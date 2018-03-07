package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: Voice Clips */
public class GraphQLPostChannelSerializer extends JsonSerializer<GraphQLPostChannel> {
    public final void m20964a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLPostChannel graphQLPostChannel = (GraphQLPostChannel) obj;
        if (1 != null) {
            jsonGenerator.f();
        }
        if (graphQLPostChannel.m20951j() != null) {
            jsonGenerator.a("blurredCoverPhoto");
            GraphQLFocusedPhoto__JsonHelper.m7527a(jsonGenerator, graphQLPostChannel.m20951j(), true);
        }
        jsonGenerator.a("can_viewer_delete", graphQLPostChannel.m20952k());
        jsonGenerator.a("can_viewer_edit", graphQLPostChannel.m20953l());
        if (graphQLPostChannel.m20954m() != null) {
            jsonGenerator.a("cover_photo");
            GraphQLFocusedPhoto__JsonHelper.m7527a(jsonGenerator, graphQLPostChannel.m20954m(), true);
        }
        jsonGenerator.a("creation_time", graphQLPostChannel.m20955n());
        if (graphQLPostChannel.m20956o() != null) {
            jsonGenerator.a("feedback");
            GraphQLFeedback__JsonHelper.a(jsonGenerator, graphQLPostChannel.m20956o(), true);
        }
        if (graphQLPostChannel.m20957p() != null) {
            jsonGenerator.a("id", graphQLPostChannel.m20957p());
        }
        jsonGenerator.a("modified_time", graphQLPostChannel.m20958q());
        if (graphQLPostChannel.m20959r() != null) {
            jsonGenerator.a("privacy_scope");
            GraphQLPrivacyScope__JsonHelper.m21034a(jsonGenerator, graphQLPostChannel.m20959r(), true);
        }
        if (graphQLPostChannel.m20960s() != null) {
            jsonGenerator.a("title");
            GraphQLTextWithEntities__JsonHelper.a(jsonGenerator, graphQLPostChannel.m20960s(), true);
        }
        if (graphQLPostChannel.m20961t() != null) {
            jsonGenerator.a("titleForSummary");
            GraphQLTextWithEntities__JsonHelper.a(jsonGenerator, graphQLPostChannel.m20961t(), true);
        }
        if (graphQLPostChannel.m20962u() != null) {
            jsonGenerator.a("url", graphQLPostChannel.m20962u());
        }
        if (1 != null) {
            jsonGenerator.g();
        }
    }

    static {
        FbSerializerProvider.a(GraphQLPostChannel.class, new GraphQLPostChannelSerializer());
    }
}
