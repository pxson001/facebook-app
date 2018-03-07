package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.facebook.graphql.enums.GraphQLObjectType;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

/* compiled from: fallback_path */
public final class GraphQLMediaSet__JsonHelper {
    public static GraphQLMediaSet m9076a(JsonParser jsonParser) {
        GraphQLMediaSet graphQLMediaSet = new GraphQLMediaSet();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            return null;
        }
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            GraphQLTextWithEntities graphQLTextWithEntities = null;
            if ("__type__".equals(i)) {
                GraphQLObjectType a;
                if (jsonParser.g() != JsonToken.VALUE_NULL) {
                    a = GraphQLObjectType.a(jsonParser);
                }
                graphQLMediaSet.d = a;
                FieldAccessQueryTracker.a(jsonParser, graphQLMediaSet, "__type__", graphQLMediaSet.a_, 0, false);
            } else if ("id".equals(i)) {
                String o;
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                    o = jsonParser.o();
                }
                graphQLMediaSet.e = o;
                FieldAccessQueryTracker.a(jsonParser, graphQLMediaSet, "id", graphQLMediaSet.a_, 1, false);
            } else if ("media".equals(i)) {
                if (jsonParser.g() != JsonToken.VALUE_NULL) {
                    r3 = GraphQLMediaSetMediaConnection__JsonHelper.m9073a(FieldAccessQueryTracker.a(jsonParser, "media"));
                }
                graphQLMediaSet.f = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLMediaSet, "media", graphQLMediaSet.a_, 2, true);
            } else if ("media_list".equals(i)) {
                if (jsonParser.g() != JsonToken.VALUE_NULL) {
                    r3 = GraphQLMediaSetMediaConnection__JsonHelper.m9073a(FieldAccessQueryTracker.a(jsonParser, "media_list"));
                }
                graphQLMediaSet.g = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLMediaSet, "media_list", graphQLMediaSet.a_, 3, true);
            } else if ("title".equals(i)) {
                if (jsonParser.g() != JsonToken.VALUE_NULL) {
                    graphQLTextWithEntities = GraphQLTextWithEntities__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "title"));
                }
                graphQLMediaSet.h = graphQLTextWithEntities;
                FieldAccessQueryTracker.a(jsonParser, graphQLMediaSet, "title", graphQLMediaSet.a_, 4, true);
            } else {
                int i2 = 0;
            }
            jsonParser.f();
        }
        return graphQLMediaSet;
    }

    public static void m9077a(JsonGenerator jsonGenerator, GraphQLMediaSet graphQLMediaSet, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        if (graphQLMediaSet.j() != null) {
            jsonGenerator.a("__type__");
            jsonGenerator.f();
            jsonGenerator.a("name", graphQLMediaSet.j().e());
            jsonGenerator.g();
        }
        if (graphQLMediaSet.k() != null) {
            jsonGenerator.a("id", graphQLMediaSet.k());
        }
        if (graphQLMediaSet.l() != null) {
            jsonGenerator.a("media");
            GraphQLMediaSetMediaConnection__JsonHelper.m9074a(jsonGenerator, graphQLMediaSet.l(), true);
        }
        if (graphQLMediaSet.m() != null) {
            jsonGenerator.a("media_list");
            GraphQLMediaSetMediaConnection__JsonHelper.m9074a(jsonGenerator, graphQLMediaSet.m(), true);
        }
        if (graphQLMediaSet.n() != null) {
            jsonGenerator.a("title");
            GraphQLTextWithEntities__JsonHelper.a(jsonGenerator, graphQLMediaSet.n(), true);
        }
        if (z) {
            jsonGenerator.g();
        }
    }
}
