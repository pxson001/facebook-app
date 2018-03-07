package com.facebook.timeline.header;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.inject.Assisted;
import com.facebook.qe.api.QeAccessor;
import com.facebook.timeline.context.TimelineUserContext;
import com.facebook.timeline.contextual.TimelineContextualInfoData;
import com.facebook.timeline.header.data.TimelineHeaderUserData;
import com.facebook.timeline.taggedmediaset.TimelineTaggedMediaSetData;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: friendsNearbyInviteParams */
public class TimelineHeaderFullHeaderAdapter extends TimelineHeaderAbstractAdapter {
    private final TimelineTaggedMediaSetData f11395e;
    private final TimelineContextualInfoData f11396f;
    public final TimelineHeaderDataLogger f11397g;
    private final boolean f11398h;
    @Nullable
    private UserTimelineHeaderView f11399i;

    /* compiled from: friendsNearbyInviteParams */
    public enum Part {
        FULL_HEADER;
        
        private static Part[] mValues;

        public static Part[] cachedValues() {
            if (mValues == null) {
                mValues = values();
            }
            return mValues;
        }
    }

    @Inject
    public TimelineHeaderFullHeaderAdapter(@Assisted Context context, @Assisted TimelineUserContext timelineUserContext, @Assisted TimelineHeaderUserData timelineHeaderUserData, @Assisted TimelineContextualInfoData timelineContextualInfoData, @Assisted TimelineTaggedMediaSetData timelineTaggedMediaSetData, @Assisted TimelineHeaderDataLogger timelineHeaderDataLogger, @Assisted Boolean bool, QeAccessor qeAccessor) {
        super(context, qeAccessor, timelineUserContext, timelineHeaderUserData);
        this.f11395e = timelineTaggedMediaSetData;
        this.f11396f = timelineContextualInfoData;
        this.f11397g = timelineHeaderDataLogger;
        this.f11398h = bool.booleanValue();
    }

    public final View m11446a(int i, ViewGroup viewGroup) {
        Part part = Part.cachedValues()[i];
        part.toString();
        switch (part) {
            case FULL_HEADER:
                this.f11399i = new UserTimelineHeaderView(this.f11327a);
                if (this.f11398h) {
                    this.f11399i.getBackground().mutate().setAlpha(0);
                }
                return this.f11399i;
            default:
                return TimelineHeaderAbstractAdapter.m11411b(i);
        }
    }

    public final boolean mo523a(final View view, int i) {
        Part part = Part.cachedValues()[i];
        part.toString();
        if (part != Part.FULL_HEADER || !(view instanceof UserTimelineHeaderView)) {
            return TimelineHeaderAbstractAdapter.m11412c(i);
        }
        boolean a = ((UserTimelineHeaderView) view).m11596a(this.f11329c, this.f11330d, this.f11395e, this.f11396f);
        view.post(new Runnable(this) {
            final /* synthetic */ TimelineHeaderFullHeaderAdapter f11393b;

            public void run() {
                this.f11393b.f11397g.m11441a((UserTimelineHeaderView) view);
            }
        });
        return a;
    }

    protected final int mo520a() {
        return Part.cachedValues().length;
    }

    protected final void mo522a(boolean[] zArr) {
        zArr[Part.FULL_HEADER.ordinal()] = true;
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
