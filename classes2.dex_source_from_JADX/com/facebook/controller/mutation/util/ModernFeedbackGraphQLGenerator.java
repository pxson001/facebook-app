package com.facebook.controller.mutation.util;

import android.text.TextUtils;
import com.facebook.api.graphql.likes.LikeMutations;
import com.facebook.api.graphql.likes.LikeMutations.FBFeedbackLikeCoreMutationString;
import com.facebook.api.graphql.likes.LikeMutations.FBFeedbackUnlikeCoreMutationString;
import com.facebook.api.graphql.likes.LikeMutations.PageLikeString;
import com.facebook.api.graphql.likes.LikeMutations.PageUnlikeString;
import com.facebook.api.graphql.likes.LikeMutationsModels.FBFeedbackLikeMutationFragmentModel;
import com.facebook.api.graphql.likes.LikeMutationsModels.FBFeedbackLikeMutationFragmentModel.LikersModel;
import com.facebook.api.graphql.likes.LikeMutationsModels.PageLikeModel;
import com.facebook.api.graphql.likes.LikeMutationsModels.PageToggleLikeFragmentModel;
import com.facebook.api.graphql.likes.LikeMutationsModels.PageToggleLikeFragmentModel.Builder;
import com.facebook.api.ufiservices.common.ToggleLikeParams;
import com.facebook.api.ufiservices.common.TogglePageLikeParams;
import com.facebook.api.ufiservices.common.TogglePostLikeParams;
import com.facebook.auth.module.ViewerContextManagerProvider;
import com.facebook.auth.viewercontext.ViewerContextManager;
import com.facebook.debug.log.BLog;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.calls.FeedbackLikeInputData;
import com.facebook.graphql.calls.FeedbackUnlikeInputData;
import com.facebook.graphql.calls.GraphQlCallInput;
import com.facebook.graphql.calls.GraphQlMutationCallInput;
import com.facebook.graphql.calls.PageLikeInputData;
import com.facebook.graphql.calls.PageLikeInputData.Source;
import com.facebook.graphql.calls.PageUnlikeInputData;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.request.MutationRequest;
import com.facebook.graphql.model.GraphQLFeedback;
import com.facebook.graphql.query.TypedGraphQLMutationString;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.facebook.inject.InjectorLike;
import com.facebook.proxygen.HTTPTransportCallback;
import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.RegularImmutableSet;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.MoreExecutors;
import java.nio.ByteBuffer;
import java.util.List;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: gmp_app_id */
public class ModernFeedbackGraphQLGenerator implements FeedbackGraphQLGeneratorInterface {
    private static final ToLegacyResult f22215a = new ToLegacyResult();
    private final GraphQLQueryExecutor f22216b;
    private final ViewerContextManager f22217c;

    /* compiled from: gmp_app_id */
    class ToLegacyResult implements Function<Object, OperationResult> {
        static final OperationResult f22218a = OperationResult.m30116a("true");

        public Object apply(@Nullable Object obj) {
            return f22218a;
        }
    }

    public static ModernFeedbackGraphQLGenerator m30105b(InjectorLike injectorLike) {
        return new ModernFeedbackGraphQLGenerator(GraphQLQueryExecutor.m10435a(injectorLike), ViewerContextManagerProvider.m2496b(injectorLike));
    }

    @Inject
    public ModernFeedbackGraphQLGenerator(GraphQLQueryExecutor graphQLQueryExecutor, ViewerContextManager viewerContextManager) {
        this.f22216b = graphQLQueryExecutor;
        this.f22217c = viewerContextManager;
    }

    public final ListenableFuture<OperationResult> mo1940a(TogglePostLikeParams togglePostLikeParams) {
        String str;
        List e;
        GraphQlMutationCallInput graphQlMutationCallInput;
        TypedGraphQLMutationString typedGraphQLMutationString;
        boolean z = true;
        String str2 = null;
        m30106b(togglePostLikeParams);
        ToggleLikeParams b = togglePostLikeParams.b();
        Preconditions.checkNotNull(b.c, "null actor");
        Preconditions.checkState(b.e.y_() == b.b, "Feedback object passed in should reflect the optimistic mutation");
        String H = b.c.m23765H();
        if (TextUtils.isEmpty(H)) {
            z = false;
        }
        Preconditions.checkState(z, "Null/empty actor ID");
        if (b.d != null) {
            str = b.d.f22391c;
            str2 = b.d.f22390b;
            e = b.d.m30313e();
        } else {
            e = null;
            str = null;
        }
        GraphQlCallInput graphQlCallInput;
        GraphQlCallInput graphQlCallInput2;
        if (b.b) {
            FBFeedbackLikeCoreMutationString a = LikeMutations.a();
            FeedbackLikeInputData a2 = new FeedbackLikeInputData().b(b.e.z_()).a(H);
            a2.m11397a("nectar_module", str2);
            graphQlCallInput = a2;
            graphQlCallInput.m11397a("feedback_source", str);
            graphQlCallInput2 = graphQlCallInput;
            graphQlCallInput2.m11398a("tracking", e);
            graphQlMutationCallInput = graphQlCallInput2;
            typedGraphQLMutationString = a;
        } else {
            FBFeedbackUnlikeCoreMutationString b2 = LikeMutations.b();
            FeedbackUnlikeInputData a3 = new FeedbackUnlikeInputData().b(b.e.z_()).a(H);
            a3.m11397a("nectar_module", str2);
            graphQlCallInput = a3;
            graphQlCallInput.m11397a("feedback_source", str);
            graphQlCallInput2 = graphQlCallInput;
            graphQlCallInput2.m11398a("tracking", e);
            graphQlMutationCallInput = graphQlCallInput2;
            typedGraphQLMutationString = b2;
        }
        return m30104a(typedGraphQLMutationString, graphQlMutationCallInput, m30103a(b), ImmutableSet.of(H), false);
    }

