package com.facebook.messaging.payment.prefs.transactions;

import android.content.res.Resources;
import android.graphics.Typeface;
import com.facebook.messaging.payment.model.PaymentTransaction;
import com.facebook.messaging.payment.model.PaymentTransactionType;
import com.facebook.messaging.payment.util.PaymentTransactionUtil;
import com.facebook.messaging.util.date.MessagingDateUtil;
import com.google.common.base.Preconditions;
import javax.inject.Inject;

/* compiled from: gametime_header_ */
public class MPMessengerPayHistoryItemViewParamsFactory {
    public final Resources f14319a;
    public final MessagingDateUtil f14320b;
    private final PaymentTransactionUtil f14321c;

    @Inject
    public MPMessengerPayHistoryItemViewParamsFactory(Resources resources, MessagingDateUtil messagingDateUtil, PaymentTransactionUtil paymentTransactionUtil) {
        this.f14319a = resources;
        this.f14320b = messagingDateUtil;
        this.f14321c = paymentTransactionUtil;
    }

    public final MessengerPayHistoryItemViewParams m14728a(Object obj) {
        Preconditions.checkArgument(obj instanceof PaymentTransaction);
        PaymentTransaction paymentTransaction = (PaymentTransaction) obj;
        Preconditions.checkNotNull(paymentTransaction.f13241n);
        MessengerPayHistoryItemViewCommonParamsBuilder newBuilder = MessengerPayHistoryItemViewCommonParams.newBuilder();
        newBuilder.f14343a = PaymentTransactionType.MP;
        newBuilder = newBuilder;
        newBuilder.f14347e = Boolean.valueOf(this.f14321c.m15528d(paymentTransaction));
        newBuilder = newBuilder;
        newBuilder.f14344b = paymentTransaction.f13241n.m13473a();
        newBuilder = newBuilder;
        newBuilder.f14345c = paymentTransaction.f13237j;
        newBuilder = newBuilder;
        MessengerPayHistoryStatusViewParamsBuilder newBuilder2 = MessengerPayHistoryStatusViewParams.newBuilder();
        newBuilder2.f14387b = MessengerPayHistoryStatusViewState.COMPLETED;
        newBuilder2 = newBuilder2;
        newBuilder2.f14386a = Typeface.DEFAULT;
        newBuilder2 = newBuilder2;
        if (Long.parseLong(paymentTransaction.f13233f) * 1000 > 0) {
            newBuilder2.f14388c = this.f14319a.getString(2131240325, new Object[]{this.f14320b.a(r5)});
        } else {
            newBuilder2.f14388c = "";
        }
        newBuilder.f14346d = newBuilder2.m14774d();
        newBuilder = newBuilder;
        ProductMessengerPayHistoryItemViewParamsBuilder newBuilder3 = ProductMessengerPayHistoryItemViewParams.newBuilder();
        newBuilder3.f14411a = paymentTransaction.f13241n.m13475c();
        newBuilder3 = newBuilder3;
        newBuilder3.f14412b = 2130843366;
        newBuilder3 = newBuilder3;
        newBuilder3.f14413c = newBuilder.m14754f();
        return newBuilder3.m14799d();
    }
}
