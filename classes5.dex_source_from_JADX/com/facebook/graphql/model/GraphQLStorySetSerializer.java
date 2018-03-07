package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.facebook.graphql.enums.GraphQLStorySetCollectionType;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: USER_SETTINGS */
public class GraphQLStorySetSerializer extends JsonSerializer<GraphQLStorySet> {
    public final void m21906a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLStorySet graphQLStorySet = (GraphQLStorySet) obj;
        if (1 != null) {
            jsonGenerator.f();
        }
        if (graphQLStorySet.getType() != null) {
            jsonGenerator.a("__type__");
            jsonGenerator.f();
            jsonGenerator.a("name", graphQLStorySet.getType().e());
            jsonGenerator.g();
        }
        jsonGenerator.a("action_links");
        if (graphQLStorySet.y() != null) {
            jsonGenerator.d();
            for (GraphQLStoryActionLink graphQLStoryActionLink : graphQLStorySet.y()) {
                if (graphQLStoryActionLink != null) {
                    GraphQLStoryActionLink__JsonHelper.m21848a(jsonGenerator, graphQLStoryActionLink, true);
                }
            }
            jsonGenerator.e();
        } else {
            jsonGenerator.h();
        }
        if (graphQLStorySet.z() != null) {
            jsonGenerator.a("all_stories");
            GraphQLStorySetStoriesConnection__JsonHelper.m21914a(jsonGenerator, graphQLStorySet.z(), true);
        }
        if (graphQLStorySet.g() != null) {
            jsonGenerator.a("cache_id", graphQLStorySet.g());
        }
        if (graphQLStorySet.S_() != null) {
            jsonGenerator.a("debug_info", graphQLStorySet.S_());
        }
        if (graphQLStorySet.A() != null) {
            jsonGenerator.a("feed_unit_pagination_identifier", graphQLStorySet.A());
        }
        jsonGenerator.a("fetchTimeMs", graphQLStorySet.T_());
        if (graphQLStorySet.B() != null) {
            jsonGenerator.a("id", graphQLStorySet.B());
        }
        if (graphQLStorySet.C() != null) {
            jsonGenerator.a("short_term_cache_key", graphQLStorySet.C());
        }
        if (graphQLStorySet.D() != null) {
            jsonGenerator.a("title");
            GraphQLTextWithEntities__JsonHelper.a(jsonGenerator, graphQLStorySet.D(), true);
        }
        if (graphQLStorySet.E() != null) {
            jsonGenerator.a("titleForSummary");
            GraphQLTextWithEntities__JsonHelper.a(jsonGenerator, graphQLStorySet.E(), true);
        }
        if (graphQLStorySet.k() != null) {
            jsonGenerator.a("tracking", graphQLStorySet.k());
        }
        if (graphQLStorySet.F() != null) {
            jsonGenerator.a("url", graphQLStorySet.F());
        }
        jsonGenerator.a("collection_type_list");
        if (graphQLStorySet.G() != null) {
            jsonGenerator.d();
            for (GraphQLStorySetCollectionType graphQLStorySetCollectionType : graphQLStorySet.G()) {
                if (graphQLStorySetCollectionType != null) {
                    jsonGenerator.b(graphQLStorySetCollectionType.toString());
                }
            }
            jsonGenerator.e();
        } else {
            jsonGenerator.h();
        }
        if (graphQLStorySet.H() != null) {
            jsonGenerator.a("hideable_token", graphQLStorySet.H());
        }
        if (graphQLStorySet.I() != null) {
            jsonGenerator.a("negative_feedback_actions");
            GraphQLNegativeFeedbackActionsConnection__JsonHelper.m9244a(jsonGenerator, graphQLStorySet.I(), true);
        }
        if (graphQLStorySet.J() != null) {
            jsonGenerator.a("local_last_negative_feedback_action_type", graphQLStorySet.J());
        }
        if (graphQLStorySet.K() != null) {
            jsonGenerator.a("local_story_visibility", graphQLStorySet.K());
        }
        jsonGenerator.a("local_story_visible_height", graphQLStorySet.L());
        if (graphQLStorySet.M() != null) {
            jsonGenerator.a("set_icon");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLStorySet.M(), true);
        }
        if (1 != null) {
            jsonGenerator.g();
        }
    }

    static {
        FbSerializerProvider.a(GraphQLStorySet.class, new GraphQLStorySetSerializer());
    }
}
