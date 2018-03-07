package com.facebook.particles.suppliers;

import com.facebook.common.util.MathUtil;
import java.util.Random;

/* compiled from: matches */
public class RandomInRange implements FloatSupplier {
    public static final RandomInRange f9248a = new RandomInRange(0.0f, 1.0f);
    public static final RandomInRange f9249b = new RandomInRange(0.0f, 360.0f);
    private final Random f9250c = new Random();
    private final float f9251d;
    private final float f9252e;

    public RandomInRange(float f, float f2) {
        this.f9251d = f;
        this.f9252e = f2;
    }

    public final float mo482a() {
        return MathUtil.a(this.f9251d, this.f9252e, this.f9250c.nextFloat());
    }
}
