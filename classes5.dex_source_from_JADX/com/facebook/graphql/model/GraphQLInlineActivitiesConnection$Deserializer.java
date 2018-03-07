package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.deserializers.GraphQLInlineActivitiesConnectionDeserializer;
import com.facebook.graphql.modelutil.BaseModel;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: first_question */
public class GraphQLInlineActivitiesConnection$Deserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLInlineActivitiesConnection.class, new GraphQLInlineActivitiesConnection$Deserializer());
    }

    public Object m8685a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        MutableFlatBuffer a = GraphQLInlineActivitiesConnectionDeserializer.m5245a(jsonParser, (short) 199);
        Object graphQLInlineActivitiesConnection = new GraphQLInlineActivitiesConnection();
        ((BaseModel) graphQLInlineActivitiesConnection).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
        if (graphQLInlineActivitiesConnection instanceof Postprocessable) {
            return ((Postprocessable) graphQLInlineActivitiesConnection).a();
        }
        return graphQLInlineActivitiesConnection;
    }
}
