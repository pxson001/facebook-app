package com.facebook.graphql.model;

/* compiled from: log_in */
public class DedupableUtil {

    /* compiled from: log_in */
    public interface SentinelEdge {
        String m23085a();
    }

    private DedupableUtil() {
    }

    public static String m23084a(GraphQLFeedUnitEdge graphQLFeedUnitEdge) {
        if (graphQLFeedUnitEdge instanceof SentinelEdge) {
            return ((SentinelEdge) graphQLFeedUnitEdge).m23085a();
        }
        String b = graphQLFeedUnitEdge.m19080b();
        if (b == null && (graphQLFeedUnitEdge instanceof GraphQLFeedUnitEdge)) {
            return GraphQLHelper.m22472a(graphQLFeedUnitEdge);
        }
        return b;
    }
}
