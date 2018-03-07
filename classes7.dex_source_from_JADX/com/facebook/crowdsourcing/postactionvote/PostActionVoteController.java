package com.facebook.crowdsourcing.postactionvote;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.crowdsourcing.enums.CrowdsourcingFieldType;
import com.facebook.crowdsourcing.logging.CrowdEndpoint;
import com.facebook.crowdsourcing.logging.CrowdEntryPoint;
import com.facebook.crowdsourcing.logging.CrowdsourcingContext;
import com.facebook.crowdsourcing.logging.SuggestEditsAnalyticsLogger;
import com.facebook.crowdsourcing.postactionvote.graphql.CrowdsourcingCurrentValueVoteMutation.CrowdsourcingCurrentValueVoteMutationString;
import com.facebook.crowdsourcing.postactionvote.view.PostActionVoteView;
import com.facebook.crowdsourcing.protocol.graphql.CrowdsourcingViewerClaimsQueries.CrowdsourcingClaimCountQueryString;
import com.facebook.crowdsourcing.protocol.graphql.CrowdsourcingViewerClaimsQueriesModels.CrowdsourcingClaimCountQueryModel;
import com.facebook.fbui.dialog.AlertDialog.Builder;
import com.facebook.graphql.calls.CrowdsourcingCurrentValueVoteInputData;
import com.facebook.graphql.calls.CrowdsourcingCurrentValueVoteInputData.Sentiment;
import com.facebook.graphql.calls.GraphQlCallInput;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.offlinemode.common.OfflineQueryBehavior;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.ui.futures.TasksManager;
import com.facebook.ui.toaster.ClickableToast;
import com.facebook.ui.toaster.ClickableToastBuilder;
import com.google.common.base.Function;
import com.google.common.base.Optional;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.MoreExecutors;
import java.util.HashSet;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: com.facebook.friendsharing.souvenirs.activity.SouvenirEditorActivity */
public class PostActionVoteController {
    private final Lazy<ClickableToastBuilder> f17576a;
    public final AbstractFbErrorReporter f17577b;
    private final GraphQLQueryExecutor f17578c;
    private final QeAccessor f17579d;
    private final SuggestEditsAnalyticsLogger f17580e;
    private final TasksManager f17581f;
    public final HashSet<Long> f17582g = new HashSet();
    private ClickableToast f17583h;

    /* compiled from: com.facebook.friendsharing.souvenirs.activity.SouvenirEditorActivity */
    class C14603 implements Function<GraphQLResult<CrowdsourcingClaimCountQueryModel>, Integer> {
        final /* synthetic */ PostActionVoteController f17573a;

        C14603(PostActionVoteController postActionVoteController) {
            this.f17573a = postActionVoteController;
        }

        @Nullable
        public Object apply(@Nullable Object obj) {
            GraphQLResult graphQLResult = (GraphQLResult) obj;
            if (graphQLResult == null || ((CrowdsourcingClaimCountQueryModel) graphQLResult.e).m2367a() == null || ((CrowdsourcingClaimCountQueryModel) graphQLResult.e).m2367a().m2362a() == null) {
                return Integer.valueOf(0);
            }
            return Integer.valueOf(((CrowdsourcingClaimCountQueryModel) graphQLResult.e).m2367a().m2362a().m2357a());
        }
    }

    /* compiled from: com.facebook.friendsharing.souvenirs.activity.SouvenirEditorActivity */
    class C14614 implements OnClickListener {
        final /* synthetic */ PostActionVoteController f17574a;

        C14614(PostActionVoteController postActionVoteController) {
            this.f17574a = postActionVoteController;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.dismiss();
        }
    }

    /* compiled from: com.facebook.friendsharing.souvenirs.activity.SouvenirEditorActivity */
    class C14625 extends AbstractDisposableFutureCallback {
        final /* synthetic */ PostActionVoteController f17575a;

        C14625(PostActionVoteController postActionVoteController) {
            this.f17575a = postActionVoteController;
        }

        protected final void m21440a(Object obj) {
        }

        protected final void m21441a(Throwable th) {
            this.f17575a.f17577b.a("crowdsourcing_post_action_vote", "Failed to submit PAV claim mutation");
        }
    }

