package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: Tried to change cursor after adapter was closed. */
public class GraphQLTrendingEntitiesEdgeSerializer extends JsonSerializer<GraphQLTrendingEntitiesEdge> {
    public final void m22295a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLTrendingEntitiesEdge graphQLTrendingEntitiesEdge = (GraphQLTrendingEntitiesEdge) obj;
        if (1 != null) {
            jsonGenerator.f();
        }
        if (graphQLTrendingEntitiesEdge.m22289a() != null) {
            jsonGenerator.a("node");
            GraphQLProfile__JsonHelper.m21115a(jsonGenerator, graphQLTrendingEntitiesEdge.m22289a(), true);
        }
        if (graphQLTrendingEntitiesEdge.m22291j() != null) {
            jsonGenerator.a("promote_text", graphQLTrendingEntitiesEdge.m22291j());
        }
        if (graphQLTrendingEntitiesEdge.m22292k() != null) {
            jsonGenerator.a("query");
            GraphQLGraphSearchQuery__JsonHelper.m8266a(jsonGenerator, graphQLTrendingEntitiesEdge.m22292k(), true);
        }
        if (graphQLTrendingEntitiesEdge.m22293l() != null) {
            jsonGenerator.a("tracking", graphQLTrendingEntitiesEdge.m22293l());
        }
        if (1 != null) {
            jsonGenerator.g();
        }
    }

    static {
        FbSerializerProvider.a(GraphQLTrendingEntitiesEdge.class, new GraphQLTrendingEntitiesEdgeSerializer());
    }
}
