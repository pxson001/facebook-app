package com.facebook.placetips.settings.graphql;

import com.facebook.common.json.FbSerializerProvider;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.placetips.settings.graphql.GravitySettingsGraphQlFragmentParsers.GravitySettingsGraphQlFragmentParser;
import com.facebook.placetips.settings.graphql.GravitySettingsQueryModels.GravitySettingsQueryModel;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.nio.ByteBuffer;

/* compiled from: rp_commerce_price_sort */
public class GravitySettingsQueryModels$GravitySettingsQueryModel$Serializer extends JsonSerializer<GravitySettingsQueryModel> {
    public final void m3920a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        MutableFlatBuffer mutableFlatBuffer;
        GravitySettingsQueryModel gravitySettingsQueryModel = (GravitySettingsQueryModel) obj;
        if (gravitySettingsQueryModel.w_() == null) {
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
            flatBufferBuilder.d(gravitySettingsQueryModel.a(flatBufferBuilder));
            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
            wrap.position(0);
            mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
            gravitySettingsQueryModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
        }
        mutableFlatBuffer = gravitySettingsQueryModel.w_();
        int u_ = gravitySettingsQueryModel.u_();
        jsonGenerator.f();
        int g = mutableFlatBuffer.g(u_, 0);
        if (g != 0) {
            jsonGenerator.a("viewer_gravity_settings");
            GravitySettingsGraphQlFragmentParser.a(mutableFlatBuffer, g, jsonGenerator);
        }
        jsonGenerator.g();
    }

    static {
        FbSerializerProvider.a(GravitySettingsQueryModel.class, new GravitySettingsQueryModels$GravitySettingsQueryModel$Serializer());
    }
}
