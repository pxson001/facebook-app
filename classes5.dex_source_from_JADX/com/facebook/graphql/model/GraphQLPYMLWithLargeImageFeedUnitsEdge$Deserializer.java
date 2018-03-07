package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.deserializers.GraphQLPYMLWithLargeImageFeedUnitsEdgeDeserializer;
import com.facebook.graphql.modelutil.BaseModel;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: entry_point_description */
public class GraphQLPYMLWithLargeImageFeedUnitsEdge$Deserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLPYMLWithLargeImageFeedUnitsEdge.class, new GraphQLPYMLWithLargeImageFeedUnitsEdge$Deserializer());
    }

    public Object m9454a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        MutableFlatBuffer a = GraphQLPYMLWithLargeImageFeedUnitsEdgeDeserializer.m5490a(jsonParser, (short) 267);
        Object graphQLPYMLWithLargeImageFeedUnitsEdge = new GraphQLPYMLWithLargeImageFeedUnitsEdge();
        ((BaseModel) graphQLPYMLWithLargeImageFeedUnitsEdge).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
        if (graphQLPYMLWithLargeImageFeedUnitsEdge instanceof Postprocessable) {
            return ((Postprocessable) graphQLPYMLWithLargeImageFeedUnitsEdge).a();
        }
        return graphQLPYMLWithLargeImageFeedUnitsEdge;
    }
}
