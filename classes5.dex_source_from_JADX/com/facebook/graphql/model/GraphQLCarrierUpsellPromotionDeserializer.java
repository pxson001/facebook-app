package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: photos_grid */
public class GraphQLCarrierUpsellPromotionDeserializer extends FbJsonDeserializer {
    public Object m6741a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        GraphQLCarrierUpsellPromotion graphQLCarrierUpsellPromotion = new GraphQLCarrierUpsellPromotion();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            graphQLCarrierUpsellPromotion = null;
        } else {
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                String o;
                if ("action_text".equals(i)) {
                    o = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                    graphQLCarrierUpsellPromotion.f3409d = o;
                    FieldAccessQueryTracker.a(jsonParser, graphQLCarrierUpsellPromotion, "action_text", graphQLCarrierUpsellPromotion.a_, 0, false);
                } else if ("code".equals(i)) {
                    o = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                    graphQLCarrierUpsellPromotion.f3410e = o;
                    FieldAccessQueryTracker.a(jsonParser, graphQLCarrierUpsellPromotion, "code", graphQLCarrierUpsellPromotion.a_, 1, false);
                } else if ("feedAwesomizerProfilePicture".equals(i)) {
                    if (jsonParser.g() == JsonToken.VALUE_NULL) {
                        r4 = null;
                    } else {
                        r4 = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "feedAwesomizerProfilePicture"));
                    }
                    graphQLCarrierUpsellPromotion.f3411f = r4;
                    FieldAccessQueryTracker.a(jsonParser, graphQLCarrierUpsellPromotion, "feedAwesomizerProfilePicture", graphQLCarrierUpsellPromotion.a_, 2, true);
                } else if ("full_price".equals(i)) {
                    double d;
                    if (jsonParser.g() == JsonToken.VALUE_NULL) {
                        d = 0.0d;
                    } else {
                        d = jsonParser.G();
                    }
                    graphQLCarrierUpsellPromotion.f3412g = d;
                    FieldAccessQueryTracker.a(jsonParser, graphQLCarrierUpsellPromotion, "full_price", graphQLCarrierUpsellPromotion.a_, 3, false);
                } else if ("id".equals(i)) {
                    o = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                    graphQLCarrierUpsellPromotion.f3413h = o;
                    FieldAccessQueryTracker.a(jsonParser, graphQLCarrierUpsellPromotion, "id", graphQLCarrierUpsellPromotion.a_, 4, false);
                } else if ("imageHighOrig".equals(i)) {
                    if (jsonParser.g() == JsonToken.VALUE_NULL) {
                        r4 = null;
                    } else {
                        r4 = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "imageHighOrig"));
                    }
                    graphQLCarrierUpsellPromotion.f3414i = r4;
                    FieldAccessQueryTracker.a(jsonParser, graphQLCarrierUpsellPromotion, "imageHighOrig", graphQLCarrierUpsellPromotion.a_, 5, true);
                } else if ("inline_activities".equals(i)) {
                    GraphQLInlineActivitiesConnection graphQLInlineActivitiesConnection;
                    if (jsonParser.g() == JsonToken.VALUE_NULL) {
                        graphQLInlineActivitiesConnection = null;
                    } else {
                        graphQLInlineActivitiesConnection = GraphQLInlineActivitiesConnection__JsonHelper.m8689a(FieldAccessQueryTracker.a(jsonParser, "inline_activities"));
                    }
                    graphQLCarrierUpsellPromotion.f3415j = graphQLInlineActivitiesConnection;
                    FieldAccessQueryTracker.a(jsonParser, graphQLCarrierUpsellPromotion, "inline_activities", graphQLCarrierUpsellPromotion.a_, 6, true);
                } else if ("is_loan".equals(i)) {
                    if (jsonParser.g() == JsonToken.VALUE_NULL) {
                        r4 = false;
                    } else {
                        r4 = jsonParser.H();
                    }
                    graphQLCarrierUpsellPromotion.f3416k = r4;
                    FieldAccessQueryTracker.a(jsonParser, graphQLCarrierUpsellPromotion, "is_loan", graphQLCarrierUpsellPromotion.a_, 7, false);
                } else if ("name".equals(i)) {
                    o = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                    graphQLCarrierUpsellPromotion.f3417l = o;
                    FieldAccessQueryTracker.a(jsonParser, graphQLCarrierUpsellPromotion, "name", graphQLCarrierUpsellPromotion.a_, 8, false);
                } else if ("profileImageLarge".equals(i)) {
                    if (jsonParser.g() == JsonToken.VALUE_NULL) {
                        r4 = null;
                    } else {
                        r4 = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "profileImageLarge"));
                    }
                    graphQLCarrierUpsellPromotion.f3418m = r4;
                    FieldAccessQueryTracker.a(jsonParser, graphQLCarrierUpsellPromotion, "profileImageLarge", graphQLCarrierUpsellPromotion.a_, 9, true);
                } else if ("profileImageSmall".equals(i)) {
                    if (jsonParser.g() == JsonToken.VALUE_NULL) {
                        r4 = null;
                    } else {
                        r4 = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "profileImageSmall"));
                    }
                    graphQLCarrierUpsellPromotion.f3419n = r4;
                    FieldAccessQueryTracker.a(jsonParser, graphQLCarrierUpsellPromotion, "profileImageSmall", graphQLCarrierUpsellPromotion.a_, 10, true);
                } else if ("profilePicture50".equals(i)) {
                    if (jsonParser.g() == JsonToken.VALUE_NULL) {
                        r4 = null;
                    } else {
                        r4 = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "profilePicture50"));
                    }
                    graphQLCarrierUpsellPromotion.f3420o = r4;
                    FieldAccessQueryTracker.a(jsonParser, graphQLCarrierUpsellPromotion, "profilePicture50", graphQLCarrierUpsellPromotion.a_, 11, true);
                } else if ("profilePictureHighRes".equals(i)) {
                    if (jsonParser.g() == JsonToken.VALUE_NULL) {
                        r4 = null;
                    } else {
                        r4 = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "profilePictureHighRes"));
                    }
                    graphQLCarrierUpsellPromotion.f3421p = r4;
                    FieldAccessQueryTracker.a(jsonParser, graphQLCarrierUpsellPromotion, "profilePictureHighRes", graphQLCarrierUpsellPromotion.a_, 12, true);
                } else if ("profilePictureLarge".equals(i)) {
                    if (jsonParser.g() == JsonToken.VALUE_NULL) {
                        r4 = null;
                    } else {
                        r4 = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "profilePictureLarge"));
                    }
                    graphQLCarrierUpsellPromotion.f3422q = r4;
                    FieldAccessQueryTracker.a(jsonParser, graphQLCarrierUpsellPromotion, "profilePictureLarge", graphQLCarrierUpsellPromotion.a_, 13, true);
                } else if ("profile_photo".equals(i)) {
                    GraphQLPhoto graphQLPhoto;
                    if (jsonParser.g() == JsonToken.VALUE_NULL) {
                        graphQLPhoto = null;
                    } else {
                        graphQLPhoto = GraphQLPhoto__JsonHelper.m20764a(FieldAccessQueryTracker.a(jsonParser, "profile_photo"));
                    }
                    graphQLCarrierUpsellPromotion.f3423r = graphQLPhoto;
                    FieldAccessQueryTracker.a(jsonParser, graphQLCarrierUpsellPromotion, "profile_photo", graphQLCarrierUpsellPromotion.a_, 14, true);
                } else if ("profile_picture".equals(i)) {
                    if (jsonParser.g() == JsonToken.VALUE_NULL) {
                        r4 = null;
                    } else {
                        r4 = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "profile_picture"));
                    }
                    graphQLCarrierUpsellPromotion.f3424s = r4;
                    FieldAccessQueryTracker.a(jsonParser, graphQLCarrierUpsellPromotion, "profile_picture", graphQLCarrierUpsellPromotion.a_, 15, true);
                } else if ("profile_picture_is_silhouette".equals(i)) {
                    if (jsonParser.g() == JsonToken.VALUE_NULL) {
                        r4 = false;
                    } else {
                        r4 = jsonParser.H();
                    }
                    graphQLCarrierUpsellPromotion.f3425t = r4;
                    FieldAccessQueryTracker.a(jsonParser, graphQLCarrierUpsellPromotion, "profile_picture_is_silhouette", graphQLCarrierUpsellPromotion.a_, 16, false);
                } else if ("streaming_profile_picture".equals(i)) {
                    GraphQLStreamingImage graphQLStreamingImage;
                    if (jsonParser.g() == JsonToken.VALUE_NULL) {
                        graphQLStreamingImage = null;
                    } else {
                        graphQLStreamingImage = GraphQLStreamingImage__JsonHelper.m21929a(FieldAccessQueryTracker.a(jsonParser, "streaming_profile_picture"));
                    }
                    graphQLCarrierUpsellPromotion.f3426u = graphQLStreamingImage;
                    FieldAccessQueryTracker.a(jsonParser, graphQLCarrierUpsellPromotion, "streaming_profile_picture", graphQLCarrierUpsellPromotion.a_, 18, true);
                } else if ("taggable_object_profile_picture".equals(i)) {
                    if (jsonParser.g() == JsonToken.VALUE_NULL) {
                        r4 = null;
                    } else {
                        r4 = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "taggable_object_profile_picture"));
                    }
                    graphQLCarrierUpsellPromotion.f3427v = r4;
                    FieldAccessQueryTracker.a(jsonParser, graphQLCarrierUpsellPromotion, "taggable_object_profile_picture", graphQLCarrierUpsellPromotion.a_, 19, true);
                } else if ("title".equals(i)) {
                    if (jsonParser.g() == JsonToken.VALUE_NULL) {
                        r4 = null;
                    } else {
                        r4 = GraphQLTextWithEntities__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "title"));
                    }
                    graphQLCarrierUpsellPromotion.f3428w = r4;
                    FieldAccessQueryTracker.a(jsonParser, graphQLCarrierUpsellPromotion, "title", graphQLCarrierUpsellPromotion.a_, 20, true);
                } else if ("titleForSummary".equals(i)) {
                    if (jsonParser.g() == JsonToken.VALUE_NULL) {
                        r4 = null;
                    } else {
                        r4 = GraphQLTextWithEntities__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "titleForSummary"));
                    }
                    graphQLCarrierUpsellPromotion.f3429x = r4;
                    FieldAccessQueryTracker.a(jsonParser, graphQLCarrierUpsellPromotion, "titleForSummary", graphQLCarrierUpsellPromotion.a_, 21, true);
                } else if ("url".equals(i)) {
                    o = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                    graphQLCarrierUpsellPromotion.f3430y = o;
                    FieldAccessQueryTracker.a(jsonParser, graphQLCarrierUpsellPromotion, "url", graphQLCarrierUpsellPromotion.a_, 22, false);
                }
                jsonParser.f();
            }
        }
        return graphQLCarrierUpsellPromotion;
    }

    static {
        GlobalAutoGenDeserializerCache.a(GraphQLCarrierUpsellPromotion.class, new GraphQLCarrierUpsellPromotionDeserializer());
    }

    public GraphQLCarrierUpsellPromotionDeserializer() {
        a(GraphQLCarrierUpsellPromotion.class);
    }
}
