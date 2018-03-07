package com.facebook.orca.threadlist;

import android.os.Bundle;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.futures.FutureAndCallbackHolder;
import com.facebook.common.loader.FbLoader;
import com.facebook.common.loader.FbLoader.Callback;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.debug.debugoverlay.DebugOverlayController;
import com.facebook.debug.log.BLog;
import com.facebook.fbservice.ops.BlueServiceOperationFactory;
import com.facebook.fbservice.ops.DefaultBlueServiceOperationFactory;
import com.facebook.fbservice.ops.OperationResultFutureCallback;
import com.facebook.fbservice.results.DataFetchDisposition;
import com.facebook.fbservice.service.DataFreshnessParam;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.fbservice.service.ServiceException;
import com.facebook.http.interfaces.RequestPriority;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.messaging.analytics.perf.MessagingPerformanceLogger;
import com.facebook.messaging.cache.DataCache;
import com.facebook.messaging.cache.ThreadsCacheUpdateRateLimiter;
import com.facebook.messaging.debugoverlay.MessagesDebugOverlaySettingsTags;
import com.facebook.messaging.model.folders.FolderName;
import com.facebook.messaging.model.folders.ThreadTypeFilter;
import com.facebook.messaging.model.threadkey.ThreadKey;
import com.facebook.messaging.model.threads.ThreadSummary;
import com.facebook.messaging.model.threads.ThreadsCollection;
import com.facebook.messaging.service.model.FetchMoreThreadsParams;
import com.facebook.messaging.service.model.FetchMoreThreadsResult;
import com.facebook.messaging.service.model.FetchThreadListParams;
import com.facebook.messaging.service.model.FetchThreadListParamsBuilder;
import com.facebook.messaging.service.model.FetchThreadListResult;
import com.facebook.tools.dextr.runtime.detour.BlueServiceOperationFactoryDetour;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.EnumMap;
import java.util.Map;
import java.util.Random;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;
import javax.inject.Inject;

/* compiled from: native_album */
public class ThreadListLoader implements FbLoader<Params, Result, Error> {
    private final DefaultBlueServiceOperationFactory f6718a;
    private final Clock f6719b;
    private final DebugOverlayController f6720c;
    private final ThreadsCacheUpdateRateLimiter f6721d;
    private final DataCache f6722e;
    public final MessagingPerformanceLogger f6723f;
    private final Lazy<FbErrorReporter> f6724g;
    private final Random f6725h;
    private FolderName f6726i;
    private ThreadTypeFilter f6727j = ThreadTypeFilter.ALL;
    private Callback<Params, Result, Error> f6728k;
    private DataFreshnessParam f6729l;
    public FutureAndCallbackHolder<OperationResult> f6730m;
    public FutureAndCallbackHolder<OperationResult> f6731n;
    public Params f6732o;
    private final Map<ThreadTypeFilter, Result> f6733p = new EnumMap(ThreadTypeFilter.class);
    private int f6734q;
    @Nullable
    public Params f6735r;

    /* compiled from: native_album */
    public class Error {
        public final ServiceException f6705a;
        public final boolean f6706b;

        public Error(ServiceException serviceException, boolean z) {
            this.f6705a = serviceException;
            this.f6706b = z;
        }
    }

    /* compiled from: native_album */
    public enum LoadType {
        THREAD_LIST,
        MORE_THREADS
    }

    @Immutable
    /* compiled from: native_album */
    public class Params {
        public final boolean f6707a;
        public final boolean f6708b;
        public final LoadType f6709c;
        public final ThreadTypeFilter f6710d;
        public final boolean f6711e;
        public final CallerContext f6712f;

        public Params(boolean z, boolean z2, LoadType loadType, ThreadTypeFilter threadTypeFilter, boolean z3, CallerContext callerContext) {
            this.f6707a = z;
            this.f6708b = z2;
            this.f6709c = loadType;
            this.f6710d = threadTypeFilter;
            this.f6711e = z3;
            this.f6712f = callerContext;
        }

