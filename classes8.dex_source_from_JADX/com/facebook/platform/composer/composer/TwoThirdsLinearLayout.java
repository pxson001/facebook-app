package com.facebook.platform.composer.composer;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import com.facebook.device.ScreenUtil;
import com.facebook.inject.FbInjector;
import com.facebook.widget.CustomLinearLayout;
import javax.inject.Inject;

/* compiled from: rich_document_first_layout */
public class TwoThirdsLinearLayout extends CustomLinearLayout {
    @Inject
    public ScreenUtil f4141a;

    private static <T extends View> void m4103a(Class<T> cls, T t) {
        m4104a((Object) t, t.getContext());
    }

    private static void m4104a(Object obj, Context context) {
        ((TwoThirdsLinearLayout) obj).f4141a = ScreenUtil.a(FbInjector.get(context));
    }

    public TwoThirdsLinearLayout(Context context) {
        super(context);
        m4101a();
    }

    public TwoThirdsLinearLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m4101a();
    }

    public TwoThirdsLinearLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m4101a();
    }

    private void m4101a() {
        m4103a(TwoThirdsLinearLayout.class, (View) this);
    }

    protected void onMeasure(int i, int i2) {
        super.onMeasure(MeasureSpec.makeMeasureSpec(this.f4141a.c(), 1073741824), MeasureSpec.makeMeasureSpec((this.f4141a.d() * 2) / 3, 1073741824));
    }

    private void m4102a(ScreenUtil screenUtil) {
        this.f4141a = screenUtil;
    }
}
