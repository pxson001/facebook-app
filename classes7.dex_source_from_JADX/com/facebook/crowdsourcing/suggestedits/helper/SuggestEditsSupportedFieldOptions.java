package com.facebook.crowdsourcing.suggestedits.helper;

import com.facebook.graphql.enums.GraphQLSuggestEditsFieldOptionType;
import com.google.common.collect.ImmutableSet;

/* compiled from: clickable_buy_text */
public class SuggestEditsSupportedFieldOptions {
    private static final ImmutableSet<GraphQLSuggestEditsFieldOptionType> f17689a = ImmutableSet.of(GraphQLSuggestEditsFieldOptionType.ADD_VALUE, GraphQLSuggestEditsFieldOptionType.ALWAYS_OPEN, GraphQLSuggestEditsFieldOptionType.DOESNT_HAVE_VALUE, GraphQLSuggestEditsFieldOptionType.HAS_VALUE, GraphQLSuggestEditsFieldOptionType.PERMANENTLY_CLOSED);

    public static boolean m21552a(GraphQLSuggestEditsFieldOptionType graphQLSuggestEditsFieldOptionType) {
        return f17689a.contains(graphQLSuggestEditsFieldOptionType);
    }
}
