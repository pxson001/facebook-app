package com.facebook.messaging.payment.protocol.cards.parser;

import com.facebook.common.util.JSONUtil;
import com.facebook.messaging.payment.service.model.cards.NewNetBankingOption;
import com.facebook.messaging.payment.service.model.pay.SendPaymentBankDetails;
import com.facebook.payments.paymentmethods.model.NewPaymentOption;
import com.facebook.payments.paymentmethods.model.NewPaymentOptionType;
import com.facebook.payments.paymentmethods.picker.protocol.parser.NMORNewPaymentOptionParser;
import com.fasterxml.jackson.databind.JsonNode;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList.Builder;
import java.util.Iterator;

/* compiled from: followUpActionUrl */
public class NMORNewNetBankingOptionParser implements NMORNewPaymentOptionParser<NewNetBankingOption> {
    public final NewPaymentOption mo596a(JsonNode jsonNode) {
        boolean z = true;
        Preconditions.checkArgument(jsonNode.d("type"));
        Preconditions.checkArgument(NewPaymentOptionType.forValue(JSONUtil.b(jsonNode.b("type"))) == NewPaymentOptionType.NEW_NET_BANKING);
        String b = JSONUtil.b(jsonNode.b("provider"));
        Builder builder = new Builder();
        if (jsonNode.d("bank_info")) {
            JsonNode b2 = jsonNode.b("bank_info");
            Preconditions.checkNotNull(b2);
            Preconditions.checkArgument(b2.h());
            if (b2.e() == 0) {
                z = false;
            }
            Preconditions.checkArgument(z);
            Iterator it = b2.iterator();
            while (it.hasNext()) {
                JsonNode jsonNode2 = (JsonNode) it.next();
                builder.c(new SendPaymentBankDetails(JSONUtil.b(jsonNode2.b("code")), JSONUtil.b(jsonNode2.b("image")), JSONUtil.b(jsonNode2.b("redirect_url")), null, JSONUtil.b(jsonNode2.b("name"))));
            }
        }
        return new NewNetBankingOption(b, builder.b());
    }

    public final NewPaymentOptionType mo597a() {
        return NewPaymentOptionType.NEW_NET_BANKING;
    }
}
