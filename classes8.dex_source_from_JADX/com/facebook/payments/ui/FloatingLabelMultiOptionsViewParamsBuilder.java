package com.facebook.payments.ui;

import com.facebook.payments.ui.FloatingLabelMultiOptionsView.Mode;

/* compiled from: subscribe_page_events_tap */
public class FloatingLabelMultiOptionsViewParamsBuilder {
    public Mode f1967a;
    public String f1968b;
    public String f1969c;
    public String f1970d;

    public final Mode m2197a() {
        return this.f1967a;
    }

    public final FloatingLabelMultiOptionsViewParamsBuilder m2198a(Mode mode) {
        this.f1967a = mode;
        return this;
    }

    public final String m2201b() {
        return this.f1968b;
    }

    public final FloatingLabelMultiOptionsViewParamsBuilder m2199a(String str) {
        this.f1968b = str;
        return this;
    }

    public final String m2203c() {
        return this.f1969c;
    }

    public final FloatingLabelMultiOptionsViewParamsBuilder m2200b(String str) {
        this.f1969c = str;
        return this;
    }

    public final String m2204d() {
        return this.f1970d;
    }

    public final FloatingLabelMultiOptionsViewParamsBuilder m2202c(String str) {
        this.f1970d = str;
        return this;
    }

    public final FloatingLabelMultiOptionsViewParams m2205e() {
        return new FloatingLabelMultiOptionsViewParams(this);
    }
}
