package com.facebook.imagepipeline.core;

import android.net.Uri;
import android.os.Build.VERSION;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.common.media.MediaUtils;
import com.facebook.common.references.CloseableReference;
import com.facebook.common.util.UriUtil;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.memory.PooledByteBuffer;
import com.facebook.imagepipeline.producers.BaseNetworkFetcher;
import com.facebook.imagepipeline.producers.BitmapMemoryCacheGetProducer;
import com.facebook.imagepipeline.producers.BitmapMemoryCacheKeyMultiplexProducer;
import com.facebook.imagepipeline.producers.BitmapMemoryCacheProducer;
import com.facebook.imagepipeline.producers.BranchOnSeparateImagesProducer;
import com.facebook.imagepipeline.producers.DecodeProducer;
import com.facebook.imagepipeline.producers.DiskCacheProducer;
import com.facebook.imagepipeline.producers.EncodedCacheKeyMultiplexProducer;
import com.facebook.imagepipeline.producers.EncodedMemoryCacheProducer;
import com.facebook.imagepipeline.producers.Producer;
import com.facebook.imagepipeline.producers.RemoveImageTransformMetaDataProducer;
import com.facebook.imagepipeline.producers.ThreadHandoffProducerQueue;
import com.facebook.imagepipeline.producers.ThrottlingProducer;
import com.facebook.imagepipeline.producers.ThumbnailBranchProducer;
import com.facebook.imagepipeline.producers.ThumbnailProducer;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequest.RequestLevel;
import java.util.HashMap;
import java.util.Map;

/* compiled from: orca_sticker_tap_download_android */
public class ProducerSequenceFactory {
    @VisibleForTesting
    Producer<CloseableReference<CloseableImage>> f10852a;
    @VisibleForTesting
    Producer<EncodedImage> f10853b;
    @VisibleForTesting
    Producer<CloseableReference<PooledByteBuffer>> f10854c;
    @VisibleForTesting
    Producer<Void> f10855d;
    @VisibleForTesting
    Producer<CloseableReference<CloseableImage>> f10856e;
    @VisibleForTesting
    Producer<CloseableReference<CloseableImage>> f10857f;
    @VisibleForTesting
    Producer<CloseableReference<CloseableImage>> f10858g;
    @VisibleForTesting
    Producer<CloseableReference<CloseableImage>> f10859h;
    @VisibleForTesting
    Producer<CloseableReference<CloseableImage>> f10860i;
    @VisibleForTesting
    Producer<CloseableReference<CloseableImage>> f10861j;
    @VisibleForTesting
    Map<Producer<CloseableReference<CloseableImage>>, Producer<CloseableReference<CloseableImage>>> f10862k = new HashMap();
    @VisibleForTesting
    Map<Producer<CloseableReference<CloseableImage>>, Producer<Void>> f10863l = new HashMap();
    public final ProducerFactory f10864m;
    private final BaseNetworkFetcher f10865n;
    private final boolean f10866o;
    private final boolean f10867p;
    public final boolean f10868q;
    private final ThreadHandoffProducerQueue f10869r;
    private Producer<EncodedImage> f10870s;

    public ProducerSequenceFactory(ProducerFactory producerFactory, BaseNetworkFetcher baseNetworkFetcher, boolean z, boolean z2, boolean z3, ThreadHandoffProducerQueue threadHandoffProducerQueue) {
        this.f10864m = producerFactory;
        this.f10865n = baseNetworkFetcher;
        this.f10866o = z;
        this.f10868q = z2;
        this.f10867p = z3;
        this.f10869r = threadHandoffProducerQueue;
    }

    public final Producer<CloseableReference<PooledByteBuffer>> m16096a(ImageRequest imageRequest) {
        m16088e(imageRequest);
        synchronized (this) {
            if (this.f10854c == null) {
                this.f10854c = new RemoveImageTransformMetaDataProducer(m16080b());
            }
        }
        return this.f10854c;
    }

    public final Producer<Void> m16097b(ImageRequest imageRequest) {
        m16088e(imageRequest);
        return m16082c();
    }

