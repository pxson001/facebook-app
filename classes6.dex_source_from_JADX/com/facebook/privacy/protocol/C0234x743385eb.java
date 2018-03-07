package com.facebook.privacy.protocol;

import com.facebook.common.json.FbSerializerProvider;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.privacy.protocol.FetchAudienceInfoModels.FetchAudienceInfoForLoginModel;
import com.facebook.privacy.protocol.FetchAudienceInfoParsers.AudienceInfoFieldsForLoginParser;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.nio.ByteBuffer;

/* compiled from: sticker_source_object_id */
public class C0234x743385eb extends JsonSerializer<FetchAudienceInfoForLoginModel> {
    public final void m6043a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        MutableFlatBuffer mutableFlatBuffer;
        FetchAudienceInfoForLoginModel fetchAudienceInfoForLoginModel = (FetchAudienceInfoForLoginModel) obj;
        if (fetchAudienceInfoForLoginModel.w_() == null) {
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
            flatBufferBuilder.d(fetchAudienceInfoForLoginModel.a(flatBufferBuilder));
            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
            wrap.position(0);
            mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
            fetchAudienceInfoForLoginModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
        }
        mutableFlatBuffer = fetchAudienceInfoForLoginModel.w_();
        int u_ = fetchAudienceInfoForLoginModel.u_();
        jsonGenerator.f();
        int g = mutableFlatBuffer.g(u_, 0);
        if (g != 0) {
            jsonGenerator.a("audience_info");
            AudienceInfoFieldsForLoginParser.m6046a(mutableFlatBuffer, g, jsonGenerator);
        }
        jsonGenerator.g();
    }

    static {
        FbSerializerProvider.a(FetchAudienceInfoForLoginModel.class, new C0234x743385eb());
    }
}
