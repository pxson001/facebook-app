package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: inline_style */
public class GraphQLEventCreateActionLinkSerializer extends JsonSerializer<GraphQLEventCreateActionLink> {
    public final void m7163a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLEventCreateActionLink graphQLEventCreateActionLink = (GraphQLEventCreateActionLink) obj;
        if (1 != null) {
            jsonGenerator.f();
        }
        if (graphQLEventCreateActionLink.m7158a() != null) {
            jsonGenerator.a("temporal_event_info");
            GraphQLTemporalEventInfo__JsonHelper.m22104a(jsonGenerator, graphQLEventCreateActionLink.m7158a(), true);
        }
        if (graphQLEventCreateActionLink.m7160j() != null) {
            jsonGenerator.a("title", graphQLEventCreateActionLink.m7160j());
        }
        if (graphQLEventCreateActionLink.m7161k() != null) {
            jsonGenerator.a("url", graphQLEventCreateActionLink.m7161k());
        }
        if (1 != null) {
            jsonGenerator.g();
        }
    }

    static {
        FbSerializerProvider.a(GraphQLEventCreateActionLink.class, new GraphQLEventCreateActionLinkSerializer());
    }
}
