package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.deserializers.GraphQLAttachmentPropertyDeserializer;
import com.facebook.graphql.modelutil.BaseModel;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: is_selected */
public class GraphQLAttachmentProperty$Deserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLAttachmentProperty.class, new GraphQLAttachmentProperty$Deserializer());
    }

    public Object m6605a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        MutableFlatBuffer a = GraphQLAttachmentPropertyDeserializer.m4589a(jsonParser, (short) 207);
        Object graphQLAttachmentProperty = new GraphQLAttachmentProperty();
        ((BaseModel) graphQLAttachmentProperty).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
        if (graphQLAttachmentProperty instanceof Postprocessable) {
            return ((Postprocessable) graphQLAttachmentProperty).a();
        }
        return graphQLAttachmentProperty;
    }
}
