package com.facebook.leadgen;

import com.facebook.api.graphql.leadgen.LeadGenDeepLinkUserInfoCreateMutationModels.LeadGenDeepLinkUserInfoCoreMutationFieldsModel;
import com.facebook.api.graphql.leadgen.LeadGenDeepLinkUserInfoCreateMutationModels.LeadGenDeepLinkUserInfoCoreMutationFieldsModel.LeadGenDeepLinkUserStatusModel;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.model.ActionLinkHelper;
import com.facebook.graphql.model.GraphQLStoryActionLink;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.inject.InjectorLike;
import com.facebook.leadgen.LeadGenUserInputFormFragment.C05762;
import com.facebook.leadgen.data.LeadGenDataExtractor;
import com.facebook.leadgen.deeplink.LeadGenDeepLinkShareUserInfoClient;
import com.facebook.ui.futures.TasksManager;
import com.google.common.collect.ImmutableMap;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Callable;
import javax.inject.Inject;

/* compiled from: place_question_answer_label */
public class LeadGenFormSubmissionHelper {
    private final TasksManager f6277a;
    public final LeadGenDeepLinkShareUserInfoClient f6278b;
    public final LeadGenLogger f6279c;
    public C05762 f6280d;

    public static LeadGenFormSubmissionHelper m8123b(InjectorLike injectorLike) {
        return new LeadGenFormSubmissionHelper(TasksManager.b(injectorLike), new LeadGenDeepLinkShareUserInfoClient(GraphQLQueryExecutor.a(injectorLike), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike)), LeadGenLogger.m8134a(injectorLike));
    }

    @Inject
    public LeadGenFormSubmissionHelper(TasksManager tasksManager, LeadGenDeepLinkShareUserInfoClient leadGenDeepLinkShareUserInfoClient, LeadGenLogger leadGenLogger) {
        this.f6277a = tasksManager;
        this.f6278b = leadGenDeepLinkShareUserInfoClient;
        this.f6279c = leadGenLogger;
    }

    public final void m8124a(LeadGenDataExtractor leadGenDataExtractor, ImmutableMap<String, String> immutableMap, ImmutableMap<String, String> immutableMap2, final int i) {
        final String F = leadGenDataExtractor.m8195F();
        GraphQLStoryAttachment graphQLStoryAttachment = leadGenDataExtractor.f6368d;
        String str = null;
        if (graphQLStoryAttachment != null) {
            GraphQLStoryActionLink a = ActionLinkHelper.a(graphQLStoryAttachment, 1185006756);
            if (a != null) {
                str = a.N();
            }
        }
        final String str2 = str;
        if (str2 != null) {
            final ImmutableMap<String, String> immutableMap3 = immutableMap;
            final ImmutableMap<String, String> immutableMap4 = immutableMap2;
            this.f6277a.a(leadGenDataExtractor.m8201b(), new Callable<ListenableFuture<LeadGenDeepLinkUserInfoCoreMutationFieldsModel>>(this) {
                final /* synthetic */ LeadGenFormSubmissionHelper f6274e;

                public Object call() {
                    return this.f6274e.f6278b.m8215a(F, str2, immutableMap3, immutableMap4);
                }
            }, new AbstractDisposableFutureCallback<LeadGenDeepLinkUserInfoCoreMutationFieldsModel>(this) {
                final /* synthetic */ LeadGenFormSubmissionHelper f6276b;

                protected final void m8121a(Object obj) {
                    LeadGenDeepLinkUserInfoCoreMutationFieldsModel leadGenDeepLinkUserInfoCoreMutationFieldsModel = (LeadGenDeepLinkUserInfoCoreMutationFieldsModel) obj;
                    LeadGenFormSubmissionHelper leadGenFormSubmissionHelper = this.f6276b;
                    boolean z = false;
                    if (leadGenDeepLinkUserInfoCoreMutationFieldsModel != null) {
                        LeadGenDeepLinkUserStatusModel a = leadGenDeepLinkUserInfoCoreMutationFieldsModel.m609a();
                        if (a != null) {
                            z = a.m604b();
                        }
                    }
                    if (z) {
                        this.f6276b.f6279c.m8141a("cta_lead_gen_share_click", i);
                    }
                    if (this.f6276b.f6280d != null) {
                        this.f6276b.f6280d.m8178a(leadGenDeepLinkUserInfoCoreMutationFieldsModel, LeadGenUtil$SendInfoMutationStatus.SUCCESS);
                    }
                }

                protected final void m8122a(Throwable th) {
                    this.f6276b.f6279c.m8141a("cta_lead_gen_error_confirmation_card_click", i);
                    if (this.f6276b.f6280d != null) {
                        this.f6276b.f6280d.m8178a(null, LeadGenUtil$SendInfoMutationStatus.FAILURE);
                    }
                }
            });
        }
    }
}
