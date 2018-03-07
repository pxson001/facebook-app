package com.facebook.composer.minutiae.graphql;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbSerializerProvider;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.composer.minutiae.graphql.MinutiaeDefaultsGraphQLInterfaces.MinutiaeTaggableActivity;
import com.facebook.composer.minutiae.graphql.MinutiaeDefaultsGraphQLInterfaces.MinutiaeTaggableActivityFields;
import com.facebook.composer.minutiae.graphql.MinutiaeDefaultsGraphQLInterfaces.MinutiaeTaggableActivityPreviewTemplateFields;
import com.facebook.composer.minutiae.graphql.MinutiaeDefaultsGraphQLParsers.MinutiaeIconParser;
import com.facebook.composer.minutiae.graphql.MinutiaeDefaultsGraphQLParsers.MinutiaePreviewTemplateParser;
import com.facebook.composer.minutiae.graphql.MinutiaeDefaultsGraphQLParsers.MinutiaePreviewTemplateParser.TemplateTokensParser;
import com.facebook.composer.minutiae.graphql.MinutiaeDefaultsGraphQLParsers.MinutiaeTaggableActivityFieldsParser;
import com.facebook.composer.minutiae.graphql.MinutiaeDefaultsGraphQLParsers.MinutiaeTaggableActivityFieldsParser.GlyphParser;
import com.facebook.composer.minutiae.graphql.MinutiaeDefaultsGraphQLParsers.MinutiaeTaggableActivityFieldsParser.IconImageLargeParser;
import com.facebook.composer.minutiae.graphql.MinutiaeDefaultsGraphQLParsers.MinutiaeTaggableActivityIconsParser;
import com.facebook.composer.minutiae.graphql.MinutiaeDefaultsGraphQLParsers.MinutiaeTaggableActivityIconsParser.AllIconsParser;
import com.facebook.composer.minutiae.graphql.MinutiaeDefaultsGraphQLParsers.MinutiaeTaggableActivityParser;
import com.facebook.composer.minutiae.graphql.MinutiaeDefaultsGraphQLParsers.MinutiaeTaggableActivityPreviewTemplateFieldsParser;
import com.facebook.composer.minutiae.graphql.MinutiaeDefaultsGraphQLParsers.MinutiaeTaggableObjectFieldsParser;
import com.facebook.composer.minutiae.graphql.MinutiaeDefaultsGraphQLParsers.MinutiaeTaggableObjectFieldsParser.OpenGraphComposerPreviewParser;
import com.facebook.composer.minutiae.graphql.MinutiaeDefaultsGraphQLParsers.MinutiaeTaggableObjectFieldsParser.PageParser;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.FragmentModelWithoutBridge;
import com.facebook.flatbuffers.ModelWithFlatBufferFormatHash;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.enums.GraphQLActivityTemplateTokenType;
import com.facebook.graphql.enums.GraphQLObjectType;
import com.facebook.graphql.enums.GraphQLStoryAttachmentStyle;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.querybuilder.common.CommonGraphQLInterfaces.DefaultImageFields;
import com.facebook.graphql.querybuilder.common.CommonGraphQLModels.DefaultImageFieldsModel;
import com.facebook.graphql.visitor.ConsistencyTuple;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLPersistableNode;
import com.facebook.graphql.visitor.GraphQLVisitableConsistentModel;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.facebook.linkify.LinkifyTargetGraphQLInterfaces.LinkifyTargetGraphQL;
import com.facebook.linkify.LinkifyTargetGraphQLInterfaces.LinkifyTargetGraphQL.ProfilePicture;
import com.facebook.linkify.LinkifyTargetGraphQLModels.LinkifyTargetGraphQLModel.ProfilePictureModel;
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

