package com.facebook.widget;

import com.google.common.collect.Sets;
import java.util.Set;
import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
/* compiled from: priority_dir */
public class OnDrawListenerSet {
    @GuardedBy("mOnDrawListeners")
    private Set<OnDrawListener> f11851a = Sets.m1313a();

    /* compiled from: priority_dir */
    public interface OnDrawListener {
        boolean gD_();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void m17178a() {
        /*
        r5 = this;
        r2 = r5.f11851a;
        monitor-enter(r2);
        r0 = r5.f11851a;	 Catch:{ all -> 0x0031 }
        r0 = r0.isEmpty();	 Catch:{ all -> 0x0031 }
        if (r0 == 0) goto L_0x000d;
    L_0x000b:
        monitor-exit(r2);	 Catch:{ all -> 0x0031 }
    L_0x000c:
        return;
    L_0x000d:
        r0 = 0;
        r1 = r5.f11851a;	 Catch:{ all -> 0x0031 }
        r3 = r1.iterator();	 Catch:{ all -> 0x0031 }
        r1 = r0;
    L_0x0015:
        r0 = r3.hasNext();	 Catch:{ all -> 0x0031 }
        if (r0 == 0) goto L_0x0034;
    L_0x001b:
        r0 = r3.next();	 Catch:{ all -> 0x0031 }
        r0 = (com.facebook.widget.OnDrawListenerSet.OnDrawListener) r0;	 Catch:{ all -> 0x0031 }
        r4 = r0.gD_();	 Catch:{ all -> 0x0031 }
        if (r4 == 0) goto L_0x0015;
    L_0x0027:
        if (r1 != 0) goto L_0x002d;
    L_0x0029:
        r1 = com.google.common.collect.Lists.m1306b();	 Catch:{ all -> 0x0031 }
    L_0x002d:
        r1.add(r0);	 Catch:{ all -> 0x0031 }
        goto L_0x0015;
    L_0x0031:
        r0 = move-exception;
        monitor-exit(r2);	 Catch:{ all -> 0x0031 }
        throw r0;
    L_0x0034:
        if (r1 == 0) goto L_0x004c;
    L_0x0036:
        r1 = r1.iterator();	 Catch:{  }
    L_0x003a:
        r0 = r1.hasNext();	 Catch:{  }
        if (r0 == 0) goto L_0x004c;
    L_0x0040:
        r0 = r1.next();	 Catch:{  }
        r0 = (com.facebook.widget.OnDrawListenerSet.OnDrawListener) r0;	 Catch:{  }
        r3 = r5.f11851a;	 Catch:{  }
        r3.remove(r0);	 Catch:{  }
        goto L_0x003a;
    L_0x004c:
        monitor-exit(r2);	 Catch:{  }
        goto L_0x000c;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.widget.OnDrawListenerSet.a():void");
    }

    public final void m17179a(OnDrawListener onDrawListener) {
        synchronized (this.f11851a) {
            this.f11851a.add(onDrawListener);
        }
    }

    public final void m17180b() {
        synchronized (this.f11851a) {
            this.f11851a.clear();
        }
    }

    public final void m17181b(OnDrawListener onDrawListener) {
        synchronized (this.f11851a) {
            this.f11851a.clear();
            this.f11851a.add(onDrawListener);
        }
    }
}
