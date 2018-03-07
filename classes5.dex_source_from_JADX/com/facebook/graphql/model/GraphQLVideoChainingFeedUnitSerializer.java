package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: Tile stringKey is null */
public class GraphQLVideoChainingFeedUnitSerializer extends JsonSerializer<GraphQLVideoChainingFeedUnit> {
    public final void m22434a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLVideoChainingFeedUnit graphQLVideoChainingFeedUnit = (GraphQLVideoChainingFeedUnit) obj;
        if (1 != null) {
            jsonGenerator.f();
        }
        if (graphQLVideoChainingFeedUnit.getType() != null) {
            jsonGenerator.a("__type__");
            jsonGenerator.f();
            jsonGenerator.a("name", graphQLVideoChainingFeedUnit.getType().e());
            jsonGenerator.g();
        }
        if (graphQLVideoChainingFeedUnit.g() != null) {
            jsonGenerator.a("cache_id", graphQLVideoChainingFeedUnit.g());
        }
        if (graphQLVideoChainingFeedUnit.S_() != null) {
            jsonGenerator.a("debug_info", graphQLVideoChainingFeedUnit.S_());
        }
        jsonGenerator.a("fetchTimeMs", graphQLVideoChainingFeedUnit.T_());
        if (graphQLVideoChainingFeedUnit.o() != null) {
            jsonGenerator.a("id", graphQLVideoChainingFeedUnit.o());
        }
        if (graphQLVideoChainingFeedUnit.p() != null) {
            jsonGenerator.a("original_video");
            GraphQLVideo__JsonHelper.m22484a(jsonGenerator, graphQLVideoChainingFeedUnit.p(), true);
        }
        if (graphQLVideoChainingFeedUnit.q() != null) {
            jsonGenerator.a("short_term_cache_key", graphQLVideoChainingFeedUnit.q());
        }
        if (graphQLVideoChainingFeedUnit.r() != null) {
            jsonGenerator.a("suggested_videos");
            GraphQLSuggestedVideoConnection__JsonHelper.m22027a(jsonGenerator, graphQLVideoChainingFeedUnit.r(), true);
        }
        if (graphQLVideoChainingFeedUnit.s() != null) {
            jsonGenerator.a("title");
            GraphQLTextWithEntities__JsonHelper.a(jsonGenerator, graphQLVideoChainingFeedUnit.s(), true);
        }
        if (graphQLVideoChainingFeedUnit.t() != null) {
            jsonGenerator.a("titleForSummary");
            GraphQLTextWithEntities__JsonHelper.a(jsonGenerator, graphQLVideoChainingFeedUnit.t(), true);
        }
        if (graphQLVideoChainingFeedUnit.k() != null) {
            jsonGenerator.a("tracking", graphQLVideoChainingFeedUnit.k());
        }
        if (graphQLVideoChainingFeedUnit.u() != null) {
            jsonGenerator.a("url", graphQLVideoChainingFeedUnit.u());
        }
        if (graphQLVideoChainingFeedUnit.x() != null) {
            jsonGenerator.a("videoChainingTitle");
            GraphQLTextWithEntities__JsonHelper.a(jsonGenerator, graphQLVideoChainingFeedUnit.x(), true);
        }
        if (1 != null) {
            jsonGenerator.g();
        }
    }

    static {
        FbSerializerProvider.a(GraphQLVideoChainingFeedUnit.class, new GraphQLVideoChainingFeedUnitSerializer());
    }
}
