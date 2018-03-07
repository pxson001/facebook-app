package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.deserializers.GraphQLCommentDeserializer;
import com.facebook.graphql.modelutil.BaseModel;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: is_away_toggle_on */
public class GraphQLComment$Deserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLComment.class, new GraphQLComment$Deserializer());
    }

    public Object m6802a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        MutableFlatBuffer a = GraphQLCommentDeserializer.m4658a(jsonParser, (short) 44);
        Object graphQLComment = new GraphQLComment();
        ((BaseModel) graphQLComment).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
        if (graphQLComment instanceof Postprocessable) {
            return ((Postprocessable) graphQLComment).a();
        }
        return graphQLComment;
    }
}
