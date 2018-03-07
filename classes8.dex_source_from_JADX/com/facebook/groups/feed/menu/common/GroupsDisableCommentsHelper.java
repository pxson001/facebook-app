package com.facebook.groups.feed.menu.common;

import android.content.res.Resources;
import com.facebook.auth.module.String_LoggedInUserIdMethodAutoProvider;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.common.identifiers.SafeUUIDGenerator;
import com.facebook.controller.mutation.gk.ControllerMutationGatekeepers;
import com.facebook.controller.mutation.util.FeedStoryMutator;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.core.props.StoryProps;
import com.facebook.feed.util.event.FeedEventBus;
import com.facebook.feed.util.event.StoryEvents.FeedUnitMutatedEvent;
import com.facebook.graphql.calls.FeedbackDisableCommentingInputData;
import com.facebook.graphql.calls.FeedbackEnableCommentingInputData;
import com.facebook.graphql.calls.GraphQlCallInput;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.model.FeedUnit;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.GraphQLStoryActionLink;
import com.facebook.graphql.model.GraphQLStorySet;
import com.facebook.graphql.model.GraphQLTextWithEntities;
import com.facebook.graphql.model.GraphQLTextWithEntities.Builder;
import com.facebook.graphql.model.StoryActionLinkHelper;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.groups.feed.protocol.FeedStoryMutations.FeedbackDisableCommentingMutationString;
import com.facebook.groups.feed.protocol.FeedStoryMutations.FeedbackEnableCommentingMutationString;
import com.facebook.groups.feed.protocol.FeedStoryMutationsModels.CommentsDisabledNoticeFieldsModel;
import com.facebook.groups.feed.protocol.FeedStoryMutationsModels.FeedbackDisableCommentingMutationModel;
import com.facebook.groups.feed.protocol.FeedStoryMutationsModels.FeedbackEnableCommentingMutationModel;
import com.facebook.inject.InjectorLike;
import com.facebook.ui.toaster.ToastBuilder;
import com.facebook.ui.toaster.Toaster;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import java.util.concurrent.ExecutorService;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: viewDidDisappear */
public class GroupsDisableCommentsHelper {
    public final String f499a;
    public final GraphQLQueryExecutor f500b;
    public final ExecutorService f501c;
    private final Resources f502d;
    public final Toaster f503e;
    private final FeedStoryMutator f504f;
    private final FeedEventBus f505g;
    public final ControllerMutationGatekeepers f506h;

    public static GroupsDisableCommentsHelper m488a(InjectorLike injectorLike) {
        return new GroupsDisableCommentsHelper(String_LoggedInUserIdMethodAutoProvider.b(injectorLike), (ExecutorService) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(injectorLike), FeedEventBus.a(injectorLike), FeedStoryMutator.b(injectorLike), GraphQLQueryExecutor.a(injectorLike), ResourcesMethodAutoProvider.a(injectorLike), Toaster.b(injectorLike), ControllerMutationGatekeepers.b(injectorLike));
    }

    @Inject
    public GroupsDisableCommentsHelper(String str, ExecutorService executorService, FeedEventBus feedEventBus, FeedStoryMutator feedStoryMutator, GraphQLQueryExecutor graphQLQueryExecutor, Resources resources, Toaster toaster, ControllerMutationGatekeepers controllerMutationGatekeepers) {
        this.f499a = str;
        this.f501c = executorService;
        this.f505g = feedEventBus;
        this.f504f = feedStoryMutator;
        this.f500b = graphQLQueryExecutor;
        this.f502d = resources;
        this.f503e = toaster;
        this.f506h = controllerMutationGatekeepers;
    }

    private static boolean m491c(FeedUnit feedUnit) {
        GraphQLStoryActionLink e = m493e(feedUnit);
        if (e == null || e.D() == null) {
            return false;
        }
        return e.D().x();
    }

    private static boolean m492d(FeedUnit feedUnit) {
        GraphQLStoryActionLink e = m493e(feedUnit);
        if (e == null || e.D() == null || e.D().x()) {
            return false;
        }
        return true;
    }

    public static boolean m490a(FeedUnit feedUnit) {
        return m491c(feedUnit) || m492d(feedUnit);
    }

