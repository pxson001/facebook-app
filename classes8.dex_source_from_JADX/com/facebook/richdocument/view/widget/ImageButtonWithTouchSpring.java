package com.facebook.richdocument.view.widget;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedProvider;
import com.facebook.resources.ui.FbImageButton;
import com.facebook.richdocument.view.RichDocumentUIConfig;
import com.facebook.springs.SpringConfig;
import com.facebook.widget.springbutton.TouchSpring;
import com.facebook.widget.springbutton.TouchSpring.TouchSpringUpdateListener;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: open_acorn_weather_settings_tap */
public class ImageButtonWithTouchSpring extends FbImageButton implements TouchSpringUpdateListener {
    private static final SpringConfig f7189b = SpringConfig.b(RichDocumentUIConfig.f6539J, RichDocumentUIConfig.f6540K);
    @Inject
    public Provider<TouchSpring> f7190a;
    public TouchSpring f7191c;

    /* compiled from: open_acorn_weather_settings_tap */
    class C08141 implements OnTouchListener {
        final /* synthetic */ ImageButtonWithTouchSpring f7188a;

        C08141(ImageButtonWithTouchSpring imageButtonWithTouchSpring) {
            this.f7188a = imageButtonWithTouchSpring;
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            return this.f7188a.f7191c != null && this.f7188a.f7191c.onTouch(view, motionEvent);
        }
    }

    public static void m7458a(Object obj, Context context) {
        ((ImageButtonWithTouchSpring) obj).f7190a = IdBasedProvider.a(FbInjector.get(context), 3736);
    }

    public ImageButtonWithTouchSpring(Context context) {
        super(context);
        m7457a();
    }

    private void m7457a() {
        Class cls = ImageButtonWithTouchSpring.class;
        m7458a(this, getContext());
        this.f7191c = (TouchSpring) this.f7190a.get();
        this.f7191c.a(this);
        this.f7191c.d = true;
        this.f7191c.b = 0.8f;
        this.f7191c.c = 1.0f;
        this.f7191c.a(f7189b);
        super.setOnTouchListener(new C08141(this));
    }

    public void setSpring(TouchSpring touchSpring) {
        this.f7191c = touchSpring;
    }

    public final void m7459a(float f) {
        setScaleX(f);
        setScaleY(f);
    }

    public void setOnTouchListener(OnTouchListener onTouchListener) {
        throw new UnsupportedOperationException("TouchSpring is OnTouchListener for this view");
    }
}
