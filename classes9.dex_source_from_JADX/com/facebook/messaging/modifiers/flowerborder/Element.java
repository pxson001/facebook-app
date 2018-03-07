package com.facebook.messaging.modifiers.flowerborder;

import android.graphics.Paint;

/* compiled from: kilometer */
class Element {
    public final float f12249a;
    public final float f12250b;
    public final float f12251c;
    public final float f12252d;
    public final float f12253e;
    public final ElementStyle f12254f;
    public final Paint f12255g;
    public final long f12256h;
    public final long f12257i;

    /* compiled from: kilometer */
    public class Builder {
        public float f12240a;
        public float f12241b;
        public float f12242c = 1.0f;
        public float f12243d;
        public float f12244e;
        public ElementStyle f12245f;
        public Paint f12246g;
        public long f12247h;
        public long f12248i;

        public final Builder m12729a(Element element) {
            this.f12240a = element.f12249a;
            this.f12241b = element.f12250b;
            this.f12242c = element.f12251c;
            this.f12243d = element.f12252d;
            this.f12244e = element.f12253e;
            this.f12245f = element.f12254f;
            this.f12246g = element.f12255g;
            this.f12247h = element.f12256h;
            this.f12248i = element.f12257i;
            return this;
        }

        public final Builder m12728a(float f, float f2) {
            this.f12240a = f;
            this.f12241b = f2;
            return this;
        }

        public final Element m12730a() {
            return new Element(this);
        }
    }

    public static Builder m12731a() {
        return new Builder();
    }

    public Element(Builder builder) {
        this.f12249a = builder.f12240a;
        this.f12250b = builder.f12241b;
        this.f12251c = builder.f12242c;
        this.f12252d = builder.f12243d;
        this.f12253e = builder.f12244e;
        this.f12254f = builder.f12245f;
        this.f12255g = builder.f12246g;
        this.f12256h = builder.f12247h;
        this.f12257i = builder.f12248i;
    }
}