        public static Params m6397a(boolean z, boolean z2, boolean z3, ThreadTypeFilter threadTypeFilter, CallerContext callerContext) {
            return new Params(z, z2, LoadType.THREAD_LIST, threadTypeFilter, z3, callerContext);
        }

        public static Params m6396a(Params params, Params params2) {
            boolean z;
            boolean z2;
            boolean z3 = true;
            Preconditions.checkState(params.f6709c == params2.f6709c);
            if (params.f6710d == params2.f6710d) {
                z = true;
            } else {
                z = false;
            }
            Preconditions.checkState(z);
            if (params.f6707a || params2.f6707a) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (!(params.f6708b || params2.f6708b)) {
                z3 = false;
            }
            if (params.f6707a == z2 && params.f6708b == z3) {
                return params;
            }
            return new Params(z2, z3, params.f6709c, params.f6710d, params.f6711e, params2.f6712f != null ? params2.f6712f : params.f6712f);
        }

        public String toString() {
            return Objects.toStringHelper(this).add("needToHitServer", this.f6707a).add("loadWasFromUserAction", this.f6708b).add("loadType", this.f6709c).add("inboxFilter", this.f6710d).add("callerContext", this.f6712f).toString();
        }
    }

    /* compiled from: native_album */
    public class Result {
        public static final Result f6713a = m6398a(ThreadsCollection.b, 0, 0, DataFetchDisposition.a);
        public final ThreadsCollection f6714b;
        public final long f6715c;
        public final long f6716d;
        public final DataFetchDisposition f6717e;

        private Result(ThreadsCollection threadsCollection, long j, long j2, DataFetchDisposition dataFetchDisposition) {
            this.f6714b = threadsCollection;
            this.f6715c = j;
            this.f6716d = j2;
            this.f6717e = dataFetchDisposition;
        }

        public static Result m6398a(ThreadsCollection threadsCollection, long j, long j2, DataFetchDisposition dataFetchDisposition) {
            return new Result(threadsCollection, j, j2, dataFetchDisposition);
        }

        public final boolean m6399a() {
            return this.f6714b.d();
        }
    }

    public static ThreadListLoader m6401a(InjectorLike injectorLike) {
        return new ThreadListLoader(DefaultBlueServiceOperationFactory.b(injectorLike), (Clock) SystemClockMethodAutoProvider.a(injectorLike), DebugOverlayController.a(injectorLike), ThreadsCacheUpdateRateLimiter.a(injectorLike), DataCache.a(injectorLike), MessagingPerformanceLogger.a(injectorLike), IdBasedSingletonScopeProvider.b(injectorLike, 494));
    }

    @Inject
    public ThreadListLoader(BlueServiceOperationFactory blueServiceOperationFactory, Clock clock, DebugOverlayController debugOverlayController, ThreadsCacheUpdateRateLimiter threadsCacheUpdateRateLimiter, DataCache dataCache, MessagingPerformanceLogger messagingPerformanceLogger, Lazy<FbErrorReporter> lazy) {
        this.f6718a = blueServiceOperationFactory;
        this.f6719b = clock;
        this.f6720c = debugOverlayController;
        this.f6721d = threadsCacheUpdateRateLimiter;
        this.f6722e = dataCache;
        this.f6723f = messagingPerformanceLogger;
        this.f6724g = lazy;
        this.f6725h = new Random();
    }

    public final void m6417a(FolderName folderName) {
        Preconditions.checkNotNull(folderName);
        if (folderName != this.f6726i) {
            this.f6726i = folderName;
            m6414d();
        }
    }

    public final void m6418a(ThreadTypeFilter threadTypeFilter) {
        if (this.f6727j != threadTypeFilter) {
            this.f6727j = threadTypeFilter;
            m6410a(false);
        }
    }

    public final void m6416a(Callback<Params, Result, Error> callback) {
        this.f6728k = callback;
    }

    private void m6414d() {
        m6410a(true);
    }

