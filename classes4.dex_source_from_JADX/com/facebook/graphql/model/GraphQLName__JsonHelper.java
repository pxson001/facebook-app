package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* compiled from: scaling_factor */
public final class GraphQLName__JsonHelper {
    public static GraphQLName m3236a(JsonParser jsonParser) {
        GraphQLName graphQLName = new GraphQLName();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            return null;
        }
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            m3238a(graphQLName, i, jsonParser);
            jsonParser.f();
        }
        return graphQLName;
    }

    private static boolean m3238a(GraphQLName graphQLName, String str, JsonParser jsonParser) {
        String str2 = null;
        if ("locale".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                str2 = jsonParser.o();
            }
            graphQLName.d = str2;
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLName, "locale", graphQLName.a_, 0, false);
            return true;
        } else if ("parts".equals(str)) {
            Collection arrayList;
            List copyOf;
            if (jsonParser.g() == JsonToken.START_ARRAY) {
                arrayList = new ArrayList();
                while (jsonParser.c() != JsonToken.END_ARRAY) {
                    GraphQLNamePart a = GraphQLNamePart__JsonHelper.m3239a(FieldAccessQueryTracker.m2235a(jsonParser, "parts"));
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
            graphQLName.e = copyOf;
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLName, "parts", graphQLName.B_(), 1, true);
            return true;
        } else if ("phonetic_name".equals(str)) {
            GraphQLName a2;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a2 = m3236a(FieldAccessQueryTracker.m2235a(jsonParser, "phonetic_name"));
            }
            graphQLName.f = a2;
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLName, "phonetic_name", graphQLName.B_(), 2, true);
            return true;
        } else if (!"text".equals(str)) {
            return false;
        } else {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                str2 = jsonParser.o();
            }
            graphQLName.g = str2;
            FieldAccessQueryTracker.m2236a(jsonParser, graphQLName, "text", graphQLName.B_(), 3, false);
            return true;
        }
    }

    public static void m3237a(JsonGenerator jsonGenerator, GraphQLName graphQLName, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        if (graphQLName.j() != null) {
            jsonGenerator.a("locale", graphQLName.j());
        }
        jsonGenerator.a("parts");
        if (graphQLName.a() != null) {
            jsonGenerator.d();
            for (GraphQLNamePart graphQLNamePart : graphQLName.a()) {
                if (graphQLNamePart != null) {
                    GraphQLNamePart__JsonHelper.m3240a(jsonGenerator, graphQLNamePart, true);
                }
            }
            jsonGenerator.e();
        } else {
            jsonGenerator.h();
        }
        if (graphQLName.k() != null) {
            jsonGenerator.a("phonetic_name");
            m3237a(jsonGenerator, graphQLName.k(), true);
        }
        if (graphQLName.s_() != null) {
            jsonGenerator.a("text", graphQLName.s_());
        }
        if (z) {
            jsonGenerator.g();
        }
    }
}
