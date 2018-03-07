package com.facebook.ui.images.fetch;

import android.net.Uri;
import com.facebook.ui.images.base.UrlImageProcessor;
import com.facebook.ui.images.cache.ImageCacheKey;
import com.facebook.ui.images.cache.ImageCacheKey.ImageType;
import com.facebook.ui.images.cache.ImageCacheKey.Options;
import com.google.common.base.Preconditions;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

@Immutable
@Deprecated
/* compiled from: engine_creation_failed */
public class FetchImageParams {
    public final Uri f12950a;
    public final ImageType f12951b;
    @Nullable
    public final FirstAvailableImageUris f12952c;
    @Nullable
    public final UrlImageProcessor f12953d;
    public final String f12954e;
    public final Options f12955f;
    public final boolean f12956g;
    public final boolean f12957h;
    public final boolean f12958i;
    public final boolean f12959j;
    private volatile ImageCacheKey f12960k;
    private volatile ImageCacheKey f12961l;

    /* compiled from: engine_creation_failed */
    public class Builder {
        public final Uri f12962a;
        @Nullable
        public final FirstAvailableImageUris f12963b;
        public ImageType f12964c = ImageType.BITMAP;
        @Nullable
        public UrlImageProcessor f12965d;
        public Options f12966e = ImageCacheKey.f12971a;
        public boolean f12967f;
        public boolean f12968g;
        public boolean f12969h;
        public boolean f12970i;

        public Builder(Uri uri, @Nullable FirstAvailableImageUris firstAvailableImageUris) {
            this.f12962a = uri;
            this.f12963b = firstAvailableImageUris;
        }

        public final FetchImageParams m13851a() {
            return new FetchImageParams(this);
        }
    }

    public FetchImageParams(Builder builder) {
        Preconditions.checkNotNull(builder.f12962a);
        Preconditions.checkArgument(builder.f12962a.isAbsolute(), "Url %s is not absolute", new Object[]{builder.f12962a});
        Preconditions.checkNotNull(builder.f12966e);
        this.f12950a = builder.f12962a;
        this.f12951b = builder.f12964c;
        this.f12952c = builder.f12963b;
        this.f12953d = builder.f12965d;
        this.f12955f = builder.f12966e;
        this.f12956g = builder.f12967f;
        this.f12957h = builder.f12968g;
        this.f12958i = builder.f12969h;
        this.f12959j = builder.f12970i;
        this.f12954e = this.f12953d != null ? this.f12953d.a() : null;
    }

    public final Uri m13846a() {
        return this.f12950a;
    }

    @Nullable
    public final UrlImageProcessor m13847d() {
        return this.f12953d;
    }

    public final boolean m13848f() {
        return this.f12956g;
    }

    public final ImageCacheKey m13849j() {
        if (this.f12960k != null) {
            return this.f12960k;
        }
        if (this.f12953d == null) {
            this.f12960k = m13850k();
        } else if (this.f12954e == UrlImageProcessor.a) {
            return null;
        } else {
            this.f12960k = new ImageCacheKey(this.f12950a, this.f12951b, this.f12955f, this.f12954e);
        }
        return this.f12960k;
    }

    public final ImageCacheKey m13850k() {
        if (this.f12961l == null) {
            this.f12961l = new ImageCacheKey(this.f12950a, this.f12951b, this.f12955f, null);
        }
        return this.f12961l;
    }

    @Deprecated
    public static Builder m13845a(Uri uri) {
        return new Builder(uri, null);
    }

    public String toString() {
        return this.f12950a.toString();
    }
}
