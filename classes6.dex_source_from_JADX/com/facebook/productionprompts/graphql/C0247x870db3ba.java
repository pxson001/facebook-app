package com.facebook.productionprompts.graphql;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.productionprompts.graphql.FetchProductionPromptsGraphQLModels.ClientProductionPromptsInfoModel;
import com.facebook.productionprompts.graphql.FetchProductionPromptsGraphQLParsers.ClientProductionPromptsInfoParser;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import java.nio.ByteBuffer;

/* compiled from: state_report_button_position */
public class C0247x870db3ba extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(ClientProductionPromptsInfoModel.class, new C0247x870db3ba());
    }

    public Object m6129a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
        flatBufferBuilder.d(ClientProductionPromptsInfoParser.b(jsonParser, flatBufferBuilder));
        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
        wrap.position(0);
        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
        mutableFlatBuffer.a(4, Boolean.valueOf(true));
        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
        Object clientProductionPromptsInfoModel = new ClientProductionPromptsInfoModel();
        ((BaseModel) clientProductionPromptsInfoModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
        if (clientProductionPromptsInfoModel instanceof Postprocessable) {
            return ((Postprocessable) clientProductionPromptsInfoModel).a();
        }
        return clientProductionPromptsInfoModel;
    }
}
