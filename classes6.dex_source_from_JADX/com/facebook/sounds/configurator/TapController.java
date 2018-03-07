package com.facebook.sounds.configurator;

import android.content.Context;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewConfiguration;
import com.facebook.sounds.configurator.SpringTextView.AnimStates;
import com.facebook.sounds.configurator.SpringTextView.PressListener;
import com.facebook.sounds.configurator.TextButton.OnLongPressListener;
import com.facebook.sounds.configurator.TextButton.TapControllerListener;

/* compiled from: event_members.count */
public class TapController {
    public static final int f16032a = ViewConfiguration.getLongPressTimeout();
    private View f16033b;
    public GestureDetector f16034c;
    public boolean f16035d = true;
    public TapControllerListener f16036e;
    public PressListener f16037f;
    public OnLongPressListener f16038g;
    public boolean f16039h;
    public boolean f16040i;
    public boolean f16041j = false;

    /* compiled from: event_members.count */
    class OnGestureListener extends SimpleOnGestureListener {
        final /* synthetic */ TapController f16030a;

        public OnGestureListener(TapController tapController) {
            this.f16030a = tapController;
        }

        public boolean onDown(MotionEvent motionEvent) {
            if (this.f16030a.f16037f != null) {
                SpringTextView springTextView = this.f16030a.f16037f.f16022a;
                if (!springTextView.f16029f.equals(AnimStates.PRESSING)) {
                    springTextView.f16029f = AnimStates.PRESSING;
                    springTextView.f16027d.m23050a(springTextView.f16025b);
                    springTextView.f16027d.m23053b(0.8d);
                }
            }
            this.f16030a.f16039h = true;
            return true;
        }

        public boolean onSingleTapUp(MotionEvent motionEvent) {
            this.f16030a.f16039h = false;
            this.f16030a.f16040i = false;
            if (this.f16030a.f16037f != null) {
                this.f16030a.f16037f.m23656b();
            }
            if (this.f16030a.f16036e == null) {
                return false;
            }
            TapControllerListener tapControllerListener = this.f16030a.f16036e;
            motionEvent.getX();
            motionEvent.getY();
            tapControllerListener.m23662a();
            return true;
        }

        public void onLongPress(MotionEvent motionEvent) {
            if (this.f16030a.f16039h && this.f16030a.f16038g != null) {
                this.f16030a.f16039h = false;
                TapController.m23661b(this.f16030a);
            }
        }
    }

    /* compiled from: event_members.count */
    class ViewOnTouchListener implements OnTouchListener {
        final /* synthetic */ TapController f16031a;

        public ViewOnTouchListener(TapController tapController) {
            this.f16031a = tapController;
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (!this.f16031a.f16035d) {
                return false;
            }
            if (this.f16031a.f16034c.onTouchEvent(motionEvent)) {
                return true;
            }
            if (motionEvent.getAction() == 3 || motionEvent.getAction() == 1) {
                if (this.f16031a.f16037f != null) {
                    this.f16031a.f16037f.m23656b();
                }
                if (!(this.f16031a.f16040i || this.f16031a.f16036e == null || !TapController.m23660a(this.f16031a, motionEvent) || this.f16031a.f16041j)) {
                    TapControllerListener tapControllerListener = this.f16031a.f16036e;
                    motionEvent.getX();
                    motionEvent.getY();
                    tapControllerListener.m23662a();
                }
                this.f16031a.f16040i = false;
                return true;
            }
            long eventTime = motionEvent.getEventTime() - motionEvent.getDownTime();
            if (!this.f16031a.f16039h || eventTime < ((long) TapController.f16032a)) {
                return true;
            }
            this.f16031a.f16039h = false;
            if (!this.f16031a.f16034c.isLongpressEnabled() || !TapController.m23660a(this.f16031a, motionEvent)) {
                return true;
            }
            TapController.m23661b(this.f16031a);
            return true;
        }
    }

    public TapController(Context context, View view) {
        this.f16033b = view;
        this.f16033b.setOnTouchListener(new ViewOnTouchListener(this));
        this.f16034c = new GestureDetector(context, new OnGestureListener(this));
        this.f16034c.setIsLongpressEnabled(false);
        this.f16034c.setOnDoubleTapListener(null);
    }

    public static boolean m23660a(TapController tapController, MotionEvent motionEvent) {
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        View view = tapController.f16033b;
        return x >= 0.0f && x <= ((float) view.getWidth()) && y >= 0.0f && y <= ((float) view.getHeight());
    }

    public static void m23661b(TapController tapController) {
        if (tapController.f16038g != null) {
            tapController.f16040i = true;
        }
    }
}
