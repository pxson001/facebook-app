package com.facebook.feedplugins.storyset.rows.ui;

import android.content.Context;
import android.widget.LinearLayout;
import com.facebook.components.feed.FeedComponentView;
import com.facebook.feed.rows.sections.header.ui.HScrollPageHeaderView;
import com.facebook.feed.rows.sections.hscrollrecyclerview.HasPageStyle;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.widget.RecyclableView;
import com.facebook.widget.pageritemwrapper.PagerItemWrapperLayout;

/* compiled from: app_section_id */
public class NetEgoStoryPageView extends PagerItemWrapperLayout implements HasPageStyle, CanHaveEmbededHeader, RecyclableView {
    public boolean f9842a;
    private final HScrollPageHeaderView f9843b = ((HScrollPageHeaderView) c(2131562634));
    private final FeedComponentView f9844c;
    private final LinearLayout f9845d = ((LinearLayout) c(2131562633));

    public NetEgoStoryPageView(Context context, int i) {
        super(context);
        setContentView(i);
        this.f9843b.setSingleLineTitle(true);
        this.f9844c = (FeedComponentView) c(2131564191);
    }

    protected void onAttachedToWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, 728110253);
        super.onAttachedToWindow();
        this.f9842a = true;
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, -1608410120, a);
    }

    protected void onDetachedFromWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, -1556660843);
        super.onDetachedFromWindow();
        this.f9842a = false;
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, -1469691031, a);
    }

    public void setUseEmbeddedHeaderComponent(boolean z) {
        int i;
        int i2 = 8;
        FeedComponentView feedComponentView = this.f9844c;
        if (z) {
            i = 0;
        } else {
            i = 8;
        }
        feedComponentView.setVisibility(i);
        HScrollPageHeaderView hScrollPageHeaderView = this.f9843b;
        if (!z) {
            i2 = 0;
        }
        hScrollPageHeaderView.setVisibility(i2);
    }

    public final boolean m10251a() {
        return this.f9842a;
    }

    public final void m10250a(int i, boolean z, boolean z2) {
    }

    public void setWidth(int i) {
        this.f9845d.setBackgroundResource(2130842530);
    }
}
