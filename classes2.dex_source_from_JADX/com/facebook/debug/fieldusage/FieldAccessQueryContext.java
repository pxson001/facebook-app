package com.facebook.debug.fieldusage;

import com.facebook.debug.fieldusage.FieldTrackable.QueryTracker;
import com.facebook.graphql.modelutil.BaseModel;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonStreamContext;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/* compiled from: send_skype */
public class FieldAccessQueryContext {
    public static FieldUsageReporterFactory f5597a;
    private static final Map<Object, QueryTracker> f5598b = new HashMap();

    public static synchronized boolean m9555a() {
        boolean z;
        synchronized (FieldAccessQueryContext.class) {
            z = f5597a != null && f5597a.m9548a();
        }
        return z;
    }

    private static Object m9552a(JsonParser jsonParser) {
        return jsonParser.mo1765b();
    }

    public static synchronized boolean m9556a(Object obj, FieldAccessQueryTracker fieldAccessQueryTracker) {
        boolean z = false;
        synchronized (FieldAccessQueryContext.class) {
            if (m9555a()) {
                m9558b();
                if (((long) f5598b.size()) < f5597a.m9550c()) {
                    if (obj instanceof JsonParser) {
                        obj = m9552a((JsonParser) obj);
                    }
                    int identityHashCode = System.identityHashCode(obj);
                    if (!f5598b.containsKey(Integer.valueOf(identityHashCode))) {
                        f5598b.put(Integer.valueOf(identityHashCode), fieldAccessQueryTracker);
                        z = true;
                    }
                }
            }
        }
        return z;
    }

    public static synchronized void m9554a(Object obj) {
        synchronized (FieldAccessQueryContext.class) {
            if (m9555a()) {
                if (obj instanceof JsonParser) {
                    obj = m9552a((JsonParser) obj);
                }
                int identityHashCode = System.identityHashCode(obj);
                if (f5598b.containsKey(Integer.valueOf(identityHashCode))) {
                    f5598b.remove(Integer.valueOf(identityHashCode));
                }
            }
        }
    }

    private static synchronized void m9558b() {
        synchronized (FieldAccessQueryContext.class) {
            if (f5597a != null) {
                List<Object> arrayList = new ArrayList();
                for (Entry entry : f5598b.entrySet()) {
                    if (((FieldAccessQueryTracker) entry.getValue()).c() > f5597a.m9549b() * 1000) {
                        arrayList.add(entry.getKey());
                    }
                }
                for (Object remove : arrayList) {
                    f5598b.remove(remove);
                }
            }
        }
    }

    public static synchronized FieldAccessQueryTracker m9557b(Object obj) {
        FieldAccessQueryTracker fieldAccessQueryTracker = null;
        synchronized (FieldAccessQueryContext.class) {
            if (m9555a()) {
                if (obj instanceof JsonParser) {
                    obj = m9552a((JsonParser) obj);
                }
                int identityHashCode = System.identityHashCode(obj);
                if (f5598b.containsKey(Integer.valueOf(identityHashCode))) {
                    fieldAccessQueryTracker = (FieldAccessQueryTracker) f5598b.get(Integer.valueOf(identityHashCode));
                }
            }
        }
        return fieldAccessQueryTracker;
    }

    static FieldAccessTracker m9551a(Object obj, FieldAccessTracker fieldAccessTracker, FieldAccessQueryTracker fieldAccessQueryTracker) {
        if (fieldAccessQueryTracker != null && fieldAccessTracker == null && (obj instanceof BaseModel)) {
            return ((BaseModel) obj).m9942a(fieldAccessQueryTracker);
        }
        return fieldAccessTracker;
    }

    public static String m9553a(JsonStreamContext jsonStreamContext) {
        if (jsonStreamContext == null || "viewer".equals(jsonStreamContext.mo1660h()) || "response".equals(jsonStreamContext.mo1660h()) || (jsonStreamContext.mo1660h() != null && jsonStreamContext.mo1660h().matches("^[0-9]*$"))) {
            return null;
        }
        String a = m9553a(jsonStreamContext.mo1659a());
        if (a == null) {
            return jsonStreamContext.mo1660h();
        }
        if (jsonStreamContext.mo1660h() == null) {
            return a;
        }
        StringBuilder stringBuilder = new StringBuilder((a.length() + 1) + jsonStreamContext.mo1660h().length());
        stringBuilder.append(a).append(".").append(jsonStreamContext.mo1660h());
        return stringBuilder.toString();
    }
}
