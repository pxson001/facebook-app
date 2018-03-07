package com.facebook.messaging.messagerequests.loaders;

import android.os.Bundle;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.common.futures.FutureAndCallbackHolder;
import com.facebook.common.loader.FbLoader;
import com.facebook.common.loader.FbLoader.Callback;
import com.facebook.fbservice.ops.BlueServiceOperationFactory.OperationFuture;
import com.facebook.fbservice.ops.DefaultBlueServiceOperationFactory;
import com.facebook.fbservice.ops.ErrorPropagation;
import com.facebook.fbservice.service.DataFreshnessParam;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.analytics.perf.MessagingPerformanceLogger;
import com.facebook.messaging.model.folders.FolderName;
import com.facebook.messaging.model.threads.ThreadSummary;
import com.facebook.messaging.model.threads.ThreadsCollection;
import com.facebook.messaging.service.model.FetchMoreThreadsParams;
import com.facebook.messaging.service.model.FetchMoreThreadsResult;
import com.facebook.messaging.service.model.FetchThreadListParams;
import com.facebook.messaging.service.model.FetchThreadListParamsBuilder;
import com.facebook.messaging.service.model.FetchThreadListResult;
import com.facebook.tools.dextr.runtime.detour.BlueServiceOperationFactoryDetour;
import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.Futures;
import java.util.Random;
import java.util.concurrent.Executor;
import javax.inject.Inject;

/* compiled from: saved_dashboard_nux_imp */
public class MessageRequestsLoader implements FbLoader<Params, Result, Throwable> {
    public static final Class<?> f3238a = MessageRequestsLoader.class;
    public final DefaultBlueServiceOperationFactory f3239b;
    public final AbstractFbErrorReporter f3240c;
    public final Executor f3241d;
    public final MessagingPerformanceLogger f3242e;
    public final Random f3243f = new Random();
    public FutureAndCallbackHolder<OperationResult> f3244g;
    public FutureAndCallbackHolder<OperationResult> f3245h;
    public Result f3246i;
    public Callback<Params, Result, Throwable> f3247j;
    public int f3248k;

    /* compiled from: saved_dashboard_nux_imp */
    public enum LoadType {
        THREAD_LIST,
        MORE_THREADS
    }

    /* compiled from: saved_dashboard_nux_imp */
    public class Params {
        public final FolderName f3233a;
        public final LoadType f3234b;
        public final boolean f3235c;
    }

    /* compiled from: saved_dashboard_nux_imp */
    public class Result {
        public final FolderName f3236a;
        public final ThreadsCollection f3237b;

        public Result(FolderName folderName, ThreadsCollection threadsCollection) {
            this.f3236a = folderName;
            this.f3237b = threadsCollection;
        }
    }

