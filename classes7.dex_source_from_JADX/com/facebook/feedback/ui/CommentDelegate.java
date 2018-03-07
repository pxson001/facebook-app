package com.facebook.feedback.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.util.TypedValue;
import com.facebook.analytics.InteractionLogger;
import com.facebook.api.graphql.commentservice.CommentsServiceModels.CommentCreateShimMutationFragmentModel;
import com.facebook.api.graphql.commentservice.CommentsServiceShimmedMutation.AddCommentString;
import com.facebook.api.ufiservices.common.FeedbackLoggingParams;
import com.facebook.api.ufiservices.common.GraphQLActorCacheImpl;
import com.facebook.api.ufiservices.common.TogglePostLikeParams;
import com.facebook.auth.viewercontext.ViewerContext;
import com.facebook.common.android.FragmentActivityMethodAutoProvider;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForNonUiThreadMethodAutoProvider;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.common.fblinks.FBLinks;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.common.negativefeedback.NegativeFeedbackExperienceLocation;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.time.AwakeTimeSinceBootClockMethodAutoProvider;
import com.facebook.common.time.MonotonicClock;
import com.facebook.common.uri.FbUriIntentHandler;
import com.facebook.controller.mutation.CommentMutationHelper;
import com.facebook.controller.mutation.CommentMutationHelper.C02294;
import com.facebook.controller.mutation.MutationCallback;
import com.facebook.controller.mutation.util.FeedbackMutator;
import com.facebook.fbservice.ops.OperationResultFutureCallback;
import com.facebook.fbservice.service.ServiceException;
import com.facebook.feed.rows.core.events.EventsStream;
import com.facebook.feedback.reactions.api.ReactionsMutationController;
import com.facebook.friends.FriendingClient;
import com.facebook.funnellogger.FunnelRegistry;
import com.facebook.graphql.enums.GraphQLFeedOptimisticPublishState;
import com.facebook.graphql.enums.GraphQLNegativeFeedbackActionType;
import com.facebook.graphql.model.GraphQLActorCache;
import com.facebook.graphql.model.GraphQLComment;
import com.facebook.graphql.model.GraphQLComment.Builder;
import com.facebook.graphql.model.GraphQLFeedback;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.negativefeedback.abtest.ExperimentsForNegativeFeedbackAbTestModule;
import com.facebook.negativefeedback.ui.NegativeFeedbackDialogFragment;
import com.facebook.notifications.logging.NotificationsFunnelLoggingConstants.NotificationActionType;
import com.facebook.notifications.logging.NotificationsLogger;
import com.facebook.notifications.logging.NotificationsLogger.NotificationLogObject;
import com.facebook.offlinemode.comments.OfflineCommentsDbHelper;
import com.facebook.offlinemode.common.PendingRequest;
import com.facebook.offlinemode.db.PendingGraphQlMutationRequest;
import com.facebook.pages.common.bannedusers.analytics.PagesBanUserAnalytics;
import com.facebook.pages.common.bannedusers.analytics.PagesBanUserReferrer;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.sounds.FBSoundUtil;
import com.facebook.translation.data.CommentTranslationLoader;
import com.facebook.ufiservices.cache.PendingCommentCache;
import com.facebook.ufiservices.event.CommentEvents.DeleteCommentEvent;
import com.facebook.ufiservices.event.CommentEvents.UpdateCommentEvent;
import com.facebook.ui.futures.TasksManager;
import com.facebook.ui.toaster.ToastBuilder;
import com.facebook.ui.toaster.Toaster;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: see_friendship */
public class CommentDelegate {
    public final CommentTranslationLoader f4224a;
    public final EventsStream f4225b;
    private final FbUriIntentHandler f4226c;
    public final FeedbackController f4227d;
    public final FeedbackErrorUtil f4228e;
    public final InteractionLogger f4229f;
    public final MonotonicClock f4230g;
    public final Lazy<FBSoundUtil> f4231h;
    private final TasksManager f4232i;
    private final FragmentActivity f4233j;
    public final OfflineCommentsDbHelper f4234k;
    public final OfflineCommentCache f4235l;
    public final ListeningExecutorService f4236m;
    public final Executor f4237n;
    private final NotificationsLogger f4238o;
    private final QeAccessor f4239p;
    private final PendingCommentCache f4240q;
    private final CommentMutationHelper f4241r;
    public final FriendingClient f4242s;
    public final Lazy<PagesBanUserAnalytics> f4243t;
    public final Lazy<ViewerContext> f4244u;
    public final GraphQLActorCacheImpl f4245v;
    public final FeedbackMutator f4246w;
    public final ReactionsMutationController f4247x;
    public FeedbackLoggingParams f4248y;
    public NotificationLogObject f4249z;

