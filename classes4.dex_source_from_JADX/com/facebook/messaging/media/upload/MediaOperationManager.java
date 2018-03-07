package com.facebook.messaging.media.upload;

import com.facebook.auth.userscope.UserScoped;
import com.facebook.fbservice.ops.BlueServiceOperationFactory.OperationFuture;
import com.facebook.messaging.media.upload.util.MediaUploadKey;
import com.facebook.ui.media.attachments.MediaResource;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.collect.HashMultimap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.SetMultimap;
import com.google.common.util.concurrent.MoreExecutors;
import java.util.Iterator;
import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.ThreadSafe;

@UserScoped
@ThreadSafe
/* compiled from: mInsetB */
public class MediaOperationManager {
    private static final Object f8681d = new Object();
    @GuardedBy("this")
    private final SetMultimap<MediaUploadKey, OperationFuture> f8682a = HashMultimap.u();
    @GuardedBy("this")
    private final SetMultimap<String, MediaUploadKey> f8683b = HashMultimap.u();
    @GuardedBy("this")
    private final SetMultimap<MediaUploadKey, String> f8684c = HashMultimap.u();

    private static MediaOperationManager m8940a() {
        return new MediaOperationManager();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.facebook.messaging.media.upload.MediaOperationManager m8941a(com.facebook.inject.InjectorLike r7) {
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
        r1 = f8681d;	 Catch:{ all -> 0x006b }
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
        r1 = m8940a();	 Catch:{ all -> 0x0061 }
        com.facebook.auth.userscope.UserScope.a(r6);	 Catch:{  }
        if (r1 != 0) goto L_0x0070;
    L_0x004c:
        r0 = f8681d;	 Catch:{  }
        r6 = com.facebook.auth.userscope.UserScope.a;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r6);	 Catch:{  }
        r0 = (com.facebook.messaging.media.upload.MediaOperationManager) r0;	 Catch:{  }
    L_0x0056:
        if (r0 == 0) goto L_0x0079;
    L_0x0058:
        r2.c(r5);	 Catch:{  }
    L_0x005b:
        r0 = (com.facebook.messaging.media.upload.MediaOperationManager) r0;	 Catch:{  }
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
        r0 = f8681d;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r1);	 Catch:{  }
        r0 = (com.facebook.messaging.media.upload.MediaOperationManager) r0;	 Catch:{  }
        goto L_0x0056;
    L_0x0079:
        r0 = r1;
        goto L_0x0058;
    L_0x007b:
        r0 = r1;
        goto L_0x005b;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.media.upload.MediaOperationManager.a(com.facebook.inject.InjectorLike):com.facebook.messaging.media.upload.MediaOperationManager");
    }

    public final synchronized void m8951a(MediaResource mediaResource, OperationFuture operationFuture) {
        MediaUploadKey a = MediaUploadKey.a(mediaResource);
        String str = mediaResource.m;
        this.f8682a.a(a, operationFuture);
        m8948c(a, str);
        operationFuture.a(new 1(this, a, operationFuture), MoreExecutors.a());
    }

    public final synchronized void m8950a(MediaResource mediaResource) {
        MediaUploadKey a = MediaUploadKey.a(mediaResource);
        if (!m8942a(a).isEmpty()) {
            m8948c(a, mediaResource.m);
        }
    }

    public final void m8952a(String str) {
        for (MediaUploadKey a : m8947b(str)) {
            m8944a(a, str);
        }
    }

    public final void m8953b(MediaResource mediaResource) {
        m8944a(MediaUploadKey.a(mediaResource), mediaResource.m);
    }

    private void m8944a(MediaUploadKey mediaUploadKey, String str) {
        Iterator it = m8946b(mediaUploadKey, str).iterator();
        while (it.hasNext()) {
            ((OperationFuture) it.next()).f();
        }
    }

    private synchronized ImmutableSet<OperationFuture> m8946b(MediaUploadKey mediaUploadKey, String str) {
        ImmutableSet<OperationFuture> of;
        of = ImmutableSet.of();
        m8949d(mediaUploadKey, str);
        if (m8945b(mediaUploadKey).isEmpty()) {
            of = m8942a(mediaUploadKey);
        }
        return of;
    }

    private synchronized void m8948c(MediaUploadKey mediaUploadKey, String str) {
        this.f8684c.a(mediaUploadKey, str);
        this.f8683b.a(str, mediaUploadKey);
    }

    private synchronized void m8949d(MediaUploadKey mediaUploadKey, String str) {
        this.f8684c.c(mediaUploadKey, str);
        this.f8683b.c(str, mediaUploadKey);
    }

    public static synchronized void m8943a(MediaOperationManager mediaOperationManager, MediaUploadKey mediaUploadKey, OperationFuture operationFuture) {
        synchronized (mediaOperationManager) {
            mediaOperationManager.f8682a.c(mediaUploadKey, operationFuture);
            if (mediaOperationManager.m8942a(mediaUploadKey).isEmpty()) {
                for (String c : mediaOperationManager.f8684c.b(mediaUploadKey)) {
                    mediaOperationManager.f8683b.c(c, mediaUploadKey);
                }
            }
        }
    }

    @VisibleForTesting
    private synchronized ImmutableSet<OperationFuture> m8942a(MediaUploadKey mediaUploadKey) {
        return ImmutableSet.copyOf(this.f8682a.a(mediaUploadKey));
    }

    @VisibleForTesting
    private synchronized ImmutableSet<String> m8945b(MediaUploadKey mediaUploadKey) {
        return ImmutableSet.copyOf(this.f8684c.a(mediaUploadKey));
    }

    @VisibleForTesting
    private synchronized ImmutableSet<MediaUploadKey> m8947b(String str) {
        return ImmutableSet.copyOf(this.f8683b.a(str));
    }
}
