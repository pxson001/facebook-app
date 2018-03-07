package com.facebook.placetips.pulsarcore.presence;

import com.facebook.common.futures.FbFutures.2;
import com.facebook.graphql.calls.GraphQlCallInput;
import com.facebook.graphql.calls.PulsarScanInputPulsarScan;
import com.facebook.graphql.calls.PulsarScanInputPulsarScan.BLEs;
import com.facebook.graphql.calls.PulsarScanInputPulsarScan.Pulsars;
import com.facebook.graphql.enums.GraphQLPulsarScanQueryResultCode;
import com.facebook.graphql.executor.GraphQLCachePolicy;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLQueryFuture;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.placetips.bootstrap.ConfidenceLevel;
import com.facebook.placetips.bootstrap.PlaceTipsLocalLogger;
import com.facebook.placetips.bootstrap.PresenceSource;
import com.facebook.placetips.bootstrap.PresenceSourceType;
import com.facebook.placetips.bootstrap.data.BleBroadcastSummary;
import com.facebook.placetips.bootstrap.data.BleScanResult;
import com.facebook.placetips.bootstrap.data.PulsarRecord;
import com.facebook.placetips.bootstrap.event.PlaceTipsPresenceEvent;
import com.facebook.placetips.logging.PlaceTipsAnalyticsEvent;
import com.facebook.placetips.logging.PlaceTipsAnalyticsLogger;
import com.facebook.placetips.logging.PlaceTipsEmptyResponseException;
import com.facebook.placetips.logging.PlaceTipsLocalLoggerImpl;
import com.facebook.placetips.presence.PagePresenceManager;
import com.facebook.placetips.presence.PagePresenceManager.PresenceUpdateBuilder;
import com.facebook.placetips.presence.PagePresenceManagerFuture;
import com.facebook.placetips.pulsarcore.PulsarPrefs;
import com.facebook.placetips.pulsarcore.PulsarPrefs.Accessor;
import com.facebook.placetips.pulsarcore.PulsarPrefs.AccessorFuture;
import com.facebook.placetips.pulsarcore.PulsarSpecificAnalyticsLogger;
import com.facebook.placetips.pulsarcore.abtest.PlaceTipsPulsarQe.Config;
import com.facebook.placetips.pulsarcore.abtest.PlaceTipsPulsarQeFuture;
import com.facebook.placetips.pulsarcore.graphql.PulsarScanQuery.SimplePulsarScanQueryString;
import com.facebook.placetips.pulsarcore.graphql.PulsarScanQueryModels.SimplePulsarScanQueryModel;
import com.facebook.placetips.pulsarcore.graphql.PulsarScanQueryModels.SimplePulsarScanQueryModel.BestGuessModel.PulsarModel.PageModel;
import com.facebook.placetips.pulsarcore.parsing.BLEBroadcastParser;
import com.facebook.placetips.pulsarcore.parsing.BLEBroadcastParser.ParsedBroadcast;
import com.facebook.placetips.pulsarcore.parsing.BLEBroadcastParserProvider;
import com.facebook.placetips.pulsarcore.parsing.FBLEBroadcast;
import com.facebook.placetips.settings.PlaceTipsSettingsPrefs;
import com.facebook.placetips.settings.graphql.GravitySettingsGraphQlFragmentModels.GravitySettingsGraphQlFragmentModel;
import com.facebook.placetips.settings.graphql.GravitySettingsUtil;
import com.facebook.reaction.ReactionUtil;
import com.facebook.reaction.protocol.graphql.FetchReactionGraphQLModels.PlaceTipsFeedUnitFragmentModel;
import com.google.common.base.Function;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.google.common.util.concurrent.AsyncFunction;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.common.util.concurrent.SettableFuture;
import java.util.List;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: TabClick */
public class DefaultBleScanProcessor {
    public final GraphQLQueryExecutor f10750a;
    public final Lazy<PagePresenceManagerFuture> f10751b;
    public final Lazy<AccessorFuture> f10752c;
    public final Lazy<PlaceTipsSettingsPrefs.AccessorFuture> f10753d;
    public final PulsarSpecificAnalyticsLogger f10754e;
    public final BLEBroadcastParserProvider f10755f;
    public final Provider<PlaceTipsPulsarQeFuture> f10756g;
    public final PlaceTipsLocalLogger f10757h;
    private final ReactionUtil f10758i;

