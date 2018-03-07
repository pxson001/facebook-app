package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.deserializers.GraphQLGraphSearchQueryTitleDeserializer;
import com.facebook.graphql.modelutil.BaseModel;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: game_about */
public class GraphQLGraphSearchQueryTitle$Deserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLGraphSearchQueryTitle.class, new GraphQLGraphSearchQueryTitle$Deserializer());
    }

    public Object m8259a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        MutableFlatBuffer a = GraphQLGraphSearchQueryTitleDeserializer.m5104a(jsonParser, (short) 475);
        Object graphQLGraphSearchQueryTitle = new GraphQLGraphSearchQueryTitle();
        ((BaseModel) graphQLGraphSearchQueryTitle).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
        if (graphQLGraphSearchQueryTitle instanceof Postprocessable) {
            return ((Postprocessable) graphQLGraphSearchQueryTitle).a();
        }
        return graphQLGraphSearchQueryTitle;
    }
}
