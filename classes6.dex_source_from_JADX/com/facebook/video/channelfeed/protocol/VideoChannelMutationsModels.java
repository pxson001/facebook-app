package com.facebook.video.channelfeed.protocol;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbSerializerProvider;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.FragmentModelWithoutBridge;
import com.facebook.flatbuffers.ModelWithFlatBufferFormatHash;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.enums.GraphQLObjectType;
import com.facebook.graphql.enums.GraphQLSubscribeStatus;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.visitor.ConsistencyTuple;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLPersistableNode;
import com.facebook.graphql.visitor.GraphQLVisitableConsistentModel;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.facebook.video.channelfeed.protocol.VideoChannelMutationsParsers.VideoChannelFollowCoreMutationParser;
import com.facebook.video.channelfeed.protocol.VideoChannelMutationsParsers.VideoChannelFollowCoreMutationParser.VideoChannelParser;
import com.facebook.video.channelfeed.protocol.VideoChannelMutationsParsers.VideoChannelSubscribeCoreMutationParser;
import com.facebook.video.channelfeed.protocol.VideoChannelMutationsParsers.VideoChannelUnfollowCoreMutationParser;
import com.facebook.video.channelfeed.protocol.VideoChannelMutationsParsers.VideoChannelUnsubscribeCoreMutationParser;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.nio.ByteBuffer;
import javax.annotation.Nullable;

