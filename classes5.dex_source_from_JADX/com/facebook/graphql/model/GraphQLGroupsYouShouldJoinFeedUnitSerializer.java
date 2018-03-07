package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: formatted_shipping_address */
public class GraphQLGroupsYouShouldJoinFeedUnitSerializer extends JsonSerializer<GraphQLGroupsYouShouldJoinFeedUnit> {
    public final void m8559a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLGroupsYouShouldJoinFeedUnit graphQLGroupsYouShouldJoinFeedUnit = (GraphQLGroupsYouShouldJoinFeedUnit) obj;
        if (1 != null) {
            jsonGenerator.f();
        }
        if (graphQLGroupsYouShouldJoinFeedUnit.getType() != null) {
            jsonGenerator.a("__type__");
            jsonGenerator.f();
            jsonGenerator.a("name", graphQLGroupsYouShouldJoinFeedUnit.getType().e());
            jsonGenerator.g();
        }
        if (graphQLGroupsYouShouldJoinFeedUnit.g() != null) {
            jsonGenerator.a("cache_id", graphQLGroupsYouShouldJoinFeedUnit.g());
        }
        if (graphQLGroupsYouShouldJoinFeedUnit.S_() != null) {
            jsonGenerator.a("debug_info", graphQLGroupsYouShouldJoinFeedUnit.S_());
        }
        jsonGenerator.a("fetchTimeMs", graphQLGroupsYouShouldJoinFeedUnit.T_());
        jsonGenerator.a("gysjItems");
        if (graphQLGroupsYouShouldJoinFeedUnit.l() != null) {
            jsonGenerator.d();
            for (GraphQLGroupsYouShouldJoinFeedUnitItem graphQLGroupsYouShouldJoinFeedUnitItem : graphQLGroupsYouShouldJoinFeedUnit.l()) {
                if (graphQLGroupsYouShouldJoinFeedUnitItem != null) {
                    GraphQLGroupsYouShouldJoinFeedUnitItem__JsonHelper.m8557a(jsonGenerator, graphQLGroupsYouShouldJoinFeedUnitItem, true);
                }
            }
            jsonGenerator.e();
        } else {
            jsonGenerator.h();
        }
        if (graphQLGroupsYouShouldJoinFeedUnit.o() != null) {
            jsonGenerator.a("gysjTitle");
            GraphQLTextWithEntities__JsonHelper.a(jsonGenerator, graphQLGroupsYouShouldJoinFeedUnit.o(), true);
        }
        jsonGenerator.a("items");
        if (graphQLGroupsYouShouldJoinFeedUnit.p() != null) {
            jsonGenerator.d();
            for (GraphQLGroupsYouShouldJoinFeedUnitItem graphQLGroupsYouShouldJoinFeedUnitItem2 : graphQLGroupsYouShouldJoinFeedUnit.p()) {
                if (graphQLGroupsYouShouldJoinFeedUnitItem2 != null) {
                    GraphQLGroupsYouShouldJoinFeedUnitItem__JsonHelper.m8557a(jsonGenerator, graphQLGroupsYouShouldJoinFeedUnitItem2, true);
                }
            }
            jsonGenerator.e();
        } else {
            jsonGenerator.h();
        }
        if (graphQLGroupsYouShouldJoinFeedUnit.q() != null) {
            jsonGenerator.a("short_term_cache_key", graphQLGroupsYouShouldJoinFeedUnit.q());
        }
        if (graphQLGroupsYouShouldJoinFeedUnit.r() != null) {
            jsonGenerator.a("title");
            GraphQLTextWithEntities__JsonHelper.a(jsonGenerator, graphQLGroupsYouShouldJoinFeedUnit.r(), true);
        }
        if (graphQLGroupsYouShouldJoinFeedUnit.k() != null) {
            jsonGenerator.a("tracking", graphQLGroupsYouShouldJoinFeedUnit.k());
        }
        if (1 != null) {
            jsonGenerator.g();
        }
    }

    static {
        FbSerializerProvider.a(GraphQLGroupsYouShouldJoinFeedUnit.class, new GraphQLGroupsYouShouldJoinFeedUnitSerializer());
    }
}
