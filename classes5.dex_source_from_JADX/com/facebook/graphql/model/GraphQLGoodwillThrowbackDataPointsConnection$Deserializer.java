package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.deserializers.GraphQLGoodwillThrowbackDataPointsConnectionDeserializer;
import com.facebook.graphql.modelutil.BaseModel;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: google.message_id */
public class GraphQLGoodwillThrowbackDataPointsConnection$Deserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLGoodwillThrowbackDataPointsConnection.class, new GraphQLGoodwillThrowbackDataPointsConnection$Deserializer());
    }

    public Object m7936a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        MutableFlatBuffer a = GraphQLGoodwillThrowbackDataPointsConnectionDeserializer.m5030a(jsonParser, (short) 234);
        Object graphQLGoodwillThrowbackDataPointsConnection = new GraphQLGoodwillThrowbackDataPointsConnection();
        ((BaseModel) graphQLGoodwillThrowbackDataPointsConnection).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
        if (graphQLGoodwillThrowbackDataPointsConnection instanceof Postprocessable) {
            return ((Postprocessable) graphQLGoodwillThrowbackDataPointsConnection).a();
        }
        return graphQLGoodwillThrowbackDataPointsConnection;
    }
}
