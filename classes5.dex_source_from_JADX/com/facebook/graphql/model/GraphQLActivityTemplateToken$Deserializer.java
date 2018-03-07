package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.deserializers.GraphQLActivityTemplateTokenDeserializer;
import com.facebook.graphql.modelutil.BaseModel;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: launch_point_friend_invites */
public class GraphQLActivityTemplateToken$Deserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLActivityTemplateToken.class, new GraphQLActivityTemplateToken$Deserializer());
    }

    public Object m6390a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        MutableFlatBuffer a = GraphQLActivityTemplateTokenDeserializer.m4515a(jsonParser, (short) 201);
        Object graphQLActivityTemplateToken = new GraphQLActivityTemplateToken();
        ((BaseModel) graphQLActivityTemplateToken).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
        if (graphQLActivityTemplateToken instanceof Postprocessable) {
            return ((Postprocessable) graphQLActivityTemplateToken).a();
        }
        return graphQLActivityTemplateToken;
    }
}
