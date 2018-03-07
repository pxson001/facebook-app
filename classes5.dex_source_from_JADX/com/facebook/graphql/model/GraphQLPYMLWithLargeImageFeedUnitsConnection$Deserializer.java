package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.deserializers.GraphQLPYMLWithLargeImageFeedUnitsConnectionDeserializer;
import com.facebook.graphql.modelutil.BaseModel;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: error changing cursor and caching columns */
public class GraphQLPYMLWithLargeImageFeedUnitsConnection$Deserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLPYMLWithLargeImageFeedUnitsConnection.class, new GraphQLPYMLWithLargeImageFeedUnitsConnection$Deserializer());
    }

    public Object m9448a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        MutableFlatBuffer a = GraphQLPYMLWithLargeImageFeedUnitsConnectionDeserializer.m5487a(jsonParser, (short) 266);
        Object graphQLPYMLWithLargeImageFeedUnitsConnection = new GraphQLPYMLWithLargeImageFeedUnitsConnection();
        ((BaseModel) graphQLPYMLWithLargeImageFeedUnitsConnection).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
        if (graphQLPYMLWithLargeImageFeedUnitsConnection instanceof Postprocessable) {
            return ((Postprocessable) graphQLPYMLWithLargeImageFeedUnitsConnection).a();
        }
        return graphQLPYMLWithLargeImageFeedUnitsConnection;
    }
}
