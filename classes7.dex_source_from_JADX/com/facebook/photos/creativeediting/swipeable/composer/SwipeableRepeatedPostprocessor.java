package com.facebook.photos.creativeediting.swipeable.composer;

import com.facebook.cache.common.CacheKey;
import com.facebook.cache.common.SimpleCacheKey;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.request.BaseRepeatedPostProcessor;
import com.facebook.photos.creativeediting.model.Filter;
import com.facebook.photos.creativeediting.swipeable.composer.SwipeablePostprocessorManager.C08181;
import com.facebook.photos.imageprocessing.FiltersEngine.Session;
import com.google.common.base.Preconditions;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: lockscreen_notification_screen_on */
public class SwipeableRepeatedPostprocessor extends BaseRepeatedPostProcessor {
    private static final String f9891a = SwipeableRepeatedPostprocessor.class.getCanonicalName();
    @GuardedBy("this")
    private CloseableReference<Session> f9892b = null;
    @GuardedBy("this")
    private String f9893c = Filter.PassThrough.name();
    @GuardedBy("this")
    private boolean f9894d;
    @Nullable
    public C08181 f9895e;
    private CacheKey f9896f;
    private boolean f9897g;

    public final String m11827a() {
        return f9891a;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void m11828a(android.graphics.Bitmap r4) {
        /*
        r3 = this;
        monitor-enter(r3);
        r0 = r3.f9894d;	 Catch:{ all -> 0x003c }
        if (r0 == 0) goto L_0x0013;
    L_0x0005:
        r0 = r3.f9892b;	 Catch:{ all -> 0x003c }
        if (r0 == 0) goto L_0x0011;
    L_0x0009:
        r0 = r3.f9892b;	 Catch:{ all -> 0x003c }
        r0.close();	 Catch:{ all -> 0x003c }
        r0 = 0;
        r3.f9892b = r0;	 Catch:{ all -> 0x003c }
    L_0x0011:
        monitor-exit(r3);	 Catch:{ all -> 0x003c }
    L_0x0012:
        return;
    L_0x0013:
        r0 = r3.f9892b;	 Catch:{ all -> 0x003c }
        r1 = com.facebook.common.references.CloseableReference.b(r0);	 Catch:{ all -> 0x003c }
        r2 = r3.f9893c;	 Catch:{ all -> 0x003c }
        monitor-exit(r3);	 Catch:{ all -> 0x003c }
        if (r1 == 0) goto L_0x003f;
    L_0x001e:
        r0 = r1.a();
        r0 = (com.facebook.photos.imageprocessing.FiltersEngine.Session) r0;
        r0 = r0.a(r4, r2);
        if (r0 == 0) goto L_0x003f;
    L_0x002a:
        r0 = r3.f9895e;
        if (r0 == 0) goto L_0x003f;
    L_0x002e:
        r0 = r3.f9895e;
        r0.m11820a(r3);
        r1.close();
    L_0x0036:
        if (r1 == 0) goto L_0x0012;
    L_0x0038:
        r1.close();
        goto L_0x0012;
    L_0x003c:
        r0 = move-exception;
        monitor-exit(r3);	 Catch:{  }
        throw r0;
    L_0x003f:
        r0 = r3.f9895e;
        if (r0 == 0) goto L_0x0036;
    L_0x0043:
        r0 = r3.f9895e;
        r0.m11819a(r4);
        goto L_0x0036;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.photos.creativeediting.swipeable.composer.SwipeableRepeatedPostprocessor.a(android.graphics.Bitmap):void");
    }

    @Nullable
    public final CacheKey m11831b() {
        return this.f9897g ? this.f9896f : null;
    }

    public final void m11829a(CloseableReference<Session> closeableReference) {
        synchronized (this) {
            if (this.f9894d) {
                return;
            }
            this.f9892b = CloseableReference.b(closeableReference);
            c();
        }
    }

    public final void m11830a(String str) {
        Preconditions.checkNotNull(str);
        synchronized (this) {
            if (this.f9894d) {
                return;
            }
            this.f9893c = str;
            this.f9896f = new SimpleCacheKey(str);
            c();
        }
    }

    public final void m11832d() {
        synchronized (this) {
            this.f9894d = true;
        }
        c();
    }

    public final synchronized void m11833e() {
        this.f9894d = false;
    }
}
