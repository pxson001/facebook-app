package com.facebook.common.ui.util;

import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.TouchDelegate;
import android.view.View;

/* compiled from: should_auto_submit */
public class CompoundTouchDelegate extends TouchDelegate {
    private final TouchDelegate[] f2757a;

    public CompoundTouchDelegate(View view, TouchDelegate... touchDelegateArr) {
        super(new Rect(), view);
        this.f2757a = touchDelegateArr;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        for (TouchDelegate onTouchEvent : this.f2757a) {
            if (onTouchEvent.onTouchEvent(motionEvent)) {
                return true;
            }
        }
        return false;
    }
}
