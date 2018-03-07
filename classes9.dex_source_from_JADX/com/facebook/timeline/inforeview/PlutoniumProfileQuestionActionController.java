package com.facebook.timeline.inforeview;

import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.graphql.calls.GraphQlCallInput;
import com.facebook.graphql.calls.ProfileQuestionSaveInputData;
import com.facebook.graphql.calls.ProfileQuestionSaveInputData.Privacy;
import com.facebook.graphql.calls.ProfileQuestionSaveInputData.Privacy.BaseState;
import com.facebook.graphql.calls.ProfileQuestionSkipInputData;
import com.facebook.graphql.enums.GraphQLPrivacyBaseState;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.model.GraphQLPrivacyRowInput;
import com.facebook.graphql.querybuilder.common.GraphQlQueryDefaults;
import com.facebook.timeline.protocol.TimelineInfoReviewMutation.TimelineInfoReviewQuestionSaveMutationString;
import com.facebook.timeline.protocol.TimelineInfoReviewMutation.TimelineInfoReviewQuestionSkipMutationString;
import com.facebook.timeline.protocol.TimelineInfoReviewMutationModels.TimelineInfoReviewQuestionSaveMutationModel;
import com.facebook.timeline.protocol.TimelineInfoReviewMutationModels.TimelineInfoReviewQuestionSkipMutationModel;
import com.google.common.util.concurrent.FutureCallback;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: upload_conn_quality_confidence */
public class PlutoniumProfileQuestionActionController {
    private final GraphQLQueryExecutor f882a;
    private final DefaultAndroidThreadUtil f883b;
    public final AbstractFbErrorReporter f884c;
    public PlutoniumProfileQuestionHandler f885d;

