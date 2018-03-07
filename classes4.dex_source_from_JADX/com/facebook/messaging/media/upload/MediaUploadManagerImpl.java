package com.facebook.messaging.media.upload;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.facebook.auth.privacy.IHaveUserData;
import com.facebook.auth.userscope.UserScoped;
import com.facebook.base.broadcast.BaseFbBroadcastManager;
import com.facebook.base.broadcast.BaseFbBroadcastManager.SelfRegistrableReceiverImpl;
import com.facebook.base.broadcast.FbBroadcastManager;
import com.facebook.base.broadcast.LocalFbBroadcastManager;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.executors.AndroidThreadUtil;
import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForNonUiThreadMethodAutoProvider;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.common.file.StatFsHelperMethodAutoProvider;
import com.facebook.common.statfs.StatFsHelper;
import com.facebook.common.statfs.StatFsHelper.StorageType;
import com.facebook.common.util.StringUtil;
import com.facebook.content.ActionReceiver;
import com.facebook.content.BroadcastReceiverLike;
import com.facebook.debug.log.BLog;
import com.facebook.fbservice.ops.BlueServiceOperationFactory;
import com.facebook.fbservice.ops.BlueServiceOperationFactory.OperationFuture;
import com.facebook.fbservice.ops.DefaultBlueServiceOperationFactory;
import com.facebook.fbservice.ops.ErrorPropagation;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.gk.store.GatekeeperStore;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.inject.ForAppContext;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.media.transcode.video.SegmentedVideoTranscodeSession;
import com.facebook.messaging.analytics.perf.MessagingPerformanceLogger;
import com.facebook.messaging.attachments.CryptoHandler;
import com.facebook.messaging.media.mediatray.MediaTrayKeyboardView.4;
import com.facebook.messaging.media.photoquality.PhotoQuality;
import com.facebook.messaging.media.photoquality.PhotoQualityHelper;
import com.facebook.messaging.media.upload.EncryptedPhotoUploadResult.Status;
import com.facebook.messaging.media.upload.MediaItemUploadStatus.Stage;
import com.facebook.messaging.media.upload.MediaItemUploadStatus.State;
import com.facebook.messaging.media.upload.MediaUploadManager.Listener;
import com.facebook.messaging.media.upload.MessageMediaUploadState.UploadState;
import com.facebook.messaging.media.upload.config.MediaUploadConfiguration;
import com.facebook.messaging.media.upload.util.MediaHashCache;
import com.facebook.messaging.media.upload.util.MediaUploadKey;
import com.facebook.messaging.model.attribution.ContentAppAttribution;
import com.facebook.messaging.model.attribution.ContentAppAttributionBuilder;
import com.facebook.messaging.model.messages.Message;
import com.facebook.messaging.model.messages.MessageBuilder;
import com.facebook.messaging.model.messages.MessageUtil;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.tools.dextr.runtime.detour.BlueServiceOperationFactoryDetour;
import com.facebook.tools.dextr.runtime.detour.FutureDetour;
import com.facebook.ui.media.attachments.MediaResource;
import com.facebook.ui.media.attachments.MediaResource$Type;
import com.facebook.ui.media.attachments.MediaResourceBuilder;
import com.facebook.ui.media.attachments.MediaResourceHelper;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Joiner;
import com.google.common.base.Preconditions;
import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.SettableFuture;
import java.util.Collections;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import javax.annotation.concurrent.NotThreadSafe;
import javax.inject.Inject;
import javax.inject.Provider;

@UserScoped
@NotThreadSafe
/* compiled from: mMessagesCounts */
public class MediaUploadManagerImpl implements IHaveUserData {
    private static final Object f8606L = new Object();
    public static final Class<?> f8607a = MediaUploadManagerImpl.class;
    private static final ImmutableSet<MediaResource$Type> f8608b = ImmutableSet.of(MediaResource$Type.PHOTO, MediaResource$Type.VIDEO, MediaResource$Type.AUDIO, MediaResource$Type.OTHER, MediaResource$Type.ENCRYPTED_PHOTO, MediaResource$Type.ENT_PHOTO, new MediaResource$Type[0]);
    private static final ImmutableSet<MediaResource$Type> f8609c = ImmutableSet.of(MediaResource$Type.PHOTO, MediaResource$Type.VIDEO, MediaResource$Type.AUDIO, MediaResource$Type.OTHER, MediaResource$Type.ENCRYPTED_PHOTO, MediaResource$Type.ENT_PHOTO, new MediaResource$Type[0]);
    private static final ImmutableSet<MediaResource$Type> f8610d = ImmutableSet.of(MediaResource$Type.PHOTO, MediaResource$Type.VIDEO, MediaResource$Type.ENCRYPTED_PHOTO, MediaResource$Type.ENT_PHOTO);
    private static final ImmutableSet<String> f8611e = ImmutableSet.of("image/gif", "image/png", "image/webp");
    public final TwoPhaseSendHandler f8612A;
    public final CryptoHandler f8613B;
    public final Context f8614C;
    public final Cache<MediaUploadKey, Double> f8615D = CacheBuilder.newBuilder().a(300, TimeUnit.SECONDS).q();
    private final SelfRegistrableReceiverImpl f8616E;
    public final Set<Listener> f8617F = Collections.newSetFromMap(Maps.e());
    private final Lazy<MediaResourceChecker> f8618G;
    private final QeAccessor f8619H;
    public final GatekeeperStoreImpl f8620I;
    public boolean f8621J;
    public boolean f8622K;
    public final DefaultBlueServiceOperationFactory f8623f;
    public final MediaHashCache f8624g;
    public final MediaResizeCache f8625h;
    private final MediaUploadCache f8626i;
    public final MediaOperationManager f8627j;
    private final MediaResourceHelper f8628k;
    private final MediaResourceSizeEstimator f8629l;
    public final DefaultAndroidThreadUtil f8630m;
    private final MessageUtil f8631n;
    public final BaseFbBroadcastManager f8632o;
    private final AbstractFbErrorReporter f8633p;
    private final MediaGetFbidAnalyticsLogger f8634q;
    public final MediaUploadManagerAnalyticsLogger f8635r;
    public final Executor f8636s;
    public final ListeningExecutorService f8637t;
    private final Provider<MediaUploadConfiguration> f8638u;
    private final SkipVideoResizeHelper f8639v;
    private final SkipUploadExperimentHelper f8640w;
    private final MessagingPerformanceLogger f8641x;
    private final StatFsHelper f8642y;
    private final PhotoQualityHelper f8643z;

