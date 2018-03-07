package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.deserializers.GraphQLReactorsOfContentEdgeDeserializer;
import com.facebook.graphql.modelutil.BaseModel;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: VIDEO_STORIES */
public class GraphQLReactorsOfContentEdge$Deserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLReactorsOfContentEdge.class, new GraphQLReactorsOfContentEdge$Deserializer());
    }

    public Object m21348a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        MutableFlatBuffer a = GraphQLReactorsOfContentEdgeDeserializer.m5791a(jsonParser, (short) 283);
        Object graphQLReactorsOfContentEdge = new GraphQLReactorsOfContentEdge();
        ((BaseModel) graphQLReactorsOfContentEdge).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
        if (graphQLReactorsOfContentEdge instanceof Postprocessable) {
            return ((Postprocessable) graphQLReactorsOfContentEdge).a();
        }
        return graphQLReactorsOfContentEdge;
    }
}
