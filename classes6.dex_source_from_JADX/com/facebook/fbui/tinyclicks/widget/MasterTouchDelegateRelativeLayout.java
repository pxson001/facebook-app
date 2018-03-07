package com.facebook.fbui.tinyclicks.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.facebook.fbui.tinyclicks.MasterTouchDelegate;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.widget.CustomRelativeLayout;

/* compiled from: next_eligible_fetch_time */
public class MasterTouchDelegateRelativeLayout extends CustomRelativeLayout implements MasterTouchDelegateLayout {
    private MasterTouchDelegate f10037a;

    public MasterTouchDelegateRelativeLayout(Context context) {
        super(context);
        m15723a(context);
    }

    public MasterTouchDelegateRelativeLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m15723a(context);
    }

    public MasterTouchDelegateRelativeLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m15723a(context);
    }

    private void m15723a(Context context) {
        this.f10037a = MasterTouchDelegate.m15707b(FbInjector.get(context));
        this.f10037a.m15712a((MasterTouchDelegateLayout) this);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return this.f10037a.m15713a(motionEvent);
    }

    protected void onAttachedToWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, 1364286139);
        super.onAttachedToWindow();
        this.f10037a.m15710a();
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, -744791117, a);
    }

    protected void onDetachedFromWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, -1053725515);
        this.f10037a.m15714b();
        super.onDetachedFromWindow();
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, -1826720726, a);
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
        this.f10037a.m15711a(canvas);
    }
}
