package com.facebook.messaging.inbox2.data.unitstore;

import android.database.sqlite.SQLiteDatabase;
import android.net.NetworkInfo;
import com.facebook.auth.userscope.UserScoped;
import com.facebook.common.executors.DefaultSerialListeningExecutorService;
import com.facebook.common.executors.DefaultSerialListeningExecutorService_DefaultExecutorServiceMethodAutoProvider;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.debug.tracer.Tracer;
import com.facebook.fbservice.results.DataFreshnessResult;
import com.facebook.fbservice.service.DataFreshnessParam;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.calls.GraphQlCallInput;
import com.facebook.graphql.calls.MessengerInboxItemRecordActionInputData;
import com.facebook.graphql.calls.MessengerInboxUnitRecordActionInputData;
import com.facebook.graphql.calls.MessengerInboxUnitRecordActionInputData.ActionType;
import com.facebook.graphql.enums.GraphQLMessengerInboxUnitType;
import com.facebook.graphql.enums.GraphQLMessengerInboxUnitUpdateStatus;
import com.facebook.graphql.executor.GraphQLCachePolicy;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.executor.cache.ConsistencyCacheFactoryImpl;
import com.facebook.graphql.executor.cachekey.KeyFactory;
import com.facebook.graphql.executor.iface.ConsistencyMemoryCache;
import com.facebook.graphql.executor.request.MutationRequest;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.inbox2.data.common.InboxUnitFetcher;
import com.facebook.messaging.inbox2.data.common.InboxUnitFetcherException;
import com.facebook.messaging.inbox2.data.common.InboxUnitFetcherHelper;
import com.facebook.messaging.inbox2.data.common.InboxUnitParams;
import com.facebook.messaging.inbox2.data.common.InboxUnitResult;
import com.facebook.messaging.inbox2.data.common.InboxUnitSnapshot;
import com.facebook.messaging.inbox2.data.common.InboxUnitsToFetch;
import com.facebook.messaging.inbox2.data.graphql.InboxUnitGraphQLQueryExecutorHelper;
import com.facebook.messaging.inbox2.data.loader.InboxUnitManager;
import com.facebook.messaging.inbox2.data.loader.InboxUnitManager.C04551;
import com.facebook.messaging.inbox2.data.unitstore.InboxUnitStoreReaderWriter.UnitWithPosition;
import com.facebook.messaging.inbox2.graphql.InboxV2Mutations.MessengerInbox2UnitActionMutationString;
import com.facebook.messaging.inbox2.graphql.InboxV2Mutations.MessengerInboxItemActionMutationString;
import com.facebook.messaging.inbox2.graphql.InboxV2MutationsModels.MessengerInbox2UnitActionMutationModel;
import com.facebook.messaging.inbox2.graphql.InboxV2MutationsModels.MessengerInbox2UnitActionMutationModel.MessengerInboxUnitModel;
import com.facebook.messaging.inbox2.graphql.InboxV2MutationsModels.MessengerInboxItemActionMutationModel;
import com.facebook.messaging.inbox2.graphql.InboxV2MutationsModels.MessengerInboxItemActionMutationModel.MessengerInboxItemModel;
import com.facebook.messaging.inbox2.graphql.InboxV2Query.InboxV2QueryString;
import com.facebook.messaging.inbox2.graphql.InboxV2QueryModels.InboxV2QueryModel;
import com.facebook.messaging.inbox2.graphql.InboxV2QueryModels.InboxV2QueryModel.Builder;
import com.facebook.messaging.inbox2.graphql.InboxV2QueryModels.InboxV2QueryModel.MessengerInboxUnitsModel;
import com.facebook.messaging.inbox2.graphql.InboxV2QueryModels.InboxV2QueryModel.MessengerInboxUnitsModel.NodesModel;
import com.facebook.messaging.inbox2.graphql.InboxV2QueryModels.InboxV2QueryModel.MessengerInboxUnitsModel.NodesModel.MessengerInboxUnitItemsModel;
import com.facebook.messaging.inbox2.items.InboxUnitItem;
import com.facebook.messaging.prefs.MessagingPrefKeys;
import com.facebook.offlinemode.common.OfflineQueryBehavior;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.tools.dextr.runtime.detour.SQLiteDetour;
import com.facebook.tools.dextr.runtime.detour.TracerDetour;
import com.facebook.ultralight.Inject;
import com.facebook.ultralight.Lazy;
import com.facebook.ultralight.UltralightRuntime;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.MapMaker;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.FuturesGetChecked;
import com.google.common.util.concurrent.ListenableFuture;
import java.nio.ByteBuffer;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentMap;
import javax.annotation.Nullable;

