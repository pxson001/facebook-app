package com.facebook.ufiservices.util;

import com.facebook.common.json.FbSerializerProvider;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.ufiservices.util.LinkifyUtilGraphQLModels.LinkableUtilApplyAggregatedLinksGraphQLModel;
import com.facebook.ufiservices.util.LinkifyUtilGraphQLParsers.LinkableUtilApplyAggregatedLinksGraphQLParser.AggregatedRangesParser;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.nio.ByteBuffer;

/* compiled from: crop_profile_picture */
public class C1373xba87a85 extends JsonSerializer<LinkableUtilApplyAggregatedLinksGraphQLModel> {
    public final void m26907a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        MutableFlatBuffer mutableFlatBuffer;
        LinkableUtilApplyAggregatedLinksGraphQLModel linkableUtilApplyAggregatedLinksGraphQLModel = (LinkableUtilApplyAggregatedLinksGraphQLModel) obj;
        if (linkableUtilApplyAggregatedLinksGraphQLModel.w_() == null) {
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
            flatBufferBuilder.d(linkableUtilApplyAggregatedLinksGraphQLModel.a(flatBufferBuilder));
            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
            wrap.position(0);
            mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
            linkableUtilApplyAggregatedLinksGraphQLModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
        }
        mutableFlatBuffer = linkableUtilApplyAggregatedLinksGraphQLModel.w_();
        int u_ = linkableUtilApplyAggregatedLinksGraphQLModel.u_();
        jsonGenerator.f();
        int g = mutableFlatBuffer.g(u_, 0);
        if (g != 0) {
            jsonGenerator.a("aggregated_ranges");
            AggregatedRangesParser.m26947a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
        }
        if (mutableFlatBuffer.g(u_, 1) != 0) {
            jsonGenerator.a("text");
            jsonGenerator.b(mutableFlatBuffer.c(u_, 1));
        }
        jsonGenerator.g();
    }

    static {
        FbSerializerProvider.a(LinkableUtilApplyAggregatedLinksGraphQLModel.class, new C1373xba87a85());
    }
}
