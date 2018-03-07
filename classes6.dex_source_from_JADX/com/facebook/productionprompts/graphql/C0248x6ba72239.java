package com.facebook.productionprompts.graphql;

import com.facebook.common.json.FbSerializerProvider;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.productionprompts.graphql.FetchProductionPromptsGraphQLModels.ClientProductionPromptsInfoModel;
import com.facebook.productionprompts.graphql.FetchProductionPromptsGraphQLParsers.ClientProductionPromptsInfoParser;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.nio.ByteBuffer;

/* compiled from: state_report_button_position */
public class C0248x6ba72239 extends JsonSerializer<ClientProductionPromptsInfoModel> {
    public final void m6130a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        ClientProductionPromptsInfoModel clientProductionPromptsInfoModel = (ClientProductionPromptsInfoModel) obj;
        if (clientProductionPromptsInfoModel.w_() == null) {
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
            flatBufferBuilder.d(clientProductionPromptsInfoModel.a(flatBufferBuilder));
            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
            wrap.position(0);
            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
            clientProductionPromptsInfoModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
        }
        ClientProductionPromptsInfoParser.a(clientProductionPromptsInfoModel.w_(), clientProductionPromptsInfoModel.u_(), jsonGenerator);
    }

    static {
        FbSerializerProvider.a(ClientProductionPromptsInfoModel.class, new C0248x6ba72239());
    }
}
