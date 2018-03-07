package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: Total wakelock power */
public class GraphQLTrueTopicFeedOptionsEdgeSerializer extends JsonSerializer<GraphQLTrueTopicFeedOptionsEdge> {
    public final void m22336a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLTrueTopicFeedOptionsEdge__JsonHelper.m22338a(jsonGenerator, (GraphQLTrueTopicFeedOptionsEdge) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLTrueTopicFeedOptionsEdge.class, new GraphQLTrueTopicFeedOptionsEdgeSerializer());
    }
}
