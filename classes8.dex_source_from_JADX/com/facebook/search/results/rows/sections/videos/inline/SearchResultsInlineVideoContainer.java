package com.facebook.search.results.rows.sections.videos.inline;

import android.content.Context;
import android.util.AttributeSet;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.widget.RecyclableView;
import com.facebook.widget.pageritemwrapper.PagerItemWrapperLayout;
import com.facebook.widget.recyclerview.keepattached.RecyclerViewKeepAttached;

/* compiled from: PLACEHOLDER_CTA */
public class SearchResultsInlineVideoContainer extends PagerItemWrapperLayout implements RecyclableView, RecyclerViewKeepAttached {
    public boolean f25277a;

    public SearchResultsInlineVideoContainer(Context context) {
        this(context, null);
    }

    private SearchResultsInlineVideoContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setContentView(2130904922);
    }

    public final boolean m28520a() {
        return this.f25277a;
    }

    protected void onAttachedToWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, -243781725);
        super.onAttachedToWindow();
        this.f25277a = true;
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, 1886145372, a);
    }

    protected void onDetachedFromWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, 795472615);
        this.f25277a = false;
        super.onDetachedFromWindow();
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, 1309436121, a);
    }

    public final boolean gK_() {
        return true;
    }
}
