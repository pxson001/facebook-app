package com.facebook.zero.protocol.graphql;

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
import com.facebook.graphql.enums.GraphQLZeroTokenMode;
import com.facebook.graphql.enums.GraphQLZeroTokenRegStatus;
import com.facebook.graphql.enums.GraphQLZeroTokenUnregisteredReason;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.facebook.zero.protocol.graphql.ZeroTokenGraphQLParsers.FetchZeroTokenQueryParser;
import com.facebook.zero.protocol.graphql.ZeroTokenGraphQLParsers.FetchZeroTokenQueryParser.ZeroCarrierParser;
import com.facebook.zero.protocol.graphql.ZeroTokenGraphQLParsers.FetchZeroTokenQueryParser.ZeroTokenParser;
import com.facebook.zero.protocol.graphql.ZeroTokenGraphQLParsers.FetchZeroTokenQueryParser.ZeroTokenParser.FeaturesParser;
import com.facebook.zero.protocol.graphql.ZeroTokenGraphQLParsers.GraphQLRewriteRuleParser;
import com.facebook.zero.protocol.graphql.ZeroTokenGraphQLParsers.RewriteRuleParser;
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

/* compiled from: x_y_tags */
public class ZeroTokenGraphQLModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -576736034)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: x_y_tags */
    public final class FetchZeroTokenQueryModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private ZeroCarrierModel f210d;
        @Nullable
        private ZeroTokenModel f211e;

        /* compiled from: x_y_tags */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(FetchZeroTokenQueryModel.class, new Deserializer());
            }

            public Object m166a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = FetchZeroTokenQueryParser.m221a(jsonParser);
                Object fetchZeroTokenQueryModel = new FetchZeroTokenQueryModel();
                ((BaseModel) fetchZeroTokenQueryModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (fetchZeroTokenQueryModel instanceof Postprocessable) {
                    return ((Postprocessable) fetchZeroTokenQueryModel).a();
                }
                return fetchZeroTokenQueryModel;
            }
        }

        /* compiled from: x_y_tags */
        public class Serializer extends JsonSerializer<FetchZeroTokenQueryModel> {
            public final void m167a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                FetchZeroTokenQueryModel fetchZeroTokenQueryModel = (FetchZeroTokenQueryModel) obj;
                if (fetchZeroTokenQueryModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(fetchZeroTokenQueryModel.m197a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    fetchZeroTokenQueryModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = fetchZeroTokenQueryModel.w_();
                int u_ = fetchZeroTokenQueryModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("zero_carrier");
                    ZeroCarrierParser.m215a(mutableFlatBuffer, g, jsonGenerator);
                }
                g = mutableFlatBuffer.g(u_, 1);
                if (g != 0) {
                    jsonGenerator.a("zero_token");
                    ZeroTokenParser.m220a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(FetchZeroTokenQueryModel.class, new Serializer());
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -298128110)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: x_y_tags */
        public final class ZeroCarrierModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private String f194d;
            @Nullable
            private String f195e;
            @Nullable
            private String f196f;

            /* compiled from: x_y_tags */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(ZeroCarrierModel.class, new Deserializer());
                }

                public Object m168a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(ZeroCarrierParser.m214a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object zeroCarrierModel = new ZeroCarrierModel();
                    ((BaseModel) zeroCarrierModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (zeroCarrierModel instanceof Postprocessable) {
                        return ((Postprocessable) zeroCarrierModel).a();
                    }
                    return zeroCarrierModel;
                }
            }

            /* compiled from: x_y_tags */
            public class Serializer extends JsonSerializer<ZeroCarrierModel> {
                public final void m169a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    ZeroCarrierModel zeroCarrierModel = (ZeroCarrierModel) obj;
                    if (zeroCarrierModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(zeroCarrierModel.m170a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        zeroCarrierModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    ZeroCarrierParser.m215a(zeroCarrierModel.w_(), zeroCarrierModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(ZeroCarrierModel.class, new Serializer());
                }
            }

            public ZeroCarrierModel() {
                super(3);
            }

            @Nullable
            public final String m172a() {
                this.f194d = super.a(this.f194d, 0);
                return this.f194d;
            }

            @Nullable
            public final String m173j() {
                this.f195e = super.a(this.f195e, 1);
                return this.f195e;
            }

            @Nullable
            public final String m174k() {
                this.f196f = super.a(this.f196f, 2);
                return this.f196f;
            }

            public final int jK_() {
                return 1321194256;
            }

            public final GraphQLVisitableModel m171a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m170a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m172a());
                int b2 = flatBufferBuilder.b(m173j());
                int b3 = flatBufferBuilder.b(m174k());
                flatBufferBuilder.c(3);
                flatBufferBuilder.b(0, b);
                flatBufferBuilder.b(1, b2);
                flatBufferBuilder.b(2, b3);
                i();
                return flatBufferBuilder.d();
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 1547064213)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: x_y_tags */
        public final class ZeroTokenModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private String f201d;
            @Nullable
            private List<String> f202e;
            @Nullable
            private String f203f;
            @Nullable
            private List<FeaturesModel> f204g;
            @Nullable
            private GraphQLZeroTokenMode f205h;
            @Nullable
            private GraphQLZeroTokenRegStatus f206i;
            @Nullable
            private String f207j;
            private int f208k;
            @Nullable
            private GraphQLZeroTokenUnregisteredReason f209l;

            /* compiled from: x_y_tags */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(ZeroTokenModel.class, new Deserializer());
                }

                public Object m175a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(ZeroTokenParser.m219a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object zeroTokenModel = new ZeroTokenModel();
                    ((BaseModel) zeroTokenModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (zeroTokenModel instanceof Postprocessable) {
                        return ((Postprocessable) zeroTokenModel).a();
                    }
                    return zeroTokenModel;
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = -225183737)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: x_y_tags */
            public final class FeaturesModel extends BaseModel implements GraphQLVisitableModel {
                @Nullable
                private GraphQLObjectType f197d;
                @Nullable
                private List<GraphQLRewriteRuleModel> f198e;
                @Nullable
                private List<RewriteRuleModel> f199f;
                @Nullable
                private List<RewriteRuleModel> f200g;

                /* compiled from: x_y_tags */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(FeaturesModel.class, new Deserializer());
                    }

                    public Object m176a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(FeaturesParser.m217b(jsonParser, flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                        Object featuresModel = new FeaturesModel();
                        ((BaseModel) featuresModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                        if (featuresModel instanceof Postprocessable) {
                            return ((Postprocessable) featuresModel).a();
                        }
                        return featuresModel;
                    }
                }

                /* compiled from: x_y_tags */
                public class Serializer extends JsonSerializer<FeaturesModel> {
                    public final void m177a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        FeaturesModel featuresModel = (FeaturesModel) obj;
                        if (featuresModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(featuresModel.m179a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            featuresModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        FeaturesParser.m218b(featuresModel.w_(), featuresModel.u_(), jsonGenerator, serializerProvider);
                    }

                    static {
                        FbSerializerProvider.a(FeaturesModel.class, new Serializer());
                    }
                }

                public FeaturesModel() {
                    super(4);
                }

                @Nullable
                private GraphQLObjectType m178l() {
                    if (this.b != null && this.f197d == null) {
                        this.f197d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
                    }
                    return this.f197d;
                }

                @Nonnull
                public final ImmutableList<GraphQLRewriteRuleModel> m181a() {
                    this.f198e = super.a(this.f198e, 1, GraphQLRewriteRuleModel.class);
                    return (ImmutableList) this.f198e;
                }

                @Nonnull
                public final ImmutableList<RewriteRuleModel> m182j() {
                    this.f199f = super.a(this.f199f, 2, RewriteRuleModel.class);
                    return (ImmutableList) this.f199f;
                }

                @Nonnull
                public final ImmutableList<RewriteRuleModel> m183k() {
                    this.f200g = super.a(this.f200g, 3, RewriteRuleModel.class);
                    return (ImmutableList) this.f200g;
                }

                public final int jK_() {
                    return -268014612;
                }

                public final GraphQLVisitableModel m180a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    Builder a;
                    GraphQLVisitableModel graphQLVisitableModel = null;
                    h();
                    if (m181a() != null) {
                        a = ModelHelper.a(m181a(), graphQLModelMutatingVisitor);
                        if (a != null) {
                            graphQLVisitableModel = (FeaturesModel) ModelHelper.a(null, this);
                            graphQLVisitableModel.f198e = a.b();
                        }
                    }
                    if (m182j() != null) {
                        a = ModelHelper.a(m182j(), graphQLModelMutatingVisitor);
                        if (a != null) {
                            graphQLVisitableModel = (FeaturesModel) ModelHelper.a(graphQLVisitableModel, this);
                            graphQLVisitableModel.f199f = a.b();
                        }
                    }
                    if (m183k() != null) {
                        a = ModelHelper.a(m183k(), graphQLModelMutatingVisitor);
                        if (a != null) {
                            graphQLVisitableModel = (FeaturesModel) ModelHelper.a(graphQLVisitableModel, this);
                            graphQLVisitableModel.f200g = a.b();
                        }
                    }
                    i();
                    return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                }

                public final int m179a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int a = ModelHelper.a(flatBufferBuilder, m178l());
                    int a2 = ModelHelper.a(flatBufferBuilder, m181a());
                    int a3 = ModelHelper.a(flatBufferBuilder, m182j());
                    int a4 = ModelHelper.a(flatBufferBuilder, m183k());
                    flatBufferBuilder.c(4);
                    flatBufferBuilder.b(0, a);
                    flatBufferBuilder.b(1, a2);
                    flatBufferBuilder.b(2, a3);
                    flatBufferBuilder.b(3, a4);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            /* compiled from: x_y_tags */
            public class Serializer extends JsonSerializer<ZeroTokenModel> {
                public final void m184a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    ZeroTokenModel zeroTokenModel = (ZeroTokenModel) obj;
                    if (zeroTokenModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(zeroTokenModel.m186a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        zeroTokenModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    ZeroTokenParser.m220a(zeroTokenModel.w_(), zeroTokenModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(ZeroTokenModel.class, new Serializer());
                }
            }

            public ZeroTokenModel() {
                super(9);
            }

            @Nullable
            public final String m188a() {
                this.f201d = super.a(this.f201d, 0);
                return this.f201d;
            }

            @Nonnull
            public final ImmutableList<String> m190j() {
                this.f202e = super.a(this.f202e, 1);
                return (ImmutableList) this.f202e;
            }

            @Nullable
            public final String m191k() {
                this.f203f = super.a(this.f203f, 2);
                return this.f203f;
            }

            @Nonnull
            public final ImmutableList<FeaturesModel> m192l() {
                this.f204g = super.a(this.f204g, 3, FeaturesModel.class);
                return (ImmutableList) this.f204g;
            }

            @Nullable
            private GraphQLZeroTokenMode m185q() {
                this.f205h = (GraphQLZeroTokenMode) super.b(this.f205h, 4, GraphQLZeroTokenMode.class, GraphQLZeroTokenMode.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
                return this.f205h;
            }

            @Nullable
            public final GraphQLZeroTokenRegStatus m193m() {
                this.f206i = (GraphQLZeroTokenRegStatus) super.b(this.f206i, 5, GraphQLZeroTokenRegStatus.class, GraphQLZeroTokenRegStatus.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
                return this.f206i;
            }

            @Nullable
            public final String m194n() {
                this.f207j = super.a(this.f207j, 6);
                return this.f207j;
            }

            public final int m195o() {
                a(0, 7);
                return this.f208k;
            }

            @Nullable
            public final GraphQLZeroTokenUnregisteredReason m196p() {
                this.f209l = (GraphQLZeroTokenUnregisteredReason) super.b(this.f209l, 8, GraphQLZeroTokenUnregisteredReason.class, GraphQLZeroTokenUnregisteredReason.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
                return this.f209l;
            }

            public final int jK_() {
                return 1823069201;
            }

            public final GraphQLVisitableModel m187a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m192l() != null) {
                    Builder a = ModelHelper.a(m192l(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        graphQLVisitableModel = (ZeroTokenModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f204g = a.b();
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m186a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m188a());
                int c = flatBufferBuilder.c(m190j());
                int b2 = flatBufferBuilder.b(m191k());
                int a = ModelHelper.a(flatBufferBuilder, m192l());
                int a2 = flatBufferBuilder.a(m185q());
                int a3 = flatBufferBuilder.a(m193m());
                int b3 = flatBufferBuilder.b(m194n());
                int a4 = flatBufferBuilder.a(m196p());
                flatBufferBuilder.c(9);
                flatBufferBuilder.b(0, b);
                flatBufferBuilder.b(1, c);
                flatBufferBuilder.b(2, b2);
                flatBufferBuilder.b(3, a);
                flatBufferBuilder.b(4, a2);
                flatBufferBuilder.b(5, a3);
                flatBufferBuilder.b(6, b3);
                flatBufferBuilder.a(7, this.f208k, 0);
                flatBufferBuilder.b(8, a4);
                i();
                return flatBufferBuilder.d();
            }

            public final void m189a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                super.a(mutableFlatBuffer, i, obj);
                this.f208k = mutableFlatBuffer.a(i, 7, 0);
            }
        }

        public FetchZeroTokenQueryModel() {
            super(2);
        }

        @Nullable
        public final ZeroCarrierModel m199a() {
            this.f210d = (ZeroCarrierModel) super.a(this.f210d, 0, ZeroCarrierModel.class);
            return this.f210d;
        }

        @Nullable
        public final ZeroTokenModel m200j() {
            this.f211e = (ZeroTokenModel) super.a(this.f211e, 1, ZeroTokenModel.class);
            return this.f211e;
        }

        public final int jK_() {
            return -1732764110;
        }

        public final GraphQLVisitableModel m198a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m199a() != null) {
                ZeroCarrierModel zeroCarrierModel = (ZeroCarrierModel) graphQLModelMutatingVisitor.b(m199a());
                if (m199a() != zeroCarrierModel) {
                    graphQLVisitableModel = (FetchZeroTokenQueryModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f210d = zeroCarrierModel;
                }
            }
            if (m200j() != null) {
                ZeroTokenModel zeroTokenModel = (ZeroTokenModel) graphQLModelMutatingVisitor.b(m200j());
                if (m200j() != zeroTokenModel) {
                    graphQLVisitableModel = (FetchZeroTokenQueryModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f211e = zeroTokenModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m197a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m199a());
            int a2 = ModelHelper.a(flatBufferBuilder, m200j());
            flatBufferBuilder.c(2);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, a2);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -825879892)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: x_y_tags */
    public final class GraphQLRewriteRuleModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private List<String> f212d;
        @Nullable
        private String f213e;
        @Nullable
        private String f214f;

        /* compiled from: x_y_tags */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(GraphQLRewriteRuleModel.class, new Deserializer());
            }

            public Object m201a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(GraphQLRewriteRuleParser.m223b(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object graphQLRewriteRuleModel = new GraphQLRewriteRuleModel();
                ((BaseModel) graphQLRewriteRuleModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (graphQLRewriteRuleModel instanceof Postprocessable) {
                    return ((Postprocessable) graphQLRewriteRuleModel).a();
                }
                return graphQLRewriteRuleModel;
            }
        }

        /* compiled from: x_y_tags */
        public class Serializer extends JsonSerializer<GraphQLRewriteRuleModel> {
            public final void m202a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                GraphQLRewriteRuleModel graphQLRewriteRuleModel = (GraphQLRewriteRuleModel) obj;
                if (graphQLRewriteRuleModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(graphQLRewriteRuleModel.m204a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    graphQLRewriteRuleModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                GraphQLRewriteRuleParser.m222a(graphQLRewriteRuleModel.w_(), graphQLRewriteRuleModel.u_(), jsonGenerator);
            }

            static {
                FbSerializerProvider.a(GraphQLRewriteRuleModel.class, new Serializer());
            }
        }

        public GraphQLRewriteRuleModel() {
            super(3);
        }

        @Nonnull
        private ImmutableList<String> m203k() {
            this.f212d = super.a(this.f212d, 0);
            return (ImmutableList) this.f212d;
        }

        @Nullable
        public final String m206a() {
            this.f213e = super.a(this.f213e, 1);
            return this.f213e;
        }

        @Nullable
        public final String m207j() {
            this.f214f = super.a(this.f214f, 2);
            return this.f214f;
        }

        public final int jK_() {
            return 784253168;
        }

        public final GraphQLVisitableModel m205a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            h();
            i();
            return this;
        }

        public final int m204a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int c = flatBufferBuilder.c(m203k());
            int b = flatBufferBuilder.b(m206a());
            int b2 = flatBufferBuilder.b(m207j());
            flatBufferBuilder.c(3);
            flatBufferBuilder.b(0, c);
            flatBufferBuilder.b(1, b);
            flatBufferBuilder.b(2, b2);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 1778077682)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: x_y_tags */
    public final class RewriteRuleModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private String f215d;
        @Nullable
        private String f216e;

        /* compiled from: x_y_tags */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(RewriteRuleModel.class, new Deserializer());
            }

            public Object m208a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(RewriteRuleParser.m227b(jsonParser, flatBufferBuilder));
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

        /* compiled from: x_y_tags */
        public class Serializer extends JsonSerializer<RewriteRuleModel> {
            public final void m209a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                RewriteRuleModel rewriteRuleModel = (RewriteRuleModel) obj;
                if (rewriteRuleModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(rewriteRuleModel.m210a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    rewriteRuleModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                RewriteRuleParser.m225a(rewriteRuleModel.w_(), rewriteRuleModel.u_(), jsonGenerator);
            }

            static {
                FbSerializerProvider.a(RewriteRuleModel.class, new Serializer());
            }
        }

        public RewriteRuleModel() {
            super(2);
        }

        @Nullable
        public final String m212a() {
            this.f215d = super.a(this.f215d, 0);
            return this.f215d;
        }

        @Nullable
        public final String m213j() {
            this.f216e = super.a(this.f216e, 1);
            return this.f216e;
        }

        public final int jK_() {
            return -1646467625;
        }

        public final GraphQLVisitableModel m211a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            h();
            i();
            return this;
        }

        public final int m210a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(m212a());
            int b2 = flatBufferBuilder.b(m213j());
            flatBufferBuilder.c(2);
            flatBufferBuilder.b(0, b);
            flatBufferBuilder.b(1, b2);
            i();
            return flatBufferBuilder.d();
        }
    }
}
