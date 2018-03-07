package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

/* compiled from: expiration_date */
public final class GraphQLNearbyPlacesBrowsePlaceResultsConnection__JsonHelper {
    public static GraphQLNearbyPlacesBrowsePlaceResultsConnection m9208a(JsonParser jsonParser) {
        GraphQLNearbyPlacesBrowsePlaceResultsConnection graphQLNearbyPlacesBrowsePlaceResultsConnection = new GraphQLNearbyPlacesBrowsePlaceResultsConnection();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            return null;
        }
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            m9210a(graphQLNearbyPlacesBrowsePlaceResultsConnection, i, jsonParser);
            jsonParser.f();
        }
        return graphQLNearbyPlacesBrowsePlaceResultsConnection;
    }

    private static boolean m9210a(GraphQLNearbyPlacesBrowsePlaceResultsConnection graphQLNearbyPlacesBrowsePlaceResultsConnection, String str, JsonParser jsonParser) {
        String str2 = null;
        if ("display_region_hint".equals(str)) {
            GraphQLGeoRectangle a;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a = GraphQLGeoRectangle__JsonHelper.m7766a(FieldAccessQueryTracker.a(jsonParser, "display_region_hint"));
            }
            graphQLNearbyPlacesBrowsePlaceResultsConnection.f4537d = a;
            FieldAccessQueryTracker.a(jsonParser, graphQLNearbyPlacesBrowsePlaceResultsConnection, "display_region_hint", graphQLNearbyPlacesBrowsePlaceResultsConnection.a_, 0, true);
            return true;
        } else if ("page_info".equals(str)) {
            GraphQLPageInfo a2;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a2 = GraphQLPageInfo__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "page_info"));
            }
            graphQLNearbyPlacesBrowsePlaceResultsConnection.f4538e = a2;
            FieldAccessQueryTracker.a(jsonParser, graphQLNearbyPlacesBrowsePlaceResultsConnection, "page_info", graphQLNearbyPlacesBrowsePlaceResultsConnection.B_(), 1, true);
            return true;
        } else if (!"tracking".equals(str)) {
            return false;
        } else {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                str2 = jsonParser.o();
            }
            graphQLNearbyPlacesBrowsePlaceResultsConnection.f4539f = str2;
            FieldAccessQueryTracker.a(jsonParser, graphQLNearbyPlacesBrowsePlaceResultsConnection, "tracking", graphQLNearbyPlacesBrowsePlaceResultsConnection.B_(), 2, false);
            return true;
        }
    }

    public static void m9209a(JsonGenerator jsonGenerator, GraphQLNearbyPlacesBrowsePlaceResultsConnection graphQLNearbyPlacesBrowsePlaceResultsConnection, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        if (graphQLNearbyPlacesBrowsePlaceResultsConnection.m9202a() != null) {
            jsonGenerator.a("display_region_hint");
            GraphQLGeoRectangle__JsonHelper.m7767a(jsonGenerator, graphQLNearbyPlacesBrowsePlaceResultsConnection.m9202a(), true);
        }
        if (graphQLNearbyPlacesBrowsePlaceResultsConnection.m9204j() != null) {
            jsonGenerator.a("page_info");
            GraphQLPageInfo__JsonHelper.a(jsonGenerator, graphQLNearbyPlacesBrowsePlaceResultsConnection.m9204j(), true);
        }
        if (graphQLNearbyPlacesBrowsePlaceResultsConnection.m9205k() != null) {
            jsonGenerator.a("tracking", graphQLNearbyPlacesBrowsePlaceResultsConnection.m9205k());
        }
        if (z) {
            jsonGenerator.g();
        }
    }
}
