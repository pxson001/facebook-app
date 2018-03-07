package com.facebook.appdiscovery.lite.protocol;

import com.facebook.appdiscovery.lite.protocol.AppFragmentsGraphQLModels.PlatformApplicationFragmentModel;
import com.facebook.appdiscovery.lite.protocol.AppFragmentsGraphQLParsers.PlatformApplicationFragmentParser;
import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.modelutil.BaseModel;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import java.nio.ByteBuffer;

/* compiled from: sendInstantly */
public class C0371x38216de8 extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(PlatformApplicationFragmentModel.class, new C0371x38216de8());
    }

    public Object m3937a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
        flatBufferBuilder.d(PlatformApplicationFragmentParser.m4033a(jsonParser, flatBufferBuilder));
        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
        wrap.position(0);
        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
        mutableFlatBuffer.a(4, Boolean.valueOf(true));
        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
        Object platformApplicationFragmentModel = new PlatformApplicationFragmentModel();
        ((BaseModel) platformApplicationFragmentModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
        if (platformApplicationFragmentModel instanceof Postprocessable) {
            return ((Postprocessable) platformApplicationFragmentModel).a();
        }
        return platformApplicationFragmentModel;
    }
}
