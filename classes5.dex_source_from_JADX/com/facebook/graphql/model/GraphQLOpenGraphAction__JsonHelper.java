package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* compiled from: event_based_pyml */
public final class GraphQLOpenGraphAction__JsonHelper {
    public static GraphQLOpenGraphAction m9395a(JsonParser jsonParser) {
        GraphQLOpenGraphAction graphQLOpenGraphAction = new GraphQLOpenGraphAction();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            return null;
        }
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            m9397a(graphQLOpenGraphAction, i, jsonParser);
            jsonParser.f();
        }
        return graphQLOpenGraphAction;
    }

    private static boolean m9397a(GraphQLOpenGraphAction graphQLOpenGraphAction, String str, JsonParser jsonParser) {
        String str2 = null;
        if ("android_urls".equals(str)) {
            Collection arrayList;
            List copyOf;
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
            graphQLOpenGraphAction.d = copyOf;
            FieldAccessQueryTracker.a(jsonParser, graphQLOpenGraphAction, "android_urls", graphQLOpenGraphAction.a_, 0, false);
            return true;
        } else if ("application".equals(str)) {
            GraphQLApplication a;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a = GraphQLApplication__JsonHelper.m6587a(FieldAccessQueryTracker.a(jsonParser, "application"));
            }
            graphQLOpenGraphAction.e = a;
            FieldAccessQueryTracker.a(jsonParser, graphQLOpenGraphAction, "application", graphQLOpenGraphAction.B_(), 1, true);
            return true;
        } else if ("feedback".equals(str)) {
            GraphQLFeedback a2;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a2 = GraphQLFeedback__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "feedback"));
            }
            graphQLOpenGraphAction.f = a2;
            FieldAccessQueryTracker.a(jsonParser, graphQLOpenGraphAction, "feedback", graphQLOpenGraphAction.B_(), 2, true);
            return true;
        } else if ("id".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                str2 = jsonParser.o();
            }
            graphQLOpenGraphAction.g = str2;
            FieldAccessQueryTracker.a(jsonParser, graphQLOpenGraphAction, "id", graphQLOpenGraphAction.B_(), 3, false);
            return true;
        } else if ("primary_object_node".equals(str)) {
            GraphQLNode a3;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a3 = GraphQLNode__JsonHelper.m9292a(FieldAccessQueryTracker.a(jsonParser, "primary_object_node"));
            }
            graphQLOpenGraphAction.h = a3;
            FieldAccessQueryTracker.a(jsonParser, graphQLOpenGraphAction, "primary_object_node", graphQLOpenGraphAction.B_(), 4, true);
            return true;
        } else if (!"url".equals(str)) {
            return false;
        } else {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                str2 = jsonParser.o();
            }
            graphQLOpenGraphAction.i = str2;
            FieldAccessQueryTracker.a(jsonParser, graphQLOpenGraphAction, "url", graphQLOpenGraphAction.B_(), 5, false);
            return true;
        }
    }

    public static void m9396a(JsonGenerator jsonGenerator, GraphQLOpenGraphAction graphQLOpenGraphAction, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        jsonGenerator.a("android_urls");
        if (graphQLOpenGraphAction.j() != null) {
            jsonGenerator.d();
            for (String str : graphQLOpenGraphAction.j()) {
                if (str != null) {
                    jsonGenerator.b(str);
                }
            }
            jsonGenerator.e();
        } else {
            jsonGenerator.h();
        }
        if (graphQLOpenGraphAction.k() != null) {
            jsonGenerator.a("application");
            GraphQLApplication__JsonHelper.m6588a(jsonGenerator, graphQLOpenGraphAction.k(), true);
        }
        if (graphQLOpenGraphAction.l() != null) {
            jsonGenerator.a("feedback");
            GraphQLFeedback__JsonHelper.a(jsonGenerator, graphQLOpenGraphAction.l(), true);
        }
        if (graphQLOpenGraphAction.m() != null) {
            jsonGenerator.a("id", graphQLOpenGraphAction.m());
        }
        if (graphQLOpenGraphAction.n() != null) {
            jsonGenerator.a("primary_object_node");
            GraphQLNode__JsonHelper.m9293a(jsonGenerator, graphQLOpenGraphAction.n(), true);
        }
        if (graphQLOpenGraphAction.o() != null) {
            jsonGenerator.a("url", graphQLOpenGraphAction.o());
        }
        if (z) {
            jsonGenerator.g();
        }
    }
}
