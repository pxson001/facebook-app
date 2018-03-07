package com.facebook.video.commercialbreak.protocol;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbSerializerProvider;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.FragmentModelWithBridge;
import com.facebook.flatbuffers.ModelWithFlatBufferFormatHash;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.facebook.video.commercialbreak.protocol.FetchInstreamVideoAdsParsers.InstreamVideoAdsQueryParser;
import com.facebook.video.commercialbreak.protocol.FetchInstreamVideoAdsParsers.InstreamVideoAdsQueryParser.InstreamVideoAdsParser;
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

/* compiled from: location_settings_perf_init */
public class FetchInstreamVideoAdsModels {

    @FragmentModelWithBridge
    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 741291682)
    @JsonSerialize(using = Serializer.class)
    /* compiled from: location_settings_perf_init */
    public final class InstreamVideoAdsQueryModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private InstreamVideoAdsModel f9781d;

        /* compiled from: location_settings_perf_init */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(InstreamVideoAdsQueryModel.class, new Deserializer());
            }

            public Object m11465a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = InstreamVideoAdsQueryParser.m11477a(jsonParser);
                Object instreamVideoAdsQueryModel = new InstreamVideoAdsQueryModel();
                ((BaseModel) instreamVideoAdsQueryModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (instreamVideoAdsQueryModel instanceof Postprocessable) {
                    return ((Postprocessable) instreamVideoAdsQueryModel).a();
                }
                return instreamVideoAdsQueryModel;
            }
        }

        @FragmentModelWithBridge
        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 260088323)
        @JsonSerialize(using = Serializer.class)
        /* compiled from: location_settings_perf_init */
        public final class InstreamVideoAdsModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private List<GraphQLStory> f9780d;

            /* compiled from: location_settings_perf_init */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(InstreamVideoAdsModel.class, new Deserializer());
                }

                public Object m11466a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(InstreamVideoAdsParser.m11475a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object instreamVideoAdsModel = new InstreamVideoAdsModel();
                    ((BaseModel) instreamVideoAdsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (instreamVideoAdsModel instanceof Postprocessable) {
                        return ((Postprocessable) instreamVideoAdsModel).a();
                    }
                    return instreamVideoAdsModel;
                }
            }

            /* compiled from: location_settings_perf_init */
            public class Serializer extends JsonSerializer<InstreamVideoAdsModel> {
                public final void m11467a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    InstreamVideoAdsModel instreamVideoAdsModel = (InstreamVideoAdsModel) obj;
                    if (instreamVideoAdsModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(instreamVideoAdsModel.m11468a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        instreamVideoAdsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    InstreamVideoAdsParser.m11476a(instreamVideoAdsModel.w_(), instreamVideoAdsModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(InstreamVideoAdsModel.class, new Serializer());
                }
            }

            public InstreamVideoAdsModel() {
                super(1);
            }

            @Nonnull
            public final ImmutableList<GraphQLStory> m11470a() {
                this.f9780d = super.a(this.f9780d, 0, GraphQLStory.class);
                return (ImmutableList) this.f9780d;
            }

            public final int jK_() {
                return -1224070952;
            }

            public final GraphQLVisitableModel m11469a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m11470a() != null) {
                    Builder a = ModelHelper.a(m11470a(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        graphQLVisitableModel = (InstreamVideoAdsModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f9780d = a.b();
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m11468a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m11470a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, a);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: location_settings_perf_init */
        public class Serializer extends JsonSerializer<InstreamVideoAdsQueryModel> {
            public final void m11471a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                InstreamVideoAdsQueryModel instreamVideoAdsQueryModel = (InstreamVideoAdsQueryModel) obj;
                if (instreamVideoAdsQueryModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(instreamVideoAdsQueryModel.m11472a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    instreamVideoAdsQueryModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = instreamVideoAdsQueryModel.w_();
                int u_ = instreamVideoAdsQueryModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("instream_video_ads");
                    InstreamVideoAdsParser.m11476a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(InstreamVideoAdsQueryModel.class, new Serializer());
            }
        }

        public InstreamVideoAdsQueryModel() {
            super(1);
        }

        @Nullable
        public final InstreamVideoAdsModel m11474a() {
            this.f9781d = (InstreamVideoAdsModel) super.a(this.f9781d, 0, InstreamVideoAdsModel.class);
            return this.f9781d;
        }

        public final int jK_() {
            return -1732764110;
        }

        public final GraphQLVisitableModel m11473a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m11474a() != null) {
                InstreamVideoAdsModel instreamVideoAdsModel = (InstreamVideoAdsModel) graphQLModelMutatingVisitor.b(m11474a());
                if (m11474a() != instreamVideoAdsModel) {
                    graphQLVisitableModel = (InstreamVideoAdsQueryModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f9781d = instreamVideoAdsModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m11472a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m11474a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }
}
