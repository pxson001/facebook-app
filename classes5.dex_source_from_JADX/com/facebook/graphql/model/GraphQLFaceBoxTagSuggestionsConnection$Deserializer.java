package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.deserializers.GraphQLFaceBoxTagSuggestionsConnectionDeserializer;
import com.facebook.graphql.modelutil.BaseModel;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: hybrid */
public class GraphQLFaceBoxTagSuggestionsConnection$Deserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLFaceBoxTagSuggestionsConnection.class, new GraphQLFaceBoxTagSuggestionsConnection$Deserializer());
    }

    public Object m7436a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        MutableFlatBuffer a = GraphQLFaceBoxTagSuggestionsConnectionDeserializer.m4874a(jsonParser, (short) 455);
        Object graphQLFaceBoxTagSuggestionsConnection = new GraphQLFaceBoxTagSuggestionsConnection();
        ((BaseModel) graphQLFaceBoxTagSuggestionsConnection).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
        if (graphQLFaceBoxTagSuggestionsConnection instanceof Postprocessable) {
            return ((Postprocessable) graphQLFaceBoxTagSuggestionsConnection).a();
        }
        return graphQLFaceBoxTagSuggestionsConnection;
    }
}
