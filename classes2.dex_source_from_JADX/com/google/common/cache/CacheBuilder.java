package com.google.common.cache;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Ascii;
import com.google.common.base.Equivalence;
import com.google.common.base.MoreObjects;
import com.google.common.base.MoreObjects.ToStringHelper;
import com.google.common.base.Preconditions;
import com.google.common.base.Supplier;
import com.google.common.base.Suppliers.SupplierOfInstance;
import com.google.common.base.Ticker;
import com.google.common.cache.AbstractCache.SimpleStatsCounter;
import com.google.common.cache.LocalCache.LocalManualCache;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.CheckReturnValue;

@GwtCompatible
/* compiled from: zero_buy_promo */
public final class CacheBuilder<K, V> {
    static final Supplier<? extends AbstractCache$StatsCounter> f543a = new SupplierOfInstance(new C00221());
    static final CacheStats f544b = new CacheStats(0, 0, 0, 0, 0, 0);
    static final Supplier<AbstractCache$StatsCounter> f545c = new C00232();
    static final Ticker f546d = new C00243();
    private static final Logger f547u = Logger.getLogger(CacheBuilder.class.getName());
    boolean f548e = true;
    public int f549f = -1;
    int f550g = -1;
    long f551h = -1;
    long f552i = -1;
    Weigher<? super K, ? super V> f553j;
    Strength f554k;
    Strength f555l;
    long f556m = -1;
    long f557n = -1;
    public long f558o = -1;
    public Equivalence<Object> f559p;
    Equivalence<Object> f560q;
    RemovalListener<? super K, ? super V> f561r;
    public Ticker f562s;
    Supplier<? extends AbstractCache$StatsCounter> f563t = f543a;

    /* compiled from: zero_buy_promo */
    final class C00221 implements AbstractCache$StatsCounter {
        C00221() {
        }

        public final void mo120a(int i) {
        }

        public final void mo122b(int i) {
        }

        public final void mo121a(long j) {
        }

        public final void mo123b(long j) {
        }

        public final void mo119a() {
        }
    }

    /* compiled from: zero_buy_promo */
    final class C00232 implements Supplier<AbstractCache$StatsCounter> {
        C00232() {
        }

        public final Object get() {
            return new SimpleStatsCounter();
        }
    }

    /* compiled from: zero_buy_promo */
    final class C00243 extends Ticker {
        C00243() {
        }

        public final long read() {
            return 0;
        }
    }

    /* compiled from: zero_buy_promo */
    enum OneWeigher implements Weigher<Object, Object> {
        INSTANCE;

        public final int weigh(Object obj, Object obj2) {
            return 1;
        }
    }

    /* compiled from: zero_buy_promo */
    enum NullListener implements RemovalListener<Object, Object> {
        INSTANCE;

        public final void onRemoval(RemovalNotification<Object, Object> removalNotification) {
        }
    }

    CacheBuilder() {
    }

    public static CacheBuilder<Object, Object> newBuilder() {
        return new CacheBuilder();
    }

    final Equivalence<Object> m1120a() {
        return (Equivalence) MoreObjects.firstNonNull(this.f559p, m1139h().defaultEquivalence());
    }

    @GwtIncompatible("To be supported")
    final CacheBuilder<K, V> m1132b(Equivalence<Object> equivalence) {
        boolean z;
        if (this.f560q == null) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkState(z, "value equivalence was already set to %s", this.f560q);
        this.f560q = (Equivalence) Preconditions.checkNotNull(equivalence);
        return this;
    }

    final Equivalence<Object> m1128b() {
        return (Equivalence) MoreObjects.firstNonNull(this.f560q, m1142k().defaultEquivalence());
    }

    final int m1134c() {
        return this.f549f == -1 ? 16 : this.f549f;
    }

    public final CacheBuilder<K, V> m1129b(int i) {
        boolean z;
        boolean z2 = true;
        if (this.f550g == -1) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkState(z, "concurrency level was already set to %s", Integer.valueOf(this.f550g));
        if (i <= 0) {
            z2 = false;
        }
        Preconditions.checkArgument(z2);
        this.f550g = i;
        return this;
    }

