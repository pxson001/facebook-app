package com.facebook.messaging.media.upload;

import com.facebook.auth.userscope.UserScoped;
import com.facebook.messaging.media.upload.util.MediaUploadKey;
import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.RemovalListener;
import com.google.common.cache.RemovalNotification;
import com.google.common.collect.Maps;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;

@UserScoped
/* compiled from: mInsetL */
public class MediaUploadCache {
    private static final Object f8677c = new Object();
    @GuardedBy("this")
    private final Cache<MediaUploadKey, MediaItemUploadStatus> f8678a = CacheBuilder.newBuilder().a(2073600000, TimeUnit.MILLISECONDS).a(new C04151(this)).q();
    @GuardedBy("this")
    private final Map<String, MediaUploadKey> f8679b = Maps.c();

    /* compiled from: mInsetL */
    class C04151 implements RemovalListener<MediaUploadKey, MediaItemUploadStatus> {
        final /* synthetic */ MediaUploadCache f8680a;

        C04151(MediaUploadCache mediaUploadCache) {
            this.f8680a = mediaUploadCache;
        }

        public void onRemoval(RemovalNotification<MediaUploadKey, MediaItemUploadStatus> removalNotification) {
            MediaUploadCache.m8933a(this.f8680a, (MediaItemUploadStatus) removalNotification.getValue());
        }
    }

    private static MediaUploadCache m8934b() {
        return new MediaUploadCache();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.facebook.messaging.media.upload.MediaUploadCache m8932a(com.facebook.inject.InjectorLike r7) {
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
        r1 = f8677c;	 Catch:{ all -> 0x006b }
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
        r1 = m8934b();	 Catch:{ all -> 0x0061 }
        com.facebook.auth.userscope.UserScope.a(r6);	 Catch:{  }
        if (r1 != 0) goto L_0x0070;
    L_0x004c:
        r0 = f8677c;	 Catch:{  }
        r6 = com.facebook.auth.userscope.UserScope.a;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r6);	 Catch:{  }
        r0 = (com.facebook.messaging.media.upload.MediaUploadCache) r0;	 Catch:{  }
    L_0x0056:
        if (r0 == 0) goto L_0x0079;
    L_0x0058:
        r2.c(r5);	 Catch:{  }
    L_0x005b:
        r0 = (com.facebook.messaging.media.upload.MediaUploadCache) r0;	 Catch:{  }
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
        r0 = f8677c;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r1);	 Catch:{  }
        r0 = (com.facebook.messaging.media.upload.MediaUploadCache) r0;	 Catch:{  }
        goto L_0x0056;
    L_0x0079:
        r0 = r1;
        goto L_0x0058;
    L_0x007b:
        r0 = r1;
        goto L_0x005b;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.media.upload.MediaUploadCache.a(com.facebook.inject.InjectorLike):com.facebook.messaging.media.upload.MediaUploadCache");
    }

    @Nullable
    public final synchronized MediaItemUploadStatus m8935a(MediaUploadKey mediaUploadKey) {
        return (MediaItemUploadStatus) this.f8678a.a(mediaUploadKey);
    }

    public final synchronized void m8937a(MediaUploadKey mediaUploadKey, MediaItemUploadStatus mediaItemUploadStatus) {
        this.f8678a.a(mediaUploadKey, mediaItemUploadStatus);
        if (mediaItemUploadStatus.c != null) {
            this.f8679b.put(mediaItemUploadStatus.c, mediaUploadKey);
        }
    }

    public final synchronized boolean m8939b(MediaUploadKey mediaUploadKey, MediaItemUploadStatus mediaItemUploadStatus) {
        boolean z;
        MediaItemUploadStatus a = m8935a(mediaUploadKey);
        if (a == null || a.b != mediaItemUploadStatus.b) {
            m8937a(mediaUploadKey, mediaItemUploadStatus);
            z = true;
        } else {
            z = false;
        }
        return z;
    }

    public final synchronized void m8938a(Set<String> set) {
        for (String str : set) {
            MediaUploadKey mediaUploadKey = (MediaUploadKey) this.f8679b.get(str);
            if (mediaUploadKey != null) {
                this.f8678a.b(mediaUploadKey);
            }
        }
    }

    final synchronized Set<Entry<MediaUploadKey, MediaItemUploadStatus>> m8936a() {
        return this.f8678a.b().entrySet();
    }

    public static synchronized void m8933a(MediaUploadCache mediaUploadCache, MediaItemUploadStatus mediaItemUploadStatus) {
        synchronized (mediaUploadCache) {
            if (mediaItemUploadStatus.c != null) {
                mediaUploadCache.f8679b.remove(mediaItemUploadStatus.c);
            }
        }
    }
}
