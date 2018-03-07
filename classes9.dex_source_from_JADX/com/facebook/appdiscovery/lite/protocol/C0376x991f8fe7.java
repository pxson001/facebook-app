package com.facebook.appdiscovery.lite.protocol;

import com.facebook.appdiscovery.lite.protocol.AppFragmentsGraphQLModels.PlatformApplicationFragmentModel;
import com.facebook.appdiscovery.lite.protocol.AppFragmentsGraphQLParsers.PlatformApplicationFragmentParser;
import com.facebook.common.json.FbSerializerProvider;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.nio.ByteBuffer;

/* compiled from: sendInstantly */
public class C0376x991f8fe7 extends JsonSerializer<PlatformApplicationFragmentModel> {
    public final void m3961a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        PlatformApplicationFragmentModel platformApplicationFragmentModel = (PlatformApplicationFragmentModel) obj;
        if (platformApplicationFragmentModel.w_() == null) {
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
            flatBufferBuilder.d(platformApplicationFragmentModel.a(flatBufferBuilder));
            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
            wrap.position(0);
            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
            platformApplicationFragmentModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
        }
        PlatformApplicationFragmentParser.m4034a(platformApplicationFragmentModel.w_(), platformApplicationFragmentModel.u_(), jsonGenerator, serializerProvider);
    }

    static {
        FbSerializerProvider.a(PlatformApplicationFragmentModel.class, new C0376x991f8fe7());
    }
}
