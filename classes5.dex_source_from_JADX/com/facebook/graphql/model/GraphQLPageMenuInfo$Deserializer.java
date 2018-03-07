package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.deserializers.GraphQLPageMenuInfoDeserializer;
import com.facebook.graphql.modelutil.BaseModel;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: encryptChannelRequestMethod */
public class GraphQLPageMenuInfo$Deserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLPageMenuInfo.class, new GraphQLPageMenuInfo$Deserializer());
    }

    public Object m9496a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        MutableFlatBuffer a = GraphQLPageMenuInfoDeserializer.m5513a(jsonParser, (short) 285);
        Object graphQLPageMenuInfo = new GraphQLPageMenuInfo();
        ((BaseModel) graphQLPageMenuInfo).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
        if (graphQLPageMenuInfo instanceof Postprocessable) {
            return ((Postprocessable) graphQLPageMenuInfo).a();
        }
        return graphQLPageMenuInfo;
    }
}
