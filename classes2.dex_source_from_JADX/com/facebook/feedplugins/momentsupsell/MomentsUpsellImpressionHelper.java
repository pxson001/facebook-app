package com.facebook.feedplugins.momentsupsell;

import android.content.Context;
import com.facebook.analytics.HoneyAnalyticsEvent;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.appsinstallhelper.AppsInstallHelper;
import com.facebook.appsinstallhelper.AppsInstallHelperProvider;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.common.util.CollectionUtil;
import com.facebook.feedplugins.momentsupsell.abtest.ExperimentsForMomentsUpsellFeedPluginModule;
import com.facebook.feedplugins.momentsupsell.analytics.MomentsUpsellFeedPluginLogger;
import com.facebook.feedplugins.momentsupsell.prefs.MomentsUpsellPrefs;
import com.facebook.graphql.model.GraphQLActor;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.StoryActorHelper;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.moments.install.MomentsInstallInfo;
import com.facebook.photos.mediafetcher.MediaFetcherFactory;
import com.facebook.photos.mediafetcher.interfaces.MediaFetcher;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.google.common.base.Objects;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Sets;
import java.util.Set;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

@Singleton
/* compiled from: inFlight */
public class MomentsUpsellImpressionHelper {
    public static final String f20289a = MomentsUpsellImpressionHelper.class.getSimpleName();
    public static final CallerContext f20290b = CallerContext.m9061a(MomentsUpsellImpressionHelper.class, "moments_upsell");
    private static volatile MomentsUpsellImpressionHelper f20291p;
    public final Lazy<MediaFetcherFactory> f20292c;
    public final Provider<String> f20293d;
    private final QeAccessor f20294e;
    public final MomentsUpsellPrefs f20295f;
    public final MomentsUpsellFeedPluginLogger f20296g;
    private final Context f20297h;
    private final Clock f20298i;
    private final AppsInstallHelper f20299j;
    private final int f20300k;
    public MediaFetcher f20301l;
    public MediaListener f20302m;
    public Set<String> f20303n = Sets.m1325b();
    public Set<String> f20304o = Sets.m1325b();

    public static com.facebook.feedplugins.momentsupsell.MomentsUpsellImpressionHelper m27962a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f20291p;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.feedplugins.momentsupsell.MomentsUpsellImpressionHelper.class;
        monitor-enter(r1);
        r0 = f20291p;	 Catch:{ all -> 0x003a }
        if (r0 != 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000b:
        if (r5 == 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000d:
        r2 = com.facebook.inject.ScopeSet.m1499a();	 Catch:{ all -> 0x003a }
        r3 = r2.m1503b();	 Catch:{ all -> 0x003a }
        r0 = com.facebook.inject.SingletonScope.class;	 Catch:{ all -> 0x003a }
        r0 = r5.getInstance(r0);	 Catch:{ all -> 0x003a }
        r0 = (com.facebook.inject.SingletonScope) r0;	 Catch:{ all -> 0x003a }
        r4 = r0.enterScope();	 Catch:{ all -> 0x003a }
        r0 = r5.getApplicationInjector();	 Catch:{ all -> 0x0035 }
        r0 = m27964b(r0);	 Catch:{ all -> 0x0035 }
        f20291p = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f20291p;
        return r0;
    L_0x0035:
        r0 = move-exception;
        com.facebook.inject.SingletonScope.m1338a(r4);	 Catch:{ all -> 0x0035 }
        throw r0;	 Catch:{ all -> 0x0035 }
    L_0x003a:
        r0 = move-exception;
        r2.m1505c(r3);	 Catch:{ all -> 0x003a }
        throw r0;	 Catch:{ all -> 0x003a }
    L_0x003f:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x003a }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.feedplugins.momentsupsell.MomentsUpsellImpressionHelper.a(com.facebook.inject.InjectorLike):com.facebook.feedplugins.momentsupsell.MomentsUpsellImpressionHelper");
    }

