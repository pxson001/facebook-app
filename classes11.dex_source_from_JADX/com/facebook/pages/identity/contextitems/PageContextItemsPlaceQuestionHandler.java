package com.facebook.pages.identity.contextitems;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.view.View;
import android.widget.TextView;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.executors.ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.crowdsourcing.enums.CrowdsourcingFieldType;
import com.facebook.crowdsourcing.loader.FetchPlaceQuestionsGraphQLRequest;
import com.facebook.crowdsourcing.logging.CrowdEndpoint;
import com.facebook.crowdsourcing.logging.CrowdEntryPoint;
import com.facebook.crowdsourcing.logging.CrowdsourcingContext;
import com.facebook.crowdsourcing.logging.SuggestEditsAnalyticsLogger;
import com.facebook.crowdsourcing.protocol.graphql.CrowdsourcingPlaceQuestionMutations.CrowdsourcingPlaceQuestionAnswerSubmitString;
import com.facebook.crowdsourcing.protocol.graphql.CrowdsourcingPlaceQuestionMutationsModels.CrowdsourcingPlaceQuestionAnswerSubmitModel;
import com.facebook.crowdsourcing.protocol.graphql.CrowdsourcingPlaceQuestionQueriesInterfaces.FBCrowdsourcingPlaceQuestionsQuery;
import com.facebook.crowdsourcing.protocol.graphql.CrowdsourcingPlaceQuestionQueriesModels.FBCrowdsourcingPlaceQuestionFragmentModel;
import com.facebook.crowdsourcing.protocol.graphql.CrowdsourcingPlaceQuestionQueriesModels.FBCrowdsourcingPlaceQuestionFragmentModel.PlaceQuestionAnswersModel;
import com.facebook.crowdsourcing.protocol.graphql.CrowdsourcingPlaceQuestionQueriesModels.FBCrowdsourcingPlaceQuestionsQueryModel;
import com.facebook.crowdsourcing.protocol.graphql.CrowdsourcingPlaceQuestionQueriesModels.FBCrowdsourcingPlaceQuestionsQueryModel.CrowdsourcingPlaceQuestionsDataModel.PlaceQuestionsModel.EdgesModel;
import com.facebook.fbui.dialog.AlertDialog.Builder;
import com.facebook.graphql.calls.CrowdsourcingPlaceQuestionSubmitAnswerInputData;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.inject.InjectorLike;
import com.facebook.offlinemode.common.OfflineQueryBehavior;
import com.facebook.pages.common.scoped_eventbus.scopedevent.PageScopedEventBus;
import com.facebook.pages.common.scoped_eventbus.scopedevent.PageScopedEventsSubscribers.PlaceQuestionAnsweredEvent;
import com.facebook.pages.identity.contextitems.handler.PageContextItemHandlingData;
import com.facebook.ui.futures.TasksManager;
import com.facebook.widget.CustomLinearLayout;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: phone-pad */
public class PageContextItemsPlaceQuestionHandler {
    public static final String f3871a = PageContextItemsPlaceQuestionHandler.class.getSimpleName();
    public final AbstractFbErrorReporter f3872b;
    private final FetchPlaceQuestionsGraphQLRequest f3873c;
    private final GraphQLQueryExecutor f3874d;
    private final PageScopedEventBus f3875e;
    private final SuggestEditsAnalyticsLogger f3876f;
    private final TasksManager<String> f3877g;

    /* compiled from: phone-pad */
    class C05252 extends AbstractDisposableFutureCallback<GraphQLResult<CrowdsourcingPlaceQuestionAnswerSubmitModel>> {
        final /* synthetic */ PageContextItemsPlaceQuestionHandler f3866a;

        C05252(PageContextItemsPlaceQuestionHandler pageContextItemsPlaceQuestionHandler) {
            this.f3866a = pageContextItemsPlaceQuestionHandler;
        }

        protected final void m4788a(Throwable th) {
            this.f3866a.f3872b.a(PageContextItemsPlaceQuestionHandler.f3871a, "Failed to submit answer to Place Question");
        }
    }

    /* compiled from: phone-pad */
    class PlaceQuestionDialogView extends CustomLinearLayout {
        final /* synthetic */ PageContextItemsPlaceQuestionHandler f3867a;
        private final TextView f3868b = ((TextView) a(2131565521));
        private final TextView f3869c = ((TextView) a(2131565522));
        private final TextView f3870d = ((TextView) a(2131565523));

        public PlaceQuestionDialogView(PageContextItemsPlaceQuestionHandler pageContextItemsPlaceQuestionHandler, Context context) {
            this.f3867a = pageContextItemsPlaceQuestionHandler;
            super(context);
            setContentView(2130906031);
        }

        public final void m4789a(@Nullable String str) {
            this.f3868b.setVisibility(Strings.isNullOrEmpty(str) ? 8 : 0);
            this.f3868b.setText(str);
        }

