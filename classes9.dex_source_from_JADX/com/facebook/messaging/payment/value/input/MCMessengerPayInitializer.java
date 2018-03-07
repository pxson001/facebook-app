package com.facebook.messaging.payment.value.input;

import android.os.Bundle;
import com.facebook.flatbuffers.helpers.FlatBufferModelHelper;
import com.facebook.messaging.payment.model.graphql.PaymentGraphQLModels.PaymentPlatformContextModel;
import com.facebook.messaging.payment.model.graphql.PaymentGraphQLModels.PaymentPlatformItemModel;
import com.facebook.messaging.payment.model.graphql.PaymentGraphQLModels.PaymentPlatformItemModel.Builder;
import com.facebook.messaging.payment.util.PaymentAddressUtil;
import com.google.common.base.Optional;

/* compiled from: external_request_id */
public class MCMessengerPayInitializer implements MessengerPayInitializer {
    public final void mo610a(Bundle bundle, MessengerPayData messengerPayData) {
        PaymentPlatformContextModel paymentPlatformContextModel = (PaymentPlatformContextModel) FlatBufferModelHelper.a(bundle, "payment_platform_context");
        Builder builder = new Builder();
        PaymentPlatformItemModel g = paymentPlatformContextModel.m13757g();
        Builder builder2 = new Builder();
        builder2.f13339a = g.m13785l();
        builder2.f13340b = g.m13786m();
        builder2.f13341c = g.m13779b();
        builder2.f13342d = g.m13780c();
        builder2.f13343e = g.m13781d();
        builder2.f13344f = g.m13787n();
        builder2.f13345g = g.m13782g();
        builder2.f13346h = g.lt_();
        builder2.f13347i = g.m13788o();
        builder2.f13348j = g.m13783j();
        builder2.f13349k = g.m13789p();
        Builder builder3 = builder2;
        builder3.f13347i = paymentPlatformContextModel.ls_().m13742a();
        messengerPayData.m15743a(builder3.m13763a());
        messengerPayData.m15761c(paymentPlatformContextModel.m13760l());
        messengerPayData.m15760c(Optional.fromNullable(paymentPlatformContextModel.m13758j()));
        messengerPayData.m15762d(Optional.fromNullable(PaymentAddressUtil.m15513a(paymentPlatformContextModel.lr_())));
    }
}
