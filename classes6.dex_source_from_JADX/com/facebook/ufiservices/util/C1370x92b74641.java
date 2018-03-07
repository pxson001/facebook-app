package com.facebook.ufiservices.util;

import com.facebook.common.json.FbSerializerProvider;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.ufiservices.util.LinkifyUtilGraphQLModels.LinkableUtilApplyAggregatedLinksGraphQLModel.AggregatedRangesModel.SampleEntitiesModel;
import com.facebook.ufiservices.util.LinkifyUtilGraphQLParsers.LinkableUtilApplyAggregatedLinksGraphQLParser.AggregatedRangesParser.SampleEntitiesParser;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.nio.ByteBuffer;

/* compiled from: crop_profile_picture */
public class C1370x92b74641 extends JsonSerializer<SampleEntitiesModel> {
    public final void m26904a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        SampleEntitiesModel sampleEntitiesModel = (SampleEntitiesModel) obj;
        if (sampleEntitiesModel.w_() == null) {
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
            flatBufferBuilder.d(sampleEntitiesModel.a(flatBufferBuilder));
            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
            wrap.position(0);
            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
            sampleEntitiesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
        }
        SampleEntitiesParser.m26945b(sampleEntitiesModel.w_(), sampleEntitiesModel.u_(), jsonGenerator, serializerProvider);
    }

    static {
        FbSerializerProvider.a(SampleEntitiesModel.class, new C1370x92b74641());
    }
}
