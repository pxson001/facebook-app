package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.deserializers.GraphQLImageDeserializer;
import com.facebook.graphql.modelutil.BaseModel;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: follow_up_action_url */
public class GraphQLImage$Deserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLImage.class, new GraphQLImage$Deserializer());
    }

    public Object m8615a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        MutableFlatBuffer a = GraphQLImageDeserializer.a(jsonParser, (short) 5);
        Object graphQLImage = new GraphQLImage();
        ((BaseModel) graphQLImage).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
        if (graphQLImage instanceof Postprocessable) {
            return ((Postprocessable) graphQLImage).a();
        }
        return graphQLImage;
    }
}
