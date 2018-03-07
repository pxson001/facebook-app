package com.fasterxml.jackson.databind.node;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: capabilities */
public final class POJONode extends ValueNode {
    public final Object f6154a;

    public POJONode(Object obj) {
        this.f6154a = obj;
    }

    public final JsonNodeType m11554k() {
        return JsonNodeType.POJO;
    }

    public final JsonToken m11551a() {
        return JsonToken.VALUE_EMBEDDED_OBJECT;
    }

    public final byte[] m11555t() {
        if (this.f6154a instanceof byte[]) {
            return (byte[]) this.f6154a;
        }
        return super.t();
    }

    public final String m11547B() {
        return this.f6154a == null ? "null" : this.f6154a.toString();
    }

    public final boolean m11552a(boolean z) {
        if (this.f6154a == null || !(this.f6154a instanceof Boolean)) {
            return z;
        }
        return ((Boolean) this.f6154a).booleanValue();
    }

    public final int m11553b(int i) {
        if (this.f6154a instanceof Number) {
            return ((Number) this.f6154a).intValue();
        }
        return i;
    }

    public final long m11550a(long j) {
        if (this.f6154a instanceof Number) {
            return ((Number) this.f6154a).longValue();
        }
        return j;
    }

    public final double m11549a(double d) {
        if (this.f6154a instanceof Number) {
            return ((Number) this.f6154a).doubleValue();
        }
        return d;
    }

    public final void serialize(JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        if (this.f6154a == null) {
            serializerProvider.a(jsonGenerator);
        } else {
            jsonGenerator.a(this.f6154a);
        }
    }

    public final Object m11548I() {
        return this.f6154a;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (obj.getClass() != getClass()) {
            return false;
        }
        POJONode pOJONode = (POJONode) obj;
        if (this.f6154a != null) {
            return this.f6154a.equals(pOJONode.f6154a);
        }
        if (pOJONode.f6154a != null) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return this.f6154a.hashCode();
    }

    public final String toString() {
        return String.valueOf(this.f6154a);
    }
}
