package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.deserializers.GraphQLDocumentElementDeserializer;
import com.facebook.graphql.modelutil.BaseModel;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: ios_place_creation_old_source */
public class GraphQLDocumentElement$Deserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLDocumentElement.class, new GraphQLDocumentElement$Deserializer());
    }

    public Object m6950a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        MutableFlatBuffer a = GraphQLDocumentElementDeserializer.m4716a(jsonParser, (short) 561);
        Object graphQLDocumentElement = new GraphQLDocumentElement();
        ((BaseModel) graphQLDocumentElement).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
        if (graphQLDocumentElement instanceof Postprocessable) {
            return ((Postprocessable) graphQLDocumentElement).a();
        }
        return graphQLDocumentElement;
    }
}
