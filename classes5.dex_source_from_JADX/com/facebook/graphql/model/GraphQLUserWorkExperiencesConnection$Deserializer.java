package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.deserializers.GraphQLUserWorkExperiencesConnectionDeserializer;
import com.facebook.graphql.modelutil.BaseModel;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: TimezoneInfo */
public class GraphQLUserWorkExperiencesConnection$Deserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLUserWorkExperiencesConnection.class, new GraphQLUserWorkExperiencesConnection$Deserializer());
    }

    public Object m22401a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        MutableFlatBuffer a = GraphQLUserWorkExperiencesConnectionDeserializer.m6160a(jsonParser, (short) 337);
        Object graphQLUserWorkExperiencesConnection = new GraphQLUserWorkExperiencesConnection();
        ((BaseModel) graphQLUserWorkExperiencesConnection).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
        if (graphQLUserWorkExperiencesConnection instanceof Postprocessable) {
            return ((Postprocessable) graphQLUserWorkExperiencesConnection).a();
        }
        return graphQLUserWorkExperiencesConnection;
    }
}
