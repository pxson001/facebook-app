package com.facebook.feed.sponsored;

import com.facebook.graphql.model.GraphQLFeedUnitEdge;
import com.facebook.graphql.model.Sponsorable;

/* compiled from: Typeahead data must be set before starting the fragment! */
public class SponsoredFeedUnitValidator$SponsorableUnit {
    public GraphQLFeedUnitEdge f21682a;
    public int f21683b;

    SponsoredFeedUnitValidator$SponsorableUnit(GraphQLFeedUnitEdge graphQLFeedUnitEdge, int i) {
        this.f21682a = graphQLFeedUnitEdge;
        this.f21683b = i;
    }

    public final GraphQLFeedUnitEdge m24257a() {
        return this.f21682a;
    }

    public final Sponsorable m24258b() {
        return (Sponsorable) this.f21682a.c();
    }

    public final int m24259c() {
        return this.f21683b;
    }
}
