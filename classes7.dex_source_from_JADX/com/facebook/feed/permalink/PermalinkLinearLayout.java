package com.facebook.feed.permalink;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.facebook.common.ui.keyboard.SoftInputDetector;
import com.facebook.fbui.tinyclicks.MasterTouchDelegate;
import com.facebook.fbui.tinyclicks.widget.MasterTouchDelegateLayout;
import com.facebook.fbui.widget.layout.SegmentedLinearLayout;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import javax.inject.Inject;

/* compiled from: after_animation */
public class PermalinkLinearLayout extends SegmentedLinearLayout implements MasterTouchDelegateLayout {
    @Inject
    MasterTouchDelegate f19595a;
    @Inject
    SoftInputDetector f19596b;

    private static <T extends View> void m22899a(Class<T> cls, T t) {
        m22900a((Object) t, t.getContext());
    }

    private static void m22900a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((PermalinkLinearLayout) obj).m22898a(MasterTouchDelegate.b(fbInjector), SoftInputDetector.a(fbInjector));
    }

    private void m22898a(MasterTouchDelegate masterTouchDelegate, SoftInputDetector softInputDetector) {
        this.f19595a = masterTouchDelegate;
        this.f19596b = softInputDetector;
    }

    public PermalinkLinearLayout(Context context) {
        super(context);
        m22897a();
    }

    @TargetApi(11)
    public PermalinkLinearLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m22897a();
    }

    private void m22897a() {
        m22899a(PermalinkLinearLayout.class, (View) this);
        this.f19595a.a(this);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return this.f19595a.a(motionEvent);
    }

    protected void onAttachedToWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, 2037979392);
        super.onAttachedToWindow();
        this.f19595a.a();
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, -63666881, a);
    }

    protected void onDetachedFromWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, 1402920978);
        this.f19595a.b();
        super.onDetachedFromWindow();
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, 2019414754, a);
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
        this.f19595a.a(canvas);
    }

    protected void onMeasure(int i, int i2) {
        this.f19596b.a(this, i2);
        super.onMeasure(i, i2);
    }
}
