package com.google.common.collect;

import java.util.Collection;
import java.util.Comparator;
import java.util.Map.Entry;

/* compiled from: log_event_name */
public class ImmutableMultimap$Builder<K, V> {
    Multimap<K, V> f9008a;
    Comparator<? super K> f9009b;
    Comparator<? super V> f9010c;

    public ImmutableMultimap$Builder() {
        this(MultimapBuilder.m9358a().m9361b().mo142b());
    }

    ImmutableMultimap$Builder(Multimap<K, V> multimap) {
        this.f9008a = multimap;
    }

    public ImmutableMultimap$Builder<K, V> mo697b(K k, V v) {
        CollectPreconditions.a(k, v);
        this.f9008a.a(k, v);
        return this;
    }

    public ImmutableMultimap$Builder<K, V> mo696b(K k, Iterable<? extends V> iterable) {
        if (k == null) {
            throw new NullPointerException("null key in entry: null=" + Iterables.c(iterable));
        }
        Collection c = this.f9008a.c(k);
        for (Object next : iterable) {
            CollectPreconditions.a(k, next);
            c.add(next);
        }
        return this;
    }

    public ImmutableMultimap$Builder<K, V> mo695b(Multimap<? extends K, ? extends V> multimap) {
        for (Entry entry : multimap.b().entrySet()) {
            mo696b(entry.getKey(), (Iterable) entry.getValue());
        }
        return this;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.google.common.collect.ImmutableMultimap<K, V> mo698b() {
        /*
        r6 = this;
        r0 = r6.f9010c;
        if (r0 == 0) goto L_0x0026;
    L_0x0004:
        r0 = r6.f9008a;
        r0 = r0.b();
        r0 = r0.values();
        r1 = r0.iterator();
    L_0x0012:
        r0 = r1.hasNext();
        if (r0 == 0) goto L_0x0026;
    L_0x0018:
        r0 = r1.next();
        r0 = (java.util.Collection) r0;
        r0 = (java.util.List) r0;
        r2 = r6.f9010c;
        java.util.Collections.sort(r0, r2);
        goto L_0x0012;
    L_0x0026:
        r0 = r6.f9009b;
        if (r0 == 0) goto L_0x006e;
    L_0x002a:
        r0 = com.google.common.collect.MultimapBuilder.m9358a();
        r0 = r0.m9361b();
        r1 = r0.mo142b();
        r0 = r6.f9009b;
        r0 = com.google.common.collect.Ordering.a(r0);
        r0 = r0.e();
        r2 = r6.f9008a;
        r2 = r2.b();
        r2 = r2.entrySet();
        r0 = r0.d(r2);
        r2 = r0.iterator();
    L_0x0052:
        r0 = r2.hasNext();
        if (r0 == 0) goto L_0x006c;
    L_0x0058:
        r0 = r2.next();
        r0 = (java.util.Map.Entry) r0;
        r3 = r0.getKey();
        r0 = r0.getValue();
        r0 = (java.lang.Iterable) r0;
        r1.a(r3, r0);
        goto L_0x0052;
    L_0x006c:
        r6.f9008a = r1;
    L_0x006e:
        r0 = r6.f9008a;
        r4 = r0 instanceof com.google.common.collect.ImmutableMultimap;
        if (r4 == 0) goto L_0x007f;
    L_0x0074:
        r4 = r0;
        r4 = (com.google.common.collect.ImmutableMultimap) r4;
        r5 = r4.d();
        if (r5 != 0) goto L_0x007f;
    L_0x007d:
        r0 = r4;
        return r0;
    L_0x007f:
        r4 = com.google.common.collect.ImmutableListMultimap.m2105b(r0);
        goto L_0x007d;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.collect.ImmutableMultimap$Builder.b():com.google.common.collect.ImmutableMultimap<K, V>");
    }
}
