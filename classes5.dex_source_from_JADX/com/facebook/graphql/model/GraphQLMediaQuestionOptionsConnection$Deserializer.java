package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.deserializers.GraphQLMediaQuestionOptionsConnectionDeserializer;
import com.facebook.graphql.modelutil.BaseModel;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: fb4a_graphql_disk_cache_snapshot_table */
public class GraphQLMediaQuestionOptionsConnection$Deserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLMediaQuestionOptionsConnection.class, new GraphQLMediaQuestionOptionsConnection$Deserializer());
    }

    public Object m9045a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        MutableFlatBuffer a = GraphQLMediaQuestionOptionsConnectionDeserializer.m5350a(jsonParser, (short) 231);
        Object graphQLMediaQuestionOptionsConnection = new GraphQLMediaQuestionOptionsConnection();
        ((BaseModel) graphQLMediaQuestionOptionsConnection).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
        if (graphQLMediaQuestionOptionsConnection instanceof Postprocessable) {
            return ((Postprocessable) graphQLMediaQuestionOptionsConnection).a();
        }
        return graphQLMediaQuestionOptionsConnection;
    }
}
