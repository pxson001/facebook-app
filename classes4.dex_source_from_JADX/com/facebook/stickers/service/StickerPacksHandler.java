package com.facebook.stickers.service;

import android.database.sqlite.SQLiteDatabase;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.network.FbNetworkManager;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.common.util.TriState;
import com.facebook.debug.log.BLog;
import com.facebook.fbservice.service.DataFreshnessParam;
import com.facebook.fbservice.service.ErrorCode;
import com.facebook.fbservice.service.OperationParams;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.http.protocol.ApiMethodRunner$Batch;
import com.facebook.http.protocol.ApiMethodRunnerImpl;
import com.facebook.http.protocol.BatchOperation;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.stickers.data.StickerCache;
import com.facebook.stickers.data.StickerDbStorageImpl;
import com.facebook.stickers.data.StickersDatabaseSupplier;
import com.facebook.stickers.data.StickersDbProperties;
import com.facebook.stickers.data.StickersDbPropertyUtil;
import com.facebook.stickers.model.StickerPack;
import com.facebook.stickers.model.StickerPackType;
import com.facebook.stickers.service.FetchStickerPacksParams.TrayPacksUpdateOperation;
import com.facebook.stickers.service.FetchStickerPacksResult.Availability;
import com.facebook.tools.dextr.runtime.detour.SQLiteDetour;
import com.facebook.tools.dextr.runtime.detour.TracerDetour;
import com.facebook.ultralight.Lazy;
import com.facebook.ultralight.UltralightRuntime;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: r_cancel_req */
public class StickerPacksHandler {
    private static final Class<?> f3879a;
    public static final CallerContext f3880b;
    @Inject
    @Lazy
    public com.facebook.inject.Lazy<FbNetworkManager> f3881c = UltralightRuntime.b;
    private final StickerCache f3882d;
    private final StickerDbStorageImpl f3883e;
    private final StickersDatabaseSupplier f3884f;
    public final ApiMethodRunnerImpl f3885g;
    public final SetDownloadedStickerPacksMethod f3886h;
    private final FetchStickerPackIdsMethod f3887i;
    private final FetchStickerPacksMethod f3888j;
    private final FetchStickerPacksByIdMethod f3889k;
    public final AddStickerPackMethod f3890l;
    private final StickersDbPropertyUtil f3891m;
    private final DefaultStickerPackSetProvider f3892n;
    private final Clock f3893o;
    private final StickerConfigBroadcaster f3894p;

    public static StickerPacksHandler m4340b(InjectorLike injectorLike) {
        StickerPacksHandler stickerPacksHandler = new StickerPacksHandler(StickerCache.m12960a(injectorLike), StickerDbStorageImpl.m4229a(injectorLike), StickersDatabaseSupplier.m4268a(injectorLike), ApiMethodRunnerImpl.a(injectorLike), SetDownloadedStickerPacksMethod.m4350a(injectorLike), FetchStickerPackIdsMethod.m4353a(injectorLike), FetchStickerPacksMethod.m4358a(injectorLike), FetchStickerPacksByIdMethod.m4364a(injectorLike), AddStickerPackMethod.m4370a(injectorLike), StickerConfigBroadcaster.m4373a(injectorLike), StickersDbPropertyUtil.m4376a(injectorLike), DefaultStickerPackSetProvider.m4378a(injectorLike), (Clock) SystemClockMethodAutoProvider.a(injectorLike));
        stickerPacksHandler.f3881c = IdBasedSingletonScopeProvider.b(injectorLike, 585);
        return stickerPacksHandler;
    }

    static {
        Class cls = StickerPacksHandler.class;
        f3879a = cls;
        f3880b = CallerContext.a(cls);
    }

    final OperationResult m4347c(OperationParams operationParams) {
        return m4331a((FetchStickerPacksParams) operationParams.c.getParcelable("fetchStickerPacksParams"));
    }

    final OperationResult m4348d(OperationParams operationParams) {
        StickerPack stickerPack = (StickerPack) operationParams.c.getParcelable("stickerPack");
        ImmutableList of = ImmutableList.of(stickerPack);
        FetchStickerPacksResult a = m4333a();
        Builder builder = new Builder();
        builder.b(of);
        builder.b((Iterable) a.f3955b.get());
        ImmutableList b = builder.b();
        ApiMethodRunner$Batch a2 = this.f3885g.a();
        BatchOperation.Builder a3 = BatchOperation.m12541a(this.f3890l, stickerPack);
        a3.f11927c = "add-sticker-pack";
        a2.mo888a(a3.m12549a());
        a3 = BatchOperation.m12541a(this.f3886h, b);
        a3.f11927c = "set-downloaded-packs";
        a3 = a3;
        a3.f11928d = "add-sticker-pack";
        a2.mo888a(a3.m12549a());
        a2.mo889a("add-packs", f3880b);
        m4337a(of);
        return OperationResult.a;
    }

