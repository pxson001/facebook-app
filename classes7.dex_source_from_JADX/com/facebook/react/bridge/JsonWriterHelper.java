package com.facebook.react.bridge;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/* compiled from: group_info */
class JsonWriterHelper {
    JsonWriterHelper() {
    }

    public static void m13486a(JsonWriter jsonWriter, Object obj) {
        if (obj instanceof Map) {
            m13488a(jsonWriter, (Map) obj);
        } else if (obj instanceof List) {
            m13487a(jsonWriter, (List) obj);
        } else {
            m13489b(jsonWriter, obj);
        }
    }

    private static void m13488a(JsonWriter jsonWriter, Map<?, ?> map) {
        jsonWriter.m13482c();
        for (Entry entry : map.entrySet()) {
            jsonWriter.m13478a(entry.getKey().toString());
            m13486a(jsonWriter, entry.getValue());
        }
        jsonWriter.m13484d();
    }

    private static void m13487a(JsonWriter jsonWriter, List<?> list) {
        jsonWriter.m13475a();
        for (Object b : list) {
            m13489b(jsonWriter, b);
        }
        jsonWriter.m13480b();
    }

    private static void m13489b(JsonWriter jsonWriter, Object obj) {
        if (obj == null) {
            jsonWriter.m13485e();
        } else if (obj instanceof String) {
            jsonWriter.m13481b((String) obj);
        } else if (obj instanceof Number) {
            jsonWriter.m13477a((Number) obj);
        } else if (obj instanceof Boolean) {
            jsonWriter.m13479a(((Boolean) obj).booleanValue());
        } else {
            throw new IllegalArgumentException("Unknown value: " + obj);
        }
    }
}
