package com.facebook.auth.protocol;

import com.facebook.auth.protocol.LoggedInUserQueryFragmentModels.LoggedInUserQueryFragmentModel;
import com.facebook.auth.protocol.LoggedInUserQueryFragmentParsers.LoggedInUserQueryFragmentParser;
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
public class C0150xd49217a0 extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(LoggedInUserQueryFragmentModel.class, new C0150xd49217a0());
    }

    public Object m3226a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
        flatBufferBuilder.d(LoggedInUserQueryFragmentParser.a(jsonParser, flatBufferBuilder));
        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
        wrap.position(0);
        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
        mutableFlatBuffer.a(4, Boolean.valueOf(true));
        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
        Object loggedInUserQueryFragmentModel = new LoggedInUserQueryFragmentModel();
        ((BaseModel) loggedInUserQueryFragmentModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
        if (loggedInUserQueryFragmentModel instanceof Postprocessable) {
            return ((Postprocessable) loggedInUserQueryFragmentModel).a();
        }
        return loggedInUserQueryFragmentModel;
    }
}
