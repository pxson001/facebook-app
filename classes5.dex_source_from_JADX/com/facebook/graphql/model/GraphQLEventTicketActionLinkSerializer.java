package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: immediate_child_count */
public class GraphQLEventTicketActionLinkSerializer extends JsonSerializer<GraphQLEventTicketActionLink> {
    public final void m7291a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLEventTicketActionLink graphQLEventTicketActionLink = (GraphQLEventTicketActionLink) obj;
        if (1 != null) {
            jsonGenerator.f();
        }
        if (graphQLEventTicketActionLink.m7286a() != null) {
            jsonGenerator.a("event");
            GraphQLEvent__JsonHelper.m7345a(jsonGenerator, graphQLEventTicketActionLink.m7286a(), true);
        }
        if (graphQLEventTicketActionLink.m7288j() != null) {
            jsonGenerator.a("title", graphQLEventTicketActionLink.m7288j());
        }
        if (graphQLEventTicketActionLink.m7289k() != null) {
            jsonGenerator.a("url", graphQLEventTicketActionLink.m7289k());
        }
        if (1 != null) {
            jsonGenerator.g();
        }
    }

    static {
        FbSerializerProvider.a(GraphQLEventTicketActionLink.class, new GraphQLEventTicketActionLinkSerializer());
    }
}
