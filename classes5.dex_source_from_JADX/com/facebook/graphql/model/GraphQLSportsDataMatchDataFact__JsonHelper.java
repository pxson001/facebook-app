package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

/* compiled from: Unknown what= */
public final class GraphQLSportsDataMatchDataFact__JsonHelper {
    public static GraphQLSportsDataMatchDataFact m21782a(JsonParser jsonParser) {
        GraphQLSportsDataMatchDataFact graphQLSportsDataMatchDataFact = new GraphQLSportsDataMatchDataFact();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            return null;
        }
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            m21784a(graphQLSportsDataMatchDataFact, i, jsonParser);
            jsonParser.f();
        }
        return graphQLSportsDataMatchDataFact;
    }

    private static boolean m21784a(GraphQLSportsDataMatchDataFact graphQLSportsDataMatchDataFact, String str, JsonParser jsonParser) {
        GraphQLComment graphQLComment = null;
        if ("acting_team".equals(str)) {
            GraphQLPage a;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a = GraphQLPage__JsonHelper.m9553a(FieldAccessQueryTracker.a(jsonParser, "acting_team"));
            }
            graphQLSportsDataMatchDataFact.f13058d = a;
            FieldAccessQueryTracker.a(jsonParser, graphQLSportsDataMatchDataFact, "acting_team", graphQLSportsDataMatchDataFact.a_, 0, true);
            return true;
        } else if ("acting_team_short_name".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                r0 = jsonParser.o();
            }
            graphQLSportsDataMatchDataFact.f13059e = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLSportsDataMatchDataFact, "acting_team_short_name", graphQLSportsDataMatchDataFact.B_(), 1, false);
            return true;
        } else if ("fact_clock".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                r0 = jsonParser.o();
            }
            graphQLSportsDataMatchDataFact.f13060f = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLSportsDataMatchDataFact, "fact_clock", graphQLSportsDataMatchDataFact.B_(), 2, false);
            return true;
        } else if ("fact_message".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                r0 = jsonParser.o();
            }
            graphQLSportsDataMatchDataFact.f13061g = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLSportsDataMatchDataFact, "fact_message", graphQLSportsDataMatchDataFact.B_(), 3, false);
            return true;
        } else if ("fact_time".equals(str)) {
            graphQLSportsDataMatchDataFact.f13062h = jsonParser.g() == JsonToken.VALUE_NULL ? 0 : jsonParser.F();
            FieldAccessQueryTracker.a(jsonParser, graphQLSportsDataMatchDataFact, "fact_time", graphQLSportsDataMatchDataFact.B_(), 4, false);
            return true;
        } else if ("feedback".equals(str)) {
            GraphQLFeedback a2;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a2 = GraphQLFeedback__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "feedback"));
            }
            graphQLSportsDataMatchDataFact.f13063i = a2;
            FieldAccessQueryTracker.a(jsonParser, graphQLSportsDataMatchDataFact, "feedback", graphQLSportsDataMatchDataFact.B_(), 5, true);
            return true;
        } else if ("header_text".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                r0 = jsonParser.o();
            }
            graphQLSportsDataMatchDataFact.f13064j = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLSportsDataMatchDataFact, "header_text", graphQLSportsDataMatchDataFact.B_(), 6, false);
            return true;
        } else if ("id".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                r0 = jsonParser.o();
            }
            graphQLSportsDataMatchDataFact.f13065k = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLSportsDataMatchDataFact, "id", graphQLSportsDataMatchDataFact.B_(), 7, false);
            return true;
        } else if ("score_text".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                r0 = jsonParser.o();
            }
            graphQLSportsDataMatchDataFact.f13066l = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLSportsDataMatchDataFact, "score_text", graphQLSportsDataMatchDataFact.B_(), 8, false);
            return true;
        } else if ("sequence_number".equals(str)) {
            graphQLSportsDataMatchDataFact.f13067m = jsonParser.g() == JsonToken.VALUE_NULL ? 0 : jsonParser.E();
            FieldAccessQueryTracker.a(jsonParser, graphQLSportsDataMatchDataFact, "sequence_number", graphQLSportsDataMatchDataFact.B_(), 9, false);
            return true;
        } else if ("story".equals(str)) {
            GraphQLStory a3;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a3 = GraphQLStory__JsonHelper.m21922a(FieldAccessQueryTracker.a(jsonParser, "story"));
            }
            graphQLSportsDataMatchDataFact.f13068n = a3;
            FieldAccessQueryTracker.a(jsonParser, graphQLSportsDataMatchDataFact, "story", graphQLSportsDataMatchDataFact.B_(), 10, true);
            return true;
        } else if ("url".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                r0 = jsonParser.o();
            }
            graphQLSportsDataMatchDataFact.f13069o = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLSportsDataMatchDataFact, "url", graphQLSportsDataMatchDataFact.B_(), 11, false);
            return true;
        } else if (!"preview_comment".equals(str)) {
            return false;
        } else {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                graphQLComment = GraphQLComment__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "preview_comment"));
            }
            graphQLSportsDataMatchDataFact.f13070p = graphQLComment;
            FieldAccessQueryTracker.a(jsonParser, graphQLSportsDataMatchDataFact, "preview_comment", graphQLSportsDataMatchDataFact.B_(), 12, true);
            return true;
        }
    }

    public static void m21783a(JsonGenerator jsonGenerator, GraphQLSportsDataMatchDataFact graphQLSportsDataMatchDataFact, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        if (graphQLSportsDataMatchDataFact.m21767j() != null) {
            jsonGenerator.a("acting_team");
            GraphQLPage__JsonHelper.m9554a(jsonGenerator, graphQLSportsDataMatchDataFact.m21767j(), true);
        }
        if (graphQLSportsDataMatchDataFact.m21768k() != null) {
            jsonGenerator.a("acting_team_short_name", graphQLSportsDataMatchDataFact.m21768k());
        }
        if (graphQLSportsDataMatchDataFact.m21769l() != null) {
            jsonGenerator.a("fact_clock", graphQLSportsDataMatchDataFact.m21769l());
        }
        if (graphQLSportsDataMatchDataFact.m21770m() != null) {
            jsonGenerator.a("fact_message", graphQLSportsDataMatchDataFact.m21770m());
        }
        jsonGenerator.a("fact_time", graphQLSportsDataMatchDataFact.m21771n());
        if (graphQLSportsDataMatchDataFact.m21772o() != null) {
            jsonGenerator.a("feedback");
            GraphQLFeedback__JsonHelper.a(jsonGenerator, graphQLSportsDataMatchDataFact.m21772o(), true);
        }
        if (graphQLSportsDataMatchDataFact.m21773p() != null) {
            jsonGenerator.a("header_text", graphQLSportsDataMatchDataFact.m21773p());
        }
        if (graphQLSportsDataMatchDataFact.m21774q() != null) {
            jsonGenerator.a("id", graphQLSportsDataMatchDataFact.m21774q());
        }
        if (graphQLSportsDataMatchDataFact.m21775r() != null) {
            jsonGenerator.a("score_text", graphQLSportsDataMatchDataFact.m21775r());
        }
        jsonGenerator.a("sequence_number", graphQLSportsDataMatchDataFact.m21776s());
        if (graphQLSportsDataMatchDataFact.m21777t() != null) {
            jsonGenerator.a("story");
            GraphQLStory__JsonHelper.m21923a(jsonGenerator, graphQLSportsDataMatchDataFact.m21777t(), true);
        }
        if (graphQLSportsDataMatchDataFact.m21778u() != null) {
            jsonGenerator.a("url", graphQLSportsDataMatchDataFact.m21778u());
        }
        if (graphQLSportsDataMatchDataFact.m21779v() != null) {
            jsonGenerator.a("preview_comment");
            GraphQLComment__JsonHelper.a(jsonGenerator, graphQLSportsDataMatchDataFact.m21779v(), true);
        }
        if (z) {
            jsonGenerator.g();
        }
    }
}
