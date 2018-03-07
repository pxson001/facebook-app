package com.facebook.feedback.ui;

import com.facebook.api.prefetch.GraphQLPrefetchConsumer;
import com.facebook.api.prefetch.GraphQLPrefetchConsumerProvider;
import com.facebook.api.prefetch.GraphQLPrefetchResult;
import com.facebook.api.ufiservices.FeedbackPrefetchPolicyProvider;
import com.facebook.api.ufiservices.common.CommentOrderType;
import com.facebook.api.ufiservices.common.FeedbackLoggingParams;
import com.facebook.auth.viewercontext.ViewerContext;
import com.facebook.auth.viewercontext.ViewerContext.ViewerContextBuilder;
import com.facebook.auth.viewercontext.ViewerContextManager;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.common.futures.DelayedAbstractDisposableFutureCallback;
import com.facebook.common.futures.DisposableFutureCallback;
import com.facebook.common.identifiers.SafeUUIDGenerator;
import com.facebook.common.util.StringUtil;
import com.facebook.controller.mutation.CommentMutationHelper;
import com.facebook.controller.mutation.FeedbackMutationHelper;
import com.facebook.controller.mutation.MutationCallback;
import com.facebook.fbservice.service.DataFreshnessParam;
import com.facebook.fbservice.service.ServiceException;
import com.facebook.feed.rows.core.events.EventsStream;
import com.facebook.feed.util.event.FeedEventBus;
import com.facebook.feedback.abtest.ExperimentsForFeedbackTestModule;
import com.facebook.feedback.events.FeedbackEvents.UpdateLikeFeedbackEvent;
import com.facebook.feedback.prefetcher.FeedbackPrefetcher;
import com.facebook.feedback.prefetcher.FeedbackPrefetchingExperiments;
import com.facebook.funnellogger.FunnelLogger;
import com.facebook.funnellogger.FunnelLoggerImpl;
import com.facebook.funnellogger.FunnelRegistry;
import com.facebook.graphql.enums.GraphQLFeedOptimisticPublishState;
import com.facebook.graphql.model.GraphQLComment;
import com.facebook.graphql.model.GraphQLComment.Builder;
import com.facebook.graphql.model.GraphQLFeedback;
import com.facebook.graphql.model.GraphQLPage;
import com.facebook.graphql.model.PropertyHelper;
import com.facebook.http.interfaces.RequestPriority;
import com.facebook.inject.Assisted;
import com.facebook.inject.Lazy;
import com.facebook.qe.api.QeAccessor;
import com.facebook.sounds.FBSoundUtil;
import com.facebook.tools.dextr.runtime.detour.FutureDetour;
import com.facebook.ufiservices.cache.PendingCommentCache;
import com.facebook.ufiservices.cache.PendingCommentInputEntry;
import com.facebook.ufiservices.data.FeedbackLoader;
import com.facebook.ufiservices.event.CommentEvents.AddCommentEvent;
import com.facebook.ufiservices.event.CommentEvents.UpdateCommentEvent;
import com.facebook.ufiservices.event.UfiEvents.LikeUpdatedUIEvent;
import com.facebook.ufiservices.flyout.FeedbackParams;
import com.facebook.ui.futures.TasksManager;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Strings;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.SettableFuture;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import javax.inject.Inject;

/* compiled from: sawb */
public class FeedbackController {
    public final EventsStream f4477a;
    public final FeedEventBus f4478b;
    public final Executor f4479c;
    public final FeedbackErrorUtil f4480d;
    public final FeedbackLoader f4481e;
    private final QeAccessor f4482f;
    private final FunnelLoggerImpl f4483g;
    public final Lazy<FBSoundUtil> f4484h;
    public final PendingCommentCache f4485i;
    public final TasksManager f4486j;
    public final GraphQLPrefetchConsumer<GraphQLFeedback> f4487k;
    public final OfflineCommentCache f4488l;
    public ViewerContextManager f4489m;
    private final CommentMutationHelper f4490n;
    public final FeedbackMutationHelper f4491o;
    public final boolean f4492p;
    public final boolean f4493q;
    public final FeedbackPrefetcher f4494r;
    public final FeedbackPrefetchingExperiments f4495s;

