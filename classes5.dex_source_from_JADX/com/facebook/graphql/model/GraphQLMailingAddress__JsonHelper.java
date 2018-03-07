package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

/* compiled from: fb_jewel */
public final class GraphQLMailingAddress__JsonHelper {
    public static boolean m8984a(GraphQLMailingAddress graphQLMailingAddress, String str, JsonParser jsonParser) {
        String str2 = null;
        if ("address".equals(str)) {
            GraphQLStreetAddress a;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a = GraphQLStreetAddress__JsonHelper.m21936a(FieldAccessQueryTracker.a(jsonParser, "address"));
            }
            graphQLMailingAddress.f4415d = a;
            FieldAccessQueryTracker.a(jsonParser, graphQLMailingAddress, "address", graphQLMailingAddress.a_, 0, true);
            return true;
        } else if ("city".equals(str)) {
            GraphQLPage a2;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a2 = GraphQLPage__JsonHelper.m9553a(FieldAccessQueryTracker.a(jsonParser, "city"));
            }
            graphQLMailingAddress.f4416e = a2;
            FieldAccessQueryTracker.a(jsonParser, graphQLMailingAddress, "city", graphQLMailingAddress.B_(), 1, true);
            return true;
        } else if ("id".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                str2 = jsonParser.o();
            }
            graphQLMailingAddress.f4417f = str2;
            FieldAccessQueryTracker.a(jsonParser, graphQLMailingAddress, "id", graphQLMailingAddress.B_(), 2, false);
            return true;
        } else if ("is_default".equals(str)) {
            graphQLMailingAddress.f4418g = jsonParser.g() == JsonToken.VALUE_NULL ? false : jsonParser.H();
            FieldAccessQueryTracker.a(jsonParser, graphQLMailingAddress, "is_default", graphQLMailingAddress.B_(), 3, false);
            return true;
        } else if ("is_messenger_eligible".equals(str)) {
            graphQLMailingAddress.f4419h = jsonParser.g() == JsonToken.VALUE_NULL ? false : jsonParser.H();
            FieldAccessQueryTracker.a(jsonParser, graphQLMailingAddress, "is_messenger_eligible", graphQLMailingAddress.B_(), 4, false);
            return true;
        } else if ("label".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                str2 = jsonParser.o();
            }
            graphQLMailingAddress.f4420i = str2;
            FieldAccessQueryTracker.a(jsonParser, graphQLMailingAddress, "label", graphQLMailingAddress.B_(), 5, false);
            return true;
        } else if ("url".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                str2 = jsonParser.o();
            }
            graphQLMailingAddress.f4421j = str2;
            FieldAccessQueryTracker.a(jsonParser, graphQLMailingAddress, "url", graphQLMailingAddress.B_(), 6, false);
            return true;
        } else if ("city_name".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                str2 = jsonParser.o();
            }
            graphQLMailingAddress.f4422k = str2;
            FieldAccessQueryTracker.a(jsonParser, graphQLMailingAddress, "city_name", graphQLMailingAddress.B_(), 7, false);
            return true;
        } else if (!"region_name".equals(str)) {
            return false;
        } else {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                str2 = jsonParser.o();
            }
            graphQLMailingAddress.f4423l = str2;
            FieldAccessQueryTracker.a(jsonParser, graphQLMailingAddress, "region_name", graphQLMailingAddress.B_(), 8, false);
            return true;
        }
    }
}
