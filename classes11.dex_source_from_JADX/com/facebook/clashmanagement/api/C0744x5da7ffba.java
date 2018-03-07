package com.facebook.clashmanagement.api;

import com.facebook.clashmanagement.api.ClashUnitQueryModels.ClashUnitQueryModel.EligibleClashUnitsModel.EdgesModel;
import com.facebook.common.json.FbSerializerProvider;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.nio.ByteBuffer;

/* compiled from: key_submit_answer */
public class C0744x5da7ffba extends JsonSerializer<EdgesModel> {
    public final void m7324a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        EdgesModel edgesModel = (EdgesModel) obj;
        if (edgesModel.w_() == null) {
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
            flatBufferBuilder.d(edgesModel.a(flatBufferBuilder));
            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
            wrap.position(0);
            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
            edgesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
        }
        C0746x2c16c1b0.m7330b(edgesModel.w_(), edgesModel.u_(), jsonGenerator, serializerProvider);
    }

    static {
        FbSerializerProvider.a(EdgesModel.class, new C0744x5da7ffba());
    }
}
