package com.facebook.photos.imageprocessing;

import android.graphics.RectF;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.executors.ConstrainedListeningExecutorService;
import com.facebook.common.executors.ConstrainedListeningExecutorServiceFactory;
import com.facebook.common.executors.DefaultConstrainedListeningExecutorService;
import com.facebook.common.executors.ExecutorsUserScopeHelper;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.request.BaseRepeatedPostProcessor;
import com.facebook.photos.creativeediting.model.Filter;
import com.facebook.photos.imageprocessing.FiltersEngine.Session;
import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.ThreadSafe;
import javax.inject.Inject;

@ThreadSafe
/* compiled from: hdr */
public class FiltersRepeatedPostprocessor extends BaseRepeatedPostProcessor {
    private static final String f13053a = FiltersRepeatedPostprocessor.class.getSimpleName();
    private static ConstrainedListeningExecutorService f13054c;
    private final String f13055b = "EDITABLE_PHOTO_POSTPROCESSOR";
    private final AbstractFbErrorReporter f13056d;
    @GuardedBy("this")
    private CloseableReference<Session> f13057e = null;
    @GuardedBy("this")
    private RectF[] f13058f = null;
    @GuardedBy("this")
    private boolean f13059g = false;
    @GuardedBy("this")
    public boolean f13060h = false;
    @GuardedBy("this")
    private String f13061i = Filter.PassThrough.name();
    public FiltersEngine f13062j;
    public State f13063k = State.NONE;

    /* compiled from: hdr */
    enum State {
        NONE,
        PREPROCESSING,
        APPLYING,
        CLOSING
    }

