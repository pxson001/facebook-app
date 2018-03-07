package com.facebook.facecastdisplay;

import com.facebook.common.util.CollectionUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import javax.annotation.Nullable;

/* compiled from: attribute */
public class RoundRobinBuffer<K, E> {
    private final HashMap<K, List<E>> f19004a = new HashMap();
    private final List<K> f19005b = new ArrayList();
    private int f19006c = -1;

    public final void m22582a(K k, E e) {
        if (!this.f19005b.contains(k)) {
            this.f19005b.add(k);
        }
        List list = (List) this.f19004a.get(k);
        if (list == null) {
            list = new LinkedList();
            this.f19004a.put(k, list);
        }
        list.add(e);
    }

    @Nullable
    public final E m22581a() {
        int i = this.f19006c + 1;
        int i2 = 0;
        while (i2 < this.f19005b.size()) {
            int size = i % this.f19005b.size();
            List list = (List) this.f19004a.get(this.f19005b.get(size));
            if (CollectionUtil.b(list)) {
                this.f19006c = size;
                E remove = list.remove(0);
                if (CollectionUtil.a(list)) {
                    this.f19005b.remove(this.f19006c);
                    this.f19006c--;
                }
                return remove;
            }
            i2++;
            i = size + 1;
        }
        return null;
    }

    public final int m22580a(K k) {
        List list = (List) this.f19004a.get(k);
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    @Nullable
    public final List<E> m22583b(K k) {
        return (List) this.f19004a.get(k);
    }

    public final void m22584b() {
        this.f19004a.clear();
        this.f19005b.clear();
        this.f19006c = -1;
    }
}
