package com.fasterxml.jackson.core.base;

import com.facebook.proxygen.HTTPTransportCallback;
import com.fasterxml.jackson.core.Base64Variant;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonParser.Feature;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.core.io.NumberInput;
import com.fasterxml.jackson.core.util.ByteArrayBuilder;
import com.fasterxml.jackson.core.util.VersionUtil;

/* compiled from: pyma_imp */
public abstract class ParserMinimalBase extends JsonParser {
    protected JsonToken f8614K;
    protected JsonToken f8615L;

    /* compiled from: pyma_imp */
    /* synthetic */ class C03951 {
        static final /* synthetic */ int[] f8951a = new int[JsonToken.values().length];

        static {
            try {
                f8951a[JsonToken.START_OBJECT.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f8951a[JsonToken.START_ARRAY.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f8951a[JsonToken.END_OBJECT.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f8951a[JsonToken.END_ARRAY.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f8951a[JsonToken.VALUE_NUMBER_INT.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                f8951a[JsonToken.VALUE_TRUE.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            try {
                f8951a[JsonToken.VALUE_FALSE.ordinal()] = 7;
            } catch (NoSuchFieldError e7) {
            }
            try {
                f8951a[JsonToken.VALUE_NULL.ordinal()] = 8;
            } catch (NoSuchFieldError e8) {
            }
            try {
                f8951a[JsonToken.VALUE_EMBEDDED_OBJECT.ordinal()] = 9;
            } catch (NoSuchFieldError e9) {
            }
            try {
                f8951a[JsonToken.VALUE_STRING.ordinal()] = 10;
            } catch (NoSuchFieldError e10) {
            }
            try {
                f8951a[JsonToken.VALUE_NUMBER_FLOAT.ordinal()] = 11;
            } catch (NoSuchFieldError e11) {
            }
        }
    }

    protected abstract void mo1777P();

    public abstract JsonToken mo1766c();

    public abstract String mo1769o();

    protected ParserMinimalBase() {
    }

    protected ParserMinimalBase(int i) {
        super(i);
    }

    public Version version() {
        return VersionUtil.a(getClass());
    }

    public final JsonToken mo1794g() {
        return this.f8614K;
    }

    public final boolean mo1795h() {
        return this.f8614K != null;
    }

    public final JsonToken mo1792d() {
        JsonToken c = mo1766c();
        if (c == JsonToken.FIELD_NAME) {
            return mo1766c();
        }
        return c;
    }

    public JsonParser mo1793f() {
        if (this.f8614K == JsonToken.START_OBJECT || this.f8614K == JsonToken.START_ARRAY) {
            int i = 1;
            while (true) {
                JsonToken c = mo1766c();
                if (c == null) {
                    mo1777P();
                } else {
                    switch (C03951.f8951a[c.ordinal()]) {
                        case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
                        case HTTPTransportCallback.FIRST_BODY_BYTE_FLUSHED /*2*/:
                            i++;
                            continue;
                        case 3:
                        case HTTPTransportCallback.LAST_BODY_BYTE_FLUSHED /*4*/:
                            i--;
                            if (i == 0) {
                                break;
                            }
                            continue;
                        default:
                            continue;
                    }
                }
            }
        }
        return this;
    }

    public final void mo1796n() {
        if (this.f8614K != null) {
            this.f8615L = this.f8614K;
            this.f8614K = null;
        }
    }

    public final boolean mo1790a(boolean z) {
        if (this.f8614K == null) {
            return z;
        }
        switch (C03951.f8951a[this.f8614K.ordinal()]) {
            case 5:
                return mo1785x() != 0;
            case 6:
                return true;
            case 7:
            case HTTPTransportCallback.LAST_BODY_BYTE_ACKED /*8*/:
                return false;
            case 9:
                Object D = mo1776D();
                if (D instanceof Boolean) {
                    return ((Boolean) D).booleanValue();
                }
                break;
            case 10:
                break;
            default:
                return z;
        }
        if ("true".equals(mo1769o().trim())) {
            return true;
        }
        return z;
    }

    public final int mo1791b(int i) {
        if (this.f8614K == null) {
            return i;
        }
        switch (C03951.f8951a[this.f8614K.ordinal()]) {
            case 5:
            case 11:
                return mo1785x();
            case 6:
                return 1;
            case 7:
            case HTTPTransportCallback.LAST_BODY_BYTE_ACKED /*8*/:
                return 0;
            case 9:
                Object D = mo1776D();
                if (D instanceof Number) {
                    return ((Number) D).intValue();
                }
                return i;
            case 10:
                return NumberInput.m13439a(mo1769o(), i);
            default:
                return i;
        }
    }

    public final long mo1789a(long j) {
        if (this.f8614K == null) {
            return j;
        }
        switch (C03951.f8951a[this.f8614K.ordinal()]) {
            case 5:
            case 11:
                return mo1786y();
            case 6:
                return 1;
            case 7:
            case HTTPTransportCallback.LAST_BODY_BYTE_ACKED /*8*/:
                return 0;
            case 9:
                Object D = mo1776D();
                if (D instanceof Number) {
                    return ((Number) D).longValue();
                }
                return j;
            case 10:
                return NumberInput.m13441a(mo1769o(), j);
            default:
                return j;
        }
    }

    public final double mo1788a(double d) {
        if (this.f8614K == null) {
            return d;
        }
        switch (C03951.f8951a[this.f8614K.ordinal()]) {
            case 5:
            case 11:
                return mo1774B();
            case 6:
                return 1.0d;
            case 7:
            case HTTPTransportCallback.LAST_BODY_BYTE_ACKED /*8*/:
                return 0.0d;
            case 9:
                Object D = mo1776D();
                if (D instanceof Number) {
                    return ((Number) D).doubleValue();
                }
                return d;
            case 10:
                return NumberInput.m13437a(mo1769o(), d);
            default:
                return d;
        }
    }

    public String mo1762a(String str) {
        return (this.f8614K == JsonToken.VALUE_STRING || !(this.f8614K == null || this.f8614K == JsonToken.VALUE_NULL || !this.f8614K.isScalarValue())) ? mo1769o() : str;
    }

    protected final void m13226a(String str, ByteArrayBuilder byteArrayBuilder, Base64Variant base64Variant) {
        try {
            base64Variant.m7141a(str, byteArrayBuilder);
        } catch (IllegalArgumentException e) {
            m13236e(e.getMessage());
        }
    }

    protected final void m13230b(int i, String str) {
        String str2 = "Unexpected character (" + m13218e(i) + ")";
        if (str != null) {
            str2 = str2 + ": " + str;
        }
        m13236e(str2);
    }

    protected final void m13220S() {
        m13235d(" in " + this.f8614K);
    }

    protected final void m13235d(String str) {
        m13236e("Unexpected end-of-input" + str);
    }

    protected final void m13221T() {
        m13235d(" in a value");
    }

    protected final void m13234d(int i) {
        m13236e("Illegal character (" + m13218e((char) i) + "): only regular white space (\\r, \\n, \\t) is allowed between tokens");
    }

    protected final void m13232c(int i, String str) {
        if (!m13262a(Feature.ALLOW_UNQUOTED_CONTROL_CHARS) || i >= 32) {
            m13236e("Illegal unquoted character (" + m13218e((char) i) + "): has to be escaped using backslash to be included in " + str);
        }
    }

    protected final char m13222a(char c) {
        if (!(m13262a(Feature.ALLOW_BACKSLASH_ESCAPING_ANY_CHARACTER) || (c == '\'' && m13262a(Feature.ALLOW_SINGLE_QUOTES)))) {
            m13236e("Unrecognized character escape " + m13218e((int) c));
        }
        return c;
    }

    protected static final String m13218e(int i) {
        char c = (char) i;
        if (Character.isISOControl(c)) {
            return "(CTRL-CHAR, code " + i + ")";
        }
        if (i > 255) {
            return "'" + c + "' (code " + i + " / 0x" + Integer.toHexString(i) + ")";
        }
        return "'" + c + "' (code " + i + ")";
    }

    protected final void m13236e(String str) {
        throw m13266b(str);
    }

    protected final void m13227a(String str, Throwable th) {
        throw m13217b(str, th);
    }

    protected static void m13216U() {
        VersionUtil.b();
    }

    private JsonParseException m13217b(String str, Throwable th) {
        return new JsonParseException(str, mo1781l(), th);
    }
}
