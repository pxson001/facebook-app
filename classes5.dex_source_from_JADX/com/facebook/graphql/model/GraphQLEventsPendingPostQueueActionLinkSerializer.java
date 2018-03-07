package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: image320 */
public class GraphQLEventsPendingPostQueueActionLinkSerializer extends JsonSerializer<GraphQLEventsPendingPostQueueActionLink> {
    public final void m7367a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLEventsPendingPostQueueActionLink graphQLEventsPendingPostQueueActionLink = (GraphQLEventsPendingPostQueueActionLink) obj;
        if (1 != null) {
            jsonGenerator.f();
        }
        if (graphQLEventsPendingPostQueueActionLink.m7362a() != null) {
            jsonGenerator.a("event");
            GraphQLEvent__JsonHelper.m7345a(jsonGenerator, graphQLEventsPendingPostQueueActionLink.m7362a(), true);
        }
        if (graphQLEventsPendingPostQueueActionLink.m7364j() != null) {
            jsonGenerator.a("title", graphQLEventsPendingPostQueueActionLink.m7364j());
        }
        if (graphQLEventsPendingPostQueueActionLink.m7365k() != null) {
            jsonGenerator.a("url", graphQLEventsPendingPostQueueActionLink.m7365k());
        }
        if (1 != null) {
            jsonGenerator.g();
        }
    }

    static {
        FbSerializerProvider.a(GraphQLEventsPendingPostQueueActionLink.class, new GraphQLEventsPendingPostQueueActionLinkSerializer());
    }
}
