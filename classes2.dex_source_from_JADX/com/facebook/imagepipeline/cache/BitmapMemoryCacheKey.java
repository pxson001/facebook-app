package com.facebook.imagepipeline.cache;

import android.net.Uri;
import com.facebook.cache.common.CacheKey;
import com.facebook.common.internal.Objects;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.time.RealtimeSinceBootClock;
import com.facebook.common.util.HashCodeUtil;
import com.facebook.imagepipeline.common.ImageDecodeOptions;
import com.facebook.imagepipeline.common.ResizeOptions;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: media_upload */
public class BitmapMemoryCacheKey implements CacheKey {
    public final String f14503a;
    @Nullable
    private final ResizeOptions f14504b;
    private final boolean f14505c;
    private final ImageDecodeOptions f14506d;
    @Nullable
    private final CacheKey f14507e;
    @Nullable
    private final String f14508f;
    private final int f14509g;
    private final Object f14510h;
    private final long f14511i;

    public BitmapMemoryCacheKey(String str, @Nullable ResizeOptions resizeOptions, boolean z, ImageDecodeOptions imageDecodeOptions, @Nullable CacheKey cacheKey, @Nullable String str2, Object obj) {
        this.f14503a = (String) Preconditions.a(str);
        this.f14504b = resizeOptions;
        this.f14505c = z;
        this.f14506d = imageDecodeOptions;
        this.f14507e = cacheKey;
        this.f14508f = str2;
        this.f14509g = HashCodeUtil.m20815a(Integer.valueOf(str.hashCode()), Integer.valueOf(resizeOptions != null ? resizeOptions.hashCode() : 0), Integer.valueOf(z ? Boolean.TRUE.hashCode() : Boolean.FALSE.hashCode()), this.f14506d, this.f14507e, (Object) str2);
        this.f14510h = obj;
        this.f14511i = RealtimeSinceBootClock.f3978a.now();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof BitmapMemoryCacheKey)) {
            return false;
        }
        BitmapMemoryCacheKey bitmapMemoryCacheKey = (BitmapMemoryCacheKey) obj;
        if (this.f14509g == bitmapMemoryCacheKey.f14509g && this.f14503a.equals(bitmapMemoryCacheKey.f14503a) && Objects.m20538a(this.f14504b, bitmapMemoryCacheKey.f14504b) && this.f14505c == bitmapMemoryCacheKey.f14505c && Objects.m20538a(this.f14506d, bitmapMemoryCacheKey.f14506d) && Objects.m20538a(this.f14507e, bitmapMemoryCacheKey.f14507e) && Objects.m20538a(this.f14508f, bitmapMemoryCacheKey.f14508f)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return this.f14509g;
    }

    public final boolean mo2792a(Uri uri) {
        return this.f14503a.contains(uri.toString());
    }

    public String toString() {
        return String.format(null, "%s_%s_%s_%s_%s_%s_%d", new Object[]{this.f14503a, this.f14504b, Boolean.toString(this.f14505c), this.f14506d, this.f14507e, this.f14508f, Integer.valueOf(this.f14509g)});
    }
}
