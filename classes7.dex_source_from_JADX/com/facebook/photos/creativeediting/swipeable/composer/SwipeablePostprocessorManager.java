package com.facebook.photos.creativeediting.swipeable.composer;

import android.graphics.Bitmap;
import android.graphics.RectF;
import com.facebook.common.executors.ImageTransformExecutorService;
import com.facebook.common.references.CloseableReference;
import com.facebook.photos.imageprocessing.FiltersEngine;
import com.facebook.photos.imageprocessing.FiltersEngine.Session;
import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.ListeningExecutorService;
import javax.annotation.concurrent.GuardedBy;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: lockscreen_notification_setting_click */
public class SwipeablePostprocessorManager {
    public final FiltersEngine f9880a;
    @ImageTransformExecutorService
    private final ListeningExecutorService f9881b;
    public SwipeableRepeatedPostprocessor f9882c;
    public SwipeableRepeatedPostprocessor f9883d;
    public SwipeableRepeatedPostprocessor f9884e;
    public volatile boolean f9885f;
    public volatile boolean f9886g;
    public volatile boolean f9887h;
    @GuardedBy("this")
    public CloseableReference<Session> f9888i;
    @GuardedBy("this")
    private RectF[] f9889j = null;
    private final C08181 f9890k = new C08181(this);

    /* compiled from: lockscreen_notification_setting_click */
    public class C08181 {
        final /* synthetic */ SwipeablePostprocessorManager f9876a;

        C08181(SwipeablePostprocessorManager swipeablePostprocessorManager) {
            this.f9876a = swipeablePostprocessorManager;
        }

        public final void m11819a(Bitmap bitmap) {
            synchronized (this) {
                CloseableReference b = CloseableReference.b(this.f9876a.f9888i);
                if (b != null) {
                    CloseableReference.c(b);
                    return;
                }
                this.f9876a.f9888i = CloseableReference.a(this.f9876a.f9880a.a(bitmap));
                this.f9876a.f9882c.m11829a(this.f9876a.f9888i);
                this.f9876a.f9883d.m11829a(this.f9876a.f9888i);
                this.f9876a.f9884e.m11829a(this.f9876a.f9888i);
                SwipeablePostprocessorManager.m11822g(this.f9876a);
            }
        }

        public final void m11820a(SwipeableRepeatedPostprocessor swipeableRepeatedPostprocessor) {
            Preconditions.checkNotNull(swipeableRepeatedPostprocessor);
            if (swipeableRepeatedPostprocessor.equals(this.f9876a.f9882c)) {
                this.f9876a.f9885f = true;
            } else if (swipeableRepeatedPostprocessor.equals(this.f9876a.f9883d)) {
                this.f9876a.f9886g = true;
            } else if (swipeableRepeatedPostprocessor.equals(this.f9876a.f9884e)) {
                this.f9876a.f9887h = true;
            }
        }
    }

    @Inject
    public SwipeablePostprocessorManager(ListeningExecutorService listeningExecutorService, FiltersEngine filtersEngine, Provider<SwipeableRepeatedPostprocessor> provider) {
        this.f9881b = listeningExecutorService;
        this.f9880a = filtersEngine;
        this.f9882c = (SwipeableRepeatedPostprocessor) provider.get();
        this.f9883d = (SwipeableRepeatedPostprocessor) provider.get();
        this.f9884e = (SwipeableRepeatedPostprocessor) provider.get();
        this.f9882c.f9895e = this.f9890k;
        this.f9883d.f9895e = this.f9890k;
        this.f9884e.f9895e = this.f9890k;
    }

    public final void m11824a(RectF[] rectFArr) {
        synchronized (this) {
            this.f9889j = rectFArr;
        }
        m11822g(this);
    }

    public final void m11825d() {
        CloseableReference closeableReference;
        this.f9882c.m11832d();
        this.f9883d.m11832d();
        this.f9884e.m11832d();
        this.f9885f = false;
        this.f9886g = false;
        this.f9887h = false;
        synchronized (this) {
            closeableReference = this.f9888i;
            this.f9888i = null;
        }
        CloseableReference.c(closeableReference);
    }

    public final void m11826e() {
        this.f9882c.m11833e();
        this.f9883d.m11833e();
        this.f9884e.m11833e();
        synchronized (this) {
            CloseableReference b = CloseableReference.b(this.f9888i);
        }
        if (b != null) {
            this.f9882c.m11829a(b);
            this.f9883d.m11829a(b);
            this.f9884e.m11829a(b);
            CloseableReference.c(b);
            return;
        }
        m11823h(this);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void m11822g(com.facebook.photos.creativeediting.swipeable.composer.SwipeablePostprocessorManager r4) {
        /*
        monitor-enter(r4);
        r0 = r4.f9888i;	 Catch:{ all -> 0x0023 }
        r0 = com.facebook.common.references.CloseableReference.b(r0);	 Catch:{ all -> 0x0023 }
        r1 = r4.f9889j;	 Catch:{ all -> 0x0023 }
        if (r1 == 0) goto L_0x000d;
    L_0x000b:
        if (r0 != 0) goto L_0x0014;
    L_0x000d:
        if (r0 == 0) goto L_0x0012;
    L_0x000f:
        r0.close();	 Catch:{ all -> 0x0023 }
    L_0x0012:
        monitor-exit(r4);	 Catch:{ all -> 0x0023 }
    L_0x0013:
        return;
    L_0x0014:
        monitor-exit(r4);	 Catch:{ all -> 0x0023 }
        r2 = r4.f9881b;
        r3 = new com.facebook.photos.creativeediting.swipeable.composer.SwipeablePostprocessorManager$2;
        r3.<init>(r4, r1, r0);
        r0 = -1377546764; // 0xffffffffade44df4 float:-2.5955217E-11 double:NaN;
        com.facebook.tools.dextr.runtime.detour.ExecutorDetour.a(r2, r3, r0);
        goto L_0x0013;
    L_0x0023:
        r0 = move-exception;
        monitor-exit(r4);	 Catch:{  }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.photos.creativeediting.swipeable.composer.SwipeablePostprocessorManager.g(com.facebook.photos.creativeediting.swipeable.composer.SwipeablePostprocessorManager):void");
    }

    public static void m11823h(SwipeablePostprocessorManager swipeablePostprocessorManager) {
        swipeablePostprocessorManager.f9882c.c();
        swipeablePostprocessorManager.f9883d.c();
        swipeablePostprocessorManager.f9884e.c();
    }
}
