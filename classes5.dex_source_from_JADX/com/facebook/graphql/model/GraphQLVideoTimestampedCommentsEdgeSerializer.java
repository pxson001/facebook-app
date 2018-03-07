package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: TestCampaign */
public class GraphQLVideoTimestampedCommentsEdgeSerializer extends JsonSerializer<GraphQLVideoTimestampedCommentsEdge> {
    public final void m22480a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLVideoTimestampedCommentsEdge__JsonHelper.m22482a(jsonGenerator, (GraphQLVideoTimestampedCommentsEdge) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLVideoTimestampedCommentsEdge.class, new GraphQLVideoTimestampedCommentsEdgeSerializer());
    }
}
