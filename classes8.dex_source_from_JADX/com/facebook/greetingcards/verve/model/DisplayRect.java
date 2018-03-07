package com.facebook.greetingcards.verve.model;

import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: was_bootstrap_loaded_at_click_time */
public class DisplayRect {
    public final float f274a;
    public final float f275b;
    public final float f276c;
    public final float f277d;

    public DisplayRect(float f, float f2, float f3, float f4) {
        this.f274a = f;
        this.f275b = f2;
        this.f276c = f3;
        this.f277d = f4;
    }

    public static DisplayRect m263a(DisplayRect displayRect, float f) {
        return f == 1.0f ? displayRect : new DisplayRect(displayRect.f274a * f, displayRect.f275b * f, displayRect.f276c * f, displayRect.f277d * f);
    }
}
