package com.facebook.messaging.payment.value.input.checkout;

import android.content.res.Resources;
import com.facebook.messaging.payment.currency.PaymentCurrencyUtil;
import com.facebook.messaging.payment.model.graphql.PaymentGraphQLModels.PaymentPlatformContextModel;
import com.facebook.messaging.payment.model.graphql.PaymentGraphQLModels.PaymentPlatformItemModel;
import com.facebook.messaging.payment.model.graphql.PaymentGraphQLModels.PaymentPlatformItemModel.PlatformImagesModel;
import com.facebook.messaging.payment.model.graphql.PaymentGraphQLModels.PaymentShippingOptionModel;
import com.facebook.payments.checkout.SimpleCheckoutManager;
import com.facebook.payments.checkout.model.CheckoutData;
import com.facebook.payments.checkout.recyclerview.CheckoutRow;
import com.facebook.payments.checkout.recyclerview.CheckoutRowType;
import com.facebook.payments.checkout.recyclerview.PriceTableCheckoutRow;
import com.facebook.payments.checkout.recyclerview.PriceTableRowView.RowData;
import com.facebook.payments.checkout.recyclerview.SimpleCheckoutRowsGenerator;
import com.facebook.payments.model.CurrencyAmount;
import com.facebook.payments.model.PriceFormatter;
import com.facebook.payments.ui.SingleItemInfoViewParams;
import com.facebook.payments.ui.SingleItemInfoViewParamsBuilder;
import com.google.common.base.Optional;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSortedMap;
import com.google.common.collect.ImmutableSortedMap.Builder;
import com.google.common.collect.Iterables;
import java.util.Iterator;
import java.util.Map.Entry;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: endTimeSeconds */
public class MessengerCommerceCheckoutRowsGenerator extends SimpleCheckoutRowsGenerator {
    private final PaymentCurrencyUtil f15764b;

    @Inject
    public MessengerCommerceCheckoutRowsGenerator(Resources resources, SimpleCheckoutManager simpleCheckoutManager, PaymentCurrencyUtil paymentCurrencyUtil) {
        super(resources, simpleCheckoutManager);
        this.f15764b = paymentCurrencyUtil;
    }

    protected final ImmutableSortedMap<Integer, CheckoutRowType> mo630b(CheckoutData checkoutData) {
        Builder b = ImmutableSortedMap.b();
        b.a(Integer.valueOf(1), CheckoutRowType.SINGLE_ITEM_INFO);
        Iterator it = super.mo630b(checkoutData).entrySet().iterator();
        while (it.hasNext()) {
            Entry entry = (Entry) it.next();
            b.a(Integer.valueOf(((Integer) entry.getKey()).intValue() + 1), entry.getValue());
        }
        return b.a();
    }

    @Nullable
    protected final CheckoutRow mo629a(CheckoutRowType checkoutRowType, CheckoutData checkoutData) {
        switch (checkoutRowType) {
            case SINGLE_ITEM_INFO:
                CheckoutRow checkoutRow = null;
                PaymentPlatformContextModel paymentPlatformContextModel = (PaymentPlatformContextModel) checkoutData.mo726j();
                if (!(paymentPlatformContextModel == null || paymentPlatformContextModel.m13757g() == null)) {
                    String str;
                    PaymentPlatformItemModel g = paymentPlatformContextModel.m13757g();
                    PlatformImagesModel platformImagesModel = (PlatformImagesModel) Iterables.a(g.lt_(), null);
                    ImmutableList d = g.m13781d();
                    StringBuilder stringBuilder = new StringBuilder();
                    for (int i = 0; i < d.size(); i++) {
                        stringBuilder.append((String) d.get(i));
                        if (i < d.size() - 1) {
                            stringBuilder.append(" · ");
                        }
                    }
                    SingleItemInfoViewParamsBuilder newBuilder = SingleItemInfoViewParams.newBuilder();
                    if (platformImagesModel == null) {
                        str = null;
                    } else {
                        str = platformImagesModel.m13774a();
                    }
                    newBuilder.a = str;
                    SingleItemInfoViewParamsBuilder singleItemInfoViewParamsBuilder = newBuilder;
                    singleItemInfoViewParamsBuilder.b = this.f15707a.getDimension(2131429257);
                    singleItemInfoViewParamsBuilder = singleItemInfoViewParamsBuilder;
                    singleItemInfoViewParamsBuilder.c = g.m13782g();
                    singleItemInfoViewParamsBuilder = singleItemInfoViewParamsBuilder;
                    singleItemInfoViewParamsBuilder.d = stringBuilder.toString();
                    checkoutRow = new MessengerCommerceItemInfoCheckoutRow(paymentPlatformContextModel.m13757g().lv_(), singleItemInfoViewParamsBuilder.f());
                }
                return checkoutRow;
            default:
                return super.mo629a(checkoutRowType, checkoutData);
        }
    }

    @Nullable
    protected final CheckoutRow mo643d(CheckoutData checkoutData) {
        Optional h = checkoutData.mo724h();
        if (h == null) {
            return super.mo643d(checkoutData);
        }
        CurrencyAmount a;
        CurrencyAmount a2;
        CurrencyAmount a3;
        CurrencyAmount a4;
        if (h.isPresent()) {
            PaymentShippingOptionModel paymentShippingOptionModel = ((MessengerCommerceShippingOption) h.get()).f15783a;
            a = this.f15764b.m13197a(paymentShippingOptionModel.m13827d(), paymentShippingOptionModel.m13823a());
            a2 = this.f15764b.m13197a(paymentShippingOptionModel.lA_(), paymentShippingOptionModel.m13823a());
            a3 = this.f15764b.m13197a(paymentShippingOptionModel.m13826c(), paymentShippingOptionModel.m13823a());
            a4 = this.f15764b.m13197a(paymentShippingOptionModel.m13828g(), paymentShippingOptionModel.m13823a());
        } else {
            PaymentPlatformItemModel g = ((PaymentPlatformContextModel) checkoutData.mo726j()).m13757g();
            a4 = this.f15764b.m13197a(g.lu_().m13691a(), g.lu_().m13695b());
            a3 = null;
            a2 = null;
            a = a4;
        }
        return new PriceTableCheckoutRow(ImmutableList.of(new RowData(this.f15707a.getString(2131240548), PriceFormatter.a(a)), new RowData(this.f15707a.getString(2131240549), a2 != null ? PriceFormatter.a(a2) : this.f15707a.getString(2131240551)), new RowData(this.f15707a.getString(2131240550), a3 != null ? PriceFormatter.a(a3) : this.f15707a.getString(2131240551)), new RowData(this.f15707a.getString(2131240251), PriceFormatter.a(a4), true)));
    }

    protected final boolean mo642c(CheckoutData checkoutData) {
        boolean z;
        if (checkoutData.mo722f() == null || !checkoutData.mo722f().isPresent()) {
            z = false;
        } else {
            z = true;
        }
        boolean z2;
        if (checkoutData.mo724h() == null || !checkoutData.mo724h().isPresent()) {
            z2 = false;
        } else {
            z2 = true;
        }
        if (super.mo642c(checkoutData) && r0 && r3) {
            return true;
        }
        return false;
    }
}
