package com.facebook.saved2.graphql;

import com.facebook.api.graphql.media.NewsFeedMediaGraphQLInterfaces.SphericalMetadata;
import com.facebook.api.graphql.media.NewsFeedMediaGraphQLModels.SphericalMetadataModel.GuidedTourModel;
import com.facebook.api.graphql.media.NewsFeedMediaGraphQLModels.VideoChannelIdForVideoFragmentModel.VideoChannelModel;
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
import com.facebook.graphql.enums.GraphQLSavedState;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.querybuilder.common.CommonGraphQLModels.DefaultImageFieldsModel;
import com.facebook.graphql.visitor.ConsistencyTuple;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLPersistableNode;
import com.facebook.graphql.visitor.GraphQLVisitableConsistentModel;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.facebook.saved.protocol.graphql.FetchSavedItemsGraphQLModels.ShareableTargetExtraFieldsModel.EventViewerCapabilityModel;
import com.facebook.saved.protocol.graphql.FetchSavedItemsGraphQLModels.ShareableTargetExtraFieldsModel.GlobalShareModel;
import com.facebook.saved.protocol.graphql.FetchSavedItemsGraphQLModels.ViewerRecommendationFieldsModel.ViewerRecommendationModel;
import com.facebook.saved2.graphql.FetchSaved2ItemsGraphQLParsers.FetchSaved2ItemsGraphQLParser;
import com.facebook.saved2.graphql.FetchSaved2ItemsGraphQLParsers.FetchSaved2ItemsGraphQLParser.SavedItemsParser;
import com.facebook.saved2.graphql.FetchSaved2ItemsGraphQLParsers.FetchSaved2ItemsGraphQLParser.SavedItemsParser.PageInfoParser;
import com.facebook.saved2.graphql.FetchSaved2ItemsGraphQLParsers.Saved2DashboardItemFieldsParser;
import com.facebook.saved2.graphql.FetchSaved2ItemsGraphQLParsers.Saved2ItemParser;
import com.facebook.saved2.graphql.FetchSaved2ItemsGraphQLParsers.Saved2ItemParser.AttributionTextParser;
import com.facebook.saved2.graphql.FetchSaved2ItemsGraphQLParsers.Saved2ItemParser.GlobalShareParser;
import com.facebook.saved2.graphql.FetchSaved2ItemsGraphQLParsers.Saved2ItemParser.GlobalShareParser.InstantArticleParser;
import com.facebook.saved2.graphql.FetchSaved2ItemsGraphQLParsers.Saved2ItemParser.GlobalShareParser.InstantArticleParser.LatestVersionParser;
import com.facebook.saved2.graphql.FetchSaved2ItemsGraphQLParsers.Saved2ItemParser.PermalinkNodeParser;
import com.facebook.saved2.graphql.FetchSaved2ItemsGraphQLParsers.Saved2ItemParser.SourceObjectParser;
import com.facebook.saved2.graphql.FetchSaved2ItemsGraphQLParsers.Saved2ItemParser.SourceObjectParser.ActorsParser;
import com.facebook.saved2.graphql.FetchSaved2ItemsGraphQLParsers.Saved2ItemParser.SubtitleTextParser;
import com.facebook.saved2.graphql.FetchSaved2ItemsGraphQLParsers.Saved2ItemParser.TitleParser;
import com.facebook.saved2.graphql.FetchSaved2ItemsGraphQLParsers.Saved2ItemsEdgeParser;
import com.facebook.saved2.graphql.FetchSaved2ItemsGraphQLParsers.Saved2ItemsEdgeParser.GroupTitleParser;
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

