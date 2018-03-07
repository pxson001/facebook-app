package com.facebook.feedplugins.storyset.rows.ui;

import android.content.Context;
import com.facebook.feed.rows.sections.hscrollrecyclerview.HasPageStyle;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.widget.RecyclableView;
import com.facebook.widget.pageritemwrapper.PagerItemWrapperLayout;

/* compiled from: arg_should_support_cache */
public abstract class StoryAttachmentStylePageView extends PagerItemWrapperLayout implements HasPageStyle, RecyclableView {
    public boolean f9841a;

    public StoryAttachmentStylePageView(Context context, int i) {
        super(context);
        setContentView(i);
    }

    public final void m10248a(int i, boolean z, boolean z2) {
    }

    public void setWidth(int i) {
        if (getLayoutParams() != null && getLayoutParams().width != i) {
            getLayoutParams().width = i;
        }
    }

    public final boolean m10249a() {
        return this.f9841a;
    }

    protected void onAttachedToWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, -1003524503);
        super.onAttachedToWindow();
        this.f9841a = true;
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, -557150680, a);
    }

    protected void onDetachedFromWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, 1049957363);
        super.onDetachedFromWindow();
        this.f9841a = false;
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, -683367949, a);
    }
}
