package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: User attribute given of un-supported type */
public class GraphQLSocialWifiFeedUnitSerializer extends JsonSerializer<GraphQLSocialWifiFeedUnit> {
    public final void m21687a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLSocialWifiFeedUnit graphQLSocialWifiFeedUnit = (GraphQLSocialWifiFeedUnit) obj;
        if (1 != null) {
            jsonGenerator.f();
        }
        if (graphQLSocialWifiFeedUnit.getType() != null) {
            jsonGenerator.a("__type__");
            jsonGenerator.f();
            jsonGenerator.a("name", graphQLSocialWifiFeedUnit.getType().e());
            jsonGenerator.g();
        }
        if (graphQLSocialWifiFeedUnit.g() != null) {
            jsonGenerator.a("cache_id", graphQLSocialWifiFeedUnit.g());
        }
        if (graphQLSocialWifiFeedUnit.S_() != null) {
            jsonGenerator.a("debug_info", graphQLSocialWifiFeedUnit.S_());
        }
        jsonGenerator.a("fetchTimeMs", graphQLSocialWifiFeedUnit.T_());
        jsonGenerator.a("items");
        if (graphQLSocialWifiFeedUnit.n() != null) {
            jsonGenerator.d();
            for (GraphQLSocialWifiFeedUnitItem graphQLSocialWifiFeedUnitItem : graphQLSocialWifiFeedUnit.n()) {
                if (graphQLSocialWifiFeedUnitItem != null) {
                    GraphQLSocialWifiFeedUnitItem__JsonHelper.m21685a(jsonGenerator, graphQLSocialWifiFeedUnitItem, true);
                }
            }
            jsonGenerator.e();
        } else {
            jsonGenerator.h();
        }
        if (graphQLSocialWifiFeedUnit.o() != null) {
            jsonGenerator.a("short_term_cache_key", graphQLSocialWifiFeedUnit.o());
        }
        jsonGenerator.a("socialWifiItems");
        if (graphQLSocialWifiFeedUnit.p() != null) {
            jsonGenerator.d();
            for (GraphQLSocialWifiFeedUnitItem graphQLSocialWifiFeedUnitItem2 : graphQLSocialWifiFeedUnit.p()) {
                if (graphQLSocialWifiFeedUnitItem2 != null) {
                    GraphQLSocialWifiFeedUnitItem__JsonHelper.m21685a(jsonGenerator, graphQLSocialWifiFeedUnitItem2, true);
                }
            }
            jsonGenerator.e();
        } else {
            jsonGenerator.h();
        }
        if (graphQLSocialWifiFeedUnit.q() != null) {
            jsonGenerator.a("socialWifiTitle");
            GraphQLTextWithEntities__JsonHelper.a(jsonGenerator, graphQLSocialWifiFeedUnit.q(), true);
        }
        if (graphQLSocialWifiFeedUnit.r() != null) {
            jsonGenerator.a("title");
            GraphQLTextWithEntities__JsonHelper.a(jsonGenerator, graphQLSocialWifiFeedUnit.r(), true);
        }
        if (graphQLSocialWifiFeedUnit.k() != null) {
            jsonGenerator.a("tracking", graphQLSocialWifiFeedUnit.k());
        }
        if (1 != null) {
            jsonGenerator.g();
        }
    }

    static {
        FbSerializerProvider.a(GraphQLSocialWifiFeedUnit.class, new GraphQLSocialWifiFeedUnitSerializer());
    }
}
