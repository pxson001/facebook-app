package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.deserializers.GraphQLResharesOfContentConnectionDeserializer;
import com.facebook.graphql.modelutil.BaseModel;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: VIDEO_CHANNEL */
public class GraphQLResharesOfContentConnection$Deserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLResharesOfContentConnection.class, new GraphQLResharesOfContentConnection$Deserializer());
    }

    public Object m21500a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        MutableFlatBuffer a = GraphQLResharesOfContentConnectionDeserializer.m5840a(jsonParser, (short) 216);
        Object graphQLResharesOfContentConnection = new GraphQLResharesOfContentConnection();
        ((BaseModel) graphQLResharesOfContentConnection).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
        if (graphQLResharesOfContentConnection instanceof Postprocessable) {
            return ((Postprocessable) graphQLResharesOfContentConnection).a();
        }
        return graphQLResharesOfContentConnection;
    }
}
