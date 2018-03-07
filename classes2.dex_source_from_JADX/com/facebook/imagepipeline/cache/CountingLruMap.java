package com.facebook.imagepipeline.cache;

import com.android.internal.util.Predicate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
/* compiled from: orca_edit_photo_android */
public class CountingLruMap<K, V> {
    private final ValueDescriptor<V> f10897a;
    @GuardedBy("this")
    private final LinkedHashMap<K, V> f10898b = new LinkedHashMap();
    @GuardedBy("this")
    private int f10899c = 0;

    public CountingLruMap(ValueDescriptor<V> valueDescriptor) {
        this.f10897a = valueDescriptor;
    }

    public final synchronized int m16153a() {
        return this.f10898b.size();
    }

    public final synchronized int m16157b() {
        return this.f10899c;
    }

    @Nullable
    public final synchronized K m16160c() {
        return this.f10898b.isEmpty() ? null : this.f10898b.keySet().iterator().next();
    }

    public final synchronized ArrayList<Entry<K, V>> m16156a(@Nullable Predicate<K> predicate) {
        ArrayList<Entry<K, V>> arrayList;
        arrayList = new ArrayList();
        for (Entry entry : this.f10898b.entrySet()) {
            if (predicate == null || predicate.apply(entry.getKey())) {
                arrayList.add(entry);
            }
        }
        return arrayList;
    }

    @Nullable
    public final synchronized V m16154a(K k) {
        return this.f10898b.get(k);
    }

    @Nullable
    public final synchronized V m16155a(K k, V v) {
        V remove;
        remove = this.f10898b.remove(k);
        this.f10899c -= m16152c(remove);
        this.f10898b.put(k, v);
        this.f10899c += m16152c(v);
        return remove;
    }

    @Nullable
    public final synchronized V m16158b(K k) {
        V remove;
        remove = this.f10898b.remove(k);
        this.f10899c -= m16152c(remove);
        return remove;
    }

    public final synchronized ArrayList<V> m16159b(@Nullable Predicate<K> predicate) {
        ArrayList<V> arrayList;
        arrayList = new ArrayList();
        Iterator it = this.f10898b.entrySet().iterator();
        while (it.hasNext()) {
            Entry entry = (Entry) it.next();
            if (predicate == null || predicate.apply(entry.getKey())) {
                arrayList.add(entry.getValue());
                this.f10899c -= m16152c(entry.getValue());
                it.remove();
            }
        }
        return arrayList;
    }

    public final synchronized ArrayList<V> m16161d() {
        ArrayList<V> arrayList;
        arrayList = new ArrayList(this.f10898b.values());
        this.f10898b.clear();
        this.f10899c = 0;
        return arrayList;
    }

    private int m16152c(V v) {
        return v == null ? 0 : this.f10897a.mo2068a(v);
    }
}
