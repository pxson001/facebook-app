package com.facebook.directinstall.util;

import com.facebook.common.json.FbSerializerProvider;
import com.facebook.directinstall.util.DirectInstallApplicationUtilsGraphQLModels.GetNativeAppDetailsActorGraphQLModel;
import com.facebook.directinstall.util.DirectInstallApplicationUtilsGraphQLParsers.GetNativeAppDetailsActorGraphQLParser.ProfilePictureParser;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.modelutil.SerializerHelpers;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.nio.ByteBuffer;

/* compiled from: ogActionType */
public class C0592x452a944b extends JsonSerializer<GetNativeAppDetailsActorGraphQLModel> {
    public final void m12570a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        MutableFlatBuffer mutableFlatBuffer;
        GetNativeAppDetailsActorGraphQLModel getNativeAppDetailsActorGraphQLModel = (GetNativeAppDetailsActorGraphQLModel) obj;
        if (getNativeAppDetailsActorGraphQLModel.w_() == null) {
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
            flatBufferBuilder.d(getNativeAppDetailsActorGraphQLModel.a(flatBufferBuilder));
            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
            wrap.position(0);
            mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
            getNativeAppDetailsActorGraphQLModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
        }
        mutableFlatBuffer = getNativeAppDetailsActorGraphQLModel.w_();
        int u_ = getNativeAppDetailsActorGraphQLModel.u_();
        jsonGenerator.f();
        if (mutableFlatBuffer.g(u_, 0) != 0) {
            jsonGenerator.a("__type__");
            SerializerHelpers.b(mutableFlatBuffer, u_, 0, jsonGenerator);
        }
        if (mutableFlatBuffer.g(u_, 1) != 0) {
            jsonGenerator.a("name");
            jsonGenerator.b(mutableFlatBuffer.c(u_, 1));
        }
        int g = mutableFlatBuffer.g(u_, 2);
        if (g != 0) {
            jsonGenerator.a("profile_picture");
            ProfilePictureParser.m12660a(mutableFlatBuffer, g, jsonGenerator);
        }
        jsonGenerator.g();
    }

    static {
        FbSerializerProvider.a(GetNativeAppDetailsActorGraphQLModel.class, new C0592x452a944b());
    }
}
