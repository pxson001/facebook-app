package com.facebook.imagepipeline.core;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import com.facebook.cache.common.CacheKey;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory;
import com.facebook.imagepipeline.cache.BufferedDiskCache;
import com.facebook.imagepipeline.cache.CacheKeyFactory;
import com.facebook.imagepipeline.cache.DefaultCacheKeyFactory;
import com.facebook.imagepipeline.cache.MemoryCache;
import com.facebook.imagepipeline.decoder.ImageDecoder;
import com.facebook.imagepipeline.decoder.ProgressiveJpegConfig;
import com.facebook.imagepipeline.decoder.SimpleProgressiveJpegConfig;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.memory.ByteArrayPool;
import com.facebook.imagepipeline.memory.GenericByteArrayPool;
import com.facebook.imagepipeline.memory.NativePooledByteBufferFactory;
import com.facebook.imagepipeline.memory.PooledByteBuffer;
import com.facebook.imagepipeline.memory.PooledByteBufferFactory;
import com.facebook.imagepipeline.producers.AddImageTransformMetaDataProducer;
import com.facebook.imagepipeline.producers.BaseNetworkFetcher;
import com.facebook.imagepipeline.producers.DataFetchProducer;
import com.facebook.imagepipeline.producers.LocalAssetFetchProducer;
import com.facebook.imagepipeline.producers.LocalContentUriFetchProducer;
import com.facebook.imagepipeline.producers.LocalContentUriThumbnailFetchProducer;
import com.facebook.imagepipeline.producers.LocalExifThumbnailProducer;
import com.facebook.imagepipeline.producers.LocalFileFetchProducer;
import com.facebook.imagepipeline.producers.LocalResourceFetchProducer;
import com.facebook.imagepipeline.producers.LocalVideoThumbnailProducer;
import com.facebook.imagepipeline.producers.NetworkFetchProducer;
import com.facebook.imagepipeline.producers.PostprocessedBitmapMemoryCacheProducer;
import com.facebook.imagepipeline.producers.PostprocessorProducer;
import com.facebook.imagepipeline.producers.Producer;
import com.facebook.imagepipeline.producers.ResizeAndRotateProducer;
import com.facebook.imagepipeline.producers.SwallowResultProducer;
import com.facebook.imagepipeline.producers.ThreadHandoffProducer;
import com.facebook.imagepipeline.producers.ThreadHandoffProducerQueue;
import com.facebook.imagepipeline.producers.WebpTranscodeProducer;

/* compiled from: orca_service_exception */
public class ProducerFactory {
    private ContentResolver f10871a;
    private Resources f10872b;
    private AssetManager f10873c;
    public final GenericByteArrayPool f10874d;
    public final ImageDecoder f10875e;
    public final SimpleProgressiveJpegConfig f10876f;
    public final boolean f10877g;
    public final boolean f10878h;
    private final boolean f10879i;
    public final ExecutorSupplier f10880j;
    private final NativePooledByteBufferFactory f10881k;
    public final BufferedDiskCache f10882l;
    public final BufferedDiskCache f10883m;
    public final MemoryCache<CacheKey, PooledByteBuffer> f10884n;
    public final MemoryCache<CacheKey, CloseableImage> f10885o;
    public final DefaultCacheKeyFactory f10886p;
    public final int f10887q;
    private final PlatformBitmapFactory f10888r;

