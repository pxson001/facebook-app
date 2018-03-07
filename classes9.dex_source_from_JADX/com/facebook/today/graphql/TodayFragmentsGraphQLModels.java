package com.facebook.today.graphql;

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
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.querybuilder.common.CommonGraphQL2Models.DefaultPageInfoFieldsModel;
import com.facebook.graphql.querybuilder.common.TextWithEntitiesGraphQLModels.DefaultTextWithEntitiesFieldsModel;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.facebook.reaction.protocol.common.ReactionCommonGraphQLModels.ReactionImageFieldsModel;
import com.facebook.reaction.protocol.graphql.ReactionActionsGraphQLModels.ReactionWeatherSettingsPlaceItemFragmentModel;
import com.facebook.today.graphql.TodayFragmentsGraphQLParsers.ReactionWeatherCitySettingsQueryParser;
import com.facebook.today.graphql.TodayFragmentsGraphQLParsers.ReactionWeatherCitySettingsQueryParser.ReactionContentSettingsParser;
import com.facebook.today.graphql.TodayFragmentsGraphQLParsers.ReactionWeatherCitySettingsQueryParser.ReactionContentSettingsParser.AcornWeatherContentSettingsSuggestionsParser;
import com.facebook.today.graphql.TodayFragmentsGraphQLParsers.ReactionWeatherCitySettingsQueryParser.ReactionContentSettingsParser.AcornWeatherContentSettingsSuggestionsParser.EdgesParser;
import com.facebook.today.graphql.TodayFragmentsGraphQLParsers.ReactionWeatherCitySettingsQueryParser.ReactionContentSettingsParser.AcornWeatherContentSettingsSuggestionsParser.PageInfoParser;
import com.facebook.today.graphql.TodayFragmentsGraphQLParsers.TodayOTDQueryParser;
import com.facebook.today.graphql.TodayFragmentsGraphQLParsers.TodayOTDQueryParser.TodayOtdStoriesParser;
import com.facebook.today.graphql.TodayFragmentsGraphQLParsers.TodayOTDQueryParser.TodayOtdStoriesParser.SectionsParser;
import com.facebook.today.graphql.TodayFragmentsGraphQLParsers.TodayOTDQueryParser.TodayOtdStoriesParser.SectionsParser.SubtitleParser;
import com.facebook.today.graphql.TodayFragmentsGraphQLParsers.TodayOTDQueryParser.TodayOtdStoriesParser.SectionsParser.TitleParser;
import com.facebook.today.graphql.TodayFragmentsGraphQLParsers.TodayOTDStoryEdgeFragmentParser;
import com.facebook.today.graphql.TodayFragmentsGraphQLParsers.TodayUnitSettingsQueryParser;
import com.facebook.today.graphql.TodayFragmentsGraphQLParsers.TodayUnitSettingsQueryParser.TodayUnitSettingsParser;
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

