package com.facebook.search.protocol.awareness;

import com.facebook.common.json.FbSerializerProvider;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.search.protocol.awareness.SearchAwarenessModels.UserSearchAwarenessSuggestionSubscriptionModel;
import com.facebook.search.protocol.awareness.SearchAwarenessParsers.SearchAwarenessRootSuggestionFieldsFragmentParser;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.nio.ByteBuffer;

/* compiled from: nearby_places_module */
public class C0915x3aa268c3 extends JsonSerializer<UserSearchAwarenessSuggestionSubscriptionModel> {
    public final void m9070a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        MutableFlatBuffer mutableFlatBuffer;
        UserSearchAwarenessSuggestionSubscriptionModel userSearchAwarenessSuggestionSubscriptionModel = (UserSearchAwarenessSuggestionSubscriptionModel) obj;
        if (userSearchAwarenessSuggestionSubscriptionModel.w_() == null) {
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
            flatBufferBuilder.d(userSearchAwarenessSuggestionSubscriptionModel.a(flatBufferBuilder));
            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
            wrap.position(0);
            mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
            userSearchAwarenessSuggestionSubscriptionModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
        }
        mutableFlatBuffer = userSearchAwarenessSuggestionSubscriptionModel.w_();
        int u_ = userSearchAwarenessSuggestionSubscriptionModel.u_();
        jsonGenerator.f();
        int g = mutableFlatBuffer.g(u_, 0);
        if (g != 0) {
            jsonGenerator.a("suggestion");
            SearchAwarenessRootSuggestionFieldsFragmentParser.m9075a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        jsonGenerator.g();
    }

    static {
        FbSerializerProvider.a(UserSearchAwarenessSuggestionSubscriptionModel.class, new C0915x3aa268c3());
    }
}
