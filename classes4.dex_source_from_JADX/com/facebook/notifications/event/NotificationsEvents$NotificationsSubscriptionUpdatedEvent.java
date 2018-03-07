package com.facebook.notifications.event;

import com.facebook.graphql.model.GraphQLStory;
import javax.annotation.Nullable;

/* compiled from: extend_access_token_method */
public class NotificationsEvents$NotificationsSubscriptionUpdatedEvent implements NotificationsEvent {
    public final GraphQLStory f12779a;
    public final String f12780b;
    @Nullable
    public final String f12781c;
    public final String f12782d;
    public final String f12783e;

    public NotificationsEvents$NotificationsSubscriptionUpdatedEvent(GraphQLStory graphQLStory, String str, @Nullable String str2, String str3, String str4) {
        this.f12779a = graphQLStory;
        this.f12780b = str;
        this.f12781c = str2;
        this.f12782d = str3;
        this.f12783e = str4;
    }
}
