package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

/* compiled from: sa_type */
public final class GraphQLFeedbackReactionInfo__JsonHelper {
    public static GraphQLFeedbackReactionInfo m3261a(JsonParser jsonParser) {
        GraphQLFeedbackReactionInfo graphQLFeedbackReactionInfo = new GraphQLFeedbackReactionInfo();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            return null;
        }
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            String o;
            if ("color".equals(i)) {
                o = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                graphQLFeedbackReactionInfo.d = o;
                FieldAccessQueryTracker.m2236a(jsonParser, graphQLFeedbackReactionInfo, "color", graphQLFeedbackReactionInfo.a_, 0, false);
            } else if ("id".equals(i)) {
                o = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                graphQLFeedbackReactionInfo.e = o;
                FieldAccessQueryTracker.m2236a(jsonParser, graphQLFeedbackReactionInfo, "id", graphQLFeedbackReactionInfo.a_, 1, false);
            } else if ("is_deprecated".equals(i)) {
                boolean z;
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    z = false;
                } else {
                    z = jsonParser.H();
                }
                graphQLFeedbackReactionInfo.f = z;
                FieldAccessQueryTracker.m2236a(jsonParser, graphQLFeedbackReactionInfo, "is_deprecated", graphQLFeedbackReactionInfo.a_, 2, false);
            } else if ("key".equals(i)) {
                int i2;
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    i2 = 0;
                } else {
                    i2 = jsonParser.E();
                }
                graphQLFeedbackReactionInfo.g = i2;
                FieldAccessQueryTracker.m2236a(jsonParser, graphQLFeedbackReactionInfo, "key", graphQLFeedbackReactionInfo.a_, 3, false);
            } else if ("largeFaceImage".equals(i)) {
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    r3 = null;
                } else {
                    r3 = GraphQLImage__JsonHelper.m2260a(FieldAccessQueryTracker.m2235a(jsonParser, "largeFaceImage"));
                }
                graphQLFeedbackReactionInfo.h = r3;
                FieldAccessQueryTracker.m2236a(jsonParser, graphQLFeedbackReactionInfo, "largeFaceImage", graphQLFeedbackReactionInfo.a_, 4, true);
            } else if ("localized_name".equals(i)) {
                o = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                graphQLFeedbackReactionInfo.i = o;
                FieldAccessQueryTracker.m2236a(jsonParser, graphQLFeedbackReactionInfo, "localized_name", graphQLFeedbackReactionInfo.a_, 5, false);
            } else if ("smallFaceImage".equals(i)) {
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    r3 = null;
                } else {
                    r3 = GraphQLImage__JsonHelper.m2260a(FieldAccessQueryTracker.m2235a(jsonParser, "smallFaceImage"));
                }
                graphQLFeedbackReactionInfo.j = r3;
                FieldAccessQueryTracker.m2236a(jsonParser, graphQLFeedbackReactionInfo, "smallFaceImage", graphQLFeedbackReactionInfo.a_, 6, true);
            } else if ("tabIconImage".equals(i)) {
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    r3 = null;
                } else {
                    r3 = GraphQLImage__JsonHelper.m2260a(FieldAccessQueryTracker.m2235a(jsonParser, "tabIconImage"));
                }
                graphQLFeedbackReactionInfo.k = r3;
                FieldAccessQueryTracker.m2236a(jsonParser, graphQLFeedbackReactionInfo, "tabIconImage", graphQLFeedbackReactionInfo.a_, 7, true);
            } else if ("url".equals(i)) {
                o = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                graphQLFeedbackReactionInfo.l = o;
                FieldAccessQueryTracker.m2236a(jsonParser, graphQLFeedbackReactionInfo, "url", graphQLFeedbackReactionInfo.a_, 8, false);
            }
            jsonParser.f();
        }
        return graphQLFeedbackReactionInfo;
    }

    public static void m3262a(JsonGenerator jsonGenerator, GraphQLFeedbackReactionInfo graphQLFeedbackReactionInfo, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        if (graphQLFeedbackReactionInfo.j() != null) {
            jsonGenerator.a("color", graphQLFeedbackReactionInfo.j());
        }
        if (graphQLFeedbackReactionInfo.k() != null) {
            jsonGenerator.a("id", graphQLFeedbackReactionInfo.k());
        }
        jsonGenerator.a("is_deprecated", graphQLFeedbackReactionInfo.l());
        jsonGenerator.a("key", graphQLFeedbackReactionInfo.m());
        if (graphQLFeedbackReactionInfo.n() != null) {
            jsonGenerator.a("largeFaceImage");
            GraphQLImage__JsonHelper.m2261a(jsonGenerator, graphQLFeedbackReactionInfo.n(), true);
        }
        if (graphQLFeedbackReactionInfo.o() != null) {
            jsonGenerator.a("localized_name", graphQLFeedbackReactionInfo.o());
        }
        if (graphQLFeedbackReactionInfo.p() != null) {
            jsonGenerator.a("smallFaceImage");
            GraphQLImage__JsonHelper.m2261a(jsonGenerator, graphQLFeedbackReactionInfo.p(), true);
        }
        if (graphQLFeedbackReactionInfo.q() != null) {
            jsonGenerator.a("tabIconImage");
            GraphQLImage__JsonHelper.m2261a(jsonGenerator, graphQLFeedbackReactionInfo.q(), true);
        }
        if (graphQLFeedbackReactionInfo.r() != null) {
            jsonGenerator.a("url", graphQLFeedbackReactionInfo.r());
        }
        if (z) {
            jsonGenerator.g();
        }
    }
}
