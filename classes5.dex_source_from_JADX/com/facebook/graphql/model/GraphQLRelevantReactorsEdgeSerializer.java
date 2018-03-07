package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: VIDEO_HOME_SEE_MORE */
public class GraphQLRelevantReactorsEdgeSerializer extends JsonSerializer<GraphQLRelevantReactorsEdge> {
    public final void m21396a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLRelevantReactorsEdge__JsonHelper.m21398a(jsonGenerator, (GraphQLRelevantReactorsEdge) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLRelevantReactorsEdge.class, new GraphQLRelevantReactorsEdgeSerializer());
    }
}
