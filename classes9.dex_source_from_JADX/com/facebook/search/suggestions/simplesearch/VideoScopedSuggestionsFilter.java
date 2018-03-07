package com.facebook.search.suggestions.simplesearch;

import com.facebook.graphql.enums.GraphQLObjectType;
import com.facebook.search.model.EntityTypeaheadUnit;
import com.facebook.search.model.TypeaheadUnit;
import com.facebook.ui.typeahead.BaseSuggestionFilter;
import com.facebook.ui.typeahead.TypeaheadResponse;

/* compiled from: visible_topic_feeds */
public class VideoScopedSuggestionsFilter extends BaseSuggestionFilter<TypeaheadUnit> {
    public final boolean m423a(Object obj, TypeaheadResponse typeaheadResponse, String str) {
        TypeaheadUnit typeaheadUnit = (TypeaheadUnit) obj;
        if (!(typeaheadUnit instanceof EntityTypeaheadUnit) || !((EntityTypeaheadUnit) typeaheadUnit).j) {
            return true;
        }
        boolean z;
        EntityTypeaheadUnit entityTypeaheadUnit = (EntityTypeaheadUnit) typeaheadUnit;
        GraphQLObjectType graphQLObjectType = entityTypeaheadUnit.c;
        if (graphQLObjectType.g() == 2645995) {
            z = entityTypeaheadUnit.i;
        } else if (graphQLObjectType.g() == 2479791) {
            z = entityTypeaheadUnit.g;
        } else {
            z = false;
        }
        return z;
    }
}
