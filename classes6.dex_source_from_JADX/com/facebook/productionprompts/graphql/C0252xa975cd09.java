package com.facebook.productionprompts.graphql;

import com.facebook.common.json.FbSerializerProvider;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.productionprompts.graphql.FetchProductionPromptsGraphQLModels.FetchProductionPromptsQueryModel.ProductionPromptsModel;
import com.facebook.productionprompts.graphql.FetchProductionPromptsGraphQLParsers.FetchProductionPromptsQueryParser.ProductionPromptsParser;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.nio.ByteBuffer;

/* compiled from: state_report_button_position */
public class C0252xa975cd09 extends JsonSerializer<ProductionPromptsModel> {
    public final void m6134a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        ProductionPromptsModel productionPromptsModel = (ProductionPromptsModel) obj;
        if (productionPromptsModel.w_() == null) {
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
            flatBufferBuilder.d(productionPromptsModel.a(flatBufferBuilder));
            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
            wrap.position(0);
            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
            productionPromptsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
        }
        ProductionPromptsParser.a(productionPromptsModel.w_(), productionPromptsModel.u_(), jsonGenerator, serializerProvider);
    }

    static {
        FbSerializerProvider.a(ProductionPromptsModel.class, new C0252xa975cd09());
    }
}
