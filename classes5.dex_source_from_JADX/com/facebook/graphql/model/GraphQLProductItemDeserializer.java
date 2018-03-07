package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.facebook.graphql.enums.GraphQLCommerceCheckoutStyle;
import com.facebook.graphql.enums.GraphQLCommerceProductVisibility;
import com.facebook.graphql.enums.GraphQLProductAvailability;
import com.facebook.graphql.enums.GraphQLSavedState;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;

/* compiled from: neither mData nor mUri are set */
public class GraphQLProductItemDeserializer extends FbJsonDeserializer {
    public Object m21091a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        GraphQLProductItem graphQLProductItem = new GraphQLProductItem();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            graphQLProductItem = null;
        } else {
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                String o;
                if ("checkout_url".equals(i)) {
                    o = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                    graphQLProductItem.f12745d = o;
                    FieldAccessQueryTracker.a(jsonParser, graphQLProductItem, "checkout_url", graphQLProductItem.a_, 0, false);
                } else if ("commerce_checkout_style".equals(i)) {
                    graphQLProductItem.f12746e = GraphQLCommerceCheckoutStyle.fromString(jsonParser.o());
                    FieldAccessQueryTracker.a(jsonParser, graphQLProductItem, "commerce_checkout_style", graphQLProductItem.a_, 1, false);
                } else if ("commerce_featured_item".equals(i)) {
                    if (jsonParser.g() == JsonToken.VALUE_NULL) {
                        r4 = false;
                    } else {
                        r4 = jsonParser.H();
                    }
                    graphQLProductItem.f12747f = r4;
                    FieldAccessQueryTracker.a(jsonParser, graphQLProductItem, "commerce_featured_item", graphQLProductItem.a_, 2, false);
                } else if ("commerce_inventory".equals(i)) {
                    int i2;
                    if (jsonParser.g() == JsonToken.VALUE_NULL) {
                        i2 = 0;
                    } else {
                        i2 = jsonParser.E();
                    }
                    graphQLProductItem.f12748g = i2;
                    FieldAccessQueryTracker.a(jsonParser, graphQLProductItem, "commerce_inventory", graphQLProductItem.a_, 3, false);
                } else if ("commerce_product_visibility".equals(i)) {
                    graphQLProductItem.f12749h = GraphQLCommerceProductVisibility.fromString(jsonParser.o());
                    FieldAccessQueryTracker.a(jsonParser, graphQLProductItem, "commerce_product_visibility", graphQLProductItem.a_, 4, false);
                } else if ("creation_time".equals(i)) {
                    long j;
                    if (jsonParser.g() == JsonToken.VALUE_NULL) {
                        j = 0;
                    } else {
                        j = jsonParser.F();
                    }
                    graphQLProductItem.f12750i = j;
                    FieldAccessQueryTracker.a(jsonParser, graphQLProductItem, "creation_time", graphQLProductItem.a_, 5, false);
                } else if ("current_price".equals(i)) {
                    if (jsonParser.g() == JsonToken.VALUE_NULL) {
                        r4 = null;
                    } else {
                        r4 = GraphQLCurrencyQuantity__JsonHelper.m6924a(FieldAccessQueryTracker.a(jsonParser, "current_price"));
                    }
                    graphQLProductItem.f12751j = r4;
                    FieldAccessQueryTracker.a(jsonParser, graphQLProductItem, "current_price", graphQLProductItem.a_, 6, true);
                } else if ("description".equals(i)) {
                    o = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                    graphQLProductItem.f12752k = o;
                    FieldAccessQueryTracker.a(jsonParser, graphQLProductItem, "description", graphQLProductItem.a_, 7, false);
                } else if ("experimental_freeform_price".equals(i)) {
                    o = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                    graphQLProductItem.f12753l = o;
                    FieldAccessQueryTracker.a(jsonParser, graphQLProductItem, "experimental_freeform_price", graphQLProductItem.a_, 8, false);
                } else if ("external_url".equals(i)) {
                    o = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                    graphQLProductItem.f12754m = o;
                    FieldAccessQueryTracker.a(jsonParser, graphQLProductItem, "external_url", graphQLProductItem.a_, 9, false);
                } else if ("feedAwesomizerProfilePicture".equals(i)) {
                    if (jsonParser.g() == JsonToken.VALUE_NULL) {
                        r4 = null;
                    } else {
                        r4 = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "feedAwesomizerProfilePicture"));
                    }
                    graphQLProductItem.f12755n = r4;
                    FieldAccessQueryTracker.a(jsonParser, graphQLProductItem, "feedAwesomizerProfilePicture", graphQLProductItem.a_, 10, true);
                } else if ("feedback".equals(i)) {
                    GraphQLFeedback graphQLFeedback;
                    if (jsonParser.g() == JsonToken.VALUE_NULL) {
                        graphQLFeedback = null;
                    } else {
                        graphQLFeedback = GraphQLFeedback__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "feedback"));
                    }
                    graphQLProductItem.f12756o = graphQLFeedback;
                    FieldAccessQueryTracker.a(jsonParser, graphQLProductItem, "feedback", graphQLProductItem.a_, 11, true);
                } else if ("front_view_image".equals(i)) {
                    if (jsonParser.g() == JsonToken.VALUE_NULL) {
                        r4 = null;
                    } else {
                        r4 = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "front_view_image"));
                    }
                    graphQLProductItem.f12757p = r4;
                    FieldAccessQueryTracker.a(jsonParser, graphQLProductItem, "front_view_image", graphQLProductItem.a_, 12, true);
                } else if ("id".equals(i)) {
                    o = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                    graphQLProductItem.f12758q = o;
                    FieldAccessQueryTracker.a(jsonParser, graphQLProductItem, "id", graphQLProductItem.a_, 13, false);
                } else if ("image".equals(i)) {
                    if (jsonParser.g() == JsonToken.VALUE_NULL) {
                        r4 = null;
                    } else {
                        r4 = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "image"));
                    }
                    graphQLProductItem.f12759r = r4;
                    FieldAccessQueryTracker.a(jsonParser, graphQLProductItem, "image", graphQLProductItem.a_, 14, true);
                } else if ("imageHighOrig".equals(i)) {
                    if (jsonParser.g() == JsonToken.VALUE_NULL) {
                        r4 = null;
                    } else {
                        r4 = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "imageHighOrig"));
                    }
                    graphQLProductItem.f12760s = r4;
                    FieldAccessQueryTracker.a(jsonParser, graphQLProductItem, "imageHighOrig", graphQLProductItem.a_, 15, true);
                } else if ("images".equals(i)) {
                    r4 = null;
                    if (jsonParser.g() == JsonToken.START_ARRAY) {
                        r4 = new ArrayList();
                        while (jsonParser.c() != JsonToken.END_ARRAY) {
                            r5 = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "images"));
                            if (r5 != null) {
                                r4.add(r5);
                            }
                        }
                    }
                    if (r4 == null) {
                        r4 = null;
                    } else {
                        r4 = ImmutableList.copyOf(r4);
                    }
                    graphQLProductItem.f12761t = r4;
                    FieldAccessQueryTracker.a(jsonParser, graphQLProductItem, "images", graphQLProductItem.a_, 16, true);
                } else if ("inline_activities".equals(i)) {
                    GraphQLInlineActivitiesConnection graphQLInlineActivitiesConnection;
                    if (jsonParser.g() == JsonToken.VALUE_NULL) {
                        graphQLInlineActivitiesConnection = null;
                    } else {
                        graphQLInlineActivitiesConnection = GraphQLInlineActivitiesConnection__JsonHelper.m8689a(FieldAccessQueryTracker.a(jsonParser, "inline_activities"));
                    }
                    graphQLProductItem.f12762u = graphQLInlineActivitiesConnection;
                    FieldAccessQueryTracker.a(jsonParser, graphQLProductItem, "inline_activities", graphQLProductItem.a_, 17, true);
                } else if ("is_on_sale".equals(i)) {
                    if (jsonParser.g() == JsonToken.VALUE_NULL) {
                        r4 = false;
                    } else {
                        r4 = jsonParser.H();
                    }
                    graphQLProductItem.f12763v = r4;
                    FieldAccessQueryTracker.a(jsonParser, graphQLProductItem, "is_on_sale", graphQLProductItem.a_, 18, false);
                } else if ("item_availability".equals(i)) {
                    graphQLProductItem.f12764w = GraphQLProductAvailability.fromString(jsonParser.o());
                    FieldAccessQueryTracker.a(jsonParser, graphQLProductItem, "item_availability", graphQLProductItem.a_, 19, false);
                } else if ("item_details".equals(i)) {
                    r4 = null;
                    if (jsonParser.g() == JsonToken.START_ARRAY) {
                        r4 = new ArrayList();
                        while (jsonParser.c() != JsonToken.END_ARRAY) {
                            r5 = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                            if (r5 != null) {
                                r4.add(r5);
                            }
                        }
                    }
                    if (r4 == null) {
                        r4 = null;
                    } else {
                        r4 = ImmutableList.copyOf(r4);
                    }
                    graphQLProductItem.f12765x = r4;
                    FieldAccessQueryTracker.a(jsonParser, graphQLProductItem, "item_details", graphQLProductItem.a_, 20, false);
                } else if ("item_price".equals(i)) {
                    graphQLProductItem.f12766y = jsonParser.g() == JsonToken.VALUE_NULL ? null : GraphQLCurrencyQuantity__JsonHelper.m6924a(FieldAccessQueryTracker.a(jsonParser, "item_price"));
                    FieldAccessQueryTracker.a(jsonParser, graphQLProductItem, "item_price", graphQLProductItem.a_, 21, true);
                } else if ("merchant_logo".equals(i)) {
                    graphQLProductItem.f12767z = jsonParser.g() == JsonToken.VALUE_NULL ? null : GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "merchant_logo"));
                    FieldAccessQueryTracker.a(jsonParser, graphQLProductItem, "merchant_logo", graphQLProductItem.a_, 22, true);
                } else if ("name".equals(i)) {
                    o = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                    graphQLProductItem.f12721A = o;
                    FieldAccessQueryTracker.a(jsonParser, graphQLProductItem, "name", graphQLProductItem.a_, 23, false);
                } else if ("page".equals(i)) {
                    graphQLProductItem.f12722B = jsonParser.g() == JsonToken.VALUE_NULL ? null : GraphQLPage__JsonHelper.m9553a(FieldAccessQueryTracker.a(jsonParser, "page"));
                    FieldAccessQueryTracker.a(jsonParser, graphQLProductItem, "page", graphQLProductItem.a_, 24, true);
                } else if ("parent_story".equals(i)) {
                    graphQLProductItem.f12723C = jsonParser.g() == JsonToken.VALUE_NULL ? null : GraphQLStory__JsonHelper.m21922a(FieldAccessQueryTracker.a(jsonParser, "parent_story"));
                    FieldAccessQueryTracker.a(jsonParser, graphQLProductItem, "parent_story", graphQLProductItem.a_, 25, true);
                } else if ("platform_images".equals(i)) {
                    r4 = null;
                    if (jsonParser.g() == JsonToken.START_ARRAY) {
                        r4 = new ArrayList();
                        while (jsonParser.c() != JsonToken.END_ARRAY) {
                            r5 = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "platform_images"));
                            if (r5 != null) {
                                r4.add(r5);
                            }
                        }
                    }
                    if (r4 == null) {
                        r4 = null;
                    } else {
                        r4 = ImmutableList.copyOf(r4);
                    }
                    graphQLProductItem.f12724D = r4;
                    FieldAccessQueryTracker.a(jsonParser, graphQLProductItem, "platform_images", graphQLProductItem.a_, 26, true);
                } else if ("productCatalogImage".equals(i)) {
                    if (jsonParser.g() == JsonToken.VALUE_NULL) {
                        r4 = null;
                    } else {
                        r4 = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "productCatalogImage"));
                    }
                    graphQLProductItem.f12725E = r4;
                    FieldAccessQueryTracker.a(jsonParser, graphQLProductItem, "productCatalogImage", graphQLProductItem.a_, 27, true);
                } else if ("productImageLarge".equals(i)) {
                    if (jsonParser.g() == JsonToken.VALUE_NULL) {
                        r4 = null;
                    } else {
                        r4 = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "productImageLarge"));
                    }
                    graphQLProductItem.f12726F = r4;
                    FieldAccessQueryTracker.a(jsonParser, graphQLProductItem, "productImageLarge", graphQLProductItem.a_, 28, true);
                } else if ("profileImageLarge".equals(i)) {
                    if (jsonParser.g() == JsonToken.VALUE_NULL) {
                        r4 = null;
                    } else {
                        r4 = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "profileImageLarge"));
                    }
                    graphQLProductItem.f12727G = r4;
                    FieldAccessQueryTracker.a(jsonParser, graphQLProductItem, "profileImageLarge", graphQLProductItem.a_, 29, true);
                } else if ("profileImageSmall".equals(i)) {
                    if (jsonParser.g() == JsonToken.VALUE_NULL) {
                        r4 = null;
                    } else {
                        r4 = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "profileImageSmall"));
                    }
                    graphQLProductItem.f12728H = r4;
                    FieldAccessQueryTracker.a(jsonParser, graphQLProductItem, "profileImageSmall", graphQLProductItem.a_, 30, true);
                } else if ("profilePicture50".equals(i)) {
                    if (jsonParser.g() == JsonToken.VALUE_NULL) {
                        r4 = null;
                    } else {
                        r4 = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "profilePicture50"));
                    }
                    graphQLProductItem.f12729I = r4;
                    FieldAccessQueryTracker.a(jsonParser, graphQLProductItem, "profilePicture50", graphQLProductItem.a_, 31, true);
                } else if ("profilePictureHighRes".equals(i)) {
                    if (jsonParser.g() == JsonToken.VALUE_NULL) {
                        r4 = null;
                    } else {
                        r4 = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "profilePictureHighRes"));
                    }
                    graphQLProductItem.f12730J = r4;
                    FieldAccessQueryTracker.a(jsonParser, graphQLProductItem, "profilePictureHighRes", graphQLProductItem.a_, 32, true);
                } else if ("profilePictureLarge".equals(i)) {
                    if (jsonParser.g() == JsonToken.VALUE_NULL) {
                        r4 = null;
                    } else {
                        r4 = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "profilePictureLarge"));
                    }
                    graphQLProductItem.f12731K = r4;
                    FieldAccessQueryTracker.a(jsonParser, graphQLProductItem, "profilePictureLarge", graphQLProductItem.a_, 33, true);
                } else if ("profile_photo".equals(i)) {
                    GraphQLPhoto graphQLPhoto;
                    if (jsonParser.g() == JsonToken.VALUE_NULL) {
                        graphQLPhoto = null;
                    } else {
                        graphQLPhoto = GraphQLPhoto__JsonHelper.m20764a(FieldAccessQueryTracker.a(jsonParser, "profile_photo"));
                    }
                    graphQLProductItem.f12732L = graphQLPhoto;
                    FieldAccessQueryTracker.a(jsonParser, graphQLProductItem, "profile_photo", graphQLProductItem.a_, 34, true);
                } else if ("profile_picture".equals(i)) {
                    if (jsonParser.g() == JsonToken.VALUE_NULL) {
                        r4 = null;
                    } else {
                        r4 = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "profile_picture"));
                    }
                    graphQLProductItem.f12733M = r4;
                    FieldAccessQueryTracker.a(jsonParser, graphQLProductItem, "profile_picture", graphQLProductItem.a_, 35, true);
                } else if ("profile_picture_is_silhouette".equals(i)) {
                    if (jsonParser.g() == JsonToken.VALUE_NULL) {
                        r4 = false;
                    } else {
                        r4 = jsonParser.H();
                    }
                    graphQLProductItem.f12734N = r4;
                    FieldAccessQueryTracker.a(jsonParser, graphQLProductItem, "profile_picture_is_silhouette", graphQLProductItem.a_, 36, false);
                } else if ("reference_url".equals(i)) {
                    o = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                    graphQLProductItem.f12735O = o;
                    FieldAccessQueryTracker.a(jsonParser, graphQLProductItem, "reference_url", graphQLProductItem.a_, 37, false);
                } else if ("sale_price".equals(i)) {
                    if (jsonParser.g() == JsonToken.VALUE_NULL) {
                        r4 = null;
                    } else {
                        r4 = GraphQLCurrencyQuantity__JsonHelper.m6924a(FieldAccessQueryTracker.a(jsonParser, "sale_price"));
                    }
                    graphQLProductItem.f12736P = r4;
                    FieldAccessQueryTracker.a(jsonParser, graphQLProductItem, "sale_price", graphQLProductItem.a_, 38, true);
                } else if ("seller".equals(i)) {
                    GraphQLActor graphQLActor;
                    if (jsonParser.g() == JsonToken.VALUE_NULL) {
                        graphQLActor = null;
                    } else {
                        graphQLActor = GraphQLActor__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "seller"));
                    }
                    graphQLProductItem.f12737Q = graphQLActor;
                    FieldAccessQueryTracker.a(jsonParser, graphQLProductItem, "seller", graphQLProductItem.a_, 39, true);
                } else if ("streaming_profile_picture".equals(i)) {
                    GraphQLStreamingImage graphQLStreamingImage;
                    if (jsonParser.g() == JsonToken.VALUE_NULL) {
                        graphQLStreamingImage = null;
                    } else {
                        graphQLStreamingImage = GraphQLStreamingImage__JsonHelper.m21929a(FieldAccessQueryTracker.a(jsonParser, "streaming_profile_picture"));
                    }
                    graphQLProductItem.f12738R = graphQLStreamingImage;
                    FieldAccessQueryTracker.a(jsonParser, graphQLProductItem, "streaming_profile_picture", graphQLProductItem.a_, 40, true);
                } else if ("taggable_object_profile_picture".equals(i)) {
                    if (jsonParser.g() == JsonToken.VALUE_NULL) {
                        r4 = null;
                    } else {
                        r4 = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "taggable_object_profile_picture"));
                    }
                    graphQLProductItem.f12739S = r4;
                    FieldAccessQueryTracker.a(jsonParser, graphQLProductItem, "taggable_object_profile_picture", graphQLProductItem.a_, 41, true);
                } else if ("url".equals(i)) {
                    o = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                    graphQLProductItem.f12740T = o;
                    FieldAccessQueryTracker.a(jsonParser, graphQLProductItem, "url", graphQLProductItem.a_, 42, false);
                } else if ("variant_values".equals(i)) {
                    r4 = null;
                    if (jsonParser.g() == JsonToken.START_ARRAY) {
                        r4 = new ArrayList();
                        while (jsonParser.c() != JsonToken.END_ARRAY) {
                            r5 = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                            if (r5 != null) {
                                r4.add(r5);
                            }
                        }
                    }
                    if (r4 == null) {
                        r4 = null;
                    } else {
                        r4 = ImmutableList.copyOf(r4);
                    }
                    graphQLProductItem.f12741U = r4;
                    FieldAccessQueryTracker.a(jsonParser, graphQLProductItem, "variant_values", graphQLProductItem.a_, 43, false);
                } else if ("viewer_saved_state".equals(i)) {
                    graphQLProductItem.f12742V = GraphQLSavedState.fromString(jsonParser.o());
                    FieldAccessQueryTracker.a(jsonParser, graphQLProductItem, "viewer_saved_state", graphQLProductItem.a_, 44, false);
                } else if ("product_latitude".equals(i)) {
                    if (jsonParser.g() == JsonToken.VALUE_NULL) {
                        r4 = 0.0d;
                    } else {
                        r4 = jsonParser.G();
                    }
                    graphQLProductItem.f12743W = r4;
                    FieldAccessQueryTracker.a(jsonParser, graphQLProductItem, "product_latitude", graphQLProductItem.a_, 45, false);
                } else if ("product_longitude".equals(i)) {
                    if (jsonParser.g() == JsonToken.VALUE_NULL) {
                        r4 = 0.0d;
                    } else {
                        r4 = jsonParser.G();
                    }
                    graphQLProductItem.f12744X = r4;
                    FieldAccessQueryTracker.a(jsonParser, graphQLProductItem, "product_longitude", graphQLProductItem.a_, 46, false);
                }
                jsonParser.f();
            }
        }
        return graphQLProductItem;
    }

    static {
        GlobalAutoGenDeserializerCache.a(GraphQLProductItem.class, new GraphQLProductItemDeserializer());
    }

    public GraphQLProductItemDeserializer() {
        a(GraphQLProductItem.class);
    }
}
