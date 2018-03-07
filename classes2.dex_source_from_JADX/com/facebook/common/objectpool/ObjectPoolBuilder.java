package com.facebook.common.objectpool;

import com.facebook.common.objectpool.ObjectPool.Allocator;
import com.facebook.common.objectpool.ObjectPool.BasicAllocator;
import com.facebook.common.time.MonotonicClock;
import javax.annotation.Nullable;

/* compiled from: zero_rating2/ */
public class ObjectPoolBuilder<T> {
    private Class<T> f512a;
    private int f513b;
    public int f514c;
    private int f515d;
    private long f516e;
    public Allocator<T> f517f;
    private MonotonicClock f518g;
    private final ObjectPoolManager f519h;

    public ObjectPoolBuilder(Class<T> cls, MonotonicClock monotonicClock) {
        this(null, cls, monotonicClock);
    }

    public ObjectPoolBuilder(@Nullable ObjectPoolManager objectPoolManager, Class<T> cls, MonotonicClock monotonicClock) {
        this.f513b = 16;
        this.f514c = 1024;
        this.f515d = 16;
        this.f516e = 60000;
        this.f519h = objectPoolManager;
        this.f512a = cls;
        this.f518g = monotonicClock;
    }

    public final ObjectPool<T> m1047a() {
        if (this.f518g == null) {
            throw new IllegalArgumentException("Must add a clock to the object pool builder");
        }
        Allocator allocator = this.f517f;
        if (allocator == null) {
            allocator = new BasicAllocator(this.f512a);
        }
        ObjectPool<T> objectPool = new ObjectPool(this.f512a, this.f513b, this.f514c, this.f515d, this.f516e, allocator, this.f518g);
        if (this.f519h != null) {
            ObjectPoolManager objectPoolManager = this.f519h;
            objectPoolManager.a.put(this.f512a, objectPool);
        }
        return objectPool;
    }
}
