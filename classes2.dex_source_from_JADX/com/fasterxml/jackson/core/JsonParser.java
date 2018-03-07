package com.fasterxml.jackson.core;

import com.fasterxml.jackson.core.type.TypeReference;
import java.io.Closeable;
import java.io.OutputStream;
import java.io.Writer;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Iterator;

/* compiled from: stories_per_tail_fetch */
public abstract class JsonParser implements Versioned, Closeable {
    protected int f8616a;

    /* compiled from: stories_per_tail_fetch */
    public enum Feature {
        AUTO_CLOSE_SOURCE(true),
        ALLOW_COMMENTS(false),
        ALLOW_UNQUOTED_FIELD_NAMES(false),
        ALLOW_SINGLE_QUOTES(false),
        ALLOW_UNQUOTED_CONTROL_CHARS(false),
        ALLOW_BACKSLASH_ESCAPING_ANY_CHARACTER(false),
        ALLOW_NUMERIC_LEADING_ZEROS(false),
        ALLOW_NON_NUMERIC_NUMBERS(false);
        
        private final boolean _defaultState;

        public static int collectDefaults() {
            int i = 0;
            for (Feature feature : values()) {
                if (feature.enabledByDefault()) {
                    i |= feature.getMask();
                }
            }
            return i;
        }

        private Feature(boolean z) {
            this._defaultState = z;
        }

        public final boolean enabledByDefault() {
            return this._defaultState;
        }

        public final int getMask() {
            return 1 << ordinal();
        }
    }

    /* compiled from: stories_per_tail_fetch */
    public enum NumberType {
        INT,
        LONG,
        BIG_INTEGER,
        FLOAT,
        DOUBLE,
        BIG_DECIMAL
    }

    public abstract float mo1773A();

    public abstract double mo1774B();

    public abstract BigDecimal mo1775C();

    public abstract Object mo1776D();

    public abstract ObjectCodec mo1761a();

    public abstract String mo1762a(String str);

    public abstract void mo1763a(ObjectCodec objectCodec);

    public abstract byte[] mo1764a(Base64Variant base64Variant);

    public abstract JsonToken mo1766c();

    public abstract void close();

    public abstract JsonToken mo1792d();

    public abstract JsonParser mo1793f();

    public abstract JsonToken mo1794g();

    public abstract boolean mo1795h();

    public abstract String mo1778i();

    public abstract JsonStreamContext mo1779j();

    public abstract JsonLocation mo1780k();

    public abstract JsonLocation mo1781l();

    public abstract void mo1796n();

    public abstract String mo1769o();

    public abstract char[] mo1770p();

    public abstract int mo1771q();

    public abstract int mo1772r();

    public abstract boolean mo1782s();

    public abstract Number mo1783t();

    public abstract NumberType mo1784u();

    public abstract Version version();

    public abstract int mo1785x();

    public abstract long mo1786y();

    public abstract BigInteger mo1787z();

    protected JsonParser() {
    }

    protected JsonParser(int i) {
        this.f8616a = i;
    }

    public Object mo1765b() {
        return null;
    }

    public int mo3207a(OutputStream outputStream) {
        return -1;
    }

    public int mo1760a(Writer writer) {
        return -1;
    }

    public boolean m13262a(Feature feature) {
        return (this.f8616a & feature.getMask()) != 0;
    }

    public String mo1768e() {
        return mo1766c() == JsonToken.VALUE_STRING ? mo1769o() : null;
    }

    public int mo1759a(int i) {
        return mo1766c() == JsonToken.VALUE_NUMBER_INT ? mo1785x() : i;
    }

    public final boolean m13279m() {
        return mo1794g() == JsonToken.START_ARRAY;
    }

    public byte m13288v() {
        int x = mo1785x();
        if (x >= -128 && x <= 255) {
            return (byte) x;
        }
        throw m13266b("Numeric value (" + mo1769o() + ") out of range of Java byte");
    }

    public short m13289w() {
        int x = mo1785x();
        if (x >= -32768 && x <= 32767) {
            return (short) x;
        }
        throw m13266b("Numeric value (" + mo1769o() + ") out of range of Java short");
    }

    public int m13246E() {
        return mo1791b(0);
    }

    public int mo1791b(int i) {
        return i;
    }

    public long m13247F() {
        return mo1789a(0);
    }

    public long mo1789a(long j) {
        return j;
    }

    public double m13248G() {
        return mo1788a(0.0d);
    }

    public double mo1788a(double d) {
        return d;
    }

    public boolean m13249H() {
        return mo1790a(false);
    }

    public boolean mo1790a(boolean z) {
        return z;
    }

    public String mo1753I() {
        return mo1762a(null);
    }

    public <T> T m13259a(Class<T> cls) {
        ObjectCodec a = mo1761a();
        if (a != null) {
            return a.mo908a(this, (Class) cls);
        }
        throw new IllegalStateException("No ObjectCodec defined for the parser, can not deserialize JSON into Java objects");
    }

    public <T> T m13258a(TypeReference<?> typeReference) {
        ObjectCodec a = mo1761a();
        if (a != null) {
            return a.mo907a(this, (TypeReference) typeReference);
        }
        throw new IllegalStateException("No ObjectCodec defined for the parser, can not deserialize JSON into Java objects");
    }

    public <T> Iterator<T> m13268b(Class<T> cls) {
        ObjectCodec a = mo1761a();
        if (a != null) {
            return a.mo911b(this, cls);
        }
        throw new IllegalStateException("No ObjectCodec defined for the parser, can not deserialize JSON into Java objects");
    }

    public <T extends TreeNode> T m13251J() {
        ObjectCodec a = mo1761a();
        if (a != null) {
            return a.mo906a(this);
        }
        throw new IllegalStateException("No ObjectCodec defined for the parser, can not deserialize JSON into JsonNode tree");
    }

    protected final JsonParseException m13266b(String str) {
        return new JsonParseException(str, mo1781l());
    }
}
