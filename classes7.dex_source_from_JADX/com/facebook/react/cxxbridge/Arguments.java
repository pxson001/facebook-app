package com.facebook.react.cxxbridge;

import android.os.Bundle;
import com.facebook.react.bridge.WritableNativeArray;
import com.facebook.react.bridge.WritableNativeMap;
import java.lang.reflect.Array;
import java.util.AbstractList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/* compiled from: growth_add_contactpoint_success */
public class Arguments {

    /* compiled from: growth_add_contactpoint_success */
    final class C10231 extends AbstractList {
        final /* synthetic */ Object f11586a;

        C10231(Object obj) {
            this.f11586a = obj;
        }

        public final int size() {
            return Array.getLength(this.f11586a);
        }

        public final Object get(int i) {
            return Array.get(this.f11586a, i);
        }
    }

    private static Object m13621a(Object obj) {
        if (obj == null) {
            return null;
        }
        if ((obj instanceof Float) || (obj instanceof Long) || (obj instanceof Byte) || (obj instanceof Short)) {
            return new Double(((Number) obj).doubleValue());
        }
        if (obj.getClass().isArray()) {
            return m13623b(obj);
        }
        if (obj instanceof List) {
            return m13618a((List) obj);
        }
        if (obj instanceof Map) {
            return m13620a((Map) obj);
        }
        if (obj instanceof Bundle) {
            return m13619a((Bundle) obj);
        }
        return obj;
    }

    private static WritableNativeArray m13618a(List list) {
        WritableNativeArray writableNativeArray = new WritableNativeArray();
        if (list == null) {
            return writableNativeArray;
        }
        for (Object a : list) {
            Object a2 = m13621a(a2);
            if (a2 == null) {
                writableNativeArray.pushNull();
            } else if (a2 instanceof Boolean) {
                writableNativeArray.pushBoolean(((Boolean) a2).booleanValue());
            } else if (a2 instanceof Integer) {
                writableNativeArray.pushInt(((Integer) a2).intValue());
            } else if (a2 instanceof Double) {
                writableNativeArray.pushDouble(((Double) a2).doubleValue());
            } else if (a2 instanceof String) {
                writableNativeArray.pushString((String) a2);
            } else if (a2 instanceof WritableNativeArray) {
                writableNativeArray.mo688a((WritableNativeArray) a2);
            } else if (a2 instanceof WritableNativeMap) {
                writableNativeArray.mo689a((WritableNativeMap) a2);
            } else {
                throw new IllegalArgumentException("Could not convert " + a2.getClass());
            }
        }
        return writableNativeArray;
    }

    private static <T> WritableNativeArray m13623b(Object obj) {
        if (obj == null) {
            return new WritableNativeArray();
        }
        return m13618a(new C10231(obj));
    }

    private static void m13622a(WritableNativeMap writableNativeMap, String str, Object obj) {
        Object a = m13621a(obj);
        if (a == null) {
            writableNativeMap.putNull(str);
        } else if (a instanceof Boolean) {
            writableNativeMap.putBoolean(str, ((Boolean) a).booleanValue());
        } else if (a instanceof Integer) {
            writableNativeMap.putInt(str, ((Integer) a).intValue());
        } else if (a instanceof Number) {
            writableNativeMap.putDouble(str, ((Number) a).doubleValue());
        } else if (a instanceof String) {
            writableNativeMap.putString(str, (String) a);
        } else if (a instanceof WritableNativeArray) {
            writableNativeMap.mo695a(str, (WritableNativeArray) a);
        } else if (a instanceof WritableNativeMap) {
            writableNativeMap.mo696a(str, (WritableNativeMap) a);
        } else {
            throw new IllegalArgumentException("Could not convert " + a.getClass());
        }
    }

    public static WritableNativeMap m13620a(Map<String, Object> map) {
        WritableNativeMap writableNativeMap = new WritableNativeMap();
        if (map == null) {
            return writableNativeMap;
        }
        for (Entry entry : map.entrySet()) {
            m13622a(writableNativeMap, (String) entry.getKey(), entry.getValue());
        }
        return writableNativeMap;
    }

    public static WritableNativeMap m13619a(Bundle bundle) {
        WritableNativeMap writableNativeMap = new WritableNativeMap();
        if (bundle == null) {
            return writableNativeMap;
        }
        for (String str : bundle.keySet()) {
            m13622a(writableNativeMap, str, bundle.get(str));
        }
        return writableNativeMap;
    }
}
