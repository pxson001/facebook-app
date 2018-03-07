package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.deserializers.GraphQLLeadGenErrorNodeDeserializer;
import com.facebook.graphql.modelutil.BaseModel;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: feed_story_search */
public class GraphQLLeadGenErrorNode$Deserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLLeadGenErrorNode.class, new GraphQLLeadGenErrorNode$Deserializer());
    }

    public Object m8829a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        MutableFlatBuffer a = GraphQLLeadGenErrorNodeDeserializer.m5290a(jsonParser, (short) 174);
        Object graphQLLeadGenErrorNode = new GraphQLLeadGenErrorNode();
        ((BaseModel) graphQLLeadGenErrorNode).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
        if (graphQLLeadGenErrorNode instanceof Postprocessable) {
            return ((Postprocessable) graphQLLeadGenErrorNode).a();
        }
        return graphQLLeadGenErrorNode;
    }
}
