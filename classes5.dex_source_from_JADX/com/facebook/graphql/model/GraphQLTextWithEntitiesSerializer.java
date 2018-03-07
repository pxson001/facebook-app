package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: UNLIKE_PAGE */
public class GraphQLTextWithEntitiesSerializer extends JsonSerializer<GraphQLTextWithEntities> {
    public final void m22109a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLTextWithEntities__JsonHelper.a(jsonGenerator, (GraphQLTextWithEntities) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLTextWithEntities.class, new GraphQLTextWithEntitiesSerializer());
    }
}
