package com.facebook.messaging.payment.sync.delta;

import com.facebook.auth.userscope.UserScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.payment.sync.connection.PaymentsSyncWebFetcher;
import com.facebook.messaging.paymentsync.model.thrift.DeltaPaymentForcedFetch;
import com.facebook.messaging.paymentsync.model.thrift.DeltaPaymentWrapper;
import com.facebook.sync.delta.DeltaEnsuredDataFetcher;
import com.facebook.sync.delta.DeltaWithSequenceId;
import java.util.List;
import javax.inject.Inject;

@UserScoped
/* compiled from: fetchMoreThreads (CSH). */
public class PaymentsDeltaEnsuredDataFetcher implements DeltaEnsuredDataFetcher<PaymentsPrefetchedSyncData, DeltaPaymentWrapper> {
    private static final Object f14848b = new Object();
    private final PaymentsSyncWebFetcher f14849a;

    private static PaymentsDeltaEnsuredDataFetcher m15262b(InjectorLike injectorLike) {
        return new PaymentsDeltaEnsuredDataFetcher(PaymentsSyncWebFetcher.m15255a(injectorLike));
    }

    @Inject
    public PaymentsDeltaEnsuredDataFetcher(PaymentsSyncWebFetcher paymentsSyncWebFetcher) {
        this.f14849a = paymentsSyncWebFetcher;
    }

    public final Object m15263a(List list) {
        for (DeltaWithSequenceId deltaWithSequenceId : list) {
            if (((DeltaPaymentWrapper) deltaWithSequenceId.a).setField_ == 8) {
                DeltaPaymentForcedFetch f = ((DeltaPaymentWrapper) deltaWithSequenceId.a).m16095f();
                if (f.fetchTransferFbId != null) {
                    this.f14849a.m15259a(String.valueOf(f.fetchTransferFbId));
                } else if (f.fetchPaymentMethods != null && f.fetchPaymentMethods.booleanValue()) {
                    this.f14849a.m15260b();
                }
            }
        }
        return new PaymentsPrefetchedSyncData();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.facebook.messaging.payment.sync.delta.PaymentsDeltaEnsuredDataFetcher m15261a(com.facebook.inject.InjectorLike r7) {
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
        r1 = f14848b;	 Catch:{ all -> 0x006c }
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
        r1 = m15262b(r0);	 Catch:{ all -> 0x0062 }
        com.facebook.auth.userscope.UserScope.a(r6);	 Catch:{  }
        if (r1 != 0) goto L_0x0071;
    L_0x004d:
        r0 = f14848b;	 Catch:{  }
        r6 = com.facebook.auth.userscope.UserScope.a;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r6);	 Catch:{  }
        r0 = (com.facebook.messaging.payment.sync.delta.PaymentsDeltaEnsuredDataFetcher) r0;	 Catch:{  }
    L_0x0057:
        if (r0 == 0) goto L_0x007a;
    L_0x0059:
        r2.c(r5);	 Catch:{  }
    L_0x005c:
        r0 = (com.facebook.messaging.payment.sync.delta.PaymentsDeltaEnsuredDataFetcher) r0;	 Catch:{  }
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
        r0 = f14848b;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r1);	 Catch:{  }
        r0 = (com.facebook.messaging.payment.sync.delta.PaymentsDeltaEnsuredDataFetcher) r0;	 Catch:{  }
        goto L_0x0057;
    L_0x007a:
        r0 = r1;
        goto L_0x0059;
    L_0x007c:
        r0 = r1;
        goto L_0x005c;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.payment.sync.delta.PaymentsDeltaEnsuredDataFetcher.a(com.facebook.inject.InjectorLike):com.facebook.messaging.payment.sync.delta.PaymentsDeltaEnsuredDataFetcher");
    }
}