    public final ListenableFuture<OperationResult> m30107a(TogglePageLikeParams togglePageLikeParams) {
        TypedGraphQLMutationString pageLikeString;
        GraphQlMutationCallInput graphQlMutationCallInput;
        Preconditions.checkNotNull(togglePageLikeParams, "params");
        Preconditions.checkNotNull(togglePageLikeParams.a, "likeableId");
        Preconditions.checkNotNull(togglePageLikeParams.c, "likerProfile");
        GraphQlCallInput graphQlCallInput;
        if (togglePageLikeParams.b) {
            pageLikeString = new PageLikeString();
            PageLikeInputData pageLikeInputData = new PageLikeInputData();
            pageLikeInputData.m11397a("page_id", togglePageLikeParams.a);
            graphQlCallInput = pageLikeInputData;
            graphQlCallInput.m11397a("actor_id", togglePageLikeParams.c.m23765H());
            graphQlMutationCallInput = graphQlCallInput;
            String str = togglePageLikeParams.e;
            Enum enumR = null;
            if (str != null) {
                for (Source source : Source.values()) {
                    if (str.equals(source.toString())) {
                        enumR = source;
                        break;
                    }
                }
                BLog.b(ModernFeedbackGraphQLGenerator.class, "unknown enum value: %s ", new Object[]{str});
            }
            Enum enumR2 = enumR;
            if (enumR2 != null) {
                graphQlMutationCallInput.m11395a("source", enumR2);
            }
        } else {
            pageLikeString = new PageUnlikeString();
            PageUnlikeInputData pageUnlikeInputData = new PageUnlikeInputData();
            pageUnlikeInputData.m11397a("page_id", togglePageLikeParams.a);
            graphQlCallInput = pageUnlikeInputData;
            graphQlCallInput.m11397a("actor_id", togglePageLikeParams.c.m23765H());
            graphQlMutationCallInput = graphQlCallInput;
        }
        Builder builder = new Builder();
        builder.a = togglePageLikeParams.b;
        builder = builder;
        builder.b = togglePageLikeParams.a;
        PageToggleLikeFragmentModel a = builder.a();
        PageLikeModel.Builder builder2 = new PageLikeModel.Builder();
        builder2.a = a;
        return m30104a(pageLikeString, graphQlMutationCallInput, builder2.a(), RegularImmutableSet.f688a, true);
    }

    private ListenableFuture<OperationResult> m30104a(TypedGraphQLMutationString typedGraphQLMutationString, GraphQlMutationCallInput graphQlMutationCallInput, GraphQLVisitableModel graphQLVisitableModel, ImmutableSet<String> immutableSet, boolean z) {
        typedGraphQLMutationString.m11310a("input", (GraphQlCallInput) graphQlMutationCallInput);
        MutationRequest mutationRequest = new MutationRequest(typedGraphQLMutationString, immutableSet);
        mutationRequest.a(graphQLVisitableModel);
        if (z) {
            mutationRequest.e = this.f22217c.mo212a();
        }
        return Futures.m2450a(this.f22216b.m10457b(mutationRequest), f22215a, MoreExecutors.m1813a());
    }

    static void m30106b(TogglePostLikeParams togglePostLikeParams) {
        Preconditions.checkState(togglePostLikeParams.a == null);
        GraphQLFeedback graphQLFeedback = togglePostLikeParams.e;
        if (graphQLFeedback == null) {
            throw new NullPointerException("feedback == null");
        } else if (graphQLFeedback.z_() == null || graphQLFeedback.mo2933j() == null) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("feedback.id:");
            stringBuilder.append(graphQLFeedback.z_());
            stringBuilder.append(", feedback.legacyApiPostId:");
            stringBuilder.append(graphQLFeedback.mo2933j());
            throw new NullPointerException(stringBuilder.toString());
        }
    }

    public static GraphQLVisitableModel m30103a(ToggleLikeParams toggleLikeParams) {
        LikersModel likersModel = null;
        if (!(toggleLikeParams.e == null || toggleLikeParams.e.m23209C() == null)) {
            LikersModel.Builder builder = new LikersModel.Builder();
            builder.a = toggleLikeParams.e.m23209C().mo2914a();
            builder = builder;
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(HTTPTransportCallback.BODY_BYTES_RECEIVED);
            flatBufferBuilder.m21510c(1);
            flatBufferBuilder.m21494a(0, builder.a, 0);
            flatBufferBuilder.m21513d(flatBufferBuilder.m21511d());
            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.m21515e());
            wrap.position(0);
            likersModel = new LikersModel(new MutableFlatBuffer(wrap, null, null, true, null));
        }
        FBFeedbackLikeMutationFragmentModel.Builder builder2 = new FBFeedbackLikeMutationFragmentModel.Builder();
        builder2.c = toggleLikeParams.a;
        builder2 = builder2;
        builder2.a = toggleLikeParams.b;
        builder2 = builder2;
        builder2.e = likersModel;
        return builder2.a();
    }
}
