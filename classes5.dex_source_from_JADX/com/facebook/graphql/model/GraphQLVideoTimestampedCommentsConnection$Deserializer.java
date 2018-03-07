package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.deserializers.GraphQLVideoTimestampedCommentsConnectionDeserializer;
import com.facebook.graphql.modelutil.BaseModel;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: The max capacity  */
public class GraphQLVideoTimestampedCommentsConnection$Deserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLVideoTimestampedCommentsConnection.class, new GraphQLVideoTimestampedCommentsConnection$Deserializer());
    }

    public Object m22468a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        MutableFlatBuffer a = GraphQLVideoTimestampedCommentsConnectionDeserializer.m6194a(jsonParser, (short) 519);
        Object graphQLVideoTimestampedCommentsConnection = new GraphQLVideoTimestampedCommentsConnection();
        ((BaseModel) graphQLVideoTimestampedCommentsConnection).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
        if (graphQLVideoTimestampedCommentsConnection instanceof Postprocessable) {
            return ((Postprocessable) graphQLVideoTimestampedCommentsConnection).a();
        }
        return graphQLVideoTimestampedCommentsConnection;
    }
}
