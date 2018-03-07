package com.facebook.widget.refreshableview;

import android.graphics.drawable.Drawable;
import android.view.animation.Animation;
import android.view.animation.Interpolator;
import android.view.animation.Transformation;

/* compiled from: reaction_unit_id */
public class VelocityRotationAnimation extends Animation {
    private Drawable f6212a;
    private long f6213b;
    public float f6214c = 0.0f;
    public float f6215d = 0.0f;
    public float f6216e = 0.0f;
    public float f6217f = 0.0f;
    public long f6218g = 0;
    public Interpolator f6219h;

    public VelocityRotationAnimation(Drawable drawable, long j) {
        this.f6212a = drawable;
        this.f6213b = j;
        setDuration(this.f6213b);
    }

    protected void applyTransformation(float f, Transformation transformation) {
        super.applyTransformation(f, transformation);
        if (this.f6215d < ((float) this.f6218g)) {
            float f2 = ((float) this.f6213b) * f;
            if (f2 >= this.f6214c) {
                this.f6215d += f2 - this.f6214c;
            } else {
                this.f6215d += (((float) this.f6213b) + f2) - this.f6214c;
            }
            this.f6214c = f2;
            this.f6216e = (this.f6219h.getInterpolation(this.f6215d / ((float) this.f6218g)) * this.f6217f) % 360.0f;
        }
        this.f6212a.setLevel((int) (10000.0f * ((this.f6216e / 360.0f) + f)));
    }
}
