package com.facebook.privacy.protocol;

import com.facebook.common.json.FbSerializerProvider;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.privacy.protocol.FetchAudienceInfoModels.AudienceInfoFieldsModel;
import com.facebook.privacy.protocol.FetchAudienceInfoParsers.AudienceInfoFieldsParser;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.nio.ByteBuffer;

/* compiled from: sticker_source_object_id */
public class FetchAudienceInfoModels$AudienceInfoFieldsModel$Serializer extends JsonSerializer<AudienceInfoFieldsModel> {
    public final void m6041a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        AudienceInfoFieldsModel audienceInfoFieldsModel = (AudienceInfoFieldsModel) obj;
        if (audienceInfoFieldsModel.w_() == null) {
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
            flatBufferBuilder.d(audienceInfoFieldsModel.a(flatBufferBuilder));
            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
            wrap.position(0);
            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
            audienceInfoFieldsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
        }
        AudienceInfoFieldsParser.a(audienceInfoFieldsModel.w_(), audienceInfoFieldsModel.u_(), jsonGenerator, serializerProvider);
    }

    static {
        FbSerializerProvider.a(AudienceInfoFieldsModel.class, new FetchAudienceInfoModels$AudienceInfoFieldsModel$Serializer());
    }
}
