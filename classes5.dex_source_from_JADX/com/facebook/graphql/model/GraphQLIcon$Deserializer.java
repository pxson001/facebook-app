package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.deserializers.GraphQLIconDeserializer;
import com.facebook.graphql.modelutil.BaseModel;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: followup_choices */
public class GraphQLIcon$Deserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLIcon.class, new GraphQLIcon$Deserializer());
    }

    public Object m8609a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        MutableFlatBuffer a = GraphQLIconDeserializer.m5220a(jsonParser, (short) 143);
        Object graphQLIcon = new GraphQLIcon();
        ((BaseModel) graphQLIcon).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
        if (graphQLIcon instanceof Postprocessable) {
            return ((Postprocessable) graphQLIcon).a();
        }
        return graphQLIcon;
    }
}
