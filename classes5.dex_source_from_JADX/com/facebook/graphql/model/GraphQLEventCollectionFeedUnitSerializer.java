package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: instagram */
public class GraphQLEventCollectionFeedUnitSerializer extends JsonSerializer<GraphQLEventCollectionFeedUnit> {
    public final void m7145a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLEventCollectionFeedUnit graphQLEventCollectionFeedUnit = (GraphQLEventCollectionFeedUnit) obj;
        if (1 != null) {
            jsonGenerator.f();
        }
        if (graphQLEventCollectionFeedUnit.getType() != null) {
            jsonGenerator.a("__type__");
            jsonGenerator.f();
            jsonGenerator.a("name", graphQLEventCollectionFeedUnit.getType().e());
            jsonGenerator.g();
        }
        if (graphQLEventCollectionFeedUnit.m7133g() != null) {
            jsonGenerator.a("cache_id", graphQLEventCollectionFeedUnit.m7133g());
        }
        if (graphQLEventCollectionFeedUnit.S_() != null) {
            jsonGenerator.a("debug_info", graphQLEventCollectionFeedUnit.S_());
        }
        if (graphQLEventCollectionFeedUnit.m7138o() != null) {
            jsonGenerator.a("eventChainingTitle");
            GraphQLTextWithEntities__JsonHelper.a(jsonGenerator, graphQLEventCollectionFeedUnit.m7138o(), true);
        }
        jsonGenerator.a("fetchTimeMs", graphQLEventCollectionFeedUnit.T_());
        if (graphQLEventCollectionFeedUnit.m7139p() != null) {
            jsonGenerator.a("short_term_cache_key", graphQLEventCollectionFeedUnit.m7139p());
        }
        if (graphQLEventCollectionFeedUnit.m7140q() != null) {
            jsonGenerator.a("suggestedEvents");
            GraphQLEventCollectionToItemConnection__JsonHelper.m7154a(jsonGenerator, graphQLEventCollectionFeedUnit.m7140q(), true);
        }
        if (graphQLEventCollectionFeedUnit.m7141r() != null) {
            jsonGenerator.a("title");
            GraphQLTextWithEntities__JsonHelper.a(jsonGenerator, graphQLEventCollectionFeedUnit.m7141r(), true);
        }
        if (graphQLEventCollectionFeedUnit.m7135k() != null) {
            jsonGenerator.a("tracking", graphQLEventCollectionFeedUnit.m7135k());
        }
        if (1 != null) {
            jsonGenerator.g();
        }
    }

    static {
        FbSerializerProvider.a(GraphQLEventCollectionFeedUnit.class, new GraphQLEventCollectionFeedUnitSerializer());
    }
}
