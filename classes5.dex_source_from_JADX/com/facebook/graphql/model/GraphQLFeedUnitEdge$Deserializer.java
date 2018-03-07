package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.deserializers.GraphQLFeedUnitEdgeDeserializer;
import com.facebook.graphql.modelutil.BaseModel;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: hookRun */
public class GraphQLFeedUnitEdge$Deserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLFeedUnitEdge.class, new GraphQLFeedUnitEdge$Deserializer());
    }

    public Object m7467a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        MutableFlatBuffer a = GraphQLFeedUnitEdgeDeserializer.m4886a(jsonParser, (short) 409);
        Object graphQLFeedUnitEdge = new GraphQLFeedUnitEdge();
        ((BaseModel) graphQLFeedUnitEdge).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
        if (graphQLFeedUnitEdge instanceof Postprocessable) {
            return ((Postprocessable) graphQLFeedUnitEdge).a();
        }
        return graphQLFeedUnitEdge;
    }
}
