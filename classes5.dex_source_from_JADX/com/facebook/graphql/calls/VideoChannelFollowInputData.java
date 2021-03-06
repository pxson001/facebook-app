package com.facebook.graphql.calls;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializable;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;

/* compiled from: places_editor_review_duplicates_module */
public final class VideoChannelFollowInputData extends GraphQlMutationCallInput {

    /* compiled from: places_editor_review_duplicates_module */
    public enum Surface implements JsonSerializable {
        VIDEO_CHANNEL_HEADER("VIDEO_CHANNEL_HEADER"),
        INTERN("INTERN"),
        RECOMMENDED_VIDEO_CHANNEL("RECOMMENDED_VIDEO_CHANNEL"),
        FAN_STATUS_CHANGE_OBSERVER("FAN_STATUS_CHANGE_OBSERVER"),
        IN_LIVE_EXPERIENCE("IN_LIVE_EXPERIENCE"),
        VIDEO_HOME_GUIDE("VIDEO_HOME_GUIDE"),
        CHEVRON("CHEVRON"),
        UNKNOWN("UNKNOWN");
        
        protected final String serverValue;

        private Surface(String str) {
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
