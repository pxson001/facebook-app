package com.facebook.search.model;

import com.facebook.graphql.enums.GraphQLGraphSearchResultsDisplayStyle;
import com.facebook.search.api.GraphSearchQuery.ScopedEntityType;
import com.facebook.search.model.KeywordTypeaheadUnit.KeywordType;
import javax.annotation.Nullable;

/* compiled from: TUTORIAL_NUX */
public class GraphSearchQuerySpecHelper {
    public static boolean m25628a(@Nullable GraphSearchQuerySpec graphSearchQuerySpec) {
        GraphQLGraphSearchResultsDisplayStyle graphQLGraphSearchResultsDisplayStyle;
        boolean z;
        boolean z2 = graphSearchQuerySpec != null && graphSearchQuerySpec.jI_() == ScopedEntityType.VIDEO;
        if (graphSearchQuerySpec == null || graphSearchQuerySpec.mo1215f().isEmpty()) {
            graphQLGraphSearchResultsDisplayStyle = GraphQLGraphSearchResultsDisplayStyle.UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
        } else {
            graphQLGraphSearchResultsDisplayStyle = (GraphQLGraphSearchResultsDisplayStyle) graphSearchQuerySpec.mo1215f().get(0);
        }
        if (graphQLGraphSearchResultsDisplayStyle == GraphQLGraphSearchResultsDisplayStyle.BLENDED_VIDEOS) {
            z = true;
        } else {
            z = false;
        }
        return z || z2;
    }

    public static boolean m25629b(@Nullable GraphSearchQuerySpec graphSearchQuerySpec) {
        return graphSearchQuerySpec != null && graphSearchQuerySpec.jI_() == ScopedEntityType.MARKETPLACE;
    }

    public static boolean m25630c(@Nullable GraphSearchQuerySpec graphSearchQuerySpec) {
        return graphSearchQuerySpec != null && ("news_v2".equals(graphSearchQuerySpec.jH_()) || m25631e(graphSearchQuerySpec));
    }

    private static boolean m25631e(GraphSearchQuerySpec graphSearchQuerySpec) {
        return (graphSearchQuerySpec instanceof KeywordTypeaheadUnit) && ((KeywordTypeaheadUnit) graphSearchQuerySpec).f22118g == KeywordType.trending;
    }
}
