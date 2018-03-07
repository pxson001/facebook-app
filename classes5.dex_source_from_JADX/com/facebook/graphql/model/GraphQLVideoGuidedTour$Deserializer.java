package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.deserializers.GraphQLVideoGuidedTourDeserializer;
import com.facebook.graphql.modelutil.BaseModel;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: This instance has been unsubscribed and the queue is no longer usable. */
public class GraphQLVideoGuidedTour$Deserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLVideoGuidedTour.class, new GraphQLVideoGuidedTour$Deserializer());
    }

    public Object m22449a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        MutableFlatBuffer a = GraphQLVideoGuidedTourDeserializer.m6188a(jsonParser, (short) 243);
        Object graphQLVideoGuidedTour = new GraphQLVideoGuidedTour();
        ((BaseModel) graphQLVideoGuidedTour).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
        if (graphQLVideoGuidedTour instanceof Postprocessable) {
            return ((Postprocessable) graphQLVideoGuidedTour).a();
        }
        return graphQLVideoGuidedTour;
    }
}
