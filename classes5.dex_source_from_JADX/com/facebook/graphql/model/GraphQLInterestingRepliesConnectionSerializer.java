package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: feedback_reaction_info */
public class GraphQLInterestingRepliesConnectionSerializer extends JsonSerializer<GraphQLInterestingRepliesConnection> {
    public final void m8750a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLInterestingRepliesConnection__JsonHelper.a(jsonGenerator, (GraphQLInterestingRepliesConnection) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLInterestingRepliesConnection.class, new GraphQLInterestingRepliesConnectionSerializer());
    }
}
