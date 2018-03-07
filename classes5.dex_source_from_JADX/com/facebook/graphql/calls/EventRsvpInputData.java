package com.facebook.graphql.calls;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializable;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;
import java.util.List;

/* compiled from: radio.active */
public final class EventRsvpInputData extends GraphQlMutationCallInput {

    /* compiled from: radio.active */
    public final class Context extends GraphQlCallInput {

        /* compiled from: radio.active */
        public final class EventActionHistory extends GraphQlCallInput {
            public final EventActionHistory m4392a(String str) {
                a("surface", str);
                return this;
            }

            public final EventActionHistory m4393b(String str) {
                a("mechanism", str);
                return this;
            }

            public final EventActionHistory m4394c(String str) {
                a("extra_data", str);
                return this;
            }
        }

        public final Context m4395a(List<EventActionHistory> list) {
            a("event_action_history", list);
            return this;
        }
    }

    /* compiled from: radio.active */
    public enum GuestStatus implements JsonSerializable {
        GOING("going"),
        MAYBE("maybe"),
        NOT_GOING("not_going");
        
        protected final String serverValue;

        private GuestStatus(String str) {
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

    public final EventRsvpInputData m4399b(String str) {
        a("event_id", str);
        return this;
    }

    public final EventRsvpInputData m4397a(GuestStatus guestStatus) {
        a("guest_status", guestStatus);
        return this;
    }

    public final EventRsvpInputData m4398a(List<String> list) {
        a("tracking", list);
        return this;
    }

    public final EventRsvpInputData m4396a(Context context) {
        a("context", context);
        return this;
    }
}
