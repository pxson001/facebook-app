package com.facebook.events.feed.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;
import com.facebook.auth.viewercontext.ViewerContext;
import com.facebook.auth.viewercontext.ViewerContextManager;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.events.data.EventAdminStatusRecord;
import com.facebook.events.feed.protocol.EventPinnedPostAndRecentStoryGraphQLModels.EventPinnedPostAndRecentStoryFragmentModel;
import com.facebook.events.feed.protocol.EventsPinnedPostMutations.EventChangeStoryPinStatusMutationString;
import com.facebook.events.feed.protocol.EventsPinnedPostMutationsModels.EventChangeStoryPinStatusMutationModel;
import com.facebook.events.permalink.EventPermalinkFragment;
import com.facebook.feed.environment.CanPinAndUnpinPosts;
import com.facebook.graphql.calls.EventChangeStoryPinStatusInputData;
import com.facebook.graphql.calls.EventChangeStoryPinStatusInputData.Context.EventActionHistory;
import com.facebook.graphql.calls.EventChangeStoryPinStatusInputData.PinnedStatus;
import com.facebook.graphql.calls.GraphQlCallInput;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.model.GraphQLFeedUnitEdge;
import com.facebook.graphql.model.GraphQLFeedUnitEdge.Builder;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.facebook.inject.Assisted;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.ui.dialogs.FbAlertDialogBuilder;
import com.facebook.ui.toaster.ClickableToast;
import com.facebook.ui.toaster.ClickableToastBuilder;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import java.util.List;
import javax.inject.Inject;

/* compiled from: com.facebook.TokenCachingStrategy.IsSSO */
public class EventFeedStoryPinMutator implements CanPinAndUnpinPosts {
    private final ViewerContextManager f17437a;
    private final EventStoriesQueryParamHelper f17438b;
    private final GraphQLQueryExecutor f17439c;
    private final DefaultAndroidThreadUtil f17440d;
    public final AbstractFbErrorReporter f17441e;
    public final ClickableToastBuilder f17442f;
    private final EventAdminStatusRecord f17443g;
    public final EventPermalinkFragment f17444h;
    public final EventPermalinkStoriesExtractor f17445i;

    @Inject
    public EventFeedStoryPinMutator(@Assisted EventPermalinkFragment eventPermalinkFragment, ViewerContextManager viewerContextManager, EventStoriesQueryParamHelper eventStoriesQueryParamHelper, GraphQLQueryExecutor graphQLQueryExecutor, DefaultAndroidThreadUtil defaultAndroidThreadUtil, AbstractFbErrorReporter abstractFbErrorReporter, ClickableToastBuilder clickableToastBuilder, EventAdminStatusRecord eventAdminStatusRecord, EventPermalinkStoriesExtractor eventPermalinkStoriesExtractor) {
        this.f17437a = viewerContextManager;
        this.f17438b = eventStoriesQueryParamHelper;
        this.f17439c = graphQLQueryExecutor;
        this.f17440d = defaultAndroidThreadUtil;
        this.f17441e = abstractFbErrorReporter;
        this.f17442f = clickableToastBuilder;
        this.f17443g = eventAdminStatusRecord;
        this.f17444h = eventPermalinkFragment;
        this.f17445i = eventPermalinkStoriesExtractor;
    }

