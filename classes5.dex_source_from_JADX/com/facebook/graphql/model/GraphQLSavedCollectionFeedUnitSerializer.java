package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: VERTICAL_COMPONENTS_WITH_TRANSPARENT_BACKGROUND */
public class GraphQLSavedCollectionFeedUnitSerializer extends JsonSerializer<GraphQLSavedCollectionFeedUnit> {
    public final void m21551a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLSavedCollectionFeedUnit graphQLSavedCollectionFeedUnit = (GraphQLSavedCollectionFeedUnit) obj;
        if (1 != null) {
            jsonGenerator.f();
        }
        if (graphQLSavedCollectionFeedUnit.getType() != null) {
            jsonGenerator.a("__type__");
            jsonGenerator.f();
            jsonGenerator.a("name", graphQLSavedCollectionFeedUnit.getType().e());
            jsonGenerator.g();
        }
        jsonGenerator.a("action_links");
        if (graphQLSavedCollectionFeedUnit.t() != null) {
            jsonGenerator.d();
            for (GraphQLStoryActionLink graphQLStoryActionLink : graphQLSavedCollectionFeedUnit.t()) {
                if (graphQLStoryActionLink != null) {
                    GraphQLStoryActionLink__JsonHelper.m21848a(jsonGenerator, graphQLStoryActionLink, true);
                }
            }
            jsonGenerator.e();
        } else {
            jsonGenerator.h();
        }
        if (graphQLSavedCollectionFeedUnit.g() != null) {
            jsonGenerator.a("cache_id", graphQLSavedCollectionFeedUnit.g());
        }
        if (graphQLSavedCollectionFeedUnit.S_() != null) {
            jsonGenerator.a("debug_info", graphQLSavedCollectionFeedUnit.S_());
        }
        jsonGenerator.a("fetchTimeMs", graphQLSavedCollectionFeedUnit.T_());
        jsonGenerator.a("items");
        if (graphQLSavedCollectionFeedUnit.u() != null) {
            jsonGenerator.d();
            for (GraphQLSavedCollectionFeedUnitItem graphQLSavedCollectionFeedUnitItem : graphQLSavedCollectionFeedUnit.u()) {
                if (graphQLSavedCollectionFeedUnitItem != null) {
                    GraphQLSavedCollectionFeedUnitItem__JsonHelper.m21549a(jsonGenerator, graphQLSavedCollectionFeedUnitItem, true);
                }
            }
            jsonGenerator.e();
        } else {
            jsonGenerator.h();
        }
        jsonGenerator.a("savedActionLinks");
        if (graphQLSavedCollectionFeedUnit.x() != null) {
            jsonGenerator.d();
            for (GraphQLStoryActionLink graphQLStoryActionLink2 : graphQLSavedCollectionFeedUnit.x()) {
                if (graphQLStoryActionLink2 != null) {
                    GraphQLStoryActionLink__JsonHelper.m21848a(jsonGenerator, graphQLStoryActionLink2, true);
                }
            }
            jsonGenerator.e();
        } else {
            jsonGenerator.h();
        }
        if (graphQLSavedCollectionFeedUnit.y() != null) {
            jsonGenerator.a("savedCollection");
            GraphQLTimelineAppCollection__JsonHelper.m22161a(jsonGenerator, graphQLSavedCollectionFeedUnit.y(), true);
        }
        jsonGenerator.a("savedItems");
        if (graphQLSavedCollectionFeedUnit.z() != null) {
            jsonGenerator.d();
            for (GraphQLSavedCollectionFeedUnitItem graphQLSavedCollectionFeedUnitItem2 : graphQLSavedCollectionFeedUnit.z()) {
                if (graphQLSavedCollectionFeedUnitItem2 != null) {
                    GraphQLSavedCollectionFeedUnitItem__JsonHelper.m21549a(jsonGenerator, graphQLSavedCollectionFeedUnitItem2, true);
                }
            }
            jsonGenerator.e();
        } else {
            jsonGenerator.h();
        }
        if (graphQLSavedCollectionFeedUnit.A() != null) {
            jsonGenerator.a("savedTitle");
            GraphQLTextWithEntities__JsonHelper.a(jsonGenerator, graphQLSavedCollectionFeedUnit.A(), true);
        }
        if (graphQLSavedCollectionFeedUnit.B() != null) {
            jsonGenerator.a("short_term_cache_key", graphQLSavedCollectionFeedUnit.B());
        }
        if (graphQLSavedCollectionFeedUnit.C() != null) {
            jsonGenerator.a("title");
            GraphQLTextWithEntities__JsonHelper.a(jsonGenerator, graphQLSavedCollectionFeedUnit.C(), true);
        }
        if (graphQLSavedCollectionFeedUnit.k() != null) {
            jsonGenerator.a("tracking", graphQLSavedCollectionFeedUnit.k());
        }
        if (graphQLSavedCollectionFeedUnit.D() != null) {
            jsonGenerator.a("local_last_negative_feedback_action_type", graphQLSavedCollectionFeedUnit.D());
        }
        if (graphQLSavedCollectionFeedUnit.E() != null) {
            jsonGenerator.a("local_story_visibility", graphQLSavedCollectionFeedUnit.E());
        }
        jsonGenerator.a("local_story_visible_height", graphQLSavedCollectionFeedUnit.F());
        if (1 != null) {
            jsonGenerator.g();
        }
    }

    static {
        FbSerializerProvider.a(GraphQLSavedCollectionFeedUnit.class, new GraphQLSavedCollectionFeedUnitSerializer());
    }
}
