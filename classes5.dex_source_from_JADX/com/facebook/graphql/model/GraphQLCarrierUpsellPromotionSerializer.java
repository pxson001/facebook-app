package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: is_eligible_for_invalidation */
public class GraphQLCarrierUpsellPromotionSerializer extends JsonSerializer<GraphQLCarrierUpsellPromotion> {
    public final void m6742a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLCarrierUpsellPromotion graphQLCarrierUpsellPromotion = (GraphQLCarrierUpsellPromotion) obj;
        if (1 != null) {
            jsonGenerator.f();
        }
        if (graphQLCarrierUpsellPromotion.m6724j() != null) {
            jsonGenerator.a("action_text", graphQLCarrierUpsellPromotion.m6724j());
        }
        if (graphQLCarrierUpsellPromotion.m6725k() != null) {
            jsonGenerator.a("code", graphQLCarrierUpsellPromotion.m6725k());
        }
        if (graphQLCarrierUpsellPromotion.m6726l() != null) {
            jsonGenerator.a("feedAwesomizerProfilePicture");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLCarrierUpsellPromotion.m6726l(), true);
        }
        jsonGenerator.a("full_price", graphQLCarrierUpsellPromotion.m6727m());
        if (graphQLCarrierUpsellPromotion.m6728n() != null) {
            jsonGenerator.a("id", graphQLCarrierUpsellPromotion.m6728n());
        }
        if (graphQLCarrierUpsellPromotion.m6729o() != null) {
            jsonGenerator.a("imageHighOrig");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLCarrierUpsellPromotion.m6729o(), true);
        }
        if (graphQLCarrierUpsellPromotion.m6730p() != null) {
            jsonGenerator.a("inline_activities");
            GraphQLInlineActivitiesConnection__JsonHelper.m8690a(jsonGenerator, graphQLCarrierUpsellPromotion.m6730p(), true);
        }
        jsonGenerator.a("is_loan", graphQLCarrierUpsellPromotion.m6731q());
        if (graphQLCarrierUpsellPromotion.m6732r() != null) {
            jsonGenerator.a("name", graphQLCarrierUpsellPromotion.m6732r());
        }
        if (graphQLCarrierUpsellPromotion.m6733s() != null) {
            jsonGenerator.a("profileImageLarge");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLCarrierUpsellPromotion.m6733s(), true);
        }
        if (graphQLCarrierUpsellPromotion.m6734t() != null) {
            jsonGenerator.a("profileImageSmall");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLCarrierUpsellPromotion.m6734t(), true);
        }
        if (graphQLCarrierUpsellPromotion.m6735u() != null) {
            jsonGenerator.a("profilePicture50");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLCarrierUpsellPromotion.m6735u(), true);
        }
        if (graphQLCarrierUpsellPromotion.m6736v() != null) {
            jsonGenerator.a("profilePictureHighRes");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLCarrierUpsellPromotion.m6736v(), true);
        }
        if (graphQLCarrierUpsellPromotion.m6737w() != null) {
            jsonGenerator.a("profilePictureLarge");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLCarrierUpsellPromotion.m6737w(), true);
        }
        if (graphQLCarrierUpsellPromotion.m6738x() != null) {
            jsonGenerator.a("profile_photo");
            GraphQLPhoto__JsonHelper.m20765a(jsonGenerator, graphQLCarrierUpsellPromotion.m6738x(), true);
        }
        if (graphQLCarrierUpsellPromotion.m6739y() != null) {
            jsonGenerator.a("profile_picture");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLCarrierUpsellPromotion.m6739y(), true);
        }
        jsonGenerator.a("profile_picture_is_silhouette", graphQLCarrierUpsellPromotion.m6740z());
        if (graphQLCarrierUpsellPromotion.m6715A() != null) {
            jsonGenerator.a("streaming_profile_picture");
            GraphQLStreamingImage__JsonHelper.m21930a(jsonGenerator, graphQLCarrierUpsellPromotion.m6715A(), true);
        }
        if (graphQLCarrierUpsellPromotion.m6716B() != null) {
            jsonGenerator.a("taggable_object_profile_picture");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLCarrierUpsellPromotion.m6716B(), true);
        }
        if (graphQLCarrierUpsellPromotion.m6717C() != null) {
            jsonGenerator.a("title");
            GraphQLTextWithEntities__JsonHelper.a(jsonGenerator, graphQLCarrierUpsellPromotion.m6717C(), true);
        }
        if (graphQLCarrierUpsellPromotion.m6718D() != null) {
            jsonGenerator.a("titleForSummary");
            GraphQLTextWithEntities__JsonHelper.a(jsonGenerator, graphQLCarrierUpsellPromotion.m6718D(), true);
        }
        if (graphQLCarrierUpsellPromotion.m6719E() != null) {
            jsonGenerator.a("url", graphQLCarrierUpsellPromotion.m6719E());
        }
        if (1 != null) {
            jsonGenerator.g();
        }
    }

    static {
        FbSerializerProvider.a(GraphQLCarrierUpsellPromotion.class, new GraphQLCarrierUpsellPromotionSerializer());
    }
}