    /* compiled from: see_friendship */
    public class C03732 extends AbstractDisposableFutureCallback {
        final /* synthetic */ GraphQLComment f4204a;
        final /* synthetic */ GraphQLFeedback f4205b;
        final /* synthetic */ CommentDelegate f4206c;

        public C03732(CommentDelegate commentDelegate, GraphQLComment graphQLComment, GraphQLFeedback graphQLFeedback) {
            this.f4206c = commentDelegate;
            this.f4204a = graphQLComment;
            this.f4205b = graphQLFeedback;
        }

        protected final void m4842a(Object obj) {
        }

        protected final void m4843a(Throwable th) {
            this.f4206c.f4225b.a(new UpdateCommentEvent(this.f4204a, this.f4205b.z_()));
            this.f4206c.f4228e.m5078a(th);
        }
    }

    public static CommentDelegate m4850b(InjectorLike injectorLike) {
        return new CommentDelegate(CommentTranslationLoader.a(injectorLike), EventsStream.a(injectorLike), FbUriIntentHandler.a(injectorLike), (FeedbackControllerProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(FeedbackControllerProvider.class), FeedbackErrorUtil.m5075a(injectorLike), InteractionLogger.a(injectorLike), (MonotonicClock) AwakeTimeSinceBootClockMethodAutoProvider.a(injectorLike), IdBasedSingletonScopeProvider.b(injectorLike, 10994), TasksManager.a(injectorLike), FragmentActivityMethodAutoProvider.a(injectorLike), OfflineCommentsDbHelper.a(injectorLike), OfflineCommentCache.m5175a(injectorLike), (ListeningExecutorService) ListeningScheduledExecutorService_ForNonUiThreadMethodAutoProvider.a(injectorLike), (Executor) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(injectorLike), NotificationsLogger.a(injectorLike), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike), PendingCommentCache.a(injectorLike), CommentMutationHelper.m2210a(injectorLike), FriendingClient.a(injectorLike), IdBasedSingletonScopeProvider.b(injectorLike, 8908), IdBasedLazy.a(injectorLike, 372), GraphQLActorCacheImpl.a(injectorLike), FeedbackMutator.a(injectorLike), ReactionsMutationController.a(injectorLike));
    }

    @Inject
    public CommentDelegate(CommentTranslationLoader commentTranslationLoader, EventsStream eventsStream, FbUriIntentHandler fbUriIntentHandler, FeedbackControllerProvider feedbackControllerProvider, FeedbackErrorUtil feedbackErrorUtil, InteractionLogger interactionLogger, MonotonicClock monotonicClock, Lazy<FBSoundUtil> lazy, TasksManager tasksManager, FragmentActivity fragmentActivity, OfflineCommentsDbHelper offlineCommentsDbHelper, OfflineCommentCache offlineCommentCache, ListeningExecutorService listeningExecutorService, Executor executor, NotificationsLogger notificationsLogger, QeAccessor qeAccessor, PendingCommentCache pendingCommentCache, CommentMutationHelper commentMutationHelper, FriendingClient friendingClient, Lazy<PagesBanUserAnalytics> lazy2, Lazy<ViewerContext> lazy3, GraphQLActorCache graphQLActorCache, FeedbackMutator feedbackMutator, ReactionsMutationController reactionsMutationController) {
        this.f4224a = commentTranslationLoader;
        this.f4226c = fbUriIntentHandler;
        this.f4225b = eventsStream;
        this.f4227d = feedbackControllerProvider.m5074a(FeedbackControllerParams.f4498a);
        this.f4228e = feedbackErrorUtil;
        this.f4229f = interactionLogger;
        this.f4230g = monotonicClock;
        this.f4231h = lazy;
        this.f4232i = tasksManager;
        this.f4233j = fragmentActivity;
        this.f4234k = offlineCommentsDbHelper;
        this.f4235l = offlineCommentCache;
        this.f4236m = listeningExecutorService;
        this.f4237n = executor;
        this.f4238o = notificationsLogger;
        this.f4239p = qeAccessor;
        this.f4240q = pendingCommentCache;
        this.f4241r = commentMutationHelper;
        this.f4242s = friendingClient;
        this.f4243t = lazy2;
        this.f4244u = lazy3;
        this.f4245v = graphQLActorCache;
        this.f4246w = feedbackMutator;
        this.f4247x = reactionsMutationController;
    }

