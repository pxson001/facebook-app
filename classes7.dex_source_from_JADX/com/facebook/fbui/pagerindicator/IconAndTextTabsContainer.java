package com.facebook.fbui.pagerindicator;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.view.PagerAdapter;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.InflateException;
import android.view.View;
import android.widget.TextView;
import com.facebook.common.util.StringUtil;
import com.facebook.fbui.pagerindicator.IconTabbedViewPagerIndicator.IconTabsContainer;
import com.facebook.feedback.reactions.data.FeedbackReaction;
import com.facebook.feedback.reactions.ui.ReactorsLoader;
import com.facebook.feedback.reactions.ui.TabbedReactorsListFragment.ReactorViewPagerAdapter;

/* compiled from: souvenir_id */
public class IconAndTextTabsContainer extends IconTabsContainer {
    public IconAndTextTabsContainer(Context context) {
        this(context, null);
    }

    public IconAndTextTabsContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setTabLayout(2130904274);
    }

    public final View m4306a(PagerAdapter pagerAdapter, int i) {
        View d = m4304d();
        if ((d instanceof TextView) && (pagerAdapter instanceof ReactorViewPagerAdapter)) {
            Drawable drawable;
            ReactorViewPagerAdapter reactorViewPagerAdapter = (ReactorViewPagerAdapter) pagerAdapter;
            TextView textView = (TextView) d;
            CharSequence J_ = pagerAdapter.J_(i);
            FeedbackReaction e = ReactorViewPagerAdapter.m4578e(reactorViewPagerAdapter, i);
            if (ReactorsLoader.m4556c(e)) {
                drawable = null;
            } else {
                drawable = e.k.a();
            }
            Drawable drawable2 = drawable;
            if (TextUtils.isEmpty(J_)) {
                J_ = "";
            }
            reactorViewPagerAdapter.m4581a(textView, i);
            textView.setText(J_);
            if (drawable2 != null) {
                textView.setCompoundDrawablesWithIntrinsicBounds(drawable2, null, null, null);
            }
            CharSequence b = reactorViewPagerAdapter.m4584b(i);
            if (!StringUtil.a(b)) {
                J_ = b;
            }
            d.setContentDescription(J_);
            addView(d);
            return d;
        }
        throw new InflateException("Tab layout should be a subclass of TextView and pager adapter should be a subclass of IconAndTextPagerAdapter");
    }
}
