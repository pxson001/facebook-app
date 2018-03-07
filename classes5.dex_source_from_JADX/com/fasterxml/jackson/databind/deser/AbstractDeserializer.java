package com.fasterxml.jackson.databind.deser;

import android.support.v7.widget.LinearLayoutCompat;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.BeanDescription;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.deser.impl.ObjectIdReader;
import com.fasterxml.jackson.databind.jsontype.TypeDeserializer;
import java.io.Serializable;
import java.util.Map;

/* compiled from: clientSessionContext */
public class AbstractDeserializer extends JsonDeserializer<Object> implements Serializable {
    private static final long serialVersionUID = -3010349050434697698L;
    protected final boolean _acceptBoolean;
    protected final boolean _acceptDouble;
    protected final boolean _acceptInt;
    protected final boolean _acceptString;
    protected final Map<String, SettableBeanProperty> _backRefProperties;
    protected final JavaType _baseType;
    protected final ObjectIdReader _objectIdReader;

    /* compiled from: clientSessionContext */
    /* synthetic */ class C05481 {
        static final /* synthetic */ int[] f5985a = new int[JsonToken.values().length];

        static {
            try {
                f5985a[JsonToken.VALUE_STRING.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f5985a[JsonToken.VALUE_NUMBER_INT.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f5985a[JsonToken.VALUE_NUMBER_FLOAT.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f5985a[JsonToken.VALUE_TRUE.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f5985a[JsonToken.VALUE_FALSE.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
        }
    }

    public AbstractDeserializer(BeanDeserializerBuilder beanDeserializerBuilder, BeanDescription beanDescription, Map<String, SettableBeanProperty> map) {
        boolean z;
        boolean z2 = false;
        this._baseType = beanDescription.a;
        this._objectIdReader = beanDeserializerBuilder.f5997h;
        this._backRefProperties = map;
        Class cls = this._baseType._class;
        this._acceptString = cls.isAssignableFrom(String.class);
        if (cls == Boolean.TYPE || cls.isAssignableFrom(Boolean.class)) {
            z = true;
        } else {
            z = false;
        }
        this._acceptBoolean = z;
        if (cls == Integer.TYPE || cls.isAssignableFrom(Integer.class)) {
            z = true;
        } else {
            z = false;
        }
        this._acceptInt = z;
        if (cls == Double.TYPE || cls.isAssignableFrom(Double.class)) {
            z2 = true;
        }
        this._acceptDouble = z2;
    }

    public final boolean m10826d() {
        return true;
    }

    public final SettableBeanProperty m10823a(String str) {
        return this._backRefProperties == null ? null : (SettableBeanProperty) this._backRefProperties.get(str);
    }

    public final Object m10825a(JsonParser jsonParser, DeserializationContext deserializationContext, TypeDeserializer typeDeserializer) {
        if (this._objectIdReader != null) {
            JsonToken g = jsonParser.g();
            if (g != null && g.isScalarValue()) {
                return m10822b(jsonParser, deserializationContext);
            }
        }
        Object a = m10821a(jsonParser);
        return a == null ? typeDeserializer.mo699a(jsonParser, deserializationContext) : a;
    }

    public Object m10824a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        throw deserializationContext.a(this._baseType._class, "abstract types either need to be mapped to concrete types, have custom deserializer, or be instantiated with additional type information");
    }

    private Object m10821a(JsonParser jsonParser) {
        switch (C05481.f5985a[jsonParser.g().ordinal()]) {
            case 1:
                if (this._acceptString) {
                    return jsonParser.o();
                }
                break;
            case LinearLayoutCompat.SHOW_DIVIDER_MIDDLE /*2*/:
                if (this._acceptInt) {
                    return Integer.valueOf(jsonParser.x());
                }
                break;
            case 3:
                if (this._acceptDouble) {
                    return Double.valueOf(jsonParser.B());
                }
                break;
            case LinearLayoutCompat.SHOW_DIVIDER_END /*4*/:
                if (this._acceptBoolean) {
                    return Boolean.TRUE;
                }
                break;
            case 5:
                if (this._acceptBoolean) {
                    return Boolean.FALSE;
                }
                break;
        }
        return null;
    }

    private Object m10822b(JsonParser jsonParser, DeserializationContext deserializationContext) {
        Object a = this._objectIdReader.deserializer.a(jsonParser, deserializationContext);
        Object obj = deserializationContext.a(a, this._objectIdReader.generator).f6055b;
        if (obj != null) {
            return obj;
        }
        throw new IllegalStateException("Could not resolve Object Id [" + a + "] -- unresolved forward-reference?");
    }
}
