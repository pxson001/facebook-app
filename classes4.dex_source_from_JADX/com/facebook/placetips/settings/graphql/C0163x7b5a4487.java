package com.facebook.placetips.settings.graphql;

import com.facebook.common.json.FbSerializerProvider;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.placetips.settings.graphql.GravitySettingsGraphQlFragmentModels.GravitySettingsGraphQlFragmentModel;
import com.facebook.placetips.settings.graphql.GravitySettingsGraphQlFragmentParsers.GravitySettingsGraphQlFragmentParser;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.nio.ByteBuffer;

/* compiled from: redirected_from_dbl */
public class C0163x7b5a4487 extends JsonSerializer<GravitySettingsGraphQlFragmentModel> {
    public final void m3930a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        GravitySettingsGraphQlFragmentModel gravitySettingsGraphQlFragmentModel = (GravitySettingsGraphQlFragmentModel) obj;
        if (gravitySettingsGraphQlFragmentModel.w_() == null) {
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
            flatBufferBuilder.d(gravitySettingsGraphQlFragmentModel.a(flatBufferBuilder));
            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
            wrap.position(0);
            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
            gravitySettingsGraphQlFragmentModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
        }
        GravitySettingsGraphQlFragmentParser.a(gravitySettingsGraphQlFragmentModel.w_(), gravitySettingsGraphQlFragmentModel.u_(), jsonGenerator);
    }

    static {
        FbSerializerProvider.m277a(GravitySettingsGraphQlFragmentModel.class, new C0163x7b5a4487());
    }
}
