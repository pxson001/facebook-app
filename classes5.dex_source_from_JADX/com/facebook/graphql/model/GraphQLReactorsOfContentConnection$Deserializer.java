package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.deserializers.GraphQLReactorsOfContentConnectionDeserializer;
import com.facebook.graphql.modelutil.BaseModel;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: VIDEO_VIEWS */
public class GraphQLReactorsOfContentConnection$Deserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLReactorsOfContentConnection.class, new GraphQLReactorsOfContentConnection$Deserializer());
    }

    public Object m21343a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        MutableFlatBuffer a = GraphQLReactorsOfContentConnectionDeserializer.m5788a(jsonParser, (short) 209);
        Object graphQLReactorsOfContentConnection = new GraphQLReactorsOfContentConnection();
        ((BaseModel) graphQLReactorsOfContentConnection).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
        if (graphQLReactorsOfContentConnection instanceof Postprocessable) {
            return ((Postprocessable) graphQLReactorsOfContentConnection).a();
        }
        return graphQLReactorsOfContentConnection;
    }
}
