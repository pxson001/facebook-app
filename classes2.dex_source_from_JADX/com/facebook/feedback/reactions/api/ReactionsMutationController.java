package com.facebook.feedback.reactions.api;

import android.content.Context;
import com.facebook.api.graphql.reactions.ReactionsGraphQL.ViewerReactionsMutationString;
import com.facebook.api.graphql.reactions.ReactionsGraphQLModels.ViewerReactionsMutationFragmentModel;
import com.facebook.api.graphql.reactions.ReactionsGraphQLModels.ViewerReactionsMutationFragmentModel.FeedbackModel;
import com.facebook.api.graphql.reactions.ReactionsGraphQLModels.ViewerReactionsMutationFragmentModel.FeedbackModel.Builder;
import com.facebook.api.graphql.reactions.ReactionsGraphQLModels.ViewerReactionsMutationFragmentModel.FeedbackModel.LikersModel;
import com.facebook.api.graphql.reactions.ReactionsGraphQLModels.ViewerReactionsMutationFragmentModel.FeedbackModel.ReactorsModel;
import com.facebook.api.graphql.reactions.ReactionsGraphQLModels.ViewerReactionsMutationFragmentModel.FeedbackModel.ViewerFeedbackReactionModel;
import com.facebook.api.ufiservices.common.FeedbackLoggingParams;
import com.facebook.api.ufiservices.common.GraphQLActorCacheImpl;
import com.facebook.auth.module.ViewerContextManagerProvider;
import com.facebook.auth.viewercontext.ViewerContextManager;
import com.facebook.common.futures.DisposableFutureCallback;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.controller.mutation.util.FeedbackMutator;
import com.facebook.feedback.reactions.data.FeedbackReaction;
import com.facebook.feedback.reactions.util.ReactionsModelConversionHelper;
import com.facebook.graphql.calls.FeedbackReactInputData;
import com.facebook.graphql.calls.GraphQlCallInput;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.request.MutationRequest;
import com.facebook.graphql.model.GraphQLActor;
import com.facebook.graphql.model.GraphQLFeedback;
import com.facebook.graphql.model.GraphQLLikersOfContentConnection;
import com.facebook.graphql.model.GraphQLReactorsOfContentConnection;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.GraphQLSubstoriesConnection;
import com.facebook.graphql.model.StoryHierarchyHelper;
import com.facebook.graphql.query.TypedGraphQLMutationString;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.notifications.logging.NotificationsFunnelLogger;
import com.facebook.offlinemode.common.OfflineQueryBehavior;
import com.facebook.ui.futures.TasksManager;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;

@ContextScoped
/* compiled from: has_pending_saved_bookmark_nux */
public class ReactionsMutationController {
    private static final Class<?> f21346a = ReactionsMutationController.class;
    public static int f21347b = 0;
    private static ReactionsMutationController f21348i;
    private static final Object f21349j = new Object();
    private final TasksManager f21350c;
    public final GraphQLQueryExecutor f21351d;
    private final GraphQLActorCacheImpl f21352e;
    private final FeedbackMutator f21353f;
    public final ViewerContextManager f21354g;
    private final NotificationsFunnelLogger f21355h;

    private static ReactionsMutationController m29038b(InjectorLike injectorLike) {
        return new ReactionsMutationController(TasksManager.m14550b(injectorLike), GraphQLQueryExecutor.m10435a(injectorLike), GraphQLActorCacheImpl.m14532a(injectorLike), FeedbackMutator.m10618a(injectorLike), ViewerContextManagerProvider.m2496b(injectorLike), NotificationsFunnelLogger.m29041a(injectorLike));
    }

