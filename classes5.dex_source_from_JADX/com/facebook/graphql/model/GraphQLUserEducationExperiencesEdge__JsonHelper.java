package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

/* compiled from: Too many views in view hierarchy */
public final class GraphQLUserEducationExperiencesEdge__JsonHelper {
    public static GraphQLUserEducationExperiencesEdge m22398a(JsonParser jsonParser) {
        GraphQLUserEducationExperiencesEdge graphQLUserEducationExperiencesEdge = new GraphQLUserEducationExperiencesEdge();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            return null;
        }
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            if ("node".equals(i)) {
                GraphQLEducationExperience graphQLEducationExperience;
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    graphQLEducationExperience = null;
                } else {
                    graphQLEducationExperience = GraphQLEducationExperience__JsonHelper.m6983a(FieldAccessQueryTracker.a(jsonParser, "node"));
                }
                graphQLUserEducationExperiencesEdge.f13442d = graphQLEducationExperience;
                FieldAccessQueryTracker.a(jsonParser, graphQLUserEducationExperiencesEdge, "node", graphQLUserEducationExperiencesEdge.a_, 0, true);
            } else {
                int i2 = 0;
            }
            jsonParser.f();
        }
        return graphQLUserEducationExperiencesEdge;
    }

    public static void m22399a(JsonGenerator jsonGenerator, GraphQLUserEducationExperiencesEdge graphQLUserEducationExperiencesEdge, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        if (graphQLUserEducationExperiencesEdge.m22394a() != null) {
            jsonGenerator.a("node");
            GraphQLEducationExperience__JsonHelper.m6984a(jsonGenerator, graphQLUserEducationExperiencesEdge.m22394a(), true);
        }
        if (z) {
            jsonGenerator.g();
        }
    }
}
