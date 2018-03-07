package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

/* compiled from: getPhoneOnTime */
public final class GraphQLGoodwillThrowbackSection__JsonHelper {
    public static GraphQLGoodwillThrowbackSection m8116a(JsonParser jsonParser) {
        GraphQLGoodwillThrowbackSection graphQLGoodwillThrowbackSection = new GraphQLGoodwillThrowbackSection();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            return null;
        }
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            m8118a(graphQLGoodwillThrowbackSection, i, jsonParser);
            jsonParser.f();
        }
        return graphQLGoodwillThrowbackSection;
    }

    private static boolean m8118a(GraphQLGoodwillThrowbackSection graphQLGoodwillThrowbackSection, String str, JsonParser jsonParser) {
        GraphQLTextWithEntities graphQLTextWithEntities = null;
        if ("accent_image".equals(str)) {
            GraphQLImage a;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "accent_image"));
            }
            graphQLGoodwillThrowbackSection.f4034d = a;
            FieldAccessQueryTracker.a(jsonParser, graphQLGoodwillThrowbackSection, "accent_image", graphQLGoodwillThrowbackSection.a_, 0, true);
            return true;
        } else if ("key".equals(str)) {
            String o;
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                o = jsonParser.o();
            }
            graphQLGoodwillThrowbackSection.f4035e = o;
            FieldAccessQueryTracker.a(jsonParser, graphQLGoodwillThrowbackSection, "key", graphQLGoodwillThrowbackSection.B_(), 1, false);
            return true;
        } else if ("subtitle".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                graphQLTextWithEntities = GraphQLTextWithEntities__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "subtitle"));
            }
            graphQLGoodwillThrowbackSection.f4036f = graphQLTextWithEntities;
            FieldAccessQueryTracker.a(jsonParser, graphQLGoodwillThrowbackSection, "subtitle", graphQLGoodwillThrowbackSection.B_(), 2, true);
            return true;
        } else if (!"title".equals(str)) {
            return false;
        } else {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                graphQLTextWithEntities = GraphQLTextWithEntities__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "title"));
            }
            graphQLGoodwillThrowbackSection.f4037g = graphQLTextWithEntities;
            FieldAccessQueryTracker.a(jsonParser, graphQLGoodwillThrowbackSection, "title", graphQLGoodwillThrowbackSection.B_(), 3, true);
            return true;
        }
    }

    public static void m8117a(JsonGenerator jsonGenerator, GraphQLGoodwillThrowbackSection graphQLGoodwillThrowbackSection, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        if (graphQLGoodwillThrowbackSection.m8110j() != null) {
            jsonGenerator.a("accent_image");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLGoodwillThrowbackSection.m8110j(), true);
        }
        if (graphQLGoodwillThrowbackSection.m8111k() != null) {
            jsonGenerator.a("key", graphQLGoodwillThrowbackSection.m8111k());
        }
        if (graphQLGoodwillThrowbackSection.m8112l() != null) {
            jsonGenerator.a("subtitle");
            GraphQLTextWithEntities__JsonHelper.a(jsonGenerator, graphQLGoodwillThrowbackSection.m8112l(), true);
        }
        if (graphQLGoodwillThrowbackSection.m8113m() != null) {
            jsonGenerator.a("title");
            GraphQLTextWithEntities__JsonHelper.a(jsonGenerator, graphQLGoodwillThrowbackSection.m8113m(), true);
        }
        if (z) {
            jsonGenerator.g();
        }
    }
}
