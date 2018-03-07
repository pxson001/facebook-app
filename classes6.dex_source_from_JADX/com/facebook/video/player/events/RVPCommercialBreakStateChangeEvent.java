package com.facebook.video.player.events;

import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.video.analytics.VideoAnalytics.PlayerType;

/* compiled from: composer_edit_change_with_tag */
public class RVPCommercialBreakStateChangeEvent extends RichVideoPlayerEvent {
    public final State f19277a;
    public final State f19278b;
    public final CommercialBreakStateChangeEventExtraData f19279c;

    /* compiled from: composer_edit_change_with_tag */
    public class CommercialBreakStateChangeEventExtraData {
        public long f19272a = -1;
        public boolean f19273b = false;
        public long f19274c = -1;
        public FeedProps<GraphQLStory> f19275d;
        public PlayerType f19276e = PlayerType.OTHERS;
    }

    /* compiled from: composer_edit_change_with_tag */
    public enum State {
        LIVE,
        TRANSITION,
        VIDEO_AD,
        WAIT_FOR_ADS,
        STATIC_COUNTDOWN
    }

    public RVPCommercialBreakStateChangeEvent(State state, State state2, CommercialBreakStateChangeEventExtraData commercialBreakStateChangeEventExtraData) {
        this.f19277a = state;
        this.f19278b = state2;
        this.f19279c = commercialBreakStateChangeEventExtraData;
    }
}
