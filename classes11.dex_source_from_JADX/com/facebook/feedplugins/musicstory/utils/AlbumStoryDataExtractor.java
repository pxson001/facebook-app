package com.facebook.feedplugins.musicstory.utils;

import com.facebook.graphql.model.GraphQLNode;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.google.common.base.Preconditions;

/* compiled from: com.facebook.leadgen.deeplink.LeadGenActivity */
public class AlbumStoryDataExtractor {
    public final GraphQLStoryAttachment f8399a;
    public final GraphQLNode f8400b;

    public AlbumStoryDataExtractor(GraphQLStoryAttachment graphQLStoryAttachment) {
        Preconditions.checkNotNull(graphQLStoryAttachment);
        Preconditions.checkNotNull(graphQLStoryAttachment.z());
        this.f8399a = graphQLStoryAttachment;
        this.f8400b = graphQLStoryAttachment.z();
        Preconditions.checkState(this.f8400b.j().g() == -2027902571);
    }
}
