package com.facebook.fbui.tinyclicks.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.facebook.fbui.tinyclicks.MasterTouchDelegate;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.widget.CustomFrameLayout;

/* compiled from: nick_names */
public class MasterTouchDelegateFrameLayout extends CustomFrameLayout implements MasterTouchDelegateLayout {
    public MasterTouchDelegate f10036a;

    public MasterTouchDelegateFrameLayout(Context context) {
        super(context);
        m15722a(context);
    }

    public MasterTouchDelegateFrameLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MasterTouchDelegateFrameLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m15722a(context);
    }

    private void m15722a(Context context) {
        this.f10036a = MasterTouchDelegate.m15707b(FbInjector.get(context));
        this.f10036a.m15712a((MasterTouchDelegateLayout) this);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return this.f10036a.m15713a(motionEvent);
    }

    protected void onAttachedToWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, -1738617753);
        super.onAttachedToWindow();
        this.f10036a.m15710a();
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, -86386084, a);
    }

    protected void onDetachedFromWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, 267550113);
        this.f10036a.m15714b();
        super.onDetachedFromWindow();
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, 77972917, a);
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
        this.f10036a.m15711a(canvas);
    }

    public MasterTouchDelegate getMasterTouchDelegate() {
        return this.f10036a;
    }
}
