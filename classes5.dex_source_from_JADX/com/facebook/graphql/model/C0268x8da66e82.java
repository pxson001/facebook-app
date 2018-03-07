package com.facebook.graphql.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.deserializers.C0239xb10bb428;
import com.facebook.graphql.modelutil.BaseModel;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: is_viewer_newly_added */
public class C0268x8da66e82 extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(GraphQLAppendPostActionLinkTaggedAndMentionedUsersConnection.class, new C0268x8da66e82());
    }

    public Object m6576a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        MutableFlatBuffer a = C0239xb10bb428.m4577a(jsonParser, (short) 195);
        Object graphQLAppendPostActionLinkTaggedAndMentionedUsersConnection = new GraphQLAppendPostActionLinkTaggedAndMentionedUsersConnection();
        ((BaseModel) graphQLAppendPostActionLinkTaggedAndMentionedUsersConnection).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
        if (graphQLAppendPostActionLinkTaggedAndMentionedUsersConnection instanceof Postprocessable) {
            return ((Postprocessable) graphQLAppendPostActionLinkTaggedAndMentionedUsersConnection).a();
        }
        return graphQLAppendPostActionLinkTaggedAndMentionedUsersConnection;
    }
}
