package com.facebook.feedback.reactions.api;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.feedback.reactions.api.FetchFeedbackReactionSettingsGraphQLModels.FetchFeedbackReactionsVectorDataQueryModel.FeedbackReactionSettingsModel;
import com.facebook.feedback.reactions.api.FetchFeedbackReactionSettingsGraphQLParsers.FetchFeedbackReactionsVectorDataQueryParser.FeedbackReactionSettingsParser;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.modelutil.BaseModel;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import java.nio.ByteBuffer;

/* compiled from: share_recent_post */
public class C0328x9e14d9ee extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(FeedbackReactionSettingsModel.class, new C0328x9e14d9ee());
    }

    public Object m4494a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
        flatBufferBuilder.d(FeedbackReactionSettingsParser.a(jsonParser, flatBufferBuilder));
        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
        wrap.position(0);
        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
        mutableFlatBuffer.a(4, Boolean.valueOf(true));
        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
        Object feedbackReactionSettingsModel = new FeedbackReactionSettingsModel();
        ((BaseModel) feedbackReactionSettingsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
        if (feedbackReactionSettingsModel instanceof Postprocessable) {
            return ((Postprocessable) feedbackReactionSettingsModel).a();
        }
        return feedbackReactionSettingsModel;
    }
}
