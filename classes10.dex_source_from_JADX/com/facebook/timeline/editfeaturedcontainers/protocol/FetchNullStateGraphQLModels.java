package com.facebook.timeline.editfeaturedcontainers.protocol;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbSerializerProvider;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.FragmentModelWithoutBridge;
import com.facebook.flatbuffers.ModelWithFlatBufferFormatHash;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.enums.GraphQLIntroFeaturedPageSuggestionsSectionType;
import com.facebook.graphql.enums.GraphQLObjectType;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.modelutil.SerializerHelpers;
import com.facebook.graphql.querybuilder.common.CommonGraphQLModels.DefaultImageFieldsModel;
import com.facebook.graphql.visitor.ConsistencyTuple;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLPersistableNode;
import com.facebook.graphql.visitor.GraphQLVisitableConsistentModel;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.facebook.timeline.editfeaturedcontainers.protocol.FetchNullStateGraphQLParsers.FeaturedPageSectionParser;
import com.facebook.timeline.editfeaturedcontainers.protocol.FetchNullStateGraphQLParsers.FeaturedPageSectionParser.TitleParser;
import com.facebook.timeline.editfeaturedcontainers.protocol.FetchNullStateGraphQLParsers.FeaturedPageSectionsParser;
import com.facebook.timeline.editfeaturedcontainers.protocol.FetchNullStateGraphQLParsers.FeaturedPageSectionsParser.FeaturedPagesSuggestionsParser;
import com.facebook.timeline.editfeaturedcontainers.protocol.FetchNullStateGraphQLParsers.FeaturedPageSuggestionParser;
import com.facebook.timeline.editfeaturedcontainers.protocol.FetchNullStateGraphQLParsers.FeaturedPageSuggestionParser.PageParser;
import com.facebook.timeline.editfeaturedcontainers.protocol.FetchNullStateGraphQLParsers.FeaturedPageSuggestionParser.SubtitleParser;
import com.facebook.timeline.editfeaturedcontainers.protocol.FetchNullStateGraphQLParsers.FeaturedPhotoSuggestionParser;
import com.facebook.timeline.editfeaturedcontainers.protocol.FetchNullStateGraphQLParsers.IntroCardParser;
import com.facebook.timeline.editfeaturedcontainers.protocol.FetchNullStateGraphQLParsers.IntroCardParser.FeaturedPhotosSuggestionsParser;
import com.facebook.timeline.editfeaturedcontainers.protocol.FetchNullStateGraphQLParsers.NullStateMorePageSuggestionsQueryParser;
import com.facebook.timeline.editfeaturedcontainers.protocol.FetchNullStateGraphQLParsers.PhotoParser;
import com.facebook.timeline.editfeaturedcontainers.protocol.FetchNullStateGraphQLParsers.UserParser;
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

