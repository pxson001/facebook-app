package com.facebook.auth.protocol;

import com.facebook.auth.protocol.FetchFacebookEmployeeStatusGraphQLModels.FetchFacebookEmployeeStatusQueryModel;
import com.facebook.common.json.FbSerializerProvider;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.nio.ByteBuffer;

/* compiled from: summary_snippet */
public class C0145x439fdfc6 extends JsonSerializer<FetchFacebookEmployeeStatusQueryModel> {
    public final void m3216a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        MutableFlatBuffer mutableFlatBuffer;
        FetchFacebookEmployeeStatusQueryModel fetchFacebookEmployeeStatusQueryModel = (FetchFacebookEmployeeStatusQueryModel) obj;
        if (fetchFacebookEmployeeStatusQueryModel.w_() == null) {
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
            flatBufferBuilder.d(fetchFacebookEmployeeStatusQueryModel.a(flatBufferBuilder));
            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
            wrap.position(0);
            mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
            fetchFacebookEmployeeStatusQueryModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
        }
        mutableFlatBuffer = fetchFacebookEmployeeStatusQueryModel.w_();
        int u_ = fetchFacebookEmployeeStatusQueryModel.u_();
        jsonGenerator.f();
        boolean a = mutableFlatBuffer.a(u_, 0);
        if (a) {
            jsonGenerator.a("is_fb_employee");
            jsonGenerator.a(a);
        }
        jsonGenerator.g();
    }

    static {
        FbSerializerProvider.a(FetchFacebookEmployeeStatusQueryModel.class, new C0145x439fdfc6());
    }
}
