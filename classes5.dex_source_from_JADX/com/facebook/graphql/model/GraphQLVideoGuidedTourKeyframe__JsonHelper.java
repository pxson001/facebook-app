package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

/* compiled from: There was not a running job when onExit was called */
public final class GraphQLVideoGuidedTourKeyframe__JsonHelper {
    public static GraphQLVideoGuidedTourKeyframe m22462a(JsonParser jsonParser) {
        GraphQLVideoGuidedTourKeyframe graphQLVideoGuidedTourKeyframe = new GraphQLVideoGuidedTourKeyframe();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            return null;
        }
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            int i2;
            if ("pitch".equals(i)) {
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    i2 = 0;
                } else {
                    i2 = jsonParser.E();
                }
                graphQLVideoGuidedTourKeyframe.f13451d = i2;
                FieldAccessQueryTracker.a(jsonParser, graphQLVideoGuidedTourKeyframe, "pitch", graphQLVideoGuidedTourKeyframe.a_, 0, false);
            } else if ("timestamp".equals(i)) {
                long j;
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    j = 0;
                } else {
                    j = jsonParser.F();
                }
                graphQLVideoGuidedTourKeyframe.f13452e = j;
                FieldAccessQueryTracker.a(jsonParser, graphQLVideoGuidedTourKeyframe, "timestamp", graphQLVideoGuidedTourKeyframe.a_, 1, false);
            } else if ("yaw".equals(i)) {
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    i2 = 0;
                } else {
                    i2 = jsonParser.E();
                }
                graphQLVideoGuidedTourKeyframe.f13453f = i2;
                FieldAccessQueryTracker.a(jsonParser, graphQLVideoGuidedTourKeyframe, "yaw", graphQLVideoGuidedTourKeyframe.a_, 2, false);
            }
            jsonParser.f();
        }
        return graphQLVideoGuidedTourKeyframe;
    }

    public static void m22463a(JsonGenerator jsonGenerator, GraphQLVideoGuidedTourKeyframe graphQLVideoGuidedTourKeyframe, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        jsonGenerator.a("pitch", graphQLVideoGuidedTourKeyframe.m22454a());
        jsonGenerator.a("timestamp", graphQLVideoGuidedTourKeyframe.m22458j());
        jsonGenerator.a("yaw", graphQLVideoGuidedTourKeyframe.m22459k());
        if (z) {
            jsonGenerator.g();
        }
    }
}
