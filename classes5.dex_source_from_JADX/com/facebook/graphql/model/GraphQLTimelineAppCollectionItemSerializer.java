package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: UNKNOWN_QP_PRODUCT */
public class GraphQLTimelineAppCollectionItemSerializer extends JsonSerializer<GraphQLTimelineAppCollectionItem> {
    public final void m22150a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLTimelineAppCollectionItem graphQLTimelineAppCollectionItem = (GraphQLTimelineAppCollectionItem) obj;
        if (1 != null) {
            jsonGenerator.f();
        }
        if (graphQLTimelineAppCollectionItem.m22132j() != null) {
            jsonGenerator.a("attribution_text");
            GraphQLTextWithEntities__JsonHelper.a(jsonGenerator, graphQLTimelineAppCollectionItem.m22132j(), true);
        }
        if (graphQLTimelineAppCollectionItem.m22133k() != null) {
            jsonGenerator.a("collection_item_type", graphQLTimelineAppCollectionItem.m22133k().toString());
        }
        jsonGenerator.a("creation_time", graphQLTimelineAppCollectionItem.m22134l());
        if (graphQLTimelineAppCollectionItem.m22135m() != null) {
            jsonGenerator.a("feedback");
            GraphQLFeedback__JsonHelper.a(jsonGenerator, graphQLTimelineAppCollectionItem.m22135m(), true);
        }
        if (graphQLTimelineAppCollectionItem.m22136n() != null) {
            jsonGenerator.a("global_share");
            GraphQLExternalUrl__JsonHelper.m7430a(jsonGenerator, graphQLTimelineAppCollectionItem.m22136n(), true);
        }
        if (graphQLTimelineAppCollectionItem.m22137o() != null) {
            jsonGenerator.a("icon_image");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLTimelineAppCollectionItem.m22137o(), true);
        }
        if (graphQLTimelineAppCollectionItem.m22138p() != null) {
            jsonGenerator.a("id", graphQLTimelineAppCollectionItem.m22138p());
        }
        if (graphQLTimelineAppCollectionItem.m22139q() != null) {
            jsonGenerator.a("image");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLTimelineAppCollectionItem.m22139q(), true);
        }
        if (graphQLTimelineAppCollectionItem.m22140r() != null) {
            jsonGenerator.a("listImage");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLTimelineAppCollectionItem.m22140r(), true);
        }
        if (graphQLTimelineAppCollectionItem.m22141s() != null) {
            jsonGenerator.a("node");
            GraphQLNode__JsonHelper.m9293a(jsonGenerator, graphQLTimelineAppCollectionItem.m22141s(), true);
        }
        if (graphQLTimelineAppCollectionItem.m22142t() != null) {
            jsonGenerator.a("permalink_node");
            GraphQLNode__JsonHelper.m9293a(jsonGenerator, graphQLTimelineAppCollectionItem.m22142t(), true);
        }
        if (graphQLTimelineAppCollectionItem.m22143u() != null) {
            jsonGenerator.a("privacy_scope");
            GraphQLPrivacyScope__JsonHelper.m21034a(jsonGenerator, graphQLTimelineAppCollectionItem.m22143u(), true);
        }
        if (graphQLTimelineAppCollectionItem.m22144v() != null) {
            jsonGenerator.a("profileImageLarge");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLTimelineAppCollectionItem.m22144v(), true);
        }
        if (graphQLTimelineAppCollectionItem.m22145w() != null) {
            jsonGenerator.a("profileImageSmall");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLTimelineAppCollectionItem.m22145w(), true);
        }
        if (graphQLTimelineAppCollectionItem.m22146x() != null) {
            jsonGenerator.a("rating");
            GraphQLRating__JsonHelper.m21311a(jsonGenerator, graphQLTimelineAppCollectionItem.m22146x(), true);
        }
        if (graphQLTimelineAppCollectionItem.m22147y() != null) {
            jsonGenerator.a("source_object");
            FeedUnitSerializer.m6333a(jsonGenerator, graphQLTimelineAppCollectionItem.m22147y());
        }
        if (graphQLTimelineAppCollectionItem.m22148z() != null) {
            jsonGenerator.a("subtitle_text");
            GraphQLTextWithEntities__JsonHelper.a(jsonGenerator, graphQLTimelineAppCollectionItem.m22148z(), true);
        }
        if (graphQLTimelineAppCollectionItem.m22121A() != null) {
            jsonGenerator.a("tableImage");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLTimelineAppCollectionItem.m22121A(), true);
        }
        if (graphQLTimelineAppCollectionItem.m22122B() != null) {
            jsonGenerator.a("title");
            GraphQLTextWithEntities__JsonHelper.a(jsonGenerator, graphQLTimelineAppCollectionItem.m22122B(), true);
        }
        if (graphQLTimelineAppCollectionItem.m22123C() != null) {
            jsonGenerator.a("titleForSummary");
            GraphQLTextWithEntities__JsonHelper.a(jsonGenerator, graphQLTimelineAppCollectionItem.m22123C(), true);
        }
        if (graphQLTimelineAppCollectionItem.m22124D() != null) {
            jsonGenerator.a("url", graphQLTimelineAppCollectionItem.m22124D());
        }
        if (graphQLTimelineAppCollectionItem.m22125E() != null) {
            jsonGenerator.a("locally_updated_containing_collection_id", graphQLTimelineAppCollectionItem.m22125E());
        }
        if (1 != null) {
            jsonGenerator.g();
        }
    }

    static {
        FbSerializerProvider.a(GraphQLTimelineAppCollectionItem.class, new GraphQLTimelineAppCollectionItemSerializer());
    }
}