    public final void m4852a(GraphQLComment graphQLComment, final GraphQLFeedback graphQLFeedback) {
        CommentMutationHelper commentMutationHelper = this.f4241r;
        FeedbackLoggingParams feedbackLoggingParams = this.f4248y;
        C03721 c03721 = new MutationCallback<GraphQLComment>(this) {
            final /* synthetic */ CommentDelegate f4203b;

            public final void m4838a(Object obj) {
                GraphQLComment graphQLComment = (GraphQLComment) obj;
                this.f4203b.f4225b.a(new UpdateCommentEvent(graphQLComment, graphQLFeedback.j()));
                if (graphQLComment.l().y_()) {
                    ((FBSoundUtil) this.f4203b.f4231h.get()).b("like_comment");
                }
            }

            public final void m4839a(Object obj, ServiceException serviceException) {
                this.f4203b.f4225b.a(new UpdateCommentEvent((GraphQLComment) obj, graphQLFeedback.j()));
                this.f4203b.f4228e.m5077a(serviceException);
            }

            public final /* bridge */ /* synthetic */ void m4840b(Object obj) {
            }

            public final /* bridge */ /* synthetic */ void m4841c(Object obj) {
            }
        };
        GraphQLFeedback a = commentMutationHelper.f2255h.a(graphQLComment.l(), commentMutationHelper.f2249b.a());
        Builder a2 = Builder.a(graphQLComment);
        a2.o = a;
        GraphQLComment a3 = a2.a();
        if (c03721 != null) {
            c03721.a(a3);
        }
        TogglePostLikeParams.Builder a4 = TogglePostLikeParams.a();
        a4.d = feedbackLoggingParams;
        a4 = a4;
        a4.e = a;
        a4 = a4;
        a4.b = a.y_();
        TogglePostLikeParams.Builder builder = a4;
        builder.c = commentMutationHelper.f2249b.a();
        commentMutationHelper.f2251d.a("toggle_comment_like_" + graphQLComment.y(), commentMutationHelper.f2256i.a(builder.a()), new C02294(commentMutationHelper, c03721, graphQLComment));
        commentMutationHelper.f2248a.a(graphQLComment.l(), feedbackLoggingParams);
        commentMutationHelper.f2259l.a.b(FunnelRegistry.Q, NotificationActionType.COMMENT_LIKE.name());
        if (this.f4249z != null) {
            this.f4238o.a(this.f4249z, "beeper_caused_comment_like");
            this.f4249z = null;
        }
    }

    public final void m4855b(GraphQLComment graphQLComment, GraphQLFeedback graphQLFeedback) {
        this.f4227d.m5066a(graphQLComment, graphQLFeedback, this.f4248y);
    }