    /* compiled from: TabClick */
    public class C12691 implements AsyncFunction<ParsedPayload, PulsarScanInputPulsarScan> {
        final /* synthetic */ DefaultBleScanProcessor f10732a;

        public C12691(DefaultBleScanProcessor defaultBleScanProcessor) {
            this.f10732a = defaultBleScanProcessor;
        }

        public final ListenableFuture m11266a(Object obj) {
            Object obj2;
            final ParsedPayload parsedPayload = (ParsedPayload) obj;
            if (parsedPayload.f10744a.isEmpty() && parsedPayload.f10745b.isEmpty()) {
                obj2 = 1;
            } else {
                obj2 = null;
            }
            if (obj2 == null) {
                this.f10732a.f10757h.a("Non-empty ParsedPayload with %d pulsars and %d BLEs", new Object[]{Integer.valueOf(parsedPayload.f10744a.size()), Integer.valueOf(parsedPayload.f10745b.size())});
                return Futures.a(parsedPayload.m11269b());
            }
            return Futures.a(Futures.a(new ListenableFuture[]{(ListenableFuture) this.f10732a.f10752c.get(), (ListenableFuture) this.f10732a.f10751b.get()}), new Function<List<Object>, PulsarScanInputPulsarScan>(this) {
                final /* synthetic */ C12691 f10731b;

                @Nullable
                public Object apply(Object obj) {
                    List list = (List) obj;
                    Accessor accessor = (Accessor) list.get(0);
                    if (!((PagePresenceManager) list.get(1)).a().isPresent() && accessor.f10673a.a(PulsarPrefs.f10678a, false)) {
                        return null;
                    }
                    this.f10731b.f10732a.f10757h.a("Creating inputParams anyway");
                    return parsedPayload.m11269b();
                }
            }, MoreExecutors.a());
        }
    }

    /* compiled from: TabClick */
    public class C12702 implements AsyncFunction<List<Object>, PlaceTipsPresenceEvent> {
        final /* synthetic */ DefaultBleScanProcessor f10733a;

        public C12702(DefaultBleScanProcessor defaultBleScanProcessor) {
            this.f10733a = defaultBleScanProcessor;
        }

        public final ListenableFuture m11267a(Object obj) {
            List list = (List) obj;
            PulsarScanInputPulsarScan pulsarScanInputPulsarScan = (PulsarScanInputPulsarScan) list.get(0);
            PagePresenceManager pagePresenceManager = (PagePresenceManager) list.get(1);
            if (pulsarScanInputPulsarScan == null) {
                this.f10733a.f10757h.a("Null input params, updating to null");
                return Futures.a(pagePresenceManager.a(PresenceSourceType.BLE));
            }
            this.f10733a.f10757h.a("Starting graphql request");
            GraphQlQueryString simplePulsarScanQueryString = new SimplePulsarScanQueryString();
            simplePulsarScanQueryString.a("ble_params", pulsarScanInputPulsarScan);
            GraphQLQueryFuture a = this.f10733a.f10750a.a(GraphQLRequest.a(simplePulsarScanQueryString).a(GraphQLCachePolicy.c));
            this.f10733a.f10754e.m11192a(pulsarScanInputPulsarScan);
            DefaultBleScanProcessor defaultBleScanProcessor = this.f10733a;
            ListenableFuture b = Futures.b(a, new C12724(defaultBleScanProcessor), MoreExecutors.a());
            Futures.a(b, new C12768(defaultBleScanProcessor), MoreExecutors.a());
            SettableFuture f = SettableFuture.f();
            Futures.a(b, new 2(f), MoreExecutors.a());
            return Futures.a(f, new C12735(defaultBleScanProcessor, pagePresenceManager), MoreExecutors.a());
        }
    }

    /* compiled from: TabClick */
    public class C12713 implements Function<Config, ParsedPayload> {
        final /* synthetic */ BleScanResult f10734a;
        final /* synthetic */ DefaultBleScanProcessor f10735b;

