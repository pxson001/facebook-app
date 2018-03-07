package com.facebook.redspace.data;

import com.facebook.auth.annotations.LoggedInUserId;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.common.util.StringUtil;
import com.facebook.debug.log.BLog;
import com.facebook.graphql.calls.NoContextTokenInputNoContextToken;
import com.facebook.graphql.executor.GraphQLBatchRequest;
import com.facebook.graphql.executor.GraphQLCachePolicy;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.executor.GraphQLSubscriptionHolder;
import com.facebook.graphql.executor.RequestObservable;
import com.facebook.inject.Assisted;
import com.facebook.redspace.analytics.logger.RedSpaceLogger;
import com.facebook.redspace.analytics.logger.RedSpaceTimeLogger;
import com.facebook.redspace.fetcher.RedSpaceBatchFetcher;
import com.facebook.redspace.fetcher.RedSpaceBatchRequests;
import com.facebook.redspace.fetcher.RedSpaceBatchRequests.4;
import com.facebook.redspace.fetcher.RedSpaceBatchRequests.RedSpaceWallResult;
import com.facebook.redspace.fetcher.RedSpaceRequests;
import com.facebook.redspace.fetcher.RedSpaceViewerProfileHelper;
import com.facebook.redspace.fragment.RedSpaceStoriesFragment;
import com.facebook.redspace.fragment.controllercallbacks.RedSpaceStoriesControllerCallbacksDispatcher;
import com.facebook.redspace.fragment.controllercallbacks.controller.RedSpaceWallLoadEventController;
import com.facebook.redspace.protocol.RedSpaceFeedFragmentsModels.RedSpaceFeedProfileFragmentModel;
import com.facebook.redspace.protocol.RedSpaceFeedFragmentsModels.RedSpaceStoriesQueryModel;
import com.facebook.ui.futures.TasksManager;
import com.facebook.ultralight.Inject;
import com.facebook.ultralight.Lazy;
import com.facebook.ultralight.UltralightRuntime;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.ListenableFuture;
import java.lang.ref.WeakReference;
import java.util.concurrent.Callable;

/* compiled from: Placeholder not found for card  */
public class RedSpaceWallFetcherHelper {
    private static final String f11902a = RedSpaceWallFetcherHelper.class.getSimpleName();
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<RedSpaceBatchFetcher> f11903b = UltralightRuntime.b;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<RedSpaceRequests> f11904c = UltralightRuntime.b;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<RedSpaceBatchRequests> f11905d = UltralightRuntime.b;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<FbErrorReporter> f11906e = UltralightRuntime.b;
    @Inject
    @Lazy
    public com.facebook.inject.Lazy<GraphQLQueryExecutor> f11907f = UltralightRuntime.b;
    @Inject
    @Lazy
    public com.facebook.inject.Lazy<TasksManager> f11908g = UltralightRuntime.b;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<RedSpaceSelfProfileDataStore> f11909h = UltralightRuntime.b;
    @Inject
    @Lazy
    @LoggedInUserId
    private com.facebook.inject.Lazy<String> f11910i = UltralightRuntime.b;
    private final RedSpaceFeedProfileFragmentModel f11911j;
    private final RedSpaceWallCollection f11912k;
    private final GraphQLSubscriptionHolder f11913l;
    private final WeakReference<RedSpaceWallFetchListener> f11914m;
    public boolean f11915n = false;
    private final FutureCallback<RedSpaceWallResult> f11916o = new C14151(this);
    public final AbstractDisposableFutureCallback<GraphQLResult<RedSpaceStoriesQueryModel>> f11917p = new C14162(this);

    /* compiled from: Placeholder not found for card  */
    class C14151 extends AbstractDisposableFutureCallback<RedSpaceWallResult> {
        final /* synthetic */ RedSpaceWallFetcherHelper f11898a;

        C14151(RedSpaceWallFetcherHelper redSpaceWallFetcherHelper) {
            this.f11898a = redSpaceWallFetcherHelper;
        }

        protected final void m12350a(Object obj) {
            RedSpaceWallFetcherHelper.m12355a(this.f11898a, (RedSpaceWallResult) obj);
        }

        protected final void m12351a(Throwable th) {
            RedSpaceWallFetcherHelper.m12356a(this.f11898a, th);
        }
    }

