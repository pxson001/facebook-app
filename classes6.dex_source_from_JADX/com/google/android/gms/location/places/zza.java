package com.google.android.gms.location.places;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public abstract class zza {
    static <E> Set<E> m8962a(List<E> list) {
        return (list == null || list.isEmpty()) ? Collections.emptySet() : Collections.unmodifiableSet(new HashSet(list));
    }

    static <E> List<E> m8963c(Collection<E> collection) {
        return (collection == null || collection.isEmpty()) ? Collections.emptyList() : new ArrayList(collection);
    }
}
