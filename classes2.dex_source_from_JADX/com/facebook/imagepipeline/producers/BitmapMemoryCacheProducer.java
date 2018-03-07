package com.facebook.imagepipeline.producers;

import com.facebook.cache.common.CacheKey;
import com.facebook.common.internal.ImmutableMap;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.cache.CacheKeyFactory;
import com.facebook.imagepipeline.cache.DefaultCacheKeyFactory;
import com.facebook.imagepipeline.cache.MemoryCache;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.image.ImmutableQualityInfo;
import com.facebook.imagepipeline.request.ImageRequest.RequestLevel;
import java.util.Map;

/* compiled from: megaphone_location */
public class BitmapMemoryCacheProducer implements Producer<CloseableReference<CloseableImage>> {
    public final MemoryCache<CacheKey, CloseableImage> f14474a;
    private final DefaultCacheKeyFactory f14475b;
    private final Producer<CloseableReference<CloseableImage>> f14476c;

    public BitmapMemoryCacheProducer(MemoryCache<CacheKey, CloseableImage> memoryCache, CacheKeyFactory cacheKeyFactory, Producer<CloseableReference<CloseableImage>> producer) {
        this.f14474a = memoryCache;
        this.f14475b = cacheKeyFactory;
        this.f14476c = producer;
    }

    public final void mo2774a(Consumer<CloseableReference<CloseableImage>> consumer, ProducerContext producerContext) {
        Map map = null;
        ProducerListener producerListener = producerContext.f14482c;
        String str = producerContext.f14481b;
        producerListener.mo2106a(str, mo2778a());
        CacheKey a = this.f14475b.m15876a(producerContext.f14480a, producerContext.f14483d);
        CloseableReference a2 = this.f14474a.mo2071a((Object) a);
        if (a2 != null) {
            boolean z = ((CloseableImage) a2.m15682a()).mo2983d().f17882d;
            if (z) {
                producerListener.mo2109a(str, mo2778a(), producerListener.mo2110a(str) ? ImmutableMap.m3306a("cached_value_found", "true") : null);
                consumer.m20905a(1.0f);
            }
            consumer.m20910b(a2, z);
            a2.close();
            if (z) {
                return;
            }
        }
        if (producerContext.f14484e.getValue() >= RequestLevel.BITMAP_MEMORY_CACHE.getValue()) {
            Map a3;
            String a4 = mo2778a();
            if (producerListener.mo2110a(str)) {
                a3 = ImmutableMap.m3306a("cached_value_found", "false");
            } else {
                a3 = null;
            }
            producerListener.mo2109a(str, a4, a3);
            consumer.m20910b(null, true);
            return;
        }
        BaseConsumer a5 = mo2777a((BaseConsumer) consumer, a);
        a4 = mo2778a();
        if (producerListener.mo2110a(str)) {
            map = ImmutableMap.m3306a("cached_value_found", "false");
        }
        producerListener.mo2109a(str, a4, map);
        this.f14476c.mo2774a(a5, producerContext);
    }

    protected Consumer<CloseableReference<CloseableImage>> mo2777a(Consumer<CloseableReference<CloseableImage>> consumer, final CacheKey cacheKey) {
        return new DelegatingConsumer<CloseableReference<CloseableImage>, CloseableReference<CloseableImage>>(this, consumer) {
            final /* synthetic */ BitmapMemoryCacheProducer f14614b;

            public final void mo2788a(Object obj, boolean z) {
                CloseableReference a;
                obj = (CloseableReference) obj;
                if (obj == null) {
                    if (z) {
                        m21033d().m20910b(null, true);
                    }
                } else if (((CloseableImage) obj.m15682a()).mo2992e()) {
                    m21033d().m20910b(obj, z);
                } else {
                    if (!z) {
                        a = this.f14614b.f14474a.mo2071a(cacheKey);
                        if (a != null) {
                            try {
                                ImmutableQualityInfo d = ((CloseableImage) obj.m15682a()).mo2983d();
                                ImmutableQualityInfo d2 = ((CloseableImage) a.m15682a()).mo2983d();
                                if (d2.m25104c() || d2.m25102a() >= d.m25102a()) {
                                    m21033d().m20910b(a, false);
                                    return;
                                }
                                CloseableReference.m15681c(a);
                            } finally {
                                CloseableReference.m15681c(a);
                            }
                        }
                    }
                    a = this.f14614b.f14474a.mo2072a(cacheKey, obj);
                    if (z) {
                        try {
                            m21033d().m20905a(1.0f);
                        } catch (Throwable th) {
                            CloseableReference.m15681c(a);
                        }
                    }
                    BaseConsumer d3 = m21033d();
                    if (a != null) {
                        obj = a;
                    }
                    d3.m20910b(obj, z);
                    CloseableReference.m15681c(a);
                }
            }
        };
    }

    protected String mo2778a() {
        return "BitmapMemoryCacheProducer";
    }
}
