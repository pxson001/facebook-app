package com.facebook.search.results.model;

import com.facebook.api.feed.data.collections.ListItemCollection;
import com.facebook.graphql.model.GraphQLGraphSearchResultsEdge;
import java.util.ArrayList;
import java.util.List;

/* compiled from: SAVE_OG_OBJECT */
public class SearchResultsEntitiesCollection implements ListItemCollection<GraphQLGraphSearchResultsEdge> {
    public final List<GraphQLGraphSearchResultsEdge> f23341a = new ArrayList();

    public final int m27045a() {
        return this.f23341a.size();
    }

    public final Object m27046a(int i) {
        return (GraphQLGraphSearchResultsEdge) this.f23341a.get(i);
    }
}
