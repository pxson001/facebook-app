package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.facebook.graphql.enums.GraphQLGraphSearchResultsDisplayStyle;
import com.facebook.graphql.enums.GraphQLObjectType;
import com.facebook.graphql.enums.GraphQLSavedState;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* compiled from: VERTEX_PERMANENTLY_CLOSED_DIALOG */
public final class GraphQLSearchSuggestionUnit__JsonHelper {
    public static GraphQLSearchSuggestionUnit m21608a(JsonParser jsonParser) {
        GraphQLSearchSuggestionUnit graphQLSearchSuggestionUnit = new GraphQLSearchSuggestionUnit();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            return null;
        }
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            if ("__type__".equals(i)) {
                GraphQLObjectType graphQLObjectType;
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    graphQLObjectType = null;
                } else {
                    graphQLObjectType = GraphQLObjectType.a(jsonParser);
                }
                graphQLSearchSuggestionUnit.f13004d = graphQLObjectType;
                FieldAccessQueryTracker.a(jsonParser, graphQLSearchSuggestionUnit, "__type__", graphQLSearchSuggestionUnit.a_, 0, false);
            } else if ("does_viewer_like".equals(i)) {
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    r3 = false;
                } else {
                    r3 = jsonParser.H();
                }
                graphQLSearchSuggestionUnit.f13005e = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLSearchSuggestionUnit, "does_viewer_like", graphQLSearchSuggestionUnit.a_, 1, false);
            } else if ("icon_image".equals(i)) {
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    r3 = null;
                } else {
                    r3 = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "icon_image"));
                }
                graphQLSearchSuggestionUnit.f13006f = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLSearchSuggestionUnit, "icon_image", graphQLSearchSuggestionUnit.a_, 2, true);
            } else if ("id".equals(i)) {
                r3 = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                graphQLSearchSuggestionUnit.f13007g = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLSearchSuggestionUnit, "id", graphQLSearchSuggestionUnit.a_, 3, false);
            } else if ("is_verified".equals(i)) {
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    r3 = false;
                } else {
                    r3 = jsonParser.H();
                }
                graphQLSearchSuggestionUnit.f13008h = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLSearchSuggestionUnit, "is_verified", graphQLSearchSuggestionUnit.a_, 4, false);
            } else if ("is_viewer_friend".equals(i)) {
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    r3 = false;
                } else {
                    r3 = jsonParser.H();
                }
                graphQLSearchSuggestionUnit.f13009i = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLSearchSuggestionUnit, "is_viewer_friend", graphQLSearchSuggestionUnit.a_, 5, false);
            } else if ("name".equals(i)) {
                r3 = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                graphQLSearchSuggestionUnit.f13010j = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLSearchSuggestionUnit, "name", graphQLSearchSuggestionUnit.a_, 6, false);
            } else if ("profile_picture".equals(i)) {
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    r3 = null;
                } else {
                    r3 = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "profile_picture"));
                }
                graphQLSearchSuggestionUnit.f13011k = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLSearchSuggestionUnit, "profile_picture", graphQLSearchSuggestionUnit.a_, 7, true);
            } else if ("query_title".equals(i)) {
                GraphQLGraphSearchQueryTitle graphQLGraphSearchQueryTitle;
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    graphQLGraphSearchQueryTitle = null;
                } else {
                    graphQLGraphSearchQueryTitle = GraphQLGraphSearchQueryTitle__JsonHelper.m8263a(FieldAccessQueryTracker.a(jsonParser, "query_title"));
                }
                graphQLSearchSuggestionUnit.f13012l = graphQLGraphSearchQueryTitle;
                FieldAccessQueryTracker.a(jsonParser, graphQLSearchSuggestionUnit, "query_title", graphQLSearchSuggestionUnit.a_, 8, true);
            } else if ("search_result_style_list".equals(i)) {
                List list;
                Collection collection = null;
                if (jsonParser.g() == JsonToken.START_ARRAY) {
                    collection = new ArrayList();
                    while (jsonParser.c() != JsonToken.END_ARRAY) {
                        GraphQLGraphSearchResultsDisplayStyle fromString = GraphQLGraphSearchResultsDisplayStyle.fromString(jsonParser.o());
                        if (fromString != null) {
                            collection.add(fromString);
                        }
                    }
                }
                if (collection == null) {
                    list = null;
                } else {
                    list = ImmutableList.copyOf(collection);
                }
                graphQLSearchSuggestionUnit.f13013m = list;
                FieldAccessQueryTracker.a(jsonParser, graphQLSearchSuggestionUnit, "search_result_style_list", graphQLSearchSuggestionUnit.a_, 9, false);
            } else if ("url".equals(i)) {
                r3 = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                graphQLSearchSuggestionUnit.f13014n = r3;
                FieldAccessQueryTracker.a(jsonParser, graphQLSearchSuggestionUnit, "url", graphQLSearchSuggestionUnit.a_, 10, false);
            } else if ("viewer_saved_state".equals(i)) {
                graphQLSearchSuggestionUnit.f13015o = GraphQLSavedState.fromString(jsonParser.o());
                FieldAccessQueryTracker.a(jsonParser, graphQLSearchSuggestionUnit, "viewer_saved_state", graphQLSearchSuggestionUnit.a_, 11, false);
            }
            jsonParser.f();
        }
        return graphQLSearchSuggestionUnit;
    }

    public static void m21609a(JsonGenerator jsonGenerator, GraphQLSearchSuggestionUnit graphQLSearchSuggestionUnit, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        if (graphQLSearchSuggestionUnit.m21594j() != null) {
            jsonGenerator.a("__type__");
            jsonGenerator.f();
            jsonGenerator.a("name", graphQLSearchSuggestionUnit.m21594j().e());
            jsonGenerator.g();
        }
        jsonGenerator.a("does_viewer_like", graphQLSearchSuggestionUnit.m21595k());
        if (graphQLSearchSuggestionUnit.m21596l() != null) {
            jsonGenerator.a("icon_image");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLSearchSuggestionUnit.m21596l(), true);
        }
        if (graphQLSearchSuggestionUnit.m21597m() != null) {
            jsonGenerator.a("id", graphQLSearchSuggestionUnit.m21597m());
        }
        jsonGenerator.a("is_verified", graphQLSearchSuggestionUnit.m21598n());
        jsonGenerator.a("is_viewer_friend", graphQLSearchSuggestionUnit.m21599o());
        if (graphQLSearchSuggestionUnit.m21600p() != null) {
            jsonGenerator.a("name", graphQLSearchSuggestionUnit.m21600p());
        }
        if (graphQLSearchSuggestionUnit.m21601q() != null) {
            jsonGenerator.a("profile_picture");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLSearchSuggestionUnit.m21601q(), true);
        }
        if (graphQLSearchSuggestionUnit.m21602r() != null) {
            jsonGenerator.a("query_title");
            GraphQLGraphSearchQueryTitle__JsonHelper.m8264a(jsonGenerator, graphQLSearchSuggestionUnit.m21602r(), true);
        }
        jsonGenerator.a("search_result_style_list");
        if (graphQLSearchSuggestionUnit.m21603s() != null) {
            jsonGenerator.d();
            for (GraphQLGraphSearchResultsDisplayStyle graphQLGraphSearchResultsDisplayStyle : graphQLSearchSuggestionUnit.m21603s()) {
                if (graphQLGraphSearchResultsDisplayStyle != null) {
                    jsonGenerator.b(graphQLGraphSearchResultsDisplayStyle.toString());
                }
            }
            jsonGenerator.e();
        } else {
            jsonGenerator.h();
        }
        if (graphQLSearchSuggestionUnit.m21604t() != null) {
            jsonGenerator.a("url", graphQLSearchSuggestionUnit.m21604t());
        }
        if (graphQLSearchSuggestionUnit.m21605u() != null) {
            jsonGenerator.a("viewer_saved_state", graphQLSearchSuggestionUnit.m21605u().toString());
        }
        if (z) {
            jsonGenerator.g();
        }
    }
}
