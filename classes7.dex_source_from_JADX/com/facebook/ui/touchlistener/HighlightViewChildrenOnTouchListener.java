package com.facebook.ui.touchlistener;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import com.facebook.fbui.widget.layout.ImageBlockLayout;

/* compiled from: enabled_nsp_bump */
public class HighlightViewChildrenOnTouchListener implements OnTouchListener {
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                HighlightViewUtil.m19321a(viewGroup.getChildAt(i), motionEvent.getAction());
            }
            if (view instanceof ImageBlockLayout) {
                HighlightViewUtil.m19325a((ImageBlockLayout) view, motionEvent.getAction());
            }
        }
        return false;
    }
}