        public C12713(DefaultBleScanProcessor defaultBleScanProcessor, BleScanResult bleScanResult) {
            this.f10735b = defaultBleScanProcessor;
            this.f10734a = bleScanResult;
        }

        @Nullable
        public Object apply(Object obj) {
            Config config = (Config) obj;
            ParsedPayload parsedPayload = new ParsedPayload();
            BLEBroadcastParser a = this.f10735b.f10755f.m11262a(config.f10683b);
            ImmutableList immutableList = this.f10734a.a;
            int size = immutableList.size();
            for (int i = 0; i < size; i++) {
                BleBroadcastSummary bleBroadcastSummary = (BleBroadcastSummary) immutableList.get(i);
                ParsedBroadcast a2 = a.m11261a(bleBroadcastSummary.a);
                if (a2 != null) {
                    List copyOf = ImmutableList.copyOf(bleBroadcastSummary.b);
                    switch (a2.f10719a) {
                        case PULSAR:
                            DefaultBleScanProcessor.m11271a(this.f10735b, (PulsarRecord) a2.f10720b.get(), copyOf, parsedPayload);
                            break;
                        case FBLE:
                            DefaultBleScanProcessor.m11272a(this.f10735b, (FBLEBroadcast) a2.f10721c.get(), copyOf, parsedPayload);
                            break;
                        default:
                            break;
                    }
                }
            }
            return parsedPayload;
        }
    }

    /* compiled from: TabClick */
    public class C12724 implements AsyncFunction<GraphQLResult<SimplePulsarScanQueryModel>, PulsarScanResponseContainer> {
        final /* synthetic */ DefaultBleScanProcessor f10736a;

        public C12724(DefaultBleScanProcessor defaultBleScanProcessor) {
            this.f10736a = defaultBleScanProcessor;
        }

        public final ListenableFuture m11268a(@Nullable Object obj) {
            GraphQLResult graphQLResult = (GraphQLResult) obj;
            if (graphQLResult == null) {
                throw new PlaceTipsEmptyResponseException("input is null");
            } else if (graphQLResult.e == null) {
                throw new PlaceTipsEmptyResponseException("input.getResult() is null");
            } else {
                GravitySettingsGraphQlFragmentModel k = ((SimplePulsarScanQueryModel) graphQLResult.e).m11247k();
                DefaultBleScanProcessor defaultBleScanProcessor = this.f10736a;
                Futures.a((ListenableFuture) defaultBleScanProcessor.f10752c.get(), new C12746(defaultBleScanProcessor), MoreExecutors.a());
                Futures.a((ListenableFuture) defaultBleScanProcessor.f10753d.get(), new C12757(defaultBleScanProcessor, k), MoreExecutors.a());
                if (GravitySettingsUtil.a(k)) {
                    this.f10736a.f10757h.a("Got pulsar_scan result code: %s", new Object[]{((SimplePulsarScanQueryModel) graphQLResult.e).m11248l()});
                    return Futures.a(PulsarScanResponseContainer.m11270b((SimplePulsarScanQueryModel) graphQLResult.e));
                }
                throw new IllegalAccessException("Gravity no longer enabled");
            }
        }
    }

    /* compiled from: TabClick */
    public class C12735 implements Function<PulsarScanResponseContainer, PlaceTipsPresenceEvent> {
        final /* synthetic */ PagePresenceManager f10737a;
        final /* synthetic */ DefaultBleScanProcessor f10738b;

        public C12735(DefaultBleScanProcessor defaultBleScanProcessor, PagePresenceManager pagePresenceManager) {
            this.f10738b = defaultBleScanProcessor;
            this.f10737a = pagePresenceManager;
        }

        public Object apply(@Nullable Object obj) {
            PulsarScanResponseContainer pulsarScanResponseContainer = (PulsarScanResponseContainer) obj;
            if (pulsarScanResponseContainer == null) {
                return this.f10737a.a(PresenceSourceType.BLE);
            }
            this.f10738b.f10757h.a("Updating with bestGuess from server");
            PresenceUpdateBuilder a = this.f10737a.a(PresenceSource.a(pulsarScanResponseContainer.f10748c));
            a.c = pulsarScanResponseContainer.f10746a.m11228j();
            a = a;
            a.d = pulsarScanResponseContainer.f10746a.m11229k();
            a = a;
            a.g = pulsarScanResponseContainer.f10747b.k();
            a = a;
            a.h = pulsarScanResponseContainer.f10747b.j();
            a = a;
            a.p = pulsarScanResponseContainer.f10749d;
            return a.a();
        }
    }

