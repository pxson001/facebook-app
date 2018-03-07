package com.facebook.feed.rows.sections.attachments.ui;

import android.content.Context;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import com.facebook.feed.rows.sections.hscrollrecyclerview.HasPageStyle;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.widget.RecyclableView;
import com.facebook.widget.pageritemwrapper.PagerItemWrapperLayout;

/* compiled from: V_VP8 */
public class EventSubStoryItemView extends PagerItemWrapperLayout implements HasPageStyle, RecyclableView {
    private final LinearLayout f21054a = ((LinearLayout) c(2131561425));
    public boolean f21055b;

    public EventSubStoryItemView(Context context) {
        super(context);
        setContentView(2130904101);
        setBackgroundResource(2130843719);
    }

    public final void m23935a(int i, boolean z, boolean z2) {
        setWidth(i);
    }

    public void setWidth(int i) {
        LayoutParams layoutParams = (LayoutParams) this.f21054a.getLayoutParams();
        layoutParams.width = i;
        this.f21054a.setLayoutParams(layoutParams);
        this.f21054a.requestLayout();
    }

    protected void onAttachedToWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, -1216842599);
        super.onAttachedToWindow();
        this.f21055b = true;
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, -1511214739, a);
    }

    protected void onDetachedFromWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, 801383775);
        super.onDetachedFromWindow();
        this.f21055b = false;
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, -720551920, a);
    }

    public final boolean m23936a() {
        return this.f21055b;
    }
}
