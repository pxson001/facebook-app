package com.facebook.goodwill.feed.protocol;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbSerializerProvider;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.FragmentModelWithBridge;
import com.facebook.flatbuffers.FragmentModelWithoutBridge;
import com.facebook.flatbuffers.ModelWithFlatBufferFormatHash;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.goodwill.feed.protocol.FetchThrowbackFeedGraphQLParsers.BirthdayThrowbackThemeFieldsParser;
import com.facebook.goodwill.feed.protocol.FetchThrowbackFeedGraphQLParsers.BirthdayThrowbackThemeFieldsParser.SubtitleParser;
import com.facebook.goodwill.feed.protocol.FetchThrowbackFeedGraphQLParsers.BirthdayThrowbackThemeFieldsParser.TitleParser;
import com.facebook.goodwill.feed.protocol.FetchThrowbackFeedGraphQLParsers.ThrowbackFeedFragmentParser;
import com.facebook.goodwill.feed.protocol.FetchThrowbackFeedGraphQLParsers.ThrowbackFeedFragmentParser.AccentImagesParser;
import com.facebook.goodwill.feed.protocol.FetchThrowbackFeedGraphQLParsers.ThrowbackFeedFragmentParser.AccentImagesParser.NodesParser;
import com.facebook.goodwill.feed.protocol.FetchThrowbackFeedGraphQLParsers.ThrowbackFeedFragmentParser.HeaderTextParser;
import com.facebook.goodwill.feed.protocol.FetchThrowbackFeedGraphQLParsers.ThrowbackFeedFragmentParser.ThemeParser;
import com.facebook.goodwill.feed.protocol.FetchThrowbackFeedGraphQLParsers.ThrowbackFeedFragmentParser.ThrowbackSettingsParser;
import com.facebook.goodwill.feed.protocol.FetchThrowbackFeedGraphQLParsers.ThrowbackFeedQueryParser;
import com.facebook.goodwill.feed.protocol.FetchThrowbackFeedGraphQLParsers.ThrowbackFeedUnitEdgeParser;
import com.facebook.goodwill.feed.protocol.FetchThrowbackFeedGraphQLParsers.ThrowbackFeedUnitsConnectionFragmentParser;
import com.facebook.goodwill.feed.protocol.FetchThrowbackFeedGraphQLParsers.ThrowbackMoreStoriesFragmentParser;
import com.facebook.goodwill.feed.protocol.FetchThrowbackFeedGraphQLParsers.ThrowbackMoreStoriesQueryParser;
import com.facebook.goodwill.feed.protocol.FetchThrowbackFeedGraphQLParsers.ThrowbackSectionFragmentParser;
import com.facebook.goodwill.feed.protocol.ThrowbackFeedUnitsModels.ThrowbackShareableModel;
import com.facebook.graphql.enums.GraphQLObjectType;
import com.facebook.graphql.model.GraphQLGoodwillThrowbackFeedUnit;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.querybuilder.common.CommonGraphQL2Models.DefaultPageInfoFieldsModel;
import com.facebook.graphql.querybuilder.common.CommonGraphQLModels.DefaultImageFieldsModel;
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

