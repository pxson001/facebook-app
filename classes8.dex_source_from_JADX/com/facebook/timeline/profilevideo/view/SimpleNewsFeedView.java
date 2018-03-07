package com.facebook.timeline.profilevideo.view;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.MotionEvent;

/* compiled from: mFeedUnitShowSuggestifierFooter */
public class SimpleNewsFeedView extends RecyclerView {
    private LinearLayoutManager f9514h;

    public SimpleNewsFeedView(Context context) {
        super(context);
        m11207m();
    }

    public SimpleNewsFeedView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m11207m();
    }

    public SimpleNewsFeedView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m11207m();
    }

    private void m11207m() {
        this.v = true;
        this.f9514h = new LinearLayoutManager(getContext());
        setLayoutManager(this.f9514h);
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return true;
    }

    public final void m11208l() {
        if (getChildCount() != 0) {
            scrollBy(0, (int) (((double) getChildAt(0).getHeight()) * 0.5d));
        }
    }
}
