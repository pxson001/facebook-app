package com.facebook.search.results.environment;

import com.facebook.graphql.model.FeedUnit;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel;

/* compiled from: SuggestifierQuestionVoteMutation */
public interface CanReplaceSearchResult extends AnyEnvironment {
    void mo1242a(GraphQLStory graphQLStory);

    void mo1243a(SearchResultsEdgeModel searchResultsEdgeModel, SearchResultsEdgeModel searchResultsEdgeModel2);

    boolean mo1244a(FeedUnit feedUnit);
}
