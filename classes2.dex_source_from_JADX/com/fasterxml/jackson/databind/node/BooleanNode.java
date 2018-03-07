package com.fasterxml.jackson.databind.node;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: requires_admin_membership_approval */
public final class BooleanNode extends ValueNode {
    public static final BooleanNode f7218a = new BooleanNode(true);
    public static final BooleanNode f7219b = new BooleanNode(false);
    private final boolean f7220c;

    private BooleanNode(boolean z) {
        this.f7220c = z;
    }

    public static BooleanNode m11686I() {
        return f7218a;
    }

    public static BooleanNode m11687J() {
        return f7219b;
    }

    public static BooleanNode m11688b(boolean z) {
        return z ? f7218a : f7219b;
    }

    public final JsonNodeType mo715k() {
        return JsonNodeType.BOOLEAN;
    }

    public final JsonToken mo706a() {
        return this.f7220c ? JsonToken.VALUE_TRUE : JsonToken.VALUE_FALSE;
    }

    public final boolean mo1647u() {
        return this.f7220c;
    }

    public final String mo719B() {
        return this.f7220c ? "true" : "false";
    }

    public final boolean mo1646F() {
        return this.f7220c;
    }

    public final boolean mo726a(boolean z) {
        return this.f7220c;
    }

    public final int mo727b(int i) {
        return this.f7220c ? 1 : 0;
    }

    public final long mo725a(long j) {
        return this.f7220c ? 1 : 0;
    }

    public final double mo724a(double d) {
        return this.f7220c ? 1.0d : 0.0d;
    }

    public final void serialize(JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        jsonGenerator.mo1119a(this.f7220c);
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
        if (this.f7220c != ((BooleanNode) obj).f7220c) {
            return false;
        }
        return true;
    }
}