    public final void m494a(final FeedProps<GraphQLStory> feedProps) {
        GraphQLStory graphQLStory = (GraphQLStory) feedProps.a;
        GraphQLStory graphQLStory2;
        GraphQlCallInput graphQlCallInput;
        GraphQlCallInput graphQlCallInput2;
        GraphQlQueryString feedbackEnableCommentingMutationString;
        if (m491c(graphQLStory)) {
            graphQLStory2 = (GraphQLStory) feedProps.a;
            FeedbackEnableCommentingInputData feedbackEnableCommentingInputData = new FeedbackEnableCommentingInputData();
            feedbackEnableCommentingInputData.a("client_mutation_id", SafeUUIDGenerator.a().toString());
            graphQlCallInput = feedbackEnableCommentingInputData;
            graphQlCallInput.a("actor_id", this.f499a);
            graphQlCallInput = graphQlCallInput;
            graphQlCallInput.a("feedback_id", graphQLStory2.l().z_());
            graphQlCallInput2 = graphQlCallInput;
            feedbackEnableCommentingMutationString = new FeedbackEnableCommentingMutationString();
            feedbackEnableCommentingMutationString.a("input", graphQlCallInput2);
            Futures.a(this.f500b.a(GraphQLRequest.a(feedbackEnableCommentingMutationString)), new FutureCallback<GraphQLResult<FeedbackEnableCommentingMutationModel>>(this) {
                final /* synthetic */ GroupsDisableCommentsHelper f496b;

                public void onSuccess(Object obj) {
                    GraphQLResult graphQLResult = (GraphQLResult) obj;
                    if (this.f496b.f506h.b() && graphQLResult != null && graphQLResult.e != null && ((FeedbackEnableCommentingMutationModel) graphQLResult.e).a() != null) {
                        GroupsDisableCommentsHelper.m489a(this.f496b, feedProps, ((FeedbackEnableCommentingMutationModel) graphQLResult.e).a());
                    }
                }

                public void onFailure(Throwable th) {
                    this.f496b.f503e.a(new ToastBuilder(2131233449));
                }
            }, this.f501c);
        } else if (m492d(graphQLStory)) {
            graphQLStory2 = (GraphQLStory) feedProps.a;
            FeedbackDisableCommentingInputData feedbackDisableCommentingInputData = new FeedbackDisableCommentingInputData();
            feedbackDisableCommentingInputData.a("client_mutation_id", SafeUUIDGenerator.a().toString());
            graphQlCallInput = feedbackDisableCommentingInputData;
            graphQlCallInput.a("actor_id", this.f499a);
            graphQlCallInput = graphQlCallInput;
            graphQlCallInput.a("feedback_id", graphQLStory2.l().z_());
            graphQlCallInput2 = graphQlCallInput;
            feedbackEnableCommentingMutationString = new FeedbackDisableCommentingMutationString();
            feedbackEnableCommentingMutationString.a("input", graphQlCallInput2);
            Futures.a(this.f500b.a(GraphQLRequest.a(feedbackEnableCommentingMutationString)), new FutureCallback<GraphQLResult<FeedbackDisableCommentingMutationModel>>(this) {
                final /* synthetic */ GroupsDisableCommentsHelper f498b;

                public void onSuccess(Object obj) {
                    GraphQLResult graphQLResult = (GraphQLResult) obj;
                    if (this.f498b.f506h.b() && graphQLResult != null && graphQLResult.e != null && ((FeedbackDisableCommentingMutationModel) graphQLResult.e).a() != null) {
                        GroupsDisableCommentsHelper.m489a(this.f498b, feedProps, ((FeedbackDisableCommentingMutationModel) graphQLResult.e).a());
                    }
                }

                public void onFailure(Throwable th) {
                    this.f498b.f503e.a(new ToastBuilder(2131233449));
                }
            }, this.f501c);
        }
    }

    private static GraphQLStoryActionLink m493e(FeedUnit feedUnit) {
        return StoryActionLinkHelper.a((GraphQLStory) feedUnit, -1103690310);
    }

    public final String m495b(FeedUnit feedUnit) {
        if (m491c(feedUnit)) {
            return this.f502d.getString(2131233460);
        }
        if (m492d(feedUnit)) {
            return this.f502d.getString(2131233461);
        }
        return null;
    }

    public static void m489a(GroupsDisableCommentsHelper groupsDisableCommentsHelper, @Nullable FeedProps feedProps, CommentsDisabledNoticeFieldsModel commentsDisabledNoticeFieldsModel) {
        if (commentsDisabledNoticeFieldsModel != null) {
            GraphQLTextWithEntities graphQLTextWithEntities;
            GraphQLStory graphQLStory = (GraphQLStory) feedProps.a;
            FeedStoryMutator feedStoryMutator = groupsDisableCommentsHelper.f504f;
            boolean j = commentsDisabledNoticeFieldsModel.j();
            boolean l = commentsDisabledNoticeFieldsModel.l();
            if (commentsDisabledNoticeFieldsModel.k() == null) {
                graphQLTextWithEntities = null;
            } else {
                Builder builder = new Builder();
                builder.i = commentsDisabledNoticeFieldsModel.k().a();
                graphQLTextWithEntities = builder.a();
            }
            GraphQLStory a = feedStoryMutator.a(graphQLStory, j, l, graphQLTextWithEntities);
            GraphQLStorySet h = StoryProps.h(feedProps);
            if (h == null) {
                h = a;
            }
            groupsDisableCommentsHelper.f505g.a(new FeedUnitMutatedEvent((FeedUnit) h));
        }
    }
}
