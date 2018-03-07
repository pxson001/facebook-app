package com.facebook.graphql.calls;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializable;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;

/* compiled from: pymk_ci */
public final class GravityNegativeFeedbackInputData extends GraphQlMutationCallInput {

    /* compiled from: pymk_ci */
    public enum FeedbackType implements JsonSerializable {
        INCORRECT_LOCATION("INCORRECT_LOCATION"),
        SINGLE_PAGE_OPT_OUT("SINGLE_PAGE_OPT_OUT"),
        ANNOYING("ANNOYING");
        
        protected final String serverValue;

        private FeedbackType(String str) {
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

    /* compiled from: pymk_ci */
    public final class LocationData extends GraphQlCallInput {
        public final LocationData m4426c(Integer num) {
            a("client_current_time", num);
            return this;
        }
    }
}
