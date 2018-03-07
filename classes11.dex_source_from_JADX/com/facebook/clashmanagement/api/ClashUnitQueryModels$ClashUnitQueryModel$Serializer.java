package com.facebook.clashmanagement.api;

import com.facebook.clashmanagement.api.ClashUnitQueryModels.ClashUnitQueryModel;
import com.facebook.clashmanagement.api.ClashUnitQueryParsers.ClashUnitQueryParser.EligibleClashUnitsParser;
import com.facebook.common.json.FbSerializerProvider;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.nio.ByteBuffer;

/* compiled from: key_submit_answer */
public class ClashUnitQueryModels$ClashUnitQueryModel$Serializer extends JsonSerializer<ClashUnitQueryModel> {
    public final void m7326a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        MutableFlatBuffer mutableFlatBuffer;
        ClashUnitQueryModel clashUnitQueryModel = (ClashUnitQueryModel) obj;
        if (clashUnitQueryModel.w_() == null) {
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
            flatBufferBuilder.d(clashUnitQueryModel.a(flatBufferBuilder));
            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
            wrap.position(0);
            mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
            clashUnitQueryModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
        }
        mutableFlatBuffer = clashUnitQueryModel.w_();
        int u_ = clashUnitQueryModel.u_();
        jsonGenerator.f();
        int g = mutableFlatBuffer.g(u_, 0);
        if (g != 0) {
            jsonGenerator.a("eligible_clash_units");
            EligibleClashUnitsParser.a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        jsonGenerator.g();
    }

    static {
        FbSerializerProvider.a(ClashUnitQueryModel.class, new ClashUnitQueryModels$ClashUnitQueryModel$Serializer());
    }
}
