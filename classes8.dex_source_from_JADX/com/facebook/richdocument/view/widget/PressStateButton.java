package com.facebook.richdocument.view.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedProvider;
import com.facebook.widget.springbutton.TouchSpring;
import com.facebook.widget.springbutton.TouchSpring.TouchSpringUpdateListener;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: offscreen_raw_time */
public class PressStateButton extends ScalableImageWithTextView implements TouchSpringUpdateListener {
    @Inject
    public Provider<TouchSpring> f7244a;
    public final TouchSpring f7245e;
    public boolean f7246f;
    private float f7247g;

    /* compiled from: offscreen_raw_time */
    class C08271 implements OnTouchListener {
        final /* synthetic */ PressStateButton f7235a;

        C08271(PressStateButton pressStateButton) {
            this.f7235a = pressStateButton;
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            return this.f7235a.f7245e != null && this.f7235a.f7245e.onTouch(view, motionEvent);
        }
    }

    private static <T extends View> void m7511a(Class<T> cls, T t) {
        m7512a((Object) t, t.getContext());
    }

    private static void m7512a(Object obj, Context context) {
        ((PressStateButton) obj).f7244a = IdBasedProvider.a(FbInjector.get(context), 3736);
    }

    public PressStateButton(Context context) {
        this(context, null);
    }

    public PressStateButton(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PressStateButton(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f7246f = true;
        this.f7247g = 1.0f;
        m7511a(PressStateButton.class, (View) this);
        setOnTouchListener(new C08271(this));
        this.f7245e = (TouchSpring) this.f7244a.get();
        this.f7245e.a(this);
        this.f7245e.d = true;
        setClipChildren(false);
        setClipToPadding(false);
    }

    public void setDrawableBaseScale(float f) {
        this.f7247g = f;
        setImageScaleX(1.0f);
        setImageScaleY(1.0f);
    }

    public final void m7514a(float f) {
        if (this.f7246f) {
            setImageScaleX(f);
            setImageScaleY(f);
        }
    }

    public void setHasAnimation(boolean z) {
        this.f7246f = z;
    }

    public void setImageScaleX(float f) {
        super.setImageScaleX(this.f7247g * f);
    }

    public void setImageScaleY(float f) {
        super.setImageScaleY(this.f7247g * f);
    }

    private void m7513a(Provider<TouchSpring> provider) {
        this.f7244a = provider;
    }
}
