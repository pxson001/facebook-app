package com.facebook.graphql.model;

import com.facebook.common.util.StringUtil;

/* compiled from: groups/events/<p$1> */
public class GraphQLCommentHelper {
    public static String m29307a(GraphQLComment graphQLComment) {
        if (graphQLComment.m27185r() != null) {
            return graphQLComment.m27185r().aa();
        }
        return null;
    }

    public static boolean m29308b(GraphQLComment graphQLComment) {
        return graphQLComment.m27184q() != null && graphQLComment.m27184q().size() > 0;
    }

    public static GraphQLStoryAttachment m29309c(GraphQLComment graphQLComment) {
        if (m29308b(graphQLComment)) {
            return (GraphQLStoryAttachment) graphQLComment.m27178j().get(0);
        }
        return null;
    }

    private static GraphQLStoryAttachment m29306a(GraphQLComment graphQLComment, int i) {
        GraphQLStoryAttachment c = m29309c(graphQLComment);
        return (c == null || c.m23979r() == null || c.m23979r().m24453j() == null || c.m23979r().m24453j().m22301g() != i) ? null : c;
    }

    public static GraphQLStoryAttachment m29310e(GraphQLComment graphQLComment) {
        return m29306a(graphQLComment, -225599203);
    }

    public static GraphQLStoryAttachment m29311f(GraphQLComment graphQLComment) {
        return m29306a(graphQLComment, 77090322);
    }

    public static boolean m29312g(GraphQLComment graphQLComment) {
        return m29310e(graphQLComment) != null;
    }

    public static boolean m29313i(GraphQLComment graphQLComment) {
        return (graphQLComment.m27186s() == null || StringUtil.m3599c(graphQLComment.m27186s().mo2911a())) ? false : true;
    }

    public static boolean m29314k(GraphQLComment graphQLComment) {
        return graphQLComment.m27193z() != null && graphQLComment.m27193z().m27685a() > 0;
    }
}
