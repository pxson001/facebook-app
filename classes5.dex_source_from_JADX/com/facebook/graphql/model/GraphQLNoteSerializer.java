package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: event_maybes */
public class GraphQLNoteSerializer extends JsonSerializer<GraphQLNote> {
    public final void m9328a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLNote graphQLNote = (GraphQLNote) obj;
        if (1 != null) {
            jsonGenerator.f();
        }
        if (graphQLNote.m9310j() != null) {
            jsonGenerator.a("blurredCoverPhoto");
            GraphQLFocusedPhoto__JsonHelper.m7527a(jsonGenerator, graphQLNote.m9310j(), true);
        }
        if (graphQLNote.m9311k() != null) {
            jsonGenerator.a("cover_photo");
            GraphQLFocusedPhoto__JsonHelper.m7527a(jsonGenerator, graphQLNote.m9311k(), true);
        }
        jsonGenerator.a("created_time", graphQLNote.m9312l());
        if (graphQLNote.m9313m() != null) {
            jsonGenerator.a("feedback");
            GraphQLFeedback__JsonHelper.a(jsonGenerator, graphQLNote.m9313m(), true);
        }
        if (graphQLNote.m9314n() != null) {
            jsonGenerator.a("id", graphQLNote.m9314n());
        }
        if (graphQLNote.m9315o() != null) {
            jsonGenerator.a("plain_body", graphQLNote.m9315o());
        }
        if (graphQLNote.m9316p() != null) {
            jsonGenerator.a("privacy_scope");
            GraphQLPrivacyScope__JsonHelper.m21034a(jsonGenerator, graphQLNote.m9316p(), true);
        }
        if (graphQLNote.m9317q() != null) {
            jsonGenerator.a("published_document");
            GraphQLComposedDocument__JsonHelper.m6839a(jsonGenerator, graphQLNote.m9317q(), true);
        }
        if (graphQLNote.m9318r() != null) {
            jsonGenerator.a("subject", graphQLNote.m9318r());
        }
        if (graphQLNote.m9319s() != null) {
            jsonGenerator.a("url", graphQLNote.m9319s());
        }
        if (graphQLNote.m9320t() != null) {
            jsonGenerator.a("from");
            GraphQLActor__JsonHelper.a(jsonGenerator, graphQLNote.m9320t(), true);
        }
        if (graphQLNote.m9321u() != null) {
            jsonGenerator.a("feedAwesomizerProfilePicture");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLNote.m9321u(), true);
        }
        if (graphQLNote.m9322v() != null) {
            jsonGenerator.a("imageHighOrig");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLNote.m9322v(), true);
        }
        if (graphQLNote.m9323w() != null) {
            jsonGenerator.a("inline_activities");
            GraphQLInlineActivitiesConnection__JsonHelper.m8690a(jsonGenerator, graphQLNote.m9323w(), true);
        }
        if (graphQLNote.m9324x() != null) {
            jsonGenerator.a("name", graphQLNote.m9324x());
        }
        if (graphQLNote.m9325y() != null) {
            jsonGenerator.a("profileImageLarge");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLNote.m9325y(), true);
        }
        if (graphQLNote.m9326z() != null) {
            jsonGenerator.a("profileImageSmall");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLNote.m9326z(), true);
        }
        if (graphQLNote.m9297A() != null) {
            jsonGenerator.a("profilePicture50");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLNote.m9297A(), true);
        }
        if (graphQLNote.m9298B() != null) {
            jsonGenerator.a("profilePictureHighRes");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLNote.m9298B(), true);
        }
        if (graphQLNote.m9299C() != null) {
            jsonGenerator.a("profilePictureLarge");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLNote.m9299C(), true);
        }
        if (graphQLNote.m9300D() != null) {
            jsonGenerator.a("profile_photo");
            GraphQLPhoto__JsonHelper.m20765a(jsonGenerator, graphQLNote.m9300D(), true);
        }
        if (graphQLNote.m9301E() != null) {
            jsonGenerator.a("profile_picture");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLNote.m9301E(), true);
        }
        jsonGenerator.a("profile_picture_is_silhouette", graphQLNote.m9302F());
        if (graphQLNote.m9303G() != null) {
            jsonGenerator.a("streaming_profile_picture");
            GraphQLStreamingImage__JsonHelper.m21930a(jsonGenerator, graphQLNote.m9303G(), true);
        }
        if (graphQLNote.m9304H() != null) {
            jsonGenerator.a("taggable_object_profile_picture");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLNote.m9304H(), true);
        }
        if (graphQLNote.m9305I() != null) {
            jsonGenerator.a("viewer_saved_state", graphQLNote.m9305I().toString());
        }
        if (1 != null) {
            jsonGenerator.g();
        }
    }

    static {
        FbSerializerProvider.a(GraphQLNote.class, new GraphQLNoteSerializer());
    }
}
