package com.facebook.messaging.payment.value.input.checkout;

import android.content.res.Resources;
import com.facebook.messaging.payment.value.input.MoneyPennyItemParams;
import com.facebook.payments.checkout.SimpleCheckoutManager;
import com.facebook.payments.checkout.model.CheckoutData;
import com.facebook.payments.checkout.recyclerview.CheckoutRow;
import com.facebook.payments.checkout.recyclerview.CheckoutRowType;
import com.facebook.payments.checkout.recyclerview.SimpleCheckoutRowsGenerator;
import com.facebook.payments.checkout.recyclerview.SingleItemInfoCheckoutRow;
import com.facebook.payments.ui.SingleItemInfoViewParams;
import com.facebook.payments.ui.SingleItemInfoViewParamsBuilder;
import com.google.common.collect.ImmutableSortedMap;
import com.google.common.collect.ImmutableSortedMap.Builder;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: err_code */
public class MCheckoutRowsGenerator extends SimpleCheckoutRowsGenerator {
    @Inject
    public MCheckoutRowsGenerator(Resources resources, SimpleCheckoutManager simpleCheckoutManager) {
        super(resources, simpleCheckoutManager);
    }

    protected final ImmutableSortedMap<Integer, CheckoutRowType> mo630b(CheckoutData checkoutData) {
        Builder b = ImmutableSortedMap.b();
        b.a(Integer.valueOf(1), CheckoutRowType.SINGLE_ITEM_INFO);
        b.a(Integer.valueOf(2), CheckoutRowType.DESCRIPTION);
        b.a(Integer.valueOf(3), CheckoutRowType.PRICE_TABLE);
        b.a(Integer.valueOf(4), CheckoutRowType.ADD_PAYMENT_METHOD);
        b.a(Integer.valueOf(5), CheckoutRowType.PAYMENT_METHOD);
        b.a(Integer.valueOf(6), CheckoutRowType.TERMS_AND_POLICIES);
        return b.a();
    }

    @Nullable
    protected final CheckoutRow mo629a(CheckoutRowType checkoutRowType, CheckoutData checkoutData) {
        switch (checkoutRowType) {
            case DESCRIPTION:
                return new MDescriptionCheckoutRow(2131240530);
            case SINGLE_ITEM_INFO:
                MoneyPennyItemParams moneyPennyItemParams = ((MCheckoutParams) checkoutData.mo717a()).f15702b;
                SingleItemInfoViewParamsBuilder newBuilder = SingleItemInfoViewParams.newBuilder();
                newBuilder.a = moneyPennyItemParams.f15478b;
                newBuilder = newBuilder;
                newBuilder.b = this.f15707a.getDimension(2131429257);
                newBuilder = newBuilder;
                newBuilder.c = moneyPennyItemParams.f15479c;
                newBuilder = newBuilder;
                newBuilder.d = moneyPennyItemParams.f15480d;
                newBuilder = newBuilder;
                newBuilder.e = moneyPennyItemParams.f15481e;
                return new SingleItemInfoCheckoutRow(newBuilder.f());
            default:
                return super.mo629a(checkoutRowType, checkoutData);
        }
    }
}
