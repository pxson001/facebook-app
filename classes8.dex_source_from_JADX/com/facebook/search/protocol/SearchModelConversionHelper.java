package com.facebook.search.protocol;

import com.facebook.graphql.model.GraphQLGraphSearchResultDecoration;
import com.facebook.graphql.model.GraphQLGraphSearchResultDecoration.Builder;
import com.facebook.graphql.model.GraphQLGraphSearchSnippet;
import com.facebook.graphql.model.GraphQLTextWithEntities;
import com.facebook.search.protocol.FetchKeywordSearchResultsGraphQLModels.KeywordSearchResultDecorationModel;
import com.facebook.search.protocol.FetchKeywordSearchResultsGraphQLModels.KeywordSearchResultDecorationModel.OrderedSnippetsModel;
import com.facebook.search.protocol.FetchKeywordSearchResultsGraphQLModels.KeywordSearchResultDecorationModel.OrderedSnippetsModel.SentenceModel;
import com.google.common.collect.ImmutableList;

/* compiled from: nearby_places_result_list_view_state */
public final class SearchModelConversionHelper {
    public static GraphQLGraphSearchResultDecoration m8989a(KeywordSearchResultDecorationModel keywordSearchResultDecorationModel) {
        if (keywordSearchResultDecorationModel == null) {
            return null;
        }
        Builder builder = new Builder();
        builder.h = keywordSearchResultDecorationModel.m8652a();
        if (keywordSearchResultDecorationModel.m8653b() != null) {
            ImmutableList.Builder builder2 = ImmutableList.builder();
            for (int i = 0; i < keywordSearchResultDecorationModel.m8653b().size(); i++) {
                Object obj;
                OrderedSnippetsModel orderedSnippetsModel = (OrderedSnippetsModel) keywordSearchResultDecorationModel.m8653b().get(i);
                if (orderedSnippetsModel == null) {
                    obj = null;
                } else {
                    GraphQLTextWithEntities graphQLTextWithEntities;
                    GraphQLGraphSearchSnippet.Builder builder3 = new GraphQLGraphSearchSnippet.Builder();
                    SentenceModel a = orderedSnippetsModel.m8648a();
                    if (a == null) {
                        graphQLTextWithEntities = null;
                    } else {
                        GraphQLTextWithEntities.Builder builder4 = new GraphQLTextWithEntities.Builder();
                        builder4.i = a.m8643a();
                        graphQLTextWithEntities = builder4.a();
                    }
                    builder3.e = graphQLTextWithEntities;
                    GraphQLGraphSearchSnippet graphQLGraphSearchSnippet = new GraphQLGraphSearchSnippet(builder3);
                }
                builder2.c(obj);
            }
            builder.i = builder2.b();
        }
        builder.j = keywordSearchResultDecorationModel.m8654c();
        return new GraphQLGraphSearchResultDecoration(builder);
    }
}
