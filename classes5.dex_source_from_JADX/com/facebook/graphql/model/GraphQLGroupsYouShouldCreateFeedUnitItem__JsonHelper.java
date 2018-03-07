package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.facebook.graphql.enums.GraphQLGroupCreationSuggestionType;
import com.facebook.graphql.enums.GraphQLGroupVisibility;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* compiled from: frame-rate */
public final class GraphQLGroupsYouShouldCreateFeedUnitItem__JsonHelper {
    public static GraphQLGroupsYouShouldCreateFeedUnitItem m8539a(JsonParser jsonParser) {
        GraphQLGroupsYouShouldCreateFeedUnitItem graphQLGroupsYouShouldCreateFeedUnitItem = new GraphQLGroupsYouShouldCreateFeedUnitItem();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            return null;
        }
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            m8541a(graphQLGroupsYouShouldCreateFeedUnitItem, i, jsonParser);
            jsonParser.f();
        }
        return graphQLGroupsYouShouldCreateFeedUnitItem;
    }

    private static boolean m8541a(GraphQLGroupsYouShouldCreateFeedUnitItem graphQLGroupsYouShouldCreateFeedUnitItem, String str, JsonParser jsonParser) {
        String str2 = null;
        if ("default_group_name".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                str2 = jsonParser.o();
            }
            graphQLGroupsYouShouldCreateFeedUnitItem.f4222d = str2;
            FieldAccessQueryTracker.a(jsonParser, graphQLGroupsYouShouldCreateFeedUnitItem, "default_group_name", graphQLGroupsYouShouldCreateFeedUnitItem.a_, 0, false);
            return true;
        } else if ("default_members".equals(str)) {
            GraphQLGroupCreationSuggestionDefaultMembersConnection a;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a = C0396xbb7ddb05.m8425a(FieldAccessQueryTracker.a(jsonParser, "default_members"));
            }
            graphQLGroupsYouShouldCreateFeedUnitItem.f4223e = a;
            FieldAccessQueryTracker.a(jsonParser, graphQLGroupsYouShouldCreateFeedUnitItem, "default_members", graphQLGroupsYouShouldCreateFeedUnitItem.B_(), 1, true);
            return true;
        } else if ("default_visibility".equals(str)) {
            graphQLGroupsYouShouldCreateFeedUnitItem.f4224f = GraphQLGroupVisibility.fromString(jsonParser.o());
            FieldAccessQueryTracker.a(jsonParser, graphQLGroupsYouShouldCreateFeedUnitItem, "default_visibility", graphQLGroupsYouShouldCreateFeedUnitItem.B_(), 2, false);
            return true;
        } else if ("profile".equals(str)) {
            GraphQLProfile a2;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a2 = GraphQLProfile__JsonHelper.m21114a(FieldAccessQueryTracker.a(jsonParser, "profile"));
            }
            graphQLGroupsYouShouldCreateFeedUnitItem.f4225g = a2;
            FieldAccessQueryTracker.a(jsonParser, graphQLGroupsYouShouldCreateFeedUnitItem, "profile", graphQLGroupsYouShouldCreateFeedUnitItem.B_(), 3, true);
            return true;
        } else if ("suggested_members".equals(str)) {
            Collection arrayList;
            List copyOf;
            if (jsonParser.g() == JsonToken.START_ARRAY) {
                arrayList = new ArrayList();
                while (jsonParser.c() != JsonToken.END_ARRAY) {
                    GraphQLUser a3 = GraphQLUser__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "suggested_members"));
                    if (a3 != null) {
                        arrayList.add(a3);
                    }
                }
            } else {
                arrayList = null;
            }
            if (arrayList != null) {
                copyOf = ImmutableList.copyOf(arrayList);
            }
            graphQLGroupsYouShouldCreateFeedUnitItem.f4226h = copyOf;
            FieldAccessQueryTracker.a(jsonParser, graphQLGroupsYouShouldCreateFeedUnitItem, "suggested_members", graphQLGroupsYouShouldCreateFeedUnitItem.B_(), 4, true);
            return true;
        } else if ("suggestion_cover_image".equals(str)) {
            GraphQLImage a4;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a4 = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "suggestion_cover_image"));
            }
            graphQLGroupsYouShouldCreateFeedUnitItem.f4227i = a4;
            FieldAccessQueryTracker.a(jsonParser, graphQLGroupsYouShouldCreateFeedUnitItem, "suggestion_cover_image", graphQLGroupsYouShouldCreateFeedUnitItem.B_(), 5, true);
            return true;
        } else if ("suggestion_identifier".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                str2 = jsonParser.o();
            }
            graphQLGroupsYouShouldCreateFeedUnitItem.f4228j = str2;
            FieldAccessQueryTracker.a(jsonParser, graphQLGroupsYouShouldCreateFeedUnitItem, "suggestion_identifier", graphQLGroupsYouShouldCreateFeedUnitItem.B_(), 6, false);
            return true;
        } else if ("suggestion_type".equals(str)) {
            graphQLGroupsYouShouldCreateFeedUnitItem.f4229k = GraphQLGroupCreationSuggestionType.fromString(jsonParser.o());
            FieldAccessQueryTracker.a(jsonParser, graphQLGroupsYouShouldCreateFeedUnitItem, "suggestion_type", graphQLGroupsYouShouldCreateFeedUnitItem.B_(), 7, false);
            return true;
        } else if (!"tracking".equals(str)) {
            return false;
        } else {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                str2 = jsonParser.o();
            }
            graphQLGroupsYouShouldCreateFeedUnitItem.f4230l = str2;
            FieldAccessQueryTracker.a(jsonParser, graphQLGroupsYouShouldCreateFeedUnitItem, "tracking", graphQLGroupsYouShouldCreateFeedUnitItem.B_(), 8, false);
            return true;
        }
    }

    public static void m8540a(JsonGenerator jsonGenerator, GraphQLGroupsYouShouldCreateFeedUnitItem graphQLGroupsYouShouldCreateFeedUnitItem, boolean z) {
        if (z) {
            jsonGenerator.f();
        }
        if (graphQLGroupsYouShouldCreateFeedUnitItem.m8528a() != null) {
            jsonGenerator.a("default_group_name", graphQLGroupsYouShouldCreateFeedUnitItem.m8528a());
        }
        if (graphQLGroupsYouShouldCreateFeedUnitItem.m8529j() != null) {
            jsonGenerator.a("default_members");
            C0396xbb7ddb05.m8426a(jsonGenerator, graphQLGroupsYouShouldCreateFeedUnitItem.m8529j(), true);
        }
        if (graphQLGroupsYouShouldCreateFeedUnitItem.m8531l() != null) {
            jsonGenerator.a("default_visibility", graphQLGroupsYouShouldCreateFeedUnitItem.m8531l().toString());
        }
        if (graphQLGroupsYouShouldCreateFeedUnitItem.m8532m() != null) {
            jsonGenerator.a("profile");
            GraphQLProfile__JsonHelper.m21115a(jsonGenerator, graphQLGroupsYouShouldCreateFeedUnitItem.m8532m(), true);
        }
        jsonGenerator.a("suggested_members");
        if (graphQLGroupsYouShouldCreateFeedUnitItem.m8533n() != null) {
            jsonGenerator.d();
            for (GraphQLUser graphQLUser : graphQLGroupsYouShouldCreateFeedUnitItem.m8533n()) {
                if (graphQLUser != null) {
                    GraphQLUser__JsonHelper.a(jsonGenerator, graphQLUser, true);
                }
            }
            jsonGenerator.e();
        } else {
            jsonGenerator.h();
        }
        if (graphQLGroupsYouShouldCreateFeedUnitItem.m8534o() != null) {
            jsonGenerator.a("suggestion_cover_image");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLGroupsYouShouldCreateFeedUnitItem.m8534o(), true);
        }
        if (graphQLGroupsYouShouldCreateFeedUnitItem.m8535p() != null) {
            jsonGenerator.a("suggestion_identifier", graphQLGroupsYouShouldCreateFeedUnitItem.m8535p());
        }
        if (graphQLGroupsYouShouldCreateFeedUnitItem.m8536q() != null) {
            jsonGenerator.a("suggestion_type", graphQLGroupsYouShouldCreateFeedUnitItem.m8536q().toString());
        }
        if (graphQLGroupsYouShouldCreateFeedUnitItem.m8530k() != null) {
            jsonGenerator.a("tracking", graphQLGroupsYouShouldCreateFeedUnitItem.m8530k());
        }
        if (z) {
            jsonGenerator.g();
        }
    }
}
