package com.facebook.messaging.payment.sync.delta;

import com.facebook.auth.userscope.UserScoped;
import com.facebook.fbtrace.FbTraceNode;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.payment.sync.PaymentsSyncDbHandler;
import com.facebook.messaging.paymentsync.model.thrift.DeltaPaymentWrapper;
import com.facebook.messaging.paymentsync.model.thrift.PaymentSyncPayload;
import com.facebook.sync.delta.DeltasWithSequenceIdsFactory.DeltaNoOpSniffer;
import com.facebook.sync.delta.SyncPayloadHandler;
import com.facebook.sync.delta.SyncPayloadHandler.SyncPayloadHandlerCallback;
import com.facebook.sync.model.IrisQueueTypes;
import javax.inject.Inject;

@UserScoped
/* compiled from: fetchMoreMessages (GQL).  */
public class PaymentsSyncPayloadHandler implements SyncPayloadHandlerCallback {
    private static final Object f14861f = new Object();
    private final PaymentsDeltaEnsuredDataFetcher f14862a;
    private final PaymentsSyncDbHandler f14863b;
    private final PaymentsDeltaHandlerSupplier f14864c;
    private final SyncPayloadHandler f14865d;
    private final DeltaNoOpSniffer<DeltaPaymentWrapper> f14866e = new C17181(this);

    /* compiled from: fetchMoreMessages (GQL).  */
    class C17181 implements DeltaNoOpSniffer<DeltaPaymentWrapper> {
        final /* synthetic */ PaymentsSyncPayloadHandler f14860a;

        C17181(PaymentsSyncPayloadHandler paymentsSyncPayloadHandler) {
            this.f14860a = paymentsSyncPayloadHandler;
        }

        public final boolean m15268a(Object obj) {
            return false;
        }

        public final Integer m15269b(Object obj) {
            return null;
        }
    }

    private static PaymentsSyncPayloadHandler m15271b(InjectorLike injectorLike) {
        return new PaymentsSyncPayloadHandler(PaymentsDeltaEnsuredDataFetcher.m15261a(injectorLike), PaymentsSyncDbHandler.m15225a(injectorLike), PaymentsDeltaHandlerSupplier.m15264a(injectorLike), SyncPayloadHandler.a(injectorLike));
    }

    @Inject
    public PaymentsSyncPayloadHandler(PaymentsDeltaEnsuredDataFetcher paymentsDeltaEnsuredDataFetcher, PaymentsSyncDbHandler paymentsSyncDbHandler, PaymentsDeltaHandlerSupplier paymentsDeltaHandlerSupplier, SyncPayloadHandler syncPayloadHandler) {
        this.f14862a = paymentsDeltaEnsuredDataFetcher;
        this.f14863b = paymentsSyncDbHandler;
        this.f14864c = paymentsDeltaHandlerSupplier;
        this.f14865d = syncPayloadHandler;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.facebook.messaging.payment.sync.delta.PaymentsSyncPayloadHandler m15270a(com.facebook.inject.InjectorLike r7) {
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
        r1 = f14861f;	 Catch:{ all -> 0x006c }
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
        r1 = m15271b(r0);	 Catch:{ all -> 0x0062 }
        com.facebook.auth.userscope.UserScope.a(r6);	 Catch:{  }
        if (r1 != 0) goto L_0x0071;
    L_0x004d:
        r0 = f14861f;	 Catch:{  }
        r6 = com.facebook.auth.userscope.UserScope.a;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r6);	 Catch:{  }
        r0 = (com.facebook.messaging.payment.sync.delta.PaymentsSyncPayloadHandler) r0;	 Catch:{  }
    L_0x0057:
        if (r0 == 0) goto L_0x007a;
    L_0x0059:
        r2.c(r5);	 Catch:{  }
    L_0x005c:
        r0 = (com.facebook.messaging.payment.sync.delta.PaymentsSyncPayloadHandler) r0;	 Catch:{  }
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
        r0 = f14861f;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r1);	 Catch:{  }
        r0 = (com.facebook.messaging.payment.sync.delta.PaymentsSyncPayloadHandler) r0;	 Catch:{  }
        goto L_0x0057;
    L_0x007a:
        r0 = r1;
        goto L_0x0059;
    L_0x007c:
        r0 = r1;
        goto L_0x005c;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.payment.sync.delta.PaymentsSyncPayloadHandler.a(com.facebook.inject.InjectorLike):com.facebook.messaging.payment.sync.delta.PaymentsSyncPayloadHandler");
    }

    public final void m15273a(PaymentSyncPayload paymentSyncPayload) {
        this.f14865d.a(IrisQueueTypes.PAYMENTS_QUEUE_TYPE, paymentSyncPayload.deltas, paymentSyncPayload.firstDeltaSeqId.longValue(), this.f14866e, this.f14862a, this.f14863b, this.f14864c, FbTraceNode.a, this);
    }

    public final void m15272a() {
    }

    public final void m15274b() {
    }
}
