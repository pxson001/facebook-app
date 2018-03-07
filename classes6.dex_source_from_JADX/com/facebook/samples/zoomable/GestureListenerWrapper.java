package com.facebook.samples.zoomable;

import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;

/* compiled from: setHideKeyboardIfReachedMinimumHeight */
public class GestureListenerWrapper extends SimpleOnGestureListener {
    public SimpleOnGestureListener f4830a = new SimpleOnGestureListener();

    public void onLongPress(MotionEvent motionEvent) {
        this.f4830a.onLongPress(motionEvent);
    }

    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        return this.f4830a.onScroll(motionEvent, motionEvent2, f, f2);
    }

    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        return this.f4830a.onFling(motionEvent, motionEvent2, f, f2);
    }

    public void onShowPress(MotionEvent motionEvent) {
        this.f4830a.onShowPress(motionEvent);
    }

    public boolean onDown(MotionEvent motionEvent) {
        return this.f4830a.onDown(motionEvent);
    }

    public boolean onDoubleTap(MotionEvent motionEvent) {
        return this.f4830a.onDoubleTap(motionEvent);
    }

    public boolean onDoubleTapEvent(MotionEvent motionEvent) {
        return this.f4830a.onDoubleTapEvent(motionEvent);
    }

    public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
        return this.f4830a.onSingleTapConfirmed(motionEvent);
    }

    public boolean onSingleTapUp(MotionEvent motionEvent) {
        return this.f4830a.onSingleTapUp(motionEvent);
    }
}
