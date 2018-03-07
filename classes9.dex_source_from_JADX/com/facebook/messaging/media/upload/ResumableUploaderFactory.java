package com.facebook.messaging.media.upload;

import com.facebook.auth.userscope.UserScoped;
import com.facebook.base.broadcast.BaseFbBroadcastManager;
import com.facebook.base.broadcast.LocalFbBroadcastManager;
import com.facebook.common.executors.ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider;
import com.facebook.http.protocol.ApiMethodProgressListener;
import com.facebook.http.protocol.ApiMethodRunnerParams;
import com.facebook.http.protocol.HttpRequestAbortHandler;
import com.facebook.http.protocol.HttpWireCallback;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.media.bandwidth.MediaBandwidthManager;
import com.facebook.messaging.media.bandwidth.MediaBandwidthManager$MediaApiMethodProgressListener;
import com.facebook.messaging.media.upload.ResumableUploadCallableFactory.ResumableUploadCallable;
import com.facebook.messaging.media.upload.ResumableUploadMetricsBuilder.UploadStatus;
import com.facebook.messaging.media.upload.StartResumableUploadMethod.Response;
import com.facebook.messaging.media.upload.util.MediaUploadStateHelper;
import com.facebook.qe.api.ExposureLogging;
import com.facebook.qe.api.Liveness;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.tools.dextr.runtime.detour.FutureDetour;
import com.facebook.ui.media.attachments.MediaResource;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import java.io.File;
import java.util.concurrent.CancellationException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import javax.annotation.concurrent.NotThreadSafe;
import javax.annotation.concurrent.ThreadSafe;
import javax.inject.Inject;

@UserScoped
@ThreadSafe
/* compiled from: legacy_attachment_id */
public class ResumableUploaderFactory {
    private static final Object f12042h = new Object();
    public final BaseFbBroadcastManager f12043a;
    public final ListeningExecutorService f12044b;
    public final MediaUploadStateHelper f12045c;
    public final ResumableUploadCallableFactory f12046d;
    public final MediaBandwidthManager f12047e;
    public final QeAccessor f12048f;
    public final MediaUploadErrorHelper f12049g;

    @ThreadSafe
    /* compiled from: legacy_attachment_id */
    public class OffsetProgressListener implements ApiMethodProgressListener, HttpWireCallback {
        final /* synthetic */ ResumableUploaderFactory f12023a;
        private boolean f12024b = false;
        private long f12025c = 0;
        private long f12026d = 0;
        private long f12027e;
        private final MediaResource f12028f;
        private ApiMethodProgressListener f12029g;

        public OffsetProgressListener(ResumableUploaderFactory resumableUploaderFactory, long j, MediaResource mediaResource) {
            this.f12023a = resumableUploaderFactory;
            this.f12027e = j;
            this.f12028f = mediaResource;
            MediaBandwidthManager mediaBandwidthManager = resumableUploaderFactory.f12047e;
            mediaBandwidthManager.getClass();
            this.f12029g = new MediaBandwidthManager$MediaApiMethodProgressListener(mediaBandwidthManager);
        }

        public final void m12571b(long j) {
            this.f12025c = j;
        }

        public final void m12570a(long j, long j2) {
            if (!this.f12024b) {
                m12567c(j);
            }
        }

        public final void m12568a() {
            if (this.f12023a.f12048f.a(Liveness.Live, ExposureLogging.On, ExperimentsForMediaUploadModule.f11832d, false)) {
                this.f12024b = true;
            }
        }

        public final void m12569a(long j) {
            if (this.f12024b) {
                this.f12025c += j;
                m12567c(0);
            }
        }

        private void m12567c(long j) {
            this.f12026d = Math.max(this.f12025c + j, this.f12026d);
            this.f12029g.a(this.f12026d, this.f12027e);
            this.f12023a.f12043a.a(MediaUploadEvents.m12490b(this.f12028f, (((double) this.f12026d) * 1.0d) / ((double) this.f12027e)));
        }
    }

    /* compiled from: legacy_attachment_id */
    public class Params {
        public final String f12030a;
        public final String f12031b;
        public final File f12032c;
        public final MediaResource f12033d;
        public final String f12034e;
        public final ResumableUploadMetricsBuilder f12035f;

        public Params(String str, String str2, File file, MediaResource mediaResource, String str3, ResumableUploadMetricsBuilder resumableUploadMetricsBuilder) {
            this.f12030a = str;
            this.f12031b = str2;
            this.f12032c = file;
            this.f12033d = mediaResource;
            this.f12034e = str3;
            this.f12035f = resumableUploadMetricsBuilder;
        }
    }

    @NotThreadSafe
    /* compiled from: legacy_attachment_id */
    public class ResumableUploader {
        final /* synthetic */ ResumableUploaderFactory f12036a;
        private Params f12037b;
        private String f12038c = null;
        private Response f12039d = null;
        private ListenableFuture<Response> f12040e;
        private final HttpRequestAbortHandler f12041f;

        public ResumableUploader(ResumableUploaderFactory resumableUploaderFactory, Params params) {
            this.f12036a = resumableUploaderFactory;
            this.f12037b = params;
            this.f12041f = new HttpRequestAbortHandler();
        }

        public final String m12572a() {
            return this.f12039d.f12056a;
        }

