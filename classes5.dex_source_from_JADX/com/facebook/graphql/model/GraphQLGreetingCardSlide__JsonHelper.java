package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.facebook.graphql.enums.GraphQLGreetingCardSlideType;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

/* compiled from: friendshake */
public final class GraphQLGreetingCardSlide__JsonHelper {
    public static GraphQLGreetingCardSlide m8350a(JsonParser jsonParser) {
        GraphQLGreetingCardSlide graphQLGreetingCardSlide = new GraphQLGreetingCardSlide();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            return null;
        }
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            m8352a(graphQLGreetingCardSlide, i, jsonParser);
            jsonParser.f();
        }
        return graphQLGreetingCardSlide;
    }

    private static boolean m8352a(GraphQLGreetingCardSlide graphQLGreetingCardSlide, String str, JsonParser jsonParser) {
        GraphQLTextWithEntities graphQLTextWithEntities = null;
        if ("message".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                graphQLTextWithEntities = GraphQLTextWithEntities__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "message"));
            }
            graphQLGreetingCardSlide.f4132d = graphQLTextWithEntities;
            FieldAccessQueryTracker.a(jsonParser, graphQLGreetingCardSlide, "message", graphQLGreetingCardSlide.a_, 0, true);
            return true;
        } else if ("photos".equals(str)) {
            GraphQLGreetingCardSlidePhotosConnection a;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a = GraphQLGreetingCardSlidePhotosConnection__JsonHelper.m8347a(FieldAccessQueryTracker.a(jsonParser, "photos"));
            }
            graphQLGreetingCardSlide.f4133e = a;
            FieldAccessQueryTracker.a(jsonParser, graphQLGreetingCardSlide, "photos", graphQLGreetingCardSlide.B_(), 1, true);
            return true;
        } else if ("slide_type".equals(str)) {
            graphQLGreetingCardSlide.f4134f = GraphQLGreetingCardSlideType.fromString(jsonParser.o());
            FieldAccessQueryTracker.a(jsonParser, graphQLGreetingCardSlide, "slide_type", graphQLGreetingCardSlide.B_(), 2, false);
            return true;
        } else if (!"title".equals(str)) {
            return false;
        } else {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                graphQLTextWithEntities = GraphQLTextWithEntities__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "title"));
            }
            graphQLGreetingCardSlide.f4135g = graphQLTextWithEntities;
            FieldAccessQueryTracker.a(jsonParser, graphQLGreetingCardSlide, "title", graphQLGreetingCardSlide.B_(), 3, true);
            return true;
        }
    }

    public static void m8351a(JsonGenerator jsonGenerator, GraphQLGreetingCardSlide graphQLGreetingCardSlide, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        if (graphQLGreetingCardSlide.m8334a() != null) {
            jsonGenerator.a("message");
            GraphQLTextWithEntities__JsonHelper.a(jsonGenerator, graphQLGreetingCardSlide.m8334a(), true);
        }
        if (graphQLGreetingCardSlide.m8336j() != null) {
            jsonGenerator.a("photos");
            GraphQLGreetingCardSlidePhotosConnection__JsonHelper.m8348a(jsonGenerator, graphQLGreetingCardSlide.m8336j(), true);
        }
        if (graphQLGreetingCardSlide.m8337k() != null) {
            jsonGenerator.a("slide_type", graphQLGreetingCardSlide.m8337k().toString());
        }
        if (graphQLGreetingCardSlide.m8338l() != null) {
            jsonGenerator.a("title");
            GraphQLTextWithEntities__JsonHelper.a(jsonGenerator, graphQLGreetingCardSlide.m8338l(), true);
        }
        if (z) {
            jsonGenerator.g();
        }
    }
}
