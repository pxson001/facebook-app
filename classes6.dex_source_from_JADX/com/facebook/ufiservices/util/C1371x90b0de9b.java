package com.facebook.ufiservices.util;

import com.facebook.common.json.FbSerializerProvider;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.ufiservices.util.LinkifyUtilGraphQLModels.LinkableUtilApplyAggregatedLinksGraphQLModel.AggregatedRangesModel;
import com.facebook.ufiservices.util.LinkifyUtilGraphQLParsers.LinkableUtilApplyAggregatedLinksGraphQLParser.AggregatedRangesParser;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.nio.ByteBuffer;

/* compiled from: crop_profile_picture */
public class C1371x90b0de9b extends JsonSerializer<AggregatedRangesModel> {
    public final void m26905a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        AggregatedRangesModel aggregatedRangesModel = (AggregatedRangesModel) obj;
        if (aggregatedRangesModel.w_() == null) {
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
            flatBufferBuilder.d(aggregatedRangesModel.a(flatBufferBuilder));
            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
            wrap.position(0);
            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
            aggregatedRangesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
        }
        AggregatedRangesParser.m26949b(aggregatedRangesModel.w_(), aggregatedRangesModel.u_(), jsonGenerator, serializerProvider);
    }

    static {
        FbSerializerProvider.a(AggregatedRangesModel.class, new C1371x90b0de9b());
    }
}
