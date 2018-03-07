package com.facebook.graphql.calls;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializable;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;

/* compiled from: redSpaceValue */
public final class CommerceProductItemUpdateInputData extends GraphQlMutationCallInput {

    /* compiled from: redSpaceValue */
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

    /* compiled from: redSpaceValue */
    public final class ProductItemPrice extends GraphQlCallInput {
    }

    public final CommerceProductItemUpdateInputData m4341a(CommerceFeaturedItem commerceFeaturedItem) {
        a("commerce_featured_item", commerceFeaturedItem);
        return this;
    }
}
