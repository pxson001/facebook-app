package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

/* compiled from: Unknown type  */
public final class GraphQLSportsDataMatchData__JsonHelper {
    public static GraphQLSportsDataMatchData m21786a(JsonParser jsonParser) {
        GraphQLSportsDataMatchData graphQLSportsDataMatchData = new GraphQLSportsDataMatchData();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            return null;
        }
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            m21788a(graphQLSportsDataMatchData, i, jsonParser);
            jsonParser.f();
        }
        return graphQLSportsDataMatchData;
    }

    private static boolean m21788a(GraphQLSportsDataMatchData graphQLSportsDataMatchData, String str, JsonParser jsonParser) {
        long j = 0;
        GraphQLPage graphQLPage = null;
        if ("active_team_with_ball".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                graphQLPage = GraphQLPage__JsonHelper.m9553a(FieldAccessQueryTracker.a(jsonParser, "active_team_with_ball"));
            }
            graphQLSportsDataMatchData.d = graphQLPage;
            FieldAccessQueryTracker.a(jsonParser, graphQLSportsDataMatchData, "active_team_with_ball", graphQLSportsDataMatchData.a_, 0, true);
            return true;
        } else if ("away_team".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                graphQLPage = GraphQLPage__JsonHelper.m9553a(FieldAccessQueryTracker.a(jsonParser, "away_team"));
            }
            graphQLSportsDataMatchData.e = graphQLPage;
            FieldAccessQueryTracker.a(jsonParser, graphQLSportsDataMatchData, "away_team", graphQLSportsDataMatchData.B_(), 1, true);
            return true;
        } else if ("away_team_fan_count".equals(str)) {
            graphQLSportsDataMatchData.f = jsonParser.g() == JsonToken.VALUE_NULL ? 0 : jsonParser.E();
            FieldAccessQueryTracker.a(jsonParser, graphQLSportsDataMatchData, "away_team_fan_count", graphQLSportsDataMatchData.B_(), 2, false);
            return true;
        } else if ("away_team_market".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                r0 = jsonParser.o();
            }
            graphQLSportsDataMatchData.g = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLSportsDataMatchData, "away_team_market", graphQLSportsDataMatchData.B_(), 3, false);
            return true;
        } else if ("away_team_name".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                r0 = jsonParser.o();
            }
            graphQLSportsDataMatchData.h = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLSportsDataMatchData, "away_team_name", graphQLSportsDataMatchData.B_(), 4, false);
            return true;
        } else if ("away_team_primary_color".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                r0 = jsonParser.o();
            }
            graphQLSportsDataMatchData.i = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLSportsDataMatchData, "away_team_primary_color", graphQLSportsDataMatchData.B_(), 5, false);
            return true;
        } else if ("away_team_score".equals(str)) {
            graphQLSportsDataMatchData.j = jsonParser.g() == JsonToken.VALUE_NULL ? 0 : jsonParser.E();
            FieldAccessQueryTracker.a(jsonParser, graphQLSportsDataMatchData, "away_team_score", graphQLSportsDataMatchData.B_(), 6, false);
            return true;
        } else if ("broadcast_network".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                r0 = jsonParser.o();
            }
            graphQLSportsDataMatchData.k = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLSportsDataMatchData, "broadcast_network", graphQLSportsDataMatchData.B_(), 8, false);
            return true;
        } else if ("clock".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                r0 = jsonParser.o();
            }
            graphQLSportsDataMatchData.l = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLSportsDataMatchData, "clock", graphQLSportsDataMatchData.B_(), 9, false);
            return true;
        } else if ("facts".equals(str)) {
            GraphQLSportsDataMatchToFactsConnection a;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a = GraphQLSportsDataMatchToFactsConnection__JsonHelper.m21797a(FieldAccessQueryTracker.a(jsonParser, "facts"));
            }
            graphQLSportsDataMatchData.m = a;
            FieldAccessQueryTracker.a(jsonParser, graphQLSportsDataMatchData, "facts", graphQLSportsDataMatchData.B_(), 10, true);
            return true;
        } else if ("fan_favorite".equals(str)) {
            GraphQLSportsDataMatchToFanFavoriteConnection a2;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a2 = GraphQLSportsDataMatchToFanFavoriteConnection__JsonHelper.m21806a(FieldAccessQueryTracker.a(jsonParser, "fan_favorite"));
            }
            graphQLSportsDataMatchData.n = a2;
            FieldAccessQueryTracker.a(jsonParser, graphQLSportsDataMatchData, "fan_favorite", graphQLSportsDataMatchData.B_(), 11, true);
            return true;
        } else if ("home_team".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                graphQLPage = GraphQLPage__JsonHelper.m9553a(FieldAccessQueryTracker.a(jsonParser, "home_team"));
            }
            graphQLSportsDataMatchData.o = graphQLPage;
            FieldAccessQueryTracker.a(jsonParser, graphQLSportsDataMatchData, "home_team", graphQLSportsDataMatchData.B_(), 12, true);
            return true;
        } else if ("home_team_fan_count".equals(str)) {
            graphQLSportsDataMatchData.p = jsonParser.g() == JsonToken.VALUE_NULL ? 0 : jsonParser.E();
            FieldAccessQueryTracker.a(jsonParser, graphQLSportsDataMatchData, "home_team_fan_count", graphQLSportsDataMatchData.B_(), 13, false);
            return true;
        } else if ("home_team_market".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                r0 = jsonParser.o();
            }
            graphQLSportsDataMatchData.q = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLSportsDataMatchData, "home_team_market", graphQLSportsDataMatchData.B_(), 14, false);
            return true;
        } else if ("home_team_name".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                r0 = jsonParser.o();
            }
            graphQLSportsDataMatchData.r = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLSportsDataMatchData, "home_team_name", graphQLSportsDataMatchData.B_(), 15, false);
            return true;
        } else if ("home_team_primary_color".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                r0 = jsonParser.o();
            }
            graphQLSportsDataMatchData.s = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLSportsDataMatchData, "home_team_primary_color", graphQLSportsDataMatchData.B_(), 16, false);
            return true;
        } else if ("home_team_score".equals(str)) {
            graphQLSportsDataMatchData.t = jsonParser.g() == JsonToken.VALUE_NULL ? 0 : jsonParser.E();
            FieldAccessQueryTracker.a(jsonParser, graphQLSportsDataMatchData, "home_team_score", graphQLSportsDataMatchData.B_(), 17, false);
            return true;
        } else if ("id".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                r0 = jsonParser.o();
            }
            graphQLSportsDataMatchData.u = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLSportsDataMatchData, "id", graphQLSportsDataMatchData.B_(), 19, false);
            return true;
        } else if ("period".equals(str)) {
            graphQLSportsDataMatchData.v = jsonParser.g() == JsonToken.VALUE_NULL ? 0 : jsonParser.E();
            FieldAccessQueryTracker.a(jsonParser, graphQLSportsDataMatchData, "period", graphQLSportsDataMatchData.B_(), 20, false);
            return true;
        } else if ("scheduled_start_time".equals(str)) {
            graphQLSportsDataMatchData.w = jsonParser.g() == JsonToken.VALUE_NULL ? 0 : jsonParser.F();
            FieldAccessQueryTracker.a(jsonParser, graphQLSportsDataMatchData, "scheduled_start_time", graphQLSportsDataMatchData.B_(), 21, false);
            return true;
        } else if ("sports_data_cover_photo".equals(str)) {
            GraphQLPhoto a3;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a3 = GraphQLPhoto__JsonHelper.m20764a(FieldAccessQueryTracker.a(jsonParser, "sports_data_cover_photo"));
            }
            graphQLSportsDataMatchData.x = a3;
            FieldAccessQueryTracker.a(jsonParser, graphQLSportsDataMatchData, "sports_data_cover_photo", graphQLSportsDataMatchData.B_(), 22, true);
            return true;
        } else if ("sports_data_fallback_photo".equals(str)) {
            GraphQLImage a4;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a4 = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "sports_data_fallback_photo"));
            }
            graphQLSportsDataMatchData.y = a4;
            FieldAccessQueryTracker.a(jsonParser, graphQLSportsDataMatchData, "sports_data_fallback_photo", graphQLSportsDataMatchData.B_(), 23, true);
            return true;
        } else if ("sports_subtitle".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                r0 = jsonParser.o();
            }
            graphQLSportsDataMatchData.z = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLSportsDataMatchData, "sports_subtitle", graphQLSportsDataMatchData.B_(), 24, false);
            return true;
        } else if ("status".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                r0 = jsonParser.o();
            }
            graphQLSportsDataMatchData.A = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLSportsDataMatchData, "status", graphQLSportsDataMatchData.B_(), 25, false);
            return true;
        } else if ("status_text".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                r0 = jsonParser.o();
            }
            graphQLSportsDataMatchData.B = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLSportsDataMatchData, "status_text", graphQLSportsDataMatchData.B_(), 26, false);
            return true;
        } else if ("updated_time".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                j = jsonParser.F();
            }
            graphQLSportsDataMatchData.C = j;
            FieldAccessQueryTracker.a(jsonParser, graphQLSportsDataMatchData, "updated_time", graphQLSportsDataMatchData.B_(), 27, false);
            return true;
        } else if ("url".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                r0 = jsonParser.o();
            }
            graphQLSportsDataMatchData.D = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLSportsDataMatchData, "url", graphQLSportsDataMatchData.B_(), 28, false);
            return true;
        } else if ("viewer_can_vote_fan_favorite".equals(str)) {
            graphQLSportsDataMatchData.E = jsonParser.g() == JsonToken.VALUE_NULL ? false : jsonParser.H();
            FieldAccessQueryTracker.a(jsonParser, graphQLSportsDataMatchData, "viewer_can_vote_fan_favorite", graphQLSportsDataMatchData.B_(), 29, false);
            return true;
        } else if ("match_page".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                graphQLPage = GraphQLPage__JsonHelper.m9553a(FieldAccessQueryTracker.a(jsonParser, "match_page"));
            }
            graphQLSportsDataMatchData.F = graphQLPage;
            FieldAccessQueryTracker.a(jsonParser, graphQLSportsDataMatchData, "match_page", graphQLSportsDataMatchData.B_(), 32, true);
            return true;
        } else if (!"has_match_started".equals(str)) {
            return false;
        } else {
            graphQLSportsDataMatchData.G = jsonParser.g() == JsonToken.VALUE_NULL ? false : jsonParser.H();
            FieldAccessQueryTracker.a(jsonParser, graphQLSportsDataMatchData, "has_match_started", graphQLSportsDataMatchData.B_(), 33, false);
            return true;
        }
    }

    public static void m21787a(JsonGenerator jsonGenerator, GraphQLSportsDataMatchData graphQLSportsDataMatchData, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        if (graphQLSportsDataMatchData.j() != null) {
            jsonGenerator.a("active_team_with_ball");
            GraphQLPage__JsonHelper.m9554a(jsonGenerator, graphQLSportsDataMatchData.j(), true);
        }
        if (graphQLSportsDataMatchData.k() != null) {
            jsonGenerator.a("away_team");
            GraphQLPage__JsonHelper.m9554a(jsonGenerator, graphQLSportsDataMatchData.k(), true);
        }
        jsonGenerator.a("away_team_fan_count", graphQLSportsDataMatchData.l());
        if (graphQLSportsDataMatchData.m() != null) {
            jsonGenerator.a("away_team_market", graphQLSportsDataMatchData.m());
        }
        if (graphQLSportsDataMatchData.n() != null) {
            jsonGenerator.a("away_team_name", graphQLSportsDataMatchData.n());
        }
        if (graphQLSportsDataMatchData.o() != null) {
            jsonGenerator.a("away_team_primary_color", graphQLSportsDataMatchData.o());
        }
        jsonGenerator.a("away_team_score", graphQLSportsDataMatchData.p());
        if (graphQLSportsDataMatchData.q() != null) {
            jsonGenerator.a("broadcast_network", graphQLSportsDataMatchData.q());
        }
        if (graphQLSportsDataMatchData.r() != null) {
            jsonGenerator.a("clock", graphQLSportsDataMatchData.r());
        }
        if (graphQLSportsDataMatchData.s() != null) {
            jsonGenerator.a("facts");
            GraphQLSportsDataMatchToFactsConnection__JsonHelper.m21798a(jsonGenerator, graphQLSportsDataMatchData.s(), true);
        }
        if (graphQLSportsDataMatchData.t() != null) {
            jsonGenerator.a("fan_favorite");
            GraphQLSportsDataMatchToFanFavoriteConnection__JsonHelper.m21807a(jsonGenerator, graphQLSportsDataMatchData.t(), true);
        }
        if (graphQLSportsDataMatchData.u() != null) {
            jsonGenerator.a("home_team");
            GraphQLPage__JsonHelper.m9554a(jsonGenerator, graphQLSportsDataMatchData.u(), true);
        }
        jsonGenerator.a("home_team_fan_count", graphQLSportsDataMatchData.v());
        if (graphQLSportsDataMatchData.w() != null) {
            jsonGenerator.a("home_team_market", graphQLSportsDataMatchData.w());
        }
        if (graphQLSportsDataMatchData.x() != null) {
            jsonGenerator.a("home_team_name", graphQLSportsDataMatchData.x());
        }
        if (graphQLSportsDataMatchData.y() != null) {
            jsonGenerator.a("home_team_primary_color", graphQLSportsDataMatchData.y());
        }
        jsonGenerator.a("home_team_score", graphQLSportsDataMatchData.z());
        if (graphQLSportsDataMatchData.A() != null) {
            jsonGenerator.a("id", graphQLSportsDataMatchData.A());
        }
        jsonGenerator.a("period", graphQLSportsDataMatchData.B());
        jsonGenerator.a("scheduled_start_time", graphQLSportsDataMatchData.C());
        if (graphQLSportsDataMatchData.D() != null) {
            jsonGenerator.a("sports_data_cover_photo");
            GraphQLPhoto__JsonHelper.m20765a(jsonGenerator, graphQLSportsDataMatchData.D(), true);
        }
        if (graphQLSportsDataMatchData.E() != null) {
            jsonGenerator.a("sports_data_fallback_photo");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLSportsDataMatchData.E(), true);
        }
        if (graphQLSportsDataMatchData.F() != null) {
            jsonGenerator.a("sports_subtitle", graphQLSportsDataMatchData.F());
        }
        if (graphQLSportsDataMatchData.G() != null) {
            jsonGenerator.a("status", graphQLSportsDataMatchData.G());
        }
        if (graphQLSportsDataMatchData.H() != null) {
            jsonGenerator.a("status_text", graphQLSportsDataMatchData.H());
        }
        jsonGenerator.a("updated_time", graphQLSportsDataMatchData.I());
        if (graphQLSportsDataMatchData.J() != null) {
            jsonGenerator.a("url", graphQLSportsDataMatchData.J());
        }
        jsonGenerator.a("viewer_can_vote_fan_favorite", graphQLSportsDataMatchData.K());
        if (graphQLSportsDataMatchData.L() != null) {
            jsonGenerator.a("match_page");
            GraphQLPage__JsonHelper.m9554a(jsonGenerator, graphQLSportsDataMatchData.L(), true);
        }
        jsonGenerator.a("has_match_started", graphQLSportsDataMatchData.M());
        if (z) {
            jsonGenerator.g();
        }
    }
}
