package com.fasterxml.jackson.databind.deser.std;

import com.fasterxml.jackson.core.JsonLocation;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.BeanDescription;
import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.deser.CreatorProperty;
import com.fasterxml.jackson.databind.deser.SettableBeanProperty;
import com.fasterxml.jackson.databind.deser.ValueInstantiator;
import com.fasterxml.jackson.databind.util.TokenBuffer;

/* compiled from: checkout_url */
public class JacksonDeserializers {

    /* compiled from: checkout_url */
    public class JavaTypeDeserializer extends StdScalarDeserializer<JavaType> {
        public static final JavaTypeDeserializer f6068a = new JavaTypeDeserializer();

        public /* synthetic */ Object m11179a(JsonParser jsonParser, DeserializationContext deserializationContext) {
            return m11180b(jsonParser, deserializationContext);
        }

        public JavaTypeDeserializer() {
            super(JavaType.class);
        }

        public JavaType m11180b(JsonParser jsonParser, DeserializationContext deserializationContext) {
            JsonToken g = jsonParser.g();
            if (g == JsonToken.VALUE_STRING) {
                String trim = jsonParser.o().trim();
                if (trim.length() == 0) {
                    return (JavaType) b();
                }
                return deserializationContext.c().a(trim);
            } else if (g == JsonToken.VALUE_EMBEDDED_OBJECT) {
                return (JavaType) jsonParser.D();
            } else {
                throw deserializationContext.b(this._valueClass);
            }
        }
    }

    /* compiled from: checkout_url */
    public class JsonLocationInstantiator extends ValueInstantiator {
        public static final JsonLocationInstantiator f6069a = new JsonLocationInstantiator();

        public final String mo671a() {
            return JsonLocation.class.getName();
        }

        public final boolean mo673j() {
            return true;
        }

        public final SettableBeanProperty[] mo672a(DeserializationConfig deserializationConfig) {
            JavaType b = deserializationConfig.b(Integer.TYPE);
            JavaType b2 = deserializationConfig.b(Long.TYPE);
            return (SettableBeanProperty[]) new CreatorProperty[]{m11182a("sourceRef", deserializationConfig.b(Object.class), 0), m11182a("byteOffset", b2, 1), m11182a("charOffset", b2, 2), m11182a("lineNr", b, 3), m11182a("columnNr", b, 4)};
        }

        private static CreatorProperty m11182a(String str, JavaType javaType, int i) {
            return new CreatorProperty(str, javaType, null, null, null, null, i, null, true);
        }

        public final Object mo670a(Object[] objArr) {
            return new JsonLocation(objArr[0], m11181a(objArr[1]), m11181a(objArr[2]), m11183b(objArr[3]), m11183b(objArr[4]));
        }

        private static final long m11181a(Object obj) {
            return obj == null ? 0 : ((Number) obj).longValue();
        }

        private static final int m11183b(Object obj) {
            return obj == null ? 0 : ((Number) obj).intValue();
        }
    }

    public static JsonDeserializer<?> m11188a(Class<?> cls) {
        if (cls == TokenBuffer.class) {
            return TokenBufferDeserializer.a;
        }
        if (JavaType.class.isAssignableFrom(cls)) {
            return JavaTypeDeserializer.f6068a;
        }
        return null;
    }

    public static ValueInstantiator m11189a(BeanDescription beanDescription) {
        if (beanDescription.b() == JsonLocation.class) {
            return JsonLocationInstantiator.f6069a;
        }
        return null;
    }
}