    @Inject
    public FeedbackController(EventsStream eventsStream, FeedEventBus feedEventBus, Executor executor, FeedbackErrorUtil feedbackErrorUtil, FeedbackLoader feedbackLoader, FeedbackPrefetchPolicyProvider feedbackPrefetchPolicyProvider, GraphQLPrefetchConsumerProvider graphQLPrefetchConsumerProvider, Lazy<FBSoundUtil> lazy, PendingCommentCache pendingCommentCache, TasksManager tasksManager, OfflineCommentCache offlineCommentCache, ViewerContextManager viewerContextManager, CommentMutationHelper commentMutationHelper, FeedbackMutationHelper feedbackMutationHelper, QeAccessor qeAccessor, FunnelLogger funnelLogger, FeedbackPrefetcher feedbackPrefetcher, @Assisted FeedbackControllerParams feedbackControllerParams, FeedbackPrefetchingExperiments feedbackPrefetchingExperiments) {
        this.f4477a = eventsStream;
        this.f4478b = feedEventBus;
        this.f4484h = lazy;
        this.f4480d = feedbackErrorUtil;
        this.f4481e = feedbackLoader;
        this.f4482f = qeAccessor;
        this.f4483g = funnelLogger;
        this.f4493q = feedbackControllerParams.m5072a();
        this.f4485i = pendingCommentCache;
        this.f4487k = graphQLPrefetchConsumerProvider.a(feedbackPrefetchPolicyProvider.a(Boolean.valueOf(this.f4493q), Boolean.valueOf(false)));
        this.f4479c = executor;
        this.f4486j = tasksManager;
        this.f4489m = viewerContextManager;
        this.f4488l = offlineCommentCache;
        this.f4490n = commentMutationHelper;
        this.f4491o = feedbackMutationHelper;
        this.f4492p = feedbackControllerParams.m5073b();
        this.f4494r = feedbackPrefetcher;
        this.f4495s = feedbackPrefetchingExperiments;
    }

    public final void m5069a(final FeedbackParams feedbackParams, final OnFeedbackLoadListener onFeedbackLoadListener, CallerContext callerContext) {
        if (feedbackParams.g() != null) {
            m5064b(feedbackParams, onFeedbackLoadListener, callerContext);
        } else if (Strings.isNullOrEmpty(feedbackParams.d())) {
            onFeedbackLoadListener.mo197a(ServiceException.a(new NullPointerException("Feedback id and legacy api post id are null")), feedbackParams);
        } else {
            this.f4486j.a("fetch_feedback_" + feedbackParams.d(), this.f4481e.a(feedbackParams.d(), CommentOrderType.DEFAULT_ORDER, RequestPriority.INTERACTIVE, CallerContext.a(getClass(), feedbackParams.h())), new AbstractDisposableFutureCallback<GraphQLFeedback>(this) {
                final /* synthetic */ FeedbackController f4470c;

                protected final void m5049a(Object obj) {
                    GraphQLFeedback graphQLFeedback = (GraphQLFeedback) obj;
                    if (graphQLFeedback == null) {
                        m5050a(new NullPointerException("Fetched feedback was non-existent"));
                    } else {
                        onFeedbackLoadListener.mo199b(graphQLFeedback);
                    }
                }

                protected final void m5050a(Throwable th) {
                    onFeedbackLoadListener.mo197a(ServiceException.a(th), feedbackParams);
                }
            });
        }
    }