/* compiled from: addresses */
public class MinutiaeDefaultsGraphQLModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -1539951621)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: addresses */
    public final class MinutiaeIconModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel {
        @Nullable
        private String f11359d;
        @Nullable
        private DefaultImageFieldsModel f11360e;

        /* compiled from: addresses */
        public final class Builder {
            @Nullable
            public String f11357a;
            @Nullable
            public DefaultImageFieldsModel f11358b;
        }

        /* compiled from: addresses */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(MinutiaeIconModel.class, new Deserializer());
            }

            public Object m19354a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(MinutiaeIconParser.m19513b(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object minutiaeIconModel = new MinutiaeIconModel();
                ((BaseModel) minutiaeIconModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (minutiaeIconModel instanceof Postprocessable) {
                    return ((Postprocessable) minutiaeIconModel).a();
                }
                return minutiaeIconModel;
            }
        }

        /* compiled from: addresses */
        public class Serializer extends JsonSerializer<MinutiaeIconModel> {
            public final void m19355a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MinutiaeIconModel minutiaeIconModel = (MinutiaeIconModel) obj;
                if (minutiaeIconModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(minutiaeIconModel.m19357a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    minutiaeIconModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                MinutiaeIconParser.m19514b(minutiaeIconModel.w_(), minutiaeIconModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(MinutiaeIconModel.class, new Serializer());
            }
        }

        @Nullable
        public final /* synthetic */ DefaultImageFields m19361c() {
            return m19362j();
        }

        public MinutiaeIconModel() {
            super(2);
        }

        public MinutiaeIconModel(MutableFlatBuffer mutableFlatBuffer) {
            super(2);
            a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
        }

        @Nullable
        public final String m19360b() {
            this.f11359d = super.a(this.f11359d, 0);
            return this.f11359d;
        }

        @Nullable
        public final DefaultImageFieldsModel m19362j() {
            this.f11360e = (DefaultImageFieldsModel) super.a(this.f11360e, 1, DefaultImageFieldsModel.class);
            return this.f11360e;
        }

        public static MinutiaeIconModel m19356a(MinutiaeIconModel minutiaeIconModel) {
            if (minutiaeIconModel == null) {
                return null;
            }
            if (minutiaeIconModel instanceof MinutiaeIconModel) {
                return minutiaeIconModel;
            }
            Builder builder = new Builder();
            builder.f11357a = minutiaeIconModel.m19360b();
            builder.f11358b = DefaultImageFieldsModel.a(minutiaeIconModel.m19361c());
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
            int b = flatBufferBuilder.b(builder.f11357a);
            int a = ModelHelper.a(flatBufferBuilder, builder.f11358b);
            flatBufferBuilder.c(2);
            flatBufferBuilder.b(0, b);
            flatBufferBuilder.b(1, a);
            flatBufferBuilder.d(flatBufferBuilder.d());
            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
            wrap.position(0);
            return new MinutiaeIconModel(new MutableFlatBuffer(wrap, null, null, true, null));
        }

        @Nullable
        public final String m19359a() {
            return m19360b();
        }

        public final int jK_() {
            return 638969039;
        }

        public final GraphQLVisitableModel m19358a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m19362j() != null) {
                DefaultImageFieldsModel defaultImageFieldsModel = (DefaultImageFieldsModel) graphQLModelMutatingVisitor.b(m19362j());
                if (m19362j() != defaultImageFieldsModel) {
                    graphQLVisitableModel = (MinutiaeIconModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f11360e = defaultImageFieldsModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m19357a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(m19360b());
            int a = ModelHelper.a(flatBufferBuilder, m19362j());
            flatBufferBuilder.c(2);
            flatBufferBuilder.b(0, b);
            flatBufferBuilder.b(1, a);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -527607260)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: addresses */
    public final class MinutiaePreviewTemplateModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private String f11367d;
        @Nullable
        private List<TemplateTokensModel> f11368e;

        /* compiled from: addresses */
        public final class Builder {
            @Nullable
            public String f11361a;
            @Nullable
            public ImmutableList<TemplateTokensModel> f11362b;
        }

        /* compiled from: addresses */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(MinutiaePreviewTemplateModel.class, new Deserializer());
            }

            public Object m19363a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(MinutiaePreviewTemplateParser.m19517a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object minutiaePreviewTemplateModel = new MinutiaePreviewTemplateModel();
                ((BaseModel) minutiaePreviewTemplateModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (minutiaePreviewTemplateModel instanceof Postprocessable) {
                    return ((Postprocessable) minutiaePreviewTemplateModel).a();
                }
                return minutiaePreviewTemplateModel;
            }
        }

        /* compiled from: addresses */
        public class Serializer extends JsonSerializer<MinutiaePreviewTemplateModel> {
            public final void m19364a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MinutiaePreviewTemplateModel minutiaePreviewTemplateModel = (MinutiaePreviewTemplateModel) obj;
                if (minutiaePreviewTemplateModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(minutiaePreviewTemplateModel.m19374a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    minutiaePreviewTemplateModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                MinutiaePreviewTemplateParser.m19518a(minutiaePreviewTemplateModel.w_(), minutiaePreviewTemplateModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(MinutiaePreviewTemplateModel.class, new Serializer());
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1190013070)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: addresses */
        public final class TemplateTokensModel extends BaseModel implements GraphQLVisitableModel {
            private int f11365d;
            @Nullable
            private GraphQLActivityTemplateTokenType f11366e;

            /* compiled from: addresses */
            public final class Builder {
                public int f11363a;
                @Nullable
                public GraphQLActivityTemplateTokenType f11364b;
            }

            /* compiled from: addresses */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(TemplateTokensModel.class, new Deserializer());
                }

                public Object m19365a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(TemplateTokensParser.m19516b(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object templateTokensModel = new TemplateTokensModel();
                    ((BaseModel) templateTokensModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (templateTokensModel instanceof Postprocessable) {
                        return ((Postprocessable) templateTokensModel).a();
                    }
                    return templateTokensModel;
                }
            }

            /* compiled from: addresses */
            public class Serializer extends JsonSerializer<TemplateTokensModel> {
                public final void m19366a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    TemplateTokensModel templateTokensModel = (TemplateTokensModel) obj;
                    if (templateTokensModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(templateTokensModel.m19369a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        templateTokensModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    TemplateTokensParser.m19515a(templateTokensModel.w_(), templateTokensModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(TemplateTokensModel.class, new Serializer());
                }
            }

            public TemplateTokensModel() {
                super(2);
            }

            public TemplateTokensModel(MutableFlatBuffer mutableFlatBuffer) {
                super(2);
                a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
            }

            public final int m19368a() {
                a(0, 0);
                return this.f11365d;
            }

            @Nullable
            public final GraphQLActivityTemplateTokenType m19372b() {
                this.f11366e = (GraphQLActivityTemplateTokenType) super.b(this.f11366e, 1, GraphQLActivityTemplateTokenType.class, GraphQLActivityTemplateTokenType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
                return this.f11366e;
            }

            public static TemplateTokensModel m19367a(TemplateTokensModel templateTokensModel) {
                if (templateTokensModel == null) {
                    return null;
                }
                if (templateTokensModel instanceof TemplateTokensModel) {
                    return templateTokensModel;
                }
                Builder builder = new Builder();
                builder.f11363a = templateTokensModel.m19368a();
                builder.f11364b = templateTokensModel.m19372b();
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                int a = flatBufferBuilder.a(builder.f11364b);
                flatBufferBuilder.c(2);
                flatBufferBuilder.a(0, builder.f11363a, 0);
                flatBufferBuilder.b(1, a);
                flatBufferBuilder.d(flatBufferBuilder.d());
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                return new TemplateTokensModel(new MutableFlatBuffer(wrap, null, null, true, null));
            }

            public final int jK_() {
                return -400689488;
            }

            public final GraphQLVisitableModel m19370a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m19369a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = flatBufferBuilder.a(m19372b());
                flatBufferBuilder.c(2);
                flatBufferBuilder.a(0, this.f11365d, 0);
                flatBufferBuilder.b(1, a);
                i();
                return flatBufferBuilder.d();
            }

            public final void m19371a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                super.a(mutableFlatBuffer, i, obj);
                this.f11365d = mutableFlatBuffer.a(i, 0, 0);
            }
        }

        public MinutiaePreviewTemplateModel() {
            super(2);
        }

        public MinutiaePreviewTemplateModel(MutableFlatBuffer mutableFlatBuffer) {
            super(2);
            a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
        }

        @Nullable
        public final String m19376a() {
            this.f11367d = super.a(this.f11367d, 0);
            return this.f11367d;
        }

        @Nonnull
        public final ImmutableList<TemplateTokensModel> m19377b() {
            this.f11368e = super.a(this.f11368e, 1, TemplateTokensModel.class);
            return (ImmutableList) this.f11368e;
        }

        public static MinutiaePreviewTemplateModel m19373a(MinutiaePreviewTemplateModel minutiaePreviewTemplateModel) {
            if (minutiaePreviewTemplateModel == null) {
                return null;
            }
            if (minutiaePreviewTemplateModel instanceof MinutiaePreviewTemplateModel) {
                return minutiaePreviewTemplateModel;
            }
            Builder builder = new Builder();
            builder.f11361a = minutiaePreviewTemplateModel.m19376a();
            com.google.common.collect.ImmutableList.Builder builder2 = ImmutableList.builder();
            for (int i = 0; i < minutiaePreviewTemplateModel.m19377b().size(); i++) {
                builder2.c(TemplateTokensModel.m19367a((TemplateTokensModel) minutiaePreviewTemplateModel.m19377b().get(i)));
            }
            builder.f11362b = builder2.b();
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
            int b = flatBufferBuilder.b(builder.f11361a);
            int a = ModelHelper.a(flatBufferBuilder, builder.f11362b);
            flatBufferBuilder.c(2);
            flatBufferBuilder.b(0, b);
            flatBufferBuilder.b(1, a);
            flatBufferBuilder.d(flatBufferBuilder.d());
            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
            wrap.position(0);
            return new MinutiaePreviewTemplateModel(new MutableFlatBuffer(wrap, null, null, true, null));
        }

        public final int jK_() {
            return -875449780;
        }

        public final GraphQLVisitableModel m19375a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m19377b() != null) {
                com.google.common.collect.ImmutableList.Builder a = ModelHelper.a(m19377b(), graphQLModelMutatingVisitor);
                if (a != null) {
                    graphQLVisitableModel = (MinutiaePreviewTemplateModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f11368e = a.b();
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m19374a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(m19376a());
            int a = ModelHelper.a(flatBufferBuilder, m19377b());
            flatBufferBuilder.c(2);
            flatBufferBuilder.b(0, b);
            flatBufferBuilder.b(1, a);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -1907873456)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: addresses */
    public final class MinutiaeTaggableActivityFieldsModel extends BaseModel implements MinutiaeTaggableActivityFields, GraphQLPersistableNode, GraphQLVisitableModel {
        @Nullable
        private GlyphModel f11373d;
        @Nullable
        private IconImageLargeModel f11374e;
        @Nullable
        private String f11375f;
        private boolean f11376g;
        @Nullable
        private String f11377h;
        private int f11378i;
        @Nullable
        private String f11379j;
        @Nullable
        private String f11380k;
        private boolean f11381l;
        private boolean f11382m;
        private boolean f11383n;

        /* compiled from: addresses */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(MinutiaeTaggableActivityFieldsModel.class, new Deserializer());
            }

            public Object m19378a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(MinutiaeTaggableActivityFieldsParser.m19523a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object minutiaeTaggableActivityFieldsModel = new MinutiaeTaggableActivityFieldsModel();
                ((BaseModel) minutiaeTaggableActivityFieldsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (minutiaeTaggableActivityFieldsModel instanceof Postprocessable) {
                    return ((Postprocessable) minutiaeTaggableActivityFieldsModel).a();
                }
                return minutiaeTaggableActivityFieldsModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 842551240)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: addresses */
        public final class GlyphModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private String f11370d;

            /* compiled from: addresses */
            public final class Builder {
                @Nullable
                public String f11369a;

                public final GlyphModel m19379a() {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    int b = flatBufferBuilder.b(this.f11369a);
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.b(0, b);
                    flatBufferBuilder.d(flatBufferBuilder.d());
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    return new GlyphModel(new MutableFlatBuffer(wrap, null, null, true, null));
                }
            }

            /* compiled from: addresses */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(GlyphModel.class, new Deserializer());
                }

                public Object m19380a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(GlyphParser.m19519a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object glyphModel = new GlyphModel();
                    ((BaseModel) glyphModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (glyphModel instanceof Postprocessable) {
                        return ((Postprocessable) glyphModel).a();
                    }
                    return glyphModel;
                }
            }

            /* compiled from: addresses */
            public class Serializer extends JsonSerializer<GlyphModel> {
                public final void m19381a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    GlyphModel glyphModel = (GlyphModel) obj;
                    if (glyphModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(glyphModel.m19383a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        glyphModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    GlyphParser.m19520a(glyphModel.w_(), glyphModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(GlyphModel.class, new Serializer());
                }
            }

            public GlyphModel() {
                super(1);
            }

            public GlyphModel(MutableFlatBuffer mutableFlatBuffer) {
                super(1);
                a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
            }

            @Nullable
            public final String m19385a() {
                this.f11370d = super.a(this.f11370d, 0);
                return this.f11370d;
            }

            public static GlyphModel m19382a(GlyphModel glyphModel) {
                if (glyphModel == null) {
                    return null;
                }
                if (glyphModel instanceof GlyphModel) {
                    return glyphModel;
                }
                Builder builder = new Builder();
                builder.f11369a = glyphModel.m19385a();
                return builder.m19379a();
            }

            public final int jK_() {
                return 70760763;
            }

            public final GraphQLVisitableModel m19384a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m19383a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m19385a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, b);
                i();
                return flatBufferBuilder.d();
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 842551240)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: addresses */
        public final class IconImageLargeModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private String f11372d;

            /* compiled from: addresses */
            public final class Builder {
                @Nullable
                public String f11371a;

                public final IconImageLargeModel m19386a() {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    int b = flatBufferBuilder.b(this.f11371a);
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.b(0, b);
                    flatBufferBuilder.d(flatBufferBuilder.d());
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    return new IconImageLargeModel(new MutableFlatBuffer(wrap, null, null, true, null));
                }
            }

            /* compiled from: addresses */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(IconImageLargeModel.class, new Deserializer());
                }

                public Object m19387a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(IconImageLargeParser.m19521a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object iconImageLargeModel = new IconImageLargeModel();
                    ((BaseModel) iconImageLargeModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (iconImageLargeModel instanceof Postprocessable) {
                        return ((Postprocessable) iconImageLargeModel).a();
                    }
                    return iconImageLargeModel;
                }
            }

            /* compiled from: addresses */
            public class Serializer extends JsonSerializer<IconImageLargeModel> {
                public final void m19388a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    IconImageLargeModel iconImageLargeModel = (IconImageLargeModel) obj;
                    if (iconImageLargeModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(iconImageLargeModel.m19390a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        iconImageLargeModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    IconImageLargeParser.m19522a(iconImageLargeModel.w_(), iconImageLargeModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(IconImageLargeModel.class, new Serializer());
                }
            }

            public IconImageLargeModel() {
                super(1);
            }

            public IconImageLargeModel(MutableFlatBuffer mutableFlatBuffer) {
                super(1);
                a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
            }

            @Nullable
            public final String m19392a() {
                this.f11372d = super.a(this.f11372d, 0);
                return this.f11372d;
            }

            public static IconImageLargeModel m19389a(IconImageLargeModel iconImageLargeModel) {
                if (iconImageLargeModel == null) {
                    return null;
                }
                if (iconImageLargeModel instanceof IconImageLargeModel) {
                    return iconImageLargeModel;
                }
                Builder builder = new Builder();
                builder.f11371a = iconImageLargeModel.m19392a();
                return builder.m19386a();
            }

            public final int jK_() {
                return 70760763;
            }

            public final GraphQLVisitableModel m19391a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m19390a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m19392a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, b);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: addresses */
        public class Serializer extends JsonSerializer<MinutiaeTaggableActivityFieldsModel> {
            public final void m19393a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MinutiaeTaggableActivityFieldsModel minutiaeTaggableActivityFieldsModel = (MinutiaeTaggableActivityFieldsModel) obj;
                if (minutiaeTaggableActivityFieldsModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(minutiaeTaggableActivityFieldsModel.m19400a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    minutiaeTaggableActivityFieldsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                MinutiaeTaggableActivityFieldsParser.m19524a(minutiaeTaggableActivityFieldsModel.w_(), minutiaeTaggableActivityFieldsModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(MinutiaeTaggableActivityFieldsModel.class, new Serializer());
            }
        }

        public MinutiaeTaggableActivityFieldsModel() {
            super(11);
        }

        @Nullable
        private GlyphModel m19394j() {
            this.f11373d = (GlyphModel) super.a(this.f11373d, 0, GlyphModel.class);
            return this.f11373d;
        }

        @Nullable
        private IconImageLargeModel m19395k() {
            this.f11374e = (IconImageLargeModel) super.a(this.f11374e, 1, IconImageLargeModel.class);
            return this.f11374e;
        }

        @Nullable
        private String m19396l() {
            this.f11375f = super.a(this.f11375f, 2);
            return this.f11375f;
        }

        @Nullable
        private String m19397m() {
            this.f11377h = super.a(this.f11377h, 4);
            return this.f11377h;
        }

        @Nullable
        private String m19398n() {
            this.f11379j = super.a(this.f11379j, 6);
            return this.f11379j;
        }

        @Nullable
        private String m19399o() {
            this.f11380k = super.a(this.f11380k, 7);
            return this.f11380k;
        }

        @Nullable
        public final String m19402a() {
            return m19396l();
        }

        public final int jK_() {
            return -934090;
        }

        public final GraphQLVisitableModel m19401a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m19394j() != null) {
                GlyphModel glyphModel = (GlyphModel) graphQLModelMutatingVisitor.b(m19394j());
                if (m19394j() != glyphModel) {
                    graphQLVisitableModel = (MinutiaeTaggableActivityFieldsModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f11373d = glyphModel;
                }
            }
            if (m19395k() != null) {
                IconImageLargeModel iconImageLargeModel = (IconImageLargeModel) graphQLModelMutatingVisitor.b(m19395k());
                if (m19395k() != iconImageLargeModel) {
                    graphQLVisitableModel = (MinutiaeTaggableActivityFieldsModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f11374e = iconImageLargeModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m19400a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m19394j());
            int a2 = ModelHelper.a(flatBufferBuilder, m19395k());
            int b = flatBufferBuilder.b(m19396l());
            int b2 = flatBufferBuilder.b(m19397m());
            int b3 = flatBufferBuilder.b(m19398n());
            int b4 = flatBufferBuilder.b(m19399o());
            flatBufferBuilder.c(11);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, a2);
            flatBufferBuilder.b(2, b);
            flatBufferBuilder.a(3, this.f11376g);
            flatBufferBuilder.b(4, b2);
            flatBufferBuilder.a(5, this.f11378i, 0);
            flatBufferBuilder.b(6, b3);
            flatBufferBuilder.b(7, b4);
            flatBufferBuilder.a(8, this.f11381l);
            flatBufferBuilder.a(9, this.f11382m);
            flatBufferBuilder.a(10, this.f11383n);
            i();
            return flatBufferBuilder.d();
        }

        public final void m19403a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
            super.a(mutableFlatBuffer, i, obj);
            this.f11376g = mutableFlatBuffer.a(i, 3);
            this.f11378i = mutableFlatBuffer.a(i, 5, 0);
            this.f11381l = mutableFlatBuffer.a(i, 8);
            this.f11382m = mutableFlatBuffer.a(i, 9);
            this.f11383n = mutableFlatBuffer.a(i, 10);
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -1235937286)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: addresses */
    public final class MinutiaeTaggableActivityIconsModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private AllIconsModel f11386d;

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -812646217)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: addresses */
        public final class AllIconsModel extends BaseModel implements GraphQLVisitableModel {
            private int f11384d;
            @Nullable
            private List<MinutiaeIconModel> f11385e;

            /* compiled from: addresses */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(AllIconsModel.class, new Deserializer());
                }

                public Object m19404a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(AllIconsParser.m19525a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object allIconsModel = new AllIconsModel();
                    ((BaseModel) allIconsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (allIconsModel instanceof Postprocessable) {
                        return ((Postprocessable) allIconsModel).a();
                    }
                    return allIconsModel;
                }
            }

            /* compiled from: addresses */
            public class Serializer extends JsonSerializer<AllIconsModel> {
                public final void m19405a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    AllIconsModel allIconsModel = (AllIconsModel) obj;
                    if (allIconsModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(allIconsModel.m19406a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        allIconsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    AllIconsParser.m19526a(allIconsModel.w_(), allIconsModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(AllIconsModel.class, new Serializer());
                }
            }

            public AllIconsModel() {
                super(2);
            }

            @Nonnull
            public final ImmutableList<MinutiaeIconModel> m19408a() {
                this.f11385e = super.a(this.f11385e, 1, MinutiaeIconModel.class);
                return (ImmutableList) this.f11385e;
            }

            public final int jK_() {
                return -1113843827;
            }

            public final GraphQLVisitableModel m19407a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m19408a() != null) {
                    Builder a = ModelHelper.a(m19408a(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        graphQLVisitableModel = (AllIconsModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f11385e = a.b();
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m19406a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m19408a());
                flatBufferBuilder.c(2);
                flatBufferBuilder.a(0, this.f11384d, 0);
                flatBufferBuilder.b(1, a);
                i();
                return flatBufferBuilder.d();
            }

            public final void m19409a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                super.a(mutableFlatBuffer, i, obj);
                this.f11384d = mutableFlatBuffer.a(i, 0, 0);
            }
        }

        /* compiled from: addresses */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(MinutiaeTaggableActivityIconsModel.class, new Deserializer());
            }

            public Object m19410a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = MinutiaeTaggableActivityIconsParser.m19527a(jsonParser);
                Object minutiaeTaggableActivityIconsModel = new MinutiaeTaggableActivityIconsModel();
                ((BaseModel) minutiaeTaggableActivityIconsModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (minutiaeTaggableActivityIconsModel instanceof Postprocessable) {
                    return ((Postprocessable) minutiaeTaggableActivityIconsModel).a();
                }
                return minutiaeTaggableActivityIconsModel;
            }
        }

        /* compiled from: addresses */
        public class Serializer extends JsonSerializer<MinutiaeTaggableActivityIconsModel> {
            public final void m19411a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                MinutiaeTaggableActivityIconsModel minutiaeTaggableActivityIconsModel = (MinutiaeTaggableActivityIconsModel) obj;
                if (minutiaeTaggableActivityIconsModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(minutiaeTaggableActivityIconsModel.m19412a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    minutiaeTaggableActivityIconsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = minutiaeTaggableActivityIconsModel.w_();
                int u_ = minutiaeTaggableActivityIconsModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("all_icons");
                    AllIconsParser.m19526a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(MinutiaeTaggableActivityIconsModel.class, new Serializer());
            }
        }

        public MinutiaeTaggableActivityIconsModel() {
            super(1);
        }

        @Nullable
        public final AllIconsModel m19413a() {
            this.f11386d = (AllIconsModel) super.a(this.f11386d, 0, AllIconsModel.class);
            return this.f11386d;
        }

        public final int jK_() {
            return -934090;
        }

        public final GraphQLVisitableModel m19414a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m19413a() != null) {
                AllIconsModel allIconsModel = (AllIconsModel) graphQLModelMutatingVisitor.b(m19413a());
                if (m19413a() != allIconsModel) {
                    graphQLVisitableModel = (MinutiaeTaggableActivityIconsModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f11386d = allIconsModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m19412a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m19413a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 1265181912)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: addresses */
    public final class MinutiaeTaggableActivityModel extends BaseModel implements MinutiaeTaggableActivity, GraphQLPersistableNode, GraphQLVisitableModel {
        @Nullable
        private AllIconsModel f11407d;
        @Nullable
        private GlyphModel f11408e;
        @Nullable
        private IconImageLargeModel f11409f;
        @Nullable
        private String f11410g;
        private boolean f11411h;
        @Nullable
        private String f11412i;
        private int f11413j;
        @Nullable
        private String f11414k;
        @Nullable
        private MinutiaePreviewTemplateModel f11415l;
        @Nullable
        private MinutiaePreviewTemplateModel f11416m;
        @Nullable
        private MinutiaePreviewTemplateModel f11417n;
        @Nullable
        private MinutiaePreviewTemplateModel f11418o;
        @Nullable
        private MinutiaePreviewTemplateModel f11419p;
        @Nullable
        private MinutiaePreviewTemplateModel f11420q;
        @Nullable
        private String f11421r;
        private boolean f11422s;
        private boolean f11423t;
        private boolean f11424u;

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1723990064)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: addresses */
        public final class AllIconsModel extends BaseModel implements GraphQLVisitableModel {
            private int f11388d;

            /* compiled from: addresses */
            public final class Builder {
                public int f11387a;

                public final AllIconsModel m19415a() {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.a(0, this.f11387a, 0);
                    flatBufferBuilder.d(flatBufferBuilder.d());
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    return new AllIconsModel(new MutableFlatBuffer(wrap, null, null, true, null));
                }
            }

            /* compiled from: addresses */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(AllIconsModel.class, new Deserializer());
                }

                public Object m19416a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(MinutiaeTaggableActivityParser.AllIconsParser.m19528a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object allIconsModel = new AllIconsModel();
                    ((BaseModel) allIconsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (allIconsModel instanceof Postprocessable) {
                        return ((Postprocessable) allIconsModel).a();
                    }
                    return allIconsModel;
                }
            }

            /* compiled from: addresses */
            public class Serializer extends JsonSerializer<AllIconsModel> {
                public final void m19417a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    AllIconsModel allIconsModel = (AllIconsModel) obj;
                    if (allIconsModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(allIconsModel.m19420a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        allIconsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    MinutiaeTaggableActivityParser.AllIconsParser.m19529a(allIconsModel.w_(), allIconsModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(AllIconsModel.class, new Serializer());
                }
            }

            public AllIconsModel() {
                super(1);
            }

            public AllIconsModel(MutableFlatBuffer mutableFlatBuffer) {
                super(1);
                a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
            }

            public final int m19419a() {
                a(0, 0);
                return this.f11388d;
            }

            public static AllIconsModel m19418a(AllIconsModel allIconsModel) {
                if (allIconsModel == null) {
                    return null;
                }
                if (allIconsModel instanceof AllIconsModel) {
                    return allIconsModel;
                }
                Builder builder = new Builder();
                builder.f11387a = allIconsModel.m19419a();
                return builder.m19415a();
            }

            public final int jK_() {
                return -1113843827;
            }

            public final GraphQLVisitableModel m19421a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m19420a(FlatBufferBuilder flatBufferBuilder) {
                h();
                flatBufferBuilder.c(1);
                flatBufferBuilder.a(0, this.f11388d, 0);
                i();
                return flatBufferBuilder.d();
            }

            public final void m19422a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                super.a(mutableFlatBuffer, i, obj);
                this.f11388d = mutableFlatBuffer.a(i, 0, 0);
            }
        }

        /* compiled from: addresses */
        public final class Builder {
            @Nullable
            public AllIconsModel f11389a;
            @Nullable
            public GlyphModel f11390b;
            @Nullable
            public IconImageLargeModel f11391c;
            @Nullable
            public String f11392d;
            public boolean f11393e;
            @Nullable
            public String f11394f;
            public int f11395g;
            @Nullable
            public String f11396h;
            @Nullable
            public MinutiaePreviewTemplateModel f11397i;
            @Nullable
            public MinutiaePreviewTemplateModel f11398j;
            @Nullable
            public MinutiaePreviewTemplateModel f11399k;
            @Nullable
            public MinutiaePreviewTemplateModel f11400l;
            @Nullable
            public MinutiaePreviewTemplateModel f11401m;
            @Nullable
            public MinutiaePreviewTemplateModel f11402n;
            @Nullable
            public String f11403o;
            public boolean f11404p;
            public boolean f11405q;
            public boolean f11406r;

            public static Builder m19423a(MinutiaeTaggableActivityModel minutiaeTaggableActivityModel) {
                Builder builder = new Builder();
                builder.f11389a = minutiaeTaggableActivityModel.m19451s();
                builder.f11390b = minutiaeTaggableActivityModel.m19430C();
                builder.f11391c = minutiaeTaggableActivityModel.m19431D();
                builder.f11392d = minutiaeTaggableActivityModel.mo1193j();
                builder.f11393e = minutiaeTaggableActivityModel.mo1194k();
                builder.f11394f = minutiaeTaggableActivityModel.mo1195l();
                builder.f11395g = minutiaeTaggableActivityModel.mo1196m();
                builder.f11396h = minutiaeTaggableActivityModel.mo1197n();
                builder.f11397i = minutiaeTaggableActivityModel.m19432E();
                builder.f11398j = minutiaeTaggableActivityModel.m19433F();
                builder.f11399k = minutiaeTaggableActivityModel.m19434G();
                builder.f11400l = minutiaeTaggableActivityModel.m19435H();
                builder.f11401m = minutiaeTaggableActivityModel.m19436I();
                builder.f11402n = minutiaeTaggableActivityModel.m19437J();
                builder.f11403o = minutiaeTaggableActivityModel.mo1198o();
                builder.f11404p = minutiaeTaggableActivityModel.mo1199p();
                builder.f11405q = minutiaeTaggableActivityModel.mo1200q();
                builder.f11406r = minutiaeTaggableActivityModel.mo1201r();
                return builder;
            }

            public final MinutiaeTaggableActivityModel m19424a() {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                int a = ModelHelper.a(flatBufferBuilder, this.f11389a);
                int a2 = ModelHelper.a(flatBufferBuilder, this.f11390b);
                int a3 = ModelHelper.a(flatBufferBuilder, this.f11391c);
                int b = flatBufferBuilder.b(this.f11392d);
                int b2 = flatBufferBuilder.b(this.f11394f);
                int b3 = flatBufferBuilder.b(this.f11396h);
                int a4 = ModelHelper.a(flatBufferBuilder, this.f11397i);
                int a5 = ModelHelper.a(flatBufferBuilder, this.f11398j);
                int a6 = ModelHelper.a(flatBufferBuilder, this.f11399k);
                int a7 = ModelHelper.a(flatBufferBuilder, this.f11400l);
                int a8 = ModelHelper.a(flatBufferBuilder, this.f11401m);
                int a9 = ModelHelper.a(flatBufferBuilder, this.f11402n);
                int b4 = flatBufferBuilder.b(this.f11403o);
                flatBufferBuilder.c(18);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.b(1, a2);
                flatBufferBuilder.b(2, a3);
                flatBufferBuilder.b(3, b);
                flatBufferBuilder.a(4, this.f11393e);
                flatBufferBuilder.b(5, b2);
                flatBufferBuilder.a(6, this.f11395g, 0);
                flatBufferBuilder.b(7, b3);
                flatBufferBuilder.b(8, a4);
                flatBufferBuilder.b(9, a5);
                flatBufferBuilder.b(10, a6);
                flatBufferBuilder.b(11, a7);
                flatBufferBuilder.b(12, a8);
                flatBufferBuilder.b(13, a9);
                flatBufferBuilder.b(14, b4);
                flatBufferBuilder.a(15, this.f11404p);
                flatBufferBuilder.a(16, this.f11405q);
                flatBufferBuilder.a(17, this.f11406r);
                flatBufferBuilder.d(flatBufferBuilder.d());
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                return new MinutiaeTaggableActivityModel(new MutableFlatBuffer(wrap, null, null, true, null));
            }
        }

        /* compiled from: addresses */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(MinutiaeTaggableActivityModel.class, new Deserializer());
            }

            public Object m19425a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(MinutiaeTaggableActivityParser.m19530a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object minutiaeTaggableActivityModel = new MinutiaeTaggableActivityModel();
                ((BaseModel) minutiaeTaggableActivityModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (minutiaeTaggableActivityModel instanceof Postprocessable) {
                    return ((Postprocessable) minutiaeTaggableActivityModel).a();
                }
                return minutiaeTaggableActivityModel;
            }
        }

        /* compiled from: addresses */
        public class Serializer extends JsonSerializer<MinutiaeTaggableActivityModel> {
            public final void m19426a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MinutiaeTaggableActivityModel minutiaeTaggableActivityModel = (MinutiaeTaggableActivityModel) obj;
                if (minutiaeTaggableActivityModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(minutiaeTaggableActivityModel.m19438a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    minutiaeTaggableActivityModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                MinutiaeTaggableActivityParser.m19531b(minutiaeTaggableActivityModel.w_(), minutiaeTaggableActivityModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(MinutiaeTaggableActivityModel.class, new Serializer());
            }
        }

        @Nullable
        public final /* synthetic */ GlyphModel mo1191A() {
            return m19430C();
        }

        @Nullable
        public final /* synthetic */ AllIconsModel mo1192B() {
            return m19451s();
        }

        @Nullable
        public final /* synthetic */ MinutiaePreviewTemplateModel mo1185t() {
            return m19437J();
        }

        @Nullable
        public final /* synthetic */ MinutiaePreviewTemplateModel mo1186u() {
            return m19436I();
        }

        @Nullable
        public final /* synthetic */ MinutiaePreviewTemplateModel mo1187v() {
            return m19435H();
        }

        @Nullable
        public final /* synthetic */ MinutiaePreviewTemplateModel mo1188w() {
            return m19434G();
        }

        @Nullable
        public final /* synthetic */ MinutiaePreviewTemplateModel mo1189x() {
            return m19433F();
        }

        @Nullable
        public final /* synthetic */ MinutiaePreviewTemplateModel mo1190y() {
            return m19432E();
        }

        @Nullable
        public final /* synthetic */ IconImageLargeModel mo1202z() {
            return m19431D();
        }

        public MinutiaeTaggableActivityModel() {
            super(18);
        }

        public MinutiaeTaggableActivityModel(MutableFlatBuffer mutableFlatBuffer) {
            super(18);
            a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
        }

        @Nullable
        public final AllIconsModel m19451s() {
            this.f11407d = (AllIconsModel) super.a(this.f11407d, 0, AllIconsModel.class);
            return this.f11407d;
        }

        @Nullable
        public final GlyphModel m19430C() {
            this.f11408e = (GlyphModel) super.a(this.f11408e, 1, GlyphModel.class);
            return this.f11408e;
        }

        @Nullable
        public final IconImageLargeModel m19431D() {
            this.f11409f = (IconImageLargeModel) super.a(this.f11409f, 2, IconImageLargeModel.class);
            return this.f11409f;
        }

        @Nullable
        public final String mo1193j() {
            this.f11410g = super.a(this.f11410g, 3);
            return this.f11410g;
        }

        public final boolean mo1194k() {
            a(0, 4);
            return this.f11411h;
        }

        @Nullable
        public final String mo1195l() {
            this.f11412i = super.a(this.f11412i, 5);
            return this.f11412i;
        }

        public final int mo1196m() {
            a(0, 6);
            return this.f11413j;
        }

        @Nullable
        public final String mo1197n() {
            this.f11414k = super.a(this.f11414k, 7);
            return this.f11414k;
        }

        @Nullable
        public final MinutiaePreviewTemplateModel m19432E() {
            this.f11415l = (MinutiaePreviewTemplateModel) super.a(this.f11415l, 8, MinutiaePreviewTemplateModel.class);
            return this.f11415l;
        }

        @Nullable
        public final MinutiaePreviewTemplateModel m19433F() {
            this.f11416m = (MinutiaePreviewTemplateModel) super.a(this.f11416m, 9, MinutiaePreviewTemplateModel.class);
            return this.f11416m;
        }

        @Nullable
        public final MinutiaePreviewTemplateModel m19434G() {
            this.f11417n = (MinutiaePreviewTemplateModel) super.a(this.f11417n, 10, MinutiaePreviewTemplateModel.class);
            return this.f11417n;
        }

        @Nullable
        public final MinutiaePreviewTemplateModel m19435H() {
            this.f11418o = (MinutiaePreviewTemplateModel) super.a(this.f11418o, 11, MinutiaePreviewTemplateModel.class);
            return this.f11418o;
        }

        @Nullable
        public final MinutiaePreviewTemplateModel m19436I() {
            this.f11419p = (MinutiaePreviewTemplateModel) super.a(this.f11419p, 12, MinutiaePreviewTemplateModel.class);
            return this.f11419p;
        }

        @Nullable
        public final MinutiaePreviewTemplateModel m19437J() {
            this.f11420q = (MinutiaePreviewTemplateModel) super.a(this.f11420q, 13, MinutiaePreviewTemplateModel.class);
            return this.f11420q;
        }

        @Nullable
        public final String mo1198o() {
            this.f11421r = super.a(this.f11421r, 14);
            return this.f11421r;
        }

        public final boolean mo1199p() {
            a(1, 7);
            return this.f11422s;
        }

        public final boolean mo1200q() {
            a(2, 0);
            return this.f11423t;
        }

        public final boolean mo1201r() {
            a(2, 1);
            return this.f11424u;
        }

        public static MinutiaeTaggableActivityModel m19427a(MinutiaeTaggableActivity minutiaeTaggableActivity) {
            if (minutiaeTaggableActivity == null) {
                return null;
            }
            if (minutiaeTaggableActivity instanceof MinutiaeTaggableActivityModel) {
                return (MinutiaeTaggableActivityModel) minutiaeTaggableActivity;
            }
            Builder builder = new Builder();
            builder.f11389a = AllIconsModel.m19418a(minutiaeTaggableActivity.mo1192B());
            builder.f11390b = GlyphModel.m19382a(minutiaeTaggableActivity.mo1191A());
            builder.f11391c = IconImageLargeModel.m19389a(minutiaeTaggableActivity.mo1202z());
            builder.f11392d = minutiaeTaggableActivity.mo1193j();
            builder.f11393e = minutiaeTaggableActivity.mo1194k();
            builder.f11394f = minutiaeTaggableActivity.mo1195l();
            builder.f11395g = minutiaeTaggableActivity.mo1196m();
            builder.f11396h = minutiaeTaggableActivity.mo1197n();
            builder.f11397i = MinutiaePreviewTemplateModel.m19373a(minutiaeTaggableActivity.mo1190y());
            builder.f11398j = MinutiaePreviewTemplateModel.m19373a(minutiaeTaggableActivity.mo1189x());
            builder.f11399k = MinutiaePreviewTemplateModel.m19373a(minutiaeTaggableActivity.mo1188w());
            builder.f11400l = MinutiaePreviewTemplateModel.m19373a(minutiaeTaggableActivity.mo1187v());
            builder.f11401m = MinutiaePreviewTemplateModel.m19373a(minutiaeTaggableActivity.mo1186u());
            builder.f11402n = MinutiaePreviewTemplateModel.m19373a(minutiaeTaggableActivity.mo1185t());
            builder.f11403o = minutiaeTaggableActivity.mo1198o();
            builder.f11404p = minutiaeTaggableActivity.mo1199p();
            builder.f11405q = minutiaeTaggableActivity.mo1200q();
            builder.f11406r = minutiaeTaggableActivity.mo1201r();
            return builder.m19424a();
        }

        @Nullable
        public final String m19440a() {
            return mo1193j();
        }

        public final int jK_() {
            return -934090;
        }

        public final GraphQLVisitableModel m19439a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            MinutiaePreviewTemplateModel minutiaePreviewTemplateModel;
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m19451s() != null) {
                AllIconsModel allIconsModel = (AllIconsModel) graphQLModelMutatingVisitor.b(m19451s());
                if (m19451s() != allIconsModel) {
                    graphQLVisitableModel = (MinutiaeTaggableActivityModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f11407d = allIconsModel;
                }
            }
            if (m19430C() != null) {
                GlyphModel glyphModel = (GlyphModel) graphQLModelMutatingVisitor.b(m19430C());
                if (m19430C() != glyphModel) {
                    graphQLVisitableModel = (MinutiaeTaggableActivityModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f11408e = glyphModel;
                }
            }
            if (m19431D() != null) {
                IconImageLargeModel iconImageLargeModel = (IconImageLargeModel) graphQLModelMutatingVisitor.b(m19431D());
                if (m19431D() != iconImageLargeModel) {
                    graphQLVisitableModel = (MinutiaeTaggableActivityModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f11409f = iconImageLargeModel;
                }
            }
            if (m19432E() != null) {
                minutiaePreviewTemplateModel = (MinutiaePreviewTemplateModel) graphQLModelMutatingVisitor.b(m19432E());
                if (m19432E() != minutiaePreviewTemplateModel) {
                    graphQLVisitableModel = (MinutiaeTaggableActivityModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f11415l = minutiaePreviewTemplateModel;
                }
            }
            if (m19433F() != null) {
                minutiaePreviewTemplateModel = (MinutiaePreviewTemplateModel) graphQLModelMutatingVisitor.b(m19433F());
                if (m19433F() != minutiaePreviewTemplateModel) {
                    graphQLVisitableModel = (MinutiaeTaggableActivityModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f11416m = minutiaePreviewTemplateModel;
                }
            }
            if (m19434G() != null) {
                minutiaePreviewTemplateModel = (MinutiaePreviewTemplateModel) graphQLModelMutatingVisitor.b(m19434G());
                if (m19434G() != minutiaePreviewTemplateModel) {
                    graphQLVisitableModel = (MinutiaeTaggableActivityModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f11417n = minutiaePreviewTemplateModel;
                }
            }
            if (m19435H() != null) {
                minutiaePreviewTemplateModel = (MinutiaePreviewTemplateModel) graphQLModelMutatingVisitor.b(m19435H());
                if (m19435H() != minutiaePreviewTemplateModel) {
                    graphQLVisitableModel = (MinutiaeTaggableActivityModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f11418o = minutiaePreviewTemplateModel;
                }
            }
            if (m19436I() != null) {
                minutiaePreviewTemplateModel = (MinutiaePreviewTemplateModel) graphQLModelMutatingVisitor.b(m19436I());
                if (m19436I() != minutiaePreviewTemplateModel) {
                    graphQLVisitableModel = (MinutiaeTaggableActivityModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f11419p = minutiaePreviewTemplateModel;
                }
            }
            if (m19437J() != null) {
                minutiaePreviewTemplateModel = (MinutiaePreviewTemplateModel) graphQLModelMutatingVisitor.b(m19437J());
                if (m19437J() != minutiaePreviewTemplateModel) {
                    graphQLVisitableModel = (MinutiaeTaggableActivityModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f11420q = minutiaePreviewTemplateModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m19438a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m19451s());
            int a2 = ModelHelper.a(flatBufferBuilder, m19430C());
            int a3 = ModelHelper.a(flatBufferBuilder, m19431D());
            int b = flatBufferBuilder.b(mo1193j());
            int b2 = flatBufferBuilder.b(mo1195l());
            int b3 = flatBufferBuilder.b(mo1197n());
            int a4 = ModelHelper.a(flatBufferBuilder, m19432E());
            int a5 = ModelHelper.a(flatBufferBuilder, m19433F());
            int a6 = ModelHelper.a(flatBufferBuilder, m19434G());
            int a7 = ModelHelper.a(flatBufferBuilder, m19435H());
            int a8 = ModelHelper.a(flatBufferBuilder, m19436I());
            int a9 = ModelHelper.a(flatBufferBuilder, m19437J());
            int b4 = flatBufferBuilder.b(mo1198o());
            flatBufferBuilder.c(18);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, a2);
            flatBufferBuilder.b(2, a3);
            flatBufferBuilder.b(3, b);
            flatBufferBuilder.a(4, this.f11411h);
            flatBufferBuilder.b(5, b2);
            flatBufferBuilder.a(6, this.f11413j, 0);
            flatBufferBuilder.b(7, b3);
            flatBufferBuilder.b(8, a4);
            flatBufferBuilder.b(9, a5);
            flatBufferBuilder.b(10, a6);
            flatBufferBuilder.b(11, a7);
            flatBufferBuilder.b(12, a8);
            flatBufferBuilder.b(13, a9);
            flatBufferBuilder.b(14, b4);
            flatBufferBuilder.a(15, this.f11422s);
            flatBufferBuilder.a(16, this.f11423t);
            flatBufferBuilder.a(17, this.f11424u);
            i();
            return flatBufferBuilder.d();
        }

        public final void m19441a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
            super.a(mutableFlatBuffer, i, obj);
            this.f11411h = mutableFlatBuffer.a(i, 4);
            this.f11413j = mutableFlatBuffer.a(i, 6, 0);
            this.f11422s = mutableFlatBuffer.a(i, 15);
            this.f11423t = mutableFlatBuffer.a(i, 16);
            this.f11424u = mutableFlatBuffer.a(i, 17);
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -1249306621)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: addresses */
    public final class MinutiaeTaggableActivityPreviewTemplateFieldsModel extends BaseModel implements MinutiaeTaggableActivityPreviewTemplateFields, GraphQLVisitableModel {
        @Nullable
        private MinutiaePreviewTemplateModel f11425d;
        @Nullable
        private MinutiaePreviewTemplateModel f11426e;
        @Nullable
        private MinutiaePreviewTemplateModel f11427f;
        @Nullable
        private MinutiaePreviewTemplateModel f11428g;
        @Nullable
        private MinutiaePreviewTemplateModel f11429h;
        @Nullable
        private MinutiaePreviewTemplateModel f11430i;

        /* compiled from: addresses */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(MinutiaeTaggableActivityPreviewTemplateFieldsModel.class, new Deserializer());
            }

            public Object m19459a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(MinutiaeTaggableActivityPreviewTemplateFieldsParser.m19532a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object minutiaeTaggableActivityPreviewTemplateFieldsModel = new MinutiaeTaggableActivityPreviewTemplateFieldsModel();
                ((BaseModel) minutiaeTaggableActivityPreviewTemplateFieldsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (minutiaeTaggableActivityPreviewTemplateFieldsModel instanceof Postprocessable) {
                    return ((Postprocessable) minutiaeTaggableActivityPreviewTemplateFieldsModel).a();
                }
                return minutiaeTaggableActivityPreviewTemplateFieldsModel;
            }
        }

        /* compiled from: addresses */
        public class Serializer extends JsonSerializer<MinutiaeTaggableActivityPreviewTemplateFieldsModel> {
            public final void m19460a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MinutiaeTaggableActivityPreviewTemplateFieldsModel minutiaeTaggableActivityPreviewTemplateFieldsModel = (MinutiaeTaggableActivityPreviewTemplateFieldsModel) obj;
                if (minutiaeTaggableActivityPreviewTemplateFieldsModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(minutiaeTaggableActivityPreviewTemplateFieldsModel.m19467a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    minutiaeTaggableActivityPreviewTemplateFieldsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                MinutiaeTaggableActivityPreviewTemplateFieldsParser.m19533a(minutiaeTaggableActivityPreviewTemplateFieldsModel.w_(), minutiaeTaggableActivityPreviewTemplateFieldsModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(MinutiaeTaggableActivityPreviewTemplateFieldsModel.class, new Serializer());
            }
        }

        @Nullable
        public final /* synthetic */ MinutiaePreviewTemplateModel mo1185t() {
            return m19466n();
        }

        @Nullable
        public final /* synthetic */ MinutiaePreviewTemplateModel mo1186u() {
            return m19465m();
        }

        @Nullable
        public final /* synthetic */ MinutiaePreviewTemplateModel mo1187v() {
            return m19464l();
        }

        @Nullable
        public final /* synthetic */ MinutiaePreviewTemplateModel mo1188w() {
            return m19463k();
        }

        @Nullable
        public final /* synthetic */ MinutiaePreviewTemplateModel mo1189x() {
            return m19462j();
        }

        @Nullable
        public final /* synthetic */ MinutiaePreviewTemplateModel mo1190y() {
            return m19461a();
        }

        public MinutiaeTaggableActivityPreviewTemplateFieldsModel() {
            super(6);
        }

        @Nullable
        private MinutiaePreviewTemplateModel m19461a() {
            this.f11425d = (MinutiaePreviewTemplateModel) super.a(this.f11425d, 0, MinutiaePreviewTemplateModel.class);
            return this.f11425d;
        }

        @Nullable
        private MinutiaePreviewTemplateModel m19462j() {
            this.f11426e = (MinutiaePreviewTemplateModel) super.a(this.f11426e, 1, MinutiaePreviewTemplateModel.class);
            return this.f11426e;
        }

        @Nullable
        private MinutiaePreviewTemplateModel m19463k() {
            this.f11427f = (MinutiaePreviewTemplateModel) super.a(this.f11427f, 2, MinutiaePreviewTemplateModel.class);
            return this.f11427f;
        }

        @Nullable
        private MinutiaePreviewTemplateModel m19464l() {
            this.f11428g = (MinutiaePreviewTemplateModel) super.a(this.f11428g, 3, MinutiaePreviewTemplateModel.class);
            return this.f11428g;
        }

        @Nullable
        private MinutiaePreviewTemplateModel m19465m() {
            this.f11429h = (MinutiaePreviewTemplateModel) super.a(this.f11429h, 4, MinutiaePreviewTemplateModel.class);
            return this.f11429h;
        }

        @Nullable
        private MinutiaePreviewTemplateModel m19466n() {
            this.f11430i = (MinutiaePreviewTemplateModel) super.a(this.f11430i, 5, MinutiaePreviewTemplateModel.class);
            return this.f11430i;
        }

        public final int jK_() {
            return -934090;
        }

        public final GraphQLVisitableModel m19468a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            MinutiaePreviewTemplateModel minutiaePreviewTemplateModel;
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m19461a() != null) {
                minutiaePreviewTemplateModel = (MinutiaePreviewTemplateModel) graphQLModelMutatingVisitor.b(m19461a());
                if (m19461a() != minutiaePreviewTemplateModel) {
                    graphQLVisitableModel = (MinutiaeTaggableActivityPreviewTemplateFieldsModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f11425d = minutiaePreviewTemplateModel;
                }
            }
            if (m19462j() != null) {
                minutiaePreviewTemplateModel = (MinutiaePreviewTemplateModel) graphQLModelMutatingVisitor.b(m19462j());
                if (m19462j() != minutiaePreviewTemplateModel) {
                    graphQLVisitableModel = (MinutiaeTaggableActivityPreviewTemplateFieldsModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f11426e = minutiaePreviewTemplateModel;
                }
            }
            if (m19463k() != null) {
                minutiaePreviewTemplateModel = (MinutiaePreviewTemplateModel) graphQLModelMutatingVisitor.b(m19463k());
                if (m19463k() != minutiaePreviewTemplateModel) {
                    graphQLVisitableModel = (MinutiaeTaggableActivityPreviewTemplateFieldsModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f11427f = minutiaePreviewTemplateModel;
                }
            }
            if (m19464l() != null) {
                minutiaePreviewTemplateModel = (MinutiaePreviewTemplateModel) graphQLModelMutatingVisitor.b(m19464l());
                if (m19464l() != minutiaePreviewTemplateModel) {
                    graphQLVisitableModel = (MinutiaeTaggableActivityPreviewTemplateFieldsModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f11428g = minutiaePreviewTemplateModel;
                }
            }
            if (m19465m() != null) {
                minutiaePreviewTemplateModel = (MinutiaePreviewTemplateModel) graphQLModelMutatingVisitor.b(m19465m());
                if (m19465m() != minutiaePreviewTemplateModel) {
                    graphQLVisitableModel = (MinutiaeTaggableActivityPreviewTemplateFieldsModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f11429h = minutiaePreviewTemplateModel;
                }
            }
            if (m19466n() != null) {
                minutiaePreviewTemplateModel = (MinutiaePreviewTemplateModel) graphQLModelMutatingVisitor.b(m19466n());
                if (m19466n() != minutiaePreviewTemplateModel) {
                    graphQLVisitableModel = (MinutiaeTaggableActivityPreviewTemplateFieldsModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f11430i = minutiaePreviewTemplateModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m19467a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m19461a());
            int a2 = ModelHelper.a(flatBufferBuilder, m19462j());
            int a3 = ModelHelper.a(flatBufferBuilder, m19463k());
            int a4 = ModelHelper.a(flatBufferBuilder, m19464l());
            int a5 = ModelHelper.a(flatBufferBuilder, m19465m());
            int a6 = ModelHelper.a(flatBufferBuilder, m19466n());
            flatBufferBuilder.c(6);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, a2);
            flatBufferBuilder.b(2, a3);
            flatBufferBuilder.b(3, a4);
            flatBufferBuilder.b(4, a5);
            flatBufferBuilder.b(5, a6);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -1476040714)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: addresses */
    public final class MinutiaeTaggableObjectFieldsModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel, LinkifyTargetGraphQL {
        @Nullable
        private GraphQLObjectType f11446d;
        @Nullable
        private String f11447e;
        private boolean f11448f;
        @Nullable
        private String f11449g;
        @Nullable
        private OpenGraphComposerPreviewModel f11450h;
        @Nullable
        private PageModel f11451i;
        @Nullable
        private ProfilePictureModel f11452j;
        @Nullable
        private DefaultImageFieldsModel f11453k;
        @Nullable
        private String f11454l;

        /* compiled from: addresses */
        public final class Builder {
            @Nullable
            public GraphQLObjectType f11431a;
            @Nullable
            public String f11432b;
            public boolean f11433c;
            @Nullable
            public String f11434d;
            @Nullable
            public OpenGraphComposerPreviewModel f11435e;
            @Nullable
            public PageModel f11436f;
            @Nullable
            public ProfilePictureModel f11437g;
            @Nullable
            public DefaultImageFieldsModel f11438h;
            @Nullable
            public String f11439i;

            public final MinutiaeTaggableObjectFieldsModel m19475a() {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                int a = ModelHelper.a(flatBufferBuilder, this.f11431a);
                int b = flatBufferBuilder.b(this.f11432b);
                int b2 = flatBufferBuilder.b(this.f11434d);
                int a2 = ModelHelper.a(flatBufferBuilder, this.f11435e);
                int a3 = ModelHelper.a(flatBufferBuilder, this.f11436f);
                int a4 = ModelHelper.a(flatBufferBuilder, this.f11437g);
                int a5 = ModelHelper.a(flatBufferBuilder, this.f11438h);
                int b3 = flatBufferBuilder.b(this.f11439i);
                flatBufferBuilder.c(9);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.b(1, b);
                flatBufferBuilder.a(2, this.f11433c);
                flatBufferBuilder.b(3, b2);
                flatBufferBuilder.b(4, a2);
                flatBufferBuilder.b(5, a3);
                flatBufferBuilder.b(6, a4);
                flatBufferBuilder.b(7, a5);
                flatBufferBuilder.b(8, b3);
                flatBufferBuilder.d(flatBufferBuilder.d());
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                return new MinutiaeTaggableObjectFieldsModel(new MutableFlatBuffer(wrap, null, null, true, null));
            }
        }

        /* compiled from: addresses */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(MinutiaeTaggableObjectFieldsModel.class, new Deserializer());
            }

            public Object m19476a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(MinutiaeTaggableObjectFieldsParser.m19538a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object minutiaeTaggableObjectFieldsModel = new MinutiaeTaggableObjectFieldsModel();
                ((BaseModel) minutiaeTaggableObjectFieldsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (minutiaeTaggableObjectFieldsModel instanceof Postprocessable) {
                    return ((Postprocessable) minutiaeTaggableObjectFieldsModel).a();
                }
                return minutiaeTaggableObjectFieldsModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 1317720611)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: addresses */
        public final class OpenGraphComposerPreviewModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private List<GraphQLStoryAttachmentStyle> f11441d;

            /* compiled from: addresses */
            public final class Builder {
                @Nullable
                public ImmutableList<GraphQLStoryAttachmentStyle> f11440a;
            }

            /* compiled from: addresses */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(OpenGraphComposerPreviewModel.class, new Deserializer());
                }

                public Object m19477a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(OpenGraphComposerPreviewParser.m19534a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object openGraphComposerPreviewModel = new OpenGraphComposerPreviewModel();
                    ((BaseModel) openGraphComposerPreviewModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (openGraphComposerPreviewModel instanceof Postprocessable) {
                        return ((Postprocessable) openGraphComposerPreviewModel).a();
                    }
                    return openGraphComposerPreviewModel;
                }
            }

            /* compiled from: addresses */
            public class Serializer extends JsonSerializer<OpenGraphComposerPreviewModel> {
                public final void m19478a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    OpenGraphComposerPreviewModel openGraphComposerPreviewModel = (OpenGraphComposerPreviewModel) obj;
                    if (openGraphComposerPreviewModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(openGraphComposerPreviewModel.m19480a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        openGraphComposerPreviewModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    OpenGraphComposerPreviewParser.m19535a(openGraphComposerPreviewModel.w_(), openGraphComposerPreviewModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(OpenGraphComposerPreviewModel.class, new Serializer());
                }
            }

            public OpenGraphComposerPreviewModel() {
                super(1);
            }

            public OpenGraphComposerPreviewModel(MutableFlatBuffer mutableFlatBuffer) {
                super(1);
                a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
            }

            @Nonnull
            public final ImmutableList<GraphQLStoryAttachmentStyle> m19482a() {
                this.f11441d = super.c(this.f11441d, 0, GraphQLStoryAttachmentStyle.class);
                return (ImmutableList) this.f11441d;
            }

            public static OpenGraphComposerPreviewModel m19479a(OpenGraphComposerPreviewModel openGraphComposerPreviewModel) {
                if (openGraphComposerPreviewModel == null) {
                    return null;
                }
                if (openGraphComposerPreviewModel instanceof OpenGraphComposerPreviewModel) {
                    return openGraphComposerPreviewModel;
                }
                Builder builder = new Builder();
                com.google.common.collect.ImmutableList.Builder builder2 = ImmutableList.builder();
                for (int i = 0; i < openGraphComposerPreviewModel.m19482a().size(); i++) {
                    builder2.c(openGraphComposerPreviewModel.m19482a().get(i));
                }
                builder.f11440a = builder2.b();
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                int d = flatBufferBuilder.d(builder.f11440a);
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, d);
                flatBufferBuilder.d(flatBufferBuilder.d());
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                return new OpenGraphComposerPreviewModel(new MutableFlatBuffer(wrap, null, null, true, null));
            }

            public final int jK_() {
                return -1267730472;
            }

            public final GraphQLVisitableModel m19481a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m19480a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int d = flatBufferBuilder.d(m19482a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, d);
                i();
                return flatBufferBuilder.d();
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 966111691)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: addresses */
        public final class PageModel extends BaseModel implements GraphQLVisitableConsistentModel {
            private boolean f11444d;
            @Nullable
            private String f11445e;

            /* compiled from: addresses */
            public final class Builder {
                public boolean f11442a;
                @Nullable
                public String f11443b;
            }

            /* compiled from: addresses */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(PageModel.class, new Deserializer());
                }

                public Object m19483a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(PageParser.m19536a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object pageModel = new PageModel();
                    ((BaseModel) pageModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (pageModel instanceof Postprocessable) {
                        return ((Postprocessable) pageModel).a();
                    }
                    return pageModel;
                }
            }

            /* compiled from: addresses */
            public class Serializer extends JsonSerializer<PageModel> {
                public final void m19484a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    PageModel pageModel = (PageModel) obj;
                    if (pageModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(pageModel.m19486a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        pageModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    PageParser.m19537a(pageModel.w_(), pageModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(PageModel.class, new Serializer());
                }
            }

            public PageModel() {
                super(2);
            }

            public PageModel(MutableFlatBuffer mutableFlatBuffer) {
                super(2);
                a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
            }

            public final void m19489a(String str, ConsistencyTuple consistencyTuple) {
                consistencyTuple.a();
            }

            public final void m19490a(String str, Object obj, boolean z) {
            }

            public final boolean m19491a() {
                a(0, 0);
                return this.f11444d;
            }

            @Nullable
            public final String m19492b() {
                this.f11445e = super.a(this.f11445e, 1);
                return this.f11445e;
            }

            public static PageModel m19485a(PageModel pageModel) {
                if (pageModel == null) {
                    return null;
                }
                if (pageModel instanceof PageModel) {
                    return pageModel;
                }
                Builder builder = new Builder();
                builder.f11442a = pageModel.m19491a();
                builder.f11443b = pageModel.m19492b();
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                int b = flatBufferBuilder.b(builder.f11443b);
                flatBufferBuilder.c(2);
                flatBufferBuilder.a(0, builder.f11442a);
                flatBufferBuilder.b(1, b);
                flatBufferBuilder.d(flatBufferBuilder.d());
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                return new PageModel(new MutableFlatBuffer(wrap, null, null, true, null));
            }

            public final int jK_() {
                return 2479791;
            }

            public final GraphQLVisitableModel m19487a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m19486a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m19492b());
                flatBufferBuilder.c(2);
                flatBufferBuilder.a(0, this.f11444d);
                flatBufferBuilder.b(1, b);
                i();
                return flatBufferBuilder.d();
            }

            public final void m19488a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                super.a(mutableFlatBuffer, i, obj);
                this.f11444d = mutableFlatBuffer.a(i, 0);
            }
        }

        /* compiled from: addresses */
        public class Serializer extends JsonSerializer<MinutiaeTaggableObjectFieldsModel> {
            public final void m19493a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MinutiaeTaggableObjectFieldsModel minutiaeTaggableObjectFieldsModel = (MinutiaeTaggableObjectFieldsModel) obj;
                if (minutiaeTaggableObjectFieldsModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(minutiaeTaggableObjectFieldsModel.m19498a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    minutiaeTaggableObjectFieldsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                MinutiaeTaggableObjectFieldsParser.m19539a(minutiaeTaggableObjectFieldsModel.w_(), minutiaeTaggableObjectFieldsModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(MinutiaeTaggableObjectFieldsModel.class, new Serializer());
            }
        }

        @Nullable
        public final /* synthetic */ ProfilePicture ad_() {
            return m19496n();
        }

        @Nullable
        public final /* synthetic */ OpenGraphComposerPreviewModel m19507g() {
            return m19510l();
        }

        @Nullable
        public final /* synthetic */ PageModel m19508j() {
            return m19495m();
        }

        @Nullable
        public final /* synthetic */ DefaultImageFields m19509k() {
            return m19497o();
        }

        public MinutiaeTaggableObjectFieldsModel() {
            super(9);
        }

        public MinutiaeTaggableObjectFieldsModel(MutableFlatBuffer mutableFlatBuffer) {
            super(9);
            a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
        }

        public final void m19502a(String str, ConsistencyTuple consistencyTuple) {
            consistencyTuple.a();
        }

        public final void m19503a(String str, Object obj, boolean z) {
        }

        @Nullable
        public final GraphQLObjectType m19504b() {
            if (this.b != null && this.f11446d == null) {
                this.f11446d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
            }
            return this.f11446d;
        }

        @Nullable
        public final String m19506d() {
            this.f11447e = super.a(this.f11447e, 1);
            return this.f11447e;
        }

        public final boolean m19505c() {
            a(0, 2);
            return this.f11448f;
        }

        @Nullable
        public final String C_() {
            this.f11449g = super.a(this.f11449g, 3);
            return this.f11449g;
        }

        @Nullable
        public final OpenGraphComposerPreviewModel m19510l() {
            this.f11450h = (OpenGraphComposerPreviewModel) super.a(this.f11450h, 4, OpenGraphComposerPreviewModel.class);
            return this.f11450h;
        }

        @Nullable
        private PageModel m19495m() {
            this.f11451i = (PageModel) super.a(this.f11451i, 5, PageModel.class);
            return this.f11451i;
        }

        @Nullable
        private ProfilePictureModel m19496n() {
            this.f11452j = (ProfilePictureModel) super.a(this.f11452j, 6, ProfilePictureModel.class);
            return this.f11452j;
        }

        @Nullable
        private DefaultImageFieldsModel m19497o() {
            this.f11453k = (DefaultImageFieldsModel) super.a(this.f11453k, 7, DefaultImageFieldsModel.class);
            return this.f11453k;
        }

        @Nullable
        public final String D_() {
            this.f11454l = super.a(this.f11454l, 8);
            return this.f11454l;
        }

        public static MinutiaeTaggableObjectFieldsModel m19494a(MinutiaeTaggableObjectFieldsModel minutiaeTaggableObjectFieldsModel) {
            if (minutiaeTaggableObjectFieldsModel == null) {
                return null;
            }
            if (minutiaeTaggableObjectFieldsModel instanceof MinutiaeTaggableObjectFieldsModel) {
                return minutiaeTaggableObjectFieldsModel;
            }
            Builder builder = new Builder();
            builder.f11431a = minutiaeTaggableObjectFieldsModel.m19504b();
            builder.f11432b = minutiaeTaggableObjectFieldsModel.m19506d();
            builder.f11433c = minutiaeTaggableObjectFieldsModel.m19505c();
            builder.f11434d = minutiaeTaggableObjectFieldsModel.C_();
            builder.f11435e = OpenGraphComposerPreviewModel.m19479a(minutiaeTaggableObjectFieldsModel.m19507g());
            builder.f11436f = PageModel.m19485a(minutiaeTaggableObjectFieldsModel.m19508j());
            builder.f11437g = ProfilePictureModel.a(minutiaeTaggableObjectFieldsModel.ad_());
            builder.f11438h = DefaultImageFieldsModel.a(minutiaeTaggableObjectFieldsModel.m19509k());
            builder.f11439i = minutiaeTaggableObjectFieldsModel.D_();
            return builder.m19475a();
        }

        @Nullable
        public final String m19500a() {
            return m19506d();
        }

        public final int jK_() {
            return 1355227529;
        }

        public final GraphQLVisitableModel m19499a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m19510l() != null) {
                OpenGraphComposerPreviewModel openGraphComposerPreviewModel = (OpenGraphComposerPreviewModel) graphQLModelMutatingVisitor.b(m19510l());
                if (m19510l() != openGraphComposerPreviewModel) {
                    graphQLVisitableModel = (MinutiaeTaggableObjectFieldsModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f11450h = openGraphComposerPreviewModel;
                }
            }
            if (m19495m() != null) {
                PageModel pageModel = (PageModel) graphQLModelMutatingVisitor.b(m19495m());
                if (m19495m() != pageModel) {
                    graphQLVisitableModel = (MinutiaeTaggableObjectFieldsModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f11451i = pageModel;
                }
            }
            if (m19496n() != null) {
                ProfilePictureModel profilePictureModel = (ProfilePictureModel) graphQLModelMutatingVisitor.b(m19496n());
                if (m19496n() != profilePictureModel) {
                    graphQLVisitableModel = (MinutiaeTaggableObjectFieldsModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f11452j = profilePictureModel;
                }
            }
            if (m19497o() != null) {
                DefaultImageFieldsModel defaultImageFieldsModel = (DefaultImageFieldsModel) graphQLModelMutatingVisitor.b(m19497o());
                if (m19497o() != defaultImageFieldsModel) {
                    graphQLVisitableModel = (MinutiaeTaggableObjectFieldsModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f11453k = defaultImageFieldsModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m19498a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m19504b());
            int b = flatBufferBuilder.b(m19506d());
            int b2 = flatBufferBuilder.b(C_());
            int a2 = ModelHelper.a(flatBufferBuilder, m19510l());
            int a3 = ModelHelper.a(flatBufferBuilder, m19495m());
            int a4 = ModelHelper.a(flatBufferBuilder, m19496n());
            int a5 = ModelHelper.a(flatBufferBuilder, m19497o());
            int b3 = flatBufferBuilder.b(D_());
            flatBufferBuilder.c(9);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, b);
            flatBufferBuilder.a(2, this.f11448f);
            flatBufferBuilder.b(3, b2);
            flatBufferBuilder.b(4, a2);
            flatBufferBuilder.b(5, a3);
            flatBufferBuilder.b(6, a4);
            flatBufferBuilder.b(7, a5);
            flatBufferBuilder.b(8, b3);
            i();
            return flatBufferBuilder.d();
        }

        public final void m19501a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
            super.a(mutableFlatBuffer, i, obj);
            this.f11448f = mutableFlatBuffer.a(i, 2);
        }
    }
}
