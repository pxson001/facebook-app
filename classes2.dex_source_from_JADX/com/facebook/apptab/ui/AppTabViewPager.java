package com.facebook.apptab.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.facebook.inject.FbInjector;
import com.facebook.widget.CustomViewPager;
import javax.inject.Inject;

/* compiled from: rtt_decay_constant */
public class AppTabViewPager extends CustomViewPager {
    public FbHeaderLayoutManager f6371a;

    private static <T extends View> void m10767a(Class<T> cls, T t) {
        m10768a((Object) t, t.getContext());
    }

    private static void m10768a(Object obj, Context context) {
        ((AppTabViewPager) obj).f6371a = FbHeaderLayoutManager.m6588a(FbInjector.get(context));
    }

    public AppTabViewPager(Context context) {
        super(context);
        m10769g();
    }

    public AppTabViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m10769g();
    }

    @Inject
    private void m10766a(FbHeaderLayoutManager fbHeaderLayoutManager) {
        this.f6371a = fbHeaderLayoutManager;
    }

    private void m10769g() {
        m10767a(AppTabViewPager.class, (View) this);
    }

    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, this.f6371a.m6589a(i2));
    }

    public final void mo1482b(int i, boolean z) {
        throw new UnsupportedOperationException("Since this class dynamically adjusts to the height of the title bar, manually setting the height is not supported.");
    }

    protected final boolean mo1481a(float f, float f2) {
        return false;
    }
}
