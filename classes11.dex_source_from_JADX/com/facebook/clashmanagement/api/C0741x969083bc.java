package com.facebook.clashmanagement.api;

import com.facebook.clashmanagement.api.ClashUnitQueryModels.ClashUnitQueryModel.EligibleClashUnitsModel;
import com.facebook.clashmanagement.api.ClashUnitQueryParsers.ClashUnitQueryParser.EligibleClashUnitsParser;
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

/* compiled from: key_submit_answer */
public class C0741x969083bc extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(EligibleClashUnitsModel.class, new C0741x969083bc());
    }

    public Object m7313a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
        flatBufferBuilder.d(EligibleClashUnitsParser.a(jsonParser, flatBufferBuilder));
        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
        wrap.position(0);
        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
        mutableFlatBuffer.a(4, Boolean.valueOf(true));
        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
        Object eligibleClashUnitsModel = new EligibleClashUnitsModel();
        ((BaseModel) eligibleClashUnitsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
        if (eligibleClashUnitsModel instanceof Postprocessable) {
            return ((Postprocessable) eligibleClashUnitsModel).a();
        }
        return eligibleClashUnitsModel;
    }
}
