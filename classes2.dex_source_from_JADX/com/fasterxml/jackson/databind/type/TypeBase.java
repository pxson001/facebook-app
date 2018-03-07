package com.fasterxml.jackson.databind.type;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonSerializable;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;

/* compiled from: streaming_fetch_rerun_count */
public abstract class TypeBase extends JavaType implements JsonSerializable {
    private static final long serialVersionUID = -3581199092426900829L;
    volatile transient String f4010a;

    protected abstract String mo927v();

    protected TypeBase(Class<?> cls, int i, Object obj, Object obj2, boolean z) {
        super(cls, i, obj, obj2, z);
    }

    public final String mo928a() {
        String str = this.f4010a;
        if (str == null) {
            return mo927v();
        }
        return str;
    }

    public final <T> T mo929t() {
        return this._valueHandler;
    }

    public final <T> T mo930u() {
        return this._typeHandler;
    }

    public void serializeWithType(JsonGenerator jsonGenerator, SerializerProvider serializerProvider, TypeSerializer typeSerializer) {
        typeSerializer.a(this, jsonGenerator);
        serialize(jsonGenerator, serializerProvider);
        typeSerializer.d(this, jsonGenerator);
    }

    public void serialize(JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        jsonGenerator.mo1123b(mo928a());
    }
}
