package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

/* compiled from: group_info_page */
public final class GraphQLGeoRectangle__JsonHelper {
    public static GraphQLGeoRectangle m7766a(JsonParser jsonParser) {
        GraphQLGeoRectangle graphQLGeoRectangle = new GraphQLGeoRectangle();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            return null;
        }
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            double d;
            if ("east".equals(i)) {
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    d = 0.0d;
                } else {
                    d = jsonParser.G();
                }
                graphQLGeoRectangle.d = d;
                FieldAccessQueryTracker.a(jsonParser, graphQLGeoRectangle, "east", graphQLGeoRectangle.a_, 0, false);
            } else if ("north".equals(i)) {
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    d = 0.0d;
                } else {
                    d = jsonParser.G();
                }
                graphQLGeoRectangle.e = d;
                FieldAccessQueryTracker.a(jsonParser, graphQLGeoRectangle, "north", graphQLGeoRectangle.a_, 1, false);
            } else if ("south".equals(i)) {
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    d = 0.0d;
                } else {
                    d = jsonParser.G();
                }
                graphQLGeoRectangle.f = d;
                FieldAccessQueryTracker.a(jsonParser, graphQLGeoRectangle, "south", graphQLGeoRectangle.a_, 2, false);
            } else if ("west".equals(i)) {
                if (jsonParser.g() == JsonToken.VALUE_NULL) {
                    d = 0.0d;
                } else {
                    d = jsonParser.G();
                }
                graphQLGeoRectangle.g = d;
                FieldAccessQueryTracker.a(jsonParser, graphQLGeoRectangle, "west", graphQLGeoRectangle.a_, 3, false);
            }
            jsonParser.f();
        }
        return graphQLGeoRectangle;
    }

    public static void m7767a(JsonGenerator jsonGenerator, GraphQLGeoRectangle graphQLGeoRectangle, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        jsonGenerator.a("east", graphQLGeoRectangle.a());
        jsonGenerator.a("north", graphQLGeoRectangle.j());
        jsonGenerator.a("south", graphQLGeoRectangle.k());
        jsonGenerator.a("west", graphQLGeoRectangle.l());
        if (z) {
            jsonGenerator.g();
        }
    }
}