    @Inject
    public StickerPacksHandler(StickerCache stickerCache, StickerDbStorageImpl stickerDbStorageImpl, StickersDatabaseSupplier stickersDatabaseSupplier, ApiMethodRunnerImpl apiMethodRunnerImpl, SetDownloadedStickerPacksMethod setDownloadedStickerPacksMethod, FetchStickerPackIdsMethod fetchStickerPackIdsMethod, FetchStickerPacksMethod fetchStickerPacksMethod, FetchStickerPacksByIdMethod fetchStickerPacksByIdMethod, AddStickerPackMethod addStickerPackMethod, StickerConfigBroadcaster stickerConfigBroadcaster, StickersDbPropertyUtil stickersDbPropertyUtil, DefaultStickerPackSetProvider defaultStickerPackSetProvider, Clock clock) {
        this.f3882d = stickerCache;
        this.f3883e = stickerDbStorageImpl;
        this.f3884f = stickersDatabaseSupplier;
        this.f3885g = apiMethodRunnerImpl;
        this.f3886h = setDownloadedStickerPacksMethod;
        this.f3887i = fetchStickerPackIdsMethod;
        this.f3888j = fetchStickerPacksMethod;
        this.f3889k = fetchStickerPacksByIdMethod;
        this.f3890l = addStickerPackMethod;
        this.f3894p = stickerConfigBroadcaster;
        this.f3891m = stickersDbPropertyUtil;
        this.f3893o = clock;
        this.f3892n = defaultStickerPackSetProvider;
    }

    final void m4345a(List<StickerPack> list, @Nullable List<StickerPack> list2) {
        if (list2 == null) {
            List of = ImmutableList.of();
        }
        this.f3882d.m12967a(StickerPackType.DOWNLOADED_PACKS, (List) list);
        SQLiteDatabase a = this.f3884f.a();
        SQLiteDetour.a(a, -672788868);
        try {
            this.f3883e.m4252a(StickerPackType.DOWNLOADED_PACKS, (List) list);
            this.f3883e.m4263b(of);
            a.setTransactionSuccessful();
            this.f3894p.m4375a();
            this.f3885g.a(this.f3886h, list);
        } finally {
            SQLiteDetour.b(a, 1860474113);
        }
    }

    final OperationResult m4344a(OperationParams operationParams) {
        FetchStickerPackIdsParams fetchStickerPackIdsParams = (FetchStickerPackIdsParams) operationParams.b().getParcelable("fetchStickerPackIdsParams");
        TracerDetour.a("StickerPacksHandler handleFetchStickerPackIds", -657823332);
        try {
            OperationResult a = OperationResult.a(new FetchStickerPackIdsResult(((FetchStickerPackIdsResult) this.f3885g.a(this.f3887i, fetchStickerPackIdsParams)).a()));
            return a;
        } finally {
            TracerDetour.a(388249454);
        }
    }

    public final OperationResult m4346b(OperationParams operationParams) {
        ImmutableList<String> a = ((FetchStickerPacksByIdParams) operationParams.b().getParcelable("fetchStickerPacksByIdParams")).a();
        Collection a2 = Lists.a();
        Builder builder = new Builder();
        ImmutableMap.Builder builder2 = new ImmutableMap.Builder();
        for (String str : a) {
            TriState c = this.f3882d.m12977c(str);
            TriState c2 = this.f3883e.m4265c(str);
            if (this.f3882d.m12971a(str) && c.isSet()) {
                builder.c(this.f3882d.m12972b(str));
                builder2.b(str, m4332a(c));
            } else if (this.f3883e.m4257a(str) && c2.isSet()) {
                TracerDetour.a("StickerPacksHandler fetchStickerPacksById fetch from db", -1920302302);
                try {
                    builder.c(this.f3883e.m4258b(str));
                    builder2.b(str, m4332a(c2));
                } finally {
                    a2 = 957823600;
                    TracerDetour.a(957823600);
                }
            } else {
                a2.add(str);
            }
        }
        if (a2.size() > 0) {
            FetchStickerPacksResult a3 = m4334a(new FetchStickerPacksByIdParams(a2));
            builder.b((Iterable) a3.m4447a().get());
            builder2.a((Map) a3.m4449b().get());
        }
        return OperationResult.a(new FetchStickerPacksResult(builder.b(), builder2.b()));
    }

