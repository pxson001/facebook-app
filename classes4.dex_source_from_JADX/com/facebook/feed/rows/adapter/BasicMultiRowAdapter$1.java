package com.facebook.feed.rows.adapter;

import com.facebook.feed.rows.adapter.api.HasMarkers.Marker;
import com.facebook.feed.rows.core.BoundedAdapter;
import com.facebook.graphql.model.GraphQLFeedUnitEdge;

/* compiled from: primary_action */
class BasicMultiRowAdapter$1 implements Marker {
    final /* synthetic */ GraphQLFeedUnitEdge f4235a;
    final /* synthetic */ int f4236b;
    final /* synthetic */ BasicMultiRowAdapter f4237c;

    BasicMultiRowAdapter$1(BasicMultiRowAdapter basicMultiRowAdapter, GraphQLFeedUnitEdge graphQLFeedUnitEdge, int i) {
        this.f4237c = basicMultiRowAdapter;
        this.f4235a = graphQLFeedUnitEdge;
        this.f4236b = i;
    }

    public final int m4767a() {
        for (int i = 0; i < this.f4237c.aZ_(); i++) {
            if (((BoundedAdapter) this.f4237c.getItem(i)).d == this.f4235a) {
                return this.f4236b + i;
            }
        }
        return Integer.MIN_VALUE;
    }
}
