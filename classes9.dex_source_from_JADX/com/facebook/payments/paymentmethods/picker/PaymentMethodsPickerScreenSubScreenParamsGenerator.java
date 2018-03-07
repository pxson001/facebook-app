package com.facebook.payments.paymentmethods.picker;

import android.content.Context;
import android.content.Intent;
import com.facebook.payments.decorator.PaymentsDecoratorAnimation;
import com.facebook.payments.decorator.PaymentsDecoratorParams;
import com.facebook.payments.decorator.PaymentsDecoratorParams.Builder;
import com.facebook.payments.paymentmethods.cardform.CardFormActivity;
import com.facebook.payments.paymentmethods.cardform.CardFormAnalyticsParams;
import com.facebook.payments.paymentmethods.cardform.CardFormAnalyticsParamsBuilder;
import com.facebook.payments.paymentmethods.cardform.CardFormCommonParams;
import com.facebook.payments.paymentmethods.cardform.CardFormCommonParamsBuilder;
import com.facebook.payments.paymentmethods.cardform.CardFormStyle;
import com.facebook.payments.paymentmethods.cardform.CardFormStyleParams;
import com.facebook.payments.paymentmethods.picker.model.PickerScreenData;
import javax.inject.Inject;

/* compiled from: effective_response_timespan */
public class PaymentMethodsPickerScreenSubScreenParamsGenerator {
    protected final Context f15846a;

    @Inject
    public PaymentMethodsPickerScreenSubScreenParamsGenerator(Context context) {
        this.f15846a = context;
    }

    public Intent mo654a(PickerScreenData pickerScreenData, PickerScreenParams pickerScreenParams) {
        CardFormAnalyticsParamsBuilder newBuilder = CardFormAnalyticsParams.newBuilder();
        newBuilder.b = pickerScreenParams.mo743a().m18791b().f3966a;
        CardFormAnalyticsParams c = newBuilder.c();
        Builder a = PaymentsDecoratorParams.newBuilder().a(pickerScreenData.mo752a().mo743a().f18784a.f18812a);
        a.a = PaymentsDecoratorAnimation.MODAL_BOTTOM;
        PaymentsDecoratorParams c2 = a.c();
        CardFormStyleParams.Builder newBuilder2 = CardFormStyleParams.newBuilder();
        newBuilder2.c = c2;
        CardFormStyleParams e = newBuilder2.e();
        CardFormCommonParamsBuilder newBuilder3 = CardFormCommonParams.newBuilder();
        newBuilder3.a = CardFormStyle.SIMPLE;
        newBuilder3 = newBuilder3;
        newBuilder3.b = c;
        CardFormCommonParamsBuilder cardFormCommonParamsBuilder = newBuilder3;
        cardFormCommonParamsBuilder.e = pickerScreenParams.mo743a().f18787d;
        cardFormCommonParamsBuilder = cardFormCommonParamsBuilder;
        cardFormCommonParamsBuilder.c = e;
        return CardFormActivity.a(this.f15846a, cardFormCommonParamsBuilder.f());
    }
}