    private void m6410a(boolean z) {
        if (this.f6730m != null) {
            this.f6730m.a(false);
            this.f6730m = null;
            MessagingPerformanceLogger messagingPerformanceLogger = this.f6723f;
            messagingPerformanceLogger.d.b(5505042, this.f6734q, (short) 4);
        }
        if (this.f6731n != null) {
            this.f6731n.a(false);
            this.f6731n = null;
        }
        this.f6732o = null;
        if (z) {
            this.f6733p.clear();
        }
    }

    public final void m6419a(@Nonnull Params params) {
        Preconditions.checkNotNull(params);
        if (params.f6709c == LoadType.THREAD_LIST) {
            m6411b(params);
        } else if (params.f6709c == LoadType.MORE_THREADS) {
            m6413c(params);
        }
    }

    private void m6411b(Params params) {
        Result a;
        int nextInt = this.f6725h.nextInt();
        this.f6734q = nextInt;
        this.f6723f.a(nextInt, "ThreadListLoader.startLoadThreadList");
        if (this.f6722e.a(this.f6726i, params.f6710d)) {
            a = Result.m6398a(this.f6722e.b(this.f6726i, params.f6710d), this.f6722e.c(this.f6726i, params.f6710d), this.f6722e.a(this.f6726i).e, DataFetchDisposition.d);
            this.f6733p.put(params.f6710d, a);
            this.f6723f.a(nextInt, a.f6717e);
            this.f6723f.f(nextInt);
            m6404a(params, a);
        } else {
            a = null;
        }
        if (this.f6731n != null) {
            if (!this.f6732o.f6708b || params.f6708b) {
                this.f6731n.a(false);
                this.f6731n = null;
                this.f6732o = null;
            } else {
                this.f6723f.f(nextInt);
                return;
            }
        }
        if (this.f6730m != null) {
            this.f6732o = Params.m6396a(this.f6732o, params);
            if (params.f6711e) {
                this.f6735r = params;
            }
            this.f6723f.f(nextInt);
        } else if (a == null) {
            m6402a(params, DataFreshnessParam.STALE_DATA_OKAY, nextInt);
        } else if (params.f6707a) {
            m6402a(params, DataFreshnessParam.CHECK_SERVER_FOR_NEW_DATA, nextInt);
        } else if (this.f6721d.a(this.f6726i)) {
            m6402a(params, DataFreshnessParam.PREFER_CACHE_IF_UP_TO_DATE, nextInt);
        } else {
            this.f6732o = params;
            m6412b(this.f6732o, a);
        }
    }

    public final void m6415a() {
        m6414d();
    }

    public final boolean m6421b() {
        return this.f6730m != null;
    }

