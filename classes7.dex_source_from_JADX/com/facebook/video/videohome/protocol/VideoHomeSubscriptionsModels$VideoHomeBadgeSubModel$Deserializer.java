package com.facebook.video.videohome.protocol;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.video.videohome.protocol.VideoHomeSubscriptionsModels.VideoHomeBadgeSubModel;
import com.facebook.video.videohome.protocol.VideoHomeSubscriptionsParsers.VideoHomeBadgeSubParser;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import java.nio.ByteBuffer;

/* compiled from: dict =  */
public class VideoHomeSubscriptionsModels$VideoHomeBadgeSubModel$Deserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(VideoHomeBadgeSubModel.class, new VideoHomeSubscriptionsModels$VideoHomeBadgeSubModel$Deserializer());
    }

    public Object m19758a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
        flatBufferBuilder.d(VideoHomeBadgeSubParser.m19761a(jsonParser, flatBufferBuilder));
        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
        wrap.position(0);
        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
        mutableFlatBuffer.a(4, Boolean.valueOf(true));
        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
        Object videoHomeBadgeSubModel = new VideoHomeBadgeSubModel();
        ((BaseModel) videoHomeBadgeSubModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
        if (videoHomeBadgeSubModel instanceof Postprocessable) {
            return ((Postprocessable) videoHomeBadgeSubModel).a();
        }
        return videoHomeBadgeSubModel;
    }
}
