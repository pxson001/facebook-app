package com.facebook.feed.server;

import com.facebook.api.feed.FetchFeedParams;
import com.facebook.api.feed.FetchFeedParams.FetchTypeForLogging;
import com.facebook.api.feed.FetchFeedParamsBuilder;
import com.facebook.api.feed.FetchFeedResult;
import com.facebook.api.feed.util.FeedUtils;
import com.facebook.api.feed.xconfig.NewsFeedXConfig;
import com.facebook.api.feed.xconfig.NewsFeedXConfigReader;
import com.facebook.api.feedtype.FeedType.CachePolicy;
import com.facebook.api.feedtype.FeedType.Name;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.callercontext.DefaultCallerContextHolder;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.fbservice.service.BlueServiceProgressCallback;
import com.facebook.fbservice.service.DataFreshnessParam;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.feed.protocol.FeedReliabilityLogger;
import com.facebook.feed.protocol.FetchFeedMethod;
import com.facebook.feed.util.injection.FeedClientSideInjectionTool;
import com.facebook.http.protocol.ApiMethodRunner;
import com.facebook.http.protocol.ApiMethodRunner.Batch;
import com.facebook.http.protocol.ApiMethodRunner.Batch.Type;
import com.facebook.http.protocol.ApiMethodRunnerImpl;
import com.facebook.http.protocol.ApiMethodRunnerParams;
import com.facebook.http.protocol.BatchMethodNotExecutedException;
import com.facebook.http.protocol.BatchOperation;
import com.facebook.http.protocol.BatchOperation.Builder;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.user.model.User;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: UID */
public class NewsFeedServiceImplementation {
    private final Lazy<ApiMethodRunner> f21633a;
    public final Lazy<FeedClientSideInjectionTool> f21634b;
    public final Lazy<NewsFeedFilterHandler> f21635c;
    private final NewsFeedXConfigReader f21636d;
    private final Provider<User> f21637e;
    private final Clock f21638f;
    private final FeedReliabilityLogger f21639g;

    public static NewsFeedServiceImplementation m24226a(InjectorLike injectorLike) {
        return new NewsFeedServiceImplementation(IdBasedSingletonScopeProvider.b(injectorLike, 2279), IdBasedSingletonScopeProvider.b(injectorLike, 6094), IdBasedLazy.a(injectorLike, 1715), IdBasedProvider.a(injectorLike, 3595), (Clock) SystemClockMethodAutoProvider.a(injectorLike), FeedReliabilityLogger.a(injectorLike), NewsFeedXConfigReader.a(injectorLike));
    }

    @Inject
    public NewsFeedServiceImplementation(Lazy<ApiMethodRunner> lazy, Lazy<FeedClientSideInjectionTool> lazy2, Lazy<NewsFeedFilterHandler> lazy3, Provider<User> provider, Clock clock, FeedReliabilityLogger feedReliabilityLogger, NewsFeedXConfigReader newsFeedXConfigReader) {
        this.f21633a = lazy;
        this.f21634b = lazy2;
        this.f21635c = lazy3;
        this.f21636d = newsFeedXConfigReader;
        this.f21637e = provider;
        this.f21638f = clock;
        this.f21639g = feedReliabilityLogger;
    }

    public final FetchFeedResult m24228a(FetchFeedParams fetchFeedParams, BlueServiceProgressCallback blueServiceProgressCallback, FetchFeedMethod fetchFeedMethod) {
        boolean z;
        if (fetchFeedParams.b.e() != CachePolicy.NO_CACHE) {
            z = true;
        } else {
            z = false;
        }
        if (fetchFeedParams.a == DataFreshnessParam.DO_NOT_CHECK_SERVER) {
            return FetchFeedResult.a(fetchFeedParams);
        }
        FetchFeedResult fetchFeedResult;
        if (fetchFeedParams.b.g.equals(Name.a)) {
            if (!fetchFeedParams.o || fetchFeedParams.p == FetchTypeForLogging.TAIL) {
                fetchFeedResult = (FetchFeedResult) ((ApiMethodRunnerImpl) this.f21633a.get()).a(fetchFeedMethod, fetchFeedParams, null);
            } else {
                fetchFeedResult = m24224a(blueServiceProgressCallback, fetchFeedParams, null, fetchFeedMethod);
            }
            fetchFeedResult = ((FeedClientSideInjectionTool) this.f21634b.get()).a(fetchFeedResult);
        } else {
            fetchFeedResult = (FetchFeedResult) ((ApiMethodRunnerImpl) this.f21633a.get()).a(fetchFeedMethod, fetchFeedParams);
        }
        return ((NewsFeedFilterHandler) this.f21635c.get()).a(fetchFeedResult, z);
    }

