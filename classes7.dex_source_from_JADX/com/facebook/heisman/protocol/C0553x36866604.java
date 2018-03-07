package com.facebook.heisman.protocol;

import com.facebook.common.json.FbSerializerProvider;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.modelutil.SerializerHelpers;
import com.facebook.heisman.protocol.FetchImageOverlayGraphQLModels.ImageOverlayCameraTitleFieldsModel;
import com.facebook.heisman.protocol.FetchImageOverlayGraphQLParsers.CameraTitleFieldsParser;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.nio.ByteBuffer;

/* compiled from: possible_push_subscription_levels */
public class C0553x36866604 extends JsonSerializer<ImageOverlayCameraTitleFieldsModel> {
    public final void m7914a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        MutableFlatBuffer mutableFlatBuffer;
        ImageOverlayCameraTitleFieldsModel imageOverlayCameraTitleFieldsModel = (ImageOverlayCameraTitleFieldsModel) obj;
        if (imageOverlayCameraTitleFieldsModel.w_() == null) {
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
            flatBufferBuilder.d(imageOverlayCameraTitleFieldsModel.a(flatBufferBuilder));
            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
            wrap.position(0);
            mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
            imageOverlayCameraTitleFieldsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
        }
        mutableFlatBuffer = imageOverlayCameraTitleFieldsModel.w_();
        int u_ = imageOverlayCameraTitleFieldsModel.u_();
        jsonGenerator.f();
        if (mutableFlatBuffer.g(u_, 0) != 0) {
            jsonGenerator.a("__type__");
            SerializerHelpers.b(mutableFlatBuffer, u_, 0, jsonGenerator);
        }
        int g = mutableFlatBuffer.g(u_, 1);
        if (g != 0) {
            jsonGenerator.a("associated_pages");
            jsonGenerator.d();
            for (int i = 0; i < mutableFlatBuffer.c(g); i++) {
                CameraTitleFieldsParser.m7920b(mutableFlatBuffer, mutableFlatBuffer.m(g, i), jsonGenerator, serializerProvider);
            }
            jsonGenerator.e();
        }
        jsonGenerator.g();
    }

    static {
        FbSerializerProvider.a(ImageOverlayCameraTitleFieldsModel.class, new C0553x36866604());
    }
}