    public ProducerFactory(Context context, ByteArrayPool byteArrayPool, ImageDecoder imageDecoder, ProgressiveJpegConfig progressiveJpegConfig, boolean z, boolean z2, ExecutorSupplier executorSupplier, PooledByteBufferFactory pooledByteBufferFactory, MemoryCache<CacheKey, CloseableImage> memoryCache, MemoryCache<CacheKey, PooledByteBuffer> memoryCache2, BufferedDiskCache bufferedDiskCache, BufferedDiskCache bufferedDiskCache2, CacheKeyFactory cacheKeyFactory, PlatformBitmapFactory platformBitmapFactory, boolean z3, int i) {
        this.f10887q = i;
        this.f10871a = context.getApplicationContext().getContentResolver();
        this.f10872b = context.getApplicationContext().getResources();
        this.f10873c = context.getApplicationContext().getAssets();
        this.f10874d = byteArrayPool;
        this.f10875e = imageDecoder;
        this.f10876f = progressiveJpegConfig;
        this.f10877g = z;
        this.f10878h = z2;
        this.f10880j = executorSupplier;
        this.f10881k = pooledByteBufferFactory;
        this.f10885o = memoryCache;
        this.f10884n = memoryCache2;
        this.f10882l = bufferedDiskCache;
        this.f10883m = bufferedDiskCache2;
        this.f10886p = cacheKeyFactory;
        this.f10888r = platformBitmapFactory;
        this.f10879i = z3;
    }

    public static AddImageTransformMetaDataProducer m16100a(Producer<EncodedImage> producer) {
        return new AddImageTransformMetaDataProducer(producer);
    }

    public final DataFetchProducer m16103a() {
        return new DataFetchProducer(this.f10881k, this.f10879i);
    }

    public final LocalAssetFetchProducer m16105b() {
        return new LocalAssetFetchProducer(this.f10880j.mo2022a(), this.f10881k, this.f10873c, this.f10879i);
    }

    public final LocalContentUriFetchProducer m16106c() {
        return new LocalContentUriFetchProducer(this.f10880j.mo2022a(), this.f10881k, this.f10871a, this.f10879i);
    }

    public final LocalContentUriThumbnailFetchProducer m16107d() {
        return new LocalContentUriThumbnailFetchProducer(this.f10880j.mo2022a(), this.f10881k, this.f10871a, this.f10879i);
    }

    public final LocalExifThumbnailProducer m16108e() {
        return new LocalExifThumbnailProducer(this.f10880j.mo2022a(), this.f10881k, this.f10871a);
    }

    public final LocalFileFetchProducer m16109f() {
        return new LocalFileFetchProducer(this.f10880j.mo2022a(), this.f10881k, this.f10879i);
    }

    public final LocalResourceFetchProducer m16110g() {
        return new LocalResourceFetchProducer(this.f10880j.mo2022a(), this.f10881k, this.f10872b, this.f10879i);
    }

    public final LocalVideoThumbnailProducer m16111h() {
        return new LocalVideoThumbnailProducer(this.f10880j.mo2022a());
    }

    public final NetworkFetchProducer m16104a(BaseNetworkFetcher baseNetworkFetcher) {
        return new NetworkFetchProducer(this.f10881k, this.f10874d, baseNetworkFetcher);
    }

    public final PostprocessedBitmapMemoryCacheProducer m16112i(Producer<CloseableReference<CloseableImage>> producer) {
        return new PostprocessedBitmapMemoryCacheProducer(this.f10885o, this.f10886p, producer);
    }

    public final PostprocessorProducer m16113j(Producer<CloseableReference<CloseableImage>> producer) {
        return new PostprocessorProducer(producer, this.f10888r, this.f10880j.mo2025d());
    }

    public final ResizeAndRotateProducer m16114k(Producer<EncodedImage> producer) {
        return new ResizeAndRotateProducer(this.f10880j.mo2025d(), this.f10881k, producer);
    }

    public static <T> SwallowResultProducer<T> m16102l(Producer<T> producer) {
        return new SwallowResultProducer(producer);
    }

    public static <T> ThreadHandoffProducer<T> m16101a(Producer<T> producer, ThreadHandoffProducerQueue threadHandoffProducerQueue) {
        return new ThreadHandoffProducer(producer, threadHandoffProducerQueue);
    }

    public final WebpTranscodeProducer m16115m(Producer<EncodedImage> producer) {
        return new WebpTranscodeProducer(this.f10880j.mo2025d(), this.f10881k, producer);
    }
}
