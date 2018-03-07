package com.facebook.payments.paymentmethods.picker.protocol.parser;

import com.facebook.common.locale.Country;
import com.facebook.common.util.JSONUtil;
import com.facebook.payments.paymentmethods.model.BillingAddress;
import com.facebook.payments.paymentmethods.model.CreditCard;
import com.facebook.payments.paymentmethods.model.FbPaymentCardType;
import com.facebook.payments.paymentmethods.model.PaymentMethod;
import com.facebook.payments.paymentmethods.model.PaymentMethodType;
import com.fasterxml.jackson.databind.JsonNode;
import com.google.common.base.Preconditions;
import javax.annotation.Nullable;

/* compiled from: best_score */
public class CreditCardPaymentMethodParser implements PaymentMethodParser<CreditCard> {
    public final PaymentMethodType mo755a() {
        return PaymentMethodType.CREDIT_CARD;
    }

    public final PaymentMethod mo754a(JsonNode jsonNode) {
        Preconditions.checkArgument(jsonNode.d("cc"));
        JsonNode b = jsonNode.b("cc");
        return new CreditCard(JSONUtil.b(b.b("id")), JSONUtil.b(b.b("expiry_month")), JSONUtil.b(b.b("expiry_year")), JSONUtil.b(b.b("last4")), JSONUtil.b(b.b("first6")), FbPaymentCardType.forValue(JSONUtil.b(b.b("card_type"))), JSONUtil.b(b.b("readable_card_type")), JSONUtil.b(b.b("card_holder_name")), JSONUtil.g(b.b("is_enabled")), Boolean.valueOf(JSONUtil.g(b.b("is_cvv_tricky_bin"))), m18867c(b));
    }

    @Nullable
    private static BillingAddress m18867c(JsonNode jsonNode) {
        Country country = null;
        if (!jsonNode.d("billing_address")) {
            return null;
        }
        JsonNode b = jsonNode.b("billing_address");
        String b2 = JSONUtil.b(b.b("zip"));
        String b3 = JSONUtil.b(b.b("country_code"));
        if (b3 != null) {
            country = Country.a(b3);
        }
        return new BillingAddress(b2, country);
    }
}
