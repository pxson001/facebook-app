package com.facebook.auth.protocol;

import com.facebook.auth.protocol.LoggedInUserQueryFragmentModels.LoggedInUserQueryFragmentModel.AllPhonesModel;
import com.facebook.common.json.FbSerializerProvider;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.productionprompts.graphql.FetchProductionPromptsGraphQLParsers.FetchProductionPromptsQueryParser;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.nio.ByteBuffer;

/* compiled from: suggestion_text */
public class C0149x4d749a46 extends JsonSerializer<AllPhonesModel> {
    public final void m3225a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        AllPhonesModel allPhonesModel = (AllPhonesModel) obj;
        if (allPhonesModel.w_() == null) {
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
            flatBufferBuilder.d(allPhonesModel.a(flatBufferBuilder));
            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
            wrap.position(0);
            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
            allPhonesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
        }
        FetchProductionPromptsQueryParser.b(allPhonesModel.w_(), allPhonesModel.u_(), jsonGenerator, serializerProvider);
    }

    static {
        FbSerializerProvider.a(AllPhonesModel.class, new C0149x4d749a46());
    }
}