    public static MessageRequestsLoader m3157b(InjectorLike injectorLike) {
        return new MessageRequestsLoader(DefaultBlueServiceOperationFactory.b(injectorLike), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike), (Executor) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(injectorLike), MessagingPerformanceLogger.a(injectorLike));
    }

    public final void m3160a(Object obj) {
        final Params params = (Params) obj;
        if (params.f3234b == LoadType.THREAD_LIST && this.f3244g == null) {
            DataFreshnessParam dataFreshnessParam;
            if (params.f3235c) {
                dataFreshnessParam = DataFreshnessParam.CHECK_SERVER_FOR_NEW_DATA;
            } else {
                dataFreshnessParam = DataFreshnessParam.PREFER_CACHE_IF_UP_TO_DATE;
            }
            final int nextInt = this.f3243f.nextInt();
            this.f3248k = nextInt;
            this.f3242e.a(nextInt, "MessageRequestsLoader");
            FetchThreadListParamsBuilder newBuilder = FetchThreadListParams.newBuilder();
            newBuilder.a = dataFreshnessParam;
            newBuilder = newBuilder;
            newBuilder.b = params.f3233a;
            newBuilder = newBuilder;
            newBuilder.f = 8;
            FetchThreadListParams h = newBuilder.h();
            Bundle bundle = new Bundle();
            bundle.putParcelable("fetchThreadListParams", h);
            bundle.putInt("logger_instance_key", nextInt);
            OperationFuture a = BlueServiceOperationFactoryDetour.a(this.f3239b, "fetch_thread_list", bundle, ErrorPropagation.BY_ERROR_CODE, null, -1195037996).a();
            this.f3247j.a(params, a);
            C05221 c05221 = new AbstractDisposableFutureCallback<OperationResult>(this) {
                final /* synthetic */ MessageRequestsLoader f3230c;

                protected final void m3153a(Object obj) {
                    OperationResult operationResult = (OperationResult) obj;
                    this.f3230c.f3242e.f(nextInt);
                    this.f3230c.f3244g = null;
                    FetchThreadListResult fetchThreadListResult = (FetchThreadListResult) operationResult.h();
                    this.f3230c.f3246i = new Result(params.f3233a, fetchThreadListResult.c);
                    this.f3230c.f3247j.a(params, this.f3230c.f3246i);
                    this.f3230c.f3247j.b(params, this.f3230c.f3246i);
                }

                protected final void m3154a(Throwable th) {
                    this.f3230c.f3242e.g(nextInt);
                    this.f3230c.f3244g = null;
                    this.f3230c.f3240c.a(MessageRequestsLoader.f3238a.getSimpleName(), "Failed fetching Conversation Requests", th);
                    this.f3230c.f3247j.c(params, th);
                }
            };
            this.f3244g = FutureAndCallbackHolder.a(a, c05221);
            Futures.a(a, c05221, this.f3241d);
        } else if (params.f3234b == LoadType.MORE_THREADS) {
            m3158b(params);
        }
    }

    @Inject
    public MessageRequestsLoader(DefaultBlueServiceOperationFactory defaultBlueServiceOperationFactory, AbstractFbErrorReporter abstractFbErrorReporter, Executor executor, MessagingPerformanceLogger messagingPerformanceLogger) {
        this.f3239b = defaultBlueServiceOperationFactory;
        this.f3240c = abstractFbErrorReporter;
        this.f3241d = executor;
        this.f3242e = messagingPerformanceLogger;
    }

    public final void m3159a(Callback<Params, Result, Throwable> callback) {
        this.f3247j = callback;
    }

    private void m3158b(final Params params) {
        if (this.f3244g == null && this.f3245h == null) {
            Preconditions.checkNotNull(this.f3246i);
            Preconditions.checkArgument(!this.f3246i.f3237b.d());
            ThreadsCollection threadsCollection = this.f3246i.f3237b;
            ThreadSummary a = threadsCollection.a(threadsCollection.e() - 1);
            FetchMoreThreadsParams fetchMoreThreadsParams = new FetchMoreThreadsParams(params.f3233a, a.k, a.a.i(), 6);
            Bundle bundle = new Bundle();
            bundle.putParcelable("fetchMoreThreadsParams", fetchMoreThreadsParams);
            OperationFuture a2 = BlueServiceOperationFactoryDetour.a(this.f3239b, "fetch_more_threads", bundle, ErrorPropagation.BY_ERROR_CODE, null, -860700969).a();
            this.f3247j.a(params, a2);
            C05232 c05232 = new AbstractDisposableFutureCallback<OperationResult>(this) {
                final /* synthetic */ MessageRequestsLoader f3232b;

                protected final void m3155a(Object obj) {
                    OperationResult operationResult = (OperationResult) obj;
                    this.f3232b.f3245h = null;
                    ThreadsCollection a = ThreadsCollection.a(this.f3232b.f3246i.f3237b, ((FetchMoreThreadsResult) operationResult.h()).c);
                    this.f3232b.f3246i = new Result(params.f3233a, a);
                    this.f3232b.f3247j.a(params, this.f3232b.f3246i);
                    this.f3232b.f3247j.b(params, this.f3232b.f3246i);
                }

                protected final void m3156a(Throwable th) {
                    this.f3232b.f3245h = null;
                    this.f3232b.f3247j.c(params, th);
                }
            };
            this.f3245h = FutureAndCallbackHolder.a(a2, c05232);
            Futures.a(a2, c05232, this.f3241d);
        }
    }
}
