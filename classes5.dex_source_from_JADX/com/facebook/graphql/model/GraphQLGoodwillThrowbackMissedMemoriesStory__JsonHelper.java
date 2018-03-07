package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.facebook.graphql.enums.GraphQLObjectType;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;

/* compiled from: getUidStats */
public final class GraphQLGoodwillThrowbackMissedMemoriesStory__JsonHelper {
    public static boolean m8051a(GraphQLGoodwillThrowbackMissedMemoriesStory graphQLGoodwillThrowbackMissedMemoriesStory, String str, JsonParser jsonParser) {
        String str2 = null;
        if ("__type__".equals(str)) {
            graphQLGoodwillThrowbackMissedMemoriesStory.f4019d = GraphQLObjectType.a(jsonParser);
            return true;
        } else if ("fetchTimeMs".equals(str)) {
            long j;
            if (jsonParser.g() == JsonToken.VALUE_NULL) {
                j = 0;
            } else {
                j = jsonParser.F();
            }
            graphQLGoodwillThrowbackMissedMemoriesStory.f4020e = j;
            FieldAccessQueryTracker.a(jsonParser, graphQLGoodwillThrowbackMissedMemoriesStory, "fetchTimeMs", graphQLGoodwillThrowbackMissedMemoriesStory.a_, 0, false);
            return true;
        } else if ("photo_attachments".equals(str)) {
            if (jsonParser.g() == JsonToken.START_ARRAY) {
                r1 = new ArrayList();
                while (jsonParser.c() != JsonToken.END_ARRAY) {
                    GraphQLStoryAttachment a = GraphQLStoryAttachment__JsonHelper.m21862a(FieldAccessQueryTracker.a(jsonParser, "photo_attachments"));
                    if (a != null) {
                        r1.add(a);
                    }
                }
            } else {
                r1 = null;
            }
            if (r1 != null) {
                r0 = ImmutableList.copyOf(r1);
            }
            graphQLGoodwillThrowbackMissedMemoriesStory.f4021f = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLGoodwillThrowbackMissedMemoriesStory, "photo_attachments", graphQLGoodwillThrowbackMissedMemoriesStory.B_(), 1, true);
            return true;
        } else if ("photo_stories".equals(str)) {
            if (jsonParser.g() == JsonToken.START_ARRAY) {
                r1 = new ArrayList();
                while (jsonParser.c() != JsonToken.END_ARRAY) {
                    GraphQLStory a2 = GraphQLStory__JsonHelper.m21922a(FieldAccessQueryTracker.a(jsonParser, "photo_stories"));
                    if (a2 != null) {
                        r1.add(a2);
                    }
                }
            } else {
                r1 = null;
            }
            if (r1 != null) {
                r0 = ImmutableList.copyOf(r1);
            }
            graphQLGoodwillThrowbackMissedMemoriesStory.f4022g = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLGoodwillThrowbackMissedMemoriesStory, "photo_stories", graphQLGoodwillThrowbackMissedMemoriesStory.B_(), 2, true);
            return true;
        } else if ("section_header".equals(str)) {
            GraphQLGoodwillThrowbackSection a3;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a3 = GraphQLGoodwillThrowbackSection__JsonHelper.m8116a(FieldAccessQueryTracker.a(jsonParser, "section_header"));
            }
            graphQLGoodwillThrowbackMissedMemoriesStory.f4023h = a3;
            FieldAccessQueryTracker.a(jsonParser, graphQLGoodwillThrowbackMissedMemoriesStory, "section_header", graphQLGoodwillThrowbackMissedMemoriesStory.B_(), 3, true);
            return true;
        } else if (!"render_style".equals(str)) {
            return false;
        } else {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                str2 = jsonParser.o();
            }
            graphQLGoodwillThrowbackMissedMemoriesStory.f4024i = str2;
            FieldAccessQueryTracker.a(jsonParser, graphQLGoodwillThrowbackMissedMemoriesStory, "render_style", graphQLGoodwillThrowbackMissedMemoriesStory.B_(), 4, false);
            return true;
        }
    }
}