/* compiled from: get_notified */
public class FetchNullStateGraphQLModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 1825923169)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: get_notified */
    public final class FeaturedPageSectionModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private List<FeaturedPageSuggestionModel> f10775d;
        @Nullable
        private GraphQLIntroFeaturedPageSuggestionsSectionType f10776e;
        @Nullable
        private TitleModel f10777f;

        /* compiled from: get_notified */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(FeaturedPageSectionModel.class, new Deserializer());
            }

            public Object m10810a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(FeaturedPageSectionParser.m10905b(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object featuredPageSectionModel = new FeaturedPageSectionModel();
                ((BaseModel) featuredPageSectionModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (featuredPageSectionModel instanceof Postprocessable) {
                    return ((Postprocessable) featuredPageSectionModel).a();
                }
                return featuredPageSectionModel;
            }
        }

        /* compiled from: get_notified */
        public class Serializer extends JsonSerializer<FeaturedPageSectionModel> {
            public final void m10811a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                FeaturedPageSectionModel featuredPageSectionModel = (FeaturedPageSectionModel) obj;
                if (featuredPageSectionModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(featuredPageSectionModel.m10817a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    featuredPageSectionModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                FeaturedPageSectionParser.m10906b(featuredPageSectionModel.w_(), featuredPageSectionModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(FeaturedPageSectionModel.class, new Serializer());
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1352864475)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: get_notified */
        public final class TitleModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private String f10774d;

            /* compiled from: get_notified */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(TitleModel.class, new Deserializer());
                }

                public Object m10812a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(TitleParser.m10901a(jsonParser, flatBufferBuilder));
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

            /* compiled from: get_notified */
            public class Serializer extends JsonSerializer<TitleModel> {
                public final void m10813a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    TitleModel titleModel = (TitleModel) obj;
                    if (titleModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(titleModel.m10814a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        titleModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    TitleParser.m10902a(titleModel.w_(), titleModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(TitleModel.class, new Serializer());
                }
            }

            public TitleModel() {
                super(1);
            }

            @Nullable
            public final String m10816a() {
                this.f10774d = super.a(this.f10774d, 0);
                return this.f10774d;
            }

            public final int jK_() {
                return -1919764332;
            }

            public final GraphQLVisitableModel m10815a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m10814a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m10816a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, b);
                i();
                return flatBufferBuilder.d();
            }
        }

        public FeaturedPageSectionModel() {
            super(3);
        }

        @Nonnull
        public final ImmutableList<FeaturedPageSuggestionModel> m10819a() {
            this.f10775d = super.a(this.f10775d, 0, FeaturedPageSuggestionModel.class);
            return (ImmutableList) this.f10775d;
        }

        @Nullable
        public final GraphQLIntroFeaturedPageSuggestionsSectionType m10820j() {
            this.f10776e = (GraphQLIntroFeaturedPageSuggestionsSectionType) super.b(this.f10776e, 1, GraphQLIntroFeaturedPageSuggestionsSectionType.class, GraphQLIntroFeaturedPageSuggestionsSectionType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
            return this.f10776e;
        }

        @Nullable
        public final TitleModel m10821k() {
            this.f10777f = (TitleModel) super.a(this.f10777f, 2, TitleModel.class);
            return this.f10777f;
        }

        public final int jK_() {
            return -1059910369;
        }

        public final GraphQLVisitableModel m10818a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel;
            TitleModel titleModel;
            h();
            if (m10819a() != null) {
                Builder a = ModelHelper.a(m10819a(), graphQLModelMutatingVisitor);
                if (a != null) {
                    FeaturedPageSectionModel featuredPageSectionModel = (FeaturedPageSectionModel) ModelHelper.a(null, this);
                    featuredPageSectionModel.f10775d = a.b();
                    graphQLVisitableModel = featuredPageSectionModel;
                    if (m10821k() != null) {
                        titleModel = (TitleModel) graphQLModelMutatingVisitor.b(m10821k());
                        if (m10821k() != titleModel) {
                            graphQLVisitableModel = (FeaturedPageSectionModel) ModelHelper.a(graphQLVisitableModel, this);
                            graphQLVisitableModel.f10777f = titleModel;
                        }
                    }
                    i();
                    return graphQLVisitableModel != null ? this : graphQLVisitableModel;
                }
            }
            graphQLVisitableModel = null;
            if (m10821k() != null) {
                titleModel = (TitleModel) graphQLModelMutatingVisitor.b(m10821k());
                if (m10821k() != titleModel) {
                    graphQLVisitableModel = (FeaturedPageSectionModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f10777f = titleModel;
                }
            }
            i();
            if (graphQLVisitableModel != null) {
            }
        }

        public final int m10817a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m10819a());
            int a2 = flatBufferBuilder.a(m10820j());
            int a3 = ModelHelper.a(flatBufferBuilder, m10821k());
            flatBufferBuilder.c(3);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, a2);
            flatBufferBuilder.b(2, a3);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -521673252)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: get_notified */
    public final class FeaturedPageSectionsModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private FeaturedPagesSuggestionsModel f10779d;

        /* compiled from: get_notified */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(FeaturedPageSectionsModel.class, new Deserializer());
            }

            public Object m10822a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(FeaturedPageSectionsParser.m10909a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object featuredPageSectionsModel = new FeaturedPageSectionsModel();
                ((BaseModel) featuredPageSectionsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (featuredPageSectionsModel instanceof Postprocessable) {
                    return ((Postprocessable) featuredPageSectionsModel).a();
                }
                return featuredPageSectionsModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 198858519)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: get_notified */
        public final class FeaturedPagesSuggestionsModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private List<FeaturedPageSectionModel> f10778d;

            /* compiled from: get_notified */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(FeaturedPagesSuggestionsModel.class, new Deserializer());
                }

                public Object m10823a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(FeaturedPagesSuggestionsParser.m10907a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object featuredPagesSuggestionsModel = new FeaturedPagesSuggestionsModel();
                    ((BaseModel) featuredPagesSuggestionsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (featuredPagesSuggestionsModel instanceof Postprocessable) {
                        return ((Postprocessable) featuredPagesSuggestionsModel).a();
                    }
                    return featuredPagesSuggestionsModel;
                }
            }

            /* compiled from: get_notified */
            public class Serializer extends JsonSerializer<FeaturedPagesSuggestionsModel> {
                public final void m10824a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    FeaturedPagesSuggestionsModel featuredPagesSuggestionsModel = (FeaturedPagesSuggestionsModel) obj;
                    if (featuredPagesSuggestionsModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(featuredPagesSuggestionsModel.m10825a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        featuredPagesSuggestionsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    FeaturedPagesSuggestionsParser.m10908a(featuredPagesSuggestionsModel.w_(), featuredPagesSuggestionsModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(FeaturedPagesSuggestionsModel.class, new Serializer());
                }
            }

            public FeaturedPagesSuggestionsModel() {
                super(1);
            }

            @Nonnull
            public final ImmutableList<FeaturedPageSectionModel> m10827a() {
                this.f10778d = super.a(this.f10778d, 0, FeaturedPageSectionModel.class);
                return (ImmutableList) this.f10778d;
            }

            public final int jK_() {
                return -1400340174;
            }

            public final GraphQLVisitableModel m10826a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m10827a() != null) {
                    Builder a = ModelHelper.a(m10827a(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        graphQLVisitableModel = (FeaturedPagesSuggestionsModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f10778d = a.b();
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m10825a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m10827a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, a);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: get_notified */
        public class Serializer extends JsonSerializer<FeaturedPageSectionsModel> {
            public final void m10828a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                FeaturedPageSectionsModel featuredPageSectionsModel = (FeaturedPageSectionsModel) obj;
                if (featuredPageSectionsModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(featuredPageSectionsModel.m10829a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    featuredPageSectionsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                FeaturedPageSectionsParser.m10910a(featuredPageSectionsModel.w_(), featuredPageSectionsModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(FeaturedPageSectionsModel.class, new Serializer());
            }
        }

        public FeaturedPageSectionsModel() {
            super(1);
        }

        @Nullable
        public final FeaturedPagesSuggestionsModel m10831a() {
            this.f10779d = (FeaturedPagesSuggestionsModel) super.a(this.f10779d, 0, FeaturedPagesSuggestionsModel.class);
            return this.f10779d;
        }

        public final int jK_() {
            return 2102913043;
        }

        public final GraphQLVisitableModel m10830a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m10831a() != null) {
                FeaturedPagesSuggestionsModel featuredPagesSuggestionsModel = (FeaturedPagesSuggestionsModel) graphQLModelMutatingVisitor.b(m10831a());
                if (m10831a() != featuredPagesSuggestionsModel) {
                    graphQLVisitableModel = (FeaturedPageSectionsModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f10779d = featuredPagesSuggestionsModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m10829a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m10831a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 948403526)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: get_notified */
    public final class FeaturedPageSuggestionModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private PageModel f10784d;
        @Nullable
        private SubtitleModel f10785e;
        @Nullable
        private TitleModel f10786f;

        /* compiled from: get_notified */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(FeaturedPageSuggestionModel.class, new Deserializer());
            }

            public Object m10832a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(FeaturedPageSuggestionParser.m10917b(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object featuredPageSuggestionModel = new FeaturedPageSuggestionModel();
                ((BaseModel) featuredPageSuggestionModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (featuredPageSuggestionModel instanceof Postprocessable) {
                    return ((Postprocessable) featuredPageSuggestionModel).a();
                }
                return featuredPageSuggestionModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1541238774)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: get_notified */
        public final class PageModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
            @Nullable
            private String f10780d;
            @Nullable
            private DefaultImageFieldsModel f10781e;

            /* compiled from: get_notified */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(PageModel.class, new Deserializer());
                }

                public Object m10833a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(PageParser.m10911a(jsonParser, flatBufferBuilder));
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

            /* compiled from: get_notified */
            public class Serializer extends JsonSerializer<PageModel> {
                public final void m10834a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    PageModel pageModel = (PageModel) obj;
                    if (pageModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(pageModel.m10836a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        pageModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    PageParser.m10912a(pageModel.w_(), pageModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(PageModel.class, new Serializer());
                }
            }

            public PageModel() {
                super(2);
            }

            public final void m10839a(String str, ConsistencyTuple consistencyTuple) {
                consistencyTuple.a();
            }

            public final void m10840a(String str, Object obj, boolean z) {
            }

            @Nullable
            private String m10835k() {
                this.f10780d = super.a(this.f10780d, 0);
                return this.f10780d;
            }

            @Nullable
            public final DefaultImageFieldsModel m10841j() {
                this.f10781e = (DefaultImageFieldsModel) super.a(this.f10781e, 1, DefaultImageFieldsModel.class);
                return this.f10781e;
            }

            @Nullable
            public final String m10838a() {
                return m10835k();
            }

            public final int jK_() {
                return 2479791;
            }

            public final GraphQLVisitableModel m10837a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m10841j() != null) {
                    DefaultImageFieldsModel defaultImageFieldsModel = (DefaultImageFieldsModel) graphQLModelMutatingVisitor.b(m10841j());
                    if (m10841j() != defaultImageFieldsModel) {
                        graphQLVisitableModel = (PageModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f10781e = defaultImageFieldsModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m10836a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m10835k());
                int a = ModelHelper.a(flatBufferBuilder, m10841j());
                flatBufferBuilder.c(2);
                flatBufferBuilder.b(0, b);
                flatBufferBuilder.b(1, a);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: get_notified */
        public class Serializer extends JsonSerializer<FeaturedPageSuggestionModel> {
            public final void m10842a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                FeaturedPageSuggestionModel featuredPageSuggestionModel = (FeaturedPageSuggestionModel) obj;
                if (featuredPageSuggestionModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(featuredPageSuggestionModel.m10853a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    featuredPageSuggestionModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                FeaturedPageSuggestionParser.m10918b(featuredPageSuggestionModel.w_(), featuredPageSuggestionModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(FeaturedPageSuggestionModel.class, new Serializer());
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1352864475)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: get_notified */
        public final class SubtitleModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private String f10782d;

            /* compiled from: get_notified */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(SubtitleModel.class, new Deserializer());
                }

                public Object m10843a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(SubtitleParser.m10913a(jsonParser, flatBufferBuilder));
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

            /* compiled from: get_notified */
            public class Serializer extends JsonSerializer<SubtitleModel> {
                public final void m10844a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    SubtitleModel subtitleModel = (SubtitleModel) obj;
                    if (subtitleModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(subtitleModel.m10845a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        subtitleModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    SubtitleParser.m10914a(subtitleModel.w_(), subtitleModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(SubtitleModel.class, new Serializer());
                }
            }

            public SubtitleModel() {
                super(1);
            }

            @Nullable
            public final String m10847a() {
                this.f10782d = super.a(this.f10782d, 0);
                return this.f10782d;
            }

            public final int jK_() {
                return -1919764332;
            }

            public final GraphQLVisitableModel m10846a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m10845a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m10847a());
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
        /* compiled from: get_notified */
        public final class TitleModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private String f10783d;

            /* compiled from: get_notified */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(TitleModel.class, new Deserializer());
                }

                public Object m10848a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(FeaturedPageSuggestionParser.TitleParser.m10915a(jsonParser, flatBufferBuilder));
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

            /* compiled from: get_notified */
            public class Serializer extends JsonSerializer<TitleModel> {
                public final void m10849a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    TitleModel titleModel = (TitleModel) obj;
                    if (titleModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(titleModel.m10850a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        titleModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    FeaturedPageSuggestionParser.TitleParser.m10916a(titleModel.w_(), titleModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(TitleModel.class, new Serializer());
                }
            }

            public TitleModel() {
                super(1);
            }

            @Nullable
            public final String m10852a() {
                this.f10783d = super.a(this.f10783d, 0);
                return this.f10783d;
            }

            public final int jK_() {
                return -1919764332;
            }

            public final GraphQLVisitableModel m10851a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m10850a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m10852a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, b);
                i();
                return flatBufferBuilder.d();
            }
        }

        public FeaturedPageSuggestionModel() {
            super(3);
        }

        @Nullable
        public final PageModel m10855a() {
            this.f10784d = (PageModel) super.a(this.f10784d, 0, PageModel.class);
            return this.f10784d;
        }

        @Nullable
        public final SubtitleModel m10856j() {
            this.f10785e = (SubtitleModel) super.a(this.f10785e, 1, SubtitleModel.class);
            return this.f10785e;
        }

        @Nullable
        public final TitleModel m10857k() {
            this.f10786f = (TitleModel) super.a(this.f10786f, 2, TitleModel.class);
            return this.f10786f;
        }

        public final int jK_() {
            return -2005447891;
        }

        public final GraphQLVisitableModel m10854a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m10855a() != null) {
                PageModel pageModel = (PageModel) graphQLModelMutatingVisitor.b(m10855a());
                if (m10855a() != pageModel) {
                    graphQLVisitableModel = (FeaturedPageSuggestionModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f10784d = pageModel;
                }
            }
            if (m10856j() != null) {
                SubtitleModel subtitleModel = (SubtitleModel) graphQLModelMutatingVisitor.b(m10856j());
                if (m10856j() != subtitleModel) {
                    graphQLVisitableModel = (FeaturedPageSuggestionModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f10785e = subtitleModel;
                }
            }
            if (m10857k() != null) {
                TitleModel titleModel = (TitleModel) graphQLModelMutatingVisitor.b(m10857k());
                if (m10857k() != titleModel) {
                    graphQLVisitableModel = (FeaturedPageSuggestionModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f10786f = titleModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m10853a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m10855a());
            int a2 = ModelHelper.a(flatBufferBuilder, m10856j());
            int a3 = ModelHelper.a(flatBufferBuilder, m10857k());
            flatBufferBuilder.c(3);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, a2);
            flatBufferBuilder.b(2, a3);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 1151142952)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: get_notified */
    public final class FeaturedPhotoSuggestionModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private PhotoModel f10787d;

        /* compiled from: get_notified */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(FeaturedPhotoSuggestionModel.class, new Deserializer());
            }

            public Object m10858a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(FeaturedPhotoSuggestionParser.m10919b(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object featuredPhotoSuggestionModel = new FeaturedPhotoSuggestionModel();
                ((BaseModel) featuredPhotoSuggestionModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (featuredPhotoSuggestionModel instanceof Postprocessable) {
                    return ((Postprocessable) featuredPhotoSuggestionModel).a();
                }
                return featuredPhotoSuggestionModel;
            }
        }

        /* compiled from: get_notified */
        public class Serializer extends JsonSerializer<FeaturedPhotoSuggestionModel> {
            public final void m10859a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                FeaturedPhotoSuggestionModel featuredPhotoSuggestionModel = (FeaturedPhotoSuggestionModel) obj;
                if (featuredPhotoSuggestionModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(featuredPhotoSuggestionModel.m10860a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    featuredPhotoSuggestionModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                FeaturedPhotoSuggestionParser.m10920b(featuredPhotoSuggestionModel.w_(), featuredPhotoSuggestionModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(FeaturedPhotoSuggestionModel.class, new Serializer());
            }
        }

        public FeaturedPhotoSuggestionModel() {
            super(1);
        }

        @Nullable
        public final PhotoModel m10862a() {
            this.f10787d = (PhotoModel) super.a(this.f10787d, 0, PhotoModel.class);
            return this.f10787d;
        }

        public final int jK_() {
            return -915341398;
        }

        public final GraphQLVisitableModel m10861a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m10862a() != null) {
                PhotoModel photoModel = (PhotoModel) graphQLModelMutatingVisitor.b(m10862a());
                if (m10862a() != photoModel) {
                    graphQLVisitableModel = (FeaturedPhotoSuggestionModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f10787d = photoModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m10860a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m10862a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -634928465)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: get_notified */
    public final class IntroCardModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private FeaturedPagesSuggestionsModel f10790d;
        @Nullable
        private FeaturedPhotosSuggestionsModel f10791e;

        /* compiled from: get_notified */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(IntroCardModel.class, new Deserializer());
            }

            public Object m10863a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(IntroCardParser.m10925a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object introCardModel = new IntroCardModel();
                ((BaseModel) introCardModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (introCardModel instanceof Postprocessable) {
                    return ((Postprocessable) introCardModel).a();
                }
                return introCardModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 198858519)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: get_notified */
        public final class FeaturedPagesSuggestionsModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private List<FeaturedPageSectionModel> f10788d;

            /* compiled from: get_notified */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(FeaturedPagesSuggestionsModel.class, new Deserializer());
                }

                public Object m10864a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(IntroCardParser.FeaturedPagesSuggestionsParser.m10921a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object featuredPagesSuggestionsModel = new FeaturedPagesSuggestionsModel();
                    ((BaseModel) featuredPagesSuggestionsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (featuredPagesSuggestionsModel instanceof Postprocessable) {
                        return ((Postprocessable) featuredPagesSuggestionsModel).a();
                    }
                    return featuredPagesSuggestionsModel;
                }
            }

            /* compiled from: get_notified */
            public class Serializer extends JsonSerializer<FeaturedPagesSuggestionsModel> {
                public final void m10865a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    FeaturedPagesSuggestionsModel featuredPagesSuggestionsModel = (FeaturedPagesSuggestionsModel) obj;
                    if (featuredPagesSuggestionsModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(featuredPagesSuggestionsModel.m10866a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        featuredPagesSuggestionsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    IntroCardParser.FeaturedPagesSuggestionsParser.m10922a(featuredPagesSuggestionsModel.w_(), featuredPagesSuggestionsModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(FeaturedPagesSuggestionsModel.class, new Serializer());
                }
            }

            public FeaturedPagesSuggestionsModel() {
                super(1);
            }

            @Nonnull
            public final ImmutableList<FeaturedPageSectionModel> m10868a() {
                this.f10788d = super.a(this.f10788d, 0, FeaturedPageSectionModel.class);
                return (ImmutableList) this.f10788d;
            }

            public final int jK_() {
                return -1400340174;
            }

            public final GraphQLVisitableModel m10867a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m10868a() != null) {
                    Builder a = ModelHelper.a(m10868a(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        graphQLVisitableModel = (FeaturedPagesSuggestionsModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f10788d = a.b();
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m10866a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m10868a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, a);
                i();
                return flatBufferBuilder.d();
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1322776554)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: get_notified */
        public final class FeaturedPhotosSuggestionsModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private List<FeaturedPhotoSuggestionModel> f10789d;

            /* compiled from: get_notified */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(FeaturedPhotosSuggestionsModel.class, new Deserializer());
                }

                public Object m10869a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(FeaturedPhotosSuggestionsParser.m10923a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object featuredPhotosSuggestionsModel = new FeaturedPhotosSuggestionsModel();
                    ((BaseModel) featuredPhotosSuggestionsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (featuredPhotosSuggestionsModel instanceof Postprocessable) {
                        return ((Postprocessable) featuredPhotosSuggestionsModel).a();
                    }
                    return featuredPhotosSuggestionsModel;
                }
            }

            /* compiled from: get_notified */
            public class Serializer extends JsonSerializer<FeaturedPhotosSuggestionsModel> {
                public final void m10870a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    FeaturedPhotosSuggestionsModel featuredPhotosSuggestionsModel = (FeaturedPhotosSuggestionsModel) obj;
                    if (featuredPhotosSuggestionsModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(featuredPhotosSuggestionsModel.m10871a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        featuredPhotosSuggestionsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    FeaturedPhotosSuggestionsParser.m10924a(featuredPhotosSuggestionsModel.w_(), featuredPhotosSuggestionsModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(FeaturedPhotosSuggestionsModel.class, new Serializer());
                }
            }

            public FeaturedPhotosSuggestionsModel() {
                super(1);
            }

            @Nonnull
            public final ImmutableList<FeaturedPhotoSuggestionModel> m10873a() {
                this.f10789d = super.a(this.f10789d, 0, FeaturedPhotoSuggestionModel.class);
                return (ImmutableList) this.f10789d;
            }

            public final int jK_() {
                return 1190800139;
            }

            public final GraphQLVisitableModel m10872a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m10873a() != null) {
                    Builder a = ModelHelper.a(m10873a(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        graphQLVisitableModel = (FeaturedPhotosSuggestionsModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f10789d = a.b();
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m10871a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m10873a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, a);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: get_notified */
        public class Serializer extends JsonSerializer<IntroCardModel> {
            public final void m10874a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                IntroCardModel introCardModel = (IntroCardModel) obj;
                if (introCardModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(introCardModel.m10875a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    introCardModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                IntroCardParser.m10926a(introCardModel.w_(), introCardModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(IntroCardModel.class, new Serializer());
            }
        }

        public IntroCardModel() {
            super(2);
        }

        @Nullable
        public final FeaturedPagesSuggestionsModel m10877a() {
            this.f10790d = (FeaturedPagesSuggestionsModel) super.a(this.f10790d, 0, FeaturedPagesSuggestionsModel.class);
            return this.f10790d;
        }

        @Nullable
        public final FeaturedPhotosSuggestionsModel m10878j() {
            this.f10791e = (FeaturedPhotosSuggestionsModel) super.a(this.f10791e, 1, FeaturedPhotosSuggestionsModel.class);
            return this.f10791e;
        }

        public final int jK_() {
            return 2102913043;
        }

        public final GraphQLVisitableModel m10876a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m10877a() != null) {
                FeaturedPagesSuggestionsModel featuredPagesSuggestionsModel = (FeaturedPagesSuggestionsModel) graphQLModelMutatingVisitor.b(m10877a());
                if (m10877a() != featuredPagesSuggestionsModel) {
                    graphQLVisitableModel = (IntroCardModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f10790d = featuredPagesSuggestionsModel;
                }
            }
            if (m10878j() != null) {
                FeaturedPhotosSuggestionsModel featuredPhotosSuggestionsModel = (FeaturedPhotosSuggestionsModel) graphQLModelMutatingVisitor.b(m10878j());
                if (m10878j() != featuredPhotosSuggestionsModel) {
                    graphQLVisitableModel = (IntroCardModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f10791e = featuredPhotosSuggestionsModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m10875a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m10877a());
            int a2 = ModelHelper.a(flatBufferBuilder, m10878j());
            flatBufferBuilder.c(2);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, a2);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -327831156)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: get_notified */
    public final class NullStateMorePageSuggestionsQueryModel extends BaseModel implements GraphQLVisitableConsistentModel {
        @Nullable
        private GraphQLObjectType f10792d;
        @Nullable
        private FeaturedPageSectionsModel f10793e;

        /* compiled from: get_notified */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(NullStateMorePageSuggestionsQueryModel.class, new Deserializer());
            }

            public Object m10879a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = NullStateMorePageSuggestionsQueryParser.m10927a(jsonParser);
                Object nullStateMorePageSuggestionsQueryModel = new NullStateMorePageSuggestionsQueryModel();
                ((BaseModel) nullStateMorePageSuggestionsQueryModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (nullStateMorePageSuggestionsQueryModel instanceof Postprocessable) {
                    return ((Postprocessable) nullStateMorePageSuggestionsQueryModel).a();
                }
                return nullStateMorePageSuggestionsQueryModel;
            }
        }

        /* compiled from: get_notified */
        public class Serializer extends JsonSerializer<NullStateMorePageSuggestionsQueryModel> {
            public final void m10880a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                NullStateMorePageSuggestionsQueryModel nullStateMorePageSuggestionsQueryModel = (NullStateMorePageSuggestionsQueryModel) obj;
                if (nullStateMorePageSuggestionsQueryModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(nullStateMorePageSuggestionsQueryModel.m10882a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    nullStateMorePageSuggestionsQueryModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = nullStateMorePageSuggestionsQueryModel.w_();
                int u_ = nullStateMorePageSuggestionsQueryModel.u_();
                jsonGenerator.f();
                if (mutableFlatBuffer.g(u_, 0) != 0) {
                    jsonGenerator.a("__type__");
                    SerializerHelpers.b(mutableFlatBuffer, u_, 0, jsonGenerator);
                }
                int g = mutableFlatBuffer.g(u_, 1);
                if (g != 0) {
                    jsonGenerator.a("profile_intro_card");
                    FeaturedPageSectionsParser.m10910a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(NullStateMorePageSuggestionsQueryModel.class, new Serializer());
            }
        }

        public NullStateMorePageSuggestionsQueryModel() {
            super(2);
        }

        public final void m10885a(String str, ConsistencyTuple consistencyTuple) {
            consistencyTuple.a();
        }

        public final void m10886a(String str, Object obj, boolean z) {
        }

        @Nullable
        private GraphQLObjectType m10881j() {
            if (this.b != null && this.f10792d == null) {
                this.f10792d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
            }
            return this.f10792d;
        }

        @Nullable
        public final FeaturedPageSectionsModel m10884a() {
            this.f10793e = (FeaturedPageSectionsModel) super.a(this.f10793e, 1, FeaturedPageSectionsModel.class);
            return this.f10793e;
        }

        public final int jK_() {
            return 63093205;
        }

        public final GraphQLVisitableModel m10883a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m10884a() != null) {
                FeaturedPageSectionsModel featuredPageSectionsModel = (FeaturedPageSectionsModel) graphQLModelMutatingVisitor.b(m10884a());
                if (m10884a() != featuredPageSectionsModel) {
                    graphQLVisitableModel = (NullStateMorePageSuggestionsQueryModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f10793e = featuredPageSectionsModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m10882a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m10881j());
            int a2 = ModelHelper.a(flatBufferBuilder, m10884a());
            flatBufferBuilder.c(2);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, a2);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -1810715828)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: get_notified */
    public final class PhotoModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel {
        @Nullable
        private String f10794d;
        @Nullable
        private DefaultImageFieldsModel f10795e;

        /* compiled from: get_notified */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(PhotoModel.class, new Deserializer());
            }

            public Object m10887a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(PhotoParser.m10928a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object photoModel = new PhotoModel();
                ((BaseModel) photoModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (photoModel instanceof Postprocessable) {
                    return ((Postprocessable) photoModel).a();
                }
                return photoModel;
            }
        }

        /* compiled from: get_notified */
        public class Serializer extends JsonSerializer<PhotoModel> {
            public final void m10888a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                PhotoModel photoModel = (PhotoModel) obj;
                if (photoModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(photoModel.m10889a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    photoModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                PhotoParser.m10929a(photoModel.w_(), photoModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(PhotoModel.class, new Serializer());
            }
        }

        public PhotoModel() {
            super(2);
        }

        @Nullable
        public final String m10892j() {
            this.f10794d = super.a(this.f10794d, 0);
            return this.f10794d;
        }

        @Nullable
        public final DefaultImageFieldsModel m10893k() {
            this.f10795e = (DefaultImageFieldsModel) super.a(this.f10795e, 1, DefaultImageFieldsModel.class);
            return this.f10795e;
        }

        @Nullable
        public final String m10891a() {
            return m10892j();
        }

        public final int jK_() {
            return 77090322;
        }

        public final GraphQLVisitableModel m10890a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m10893k() != null) {
                DefaultImageFieldsModel defaultImageFieldsModel = (DefaultImageFieldsModel) graphQLModelMutatingVisitor.b(m10893k());
                if (m10893k() != defaultImageFieldsModel) {
                    graphQLVisitableModel = (PhotoModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f10795e = defaultImageFieldsModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m10889a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(m10892j());
            int a = ModelHelper.a(flatBufferBuilder, m10893k());
            flatBufferBuilder.c(2);
            flatBufferBuilder.b(0, b);
            flatBufferBuilder.b(1, a);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 1253167978)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: get_notified */
    public final class UserModel extends BaseModel implements GraphQLVisitableConsistentModel {
        @Nullable
        private IntroCardModel f10796d;

        /* compiled from: get_notified */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(UserModel.class, new Deserializer());
            }

            public Object m10894a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = UserParser.m10930a(jsonParser);
                Object userModel = new UserModel();
                ((BaseModel) userModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (userModel instanceof Postprocessable) {
                    return ((Postprocessable) userModel).a();
                }
                return userModel;
            }
        }

        /* compiled from: get_notified */
        public class Serializer extends JsonSerializer<UserModel> {
            public final void m10895a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                UserModel userModel = (UserModel) obj;
                if (userModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(userModel.m10896a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    userModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = userModel.w_();
                int u_ = userModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("profile_intro_card");
                    IntroCardParser.m10926a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(UserModel.class, new Serializer());
            }
        }

        public UserModel() {
            super(1);
        }

        public final void m10899a(String str, ConsistencyTuple consistencyTuple) {
            consistencyTuple.a();
        }

        public final void m10900a(String str, Object obj, boolean z) {
        }

        @Nullable
        public final IntroCardModel m10898a() {
            this.f10796d = (IntroCardModel) super.a(this.f10796d, 0, IntroCardModel.class);
            return this.f10796d;
        }

        public final int jK_() {
            return 2645995;
        }

        public final GraphQLVisitableModel m10897a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m10898a() != null) {
                IntroCardModel introCardModel = (IntroCardModel) graphQLModelMutatingVisitor.b(m10898a());
                if (m10898a() != introCardModel) {
                    graphQLVisitableModel = (UserModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f10796d = introCardModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m10896a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m10898a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }
}
