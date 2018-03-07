package com.facebook.goodwill.feed.rows;

import com.facebook.graphql.model.GraphQLFeedUnitEdge;

/* compiled from: false. Is in exposure holdout. */
public class ThrowbackYearMarkerFeedUnitEdge extends GraphQLFeedUnitEdge {
    public ThrowbackYearMarkerFeedUnitEdge(String str, String str2, boolean z) {
        this.i = new ThrowbackYearMarkerFeedUnit(str, str2, z);
        this.f = str + str2;
    }

    public String toString() {
        return "GoodwillThrowback.YEAR_MARKER";
    }
}
