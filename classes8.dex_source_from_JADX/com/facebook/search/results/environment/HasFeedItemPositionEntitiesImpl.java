package com.facebook.search.results.environment;

import com.facebook.graphql.model.GraphQLGraphSearchResultsEdge;
import com.facebook.graphql.model.GraphQLNode;
import com.facebook.inject.Assisted;
import com.facebook.search.results.model.SearchResultsEntitiesCollection;
import javax.inject.Inject;

/* compiled from: Successfully cleared recent searches cache! */
public class HasFeedItemPositionEntitiesImpl implements HasFeedItemPosition {
    private final SearchResultsEntitiesCollection f22542a;

    @Inject
    public HasFeedItemPositionEntitiesImpl(@Assisted SearchResultsEntitiesCollection searchResultsEntitiesCollection) {
        this.f22542a = searchResultsEntitiesCollection;
    }

    public final int mo1245a(Object obj) {
        if (obj instanceof GraphQLNode) {
            SearchResultsEntitiesCollection searchResultsEntitiesCollection = this.f22542a;
            GraphQLNode graphQLNode = (GraphQLNode) obj;
            int i = 0;
            while (i < searchResultsEntitiesCollection.f23341a.size()) {
                if (((GraphQLGraphSearchResultsEdge) searchResultsEntitiesCollection.f23341a.get(i)).j() == graphQLNode) {
                    break;
                }
                i++;
            }
            i = -1;
            return i;
        } else if (!(obj instanceof GraphQLGraphSearchResultsEdge)) {
            return -1;
        } else {
            return this.f22542a.f23341a.indexOf((GraphQLGraphSearchResultsEdge) obj);
        }
    }
}
