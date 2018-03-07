package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: WRITE_POST_TO_PAGE */
public class GraphQLPagesYouMayLikeFeedUnitSerializer extends JsonSerializer<GraphQLPagesYouMayLikeFeedUnit> {
    public final void m20582a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLPagesYouMayLikeFeedUnit graphQLPagesYouMayLikeFeedUnit = (GraphQLPagesYouMayLikeFeedUnit) obj;
        if (1 != null) {
            jsonGenerator.f();
        }
        if (graphQLPagesYouMayLikeFeedUnit.getType() != null) {
            jsonGenerator.a("__type__");
            jsonGenerator.f();
            jsonGenerator.a("name", graphQLPagesYouMayLikeFeedUnit.getType().e());
            jsonGenerator.g();
        }
        if (graphQLPagesYouMayLikeFeedUnit.g() != null) {
            jsonGenerator.a("cache_id", graphQLPagesYouMayLikeFeedUnit.g());
        }
        if (graphQLPagesYouMayLikeFeedUnit.S_() != null) {
            jsonGenerator.a("debug_info", graphQLPagesYouMayLikeFeedUnit.S_());
        }
        jsonGenerator.a("fetchTimeMs", graphQLPagesYouMayLikeFeedUnit.T_());
        jsonGenerator.a("items");
        if (graphQLPagesYouMayLikeFeedUnit.s() != null) {
            jsonGenerator.d();
            for (GraphQLPagesYouMayLikeFeedUnitItem graphQLPagesYouMayLikeFeedUnitItem : graphQLPagesYouMayLikeFeedUnit.s()) {
                if (graphQLPagesYouMayLikeFeedUnitItem != null) {
                    GraphQLPagesYouMayLikeFeedUnitItem__JsonHelper.m20580a(jsonGenerator, graphQLPagesYouMayLikeFeedUnitItem, true);
                }
            }
            jsonGenerator.e();
        } else {
            jsonGenerator.h();
        }
        jsonGenerator.a("pymlItems");
        if (graphQLPagesYouMayLikeFeedUnit.t() != null) {
            jsonGenerator.d();
            for (GraphQLPagesYouMayLikeFeedUnitItem graphQLPagesYouMayLikeFeedUnitItem2 : graphQLPagesYouMayLikeFeedUnit.t()) {
                if (graphQLPagesYouMayLikeFeedUnitItem2 != null) {
                    GraphQLPagesYouMayLikeFeedUnitItem__JsonHelper.m20580a(jsonGenerator, graphQLPagesYouMayLikeFeedUnitItem2, true);
                }
            }
            jsonGenerator.e();
        } else {
            jsonGenerator.h();
        }
        if (graphQLPagesYouMayLikeFeedUnit.x() != null) {
            jsonGenerator.a("pymlPageBrowserCategory");
            GraphQLPageBrowserCategoryInfo__JsonHelper.m9479a(jsonGenerator, graphQLPagesYouMayLikeFeedUnit.x(), true);
        }
        if (graphQLPagesYouMayLikeFeedUnit.y() != null) {
            jsonGenerator.a("pymlTitle");
            GraphQLTextWithEntities__JsonHelper.a(jsonGenerator, graphQLPagesYouMayLikeFeedUnit.y(), true);
        }
        if (graphQLPagesYouMayLikeFeedUnit.z() != null) {
            jsonGenerator.a("short_term_cache_key", graphQLPagesYouMayLikeFeedUnit.z());
        }
        if (graphQLPagesYouMayLikeFeedUnit.A() != null) {
            jsonGenerator.a("title");
            GraphQLTextWithEntities__JsonHelper.a(jsonGenerator, graphQLPagesYouMayLikeFeedUnit.A(), true);
        }
        if (graphQLPagesYouMayLikeFeedUnit.k() != null) {
            jsonGenerator.a("tracking", graphQLPagesYouMayLikeFeedUnit.k());
        }
        if (graphQLPagesYouMayLikeFeedUnit.B() != null) {
            jsonGenerator.a("local_last_negative_feedback_action_type", graphQLPagesYouMayLikeFeedUnit.B());
        }
        if (graphQLPagesYouMayLikeFeedUnit.C() != null) {
            jsonGenerator.a("local_story_visibility", graphQLPagesYouMayLikeFeedUnit.C());
        }
        jsonGenerator.a("local_story_visible_height", graphQLPagesYouMayLikeFeedUnit.D());
        if (1 != null) {
            jsonGenerator.g();
        }
    }

    static {
        FbSerializerProvider.a(GraphQLPagesYouMayLikeFeedUnit.class, new GraphQLPagesYouMayLikeFeedUnitSerializer());
    }
}
