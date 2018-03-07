package com.facebook.controller.mutation;

import com.facebook.api.ufiservices.common.AddCommentParams;
import com.facebook.api.ufiservices.common.AddCommentParams.Builder;
import com.facebook.api.ufiservices.common.DeleteCommentParams;
import com.facebook.api.ufiservices.common.FeedbackLoggingParams;
import com.facebook.api.ufiservices.common.GraphQLActorCacheImpl;
import com.facebook.auth.module.ViewerContextManagerProvider;
import com.facebook.auth.viewercontext.ViewerContext;
import com.facebook.auth.viewercontext.ViewerContext.ViewerContextBuilder;
import com.facebook.auth.viewercontext.ViewerContextManager;
import com.facebook.controller.mutation.util.FeedbackGraphQLGenerator;
import com.facebook.controller.mutation.util.FeedbackMutator;
import com.facebook.fbservice.ops.OperationResultFutureCallback;
import com.facebook.fbservice.ops.ResultFutureCallback;
import com.facebook.fbservice.service.ServiceException;
import com.facebook.feedback.logging.FeedbackAnalyticsLogger;
import com.facebook.feedback.logging.FeedbackAnalyticsLogger.CommentPostType;
import com.facebook.graphql.model.FeedTrackableUtil;
import com.facebook.graphql.model.GraphQLActor;
import com.facebook.graphql.model.GraphQLComment;
import com.facebook.graphql.model.GraphQLFeedback;
import com.facebook.graphql.model.GraphQLPage;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.graphql.model.GraphQLVideo;
import com.facebook.graphql.model.PropertyHelper;
import com.facebook.graphql.model.conversion.GraphQLMediaConversionHelper;
import com.facebook.graphql.model.conversion.GraphQLPageConversionHelper;
import com.facebook.inject.InjectorLike;
import com.facebook.notifications.logging.NotificationsFunnelLogger;
import com.facebook.photos.upload.serverprocessing.VideoStatusChecker.Listener;
import com.facebook.photos.upload.serverprocessing.VideoStatusCheckerProvider;
import com.facebook.ufiperf.perf.UfiPerfUtil;
import com.facebook.ufiservices.cache.PendingCommentInputEntry;
import com.facebook.ufiservices.data.FeedbackLoader;
import com.facebook.ufiservices.futures.UFIFuturesGenerator;
import com.facebook.ufiservices.util.OptimisticCommentFactory;
import com.facebook.ui.futures.TasksManager;
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;

/* compiled from: tap_photos_feed_footer_comment */
public class CommentMutationHelper {
    public final FeedbackAnalyticsLogger f2248a;
    public final GraphQLActorCacheImpl f2249b;
    private final OptimisticCommentFactory f2250c;
    public final TasksManager f2251d;
    private final UFIFuturesGenerator f2252e;
    private final UfiPerfUtil f2253f;
    private final ViewerContextManager f2254g;
    public final FeedbackMutator f2255h;
    public final FeedbackGraphQLGenerator f2256i;
    private final VideoStatusCheckerProvider f2257j;
    public final FeedbackLoader f2258k;
    public final NotificationsFunnelLogger f2259l;

    /* compiled from: tap_photos_feed_footer_comment */
    public class C02283 extends ResultFutureCallback<GraphQLComment> {
        final /* synthetic */ MutationCallback f2239a;
        final /* synthetic */ GraphQLComment f2240b;
        final /* synthetic */ CommentMutationHelper f2241c;

        public C02283(CommentMutationHelper commentMutationHelper, MutationCallback mutationCallback, GraphQLComment graphQLComment) {
            this.f2241c = commentMutationHelper;
            this.f2239a = mutationCallback;
            this.f2240b = graphQLComment;
        }

        public final void m2204a(Object obj) {
            GraphQLComment graphQLComment = (GraphQLComment) obj;
            if (graphQLComment == null) {
                if (this.f2239a != null) {
                    this.f2239a.c(this.f2240b);
                }
            } else if (this.f2239a != null) {
                this.f2239a.b(graphQLComment);
            }
        }

        public final void m2203a(ServiceException serviceException) {
            if (this.f2239a != null) {
                this.f2239a.a(this.f2240b, serviceException);
            }
        }
    }

    /* compiled from: tap_photos_feed_footer_comment */
    public class C02294 extends OperationResultFutureCallback {
        final /* synthetic */ MutationCallback f2242a;
        final /* synthetic */ GraphQLComment f2243b;
        final /* synthetic */ CommentMutationHelper f2244c;

        public C02294(CommentMutationHelper commentMutationHelper, MutationCallback mutationCallback, GraphQLComment graphQLComment) {
            this.f2244c = commentMutationHelper;
            this.f2242a = mutationCallback;
            this.f2243b = graphQLComment;
        }

