package com.facebook.productionprompts.graphql;

import com.facebook.common.json.FbSerializerProvider;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.productionprompts.graphql.FetchProductionPromptsGraphQLModels.FetchProductionPromptsQueryModel;
import com.facebook.productionprompts.graphql.FetchProductionPromptsGraphQLParsers.FetchProductionPromptsQueryParser.ClientProductionPromptsParser;
import com.facebook.productionprompts.graphql.FetchProductionPromptsGraphQLParsers.FetchProductionPromptsQueryParser.ProductionPromptsParser;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.nio.ByteBuffer;

/* compiled from: state_report_button_position */
public class C0253x1b60160c extends JsonSerializer<FetchProductionPromptsQueryModel> {
    public final void m6135a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        MutableFlatBuffer mutableFlatBuffer;
        FetchProductionPromptsQueryModel fetchProductionPromptsQueryModel = (FetchProductionPromptsQueryModel) obj;
        if (fetchProductionPromptsQueryModel.w_() == null) {
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
            flatBufferBuilder.d(fetchProductionPromptsQueryModel.a(flatBufferBuilder));
            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
            wrap.position(0);
            mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
            fetchProductionPromptsQueryModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
        }
        mutableFlatBuffer = fetchProductionPromptsQueryModel.w_();
        int u_ = fetchProductionPromptsQueryModel.u_();
        jsonGenerator.f();
        int g = mutableFlatBuffer.g(u_, 0);
        if (g != 0) {
            jsonGenerator.a("client_production_prompts");
            ClientProductionPromptsParser.a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        g = mutableFlatBuffer.g(u_, 1);
        if (g != 0) {
            jsonGenerator.a("production_prompts");
            ProductionPromptsParser.a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        jsonGenerator.g();
    }

    static {
        FbSerializerProvider.a(FetchProductionPromptsQueryModel.class, new C0253x1b60160c());
    }
}
