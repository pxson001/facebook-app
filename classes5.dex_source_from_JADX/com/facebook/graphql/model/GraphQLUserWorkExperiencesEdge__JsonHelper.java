package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

/* compiled from: TimelineSection */
public final class GraphQLUserWorkExperiencesEdge__JsonHelper {
    public static GraphQLUserWorkExperiencesEdge m22414a(JsonParser jsonParser) {
        GraphQLUserWorkExperiencesEdge graphQLUserWorkExperiencesEdge = new GraphQLUserWorkExperiencesEdge();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            return null;
        }
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            if ("node".equals(i)) {
                GraphQLWorkExperience graphQLWorkExperience;
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    graphQLWorkExperience = null;
                } else {
                    graphQLWorkExperience = GraphQLWorkExperience__JsonHelper.m22533a(FieldAccessQueryTracker.a(jsonParser, "node"));
                }
                graphQLUserWorkExperiencesEdge.f13443d = graphQLWorkExperience;
                FieldAccessQueryTracker.a(jsonParser, graphQLUserWorkExperiencesEdge, "node", graphQLUserWorkExperiencesEdge.a_, 0, true);
            } else {
                int i2 = 0;
            }
            jsonParser.f();
        }
        return graphQLUserWorkExperiencesEdge;
    }

    public static void m22415a(JsonGenerator jsonGenerator, GraphQLUserWorkExperiencesEdge graphQLUserWorkExperiencesEdge, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        if (graphQLUserWorkExperiencesEdge.m22410a() != null) {
            jsonGenerator.a("node");
            GraphQLWorkExperience__JsonHelper.m22534a(jsonGenerator, graphQLUserWorkExperiencesEdge.m22410a(), true);
        }
        if (z) {
            jsonGenerator.g();
        }
    }
}
