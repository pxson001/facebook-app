package com.facebook.drawee.generic;

import com.facebook.common.internal.Preconditions;
import java.util.Arrays;

/* compiled from: Zombie(s) */
public class RoundingParams {
    public RoundingMethod f11976a = RoundingMethod.BITMAP_ONLY;
    public boolean f11977b = false;
    public float[] f11978c = null;
    public int f11979d = 0;
    public float f11980e = 0.0f;
    public int f11981f = 0;
    public float f11982g = 0.0f;

    /* compiled from: Zombie(s) */
    public enum RoundingMethod {
        OVERLAY_COLOR,
        BITMAP_ONLY
    }

    public final RoundingParams m19986a(boolean z) {
        this.f11977b = z;
        return this;
    }

    public final RoundingParams m19982a(float f) {
        Arrays.fill(m19981i(), f);
        return this;
    }

    public final RoundingParams m19983a(float f, float f2, float f3, float f4) {
        float[] i = m19981i();
        i[1] = f;
        i[0] = f;
        i[3] = f2;
        i[2] = f2;
        i[5] = f3;
        i[4] = f3;
        i[7] = f4;
        i[6] = f4;
        return this;
    }

    public final RoundingParams m19984a(int i) {
        this.f11979d = i;
        this.f11976a = RoundingMethod.OVERLAY_COLOR;
        return this;
    }

    private float[] m19981i() {
        if (this.f11978c == null) {
            this.f11978c = new float[8];
        }
        return this.f11978c;
    }

    public static RoundingParams m19980e() {
        RoundingParams roundingParams = new RoundingParams();
        roundingParams.f11977b = true;
        return roundingParams;
    }

    public static RoundingParams m19978b(float f) {
        return new RoundingParams().m19982a(f);
    }

    public static RoundingParams m19979b(float f, float f2, float f3, float f4) {
        return new RoundingParams().m19983a(f, f2, f3, f4);
    }

    public final RoundingParams m19988c(float f) {
        Preconditions.a(f >= 0.0f, "the border width cannot be < 0");
        this.f11980e = f;
        return this;
    }

    public final RoundingParams m19987b(int i) {
        this.f11981f = i;
        return this;
    }

    public final RoundingParams m19985a(int i, float f) {
        Preconditions.a(f >= 0.0f, "the border width cannot be < 0");
        this.f11980e = f;
        this.f11981f = i;
        return this;
    }

    public final RoundingParams m19989d(float f) {
        Preconditions.a(f >= 0.0f, "the padding cannot be < 0");
        this.f11982g = f;
        return this;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        RoundingParams roundingParams = (RoundingParams) obj;
        if (this.f11977b == roundingParams.f11977b && this.f11979d == roundingParams.f11979d && Float.compare(roundingParams.f11980e, this.f11980e) == 0 && this.f11981f == roundingParams.f11981f && Float.compare(roundingParams.f11982g, this.f11982g) == 0 && this.f11976a == roundingParams.f11976a) {
            return Arrays.equals(this.f11978c, roundingParams.f11978c);
        }
        return false;
    }

    public int hashCode() {
        int i;
        int i2 = 0;
        int hashCode = (this.f11976a != null ? this.f11976a.hashCode() : 0) * 31;
        if (this.f11977b) {
            i = 1;
        } else {
            i = 0;
        }
        hashCode = (i + hashCode) * 31;
        if (this.f11978c != null) {
            i = Arrays.hashCode(this.f11978c);
        } else {
            i = 0;
        }
        hashCode = (((i + hashCode) * 31) + this.f11979d) * 31;
        if (this.f11980e != 0.0f) {
            i = Float.floatToIntBits(this.f11980e);
        } else {
            i = 0;
        }
        i = (((i + hashCode) * 31) + this.f11981f) * 31;
        if (this.f11982g != 0.0f) {
            i2 = Float.floatToIntBits(this.f11982g);
        }
        return i + i2;
    }
}
