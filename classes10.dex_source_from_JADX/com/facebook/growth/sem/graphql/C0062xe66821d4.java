package com.facebook.growth.sem.graphql;

import com.facebook.common.json.FbSerializerProvider;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.growth.sem.graphql.UserSemResTrackingMutationsModels.UserSemResTrackingMutationModel;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.nio.ByteBuffer;

/* compiled from: vnd.android-dir/mms-sms */
public class C0062xe66821d4 extends JsonSerializer<UserSemResTrackingMutationModel> {
    public final void m494a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        MutableFlatBuffer mutableFlatBuffer;
        UserSemResTrackingMutationModel userSemResTrackingMutationModel = (UserSemResTrackingMutationModel) obj;
        if (userSemResTrackingMutationModel.w_() == null) {
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
            flatBufferBuilder.d(userSemResTrackingMutationModel.a(flatBufferBuilder));
            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
            wrap.position(0);
            mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
            userSemResTrackingMutationModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
        }
        mutableFlatBuffer = userSemResTrackingMutationModel.w_();
        int u_ = userSemResTrackingMutationModel.u_();
        jsonGenerator.f();
        if (mutableFlatBuffer.g(u_, 0) != 0) {
            jsonGenerator.a("client_mutation_id");
            jsonGenerator.b(mutableFlatBuffer.c(u_, 0));
        }
        jsonGenerator.g();
    }

    static {
        FbSerializerProvider.a(UserSemResTrackingMutationModel.class, new C0062xe66821d4());
    }
}
