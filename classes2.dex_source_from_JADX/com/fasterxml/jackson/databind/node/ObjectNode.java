package com.fasterxml.jackson.databind.node;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.core.TreeNode;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

/* compiled from: textbox_clicked_cold */
public final class ObjectNode extends ContainerNode<ObjectNode> {
    private final Map<String, JsonNode> f3119b = new LinkedHashMap();

    public final /* synthetic */ TreeNode mo707a(String str) {
        return mo709b(str);
    }

    public final /* synthetic */ JsonNode mo711d() {
        return m5122I();
    }

    public ObjectNode(JsonNodeFactory jsonNodeFactory) {
        super(jsonNodeFactory);
    }

    public final ObjectNode m5122I() {
        ObjectNode objectNode = new ObjectNode(this.f3120a);
        for (Entry entry : this.f3119b.entrySet()) {
            objectNode.f3119b.put(entry.getKey(), ((JsonNode) entry.getValue()).mo711d());
        }
        return objectNode;
    }

    public final JsonNodeType mo715k() {
        return JsonNodeType.OBJECT;
    }

    public final JsonToken mo706a() {
        return JsonToken.START_OBJECT;
    }

    public final int mo712e() {
        return this.f3119b.size();
    }

    public final Iterator<JsonNode> mo704G() {
        return this.f3119b.values().iterator();
    }

    public final JsonNode mo708a(int i) {
        return null;
    }

    public final JsonNode mo709b(String str) {
        return (JsonNode) this.f3119b.get(str);
    }

    public final Iterator<String> mo714j() {
        return this.f3119b.keySet().iterator();
    }

    public final JsonNode mo710c(String str) {
        JsonNode jsonNode = (JsonNode) this.f3119b.get(str);
        if (jsonNode != null) {
            return jsonNode;
        }
        return MissingNode.a;
    }

    public final Iterator<Entry<String, JsonNode>> mo705H() {
        return this.f3119b.entrySet().iterator();
    }

    public final JsonNode mo713f(String str) {
        for (Entry entry : this.f3119b.entrySet()) {
            if (str.equals(entry.getKey())) {
                return (JsonNode) entry.getValue();
            }
            JsonNode f = ((JsonNode) entry.getValue()).mo713f(str);
            if (f != null) {
                return f;
            }
        }
        return null;
    }

    public final void serialize(JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        jsonGenerator.mo1134f();
        for (Entry entry : this.f3119b.entrySet()) {
            jsonGenerator.mo1115a((String) entry.getKey());
            ((BaseJsonNode) entry.getValue()).serialize(jsonGenerator, serializerProvider);
        }
        jsonGenerator.mo1136g();
    }

    public final void serializeWithType(JsonGenerator jsonGenerator, SerializerProvider serializerProvider, TypeSerializer typeSerializer) {
        typeSerializer.b(this, jsonGenerator);
        for (Entry entry : this.f3119b.entrySet()) {
            jsonGenerator.mo1115a((String) entry.getKey());
            ((BaseJsonNode) entry.getValue()).serialize(jsonGenerator, serializerProvider);
        }
        typeSerializer.e(this, jsonGenerator);
    }

    public final JsonNode m5126a(String str, JsonNode jsonNode) {
        if (jsonNode == null) {
            jsonNode = m5156M();
        }
        this.f3119b.put(str, jsonNode);
        return this;
    }

    public final JsonNode m5141b(String str, JsonNode jsonNode) {
        if (jsonNode == null) {
            jsonNode = m5156M();
        }
        return (JsonNode) this.f3119b.put(str, jsonNode);
    }

    public final JsonNode m5143c(String str, JsonNode jsonNode) {
        if (jsonNode == null) {
            jsonNode = m5156M();
        }
        return (JsonNode) this.f3119b.put(str, jsonNode);
    }

    public final JsonNode m5147h(String str) {
        return (JsonNode) this.f3119b.remove(str);
    }

    public final ArrayNode m5148j(String str) {
        ArrayNode K = m5154K();
        this.f3119b.put(str, K);
        return K;
    }

    public final ObjectNode m5151k(String str) {
        ObjectNode L = m5155L();
        this.f3119b.put(str, L);
        return L;
    }

    public final ObjectNode m5152l(String str) {
        this.f3119b.put(str, m5156M());
        return this;
    }

    public final ObjectNode m5136a(String str, Short sh) {
        if (sh == null) {
            this.f3119b.put(str, m5156M());
        } else {
            this.f3119b.put(str, m5160a(sh.shortValue()));
        }
        return this;
    }

    public final ObjectNode m5129a(String str, int i) {
        this.f3119b.put(str, m5165d(i));
        return this;
    }

    public final ObjectNode m5134a(String str, Integer num) {
        if (num == null) {
            this.f3119b.put(str, m5156M());
        } else {
            this.f3119b.put(str, m5165d(num.intValue()));
        }
        return this;
    }

    public final ObjectNode m5130a(String str, long j) {
        this.f3119b.put(str, m5164c(j));
        return this;
    }

    public final ObjectNode m5135a(String str, Long l) {
        if (l == null) {
            this.f3119b.put(str, m5156M());
        } else {
            this.f3119b.put(str, m5164c(l.longValue()));
        }
        return this;
    }

    public final ObjectNode m5128a(String str, float f) {
        this.f3119b.put(str, m5159a(f));
        return this;
    }

    public final ObjectNode m5133a(String str, Float f) {
        if (f == null) {
            this.f3119b.put(str, m5156M());
        } else {
            this.f3119b.put(str, m5159a(f.floatValue()));
        }
        return this;
    }

    public final ObjectNode m5127a(String str, double d) {
        this.f3119b.put(str, m5163b(d));
        return this;
    }

    public final ObjectNode m5132a(String str, Double d) {
        if (d == null) {
            this.f3119b.put(str, m5156M());
        } else {
            this.f3119b.put(str, m5163b(d.doubleValue()));
        }
        return this;
    }

    public final ObjectNode m5137a(String str, String str2) {
        if (str2 == null) {
            m5152l(str);
        } else {
            this.f3119b.put(str, m5167i(str2));
        }
        return this;
    }

    public final ObjectNode m5138a(String str, boolean z) {
        this.f3119b.put(str, m5162b(z));
        return this;
    }

    public final ObjectNode m5131a(String str, Boolean bool) {
        if (bool == null) {
            this.f3119b.put(str, m5156M());
        } else {
            this.f3119b.put(str, m5162b(bool.booleanValue()));
        }
        return this;
    }

    public final ObjectNode m5139a(String str, byte[] bArr) {
        if (bArr == null) {
            this.f3119b.put(str, m5156M());
        } else {
            this.f3119b.put(str, m5158a(bArr));
        }
        return this;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return this.f3119b.equals(((ObjectNode) obj).f3119b);
    }

    public final int hashCode() {
        return this.f3119b.hashCode();
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder((mo712e() << 4) + 32);
        stringBuilder.append("{");
        int i = 0;
        for (Entry entry : this.f3119b.entrySet()) {
            if (i > 0) {
                stringBuilder.append(",");
            }
            int i2 = i + 1;
            TextNode.m5237a(stringBuilder, (String) entry.getKey());
            stringBuilder.append(':');
            stringBuilder.append(((JsonNode) entry.getValue()).toString());
            i = i2;
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}
