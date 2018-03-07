package com.facebook.sync.delta;

import android.os.Bundle;
import android.os.Parcelable;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.auth.userscope.UserScoped;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.debug.log.BLog;
import com.facebook.fbtrace.FbTraceNode;
import com.facebook.inject.InjectorLike;
import com.facebook.sync.SyncDbHandler;
import com.facebook.sync.analytics.SyncAnalyticsLogger;
import com.facebook.sync.analytics.SyncErrorReporter;
import com.facebook.sync.delta.DeltasWithSequenceIdsFactory.DeltaNoOpSniffer;
import com.facebook.sync.model.IrisQueueTypes;
import com.facebook.sync.service.MissedDeltaException;
import com.facebook.sync.util.SequenceIdUtil;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMap.Builder;
import java.util.List;
import javax.inject.Inject;

@UserScoped
/* compiled from: feed_name */
public class SyncPayloadHandler {
    private static final Class<?> f14516a = SyncPayloadHandler.class;
    private static final Object f14517g = new Object();
    private final Clock f14518b;
    private final DeltasWithSequenceIdsFactory f14519c;
    private final SequenceIdUtil f14520d;
    private final SyncAnalyticsLogger f14521e;
    private final SyncErrorReporter f14522f;

    /* compiled from: feed_name */
    public class DbResult {
        public final ImmutableMap<Long, Bundle> f14514a;
        public final ImmutableList<Long> f14515b;

        public DbResult(ImmutableMap<Long, Bundle> immutableMap, ImmutableList<Long> immutableList) {
            this.f14514a = immutableMap;
            this.f14515b = immutableList;
        }
    }

    /* compiled from: feed_name */
    public interface SyncPayloadHandlerCallback {
        void m18416a();

        void m18417b();
    }

