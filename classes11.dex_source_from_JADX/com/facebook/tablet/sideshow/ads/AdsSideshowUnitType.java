package com.facebook.tablet.sideshow.ads;

import android.content.Context;
import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.common.fragmentconstants.FragmentConstants.ContentFragmentType;
import com.facebook.common.uri.FbUriIntentHandler;
import com.facebook.feed.analytics.NewsFeedAnalyticsEventBuilder;
import com.facebook.feed.logging.impression.FeedUnitSponsoredImpressionLogger;
import com.facebook.feed.platformads.AppAdsInvalidator;
import com.facebook.feed.renderer.spannable.NativeThirdPartyUriClickHandler;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.tablet.abtest.TabletExperimentConfiguration;
import com.facebook.tablet.sideshow.SideshowHost.HostInterfaceImpl;
import com.facebook.tablet.sideshow.SideshowUnit;
import com.facebook.tablet.sideshow.SideshowUnitType;
import com.facebook.tablet.sideshow.ads.graphql.FetchAppAdsSideshowDataRequest;
import com.facebook.tablet.sideshow.ads.ui.AdsSideshowListAdapter;
import com.facebook.tablet.sideshow.analytics.SideshowAnalyticsLogger;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: onbeginload */
public class AdsSideshowUnitType implements SideshowUnitType {
    private static volatile AdsSideshowUnitType f4631g;
    private final AdsSideshowListAdapter f4632a;
    private final FetchAppAdsSideshowDataRequest f4633b;
    private final AppAdsInvalidator f4634c;
    private final FeedUnitSponsoredImpressionLogger f4635d;
    private AdsSideshowUnit f4636e;
    private TabletExperimentConfiguration f4637f;

    public static com.facebook.tablet.sideshow.ads.AdsSideshowUnitType m5847a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f4631g;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.tablet.sideshow.ads.AdsSideshowUnitType.class;
        monitor-enter(r1);
        r0 = f4631g;	 Catch:{ all -> 0x003a }
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
        r0 = m5848b(r0);	 Catch:{ all -> 0x0035 }
        f4631g = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f4631g;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.tablet.sideshow.ads.AdsSideshowUnitType.a(com.facebook.inject.InjectorLike):com.facebook.tablet.sideshow.ads.AdsSideshowUnitType");
    }

    private static AdsSideshowUnitType m5848b(InjectorLike injectorLike) {
        return new AdsSideshowUnitType(new AdsSideshowListAdapter((Context) injectorLike.getInstance(Context.class), IdBasedProvider.a(injectorLike, 1117), AnalyticsLoggerMethodAutoProvider.a(injectorLike), FbUriIntentHandler.a(injectorLike), NewsFeedAnalyticsEventBuilder.a(injectorLike), SideshowAnalyticsLogger.a(injectorLike), NativeThirdPartyUriClickHandler.a(injectorLike)), FetchAppAdsSideshowDataRequest.m5853a(injectorLike), AppAdsInvalidator.b(injectorLike), FeedUnitSponsoredImpressionLogger.a(injectorLike), TabletExperimentConfiguration.a(injectorLike));
    }

    @Inject
    public AdsSideshowUnitType(AdsSideshowListAdapter adsSideshowListAdapter, FetchAppAdsSideshowDataRequest fetchAppAdsSideshowDataRequest, AppAdsInvalidator appAdsInvalidator, FeedUnitSponsoredImpressionLogger feedUnitSponsoredImpressionLogger, TabletExperimentConfiguration tabletExperimentConfiguration) {
        this.f4632a = adsSideshowListAdapter;
        this.f4633b = fetchAppAdsSideshowDataRequest;
        this.f4634c = appAdsInvalidator;
        this.f4635d = feedUnitSponsoredImpressionLogger;
        this.f4637f = tabletExperimentConfiguration;
    }

    public final SideshowUnit m5850a(HostInterfaceImpl hostInterfaceImpl) {
        if (this.f4636e == null) {
            this.f4636e = new AdsSideshowUnit(this.f4632a, this.f4633b, this.f4634c, this.f4635d);
        }
        return this.f4636e;
    }

    public final int m5849a(ContentFragmentType contentFragmentType) {
        if (null == null || contentFragmentType != ContentFragmentType.NATIVE_NEWS_FEED_FRAGMENT) {
            return 0;
        }
        return 3;
    }
}
