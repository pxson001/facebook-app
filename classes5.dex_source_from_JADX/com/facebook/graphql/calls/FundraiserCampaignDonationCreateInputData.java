package com.facebook.graphql.calls;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializable;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;

/* compiled from: pymk_nux */
public final class FundraiserCampaignDonationCreateInputData extends GraphQlMutationCallInput {

    /* compiled from: pymk_nux */
    public final class DonationAmount extends GraphQlCallInput {
    }

    /* compiled from: pymk_nux */
    public enum PaymentMethodType implements JsonSerializable {
        CREDIT_CARD("CREDIT_CARD"),
        PAYPAL("PAYPAL");
        
        protected final String serverValue;

        private PaymentMethodType(String str) {
            this.serverValue = str;
        }

        public final String toString() {
            return this.serverValue;
        }

        public final void serialize(JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            jsonGenerator.b(this.serverValue);
        }

        public final void serializeWithType(JsonGenerator jsonGenerator, SerializerProvider serializerProvider, TypeSerializer typeSerializer) {
            throw new UnsupportedOperationException("Serialization infrastructure does not support type serialization.");
        }
    }
}