@UserScoped
/* compiled from: server */
public class InboxUnitFetcherWithUnitStore implements InboxUnitFetcher {
    @VisibleForTesting
    static UnitStorePropertyKey f2813a = new UnitStorePropertyKey("last_successful_fetch_ms");
    static UnitStorePropertyKey f2814b = new UnitStorePropertyKey("last_full_successful_fetch_ms");
    @VisibleForTesting
    static UnitStorePropertyKey f2815c = new UnitStorePropertyKey("last_successful_cache_key");
    public static final Class<?> f2816d = InboxUnitFetcherWithUnitStore.class;
    private static final Object f2817q = new Object();
    private final GraphQLQueryExecutor f2818e;
    private final InboxUnitStoreReaderWriter f2819f;
    private final UnitStoreDatabaseSupplier f2820g;
    private final UnitStoreDbPropertyUtil f2821h;
    private final DefaultSerialListeningExecutorService f2822i;
    private final ConsistencyCacheFactoryImpl f2823j;
    private final FbSharedPreferences f2824k;
    private final KeyFactory f2825l;
    private final Clock f2826m;
    public final ConcurrentMap<InboxUnitResultWithGraphQL, Boolean> f2827n;
    @Inject
    @Lazy
    public com.facebook.inject.Lazy<InboxUnitGraphQLQueryExecutorHelper> f2828o = UltralightRuntime.b;
    @Inject
    @Lazy
    public com.facebook.inject.Lazy<InboxUnitFetcherHelper> f2829p = UltralightRuntime.b;

    /* compiled from: server */
    class C04623 implements FutureCallback<Object> {
        final /* synthetic */ InboxUnitFetcherWithUnitStore f2804a;

        public void onFailure(Throwable th) {
            Class cls = InboxUnitFetcherWithUnitStore.f2816d;
        }

        public void onSuccess(@Nullable Object obj) {
            Class cls = InboxUnitFetcherWithUnitStore.f2816d;
        }

        C04623(InboxUnitFetcherWithUnitStore inboxUnitFetcherWithUnitStore) {
            this.f2804a = inboxUnitFetcherWithUnitStore;
        }
    }

