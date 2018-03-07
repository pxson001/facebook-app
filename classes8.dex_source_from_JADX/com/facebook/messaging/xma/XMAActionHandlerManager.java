package com.facebook.messaging.xma;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* compiled from: timeline/profilevideo/store */
public class XMAActionHandlerManager<T> {
    public final Map<String, Set<XMAActionHandler<T>>> f1573a = new HashMap();

    public final void m1745a(XMAActionHandler<T> xMAActionHandler, String str) {
        Set set = (Set) this.f1573a.get(str);
        if (set == null) {
            set = new HashSet();
            this.f1573a.put(str, set);
        }
        set.add(xMAActionHandler);
    }

    public final void m1744a(XMAActionHandler<T> xMAActionHandler) {
        for (Set set : this.f1573a.values()) {
            if (set.contains(xMAActionHandler)) {
                set.remove(xMAActionHandler);
            }
        }
    }
}
