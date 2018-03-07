package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.deserializers.GraphQLPostedPhotosConnectionDeserializer;
import com.facebook.graphql.modelutil.BaseModel;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: ViewerReactionsMutation */
public class GraphQLPostedPhotosConnection$Deserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLPostedPhotosConnection.class, new GraphQLPostedPhotosConnection$Deserializer());
    }

    public Object m20970a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        MutableFlatBuffer a = GraphQLPostedPhotosConnectionDeserializer.m5686a(jsonParser, (short) 452);
        Object graphQLPostedPhotosConnection = new GraphQLPostedPhotosConnection();
        ((BaseModel) graphQLPostedPhotosConnection).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
        if (graphQLPostedPhotosConnection instanceof Postprocessable) {
            return ((Postprocessable) graphQLPostedPhotosConnection).a();
        }
        return graphQLPostedPhotosConnection;
    }
}
