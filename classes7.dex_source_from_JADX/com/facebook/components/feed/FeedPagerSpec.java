package com.facebook.components.feed;

import com.facebook.components.ComponentContext;
import com.facebook.components.ThreadUtils;
import com.facebook.components.annotations.MountSpec;
import com.facebook.components.widget.PagerBinder;
import com.facebook.feed.rows.pager.RowViewPager;

@MountSpec
/* compiled from: transliterator_help_opened */
public class FeedPagerSpec {
    public static final ComponentPageSwitcher f1222a = null;

    protected static RowViewPager m1290a(ComponentContext componentContext, RowViewPager rowViewPager, PagerBinder pagerBinder, int i) {
        if (rowViewPager == null) {
            rowViewPager = new RowViewPager(componentContext);
        }
        rowViewPager.setPageMargin(i);
        ThreadUtils.b();
        if (pagerBinder.f1236g != null) {
            pagerBinder.mo55g(pagerBinder.f1236g);
        }
        pagerBinder.f1236g = rowViewPager;
        pagerBinder.mo53e(pagerBinder.f1236g);
        return rowViewPager;
    }
}
