package com.facebook.contacts.graphql;

import com.facebook.common.json.FbSerializerProvider;
import com.facebook.contacts.graphql.ContactGraphQLModels.ContactModel.RepresentedProfileModel.BirthdateModel;
import com.facebook.contacts.graphql.ContactGraphQLParsers.ContactParser.RepresentedProfileParser.BirthdateParser;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.nio.ByteBuffer;

/* compiled from: photo_ */
public class C0500x49091f33 extends JsonSerializer<BirthdateModel> {
    public final void m11813a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        BirthdateModel birthdateModel = (BirthdateModel) obj;
        if (birthdateModel.w_() == null) {
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
            flatBufferBuilder.d(birthdateModel.a(flatBufferBuilder));
            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
            wrap.position(0);
            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
            birthdateModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
        }
        BirthdateParser.a(birthdateModel.w_(), birthdateModel.u_(), jsonGenerator);
    }

    static {
        FbSerializerProvider.a(BirthdateModel.class, new C0500x49091f33());
    }
}
