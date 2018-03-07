package com.facebook.messaging.payment.model;

import com.facebook.common.json.AutoGenJsonDeserializer;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.google.common.base.Objects;
import javax.annotation.concurrent.Immutable;

@AutoGenJsonDeserializer
@JsonDeserialize(using = PaymentTransactionEdgeNodeDeserializer.class)
@Immutable
/* compiled from: iab_origin */
public class PaymentTransactionEdgeNode {
    @JsonProperty("node")
    private final PaymentTransaction mPaymentTransaction = null;

    private PaymentTransactionEdgeNode() {
    }

    public String toString() {
        return Objects.toStringHelper(this).add("node", this.mPaymentTransaction).toString();
    }
}
