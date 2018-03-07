package com.facebook.graphql.calls;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializable;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;
import java.util.List;

/* compiled from: range unbounded on this side */
public final class EventCreateInputData extends GraphQlMutationCallInput {

    /* compiled from: range unbounded on this side */
    public final class Context extends GraphQlCallInput {

        /* compiled from: range unbounded on this side */
        public final class EventActionHistory extends GraphQlCallInput {
            public final EventActionHistory m4366a(String str) {
                a("surface", str);
                return this;
            }

            public final EventActionHistory m4367b(String str) {
                a("mechanism", str);
                return this;
            }
        }

        public final Context m4368a(List<EventActionHistory> list) {
            a("event_action_history", list);
            return this;
        }
    }

    /* compiled from: range unbounded on this side */
    public final class CoverPhotoInfo extends GraphQlCallInput {
    }

    /* compiled from: range unbounded on this side */
    public enum EventVisibility implements JsonSerializable {
        FRIENDS_OF_FRIENDS("FRIENDS_OF_FRIENDS"),
        FRIENDS_OF_GUESTS("FRIENDS_OF_GUESTS"),
        GROUP("GROUP"),
        INVITE_ONLY("INVITE_ONLY"),
        PAGE("PAGE"),
        USER_PUBLIC("USER_PUBLIC"),
        COMMUNITY("COMMUNITY");
        
        protected final String serverValue;

        private EventVisibility(String str) {
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

    /* compiled from: range unbounded on this side */
    public enum InvitePolicy implements JsonSerializable {
        CANNOT_INVITE_FRIENDS("CANNOT_INVITE_FRIENDS"),
        CAN_INVITE_FRIENDS("CAN_INVITE_FRIENDS");
        
        protected final String serverValue;

        private InvitePolicy(String str) {
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

    /* compiled from: range unbounded on this side */
    public enum PostApprovalRequired implements JsonSerializable {
        TRUE("true"),
        FALSE("false");
        
        protected final String serverValue;

        private PostApprovalRequired(String str) {
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

    /* compiled from: range unbounded on this side */
    public enum PrivacyUpdatePolicy implements JsonSerializable {
        CAN_UPDATE("CAN_UPDATE"),
        PRIVACY_LOCKED("PRIVACY_LOCKED");
        
        protected final String serverValue;

        private PrivacyUpdatePolicy(String str) {
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

    public final EventCreateInputData m4374a(String str) {
        a("actor_id", str);
        return this;
    }

    public final EventCreateInputData m4375b(String str) {
        a("name", str);
        return this;
    }

    public final EventCreateInputData m4376c(String str) {
        a("start_time", str);
        return this;
    }

    public final EventCreateInputData m4377d(String str) {
        a("end_time", str);
        return this;
    }

    public final EventCreateInputData m4378e(String str) {
        a("description", str);
        return this;
    }

    public final EventCreateInputData m4372a(InvitePolicy invitePolicy) {
        a("invite_policy", invitePolicy);
        return this;
    }

    public final EventCreateInputData m4379f(String str) {
        a("location_name", str);
        return this;
    }

    public final EventCreateInputData m4380g(String str) {
        a("location_id", str);
        return this;
    }

    public final EventCreateInputData m4371a(EventVisibility eventVisibility) {
        a("event_visibility", eventVisibility);
        return this;
    }

    public final EventCreateInputData m4369a(Context context) {
        a("context", context);
        return this;
    }

    public final EventCreateInputData m4381h(String str) {
        a("object_id", str);
        return this;
    }

    public final EventCreateInputData m4373a(PrivacyUpdatePolicy privacyUpdatePolicy) {
        a("privacy_update_policy", privacyUpdatePolicy);
        return this;
    }

    public final EventCreateInputData m4370a(CoverPhotoInfo coverPhotoInfo) {
        a("cover_photo_info", coverPhotoInfo);
        return this;
    }
}
