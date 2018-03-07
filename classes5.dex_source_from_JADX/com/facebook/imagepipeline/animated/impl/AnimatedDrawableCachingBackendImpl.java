package com.facebook.imagepipeline.animated.impl;

import android.app.ActivityManager;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.support.v4.util.SparseArrayCompat;
import bolts.Continuation;
import bolts.Task;
import com.facebook.common.executors.SerialExecutorService;
import com.facebook.common.references.CloseableReference;
import com.facebook.common.references.ResourceReleaser;
import com.facebook.common.time.MonotonicClock;
import com.facebook.imagepipeline.animated.base.AnimatedDrawableBackend;
import com.facebook.imagepipeline.animated.base.AnimatedDrawableCachingBackend;
import com.facebook.imagepipeline.animated.base.AnimatedDrawableFrameInfo.DisposalMethod;
import com.facebook.imagepipeline.animated.base.AnimatedDrawableOptions;
import com.facebook.imagepipeline.animated.base.DelegatingAnimatedDrawableBackend;
import com.facebook.imagepipeline.animated.impl.AnimatedImageCompositor.Callback;
import com.facebook.imagepipeline.animated.util.AnimatedDrawableUtil;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: TRAVEL_IN */
public class AnimatedDrawableCachingBackendImpl extends DelegatingAnimatedDrawableBackend implements AnimatedDrawableCachingBackend {
    private static final Class<?> f13644a = AnimatedDrawableCachingBackendImpl.class;
    private static final AtomicInteger f13645b = new AtomicInteger();
    private final SerialExecutorService f13646c;
    private final AnimatedDrawableUtil f13647d;
    private final ActivityManager f13648e;
    private final MonotonicClock f13649f;
    private final AnimatedDrawableBackend f13650g;
    private final AnimatedDrawableOptions f13651h;
    private final AnimatedImageCompositor f13652i;
    private final ResourceReleaser<Bitmap> f13653j;
    private final double f13654k;
    private final double f13655l;
    @GuardedBy("this")
    private final List<Bitmap> f13656m;
    @GuardedBy("this")
    private final SparseArrayCompat<Task<Object>> f13657n;
    @GuardedBy("this")
    private final SparseArrayCompat<CloseableReference<Bitmap>> f13658o;
    @GuardedBy("this")
    private final WhatToKeepCachedArray f13659p;
    @GuardedBy("ui-thread")
    private int f13660q;

    /* compiled from: TRAVEL_IN */
    class C12971 implements Callback {
        final /* synthetic */ AnimatedDrawableCachingBackendImpl f13637a;

        C12971(AnimatedDrawableCachingBackendImpl animatedDrawableCachingBackendImpl) {
            this.f13637a = animatedDrawableCachingBackendImpl;
        }

        public final void mo1258a(int i, Bitmap bitmap) {
            AnimatedDrawableCachingBackendImpl.m22944a(this.f13637a, i, bitmap);
        }

        public final CloseableReference<Bitmap> mo1257a(int i) {
            return AnimatedDrawableCachingBackendImpl.m22949i(this.f13637a, i);
        }
    }

    /* compiled from: TRAVEL_IN */
    class C12982 implements ResourceReleaser<Bitmap> {
        final /* synthetic */ AnimatedDrawableCachingBackendImpl f13638a;

        C12982(AnimatedDrawableCachingBackendImpl animatedDrawableCachingBackendImpl) {
            this.f13638a = animatedDrawableCachingBackendImpl;
        }

        public final void m22939a(Object obj) {
            this.f13638a.m22958a((Bitmap) obj);
        }
    }

    public final /* synthetic */ AnimatedDrawableBackend mo1259a(Rect rect) {
        return mo1261b(rect);
    }

