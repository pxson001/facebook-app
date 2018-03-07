package com.facebook.video.channelfeed;

import com.facebook.graphql.model.GraphQLActor;
import com.facebook.graphql.model.GraphQLSinglePublisherVideoChannelsConnection;
import com.facebook.graphql.model.GraphQLSinglePublisherVideoChannelsEdge;
import com.facebook.graphql.model.GraphQLVideoChannel;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.collect.RegularImmutableList;

/* compiled from: success_create_account */
public class VideoChannelHelper {
    public static ImmutableList<String> m2552a(GraphQLActor graphQLActor) {
        GraphQLSinglePublisherVideoChannelsConnection ao = graphQLActor.ao();
        if (ao == null) {
            String H = graphQLActor.H();
            if (H != null) {
                return ImmutableList.of(H);
            }
            return RegularImmutableList.a;
        }
        Builder builder = new Builder();
        ImmutableList a = ao.a();
        int size = a.size();
        for (int i = 0; i < size; i++) {
            GraphQLVideoChannel a2 = ((GraphQLSinglePublisherVideoChannelsEdge) a.get(i)).a();
            Object k = a2 != null ? a2.k() : null;
            if (k != null) {
                builder.c(k);
            }
        }
        return builder.b();
    }
}
