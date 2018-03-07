package com.facebook.timeline.data;

import com.google.common.base.Optional;
import javax.annotation.concurrent.NotThreadSafe;

@NotThreadSafe
/* compiled from: feather_overlay_end */
public abstract class TimelineDataSource<T> implements DataSource<T> {
    public int f14571a = 0;
    public T f14572b;
    protected int f14573c;
    public int f14574d = 0;
    protected int f14575e = 0;

    public void m18464a(T t, int i) {
        this.f14572b = t;
        this.f14573c = i;
        this.f14574d = m18462a(i);
        this.f14571a++;
    }

    private static int m18462a(int i) {
        switch (i) {
            case 0:
            case 1:
            case 3:
                return 1;
            case 2:
                return 2;
            default:
                throw new IllegalArgumentException("Unexpected DataType: " + i);
        }
    }

    public final Optional<T> m18463a() {
        return Optional.fromNullable(this.f14572b);
    }

    public boolean m18466d() {
        return this.f14572b != null;
    }

    public final int m18467f() {
        return this.f14575e;
    }

    public final void m18468g() {
        this.f14575e = 1;
    }

    public final void m18469h() {
        this.f14575e = 0;
    }

    public final void m18465c() {
    }
}
