package com.facebook.messaging.photos.editing;

import java.util.ArrayList;
import java.util.List;

/* compiled from: dismiss_participants_dialog */
public class Observable {
    private final List<Observer> f16069a = new ArrayList();

    public final void m16224a(Observer observer) {
        if (observer == null) {
            throw new IllegalArgumentException("The observer is null.");
        }
        synchronized (this.f16069a) {
            if (this.f16069a.contains(observer)) {
                throw new IllegalStateException("Observer " + observer + " is already registered.");
            }
            this.f16069a.add(observer);
        }
    }

    public final boolean m16226b(Observer observer) {
        if (observer == null) {
            throw new IllegalArgumentException("The observer is null.");
        }
        boolean remove;
        synchronized (this.f16069a) {
            if (this.f16069a.indexOf(observer) == -1) {
                throw new IllegalStateException("Observer " + observer + " was not registered.");
            }
            remove = this.f16069a.remove(observer);
        }
        return remove;
    }

    public final void m16225a(Object obj) {
        synchronized (this.f16069a) {
            for (int size = this.f16069a.size() - 1; size >= 0; size--) {
                ((Observer) this.f16069a.get(size)).mo663a(obj);
            }
        }
    }
}
