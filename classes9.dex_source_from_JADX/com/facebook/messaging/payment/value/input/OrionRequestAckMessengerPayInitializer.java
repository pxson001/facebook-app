package com.facebook.messaging.payment.value.input;

import android.os.Bundle;
import com.facebook.flatbuffers.helpers.FlatBufferModelHelper;
import com.facebook.messaging.payment.currency.CurrencyFormatType;
import com.facebook.messaging.payment.currency.PaymentCurrencyUtil;
import com.facebook.messaging.payment.model.graphql.PaymentGraphQLModels.PaymentRequestModel;
import com.facebook.user.model.Name;
import com.facebook.user.model.UserKey;
import javax.inject.Inject;

/* compiled from: event_action_style */
public class OrionRequestAckMessengerPayInitializer implements MessengerPayInitializer {
    private final PaymentCurrencyUtil f15594a;
    private final OrionRequestAckMessengerPayLogger f15595b;

    @Inject
    public OrionRequestAckMessengerPayInitializer(PaymentCurrencyUtil paymentCurrencyUtil, OrionRequestAckMessengerPayLogger orionRequestAckMessengerPayLogger) {
        this.f15594a = paymentCurrencyUtil;
        this.f15595b = orionRequestAckMessengerPayLogger;
    }

    public final void mo610a(Bundle bundle, MessengerPayData messengerPayData) {
        PaymentRequestModel paymentRequestModel = (PaymentRequestModel) FlatBufferModelHelper.a(bundle, "payment_request");
        messengerPayData.m15750a(UserKey.b(paymentRequestModel.m13816k().m13879c()));
        messengerPayData.m15749a(new Name(paymentRequestModel.m13816k().lE_()));
        messengerPayData.m15746a(new MessengerPayAmount(this.f15594a.m13199a(CurrencyFormatType.NO_CURRENCY_SYMBOL_OR_EMPTY_DECIMALS, paymentRequestModel.m13811b().m13703a(), paymentRequestModel.m13811b().m13707b()), paymentRequestModel.m13811b().m13707b()));
        messengerPayData.m15753a(paymentRequestModel.m13814g());
        messengerPayData.m15744a(paymentRequestModel.ly_());
    }
}
