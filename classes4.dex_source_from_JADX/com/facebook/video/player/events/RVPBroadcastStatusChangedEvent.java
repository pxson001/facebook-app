package com.facebook.video.player.events;

import com.facebook.graphql.enums.GraphQLVideoBroadcastStatus;
import javax.annotation.Nullable;

/* compiled from: path */
public class RVPBroadcastStatusChangedEvent extends RichVideoPlayerEvent {
    @Nullable
    public final String f5329a;
    public GraphQLVideoBroadcastStatus f5330b;

    public RVPBroadcastStatusChangedEvent(@Nullable String str, GraphQLVideoBroadcastStatus graphQLVideoBroadcastStatus) {
        this.f5329a = str;
        this.f5330b = graphQLVideoBroadcastStatus;
    }
}