/* compiled from: udp_parcel_key */
public class TodayFragmentsGraphQLModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 368873228)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: udp_parcel_key */
    public final class ReactionWeatherCitySettingsQueryModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private ReactionContentSettingsModel f1176d;

        /* compiled from: udp_parcel_key */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(ReactionWeatherCitySettingsQueryModel.class, new Deserializer());
            }

            public Object m1221a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = ReactionWeatherCitySettingsQueryParser.m1306a(jsonParser);
                Object reactionWeatherCitySettingsQueryModel = new ReactionWeatherCitySettingsQueryModel();
                ((BaseModel) reactionWeatherCitySettingsQueryModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (reactionWeatherCitySettingsQueryModel instanceof Postprocessable) {
                    return ((Postprocessable) reactionWeatherCitySettingsQueryModel).a();
                }
                return reactionWeatherCitySettingsQueryModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1552579509)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: udp_parcel_key */
        public final class ReactionContentSettingsModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private AcornWeatherContentSettingsSuggestionsModel f1175d;

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = 2028847704)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: udp_parcel_key */
            public final class AcornWeatherContentSettingsSuggestionsModel extends BaseModel implements GraphQLVisitableModel {
                @Nullable
                private List<EdgesModel> f1173d;
                @Nullable
                private PageInfoModel f1174e;

                /* compiled from: udp_parcel_key */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(AcornWeatherContentSettingsSuggestionsModel.class, new Deserializer());
                    }

                    public Object m1222a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(AcornWeatherContentSettingsSuggestionsParser.m1302a(jsonParser, flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                        Object acornWeatherContentSettingsSuggestionsModel = new AcornWeatherContentSettingsSuggestionsModel();
                        ((BaseModel) acornWeatherContentSettingsSuggestionsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                        if (acornWeatherContentSettingsSuggestionsModel instanceof Postprocessable) {
                            return ((Postprocessable) acornWeatherContentSettingsSuggestionsModel).a();
                        }
                        return acornWeatherContentSettingsSuggestionsModel;
                    }
                }

                @JsonDeserialize(using = Deserializer.class)
                @ModelWithFlatBufferFormatHash(a = 1989519063)
                @JsonSerialize(using = Serializer.class)
                @FragmentModelWithoutBridge
                /* compiled from: udp_parcel_key */
                public final class EdgesModel extends BaseModel implements GraphQLVisitableModel {
                    @Nullable
                    private ReactionWeatherSettingsPlaceItemFragmentModel f1169d;

                    /* compiled from: udp_parcel_key */
                    public class Deserializer extends FbJsonDeserializer {
                        static {
                            GlobalAutoGenDeserializerCache.a(EdgesModel.class, new Deserializer());
                        }

                        public Object m1223a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(EdgesParser.m1298b(jsonParser, flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            mutableFlatBuffer.a(4, Boolean.valueOf(true));
                            MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                            Object edgesModel = new EdgesModel();
                            ((BaseModel) edgesModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                            if (edgesModel instanceof Postprocessable) {
                                return ((Postprocessable) edgesModel).a();
                            }
                            return edgesModel;
                        }
                    }

                    /* compiled from: udp_parcel_key */
                    public class Serializer extends JsonSerializer<EdgesModel> {
                        public final void m1224a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                            EdgesModel edgesModel = (EdgesModel) obj;
                            if (edgesModel.w_() == null) {
                                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                flatBufferBuilder.d(edgesModel.m1226a(flatBufferBuilder));
                                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                wrap.position(0);
                                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                edgesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                            }
                            EdgesParser.m1299b(edgesModel.w_(), edgesModel.u_(), jsonGenerator, serializerProvider);
                        }

                        static {
                            FbSerializerProvider.a(EdgesModel.class, new Serializer());
                        }
                    }

                    public EdgesModel() {
                        super(1);
                    }

                    @Nullable
                    private ReactionWeatherSettingsPlaceItemFragmentModel m1225a() {
                        this.f1169d = (ReactionWeatherSettingsPlaceItemFragmentModel) super.a(this.f1169d, 0, ReactionWeatherSettingsPlaceItemFragmentModel.class);
                        return this.f1169d;
                    }

                    public final int jK_() {
                        return 651473464;
                    }

                    public final GraphQLVisitableModel m1227a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                        GraphQLVisitableModel graphQLVisitableModel = null;
                        h();
                        if (m1225a() != null) {
                            ReactionWeatherSettingsPlaceItemFragmentModel reactionWeatherSettingsPlaceItemFragmentModel = (ReactionWeatherSettingsPlaceItemFragmentModel) graphQLModelMutatingVisitor.b(m1225a());
                            if (m1225a() != reactionWeatherSettingsPlaceItemFragmentModel) {
                                graphQLVisitableModel = (EdgesModel) ModelHelper.a(null, this);
                                graphQLVisitableModel.f1169d = reactionWeatherSettingsPlaceItemFragmentModel;
                            }
                        }
                        i();
                        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                    }

                    public final int m1226a(FlatBufferBuilder flatBufferBuilder) {
                        h();
                        int a = ModelHelper.a(flatBufferBuilder, m1225a());
                        flatBufferBuilder.c(1);
                        flatBufferBuilder.b(0, a);
                        i();
                        return flatBufferBuilder.d();
                    }
                }

                @JsonDeserialize(using = Deserializer.class)
                @ModelWithFlatBufferFormatHash(a = -1638106720)
                @JsonSerialize(using = Serializer.class)
                @FragmentModelWithoutBridge
                /* compiled from: udp_parcel_key */
                public final class PageInfoModel extends BaseModel implements GraphQLVisitableModel {
                    @Nullable
                    private String f1170d;
                    private boolean f1171e;
                    @Nullable
                    private String f1172f;

                    /* compiled from: udp_parcel_key */
                    public class Deserializer extends FbJsonDeserializer {
                        static {
                            GlobalAutoGenDeserializerCache.a(PageInfoModel.class, new Deserializer());
                        }

                        public Object m1228a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(PageInfoParser.m1300a(jsonParser, flatBufferBuilder));
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

                    /* compiled from: udp_parcel_key */
                    public class Serializer extends JsonSerializer<PageInfoModel> {
                        public final void m1229a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                            PageInfoModel pageInfoModel = (PageInfoModel) obj;
                            if (pageInfoModel.w_() == null) {
                                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                flatBufferBuilder.d(pageInfoModel.m1232a(flatBufferBuilder));
                                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                wrap.position(0);
                                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                pageInfoModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                            }
                            PageInfoParser.m1301a(pageInfoModel.w_(), pageInfoModel.u_(), jsonGenerator);
                        }

                        static {
                            FbSerializerProvider.a(PageInfoModel.class, new Serializer());
                        }
                    }

                    public PageInfoModel() {
                        super(3);
                    }

                    @Nullable
                    private String m1230a() {
                        this.f1170d = super.a(this.f1170d, 0);
                        return this.f1170d;
                    }

                    @Nullable
                    private String m1231j() {
                        this.f1172f = super.a(this.f1172f, 2);
                        return this.f1172f;
                    }

                    public final int jK_() {
                        return 923779069;
                    }

                    public final GraphQLVisitableModel m1233a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                        h();
                        i();
                        return this;
                    }

                    public final int m1232a(FlatBufferBuilder flatBufferBuilder) {
                        h();
                        int b = flatBufferBuilder.b(m1230a());
                        int b2 = flatBufferBuilder.b(m1231j());
                        flatBufferBuilder.c(3);
                        flatBufferBuilder.b(0, b);
                        flatBufferBuilder.a(1, this.f1171e);
                        flatBufferBuilder.b(2, b2);
                        i();
                        return flatBufferBuilder.d();
                    }

                    public final void m1234a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                        super.a(mutableFlatBuffer, i, obj);
                        this.f1171e = mutableFlatBuffer.a(i, 1);
                    }
                }

                /* compiled from: udp_parcel_key */
                public class Serializer extends JsonSerializer<AcornWeatherContentSettingsSuggestionsModel> {
                    public final void m1235a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        AcornWeatherContentSettingsSuggestionsModel acornWeatherContentSettingsSuggestionsModel = (AcornWeatherContentSettingsSuggestionsModel) obj;
                        if (acornWeatherContentSettingsSuggestionsModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(acornWeatherContentSettingsSuggestionsModel.m1238a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            acornWeatherContentSettingsSuggestionsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        AcornWeatherContentSettingsSuggestionsParser.m1303a(acornWeatherContentSettingsSuggestionsModel.w_(), acornWeatherContentSettingsSuggestionsModel.u_(), jsonGenerator, serializerProvider);
                    }

                    static {
                        FbSerializerProvider.a(AcornWeatherContentSettingsSuggestionsModel.class, new Serializer());
                    }
                }

                public AcornWeatherContentSettingsSuggestionsModel() {
                    super(2);
                }

                @Nonnull
                private ImmutableList<EdgesModel> m1236a() {
                    this.f1173d = super.a(this.f1173d, 0, EdgesModel.class);
                    return (ImmutableList) this.f1173d;
                }

                @Nullable
                private PageInfoModel m1237j() {
                    this.f1174e = (PageInfoModel) super.a(this.f1174e, 1, PageInfoModel.class);
                    return this.f1174e;
                }

                public final int jK_() {
                    return 990198553;
                }

                public final GraphQLVisitableModel m1239a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    GraphQLVisitableModel graphQLVisitableModel;
                    PageInfoModel pageInfoModel;
                    h();
                    if (m1236a() != null) {
                        Builder a = ModelHelper.a(m1236a(), graphQLModelMutatingVisitor);
                        if (a != null) {
                            AcornWeatherContentSettingsSuggestionsModel acornWeatherContentSettingsSuggestionsModel = (AcornWeatherContentSettingsSuggestionsModel) ModelHelper.a(null, this);
                            acornWeatherContentSettingsSuggestionsModel.f1173d = a.b();
                            graphQLVisitableModel = acornWeatherContentSettingsSuggestionsModel;
                            if (m1237j() != null) {
                                pageInfoModel = (PageInfoModel) graphQLModelMutatingVisitor.b(m1237j());
                                if (m1237j() != pageInfoModel) {
                                    graphQLVisitableModel = (AcornWeatherContentSettingsSuggestionsModel) ModelHelper.a(graphQLVisitableModel, this);
                                    graphQLVisitableModel.f1174e = pageInfoModel;
                                }
                            }
                            i();
                            return graphQLVisitableModel != null ? this : graphQLVisitableModel;
                        }
                    }
                    graphQLVisitableModel = null;
                    if (m1237j() != null) {
                        pageInfoModel = (PageInfoModel) graphQLModelMutatingVisitor.b(m1237j());
                        if (m1237j() != pageInfoModel) {
                            graphQLVisitableModel = (AcornWeatherContentSettingsSuggestionsModel) ModelHelper.a(graphQLVisitableModel, this);
                            graphQLVisitableModel.f1174e = pageInfoModel;
                        }
                    }
                    i();
                    if (graphQLVisitableModel != null) {
                    }
                }

                public final int m1238a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int a = ModelHelper.a(flatBufferBuilder, m1236a());
                    int a2 = ModelHelper.a(flatBufferBuilder, m1237j());
                    flatBufferBuilder.c(2);
                    flatBufferBuilder.b(0, a);
                    flatBufferBuilder.b(1, a2);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            /* compiled from: udp_parcel_key */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(ReactionContentSettingsModel.class, new Deserializer());
                }

                public Object m1240a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(ReactionContentSettingsParser.m1304a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object reactionContentSettingsModel = new ReactionContentSettingsModel();
                    ((BaseModel) reactionContentSettingsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (reactionContentSettingsModel instanceof Postprocessable) {
                        return ((Postprocessable) reactionContentSettingsModel).a();
                    }
                    return reactionContentSettingsModel;
                }
            }

            /* compiled from: udp_parcel_key */
            public class Serializer extends JsonSerializer<ReactionContentSettingsModel> {
                public final void m1241a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    ReactionContentSettingsModel reactionContentSettingsModel = (ReactionContentSettingsModel) obj;
                    if (reactionContentSettingsModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(reactionContentSettingsModel.m1243a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        reactionContentSettingsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    ReactionContentSettingsParser.m1305a(reactionContentSettingsModel.w_(), reactionContentSettingsModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(ReactionContentSettingsModel.class, new Serializer());
                }
            }

            public ReactionContentSettingsModel() {
                super(1);
            }

            @Nullable
            private AcornWeatherContentSettingsSuggestionsModel m1242a() {
                this.f1175d = (AcornWeatherContentSettingsSuggestionsModel) super.a(this.f1175d, 0, AcornWeatherContentSettingsSuggestionsModel.class);
                return this.f1175d;
            }

            public final int jK_() {
                return -1843738061;
            }

            public final GraphQLVisitableModel m1244a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m1242a() != null) {
                    AcornWeatherContentSettingsSuggestionsModel acornWeatherContentSettingsSuggestionsModel = (AcornWeatherContentSettingsSuggestionsModel) graphQLModelMutatingVisitor.b(m1242a());
                    if (m1242a() != acornWeatherContentSettingsSuggestionsModel) {
                        graphQLVisitableModel = (ReactionContentSettingsModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f1175d = acornWeatherContentSettingsSuggestionsModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m1243a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m1242a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, a);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: udp_parcel_key */
        public class Serializer extends JsonSerializer<ReactionWeatherCitySettingsQueryModel> {
            public final void m1245a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                ReactionWeatherCitySettingsQueryModel reactionWeatherCitySettingsQueryModel = (ReactionWeatherCitySettingsQueryModel) obj;
                if (reactionWeatherCitySettingsQueryModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(reactionWeatherCitySettingsQueryModel.m1247a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    reactionWeatherCitySettingsQueryModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = reactionWeatherCitySettingsQueryModel.w_();
                int u_ = reactionWeatherCitySettingsQueryModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("reaction_content_settings");
                    ReactionContentSettingsParser.m1305a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(ReactionWeatherCitySettingsQueryModel.class, new Serializer());
            }
        }

        public ReactionWeatherCitySettingsQueryModel() {
            super(1);
        }

        @Nullable
        private ReactionContentSettingsModel m1246a() {
            this.f1176d = (ReactionContentSettingsModel) super.a(this.f1176d, 0, ReactionContentSettingsModel.class);
            return this.f1176d;
        }

        public final int jK_() {
            return -1732764110;
        }

        public final GraphQLVisitableModel m1248a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m1246a() != null) {
                ReactionContentSettingsModel reactionContentSettingsModel = (ReactionContentSettingsModel) graphQLModelMutatingVisitor.b(m1246a());
                if (m1246a() != reactionContentSettingsModel) {
                    graphQLVisitableModel = (ReactionWeatherCitySettingsQueryModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f1176d = reactionContentSettingsModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m1247a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m1246a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }

    @FragmentModelWithBridge
    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 559261047)
    @JsonSerialize(using = Serializer.class)
    /* compiled from: udp_parcel_key */
    public final class TodayOTDQueryModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private TodayOtdStoriesModel f1185d;

        /* compiled from: udp_parcel_key */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(TodayOTDQueryModel.class, new Deserializer());
            }

            public Object m1249a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = TodayOTDQueryParser.m1316a(jsonParser);
                Object todayOTDQueryModel = new TodayOTDQueryModel();
                ((BaseModel) todayOTDQueryModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (todayOTDQueryModel instanceof Postprocessable) {
                    return ((Postprocessable) todayOTDQueryModel).a();
                }
                return todayOTDQueryModel;
            }
        }

        /* compiled from: udp_parcel_key */
        public class Serializer extends JsonSerializer<TodayOTDQueryModel> {
            public final void m1250a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                TodayOTDQueryModel todayOTDQueryModel = (TodayOTDQueryModel) obj;
                if (todayOTDQueryModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(todayOTDQueryModel.m1276a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    todayOTDQueryModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = todayOTDQueryModel.w_();
                int u_ = todayOTDQueryModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("today_otd_stories");
                    TodayOtdStoriesParser.m1315a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(TodayOTDQueryModel.class, new Serializer());
            }
        }

        @FragmentModelWithBridge
        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -332392914)
        @JsonSerialize(using = Serializer.class)
        /* compiled from: udp_parcel_key */
        public final class TodayOtdStoriesModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private List<TodayOTDStoryEdgeFragmentModel> f1182d;
            @Nullable
            private DefaultPageInfoFieldsModel f1183e;
            @Nullable
            private List<SectionsModel> f1184f;

            /* compiled from: udp_parcel_key */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(TodayOtdStoriesModel.class, new Deserializer());
                }

                public Object m1251a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(TodayOtdStoriesParser.m1314a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object todayOtdStoriesModel = new TodayOtdStoriesModel();
                    ((BaseModel) todayOtdStoriesModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (todayOtdStoriesModel instanceof Postprocessable) {
                        return ((Postprocessable) todayOtdStoriesModel).a();
                    }
                    return todayOtdStoriesModel;
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = 900652116)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: udp_parcel_key */
            public final class SectionsModel extends BaseModel implements GraphQLVisitableModel {
                @Nullable
                private String f1179d;
                @Nullable
                private SubtitleModel f1180e;
                @Nullable
                private TitleModel f1181f;

                /* compiled from: udp_parcel_key */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(SectionsModel.class, new Deserializer());
                    }

                    public Object m1252a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(SectionsParser.m1312b(jsonParser, flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                        Object sectionsModel = new SectionsModel();
                        ((BaseModel) sectionsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                        if (sectionsModel instanceof Postprocessable) {
                            return ((Postprocessable) sectionsModel).a();
                        }
                        return sectionsModel;
                    }
                }

                /* compiled from: udp_parcel_key */
                public class Serializer extends JsonSerializer<SectionsModel> {
                    public final void m1253a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        SectionsModel sectionsModel = (SectionsModel) obj;
                        if (sectionsModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(sectionsModel.m1267a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            sectionsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        SectionsParser.m1313b(sectionsModel.w_(), sectionsModel.u_(), jsonGenerator, serializerProvider);
                    }

                    static {
                        FbSerializerProvider.a(SectionsModel.class, new Serializer());
                    }
                }

                @JsonDeserialize(using = Deserializer.class)
                @ModelWithFlatBufferFormatHash(a = -1352864475)
                @JsonSerialize(using = Serializer.class)
                @FragmentModelWithoutBridge
                /* compiled from: udp_parcel_key */
                public final class SubtitleModel extends BaseModel implements GraphQLVisitableModel {
                    @Nullable
                    private String f1177d;

                    /* compiled from: udp_parcel_key */
                    public class Deserializer extends FbJsonDeserializer {
                        static {
                            GlobalAutoGenDeserializerCache.a(SubtitleModel.class, new Deserializer());
                        }

                        public Object m1254a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(SubtitleParser.m1307a(jsonParser, flatBufferBuilder));
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

                    /* compiled from: udp_parcel_key */
                    public class Serializer extends JsonSerializer<SubtitleModel> {
                        public final void m1255a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                            SubtitleModel subtitleModel = (SubtitleModel) obj;
                            if (subtitleModel.w_() == null) {
                                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                flatBufferBuilder.d(subtitleModel.m1257a(flatBufferBuilder));
                                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                wrap.position(0);
                                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                subtitleModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                            }
                            SubtitleParser.m1308a(subtitleModel.w_(), subtitleModel.u_(), jsonGenerator);
                        }

                        static {
                            FbSerializerProvider.a(SubtitleModel.class, new Serializer());
                        }
                    }

                    public SubtitleModel() {
                        super(1);
                    }

                    @Nullable
                    private String m1256a() {
                        this.f1177d = super.a(this.f1177d, 0);
                        return this.f1177d;
                    }

                    public final int jK_() {
                        return -1919764332;
                    }

                    public final GraphQLVisitableModel m1258a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                        h();
                        i();
                        return this;
                    }

                    public final int m1257a(FlatBufferBuilder flatBufferBuilder) {
                        h();
                        int b = flatBufferBuilder.b(m1256a());
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
                /* compiled from: udp_parcel_key */
                public final class TitleModel extends BaseModel implements GraphQLVisitableModel {
                    @Nullable
                    private String f1178d;

                    /* compiled from: udp_parcel_key */
                    public class Deserializer extends FbJsonDeserializer {
                        static {
                            GlobalAutoGenDeserializerCache.a(TitleModel.class, new Deserializer());
                        }

                        public Object m1259a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(TitleParser.m1309a(jsonParser, flatBufferBuilder));
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

                    /* compiled from: udp_parcel_key */
                    public class Serializer extends JsonSerializer<TitleModel> {
                        public final void m1260a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                            TitleModel titleModel = (TitleModel) obj;
                            if (titleModel.w_() == null) {
                                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                flatBufferBuilder.d(titleModel.m1262a(flatBufferBuilder));
                                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                wrap.position(0);
                                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                titleModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                            }
                            TitleParser.m1310a(titleModel.w_(), titleModel.u_(), jsonGenerator);
                        }

                        static {
                            FbSerializerProvider.a(TitleModel.class, new Serializer());
                        }
                    }

                    public TitleModel() {
                        super(1);
                    }

                    @Nullable
                    private String m1261a() {
                        this.f1178d = super.a(this.f1178d, 0);
                        return this.f1178d;
                    }

                    public final int jK_() {
                        return -1919764332;
                    }

                    public final GraphQLVisitableModel m1263a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                        h();
                        i();
                        return this;
                    }

                    public final int m1262a(FlatBufferBuilder flatBufferBuilder) {
                        h();
                        int b = flatBufferBuilder.b(m1261a());
                        flatBufferBuilder.c(1);
                        flatBufferBuilder.b(0, b);
                        i();
                        return flatBufferBuilder.d();
                    }
                }

                public SectionsModel() {
                    super(3);
                }

                @Nullable
                private String m1264a() {
                    this.f1179d = super.a(this.f1179d, 0);
                    return this.f1179d;
                }

                @Nullable
                private SubtitleModel m1265j() {
                    this.f1180e = (SubtitleModel) super.a(this.f1180e, 1, SubtitleModel.class);
                    return this.f1180e;
                }

                @Nullable
                private TitleModel m1266k() {
                    this.f1181f = (TitleModel) super.a(this.f1181f, 2, TitleModel.class);
                    return this.f1181f;
                }

                public final int jK_() {
                    return 1839999535;
                }

                public final GraphQLVisitableModel m1268a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    GraphQLVisitableModel graphQLVisitableModel = null;
                    h();
                    if (m1265j() != null) {
                        SubtitleModel subtitleModel = (SubtitleModel) graphQLModelMutatingVisitor.b(m1265j());
                        if (m1265j() != subtitleModel) {
                            graphQLVisitableModel = (SectionsModel) ModelHelper.a(null, this);
                            graphQLVisitableModel.f1180e = subtitleModel;
                        }
                    }
                    if (m1266k() != null) {
                        TitleModel titleModel = (TitleModel) graphQLModelMutatingVisitor.b(m1266k());
                        if (m1266k() != titleModel) {
                            graphQLVisitableModel = (SectionsModel) ModelHelper.a(graphQLVisitableModel, this);
                            graphQLVisitableModel.f1181f = titleModel;
                        }
                    }
                    i();
                    return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                }

                public final int m1267a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int b = flatBufferBuilder.b(m1264a());
                    int a = ModelHelper.a(flatBufferBuilder, m1265j());
                    int a2 = ModelHelper.a(flatBufferBuilder, m1266k());
                    flatBufferBuilder.c(3);
                    flatBufferBuilder.b(0, b);
                    flatBufferBuilder.b(1, a);
                    flatBufferBuilder.b(2, a2);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            /* compiled from: udp_parcel_key */
            public class Serializer extends JsonSerializer<TodayOtdStoriesModel> {
                public final void m1269a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    TodayOtdStoriesModel todayOtdStoriesModel = (TodayOtdStoriesModel) obj;
                    if (todayOtdStoriesModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(todayOtdStoriesModel.m1273a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        todayOtdStoriesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    TodayOtdStoriesParser.m1315a(todayOtdStoriesModel.w_(), todayOtdStoriesModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(TodayOtdStoriesModel.class, new Serializer());
                }
            }

            public TodayOtdStoriesModel() {
                super(3);
            }

            @Nonnull
            private ImmutableList<TodayOTDStoryEdgeFragmentModel> m1270a() {
                this.f1182d = super.a(this.f1182d, 0, TodayOTDStoryEdgeFragmentModel.class);
                return (ImmutableList) this.f1182d;
            }

            @Nullable
            private DefaultPageInfoFieldsModel m1271j() {
                this.f1183e = (DefaultPageInfoFieldsModel) super.a(this.f1183e, 1, DefaultPageInfoFieldsModel.class);
                return this.f1183e;
            }

            @Nonnull
            private ImmutableList<SectionsModel> m1272k() {
                this.f1184f = super.a(this.f1184f, 2, SectionsModel.class);
                return (ImmutableList) this.f1184f;
            }

            public final int jK_() {
                return 1843763028;
            }

            public final GraphQLVisitableModel m1274a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                TodayOtdStoriesModel todayOtdStoriesModel;
                GraphQLVisitableModel graphQLVisitableModel;
                DefaultPageInfoFieldsModel defaultPageInfoFieldsModel;
                Builder a;
                h();
                if (m1270a() != null) {
                    Builder a2 = ModelHelper.a(m1270a(), graphQLModelMutatingVisitor);
                    if (a2 != null) {
                        todayOtdStoriesModel = (TodayOtdStoriesModel) ModelHelper.a(null, this);
                        todayOtdStoriesModel.f1182d = a2.b();
                        graphQLVisitableModel = todayOtdStoriesModel;
                        if (m1271j() != null) {
                            defaultPageInfoFieldsModel = (DefaultPageInfoFieldsModel) graphQLModelMutatingVisitor.b(m1271j());
                            if (m1271j() != defaultPageInfoFieldsModel) {
                                graphQLVisitableModel = (TodayOtdStoriesModel) ModelHelper.a(graphQLVisitableModel, this);
                                graphQLVisitableModel.f1183e = defaultPageInfoFieldsModel;
                            }
                        }
                        if (m1272k() != null) {
                            a = ModelHelper.a(m1272k(), graphQLModelMutatingVisitor);
                            if (a != null) {
                                todayOtdStoriesModel = (TodayOtdStoriesModel) ModelHelper.a(graphQLVisitableModel, this);
                                todayOtdStoriesModel.f1184f = a.b();
                                graphQLVisitableModel = todayOtdStoriesModel;
                            }
                        }
                        i();
                        return graphQLVisitableModel != null ? this : graphQLVisitableModel;
                    }
                }
                graphQLVisitableModel = null;
                if (m1271j() != null) {
                    defaultPageInfoFieldsModel = (DefaultPageInfoFieldsModel) graphQLModelMutatingVisitor.b(m1271j());
                    if (m1271j() != defaultPageInfoFieldsModel) {
                        graphQLVisitableModel = (TodayOtdStoriesModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f1183e = defaultPageInfoFieldsModel;
                    }
                }
                if (m1272k() != null) {
                    a = ModelHelper.a(m1272k(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        todayOtdStoriesModel = (TodayOtdStoriesModel) ModelHelper.a(graphQLVisitableModel, this);
                        todayOtdStoriesModel.f1184f = a.b();
                        graphQLVisitableModel = todayOtdStoriesModel;
                    }
                }
                i();
                if (graphQLVisitableModel != null) {
                }
            }

            public final int m1273a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m1270a());
                int a2 = ModelHelper.a(flatBufferBuilder, m1271j());
                int a3 = ModelHelper.a(flatBufferBuilder, m1272k());
                flatBufferBuilder.c(3);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.b(1, a2);
                flatBufferBuilder.b(2, a3);
                i();
                return flatBufferBuilder.d();
            }
        }

        public TodayOTDQueryModel() {
            super(1);
        }

        @Nullable
        private TodayOtdStoriesModel m1275a() {
            this.f1185d = (TodayOtdStoriesModel) super.a(this.f1185d, 0, TodayOtdStoriesModel.class);
            return this.f1185d;
        }

        public final int jK_() {
            return -1732764110;
        }

        public final GraphQLVisitableModel m1277a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m1275a() != null) {
                TodayOtdStoriesModel todayOtdStoriesModel = (TodayOtdStoriesModel) graphQLModelMutatingVisitor.b(m1275a());
                if (m1275a() != todayOtdStoriesModel) {
                    graphQLVisitableModel = (TodayOTDQueryModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f1185d = todayOtdStoriesModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m1276a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m1275a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }

    @FragmentModelWithBridge
    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -1366927098)
    @JsonSerialize(using = Serializer.class)
    /* compiled from: udp_parcel_key */
    public final class TodayOTDStoryEdgeFragmentModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private GraphQLStory f1186d;
        @Nullable
        private String f1187e;

        /* compiled from: udp_parcel_key */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(TodayOTDStoryEdgeFragmentModel.class, new Deserializer());
            }

            public Object m1278a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(TodayOTDStoryEdgeFragmentParser.m1317b(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object todayOTDStoryEdgeFragmentModel = new TodayOTDStoryEdgeFragmentModel();
                ((BaseModel) todayOTDStoryEdgeFragmentModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (todayOTDStoryEdgeFragmentModel instanceof Postprocessable) {
                    return ((Postprocessable) todayOTDStoryEdgeFragmentModel).a();
                }
                return todayOTDStoryEdgeFragmentModel;
            }
        }

        /* compiled from: udp_parcel_key */
        public class Serializer extends JsonSerializer<TodayOTDStoryEdgeFragmentModel> {
            public final void m1279a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                TodayOTDStoryEdgeFragmentModel todayOTDStoryEdgeFragmentModel = (TodayOTDStoryEdgeFragmentModel) obj;
                if (todayOTDStoryEdgeFragmentModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(todayOTDStoryEdgeFragmentModel.m1282a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    todayOTDStoryEdgeFragmentModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                TodayOTDStoryEdgeFragmentParser.m1318b(todayOTDStoryEdgeFragmentModel.w_(), todayOTDStoryEdgeFragmentModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(TodayOTDStoryEdgeFragmentModel.class, new Serializer());
            }
        }

        public TodayOTDStoryEdgeFragmentModel() {
            super(2);
        }

        @Nullable
        private GraphQLStory m1280a() {
            this.f1186d = (GraphQLStory) super.a(this.f1186d, 0, GraphQLStory.class);
            return this.f1186d;
        }

        @Nullable
        private String m1281j() {
            this.f1187e = super.a(this.f1187e, 1);
            return this.f1187e;
        }

        public final int jK_() {
            return 793876147;
        }

        public final GraphQLVisitableModel m1283a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m1280a() != null) {
                GraphQLStory graphQLStory = (GraphQLStory) graphQLModelMutatingVisitor.b(m1280a());
                if (m1280a() != graphQLStory) {
                    graphQLVisitableModel = (TodayOTDStoryEdgeFragmentModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f1186d = graphQLStory;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m1282a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m1280a());
            int b = flatBufferBuilder.b(m1281j());
            flatBufferBuilder.c(2);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, b);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 297681369)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: udp_parcel_key */
    public final class TodayUnitSettingsQueryModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private List<TodayUnitSettingsModel> f1193d;

        /* compiled from: udp_parcel_key */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(TodayUnitSettingsQueryModel.class, new Deserializer());
            }

            public Object m1284a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(TodayUnitSettingsQueryParser.m1321a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object todayUnitSettingsQueryModel = new TodayUnitSettingsQueryModel();
                ((BaseModel) todayUnitSettingsQueryModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (todayUnitSettingsQueryModel instanceof Postprocessable) {
                    return ((Postprocessable) todayUnitSettingsQueryModel).a();
                }
                return todayUnitSettingsQueryModel;
            }
        }

        /* compiled from: udp_parcel_key */
        public class Serializer extends JsonSerializer<TodayUnitSettingsQueryModel> {
            public final void m1285a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                TodayUnitSettingsQueryModel todayUnitSettingsQueryModel = (TodayUnitSettingsQueryModel) obj;
                if (todayUnitSettingsQueryModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(todayUnitSettingsQueryModel.m1296a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    todayUnitSettingsQueryModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = todayUnitSettingsQueryModel.w_();
                int u_ = todayUnitSettingsQueryModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("today_unit_settings");
                    jsonGenerator.d();
                    for (int i = 0; i < mutableFlatBuffer.c(g); i++) {
                        TodayUnitSettingsParser.m1320b(mutableFlatBuffer, mutableFlatBuffer.m(g, i), jsonGenerator, serializerProvider);
                    }
                    jsonGenerator.e();
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(TodayUnitSettingsQueryModel.class, new Serializer());
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 772890496)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: udp_parcel_key */
        public final class TodayUnitSettingsModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private ReactionImageFieldsModel f1188d;
            @Nullable
            private DefaultTextWithEntitiesFieldsModel f1189e;
            @Nullable
            private String f1190f;
            @Nullable
            private DefaultTextWithEntitiesFieldsModel f1191g;
            @Nullable
            private ReactionImageFieldsModel f1192h;

            /* compiled from: udp_parcel_key */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(TodayUnitSettingsModel.class, new Deserializer());
                }

                public Object m1286a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(TodayUnitSettingsParser.m1319b(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object todayUnitSettingsModel = new TodayUnitSettingsModel();
                    ((BaseModel) todayUnitSettingsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (todayUnitSettingsModel instanceof Postprocessable) {
                        return ((Postprocessable) todayUnitSettingsModel).a();
                    }
                    return todayUnitSettingsModel;
                }
            }

            /* compiled from: udp_parcel_key */
            public class Serializer extends JsonSerializer<TodayUnitSettingsModel> {
                public final void m1287a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    TodayUnitSettingsModel todayUnitSettingsModel = (TodayUnitSettingsModel) obj;
                    if (todayUnitSettingsModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(todayUnitSettingsModel.m1293a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        todayUnitSettingsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    TodayUnitSettingsParser.m1320b(todayUnitSettingsModel.w_(), todayUnitSettingsModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(TodayUnitSettingsModel.class, new Serializer());
                }
            }

            public TodayUnitSettingsModel() {
                super(5);
            }

            @Nullable
            private ReactionImageFieldsModel m1288a() {
                this.f1188d = (ReactionImageFieldsModel) super.a(this.f1188d, 0, ReactionImageFieldsModel.class);
                return this.f1188d;
            }

            @Nullable
            private DefaultTextWithEntitiesFieldsModel m1289j() {
                this.f1189e = (DefaultTextWithEntitiesFieldsModel) super.a(this.f1189e, 1, DefaultTextWithEntitiesFieldsModel.class);
                return this.f1189e;
            }

            @Nullable
            private String m1290k() {
                this.f1190f = super.a(this.f1190f, 2);
                return this.f1190f;
            }

            @Nullable
            private DefaultTextWithEntitiesFieldsModel m1291l() {
                this.f1191g = (DefaultTextWithEntitiesFieldsModel) super.a(this.f1191g, 3, DefaultTextWithEntitiesFieldsModel.class);
                return this.f1191g;
            }

            @Nullable
            private ReactionImageFieldsModel m1292m() {
                this.f1192h = (ReactionImageFieldsModel) super.a(this.f1192h, 4, ReactionImageFieldsModel.class);
                return this.f1192h;
            }

            public final int jK_() {
                return -2014452989;
            }

            public final GraphQLVisitableModel m1294a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                ReactionImageFieldsModel reactionImageFieldsModel;
                DefaultTextWithEntitiesFieldsModel defaultTextWithEntitiesFieldsModel;
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m1288a() != null) {
                    reactionImageFieldsModel = (ReactionImageFieldsModel) graphQLModelMutatingVisitor.b(m1288a());
                    if (m1288a() != reactionImageFieldsModel) {
                        graphQLVisitableModel = (TodayUnitSettingsModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f1188d = reactionImageFieldsModel;
                    }
                }
                if (m1289j() != null) {
                    defaultTextWithEntitiesFieldsModel = (DefaultTextWithEntitiesFieldsModel) graphQLModelMutatingVisitor.b(m1289j());
                    if (m1289j() != defaultTextWithEntitiesFieldsModel) {
                        graphQLVisitableModel = (TodayUnitSettingsModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f1189e = defaultTextWithEntitiesFieldsModel;
                    }
                }
                if (m1291l() != null) {
                    defaultTextWithEntitiesFieldsModel = (DefaultTextWithEntitiesFieldsModel) graphQLModelMutatingVisitor.b(m1291l());
                    if (m1291l() != defaultTextWithEntitiesFieldsModel) {
                        graphQLVisitableModel = (TodayUnitSettingsModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f1191g = defaultTextWithEntitiesFieldsModel;
                    }
                }
                if (m1292m() != null) {
                    reactionImageFieldsModel = (ReactionImageFieldsModel) graphQLModelMutatingVisitor.b(m1292m());
                    if (m1292m() != reactionImageFieldsModel) {
                        graphQLVisitableModel = (TodayUnitSettingsModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f1192h = reactionImageFieldsModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m1293a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m1288a());
                int a2 = ModelHelper.a(flatBufferBuilder, m1289j());
                int b = flatBufferBuilder.b(m1290k());
                int a3 = ModelHelper.a(flatBufferBuilder, m1291l());
                int a4 = ModelHelper.a(flatBufferBuilder, m1292m());
                flatBufferBuilder.c(5);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.b(1, a2);
                flatBufferBuilder.b(2, b);
                flatBufferBuilder.b(3, a3);
                flatBufferBuilder.b(4, a4);
                i();
                return flatBufferBuilder.d();
            }
        }

        public TodayUnitSettingsQueryModel() {
            super(1);
        }

        @Nonnull
        private ImmutableList<TodayUnitSettingsModel> m1295a() {
            this.f1193d = super.a(this.f1193d, 0, TodayUnitSettingsModel.class);
            return (ImmutableList) this.f1193d;
        }

        public final int jK_() {
            return -1732764110;
        }

        public final GraphQLVisitableModel m1297a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m1295a() != null) {
                Builder a = ModelHelper.a(m1295a(), graphQLModelMutatingVisitor);
                if (a != null) {
                    graphQLVisitableModel = (TodayUnitSettingsQueryModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f1193d = a.b();
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m1296a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m1295a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }
}
