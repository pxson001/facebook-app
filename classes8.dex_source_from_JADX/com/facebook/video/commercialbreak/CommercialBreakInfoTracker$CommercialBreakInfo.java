package com.facebook.video.commercialbreak;

import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.video.player.events.RVPCommercialBreakStateChangeEvent.State;
import javax.annotation.Nullable;

/* compiled from: loggingClass */
public class CommercialBreakInfoTracker$CommercialBreakInfo {
    @Nullable
    public FeedProps<GraphQLStory> f9716a;
    public long f9717b = -1;
    public long f9718c = -1;
    public State f9719d = State.LIVE;
    public State f9720e = State.LIVE;
    public CommercialBreakVideoAdFetcher$State f9721f = CommercialBreakVideoAdFetcher$State.IDLE;
    public long f9722g = -1;
    public boolean f9723h = false;
    public long f9724i = -1;
    public boolean f9725j = false;
    public long f9726k = -1;
}
