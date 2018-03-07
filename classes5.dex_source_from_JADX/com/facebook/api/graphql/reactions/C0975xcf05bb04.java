package com.facebook.api.graphql.reactions;

import com.facebook.api.graphql.reactions.ReactionsGraphQLModels.ViewerReactionsMutationFragmentModel.FeedbackModel;
import com.facebook.api.graphql.reactions.ReactionsGraphQLParsers.ViewerReactionsMutationFragmentParser.FeedbackParser;
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
public class C0975xcf05bb04 extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(FeedbackModel.class, new C0975xcf05bb04());
    }

    public Object m17105a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
        flatBufferBuilder.d(FeedbackParser.m17176a(jsonParser, flatBufferBuilder));
        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
        wrap.position(0);
        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
        mutableFlatBuffer.a(4, Boolean.valueOf(true));
        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
        Object feedbackModel = new FeedbackModel();
        ((BaseModel) feedbackModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
        if (feedbackModel instanceof Postprocessable) {
            return ((Postprocessable) feedbackModel).a();
        }
        return feedbackModel;
    }
}
