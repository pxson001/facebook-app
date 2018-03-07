package com.facebook.imagepipeline.common;

import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: network_country_iso */
public class ImageDecodeOptions {
    public static final ImageDecodeOptions f12728h = newBuilder().m18786h();
    public final int f12729a;
    public final int f12730b;
    public final boolean f12731c;
    public final boolean f12732d;
    public final boolean f12733e;
    public final boolean f12734f;
    public final boolean f12735g;

    ImageDecodeOptions(ImageDecodeOptionsBuilder imageDecodeOptionsBuilder) {
        this.f12729a = imageDecodeOptionsBuilder.f12736a;
        this.f12730b = imageDecodeOptionsBuilder.f12737b;
        this.f12731c = imageDecodeOptionsBuilder.f12738c;
        this.f12732d = imageDecodeOptionsBuilder.f12739d;
        this.f12733e = imageDecodeOptionsBuilder.f12740e;
        this.f12734f = imageDecodeOptionsBuilder.f12741f;
        this.f12735g = imageDecodeOptionsBuilder.f12742g;
    }

    public static ImageDecodeOptionsBuilder newBuilder() {
        return new ImageDecodeOptionsBuilder();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        ImageDecodeOptions imageDecodeOptions = (ImageDecodeOptions) obj;
        if (this.f12730b != imageDecodeOptions.f12730b) {
            return false;
        }
        if (this.f12731c != imageDecodeOptions.f12731c) {
            return false;
        }
        if (this.f12732d != imageDecodeOptions.f12732d) {
            return false;
        }
        if (this.f12733e != imageDecodeOptions.f12733e) {
            return false;
        }
        if (this.f12734f != imageDecodeOptions.f12734f) {
            return false;
        }
        if (this.f12735g != imageDecodeOptions.f12735g) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return (this.f12731c ? 1 : 0) + (this.f12730b * 31);
    }

    public String toString() {
        return String.format(null, "%d-%d-%b-%b-%b-%b-%b", new Object[]{Integer.valueOf(this.f12729a), Integer.valueOf(this.f12730b), Boolean.valueOf(this.f12731c), Boolean.valueOf(this.f12732d), Boolean.valueOf(this.f12733e), Boolean.valueOf(this.f12734f), Boolean.valueOf(this.f12735g)});
    }
}
