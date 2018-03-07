package com.fasterxml.jackson.core;

import com.fasterxml.jackson.core.io.CharacterEscapes;
import java.io.Closeable;
import java.io.Flushable;
import java.math.BigDecimal;
import java.math.BigInteger;

/* compiled from: stories_per_initial_fetch */
public abstract class JsonGenerator implements Versioned, Closeable, Flushable {
    public PrettyPrinter f4184a;

    /* compiled from: stories_per_initial_fetch */
    public enum Feature {
        AUTO_CLOSE_TARGET(true),
        AUTO_CLOSE_JSON_CONTENT(true),
        QUOTE_FIELD_NAMES(true),
        QUOTE_NON_NUMERIC_NUMBERS(true),
        WRITE_NUMBERS_AS_STRINGS(false),
        FLUSH_PASSED_TO_STREAM(true),
        ESCAPE_NON_ASCII(false);
        
        private final boolean _defaultState;
        private final int _mask;

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
            this._mask = 1 << ordinal();
            this._defaultState = z;
        }

        public final boolean enabledByDefault() {
            return this._defaultState;
        }

        public final int getMask() {
            return this._mask;
        }
    }

    public abstract JsonGenerator mo1106a(ObjectCodec objectCodec);

    public abstract ObjectCodec mo1107a();

    public abstract void mo1108a(char c);

    public abstract void mo1109a(double d);

    public abstract void mo1110a(float f);

    public abstract void mo1111a(long j);

    public abstract void mo1112a(Base64Variant base64Variant, byte[] bArr, int i, int i2);

    public abstract void mo1113a(TreeNode treeNode);

    public abstract void mo1114a(Object obj);

    public abstract void mo1115a(String str);

    public abstract void mo1116a(BigDecimal bigDecimal);

    public abstract void mo1117a(BigInteger bigInteger);

    public abstract void mo1119a(boolean z);

    public abstract void mo1120a(char[] cArr, int i, int i2);

    public abstract void mo1121b(int i);

    public abstract void mo1122b(SerializableString serializableString);

    public abstract void mo1123b(String str);

    public abstract void mo1124b(char[] cArr, int i, int i2);

    public abstract JsonGenerator mo1125c();

    public abstract void mo1126c(SerializableString serializableString);

    public abstract void mo1127c(String str);

    public abstract void close();

    public abstract void mo1129d();

    public abstract void mo1131d(String str);

    public abstract void mo1132e();

    public abstract void mo1133e(String str);

    public abstract void mo1134f();

    public abstract void flush();

    public abstract void mo1136g();

    public abstract void mo1137h();

    public final void m7696a(byte[] bArr) {
        mo1112a(Base64Variants.f4073b, bArr, 0, bArr.length);
    }

    protected JsonGenerator() {
    }

    public final void m7681a(FormatSchema formatSchema) {
        throw new UnsupportedOperationException("Generator of type " + getClass().getName() + " does not support schema of type '" + formatSchema.a() + "'");
    }

    public JsonGenerator mo1656a(SerializableString serializableString) {
        throw new UnsupportedOperationException();
    }

    public JsonGenerator m7672a(PrettyPrinter prettyPrinter) {
        this.f4184a = prettyPrinter;
        return this;
    }

    public final PrettyPrinter m7698b() {
        return this.f4184a;
    }

    public JsonGenerator mo1655a(int i) {
        return this;
    }

    public JsonGenerator mo1657a(CharacterEscapes characterEscapes) {
        return this;
    }

    public void mo1130d(SerializableString serializableString) {
        mo1127c(serializableString.mo1050a());
    }

    public void mo1118a(short s) {
        mo1121b((int) s);
    }

    public void mo1658a(String str, String str2) {
        mo1115a(str);
        mo1123b(str2);
    }

    public final void m7691a(String str, boolean z) {
        mo1115a(str);
        mo1119a(z);
    }

    public final void m7687a(String str, int i) {
        mo1115a(str);
        mo1121b(i);
    }

    public final void m7688a(String str, long j) {
        mo1115a(str);
        mo1111a(j);
    }

    public final void m7685a(String str, double d) {
        mo1115a(str);
        mo1109a(d);
    }

    public final void m7686a(String str, float f) {
        mo1115a(str);
        mo1110a(f);
    }

    public final void m7712f(String str) {
        mo1115a(str);
        mo1129d();
    }

    public final void m7714g(String str) {
        mo1115a(str);
        mo1134f();
    }

    public final void m7689a(String str, Object obj) {
        mo1115a(str);
        mo1114a(obj);
    }
}
