package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: imageThumbnail */
public class GraphQLEventViewActionLinkSerializer extends JsonSerializer<GraphQLEventViewActionLink> {
    public final void m7320a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLEventViewActionLink graphQLEventViewActionLink = (GraphQLEventViewActionLink) obj;
        if (1 != null) {
            jsonGenerator.f();
        }
        if (graphQLEventViewActionLink.m7315a() != null) {
            jsonGenerator.a("event");
            GraphQLEvent__JsonHelper.m7345a(jsonGenerator, graphQLEventViewActionLink.m7315a(), true);
        }
        if (graphQLEventViewActionLink.m7317j() != null) {
            jsonGenerator.a("title", graphQLEventViewActionLink.m7317j());
        }
        if (graphQLEventViewActionLink.m7318k() != null) {
            jsonGenerator.a("url", graphQLEventViewActionLink.m7318k());
        }
        if (1 != null) {
            jsonGenerator.g();
        }
    }

    static {
        FbSerializerProvider.a(GraphQLEventViewActionLink.class, new GraphQLEventViewActionLinkSerializer());
    }
}
