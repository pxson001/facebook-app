package com.facebook.api.feed.data;

import com.facebook.feed.model.GapFeedEdge;
import com.facebook.graphql.model.DedupableUtil;
import com.facebook.graphql.model.GraphQLFeedUnitEdge;
import com.facebook.graphql.model.PropertyHelper;

/* compiled from: user_storage_key_prev */
public class GapFactory {
    public static GapFeedEdge m689a(String str, String str2, String str3, String str4, String str5, String str6) {
        GapFeedEdge gapFeedEdge = new GapFeedEdge(m690a(str2), str, m691c(str3), str6);
        PropertyHelper.b(gapFeedEdge, str4);
        PropertyHelper.a(gapFeedEdge, m690a(str5));
        return gapFeedEdge;
    }

    public static GapFeedEdge m688a(GraphQLFeedUnitEdge graphQLFeedUnitEdge, String str) {
        GapFeedEdge gapFeedEdge = new GapFeedEdge(m690a(graphQLFeedUnitEdge.V_()), graphQLFeedUnitEdge.W_(), m691c(DedupableUtil.a(graphQLFeedUnitEdge)), str);
        PropertyHelper.b(gapFeedEdge, gapFeedEdge.g());
        PropertyHelper.a(gapFeedEdge, gapFeedEdge.d());
        return gapFeedEdge;
    }

    public static String m690a(String str) {
        return str + ":gap";
    }

    private static String m691c(String str) {
        return str + "(gap)";
    }
}
