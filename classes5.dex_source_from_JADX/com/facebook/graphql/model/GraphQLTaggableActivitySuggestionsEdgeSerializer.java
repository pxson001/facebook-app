package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: UNREAD_BASED */
public class GraphQLTaggableActivitySuggestionsEdgeSerializer extends JsonSerializer<GraphQLTaggableActivitySuggestionsEdge> {
    public final void m22080a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLTaggableActivitySuggestionsEdge graphQLTaggableActivitySuggestionsEdge = (GraphQLTaggableActivitySuggestionsEdge) obj;
        if (1 != null) {
            jsonGenerator.f();
        }
        if (graphQLTaggableActivitySuggestionsEdge.m22067a() != null) {
            jsonGenerator.a("associated_places_info");
            GraphQLPlaceFlowInfo__JsonHelper.m20848a(jsonGenerator, graphQLTaggableActivitySuggestionsEdge.m22067a(), true);
        }
        if (graphQLTaggableActivitySuggestionsEdge.m22070j() != null) {
            jsonGenerator.a("cursor", graphQLTaggableActivitySuggestionsEdge.m22070j());
        }
        jsonGenerator.a("custom_icon_suggestions");
        if (graphQLTaggableActivitySuggestionsEdge.m22071k() != null) {
            jsonGenerator.d();
            for (GraphQLTaggableActivityIcon graphQLTaggableActivityIcon : graphQLTaggableActivitySuggestionsEdge.m22071k()) {
                if (graphQLTaggableActivityIcon != null) {
                    GraphQLTaggableActivityIcon__JsonHelper.m22055a(jsonGenerator, graphQLTaggableActivityIcon, true);
                }
            }
            jsonGenerator.e();
        } else {
            jsonGenerator.h();
        }
        if (graphQLTaggableActivitySuggestionsEdge.m22072l() != null) {
            jsonGenerator.a("display_name", graphQLTaggableActivitySuggestionsEdge.m22072l());
        }
        if (graphQLTaggableActivitySuggestionsEdge.m22073m() != null) {
            jsonGenerator.a("icon");
            GraphQLTaggableActivityIcon__JsonHelper.m22055a(jsonGenerator, graphQLTaggableActivitySuggestionsEdge.m22073m(), true);
        }
        if (graphQLTaggableActivitySuggestionsEdge.m22074n() != null) {
            jsonGenerator.a("iconImageLarge");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLTaggableActivitySuggestionsEdge.m22074n(), true);
        }
        if (graphQLTaggableActivitySuggestionsEdge.m22075o() != null) {
            jsonGenerator.a("node");
            GraphQLProfile__JsonHelper.m21115a(jsonGenerator, graphQLTaggableActivitySuggestionsEdge.m22075o(), true);
        }
        jsonGenerator.a("show_attachment_preview", graphQLTaggableActivitySuggestionsEdge.m22076p());
        if (graphQLTaggableActivitySuggestionsEdge.m22077q() != null) {
            jsonGenerator.a("subtext");
            GraphQLTextWithEntities__JsonHelper.a(jsonGenerator, graphQLTaggableActivitySuggestionsEdge.m22077q(), true);
        }
        if (graphQLTaggableActivitySuggestionsEdge.m22078r() != null) {
            jsonGenerator.a("tracking", graphQLTaggableActivitySuggestionsEdge.m22078r());
        }
        if (1 != null) {
            jsonGenerator.g();
        }
    }

    static {
        FbSerializerProvider.a(GraphQLTaggableActivitySuggestionsEdge.class, new GraphQLTaggableActivitySuggestionsEdgeSerializer());
    }
}
