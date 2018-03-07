package com.facebook.feedplugins.multishare;

import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.graphql.model.GraphQLStoryActionLink;
import com.facebook.graphql.model.GraphQLStoryAttachment;

/* compiled from: contact_invite_list_open */
public class BusinessActionButtonPartDefinition$Props {
    public final int f8000a;
    public final GraphQLStoryActionLink f8001b;
    public final FeedProps<GraphQLStoryAttachment> f8002c;
    public final int f8003d;

    public BusinessActionButtonPartDefinition$Props(int i, GraphQLStoryActionLink graphQLStoryActionLink, FeedProps<GraphQLStoryAttachment> feedProps, int i2) {
        this.f8000a = i;
        this.f8001b = graphQLStoryActionLink;
        this.f8002c = feedProps;
        this.f8003d = i2;
    }
}
