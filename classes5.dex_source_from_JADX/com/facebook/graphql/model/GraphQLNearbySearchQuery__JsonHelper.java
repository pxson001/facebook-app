package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* compiled from: experimental_freeform_price */
public final class GraphQLNearbySearchQuery__JsonHelper {
    public static boolean m9220a(GraphQLNearbySearchQuery graphQLNearbySearchQuery, String str, JsonParser jsonParser) {
        String str2 = null;
        if ("browse_places".equals(str)) {
            GraphQLNearbyPlacesBrowsePlaceResultsConnection a;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a = GraphQLNearbyPlacesBrowsePlaceResultsConnection__JsonHelper.m9208a(FieldAccessQueryTracker.a(jsonParser, "browse_places"));
            }
            graphQLNearbySearchQuery.f4540d = a;
            FieldAccessQueryTracker.a(jsonParser, graphQLNearbySearchQuery, "browse_places", graphQLNearbySearchQuery.a_, 0, true);
            return true;
        } else if ("query_suggestions".equals(str)) {
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
            graphQLNearbySearchQuery.f4541e = copyOf;
            FieldAccessQueryTracker.a(jsonParser, graphQLNearbySearchQuery, "query_suggestions", graphQLNearbySearchQuery.B_(), 1, false);
            return true;
        } else if (!"search_session_id".equals(str)) {
            return false;
        } else {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                str2 = jsonParser.o();
            }
            graphQLNearbySearchQuery.f4542f = str2;
            FieldAccessQueryTracker.a(jsonParser, graphQLNearbySearchQuery, "search_session_id", graphQLNearbySearchQuery.B_(), 2, false);
            return true;
        }
    }
}
