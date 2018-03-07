package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.deserializers.GraphQLQuestionOptionsConnectionDeserializer;
import com.facebook.graphql.modelutil.BaseModel;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: VIEW_PROFILE */
public class GraphQLQuestionOptionsConnection$Deserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLQuestionOptionsConnection.class, new GraphQLQuestionOptionsConnection$Deserializer());
    }

    public Object m21187a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        MutableFlatBuffer a = GraphQLQuestionOptionsConnectionDeserializer.m5741a(jsonParser, (short) 236);
        Object graphQLQuestionOptionsConnection = new GraphQLQuestionOptionsConnection();
        ((BaseModel) graphQLQuestionOptionsConnection).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
        if (graphQLQuestionOptionsConnection instanceof Postprocessable) {
            return ((Postprocessable) graphQLQuestionOptionsConnection).a();
        }
        return graphQLQuestionOptionsConnection;
    }
}