    private void m6402a(final Params params, DataFreshnessParam dataFreshnessParam, final int i) {
        if (this.f6730m != null) {
            this.f6723f.f(i);
            return;
        }
        RequestPriority requestPriority;
        this.f6723f.a(i, "ThreadListLoader.loadThreads");
        RequestPriority requestPriority2 = RequestPriority.NON_INTERACTIVE;
        if (params == null || !(params.f6711e || params.f6708b)) {
            requestPriority = requestPriority2;
        } else {
            requestPriority = RequestPriority.INTERACTIVE;
        }
        CallerContext a = params != null ? params.f6712f : CallerContext.a(getClass());
        this.f6729l = dataFreshnessParam;
        FetchThreadListParamsBuilder newBuilder = FetchThreadListParams.newBuilder();
        newBuilder.a = dataFreshnessParam;
        newBuilder = newBuilder;
        newBuilder.b = this.f6726i;
        newBuilder = newBuilder;
        newBuilder.c = params.f6710d;
        newBuilder = newBuilder;
        newBuilder.g = requestPriority;
        FetchThreadListParams h = newBuilder.h();
        this.f6720c.a(MessagesDebugOverlaySettingsTags.d, "ThreadListLoader FETCH_THREAD_LIST");
        Bundle bundle = new Bundle();
        bundle.putParcelable("fetchThreadListParams", h);
        bundle.putInt("logger_instance_key", i);
        ListenableFuture b = BlueServiceOperationFactoryDetour.a(this.f6718a, "fetch_thread_list", bundle, a, -735197486).b();
        this.f6732o = params;
        m6405a(params, b);
        C10111 c10111 = new OperationResultFutureCallback(this) {
            final /* synthetic */ ThreadListLoader f6702c;

            public final void m6393a(Object obj) {
                OperationResult operationResult = (OperationResult) obj;
                this.f6702c.f6730m = null;
                Params params = this.f6702c.f6735r;
                this.f6702c.f6735r = null;
                this.f6702c.f6723f.f(i);
                ThreadListLoader.m6407a(this.f6702c, params, operationResult, params, i);
            }

            protected final void m6392a(ServiceException serviceException) {
                this.f6702c.f6730m = null;
                Params params = this.f6702c.f6735r;
                this.f6702c.f6735r = null;
                this.f6702c.f6723f.g(i);
                ThreadListLoader.m6409a(this.f6702c, params, serviceException, params);
            }
        };
        this.f6730m = FutureAndCallbackHolder.a(b, c10111);
        Futures.a(b, c10111);
    }

    private void m6405a(Params params, ListenableFuture<?> listenableFuture) {
        if (this.f6728k != null) {
            this.f6728k.a(params, listenableFuture);
        } else {
            ((AbstractFbErrorReporter) this.f6724g.get()).a("ThreadListLoader", "callback is null");
        }
    }

    private void m6404a(Params params, Result result) {
        if (this.f6728k != null) {
            this.f6728k.a(params, result);
        } else {
            ((AbstractFbErrorReporter) this.f6724g.get()).a("ThreadListLoader", "callback is null");
        }
    }

    private void m6412b(Params params, Result result) {
        if (this.f6728k != null) {
            this.f6728k.b(params, result);
        } else {
            ((AbstractFbErrorReporter) this.f6724g.get()).a("ThreadListLoader", "callback is null");
        }
    }

    private void m6403a(Params params, Error error) {
        if (this.f6728k != null) {
            this.f6728k.c(params, error);
        } else {
            ((AbstractFbErrorReporter) this.f6724g.get()).a("ThreadListLoader", "callback is null");
        }
    }

    public static void m6407a(ThreadListLoader threadListLoader, Params params, @Nullable OperationResult operationResult, Params params2, int i) {
        if (threadListLoader.f6732o == null) {
            BLog.a("ThreadListLoader", "mCurrentParams is null in onFetchThreadsSucceeded.");
            return;
        }
        FetchThreadListResult fetchThreadListResult = (FetchThreadListResult) operationResult.k();
        ThreadsCollection threadsCollection = fetchThreadListResult.c;
        long d = fetchThreadListResult.g.d();
        long j = fetchThreadListResult.l;
        long a = threadListLoader.f6719b.a();
        Result a2 = Result.m6398a(threadsCollection, j, d, fetchThreadListResult.a);
        threadListLoader.f6733p.put(params.f6710d, a2);
        DataFetchDisposition dataFetchDisposition = fetchThreadListResult.a;
        if (threadListLoader.f6732o.f6707a && threadListLoader.f6729l != DataFreshnessParam.CHECK_SERVER_FOR_NEW_DATA && dataFetchDisposition.m.isLocal()) {
            threadListLoader.m6404a(params, a2);
            threadListLoader.m6402a(threadListLoader.f6732o, DataFreshnessParam.CHECK_SERVER_FOR_NEW_DATA, i);
        } else if (dataFetchDisposition.o.asBoolean(false)) {
            threadListLoader.m6404a(params, a2);
            threadListLoader.m6402a(threadListLoader.f6732o, DataFreshnessParam.CHECK_SERVER_FOR_NEW_DATA, i);
        } else if (a - a2.f6715c >= 1800000) {
            threadListLoader.m6404a(params, a2);
            threadListLoader.m6402a(threadListLoader.f6732o, DataFreshnessParam.CHECK_SERVER_FOR_NEW_DATA, i);
        } else {
            threadListLoader.m6404a(params, a2);
            threadListLoader.m6412b(threadListLoader.f6732o, a2);
            if (params2 != null) {
                threadListLoader.m6411b(params2);
            }
        }
    }

