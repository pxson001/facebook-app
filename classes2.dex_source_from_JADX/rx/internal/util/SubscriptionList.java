package rx.internal.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import rx.Subscription;
import rx.exceptions.CompositeException;

/* compiled from: rtc_conferencing_roster_muting_android */
public final class SubscriptionList implements Subscription {
    private List<Subscription> f6468a;
    private boolean f6469b = false;

    public final synchronized boolean mo1601c() {
        return this.f6469b;
    }

    public final void m11211a(Subscription subscription) {
        synchronized (this) {
            if (!this.f6469b) {
                if (this.f6468a == null) {
                    this.f6468a = new LinkedList();
                }
                this.f6468a.add(subscription);
                subscription = null;
            }
        }
        if (subscription != null) {
            subscription.mo1600b();
        }
    }

    public final void mo1600b() {
        synchronized (this) {
            if (this.f6469b) {
                return;
            }
            this.f6469b = true;
            m11210a(this.f6468a);
            this.f6468a = null;
        }
    }

    private static void m11210a(Collection<Subscription> collection) {
        if (collection != null) {
            Collection collection2 = null;
            for (Subscription b : collection) {
                try {
                    b.mo1600b();
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
