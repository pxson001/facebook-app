package com.facebook.messaging.sync;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import com.facebook.auth.userscope.UserScoped;
import com.facebook.debug.log.BLog;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.database.threads.DbThreadProperties;
import com.facebook.messaging.database.threads.DbThreadsPropertyUtil;
import com.facebook.messaging.database.threads.ThreadsDatabaseSupplier;
import com.facebook.messaging.sync.delta.MessagesDeltaHandlerSupplier;
import com.facebook.messaging.sync.delta.PrefetchedSyncData;
import com.facebook.messaging.sync.model.thrift.DeltaWrapper;
import com.facebook.sync.SyncDbHandler;
import com.facebook.sync.analytics.FullRefreshReason;
import com.facebook.sync.delta.DeltaWithSequenceId;
import com.facebook.sync.util.SequenceIdUtil;
import com.facebook.sync.util.SequenceIdUtil.SequenceIdState;
import com.facebook.tools.dextr.runtime.detour.SQLiteDetour;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMap.Builder;
import java.util.List;
import javax.inject.Inject;

@UserScoped
/* compiled from: publish failed */
public class MessagesSyncDbHandler implements SyncDbHandler<PrefetchedSyncData, DeltaWrapper> {
    private static final Class<?> f4262a = MessagesSyncDbHandler.class;
    private static final Object f4263g = new Object();
    public final DbThreadsPropertyUtil f4264b;
    private final ThreadsDatabaseSupplier f4265c;
    private final MessagesDeltaHandlerSupplier f4266d;
    private final Boolean f4267e;
    private final SequenceIdUtil f4268f;

    private static MessagesSyncDbHandler m3884b(InjectorLike injectorLike) {
        return new MessagesSyncDbHandler(DbThreadsPropertyUtil.a(injectorLike), ThreadsDatabaseSupplier.a(injectorLike), MessagesDeltaHandlerSupplier.m3974a(injectorLike), Boolean.valueOf(GatekeeperStoreImplMethodAutoProvider.a(injectorLike).a(979, false)), SequenceIdUtil.a(injectorLike));
    }

    public final Bundle m3886a(Object obj, DeltaWithSequenceId deltaWithSequenceId) {
        PrefetchedSyncData prefetchedSyncData = (PrefetchedSyncData) obj;
        SQLiteDatabase a = this.f4265c.a();
        SQLiteDetour.a(a, 1589638487);
        try {
            Bundle b = m3883b(prefetchedSyncData, deltaWithSequenceId);
            a.setTransactionSuccessful();
            SQLiteDetour.b(a, -2059289234);
            return b;
        } catch (Exception e) {
            BLog.a(f4262a, "Error applying delta type %d seqid %d error: %s", new Object[]{Integer.valueOf(((DeltaWrapper) deltaWithSequenceId.a).a()), Long.valueOf(deltaWithSequenceId.b), e});
            throw r1;
        } catch (Throwable th) {
            SQLiteDetour.b(a, 1595690470);
        }
    }

    public final ImmutableMap m3887a(Object obj, List list) {
        PrefetchedSyncData prefetchedSyncData = (PrefetchedSyncData) obj;
        if (this.f4267e.booleanValue()) {
            Builder builder = ImmutableMap.builder();
            SQLiteDatabase a = this.f4265c.a();
            long a2 = m3885a();
            Long.valueOf(a2);
            SQLiteDetour.a(a, 528198933);
            try {
                DeltaWithSequenceId deltaWithSequenceId = null;
                for (DeltaWithSequenceId deltaWithSequenceId2 : list) {
                    if (SequenceIdUtil.a(deltaWithSequenceId2.b, m3885a()) != SequenceIdState.EXPECTED) {
                        int i;
                        if (deltaWithSequenceId == null) {
                            i = -1;
                        } else {
                            i = ((DeltaWrapper) deltaWithSequenceId.a).a();
                        }
                        BLog.a(f4262a, "Unexpected delta! type %d , previous type: %d, firstSeqId: %d, currentSeqId: %d", new Object[]{Integer.valueOf(((DeltaWrapper) deltaWithSequenceId2.a).a()), Integer.valueOf(i), Long.valueOf(a2), Long.valueOf(deltaWithSequenceId2.b)});
                        throw new RuntimeException("Unable to process the whole batch of deltas at once.");
                    }
                    Bundle b = m3883b(prefetchedSyncData, deltaWithSequenceId2);
                    if (b != null) {
                        builder.b(Long.valueOf(deltaWithSequenceId2.b), b);
                        deltaWithSequenceId = deltaWithSequenceId2;
                    } else {
                        BLog.b(f4262a, "Bundle from handleDeltaInternal is null. delta type: %d, seqId: %d", new Object[]{Integer.valueOf(((DeltaWrapper) deltaWithSequenceId2.a).a()), Long.valueOf(deltaWithSequenceId2.b)});
                        deltaWithSequenceId = deltaWithSequenceId2;
                    }
                }
                a.setTransactionSuccessful();
                Long.valueOf(m3885a());
                SQLiteDetour.b(a, 152023053);
                return builder.b();
            } catch (Throwable e) {
                BLog.b(f4262a, "Failed batch processing deltas", e);
                this.f4264b.b(DbThreadProperties.j, a2);
                throw e;
            } catch (Throwable th) {
                SQLiteDetour.b(a, -1776466554);
            }
        } else {
            throw new UnsupportedOperationException();
        }
    }

