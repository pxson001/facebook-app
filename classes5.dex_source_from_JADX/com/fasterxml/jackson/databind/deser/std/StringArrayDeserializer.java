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
import com.fasterxml.jackson.databind.util.ObjectBuffer;

@JacksonStdImpl
/* compiled from: check_box_label */
public final class StringArrayDeserializer extends StdDeserializer<String[]> implements ContextualDeserializer {
    public static final StringArrayDeserializer f6101a = new StringArrayDeserializer();
    private static final long serialVersionUID = -7589512013334920693L;
    protected JsonDeserializer<String> _elementDeserializer;

    public final /* synthetic */ Object m11341a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return m11343b(jsonParser, deserializationContext);
    }

    public StringArrayDeserializer() {
        super(String[].class);
        this._elementDeserializer = null;
    }

    private StringArrayDeserializer(JsonDeserializer<?> jsonDeserializer) {
        super(String[].class);
        this._elementDeserializer = jsonDeserializer;
    }

    public final String[] m11343b(JsonParser jsonParser, DeserializationContext deserializationContext) {
        if (!jsonParser.m()) {
            return m11339e(jsonParser, deserializationContext);
        }
        if (this._elementDeserializer != null) {
            return m11338d(jsonParser, deserializationContext);
        }
        ObjectBuffer l = deserializationContext.l();
        Object[] a = l.m11800a();
        int i = 0;
        while (true) {
            JsonToken c = jsonParser.c();
            if (c != JsonToken.END_ARRAY) {
                String o;
                int i2;
                if (c == JsonToken.VALUE_STRING) {
                    o = jsonParser.o();
                } else if (c == JsonToken.VALUE_NULL) {
                    o = null;
                } else {
                    o = StdDeserializer.x(jsonParser, deserializationContext);
                }
                if (i >= a.length) {
                    a = l.m11801a(a);
                    i2 = 0;
                } else {
                    i2 = i;
                }
                i = i2 + 1;
                a[i2] = o;
            } else {
                String[] strArr = (String[]) l.m11803a(a, i, String.class);
                deserializationContext.a(l);
                return strArr;
            }
        }
    }

    private String[] m11338d(JsonParser jsonParser, DeserializationContext deserializationContext) {
        ObjectBuffer l = deserializationContext.l();
        Object[] a = l.m11800a();
        JsonDeserializer jsonDeserializer = this._elementDeserializer;
        int i = 0;
        Object[] objArr = a;
        while (true) {
            JsonToken c = jsonParser.c();
            if (c != JsonToken.END_ARRAY) {
                Object obj;
                Object[] a2;
                int i2;
                if (c == JsonToken.VALUE_NULL) {
                    obj = null;
                } else {
                    String str = (String) jsonDeserializer.a(jsonParser, deserializationContext);
                }
                if (i >= objArr.length) {
                    a2 = l.m11801a(objArr);
                    i2 = 0;
                } else {
                    int i3 = i;
                    a2 = objArr;
                    i2 = i3;
                }
                int i4 = i2 + 1;
                a2[i2] = obj;
                objArr = a2;
                i = i4;
            } else {
                String[] strArr = (String[]) l.m11803a(objArr, i, String.class);
                deserializationContext.a(l);
                return strArr;
            }
        }
    }

    public final Object m11342a(JsonParser jsonParser, DeserializationContext deserializationContext, TypeDeserializer typeDeserializer) {
        return typeDeserializer.mo700b(jsonParser, deserializationContext);
    }

    private final String[] m11339e(JsonParser jsonParser, DeserializationContext deserializationContext) {
        String[] strArr = null;
        if (deserializationContext.a(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY)) {
            String[] strArr2 = new String[1];
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                strArr = StdDeserializer.x(jsonParser, deserializationContext);
            }
            strArr2[0] = strArr;
            return strArr2;
        } else if (jsonParser.g() == JsonToken.VALUE_STRING && deserializationContext.a(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT) && jsonParser.o().length() == 0) {
            return null;
        } else {
            throw deserializationContext.b(this._valueClass);
        }
    }

    public final JsonDeserializer<?> m11340a(DeserializationContext deserializationContext, BeanProperty beanProperty) {
        JsonDeserializer a = StdDeserializer.a(deserializationContext, beanProperty, this._elementDeserializer);
        if (a == null) {
            a = deserializationContext.a(deserializationContext.a(String.class), beanProperty);
        } else if (a instanceof ContextualDeserializer) {
            a = ((ContextualDeserializer) a).a(deserializationContext, beanProperty);
        }
        if (a != null && StdDeserializer.a(a)) {
            a = null;
        }
        if (this._elementDeserializer != a) {
            return new StringArrayDeserializer(a);
        }
        return this;
    }
}
