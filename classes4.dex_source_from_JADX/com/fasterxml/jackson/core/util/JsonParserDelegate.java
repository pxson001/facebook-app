package com.fasterxml.jackson.core.util;

import com.fasterxml.jackson.core.Base64Variant;
import com.fasterxml.jackson.core.JsonLocation;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonParser.Feature;
import com.fasterxml.jackson.core.JsonParser.NumberType;
import com.fasterxml.jackson.core.JsonStreamContext;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.core.Version;
import java.math.BigDecimal;
import java.math.BigInteger;

/* compiled from: fbpage_presence */
public class JsonParserDelegate extends JsonParser {
    protected JsonParser f11950b;

    public JsonParserDelegate(JsonParser jsonParser) {
        this.f11950b = jsonParser;
    }

    public final void m12578a(ObjectCodec objectCodec) {
        this.f11950b.a(objectCodec);
    }

    public final ObjectCodec m12576a() {
        return this.f11950b.a();
    }

    public final boolean m12579a(Feature feature) {
        return this.f11950b.a(feature);
    }

    public Version version() {
        return this.f11950b.version();
    }

    public final Object m12583b() {
        return this.f11950b.b();
    }

    public void close() {
        this.f11950b.close();
    }

    public final JsonToken m12587g() {
        return this.f11950b.g();
    }

    public final boolean m12588h() {
        return this.f11950b.h();
    }

    public final String m12589i() {
        return this.f11950b.i();
    }

    public final JsonLocation m12592l() {
        return this.f11950b.l();
    }

    public final JsonStreamContext m12590j() {
        return this.f11950b.j();
    }

    public final void m12593n() {
        this.f11950b.n();
    }

    public final String m12594o() {
        return this.f11950b.o();
    }

    public final boolean m12598s() {
        return this.f11950b.s();
    }

    public final char[] m12595p() {
        return this.f11950b.p();
    }

    public final int m12596q() {
        return this.f11950b.q();
    }

    public final int m12597r() {
        return this.f11950b.r();
    }

    public final BigInteger m12605z() {
        return this.f11950b.z();
    }

    public final byte m12601v() {
        return this.f11950b.v();
    }

    public final short m12602w() {
        return this.f11950b.w();
    }

    public final BigDecimal m12567C() {
        return this.f11950b.C();
    }

    public final double m12566B() {
        return this.f11950b.B();
    }

    public final float m12565A() {
        return this.f11950b.A();
    }

    public final int m12603x() {
        return this.f11950b.x();
    }

    public final long m12604y() {
        return this.f11950b.y();
    }

    public final NumberType m12600u() {
        return this.f11950b.u();
    }

    public final Number m12599t() {
        return this.f11950b.t();
    }

    public final int m12569E() {
        return this.f11950b.E();
    }

    public final int m12582b(int i) {
        return this.f11950b.b(i);
    }

    public final long m12570F() {
        return this.f11950b.F();
    }

    public final long m12575a(long j) {
        return this.f11950b.a(j);
    }

    public final double m12571G() {
        return this.f11950b.G();
    }

    public final double m12574a(double d) {
        return this.f11950b.a(d);
    }

    public final boolean m12572H() {
        return this.f11950b.H();
    }

    public final boolean m12580a(boolean z) {
        return this.f11950b.a(z);
    }

    public final String m12573I() {
        return this.f11950b.I();
    }

    public final String m12577a(String str) {
        return this.f11950b.a(str);
    }

    public final Object m12568D() {
        return this.f11950b.D();
    }

    public final byte[] m12581a(Base64Variant base64Variant) {
        return this.f11950b.a(base64Variant);
    }

    public final JsonLocation m12591k() {
        return this.f11950b.k();
    }

    public JsonToken mo894c() {
        return this.f11950b.c();
    }

    public final JsonToken m12585d() {
        return this.f11950b.d();
    }

    public JsonParser mo895f() {
        this.f11950b.f();
        return this;
    }
}
