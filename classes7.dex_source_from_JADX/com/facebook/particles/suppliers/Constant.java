package com.facebook.particles.suppliers;

import android.content.res.Resources;

/* compiled from: maxDeltasAbleToProcess */
public class Constant implements FloatSupplier {
    public static final Constant f9242a = new Constant(0.0f);
    public static final Constant f9243b = new Constant(1.0f);
    private final float f9244c;

    private Constant(float f) {
        this.f9244c = f;
    }

    public Constant(Resources resources, int i) {
        this(resources.getDimension(i));
    }

    public final float mo482a() {
        return this.f9244c;
    }
}
