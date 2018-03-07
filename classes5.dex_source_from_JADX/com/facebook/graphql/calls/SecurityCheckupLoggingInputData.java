package com.facebook.graphql.calls;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializable;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;

/* compiled from: popular_at_report_not_helpful */
public final class SecurityCheckupLoggingInputData extends GraphQlMutationCallInput {

    /* compiled from: popular_at_report_not_helpful */
    public enum Event implements JsonSerializable {
        CHECKUP_RENDER("CHECKUP_RENDER"),
        STEP_1_PASSWORD_CHANGED("STEP_1_PASSWORD_CHANGED"),
        STEP_1_PASSWORD_CHANGE_ERROR("STEP_1_PASSWORD_CHANGE_ERROR"),
        STEP_1_LA_JEWEL_ON("STEP_1_LA_JEWEL_ON"),
        STEP_1_LA_JEWEL_OFF("STEP_1_LA_JEWEL_OFF"),
        STEP_1_LA_EMAIL_ON("STEP_1_LA_EMAIL_ON"),
        STEP_1_LA_EMAIL_OFF("STEP_1_LA_EMAIL_OFF"),
        STEP_1_LA_PHONE_ON("STEP_1_LA_PHONE_ON"),
        STEP_1_LA_PHONE_OFF("STEP_1_LA_PHONE_OFF"),
        STEP_2_END_SESSION("STEP_2_END_SESSION"),
        FINALE_SHOWN("FINALE_SHOWN"),
        FINISHED_CLICK_SETTINGS("FINISHED_CLICK_SETTINGS"),
        FINISHED_CLICK_LEARN_MORE("FINISHED_CLICK_LEARN_MORE"),
        END_SESSION_OPEN("END_SESSION_OPEN"),
        LA_OPEN("LA_OPEN"),
        LA_LEARN_MORE("LA_LEARN_MORE"),
        PASSWORD_OPEN("PASSWORD_OPEN"),
        PASSWORD_EXPAND("PASSWORD_EXPAND"),
        PASSWORD_CANCEL("PASSWORD_CANCEL"),
        FINISHED_CLICK_CLOSE("FINISHED_CLICK_CLOSE"),
        INTRO_RENDER("INTRO_RENDER"),
        INTRO_CLICK_ACCEPT("INTRO_CLICK_ACCEPT"),
        INTRO_CLICK_DECLINE("INTRO_CLICK_DECLINE"),
        INTRO_CLICK_X("INTRO_CLICK_X"),
        STEP_1_NEXT("STEP_1_NEXT"),
        STEP_2_NEXT("STEP_2_NEXT"),
        CHECKUP_LOAD_START("CHECKUP_LOAD_START"),
        CHECKUP_LOAD_COMPLETE("CHECKUP_LOAD_COMPLETE"),
        END_SESSION_EXPAND("END_SESSION_EXPAND"),
        END_SESSION_COLLAPSE("END_SESSION_COLLAPSE"),
        LA_EXPAND("LA_EXPAND"),
        LA_TURN_OFF("LA_TURN_OFF"),
        LA_COLLAPSE("LA_COLLAPSE"),
        PASSWORD_COLLAPSE("PASSWORD_COLLAPSE"),
        PASSWORD_CHANGE_CTA("PASSWORD_CHANGE_CTA"),
        PASSWORD_CHANGE_ERROR("PASSWORD_CHANGE_ERROR");
        
        protected final String serverValue;

        private Event(String str) {
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

    /* compiled from: popular_at_report_not_helpful */
    public enum Source implements JsonSerializable {
        TEST_PAGE("TEST_PAGE"),
        QP("QP"),
        DD_INITIAL_MEGAPHONE("DD_INITIAL_MEGAPHONE"),
        DD_TAM_EXPT_MEGAPHONE("DD_TAM_EXPT_MEGAPHONE"),
        INITIAL_MEGAPHONE("INITIAL_MEGAPHONE"),
        REMINDER_MEGAPHONE("REMINDER_MEGAPHONE"),
        NOTIFICATION("NOTIFICATION"),
        NEWS_FEED("NEWS_FEED"),
        NEWS_FEED_LAUNCHER("NEWS_FEED_LAUNCHER"),
        HELP_CENTER("HELP_CENTER"),
        SCHEDULED_MEGAPHONE("SCHEDULED_MEGAPHONE"),
        FB4A_MEGAPHONE("FB4A_MEGAPHONE"),
        FB4A_INITIAL_MEGAPHONE("FB4A_INITIAL_MEGAPHONE"),
        FB4A_REMINDER_MEGAPHONE("FB4A_REMINDER_MEGAPHONE"),
        FB4A_NEWS_FEED("FB4A_NEWS_FEED"),
        DELTA_ANDROID("DELTA_ANDROID");
        
        protected final String serverValue;

        private Source(String str) {
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
