package com.fasterxml.jackson.databind.util;

import com.fasterxml.jackson.core.JsonToken;

/* compiled from: can_viewer_edit_post_media */
public final class TokenBuffer$Segment {
    private static final JsonToken[] f6265d = new JsonToken[16];
    public TokenBuffer$Segment f6266a;
    protected long f6267b;
    protected final Object[] f6268c = new Object[16];

    static {
        Object values = JsonToken.values();
        System.arraycopy(values, 1, f6265d, 1, Math.min(15, values.length - 1));
    }

    public final JsonToken m11853a(int i) {
        long j = this.f6267b;
        if (i > 0) {
            j >>= i << 2;
        }
        return f6265d[((int) j) & 15];
    }

    public final Object m11857b(int i) {
        return this.f6268c[i];
    }

    public final TokenBuffer$Segment m11854a() {
        return this.f6266a;
    }

    public final TokenBuffer$Segment m11855a(int i, JsonToken jsonToken) {
        if (i < 16) {
            m11851b(i, jsonToken);
            return null;
        }
        this.f6266a = new TokenBuffer$Segment();
        this.f6266a.m11851b(0, jsonToken);
        return this.f6266a;
    }

    public final TokenBuffer$Segment m11856a(int i, JsonToken jsonToken, Object obj) {
        if (i < 16) {
            m11852b(i, jsonToken, obj);
            return null;
        }
        this.f6266a = new TokenBuffer$Segment();
        this.f6266a.m11852b(0, jsonToken, obj);
        return this.f6266a;
    }

    private void m11851b(int i, JsonToken jsonToken) {
        long ordinal = (long) jsonToken.ordinal();
        if (i > 0) {
            ordinal <<= i << 2;
        }
        this.f6267b = ordinal | this.f6267b;
    }

    private void m11852b(int i, JsonToken jsonToken, Object obj) {
        this.f6268c[i] = obj;
        long ordinal = (long) jsonToken.ordinal();
        if (i > 0) {
            ordinal <<= i << 2;
        }
        this.f6267b = ordinal | this.f6267b;
    }
}
