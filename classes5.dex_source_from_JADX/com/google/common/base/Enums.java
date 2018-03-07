package com.google.common.base;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import java.lang.ref.WeakReference;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;
import javax.annotation.CheckReturnValue;

@GwtCompatible
@CheckReturnValue
@Beta
/* compiled from: can_guests_invite_friends */
public final class Enums {
    @GwtIncompatible("java.lang.ref.WeakReference")
    private static final Map<Class<? extends Enum<?>>, Map<String, WeakReference<? extends Enum<?>>>> enumConstantCache = new WeakHashMap();

    private Enums() {
    }

    public static <T extends Enum<T>> Optional<T> getIfPresent(Class<T> cls, String str) {
        Optional<T> optional;
        Preconditions.checkNotNull(cls);
        Preconditions.checkNotNull(str);
        WeakReference weakReference = (WeakReference) getEnumConstants(cls).get(str);
        if (weakReference == null) {
            optional = Absent.INSTANCE;
        } else {
            optional = Optional.of(cls.cast(weakReference.get()));
        }
        return optional;
    }

    @GwtIncompatible("java.lang.ref.WeakReference")
    private static <T extends Enum<T>> Map<String, WeakReference<? extends Enum<?>>> populateCache(Class<T> cls) {
        Map<String, WeakReference<? extends Enum<?>>> hashMap = new HashMap();
        Iterator it = EnumSet.allOf(cls).iterator();
        while (it.hasNext()) {
            Enum enumR = (Enum) it.next();
            hashMap.put(enumR.name(), new WeakReference(enumR));
        }
        enumConstantCache.put(cls, hashMap);
        return hashMap;
    }

    @GwtIncompatible("java.lang.ref.WeakReference")
    public static <T extends Enum<T>> Map<String, WeakReference<? extends Enum<?>>> getEnumConstants(Class<T> cls) {
        Map<String, WeakReference<? extends Enum<?>>> map;
        synchronized (enumConstantCache) {
            map = (Map) enumConstantCache.get(cls);
            if (map == null) {
                map = populateCache(cls);
            }
        }
        return map;
    }
}
