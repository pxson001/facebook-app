package com.facebook.messaging.payment.model;

import com.facebook.messaging.payment.model.graphql.PaymentGraphQLModels.PlatformItemModel;
import com.facebook.messaging.payment.model.graphql.PaymentGraphQLModels.TransferContextModel;

/* compiled from: iab_user_disabled */
public class PaymentTransactionBuilder {
    public String f13243a;
    public PaymentType f13244b;
    public Sender f13245c;
    public Receiver f13246d;
    public String f13247e;
    public TransferStatus f13248f;
    public String f13249g;
    public String f13250h;
    public Amount f13251i;
    public Amount f13252j;
    public TransferContextModel f13253k;
    public PlatformItemModel f13254l;
    public CommerceOrder f13255m;
    public String f13256n;

    public static PaymentTransactionBuilder m13533a(PaymentTransaction paymentTransaction) {
        PaymentTransactionBuilder paymentTransactionBuilder = new PaymentTransactionBuilder();
        paymentTransactionBuilder.f13243a = paymentTransaction.f13229b;
        paymentTransactionBuilder = paymentTransactionBuilder;
        paymentTransactionBuilder.f13244b = paymentTransaction.f13230c;
        paymentTransactionBuilder = paymentTransactionBuilder;
        paymentTransactionBuilder.f13245c = paymentTransaction.f13231d;
        paymentTransactionBuilder = paymentTransactionBuilder;
        paymentTransactionBuilder.f13246d = paymentTransaction.f13232e;
        paymentTransactionBuilder = paymentTransactionBuilder;
        paymentTransactionBuilder.f13248f = paymentTransaction.f13234g;
        paymentTransactionBuilder = paymentTransactionBuilder;
        paymentTransactionBuilder.f13251i = paymentTransaction.f13237j;
        paymentTransactionBuilder = paymentTransactionBuilder;
        paymentTransactionBuilder.f13252j = paymentTransaction.f13238k;
        paymentTransactionBuilder = paymentTransactionBuilder;
        paymentTransactionBuilder.f13247e = paymentTransaction.f13233f;
        paymentTransactionBuilder = paymentTransactionBuilder;
        paymentTransactionBuilder.f13249g = paymentTransaction.f13235h;
        paymentTransactionBuilder = paymentTransactionBuilder;
        paymentTransactionBuilder.f13250h = paymentTransaction.f13236i;
        paymentTransactionBuilder = paymentTransactionBuilder;
        paymentTransactionBuilder.f13253k = paymentTransaction.f13239l;
        paymentTransactionBuilder = paymentTransactionBuilder;
        paymentTransactionBuilder.f13254l = paymentTransaction.f13240m;
        paymentTransactionBuilder = paymentTransactionBuilder;
        paymentTransactionBuilder.f13255m = paymentTransaction.f13241n;
        paymentTransactionBuilder = paymentTransactionBuilder;
        paymentTransactionBuilder.f13256n = paymentTransaction.f13242o;
        return paymentTransactionBuilder;
    }

    public final PaymentTransaction m13534o() {
        return new PaymentTransaction(this);
    }
}
