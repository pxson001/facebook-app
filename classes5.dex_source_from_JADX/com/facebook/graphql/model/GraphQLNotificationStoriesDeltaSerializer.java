package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: event_create */
public class GraphQLNotificationStoriesDeltaSerializer extends JsonSerializer<GraphQLNotificationStoriesDelta> {
    public final void m9369a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLNotificationStoriesDelta graphQLNotificationStoriesDelta = (GraphQLNotificationStoriesDelta) obj;
        if (1 != null) {
            jsonGenerator.f();
        }
        if (graphQLNotificationStoriesDelta.m9364a() != null) {
            jsonGenerator.a("modified_edge");
            GraphQLNotificationStoriesEdge__JsonHelper.m9390a(jsonGenerator, graphQLNotificationStoriesDelta.m9364a(), true);
        }
        if (graphQLNotificationStoriesDelta.m9366j() != null) {
            jsonGenerator.a("removed", graphQLNotificationStoriesDelta.m9366j());
        }
        if (graphQLNotificationStoriesDelta.m9367k() != null) {
            jsonGenerator.a("unchanged", graphQLNotificationStoriesDelta.m9367k());
        }
        if (1 != null) {
            jsonGenerator.g();
        }
    }

    static {
        FbSerializerProvider.a(GraphQLNotificationStoriesDelta.class, new GraphQLNotificationStoriesDeltaSerializer());
    }
}
