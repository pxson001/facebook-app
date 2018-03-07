package com.facebook.api.feedcache.resync;

import com.facebook.api.graphql.fetchstories.FetchCachedStoryUpdatesModels.SingleNodeQueryModel;
import com.facebook.common.time.SystemClock;
import com.facebook.controller.mutation.util.FeedStoryMutator;
import com.facebook.controller.mutation.util.FeedbackMutator;
import com.facebook.controller.mutation.util.GraphQLTextWithEntitiesMutator;
import com.facebook.graphql.model.GraphQLFeedback;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.GraphQLStory.Builder;
import com.facebook.graphql.model.GraphQLTextWithEntities;
import com.facebook.graphql.model.StoryHierarchyHelper;

/* compiled from: message_button_nux_mutation_failure */
public class NewsFeedCacheSyncDataUtils {
    public static GraphQLStory m6647a(GraphQLStory graphQLStory, SingleNodeQueryModel singleNodeQueryModel) {
        GraphQLFeedback a;
        GraphQLTextWithEntities a2;
        GraphQLStory graphQLStory2;
        GraphQLTextWithEntities graphQLTextWithEntities = null;
        if (singleNodeQueryModel.k() != null) {
            if (singleNodeQueryModel.k().j() != null) {
                a = FeedbackMutator.a(graphQLStory.l(), singleNodeQueryModel.k().j().a());
            } else {
                a = null;
            }
            if (singleNodeQueryModel.k().a() != null) {
                a = FeedbackMutator.b(a, singleNodeQueryModel.k().a().a());
            }
        } else {
            a = null;
        }
        GraphQLStory a3 = FeedStoryMutator.a(graphQLStory, a);
        if (singleNodeQueryModel.n() != null) {
            a2 = GraphQLTextWithEntitiesMutator.a(a3.aH(), singleNodeQueryModel.n().a());
        } else {
            a2 = null;
        }
        if (a3 == null) {
            graphQLStory2 = null;
        } else {
            Builder a4 = Builder.a(a3);
            a4.ay = a2;
            a4 = a4;
            a4.F = SystemClock.a.a();
            graphQLStory2 = a4.a();
        }
        GraphQLStory graphQLStory3 = graphQLStory2;
        if (singleNodeQueryModel.m() != null) {
            graphQLTextWithEntities = GraphQLTextWithEntitiesMutator.a(StoryHierarchyHelper.b(graphQLStory3), singleNodeQueryModel.m().a());
        }
        if (graphQLStory3 == null) {
            graphQLStory2 = null;
        } else {
            a4 = Builder.a(graphQLStory3);
            a4.X = graphQLTextWithEntities;
            a4 = a4;
            a4.F = SystemClock.a.a();
            graphQLStory2 = a4.a();
        }
        return graphQLStory2;
    }
}
