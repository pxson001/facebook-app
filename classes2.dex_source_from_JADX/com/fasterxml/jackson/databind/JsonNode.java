package com.fasterxml.jackson.databind;

import com.facebook.proxygen.HTTPTransportCallback;
import com.fasterxml.jackson.core.TreeNode;
import com.fasterxml.jackson.databind.node.JsonNodeType;
import com.fasterxml.jackson.databind.util.EmptyIterator;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Iterator;
import java.util.Map.Entry;

/* compiled from: textColor */
public abstract class JsonNode implements TreeNode, Iterable<JsonNode> {
    public abstract String mo719B();

    public abstract JsonNode mo708a(int i);

    public abstract JsonNode mo710c(String str);

    public abstract <T extends JsonNode> T mo711d();

    public abstract JsonNode mo713f(String str);

    public abstract JsonNode mo723g(String str);

    public abstract JsonNodeType mo715k();

    public abstract String toString();

    public Iterator<JsonNode> mo704G() {
        return EmptyIterator.a;
    }

    public Iterator<Entry<String, JsonNode>> mo705H() {
        return EmptyIterator.a;
    }

    public Iterator<String> mo714j() {
        return EmptyIterator.a;
    }

    public /* synthetic */ TreeNode mo707a(String str) {
        return mo709b(str);
    }

    protected JsonNode() {
    }

    public int mo712e() {
        return 0;
    }

    public final boolean m5193f() {
        switch (1.a[mo715k().ordinal()]) {
            case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
            case HTTPTransportCallback.FIRST_BODY_BYTE_FLUSHED /*2*/:
            case 3:
                return false;
            default:
                return true;
        }
    }

    public final boolean m5195g() {
        return mo715k() == JsonNodeType.MISSING;
    }

    public final boolean m5196h() {
        return mo715k() == JsonNodeType.ARRAY;
    }

    public final boolean m5197i() {
        return mo715k() == JsonNodeType.OBJECT;
    }

    public JsonNode mo709b(String str) {
        return null;
    }

    public final boolean m5200l() {
        return mo715k() == JsonNodeType.POJO;
    }

    public final boolean m5201m() {
        return mo715k() == JsonNodeType.NUMBER;
    }

    public boolean mo1604n() {
        return false;
    }

    public final boolean m5203o() {
        return mo715k() == JsonNodeType.STRING;
    }

    public final boolean m5204p() {
        return mo715k() == JsonNodeType.BOOLEAN;
    }

    public final boolean m5205q() {
        return mo715k() == JsonNodeType.NULL;
    }

    public final boolean m5206r() {
        return mo715k() == JsonNodeType.BINARY;
    }

    public String mo728s() {
        return null;
    }

    public byte[] mo729t() {
        return null;
    }

    public boolean mo1647u() {
        return false;
    }

    public Number mo1282v() {
        return null;
    }

    public int mo1283w() {
        return 0;
    }

    public long mo1284x() {
        return 0;
    }

    public double mo1285y() {
        return 0.0d;
    }

    public BigDecimal mo1286z() {
        return BigDecimal.ZERO;
    }

    public BigInteger mo1281A() {
        return BigInteger.ZERO;
    }

    public int mo1287C() {
        return mo727b(0);
    }

    public int mo727b(int i) {
        return i;
    }

    public long mo1288D() {
        return mo725a(0);
    }

    public long mo725a(long j) {
        return j;
    }

    public double mo1289E() {
        return mo724a(0.0d);
    }

    public double mo724a(double d) {
        return d;
    }

    public boolean mo1646F() {
        return mo726a(false);
    }

    public boolean mo726a(boolean z) {
        return z;
    }

    public boolean mo730d(String str) {
        return mo709b(str) != null;
    }

    public boolean mo731e(String str) {
        JsonNode b = mo709b(str);
        return (b == null || b.m5205q()) ? false : true;
    }

    public final Iterator<JsonNode> iterator() {
        return mo704G();
    }
}