        public final void m4790b(@Nullable String str) {
            this.f3869c.setVisibility(Strings.isNullOrEmpty(str) ? 8 : 0);
            this.f3869c.setText(str);
        }

        public final void m4791c(@Nullable String str) {
            this.f3870d.setVisibility(Strings.isNullOrEmpty(str) ? 8 : 0);
            this.f3870d.setText(str);
        }
    }

    public static PageContextItemsPlaceQuestionHandler m4794b(InjectorLike injectorLike) {
        return new PageContextItemsPlaceQuestionHandler((AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike), new FetchPlaceQuestionsGraphQLRequest(GraphQLQueryExecutor.a(injectorLike), ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider.a(injectorLike)), GraphQLQueryExecutor.a(injectorLike), PageScopedEventBus.a(injectorLike), SuggestEditsAnalyticsLogger.a(injectorLike), TasksManager.b(injectorLike));
    }

    @Inject
    public PageContextItemsPlaceQuestionHandler(AbstractFbErrorReporter abstractFbErrorReporter, FetchPlaceQuestionsGraphQLRequest fetchPlaceQuestionsGraphQLRequest, GraphQLQueryExecutor graphQLQueryExecutor, PageScopedEventBus pageScopedEventBus, SuggestEditsAnalyticsLogger suggestEditsAnalyticsLogger, TasksManager tasksManager) {
        this.f3872b = abstractFbErrorReporter;
        this.f3873c = fetchPlaceQuestionsGraphQLRequest;
        this.f3874d = graphQLQueryExecutor;
        this.f3875e = pageScopedEventBus;
        this.f3876f = suggestEditsAnalyticsLogger;
        this.f3877g = tasksManager;
    }

