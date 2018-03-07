package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.deserializers.GraphQLUserEducationExperiencesConnectionDeserializer;
import com.facebook.graphql.modelutil.BaseModel;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: Topic */
public class GraphQLUserEducationExperiencesConnection$Deserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLUserEducationExperiencesConnection.class, new GraphQLUserEducationExperiencesConnection$Deserializer());
    }

    public Object m22385a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        MutableFlatBuffer a = GraphQLUserEducationExperiencesConnectionDeserializer.m6154a(jsonParser, (short) 339);
        Object graphQLUserEducationExperiencesConnection = new GraphQLUserEducationExperiencesConnection();
        ((BaseModel) graphQLUserEducationExperiencesConnection).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
        if (graphQLUserEducationExperiencesConnection instanceof Postprocessable) {
            return ((Postprocessable) graphQLUserEducationExperiencesConnection).a();
        }
        return graphQLUserEducationExperiencesConnection;
    }
}