        public final String m12574b() {
            return this.f12039d.f12057b;
        }

        public final boolean m12575c() {
            Response response = this.f12039d;
            boolean z = response.f12057b != null && response.f12057b.length() > 0;
            return z;
        }

        public final boolean m12573a(ApiMethodRunnerParams apiMethodRunnerParams) {
            if (this.f12040e != null && !this.f12040e.isDone()) {
                return false;
            }
            if (this.f12038c == null) {
                this.f12038c = this.f12037b.f12031b;
            }
            apiMethodRunnerParams.a = new OffsetProgressListener(this.f12036a, this.f12037b.f12032c.length(), this.f12037b.f12033d);
            apiMethodRunnerParams.c = this.f12041f;
            this.f12040e = this.f12036a.f12044b.a(new ResumableUploadCallable(this.f12036a.f12046d, new com.facebook.messaging.media.upload.ResumableUploadCallableFactory.Params(this.f12038c, apiMethodRunnerParams, this.f12037b.f12032c, this.f12037b.f12033d, this.f12037b.f12034e, this.f12037b.f12035f)));
            return true;
        }

        public final boolean m12576d() {
            do {
                try {
                    this.f12039d = (Response) FutureDetour.a(this.f12040e, 100, TimeUnit.MILLISECONDS, -462788728);
                    return true;
                } catch (TimeoutException e) {
                    if (this.f12036a.f12045c.m12727d(this.f12037b.f12030a)) {
                        if (this.f12037b.f12035f != null) {
                            this.f12037b.f12035f.m12563a(UploadStatus.USER_CANCELLED);
                        }
                        this.f12041f.a();
                        throw new CancellationException();
                    }
                } catch (Throwable e2) {
                    Throwable th = e2;
                    if (this.f12037b.f12035f != null) {
                        this.f12037b.f12035f.m12564a(th.getMessage(), th.getCause() != null ? th.getCause().getMessage() : "");
                    }
                    if (this.f12036a.f12049g.m12483a(th)) {
                        this.f12036a.f12047e.a();
                        return false;
                    }
                    throw th;
                }
            } while (this.f12036a.f12045c.m12727d(this.f12037b.f12030a));
            if (this.f12037b.f12035f != null) {
                this.f12037b.f12035f.m12563a(UploadStatus.USER_CANCELLED);
            }
            this.f12041f.a();
            throw new CancellationException();
        }
    }

    private static ResumableUploaderFactory m12578b(InjectorLike injectorLike) {
        return new ResumableUploaderFactory((BaseFbBroadcastManager) LocalFbBroadcastManager.a(injectorLike), ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider.a(injectorLike), MediaUploadStateHelper.m12723a(injectorLike), ResumableUploadCallableFactory.m12557a(injectorLike), MediaBandwidthManager.a(injectorLike), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike), MediaUploadErrorHelper.m12481a(injectorLike));
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.facebook.messaging.media.upload.ResumableUploaderFactory m12577a(com.facebook.inject.InjectorLike r7) {
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
        r1 = f12042h;	 Catch:{ all -> 0x006c }
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
        r1 = m12578b(r0);	 Catch:{ all -> 0x0062 }
        com.facebook.auth.userscope.UserScope.a(r6);	 Catch:{  }
        if (r1 != 0) goto L_0x0071;
    L_0x004d:
        r0 = f12042h;	 Catch:{  }
        r6 = com.facebook.auth.userscope.UserScope.a;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r6);	 Catch:{  }
        r0 = (com.facebook.messaging.media.upload.ResumableUploaderFactory) r0;	 Catch:{  }
    L_0x0057:
        if (r0 == 0) goto L_0x007a;
    L_0x0059:
        r2.c(r5);	 Catch:{  }
    L_0x005c:
        r0 = (com.facebook.messaging.media.upload.ResumableUploaderFactory) r0;	 Catch:{  }
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
        r0 = f12042h;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r1);	 Catch:{  }
        r0 = (com.facebook.messaging.media.upload.ResumableUploaderFactory) r0;	 Catch:{  }
        goto L_0x0057;
    L_0x007a:
        r0 = r1;
        goto L_0x0059;
    L_0x007c:
        r0 = r1;
        goto L_0x005c;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.media.upload.ResumableUploaderFactory.a(com.facebook.inject.InjectorLike):com.facebook.messaging.media.upload.ResumableUploaderFactory");
    }

    @Inject
    public ResumableUploaderFactory(BaseFbBroadcastManager baseFbBroadcastManager, ListeningExecutorService listeningExecutorService, MediaUploadStateHelper mediaUploadStateHelper, ResumableUploadCallableFactory resumableUploadCallableFactory, MediaBandwidthManager mediaBandwidthManager, QeAccessor qeAccessor, MediaUploadErrorHelper mediaUploadErrorHelper) {
        this.f12043a = baseFbBroadcastManager;
        this.f12044b = listeningExecutorService;
        this.f12045c = mediaUploadStateHelper;
        this.f12046d = resumableUploadCallableFactory;
        this.f12047e = mediaBandwidthManager;
        this.f12048f = qeAccessor;
        this.f12049g = mediaUploadErrorHelper;
    }

    public final ResumableUploader m12579a(Params params) {
        return new ResumableUploader(this, params);
    }
}
