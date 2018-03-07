package com.facebook.messaging.payment.protocol.cards.parser;

import com.facebook.common.util.JSONUtil;
import com.facebook.messaging.payment.service.model.cards.NewManualTransferOption;
import com.facebook.payments.paymentmethods.model.NewPaymentOption;
import com.facebook.payments.paymentmethods.model.NewPaymentOptionType;
import com.facebook.payments.paymentmethods.picker.protocol.parser.NMORNewPaymentOptionParser;
import com.fasterxml.jackson.databind.JsonNode;
import com.google.common.base.Preconditions;

/* compiled from: follow_up_action_button_text */
public class NMORNewManualTransferOptionParser implements NMORNewPaymentOptionParser<NewManualTransferOption> {
    public final NewPaymentOption mo596a(JsonNode jsonNode) {
        String b;
        String b2;
        String str = null;
        Preconditions.checkArgument(jsonNode.d("type"));
        Preconditions.checkArgument(NewPaymentOptionType.forValue(JSONUtil.b(jsonNode.b("type"))) == NewPaymentOptionType.NEW_MANUAL_TRANSFER);
        String b3 = JSONUtil.b(jsonNode.b("title"));
        if (jsonNode.d("manual_transfer_info")) {
            JsonNode b4 = jsonNode.b("manual_transfer_info");
            b = JSONUtil.b(b4.b("description"));
            str = JSONUtil.b(b4.b("transfer_option_id"));
            b2 = JSONUtil.b(b4.b("invoice_id"));
        } else {
            b2 = null;
            b = null;
        }
        return new NewManualTransferOption(b3, b, str, b2);
    }

    public final NewPaymentOptionType mo597a() {
        return NewPaymentOptionType.NEW_MANUAL_TRANSFER;
    }
}
