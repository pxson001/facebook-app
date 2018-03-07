package com.facebook.spherical;

/* compiled from: event_admin_rsvp */
public class Quaternion {
    public float f16141a = 1.0f;
    public float f16142b = 0.0f;
    public float f16143c = 0.0f;
    public float f16144d = 0.0f;

    public final void m23716a(Quaternion quaternion) {
        this.f16142b = quaternion.f16142b;
        this.f16143c = quaternion.f16143c;
        this.f16144d = quaternion.f16144d;
        this.f16141a = quaternion.f16141a;
    }

    public final void m23715a(float f, float f2, float f3, float f4) {
        float f5 = 0.5f * f;
        float sin = (float) Math.sin((double) f5);
        this.f16141a = (float) Math.cos((double) f5);
        this.f16142b = f2 * sin;
        this.f16143c = f3 * sin;
        this.f16144d = f4 * sin;
    }

    public final void m23718a(float[] fArr) {
        this.f16141a = fArr[0];
        this.f16142b = fArr[1];
        this.f16143c = fArr[2];
        this.f16144d = fArr[3];
    }

    public final void m23720b(float[] fArr) {
        fArr[0] = (1.0f - ((this.f16143c * 2.0f) * this.f16143c)) - ((this.f16144d * 2.0f) * this.f16144d);
        fArr[1] = ((this.f16142b * 2.0f) * this.f16143c) + ((this.f16141a * 2.0f) * this.f16144d);
        fArr[2] = ((this.f16142b * 2.0f) * this.f16144d) - ((this.f16141a * 2.0f) * this.f16143c);
        fArr[3] = 0.0f;
        fArr[4] = ((this.f16142b * 2.0f) * this.f16143c) - ((this.f16141a * 2.0f) * this.f16144d);
        fArr[5] = (1.0f - ((this.f16142b * 2.0f) * this.f16142b)) - ((this.f16144d * 2.0f) * this.f16144d);
        fArr[6] = ((this.f16143c * 2.0f) * this.f16144d) + ((this.f16141a * 2.0f) * this.f16142b);
        fArr[7] = 0.0f;
        fArr[8] = ((this.f16142b * 2.0f) * this.f16144d) + ((this.f16141a * 2.0f) * this.f16143c);
        fArr[9] = ((this.f16143c * 2.0f) * this.f16144d) - ((this.f16141a * 2.0f) * this.f16142b);
        fArr[10] = (1.0f - ((this.f16142b * 2.0f) * this.f16142b)) - ((this.f16143c * 2.0f) * this.f16143c);
        fArr[11] = 0.0f;
        fArr[12] = 0.0f;
        fArr[13] = 0.0f;
        fArr[14] = 0.0f;
        fArr[15] = 1.0f;
    }

    private float m23714d(Quaternion quaternion) {
        return (((this.f16141a * quaternion.f16141a) + (this.f16142b * quaternion.f16142b)) + (this.f16143c * quaternion.f16143c)) + (this.f16144d * quaternion.f16144d);
    }

    public final void m23719b(Quaternion quaternion) {
        float f = (((quaternion.f16141a * this.f16142b) + (quaternion.f16142b * this.f16141a)) + (quaternion.f16143c * this.f16144d)) - (quaternion.f16144d * this.f16143c);
        float f2 = (((quaternion.f16141a * this.f16143c) - (quaternion.f16142b * this.f16144d)) + (quaternion.f16143c * this.f16141a)) + (quaternion.f16144d * this.f16142b);
        float f3 = (((quaternion.f16141a * this.f16144d) + (quaternion.f16142b * this.f16143c)) - (quaternion.f16143c * this.f16142b)) + (quaternion.f16144d * this.f16141a);
        this.f16141a = (((quaternion.f16141a * this.f16141a) - (quaternion.f16142b * this.f16142b)) - (quaternion.f16143c * this.f16143c)) - (quaternion.f16144d * this.f16144d);
        this.f16142b = f;
        this.f16143c = f2;
        this.f16144d = f3;
    }

    public final void m23721c(Quaternion quaternion) {
        float f = (((this.f16141a * quaternion.f16142b) + (this.f16142b * quaternion.f16141a)) + (this.f16143c * quaternion.f16144d)) - (this.f16144d * quaternion.f16143c);
        float f2 = (((this.f16141a * quaternion.f16143c) - (this.f16142b * quaternion.f16144d)) + (this.f16143c * quaternion.f16141a)) + (this.f16144d * quaternion.f16142b);
        float f3 = (((this.f16141a * quaternion.f16144d) + (this.f16142b * quaternion.f16143c)) - (this.f16143c * quaternion.f16142b)) + (this.f16144d * quaternion.f16141a);
        this.f16141a = (((this.f16141a * quaternion.f16141a) - (this.f16142b * quaternion.f16142b)) - (this.f16143c * quaternion.f16143c)) - (this.f16144d * quaternion.f16144d);
        this.f16142b = f;
        this.f16143c = f2;
        this.f16144d = f3;
    }

    public final void m23717a(Quaternion quaternion, Quaternion quaternion2, float f) {
        double sin;
        double d = (double) quaternion.m23714d(quaternion2);
        float[] fArr = new float[4];
        if (d < 0.0d) {
            d = -d;
            fArr[0] = -quaternion2.f16141a;
            fArr[1] = -quaternion2.f16142b;
            fArr[2] = -quaternion2.f16143c;
            fArr[3] = -quaternion2.f16144d;
        } else {
            fArr[0] = quaternion2.f16141a;
            fArr[1] = quaternion2.f16142b;
            fArr[2] = quaternion2.f16143c;
            fArr[3] = quaternion2.f16144d;
        }
        if (1.0d - d > 0.01d) {
            d = (double) ((float) Math.acos(d));
            double sin2 = Math.sin(d);
            sin = Math.sin((1.0d - ((double) f)) * d) / sin2;
            d = Math.sin(d * ((double) f)) / sin2;
        } else {
            sin = 1.0d - ((double) f);
            d = (double) f;
        }
        this.f16141a = (float) ((((double) quaternion.f16141a) * sin) + (((double) fArr[0]) * d));
        this.f16142b = (float) ((((double) quaternion.f16142b) * sin) + (((double) fArr[1]) * d));
        this.f16143c = (float) ((((double) quaternion.f16143c) * sin) + (((double) fArr[2]) * d));
        this.f16144d = (float) ((d * ((double) fArr[3])) + (sin * ((double) quaternion.f16144d)));
    }
}