    @VisibleForTesting
    private ListenableFuture<GraphQLFeedback> m5061a(FeedbackParams feedbackParams) {
        if (feedbackParams.a == null || PropertyHelper.a(feedbackParams.a) == null) {
            return null;
        }
        final String a = PropertyHelper.a(feedbackParams.a);
        GraphQLPage O = feedbackParams.a.O();
        if (O == null) {
            return null;
        }
        String ae = O.ae();
        ViewerContext d = this.f4489m.d();
        ViewerContextBuilder newBuilder = ViewerContext.newBuilder();
        newBuilder.d = true;
        newBuilder = newBuilder;
        newBuilder.c = d.mSessionCookiesString;
        newBuilder = newBuilder;
        newBuilder.f = d.mSessionKey;
        newBuilder = newBuilder;
        newBuilder.e = d.mSessionSecret;
        ViewerContextBuilder viewerContextBuilder = newBuilder;
        viewerContextBuilder.a = ae;
        viewerContextBuilder = viewerContextBuilder;
        viewerContextBuilder.b = a;
        ViewerContext h = viewerContextBuilder.h();
        final SettableFuture f = SettableFuture.f();
        m5062a(feedbackParams.g(), h, CallerContext.a, feedbackParams.q, new DelayedAbstractDisposableFutureCallback<GraphQLFeedback>(this) {
            final /* synthetic */ FeedbackController f4453c;

            protected final void m5041a(Object obj) {
                GraphQLFeedback graphQLFeedback = (GraphQLFeedback) obj;
                if (graphQLFeedback != null) {
                    PropertyHelper.a(graphQLFeedback, a);
                }
                FutureDetour.a(f, graphQLFeedback, 1197607497);
            }

            protected final void m5042a(Throwable th) {
                f.a(th);
            }
        });
        return f;
    }

    private void m5064b(final FeedbackParams feedbackParams, final OnFeedbackLoadListener onFeedbackLoadListener, CallerContext callerContext) {
        C04132 c04132 = new DelayedAbstractDisposableFutureCallback<GraphQLPrefetchResult<GraphQLFeedback>>(this) {
            final /* synthetic */ FeedbackController f4455b;

            protected final void m5043a(Object obj) {
                GraphQLFeedback graphQLFeedback = (GraphQLFeedback) ((GraphQLPrefetchResult) obj).a;
                if (graphQLFeedback != null) {
                    onFeedbackLoadListener.mo200c(graphQLFeedback);
                }
            }

            protected final void m5044a(Throwable th) {
            }
        };
        c04132.b();
        ListenableFuture a = m5061a(feedbackParams);
        if (a != null) {
            Futures.a(a, m5059a(this, feedbackParams, onFeedbackLoadListener), this.f4479c);
        } else if (feedbackParams.m != null || feedbackParams.p) {
            m5063b(feedbackParams, c04132, onFeedbackLoadListener, callerContext);
        } else {
            C04143 c04143 = new DelayedAbstractDisposableFutureCallback<GraphQLPrefetchResult<GraphQLFeedback>>(this) {
                DisposableFutureCallback<GraphQLFeedback> f4456a = FeedbackController.m5059a(this.f4459d, feedbackParams, onFeedbackLoadListener);
                final /* synthetic */ FeedbackController f4459d;

                protected final void m5045a(Object obj) {
                    this.f4456a.onSuccess(((GraphQLPrefetchResult) obj).a);
                }

                protected final void m5046a(Throwable th) {
                    this.f4456a.onFailure(th);
                }
            };
            c04143.b();
            GraphQLPrefetchConsumer graphQLPrefetchConsumer = this.f4487k;
            if (this.f4495s.b()) {
                graphQLPrefetchConsumer = this.f4494r.a(this.f4493q, false);
            }
            graphQLPrefetchConsumer.a(feedbackParams.g(), c04132, c04143, callerContext, this.f4479c);
        }
    }

    private void m5062a(String str, ViewerContext viewerContext, CallerContext callerContext, boolean z, DelayedAbstractDisposableFutureCallback<GraphQLFeedback> delayedAbstractDisposableFutureCallback) {
        ListenableFuture a = this.f4481e.a(str, DataFreshnessParam.CHECK_SERVER_FOR_NEW_DATA, CommentOrderType.DEFAULT_ORDER, false, null, z, callerContext, viewerContext);
        delayedAbstractDisposableFutureCallback.b();
        if (a != null) {
            this.f4486j.a("fetch_feedback_with_viewer_context", a, delayedAbstractDisposableFutureCallback);
        }
    }

