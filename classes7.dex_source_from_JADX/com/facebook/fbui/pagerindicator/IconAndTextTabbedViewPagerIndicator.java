package com.facebook.fbui.pagerindicator;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.View;
import com.facebook.feedback.reactions.ui.TabbedReactorsListFragment.ReactorViewPagerAdapter;

/* compiled from: souvenir_unique_id */
public class IconAndTextTabbedViewPagerIndicator extends TabbedViewPagerIndicator {
    public IconAndTextTabbedViewPagerIndicator(Context context) {
        this(context, null);
    }

    public IconAndTextTabbedViewPagerIndicator(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 2130772337);
    }

    public IconAndTextTabbedViewPagerIndicator(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void setViewPager(ViewPager viewPager) {
        PagerAdapter adapter = viewPager.getAdapter();
        if (adapter == null || (adapter instanceof ReactorViewPagerAdapter)) {
            super.setViewPager(viewPager);
            return;
        }
        throw new IllegalStateException("Adapter should be an instance of IconAndTextPagerAdapter");
    }

    protected int getTabsContainerResource() {
        return 2130904275;
    }

    protected final View mo169c(int i) {
        return ((IconAndTextTabsContainer) this.f3562c).m4306a(this.f3563d, i);
    }
}
