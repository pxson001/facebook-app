package com.google.common.util.concurrent;

import com.google.common.util.concurrent.AbstractFuture.AtomicHelper;
import com.google.common.util.concurrent.AbstractFuture.Listener;
import com.google.common.util.concurrent.AbstractFuture.Waiter;

/* compiled from: bug_network_subtype */
final class AbstractFuture$SynchronizedHelper extends AtomicHelper {
    final void m13823a(Waiter waiter, Thread thread) {
        waiter.b = thread;
    }

    final void m13822a(Waiter waiter, Waiter waiter2) {
        waiter.c = waiter2;
    }

    final boolean m13825a(AbstractFuture<?> abstractFuture, Waiter waiter, Waiter waiter2) {
        boolean z;
        synchronized (abstractFuture) {
            if (abstractFuture.g == waiter) {
                AbstractFuture.a(abstractFuture, waiter2);
                z = true;
            } else {
                z = false;
            }
        }
        return z;
    }

    final boolean m13824a(AbstractFuture<?> abstractFuture, Listener listener, Listener listener2) {
        boolean z;
        synchronized (abstractFuture) {
            if (abstractFuture.f == listener) {
                AbstractFuture.a(abstractFuture, listener2);
                z = true;
            } else {
                z = false;
            }
        }
        return z;
    }

    final boolean m13826a(AbstractFuture<?> abstractFuture, Object obj, Object obj2) {
        boolean z;
        synchronized (abstractFuture) {
            if (abstractFuture.e == obj) {
                AbstractFuture.a(abstractFuture, obj2);
                z = true;
            } else {
                z = false;
            }
        }
        return z;
    }
}
