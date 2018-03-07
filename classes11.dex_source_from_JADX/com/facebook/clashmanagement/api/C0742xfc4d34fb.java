package com.facebook.clashmanagement.api;

import com.facebook.clashmanagement.api.ClashUnitQueryModels.ClashUnitQueryModel.EligibleClashUnitsModel.EdgesModel;
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
public class C0742xfc4d34fb extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(EdgesModel.class, new C0742xfc4d34fb());
    }

    public Object m7314a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
        flatBufferBuilder.d(C0746x2c16c1b0.m7329b(jsonParser, flatBufferBuilder));
        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
        wrap.position(0);
        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
        mutableFlatBuffer.a(4, Boolean.valueOf(true));
        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
        Object edgesModel = new EdgesModel();
        ((BaseModel) edgesModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
        if (edgesModel instanceof Postprocessable) {
            return ((Postprocessable) edgesModel).a();
        }
        return edgesModel;
    }
}