    final int m1135d() {
        return this.f550g == -1 ? 4 : this.f550g;
    }

    public final CacheBuilder<K, V> m1122a(long j) {
        boolean z;
        boolean z2 = true;
        Preconditions.checkState(this.f551h == -1, "maximum size was already set to %s", Long.valueOf(this.f551h));
        if (this.f552i == -1) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkState(z, "maximum weight was already set to %s", Long.valueOf(this.f552i));
        if (this.f553j == null) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkState(z, "maximum size can not be combined with weigher");
        if (j < 0) {
            z2 = false;
        }
        Preconditions.checkArgument(z2, "maximum size must not be negative");
        this.f551h = j;
        return this;
    }

    @GwtIncompatible("To be supported")
    public final CacheBuilder<K, V> m1130b(long j) {
        boolean z;
        boolean z2 = true;
        Preconditions.checkState(this.f552i == -1, "maximum weight was already set to %s", Long.valueOf(this.f552i));
        if (this.f551h == -1) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkState(z, "maximum size was already set to %s", Long.valueOf(this.f551h));
        this.f552i = j;
        if (j < 0) {
            z2 = false;
        }
        Preconditions.checkArgument(z2, "maximum weight must not be negative");
        return this;
    }

    @GwtIncompatible("To be supported")
    public final <K1 extends K, V1 extends V> CacheBuilder<K1, V1> m1126a(Weigher<? super K1, ? super V1> weigher) {
        Preconditions.checkState(this.f553j == null);
        if (this.f548e) {
            boolean z;
            if (this.f551h == -1) {
                z = true;
            } else {
                z = false;
            }
            Preconditions.checkState(z, "weigher can not be combined with maximum size", Long.valueOf(this.f551h));
        }
        this.f553j = (Weigher) Preconditions.checkNotNull(weigher);
        return this;
    }

    final long m1136e() {
        if (this.f556m == 0 || this.f557n == 0) {
            return 0;
        }
        return this.f553j == null ? this.f551h : this.f552i;
    }

    final <K1 extends K, V1 extends V> Weigher<K1, V1> m1137f() {
        return (Weigher) MoreObjects.firstNonNull(this.f553j, OneWeigher.INSTANCE);
    }

    @GwtIncompatible("java.lang.ref.WeakReference")
    public final CacheBuilder<K, V> m1138g() {
        return m1124a(Strength.WEAK);
    }

    final CacheBuilder<K, V> m1124a(Strength strength) {
        boolean z;
        if (this.f554k == null) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkState(z, "Key strength was already set to %s", this.f554k);
        this.f554k = (Strength) Preconditions.checkNotNull(strength);
        return this;
    }

    final Strength m1139h() {
        return (Strength) MoreObjects.firstNonNull(this.f554k, Strength.STRONG);
    }

    @GwtIncompatible("java.lang.ref.WeakReference")
    public final CacheBuilder<K, V> m1140i() {
        return m1133b(Strength.WEAK);
    }

    @GwtIncompatible("java.lang.ref.SoftReference")
    public final CacheBuilder<K, V> m1141j() {
        return m1133b(Strength.SOFT);
    }

    final CacheBuilder<K, V> m1133b(Strength strength) {
        boolean z;
        if (this.f555l == null) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkState(z, "Value strength was already set to %s", this.f555l);
        this.f555l = (Strength) Preconditions.checkNotNull(strength);
        return this;
    }

    final Strength m1142k() {
        return (Strength) MoreObjects.firstNonNull(this.f555l, Strength.STRONG);
    }

    public final CacheBuilder<K, V> m1123a(long j, TimeUnit timeUnit) {
        boolean z;
        if (this.f556m == -1) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkState(z, "expireAfterWrite was already set to %s ns", Long.valueOf(this.f556m));
        if (j >= 0) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkArgument(z, "duration cannot be negative: %s %s", Long.valueOf(j), timeUnit);
        this.f556m = timeUnit.toNanos(j);
        return this;
    }

