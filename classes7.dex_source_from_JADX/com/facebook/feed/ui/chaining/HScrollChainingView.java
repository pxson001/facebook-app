package com.facebook.feed.ui.chaining;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AbsListView.LayoutParams;
import android.widget.TextView;
import com.facebook.feed.ui.chaining.HScrollChainingViewController.ItemListRecyclablePagerAdapter;
import com.facebook.feed.ui.itemlistfeedunits.FeedListItemUserActionListener;
import com.facebook.graphql.model.ScrollableItemListFeedUnit;
import com.facebook.widget.CustomLinearLayout;
import com.facebook.widget.CustomViewPager;
import com.facebook.widget.CustomViewUtils;
import com.google.common.base.Preconditions;
import javax.annotation.Nullable;

/* compiled from: Tried to access a JS module before the React instance was fully set up. Calls to ReactContext#getJSModule should be protected by ReactContext#hasActiveCatalystInstance(). */
public class HScrollChainingView extends CustomLinearLayout implements FeedListItemUserActionListener {
    public CustomViewPager f21842a = ((CustomViewPager) a(2131562915));
    public TextView f21843b = ((TextView) a(2131562912));
    public View f21844c = a(2131562913);
    public View f21845d = a(2131562914);
    public TextView f21846e = ((TextView) a(2131562917));
    public View f21847f = a(2131562911);
    public View f21848g = a(2131562916);
    @Nullable
    public HScrollChainingViewController f21849h;

    public HScrollChainingView(Context context) {
        super(context);
        setContentView(2130904792);
        CustomViewUtils.b(this, new ColorDrawable(getResources().getColor(2131361939)));
        setPadding(0, 0, 0, getResources().getDimensionPixelSize(2131429000));
        setLayoutParams(new LayoutParams(-1, -2));
        setOrientation(1);
        this.f21843b.setMovementMethod(LinkMovementMethod.getInstance());
    }

    public final void mR_() {
        PagerAdapter adapter = this.f21842a.getAdapter();
        if (adapter != null && (adapter instanceof ItemListRecyclablePagerAdapter)) {
            ItemListRecyclablePagerAdapter itemListRecyclablePagerAdapter = (ItemListRecyclablePagerAdapter) this.f21842a.getAdapter();
            if (this.f21849h != null) {
                HScrollChainingViewController.m24437a(itemListRecyclablePagerAdapter, this.f21842a);
            }
        }
    }

    public void setRemoveButtonClickListener(OnClickListener onClickListener) {
        this.f21844c.setVisibility(onClickListener == null ? 8 : 0);
        this.f21844c.setOnClickListener(onClickListener);
    }

    public void setMenuButtonClickListener(OnClickListener onClickListener) {
        this.f21845d.setVisibility(onClickListener == null ? 8 : 0);
        this.f21845d.setOnClickListener(onClickListener);
    }

    public void setOnPageChangeListener(OnPageChangeListener onPageChangeListener) {
        this.f21842a.setOnPageChangeListener(onPageChangeListener);
    }

    public void setInstallInstagramButtonClickListener(OnClickListener onClickListener) {
        this.f21846e.setOnClickListener(onClickListener);
    }

    public final void m24431b() {
        this.f21846e.setVisibility(0);
    }

    public final void mo1514a(View view, Object obj, ScrollableItemListFeedUnit scrollableItemListFeedUnit) {
        Preconditions.checkNotNull(view);
        Preconditions.checkNotNull(obj);
        this.f21849h.m24444a((ItemListRecyclablePagerAdapter) this.f21842a.getAdapter(), this.f21842a, view, obj, scrollableItemListFeedUnit);
    }
}
