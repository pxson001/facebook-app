package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.deserializers.GraphQLEventsOccurringHereConnectionDeserializer;
import com.facebook.graphql.modelutil.BaseModel;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: imageLarge */
public class GraphQLEventsOccurringHereConnection$Deserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLEventsOccurringHereConnection.class, new GraphQLEventsOccurringHereConnection$Deserializer());
    }

    public Object m7353a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        MutableFlatBuffer a = GraphQLEventsOccurringHereConnectionDeserializer.m4856a(jsonParser, (short) 414);
        Object graphQLEventsOccurringHereConnection = new GraphQLEventsOccurringHereConnection();
        ((BaseModel) graphQLEventsOccurringHereConnection).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
        if (graphQLEventsOccurringHereConnection instanceof Postprocessable) {
            return ((Postprocessable) graphQLEventsOccurringHereConnection).a();
        }
        return graphQLEventsOccurringHereConnection;
    }
}