    public static void m6409a(ThreadListLoader threadListLoader, Params params, @Nullable ServiceException serviceException, Params params2) {
        threadListLoader.m6403a(params, new Error(serviceException, params.f6708b));
        if (params2 != null) {
            threadListLoader.m6411b(params2);
        }
    }

    private void m6413c(final Params params) {
        if (this.f6730m == null && this.f6731n == null) {
            Result result = (Result) this.f6733p.get(params.f6710d);
            if (result != null && !result.f6714b.d()) {
                ThreadsCollection threadsCollection = result.f6714b;
                ThreadSummary a = threadsCollection.a(threadsCollection.e() - 1);
                FetchMoreThreadsParams fetchMoreThreadsParams = new FetchMoreThreadsParams(this.f6726i, params.f6710d, a.k, a.a.i(), 10, m6400a(threadsCollection));
                this.f6720c.a(MessagesDebugOverlaySettingsTags.d, "ThreadListLoader FETCH_MORE_THREADS");
                Bundle bundle = new Bundle();
                bundle.putParcelable("fetchMoreThreadsParams", fetchMoreThreadsParams);
                ListenableFuture a2 = BlueServiceOperationFactoryDetour.a(this.f6718a, "fetch_more_threads", bundle, CallerContext.a(getClass()), -218009736).a();
                this.f6732o = params;
                m6405a(params, a2);
                C10122 c10122 = new OperationResultFutureCallback(this) {
                    final /* synthetic */ ThreadListLoader f6704b;

                    public final void m6395a(Object obj) {
                        OperationResult operationResult = (OperationResult) obj;
                        this.f6704b.f6731n = null;
                        ThreadListLoader.m6406a(this.f6704b, params, operationResult);
                    }

                    protected final void m6394a(ServiceException serviceException) {
                        this.f6704b.f6731n = null;
                        ThreadListLoader.m6408a(this.f6704b, params, serviceException);
                    }
                };
                this.f6731n = FutureAndCallbackHolder.a(a2, c10122);
                Futures.a(a2, c10122);
            }
        }
    }

    public static void m6406a(ThreadListLoader threadListLoader, Params params, OperationResult operationResult) {
        Result result = (Result) threadListLoader.f6733p.get(params.f6710d);
        if (result != null) {
            FetchMoreThreadsResult fetchMoreThreadsResult = (FetchMoreThreadsResult) operationResult.k();
            result = Result.m6398a(ThreadsCollection.a(result.f6714b, fetchMoreThreadsResult.c), result.f6715c, result.f6716d, fetchMoreThreadsResult.a);
            threadListLoader.f6733p.put(params.f6710d, result);
            threadListLoader.m6404a(params, result);
            threadListLoader.m6412b(params, result);
        }
    }

    public static void m6408a(ThreadListLoader threadListLoader, Params params, ServiceException serviceException) {
        threadListLoader.m6403a(params, new Error(serviceException, true));
    }

    private static long m6400a(ThreadsCollection threadsCollection) {
        long j = Long.MAX_VALUE;
        if (threadsCollection != null) {
            ImmutableList immutableList = threadsCollection.c;
            int size = immutableList.size();
            int i = 0;
            while (i < size) {
                long j2;
                ThreadSummary threadSummary = (ThreadSummary) immutableList.get(i);
                if (!ThreadKey.d(threadSummary.a) || threadSummary.L >= j) {
                    j2 = j;
                } else {
                    j2 = threadSummary.L;
                }
                i++;
                j = j2;
            }
        }
        return j;
    }
}