        protected final void m2205a(ServiceException serviceException) {
            if (this.f2242a != null) {
                this.f2242a.a(this.f2243b, serviceException);
            }
        }
    }

    public static CommentMutationHelper m2210a(InjectorLike injectorLike) {
        return new CommentMutationHelper(FeedbackAnalyticsLogger.a(injectorLike), GraphQLActorCacheImpl.a(injectorLike), OptimisticCommentFactory.b(injectorLike), TasksManager.b(injectorLike), UFIFuturesGenerator.a(injectorLike), UfiPerfUtil.a(injectorLike), ViewerContextManagerProvider.b(injectorLike), FeedbackMutator.a(injectorLike), FeedbackGraphQLGenerator.a(injectorLike), (VideoStatusCheckerProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(VideoStatusCheckerProvider.class), FeedbackLoader.a(injectorLike), NotificationsFunnelLogger.a(injectorLike));
    }

    @Inject
    public CommentMutationHelper(FeedbackAnalyticsLogger feedbackAnalyticsLogger, GraphQLActorCacheImpl graphQLActorCacheImpl, OptimisticCommentFactory optimisticCommentFactory, TasksManager tasksManager, UFIFuturesGenerator uFIFuturesGenerator, UfiPerfUtil ufiPerfUtil, ViewerContextManager viewerContextManager, FeedbackMutator feedbackMutator, FeedbackGraphQLGenerator feedbackGraphQLGenerator, VideoStatusCheckerProvider videoStatusCheckerProvider, FeedbackLoader feedbackLoader, NotificationsFunnelLogger notificationsFunnelLogger) {
        this.f2248a = feedbackAnalyticsLogger;
        this.f2249b = graphQLActorCacheImpl;
        this.f2250c = optimisticCommentFactory;
        this.f2251d = tasksManager;
        this.f2252e = uFIFuturesGenerator;
        this.f2253f = ufiPerfUtil;
        this.f2254g = viewerContextManager;
        this.f2255h = feedbackMutator;
        this.f2256i = feedbackGraphQLGenerator;
        this.f2257j = videoStatusCheckerProvider;
        this.f2258k = feedbackLoader;
        this.f2259l = notificationsFunnelLogger;
    }

    private ViewerContext m2209a(String str, String str2) {
        ViewerContext d = this.f2254g.d();
        ViewerContextBuilder newBuilder = ViewerContext.newBuilder();
        newBuilder.d = true;
        newBuilder = newBuilder;
        newBuilder.c = d.mSessionCookiesString;
        newBuilder = newBuilder;
        newBuilder.f = d.mSessionKey;
        newBuilder = newBuilder;
        newBuilder.e = d.mSessionSecret;
        ViewerContextBuilder viewerContextBuilder = newBuilder;
        viewerContextBuilder.a = str;
        viewerContextBuilder = viewerContextBuilder;
        viewerContextBuilder.b = str2;
        return viewerContextBuilder.h();
    }

    public final void m2213a(String str, PendingCommentInputEntry pendingCommentInputEntry, GraphQLFeedback graphQLFeedback, FeedbackLoggingParams feedbackLoggingParams, boolean z, MutationCallback<GraphQLComment> mutationCallback) {
        GraphQLActor a;
        this.f2253f.H();
        this.f2248a.a(z ? CommentPostType.MANUAL_RETRY : CommentPostType.REQUEST, pendingCommentInputEntry.c, feedbackLoggingParams);
        if (graphQLFeedback.O() != null) {
            a = GraphQLPageConversionHelper.a(graphQLFeedback.O());
        } else {
            a = this.f2249b.a();
        }
        final GraphQLComment a2 = this.f2250c.a(str, a, pendingCommentInputEntry);
        this.f2253f.I();
        if (mutationCallback != null) {
            mutationCallback.a(a2);
        }
        Builder a3 = AddCommentParams.a();
        a3.a = pendingCommentInputEntry.a;
        a3 = a3;
        a3.b = pendingCommentInputEntry.b;
        a3 = a3;
        a3.c = pendingCommentInputEntry.c;
        a3 = a3;
        a3.d = a2;
        a3 = a3;
        a3.e = feedbackLoggingParams;
        a3 = a3;
        a3.f = str;
        a3 = a3;
        a3.i = Boolean.toString(pendingCommentInputEntry.d);
        a3 = a3;
        a3.h = Boolean.toString(pendingCommentInputEntry.d);
        a3 = a3;
        a3.k = pendingCommentInputEntry.h;
        a3 = a3;
        a3.l = pendingCommentInputEntry.i;
        a3 = a3;
        if (PropertyHelper.a(graphQLFeedback) != null) {
            GraphQLPage O = graphQLFeedback.O();
            if (O == null) {
                a3.j = null;
            } else {
                a3.j = m2209a(O.ae(), PropertyHelper.a(graphQLFeedback));
            }
        }
        final PendingCommentInputEntry pendingCommentInputEntry2 = pendingCommentInputEntry;
        final FeedbackLoggingParams feedbackLoggingParams2 = feedbackLoggingParams;
        final MutationCallback<GraphQLComment> mutationCallback2 = mutationCallback;
        this.f2251d.a("post_comment_" + str, this.f2252e.a(str, pendingCommentInputEntry, a3, true), new ResultFutureCallback<GraphQLComment>(this) {
            final /* synthetic */ CommentMutationHelper f2233e;

            public final void m2200a(Object obj) {
                GraphQLComment graphQLComment = (GraphQLComment) obj;
                if (graphQLComment == null) {
                    this.f2233e.f2248a.a(CommentPostType.OFFLINE, pendingCommentInputEntry2.c, feedbackLoggingParams2);
                    if (mutationCallback2 != null) {
                        mutationCallback2.c(a2);
                        return;
                    }
                    return;
                }
                Object obj2;
                this.f2233e.f2248a.a(CommentPostType.SUCCESS, pendingCommentInputEntry2.c, feedbackLoggingParams2);
                CommentMutationHelper commentMutationHelper = this.f2233e;
                ImmutableList.builder();
                ImmutableList q = graphQLComment.q();
                int size = q.size();
                for (int i = 0; i < size; i++) {
                    GraphQLStoryAttachment graphQLStoryAttachment = (GraphQLStoryAttachment) q.get(i);
                    if (graphQLStoryAttachment != null && graphQLStoryAttachment.r() != null && GraphQLMediaConversionHelper.b(graphQLStoryAttachment.r()) != null) {
                        obj2 = 1;
                        break;
                    }
                }
                obj2 = null;
                if (obj2 != null) {
                    CommentMutationHelper.m2211a(this.f2233e, graphQLComment, a2, pendingCommentInputEntry2.b, mutationCallback2);
                } else if (mutationCallback2 != null) {
                    mutationCallback2.b(graphQLComment);
                }
            }

            public final void m2199a(ServiceException serviceException) {
                this.f2233e.f2248a.a(CommentPostType.FAILURE, pendingCommentInputEntry2.c, feedbackLoggingParams2);
                if (mutationCallback2 != null) {
                    mutationCallback2.a(a2, serviceException);
                }
            }
        });
    }

    public static void m2211a(CommentMutationHelper commentMutationHelper, GraphQLComment graphQLComment, GraphQLComment graphQLComment2, String str, MutationCallback mutationCallback) {
        ImmutableList.Builder builder = ImmutableList.builder();
        ImmutableList q = graphQLComment.q();
        int size = q.size();
        for (int i = 0; i < size; i++) {
            GraphQLVideo b = GraphQLMediaConversionHelper.b(((GraphQLStoryAttachment) q.get(i)).r());
            if (b != null) {
                builder.c(b.J());
            }
        }
        final GraphQLComment graphQLComment3 = graphQLComment2;
        final GraphQLComment graphQLComment4 = graphQLComment;
        final String str2 = str;
        final MutationCallback mutationCallback2 = mutationCallback;
        commentMutationHelper.f2257j.a(builder.b(), new Listener(commentMutationHelper) {
            final /* synthetic */ CommentMutationHelper f2238e;

            public final void m2201a() {
                CommentMutationHelper commentMutationHelper = this.f2238e;
                GraphQLComment graphQLComment = graphQLComment3;
                String y = graphQLComment4.y();
                commentMutationHelper.f2251d.a("fetch_video_comment_" + y, commentMutationHelper.f2258k.a(str2, y, null, false, false), new C02283(commentMutationHelper, mutationCallback2, graphQLComment));
            }

            public final void m2202b() {
                if (mutationCallback2 != null) {
                    mutationCallback2.a(graphQLComment3, null);
                }
            }
        }).a();
    }

    public final void m2212a(final GraphQLComment graphQLComment, String str, final MutationCallback<GraphQLComment> mutationCallback) {
        DeleteCommentParams.Builder builder = new DeleteCommentParams.Builder();
        builder.a = graphQLComment.l().j();
        builder = builder;
        builder.b = str;
        builder = builder;
        builder.c = FeedTrackableUtil.a().toString();
        this.f2251d.a("delete_comment_" + graphQLComment.l().j(), this.f2256i.a(builder.a()), new OperationResultFutureCallback(this) {
            final /* synthetic */ CommentMutationHelper f2247c;

            protected final void m2207a(ServiceException serviceException) {
                if (mutationCallback != null) {
                    mutationCallback.a(graphQLComment, serviceException);
                }
            }

            protected final void m2208a(Object obj) {
                if (mutationCallback != null) {
                    mutationCallback.b(graphQLComment);
                }
            }
        });
    }
}
