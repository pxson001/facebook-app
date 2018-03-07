package com.facebook.imagepipeline.internal;

import android.content.res.Resources;
import android.net.Uri;
import android.util.DisplayMetrics;
import com.facebook.common.util.UriUtil;
import com.facebook.imagepipeline.common.ImageDecodeOptions;
import com.facebook.imagepipeline.common.ImageDecodeOptionsBuilder;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.request.ImageRequest.RequestLevel;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.facebook.ui.images.cache.ImageCacheKey.Options;
import com.facebook.ui.images.fetch.FetchImageParams;

@Deprecated
/* compiled from: TOY_STORE */
public class ImageRequestBuilderFactory {
    private ImageRequestBuilderFactory() {
    }

    public static ImageRequestBuilder m23054a(FetchImageParams fetchImageParams, Resources resources) {
        int i;
        int i2 = 0;
        Options options = fetchImageParams.f;
        if (options == null || resources == null) {
            i = 0;
        } else {
            i = options.c;
            i2 = options.d;
            DisplayMetrics displayMetrics = resources.getDisplayMetrics();
            if (i == -2) {
                i = displayMetrics.widthPixels;
            }
            if (i2 == -2) {
                i2 = displayMetrics.heightPixels;
            }
        }
        Uri uri = fetchImageParams.a;
        ImageRequestBuilder a = ImageRequestBuilder.a(uri);
        if (fetchImageParams.h) {
            a.b = RequestLevel.BITMAP_MEMORY_CACHE;
        }
        if (!UriUtil.a(uri) && i > 0 && i2 > 0) {
            a.d = new ResizeOptions(i, i2);
        }
        if (!(UriUtil.a(uri) || options == null)) {
            a.c = options.f;
        }
        ImageDecodeOptionsBuilder newBuilder = ImageDecodeOptions.newBuilder();
        if (options != null) {
            newBuilder.b = options.b;
        }
        a.e = newBuilder.h();
        return a;
    }
}
