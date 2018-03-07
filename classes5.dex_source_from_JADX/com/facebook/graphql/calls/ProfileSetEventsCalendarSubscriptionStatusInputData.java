package com.facebook.graphql.calls;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializable;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;
import java.util.List;

/* compiled from: previewTemplateAtPlace */
public final class ProfileSetEventsCalendarSubscriptionStatusInputData extends GraphQlMutationCallInput {

    /* compiled from: previewTemplateAtPlace */
    public final class Context extends GraphQlCallInput {

        /* compiled from: previewTemplateAtPlace */
        public final class EventActionHistory extends GraphQlCallInput {
            public final EventActionHistory m4472a(String str) {
                a("surface", str);
                return this;
            }

            public final EventActionHistory m4473b(String str) {
                a("mechanism", str);
                return this;
            }
        }

        public final Context m4474a(List<EventActionHistory> list) {
            a("event_action_history", list);
            return this;
        }
    }

    /* compiled from: previewTemplateAtPlace */
    public enum SubscriptionStatus implements JsonSerializable {
        NONE("NONE"),
        ALL("ALL"),
        LOCAL("LOCAL");
        
        protected final String serverValue;

        private SubscriptionStatus(String str) {
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

    public final ProfileSetEventsCalendarSubscriptionStatusInputData m4477a(String str) {
        a("profile_id", str);
        return this;
    }

    public final ProfileSetEventsCalendarSubscriptionStatusInputData m4476a(SubscriptionStatus subscriptionStatus) {
        a("subscription_status", subscriptionStatus);
        return this;
    }

    public final ProfileSetEventsCalendarSubscriptionStatusInputData m4475a(Context context) {
        a("context", context);
        return this;
    }
}
