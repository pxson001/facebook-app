package com.facebook.graphql.calls;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializable;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;

/* compiled from: real_time_activity_actors */
public final class CrowdsourcingCurrentValueVoteInputData extends GraphQlMutationCallInput {

    /* compiled from: real_time_activity_actors */
    public enum Sentiment implements JsonSerializable {
        AGREE("agree"),
        DISAGREE("disagree"),
        UNSURE("unsure"),
        SPAM("spam"),
        FIVE_VERY_GOOD("five_very_good"),
        FIVE_GOOD("five_good"),
        FIVE_NEUTRAL("five_neutral"),
        FIVE_BAD("five_bad"),
        FIVE_VERY_BAD("five_very_bad"),
        MCSS_AGREE("mcss_agree"),
        MCSS_DISAGREE("mcss_disagree"),
        MCSS_UNSURE("mcss_unsure"),
        CHOSE_1("chose_1"),
        CHOSE_2("chose_2");
        
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
