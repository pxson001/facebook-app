package com.facebook.feed.workingrange.listeners;

import com.facebook.feed.util.event.FeedEventBus;
import com.facebook.feed.util.event.HideEvents$ChangeRendererEvent;
import com.facebook.feed.util.event.HideEvents$StoryVisibilityEvent;
import com.facebook.graphql.enums.StoryVisibility;
import com.facebook.graphql.model.FeedEdge;
import com.facebook.graphql.model.GraphQLFeedUnitEdge;
import com.facebook.graphql.model.HideableUnit;
import com.facebook.graphql.model.interfaces.FeedUnitCommon;
import com.facebook.inject.InjectorLike;
import com.facebook.ultralight.Inject;
import com.facebook.workingrange.core.BaseWorkingRangeListener;
import com.facebook.workingrange.core.SnapshotWithVisiblity;
import com.facebook.workingrange.core.WorkingRangeSnapshot;

/* compiled from: onConnectionFailure must only be called on the Handler thread */
public class HideableUnitWorkingRangeListener extends BaseWorkingRangeListener<FeedEdge, SnapshotWithVisiblity<FeedEdge>> {
    @Inject
    public FeedEventBus f11146a;

    public static HideableUnitWorkingRangeListener m16473a(InjectorLike injectorLike) {
        HideableUnitWorkingRangeListener hideableUnitWorkingRangeListener = new HideableUnitWorkingRangeListener();
        hideableUnitWorkingRangeListener.f11146a = FeedEventBus.m4573a(injectorLike);
        return hideableUnitWorkingRangeListener;
    }

    public final void mo2116a(Object obj, int i, WorkingRangeSnapshot workingRangeSnapshot) {
        FeedUnitCommon c = ((GraphQLFeedUnitEdge) obj).mo2540c();
        if ((c instanceof HideableUnit) && ((HideableUnit) c).mo2879o() == StoryVisibility.HIDDEN) {
            this.f11146a.mo651a(new HideEvents$StoryVisibilityEvent(c.mo2507g(), null, null, StoryVisibility.GONE, 1));
            this.f11146a.mo651a(new HideEvents$ChangeRendererEvent());
        }
    }
}
