package com.facebook.productionprompts.graphql;

import com.facebook.common.json.FbSerializerProvider;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.productionprompts.graphql.FetchProductionPromptsGraphQLModels.FetchProductionPromptsQueryModel.ClientProductionPromptsModel;
import com.facebook.productionprompts.graphql.FetchProductionPromptsGraphQLParsers.FetchProductionPromptsQueryParser.ClientProductionPromptsParser;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.nio.ByteBuffer;

/* compiled from: state_report_button_position */
public class C0250x6789f1fe extends JsonSerializer<ClientProductionPromptsModel> {
    public final void m6132a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        ClientProductionPromptsModel clientProductionPromptsModel = (ClientProductionPromptsModel) obj;
        if (clientProductionPromptsModel.w_() == null) {
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
            flatBufferBuilder.d(clientProductionPromptsModel.a(flatBufferBuilder));
            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
            wrap.position(0);
            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
            clientProductionPromptsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
        }
        ClientProductionPromptsParser.a(clientProductionPromptsModel.w_(), clientProductionPromptsModel.u_(), jsonGenerator, serializerProvider);
    }

    static {
        FbSerializerProvider.a(ClientProductionPromptsModel.class, new C0250x6789f1fe());
    }
}
