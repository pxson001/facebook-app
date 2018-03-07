package com.facebook.search.protocol.nullstate;

import com.facebook.common.json.FbSerializerProvider;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.search.protocol.nullstate.FetchNullStateModulesGraphQLModels.NullStateModuleQueryModel;
import com.facebook.search.protocol.nullstate.FetchNullStateModulesGraphQLParsers.NullStateModuleQueryParser.ProviderParser;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.nio.ByteBuffer;

/* compiled from: multi_photo_attachment */
public class C0921xfbbf04a7 extends JsonSerializer<NullStateModuleQueryModel> {
    public final void m9471a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        MutableFlatBuffer mutableFlatBuffer;
        NullStateModuleQueryModel nullStateModuleQueryModel = (NullStateModuleQueryModel) obj;
        if (nullStateModuleQueryModel.w_() == null) {
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
            flatBufferBuilder.d(nullStateModuleQueryModel.a(flatBufferBuilder));
            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
            wrap.position(0);
            mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
            nullStateModuleQueryModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
        }
        mutableFlatBuffer = nullStateModuleQueryModel.w_();
        int u_ = nullStateModuleQueryModel.u_();
        jsonGenerator.f();
        int g = mutableFlatBuffer.g(u_, 0);
        if (g != 0) {
            jsonGenerator.a("provider");
            ProviderParser.a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        jsonGenerator.g();
    }

    static {
        FbSerializerProvider.a(NullStateModuleQueryModel.class, new C0921xfbbf04a7());
    }
}
