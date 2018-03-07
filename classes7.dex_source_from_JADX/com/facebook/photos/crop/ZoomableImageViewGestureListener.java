package com.facebook.photos.crop;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import javax.annotation.Nullable;

/* compiled from: live_feedback_input_is_reactions_tap_nux_shown */
public class ZoomableImageViewGestureListener implements OnTouchListener {
    private final OnTouchCallback f10087a;
    private final OnTouchCallback f10088b = new C08491(this);
    private ProfilePicZoomableImageView f10089c;
    private float f10090d;
    private float f10091e;
    private float f10092f;

    /* compiled from: live_feedback_input_is_reactions_tap_nux_shown */
    public interface OnTouchCallback {
        void mo546a();
    }

    /* compiled from: live_feedback_input_is_reactions_tap_nux_shown */
    class C08491 implements OnTouchCallback {
        final /* synthetic */ ZoomableImageViewGestureListener f10086a;

        C08491(ZoomableImageViewGestureListener zoomableImageViewGestureListener) {
            this.f10086a = zoomableImageViewGestureListener;
        }

        public final void mo546a() {
        }
    }

    public ZoomableImageViewGestureListener(ProfilePicZoomableImageView profilePicZoomableImageView, @Nullable OnTouchCallback onTouchCallback) {
        this.f10089c = profilePicZoomableImageView;
        if (onTouchCallback == null) {
            onTouchCallback = this.f10088b;
        }
        this.f10087a = onTouchCallback;
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        int i = 0;
        switch (motionEvent.getAction() & 255) {
            case 0:
                m11980a(1, 0, 0, motionEvent);
                this.f10087a.mo546a();
                break;
            case 2:
                float y;
                float x = motionEvent.getPointerCount() == 1 ? motionEvent.getX(0) : m11978a(motionEvent.getX(0), motionEvent.getX(1));
                if (motionEvent.getPointerCount() == 1) {
                    y = motionEvent.getY(0);
                } else {
                    y = m11978a(motionEvent.getY(0), motionEvent.getY(1));
                }
                this.f10089c.m11974a(x - this.f10090d, y - this.f10091e);
                if (motionEvent.getPointerCount() > 1) {
                    float a = m11979a(motionEvent.getX(0), motionEvent.getY(0), motionEvent.getX(1), motionEvent.getY(1));
                    this.f10089c.m11975a(a / this.f10092f, x, y);
                    this.f10092f = a;
                }
                this.f10090d = x;
                this.f10091e = y;
                this.f10087a.mo546a();
                break;
            case 5:
                m11980a(2, 0, 1, motionEvent);
                this.f10087a.mo546a();
                break;
            case 6:
                int actionIndex = motionEvent.getActionIndex();
                if (motionEvent.getPointerCount() == 2) {
                    m11980a(1, actionIndex == 0 ? 1 : 0, 0, motionEvent);
                } else {
                    if (actionIndex == 0) {
                        i = 1;
                    }
                    if (actionIndex == 1 || i == 1) {
                        actionIndex = 2;
                    } else {
                        actionIndex = 1;
                    }
                    m11980a(2, i, actionIndex, motionEvent);
                }
                this.f10087a.mo546a();
                break;
        }
        return true;
    }

    private void m11980a(int i, int i2, int i3, MotionEvent motionEvent) {
        if (i == 1) {
            this.f10090d = motionEvent.getX(i2);
            this.f10091e = motionEvent.getY(i2);
        } else if (i == 2) {
            this.f10090d = m11978a(motionEvent.getX(i2), motionEvent.getX(i3));
            this.f10091e = m11978a(motionEvent.getY(i2), motionEvent.getY(i3));
            this.f10092f = m11979a(motionEvent.getX(i2), motionEvent.getY(i2), motionEvent.getX(i3), motionEvent.getY(i3));
        }
    }

    private static float m11978a(float f, float f2) {
        return (f + f2) / 2.0f;
    }

    private static float m11979a(float f, float f2, float f3, float f4) {
        return (float) Math.sqrt(Math.pow((double) (f - f3), 2.0d) + Math.pow((double) (f2 - f4), 2.0d));
    }
}
