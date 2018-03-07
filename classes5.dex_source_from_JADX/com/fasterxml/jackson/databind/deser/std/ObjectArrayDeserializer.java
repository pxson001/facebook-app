package com.fasterxml.jackson.databind.deser.std;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.annotation.JacksonStdImpl;
import com.fasterxml.jackson.databind.deser.ContextualDeserializer;
import com.fasterxml.jackson.databind.jsontype.TypeDeserializer;
import com.fasterxml.jackson.databind.type.ArrayType;
import com.fasterxml.jackson.databind.util.ObjectBuffer;
import java.lang.reflect.Array;

@JacksonStdImpl
/* compiled from: checkin */
public class ObjectArrayDeserializer extends ContainerDeserializerBase<Object[]> implements ContextualDeserializer {
    private static final long serialVersionUID = 1;
    protected final ArrayType _arrayType;
    protected final Class<?> _elementClass;
    protected JsonDeserializer<Object> _elementDeserializer;
    protected final TypeDeserializer _elementTypeDeserializer;
    protected final boolean _untyped;

    public /* synthetic */ Object m11255a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return m11257b(jsonParser, deserializationContext);
    }

    public ObjectArrayDeserializer(ArrayType arrayType, JsonDeserializer<Object> jsonDeserializer, TypeDeserializer typeDeserializer) {
        super(Object[].class);
        this._arrayType = arrayType;
        this._elementClass = arrayType.r()._class;
        this._untyped = this._elementClass == Object.class;
        this._elementDeserializer = jsonDeserializer;
        this._elementTypeDeserializer = typeDeserializer;
    }

    private ObjectArrayDeserializer m11251a(TypeDeserializer typeDeserializer, JsonDeserializer<?> jsonDeserializer) {
        return (jsonDeserializer == this._elementDeserializer && typeDeserializer == this._elementTypeDeserializer) ? this : new ObjectArrayDeserializer(this._arrayType, jsonDeserializer, typeDeserializer);
    }

    public final JsonDeserializer<?> m11254a(DeserializationContext deserializationContext, BeanProperty beanProperty) {
        JsonDeserializer a = StdDeserializer.a(deserializationContext, beanProperty, this._elementDeserializer);
        if (a == null) {
            a = deserializationContext.a(this._arrayType.r(), beanProperty);
        } else if (a instanceof ContextualDeserializer) {
            a = ((ContextualDeserializer) a).a(deserializationContext, beanProperty);
        }
        TypeDeserializer typeDeserializer = this._elementTypeDeserializer;
        if (typeDeserializer != null) {
            typeDeserializer = typeDeserializer.mo698a(beanProperty);
        }
        return m11251a(typeDeserializer, a);
    }

    public final JsonDeserializer<Object> mo662e() {
        return this._elementDeserializer;
    }

    public Object[] m11257b(JsonParser jsonParser, DeserializationContext deserializationContext) {
        if (!jsonParser.m()) {
            return m11253e(jsonParser, deserializationContext);
        }
        ObjectBuffer l = deserializationContext.l();
        Object[] a = l.m11800a();
        TypeDeserializer typeDeserializer = this._elementTypeDeserializer;
        Object[] objArr = a;
        int i = 0;
        while (true) {
            JsonToken c = jsonParser.c();
            if (c == JsonToken.END_ARRAY) {
                break;
            }
            Object obj;
            int i2;
            if (c == JsonToken.VALUE_NULL) {
                obj = null;
            } else if (typeDeserializer == null) {
                obj = this._elementDeserializer.a(jsonParser, deserializationContext);
            } else {
                obj = this._elementDeserializer.a(jsonParser, deserializationContext, typeDeserializer);
            }
            if (i >= objArr.length) {
                objArr = l.m11801a(objArr);
                i2 = 0;
            } else {
                i2 = i;
            }
            i = i2 + 1;
            objArr[i2] = obj;
        }
        if (this._untyped) {
            a = l.m11802a(objArr, i);
        } else {
            a = l.m11803a(objArr, i, this._elementClass);
        }
        deserializationContext.a(l);
        return a;
    }

    public final Object m11256a(JsonParser jsonParser, DeserializationContext deserializationContext, TypeDeserializer typeDeserializer) {
        return (Object[]) typeDeserializer.mo700b(jsonParser, deserializationContext);
    }

    private static Byte[] m11252d(JsonParser jsonParser, DeserializationContext deserializationContext) {
        byte[] a = jsonParser.a(deserializationContext.h());
        Byte[] bArr = new Byte[a.length];
        int length = a.length;
        for (int i = 0; i < length; i++) {
            bArr[i] = Byte.valueOf(a[i]);
        }
        return bArr;
    }

    private final Object[] m11253e(JsonParser jsonParser, DeserializationContext deserializationContext) {
        if (jsonParser.g() == JsonToken.VALUE_STRING && deserializationContext.a(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT) && jsonParser.o().length() == 0) {
            return null;
        }
        if (deserializationContext.a(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY)) {
            Object obj;
            Object[] objArr;
            if (jsonParser.g() == JsonToken.VALUE_NULL) {
                obj = null;
            } else if (this._elementTypeDeserializer == null) {
                obj = this._elementDeserializer.a(jsonParser, deserializationContext);
            } else {
                obj = this._elementDeserializer.a(jsonParser, deserializationContext, this._elementTypeDeserializer);
            }
            if (this._untyped) {
                objArr = new Object[1];
            } else {
                objArr = (Object[]) Array.newInstance(this._elementClass, 1);
            }
            objArr[0] = obj;
            return objArr;
        } else if (jsonParser.g() == JsonToken.VALUE_STRING && this._elementClass == Byte.class) {
            return m11252d(jsonParser, deserializationContext);
        } else {
            throw deserializationContext.b(this._arrayType._class);
        }
    }
}
