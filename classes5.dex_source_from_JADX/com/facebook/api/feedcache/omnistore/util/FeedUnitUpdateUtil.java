package com.facebook.api.feedcache.omnistore.util;

import com.facebook.controller.mutation.util.FeedStoryMutator;
import com.facebook.controller.mutation.util.FeedbackMutator;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.model.FeedUnit;
import com.facebook.graphql.model.GraphQLFeedback;
import com.facebook.graphql.model.GraphQLStory;
import java.nio.ByteBuffer;

/* compiled from: appendable */
public class FeedUnitUpdateUtil {
    public static String m14731a(FeedUnit feedUnit) {
        if (feedUnit instanceof GraphQLStory) {
            return ((GraphQLStory) feedUnit).c();
        }
        return "";
    }

    public static int m14733b(FeedUnit feedUnit) {
        if (feedUnit instanceof GraphQLStory) {
            return ((GraphQLStory) feedUnit).aa_();
        }
        return 0;
    }

    public static int m14736c(FeedUnit feedUnit) {
        if (feedUnit instanceof GraphQLStory) {
            return ((GraphQLStory) feedUnit).n();
        }
        return 0;
    }

    public static GraphQLStory m14730a(GraphQLStory graphQLStory, int i) {
        GraphQLFeedback l = graphQLStory.l();
        return l == null ? graphQLStory : FeedStoryMutator.a(graphQLStory, FeedbackMutator.a(l, i));
    }

    public static GraphQLStory m14734b(GraphQLStory graphQLStory, int i) {
        GraphQLFeedback l = graphQLStory.l();
        return l == null ? graphQLStory : FeedStoryMutator.a(graphQLStory, FeedbackMutator.b(l, i));
    }

    public static byte[] m14732a(GraphQLStory graphQLStory) {
        MutableFlatBuffer w_ = graphQLStory.w_();
        if (w_ == null || !w_.d || !w_.b()) {
            return null;
        }
        ByteBuffer c = w_.c();
        if (c != null) {
            return c.array();
        }
        return null;
    }

    public static byte[] m14735b(GraphQLStory graphQLStory) {
        MutableFlatBuffer w_ = graphQLStory.w_();
        if (w_ == null || !w_.d || !w_.d()) {
            return null;
        }
        ByteBuffer e = w_.e();
        if (e != null) {
            return e.array();
        }
        return null;
    }

    public static boolean m14737d(FeedUnit feedUnit) {
        return feedUnit instanceof GraphQLStory;
    }
}
