package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

/* compiled from: game_cta_action_bar */
public final class GraphQLGraphSearchQueryFilter__JsonHelper {
    public static GraphQLGraphSearchQueryFilter m8255a(JsonParser jsonParser) {
        GraphQLGraphSearchQueryFilter graphQLGraphSearchQueryFilter = new GraphQLGraphSearchQueryFilter();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            return null;
        }
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            m8257a(graphQLGraphSearchQueryFilter, i, jsonParser);
            jsonParser.f();
        }
        return graphQLGraphSearchQueryFilter;
    }

    private static boolean m8257a(GraphQLGraphSearchQueryFilter graphQLGraphSearchQueryFilter, String str, JsonParser jsonParser) {
        String str2 = null;
        if ("current_value".equals(str)) {
            GraphQLGraphSearchQueryFilterValue a;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a = GraphQLGraphSearchQueryFilterValue__JsonHelper.m8247a(FieldAccessQueryTracker.a(jsonParser, "current_value"));
            }
            graphQLGraphSearchQueryFilter.f4075d = a;
            FieldAccessQueryTracker.a(jsonParser, graphQLGraphSearchQueryFilter, "current_value", graphQLGraphSearchQueryFilter.a_, 0, true);
            return true;
        } else if ("custom_value".equals(str)) {
            GraphQLGraphSearchQueryFilterCustomValue a2;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a2 = GraphQLGraphSearchQueryFilterCustomValue__JsonHelper.m8223a(FieldAccessQueryTracker.a(jsonParser, "custom_value"));
            }
            graphQLGraphSearchQueryFilter.f4076e = a2;
            FieldAccessQueryTracker.a(jsonParser, graphQLGraphSearchQueryFilter, "custom_value", graphQLGraphSearchQueryFilter.B_(), 1, true);
            return true;
        } else if ("default_option_text".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                str2 = jsonParser.o();
            }
            graphQLGraphSearchQueryFilter.f4077f = str2;
            FieldAccessQueryTracker.a(jsonParser, graphQLGraphSearchQueryFilter, "default_option_text", graphQLGraphSearchQueryFilter.B_(), 2, false);
            return true;
        } else if ("filter_values".equals(str)) {
            GraphQLGraphSearchQueryFilterValuesConnection a3;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a3 = GraphQLGraphSearchQueryFilterValuesConnection__JsonHelper.m8253a(FieldAccessQueryTracker.a(jsonParser, "filter_values"));
            }
            graphQLGraphSearchQueryFilter.f4078g = a3;
            FieldAccessQueryTracker.a(jsonParser, graphQLGraphSearchQueryFilter, "filter_values", graphQLGraphSearchQueryFilter.B_(), 4, true);
            return true;
        } else if ("handle".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                str2 = jsonParser.o();
            }
            graphQLGraphSearchQueryFilter.f4079h = str2;
            FieldAccessQueryTracker.a(jsonParser, graphQLGraphSearchQueryFilter, "handle", graphQLGraphSearchQueryFilter.B_(), 5, false);
            return true;
        } else if ("id".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                str2 = jsonParser.o();
            }
            graphQLGraphSearchQueryFilter.f4080i = str2;
            FieldAccessQueryTracker.a(jsonParser, graphQLGraphSearchQueryFilter, "id", graphQLGraphSearchQueryFilter.B_(), 6, false);
            return true;
        } else if ("name".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                str2 = jsonParser.o();
            }
            graphQLGraphSearchQueryFilter.f4081j = str2;
            FieldAccessQueryTracker.a(jsonParser, graphQLGraphSearchQueryFilter, "name", graphQLGraphSearchQueryFilter.B_(), 7, false);
            return true;
        } else if ("text".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                str2 = jsonParser.o();
            }
            graphQLGraphSearchQueryFilter.f4082k = str2;
            FieldAccessQueryTracker.a(jsonParser, graphQLGraphSearchQueryFilter, "text", graphQLGraphSearchQueryFilter.B_(), 8, false);
            return true;
        } else if (!"search_place_holder".equals(str)) {
            return false;
        } else {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                str2 = jsonParser.o();
            }
            graphQLGraphSearchQueryFilter.f4083l = str2;
            FieldAccessQueryTracker.a(jsonParser, graphQLGraphSearchQueryFilter, "search_place_holder", graphQLGraphSearchQueryFilter.B_(), 9, false);
            return true;
        }
    }

    public static void m8256a(JsonGenerator jsonGenerator, GraphQLGraphSearchQueryFilter graphQLGraphSearchQueryFilter, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        if (graphQLGraphSearchQueryFilter.m8204j() != null) {
            jsonGenerator.a("current_value");
            GraphQLGraphSearchQueryFilterValue__JsonHelper.m8248a(jsonGenerator, graphQLGraphSearchQueryFilter.m8204j(), true);
        }
        if (graphQLGraphSearchQueryFilter.m8205k() != null) {
            jsonGenerator.a("custom_value");
            GraphQLGraphSearchQueryFilterCustomValue__JsonHelper.m8224a(jsonGenerator, graphQLGraphSearchQueryFilter.m8205k(), true);
        }
        if (graphQLGraphSearchQueryFilter.m8206l() != null) {
            jsonGenerator.a("default_option_text", graphQLGraphSearchQueryFilter.m8206l());
        }
        if (graphQLGraphSearchQueryFilter.m8207m() != null) {
            jsonGenerator.a("filter_values");
            GraphQLGraphSearchQueryFilterValuesConnection__JsonHelper.m8254a(jsonGenerator, graphQLGraphSearchQueryFilter.m8207m(), true);
        }
        if (graphQLGraphSearchQueryFilter.m8208n() != null) {
            jsonGenerator.a("handle", graphQLGraphSearchQueryFilter.m8208n());
        }
        if (graphQLGraphSearchQueryFilter.m8209o() != null) {
            jsonGenerator.a("id", graphQLGraphSearchQueryFilter.m8209o());
        }
        if (graphQLGraphSearchQueryFilter.m8210p() != null) {
            jsonGenerator.a("name", graphQLGraphSearchQueryFilter.m8210p());
        }
        if (graphQLGraphSearchQueryFilter.m8211q() != null) {
            jsonGenerator.a("text", graphQLGraphSearchQueryFilter.m8211q());
        }
        if (graphQLGraphSearchQueryFilter.m8212r() != null) {
            jsonGenerator.a("search_place_holder", graphQLGraphSearchQueryFilter.m8212r());
        }
        if (z) {
            jsonGenerator.g();
        }
    }
}
