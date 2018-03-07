package com.facebook.photos.data.protocol;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.SimpleMediaFeedbackModel;
import com.facebook.photos.data.protocol.PhotosMetadataGraphQLParsers.SimpleMediaFeedbackParser;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import java.nio.ByteBuffer;

/* compiled from: suggest_edits */
public class C0219xfd018484 extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(SimpleMediaFeedbackModel.class, new C0219xfd018484());
    }

    public Object m5336a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
        flatBufferBuilder.d(SimpleMediaFeedbackParser.m5490a(jsonParser, flatBufferBuilder));
        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
        wrap.position(0);
        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
        mutableFlatBuffer.a(4, Boolean.valueOf(true));
        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
        Object simpleMediaFeedbackModel = new SimpleMediaFeedbackModel();
        ((BaseModel) simpleMediaFeedbackModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
        if (simpleMediaFeedbackModel instanceof Postprocessable) {
            return ((Postprocessable) simpleMediaFeedbackModel).a();
        }
        return simpleMediaFeedbackModel;
    }
}
