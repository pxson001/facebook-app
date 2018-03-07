package com.facebook.pager;

import com.facebook.common.objectpool.ObjectPool;
import com.facebook.common.objectpool.ObjectPool.Allocator;
import com.facebook.common.time.AwakeTimeSinceBootClock;
import com.google.common.base.Objects;

/* compiled from: ccu_invalid_contact_id_event */
public class RenderInfo<T, S> {
    private static final ObjectPool<RenderInfo> f18415a = new ObjectPool(RenderInfo.class, 0, 100, 1, 500, new C21291(), AwakeTimeSinceBootClock.INSTANCE);
    public T f18416b;
    public S f18417c;
    public int f18418d = Integer.MIN_VALUE;
    public int f18419e = Integer.MAX_VALUE;
    public float f18420f = Float.MIN_VALUE;
    public float f18421g = Float.MIN_VALUE;
    public float f18422h = Float.MIN_VALUE;

    /* compiled from: ccu_invalid_contact_id_event */
    final class C21291 implements Allocator<RenderInfo> {
        C21291() {
        }

        public final void m18402a(Object obj) {
            RenderInfo renderInfo = (RenderInfo) obj;
            renderInfo.f18416b = null;
            renderInfo.f18417c = null;
            renderInfo.f18418d = Integer.MIN_VALUE;
            renderInfo.f18419e = Integer.MIN_VALUE;
            renderInfo.f18420f = Float.MIN_VALUE;
            renderInfo.f18421g = Float.MIN_VALUE;
            renderInfo.f18422h = Float.MIN_VALUE;
        }

        public final Object m18401a() {
            return new RenderInfo();
        }
    }

    public static <X, Y> RenderInfo<X, Y> m18403a() {
        return (RenderInfo) f18415a.a();
    }

    public final void m18404b() {
        f18415a.a(this);
    }

    public final T m18405d() {
        return this.f18416b;
    }

    public final int m18406f() {
        return this.f18419e;
    }

    public final int m18407g() {
        return this.f18418d;
    }

    public final float m18408h() {
        return this.f18421g;
    }

    public final float m18409i() {
        return this.f18422h;
    }

    public final float m18410j() {
        return this.f18420f;
    }

    public String toString() {
        return "object:" + this.f18416b + " position:" + this.f18418d + " width:" + this.f18421g + " height:" + this.f18422h + " offset:" + this.f18420f;
    }

    public int hashCode() {
        return Objects.hashCode(new Object[]{this.f18416b, Integer.valueOf(this.f18418d)});
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof RenderInfo)) {
            return false;
        }
        RenderInfo renderInfo = (RenderInfo) obj;
        if (Objects.equal(this.f18416b, renderInfo.f18416b) && Objects.equal(Integer.valueOf(this.f18418d), Integer.valueOf(renderInfo.f18418d))) {
            return true;
        }
        return false;
    }
}
