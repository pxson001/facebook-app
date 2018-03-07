package com.facebook.placetips.gpscore;

import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.common.time.TimeConversions;
import com.facebook.graphql.calls.GraphQlCallInput;
import com.facebook.graphql.calls.LocationTriggerInputInput;
import com.facebook.graphql.calls.LocationTriggerInputInput.ViewerCoordinates;
import com.facebook.graphql.executor.GraphQLCachePolicy;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.location.FbLocationCache;
import com.facebook.location.ImmutableLocation;
import com.facebook.placetips.bootstrap.PlaceTipsLocalLogger;
import com.facebook.placetips.bootstrap.PresenceSourceType;
import com.facebook.placetips.common.graphql.LocationTriggerWithReactionUnitsGraphQL.LocationTriggerWithReactionUnitsString;
import com.facebook.placetips.common.graphql.LocationTriggerWithReactionUnitsGraphQLInterfaces.LocationTriggerWithReactionUnits;
import com.facebook.placetips.common.graphql.LocationTriggerWithReactionUnitsGraphQLModels.LocationTriggerWithReactionUnitsModel;
import com.facebook.placetips.gpscore.LocationTriggerFetchProcessor.C12512;
import com.facebook.placetips.gpscore.abtest.ExperimentsForPlaceTipsGpsAbTestModule;
import com.facebook.placetips.logging.PlaceTipsAnalyticsEvent;
import com.facebook.placetips.logging.PlaceTipsAnalyticsLogger;
import com.facebook.placetips.presence.PagePresenceManager;
import com.facebook.placetips.presence.PagePresenceManagerFuture;
import com.facebook.qe.api.QeAccessor;
import com.facebook.ui.futures.TasksManager;
import com.google.common.base.Optional;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.MoreExecutors;
import java.util.List;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: Time not between  */
public class PlaceTipsGpsReceiverLogic {
    private static volatile PlaceTipsGpsReceiverLogic f10615j;
    private final Lazy<PagePresenceManagerFuture> f10616a;
    private final Lazy<LocationTriggerFetchProcessor> f10617b;
    private final Lazy<FbLocationCache> f10618c;
    private final Lazy<PlaceTipsGpsSpecificAnalyticsLogger> f10619d;
    private final Lazy<PlaceTipsLocalLogger> f10620e;
    public final Lazy<PlaceTipsGpsLocationProcessor> f10621f;
    public final Lazy<TasksManager> f10622g;
    public final Lazy<QeAccessor> f10623h;
    public boolean f10624i = true;

    /* compiled from: Time not between  */
    class C12532 extends AbstractDisposableFutureCallback<List<Object>> {
        final /* synthetic */ PlaceTipsGpsReceiverLogic f10610a;

        C12532(PlaceTipsGpsReceiverLogic placeTipsGpsReceiverLogic) {
            this.f10610a = placeTipsGpsReceiverLogic;
        }

        protected final void m11095a(Object obj) {
            List list = (List) obj;
            PagePresenceManager pagePresenceManager = (PagePresenceManager) list.get(0);
            LocationTriggerWithReactionUnitsModel locationTriggerWithReactionUnitsModel = (LocationTriggerWithReactionUnitsModel) list.get(1);
            if (pagePresenceManager != null) {
                pagePresenceManager.a(PresenceSourceType.GPS, locationTriggerWithReactionUnitsModel);
            }
        }

        protected final void m11096a(Throwable th) {
        }
    }

    /* compiled from: Time not between  */
    public class C12543 extends AbstractDisposableFutureCallback<LocationTriggerWithReactionUnits> {
        final /* synthetic */ ImmutableLocation f10611a;
        final /* synthetic */ Object f10612b;
        final /* synthetic */ PagePresenceManager f10613c;
        final /* synthetic */ PlaceTipsGpsReceiverLogic f10614d;

        public C12543(PlaceTipsGpsReceiverLogic placeTipsGpsReceiverLogic, ImmutableLocation immutableLocation, Object obj, PagePresenceManager pagePresenceManager) {
            this.f10614d = placeTipsGpsReceiverLogic;
            this.f10611a = immutableLocation;
            this.f10612b = obj;
            this.f10613c = pagePresenceManager;
        }

        protected final void m11097a(Object obj) {
            ((DefaultPlaceTipsGpsLocationProcessor) this.f10614d.f10621f.get()).m11089a(this.f10611a, this.f10612b, this.f10613c, ((QeAccessor) this.f10614d.f10623h.get()).a(ExperimentsForPlaceTipsGpsAbTestModule.b, "%s"), (LocationTriggerWithReactionUnitsModel) obj);
        }