    public static PostActionVoteController m21442a(InjectorLike injectorLike) {
        return new PostActionVoteController(IdBasedLazy.a(injectorLike, 3585), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike), GraphQLQueryExecutor.a(injectorLike), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike), SuggestEditsAnalyticsLogger.a(injectorLike), TasksManager.b(injectorLike));
    }

    private ListenableFuture<Integer> m21443a(long j, CrowdsourcingFieldType crowdsourcingFieldType) {
        GraphQlQueryString crowdsourcingClaimCountQueryString = new CrowdsourcingClaimCountQueryString();
        crowdsourcingClaimCountQueryString.a("page_id", Long.valueOf(j));
        crowdsourcingClaimCountQueryString.a("field_type", Long.valueOf(crowdsourcingFieldType.getValue()));
        return Futures.a(this.f17578c.a(GraphQLRequest.a(crowdsourcingClaimCountQueryString)), new C14603(this), MoreExecutors.a());
    }

    @Inject
    public PostActionVoteController(Lazy<ClickableToastBuilder> lazy, FbErrorReporter fbErrorReporter, GraphQLQueryExecutor graphQLQueryExecutor, QeAccessor qeAccessor, SuggestEditsAnalyticsLogger suggestEditsAnalyticsLogger, TasksManager tasksManager) {
        this.f17576a = lazy;
        this.f17577b = fbErrorReporter;
        this.f17578c = graphQLQueryExecutor;
        this.f17579d = qeAccessor;
        this.f17580e = suggestEditsAnalyticsLogger;
        this.f17581f = tasksManager;
    }

    public final void m21448b() {
        if (this.f17583h != null) {
            this.f17583h.b();
            this.f17583h = null;
        }
    }

    public final void m21446a(Context context, CrowdEntryPoint crowdEntryPoint, long j) {
        this.f17580e.a(CrowdEntryPoint.POST_CALL, Optional.of(String.valueOf(j)));
        if (!this.f17582g.contains(Long.valueOf(j))) {
            final Context context2 = context;
            final CrowdEntryPoint crowdEntryPoint2 = crowdEntryPoint;
            final long j2 = j;
            this.f17581f.a("get_viewer_claims_count" + CrowdsourcingFieldType.PAGE_PHONE, m21443a(j, CrowdsourcingFieldType.PAGE_PHONE), new AbstractDisposableFutureCallback<Integer>(this) {
                final /* synthetic */ PostActionVoteController f17568d;

                protected final void m21438a(Object obj) {
                    if (((Integer) obj).intValue() <= 0) {
                        this.f17568d.m21444a(context2, crowdEntryPoint2, j2, 60000);
                    }
                }

                protected final void m21439a(Throwable th) {
                    this.f17568d.f17577b.a("crowdsourcing_post_action_vote", "Could not fetch previous claims");
                }
            });
        }
    }

    private void m21444a(Context context, CrowdEntryPoint crowdEntryPoint, long j, int i) {
        this.f17580e.a(new CrowdsourcingContext(CrowdEntryPoint.POST_CALL, CrowdEndpoint.POST_ACTION_VOTE), String.valueOf(j));
        m21448b();
        final Context context2 = context;
        final CrowdEntryPoint crowdEntryPoint2 = crowdEntryPoint;
        final long j2 = j;
        PostActionVoteView postActionVoteView = new PostActionVoteView(context.getResources().getString(2131239178), context.getResources().getString(2131239179), new Object(this) {
            public final /* synthetic */ PostActionVoteController f17572d;
        }, context);
        this.f17583h = ((ClickableToastBuilder) this.f17576a.get()).a(postActionVoteView, i);
        this.f17583h.g = 2131626211;
        this.f17583h.a();
        postActionVoteView.m21456a((long) i);
    }

    public final void m21447a(Context context, CrowdEntryPoint crowdEntryPoint, long j, CrowdsourcingFieldType crowdsourcingFieldType, boolean z) {
        Enum enumR;
        new Builder(context).a(context.getResources().getString(2131230726), new C14614(this)).a(context.getResources().getString(2131239176)).b(context.getResources().getString(2131239177)).b();
        GraphQlQueryString crowdsourcingCurrentValueVoteMutationString = new CrowdsourcingCurrentValueVoteMutationString();
        CrowdsourcingCurrentValueVoteInputData crowdsourcingCurrentValueVoteInputData = new CrowdsourcingCurrentValueVoteInputData();
        crowdsourcingCurrentValueVoteInputData.a("field_type", String.valueOf(crowdsourcingFieldType.getValue()));
        crowdsourcingCurrentValueVoteInputData.a("page_id", String.valueOf(j));
        if (z) {
            enumR = Sentiment.AGREE;
        } else {
            enumR = Sentiment.DISAGREE;
        }
        crowdsourcingCurrentValueVoteInputData.a("sentiment", enumR);
        GraphQlCallInput graphQlCallInput = crowdsourcingCurrentValueVoteInputData;
        graphQlCallInput.a("endpoint", CrowdEndpoint.POST_ACTION_VOTE.getFullName());
        graphQlCallInput.a("entry_point", crowdEntryPoint.getFullName());
        crowdsourcingCurrentValueVoteMutationString.a("input", crowdsourcingCurrentValueVoteInputData);
        this.f17581f.a("submit_claim" + j + ":" + crowdsourcingFieldType, this.f17578c.a(GraphQLRequest.a(crowdsourcingCurrentValueVoteMutationString), OfflineQueryBehavior.b), new C14625(this));
    }
}
