package com.facebook.api.feed.subscriptions;

import com.facebook.api.feed.subscriptions.LiveVideoStatusSubscriptionsParsers.LiveVideoStatusUpdateSubscriptionParser;
import com.facebook.api.feed.subscriptions.LiveVideoStatusSubscriptionsParsers.LiveVideoStatusUpdateSubscriptionParser.VideoParser;
import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbSerializerProvider;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.FragmentModelWithoutBridge;
import com.facebook.flatbuffers.ModelWithFlatBufferFormatHash;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.enums.GraphQLVideoBroadcastStatus;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLPersistableNode;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.facebook.reviews.protocol.graphql.UserReviewsFragmentsParsers.UserReviewsParser;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.nio.ByteBuffer;
import javax.annotation.Nullable;

/* compiled from: artifact_size_description */
public class LiveVideoStatusSubscriptionsModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 537701949)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: artifact_size_description */
    public final class LiveVideoStatusUpdateSubscriptionModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private VideoModel f8782d;

        /* compiled from: artifact_size_description */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(LiveVideoStatusUpdateSubscriptionModel.class, new Deserializer());
            }

            public Object m14679a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = LiveVideoStatusUpdateSubscriptionParser.m14692a(jsonParser);
                Object liveVideoStatusUpdateSubscriptionModel = new LiveVideoStatusUpdateSubscriptionModel();
                ((BaseModel) liveVideoStatusUpdateSubscriptionModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (liveVideoStatusUpdateSubscriptionModel instanceof Postprocessable) {
                    return ((Postprocessable) liveVideoStatusUpdateSubscriptionModel).a();
                }
                return liveVideoStatusUpdateSubscriptionModel;
            }
        }

        /* compiled from: artifact_size_description */
        public class Serializer extends JsonSerializer<LiveVideoStatusUpdateSubscriptionModel> {
            public final void m14680a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                LiveVideoStatusUpdateSubscriptionModel liveVideoStatusUpdateSubscriptionModel = (LiveVideoStatusUpdateSubscriptionModel) obj;
                if (liveVideoStatusUpdateSubscriptionModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(liveVideoStatusUpdateSubscriptionModel.m14688a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    liveVideoStatusUpdateSubscriptionModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = liveVideoStatusUpdateSubscriptionModel.w_();
                int u_ = liveVideoStatusUpdateSubscriptionModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("video");
                    UserReviewsParser.a(mutableFlatBuffer, g, jsonGenerator);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(LiveVideoStatusUpdateSubscriptionModel.class, new Serializer());
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 1825347743)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: artifact_size_description */
        public final class VideoModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel {
            @Nullable
            private GraphQLVideoBroadcastStatus f8780d;
            @Nullable
            private String f8781e;

            /* compiled from: artifact_size_description */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(VideoModel.class, new Deserializer());
                }

                public Object m14681a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(VideoParser.m14691a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object videoModel = new VideoModel();
                    ((BaseModel) videoModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (videoModel instanceof Postprocessable) {
                        return ((Postprocessable) videoModel).a();
                    }
                    return videoModel;
                }
            }

            /* compiled from: artifact_size_description */
            public class Serializer extends JsonSerializer<VideoModel> {
                public final void m14682a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    VideoModel videoModel = (VideoModel) obj;
                    if (videoModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(videoModel.m14683a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        videoModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    UserReviewsParser.a(videoModel.w_(), videoModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(VideoModel.class, new Serializer());
                }
            }

            public VideoModel() {
                super(2);
            }

            @Nullable
            public final GraphQLVideoBroadcastStatus m14686j() {
                this.f8780d = (GraphQLVideoBroadcastStatus) super.b(this.f8780d, 0, GraphQLVideoBroadcastStatus.class, GraphQLVideoBroadcastStatus.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
                return this.f8780d;
            }

            @Nullable
            public final String m14687k() {
                this.f8781e = super.a(this.f8781e, 1);
                return this.f8781e;
            }

            @Nullable
            public final String m14685a() {
                return m14687k();
            }

            public final int jK_() {
                return 82650203;
            }

            public final GraphQLVisitableModel m14684a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m14683a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = flatBufferBuilder.a(m14686j());
                int b = flatBufferBuilder.b(m14687k());
                flatBufferBuilder.c(2);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.b(1, b);
                i();
                return flatBufferBuilder.d();
            }
        }

        public LiveVideoStatusUpdateSubscriptionModel() {
            super(1);
        }

        @Nullable
        public final VideoModel m14689a() {
            this.f8782d = (VideoModel) super.a(this.f8782d, 0, VideoModel.class);
            return this.f8782d;
        }

        public final int jK_() {
            return 1760485296;
        }

        public final GraphQLVisitableModel m14690a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m14689a() != null) {
                VideoModel videoModel = (VideoModel) graphQLModelMutatingVisitor.b(m14689a());
                if (m14689a() != videoModel) {
                    graphQLVisitableModel = (LiveVideoStatusUpdateSubscriptionModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f8782d = videoModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m14688a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m14689a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }
}
