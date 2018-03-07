package com.facebook.payments.paymentmethods.picker.protocol.parser;

import com.facebook.common.util.JSONUtil;
import com.facebook.payments.paymentmethods.model.NewPaymentOption;
import com.facebook.payments.paymentmethods.model.NewPaymentOptionType;
import com.fasterxml.jackson.databind.JsonNode;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.collect.RegularImmutableList;
import java.util.Iterator;
import javax.inject.Inject;

/* compiled from: beat_high_score */
public class NMORPaymentMethodsInfoParser extends MORPaymentMethodsInfoParser {
    private final PaymentMethodsInfoParserManager f18872a;

    @Inject
    public NMORPaymentMethodsInfoParser(PaymentMethodsInfoParserManager paymentMethodsInfoParserManager) {
        super(paymentMethodsInfoParserManager);
        this.f18872a = paymentMethodsInfoParserManager;
    }

    @VisibleForTesting
    final ImmutableList<NewPaymentOption> mo758b(JsonNode jsonNode) {
        if (!jsonNode.d("available_payment_methods_details")) {
            return RegularImmutableList.a;
        }
        JsonNode b = jsonNode.b("available_payment_methods_details");
        Preconditions.checkArgument(b.h());
        Builder builder = new Builder();
        Iterator it = b.iterator();
        while (it.hasNext()) {
            b = (JsonNode) it.next();
            Preconditions.checkArgument(b.d("type"));
            NewPaymentOptionType forValue = NewPaymentOptionType.forValue(JSONUtil.b(b.b("type")));
            for (NMORNewPaymentOptionParser nMORNewPaymentOptionParser : this.f18872a.f18876b) {
                if (nMORNewPaymentOptionParser.mo597a() == forValue) {
                    break;
                }
            }
            NMORNewPaymentOptionParser nMORNewPaymentOptionParser2 = null;
            NMORNewPaymentOptionParser nMORNewPaymentOptionParser3 = nMORNewPaymentOptionParser2;
            if (nMORNewPaymentOptionParser3 != null) {
                builder.c(nMORNewPaymentOptionParser3.mo596a(b));
            }
        }
        return builder.b();
    }
}