    private void m5063b(FeedbackParams feedbackParams, DelayedAbstractDisposableFutureCallback<GraphQLPrefetchResult<GraphQLFeedback>> delayedAbstractDisposableFutureCallback, OnFeedbackLoadListener onFeedbackLoadListener, CallerContext callerContext) {
        GraphQLPrefetchConsumer graphQLPrefetchConsumer = this.f4487k;
        if (this.f4495s.b()) {
            graphQLPrefetchConsumer = this.f4494r.a(this.f4493q, false);
        }
        graphQLPrefetchConsumer.a(feedbackParams.g(), delayedAbstractDisposableFutureCallback, callerContext, this.f4479c);
        this.f4486j.a("fetch_focused_feedback", this.f4481e.a(feedbackParams.g(), DataFreshnessParam.CHECK_SERVER_FOR_NEW_DATA, feedbackParams.o, feedbackParams.p, feedbackParams.m, feedbackParams.q, callerContext), m5059a(this, feedbackParams, onFeedbackLoadListener));
    }

    public static DisposableFutureCallback m5059a(FeedbackController feedbackController, final FeedbackParams feedbackParams, final OnFeedbackLoadListener onFeedbackLoadListener) {
        return new AbstractDisposableFutureCallback<GraphQLFeedback>(feedbackController) {
            final /* synthetic */ FeedbackController f4462c;

            protected final void m5047a(Object obj) {
                GraphQLFeedback graphQLFeedback = (GraphQLFeedback) obj;
                if (graphQLFeedback == null) {
                    m5048a(new NullPointerException("Fetched feedback was non-existent"));
                } else {
                    onFeedbackLoadListener.mo199b(graphQLFeedback);
                }
            }

            protected final void m5048a(Throwable th) {
                onFeedbackLoadListener.mo197a(ServiceException.a(th), feedbackParams);
            }
        };
    }

    public final void m5070a(String str, String str2, String str3, boolean z, AbstractDisposableFutureCallback<GraphQLComment> abstractDisposableFutureCallback) {
        final String str4 = str;
        final String str5 = str2;
        final String str6 = str3;
        final boolean z2 = z;
        this.f4486j.a("fetch_comment_" + str2, new Callable<ListenableFuture>(this) {
            final /* synthetic */ FeedbackController f4467e;

            public Object call() {
                return this.f4467e.f4481e.a(str4, str5, str6, true, z2);
            }
        }, abstractDisposableFutureCallback);
    }

    public final void m5066a(GraphQLComment graphQLComment, GraphQLFeedback graphQLFeedback, FeedbackLoggingParams feedbackLoggingParams) {
        String H = graphQLComment.H();
        PendingCommentInputEntry pendingCommentInputEntry = (PendingCommentInputEntry) this.f4485i.a.get(H);
        if (pendingCommentInputEntry != null) {
            this.f4490n.m2213a(H, pendingCommentInputEntry, graphQLFeedback, feedbackLoggingParams, true, m5060a(H, pendingCommentInputEntry, graphQLFeedback));
        }
    }

    public final void m5068a(PendingCommentInputEntry pendingCommentInputEntry, GraphQLFeedback graphQLFeedback, FeedbackLoggingParams feedbackLoggingParams) {
        String uuid = SafeUUIDGenerator.a().toString();
        ((FBSoundUtil) this.f4484h.get()).b("post_comment");
        this.f4490n.m2213a(uuid, pendingCommentInputEntry, graphQLFeedback, feedbackLoggingParams, false, m5060a(uuid, pendingCommentInputEntry, graphQLFeedback));
        if (this.f4482f.a(ExperimentsForFeedbackTestModule.Y, false) || this.f4482f.a(ExperimentsForFeedbackTestModule.X, false)) {
            this.f4483g.b(FunnelRegistry.t, "Posting_Comments");
        }
    }

