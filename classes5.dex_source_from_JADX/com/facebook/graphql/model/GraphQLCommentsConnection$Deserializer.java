package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.deserializers.GraphQLCommentsConnectionDeserializer;
import com.facebook.graphql.modelutil.BaseModel;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: is_album_attachment */
public class GraphQLCommentsConnection$Deserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLCommentsConnection.class, new GraphQLCommentsConnection$Deserializer());
    }

    public Object m6815a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        MutableFlatBuffer a = GraphQLCommentsConnectionDeserializer.m4666a(jsonParser, (short) 271);
        Object graphQLCommentsConnection = new GraphQLCommentsConnection();
        ((BaseModel) graphQLCommentsConnection).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
        if (graphQLCommentsConnection instanceof Postprocessable) {
            return ((Postprocessable) graphQLCommentsConnection).a();
        }
        return graphQLCommentsConnection;
    }
}
