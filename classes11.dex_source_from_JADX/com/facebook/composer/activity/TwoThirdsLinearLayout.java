package com.facebook.composer.activity;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import com.facebook.device.ScreenUtil;
import com.facebook.inject.FbInjector;
import com.facebook.widget.CustomLinearLayout;
import javax.inject.Inject;

/* compiled from: inline_sprouts_state */
public class TwoThirdsLinearLayout extends CustomLinearLayout {
    @Inject
    public ScreenUtil f6228a;

    private static <T extends View> void m7704a(Class<T> cls, T t) {
        m7705a((Object) t, t.getContext());
    }

    private static void m7705a(Object obj, Context context) {
        ((TwoThirdsLinearLayout) obj).f6228a = ScreenUtil.a(FbInjector.get(context));
    }

    public TwoThirdsLinearLayout(Context context) {
        super(context);
        m7702a();
    }

    public TwoThirdsLinearLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m7702a();
    }

    public TwoThirdsLinearLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m7702a();
    }

    private void m7702a() {
        m7704a(TwoThirdsLinearLayout.class, (View) this);
    }

    protected void onMeasure(int i, int i2) {
        super.onMeasure(MeasureSpec.makeMeasureSpec(this.f6228a.c(), 1073741824), MeasureSpec.makeMeasureSpec((this.f6228a.d() * 2) / 3, 1073741824));
    }

    private void m7703a(ScreenUtil screenUtil) {
        this.f6228a = screenUtil;
    }
}
