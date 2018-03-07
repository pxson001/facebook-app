package com.facebook.ui.images.cache;

import android.net.Uri;
import com.facebook.cache.common.CacheKey;
import com.facebook.cache.common.SimpleCacheKey;
import com.facebook.common.util.FacebookUriUtil;
import com.facebook.ui.media.cache.MediaCacheKey;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;
import javax.annotation.concurrent.NotThreadSafe;

/* compiled from: eng */
public class ImageCacheKey extends MediaCacheKey {
    public static final Options f12971a = Options.newBuilder().m13856a(true).m13857f();
    public static final Options f12972b = Options.newBuilder().m13855a(64, 64).m13857f();
    public static final Options f12973c = Options.newBuilder().m13856a(false).m13857f();
    public final ImageType f12974d;
    private final Uri f12975e;
    public final Uri f12976f;
    @Nullable
    private final String f12977g;
    public final Options f12978h;
    private volatile CacheKey f12979i;

    /* compiled from: eng */
    public enum ImageType {
        BITMAP,
        ANIMATED
    }

    @Immutable
    /* compiled from: eng */
    public class Options {
        public static final DownscalingMethod f12980a = DownscalingMethod.MemoryUsagePowerOfTwo;
        public final int f12981b;
        public final int f12982c;
        public final int f12983d;
        public final DownscalingMethod f12984e;
        public final boolean f12985f;

        /* compiled from: eng */
        public enum DownscalingMethod {
            MemoryUsagePowerOfTwo,
            MaxScaleNonPowerOfTwo,
            MinScaleNonPowerOfTwo
        }

        public Options(OptionsBuilder optionsBuilder) {
            Preconditions.checkNotNull(optionsBuilder.f12989d);
            this.f12981b = optionsBuilder.f12986a;
            this.f12982c = optionsBuilder.f12987b;
            this.f12983d = optionsBuilder.f12988c;
            this.f12984e = optionsBuilder.f12989d;
            this.f12985f = optionsBuilder.f12990e;
        }

        public static OptionsBuilder newBuilder() {
            return new OptionsBuilder();
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            Options options = (Options) obj;
            if (this.f12983d != options.f12983d) {
                return false;
            }
            if (this.f12982c != options.f12982c) {
                return false;
            }
            if (this.f12984e != options.f12984e) {
                return false;
            }
            if (this.f12985f != options.f12985f) {
                return false;
            }
            if (this.f12981b != options.f12981b) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return (this.f12985f ? 1 : 0) + (((((((this.f12982c * 53) + this.f12981b) * 31) + this.f12983d) * 17) + this.f12984e.ordinal()) * 13);
        }

        public String toString() {
            return Objects.toStringHelper(this).add("w", this.f12982c).add("h", this.f12983d).add("d", this.f12984e).add("o", this.f12985f).add("c", this.f12981b).toString();
        }
    }

    @NotThreadSafe
    /* compiled from: eng */
    public class OptionsBuilder {
        public int f12986a = -1;
        public int f12987b = -1;
        public int f12988c = -1;
        public DownscalingMethod f12989d = Options.f12980a;
        public boolean f12990e = true;

        OptionsBuilder() {
        }

        public final OptionsBuilder m13856a(boolean z) {
            if (z) {
                return m13855a(-2, -2);
            }
            return m13855a(-1, -1);
        }

        public final OptionsBuilder m13855a(int i, int i2) {
            this.f12987b = i;
            this.f12988c = i2;
            return this;
        }

        public final Options m13857f() {
            return new Options(this);
        }
    }

    public ImageCacheKey(Uri uri, Options options, String str) {
        this(uri, ImageType.BITMAP, options, str);
    }

    public ImageCacheKey(Uri uri, ImageType imageType, Options options, @Nullable String str) {
        Preconditions.checkNotNull(uri);
        Preconditions.checkNotNull(options);
        this.f12975e = uri;
        this.f12976f = FacebookUriUtil.i(uri);
        this.f12974d = imageType;
        this.f12978h = options;
        this.f12977g = str;
    }

    public final Options m13854e() {
        return this.f12978h;
    }

    public final Uri m13852a() {
        return this.f12975e;
    }

    public final CacheKey m13853b() {
        if (this.f12979i == null) {
            this.f12979i = new SimpleCacheKey(this.f12976f + (this.f12977g == null ? "" : "____" + this.f12977g));
        }
        return this.f12979i;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof ImageCacheKey)) {
            return false;
        }
        ImageCacheKey imageCacheKey = (ImageCacheKey) obj;
        if (Objects.equal(this.f12976f, imageCacheKey.f12976f) && Objects.equal(this.f12974d, imageCacheKey.f12974d) && Objects.equal(this.f12977g, imageCacheKey.f12977g) && Objects.equal(this.f12978h, imageCacheKey.f12978h)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return Objects.hashCode(new Object[]{this.f12976f, this.f12978h, this.f12977g, this.f12974d});
    }

    public String toString() {
        return Objects.toStringHelper(this).add("k", this.f12976f).add("o", this.f12978h).add("e", this.f12977g).add("t", this.f12974d).toString();
    }
}
