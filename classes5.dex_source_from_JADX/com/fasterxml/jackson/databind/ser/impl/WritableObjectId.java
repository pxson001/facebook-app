package com.fasterxml.jackson.databind.ser.impl;

import com.fasterxml.jackson.annotation.ObjectIdGenerator;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.io.SerializedString;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: can_viewer_react */
public final class WritableObjectId {
    public final ObjectIdGenerator<?> f6188a;
    public Object f6189b;
    protected boolean f6190c = false;

    public WritableObjectId(ObjectIdGenerator<?> objectIdGenerator) {
        this.f6188a = objectIdGenerator;
    }

    public final boolean m11643a(JsonGenerator jsonGenerator, SerializerProvider serializerProvider, ObjectIdWriter objectIdWriter) {
        if (this.f6189b == null || (!this.f6190c && !objectIdWriter.f6170e)) {
            return false;
        }
        objectIdWriter.f6169d.a(this.f6189b, jsonGenerator, serializerProvider);
        return true;
    }

    public final Object m11642a(Object obj) {
        Object b = this.f6188a.mo660b(obj);
        this.f6189b = b;
        return b;
    }

    public final void m11644b(JsonGenerator jsonGenerator, SerializerProvider serializerProvider, ObjectIdWriter objectIdWriter) {
        SerializedString serializedString = objectIdWriter.f6167b;
        this.f6190c = true;
        if (serializedString != null) {
            jsonGenerator.b(serializedString);
            objectIdWriter.f6169d.a(this.f6189b, jsonGenerator, serializerProvider);
        }
    }
}
