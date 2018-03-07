package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: fr_tab */
public class GraphQLGroupsYouShouldCreateFeedUnitSerializer extends JsonSerializer<GraphQLGroupsYouShouldCreateFeedUnit> {
    public final void m8542a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLGroupsYouShouldCreateFeedUnit graphQLGroupsYouShouldCreateFeedUnit = (GraphQLGroupsYouShouldCreateFeedUnit) obj;
        if (1 != null) {
            jsonGenerator.f();
        }
        if (graphQLGroupsYouShouldCreateFeedUnit.getType() != null) {
            jsonGenerator.a("__type__");
            jsonGenerator.f();
            jsonGenerator.a("name", graphQLGroupsYouShouldCreateFeedUnit.getType().e());
            jsonGenerator.g();
        }
        if (graphQLGroupsYouShouldCreateFeedUnit.g() != null) {
            jsonGenerator.a("cache_id", graphQLGroupsYouShouldCreateFeedUnit.g());
        }
        if (graphQLGroupsYouShouldCreateFeedUnit.S_() != null) {
            jsonGenerator.a("debug_info", graphQLGroupsYouShouldCreateFeedUnit.S_());
        }
        jsonGenerator.a("fetchTimeMs", graphQLGroupsYouShouldCreateFeedUnit.T_());
        jsonGenerator.a("gyscItems");
        if (graphQLGroupsYouShouldCreateFeedUnit.o() != null) {
            jsonGenerator.d();
            for (GraphQLGroupsYouShouldCreateFeedUnitItem graphQLGroupsYouShouldCreateFeedUnitItem : graphQLGroupsYouShouldCreateFeedUnit.o()) {
                if (graphQLGroupsYouShouldCreateFeedUnitItem != null) {
                    GraphQLGroupsYouShouldCreateFeedUnitItem__JsonHelper.m8540a(jsonGenerator, graphQLGroupsYouShouldCreateFeedUnitItem, true);
                }
            }
            jsonGenerator.e();
        } else {
            jsonGenerator.h();
        }
        if (graphQLGroupsYouShouldCreateFeedUnit.p() != null) {
            jsonGenerator.a("gyscTitle");
            GraphQLTextWithEntities__JsonHelper.a(jsonGenerator, graphQLGroupsYouShouldCreateFeedUnit.p(), true);
        }
        jsonGenerator.a("items");
        if (graphQLGroupsYouShouldCreateFeedUnit.q() != null) {
            jsonGenerator.d();
            for (GraphQLGroupsYouShouldCreateFeedUnitItem graphQLGroupsYouShouldCreateFeedUnitItem2 : graphQLGroupsYouShouldCreateFeedUnit.q()) {
                if (graphQLGroupsYouShouldCreateFeedUnitItem2 != null) {
                    GraphQLGroupsYouShouldCreateFeedUnitItem__JsonHelper.m8540a(jsonGenerator, graphQLGroupsYouShouldCreateFeedUnitItem2, true);
                }
            }
            jsonGenerator.e();
        } else {
            jsonGenerator.h();
        }
        if (graphQLGroupsYouShouldCreateFeedUnit.r() != null) {
            jsonGenerator.a("short_term_cache_key", graphQLGroupsYouShouldCreateFeedUnit.r());
        }
        if (graphQLGroupsYouShouldCreateFeedUnit.s() != null) {
            jsonGenerator.a("title");
            GraphQLTextWithEntities__JsonHelper.a(jsonGenerator, graphQLGroupsYouShouldCreateFeedUnit.s(), true);
        }
        if (graphQLGroupsYouShouldCreateFeedUnit.k() != null) {
            jsonGenerator.a("tracking", graphQLGroupsYouShouldCreateFeedUnit.k());
        }
        if (1 != null) {
            jsonGenerator.g();
        }
    }

    static {
        FbSerializerProvider.a(GraphQLGroupsYouShouldCreateFeedUnit.class, new GraphQLGroupsYouShouldCreateFeedUnitSerializer());
    }
}