    private static void m16088e(ImageRequest imageRequest) {
        boolean z;
        Preconditions.a(imageRequest);
        Preconditions.a(UriUtil.m18788a(imageRequest.f12746c));
        if (imageRequest.f12753j.getValue() <= RequestLevel.ENCODED_MEMORY_CACHE.getValue()) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.a(z);
    }

    public final Producer<CloseableReference<CloseableImage>> m16098c(ImageRequest imageRequest) {
        Producer f = m16091f(imageRequest);
        if (imageRequest.f12755l != null) {
            return m16087e(f);
        }
        return f;
    }

    public final Producer<Void> m16099d(ImageRequest imageRequest) {
        return m16090f(m16091f(imageRequest));
    }

    private Producer<CloseableReference<CloseableImage>> m16091f(ImageRequest imageRequest) {
        Preconditions.a(imageRequest);
        Uri uri = imageRequest.f12746c;
        Preconditions.a(uri, "Uri is null.");
        if (UriUtil.m18788a(uri)) {
            return m16077a();
        }
        if (UriUtil.m18789b(uri)) {
            if (MediaUtils.b(MediaUtils.c(uri.getPath()))) {
                return m16089f();
            }
            return m16086e();
        } else if (UriUtil.m18790c(uri)) {
            return m16092g();
        } else {
            if (UriUtil.m18792f(uri)) {
                return m16094i();
            }
            if (UriUtil.m18793g(uri)) {
                return m16093h();
            }
            if ("data".equals(UriUtil.m18794i(uri))) {
                return m16095j();
            }
            String uri2 = uri.toString();
            if (uri2.length() > 30) {
                uri2 = uri2.substring(0, 30) + "...";
            }
            throw new RuntimeException("Unsupported uri scheme! Uri is: " + uri2);
        }
    }

    private synchronized Producer<CloseableReference<CloseableImage>> m16077a() {
        if (this.f10852a == null) {
            this.f10852a = m16081b(m16084d());
        }
        return this.f10852a;
    }

    private synchronized Producer<EncodedImage> m16080b() {
        if (this.f10853b == null) {
            this.f10853b = ProducerFactory.m16101a(m16084d(), this.f10869r);
        }
        return this.f10853b;
    }

    private synchronized Producer<Void> m16082c() {
        if (this.f10855d == null) {
            this.f10855d = ProducerFactory.m16102l(m16080b());
        }
        return this.f10855d;
    }

    private synchronized Producer<EncodedImage> m16084d() {
        if (this.f10870s == null) {
            this.f10870s = ProducerFactory.m16100a(m16083c(this.f10864m.m16104a(this.f10865n)));
            if (this.f10866o && !this.f10868q) {
                this.f10870s = this.f10864m.m16114k(this.f10870s);
            }
        }
        return this.f10870s;
    }

    private synchronized Producer<CloseableReference<CloseableImage>> m16086e() {
        if (this.f10856e == null) {
            this.f10856e = m16078a(this.f10864m.m16109f());
        }
        return this.f10856e;
    }

    private synchronized Producer<CloseableReference<CloseableImage>> m16089f() {
        if (this.f10857f == null) {
            this.f10857f = m16085d(this.f10864m.m16111h());
        }
        return this.f10857f;
    }

    private synchronized Producer<CloseableReference<CloseableImage>> m16092g() {
        if (this.f10858g == null) {
            this.f10858g = m16079a(this.f10864m.m16106c(), new ThumbnailProducer[]{this.f10864m.m16107d(), this.f10864m.m16108e()});
        }
        return this.f10858g;
    }

    private synchronized Producer<CloseableReference<CloseableImage>> m16093h() {
        if (this.f10859h == null) {
            this.f10859h = m16078a(this.f10864m.m16110g());
        }
        return this.f10859h;
    }

    private synchronized Producer<CloseableReference<CloseableImage>> m16094i() {
        if (this.f10860i == null) {
            this.f10860i = m16078a(this.f10864m.m16105b());
        }
        return this.f10860i;
    }

