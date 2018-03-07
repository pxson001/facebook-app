package com.facebook.photos.data.protocol;

import com.facebook.common.json.FbSerializerProvider;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.SimpleMediaFeedbackModel;
import com.facebook.photos.data.protocol.PhotosMetadataGraphQLParsers.SimpleMediaFeedbackParser;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.nio.ByteBuffer;

/* compiled from: suggest_edits */
public class PhotosMetadataGraphQLModels$SimpleMediaFeedbackModel$Serializer extends JsonSerializer<SimpleMediaFeedbackModel> {
    public final void m5345a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        SimpleMediaFeedbackModel simpleMediaFeedbackModel = (SimpleMediaFeedbackModel) obj;
        if (simpleMediaFeedbackModel.w_() == null) {
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
            flatBufferBuilder.d(simpleMediaFeedbackModel.a(flatBufferBuilder));
            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
            wrap.position(0);
            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
            simpleMediaFeedbackModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
        }
        SimpleMediaFeedbackParser.m5491a(simpleMediaFeedbackModel.w_(), simpleMediaFeedbackModel.u_(), jsonGenerator, serializerProvider);
    }

    static {
        FbSerializerProvider.a(SimpleMediaFeedbackModel.class, new PhotosMetadataGraphQLModels$SimpleMediaFeedbackModel$Serializer());
    }
}
