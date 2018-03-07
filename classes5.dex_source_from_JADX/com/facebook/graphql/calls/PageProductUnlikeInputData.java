package com.facebook.graphql.calls;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializable;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;

/* compiled from: primary_image */
public final class PageProductUnlikeInputData extends GraphQlMutationCallInput {

    /* compiled from: primary_image */
    public enum Context implements JsonSerializable {
        AFTER_PARTY_POPULAR_AT_IOS("after_party_popular_at_ios"),
        AFTER_PARTY_POPULAR_AT_ANDROID("after_party_popular_at_android"),
        HC("hc"),
        MIYML("miyml"),
        MID("mid"),
        PA("pa"),
        PM("pm"),
        PS("ps"),
        PI("pi"),
        POPULAR_AT_TEST_PAGE("popular_at_test_page"),
        PC("pc"),
        PB("pb"),
        ST("st"),
        TDD("tdd"),
        TNT("tnt");
        
        protected final String serverValue;

        private Context(String str) {
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

    public final PageProductUnlikeInputData m4469a(String str) {
        a("page_product_id", str);
        return this;
    }

    public final PageProductUnlikeInputData m4468a(Context context) {
        a("context", context);
        return this;
    }
}