    public AnimatedDrawableCachingBackendImpl(SerialExecutorService serialExecutorService, ActivityManager activityManager, AnimatedDrawableUtil animatedDrawableUtil, MonotonicClock monotonicClock, AnimatedDrawableBackend animatedDrawableBackend, AnimatedDrawableOptions animatedDrawableOptions) {
        double d;
        super(animatedDrawableBackend);
        this.f13646c = serialExecutorService;
        this.f13648e = activityManager;
        this.f13647d = animatedDrawableUtil;
        this.f13649f = monotonicClock;
        this.f13650g = animatedDrawableBackend;
        this.f13651h = animatedDrawableOptions;
        if (animatedDrawableOptions.f13608d >= 0) {
            d = (double) (animatedDrawableOptions.f13608d / 1024);
        } else {
            int i;
            if (activityManager.getMemoryClass() > 32) {
                i = 5242880;
            } else {
                i = 3145728;
            }
            d = (double) (i / 1024);
        }
        this.f13654k = d;
        this.f13652i = new AnimatedImageCompositor(animatedDrawableBackend, new C12971(this));
        this.f13653j = new C12982(this);
        this.f13656m = new ArrayList();
        this.f13657n = new SparseArrayCompat(10);
        this.f13658o = new SparseArrayCompat(10);
        this.f13659p = new WhatToKeepCachedArray(this.f13650g.mo1244c());
        this.f13655l = (double) ((((this.f13650g.mo1252g() * this.f13650g.mo1253h()) / 1024) * this.f13650g.mo1244c()) * 4);
    }

    protected synchronized void finalize() {
        super.finalize();
        this.f13658o.a();
        f13645b.addAndGet(-this.f13656m.size());
        this.f13656m.clear();
    }

    private Bitmap m22951m() {
        f13645b.incrementAndGet();
        Integer.valueOf(f13645b.get());
        return Bitmap.createBitmap(this.f13650g.mo1252g(), this.f13650g.mo1253h(), Config.ARGB_8888);
    }

    public final void mo1241a(int i, Canvas canvas) {
        throw new IllegalStateException();
    }

    public final CloseableReference<Bitmap> mo1262g(int i) {
        this.f13660q = i;
        CloseableReference<Bitmap> a = m22941a(i, false);
        m22953o();
        return a;
    }

    public final CloseableReference<Bitmap> mo1263l() {
        return mo1240a().m22884c();
    }

    public final AnimatedDrawableCachingBackend mo1261b(Rect rect) {
        AnimatedDrawableBackend a = this.f13650g.mo1259a(rect);
        return a == this.f13650g ? this : new AnimatedDrawableCachingBackendImpl(this.f13646c, this.f13648e, this.f13647d, this.f13649f, a, this.f13651h);
    }

    public final synchronized void mo1256k() {
        this.f13659p.m22994a(false);
        m22955q();
        for (Bitmap recycle : this.f13656m) {
            recycle.recycle();
            f13645b.decrementAndGet();
        }
        this.f13656m.clear();
        this.f13650g.mo1256k();
        Integer.valueOf(f13645b.get());
    }

    public final int mo1255j() {
        int i;
        int i2 = 0;
        synchronized (this) {
            i = 0;
            for (Bitmap a : this.f13656m) {
                i += AnimatedDrawableUtil.a(a);
            }
            while (i2 < this.f13658o.a()) {
                i += AnimatedDrawableUtil.a((Bitmap) ((CloseableReference) this.f13658o.f(i2)).a());
                i2++;
            }
        }
        return this.f13650g.mo1255j() + i;
    }

