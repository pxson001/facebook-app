package com.facebook.api.graphql.feed;

import com.facebook.api.graphql.feed.NewsFeedDefaultsFeedbackGraphQLModels.NewsFeedDefaultsCompleteFeedbackModel;
import com.facebook.api.graphql.feed.NewsFeedDefaultsFeedbackGraphQLParsers.NewsFeedDefaultsCompleteFeedbackParser;
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

/* compiled from: app_center_categories */
public class C0964x94b5d508 extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(NewsFeedDefaultsCompleteFeedbackModel.class, new C0964x94b5d508());
    }

    public Object m15847a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
        flatBufferBuilder.d(NewsFeedDefaultsCompleteFeedbackParser.m15889a(jsonParser, flatBufferBuilder));
        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
        wrap.position(0);
        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
        mutableFlatBuffer.a(4, Boolean.valueOf(true));
        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
        Object newsFeedDefaultsCompleteFeedbackModel = new NewsFeedDefaultsCompleteFeedbackModel();
        ((BaseModel) newsFeedDefaultsCompleteFeedbackModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
        if (newsFeedDefaultsCompleteFeedbackModel instanceof Postprocessable) {
            return ((Postprocessable) newsFeedDefaultsCompleteFeedbackModel).a();
        }
        return newsFeedDefaultsCompleteFeedbackModel;
    }
}
