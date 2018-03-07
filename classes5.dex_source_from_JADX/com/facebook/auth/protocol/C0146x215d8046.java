package com.facebook.auth.protocol;

import com.facebook.auth.protocol.GetLoggedInUserGraphQLModels.GetLoggedInUserQueryModel;
import com.facebook.common.json.FbSerializerProvider;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.productionprompts.graphql.FetchProductionPromptsGraphQLParsers.FetchProductionPromptsQueryParser;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.nio.ByteBuffer;

/* compiled from: suggestion_type */
public class C0146x215d8046 extends JsonSerializer<GetLoggedInUserQueryModel> {
    public final void m3217a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        MutableFlatBuffer mutableFlatBuffer;
        GetLoggedInUserQueryModel getLoggedInUserQueryModel = (GetLoggedInUserQueryModel) obj;
        if (getLoggedInUserQueryModel.w_() == null) {
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
            flatBufferBuilder.d(getLoggedInUserQueryModel.a(flatBufferBuilder));
            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
            wrap.position(0);
            mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
            getLoggedInUserQueryModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
        }
        mutableFlatBuffer = getLoggedInUserQueryModel.w_();
        int u_ = getLoggedInUserQueryModel.u_();
        jsonGenerator.f();
        int g = mutableFlatBuffer.g(u_, 0);
        if (g != 0) {
            jsonGenerator.a("actor");
            FetchProductionPromptsQueryParser.a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        boolean a = mutableFlatBuffer.a(u_, 1);
        if (a) {
            jsonGenerator.a("is_fb_employee");
            jsonGenerator.a(a);
        }
        jsonGenerator.g();
    }

    static {
        FbSerializerProvider.a(GetLoggedInUserQueryModel.class, new C0146x215d8046());
    }
}
