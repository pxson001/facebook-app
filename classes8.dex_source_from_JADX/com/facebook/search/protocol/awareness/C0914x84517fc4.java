package com.facebook.search.protocol.awareness;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.search.protocol.awareness.SearchAwarenessModels.UserSearchAwarenessSuggestionSubscriptionModel;
import com.facebook.search.protocol.awareness.SearchAwarenessParsers.UserSearchAwarenessSuggestionSubscriptionParser;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: nearby_places_module */
public class C0914x84517fc4 extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(UserSearchAwarenessSuggestionSubscriptionModel.class, new C0914x84517fc4());
    }

    public Object m9069a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        MutableFlatBuffer a = UserSearchAwarenessSuggestionSubscriptionParser.m9083a(jsonParser);
        Object userSearchAwarenessSuggestionSubscriptionModel = new UserSearchAwarenessSuggestionSubscriptionModel();
        ((BaseModel) userSearchAwarenessSuggestionSubscriptionModel).a(a, FlatBuffer.a(a.a), jsonParser);
        if (userSearchAwarenessSuggestionSubscriptionModel instanceof Postprocessable) {
            return ((Postprocessable) userSearchAwarenessSuggestionSubscriptionModel).a();
        }
        return userSearchAwarenessSuggestionSubscriptionModel;
    }
}
