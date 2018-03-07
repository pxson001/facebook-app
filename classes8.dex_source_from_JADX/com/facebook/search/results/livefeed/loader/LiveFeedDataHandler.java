package com.facebook.search.results.livefeed.loader;

import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.querybuilder.common.CommonGraphQL2Interfaces.DefaultPageInfoFields;
import com.facebook.search.common.errors.GraphSearchException;
import com.google.common.base.Optional;
import com.google.common.collect.ImmutableList;

/* compiled from: SHARE_BUTTON */
public interface LiveFeedDataHandler {
    void mo1295a(GraphSearchException graphSearchException);

    void mo1296a(ImmutableList<GraphQLStory> immutableList, Optional<DefaultPageInfoFields> optional, String str, String str2, String str3);

    void mo1297b(ImmutableList<GraphQLStory> immutableList, Optional<DefaultPageInfoFields> optional, String str, String str2, String str3);
}
