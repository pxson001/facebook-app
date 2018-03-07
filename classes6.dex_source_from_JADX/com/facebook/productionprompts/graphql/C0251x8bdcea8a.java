package com.facebook.productionprompts.graphql;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.productionprompts.graphql.FetchProductionPromptsGraphQLModels.FetchProductionPromptsQueryModel.ProductionPromptsModel;
import com.facebook.productionprompts.graphql.FetchProductionPromptsGraphQLParsers.FetchProductionPromptsQueryParser.ProductionPromptsParser;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import java.nio.ByteBuffer;

/* compiled from: state_report_button_position */
public class C0251x8bdcea8a extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(ProductionPromptsModel.class, new C0251x8bdcea8a());
    }

    public Object m6133a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
        flatBufferBuilder.d(ProductionPromptsParser.a(jsonParser, flatBufferBuilder));
        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
        wrap.position(0);
        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
        mutableFlatBuffer.a(4, Boolean.valueOf(true));
        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
        Object productionPromptsModel = new ProductionPromptsModel();
        ((BaseModel) productionPromptsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
        if (productionPromptsModel instanceof Postprocessable) {
            return ((Postprocessable) productionPromptsModel).a();
        }
        return productionPromptsModel;
    }
}
