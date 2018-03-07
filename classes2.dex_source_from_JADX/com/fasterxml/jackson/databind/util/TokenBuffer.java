package com.fasterxml.jackson.databind.util;

import com.facebook.proxygen.HTTPTransportCallback;
import com.fasterxml.jackson.core.Base64Variant;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonParser.Feature;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.core.SerializableString;
import com.fasterxml.jackson.core.TreeNode;
import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.core.json.JsonWriteContext;
import com.fasterxml.jackson.databind.cfg.PackageVersion;
import java.math.BigDecimal;
import java.math.BigInteger;

/* compiled from: stack_name */
public class TokenBuffer extends JsonGenerator {
    protected static final int f4176b = Feature.collectDefaults();
    protected ObjectCodec f4177c;
    protected int f4178d = f4176b;
    protected boolean f4179e;
    protected Segment f4180f;
    protected Segment f4181g;
    protected int f4182h;
    protected JsonWriteContext f4183i = JsonWriteContext.m11949i();

    public TokenBuffer(ObjectCodec objectCodec) {
        this.f4177c = objectCodec;
        Segment segment = new Segment();
        this.f4181g = segment;
        this.f4180f = segment;
        this.f4182h = 0;
    }

    public Version version() {
        return PackageVersion.VERSION;
    }

    public final JsonParser m7668i() {
        return m7631b(this.f4177c);
    }

    private JsonParser m7631b(ObjectCodec objectCodec) {
        return new Parser(this.f4180f, objectCodec);
    }

    public final JsonParser m7635a(JsonParser jsonParser) {
        Parser parser = new Parser(this.f4180f, jsonParser.mo1761a());
        parser.h = jsonParser.mo1780k();
        return parser;
    }

    public final JsonToken m7669j() {
        if (this.f4180f != null) {
            return this.f4180f.a(0);
        }
        return null;
    }

