package com.facebook.common.jniexecutors;

import com.facebook.common.objectpool.ObjectPool;
import com.facebook.common.objectpool.ObjectPool.BasicAllocator;
import com.facebook.common.objectpool.ObjectPoolBuilder;
import com.facebook.common.time.AwakeTimeSinceBootClock;
import com.facebook.jni.HybridData;
import com.facebook.proguard.annotations.DoNotStrip;
import com.facebook.soloader.SoLoader;

@DoNotStrip
/* compiled from: max_viewers */
public final class NativeRunnable implements Runnable {
    private static final ObjectPool<NativeRunnable> f8176a;
    @DoNotStrip
    public HybridData mHybridData;

    /* compiled from: max_viewers */
    final class C03961 extends BasicAllocator<NativeRunnable> {
        C03961(Class cls) {
            super(cls);
        }

        public final void m8476a(Object obj) {
            ((NativeRunnable) obj).mHybridData = null;
        }

        public final Object m8475a() {
            return new NativeRunnable(null);
        }
    }

    public final native void nativeRun();

    static {
        ObjectPoolBuilder objectPoolBuilder = new ObjectPoolBuilder(NativeRunnable.class, AwakeTimeSinceBootClock.INSTANCE);
        objectPoolBuilder.f = new C03961(NativeRunnable.class);
        f8176a = objectPoolBuilder.a();
        SoLoader.a("jniexecutors");
    }

    @DoNotStrip
    public static NativeRunnable allocate(HybridData hybridData) {
        NativeRunnable nativeRunnable = (NativeRunnable) f8176a.a();
        nativeRunnable.mHybridData = hybridData;
        return nativeRunnable;
    }

    @DoNotStrip
    public final void release() {
        f8176a.a(this);
    }

    @DoNotStrip
    public NativeRunnable(HybridData hybridData) {
        this.mHybridData = hybridData;
    }

    @DoNotStrip
    public final void run() {
        nativeRun();
    }
}
