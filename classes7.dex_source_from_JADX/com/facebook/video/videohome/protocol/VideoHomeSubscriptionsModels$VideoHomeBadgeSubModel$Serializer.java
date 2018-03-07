package com.facebook.video.videohome.protocol;

import com.facebook.common.json.FbSerializerProvider;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.video.videohome.protocol.VideoHomeSubscriptionsModels.VideoHomeBadgeSubModel;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.nio.ByteBuffer;

/* compiled from: dict =  */
public class VideoHomeSubscriptionsModels$VideoHomeBadgeSubModel$Serializer extends JsonSerializer<VideoHomeBadgeSubModel> {
    public final void m19759a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        MutableFlatBuffer mutableFlatBuffer;
        VideoHomeBadgeSubModel videoHomeBadgeSubModel = (VideoHomeBadgeSubModel) obj;
        if (videoHomeBadgeSubModel.w_() == null) {
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
            flatBufferBuilder.d(videoHomeBadgeSubModel.a(flatBufferBuilder));
            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
            wrap.position(0);
            mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
            videoHomeBadgeSubModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
        }
        mutableFlatBuffer = videoHomeBadgeSubModel.w_();
        int u_ = videoHomeBadgeSubModel.u_();
        jsonGenerator.f();
        int a = mutableFlatBuffer.a(u_, 0, 0);
        if (a != 0) {
            jsonGenerator.a("video_home_badge_count");
            jsonGenerator.b(a);
        }
        if (mutableFlatBuffer.g(u_, 1) != 0) {
            jsonGenerator.a("video_home_badge_update_reason");
            jsonGenerator.b(mutableFlatBuffer.b(u_, 1));
        }
        a = mutableFlatBuffer.a(u_, 2, 0);
        if (a != 0) {
            jsonGenerator.a("video_home_max_badge_count");
            jsonGenerator.b(a);
        }
        a = mutableFlatBuffer.a(u_, 3, 0);
        if (a != 0) {
            jsonGenerator.a("video_home_prefetch_unit_count");
            jsonGenerator.b(a);
        }
        jsonGenerator.g();
    }

    static {
        FbSerializerProvider.a(VideoHomeBadgeSubModel.class, new VideoHomeSubscriptionsModels$VideoHomeBadgeSubModel$Serializer());
    }
}