/* compiled from: fetchTaggedMediaSet */
public class FetchThrowbackFeedGraphQLModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 1049463252)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: fetchTaggedMediaSet */
    public final class BirthdayThrowbackThemeFieldsModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private SubtitleModel f13444d;
        @Nullable
        private TitleModel f13445e;

        /* compiled from: fetchTaggedMediaSet */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(BirthdayThrowbackThemeFieldsModel.class, new Deserializer());
            }

            public Object m15093a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = BirthdayThrowbackThemeFieldsParser.m15212a(jsonParser);
                Object birthdayThrowbackThemeFieldsModel = new BirthdayThrowbackThemeFieldsModel();
                ((BaseModel) birthdayThrowbackThemeFieldsModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (birthdayThrowbackThemeFieldsModel instanceof Postprocessable) {
                    return ((Postprocessable) birthdayThrowbackThemeFieldsModel).a();
                }
                return birthdayThrowbackThemeFieldsModel;
            }
        }

        /* compiled from: fetchTaggedMediaSet */
        public class Serializer extends JsonSerializer<BirthdayThrowbackThemeFieldsModel> {
            public final void m15094a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                BirthdayThrowbackThemeFieldsModel birthdayThrowbackThemeFieldsModel = (BirthdayThrowbackThemeFieldsModel) obj;
                if (birthdayThrowbackThemeFieldsModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(birthdayThrowbackThemeFieldsModel.m15107a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    birthdayThrowbackThemeFieldsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = birthdayThrowbackThemeFieldsModel.w_();
                int u_ = birthdayThrowbackThemeFieldsModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("subtitle");
                    SubtitleParser.m15209a(mutableFlatBuffer, g, jsonGenerator);
                }
                g = mutableFlatBuffer.g(u_, 1);
                if (g != 0) {
                    jsonGenerator.a("title");
                    TitleParser.m15211a(mutableFlatBuffer, g, jsonGenerator);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(BirthdayThrowbackThemeFieldsModel.class, new Serializer());
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1352864475)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: fetchTaggedMediaSet */
        public final class SubtitleModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private String f13442d;

            /* compiled from: fetchTaggedMediaSet */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(SubtitleModel.class, new Deserializer());
                }

                public Object m15095a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(SubtitleParser.m15208a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object subtitleModel = new SubtitleModel();
                    ((BaseModel) subtitleModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (subtitleModel instanceof Postprocessable) {
                        return ((Postprocessable) subtitleModel).a();
                    }
                    return subtitleModel;
                }
            }

            /* compiled from: fetchTaggedMediaSet */
            public class Serializer extends JsonSerializer<SubtitleModel> {
                public final void m15096a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    SubtitleModel subtitleModel = (SubtitleModel) obj;
                    if (subtitleModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(subtitleModel.m15097a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        subtitleModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    SubtitleParser.m15209a(subtitleModel.w_(), subtitleModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(SubtitleModel.class, new Serializer());
                }
            }

            public SubtitleModel() {
                super(1);
            }

            @Nullable
            public final String m15099a() {
                this.f13442d = super.a(this.f13442d, 0);
                return this.f13442d;
            }

            public final int jK_() {
                return -1919764332;
            }

            public final GraphQLVisitableModel m15098a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m15097a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m15099a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, b);
                i();
                return flatBufferBuilder.d();
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1352864475)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: fetchTaggedMediaSet */
        public final class TitleModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private String f13443d;

            /* compiled from: fetchTaggedMediaSet */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(TitleModel.class, new Deserializer());
                }

                public Object m15100a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(TitleParser.m15210a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object titleModel = new TitleModel();
                    ((BaseModel) titleModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (titleModel instanceof Postprocessable) {
                        return ((Postprocessable) titleModel).a();
                    }
                    return titleModel;
                }
            }

            /* compiled from: fetchTaggedMediaSet */
            public class Serializer extends JsonSerializer<TitleModel> {
                public final void m15101a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    TitleModel titleModel = (TitleModel) obj;
                    if (titleModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(titleModel.m15102a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        titleModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    TitleParser.m15211a(titleModel.w_(), titleModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(TitleModel.class, new Serializer());
                }
            }

            public TitleModel() {
                super(1);
            }

            @Nullable
            public final String m15104a() {
                this.f13443d = super.a(this.f13443d, 0);
                return this.f13443d;
            }

            public final int jK_() {
                return -1919764332;
            }

            public final GraphQLVisitableModel m15103a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m15102a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m15104a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, b);
                i();
                return flatBufferBuilder.d();
            }
        }

        public BirthdayThrowbackThemeFieldsModel() {
            super(2);
        }

        @Nullable
        private SubtitleModel m15105a() {
            this.f13444d = (SubtitleModel) super.a(this.f13444d, 0, SubtitleModel.class);
            return this.f13444d;
        }

        @Nullable
        private TitleModel m15106j() {
            this.f13445e = (TitleModel) super.a(this.f13445e, 1, TitleModel.class);
            return this.f13445e;
        }

        public final int jK_() {
            return 1065444639;
        }

        public final GraphQLVisitableModel m15108a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m15105a() != null) {
                SubtitleModel subtitleModel = (SubtitleModel) graphQLModelMutatingVisitor.b(m15105a());
                if (m15105a() != subtitleModel) {
                    graphQLVisitableModel = (BirthdayThrowbackThemeFieldsModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f13444d = subtitleModel;
                }
            }
            if (m15106j() != null) {
                TitleModel titleModel = (TitleModel) graphQLModelMutatingVisitor.b(m15106j());
                if (m15106j() != titleModel) {
                    graphQLVisitableModel = (BirthdayThrowbackThemeFieldsModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f13445e = titleModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m15107a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m15105a());
            int a2 = ModelHelper.a(flatBufferBuilder, m15106j());
            flatBufferBuilder.c(2);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, a2);
            i();
            return flatBufferBuilder.d();
        }
    }

    @FragmentModelWithBridge
    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -1487580433)
    @JsonSerialize(using = Serializer.class)
    /* compiled from: fetchTaggedMediaSet */
    public final class ThrowbackFeedFragmentModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private AccentImagesModel f13456d;
        @Nullable
        private DefaultImageFieldsModel f13457e;
        @Nullable
        private String f13458f;
        @Nullable
        private DefaultImageFieldsModel f13459g;
        @Nullable
        private DefaultImageFieldsModel f13460h;
        @Nullable
        private HeaderTextModel f13461i;
        @Nullable
        private DefaultImageFieldsModel f13462j;
        @Nullable
        private String f13463k;
        @Nullable
        private String f13464l;
        @Nullable
        private DefaultImageFieldsModel f13465m;
        @Nullable
        private String f13466n;
        @Nullable
        private String f13467o;
        @Nullable
        private String f13468p;
        @Nullable
        private String f13469q;
        @Nullable
        private ThemeModel f13470r;
        @Nullable
        private ThrowbackSettingsModel f13471s;
        @Nullable
        private ThrowbackFeedUnitsConnectionFragmentModel f13472t;
        private long f13473u;

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 191455936)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: fetchTaggedMediaSet */
        public final class AccentImagesModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private List<NodesModel> f13448d;

            /* compiled from: fetchTaggedMediaSet */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(AccentImagesModel.class, new Deserializer());
                }

                public Object m15109a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(AccentImagesParser.m15215a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object accentImagesModel = new AccentImagesModel();
                    ((BaseModel) accentImagesModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (accentImagesModel instanceof Postprocessable) {
                        return ((Postprocessable) accentImagesModel).a();
                    }
                    return accentImagesModel;
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = -1915099230)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: fetchTaggedMediaSet */
            public final class NodesModel extends BaseModel implements GraphQLVisitableModel {
                @Nullable
                private GraphQLObjectType f13446d;
                @Nullable
                private DefaultImageFieldsModel f13447e;

                /* compiled from: fetchTaggedMediaSet */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(NodesModel.class, new Deserializer());
                    }

                    public Object m15110a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(NodesParser.m15213b(jsonParser, flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                        Object nodesModel = new NodesModel();
                        ((BaseModel) nodesModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                        if (nodesModel instanceof Postprocessable) {
                            return ((Postprocessable) nodesModel).a();
                        }
                        return nodesModel;
                    }
                }

                /* compiled from: fetchTaggedMediaSet */
                public class Serializer extends JsonSerializer<NodesModel> {
                    public final void m15111a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        NodesModel nodesModel = (NodesModel) obj;
                        if (nodesModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(nodesModel.m15113a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            nodesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        NodesParser.m15214b(nodesModel.w_(), nodesModel.u_(), jsonGenerator, serializerProvider);
                    }

                    static {
                        FbSerializerProvider.a(NodesModel.class, new Serializer());
                    }
                }

                public NodesModel() {
                    super(2);
                }

                @Nullable
                private GraphQLObjectType m15112j() {
                    if (this.b != null && this.f13446d == null) {
                        this.f13446d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
                    }
                    return this.f13446d;
                }

                @Nullable
                public final DefaultImageFieldsModel m15114a() {
                    this.f13447e = (DefaultImageFieldsModel) super.a(this.f13447e, 1, DefaultImageFieldsModel.class);
                    return this.f13447e;
                }

                public final int jK_() {
                    return 818607219;
                }

                public final GraphQLVisitableModel m15115a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    GraphQLVisitableModel graphQLVisitableModel = null;
                    h();
                    if (m15114a() != null) {
                        DefaultImageFieldsModel defaultImageFieldsModel = (DefaultImageFieldsModel) graphQLModelMutatingVisitor.b(m15114a());
                        if (m15114a() != defaultImageFieldsModel) {
                            graphQLVisitableModel = (NodesModel) ModelHelper.a(null, this);
                            graphQLVisitableModel.f13447e = defaultImageFieldsModel;
                        }
                    }
                    i();
                    return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                }

                public final int m15113a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int a = ModelHelper.a(flatBufferBuilder, m15112j());
                    int a2 = ModelHelper.a(flatBufferBuilder, m15114a());
                    flatBufferBuilder.c(2);
                    flatBufferBuilder.b(0, a);
                    flatBufferBuilder.b(1, a2);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            /* compiled from: fetchTaggedMediaSet */
            public class Serializer extends JsonSerializer<AccentImagesModel> {
                public final void m15116a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    AccentImagesModel accentImagesModel = (AccentImagesModel) obj;
                    if (accentImagesModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(accentImagesModel.m15117a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        accentImagesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    AccentImagesParser.m15216a(accentImagesModel.w_(), accentImagesModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(AccentImagesModel.class, new Serializer());
                }
            }

            public AccentImagesModel() {
                super(1);
            }

            @Nonnull
            public final ImmutableList<NodesModel> m15119a() {
                this.f13448d = super.a(this.f13448d, 0, NodesModel.class);
                return (ImmutableList) this.f13448d;
            }

            public final int jK_() {
                return 1052015966;
            }

            public final GraphQLVisitableModel m15118a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m15119a() != null) {
                    Builder a = ModelHelper.a(m15119a(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        graphQLVisitableModel = (AccentImagesModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f13448d = a.b();
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m15117a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m15119a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, a);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: fetchTaggedMediaSet */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(ThrowbackFeedFragmentModel.class, new Deserializer());
            }

            public Object m15120a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(ThrowbackFeedFragmentParser.m15223a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object throwbackFeedFragmentModel = new ThrowbackFeedFragmentModel();
                ((BaseModel) throwbackFeedFragmentModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (throwbackFeedFragmentModel instanceof Postprocessable) {
                    return ((Postprocessable) throwbackFeedFragmentModel).a();
                }
                return throwbackFeedFragmentModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1352864475)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: fetchTaggedMediaSet */
        public final class HeaderTextModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private String f13449d;

            /* compiled from: fetchTaggedMediaSet */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(HeaderTextModel.class, new Deserializer());
                }

                public Object m15121a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(HeaderTextParser.m15217a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object headerTextModel = new HeaderTextModel();
                    ((BaseModel) headerTextModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (headerTextModel instanceof Postprocessable) {
                        return ((Postprocessable) headerTextModel).a();
                    }
                    return headerTextModel;
                }
            }

            /* compiled from: fetchTaggedMediaSet */
            public class Serializer extends JsonSerializer<HeaderTextModel> {
                public final void m15122a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    HeaderTextModel headerTextModel = (HeaderTextModel) obj;
                    if (headerTextModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(headerTextModel.m15123a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        headerTextModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    HeaderTextParser.m15218a(headerTextModel.w_(), headerTextModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(HeaderTextModel.class, new Serializer());
                }
            }

            public HeaderTextModel() {
                super(1);
            }

            @Nullable
            public final String m15125a() {
                this.f13449d = super.a(this.f13449d, 0);
                return this.f13449d;
            }

            public final int jK_() {
                return -1919764332;
            }

            public final GraphQLVisitableModel m15124a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m15123a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m15125a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, b);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: fetchTaggedMediaSet */
        public class Serializer extends JsonSerializer<ThrowbackFeedFragmentModel> {
            public final void m15126a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                ThrowbackFeedFragmentModel throwbackFeedFragmentModel = (ThrowbackFeedFragmentModel) obj;
                if (throwbackFeedFragmentModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(throwbackFeedFragmentModel.m15141a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    throwbackFeedFragmentModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                ThrowbackFeedFragmentParser.m15224a(throwbackFeedFragmentModel.w_(), throwbackFeedFragmentModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(ThrowbackFeedFragmentModel.class, new Serializer());
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 155057016)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: fetchTaggedMediaSet */
        public final class ThemeModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private GraphQLObjectType f13450d;
            @Nullable
            private String f13451e;
            @Nullable
            private String f13452f;
            @Nullable
            private SubtitleModel f13453g;
            @Nullable
            private TitleModel f13454h;

            /* compiled from: fetchTaggedMediaSet */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(ThemeModel.class, new Deserializer());
                }

                public Object m15127a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(ThemeParser.m15219a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object themeModel = new ThemeModel();
                    ((BaseModel) themeModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (themeModel instanceof Postprocessable) {
                        return ((Postprocessable) themeModel).a();
                    }
                    return themeModel;
                }
            }

            /* compiled from: fetchTaggedMediaSet */
            public class Serializer extends JsonSerializer<ThemeModel> {
                public final void m15128a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    ThemeModel themeModel = (ThemeModel) obj;
                    if (themeModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(themeModel.m15129a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        themeModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    ThemeParser.m15220a(themeModel.w_(), themeModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(ThemeModel.class, new Serializer());
                }
            }

            public ThemeModel() {
                super(5);
            }

            @Nullable
            public final GraphQLObjectType m15130a() {
                if (this.b != null && this.f13450d == null) {
                    this.f13450d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
                }
                return this.f13450d;
            }

            @Nullable
            public final String m15132j() {
                this.f13451e = super.a(this.f13451e, 1);
                return this.f13451e;
            }

            @Nullable
            public final String m15133k() {
                this.f13452f = super.a(this.f13452f, 2);
                return this.f13452f;
            }

            @Nullable
            public final SubtitleModel m15134l() {
                this.f13453g = (SubtitleModel) super.a(this.f13453g, 3, SubtitleModel.class);
                return this.f13453g;
            }

            @Nullable
            public final TitleModel m15135m() {
                this.f13454h = (TitleModel) super.a(this.f13454h, 4, TitleModel.class);
                return this.f13454h;
            }

            public final int jK_() {
                return 2094871708;
            }

            public final GraphQLVisitableModel m15131a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m15134l() != null) {
                    SubtitleModel subtitleModel = (SubtitleModel) graphQLModelMutatingVisitor.b(m15134l());
                    if (m15134l() != subtitleModel) {
                        graphQLVisitableModel = (ThemeModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f13453g = subtitleModel;
                    }
                }
                if (m15135m() != null) {
                    TitleModel titleModel = (TitleModel) graphQLModelMutatingVisitor.b(m15135m());
                    if (m15135m() != titleModel) {
                        graphQLVisitableModel = (ThemeModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f13454h = titleModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m15129a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m15130a());
                int b = flatBufferBuilder.b(m15132j());
                int b2 = flatBufferBuilder.b(m15133k());
                int a2 = ModelHelper.a(flatBufferBuilder, m15134l());
                int a3 = ModelHelper.a(flatBufferBuilder, m15135m());
                flatBufferBuilder.c(5);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.b(1, b);
                flatBufferBuilder.b(2, b2);
                flatBufferBuilder.b(3, a2);
                flatBufferBuilder.b(4, a3);
                i();
                return flatBufferBuilder.d();
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1239187262)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: fetchTaggedMediaSet */
        public final class ThrowbackSettingsModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private String f13455d;

            /* compiled from: fetchTaggedMediaSet */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(ThrowbackSettingsModel.class, new Deserializer());
                }

                public Object m15136a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(ThrowbackSettingsParser.m15221a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object throwbackSettingsModel = new ThrowbackSettingsModel();
                    ((BaseModel) throwbackSettingsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (throwbackSettingsModel instanceof Postprocessable) {
                        return ((Postprocessable) throwbackSettingsModel).a();
                    }
                    return throwbackSettingsModel;
                }
            }

            /* compiled from: fetchTaggedMediaSet */
            public class Serializer extends JsonSerializer<ThrowbackSettingsModel> {
                public final void m15137a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    ThrowbackSettingsModel throwbackSettingsModel = (ThrowbackSettingsModel) obj;
                    if (throwbackSettingsModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(throwbackSettingsModel.m15138a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        throwbackSettingsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    ThrowbackSettingsParser.m15222a(throwbackSettingsModel.w_(), throwbackSettingsModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(ThrowbackSettingsModel.class, new Serializer());
                }
            }

            public ThrowbackSettingsModel() {
                super(1);
            }

            @Nullable
            public final String m15140a() {
                this.f13455d = super.a(this.f13455d, 0);
                return this.f13455d;
            }

            public final int jK_() {
                return 1199989153;
            }

            public final GraphQLVisitableModel m15139a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m15138a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m15140a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, b);
                i();
                return flatBufferBuilder.d();
            }
        }

        public ThrowbackFeedFragmentModel() {
            super(18);
        }

        @Nullable
        public final AccentImagesModel m15142a() {
            this.f13456d = (AccentImagesModel) super.a(this.f13456d, 0, AccentImagesModel.class);
            return this.f13456d;
        }

        @Nullable
        public final DefaultImageFieldsModel m15145j() {
            this.f13457e = (DefaultImageFieldsModel) super.a(this.f13457e, 1, DefaultImageFieldsModel.class);
            return this.f13457e;
        }

        @Nullable
        public final String m15146k() {
            this.f13458f = super.a(this.f13458f, 2);
            return this.f13458f;
        }

        @Nullable
        public final DefaultImageFieldsModel m15147l() {
            this.f13459g = (DefaultImageFieldsModel) super.a(this.f13459g, 3, DefaultImageFieldsModel.class);
            return this.f13459g;
        }

        @Nullable
        public final DefaultImageFieldsModel m15148m() {
            this.f13460h = (DefaultImageFieldsModel) super.a(this.f13460h, 4, DefaultImageFieldsModel.class);
            return this.f13460h;
        }

        @Nullable
        public final HeaderTextModel m15149n() {
            this.f13461i = (HeaderTextModel) super.a(this.f13461i, 5, HeaderTextModel.class);
            return this.f13461i;
        }

        @Nullable
        public final DefaultImageFieldsModel m15150o() {
            this.f13462j = (DefaultImageFieldsModel) super.a(this.f13462j, 6, DefaultImageFieldsModel.class);
            return this.f13462j;
        }

        @Nullable
        public final String m15151p() {
            this.f13463k = super.a(this.f13463k, 7);
            return this.f13463k;
        }

        @Nullable
        public final String m15152q() {
            this.f13464l = super.a(this.f13464l, 8);
            return this.f13464l;
        }

        @Nullable
        public final DefaultImageFieldsModel m15153r() {
            this.f13465m = (DefaultImageFieldsModel) super.a(this.f13465m, 9, DefaultImageFieldsModel.class);
            return this.f13465m;
        }

        @Nullable
        public final String m15154s() {
            this.f13466n = super.a(this.f13466n, 10);
            return this.f13466n;
        }

        @Nullable
        public final String m15155t() {
            this.f13467o = super.a(this.f13467o, 11);
            return this.f13467o;
        }

        @Nullable
        public final String m15156u() {
            this.f13468p = super.a(this.f13468p, 12);
            return this.f13468p;
        }

        @Nullable
        public final String m15157v() {
            this.f13469q = super.a(this.f13469q, 13);
            return this.f13469q;
        }

        @Nullable
        public final ThemeModel m15158w() {
            this.f13470r = (ThemeModel) super.a(this.f13470r, 14, ThemeModel.class);
            return this.f13470r;
        }

        @Nullable
        public final ThrowbackSettingsModel m15159x() {
            this.f13471s = (ThrowbackSettingsModel) super.a(this.f13471s, 15, ThrowbackSettingsModel.class);
            return this.f13471s;
        }

        @Nullable
        public final ThrowbackFeedUnitsConnectionFragmentModel m15160y() {
            this.f13472t = (ThrowbackFeedUnitsConnectionFragmentModel) super.a(this.f13472t, 16, ThrowbackFeedUnitsConnectionFragmentModel.class);
            return this.f13472t;
        }

        public final long m15161z() {
            a(2, 1);
            return this.f13473u;
        }

        public final int jK_() {
            return -302803958;
        }

        public final GraphQLVisitableModel m15143a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            DefaultImageFieldsModel defaultImageFieldsModel;
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m15142a() != null) {
                AccentImagesModel accentImagesModel = (AccentImagesModel) graphQLModelMutatingVisitor.b(m15142a());
                if (m15142a() != accentImagesModel) {
                    graphQLVisitableModel = (ThrowbackFeedFragmentModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f13456d = accentImagesModel;
                }
            }
            if (m15145j() != null) {
                defaultImageFieldsModel = (DefaultImageFieldsModel) graphQLModelMutatingVisitor.b(m15145j());
                if (m15145j() != defaultImageFieldsModel) {
                    graphQLVisitableModel = (ThrowbackFeedFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f13457e = defaultImageFieldsModel;
                }
            }
            if (m15147l() != null) {
                defaultImageFieldsModel = (DefaultImageFieldsModel) graphQLModelMutatingVisitor.b(m15147l());
                if (m15147l() != defaultImageFieldsModel) {
                    graphQLVisitableModel = (ThrowbackFeedFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f13459g = defaultImageFieldsModel;
                }
            }
            if (m15148m() != null) {
                defaultImageFieldsModel = (DefaultImageFieldsModel) graphQLModelMutatingVisitor.b(m15148m());
                if (m15148m() != defaultImageFieldsModel) {
                    graphQLVisitableModel = (ThrowbackFeedFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f13460h = defaultImageFieldsModel;
                }
            }
            if (m15149n() != null) {
                HeaderTextModel headerTextModel = (HeaderTextModel) graphQLModelMutatingVisitor.b(m15149n());
                if (m15149n() != headerTextModel) {
                    graphQLVisitableModel = (ThrowbackFeedFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f13461i = headerTextModel;
                }
            }
            if (m15150o() != null) {
                defaultImageFieldsModel = (DefaultImageFieldsModel) graphQLModelMutatingVisitor.b(m15150o());
                if (m15150o() != defaultImageFieldsModel) {
                    graphQLVisitableModel = (ThrowbackFeedFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f13462j = defaultImageFieldsModel;
                }
            }
            if (m15153r() != null) {
                defaultImageFieldsModel = (DefaultImageFieldsModel) graphQLModelMutatingVisitor.b(m15153r());
                if (m15153r() != defaultImageFieldsModel) {
                    graphQLVisitableModel = (ThrowbackFeedFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f13465m = defaultImageFieldsModel;
                }
            }
            if (m15158w() != null) {
                ThemeModel themeModel = (ThemeModel) graphQLModelMutatingVisitor.b(m15158w());
                if (m15158w() != themeModel) {
                    graphQLVisitableModel = (ThrowbackFeedFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f13470r = themeModel;
                }
            }
            if (m15159x() != null) {
                ThrowbackSettingsModel throwbackSettingsModel = (ThrowbackSettingsModel) graphQLModelMutatingVisitor.b(m15159x());
                if (m15159x() != throwbackSettingsModel) {
                    graphQLVisitableModel = (ThrowbackFeedFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f13471s = throwbackSettingsModel;
                }
            }
            if (m15160y() != null) {
                ThrowbackFeedUnitsConnectionFragmentModel throwbackFeedUnitsConnectionFragmentModel = (ThrowbackFeedUnitsConnectionFragmentModel) graphQLModelMutatingVisitor.b(m15160y());
                if (m15160y() != throwbackFeedUnitsConnectionFragmentModel) {
                    graphQLVisitableModel = (ThrowbackFeedFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f13472t = throwbackFeedUnitsConnectionFragmentModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m15141a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m15142a());
            int a2 = ModelHelper.a(flatBufferBuilder, m15145j());
            int b = flatBufferBuilder.b(m15146k());
            int a3 = ModelHelper.a(flatBufferBuilder, m15147l());
            int a4 = ModelHelper.a(flatBufferBuilder, m15148m());
            int a5 = ModelHelper.a(flatBufferBuilder, m15149n());
            int a6 = ModelHelper.a(flatBufferBuilder, m15150o());
            int b2 = flatBufferBuilder.b(m15151p());
            int b3 = flatBufferBuilder.b(m15152q());
            int a7 = ModelHelper.a(flatBufferBuilder, m15153r());
            int b4 = flatBufferBuilder.b(m15154s());
            int b5 = flatBufferBuilder.b(m15155t());
            int b6 = flatBufferBuilder.b(m15156u());
            int b7 = flatBufferBuilder.b(m15157v());
            int a8 = ModelHelper.a(flatBufferBuilder, m15158w());
            int a9 = ModelHelper.a(flatBufferBuilder, m15159x());
            int a10 = ModelHelper.a(flatBufferBuilder, m15160y());
            flatBufferBuilder.c(18);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, a2);
            flatBufferBuilder.b(2, b);
            flatBufferBuilder.b(3, a3);
            flatBufferBuilder.b(4, a4);
            flatBufferBuilder.b(5, a5);
            flatBufferBuilder.b(6, a6);
            flatBufferBuilder.b(7, b2);
            flatBufferBuilder.b(8, b3);
            flatBufferBuilder.b(9, a7);
            flatBufferBuilder.b(10, b4);
            flatBufferBuilder.b(11, b5);
            flatBufferBuilder.b(12, b6);
            flatBufferBuilder.b(13, b7);
            flatBufferBuilder.b(14, a8);
            flatBufferBuilder.b(15, a9);
            flatBufferBuilder.b(16, a10);
            flatBufferBuilder.a(17, this.f13473u, 0);
            i();
            return flatBufferBuilder.d();
        }

        public final void m15144a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
            super.a(mutableFlatBuffer, i, obj);
            this.f13473u = mutableFlatBuffer.a(i, 17, 0);
        }
    }

    @FragmentModelWithBridge
    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 876201485)
    @JsonSerialize(using = Serializer.class)
    /* compiled from: fetchTaggedMediaSet */
    public final class ThrowbackFeedQueryModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private ThrowbackFeedFragmentModel f13474d;

        /* compiled from: fetchTaggedMediaSet */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(ThrowbackFeedQueryModel.class, new Deserializer());
            }

            public Object m15162a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = ThrowbackFeedQueryParser.m15225a(jsonParser);
                Object throwbackFeedQueryModel = new ThrowbackFeedQueryModel();
                ((BaseModel) throwbackFeedQueryModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (throwbackFeedQueryModel instanceof Postprocessable) {
                    return ((Postprocessable) throwbackFeedQueryModel).a();
                }
                return throwbackFeedQueryModel;
            }
        }

        /* compiled from: fetchTaggedMediaSet */
        public class Serializer extends JsonSerializer<ThrowbackFeedQueryModel> {
            public final void m15163a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                ThrowbackFeedQueryModel throwbackFeedQueryModel = (ThrowbackFeedQueryModel) obj;
                if (throwbackFeedQueryModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(throwbackFeedQueryModel.m15164a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    throwbackFeedQueryModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = throwbackFeedQueryModel.w_();
                int u_ = throwbackFeedQueryModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("throwback");
                    ThrowbackFeedFragmentParser.m15224a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(ThrowbackFeedQueryModel.class, new Serializer());
            }
        }

        public ThrowbackFeedQueryModel() {
            super(1);
        }

        @Nullable
        public final ThrowbackFeedFragmentModel m15165a() {
            this.f13474d = (ThrowbackFeedFragmentModel) super.a(this.f13474d, 0, ThrowbackFeedFragmentModel.class);
            return this.f13474d;
        }

        public final int jK_() {
            return -1732764110;
        }

        public final GraphQLVisitableModel m15166a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m15165a() != null) {
                ThrowbackFeedFragmentModel throwbackFeedFragmentModel = (ThrowbackFeedFragmentModel) graphQLModelMutatingVisitor.b(m15165a());
                if (m15165a() != throwbackFeedFragmentModel) {
                    graphQLVisitableModel = (ThrowbackFeedQueryModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f13474d = throwbackFeedFragmentModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m15164a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m15165a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }

    @FragmentModelWithBridge
    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 1622453724)
    @JsonSerialize(using = Serializer.class)
    /* compiled from: fetchTaggedMediaSet */
    public final class ThrowbackFeedUnitEdgeModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private GraphQLGoodwillThrowbackFeedUnit f13475d;
        @Nullable
        private String f13476e;
        @Nullable
        private ThrowbackShareableModel f13477f;

        /* compiled from: fetchTaggedMediaSet */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(ThrowbackFeedUnitEdgeModel.class, new Deserializer());
            }

            public Object m15167a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(ThrowbackFeedUnitEdgeParser.m15226b(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object throwbackFeedUnitEdgeModel = new ThrowbackFeedUnitEdgeModel();
                ((BaseModel) throwbackFeedUnitEdgeModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (throwbackFeedUnitEdgeModel instanceof Postprocessable) {
                    return ((Postprocessable) throwbackFeedUnitEdgeModel).a();
                }
                return throwbackFeedUnitEdgeModel;
            }
        }

        /* compiled from: fetchTaggedMediaSet */
        public class Serializer extends JsonSerializer<ThrowbackFeedUnitEdgeModel> {
            public final void m15168a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                ThrowbackFeedUnitEdgeModel throwbackFeedUnitEdgeModel = (ThrowbackFeedUnitEdgeModel) obj;
                if (throwbackFeedUnitEdgeModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(throwbackFeedUnitEdgeModel.m15169a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    throwbackFeedUnitEdgeModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                ThrowbackFeedUnitEdgeParser.m15227b(throwbackFeedUnitEdgeModel.w_(), throwbackFeedUnitEdgeModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(ThrowbackFeedUnitEdgeModel.class, new Serializer());
            }
        }

        public ThrowbackFeedUnitEdgeModel() {
            super(3);
        }

        @Nullable
        public final GraphQLGoodwillThrowbackFeedUnit m15170a() {
            this.f13475d = (GraphQLGoodwillThrowbackFeedUnit) super.a(this.f13475d, 0, GraphQLGoodwillThrowbackFeedUnit.class);
            return this.f13475d;
        }

        @Nullable
        public final String m15172j() {
            this.f13476e = super.a(this.f13476e, 1);
            return this.f13476e;
        }

        @Nullable
        public final ThrowbackShareableModel m15173k() {
            this.f13477f = (ThrowbackShareableModel) super.a(this.f13477f, 2, ThrowbackShareableModel.class);
            return this.f13477f;
        }

        public final int jK_() {
            return -687624432;
        }

        public final GraphQLVisitableModel m15171a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m15170a() != null) {
                GraphQLGoodwillThrowbackFeedUnit graphQLGoodwillThrowbackFeedUnit = (GraphQLGoodwillThrowbackFeedUnit) graphQLModelMutatingVisitor.b(m15170a());
                if (m15170a() != graphQLGoodwillThrowbackFeedUnit) {
                    graphQLVisitableModel = (ThrowbackFeedUnitEdgeModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f13475d = graphQLGoodwillThrowbackFeedUnit;
                }
            }
            if (m15173k() != null) {
                ThrowbackShareableModel throwbackShareableModel = (ThrowbackShareableModel) graphQLModelMutatingVisitor.b(m15173k());
                if (m15173k() != throwbackShareableModel) {
                    graphQLVisitableModel = (ThrowbackFeedUnitEdgeModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f13477f = throwbackShareableModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m15169a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m15170a());
            int b = flatBufferBuilder.b(m15172j());
            int a2 = ModelHelper.a(flatBufferBuilder, m15173k());
            flatBufferBuilder.c(3);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, b);
            flatBufferBuilder.b(2, a2);
            i();
            return flatBufferBuilder.d();
        }
    }

    @FragmentModelWithBridge
    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 926540763)
    @JsonSerialize(using = Serializer.class)
    /* compiled from: fetchTaggedMediaSet */
    public final class ThrowbackFeedUnitsConnectionFragmentModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private List<ThrowbackFeedUnitEdgeModel> f13478d;
        @Nullable
        private DefaultPageInfoFieldsModel f13479e;
        @Nullable
        private List<ThrowbackSectionFragmentModel> f13480f;

        /* compiled from: fetchTaggedMediaSet */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(ThrowbackFeedUnitsConnectionFragmentModel.class, new Deserializer());
            }

            public Object m15174a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(ThrowbackFeedUnitsConnectionFragmentParser.m15228a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object throwbackFeedUnitsConnectionFragmentModel = new ThrowbackFeedUnitsConnectionFragmentModel();
                ((BaseModel) throwbackFeedUnitsConnectionFragmentModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (throwbackFeedUnitsConnectionFragmentModel instanceof Postprocessable) {
                    return ((Postprocessable) throwbackFeedUnitsConnectionFragmentModel).a();
                }
                return throwbackFeedUnitsConnectionFragmentModel;
            }
        }

        /* compiled from: fetchTaggedMediaSet */
        public class Serializer extends JsonSerializer<ThrowbackFeedUnitsConnectionFragmentModel> {
            public final void m15175a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                ThrowbackFeedUnitsConnectionFragmentModel throwbackFeedUnitsConnectionFragmentModel = (ThrowbackFeedUnitsConnectionFragmentModel) obj;
                if (throwbackFeedUnitsConnectionFragmentModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(throwbackFeedUnitsConnectionFragmentModel.m15176a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    throwbackFeedUnitsConnectionFragmentModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                ThrowbackFeedUnitsConnectionFragmentParser.m15229a(throwbackFeedUnitsConnectionFragmentModel.w_(), throwbackFeedUnitsConnectionFragmentModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(ThrowbackFeedUnitsConnectionFragmentModel.class, new Serializer());
            }
        }

        public ThrowbackFeedUnitsConnectionFragmentModel() {
            super(3);
        }

        @Nonnull
        public final ImmutableList<ThrowbackFeedUnitEdgeModel> m15178a() {
            this.f13478d = super.a(this.f13478d, 0, ThrowbackFeedUnitEdgeModel.class);
            return (ImmutableList) this.f13478d;
        }

        @Nullable
        public final DefaultPageInfoFieldsModel m15179j() {
            this.f13479e = (DefaultPageInfoFieldsModel) super.a(this.f13479e, 1, DefaultPageInfoFieldsModel.class);
            return this.f13479e;
        }

        @Nonnull
        public final ImmutableList<ThrowbackSectionFragmentModel> m15180k() {
            this.f13480f = super.a(this.f13480f, 2, ThrowbackSectionFragmentModel.class);
            return (ImmutableList) this.f13480f;
        }

        public final int jK_() {
            return -716622351;
        }

        public final GraphQLVisitableModel m15177a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            ThrowbackFeedUnitsConnectionFragmentModel throwbackFeedUnitsConnectionFragmentModel;
            GraphQLVisitableModel graphQLVisitableModel;
            DefaultPageInfoFieldsModel defaultPageInfoFieldsModel;
            Builder a;
            h();
            if (m15178a() != null) {
                Builder a2 = ModelHelper.a(m15178a(), graphQLModelMutatingVisitor);
                if (a2 != null) {
                    throwbackFeedUnitsConnectionFragmentModel = (ThrowbackFeedUnitsConnectionFragmentModel) ModelHelper.a(null, this);
                    throwbackFeedUnitsConnectionFragmentModel.f13478d = a2.b();
                    graphQLVisitableModel = throwbackFeedUnitsConnectionFragmentModel;
                    if (m15179j() != null) {
                        defaultPageInfoFieldsModel = (DefaultPageInfoFieldsModel) graphQLModelMutatingVisitor.b(m15179j());
                        if (m15179j() != defaultPageInfoFieldsModel) {
                            graphQLVisitableModel = (ThrowbackFeedUnitsConnectionFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                            graphQLVisitableModel.f13479e = defaultPageInfoFieldsModel;
                        }
                    }
                    if (m15180k() != null) {
                        a = ModelHelper.a(m15180k(), graphQLModelMutatingVisitor);
                        if (a != null) {
                            throwbackFeedUnitsConnectionFragmentModel = (ThrowbackFeedUnitsConnectionFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                            throwbackFeedUnitsConnectionFragmentModel.f13480f = a.b();
                            graphQLVisitableModel = throwbackFeedUnitsConnectionFragmentModel;
                        }
                    }
                    i();
                    return graphQLVisitableModel != null ? this : graphQLVisitableModel;
                }
            }
            graphQLVisitableModel = null;
            if (m15179j() != null) {
                defaultPageInfoFieldsModel = (DefaultPageInfoFieldsModel) graphQLModelMutatingVisitor.b(m15179j());
                if (m15179j() != defaultPageInfoFieldsModel) {
                    graphQLVisitableModel = (ThrowbackFeedUnitsConnectionFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f13479e = defaultPageInfoFieldsModel;
                }
            }
            if (m15180k() != null) {
                a = ModelHelper.a(m15180k(), graphQLModelMutatingVisitor);
                if (a != null) {
                    throwbackFeedUnitsConnectionFragmentModel = (ThrowbackFeedUnitsConnectionFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    throwbackFeedUnitsConnectionFragmentModel.f13480f = a.b();
                    graphQLVisitableModel = throwbackFeedUnitsConnectionFragmentModel;
                }
            }
            i();
            if (graphQLVisitableModel != null) {
            }
        }

        public final int m15176a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m15178a());
            int a2 = ModelHelper.a(flatBufferBuilder, m15179j());
            int a3 = ModelHelper.a(flatBufferBuilder, m15180k());
            flatBufferBuilder.c(3);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, a2);
            flatBufferBuilder.b(2, a3);
            i();
            return flatBufferBuilder.d();
        }
    }

    @FragmentModelWithBridge
    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -868874250)
    @JsonSerialize(using = Serializer.class)
    /* compiled from: fetchTaggedMediaSet */
    public final class ThrowbackMoreStoriesFragmentModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private ThrowbackFeedUnitsConnectionFragmentModel f13481d;

        /* compiled from: fetchTaggedMediaSet */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(ThrowbackMoreStoriesFragmentModel.class, new Deserializer());
            }

            public Object m15181a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(ThrowbackMoreStoriesFragmentParser.m15230a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object throwbackMoreStoriesFragmentModel = new ThrowbackMoreStoriesFragmentModel();
                ((BaseModel) throwbackMoreStoriesFragmentModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (throwbackMoreStoriesFragmentModel instanceof Postprocessable) {
                    return ((Postprocessable) throwbackMoreStoriesFragmentModel).a();
                }
                return throwbackMoreStoriesFragmentModel;
            }
        }

        /* compiled from: fetchTaggedMediaSet */
        public class Serializer extends JsonSerializer<ThrowbackMoreStoriesFragmentModel> {
            public final void m15182a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                ThrowbackMoreStoriesFragmentModel throwbackMoreStoriesFragmentModel = (ThrowbackMoreStoriesFragmentModel) obj;
                if (throwbackMoreStoriesFragmentModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(throwbackMoreStoriesFragmentModel.m15183a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    throwbackMoreStoriesFragmentModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                ThrowbackMoreStoriesFragmentParser.m15231a(throwbackMoreStoriesFragmentModel.w_(), throwbackMoreStoriesFragmentModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(ThrowbackMoreStoriesFragmentModel.class, new Serializer());
            }
        }

        public ThrowbackMoreStoriesFragmentModel() {
            super(1);
        }

        @Nullable
        public final ThrowbackFeedUnitsConnectionFragmentModel m15184a() {
            this.f13481d = (ThrowbackFeedUnitsConnectionFragmentModel) super.a(this.f13481d, 0, ThrowbackFeedUnitsConnectionFragmentModel.class);
            return this.f13481d;
        }

        public final int jK_() {
            return -302803958;
        }

        public final GraphQLVisitableModel m15185a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m15184a() != null) {
                ThrowbackFeedUnitsConnectionFragmentModel throwbackFeedUnitsConnectionFragmentModel = (ThrowbackFeedUnitsConnectionFragmentModel) graphQLModelMutatingVisitor.b(m15184a());
                if (m15184a() != throwbackFeedUnitsConnectionFragmentModel) {
                    graphQLVisitableModel = (ThrowbackMoreStoriesFragmentModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f13481d = throwbackFeedUnitsConnectionFragmentModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m15183a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m15184a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }

    @FragmentModelWithBridge
    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -1652817266)
    @JsonSerialize(using = Serializer.class)
    /* compiled from: fetchTaggedMediaSet */
    public final class ThrowbackMoreStoriesQueryModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private ThrowbackMoreStoriesFragmentModel f13482d;

        /* compiled from: fetchTaggedMediaSet */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(ThrowbackMoreStoriesQueryModel.class, new Deserializer());
            }

            public Object m15186a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = ThrowbackMoreStoriesQueryParser.m15232a(jsonParser);
                Object throwbackMoreStoriesQueryModel = new ThrowbackMoreStoriesQueryModel();
                ((BaseModel) throwbackMoreStoriesQueryModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (throwbackMoreStoriesQueryModel instanceof Postprocessable) {
                    return ((Postprocessable) throwbackMoreStoriesQueryModel).a();
                }
                return throwbackMoreStoriesQueryModel;
            }
        }

        /* compiled from: fetchTaggedMediaSet */
        public class Serializer extends JsonSerializer<ThrowbackMoreStoriesQueryModel> {
            public final void m15187a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                ThrowbackMoreStoriesQueryModel throwbackMoreStoriesQueryModel = (ThrowbackMoreStoriesQueryModel) obj;
                if (throwbackMoreStoriesQueryModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(throwbackMoreStoriesQueryModel.m15188a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    throwbackMoreStoriesQueryModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = throwbackMoreStoriesQueryModel.w_();
                int u_ = throwbackMoreStoriesQueryModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("throwback");
                    ThrowbackMoreStoriesFragmentParser.m15231a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(ThrowbackMoreStoriesQueryModel.class, new Serializer());
            }
        }

        public ThrowbackMoreStoriesQueryModel() {
            super(1);
        }

        @Nullable
        public final ThrowbackMoreStoriesFragmentModel m15189a() {
            this.f13482d = (ThrowbackMoreStoriesFragmentModel) super.a(this.f13482d, 0, ThrowbackMoreStoriesFragmentModel.class);
            return this.f13482d;
        }

        public final int jK_() {
            return -1732764110;
        }

        public final GraphQLVisitableModel m15190a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m15189a() != null) {
                ThrowbackMoreStoriesFragmentModel throwbackMoreStoriesFragmentModel = (ThrowbackMoreStoriesFragmentModel) graphQLModelMutatingVisitor.b(m15189a());
                if (m15189a() != throwbackMoreStoriesFragmentModel) {
                    graphQLVisitableModel = (ThrowbackMoreStoriesQueryModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f13482d = throwbackMoreStoriesFragmentModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m15188a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m15189a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 13944523)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: fetchTaggedMediaSet */
    public final class ThrowbackSectionFragmentModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private String f13485d;
        @Nullable
        private SubtitleModel f13486e;
        @Nullable
        private TitleModel f13487f;

        /* compiled from: fetchTaggedMediaSet */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(ThrowbackSectionFragmentModel.class, new Deserializer());
            }

            public Object m15191a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(ThrowbackSectionFragmentParser.m15238b(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object throwbackSectionFragmentModel = new ThrowbackSectionFragmentModel();
                ((BaseModel) throwbackSectionFragmentModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (throwbackSectionFragmentModel instanceof Postprocessable) {
                    return ((Postprocessable) throwbackSectionFragmentModel).a();
                }
                return throwbackSectionFragmentModel;
            }
        }

        /* compiled from: fetchTaggedMediaSet */
        public class Serializer extends JsonSerializer<ThrowbackSectionFragmentModel> {
            public final void m15192a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                ThrowbackSectionFragmentModel throwbackSectionFragmentModel = (ThrowbackSectionFragmentModel) obj;
                if (throwbackSectionFragmentModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(throwbackSectionFragmentModel.m15203a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    throwbackSectionFragmentModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                ThrowbackSectionFragmentParser.m15239b(throwbackSectionFragmentModel.w_(), throwbackSectionFragmentModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(ThrowbackSectionFragmentModel.class, new Serializer());
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1352864475)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: fetchTaggedMediaSet */
        public final class SubtitleModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private String f13483d;

            /* compiled from: fetchTaggedMediaSet */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(SubtitleModel.class, new Deserializer());
                }

                public Object m15193a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(ThrowbackSectionFragmentParser.SubtitleParser.m15233a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object subtitleModel = new SubtitleModel();
                    ((BaseModel) subtitleModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (subtitleModel instanceof Postprocessable) {
                        return ((Postprocessable) subtitleModel).a();
                    }
                    return subtitleModel;
                }
            }

            /* compiled from: fetchTaggedMediaSet */
            public class Serializer extends JsonSerializer<SubtitleModel> {
                public final void m15194a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    SubtitleModel subtitleModel = (SubtitleModel) obj;
                    if (subtitleModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(subtitleModel.m15195a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        subtitleModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    ThrowbackSectionFragmentParser.SubtitleParser.m15234a(subtitleModel.w_(), subtitleModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(SubtitleModel.class, new Serializer());
                }
            }

            public SubtitleModel() {
                super(1);
            }

            @Nullable
            public final String m15197a() {
                this.f13483d = super.a(this.f13483d, 0);
                return this.f13483d;
            }

            public final int jK_() {
                return -1919764332;
            }

            public final GraphQLVisitableModel m15196a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m15195a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m15197a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, b);
                i();
                return flatBufferBuilder.d();
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1352864475)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: fetchTaggedMediaSet */
        public final class TitleModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private String f13484d;

            /* compiled from: fetchTaggedMediaSet */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(TitleModel.class, new Deserializer());
                }

                public Object m15198a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(ThrowbackSectionFragmentParser.TitleParser.m15235a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object titleModel = new TitleModel();
                    ((BaseModel) titleModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (titleModel instanceof Postprocessable) {
                        return ((Postprocessable) titleModel).a();
                    }
                    return titleModel;
                }
            }

            /* compiled from: fetchTaggedMediaSet */
            public class Serializer extends JsonSerializer<TitleModel> {
                public final void m15199a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    TitleModel titleModel = (TitleModel) obj;
                    if (titleModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(titleModel.m15200a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        titleModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    ThrowbackSectionFragmentParser.TitleParser.m15236a(titleModel.w_(), titleModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(TitleModel.class, new Serializer());
                }
            }

            public TitleModel() {
                super(1);
            }

            @Nullable
            public final String m15202a() {
                this.f13484d = super.a(this.f13484d, 0);
                return this.f13484d;
            }

            public final int jK_() {
                return -1919764332;
            }

            public final GraphQLVisitableModel m15201a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m15200a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m15202a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, b);
                i();
                return flatBufferBuilder.d();
            }
        }

        public ThrowbackSectionFragmentModel() {
            super(3);
        }

        @Nullable
        public final String m15205a() {
            this.f13485d = super.a(this.f13485d, 0);
            return this.f13485d;
        }

        @Nullable
        public final SubtitleModel m15206j() {
            this.f13486e = (SubtitleModel) super.a(this.f13486e, 1, SubtitleModel.class);
            return this.f13486e;
        }

        @Nullable
        public final TitleModel m15207k() {
            this.f13487f = (TitleModel) super.a(this.f13487f, 2, TitleModel.class);
            return this.f13487f;
        }

        public final int jK_() {
            return -1916653145;
        }

        public final GraphQLVisitableModel m15204a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m15206j() != null) {
                SubtitleModel subtitleModel = (SubtitleModel) graphQLModelMutatingVisitor.b(m15206j());
                if (m15206j() != subtitleModel) {
                    graphQLVisitableModel = (ThrowbackSectionFragmentModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f13486e = subtitleModel;
                }
            }
            if (m15207k() != null) {
                TitleModel titleModel = (TitleModel) graphQLModelMutatingVisitor.b(m15207k());
                if (m15207k() != titleModel) {
                    graphQLVisitableModel = (ThrowbackSectionFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f13487f = titleModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m15203a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(m15205a());
            int a = ModelHelper.a(flatBufferBuilder, m15206j());
            int a2 = ModelHelper.a(flatBufferBuilder, m15207k());
            flatBufferBuilder.c(3);
            flatBufferBuilder.b(0, b);
            flatBufferBuilder.b(1, a);
            flatBufferBuilder.b(2, a2);
            i();
            return flatBufferBuilder.d();
        }
    }
}