    public final void mo1260a(StringBuilder stringBuilder) {
        if (this.f13651h.f13606b) {
            stringBuilder.append("Pinned To Memory");
        } else {
            if (this.f13655l < this.f13654k) {
                stringBuilder.append("within ");
            } else {
                stringBuilder.append("exceeds ");
            }
            AnimatedDrawableUtil.a(stringBuilder, (int) this.f13654k);
        }
        if (m22954p() && this.f13651h.f13607c) {
            stringBuilder.append(" MT");
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.facebook.common.references.CloseableReference<android.graphics.Bitmap> m22941a(int r9, boolean r10) {
        /*
        r8 = this;
        r6 = 10;
        r0 = r8.f13649f;
        r2 = r0.now();
        monitor-enter(r8);	 Catch:{ all -> 0x005b }
        r0 = r8.f13659p;	 Catch:{ all -> 0x0058 }
        r1 = 1;
        r0.m22993a(r9, r1);	 Catch:{ all -> 0x0058 }
        r0 = m22949i(r8, r9);	 Catch:{ all -> 0x0058 }
        if (r0 == 0) goto L_0x0029;
    L_0x0015:
        monitor-exit(r8);	 Catch:{ all -> 0x0058 }
        r1 = r8.f13649f;
        r4 = r1.now();
        r2 = r4 - r2;
        r1 = (r2 > r6 ? 1 : (r2 == r6 ? 0 : -1));
        if (r1 <= 0) goto L_0x0028;
    L_0x0022:
        java.lang.Integer.valueOf(r9);
        java.lang.Long.valueOf(r2);
    L_0x0028:
        return r0;
    L_0x0029:
        monitor-exit(r8);	 Catch:{  }
        if (r10 == 0) goto L_0x0074;
    L_0x002c:
        r1 = r8.m22952n();	 Catch:{  }
        r4 = r8.f13652i;	 Catch:{ all -> 0x006f }
        r0 = r1.a();	 Catch:{ all -> 0x006f }
        r0 = (android.graphics.Bitmap) r0;	 Catch:{ all -> 0x006f }
        r4.m22989a(r9, r0);	 Catch:{ all -> 0x006f }
        r8.m22943a(r9, r1);	 Catch:{ all -> 0x006f }
        r0 = r1.b();	 Catch:{ all -> 0x006f }
        r1.close();	 Catch:{  }
        r1 = r8.f13649f;
        r4 = r1.now();
        r2 = r4 - r2;
        r1 = (r2 > r6 ? 1 : (r2 == r6 ? 0 : -1));
        if (r1 <= 0) goto L_0x0028;
    L_0x0051:
        java.lang.Integer.valueOf(r9);
        java.lang.Long.valueOf(r2);
        goto L_0x0028;
    L_0x0058:
        r0 = move-exception;
        monitor-exit(r8);	 Catch:{  }
        throw r0;	 Catch:{  }
    L_0x005b:
        r0 = move-exception;
        r1 = r8.f13649f;
        r4 = r1.now();
        r2 = r4 - r2;
        r1 = (r2 > r6 ? 1 : (r2 == r6 ? 0 : -1));
        if (r1 <= 0) goto L_0x006e;
    L_0x0068:
        java.lang.Integer.valueOf(r9);
        java.lang.Long.valueOf(r2);
    L_0x006e:
        throw r0;
    L_0x006f:
        r0 = move-exception;
        r1.close();	 Catch:{  }
        throw r0;	 Catch:{  }
    L_0x0074:
        r0 = r8.f13649f;
        r0 = r0.now();
        r0 = r0 - r2;
        r2 = (r0 > r6 ? 1 : (r0 == r6 ? 0 : -1));
        if (r2 <= 0) goto L_0x0085;
    L_0x007f:
        java.lang.Integer.valueOf(r9);
        java.lang.Long.valueOf(r0);
    L_0x0085:
        r0 = 0;
        goto L_0x0028;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.imagepipeline.animated.impl.AnimatedDrawableCachingBackendImpl.a(int, boolean):com.facebook.common.references.CloseableReference<android.graphics.Bitmap>");
    }

    public static void m22944a(AnimatedDrawableCachingBackendImpl animatedDrawableCachingBackendImpl, int i, Bitmap bitmap) {
        Object obj = null;
        synchronized (animatedDrawableCachingBackendImpl) {
            if (animatedDrawableCachingBackendImpl.f13659p.m22995a(i) && animatedDrawableCachingBackendImpl.f13658o.a(i) == null) {
                obj = 1;
            }
        }
        if (obj != null) {
            animatedDrawableCachingBackendImpl.m22947b(i, bitmap);
        }
    }

    private void m22947b(int i, Bitmap bitmap) {
        CloseableReference n = m22952n();
        try {
            Canvas canvas = new Canvas((Bitmap) n.a());
            canvas.drawColor(0, Mode.SRC);
            canvas.drawBitmap(bitmap, 0.0f, 0.0f, null);
            m22943a(i, n);
        } finally {
            n.close();
        }
    }

    private CloseableReference<Bitmap> m22952n() {
        Object m;
        synchronized (this) {
            long nanoTime = System.nanoTime();
            long convert = TimeUnit.NANOSECONDS.convert(20, TimeUnit.MILLISECONDS) + nanoTime;
            while (this.f13656m.isEmpty() && nanoTime < convert) {
                try {
                    TimeUnit.NANOSECONDS.timedWait(this, convert - nanoTime);
                    nanoTime = System.nanoTime();
                } catch (Throwable e) {
                    Thread.currentThread().interrupt();
                    throw new RuntimeException(e);
                }
            }
            if (this.f13656m.isEmpty()) {
                m = m22951m();
            } else {
                Bitmap bitmap = (Bitmap) this.f13656m.remove(this.f13656m.size() - 1);
            }
        }
        return CloseableReference.a(m, this.f13653j);
    }

    final synchronized void m22958a(Bitmap bitmap) {
        this.f13656m.add(bitmap);
    }

    private synchronized void m22953o() {
        int i = 1;
        synchronized (this) {
            int i2;
            int i3;
            int i4 = this.f13650g.mo1239a(this.f13660q).f13604g == DisposalMethod.DISPOSE_TO_PREVIOUS ? 1 : 0;
            int i5 = this.f13660q;
            if (i4 != 0) {
                i2 = 1;
            } else {
                i2 = 0;
            }
            i2 = Math.max(0, i5 - i2);
            if (this.f13651h.f13607c) {
                i3 = 3;
            } else {
                i3 = 0;
            }
            if (i4 == 0) {
                i = 0;
            }
            int max = Math.max(i3, i);
            i = (i2 + max) % this.f13650g.mo1244c();
            m22946b(i2, i);
            if (!m22954p()) {
                this.f13659p.m22994a(true);
                this.f13659p.m22992a(i2, i);
                for (i = i2; i >= 0; i--) {
                    if (this.f13658o.a(i) != null) {
                        this.f13659p.m22993a(i, true);
                        break;
                    }
                }
                m22955q();
            }
            if (this.f13651h.f13607c) {
                m22942a(i2, max);
            } else {
                m22946b(this.f13660q, this.f13660q);
            }
        }
    }

    private boolean m22954p() {
        if (!this.f13651h.f13606b && this.f13655l >= this.f13654k) {
            return false;
        }
        return true;
    }

    private synchronized void m22942a(int i, int i2) {
        for (int i3 = 0; i3 < i2; i3++) {
            final int c = (i + i3) % this.f13650g.mo1244c();
            Task task = (Task) this.f13657n.a(c);
            if (!m22950j(c) && task == null) {
                task = Task.a(new Callable<Object>(this) {
                    final /* synthetic */ AnimatedDrawableCachingBackendImpl f13640b;

                    public Object call() {
                        AnimatedDrawableCachingBackendImpl.m22948h(this.f13640b, c);
                        return null;
                    }
                }, this.f13646c);
                this.f13657n.a(c, task);
                task.a(new Continuation<Object, Object>(this) {
                    final /* synthetic */ AnimatedDrawableCachingBackendImpl f13643c;

                    public final Object m22940a(Task<Object> task) {
                        AnimatedDrawableCachingBackendImpl.m22945a(this.f13643c, task, c);
                        return null;
                    }
                });
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void m22948h(com.facebook.imagepipeline.animated.impl.AnimatedDrawableCachingBackendImpl r4, int r5) {
        /*
        monitor-enter(r4);
        r0 = r4.f13659p;	 Catch:{ all -> 0x0013 }
        r0 = r0.m22995a(r5);	 Catch:{ all -> 0x0013 }
        if (r0 != 0) goto L_0x000b;
    L_0x0009:
        monitor-exit(r4);	 Catch:{ all -> 0x0013 }
    L_0x000a:
        return;
    L_0x000b:
        r0 = r4.m22950j(r5);	 Catch:{ all -> 0x0013 }
        if (r0 == 0) goto L_0x0016;
    L_0x0011:
        monitor-exit(r4);	 Catch:{ all -> 0x0013 }
        goto L_0x000a;
    L_0x0013:
        r0 = move-exception;
        monitor-exit(r4);	 Catch:{ all -> 0x0013 }
        throw r0;
    L_0x0016:
        monitor-exit(r4);	 Catch:{  }
        r0 = r4.f13650g;
        r1 = r0.mo1249e(r5);
        if (r1 == 0) goto L_0x0026;
    L_0x001f:
        r4.m22943a(r5, r1);	 Catch:{ all -> 0x003f }
    L_0x0022:
        com.facebook.common.references.CloseableReference.c(r1);
        goto L_0x000a;
    L_0x0026:
        r2 = r4.m22952n();	 Catch:{  }
        r3 = r4.f13652i;	 Catch:{ all -> 0x0044 }
        r0 = r2.a();	 Catch:{ all -> 0x0044 }
        r0 = (android.graphics.Bitmap) r0;	 Catch:{ all -> 0x0044 }
        r3.m22989a(r5, r0);	 Catch:{ all -> 0x0044 }
        r4.m22943a(r5, r2);	 Catch:{ all -> 0x0044 }
        java.lang.Integer.valueOf(r5);	 Catch:{ all -> 0x0044 }
        r2.close();	 Catch:{  }
        goto L_0x0022;
    L_0x003f:
        r0 = move-exception;
        com.facebook.common.references.CloseableReference.c(r1);
        throw r0;
    L_0x0044:
        r0 = move-exception;
        r2.close();	 Catch:{  }
        throw r0;	 Catch:{  }
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.imagepipeline.animated.impl.AnimatedDrawableCachingBackendImpl.h(com.facebook.imagepipeline.animated.impl.AnimatedDrawableCachingBackendImpl, int):void");
    }

    public static synchronized void m22945a(AnimatedDrawableCachingBackendImpl animatedDrawableCachingBackendImpl, Task task, int i) {
        synchronized (animatedDrawableCachingBackendImpl) {
            int g = animatedDrawableCachingBackendImpl.f13657n.g(i);
            if (g >= 0 && ((Task) animatedDrawableCachingBackendImpl.f13657n.f(g)) == task) {
                animatedDrawableCachingBackendImpl.f13657n.d(g);
                if (task.d() != null) {
                    task.d();
                    new Object[1][0] = Integer.valueOf(i);
                }
            }
        }
    }

    private synchronized void m22946b(int i, int i2) {
        int i3 = 0;
        while (i3 < this.f13657n.a()) {
            if (AnimatedDrawableUtil.a(i, i2, this.f13657n.e(i3))) {
                this.f13657n.f(i3);
                this.f13657n.d(i3);
            } else {
                i3++;
            }
        }
    }

    private synchronized void m22955q() {
        int i = 0;
        while (i < this.f13658o.a()) {
            if (this.f13659p.m22995a(this.f13658o.e(i))) {
                i++;
            } else {
                CloseableReference closeableReference = (CloseableReference) this.f13658o.f(i);
                this.f13658o.d(i);
                closeableReference.close();
            }
        }
    }

    private synchronized void m22943a(int i, CloseableReference<Bitmap> closeableReference) {
        if (this.f13659p.m22995a(i)) {
            int g = this.f13658o.g(i);
            if (g >= 0) {
                ((CloseableReference) this.f13658o.f(g)).close();
                this.f13658o.d(g);
            }
            this.f13658o.a(i, closeableReference.b());
        }
    }

    public static synchronized CloseableReference m22949i(AnimatedDrawableCachingBackendImpl animatedDrawableCachingBackendImpl, int i) {
        CloseableReference b;
        synchronized (animatedDrawableCachingBackendImpl) {
            b = CloseableReference.b((CloseableReference) animatedDrawableCachingBackendImpl.f13658o.a(i));
            if (b == null) {
                b = animatedDrawableCachingBackendImpl.f13650g.mo1249e(i);
            }
        }
        return b;
    }

    private synchronized boolean m22950j(int i) {
        boolean z;
        z = this.f13658o.a(i) != null || this.f13650g.mo1251f(i);
        return z;
    }
}
