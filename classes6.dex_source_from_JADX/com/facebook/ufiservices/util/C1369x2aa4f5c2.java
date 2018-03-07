package com.facebook.ufiservices.util;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.ufiservices.util.LinkifyUtilGraphQLModels.LinkableUtilApplyAggregatedLinksGraphQLModel.AggregatedRangesModel.SampleEntitiesModel;
import com.facebook.ufiservices.util.LinkifyUtilGraphQLParsers.LinkableUtilApplyAggregatedLinksGraphQLParser.AggregatedRangesParser.SampleEntitiesParser;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import java.nio.ByteBuffer;

/* compiled from: crop_profile_picture */
public class C1369x2aa4f5c2 extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(SampleEntitiesModel.class, new C1369x2aa4f5c2());
    }

    public Object m26903a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
        flatBufferBuilder.d(SampleEntitiesParser.m26944b(jsonParser, flatBufferBuilder));
        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
        wrap.position(0);
        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
        mutableFlatBuffer.a(4, Boolean.valueOf(true));
        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
        Object sampleEntitiesModel = new SampleEntitiesModel();
        ((BaseModel) sampleEntitiesModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
        if (sampleEntitiesModel instanceof Postprocessable) {
            return ((Postprocessable) sampleEntitiesModel).a();
        }
        return sampleEntitiesModel;
    }
}
