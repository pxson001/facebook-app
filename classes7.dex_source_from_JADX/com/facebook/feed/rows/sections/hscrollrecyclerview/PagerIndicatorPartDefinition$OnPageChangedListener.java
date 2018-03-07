package com.facebook.feed.rows.sections.hscrollrecyclerview;

import com.facebook.feed.rows.core.persistence.PageIndicatorCurrentPositionState;
import com.facebook.widget.viewpageindicator.HScrollCirclePageIndicator.ScrollState;

/* compiled from: show_text */
public class PagerIndicatorPartDefinition$OnPageChangedListener {
    public int f3709a;
    public int f3710b;
    public int f3711c;
    public RowViewPagerIndicator f3712d;
    public PageIndicatorCurrentPositionState f3713e;

    public final void m4405a(int i, int i2) {
        int i3 = this.f3709a;
        this.f3709a = i;
        this.f3710b = i2;
        if (this.f3713e != null) {
            int i4 = this.f3713e.a;
            PagerIndicatorPartDefinition.a(this.f3712d, i4, PagerIndicatorPartDefinition.b(i3, i4, this.f3709a, this.f3711c), this.f3709a, this.f3710b, this.f3711c, this.f3713e);
            RowViewPagerIndicator rowViewPagerIndicator = this.f3712d;
            ScrollState scrollState = ScrollState.Scrolled;
            if (rowViewPagerIndicator != null) {
                rowViewPagerIndicator.f3728b.v = scrollState;
            }
        }
    }
}
