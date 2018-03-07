package com.facebook.messaging.payment.protocol.transactions;

import com.facebook.inject.InjectorLike;
import com.facebook.messaging.payment.model.Amount;
import com.facebook.messaging.payment.model.CommerceOrder;
import com.facebook.messaging.payment.model.PaymentTransaction;
import com.facebook.messaging.payment.model.PaymentTransactionBuilder;
import com.facebook.messaging.payment.model.PaymentType;
import com.facebook.messaging.payment.model.Receiver;
import com.facebook.messaging.payment.model.Sender;
import com.facebook.messaging.payment.model.TransferStatus;
import com.facebook.messaging.payment.model.graphql.PaymentGraphQLModels.PaymentTransactionModel;
import com.facebook.messaging.payment.util.PaymentTransactionUtil;
import javax.inject.Inject;

/* compiled from: flowContextId */
public class PaymentTransactionQueryUtils {
    private final PaymentTransactionUtil f14612a;

    public static PaymentTransactionQueryUtils m15141b(InjectorLike injectorLike) {
        return new PaymentTransactionQueryUtils(PaymentTransactionUtil.m15519a(injectorLike));
    }

    @Inject
    public PaymentTransactionQueryUtils(PaymentTransactionUtil paymentTransactionUtil) {
        this.f14612a = paymentTransactionUtil;
    }

    public final PaymentTransaction m15142a(PaymentTransactionModel paymentTransactionModel) {
        PaymentTransactionBuilder newBuilder = PaymentTransaction.newBuilder();
        newBuilder.f13243a = paymentTransactionModel.lC_();
        newBuilder = newBuilder;
        newBuilder.f13244b = PaymentType.fromString(paymentTransactionModel.m13837b().e());
        newBuilder = newBuilder;
        newBuilder.f13247e = String.valueOf(paymentTransactionModel.lB_());
        newBuilder = newBuilder;
        newBuilder.f13250h = String.valueOf(paymentTransactionModel.m13848q());
        newBuilder = newBuilder;
        newBuilder.f13253k = paymentTransactionModel.m13855x();
        newBuilder = newBuilder;
        newBuilder.f13249g = String.valueOf(paymentTransactionModel.m13840g());
        newBuilder = newBuilder;
        newBuilder.f13256n = paymentTransactionModel.m13841j();
        PaymentTransactionBuilder paymentTransactionBuilder = newBuilder;
        if (paymentTransactionModel.m13854w() != null) {
            paymentTransactionBuilder.f13245c = new Sender(paymentTransactionModel.m13854w().m13879c(), paymentTransactionModel.m13854w().lE_(), paymentTransactionModel.m13854w().m13880d());
        }
        if (paymentTransactionModel.m13853v() != null) {
            paymentTransactionBuilder.f13246d = new Receiver(paymentTransactionModel.m13853v().m13879c(), paymentTransactionModel.m13853v().lE_(), paymentTransactionModel.m13853v().m13880d());
        }
        if (paymentTransactionModel.m13849r() != null) {
            paymentTransactionBuilder.f13251i = new Amount(paymentTransactionModel.m13849r().m13707b(), paymentTransactionModel.m13849r().m13708c(), paymentTransactionModel.m13849r().m13703a());
        }
        if (paymentTransactionModel.m13850s() != null) {
            paymentTransactionBuilder.f13252j = new Amount(paymentTransactionModel.m13850s().m13707b(), paymentTransactionModel.m13850s().m13708c(), paymentTransactionModel.m13850s().m13703a());
        }
        if (!(paymentTransactionModel.m13853v() == null || paymentTransactionModel.m13844m() == null || paymentTransactionModel.m13846o() == null)) {
            TransferStatus fromString;
            if (this.f14612a.m15525a(paymentTransactionModel.m13853v().m13879c())) {
                fromString = TransferStatus.fromString(paymentTransactionModel.m13844m().toString());
            } else {
                fromString = TransferStatus.fromString(paymentTransactionModel.m13846o().toString());
            }
            paymentTransactionBuilder.f13248f = fromString;
        }
        if (paymentTransactionModel.m13852u() != null) {
            paymentTransactionBuilder.f13254l = paymentTransactionModel.m13852u();
        }
        if (paymentTransactionModel.m13851t() != null) {
            paymentTransactionBuilder.f13255m = new CommerceOrder(paymentTransactionModel.m13851t().m13575c(), paymentTransactionModel.m13851t().ln_(), paymentTransactionModel.m13851t().m13574b(), paymentTransactionModel.m13851t().m13577g(), paymentTransactionModel.m13851t().m13576d());
        }
        return paymentTransactionBuilder.m13534o();
    }
}
