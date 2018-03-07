package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.facebook.graphql.enums.GraphQLObjectType;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

/* compiled from: Trying to get API request when we should not be deleting from server */
public final class GraphQLTopic__JsonHelper {
    public static GraphQLTopic m22278a(JsonParser jsonParser) {
        GraphQLTopic graphQLTopic = new GraphQLTopic();
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
                graphQLTopic.d = graphQLObjectType;
                FieldAccessQueryTracker.a(jsonParser, graphQLTopic, "__type__", graphQLTopic.a_, 0, false);
            } else if ("id".equals(i)) {
                r3 = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                graphQLTopic.e = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLTopic, "id", graphQLTopic.a_, 1, false);
            } else if ("name".equals(i)) {
                r3 = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                graphQLTopic.f = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLTopic, "name", graphQLTopic.a_, 2, false);
            } else if ("profile_picture".equals(i)) {
                GraphQLImage graphQLImage;
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    graphQLImage = null;
                } else {
                    graphQLImage = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "profile_picture"));
                }
                graphQLTopic.g = graphQLImage;
                FieldAccessQueryTracker.a(jsonParser, graphQLTopic, "profile_picture", graphQLTopic.a_, 3, true);
            } else if ("related_article_title".equals(i)) {
                r3 = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                graphQLTopic.h = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLTopic, "related_article_title", graphQLTopic.a_, 4, false);
            } else if ("tag".equals(i)) {
                r3 = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                graphQLTopic.i = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLTopic, "tag", graphQLTopic.a_, 5, false);
            }
            jsonParser.f();
        }
        return graphQLTopic;
    }

    public static void m22279a(JsonGenerator jsonGenerator, GraphQLTopic graphQLTopic, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        if (graphQLTopic.j() != null) {
            jsonGenerator.a("__type__");
            jsonGenerator.f();
            jsonGenerator.a("name", graphQLTopic.j().e());
            jsonGenerator.g();
        }
        if (graphQLTopic.k() != null) {
            jsonGenerator.a("id", graphQLTopic.k());
        }
        if (graphQLTopic.l() != null) {
            jsonGenerator.a("name", graphQLTopic.l());
        }
        if (graphQLTopic.m() != null) {
            jsonGenerator.a("profile_picture");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLTopic.m(), true);
        }
        if (graphQLTopic.n() != null) {
            jsonGenerator.a("related_article_title", graphQLTopic.n());
        }
        if (graphQLTopic.o() != null) {
            jsonGenerator.a("tag", graphQLTopic.o());
        }
        if (z) {
            jsonGenerator.g();
        }
    }
}
