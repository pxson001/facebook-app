package com.facebook.messaging.media.upload;

import com.facebook.auth.userscope.UserScoped;
import com.facebook.base.broadcast.BaseFbBroadcastManager;
import com.facebook.base.broadcast.LocalFbBroadcastManager;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.common.executors.ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.http.protocol.ApiMethodProgressListener;
import com.facebook.http.protocol.ApiMethodRunnerImpl;
import com.facebook.http.protocol.ApiMethodRunnerParams;
import com.facebook.http.protocol.HttpRequestAbortHandler;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.media.bandwidth.MediaBandwidthManager;
import com.facebook.messaging.media.bandwidth.MediaBandwidthManager$MediaApiMethodProgressListener;
import com.facebook.messaging.media.upload.MediaUploadMethod.Params;
import com.facebook.messaging.media.upload.udp.UDPManager;
import com.facebook.messaging.media.upload.util.MediaUploadStateHelper;
import com.facebook.tools.dextr.runtime.detour.FutureDetour;
import com.facebook.ui.media.attachments.MediaResource;
import com.facebook.ui.media.attachments.MediaResource.Type;
import com.facebook.ultralight.Lazy;
import com.facebook.ultralight.UltralightRuntime;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReference;
import javax.inject.Inject;

@UserScoped
/* compiled from: listener can not be null */
public class MediaUploadServiceHelper {
    private static final Object f11957n = new Object();
    public final ApiMethodRunnerImpl f11958a;
    public final MediaUploadMethod f11959b;
    public final Clock f11960c;
    public final BaseFbBroadcastManager f11961d;
    private final ListeningExecutorService f11962e;
    private final MediaUploadStateHelper f11963f;
    private final MediaResumableUploadManager f11964g;
    public final MediaBandwidthManager f11965h;
    private final PhotoUploadServiceHandlerLogger f11966i;
    private final DefaultAndroidThreadUtil f11967j;
    private final UDPManager f11968k;
    @Inject
    @Lazy
    public com.facebook.inject.Lazy<FbErrorReporter> f11969l = UltralightRuntime.b;
    @Inject
    @Lazy
    public com.facebook.inject.Lazy<MediaUploadErrorHelper> f11970m = UltralightRuntime.b;

    /* compiled from: listener can not be null */
    class MediaUploadProgressListener implements ApiMethodProgressListener {
        final /* synthetic */ MediaUploadServiceHelper f11952a;
        private final MediaResource f11953b;
        private double f11954c = 0.0d;
        private long f11955d = 0;
        private ApiMethodProgressListener f11956e;

        public MediaUploadProgressListener(MediaUploadServiceHelper mediaUploadServiceHelper, MediaResource mediaResource) {
            this.f11952a = mediaUploadServiceHelper;
            this.f11953b = mediaResource;
            MediaBandwidthManager mediaBandwidthManager = mediaUploadServiceHelper.f11965h;
            mediaBandwidthManager.getClass();
            this.f11956e = new MediaBandwidthManager$MediaApiMethodProgressListener(mediaBandwidthManager);
        }

        public final void m12514a(long j, long j2) {
            this.f11956e.a(j, j2);
            long a = this.f11952a.f11960c.a();
            if (a - this.f11955d >= 15 || j == j2) {
                double d = ((double) j) / ((double) j2);
                if (d != this.f11954c) {
                    this.f11954c = d;
                    this.f11955d = a;
                    this.f11952a.f11961d.a(MediaUploadEvents.m12490b(this.f11953b, d));
                }
            }
        }
    }

    /* compiled from: listener can not be null */
    enum UploadMethod {
        Resumable,
        ChunkedUDP,
        UN_SPECIFIED
    }

