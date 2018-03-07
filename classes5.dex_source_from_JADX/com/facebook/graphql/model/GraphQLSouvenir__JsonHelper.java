package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

/* compiled from: Unrecognized token byte 0x3A (malformed segment header? */
public final class GraphQLSouvenir__JsonHelper {
    public static boolean m21751a(GraphQLSouvenir graphQLSouvenir, String str, JsonParser jsonParser) {
        String str2 = null;
        if ("container_post".equals(str)) {
            GraphQLStory a;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a = GraphQLStory__JsonHelper.m21922a(FieldAccessQueryTracker.a(jsonParser, "container_post"));
            }
            graphQLSouvenir.f13026d = a;
            FieldAccessQueryTracker.a(jsonParser, graphQLSouvenir, "container_post", graphQLSouvenir.a_, 0, true);
            return true;
        } else if ("formatting_string".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                str2 = jsonParser.o();
            }
            graphQLSouvenir.f13027e = str2;
            FieldAccessQueryTracker.a(jsonParser, graphQLSouvenir, "formatting_string", graphQLSouvenir.B_(), 1, false);
            return true;
        } else if ("id".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                str2 = jsonParser.o();
            }
            graphQLSouvenir.f13028f = str2;
            FieldAccessQueryTracker.a(jsonParser, graphQLSouvenir, "id", graphQLSouvenir.B_(), 2, false);
            return true;
        } else if ("media_elements".equals(str)) {
            GraphQLSouvenirMediaConnection a2;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a2 = GraphQLSouvenirMediaConnection__JsonHelper.m21706a(FieldAccessQueryTracker.a(jsonParser, "media_elements"));
            }
            graphQLSouvenir.f13029g = a2;
            FieldAccessQueryTracker.a(jsonParser, graphQLSouvenir, "media_elements", graphQLSouvenir.B_(), 3, true);
            return true;
        } else if ("souvenir_cover_photo".equals(str)) {
            GraphQLPhoto a3;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a3 = GraphQLPhoto__JsonHelper.m20764a(FieldAccessQueryTracker.a(jsonParser, "souvenir_cover_photo"));
            }
            graphQLSouvenir.f13030h = a3;
            FieldAccessQueryTracker.a(jsonParser, graphQLSouvenir, "souvenir_cover_photo", graphQLSouvenir.B_(), 5, true);
            return true;
        } else if ("title".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLTextWithEntities__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "title"));
            }
            graphQLSouvenir.f13031i = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLSouvenir, "title", graphQLSouvenir.B_(), 6, true);
            return true;
        } else if ("titleForSummary".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLTextWithEntities__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "titleForSummary"));
            }
            graphQLSouvenir.f13032j = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLSouvenir, "titleForSummary", graphQLSouvenir.B_(), 7, true);
            return true;
        } else if (!"url".equals(str)) {
            return false;
        } else {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                str2 = jsonParser.o();
            }
            graphQLSouvenir.f13033k = str2;
            FieldAccessQueryTracker.a(jsonParser, graphQLSouvenir, "url", graphQLSouvenir.B_(), 8, false);
            return true;
        }
    }
}
