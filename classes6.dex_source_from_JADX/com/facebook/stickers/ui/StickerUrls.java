package com.facebook.stickers.ui;

import android.graphics.Color;
import android.net.Uri;
import com.facebook.imagepipeline.common.ImageDecodeOptions;
import com.facebook.imagepipeline.common.ImageDecodeOptionsBuilder;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.stickers.model.Sticker;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: drawable */
public class StickerUrls {
    public final Provider<Boolean> f17078a;

    public static StickerUrls m24769b(InjectorLike injectorLike) {
        return new StickerUrls(IdBasedProvider.a(injectorLike, 4336));
    }

    @Inject
    StickerUrls(Provider<Boolean> provider) {
        this.f17078a = provider;
    }

    public static ImageRequest[] m24768a(Sticker sticker) {
        List arrayList = new ArrayList();
        if (sticker.f4945h != null) {
            arrayList.add(ImageRequest.a(sticker.f4945h));
        }
        if (sticker.f4941d != null) {
            arrayList.add(ImageRequest.a(sticker.f4941d));
        }
        if (sticker.f4944g != null) {
            arrayList.add(ImageRequest.a(sticker.f4944g));
        }
        arrayList.add(ImageRequest.a(sticker.f4940c));
        return (ImageRequest[]) arrayList.toArray(new ImageRequest[arrayList.size()]);
    }

    public final ImageRequest[] m24771b(Sticker sticker) {
        List a = m24767a(sticker, true, 0);
        return (ImageRequest[]) a.toArray(new ImageRequest[a.size()]);
    }

    public static ImageRequest m24770c(Sticker sticker) {
        if (sticker.f4945h != null) {
            return ImageRequest.a(sticker.f4945h);
        }
        if (sticker.f4941d != null) {
            return ImageRequest.a(sticker.f4941d);
        }
        if (sticker.f4944g != null) {
            return ImageRequest.a(sticker.f4944g);
        }
        return ImageRequest.a(sticker.f4940c);
    }

    public static List<ImageRequest> m24767a(Sticker sticker, boolean z, int i) {
        List<ImageRequest> arrayList = new ArrayList();
        Uri uri = null;
        if (sticker.f4943f != null) {
            uri = sticker.f4943f;
        } else if (sticker.f4942e != null) {
            uri = sticker.f4942e;
        }
        if (uri != null) {
            ImageDecodeOptionsBuilder newBuilder = ImageDecodeOptions.newBuilder();
            newBuilder.c = true;
            newBuilder = newBuilder;
            if (z) {
                newBuilder.f = true;
            }
            if (Color.alpha(i) != 0) {
                newBuilder.b = i;
            }
            ImageDecodeOptions h = newBuilder.h();
            ImageRequestBuilder a = ImageRequestBuilder.a(uri);
            a.e = h;
            arrayList.add(a.m());
        }
        return arrayList;
    }
}
