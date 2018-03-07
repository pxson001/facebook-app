package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: event_gymk */
public class GraphQLNotifOptionRowDisplaySerializer extends JsonSerializer<GraphQLNotifOptionRowDisplay> {
    public final void m9356a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLNotifOptionRowDisplay graphQLNotifOptionRowDisplay = (GraphQLNotifOptionRowDisplay) obj;
        if (1 != null) {
            jsonGenerator.f();
        }
        if (graphQLNotifOptionRowDisplay.m9344a() != null) {
            jsonGenerator.a("__type__");
            jsonGenerator.f();
            jsonGenerator.a("name", graphQLNotifOptionRowDisplay.m9344a().e());
            jsonGenerator.g();
        }
        if (graphQLNotifOptionRowDisplay.m9346j() != null) {
            jsonGenerator.a("bg_color", graphQLNotifOptionRowDisplay.m9346j());
        }
        if (graphQLNotifOptionRowDisplay.m9347k() != null) {
            jsonGenerator.a("image_glyph", graphQLNotifOptionRowDisplay.m9347k());
        }
        if (graphQLNotifOptionRowDisplay.m9348l() != null) {
            jsonGenerator.a("image_source");
            GraphQLImage__JsonHelper.a(jsonGenerator, graphQLNotifOptionRowDisplay.m9348l(), true);
        }
        if (graphQLNotifOptionRowDisplay.m9349m() != null) {
            jsonGenerator.a("style", graphQLNotifOptionRowDisplay.m9349m().toString());
        }
        if (graphQLNotifOptionRowDisplay.m9350n() != null) {
            jsonGenerator.a("subtext");
            GraphQLTextWithEntities__JsonHelper.a(jsonGenerator, graphQLNotifOptionRowDisplay.m9350n(), true);
        }
        if (graphQLNotifOptionRowDisplay.m9351o() != null) {
            jsonGenerator.a("tertiary_text");
            GraphQLTextWithEntities__JsonHelper.a(jsonGenerator, graphQLNotifOptionRowDisplay.m9351o(), true);
        }
        if (graphQLNotifOptionRowDisplay.m9352p() != null) {
            jsonGenerator.a("tertiary_text_color", graphQLNotifOptionRowDisplay.m9352p());
        }
        if (graphQLNotifOptionRowDisplay.m9353q() != null) {
            jsonGenerator.a("text");
            GraphQLTextWithEntities__JsonHelper.a(jsonGenerator, graphQLNotifOptionRowDisplay.m9353q(), true);
        }
        if (graphQLNotifOptionRowDisplay.m9354r() != null) {
            jsonGenerator.a("undo_text");
            GraphQLTextWithEntities__JsonHelper.a(jsonGenerator, graphQLNotifOptionRowDisplay.m9354r(), true);
        }
        if (1 != null) {
            jsonGenerator.g();
        }
    }

    static {
        FbSerializerProvider.a(GraphQLNotifOptionRowDisplay.class, new GraphQLNotifOptionRowDisplaySerializer());
    }
}
