package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

/* compiled from: googleSignInAccount */
public final class GraphQLGoodwillThrowbackDataPoint__JsonHelper {
    public static GraphQLGoodwillThrowbackDataPoint m7934a(JsonParser jsonParser) {
        GraphQLGoodwillThrowbackDataPoint graphQLGoodwillThrowbackDataPoint = new GraphQLGoodwillThrowbackDataPoint();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            return null;
        }
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            GraphQLTextWithEntities graphQLTextWithEntities = null;
            if ("icon".equals(i)) {
                GraphQLImage a;
                if (jsonParser.g() != JsonToken.VALUE_NULL) {
                    a = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "icon"));
                }
                graphQLGoodwillThrowbackDataPoint.f3938d = a;
                FieldAccessQueryTracker.a(jsonParser, graphQLGoodwillThrowbackDataPoint, "icon", graphQLGoodwillThrowbackDataPoint.a_, 0, true);
            } else if ("text".equals(i)) {
                if (jsonParser.g() != JsonToken.VALUE_NULL) {
                    graphQLTextWithEntities = GraphQLTextWithEntities__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "text"));
                }
                graphQLGoodwillThrowbackDataPoint.f3939e = graphQLTextWithEntities;
                FieldAccessQueryTracker.a(jsonParser, graphQLGoodwillThrowbackDataPoint, "text", graphQLGoodwillThrowbackDataPoint.a_, 1, true);
            } else {
                int i2 = 0;
            }
            jsonParser.f();
        }
        return graphQLGoodwillThrowbackDataPoint;
    }

    public static void m7935a(JsonGenerator jsonGenerator, GraphQLGoodwillThrowbackDataPoint graphQLGoodwillThrowbackDataPoint, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        if (graphQLGoodwillThrowbackDataPoint.m7929a() != null) {
            jsonGenerator.a("icon");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLGoodwillThrowbackDataPoint.m7929a(), true);
        }
        if (graphQLGoodwillThrowbackDataPoint.m7931j() != null) {
            jsonGenerator.a("text");
            GraphQLTextWithEntities__JsonHelper.a(jsonGenerator, graphQLGoodwillThrowbackDataPoint.m7931j(), true);
        }
        if (z) {
            jsonGenerator.g();
        }
    }
}
