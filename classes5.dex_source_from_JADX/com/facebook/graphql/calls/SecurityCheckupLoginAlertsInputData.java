package com.facebook.graphql.calls;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializable;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;

/* compiled from: popular_at_report_not_available */
public final class SecurityCheckupLoginAlertsInputData extends GraphQlMutationCallInput {

    /* compiled from: popular_at_report_not_available */
    public enum SetEmail implements JsonSerializable {
        TRUE("true"),
        FALSE("false");
        
        protected final String serverValue;

        private SetEmail(String str) {
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

    /* compiled from: popular_at_report_not_available */
    public enum SetNotif implements JsonSerializable {
        TRUE("true"),
        FALSE("false");
        
        protected final String serverValue;

        private SetNotif(String str) {
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

    /* compiled from: popular_at_report_not_available */
    public enum SetPhone implements JsonSerializable {
        TRUE("true"),
        FALSE("false");
        
        protected final String serverValue;

        private SetPhone(String str) {
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

    /* compiled from: popular_at_report_not_available */
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
