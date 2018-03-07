package com.facebook.messaging.payment.util;

import com.facebook.messaging.payment.model.graphql.PaymentGraphQLInterfaces.MailingAddressInfo;
import com.facebook.messaging.payment.model.graphql.PaymentGraphQLModels.MailingAddressInfoModel;
import com.facebook.messaging.payment.model.graphql.PaymentGraphQLModels.StreetAddressInfoModel;
import com.facebook.payments.shipping.model.MailingAddress;
import com.facebook.payments.shipping.model.SimpleMailingAddress;
import com.facebook.payments.shipping.model.SimpleMailingAddressBuilder;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import java.util.ArrayList;
import javax.annotation.Nullable;

/* compiled from: f241bf0e75c6d8369ce15e0cc9a5085f */
public class PaymentAddressUtil {
    public static ImmutableList<MailingAddress> m15514a(ArrayList<MailingAddressInfo> arrayList) {
        Builder builder = ImmutableList.builder();
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            builder.c(m15513a((MailingAddressInfoModel) arrayList.get(i)));
        }
        return builder.b();
    }

    @Nullable
    public static MailingAddress m15513a(@Nullable MailingAddressInfoModel mailingAddressInfoModel) {
        if (mailingAddressInfoModel == null) {
            return null;
        }
        StreetAddressInfoModel b = mailingAddressInfoModel.m13672b();
        SimpleMailingAddressBuilder newBuilder = SimpleMailingAddress.newBuilder();
        newBuilder.f19012a = mailingAddressInfoModel.m13674d();
        newBuilder = newBuilder;
        newBuilder.f19013b = b.m13907a();
        newBuilder = newBuilder;
        newBuilder.f19014c = b.m13911g();
        newBuilder = newBuilder;
        newBuilder.f19015d = b.m13908b();
        newBuilder = newBuilder;
        newBuilder.f19016e = b.m13909c();
        newBuilder = newBuilder;
        newBuilder.f19017f = b.lG_();
        newBuilder = newBuilder;
        newBuilder.f19018g = b.m13910d();
        SimpleMailingAddressBuilder simpleMailingAddressBuilder = newBuilder;
        simpleMailingAddressBuilder.f19019h = mailingAddressInfoModel.m13675g();
        simpleMailingAddressBuilder = simpleMailingAddressBuilder;
        simpleMailingAddressBuilder.f19020i = mailingAddressInfoModel.m13673c();
        simpleMailingAddressBuilder = simpleMailingAddressBuilder;
        simpleMailingAddressBuilder.f19021j = mailingAddressInfoModel.lp_();
        simpleMailingAddressBuilder = simpleMailingAddressBuilder;
        simpleMailingAddressBuilder.f19022k = mailingAddressInfoModel.lo_();
        return simpleMailingAddressBuilder.m18983l();
    }
}
