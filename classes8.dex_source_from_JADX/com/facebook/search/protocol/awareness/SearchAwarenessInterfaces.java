package com.facebook.search.protocol.awareness;

import com.facebook.graphql.enums.GraphQLSearchAwarenessTemplatesEnum;
import com.google.common.collect.ImmutableList;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/* compiled from: nearby_places_query_topic */
public class SearchAwarenessInterfaces {

    /* compiled from: nearby_places_query_topic */
    public interface SearchAwarenessSuggestionFieldsFragment {
        @Nullable
        String mo557b();

        @Nonnull
        ImmutableList<String> mo558c();

        @Nullable
        String mo559d();

        @Nullable
        String mo560g();

        @Nullable
        GraphQLSearchAwarenessTemplatesEnum jF_();
    }
}
