package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.facebook.graphql.enums.GraphQLObjectType;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

/* compiled from: Type-wrapped deserializer's deserializeWithType should never get called */
public final class GraphQLTopicFeedOption__JsonHelper {
    public static GraphQLTopicFeedOption m22275a(JsonParser jsonParser) {
        GraphQLTopicFeedOption graphQLTopicFeedOption = new GraphQLTopicFeedOption();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            return null;
        }
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            if ("__type__".equals(i)) {
                GraphQLObjectType graphQLObjectType;
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    graphQLObjectType = null;
                } else {
                    graphQLObjectType = GraphQLObjectType.a(jsonParser);
                }
                graphQLTopicFeedOption.f13359d = graphQLObjectType;
                FieldAccessQueryTracker.a(jsonParser, graphQLTopicFeedOption, "__type__", graphQLTopicFeedOption.a_, 0, false);
            } else if ("id".equals(i)) {
                r3 = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                graphQLTopicFeedOption.f13360e = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLTopicFeedOption, "id", graphQLTopicFeedOption.a_, 1, false);
            } else if ("name".equals(i)) {
                r3 = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                graphQLTopicFeedOption.f13361f = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLTopicFeedOption, "name", graphQLTopicFeedOption.a_, 2, false);
            }
            jsonParser.f();
        }
        return graphQLTopicFeedOption;
    }

    public static void m22276a(JsonGenerator jsonGenerator, GraphQLTopicFeedOption graphQLTopicFeedOption, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        if (graphQLTopicFeedOption.m22270j() != null) {
            jsonGenerator.a("__type__");
            jsonGenerator.f();
            jsonGenerator.a("name", graphQLTopicFeedOption.m22270j().e());
            jsonGenerator.g();
        }
        if (graphQLTopicFeedOption.m22271k() != null) {
            jsonGenerator.a("id", graphQLTopicFeedOption.m22271k());
        }
        if (graphQLTopicFeedOption.m22272l() != null) {
            jsonGenerator.a("name", graphQLTopicFeedOption.m22272l());
        }
        if (z) {
            jsonGenerator.g();
        }
    }
}
