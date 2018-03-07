package com.facebook.messaging.media.upload;

import com.facebook.auth.userscope.UserScoped;
import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.common.tempfile.BackingFileResolver;
import com.facebook.common.util.StringUtil;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.http.protocol.ApiMethodRunnerImpl;
import com.facebook.http.protocol.ApiMethodRunnerParams;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.media.upload.ResumableUploadMetricsBuilder.UploadStatus;
import com.facebook.messaging.media.upload.ResumableUploaderFactory.Params;
import com.facebook.messaging.media.upload.ResumableUploaderFactory.ResumableUploader;
import com.facebook.messaging.requestrouting.RequestRoutingHelper;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.ui.media.attachments.MediaResource;
import com.facebook.ui.media.attachments.MediaResource.Type;
import com.google.common.base.Preconditions;
import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.google.common.collect.ImmutableList;
import com.google.common.hash.Hashing;
import com.google.common.io.Files;
import java.io.File;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReference;
import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.ThreadSafe;
import javax.inject.Inject;
import org.apache.http.message.BasicHeader;

@UserScoped
@ThreadSafe
/* compiled from: localPath */
public class MediaResumableUploadManager {
    private static final Object f11878k = new Object();
    private final MediaUploadMethod f11879a;
    private final ApiMethodRunnerImpl f11880b;
    public final BackingFileResolver f11881c;
    private final ResumableUploaderFactory f11882d;
    private final MediaUploadConfig f11883e;
    private final GatekeeperStoreImpl f11884f;
    private final RequestRoutingHelper f11885g;
    private final ExponentialBackoffApplier f11886h;
    @Inject
    public QeAccessor f11887i;
    @GuardedBy("this")
    private final Cache<String, String> f11888j = CacheBuilder.newBuilder().a(2073600000, TimeUnit.MILLISECONDS).q();

    /* compiled from: localPath */
    class ExponentialBackoffApplier {
        private final DefaultAndroidThreadUtil f11876a;
        private long f11877b;

        public ExponentialBackoffApplier(DefaultAndroidThreadUtil defaultAndroidThreadUtil) {
            this.f11876a = defaultAndroidThreadUtil;
            m12469a();
        }

        public final void m12469a() {
            this.f11877b = 10;
        }

        public final void m12470b() {
            DefaultAndroidThreadUtil defaultAndroidThreadUtil = this.f11876a;
            Thread.sleep(this.f11877b);
            this.f11877b = Math.min(this.f11877b << 1, 5000);
        }
    }

