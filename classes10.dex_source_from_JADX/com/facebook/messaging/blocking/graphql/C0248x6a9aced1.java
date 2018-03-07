package com.facebook.messaging.blocking.graphql;

import com.facebook.common.json.FbSerializerProvider;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.messaging.blocking.graphql.GetBlockInfoForUserModels.GetBlockInfoForUserQueryModel;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.nio.ByteBuffer;

/* compiled from: thread_video_view */
public class C0248x6a9aced1 extends JsonSerializer<GetBlockInfoForUserQueryModel> {
    public final void m1463a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        MutableFlatBuffer mutableFlatBuffer;
        GetBlockInfoForUserQueryModel getBlockInfoForUserQueryModel = (GetBlockInfoForUserQueryModel) obj;
        if (getBlockInfoForUserQueryModel.w_() == null) {
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
            flatBufferBuilder.d(getBlockInfoForUserQueryModel.a(flatBufferBuilder));
            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
            wrap.position(0);
            mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
            getBlockInfoForUserQueryModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
        }
        mutableFlatBuffer = getBlockInfoForUserQueryModel.w_();
        int u_ = getBlockInfoForUserQueryModel.u_();
        jsonGenerator.f();
        boolean a = mutableFlatBuffer.a(u_, 0);
        if (a) {
            jsonGenerator.a("is_blocked_by_viewer");
            jsonGenerator.a(a);
        }
        a = mutableFlatBuffer.a(u_, 1);
        if (a) {
            jsonGenerator.a("is_message_blocked_by_viewer");
            jsonGenerator.a(a);
        }
        if (mutableFlatBuffer.g(u_, 2) != 0) {
            jsonGenerator.a("name");
            jsonGenerator.b(mutableFlatBuffer.c(u_, 2));
        }
        jsonGenerator.g();
    }

    static {
        FbSerializerProvider.a(GetBlockInfoForUserQueryModel.class, new C0248x6a9aced1());
    }
}
