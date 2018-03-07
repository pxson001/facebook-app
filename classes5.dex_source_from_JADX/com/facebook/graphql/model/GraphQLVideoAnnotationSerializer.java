package com.facebook.graphql.model;

import com.facebook.common.json.FbSerializerProvider;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* compiled from: Timed_Out_Attachments */
public class GraphQLVideoAnnotationSerializer extends JsonSerializer<GraphQLVideoAnnotation> {
    public final void m22428a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GraphQLVideoAnnotation__JsonHelper.m22430a(jsonGenerator, (GraphQLVideoAnnotation) obj, true);
    }

    static {
        FbSerializerProvider.a(GraphQLVideoAnnotation.class, new GraphQLVideoAnnotationSerializer());
    }
}
