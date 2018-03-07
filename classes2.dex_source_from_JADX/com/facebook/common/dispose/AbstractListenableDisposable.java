package com.facebook.common.dispose;

import com.facebook.common.dispose.DisposableContextHelper.2;
import com.google.common.collect.Sets;
import java.util.Set;
import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
/* compiled from: survey_hide_feed_unit */
public abstract class AbstractListenableDisposable implements Disposable {
    private boolean f3754a = false;
    private Set<DisposeListener> f3755b = null;

    protected abstract void mo3461b();

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void jc_() {
        /*
        r2 = this;
        monitor-enter(r2);
        r0 = r2.ba_();	 Catch:{ all -> 0x002a }
        if (r0 == 0) goto L_0x0009;
    L_0x0007:
        monitor-exit(r2);	 Catch:{ all -> 0x002a }
    L_0x0008:
        return;
    L_0x0009:
        r2.mo3461b();	 Catch:{ all -> 0x002a }
        r0 = 1;
        r2.f3754a = r0;	 Catch:{ all -> 0x002a }
        monitor-exit(r2);	 Catch:{ all -> 0x002a }
        r0 = r2.f3755b;
        if (r0 == 0) goto L_0x0008;
    L_0x0014:
        r0 = r2.f3755b;
        r1 = r0.iterator();
    L_0x001a:
        r0 = r1.hasNext();
        if (r0 == 0) goto L_0x002d;
    L_0x0020:
        r0 = r1.next();
        r0 = (com.facebook.common.dispose.DisposableContextHelper.2) r0;
        r0.a(r2);
        goto L_0x001a;
    L_0x002a:
        r0 = move-exception;
        monitor-exit(r2);	 Catch:{  }
        throw r0;
    L_0x002d:
        r0 = 0;
        r2.f3755b = r0;
        goto L_0x0008;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.common.dispose.AbstractListenableDisposable.jc_():void");
    }

    public final synchronized boolean ba_() {
        return this.f3754a;
    }

    public final void m6203a(2 2) {
        Object obj = null;
        synchronized (this) {
            if (ba_()) {
                obj = 1;
            } else {
                if (this.f3755b == null) {
                    this.f3755b = Sets.m1313a();
                }
                this.f3755b.add(2);
            }
        }
        if (obj != null) {
            2.a(this);
        }
    }
}
