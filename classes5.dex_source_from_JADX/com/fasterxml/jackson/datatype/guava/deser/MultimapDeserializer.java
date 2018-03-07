package com.fasterxml.jackson.datatype.guava.deser;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.KeyDeserializer;
import com.fasterxml.jackson.databind.deser.ContextualDeserializer;
import com.fasterxml.jackson.databind.jsontype.TypeDeserializer;
import com.fasterxml.jackson.databind.type.MapLikeType;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.LinkedListMultimap;
import com.google.common.collect.ListMultimap;
import com.google.common.collect.Multimap;
import java.lang.reflect.Method;
import java.util.List;

/* compiled from: can_view_members */
public class MultimapDeserializer extends JsonDeserializer<Multimap<?, ?>> implements ContextualDeserializer {
    private static final List<String> f6317a = ImmutableList.of("copyOf", "create");
    private final MapLikeType f6318b;
    private final KeyDeserializer f6319c;
    private final TypeDeserializer f6320d;
    private final JsonDeserializer<?> f6321e;
    private final Method f6322f;

    private MultimapDeserializer(MapLikeType mapLikeType, KeyDeserializer keyDeserializer, TypeDeserializer typeDeserializer, JsonDeserializer<?> jsonDeserializer, Method method) {
        this.f6318b = mapLikeType;
        this.f6319c = keyDeserializer;
        this.f6320d = typeDeserializer;
        this.f6321e = jsonDeserializer;
        this.f6322f = method;
    }

    public final JsonDeserializer<?> m12036a(DeserializationContext deserializationContext, BeanProperty beanProperty) {
        KeyDeserializer keyDeserializer = this.f6319c;
        if (keyDeserializer == null) {
            keyDeserializer = deserializationContext.b(this.f6318b.q(), beanProperty);
        }
        JsonDeserializer jsonDeserializer = this.f6321e;
        if (jsonDeserializer == null) {
            jsonDeserializer = deserializationContext.a(this.f6318b.r(), beanProperty);
        }
        TypeDeserializer typeDeserializer = this.f6320d;
        if (!(typeDeserializer == null || beanProperty == null)) {
            typeDeserializer = typeDeserializer.mo698a(beanProperty);
        }
        return new MultimapDeserializer(this.f6318b, keyDeserializer, typeDeserializer, jsonDeserializer, this.f6322f);
    }

    public Object m12037a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        LinkedListMultimap a = LinkedListMultimap.m13481a();
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            Object a2;
            if (this.f6319c != null) {
                a2 = this.f6319c.a(jsonParser.i(), deserializationContext);
            } else {
                a2 = jsonParser.i();
            }
            jsonParser.c();
            m12035a(jsonParser, JsonToken.START_ARRAY);
            while (jsonParser.c() != JsonToken.END_ARRAY) {
                if (this.f6320d != null) {
                    a.a(a2, this.f6321e.a(jsonParser, deserializationContext, this.f6320d));
                } else {
                    a.a(a2, this.f6321e.a(jsonParser, deserializationContext));
                }
            }
        }
        if (this.f6322f == null) {
            return a;
        }
        try {
            return (Multimap) this.f6322f.invoke(null, new Object[]{a});
        } catch (Throwable e) {
            throw new JsonMappingException("Could not map to " + this.f6318b, m12033a(e));
        } catch (Throwable e2) {
            throw new JsonMappingException("Could not map to " + this.f6318b, m12033a(e2));
        } catch (Throwable e22) {
            throw new JsonMappingException("Could not map to " + this.f6318b, m12033a(e22));
        }
    }

    private static Method m12034a(Class<?> cls) {
        if (cls == LinkedListMultimap.class || cls == ListMultimap.class || cls == Multimap.class) {
            return null;
        }
        for (String method : f6317a) {
            Method method2;
            try {
                method2 = cls.getMethod(method, new Class[]{Multimap.class});
                if (method2 != null) {
                    return method2;
                }
            } catch (NoSuchMethodException e) {
            }
        }
        for (String method3 : f6317a) {
            try {
                method2 = cls.getMethod(method3, new Class[]{Multimap.class});
                if (method2 != null) {
                    return method2;
                }
            } catch (NoSuchMethodException e2) {
            }
        }
        return null;
    }

    private static void m12035a(JsonParser jsonParser, JsonToken jsonToken) {
        if (jsonParser.g() != jsonToken) {
            throw new JsonMappingException("Expecting " + jsonToken + ", found " + jsonParser.g(), jsonParser.l());
        }
    }

    private static Throwable m12033a(Throwable th) {
        while (th.getCause() != null) {
            th = th.getCause();
        }
        return th;
    }

    public MultimapDeserializer(MapLikeType mapLikeType, KeyDeserializer keyDeserializer, TypeDeserializer typeDeserializer, JsonDeserializer<?> jsonDeserializer) {
        this(mapLikeType, keyDeserializer, typeDeserializer, jsonDeserializer, m12034a(mapLikeType._class));
    }
}
