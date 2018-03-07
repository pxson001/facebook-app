package com.facebook.graphql.calls;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializable;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;
import java.util.List;

/* compiled from: recent_claims_count */
public final class ContactUploadSessionCreateAndMaybeBatchUploadInputData extends GraphQlMutationCallInput {

    /* compiled from: recent_claims_count */
    public enum ContactUploadSessionType implements JsonSerializable {
        FULL("FULL"),
        DELTA("DELTA");
        
        protected final String serverValue;

        private ContactUploadSessionType(String str) {
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

    /* compiled from: recent_claims_count */
    public final class Contacts extends GraphQlCallInput {

        /* compiled from: recent_claims_count */
        public final class Emails extends GraphQlCallInput {
        }

        /* compiled from: recent_claims_count */
        public enum Modifier implements JsonSerializable {
            ADD("ADD"),
            REMOVE("REMOVE"),
            UPDATE("UPDATE");
            
            protected final String serverValue;

            private Modifier(String str) {
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

        /* compiled from: recent_claims_count */
        public final class Phones extends GraphQlCallInput {
        }
    }

    /* compiled from: recent_claims_count */
    public enum NeedFriendableContacts implements JsonSerializable {
        TRUE("true"),
        FALSE("false");
        
        protected final String serverValue;

        private NeedFriendableContacts(String str) {
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

    /* compiled from: recent_claims_count */
    public enum NeedInvitableContacts implements JsonSerializable {
        TRUE("true"),
        FALSE("false");
        
        protected final String serverValue;

        private NeedInvitableContacts(String str) {
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

    /* compiled from: recent_claims_count */
    public enum Source implements JsonSerializable {
        FB_NUX_CI("FB_NUX_CI"),
        FB_CCU_BACKGROUND_PING("FB_CCU_BACKGROUND_PING");
        
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

    public final ContactUploadSessionCreateAndMaybeBatchUploadInputData m4345a(Source source) {
        a("source", source);
        return this;
    }

    public final ContactUploadSessionCreateAndMaybeBatchUploadInputData m4346a(String str) {
        a("phone_id", str);
        return this;
    }

    public final ContactUploadSessionCreateAndMaybeBatchUploadInputData m4348b(String str) {
        a("minimal_base_hash", str);
        return this;
    }

    public final ContactUploadSessionCreateAndMaybeBatchUploadInputData m4349c(String str) {
        a("extended_base_hash", str);
        return this;
    }

    public final ContactUploadSessionCreateAndMaybeBatchUploadInputData m4342a(ContactUploadSessionType contactUploadSessionType) {
        a("contact_upload_session_type", contactUploadSessionType);
        return this;
    }

    public final ContactUploadSessionCreateAndMaybeBatchUploadInputData m4344a(NeedInvitableContacts needInvitableContacts) {
        a("need_invitable_contacts", needInvitableContacts);
        return this;
    }

    public final ContactUploadSessionCreateAndMaybeBatchUploadInputData m4343a(NeedFriendableContacts needFriendableContacts) {
        a("need_friendable_contacts", needFriendableContacts);
        return this;
    }

    public final ContactUploadSessionCreateAndMaybeBatchUploadInputData m4347a(List<Contacts> list) {
        a("contacts", list);
        return this;
    }
}