    public final TokenBuffer m7637a(TokenBuffer tokenBuffer) {
        JsonParser i = tokenBuffer.m7668i();
        while (i.mo1766c() != null) {
            m7632c(i);
        }
        return this;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void m7643a(com.fasterxml.jackson.core.JsonGenerator r8) {
        /*
        r7 = this;
        r2 = 0;
        r3 = r7.f4180f;
        r1 = -1;
        r0 = r1;
        r1 = r3;
    L_0x0006:
        r0 = r0 + 1;
        r3 = 16;
        if (r0 < r3) goto L_0x013a;
    L_0x000c:
        r6 = r1.a;
        r0 = r6;
        if (r0 == 0) goto L_0x0139;
    L_0x0011:
        r1 = r2;
        r3 = r0;
    L_0x0013:
        r0 = r3.a(r1);
        if (r0 == 0) goto L_0x0139;
    L_0x0019:
        r4 = com.fasterxml.jackson.databind.util.TokenBuffer.1.a;
        r0 = r0.ordinal();
        r0 = r4[r0];
        switch(r0) {
            case 1: goto L_0x002c;
            case 2: goto L_0x0032;
            case 3: goto L_0x0038;
            case 4: goto L_0x003e;
            case 5: goto L_0x0044;
            case 6: goto L_0x005c;
            case 7: goto L_0x0072;
            case 8: goto L_0x00b7;
            case 9: goto L_0x0118;
            case 10: goto L_0x0120;
            case 11: goto L_0x0127;
            case 12: goto L_0x012e;
            default: goto L_0x0024;
        };
    L_0x0024:
        r0 = new java.lang.RuntimeException;
        r1 = "Internal error: should never end up through this code path";
        r0.<init>(r1);
        throw r0;
    L_0x002c:
        r8.mo1134f();
        r0 = r1;
        r1 = r3;
        goto L_0x0006;
    L_0x0032:
        r8.mo1136g();
        r0 = r1;
        r1 = r3;
        goto L_0x0006;
    L_0x0038:
        r8.mo1129d();
        r0 = r1;
        r1 = r3;
        goto L_0x0006;
    L_0x003e:
        r8.mo1132e();
        r0 = r1;
        r1 = r3;
        goto L_0x0006;
    L_0x0044:
        r0 = r3.b(r1);
        r4 = r0 instanceof com.fasterxml.jackson.core.SerializableString;
        if (r4 == 0) goto L_0x0054;
    L_0x004c:
        r0 = (com.fasterxml.jackson.core.SerializableString) r0;
        r8.mo1122b(r0);
    L_0x0051:
        r0 = r1;
        r1 = r3;
        goto L_0x0006;
    L_0x0054:
        r0 = (java.lang.String) r0;
        r8.mo1115a(r0);
        r0 = r1;
        r1 = r3;
        goto L_0x0006;
    L_0x005c:
        r0 = r3.b(r1);
        r4 = r0 instanceof com.fasterxml.jackson.core.SerializableString;
        if (r4 == 0) goto L_0x006a;
    L_0x0064:
        r0 = (com.fasterxml.jackson.core.SerializableString) r0;
        r8.mo1126c(r0);
        goto L_0x0051;
    L_0x006a:
        r0 = (java.lang.String) r0;
        r8.mo1123b(r0);
        r0 = r1;
        r1 = r3;
        goto L_0x0006;
    L_0x0072:
        r0 = r3.b(r1);
        r4 = r0 instanceof java.lang.Integer;
        if (r4 == 0) goto L_0x0084;
    L_0x007a:
        r0 = (java.lang.Integer) r0;
        r0 = r0.intValue();
        r8.mo1121b(r0);
        goto L_0x0051;
    L_0x0084:
        r4 = r0 instanceof java.math.BigInteger;
        if (r4 == 0) goto L_0x008e;
    L_0x0088:
        r0 = (java.math.BigInteger) r0;
        r8.mo1117a(r0);
        goto L_0x0051;
    L_0x008e:
        r4 = r0 instanceof java.lang.Long;
        if (r4 == 0) goto L_0x009c;
    L_0x0092:
        r0 = (java.lang.Long) r0;
        r4 = r0.longValue();
        r8.mo1111a(r4);
        goto L_0x0051;
    L_0x009c:
        r4 = r0 instanceof java.lang.Short;
        if (r4 == 0) goto L_0x00aa;
    L_0x00a0:
        r0 = (java.lang.Short) r0;
        r0 = r0.shortValue();
        r8.mo1118a(r0);
        goto L_0x0051;
    L_0x00aa:
        r0 = (java.lang.Number) r0;
        r0 = r0.intValue();
        r8.mo1121b(r0);
        r0 = r1;
        r1 = r3;
        goto L_0x0006;
    L_0x00b7:
        r0 = r3.b(r1);
        r4 = r0 instanceof java.lang.Double;
        if (r4 == 0) goto L_0x00c9;
    L_0x00bf:
        r0 = (java.lang.Double) r0;
        r4 = r0.doubleValue();
        r8.mo1109a(r4);
        goto L_0x0051;
    L_0x00c9:
        r4 = r0 instanceof java.math.BigDecimal;
        if (r4 == 0) goto L_0x00d4;
    L_0x00cd:
        r0 = (java.math.BigDecimal) r0;
        r8.mo1116a(r0);
        goto L_0x0051;
    L_0x00d4:
        r4 = r0 instanceof java.lang.Float;
        if (r4 == 0) goto L_0x00e3;
    L_0x00d8:
        r0 = (java.lang.Float) r0;
        r0 = r0.floatValue();
        r8.mo1110a(r0);
        goto L_0x0051;
    L_0x00e3:
        if (r0 != 0) goto L_0x00ea;
    L_0x00e5:
        r8.mo1137h();
        goto L_0x0051;
    L_0x00ea:
        r4 = r0 instanceof java.lang.String;
        if (r4 == 0) goto L_0x00f5;
    L_0x00ee:
        r0 = (java.lang.String) r0;
        r8.mo1133e(r0);
        goto L_0x0051;
    L_0x00f5:
        r1 = new com.fasterxml.jackson.core.JsonGenerationException;
        r2 = new java.lang.StringBuilder;
        r3 = "Unrecognized value type for VALUE_NUMBER_FLOAT: ";
        r2.<init>(r3);
        r0 = r0.getClass();
        r0 = r0.getName();
        r0 = r2.append(r0);
        r2 = ", can not serialize";
        r0 = r0.append(r2);
        r0 = r0.toString();
        r1.<init>(r0);
        throw r1;
    L_0x0118:
        r0 = 1;
        r8.mo1119a(r0);
        r0 = r1;
        r1 = r3;
        goto L_0x0006;
    L_0x0120:
        r8.mo1119a(r2);
        r0 = r1;
        r1 = r3;
        goto L_0x0006;
    L_0x0127:
        r8.mo1137h();
        r0 = r1;
        r1 = r3;
        goto L_0x0006;
    L_0x012e:
        r0 = r3.b(r1);
        r8.mo1114a(r0);
        r0 = r1;
        r1 = r3;
        goto L_0x0006;
    L_0x0139:
        return;
    L_0x013a:
        r3 = r1;
        r1 = r0;
        goto L_0x0013;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.databind.util.TokenBuffer.a(com.fasterxml.jackson.core.JsonGenerator):void");
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[TokenBuffer: ");
        JsonParser i = m7668i();
        int i2 = 0;
        while (true) {
            try {
                JsonToken c = i.mo1766c();
                if (c == null) {
                    break;
                }
                if (i2 < 100) {
                    if (i2 > 0) {
                        stringBuilder.append(", ");
                    }
                    stringBuilder.append(c.toString());
                    if (c == JsonToken.FIELD_NAME) {
                        stringBuilder.append('(');
                        stringBuilder.append(i.mo1778i());
                        stringBuilder.append(')');
                    }
                }
                i2++;
            } catch (Throwable e) {
                throw new IllegalStateException(e);
            }
        }
        if (i2 >= 100) {
            stringBuilder.append(" ... (truncated ").append(i2 - 100).append(" entries)");
        }
        stringBuilder.append(']');
        return stringBuilder.toString();
    }

    public final JsonGenerator mo1125c() {
        return this;
    }

    public final JsonGenerator mo1106a(ObjectCodec objectCodec) {
        this.f4177c = objectCodec;
        return this;
    }

    public final ObjectCodec mo1107a() {
        return this.f4177c;
    }

    public void flush() {
    }

    public void close() {
        this.f4179e = true;
    }

    public final void mo1129d() {
        m7629a(JsonToken.START_ARRAY);
        this.f4183i = this.f4183i.m11953j();
    }

    public final void mo1132e() {
        m7629a(JsonToken.END_ARRAY);
        JsonWriteContext jsonWriteContext = this.f4183i.f7351c;
        if (jsonWriteContext != null) {
            this.f4183i = jsonWriteContext;
        }
    }

    public final void mo1134f() {
        m7629a(JsonToken.START_OBJECT);
        this.f4183i = this.f4183i.m11954k();
    }

    public final void mo1136g() {
        m7629a(JsonToken.END_OBJECT);
        JsonWriteContext jsonWriteContext = this.f4183i.f7351c;
        if (jsonWriteContext != null) {
            this.f4183i = jsonWriteContext;
        }
    }

    public final void mo1115a(String str) {
        m7630a(JsonToken.FIELD_NAME, str);
        this.f4183i.m11950a(str);
    }

    public final void mo1122b(SerializableString serializableString) {
        m7630a(JsonToken.FIELD_NAME, serializableString);
        this.f4183i.m11950a(serializableString.mo1050a());
    }

    public final void mo1123b(String str) {
        if (str == null) {
            mo1137h();
        } else {
            m7630a(JsonToken.VALUE_STRING, str);
        }
    }

    public final void mo1120a(char[] cArr, int i, int i2) {
        mo1123b(new String(cArr, i, i2));
    }

    public final void mo1126c(SerializableString serializableString) {
        if (serializableString == null) {
            mo1137h();
        } else {
            m7630a(JsonToken.VALUE_STRING, serializableString);
        }
    }

    public final void mo1127c(String str) {
        m7633k();
    }

    public final void mo1130d(SerializableString serializableString) {
        m7633k();
    }

    public final void mo1124b(char[] cArr, int i, int i2) {
        m7633k();
    }

    public final void mo1108a(char c) {
        m7633k();
    }

    public final void mo1131d(String str) {
        m7633k();
    }

    public final void mo1118a(short s) {
        m7630a(JsonToken.VALUE_NUMBER_INT, Short.valueOf(s));
    }

    public final void mo1121b(int i) {
        m7630a(JsonToken.VALUE_NUMBER_INT, Integer.valueOf(i));
    }

    public final void mo1111a(long j) {
        m7630a(JsonToken.VALUE_NUMBER_INT, Long.valueOf(j));
    }

    public final void mo1109a(double d) {
        m7630a(JsonToken.VALUE_NUMBER_FLOAT, Double.valueOf(d));
    }

    public final void mo1110a(float f) {
        m7630a(JsonToken.VALUE_NUMBER_FLOAT, Float.valueOf(f));
    }

    public final void mo1116a(BigDecimal bigDecimal) {
        if (bigDecimal == null) {
            mo1137h();
        } else {
            m7630a(JsonToken.VALUE_NUMBER_FLOAT, bigDecimal);
        }
    }

    public final void mo1117a(BigInteger bigInteger) {
        if (bigInteger == null) {
            mo1137h();
        } else {
            m7630a(JsonToken.VALUE_NUMBER_INT, bigInteger);
        }
    }

    public final void mo1133e(String str) {
        m7630a(JsonToken.VALUE_NUMBER_FLOAT, str);
    }

    public final void mo1119a(boolean z) {
        m7629a(z ? JsonToken.VALUE_TRUE : JsonToken.VALUE_FALSE);
    }

    public final void mo1137h() {
        m7629a(JsonToken.VALUE_NULL);
    }

    public final void mo1114a(Object obj) {
        m7630a(JsonToken.VALUE_EMBEDDED_OBJECT, obj);
    }

    public final void mo1113a(TreeNode treeNode) {
        m7630a(JsonToken.VALUE_EMBEDDED_OBJECT, treeNode);
    }

    public final void mo1112a(Base64Variant base64Variant, byte[] bArr, int i, int i2) {
        Object obj = new byte[i2];
        System.arraycopy(bArr, i, obj, 0, i2);
        mo1114a(obj);
    }

    private void m7632c(JsonParser jsonParser) {
        switch (1.a[jsonParser.mo1794g().ordinal()]) {
            case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
                mo1134f();
                return;
            case HTTPTransportCallback.FIRST_BODY_BYTE_FLUSHED /*2*/:
                mo1136g();
                return;
            case 3:
                mo1129d();
                return;
            case HTTPTransportCallback.LAST_BODY_BYTE_FLUSHED /*4*/:
                mo1132e();
                return;
            case 5:
                mo1115a(jsonParser.mo1778i());
                return;
            case 6:
                if (jsonParser.mo1782s()) {
                    mo1120a(jsonParser.mo1770p(), jsonParser.mo1772r(), jsonParser.mo1771q());
                    return;
                } else {
                    mo1123b(jsonParser.mo1769o());
                    return;
                }
            case 7:
                switch (1.b[jsonParser.mo1784u().ordinal()]) {
                    case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
                        mo1121b(jsonParser.mo1785x());
                        return;
                    case HTTPTransportCallback.FIRST_BODY_BYTE_FLUSHED /*2*/:
                        mo1117a(jsonParser.mo1787z());
                        return;
                    default:
                        mo1111a(jsonParser.mo1786y());
                        return;
                }
            case HTTPTransportCallback.LAST_BODY_BYTE_ACKED /*8*/:
                switch (1.b[jsonParser.mo1784u().ordinal()]) {
                    case 3:
                        mo1116a(jsonParser.mo1775C());
                        return;
                    case HTTPTransportCallback.LAST_BODY_BYTE_FLUSHED /*4*/:
                        mo1110a(jsonParser.mo1773A());
                        return;
                    default:
                        mo1109a(jsonParser.mo1774B());
                        return;
                }
            case 9:
                mo1119a(true);
                return;
            case 10:
                mo1119a(false);
                return;
            case 11:
                mo1137h();
                return;
            case 12:
                mo1114a(jsonParser.mo1776D());
                return;
            default:
                throw new RuntimeException("Internal error: should never end up through this code path");
        }
    }

