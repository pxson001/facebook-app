package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

/* compiled from: VoIP Call */
public final class GraphQLPostChannel__JsonHelper {
    public static boolean m20965a(GraphQLPostChannel graphQLPostChannel, String str, JsonParser jsonParser) {
        long j = 0;
        String str2 = null;
        GraphQLFocusedPhoto a;
        if ("blurredCoverPhoto".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a = GraphQLFocusedPhoto__JsonHelper.m7526a(FieldAccessQueryTracker.a(jsonParser, "blurredCoverPhoto"));
            }
            graphQLPostChannel.f12675d = a;
            FieldAccessQueryTracker.a(jsonParser, graphQLPostChannel, "blurredCoverPhoto", graphQLPostChannel.a_, 0, true);
            return true;
        } else if ("can_viewer_delete".equals(str)) {
            graphQLPostChannel.f12676e = jsonParser.g() == JsonToken.VALUE_NULL ? false : jsonParser.H();
            FieldAccessQueryTracker.a(jsonParser, graphQLPostChannel, "can_viewer_delete", graphQLPostChannel.B_(), 1, false);
            return true;
        } else if ("can_viewer_edit".equals(str)) {
            graphQLPostChannel.f12677f = jsonParser.g() == JsonToken.VALUE_NULL ? false : jsonParser.H();
            FieldAccessQueryTracker.a(jsonParser, graphQLPostChannel, "can_viewer_edit", graphQLPostChannel.B_(), 2, false);
            return true;
        } else if ("cover_photo".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a = GraphQLFocusedPhoto__JsonHelper.m7526a(FieldAccessQueryTracker.a(jsonParser, "cover_photo"));
            }
            graphQLPostChannel.f12678g = a;
            FieldAccessQueryTracker.a(jsonParser, graphQLPostChannel, "cover_photo", graphQLPostChannel.B_(), 3, true);
            return true;
        } else if ("creation_time".equals(str)) {
            graphQLPostChannel.f12679h = jsonParser.g() == JsonToken.VALUE_NULL ? 0 : jsonParser.F();
            FieldAccessQueryTracker.a(jsonParser, graphQLPostChannel, "creation_time", graphQLPostChannel.B_(), 4, false);
            return true;
        } else if ("feedback".equals(str)) {
            GraphQLFeedback a2;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a2 = GraphQLFeedback__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "feedback"));
            }
            graphQLPostChannel.f12680i = a2;
            FieldAccessQueryTracker.a(jsonParser, graphQLPostChannel, "feedback", graphQLPostChannel.B_(), 5, true);
            return true;
        } else if ("id".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                str2 = jsonParser.o();
            }
            graphQLPostChannel.f12681j = str2;
            FieldAccessQueryTracker.a(jsonParser, graphQLPostChannel, "id", graphQLPostChannel.B_(), 6, false);
            return true;
        } else if ("modified_time".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                j = jsonParser.F();
            }
            graphQLPostChannel.f12682k = j;
            FieldAccessQueryTracker.a(jsonParser, graphQLPostChannel, "modified_time", graphQLPostChannel.B_(), 7, false);
            return true;
        } else if ("privacy_scope".equals(str)) {
            GraphQLPrivacyScope a3;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a3 = GraphQLPrivacyScope__JsonHelper.m21033a(FieldAccessQueryTracker.a(jsonParser, "privacy_scope"));
            }
            graphQLPostChannel.f12683l = a3;
            FieldAccessQueryTracker.a(jsonParser, graphQLPostChannel, "privacy_scope", graphQLPostChannel.B_(), 8, true);
            return true;
        } else if ("title".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLTextWithEntities__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "title"));
            }
            graphQLPostChannel.f12684m = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLPostChannel, "title", graphQLPostChannel.B_(), 10, true);
            return true;
        } else if ("titleForSummary".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                r0 = GraphQLTextWithEntities__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "titleForSummary"));
            }
            graphQLPostChannel.f12685n = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLPostChannel, "titleForSummary", graphQLPostChannel.B_(), 11, true);
            return true;
        } else if (!"url".equals(str)) {
            return false;
        } else {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                str2 = jsonParser.o();
            }
            graphQLPostChannel.f12686o = str2;
            FieldAccessQueryTracker.a(jsonParser, graphQLPostChannel, "url", graphQLPostChannel.B_(), 12, false);
            return true;
        }
    }
}
