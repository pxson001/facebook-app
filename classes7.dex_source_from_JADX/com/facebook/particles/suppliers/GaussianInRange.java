package com.facebook.particles.suppliers;

import com.facebook.common.util.MathUtil;
import java.util.Random;

/* compiled from: matroska */
public class GaussianInRange implements FloatSupplier {
    private final Random f9245a = new Random();
    private final float f9246b;
    private final float f9247c;

    public GaussianInRange(float f, float f2) {
        this.f9246b = f;
        this.f9247c = f2;
    }

    public final float mo482a() {
        float nextGaussian = (float) this.f9245a.nextGaussian();
        float f = this.f9246b;
        float f2 = this.f9247c;
        return MathUtil.b(MathUtil.a(nextGaussian, -2.33f, 2.33f, f, f2), Math.min(f, f2), Math.max(f, f2));
    }
}
