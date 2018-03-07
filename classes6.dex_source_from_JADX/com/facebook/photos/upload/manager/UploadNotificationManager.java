package com.facebook.photos.upload.manager;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat.Builder;
import android.util.Log;
import com.facebook.auth.annotations.LoggedInUserId;
import com.facebook.auth.module.String_LoggedInUserIdMethodAutoProvider;
import com.facebook.common.android.NotificationManagerMethodAutoProvider;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.fblinks.FBLinks;
import com.facebook.common.network.FbNetworkManager;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.common.util.StringUtil;
import com.facebook.common.util.TriState;
import com.facebook.composer.publish.cache.pendingstory.PendingStoryStore;
import com.facebook.composer.publish.optimistic.ComposerActivityBroadcaster;
import com.facebook.compost.abtest.ExperimentsForCompostAbTestModule;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.content.SecurePendingIntent;
import com.facebook.content.event.FbEvent;
import com.facebook.debug.log.BLog;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.intent.feed.DefaultFeedIntentBuilder;
import com.facebook.intent.feed.IFeedIntentBuilder;
import com.facebook.ipc.composer.model.ComposerSourceSurface;
import com.facebook.ipc.composer.model.ComposerSourceType;
import com.facebook.photos.intent.PhotosViewIntentBuilder;
import com.facebook.photos.intent.PhotosViewIntentProvider;
import com.facebook.photos.upload.dialog.UploadDialogsIntentBuilder;
import com.facebook.photos.upload.event.BaseMediaUploadEvent;
import com.facebook.photos.upload.event.BaseMediaUploadEvent$Status;
import com.facebook.photos.upload.event.MediaServerProcessingEvent;
import com.facebook.photos.upload.event.MediaUploadEventBus;
import com.facebook.photos.upload.event.MediaUploadEventSubscriber;
import com.facebook.photos.upload.event.MediaUploadFailedEvent;
import com.facebook.photos.upload.event.MediaUploadSuccessEvent;
import com.facebook.photos.upload.event.MultiPhotoUploadProgressEvent;
import com.facebook.photos.upload.event.VideoUploadProgressEvent;
import com.facebook.photos.upload.event.VideoUploadSlowEvent;
import com.facebook.photos.upload.intent.VideoUploadSuccessIntent;
import com.facebook.photos.upload.intent.VideoUploadSuccessIntentImpl;
import com.facebook.photos.upload.module.UploadNotificationConfigurationMethodAutoProvider;
import com.facebook.photos.upload.operation.UploadOperation;
import com.facebook.photos.upload.operation.UploadOperation.PublishMethod;
import com.facebook.photos.upload.operation.UploadOperation.Type;
import com.facebook.photos.upload.progresspage.CompostActivity;
import com.facebook.photos.upload.progresspage.CompostSourceType;
import com.facebook.photos.upload.protocol.UploadServerResponse;
import com.facebook.photos.upload.protocol.UploadServerResponse.ResponseType;
import com.facebook.photos.upload.service.PhotosUploadHelperService;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.google.common.base.Preconditions;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: graph_search_native_url */
public class UploadNotificationManager {
    private static volatile UploadNotificationManager f13656y;
    private final boolean f13657a = Log.isLoggable("MediaUpload", 3);
    public final Context f13658b;
    private final NotificationManager f13659c;
    private final MediaUploadEventBus f13660d;
    public final PhotosViewIntentProvider f13661e;
    public final DefaultUploadNotificationConfiguration f13662f;
    private final Provider<TriState> f13663g;
    public final VideoUploadSuccessIntentImpl f13664h;
    public final SecureContextHelper f13665i;
    private final AbstractFbErrorReporter f13666j;
    @LoggedInUserId
    public final String f13667k;
    private final MultiPhotoUploadBusSubscriber f13668l = new MultiPhotoUploadBusSubscriber(this);
    private final VideoUploadBusSubscriber f13669m = new VideoUploadBusSubscriber(this);
    private final SlowMediaUploadBusSubscriber f13670n = new SlowMediaUploadBusSubscriber(this);
    public final NotificationHelper f13671o = new NotificationHelper(this);
    public final PendingIntent f13672p;
    private final ComposerActivityBroadcaster f13673q;
    public IFeedIntentBuilder f13674r;
    private final QeAccessor f13675s;
    private final Clock f13676t;
    private final FbNetworkManager f13677u;
    private final PendingStoryStore f13678v;
    public boolean f13679w = true;
    @GuardedBy("itself")
    public Builder f13680x;

    /* compiled from: graph_search_native_url */
    class MultiPhotoUploadBusSubscriber extends MediaUploadEventSubscriber<MultiPhotoUploadProgressEvent> {
        final /* synthetic */ UploadNotificationManager f13652a;

