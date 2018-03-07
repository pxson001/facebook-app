package com.facebook.graphql.calls;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializable;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;

/* compiled from: redirection_info */
public final class CommentPlaceRecommendationDeleteInputData extends GraphQlMutationCallInput {

    /* compiled from: redirection_info */
    public enum RecommendationTypes implements JsonSerializable {
        PENDING_PLACE("PENDING_PLACE"),
        CONFIRMED_PLACE("CONFIRMED_PLACE");
        
        protected final String serverValue;

        private RecommendationTypes(String str) {
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
