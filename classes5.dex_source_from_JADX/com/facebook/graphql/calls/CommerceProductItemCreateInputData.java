package com.facebook.graphql.calls;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializable;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;

/* compiled from: red_space */
public final class CommerceProductItemCreateInputData extends GraphQlMutationCallInput {

    /* compiled from: red_space */
    public enum CommerceFeaturedItem implements JsonSerializable {
        TRUE("true"),
        FALSE("false");
        
        protected final String serverValue;

        private CommerceFeaturedItem(String str) {
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

    /* compiled from: red_space */
    public final class ProductItemPrice extends GraphQlCallInput {
    }

    /* compiled from: red_space */
    public enum ShareToTimeline implements JsonSerializable {
        TRUE("true"),
        FALSE("false");
        
        protected final String serverValue;

        private ShareToTimeline(String str) {
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

    public final CommerceProductItemCreateInputData m4339a(CommerceFeaturedItem commerceFeaturedItem) {
        a("commerce_featured_item", commerceFeaturedItem);
        return this;
    }

    public final CommerceProductItemCreateInputData m4340a(ShareToTimeline shareToTimeline) {
        a("share_to_timeline", shareToTimeline);
        return this;
    }
}