    public static void m17790a(EventFeedStoryPinMutator eventFeedStoryPinMutator, final GraphQLStory graphQLStory, final PinnedStatus pinnedStatus, final Context context) {
        ViewerContext d = eventFeedStoryPinMutator.f17437a.d();
        EventChangeStoryPinStatusInputData eventChangeStoryPinStatusInputData = new EventChangeStoryPinStatusInputData();
        eventChangeStoryPinStatusInputData.a("event_id", graphQLStory.aJ().b());
        GraphQlCallInput graphQlCallInput = eventChangeStoryPinStatusInputData;
        graphQlCallInput.a("story_id", graphQLStory.c());
        graphQlCallInput = graphQlCallInput;
        graphQlCallInput.a("pinned_status", pinnedStatus);
        graphQlCallInput = graphQlCallInput;
        EventChangeStoryPinStatusInputData.Context context2 = new EventChangeStoryPinStatusInputData.Context();
        EventActionHistory eventActionHistory = new EventActionHistory();
        eventActionHistory.a("surface", "event_permalink");
        context2.a("event_action_history", ImmutableList.of(eventActionHistory));
        graphQlCallInput.a("context", context2);
        graphQlCallInput = graphQlCallInput;
        if (d.mIsPageContext) {
            graphQlCallInput.a("actor_id", d.mUserId);
        }
        TypedGraphQlQueryString eventChangeStoryPinStatusMutationString = new EventChangeStoryPinStatusMutationString();
        eventChangeStoryPinStatusMutationString.a("input", graphQlCallInput);
        eventFeedStoryPinMutator.f17438b.m17801a(eventChangeStoryPinStatusMutationString);
        eventFeedStoryPinMutator.f17440d.a(eventFeedStoryPinMutator.f17439c.a(GraphQLRequest.a(eventChangeStoryPinStatusMutationString)), new AbstractDisposableFutureCallback<GraphQLResult<EventChangeStoryPinStatusMutationModel>>(eventFeedStoryPinMutator) {
            final /* synthetic */ EventFeedStoryPinMutator f17433d;

            protected final void m17788a(Object obj) {
                GraphQLResult graphQLResult = (GraphQLResult) obj;
                if (this.f17433d.f17444h != null) {
                    EventChangeStoryPinStatusMutationModel eventChangeStoryPinStatusMutationModel = (EventChangeStoryPinStatusMutationModel) graphQLResult.e;
                    if (eventChangeStoryPinStatusMutationModel != null && eventChangeStoryPinStatusMutationModel.m17764a() != null) {
                        EventPinnedPostAndRecentStoryFragmentModel a = eventChangeStoryPinStatusMutationModel.m17764a();
                        EventPermalinkFragment eventPermalinkFragment = this.f17433d.f17444h;
                        String g = graphQLStory.g();
                        String j = eventChangeStoryPinStatusMutationModel.m17766j();
                        List<GraphQLFeedUnitEdge> a2 = eventPermalinkFragment.aV.a(g);
                        if (!a2.isEmpty()) {
                            for (GraphQLFeedUnitEdge graphQLFeedUnitEdge : a2) {
                                Builder a3 = Builder.a(graphQLFeedUnitEdge);
                                a3.k = j;
                                GraphQLFeedUnitEdge a4 = a3.a();
                                eventPermalinkFragment.aV.c(graphQLFeedUnitEdge);
                                eventPermalinkFragment.aV.b(a4);
                            }
                        }
                        this.f17433d.f17444h.m18237a(this.f17433d.f17445i.m17797a(a), this.f17433d.f17445i.m17798b(a));
                    }
                }
            }

            protected final void m17789a(Throwable th) {
                int i;
                Toast.makeText(context, "Failure :(", 1).show();
                this.f17433d.f17441e.a(EventFeedStoryPinMutator.class.getSimpleName(), "Failed to change story pin status", th);
                EventsFeedRetrySnackBar eventsFeedRetrySnackBar = new EventsFeedRetrySnackBar(context);
                if (pinnedStatus == PinnedStatus.PINNED) {
                    i = 2131241907;
                } else {
                    i = 2131241908;
                }
                eventsFeedRetrySnackBar.f17456b.setText(i);
                final ClickableToast a = this.f17433d.f17442f.a(eventsFeedRetrySnackBar, 4000);
                eventsFeedRetrySnackBar.f17455a.setOnClickListener(new OnClickListener(this) {
                    final /* synthetic */ C24611 f17429b;

                    public void onClick(View view) {
                        int a = Logger.a(2, EntryType.UI_INPUT_START, -953036606);
                        EventFeedStoryPinMutator.m17790a(this.f17429b.f17433d, graphQLStory, pinnedStatus, context);
                        a.b();
                        Logger.a(2, EntryType.UI_INPUT_END, -944535649, a);
                    }
                });
                a.a();
            }
        });
    }

    public final void m17791a(final GraphQLStory graphQLStory, final Context context) {
        Preconditions.checkArgument(graphQLStory.aJ().j().g() == 67338874);
        if (this.f17443g.e(graphQLStory.aJ().b())) {
            new FbAlertDialogBuilder(context).a(2131241909).b(2131241910).a(2131230729, new DialogInterface.OnClickListener(this) {
                final /* synthetic */ EventFeedStoryPinMutator f17436c;

                public void onClick(DialogInterface dialogInterface, int i) {
                    EventFeedStoryPinMutator.m17790a(this.f17436c, graphQLStory, PinnedStatus.PINNED, context);
                }
            }).b(2131230727, null).c(true).b();
        } else {
            m17790a(this, graphQLStory, PinnedStatus.PINNED, context);
        }
    }

    public final void m17792b(GraphQLStory graphQLStory, Context context) {
        Preconditions.checkArgument(graphQLStory.aJ().j().g() == 67338874);
        m17790a(this, graphQLStory, PinnedStatus.NONE, context);
    }
}
