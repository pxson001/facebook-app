package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.deserializers.GraphQLAudioDeserializer;
import com.facebook.graphql.modelutil.BaseModel;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: is_playable */
public class GraphQLAudio$Deserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLAudio.class, new GraphQLAudio$Deserializer());
    }

    public Object m6623a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        MutableFlatBuffer a = GraphQLAudioDeserializer.m4601a(jsonParser, (short) 219);
        Object graphQLAudio = new GraphQLAudio();
        ((BaseModel) graphQLAudio).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
        if (graphQLAudio instanceof Postprocessable) {
            return ((Postprocessable) graphQLAudio).a();
        }
        return graphQLAudio;
    }
}
