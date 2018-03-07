package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.deserializers.GraphQLViewerVisitsConnectionDeserializer;
import com.facebook.graphql.modelutil.BaseModel;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: TaskStackBuilder */
public class GraphQLViewerVisitsConnection$Deserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLViewerVisitsConnection.class, new GraphQLViewerVisitsConnection$Deserializer());
    }

    public Object m22488a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        MutableFlatBuffer a = GraphQLViewerVisitsConnectionDeserializer.m6203a(jsonParser, (short) 523);
        Object graphQLViewerVisitsConnection = new GraphQLViewerVisitsConnection();
        ((BaseModel) graphQLViewerVisitsConnection).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
        if (graphQLViewerVisitsConnection instanceof Postprocessable) {
            return ((Postprocessable) graphQLViewerVisitsConnection).a();
        }
        return graphQLViewerVisitsConnection;
    }
}
