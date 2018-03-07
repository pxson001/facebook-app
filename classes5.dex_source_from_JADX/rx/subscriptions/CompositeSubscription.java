package rx.subscriptions;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import rx.Subscription;
import rx.exceptions.CompositeException;

/* compiled from: bigPictureUrl */
public final class CompositeSubscription implements Subscription {
    private Set<Subscription> f7967a;
    private boolean f7968b = false;

    public final synchronized boolean m14089c() {
        return this.f7968b;
    }

    public final void m14086a(Subscription subscription) {
        synchronized (this) {
            if (!this.f7968b) {
                if (this.f7967a == null) {
                    this.f7967a = new HashSet(4);
                }
                this.f7967a.add(subscription);
                subscription = null;
            }
        }
        if (subscription != null) {
            subscription.b();
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void m14088b(rx.Subscription r2) {
        /*
        r1 = this;
        monitor-enter(r1);
        r0 = r1.f7968b;	 Catch:{ all -> 0x0018 }
        if (r0 != 0) goto L_0x0009;
    L_0x0005:
        r0 = r1.f7967a;	 Catch:{ all -> 0x0018 }
        if (r0 != 0) goto L_0x000b;
    L_0x0009:
        monitor-exit(r1);	 Catch:{ all -> 0x0018 }
    L_0x000a:
        return;
    L_0x000b:
        r0 = r1.f7967a;	 Catch:{ all -> 0x0018 }
        r0 = r0.remove(r2);	 Catch:{ all -> 0x0018 }
        monitor-exit(r1);	 Catch:{ all -> 0x0018 }
        if (r0 == 0) goto L_0x000a;
    L_0x0014:
        r2.b();
        goto L_0x000a;
    L_0x0018:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{  }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: rx.subscriptions.CompositeSubscription.b(rx.Subscription):void");
    }

    public final void m14087b() {
        synchronized (this) {
            if (this.f7968b) {
                return;
            }
            this.f7968b = true;
            m14085a(this.f7967a);
        }
    }

    private static void m14085a(Collection<Subscription> collection) {
        if (collection != null) {
            Collection collection2 = null;
            for (Subscription b : collection) {
                try {
                    b.b();
                } catch (Throwable th) {
                    List arrayList;
                    if (collection2 == null) {
                        arrayList = new ArrayList();
                    } else {
                        Collection collection3 = collection2;
                    }
                    arrayList.add(th);
                    collection2 = arrayList;
                }
            }
            if (collection2 == null) {
                return;
            }
            if (collection2.size() == 1) {
                Throwable th2 = (Throwable) collection2.get(0);
                if (th2 instanceof RuntimeException) {
                    throw ((RuntimeException) th2);
                }
                throw new CompositeException(collection2);
            }
            throw new CompositeException(collection2);
        }
    }
}