    /* compiled from: upload_conn_quality_confidence */
    public /* synthetic */ class C00823 {
        public static final /* synthetic */ int[] f881a = new int[GraphQLPrivacyBaseState.values().length];

        static {
            try {
                f881a[GraphQLPrivacyBaseState.EVERYONE.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f881a[GraphQLPrivacyBaseState.FRIENDS.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f881a[GraphQLPrivacyBaseState.FRIENDS_OF_FRIENDS.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f881a[GraphQLPrivacyBaseState.SELF.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
        }
    }

    @Inject
    public PlutoniumProfileQuestionActionController(GraphQLQueryExecutor graphQLQueryExecutor, DefaultAndroidThreadUtil defaultAndroidThreadUtil, AbstractFbErrorReporter abstractFbErrorReporter) {
        this.f882a = graphQLQueryExecutor;
        this.f883b = defaultAndroidThreadUtil;
        this.f884c = abstractFbErrorReporter;
    }

    public final void m908a(@Nonnull String str, @Nonnull String str2, @Nonnull GraphQLPrivacyRowInput graphQLPrivacyRowInput, @Nullable String str3, @Nonnull String str4, @Nonnull String str5, @Nonnull String str6) {
        if (str4.equals("SAVE")) {
            m906a(str, str2, graphQLPrivacyRowInput, str3, str5, str6);
        } else {
            m907a(str, str2, str5, str6);
        }
    }

    private void m906a(@Nonnull String str, @Nonnull String str2, @Nonnull GraphQLPrivacyRowInput graphQLPrivacyRowInput, @Nullable String str3, @Nonnull String str4, @Nonnull String str5) {
        BaseState baseState;
        Privacy privacy = new Privacy();
        privacy.a("allow", graphQLPrivacyRowInput.a());
        GraphQlCallInput graphQlCallInput = privacy;
        graphQlCallInput.a("deny", graphQLPrivacyRowInput.k());
        graphQlCallInput = graphQlCallInput;
        switch (C00823.f881a[graphQLPrivacyRowInput.j().ordinal()]) {
            case 1:
                baseState = BaseState.EVERYONE;
                break;
            case 2:
                baseState = BaseState.FRIENDS;
                break;
            case 3:
                baseState = BaseState.FRIENDS_OF_FRIENDS;
                break;
            case 4:
                baseState = BaseState.SELF;
                break;
            default:
                baseState = null;
                break;
        }
        graphQlCallInput.a("base_state", baseState);
        graphQlCallInput = graphQlCallInput;
        ProfileQuestionSaveInputData profileQuestionSaveInputData = new ProfileQuestionSaveInputData();
        profileQuestionSaveInputData.a("session", str2);
        GraphQlCallInput graphQlCallInput2 = profileQuestionSaveInputData;
        graphQlCallInput2.a("privacy", graphQlCallInput);
        graphQlCallInput = graphQlCallInput2;
        graphQlCallInput.a("profile_question_id", str);
        graphQlCallInput = graphQlCallInput;
        graphQlCallInput.a("profile_question_option_id", str3);
        graphQlCallInput2 = graphQlCallInput;
        this.f883b.a(this.f882a.a(GraphQLRequest.a((TimelineInfoReviewQuestionSaveMutationString) new TimelineInfoReviewQuestionSaveMutationString().a("input", graphQlCallInput2).a("ref", str4).a("scale", GraphQlQueryDefaults.a()).a("session", str2).a("surface", str5))), new FutureCallback<GraphQLResult<TimelineInfoReviewQuestionSaveMutationModel>>(this) {
            final /* synthetic */ PlutoniumProfileQuestionActionController f878b;

            public void onSuccess(Object obj) {
                GraphQLResult graphQLResult = (GraphQLResult) obj;
                if (graphQLResult == null || graphQLResult.e == null || ((TimelineInfoReviewQuestionSaveMutationModel) graphQLResult.e).a() == null) {
                    this.f878b.f885d.m913b();
                } else {
                    this.f878b.f885d.m912a(((TimelineInfoReviewQuestionSaveMutationModel) graphQLResult.e).a().a());
                }
            }

            public void onFailure(Throwable th) {
                this.f878b.f884c.a("PlutoniumProfileQuestionActionController.save_question_failed", "Failure saving profile question. Input: " + graphQlCallInput2.toString(), th);
                this.f878b.f885d.m913b();
            }
        });
    }

    private void m907a(@Nonnull String str, @Nonnull String str2, @Nonnull String str3, @Nonnull String str4) {
        ProfileQuestionSkipInputData profileQuestionSkipInputData = new ProfileQuestionSkipInputData();
        profileQuestionSkipInputData.a("session", str2);
        GraphQlCallInput graphQlCallInput = profileQuestionSkipInputData;
        graphQlCallInput.a("profile_question_id", str);
        final GraphQlCallInput graphQlCallInput2 = graphQlCallInput;
        this.f883b.a(this.f882a.a(GraphQLRequest.a((TimelineInfoReviewQuestionSkipMutationString) new TimelineInfoReviewQuestionSkipMutationString().a("input", graphQlCallInput2).a("ref", str3).a("scale", GraphQlQueryDefaults.a()).a("session", str2).a("surface", str4))), new FutureCallback<GraphQLResult<TimelineInfoReviewQuestionSkipMutationModel>>(this) {
            final /* synthetic */ PlutoniumProfileQuestionActionController f880b;

            public void onSuccess(Object obj) {
                GraphQLResult graphQLResult = (GraphQLResult) obj;
                if (graphQLResult == null || graphQLResult.e == null || ((TimelineInfoReviewQuestionSkipMutationModel) graphQLResult.e).a() == null) {
                    this.f880b.f885d.m913b();
                } else {
                    this.f880b.f885d.m912a(((TimelineInfoReviewQuestionSkipMutationModel) graphQLResult.e).a().a());
                }
            }

            public void onFailure(Throwable th) {
                this.f880b.f884c.a("PlutoniumProfileQuestionActionController.skip_question_failed", "Failure skipping profile question. Input: " + graphQlCallInput2.toString(), th);
                this.f880b.f885d.m913b();
            }
        });
    }
}
