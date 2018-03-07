package com.fasterxml.jackson.databind.node;

import com.fasterxml.jackson.core.Base64Variant;
import com.fasterxml.jackson.core.Base64Variants;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonLocation;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.core.io.CharTypes;
import com.fasterxml.jackson.core.io.NumberInput;
import com.fasterxml.jackson.core.util.ByteArrayBuilder;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: template */
public final class TextNode extends ValueNode {
    static final TextNode f3124a = new TextNode("");
    final String f3125b;

    public TextNode(String str) {
        this.f3125b = str;
    }

    public static TextNode m5239h(String str) {
        if (str == null) {
            return null;
        }
        if (str.length() == 0) {
            return f3124a;
        }
        return new TextNode(str);
    }

    public final JsonNodeType mo715k() {
        return JsonNodeType.STRING;
    }

    public final JsonToken mo706a() {
        return JsonToken.VALUE_STRING;
    }

    public final String mo728s() {
        return this.f3125b;
    }

    private byte[] m5238a(Base64Variant base64Variant) {
        ByteArrayBuilder byteArrayBuilder = new ByteArrayBuilder(100);
        String str = this.f3125b;
        int length = str.length();
        int i = 0;
        loop0:
        while (i < length) {
            int i2;
            char charAt;
            while (true) {
                i2 = i + 1;
                charAt = str.charAt(i);
                if (i2 >= length) {
                    break loop0;
                } else if (charAt > ' ') {
                    break;
                } else {
                    i = i2;
                }
            }
            int b = base64Variant.m7146b(charAt);
            if (b < 0) {
                m5235a(base64Variant, charAt, 0);
            }
            if (i2 >= length) {
                m5234I();
            }
            i = i2 + 1;
            char charAt2 = str.charAt(i2);
            int b2 = base64Variant.m7146b(charAt2);
            if (b2 < 0) {
                m5235a(base64Variant, charAt2, 1);
            }
            i2 = (b << 6) | b2;
            if (i >= length) {
                if (!base64Variant.f4076a) {
                    byteArrayBuilder.a(i2 >> 4);
                    break;
                }
                m5234I();
            }
            b = i + 1;
            charAt = str.charAt(i);
            b2 = base64Variant.m7146b(charAt);
            char charAt3;
            if (b2 < 0) {
                if (b2 != -2) {
                    m5235a(base64Variant, charAt, 2);
                }
                if (b >= length) {
                    m5234I();
                }
                i = b + 1;
                charAt3 = str.charAt(b);
                if (!base64Variant.m7143a(charAt3)) {
                    m5236a(base64Variant, charAt3, 3, "expected padding character '" + base64Variant.f4077b + "'");
                }
                byteArrayBuilder.a(i2 >> 4);
            } else {
                i2 = (i2 << 6) | b2;
                if (b >= length) {
                    if (!base64Variant.f4076a) {
                        byteArrayBuilder.b(i2 >> 2);
                        break;
                    }
                    m5234I();
                }
                i = b + 1;
                charAt3 = str.charAt(b);
                b2 = base64Variant.m7146b(charAt3);
                if (b2 < 0) {
                    if (b2 != -2) {
                        m5235a(base64Variant, charAt3, 3);
                    }
                    byteArrayBuilder.b(i2 >> 2);
                } else {
                    byteArrayBuilder.c((i2 << 6) | b2);
                }
            }
        }
        return byteArrayBuilder.c();
    }

    public final byte[] mo729t() {
        return m5238a(Base64Variants.f4073b);
    }

    public final String mo719B() {
        return this.f3125b;
    }

    public final boolean mo726a(boolean z) {
        if (this.f3125b == null || !"true".equals(this.f3125b.trim())) {
            return z;
        }
        return true;
    }

    public final int mo727b(int i) {
        return NumberInput.m13439a(this.f3125b, i);
    }

    public final long mo725a(long j) {
        return NumberInput.m13441a(this.f3125b, j);
    }

    public final double mo724a(double d) {
        return NumberInput.m13437a(this.f3125b, d);
    }

    public final void serialize(JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        if (this.f3125b == null) {
            jsonGenerator.mo1137h();
        } else {
            jsonGenerator.mo1123b(this.f3125b);
        }
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != getClass()) {
            return false;
        }
        return ((TextNode) obj).f3125b.equals(this.f3125b);
    }

    public final int hashCode() {
        return this.f3125b.hashCode();
    }

    public final String toString() {
        int length = this.f3125b.length();
        StringBuilder stringBuilder = new StringBuilder((length >> 4) + (length + 2));
        m5237a(stringBuilder, this.f3125b);
        return stringBuilder.toString();
    }

    protected static void m5237a(StringBuilder stringBuilder, String str) {
        stringBuilder.append('\"');
        CharTypes.m11932a(stringBuilder, str);
        stringBuilder.append('\"');
    }

    private void m5235a(Base64Variant base64Variant, char c, int i) {
        m5236a(base64Variant, c, i, null);
    }

    private static void m5236a(Base64Variant base64Variant, char c, int i, String str) {
        String str2;
        if (c <= ' ') {
            str2 = "Illegal white space character (code 0x" + Integer.toHexString(c) + ") as character #" + (i + 1) + " of 4-char base64 unit: can only used between units";
        } else if (base64Variant.m7143a(c)) {
            str2 = "Unexpected padding character ('" + base64Variant.f4077b + "') as character #" + (i + 1) + " of 4-char base64 unit: padding only legal as 3rd or 4th character";
        } else if (!Character.isDefined(c) || Character.isISOControl(c)) {
            str2 = "Illegal character (code 0x" + Integer.toHexString(c) + ") in base64 content";
        } else {
            str2 = "Illegal character '" + c + "' (code 0x" + Integer.toHexString(c) + ") in base64 content";
        }
        if (str != null) {
            str2 = str2 + ": " + str;
        }
        throw new JsonParseException(str2, JsonLocation.a);
    }

    private static void m5234I() {
        throw new JsonParseException("Unexpected end-of-String when base64 content", JsonLocation.a);
    }
}
