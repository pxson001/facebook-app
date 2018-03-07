package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* compiled from: fbandroid_pistol_fire_crash */
public final class GraphQLLocalContextAttachmentStyleInfo__JsonHelper {
    public static boolean m8959a(GraphQLLocalContextAttachmentStyleInfo graphQLLocalContextAttachmentStyleInfo, String str, JsonParser jsonParser) {
        String str2 = null;
        if ("category_name".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                str2 = jsonParser.o();
            }
            graphQLLocalContextAttachmentStyleInfo.f4409d = str2;
            FieldAccessQueryTracker.a(jsonParser, graphQLLocalContextAttachmentStyleInfo, "category_name", graphQLLocalContextAttachmentStyleInfo.a_, 0, false);
            return true;
        } else if ("place_open_status_formats".equals(str)) {
            Collection arrayList;
            List copyOf;
            if (jsonParser.g() == JsonToken.START_ARRAY) {
                arrayList = new ArrayList();
                while (jsonParser.c() != JsonToken.END_ARRAY) {
                    GraphQLPlaceOpenStatusFormat a = GraphQLPlaceOpenStatusFormat__JsonHelper.m20886a(FieldAccessQueryTracker.a(jsonParser, "place_open_status_formats"));
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
            graphQLLocalContextAttachmentStyleInfo.f4410e = copyOf;
            FieldAccessQueryTracker.a(jsonParser, graphQLLocalContextAttachmentStyleInfo, "place_open_status_formats", graphQLLocalContextAttachmentStyleInfo.B_(), 1, true);
            return true;
        } else if (!"time_zone".equals(str)) {
            return false;
        } else {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                str2 = jsonParser.o();
            }
            graphQLLocalContextAttachmentStyleInfo.f4411f = str2;
            FieldAccessQueryTracker.a(jsonParser, graphQLLocalContextAttachmentStyleInfo, "time_zone", graphQLLocalContextAttachmentStyleInfo.B_(), 2, false);
            return true;
        }
    }
}
