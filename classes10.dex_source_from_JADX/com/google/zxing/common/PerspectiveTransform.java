package com.google.zxing.common;

/* compiled from: event_prompt_impression */
public final class PerspectiveTransform {
    private final float f13495a;
    private final float f13496b;
    private final float f13497c;
    private final float f13498d;
    private final float f13499e;
    private final float f13500f;
    private final float f13501g;
    private final float f13502h;
    private final float f13503i;

    private PerspectiveTransform(float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9) {
        this.f13495a = f;
        this.f13496b = f4;
        this.f13497c = f7;
        this.f13498d = f2;
        this.f13499e = f5;
        this.f13500f = f8;
        this.f13501g = f3;
        this.f13502h = f6;
        this.f13503i = f9;
    }

    public static PerspectiveTransform m13695a(float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10, float f11, float f12, float f13, float f14, float f15, float f16) {
        return m13694a(f9, f10, f11, f12, f13, f14, f15, f16).m13696a(m13697b(f, f2, f3, f4, f5, f6, f7, f8));
    }

    public final void m13698a(float[] fArr) {
        int length = fArr.length;
        float f = this.f13495a;
        float f2 = this.f13496b;
        float f3 = this.f13497c;
        float f4 = this.f13498d;
        float f5 = this.f13499e;
        float f6 = this.f13500f;
        float f7 = this.f13501g;
        float f8 = this.f13502h;
        float f9 = this.f13503i;
        for (int i = 0; i < length; i += 2) {
            float f10 = fArr[i];
            float f11 = fArr[i + 1];
            float f12 = ((f3 * f10) + (f6 * f11)) + f9;
            fArr[i] = (((f * f10) + (f4 * f11)) + f7) / f12;
            fArr[i + 1] = (((f10 * f2) + (f11 * f5)) + f8) / f12;
        }
    }

    private static PerspectiveTransform m13694a(float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8) {
        float f9 = ((f - f3) + f5) - f7;
        float f10 = ((f2 - f4) + f6) - f8;
        if (f9 == 0.0f && f10 == 0.0f) {
            return new PerspectiveTransform(f3 - f, f5 - f3, f, f4 - f2, f6 - f4, f2, 0.0f, 0.0f, 1.0f);
        }
        float f11 = f3 - f5;
        float f12 = f7 - f5;
        float f13 = f4 - f6;
        float f14 = f8 - f6;
        float f15 = (f11 * f14) - (f12 * f13);
        float f16 = ((f14 * f9) - (f12 * f10)) / f15;
        float f17 = ((f10 * f11) - (f9 * f13)) / f15;
        return new PerspectiveTransform((f3 - f) + (f16 * f3), (f7 - f) + (f17 * f7), f, (f16 * f4) + (f4 - f2), (f17 * f8) + (f8 - f2), f2, f16, f17, 1.0f);
    }

    private static PerspectiveTransform m13697b(float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8) {
        return m13694a(f, f2, f3, f4, f5, f6, f7, f8).m13693a();
    }

    private PerspectiveTransform m13693a() {
        return new PerspectiveTransform((this.f13499e * this.f13503i) - (this.f13500f * this.f13502h), (this.f13500f * this.f13501g) - (this.f13498d * this.f13503i), (this.f13498d * this.f13502h) - (this.f13499e * this.f13501g), (this.f13497c * this.f13502h) - (this.f13496b * this.f13503i), (this.f13495a * this.f13503i) - (this.f13497c * this.f13501g), (this.f13496b * this.f13501g) - (this.f13495a * this.f13502h), (this.f13496b * this.f13500f) - (this.f13497c * this.f13499e), (this.f13497c * this.f13498d) - (this.f13495a * this.f13500f), (this.f13495a * this.f13499e) - (this.f13496b * this.f13498d));
    }

    private PerspectiveTransform m13696a(PerspectiveTransform perspectiveTransform) {
        return new PerspectiveTransform(((this.f13495a * perspectiveTransform.f13495a) + (this.f13498d * perspectiveTransform.f13496b)) + (this.f13501g * perspectiveTransform.f13497c), ((this.f13495a * perspectiveTransform.f13498d) + (this.f13498d * perspectiveTransform.f13499e)) + (this.f13501g * perspectiveTransform.f13500f), ((this.f13495a * perspectiveTransform.f13501g) + (this.f13498d * perspectiveTransform.f13502h)) + (this.f13501g * perspectiveTransform.f13503i), ((this.f13496b * perspectiveTransform.f13495a) + (this.f13499e * perspectiveTransform.f13496b)) + (this.f13502h * perspectiveTransform.f13497c), ((this.f13496b * perspectiveTransform.f13498d) + (this.f13499e * perspectiveTransform.f13499e)) + (this.f13502h * perspectiveTransform.f13500f), ((this.f13496b * perspectiveTransform.f13501g) + (this.f13499e * perspectiveTransform.f13502h)) + (this.f13502h * perspectiveTransform.f13503i), ((this.f13497c * perspectiveTransform.f13495a) + (this.f13500f * perspectiveTransform.f13496b)) + (this.f13503i * perspectiveTransform.f13497c), ((this.f13497c * perspectiveTransform.f13498d) + (this.f13500f * perspectiveTransform.f13499e)) + (this.f13503i * perspectiveTransform.f13500f), ((this.f13497c * perspectiveTransform.f13501g) + (this.f13500f * perspectiveTransform.f13502h)) + (this.f13503i * perspectiveTransform.f13503i));
    }
}
