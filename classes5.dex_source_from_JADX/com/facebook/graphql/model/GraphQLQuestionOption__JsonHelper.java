package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

/* compiled from: VIEW_PROFILE_LIST_WITH_CATEGORIES */
public final class GraphQLQuestionOption__JsonHelper {
    public static GraphQLQuestionOption m21182a(JsonParser jsonParser) {
        GraphQLQuestionOption graphQLQuestionOption = new GraphQLQuestionOption();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            return null;
        }
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            m21184a(graphQLQuestionOption, i, jsonParser);
            jsonParser.f();
        }
        return graphQLQuestionOption;
    }

    private static boolean m21184a(GraphQLQuestionOption graphQLQuestionOption, String str, JsonParser jsonParser) {
        GraphQLQuestionOptionVotersConnection graphQLQuestionOptionVotersConnection = null;
        String o;
        if ("id".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                o = jsonParser.o();
            }
            graphQLQuestionOption.f12831d = o;
            FieldAccessQueryTracker.a(jsonParser, graphQLQuestionOption, "id", graphQLQuestionOption.a_, 0, false);
            return true;
        } else if ("text_with_entities".equals(str)) {
            GraphQLTextWithEntities a;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a = GraphQLTextWithEntities__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "text_with_entities"));
            }
            graphQLQuestionOption.f12832e = a;
            FieldAccessQueryTracker.a(jsonParser, graphQLQuestionOption, "text_with_entities", graphQLQuestionOption.B_(), 1, true);
            return true;
        } else if ("url".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                o = jsonParser.o();
            }
            graphQLQuestionOption.f12833f = o;
            FieldAccessQueryTracker.a(jsonParser, graphQLQuestionOption, "url", graphQLQuestionOption.B_(), 2, false);
            return true;
        } else if ("viewer_has_voted".equals(str)) {
            graphQLQuestionOption.f12834g = jsonParser.g() == JsonToken.VALUE_NULL ? false : jsonParser.H();
            FieldAccessQueryTracker.a(jsonParser, graphQLQuestionOption, "viewer_has_voted", graphQLQuestionOption.B_(), 3, false);
            return true;
        } else if (!"voters".equals(str)) {
            return false;
        } else {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                graphQLQuestionOptionVotersConnection = GraphQLQuestionOptionVotersConnection__JsonHelper.m21180a(FieldAccessQueryTracker.a(jsonParser, "voters"));
            }
            graphQLQuestionOption.f12835h = graphQLQuestionOptionVotersConnection;
            FieldAccessQueryTracker.a(jsonParser, graphQLQuestionOption, "voters", graphQLQuestionOption.B_(), 4, true);
            return true;
        }
    }

    public static void m21183a(JsonGenerator jsonGenerator, GraphQLQuestionOption graphQLQuestionOption, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        if (graphQLQuestionOption.m21160j() != null) {
            jsonGenerator.a("id", graphQLQuestionOption.m21160j());
        }
        if (graphQLQuestionOption.m21161k() != null) {
            jsonGenerator.a("text_with_entities");
            GraphQLTextWithEntities__JsonHelper.a(jsonGenerator, graphQLQuestionOption.m21161k(), true);
        }
        if (graphQLQuestionOption.m21162l() != null) {
            jsonGenerator.a("url", graphQLQuestionOption.m21162l());
        }
        jsonGenerator.a("viewer_has_voted", graphQLQuestionOption.m21163m());
        if (graphQLQuestionOption.m21164n() != null) {
            jsonGenerator.a("voters");
            GraphQLQuestionOptionVotersConnection__JsonHelper.m21181a(jsonGenerator, graphQLQuestionOption.m21164n(), true);
        }
        if (z) {
            jsonGenerator.g();
        }
    }
}
