package com.facebook.messaging.payment.sync.delta.handler;

import android.os.Bundle;
import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.auth.userscope.UserScoped;
import com.facebook.contacts.graphql.Contact;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.payment.analytics.P2pPaymentsLogEvent;
import com.facebook.messaging.payment.cache.PaymentTransactionCache;
import com.facebook.messaging.payment.database.handler.DbInsertPaymentTransactionsHandler;
import com.facebook.messaging.payment.database.handler.DbPaymentsUtil;
import com.facebook.messaging.payment.model.Amount;
import com.facebook.messaging.payment.model.PaymentTransaction;
import com.facebook.messaging.payment.model.PaymentTransactionBuilder;
import com.facebook.messaging.payment.model.Receiver;
import com.facebook.messaging.payment.model.Sender;
import com.facebook.messaging.payment.model.TransferStatus;
import com.facebook.messaging.payment.model.graphql.PaymentGraphQLModels.TransferContextModel;
import com.facebook.messaging.payment.model.graphql.PaymentGraphQLModels.TransferContextModel.Builder;
import com.facebook.messaging.payment.protocol.PaymentsBroadcaster;
import com.facebook.messaging.payment.sync.connection.PaymentsSyncWebFetcher;
import com.facebook.messaging.payment.sync.delta.handlerbase.PaymentsDeltaHandler;
import com.facebook.messaging.payment.util.PaymentTransactionUtil;
import com.facebook.messaging.paymentsync.model.thrift.DeltaNewTransfer;
import com.facebook.messaging.paymentsync.model.thrift.DeltaPaymentWrapper;
import com.facebook.messaging.paymentsync.model.thrift.ReceiverStatus;
import com.facebook.messaging.paymentsync.model.thrift.SenderStatus;
import com.facebook.sync.delta.DeltaWithSequenceId;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;

@UserScoped
/* compiled from: fetchMontageThreadList (GQL) */
public class DeltaNewTransferHandler extends PaymentsDeltaHandler {
    private static final Object f14878h = new Object();
    private final DbInsertPaymentTransactionsHandler f14879a;
    private final PaymentTransactionCache f14880b;
    private final PaymentsBroadcaster f14881c;
    private final PaymentTransactionUtil f14882d;
    private final PaymentsSyncWebFetcher f14883e;
    private final DbPaymentsUtil f14884f;
    private final AnalyticsLogger f14885g;

