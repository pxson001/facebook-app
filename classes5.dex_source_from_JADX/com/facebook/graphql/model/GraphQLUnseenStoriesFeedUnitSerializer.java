package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: Total CPU power */
public class GraphQLUnseenStoriesFeedUnitSerializer extends JsonSerializer<GraphQLUnseenStoriesFeedUnit> {
    public final void m22380a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLUnseenStoriesFeedUnit graphQLUnseenStoriesFeedUnit = (GraphQLUnseenStoriesFeedUnit) obj;
        if (1 != null) {
            jsonGenerator.f();
        }
        if (graphQLUnseenStoriesFeedUnit.getType() != null) {
            jsonGenerator.a("__type__");
            jsonGenerator.f();
            jsonGenerator.a("name", graphQLUnseenStoriesFeedUnit.getType().e());
            jsonGenerator.g();
        }
        if (graphQLUnseenStoriesFeedUnit.m22367g() != null) {
            jsonGenerator.a("cache_id", graphQLUnseenStoriesFeedUnit.m22367g());
        }
        if (graphQLUnseenStoriesFeedUnit.S_() != null) {
            jsonGenerator.a("debug_info", graphQLUnseenStoriesFeedUnit.S_());
        }
        jsonGenerator.a("fetchTimeMs", graphQLUnseenStoriesFeedUnit.T_());
        if (graphQLUnseenStoriesFeedUnit.m22370l() != null) {
            jsonGenerator.a("id", graphQLUnseenStoriesFeedUnit.m22370l());
        }
        if (graphQLUnseenStoriesFeedUnit.m22372o() != null) {
            jsonGenerator.a("owner");
            GraphQLActor__JsonHelper.a(jsonGenerator, graphQLUnseenStoriesFeedUnit.m22372o(), true);
        }
        if (graphQLUnseenStoriesFeedUnit.m22373p() != null) {
            jsonGenerator.a("short_term_cache_key", graphQLUnseenStoriesFeedUnit.m22373p());
        }
        if (graphQLUnseenStoriesFeedUnit.m22374q() != null) {
            jsonGenerator.a("title");
            GraphQLTextWithEntities__JsonHelper.a(jsonGenerator, graphQLUnseenStoriesFeedUnit.m22374q(), true);
        }
        if (graphQLUnseenStoriesFeedUnit.m22375r() != null) {
            jsonGenerator.a("titleForSummary");
            GraphQLTextWithEntities__JsonHelper.a(jsonGenerator, graphQLUnseenStoriesFeedUnit.m22375r(), true);
        }
        if (graphQLUnseenStoriesFeedUnit.m22369k() != null) {
            jsonGenerator.a("tracking", graphQLUnseenStoriesFeedUnit.m22369k());
        }
        if (graphQLUnseenStoriesFeedUnit.m22376s() != null) {
            jsonGenerator.a("url", graphQLUnseenStoriesFeedUnit.m22376s());
        }
        if (1 != null) {
            jsonGenerator.g();
        }
    }

    static {
        FbSerializerProvider.a(GraphQLUnseenStoriesFeedUnit.class, new GraphQLUnseenStoriesFeedUnitSerializer());
    }
}
