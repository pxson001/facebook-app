package com.facebook.widget.springbutton;

import android.content.Context;
import android.util.AttributeSet;
import com.facebook.fbui.glyph.GlyphView;
import com.facebook.widget.springbutton.TouchSpring.TouchSpringUpdateListener;

/* compiled from: native_settings_row_clicked */
public class SpringScaleButton extends GlyphView implements TouchSpringUpdateListener {
    private TouchSpring f7279b;

    public SpringScaleButton(Context context) {
        this(context, null);
    }

    public SpringScaleButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public final void m7601a(TouchSpring touchSpring) {
        this.f7279b = touchSpring;
        this.f7279b.a(this);
        setOnTouchListener(touchSpring);
    }

    public final void m7599a() {
        setOnTouchListener(null);
        this.f7279b.a();
        this.f7279b = null;
    }

    public final void m7600a(float f) {
        setScaleX(f);
        setScaleY(f);
    }
}
