package com.facebook.graphql.calls;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializable;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;
import java.util.List;

/* compiled from: rageshake/ */
public final class EventEditInputData extends GraphQlMutationCallInput {

    /* compiled from: rageshake/ */
    public final class Context extends GraphQlCallInput {

        /* compiled from: rageshake/ */
        public final class EventActionHistory extends GraphQlCallInput {
            public final EventActionHistory m4382a(String str) {
                a("surface", str);
                return this;
            }

            public final EventActionHistory m4383b(String str) {
                a("mechanism", str);
                return this;
            }
        }

        public final Context m4384a(List<EventActionHistory> list) {
            a("event_action_history", list);
            return this;
        }
    }

    /* compiled from: rageshake/ */
    public final class CoverPhotoInfo extends GraphQlCallInput {
        public final CoverPhotoInfo m4385a(String str) {
            a("photo_id", str);
            return this;
        }
    }

    /* compiled from: rageshake/ */
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

    /* compiled from: rageshake/ */
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

    /* compiled from: rageshake/ */
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

    public final EventEditInputData m4388a(String str) {
        a("event_id", str);
        return this;
    }

    public final EventEditInputData m4386a(Context context) {
        a("context", context);
        return this;
    }

    public final EventEditInputData m4387a(CoverPhotoInfo coverPhotoInfo) {
        a("cover_photo_info", coverPhotoInfo);
        return this;
    }
}
