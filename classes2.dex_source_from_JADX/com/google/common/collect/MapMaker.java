package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Ascii;
import com.google.common.base.Equivalence;
import com.google.common.base.MoreObjects;
import com.google.common.base.MoreObjects.ToStringHelper;
import com.google.common.base.Preconditions;
import com.google.common.base.Ticker;
import com.google.common.collect.MapMakerInternalMap.Strength;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.TimeUnit;

@GwtCompatible
/* compiled from: wifi_state */
public final class MapMaker extends GenericMapMaker<Object, Object> {
    public boolean f745b;
    int f746c = -1;
    int f747d = -1;
    int f748e = -1;
    Strength f749f;
    public Strength f750g;
    long f751h = -1;
    public long f752i = -1;
    RemovalCause f753j;
    public Equivalence<Object> f754k;
    public Ticker f755l;

    /* compiled from: wifi_state */
    public interface RemovalListener<K, V> {
        void onRemoval(RemovalNotification<K, V> removalNotification);
    }

    /* compiled from: wifi_state */
    enum RemovalCause {
        EXPLICIT {
            final boolean wasEvicted() {
                return false;
            }
        },
        REPLACED {
            final boolean wasEvicted() {
                return false;
            }
        },
        COLLECTED {
            final boolean wasEvicted() {
                return true;
            }
        },
        EXPIRED {
            final boolean wasEvicted() {
                return true;
            }
        },
        SIZE {
            final boolean wasEvicted() {
                return true;
            }
        };

        abstract boolean wasEvicted();
    }

    public final MapMaker m1476a(int i) {
        boolean z = true;
        Preconditions.checkState(this.f746c == -1, "initial capacity was already set to %s", Integer.valueOf(this.f746c));
        if (i < 0) {
            z = false;
        }
        Preconditions.checkArgument(z);
        this.f746c = i;
        return this;
    }

    final int m1482c() {
        return this.f746c == -1 ? 16 : this.f746c;
    }

    @Deprecated
    public final MapMaker m1479b(int i) {
        boolean z = false;
        Preconditions.checkState(this.f748e == -1, "maximum size was already set to %s", Integer.valueOf(this.f748e));
        if (i >= 0) {
            z = true;
        }
        Preconditions.checkArgument(z, "maximum size must not be negative");
        this.f748e = i;
        this.f745b = true;
        if (this.f748e == 0) {
            this.f753j = RemovalCause.SIZE;
        }
        return this;
    }

    public final MapMaker m1483c(int i) {
        boolean z = true;
        Preconditions.checkState(this.f747d == -1, "concurrency level was already set to %s", Integer.valueOf(this.f747d));
        if (i <= 0) {
            z = false;
        }
        Preconditions.checkArgument(z);
        this.f747d = i;
        return this;
    }

    final int m1484d() {
        return this.f747d == -1 ? 4 : this.f747d;
    }

    @GwtIncompatible("java.lang.ref.WeakReference")
    public final MapMaker m1485e() {
        return m1478a(Strength.WEAK);
    }

    public final MapMaker m1478a(Strength strength) {
        boolean z = false;
        Preconditions.checkState(this.f749f == null, "Key strength was already set to %s", this.f749f);
        this.f749f = (Strength) Preconditions.checkNotNull(strength);
        if (this.f749f != Strength.SOFT) {
            z = true;
        }
        Preconditions.checkArgument(z, "Soft keys are not supported");
        if (strength != Strength.STRONG) {
            this.f745b = true;
        }
        return this;
    }

    public final Strength m1486f() {
        return (Strength) MoreObjects.firstNonNull(this.f749f, Strength.STRONG);
    }

    @GwtIncompatible("java.lang.ref.WeakReference")
    public final MapMaker m1487g() {
        return m1481b(Strength.WEAK);
    }

    public final MapMaker m1481b(Strength strength) {
        Preconditions.checkState(this.f750g == null, "Value strength was already set to %s", this.f750g);
        this.f750g = (Strength) Preconditions.checkNotNull(strength);
        if (strength != Strength.STRONG) {
            this.f745b = true;
        }
        return this;
    }

    @Deprecated
    public final MapMaker m1477a(long j, TimeUnit timeUnit) {
        m1475c(j, timeUnit);
        this.f751h = timeUnit.toNanos(j);
        if (j == 0 && this.f753j == null) {
            this.f753j = RemovalCause.EXPIRED;
        }
        this.f745b = true;
        return this;
    }

    private void m1475c(long j, TimeUnit timeUnit) {
        boolean z;
        Preconditions.checkState(this.f751h == -1, "expireAfterWrite was already set to %s ns", Long.valueOf(this.f751h));
        if (this.f752i == -1) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkState(z, "expireAfterAccess was already set to %s ns", Long.valueOf(this.f752i));
        if (j >= 0) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkArgument(z, "duration cannot be negative: %s %s", Long.valueOf(j), timeUnit);
    }

    final long m1488i() {
        return this.f751h == -1 ? 0 : this.f751h;
    }

    @GwtIncompatible("To be supported")
    @Deprecated
    public final MapMaker m1480b(long j, TimeUnit timeUnit) {
        m1475c(j, timeUnit);
        this.f752i = timeUnit.toNanos(j);
        if (j == 0 && this.f753j == null) {
            this.f753j = RemovalCause.EXPIRED;
        }
        this.f745b = true;
        return this;
    }

    public final <K, V> ConcurrentMap<K, V> m1489l() {
        if (!this.f745b) {
            return new ConcurrentHashMap(m1482c(), 0.75f, m1484d());
        }
        return this.f753j == null ? new MapMakerInternalMap(this) : new NullConcurrentMap(this);
    }

    public final String toString() {
        ToStringHelper toStringHelper = MoreObjects.toStringHelper((Object) this);
        if (this.f746c != -1) {
            toStringHelper.add("initialCapacity", this.f746c);
        }
        if (this.f747d != -1) {
            toStringHelper.add("concurrencyLevel", this.f747d);
        }
        if (this.f748e != -1) {
            toStringHelper.add("maximumSize", this.f748e);
        }
        if (this.f751h != -1) {
            toStringHelper.add("expireAfterWrite", this.f751h + "ns");
        }
        if (this.f752i != -1) {
            toStringHelper.add("expireAfterAccess", this.f752i + "ns");
        }
        if (this.f749f != null) {
            toStringHelper.add("keyStrength", Ascii.toLowerCase(this.f749f.toString()));
        }
        if (this.f750g != null) {
            toStringHelper.add("valueStrength", Ascii.toLowerCase(this.f750g.toString()));
        }
        if (this.f754k != null) {
            toStringHelper.addValue("keyEquivalence");
        }
        if (this.f756a != null) {
            toStringHelper.addValue("removalListener");
        }
        return toStringHelper.toString();
    }
}
