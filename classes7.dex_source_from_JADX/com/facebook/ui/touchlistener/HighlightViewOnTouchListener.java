package com.facebook.ui.touchlistener;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import com.facebook.fbui.widget.contentview.ContentView;

/* compiled from: enabled_bump_all_unseen */
public class HighlightViewOnTouchListener implements OnTouchListener {
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if ((view instanceof ContentView) || !(view instanceof ViewGroup)) {
            HighlightViewUtil.m19321a(view, motionEvent.getAction());
        } else {
            HighlightViewUtil.m19323a((ViewGroup) view, motionEvent.getAction());
        }
        return false;
    }
}
