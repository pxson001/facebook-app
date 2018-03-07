package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: experimentGroupName */
public class GraphQLNearbySearchSuggestionSerializer extends JsonSerializer<GraphQLNearbySearchSuggestion> {
    public final void m9230a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLNearbySearchSuggestion graphQLNearbySearchSuggestion = (GraphQLNearbySearchSuggestion) obj;
        if (1 != null) {
            jsonGenerator.f();
        }
        if (graphQLNearbySearchSuggestion.m9224a() != null) {
            jsonGenerator.a("bounds");
            GraphQLGeoRectangle__JsonHelper.m7767a(jsonGenerator, graphQLNearbySearchSuggestion.m9224a(), true);
        }
        if (graphQLNearbySearchSuggestion.m9226j() != null) {
            jsonGenerator.a("results_title");
            GraphQLTextWithEntities__JsonHelper.a(jsonGenerator, graphQLNearbySearchSuggestion.m9226j(), true);
        }
        if (graphQLNearbySearchSuggestion.m9227k() != null) {
            jsonGenerator.a("suggestion_text");
            GraphQLTextWithEntities__JsonHelper.a(jsonGenerator, graphQLNearbySearchSuggestion.m9227k(), true);
        }
        if (graphQLNearbySearchSuggestion.m9228l() != null) {
            jsonGenerator.a("topic");
            GraphQLPage__JsonHelper.m9554a(jsonGenerator, graphQLNearbySearchSuggestion.m9228l(), true);
        }
        if (1 != null) {
            jsonGenerator.g();
        }
    }

    static {
        FbSerializerProvider.a(GraphQLNearbySearchSuggestion.class, new GraphQLNearbySearchSuggestionSerializer());
    }
}
