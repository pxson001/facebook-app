package com.facebook.events.sideshow;

import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.common.fragmentconstants.FragmentConstants.ContentFragmentType;
import com.facebook.common.uri.UriIntentMapper;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.inject.InjectorLike;
import com.facebook.katana.urimap.Fb4aUriIntentMapper;
import com.facebook.tablet.abtest.TabletExperimentConfiguration;
import com.facebook.tablet.sideshow.SideshowHost.HostInterfaceImpl;
import com.facebook.tablet.sideshow.SideshowUnit;
import com.facebook.tablet.sideshow.SideshowUnitType;
import com.google.common.util.concurrent.ListeningExecutorService;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: TYPE_INT64 */
public class EventsSideshowUnitType implements SideshowUnitType {
    private static volatile EventsSideshowUnitType f24445d;
    private EventsSideshowDataHolder f24446a;
    private UriIntentMapper f24447b;
    private TabletExperimentConfiguration f24448c;

    /* compiled from: TYPE_INT64 */
    /* synthetic */ class C29351 {
        static final /* synthetic */ int[] f24444a = new int[ContentFragmentType.values().length];

        static {
            try {
                f24444a[ContentFragmentType.NATIVE_NEWS_FEED_FRAGMENT.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f24444a[ContentFragmentType.THROWBACK_FEED_FRAGMENT.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
        }
    }

    public static com.facebook.events.sideshow.EventsSideshowUnitType m26298a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f24445d;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.events.sideshow.EventsSideshowUnitType.class;
        monitor-enter(r1);
        r0 = f24445d;	 Catch:{ all -> 0x003a }
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
        r0 = m26299b(r0);	 Catch:{ all -> 0x0035 }
        f24445d = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f24445d;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.events.sideshow.EventsSideshowUnitType.a(com.facebook.inject.InjectorLike):com.facebook.events.sideshow.EventsSideshowUnitType");
    }

    private static EventsSideshowUnitType m26299b(InjectorLike injectorLike) {
        return new EventsSideshowUnitType(new EventsSideshowDataHolder(new FetchEventsAndBirthdaysRequest(GraphQLQueryExecutor.a(injectorLike), (ListeningExecutorService) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(injectorLike))), (UriIntentMapper) Fb4aUriIntentMapper.a(injectorLike), TabletExperimentConfiguration.a(injectorLike));
    }

    @Inject
    public EventsSideshowUnitType(EventsSideshowDataHolder eventsSideshowDataHolder, UriIntentMapper uriIntentMapper, TabletExperimentConfiguration tabletExperimentConfiguration) {
        this.f24446a = eventsSideshowDataHolder;
        this.f24447b = uriIntentMapper;
        this.f24448c = tabletExperimentConfiguration;
    }

    public final SideshowUnit mo1146a(HostInterfaceImpl hostInterfaceImpl) {
        return new EventsSideshowUnit(this.f24446a, this.f24447b);
    }

    public final int mo1145a(ContentFragmentType contentFragmentType) {
        if (!this.f24448c.c() || contentFragmentType == null) {
            return 0;
        }
        switch (C29351.f24444a[contentFragmentType.ordinal()]) {
            case 1:
                return 4;
            case 2:
                return 2;
            default:
                return 0;
        }
    }
}