    private static Availability m4332a(TriState triState) {
        if (triState.asBoolean(false)) {
            return Availability.DOWNLOADED;
        }
        return Availability.IN_STORE;
    }

    private FetchStickerPacksResult m4334a(FetchStickerPacksByIdParams fetchStickerPacksByIdParams) {
        TracerDetour.a("StickerPacksHandler fetchStickerPacksByIdFromServer", -128251057);
        try {
            FetchStickerPacksResult fetchStickerPacksResult = (FetchStickerPacksResult) this.f3885g.a(this.f3889k, fetchStickerPacksByIdParams);
            return fetchStickerPacksResult;
        } finally {
            TracerDetour.a(-1183025621);
        }
    }

    private FetchStickerPacksResult m4333a() {
        return (FetchStickerPacksResult) m4331a(new FetchStickerPacksParams.Builder(StickerPackType.DOWNLOADED_PACKS, DataFreshnessParam.PREFER_CACHE_IF_UP_TO_DATE).m4385a()).h();
    }

    private void m4337a(ImmutableList<StickerPack> immutableList) {
        SQLiteDatabase a = this.f3884f.a();
        SQLiteDetour.a(a, -515277932);
        try {
            if (this.f3883e.m4264b(StickerPackType.OWNED_PACKS)) {
                this.f3883e.m4261b(StickerPackType.OWNED_PACKS, (List) immutableList);
            }
            this.f3883e.m4261b(StickerPackType.DOWNLOADED_PACKS, (List) immutableList);
            a.setTransactionSuccessful();
        } finally {
            SQLiteDetour.b(a, 974561226);
        }
    }

    private OperationResult m4331a(FetchStickerPacksParams fetchStickerPacksParams) {
        StickerPackType a = fetchStickerPacksParams.m4386a();
        DataFreshnessParam b = fetchStickerPacksParams.m4387b();
        TracerDetour.a("StickerPacksHandler handleAddStickerPack", 15611891);
        try {
            ImmutableList immutableList;
            List a2;
            int i;
            OperationResult a3;
            if (b == DataFreshnessParam.CHECK_SERVER_FOR_NEW_DATA || !(b == DataFreshnessParam.DO_NOT_CHECK_SERVER || this.f3883e.m4264b(a))) {
                if (((FbNetworkManager) this.f3881c.get()).d()) {
                    FetchStickerPacksApiParams.Builder builder = new FetchStickerPacksApiParams.Builder(fetchStickerPacksParams);
                    Object obj = (!fetchStickerPacksParams.m4389g() || m4330a(a) == 0) ? null : 1;
                    if (obj != null) {
                        builder.a(m4339b(a));
                    }
                    immutableList = (ImmutableList) ((FetchStickerPacksResult) this.f3885g.a(this.f3888j, builder.a())).m4447a().get();
                    m4343c(a);
                    if (obj != null) {
                        m4336a(a, immutableList);
                        a2 = this.f3883e.m4249a(a);
                    } else {
                        m4342b(a, immutableList);
                        a2 = immutableList;
                    }
                    if (fetchStickerPacksParams.m4390h() != TrayPacksUpdateOperation.DO_NOT_UPDATE) {
                        if (!this.f3883e.m4264b(StickerPackType.DOWNLOADED_PACKS) || fetchStickerPacksParams.m4390h() == TrayPacksUpdateOperation.REPLACE_FROM_NETWORK) {
                            m4342b(StickerPackType.DOWNLOADED_PACKS, (ImmutableList) ((FetchStickerPacksResult) this.f3885g.a(this.f3888j, new FetchStickerPacksApiParams.Builder(new FetchStickerPacksParams.Builder(StickerPackType.DOWNLOADED_PACKS, DataFreshnessParam.CHECK_SERVER_FOR_NEW_DATA).m4385a()).a())).m4447a().get());
                            m4343c(StickerPackType.DOWNLOADED_PACKS);
                        } else {
                            Builder builder2 = new Builder();
                            int size = a2.size();
                            for (i = 0; i < size; i++) {
                                StickerPack stickerPack = (StickerPack) a2.get(i);
                                if (stickerPack.s()) {
                                    builder2.c(stickerPack);
                                }
                            }
                            m4336a(StickerPackType.DOWNLOADED_PACKS, builder2.b());
                        }
                    }
                } else {
                    a3 = OperationResult.a(ErrorCode.CONNECTION_FAILURE);
                    return a3;
                }
            } else if (this.f3883e.m4264b(a)) {
                a2 = this.f3883e.m4249a(a);
            } else {
                a3 = OperationResult.a(FetchStickerPacksResult.f3954a);
                TracerDetour.a(-1129746069);
                return a3;
            }
            if (a == StickerPackType.DOWNLOADED_PACKS) {
                Set a4 = m4335a((Collection) a2);
                if (!a4.containsAll(this.f3892n.m4380a())) {
                    a3 = m4331a(new FetchStickerPacksParams.Builder(StickerPackType.OWNED_PACKS, DataFreshnessParam.PREFER_CACHE_IF_UP_TO_DATE).m4384a(fetchStickerPacksParams.m4388d()).m4385a());
                    if (a3.b()) {
                        Map b2;
                        FetchStickerPacksResult fetchStickerPacksResult = (FetchStickerPacksResult) a3.h();
                        HashMap hashMap = new HashMap();
                        if (fetchStickerPacksResult.m4447a().isPresent()) {
                            b2 = m4341b((Collection) fetchStickerPacksResult.m4447a().get());
                        } else {
                            Object obj2 = hashMap;
                        }
                        Builder builder3 = new Builder();
                        builder3.b(a2);
                        ImmutableList a5 = this.f3892n.m4380a();
                        int size2 = a5.size();
                        i = 0;
                        Object obj3 = null;
                        while (i < size2) {
                            Object obj4 = (m4338a((String) a5.get(i), a4, b2, builder3) || obj3 != null) ? 1 : null;
                            i++;
                            obj3 = obj4;
                        }
                        if (obj3 != null) {
                            immutableList = builder3.b();
                            m4342b(a, immutableList);
                        } else {
                            immutableList = a2;
                        }
                        a2 = immutableList;
                    } else {
                        BLog.b(f3879a, "Unable to include default packs in downloaded list!");
                    }
                }
            }
            a3 = OperationResult.a(new FetchStickerPacksResult(a2));
            TracerDetour.a(-374744083);
            return a3;
        } finally {
            TracerDetour.a(947164787);
        }
    }

