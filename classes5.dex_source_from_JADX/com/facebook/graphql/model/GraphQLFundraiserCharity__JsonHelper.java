package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

/* compiled from: group_topic_tags */
public final class GraphQLFundraiserCharity__JsonHelper {
    public static GraphQLFundraiserCharity m7675a(JsonParser jsonParser) {
        GraphQLFundraiserCharity graphQLFundraiserCharity = new GraphQLFundraiserCharity();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            return null;
        }
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            m7677a(graphQLFundraiserCharity, i, jsonParser);
            jsonParser.f();
        }
        return graphQLFundraiserCharity;
    }

    private static boolean m7677a(GraphQLFundraiserCharity graphQLFundraiserCharity, String str, JsonParser jsonParser) {
        String str2 = null;
        if ("id".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                str2 = jsonParser.o();
            }
            graphQLFundraiserCharity.d = str2;
            FieldAccessQueryTracker.a(jsonParser, graphQLFundraiserCharity, "id", graphQLFundraiserCharity.a_, 1, false);
            return true;
        } else if ("page".equals(str)) {
            GraphQLPage a;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a = GraphQLPage__JsonHelper.m9553a(FieldAccessQueryTracker.a(jsonParser, "page"));
            }
            graphQLFundraiserCharity.e = a;
            FieldAccessQueryTracker.a(jsonParser, graphQLFundraiserCharity, "page", graphQLFundraiserCharity.B_(), 2, true);
            return true;
        } else if ("profile_pic".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                str2 = jsonParser.o();
            }
            graphQLFundraiserCharity.f = str2;
            FieldAccessQueryTracker.a(jsonParser, graphQLFundraiserCharity, "profile_pic", graphQLFundraiserCharity.B_(), 3, false);
            return true;
        } else if (!"url".equals(str)) {
            return false;
        } else {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                str2 = jsonParser.o();
            }
            graphQLFundraiserCharity.g = str2;
            FieldAccessQueryTracker.a(jsonParser, graphQLFundraiserCharity, "url", graphQLFundraiserCharity.B_(), 4, false);
            return true;
        }
    }

    public static void m7676a(JsonGenerator jsonGenerator, GraphQLFundraiserCharity graphQLFundraiserCharity, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        if (graphQLFundraiserCharity.j() != null) {
            jsonGenerator.a("id", graphQLFundraiserCharity.j());
        }
        if (graphQLFundraiserCharity.k() != null) {
            jsonGenerator.a("page");
            GraphQLPage__JsonHelper.m9554a(jsonGenerator, graphQLFundraiserCharity.k(), true);
        }
        if (graphQLFundraiserCharity.l() != null) {
            jsonGenerator.a("profile_pic", graphQLFundraiserCharity.l());
        }
        if (graphQLFundraiserCharity.m() != null) {
            jsonGenerator.a("url", graphQLFundraiserCharity.m());
        }
        if (z) {
            jsonGenerator.g();
        }
    }
}
