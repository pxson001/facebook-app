package com.facebook.checkin.socialsearch.utils;

import com.facebook.api.graphql.storyattachment.StoryAttachmentGraphQLModels.CommentPlaceInfoAttachmentTargetModel.PlaceListItemsModel.NodesModel;
import com.facebook.api.graphql.storyattachment.StoryAttachmentGraphQLModels.CommentPlaceInfoPageFieldsModel;
import com.facebook.checkin.socialsearch.graphql.PlaceRecommendationPageConversionHelper;
import com.facebook.checkin.socialsearch.graphql.SocialSearchGraphQLMutations.AddPlaceListItemToCommentMutationString;
import com.facebook.checkin.socialsearch.graphql.SocialSearchGraphQLMutationsModels.AddPlaceListItemToCommentMutationModel;
import com.facebook.checkin.socialsearch.graphql.SocialSearchGraphQLMutationsModels.CommentFieldsForPlaceMutationModel.AttachmentsModel;
import com.facebook.checkin.socialsearch.graphql.SocialSearchGraphQLMutationsModels.CommentFieldsForPlaceMutationModel.AttachmentsModel.TargetModel;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.controller.mutation.util.FeedStoryMutator;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.core.props.StoryProps;
import com.facebook.feed.util.event.FeedEventBus;
import com.facebook.feed.util.event.StoryEvents.FeedUnitMutatedEvent;
import com.facebook.graphql.calls.CommentAddPlaceInputData;
import com.facebook.graphql.calls.GraphQlCallInput;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.model.GraphQLPage;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.inject.InjectorLike;
import com.facebook.story.GraphQLStoryHelper;
import com.facebook.ui.futures.TasksManager;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.ListenableFuture;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: udta */
public class AddPlaceListItemToCommentMutationHelper {
    private final GraphQLQueryExecutor f1139a;
    private final GraphQLStoryHelper f1140b;
    public final FeedStoryMutator f1141c;
    public final FeedEventBus f1142d;
    private final TasksManager f1143e;

    /* compiled from: udta */
    public class C01081 implements FutureCallback<GraphQLResult<AddPlaceListItemToCommentMutationModel>> {
        final /* synthetic */ String f1135a;
        final /* synthetic */ GraphQLStory f1136b;
        final /* synthetic */ String f1137c;
        final /* synthetic */ AddPlaceListItemToCommentMutationHelper f1138d;

        public C01081(AddPlaceListItemToCommentMutationHelper addPlaceListItemToCommentMutationHelper, String str, GraphQLStory graphQLStory, String str2) {
            this.f1138d = addPlaceListItemToCommentMutationHelper;
            this.f1135a = str;
            this.f1136b = graphQLStory;
            this.f1137c = str2;
        }

        public void onSuccess(@Nullable Object obj) {
            GraphQLPage graphQLPage;
            GraphQLResult graphQLResult = (GraphQLResult) obj;
            String str = this.f1135a;
            int i = 0;
            if (graphQLResult == null || graphQLResult.e == null || ((AddPlaceListItemToCommentMutationModel) graphQLResult.e).m1168a() == null || ((AddPlaceListItemToCommentMutationModel) graphQLResult.e).m1168a().m1202j() == null || ((AddPlaceListItemToCommentMutationModel) graphQLResult.e).m1168a().m1202j().isEmpty()) {
                graphQLPage = null;
            } else {
                TargetModel a = ((AttachmentsModel) ((AddPlaceListItemToCommentMutationModel) graphQLResult.e).m1168a().m1202j().get(0)).m1185a();
                if (a == null || a.m1183j() == null || a.m1183j().a().isEmpty()) {
                    graphQLPage = null;
                } else {
                    ImmutableList a2 = a.m1183j().a();
                    int size = a2.size();
                    while (i < size) {
                        CommentPlaceInfoPageFieldsModel a3 = ((NodesModel) a2.get(i)).a();
                        if (a3.bq_().equals(str)) {
                            graphQLPage = PlaceRecommendationPageConversionHelper.m1088a(a3);
                            break;
                        }
                        i++;
                    }
                    graphQLPage = null;
                }
            }
            GraphQLPage graphQLPage2 = graphQLPage;
            if (graphQLPage2 != null) {
                FeedProps a4 = this.f1138d.f1141c.a(FeedProps.c(this.f1136b), graphQLPage2, this.f1137c);
                if (a4 != null) {
                    this.f1138d.f1142d.a(new FeedUnitMutatedEvent(StoryProps.f(a4)));
                }
            }
        }

        public void onFailure(Throwable th) {
        }
    }

    public static AddPlaceListItemToCommentMutationHelper m1236b(InjectorLike injectorLike) {
        return new AddPlaceListItemToCommentMutationHelper(GraphQLQueryExecutor.a(injectorLike), GraphQLStoryHelper.a(injectorLike), FeedStoryMutator.b(injectorLike), FeedEventBus.a(injectorLike), TasksManager.b(injectorLike));
    }

    @Inject
    public AddPlaceListItemToCommentMutationHelper(GraphQLQueryExecutor graphQLQueryExecutor, GraphQLStoryHelper graphQLStoryHelper, FeedStoryMutator feedStoryMutator, FeedEventBus feedEventBus, TasksManager tasksManager) {
        this.f1139a = graphQLQueryExecutor;
        this.f1140b = graphQLStoryHelper;
        this.f1141c = feedStoryMutator;
        this.f1142d = feedEventBus;
        this.f1143e = tasksManager;
    }

    public final void m1237a(String str, String str2, @Nullable FutureCallback<GraphQLResult<AddPlaceListItemToCommentMutationModel>> futureCallback) {
        CommentAddPlaceInputData commentAddPlaceInputData = new CommentAddPlaceInputData();
        commentAddPlaceInputData.a("comment_id", str);
        GraphQlCallInput graphQlCallInput = commentAddPlaceInputData;
        graphQlCallInput.a("place_ids", ImmutableList.of(str2));
        graphQlCallInput = graphQlCallInput;
        GraphQlQueryString addPlaceListItemToCommentMutationString = new AddPlaceListItemToCommentMutationString();
        addPlaceListItemToCommentMutationString.a("input", graphQlCallInput);
        addPlaceListItemToCommentMutationString.a("profile_image_size", GraphQLStoryHelper.a());
        ListenableFuture a = this.f1139a.a(GraphQLRequest.a(addPlaceListItemToCommentMutationString));
        if (futureCallback != null) {
            this.f1143e.a("add_place", a, AbstractDisposableFutureCallback.a(futureCallback));
        }
    }
}
