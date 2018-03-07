package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.facebook.graphql.deserializers.GraphQLVideoAnnotationDeserializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: TimelineAppCollection */
public final class GraphQLVideoAnnotation$Serializer extends JsonSerializer<GraphQLVideoAnnotation> {
    public final void m22426a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLVideoAnnotation graphQLVideoAnnotation = (GraphQLVideoAnnotation) obj;
        GraphQLVideoAnnotationDeserializer.m6170a(graphQLVideoAnnotation.w_(), graphQLVideoAnnotation.u_(), jsonGenerator);
    }

    static {
        FbSerializerProvider.a(GraphQLVideoAnnotation.class, new GraphQLVideoAnnotation$Serializer());
        FbSerializerProvider.a(GraphQLVideoAnnotation.class, new GraphQLVideoAnnotation$Serializer());
    }
}
