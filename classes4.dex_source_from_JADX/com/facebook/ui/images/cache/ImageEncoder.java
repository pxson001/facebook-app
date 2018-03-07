package com.facebook.ui.images.cache;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory.Options;
import android.net.Uri;
import com.facebook.binaryresource.BinaryResource;
import com.facebook.binaryresource.ByteArrayBinaryResource;
import com.facebook.binaryresource.FileBinaryResource;
import com.facebook.common.util.StreamUtil;
import com.facebook.inject.InjectorLike;
import com.facebook.ui.images.base.ByteArrayBitmapReader;
import com.facebook.ui.images.cache.ImageCacheKey.ImageType;
import com.facebook.ui.images.cache.ImageCacheKey.Options.DownscalingMethod;
import com.facebook.ui.images.decoder.ImageDecoder;
import com.facebook.ui.images.decoder.ImageDecoder.ImageOrientationProcessing;
import com.facebook.ui.images.webp.AnimatedImageDecoder;
import com.facebook.ui.media.cache.BaseObjectEncoder;
import com.facebook.ui.media.cache.MediaCacheKey;
import com.google.common.annotations.VisibleForTesting;
import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import javax.annotation.Nullable;
import javax.inject.Inject;

@Deprecated
/* compiled from: enum */
public class ImageEncoder extends BaseObjectEncoder<ImageCacheKey, CachedImage> {
    private final ImageDecoder f12897a;
    private final AnimatedImageDecoder f12898b;

    public static ImageEncoder m13758b(InjectorLike injectorLike) {
        return new ImageEncoder(ImageDecoder.m13772a(injectorLike), AnimatedImageDecoder.a(injectorLike));
    }

    public final Object mo932a(MediaCacheKey mediaCacheKey, BinaryResource binaryResource) {
        mediaCacheKey = (ImageCacheKey) mediaCacheKey;
        if (binaryResource instanceof FileBinaryResource) {
            return m13759a((ImageCacheKey) mediaCacheKey, ((FileBinaryResource) binaryResource).a);
        }
        if (binaryResource instanceof ByteArrayBinaryResource) {
            return m13757b(mediaCacheKey, ((ByteArrayBinaryResource) binaryResource).b());
        }
        return (CachedImage) super.mo932a(mediaCacheKey, binaryResource);
    }

    public final Object mo933a(MediaCacheKey mediaCacheKey, InputStream inputStream) {
        ImageCacheKey imageCacheKey = (ImageCacheKey) mediaCacheKey;
        switch (imageCacheKey.f12974d) {
            case BITMAP:
                return m13757b(imageCacheKey, StreamUtil.a(inputStream));
            case ANIMATED:
                return CachedImage.m13887a(this.f12898b.a(inputStream, imageCacheKey.f12978h.f12981b, imageCacheKey.f12978h.f12982c, imageCacheKey.f12978h.f12983d));
            default:
                return null;
        }
    }

    public final Object mo934a(MediaCacheKey mediaCacheKey, byte[] bArr) {
        ImageCacheKey imageCacheKey = (ImageCacheKey) mediaCacheKey;
        int i = imageCacheKey.f12978h.f12982c;
        int i2 = imageCacheKey.f12978h.f12983d;
        switch (imageCacheKey.f12974d) {
            case BITMAP:
                ImageOrientationProcessing imageOrientationProcessing;
                DownscalingMethod downscalingMethod = imageCacheKey.f12978h.f12984e;
                if (imageCacheKey.f12978h.f12985f) {
                    imageOrientationProcessing = ImageOrientationProcessing.APPLY_ORIENTATION;
                } else {
                    imageOrientationProcessing = ImageOrientationProcessing.NO_ORIENTATION;
                }
                return CachedImage.m13888a(this.f12897a.m13775a(new ByteArrayBitmapReader(bArr), i, i2, downscalingMethod, imageOrientationProcessing));
            case ANIMATED:
                return CachedImage.m13887a(this.f12898b.a(bArr, imageCacheKey.f12978h.f12981b, i, i2));
            default:
                return null;
        }
    }

    public final void mo935a(MediaCacheKey mediaCacheKey, Object obj, OutputStream outputStream) {
        ImageCacheKey imageCacheKey = (ImageCacheKey) mediaCacheKey;
        CachedImage cachedImage = (CachedImage) obj;
        if (cachedImage != null) {
            ImageType imageType = imageCacheKey.f12974d;
            if (imageType == ImageType.BITMAP) {
                Bitmap a = cachedImage.mo941a();
                if (a.hasAlpha()) {
                    a.compress(CompressFormat.PNG, 100, outputStream);
                } else {
                    a.compress(CompressFormat.JPEG, 95, outputStream);
                }
            } else if (imageType == ImageType.ANIMATED) {
                throw new UnsupportedOperationException("TODO (#2567028): Animated image encoding not implemented");
            }
        }
    }

    @Inject
    public ImageEncoder(ImageDecoder imageDecoder, AnimatedImageDecoder animatedImageDecoder) {
        this.f12897a = imageDecoder;
        this.f12898b = animatedImageDecoder;
    }

    @VisibleForTesting
    private CachedImage m13757b(ImageCacheKey imageCacheKey, byte[] bArr) {
        switch (imageCacheKey.f12974d) {
            case BITMAP:
                Options options = new Options();
                options.inInputShareable = true;
                options.inPurgeable = true;
                return CachedImage.m13888a(new ByteArrayBitmapReader(bArr).mo938a(options));
            case ANIMATED:
                return CachedImage.m13887a(this.f12898b.a(bArr, imageCacheKey.f12978h.f12981b, imageCacheKey.f12978h.f12982c, imageCacheKey.f12978h.f12983d));
            default:
                return null;
        }
    }

    @Nullable
    public final CachedImage m13759a(ImageCacheKey imageCacheKey, File file) {
        int i = imageCacheKey.f12978h.f12982c;
        int i2 = imageCacheKey.f12978h.f12983d;
        switch (imageCacheKey.f12974d) {
            case BITMAP:
                ImageOrientationProcessing imageOrientationProcessing;
                DownscalingMethod downscalingMethod = imageCacheKey.f12978h.f12984e;
                if (imageCacheKey.f12978h.f12985f) {
                    imageOrientationProcessing = ImageOrientationProcessing.APPLY_ORIENTATION;
                } else {
                    imageOrientationProcessing = ImageOrientationProcessing.NO_ORIENTATION;
                }
                return CachedImage.m13888a(this.f12897a.m13774a(Uri.fromFile(file), i, i2, downscalingMethod, imageOrientationProcessing));
            case ANIMATED:
                return CachedImage.m13887a(this.f12898b.a(file, imageCacheKey.f12978h.f12981b, i, i2));
            default:
                return null;
        }
    }
}