        protected final void m11098a(Throwable th) {
            ((DefaultPlaceTipsGpsLocationProcessor) this.f10614d.f10621f.get()).m11089a(this.f10611a, this.f10612b, this.f10613c, ((QeAccessor) this.f10614d.f10623h.get()).a(ExperimentsForPlaceTipsGpsAbTestModule.b, "%s"), null);
        }
    }

    /* compiled from: Time not between  */
    public enum Task {
        PROCESS_LOCATION,
        HANDLE_LOCATION_RESULT
    }

    public static com.facebook.placetips.gpscore.PlaceTipsGpsReceiverLogic m11099a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f10615j;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.placetips.gpscore.PlaceTipsGpsReceiverLogic.class;
        monitor-enter(r1);
        r0 = f10615j;	 Catch:{ all -> 0x003a }
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
        r0 = m11102b(r0);	 Catch:{ all -> 0x0035 }
        f10615j = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f10615j;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.placetips.gpscore.PlaceTipsGpsReceiverLogic.a(com.facebook.inject.InjectorLike):com.facebook.placetips.gpscore.PlaceTipsGpsReceiverLogic");
    }

    private static PlaceTipsGpsReceiverLogic m11102b(InjectorLike injectorLike) {
        return new PlaceTipsGpsReceiverLogic(IdBasedSingletonScopeProvider.b(injectorLike, 3010), IdBasedLazy.a(injectorLike, 9587), IdBasedLazy.a(injectorLike, 2478), IdBasedSingletonScopeProvider.b(injectorLike, 9591), IdBasedSingletonScopeProvider.b(injectorLike, 3008), IdBasedLazy.a(injectorLike, 9586), IdBasedLazy.a(injectorLike, 3561), IdBasedSingletonScopeProvider.b(injectorLike, 3219));
    }

    @Inject
    public PlaceTipsGpsReceiverLogic(Lazy<PagePresenceManagerFuture> lazy, Lazy<LocationTriggerFetchProcessor> lazy2, Lazy<FbLocationCache> lazy3, Lazy<PlaceTipsGpsSpecificAnalyticsLogger> lazy4, Lazy<PlaceTipsLocalLogger> lazy5, Lazy<PlaceTipsGpsLocationProcessor> lazy6, Lazy<TasksManager> lazy7, Lazy<QeAccessor> lazy8) {
        this.f10616a = lazy;
        this.f10617b = lazy2;
        this.f10618c = lazy3;
        this.f10619d = lazy4;
        this.f10620e = lazy5;
        this.f10621f = lazy6;
        this.f10622g = lazy7;
        this.f10623h = lazy8;
    }

    final void m11104b() {
        if (this.f10624i) {
            this.f10624i = false;
            ((PlaceTipsGpsSpecificAnalyticsLogger) this.f10619d.get()).m11109a(PlaceTipsAnalyticsEvent.GPS_LOCATION_CHECK_SKIPPED);
            m11103e();
        }
    }

    final void m11105c() {
        if (this.f10624i) {
            this.f10624i = false;
            ((PlaceTipsGpsSpecificAnalyticsLogger) this.f10619d.get()).m11109a(PlaceTipsAnalyticsEvent.GPS_LOCATION_CHECK_FAILED);
            m11100a(null);
        }
    }

    final void m11106d() {
        if (this.f10624i) {
            this.f10624i = false;
            ((PlaceTipsGpsSpecificAnalyticsLogger) this.f10619d.get()).m11109a(PlaceTipsAnalyticsEvent.GPS_LOCATION_REPORTED);
            m11103e();
        }
    }

    private void m11103e() {
        m11100a(((FbLocationCache) this.f10618c.get()).a(60000));
    }

    private void m11100a(@Nullable final ImmutableLocation immutableLocation) {
        if (immutableLocation == null) {
            m11101a(this, Futures.a());
            return;
        }
        ListenableFuture a;
        ((PlaceTipsLocalLogger) this.f10620e.get()).a("New Location reported: %s", new Object[]{immutableLocation});
        final PlaceTipsGpsSpecificAnalyticsLogger placeTipsGpsSpecificAnalyticsLogger = (PlaceTipsGpsSpecificAnalyticsLogger) this.f10619d.get();
        placeTipsGpsSpecificAnalyticsLogger.m11109a(PlaceTipsAnalyticsEvent.START_PAGE_LOOKUP);
        LocationTriggerFetchProcessor locationTriggerFetchProcessor = (LocationTriggerFetchProcessor) this.f10617b.get();
        if (immutableLocation == null) {
            a = Futures.a(new NullPointerException("Can't get location trigger for null location"));
        } else {
            ViewerCoordinates viewerCoordinates = new ViewerCoordinates();
            viewerCoordinates.a("latitude", Double.valueOf(immutableLocation.a()));
            GraphQlCallInput graphQlCallInput = viewerCoordinates;
            graphQlCallInput.a("longitude", Double.valueOf(immutableLocation.b()));
            GraphQlCallInput graphQlCallInput2 = graphQlCallInput;
            if (immutableLocation.c().isPresent()) {
                graphQlCallInput2.a("accuracy", Double.valueOf(((Float) immutableLocation.c().get()).doubleValue()));
            }
            Optional f = immutableLocation.f();
            if (f.isPresent()) {
                graphQlCallInput2.a("speed", Double.valueOf(((Float) f.get()).doubleValue()));
            }
            long a2 = locationTriggerFetchProcessor.f10603c.a(immutableLocation);
            if (a2 >= 0) {
                graphQlCallInput2.a("stale_time", Double.valueOf(TimeConversions.n(a2)));
            }
            LocationTriggerInputInput locationTriggerInputInput = new LocationTriggerInputInput();
            locationTriggerInputInput.a("viewer_coordinates", graphQlCallInput2);
            graphQlCallInput = locationTriggerInputInput;
            GraphQlQueryString locationTriggerWithReactionUnitsString = new LocationTriggerWithReactionUnitsString();
            locationTriggerWithReactionUnitsString.a("query_data", graphQlCallInput).a("supported_client_interfaces", (String) locationTriggerFetchProcessor.f10604d.get()).a("default_image_scale", Float.valueOf(locationTriggerFetchProcessor.f10601a.getResources().getDisplayMetrics().density));
            a = Futures.b(locationTriggerFetchProcessor.f10602b.a(GraphQLRequest.a(locationTriggerWithReactionUnitsString).a(GraphQLCachePolicy.c)), new C12512(locationTriggerFetchProcessor), MoreExecutors.a());
        }
        final ListenableFuture listenableFuture = a;
        ((TasksManager) this.f10622g.get()).a(Task.PROCESS_LOCATION, Futures.a(new ListenableFuture[]{(ListenableFuture) this.f10616a.get(), ((DefaultPlaceTipsGpsLocationProcessor) this.f10621f.get()).m11087a(immutableLocation)}), new AbstractDisposableFutureCallback<List<Object>>(this) {
            final /* synthetic */ PlaceTipsGpsReceiverLogic f10609d;

            protected final void m11093a(Object obj) {
                List list = (List) obj;
                PagePresenceManager pagePresenceManager = (PagePresenceManager) list.get(0);
                Object obj2 = list.get(1);
                PlaceTipsGpsSpecificAnalyticsLogger placeTipsGpsSpecificAnalyticsLogger = placeTipsGpsSpecificAnalyticsLogger;
                ((PlaceTipsAnalyticsLogger) placeTipsGpsSpecificAnalyticsLogger.f10626a.get()).a(((DefaultPlaceTipsGpsLocationProcessor) this.f10609d.f10621f.get()).m11088a(obj2), PresenceSourceType.GPS);
                ((PlaceTipsAnalyticsLogger) placeTipsGpsSpecificAnalyticsLogger.f10626a.get()).a(PresenceSourceType.GPS);
                PlaceTipsGpsReceiverLogic placeTipsGpsReceiverLogic = this.f10609d;
                ImmutableLocation immutableLocation = immutableLocation;
                ((TasksManager) placeTipsGpsReceiverLogic.f10622g.get()).a(Task.HANDLE_LOCATION_RESULT, listenableFuture, new C12543(placeTipsGpsReceiverLogic, immutableLocation, obj2, pagePresenceManager));
            }

            protected final void m11094a(Throwable th) {
                PlaceTipsGpsSpecificAnalyticsLogger placeTipsGpsSpecificAnalyticsLogger = placeTipsGpsSpecificAnalyticsLogger;
                ((PlaceTipsAnalyticsLogger) placeTipsGpsSpecificAnalyticsLogger.f10626a.get()).a(PlaceTipsAnalyticsEvent.END_PAGE_LOOKUP_FAIL, PresenceSourceType.GPS, th);
                PlaceTipsGpsReceiverLogic.m11101a(this.f10609d, listenableFuture);
            }
        });
    }

    public static void m11101a(PlaceTipsGpsReceiverLogic placeTipsGpsReceiverLogic, ListenableFuture listenableFuture) {
        ((TasksManager) placeTipsGpsReceiverLogic.f10622g.get()).a(Task.PROCESS_LOCATION, Futures.b(new ListenableFuture[]{(ListenableFuture) placeTipsGpsReceiverLogic.f10616a.get(), listenableFuture}), new C12532(placeTipsGpsReceiverLogic));
    }
}
