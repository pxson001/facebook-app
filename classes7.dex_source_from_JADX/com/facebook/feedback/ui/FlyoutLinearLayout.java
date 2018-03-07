package com.facebook.feedback.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.facebook.common.ui.keyboard.SoftInputDetector;
import com.facebook.fbui.widget.layout.SegmentedLinearLayout;
import com.facebook.inject.FbInjector;
import javax.inject.Inject;

/* compiled from: rows */
public class FlyoutLinearLayout extends SegmentedLinearLayout {
    @Inject
    public SoftInputDetector f4581a;

    private static <T extends View> void m5135a(Class<T> cls, T t) {
        m5136a((Object) t, t.getContext());
    }

    private static void m5136a(Object obj, Context context) {
        ((FlyoutLinearLayout) obj).f4581a = SoftInputDetector.a(FbInjector.get(context));
    }

    public FlyoutLinearLayout(Context context) {
        super(context);
        m5133a();
    }

    public FlyoutLinearLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m5133a();
    }

    private void m5133a() {
        m5135a(FlyoutLinearLayout.class, (View) this);
    }

    protected void onMeasure(int i, int i2) {
        this.f4581a.a(this, i2);
        super.onMeasure(i, i2);
    }

    private void m5134a(SoftInputDetector softInputDetector) {
        this.f4581a = softInputDetector;
    }
}
