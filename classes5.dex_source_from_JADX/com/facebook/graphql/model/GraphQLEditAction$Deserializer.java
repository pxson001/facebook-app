package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.deserializers.GraphQLEditActionDeserializer;
import com.facebook.graphql.modelutil.BaseModel;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: ios_page_header */
public class GraphQLEditAction$Deserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLEditAction.class, new GraphQLEditAction$Deserializer());
    }

    public Object m6956a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        MutableFlatBuffer a = GraphQLEditActionDeserializer.m4719a(jsonParser, (short) 21);
        Object graphQLEditAction = new GraphQLEditAction();
        ((BaseModel) graphQLEditAction).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
        if (graphQLEditAction instanceof Postprocessable) {
            return ((Postprocessable) graphQLEditAction).a();
        }
        return graphQLEditAction;
    }
}
