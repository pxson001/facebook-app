package com.facebook.payments.paymentmethods.picker.protocol.parser;

import com.facebook.common.locale.Country;
import com.facebook.common.util.JSONUtil;
import com.facebook.payments.paymentmethods.model.NewPaymentOption;
import com.facebook.payments.paymentmethods.model.NewPaymentOptionType;
import com.facebook.payments.paymentmethods.model.PaymentMethod;
import com.facebook.payments.paymentmethods.model.PaymentMethodType;
import com.facebook.payments.paymentmethods.model.PaymentMethodsInfo;
import com.facebook.payments.paymentmethods.picker.protocol.parser.CommonPaymentMethodsInfoParser.Result;
import com.fasterxml.jackson.databind.JsonNode;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.collect.RegularImmutableList;
import java.util.Iterator;
import javax.inject.Inject;

/* compiled from: before_time */
public class MORPaymentMethodsInfoParser {
    private final PaymentMethodsInfoParserManager f18871a;

    public final PaymentMethodsInfo m18877a(JsonNode jsonNode) {
        Country country;
        String b = JSONUtil.b(jsonNode.b("country"));
        String b2 = JSONUtil.b(jsonNode.b("currency"));
        String b3 = JSONUtil.b(jsonNode.b("account_id"));
        if (b == null) {
            country = null;
        } else {
            country = Country.a(b);
        }
        Result result = new Result(country, b2, b3);
        ImmutableList b4 = mo758b(jsonNode);
        return new PaymentMethodsInfo(result.f18868a, result.f18869b, result.f18870c, m18876c(jsonNode), b4);
    }

    @Inject
    public MORPaymentMethodsInfoParser(PaymentMethodsInfoParserManager paymentMethodsInfoParserManager) {
        this.f18871a = paymentMethodsInfoParserManager;
    }

    @VisibleForTesting
    ImmutableList<NewPaymentOption> mo758b(JsonNode jsonNode) {
        if (!jsonNode.d("available_payment_methods")) {
            return RegularImmutableList.a;
        }
        JsonNode b = jsonNode.b("available_payment_methods");
        Preconditions.checkArgument(b.h());
        Builder builder = new Builder();
        Iterator it = b.iterator();
        while (it.hasNext()) {
            NewPaymentOptionType forValue = NewPaymentOptionType.forValue(JSONUtil.b((JsonNode) it.next()));
            for (MORNewPaymentOptionParser mORNewPaymentOptionParser : this.f18871a.f18877c) {
                if (mORNewPaymentOptionParser.mo757a() == forValue) {
                    break;
                }
            }
            MORNewPaymentOptionParser mORNewPaymentOptionParser2 = null;
            MORNewPaymentOptionParser mORNewPaymentOptionParser3 = mORNewPaymentOptionParser2;
            if (mORNewPaymentOptionParser3 != null) {
                builder.c(mORNewPaymentOptionParser3.mo756a(jsonNode));
            }
        }
        return builder.b();
    }

    @VisibleForTesting
    private ImmutableList<PaymentMethod> m18876c(JsonNode jsonNode) {
        if (!jsonNode.d("existing_payment_methods")) {
            return RegularImmutableList.a;
        }
        JsonNode b = jsonNode.b("existing_payment_methods");
        Preconditions.checkArgument(b.h());
        Builder builder = new Builder();
        Iterator it = b.iterator();
        while (it.hasNext()) {
            b = (JsonNode) it.next();
            Preconditions.checkArgument(b.d("type"));
            PaymentMethodType forValue = PaymentMethodType.forValue(JSONUtil.b(b.b("type")));
            for (PaymentMethodParser paymentMethodParser : this.f18871a.f18875a) {
                if (paymentMethodParser.mo755a() == forValue) {
                    break;
                }
            }
            PaymentMethodParser paymentMethodParser2 = null;
            PaymentMethodParser paymentMethodParser3 = paymentMethodParser2;
            if (paymentMethodParser3 != null) {
                builder.c(paymentMethodParser3.mo754a(b));
            }
        }
        return builder.b();
    }
}