    private long m4330a(StickerPackType stickerPackType) {
        return this.f3891m.m8550a(StickersDbProperties.a(stickerPackType), 0);
    }

    private long m4339b(StickerPackType stickerPackType) {
        long j = 0;
        ImmutableList a = this.f3883e.m4249a(stickerPackType);
        int size = a.size();
        int i = 0;
        while (i < size) {
            long j2;
            StickerPack stickerPack = (StickerPack) a.get(i);
            if (stickerPack.j() > j) {
                j2 = stickerPack.j();
            } else {
                j2 = j;
            }
            i++;
            j = j2;
        }
        return j;
    }

    private void m4343c(StickerPackType stickerPackType) {
        this.f3891m.m8557b(StickersDbProperties.a(stickerPackType), this.f3893o.a());
    }

    private void m4336a(StickerPackType stickerPackType, ImmutableList<StickerPack> immutableList) {
        if (this.f3883e.m4264b(stickerPackType)) {
            this.f3883e.m4261b(stickerPackType, (List) immutableList);
        } else {
            m4342b(stickerPackType, immutableList);
        }
    }

    private void m4342b(StickerPackType stickerPackType, ImmutableList<StickerPack> immutableList) {
        this.f3883e.m4252a(stickerPackType, (List) immutableList);
    }

    private static Set<String> m4335a(Collection<StickerPack> collection) {
        Set<String> hashSet = new HashSet();
        for (StickerPack stickerPack : collection) {
            hashSet.add(stickerPack.a);
        }
        return hashSet;
    }

    private static Map<String, StickerPack> m4341b(Collection<StickerPack> collection) {
        Map<String, StickerPack> hashMap = new HashMap();
        for (StickerPack stickerPack : collection) {
            hashMap.put(stickerPack.a, stickerPack);
        }
        return hashMap;
    }

    private static boolean m4338a(String str, Set<String> set, Map<String, StickerPack> map, Builder<StickerPack> builder) {
        if (!set.contains(str)) {
            if (map.containsKey(str)) {
                builder.c(map.get(str));
                return true;
            }
            BLog.b(f3879a, "Couldn't add Meep sticker pack!");
        }
        return false;
    }
}