    private FetchFeedResult m24224a(BlueServiceProgressCallback blueServiceProgressCallback, FetchFeedParams fetchFeedParams, @Nullable ApiMethodRunnerParams apiMethodRunnerParams, FetchFeedMethod fetchFeedMethod) {
        Batch a = m24227a(blueServiceProgressCallback, fetchFeedParams, fetchFeedMethod);
        try {
            CallerContext a2;
            CallerContext b = DefaultCallerContextHolder.b(fetchFeedParams.l());
            if (b == null) {
                a2 = CallerContext.a(getClass());
            } else {
                a2 = b;
            }
            String str = "fetch-feed-batch";
            a.a(str, CallerContext.a(a2, fetchFeedParams.h().isManual() ? str + "-ptr" : str), apiMethodRunnerParams);
            return ((FetchFeedResult) a.a("first-fetch")).a(fetchFeedParams, (FetchFeedResult) a.a("second-fetch"));
        } catch (Exception e) {
            Exception exception = e;
            FetchFeedResult fetchFeedResult = (FetchFeedResult) a.a("first-fetch");
            FetchFeedResult fetchFeedResult2 = (FetchFeedResult) a.a("second-fetch");
            if (fetchFeedResult == null && fetchFeedResult2 == null) {
                throw exception;
            }
            if (fetchFeedResult != null) {
                fetchFeedResult2 = fetchFeedResult;
            }
            return new FetchFeedResult(fetchFeedParams, fetchFeedResult2.c(), fetchFeedResult2.a(), fetchFeedResult2.b(), fetchFeedResult2.i());
        }
    }

    private Batch m24227a(BlueServiceProgressCallback blueServiceProgressCallback, FetchFeedParams fetchFeedParams, FetchFeedMethod fetchFeedMethod) {
        boolean z;
        String str;
        if (fetchFeedParams.b.e() != CachePolicy.NO_CACHE) {
            z = true;
        } else {
            z = false;
        }
        NewsFeedXConfigReader newsFeedXConfigReader = this.f21636d;
        if (newsFeedXConfigReader.e == -1) {
            newsFeedXConfigReader.e = newsFeedXConfigReader.a.a(NewsFeedXConfig.f, 3);
        }
        int min = Math.min(newsFeedXConfigReader.e, fetchFeedParams.c);
        if (this.f21637e.get() != null) {
            str = ((User) this.f21637e.get()).a;
        } else {
            str = "0";
        }
        Batch a = ((ApiMethodRunnerImpl) this.f21633a.get()).a().a(Type.STREAMING);
        String a2 = FeedUtils.a(str, this.f21638f);
        FetchFeedParamsBuilder a3 = new FetchFeedParamsBuilder().a(fetchFeedParams);
        a3.c = min;
        a3 = a3;
        a3.k = FetchTypeForLogging.CHUNKED_INITIAL;
        a3 = a3;
        a3.h = a2;
        Builder a4 = BatchOperation.a(fetchFeedMethod, a3.q());
        a4.c = "first-fetch";
        a4 = a4;
        a4.f = m24225a(blueServiceProgressCallback, z);
        a.a(a4.a(true).a());
        if (min < fetchFeedParams.c) {
            FetchFeedParamsBuilder a5 = new FetchFeedParamsBuilder().a(fetchFeedParams);
            a5.c = fetchFeedParams.c - min;
            FetchFeedParamsBuilder fetchFeedParamsBuilder = a5;
            fetchFeedParamsBuilder.f = "{result=first-fetch:$.viewer.news_feed.page_info.end_cursor}";
            fetchFeedParamsBuilder = fetchFeedParamsBuilder;
            fetchFeedParamsBuilder.k = FetchTypeForLogging.CHUNKED_REMAINDER;
            fetchFeedParamsBuilder = fetchFeedParamsBuilder;
            fetchFeedParamsBuilder.h = FeedUtils.a(str, this.f21638f);
            Builder a6 = BatchOperation.a(fetchFeedMethod, fetchFeedParamsBuilder.q());
            a6.c = "second-fetch";
            a6 = a6;
            a6.f = m24225a(blueServiceProgressCallback, z);
            Builder builder = a6;
            builder.e = "first-fetch:$.viewer.news_feed.page_info.end_cursor";
            a.a(builder.a(true).a());
        }
        return a;
    }

    private C18121 m24225a(final BlueServiceProgressCallback blueServiceProgressCallback, final boolean z) {
        return new Object(this) {
            final /* synthetic */ NewsFeedServiceImplementation f21632c;

            public final void m24223a(Object obj) {
                if (blueServiceProgressCallback != null) {
                    blueServiceProgressCallback.a(OperationResult.a(((NewsFeedFilterHandler) this.f21632c.f21635c.get()).a(((FeedClientSideInjectionTool) this.f21632c.f21634b.get()).a((FetchFeedResult) obj), z)));
                }
            }

            public final void m24222a(Exception exception) {
                if (!(exception instanceof BatchMethodNotExecutedException) && blueServiceProgressCallback != null) {
                    blueServiceProgressCallback.a(OperationResult.a(exception));
                }
            }
        };
    }
}
