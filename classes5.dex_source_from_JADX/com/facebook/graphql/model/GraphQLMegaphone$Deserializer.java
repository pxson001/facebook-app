package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.deserializers.GraphQLMegaphoneDeserializer;
import com.facebook.graphql.modelutil.BaseModel;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: failed_status */
public class GraphQLMegaphone$Deserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLMegaphone.class, new GraphQLMegaphone$Deserializer());
    }

    public Object m9087a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        MutableFlatBuffer a = GraphQLMegaphoneDeserializer.m5365a(jsonParser, (short) 421);
        Object graphQLMegaphone = new GraphQLMegaphone();
        ((BaseModel) graphQLMegaphone).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
        if (graphQLMegaphone instanceof Postprocessable) {
            return ((Postprocessable) graphQLMegaphone).a();
        }
        return graphQLMegaphone;
    }
}
