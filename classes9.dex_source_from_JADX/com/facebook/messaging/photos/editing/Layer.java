package com.facebook.messaging.photos.editing;

/* compiled from: displayed_page_responsiveness_value */
public class Layer {
    public final Observable f16027a = new Observable();
    public float f16028b;
    public float f16029c;
    public float f16030d = 1.0f;
    public float f16031e;
    public boolean f16032f;

    /* compiled from: displayed_page_responsiveness_value */
    public enum Event {
        TRANSLATE,
        SCALE,
        ROTATE,
        FLIP
    }

    public boolean mo676a() {
        return false;
    }

    public final void m16179a(boolean z) {
        if (this.f16032f != z) {
            this.f16032f = z;
            m16178a(Event.FLIP);
        }
    }

    public final void m16178a(Object obj) {
        this.f16027a.m16225a(obj);
    }
}
