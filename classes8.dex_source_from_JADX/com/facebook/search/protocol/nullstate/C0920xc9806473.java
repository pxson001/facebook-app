package com.facebook.search.protocol.nullstate;

import com.facebook.common.json.FbSerializerProvider;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.search.protocol.nullstate.FetchNullStateModulesGraphQLModels.NullStateModuleQueryModel.ProviderModel;
import com.facebook.search.protocol.nullstate.FetchNullStateModulesGraphQLParsers.NullStateModuleQueryParser.ProviderParser;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.nio.ByteBuffer;

/* compiled from: multi_photo_attachment */
public class C0920xc9806473 extends JsonSerializer<ProviderModel> {
    public final void m9470a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        ProviderModel providerModel = (ProviderModel) obj;
        if (providerModel.w_() == null) {
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
            flatBufferBuilder.d(providerModel.a(flatBufferBuilder));
            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
            wrap.position(0);
            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
            providerModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
        }
        ProviderParser.a(providerModel.w_(), providerModel.u_(), jsonGenerator, serializerProvider);
    }

    static {
        FbSerializerProvider.a(ProviderModel.class, new C0920xc9806473());
    }
}
