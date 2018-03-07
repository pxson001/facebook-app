package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.facebook.graphql.enums.GraphQLGraphSearchResultsDisplayStyle;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;

/* compiled from: fundraisers */
public final class GraphQLGraphSearchQuery__JsonHelper {
    public static GraphQLGraphSearchQuery m8265a(JsonParser jsonParser) {
        GraphQLGraphSearchQuery graphQLGraphSearchQuery = new GraphQLGraphSearchQuery();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            return null;
        }
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            m8267a(graphQLGraphSearchQuery, i, jsonParser);
            jsonParser.f();
        }
        return graphQLGraphSearchQuery;
    }

    private static boolean m8267a(GraphQLGraphSearchQuery graphQLGraphSearchQuery, String str, JsonParser jsonParser) {
        String str2 = null;
        if ("filtered_query".equals(str)) {
            GraphQLGraphSearchQuery a;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a = m8265a(FieldAccessQueryTracker.a(jsonParser, "filtered_query"));
            }
            graphQLGraphSearchQuery.f4057d = a;
            FieldAccessQueryTracker.a(jsonParser, graphQLGraphSearchQuery, "filtered_query", graphQLGraphSearchQuery.a_, 0, true);
            return true;
        } else if ("id".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                str2 = jsonParser.o();
            }
            graphQLGraphSearchQuery.f4058e = str2;
            FieldAccessQueryTracker.a(jsonParser, graphQLGraphSearchQuery, "id", graphQLGraphSearchQuery.B_(), 1, false);
            return true;
        } else if ("modules".equals(str)) {
            GraphQLGraphSearchModulesConnection a2;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a2 = GraphQLGraphSearchModulesConnection__JsonHelper.m8171a(FieldAccessQueryTracker.a(jsonParser, "modules"));
            }
            graphQLGraphSearchQuery.f4059f = a2;
            FieldAccessQueryTracker.a(jsonParser, graphQLGraphSearchQuery, "modules", graphQLGraphSearchQuery.B_(), 2, true);
            return true;
        } else if ("name".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                str2 = jsonParser.o();
            }
            graphQLGraphSearchQuery.f4060g = str2;
            FieldAccessQueryTracker.a(jsonParser, graphQLGraphSearchQuery, "name", graphQLGraphSearchQuery.B_(), 3, false);
            return true;
        } else if ("name_search_tokens".equals(str)) {
            if (jsonParser.g() == JsonToken.START_ARRAY) {
                r1 = new ArrayList();
                while (jsonParser.c() != JsonToken.END_ARRAY) {
                    Object o = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                    if (o != null) {
                        r1.add(o);
                    }
                }
            } else {
                r1 = null;
            }
            if (r1 != null) {
                r0 = ImmutableList.copyOf(r1);
            }
            graphQLGraphSearchQuery.f4061h = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLGraphSearchQuery, "name_search_tokens", graphQLGraphSearchQuery.B_(), 4, false);
            return true;
        } else if ("needle_filters".equals(str)) {
            if (jsonParser.g() == JsonToken.START_ARRAY) {
                r1 = new ArrayList();
                while (jsonParser.c() != JsonToken.END_ARRAY) {
                    r2 = GraphQLGraphSearchQueryFilterGroup__JsonHelper.m8233a(FieldAccessQueryTracker.a(jsonParser, "needle_filters"));
                    if (r2 != null) {
                        r1.add(r2);
                    }
                }
            } else {
                r1 = null;
            }
            if (r1 != null) {
                r0 = ImmutableList.copyOf(r1);
            }
            graphQLGraphSearchQuery.f4062i = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLGraphSearchQuery, "needle_filters", graphQLGraphSearchQuery.B_(), 5, true);
            return true;
        } else if ("post_search_intent_log".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                str2 = jsonParser.o();
            }
            graphQLGraphSearchQuery.f4063j = str2;
            FieldAccessQueryTracker.a(jsonParser, graphQLGraphSearchQuery, "post_search_intent_log", graphQLGraphSearchQuery.B_(), 6, false);
            return true;
        } else if ("query_function".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                str2 = jsonParser.o();
            }
            graphQLGraphSearchQuery.f4064k = str2;
            FieldAccessQueryTracker.a(jsonParser, graphQLGraphSearchQuery, "query_function", graphQLGraphSearchQuery.B_(), 7, false);
            return true;
        } else if ("query_title".equals(str)) {
            GraphQLGraphSearchQueryTitle a3;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a3 = GraphQLGraphSearchQueryTitle__JsonHelper.m8263a(FieldAccessQueryTracker.a(jsonParser, "query_title"));
            }
            graphQLGraphSearchQuery.f4065l = a3;
            FieldAccessQueryTracker.a(jsonParser, graphQLGraphSearchQuery, "query_title", graphQLGraphSearchQuery.B_(), 8, true);
            return true;
        } else if ("results".equals(str)) {
            GraphQLGraphSearchResultsConnection a4;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a4 = GraphQLGraphSearchResultsConnection__JsonHelper.m8297a(FieldAccessQueryTracker.a(jsonParser, "results"));
            }
            graphQLGraphSearchQuery.f4066m = a4;
            FieldAccessQueryTracker.a(jsonParser, graphQLGraphSearchQuery, "results", graphQLGraphSearchQuery.B_(), 9, true);
            return true;
        } else if ("search_result_style_list".equals(str)) {
            if (jsonParser.g() == JsonToken.START_ARRAY) {
                r1 = new ArrayList();
                while (jsonParser.c() != JsonToken.END_ARRAY) {
                    GraphQLGraphSearchResultsDisplayStyle fromString = GraphQLGraphSearchResultsDisplayStyle.fromString(jsonParser.o());
                    if (fromString != null) {
                        r1.add(fromString);
                    }
                }
            } else {
                r1 = null;
            }
            if (r1 != null) {
                r0 = ImmutableList.copyOf(r1);
            }
            graphQLGraphSearchQuery.f4067n = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLGraphSearchQuery, "search_result_style_list", graphQLGraphSearchQuery.B_(), 10, false);
            return true;
        } else if ("session_id".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                str2 = jsonParser.o();
            }
            graphQLGraphSearchQuery.f4068o = str2;
            FieldAccessQueryTracker.a(jsonParser, graphQLGraphSearchQuery, "session_id", graphQLGraphSearchQuery.B_(), 11, false);
            return true;
        } else if ("top_filters".equals(str)) {
            if (jsonParser.g() == JsonToken.START_ARRAY) {
                r1 = new ArrayList();
                while (jsonParser.c() != JsonToken.END_ARRAY) {
                    r2 = GraphQLGraphSearchQueryFilterGroup__JsonHelper.m8233a(FieldAccessQueryTracker.a(jsonParser, "top_filters"));
                    if (r2 != null) {
                        r1.add(r2);
                    }
                }
            } else {
                r1 = null;
            }
            if (r1 != null) {
                r0 = ImmutableList.copyOf(r1);
            }
            graphQLGraphSearchQuery.f4069p = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLGraphSearchQuery, "top_filters", graphQLGraphSearchQuery.B_(), 12, true);
            return true;
        } else if ("underlying_entity".equals(str)) {
            GraphQLProfile a5;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a5 = GraphQLProfile__JsonHelper.m21114a(FieldAccessQueryTracker.a(jsonParser, "underlying_entity"));
            }
            graphQLGraphSearchQuery.f4070q = a5;
            FieldAccessQueryTracker.a(jsonParser, graphQLGraphSearchQuery, "underlying_entity", graphQLGraphSearchQuery.B_(), 13, true);
            return true;
        } else if ("url".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                str2 = jsonParser.o();
            }
            graphQLGraphSearchQuery.f4071r = str2;
            FieldAccessQueryTracker.a(jsonParser, graphQLGraphSearchQuery, "url", graphQLGraphSearchQuery.B_(), 14, false);
            return true;
        } else if ("vertical_to_log".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                str2 = jsonParser.o();
            }
            graphQLGraphSearchQuery.f4072s = str2;
            FieldAccessQueryTracker.a(jsonParser, graphQLGraphSearchQuery, "vertical_to_log", graphQLGraphSearchQuery.B_(), 15, false);
            return true;
        } else if ("query_role".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                str2 = jsonParser.o();
            }
            graphQLGraphSearchQuery.f4073t = str2;
            FieldAccessQueryTracker.a(jsonParser, graphQLGraphSearchQuery, "query_role", graphQLGraphSearchQuery.B_(), 16, false);
            return true;
        } else if (!"estimated_results".equals(str)) {
            return false;
        } else {
            graphQLGraphSearchQuery.f4074u = jsonParser.g() == JsonToken.VALUE_NULL ? 0 : jsonParser.E();
            FieldAccessQueryTracker.a(jsonParser, graphQLGraphSearchQuery, "estimated_results", graphQLGraphSearchQuery.B_(), 18, false);
            return true;
        }
    }

    public static void m8266a(JsonGenerator jsonGenerator, GraphQLGraphSearchQuery graphQLGraphSearchQuery, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        if (graphQLGraphSearchQuery.m8181j() != null) {
            jsonGenerator.a("filtered_query");
            m8266a(jsonGenerator, graphQLGraphSearchQuery.m8181j(), true);
        }
        if (graphQLGraphSearchQuery.m8182k() != null) {
            jsonGenerator.a("id", graphQLGraphSearchQuery.m8182k());
        }
        if (graphQLGraphSearchQuery.m8183l() != null) {
            jsonGenerator.a("modules");
            GraphQLGraphSearchModulesConnection__JsonHelper.m8172a(jsonGenerator, graphQLGraphSearchQuery.m8183l(), true);
        }
        if (graphQLGraphSearchQuery.m8184m() != null) {
            jsonGenerator.a("name", graphQLGraphSearchQuery.m8184m());
        }
        jsonGenerator.a("name_search_tokens");
        if (graphQLGraphSearchQuery.m8185n() != null) {
            jsonGenerator.d();
            for (String str : graphQLGraphSearchQuery.m8185n()) {
                if (str != null) {
                    jsonGenerator.b(str);
                }
            }
            jsonGenerator.e();
        } else {
            jsonGenerator.h();
        }
        jsonGenerator.a("needle_filters");
        if (graphQLGraphSearchQuery.m8186o() != null) {
            jsonGenerator.d();
            for (GraphQLGraphSearchQueryFilterGroup graphQLGraphSearchQueryFilterGroup : graphQLGraphSearchQuery.m8186o()) {
                if (graphQLGraphSearchQueryFilterGroup != null) {
                    GraphQLGraphSearchQueryFilterGroup__JsonHelper.m8234a(jsonGenerator, graphQLGraphSearchQueryFilterGroup, true);
                }
            }
            jsonGenerator.e();
        } else {
            jsonGenerator.h();
        }
        if (graphQLGraphSearchQuery.m8187p() != null) {
            jsonGenerator.a("post_search_intent_log", graphQLGraphSearchQuery.m8187p());
        }
        if (graphQLGraphSearchQuery.m8188q() != null) {
            jsonGenerator.a("query_function", graphQLGraphSearchQuery.m8188q());
        }
        if (graphQLGraphSearchQuery.m8189r() != null) {
            jsonGenerator.a("query_title");
            GraphQLGraphSearchQueryTitle__JsonHelper.m8264a(jsonGenerator, graphQLGraphSearchQuery.m8189r(), true);
        }
        if (graphQLGraphSearchQuery.m8190s() != null) {
            jsonGenerator.a("results");
            GraphQLGraphSearchResultsConnection__JsonHelper.m8298a(jsonGenerator, graphQLGraphSearchQuery.m8190s(), true);
        }
        jsonGenerator.a("search_result_style_list");
        if (graphQLGraphSearchQuery.m8191t() != null) {
            jsonGenerator.d();
            for (GraphQLGraphSearchResultsDisplayStyle graphQLGraphSearchResultsDisplayStyle : graphQLGraphSearchQuery.m8191t()) {
                if (graphQLGraphSearchResultsDisplayStyle != null) {
                    jsonGenerator.b(graphQLGraphSearchResultsDisplayStyle.toString());
                }
            }
            jsonGenerator.e();
        } else {
            jsonGenerator.h();
        }
        if (graphQLGraphSearchQuery.m8192u() != null) {
            jsonGenerator.a("session_id", graphQLGraphSearchQuery.m8192u());
        }
        jsonGenerator.a("top_filters");
        if (graphQLGraphSearchQuery.m8193v() != null) {
            jsonGenerator.d();
            for (GraphQLGraphSearchQueryFilterGroup graphQLGraphSearchQueryFilterGroup2 : graphQLGraphSearchQuery.m8193v()) {
                if (graphQLGraphSearchQueryFilterGroup2 != null) {
                    GraphQLGraphSearchQueryFilterGroup__JsonHelper.m8234a(jsonGenerator, graphQLGraphSearchQueryFilterGroup2, true);
                }
            }
            jsonGenerator.e();
        } else {
            jsonGenerator.h();
        }
        if (graphQLGraphSearchQuery.m8194w() != null) {
            jsonGenerator.a("underlying_entity");
            GraphQLProfile__JsonHelper.m21115a(jsonGenerator, graphQLGraphSearchQuery.m8194w(), true);
        }
        if (graphQLGraphSearchQuery.m8195x() != null) {
            jsonGenerator.a("url", graphQLGraphSearchQuery.m8195x());
        }
        if (graphQLGraphSearchQuery.m8196y() != null) {
            jsonGenerator.a("vertical_to_log", graphQLGraphSearchQuery.m8196y());
        }
        if (graphQLGraphSearchQuery.m8197z() != null) {
            jsonGenerator.a("query_role", graphQLGraphSearchQuery.m8197z());
        }
        jsonGenerator.a("estimated_results", graphQLGraphSearchQuery.m8176A());
        if (z) {
            jsonGenerator.g();
        }
    }
}
