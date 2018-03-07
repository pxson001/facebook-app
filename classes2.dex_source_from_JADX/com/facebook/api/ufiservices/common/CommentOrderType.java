package com.facebook.api.ufiservices.common;

import com.facebook.common.util.StringUtil;
import com.facebook.graphql.model.GraphQLFeedback;
import javax.annotation.Nullable;

/* compiled from: group_owner_authored_stories.total_for_sale_count */
public enum CommentOrderType {
    RANKED_ORDER("ranked_threaded"),
    THREADED_CHRONOLOGICAL_ORDER("toplevel"),
    DEFAULT_ORDER(null);
    
    @Nullable
    public String toString;

    private CommentOrderType(String str) {
        this.toString = str;
    }

    public static CommentOrderType getOrder(GraphQLFeedback graphQLFeedback) {
        if (graphQLFeedback == null) {
            return DEFAULT_ORDER;
        }
        String s = graphQLFeedback.m23252s();
        for (CommentOrderType commentOrderType : values()) {
            if (StringUtil.m3590a(commentOrderType.toString, s)) {
                return commentOrderType;
            }
        }
        return DEFAULT_ORDER;
    }

    public static CommentOrderType getOrder(String str) {
        for (CommentOrderType commentOrderType : values()) {
            if (StringUtil.m3590a(commentOrderType.toString, str)) {
                return commentOrderType;
            }
        }
        return DEFAULT_ORDER;
    }

    public static boolean isReverseOrder(GraphQLFeedback graphQLFeedback) {
        return isRanked(getOrder(graphQLFeedback));
    }

    public static boolean isRanked(CommentOrderType commentOrderType) {
        return commentOrderType == RANKED_ORDER;
    }

    public static boolean isRanked(GraphQLFeedback graphQLFeedback) {
        return isRanked(getOrder(graphQLFeedback));
    }

    public final String toString() {
        return this.toString;
    }
}
