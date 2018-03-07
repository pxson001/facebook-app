package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: ipad_sidefeed_group_gymj */
public class GraphQLCreativePagesYouMayLikeFeedUnitSerializer extends JsonSerializer<GraphQLCreativePagesYouMayLikeFeedUnit> {
    public final void m6903a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLCreativePagesYouMayLikeFeedUnit graphQLCreativePagesYouMayLikeFeedUnit = (GraphQLCreativePagesYouMayLikeFeedUnit) obj;
        if (1 != null) {
            jsonGenerator.f();
        }
        if (graphQLCreativePagesYouMayLikeFeedUnit.getType() != null) {
            jsonGenerator.a("__type__");
            jsonGenerator.f();
            jsonGenerator.a("name", graphQLCreativePagesYouMayLikeFeedUnit.getType().e());
            jsonGenerator.g();
        }
        if (graphQLCreativePagesYouMayLikeFeedUnit.g() != null) {
            jsonGenerator.a("cache_id", graphQLCreativePagesYouMayLikeFeedUnit.g());
        }
        jsonGenerator.a("creativePymlItems");
        if (graphQLCreativePagesYouMayLikeFeedUnit.x() != null) {
            jsonGenerator.d();
            for (GraphQLCreativePagesYouMayLikeFeedUnitItem graphQLCreativePagesYouMayLikeFeedUnitItem : graphQLCreativePagesYouMayLikeFeedUnit.x()) {
                if (graphQLCreativePagesYouMayLikeFeedUnitItem != null) {
                    GraphQLCreativePagesYouMayLikeFeedUnitItem__JsonHelper.m6901a(jsonGenerator, graphQLCreativePagesYouMayLikeFeedUnitItem, true);
                }
            }
            jsonGenerator.e();
        } else {
            jsonGenerator.h();
        }
        if (graphQLCreativePagesYouMayLikeFeedUnit.y() != null) {
            jsonGenerator.a("creativePymlTitle");
            GraphQLTextWithEntities__JsonHelper.a(jsonGenerator, graphQLCreativePagesYouMayLikeFeedUnit.y(), true);
        }
        if (graphQLCreativePagesYouMayLikeFeedUnit.S_() != null) {
            jsonGenerator.a("debug_info", graphQLCreativePagesYouMayLikeFeedUnit.S_());
        }
        jsonGenerator.a("fetchTimeMs", graphQLCreativePagesYouMayLikeFeedUnit.T_());
        jsonGenerator.a("items");
        if (graphQLCreativePagesYouMayLikeFeedUnit.z() != null) {
            jsonGenerator.d();
            for (GraphQLCreativePagesYouMayLikeFeedUnitItem graphQLCreativePagesYouMayLikeFeedUnitItem2 : graphQLCreativePagesYouMayLikeFeedUnit.z()) {
                if (graphQLCreativePagesYouMayLikeFeedUnitItem2 != null) {
                    GraphQLCreativePagesYouMayLikeFeedUnitItem__JsonHelper.m6901a(jsonGenerator, graphQLCreativePagesYouMayLikeFeedUnitItem2, true);
                }
            }
            jsonGenerator.e();
        } else {
            jsonGenerator.h();
        }
        if (graphQLCreativePagesYouMayLikeFeedUnit.A() != null) {
            jsonGenerator.a("short_term_cache_key", graphQLCreativePagesYouMayLikeFeedUnit.A());
        }
        if (graphQLCreativePagesYouMayLikeFeedUnit.B() != null) {
            jsonGenerator.a("title");
            GraphQLTextWithEntities__JsonHelper.a(jsonGenerator, graphQLCreativePagesYouMayLikeFeedUnit.B(), true);
        }
        if (graphQLCreativePagesYouMayLikeFeedUnit.k() != null) {
            jsonGenerator.a("tracking", graphQLCreativePagesYouMayLikeFeedUnit.k());
        }
        if (graphQLCreativePagesYouMayLikeFeedUnit.C() != null) {
            jsonGenerator.a("local_last_negative_feedback_action_type", graphQLCreativePagesYouMayLikeFeedUnit.C());
        }
        if (graphQLCreativePagesYouMayLikeFeedUnit.D() != null) {
            jsonGenerator.a("local_story_visibility", graphQLCreativePagesYouMayLikeFeedUnit.D());
        }
        jsonGenerator.a("local_story_visible_height", graphQLCreativePagesYouMayLikeFeedUnit.E());
        if (1 != null) {
            jsonGenerator.g();
        }
    }

    static {
        FbSerializerProvider.a(GraphQLCreativePagesYouMayLikeFeedUnit.class, new GraphQLCreativePagesYouMayLikeFeedUnitSerializer());
    }
}
