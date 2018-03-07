package com.facebook.graphql.calls;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializable;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;

/* compiled from: politician_page_chaining_pivot */
public final class SuggestifierQuestionVoteInputData extends GraphQlMutationCallInput {

    /* compiled from: politician_page_chaining_pivot */
    public final class LocationData extends GraphQlCallInput {
    }

    /* compiled from: politician_page_chaining_pivot */
    public enum Sentiment implements JsonSerializable {
        AGREE("agree"),
        DISAGREE("disagree"),
        DISMISS("dismiss");
        
        protected final String serverValue;

        private Sentiment(String str) {
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