    private static DeltaNewTransferHandler m15286b(InjectorLike injectorLike) {
        return new DeltaNewTransferHandler(DbInsertPaymentTransactionsHandler.m13264a(injectorLike), PaymentTransactionCache.m13184a(injectorLike), PaymentsBroadcaster.m15003a(injectorLike), PaymentTransactionUtil.m15519a(injectorLike), PaymentsSyncWebFetcher.m15255a(injectorLike), DbPaymentsUtil.m13275a(injectorLike), AnalyticsLoggerMethodAutoProvider.a(injectorLike));
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.facebook.messaging.payment.sync.delta.handler.DeltaNewTransferHandler m15283a(com.facebook.inject.InjectorLike r7) {
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
        r1 = f14878h;	 Catch:{ all -> 0x006c }
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
        r1 = m15286b(r0);	 Catch:{ all -> 0x0062 }
        com.facebook.auth.userscope.UserScope.a(r6);	 Catch:{  }
        if (r1 != 0) goto L_0x0071;
    L_0x004d:
        r0 = f14878h;	 Catch:{  }
        r6 = com.facebook.auth.userscope.UserScope.a;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r6);	 Catch:{  }
        r0 = (com.facebook.messaging.payment.sync.delta.handler.DeltaNewTransferHandler) r0;	 Catch:{  }
    L_0x0057:
        if (r0 == 0) goto L_0x007a;
    L_0x0059:
        r2.c(r5);	 Catch:{  }
    L_0x005c:
        r0 = (com.facebook.messaging.payment.sync.delta.handler.DeltaNewTransferHandler) r0;	 Catch:{  }
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
        r0 = f14878h;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r1);	 Catch:{  }
        r0 = (com.facebook.messaging.payment.sync.delta.handler.DeltaNewTransferHandler) r0;	 Catch:{  }
        goto L_0x0057;
    L_0x007a:
        r0 = r1;
        goto L_0x0059;
    L_0x007c:
        r0 = r1;
        goto L_0x005c;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.payment.sync.delta.handler.DeltaNewTransferHandler.a(com.facebook.inject.InjectorLike):com.facebook.messaging.payment.sync.delta.handler.DeltaNewTransferHandler");
    }

    @Inject
    public DeltaNewTransferHandler(DbInsertPaymentTransactionsHandler dbInsertPaymentTransactionsHandler, PaymentTransactionCache paymentTransactionCache, PaymentsBroadcaster paymentsBroadcaster, PaymentTransactionUtil paymentTransactionUtil, PaymentsSyncWebFetcher paymentsSyncWebFetcher, DbPaymentsUtil dbPaymentsUtil, AnalyticsLogger analyticsLogger) {
        this.f14879a = dbInsertPaymentTransactionsHandler;
        this.f14880b = paymentTransactionCache;
        this.f14881c = paymentsBroadcaster;
        this.f14882d = paymentTransactionUtil;
        this.f14883e = paymentsSyncWebFetcher;
        this.f14884f = dbPaymentsUtil;
        this.f14885g = analyticsLogger;
    }

    protected final Bundle mo599a(DeltaWithSequenceId<DeltaPaymentWrapper> deltaWithSequenceId) {
        DeltaNewTransfer c = ((DeltaPaymentWrapper) deltaWithSequenceId.a).m16092c();
        Bundle bundle = new Bundle();
        if (c.themeId == null && c.commerceOrderId == null && c.platformItemId == null) {
            Contact b = this.f14884f.m13279b(String.valueOf(c.senderFbId));
            Contact b2 = this.f14884f.m13279b(String.valueOf(c.recipientFbId));
            if (b == null || b2 == null) {
                try {
                    this.f14883e.m15259a(String.valueOf(c.transferFbId));
                } catch (Exception e) {
                }
            } else {
                PaymentTransaction a = m15282a(c, b, b2);
                this.f14879a.m13270b(a);
                this.f14879a.m13267a(a);
                this.f14881c.m15006a();
                m15285a(c);
                bundle.putParcelable("newPaymentTransaction", a);
            }
        } else {
            try {
                this.f14883e.m15259a(String.valueOf(c.transferFbId));
            } catch (Exception e2) {
            }
        }
        return bundle;
    }

    public final void m15289a(Bundle bundle, DeltaWithSequenceId<DeltaPaymentWrapper> deltaWithSequenceId) {
        DeltaNewTransfer c = ((DeltaPaymentWrapper) deltaWithSequenceId.a).m16092c();
        PaymentTransaction paymentTransaction = (PaymentTransaction) bundle.getParcelable("newPaymentTransaction");
        if (paymentTransaction != null) {
            this.f14880b.m13190a(paymentTransaction);
            if (c.offlineThreadingId != null) {
                this.f14880b.m13189a(c.offlineThreadingId.longValue(), paymentTransaction);
            }
            this.f14881c.m15007a(paymentTransaction.f13234g, Long.parseLong(paymentTransaction.f13229b));
        }
    }

    private PaymentTransaction m15282a(DeltaNewTransfer deltaNewTransfer, Contact contact, Contact contact2) {
        TransferStatus fromString;
        Sender sender = new Sender(contact.b(), contact.e().i(), contact.s());
        Receiver receiver = new Receiver(contact2.b(), contact2.e().i(), contact2.s());
        if (m15287b(deltaNewTransfer)) {
            fromString = TransferStatus.fromString((String) ReceiverStatus.f15987b.get(deltaNewTransfer.receiverStatus));
        } else {
            fromString = TransferStatus.fromString((String) SenderStatus.f15989b.get(deltaNewTransfer.senderStatus));
        }
        TransferStatus transferStatus = fromString;
        String a = (transferStatus == TransferStatus.R_COMPLETED || transferStatus == TransferStatus.S_COMPLETED) ? m15284a(deltaNewTransfer.timestampMs) : null;
        Amount amount = new Amount(deltaNewTransfer.currency, deltaNewTransfer.amountOffset.intValue(), deltaNewTransfer.amount.intValue());
        Builder builder = new Builder();
        builder.f13469a = deltaNewTransfer.memoText;
        TransferContextModel a2 = builder.m13943a();
        PaymentTransactionBuilder newBuilder = PaymentTransaction.newBuilder();
        newBuilder.f13243a = String.valueOf(deltaNewTransfer.transferFbId);
        newBuilder = newBuilder;
        newBuilder.f13245c = sender;
        PaymentTransactionBuilder paymentTransactionBuilder = newBuilder;
        paymentTransactionBuilder.f13246d = receiver;
        paymentTransactionBuilder = paymentTransactionBuilder;
        paymentTransactionBuilder.f13247e = m15284a(deltaNewTransfer.timestampMs);
        paymentTransactionBuilder = paymentTransactionBuilder;
        paymentTransactionBuilder.f13250h = m15284a(deltaNewTransfer.timestampMs);
        paymentTransactionBuilder = paymentTransactionBuilder;
        paymentTransactionBuilder.f13249g = a;
        PaymentTransactionBuilder paymentTransactionBuilder2 = paymentTransactionBuilder;
        paymentTransactionBuilder2.f13248f = transferStatus;
        paymentTransactionBuilder2 = paymentTransactionBuilder2;
        paymentTransactionBuilder2.f13251i = amount;
        paymentTransactionBuilder2 = paymentTransactionBuilder2;
        paymentTransactionBuilder2.f13253k = a2;
        paymentTransactionBuilder2 = paymentTransactionBuilder2;
        if (deltaNewTransfer.amountFBDiscount != null) {
            paymentTransactionBuilder2.f13252j = new Amount(deltaNewTransfer.currency, deltaNewTransfer.amountOffset.intValue(), deltaNewTransfer.amountFBDiscount.intValue());
        }
        return paymentTransactionBuilder2.m13534o();
    }

    private static String m15284a(Long l) {
        if (l == null) {
            return null;
        }
        return String.valueOf(TimeUnit.MILLISECONDS.toSeconds(l.longValue()));
    }

    private void m15285a(DeltaNewTransfer deltaNewTransfer) {
        this.f14885g.a(P2pPaymentsLogEvent.d("p2p_sync_delta", m15287b(deltaNewTransfer) ? "p2p_receive" : "p2p_send").w("DeltaNewTransfer").a(deltaNewTransfer.irisSeqId).a);
    }

    private boolean m15287b(DeltaNewTransfer deltaNewTransfer) {
        return this.f14882d.m15525a(String.valueOf(deltaNewTransfer.recipientFbId));
    }
}
