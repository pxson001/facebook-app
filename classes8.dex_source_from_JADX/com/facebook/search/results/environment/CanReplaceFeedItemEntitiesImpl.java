package com.facebook.search.results.environment;

import com.facebook.graphql.model.GraphQLGraphSearchResultsEdge;
import com.facebook.graphql.model.GraphQLGraphSearchResultsEdge.Builder;
import com.facebook.graphql.model.GraphQLNode;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.inject.Assisted;
import com.facebook.search.results.model.SearchResultsEntitiesCollection;
import javax.inject.Inject;

/* compiled from: System-Light */
public class CanReplaceFeedItemEntitiesImpl implements CanReplaceFeedItem {
    private final SearchResultsEntitiesCollection f22534a;
    private final HasFeedItemPosition f22535b;

    @Inject
    public CanReplaceFeedItemEntitiesImpl(@Assisted SearchResultsEntitiesCollection searchResultsEntitiesCollection, @Assisted HasFeedItemPosition hasFeedItemPosition) {
        this.f22534a = searchResultsEntitiesCollection;
        this.f22535b = hasFeedItemPosition;
    }

    public final void mo1241a(Object obj, Object obj2) {
        int a = this.f22535b.mo1245a(obj);
        if (a != -1) {
            if (obj instanceof GraphQLNode) {
                SearchResultsEntitiesCollection searchResultsEntitiesCollection = this.f22534a;
                GraphQLNode graphQLNode = (GraphQLNode) obj2;
                GraphQLGraphSearchResultsEdge graphQLGraphSearchResultsEdge = (GraphQLGraphSearchResultsEdge) searchResultsEntitiesCollection.f23341a.get(a);
                Builder builder = new Builder();
                graphQLGraphSearchResultsEdge.h();
                builder.d = graphQLGraphSearchResultsEdge.a();
                builder.e = graphQLGraphSearchResultsEdge.j();
                builder.f = graphQLGraphSearchResultsEdge.k();
                builder.g = graphQLGraphSearchResultsEdge.l();
                BaseModel.Builder.a(builder, graphQLGraphSearchResultsEdge);
                Builder builder2 = builder;
                builder2.e = graphQLNode;
                searchResultsEntitiesCollection.f23341a.set(a, new GraphQLGraphSearchResultsEdge(builder2));
            } else if (obj instanceof GraphQLGraphSearchResultsEdge) {
                this.f22534a.f23341a.set(a, (GraphQLGraphSearchResultsEdge) obj2);
            } else {
                throw new IllegalArgumentException("Unsupported item: " + obj);
            }
        }
    }
}
