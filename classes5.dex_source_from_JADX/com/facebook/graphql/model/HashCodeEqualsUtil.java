package com.facebook.graphql.model;

import com.facebook.graphql.parser.GraphQlIdParserUtil;
import com.google.common.base.Objects;

/* compiled from: TWITTER_SHARE */
public class HashCodeEqualsUtil {
    private HashCodeEqualsUtil() {
    }

    public static boolean m22548a(GraphQLComment graphQLComment, Object obj) {
        if (obj instanceof GraphQLComment) {
            GraphQLComment graphQLComment2 = (GraphQLComment) obj;
            if (graphQLComment == graphQLComment2) {
                return true;
            }
            if (graphQLComment.H() != null && graphQLComment2.H() != null) {
                return graphQLComment.H().equals(graphQLComment2.H());
            }
            if (graphQLComment.l() != null && graphQLComment2.l() != null) {
                return Objects.equal(GraphQlIdParserUtil.m9588a(graphQLComment.l().j()), GraphQlIdParserUtil.m9588a(graphQLComment2.l().j()));
            }
            if (!(graphQLComment.y() == null || graphQLComment2.y() == null)) {
                return graphQLComment.y().equals(graphQLComment2.y());
            }
        }
        return false;
    }

    public static boolean m22549a(GraphQLFeedUnitEdge graphQLFeedUnitEdge, Object obj) {
        if (!(obj instanceof GraphQLFeedUnitEdge)) {
            return false;
        }
        return Objects.equal(DedupableUtil.a(graphQLFeedUnitEdge), DedupableUtil.a((GraphQLFeedUnitEdge) obj));
    }

    public static boolean m22551a(GraphQLStoryAttachment graphQLStoryAttachment, Object obj) {
        if (!(obj instanceof GraphQLStoryAttachment)) {
            return false;
        }
        GraphQLStoryAttachment graphQLStoryAttachment2 = (GraphQLStoryAttachment) obj;
        if (graphQLStoryAttachment == graphQLStoryAttachment2) {
            return true;
        }
        if (graphQLStoryAttachment.m() != null) {
            return Objects.equal(graphQLStoryAttachment.m(), graphQLStoryAttachment2.m());
        }
        return false;
    }

    public static boolean m22550a(GraphQLStory graphQLStory, Object obj) {
        if (obj == null || !(obj instanceof GraphQLStory) || graphQLStory == null) {
            return false;
        }
        return Objects.equal(graphQLStory.c(), ((GraphQLStory) obj).c());
    }
}
