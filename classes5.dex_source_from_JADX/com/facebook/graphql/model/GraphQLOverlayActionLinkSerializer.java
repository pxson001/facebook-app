package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: eventCategoryLabel */
public class GraphQLOverlayActionLinkSerializer extends JsonSerializer<GraphQLOverlayActionLink> {
    public final void m9421a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLOverlayActionLink graphQLOverlayActionLink = (GraphQLOverlayActionLink) obj;
        if (1 != null) {
            jsonGenerator.f();
        }
        if (graphQLOverlayActionLink.m9415a() != null) {
            jsonGenerator.a("description");
            GraphQLTextWithEntities__JsonHelper.a(jsonGenerator, graphQLOverlayActionLink.m9415a(), true);
        }
        if (graphQLOverlayActionLink.m9417j() != null) {
            jsonGenerator.a("info");
            GraphQLOverlayCallToActionInfo__JsonHelper.m9428a(jsonGenerator, graphQLOverlayActionLink.m9417j(), true);
        }
        if (graphQLOverlayActionLink.m9418k() != null) {
            jsonGenerator.a("title", graphQLOverlayActionLink.m9418k());
        }
        if (graphQLOverlayActionLink.m9419l() != null) {
            jsonGenerator.a("url", graphQLOverlayActionLink.m9419l());
        }
        if (1 != null) {
            jsonGenerator.g();
        }
    }

    static {
        FbSerializerProvider.a(GraphQLOverlayActionLink.class, new GraphQLOverlayActionLinkSerializer());
    }
}
