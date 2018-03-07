package com.facebook.checkin.socialsearch.utils;

import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.inject.InjectorLike;
import com.facebook.story.GraphQLStoryHelper;
import com.facebook.ui.futures.TasksManager;
import javax.inject.Inject;

/* compiled from: uTexture */
public class DeletePlaceRecommendationFromCommentMutationHelper {
    public final GraphQLQueryExecutor f1148a;
    private final GraphQLStoryHelper f1149b;
    public final TasksManager f1150c;

    public static DeletePlaceRecommendationFromCommentMutationHelper m1240b(InjectorLike injectorLike) {
        return new DeletePlaceRecommendationFromCommentMutationHelper(GraphQLQueryExecutor.a(injectorLike), GraphQLStoryHelper.a(injectorLike), TasksManager.b(injectorLike));
    }

    @Inject
    public DeletePlaceRecommendationFromCommentMutationHelper(GraphQLQueryExecutor graphQLQueryExecutor, GraphQLStoryHelper graphQLStoryHelper, TasksManager tasksManager) {
        this.f1148a = graphQLQueryExecutor;
        this.f1149b = graphQLStoryHelper;
        this.f1150c = tasksManager;
    }
}
