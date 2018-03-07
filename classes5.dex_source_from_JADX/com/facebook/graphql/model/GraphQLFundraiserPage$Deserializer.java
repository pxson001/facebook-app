package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.deserializers.GraphQLFundraiserPageDeserializer;
import com.facebook.graphql.modelutil.BaseModel;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: group_story_chattable_members */
public class GraphQLFundraiserPage$Deserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLFundraiserPage.class, new GraphQLFundraiserPage$Deserializer());
    }

    public Object m7678a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        MutableFlatBuffer a = GraphQLFundraiserPageDeserializer.m4979a(jsonParser, (short) 99);
        Object graphQLFundraiserPage = new GraphQLFundraiserPage();
        ((BaseModel) graphQLFundraiserPage).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
        if (graphQLFundraiserPage instanceof Postprocessable) {
            return ((Postprocessable) graphQLFundraiserPage).a();
        }
        return graphQLFundraiserPage;
    }
}