    public final void m4853a(final GraphQLComment graphQLComment, final GraphQLFeedback graphQLFeedback, Context context) {
        if (this.f4240q.c(graphQLComment.H()) == GraphQLFeedOptimisticPublishState.OFFLINE) {
            Futures.a(this.f4236m.a(new Callable<Void>(this) {
                final /* synthetic */ CommentDelegate f4212b;

                public Object call() {
                    Object obj;
                    OfflineCommentsDbHelper offlineCommentsDbHelper = this.f4212b.f4234k;
                    GraphQLComment graphQLComment = graphQLComment;
                    offlineCommentsDbHelper.b.b();
                    ImmutableList a = offlineCommentsDbHelper.a.a();
                    int size = a.size();
                    for (int i = 0; i < size; i++) {
                        PendingRequest pendingRequest = (PendingRequest) a.get(i);
                        if (pendingRequest instanceof PendingGraphQlMutationRequest) {
                            PendingGraphQlMutationRequest pendingGraphQlMutationRequest = (PendingGraphQlMutationRequest) pendingRequest;
                            if (pendingGraphQlMutationRequest.h == AddCommentString.class) {
                                CommentCreateShimMutationFragmentModel commentCreateShimMutationFragmentModel = (CommentCreateShimMutationFragmentModel) pendingGraphQlMutationRequest.j;
                                if (!(commentCreateShimMutationFragmentModel == null || commentCreateShimMutationFragmentModel.a() == null || commentCreateShimMutationFragmentModel.a().H() == null || !commentCreateShimMutationFragmentModel.a().H().equals(graphQLComment.H()))) {
                                    offlineCommentsDbHelper.a.a(pendingGraphQlMutationRequest.b);
                                    obj = 1;
                                    break;
                                }
                            }
                            continue;
                        }
                    }
                    obj = null;
                    if (obj != null) {
                        return null;
                    }
                    throw new IllegalStateException("The comment could not be found");
                }
            }), new FutureCallback<Void>(this) {
                final /* synthetic */ CommentDelegate f4215c;

                public void onSuccess(@Nullable Object obj) {
                    this.f4215c.f4235l.m5181c(graphQLComment);
                    this.f4215c.f4225b.a(new DeleteCommentEvent(graphQLComment, graphQLFeedback.j()));
                }

                public void onFailure(Throwable th) {
                    FeedbackErrorUtil feedbackErrorUtil = this.f4215c.f4228e;
                    String str = "An error occurred while trying to delete an offline comment";
                    feedbackErrorUtil.f4505e.a(new ToastBuilder(2131230758));
                    if (str != null) {
                        feedbackErrorUtil.f4504d.a(FeedbackErrorUtil.f4501a, str);
                    }
                }
            }, this.f4237n);
        } else if (graphQLComment.l().j() == null) {
            this.f4225b.a(new DeleteCommentEvent(graphQLComment, graphQLFeedback.j()));
        } else {
            TypedValue typedValue = new TypedValue();
            context.getTheme().resolveAttribute(2130773285, typedValue, true);
            CharSequence string = context.getResources().getString(typedValue.resourceId);
            final ProgressDialog progressDialog = new ProgressDialog(context);
            progressDialog.setMessage(string);
            progressDialog.show();
            final long now = this.f4230g.now();
            this.f4229f.a(true);
            final GraphQLFeedback graphQLFeedback2 = graphQLFeedback;
            this.f4241r.m2212a(graphQLComment, graphQLFeedback.j(), new MutationCallback<GraphQLComment>(this) {
                final /* synthetic */ CommentDelegate f4210d;

                public final /* bridge */ /* synthetic */ void m4844a(Object obj) {
                }

                public final void m4846b(Object obj) {
                    GraphQLComment graphQLComment = (GraphQLComment) obj;
                    progressDialog.dismiss();
                    this.f4210d.f4225b.a(new DeleteCommentEvent(graphQLComment, graphQLFeedback2.j()));
                    this.f4210d.f4229f.a(this.f4210d.f4230g.now() - now);
                }

                public final /* bridge */ /* synthetic */ void m4847c(Object obj) {
                }

                public final void m4845a(Object obj, ServiceException serviceException) {
                    this.f4210d.f4228e.m5077a(serviceException);
                    progressDialog.dismiss();
                    this.f4210d.f4229f.a(this.f4210d.f4230g.now() - now);
                }
            });
        }
    }

    public final void m4854a(final String str, final GraphQLComment graphQLComment, Context context) {
        final ProgressDialog progressDialog = new ProgressDialog(context);
        progressDialog.setMessage(context.getString(2131233313));
        progressDialog.show();
        final long now = this.f4230g.now();
        this.f4229f.a(true);
        final Context context2 = context;
        final GraphQLComment graphQLComment2 = graphQLComment;
        this.f4232i.a("ban_user_and_delete_comment_" + graphQLComment.l().j(), new Callable<ListenableFuture>(this) {
            final /* synthetic */ CommentDelegate f4218c;

            public Object call() {
                return this.f4218c.f4242s.a(Long.parseLong(str), Long.parseLong(graphQLComment.r().H()));
            }
        }, new OperationResultFutureCallback(this) {
            final /* synthetic */ CommentDelegate f4223e;

            public final void m4848a(ServiceException serviceException) {
                this.f4223e.f4228e.m5077a(serviceException);
                progressDialog.dismiss();
                this.f4223e.f4229f.a(this.f4223e.f4230g.now() - now);
            }

            public final void m4849a(Object obj) {
                progressDialog.dismiss();
                this.f4223e.f4229f.a(this.f4223e.f4230g.now() - now);
                Toaster.a(context2, context2.getString(2131233279, new Object[]{graphQLComment2.r().aa()}));
                if (((ViewerContext) this.f4223e.f4244u.get()).mIsPageContext) {
                    ((PagesBanUserAnalytics) this.f4223e.f4243t.get()).m10909a(((ViewerContext) this.f4223e.f4244u.get()).mUserId, PagesBanUserReferrer.COMMENTS);
                }
            }
        });
    }

    public final void m4851a(GraphQLComment graphQLComment, Context context) {
        if (this.f4239p.a(ExperimentsForNegativeFeedbackAbTestModule.f7971a, false)) {
            NegativeFeedbackDialogFragment.m9746a(graphQLComment.y(), NegativeFeedbackExperienceLocation.PERMALINK.stringValueOf()).a(this.f4233j.kO_(), "dialog_from_comment");
            return;
        }
        this.f4226c.a(context, StringFormatUtil.formatStrLocaleSafe(FBLinks.cC, graphQLComment.y(), GraphQLNegativeFeedbackActionType.RESOLVE_PROBLEM, NegativeFeedbackExperienceLocation.PERMALINK.stringValueOf()));
    }
}
