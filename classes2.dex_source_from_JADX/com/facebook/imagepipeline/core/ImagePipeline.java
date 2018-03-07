package com.facebook.imagepipeline.core;

import android.net.Uri;
import com.android.internal.util.Predicate;
import com.facebook.cache.common.CacheKey;
import com.facebook.common.internal.Objects;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.Supplier;
import com.facebook.common.references.CloseableReference;
import com.facebook.common.util.UriUtil;
import com.facebook.datasource.DataSource;
import com.facebook.datasource.DataSources;
import com.facebook.datasource.SimpleDataSource;
import com.facebook.imagepipeline.cache.BufferedDiskCache;
import com.facebook.imagepipeline.cache.CacheKeyFactory;
import com.facebook.imagepipeline.cache.DefaultCacheKeyFactory;
import com.facebook.imagepipeline.cache.MemoryCache;
import com.facebook.imagepipeline.common.Priority;
import com.facebook.imagepipeline.datasource.CloseableProducerToDataSourceAdapter;
import com.facebook.imagepipeline.datasource.ProducerToDataSourceAdapter;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.listener.ForwardingRequestListener;
import com.facebook.imagepipeline.listener.RequestListener;
import com.facebook.imagepipeline.memory.PooledByteBuffer;
import com.facebook.imagepipeline.producers.Producer;
import com.facebook.imagepipeline.producers.ProducerListener;
import com.facebook.imagepipeline.producers.SettableProducerContext;
import com.facebook.imagepipeline.producers.ThreadHandoffProducerQueue;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequest.RequestLevel;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicLong;
import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
/* compiled from: orca_ticker_updates */
public class ImagePipeline {
    private static final CancellationException f10841a = new CancellationException("Prefetching is not enabled");
    private final ProducerSequenceFactory f10842b;
    private final RequestListener f10843c;
    private final Supplier<Boolean> f10844d;
    public final MemoryCache<CacheKey, CloseableImage> f10845e;
    public final MemoryCache<CacheKey, PooledByteBuffer> f10846f;
    private final BufferedDiskCache f10847g;
    public final BufferedDiskCache f10848h;
    private final DefaultCacheKeyFactory f10849i;
    private final ThreadHandoffProducerQueue f10850j;
    private AtomicLong f10851k = new AtomicLong();

    public ImagePipeline(ProducerSequenceFactory producerSequenceFactory, Set<RequestListener> set, Supplier<Boolean> supplier, MemoryCache<CacheKey, CloseableImage> memoryCache, MemoryCache<CacheKey, PooledByteBuffer> memoryCache2, BufferedDiskCache bufferedDiskCache, BufferedDiskCache bufferedDiskCache2, CacheKeyFactory cacheKeyFactory, ThreadHandoffProducerQueue threadHandoffProducerQueue) {
        this.f10842b = producerSequenceFactory;
        this.f10843c = new ForwardingRequestListener(set);
        this.f10844d = supplier;
        this.f10845e = memoryCache;
        this.f10846f = memoryCache2;
        this.f10847g = bufferedDiskCache;
        this.f10848h = bufferedDiskCache2;
        this.f10849i = cacheKeyFactory;
        this.f10850j = threadHandoffProducerQueue;
    }

    private String m16063b() {
        return String.valueOf(this.f10851k.getAndIncrement());
    }

    public final Supplier<DataSource<CloseableReference<CloseableImage>>> m16065a(final ImageRequest imageRequest, final Object obj, final boolean z) {
        return new Supplier<DataSource<CloseableReference<CloseableImage>>>(this) {
            final /* synthetic */ ImagePipeline f14344d;

            public final Object mo2058a() {
                if (z) {
                    return this.f14344d.m16070b(imageRequest, obj);
                }
                return this.f14344d.m16073c(imageRequest, obj);
            }

            public String toString() {
                return Objects.m20537a((Object) this).m20544a("uri", (Object) imageRequest.f12746c).toString();
            }
        };
    }

    public final DataSource<CloseableReference<CloseableImage>> m16070b(ImageRequest imageRequest, Object obj) {
        try {
            return m16061a(this.f10842b.m16098c(imageRequest), imageRequest, RequestLevel.BITMAP_MEMORY_CACHE, obj);
        } catch (Throwable e) {
            return DataSources.a(e);
        }
    }

