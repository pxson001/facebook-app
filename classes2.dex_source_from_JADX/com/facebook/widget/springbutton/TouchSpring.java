package com.facebook.widget.springbutton;

import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.facebook.feed.ufi.FullscreenVideoFeedbackActionButtonBar.LikeButtonSpringListener;
import com.facebook.inject.InjectorLike;
import com.facebook.proxygen.HTTPTransportCallback;
import com.facebook.springs.Spring;
import com.facebook.springs.SpringConfig;
import java.lang.ref.WeakReference;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: gifts_imp */
public class TouchSpring implements OnTouchListener {
    public float f22377a = 1.3f;
    public float f22378b = 0.8f;
    public float f22379c = 1.4f;
    public boolean f22380d = false;
    public SpringConfig f22381e;
    public final SpringFactory f22382f;
    @Nullable
    public Spring f22383g;
    @Nullable
    private WeakReference<TouchSpringUpdateListener> f22384h;
    @Nullable
    public int[] f22385i;
    @Nullable
    public Rect f22386j;
    @Deprecated
    @Nullable
    public LikeButtonSpringListener f22387k;

    /* compiled from: gifts_imp */
    public interface TouchSpringUpdateListener {
        void mo3274a(float f);

        boolean isPressed();

        boolean performClick();
    }

    public static TouchSpring m30307b(InjectorLike injectorLike) {
        return new TouchSpring(SpringFactory.m28319a(injectorLike));
    }

    @Inject
    public TouchSpring(SpringFactory springFactory) {
        this.f22382f = springFactory;
    }

    public final void m30311a(TouchSpringUpdateListener touchSpringUpdateListener) {
        this.f22384h = new WeakReference(touchSpringUpdateListener);
    }

    public final void m30309a() {
        this.f22384h = null;
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        TouchSpringUpdateListener c = m30308c(this);
        if (c != null) {
            if (this.f22385i == null) {
                this.f22385i = new int[2];
                this.f22386j = new Rect();
                this.f22383g = this.f22382f.m28321a();
                if (this.f22381e != null) {
                    this.f22383g.m7814a(this.f22381e);
                }
                this.f22383g.m7815a(new ButtonSpringListener(this));
            }
            boolean a = m30306a(view, this.f22383g, motionEvent);
            if (motionEvent.getAction() == 1 && a) {
                c.performClick();
            }
        }
        return true;
    }

    private boolean m30306a(View view, Spring spring, MotionEvent motionEvent) {
        double d = 1.0d;
        boolean z = true;
        if (!this.f22380d) {
            view.getHitRect(this.f22386j);
            view.getLocationOnScreen(this.f22385i);
            this.f22386j.offsetTo(this.f22385i[0], this.f22385i[1]);
            z = this.f22386j.contains((int) motionEvent.getRawX(), (int) motionEvent.getRawY());
        }
        boolean z2 = z;
        switch (motionEvent.getAction()) {
            case 0:
            case HTTPTransportCallback.FIRST_BODY_BYTE_FLUSHED /*2*/:
                view.setPressed(z2);
                if (z2) {
                    d = (double) this.f22378b;
                }
                spring.m7818b(d);
                break;
            case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
                view.setPressed(false);
                if (z2) {
                    d = (double) this.f22379c;
                }
                spring.m7818b(d);
                break;
            case 3:
                view.setPressed(false);
                spring.m7818b(1.0d);
                break;
        }
        return z2;
    }

    public static TouchSpringUpdateListener m30308c(TouchSpring touchSpring) {
        if (touchSpring.f22384h == null) {
            return null;
        }
        return (TouchSpringUpdateListener) touchSpring.f22384h.get();
    }

    public final void m30310a(SpringConfig springConfig) {
        this.f22381e = springConfig;
        if (this.f22383g != null) {
            this.f22383g.m7814a(springConfig);
        }
    }
}