/* compiled from: contact_point */
public class VideoChannelMutationsModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -132807881)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: contact_point */
    public final class VideoChannelFollowCoreMutationModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private VideoChannelModel f18598d;

        /* compiled from: contact_point */
        public final class Builder {
            @Nullable
            public VideoChannelModel f18589a;

            public final VideoChannelFollowCoreMutationModel m27299a() {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                int a = ModelHelper.a(flatBufferBuilder, this.f18589a);
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.d(flatBufferBuilder.d());
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                return new VideoChannelFollowCoreMutationModel(new MutableFlatBuffer(wrap, null, null, true, null));
            }
        }

        /* compiled from: contact_point */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(VideoChannelFollowCoreMutationModel.class, new Deserializer());
            }

            public Object m27300a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = VideoChannelFollowCoreMutationParser.m27375a(jsonParser);
                Object videoChannelFollowCoreMutationModel = new VideoChannelFollowCoreMutationModel();
                ((BaseModel) videoChannelFollowCoreMutationModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (videoChannelFollowCoreMutationModel instanceof Postprocessable) {
                    return ((Postprocessable) videoChannelFollowCoreMutationModel).a();
                }
                return videoChannelFollowCoreMutationModel;
            }
        }

        /* compiled from: contact_point */
        public class Serializer extends JsonSerializer<VideoChannelFollowCoreMutationModel> {
            public final void m27301a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                VideoChannelFollowCoreMutationModel videoChannelFollowCoreMutationModel = (VideoChannelFollowCoreMutationModel) obj;
                if (videoChannelFollowCoreMutationModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(videoChannelFollowCoreMutationModel.m27316a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    videoChannelFollowCoreMutationModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = videoChannelFollowCoreMutationModel.w_();
                int u_ = videoChannelFollowCoreMutationModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("video_channel");
                    VideoChannelParser.m27374a(mutableFlatBuffer, g, jsonGenerator);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(VideoChannelFollowCoreMutationModel.class, new Serializer());
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -751522047)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: contact_point */
        public final class VideoChannelModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
            @Nullable
            private GraphQLObjectType f18594d;
            @Nullable
            private String f18595e;
            @Nullable
            private GraphQLSubscribeStatus f18596f;
            private boolean f18597g;

            /* compiled from: contact_point */
            public final class Builder {
                @Nullable
                public GraphQLObjectType f18590a;
                @Nullable
                public String f18591b;
                @Nullable
                public GraphQLSubscribeStatus f18592c;
                public boolean f18593d;
            }

            /* compiled from: contact_point */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(VideoChannelModel.class, new Deserializer());
                }

                public Object m27302a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(VideoChannelParser.m27373a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object videoChannelModel = new VideoChannelModel();
                    ((BaseModel) videoChannelModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (videoChannelModel instanceof Postprocessable) {
                        return ((Postprocessable) videoChannelModel).a();
                    }
                    return videoChannelModel;
                }
            }

            /* compiled from: contact_point */
            public class Serializer extends JsonSerializer<VideoChannelModel> {
                public final void m27303a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    VideoChannelModel videoChannelModel = (VideoChannelModel) obj;
                    if (videoChannelModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(videoChannelModel.m27309a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        videoChannelModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    VideoChannelParser.m27374a(videoChannelModel.w_(), videoChannelModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(VideoChannelModel.class, new Serializer());
                }
            }

            public VideoChannelModel() {
                super(4);
            }

            public VideoChannelModel(MutableFlatBuffer mutableFlatBuffer) {
                super(4);
                a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
            }

            public final void m27313a(String str, ConsistencyTuple consistencyTuple) {
                if ("video_channel_is_viewer_following".equals(str)) {
                    consistencyTuple.a = Boolean.valueOf(m27308m());
                    consistencyTuple.b = u_();
                    consistencyTuple.c = 3;
                    return;
                }
                consistencyTuple.a();
            }

            public final void m27314a(String str, Object obj, boolean z) {
                if ("video_channel_is_viewer_following".equals(str)) {
                    m27304a(((Boolean) obj).booleanValue());
                }
            }

            @Nullable
            private GraphQLObjectType m27305j() {
                if (this.b != null && this.f18594d == null) {
                    this.f18594d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
                }
                return this.f18594d;
            }

            @Nullable
            private String m27306k() {
                this.f18595e = super.a(this.f18595e, 1);
                return this.f18595e;
            }

            @Nullable
            private GraphQLSubscribeStatus m27307l() {
                this.f18596f = (GraphQLSubscribeStatus) super.b(this.f18596f, 2, GraphQLSubscribeStatus.class, GraphQLSubscribeStatus.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
                return this.f18596f;
            }

            private boolean m27308m() {
                a(0, 3);
                return this.f18597g;
            }

            private void m27304a(boolean z) {
                this.f18597g = z;
                if (this.b != null && this.b.d) {
                    this.b.a(this.c, 3, z);
                }
            }

            @Nullable
            public final String m27311a() {
                return m27306k();
            }

            public final int jK_() {
                return 756114472;
            }

            public final GraphQLVisitableModel m27310a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m27309a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m27305j());
                int b = flatBufferBuilder.b(m27306k());
                int a2 = flatBufferBuilder.a(m27307l());
                flatBufferBuilder.c(4);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.b(1, b);
                flatBufferBuilder.b(2, a2);
                flatBufferBuilder.a(3, this.f18597g);
                i();
                return flatBufferBuilder.d();
            }

            public final void m27312a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                super.a(mutableFlatBuffer, i, obj);
                this.f18597g = mutableFlatBuffer.a(i, 3);
            }
        }

        public VideoChannelFollowCoreMutationModel() {
            super(1);
        }

        public VideoChannelFollowCoreMutationModel(MutableFlatBuffer mutableFlatBuffer) {
            super(1);
            a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
        }

        @Nullable
        private VideoChannelModel m27315a() {
            this.f18598d = (VideoChannelModel) super.a(this.f18598d, 0, VideoChannelModel.class);
            return this.f18598d;
        }

        public final int jK_() {
            return -1187421484;
        }

        public final GraphQLVisitableModel m27317a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m27315a() != null) {
                VideoChannelModel videoChannelModel = (VideoChannelModel) graphQLModelMutatingVisitor.b(m27315a());
                if (m27315a() != videoChannelModel) {
                    graphQLVisitableModel = (VideoChannelFollowCoreMutationModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f18598d = videoChannelModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m27316a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m27315a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -2026396734)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: contact_point */
    public final class VideoChannelSubscribeCoreMutationModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private VideoChannelModel f18606d;

        /* compiled from: contact_point */
        public final class Builder {
            @Nullable
            public VideoChannelModel f18599a;

            public final VideoChannelSubscribeCoreMutationModel m27318a() {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                int a = ModelHelper.a(flatBufferBuilder, this.f18599a);
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.d(flatBufferBuilder.d());
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                return new VideoChannelSubscribeCoreMutationModel(new MutableFlatBuffer(wrap, null, null, true, null));
            }
        }

        /* compiled from: contact_point */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(VideoChannelSubscribeCoreMutationModel.class, new Deserializer());
            }

            public Object m27319a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = VideoChannelSubscribeCoreMutationParser.m27378a(jsonParser);
                Object videoChannelSubscribeCoreMutationModel = new VideoChannelSubscribeCoreMutationModel();
                ((BaseModel) videoChannelSubscribeCoreMutationModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (videoChannelSubscribeCoreMutationModel instanceof Postprocessable) {
                    return ((Postprocessable) videoChannelSubscribeCoreMutationModel).a();
                }
                return videoChannelSubscribeCoreMutationModel;
            }
        }

        /* compiled from: contact_point */
        public class Serializer extends JsonSerializer<VideoChannelSubscribeCoreMutationModel> {
            public final void m27320a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                VideoChannelSubscribeCoreMutationModel videoChannelSubscribeCoreMutationModel = (VideoChannelSubscribeCoreMutationModel) obj;
                if (videoChannelSubscribeCoreMutationModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(videoChannelSubscribeCoreMutationModel.m27334a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    videoChannelSubscribeCoreMutationModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = videoChannelSubscribeCoreMutationModel.w_();
                int u_ = videoChannelSubscribeCoreMutationModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("video_channel");
                    VideoChannelSubscribeCoreMutationParser.VideoChannelParser.m27377a(mutableFlatBuffer, g, jsonGenerator);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(VideoChannelSubscribeCoreMutationModel.class, new Serializer());
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -216303975)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: contact_point */
        public final class VideoChannelModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
            @Nullable
            private GraphQLObjectType f18603d;
            @Nullable
            private String f18604e;
            private boolean f18605f;

            /* compiled from: contact_point */
            public final class Builder {
                @Nullable
                public GraphQLObjectType f18600a;
                @Nullable
                public String f18601b;
                public boolean f18602c;
            }

            /* compiled from: contact_point */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(VideoChannelModel.class, new Deserializer());
                }

                public Object m27321a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(VideoChannelSubscribeCoreMutationParser.VideoChannelParser.m27376a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object videoChannelModel = new VideoChannelModel();
                    ((BaseModel) videoChannelModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (videoChannelModel instanceof Postprocessable) {
                        return ((Postprocessable) videoChannelModel).a();
                    }
                    return videoChannelModel;
                }
            }

            /* compiled from: contact_point */
            public class Serializer extends JsonSerializer<VideoChannelModel> {
                public final void m27322a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    VideoChannelModel videoChannelModel = (VideoChannelModel) obj;
                    if (videoChannelModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(videoChannelModel.m27327a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        videoChannelModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    VideoChannelSubscribeCoreMutationParser.VideoChannelParser.m27377a(videoChannelModel.w_(), videoChannelModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(VideoChannelModel.class, new Serializer());
                }
            }

            public VideoChannelModel() {
                super(3);
            }

            public VideoChannelModel(MutableFlatBuffer mutableFlatBuffer) {
                super(3);
                a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
            }

            public final void m27331a(String str, ConsistencyTuple consistencyTuple) {
                if ("video_channel_has_viewer_subscribed".equals(str)) {
                    consistencyTuple.a = Boolean.valueOf(m27326l());
                    consistencyTuple.b = u_();
                    consistencyTuple.c = 2;
                    return;
                }
                consistencyTuple.a();
            }

            public final void m27332a(String str, Object obj, boolean z) {
                if ("video_channel_has_viewer_subscribed".equals(str)) {
                    m27323a(((Boolean) obj).booleanValue());
                }
            }

            @Nullable
            private GraphQLObjectType m27324j() {
                if (this.b != null && this.f18603d == null) {
                    this.f18603d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
                }
                return this.f18603d;
            }

            @Nullable
            private String m27325k() {
                this.f18604e = super.a(this.f18604e, 1);
                return this.f18604e;
            }

            private boolean m27326l() {
                a(0, 2);
                return this.f18605f;
            }

            private void m27323a(boolean z) {
                this.f18605f = z;
                if (this.b != null && this.b.d) {
                    this.b.a(this.c, 2, z);
                }
            }

            @Nullable
            public final String m27329a() {
                return m27325k();
            }

            public final int jK_() {
                return 756114472;
            }

            public final GraphQLVisitableModel m27328a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m27327a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m27324j());
                int b = flatBufferBuilder.b(m27325k());
                flatBufferBuilder.c(3);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.b(1, b);
                flatBufferBuilder.a(2, this.f18605f);
                i();
                return flatBufferBuilder.d();
            }

            public final void m27330a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                super.a(mutableFlatBuffer, i, obj);
                this.f18605f = mutableFlatBuffer.a(i, 2);
            }
        }

        public VideoChannelSubscribeCoreMutationModel() {
            super(1);
        }

        public VideoChannelSubscribeCoreMutationModel(MutableFlatBuffer mutableFlatBuffer) {
            super(1);
            a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
        }

        @Nullable
        private VideoChannelModel m27333a() {
            this.f18606d = (VideoChannelModel) super.a(this.f18606d, 0, VideoChannelModel.class);
            return this.f18606d;
        }

        public final int jK_() {
            return -157141077;
        }

        public final GraphQLVisitableModel m27335a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m27333a() != null) {
                VideoChannelModel videoChannelModel = (VideoChannelModel) graphQLModelMutatingVisitor.b(m27333a());
                if (m27333a() != videoChannelModel) {
                    graphQLVisitableModel = (VideoChannelSubscribeCoreMutationModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f18606d = videoChannelModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m27334a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m27333a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 2061244894)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: contact_point */
    public final class VideoChannelUnfollowCoreMutationModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private VideoChannelModel f18612d;

        /* compiled from: contact_point */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(VideoChannelUnfollowCoreMutationModel.class, new Deserializer());
            }

            public Object m27336a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = VideoChannelUnfollowCoreMutationParser.m27381a(jsonParser);
                Object videoChannelUnfollowCoreMutationModel = new VideoChannelUnfollowCoreMutationModel();
                ((BaseModel) videoChannelUnfollowCoreMutationModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (videoChannelUnfollowCoreMutationModel instanceof Postprocessable) {
                    return ((Postprocessable) videoChannelUnfollowCoreMutationModel).a();
                }
                return videoChannelUnfollowCoreMutationModel;
            }
        }

        /* compiled from: contact_point */
        public class Serializer extends JsonSerializer<VideoChannelUnfollowCoreMutationModel> {
            public final void m27337a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                VideoChannelUnfollowCoreMutationModel videoChannelUnfollowCoreMutationModel = (VideoChannelUnfollowCoreMutationModel) obj;
                if (videoChannelUnfollowCoreMutationModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(videoChannelUnfollowCoreMutationModel.m27354a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    videoChannelUnfollowCoreMutationModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = videoChannelUnfollowCoreMutationModel.w_();
                int u_ = videoChannelUnfollowCoreMutationModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("video_channel");
                    VideoChannelUnfollowCoreMutationParser.VideoChannelParser.m27380a(mutableFlatBuffer, g, jsonGenerator);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(VideoChannelUnfollowCoreMutationModel.class, new Serializer());
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -22086157)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: contact_point */
        public final class VideoChannelModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
            @Nullable
            private GraphQLObjectType f18607d;
            @Nullable
            private String f18608e;
            @Nullable
            private GraphQLSubscribeStatus f18609f;
            private boolean f18610g;
            private boolean f18611h;

            /* compiled from: contact_point */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(VideoChannelModel.class, new Deserializer());
                }

                public Object m27338a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(VideoChannelUnfollowCoreMutationParser.VideoChannelParser.m27379a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object videoChannelModel = new VideoChannelModel();
                    ((BaseModel) videoChannelModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (videoChannelModel instanceof Postprocessable) {
                        return ((Postprocessable) videoChannelModel).a();
                    }
                    return videoChannelModel;
                }
            }

            /* compiled from: contact_point */
            public class Serializer extends JsonSerializer<VideoChannelModel> {
                public final void m27339a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    VideoChannelModel videoChannelModel = (VideoChannelModel) obj;
                    if (videoChannelModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(videoChannelModel.m27347a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        videoChannelModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    VideoChannelUnfollowCoreMutationParser.VideoChannelParser.m27380a(videoChannelModel.w_(), videoChannelModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(VideoChannelModel.class, new Serializer());
                }
            }

            public VideoChannelModel() {
                super(5);
            }

            public final void m27351a(String str, ConsistencyTuple consistencyTuple) {
                if ("video_channel_has_viewer_subscribed".equals(str)) {
                    consistencyTuple.a = Boolean.valueOf(m27345m());
                    consistencyTuple.b = u_();
                    consistencyTuple.c = 3;
                } else if ("video_channel_is_viewer_following".equals(str)) {
                    consistencyTuple.a = Boolean.valueOf(m27346n());
                    consistencyTuple.b = u_();
                    consistencyTuple.c = 4;
                } else {
                    consistencyTuple.a();
                }
            }

            public final void m27352a(String str, Object obj, boolean z) {
                if ("video_channel_has_viewer_subscribed".equals(str)) {
                    m27340a(((Boolean) obj).booleanValue());
                } else if ("video_channel_is_viewer_following".equals(str)) {
                    m27341b(((Boolean) obj).booleanValue());
                }
            }

            @Nullable
            private GraphQLObjectType m27342j() {
                if (this.b != null && this.f18607d == null) {
                    this.f18607d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
                }
                return this.f18607d;
            }

            @Nullable
            private String m27343k() {
                this.f18608e = super.a(this.f18608e, 1);
                return this.f18608e;
            }

            @Nullable
            private GraphQLSubscribeStatus m27344l() {
                this.f18609f = (GraphQLSubscribeStatus) super.b(this.f18609f, 2, GraphQLSubscribeStatus.class, GraphQLSubscribeStatus.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
                return this.f18609f;
            }

            private boolean m27345m() {
                a(0, 3);
                return this.f18610g;
            }

            private void m27340a(boolean z) {
                this.f18610g = z;
                if (this.b != null && this.b.d) {
                    this.b.a(this.c, 3, z);
                }
            }

            private boolean m27346n() {
                a(0, 4);
                return this.f18611h;
            }

            private void m27341b(boolean z) {
                this.f18611h = z;
                if (this.b != null && this.b.d) {
                    this.b.a(this.c, 4, z);
                }
            }

            @Nullable
            public final String m27349a() {
                return m27343k();
            }

            public final int jK_() {
                return 756114472;
            }

            public final GraphQLVisitableModel m27348a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m27347a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m27342j());
                int b = flatBufferBuilder.b(m27343k());
                int a2 = flatBufferBuilder.a(m27344l());
                flatBufferBuilder.c(5);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.b(1, b);
                flatBufferBuilder.b(2, a2);
                flatBufferBuilder.a(3, this.f18610g);
                flatBufferBuilder.a(4, this.f18611h);
                i();
                return flatBufferBuilder.d();
            }

            public final void m27350a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                super.a(mutableFlatBuffer, i, obj);
                this.f18610g = mutableFlatBuffer.a(i, 3);
                this.f18611h = mutableFlatBuffer.a(i, 4);
            }
        }

        public VideoChannelUnfollowCoreMutationModel() {
            super(1);
        }

        @Nullable
        private VideoChannelModel m27353a() {
            this.f18612d = (VideoChannelModel) super.a(this.f18612d, 0, VideoChannelModel.class);
            return this.f18612d;
        }

        public final int jK_() {
            return -825733157;
        }

        public final GraphQLVisitableModel m27355a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m27353a() != null) {
                VideoChannelModel videoChannelModel = (VideoChannelModel) graphQLModelMutatingVisitor.b(m27353a());
                if (m27353a() != videoChannelModel) {
                    graphQLVisitableModel = (VideoChannelUnfollowCoreMutationModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f18612d = videoChannelModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m27354a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m27353a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 1301513304)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: contact_point */
    public final class VideoChannelUnsubscribeCoreMutationModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private VideoChannelModel f18616d;

        /* compiled from: contact_point */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(VideoChannelUnsubscribeCoreMutationModel.class, new Deserializer());
            }

            public Object m27356a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = VideoChannelUnsubscribeCoreMutationParser.m27384a(jsonParser);
                Object videoChannelUnsubscribeCoreMutationModel = new VideoChannelUnsubscribeCoreMutationModel();
                ((BaseModel) videoChannelUnsubscribeCoreMutationModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (videoChannelUnsubscribeCoreMutationModel instanceof Postprocessable) {
                    return ((Postprocessable) videoChannelUnsubscribeCoreMutationModel).a();
                }
                return videoChannelUnsubscribeCoreMutationModel;
            }
        }

        /* compiled from: contact_point */
        public class Serializer extends JsonSerializer<VideoChannelUnsubscribeCoreMutationModel> {
            public final void m27357a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                VideoChannelUnsubscribeCoreMutationModel videoChannelUnsubscribeCoreMutationModel = (VideoChannelUnsubscribeCoreMutationModel) obj;
                if (videoChannelUnsubscribeCoreMutationModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(videoChannelUnsubscribeCoreMutationModel.m27371a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    videoChannelUnsubscribeCoreMutationModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = videoChannelUnsubscribeCoreMutationModel.w_();
                int u_ = videoChannelUnsubscribeCoreMutationModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("video_channel");
                    VideoChannelUnsubscribeCoreMutationParser.VideoChannelParser.m27383a(mutableFlatBuffer, g, jsonGenerator);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(VideoChannelUnsubscribeCoreMutationModel.class, new Serializer());
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -216303975)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: contact_point */
        public final class VideoChannelModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
            @Nullable
            private GraphQLObjectType f18613d;
            @Nullable
            private String f18614e;
            private boolean f18615f;

            /* compiled from: contact_point */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(VideoChannelModel.class, new Deserializer());
                }

                public Object m27358a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(VideoChannelUnsubscribeCoreMutationParser.VideoChannelParser.m27382a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object videoChannelModel = new VideoChannelModel();
                    ((BaseModel) videoChannelModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (videoChannelModel instanceof Postprocessable) {
                        return ((Postprocessable) videoChannelModel).a();
                    }
                    return videoChannelModel;
                }
            }

            /* compiled from: contact_point */
            public class Serializer extends JsonSerializer<VideoChannelModel> {
                public final void m27359a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    VideoChannelModel videoChannelModel = (VideoChannelModel) obj;
                    if (videoChannelModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(videoChannelModel.m27364a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        videoChannelModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    VideoChannelUnsubscribeCoreMutationParser.VideoChannelParser.m27383a(videoChannelModel.w_(), videoChannelModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(VideoChannelModel.class, new Serializer());
                }
            }

            public VideoChannelModel() {
                super(3);
            }

            public final void m27368a(String str, ConsistencyTuple consistencyTuple) {
                if ("video_channel_has_viewer_subscribed".equals(str)) {
                    consistencyTuple.a = Boolean.valueOf(m27363l());
                    consistencyTuple.b = u_();
                    consistencyTuple.c = 2;
                    return;
                }
                consistencyTuple.a();
            }

            public final void m27369a(String str, Object obj, boolean z) {
                if ("video_channel_has_viewer_subscribed".equals(str)) {
                    m27360a(((Boolean) obj).booleanValue());
                }
            }

            @Nullable
            private GraphQLObjectType m27361j() {
                if (this.b != null && this.f18613d == null) {
                    this.f18613d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
                }
                return this.f18613d;
            }

            @Nullable
            private String m27362k() {
                this.f18614e = super.a(this.f18614e, 1);
                return this.f18614e;
            }

            private boolean m27363l() {
                a(0, 2);
                return this.f18615f;
            }

            private void m27360a(boolean z) {
                this.f18615f = z;
                if (this.b != null && this.b.d) {
                    this.b.a(this.c, 2, z);
                }
            }

            @Nullable
            public final String m27366a() {
                return m27362k();
            }

            public final int jK_() {
                return 756114472;
            }

            public final GraphQLVisitableModel m27365a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m27364a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m27361j());
                int b = flatBufferBuilder.b(m27362k());
                flatBufferBuilder.c(3);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.b(1, b);
                flatBufferBuilder.a(2, this.f18615f);
                i();
                return flatBufferBuilder.d();
            }

            public final void m27367a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                super.a(mutableFlatBuffer, i, obj);
                this.f18615f = mutableFlatBuffer.a(i, 2);
            }
        }

        public VideoChannelUnsubscribeCoreMutationModel() {
            super(1);
        }

        @Nullable
        private VideoChannelModel m27370a() {
            this.f18616d = (VideoChannelModel) super.a(this.f18616d, 0, VideoChannelModel.class);
            return this.f18616d;
        }

        public final int jK_() {
            return -1173137084;
        }

        public final GraphQLVisitableModel m27372a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m27370a() != null) {
                VideoChannelModel videoChannelModel = (VideoChannelModel) graphQLModelMutatingVisitor.b(m27370a());
                if (m27370a() != videoChannelModel) {
                    graphQLVisitableModel = (VideoChannelUnsubscribeCoreMutationModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f18616d = videoChannelModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m27371a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m27370a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }
}
