package com.fasterxml.jackson.databind.util;

import java.lang.reflect.Array;

/* compiled from: can_viewer_like */
final class ArrayBuilders$1 {
    final /* synthetic */ Class f6226a;
    final /* synthetic */ int f6227b;
    final /* synthetic */ Object f6228c;

    ArrayBuilders$1(Class cls, int i, Object obj) {
        this.f6226a = cls;
        this.f6227b = i;
        this.f6228c = obj;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != this.f6226a || Array.getLength(obj) != this.f6227b) {
            return false;
        }
        for (int i = 0; i < this.f6227b; i++) {
            Object obj2 = Array.get(this.f6228c, i);
            Object obj3 = Array.get(obj, i);
            if (obj2 != obj3 && obj2 != null && !obj2.equals(obj3)) {
                return false;
            }
        }
        return true;
    }
}
