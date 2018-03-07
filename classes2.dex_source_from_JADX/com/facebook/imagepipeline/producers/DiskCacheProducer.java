package com.facebook.imagepipeline.producers;

import bolts.Continuation;
import bolts.Task;
import com.facebook.cache.common.CacheKey;
import com.facebook.common.internal.ImmutableMap;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.imagepipeline.cache.BufferedDiskCache;
import com.facebook.imagepipeline.cache.CacheKeyFactory;
import com.facebook.imagepipeline.cache.DefaultCacheKeyFactory;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequest.ImageType;
import com.facebook.imagepipeline.request.ImageRequest.RequestLevel;
import java.util.Map;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: memory_cache_hit */
public class DiskCacheProducer implements Producer<EncodedImage> {
    public final BufferedDiskCache f14454a;
    public final BufferedDiskCache f14455b;
    private final DefaultCacheKeyFactory f14456c;
    private final Producer<EncodedImage> f14457d;
    public final boolean f14458e;
    public final int f14459f;

    /* compiled from: memory_cache_hit */
    class DiskCacheConsumer extends DelegatingConsumer<EncodedImage, EncodedImage> {
        final /* synthetic */ DiskCacheProducer f14704a;
        private final BufferedDiskCache f14705b;
        private final CacheKey f14706c;

        public final void mo2788a(Object obj, boolean z) {
            EncodedImage encodedImage = (EncodedImage) obj;
            if (encodedImage != null && z) {
                if (this.f14704a.f14458e) {
                    int h = encodedImage.m15718h();
                    if (h <= 0 || h >= this.f14704a.f14459f) {
                        this.f14704a.f14454a.m16184a(this.f14706c, encodedImage);
                    } else {
                        this.f14704a.f14455b.m16184a(this.f14706c, encodedImage);
                    }
                } else {
                    this.f14705b.m16184a(this.f14706c, encodedImage);
                }
            }
            this.f14615a.m20910b(encodedImage, z);
        }

        public DiskCacheConsumer(DiskCacheProducer diskCacheProducer, Consumer<EncodedImage> consumer, BufferedDiskCache bufferedDiskCache, CacheKey cacheKey) {
            this.f14704a = diskCacheProducer;
            super(consumer);
            this.f14705b = bufferedDiskCache;
            this.f14706c = cacheKey;
        }
    }

    public DiskCacheProducer(BufferedDiskCache bufferedDiskCache, BufferedDiskCache bufferedDiskCache2, CacheKeyFactory cacheKeyFactory, Producer<EncodedImage> producer, int i) {
        this.f14454a = bufferedDiskCache;
        this.f14455b = bufferedDiskCache2;
        this.f14456c = cacheKeyFactory;
        this.f14457d = producer;
        this.f14459f = i;
        this.f14458e = i > 0;
    }

    public final void mo2774a(Consumer<EncodedImage> consumer, ProducerContext producerContext) {
        ImageRequest imageRequest = producerContext.f14480a;
        if (imageRequest.f12754k) {
            boolean z;
            Task b;
            producerContext.f14482c.mo2106a(producerContext.f14481b, "DiskCacheProducer");
            CacheKey a = this.f14456c.mo2040a(imageRequest);
            if (imageRequest.f12745b == ImageType.SMALL) {
                z = true;
            } else {
                z = false;
            }
            BufferedDiskCache bufferedDiskCache = z ? this.f14455b : this.f14454a;
            final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
            if (this.f14458e) {
                BufferedDiskCache bufferedDiskCache2;
                BufferedDiskCache bufferedDiskCache3;
                boolean a2 = this.f14455b.m16185a(a);
                boolean a3 = this.f14454a.m16185a(a);
                if (a2 || !a3) {
                    bufferedDiskCache2 = this.f14455b;
                    bufferedDiskCache3 = this.f14454a;
                } else {
                    bufferedDiskCache2 = this.f14454a;
                    bufferedDiskCache3 = this.f14455b;
                }
                b = bufferedDiskCache2.m16183a(a, atomicBoolean).m21085b(new 1(this, bufferedDiskCache3, a, atomicBoolean));
            } else {
                b = bufferedDiskCache.m16183a(a, atomicBoolean);
            }
            b.m21083a(m20825a((BaseConsumer) consumer, bufferedDiskCache, a, (BaseProducerContext) producerContext));
            producerContext.m20856a(new BaseProducerContextCallbacks(this) {
                final /* synthetic */ DiskCacheProducer f14691b;

                public final void mo2801a() {
                    atomicBoolean.set(true);
                }
            });
            return;
        }
        m20827a(this, (BaseConsumer) consumer, (BaseConsumer) consumer, (BaseProducerContext) producerContext);
    }

    private Continuation<EncodedImage, Void> m20825a(Consumer<EncodedImage> consumer, BufferedDiskCache bufferedDiskCache, CacheKey cacheKey, ProducerContext producerContext) {
        final String str = producerContext.f14481b;
        final ProducerListener producerListener = producerContext.f14482c;
        final BaseConsumer baseConsumer = consumer;
        final BufferedDiskCache bufferedDiskCache2 = bufferedDiskCache;
        final CacheKey cacheKey2 = cacheKey;
        final BaseProducerContext baseProducerContext = producerContext;
        return new Continuation<EncodedImage, Void>(this) {
            final /* synthetic */ DiskCacheProducer f14685g;

            public final Object mo2823a(Task task) {
                if (DiskCacheProducer.m20828b(task)) {
                    producerListener.mo2112b(str, "DiskCacheProducer", null);
                    baseConsumer.m20908b();
                } else if (task.m21086b()) {
                    producerListener.mo2108a(str, "DiskCacheProducer", task.m21088d(), null);
                    DiskCacheProducer.m20827a(this.f14685g, baseConsumer, new DiskCacheConsumer(this.f14685g, baseConsumer, bufferedDiskCache2, cacheKey2), baseProducerContext);
                } else {
                    EncodedImage encodedImage = (EncodedImage) task.m21087c();
                    if (encodedImage != null) {
                        producerListener.mo2109a(str, "DiskCacheProducer", DiskCacheProducer.m20826a(producerListener, str, true));
                        baseConsumer.m20905a(1.0f);
                        baseConsumer.m20910b(encodedImage, true);
                        encodedImage.close();
                    } else {
                        producerListener.mo2109a(str, "DiskCacheProducer", DiskCacheProducer.m20826a(producerListener, str, false));
                        DiskCacheProducer.m20827a(this.f14685g, baseConsumer, new DiskCacheConsumer(this.f14685g, baseConsumer, bufferedDiskCache2, cacheKey2), baseProducerContext);
                    }
                }
                return null;
            }
        };
    }

    public static void m20827a(DiskCacheProducer diskCacheProducer, BaseConsumer baseConsumer, BaseConsumer baseConsumer2, BaseProducerContext baseProducerContext) {
        if (baseProducerContext.f14484e.getValue() >= RequestLevel.DISK_CACHE.getValue()) {
            baseConsumer.m20910b(null, true);
        } else {
            diskCacheProducer.f14457d.mo2774a(baseConsumer2, baseProducerContext);
        }
    }

    public static boolean m20828b(Task<?> task) {
        return task.m21084a() || (task.m21086b() && (task.m21088d() instanceof CancellationException));
    }

    @VisibleForTesting
    static Map<String, String> m20826a(ProducerListener producerListener, String str, boolean z) {
        if (producerListener.mo2110a(str)) {
            return ImmutableMap.m3306a("cached_value_found", String.valueOf(z));
        }
        return null;
    }
}
