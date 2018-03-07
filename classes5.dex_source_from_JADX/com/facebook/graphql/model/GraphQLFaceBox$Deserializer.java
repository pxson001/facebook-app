package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.deserializers.GraphQLFaceBoxDeserializer;
import com.facebook.graphql.modelutil.BaseModel;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: i_am_faceweb */
public class GraphQLFaceBox$Deserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLFaceBox.class, new GraphQLFaceBox$Deserializer());
    }

    public Object m7432a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        MutableFlatBuffer a = GraphQLFaceBoxDeserializer.m4871a(jsonParser, (short) 84);
        Object graphQLFaceBox = new GraphQLFaceBox();
        ((BaseModel) graphQLFaceBox).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
        if (graphQLFaceBox instanceof Postprocessable) {
            return ((Postprocessable) graphQLFaceBox).a();
        }
        return graphQLFaceBox;
    }
}
