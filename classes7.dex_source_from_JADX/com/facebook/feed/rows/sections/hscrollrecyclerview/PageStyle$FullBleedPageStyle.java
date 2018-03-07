package com.facebook.feed.rows.sections.hscrollrecyclerview;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.FrameLayout;
import com.facebook.common.util.SizeUtil;

/* compiled from: show_tooltips */
class PageStyle$FullBleedPageStyle extends PageStyle {
    private final float f3704b;
    private final boolean f3705c;
    private final boolean f3706d;
    private int f3707e = -1;
    private int f3708f = -1;

    public PageStyle$FullBleedPageStyle(float f, boolean z, boolean z2) {
        this.f3704b = f;
        this.f3705c = z;
        this.f3706d = z2;
    }

    public final void m4401a(View view) {
        m4397b(view.getContext());
        if (this.f3706d) {
            PageStyle.a(view, this.f3707e);
        } else if (view instanceof HasPageStyle) {
            ((HasPageStyle) view).setWidth(this.f3707e);
        }
    }

    public final void m4402a(View view, int i, int i2) {
        if (view instanceof HasPageStyle) {
            ((HasPageStyle) view).a(this.f3707e, false, this.f3705c);
        }
    }

    public final void m4399a(ViewPager viewPager) {
        viewPager.setPageMargin(SizeUtil.a(viewPager.getContext(), 8.0f));
    }

    public final void m4404b(View view) {
        if (view instanceof FrameLayout) {
            m4397b(view.getContext());
            m4396a(view.getContext());
            ((FrameLayout) view).getChildAt(0).setBackgroundResource(0);
            if (view instanceof HasPageStyle) {
                ((HasPageStyle) view).a(this.f3707e, true, this.f3705c);
                return;
            }
            return;
        }
        throw new UnsupportedOperationException("This style requires an extra wrapping FrameLayout to work");
    }

    public final void m4400a(RecyclerView recyclerView) {
        m4397b(recyclerView.getContext());
        m4396a(recyclerView.getContext());
    }

    public final float m4398a(int i, int i2) {
        return 1.0f;
    }

    private void m4396a(Context context) {
        if (this.f3708f == -1) {
            this.f3708f = SizeUtil.a(context, 8.0f) / 2;
        }
    }

    private void m4397b(Context context) {
        if (this.f3707e == -1) {
            this.f3707e = SizeUtil.a(context, this.f3704b);
        }
    }

    public final int m4403b() {
        if (this.f3707e != -1) {
            return this.f3707e;
        }
        throw new IllegalStateException("getPageWidthPixelsForRecyclerView() must be called after applyToRecyclerView()");
    }
}
