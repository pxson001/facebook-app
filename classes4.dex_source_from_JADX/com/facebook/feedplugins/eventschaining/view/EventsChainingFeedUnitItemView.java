package com.facebook.feedplugins.eventschaining.view;

import android.content.Context;
import android.util.AttributeSet;
import com.facebook.analytics.view.tracking.TrackingNodes;
import com.facebook.analytics.view.tracking.TrackingNodes.TrackingNode;
import com.facebook.events.widget.eventcard.EventActionButtonView;
import com.facebook.events.widget.eventcard.EventsCardView;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.widget.RecyclableView;
import com.facebook.widget.pageritemwrapper.PagerItemWrapperLayout;
import javax.annotation.Nullable;

/* compiled from: num_exposures */
public class EventsChainingFeedUnitItemView extends PagerItemWrapperLayout implements RecyclableView {
    public boolean f6592a;
    public String f6593b;
    public final EventsCardView f6594c;

    public EventsChainingFeedUnitItemView(Context context) {
        this(context, null);
    }

    private EventsChainingFeedUnitItemView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f6594c = new EventsCardView(context);
        this.f6594c.setBackgroundDrawable(getResources().getDrawable(2130840170));
        addView(this.f6594c);
        TrackingNodes.a(this.f6594c.f5984c, TrackingNode.TITLE);
        TrackingNodes.a(this.f6594c.f5987f, TrackingNode.SOCIAL_CONTEXT);
    }

    protected void onAttachedToWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, -969766599);
        super.onAttachedToWindow();
        this.f6592a = true;
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, -1876305355, a);
    }

    protected void onDetachedFromWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, -1788611156);
        super.onDetachedFromWindow();
        this.f6592a = false;
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, -13258435, a);
    }

    public final boolean mo569a() {
        return this.f6592a;
    }

    public String getEventId() {
        return this.f6593b;
    }

    public EventActionButtonView getEventActionView() {
        return this.f6594c.f5988g;
    }
}
