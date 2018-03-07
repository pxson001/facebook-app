package com.facebook.backstage.camera;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.facebook.backstage.ui.SpringTextView;
import com.facebook.backstage.util.Bouncy3Conversion;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.rebound.SimpleSpringListener;
import com.facebook.rebound.Spring;
import com.facebook.rebound.SpringConfig;
import com.facebook.rebound.SpringSystem;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;

/* compiled from: searchUsersMethod */
public class CaptureButton extends SpringTextView {
    private final SpringConfig f4391a;
    private final SpringConfig f4392b;
    private final Spring f4393c;
    private final Drawable f4394d;
    private final Drawable f4395e;
    public final Handler f4396f;
    public final Runnable f4397g;
    public AnimStates f4398h;
    public CaptureState f4399i;
    @Nullable
    public CaptureButtonListener f4400j;

    /* compiled from: searchUsersMethod */
    public interface CaptureButtonListener {
        void mo146a();

        void mo147b();

        void mo148c();
    }

    /* compiled from: searchUsersMethod */
    class C04121 implements Runnable {
        final /* synthetic */ CaptureButton f4381a;

        C04121(CaptureButton captureButton) {
            this.f4381a = captureButton;
        }

        public void run() {
            this.f4381a.f4399i = CaptureState.VIDEO;
            if (this.f4381a.f4400j != null) {
                this.f4381a.f4400j.mo147b();
            }
        }
    }

    /* compiled from: searchUsersMethod */
    class C04132 implements OnTouchListener {
        final /* synthetic */ CaptureButton f4382a;

        C04132(CaptureButton captureButton) {
            this.f4382a = captureButton;
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            switch (motionEvent.getAction()) {
                case 0:
                    this.f4382a.f4399i = CaptureState.PHOTO;
                    this.f4382a.f4398h = AnimStates.NONE;
                    HandlerDetour.a(this.f4382a.f4396f, this.f4382a.f4397g);
                    HandlerDetour.b(this.f4382a.f4396f, this.f4382a.f4397g, 200, -1870237387);
                    this.f4382a.f4396f;
                    return true;
                case 1:
                    HandlerDetour.a(this.f4382a.f4396f, this.f4382a.f4397g);
                    this.f4382a.f4397g;
                    return true;
                default:
                    return false;
            }
        }
    }

    /* compiled from: searchUsersMethod */
    enum AnimStates {
        NONE,
        PRESSING,
        UNPRESSING
    }

    /* compiled from: searchUsersMethod */
    enum CaptureState {
        PHOTO,
        VIDEO
    }

    /* compiled from: searchUsersMethod */
    class SpringListener extends SimpleSpringListener {
        final /* synthetic */ CaptureButton f4384a;

        public SpringListener(CaptureButton captureButton) {
            this.f4384a = captureButton;
        }

        public final void m4393a(Spring spring) {
            float b = (float) spring.b();
            this.f4384a.setScaleX(b);
            this.f4384a.setScaleY(b);
        }

        public final void m4392a() {
            this.f4384a.f4398h = AnimStates.NONE;
        }
    }

    public CaptureButton(Context context) {
        this(context, null);
    }

    public CaptureButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CaptureButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f4396f = new Handler();
        this.f4397g = new C04121(this);
        this.f4398h = AnimStates.NONE;
        this.f4399i = CaptureState.PHOTO;
        Resources resources = context.getResources();
        this.f4394d = resources.getDrawable(2130841138);
        this.f4395e = resources.getDrawable(2130841137);
        setPressedColour(false);
        this.f4388d.f5513a.setIsLongpressEnabled(true);
        Bouncy3Conversion bouncy3Conversion = new Bouncy3Conversion(20.0d, 0.0d);
        this.f4391a = SpringConfig.a(bouncy3Conversion.f5563a, bouncy3Conversion.f5564b);
        bouncy3Conversion = new Bouncy3Conversion(5.0d, 10.0d);
        this.f4392b = SpringConfig.a(bouncy3Conversion.f5563a, bouncy3Conversion.f5564b);
        this.f4393c = SpringSystem.b().a().a(new SpringListener(this)).a(this.f4391a).a(1.0d);
        setOnTouchListener(new C04132(this));
    }

    public final void m4404a() {
        HandlerDetour.a(this.f4396f, this.f4397g);
    }

    public static void m4398b(CaptureButton captureButton) {
        captureButton.m4401d();
        switch (captureButton.f4399i) {
            case PHOTO:
                if (captureButton.f4400j != null) {
                    captureButton.f4400j.mo146a();
                    return;
                }
                return;
            case VIDEO:
                if (captureButton.f4400j != null) {
                    captureButton.f4400j.mo148c();
                    return;
                }
                return;
            default:
                return;
        }
    }

    public void setCaptureListener(CaptureButtonListener captureButtonListener) {
        this.f4400j = captureButtonListener;
    }

    private void setPressedColour(boolean z) {
        if (z) {
            setBackground(this.f4394d);
        } else {
            setBackground(this.f4395e);
        }
    }

    public static void m4400c(CaptureButton captureButton) {
        if (!captureButton.f4398h.equals(AnimStates.PRESSING)) {
            captureButton.setPressedColour(true);
            captureButton.f4398h = AnimStates.PRESSING;
            captureButton.f4393c.a(captureButton.f4391a);
            captureButton.f4393c.b(0.85d);
        }
    }

    private void m4401d() {
        if (!this.f4398h.equals(AnimStates.UNPRESSING)) {
            setPressedColour(false);
            this.f4398h = AnimStates.UNPRESSING;
            this.f4393c.a(this.f4392b);
            this.f4393c.b(1.0d).c(8.0d);
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int a = Logger.a(2, EntryType.UI_INPUT_START, 1837232195);
        boolean onTouchEvent = isEnabled() ? super.onTouchEvent(motionEvent) : true;
        LogUtils.a(-417582547, a);
        return onTouchEvent;
    }
}
