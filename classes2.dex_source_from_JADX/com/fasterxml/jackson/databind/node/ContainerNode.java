package com.fasterxml.jackson.databind.node;

import com.fasterxml.jackson.core.TreeNode;
import com.fasterxml.jackson.databind.JsonNode;

/* compiled from: text_only_place */
public abstract class ContainerNode<T extends ContainerNode<T>> extends BaseJsonNode {
    protected final JsonNodeFactory f3120a;

    public abstract JsonNode mo709b(String str);

    public abstract int mo712e();

    public /* synthetic */ TreeNode mo707a(String str) {
        return mo709b(str);
    }

    public final NullNode m5156M() {
        return NullNode.a;
    }

    protected ContainerNode(JsonNodeFactory jsonNodeFactory) {
        this.f3120a = jsonNodeFactory;
    }

    public final String mo719B() {
        return "";
    }

    public final ArrayNode m5154K() {
        return this.f3120a.m5232b();
    }

    public final ObjectNode m5155L() {
        return this.f3120a.m5233c();
    }

    public final BooleanNode m5162b(boolean z) {
        return JsonNodeFactory.m5221a(z);
    }

    public final NumericNode m5160a(short s) {
        return ShortNode.a(s);
    }

    public final NumericNode m5165d(int i) {
        return IntNode.m11286c(i);
    }

    public final NumericNode m5164c(long j) {
        return LongNode.m8911b(j);
    }

    public final NumericNode m5159a(float f) {
        return FloatNode.m24779a(f);
    }

    public final NumericNode m5163b(double d) {
        return DoubleNode.b(d);
    }

    public final TextNode m5167i(String str) {
        return TextNode.m5239h(str);
    }

    public final BinaryNode m5158a(byte[] bArr) {
        return BinaryNode.a(bArr);
    }
}
