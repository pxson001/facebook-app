package com.facebook.redspace.pagerindicator;

import android.support.v4.view.ViewPager.PageTransformer;
import android.view.View;
import com.facebook.common.util.FindViewUtil;
import com.facebook.common.util.MathUtil;

/* compiled from: PageIdentityPhotosCardView */
public class SwipeImagePageTransformer implements PageTransformer {
    public final void m12605a(View view, float f) {
        BadgableDraweeView badgableDraweeView = (BadgableDraweeView) FindViewUtil.b(view, 2131568441);
        float f2 = 1.0f;
        if (f > -1.0f && f < 1.0f) {
            f2 = 1.0f + (Math.abs(Math.abs(f) - 1.0f) * 0.3f);
        }
        float f3 = f2;
        badgableDraweeView.setScaleX(f3);
        badgableDraweeView.setScaleY(f3);
        badgableDraweeView.setDimValue(MathUtil.b(Math.abs((f * 1.0f) / 1.0f), 0.0f, 1.0f));
    }
}
