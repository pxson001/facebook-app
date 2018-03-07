package com.facebook.imagepipeline.producers;

import com.facebook.cache.common.CacheKey;
import com.facebook.imagepipeline.cache.CacheKeyFactory;
import com.facebook.imagepipeline.cache.DefaultCacheKeyFactory;
import com.facebook.imagepipeline.cache.MemoryCache;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.memory.PooledByteBuffer;

/* compiled from: memory_cache_entries */
public class EncodedMemoryCacheProducer implements Producer<EncodedImage> {
    public final MemoryCache<CacheKey, PooledByteBuffer> f14460a;
    private final DefaultCacheKeyFactory f14461b;
    private final Producer<EncodedImage> f14462c;

    public EncodedMemoryCacheProducer(MemoryCache<CacheKey, PooledByteBuffer> memoryCache, CacheKeyFactory cacheKeyFactory, Producer<EncodedImage> producer) {
        this.f14460a = memoryCache;
        this.f14461b = cacheKeyFactory;
        this.f14462c = producer;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void mo2774a(com.facebook.imagepipeline.producers.Consumer<com.facebook.imagepipeline.image.EncodedImage> r8, com.facebook.imagepipeline.producers.ProducerContext r9) {
        /*
        r7 = this;
        r0 = 0;
        r1 = r9.m20857b();
        r2 = r9.m20859c();
        r3 = "EncodedMemoryCacheProducer";
        r2.mo2106a(r1, r3);
        r3 = r9.m20853a();
        r4 = r7.f14461b;
        r3 = r4.mo2040a(r3);
        r4 = r7.f14460a;
        r4 = r4.mo2071a(r3);
        if (r4 == 0) goto L_0x0052;
    L_0x0020:
        r3 = new com.facebook.imagepipeline.image.EncodedImage;	 Catch:{ all -> 0x004d }
        r3.<init>(r4);	 Catch:{ all -> 0x004d }
        r5 = "EncodedMemoryCacheProducer";
        r6 = r2.mo2110a(r1);	 Catch:{ all -> 0x0048 }
        if (r6 == 0) goto L_0x0035;
    L_0x002d:
        r0 = "cached_value_found";
        r6 = "true";
        r0 = com.facebook.common.internal.ImmutableMap.m3306a(r0, r6);	 Catch:{ all -> 0x0048 }
    L_0x0035:
        r2.mo2109a(r1, r5, r0);	 Catch:{ all -> 0x0048 }
        r0 = 1065353216; // 0x3f800000 float:1.0 double:5.263544247E-315;
        r8.m20905a(r0);	 Catch:{ all -> 0x0048 }
        r0 = 1;
        r8.m20910b(r3, r0);	 Catch:{ all -> 0x0048 }
        com.facebook.imagepipeline.image.EncodedImage.m15704d(r3);	 Catch:{  }
        com.facebook.common.references.CloseableReference.m15681c(r4);
    L_0x0047:
        return;
    L_0x0048:
        r0 = move-exception;
        com.facebook.imagepipeline.image.EncodedImage.m15704d(r3);	 Catch:{  }
        throw r0;	 Catch:{  }
    L_0x004d:
        r0 = move-exception;
        com.facebook.common.references.CloseableReference.m15681c(r4);
        throw r0;
    L_0x0052:
        r5 = r9.m20861e();	 Catch:{  }
        r5 = r5.getValue();	 Catch:{  }
        r6 = com.facebook.imagepipeline.request.ImageRequest.RequestLevel.ENCODED_MEMORY_CACHE;	 Catch:{  }
        r6 = r6.getValue();	 Catch:{  }
        if (r5 < r6) goto L_0x007e;
    L_0x0062:
        r3 = "EncodedMemoryCacheProducer";
        r5 = r2.mo2110a(r1);	 Catch:{  }
        if (r5 == 0) goto L_0x0072;
    L_0x006a:
        r0 = "cached_value_found";
        r5 = "false";
        r0 = com.facebook.common.internal.ImmutableMap.m3306a(r0, r5);	 Catch:{  }
    L_0x0072:
        r2.mo2109a(r1, r3, r0);	 Catch:{  }
        r0 = 0;
        r1 = 1;
        r8.m20910b(r0, r1);	 Catch:{  }
        com.facebook.common.references.CloseableReference.m15681c(r4);
        goto L_0x0047;
    L_0x007e:
        r5 = new com.facebook.imagepipeline.producers.EncodedMemoryCacheProducer$1;	 Catch:{  }
        r5.<init>(r7, r8, r3);	 Catch:{  }
        r3 = "EncodedMemoryCacheProducer";
        r6 = r2.mo2110a(r1);	 Catch:{  }
        if (r6 == 0) goto L_0x0093;
    L_0x008b:
        r0 = "cached_value_found";
        r6 = "false";
        r0 = com.facebook.common.internal.ImmutableMap.m3306a(r0, r6);	 Catch:{  }
    L_0x0093:
        r2.mo2109a(r1, r3, r0);	 Catch:{  }
        r0 = r7.f14462c;	 Catch:{  }
        r0.mo2774a(r5, r9);	 Catch:{  }
        com.facebook.common.references.CloseableReference.m15681c(r4);
        goto L_0x0047;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.imagepipeline.producers.EncodedMemoryCacheProducer.a(com.facebook.imagepipeline.producers.BaseConsumer, com.facebook.imagepipeline.producers.BaseProducerContext):void");
    }
}
