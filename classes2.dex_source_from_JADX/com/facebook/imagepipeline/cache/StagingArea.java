package com.facebook.imagepipeline.cache;

import com.facebook.cache.common.CacheKey;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.logging.FLog;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.image.EncodedImage;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: onthisday?source=%s */
public class StagingArea {
    private static final Class<?> f11030a = StagingArea.class;
    @GuardedBy("this")
    private Map<CacheKey, EncodedImage> f11031b = new HashMap();

    public final synchronized void m16349a(CacheKey cacheKey, EncodedImage encodedImage) {
        Preconditions.a(cacheKey);
        Preconditions.a(EncodedImage.m15705e(encodedImage));
        EncodedImage.m15704d((EncodedImage) this.f11031b.put(cacheKey, EncodedImage.m15702a(encodedImage)));
        m16347b();
    }

    public final synchronized boolean m16351b(CacheKey cacheKey, EncodedImage encodedImage) {
        boolean z;
        Preconditions.a(cacheKey);
        Preconditions.a(encodedImage);
        Preconditions.a(EncodedImage.m15705e(encodedImage));
        EncodedImage encodedImage2 = (EncodedImage) this.f11031b.get(cacheKey);
        if (encodedImage2 == null) {
            z = false;
        } else {
            CloseableReference a = encodedImage2.m15708a();
            CloseableReference a2 = encodedImage.m15708a();
            if (!(a == null || a2 == null)) {
                try {
                    if (a.m15682a() == a2.m15682a()) {
                        this.f11031b.remove(cacheKey);
                        m16347b();
                        z = true;
                    }
                } finally {
                    CloseableReference.m15681c(a2);
                    CloseableReference.m15681c(a);
                    EncodedImage.m15704d(encodedImage2);
                }
            }
            CloseableReference.m15681c(a2);
            CloseableReference.m15681c(a);
            EncodedImage.m15704d(encodedImage2);
            z = false;
        }
        return z;
    }

    public final synchronized EncodedImage m16348a(CacheKey cacheKey) {
        EncodedImage encodedImage;
        Preconditions.a(cacheKey);
        encodedImage = (EncodedImage) this.f11031b.get(cacheKey);
        if (encodedImage != null) {
            synchronized (encodedImage) {
                if (EncodedImage.m15705e(encodedImage)) {
                    EncodedImage a = EncodedImage.m15702a(encodedImage);
                    encodedImage = a;
                } else {
                    this.f11031b.remove(cacheKey);
                    FLog.a(f11030a, "Found closed reference %d for key %s (%d)", new Object[]{Integer.valueOf(System.identityHashCode(encodedImage)), cacheKey.toString(), Integer.valueOf(System.identityHashCode(cacheKey))});
                    encodedImage = null;
                }
            }
        }
        return encodedImage;
    }

    public final synchronized boolean m16350b(CacheKey cacheKey) {
        boolean z;
        Preconditions.a(cacheKey);
        if (this.f11031b.containsKey(cacheKey)) {
            EncodedImage encodedImage = (EncodedImage) this.f11031b.get(cacheKey);
            synchronized (encodedImage) {
                if (EncodedImage.m15705e(encodedImage)) {
                    z = true;
                } else {
                    this.f11031b.remove(cacheKey);
                    FLog.a(f11030a, "Found closed reference %d for key %s (%d)", new Object[]{Integer.valueOf(System.identityHashCode(encodedImage)), cacheKey.toString(), Integer.valueOf(System.identityHashCode(cacheKey))});
                    z = false;
                }
            }
        } else {
            z = false;
        }
        return z;
    }

    private synchronized void m16347b() {
        Integer.valueOf(this.f11031b.size());
    }
}
