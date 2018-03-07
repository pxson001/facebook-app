package com.facebook.timeline.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import com.facebook.timeline.TimelineFragment.C15108;
import com.facebook.widget.CustomRelativeLayout;
import javax.annotation.Nullable;

/* compiled from: extra_instant_shopping_product_view */
public class TimelineFragmentView extends CustomRelativeLayout {
    public C15108 f12750a;

    public TimelineFragmentView(Context context) {
        this(context, null);
    }

    private TimelineFragmentView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private TimelineFragmentView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setContentView(2130907449);
    }

    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.f12750a != null) {
            C15108 c15108 = this.f12750a;
            if (c15108.f10232a.cb != null) {
                c15108.f10232a.cb.mo526a(c15108.f10232a.cg, c15108.f10232a.bt);
            }
            c15108.f10232a.cv.m11439a();
        }
    }
}
