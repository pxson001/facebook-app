package com.facebook.graphql.calls;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializable;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;

/* compiled from: playShutterSound media player error */
public final class UserLoginApprovalInputData extends GraphQlMutationCallInput {

    /* compiled from: playShutterSound media player error */
    public enum ResponseType implements JsonSerializable {
        LOGIN_APPROVE("LOGIN_APPROVE"),
        LOGIN_DENY("LOGIN_DENY");
        
        protected final String serverValue;

        private ResponseType(String str) {
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

    public final UserLoginApprovalInputData m4498a(ResponseType responseType) {
        a("response_type", responseType);
        return this;
    }

    public final UserLoginApprovalInputData m4499a(String str) {
        a("datr", str);
        return this;
    }

    public final UserLoginApprovalInputData m4500b(String str) {
        a("ip", str);
        return this;
    }

    public final UserLoginApprovalInputData m4501c(String str) {
        a("device", str);
        return this;
    }
}
