package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.deserializers.GraphQLNoContentFeedUnitDeserializer;
import com.facebook.graphql.modelutil.BaseModel;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: event_tips */
public class GraphQLNoContentFeedUnit$Deserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLNoContentFeedUnit.class, new GraphQLNoContentFeedUnit$Deserializer());
    }

    public Object m9274a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        MutableFlatBuffer a = GraphQLNoContentFeedUnitDeserializer.m5431a(jsonParser, (short) 413);
        Object graphQLNoContentFeedUnit = new GraphQLNoContentFeedUnit();
        ((BaseModel) graphQLNoContentFeedUnit).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
        if (graphQLNoContentFeedUnit instanceof Postprocessable) {
            return ((Postprocessable) graphQLNoContentFeedUnit).a();
        }
        return graphQLNoContentFeedUnit;
    }
}
