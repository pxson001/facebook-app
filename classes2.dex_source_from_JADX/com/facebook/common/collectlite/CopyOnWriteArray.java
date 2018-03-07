package com.facebook.common.collectlite;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
/* compiled from: target_fragment */
public final class CopyOnWriteArray<T> {
    private final int f3162a = -1;
    private ArrayList<T> f3163b = new ArrayList();
    private List<T> f3164c = Collections.unmodifiableList(this.f3163b);
    private int f3165d;

    public final synchronized List<T> m5330a() {
        List<T> list;
        list = this.f3164c;
        this.f3165d++;
        return list;
    }

    public final synchronized void m5332b() {
        this.f3165d--;
    }

    public final synchronized void m5331a(T t) {
        if (this.f3165d > 0) {
            ArrayList arrayList = this.f3163b;
            int size = arrayList.size();
            this.f3163b = new ArrayList(size + 1);
            this.f3164c = Collections.unmodifiableList(this.f3163b);
            for (int i = 0; i < size; i++) {
                this.f3163b.add(arrayList.get(i));
            }
        }
        this.f3163b.add(t);
    }
}
