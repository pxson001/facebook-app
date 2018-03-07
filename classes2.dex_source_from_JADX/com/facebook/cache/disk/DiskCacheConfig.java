package com.facebook.cache.disk;

import android.content.Context;
import com.facebook.cache.common.CacheErrorLogger;
import com.facebook.cache.common.CacheEventListener;
import com.facebook.cache.common.NoOpCacheErrorLogger;
import com.facebook.cache.common.NoOpCacheEventListener;
import com.facebook.common.disk.DiskTrimmableRegistry;
import com.facebook.common.disk.NoOpDiskTrimmableRegistry;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.Supplier;
import java.io.File;
import javax.annotation.Nullable;

/* compiled from: original_translation_confidence */
public class DiskCacheConfig {
    public final int f10711a;
    public final String f10712b;
    public final Supplier<File> f10713c;
    public final long f10714d;
    public final long f10715e;
    public final long f10716f;
    public final EntryEvictionComparatorSupplier f10717g;
    public final CacheErrorLogger f10718h;
    public final CacheEventListener f10719i;
    public final DiskTrimmableRegistry f10720j;

    /* compiled from: original_translation_confidence */
    public class Builder {
        public int f10721a = 1;
        public String f10722b = "image_cache";
        public Supplier<File> f10723c;
        public long f10724d = 41943040;
        public long f10725e = 10485760;
        public long f10726f = 2097152;
        public EntryEvictionComparatorSupplier f10727g = new DefaultEntryEvictionComparatorSupplier();
        public CacheErrorLogger f10728h;
        public CacheEventListener f10729i;
        public DiskTrimmableRegistry f10730j;
        @Nullable
        public final Context f10731k;

        public Builder(@Nullable Context context) {
            this.f10731k = context;
        }

        public final Builder m15969a(long j) {
            this.f10724d = j;
            return this;
        }

        public final Builder m15971b(long j) {
            this.f10725e = j;
            return this;
        }

        public final Builder m15972c(long j) {
            this.f10726f = j;
            return this;
        }

        public final DiskCacheConfig m15970a() {
            boolean z = (this.f10723c == null && this.f10731k == null) ? false : true;
            Preconditions.b(z, "Either a non-null context or a base directory path or supplier must be provided.");
            if (this.f10723c == null && this.f10731k != null) {
                this.f10723c = new 1(this);
            }
            return new DiskCacheConfig(this);
        }
    }

    public DiskCacheConfig(Builder builder) {
        this.f10711a = builder.f10721a;
        this.f10712b = (String) Preconditions.a(builder.f10722b);
        this.f10713c = (Supplier) Preconditions.a(builder.f10723c);
        this.f10714d = builder.f10724d;
        this.f10715e = builder.f10725e;
        this.f10716f = builder.f10726f;
        this.f10717g = (EntryEvictionComparatorSupplier) Preconditions.a(builder.f10727g);
        this.f10718h = builder.f10728h == null ? NoOpCacheErrorLogger.a() : builder.f10728h;
        this.f10719i = builder.f10729i == null ? NoOpCacheEventListener.f() : builder.f10729i;
        this.f10720j = builder.f10730j == null ? NoOpDiskTrimmableRegistry.a() : builder.f10730j;
    }

    public static Builder m15968a(@Nullable Context context) {
        return new Builder(context);
    }
}