/* compiled from: instant_shopping_document_close */
public class FetchSaved2ItemsGraphQLModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 1284908650)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: instant_shopping_document_close */
    public final class FetchSaved2ItemsGraphQLModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private SavedItemsModel f9373d;

        /* compiled from: instant_shopping_document_close */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(FetchSaved2ItemsGraphQLModel.class, new Deserializer());
            }

            public Object m9538a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = FetchSaved2ItemsGraphQLParser.m9678a(jsonParser);
                Object fetchSaved2ItemsGraphQLModel = new FetchSaved2ItemsGraphQLModel();
                ((BaseModel) fetchSaved2ItemsGraphQLModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (fetchSaved2ItemsGraphQLModel instanceof Postprocessable) {
                    return ((Postprocessable) fetchSaved2ItemsGraphQLModel).a();
                }
                return fetchSaved2ItemsGraphQLModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 1950753589)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: instant_shopping_document_close */
        public final class SavedItemsModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private List<Saved2ItemsEdgeModel> f9371d;
            @Nullable
            private PageInfoModel f9372e;

            /* compiled from: instant_shopping_document_close */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(SavedItemsModel.class, new Deserializer());
                }

                public Object m9539a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(SavedItemsParser.m9676a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object savedItemsModel = new SavedItemsModel();
                    ((BaseModel) savedItemsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (savedItemsModel instanceof Postprocessable) {
                        return ((Postprocessable) savedItemsModel).a();
                    }
                    return savedItemsModel;
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = 1947362733)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: instant_shopping_document_close */
            public final class PageInfoModel extends BaseModel implements GraphQLVisitableModel {
                private boolean f9370d;

                /* compiled from: instant_shopping_document_close */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(PageInfoModel.class, new Deserializer());
                    }

                    public Object m9540a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(PageInfoParser.m9674a(jsonParser, flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                        Object pageInfoModel = new PageInfoModel();
                        ((BaseModel) pageInfoModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                        if (pageInfoModel instanceof Postprocessable) {
                            return ((Postprocessable) pageInfoModel).a();
                        }
                        return pageInfoModel;
                    }
                }

                /* compiled from: instant_shopping_document_close */
                public class Serializer extends JsonSerializer<PageInfoModel> {
                    public final void m9541a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        PageInfoModel pageInfoModel = (PageInfoModel) obj;
                        if (pageInfoModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(pageInfoModel.m9542a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            pageInfoModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        PageInfoParser.m9675a(pageInfoModel.w_(), pageInfoModel.u_(), jsonGenerator);
                    }

                    static {
                        FbSerializerProvider.a(PageInfoModel.class, new Serializer());
                    }
                }

                public PageInfoModel() {
                    super(1);
                }

                public final int jK_() {
                    return 923779069;
                }

                public final GraphQLVisitableModel m9543a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    h();
                    i();
                    return this;
                }

                public final int m9542a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.a(0, this.f9370d);
                    i();
                    return flatBufferBuilder.d();
                }

                public final void m9544a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                    super.a(mutableFlatBuffer, i, obj);
                    this.f9370d = mutableFlatBuffer.a(i, 0);
                }
            }

            /* compiled from: instant_shopping_document_close */
            public class Serializer extends JsonSerializer<SavedItemsModel> {
                public final void m9545a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    SavedItemsModel savedItemsModel = (SavedItemsModel) obj;
                    if (savedItemsModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(savedItemsModel.m9547a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        savedItemsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    SavedItemsParser.m9677a(savedItemsModel.w_(), savedItemsModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(SavedItemsModel.class, new Serializer());
                }
            }

            public SavedItemsModel() {
                super(2);
            }

            @Nonnull
            public final ImmutableList<Saved2ItemsEdgeModel> m9549a() {
                this.f9371d = super.a(this.f9371d, 0, Saved2ItemsEdgeModel.class);
                return (ImmutableList) this.f9371d;
            }

            @Nullable
            private PageInfoModel m9546j() {
                this.f9372e = (PageInfoModel) super.a(this.f9372e, 1, PageInfoModel.class);
                return this.f9372e;
            }

            public final int jK_() {
                return -978743870;
            }

            public final GraphQLVisitableModel m9548a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel;
                PageInfoModel pageInfoModel;
                h();
                if (m9549a() != null) {
                    Builder a = ModelHelper.a(m9549a(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        SavedItemsModel savedItemsModel = (SavedItemsModel) ModelHelper.a(null, this);
                        savedItemsModel.f9371d = a.b();
                        graphQLVisitableModel = savedItemsModel;
                        if (m9546j() != null) {
                            pageInfoModel = (PageInfoModel) graphQLModelMutatingVisitor.b(m9546j());
                            if (m9546j() != pageInfoModel) {
                                graphQLVisitableModel = (SavedItemsModel) ModelHelper.a(graphQLVisitableModel, this);
                                graphQLVisitableModel.f9372e = pageInfoModel;
                            }
                        }
                        i();
                        return graphQLVisitableModel != null ? this : graphQLVisitableModel;
                    }
                }
                graphQLVisitableModel = null;
                if (m9546j() != null) {
                    pageInfoModel = (PageInfoModel) graphQLModelMutatingVisitor.b(m9546j());
                    if (m9546j() != pageInfoModel) {
                        graphQLVisitableModel = (SavedItemsModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f9372e = pageInfoModel;
                    }
                }
                i();
                if (graphQLVisitableModel != null) {
                }
            }

            public final int m9547a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m9549a());
                int a2 = ModelHelper.a(flatBufferBuilder, m9546j());
                flatBufferBuilder.c(2);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.b(1, a2);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: instant_shopping_document_close */
        public class Serializer extends JsonSerializer<FetchSaved2ItemsGraphQLModel> {
            public final void m9550a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                FetchSaved2ItemsGraphQLModel fetchSaved2ItemsGraphQLModel = (FetchSaved2ItemsGraphQLModel) obj;
                if (fetchSaved2ItemsGraphQLModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(fetchSaved2ItemsGraphQLModel.m9551a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    fetchSaved2ItemsGraphQLModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = fetchSaved2ItemsGraphQLModel.w_();
                int u_ = fetchSaved2ItemsGraphQLModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("saved_items");
                    SavedItemsParser.m9677a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(FetchSaved2ItemsGraphQLModel.class, new Serializer());
            }
        }

        public FetchSaved2ItemsGraphQLModel() {
            super(1);
        }

        @Nullable
        public final SavedItemsModel m9553a() {
            this.f9373d = (SavedItemsModel) super.a(this.f9373d, 0, SavedItemsModel.class);
            return this.f9373d;
        }

        public final int jK_() {
            return -1732764110;
        }

        public final GraphQLVisitableModel m9552a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m9553a() != null) {
                SavedItemsModel savedItemsModel = (SavedItemsModel) graphQLModelMutatingVisitor.b(m9553a());
                if (m9553a() != savedItemsModel) {
                    graphQLVisitableModel = (FetchSaved2ItemsGraphQLModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f9373d = savedItemsModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m9551a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m9553a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -560261565)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: instant_shopping_document_close */
    public final class Saved2DashboardItemFieldsModel extends BaseModel implements SphericalMetadata, GraphQLPersistableNode, GraphQLVisitableConsistentModel {
        @Nullable
        private GraphQLSavedState f9374A;
        @Nullable
        private GraphQLObjectType f9375d;
        private boolean f9376e;
        @Nullable
        private EventViewerCapabilityModel f9377f;
        @Nullable
        private GlobalShareModel f9378g;
        @Nullable
        private GuidedTourModel f9379h;
        @Nullable
        private String f9380i;
        private int f9381j;
        private int f9382k;
        private int f9383l;
        private boolean f9384m;
        private boolean f9385n;
        @Nullable
        private String f9386o;
        @Nullable
        private String f9387p;
        @Nullable
        private String f9388q;
        private boolean f9389r;
        private double f9390s;
        private double f9391t;
        @Nullable
        private String f9392u;
        @Nullable
        private String f9393v;
        private int f9394w;
        @Nullable
        private VideoChannelModel f9395x;
        private int f9396y;
        @Nullable
        private ViewerRecommendationModel f9397z;

        /* compiled from: instant_shopping_document_close */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(Saved2DashboardItemFieldsModel.class, new Deserializer());
            }

            public Object m9554a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(Saved2DashboardItemFieldsParser.m9679a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object saved2DashboardItemFieldsModel = new Saved2DashboardItemFieldsModel();
                ((BaseModel) saved2DashboardItemFieldsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (saved2DashboardItemFieldsModel instanceof Postprocessable) {
                    return ((Postprocessable) saved2DashboardItemFieldsModel).a();
                }
                return saved2DashboardItemFieldsModel;
            }
        }

        /* compiled from: instant_shopping_document_close */
        public class Serializer extends JsonSerializer<Saved2DashboardItemFieldsModel> {
            public final void m9555a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                Saved2DashboardItemFieldsModel saved2DashboardItemFieldsModel = (Saved2DashboardItemFieldsModel) obj;
                if (saved2DashboardItemFieldsModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(saved2DashboardItemFieldsModel.m9562a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    saved2DashboardItemFieldsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                Saved2DashboardItemFieldsParser.m9680a(saved2DashboardItemFieldsModel.w_(), saved2DashboardItemFieldsModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(Saved2DashboardItemFieldsModel.class, new Serializer());
            }
        }

        public Saved2DashboardItemFieldsModel() {
            super(24);
        }

        public final void m9566a(String str, ConsistencyTuple consistencyTuple) {
            if ("viewer_saved_state".equals(str)) {
                consistencyTuple.a = m9584z();
                consistencyTuple.b = u_();
                consistencyTuple.c = 23;
                return;
            }
            consistencyTuple.a();
        }

        public final void m9567a(String str, Object obj, boolean z) {
            if ("viewer_saved_state".equals(str)) {
                m9561a((GraphQLSavedState) obj);
            }
        }

        @Nullable
        public final GraphQLObjectType m9568j() {
            if (this.b != null && this.f9375d == null) {
                this.f9375d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
            }
            return this.f9375d;
        }

        @Nullable
        public final EventViewerCapabilityModel m9569k() {
            this.f9377f = (EventViewerCapabilityModel) super.a(this.f9377f, 2, EventViewerCapabilityModel.class);
            return this.f9377f;
        }

        @Nullable
        public final GlobalShareModel m9570l() {
            this.f9378g = (GlobalShareModel) super.a(this.f9378g, 3, GlobalShareModel.class);
            return this.f9378g;
        }

        @Nullable
        private GuidedTourModel m9556A() {
            this.f9379h = (GuidedTourModel) super.a(this.f9379h, 4, GuidedTourModel.class);
            return this.f9379h;
        }

        @Nullable
        public final String m9571m() {
            this.f9380i = super.a(this.f9380i, 5);
            return this.f9380i;
        }

        public final int m9572n() {
            a(0, 6);
            return this.f9381j;
        }

        public final int m9573o() {
            a(0, 7);
            return this.f9382k;
        }

        public final int m9574p() {
            a(1, 0);
            return this.f9383l;
        }

        public final boolean m9575q() {
            a(1, 1);
            return this.f9384m;
        }

        public final boolean m9576r() {
            a(1, 2);
            return this.f9385n;
        }

        @Nullable
        private String m9557B() {
            this.f9386o = super.a(this.f9386o, 11);
            return this.f9386o;
        }

        @Nullable
        public final String m9577s() {
            this.f9387p = super.a(this.f9387p, 12);
            return this.f9387p;
        }

        @Nullable
        private String m9558C() {
            this.f9388q = super.a(this.f9388q, 13);
            return this.f9388q;
        }

        public final double m9578t() {
            a(1, 7);
            return this.f9390s;
        }

        public final double m9579u() {
            a(2, 0);
            return this.f9391t;
        }

        @Nullable
        public final String m9580v() {
            this.f9392u = super.a(this.f9392u, 17);
            return this.f9392u;
        }

        @Nullable
        public final String m9581w() {
            this.f9393v = super.a(this.f9393v, 18);
            return this.f9393v;
        }

        public final int m9582x() {
            a(2, 3);
            return this.f9394w;
        }

        @Nullable
        private VideoChannelModel m9559D() {
            this.f9395x = (VideoChannelModel) super.a(this.f9395x, 20, VideoChannelModel.class);
            return this.f9395x;
        }

        public final int m9583y() {
            a(2, 5);
            return this.f9396y;
        }

        @Nullable
        private ViewerRecommendationModel m9560E() {
            this.f9397z = (ViewerRecommendationModel) super.a(this.f9397z, 22, ViewerRecommendationModel.class);
            return this.f9397z;
        }

        @Nullable
        public final GraphQLSavedState m9584z() {
            this.f9374A = (GraphQLSavedState) super.b(this.f9374A, 23, GraphQLSavedState.class, GraphQLSavedState.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
            return this.f9374A;
        }

        private void m9561a(GraphQLSavedState graphQLSavedState) {
            this.f9374A = graphQLSavedState;
            if (this.b != null && this.b.d) {
                this.b.a(this.c, 23, graphQLSavedState != null ? graphQLSavedState.name() : null);
            }
        }

        @Nullable
        public final String m9564a() {
            return m9571m();
        }

        public final int jK_() {
            return 2433570;
        }

        public final GraphQLVisitableModel m9563a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m9569k() != null) {
                EventViewerCapabilityModel eventViewerCapabilityModel = (EventViewerCapabilityModel) graphQLModelMutatingVisitor.b(m9569k());
                if (m9569k() != eventViewerCapabilityModel) {
                    graphQLVisitableModel = (Saved2DashboardItemFieldsModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f9377f = eventViewerCapabilityModel;
                }
            }
            if (m9570l() != null) {
                GlobalShareModel globalShareModel = (GlobalShareModel) graphQLModelMutatingVisitor.b(m9570l());
                if (m9570l() != globalShareModel) {
                    graphQLVisitableModel = (Saved2DashboardItemFieldsModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f9378g = globalShareModel;
                }
            }
            if (m9556A() != null) {
                GuidedTourModel guidedTourModel = (GuidedTourModel) graphQLModelMutatingVisitor.b(m9556A());
                if (m9556A() != guidedTourModel) {
                    graphQLVisitableModel = (Saved2DashboardItemFieldsModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f9379h = guidedTourModel;
                }
            }
            if (m9559D() != null) {
                VideoChannelModel videoChannelModel = (VideoChannelModel) graphQLModelMutatingVisitor.b(m9559D());
                if (m9559D() != videoChannelModel) {
                    graphQLVisitableModel = (Saved2DashboardItemFieldsModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f9395x = videoChannelModel;
                }
            }
            if (m9560E() != null) {
                ViewerRecommendationModel viewerRecommendationModel = (ViewerRecommendationModel) graphQLModelMutatingVisitor.b(m9560E());
                if (m9560E() != viewerRecommendationModel) {
                    graphQLVisitableModel = (Saved2DashboardItemFieldsModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f9397z = viewerRecommendationModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m9562a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m9568j());
            int a2 = ModelHelper.a(flatBufferBuilder, m9569k());
            int a3 = ModelHelper.a(flatBufferBuilder, m9570l());
            int a4 = ModelHelper.a(flatBufferBuilder, m9556A());
            int b = flatBufferBuilder.b(m9571m());
            int b2 = flatBufferBuilder.b(m9557B());
            int b3 = flatBufferBuilder.b(m9577s());
            int b4 = flatBufferBuilder.b(m9558C());
            int b5 = flatBufferBuilder.b(m9580v());
            int b6 = flatBufferBuilder.b(m9581w());
            int a5 = ModelHelper.a(flatBufferBuilder, m9559D());
            int a6 = ModelHelper.a(flatBufferBuilder, m9560E());
            int a7 = flatBufferBuilder.a(m9584z());
            flatBufferBuilder.c(24);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.a(1, this.f9376e);
            flatBufferBuilder.b(2, a2);
            flatBufferBuilder.b(3, a3);
            flatBufferBuilder.b(4, a4);
            flatBufferBuilder.b(5, b);
            flatBufferBuilder.a(6, this.f9381j, 0);
            flatBufferBuilder.a(7, this.f9382k, 0);
            flatBufferBuilder.a(8, this.f9383l, 0);
            flatBufferBuilder.a(9, this.f9384m);
            flatBufferBuilder.a(10, this.f9385n);
            flatBufferBuilder.b(11, b2);
            flatBufferBuilder.b(12, b3);
            flatBufferBuilder.b(13, b4);
            flatBufferBuilder.a(14, this.f9389r);
            flatBufferBuilder.a(15, this.f9390s, 0.0d);
            flatBufferBuilder.a(16, this.f9391t, 0.0d);
            flatBufferBuilder.b(17, b5);
            flatBufferBuilder.b(18, b6);
            flatBufferBuilder.a(19, this.f9394w, 0);
            flatBufferBuilder.b(20, a5);
            flatBufferBuilder.a(21, this.f9396y, 0);
            flatBufferBuilder.b(22, a6);
            flatBufferBuilder.b(23, a7);
            i();
            return flatBufferBuilder.d();
        }

        public final void m9565a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
            super.a(mutableFlatBuffer, i, obj);
            this.f9376e = mutableFlatBuffer.a(i, 1);
            this.f9381j = mutableFlatBuffer.a(i, 6, 0);
            this.f9382k = mutableFlatBuffer.a(i, 7, 0);
            this.f9383l = mutableFlatBuffer.a(i, 8, 0);
            this.f9384m = mutableFlatBuffer.a(i, 9);
            this.f9385n = mutableFlatBuffer.a(i, 10);
            this.f9389r = mutableFlatBuffer.a(i, 14);
            this.f9390s = mutableFlatBuffer.a(i, 15, 0.0d);
            this.f9391t = mutableFlatBuffer.a(i, 16, 0.0d);
            this.f9394w = mutableFlatBuffer.a(i, 19, 0);
            this.f9396y = mutableFlatBuffer.a(i, 21, 0);
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -768296627)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: instant_shopping_document_close */
    public final class Saved2ItemModel extends BaseModel implements GraphQLVisitableConsistentModel {
        @Nullable
        private AttributionTextModel f9414d;
        private long f9415e;
        @Nullable
        private GlobalShareModel f9416f;
        @Nullable
        private DefaultImageFieldsModel f9417g;
        @Nullable
        private Saved2DashboardItemFieldsModel f9418h;
        @Nullable
        private PermalinkNodeModel f9419i;
        @Nullable
        private SourceObjectModel f9420j;
        @Nullable
        private SubtitleTextModel f9421k;
        @Nullable
        private TitleModel f9422l;
        @Nullable
        private String f9423m;

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1352864475)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: instant_shopping_document_close */
        public final class AttributionTextModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private String f9398d;

            /* compiled from: instant_shopping_document_close */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(AttributionTextModel.class, new Deserializer());
                }

                public Object m9585a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(AttributionTextParser.m9681a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object attributionTextModel = new AttributionTextModel();
                    ((BaseModel) attributionTextModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (attributionTextModel instanceof Postprocessable) {
                        return ((Postprocessable) attributionTextModel).a();
                    }
                    return attributionTextModel;
                }
            }

            /* compiled from: instant_shopping_document_close */
            public class Serializer extends JsonSerializer<AttributionTextModel> {
                public final void m9586a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    AttributionTextModel attributionTextModel = (AttributionTextModel) obj;
                    if (attributionTextModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(attributionTextModel.m9587a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        attributionTextModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    AttributionTextParser.m9682a(attributionTextModel.w_(), attributionTextModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(AttributionTextModel.class, new Serializer());
                }
            }

            public AttributionTextModel() {
                super(1);
            }

            @Nullable
            public final String m9589a() {
                this.f9398d = super.a(this.f9398d, 0);
                return this.f9398d;
            }

            public final int jK_() {
                return -1919764332;
            }

            public final GraphQLVisitableModel m9588a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m9587a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m9589a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, b);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: instant_shopping_document_close */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(Saved2ItemModel.class, new Deserializer());
            }

            public Object m9590a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(Saved2ItemParser.m9699a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object saved2ItemModel = new Saved2ItemModel();
                ((BaseModel) saved2ItemModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (saved2ItemModel instanceof Postprocessable) {
                    return ((Postprocessable) saved2ItemModel).a();
                }
                return saved2ItemModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 763532511)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: instant_shopping_document_close */
        public final class GlobalShareModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel {
            @Nullable
            private String f9402d;
            @Nullable
            private InstantArticleModel f9403e;

            /* compiled from: instant_shopping_document_close */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(GlobalShareModel.class, new Deserializer());
                }

                public Object m9591a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(GlobalShareParser.m9687a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object globalShareModel = new GlobalShareModel();
                    ((BaseModel) globalShareModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (globalShareModel instanceof Postprocessable) {
                        return ((Postprocessable) globalShareModel).a();
                    }
                    return globalShareModel;
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = -834390634)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: instant_shopping_document_close */
            public final class InstantArticleModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel {
                @Nullable
                private String f9400d;
                @Nullable
                private LatestVersionModel f9401e;

                /* compiled from: instant_shopping_document_close */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(InstantArticleModel.class, new Deserializer());
                    }

                    public Object m9592a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(InstantArticleParser.m9685a(jsonParser, flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                        Object instantArticleModel = new InstantArticleModel();
                        ((BaseModel) instantArticleModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                        if (instantArticleModel instanceof Postprocessable) {
                            return ((Postprocessable) instantArticleModel).a();
                        }
                        return instantArticleModel;
                    }
                }

                @JsonDeserialize(using = Deserializer.class)
                @ModelWithFlatBufferFormatHash(a = -602222693)
                @JsonSerialize(using = Serializer.class)
                @FragmentModelWithoutBridge
                /* compiled from: instant_shopping_document_close */
                public final class LatestVersionModel extends BaseModel implements GraphQLVisitableModel {
                    @Nullable
                    private String f9399d;

                    /* compiled from: instant_shopping_document_close */
                    public class Deserializer extends FbJsonDeserializer {
                        static {
                            GlobalAutoGenDeserializerCache.a(LatestVersionModel.class, new Deserializer());
                        }

                        public Object m9593a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(LatestVersionParser.m9683a(jsonParser, flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            mutableFlatBuffer.a(4, Boolean.valueOf(true));
                            MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                            Object latestVersionModel = new LatestVersionModel();
                            ((BaseModel) latestVersionModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                            if (latestVersionModel instanceof Postprocessable) {
                                return ((Postprocessable) latestVersionModel).a();
                            }
                            return latestVersionModel;
                        }
                    }

                    /* compiled from: instant_shopping_document_close */
                    public class Serializer extends JsonSerializer<LatestVersionModel> {
                        public final void m9594a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                            LatestVersionModel latestVersionModel = (LatestVersionModel) obj;
                            if (latestVersionModel.w_() == null) {
                                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                flatBufferBuilder.d(latestVersionModel.m9595a(flatBufferBuilder));
                                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                wrap.position(0);
                                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                latestVersionModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                            }
                            LatestVersionParser.m9684a(latestVersionModel.w_(), latestVersionModel.u_(), jsonGenerator);
                        }

                        static {
                            FbSerializerProvider.a(LatestVersionModel.class, new Serializer());
                        }
                    }

                    public LatestVersionModel() {
                        super(1);
                    }

                    @Nullable
                    public final String m9597a() {
                        this.f9399d = super.a(this.f9399d, 0);
                        return this.f9399d;
                    }

                    public final int jK_() {
                        return 1619159843;
                    }

                    public final GraphQLVisitableModel m9596a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                        h();
                        i();
                        return this;
                    }

                    public final int m9595a(FlatBufferBuilder flatBufferBuilder) {
                        h();
                        int b = flatBufferBuilder.b(m9597a());
                        flatBufferBuilder.c(1);
                        flatBufferBuilder.b(0, b);
                        i();
                        return flatBufferBuilder.d();
                    }
                }

                /* compiled from: instant_shopping_document_close */
                public class Serializer extends JsonSerializer<InstantArticleModel> {
                    public final void m9598a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        InstantArticleModel instantArticleModel = (InstantArticleModel) obj;
                        if (instantArticleModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(instantArticleModel.m9599a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            instantArticleModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        InstantArticleParser.m9686a(instantArticleModel.w_(), instantArticleModel.u_(), jsonGenerator, serializerProvider);
                    }

                    static {
                        FbSerializerProvider.a(InstantArticleModel.class, new Serializer());
                    }
                }

                public InstantArticleModel() {
                    super(2);
                }

                @Nullable
                public final String m9602j() {
                    this.f9400d = super.a(this.f9400d, 0);
                    return this.f9400d;
                }

                @Nullable
                public final LatestVersionModel m9603k() {
                    this.f9401e = (LatestVersionModel) super.a(this.f9401e, 1, LatestVersionModel.class);
                    return this.f9401e;
                }

                @Nullable
                public final String m9601a() {
                    return m9602j();
                }

                public final int jK_() {
                    return 1607392245;
                }

                public final GraphQLVisitableModel m9600a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    GraphQLVisitableModel graphQLVisitableModel = null;
                    h();
                    if (m9603k() != null) {
                        LatestVersionModel latestVersionModel = (LatestVersionModel) graphQLModelMutatingVisitor.b(m9603k());
                        if (m9603k() != latestVersionModel) {
                            graphQLVisitableModel = (InstantArticleModel) ModelHelper.a(null, this);
                            graphQLVisitableModel.f9401e = latestVersionModel;
                        }
                    }
                    i();
                    return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                }

                public final int m9599a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int b = flatBufferBuilder.b(m9602j());
                    int a = ModelHelper.a(flatBufferBuilder, m9603k());
                    flatBufferBuilder.c(2);
                    flatBufferBuilder.b(0, b);
                    flatBufferBuilder.b(1, a);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            /* compiled from: instant_shopping_document_close */
            public class Serializer extends JsonSerializer<GlobalShareModel> {
                public final void m9604a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    GlobalShareModel globalShareModel = (GlobalShareModel) obj;
                    if (globalShareModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(globalShareModel.m9606a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        globalShareModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    GlobalShareParser.m9688a(globalShareModel.w_(), globalShareModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(GlobalShareModel.class, new Serializer());
                }
            }

            public GlobalShareModel() {
                super(2);
            }

            @Nullable
            private String m9605k() {
                this.f9402d = super.a(this.f9402d, 0);
                return this.f9402d;
            }

            @Nullable
            public final InstantArticleModel m9609j() {
                this.f9403e = (InstantArticleModel) super.a(this.f9403e, 1, InstantArticleModel.class);
                return this.f9403e;
            }

            @Nullable
            public final String m9608a() {
                return m9605k();
            }

            public final int jK_() {
                return 514783620;
            }

            public final GraphQLVisitableModel m9607a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m9609j() != null) {
                    InstantArticleModel instantArticleModel = (InstantArticleModel) graphQLModelMutatingVisitor.b(m9609j());
                    if (m9609j() != instantArticleModel) {
                        graphQLVisitableModel = (GlobalShareModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f9403e = instantArticleModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m9606a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m9605k());
                int a = ModelHelper.a(flatBufferBuilder, m9609j());
                flatBufferBuilder.c(2);
                flatBufferBuilder.b(0, b);
                flatBufferBuilder.b(1, a);
                i();
                return flatBufferBuilder.d();
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 1410424255)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: instant_shopping_document_close */
        public final class PermalinkNodeModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
            @Nullable
            private GraphQLObjectType f9404d;
            @Nullable
            private String f9405e;
            @Nullable
            private String f9406f;

            /* compiled from: instant_shopping_document_close */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(PermalinkNodeModel.class, new Deserializer());
                }

                public Object m9610a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(PermalinkNodeParser.m9689a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object permalinkNodeModel = new PermalinkNodeModel();
                    ((BaseModel) permalinkNodeModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (permalinkNodeModel instanceof Postprocessable) {
                        return ((Postprocessable) permalinkNodeModel).a();
                    }
                    return permalinkNodeModel;
                }
            }

            /* compiled from: instant_shopping_document_close */
            public class Serializer extends JsonSerializer<PermalinkNodeModel> {
                public final void m9611a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    PermalinkNodeModel permalinkNodeModel = (PermalinkNodeModel) obj;
                    if (permalinkNodeModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(permalinkNodeModel.m9613a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        permalinkNodeModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    PermalinkNodeParser.m9690a(permalinkNodeModel.w_(), permalinkNodeModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(PermalinkNodeModel.class, new Serializer());
                }
            }

            public PermalinkNodeModel() {
                super(3);
            }

            public final void m9616a(String str, ConsistencyTuple consistencyTuple) {
                consistencyTuple.a();
            }

            public final void m9617a(String str, Object obj, boolean z) {
            }

            @Nullable
            public final GraphQLObjectType m9618j() {
                if (this.b != null && this.f9404d == null) {
                    this.f9404d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
                }
                return this.f9404d;
            }

            @Nullable
            public final String m9619k() {
                this.f9405e = super.a(this.f9405e, 1);
                return this.f9405e;
            }

            @Nullable
            private String m9612l() {
                this.f9406f = super.a(this.f9406f, 2);
                return this.f9406f;
            }

            @Nullable
            public final String m9615a() {
                return m9619k();
            }

            public final int jK_() {
                return 2433570;
            }

            public final GraphQLVisitableModel m9614a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m9613a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m9618j());
                int b = flatBufferBuilder.b(m9619k());
                int b2 = flatBufferBuilder.b(m9612l());
                flatBufferBuilder.c(3);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.b(1, b);
                flatBufferBuilder.b(2, b2);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: instant_shopping_document_close */
        public class Serializer extends JsonSerializer<Saved2ItemModel> {
            public final void m9620a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                Saved2ItemModel saved2ItemModel = (Saved2ItemModel) obj;
                if (saved2ItemModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(saved2ItemModel.m9647a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    saved2ItemModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                Saved2ItemParser.m9700a(saved2ItemModel.w_(), saved2ItemModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(Saved2ItemModel.class, new Serializer());
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -72988338)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: instant_shopping_document_close */
        public final class SourceObjectModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel {
            @Nullable
            private GraphQLObjectType f9409d;
            @Nullable
            private List<ActorsModel> f9410e;
            @Nullable
            private String f9411f;

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = -341630258)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: instant_shopping_document_close */
            public final class ActorsModel extends BaseModel implements GraphQLVisitableConsistentModel {
                @Nullable
                private GraphQLObjectType f9407d;
                @Nullable
                private String f9408e;

                /* compiled from: instant_shopping_document_close */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(ActorsModel.class, new Deserializer());
                    }

                    public Object m9621a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(ActorsParser.m9692b(jsonParser, flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                        Object actorsModel = new ActorsModel();
                        ((BaseModel) actorsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                        if (actorsModel instanceof Postprocessable) {
                            return ((Postprocessable) actorsModel).a();
                        }
                        return actorsModel;
                    }
                }

                /* compiled from: instant_shopping_document_close */
                public class Serializer extends JsonSerializer<ActorsModel> {
                    public final void m9622a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        ActorsModel actorsModel = (ActorsModel) obj;
                        if (actorsModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(actorsModel.m9625a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            actorsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        ActorsParser.m9691a(actorsModel.w_(), actorsModel.u_(), jsonGenerator);
                    }

                    static {
                        FbSerializerProvider.a(ActorsModel.class, new Serializer());
                    }
                }

                public ActorsModel() {
                    super(2);
                }

                public final void m9627a(String str, ConsistencyTuple consistencyTuple) {
                    consistencyTuple.a();
                }

                public final void m9628a(String str, Object obj, boolean z) {
                }

                @Nullable
                private GraphQLObjectType m9623a() {
                    if (this.b != null && this.f9407d == null) {
                        this.f9407d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
                    }
                    return this.f9407d;
                }

                @Nullable
                private String m9624j() {
                    this.f9408e = super.a(this.f9408e, 1);
                    return this.f9408e;
                }

                public final int jK_() {
                    return 63093205;
                }

                public final GraphQLVisitableModel m9626a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    h();
                    i();
                    return this;
                }

                public final int m9625a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int a = ModelHelper.a(flatBufferBuilder, m9623a());
                    int b = flatBufferBuilder.b(m9624j());
                    flatBufferBuilder.c(2);
                    flatBufferBuilder.b(0, a);
                    flatBufferBuilder.b(1, b);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            /* compiled from: instant_shopping_document_close */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(SourceObjectModel.class, new Deserializer());
                }

                public Object m9629a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(SourceObjectParser.m9693a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object sourceObjectModel = new SourceObjectModel();
                    ((BaseModel) sourceObjectModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (sourceObjectModel instanceof Postprocessable) {
                        return ((Postprocessable) sourceObjectModel).a();
                    }
                    return sourceObjectModel;
                }
            }

            /* compiled from: instant_shopping_document_close */
            public class Serializer extends JsonSerializer<SourceObjectModel> {
                public final void m9630a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    SourceObjectModel sourceObjectModel = (SourceObjectModel) obj;
                    if (sourceObjectModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(sourceObjectModel.m9633a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        sourceObjectModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    SourceObjectParser.m9694a(sourceObjectModel.w_(), sourceObjectModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(SourceObjectModel.class, new Serializer());
                }
            }

            public SourceObjectModel() {
                super(3);
            }

            @Nullable
            private GraphQLObjectType m9631k() {
                if (this.b != null && this.f9409d == null) {
                    this.f9409d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
                }
                return this.f9409d;
            }

            @Nonnull
            private ImmutableList<ActorsModel> m9632l() {
                this.f9410e = super.a(this.f9410e, 1, ActorsModel.class);
                return (ImmutableList) this.f9410e;
            }

            @Nullable
            public final String m9636j() {
                this.f9411f = super.a(this.f9411f, 2);
                return this.f9411f;
            }

            @Nullable
            public final String m9635a() {
                return m9636j();
            }

            public final int jK_() {
                return -127231902;
            }

            public final GraphQLVisitableModel m9634a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m9632l() != null) {
                    Builder a = ModelHelper.a(m9632l(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        graphQLVisitableModel = (SourceObjectModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f9410e = a.b();
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m9633a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m9631k());
                int a2 = ModelHelper.a(flatBufferBuilder, m9632l());
                int b = flatBufferBuilder.b(m9636j());
                flatBufferBuilder.c(3);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.b(1, a2);
                flatBufferBuilder.b(2, b);
                i();
                return flatBufferBuilder.d();
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1352864475)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: instant_shopping_document_close */
        public final class SubtitleTextModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private String f9412d;

            /* compiled from: instant_shopping_document_close */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(SubtitleTextModel.class, new Deserializer());
                }

                public Object m9637a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(SubtitleTextParser.m9695a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object subtitleTextModel = new SubtitleTextModel();
                    ((BaseModel) subtitleTextModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (subtitleTextModel instanceof Postprocessable) {
                        return ((Postprocessable) subtitleTextModel).a();
                    }
                    return subtitleTextModel;
                }
            }

            /* compiled from: instant_shopping_document_close */
            public class Serializer extends JsonSerializer<SubtitleTextModel> {
                public final void m9638a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    SubtitleTextModel subtitleTextModel = (SubtitleTextModel) obj;
                    if (subtitleTextModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(subtitleTextModel.m9639a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        subtitleTextModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    SubtitleTextParser.m9696a(subtitleTextModel.w_(), subtitleTextModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(SubtitleTextModel.class, new Serializer());
                }
            }

            public SubtitleTextModel() {
                super(1);
            }

            @Nullable
            public final String m9641a() {
                this.f9412d = super.a(this.f9412d, 0);
                return this.f9412d;
            }

            public final int jK_() {
                return -1919764332;
            }

            public final GraphQLVisitableModel m9640a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m9639a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m9641a());
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
        /* compiled from: instant_shopping_document_close */
        public final class TitleModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private String f9413d;

            /* compiled from: instant_shopping_document_close */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(TitleModel.class, new Deserializer());
                }

                public Object m9642a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(TitleParser.m9697a(jsonParser, flatBufferBuilder));
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

            /* compiled from: instant_shopping_document_close */
            public class Serializer extends JsonSerializer<TitleModel> {
                public final void m9643a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    TitleModel titleModel = (TitleModel) obj;
                    if (titleModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(titleModel.m9644a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        titleModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    TitleParser.m9698a(titleModel.w_(), titleModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(TitleModel.class, new Serializer());
                }
            }

            public TitleModel() {
                super(1);
            }

            @Nullable
            public final String m9646a() {
                this.f9413d = super.a(this.f9413d, 0);
                return this.f9413d;
            }

            public final int jK_() {
                return -1919764332;
            }

            public final GraphQLVisitableModel m9645a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m9644a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m9646a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, b);
                i();
                return flatBufferBuilder.d();
            }
        }

        public Saved2ItemModel() {
            super(10);
        }

        public final void m9651a(String str, ConsistencyTuple consistencyTuple) {
            consistencyTuple.a();
        }

        public final void m9652a(String str, Object obj, boolean z) {
        }

        @Nullable
        public final AttributionTextModel m9649a() {
            this.f9414d = (AttributionTextModel) super.a(this.f9414d, 0, AttributionTextModel.class);
            return this.f9414d;
        }

        public final long m9653j() {
            a(0, 1);
            return this.f9415e;
        }

        @Nullable
        public final GlobalShareModel m9654k() {
            this.f9416f = (GlobalShareModel) super.a(this.f9416f, 2, GlobalShareModel.class);
            return this.f9416f;
        }

        @Nullable
        public final DefaultImageFieldsModel m9655l() {
            this.f9417g = (DefaultImageFieldsModel) super.a(this.f9417g, 3, DefaultImageFieldsModel.class);
            return this.f9417g;
        }

        @Nullable
        public final Saved2DashboardItemFieldsModel m9656m() {
            this.f9418h = (Saved2DashboardItemFieldsModel) super.a(this.f9418h, 4, Saved2DashboardItemFieldsModel.class);
            return this.f9418h;
        }

        @Nullable
        public final PermalinkNodeModel m9657n() {
            this.f9419i = (PermalinkNodeModel) super.a(this.f9419i, 5, PermalinkNodeModel.class);
            return this.f9419i;
        }

        @Nullable
        public final SourceObjectModel m9658o() {
            this.f9420j = (SourceObjectModel) super.a(this.f9420j, 6, SourceObjectModel.class);
            return this.f9420j;
        }

        @Nullable
        public final SubtitleTextModel m9659p() {
            this.f9421k = (SubtitleTextModel) super.a(this.f9421k, 7, SubtitleTextModel.class);
            return this.f9421k;
        }

        @Nullable
        public final TitleModel m9660q() {
            this.f9422l = (TitleModel) super.a(this.f9422l, 8, TitleModel.class);
            return this.f9422l;
        }

        @Nullable
        public final String m9661r() {
            this.f9423m = super.a(this.f9423m, 9);
            return this.f9423m;
        }

        public final int jK_() {
            return -154776335;
        }

        public final GraphQLVisitableModel m9648a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m9649a() != null) {
                AttributionTextModel attributionTextModel = (AttributionTextModel) graphQLModelMutatingVisitor.b(m9649a());
                if (m9649a() != attributionTextModel) {
                    graphQLVisitableModel = (Saved2ItemModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f9414d = attributionTextModel;
                }
            }
            if (m9654k() != null) {
                GlobalShareModel globalShareModel = (GlobalShareModel) graphQLModelMutatingVisitor.b(m9654k());
                if (m9654k() != globalShareModel) {
                    graphQLVisitableModel = (Saved2ItemModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f9416f = globalShareModel;
                }
            }
            if (m9655l() != null) {
                DefaultImageFieldsModel defaultImageFieldsModel = (DefaultImageFieldsModel) graphQLModelMutatingVisitor.b(m9655l());
                if (m9655l() != defaultImageFieldsModel) {
                    graphQLVisitableModel = (Saved2ItemModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f9417g = defaultImageFieldsModel;
                }
            }
            if (m9656m() != null) {
                Saved2DashboardItemFieldsModel saved2DashboardItemFieldsModel = (Saved2DashboardItemFieldsModel) graphQLModelMutatingVisitor.b(m9656m());
                if (m9656m() != saved2DashboardItemFieldsModel) {
                    graphQLVisitableModel = (Saved2ItemModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f9418h = saved2DashboardItemFieldsModel;
                }
            }
            if (m9657n() != null) {
                PermalinkNodeModel permalinkNodeModel = (PermalinkNodeModel) graphQLModelMutatingVisitor.b(m9657n());
                if (m9657n() != permalinkNodeModel) {
                    graphQLVisitableModel = (Saved2ItemModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f9419i = permalinkNodeModel;
                }
            }
            if (m9658o() != null) {
                SourceObjectModel sourceObjectModel = (SourceObjectModel) graphQLModelMutatingVisitor.b(m9658o());
                if (m9658o() != sourceObjectModel) {
                    graphQLVisitableModel = (Saved2ItemModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f9420j = sourceObjectModel;
                }
            }
            if (m9659p() != null) {
                SubtitleTextModel subtitleTextModel = (SubtitleTextModel) graphQLModelMutatingVisitor.b(m9659p());
                if (m9659p() != subtitleTextModel) {
                    graphQLVisitableModel = (Saved2ItemModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f9421k = subtitleTextModel;
                }
            }
            if (m9660q() != null) {
                TitleModel titleModel = (TitleModel) graphQLModelMutatingVisitor.b(m9660q());
                if (m9660q() != titleModel) {
                    graphQLVisitableModel = (Saved2ItemModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f9422l = titleModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m9647a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m9649a());
            int a2 = ModelHelper.a(flatBufferBuilder, m9654k());
            int a3 = ModelHelper.a(flatBufferBuilder, m9655l());
            int a4 = ModelHelper.a(flatBufferBuilder, m9656m());
            int a5 = ModelHelper.a(flatBufferBuilder, m9657n());
            int a6 = ModelHelper.a(flatBufferBuilder, m9658o());
            int a7 = ModelHelper.a(flatBufferBuilder, m9659p());
            int a8 = ModelHelper.a(flatBufferBuilder, m9660q());
            int b = flatBufferBuilder.b(m9661r());
            flatBufferBuilder.c(10);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.a(1, this.f9415e, 0);
            flatBufferBuilder.b(2, a2);
            flatBufferBuilder.b(3, a3);
            flatBufferBuilder.b(4, a4);
            flatBufferBuilder.b(5, a5);
            flatBufferBuilder.b(6, a6);
            flatBufferBuilder.b(7, a7);
            flatBufferBuilder.b(8, a8);
            flatBufferBuilder.b(9, b);
            i();
            return flatBufferBuilder.d();
        }

        public final void m9650a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
            super.a(mutableFlatBuffer, i, obj);
            this.f9415e = mutableFlatBuffer.a(i, 1, 0);
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -241018507)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: instant_shopping_document_close */
    public final class Saved2ItemsEdgeModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private String f9425d;
        @Nullable
        private GroupTitleModel f9426e;
        @Nullable
        private Saved2ItemModel f9427f;

        /* compiled from: instant_shopping_document_close */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(Saved2ItemsEdgeModel.class, new Deserializer());
            }

            public Object m9662a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(Saved2ItemsEdgeParser.m9703b(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object saved2ItemsEdgeModel = new Saved2ItemsEdgeModel();
                ((BaseModel) saved2ItemsEdgeModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (saved2ItemsEdgeModel instanceof Postprocessable) {
                    return ((Postprocessable) saved2ItemsEdgeModel).a();
                }
                return saved2ItemsEdgeModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1352864475)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: instant_shopping_document_close */
        public final class GroupTitleModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private String f9424d;

            /* compiled from: instant_shopping_document_close */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(GroupTitleModel.class, new Deserializer());
                }

                public Object m9663a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(GroupTitleParser.m9701a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object groupTitleModel = new GroupTitleModel();
                    ((BaseModel) groupTitleModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (groupTitleModel instanceof Postprocessable) {
                        return ((Postprocessable) groupTitleModel).a();
                    }
                    return groupTitleModel;
                }
            }

            /* compiled from: instant_shopping_document_close */
            public class Serializer extends JsonSerializer<GroupTitleModel> {
                public final void m9664a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    GroupTitleModel groupTitleModel = (GroupTitleModel) obj;
                    if (groupTitleModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(groupTitleModel.m9665a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        groupTitleModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    GroupTitleParser.m9702a(groupTitleModel.w_(), groupTitleModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(GroupTitleModel.class, new Serializer());
                }
            }

            public GroupTitleModel() {
                super(1);
            }

            @Nullable
            public final String m9667a() {
                this.f9424d = super.a(this.f9424d, 0);
                return this.f9424d;
            }

            public final int jK_() {
                return -1919764332;
            }

            public final GraphQLVisitableModel m9666a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m9665a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m9667a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, b);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: instant_shopping_document_close */
        public class Serializer extends JsonSerializer<Saved2ItemsEdgeModel> {
            public final void m9668a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                Saved2ItemsEdgeModel saved2ItemsEdgeModel = (Saved2ItemsEdgeModel) obj;
                if (saved2ItemsEdgeModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(saved2ItemsEdgeModel.m9669a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    saved2ItemsEdgeModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                Saved2ItemsEdgeParser.m9704b(saved2ItemsEdgeModel.w_(), saved2ItemsEdgeModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(Saved2ItemsEdgeModel.class, new Serializer());
            }
        }

        public Saved2ItemsEdgeModel() {
            super(3);
        }

        @Nullable
        public final String m9671a() {
            this.f9425d = super.a(this.f9425d, 0);
            return this.f9425d;
        }

        @Nullable
        public final GroupTitleModel m9672j() {
            this.f9426e = (GroupTitleModel) super.a(this.f9426e, 1, GroupTitleModel.class);
            return this.f9426e;
        }

        @Nullable
        public final Saved2ItemModel m9673k() {
            this.f9427f = (Saved2ItemModel) super.a(this.f9427f, 2, Saved2ItemModel.class);
            return this.f9427f;
        }

        public final int jK_() {
            return -852330591;
        }

        public final GraphQLVisitableModel m9670a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m9672j() != null) {
                GroupTitleModel groupTitleModel = (GroupTitleModel) graphQLModelMutatingVisitor.b(m9672j());
                if (m9672j() != groupTitleModel) {
                    graphQLVisitableModel = (Saved2ItemsEdgeModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f9426e = groupTitleModel;
                }
            }
            if (m9673k() != null) {
                Saved2ItemModel saved2ItemModel = (Saved2ItemModel) graphQLModelMutatingVisitor.b(m9673k());
                if (m9673k() != saved2ItemModel) {
                    graphQLVisitableModel = (Saved2ItemsEdgeModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f9427f = saved2ItemModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m9669a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(m9671a());
            int a = ModelHelper.a(flatBufferBuilder, m9672j());
            int a2 = ModelHelper.a(flatBufferBuilder, m9673k());
            flatBufferBuilder.c(3);
            flatBufferBuilder.b(0, b);
            flatBufferBuilder.b(1, a);
            flatBufferBuilder.b(2, a2);
            i();
            return flatBufferBuilder.d();
        }
    }
}