    /* compiled from: server */
    /* synthetic */ class C04634 {
        static final /* synthetic */ int[] f2807c = new int[GraphQLMessengerInboxUnitUpdateStatus.values().length];

        static {
            try {
                f2807c[GraphQLMessengerInboxUnitUpdateStatus.ALL_UPDATE.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f2807c[GraphQLMessengerInboxUnitUpdateStatus.NO_UPDATE.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            f2806b = new int[InboxUnitsToFetch.values().length];
            try {
                f2806b[InboxUnitsToFetch.TOP.ordinal()] = 1;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f2806b[InboxUnitsToFetch.ALL.ordinal()] = 2;
            } catch (NoSuchFieldError e4) {
            }
            f2805a = new int[DbStaleness.values().length];
            try {
                f2805a[DbStaleness.NO_DATA.ordinal()] = 1;
            } catch (NoSuchFieldError e5) {
            }
            try {
                f2805a[DbStaleness.STALE_DATA_NEEDS_FULL_SERVER_FETCH.ordinal()] = 2;
            } catch (NoSuchFieldError e6) {
            }
            try {
                f2805a[DbStaleness.STALE_DATA_NEEDS_INCREMENTAL_SERVER_FETCH.ordinal()] = 3;
            } catch (NoSuchFieldError e7) {
            }
            try {
                f2805a[DbStaleness.UP_TO_DATE.ordinal()] = 4;
            } catch (NoSuchFieldError e8) {
            }
        }
    }

    @VisibleForTesting
    /* compiled from: server */
    enum DbStaleness {
        NO_DATA,
        STALE_DATA_NEEDS_FULL_SERVER_FETCH,
        STALE_DATA_NEEDS_INCREMENTAL_SERVER_FETCH,
        UP_TO_DATE
    }

    /* compiled from: server */
    public class InboxUnitResultWithGraphQL implements InboxUnitResult {
        final /* synthetic */ InboxUnitFetcherWithUnitStore f2808a;
        private final InboxUnitSnapshot f2809b;
        public C04551 f2810c;

        public InboxUnitResultWithGraphQL(InboxUnitFetcherWithUnitStore inboxUnitFetcherWithUnitStore, InboxUnitSnapshot inboxUnitSnapshot) {
            this.f2808a = inboxUnitFetcherWithUnitStore;
            this.f2809b = inboxUnitSnapshot;
        }

        public final InboxUnitSnapshot mo75a() {
            return this.f2809b;
        }

        public final void mo76a(C04551 c04551) {
            this.f2810c = c04551;
            if (this.f2810c != null) {
                this.f2808a.f2827n.put(this, Boolean.valueOf(true));
            } else {
                this.f2808a.f2827n.remove(this);
            }
        }
    }

    /* compiled from: server */
    class IncrementalWriteResult {
        final ImmutableList<NodesModel> f2811a;
        final boolean f2812b;

        public IncrementalWriteResult(ImmutableList<NodesModel> immutableList, boolean z) {
            this.f2811a = immutableList;
            this.f2812b = z;
        }
    }

    private static InboxUnitFetcherWithUnitStore m2766b(InjectorLike injectorLike) {
        InboxUnitFetcherWithUnitStore inboxUnitFetcherWithUnitStore = new InboxUnitFetcherWithUnitStore(GraphQLQueryExecutor.a(injectorLike), new InboxUnitStoreReaderWriter(UnitStoreDatabaseSupplier.m2785a(injectorLike)), UnitStoreDatabaseSupplier.m2785a(injectorLike), new UnitStoreDbPropertyUtil(UnitStoreDatabaseSupplier.m2785a(injectorLike)), DefaultSerialListeningExecutorService_DefaultExecutorServiceMethodAutoProvider.b(injectorLike), ConsistencyCacheFactoryImpl.b(injectorLike), (FbSharedPreferences) FbSharedPreferencesImpl.a(injectorLike), KeyFactory.b(injectorLike), (Clock) SystemClockMethodAutoProvider.a(injectorLike));
        com.facebook.inject.Lazy a = IdBasedLazy.a(injectorLike, 7879);
        com.facebook.inject.Lazy a2 = IdBasedLazy.a(injectorLike, 7878);
        inboxUnitFetcherWithUnitStore.f2828o = a;
        inboxUnitFetcherWithUnitStore.f2829p = a2;
        return inboxUnitFetcherWithUnitStore;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.facebook.messaging.inbox2.data.unitstore.InboxUnitFetcherWithUnitStore m2760a(com.facebook.inject.InjectorLike r7) {
        /*
        r2 = com.facebook.inject.ScopeSet.a();
        r0 = com.facebook.auth.userscope.UserScope.class;
        r0 = r7.getInstance(r0);
        r0 = (com.facebook.auth.userscope.UserScope) r0;
        r1 = r7.getScopeAwareInjector();
        r1 = r1.b();
        if (r1 != 0) goto L_0x001e;
    L_0x0016:
        r0 = new com.facebook.inject.ProvisioningException;
        r1 = "Called user scoped provider outside of context scope";
        r0.<init>(r1);
        throw r0;
    L_0x001e:
        r3 = r0.a(r1);
        r4 = r3.b();	 Catch:{ all -> 0x006c }
        r1 = f2817q;	 Catch:{ all -> 0x006c }
        r1 = r4.get(r1);	 Catch:{ all -> 0x006c }
        r5 = com.facebook.auth.userscope.UserScope.a;	 Catch:{ all -> 0x006c }
        if (r1 != r5) goto L_0x0035;
    L_0x0030:
        r3.c();
        r0 = 0;
    L_0x0034:
        return r0;
    L_0x0035:
        if (r1 != 0) goto L_0x007c;
    L_0x0037:
        r1 = 4;
        r5 = r2.b(r1);	 Catch:{  }
        r6 = r0.a(r3);	 Catch:{ all -> 0x0067 }
        r0 = r6.e();	 Catch:{ all -> 0x0062 }
        r1 = m2766b(r0);	 Catch:{ all -> 0x0062 }
        com.facebook.auth.userscope.UserScope.a(r6);	 Catch:{  }
        if (r1 != 0) goto L_0x0071;
    L_0x004d:
        r0 = f2817q;	 Catch:{  }
        r6 = com.facebook.auth.userscope.UserScope.a;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r6);	 Catch:{  }
        r0 = (com.facebook.messaging.inbox2.data.unitstore.InboxUnitFetcherWithUnitStore) r0;	 Catch:{  }
    L_0x0057:
        if (r0 == 0) goto L_0x007a;
    L_0x0059:
        r2.c(r5);	 Catch:{  }
    L_0x005c:
        r0 = (com.facebook.messaging.inbox2.data.unitstore.InboxUnitFetcherWithUnitStore) r0;	 Catch:{  }
        r3.c();
        goto L_0x0034;
    L_0x0062:
        r0 = move-exception;
        com.facebook.auth.userscope.UserScope.a(r6);	 Catch:{  }
        throw r0;	 Catch:{  }
    L_0x0067:
        r0 = move-exception;
        r2.c(r5);	 Catch:{  }
        throw r0;	 Catch:{  }
    L_0x006c:
        r0 = move-exception;
        r3.c();
        throw r0;
    L_0x0071:
        r0 = f2817q;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r1);	 Catch:{  }
        r0 = (com.facebook.messaging.inbox2.data.unitstore.InboxUnitFetcherWithUnitStore) r0;	 Catch:{  }
        goto L_0x0057;
    L_0x007a:
        r0 = r1;
        goto L_0x0059;
    L_0x007c:
        r0 = r1;
        goto L_0x005c;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.inbox2.data.unitstore.InboxUnitFetcherWithUnitStore.a(com.facebook.inject.InjectorLike):com.facebook.messaging.inbox2.data.unitstore.InboxUnitFetcherWithUnitStore");
    }

    private void m2764a(final NodesModel nodesModel, MutationRequest<?> mutationRequest) {
        final GraphQLVisitableModel graphQLVisitableModel = mutationRequest.c;
        this.f2822i.a(new Runnable(this) {
            final /* synthetic */ InboxUnitFetcherWithUnitStore f2803c;

            public void run() {
                InboxUnitFetcherWithUnitStore.m2763a(this.f2803c, nodesModel, graphQLVisitableModel);
            }
        });
        Futures.a(this.f2818e.a(mutationRequest, OfflineQueryBehavior.c), new C04623(this));
    }

    @Inject
    private InboxUnitFetcherWithUnitStore(GraphQLQueryExecutor graphQLQueryExecutor, InboxUnitStoreReaderWriter inboxUnitStoreReaderWriter, UnitStoreDatabaseSupplier unitStoreDatabaseSupplier, UnitStoreDbPropertyUtil unitStoreDbPropertyUtil, DefaultSerialListeningExecutorService defaultSerialListeningExecutorService, ConsistencyCacheFactoryImpl consistencyCacheFactoryImpl, FbSharedPreferences fbSharedPreferences, KeyFactory keyFactory, Clock clock) {
        this.f2818e = graphQLQueryExecutor;
        this.f2819f = inboxUnitStoreReaderWriter;
        this.f2820g = unitStoreDatabaseSupplier;
        this.f2821h = unitStoreDbPropertyUtil;
        this.f2822i = defaultSerialListeningExecutorService;
        this.f2823j = consistencyCacheFactoryImpl;
        this.f2824k = fbSharedPreferences;
        this.f2825l = keyFactory;
        this.f2826m = clock;
        this.f2827n = new MapMaker().e().l();
    }

    public final EnumSet<InboxUnitsToFetch> mo78a() {
        return EnumSet.of(InboxUnitsToFetch.ALL, InboxUnitsToFetch.TOP);
    }

    public final boolean mo81b() {
        return this.f2824k.a(MessagingPrefKeys.aU, false);
    }

    public final ListenableFuture<InboxUnitResult> mo77a(final InboxUnitParams inboxUnitParams) {
        Preconditions.checkArgument(mo78a().contains(inboxUnitParams.f2753b));
        boolean z = inboxUnitParams.f2753b == InboxUnitsToFetch.ALL || inboxUnitParams.f2752a == DataFreshnessParam.DO_NOT_CHECK_SERVER;
        Preconditions.checkArgument(z);
        return this.f2822i.a(new Callable<InboxUnitResult>(this) {
            final /* synthetic */ InboxUnitFetcherWithUnitStore f2800b;

            public Object call() {
                Class cls = InboxUnitFetcherWithUnitStore.f2816d;
                InboxUnitResult b = InboxUnitFetcherWithUnitStore.m2765b(this.f2800b, inboxUnitParams);
                cls = InboxUnitFetcherWithUnitStore.f2816d;
                return b;
            }
        });
    }

    public static InboxUnitResult m2765b(InboxUnitFetcherWithUnitStore inboxUnitFetcherWithUnitStore, InboxUnitParams inboxUnitParams) {
        boolean z = true;
        TracerDetour.a("InboxUnitFetcherWithUnitStore.fetchInternal(%s, %s)", new Object[]{inboxUnitParams.f2752a, inboxUnitParams.f2753b}, -783271655);
        try {
            InboxUnitResult d;
            DbStaleness h = inboxUnitFetcherWithUnitStore.m2771h();
            if (inboxUnitParams.f2752a == DataFreshnessParam.CHECK_SERVER_FOR_NEW_DATA) {
                d = inboxUnitFetcherWithUnitStore.m2767d();
            } else if (inboxUnitParams.f2752a != DataFreshnessParam.STALE_DATA_OKAY && inboxUnitParams.f2752a != DataFreshnessParam.DO_NOT_CHECK_SERVER) {
                if (inboxUnitParams.f2753b != InboxUnitsToFetch.ALL) {
                    z = false;
                }
                Preconditions.checkState(z);
                switch (h) {
                    case NO_DATA:
                    case STALE_DATA_NEEDS_FULL_SERVER_FETCH:
                        d = inboxUnitFetcherWithUnitStore.m2767d();
                        TracerDetour.a(1032304785);
                        Tracer.a(f2816d);
                        break;
                    case STALE_DATA_NEEDS_INCREMENTAL_SERVER_FETCH:
                        d = inboxUnitFetcherWithUnitStore.m2768e();
                        TracerDetour.a(-182080894);
                        Tracer.a(f2816d);
                        break;
                    case UP_TO_DATE:
                        d = inboxUnitFetcherWithUnitStore.m2756a(DataFreshnessResult.FROM_CACHE_UP_TO_DATE, InboxUnitsToFetch.ALL);
                        TracerDetour.a(833564890);
                        Tracer.a(f2816d);
                        break;
                    default:
                        throw new IllegalStateException();
                }
            } else if (h == DbStaleness.UP_TO_DATE) {
                d = inboxUnitFetcherWithUnitStore.m2756a(DataFreshnessResult.FROM_CACHE_UP_TO_DATE, inboxUnitParams.f2753b);
                TracerDetour.a(2048037475);
                Tracer.a(f2816d);
            } else if (h != DbStaleness.NO_DATA) {
                d = inboxUnitFetcherWithUnitStore.m2756a(DataFreshnessResult.FROM_CACHE_STALE, inboxUnitParams.f2753b);
                TracerDetour.a(-1437046714);
                Tracer.a(f2816d);
            } else if (inboxUnitParams.f2752a != DataFreshnessParam.DO_NOT_CHECK_SERVER) {
                d = inboxUnitFetcherWithUnitStore.m2767d();
                TracerDetour.a(-1021073696);
                Tracer.a(f2816d);
            } else {
                d = new InboxUnitResultWithGraphQL(inboxUnitFetcherWithUnitStore, new InboxUnitSnapshot(DataFreshnessResult.NO_DATA, inboxUnitParams.f2753b, inboxUnitFetcherWithUnitStore.f2826m.a(), ImmutableList.of()));
                TracerDetour.a(-1927924780);
                Tracer.a(f2816d);
            }
            return d;
        } finally {
            TracerDetour.a(-735096753);
            Tracer.a(f2816d);
        }
    }

    private InboxUnitResult m2767d() {
        GraphQLRequest f = m2769f();
        GraphQLResult a = m2755a(f);
        m2762a(f, a);
        return m2757a(DataFreshnessResult.FROM_SERVER, InboxUnitsToFetch.ALL, (InboxV2QueryModel) a.e);
    }

    private GraphQLResult<InboxV2QueryModel> m2755a(GraphQLRequest<InboxV2QueryModel> graphQLRequest) {
        TracerDetour.a("makeRequest", 970478802);
        try {
            GraphQLResult<InboxV2QueryModel> graphQLResult = (GraphQLResult) FuturesGetChecked.a(this.f2818e.a(graphQLRequest), InboxUnitFetcherException.class);
            return graphQLResult;
        } finally {
            TracerDetour.a(-101245446);
        }
    }

    private InboxUnitResult m2768e() {
        Map c = this.f2819f.m2783c();
        InboxV2QueryString b = ((InboxUnitGraphQLQueryExecutorHelper) this.f2828o.get()).m2714b();
        ObjectNode objectNode = new ObjectNode(JsonNodeFactory.a);
        for (Entry entry : c.entrySet()) {
            objectNode.a((String) entry.getKey(), (Long) entry.getValue());
        }
        b.a("formattedUnitUpdateTimestamps", objectNode.toString());
        return m2758a(c, (GraphQLResult) FuturesGetChecked.a(this.f2818e.a(GraphQLRequest.a(b).a(GraphQLCachePolicy.c)), InboxUnitFetcherException.class));
    }

    private InboxUnitResult m2756a(DataFreshnessResult dataFreshnessResult, InboxUnitsToFetch inboxUnitsToFetch) {
        return m2757a(dataFreshnessResult, inboxUnitsToFetch, m2761a(inboxUnitsToFetch));
    }

    private InboxV2QueryModel m2761a(InboxUnitsToFetch inboxUnitsToFetch) {
        TracerDetour.a("doDbFetch", 1153507649);
        try {
            ImmutableList b;
            switch (inboxUnitsToFetch) {
                case TOP:
                    b = this.f2819f.m2781b();
                    break;
                case ALL:
                    b = this.f2819f.m2777a();
                    break;
                default:
                    throw new IllegalStateException();
            }
            InboxV2QueryModel a = new Builder().a(new MessengerInboxUnitsModel.Builder().a(b).a()).a();
            return a;
        } finally {
            TracerDetour.a(-429289068);
        }
    }

    private void m2762a(GraphQLRequest<InboxV2QueryModel> graphQLRequest, GraphQLResult<InboxV2QueryModel> graphQLResult) {
        TracerDetour.a("writeFullResultToDatabase", -6904857);
        try {
            InboxV2QueryModel inboxV2QueryModel = (InboxV2QueryModel) graphQLResult.d();
            SQLiteDatabase a = this.f2820g.a();
            SQLiteDetour.a(a, -950494306);
            try {
                this.f2819f.m2784d();
                ImmutableList a2 = inboxV2QueryModel.a().a();
                int size = a2.size();
                int i = 0;
                boolean z = false;
                boolean z2 = true;
                int i2 = 0;
                while (i < size) {
                    boolean z3;
                    NodesModel nodesModel = (NodesModel) a2.get(i);
                    this.f2819f.m2779a(nodesModel, i2, z2);
                    GraphQLMessengerInboxUnitType r = nodesModel.r();
                    if (z2 && r != GraphQLMessengerInboxUnitType.MOST_RECENT_THREADS) {
                        z3 = true;
                        z = z2;
                    } else if (r == GraphQLMessengerInboxUnitType.MOST_RECENT_THREADS) {
                        z3 = z;
                        z = false;
                    } else {
                        z3 = z;
                        z = z2;
                    }
                    i2++;
                    i++;
                    z2 = z;
                    z = z3;
                }
                this.f2821h.b(f2813a, graphQLResult.b());
                this.f2821h.b(f2814b, graphQLResult.b());
                this.f2821h.b(f2815c, graphQLRequest.a(this.f2825l));
                a.setTransactionSuccessful();
                int putBoolean = this.f2824k.edit().putBoolean(MessagingPrefKeys.aU, z);
                putBoolean.commit();
                SQLiteDetour.b(a, putBoolean);
            } finally {
                SQLiteDetour.b(a, 1686734684);
            }
        } finally {
            TracerDetour.a(163191245);
        }
    }

    private InboxUnitResult m2758a(Map<String, Long> map, GraphQLResult<InboxV2QueryModel> graphQLResult) {
        InboxV2QueryModel inboxV2QueryModel = (InboxV2QueryModel) graphQLResult.d();
        Set hashSet = new HashSet();
        IncrementalWriteResult hashSet2 = new HashSet();
        ImmutableList a = inboxV2QueryModel.a().a();
        int size = a.size();
        for (int i = 0; i < size; i++) {
            NodesModel nodesModel = (NodesModel) a.get(i);
            switch (C04634.f2807c[nodesModel.s().ordinal()]) {
                case 1:
                    nodesModel.j();
                    hashSet.add(nodesModel.j());
                    break;
                default:
                    nodesModel.j();
                    hashSet2.add(nodesModel.j());
                    break;
            }
        }
        SQLiteDatabase a2 = this.f2820g.a();
        SQLiteDetour.a(a2, 1719417837);
        try {
            ImmutableMap a3 = this.f2819f.m2778a(hashSet2);
            hashSet2 = m2759a(inboxV2QueryModel.a().a(), hashSet, a3);
            for (String str : map.keySet()) {
                if (!(a3.containsKey(str) || hashSet.contains(str))) {
                    this.f2819f.m2782b(str);
                }
            }
            this.f2821h.b(f2813a, graphQLResult.b());
            a2.setTransactionSuccessful();
            this.f2824k.edit().putBoolean(MessagingPrefKeys.aU, hashSet2.f2812b).commit();
            inboxV2QueryModel = new Builder().a(new MessengerInboxUnitsModel.Builder().a(hashSet2.f2811a).a()).a();
            return m2757a(DataFreshnessResult.FROM_SERVER, InboxUnitsToFetch.ALL, inboxV2QueryModel);
        } finally {
            SQLiteDetour.b(a2, -1786704344);
        }
    }

    private IncrementalWriteResult m2759a(ImmutableList<NodesModel> immutableList, Set<String> set, ImmutableMap<String, UnitWithPosition> immutableMap) {
        ImmutableList.Builder builder = ImmutableList.builder();
        int size = immutableList.size();
        int i = 0;
        boolean z = false;
        boolean z2 = true;
        int i2 = 0;
        while (i < size) {
            boolean z3;
            boolean z4;
            NodesModel nodesModel = (NodesModel) immutableList.get(i);
            String j = nodesModel.j();
            if (set.contains(j)) {
                nodesModel.j();
                this.f2819f.m2779a(nodesModel, i2, z2);
                builder.c(nodesModel);
            } else if (immutableMap.containsKey(j)) {
                nodesModel.j();
                this.f2819f.m2780a(j, i2, z2);
                builder.c(((UnitWithPosition) immutableMap.get(j)).f2830a);
            }
            GraphQLMessengerInboxUnitType r = nodesModel.r();
            if (z2 && r != GraphQLMessengerInboxUnitType.MOST_RECENT_THREADS) {
                z3 = true;
                z4 = z2;
            } else if (r == GraphQLMessengerInboxUnitType.MOST_RECENT_THREADS) {
                z3 = z;
                z4 = false;
            } else {
                z3 = z;
                z4 = z2;
            }
            i++;
            i2++;
            z2 = z4;
            z = z3;
        }
        return new IncrementalWriteResult(builder.b(), z);
    }

    private GraphQLRequest<InboxV2QueryModel> m2769f() {
        return GraphQLRequest.a(((InboxUnitGraphQLQueryExecutorHelper) this.f2828o.get()).m2714b()).a(GraphQLCachePolicy.c);
    }

    public final void mo79a(NodesModel nodesModel) {
        this.f2828o.get();
        GraphQlQueryString messengerInbox2UnitActionMutationString = new MessengerInbox2UnitActionMutationString();
        MessengerInboxUnitRecordActionInputData messengerInboxUnitRecordActionInputData = new MessengerInboxUnitRecordActionInputData();
        messengerInboxUnitRecordActionInputData.a("action_type", ActionType.HIDE);
        GraphQlCallInput graphQlCallInput = messengerInboxUnitRecordActionInputData;
        graphQlCallInput.a("unit_id", nodesModel.j());
        graphQlCallInput = graphQlCallInput;
        graphQlCallInput.a("unit_logging_data", nodesModel.n());
        messengerInbox2UnitActionMutationString.a("input", graphQlCallInput);
        MessengerInboxUnitModel.Builder builder = new MessengerInboxUnitModel.Builder();
        builder.a = nodesModel.j();
        builder = builder;
        builder.b = 0;
        builder = builder;
        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
        int b = flatBufferBuilder.b(builder.a);
        flatBufferBuilder.c(2);
        flatBufferBuilder.b(0, b);
        flatBufferBuilder.a(1, builder.b, 0);
        flatBufferBuilder.d(flatBufferBuilder.d());
        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
        wrap.position(0);
        MessengerInboxUnitModel messengerInboxUnitModel = new MessengerInboxUnitModel(new MutableFlatBuffer(wrap, null, null, true, null));
        MessengerInbox2UnitActionMutationModel.Builder builder2 = new MessengerInbox2UnitActionMutationModel.Builder();
        builder2.a = messengerInboxUnitModel;
        MessengerInbox2UnitActionMutationModel.Builder builder3 = builder2;
        flatBufferBuilder = new FlatBufferBuilder(128);
        b = ModelHelper.a(flatBufferBuilder, builder3.a);
        flatBufferBuilder.c(1);
        flatBufferBuilder.b(0, b);
        flatBufferBuilder.d(flatBufferBuilder.d());
        wrap = ByteBuffer.wrap(flatBufferBuilder.e());
        wrap.position(0);
        m2764a(nodesModel, GraphQLRequest.a(messengerInbox2UnitActionMutationString).a(new MessengerInbox2UnitActionMutationModel(new MutableFlatBuffer(wrap, null, null, true, null))));
    }

    public final void mo80a(InboxUnitItem inboxUnitItem) {
        this.f2828o.get();
        MessengerInboxUnitItemsModel messengerInboxUnitItemsModel = inboxUnitItem.e;
        GraphQlQueryString messengerInboxItemActionMutationString = new MessengerInboxItemActionMutationString();
        MessengerInboxItemRecordActionInputData messengerInboxItemRecordActionInputData = new MessengerInboxItemRecordActionInputData();
        messengerInboxItemRecordActionInputData.a("action_type", MessengerInboxItemRecordActionInputData.ActionType.HIDE);
        GraphQlCallInput graphQlCallInput = messengerInboxItemRecordActionInputData;
        graphQlCallInput.a("item_id", messengerInboxUnitItemsModel.j());
        graphQlCallInput = graphQlCallInput;
        graphQlCallInput.a("item_logging_data", messengerInboxUnitItemsModel.o());
        messengerInboxItemActionMutationString.a("input", graphQlCallInput);
        MessengerInboxItemModel.Builder builder = new MessengerInboxItemModel.Builder();
        builder.a = messengerInboxUnitItemsModel.j();
        builder = builder;
        builder.c = 0;
        builder = builder;
        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
        int b = flatBufferBuilder.b(builder.a);
        flatBufferBuilder.c(4);
        flatBufferBuilder.b(0, b);
        flatBufferBuilder.a(1, builder.b, 0);
        flatBufferBuilder.a(2, builder.c, 0);
        flatBufferBuilder.a(3, builder.d, 0);
        flatBufferBuilder.d(flatBufferBuilder.d());
        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
        wrap.position(0);
        MessengerInboxItemModel messengerInboxItemModel = new MessengerInboxItemModel(new MutableFlatBuffer(wrap, null, null, true, null));
        MessengerInboxItemActionMutationModel.Builder builder2 = new MessengerInboxItemActionMutationModel.Builder();
        builder2.a = messengerInboxItemModel;
        MessengerInboxItemActionMutationModel.Builder builder3 = builder2;
        flatBufferBuilder = new FlatBufferBuilder(128);
        b = ModelHelper.a(flatBufferBuilder, builder3.a);
        flatBufferBuilder.c(1);
        flatBufferBuilder.b(0, b);
        flatBufferBuilder.d(flatBufferBuilder.d());
        wrap = ByteBuffer.wrap(flatBufferBuilder.e());
        wrap.position(0);
        m2764a(inboxUnitItem.d, GraphQLRequest.a(messengerInboxItemActionMutationString).a(new MessengerInboxItemActionMutationModel(new MutableFlatBuffer(wrap, null, null, true, null))));
    }

    public static void m2763a(InboxUnitFetcherWithUnitStore inboxUnitFetcherWithUnitStore, NodesModel nodesModel, GraphQLVisitableModel graphQLVisitableModel) {
        InboxUnitStoreReaderWriter inboxUnitStoreReaderWriter = inboxUnitFetcherWithUnitStore.f2819f;
        String j = nodesModel.j();
        UnitWithPosition unitWithPosition = (UnitWithPosition) inboxUnitStoreReaderWriter.m2778a(ImmutableSet.of(j)).get(j);
        if (unitWithPosition != null) {
            ConsistencyMemoryCache a = inboxUnitFetcherWithUnitStore.f2823j.a();
            a.a(graphQLVisitableModel);
            inboxUnitFetcherWithUnitStore.f2819f.m2779a((NodesModel) a.b(unitWithPosition.f2830a), unitWithPosition.f2831b, unitWithPosition.f2832c);
            inboxUnitFetcherWithUnitStore.m2770g();
        }
    }

    @VisibleForTesting
    private void m2770g() {
        for (InboxUnitResultWithGraphQL inboxUnitResultWithGraphQL : this.f2827n.keySet()) {
            if (inboxUnitResultWithGraphQL.f2810c != null) {
                InboxUnitManager.m2735b(inboxUnitResultWithGraphQL.f2810c.f2768a);
            }
        }
    }

    private InboxUnitResult m2757a(DataFreshnessResult dataFreshnessResult, InboxUnitsToFetch inboxUnitsToFetch, InboxV2QueryModel inboxV2QueryModel) {
        TracerDetour.a("convertInboxV2QueryModel", -1973736168);
        try {
            ImmutableList a = ((InboxUnitFetcherHelper) this.f2829p.get()).m2710a(inboxV2QueryModel);
            InboxUnitResult inboxUnitResultWithGraphQL = new InboxUnitResultWithGraphQL(this, new InboxUnitSnapshot(dataFreshnessResult, inboxUnitsToFetch, this.f2826m.a(), a));
            return inboxUnitResultWithGraphQL;
        } finally {
            TracerDetour.a(-1003123357);
        }
    }

    @VisibleForTesting
    private DbStaleness m2771h() {
        if (!Objects.equal(m2769f().a(this.f2825l), this.f2821h.a(f2815c))) {
            return DbStaleness.NO_DATA;
        }
        long a = this.f2821h.a(f2814b, 0);
        if (a == 0) {
            return DbStaleness.NO_DATA;
        }
        long a2 = this.f2826m.a();
        if (a < a2 - 259200000) {
            return DbStaleness.STALE_DATA_NEEDS_FULL_SERVER_FETCH;
        }
        long a3 = this.f2821h.a(f2813a, 0);
        Object obj = 1;
        NetworkInfo activeNetworkInfo = ((InboxUnitGraphQLQueryExecutorHelper) this.f2828o.get()).f2758a.getActiveNetworkInfo();
        if (!(activeNetworkInfo != null && activeNetworkInfo.isConnected() && activeNetworkInfo.isAvailable() && activeNetworkInfo.getType() == 1)) {
            obj = null;
        }
        if (obj != null) {
            if (a3 < a2 - 3600000) {
                return DbStaleness.STALE_DATA_NEEDS_INCREMENTAL_SERVER_FETCH;
            }
            return DbStaleness.UP_TO_DATE;
        } else if (a3 < a2 - 21600000) {
            return DbStaleness.STALE_DATA_NEEDS_INCREMENTAL_SERVER_FETCH;
        } else {
            return DbStaleness.UP_TO_DATE;
        }
    }
}
