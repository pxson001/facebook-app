package com.facebook.graphql.calls;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializable;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;

/* compiled from: poll_answers_state */
public final class StoryCreateInputData extends GraphQlMutationCallInput {

    /* compiled from: poll_answers_state */
    public final class Attachments extends GraphQlCallInput {

        /* compiled from: poll_answers_state */
        public final class File extends GraphQlCallInput {

            /* compiled from: poll_answers_state */
            public final class Files extends GraphQlCallInput {
            }
        }
    }

    /* compiled from: poll_answers_state */
    public final class Audience extends GraphQlCallInput {
    }

    /* compiled from: poll_answers_state */
    public final class Message extends GraphQlCallInput {
    }

    /* compiled from: poll_answers_state */
    public enum PostChannelFeedbackState implements JsonSerializable {
        CONTAINER_FEEDBACK("CONTAINER_FEEDBACK"),
        NO_CONTAINER_FEEDBACK("NO_CONTAINER_FEEDBACK");
        
        protected final String serverValue;

        private PostChannelFeedbackState(String str) {
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

    /* compiled from: poll_answers_state */
    public enum Source implements JsonSerializable {
        MOBILE("MOBILE"),
        TABLET("TABLET");
        
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
