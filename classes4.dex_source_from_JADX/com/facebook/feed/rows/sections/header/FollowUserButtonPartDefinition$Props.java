package com.facebook.feed.rows.sections.header;

import com.facebook.graphql.calls.ActorSubscribeInputData$SubscribeLocation;
import com.facebook.graphql.calls.ActorUnsubscribeInputData$SubscribeLocation;
import com.facebook.graphql.enums.GraphQLSubscribeStatus;
import com.facebook.graphql.model.interfaces.CacheableEntity;

/* compiled from: normalized_number */
public class FollowUserButtonPartDefinition$Props {
    public final CacheableEntity f7007a;
    public final GraphQLSubscribeStatus f7008b;
    public final String f7009c;
    public final ActorSubscribeInputData$SubscribeLocation f7010d;
    public final ActorUnsubscribeInputData$SubscribeLocation f7011e;
    public final int f7012f;
    public final int f7013g;

    public FollowUserButtonPartDefinition$Props(CacheableEntity cacheableEntity, GraphQLSubscribeStatus graphQLSubscribeStatus, String str, ActorSubscribeInputData$SubscribeLocation actorSubscribeInputData$SubscribeLocation, ActorUnsubscribeInputData$SubscribeLocation actorUnsubscribeInputData$SubscribeLocation, int i, int i2) {
        this.f7007a = cacheableEntity;
        this.f7008b = graphQLSubscribeStatus;
        this.f7009c = str;
        this.f7010d = actorSubscribeInputData$SubscribeLocation;
        this.f7011e = actorUnsubscribeInputData$SubscribeLocation;
        this.f7012f = i;
        this.f7013g = i2;
    }
}
