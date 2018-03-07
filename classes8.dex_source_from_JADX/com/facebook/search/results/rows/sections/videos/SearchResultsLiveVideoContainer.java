package com.facebook.search.results.rows.sections.videos;

import android.content.Context;
import android.util.AttributeSet;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.widget.RecyclableView;
import com.facebook.widget.pageritemwrapper.PagerItemWrapperLayout;
import com.facebook.widget.recyclerview.keepattached.RecyclerViewKeepAttached;

/* compiled from: PLAY_ICON */
public class SearchResultsLiveVideoContainer extends PagerItemWrapperLayout implements RecyclableView, RecyclerViewKeepAttached {
    public boolean f25127a;

    public SearchResultsLiveVideoContainer(Context context) {
        this(context, null);
    }

    private SearchResultsLiveVideoContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setContentView(2130905095);
    }

    public final boolean m28421a() {
        return this.f25127a;
    }

    protected void onAttachedToWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, 549363101);
        super.onAttachedToWindow();
        this.f25127a = true;
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, -1297063640, a);
    }

    protected void onDetachedFromWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, -1834982288);
        this.f25127a = false;
        super.onDetachedFromWindow();
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, -1911470124, a);
    }

    public final boolean gK_() {
        return true;
    }
}
