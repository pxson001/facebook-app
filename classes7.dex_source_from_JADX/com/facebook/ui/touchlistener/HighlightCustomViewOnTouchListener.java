package com.facebook.ui.touchlistener;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

/* compiled from: enabled_ui_features */
public class HighlightCustomViewOnTouchListener implements OnTouchListener {
    private final View f15316a;

    public HighlightCustomViewOnTouchListener(View view) {
        this.f15316a = view;
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        HighlightViewUtil.m19321a(this.f15316a, motionEvent.getAction());
        return false;
    }
}