    @Inject
    public FiltersRepeatedPostprocessor(FiltersEngine filtersEngine, ConstrainedListeningExecutorServiceFactory constrainedListeningExecutorServiceFactory, AbstractFbErrorReporter abstractFbErrorReporter) {
        this.f13062j = filtersEngine;
        this.f13056d = abstractFbErrorReporter;
        if (f13054c == null) {
            String str = "autoenhance";
            f13054c = ExecutorsUserScopeHelper.a(constrainedListeningExecutorServiceFactory.c, DefaultConstrainedListeningExecutorService.a(str, 8, 64, constrainedListeningExecutorServiceFactory.a.d(str), constrainedListeningExecutorServiceFactory.b, constrainedListeningExecutorServiceFactory.d));
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void m20393a(android.graphics.Bitmap r10) {
        /*
        r9 = this;
        r3 = 1;
        monitor-enter(r9);
        r0 = com.facebook.photos.creativeediting.model.Filter.PassThrough;	 Catch:{ all -> 0x0021 }
        r0 = r0.name();	 Catch:{ all -> 0x0021 }
        r1 = r9.f13061i;	 Catch:{ all -> 0x0021 }
        r0 = r0.equals(r1);	 Catch:{ all -> 0x0021 }
        if (r0 == 0) goto L_0x0012;
    L_0x0010:
        monitor-exit(r9);	 Catch:{ all -> 0x0021 }
    L_0x0011:
        return;
    L_0x0012:
        r0 = r9.f13063k;	 Catch:{ all -> 0x0021 }
        r1 = com.facebook.photos.imageprocessing.FiltersRepeatedPostprocessor.State.NONE;	 Catch:{ all -> 0x0021 }
        if (r0 != r1) goto L_0x0024;
    L_0x0018:
        r0 = com.facebook.photos.imageprocessing.FiltersRepeatedPostprocessor.State.PREPROCESSING;	 Catch:{ all -> 0x0021 }
        r9.f13063k = r0;	 Catch:{ all -> 0x0021 }
        r9.c();	 Catch:{ all -> 0x0021 }
        monitor-exit(r9);	 Catch:{ all -> 0x0021 }
        goto L_0x0011;
    L_0x0021:
        r0 = move-exception;
        monitor-exit(r9);	 Catch:{ all -> 0x0021 }
        throw r0;
    L_0x0024:
        r0 = r9.f13063k;	 Catch:{  }
        r1 = com.facebook.photos.imageprocessing.FiltersRepeatedPostprocessor.State.CLOSING;	 Catch:{  }
        if (r0 != r1) goto L_0x002f;
    L_0x002a:
        r9.m20397e();	 Catch:{  }
        monitor-exit(r9);	 Catch:{  }
        goto L_0x0011;
    L_0x002f:
        monitor-exit(r9);	 Catch:{  }
        monitor-enter(r9);
        r0 = r9.f13057e;	 Catch:{ all -> 0x0069 }
        r6 = com.facebook.common.references.CloseableReference.b(r0);	 Catch:{ all -> 0x0069 }
        r4 = r9.f13058f;	 Catch:{ all -> 0x0069 }
        r7 = r9.f13063k;	 Catch:{ all -> 0x0069 }
        r5 = r9.f13061i;	 Catch:{ all -> 0x0069 }
        monitor-exit(r9);	 Catch:{ all -> 0x0069 }
        if (r6 != 0) goto L_0x00c5;
    L_0x0040:
        if (r4 == 0) goto L_0x00c5;
    L_0x0042:
        r0 = com.facebook.photos.imageprocessing.FiltersRepeatedPostprocessor.State.PREPROCESSING;
        if (r7 == r0) goto L_0x004a;
    L_0x0046:
        r0 = com.facebook.photos.imageprocessing.FiltersRepeatedPostprocessor.State.APPLYING;
        if (r7 != r0) goto L_0x0065;
    L_0x004a:
        r2 = new java.util.concurrent.CountDownLatch;
        r2.<init>(r3);
        r8 = f13054c;	 Catch:{ InterruptedException -> 0x006c }
        r0 = new com.facebook.photos.imageprocessing.FiltersRepeatedPostprocessor$1;	 Catch:{ InterruptedException -> 0x006c }
        r1 = r9;
        r3 = r10;
        r0.<init>(r1, r2, r3, r4, r5);	 Catch:{ InterruptedException -> 0x006c }
        r1 = 1969379794; // 0x756259d2 float:2.869338E32 double:9.730029E-315;
        com.facebook.tools.dextr.runtime.detour.ExecutorDetour.a(r8, r0, r1);	 Catch:{ InterruptedException -> 0x006c }
        r0 = 15000; // 0x3a98 float:2.102E-41 double:7.411E-320;
        r3 = java.util.concurrent.TimeUnit.MILLISECONDS;	 Catch:{ InterruptedException -> 0x006c }
        r2.await(r0, r3);	 Catch:{ InterruptedException -> 0x006c }
    L_0x0065:
        com.facebook.common.references.CloseableReference.c(r6);
        goto L_0x0011;
    L_0x0069:
        r0 = move-exception;
        monitor-exit(r9);	 Catch:{  }
        throw r0;
    L_0x006c:
        r0 = move-exception;
        r1 = f13053a;
        r2 = "sessionLatch has been interrupted.";
        com.facebook.debug.log.BLog.b(r1, r2, r0);
        r0 = r9.getClass();
        r0 = r0.getSimpleName();
        r1 = new java.lang.StringBuilder;
        r2 = "Unexpected failure: Autoenhance repeatedpostprocessor latch interrupted. \nCurrent state: ";
        r1.<init>(r2);
        r2 = r7.name();
        r1 = r1.append(r2);
        r2 = "\nExecutor queue size: ";
        r1 = r1.append(r2);
        r2 = f13054c;
        r2 = r2.a();
        r1 = r1.append(r2);
        r2 = "\nFiltered applied: ";
        r1 = r1.append(r2);
        r2 = r9.m20396d();
        r1 = r1.append(r2);
        r2 = "\nFilter name: ";
        r1 = r1.append(r2);
        r1 = r1.append(r5);
        r1 = r1.toString();
        r0 = com.facebook.common.errorreporting.SoftError.a(r0, r1);
        r0 = r0.g();
        r1 = r9.f13056d;
        r1.a(r0);
        goto L_0x0065;
    L_0x00c5:
        if (r6 == 0) goto L_0x0065;
    L_0x00c7:
        r0 = com.facebook.photos.imageprocessing.FiltersRepeatedPostprocessor.State.CLOSING;
        if (r7 == r0) goto L_0x0065;
    L_0x00cb:
        r0 = r6.a();
        r0 = (com.facebook.photos.imageprocessing.FiltersEngine.Session) r0;
        r0.m20373a(r10, r5);
        monitor-enter(r9);
        r0 = 1;
        r9.f13059g = r0;	 Catch:{ all -> 0x00e1 }
        r0 = r9.f13060h;	 Catch:{ all -> 0x00e1 }
        if (r0 != 0) goto L_0x00df;
    L_0x00dc:
        r9.m20397e();	 Catch:{ all -> 0x00e1 }
    L_0x00df:
        monitor-exit(r9);	 Catch:{ all -> 0x00e1 }
        goto L_0x0065;
    L_0x00e1:
        r0 = move-exception;
        monitor-exit(r9);	 Catch:{ all -> 0x00e1 }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.photos.imageprocessing.FiltersRepeatedPostprocessor.a(android.graphics.Bitmap):void");
    }

    public final String m20392a() {
        return "EDITABLE_PHOTO_POSTPROCESSOR";
    }

    public final void m20395a(RectF[] rectFArr) {
        synchronized (this) {
            this.f13058f = rectFArr;
        }
        c();
    }

    public final void m20394a(String str) {
        synchronized (this) {
            this.f13061i = str;
            if (this.f13057e == null) {
                this.f13063k = State.PREPROCESSING;
            } else {
                this.f13063k = State.APPLYING;
            }
        }
        c();
    }

    public final synchronized boolean m20396d() {
        return this.f13059g;
    }

    public final void m20397e() {
        CloseableReference closeableReference;
        synchronized (this) {
            closeableReference = this.f13057e;
            this.f13057e = null;
            this.f13060h = false;
            this.f13063k = State.NONE;
        }
        CloseableReference.c(closeableReference);
    }
}
