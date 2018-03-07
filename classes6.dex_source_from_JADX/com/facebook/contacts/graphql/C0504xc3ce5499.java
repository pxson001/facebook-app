package com.facebook.contacts.graphql;

import com.facebook.common.json.FbSerializerProvider;
import com.facebook.contacts.graphql.ContactGraphQLModels.ContactModel.RepresentedProfileModel;
import com.facebook.contacts.graphql.ContactGraphQLParsers.ContactParser.RepresentedProfileParser;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.nio.ByteBuffer;

/* compiled from: photo_ */
public class C0504xc3ce5499 extends JsonSerializer<RepresentedProfileModel> {
    public final void m11817a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        RepresentedProfileModel representedProfileModel = (RepresentedProfileModel) obj;
        if (representedProfileModel.w_() == null) {
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
            flatBufferBuilder.d(representedProfileModel.a(flatBufferBuilder));
            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
            wrap.position(0);
            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
            representedProfileModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
        }
        RepresentedProfileParser.a(representedProfileModel.w_(), representedProfileModel.u_(), jsonGenerator, serializerProvider);
    }

    static {
        FbSerializerProvider.a(RepresentedProfileModel.class, new C0504xc3ce5499());
    }
}
