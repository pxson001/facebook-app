package com.facebook.ufiservices.util;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.ufiservices.util.LinkifyUtilGraphQLModels.LinkableUtilApplyAggregatedLinksGraphQLModel.AggregatedRangesModel;
import com.facebook.ufiservices.util.LinkifyUtilGraphQLParsers.LinkableUtilApplyAggregatedLinksGraphQLParser.AggregatedRangesParser;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import java.nio.ByteBuffer;

/* compiled from: crop_profile_picture */
public class C1368x9099df9c extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(AggregatedRangesModel.class, new C1368x9099df9c());
    }

    public Object m26902a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
        flatBufferBuilder.d(AggregatedRangesParser.m26948b(jsonParser, flatBufferBuilder));
        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
        wrap.position(0);
        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
        mutableFlatBuffer.a(4, Boolean.valueOf(true));
        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
        Object aggregatedRangesModel = new AggregatedRangesModel();
        ((BaseModel) aggregatedRangesModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
        if (aggregatedRangesModel instanceof Postprocessable) {
            return ((Postprocessable) aggregatedRangesModel).a();
        }
        return aggregatedRangesModel;
    }
}
