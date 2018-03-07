package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: errorSubcode */
public class GraphQLPYMLWithLargeImageFeedUnitSerializer extends JsonSerializer<GraphQLPYMLWithLargeImageFeedUnit> {
    public final void m9447a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLPYMLWithLargeImageFeedUnit graphQLPYMLWithLargeImageFeedUnit = (GraphQLPYMLWithLargeImageFeedUnit) obj;
        if (1 != null) {
            jsonGenerator.f();
        }
        if (graphQLPYMLWithLargeImageFeedUnit.getType() != null) {
            jsonGenerator.a("__type__");
            jsonGenerator.f();
            jsonGenerator.a("name", graphQLPYMLWithLargeImageFeedUnit.getType().e());
            jsonGenerator.g();
        }
        if (graphQLPYMLWithLargeImageFeedUnit.g() != null) {
            jsonGenerator.a("cache_id", graphQLPYMLWithLargeImageFeedUnit.g());
        }
        if (graphQLPYMLWithLargeImageFeedUnit.S_() != null) {
            jsonGenerator.a("debug_info", graphQLPYMLWithLargeImageFeedUnit.S_());
        }
        if (graphQLPYMLWithLargeImageFeedUnit.y() != null) {
            jsonGenerator.a("feed_unit_pagination_identifier", graphQLPYMLWithLargeImageFeedUnit.y());
        }
        jsonGenerator.a("fetchTimeMs", graphQLPYMLWithLargeImageFeedUnit.T_());
        jsonGenerator.a("items");
        if (graphQLPYMLWithLargeImageFeedUnit.z() != null) {
            jsonGenerator.d();
            for (GraphQLPYMLWithLargeImageFeedUnitItem graphQLPYMLWithLargeImageFeedUnitItem : graphQLPYMLWithLargeImageFeedUnit.z()) {
                if (graphQLPYMLWithLargeImageFeedUnitItem != null) {
                    GraphQLPYMLWithLargeImageFeedUnitItem__JsonHelper.m9445a(jsonGenerator, graphQLPYMLWithLargeImageFeedUnitItem, true);
                }
            }
            jsonGenerator.e();
        } else {
            jsonGenerator.h();
        }
        if (graphQLPYMLWithLargeImageFeedUnit.A() != null) {
            jsonGenerator.a("pymlWithLargeImageFeedUnitPaginationIdentifier", graphQLPYMLWithLargeImageFeedUnit.A());
        }
        if (graphQLPYMLWithLargeImageFeedUnit.B() != null) {
            jsonGenerator.a("pymlWithLargeImageItems");
            GraphQLPYMLWithLargeImageFeedUnitsConnection__JsonHelper.m9453a(jsonGenerator, graphQLPYMLWithLargeImageFeedUnit.B(), true);
        }
        if (graphQLPYMLWithLargeImageFeedUnit.C() != null) {
            jsonGenerator.a("pymlWithLargeImageTitle");
            GraphQLTextWithEntities__JsonHelper.a(jsonGenerator, graphQLPYMLWithLargeImageFeedUnit.C(), true);
        }
        if (graphQLPYMLWithLargeImageFeedUnit.D() != null) {
            jsonGenerator.a("short_term_cache_key", graphQLPYMLWithLargeImageFeedUnit.D());
        }
        if (graphQLPYMLWithLargeImageFeedUnit.E() != null) {
            jsonGenerator.a("title");
            GraphQLTextWithEntities__JsonHelper.a(jsonGenerator, graphQLPYMLWithLargeImageFeedUnit.E(), true);
        }
        if (graphQLPYMLWithLargeImageFeedUnit.k() != null) {
            jsonGenerator.a("tracking", graphQLPYMLWithLargeImageFeedUnit.k());
        }
        if (graphQLPYMLWithLargeImageFeedUnit.F() != null) {
            jsonGenerator.a("local_last_negative_feedback_action_type", graphQLPYMLWithLargeImageFeedUnit.F());
        }
        if (graphQLPYMLWithLargeImageFeedUnit.G() != null) {
            jsonGenerator.a("local_story_visibility", graphQLPYMLWithLargeImageFeedUnit.G());
        }
        jsonGenerator.a("local_story_visible_height", graphQLPYMLWithLargeImageFeedUnit.H());
        if (1 != null) {
            jsonGenerator.g();
        }
    }

    static {
        FbSerializerProvider.a(GraphQLPYMLWithLargeImageFeedUnit.class, new GraphQLPYMLWithLargeImageFeedUnitSerializer());
    }
}