    final long m1143l() {
        return this.f556m == -1 ? 0 : this.f556m;
    }

    public final CacheBuilder<K, V> m1131b(long j, TimeUnit timeUnit) {
        boolean z;
        if (this.f557n == -1) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkState(z, "expireAfterAccess was already set to %s ns", Long.valueOf(this.f557n));
        if (j >= 0) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkArgument(z, "duration cannot be negative: %s %s", Long.valueOf(j), timeUnit);
        this.f557n = timeUnit.toNanos(j);
        return this;
    }

    final long m1144m() {
        return this.f557n == -1 ? 0 : this.f557n;
    }

    final long m1145n() {
        return this.f558o == -1 ? 0 : this.f558o;
    }

    final Ticker m1121a(boolean z) {
        if (this.f562s != null) {
            return this.f562s;
        }
        return z ? Ticker.SYSTEM_TICKER : f546d;
    }

    @CheckReturnValue
    public final <K1 extends K, V1 extends V> CacheBuilder<K1, V1> m1125a(RemovalListener<? super K1, ? super V1> removalListener) {
        Preconditions.checkState(this.f561r == null);
        this.f561r = (RemovalListener) Preconditions.checkNotNull(removalListener);
        return this;
    }

    final <K1 extends K, V1 extends V> RemovalListener<K1, V1> m1146o() {
        return (RemovalListener) MoreObjects.firstNonNull(this.f561r, NullListener.INSTANCE);
    }

    final Supplier<? extends AbstractCache$StatsCounter> m1147p() {
        return this.f563t;
    }

    public final <K1 extends K, V1 extends V> LoadingCache<K1, V1> m1127a(CacheLoader<? super K1, V1> cacheLoader) {
        m1119s();
        return new LocalLoadingCache(this, cacheLoader);
    }

    public final <K1 extends K, V1 extends V> Cache<K1, V1> m1148q() {
        m1119s();
        Preconditions.checkState(this.f558o == -1, "refreshAfterWrite requires a LoadingCache");
        return new LocalManualCache(this);
    }

    private void m1119s() {
        boolean z = true;
        if (this.f553j == null) {
            if (this.f552i != -1) {
                z = false;
            }
            Preconditions.checkState(z, "maximumWeight requires weigher");
        } else if (this.f548e) {
            if (this.f552i == -1) {
                z = false;
            }
            Preconditions.checkState(z, "weigher requires maximumWeight");
        } else if (this.f552i == -1) {
            f547u.log(Level.WARNING, "ignoring weigher specified without maximumWeight");
        }
    }

    public final String toString() {
        ToStringHelper toStringHelper = MoreObjects.toStringHelper((Object) this);
        if (this.f549f != -1) {
            toStringHelper.add("initialCapacity", this.f549f);
        }
        if (this.f550g != -1) {
            toStringHelper.add("concurrencyLevel", this.f550g);
        }
        if (this.f551h != -1) {
            toStringHelper.add("maximumSize", this.f551h);
        }
        if (this.f552i != -1) {
            toStringHelper.add("maximumWeight", this.f552i);
        }
        if (this.f556m != -1) {
            toStringHelper.add("expireAfterWrite", this.f556m + "ns");
        }
        if (this.f557n != -1) {
            toStringHelper.add("expireAfterAccess", this.f557n + "ns");
        }
        if (this.f554k != null) {
            toStringHelper.add("keyStrength", Ascii.toLowerCase(this.f554k.toString()));
        }
        if (this.f555l != null) {
            toStringHelper.add("valueStrength", Ascii.toLowerCase(this.f555l.toString()));
        }
        if (this.f559p != null) {
            toStringHelper.addValue("keyEquivalence");
        }
        if (this.f560q != null) {
            toStringHelper.addValue("valueEquivalence");
        }
        if (this.f561r != null) {
            toStringHelper.addValue("removalListener");
        }
        return toStringHelper.toString();
    }
}
