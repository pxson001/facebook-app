package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.deserializers.GraphQLEventDeserializer;
import com.facebook.graphql.modelutil.BaseModel;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: install_messenger_not_now_button */
public class GraphQLEvent$Deserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLEvent.class, new GraphQLEvent$Deserializer());
    }

    public Object m7116a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        MutableFlatBuffer a = GraphQLEventDeserializer.m4793a(jsonParser, (short) 22);
        Object graphQLEvent = new GraphQLEvent();
        ((BaseModel) graphQLEvent).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
        if (graphQLEvent instanceof Postprocessable) {
            return ((Postprocessable) graphQLEvent).a();
        }
        return graphQLEvent;
    }
}
