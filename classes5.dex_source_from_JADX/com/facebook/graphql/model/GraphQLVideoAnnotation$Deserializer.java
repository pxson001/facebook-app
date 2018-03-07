package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.deserializers.GraphQLVideoAnnotationDeserializer;
import com.facebook.graphql.modelutil.BaseModel;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: TimelineAppCollection */
public class GraphQLVideoAnnotation$Deserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLVideoAnnotation.class, new GraphQLVideoAnnotation$Deserializer());
    }

    public Object m22425a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        MutableFlatBuffer a = GraphQLVideoAnnotationDeserializer.m6169a(jsonParser, (short) 555);
        Object graphQLVideoAnnotation = new GraphQLVideoAnnotation();
        ((BaseModel) graphQLVideoAnnotation).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
        if (graphQLVideoAnnotation instanceof Postprocessable) {
            return ((Postprocessable) graphQLVideoAnnotation).a();
        }
        return graphQLVideoAnnotation;
    }
}