    /* compiled from: Placeholder not found for card  */
    class C14162 extends AbstractDisposableFutureCallback<GraphQLResult<RedSpaceStoriesQueryModel>> {
        final /* synthetic */ RedSpaceWallFetcherHelper f11899a;

        C14162(RedSpaceWallFetcherHelper redSpaceWallFetcherHelper) {
            this.f11899a = redSpaceWallFetcherHelper;
        }

        protected final void m12352a(Object obj) {
            RedSpaceWallFetcherHelper.m12355a(this.f11899a, new RedSpaceWallResult((GraphQLResult) obj, null));
        }

        protected final void m12353a(Throwable th) {
            RedSpaceWallFetcherHelper.m12356a(this.f11899a, th);
        }
    }

    public final void m12357a(com.facebook.inject.Lazy<RedSpaceBatchFetcher> lazy, com.facebook.inject.Lazy<RedSpaceRequests> lazy2, com.facebook.inject.Lazy<RedSpaceBatchRequests> lazy3, com.facebook.inject.Lazy<FbErrorReporter> lazy4, com.facebook.inject.Lazy<GraphQLQueryExecutor> lazy5, com.facebook.inject.Lazy<TasksManager> lazy6, com.facebook.inject.Lazy<RedSpaceSelfProfileDataStore> lazy7, com.facebook.inject.Lazy<String> lazy8) {
        this.f11903b = lazy;
        this.f11904c = lazy2;
        this.f11905d = lazy3;
        this.f11906e = lazy4;
        this.f11907f = lazy5;
        this.f11908g = lazy6;
        this.f11909h = lazy7;
        this.f11910i = lazy8;
    }

    @Inject
    public RedSpaceWallFetcherHelper(@Assisted RedSpaceStoriesFragment redSpaceStoriesFragment, @Assisted RedSpaceFeedProfileFragmentModel redSpaceFeedProfileFragmentModel, @Assisted GraphQLSubscriptionHolder graphQLSubscriptionHolder, @Assisted RedSpaceWallCollection redSpaceWallCollection) {
        this.f11911j = redSpaceFeedProfileFragmentModel;
        this.f11913l = graphQLSubscriptionHolder;
        this.f11912k = redSpaceWallCollection;
        this.f11914m = new WeakReference(redSpaceStoriesFragment);
    }

    public final void m12358a(boolean z) {
        NoContextTokenInputNoContextToken noContextTokenInputNoContextToken = null;
        if (!((RedSpaceBatchFetcher) this.f11903b.get()).b() && this.f11912k.m12348c()) {
            String k;
            String str;
            this.f11915n = false;
            RedSpaceStoriesFragment redSpaceStoriesFragment = (RedSpaceStoriesFragment) this.f11914m.get();
            if (redSpaceStoriesFragment != null) {
                RedSpaceStoriesControllerCallbacksDispatcher redSpaceStoriesControllerCallbacksDispatcher = redSpaceStoriesFragment.aZ;
                if (redSpaceStoriesControllerCallbacksDispatcher.f12016d != null) {
                }
                if (redSpaceStoriesControllerCallbacksDispatcher.f12018f != null) {
                    ((RedSpaceTimeLogger) redSpaceStoriesControllerCallbacksDispatcher.f12018f.f12111b.get()).a();
                }
                ((RedSpaceTimeLogger) redSpaceStoriesFragment.aE.get()).a();
                redSpaceStoriesFragment.aP.a();
                redSpaceStoriesFragment.aK.f11716c = false;
            }
            GraphQLCachePolicy graphQLCachePolicy = z ? GraphQLCachePolicy.a : GraphQLCachePolicy.d;
            if (this.f11911j.m() != null) {
                k = this.f11911j.m().k();
            } else {
                ((AbstractFbErrorReporter) this.f11906e.get()).b(f11902a, "redspace in profile " + this.f11911j.k() + " is null");
                k = null;
            }
            if (!RedSpaceViewerProfileHelper.a(this.f11911j)) {
                k = null;
                noContextTokenInputNoContextToken = NoContextTokenInputNoContextToken.SELF_VIEW_UNIT_NOT_LOADED_YET;
            }
            this.f11904c.get();
            String k2 = this.f11911j.k();
            RedSpaceWallCollection redSpaceWallCollection = this.f11912k;
            if (redSpaceWallCollection.f11889b == null) {
                str = null;
            } else {
                str = redSpaceWallCollection.f11889b.a();
            }
            final GraphQLRequest a = RedSpaceRequests.a(k2, k, noContextTokenInputNoContextToken, str, graphQLCachePolicy);
            if (StringUtil.a(this.f11911j.k(), (String) this.f11910i.get())) {
                m12354a(a);
            } else {
                ((TasksManager) this.f11908g.get()).a("redspace_wall_content", new Callable<ListenableFuture>(this) {
                    final /* synthetic */ RedSpaceWallFetcherHelper f11901b;

                    public Object call() {
                        return ((GraphQLQueryExecutor) this.f11901b.f11907f.get()).a(a);
                    }
                }, this.f11917p);
            }
        }
    }

