package com.facebook.widget.viewpager;

import android.content.Context;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.AttributeSet;
import com.facebook.widget.CustomViewPager;

/* compiled from: share_error_title */
public class ViewPagerWithCompositeOnPageChangeListener extends CustomViewPager {
    private CompositeOnPageChangeListener f3574a;

    public ViewPagerWithCompositeOnPageChangeListener(Context context) {
        super(context);
        m3372g();
    }

    public ViewPagerWithCompositeOnPageChangeListener(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m3372g();
    }

    private void m3372g() {
        this.f3574a = new CompositeOnPageChangeListener();
        super.setOnPageChangeListener(this.f3574a);
    }

    public void setOnPageChangeListener(OnPageChangeListener onPageChangeListener) {
        if (onPageChangeListener != null) {
            this.f3574a.f3566a.add(onPageChangeListener);
        }
    }
}
