package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.deserializers.GraphQLGraphSearchQueryFilterValuesConnectionDeserializer;
import com.facebook.graphql.modelutil.BaseModel;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: games_pyml */
public class GraphQLGraphSearchQueryFilterValuesConnection$Deserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLGraphSearchQueryFilterValuesConnection.class, new GraphQLGraphSearchQueryFilterValuesConnection$Deserializer());
    }

    public Object m8249a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        MutableFlatBuffer a = GraphQLGraphSearchQueryFilterValuesConnectionDeserializer.m5101a(jsonParser, (short) 474);
        Object graphQLGraphSearchQueryFilterValuesConnection = new GraphQLGraphSearchQueryFilterValuesConnection();
        ((BaseModel) graphQLGraphSearchQueryFilterValuesConnection).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
        if (graphQLGraphSearchQueryFilterValuesConnection instanceof Postprocessable) {
            return ((Postprocessable) graphQLGraphSearchQueryFilterValuesConnection).a();
        }
        return graphQLGraphSearchQueryFilterValuesConnection;
    }
}
