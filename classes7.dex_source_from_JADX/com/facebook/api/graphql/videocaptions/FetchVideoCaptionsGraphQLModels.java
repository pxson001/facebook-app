package com.facebook.api.graphql.videocaptions;

import com.facebook.api.graphql.videocaptions.FetchVideoCaptionsGraphQLParsers.FetchVideoCaptionsGraphQLParser;
import com.facebook.api.graphql.videocaptions.FetchVideoCaptionsGraphQLParsers.FetchVideoCaptionsGraphQLParser.VideoCaptionsParser;
import com.facebook.api.graphql.videocaptions.FetchVideoCaptionsGraphQLParsers.FetchVideoCaptionsGraphQLParser.VideoCaptionsParser.VideoCaptionItemsParser;
import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbSerializerProvider;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.FragmentModelWithoutBridge;
import com.facebook.flatbuffers.ModelWithFlatBufferFormatHash;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import java.nio.ByteBuffer;
import java.util.List;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/* compiled from: video_delete_fail */
public class FetchVideoCaptionsGraphQLModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -400910572)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: video_delete_fail */
    public final class FetchVideoCaptionsGraphQLModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private List<VideoCaptionsModel> f596d;

        /* compiled from: video_delete_fail */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(FetchVideoCaptionsGraphQLModel.class, new Deserializer());
            }

            public Object m677a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(FetchVideoCaptionsGraphQLParser.m700a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object fetchVideoCaptionsGraphQLModel = new FetchVideoCaptionsGraphQLModel();
                ((BaseModel) fetchVideoCaptionsGraphQLModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (fetchVideoCaptionsGraphQLModel instanceof Postprocessable) {
                    return ((Postprocessable) fetchVideoCaptionsGraphQLModel).a();
                }
                return fetchVideoCaptionsGraphQLModel;
            }
        }

        /* compiled from: video_delete_fail */
        public class Serializer extends JsonSerializer<FetchVideoCaptionsGraphQLModel> {
            public final void m678a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                FetchVideoCaptionsGraphQLModel fetchVideoCaptionsGraphQLModel = (FetchVideoCaptionsGraphQLModel) obj;
                if (fetchVideoCaptionsGraphQLModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(fetchVideoCaptionsGraphQLModel.m693a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    fetchVideoCaptionsGraphQLModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = fetchVideoCaptionsGraphQLModel.w_();
                int u_ = fetchVideoCaptionsGraphQLModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("video_captions");
                    jsonGenerator.d();
                    for (int i = 0; i < mutableFlatBuffer.c(g); i++) {
                        VideoCaptionsParser.m699b(mutableFlatBuffer, mutableFlatBuffer.m(g, i), jsonGenerator, serializerProvider);
                    }
                    jsonGenerator.e();
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(FetchVideoCaptionsGraphQLModel.class, new Serializer());
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 610978575)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: video_delete_fail */
        public final class VideoCaptionsModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private String f594d;
            @Nullable
            private List<VideoCaptionItemsModel> f595e;

            /* compiled from: video_delete_fail */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(VideoCaptionsModel.class, new Deserializer());
                }

                public Object m679a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(VideoCaptionsParser.m698b(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object videoCaptionsModel = new VideoCaptionsModel();
                    ((BaseModel) videoCaptionsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (videoCaptionsModel instanceof Postprocessable) {
                        return ((Postprocessable) videoCaptionsModel).a();
                    }
                    return videoCaptionsModel;
                }
            }

            /* compiled from: video_delete_fail */
            public class Serializer extends JsonSerializer<VideoCaptionsModel> {
                public final void m680a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    VideoCaptionsModel videoCaptionsModel = (VideoCaptionsModel) obj;
                    if (videoCaptionsModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(videoCaptionsModel.m690a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        videoCaptionsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    VideoCaptionsParser.m699b(videoCaptionsModel.w_(), videoCaptionsModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(VideoCaptionsModel.class, new Serializer());
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = -1622279025)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: video_delete_fail */
            public final class VideoCaptionItemsModel extends BaseModel implements GraphQLVisitableModel {
                @Nullable
                private String f591d;
                private int f592e;
                private int f593f;

                /* compiled from: video_delete_fail */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(VideoCaptionItemsModel.class, new Deserializer());
                    }

                    public Object m681a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(VideoCaptionItemsParser.m697b(jsonParser, flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                        Object videoCaptionItemsModel = new VideoCaptionItemsModel();
                        ((BaseModel) videoCaptionItemsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                        if (videoCaptionItemsModel instanceof Postprocessable) {
                            return ((Postprocessable) videoCaptionItemsModel).a();
                        }
                        return videoCaptionItemsModel;
                    }
                }

                /* compiled from: video_delete_fail */
                public class Serializer extends JsonSerializer<VideoCaptionItemsModel> {
                    public final void m682a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        VideoCaptionItemsModel videoCaptionItemsModel = (VideoCaptionItemsModel) obj;
                        if (videoCaptionItemsModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(videoCaptionItemsModel.m683a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            videoCaptionItemsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        VideoCaptionItemsParser.m696a(videoCaptionItemsModel.w_(), videoCaptionItemsModel.u_(), jsonGenerator);
                    }

                    static {
                        FbSerializerProvider.a(VideoCaptionItemsModel.class, new Serializer());
                    }
                }

                public VideoCaptionItemsModel() {
                    super(3);
                }

                @Nullable
                public final String m685a() {
                    this.f591d = super.a(this.f591d, 0);
                    return this.f591d;
                }

                public final int m687j() {
                    a(0, 1);
                    return this.f592e;
                }

                public final int m688k() {
                    a(0, 2);
                    return this.f593f;
                }

                public final int jK_() {
                    return 973796030;
                }

                public final GraphQLVisitableModel m684a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    h();
                    i();
                    return this;
                }

                public final int m683a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int b = flatBufferBuilder.b(m685a());
                    flatBufferBuilder.c(3);
                    flatBufferBuilder.b(0, b);
                    flatBufferBuilder.a(1, this.f592e, 0);
                    flatBufferBuilder.a(2, this.f593f, 0);
                    i();
                    return flatBufferBuilder.d();
                }

                public final void m686a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                    super.a(mutableFlatBuffer, i, obj);
                    this.f592e = mutableFlatBuffer.a(i, 1, 0);
                    this.f593f = mutableFlatBuffer.a(i, 2, 0);
                }
            }

            public VideoCaptionsModel() {
                super(2);
            }

            @Nullable
            private String m689j() {
                this.f594d = super.a(this.f594d, 0);
                return this.f594d;
            }

            @Nonnull
            public final ImmutableList<VideoCaptionItemsModel> m692a() {
                this.f595e = super.a(this.f595e, 1, VideoCaptionItemsModel.class);
                return (ImmutableList) this.f595e;
            }

            public final int jK_() {
                return 569737483;
            }

            public final GraphQLVisitableModel m691a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m692a() != null) {
                    Builder a = ModelHelper.a(m692a(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        graphQLVisitableModel = (VideoCaptionsModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f595e = a.b();
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m690a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m689j());
                int a = ModelHelper.a(flatBufferBuilder, m692a());
                flatBufferBuilder.c(2);
                flatBufferBuilder.b(0, b);
                flatBufferBuilder.b(1, a);
                i();
                return flatBufferBuilder.d();
            }
        }

        public FetchVideoCaptionsGraphQLModel() {
            super(1);
        }

        @Nonnull
        public final ImmutableList<VideoCaptionsModel> m695a() {
            this.f596d = super.a(this.f596d, 0, VideoCaptionsModel.class);
            return (ImmutableList) this.f596d;
        }

        public final int jK_() {
            return 82650203;
        }

        public final GraphQLVisitableModel m694a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m695a() != null) {
                Builder a = ModelHelper.a(m695a(), graphQLModelMutatingVisitor);
                if (a != null) {
                    graphQLVisitableModel = (FetchVideoCaptionsGraphQLModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f596d = a.b();
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m693a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m695a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }
}
