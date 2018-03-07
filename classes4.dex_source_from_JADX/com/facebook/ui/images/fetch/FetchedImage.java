package com.facebook.ui.images.fetch;

import android.graphics.Bitmap;
import com.facebook.binaryresource.BinaryResource;
import com.facebook.ui.images.cache.CachedImage;
import com.facebook.ui.images.cache.ImageCacheKey;
import com.google.common.base.Preconditions;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: end */
public class FetchedImage {
    public final ImageCacheKey f13046a;
    @Nullable
    public final BinaryResource f13047b;
    public final CachedImage f13048c;
    public final Source f13049d;
    public final Error f13050e;
    public final long f13051f;
    public final boolean f13052g;

    /* compiled from: end */
    public enum Source {
        NOT_IN_CACHE_NOT_DOWNLOADED,
        MEMORY_CACHE,
        CACHE,
        UNDERLYING_IMAGE_IN_CACHE,
        FETCHED_FROM_FILE_OR_CONTENT,
        DOWNLOADED,
        FETCHED_NEW_PIPELINE,
        ERROR
    }

    /* compiled from: end */
    public class Builder {
        public final ImageCacheKey f13053a;
        @Nullable
        public BinaryResource f13054b = null;
        public CachedImage f13055c = null;
        public Source f13056d;
        public long f13057e = -1;
        public Error f13058f;
        public boolean f13059g;

        public Builder(ImageCacheKey imageCacheKey) {
            this.f13053a = imageCacheKey;
        }

        public Builder(FetchedImage fetchedImage) {
            this.f13053a = fetchedImage.f13046a;
            this.f13054b = fetchedImage.f13047b;
            this.f13055c = fetchedImage.f13048c;
            this.f13056d = fetchedImage.f13049d;
            this.f13057e = fetchedImage.f13051f;
            this.f13058f = fetchedImage.f13050e;
            this.f13059g = fetchedImage.f13052g;
        }

        public final Builder m13908a(@Nullable BinaryResource binaryResource) {
            this.f13054b = binaryResource;
            return this;
        }

        public final Builder m13909a(CachedImage cachedImage) {
            this.f13055c = cachedImage;
            return this;
        }

        public final Builder m13911a(Source source) {
            this.f13056d = source;
            return this;
        }

        public final Builder m13910a(Error error) {
            this.f13058f = error;
            return this;
        }

        public final Builder m13907a(long j) {
            this.f13057e = j;
            return this;
        }

        public final FetchedImage m13912a() {
            return new FetchedImage(this);
        }
    }

    public FetchedImage(Builder builder) {
        boolean z = false;
        Preconditions.checkNotNull(builder.f13053a);
        Preconditions.checkNotNull(builder.f13056d);
        Preconditions.checkArgument((builder.f13056d == Source.ERROR ? 1 : 0) ^ (builder.f13058f == null ? 1 : 0));
        if (builder.f13055c == null || builder.f13054b == null) {
            z = true;
        }
        Preconditions.checkState(z);
        this.f13046a = builder.f13053a;
        this.f13047b = builder.f13054b;
        this.f13048c = builder.f13055c;
        this.f13049d = builder.f13056d;
        this.f13050e = builder.f13058f;
        this.f13051f = builder.f13057e;
        this.f13052g = builder.f13059g;
    }

    public final ImageCacheKey m13902a() {
        return this.f13046a;
    }

    public final Bitmap m13903b() {
        if (this.f13048c == null) {
            return null;
        }
        return this.f13048c.mo941a();
    }

    public final CachedImage m13904c() {
        return this.f13048c;
    }

    public final Source m13905e() {
        return this.f13049d;
    }

    public final long m13906f() {
        return this.f13051f;
    }

    public static Builder m13901a(ImageCacheKey imageCacheKey) {
        return new Builder(imageCacheKey);
    }
}
