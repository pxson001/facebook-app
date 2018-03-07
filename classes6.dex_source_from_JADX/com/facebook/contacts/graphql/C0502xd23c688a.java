package com.facebook.contacts.graphql;

import com.facebook.common.json.FbSerializerProvider;
import com.facebook.contacts.graphql.ContactGraphQLModels.ContactModel.RepresentedProfileModel.CurrentCityModel;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.nio.ByteBuffer;

/* compiled from: photo_ */
public class C0502xd23c688a extends JsonSerializer<CurrentCityModel> {
    public final void m11815a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        CurrentCityModel currentCityModel = (CurrentCityModel) obj;
        if (currentCityModel.w_() == null) {
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
            flatBufferBuilder.d(currentCityModel.a(flatBufferBuilder));
            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
            wrap.position(0);
            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
            currentCityModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
        }
        C0509x44beae5e.m11981a(currentCityModel.w_(), currentCityModel.u_(), jsonGenerator);
    }

    static {
        FbSerializerProvider.a(CurrentCityModel.class, new C0502xd23c688a());
    }
}
