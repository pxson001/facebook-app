package com.facebook.notifications.lockscreenservice;

import android.annotation.TargetApi;
import android.graphics.Rect;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.view.View.OnTouchListener;
import com.facebook.notifications.lockscreenservice.LockScreenService.C06699;
import com.facebook.springs.SimpleSpringListener;
import com.facebook.springs.Spring;
import com.facebook.springs.SpringConfig;
import com.facebook.springs.SpringSystem;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import com.facebook.ui.animations.AnimationUtil;

/* compiled from: network_failure */
public class SpringyPressStateTouchHandler implements OnTouchListener {
    private static final SpringConfig f8381a = SpringConfig.b(20.0d, 15.0d);
    private final Handler f8382b;
    private final DeferredTouchRunnable f8383c;
    public final AnimationUtil f8384d;
    public float f8385e;
    public boolean f8386f;
    public boolean f8387g;
    public boolean f8388h;
    public final View f8389i;
    public final C06699 f8390j;
    private final Rect f8391k;
    private final int[] f8392l;
    private final SpringSystem f8393m;
    public final Spring f8394n;
    private final AnimationSpringListener f8395o;

    /* compiled from: network_failure */
    final class C06701 implements OnAttachStateChangeListener {
        final /* synthetic */ Spring f8373a;
        final /* synthetic */ AnimationSpringListener f8374b;

        C06701(Spring spring, AnimationSpringListener animationSpringListener) {
            this.f8373a = spring;
            this.f8374b = animationSpringListener;
        }

        public final void onViewAttachedToWindow(View view) {
            this.f8373a.a(this.f8374b);
        }

        public final void onViewDetachedFromWindow(View view) {
            this.f8373a.b(this.f8374b);
        }
    }

    /* compiled from: network_failure */
    class AnimationSpringListener extends SimpleSpringListener {
        final /* synthetic */ SpringyPressStateTouchHandler f8375a;

        public AnimationSpringListener(SpringyPressStateTouchHandler springyPressStateTouchHandler) {
            this.f8375a = springyPressStateTouchHandler;
        }

        public final void m9968b(Spring spring) {
            if (!this.f8375a.f8386f) {
                this.f8375a.f8384d.b(this.f8375a.f8389i);
            }
            if (this.f8375a.f8388h && spring.i == 1.0d) {
                this.f8375a.f8390j.m9841a(this.f8375a.f8389i);
                this.f8375a.f8388h = false;
            }
        }

        public final void m9969c(Spring spring) {
            this.f8375a.f8384d.a(this.f8375a.f8389i);
        }

        public final void m9967a(Spring spring) {
            float d = (float) spring.d();
            this.f8375a.f8389i.setScaleX(d);
            this.f8375a.f8389i.setScaleY(d);
            if (this.f8375a.f8386f && d <= this.f8375a.f8385e) {
                this.f8375a.f8394n.b(1.0d);
                this.f8375a.f8386f = false;
            }
        }
    }

    /* compiled from: network_failure */
    public class DeferredTouchRunnable implements Runnable {
        final /* synthetic */ SpringyPressStateTouchHandler f8376a;
        private final View f8377b;
        private final SpringyPressStateTouchHandler f8378c;
        public MotionEvent f8379d;
        public boolean f8380e;

        public DeferredTouchRunnable(SpringyPressStateTouchHandler springyPressStateTouchHandler, View view, SpringyPressStateTouchHandler springyPressStateTouchHandler2) {
            this.f8376a = springyPressStateTouchHandler;
            this.f8377b = view;
            this.f8378c = springyPressStateTouchHandler2;
        }

        public final void m9970b() {
            this.f8380e = false;
        }

        public void run() {
            this.f8380e = true;
            this.f8378c.onTouch(this.f8377b, this.f8379d);
        }
    }

    public SpringyPressStateTouchHandler(View view, C06699 c06699, SpringSystem springSystem, AnimationUtil animationUtil) {
        this(view, c06699, springSystem, f8381a, 0.01d, 0.01d, animationUtil);
    }

    private SpringyPressStateTouchHandler(View view, C06699 c06699, SpringSystem springSystem, SpringConfig springConfig, double d, double d2, AnimationUtil animationUtil) {
        this.f8387g = false;
        this.f8392l = new int[]{0, 0};
        this.f8385e = 0.96f;
        this.f8389i = view;
        this.f8390j = c06699;
        this.f8391k = new Rect();
        this.f8393m = springSystem;
        this.f8384d = animationUtil;
        this.f8382b = new Handler();
        this.f8383c = new DeferredTouchRunnable(this, this.f8389i, this);
        Spring a = this.f8393m.a().a(springConfig);
        a.k = d;
        this.f8394n = a.e(d2).a(1.0d).l();
        this.f8395o = new AnimationSpringListener(this);
        if (this.f8389i.getWindowToken() != null) {
            this.f8394n.a(this.f8395o);
        }
        this.f8389i.addOnAttachStateChangeListener(m9971a(this.f8394n, this.f8395o));
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.f8387g) {
            return m9973a(motionEvent);
        }
        boolean a;
        Object obj;
        int action = motionEvent.getAction() & 255;
        if (action == 0) {
            this.f8383c.f8379d = motionEvent;
            this.f8382b.removeCallbacksAndMessages(null);
            HandlerDetour.b(this.f8382b, this.f8383c, 150, -1069573466);
        }
        if (this.f8383c.f8380e) {
            a = m9973a(motionEvent);
            obj = 1;
        } else {
            obj = null;
            a = true;
        }
        if (action == 3) {
            this.f8382b.removeCallbacksAndMessages(null);
            this.f8383c.m9970b();
            return a;
        } else if (action != 1) {
            return a;
        } else {
            this.f8382b.removeCallbacksAndMessages(null);
            this.f8383c.m9970b();
            if (obj != null) {
                return a;
            }
            a = m9973a(motionEvent);
            m9972a();
            return a;
        }
    }

    private boolean m9973a(MotionEvent motionEvent) {
        this.f8389i.getLocationOnScreen(this.f8392l);
        int i = this.f8392l[0];
        int i2 = this.f8392l[1];
        this.f8391k.set(i, i2, this.f8389i.getWidth() + i, this.f8389i.getHeight() + i2);
        boolean contains = this.f8391k.contains((int) motionEvent.getRawX(), (int) motionEvent.getRawY());
        switch (motionEvent.getAction()) {
            case 0:
                this.f8386f = false;
                this.f8388h = false;
                m9974b();
                return true;
            case 1:
                if (this.f8387g) {
                    if (this.f8394n.k()) {
                        m9975c();
                    } else {
                        this.f8386f = true;
                    }
                    this.f8388h = true;
                    return true;
                }
                m9975c();
                if (contains) {
                    return this.f8390j.m9841a(this.f8389i);
                }
                return false;
            case 2:
                if (contains) {
                    m9974b();
                    return true;
                }
                m9975c();
                return false;
            case 3:
                m9975c();
                return false;
            default:
                return false;
        }
    }

    private void m9972a() {
        this.f8386f = true;
        m9974b();
    }

    private void m9974b() {
        this.f8394n.b((double) this.f8385e);
    }

    private void m9975c() {
        this.f8394n.b(1.0d);
    }

    @TargetApi(12)
    private static OnAttachStateChangeListener m9971a(Spring spring, AnimationSpringListener animationSpringListener) {
        return new C06701(spring, animationSpringListener);
    }
}
