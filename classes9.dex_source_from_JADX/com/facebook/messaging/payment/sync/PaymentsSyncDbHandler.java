package com.facebook.messaging.payment.sync;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import com.facebook.auth.userscope.UserScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.payment.database.DbPaymentsProperties;
import com.facebook.messaging.payment.database.DbPaymentsPropertyUtil;
import com.facebook.messaging.payment.database.PaymentsDatabaseSupplier;
import com.facebook.messaging.payment.sync.delta.PaymentsDeltaHandlerSupplier;
import com.facebook.messaging.payment.sync.delta.PaymentsPrefetchedSyncData;
import com.facebook.messaging.paymentsync.model.thrift.DeltaPaymentWrapper;
import com.facebook.sync.SyncDbHandler;
import com.facebook.sync.analytics.FullRefreshReason;
import com.facebook.sync.delta.DeltaWithSequenceId;
import com.facebook.tools.dextr.runtime.detour.SQLiteDetour;
import com.google.common.collect.ImmutableMap;
import java.util.List;
import javax.inject.Inject;

@UserScoped
/* compiled from: fetchMoreTransactionsParams */
public class PaymentsSyncDbHandler implements SyncDbHandler<PaymentsPrefetchedSyncData, DeltaPaymentWrapper> {
    private static final Object f14806d = new Object();
    private final PaymentsDeltaHandlerSupplier f14807a;
    private final DbPaymentsPropertyUtil f14808b;
    private final PaymentsDatabaseSupplier f14809c;

    private static PaymentsSyncDbHandler m15227b(InjectorLike injectorLike) {
        return new PaymentsSyncDbHandler(PaymentsDeltaHandlerSupplier.m15264a(injectorLike), DbPaymentsPropertyUtil.m13206a(injectorLike), PaymentsDatabaseSupplier.m13210a(injectorLike));
    }

    public final Bundle m15229a(Object obj, DeltaWithSequenceId deltaWithSequenceId) {
        PaymentsPrefetchedSyncData paymentsPrefetchedSyncData = (PaymentsPrefetchedSyncData) obj;
        SQLiteDatabase a = this.f14809c.a();
        SQLiteDetour.a(a, -1947771245);
        try {
            Bundle b = m15226b(paymentsPrefetchedSyncData, deltaWithSequenceId);
            this.f14808b.b(DbPaymentsProperties.f12850f, deltaWithSequenceId.b);
            a.setTransactionSuccessful();
            return b;
        } finally {
            SQLiteDetour.b(a, 329504747);
        }
    }

    @Inject
    public PaymentsSyncDbHandler(PaymentsDeltaHandlerSupplier paymentsDeltaHandlerSupplier, DbPaymentsPropertyUtil dbPaymentsPropertyUtil, PaymentsDatabaseSupplier paymentsDatabaseSupplier) {
        this.f14807a = paymentsDeltaHandlerSupplier;
        this.f14808b = dbPaymentsPropertyUtil;
        this.f14809c = paymentsDatabaseSupplier;
    }

    public final long m15228a() {
        return this.f14808b.a(DbPaymentsProperties.f12850f, -1);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.facebook.messaging.payment.sync.PaymentsSyncDbHandler m15225a(com.facebook.inject.InjectorLike r7) {
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
        r1 = f14806d;	 Catch:{ all -> 0x006c }
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
        r1 = m15227b(r0);	 Catch:{ all -> 0x0062 }
        com.facebook.auth.userscope.UserScope.a(r6);	 Catch:{  }
        if (r1 != 0) goto L_0x0071;
    L_0x004d:
        r0 = f14806d;	 Catch:{  }
        r6 = com.facebook.auth.userscope.UserScope.a;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r6);	 Catch:{  }
        r0 = (com.facebook.messaging.payment.sync.PaymentsSyncDbHandler) r0;	 Catch:{  }
    L_0x0057:
        if (r0 == 0) goto L_0x007a;
    L_0x0059:
        r2.c(r5);	 Catch:{  }
    L_0x005c:
        r0 = (com.facebook.messaging.payment.sync.PaymentsSyncDbHandler) r0;	 Catch:{  }
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
        r0 = f14806d;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r1);	 Catch:{  }
        r0 = (com.facebook.messaging.payment.sync.PaymentsSyncDbHandler) r0;	 Catch:{  }
        goto L_0x0057;
    L_0x007a:
        r0 = r1;
        goto L_0x0059;
    L_0x007c:
        r0 = r1;
        goto L_0x005c;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.payment.sync.PaymentsSyncDbHandler.a(com.facebook.inject.InjectorLike):com.facebook.messaging.payment.sync.PaymentsSyncDbHandler");
    }

    public final void m15231a(long j) {
        this.f14808b.b(DbPaymentsProperties.f12850f, j);
    }

    public final boolean m15234b() {
        return this.f14808b.a(DbPaymentsProperties.f12851g, false);
    }

    public final void m15232a(boolean z, FullRefreshReason fullRefreshReason) {
        this.f14808b.b(DbPaymentsProperties.f12851g, z);
        this.f14808b.b(DbPaymentsProperties.f12852h, fullRefreshReason.toString());
    }

    public final FullRefreshReason m15235c() {
        return FullRefreshReason.a(this.f14808b.a(DbPaymentsProperties.f12852h, ""));
    }

    public final long m15236d() {
        return this.f14808b.a(DbPaymentsProperties.f12853i, -1);
    }

    public final void m15233b(long j) {
        this.f14808b.b(DbPaymentsProperties.f12853i, j);
    }

    public final String m15237e() {
        return this.f14808b.a(DbPaymentsProperties.f12849e);
    }

    public final boolean m15238f() {
        return false;
    }

    public final ImmutableMap m15230a(Object obj, List list) {
        throw new UnsupportedOperationException();
    }

    private Bundle m15226b(PaymentsPrefetchedSyncData paymentsPrefetchedSyncData, DeltaWithSequenceId<DeltaPaymentWrapper> deltaWithSequenceId) {
        return this.f14807a.m15266a((DeltaPaymentWrapper) deltaWithSequenceId.a).mo599a(deltaWithSequenceId);
    }
}
