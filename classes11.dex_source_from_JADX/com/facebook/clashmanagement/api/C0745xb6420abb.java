package com.facebook.clashmanagement.api;

import com.facebook.clashmanagement.api.ClashUnitQueryModels.ClashUnitQueryModel.EligibleClashUnitsModel;
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
public class C0745xb6420abb extends JsonSerializer<EligibleClashUnitsModel> {
    public final void m7325a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        EligibleClashUnitsModel eligibleClashUnitsModel = (EligibleClashUnitsModel) obj;
        if (eligibleClashUnitsModel.w_() == null) {
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
            flatBufferBuilder.d(eligibleClashUnitsModel.a(flatBufferBuilder));
            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
            wrap.position(0);
            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
            eligibleClashUnitsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
        }
        EligibleClashUnitsParser.a(eligibleClashUnitsModel.w_(), eligibleClashUnitsModel.u_(), jsonGenerator, serializerProvider);
    }

    static {
        FbSerializerProvider.a(EligibleClashUnitsModel.class, new C0745xb6420abb());
    }
}
