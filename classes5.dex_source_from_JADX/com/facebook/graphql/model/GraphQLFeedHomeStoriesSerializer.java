package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: hprofUpload */
public class GraphQLFeedHomeStoriesSerializer extends JsonSerializer<GraphQLFeedHomeStories> {
    public final void m7458a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLFeedHomeStories graphQLFeedHomeStories = (GraphQLFeedHomeStories) obj;
        if (1 != null) {
            jsonGenerator.f();
        }
        jsonGenerator.a("approximate_new_unit_count", graphQLFeedHomeStories.a());
        if (graphQLFeedHomeStories.j() != null) {
            jsonGenerator.a("debug_info", graphQLFeedHomeStories.j());
        }
        jsonGenerator.a("edges");
        if (graphQLFeedHomeStories.k() != null) {
            jsonGenerator.d();
            for (GraphQLFeedUnitEdge graphQLFeedUnitEdge : graphQLFeedHomeStories.k()) {
                if (graphQLFeedUnitEdge != null) {
                    GraphQLFeedUnitEdge__JsonHelper.m7472a(jsonGenerator, graphQLFeedUnitEdge, true);
                }
            }
            jsonGenerator.e();
        } else {
            jsonGenerator.h();
        }
        jsonGenerator.a("low_engagement_deduplication_keys");
        if (graphQLFeedHomeStories.l() != null) {
            jsonGenerator.d();
            for (String str : graphQLFeedHomeStories.l()) {
                if (str != null) {
                    jsonGenerator.b(str);
                }
            }
            jsonGenerator.e();
        } else {
            jsonGenerator.h();
        }
        jsonGenerator.a("no_feed_polling", graphQLFeedHomeStories.m());
        if (graphQLFeedHomeStories.n() != null) {
            jsonGenerator.a("page_info");
            GraphQLPageInfo__JsonHelper.a(jsonGenerator, graphQLFeedHomeStories.n(), true);
        }
        if (graphQLFeedHomeStories.o() != null) {
            jsonGenerator.a("query_function", graphQLFeedHomeStories.o());
        }
        if (graphQLFeedHomeStories.p() != null) {
            jsonGenerator.a("query_title", graphQLFeedHomeStories.p());
        }
        if (1 != null) {
            jsonGenerator.g();
        }
    }

    static {
        FbSerializerProvider.a(GraphQLFeedHomeStories.class, new GraphQLFeedHomeStoriesSerializer());
    }
}
