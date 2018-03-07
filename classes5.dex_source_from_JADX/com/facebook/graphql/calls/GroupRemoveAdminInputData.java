package com.facebook.graphql.calls;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializable;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;

/* compiled from: publish_menu */
public final class GroupRemoveAdminInputData extends GraphQlMutationCallInput {

    /* compiled from: publish_menu */
    public enum AdminType implements JsonSerializable {
        NONE("none"),
        MODERATOR("moderator"),
        ADMIN("admin");
        
        protected final String serverValue;

        private AdminType(String str) {
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

    public final GroupRemoveAdminInputData m4443a(String str) {
        a("actor_id", str);
        return this;
    }

    public final GroupRemoveAdminInputData m4444b(String str) {
        a("group_id", str);
        return this;
    }

    public final GroupRemoveAdminInputData m4445c(String str) {
        a("user_id", str);
        return this;
    }
}
