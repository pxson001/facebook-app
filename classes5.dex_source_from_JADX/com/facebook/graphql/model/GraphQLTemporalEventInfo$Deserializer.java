package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.deserializers.GraphQLTemporalEventInfoDeserializer;
import com.facebook.graphql.modelutil.BaseModel;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: UNOWNED_PAGE_ACTION_MENU_REPORT_PAGE */
public class GraphQLTemporalEventInfo$Deserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLTemporalEventInfo.class, new GraphQLTemporalEventInfo$Deserializer());
    }

    public Object m22099a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        MutableFlatBuffer a = GraphQLTemporalEventInfoDeserializer.m6054a(jsonParser, (short) 176);
        Object graphQLTemporalEventInfo = new GraphQLTemporalEventInfo();
        ((BaseModel) graphQLTemporalEventInfo).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
        if (graphQLTemporalEventInfo instanceof Postprocessable) {
            return ((Postprocessable) graphQLTemporalEventInfo).a();
        }
        return graphQLTemporalEventInfo;
    }
}
