package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.deserializers.GraphQLTaggableActivityIconDeserializer;
import com.facebook.graphql.modelutil.BaseModel;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: UNSET_OR_UNRECOGNIZED_ENUM_VALUE */
public class GraphQLTaggableActivityIcon$Deserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLTaggableActivityIcon.class, new GraphQLTaggableActivityIcon$Deserializer());
    }

    public Object m22050a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        MutableFlatBuffer a = GraphQLTaggableActivityIconDeserializer.m6037a(jsonParser, (short) 68);
        Object graphQLTaggableActivityIcon = new GraphQLTaggableActivityIcon();
        ((BaseModel) graphQLTaggableActivityIcon).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
        if (graphQLTaggableActivityIcon instanceof Postprocessable) {
            return ((Postprocessable) graphQLTaggableActivityIcon).a();
        }
        return graphQLTaggableActivityIcon;
    }
}
