package com.facebook.feedplugins.groupcommerce;

import android.content.Context;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.fbui.widget.layout.SegmentedLinearLayout;
import com.facebook.feed.rows.sections.header.ui.HScrollPageHeaderView;
import com.facebook.feedplugins.base.blingbar.ui.ConstantHeightBlingBarView;
import com.facebook.feedplugins.base.footer.ui.DefaultFooterView;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.widget.RecyclableView;
import com.facebook.widget.pageritemwrapper.PagerItemWrapperLayout;
import com.facebook.widget.text.BetterTextView;

/* compiled from: num_cache_hits */
public class GroupCommerceHScrollItemView extends PagerItemWrapperLayout implements RecyclableView {
    public boolean f6597a;
    public SegmentedLinearLayout f6598b = ((SegmentedLinearLayout) c(2131562633));
    private HScrollPageHeaderView f6599c = ((HScrollPageHeaderView) c(2131562634));
    public BetterTextView f6600d = ((BetterTextView) c(2131562635));
    public BetterTextView f6601e = ((BetterTextView) c(2131562636));
    public FbDraweeView f6602f = ((FbDraweeView) c(2131562637));
    private ConstantHeightBlingBarView f6603g = ((ConstantHeightBlingBarView) c(2131562638));
    private DefaultFooterView f6604h = ((DefaultFooterView) c(2131562639));

    public GroupCommerceHScrollItemView(Context context) {
        super(context);
        setContentView(2130904642);
        this.f6599c.setSingleLineTitle(true);
    }

    public HScrollPageHeaderView getHeader() {
        return this.f6599c;
    }

    public DefaultFooterView getFooter() {
        return this.f6604h;
    }

    public ConstantHeightBlingBarView getBlingBar() {
        return this.f6603g;
    }

    protected void onAttachedToWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, -54950230);
        super.onAttachedToWindow();
        this.f6597a = true;
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, 691291614, a);
    }

    protected void onDetachedFromWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, 1491032174);
        super.onDetachedFromWindow();
        this.f6597a = false;
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, -92107189, a);
    }

    public final boolean mo569a() {
        return this.f6597a;
    }
}
