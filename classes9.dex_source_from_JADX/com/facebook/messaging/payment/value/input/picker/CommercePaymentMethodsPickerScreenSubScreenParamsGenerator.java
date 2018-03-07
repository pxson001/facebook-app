package com.facebook.messaging.payment.value.input.picker;

import android.content.Context;
import android.content.Intent;
import com.facebook.messaging.payment.method.input.MessengerPayCardFormParams;
import com.facebook.messaging.payment.method.input.MessengerPayCardFormParamsBuilder;
import com.facebook.messaging.payment.util.PaymentFlowTypeUtil;
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
import com.facebook.payments.paymentmethods.model.NewCreditCardOption;
import com.facebook.payments.paymentmethods.picker.PaymentMethodsPickerScreenSubScreenParamsGenerator;
import com.facebook.payments.paymentmethods.picker.PickerScreenParams;
import com.facebook.payments.paymentmethods.picker.model.PaymentMethodsPickerScreenData;
import com.facebook.payments.paymentmethods.picker.model.PickerScreenData;
import com.google.common.collect.FluentIterable;
import javax.inject.Inject;

/* compiled from: eface31ddeee6fe78bf06d3504453490 */
public class CommercePaymentMethodsPickerScreenSubScreenParamsGenerator extends PaymentMethodsPickerScreenSubScreenParamsGenerator {
    @Inject
    public CommercePaymentMethodsPickerScreenSubScreenParamsGenerator(Context context) {
        super(context);
    }

    public final Intent mo654a(PickerScreenData pickerScreenData, PickerScreenParams pickerScreenParams) {
        CardFormAnalyticsParamsBuilder newBuilder = CardFormAnalyticsParams.newBuilder();
        newBuilder.b = pickerScreenParams.mo743a().m18791b().f3966a;
        CardFormAnalyticsParams c = newBuilder.c();
        NewCreditCardOption newCreditCardOption = (NewCreditCardOption) FluentIterable.a(((PaymentMethodsPickerScreenData) pickerScreenData).f18844a.e).a(NewCreditCardOption.class).a().orNull();
        Builder a = PaymentsDecoratorParams.newBuilder().a(pickerScreenData.mo752a().mo743a().f18784a.f18812a);
        a.a = PaymentsDecoratorAnimation.MODAL_BOTTOM;
        PaymentsDecoratorParams c2 = a.c();
        CardFormStyleParams.Builder newBuilder2 = CardFormStyleParams.newBuilder();
        newBuilder2.c = c2;
        CardFormStyleParams.Builder builder = newBuilder2;
        if (newCreditCardOption != null) {
            builder.d = newCreditCardOption.b;
        }
        CardFormCommonParamsBuilder newBuilder3 = CardFormCommonParams.newBuilder();
        newBuilder3.a = CardFormStyle.MESSENGER_PAY_ADD;
        newBuilder3 = newBuilder3;
        newBuilder3.b = c;
        newBuilder3 = newBuilder3;
        newBuilder3.c = builder.e();
        newBuilder3 = newBuilder3;
        newBuilder3.e = PaymentFlowTypeUtil.m15515a(true);
        newBuilder3 = newBuilder3;
        MessengerPayCardFormParamsBuilder newBuilder4 = MessengerPayCardFormParams.newBuilder();
        newBuilder4.f13042f = newBuilder3.f();
        MessengerPayCardFormParamsBuilder messengerPayCardFormParamsBuilder = newBuilder4;
        messengerPayCardFormParamsBuilder.f13041e = true;
        return CardFormActivity.a(this.f15846a, messengerPayCardFormParamsBuilder.m13336j());
    }
}