    private static SyncPayloadHandler m18421b(InjectorLike injectorLike) {
        return new SyncPayloadHandler((Clock) SystemClockMethodAutoProvider.a(injectorLike), DeltasWithSequenceIdsFactory.m18414a(injectorLike), SequenceIdUtil.m18453a(injectorLike), SyncAnalyticsLogger.m18336a(injectorLike), SyncErrorReporter.m18343a(injectorLike));
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.facebook.sync.delta.SyncPayloadHandler m18419a(com.facebook.inject.InjectorLike r7) {
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
        r1 = f14517g;	 Catch:{ all -> 0x006c }
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
        r1 = m18421b(r0);	 Catch:{ all -> 0x0062 }
        com.facebook.auth.userscope.UserScope.a(r6);	 Catch:{  }
        if (r1 != 0) goto L_0x0071;
    L_0x004d:
        r0 = f14517g;	 Catch:{  }
        r6 = com.facebook.auth.userscope.UserScope.a;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r6);	 Catch:{  }
        r0 = (com.facebook.sync.delta.SyncPayloadHandler) r0;	 Catch:{  }
    L_0x0057:
        if (r0 == 0) goto L_0x007a;
    L_0x0059:
        r2.c(r5);	 Catch:{  }
    L_0x005c:
        r0 = (com.facebook.sync.delta.SyncPayloadHandler) r0;	 Catch:{  }
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
        r0 = f14517g;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r1);	 Catch:{  }
        r0 = (com.facebook.sync.delta.SyncPayloadHandler) r0;	 Catch:{  }
        goto L_0x0057;
    L_0x007a:
        r0 = r1;
        goto L_0x0059;
    L_0x007c:
        r0 = r1;
        goto L_0x005c;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.sync.delta.SyncPayloadHandler.a(com.facebook.inject.InjectorLike):com.facebook.sync.delta.SyncPayloadHandler");
    }

    @Inject
    public SyncPayloadHandler(Clock clock, DeltasWithSequenceIdsFactory deltasWithSequenceIdsFactory, SequenceIdUtil sequenceIdUtil, SyncAnalyticsLogger syncAnalyticsLogger, SyncErrorReporter syncErrorReporter) {
        this.f14518b = clock;
        this.f14519c = deltasWithSequenceIdsFactory;
        this.f14520d = sequenceIdUtil;
        this.f14521e = syncAnalyticsLogger;
        this.f14522f = syncErrorReporter;
    }

    public final <PREFETCH_DATA_TYPE extends Parcelable, DELTA_WRAPPER_TYPE> DbResult m18422a(IrisQueueTypes irisQueueTypes, List<DELTA_WRAPPER_TYPE> list, long j, DeltaNoOpSniffer<DELTA_WRAPPER_TYPE> deltaNoOpSniffer, DeltaEnsuredDataFetcher<PREFETCH_DATA_TYPE, DELTA_WRAPPER_TYPE> deltaEnsuredDataFetcher, SyncDbHandler<PREFETCH_DATA_TYPE, DELTA_WRAPPER_TYPE> syncDbHandler, DeltaHandlerSupplier<PREFETCH_DATA_TYPE, DELTA_WRAPPER_TYPE> deltaHandlerSupplier, FbTraceNode fbTraceNode, SyncPayloadHandlerCallback syncPayloadHandlerCallback) {
        long a = this.f14518b.a();
        ImmutableList a2 = DeltasWithSequenceIdsFactory.m18415a(list, j, deltaNoOpSniffer, fbTraceNode);
        DbResult a3 = m18418a(irisQueueTypes, (Parcelable) deltaEnsuredDataFetcher.m18409a(a2), a2, syncDbHandler);
        try {
            m18420a(a3, a2, deltaHandlerSupplier);
            syncPayloadHandlerCallback.m18417b();
            this.f14521e.m18339a(irisQueueTypes, a, a2.size(), true);
            return a3;
        } catch (Exception e) {
            this.f14521e.m18339a(irisQueueTypes, a, a2.size(), false);
            this.f14522f.m18345b(irisQueueTypes, e);
            syncPayloadHandlerCallback.m18416a();
            return a3;
        }
    }

    @VisibleForTesting
    private <PREFETCH_DATA_TYPE extends Parcelable, DELTA_WRAPPER_TYPE> DbResult m18418a(IrisQueueTypes irisQueueTypes, PREFETCH_DATA_TYPE prefetch_data_type, List<DeltaWithSequenceId<DELTA_WRAPPER_TYPE>> list, SyncDbHandler<PREFETCH_DATA_TYPE, DELTA_WRAPPER_TYPE> syncDbHandler) {
        if (syncDbHandler.m18328f() && list.size() > 1) {
            try {
                return new DbResult(syncDbHandler.m18320a((Object) prefetch_data_type, (List) list), ImmutableList.of());
            } catch (Exception e) {
                HoneyClientEvent honeyClientEvent = new HoneyClientEvent("db_handle_batch_fail");
                honeyClientEvent.a("error", e);
                this.f14521e.m18338a(honeyClientEvent, irisQueueTypes);
            }
        }
        Builder builder = ImmutableMap.builder();
        ImmutableList.Builder builder2 = ImmutableList.builder();
        Integer.valueOf(list.size());
        for (DeltaWithSequenceId deltaWithSequenceId : list) {
            long a = syncDbHandler.m18318a();
            switch (SequenceIdUtil.m18451a(deltaWithSequenceId.f14510b, a)) {
                case EXPECTED:
                    Bundle a2 = syncDbHandler.m18319a((Object) prefetch_data_type, deltaWithSequenceId);
                    if (a2 == null) {
                        BLog.a(f14516a, "dbResult is null for seqId %d , delta: %s", new Object[]{Long.valueOf(deltaWithSequenceId.f14510b), deltaWithSequenceId.f14509a.toString()});
                        break;
                    }
                    builder.b(Long.valueOf(deltaWithSequenceId.f14510b), a2);
                    PREFETCH_DATA_TYPE parcelable = a2.getParcelable("updatedPrefetchData");
                    a2.remove("updatedPrefetchData");
                    if (parcelable == null) {
                        break;
                    }
                    prefetch_data_type = parcelable;
                    break;
                case AHEAD:
                    throw new MissedDeltaException(deltaWithSequenceId.f14510b, a);
                case ALREADY_PROCESSED:
                    Long.valueOf(deltaWithSequenceId.f14510b);
                    Long.valueOf(a);
                    builder2.c(Long.valueOf(deltaWithSequenceId.f14510b));
                    break;
                default:
                    break;
            }
        }
        ImmutableMap b = builder.b();
        Integer.valueOf(b.size());
        Long.valueOf(syncDbHandler.m18318a());
        return new DbResult(b, builder2.b());
    }

    private static <PREFETCH_DATA_TYPE, DELTA_WRAPPER_TYPE> void m18420a(DbResult dbResult, List<DeltaWithSequenceId<DELTA_WRAPPER_TYPE>> list, DeltaHandlerSupplier<PREFETCH_DATA_TYPE, DELTA_WRAPPER_TYPE> deltaHandlerSupplier) {
        for (DeltaWithSequenceId deltaWithSequenceId : list) {
            if (!dbResult.f14515b.contains(Long.valueOf(deltaWithSequenceId.f14510b))) {
                deltaHandlerSupplier.m18410a(deltaWithSequenceId.f14509a).m18408a((Bundle) dbResult.f14514a.get(Long.valueOf(deltaWithSequenceId.f14510b)), deltaWithSequenceId);
            } else {
                return;
            }
        }
    }
}
