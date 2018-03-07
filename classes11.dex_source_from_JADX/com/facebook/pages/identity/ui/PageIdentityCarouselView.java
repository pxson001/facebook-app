package com.facebook.pages.identity.ui;

import android.content.Context;
import android.content.res.Configuration;
import android.util.AttributeSet;
import com.facebook.widget.ListViewFriendlyViewPager;

/* compiled from: page_identity_place_claim_fail */
public class PageIdentityCarouselView extends ListViewFriendlyViewPager {
    public PageIdentityCarouselView(Context context) {
        super(context);
        m5217i();
    }

    public PageIdentityCarouselView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m5217i();
    }

    private final void m5216h() {
        m5217i();
    }

    private void m5217i() {
        int i = getResources().getDisplayMetrics().widthPixels;
        i = (i - ((int) (((float) i) * 0.8888889f))) / 2;
        setPadding(i, getPaddingTop(), i, getPaddingBottom());
    }

    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        m5217i();
        setAdapter(getAdapter());
    }
}
