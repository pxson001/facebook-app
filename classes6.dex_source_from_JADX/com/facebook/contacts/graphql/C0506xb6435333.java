package com.facebook.contacts.graphql;

import com.facebook.common.json.FbSerializerProvider;
import com.facebook.contacts.graphql.ContactGraphQLModels.ContactsSyncFullModel.PageInfoModel;
import com.facebook.contacts.graphql.ContactGraphQLParsers.ContactsSyncFullParser.PageInfoParser;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.nio.ByteBuffer;

/* compiled from: photo_ */
public class C0506xb6435333 extends JsonSerializer<PageInfoModel> {
    public final void m11832a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        PageInfoModel pageInfoModel = (PageInfoModel) obj;
        if (pageInfoModel.w_() == null) {
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
            flatBufferBuilder.d(pageInfoModel.a(flatBufferBuilder));
            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
            wrap.position(0);
            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
            pageInfoModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
        }
        PageInfoParser.a(pageInfoModel.w_(), pageInfoModel.u_(), jsonGenerator);
    }

    static {
        FbSerializerProvider.a(PageInfoModel.class, new C0506xb6435333());
    }
}
