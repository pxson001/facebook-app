package com.facebook.nearby.server;

import android.graphics.RectF;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.errorreporting.SoftError;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.fbservice.results.DataFreshnessResult;
import com.facebook.fbservice.service.BlueServiceHandler;
import com.facebook.fbservice.service.ErrorCode;
import com.facebook.fbservice.service.OperationParams;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.graphql.model.GraphQLGeoRectangle;
import com.facebook.graphql.model.GraphQLHelper;
import com.facebook.graphql.protocol.GraphQLProtocolHelper;
import com.facebook.http.protocol.ApiMethodRunner.Batch;
import com.facebook.http.protocol.ApiMethodRunnerImpl;
import com.facebook.http.protocol.BatchOperation;
import com.facebook.inject.InjectorLike;
import com.facebook.nearby.analytics.NearbyBrowseAnalytics;
import com.facebook.nearby.data.TilesHelper;
import com.facebook.nearby.data.cache.TilesCache;
import com.facebook.nearby.data.db.NearbyDbTilesResult;
import com.facebook.nearby.data.db.TilesDb;
import com.facebook.nearby.model.MapTile;
import com.facebook.nearby.model.TilesCacheRecord;
import com.facebook.nearby.protocol.FetchNearbyPlacesLayoutMethod;
import com.facebook.nearby.protocol.FetchNearbyPlacesLayoutResult;
import com.facebook.nearby.protocol.FetchNearbyTypeaheadPlacesLayoutMethod;
import com.facebook.nearby.protocol.NearbyTilesMethod;
import com.facebook.nearby.protocol.NearbyTilesParams;
import com.facebook.nearby.protocol.NearbyTilesResult;
import com.facebook.nearby.protocol.NearbyTilesWithLayoutsParams;
import com.facebook.nearby.protocol.NearbyTilesWithLayoutsResult;
import com.facebook.nearby.protocol.NearbyTypeaheadWithLayoutsParams;
import com.facebook.nearby.protocol.NearbyTypeaheadWithLayoutsResult;
import com.facebook.nearby.protocol.SearchNearbyPlacesMethod;
import com.facebook.nearby.protocol.SearchNearbyPlacesResult;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: topProgress */
public class NearbyServiceHandler implements BlueServiceHandler {
    private static volatile NearbyServiceHandler f766m;
    private final ApiMethodRunnerImpl f767a;
    private final SearchNearbyPlacesMethod f768b;
    private final NearbyTilesMethod f769c;
    private final FetchNearbyPlacesLayoutMethod f770d;
    private final FetchNearbyTypeaheadPlacesLayoutMethod f771e;
    private final TilesCache f772f;
    private final TilesDb f773g;
    private final TilesHelper f774h = new TilesHelper(this.f775i);
    private final Clock f775i;
    private final AbstractFbErrorReporter f776j;
    private final NearbyBrowseAnalytics f777k;
    public volatile GraphQLGeoRectangle f778l;

