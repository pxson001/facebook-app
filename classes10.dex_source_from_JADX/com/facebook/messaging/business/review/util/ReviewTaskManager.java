package com.facebook.messaging.business.review.util;

import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.fbservice.ops.DialogBasedProgressIndicator;
import com.facebook.graphql.calls.BotReviewUpdateInputData;
import com.facebook.graphql.calls.GraphQlCallInput;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.messaging.business.review.graphql.ReviewMutationFragments.MessengerPlatformBotReviewMutationString;
import com.facebook.messaging.business.review.graphql.ReviewMutationFragmentsModels.MessengerPlatformBotReviewMutationModel;
import com.facebook.messaging.business.review.graphql.ReviewQueryFragmentsModels.MessengerPlatformBotReviewQueryModel;
import com.facebook.messaging.business.review.graphql.ReviewQueryFragmentsModels.MessengerPlatformBotReviewQueryModel.ViewerMessengerPlatformBotReviewModel;
import com.facebook.messaging.business.review.view.ReviewUpdateFragment;
import com.facebook.messaging.business.review.view.ReviewUpdateFragment.C02712;
import com.facebook.messaging.business.review.view.ReviewUpdateFragment.C02723;
import com.facebook.ui.futures.TasksManager;
import javax.inject.Inject;

/* compiled from: thread.numBotParticipants */
public class ReviewTaskManager {
    public final AbstractFbErrorReporter f1671a;
    public final GraphQLQueryExecutor f1672b;
    public final TasksManager<ReviewUpdateTask> f1673c;

    /* compiled from: thread.numBotParticipants */
    public class C02681 extends AbstractDisposableFutureCallback<GraphQLResult<MessengerPlatformBotReviewQueryModel>> {
        final /* synthetic */ C02723 f1667a;
        final /* synthetic */ ReviewTaskManager f1668b;

        public C02681(ReviewTaskManager reviewTaskManager, C02723 c02723) {
            this.f1668b = reviewTaskManager;
            this.f1667a = c02723;
        }

        protected final void m1635a(Object obj) {
            GraphQLResult graphQLResult = (GraphQLResult) obj;
            C02723 c02723 = this.f1667a;
            MessengerPlatformBotReviewQueryModel messengerPlatformBotReviewQueryModel = (MessengerPlatformBotReviewQueryModel) graphQLResult.e;
            ReviewUpdateFragment.aq(c02723.f1676a);
            if (messengerPlatformBotReviewQueryModel != null) {
                c02723.f1676a.f1682f.setText(c02723.f1676a.a(2131241186, new Object[]{messengerPlatformBotReviewQueryModel.m1630j()}));
                if (messengerPlatformBotReviewQueryModel.m1631k() != null) {
                    ViewerMessengerPlatformBotReviewModel k = messengerPlatformBotReviewQueryModel.m1631k();
                    c02723.f1676a.f1680d.setRating(k.m1621j());
                    c02723.f1676a.f1681e.setText(k.m1622k());
                    c02723.f1676a.f1685i.setTitle(c02723.f1676a.b(2131241185));
                    ReviewUpdateFragment.m1645g(c02723.f1676a, k.m1621j());
                }
            }
        }

        protected final void m1636a(Throwable th) {
            C02723 c02723 = this.f1667a;
            ReviewUpdateFragment.aq(c02723.f1676a);
            if (c02723.f1676a.am != null) {
                c02723.f1676a.am.b();
            }
            this.f1668b.f1671a.a("ReviewTaskManager", "Messenger platform bot review graphql query fails");
        }
    }

    /* compiled from: thread.numBotParticipants */
    public enum ReviewUpdateTask {
        FETCH_REVIEW,
        POST_REVIEW
    }

    @Inject
    public ReviewTaskManager(AbstractFbErrorReporter abstractFbErrorReporter, GraphQLQueryExecutor graphQLQueryExecutor, TasksManager tasksManager) {
        this.f1671a = abstractFbErrorReporter;
        this.f1672b = graphQLQueryExecutor;
        this.f1673c = tasksManager;
    }

    public final void m1639a(String str, int i, String str2, final C02712 c02712) {
        BotReviewUpdateInputData botReviewUpdateInputData = new BotReviewUpdateInputData();
        botReviewUpdateInputData.a("page_id", str);
        GraphQlCallInput graphQlCallInput = botReviewUpdateInputData;
        graphQlCallInput.a("review_rating", Integer.valueOf(i));
        graphQlCallInput = graphQlCallInput;
        graphQlCallInput.a("review_text", str2);
        graphQlCallInput = graphQlCallInput;
        GraphQlQueryString messengerPlatformBotReviewMutationString = new MessengerPlatformBotReviewMutationString();
        messengerPlatformBotReviewMutationString.a("input", graphQlCallInput);
        ReviewUpdateFragment reviewUpdateFragment = c02712.f1675a;
        reviewUpdateFragment.f1684h = new DialogBasedProgressIndicator(reviewUpdateFragment.getContext(), c02712.f1675a.b(2131241187));
        reviewUpdateFragment.f1684h.a();
        this.f1673c.a(ReviewUpdateTask.POST_REVIEW, this.f1672b.a(GraphQLRequest.a(messengerPlatformBotReviewMutationString)), new AbstractDisposableFutureCallback<GraphQLResult<MessengerPlatformBotReviewMutationModel>>(this) {
            final /* synthetic */ ReviewTaskManager f1670b;

            protected final void m1637a(Object obj) {
                C02712 c02712 = c02712;
                ReviewUpdateFragment.ar(c02712.f1675a);
                c02712.f1675a.ao().finish();
            }

            protected final void m1638a(Throwable th) {
                C02712 c02712 = c02712;
                ReviewUpdateFragment.ar(c02712.f1675a);
                c02712.f1675a.f1678b.a();
                this.f1670b.f1671a.a("ReviewTaskManager", "Messenger platform bot review mutation fails.");
            }
        });
    }
}
