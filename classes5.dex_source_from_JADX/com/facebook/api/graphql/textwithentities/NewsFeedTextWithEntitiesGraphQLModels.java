package com.facebook.api.graphql.textwithentities;

import com.facebook.api.graphql.textwithentities.NewsFeedTextWithEntitiesGraphQLParsers.DefaultTextWithEntitiesWithRangesFieldsParser;
import com.facebook.api.graphql.textwithentities.NewsFeedTextWithEntitiesGraphQLParsers.DefaultTextWithEntitiesWithRangesParser;
import com.facebook.api.graphql.textwithentities.NewsFeedTextWithEntitiesGraphQLParsers.DefaultTextWithEntitiesWithRangesParser.AggregatedRangesParser;
import com.facebook.api.graphql.textwithentities.NewsFeedTextWithEntitiesGraphQLParsers.DefaultTextWithEntitiesWithRangesParser.AggregatedRangesParser.SampleEntitiesParser;
import com.facebook.api.graphql.textwithentities.NewsFeedTextWithEntitiesGraphQLParsers.DefaultTextWithEntitiesWithRangesParser.RangesParser;
import com.facebook.api.graphql.textwithentities.NewsFeedTextWithEntitiesGraphQLParsers.DefaultTextWithEntitiesWithRangesParser.RangesParser.EntityParser;
import com.facebook.api.graphql.textwithentities.NewsFeedTextWithEntitiesGraphQLParsers.TextWithEntitiesAggregatedRangeFieldsParser;
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
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.querybuilder.common.CommonGraphQLModels.DefaultImageFieldsModel;
import com.facebook.graphql.querybuilder.common.TextWithEntitiesGraphQLInterfaces.DefaultTextWithEntitiesFields;
import com.facebook.graphql.querybuilder.common.TextWithEntitiesGraphQLInterfaces.DefaultTextWithEntitiesLongFields;
import com.facebook.graphql.querybuilder.common.TextWithEntitiesGraphQLModels.DefaultTextWithEntitiesLongFieldsModel.RangesModel;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLPersistableNode;
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

