package com.facebook.timeline.header;

import android.view.View;
import android.view.ViewGroup;
import com.facebook.inject.Assisted;
import com.facebook.timeline.data.NeedsFragmentCleanup;
import com.facebook.timeline.header.data.TimelineHeaderUserData;
import com.facebook.timeline.header.ui.CaspianTimelineStandardHeader;
import com.facebook.widget.listview.FbListAdapter;
import com.facebook.widget.listview.MultiAdapterListAdapter;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: friends/center?source_ref={%s %s}&fc_tab={%s %s} */
public class TimelineHeaderMultiAdapter extends MultiAdapterListAdapter {
    private final TimelineHeaderTopAdapter f11400a;
    private final TimelineHeaderUserData f11401b;
    public final Set<NeedsFragmentCleanup> f11402c = new HashSet();

    @Inject
    public TimelineHeaderMultiAdapter(@Assisted TimelineHeaderUserData timelineHeaderUserData, @Assisted TimelineHeaderTopAdapter timelineHeaderTopAdapter, @Assisted List<FbListAdapter> list) {
        super(false, list);
        this.f11401b = timelineHeaderUserData;
        this.f11400a = timelineHeaderTopAdapter;
    }

    public View getView(int i, @Nullable View view, ViewGroup viewGroup) {
        View view2 = super.getView(i, view, viewGroup);
        if (view2 instanceof NeedsFragmentCleanup) {
            NeedsFragmentCleanup needsFragmentCleanup = (NeedsFragmentCleanup) view2;
            if (!this.f11402c.contains(needsFragmentCleanup)) {
                this.f11402c.add(needsFragmentCleanup);
            }
        }
        return view2;
    }

    @Nullable
    public final CaspianTimelineStandardHeader m11451e() {
        return this.f11400a.f11435j;
    }
}
