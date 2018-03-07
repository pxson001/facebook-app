package com.facebook.imagepipeline.request;

import android.net.Uri;
import com.facebook.common.internal.Objects;
import com.facebook.common.util.UriUtil;
import com.facebook.imagepipeline.common.ImageDecodeOptions;
import com.facebook.imagepipeline.common.Priority;
import com.facebook.imagepipeline.common.ResizeOptions;
import java.io.File;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: network_dedupped */
public class ImageRequest {
    @Nullable
    public ResizeOptions f12744a = null;
    public final ImageType f12745b;
    public final Uri f12746c;
    private File f12747d;
    public final boolean f12748e;
    public final boolean f12749f;
    public final ImageDecodeOptions f12750g;
    public final boolean f12751h;
    public final Priority f12752i;
    public final RequestLevel f12753j;
    public final boolean f12754k;
    public final Postprocessor f12755l;

    /* compiled from: network_dedupped */
    public enum RequestLevel {
        FULL_FETCH(1),
        DISK_CACHE(2),
        ENCODED_MEMORY_CACHE(3),
        BITMAP_MEMORY_CACHE(4);
        
        private int mValue;

        private RequestLevel(int i) {
            this.mValue = i;
        }

        public final int getValue() {
            return this.mValue;
        }

        public static RequestLevel getMax(RequestLevel requestLevel, RequestLevel requestLevel2) {
            return requestLevel.getValue() > requestLevel2.getValue() ? requestLevel : requestLevel2;
        }
    }

    /* compiled from: network_dedupped */
    public enum ImageType {
        SMALL,
        DEFAULT
    }

    public static ImageRequest m18795a(@Nullable Uri uri) {
        return uri == null ? null : ImageRequestBuilder.m18776a(uri).m18785m();
    }

    public static ImageRequest m18796a(@Nullable String str) {
        return (str == null || str.length() == 0) ? null : m18795a(Uri.parse(str));
    }

    protected ImageRequest(ImageRequestBuilder imageRequestBuilder) {
        boolean z;
        this.f12745b = imageRequestBuilder.f12722f;
        this.f12746c = imageRequestBuilder.f12717a;
        this.f12748e = imageRequestBuilder.f12723g;
        this.f12749f = imageRequestBuilder.f12724h;
        this.f12750g = imageRequestBuilder.f12721e;
        this.f12744a = imageRequestBuilder.f12720d;
        this.f12751h = imageRequestBuilder.f12719c;
        this.f12752i = imageRequestBuilder.f12725i;
        this.f12753j = imageRequestBuilder.f12718b;
        if (imageRequestBuilder.f12727k && UriUtil.m18788a(imageRequestBuilder.f12717a)) {
            z = true;
        } else {
            z = false;
        }
        this.f12754k = z;
        this.f12755l = imageRequestBuilder.f12726j;
    }

    public final ImageType m18797a() {
        return this.f12745b;
    }

    public final Uri m18798b() {
        return this.f12746c;
    }

    @Nullable
    public final ResizeOptions m18799e() {
        return this.f12744a;
    }

    public final boolean m18800h() {
        return this.f12748e;
    }

    public final Priority m18801j() {
        return this.f12752i;
    }

    public final RequestLevel m18802k() {
        return this.f12753j;
    }

    public final synchronized File m18803m() {
        if (this.f12747d == null) {
            this.f12747d = new File(this.f12746c.getPath());
        }
        return this.f12747d;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof ImageRequest)) {
            return false;
        }
        ImageRequest imageRequest = (ImageRequest) obj;
        if (Objects.m20538a(this.f12746c, imageRequest.f12746c) && Objects.m20538a(this.f12745b, imageRequest.f12745b) && Objects.m20538a(this.f12747d, imageRequest.f12747d)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return Objects.m20536a(this.f12745b, this.f12746c, this.f12747d);
    }
}