    private MutationCallback<GraphQLComment> m5060a(final String str, final PendingCommentInputEntry pendingCommentInputEntry, final GraphQLFeedback graphQLFeedback) {
        return new MutationCallback<GraphQLComment>(this) {
            final /* synthetic */ FeedbackController f4474d;

            public final void m5051a(Object obj) {
                GraphQLComment graphQLComment = (GraphQLComment) obj;
                this.f4474d.f4485i.a(str, GraphQLFeedOptimisticPublishState.POSTING);
                this.f4474d.f4477a.a(new AddCommentEvent(graphQLComment, graphQLFeedback.j()));
                PendingCommentCache pendingCommentCache = this.f4474d.f4485i;
                pendingCommentCache.a.put(str, pendingCommentInputEntry);
            }

            public final void m5052a(Object obj, ServiceException serviceException) {
                GraphQLComment graphQLComment = (GraphQLComment) obj;
                this.f4474d.f4485i.a(str, GraphQLFeedOptimisticPublishState.FAILED);
                this.f4474d.f4477a.a(new UpdateCommentEvent(graphQLComment, graphQLFeedback.j()));
                if (serviceException != null) {
                    this.f4474d.f4480d.m5077a(serviceException);
                }
            }

            public final void m5053b(Object obj) {
                obj = (GraphQLComment) obj;
                if (!StringUtil.a(str)) {
                    Builder a = Builder.a(obj);
                    a.z = str;
                    obj = a.a();
                }
                this.f4474d.f4477a.a(new UpdateCommentEvent(obj, graphQLFeedback.j()));
                this.f4474d.f4485i.b(str);
            }

            public final void m5054c(Object obj) {
                GraphQLComment graphQLComment = (GraphQLComment) obj;
                Builder a = Builder.a(graphQLComment);
                GraphQLFeedback.Builder builder = new GraphQLFeedback.Builder();
                builder.v = pendingCommentInputEntry.a;
                a.o = builder.a();
                GraphQLComment a2 = a.a();
                this.f4474d.f4485i.a(str, GraphQLFeedOptimisticPublishState.OFFLINE);
                this.f4474d.f4488l.m5180b(a2);
                this.f4474d.f4477a.a(new UpdateCommentEvent(graphQLComment, graphQLFeedback.j()));
            }
        };
    }

    public final void m5067a(GraphQLFeedback graphQLFeedback, FeedbackLoggingParams feedbackLoggingParams) {
        this.f4491o.m2218a(graphQLFeedback, feedbackLoggingParams, this.f4492p, new MutationCallback<GraphQLFeedback>(this, null) {
            final /* synthetic */ FeedbackController f4476b;

            public final void m5055a(Object obj) {
                GraphQLFeedback graphQLFeedback = (GraphQLFeedback) obj;
                this.f4476b.f4477a.a(new UpdateLikeFeedbackEvent(graphQLFeedback));
                if (graphQLFeedback.j() != null) {
                    this.f4476b.f4478b.a(new LikeUpdatedUIEvent(graphQLFeedback.j(), graphQLFeedback.y_(), true, graphQLFeedback));
                }
                if (graphQLFeedback.y_()) {
                    ((FBSoundUtil) this.f4476b.f4484h.get()).b("like_main");
                }
            }

            public final void m5056a(Object obj, ServiceException serviceException) {
                GraphQLFeedback graphQLFeedback = (GraphQLFeedback) obj;
                this.f4476b.f4477a.a(new UpdateLikeFeedbackEvent(graphQLFeedback));
                if (graphQLFeedback.j() != null) {
                    this.f4476b.f4478b.a(new LikeUpdatedUIEvent(graphQLFeedback.j(), graphQLFeedback.y_(), true, graphQLFeedback));
                }
                if (serviceException != null) {
                    this.f4476b.f4480d.m5077a(serviceException);
                }
                if (null != null) {
                    null.onFailure(serviceException);
                }
            }

            public final void m5057b(Object obj) {
                GraphQLFeedback graphQLFeedback = (GraphQLFeedback) obj;
                if (null != null) {
                    null.onSuccess(graphQLFeedback);
                }
            }

            public final /* bridge */ /* synthetic */ void m5058c(Object obj) {
            }
        });
    }

    public final void m5065a() {
        this.f4486j.c();
        this.f4490n.f2251d.c();
        this.f4491o.f2264b.c();
    }
}
