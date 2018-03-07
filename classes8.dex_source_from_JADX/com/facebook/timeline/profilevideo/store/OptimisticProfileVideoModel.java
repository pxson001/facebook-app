package com.facebook.timeline.profilevideo.store;

import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.timeline.profilevideo.playback.protocol.FetchProfileVideoGraphQLModels.ProfileVideoHeaderFieldsModel;
import com.facebook.video.creativeediting.model.VideoCreativeEditingData;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import java.nio.ByteBuffer;

/* compiled from: mLastFour */
public final class OptimisticProfileVideoModel {
    public final String f9408a;
    public final ProfileVideoHeaderFieldsModel f9409b;
    public final long f9410c;
    public final VideoCreativeEditingData f9411d;
    public final float f9412e;

    /* compiled from: mLastFour */
    public class Builder {
        public String f9403a;
        public com.facebook.timeline.profilevideo.playback.protocol.FetchProfileVideoGraphQLModels.ProfileVideoHeaderFieldsModel.Builder f9404b;
        public long f9405c;
        public VideoCreativeEditingData f9406d;
        public float f9407e;

        public Builder() {
            this.f9404b = new com.facebook.timeline.profilevideo.playback.protocol.FetchProfileVideoGraphQLModels.ProfileVideoHeaderFieldsModel.Builder();
        }

        public Builder(OptimisticProfileVideoModel optimisticProfileVideoModel) {
            this.f9403a = optimisticProfileVideoModel.f9408a;
            ProfileVideoHeaderFieldsModel profileVideoHeaderFieldsModel = optimisticProfileVideoModel.f9409b;
            com.facebook.timeline.profilevideo.playback.protocol.FetchProfileVideoGraphQLModels.ProfileVideoHeaderFieldsModel.Builder builder = new com.facebook.timeline.profilevideo.playback.protocol.FetchProfileVideoGraphQLModels.ProfileVideoHeaderFieldsModel.Builder();
            builder.a = profileVideoHeaderFieldsModel.b();
            builder.b = profileVideoHeaderFieldsModel.c();
            this.f9404b = builder;
            this.f9405c = optimisticProfileVideoModel.f9410c;
            this.f9406d = optimisticProfileVideoModel.f9411d;
            this.f9407e = optimisticProfileVideoModel.f9412e;
        }

        public final OptimisticProfileVideoModel m11164a() {
            return new OptimisticProfileVideoModel(this);
        }

        public final Builder m11163a(String str) {
            this.f9403a = str;
            return this;
        }

        public final Builder m11165b(String str) {
            this.f9404b.a = str;
            return this;
        }

        public final Builder m11166c(String str) {
            this.f9404b.b = str;
            return this;
        }

        public final Builder m11161a(long j) {
            this.f9405c = j;
            return this;
        }

        public final Builder m11162a(VideoCreativeEditingData videoCreativeEditingData) {
            this.f9406d = videoCreativeEditingData;
            return this;
        }

        public final Builder m11160a(float f) {
            this.f9407e = f;
            return this;
        }
    }

    public OptimisticProfileVideoModel(Builder builder) {
        this.f9408a = (String) Preconditions.checkNotNull(builder.f9403a);
        com.facebook.timeline.profilevideo.playback.protocol.FetchProfileVideoGraphQLModels.ProfileVideoHeaderFieldsModel.Builder builder2 = builder.f9404b;
        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
        int b = flatBufferBuilder.b(builder2.a);
        int b2 = flatBufferBuilder.b(builder2.b);
        flatBufferBuilder.c(2);
        flatBufferBuilder.b(0, b);
        flatBufferBuilder.b(1, b2);
        flatBufferBuilder.d(flatBufferBuilder.d());
        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
        wrap.position(0);
        this.f9409b = (ProfileVideoHeaderFieldsModel) Preconditions.checkNotNull(new ProfileVideoHeaderFieldsModel(new MutableFlatBuffer(wrap, null, null, true, null)));
        Preconditions.checkNotNull(this.f9409b.b());
        Preconditions.checkNotNull(this.f9409b.c());
        this.f9410c = builder.f9405c;
        Preconditions.checkArgument(this.f9410c > 0);
        this.f9411d = builder.f9406d;
        this.f9412e = builder.f9407e;
    }

    public final String m11167b() {
        return this.f9409b.b();
    }

    public final String m11168c() {
        return this.f9409b.c();
    }

    public final String toString() {
        return Objects.toStringHelper(this).add("mSessionId", this.f9408a).add("playableUrl", m11168c()).add("videoFbId", m11167b()).add("mUpdateTime", this.f9410c).add("aspectRatio", this.f9412e).toString();
    }
}