    /* compiled from: TabClick */
    public class C12746 implements FutureCallback<Accessor> {
        final /* synthetic */ DefaultBleScanProcessor f10739a;

        public C12746(DefaultBleScanProcessor defaultBleScanProcessor) {
            this.f10739a = defaultBleScanProcessor;
        }

        public void onSuccess(Object obj) {
            ((Accessor) obj).f10673a.edit().putBoolean(PulsarPrefs.f10678a, true).commit();
        }

        public void onFailure(Throwable th) {
            throw new Error(th);
        }
    }

    /* compiled from: TabClick */
    public class C12757 implements FutureCallback<PlaceTipsSettingsPrefs.Accessor> {
        final /* synthetic */ GravitySettingsGraphQlFragmentModel f10740a;
        final /* synthetic */ DefaultBleScanProcessor f10741b;

        public C12757(DefaultBleScanProcessor defaultBleScanProcessor, GravitySettingsGraphQlFragmentModel gravitySettingsGraphQlFragmentModel) {
            this.f10741b = defaultBleScanProcessor;
            this.f10740a = gravitySettingsGraphQlFragmentModel;
        }

        public void onSuccess(Object obj) {
            ((PlaceTipsSettingsPrefs.Accessor) obj).a(this.f10740a);
        }

        public void onFailure(Throwable th) {
            throw new Error(th);
        }
    }

    /* compiled from: TabClick */
    public class C12768 implements FutureCallback<PulsarScanResponseContainer> {
        final /* synthetic */ DefaultBleScanProcessor f10742a;

        public C12768(DefaultBleScanProcessor defaultBleScanProcessor) {
            this.f10742a = defaultBleScanProcessor;
        }

        public void onSuccess(Object obj) {
            ((PlaceTipsAnalyticsLogger) this.f10742a.f10754e.f10680a.get()).a(PresenceSourceType.BLE);
        }

        public void onFailure(Throwable th) {
            PulsarSpecificAnalyticsLogger pulsarSpecificAnalyticsLogger = this.f10742a.f10754e;
            ((PlaceTipsAnalyticsLogger) pulsarSpecificAnalyticsLogger.f10680a.get()).a(PlaceTipsAnalyticsEvent.END_PAGE_LOOKUP_FAIL, PresenceSourceType.BLE, th);
        }
    }

    /* compiled from: TabClick */
    public class ParsedPayload {
        public final List<Pulsars> f10744a = Lists.b();
        public final List<BLEs> f10745b = Lists.b();

        public final PulsarScanInputPulsarScan m11269b() {
            PulsarScanInputPulsarScan pulsarScanInputPulsarScan = new PulsarScanInputPulsarScan();
            pulsarScanInputPulsarScan.a("pulsars", this.f10744a);
            GraphQlCallInput graphQlCallInput = pulsarScanInputPulsarScan;
            graphQlCallInput.a("BLEs", this.f10745b);
            return graphQlCallInput;
        }
    }

    /* compiled from: TabClick */
    class PulsarScanResponseContainer {
        public final PageModel f10746a;
        public final PlaceTipsFeedUnitFragmentModel f10747b;
        public final int f10748c;
        public final ConfidenceLevel f10749d;