    private void m12354a(GraphQLRequest<RedSpaceStoriesQueryModel> graphQLRequest) {
        GraphQLRequest a = ((RedSpaceRequests) this.f11904c.get()).a(20, ((RedSpaceSelfProfileDataStore) this.f11909h.get()).f11872b);
        GraphQLBatchRequest graphQLBatchRequest = new GraphQLBatchRequest("redspace_self_wall_content");
        ((RedSpaceBatchFetcher) this.f11903b.get()).a(graphQLBatchRequest, RequestObservable.a(graphQLBatchRequest.a(graphQLRequest), graphQLBatchRequest.a(a), new 4((RedSpaceBatchRequests) this.f11905d.get())), this.f11916o);
    }

    public static void m12355a(RedSpaceWallFetcherHelper redSpaceWallFetcherHelper, RedSpaceWallResult redSpaceWallResult) {
        if (redSpaceWallResult.a() == null || ((RedSpaceStoriesQueryModel) redSpaceWallResult.a().e).j() == null || ((RedSpaceStoriesQueryModel) redSpaceWallResult.a().e).j().j() == null) {
            m12356a(redSpaceWallFetcherHelper, new NullPointerException("Null result " + redSpaceWallResult));
            return;
        }
        redSpaceWallFetcherHelper.f11912k.m12346a((RedSpaceStoriesQueryModel) redSpaceWallResult.a().e);
        redSpaceWallFetcherHelper.f11912k.m12342a(redSpaceWallFetcherHelper.f11913l);
        RedSpaceStoriesFragment redSpaceStoriesFragment = (RedSpaceStoriesFragment) redSpaceWallFetcherHelper.f11914m.get();
        if (redSpaceStoriesFragment != null) {
            redSpaceStoriesFragment.m12450a(redSpaceWallResult);
        }
    }

    public static void m12356a(RedSpaceWallFetcherHelper redSpaceWallFetcherHelper, Throwable th) {
        BLog.b(f11902a, "Error fetching stories", th);
        redSpaceWallFetcherHelper.f11915n = true;
        RedSpaceStoriesFragment redSpaceStoriesFragment = (RedSpaceStoriesFragment) redSpaceWallFetcherHelper.f11914m.get();
        if (redSpaceStoriesFragment != null) {
            RedSpaceStoriesControllerCallbacksDispatcher redSpaceStoriesControllerCallbacksDispatcher = redSpaceStoriesFragment.aZ;
            if (redSpaceStoriesControllerCallbacksDispatcher.f12016d != null) {
            }
            if (redSpaceStoriesControllerCallbacksDispatcher.f12018f != null) {
                RedSpaceWallLoadEventController redSpaceWallLoadEventController = redSpaceStoriesControllerCallbacksDispatcher.f12018f;
                ((RedSpaceLogger) redSpaceWallLoadEventController.f12112c.get()).b(th, ((RedSpaceTimeLogger) redSpaceWallLoadEventController.f12111b.get()).b());
            }
            ((RedSpaceLogger) redSpaceStoriesFragment.aD.get()).b(th, ((RedSpaceTimeLogger) redSpaceStoriesFragment.aE.get()).b());
            redSpaceStoriesFragment.aP.a(redSpaceStoriesFragment.aB.getString(2131230758), redSpaceStoriesFragment.aN);
            redSpaceStoriesFragment.aK.f11716c = false;
        }
    }
}
