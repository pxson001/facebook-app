package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

/* compiled from: friends_list_bookmark */
public final class GraphQLGreetingCard__JsonHelper {
    public static GraphQLGreetingCard m8376a(JsonParser jsonParser) {
        GraphQLGreetingCard graphQLGreetingCard = new GraphQLGreetingCard();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            return null;
        }
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            m8378a(graphQLGreetingCard, i, jsonParser);
            jsonParser.f();
        }
        return graphQLGreetingCard;
    }

    private static boolean m8378a(GraphQLGreetingCard graphQLGreetingCard, String str, JsonParser jsonParser) {
        String str2 = null;
        if ("greeting_card_template".equals(str)) {
            GraphQLGreetingCardTemplate a;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a = GraphQLGreetingCardTemplate__JsonHelper.m8373a(FieldAccessQueryTracker.a(jsonParser, "greeting_card_template"));
            }
            graphQLGreetingCard.d = a;
            FieldAccessQueryTracker.a(jsonParser, graphQLGreetingCard, "greeting_card_template", graphQLGreetingCard.a_, 0, true);
            return true;
        } else if ("id".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                str2 = jsonParser.o();
            }
            graphQLGreetingCard.e = str2;
            FieldAccessQueryTracker.a(jsonParser, graphQLGreetingCard, "id", graphQLGreetingCard.B_(), 1, false);
            return true;
        } else if ("primary_image".equals(str)) {
            GraphQLImage a2;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a2 = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "primary_image"));
            }
            graphQLGreetingCard.f = a2;
            FieldAccessQueryTracker.a(jsonParser, graphQLGreetingCard, "primary_image", graphQLGreetingCard.B_(), 2, true);
            return true;
        } else if ("slides".equals(str)) {
            GraphQLGreetingCardSlidesConnection a3;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a3 = GraphQLGreetingCardSlidesConnection__JsonHelper.m8357a(FieldAccessQueryTracker.a(jsonParser, "slides"));
            }
            graphQLGreetingCard.g = a3;
            FieldAccessQueryTracker.a(jsonParser, graphQLGreetingCard, "slides", graphQLGreetingCard.B_(), 3, true);
            return true;
        } else if ("theme".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                str2 = jsonParser.o();
            }
            graphQLGreetingCard.h = str2;
            FieldAccessQueryTracker.a(jsonParser, graphQLGreetingCard, "theme", graphQLGreetingCard.B_(), 4, false);
            return true;
        } else if (!"url".equals(str)) {
            return false;
        } else {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                str2 = jsonParser.o();
            }
            graphQLGreetingCard.i = str2;
            FieldAccessQueryTracker.a(jsonParser, graphQLGreetingCard, "url", graphQLGreetingCard.B_(), 5, false);
            return true;
        }
    }

    public static void m8377a(JsonGenerator jsonGenerator, GraphQLGreetingCard graphQLGreetingCard, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        if (graphQLGreetingCard.j() != null) {
            jsonGenerator.a("greeting_card_template");
            GraphQLGreetingCardTemplate__JsonHelper.m8374a(jsonGenerator, graphQLGreetingCard.j(), true);
        }
        if (graphQLGreetingCard.k() != null) {
            jsonGenerator.a("id", graphQLGreetingCard.k());
        }
        if (graphQLGreetingCard.l() != null) {
            jsonGenerator.a("primary_image");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLGreetingCard.l(), true);
        }
        if (graphQLGreetingCard.m() != null) {
            jsonGenerator.a("slides");
            GraphQLGreetingCardSlidesConnection__JsonHelper.m8358a(jsonGenerator, graphQLGreetingCard.m(), true);
        }
        if (graphQLGreetingCard.n() != null) {
            jsonGenerator.a("theme", graphQLGreetingCard.n());
        }
        if (graphQLGreetingCard.o() != null) {
            jsonGenerator.a("url", graphQLGreetingCard.o());
        }
        if (z) {
            jsonGenerator.g();
        }
    }
}
