package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* compiled from: full_name */
public final class GraphQLGraphSearchSnippet__JsonHelper {
    public static GraphQLGraphSearchSnippet m8320a(JsonParser jsonParser) {
        GraphQLGraphSearchSnippet graphQLGraphSearchSnippet = new GraphQLGraphSearchSnippet();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            return null;
        }
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            GraphQLTextWithEntities graphQLTextWithEntities = null;
            if ("detail_sentences".equals(i)) {
                Collection arrayList;
                List copyOf;
                if (jsonParser.g() == JsonToken.START_ARRAY) {
                    arrayList = new ArrayList();
                    while (jsonParser.c() != JsonToken.END_ARRAY) {
                        GraphQLTextWithEntities a = GraphQLTextWithEntities__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "detail_sentences"));
                        if (a != null) {
                            arrayList.add(a);
                        }
                    }
                } else {
                    arrayList = null;
                }
                if (arrayList != null) {
                    copyOf = ImmutableList.copyOf(arrayList);
                }
                graphQLGraphSearchSnippet.f4124d = copyOf;
                FieldAccessQueryTracker.a(jsonParser, graphQLGraphSearchSnippet, "detail_sentences", graphQLGraphSearchSnippet.a_, 0, true);
            } else if ("sentence".equals(i)) {
                if (jsonParser.g() != JsonToken.VALUE_NULL) {
                    graphQLTextWithEntities = GraphQLTextWithEntities__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "sentence"));
                }
                graphQLGraphSearchSnippet.f4125e = graphQLTextWithEntities;
                FieldAccessQueryTracker.a(jsonParser, graphQLGraphSearchSnippet, "sentence", graphQLGraphSearchSnippet.a_, 1, true);
            } else {
                int i2 = 0;
            }
            jsonParser.f();
        }
        return graphQLGraphSearchSnippet;
    }

    public static void m8321a(JsonGenerator jsonGenerator, GraphQLGraphSearchSnippet graphQLGraphSearchSnippet, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        jsonGenerator.a("detail_sentences");
        if (graphQLGraphSearchSnippet.m8316a() != null) {
            jsonGenerator.d();
            for (GraphQLTextWithEntities graphQLTextWithEntities : graphQLGraphSearchSnippet.m8316a()) {
                if (graphQLTextWithEntities != null) {
                    GraphQLTextWithEntities__JsonHelper.a(jsonGenerator, graphQLTextWithEntities, true);
                }
            }
            jsonGenerator.e();
        } else {
            jsonGenerator.h();
        }
        if (graphQLGraphSearchSnippet.m8317j() != null) {
            jsonGenerator.a("sentence");
            GraphQLTextWithEntities__JsonHelper.a(jsonGenerator, graphQLGraphSearchSnippet.m8317j(), true);
        }
        if (z) {
            jsonGenerator.g();
        }
    }
}
