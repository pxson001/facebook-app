package com.facebook.photos.creativeediting.model;

/* compiled from: surface already created */
public class SwipingTouchEventState {
    public SwipingState f3518a;
    public float f3519b;
    public float f3520c;

    /* compiled from: surface already created */
    public enum SwipingState {
        NOT_SWIPING,
        ON_DOWN,
        FINISHING,
        SWIPING
    }

    public SwipingTouchEventState(SwipingState swipingState) {
        this.f3518a = swipingState;
    }

    public final float m4706a() {
        return this.f3520c - this.f3519b;
    }

    public final boolean m4707c() {
        return this.f3518a == SwipingState.ON_DOWN;
    }

    public String toString() {
        return "direction : " + (m4709e() ? "right" : "left") + ", state : " + this.f3518a + ", startingX : " + this.f3519b + ", currentX : " + this.f3520c;
    }

    public final boolean m4708d() {
        return m4706a() < 0.0f;
    }

    public final boolean m4709e() {
        return m4706a() > 0.0f;
    }

    public final boolean m4710f() {
        return this.f3518a == SwipingState.NOT_SWIPING;
    }

    public final boolean m4711g() {
        return this.f3518a == SwipingState.FINISHING;
    }

    public final boolean m4712h() {
        return this.f3518a == SwipingState.SWIPING;
    }

    public final boolean m4713i() {
        return m4706a() == 0.0f;
    }
}
