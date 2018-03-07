package com.facebook.graphql.calls;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializable;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;

/* compiled from: reaction */
public final class DailyDialogueUpdateInputData extends GraphQlMutationCallInput {

    /* compiled from: reaction */
    public enum LightweightUnitType implements JsonSerializable {
        MISSED_STORIES("MISSED_STORIES"),
        MUSIC_LIFE_EVENT("MUSIC_LIFE_EVENT"),
        QP("QP"),
        SAVE("SAVE"),
        SIMPLE_GREETING("SIMPLE_GREETING"),
        TRENDING_MUSIC("TRENDING_MUSIC"),
        WEATHER("WEATHER");
        
        protected final String serverValue;

        private LightweightUnitType(String str) {
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

    /* compiled from: reaction */
    public enum MutationType implements JsonSerializable {
        VIEW("VIEW"),
        DISMISS("DISMISS");
        
        protected final String serverValue;

        private MutationType(String str) {
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

    /* compiled from: reaction */
    public enum ProductName implements JsonSerializable {
        APP_UPGRADE_QP("APP_UPGRADE_QP"),
        BIRTHDAY_REMINDER("BIRTHDAY_REMINDER"),
        BIRTHDAY_REMINDER_PUSH("BIRTHDAY_REMINDER_PUSH"),
        CHECKUP_QP("CHECKUP_QP"),
        CONTACT_IMPORTER("CONTACT_IMPORTER"),
        CULTURAL_MOMENTS_QP("CULTURAL_MOMENTS_QP"),
        DUMMY_STORY("DUMMY_STORY"),
        FB404_PAGE("FB404_PAGE"),
        FRIEND_BIRTHDAY_PROMOTION("FRIEND_BIRTHDAY_PROMOTION"),
        GOOD_MORNING("GOOD_MORNING"),
        LIFE_EVENT_REACTION_QP("LIFE_EVENT_REACTION_QP"),
        FLASHBACK("FLASHBACK"),
        LOGOUT_HOMEPAGE("LOGOUT_HOMEPAGE"),
        MISSED_POST("MISSED_POST"),
        PHONE_NUMBER_ACQUISITION_QP("PHONE_NUMBER_ACQUISITION_QP"),
        PHONE_NUMBER_VERIFICATION_QP("PHONE_NUMBER_VERIFICATION_QP"),
        PRIVACY_VIEW_AS_UPSELL("PRIVACY_VIEW_AS_UPSELL"),
        PRIVACY_TOP_OF_FEED("PRIVACY_TOP_OF_FEED"),
        PRODUCTION_PROMPTS("PRODUCTION_PROMPTS"),
        SECURITY_CHECKUP_QP("SECURITY_CHECKUP_QP"),
        SEE_FIRST_QP("SEE_FIRST_QP"),
        THROWBACK_NOTIFICATION("THROWBACK_NOTIFICATION"),
        THROWBACK_PROMOTION("THROWBACK_PROMOTION"),
        UNKNOWN_QP_PRODUCT("UNKNOWN_QP_PRODUCT");
        
        protected final String serverValue;

        private ProductName(String str) {
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

    public final DailyDialogueUpdateInputData m4360a(ProductName productName) {
        a("product_name", productName);
        return this;
    }

    public final DailyDialogueUpdateInputData m4359a(MutationType mutationType) {
        a("mutation_type", mutationType);
        return this;
    }

    public final DailyDialogueUpdateInputData m4358a(LightweightUnitType lightweightUnitType) {
        a("lightweight_unit_type", lightweightUnitType);
        return this;
    }

    public final DailyDialogueUpdateInputData m4361a(String str) {
        a("lightweight_unit_id", str);
        return this;
    }

    public final DailyDialogueUpdateInputData m4362b(String str) {
        a("lightweight_extra", str);
        return this;
    }
}
