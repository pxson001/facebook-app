package com.facebook.widget.springbutton;

import com.facebook.springs.SimpleSpringListener;
import com.facebook.springs.Spring;
import com.facebook.widget.springbutton.TouchSpring.TouchSpringUpdateListener;

/* compiled from: previously_disabled */
public class TouchSpring$ButtonSpringListener extends SimpleSpringListener {
    final /* synthetic */ TouchSpring f4242a;

    public TouchSpring$ButtonSpringListener(TouchSpring touchSpring) {
        this.f4242a = touchSpring;
    }

    public final void m4769a(Spring spring) {
        float d = (float) spring.d();
        if (d >= this.f4242a.a) {
            spring.b(1.0d);
        }
        TouchSpringUpdateListener c = TouchSpring.c(this.f4242a);
        if (c != null) {
            c.a(d);
        }
    }

    public final void m4771c(Spring spring) {
        TouchSpringUpdateListener c = TouchSpring.c(this.f4242a);
        if (c != null && c.isPressed() && this.f4242a.k != null) {
            this.f4242a.k.a();
        }
    }

    public final void m4770b(Spring spring) {
        TouchSpringUpdateListener c = TouchSpring.c(this.f4242a);
        if (c != null) {
            c.isPressed();
        }
    }
}