    private static MomentsUpsellImpressionHelper m27964b(InjectorLike injectorLike) {
        return new MomentsUpsellImpressionHelper(IdBasedLazy.m1808a(injectorLike, 2974), IdBasedProvider.m1811a(injectorLike, 4442), QeInternalImplMethodAutoProvider.m3744a(injectorLike), MomentsUpsellPrefs.m27967b(injectorLike), MomentsUpsellFeedPluginLogger.m27970a(injectorLike), (Context) injectorLike.getInstance(Context.class), SystemClockMethodAutoProvider.m1498a(injectorLike), (AppsInstallHelperProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(AppsInstallHelperProvider.class));
    }

    @Inject
    public MomentsUpsellImpressionHelper(Lazy<MediaFetcherFactory> lazy, Provider<String> provider, QeAccessor qeAccessor, MomentsUpsellPrefs momentsUpsellPrefs, MomentsUpsellFeedPluginLogger momentsUpsellFeedPluginLogger, Context context, Clock clock, AppsInstallHelperProvider appsInstallHelperProvider) {
        this.f20292c = lazy;
        this.f20293d = provider;
        this.f20294e = qeAccessor;
        this.f20295f = momentsUpsellPrefs;
        this.f20296g = momentsUpsellFeedPluginLogger;
        this.f20297h = context;
        this.f20298i = clock;
        this.f20299j = appsInstallHelperProvider.m27972a(new MomentsInstallInfo());
        this.f20300k = this.f20294e.mo572a(ExperimentsForMomentsUpsellFeedPluginModule.f20320b, 5);
    }

    public final boolean m27966a(GraphQLStory graphQLStory) {
        boolean z = false;
        if (this.f20294e.mo596a(ExperimentsForMomentsUpsellFeedPluginModule.f20319a, false) && !this.f20299j.m27977a()) {
            if (graphQLStory.mo2507g() != null && this.f20303n.contains(graphQLStory.mo2507g())) {
                z = true;
            }
            if (z) {
                if (!(graphQLStory.mo2507g() == null || this.f20304o.contains(graphQLStory.mo2507g()))) {
                    MomentsUpsellPrefs momentsUpsellPrefs = this.f20295f;
                    momentsUpsellPrefs.f20310f.edit().mo1274a(MomentsUpsellPrefs.f20306b, momentsUpsellPrefs.m27969d() + 1).commit();
                    momentsUpsellPrefs.f20310f.edit().mo1275a(MomentsUpsellPrefs.f20307c, momentsUpsellPrefs.f20309e.mo211a()).commit();
                    this.f20304o.add(graphQLStory.mo2507g());
                    MomentsUpsellFeedPluginLogger momentsUpsellFeedPluginLogger = this.f20296g;
                    int d = momentsUpsellFeedPluginLogger.f20313b.m27969d();
                    HoneyAnalyticsEvent honeyClientEvent = new HoneyClientEvent("moments_in_feed_upsell_impression");
                    honeyClientEvent.m5083a("total_impressions", d);
                    momentsUpsellFeedPluginLogger.f20312a.mo526a(honeyClientEvent);
                }
            }
        }
        return z;
    }

    public static boolean m27963a(MomentsUpsellImpressionHelper momentsUpsellImpressionHelper, GraphQLStory graphQLStory, ImmutableList immutableList) {
        if (CollectionUtil.m29342a(graphQLStory.m22349b())) {
            graphQLStory.mo2507g();
            return false;
        }
        GraphQLActor b = StoryActorHelper.m27492b(graphQLStory) == null ? (GraphQLActor) graphQLStory.m22349b().get(0) : StoryActorHelper.m27492b(graphQLStory);
        if (b.m23790b().m22301g() != 2645995) {
            graphQLStory.mo2507g();
            return false;
        } else if (!Objects.equal(b.m23765H(), momentsUpsellImpressionHelper.f20293d.get()) || immutableList.size() > 1) {
            graphQLStory.mo2507g();
            return true;
        } else {
            graphQLStory.mo2507g();
            return false;
        }
    }

    public static boolean m27965c(MomentsUpsellImpressionHelper momentsUpsellImpressionHelper) {
        Integer.valueOf(momentsUpsellImpressionHelper.f20295f.m27969d());
        Integer.valueOf(momentsUpsellImpressionHelper.f20300k);
        if (momentsUpsellImpressionHelper.f20295f.m27969d() >= momentsUpsellImpressionHelper.f20300k || momentsUpsellImpressionHelper.f20298i.mo211a() - momentsUpsellImpressionHelper.f20295f.f20310f.mo277a(MomentsUpsellPrefs.f20307c, 0) <= 86400000) {
            return false;
        }
        return true;
    }
}