    private static MediaResumableUploadManager m12474b(InjectorLike injectorLike) {
        MediaResumableUploadManager mediaResumableUploadManager = new MediaResumableUploadManager(MediaUploadMethod.m12499b(injectorLike), ApiMethodRunnerImpl.a(injectorLike), BackingFileResolver.a(injectorLike), DefaultAndroidThreadUtil.b(injectorLike), ResumableUploaderFactory.m12577a(injectorLike), MediaUploadConfig.m12479b(injectorLike), GatekeeperStoreImplMethodAutoProvider.a(injectorLike), RequestRoutingHelper.a(injectorLike));
        mediaResumableUploadManager.f11887i = (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike);
        return mediaResumableUploadManager;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.facebook.messaging.media.upload.MediaResumableUploadManager m12471a(com.facebook.inject.InjectorLike r7) {
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
        r1 = f11878k;	 Catch:{ all -> 0x006c }
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
        r1 = m12474b(r0);	 Catch:{ all -> 0x0062 }
        com.facebook.auth.userscope.UserScope.a(r6);	 Catch:{  }
        if (r1 != 0) goto L_0x0071;
    L_0x004d:
        r0 = f11878k;	 Catch:{  }
        r6 = com.facebook.auth.userscope.UserScope.a;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r6);	 Catch:{  }
        r0 = (com.facebook.messaging.media.upload.MediaResumableUploadManager) r0;	 Catch:{  }
    L_0x0057:
        if (r0 == 0) goto L_0x007a;
    L_0x0059:
        r2.c(r5);	 Catch:{  }
    L_0x005c:
        r0 = (com.facebook.messaging.media.upload.MediaResumableUploadManager) r0;	 Catch:{  }
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
        r0 = f11878k;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r1);	 Catch:{  }
        r0 = (com.facebook.messaging.media.upload.MediaResumableUploadManager) r0;	 Catch:{  }
        goto L_0x0057;
    L_0x007a:
        r0 = r1;
        goto L_0x0059;
    L_0x007c:
        r0 = r1;
        goto L_0x005c;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.media.upload.MediaResumableUploadManager.a(com.facebook.inject.InjectorLike):com.facebook.messaging.media.upload.MediaResumableUploadManager");
    }

    @Inject
    MediaResumableUploadManager(MediaUploadMethod mediaUploadMethod, ApiMethodRunnerImpl apiMethodRunnerImpl, BackingFileResolver backingFileResolver, DefaultAndroidThreadUtil defaultAndroidThreadUtil, ResumableUploaderFactory resumableUploaderFactory, MediaUploadConfig mediaUploadConfig, GatekeeperStoreImpl gatekeeperStoreImpl, RequestRoutingHelper requestRoutingHelper) {
        this.f11879a = mediaUploadMethod;
        this.f11880b = apiMethodRunnerImpl;
        this.f11881c = backingFileResolver;
        this.f11882d = resumableUploaderFactory;
        this.f11883e = mediaUploadConfig;
        this.f11886h = new ExponentialBackoffApplier(defaultAndroidThreadUtil);
        this.f11884f = gatekeeperStoreImpl;
        this.f11885g = requestRoutingHelper;
    }

    public final boolean m12477a(MediaResource mediaResource) {
        if (this.f11883e.m12480b(mediaResource)) {
            return false;
        }
        long j = mediaResource.p;
        if (j == 0) {
            j = this.f11881c.b(mediaResource.c);
        }
        if (j == 0) {
            return false;
        }
        if (mediaResource.d == Type.VIDEO) {
            return this.f11884f.a(904, false);
        }
        if (mediaResource.d == Type.PHOTO) {
            return this.f11884f.a(903, false);
        }
        if (mediaResource.d == Type.ENCRYPTED_PHOTO) {
            return true;
        }
        if (mediaResource.d == Type.ENT_PHOTO) {
            return true;
        }
        if (mediaResource.d == Type.AUDIO) {
            return this.f11887i.a(ExperimentsForMediaUploadModule.f11829a, false);
        }
        return false;
    }

    private static int m12473b(MediaResource mediaResource) {
        if (mediaResource.d == Type.VIDEO) {
            return 65;
        }
        return 40;
    }

    public final String m12475a(String str, MediaResource mediaResource, String str2, AtomicReference<Map<String, String>> atomicReference) {
        int i = 1;
        int i2 = 0;
        File a = this.f11881c.a(mediaResource.c);
        Preconditions.checkNotNull(a, "Unable to retrieve the object file.");
        Preconditions.checkNotNull(Boolean.valueOf(a.length() > 0), "The file is not present!");
        ResumableUploadMetricsBuilder resumableUploadMetricsBuilder = new ResumableUploadMetricsBuilder();
        atomicReference.set(resumableUploadMetricsBuilder.m12566c());
        resumableUploadMetricsBuilder.m12563a(UploadStatus.START_UPLOAD);
        resumableUploadMetricsBuilder.m12562a(a.length());
        String a2 = m12472a(Files.a(a, Hashing.a()).toString() + mediaResource.m);
        resumableUploadMetricsBuilder.m12563a(UploadStatus.FILE_KEY_COMPUTED);
        int b = m12473b(mediaResource);
        ResumableUploader a3 = this.f11882d.m12579a(new Params(str, a2, a, mediaResource, str2, resumableUploadMetricsBuilder));
        this.f11886h.m12469a();
        for (int i3 = 0; i3 < b; i3++) {
            ApiMethodRunnerParams apiMethodRunnerParams = new ApiMethodRunnerParams();
            m12476a(mediaResource, apiMethodRunnerParams);
            a3.m12573a(apiMethodRunnerParams);
            resumableUploadMetricsBuilder.m12563a(UploadStatus.UPLOAD_STARTED);
            if (a3.m12576d()) {
                resumableUploadMetricsBuilder.m12563a(UploadStatus.VIDEO_UPLOAD_COMPLETED);
                break;
            }
            this.f11886h.m12470b();
        }
        i = 0;
        if (i == 0) {
            resumableUploadMetricsBuilder.m12563a(UploadStatus.TIMED_OUT_UPLOAD);
            throw new TimeoutException("Uploading media failed");
        }
        String b2;
        this.f11886h.m12469a();
        if (a3.m12575c()) {
            b2 = a3.m12574b();
        } else {
            while (true) {
                try {
                    ApiMethodRunnerParams apiMethodRunnerParams2 = new ApiMethodRunnerParams();
                    m12476a(mediaResource, apiMethodRunnerParams2);
                    b2 = (String) this.f11880b.a(this.f11879a, new MediaUploadMethod.Params(mediaResource, 0, true, a3.m12572a()), apiMethodRunnerParams2);
                    break;
                } catch (Exception e) {
                    if (i2 < 2) {
                        this.f11886h.m12470b();
                        i2++;
                    } else {
                        resumableUploadMetricsBuilder.m12563a(UploadStatus.TIMED_OUT_POST_PROCESS);
                        throw e;
                    }
                }
            }
        }
        resumableUploadMetricsBuilder.m12563a(UploadStatus.VIDEO_POST_PROCESS_COMPLETED);
        return b2;
    }

    final void m12476a(MediaResource mediaResource, ApiMethodRunnerParams apiMethodRunnerParams) {
        if (mediaResource.d == Type.PHOTO && this.f11884f.a(298, false)) {
            Object a = this.f11885g.a();
            if (!StringUtil.c(a)) {
                apiMethodRunnerParams.a(ImmutableList.of(new BasicHeader("X-MSGR-Region", a)));
            }
        }
    }

    private synchronized String m12472a(String str) {
        String str2;
        str2 = (String) this.f11888j.a(str);
        if (str2 == null) {
            this.f11888j.a(str, str);
            str2 = str;
        }
        return str2;
    }
}