    public final void m7653b(JsonParser jsonParser) {
        JsonToken g = jsonParser.mo1794g();
        if (g == JsonToken.FIELD_NAME) {
            mo1115a(jsonParser.mo1778i());
            g = jsonParser.mo1766c();
        }
        switch (1.a[g.ordinal()]) {
            case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
                mo1134f();
                while (jsonParser.mo1766c() != JsonToken.END_OBJECT) {
                    m7653b(jsonParser);
                }
                mo1136g();
                return;
            case 3:
                mo1129d();
                while (jsonParser.mo1766c() != JsonToken.END_ARRAY) {
                    m7653b(jsonParser);
                }
                mo1132e();
                return;
            default:
                m7632c(jsonParser);
                return;
        }
    }

    private void m7629a(JsonToken jsonToken) {
        Segment a = this.f4181g.a(this.f4182h, jsonToken);
        if (a == null) {
            this.f4182h++;
            return;
        }
        this.f4181g = a;
        this.f4182h = 1;
    }

    private void m7630a(JsonToken jsonToken, Object obj) {
        Segment a = this.f4181g.a(this.f4182h, jsonToken, obj);
        if (a == null) {
            this.f4182h++;
            return;
        }
        this.f4181g = a;
        this.f4182h = 1;
    }

    private static void m7633k() {
        throw new UnsupportedOperationException("Called operation not supported for TokenBuffer");
    }
}