    public final DataSource<CloseableReference<CloseableImage>> m16073c(ImageRequest imageRequest, Object obj) {
        try {
            return m16061a(this.f10842b.m16098c(imageRequest), imageRequest, RequestLevel.FULL_FETCH, obj);
        } catch (Throwable e) {
            return DataSources.a(e);
        }
    }

    public final DataSource<CloseableReference<PooledByteBuffer>> m16074d(ImageRequest imageRequest, Object obj) {
        Preconditions.a(imageRequest.m18798b());
        try {
            Producer a = this.f10842b.m16096a(imageRequest);
            if (imageRequest.m18799e() != null) {
                imageRequest = ImageRequestBuilder.m18777a(imageRequest).m18780a(null).m18785m();
            }
            return m16061a(a, imageRequest, RequestLevel.FULL_FETCH, obj);
        } catch (Throwable e) {
            return DataSources.a(e);
        }
    }

    public final DataSource<Void> m16075e(ImageRequest imageRequest, Object obj) {
        if (!((Boolean) this.f10844d.mo2058a()).booleanValue()) {
            return DataSources.a(f10841a);
        }
        try {
            return m16062a(this.f10842b.m16099d(imageRequest), imageRequest, RequestLevel.FULL_FETCH, obj, Priority.LOW);
        } catch (Throwable e) {
            return DataSources.a(e);
        }
    }

    public final DataSource<Void> m16076f(ImageRequest imageRequest, Object obj) {
        return m16066a(imageRequest, obj, Priority.LOW);
    }

    public final DataSource<Void> m16066a(ImageRequest imageRequest, Object obj, Priority priority) {
        if (!((Boolean) this.f10844d.mo2058a()).booleanValue()) {
            return DataSources.a(f10841a);
        }
        try {
            return m16062a(this.f10842b.m16097b(imageRequest), imageRequest, RequestLevel.FULL_FETCH, obj, priority);
        } catch (Throwable e) {
            return DataSources.a(e);
        }
    }

    public final void m16067a(Uri uri) {
        Predicate d = m16064d(uri);
        this.f10845e.mo2070a(d);
        this.f10846f.mo2070a(d);
    }

    public final boolean m16071b(Uri uri) {
        return this.f10845e.mo2073b(m16064d(uri));
    }

    public final boolean m16068a(ImageRequest imageRequest) {
        CloseableReference a = this.f10845e.mo2071a(this.f10849i.m15876a(imageRequest, null));
        try {
            boolean a2 = CloseableReference.m15679a(a);
            return a2;
        } finally {
            CloseableReference.m15681c(a);
        }
    }

    public final DataSource<Boolean> m16072c(Uri uri) {
        return m16069b(ImageRequest.m18795a(uri));
    }

    public final DataSource<Boolean> m16069b(ImageRequest imageRequest) {
        CacheKey a = this.f10849i.mo2040a(imageRequest);
        SimpleDataSource h = SimpleDataSource.h();
        this.f10847g.m16186b(a).m21085b(new 5(this, a)).m21083a(new 4(this, h));
        return h;
    }

    private <T> DataSource<CloseableReference<T>> m16061a(Producer<CloseableReference<T>> producer, ImageRequest imageRequest, RequestLevel requestLevel, Object obj) {
        boolean z = false;
        try {
            RequestLevel max = RequestLevel.getMax(imageRequest.m18802k(), requestLevel);
            String b = m16063b();
            ProducerListener producerListener = this.f10843c;
            if (imageRequest.m18800h() || !UriUtil.m18788a(imageRequest.m18798b())) {
                z = true;
            }
            return CloseableProducerToDataSourceAdapter.m20866a(producer, new SettableProducerContext(imageRequest, b, producerListener, obj, max, false, z, imageRequest.m18801j()), this.f10843c);
        } catch (Throwable e) {
            return DataSources.a(e);
        }
    }

    private DataSource<Void> m16062a(Producer<Void> producer, ImageRequest imageRequest, RequestLevel requestLevel, Object obj, Priority priority) {
        try {
            return ProducerToDataSourceAdapter.a(producer, new SettableProducerContext(imageRequest, m16063b(), this.f10843c, obj, RequestLevel.getMax(imageRequest.m18802k(), requestLevel), true, false, priority), this.f10843c);
        } catch (Throwable e) {
            return DataSources.a(e);
        }
    }

    private Predicate<CacheKey> m16064d(Uri uri) {
        return new 6(this, uri);
    }
}
