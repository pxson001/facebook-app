package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: offending_list_view */
public class GraphQLOverlayCallToActionInfoDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLOverlayCallToActionInfo.class, new GraphQLOverlayCallToActionInfoDeserializer());
    }

    public GraphQLOverlayCallToActionInfoDeserializer() {
        a(GraphQLOverlayCallToActionInfo.class);
    }

    public Object m9425a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return GraphQLOverlayCallToActionInfo__JsonHelper.m9427a(jsonParser);
    }
}
