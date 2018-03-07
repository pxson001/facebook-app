package com.facebook.messaging.payment.sync.delta.handler;

import android.os.Bundle;
import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.auth.userscope.UserScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.payment.analytics.P2pPaymentsLogEvent;
import com.facebook.messaging.payment.cache.PaymentTransactionCache;
import com.facebook.messaging.payment.database.handler.DbFetchPaymentTransactionHandler;
import com.facebook.messaging.payment.database.handler.DbInsertPaymentTransactionsHandler;
import com.facebook.messaging.payment.model.PaymentTransaction;
import com.facebook.messaging.payment.model.PaymentTransactionBuilder;
import com.facebook.messaging.payment.model.TransferStatus;
import com.facebook.messaging.payment.protocol.PaymentsBroadcaster;
import com.facebook.messaging.payment.sync.connection.PaymentsSyncWebFetcher;
import com.facebook.messaging.payment.sync.delta.handlerbase.PaymentsDeltaHandler;
import com.facebook.messaging.payment.util.PaymentTransactionUtil;
import com.facebook.messaging.paymentsync.model.thrift.DeltaPaymentWrapper;
import com.facebook.messaging.paymentsync.model.thrift.DeltaTransferStatus;
import com.facebook.messaging.paymentsync.model.thrift.ReceiverStatus;
import com.facebook.messaging.paymentsync.model.thrift.SenderStatus;
import com.facebook.sync.delta.DeltaWithSequenceId;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;

@UserScoped
/* compiled from: fetchFromDb failed */
public class DeltaTransferStatusHandler extends PaymentsDeltaHandler {
    private static final Object f14911h = new Object();
    private final PaymentsBroadcaster f14912a;
    private final PaymentTransactionCache f14913b;
    private final PaymentsSyncWebFetcher f14914c;
    private final PaymentTransactionUtil f14915d;
    private final DbFetchPaymentTransactionHandler f14916e;
    private final DbInsertPaymentTransactionsHandler f14917f;
    private final AnalyticsLogger f14918g;

