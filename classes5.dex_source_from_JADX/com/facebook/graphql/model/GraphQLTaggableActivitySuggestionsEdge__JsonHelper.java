package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* compiled from: UNREAD */
public final class GraphQLTaggableActivitySuggestionsEdge__JsonHelper {
    public static boolean m22081a(GraphQLTaggableActivitySuggestionsEdge graphQLTaggableActivitySuggestionsEdge, String str, JsonParser jsonParser) {
        String str2 = null;
        if ("associated_places_info".equals(str)) {
            GraphQLPlaceFlowInfo a;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a = GraphQLPlaceFlowInfo__JsonHelper.m20847a(FieldAccessQueryTracker.a(jsonParser, "associated_places_info"));
            }
            graphQLTaggableActivitySuggestionsEdge.f13273d = a;
            FieldAccessQueryTracker.a(jsonParser, graphQLTaggableActivitySuggestionsEdge, "associated_places_info", graphQLTaggableActivitySuggestionsEdge.a_, 0, true);
            return true;
        } else if ("cursor".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                str2 = jsonParser.o();
            }
            graphQLTaggableActivitySuggestionsEdge.f13274e = str2;
            FieldAccessQueryTracker.a(jsonParser, graphQLTaggableActivitySuggestionsEdge, "cursor", graphQLTaggableActivitySuggestionsEdge.B_(), 1, false);
            return true;
        } else if ("custom_icon_suggestions".equals(str)) {
            Collection arrayList;
            List copyOf;
            if (jsonParser.g() == JsonToken.START_ARRAY) {
                arrayList = new ArrayList();
                while (jsonParser.c() != JsonToken.END_ARRAY) {
                    GraphQLTaggableActivityIcon a2 = GraphQLTaggableActivityIcon__JsonHelper.m22054a(FieldAccessQueryTracker.a(jsonParser, "custom_icon_suggestions"));
                    if (a2 != null) {
                        arrayList.add(a2);
                    }
                }
            } else {
                arrayList = null;
            }
            if (arrayList != null) {
                copyOf = ImmutableList.copyOf(arrayList);
            }
            graphQLTaggableActivitySuggestionsEdge.f13275f = copyOf;
            FieldAccessQueryTracker.a(jsonParser, graphQLTaggableActivitySuggestionsEdge, "custom_icon_suggestions", graphQLTaggableActivitySuggestionsEdge.B_(), 2, true);
            return true;
        } else if ("display_name".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                str2 = jsonParser.o();
            }
            graphQLTaggableActivitySuggestionsEdge.f13276g = str2;
            FieldAccessQueryTracker.a(jsonParser, graphQLTaggableActivitySuggestionsEdge, "display_name", graphQLTaggableActivitySuggestionsEdge.B_(), 3, false);
            return true;
        } else if ("icon".equals(str)) {
            GraphQLTaggableActivityIcon a3;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a3 = GraphQLTaggableActivityIcon__JsonHelper.m22054a(FieldAccessQueryTracker.a(jsonParser, "icon"));
            }
            graphQLTaggableActivitySuggestionsEdge.f13277h = a3;
            FieldAccessQueryTracker.a(jsonParser, graphQLTaggableActivitySuggestionsEdge, "icon", graphQLTaggableActivitySuggestionsEdge.B_(), 4, true);
            return true;
        } else if ("iconImageLarge".equals(str)) {
            GraphQLImage a4;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a4 = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "iconImageLarge"));
            }
            graphQLTaggableActivitySuggestionsEdge.f13278i = a4;
            FieldAccessQueryTracker.a(jsonParser, graphQLTaggableActivitySuggestionsEdge, "iconImageLarge", graphQLTaggableActivitySuggestionsEdge.B_(), 5, true);
            return true;
        } else if ("node".equals(str)) {
            GraphQLProfile a5;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a5 = GraphQLProfile__JsonHelper.m21114a(FieldAccessQueryTracker.a(jsonParser, "node"));
            }
            graphQLTaggableActivitySuggestionsEdge.f13279j = a5;
            FieldAccessQueryTracker.a(jsonParser, graphQLTaggableActivitySuggestionsEdge, "node", graphQLTaggableActivitySuggestionsEdge.B_(), 6, true);
            return true;
        } else if ("show_attachment_preview".equals(str)) {
            graphQLTaggableActivitySuggestionsEdge.f13280k = jsonParser.g() == JsonToken.VALUE_NULL ? false : jsonParser.H();
            FieldAccessQueryTracker.a(jsonParser, graphQLTaggableActivitySuggestionsEdge, "show_attachment_preview", graphQLTaggableActivitySuggestionsEdge.B_(), 7, false);
            return true;
        } else if ("subtext".equals(str)) {
            GraphQLTextWithEntities a6;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a6 = GraphQLTextWithEntities__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "subtext"));
            }
            graphQLTaggableActivitySuggestionsEdge.f13281l = a6;
            FieldAccessQueryTracker.a(jsonParser, graphQLTaggableActivitySuggestionsEdge, "subtext", graphQLTaggableActivitySuggestionsEdge.B_(), 8, true);
            return true;
        } else if (!"tracking".equals(str)) {
            return false;
        } else {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                str2 = jsonParser.o();
            }
            graphQLTaggableActivitySuggestionsEdge.f13282m = str2;
            FieldAccessQueryTracker.a(jsonParser, graphQLTaggableActivitySuggestionsEdge, "tracking", graphQLTaggableActivitySuggestionsEdge.B_(), 9, false);
            return true;
        }
    }
}
