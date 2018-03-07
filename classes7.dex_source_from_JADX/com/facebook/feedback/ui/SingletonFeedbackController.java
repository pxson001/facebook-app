package com.facebook.feedback.ui;

import com.facebook.api.prefetch.GraphQLPrefetchConsumer;
import com.facebook.api.prefetch.GraphQLPrefetchConsumerProvider;
import com.facebook.api.prefetch.GraphQLPrefetchResult;
import com.facebook.api.ufiservices.FeedbackPrefetchPolicy;
import com.facebook.api.ufiservices.FeedbackPrefetchPolicyProvider;
import com.facebook.api.ufiservices.common.CommentOrderType;
import com.facebook.auth.module.ViewerContextManagerProvider;
import com.facebook.auth.viewercontext.ViewerContext;
import com.facebook.auth.viewercontext.ViewerContext.ViewerContextBuilder;
import com.facebook.auth.viewercontext.ViewerContextManager;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.common.futures.DelayedAbstractDisposableFutureCallback;
import com.facebook.common.futures.DisposableFutureCallback;
import com.facebook.fbservice.service.DataFreshnessParam;
import com.facebook.fbservice.service.ServiceException;
import com.facebook.feed.abtest.ExperimentsForNewsFeedAbTestModule;
import com.facebook.feedback.abtest.ExperimentsForFeedbackTestModule;
import com.facebook.feedback.prefetcher.FeedbackPrefetcher;
import com.facebook.feedback.prefetcher.FeedbackPrefetchingExperiments;
import com.facebook.graphql.model.GraphQLFeedback;
import com.facebook.graphql.model.GraphQLPage;
import com.facebook.graphql.model.PropertyHelper;
import com.facebook.http.interfaces.RequestPriority;
import com.facebook.inject.InjectorLike;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.tools.dextr.runtime.detour.FutureDetour;
import com.facebook.ufiservices.data.FeedbackLoader;
import com.facebook.ufiservices.flyout.FeedbackParams;
import com.facebook.ui.futures.TasksManager;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Strings;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.SettableFuture;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: rotWave */
public class SingletonFeedbackController {
    private static volatile SingletonFeedbackController f4763l;
    private final Executor f4764a;
    public final FeedbackLoader f4765b;
    public final TasksManager f4766c;
    public ViewerContextManager f4767d;
    private final FeedbackPrefetcher f4768e;
    private final FeedbackPrefetchPolicyProvider f4769f;
    private final GraphQLPrefetchConsumerProvider f4770g;
    private final QeAccessor f4771h;
    private final FeedbackPrefetchingExperiments f4772i;
    @Nullable
    private GraphQLPrefetchConsumer<GraphQLFeedback> f4773j;
    @Nullable
    private GraphQLPrefetchConsumer<GraphQLFeedback> f4774k;

    public static com.facebook.feedback.ui.SingletonFeedbackController m5296a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find immediate dominator for block B:24:0x003b in {17, 19, 21, 23, 26, 28} preds:[]
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.computeDominators(BlockProcessor.java:129)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.processBlocksTree(BlockProcessor.java:48)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.rerun(BlockProcessor.java:44)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.visit(BlockFinallyExtract.java:57)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r0 = f4763l;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.feedback.ui.SingletonFeedbackController.class;
        monitor-enter(r1);
        r0 = f4763l;	 Catch:{ all -> 0x003a }
        if (r0 != 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000b:
        if (r5 == 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000d:
        r2 = com.facebook.inject.ScopeSet.a();	 Catch:{ all -> 0x003a }
        r3 = r2.b();	 Catch:{ all -> 0x003a }
        r0 = com.facebook.inject.SingletonScope.class;	 Catch:{ all -> 0x003a }
        r0 = r5.getInstance(r0);	 Catch:{ all -> 0x003a }
        r0 = (com.facebook.inject.SingletonScope) r0;	 Catch:{ all -> 0x003a }
        r4 = r0.enterScope();	 Catch:{ all -> 0x003a }
        r0 = r5.getApplicationInjector();	 Catch:{ all -> 0x0035 }
        r0 = m5300b(r0);	 Catch:{ all -> 0x0035 }
        f4763l = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f4763l;
        return r0;
    L_0x0035:
        r0 = move-exception;
        com.facebook.inject.SingletonScope.a(r4);	 Catch:{ all -> 0x0035 }
        throw r0;	 Catch:{ all -> 0x0035 }
    L_0x003a:
        r0 = move-exception;
        r2.c(r3);	 Catch:{ all -> 0x003a }
        throw r0;	 Catch:{ all -> 0x003a }
    L_0x003f:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x003a }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.feedback.ui.SingletonFeedbackController.a(com.facebook.inject.InjectorLike):com.facebook.feedback.ui.SingletonFeedbackController");
    }

