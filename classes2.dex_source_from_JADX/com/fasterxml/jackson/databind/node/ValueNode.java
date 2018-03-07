package com.fasterxml.jackson.databind.node;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.TreeNode;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;

/* compiled from: temp_ */
public abstract class ValueNode extends BaseJsonNode {
    public final /* synthetic */ TreeNode mo707a(String str) {
        return mo709b(str);
    }

    protected ValueNode() {
    }

    public <T extends JsonNode> T mo711d() {
        return this;
    }

    public final JsonNode mo710c(String str) {
        return MissingNode.a;
    }

    public void serializeWithType(JsonGenerator jsonGenerator, SerializerProvider serializerProvider, TypeSerializer typeSerializer) {
        typeSerializer.a(this, jsonGenerator);
        serialize(jsonGenerator, serializerProvider);
        typeSerializer.d(this, jsonGenerator);
    }

    public String toString() {
        return mo719B();
    }

    public final JsonNode mo708a(int i) {
        return null;
    }

    public final JsonNode mo709b(String str) {
        return null;
    }

    public final boolean mo730d(String str) {
        return false;
    }

    public final boolean mo731e(String str) {
        return false;
    }

    public final JsonNode mo713f(String str) {
        return null;
    }
}