    private synchronized Producer<CloseableReference<CloseableImage>> m16095j() {
        if (this.f10861j == null) {
            Producer a = this.f10864m.m16103a();
            if (VERSION.SDK_INT < 18 && !this.f10867p) {
                a = this.f10864m.m16115m(a);
            }
            a = ProducerFactory.m16100a(a);
            if (!this.f10868q) {
                a = this.f10864m.m16114k(a);
            }
            this.f10861j = m16081b(a);
        }
        return this.f10861j;
    }

    private Producer<CloseableReference<CloseableImage>> m16078a(Producer<EncodedImage> producer) {
        return m16079a(producer, new ThumbnailProducer[]{this.f10864m.m16108e()});
    }

    private Producer<CloseableReference<CloseableImage>> m16079a(Producer<EncodedImage> producer, ThumbnailProducer<EncodedImage>[] thumbnailProducerArr) {
        Producer a = ProducerFactory.m16100a(m16083c((Producer) producer));
        if (!this.f10868q) {
            a = this.f10864m.m16114k(a);
        }
        a = new ThrottlingProducer(5, this.f10864m.f10880j.mo2026e(), a);
        Producer thumbnailBranchProducer = new ThumbnailBranchProducer(thumbnailProducerArr);
        if (!this.f10868q) {
            thumbnailBranchProducer = this.f10864m.m16114k(thumbnailBranchProducer);
        }
        return m16081b((Producer) new BranchOnSeparateImagesProducer(thumbnailBranchProducer, a));
    }

    private Producer<CloseableReference<CloseableImage>> m16081b(Producer<EncodedImage> producer) {
        ProducerFactory producerFactory = this.f10864m;
        return m16085d((Producer) new DecodeProducer(producerFactory.f10874d, producerFactory.f10880j.mo2024c(), producerFactory.f10875e, producerFactory.f10876f, producerFactory.f10877g, producerFactory.f10878h, producer));
    }

    private Producer<EncodedImage> m16083c(Producer<EncodedImage> producer) {
        if (VERSION.SDK_INT < 18 && !this.f10867p) {
            producer = this.f10864m.m16115m(producer);
        }
        ProducerFactory producerFactory = this.f10864m;
        DiskCacheProducer diskCacheProducer = new DiskCacheProducer(producerFactory.f10882l, producerFactory.f10883m, producerFactory.f10886p, producer, producerFactory.f10887q);
        ProducerFactory producerFactory2 = this.f10864m;
        return new EncodedCacheKeyMultiplexProducer(this.f10864m.f10886p, new EncodedMemoryCacheProducer(producerFactory2.f10884n, producerFactory2.f10886p, diskCacheProducer));
    }

    private Producer<CloseableReference<CloseableImage>> m16085d(Producer<CloseableReference<CloseableImage>> producer) {
        ProducerFactory producerFactory = this.f10864m;
        Producer a = ProducerFactory.m16101a(new BitmapMemoryCacheKeyMultiplexProducer(this.f10864m.f10886p, new BitmapMemoryCacheProducer(producerFactory.f10885o, producerFactory.f10886p, producer)), this.f10869r);
        ProducerFactory producerFactory2 = this.f10864m;
        return new BitmapMemoryCacheGetProducer(producerFactory2.f10885o, producerFactory2.f10886p, a);
    }

    private synchronized Producer<CloseableReference<CloseableImage>> m16087e(Producer<CloseableReference<CloseableImage>> producer) {
        if (!this.f10862k.containsKey(producer)) {
            this.f10862k.put(producer, this.f10864m.m16112i(this.f10864m.m16113j(producer)));
        }
        return (Producer) this.f10862k.get(producer);
    }

    private synchronized Producer<Void> m16090f(Producer<CloseableReference<CloseableImage>> producer) {
        if (!this.f10863l.containsKey(producer)) {
            this.f10863l.put(producer, ProducerFactory.m16102l(producer));
        }
        return (Producer) this.f10863l.get(producer);
    }
}
