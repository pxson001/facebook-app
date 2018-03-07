package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* compiled from: fundraiser_detailed_progress_text */
public final class GraphQLGraphSearchResultDecoration__JsonHelper {
    public static GraphQLGraphSearchResultDecoration m8283a(JsonParser jsonParser) {
        GraphQLGraphSearchResultDecoration graphQLGraphSearchResultDecoration = new GraphQLGraphSearchResultDecoration();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            return null;
        }
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            m8285a(graphQLGraphSearchResultDecoration, i, jsonParser);
            jsonParser.f();
        }
        return graphQLGraphSearchResultDecoration;
    }

    private static boolean m8285a(GraphQLGraphSearchResultDecoration graphQLGraphSearchResultDecoration, String str, JsonParser jsonParser) {
        GraphQLGraphSearchSnippet graphQLGraphSearchSnippet = null;
        Collection arrayList;
        List copyOf;
        if ("comments".equals(str)) {
            if (jsonParser.g() == JsonToken.START_ARRAY) {
                arrayList = new ArrayList();
                while (jsonParser.c() != JsonToken.END_ARRAY) {
                    GraphQLComment a = GraphQLComment__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "comments"));
                    if (a != null) {
                        arrayList.add(a);
                    }
                }
            } else {
                arrayList = null;
            }
            if (arrayList != null) {
                copyOf = ImmutableList.copyOf(arrayList);
            }
            graphQLGraphSearchResultDecoration.f4101d = copyOf;
            FieldAccessQueryTracker.a(jsonParser, graphQLGraphSearchResultDecoration, "comments", graphQLGraphSearchResultDecoration.a_, 0, true);
            return true;
        } else if ("connected_friends".equals(str)) {
            GraphQLGraphSearchConnectedFriendsConnection a2;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a2 = GraphQLGraphSearchConnectedFriendsConnection__JsonHelper.m8146a(FieldAccessQueryTracker.a(jsonParser, "connected_friends"));
            }
            graphQLGraphSearchResultDecoration.f4102e = a2;
            FieldAccessQueryTracker.a(jsonParser, graphQLGraphSearchResultDecoration, "connected_friends", graphQLGraphSearchResultDecoration.B_(), 1, true);
            return true;
        } else if ("info_snippets".equals(str)) {
            if (jsonParser.g() == JsonToken.START_ARRAY) {
                arrayList = new ArrayList();
                while (jsonParser.c() != JsonToken.END_ARRAY) {
                    r2 = GraphQLGraphSearchSnippet__JsonHelper.m8320a(FieldAccessQueryTracker.a(jsonParser, "info_snippets"));
                    if (r2 != null) {
                        arrayList.add(r2);
                    }
                }
            } else {
                arrayList = null;
            }
            if (arrayList != null) {
                copyOf = ImmutableList.copyOf(arrayList);
            }
            graphQLGraphSearchResultDecoration.f4103f = copyOf;
            FieldAccessQueryTracker.a(jsonParser, graphQLGraphSearchResultDecoration, "info_snippets", graphQLGraphSearchResultDecoration.B_(), 2, true);
            return true;
        } else if ("lineage_snippets".equals(str)) {
            if (jsonParser.g() == JsonToken.START_ARRAY) {
                arrayList = new ArrayList();
                while (jsonParser.c() != JsonToken.END_ARRAY) {
                    r2 = GraphQLGraphSearchSnippet__JsonHelper.m8320a(FieldAccessQueryTracker.a(jsonParser, "lineage_snippets"));
                    if (r2 != null) {
                        arrayList.add(r2);
                    }
                }
            } else {
                arrayList = null;
            }
            if (arrayList != null) {
                copyOf = ImmutableList.copyOf(arrayList);
            }
            graphQLGraphSearchResultDecoration.f4104g = copyOf;
            FieldAccessQueryTracker.a(jsonParser, graphQLGraphSearchResultDecoration, "lineage_snippets", graphQLGraphSearchResultDecoration.B_(), 3, true);
            return true;
        } else if ("match_words".equals(str)) {
            if (jsonParser.g() == JsonToken.START_ARRAY) {
                arrayList = new ArrayList();
                while (jsonParser.c() != JsonToken.END_ARRAY) {
                    Object o = jsonParser.g() == JsonToken.VALUE_NULL ? null : jsonParser.o();
                    if (o != null) {
                        arrayList.add(o);
                    }
                }
            } else {
                arrayList = null;
            }
            if (arrayList != null) {
                copyOf = ImmutableList.copyOf(arrayList);
            }
            graphQLGraphSearchResultDecoration.f4105h = copyOf;
            FieldAccessQueryTracker.a(jsonParser, graphQLGraphSearchResultDecoration, "match_words", graphQLGraphSearchResultDecoration.B_(), 4, false);
            return true;
        } else if ("ordered_snippets".equals(str)) {
            if (jsonParser.g() == JsonToken.START_ARRAY) {
                arrayList = new ArrayList();
                while (jsonParser.c() != JsonToken.END_ARRAY) {
                    r2 = GraphQLGraphSearchSnippet__JsonHelper.m8320a(FieldAccessQueryTracker.a(jsonParser, "ordered_snippets"));
                    if (r2 != null) {
                        arrayList.add(r2);
                    }
                }
            } else {
                arrayList = null;
            }
            if (arrayList != null) {
                copyOf = ImmutableList.copyOf(arrayList);
            }
            graphQLGraphSearchResultDecoration.f4106i = copyOf;
            FieldAccessQueryTracker.a(jsonParser, graphQLGraphSearchResultDecoration, "ordered_snippets", graphQLGraphSearchResultDecoration.B_(), 5, true);
            return true;
        } else if ("snippet_source".equals(str)) {
            String o2;
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                o2 = jsonParser.o();
            }
            graphQLGraphSearchResultDecoration.f4107j = o2;
            FieldAccessQueryTracker.a(jsonParser, graphQLGraphSearchResultDecoration, "snippet_source", graphQLGraphSearchResultDecoration.B_(), 6, false);
            return true;
        } else if ("social_snippet".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                graphQLGraphSearchSnippet = GraphQLGraphSearchSnippet__JsonHelper.m8320a(FieldAccessQueryTracker.a(jsonParser, "social_snippet"));
            }
            graphQLGraphSearchResultDecoration.f4108k = graphQLGraphSearchSnippet;
            FieldAccessQueryTracker.a(jsonParser, graphQLGraphSearchResultDecoration, "social_snippet", graphQLGraphSearchResultDecoration.B_(), 7, true);
            return true;
        } else if (!"summary_snippet".equals(str)) {
            return false;
        } else {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                graphQLGraphSearchSnippet = GraphQLGraphSearchSnippet__JsonHelper.m8320a(FieldAccessQueryTracker.a(jsonParser, "summary_snippet"));
            }
            graphQLGraphSearchResultDecoration.f4109l = graphQLGraphSearchSnippet;
            FieldAccessQueryTracker.a(jsonParser, graphQLGraphSearchResultDecoration, "summary_snippet", graphQLGraphSearchResultDecoration.B_(), 8, true);
            return true;
        }
    }

    public static void m8284a(JsonGenerator jsonGenerator, GraphQLGraphSearchResultDecoration graphQLGraphSearchResultDecoration, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        jsonGenerator.a("comments");
        if (graphQLGraphSearchResultDecoration.m8272a() != null) {
            jsonGenerator.d();
            for (GraphQLComment graphQLComment : graphQLGraphSearchResultDecoration.m8272a()) {
                if (graphQLComment != null) {
                    GraphQLComment__JsonHelper.a(jsonGenerator, graphQLComment, true);
                }
            }
            jsonGenerator.e();
        } else {
            jsonGenerator.h();
        }
        if (graphQLGraphSearchResultDecoration.m8273j() != null) {
            jsonGenerator.a("connected_friends");
            GraphQLGraphSearchConnectedFriendsConnection__JsonHelper.m8147a(jsonGenerator, graphQLGraphSearchResultDecoration.m8273j(), true);
        }
        jsonGenerator.a("info_snippets");
        if (graphQLGraphSearchResultDecoration.m8274k() != null) {
            jsonGenerator.d();
            for (GraphQLGraphSearchSnippet graphQLGraphSearchSnippet : graphQLGraphSearchResultDecoration.m8274k()) {
                if (graphQLGraphSearchSnippet != null) {
                    GraphQLGraphSearchSnippet__JsonHelper.m8321a(jsonGenerator, graphQLGraphSearchSnippet, true);
                }
            }
            jsonGenerator.e();
        } else {
            jsonGenerator.h();
        }
        jsonGenerator.a("lineage_snippets");
        if (graphQLGraphSearchResultDecoration.m8275l() != null) {
            jsonGenerator.d();
            for (GraphQLGraphSearchSnippet graphQLGraphSearchSnippet2 : graphQLGraphSearchResultDecoration.m8275l()) {
                if (graphQLGraphSearchSnippet2 != null) {
                    GraphQLGraphSearchSnippet__JsonHelper.m8321a(jsonGenerator, graphQLGraphSearchSnippet2, true);
                }
            }
            jsonGenerator.e();
        } else {
            jsonGenerator.h();
        }
        jsonGenerator.a("match_words");
        if (graphQLGraphSearchResultDecoration.m8276m() != null) {
            jsonGenerator.d();
            for (String str : graphQLGraphSearchResultDecoration.m8276m()) {
                if (str != null) {
                    jsonGenerator.b(str);
                }
            }
            jsonGenerator.e();
        } else {
            jsonGenerator.h();
        }
        jsonGenerator.a("ordered_snippets");
        if (graphQLGraphSearchResultDecoration.m8277n() != null) {
            jsonGenerator.d();
            for (GraphQLGraphSearchSnippet graphQLGraphSearchSnippet22 : graphQLGraphSearchResultDecoration.m8277n()) {
                if (graphQLGraphSearchSnippet22 != null) {
                    GraphQLGraphSearchSnippet__JsonHelper.m8321a(jsonGenerator, graphQLGraphSearchSnippet22, true);
                }
            }
            jsonGenerator.e();
        } else {
            jsonGenerator.h();
        }
        if (graphQLGraphSearchResultDecoration.m8278o() != null) {
            jsonGenerator.a("snippet_source", graphQLGraphSearchResultDecoration.m8278o());
        }
        if (graphQLGraphSearchResultDecoration.m8279p() != null) {
            jsonGenerator.a("social_snippet");
            GraphQLGraphSearchSnippet__JsonHelper.m8321a(jsonGenerator, graphQLGraphSearchResultDecoration.m8279p(), true);
        }
        if (graphQLGraphSearchResultDecoration.m8280q() != null) {
            jsonGenerator.a("summary_snippet");
            GraphQLGraphSearchSnippet__JsonHelper.m8321a(jsonGenerator, graphQLGraphSearchResultDecoration.m8280q(), true);
        }
        if (z) {
            jsonGenerator.g();
        }
    }
}