    public static com.facebook.nearby.server.NearbyServiceHandler m1057a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f766m;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.nearby.server.NearbyServiceHandler.class;
        monitor-enter(r1);
        r0 = f766m;	 Catch:{ all -> 0x003a }
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
        r0 = m1060b(r0);	 Catch:{ all -> 0x0035 }
        f766m = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f766m;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.nearby.server.NearbyServiceHandler.a(com.facebook.inject.InjectorLike):com.facebook.nearby.server.NearbyServiceHandler");
    }

    private static NearbyServiceHandler m1060b(InjectorLike injectorLike) {
        return new NearbyServiceHandler(ApiMethodRunnerImpl.a(injectorLike), SearchNearbyPlacesMethod.m1012b(injectorLike), new NearbyTilesMethod((Clock) SystemClockMethodAutoProvider.a(injectorLike), ResourcesMethodAutoProvider.a(injectorLike), GraphQLProtocolHelper.a(injectorLike)), FetchNearbyPlacesLayoutMethod.m645b(injectorLike), FetchNearbyTypeaheadPlacesLayoutMethod.m648b(injectorLike), TilesCache.m417a(injectorLike), TilesDb.m430a(injectorLike), (Clock) SystemClockMethodAutoProvider.a(injectorLike), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike), NearbyBrowseAnalytics.m376b(injectorLike));
    }

    public final OperationResult m1062a(OperationParams operationParams) {
        String str = operationParams.b;
        if ("search_nearby_places_and_layout".equals(str)) {
            return m1061c(operationParams);
        }
        if ("fetch_layout_and_tiles".equals(str)) {
            return m1059b(operationParams);
        }
        throw new Exception("unknown operation type: " + str);
    }

    @Inject
    public NearbyServiceHandler(ApiMethodRunnerImpl apiMethodRunnerImpl, SearchNearbyPlacesMethod searchNearbyPlacesMethod, NearbyTilesMethod nearbyTilesMethod, FetchNearbyPlacesLayoutMethod fetchNearbyPlacesLayoutMethod, FetchNearbyTypeaheadPlacesLayoutMethod fetchNearbyTypeaheadPlacesLayoutMethod, TilesCache tilesCache, TilesDb tilesDb, Clock clock, AbstractFbErrorReporter abstractFbErrorReporter, NearbyBrowseAnalytics nearbyBrowseAnalytics) {
        this.f767a = apiMethodRunnerImpl;
        this.f768b = searchNearbyPlacesMethod;
        this.f769c = nearbyTilesMethod;
        this.f770d = fetchNearbyPlacesLayoutMethod;
        this.f771e = fetchNearbyTypeaheadPlacesLayoutMethod;
        this.f772f = tilesCache;
        this.f773g = tilesDb;
        this.f775i = clock;
        this.f776j = abstractFbErrorReporter;
        this.f777k = nearbyBrowseAnalytics;
    }

    private OperationResult m1059b(OperationParams operationParams) {
        Batch a = this.f767a.a();
        NearbyTilesWithLayoutsParams nearbyTilesWithLayoutsParams = (NearbyTilesWithLayoutsParams) operationParams.b().getParcelable("fetchLayoutAndTilesParams");
        NearbyTilesParams nearbyTilesParams = nearbyTilesWithLayoutsParams.f642a;
        GraphQLGeoRectangle a2 = nearbyTilesParams.m885a();
        if (a2 != null) {
            if (!GraphQLHelper.a(a2, this.f778l)) {
                return OperationResult.a(ErrorCode.NO_ERROR);
            }
        }
        if (this.f772f.m423a()) {
            m1058a();
            if (a2 != null) {
                RectF rectF = new RectF((float) a2.l(), (float) a2.j(), (float) a2.a(), (float) a2.k());
                ImmutableSet copyOf = ImmutableSet.copyOf(nearbyTilesParams.m887j());
                ImmutableSet copyOf2 = ImmutableSet.copyOf(nearbyTilesParams.m888k());
                List a3 = this.f772f.m421a((double) nearbyTilesParams.m886b(), copyOf2, copyOf, rectF);
                if (this.f774h.m415a(rectF, a3) >= 0.97d) {
                    return OperationResult.a(new NearbyTilesWithLayoutsResult(DataFreshnessResult.FROM_CACHE_UP_TO_DATE, this.f775i.a(), a3, this.f772f.m424b(), copyOf2, copyOf, a2, nearbyTilesParams));
                }
            }
        }
        this.f777k.m386a(nearbyTilesParams.m887j(), nearbyTilesParams.m885a(), nearbyTilesParams.m886b());
        a.a(BatchOperation.a(this.f769c, nearbyTilesParams).a("nearby_tiles").a());
        a.a(BatchOperation.a(this.f770d, nearbyTilesWithLayoutsParams.f643b).a("layout_places").a());
        try {
            a.a("fetchLayoutAndTilesRequest", CallerContext.a(getClass()));
        } catch (Exception e) {
            this.f776j.a(SoftError.a("FETCH_LAYOUT_AND_TILES_REQUEST", e.getMessage()).a(false).g());
        }
        NearbyTilesResult nearbyTilesResult = (NearbyTilesResult) a.a("nearby_tiles");
        Exception b = a.b("nearby_tiles");
        if (b != null) {
            throw b;
        } else if (nearbyTilesResult == null) {
            return OperationResult.a(ErrorCode.OTHER);
        } else {
            if (nearbyTilesResult.m893h().m885a() == null && nearbyTilesResult.m892g() == null) {
                return OperationResult.a(ErrorCode.OTHER);
            }
            NearbyTilesWithLayoutsResult nearbyTilesWithLayoutsResult = new NearbyTilesWithLayoutsResult(nearbyTilesResult, (FetchNearbyPlacesLayoutResult) a.a("layout_places"));
            this.f772f.m422a(nearbyTilesResult.m890e(), nearbyTilesResult.m891f(), nearbyTilesWithLayoutsResult.m896c(), nearbyTilesResult.m889d(), this.f775i.a());
            this.f773g.m436a(nearbyTilesWithLayoutsResult);
            return OperationResult.a(nearbyTilesWithLayoutsResult);
        }
    }

    private OperationResult m1061c(OperationParams operationParams) {
        Batch a = this.f767a.a();
        NearbyTypeaheadWithLayoutsParams nearbyTypeaheadWithLayoutsParams = (NearbyTypeaheadWithLayoutsParams) operationParams.b().getParcelable("searchNearbyPlacesAndLayoutsParams");
        a.a(BatchOperation.a(this.f768b, nearbyTypeaheadWithLayoutsParams.f651a).a("search_places").a());
        a.a(BatchOperation.a(this.f771e, nearbyTypeaheadWithLayoutsParams.f652b).a("layout_places").a());
        try {
            a.a("searchPlacesAndLayoutsRequest", CallerContext.a(getClass()));
        } catch (Exception e) {
            this.f776j.a(SoftError.a("SEARCH_NEARBY_PLACES_AND_LAYOUT", e.getMessage()).a(false).g());
        }
        SearchNearbyPlacesResult searchNearbyPlacesResult = (SearchNearbyPlacesResult) a.a("search_places");
        Exception b = a.b("search_places");
        if (b != null) {
            throw b;
        } else if (searchNearbyPlacesResult == null) {
            return OperationResult.a(ErrorCode.OTHER);
        } else {
            return OperationResult.a(new NearbyTypeaheadWithLayoutsResult(searchNearbyPlacesResult, (FetchNearbyPlacesLayoutResult) a.a("layout_places")));
        }
    }

    private void m1058a() {
        NearbyDbTilesResult c = this.f773g.m438c();
        for (TilesCacheRecord tilesCacheRecord : c.f333b) {
            this.f772f.m422a(tilesCacheRecord.f394c, tilesCacheRecord.f395d, Lists.a(new MapTile[]{tilesCacheRecord.f392a}), c.f332a, tilesCacheRecord.f393b);
        }
    }
}
