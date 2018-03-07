package com.facebook.timeline.listview;

import android.view.View;
import android.view.ViewGroup;
import com.facebook.feed.rows.adapter.MultiRowMultiAdapter;
import com.facebook.feed.rows.adapter.SingleRowFbListAdapter;
import com.facebook.feed.rows.adapter.api.MultiRowAdapter;
import com.facebook.timeline.header.TimelineHeaderMultiAdapter;
import com.facebook.timeline.header.data.TimelineHeaderData.InitializeState;
import com.facebook.timeline.header.data.TimelineHeaderUserData;
import com.facebook.timeline.protiles.model.ProtilesData;
import com.facebook.tools.dextr.runtime.detour.TracerDetour;
import javax.annotation.Nullable;

/* compiled from: fetchMessage- */
public class TimelineAdapter extends MultiRowMultiAdapter {
    private final TimelineHeaderUserData f12028a;
    private final ProtilesData f12029b;
    public final TimelineHeaderMultiAdapter f12030c;
    public final MultiRowAdapter f12031d;
    @Nullable
    public final MultiRowAdapter f12032e;
    @Nullable
    public final MultiRowAdapter f12033f;
    public final MultiRowAdapter f12034g;
    private final boolean f12035h;

    public TimelineAdapter(TimelineHeaderMultiAdapter timelineHeaderMultiAdapter, MultiRowAdapter multiRowAdapter, MultiRowAdapter multiRowAdapter2, MultiRowAdapter multiRowAdapter3, TimelineHeaderUserData timelineHeaderUserData, ProtilesData protilesData) {
        super(true, new MultiRowAdapter[]{new SingleRowFbListAdapter(timelineHeaderMultiAdapter), multiRowAdapter, multiRowAdapter2, multiRowAdapter3});
        this.f12030c = timelineHeaderMultiAdapter;
        this.f12031d = multiRowAdapter2;
        this.f12032e = multiRowAdapter;
        this.f12033f = null;
        this.f12034g = multiRowAdapter3;
        this.f12028a = timelineHeaderUserData;
        this.f12029b = protilesData;
        this.f12035h = true;
    }

    public TimelineAdapter(TimelineHeaderMultiAdapter timelineHeaderMultiAdapter, MultiRowAdapter multiRowAdapter, MultiRowAdapter multiRowAdapter2, MultiRowAdapter multiRowAdapter3, MultiRowAdapter multiRowAdapter4, TimelineHeaderUserData timelineHeaderUserData, ProtilesData protilesData) {
        super(true, new MultiRowAdapter[]{new SingleRowFbListAdapter(timelineHeaderMultiAdapter), multiRowAdapter, multiRowAdapter2, multiRowAdapter3, multiRowAdapter4});
        this.f12030c = timelineHeaderMultiAdapter;
        this.f12031d = multiRowAdapter2;
        this.f12032e = multiRowAdapter;
        this.f12033f = multiRowAdapter3;
        this.f12034g = multiRowAdapter4;
        this.f12028a = timelineHeaderUserData;
        this.f12029b = protilesData;
        this.f12035h = true;
    }

    public TimelineAdapter(TimelineHeaderUserData timelineHeaderUserData, ProtilesData protilesData, TimelineHeaderMultiAdapter timelineHeaderMultiAdapter, MultiRowAdapter multiRowAdapter, MultiRowAdapter multiRowAdapter2) {
        super(true, new MultiRowAdapter[]{new SingleRowFbListAdapter(timelineHeaderMultiAdapter), multiRowAdapter, multiRowAdapter2});
        this.f12028a = timelineHeaderUserData;
        this.f12029b = protilesData;
        this.f12030c = timelineHeaderMultiAdapter;
        this.f12031d = multiRowAdapter;
        this.f12033f = null;
        this.f12032e = null;
        this.f12034g = multiRowAdapter2;
        this.f12035h = false;
    }

    public TimelineAdapter(TimelineHeaderUserData timelineHeaderUserData, ProtilesData protilesData, TimelineHeaderMultiAdapter timelineHeaderMultiAdapter, MultiRowAdapter multiRowAdapter, MultiRowAdapter multiRowAdapter2, MultiRowAdapter multiRowAdapter3) {
        super(true, new MultiRowAdapter[]{new SingleRowFbListAdapter(timelineHeaderMultiAdapter), multiRowAdapter, multiRowAdapter2, multiRowAdapter3});
        this.f12028a = timelineHeaderUserData;
        this.f12029b = protilesData;
        this.f12030c = timelineHeaderMultiAdapter;
        this.f12031d = multiRowAdapter;
        this.f12033f = multiRowAdapter2;
        this.f12032e = null;
        this.f12034g = multiRowAdapter3;
        this.f12035h = false;
    }

    public final int m12061d() {
        return a(this.f12034g);
    }

    public final int m12062g() {
        return a(this.f12034g);
    }

    public View getView(int i, @Nullable View view, ViewGroup viewGroup) {
        TracerDetour.a("BaseTimelineAdapter.getView-%d", Integer.valueOf(i), -777062039);
        try {
            View view2 = super.getView(i, view, viewGroup);
            return view2;
        } finally {
            TracerDetour.a(0, -481713807);
        }
    }

    public boolean isEmpty() {
        return getCount() == 0 || super.isEmpty();
    }

    public int getCount() {
        Object obj;
        if (this.f12028a.e != InitializeState.UNINITIALIZED) {
            obj = 1;
        } else {
            obj = null;
        }
        if (obj == null) {
            return 0;
        }
        if (!this.f12029b.m12122e()) {
            return super.getCount();
        }
        int count = this.f12030c.getCount() + this.f12031d.getCount();
        if (!this.f12035h || this.f12032e == null) {
            return count;
        }
        return count + this.f12032e.getCount();
    }

    public long getItemId(int i) {
        return (long) i;
    }
}
