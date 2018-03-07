package com.facebook.imagepipeline.memory;

import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.VisibleForTesting;
import java.util.LinkedList;
import java.util.Queue;
import javax.annotation.Nullable;
import javax.annotation.concurrent.NotThreadSafe;

@VisibleForTesting
@NotThreadSafe
/* compiled from: page/%s/pendingedits */
public class Bucket<V> {
    public final int f10582a;
    public final int f10583b;
    final Queue f10584c;
    private int f10585d;

    public Bucket(int i, int i2, int i3) {
        boolean z;
        boolean z2 = true;
        Preconditions.b(i > 0);
        if (i2 >= 0) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.b(z);
        if (i3 < 0) {
            z2 = false;
        }
        Preconditions.b(z2);
        this.f10582a = i;
        this.f10583b = i2;
        this.f10584c = new LinkedList();
        this.f10585d = i3;
    }

    public final boolean m15758a() {
        return this.f10585d + m15759b() > this.f10583b;
    }

    final int m15759b() {
        return this.f10584c.size();
    }

    @Nullable
    public final V m15761c() {
        V d = m15762d();
        if (d != null) {
            this.f10585d++;
        }
        return d;
    }

    @Nullable
    public V m15762d() {
        return this.f10584c.poll();
    }

    public final void m15763e() {
        this.f10585d++;
    }

    public final void m15757a(V v) {
        Preconditions.a(v);
        Preconditions.b(this.f10585d > 0);
        this.f10585d--;
        m15760b(v);
    }

    void m15760b(V v) {
        this.f10584c.add(v);
    }

    public final void m15764f() {
        Preconditions.b(this.f10585d > 0);
        this.f10585d--;
    }

    public final int m15765g() {
        return this.f10585d;
    }
}
