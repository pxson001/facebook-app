package com.facebook.messaging.payment.thread;

import com.facebook.fbservice.service.DataFreshnessParam;
import com.facebook.messaging.model.messages.Message;
import com.facebook.messaging.payment.cache.PaymentCardCache;
import com.facebook.messaging.payment.cache.PaymentRequestCache;
import com.facebook.messaging.payment.cache.PaymentTransactionCache;
import com.facebook.messaging.payment.model.PaymentCard;
import com.facebook.messaging.payment.model.PaymentTransaction;
import com.facebook.messaging.payment.model.graphql.PaymentGraphQLModels.PaymentRequestModel;
import com.facebook.messaging.payment.protocol.PaymentProtocolUtil;
import com.facebook.messaging.payment.thread.model.ThreadPaymentTransactionData;
import com.google.common.base.Absent;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: failed_fetch_user_communication */
public class PaymentRowMessageItemHelper {
    public final PaymentProtocolUtil f14990a;
    private final PaymentCardCache f14991b;
    public final PaymentTransactionCache f14992c;
    public final PaymentRequestCache f14993d;

    @Inject
    public PaymentRowMessageItemHelper(PaymentProtocolUtil paymentProtocolUtil, PaymentTransactionCache paymentTransactionCache, PaymentRequestCache paymentRequestCache, PaymentCardCache paymentCardCache) {
        this.f14990a = paymentProtocolUtil;
        this.f14992c = paymentTransactionCache;
        this.f14993d = paymentRequestCache;
        this.f14991b = paymentCardCache;
    }

    public final ThreadPaymentTransactionData m15379a(Message message) {
        boolean z = (message.B == null && (message.u == null || message.u.c == null)) ? false : true;
        Preconditions.checkArgument(z);
        PaymentTransaction paymentTransaction = null;
        if (message.B != null) {
            String str = message.B.a;
            PaymentTransaction a = this.f14992c.m13187a(str);
            if (a == null) {
                this.f14990a.m14958a(str, DataFreshnessParam.STALE_DATA_OKAY);
            }
            paymentTransaction = a;
        } else if (message.n != null) {
            paymentTransaction = (PaymentTransaction) this.f14992c.m13188a(Long.parseLong(message.n)).orNull();
        }
        PaymentCardCache paymentCardCache = this.f14991b;
        Optional optional = paymentCardCache.f12822c == null ? paymentCardCache.f12822c : !paymentCardCache.f12822c.isPresent() ? Absent.INSTANCE : ((PaymentCard) paymentCardCache.f12822c.get()).m13513t() ? paymentCardCache.f12822c : Absent.INSTANCE;
        Optional optional2 = optional;
        Optional b = this.f14991b.m13165b();
        if (optional2 == null || !b.isPresent()) {
            this.f14990a.m14940a();
        }
        return new ThreadPaymentTransactionData(optional2, b, paymentTransaction);
    }

    @Nullable
    public final PaymentRequestModel m15380b(Message message) {
        Preconditions.checkArgument(message.C != null);
        String str = message.C.a;
        PaymentRequestModel a = this.f14993d.a(str);
        if (a == null) {
            this.f14990a.m14969f(str);
        }
        return a;
    }
}