/* compiled from: tagged_place */
public class NewsFeedTextWithEntitiesGraphQLModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -1849034556)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: tagged_place */
    public final class DefaultTextWithEntitiesWithRangesFieldsModel extends BaseModel implements DefaultTextWithEntitiesLongFields, GraphQLVisitableModel {
        @Nullable
        private List<TextWithEntitiesAggregatedRangeFieldsModel> f2221d;
        @Nullable
        private List<RangesModel> f2222e;
        @Nullable
        private String f2223f;

        /* compiled from: tagged_place */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(DefaultTextWithEntitiesWithRangesFieldsModel.class, new Deserializer());
            }

            public Object m3083a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(DefaultTextWithEntitiesWithRangesFieldsParser.m3144a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object defaultTextWithEntitiesWithRangesFieldsModel = new DefaultTextWithEntitiesWithRangesFieldsModel();
                ((BaseModel) defaultTextWithEntitiesWithRangesFieldsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (defaultTextWithEntitiesWithRangesFieldsModel instanceof Postprocessable) {
                    return ((Postprocessable) defaultTextWithEntitiesWithRangesFieldsModel).a();
                }
                return defaultTextWithEntitiesWithRangesFieldsModel;
            }
        }

        /* compiled from: tagged_place */
        public class Serializer extends JsonSerializer<DefaultTextWithEntitiesWithRangesFieldsModel> {
            public final void m3084a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                DefaultTextWithEntitiesWithRangesFieldsModel defaultTextWithEntitiesWithRangesFieldsModel = (DefaultTextWithEntitiesWithRangesFieldsModel) obj;
                if (defaultTextWithEntitiesWithRangesFieldsModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(defaultTextWithEntitiesWithRangesFieldsModel.m3086a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    defaultTextWithEntitiesWithRangesFieldsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                DefaultTextWithEntitiesWithRangesFieldsParser.m3145a(defaultTextWithEntitiesWithRangesFieldsModel.w_(), defaultTextWithEntitiesWithRangesFieldsModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(DefaultTextWithEntitiesWithRangesFieldsModel.class, new Serializer());
            }
        }

        public DefaultTextWithEntitiesWithRangesFieldsModel() {
            super(3);
        }

        @Nonnull
        private ImmutableList<TextWithEntitiesAggregatedRangeFieldsModel> m3085j() {
            this.f2221d = super.a(this.f2221d, 0, TextWithEntitiesAggregatedRangeFieldsModel.class);
            return (ImmutableList) this.f2221d;
        }

        @Nonnull
        public final ImmutableList<RangesModel> m3089b() {
            this.f2222e = super.a(this.f2222e, 1, RangesModel.class);
            return (ImmutableList) this.f2222e;
        }

        @Nullable
        public final String m3088a() {
            this.f2223f = super.a(this.f2223f, 2);
            return this.f2223f;
        }

        public final int jK_() {
            return -1919764332;
        }

        public final GraphQLVisitableModel m3087a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            Builder a;
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m3085j() != null) {
                a = ModelHelper.a(m3085j(), graphQLModelMutatingVisitor);
                if (a != null) {
                    graphQLVisitableModel = (DefaultTextWithEntitiesWithRangesFieldsModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f2221d = a.b();
                }
            }
            if (m3089b() != null) {
                a = ModelHelper.a(m3089b(), graphQLModelMutatingVisitor);
                if (a != null) {
                    graphQLVisitableModel = (DefaultTextWithEntitiesWithRangesFieldsModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f2222e = a.b();
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m3086a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m3085j());
            int a2 = ModelHelper.a(flatBufferBuilder, m3089b());
            int b = flatBufferBuilder.b(m3088a());
            flatBufferBuilder.c(3);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, a2);
            flatBufferBuilder.b(2, b);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 110891328)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: tagged_place */
    public final class DefaultTextWithEntitiesWithRangesModel extends BaseModel implements DefaultTextWithEntitiesFields, GraphQLVisitableModel {
        @Nullable
        private List<AggregatedRangesModel> f2240d;
        @Nullable
        private List<RangesModel> f2241e;
        @Nullable
        private String f2242f;

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -923352387)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: tagged_place */
        public final class AggregatedRangesModel extends BaseModel implements GraphQLVisitableModel {
            private int f2229d;
            private int f2230e;
            private int f2231f;
            @Nullable
            private List<SampleEntitiesModel> f2232g;

            /* compiled from: tagged_place */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(AggregatedRangesModel.class, new Deserializer());
                }

                public Object m3090a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(AggregatedRangesParser.m3149b(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object aggregatedRangesModel = new AggregatedRangesModel();
                    ((BaseModel) aggregatedRangesModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (aggregatedRangesModel instanceof Postprocessable) {
                        return ((Postprocessable) aggregatedRangesModel).a();
                    }
                    return aggregatedRangesModel;
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = 702630869)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: tagged_place */
            public final class SampleEntitiesModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel {
                @Nullable
                private GraphQLObjectType f2224d;
                @Nullable
                private String f2225e;
                @Nullable
                private String f2226f;
                @Nullable
                private DefaultImageFieldsModel f2227g;
                @Nullable
                private String f2228h;

                /* compiled from: tagged_place */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(SampleEntitiesModel.class, new Deserializer());
                    }

                    public Object m3091a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(SampleEntitiesParser.m3147b(jsonParser, flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                        Object sampleEntitiesModel = new SampleEntitiesModel();
                        ((BaseModel) sampleEntitiesModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                        if (sampleEntitiesModel instanceof Postprocessable) {
                            return ((Postprocessable) sampleEntitiesModel).a();
                        }
                        return sampleEntitiesModel;
                    }
                }

                /* compiled from: tagged_place */
                public class Serializer extends JsonSerializer<SampleEntitiesModel> {
                    public final void m3092a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        SampleEntitiesModel sampleEntitiesModel = (SampleEntitiesModel) obj;
                        if (sampleEntitiesModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(sampleEntitiesModel.m3098a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            sampleEntitiesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        SampleEntitiesParser.m3148b(sampleEntitiesModel.w_(), sampleEntitiesModel.u_(), jsonGenerator, serializerProvider);
                    }

                    static {
                        FbSerializerProvider.a(SampleEntitiesModel.class, new Serializer());
                    }
                }

                public SampleEntitiesModel() {
                    super(5);
                }

                @Nullable
                private GraphQLObjectType m3093j() {
                    if (this.b != null && this.f2224d == null) {
                        this.f2224d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
                    }
                    return this.f2224d;
                }

                @Nullable
                private String m3094k() {
                    this.f2225e = super.a(this.f2225e, 1);
                    return this.f2225e;
                }

                @Nullable
                private String m3095l() {
                    this.f2226f = super.a(this.f2226f, 2);
                    return this.f2226f;
                }

                @Nullable
                private DefaultImageFieldsModel m3096m() {
                    this.f2227g = (DefaultImageFieldsModel) super.a(this.f2227g, 3, DefaultImageFieldsModel.class);
                    return this.f2227g;
                }

                @Nullable
                private String m3097n() {
                    this.f2228h = super.a(this.f2228h, 4);
                    return this.f2228h;
                }

                @Nullable
                public final String m3100a() {
                    return m3094k();
                }

                public final int jK_() {
                    return 2080559107;
                }

                public final GraphQLVisitableModel m3099a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    GraphQLVisitableModel graphQLVisitableModel = null;
                    h();
                    if (m3096m() != null) {
                        DefaultImageFieldsModel defaultImageFieldsModel = (DefaultImageFieldsModel) graphQLModelMutatingVisitor.b(m3096m());
                        if (m3096m() != defaultImageFieldsModel) {
                            graphQLVisitableModel = (SampleEntitiesModel) ModelHelper.a(null, this);
                            graphQLVisitableModel.f2227g = defaultImageFieldsModel;
                        }
                    }
                    i();
                    return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                }

                public final int m3098a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int a = ModelHelper.a(flatBufferBuilder, m3093j());
                    int b = flatBufferBuilder.b(m3094k());
                    int b2 = flatBufferBuilder.b(m3095l());
                    int a2 = ModelHelper.a(flatBufferBuilder, m3096m());
                    int b3 = flatBufferBuilder.b(m3097n());
                    flatBufferBuilder.c(5);
                    flatBufferBuilder.b(0, a);
                    flatBufferBuilder.b(1, b);
                    flatBufferBuilder.b(2, b2);
                    flatBufferBuilder.b(3, a2);
                    flatBufferBuilder.b(4, b3);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            /* compiled from: tagged_place */
            public class Serializer extends JsonSerializer<AggregatedRangesModel> {
                public final void m3101a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    AggregatedRangesModel aggregatedRangesModel = (AggregatedRangesModel) obj;
                    if (aggregatedRangesModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(aggregatedRangesModel.m3103a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        aggregatedRangesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    AggregatedRangesParser.m3150b(aggregatedRangesModel.w_(), aggregatedRangesModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(AggregatedRangesModel.class, new Serializer());
                }
            }

            public AggregatedRangesModel() {
                super(4);
            }

            @Nonnull
            private ImmutableList<SampleEntitiesModel> m3102a() {
                this.f2232g = super.a(this.f2232g, 3, SampleEntitiesModel.class);
                return (ImmutableList) this.f2232g;
            }

            public final int jK_() {
                return 1563462756;
            }

            public final GraphQLVisitableModel m3104a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m3102a() != null) {
                    Builder a = ModelHelper.a(m3102a(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        graphQLVisitableModel = (AggregatedRangesModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f2232g = a.b();
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m3103a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m3102a());
                flatBufferBuilder.c(4);
                flatBufferBuilder.a(0, this.f2229d, 0);
                flatBufferBuilder.a(1, this.f2230e, 0);
                flatBufferBuilder.a(2, this.f2231f, 0);
                flatBufferBuilder.b(3, a);
                i();
                return flatBufferBuilder.d();
            }

            public final void m3105a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                super.a(mutableFlatBuffer, i, obj);
                this.f2229d = mutableFlatBuffer.a(i, 0, 0);
                this.f2230e = mutableFlatBuffer.a(i, 1, 0);
                this.f2231f = mutableFlatBuffer.a(i, 2, 0);
            }
        }

        /* compiled from: tagged_place */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(DefaultTextWithEntitiesWithRangesModel.class, new Deserializer());
            }

            public Object m3106a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(DefaultTextWithEntitiesWithRangesParser.m3156a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object defaultTextWithEntitiesWithRangesModel = new DefaultTextWithEntitiesWithRangesModel();
                ((BaseModel) defaultTextWithEntitiesWithRangesModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (defaultTextWithEntitiesWithRangesModel instanceof Postprocessable) {
                    return ((Postprocessable) defaultTextWithEntitiesWithRangesModel).a();
                }
                return defaultTextWithEntitiesWithRangesModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -528364512)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: tagged_place */
        public final class RangesModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private EntityModel f2237d;
            private int f2238e;
            private int f2239f;

            /* compiled from: tagged_place */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(RangesModel.class, new Deserializer());
                }

                public Object m3107a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(RangesParser.m3154b(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object rangesModel = new RangesModel();
                    ((BaseModel) rangesModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (rangesModel instanceof Postprocessable) {
                        return ((Postprocessable) rangesModel).a();
                    }
                    return rangesModel;
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = 1821837936)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: tagged_place */
            public final class EntityModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel {
                @Nullable
                private GraphQLObjectType f2233d;
                @Nullable
                private String f2234e;
                @Nullable
                private String f2235f;
                @Nullable
                private String f2236g;

                /* compiled from: tagged_place */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(EntityModel.class, new Deserializer());
                    }

                    public Object m3108a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(EntityParser.m3151a(jsonParser, flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                        Object entityModel = new EntityModel();
                        ((BaseModel) entityModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                        if (entityModel instanceof Postprocessable) {
                            return ((Postprocessable) entityModel).a();
                        }
                        return entityModel;
                    }
                }

                /* compiled from: tagged_place */
                public class Serializer extends JsonSerializer<EntityModel> {
                    public final void m3109a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        EntityModel entityModel = (EntityModel) obj;
                        if (entityModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(entityModel.m3114a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            entityModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        EntityParser.m3152a(entityModel.w_(), entityModel.u_(), jsonGenerator);
                    }

                    static {
                        FbSerializerProvider.a(EntityModel.class, new Serializer());
                    }
                }

                public EntityModel() {
                    super(4);
                }

                @Nullable
                private GraphQLObjectType m3110j() {
                    if (this.b != null && this.f2233d == null) {
                        this.f2233d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
                    }
                    return this.f2233d;
                }

                @Nullable
                private String m3111k() {
                    this.f2234e = super.a(this.f2234e, 1);
                    return this.f2234e;
                }

                @Nullable
                private String m3112l() {
                    this.f2235f = super.a(this.f2235f, 2);
                    return this.f2235f;
                }

                @Nullable
                private String m3113m() {
                    this.f2236g = super.a(this.f2236g, 3);
                    return this.f2236g;
                }

                @Nullable
                public final String m3116a() {
                    return m3111k();
                }

                public final int jK_() {
                    return 2080559107;
                }

                public final GraphQLVisitableModel m3115a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    h();
                    i();
                    return this;
                }

                public final int m3114a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int a = ModelHelper.a(flatBufferBuilder, m3110j());
                    int b = flatBufferBuilder.b(m3111k());
                    int b2 = flatBufferBuilder.b(m3112l());
                    int b3 = flatBufferBuilder.b(m3113m());
                    flatBufferBuilder.c(4);
                    flatBufferBuilder.b(0, a);
                    flatBufferBuilder.b(1, b);
                    flatBufferBuilder.b(2, b2);
                    flatBufferBuilder.b(3, b3);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            /* compiled from: tagged_place */
            public class Serializer extends JsonSerializer<RangesModel> {
                public final void m3117a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    RangesModel rangesModel = (RangesModel) obj;
                    if (rangesModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(rangesModel.m3119a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        rangesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    RangesParser.m3155b(rangesModel.w_(), rangesModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(RangesModel.class, new Serializer());
                }
            }

            public RangesModel() {
                super(3);
            }

            @Nullable
            private EntityModel m3118a() {
                this.f2237d = (EntityModel) super.a(this.f2237d, 0, EntityModel.class);
                return this.f2237d;
            }

            public final int jK_() {
                return -1024511161;
            }

            public final GraphQLVisitableModel m3120a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m3118a() != null) {
                    EntityModel entityModel = (EntityModel) graphQLModelMutatingVisitor.b(m3118a());
                    if (m3118a() != entityModel) {
                        graphQLVisitableModel = (RangesModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f2237d = entityModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m3119a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m3118a());
                flatBufferBuilder.c(3);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.a(1, this.f2238e, 0);
                flatBufferBuilder.a(2, this.f2239f, 0);
                i();
                return flatBufferBuilder.d();
            }

            public final void m3121a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                super.a(mutableFlatBuffer, i, obj);
                this.f2238e = mutableFlatBuffer.a(i, 1, 0);
                this.f2239f = mutableFlatBuffer.a(i, 2, 0);
            }
        }

        /* compiled from: tagged_place */
        public class Serializer extends JsonSerializer<DefaultTextWithEntitiesWithRangesModel> {
            public final void m3122a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                DefaultTextWithEntitiesWithRangesModel defaultTextWithEntitiesWithRangesModel = (DefaultTextWithEntitiesWithRangesModel) obj;
                if (defaultTextWithEntitiesWithRangesModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(defaultTextWithEntitiesWithRangesModel.m3125a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    defaultTextWithEntitiesWithRangesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                DefaultTextWithEntitiesWithRangesParser.m3157a(defaultTextWithEntitiesWithRangesModel.w_(), defaultTextWithEntitiesWithRangesModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(DefaultTextWithEntitiesWithRangesModel.class, new Serializer());
            }
        }

        public DefaultTextWithEntitiesWithRangesModel() {
            super(3);
        }

        @Nonnull
        private ImmutableList<AggregatedRangesModel> m3123j() {
            this.f2240d = super.a(this.f2240d, 0, AggregatedRangesModel.class);
            return (ImmutableList) this.f2240d;
        }

        @Nonnull
        private ImmutableList<RangesModel> m3124k() {
            this.f2241e = super.a(this.f2241e, 1, RangesModel.class);
            return (ImmutableList) this.f2241e;
        }

        @Nullable
        public final String m3127a() {
            this.f2242f = super.a(this.f2242f, 2);
            return this.f2242f;
        }

        public final int jK_() {
            return -1919764332;
        }

        public final GraphQLVisitableModel m3126a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            Builder a;
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m3123j() != null) {
                a = ModelHelper.a(m3123j(), graphQLModelMutatingVisitor);
                if (a != null) {
                    graphQLVisitableModel = (DefaultTextWithEntitiesWithRangesModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f2240d = a.b();
                }
            }
            if (m3124k() != null) {
                a = ModelHelper.a(m3124k(), graphQLModelMutatingVisitor);
                if (a != null) {
                    graphQLVisitableModel = (DefaultTextWithEntitiesWithRangesModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f2241e = a.b();
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m3125a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m3123j());
            int a2 = ModelHelper.a(flatBufferBuilder, m3124k());
            int b = flatBufferBuilder.b(m3127a());
            flatBufferBuilder.c(3);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, a2);
            flatBufferBuilder.b(2, b);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -1801432544)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: tagged_place */
    public final class TextWithEntitiesAggregatedRangeFieldsModel extends BaseModel implements GraphQLVisitableModel {
        private int f2248d;
        private int f2249e;
        private int f2250f;
        @Nullable
        private List<SampleEntitiesModel> f2251g;

        /* compiled from: tagged_place */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(TextWithEntitiesAggregatedRangeFieldsModel.class, new Deserializer());
            }

            public Object m3128a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(TextWithEntitiesAggregatedRangeFieldsParser.m3163b(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object textWithEntitiesAggregatedRangeFieldsModel = new TextWithEntitiesAggregatedRangeFieldsModel();
                ((BaseModel) textWithEntitiesAggregatedRangeFieldsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (textWithEntitiesAggregatedRangeFieldsModel instanceof Postprocessable) {
                    return ((Postprocessable) textWithEntitiesAggregatedRangeFieldsModel).a();
                }
                return textWithEntitiesAggregatedRangeFieldsModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 702630869)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: tagged_place */
        public final class SampleEntitiesModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel {
            @Nullable
            private GraphQLObjectType f2243d;
            @Nullable
            private String f2244e;
            @Nullable
            private String f2245f;
            @Nullable
            private DefaultImageFieldsModel f2246g;
            @Nullable
            private String f2247h;

            /* compiled from: tagged_place */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(SampleEntitiesModel.class, new Deserializer());
                }

                public Object m3129a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(TextWithEntitiesAggregatedRangeFieldsParser.SampleEntitiesParser.m3159b(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object sampleEntitiesModel = new SampleEntitiesModel();
                    ((BaseModel) sampleEntitiesModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (sampleEntitiesModel instanceof Postprocessable) {
                        return ((Postprocessable) sampleEntitiesModel).a();
                    }
                    return sampleEntitiesModel;
                }
            }

            /* compiled from: tagged_place */
            public class Serializer extends JsonSerializer<SampleEntitiesModel> {
                public final void m3130a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    SampleEntitiesModel sampleEntitiesModel = (SampleEntitiesModel) obj;
                    if (sampleEntitiesModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(sampleEntitiesModel.m3136a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        sampleEntitiesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    TextWithEntitiesAggregatedRangeFieldsParser.SampleEntitiesParser.m3160b(sampleEntitiesModel.w_(), sampleEntitiesModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(SampleEntitiesModel.class, new Serializer());
                }
            }

            public SampleEntitiesModel() {
                super(5);
            }

            @Nullable
            private GraphQLObjectType m3131j() {
                if (this.b != null && this.f2243d == null) {
                    this.f2243d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
                }
                return this.f2243d;
            }

            @Nullable
            private String m3132k() {
                this.f2244e = super.a(this.f2244e, 1);
                return this.f2244e;
            }

            @Nullable
            private String m3133l() {
                this.f2245f = super.a(this.f2245f, 2);
                return this.f2245f;
            }

            @Nullable
            private DefaultImageFieldsModel m3134m() {
                this.f2246g = (DefaultImageFieldsModel) super.a(this.f2246g, 3, DefaultImageFieldsModel.class);
                return this.f2246g;
            }

            @Nullable
            private String m3135n() {
                this.f2247h = super.a(this.f2247h, 4);
                return this.f2247h;
            }

            @Nullable
            public final String m3138a() {
                return m3132k();
            }

            public final int jK_() {
                return 2080559107;
            }

            public final GraphQLVisitableModel m3137a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m3134m() != null) {
                    DefaultImageFieldsModel defaultImageFieldsModel = (DefaultImageFieldsModel) graphQLModelMutatingVisitor.b(m3134m());
                    if (m3134m() != defaultImageFieldsModel) {
                        graphQLVisitableModel = (SampleEntitiesModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f2246g = defaultImageFieldsModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m3136a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m3131j());
                int b = flatBufferBuilder.b(m3132k());
                int b2 = flatBufferBuilder.b(m3133l());
                int a2 = ModelHelper.a(flatBufferBuilder, m3134m());
                int b3 = flatBufferBuilder.b(m3135n());
                flatBufferBuilder.c(5);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.b(1, b);
                flatBufferBuilder.b(2, b2);
                flatBufferBuilder.b(3, a2);
                flatBufferBuilder.b(4, b3);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: tagged_place */
        public class Serializer extends JsonSerializer<TextWithEntitiesAggregatedRangeFieldsModel> {
            public final void m3139a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                TextWithEntitiesAggregatedRangeFieldsModel textWithEntitiesAggregatedRangeFieldsModel = (TextWithEntitiesAggregatedRangeFieldsModel) obj;
                if (textWithEntitiesAggregatedRangeFieldsModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(textWithEntitiesAggregatedRangeFieldsModel.m3141a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    textWithEntitiesAggregatedRangeFieldsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                TextWithEntitiesAggregatedRangeFieldsParser.m3164b(textWithEntitiesAggregatedRangeFieldsModel.w_(), textWithEntitiesAggregatedRangeFieldsModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(TextWithEntitiesAggregatedRangeFieldsModel.class, new Serializer());
            }
        }

        public TextWithEntitiesAggregatedRangeFieldsModel() {
            super(4);
        }

        @Nonnull
        private ImmutableList<SampleEntitiesModel> m3140a() {
            this.f2251g = super.a(this.f2251g, 3, SampleEntitiesModel.class);
            return (ImmutableList) this.f2251g;
        }

        public final int jK_() {
            return 1563462756;
        }

        public final GraphQLVisitableModel m3142a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m3140a() != null) {
                Builder a = ModelHelper.a(m3140a(), graphQLModelMutatingVisitor);
                if (a != null) {
                    graphQLVisitableModel = (TextWithEntitiesAggregatedRangeFieldsModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f2251g = a.b();
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m3141a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m3140a());
            flatBufferBuilder.c(4);
            flatBufferBuilder.a(0, this.f2248d, 0);
            flatBufferBuilder.a(1, this.f2249e, 0);
            flatBufferBuilder.a(2, this.f2250f, 0);
            flatBufferBuilder.b(3, a);
            i();
            return flatBufferBuilder.d();
        }

        public final void m3143a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
            super.a(mutableFlatBuffer, i, obj);
            this.f2248d = mutableFlatBuffer.a(i, 0, 0);
            this.f2249e = mutableFlatBuffer.a(i, 1, 0);
            this.f2250f = mutableFlatBuffer.a(i, 2, 0);
        }
    }
}
