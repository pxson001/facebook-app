package com.facebook.feed.permalink;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.facebook.common.ui.keyboard.SoftInputDetector;
import com.facebook.fbui.tinyclicks.MasterTouchDelegate;
import com.facebook.fbui.tinyclicks.widget.MasterTouchDelegateLayout;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.widget.CustomRelativeLayout;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: aeb204b5f0bbd266771ae5263f904f33 */
public class PermalinkRelativeLayout extends CustomRelativeLayout implements MasterTouchDelegateLayout {
    @Inject
    MasterTouchDelegate f19639a;
    @Inject
    SoftInputDetector f19640b;

    private static <T extends View> void m22909a(Class<T> cls, T t) {
        m22910a((Object) t, t.getContext());
    }

    private static void m22910a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((PermalinkRelativeLayout) obj).m22908a(MasterTouchDelegate.b(fbInjector), SoftInputDetector.a(fbInjector));
    }

    private void m22908a(MasterTouchDelegate masterTouchDelegate, SoftInputDetector softInputDetector) {
        this.f19639a = masterTouchDelegate;
        this.f19640b = softInputDetector;
    }

    public PermalinkRelativeLayout(Context context) {
        super(context);
        m22907a();
    }

    public PermalinkRelativeLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        m22907a();
    }

    public PermalinkRelativeLayout(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m22907a();
    }

    private void m22907a() {
        m22909a(PermalinkRelativeLayout.class, (View) this);
        this.f19639a.a(this);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return this.f19639a.a(motionEvent);
    }

    protected void onAttachedToWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, 314661262);
        super.onAttachedToWindow();
        this.f19639a.a();
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, 816673642, a);
    }

    protected void onDetachedFromWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, -456450308);
        this.f19639a.b();
        super.onDetachedFromWindow();
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, 1233854845, a);
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
        this.f19639a.a(canvas);
    }

    protected void onMeasure(int i, int i2) {
        this.f19640b.a(this, i2);
        super.onMeasure(i, i2);
    }
}
