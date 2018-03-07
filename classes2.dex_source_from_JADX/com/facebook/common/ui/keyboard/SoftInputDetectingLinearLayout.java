package com.facebook.common.ui.keyboard;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.facebook.inject.FbInjector;
import com.facebook.widget.CustomLinearLayout;
import javax.inject.Inject;

/* compiled from: rtc_hw_video_support */
public class SoftInputDetectingLinearLayout extends CustomLinearLayout {
    @Inject
    public SoftInputDetector f6445a;

    private static <T extends View> void m11171a(Class<T> cls, T t) {
        m11172a((Object) t, t.getContext());
    }

    private static void m11172a(Object obj, Context context) {
        ((SoftInputDetectingLinearLayout) obj).f6445a = SoftInputDetector.m11173a(FbInjector.get(context));
    }

    public SoftInputDetectingLinearLayout(Context context) {
        super(context);
        m11169a();
    }

    public SoftInputDetectingLinearLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m11169a();
    }

    private void m11169a() {
        m11171a(SoftInputDetectingLinearLayout.class, (View) this);
    }

    protected void onMeasure(int i, int i2) {
        this.f6445a.m11176a(this, i2);
        super.onMeasure(i, i2);
    }

    private void m11170a(SoftInputDetector softInputDetector) {
        this.f6445a = softInputDetector;
    }
}
