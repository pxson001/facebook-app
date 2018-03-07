package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: is_non_connected_page_post */
public class GraphQLBoostedComponentActionLinkSerializer extends JsonSerializer<GraphQLBoostedComponentActionLink> {
    public final void m6644a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLBoostedComponentActionLink graphQLBoostedComponentActionLink = (GraphQLBoostedComponentActionLink) obj;
        if (1 != null) {
            jsonGenerator.f();
        }
        if (graphQLBoostedComponentActionLink.m6640a() != null) {
            jsonGenerator.a("display_text");
            GraphQLTextWithEntities__JsonHelper.a(jsonGenerator, graphQLBoostedComponentActionLink.m6640a(), true);
        }
        if (graphQLBoostedComponentActionLink.m6642j() != null) {
            jsonGenerator.a("uri", graphQLBoostedComponentActionLink.m6642j());
        }
        if (1 != null) {
            jsonGenerator.g();
        }
    }

    static {
        FbSerializerProvider.a(GraphQLBoostedComponentActionLink.class, new GraphQLBoostedComponentActionLinkSerializer());
    }
}
