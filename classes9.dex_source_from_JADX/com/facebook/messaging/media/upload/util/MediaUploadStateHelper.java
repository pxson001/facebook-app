package com.facebook.messaging.media.upload.util;

import com.facebook.auth.userscope.UserScoped;
import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import java.util.concurrent.TimeUnit;
import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.ThreadSafe;

@UserScoped
@ThreadSafe
/* compiled from: large_preview_size */
public class MediaUploadStateHelper {
    private static final Object f12237b = new Object();
    @GuardedBy("this")
    private final Cache<String, MediaUploadOperationState> f12238a = CacheBuilder.newBuilder().a(2073600000, TimeUnit.MILLISECONDS).q();

    /* compiled from: large_preview_size */
    enum MediaUploadOperationState {
        RUNNING,
        CANCELED,
        FINISHED
    }

    private static MediaUploadStateHelper m12722a() {
        return new MediaUploadStateHelper();
    }

    public final synchronized boolean m12724a(String str) {
        boolean z;
        MediaUploadOperationState mediaUploadOperationState = (MediaUploadOperationState) this.f12238a.a(str);
        if (mediaUploadOperationState == MediaUploadOperationState.FINISHED || mediaUploadOperationState == MediaUploadOperationState.CANCELED) {
            z = false;
        } else {
            this.f12238a.a(str, MediaUploadOperationState.CANCELED);
            z = true;
        }
        return z;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.facebook.messaging.media.upload.util.MediaUploadStateHelper m12723a(com.facebook.inject.InjectorLike r7) {
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
        r4 = r3.b();	 Catch:{ all -> 0x006b }
        r1 = f12237b;	 Catch:{ all -> 0x006b }
        r1 = r4.get(r1);	 Catch:{ all -> 0x006b }
        r5 = com.facebook.auth.userscope.UserScope.a;	 Catch:{ all -> 0x006b }
        if (r1 != r5) goto L_0x0035;
    L_0x0030:
        r3.c();
        r0 = 0;
    L_0x0034:
        return r0;
    L_0x0035:
        if (r1 != 0) goto L_0x007b;
    L_0x0037:
        r1 = 4;
        r5 = r2.b(r1);	 Catch:{  }
        r6 = r0.a(r3);	 Catch:{ all -> 0x0066 }
        r6.e();	 Catch:{ all -> 0x0061 }
        r1 = m12722a();	 Catch:{ all -> 0x0061 }
        com.facebook.auth.userscope.UserScope.a(r6);	 Catch:{  }
        if (r1 != 0) goto L_0x0070;
    L_0x004c:
        r0 = f12237b;	 Catch:{  }
        r6 = com.facebook.auth.userscope.UserScope.a;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r6);	 Catch:{  }
        r0 = (com.facebook.messaging.media.upload.util.MediaUploadStateHelper) r0;	 Catch:{  }
    L_0x0056:
        if (r0 == 0) goto L_0x0079;
    L_0x0058:
        r2.c(r5);	 Catch:{  }
    L_0x005b:
        r0 = (com.facebook.messaging.media.upload.util.MediaUploadStateHelper) r0;	 Catch:{  }
        r3.c();
        goto L_0x0034;
    L_0x0061:
        r0 = move-exception;
        com.facebook.auth.userscope.UserScope.a(r6);	 Catch:{  }
        throw r0;	 Catch:{  }
    L_0x0066:
        r0 = move-exception;
        r2.c(r5);	 Catch:{  }
        throw r0;	 Catch:{  }
    L_0x006b:
        r0 = move-exception;
        r3.c();
        throw r0;
    L_0x0070:
        r0 = f12237b;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r1);	 Catch:{  }
        r0 = (com.facebook.messaging.media.upload.util.MediaUploadStateHelper) r0;	 Catch:{  }
        goto L_0x0056;
    L_0x0079:
        r0 = r1;
        goto L_0x0058;
    L_0x007b:
        r0 = r1;
        goto L_0x005b;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.media.upload.util.MediaUploadStateHelper.a(com.facebook.inject.InjectorLike):com.facebook.messaging.media.upload.util.MediaUploadStateHelper");
    }

    public final synchronized boolean m12725b(String str) {
        boolean z;
        if (m12727d(str)) {
            z = false;
        } else {
            this.f12238a.a(str, MediaUploadOperationState.RUNNING);
            z = true;
        }
        return z;
    }

    public final synchronized boolean m12726c(String str) {
        boolean z;
        if (m12727d(str)) {
            z = false;
        } else {
            this.f12238a.a(str, MediaUploadOperationState.FINISHED);
            z = true;
        }
        return z;
    }

    public final synchronized boolean m12727d(String str) {
        boolean z;
        if (this.f12238a.a(str) == MediaUploadOperationState.CANCELED) {
            z = true;
        } else {
            z = false;
        }
        return z;
    }
}
