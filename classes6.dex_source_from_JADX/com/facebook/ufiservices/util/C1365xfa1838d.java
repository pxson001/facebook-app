package com.facebook.ufiservices.util;

import com.facebook.common.json.FbSerializerProvider;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.ufiservices.util.LinkifyUtilGraphQLModels.LinkableUtilApplyActorsLinksGraphQLModel.RangesModel.EntityModel;
import com.facebook.ufiservices.util.LinkifyUtilGraphQLParsers.LinkableUtilApplyActorsLinksGraphQLParser.RangesParser.EntityParser;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.nio.ByteBuffer;

/* compiled from: crop_profile_picture */
public class C1365xfa1838d extends JsonSerializer<EntityModel> {
    public final void m26899a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        EntityModel entityModel = (EntityModel) obj;
        if (entityModel.w_() == null) {
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
            flatBufferBuilder.d(entityModel.a(flatBufferBuilder));
            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
            wrap.position(0);
            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
            entityModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
        }
        EntityParser.m26937a(entityModel.w_(), entityModel.u_(), jsonGenerator, serializerProvider);
    }

    static {
        FbSerializerProvider.a(EntityModel.class, new C1365xfa1838d());
    }
}
