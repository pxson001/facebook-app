package com.google.common.collect;

import com.google.common.collect.Multiset.Entry;
import com.google.common.collect.Multisets.AbstractEntry;
import javax.annotation.Nullable;

/* compiled from: offersite/detail/view/?offer_view_id=%s&share_id=%s&site_uri=%s&title=%s */
abstract class Multisets$EntrySet<E> extends ImprovedAbstractSet<Entry<E>> {
    abstract Multiset<E> mo2173a();

    Multisets$EntrySet() {
    }

    public boolean contains(@Nullable Object obj) {
        if (!(obj instanceof AbstractEntry)) {
            return false;
        }
        AbstractEntry abstractEntry = (AbstractEntry) obj;
        if (abstractEntry.b() > 0 && mo2173a().mo2163a(abstractEntry.a()) == abstractEntry.b()) {
            return true;
        }
        return false;
    }

    public boolean remove(Object obj) {
        if (!(obj instanceof AbstractEntry)) {
            return false;
        }
        AbstractEntry abstractEntry = (AbstractEntry) obj;
        Object a = abstractEntry.a();
        int b = abstractEntry.b();
        if (b != 0) {
            return mo2173a().mo2151a(a, b, 0);
        }
        return false;
    }

    public void clear() {
        mo2173a().clear();
    }
}
