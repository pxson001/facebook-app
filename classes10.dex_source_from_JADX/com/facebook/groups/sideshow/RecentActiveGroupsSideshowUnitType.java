package com.facebook.groups.sideshow;

import com.facebook.common.fragmentconstants.FragmentConstants.ContentFragmentType;
import com.facebook.common.uri.FbUriIntentHandler;
import com.facebook.groups.sideshow.graphql.FetchRecentActiveGroupsRequest;
import com.facebook.groups.sideshow.ui.RecentActiveGroupsListAdapter;
import com.facebook.inject.InjectorLike;
import com.facebook.tablet.abtest.TabletExperimentConfiguration;
import com.facebook.tablet.sideshow.SideshowHost.HostInterfaceImpl;
import com.facebook.tablet.sideshow.SideshowUnit;
import com.facebook.tablet.sideshow.SideshowUnitType;
import com.facebook.tablet.sideshow.analytics.SideshowAnalyticsLogger;
import com.facebook.tablet.sideshow.widget.SideshowUtils;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: windows-1251 */
public class RecentActiveGroupsSideshowUnitType implements SideshowUnitType {
    private static volatile RecentActiveGroupsSideshowUnitType f317g;
    private RecentActiveGroupsListAdapter f318a;
    private FetchRecentActiveGroupsRequest f319b;
    private FbUriIntentHandler f320c;
    private TabletExperimentConfiguration f321d;
    private SideshowAnalyticsLogger f322e;
    private SideshowUtils f323f;

    /* compiled from: windows-1251 */
    /* synthetic */ class C00581 {
        static final /* synthetic */ int[] f316a = new int[ContentFragmentType.values().length];

        static {
            try {
                f316a[ContentFragmentType.NATIVE_NEWS_FEED_FRAGMENT.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f316a[ContentFragmentType.GROUP_ALBUM_FRAGMENT.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
        }
    }

    public static com.facebook.groups.sideshow.RecentActiveGroupsSideshowUnitType m410a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f317g;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.groups.sideshow.RecentActiveGroupsSideshowUnitType.class;
        monitor-enter(r1);
        r0 = f317g;	 Catch:{ all -> 0x003a }
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
        r0 = m411b(r0);	 Catch:{ all -> 0x0035 }
        f317g = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f317g;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.sideshow.RecentActiveGroupsSideshowUnitType.a(com.facebook.inject.InjectorLike):com.facebook.groups.sideshow.RecentActiveGroupsSideshowUnitType");
    }

    private static RecentActiveGroupsSideshowUnitType m411b(InjectorLike injectorLike) {
        return new RecentActiveGroupsSideshowUnitType(RecentActiveGroupsListAdapter.m480b(injectorLike), FetchRecentActiveGroupsRequest.m473a(injectorLike), FbUriIntentHandler.a(injectorLike), TabletExperimentConfiguration.a(injectorLike), SideshowAnalyticsLogger.m10181a(injectorLike), SideshowUtils.m10211b(injectorLike));
    }

    @Inject
    public RecentActiveGroupsSideshowUnitType(RecentActiveGroupsListAdapter recentActiveGroupsListAdapter, FetchRecentActiveGroupsRequest fetchRecentActiveGroupsRequest, FbUriIntentHandler fbUriIntentHandler, TabletExperimentConfiguration tabletExperimentConfiguration, SideshowAnalyticsLogger sideshowAnalyticsLogger, SideshowUtils sideshowUtils) {
        this.f318a = recentActiveGroupsListAdapter;
        this.f319b = fetchRecentActiveGroupsRequest;
        this.f320c = fbUriIntentHandler;
        this.f321d = tabletExperimentConfiguration;
        this.f322e = sideshowAnalyticsLogger;
        this.f323f = sideshowUtils;
    }

    public final SideshowUnit m413a(HostInterfaceImpl hostInterfaceImpl) {
        return new RecentActiveGroupsSideshowUnit(this.f318a, this.f319b, this.f320c, this.f322e, this.f323f);
    }

    public final int m412a(ContentFragmentType contentFragmentType) {
        if (!this.f321d.c() || contentFragmentType == null) {
            return 0;
        }
        switch (C00581.f316a[contentFragmentType.ordinal()]) {
            case 1:
                return 4;
            case 2:
                return 3;
            default:
                return 0;
        }
    }
}