        public MultiPhotoUploadBusSubscriber(UploadNotificationManager uploadNotificationManager) {
            this.f13652a = uploadNotificationManager;
        }

        public final void m21391b(FbEvent fbEvent) {
            MultiPhotoUploadProgressEvent multiPhotoUploadProgressEvent = (MultiPhotoUploadProgressEvent) fbEvent;
            if (multiPhotoUploadProgressEvent.b == BaseMediaUploadEvent$Status.UPLOADING || multiPhotoUploadProgressEvent.b == BaseMediaUploadEvent$Status.PUBLISHING) {
                int size;
                int i;
                UploadOperation uploadOperation = multiPhotoUploadProgressEvent.a;
                if (uploadOperation.m21521Z()) {
                    size = uploadOperation.f13778a.size();
                } else {
                    size = multiPhotoUploadProgressEvent.b;
                }
                if (uploadOperation.m21521Z()) {
                    i = (multiPhotoUploadProgressEvent.a * 100) / size;
                } else {
                    i = multiPhotoUploadProgressEvent.c;
                }
                UploadNotificationManager.m21403a(this.f13652a, uploadOperation, this.f13652a.f13671o.m21393a(multiPhotoUploadProgressEvent, i, UploadNotificationManager.m21401a(this.f13652a, this.f13652a.f13662f.mo1130a(this.f13652a.f13658b, multiPhotoUploadProgressEvent.a, size), uploadOperation), UploadNotificationManager.m21409g(this.f13652a, uploadOperation)));
                if (uploadOperation.m21521Z()) {
                    UploadNotificationManager.m21402a(this.f13652a, uploadOperation, i * 10);
                }
            }
        }

        public final Class<MultiPhotoUploadProgressEvent> m21390a() {
            return MultiPhotoUploadProgressEvent.class;
        }
    }

    /* compiled from: graph_search_native_url */
    class NotificationHelper {
        final /* synthetic */ UploadNotificationManager f13653a;

        public NotificationHelper(UploadNotificationManager uploadNotificationManager) {
            this.f13653a = uploadNotificationManager;
        }

        public final Notification m21393a(BaseMediaUploadEvent baseMediaUploadEvent, int i, String str, PendingIntent pendingIntent) {
            UploadOperation a = baseMediaUploadEvent.a();
            CharSequence a2 = this.f13653a.f13662f.mo1132a(this.f13653a.f13658b, a, Boolean.valueOf(baseMediaUploadEvent.b() == BaseMediaUploadEvent$Status.PROCESSING));
            String d = this.f13653a.f13662f.mo1137d(this.f13653a.f13658b);
            if (UploadNotificationManager.m21408f(a) || UploadNotificationManager.m21414n(this.f13653a, a)) {
                d = "";
            }
            if (baseMediaUploadEvent.b() == BaseMediaUploadEvent$Status.PUBLISHING) {
                return m21392a(pendingIntent, a2, str, d, 0, true, a);
            }
            if (i > 0) {
                return m21392a(pendingIntent, a2, str, d, i, false, a);
            }
            Notification c;
            synchronized (this.f13653a.f13680x) {
                Builder a3 = this.f13653a.f13680x.a(pendingIntent);
                boolean z = this.f13653a.f13679w && !UploadNotificationManager.m21414n(this.f13653a, a);
                a3.a(z).a(this.f13653a.f13662f.m21347a()).a(a2).b(str);
                c = this.f13653a.f13680x.c();
            }
            return c;
        }

        private Notification m21392a(PendingIntent pendingIntent, String str, String str2, String str3, int i, boolean z, UploadOperation uploadOperation) {
            Notification c;
            synchronized (this.f13653a.f13680x) {
                this.f13653a.f13680x.a(100, i, z);
                c = this.f13653a.f13680x.a(pendingIntent).a(str).b(str2).d(str3).a(this.f13653a.f13662f.m21347a()).a(!UploadNotificationManager.m21414n(this.f13653a, uploadOperation)).c();
            }
            return c;
        }
    }

    /* compiled from: graph_search_native_url */
    class SlowMediaUploadBusSubscriber extends MediaUploadEventSubscriber<VideoUploadSlowEvent> {
        final /* synthetic */ UploadNotificationManager f13654a;

        public SlowMediaUploadBusSubscriber(UploadNotificationManager uploadNotificationManager) {
            this.f13654a = uploadNotificationManager;
        }

