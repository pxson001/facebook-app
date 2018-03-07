package com.facebook.messaging.bball;

/* compiled from: one_week_from_now */
class BballViewHelper {
    private final BballScene f8237a;
    private float f8238b;

    public BballViewHelper(BballScene bballScene) {
        this.f8237a = bballScene;
    }

    public final void m8474a(int i, int i2) {
        if (((float) i) / ((float) i2) < 0.625f) {
            this.f8238b = ((float) i) / 1.0f;
        } else {
            this.f8238b = ((float) i2) / 1.6f;
        }
    }

    public final int m8473a() {
        return (int) (this.f8238b * 0.3f);
    }

    public final float m8475b() {
        return this.f8237a.f8173c * this.f8238b;
    }

    public final float m8476c() {
        return this.f8237a.f8174d * this.f8238b;
    }

    public final int m8477d() {
        return (int) (0.26f * this.f8238b);
    }

    public final int m8478e() {
        return (int) (0.017f * this.f8238b);
    }

    public final float m8479f() {
        return this.f8237a.f8182l * this.f8238b;
    }

    public final float m8480g() {
        return ((float) (m8478e() / 2)) + (this.f8237a.f8183m * this.f8238b);
    }

    public final float m8481h() {
        return ((float) (m8478e() / 2)) + (-1.1f * this.f8238b);
    }

    public final int m8482i() {
        return (int) (0.56f * this.f8238b);
    }

    public final int m8483j() {
        return (int) (0.35f * this.f8238b);
    }

    public final int m8484k() {
        return (int) (0.22f * this.f8238b);
    }

    public final int m8485l() {
        return (int) (0.17f * this.f8238b);
    }

    public final int m8486m() {
        return (int) (0.123f * this.f8238b);
    }

    public final int m8487n() {
        return (int) (0.0483f * this.f8238b);
    }

    public final int m8488o() {
        return (int) (0.15f * this.f8238b);
    }

    public final float m8489p() {
        return m8480g() + (0.035f * this.f8238b);
    }

    public final float m8490q() {
        return m8480g() + (-0.012f * this.f8238b);
    }

    public final float m8491r() {
        return m8489p() + (0.017f * this.f8238b);
    }
}
