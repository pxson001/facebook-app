package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.deserializers.GraphQLStorySaveInfoDeserializer;
import com.facebook.graphql.modelutil.BaseModel;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: Unable to copy attachment for bug report. */
public class GraphQLStorySaveInfo$Deserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLStorySaveInfo.class, new GraphQLStorySaveInfo$Deserializer());
    }

    public Object m21881a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        MutableFlatBuffer a = GraphQLStorySaveInfoDeserializer.m5977a(jsonParser, (short) 150);
        Object graphQLStorySaveInfo = new GraphQLStorySaveInfo();
        ((BaseModel) graphQLStorySaveInfo).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
        if (graphQLStorySaveInfo instanceof Postprocessable) {
            return ((Postprocessable) graphQLStorySaveInfo).a();
        }
        return graphQLStorySaveInfo;
    }
}
