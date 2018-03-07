package com.facebook.adsexperiencetool.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.facebook.widget.listview.BetterListView;

/* compiled from: enable_snapshot_log */
public class NonInteractableAdsPreviewView extends BetterListView {
    public NonInteractableAdsPreviewView(Context context) {
        this(context, null);
    }

    public NonInteractableAdsPreviewView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NonInteractableAdsPreviewView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return true;
    }
}
