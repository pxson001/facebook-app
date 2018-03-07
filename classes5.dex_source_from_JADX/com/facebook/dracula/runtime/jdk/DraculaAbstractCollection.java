package com.facebook.dracula.runtime.jdk;

import java.util.Iterator;

/* compiled from: ru_req_promo */
public abstract class DraculaAbstractCollection<E> implements DraculaCollection<E> {
    public abstract int m4096a();

    public abstract Iterator<E> iterator();

    protected DraculaAbstractCollection() {
    }

    public String toString() {
        Object obj;
        if (m4096a() == 0) {
            obj = 1;
        } else {
            obj = null;
        }
        if (obj != null) {
            return "[]";
        }
        StringBuilder stringBuilder = new StringBuilder(m4096a() * 16);
        stringBuilder.append('[');
        Iterator it = iterator();
        while (it.hasNext()) {
            stringBuilder.append(it.next().toString());
            if (it.hasNext()) {
                stringBuilder.append(", ");
            }
        }
        stringBuilder.append(']');
        return stringBuilder.toString();
    }
}
