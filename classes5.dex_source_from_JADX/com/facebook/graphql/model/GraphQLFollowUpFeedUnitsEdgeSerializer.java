package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: hc_stream */
public class GraphQLFollowUpFeedUnitsEdgeSerializer extends JsonSerializer<GraphQLFollowUpFeedUnitsEdge> {
    public final void m7541a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLFollowUpFeedUnitsEdge__JsonHelper.m7543a(jsonGenerator, (GraphQLFollowUpFeedUnitsEdge) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLFollowUpFeedUnitsEdge.class, new GraphQLFollowUpFeedUnitsEdgeSerializer());
    }
}
