package com.facebook.timeline.header;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.inject.Assisted;
import com.facebook.qe.api.QeAccessor;
import com.facebook.timeline.abtest.ExperimentsForTimelineAbTestModule;
import com.facebook.timeline.context.TimelineUserContext;
import com.facebook.timeline.header.data.TimelineHeaderUserData;
import com.facebook.timeline.navtiles.SlimNavTileView;
import javax.inject.Inject;

/* compiled from: friending_search */
public class TimelineHeaderNavtilesAdapter extends TimelineHeaderAbstractAdapter {

    /* compiled from: friending_search */
    public enum Part {
        NAVTILES;
        
        private static Part[] mValues;

        public static Part[] cachedValues() {
            if (mValues == null) {
                mValues = values();
            }
            return mValues;
        }
    }

    @Inject
    public TimelineHeaderNavtilesAdapter(@Assisted Context context, @Assisted TimelineUserContext timelineUserContext, @Assisted TimelineHeaderUserData timelineHeaderUserData, QeAccessor qeAccessor) {
        super(context, qeAccessor, timelineUserContext, timelineHeaderUserData);
    }

    public final View m11454a(int i, ViewGroup viewGroup) {
        Part part = Part.cachedValues()[i];
        part.toString();
        switch (part) {
            case NAVTILES:
                return new SlimNavTileView(this.f11327a);
            default:
                return TimelineHeaderAbstractAdapter.m11411b(i);
        }
    }

    public final boolean mo523a(View view, int i) {
        Part part = Part.cachedValues()[i];
        part.toString();
        if (part == Part.NAVTILES) {
            return false;
        }
        throw new IllegalArgumentException("unknown itemViewType " + i);
    }

    protected final int mo520a() {
        return Part.cachedValues().length;
    }

    protected final void mo522a(boolean[] zArr) {
        int ordinal = Part.NAVTILES.ordinal();
        boolean z = false;
        if (this.f11328b.a(ExperimentsForTimelineAbTestModule.R, false) || !this.f11330d.j()) {
            z = true;
        }
        zArr[ordinal] = z;
    }

    protected final Object mo521a(int i) {
        return Part.cachedValues()[i];
    }

    public int getViewTypeCount() {
        return Part.cachedValues().length;
    }

    public int getItemViewType(int i) {
        return ((Part) getItem(i)).ordinal();
    }
}
