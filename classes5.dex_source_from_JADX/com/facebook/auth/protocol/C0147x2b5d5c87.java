package com.facebook.auth.protocol;

import com.facebook.auth.protocol.LoggedInUserQueryFragmentModels.LoggedInUserQueryFragmentModel.AllPhonesModel;
import com.facebook.auth.protocol.LoggedInUserQueryFragmentParsers.LoggedInUserQueryFragmentParser.AllPhonesParser;
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

/* compiled from: suggestion_text */
public class C0147x2b5d5c87 extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(AllPhonesModel.class, new C0147x2b5d5c87());
    }

    public Object m3218a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
        flatBufferBuilder.d(AllPhonesParser.b(jsonParser, flatBufferBuilder));
        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
        wrap.position(0);
        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
        mutableFlatBuffer.a(4, Boolean.valueOf(true));
        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
        Object allPhonesModel = new AllPhonesModel();
        ((BaseModel) allPhonesModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
        if (allPhonesModel instanceof Postprocessable) {
            return ((Postprocessable) allPhonesModel).a();
        }
        return allPhonesModel;
    }
}
