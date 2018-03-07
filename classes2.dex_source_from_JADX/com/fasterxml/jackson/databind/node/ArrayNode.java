package com.fasterxml.jackson.databind.node;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.core.TreeNode;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: push_ack */
public final class ArrayNode extends ContainerNode<ArrayNode> {
    private final List<JsonNode> f8635b = new ArrayList();

    public final /* synthetic */ TreeNode mo707a(String str) {
        return mo709b(str);
    }

    public ArrayNode(JsonNodeFactory jsonNodeFactory) {
        super(jsonNodeFactory);
    }

    public final JsonNode mo711d() {
        JsonNode arrayNode = new ArrayNode(this.f3120a);
        for (JsonNode d : this.f8635b) {
            arrayNode.f8635b.add(d.mo711d());
        }
        return arrayNode;
    }

    public final JsonNode mo710c(String str) {
        return MissingNode.a;
    }

    public final JsonNodeType mo715k() {
        return JsonNodeType.ARRAY;
    }

    public final JsonToken mo706a() {
        return JsonToken.START_ARRAY;
    }

    public final int mo712e() {
        return this.f8635b.size();
    }

    public final Iterator<JsonNode> mo704G() {
        return this.f8635b.iterator();
    }

    public final JsonNode mo708a(int i) {
        if (i < 0 || i >= this.f8635b.size()) {
            return null;
        }
        return (JsonNode) this.f8635b.get(i);
    }

    public final JsonNode mo709b(String str) {
        return null;
    }

    public final void serialize(JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        jsonGenerator.mo1129d();
        for (JsonNode jsonNode : this.f8635b) {
            ((BaseJsonNode) jsonNode).serialize(jsonGenerator, serializerProvider);
        }
        jsonGenerator.mo1132e();
    }

    public final void serializeWithType(JsonGenerator jsonGenerator, SerializerProvider serializerProvider, TypeSerializer typeSerializer) {
        typeSerializer.c(this, jsonGenerator);
        for (JsonNode jsonNode : this.f8635b) {
            ((BaseJsonNode) jsonNode).serialize(jsonGenerator, serializerProvider);
        }
        typeSerializer.f(this, jsonGenerator);
    }

    public final JsonNode mo713f(String str) {
        for (JsonNode f : this.f8635b) {
            JsonNode f2 = f2.mo713f(str);
            if (f2 != null) {
                return f2;
            }
        }
        return null;
    }

    public final ArrayNode m13381a(JsonNode jsonNode) {
        if (jsonNode == null) {
            jsonNode = m5156M();
        }
        m13373b(jsonNode);
        return this;
    }

    public final ArrayNode m13382a(ArrayNode arrayNode) {
        this.f8635b.addAll(arrayNode.f8635b);
        return this;
    }

    public final ArrayNode m13380a(int i, JsonNode jsonNode) {
        if (jsonNode == null) {
            jsonNode = m5156M();
        }
        m13372b(i, jsonNode);
        return this;
    }

    public final ObjectNode m13375I() {
        JsonNode L = m5155L();
        m13373b(L);
        return L;
    }

    public final ArrayNode m13376J() {
        m13373b(m5156M());
        return this;
    }

    public final ArrayNode m13390c(int i) {
        m13373b(m5165d(i));
        return this;
    }

    public final ArrayNode m13385a(Integer num) {
        if (num == null) {
            return m13376J();
        }
        return m13373b(m5165d(num.intValue()));
    }

    public final ArrayNode m13388b(long j) {
        return m13373b(m5164c(j));
    }

    public final ArrayNode m13386a(Long l) {
        if (l == null) {
            return m13376J();
        }
        return m13373b(m5164c(l.longValue()));
    }

    public final ArrayNode m13384a(Double d) {
        if (d == null) {
            return m13376J();
        }
        return m13373b(m5163b(d.doubleValue()));
    }

    public final ArrayNode m13394h(String str) {
        if (str == null) {
            return m13376J();
        }
        return m13373b(m5167i(str));
    }

    public final ArrayNode m13383a(Boolean bool) {
        if (bool == null) {
            return m13376J();
        }
        return m13373b(m5162b(bool.booleanValue()));
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return this.f8635b.equals(((ArrayNode) obj).f8635b);
    }

    public final int hashCode() {
        return this.f8635b.hashCode();
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder((mo712e() << 4) + 16);
        stringBuilder.append('[');
        int size = this.f8635b.size();
        for (int i = 0; i < size; i++) {
            if (i > 0) {
                stringBuilder.append(',');
            }
            stringBuilder.append(((JsonNode) this.f8635b.get(i)).toString());
        }
        stringBuilder.append(']');
        return stringBuilder.toString();
    }

    private ArrayNode m13373b(JsonNode jsonNode) {
        this.f8635b.add(jsonNode);
        return this;
    }

    private ArrayNode m13372b(int i, JsonNode jsonNode) {
        if (i < 0) {
            this.f8635b.add(0, jsonNode);
        } else if (i >= this.f8635b.size()) {
            this.f8635b.add(jsonNode);
        } else {
            this.f8635b.add(i, jsonNode);
        }
        return this;
    }
}
