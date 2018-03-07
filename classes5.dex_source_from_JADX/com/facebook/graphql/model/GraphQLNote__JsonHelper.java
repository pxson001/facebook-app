package com.facebook.graphql.model;

import com.facebook.debug.fieldusage.FieldAccessQueryTracker;
import com.facebook.graphql.enums.GraphQLSavedState;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

/* compiled from: event_kind */
public final class GraphQLNote__JsonHelper {
    public static boolean m9329a(GraphQLNote graphQLNote, String str, JsonParser jsonParser) {
        GraphQLImage graphQLImage = null;
        GraphQLFocusedPhoto a;
        if ("blurredCoverPhoto".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a = GraphQLFocusedPhoto__JsonHelper.m7526a(FieldAccessQueryTracker.a(jsonParser, "blurredCoverPhoto"));
            }
            graphQLNote.f4617d = a;
            FieldAccessQueryTracker.a(jsonParser, graphQLNote, "blurredCoverPhoto", graphQLNote.a_, 0, true);
            return true;
        } else if ("cover_photo".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a = GraphQLFocusedPhoto__JsonHelper.m7526a(FieldAccessQueryTracker.a(jsonParser, "cover_photo"));
            }
            graphQLNote.f4618e = a;
            FieldAccessQueryTracker.a(jsonParser, graphQLNote, "cover_photo", graphQLNote.B_(), 1, true);
            return true;
        } else if ("created_time".equals(str)) {
            graphQLNote.f4619f = jsonParser.g() == JsonToken.VALUE_NULL ? 0 : jsonParser.F();
            FieldAccessQueryTracker.a(jsonParser, graphQLNote, "created_time", graphQLNote.B_(), 2, false);
            return true;
        } else if ("feedback".equals(str)) {
            GraphQLFeedback a2;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a2 = GraphQLFeedback__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "feedback"));
            }
            graphQLNote.f4620g = a2;
            FieldAccessQueryTracker.a(jsonParser, graphQLNote, "feedback", graphQLNote.B_(), 3, true);
            return true;
        } else if ("id".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                r0 = jsonParser.o();
            }
            graphQLNote.f4621h = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLNote, "id", graphQLNote.B_(), 4, false);
            return true;
        } else if ("plain_body".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                r0 = jsonParser.o();
            }
            graphQLNote.f4622i = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLNote, "plain_body", graphQLNote.B_(), 5, false);
            return true;
        } else if ("privacy_scope".equals(str)) {
            GraphQLPrivacyScope a3;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a3 = GraphQLPrivacyScope__JsonHelper.m21033a(FieldAccessQueryTracker.a(jsonParser, "privacy_scope"));
            }
            graphQLNote.f4623j = a3;
            FieldAccessQueryTracker.a(jsonParser, graphQLNote, "privacy_scope", graphQLNote.B_(), 6, true);
            return true;
        } else if ("published_document".equals(str)) {
            GraphQLComposedDocument a4;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a4 = GraphQLComposedDocument__JsonHelper.m6838a(FieldAccessQueryTracker.a(jsonParser, "published_document"));
            }
            graphQLNote.f4624k = a4;
            FieldAccessQueryTracker.a(jsonParser, graphQLNote, "published_document", graphQLNote.B_(), 7, true);
            return true;
        } else if ("subject".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                r0 = jsonParser.o();
            }
            graphQLNote.f4625l = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLNote, "subject", graphQLNote.B_(), 8, false);
            return true;
        } else if ("url".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                r0 = jsonParser.o();
            }
            graphQLNote.f4626m = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLNote, "url", graphQLNote.B_(), 9, false);
            return true;
        } else if ("from".equals(str)) {
            GraphQLActor a5;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a5 = GraphQLActor__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "from"));
            }
            graphQLNote.f4627n = a5;
            FieldAccessQueryTracker.a(jsonParser, graphQLNote, "from", graphQLNote.B_(), 10, true);
            return true;
        } else if ("feedAwesomizerProfilePicture".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                graphQLImage = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "feedAwesomizerProfilePicture"));
            }
            graphQLNote.f4628o = graphQLImage;
            FieldAccessQueryTracker.a(jsonParser, graphQLNote, "feedAwesomizerProfilePicture", graphQLNote.B_(), 11, true);
            return true;
        } else if ("imageHighOrig".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                graphQLImage = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "imageHighOrig"));
            }
            graphQLNote.f4629p = graphQLImage;
            FieldAccessQueryTracker.a(jsonParser, graphQLNote, "imageHighOrig", graphQLNote.B_(), 12, true);
            return true;
        } else if ("inline_activities".equals(str)) {
            GraphQLInlineActivitiesConnection a6;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a6 = GraphQLInlineActivitiesConnection__JsonHelper.m8689a(FieldAccessQueryTracker.a(jsonParser, "inline_activities"));
            }
            graphQLNote.f4630q = a6;
            FieldAccessQueryTracker.a(jsonParser, graphQLNote, "inline_activities", graphQLNote.B_(), 13, true);
            return true;
        } else if ("name".equals(str)) {
            if (!(jsonParser.g() == JsonToken.VALUE_NULL || jsonParser.g() == JsonToken.VALUE_NULL)) {
                r0 = jsonParser.o();
            }
            graphQLNote.f4631r = r0;
            FieldAccessQueryTracker.a(jsonParser, graphQLNote, "name", graphQLNote.B_(), 14, false);
            return true;
        } else if ("profileImageLarge".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                graphQLImage = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "profileImageLarge"));
            }
            graphQLNote.f4632s = graphQLImage;
            FieldAccessQueryTracker.a(jsonParser, graphQLNote, "profileImageLarge", graphQLNote.B_(), 15, true);
            return true;
        } else if ("profileImageSmall".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                graphQLImage = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "profileImageSmall"));
            }
            graphQLNote.f4633t = graphQLImage;
            FieldAccessQueryTracker.a(jsonParser, graphQLNote, "profileImageSmall", graphQLNote.B_(), 16, true);
            return true;
        } else if ("profilePicture50".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                graphQLImage = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "profilePicture50"));
            }
            graphQLNote.f4634u = graphQLImage;
            FieldAccessQueryTracker.a(jsonParser, graphQLNote, "profilePicture50", graphQLNote.B_(), 17, true);
            return true;
        } else if ("profilePictureHighRes".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                graphQLImage = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "profilePictureHighRes"));
            }
            graphQLNote.f4635v = graphQLImage;
            FieldAccessQueryTracker.a(jsonParser, graphQLNote, "profilePictureHighRes", graphQLNote.B_(), 18, true);
            return true;
        } else if ("profilePictureLarge".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                graphQLImage = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "profilePictureLarge"));
            }
            graphQLNote.f4636w = graphQLImage;
            FieldAccessQueryTracker.a(jsonParser, graphQLNote, "profilePictureLarge", graphQLNote.B_(), 19, true);
            return true;
        } else if ("profile_photo".equals(str)) {
            GraphQLPhoto a7;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a7 = GraphQLPhoto__JsonHelper.m20764a(FieldAccessQueryTracker.a(jsonParser, "profile_photo"));
            }
            graphQLNote.f4637x = a7;
            FieldAccessQueryTracker.a(jsonParser, graphQLNote, "profile_photo", graphQLNote.B_(), 20, true);
            return true;
        } else if ("profile_picture".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                graphQLImage = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "profile_picture"));
            }
            graphQLNote.f4638y = graphQLImage;
            FieldAccessQueryTracker.a(jsonParser, graphQLNote, "profile_picture", graphQLNote.B_(), 21, true);
            return true;
        } else if ("profile_picture_is_silhouette".equals(str)) {
            graphQLNote.f4639z = jsonParser.g() == JsonToken.VALUE_NULL ? false : jsonParser.H();
            FieldAccessQueryTracker.a(jsonParser, graphQLNote, "profile_picture_is_silhouette", graphQLNote.B_(), 22, false);
            return true;
        } else if ("streaming_profile_picture".equals(str)) {
            GraphQLStreamingImage a8;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                a8 = GraphQLStreamingImage__JsonHelper.m21929a(FieldAccessQueryTracker.a(jsonParser, "streaming_profile_picture"));
            }
            graphQLNote.f4614A = a8;
            FieldAccessQueryTracker.a(jsonParser, graphQLNote, "streaming_profile_picture", graphQLNote.B_(), 23, true);
            return true;
        } else if ("taggable_object_profile_picture".equals(str)) {
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                graphQLImage = GraphQLImage__JsonHelper.a(FieldAccessQueryTracker.a(jsonParser, "taggable_object_profile_picture"));
            }
            graphQLNote.f4615B = graphQLImage;
            FieldAccessQueryTracker.a(jsonParser, graphQLNote, "taggable_object_profile_picture", graphQLNote.B_(), 24, true);
            return true;
        } else if (!"viewer_saved_state".equals(str)) {
            return false;
        } else {
            graphQLNote.f4616C = GraphQLSavedState.fromString(jsonParser.o());
            FieldAccessQueryTracker.a(jsonParser, graphQLNote, "viewer_saved_state", graphQLNote.B_(), 25, false);
            return true;
        }
    }
}
