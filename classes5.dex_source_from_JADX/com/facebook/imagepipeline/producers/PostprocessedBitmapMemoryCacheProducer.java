package com.facebook.imagepipeline.producers;

import com.facebook.cache.common.CacheKey;
import com.facebook.common.internal.ImmutableMap;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.cache.CacheKeyFactory;
import com.facebook.imagepipeline.cache.DefaultCacheKeyFactory;
import com.facebook.imagepipeline.cache.MemoryCache;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.request.BaseRepeatedPostProcessor;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.Postprocessor;
import java.util.Map;

/* compiled from: TOPIC_MEDIA */
public class PostprocessedBitmapMemoryCacheProducer implements Producer<CloseableReference<CloseableImage>> {
    private final MemoryCache<CacheKey, CloseableImage> f13799a;
    private final DefaultCacheKeyFactory f13800b;
    private final Producer<CloseableReference<CloseableImage>> f13801c;

    /* compiled from: TOPIC_MEDIA */
    public class CachedPostprocessorConsumer extends DelegatingConsumer<CloseableReference<CloseableImage>, CloseableReference<CloseableImage>> {
        private final CacheKey f13796a;
        private final boolean f13797b;
        private final MemoryCache<CacheKey, CloseableImage> f13798c;

        protected final void m23165a(Object obj, boolean z) {
            obj = (CloseableReference) obj;
            if (obj == null) {
                if (z) {
                    d().b(null, true);
                }
            } else if (z || this.f13797b) {
                CloseableReference a = this.f13798c.a(this.f13796a, obj);
                try {
                    d().a(1.0f);
                    BaseConsumer d = d();
                    if (a != null) {
                        obj = a;
                    }
                    d.b(obj, z);
                } finally {
                    CloseableReference.c(a);
                }
            }
        }

        public CachedPostprocessorConsumer(Consumer<CloseableReference<CloseableImage>> consumer, CacheKey cacheKey, boolean z, MemoryCache<CacheKey, CloseableImage> memoryCache) {
            super(consumer);
            this.f13796a = cacheKey;
            this.f13797b = z;
            this.f13798c = memoryCache;
        }
    }

    public PostprocessedBitmapMemoryCacheProducer(MemoryCache<CacheKey, CloseableImage> memoryCache, CacheKeyFactory cacheKeyFactory, Producer<CloseableReference<CloseableImage>> producer) {
        this.f13799a = memoryCache;
        this.f13800b = cacheKeyFactory;
        this.f13801c = producer;
    }

    public final void m23166a(Consumer<CloseableReference<CloseableImage>> consumer, ProducerContext producerContext) {
        Map map = null;
        ProducerListener producerListener = producerContext.c;
        String str = producerContext.b;
        ImageRequest imageRequest = producerContext.a;
        Object obj = producerContext.d;
        Postprocessor postprocessor = imageRequest.l;
        if (postprocessor == null || postprocessor.b() == null) {
            this.f13801c.a(consumer, producerContext);
            return;
        }
        producerListener.a(str, "PostprocessedBitmapMemoryCacheProducer");
        CacheKey b = this.f13800b.b(imageRequest, obj);
        CloseableReference a = this.f13799a.a(b);
        if (a != null) {
            String str2 = "PostprocessedBitmapMemoryCacheProducer";
            if (producerListener.a(str)) {
                map = ImmutableMap.a("cached_value_found", "true");
            }
            producerListener.a(str, str2, map);
            consumer.a(1.0f);
            consumer.b(a, true);
            a.close();
            return;
        }
        CachedPostprocessorConsumer cachedPostprocessorConsumer = new CachedPostprocessorConsumer(consumer, b, postprocessor instanceof BaseRepeatedPostProcessor, this.f13799a);
        str2 = "PostprocessedBitmapMemoryCacheProducer";
        if (producerListener.a(str)) {
            map = ImmutableMap.a("cached_value_found", "false");
        }
        producerListener.a(str, str2, map);
        this.f13801c.a(cachedPostprocessorConsumer, producerContext);
    }
}