    public static ReactionsMutationController m29035a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ReactionsMutationController b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.m1330a(b2);
            synchronized (f21349j) {
                ReactionsMutationController reactionsMutationController;
                if (a2 != null) {
                    reactionsMutationController = (ReactionsMutationController) a2.mo818a(f21349j);
                } else {
                    reactionsMutationController = f21348i;
                }
                if (reactionsMutationController == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        b3 = m29038b(injectorThreadStack.m1474e());
                        if (a2 != null) {
                            a2.mo822a(f21349j, b3);
                        } else {
                            f21348i = b3;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    b3 = reactionsMutationController;
                }
            }
            return b3;
        } finally {
            a.m1505c(b);
        }
    }

    @Inject
    public ReactionsMutationController(TasksManager tasksManager, GraphQLQueryExecutor graphQLQueryExecutor, GraphQLActorCacheImpl graphQLActorCacheImpl, FeedbackMutator feedbackMutator, ViewerContextManager viewerContextManager, NotificationsFunnelLogger notificationsFunnelLogger) {
        this.f21350c = tasksManager;
        this.f21351d = graphQLQueryExecutor;
        this.f21352e = graphQLActorCacheImpl;
        this.f21353f = feedbackMutator;
        this.f21354g = viewerContextManager;
        this.f21355h = notificationsFunnelLogger;
    }

    public final void m29040a(GraphQLFeedback graphQLFeedback, FeedbackReaction feedbackReaction, FeedbackLoggingParams feedbackLoggingParams, DisposableFutureCallback disposableFutureCallback) {
        boolean z;
        int intValue = FeedbackReaction.m29190a(graphQLFeedback).intValue();
        StringBuilder append = new StringBuilder("mutate_reaction_").append(graphQLFeedback.mo2933j()).append(feedbackReaction.f21478e);
        int i = f21347b + 1;
        f21347b = i;
        Object stringBuilder = append.append(i).toString();
        TasksManager tasksManager = this.f21350c;
        Preconditions.checkNotNull(graphQLFeedback);
        Preconditions.checkNotNull(feedbackReaction);
        if (feedbackLoggingParams.f22389a != null) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkArgument(z, "Reaction mutations must include tracking codes.");
        String str = this.f21354g.mo215b() != null ? this.f21354g.mo215b().mUserId : this.f21354g.mo217d().mUserId;
        FeedbackReactInputData feedbackReactInputData = new FeedbackReactInputData();
        feedbackReactInputData.m11397a("actor_id", str);
        GraphQlCallInput graphQlCallInput = feedbackReactInputData;
        graphQlCallInput.m11397a("feedback_id", graphQLFeedback.z_());
        graphQlCallInput = graphQlCallInput;
        graphQlCallInput.m11397a("feedback_source", feedbackLoggingParams.f22391c);
        graphQlCallInput = graphQlCallInput;
        graphQlCallInput.m11397a("nectar_module", feedbackLoggingParams.f22390b);
        graphQlCallInput = graphQlCallInput;
        graphQlCallInput.m11396a("feedback_reaction", m29037a(feedbackReaction.f21478e));
        graphQlCallInput = graphQlCallInput;
        graphQlCallInput.m11398a("tracking", feedbackLoggingParams.m30313e());
        graphQlCallInput = graphQlCallInput;
        TypedGraphQLMutationString viewerReactionsMutationString = new ViewerReactionsMutationString();
        viewerReactionsMutationString.m11310a("input", graphQlCallInput);
        MutationRequest a = GraphQLRequest.m11588a(viewerReactionsMutationString);
        a.a(m29034a(graphQLFeedback, intValue, feedbackReaction));
        tasksManager.m14553a(stringBuilder, this.f21351d.m10449a(a, OfflineQueryBehavior.b), disposableFutureCallback);
        this.f21355h.m29051d(String.valueOf(feedbackReaction.f21478e));
    }

    public static Integer m29037a(int i) {
        if (i <= 0) {
            i = 0;
        }
        return Integer.valueOf(i);
    }

    public static ViewerReactionsMutationFragmentModel m29034a(GraphQLFeedback graphQLFeedback, int i, FeedbackReaction feedbackReaction) {
        ViewerFeedbackReactionModel a;
        int i2 = 1;
        if (!(i == 0 && feedbackReaction.f21478e == 1)) {
            if (i != 1 || feedbackReaction.f21478e == 1) {
                i2 = 0;
            } else {
                i2 = -1;
            }
        }
        int i3 = i2;
        if (i == 0 && feedbackReaction.f21478e != 0) {
            i2 = 1;
        } else if (i == 0 || feedbackReaction.f21478e != 0) {
            i2 = 0;
        } else {
            i2 = -1;
        }
        int i4 = i2;
        Builder builder = new Builder();
        builder.c = graphQLFeedback.mo2933j();
        builder = builder;
        builder.a = graphQLFeedback.z_();
        builder = builder;
        if (feedbackReaction != FeedbackReaction.f21476c) {
            ViewerFeedbackReactionModel.Builder builder2 = new ViewerFeedbackReactionModel.Builder();
            builder2.a = feedbackReaction.f21478e;
            a = builder2.a();
        } else {
            a = null;
        }
        builder.h = a;
        builder = builder;
        builder.i = feedbackReaction.f21478e;
        builder = builder;
        LikersModel.Builder builder3 = new LikersModel.Builder();
        GraphQLLikersOfContentConnection C = graphQLFeedback.m23209C();
        if (C != null) {
            i2 = C.mo2914a();
        } else {
            i2 = 0;
        }
        builder3.a = i3 + i2;
        builder.d = builder3.a();
        Builder builder4 = builder;
        ReactorsModel.Builder builder5 = new ReactorsModel.Builder();
        GraphQLReactorsOfContentConnection E = graphQLFeedback.m23211E();
        if (E != null) {
            i2 = E.m22671a();
        } else {
            i2 = 0;
        }
        builder5.a = i4 + i2;
        builder4.e = builder5.a();
        builder4 = builder4;
        builder4.f = ReactionsModelConversionHelper.a(FeedbackMutator.m10627a(graphQLFeedback, i, feedbackReaction.f21478e));
        ViewerReactionsMutationFragmentModel.Builder builder6 = new ViewerReactionsMutationFragmentModel.Builder();
        builder6.a = builder4.a();
        return builder6.a();
    }

    @Deprecated
    public final GraphQLStory m29039a(GraphQLStory graphQLStory, String str, FeedbackReaction feedbackReaction) {
        int intValue = FeedbackReaction.m29190a(graphQLStory.mo2890l()).intValue();
        if (str.equals(graphQLStory.m22350c())) {
            return m29036a(graphQLStory, intValue, feedbackReaction);
        }
        GraphQLStory a = StoryHierarchyHelper.m27433a(graphQLStory, str);
        if (a == null) {
            return graphQLStory;
        }
        int intValue2;
        if (a == graphQLStory.m22326L()) {
            intValue2 = FeedbackReaction.m29190a(a.mo2890l()).intValue();
            GraphQLStory.Builder a2 = GraphQLStory.Builder.a(graphQLStory);
            a2.l = m29036a(a, intValue2, feedbackReaction);
            return a2.a();
        } else if (!StoryHierarchyHelper.m27434a(graphQLStory).m22608j().contains(a)) {
            return graphQLStory;
        } else {
            ImmutableList.Builder builder = ImmutableList.builder();
            ImmutableList j = StoryHierarchyHelper.m27434a(graphQLStory).m22608j();
            int size = j.size();
            for (intValue2 = 0; intValue2 < size; intValue2++) {
                a = (GraphQLStory) j.get(intValue2);
                if (str.equals(a.m22350c())) {
                    builder.m1069c(m29036a(a, FeedbackReaction.m29190a(a.mo2890l()).intValue(), feedbackReaction));
                } else {
                    builder.m1069c(a);
                }
            }
            GraphQLStory.Builder a3 = GraphQLStory.Builder.a(graphQLStory);
            GraphQLSubstoriesConnection.Builder a4 = GraphQLSubstoriesConnection.Builder.a(StoryHierarchyHelper.m27434a(graphQLStory));
            a4.e = builder.m1068b();
            a3.g = a4.a();
            return a3.a();
        }
    }

    private GraphQLStory m29036a(GraphQLStory graphQLStory, int i, FeedbackReaction feedbackReaction) {
        FeedbackModel a = m29034a(graphQLStory.mo2890l(), i, feedbackReaction).a();
        GraphQLActor a2 = this.f21352e.m14534a();
        if (!(graphQLStory.mo2890l() == null || graphQLStory.mo2890l().m23221O() == null)) {
            GraphQLActor.Builder a3 = GraphQLActor.Builder.a(this.f21352e.m14534a());
            a3.B = graphQLStory.mo2890l().m23221O().ae();
            a3 = a3;
            a3.V = graphQLStory.mo2890l().m23221O().aG();
            a3 = a3;
            a3.ad = graphQLStory.mo2890l().m23221O().bs();
            a2 = a3.a();
        }
        GraphQLStory.Builder a4 = GraphQLStory.Builder.a(graphQLStory);
        a4.D = this.f21353f.m10638a(a2, graphQLStory.mo2890l(), a);
        return a4.a();
    }
}
