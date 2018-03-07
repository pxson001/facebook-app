package com.facebook.backstage.util;

import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;

/* compiled from: resultsUpdated called while mSearchResultsAdapter is null */
public class BetterGestureListener extends SimpleOnGestureListener {
    private static final String f5085a = BetterGestureListener.class.getSimpleName();
    public boolean f5086b = false;
    public boolean f5087c;
    private boolean f5088d = false;
    public TouchEventState f5089e = TouchEventState.ON_UP;

    /* compiled from: resultsUpdated called while mSearchResultsAdapter is null */
    public enum TouchEventState {
        ON_DOWN,
        ON_LONG_PRESS,
        ON_MULTI_TOUCH_DOWN,
        ON_MOVE,
        ON_FLING,
        ON_UP
    }

    public BetterGestureListener() {
        mo210e();
    }

    final boolean m4884c() {
        return this.f5088d;
    }

    final boolean m4885d() {
        return this.f5086b;
    }

    public void mo185a(MotionEvent motionEvent, float f, float f2) {
        this.f5089e = TouchEventState.ON_MOVE;
    }

    public void mo184a(MotionEvent motionEvent) {
        this.f5089e = TouchEventState.ON_UP;
    }

    public void mo195b(MotionEvent motionEvent) {
        this.f5089e = TouchEventState.ON_MULTI_TOUCH_DOWN;
    }

    public boolean onDown(MotionEvent motionEvent) {
        this.f5089e = TouchEventState.ON_DOWN;
        mo210e();
        return true;
    }

    public void onLongPress(MotionEvent motionEvent) {
        this.f5089e = TouchEventState.ON_LONG_PRESS;
        this.f5087c = true;
    }

    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        this.f5089e = TouchEventState.ON_FLING;
        this.f5088d = true;
        return true;
    }

    public static void m4879c(MotionEvent motionEvent) {
        new StringBuilder().append("onUnknown: ").append(motionEvent.getAction()).append(" ").append(motionEvent.getAction() & -65281);
    }

    private void mo210e() {
        this.f5088d = false;
        this.f5087c = false;
    }
}
