package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.deserializers.GraphQLStoryActionLinkDeserializer;
import com.facebook.graphql.modelutil.BaseModel;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: Unable to retrieve version number */
public class GraphQLStoryActionLink$Deserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLStoryActionLink.class, new GraphQLStoryActionLink$Deserializer());
    }

    public Object m21843a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        MutableFlatBuffer a = GraphQLStoryActionLinkDeserializer.m5949a(jsonParser, (short) 191);
        Object graphQLStoryActionLink = new GraphQLStoryActionLink();
        ((BaseModel) graphQLStoryActionLink).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
        if (graphQLStoryActionLink instanceof Postprocessable) {
            return ((Postprocessable) graphQLStoryActionLink).a();
        }
        return graphQLStoryActionLink;
    }
}
