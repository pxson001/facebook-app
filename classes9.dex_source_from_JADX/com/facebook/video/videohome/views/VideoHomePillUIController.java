package com.facebook.video.videohome.views;

import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.facebook.inject.InjectorLike;
import com.facebook.springs.SimpleSpringListener;
import com.facebook.springs.Spring;
import com.facebook.springs.SpringConfig;
import com.facebook.springs.SpringSystem;
import com.facebook.springs.SpringUtil;
import javax.inject.Inject;

/* compiled from: show_dismiss_button */
public class VideoHomePillUIController {
    public static final SpringConfig f3355a = SpringConfig.b(5.0d, 10.0d);
    public final SpringSystem f3356b;
    public final Rect f3357c;
    public final int[] f3358d = new int[]{0, 0};
    public View f3359e;
    public Spring f3360f;
    public AnimationSpringListener f3361g;
    public AnimationState f3362h = AnimationState.HIDDEN;

    /* compiled from: show_dismiss_button */
    public class C03101 implements OnTouchListener {
        final /* synthetic */ VideoHomePillUIController f3353a;

        public C03101(VideoHomePillUIController videoHomePillUIController) {
            this.f3353a = videoHomePillUIController;
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            return VideoHomePillUIController.m3185a(this.f3353a, view, motionEvent);
        }
    }

    /* compiled from: show_dismiss_button */
    public class AnimationSpringListener extends SimpleSpringListener {
        final /* synthetic */ VideoHomePillUIController f3354a;

        public AnimationSpringListener(VideoHomePillUIController videoHomePillUIController) {
            this.f3354a = videoHomePillUIController;
        }

        public final void m3183c(Spring spring) {
            this.f3354a.f3359e.setVisibility(0);
        }

        public final void m3181a(Spring spring) {
            float d = (float) spring.d();
            float a = (float) SpringUtil.a((double) d, 0.0d, 1.0d, 0.5d, 1.0d);
            this.f3354a.f3359e.setScaleX(a);
            this.f3354a.f3359e.setScaleY(a);
            if (VideoHomePillUIController.m3189h(this.f3354a) || VideoHomePillUIController.m3191k(this.f3354a)) {
                this.f3354a.f3359e.setAlpha(d);
            }
        }

        public final void m3182b(Spring spring) {
            if (VideoHomePillUIController.m3191k(this.f3354a)) {
                this.f3354a.f3362h = AnimationState.HIDDEN;
            } else if (VideoHomePillUIController.m3189h(this.f3354a)) {
                this.f3354a.f3362h = AnimationState.SHOWN;
            }
        }
    }

    /* compiled from: show_dismiss_button */
    public enum AnimationState {
        REVEALING,
        HIDING,
        SHOWN,
        HIDDEN
    }

    public static VideoHomePillUIController m3184a(InjectorLike injectorLike) {
        return new VideoHomePillUIController(SpringSystem.b(injectorLike));
    }

    @Inject
    public VideoHomePillUIController(SpringSystem springSystem) {
        this.f3356b = springSystem;
        this.f3357c = new Rect();
    }

    public static boolean m3185a(VideoHomePillUIController videoHomePillUIController, View view, MotionEvent motionEvent) {
        videoHomePillUIController.f3359e.getLocationOnScreen(videoHomePillUIController.f3358d);
        int i = videoHomePillUIController.f3358d[0];
        int i2 = videoHomePillUIController.f3358d[1];
        videoHomePillUIController.f3357c.set(i, i2, videoHomePillUIController.f3359e.getWidth() + i, videoHomePillUIController.f3359e.getHeight() + i2);
        boolean contains = videoHomePillUIController.f3357c.contains((int) motionEvent.getRawX(), (int) motionEvent.getRawY());
        switch (motionEvent.getAction()) {
            case 0:
            case 2:
                if (contains) {
                    videoHomePillUIController.m3186d();
                } else {
                    videoHomePillUIController.m3187e();
                }
                videoHomePillUIController.f3359e.setPressed(contains);
                break;
            case 1:
                if (contains) {
                    view.performClick();
                    break;
                }
                break;
            case 3:
                break;
        }
        videoHomePillUIController.m3187e();
        videoHomePillUIController.f3359e.setPressed(false);
        return true;
    }

    private void m3186d() {
        if (m3190i()) {
            this.f3360f.b(0.949999988079071d);
        }
    }

    private void m3187e() {
        if (m3190i()) {
            this.f3360f.b(1.0d);
        }
    }

    public final void m3192a() {
        m3188f();
    }

    private void m3188f() {
        if (!m3189h(this) && !m3190i()) {
            this.f3362h = AnimationState.REVEALING;
            this.f3360f.b(1.0d);
        }
    }

    public static boolean m3189h(VideoHomePillUIController videoHomePillUIController) {
        return AnimationState.REVEALING.equals(videoHomePillUIController.f3362h);
    }

    private boolean m3190i() {
        return AnimationState.SHOWN.equals(this.f3362h);
    }

    public static boolean m3191k(VideoHomePillUIController videoHomePillUIController) {
        return AnimationState.HIDING.equals(videoHomePillUIController.f3362h);
    }
}
