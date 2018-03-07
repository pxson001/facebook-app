package com.facebook.messaging.modifiers.flowerborder;

import android.graphics.drawable.BitmapDrawable;

/* compiled from: kill_animation */
class ElementStyle {
    public final BitmapDrawable f12262a;
    public final float f12263b;
    public final float f12264c;
    public final float f12265d;

    /* compiled from: kill_animation */
    public class Builder {
        public BitmapDrawable f12258a;
        public float f12259b = 1.0f;
        public float f12260c = 0.5f;
        public float f12261d = 0.5f;

        Builder() {
        }

        final Builder m12732a(float f, float f2) {
            this.f12260c = f;
            this.f12261d = f2;
            return this;
        }

        final ElementStyle m12733a() {
            return new ElementStyle(this);
        }
    }

    public static Builder m12734a() {
        return new Builder();
    }

    public ElementStyle(Builder builder) {
        this.f12262a = builder.f12258a;
        this.f12263b = builder.f12259b;
        this.f12264c = builder.f12260c;
        this.f12265d = builder.f12261d;
    }
}