    /* compiled from: mMessagesCounts */
    class C04201 implements ActionReceiver {
        final /* synthetic */ MediaUploadManagerImpl f8856a;

        C04201(MediaUploadManagerImpl mediaUploadManagerImpl) {
            this.f8856a = mediaUploadManagerImpl;
        }

        public void onReceive(Context context, Intent intent, BroadcastReceiverLike broadcastReceiverLike) {
            int a = Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_START, -1424126989);
            MediaUploadManagerImpl.m8865a(this.f8856a, intent);
            Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_END, -1567166599, a);
        }
    }

    private static MediaUploadManagerImpl m8872b(InjectorLike injectorLike) {
        return new MediaUploadManagerImpl(DefaultBlueServiceOperationFactory.a(injectorLike), MediaHashCache.m8888a(injectorLike), MediaResizeCache.m8925a(injectorLike), MediaUploadCache.m8932a(injectorLike), MediaOperationManager.m8941a(injectorLike), MediaResourceHelper.m8954a(injectorLike), MediaResourceSizeEstimator.m8987a(injectorLike), DefaultAndroidThreadUtil.a(injectorLike), MessageUtil.a(injectorLike), (BaseFbBroadcastManager) LocalFbBroadcastManager.a(injectorLike), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike), MediaGetFbidAnalyticsLogger.m9001a(injectorLike), MediaUploadManagerAnalyticsLogger.m9009a(injectorLike), (Executor) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(injectorLike), (ListeningExecutorService) ListeningScheduledExecutorService_ForNonUiThreadMethodAutoProvider.a(injectorLike), IdBasedProvider.a(injectorLike, 7945), SkipVideoResizeHelper.m9019a(injectorLike), SkipUploadExperimentHelper.m9035a(injectorLike), StatFsHelperMethodAutoProvider.a(injectorLike), MessagingPerformanceLogger.m9038a(injectorLike), PhotoQualityHelper.m9072a(injectorLike), TwoPhaseSendHandler.m9086a(injectorLike), IdBasedLazy.a(injectorLike, 7930), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike), GatekeeperStoreImplMethodAutoProvider.a(injectorLike), CryptoHandler.m9216a(injectorLike), (Context) injectorLike.getInstance(Context.class, ForAppContext.class));
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.facebook.messaging.media.upload.MediaUploadManagerImpl m8858a(com.facebook.inject.InjectorLike r7) {
        /*
        r2 = com.facebook.inject.ScopeSet.a();
        r0 = com.facebook.auth.userscope.UserScope.class;
        r0 = r7.getInstance(r0);
        r0 = (com.facebook.auth.userscope.UserScope) r0;
        r1 = r7.getScopeAwareInjector();
        r1 = r1.b();
        if (r1 != 0) goto L_0x001e;
    L_0x0016:
        r0 = new com.facebook.inject.ProvisioningException;
        r1 = "Called user scoped provider outside of context scope";
        r0.<init>(r1);
        throw r0;
    L_0x001e:
        r3 = r0.a(r1);
        r4 = r3.b();	 Catch:{ all -> 0x006c }
        r1 = f8606L;	 Catch:{ all -> 0x006c }
        r1 = r4.get(r1);	 Catch:{ all -> 0x006c }
        r5 = com.facebook.auth.userscope.UserScope.a;	 Catch:{ all -> 0x006c }
        if (r1 != r5) goto L_0x0035;
    L_0x0030:
        r3.c();
        r0 = 0;
    L_0x0034:
        return r0;
    L_0x0035:
        if (r1 != 0) goto L_0x007c;
    L_0x0037:
        r1 = 4;
        r5 = r2.b(r1);	 Catch:{  }
        r6 = r0.a(r3);	 Catch:{ all -> 0x0067 }
        r0 = r6.e();	 Catch:{ all -> 0x0062 }
        r1 = m8872b(r0);	 Catch:{ all -> 0x0062 }
        com.facebook.auth.userscope.UserScope.a(r6);	 Catch:{  }
        if (r1 != 0) goto L_0x0071;
    L_0x004d:
        r0 = f8606L;	 Catch:{  }
        r6 = com.facebook.auth.userscope.UserScope.a;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r6);	 Catch:{  }
        r0 = (com.facebook.messaging.media.upload.MediaUploadManagerImpl) r0;	 Catch:{  }
    L_0x0057:
        if (r0 == 0) goto L_0x007a;
    L_0x0059:
        r2.c(r5);	 Catch:{  }
    L_0x005c:
        r0 = (com.facebook.messaging.media.upload.MediaUploadManagerImpl) r0;	 Catch:{  }
        r3.c();
        goto L_0x0034;
    L_0x0062:
        r0 = move-exception;
        com.facebook.auth.userscope.UserScope.a(r6);	 Catch:{  }
        throw r0;	 Catch:{  }
    L_0x0067:
        r0 = move-exception;
        r2.c(r5);	 Catch:{  }
        throw r0;	 Catch:{  }
    L_0x006c:
        r0 = move-exception;
        r3.c();
        throw r0;
    L_0x0071:
        r0 = f8606L;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r1);	 Catch:{  }
        r0 = (com.facebook.messaging.media.upload.MediaUploadManagerImpl) r0;	 Catch:{  }
        goto L_0x0057;
    L_0x007a:
        r0 = r1;
        goto L_0x0059;
    L_0x007c:
        r0 = r1;
        goto L_0x005c;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.media.upload.MediaUploadManagerImpl.a(com.facebook.inject.InjectorLike):com.facebook.messaging.media.upload.MediaUploadManagerImpl");
    }

    @Inject
    public MediaUploadManagerImpl(BlueServiceOperationFactory blueServiceOperationFactory, MediaHashCache mediaHashCache, MediaResizeCache mediaResizeCache, MediaUploadCache mediaUploadCache, MediaOperationManager mediaOperationManager, MediaResourceHelper mediaResourceHelper, MediaResourceSizeEstimator mediaResourceSizeEstimator, AndroidThreadUtil androidThreadUtil, MessageUtil messageUtil, FbBroadcastManager fbBroadcastManager, FbErrorReporter fbErrorReporter, MediaGetFbidAnalyticsLogger mediaGetFbidAnalyticsLogger, MediaUploadManagerAnalyticsLogger mediaUploadManagerAnalyticsLogger, Executor executor, ListeningExecutorService listeningExecutorService, Provider<MediaUploadConfiguration> provider, SkipVideoResizeHelper skipVideoResizeHelper, SkipUploadExperimentHelper skipUploadExperimentHelper, StatFsHelper statFsHelper, MessagingPerformanceLogger messagingPerformanceLogger, PhotoQualityHelper photoQualityHelper, TwoPhaseSendHandler twoPhaseSendHandler, Lazy<MediaResourceChecker> lazy, QeAccessor qeAccessor, GatekeeperStore gatekeeperStore, CryptoHandler cryptoHandler, @ForAppContext Context context) {
        this.f8623f = blueServiceOperationFactory;
        this.f8624g = mediaHashCache;
        this.f8625h = mediaResizeCache;
        this.f8626i = mediaUploadCache;
        this.f8627j = mediaOperationManager;
        this.f8628k = mediaResourceHelper;
        this.f8629l = mediaResourceSizeEstimator;
        this.f8630m = androidThreadUtil;
        this.f8631n = messageUtil;
        this.f8632o = fbBroadcastManager;
        this.f8633p = fbErrorReporter;
        this.f8634q = mediaGetFbidAnalyticsLogger;
        this.f8635r = mediaUploadManagerAnalyticsLogger;
        this.f8636s = executor;
        this.f8637t = listeningExecutorService;
        this.f8638u = provider;
        this.f8639v = skipVideoResizeHelper;
        this.f8640w = skipUploadExperimentHelper;
        this.f8642y = statFsHelper;
        this.f8641x = messagingPerformanceLogger;
        this.f8643z = photoQualityHelper;
        this.f8612A = twoPhaseSendHandler;
        this.f8618G = lazy;
        this.f8619H = qeAccessor;
        this.f8620I = gatekeeperStore;
        this.f8613B = cryptoHandler;
        this.f8614C = context;
        C04201 c04201 = new C04201(this);
        this.f8616E = this.f8632o.a().a("com.facebook.orca.media.upload.MEDIA_RESIZE_PROGRESS", c04201).a("com.facebook.orca.media.upload.MEDIA_RESIZE_COMPLETE", c04201).a("com.facebook.orca.media.upload.MEDIA_UPLOAD_PROGRESS", c04201).a("com.facebook.orca.media.upload.MEDIA_UPLOAD_COMPLETE", c04201).a("com.facebook.orca.media.upload.MEDIA_GET_FBID_COMPLETE", c04201).a();
        this.f8616E.b();
    }

    public static void m8865a(MediaUploadManagerImpl mediaUploadManagerImpl, Intent intent) {
        double d = 1.0d;
        double d2 = 0.0d;
        MediaResource mediaResource = (MediaResource) intent.getParcelableExtra("resource");
        MediaUploadKey b = MediaUploadKey.b(mediaResource);
        String action = intent.getAction();
        if ("com.facebook.orca.media.upload.MEDIA_UPLOAD_COMPLETE".equals(action) || "com.facebook.orca.media.upload.MEDIA_GET_FBID_COMPLETE".equals(action)) {
            mediaUploadManagerImpl.f8632o.a(MediaUploadEvents.d(mediaResource));
            return;
        }
        if ("com.facebook.orca.media.upload.MEDIA_RESIZE_PROGRESS".equals(action)) {
            d = intent.getDoubleExtra("p", 0.0d);
        } else if (!"com.facebook.orca.media.upload.MEDIA_RESIZE_COMPLETE".equals(action)) {
            if ("com.facebook.orca.media.upload.MEDIA_UPLOAD_PROGRESS".equals(action)) {
                d2 = intent.getDoubleExtra("p", 0.0d);
            } else {
                d = 0.0d;
            }
        }
        double a = m8856a(mediaResource.d, mediaUploadManagerImpl.f8625h.m8929a(MediaUploadKey.a(mediaResource)), d, d2);
        mediaUploadManagerImpl.f8615D.a(b, Double.valueOf(a));
        mediaUploadManagerImpl.f8632o.a(MediaUploadEvents.a("com.facebook.orca.media.upload.PROCESS_MEDIA_TOTAL_PROGRESS", mediaResource, a));
    }

    @VisibleForTesting
    private static double m8856a(MediaResource$Type mediaResource$Type, boolean z, double d, double d2) {
        double d3;
        double d4 = 0.5d;
        if (mediaResource$Type.equals(MediaResource$Type.PHOTO) || mediaResource$Type.equals(MediaResource$Type.ENT_PHOTO)) {
            d4 = 1.0d;
            d3 = 0.0d;
        } else if (mediaResource$Type.equals(MediaResource$Type.VIDEO)) {
            if (z) {
                d3 = 0.5d;
            } else {
                d4 = 1.0d;
                d3 = 0.0d;
            }
        } else if (mediaResource$Type.equals(MediaResource$Type.AUDIO)) {
            d4 = 1.0d;
            d3 = 0.0d;
        } else if (mediaResource$Type.equals(MediaResource$Type.OTHER)) {
            d4 = 1.0d;
            d3 = 0.0d;
        } else if (mediaResource$Type.equals(MediaResource$Type.ENCRYPTED_PHOTO)) {
            d3 = 0.25d;
            d4 = 0.75d;
        } else {
            throw new IllegalArgumentException("Trying to get progress for an unsupported type");
        }
        double d5 = d2 * d4;
        return ((d * d3) + d5) / (d4 + d3);
    }

    public void clearUserData() {
        this.f8616E.c();
    }

    public final ListenableFuture<MediaItemUploadStatus> m8880a(MediaResource mediaResource) {
        Preconditions.checkArgument(f8608b.contains(mediaResource.d));
        m8876e(mediaResource);
        this.f8630m.a();
        return m8877f(mediaResource);
    }

    public final void m8881a(Message message) {
        this.f8630m.a();
        if (MessageUtil.e(message)) {
            this.f8641x.m9050a(message.n, "has_attachments");
            ImmutableList immutableList = message.t;
            int size = immutableList.size();
            for (int i = 0; i < size; i++) {
                MediaResourceBuilder a = new MediaResourceBuilder().a((MediaResource) immutableList.get(i));
                a.v = message.F;
                MediaResource C = a.C();
                m8876e(C);
                m8877f(C);
            }
        }
    }

    public final void m8884b(MediaResource mediaResource) {
        this.f8630m.a();
        this.f8627j.m8953b(mediaResource);
    }

    public final MediaItemUploadStatus m8885c(MediaResource mediaResource) {
        if (mediaResource == null) {
            return MediaItemUploadStatus.a;
        }
        if (!StringUtil.a(mediaResource.u)) {
            return MediaItemUploadStatus.a(mediaResource.u);
        }
        MediaItemUploadStatus a = this.f8626i.m8935a(MediaUploadKey.a(mediaResource));
        return a == null ? MediaItemUploadStatus.a : a;
    }

    public final MessageMediaUploadState m8883b(Message message) {
        if (!MessageUtil.e(message)) {
            return new MessageMediaUploadState(MediaItemUploadStatus.a, UploadState.NO_MEDIA_ITEMS);
        }
        ImmutableList immutableList = message.t;
        int size = immutableList.size();
        int i = 0;
        while (i < size) {
            MediaItemUploadStatus c = m8885c((MediaResource) immutableList.get(i));
            if (c.b == State.SUCCEEDED) {
                i++;
            } else if (c.b == State.NOT_ACTIVE) {
                return new MessageMediaUploadState(c, UploadState.NOT_ALL_STARTED);
            } else {
                if (c.b == State.IN_PROGRESS) {
                    return new MessageMediaUploadState(c, UploadState.IN_PROGRESS);
                }
                return new MessageMediaUploadState(c, UploadState.FAILED);
            }
        }
        return new MessageMediaUploadState(MediaItemUploadStatus.a, UploadState.SUCCEEDED);
    }

    public final boolean m8882a() {
        for (Entry entry : this.f8626i.m8936a()) {
            MediaUploadKey mediaUploadKey = (MediaUploadKey) entry.getKey();
            MediaItemUploadStatus mediaItemUploadStatus = (MediaItemUploadStatus) entry.getValue();
            if (mediaUploadKey.b == MediaResource$Type.VIDEO && mediaItemUploadStatus.b == State.IN_PROGRESS && mediaItemUploadStatus.e == Stage.RESIZING) {
                return true;
            }
        }
        return false;
    }

    public final double m8887d(@Nullable MediaResource mediaResource) {
        if (mediaResource != null) {
            Double d = (Double) this.f8615D.a(MediaUploadKey.b(mediaResource));
            if (d != null) {
                return d.doubleValue();
            }
        }
        return 0.0d;
    }

    public final Message m8886c(Message message) {
        if (message.t == null || message.t.isEmpty()) {
            return message;
        }
        ContentAppAttribution contentAppAttribution = message.F;
        Builder builder = ImmutableList.builder();
        ImmutableList immutableList = message.t;
        int size = immutableList.size();
        for (int i = 0; i < size; i++) {
            Object obj = (MediaResource) immutableList.get(i);
            MediaItemUploadStatus c = m8885c((MediaResource) obj);
            if (c.b == State.SUCCEEDED) {
                MediaResource mediaResource;
                ContentAppAttribution contentAppAttribution2;
                MediaResource a = this.f8625h.m8926a((MediaResource) obj);
                if (a != null) {
                    mediaResource = a;
                }
                MediaResourceBuilder a2 = MediaResource.a().a(mediaResource);
                a2.s = c.c;
                a = a2.C();
                if (contentAppAttribution != null || a.x == null) {
                    contentAppAttribution2 = contentAppAttribution;
                } else {
                    contentAppAttribution2 = a.x;
                }
                contentAppAttribution = contentAppAttribution2;
                obj = a;
            } else if (c.b != State.FAILED) {
                this.f8633p.a("MESSENGER_MEDIA_UPLOAD_NOT_FINISHED", "Media upload state is: " + c.b.toString());
            }
            builder.c(obj);
        }
        ImmutableList b = builder.b();
        MessageBuilder a3 = Message.newBuilder().a(message);
        a3.F = m8859a(contentAppAttribution, b);
        a3 = a3;
        a3.r = b;
        return a3.R();
    }

    @Nullable
    private static ContentAppAttribution m8859a(ContentAppAttribution contentAppAttribution, ImmutableList<MediaResource> immutableList) {
        if (contentAppAttribution == null) {
            return null;
        }
        if (immutableList.size() != 1) {
            BLog.b(f8607a, "Messages with content attribution should have only one MediaResource: %s", new Object[]{immutableList});
            return null;
        }
        ContentAppAttributionBuilder a = ContentAppAttribution.newBuilder().a(contentAppAttribution);
        a.a = ((MediaResource) immutableList.get(0)).u;
        return a.i();
    }

    private void m8876e(MediaResource mediaResource) {
        if (!MediaResourceHelper.m8955a(mediaResource)) {
            List a = Lists.a();
            if (mediaResource.o == null) {
                a.add("mime-type");
            }
            switch (15.a[mediaResource.d.ordinal()]) {
                case 1:
                    if (mediaResource.j == 0 || mediaResource.k == 0) {
                        a.add("size");
                        break;
                    }
                case 2:
                    if (mediaResource.i <= 0) {
                        a.add("duration");
                        break;
                    }
                    break;
            }
            if (!a.isEmpty()) {
                this.f8633p.a("MediaUploadManager_missing_metadata", "Missing: " + Joiner.on(",").join(a));
            }
        }
    }

    private ListenableFuture<MediaItemUploadStatus> m8877f(MediaResource mediaResource) {
        MediaResource b;
        boolean z;
        MediaItemUploadStatus c;
        SettableFuture f;
        boolean contains;
        boolean z2;
        PhotoQuality b2;
        PhotoQuality photoQuality;
        PhotoQuality photoQuality2;
        ListenableFuture b3;
        int i = 1;
        Preconditions.checkArgument(f8608b.contains(mediaResource.d));
        this.f8635r.m9013a(mediaResource);
        boolean a = this.f8612A.m9093a(mediaResource);
        if (a) {
            b = this.f8625h.m8930b(mediaResource);
        } else {
            b = null;
        }
        if (b == null) {
            b = this.f8625h.m8926a(mediaResource);
        }
        PhotoQuality a2 = this.f8643z.m9076a(mediaResource.n);
        if (mediaResource.d == MediaResource$Type.PHOTO && b != null) {
            int i2 = a2.b;
            if (i2 > b.k && i2 > b.j && (mediaResource.k > b.k || mediaResource.j > b.j)) {
                z = false;
                c = m8885c(mediaResource);
                if (c != null && z) {
                    this.f8627j.m8950a(mediaResource);
                    if (c.b != State.SUCCEEDED) {
                        this.f8635r.m9014a(mediaResource, UploadResultPath.SKIPPED_FROM_CACHE.toString());
                        Uri uri = mediaResource.c;
                        this.f8624g.m8892a(mediaResource);
                        String str = c.c;
                        return Futures.a(c);
                    } else if (c.b == State.IN_PROGRESS) {
                        this.f8635r.m9017c(mediaResource, UploadResultPath.SKIPPED_FROM_CACHE.toString(), c.e.toString());
                        return c.d;
                    }
                }
                f = SettableFuture.f();
                m8867a(mediaResource, MediaItemUploadStatus.a(Stage.STARTED, f));
                if (f8609c.contains(mediaResource.d)) {
                    m8870a(this, f, mediaResource, null, UploadResultPath.NOT_REQUIRED);
                    return f;
                }
                if (this.f8640w.m9037a(mediaResource)) {
                    m8868a(f, mediaResource);
                }
                contains = f8610d.contains(mediaResource.d);
                if (f8611e.contains(mediaResource.o)) {
                    z2 = false;
                    contains = false;
                } else if (mediaResource.d != MediaResource$Type.PHOTO && PhotoQualityHelper.m9073a(mediaResource) && this.f8643z.m9078b()) {
                    z2 = true;
                    contains = false;
                } else {
                    z2 = false;
                }
                if (a && mediaResource.n != null && contains) {
                    int i3 = 960;
                    if (a2.b > i3 && Math.max(mediaResource.j, mediaResource.k) > i3) {
                        b2 = this.f8643z.m9077b(mediaResource.n);
                        if (b2.b < a2.b) {
                            photoQuality = a2;
                            photoQuality2 = b2;
                            if (this.f8620I.a(1032, false) || mediaResource.d != MediaResource$Type.VIDEO || !SegmentedVideoTranscodeSession.a((long) mediaResource.b()) || MediaResourceHelper.m8959c(mediaResource)) {
                                b3 = Futures.b(m8862a(mediaResource, m8864a(mediaResource, contains, z, photoQuality2, 1)), new 2(this, mediaResource, z2), this.f8636s);
                            } else {
                                b3 = m8878j(mediaResource);
                            }
                            Futures.a(b3, new 3(this, mediaResource, f), this.f8636s);
                            if (!a || photoQuality == null) {
                                i = 0;
                            }
                            if (i != 0) {
                                Futures.a(Futures.b(b3, new 4(this, m8864a(mediaResource, contains, z, photoQuality, 2), mediaResource), this.f8637t), new 5(this, mediaResource), this.f8637t);
                            }
                            return f;
                        }
                    }
                }
                photoQuality = null;
                photoQuality2 = a2;
                if (this.f8620I.a(1032, false)) {
                }
                b3 = Futures.b(m8862a(mediaResource, m8864a(mediaResource, contains, z, photoQuality2, 1)), new 2(this, mediaResource, z2), this.f8636s);
                Futures.a(b3, new 3(this, mediaResource, f), this.f8636s);
                i = 0;
                if (i != 0) {
                    Futures.a(Futures.b(b3, new 4(this, m8864a(mediaResource, contains, z, photoQuality, 2), mediaResource), this.f8637t), new 5(this, mediaResource), this.f8637t);
                }
                return f;
            }
        }
        z = true;
        c = m8885c(mediaResource);
        this.f8627j.m8950a(mediaResource);
        if (c.b != State.SUCCEEDED) {
            if (c.b == State.IN_PROGRESS) {
                this.f8635r.m9017c(mediaResource, UploadResultPath.SKIPPED_FROM_CACHE.toString(), c.e.toString());
                return c.d;
            }
            f = SettableFuture.f();
            m8867a(mediaResource, MediaItemUploadStatus.a(Stage.STARTED, f));
            if (f8609c.contains(mediaResource.d)) {
                if (this.f8640w.m9037a(mediaResource)) {
                    m8868a(f, mediaResource);
                }
                contains = f8610d.contains(mediaResource.d);
                if (f8611e.contains(mediaResource.o)) {
                    z2 = false;
                    contains = false;
                } else {
                    if (mediaResource.d != MediaResource$Type.PHOTO) {
                    }
                    z2 = false;
                }
                int i32 = 960;
                b2 = this.f8643z.m9077b(mediaResource.n);
                if (b2.b < a2.b) {
                    photoQuality = a2;
                    photoQuality2 = b2;
                    if (this.f8620I.a(1032, false)) {
                    }
                    b3 = Futures.b(m8862a(mediaResource, m8864a(mediaResource, contains, z, photoQuality2, 1)), new 2(this, mediaResource, z2), this.f8636s);
                    Futures.a(b3, new 3(this, mediaResource, f), this.f8636s);
                    i = 0;
                    if (i != 0) {
                        Futures.a(Futures.b(b3, new 4(this, m8864a(mediaResource, contains, z, photoQuality, 2), mediaResource), this.f8637t), new 5(this, mediaResource), this.f8637t);
                    }
                    return f;
                }
                photoQuality = null;
                photoQuality2 = a2;
                if (this.f8620I.a(1032, false)) {
                }
                b3 = Futures.b(m8862a(mediaResource, m8864a(mediaResource, contains, z, photoQuality2, 1)), new 2(this, mediaResource, z2), this.f8636s);
                Futures.a(b3, new 3(this, mediaResource, f), this.f8636s);
                i = 0;
                if (i != 0) {
                    Futures.a(Futures.b(b3, new 4(this, m8864a(mediaResource, contains, z, photoQuality, 2), mediaResource), this.f8637t), new 5(this, mediaResource), this.f8637t);
                }
                return f;
            }
            m8870a(this, f, mediaResource, null, UploadResultPath.NOT_REQUIRED);
            return f;
        }
        this.f8635r.m9014a(mediaResource, UploadResultPath.SKIPPED_FROM_CACHE.toString());
        Uri uri2 = mediaResource.c;
        this.f8624g.m8892a(mediaResource);
        String str2 = c.c;
        return Futures.a(c);
    }

    private ListenableFuture<Uri> m8862a(MediaResource mediaResource, ListenableFuture<Void> listenableFuture) {
        return Futures.b(listenableFuture, new 7(this, mediaResource), this.f8636s);
    }

    public static boolean m8870a(MediaUploadManagerImpl mediaUploadManagerImpl, SettableFuture settableFuture, MediaResource mediaResource, String str, UploadResultPath uploadResultPath) {
        if (mediaResource.d == MediaResource$Type.ENCRYPTED_PHOTO) {
            Intent intent = new Intent("EncryptedPhotoUploadStatusAction");
            intent.putExtra("EncryptedPhotoUploadStatusKey", new EncryptedPhotoUploadResult(mediaResource.m, mediaResource.c, Status.Success, str));
            mediaUploadManagerImpl.f8632o.a(intent);
        }
        MediaItemUploadStatus a = MediaItemUploadStatus.a(str);
        if (mediaUploadManagerImpl.m8874b(mediaResource, a)) {
            mediaUploadManagerImpl.f8635r.m9014a(mediaResource, uploadResultPath.toString());
            mediaUploadManagerImpl.f8632o.a(MediaUploadEvents.a());
            FutureDetour.a(settableFuture, a, 1405973567);
            return true;
        }
        a = mediaUploadManagerImpl.m8885c(mediaResource);
        mediaUploadManagerImpl.f8624g.m8892a(mediaResource);
        String str2 = a.c;
        mediaUploadManagerImpl.f8634q.m9008a(mediaResource, a.c, str, uploadResultPath.toString());
        return false;
    }

    private void m8868a(SettableFuture<MediaItemUploadStatus> settableFuture, MediaResource mediaResource) {
        Bundle bundle = new Bundle();
        bundle.putParcelable("mediaResource", mediaResource);
        OperationFuture a = BlueServiceOperationFactoryDetour.a(this.f8623f, "media_get_fbid", bundle, ErrorPropagation.BY_EXCEPTION, CallerContext.a(f8607a, "media_dedupe"), 769687346).a();
        this.f8627j.m8951a(mediaResource, a);
        Futures.a(Futures.a(a, new 10(this), this.f8636s), new 9(this, mediaResource, settableFuture), this.f8636s);
    }

    private ListenableFuture<Void> m8864a(MediaResource mediaResource, boolean z, boolean z2, PhotoQuality photoQuality, int i) {
        if (!z) {
            return Futures.a(null);
        }
        if (z2) {
            MediaResource b;
            if (i == 2) {
                b = this.f8625h.m8930b(mediaResource);
            } else {
                b = this.f8625h.m8926a(mediaResource);
            }
            if (b != null) {
                if (this.f8619H.a(ExperimentsForMediaUploadModule.b, true)) {
                    return Futures.b(((MediaResourceChecker) this.f8618G.get()).a(b), new 11(this, mediaResource, i, photoQuality), this.f8636s);
                }
                return Futures.a(null);
            }
        }
        return m8860a(this, mediaResource, photoQuality, i);
    }

    public static ListenableFuture m8860a(MediaUploadManagerImpl mediaUploadManagerImpl, MediaResource mediaResource, PhotoQuality photoQuality, int i) {
        int i2;
        boolean z;
        String str;
        if (mediaResource.d == MediaResource$Type.VIDEO) {
            int a = mediaUploadManagerImpl.f8629l.m8989a(mediaResource);
            boolean a2 = mediaUploadManagerImpl.m8869a(a);
            if (!mediaUploadManagerImpl.m8871a(mediaResource, a, a2)) {
                return Futures.a(null);
            }
            i2 = a;
            z = a2;
        } else {
            z = false;
            i2 = 0;
        }
        m8866a(mediaUploadManagerImpl, mediaResource, Stage.RESIZING);
        Bundle bundle = new Bundle();
        bundle.putParcelable("mediaResource", mediaResource);
        if (mediaResource.d == MediaResource$Type.VIDEO) {
            bundle.putBoolean("transcode", ((MediaUploadConfiguration) mediaUploadManagerImpl.f8638u.get()).a);
            bundle.putBoolean("isOutOfSpace", z);
            bundle.putInt("estimatedBytes", i2);
            str = "video_resize";
        } else {
            bundle.putParcelable("photoQuality", photoQuality);
            bundle.putInt("phase", i);
            str = "photo_resize";
        }
        OperationFuture a3 = BlueServiceOperationFactoryDetour.a(mediaUploadManagerImpl.f8623f, str, bundle, ErrorPropagation.BY_EXCEPTION, CallerContext.a(f8607a, "media_resize"), 1627966105).a();
        mediaUploadManagerImpl.f8627j.m8951a(mediaResource, a3);
        return Futures.a(a3, new 12(mediaUploadManagerImpl, i, mediaResource), mediaUploadManagerImpl.f8636s);
    }

    private ListenableFuture<String> m8878j(MediaResource mediaResource) {
        Preconditions.checkArgument(mediaResource.d == MediaResource$Type.VIDEO);
        int a = this.f8629l.m8989a(mediaResource);
        boolean a2 = m8869a(a);
        if (!m8871a(mediaResource, a, a2)) {
            return m8861a(this, mediaResource, mediaResource, true);
        }
        m8866a(this, mediaResource, Stage.STARTED);
        m8866a(this, mediaResource, Stage.RESIZING);
        Bundle bundle = new Bundle();
        bundle.putParcelable("mediaResource", mediaResource);
        bundle.putBoolean("transcode", ((MediaUploadConfiguration) this.f8638u.get()).a);
        bundle.putBoolean("isOutOfSpace", a2);
        bundle.putInt("estimatedBytes", a);
        OperationFuture a3 = BlueServiceOperationFactoryDetour.a(this.f8623f, "video_segment_transcode_upload", bundle, ErrorPropagation.BY_EXCEPTION, CallerContext.a(f8607a, "video_transcode_upload"), 2070755226).a();
        this.f8627j.m8951a(mediaResource, a3);
        return Futures.a(a3, new 13(this), this.f8636s);
    }

    public static MediaResource m8879k(MediaUploadManagerImpl mediaUploadManagerImpl, MediaResource mediaResource) {
        if (f8610d.contains(mediaResource.d)) {
            MediaResource a = mediaUploadManagerImpl.f8625h.m8926a(mediaResource);
            if (a != null) {
                mediaResource = a;
            }
        }
        Preconditions.checkNotNull(mediaResource);
        return mediaResource;
    }

    public static ListenableFuture m8861a(MediaUploadManagerImpl mediaUploadManagerImpl, MediaResource mediaResource, MediaResource mediaResource2, boolean z) {
        m8866a(mediaUploadManagerImpl, mediaResource, Stage.UPLOADING);
        Bundle bundle = new Bundle();
        bundle.putParcelable("mediaResource", mediaResource2);
        bundle.putBoolean("fullQualityImageUpload", z);
        boolean z2 = false;
        String str = "media_upload";
        if (mediaResource.d == MediaResource$Type.PHOTO && mediaUploadManagerImpl.f8620I.a(260, false)) {
            str = mediaUploadManagerImpl.f8622K ? "photo_upload_parallel" : "photo_upload";
            if (!mediaUploadManagerImpl.f8622K) {
                z2 = true;
            }
            mediaUploadManagerImpl.f8622K = z2;
        }
        return mediaUploadManagerImpl.m8863a(mediaResource, str, bundle);
    }

    public static ListenableFuture m8873b(MediaUploadManagerImpl mediaUploadManagerImpl, MediaResource mediaResource, String str) {
        MediaResource b = mediaUploadManagerImpl.f8625h.m8930b(mediaResource);
        if (b == null) {
            return Futures.a(null);
        }
        if (!mediaUploadManagerImpl.f8612A.m9094b(mediaResource)) {
            return Futures.a(null);
        }
        Bundle bundle = new Bundle();
        bundle.putParcelable("mediaResource", b);
        bundle.putBoolean("fullQualityImageUpload", false);
        bundle.putString("originalFbid", str);
        boolean z = false;
        String str2 = "photo_upload_hires";
        if (mediaUploadManagerImpl.f8620I.a(260, false)) {
            str2 = mediaUploadManagerImpl.f8621J ? "photo_upload_hires_parallel" : "photo_upload_hires";
            if (!mediaUploadManagerImpl.f8621J) {
                z = true;
            }
            mediaUploadManagerImpl.f8621J = z;
        }
        return mediaUploadManagerImpl.m8863a(mediaResource, str2, bundle);
    }

    private ListenableFuture<String> m8863a(MediaResource mediaResource, String str, Bundle bundle) {
        OperationFuture a = BlueServiceOperationFactoryDetour.a(this.f8623f, str, bundle, ErrorPropagation.BY_EXCEPTION, CallerContext.a(f8607a, "media_upload"), -1939295133).a();
        this.f8627j.m8951a(mediaResource, a);
        return Futures.a(a, new 14(this), this.f8636s);
    }

    private boolean m8869a(int i) {
        if (i <= 0) {
            return false;
        }
        if (this.f8642y.a(StorageType.EXTERNAL) <= 0 && this.f8642y.a(StorageType.INTERNAL) <= 0) {
            return false;
        }
        if (this.f8642y.a(StorageType.EXTERNAL, (long) i) || this.f8642y.a(StorageType.INTERNAL, (long) i)) {
            return true;
        }
        return false;
    }

    private boolean m8871a(MediaResource mediaResource, int i, boolean z) {
        boolean z2 = (z || this.f8639v.m9023a(mediaResource, i, ((MediaUploadConfiguration) this.f8638u.get()).a)) ? false : true;
        if (mediaResource.c != null) {
            mediaResource.c.getEncodedPath();
        }
        if (!z2) {
            this.f8625h.m8927a(mediaResource, null);
        }
        Long.valueOf(mediaResource.p);
        Integer.valueOf(i);
        mediaResource.e.name();
        return z2;
    }

    private void m8867a(MediaResource mediaResource, MediaItemUploadStatus mediaItemUploadStatus) {
        this.f8630m.a();
        this.f8626i.m8937a(MediaUploadKey.a(mediaResource), mediaItemUploadStatus);
        m8875d();
    }

    private boolean m8874b(MediaResource mediaResource, MediaItemUploadStatus mediaItemUploadStatus) {
        this.f8630m.a();
        if (!this.f8626i.m8939b(MediaUploadKey.a(mediaResource), mediaItemUploadStatus)) {
            return false;
        }
        m8875d();
        return true;
    }

    public static void m8866a(MediaUploadManagerImpl mediaUploadManagerImpl, MediaResource mediaResource, Stage stage) {
        mediaUploadManagerImpl.f8630m.a();
        MediaUploadKey a = MediaUploadKey.a(mediaResource);
        MediaItemUploadStatus a2 = mediaUploadManagerImpl.f8626i.m8935a(a);
        if (a2 == null) {
            mediaUploadManagerImpl.f8633p.a("MediaUploadManagerImpl_MISSING_UPLOAD_STATUS", "Missing status for in progress media resource");
            return;
        }
        mediaUploadManagerImpl.f8626i.m8937a(a, MediaItemUploadStatus.a(stage, a2.d));
        mediaUploadManagerImpl.m8875d();
    }

    public static MediaItemUploadStatus m8857a(MediaUploadManagerImpl mediaUploadManagerImpl, MediaResource mediaResource, Throwable th) {
        mediaUploadManagerImpl.f8630m.a();
        MediaUploadKey a = MediaUploadKey.a(mediaResource);
        MediaItemUploadStatus a2 = mediaUploadManagerImpl.f8626i.m8935a(a);
        if (a2 == null) {
            mediaUploadManagerImpl.f8633p.a("MediaUploadManagerImpl_MISSING_UPLOAD_STATUS", "Missing status for failed media resource");
            a2 = MediaItemUploadStatus.a(Stage.UNKNOWN, th);
        } else {
            a2 = MediaItemUploadStatus.a(a2.e, th);
        }
        mediaUploadManagerImpl.f8626i.m8937a(a, a2);
        mediaUploadManagerImpl.m8875d();
        return a2;
    }

    private void m8875d() {
        this.f8630m.a();
        for (4 a : this.f8617F) {
            a.a();
        }
    }
}