    @Inject
    public MessagesSyncDbHandler(DbThreadsPropertyUtil dbThreadsPropertyUtil, ThreadsDatabaseSupplier threadsDatabaseSupplier, MessagesDeltaHandlerSupplier messagesDeltaHandlerSupplier, Boolean bool, SequenceIdUtil sequenceIdUtil) {
        this.f4264b = dbThreadsPropertyUtil;
        this.f4265c = threadsDatabaseSupplier;
        this.f4266d = messagesDeltaHandlerSupplier;
        this.f4267e = bool;
        this.f4268f = sequenceIdUtil;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.facebook.messaging.sync.MessagesSyncDbHandler m3882a(com.facebook.inject.InjectorLike r7) {
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
        r1 = f4263g;	 Catch:{ all -> 0x006c }
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
        r1 = m3884b(r0);	 Catch:{ all -> 0x0062 }
        com.facebook.auth.userscope.UserScope.a(r6);	 Catch:{  }
        if (r1 != 0) goto L_0x0071;
    L_0x004d:
        r0 = f4263g;	 Catch:{  }
        r6 = com.facebook.auth.userscope.UserScope.a;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r6);	 Catch:{  }
        r0 = (com.facebook.messaging.sync.MessagesSyncDbHandler) r0;	 Catch:{  }
    L_0x0057:
        if (r0 == 0) goto L_0x007a;
    L_0x0059:
        r2.c(r5);	 Catch:{  }
    L_0x005c:
        r0 = (com.facebook.messaging.sync.MessagesSyncDbHandler) r0;	 Catch:{  }
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
        r0 = f4263g;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r1);	 Catch:{  }
        r0 = (com.facebook.messaging.sync.MessagesSyncDbHandler) r0;	 Catch:{  }
        goto L_0x0057;
    L_0x007a:
        r0 = r1;
        goto L_0x0059;
    L_0x007c:
        r0 = r1;
        goto L_0x005c;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.sync.MessagesSyncDbHandler.a(com.facebook.inject.InjectorLike):com.facebook.messaging.sync.MessagesSyncDbHandler");
    }

    public final long m3885a() {
        return this.f4264b.a(DbThreadProperties.j, -1);
    }

    public final void m3888a(long j) {
        this.f4264b.b(DbThreadProperties.j, j);
    }

    public final boolean m3891b() {
        return this.f4264b.a(DbThreadProperties.l, false);
    }

    public final void m3889a(boolean z, FullRefreshReason fullRefreshReason) {
        this.f4264b.b(DbThreadProperties.l, z);
        this.f4264b.b(DbThreadProperties.m, fullRefreshReason.toString());
    }

    public final FullRefreshReason m3892c() {
        return FullRefreshReason.a(this.f4264b.a(DbThreadProperties.m, ""));
    }

    public final long m3893d() {
        return this.f4264b.a(DbThreadProperties.k, -1);
    }

    public final void m3890b(long j) {
        this.f4264b.b(DbThreadProperties.k, j);
    }

    public final String m3894e() {
        return this.f4264b.a(DbThreadProperties.i);
    }

    public final boolean m3895f() {
        return this.f4267e.booleanValue();
    }

    private Bundle m3883b(PrefetchedSyncData prefetchedSyncData, DeltaWithSequenceId<DeltaWrapper> deltaWithSequenceId) {
        DeltaWrapper deltaWrapper = (DeltaWrapper) deltaWithSequenceId.a;
        if (deltaWrapper.setField_ != 1 || deltaWrapper.c().numNoOps == null || deltaWrapper.c().numNoOps.intValue() <= 1) {
            Bundle a = this.f4266d.m3976a((DeltaWrapper) deltaWithSequenceId.a).mo124a(prefetchedSyncData, deltaWithSequenceId);
            this.f4264b.b(DbThreadProperties.j, deltaWithSequenceId.b);
            return a;
        }
        this.f4264b.b(DbThreadProperties.j, (deltaWithSequenceId.b + ((long) deltaWrapper.c().numNoOps.intValue())) - 1);
        return null;
    }
}
