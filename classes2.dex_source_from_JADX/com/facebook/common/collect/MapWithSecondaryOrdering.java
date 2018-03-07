package com.facebook.common.collect;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import java.util.AbstractMap;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import javax.annotation.Nullable;
import javax.annotation.concurrent.NotThreadSafe;

@NotThreadSafe
/* compiled from: send_dialtone_header_when_no_token */
public class MapWithSecondaryOrdering<K, V> extends AbstractMap<K, V> {
    private final Comparator<V> f5650a;
    private final Map<K, V> f5651b = Maps.m838c();
    private final List<V> f5652c = Lists.m1296a();
    private final Map<K, V> f5653d = Collections.unmodifiableMap(this.f5651b);
    public final List<V> f5654e = Collections.unmodifiableList(this.f5652c);
    @Nullable
    public ListObserver<V> f5655f;

    public MapWithSecondaryOrdering(Comparator<V> comparator) {
        this.f5650a = comparator;
    }

    public Set<Entry<K, V>> entrySet() {
        return this.f5653d.entrySet();
    }

    public V put(K k, V v) {
        Object obj = get(k);
        int b;
        if (obj == null) {
            b = m9732b(v);
            this.f5651b.put(k, v);
            if (this.f5655f != null) {
                this.f5655f.mo1388a(b, v, true);
            }
        } else if (this.f5650a.compare(obj, v) == 0) {
            b = m9733a(obj);
            if (b < 0) {
                throw new RuntimeException("The collection is in an invalid state");
            }
            this.f5652c.set(b, v);
            this.f5651b.put(k, v);
            if (this.f5655f != null) {
                this.f5655f.mo1387a(b, obj, (Object) v, true);
            }
        } else {
            m9731a(k, v);
        }
        return obj;
    }

    private int m9732b(V v) {
        int binarySearch = Collections.binarySearch(this.f5652c, v, this.f5650a);
        if (binarySearch >= 0) {
            binarySearch++;
            while (binarySearch < this.f5652c.size() && this.f5650a.compare(this.f5652c.get(binarySearch - 1), this.f5652c.get(binarySearch)) == 0) {
                binarySearch++;
            }
        } else {
            binarySearch = -(binarySearch + 1);
        }
        this.f5652c.add(binarySearch, v);
        return binarySearch;
    }

    public final List<V> m9734a() {
        return this.f5654e;
    }

    public void clear() {
        Object[] toArray = this.f5651b.keySet().toArray();
        for (Object remove : toArray) {
            remove(remove);
        }
    }

    public V get(Object obj) {
        return this.f5651b.get(obj);
    }

    public boolean containsKey(Object obj) {
        return this.f5651b.containsKey(obj);
    }

    public V remove(Object obj) {
        V remove = this.f5651b.remove(obj);
        if (remove == null) {
            return null;
        }
        int a = m9733a(remove);
        if (a < 0) {
            throw new RuntimeException("The collection is in an invalid state");
        }
        this.f5652c.remove(a);
        if (this.f5655f == null) {
            return remove;
        }
        this.f5655f.mo1389b(a, remove, true);
        return remove;
    }

    public final int m9733a(V v) {
        int binarySearch = Collections.binarySearch(this.f5652c, v, this.f5650a);
        if (binarySearch < 0) {
            return binarySearch;
        }
        int i = binarySearch;
        while (i < this.f5652c.size()) {
            V v2 = this.f5652c.get(i);
            if (this.f5650a.compare(v, v2) != 0) {
                break;
            } else if (v == v2) {
                return i;
            } else {
                i++;
            }
        }
        binarySearch--;
        while (binarySearch >= 0) {
            V v3 = this.f5652c.get(binarySearch);
            if (this.f5650a.compare(v, v3) != 0) {
                break;
            } else if (v == v3) {
                return binarySearch;
            } else {
                binarySearch--;
            }
        }
        return -1;
    }

    public int size() {
        return this.f5651b.size();
    }

    private void m9731a(K k, V v) {
        int a = m9733a(this.f5651b.remove(k));
        if (a < 0) {
            throw new RuntimeException("The collection is in an invalid state");
        }
        this.f5652c.remove(a);
        int b = m9732b(v);
        this.f5651b.put(k, v);
        if (this.f5655f != null) {
            this.f5655f.mo1386a(a, b, (Object) v, true);
        }
    }
}
