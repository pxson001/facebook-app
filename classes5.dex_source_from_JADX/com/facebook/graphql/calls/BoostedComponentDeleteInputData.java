package com.facebook.graphql.calls;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializable;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;

/* compiled from: refetch_broadcast_id */
public final class BoostedComponentDeleteInputData extends GraphQlMutationCallInput {

    /* compiled from: refetch_broadcast_id */
    public enum BoostedComponentApp implements JsonSerializable {
        BOOSTED_INSTAGRAM_MEDIA_MOBILE("BOOSTED_INSTAGRAM_MEDIA_MOBILE"),
        BOOSTED_LOCAL_AWARENESS_MOBILE("BOOSTED_LOCAL_AWARENESS_MOBILE"),
        BOOSTED_PAGELIKE_MOBILE("BOOSTED_PAGELIKE_MOBILE"),
        BOOSTED_POST_MOBILE("BOOSTED_POST_MOBILE"),
        BOOSTED_WEBSITE_MOBILE("BOOSTED_WEBSITE_MOBILE"),
        BOOSTED_CCTA_MOBILE("BOOSTED_CCTA_MOBILE"),
        BOOSTED_EVENT_MOBILE("BOOSTED_EVENT_MOBILE"),
        BOOSTED_PRODUCT_MOBILE("BOOSTED_PRODUCT_MOBILE"),
        BOOSTED_DYNAMIC_PRODUCTS_MOBILE("BOOSTED_DYNAMIC_PRODUCTS_MOBILE");
        
        protected final String serverValue;

        private BoostedComponentApp(String str) {
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
