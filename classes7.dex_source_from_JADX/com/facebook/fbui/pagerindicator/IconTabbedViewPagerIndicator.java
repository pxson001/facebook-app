package com.facebook.fbui.pagerindicator;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.InflateException;
import android.view.View;
import android.widget.ImageView;
import com.facebook.fbui.badges.BadgeIconView;
import com.facebook.fbui.pagerindicator.TabbedViewPagerIndicator.TabsContainer;

/* compiled from: souvenir_prompt/ */
public class IconTabbedViewPagerIndicator extends TabbedViewPagerIndicator {

    /* compiled from: souvenir_prompt/ */
    public class IconTabsContainer extends TabsContainer {
        public IconTabsContainer(Context context) {
            this(context, null);
        }

        public IconTabsContainer(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            setTabLayout(2130904276);
        }

        public final View m4305a(CharSequence charSequence, int i) {
            View d = m4304d();
            if (d instanceof ImageView) {
                ImageView imageView = (ImageView) d;
                imageView.setImageResource(i);
                if (TextUtils.isEmpty(charSequence)) {
                    charSequence = "";
                }
                imageView.setContentDescription(charSequence);
                addView(imageView);
                return d;
            }
            throw new InflateException("Tab layout should be a subclass of ImageView");
        }
    }

    protected int getTabsContainerResource() {
        return 2130904277;
    }

    public void setViewPager(ViewPager viewPager) {
        PagerAdapter adapter = viewPager.getAdapter();
        if (adapter == null || (adapter instanceof IconPagerAdapter)) {
            super.setViewPager(viewPager);
            return;
        }
        throw new IllegalStateException("Adapter should be an instance of IconPagerAdapter");
    }

    protected final void mo172a() {
        super.mo172a();
        if (this.f3564e != null) {
            int childCount = this.f3562c.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = this.f3562c.getChildAt(i);
                if (childAt instanceof BadgeIconView) {
                    ((BadgeIconView) childAt).setBadgeText(this.f3564e.m4268a(i));
                }
            }
        }
    }

    protected final View mo169c(int i) {
        PagerAdapter pagerAdapter = this.f3563d;
        View a = ((IconTabsContainer) this.f3562c).m4305a(pagerAdapter.J_(i), ((IconPagerAdapter) pagerAdapter).m4307a());
        ContentDescriptionPagerAdapter contentDescriptionPagerAdapter = this.f3564e;
        if (contentDescriptionPagerAdapter != null && (a instanceof BadgeIconView)) {
            BadgeIconView badgeIconView = (BadgeIconView) a;
            badgeIconView.setContentDescription(contentDescriptionPagerAdapter.m4266b(i));
            badgeIconView.setBadgeText(contentDescriptionPagerAdapter.m4268a(i));
        }
        return a;
    }
}
