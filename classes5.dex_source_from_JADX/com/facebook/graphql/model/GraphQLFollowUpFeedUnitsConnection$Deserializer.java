package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.deserializers.GraphQLFollowUpFeedUnitsConnectionDeserializer;
import com.facebook.graphql.modelutil.BaseModel;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: hdAtomSize */
public class GraphQLFollowUpFeedUnitsConnection$Deserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLFollowUpFeedUnitsConnection.class, new GraphQLFollowUpFeedUnitsConnection$Deserializer());
    }

    public Object m7528a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        MutableFlatBuffer a = GraphQLFollowUpFeedUnitsConnectionDeserializer.m4923a(jsonParser, (short) 325);
        Object graphQLFollowUpFeedUnitsConnection = new GraphQLFollowUpFeedUnitsConnection();
        ((BaseModel) graphQLFollowUpFeedUnitsConnection).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
        if (graphQLFollowUpFeedUnitsConnection instanceof Postprocessable) {
            return ((Postprocessable) graphQLFollowUpFeedUnitsConnection).a();
        }
        return graphQLFollowUpFeedUnitsConnection;
    }
}
