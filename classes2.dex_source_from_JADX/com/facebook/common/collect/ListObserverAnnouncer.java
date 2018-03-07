package com.facebook.common.collect;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: send_chat_event */
public final class ListObserverAnnouncer<T> implements ListObserver<T> {
    private final List<ListObserver<T>> f5657a = new CopyOnWriteArrayList();

    public final void m9754a(ListObserver<T> listObserver) {
        if (listObserver == null) {
            throw new NullPointerException();
        }
        this.f5657a.add(listObserver);
    }

    public final void m9756b(ListObserver<T> listObserver) {
        if (listObserver == null) {
            throw new NullPointerException();
        }
        this.f5657a.remove(listObserver);
    }

    public final void mo1387a(int i, T t, T t2, boolean z) {
        for (ListObserver a : this.f5657a) {
            a.mo1387a(i, (Object) t, (Object) t2, z);
        }
    }

    public final void mo1388a(int i, T t, boolean z) {
        for (ListObserver a : this.f5657a) {
            a.mo1388a(i, t, z);
        }
    }

    public final void mo1389b(int i, T t, boolean z) {
        for (ListObserver b : this.f5657a) {
            b.mo1389b(i, t, z);
        }
    }

    public final void mo1386a(int i, int i2, T t, boolean z) {
        for (ListObserver a : this.f5657a) {
            a.mo1386a(i, i2, (Object) t, z);
        }
    }
}
