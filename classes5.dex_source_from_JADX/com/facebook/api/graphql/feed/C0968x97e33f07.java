package com.facebook.api.graphql.feed;

import com.facebook.api.graphql.feed.NewsFeedDefaultsFeedbackGraphQLModels.NewsFeedDefaultsCompleteFeedbackModel;
import com.facebook.api.graphql.feed.NewsFeedDefaultsFeedbackGraphQLParsers.NewsFeedDefaultsCompleteFeedbackParser;
import com.facebook.common.json.FbSerializerProvider;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.nio.ByteBuffer;

/* compiled from: app_center_categories */
public class C0968x97e33f07 extends JsonSerializer<NewsFeedDefaultsCompleteFeedbackModel> {
    public final void m15869a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        NewsFeedDefaultsCompleteFeedbackModel newsFeedDefaultsCompleteFeedbackModel = (NewsFeedDefaultsCompleteFeedbackModel) obj;
        if (newsFeedDefaultsCompleteFeedbackModel.w_() == null) {
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
            flatBufferBuilder.d(newsFeedDefaultsCompleteFeedbackModel.a(flatBufferBuilder));
            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
            wrap.position(0);
            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
            newsFeedDefaultsCompleteFeedbackModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
        }
        NewsFeedDefaultsCompleteFeedbackParser.m15890a(newsFeedDefaultsCompleteFeedbackModel.w_(), newsFeedDefaultsCompleteFeedbackModel.u_(), jsonGenerator, serializerProvider);
    }

    static {
        FbSerializerProvider.a(NewsFeedDefaultsCompleteFeedbackModel.class, new C0968x97e33f07());
    }
}
