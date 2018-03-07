package com.facebook.common.json;

import android.net.Uri;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.JacksonDeserializers$TokenBufferDeserializer;
import com.fasterxml.jackson.databind.deser.std.JsonNodeDeserializer;
import com.fasterxml.jackson.databind.deser.std.NumberDeserializers;
import com.fasterxml.jackson.databind.deser.std.StringDeserializer;
import com.fasterxml.jackson.databind.deser.std.UntypedObjectDeserializer;
import com.fasterxml.jackson.databind.util.TokenBuffer;
import com.google.common.collect.Maps;
import java.util.concurrent.ConcurrentMap;

/* compiled from: requests_total */
public final class GlobalAutoGenDeserializerCache {
    public static final ConcurrentMap<Class<?>, JsonDeserializer> f7236a = Maps.m843e();
    public static final ConcurrentMap<Class<?>, Boolean> f7237b = Maps.m843e();
    private static boolean f7238c = false;
    public static boolean f7239d = false;

    private GlobalAutoGenDeserializerCache() {
    }

    public static <T> void m11718a(Class<? extends T> cls, JsonDeserializer<T> jsonDeserializer) {
        f7236a.putIfAbsent(cls, jsonDeserializer);
    }

    public static <T> JsonDeserializer<T> m11717a(Class<T> cls) {
        if (!f7238c) {
            f7236a.put(JsonNode.class, JsonNodeDeserializer.m13332a(JsonNode.class));
            f7236a.put(String.class, StringDeserializer.f8636a);
            f7236a.put(Integer.class, NumberDeserializers.m13400a(Integer.class, Integer.class.getName()));
            f7236a.put(Long.class, NumberDeserializers.m13400a(Long.class, Long.class.getName()));
            f7236a.put(Boolean.class, NumberDeserializers.m13400a(Boolean.class, Boolean.class.getName()));
            f7236a.put(Float.class, NumberDeserializers.m13400a(Float.class, Float.class.getName()));
            f7236a.put(Double.class, NumberDeserializers.m13400a(Double.class, Double.class.getName()));
            f7236a.put(Uri.class, new UriDeserializer());
            f7236a.put(TokenBuffer.class, JacksonDeserializers$TokenBufferDeserializer.f8648a);
            f7236a.put(Object.class, UntypedObjectDeserializer.f8649a);
            f7238c = true;
        }
        JsonDeserializer<T> jsonDeserializer = (JsonDeserializer) f7236a.get(cls);
        if (jsonDeserializer != null) {
            return jsonDeserializer;
        }
        boolean z = false;
        if (!f7237b.containsKey(cls)) {
            String concat = cls.getName().replace('$', '_').concat("Deserializer");
            String concat2 = cls.getName().concat("$Deserializer");
            if (f7239d) {
                z = m11719a(concat2);
            }
            if (!z) {
                z = m11719a(concat);
            }
            if (!(z || f7239d)) {
                z = m11719a(concat2);
            }
            f7237b.putIfAbsent(cls, Boolean.valueOf(z));
        }
        if (z) {
            return (JsonDeserializer) f7236a.get(cls);
        }
        return null;
    }

    public static boolean m11719a(String str) {
        try {
            Class.forName(str);
            return true;
        } catch (ClassNotFoundException e) {
            return false;
        } catch (NoClassDefFoundError e2) {
            return false;
        } catch (ExceptionInInitializerError e3) {
            return false;
        }
    }
}
