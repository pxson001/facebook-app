package com.facebook.tablet.sideshow.trending;

import android.content.Context;
import com.facebook.common.fragmentconstants.FragmentConstants.ContentFragmentType;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.inject.InjectorLike;
import com.facebook.search.intent.SearchResultsIntentBuilder;
import com.facebook.tablet.abtest.TabletExperimentConfiguration;
import com.facebook.tablet.sideshow.SideshowHost.HostInterfaceImpl;
import com.facebook.tablet.sideshow.SideshowUnit;
import com.facebook.tablet.sideshow.SideshowUnitType;
import com.facebook.tablet.sideshow.analytics.SideshowAnalyticsLogger;
import com.facebook.tablet.sideshow.trending.graphql.FetchTrendingEntitiesSideshowDataRequest;
import com.facebook.tablet.sideshow.trending.ui.TrendingSideshowListAdapter;
import com.facebook.tablet.sideshow.widget.SideshowUtils;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: og_song_id */
public class TrendingSideshowUnitType implements SideshowUnitType {
    private static volatile TrendingSideshowUnitType f4870h;
    private TrendingSideshowListAdapter f4871a;
    private FetchTrendingEntitiesSideshowDataRequest f4872b;
    private TabletExperimentConfiguration f4873c;
    private SideshowAnalyticsLogger f4874d;
    private SearchResultsIntentBuilder f4875e;
    private SecureContextHelper f4876f;
    private SideshowUtils f4877g;

    public static com.facebook.tablet.sideshow.trending.TrendingSideshowUnitType m6072a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r0 = f4870h;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.tablet.sideshow.trending.TrendingSideshowUnitType.class;
        monitor-enter(r1);
        r0 = f4870h;	 Catch:{ all -> 0x003a }
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
        r0 = m6073b(r0);	 Catch:{ all -> 0x0035 }
        f4870h = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f4870h;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.tablet.sideshow.trending.TrendingSideshowUnitType.a(com.facebook.inject.InjectorLike):com.facebook.tablet.sideshow.trending.TrendingSideshowUnitType");
    }

    private static TrendingSideshowUnitType m6073b(InjectorLike injectorLike) {
        return new TrendingSideshowUnitType(new TrendingSideshowListAdapter((Context) injectorLike.getInstance(Context.class)), FetchTrendingEntitiesSideshowDataRequest.m6110a(injectorLike), TabletExperimentConfiguration.a(injectorLike), SideshowAnalyticsLogger.a(injectorLike), SearchResultsIntentBuilder.a(injectorLike), (SecureContextHelper) DefaultSecureContextHelper.a(injectorLike), SideshowUtils.b(injectorLike));
    }

    @Inject
    public TrendingSideshowUnitType(TrendingSideshowListAdapter trendingSideshowListAdapter, FetchTrendingEntitiesSideshowDataRequest fetchTrendingEntitiesSideshowDataRequest, TabletExperimentConfiguration tabletExperimentConfiguration, SideshowAnalyticsLogger sideshowAnalyticsLogger, SearchResultsIntentBuilder searchResultsIntentBuilder, SecureContextHelper secureContextHelper, SideshowUtils sideshowUtils) {
        this.f4871a = trendingSideshowListAdapter;
        this.f4872b = fetchTrendingEntitiesSideshowDataRequest;
        this.f4873c = tabletExperimentConfiguration;
        this.f4874d = sideshowAnalyticsLogger;
        this.f4875e = searchResultsIntentBuilder;
        this.f4876f = secureContextHelper;
        this.f4877g = sideshowUtils;
    }

    public final int m6074a(ContentFragmentType contentFragmentType) {
        int i = (contentFragmentType == ContentFragmentType.NATIVE_NEWS_FEED_FRAGMENT || contentFragmentType == ContentFragmentType.SEARCH_FRAGMENT) ? 1 : 0;
        return (!this.f4873c.b() || i == 0) ? 0 : 3;
    }

    public final SideshowUnit m6075a(HostInterfaceImpl hostInterfaceImpl) {
        return new TrendingSideshowUnit(this.f4871a, this.f4872b, this.f4874d, this.f4875e, this.f4876f, this.f4877g);
    }
}
