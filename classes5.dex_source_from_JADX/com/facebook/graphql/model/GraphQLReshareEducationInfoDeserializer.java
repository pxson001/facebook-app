package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: music_title */
public class GraphQLReshareEducationInfoDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLReshareEducationInfo.class, new GraphQLReshareEducationInfoDeserializer());
    }

    public GraphQLReshareEducationInfoDeserializer() {
        a(GraphQLReshareEducationInfo.class);
    }

    public Object m21494a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLReshareEducationInfo__JsonHelper.m21496a(jsonParser);
    }
}
