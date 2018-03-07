package com.facebook.privacy.protocol;

import com.facebook.common.json.FbSerializerProvider;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.privacy.protocol.FetchAudienceInfoModels.FetchAudienceInfoModel;
import com.facebook.privacy.protocol.FetchAudienceInfoParsers.AudienceInfoFieldsParser;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.nio.ByteBuffer;

/* compiled from: sticker_source_object_id */
public class FetchAudienceInfoModels$FetchAudienceInfoModel$Serializer extends JsonSerializer<FetchAudienceInfoModel> {
    public final void m6044a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        MutableFlatBuffer mutableFlatBuffer;
        FetchAudienceInfoModel fetchAudienceInfoModel = (FetchAudienceInfoModel) obj;
        if (fetchAudienceInfoModel.w_() == null) {
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
            flatBufferBuilder.d(fetchAudienceInfoModel.a(flatBufferBuilder));
            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
            wrap.position(0);
            mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
            fetchAudienceInfoModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
        }
        mutableFlatBuffer = fetchAudienceInfoModel.w_();
        int u_ = fetchAudienceInfoModel.u_();
        jsonGenerator.f();
        int g = mutableFlatBuffer.g(u_, 0);
        if (g != 0) {
            jsonGenerator.a("audience_info");
            AudienceInfoFieldsParser.a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        jsonGenerator.g();
    }

    static {
        FbSerializerProvider.a(FetchAudienceInfoModel.class, new FetchAudienceInfoModels$FetchAudienceInfoModel$Serializer());
    }
}
