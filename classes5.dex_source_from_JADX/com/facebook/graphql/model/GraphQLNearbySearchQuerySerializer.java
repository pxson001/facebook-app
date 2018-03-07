package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: expiration */
public class GraphQLNearbySearchQuerySerializer extends JsonSerializer<GraphQLNearbySearchQuery> {
    public final void m9219a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLNearbySearchQuery graphQLNearbySearchQuery = (GraphQLNearbySearchQuery) obj;
        if (1 != null) {
            jsonGenerator.f();
        }
        if (graphQLNearbySearchQuery.m9214a() != null) {
            jsonGenerator.a("browse_places");
            GraphQLNearbyPlacesBrowsePlaceResultsConnection__JsonHelper.m9209a(jsonGenerator, graphQLNearbySearchQuery.m9214a(), true);
        }
        jsonGenerator.a("query_suggestions");
        if (graphQLNearbySearchQuery.m9216j() != null) {
            jsonGenerator.d();
            for (String str : graphQLNearbySearchQuery.m9216j()) {
                if (str != null) {
                    jsonGenerator.b(str);
                }
            }
            jsonGenerator.e();
        } else {
            jsonGenerator.h();
        }
        if (graphQLNearbySearchQuery.m9217k() != null) {
            jsonGenerator.a("search_session_id", graphQLNearbySearchQuery.m9217k());
        }
        if (1 != null) {
            jsonGenerator.g();
        }
    }

    static {
        FbSerializerProvider.a(GraphQLNearbySearchQuery.class, new GraphQLNearbySearchQuerySerializer());
    }
}
