package com.facebook.photos.creativeediting.model;

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
import com.facebook.photos.creativeediting.model.FetchFramePacksGraphQLParsers.FetchFramePacksQueryParser;
import com.facebook.photos.creativeediting.model.FetchFramePacksGraphQLParsers.FetchFramePacksQueryParser.SwipeableFramePacksParser;
import com.facebook.photos.creativeediting.model.FrameGraphQLModels.FramePackModel;
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

/* compiled from: swipeable_frame_packs */
public class FetchFramePacksGraphQLModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 1065251036)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: swipeable_frame_packs */
    public final class FetchFramePacksQueryModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private SwipeableFramePacksModel f3397d;

        /* compiled from: swipeable_frame_packs */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(FetchFramePacksQueryModel.class, new Deserializer());
            }

            public Object m4500a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = FetchFramePacksQueryParser.m4512a(jsonParser);
                Object fetchFramePacksQueryModel = new FetchFramePacksQueryModel();
                ((BaseModel) fetchFramePacksQueryModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (fetchFramePacksQueryModel instanceof Postprocessable) {
                    return ((Postprocessable) fetchFramePacksQueryModel).a();
                }
                return fetchFramePacksQueryModel;
            }
        }

        /* compiled from: swipeable_frame_packs */
        public class Serializer extends JsonSerializer<FetchFramePacksQueryModel> {
            public final void m4501a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                FetchFramePacksQueryModel fetchFramePacksQueryModel = (FetchFramePacksQueryModel) obj;
                if (fetchFramePacksQueryModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(fetchFramePacksQueryModel.m4507a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    fetchFramePacksQueryModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = fetchFramePacksQueryModel.w_();
                int u_ = fetchFramePacksQueryModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("swipeable_frame_packs");
                    SwipeableFramePacksParser.m4511a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(FetchFramePacksQueryModel.class, new Serializer());
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -401358520)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: swipeable_frame_packs */
        public final class SwipeableFramePacksModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private List<FramePackModel> f3396d;

            /* compiled from: swipeable_frame_packs */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(SwipeableFramePacksModel.class, new Deserializer());
                }

                public Object m4502a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(SwipeableFramePacksParser.m4510a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object swipeableFramePacksModel = new SwipeableFramePacksModel();
                    ((BaseModel) swipeableFramePacksModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (swipeableFramePacksModel instanceof Postprocessable) {
                        return ((Postprocessable) swipeableFramePacksModel).a();
                    }
                    return swipeableFramePacksModel;
                }
            }

            /* compiled from: swipeable_frame_packs */
            public class Serializer extends JsonSerializer<SwipeableFramePacksModel> {
                public final void m4503a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    SwipeableFramePacksModel swipeableFramePacksModel = (SwipeableFramePacksModel) obj;
                    if (swipeableFramePacksModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(swipeableFramePacksModel.m4504a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        swipeableFramePacksModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    SwipeableFramePacksParser.m4511a(swipeableFramePacksModel.w_(), swipeableFramePacksModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(SwipeableFramePacksModel.class, new Serializer());
                }
            }

            public SwipeableFramePacksModel() {
                super(1);
            }

            @Nonnull
            public final ImmutableList<FramePackModel> m4506a() {
                this.f3396d = super.a(this.f3396d, 0, FramePackModel.class);
                return (ImmutableList) this.f3396d;
            }

            public final int jK_() {
                return 588066390;
            }

            public final GraphQLVisitableModel m4505a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m4506a() != null) {
                    Builder a = ModelHelper.a(m4506a(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        graphQLVisitableModel = (SwipeableFramePacksModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f3396d = a.b();
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m4504a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m4506a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, a);
                i();
                return flatBufferBuilder.d();
            }
        }

        public FetchFramePacksQueryModel() {
            super(1);
        }

        @Nullable
        public final SwipeableFramePacksModel m4509a() {
            this.f3397d = (SwipeableFramePacksModel) super.a(this.f3397d, 0, SwipeableFramePacksModel.class);
            return this.f3397d;
        }

        public final int jK_() {
            return -1732764110;
        }

        public final GraphQLVisitableModel m4508a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m4509a() != null) {
                SwipeableFramePacksModel swipeableFramePacksModel = (SwipeableFramePacksModel) graphQLModelMutatingVisitor.b(m4509a());
                if (m4509a() != swipeableFramePacksModel) {
                    graphQLVisitableModel = (FetchFramePacksQueryModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f3397d = swipeableFramePacksModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m4507a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m4509a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }
}
