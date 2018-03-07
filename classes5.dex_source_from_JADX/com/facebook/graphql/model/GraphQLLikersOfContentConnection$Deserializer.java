package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.deserializers.GraphQLLikersOfContentConnectionDeserializer;
import com.facebook.graphql.modelutil.BaseModel;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: featured_video_attachments */
public class GraphQLLikersOfContentConnection$Deserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLLikersOfContentConnection.class, new GraphQLLikersOfContentConnection$Deserializer());
    }

    public Object m8916a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        MutableFlatBuffer a = GraphQLLikersOfContentConnectionDeserializer.m5319a(jsonParser, (short) 215);
        Object graphQLLikersOfContentConnection = new GraphQLLikersOfContentConnection();
        ((BaseModel) graphQLLikersOfContentConnection).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
        if (graphQLLikersOfContentConnection instanceof Postprocessable) {
            return ((Postprocessable) graphQLLikersOfContentConnection).a();
        }
        return graphQLLikersOfContentConnection;
    }
}
