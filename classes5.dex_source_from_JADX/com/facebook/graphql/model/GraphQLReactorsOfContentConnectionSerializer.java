package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: VIDEO_UNMUTED_FORCED */
public class GraphQLReactorsOfContentConnectionSerializer extends JsonSerializer<GraphQLReactorsOfContentConnection> {
    public final void m21346a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLReactorsOfContentConnection__JsonHelper.a(jsonGenerator, (GraphQLReactorsOfContentConnection) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLReactorsOfContentConnection.class, new GraphQLReactorsOfContentConnectionSerializer());
    }
}