        public final void m21395b(FbEvent fbEvent) {
            VideoUploadSlowEvent videoUploadSlowEvent = (VideoUploadSlowEvent) fbEvent;
            UploadDialogsIntentBuilder uploadDialogsIntentBuilder = new UploadDialogsIntentBuilder(this.f13654a.f13658b);
            uploadDialogsIntentBuilder.f13605b = "too_slow_request";
            uploadDialogsIntentBuilder = uploadDialogsIntentBuilder;
            uploadDialogsIntentBuilder.f13606c = videoUploadSlowEvent.a;
            uploadDialogsIntentBuilder = uploadDialogsIntentBuilder;
            uploadDialogsIntentBuilder.f13608e = Long.valueOf(videoUploadSlowEvent.f13621a);
            Intent a = uploadDialogsIntentBuilder.m21310a();
            a.setFlags(268435456);
            this.f13654a.f13665i.a(a, this.f13654a.f13658b);
        }

        public final Class<VideoUploadSlowEvent> m21394a() {
            return VideoUploadSlowEvent.class;
        }
    }

    /* compiled from: graph_search_native_url */
    class VideoUploadBusSubscriber extends MediaUploadEventSubscriber<VideoUploadProgressEvent> {
        final /* synthetic */ UploadNotificationManager f13655a;

        public VideoUploadBusSubscriber(UploadNotificationManager uploadNotificationManager) {
            this.f13655a = uploadNotificationManager;
        }

        public final void m21397b(FbEvent fbEvent) {
            VideoUploadProgressEvent videoUploadProgressEvent = (VideoUploadProgressEvent) fbEvent;
            UploadOperation uploadOperation = videoUploadProgressEvent.a;
            int i;
            if (uploadOperation.m21521Z()) {
                i = uploadOperation.f13764M;
                int i2 = uploadOperation.f13765N;
                if (videoUploadProgressEvent.b != BaseMediaUploadEvent$Status.PROCESSING) {
                    int i3 = ((i * 100) + videoUploadProgressEvent.c) / i2;
                    UploadNotificationManager.m21403a(this.f13655a, uploadOperation, this.f13655a.f13671o.m21393a(videoUploadProgressEvent, i3, UploadNotificationManager.m21401a(this.f13655a, this.f13655a.f13662f.mo1130a(this.f13655a.f13658b, i + 1, i2), uploadOperation), UploadNotificationManager.m21409g(this.f13655a, uploadOperation)));
                    UploadNotificationManager.m21402a(this.f13655a, uploadOperation, i3 * 10);
                    return;
                }
                return;
            }
            i = uploadOperation.f13772U + (((100 - uploadOperation.f13772U) * uploadOperation.f13773V) / 100);
            if (!uploadOperation.f13777Z) {
                NotificationHelper notificationHelper = this.f13655a.f13671o;
                UploadNotificationManager uploadNotificationManager = this.f13655a;
                String str = uploadOperation.f13781d;
                if (StringUtil.a(str)) {
                    str = null;
                } else {
                    StringBuilder stringBuilder = new StringBuilder(str.length());
                    UploadNotificationManager.m21404a(str, stringBuilder);
                    str = stringBuilder.toString();
                }
                UploadNotificationManager.m21403a(this.f13655a, uploadOperation, notificationHelper.m21393a(videoUploadProgressEvent, i, str, UploadNotificationManager.m21409g(this.f13655a, uploadOperation)));
            }
            BaseMediaUploadEvent$Status baseMediaUploadEvent$Status = videoUploadProgressEvent.b;
            if (baseMediaUploadEvent$Status == BaseMediaUploadEvent$Status.UPLOADING || baseMediaUploadEvent$Status == BaseMediaUploadEvent$Status.PROCESSING) {
                UploadNotificationManager.m21402a(this.f13655a, uploadOperation, i * 10);
            }
        }

        public final Class<VideoUploadProgressEvent> m21396a() {
            return VideoUploadProgressEvent.class;
        }
    }

    public static com.facebook.photos.upload.manager.UploadNotificationManager m21400a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find immediate dominator for block B:24:0x003b in {17, 19, 21, 23, 26, 28} preds:[]
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.computeDominators(BlockProcessor.java:129)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.processBlocksTree(BlockProcessor.java:48)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.rerun(BlockProcessor.java:44)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.visit(BlockFinallyExtract.java:57)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r0 = f13656y;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.photos.upload.manager.UploadNotificationManager.class;
        monitor-enter(r1);
        r0 = f13656y;	 Catch:{ all -> 0x003a }
        if (r0 != 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000b:
        if (r5 == 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000d:
        r2 = com.facebook.inject.ScopeSet.a();	 Catch:{ all -> 0x003a }
        r3 = r2.b();	 Catch:{ all -> 0x003a }
        r0 = com.facebook.inject.SingletonScope.class;	 Catch:{ all -> 0x003a }
        r0 = r5.getInstance(r0);	 Catch:{ all -> 0x003a }
        r0 = (com.facebook.inject.SingletonScope) r0;	 Catch:{ all -> 0x003a }
        r4 = r0.enterScope();	 Catch:{ all -> 0x003a }
        r0 = r5.getApplicationInjector();	 Catch:{ all -> 0x0035 }
        r0 = m21406b(r0);	 Catch:{ all -> 0x0035 }
        f13656y = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f13656y;
        return r0;
    L_0x0035:
        r0 = move-exception;
        com.facebook.inject.SingletonScope.a(r4);	 Catch:{ all -> 0x0035 }
        throw r0;	 Catch:{ all -> 0x0035 }
    L_0x003a:
        r0 = move-exception;
        r2.c(r3);	 Catch:{ all -> 0x003a }
        throw r0;	 Catch:{ all -> 0x003a }
    L_0x003f:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x003a }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.photos.upload.manager.UploadNotificationManager.a(com.facebook.inject.InjectorLike):com.facebook.photos.upload.manager.UploadNotificationManager");
    }

