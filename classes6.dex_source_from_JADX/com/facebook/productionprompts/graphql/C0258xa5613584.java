package com.facebook.productionprompts.graphql;

import com.facebook.common.json.FbSerializerProvider;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.productionprompts.graphql.FetchProductionPromptsGraphQLModels.ProductionPromptsInfoModel;
import com.facebook.productionprompts.graphql.FetchProductionPromptsGraphQLParsers.ProductionPromptsInfoParser;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.nio.ByteBuffer;

/* compiled from: state_report_button_position */
public class C0258xa5613584 extends JsonSerializer<ProductionPromptsInfoModel> {
    public final void m6154a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        ProductionPromptsInfoModel productionPromptsInfoModel = (ProductionPromptsInfoModel) obj;
        if (productionPromptsInfoModel.w_() == null) {
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
            flatBufferBuilder.d(productionPromptsInfoModel.a(flatBufferBuilder));
            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
            wrap.position(0);
            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
            productionPromptsInfoModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
        }
        ProductionPromptsInfoParser.m6249b(productionPromptsInfoModel.w_(), productionPromptsInfoModel.u_(), jsonGenerator, serializerProvider);
    }

    static {
        FbSerializerProvider.a(ProductionPromptsInfoModel.class, new C0258xa5613584());
    }
}
