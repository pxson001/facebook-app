package com.fasterxml.jackson.databind.deser.std;

import com.facebook.proxygen.HTTPTransportCallback;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.annotation.JacksonStdImpl;
import com.fasterxml.jackson.databind.jsontype.TypeDeserializer;
import com.fasterxml.jackson.databind.util.ObjectBuffer;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

@JacksonStdImpl
/* compiled from: pull_to_refresh_medium */
public class UntypedObjectDeserializer extends StdDeserializer<Object> {
    public static final UntypedObjectDeserializer f8649a = new UntypedObjectDeserializer();
    private static final Object[] f8650b = new Object[0];
    private static final long serialVersionUID = 1;

    public UntypedObjectDeserializer() {
        super(Object.class);
    }

    public Object mo1797a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        switch (1.a[jsonParser.mo1794g().ordinal()]) {
            case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
                return m13432d(jsonParser, deserializationContext);
            case HTTPTransportCallback.FIRST_BODY_BYTE_FLUSHED /*2*/:
                return m13431b(jsonParser, deserializationContext);
            case 3:
                return m13432d(jsonParser, deserializationContext);
            case HTTPTransportCallback.LAST_BODY_BYTE_FLUSHED /*4*/:
                return jsonParser.mo1776D();
            case 5:
                return jsonParser.mo1769o();
            case 6:
                if (deserializationContext.m7395a(DeserializationFeature.USE_BIG_INTEGER_FOR_INTS)) {
                    return jsonParser.mo1787z();
                }
                return jsonParser.mo1783t();
            case 7:
                if (deserializationContext.m7395a(DeserializationFeature.USE_BIG_DECIMAL_FOR_FLOATS)) {
                    return jsonParser.mo1775C();
                }
                return Double.valueOf(jsonParser.mo1774B());
            case HTTPTransportCallback.LAST_BODY_BYTE_ACKED /*8*/:
                return Boolean.TRUE;
            case 9:
                return Boolean.FALSE;
            case 10:
                return null;
            default:
                throw deserializationContext.m7397b(Object.class);
        }
    }

    public final Object mo1799a(JsonParser jsonParser, DeserializationContext deserializationContext, TypeDeserializer typeDeserializer) {
        switch (1.a[jsonParser.mo1794g().ordinal()]) {
            case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
            case HTTPTransportCallback.FIRST_BODY_BYTE_FLUSHED /*2*/:
            case 3:
                return typeDeserializer.d(jsonParser, deserializationContext);
            case HTTPTransportCallback.LAST_BODY_BYTE_FLUSHED /*4*/:
                return jsonParser.mo1776D();
            case 5:
                return jsonParser.mo1769o();
            case 6:
                if (deserializationContext.m7395a(DeserializationFeature.USE_BIG_INTEGER_FOR_INTS)) {
                    return jsonParser.mo1787z();
                }
                return jsonParser.mo1783t();
            case 7:
                if (deserializationContext.m7395a(DeserializationFeature.USE_BIG_DECIMAL_FOR_FLOATS)) {
                    return jsonParser.mo1775C();
                }
                return Double.valueOf(jsonParser.mo1774B());
            case HTTPTransportCallback.LAST_BODY_BYTE_ACKED /*8*/:
                return Boolean.TRUE;
            case 9:
                return Boolean.FALSE;
            case 10:
                return null;
            default:
                throw deserializationContext.m7397b(Object.class);
        }
    }

    private Object m13431b(JsonParser jsonParser, DeserializationContext deserializationContext) {
        if (deserializationContext.m7395a(DeserializationFeature.USE_JAVA_ARRAY_FOR_JSON_ARRAY)) {
            return m13433e(jsonParser, deserializationContext);
        }
        if (jsonParser.mo1766c() == JsonToken.END_ARRAY) {
            return new ArrayList(4);
        }
        ObjectBuffer l = deserializationContext.m7413l();
        int i = 0;
        Object[] a = l.a();
        int i2 = 0;
        do {
            int i3;
            Object a2 = mo1797a(jsonParser, deserializationContext);
            i2++;
            if (i >= a.length) {
                a = l.a(a);
                i3 = 0;
            } else {
                i3 = i;
            }
            i = i3 + 1;
            a[i3] = a2;
        } while (jsonParser.mo1766c() != JsonToken.END_ARRAY);
        List arrayList = new ArrayList((i2 + (i2 >> 3)) + 1);
        l.a(a, i, arrayList);
        return arrayList;
    }

    private Object m13432d(JsonParser jsonParser, DeserializationContext deserializationContext) {
        JsonToken g = jsonParser.mo1794g();
        if (g == JsonToken.START_OBJECT) {
            g = jsonParser.mo1766c();
        }
        if (g != JsonToken.FIELD_NAME) {
            return new LinkedHashMap(4);
        }
        String o = jsonParser.mo1769o();
        jsonParser.mo1766c();
        Object a = mo1797a(jsonParser, deserializationContext);
        if (jsonParser.mo1766c() != JsonToken.FIELD_NAME) {
            Object linkedHashMap = new LinkedHashMap(4);
            linkedHashMap.put(o, a);
            return linkedHashMap;
        }
        String o2 = jsonParser.mo1769o();
        jsonParser.mo1766c();
        Object a2 = mo1797a(jsonParser, deserializationContext);
        if (jsonParser.mo1766c() != JsonToken.FIELD_NAME) {
            linkedHashMap = new LinkedHashMap(4);
            linkedHashMap.put(o, a);
            linkedHashMap.put(o2, a2);
            return linkedHashMap;
        }
        linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(o, a);
        linkedHashMap.put(o2, a2);
        do {
            o = jsonParser.mo1769o();
            jsonParser.mo1766c();
            linkedHashMap.put(o, mo1797a(jsonParser, deserializationContext));
        } while (jsonParser.mo1766c() != JsonToken.END_OBJECT);
        return linkedHashMap;
    }

    private Object[] m13433e(JsonParser jsonParser, DeserializationContext deserializationContext) {
        if (jsonParser.mo1766c() == JsonToken.END_ARRAY) {
            return f8650b;
        }
        ObjectBuffer l = deserializationContext.m7413l();
        Object[] a = l.a();
        int i = 0;
        do {
            int i2;
            Object a2 = mo1797a(jsonParser, deserializationContext);
            if (i >= a.length) {
                a = l.a(a);
                i2 = 0;
            } else {
                i2 = i;
            }
            i = i2 + 1;
            a[i2] = a2;
        } while (jsonParser.mo1766c() != JsonToken.END_ARRAY);
        return l.a(a, i);
    }
}
