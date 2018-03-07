package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.facebook.graphql.deserializers.GraphQLLeadGenErrorNodeDeserializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: feed_story_search */
public final class GraphQLLeadGenErrorNode$Serializer extends JsonSerializer<GraphQLLeadGenErrorNode> {
    public final void m8830a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLLeadGenErrorNode graphQLLeadGenErrorNode = (GraphQLLeadGenErrorNode) obj;
        GraphQLLeadGenErrorNodeDeserializer.m5291a(graphQLLeadGenErrorNode.w_(), graphQLLeadGenErrorNode.u_(), jsonGenerator);
    }

    static {
        FbSerializerProvider.a(GraphQLLeadGenErrorNode.class, new GraphQLLeadGenErrorNode$Serializer());
        FbSerializerProvider.a(GraphQLLeadGenErrorNode.class, new GraphQLLeadGenErrorNode$Serializer());
    }
}
