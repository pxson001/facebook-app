package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.deserializers.GraphQLInstantArticleVersionDeserializer;
import com.facebook.graphql.modelutil.BaseModel;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: ffa */
public class GraphQLInstantArticleVersion$Deserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLInstantArticleVersion.class, new GraphQLInstantArticleVersion$Deserializer());
    }

    public Object m8726a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        MutableFlatBuffer a = GraphQLInstantArticleVersionDeserializer.m5266a(jsonParser, (short) 19);
        Object graphQLInstantArticleVersion = new GraphQLInstantArticleVersion();
        ((BaseModel) graphQLInstantArticleVersion).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
        if (graphQLInstantArticleVersion instanceof Postprocessable) {
            return ((Postprocessable) graphQLInstantArticleVersion).a();
        }
        return graphQLInstantArticleVersion;
    }
}
