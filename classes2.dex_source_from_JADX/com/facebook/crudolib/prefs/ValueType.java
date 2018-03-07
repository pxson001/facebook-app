package com.facebook.crudolib.prefs;

import java.util.Set;

/* compiled from: getStatsService */
class ValueType {
    ValueType() {
    }

    public static int m30386a(Object obj) {
        if (obj instanceof Boolean) {
            return 0;
        }
        if (obj instanceof Integer) {
            return 1;
        }
        if (obj instanceof Long) {
            return 2;
        }
        if (obj instanceof Float) {
            return 3;
        }
        if (obj instanceof Double) {
            return 4;
        }
        if (obj instanceof String) {
            return 5;
        }
        if (obj instanceof Set) {
            return 6;
        }
        throw new IllegalArgumentException("Unsupported type: " + obj.getClass());
    }
}
