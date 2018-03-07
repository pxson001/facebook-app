package com.facebook.api.graphql.reactions;

import com.facebook.api.graphql.reactions.ReactionsGraphQLModels.ViewerReactionsMutationFragmentModel.FeedbackModel.ReactorsModel;
import com.facebook.api.graphql.reactions.ReactionsGraphQLParsers.ViewerReactionsMutationFragmentParser.FeedbackParser.ReactorsParser;
import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.modelutil.BaseModel;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import java.nio.ByteBuffer;

/* compiled from: android_place_picker_long_press_report_duplicates */
public class C0978x8888e9f0 extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(ReactorsModel.class, new C0978x8888e9f0());
    }

    public Object m17108a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
        flatBufferBuilder.d(ReactorsParser.m17172a(jsonParser, flatBufferBuilder));
        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
        wrap.position(0);
        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
        mutableFlatBuffer.a(4, Boolean.valueOf(true));
        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
        Object reactorsModel = new ReactorsModel();
        ((BaseModel) reactorsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
        if (reactorsModel instanceof Postprocessable) {
            return ((Postprocessable) reactorsModel).a();
        }
        return reactorsModel;
    }
}
