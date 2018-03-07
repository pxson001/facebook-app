package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.deserializers.GraphQLPageCallToActionDeserializer;
import com.facebook.graphql.modelutil.BaseModel;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: engagement_pyml */
public class GraphQLPageCallToAction$Deserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLPageCallToAction.class, new GraphQLPageCallToAction$Deserializer());
    }

    public Object m9480a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        MutableFlatBuffer a = GraphQLPageCallToActionDeserializer.m5499a(jsonParser, (short) 574);
        Object graphQLPageCallToAction = new GraphQLPageCallToAction();
        ((BaseModel) graphQLPageCallToAction).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
        if (graphQLPageCallToAction instanceof Postprocessable) {
            return ((Postprocessable) graphQLPageCallToAction).a();
        }
        return graphQLPageCallToAction;
    }
}