    private static SingletonFeedbackController m5300b(InjectorLike injectorLike) {
        return new SingletonFeedbackController((Executor) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(injectorLike), FeedbackLoader.a(injectorLike), (FeedbackPrefetchPolicyProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(FeedbackPrefetchPolicyProvider.class), (GraphQLPrefetchConsumerProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(GraphQLPrefetchConsumerProvider.class), TasksManager.b(injectorLike), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike), ViewerContextManagerProvider.b(injectorLike), FeedbackPrefetcher.a(injectorLike), FeedbackPrefetchingExperiments.b(injectorLike));
    }

    @Inject
    public SingletonFeedbackController(Executor executor, FeedbackLoader feedbackLoader, FeedbackPrefetchPolicyProvider feedbackPrefetchPolicyProvider, GraphQLPrefetchConsumerProvider graphQLPrefetchConsumerProvider, TasksManager tasksManager, QeAccessor qeAccessor, ViewerContextManager viewerContextManager, FeedbackPrefetcher feedbackPrefetcher, FeedbackPrefetchingExperiments feedbackPrefetchingExperiments) {
        this.f4765b = feedbackLoader;
        this.f4769f = feedbackPrefetchPolicyProvider;
        this.f4770g = graphQLPrefetchConsumerProvider;
        this.f4764a = executor;
        this.f4766c = tasksManager;
        this.f4771h = qeAccessor;
        this.f4767d = viewerContextManager;
        this.f4768e = feedbackPrefetcher;
        this.f4772i = feedbackPrefetchingExperiments;
    }

    public final void m5303a(final FeedbackParams feedbackParams, CallerContext callerContext, final OnFeedbackLoadListener... onFeedbackLoadListenerArr) {
        if (feedbackParams.g() != null) {
            m5301b(feedbackParams, callerContext, onFeedbackLoadListenerArr);
        } else if (Strings.isNullOrEmpty(feedbackParams.d())) {
            ServiceException a = ServiceException.a(new NullPointerException("Feedback id and legacy api post id are null"));
            for (OnFeedbackLoadListener a2 : onFeedbackLoadListenerArr) {
                a2.mo197a(a, feedbackParams);
            }
        } else {
            this.f4765b.a(feedbackParams.d(), CommentOrderType.DEFAULT_ORDER, RequestPriority.INTERACTIVE, CallerContext.a(getClass(), feedbackParams.h()));
            this.f4766c.a("fetch_feedback_" + feedbackParams.d(), this.f4765b.a(feedbackParams.d(), CommentOrderType.DEFAULT_ORDER, RequestPriority.INTERACTIVE, CallerContext.a(getClass(), feedbackParams.h())), new AbstractDisposableFutureCallback<GraphQLFeedback>(this) {
                final /* synthetic */ SingletonFeedbackController f4762c;

                protected final void m5292a(Object obj) {
                    GraphQLFeedback graphQLFeedback = (GraphQLFeedback) obj;
                    if (graphQLFeedback == null) {
                        m5293a(new NullPointerException("Fetched feedback was non-existent"));
                        return;
                    }
                    for (OnFeedbackLoadListener b : onFeedbackLoadListenerArr) {
                        b.mo199b(graphQLFeedback);
                    }
                }

                protected final void m5293a(Throwable th) {
                    ServiceException a = ServiceException.a(th);
                    for (OnFeedbackLoadListener a2 : onFeedbackLoadListenerArr) {
                        a2.mo197a(a, feedbackParams);
                    }
                }
            });
        }
    }

    @VisibleForTesting
    private ListenableFuture<GraphQLFeedback> m5297a(FeedbackParams feedbackParams, CallerContext callerContext) {
        if (feedbackParams.a == null || PropertyHelper.a(feedbackParams.a) == null) {
            return null;
        }
        final String a = PropertyHelper.a(feedbackParams.a);
        GraphQLPage O = feedbackParams.a.O();
        if (O == null) {
            return null;
        }
        String ae = O.ae();
        ViewerContext d = this.f4767d.d();
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
        m5299a(feedbackParams.g(), h, callerContext, feedbackParams.q, new DelayedAbstractDisposableFutureCallback<GraphQLFeedback>(this) {
            final /* synthetic */ SingletonFeedbackController f4750c;

            protected final void m5284a(Object obj) {
                GraphQLFeedback graphQLFeedback = (GraphQLFeedback) obj;
                if (graphQLFeedback != null) {
                    PropertyHelper.a(graphQLFeedback, a);
                }
                FutureDetour.a(f, graphQLFeedback, -21797714);
            }

            protected final void m5285a(Throwable th) {
                f.a(th);
            }
        });
        return f;
    }

    private void m5302b(FeedbackParams feedbackParams, DelayedAbstractDisposableFutureCallback<GraphQLPrefetchResult<GraphQLFeedback>> delayedAbstractDisposableFutureCallback, CallerContext callerContext, OnFeedbackLoadListener... onFeedbackLoadListenerArr) {
        m5294a(feedbackParams.q, false).a(feedbackParams.g(), delayedAbstractDisposableFutureCallback, callerContext, this.f4764a);
        this.f4766c.a("fetch_focused_feedback", this.f4765b.a(feedbackParams.g(), DataFreshnessParam.CHECK_SERVER_FOR_NEW_DATA, feedbackParams.o, feedbackParams.p, feedbackParams.m, feedbackParams.q, callerContext), m5295a(this, feedbackParams, onFeedbackLoadListenerArr));
    }

    private void m5301b(FeedbackParams feedbackParams, CallerContext callerContext, final OnFeedbackLoadListener... onFeedbackLoadListenerArr) {
        C04642 c04642 = new DelayedAbstractDisposableFutureCallback<GraphQLPrefetchResult<GraphQLFeedback>>(this) {
            final /* synthetic */ SingletonFeedbackController f4752b;

            protected final void m5286a(Object obj) {
                GraphQLFeedback graphQLFeedback = (GraphQLFeedback) ((GraphQLPrefetchResult) obj).a;
                if (graphQLFeedback != null) {
                    for (OnFeedbackLoadListener c : onFeedbackLoadListenerArr) {
                        c.mo200c(graphQLFeedback);
                    }
                }
            }

            protected final void m5287a(Throwable th) {
            }
        };
        c04642.b();
        ListenableFuture a = m5297a(feedbackParams, callerContext);
        if (a != null) {
            Futures.a(a, m5295a(this, feedbackParams, onFeedbackLoadListenerArr), this.f4764a);
            return;
        }
        boolean a2 = this.f4771h.a(ExperimentsForNewsFeedAbTestModule.q, false);
        if ((feedbackParams.m == null || a2) && !feedbackParams.p) {
            m5298a(feedbackParams, c04642, callerContext, onFeedbackLoadListenerArr);
        } else {
            m5302b(feedbackParams, c04642, callerContext, onFeedbackLoadListenerArr);
        }
    }

    private void m5299a(String str, ViewerContext viewerContext, CallerContext callerContext, boolean z, DelayedAbstractDisposableFutureCallback<GraphQLFeedback> delayedAbstractDisposableFutureCallback) {
        ListenableFuture a = this.f4765b.a(str, DataFreshnessParam.CHECK_SERVER_FOR_NEW_DATA, CommentOrderType.DEFAULT_ORDER, false, null, z, callerContext, viewerContext);
        delayedAbstractDisposableFutureCallback.b();
        if (a != null) {
            this.f4766c.a("fetch_feedback_with_viewer_context", a, delayedAbstractDisposableFutureCallback);
        }
    }

    private void m5298a(final FeedbackParams feedbackParams, DelayedAbstractDisposableFutureCallback<GraphQLPrefetchResult<GraphQLFeedback>> delayedAbstractDisposableFutureCallback, CallerContext callerContext, final OnFeedbackLoadListener... onFeedbackLoadListenerArr) {
        boolean z;
        FeedbackPrefetchPolicy feedbackPrefetchPolicy;
        boolean z2 = true;
        C04653 c04653 = new DelayedAbstractDisposableFutureCallback<GraphQLPrefetchResult<GraphQLFeedback>>(this) {
            DisposableFutureCallback<GraphQLFeedback> f4753a = SingletonFeedbackController.m5295a(this.f4756d, feedbackParams, onFeedbackLoadListenerArr);
            final /* synthetic */ SingletonFeedbackController f4756d;

            protected final void m5288a(Object obj) {
                this.f4753a.onSuccess(((GraphQLPrefetchResult) obj).a);
            }

            protected final void m5289a(Throwable th) {
                this.f4753a.onFailure(th);
            }
        };
        c04653.b();
        boolean z3 = feedbackParams.q;
        if (feedbackParams.m != null) {
            z = true;
        } else {
            z = false;
        }
        GraphQLPrefetchConsumer a = m5294a(z3, z);
        if (feedbackParams.m != null) {
            FeedbackPrefetcher feedbackPrefetcher = this.f4768e;
            boolean z4 = feedbackParams.q;
            if (feedbackParams.m == null) {
                z2 = false;
            }
            FeedbackPrefetchPolicy b = feedbackPrefetcher.b(z4, z2);
            b.a(feedbackParams.g(), feedbackParams.m);
            feedbackPrefetchPolicy = b;
        } else {
            feedbackPrefetchPolicy = null;
        }
        a.a(feedbackParams.g(), delayedAbstractDisposableFutureCallback, c04653, callerContext, this.f4764a);
        if (feedbackPrefetchPolicy != null) {
            feedbackPrefetchPolicy.c(feedbackParams.g());
        }
    }

    private GraphQLPrefetchConsumer<GraphQLFeedback> m5294a(boolean z, boolean z2) {
        if (this.f4772i.b()) {
            return this.f4768e.a(z, z2);
        }
        if (!this.f4771h.a(ExperimentsForFeedbackTestModule.C, false) || !this.f4771h.a(ExperimentsForFeedbackTestModule.E, false)) {
            return this.f4770g.a(this.f4769f.a(Boolean.valueOf(z), Boolean.valueOf(false)));
        }
        if (z) {
            if (this.f4774k == null) {
                this.f4774k = this.f4770g.a(this.f4769f.a(Boolean.valueOf(true), Boolean.valueOf(false)));
            }
            return this.f4774k;
        }
        if (this.f4773j == null) {
            this.f4773j = this.f4770g.a(this.f4769f.a(Boolean.valueOf(false), Boolean.valueOf(false)));
        }
        return this.f4773j;
    }

    public static DisposableFutureCallback m5295a(SingletonFeedbackController singletonFeedbackController, final FeedbackParams feedbackParams, final OnFeedbackLoadListener... onFeedbackLoadListenerArr) {
        return new AbstractDisposableFutureCallback<GraphQLFeedback>(singletonFeedbackController) {
            final /* synthetic */ SingletonFeedbackController f4759c;

            protected final void m5290a(Object obj) {
                GraphQLFeedback graphQLFeedback = (GraphQLFeedback) obj;
                if (graphQLFeedback == null) {
                    m5291a(new NullPointerException("Fetched feedback was non-existent"));
                    return;
                }
                for (OnFeedbackLoadListener b : onFeedbackLoadListenerArr) {
                    b.mo199b(graphQLFeedback);
                }
            }

            protected final void m5291a(Throwable th) {
                ServiceException a = ServiceException.a(th);
                for (OnFeedbackLoadListener a2 : onFeedbackLoadListenerArr) {
                    a2.mo197a(a, feedbackParams);
                }
            }
        };
    }
}
