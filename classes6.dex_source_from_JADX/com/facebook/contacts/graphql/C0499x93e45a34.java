package com.facebook.contacts.graphql;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.contacts.graphql.ContactGraphQLModels.ContactModel.RepresentedProfileModel.BirthdateModel;
import com.facebook.contacts.graphql.ContactGraphQLParsers.ContactParser.RepresentedProfileParser.BirthdateParser;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.modelutil.BaseModel;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import java.nio.ByteBuffer;

/* compiled from: photo_ */
public class C0499x93e45a34 extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(BirthdateModel.class, new C0499x93e45a34());
    }

    public Object m11812a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
        flatBufferBuilder.d(BirthdateParser.a(jsonParser, flatBufferBuilder));
        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
        wrap.position(0);
        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
        mutableFlatBuffer.a(4, Boolean.valueOf(true));
        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
        Object birthdateModel = new BirthdateModel();
        ((BaseModel) birthdateModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
        if (birthdateModel instanceof Postprocessable) {
            return ((Postprocessable) birthdateModel).a();
        }
        return birthdateModel;
    }
}