    public final void m4795a(final View view, final PageContextItemHandlingData pageContextItemHandlingData, CrowdsourcingFieldType crowdsourcingFieldType) {
        this.f3876f.a(new CrowdsourcingContext(CrowdEntryPoint.ENTITY_CARD_EDIT_ACTION_BUTTON, CrowdEndpoint.PLACE_CONTEXT_ROW_PLACE_QUESTION), String.valueOf(pageContextItemHandlingData.a));
        this.f3877g.a("key_fetch_place_questions" + pageContextItemHandlingData.a, this.f3873c.a(String.valueOf(pageContextItemHandlingData.a), crowdsourcingFieldType.getValue(), "PAGE_CONTEXT_ROW", 1), new AbstractDisposableFutureCallback<FBCrowdsourcingPlaceQuestionsQuery>(this) {
            final /* synthetic */ PageContextItemsPlaceQuestionHandler f3865c;

            protected final void m4785a(Object obj) {
                FBCrowdsourcingPlaceQuestionFragmentModel fBCrowdsourcingPlaceQuestionFragmentModel;
                FBCrowdsourcingPlaceQuestionsQueryModel fBCrowdsourcingPlaceQuestionsQueryModel = (FBCrowdsourcingPlaceQuestionsQueryModel) obj;
                String str = null;
                PageContextItemsPlaceQuestionHandler pageContextItemsPlaceQuestionHandler = this.f3865c;
                if (fBCrowdsourcingPlaceQuestionsQueryModel.b() == null || fBCrowdsourcingPlaceQuestionsQueryModel.b().a() == null || fBCrowdsourcingPlaceQuestionsQueryModel.b().a().a().size() == 0) {
                    fBCrowdsourcingPlaceQuestionFragmentModel = null;
                } else {
                    fBCrowdsourcingPlaceQuestionFragmentModel = ((EdgesModel) fBCrowdsourcingPlaceQuestionsQueryModel.b().a().a().get(0)).a();
                    if (fBCrowdsourcingPlaceQuestionFragmentModel == null || fBCrowdsourcingPlaceQuestionFragmentModel.g() == null || fBCrowdsourcingPlaceQuestionFragmentModel.d().size() == 0) {
                        fBCrowdsourcingPlaceQuestionFragmentModel = null;
                    }
                }
                final FBCrowdsourcingPlaceQuestionFragmentModel fBCrowdsourcingPlaceQuestionFragmentModel2 = fBCrowdsourcingPlaceQuestionFragmentModel;
                if (fBCrowdsourcingPlaceQuestionFragmentModel2 == null || fBCrowdsourcingPlaceQuestionFragmentModel2.g() == null || fBCrowdsourcingPlaceQuestionFragmentModel2.d().size() == 0) {
                    this.f3865c.f3872b.a(PageContextItemsPlaceQuestionHandler.f3871a, "Place Question Context Row fetched invalid data");
                    PageContextItemsPlaceQuestionHandler.m4792a(this.f3865c, pageContextItemHandlingData.a);
                    return;
                }
                String a;
                final ImmutableList d = fBCrowdsourcingPlaceQuestionFragmentModel2.d();
                PlaceQuestionDialogView placeQuestionDialogView = new PlaceQuestionDialogView(this.f3865c, view.getContext());
                placeQuestionDialogView.m4789a(fBCrowdsourcingPlaceQuestionFragmentModel2.g() != null ? fBCrowdsourcingPlaceQuestionFragmentModel2.g().a() : null);
                if (fBCrowdsourcingPlaceQuestionFragmentModel2.b() != null) {
                    a = fBCrowdsourcingPlaceQuestionFragmentModel2.b().a();
                } else {
                    a = null;
                }
                placeQuestionDialogView.m4790b(a);
                if (fBCrowdsourcingPlaceQuestionFragmentModel2.eo_() != null) {
                    str = fBCrowdsourcingPlaceQuestionFragmentModel2.eo_().a();
                }
                placeQuestionDialogView.m4791c(str);
                Builder builder = new Builder(view.getContext(), 2131625529);
                builder.a(false).b(placeQuestionDialogView).a(true);
                if (d.size() > 0 && ((PlaceQuestionAnswersModel) d.get(0)).a() != null) {
                    builder.c(((PlaceQuestionAnswersModel) d.get(0)).a().a(), new OnClickListener(this) {
                        final /* synthetic */ C05241 f3856c;

                        public void onClick(DialogInterface dialogInterface, int i) {
                            PageContextItemsPlaceQuestionHandler.m4793a(this.f3856c.f3865c, pageContextItemHandlingData.a, fBCrowdsourcingPlaceQuestionFragmentModel2.c(), ((PlaceQuestionAnswersModel) d.get(0)).b());
                        }
                    });
                }
                if (d.size() > 1 && ((PlaceQuestionAnswersModel) d.get(1)).a() != null) {
                    builder.b(((PlaceQuestionAnswersModel) d.get(1)).a().a(), new OnClickListener(this) {
                        final /* synthetic */ C05241 f3859c;

                        public void onClick(DialogInterface dialogInterface, int i) {
                            PageContextItemsPlaceQuestionHandler.m4793a(this.f3859c.f3865c, pageContextItemHandlingData.a, fBCrowdsourcingPlaceQuestionFragmentModel2.c(), ((PlaceQuestionAnswersModel) d.get(1)).b());
                        }
                    });
                    if (d.size() > 2 && ((PlaceQuestionAnswersModel) d.get(2)).a() != null) {
                        builder.a(((PlaceQuestionAnswersModel) d.get(2)).a().a(), new OnClickListener(this) {
                            final /* synthetic */ C05241 f3862c;

                            public void onClick(DialogInterface dialogInterface, int i) {
                                PageContextItemsPlaceQuestionHandler.m4793a(this.f3862c.f3865c, pageContextItemHandlingData.a, fBCrowdsourcingPlaceQuestionFragmentModel2.c(), ((PlaceQuestionAnswersModel) d.get(2)).b());
                            }
                        });
                    }
                }
                builder.a().show();
            }

            protected final void m4786a(Throwable th) {
                this.f3865c.f3872b.a(PageContextItemsPlaceQuestionHandler.f3871a, "Failed to fetch place questions");
            }
        });
    }

    public static void m4793a(PageContextItemsPlaceQuestionHandler pageContextItemsPlaceQuestionHandler, long j, String str, String str2) {
        m4792a(pageContextItemsPlaceQuestionHandler, j);
        GraphQlQueryString crowdsourcingPlaceQuestionAnswerSubmitString = new CrowdsourcingPlaceQuestionAnswerSubmitString();
        CrowdsourcingPlaceQuestionSubmitAnswerInputData crowdsourcingPlaceQuestionSubmitAnswerInputData = new CrowdsourcingPlaceQuestionSubmitAnswerInputData();
        crowdsourcingPlaceQuestionSubmitAnswerInputData.a("place_question_id", str);
        crowdsourcingPlaceQuestionSubmitAnswerInputData.a("place_question_answer_value", str2);
        crowdsourcingPlaceQuestionAnswerSubmitString.a("input", crowdsourcingPlaceQuestionSubmitAnswerInputData);
        pageContextItemsPlaceQuestionHandler.f3877g.a("key_submit_answer" + str, pageContextItemsPlaceQuestionHandler.f3874d.a(GraphQLRequest.a(crowdsourcingPlaceQuestionAnswerSubmitString), OfflineQueryBehavior.b), new C05252(pageContextItemsPlaceQuestionHandler));
    }

    public static void m4792a(PageContextItemsPlaceQuestionHandler pageContextItemsPlaceQuestionHandler, long j) {
        pageContextItemsPlaceQuestionHandler.f3875e.a(new PlaceQuestionAnsweredEvent(Long.valueOf(j)));
    }
}
