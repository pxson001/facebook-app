package com.google.common.collect;

import com.google.common.base.Objects;
import com.google.common.collect.MapDifference.ValueDifference;
import java.util.Map;

/* compiled from: camera */
public class Maps$MapDifferenceImpl<K, V> implements MapDifference<K, V> {
    public final Map<K, V> f7484a;
    public final Map<K, V> f7485b;
    final Map<K, V> f7486c;
    public final Map<K, ValueDifference<V>> f7487d;

    Maps$MapDifferenceImpl(Map<K, V> map, Map<K, V> map2, Map<K, V> map3, Map<K, ValueDifference<V>> map4) {
        this.f7484a = Maps.e(map);
        this.f7485b = Maps.e(map2);
        this.f7486c = Maps.e(map3);
        this.f7487d = Maps.e(map4);
    }

    public String toString() {
        Object obj;
        if (this.f7484a.isEmpty() && this.f7485b.isEmpty() && this.f7487d.isEmpty()) {
            obj = 1;
        } else {
            obj = null;
        }
        if (obj != null) {
            return "equal";
        }
        StringBuilder stringBuilder = new StringBuilder("not equal");
        if (!this.f7484a.isEmpty()) {
            stringBuilder.append(": only on left=").append(this.f7484a);
        }
        if (!this.f7485b.isEmpty()) {
            stringBuilder.append(": only on right=").append(this.f7485b);
        }
        if (!this.f7487d.isEmpty()) {
            stringBuilder.append(": value differences=").append(this.f7487d);
        }
        return stringBuilder.toString();
    }

    public Map<K, V> mo973a() {
        return this.f7484a;
    }

    public Map<K, V> mo974b() {
        return this.f7485b;
    }

    public Map<K, V> mo975c() {
        return this.f7486c;
    }

    public Map<K, ValueDifference<V>> mo976d() {
        return this.f7487d;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof MapDifference)) {
            return false;
        }
        MapDifference mapDifference = (MapDifference) obj;
        if (mo973a().equals(mapDifference.mo973a()) && mo974b().equals(mapDifference.mo974b()) && mo975c().equals(mapDifference.mo975c()) && mo976d().equals(mapDifference.mo976d())) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return Objects.hashCode(new Object[]{mo973a(), mo974b(), mo975c(), mo976d()});
    }
}
