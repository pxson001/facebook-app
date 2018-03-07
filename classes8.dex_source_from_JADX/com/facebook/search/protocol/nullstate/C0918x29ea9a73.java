package com.facebook.search.protocol.nullstate;

import com.facebook.common.json.FbSerializerProvider;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.search.protocol.nullstate.FetchNullStateModulesGraphQLModels.NullStateModuleQueryModel.ProviderModel.ModulesModel;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.nio.ByteBuffer;

/* compiled from: multi_photo_attachment */
public class C0918x29ea9a73 extends JsonSerializer<ModulesModel> {
    public final void m9428a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        ModulesModel modulesModel = (ModulesModel) obj;
        if (modulesModel.w_() == null) {
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
            flatBufferBuilder.d(modulesModel.a(flatBufferBuilder));
            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
            wrap.position(0);
            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
            modulesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
        }
        C0922x2ae50003.m9484b(modulesModel.w_(), modulesModel.u_(), jsonGenerator, serializerProvider);
    }

    static {
        FbSerializerProvider.a(ModulesModel.class, new C0918x29ea9a73());
    }
}
