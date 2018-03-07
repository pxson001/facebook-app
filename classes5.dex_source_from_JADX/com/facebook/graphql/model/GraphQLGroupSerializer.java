package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: friendEventMembersFirst5 */
public class GraphQLGroupSerializer extends JsonSerializer<GraphQLGroup> {
    public final void m8493a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLGroup__JsonHelper.m8519a(jsonGenerator, (GraphQLGroup) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLGroup.class, new GraphQLGroupSerializer());
    }
}
