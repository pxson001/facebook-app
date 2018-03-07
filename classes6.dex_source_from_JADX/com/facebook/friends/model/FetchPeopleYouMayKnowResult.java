package com.facebook.friends.model;

import com.facebook.graphql.model.GraphQLPageInfo;
import com.google.common.collect.ImmutableList;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: max_broadcast_duration */
public class FetchPeopleYouMayKnowResult {
    public final ImmutableList<PersonYouMayKnow> f10647a;
    public final GraphQLPageInfo f10648b;

    public FetchPeopleYouMayKnowResult(ImmutableList<PersonYouMayKnow> immutableList, GraphQLPageInfo graphQLPageInfo) {
        this.f10647a = immutableList;
        this.f10648b = graphQLPageInfo;
    }
}