    private static DeltaTransferStatusHandler m15319b(InjectorLike injectorLike) {
        return new DeltaTransferStatusHandler(PaymentsBroadcaster.m15003a(injectorLike), PaymentTransactionCache.m13184a(injectorLike), PaymentsSyncWebFetcher.m15255a(injectorLike), PaymentTransactionUtil.m15519a(injectorLike), DbFetchPaymentTransactionHandler.m13242a(injectorLike), DbInsertPaymentTransactionsHandler.m13264a(injectorLike), AnalyticsLoggerMethodAutoProvider.a(injectorLike));
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.facebook.messaging.payment.sync.delta.handler.DeltaTransferStatusHandler m15316a(com.facebook.inject.InjectorLike r7) {
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
        r1 = f14911h;	 Catch:{ all -> 0x006c }
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
        r1 = m15319b(r0);	 Catch:{ all -> 0x0062 }
        com.facebook.auth.userscope.UserScope.a(r6);	 Catch:{  }
        if (r1 != 0) goto L_0x0071;
    L_0x004d:
        r0 = f14911h;	 Catch:{  }
        r6 = com.facebook.auth.userscope.UserScope.a;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r6);	 Catch:{  }
        r0 = (com.facebook.messaging.payment.sync.delta.handler.DeltaTransferStatusHandler) r0;	 Catch:{  }
    L_0x0057:
        if (r0 == 0) goto L_0x007a;
    L_0x0059:
        r2.c(r5);	 Catch:{  }
    L_0x005c:
        r0 = (com.facebook.messaging.payment.sync.delta.handler.DeltaTransferStatusHandler) r0;	 Catch:{  }
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
        r0 = f14911h;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r1);	 Catch:{  }
        r0 = (com.facebook.messaging.payment.sync.delta.handler.DeltaTransferStatusHandler) r0;	 Catch:{  }
        goto L_0x0057;
    L_0x007a:
        r0 = r1;
        goto L_0x0059;
    L_0x007c:
        r0 = r1;
        goto L_0x005c;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.payment.sync.delta.handler.DeltaTransferStatusHandler.a(com.facebook.inject.InjectorLike):com.facebook.messaging.payment.sync.delta.handler.DeltaTransferStatusHandler");
    }

    @Inject
    public DeltaTransferStatusHandler(PaymentsBroadcaster paymentsBroadcaster, PaymentTransactionCache paymentTransactionCache, PaymentsSyncWebFetcher paymentsSyncWebFetcher, PaymentTransactionUtil paymentTransactionUtil, DbFetchPaymentTransactionHandler dbFetchPaymentTransactionHandler, DbInsertPaymentTransactionsHandler dbInsertPaymentTransactionsHandler, AnalyticsLogger analyticsLogger) {
        this.f14912a = paymentsBroadcaster;
        this.f14913b = paymentTransactionCache;
        this.f14914c = paymentsSyncWebFetcher;
        this.f14915d = paymentTransactionUtil;
        this.f14916e = dbFetchPaymentTransactionHandler;
        this.f14917f = dbInsertPaymentTransactionsHandler;
        this.f14918g = analyticsLogger;
    }

    protected final Bundle mo599a(DeltaWithSequenceId<DeltaPaymentWrapper> deltaWithSequenceId) {
        DeltaTransferStatus d = ((DeltaPaymentWrapper) deltaWithSequenceId.a).m16093d();
        long longValue = d.transferFbId.longValue();
        Bundle bundle = new Bundle();
        try {
            PaymentTransaction a = this.f14916e.m13245a(longValue);
            if (a == null) {
                this.f14914c.m15259a(String.valueOf(longValue));
            } else {
                boolean c = this.f14915d.m15527c(a);
                PaymentTransaction a2 = m15314a(a, m15315a(c, d), d.timestampMs);
                this.f14917f.m13270b(a2);
                bundle.putParcelable("newPaymentTransaction", a2);
                m15318a(d, c);
            }
        } catch (Exception e) {
        }
        return bundle;
    }

    public final void m15321a(Bundle bundle, DeltaWithSequenceId<DeltaPaymentWrapper> deltaWithSequenceId) {
        PaymentTransaction paymentTransaction = (PaymentTransaction) bundle.getParcelable("newPaymentTransaction");
        if (paymentTransaction != null) {
            this.f14913b.m13190a(paymentTransaction);
            this.f14912a.m15007a(paymentTransaction.f13234g, Long.parseLong(paymentTransaction.f13229b));
        }
    }

    private static TransferStatus m15315a(boolean z, DeltaTransferStatus deltaTransferStatus) {
        if (z) {
            return TransferStatus.fromString((String) ReceiverStatus.f15987b.get(deltaTransferStatus.newReceiverStatus));
        }
        return TransferStatus.fromString((String) SenderStatus.f15989b.get(deltaTransferStatus.newSenderStatus));
    }

    private PaymentTransaction m15314a(PaymentTransaction paymentTransaction, TransferStatus transferStatus, Long l) {
        if (transferStatus == TransferStatus.R_COMPLETED || transferStatus == TransferStatus.S_COMPLETED) {
            PaymentTransactionBuilder a = PaymentTransactionBuilder.m13533a(paymentTransaction);
            a.f13248f = transferStatus;
            a = a;
            a.f13249g = m15317a(l);
            a = a;
            a.f13250h = m15317a(l);
            return a.m13534o();
        }
        a = PaymentTransactionBuilder.m13533a(paymentTransaction);
        a.f13248f = transferStatus;
        a = a;
        a.f13250h = m15317a(l);
        return a.m13534o();
    }

    private static String m15317a(Long l) {
        if (l == null) {
            return null;
        }
        return String.valueOf(TimeUnit.MILLISECONDS.toSeconds(l.longValue()));
    }

    private void m15318a(DeltaTransferStatus deltaTransferStatus, boolean z) {
        this.f14918g.a(P2pPaymentsLogEvent.d("p2p_sync_delta", z ? "p2p_receive" : "p2p_send").w("DeltaTransferStatus").a(deltaTransferStatus.irisSeqId).a);
    }
}
