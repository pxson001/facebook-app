package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: is_delegating_delete */
public class GraphQLCelebrationsFeedUnitSerializer extends JsonSerializer<GraphQLCelebrationsFeedUnit> {
    public final void m6758a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLCelebrationsFeedUnit graphQLCelebrationsFeedUnit = (GraphQLCelebrationsFeedUnit) obj;
        if (1 != null) {
            jsonGenerator.f();
        }
        if (graphQLCelebrationsFeedUnit.getType() != null) {
            jsonGenerator.a("__type__");
            jsonGenerator.f();
            jsonGenerator.a("name", graphQLCelebrationsFeedUnit.getType().e());
            jsonGenerator.g();
        }
        if (graphQLCelebrationsFeedUnit.g() != null) {
            jsonGenerator.a("cache_id", graphQLCelebrationsFeedUnit.g());
        }
        jsonGenerator.a("celebsItems");
        if (graphQLCelebrationsFeedUnit.o() != null) {
            jsonGenerator.d();
            for (GraphQLCelebrationsFeedUnitItem graphQLCelebrationsFeedUnitItem : graphQLCelebrationsFeedUnit.o()) {
                if (graphQLCelebrationsFeedUnitItem != null) {
                    GraphQLCelebrationsFeedUnitItem__JsonHelper.m6756a(jsonGenerator, graphQLCelebrationsFeedUnitItem, true);
                }
            }
            jsonGenerator.e();
        } else {
            jsonGenerator.h();
        }
        if (graphQLCelebrationsFeedUnit.p() != null) {
            jsonGenerator.a("celebsTitle");
            GraphQLTextWithEntities__JsonHelper.a(jsonGenerator, graphQLCelebrationsFeedUnit.p(), true);
        }
        if (graphQLCelebrationsFeedUnit.S_() != null) {
            jsonGenerator.a("debug_info", graphQLCelebrationsFeedUnit.S_());
        }
        jsonGenerator.a("fetchTimeMs", graphQLCelebrationsFeedUnit.T_());
        jsonGenerator.a("items");
        if (graphQLCelebrationsFeedUnit.q() != null) {
            jsonGenerator.d();
            for (GraphQLCelebrationsFeedUnitItem graphQLCelebrationsFeedUnitItem2 : graphQLCelebrationsFeedUnit.q()) {
                if (graphQLCelebrationsFeedUnitItem2 != null) {
                    GraphQLCelebrationsFeedUnitItem__JsonHelper.m6756a(jsonGenerator, graphQLCelebrationsFeedUnitItem2, true);
                }
            }
            jsonGenerator.e();
        } else {
            jsonGenerator.h();
        }
        if (graphQLCelebrationsFeedUnit.r() != null) {
            jsonGenerator.a("short_term_cache_key", graphQLCelebrationsFeedUnit.r());
        }
        if (graphQLCelebrationsFeedUnit.s() != null) {
            jsonGenerator.a("title");
            GraphQLTextWithEntities__JsonHelper.a(jsonGenerator, graphQLCelebrationsFeedUnit.s(), true);
        }
        if (graphQLCelebrationsFeedUnit.k() != null) {
            jsonGenerator.a("tracking", graphQLCelebrationsFeedUnit.k());
        }
        if (1 != null) {
            jsonGenerator.g();
        }
    }

    static {
        FbSerializerProvider.a(GraphQLCelebrationsFeedUnit.class, new GraphQLCelebrationsFeedUnitSerializer());
    }
}
