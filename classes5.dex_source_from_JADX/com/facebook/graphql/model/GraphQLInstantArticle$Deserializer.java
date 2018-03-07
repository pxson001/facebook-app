package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.deserializers.GraphQLInstantArticleDeserializer;
import com.facebook.graphql.modelutil.BaseModel;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: fieldAssignmentFormatter */
public class GraphQLInstantArticle$Deserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLInstantArticle.class, new GraphQLInstantArticle$Deserializer());
    }

    public Object m8722a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        MutableFlatBuffer a = GraphQLInstantArticleDeserializer.m5263a(jsonParser, (short) 18);
        Object graphQLInstantArticle = new GraphQLInstantArticle();
        ((BaseModel) graphQLInstantArticle).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
        if (graphQLInstantArticle instanceof Postprocessable) {
            return ((Postprocessable) graphQLInstantArticle).a();
        }
        return graphQLInstantArticle;
    }
}
