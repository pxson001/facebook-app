package com.facebook.feed.logging;

import com.facebook.api.feed.data.FeedUnitData;
import com.facebook.api.feed.data.FeedUnitDataController;
import com.facebook.common.json.FbObjectMapper;
import com.facebook.common.json.FbObjectMapperMethodAutoProvider;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.core.props.TrackableFeedProps;
import com.facebook.feed.xconfig.VpvStrippedTrackingDataXConfigController;
import com.facebook.graphql.model.FeedTrackableUtil;
import com.facebook.graphql.model.FeedUnit;
import com.facebook.graphql.model.GraphQLStorySet;
import com.facebook.inject.InjectorLike;
import com.facebook.tools.dextr.runtime.detour.TracerDetour;
import com.facebook.xconfig.core.XConfigReader;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.google.common.base.Preconditions;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: prefetch_in_excellent_connectivity */
public class ViewportLoggingHelper {
    private static volatile ViewportLoggingHelper f9235d;
    public final FeedUnitDataController f9236a;
    private final VpvStrippedTrackingDataXConfigController f9237b;
    private final FbObjectMapper f9238c;

    public static com.facebook.feed.logging.ViewportLoggingHelper m14168a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f9235d;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.feed.logging.ViewportLoggingHelper.class;
        monitor-enter(r1);
        r0 = f9235d;	 Catch:{ all -> 0x003a }
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
        r0 = m14169b(r0);	 Catch:{ all -> 0x0035 }
        f9235d = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f9235d;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.feed.logging.ViewportLoggingHelper.a(com.facebook.inject.InjectorLike):com.facebook.feed.logging.ViewportLoggingHelper");
    }

    private static ViewportLoggingHelper m14169b(InjectorLike injectorLike) {
        return new ViewportLoggingHelper(FeedUnitDataController.m14175a(injectorLike), new VpvStrippedTrackingDataXConfigController(XConfigReader.m2681a(injectorLike)), FbObjectMapperMethodAutoProvider.m6609a(injectorLike));
    }

    @Inject
    public ViewportLoggingHelper(FeedUnitDataController feedUnitDataController, VpvStrippedTrackingDataXConfigController vpvStrippedTrackingDataXConfigController, FbObjectMapper fbObjectMapper) {
        this.f9236a = feedUnitDataController;
        this.f9237b = vpvStrippedTrackingDataXConfigController;
        this.f9238c = fbObjectMapper;
    }

    public final ArrayNode m14170a(FeedProps<? extends FeedUnit> feedProps) {
        TracerDetour.a("ViewportLoggingHandler.getStrippedTrackingData", -1473172068);
        try {
            Preconditions.checkNotNull(feedProps);
            FeedUnitData a = this.f9236a.m14177a((FeedUnit) feedProps.m19804a());
            if (a.m27204q() == null) {
                a.m27195a(FeedLoggingUtil.m14268a(TrackableFeedProps.m27452b(feedProps), this.f9237b.m14179a(), this.f9238c));
            }
            ArrayNode q = a.m27204q();
            return q;
        } finally {
            TracerDetour.a(-1893695809);
        }
    }

    public final ArrayNode m14171a(GraphQLStorySet graphQLStorySet) {
        Preconditions.checkNotNull(graphQLStorySet);
        FeedUnitData a = this.f9236a.m14178a(graphQLStorySet);
        if (a.f19510q == null) {
            a.f19510q = FeedLoggingUtil.m14268a(FeedTrackableUtil.m27154b(graphQLStorySet), this.f9237b.m14179a(), this.f9238c);
        }
        return a.f19510q;
    }

    public final boolean m14172b(FeedUnit feedUnit) {
        Preconditions.checkNotNull(feedUnit);
        return this.f9236a.m14177a(feedUnit).f19497d;
    }
}