    private static UploadNotificationManager m21406b(InjectorLike injectorLike) {
        return new UploadNotificationManager((Context) injectorLike.getInstance(Context.class), NotificationManagerMethodAutoProvider.a(injectorLike), MediaUploadEventBus.a(injectorLike), PhotosViewIntentProvider.m20407a(injectorLike), UploadNotificationConfigurationMethodAutoProvider.m21436a(injectorLike), IdBasedProvider.a(injectorLike, 731), VideoUploadSuccessIntentImpl.m21343a(injectorLike), (SecureContextHelper) DefaultSecureContextHelper.a(injectorLike), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike), ComposerActivityBroadcaster.m11633a(injectorLike), (IFeedIntentBuilder) DefaultFeedIntentBuilder.a(injectorLike), String_LoggedInUserIdMethodAutoProvider.a(injectorLike), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike), (Clock) SystemClockMethodAutoProvider.a(injectorLike), FbNetworkManager.a(injectorLike), PendingStoryStore.a(injectorLike));
    }

    @Inject
    public UploadNotificationManager(Context context, NotificationManager notificationManager, MediaUploadEventBus mediaUploadEventBus, PhotosViewIntentBuilder photosViewIntentBuilder, UploadNotificationConfiguration uploadNotificationConfiguration, Provider<TriState> provider, VideoUploadSuccessIntent videoUploadSuccessIntent, SecureContextHelper secureContextHelper, FbErrorReporter fbErrorReporter, ComposerActivityBroadcaster composerActivityBroadcaster, IFeedIntentBuilder iFeedIntentBuilder, String str, QeAccessor qeAccessor, Clock clock, FbNetworkManager fbNetworkManager, PendingStoryStore pendingStoryStore) {
        this.f13658b = context;
        this.f13659c = notificationManager;
        this.f13660d = mediaUploadEventBus;
        this.f13661e = photosViewIntentBuilder;
        this.f13662f = uploadNotificationConfiguration;
        this.f13663g = provider;
        this.f13664h = videoUploadSuccessIntent;
        this.f13665i = secureContextHelper;
        this.f13666j = fbErrorReporter;
        this.f13673q = composerActivityBroadcaster;
        this.f13667k = str;
        this.f13674r = iFeedIntentBuilder;
        this.f13675s = qeAccessor;
        this.f13676t = clock;
        this.f13677u = fbNetworkManager;
        this.f13678v = pendingStoryStore;
        this.f13660d.a(this.f13668l);
        this.f13660d.a(this.f13669m);
        this.f13660d.a(this.f13670n);
        this.f13679w = ((TriState) this.f13663g.get()).asBoolean(true);
        Intent b = iFeedIntentBuilder.b(this.f13658b, FBLinks.bT);
        if (b == null) {
            b = new Intent();
        }
        this.f13672p = SecurePendingIntent.a(this.f13658b, 24601, b, 134217728);
        this.f13680x = new Builder(this.f13658b);
    }

    public static boolean m21408f(UploadOperation uploadOperation) {
        return uploadOperation.m21520Y();
    }

    public static PendingIntent m21409g(UploadNotificationManager uploadNotificationManager, UploadOperation uploadOperation) {
        if (!m21408f(uploadOperation)) {
            return uploadNotificationManager.m21412k(uploadOperation);
        }
        PendingIntent pendingIntent;
        if (uploadOperation.f13783f == 0 || uploadOperation.f13783f == Long.parseLong(uploadNotificationManager.f13667k)) {
            pendingIntent = uploadNotificationManager.f13672p;
        } else {
            String a;
            if (uploadOperation.f13784g.equals("wall")) {
                a = StringFormatUtil.a(FBLinks.aX, new Object[]{Long.valueOf(uploadOperation.f13783f)});
            } else if (uploadOperation.f13784g.equals("event")) {
                a = StringFormatUtil.a(FBLinks.t, new Object[]{Long.valueOf(uploadOperation.f13783f)});
            } else if (uploadOperation.f13784g.equals("group")) {
                a = StringFormatUtil.a(FBLinks.u, new Object[]{Long.valueOf(uploadOperation.f13783f)});
            } else if (uploadOperation.f13784g.equals("page")) {
                a = StringFormatUtil.a(FBLinks.af, new Object[]{Long.valueOf(uploadOperation.f13783f)});
            } else {
                pendingIntent = uploadNotificationManager.f13672p;
            }
            pendingIntent = SecurePendingIntent.a(uploadNotificationManager.f13658b, 24601, uploadNotificationManager.f13674r.b(uploadNotificationManager.f13658b, a), 134217728);
        }
        return pendingIntent;
    }

    public final void m21415a(UploadOperation uploadOperation) {
        boolean z = false;
        if ((!m21408f(uploadOperation) || !uploadOperation.m21542k()) && !uploadOperation.ar()) {
            try {
                CharSequence a;
                CharSequence a2;
                int a3;
                DefaultUploadNotificationConfiguration defaultUploadNotificationConfiguration = this.f13662f;
                Intent j = m21411j(uploadOperation);
                PendingIntent a4 = m21399a(uploadOperation, j);
                if (uploadOperation.m21542k()) {
                    a = defaultUploadNotificationConfiguration.mo1131a(this.f13658b, uploadOperation);
                    a2 = m21401a(this, defaultUploadNotificationConfiguration.mo1134b(this.f13658b), uploadOperation);
                    a3 = defaultUploadNotificationConfiguration.m21347a();
                } else {
                    a = defaultUploadNotificationConfiguration.mo1139f(this.f13658b);
                    a2 = m21401a(this, defaultUploadNotificationConfiguration.mo1140g(this.f13658b), uploadOperation);
                    a3 = defaultUploadNotificationConfiguration.m21353b();
                }
                m21410i(uploadOperation);
                boolean h = uploadOperation.m21540h();
                Builder b = new Builder(this.f13658b).a(a3).a(a).b(a2);
                if (h && !m21414n(this, uploadOperation)) {
                    z = true;
                }
                m21403a(this, uploadOperation, b.a(z).a(a4).c());
                if (this.f13657a) {
                    uploadOperation.m21509N();
                }
                this.f13660d.a(new MediaUploadFailedEvent(uploadOperation, j, false, h));
            } catch (Throwable th) {
                this.f13666j.b("Upload failure throwable", th);
            }
        }
    }

    public final void m21419b(UploadOperation uploadOperation) {
        if (!uploadOperation.f13777Z) {
            boolean z;
            this.f13679w = ((TriState) this.f13663g.get()).asBoolean(true);
            DefaultUploadNotificationConfiguration defaultUploadNotificationConfiguration = this.f13662f;
            defaultUploadNotificationConfiguration.mo1133a(m21414n(this, uploadOperation));
            Builder b = new Builder(this.f13658b).a(defaultUploadNotificationConfiguration.m21347a()).a(defaultUploadNotificationConfiguration.mo1131a(this.f13658b, uploadOperation)).b(m21401a(this, defaultUploadNotificationConfiguration.mo1136c(this.f13658b), uploadOperation));
            b.d = m21409g(this, uploadOperation);
            Builder builder = b;
            if (!this.f13679w || m21414n(this, uploadOperation)) {
                z = false;
            } else {
                z = true;
            }
            m21403a(this, uploadOperation, builder.a(z).c());
            if (this.f13657a) {
                String str = uploadOperation.f13793p;
            }
        }
    }

    public final void m21417a(UploadOperation uploadOperation, String str, @Nullable Bundle bundle, @Nullable GraphQLStory graphQLStory) {
        DefaultUploadNotificationConfiguration defaultUploadNotificationConfiguration = this.f13662f;
        try {
            Preconditions.checkNotNull(uploadOperation);
            Preconditions.checkNotNull(uploadOperation.m21548x());
            if (!uploadOperation.aA()) {
                CharSequence a = m21401a(this, defaultUploadNotificationConfiguration.mo1135b(this.f13658b, uploadOperation), uploadOperation);
                CharSequence e = defaultUploadNotificationConfiguration.mo1138e(this.f13658b);
                PendingIntent pendingIntent = this.f13672p;
                if (!uploadOperation.m21521Z()) {
                    try {
                        pendingIntent = m21407c(uploadOperation, str);
                    } catch (Throwable th) {
                        this.f13666j.b("Failed to build upload success intent", th);
                    }
                }
                m21410i(uploadOperation);
                m21403a(this, uploadOperation, new Builder(this.f13658b).a(defaultUploadNotificationConfiguration.m21356c()).a(e).b(a).a(false).a(pendingIntent).c());
                if (this.f13657a) {
                    uploadOperation.m21509N();
                }
                this.f13660d.a(new MediaUploadSuccessEvent(uploadOperation, str, bundle, graphQLStory));
            }
        } catch (Throwable th2) {
            this.f13666j.b("Upload Success throwable", th2);
            m21410i(uploadOperation);
        }
    }

    public final void m21418a(UploadOperation uploadOperation, String str, boolean z, @Nullable GraphQLStory graphQLStory) {
        try {
            Preconditions.checkNotNull(uploadOperation);
            Preconditions.checkNotNull(uploadOperation.m21548x());
            this.f13660d.a(new MediaServerProcessingEvent(uploadOperation, str, z, graphQLStory));
        } catch (Throwable th) {
            this.f13666j.b("Media Server Processing Success throwable", th);
            m21410i(uploadOperation);
        }
    }

    public final void m21420c(UploadOperation uploadOperation) {
        try {
            Preconditions.checkNotNull(uploadOperation);
            m21410i(uploadOperation);
            if (this.f13657a) {
                uploadOperation.m21509N();
            }
            this.f13660d.a(new MediaUploadFailedEvent(uploadOperation, null, true, false));
        } catch (Throwable th) {
            this.f13666j.b("Upload cancel throwable", th);
        }
    }

    public final void m21421d(UploadOperation uploadOperation) {
        try {
            Preconditions.checkNotNull(uploadOperation);
            this.f13673q.m11637a(uploadOperation.m21509N(), uploadOperation.m21497B());
        } catch (Throwable th) {
            this.f13666j.b("Upload restarted throwable", th);
        }
    }

    public static void m21402a(UploadNotificationManager uploadNotificationManager, UploadOperation uploadOperation, int i) {
        String str;
        if (uploadOperation.f13763L == null) {
            str = uploadOperation.f13793p;
        } else {
            str = uploadOperation.f13763L;
        }
        uploadNotificationManager.f13673q.m11638a(str, uploadOperation.f13783f, Math.min(i, 999));
    }

    public static String m21401a(UploadNotificationManager uploadNotificationManager, String str, UploadOperation uploadOperation) {
        String str2 = uploadOperation.f13781d;
        if (StringUtil.a(str2)) {
            return str;
        }
        StringBuilder stringBuilder = new StringBuilder(str2.length());
        m21404a(str2, stringBuilder);
        if (StringUtil.a(str)) {
            return stringBuilder.toString();
        }
        return uploadNotificationManager.f13658b.getString(2131236045, new Object[]{str, stringBuilder.toString()});
    }

    private static void m21413m(UploadOperation uploadOperation) {
        if (uploadOperation.f13795r == Type.PROFILE_VIDEO && uploadOperation.m21550z() != null) {
            uploadOperation.m21550z().remove("thumbnail_bitmap");
        }
    }

    public static void m21404a(String str, StringBuilder stringBuilder) {
        if (str.contains("@[")) {
            Matcher matcher = Pattern.compile("@\\[(\\d+):(\\d+:)?((\\w|\\s)+)\\]", 64).matcher(str);
            int i = 0;
            while (matcher.find()) {
                stringBuilder.append(str.subSequence(i, matcher.start()));
                stringBuilder.append(matcher.group(3));
                i = matcher.end();
            }
            stringBuilder.append(str.subSequence(i, str.length()));
            return;
        }
        stringBuilder.append(str);
    }

    private void m21410i(UploadOperation uploadOperation) {
        if (this.f13678v.a().isEmpty()) {
            this.f13659c.cancel("UploadNotificationManager", this.f13662f.mo1129a(uploadOperation));
        }
    }

    public static void m21403a(UploadNotificationManager uploadNotificationManager, UploadOperation uploadOperation, Notification notification) {
        uploadNotificationManager.f13659c.notify("UploadNotificationManager", uploadNotificationManager.f13662f.mo1129a(uploadOperation), notification);
    }

    private PendingIntent m21407c(UploadOperation uploadOperation, String str) {
        BLog.a("UploadNotificationManager", "getSuccessNotificationPendingIntent");
        Intent intent = new Intent(this.f13658b, PhotosUploadHelperService.class);
        intent.setAction("com.facebook.photos.upload.service.success." + uploadOperation.f13793p);
        m21413m(uploadOperation);
        intent.putExtra("uploadOp", uploadOperation);
        intent.putExtra("success_result", str);
        return PendingIntent.getService(this.f13658b, 24601, intent, 134217728);
    }

    private Intent m21411j(UploadOperation uploadOperation) {
        Intent intent = new Intent(this.f13658b, PhotosUploadHelperService.class);
        intent.setAction("com.facebook.photos.upload.service.retry." + uploadOperation.f13793p);
        intent.putExtra("uploadOp", uploadOperation);
        return intent;
    }

    private PendingIntent m21399a(UploadOperation uploadOperation, Intent intent) {
        m21413m(uploadOperation);
        if (!m21408f(uploadOperation) && m21414n(this, uploadOperation)) {
            return m21398a();
        }
        Context context = this.f13658b;
        UploadDialogsIntentBuilder uploadDialogsIntentBuilder = new UploadDialogsIntentBuilder(this.f13658b);
        uploadDialogsIntentBuilder.f13605b = "upload_options";
        uploadDialogsIntentBuilder = uploadDialogsIntentBuilder;
        uploadDialogsIntentBuilder.f13606c = uploadOperation;
        uploadDialogsIntentBuilder = uploadDialogsIntentBuilder;
        uploadDialogsIntentBuilder.f13607d = intent;
        return SecurePendingIntent.a(context, 24601, uploadDialogsIntentBuilder.m21310a(), 134217728);
    }

    private PendingIntent m21412k(UploadOperation uploadOperation) {
        if (!this.f13679w) {
            return this.f13672p;
        }
        if (m21414n(this, uploadOperation)) {
            return m21398a();
        }
        m21413m(uploadOperation);
        Context context = this.f13658b;
        UploadDialogsIntentBuilder uploadDialogsIntentBuilder = new UploadDialogsIntentBuilder(this.f13658b);
        uploadDialogsIntentBuilder.f13605b = "cancel_request";
        uploadDialogsIntentBuilder = uploadDialogsIntentBuilder;
        uploadDialogsIntentBuilder.f13606c = uploadOperation;
        return SecurePendingIntent.a(context, 24601, uploadDialogsIntentBuilder.m21310a(), 134217728);
    }

    public final void m21416a(UploadOperation uploadOperation, String str) {
        boolean z;
        Intent intent;
        if (uploadOperation.f13777Z) {
            z = false;
        } else {
            z = true;
        }
        Preconditions.checkState(z);
        m21410i(uploadOperation);
        if (m21408f(uploadOperation) || !m21414n(this, uploadOperation)) {
            boolean z2;
            Intent a;
            if (uploadOperation.f13777Z) {
                z2 = false;
            } else {
                z2 = true;
            }
            Preconditions.checkState(z2);
            if (uploadOperation.m21520Y()) {
                a = this.f13664h.m21345a(uploadOperation, str);
            } else if (uploadOperation.f13790m) {
                a = null;
            } else if (uploadOperation.aa()) {
                a = null;
            } else {
                PhotosViewIntentProvider photosViewIntentProvider;
                if (uploadOperation.f13795r == Type.PROFILE_PIC || uploadOperation.f13795r == Type.COVER_PHOTO) {
                    if (uploadOperation.f13783f == Long.parseLong(this.f13667k)) {
                        photosViewIntentProvider = this.f13661e;
                        long j = uploadOperation.f13783f;
                        a = photosViewIntentProvider.f13081c.a(photosViewIntentProvider.f13080b, FBLinks.cm);
                    } else {
                        a = this.f13661e.m20409a(uploadOperation.f13783f);
                    }
                } else if (uploadOperation.f13795r == Type.PLACE_PHOTO) {
                    a = this.f13661e.m20409a(uploadOperation.f13786i);
                } else if (uploadOperation.f13795r == Type.MENU_PHOTO) {
                    a = this.f13661e.m20411b(uploadOperation.f13786i);
                } else if (uploadOperation.f13795r == Type.PRODUCT_IMAGE) {
                    a = null;
                } else {
                    a = null;
                }
                if (a == null) {
                    UploadServerResponse uploadServerResponse;
                    Preconditions.checkNotNull(uploadOperation);
                    Preconditions.checkNotNull(uploadOperation.f13778a);
                    if (uploadOperation.f13792o == PublishMethod.PHOTO_REVIEW) {
                        uploadServerResponse = new UploadServerResponse(ResponseType.PHOTO_REVIEW, str, null);
                    } else if (uploadOperation.f13792o == PublishMethod.SINGLE_PHOTO || uploadOperation.f13792o == PublishMethod.STATUS || uploadOperation.f13792o == PublishMethod.VIDEO_STATUS) {
                        int indexOf = str.indexOf(95);
                        if (indexOf > 0) {
                            String substring = str.substring(0, indexOf);
                            uploadServerResponse = new UploadServerResponse(ResponseType.PHOTO_STORY, str.substring(indexOf + 1), substring);
                        } else {
                            uploadServerResponse = new UploadServerResponse(ResponseType.SINGLE_PHOTO, str, null);
                        }
                    } else {
                        uploadServerResponse = new UploadServerResponse(ResponseType.TARGET_POST, str, null);
                    }
                    UploadServerResponse uploadServerResponse2 = uploadServerResponse;
                    PhotosViewIntentProvider photosViewIntentProvider2;
                    String str2;
                    Intent a2;
                    if (uploadServerResponse2.f14137c == ResponseType.TARGET_POST) {
                        photosViewIntentProvider2 = this.f13661e;
                        str2 = uploadServerResponse2.f14135a;
                        a2 = photosViewIntentProvider2.f13081c.a(photosViewIntentProvider2.f13080b, StringFormatUtil.a(FBLinks.bk, new Object[]{str2}));
                        if (a2 != null) {
                            a2.setAction("com.facebook.photos.photogallery." + str2);
                        }
                        a = a2;
                    } else if (uploadServerResponse2.f14137c == ResponseType.PHOTO_REVIEW) {
                        photosViewIntentProvider = this.f13661e;
                        String l = Long.toString(uploadOperation.f13799v.f7934b);
                        a2 = photosViewIntentProvider.f13081c.a(photosViewIntentProvider.f13080b, StringFormatUtil.formatStrLocaleSafe(FBLinks.ai, l));
                        a2.setAction("com.facebook.photos.photogallery." + l);
                        a = a2;
                    } else if (uploadServerResponse2.f14137c == ResponseType.PHOTO_STORY) {
                        photosViewIntentProvider2 = this.f13661e;
                        String str3 = uploadServerResponse2.f14136b;
                        str2 = uploadServerResponse2.f14135a;
                        String a3 = StringFormatUtil.a(FBLinks.aT, new Object[]{str2, str3});
                        Intent intent2 = new Intent();
                        intent2.setData(Uri.parse(a3));
                        a = intent2;
                    } else {
                        photosViewIntentProvider2 = this.f13661e;
                        str2 = uploadServerResponse2.f14135a;
                        a2 = photosViewIntentProvider2.f13081c.a(photosViewIntentProvider2.f13080b, StringFormatUtil.a(FBLinks.bk, new Object[]{str2}));
                        a2.setAction("com.facebook.photos.photogallery." + str2);
                        a = a2;
                    }
                }
            }
            intent = a;
        } else {
            intent = m21405b();
        }
        if (intent != null) {
            intent.addFlags(268435456);
            this.f13665i.a(intent, this.f13658b);
        }
    }

    public static boolean m21414n(UploadNotificationManager uploadNotificationManager, UploadOperation uploadOperation) {
        boolean z;
        if (uploadOperation.f13795r == Type.PROFILE_PIC || uploadOperation.f13795r == Type.COVER_PHOTO || (uploadOperation.f13794q != null && (uploadOperation.f13794q.equals(ComposerSourceType.FEED.toString()) || uploadOperation.f13794q.equals(ComposerSourceType.FEED_INLINE.toString()) || uploadOperation.f13794q.equals(ComposerSourceType.TIMELINE.toString()) || uploadOperation.f13794q.equals(ComposerSourceType.GROUP.toString()) || uploadOperation.f13794q.equals(ComposerSourceType.EVENT.toString()) || uploadOperation.f13794q.equals(ComposerSourceType.PAGE.toString()) || uploadOperation.f13794q.equals(ComposerSourceType.EXTERNAL.toString()) || uploadOperation.f13794q.equals(ComposerSourceType.COMPOST.toString()) || uploadOperation.f13794q.equals(ComposerSourceSurface.NEWSFEED.toString()) || uploadOperation.f13794q.equals(ComposerSourceSurface.TIMELINE.toString()) || uploadOperation.f13794q.equals(ComposerSourceSurface.GROUP_FEED.toString()) || uploadOperation.f13794q.equals(ComposerSourceSurface.EVENT.toString()) || uploadOperation.f13794q.equals(ComposerSourceSurface.PAGE_FEED.toString()) || uploadOperation.f13794q.equals(ComposerSourceSurface.COMPOST.toString())))) {
            z = true;
        } else {
            z = false;
        }
        if ((uploadNotificationManager.f13675s.a(ExperimentsForCompostAbTestModule.f8106y, false) || r0) && uploadNotificationManager.f13675s.a(ExperimentsForCompostAbTestModule.f8107z, false)) {
            return true;
        }
        return false;
    }

    private PendingIntent m21398a() {
        return SecurePendingIntent.a(this.f13658b, 24601, m21405b(), 134217728);
    }

    private Intent m21405b() {
        return CompostActivity.m21601a(this.f13658b, CompostSourceType.UPLOAD_NOTIFICATION);
    }
}
