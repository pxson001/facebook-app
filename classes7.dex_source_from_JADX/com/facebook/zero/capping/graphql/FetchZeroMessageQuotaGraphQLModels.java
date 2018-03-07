package com.facebook.zero.capping.graphql;

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
import com.facebook.zero.capping.graphql.FetchZeroMessageQuotaGraphQLParsers.FetchZeroMessageQuotaQueryParser;
import com.facebook.zero.capping.graphql.FetchZeroMessageQuotaGraphQLParsers.FetchZeroMessageQuotaQueryParser.FreeFacebookMessageQuotaParser;
import com.facebook.zero.capping.graphql.FetchZeroMessageQuotaGraphQLParsers.FetchZeroMessageQuotaQueryParser.FreeFacebookMessageQuotaParser.RewriteRuleParser;
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

/* compiled from: ्आ */
public class FetchZeroMessageQuotaGraphQLModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -1138623468)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: ्आ */
    public final class FetchZeroMessageQuotaQueryModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private FreeFacebookMessageQuotaModel f91d;

        /* compiled from: ्आ */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(FetchZeroMessageQuotaQueryModel.class, new Deserializer());
            }

            public Object m64a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = FetchZeroMessageQuotaQueryParser.m87a(jsonParser);
                Object fetchZeroMessageQuotaQueryModel = new FetchZeroMessageQuotaQueryModel();
                ((BaseModel) fetchZeroMessageQuotaQueryModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (fetchZeroMessageQuotaQueryModel instanceof Postprocessable) {
                    return ((Postprocessable) fetchZeroMessageQuotaQueryModel).a();
                }
                return fetchZeroMessageQuotaQueryModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 14304566)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: ्आ */
        public final class FreeFacebookMessageQuotaModel extends BaseModel implements GraphQLVisitableModel {
            private long f85d;
            @Nullable
            private List<String> f86e;
            @Nullable
            private List<com.facebook.zero.protocol.graphql.ZeroTokenGraphQLModels.RewriteRuleModel> f87f;
            private int f88g;
            @Nullable
            private RewriteRuleModel f89h;
            private int f90i;

            /* compiled from: ्आ */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(FreeFacebookMessageQuotaModel.class, new Deserializer());
                }

                public Object m65a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(FreeFacebookMessageQuotaParser.m85a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object freeFacebookMessageQuotaModel = new FreeFacebookMessageQuotaModel();
                    ((BaseModel) freeFacebookMessageQuotaModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (freeFacebookMessageQuotaModel instanceof Postprocessable) {
                        return ((Postprocessable) freeFacebookMessageQuotaModel).a();
                    }
                    return freeFacebookMessageQuotaModel;
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = 1778077682)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: ्आ */
            public final class RewriteRuleModel extends BaseModel implements GraphQLVisitableModel {
                @Nullable
                private String f83d;
                @Nullable
                private String f84e;

                /* compiled from: ्आ */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(RewriteRuleModel.class, new Deserializer());
                    }

                    public Object m66a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(RewriteRuleParser.m83a(jsonParser, flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                        Object rewriteRuleModel = new RewriteRuleModel();
                        ((BaseModel) rewriteRuleModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                        if (rewriteRuleModel instanceof Postprocessable) {
                            return ((Postprocessable) rewriteRuleModel).a();
                        }
                        return rewriteRuleModel;
                    }
                }

                /* compiled from: ्आ */
                public class Serializer extends JsonSerializer<RewriteRuleModel> {
                    public final void m67a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        RewriteRuleModel rewriteRuleModel = (RewriteRuleModel) obj;
                        if (rewriteRuleModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(rewriteRuleModel.m70a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            rewriteRuleModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        RewriteRuleParser.m84a(rewriteRuleModel.w_(), rewriteRuleModel.u_(), jsonGenerator);
                    }

                    static {
                        FbSerializerProvider.a(RewriteRuleModel.class, new Serializer());
                    }
                }

                public RewriteRuleModel() {
                    super(2);
                }

                @Nullable
                private String m68a() {
                    this.f83d = super.a(this.f83d, 0);
                    return this.f83d;
                }

                @Nullable
                private String m69j() {
                    this.f84e = super.a(this.f84e, 1);
                    return this.f84e;
                }

                public final int jK_() {
                    return -1646467625;
                }

                public final GraphQLVisitableModel m71a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    h();
                    i();
                    return this;
                }

                public final int m70a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int b = flatBufferBuilder.b(m68a());
                    int b2 = flatBufferBuilder.b(m69j());
                    flatBufferBuilder.c(2);
                    flatBufferBuilder.b(0, b);
                    flatBufferBuilder.b(1, b2);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            /* compiled from: ्आ */
            public class Serializer extends JsonSerializer<FreeFacebookMessageQuotaModel> {
                public final void m72a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    FreeFacebookMessageQuotaModel freeFacebookMessageQuotaModel = (FreeFacebookMessageQuotaModel) obj;
                    if (freeFacebookMessageQuotaModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(freeFacebookMessageQuotaModel.m76a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        freeFacebookMessageQuotaModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    FreeFacebookMessageQuotaParser.m86a(freeFacebookMessageQuotaModel.w_(), freeFacebookMessageQuotaModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(FreeFacebookMessageQuotaModel.class, new Serializer());
                }
            }

            public FreeFacebookMessageQuotaModel() {
                super(6);
            }

            @Nonnull
            private ImmutableList<String> m73a() {
                this.f86e = super.a(this.f86e, 1);
                return (ImmutableList) this.f86e;
            }

            @Nonnull
            private ImmutableList<com.facebook.zero.protocol.graphql.ZeroTokenGraphQLModels.RewriteRuleModel> m74j() {
                this.f87f = super.a(this.f87f, 2, com.facebook.zero.protocol.graphql.ZeroTokenGraphQLModels.RewriteRuleModel.class);
                return (ImmutableList) this.f87f;
            }

            @Nullable
            private RewriteRuleModel m75k() {
                this.f89h = (RewriteRuleModel) super.a(this.f89h, 4, RewriteRuleModel.class);
                return this.f89h;
            }

            public final int jK_() {
                return -987483837;
            }

            public final GraphQLVisitableModel m77a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel;
                RewriteRuleModel rewriteRuleModel;
                h();
                if (m74j() != null) {
                    Builder a = ModelHelper.a(m74j(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        FreeFacebookMessageQuotaModel freeFacebookMessageQuotaModel = (FreeFacebookMessageQuotaModel) ModelHelper.a(null, this);
                        freeFacebookMessageQuotaModel.f87f = a.b();
                        graphQLVisitableModel = freeFacebookMessageQuotaModel;
                        if (m75k() != null) {
                            rewriteRuleModel = (RewriteRuleModel) graphQLModelMutatingVisitor.b(m75k());
                            if (m75k() != rewriteRuleModel) {
                                graphQLVisitableModel = (FreeFacebookMessageQuotaModel) ModelHelper.a(graphQLVisitableModel, this);
                                graphQLVisitableModel.f89h = rewriteRuleModel;
                            }
                        }
                        i();
                        return graphQLVisitableModel != null ? this : graphQLVisitableModel;
                    }
                }
                graphQLVisitableModel = null;
                if (m75k() != null) {
                    rewriteRuleModel = (RewriteRuleModel) graphQLModelMutatingVisitor.b(m75k());
                    if (m75k() != rewriteRuleModel) {
                        graphQLVisitableModel = (FreeFacebookMessageQuotaModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f89h = rewriteRuleModel;
                    }
                }
                i();
                if (graphQLVisitableModel != null) {
                }
            }

            public final int m76a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int c = flatBufferBuilder.c(m73a());
                int a = ModelHelper.a(flatBufferBuilder, m74j());
                int a2 = ModelHelper.a(flatBufferBuilder, m75k());
                flatBufferBuilder.c(6);
                flatBufferBuilder.a(0, this.f85d, 0);
                flatBufferBuilder.b(1, c);
                flatBufferBuilder.b(2, a);
                flatBufferBuilder.a(3, this.f88g, 0);
                flatBufferBuilder.b(4, a2);
                flatBufferBuilder.a(5, this.f90i, 0);
                i();
                return flatBufferBuilder.d();
            }

            public final void m78a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                super.a(mutableFlatBuffer, i, obj);
                this.f85d = mutableFlatBuffer.a(i, 0, 0);
                this.f88g = mutableFlatBuffer.a(i, 3, 0);
                this.f90i = mutableFlatBuffer.a(i, 5, 0);
            }
        }

        /* compiled from: ्आ */
        public class Serializer extends JsonSerializer<FetchZeroMessageQuotaQueryModel> {
            public final void m79a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                FetchZeroMessageQuotaQueryModel fetchZeroMessageQuotaQueryModel = (FetchZeroMessageQuotaQueryModel) obj;
                if (fetchZeroMessageQuotaQueryModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(fetchZeroMessageQuotaQueryModel.m81a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    fetchZeroMessageQuotaQueryModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = fetchZeroMessageQuotaQueryModel.w_();
                int u_ = fetchZeroMessageQuotaQueryModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("free_facebook_message_quota");
                    FreeFacebookMessageQuotaParser.m86a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(FetchZeroMessageQuotaQueryModel.class, new Serializer());
            }
        }

        public FetchZeroMessageQuotaQueryModel() {
            super(1);
        }

        @Nullable
        private FreeFacebookMessageQuotaModel m80a() {
            this.f91d = (FreeFacebookMessageQuotaModel) super.a(this.f91d, 0, FreeFacebookMessageQuotaModel.class);
            return this.f91d;
        }

        public final int jK_() {
            return -1732764110;
        }

        public final GraphQLVisitableModel m82a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m80a() != null) {
                FreeFacebookMessageQuotaModel freeFacebookMessageQuotaModel = (FreeFacebookMessageQuotaModel) graphQLModelMutatingVisitor.b(m80a());
                if (m80a() != freeFacebookMessageQuotaModel) {
                    graphQLVisitableModel = (FetchZeroMessageQuotaQueryModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f91d = freeFacebookMessageQuotaModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m81a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m80a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }
}
