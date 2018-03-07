package com.fasterxml.jackson.databind.node;

import com.fasterxml.jackson.core.Base64Variant;
import com.fasterxml.jackson.core.JsonLocation;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonParser.NumberType;
import com.fasterxml.jackson.core.JsonStreamContext;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.core.base.ParserMinimalBase;
import com.fasterxml.jackson.core.util.VersionUtil;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.cfg.PackageVersion;
import com.fasterxml.jackson.databind.node.NodeCursor.Array;
import com.fasterxml.jackson.databind.node.NodeCursor.Object;
import com.fasterxml.jackson.databind.node.NodeCursor.RootValue;
import java.math.BigDecimal;
import java.math.BigInteger;

/* compiled from: single_publisher_video_channels */
public class TreeTraversingParser extends ParserMinimalBase {
    protected ObjectCodec f2142b;
    protected NodeCursor f2143c;
    protected JsonToken f2144d;
    protected boolean f2145e;
    protected boolean f2146f;

    /* compiled from: single_publisher_video_channels */
    /* synthetic */ class C01131 {
        static final /* synthetic */ int[] f2153a = new int[JsonToken.values().length];

        static {
            try {
                f2153a[JsonToken.FIELD_NAME.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f2153a[JsonToken.VALUE_STRING.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f2153a[JsonToken.VALUE_NUMBER_INT.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f2153a[JsonToken.VALUE_NUMBER_FLOAT.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f2153a[JsonToken.VALUE_EMBEDDED_OBJECT.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
        }
    }

    public TreeTraversingParser(JsonNode jsonNode) {
        this(jsonNode, null);
    }

    public TreeTraversingParser(JsonNode jsonNode, ObjectCodec objectCodec) {
        super(0);
        this.f2142b = objectCodec;
        if (jsonNode.h()) {
            this.f2144d = JsonToken.START_ARRAY;
            this.f2143c = new Array(jsonNode, null);
        } else if (jsonNode.i()) {
            this.f2144d = JsonToken.START_OBJECT;
            this.f2143c = new Object(jsonNode, null);
        } else {
            this.f2143c = new RootValue(jsonNode, null);
        }
    }

    public final void m2270a(ObjectCodec objectCodec) {
        this.f2142b = objectCodec;
    }

    public final ObjectCodec m2269a() {
        return this.f2142b;
    }

    public Version version() {
        return PackageVersion.VERSION;
    }

    public void close() {
        if (!this.f2146f) {
            this.f2146f = true;
            this.f2143c = null;
            this.K = null;
        }
    }

    public final JsonToken m2272c() {
        if (this.f2144d != null) {
            this.K = this.f2144d;
            this.f2144d = null;
            return this.K;
        } else if (this.f2145e) {
            this.f2145e = false;
            if (this.f2143c.mo154m()) {
                this.f2143c = this.f2143c.m2300n();
                this.K = this.f2143c.mo151j();
                if (this.K == JsonToken.START_OBJECT || this.K == JsonToken.START_ARRAY) {
                    this.f2145e = true;
                }
                return this.K;
            }
            this.K = this.K == JsonToken.START_OBJECT ? JsonToken.END_OBJECT : JsonToken.END_ARRAY;
            return this.K;
        } else if (this.f2143c == null) {
            this.f2146f = true;
            return null;
        } else {
            this.K = this.f2143c.mo151j();
            if (this.K != null) {
                if (this.K == JsonToken.START_OBJECT || this.K == JsonToken.START_ARRAY) {
                    this.f2145e = true;
                }
                return this.K;
            }
            this.K = this.f2143c.mo152k();
            this.f2143c = this.f2143c.f2150c;
            return this.K;
        }
    }

    public final JsonParser m2273f() {
        if (this.K == JsonToken.START_OBJECT) {
            this.f2145e = false;
            this.K = JsonToken.END_OBJECT;
        } else if (this.K == JsonToken.START_ARRAY) {
            this.f2145e = false;
            this.K = JsonToken.END_ARRAY;
        }
        return this;
    }

    public final String m2274i() {
        return this.f2143c == null ? null : this.f2143c.m2294h();
    }

    public final JsonStreamContext m2275j() {
        return this.f2143c;
    }

    public final JsonLocation m2276k() {
        return JsonLocation.f915a;
    }

    public final JsonLocation m2277l() {
        return JsonLocation.f915a;
    }

    public final String m2278o() {
        if (this.f2146f) {
            return null;
        }
        switch (C01131.f2153a[this.K.ordinal()]) {
            case 1:
                return this.f2143c.m2294h();
            case 2:
                return m2262K().s();
            case 3:
            case 4:
                return String.valueOf(m2262K().v());
            case 5:
                JsonNode K = m2262K();
                if (K != null && K.r()) {
                    return K.B();
                }
        }
        if (this.K != null) {
            return this.K.asString();
        }
        return null;
    }

    public final char[] m2279p() {
        return o().toCharArray();
    }

    public final int m2280q() {
        return o().length();
    }

    public final int m2281r() {
        return 0;
    }

    public final boolean m2282s() {
        return false;
    }

    public final NumberType m2284u() {
        JsonNode L = m2263L();
        return L == null ? null : L.b();
    }

    public final BigInteger m2287z() {
        return m2263L().A();
    }

    public final BigDecimal m2266C() {
        return m2263L().z();
    }

    public final double m2265B() {
        return m2263L().y();
    }

    public final float m2264A() {
        return (float) m2263L().y();
    }

    public final long m2286y() {
        return m2263L().x();
    }

    public final int m2285x() {
        return m2263L().w();
    }

    public final Number m2283t() {
        return m2263L().v();
    }

    public final Object m2267D() {
        if (!this.f2146f) {
            JsonNode K = m2262K();
            if (K != null) {
                if (K.l()) {
                    return ((POJONode) K).a;
                }
                if (K.r()) {
                    return ((BinaryNode) K).t();
                }
            }
        }
        return null;
    }

    public final byte[] m2271a(Base64Variant base64Variant) {
        JsonNode K = m2262K();
        if (K != null) {
            byte[] t = K.t();
            if (t != null) {
                return t;
            }
            if (K.l()) {
                Object obj = ((POJONode) K).a;
                if (obj instanceof byte[]) {
                    return (byte[]) obj;
                }
            }
        }
        return null;
    }

    private JsonNode m2262K() {
        if (this.f2146f || this.f2143c == null) {
            return null;
        }
        return this.f2143c.mo153l();
    }

    private JsonNode m2263L() {
        JsonNode K = m2262K();
        if (K != null && K.m()) {
            return K;
        }
        throw b("Current token (" + (K == null ? null : K.a()) + ") not numeric, can not use numeric value accessors");
    }

    protected final void m2268P() {
        VersionUtil.b();
    }
}
