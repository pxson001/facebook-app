package com.facebook.uberbar.core;

import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.common.time.AwakeTimeSinceBootClockMethodAutoProvider;
import com.facebook.common.time.MonotonicClock;
import com.facebook.fbservice.ops.DefaultBlueServiceOperationFactory;
import com.facebook.inject.InjectorLike;
import com.facebook.search.api.GraphSearchQuery;
import com.facebook.search.api.SearchTypeaheadResultsCreator;
import com.facebook.sequencelogger.SequenceLogger;
import com.facebook.sequencelogger.SequenceLoggerImpl;
import com.facebook.uberbar.analytics.UberbarPerformanceLogger;
import com.facebook.uberbar.module.UberbarModule;
import com.facebook.uberbar.resolvers.FriendsLocalUberbarResultResolver;
import com.facebook.uberbar.resolvers.LocalUberbarResultResolver;
import com.facebook.uberbar.resolvers.PagesLocalUberbarResultResolver;
import javax.inject.Inject;

/* compiled from: total_cpu_time_sec */
public class UberbarResultFetcherFactory {
    private final LocalUberbarResultResolver f1448a;
    private final LocalUberbarResultResolver f1449b;
    private final DefaultAndroidThreadUtil f1450c;
    private final DefaultBlueServiceOperationFactory f1451d;
    private final Boolean f1452e;
    private final UberbarPerformanceLogger f1453f;
    private final SearchTypeaheadResultsCreator f1454g;
    private final AbstractFbErrorReporter f1455h;

    public static UberbarResultFetcherFactory m1544b(InjectorLike injectorLike) {
        return new UberbarResultFetcherFactory(FriendsLocalUberbarResultResolver.m1550a(injectorLike), PagesLocalUberbarResultResolver.m1554a(injectorLike), DefaultAndroidThreadUtil.b(injectorLike), DefaultBlueServiceOperationFactory.b(injectorLike), UberbarModule.m1546a(), new UberbarPerformanceLogger((MonotonicClock) AwakeTimeSinceBootClockMethodAutoProvider.a(injectorLike), (SequenceLogger) SequenceLoggerImpl.a(injectorLike)), SearchTypeaheadResultsCreator.a(injectorLike), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike));
    }

    @Inject
    public UberbarResultFetcherFactory(LocalUberbarResultResolver localUberbarResultResolver, LocalUberbarResultResolver localUberbarResultResolver2, DefaultAndroidThreadUtil defaultAndroidThreadUtil, DefaultBlueServiceOperationFactory defaultBlueServiceOperationFactory, Boolean bool, UberbarPerformanceLogger uberbarPerformanceLogger, SearchTypeaheadResultsCreator searchTypeaheadResultsCreator, AbstractFbErrorReporter abstractFbErrorReporter) {
        this.f1448a = localUberbarResultResolver;
        this.f1449b = localUberbarResultResolver2;
        this.f1450c = defaultAndroidThreadUtil;
        this.f1451d = defaultBlueServiceOperationFactory;
        this.f1452e = bool;
        this.f1453f = uberbarPerformanceLogger;
        this.f1454g = searchTypeaheadResultsCreator;
        this.f1455h = abstractFbErrorReporter;
    }

    public final UberbarResultFetcher m1545a(int i, GraphSearchQuery graphSearchQuery, String str) {
        return new UberbarResultFetcher(this.f1448a, this.f1449b, this.f1450c, this.f1451d, i, graphSearchQuery, str, this.f1452e.booleanValue(), this.f1453f, this.f1454g, this.f1455h);
    }
}
