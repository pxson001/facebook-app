package com.facebook.graphql.calls;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializable;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;

/* compiled from: price_type */
public final class PlaceQuestionSkipInputData extends GraphQlMutationCallInput {

    /* compiled from: price_type */
    public enum Surface implements JsonSerializable {
        NONE("NONE"),
        PAGES("PAGES"),
        TIMELINE("TIMELINE"),
        TIMELINE_COLLECTION("TIMELINE_COLLECTION"),
        PAGE_TAB("PAGE_TAB"),
        PERMALINK("PERMALINK"),
        NEWS_FEED("NEWS_FEED"),
        EGO_WWW("EGO_WWW"),
        EGO_MOBILE("EGO_MOBILE"),
        REACTION("REACTION"),
        ASK_EGO_MOBILE("ASK_EGO_MOBILE"),
        AYMT("AYMT"),
        REVIEWS_FEED("REVIEWS_FEED"),
        CATEGORIZED_PHOTO_VIEWER("CATEGORIZED_PHOTO_VIEWER"),
        CATEGORIZED_PHOTO_VIEWER_FOOD_ENTRY("CATEGORIZED_PHOTO_VIEWER_FOOD_ENTRY"),
        REACTION_FOOD_PHOTOS("REACTION_FOOD_PHOTOS"),
        REACTION_MENU_FOOD_PHOTOS("REACTION_MENU_FOOD_PHOTOS"),
        REACTION_PAGE_POPULAR_PHOTOS_OF_PLACE("REACTION_PAGE_POPULAR_PHOTOS_OF_PLACE"),
        REACTION_PHOTOS_OF_NEXT_PLACE("REACTION_PHOTOS_OF_NEXT_PLACE"),
        REACTION_PHOTOS_OF_PLACE_INTERIOR("REACTION_PHOTOS_OF_PLACE_INTERIOR"),
        REACTION_POPULAR_PHOTOS_OF_PLACE("REACTION_POPULAR_PHOTOS_OF_PLACE"),
        REACTION_PUBLIC_PLACE_REVIEWS("REACTION_PUBLIC_PLACE_REVIEWS");
        
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