        public static PulsarScanResponseContainer m11270b(SimplePulsarScanQueryModel simplePulsarScanQueryModel) {
            GraphQLPulsarScanQueryResultCode l = simplePulsarScanQueryModel.m11248l();
            if (simplePulsarScanQueryModel.m11245a() == null) {
                throw new PlaceTipsEmptyResponseException(l, "best guess is null");
            } else if (simplePulsarScanQueryModel.m11245a().m11238a() == null) {
                throw new PlaceTipsEmptyResponseException(l, "pulsar is null");
            } else {
                PageModel a = simplePulsarScanQueryModel.m11245a().m11238a().m11234a();
                if (a == null) {
                    throw new PlaceTipsEmptyResponseException(l, "page is null");
                }
                PlaceTipsFeedUnitFragmentModel l2 = a.m11230l();
                if (l2 == null) {
                    throw new PlaceTipsEmptyResponseException(l, "feed unit is null");
                } else if (l2.k() != null) {
                    return new PulsarScanResponseContainer(a, l2, simplePulsarScanQueryModel.m11245a().m11240j(), ConfidenceLevel.from(simplePulsarScanQueryModel.m11246j()));
                } else {
                    throw new PlaceTipsEmptyResponseException(l, "feed unit title is null");
                }
            }
        }

        private PulsarScanResponseContainer(PageModel pageModel, PlaceTipsFeedUnitFragmentModel placeTipsFeedUnitFragmentModel, int i, ConfidenceLevel confidenceLevel) {
            this.f10746a = pageModel;
            this.f10747b = placeTipsFeedUnitFragmentModel;
            this.f10748c = i;
            this.f10749d = confidenceLevel;
        }
    }

    public static DefaultBleScanProcessor m11273b(InjectorLike injectorLike) {
        return new DefaultBleScanProcessor(GraphQLQueryExecutor.a(injectorLike), IdBasedSingletonScopeProvider.b(injectorLike, 3010), IdBasedLazy.a(injectorLike, 9596), IdBasedLazy.a(injectorLike, 3023), PulsarSpecificAnalyticsLogger.m11190a(injectorLike), (BLEBroadcastParserProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(BLEBroadcastParserProvider.class), IdBasedProvider.a(injectorLike, 9599), (PlaceTipsLocalLogger) PlaceTipsLocalLoggerImpl.a(injectorLike), ReactionUtil.a(injectorLike));
    }

    @Inject
    public DefaultBleScanProcessor(GraphQLQueryExecutor graphQLQueryExecutor, Lazy<PagePresenceManagerFuture> lazy, Lazy<AccessorFuture> lazy2, Lazy<PlaceTipsSettingsPrefs.AccessorFuture> lazy3, PulsarSpecificAnalyticsLogger pulsarSpecificAnalyticsLogger, BLEBroadcastParserProvider bLEBroadcastParserProvider, Provider<PlaceTipsPulsarQeFuture> provider, PlaceTipsLocalLogger placeTipsLocalLogger, ReactionUtil reactionUtil) {
        this.f10750a = graphQLQueryExecutor;
        this.f10751b = lazy;
        this.f10752c = lazy2;
        this.f10753d = lazy3;
        this.f10754e = pulsarSpecificAnalyticsLogger;
        this.f10755f = bLEBroadcastParserProvider;
        this.f10756g = provider;
        this.f10757h = placeTipsLocalLogger;
        this.f10758i = reactionUtil;
    }

    static /* synthetic */ void m11271a(DefaultBleScanProcessor defaultBleScanProcessor, PulsarRecord pulsarRecord, List list, ParsedPayload parsedPayload) {
        for (Integer num : list) {
            Pulsars pulsars = new Pulsars();
            pulsars.a("uuid", pulsarRecord.a().toString());
            GraphQlCallInput graphQlCallInput = pulsars;
            graphQlCallInput.a("major", Integer.valueOf(pulsarRecord.b()));
            graphQlCallInput = graphQlCallInput;
            graphQlCallInput.a("minor", Integer.valueOf(pulsarRecord.c()));
            graphQlCallInput = graphQlCallInput;
            graphQlCallInput.a("rssi", num);
            parsedPayload.f10744a.add(graphQlCallInput);
        }
    }

    static /* synthetic */ void m11272a(DefaultBleScanProcessor defaultBleScanProcessor, FBLEBroadcast fBLEBroadcast, List list, ParsedPayload parsedPayload) {
        for (Integer num : list) {
            BLEs bLEs = new BLEs();
            bLEs.a("payload", fBLEBroadcast.f10728a);
            GraphQlCallInput graphQlCallInput = bLEs;
            graphQlCallInput.a("rssi", num);
            parsedPayload.f10745b.add(graphQlCallInput);
        }
    }
}