    private static MediaUploadServiceHelper m12519b(InjectorLike injectorLike) {
        MediaUploadServiceHelper mediaUploadServiceHelper = new MediaUploadServiceHelper(ApiMethodRunnerImpl.a(injectorLike), MediaUploadMethod.m12499b(injectorLike), (Clock) SystemClockMethodAutoProvider.a(injectorLike), (BaseFbBroadcastManager) LocalFbBroadcastManager.a(injectorLike), ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider.a(injectorLike), MediaUploadStateHelper.m12723a(injectorLike), MediaResumableUploadManager.m12471a(injectorLike), MediaBandwidthManager.a(injectorLike), PhotoUploadServiceHandlerLogger.m12545a(injectorLike), DefaultAndroidThreadUtil.b(injectorLike), UDPManager.m12688a(injectorLike));
        com.facebook.inject.Lazy b = IdBasedSingletonScopeProvider.b(injectorLike, 494);
        com.facebook.inject.Lazy b2 = IdBasedSingletonScopeProvider.b(injectorLike, 7933);
        mediaUploadServiceHelper.f11969l = b;
        mediaUploadServiceHelper.f11970m = b2;
        return mediaUploadServiceHelper;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.facebook.messaging.media.upload.MediaUploadServiceHelper m12515a(com.facebook.inject.InjectorLike r7) {
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
        r1 = f11957n;	 Catch:{ all -> 0x006c }
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
        r1 = m12519b(r0);	 Catch:{ all -> 0x0062 }
        com.facebook.auth.userscope.UserScope.a(r6);	 Catch:{  }
        if (r1 != 0) goto L_0x0071;
    L_0x004d:
        r0 = f11957n;	 Catch:{  }
        r6 = com.facebook.auth.userscope.UserScope.a;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r6);	 Catch:{  }
        r0 = (com.facebook.messaging.media.upload.MediaUploadServiceHelper) r0;	 Catch:{  }
    L_0x0057:
        if (r0 == 0) goto L_0x007a;
    L_0x0059:
        r2.c(r5);	 Catch:{  }
    L_0x005c:
        r0 = (com.facebook.messaging.media.upload.MediaUploadServiceHelper) r0;	 Catch:{  }
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
        r0 = f11957n;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r1);	 Catch:{  }
        r0 = (com.facebook.messaging.media.upload.MediaUploadServiceHelper) r0;	 Catch:{  }
        goto L_0x0057;
    L_0x007a:
        r0 = r1;
        goto L_0x0059;
    L_0x007c:
        r0 = r1;
        goto L_0x005c;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.media.upload.MediaUploadServiceHelper.a(com.facebook.inject.InjectorLike):com.facebook.messaging.media.upload.MediaUploadServiceHelper");
    }

    @Inject
    public MediaUploadServiceHelper(ApiMethodRunnerImpl apiMethodRunnerImpl, MediaUploadMethod mediaUploadMethod, Clock clock, BaseFbBroadcastManager baseFbBroadcastManager, ListeningExecutorService listeningExecutorService, MediaUploadStateHelper mediaUploadStateHelper, MediaResumableUploadManager mediaResumableUploadManager, MediaBandwidthManager mediaBandwidthManager, PhotoUploadServiceHandlerLogger photoUploadServiceHandlerLogger, DefaultAndroidThreadUtil defaultAndroidThreadUtil, UDPManager uDPManager) {
        this.f11958a = apiMethodRunnerImpl;
        this.f11959b = mediaUploadMethod;
        this.f11960c = clock;
        this.f11961d = baseFbBroadcastManager;
        this.f11962e = listeningExecutorService;
        this.f11963f = mediaUploadStateHelper;
        this.f11964g = mediaResumableUploadManager;
        this.f11965h = mediaBandwidthManager;
        this.f11966i = photoUploadServiceHandlerLogger;
        this.f11967j = defaultAndroidThreadUtil;
        this.f11968k = uDPManager;
    }

    public final String m12520a(boolean z, boolean z2, MediaResource mediaResource, String str, String str2) {
        AtomicReference atomicReference = new AtomicReference();
        int i = 0;
        int i2 = 0;
        while (true) {
            try {
                this.f11966i.m12556a(mediaResource, z2, z);
                String a = m12516a(str2, mediaResource, str, atomicReference);
                this.f11966i.m12555a(mediaResource, a, i2, (Map) atomicReference.get(), z2, z);
                return a;
            } catch (CancellationException e) {
                this.f11966i.m12552a(mediaResource, i2, (Map) atomicReference.get(), z2, z);
                throw e;
            } catch (Exception e2) {
                this.f11966i.m12554a(mediaResource, e2, i2, (Map) atomicReference.get(), z2, z);
                if (i2 >= 5 || !m12518a(mediaResource, e2)) {
                    throw e2;
                }
                i2++;
                int i3 = (int) (((long) i) + (((long) i2) * 1000));
                this.f11967j.a((long) i3);
                i = i3;
            }
        }
        throw e2;
    }

    private boolean m12518a(MediaResource mediaResource, Exception exception) {
        if (mediaResource.d == Type.VIDEO) {
            return false;
        }
        return ((MediaUploadErrorHelper) this.f11970m.get()).m12483a((Throwable) exception);
    }

    private String m12516a(String str, MediaResource mediaResource, String str2, AtomicReference<Map<String, String>> atomicReference) {
        UploadMethod uploadMethod;
        UploadMethod uploadMethod2 = UploadMethod.UN_SPECIFIED;
        if (this.f11968k.m12692a(str, mediaResource)) {
            uploadMethod2 = UploadMethod.ChunkedUDP;
        } else if (this.f11964g.m12477a(mediaResource)) {
            uploadMethod2 = UploadMethod.Resumable;
        }
        if (str2 == null || uploadMethod2 == UploadMethod.Resumable) {
            uploadMethod = uploadMethod2;
        } else {
            ((AbstractFbErrorReporter) this.f11969l.get()).b("MediaUploadServiceHelper_wrong_upload_method", "Upload method " + uploadMethod2 + " does not support update with fbid");
            uploadMethod = UploadMethod.Resumable;
        }
        switch (uploadMethod) {
            case Resumable:
                return this.f11964g.m12475a(str, mediaResource, str2, atomicReference);
            case ChunkedUDP:
                return this.f11968k.m12693b(str, mediaResource);
            default:
                HttpRequestAbortHandler httpRequestAbortHandler = new HttpRequestAbortHandler();
                ListenableFuture a = this.f11962e.a(m12517a(mediaResource, httpRequestAbortHandler));
                do {
                    try {
                        return (String) FutureDetour.a(a, 50, TimeUnit.MILLISECONDS, -405947771);
                    } catch (TimeoutException e) {
                        if (this.f11963f.m12727d(str)) {
                            httpRequestAbortHandler.a();
                            throw new CancellationException();
                        }
                    }
                } while (this.f11963f.m12727d(str));
                httpRequestAbortHandler.a();
                throw new CancellationException();
        }
    }

    private Callable<String> m12517a(final MediaResource mediaResource, HttpRequestAbortHandler httpRequestAbortHandler) {
        final ApiMethodRunnerParams apiMethodRunnerParams = new ApiMethodRunnerParams();
        apiMethodRunnerParams.a = new MediaUploadProgressListener(this, mediaResource);
        apiMethodRunnerParams.c = httpRequestAbortHandler;
        this.f11964g.m12476a(mediaResource, apiMethodRunnerParams);
        return new Callable<String>(this) {
            final /* synthetic */ MediaUploadServiceHelper f11950c;

            public Object call() {
                return (String) this.f11950c.f11958a.a(this.f11950c.f11959b, new Params(mediaResource, 0), apiMethodRunnerParams);
            }
        };
    }
}
