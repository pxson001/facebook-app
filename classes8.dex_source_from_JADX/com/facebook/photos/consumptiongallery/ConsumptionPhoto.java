package com.facebook.photos.consumptiongallery;

import android.net.Uri;
import com.facebook.photos.base.photos.Photo.PhotoSize;
import com.facebook.photos.base.tagging.TaggablePhoto;
import com.facebook.ui.images.cache.ImageCacheKey.Options;
import com.facebook.ui.images.cache.ImageCacheKey.Options.DownscalingMethod;
import com.facebook.ui.images.cache.ImageCacheKey.OptionsBuilder;
import com.facebook.ui.images.fetch.FetchImageParams;
import com.facebook.ui.images.fetch.FetchImageParams.Builder;
import java.util.ArrayList;

/* compiled from: status_view_scroll_pos */
public class ConsumptionPhoto extends TaggablePhoto {
    public String f2070d;
    private String f2071e;
    private int f2072f;
    private int f2073g;
    public FetchImageParams f2074h;
    private CharSequence f2075i = "";
    public int f2076j;
    public int f2077k;
    public boolean f2078l;
    public boolean f2079m;
    public boolean f2080n;
    private boolean f2081o = true;
    private long f2082p = -1;
    public String f2083q;

    /* compiled from: status_view_scroll_pos */
    /* synthetic */ class C02371 {
        static final /* synthetic */ int[] f2069a = new int[PhotoSize.values().length];

        static {
            try {
                f2069a[PhotoSize.SCREENNAIL.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f2069a[PhotoSize.THUMBNAIL.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
        }
    }

    public ConsumptionPhoto(long j) {
        super(j, new ArrayList(), null);
    }

    public final FetchImageParams m2289a(PhotoSize photoSize) {
        if (photoSize == PhotoSize.THUMBNAIL && this.f2074h != null) {
            return this.f2074h;
        }
        if (photoSize == PhotoSize.THUMBNAIL && this.f2071e == null) {
            return null;
        }
        if (photoSize == PhotoSize.SCREENNAIL && this.f2070d == null) {
            return null;
        }
        OptionsBuilder newBuilder = Options.newBuilder();
        if (this.f2072f == 0 || this.f2073g == 0) {
            photoSize = PhotoSize.SCREENNAIL;
        }
        switch (C02371.f2069a[photoSize.ordinal()]) {
            case 1:
                newBuilder.a(true);
                newBuilder.d = DownscalingMethod.MinScaleNonPowerOfTwo;
                break;
            case 2:
                newBuilder.a(this.f2072f, this.f2073g);
                newBuilder.d = DownscalingMethod.MaxScaleNonPowerOfTwo;
                break;
            default:
                throw new IllegalArgumentException("unknown size: " + photoSize);
        }
        Options f = newBuilder.f();
        String str = (photoSize != PhotoSize.THUMBNAIL || this.f2071e == null) ? this.f2070d : this.f2071e;
        Builder a = FetchImageParams.a(Uri.parse(str));
        a.e = f;
        a = a;
        a.h = true;
        return a.a();
    }
}
