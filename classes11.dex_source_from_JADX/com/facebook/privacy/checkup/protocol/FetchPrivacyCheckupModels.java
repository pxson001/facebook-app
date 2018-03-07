package com.facebook.privacy.checkup.protocol;

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
import com.facebook.graphql.enums.GraphQLEditablePrivacyScopeType;
import com.facebook.graphql.enums.GraphQLPrivacyCheckupActionType;
import com.facebook.graphql.enums.GraphQLPrivacyCheckupSectionType;
import com.facebook.graphql.enums.GraphQLPrivacyReviewCoreSectionType;
import com.facebook.graphql.model.GraphQLPrivacyOptionsContentEdge;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.querybuilder.common.CommonGraphQL2Interfaces.DefaultPageInfoFields;
import com.facebook.graphql.querybuilder.common.CommonGraphQL2Models.DefaultPageInfoFieldsModel;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.facebook.privacy.checkup.protocol.FetchPrivacyCheckupInterfaces.PrivacyCheckupItemsFragment;
import com.facebook.privacy.checkup.protocol.FetchPrivacyCheckupInterfaces.PrivacyReviewCoreItemsFragment;
import com.facebook.privacy.checkup.protocol.FetchPrivacyCheckupParsers.FetchGenericPrivacyReviewQueryParser;
import com.facebook.privacy.checkup.protocol.FetchPrivacyCheckupParsers.FetchGenericPrivacyReviewQueryParser.PrivacyReviewExperiencesParser;
import com.facebook.privacy.checkup.protocol.FetchPrivacyCheckupParsers.FetchGenericPrivacyReviewQueryParser.PrivacyReviewExperiencesParser.ReviewStepsParser;
import com.facebook.privacy.checkup.protocol.FetchPrivacyCheckupParsers.FetchGenericPrivacyReviewQueryParser.PrivacyReviewExperiencesParser.ReviewStepsParser.NodesParser;
import com.facebook.privacy.checkup.protocol.FetchPrivacyCheckupParsers.FetchGenericPrivacyReviewQueryParser.PrivacyReviewExperiencesParser.ReviewStepsParser.NodesParser.ReviewSectionsParser;
import com.facebook.privacy.checkup.protocol.FetchPrivacyCheckupParsers.FetchPrivacyCheckupAppsStepQueryParser;
import com.facebook.privacy.checkup.protocol.FetchPrivacyCheckupParsers.FetchPrivacyCheckupAppsStepQueryParser.AudienceInfoParser;
import com.facebook.privacy.checkup.protocol.FetchPrivacyCheckupParsers.FetchPrivacyCheckupAppsStepQueryParser.AudienceInfoParser.PrivacyCheckupInfoParser;
import com.facebook.privacy.checkup.protocol.FetchPrivacyCheckupParsers.FetchPrivacyCheckupAppsStepQueryParser.AudienceInfoParser.PrivacyCheckupInfoParser.AppReviewParser;
import com.facebook.privacy.checkup.protocol.FetchPrivacyCheckupParsers.FetchPrivacyCheckupAppsStepQueryParser.AudienceInfoParser.PrivacyCheckupInfoParser.AppReviewParser.CheckupItemsParser;
import com.facebook.privacy.checkup.protocol.FetchPrivacyCheckupParsers.FetchPrivacyCheckupComposerStepQueryParser;
import com.facebook.privacy.checkup.protocol.FetchPrivacyCheckupParsers.FetchPrivacyCheckupComposerStepQueryParser.AudienceInfoParser.PrivacyCheckupInfoParser.ComposerReviewParser;
import com.facebook.privacy.checkup.protocol.FetchPrivacyCheckupParsers.FetchPrivacyCheckupProfileStepQueryParser;
import com.facebook.privacy.checkup.protocol.FetchPrivacyCheckupParsers.FetchPrivacyCheckupProfileStepQueryParser.AudienceInfoParser.PrivacyCheckupInfoParser.ProfileReviewParser;
import com.facebook.privacy.checkup.protocol.FetchPrivacyCheckupParsers.PrivacyCheckupItemPrivacyScopeFragmentParser;
import com.facebook.privacy.checkup.protocol.FetchPrivacyCheckupParsers.PrivacyCheckupItemPrivacyScopeFragmentParser.IconImageParser;
import com.facebook.privacy.checkup.protocol.FetchPrivacyCheckupParsers.PrivacyCheckupItemPrivacyScopeFragmentParser.PrivacyOptionsParser;
import com.facebook.privacy.checkup.protocol.FetchPrivacyCheckupParsers.PrivacyCheckupItemsFragmentParser;
import com.facebook.privacy.checkup.protocol.FetchPrivacyCheckupParsers.PrivacyCheckupSectionDataFragmentParser;
import com.facebook.privacy.checkup.protocol.FetchPrivacyCheckupParsers.PrivacyCheckupSectionHeaderFragmentParser;
import com.facebook.privacy.checkup.protocol.FetchPrivacyCheckupParsers.PrivacyCheckupSectionInfoFragmentParser;
import com.facebook.privacy.checkup.protocol.FetchPrivacyCheckupParsers.PrivacyReviewCoreItemsFragmentParser;
import com.facebook.privacy.checkup.protocol.FetchPrivacyCheckupParsers.PrivacyReviewCoreSectionDataFragmentParser;
import com.facebook.privacy.checkup.protocol.FetchPrivacyCheckupParsers.PrivacyReviewCoreSectionHeaderFragmentParser;
import com.facebook.privacy.checkup.protocol.FetchPrivacyCheckupParsers.PrivacyReviewNavigationInfoFragmentParser;
import com.facebook.privacy.checkup.protocol.FetchPrivacyCheckupParsers.PrivacyScopeForEditFragmentParser;
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

/* compiled from: page/{#%s}/album_list */
public class FetchPrivacyCheckupModels {

    @FragmentModelWithBridge
    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -696586712)
    @JsonSerialize(using = Serializer.class)
    /* compiled from: page/{#%s}/album_list */
    public final class FetchGenericPrivacyReviewQueryModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private PrivacyReviewExperiencesModel f4494d;

        /* compiled from: page/{#%s}/album_list */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(FetchGenericPrivacyReviewQueryModel.class, new Deserializer());
            }

            public Object m5526a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = FetchGenericPrivacyReviewQueryParser.m5751a(jsonParser);
                Object fetchGenericPrivacyReviewQueryModel = new FetchGenericPrivacyReviewQueryModel();
                ((BaseModel) fetchGenericPrivacyReviewQueryModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (fetchGenericPrivacyReviewQueryModel instanceof Postprocessable) {
                    return ((Postprocessable) fetchGenericPrivacyReviewQueryModel).a();
                }
                return fetchGenericPrivacyReviewQueryModel;
            }
        }

        @FragmentModelWithBridge
        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 803511045)
        @JsonSerialize(using = Serializer.class)
        /* compiled from: page/{#%s}/album_list */
        public final class PrivacyReviewExperiencesModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private ReviewStepsModel f4493d;

            /* compiled from: page/{#%s}/album_list */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(PrivacyReviewExperiencesModel.class, new Deserializer());
                }

                public Object m5527a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(PrivacyReviewExperiencesParser.m5749a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object privacyReviewExperiencesModel = new PrivacyReviewExperiencesModel();
                    ((BaseModel) privacyReviewExperiencesModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (privacyReviewExperiencesModel instanceof Postprocessable) {
                        return ((Postprocessable) privacyReviewExperiencesModel).a();
                    }
                    return privacyReviewExperiencesModel;
                }
            }

            @FragmentModelWithBridge
            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = 1500016385)
            @JsonSerialize(using = Serializer.class)
            /* compiled from: page/{#%s}/album_list */
            public final class ReviewStepsModel extends BaseModel implements GraphQLVisitableModel {
                @Nullable
                private List<NodesModel> f4492d;

                /* compiled from: page/{#%s}/album_list */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(ReviewStepsModel.class, new Deserializer());
                    }

                    public Object m5528a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(ReviewStepsParser.m5747a(jsonParser, flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                        Object reviewStepsModel = new ReviewStepsModel();
                        ((BaseModel) reviewStepsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                        if (reviewStepsModel instanceof Postprocessable) {
                            return ((Postprocessable) reviewStepsModel).a();
                        }
                        return reviewStepsModel;
                    }
                }

                @FragmentModelWithBridge
                @JsonDeserialize(using = Deserializer.class)
                @ModelWithFlatBufferFormatHash(a = 621997481)
                @JsonSerialize(using = Serializer.class)
                /* compiled from: page/{#%s}/album_list */
                public final class NodesModel extends BaseModel implements GraphQLVisitableModel {
                    @Nullable
                    private PrivacyReviewNavigationInfoFragmentModel f4482d;
                    @Nullable
                    private ReviewSectionsModel f4483e;
                    @Nullable
                    private String f4484f;
                    @Nullable
                    private String f4485g;
                    @Nullable
                    private List<String> f4486h;
                    @Nullable
                    private String f4487i;
                    @Nullable
                    private String f4488j;
                    @Nullable
                    private String f4489k;
                    @Nullable
                    private String f4490l;
                    @Nullable
                    private String f4491m;

                    /* compiled from: page/{#%s}/album_list */
                    public class Deserializer extends FbJsonDeserializer {
                        static {
                            GlobalAutoGenDeserializerCache.a(NodesModel.class, new Deserializer());
                        }

                        public Object m5529a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(NodesParser.m5745b(jsonParser, flatBufferBuilder));
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

                    @FragmentModelWithBridge
                    @JsonDeserialize(using = Deserializer.class)
                    @ModelWithFlatBufferFormatHash(a = -1995990001)
                    @JsonSerialize(using = Serializer.class)
                    /* compiled from: page/{#%s}/album_list */
                    public final class ReviewSectionsModel extends BaseModel implements GraphQLVisitableModel, PrivacyReviewCoreItemsFragment {
                        @Nullable
                        private List<NodesModel> f4480d;
                        @Nullable
                        private DefaultPageInfoFieldsModel f4481e;

                        /* compiled from: page/{#%s}/album_list */
                        public class Deserializer extends FbJsonDeserializer {
                            static {
                                GlobalAutoGenDeserializerCache.a(ReviewSectionsModel.class, new Deserializer());
                            }

                            public Object m5530a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                flatBufferBuilder.d(ReviewSectionsParser.m5743a(jsonParser, flatBufferBuilder));
                                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                wrap.position(0);
                                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                                Object reviewSectionsModel = new ReviewSectionsModel();
                                ((BaseModel) reviewSectionsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                                if (reviewSectionsModel instanceof Postprocessable) {
                                    return ((Postprocessable) reviewSectionsModel).a();
                                }
                                return reviewSectionsModel;
                            }
                        }

                        /* compiled from: page/{#%s}/album_list */
                        public class Serializer extends JsonSerializer<ReviewSectionsModel> {
                            public final void m5531a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                                ReviewSectionsModel reviewSectionsModel = (ReviewSectionsModel) obj;
                                if (reviewSectionsModel.w_() == null) {
                                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                    flatBufferBuilder.d(reviewSectionsModel.m5532a(flatBufferBuilder));
                                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                    wrap.position(0);
                                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                    reviewSectionsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                                }
                                ReviewSectionsParser.m5744a(reviewSectionsModel.w_(), reviewSectionsModel.u_(), jsonGenerator, serializerProvider);
                            }

                            static {
                                FbSerializerProvider.a(ReviewSectionsModel.class, new Serializer());
                            }
                        }

                        public ReviewSectionsModel() {
                            super(2);
                        }

                        @Nonnull
                        public final ImmutableList<NodesModel> mo112a() {
                            this.f4480d = super.a(this.f4480d, 0, NodesModel.class);
                            return (ImmutableList) this.f4480d;
                        }

                        @Nullable
                        public final DefaultPageInfoFieldsModel m5535j() {
                            this.f4481e = (DefaultPageInfoFieldsModel) super.a(this.f4481e, 1, DefaultPageInfoFieldsModel.class);
                            return this.f4481e;
                        }

                        public final int jK_() {
                            return 643956963;
                        }

                        public final GraphQLVisitableModel m5533a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                            GraphQLVisitableModel graphQLVisitableModel;
                            DefaultPageInfoFieldsModel defaultPageInfoFieldsModel;
                            h();
                            if (mo112a() != null) {
                                Builder a = ModelHelper.a(mo112a(), graphQLModelMutatingVisitor);
                                if (a != null) {
                                    ReviewSectionsModel reviewSectionsModel = (ReviewSectionsModel) ModelHelper.a(null, this);
                                    reviewSectionsModel.f4480d = a.b();
                                    graphQLVisitableModel = reviewSectionsModel;
                                    if (m5535j() != null) {
                                        defaultPageInfoFieldsModel = (DefaultPageInfoFieldsModel) graphQLModelMutatingVisitor.b(m5535j());
                                        if (m5535j() != defaultPageInfoFieldsModel) {
                                            graphQLVisitableModel = (ReviewSectionsModel) ModelHelper.a(graphQLVisitableModel, this);
                                            graphQLVisitableModel.f4481e = defaultPageInfoFieldsModel;
                                        }
                                    }
                                    i();
                                    return graphQLVisitableModel != null ? this : graphQLVisitableModel;
                                }
                            }
                            graphQLVisitableModel = null;
                            if (m5535j() != null) {
                                defaultPageInfoFieldsModel = (DefaultPageInfoFieldsModel) graphQLModelMutatingVisitor.b(m5535j());
                                if (m5535j() != defaultPageInfoFieldsModel) {
                                    graphQLVisitableModel = (ReviewSectionsModel) ModelHelper.a(graphQLVisitableModel, this);
                                    graphQLVisitableModel.f4481e = defaultPageInfoFieldsModel;
                                }
                            }
                            i();
                            if (graphQLVisitableModel != null) {
                            }
                        }

                        public final int m5532a(FlatBufferBuilder flatBufferBuilder) {
                            h();
                            int a = ModelHelper.a(flatBufferBuilder, mo112a());
                            int a2 = ModelHelper.a(flatBufferBuilder, m5535j());
                            flatBufferBuilder.c(2);
                            flatBufferBuilder.b(0, a);
                            flatBufferBuilder.b(1, a2);
                            i();
                            return flatBufferBuilder.d();
                        }
                    }

                    /* compiled from: page/{#%s}/album_list */
                    public class Serializer extends JsonSerializer<NodesModel> {
                        public final void m5536a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                            NodesModel nodesModel = (NodesModel) obj;
                            if (nodesModel.w_() == null) {
                                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                flatBufferBuilder.d(nodesModel.m5537a(flatBufferBuilder));
                                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                wrap.position(0);
                                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                nodesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                            }
                            NodesParser.m5746b(nodesModel.w_(), nodesModel.u_(), jsonGenerator, serializerProvider);
                        }

                        static {
                            FbSerializerProvider.a(NodesModel.class, new Serializer());
                        }
                    }

                    public NodesModel() {
                        super(10);
                    }

                    @Nullable
                    public final PrivacyReviewNavigationInfoFragmentModel m5539a() {
                        this.f4482d = (PrivacyReviewNavigationInfoFragmentModel) super.a(this.f4482d, 0, PrivacyReviewNavigationInfoFragmentModel.class);
                        return this.f4482d;
                    }

                    @Nullable
                    public final ReviewSectionsModel m5540j() {
                        this.f4483e = (ReviewSectionsModel) super.a(this.f4483e, 1, ReviewSectionsModel.class);
                        return this.f4483e;
                    }

                    @Nullable
                    public final String m5541k() {
                        this.f4484f = super.a(this.f4484f, 2);
                        return this.f4484f;
                    }

                    @Nullable
                    public final String m5542l() {
                        this.f4485g = super.a(this.f4485g, 3);
                        return this.f4485g;
                    }

                    @Nonnull
                    public final ImmutableList<String> m5543m() {
                        this.f4486h = super.a(this.f4486h, 4);
                        return (ImmutableList) this.f4486h;
                    }

                    @Nullable
                    public final String m5544n() {
                        this.f4487i = super.a(this.f4487i, 5);
                        return this.f4487i;
                    }

                    @Nullable
                    public final String m5545o() {
                        this.f4488j = super.a(this.f4488j, 6);
                        return this.f4488j;
                    }

                    @Nullable
                    public final String m5546p() {
                        this.f4489k = super.a(this.f4489k, 7);
                        return this.f4489k;
                    }

                    @Nullable
                    public final String m5547q() {
                        this.f4490l = super.a(this.f4490l, 8);
                        return this.f4490l;
                    }

                    @Nullable
                    public final String m5548r() {
                        this.f4491m = super.a(this.f4491m, 9);
                        return this.f4491m;
                    }

                    public final int jK_() {
                        return -1783613429;
                    }

                    public final GraphQLVisitableModel m5538a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                        GraphQLVisitableModel graphQLVisitableModel = null;
                        h();
                        if (m5539a() != null) {
                            PrivacyReviewNavigationInfoFragmentModel privacyReviewNavigationInfoFragmentModel = (PrivacyReviewNavigationInfoFragmentModel) graphQLModelMutatingVisitor.b(m5539a());
                            if (m5539a() != privacyReviewNavigationInfoFragmentModel) {
                                graphQLVisitableModel = (NodesModel) ModelHelper.a(null, this);
                                graphQLVisitableModel.f4482d = privacyReviewNavigationInfoFragmentModel;
                            }
                        }
                        if (m5540j() != null) {
                            ReviewSectionsModel reviewSectionsModel = (ReviewSectionsModel) graphQLModelMutatingVisitor.b(m5540j());
                            if (m5540j() != reviewSectionsModel) {
                                graphQLVisitableModel = (NodesModel) ModelHelper.a(graphQLVisitableModel, this);
                                graphQLVisitableModel.f4483e = reviewSectionsModel;
                            }
                        }
                        i();
                        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                    }

                    public final int m5537a(FlatBufferBuilder flatBufferBuilder) {
                        h();
                        int a = ModelHelper.a(flatBufferBuilder, m5539a());
                        int a2 = ModelHelper.a(flatBufferBuilder, m5540j());
                        int b = flatBufferBuilder.b(m5541k());
                        int b2 = flatBufferBuilder.b(m5542l());
                        int c = flatBufferBuilder.c(m5543m());
                        int b3 = flatBufferBuilder.b(m5544n());
                        int b4 = flatBufferBuilder.b(m5545o());
                        int b5 = flatBufferBuilder.b(m5546p());
                        int b6 = flatBufferBuilder.b(m5547q());
                        int b7 = flatBufferBuilder.b(m5548r());
                        flatBufferBuilder.c(10);
                        flatBufferBuilder.b(0, a);
                        flatBufferBuilder.b(1, a2);
                        flatBufferBuilder.b(2, b);
                        flatBufferBuilder.b(3, b2);
                        flatBufferBuilder.b(4, c);
                        flatBufferBuilder.b(5, b3);
                        flatBufferBuilder.b(6, b4);
                        flatBufferBuilder.b(7, b5);
                        flatBufferBuilder.b(8, b6);
                        flatBufferBuilder.b(9, b7);
                        i();
                        return flatBufferBuilder.d();
                    }
                }

                /* compiled from: page/{#%s}/album_list */
                public class Serializer extends JsonSerializer<ReviewStepsModel> {
                    public final void m5549a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        ReviewStepsModel reviewStepsModel = (ReviewStepsModel) obj;
                        if (reviewStepsModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(reviewStepsModel.m5550a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            reviewStepsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        ReviewStepsParser.m5748a(reviewStepsModel.w_(), reviewStepsModel.u_(), jsonGenerator, serializerProvider);
                    }

                    static {
                        FbSerializerProvider.a(ReviewStepsModel.class, new Serializer());
                    }
                }

                public ReviewStepsModel() {
                    super(1);
                }

                @Nonnull
                public final ImmutableList<NodesModel> m5552a() {
                    this.f4492d = super.a(this.f4492d, 0, NodesModel.class);
                    return (ImmutableList) this.f4492d;
                }

                public final int jK_() {
                    return 1483836102;
                }

                public final GraphQLVisitableModel m5551a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    GraphQLVisitableModel graphQLVisitableModel = null;
                    h();
                    if (m5552a() != null) {
                        Builder a = ModelHelper.a(m5552a(), graphQLModelMutatingVisitor);
                        if (a != null) {
                            graphQLVisitableModel = (ReviewStepsModel) ModelHelper.a(null, this);
                            graphQLVisitableModel.f4492d = a.b();
                        }
                    }
                    i();
                    return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                }

                public final int m5550a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int a = ModelHelper.a(flatBufferBuilder, m5552a());
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.b(0, a);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            /* compiled from: page/{#%s}/album_list */
            public class Serializer extends JsonSerializer<PrivacyReviewExperiencesModel> {
                public final void m5553a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    PrivacyReviewExperiencesModel privacyReviewExperiencesModel = (PrivacyReviewExperiencesModel) obj;
                    if (privacyReviewExperiencesModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(privacyReviewExperiencesModel.m5554a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        privacyReviewExperiencesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    PrivacyReviewExperiencesParser.m5750a(privacyReviewExperiencesModel.w_(), privacyReviewExperiencesModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(PrivacyReviewExperiencesModel.class, new Serializer());
                }
            }

            public PrivacyReviewExperiencesModel() {
                super(1);
            }

            @Nullable
            public final ReviewStepsModel m5556a() {
                this.f4493d = (ReviewStepsModel) super.a(this.f4493d, 0, ReviewStepsModel.class);
                return this.f4493d;
            }

            public final int jK_() {
                return 1585063071;
            }

            public final GraphQLVisitableModel m5555a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m5556a() != null) {
                    ReviewStepsModel reviewStepsModel = (ReviewStepsModel) graphQLModelMutatingVisitor.b(m5556a());
                    if (m5556a() != reviewStepsModel) {
                        graphQLVisitableModel = (PrivacyReviewExperiencesModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f4493d = reviewStepsModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m5554a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m5556a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, a);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: page/{#%s}/album_list */
        public class Serializer extends JsonSerializer<FetchGenericPrivacyReviewQueryModel> {
            public final void m5557a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                FetchGenericPrivacyReviewQueryModel fetchGenericPrivacyReviewQueryModel = (FetchGenericPrivacyReviewQueryModel) obj;
                if (fetchGenericPrivacyReviewQueryModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(fetchGenericPrivacyReviewQueryModel.m5558a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    fetchGenericPrivacyReviewQueryModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = fetchGenericPrivacyReviewQueryModel.w_();
                int u_ = fetchGenericPrivacyReviewQueryModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("privacy_review_experiences");
                    PrivacyReviewExperiencesParser.m5750a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(FetchGenericPrivacyReviewQueryModel.class, new Serializer());
            }
        }

        public FetchGenericPrivacyReviewQueryModel() {
            super(1);
        }

        @Nullable
        public final PrivacyReviewExperiencesModel m5560a() {
            this.f4494d = (PrivacyReviewExperiencesModel) super.a(this.f4494d, 0, PrivacyReviewExperiencesModel.class);
            return this.f4494d;
        }

        public final int jK_() {
            return -1732764110;
        }

        public final GraphQLVisitableModel m5559a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m5560a() != null) {
                PrivacyReviewExperiencesModel privacyReviewExperiencesModel = (PrivacyReviewExperiencesModel) graphQLModelMutatingVisitor.b(m5560a());
                if (m5560a() != privacyReviewExperiencesModel) {
                    graphQLVisitableModel = (FetchGenericPrivacyReviewQueryModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f4494d = privacyReviewExperiencesModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m5558a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m5560a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }

    @FragmentModelWithBridge
    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -2082577044)
    @JsonSerialize(using = Serializer.class)
    /* compiled from: page/{#%s}/album_list */
    public final class FetchPrivacyCheckupAppsStepQueryModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private AudienceInfoModel f4502d;

        @FragmentModelWithBridge
        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1847329557)
        @JsonSerialize(using = Serializer.class)
        /* compiled from: page/{#%s}/album_list */
        public final class AudienceInfoModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private PrivacyCheckupInfoModel f4501d;

            /* compiled from: page/{#%s}/album_list */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(AudienceInfoModel.class, new Deserializer());
                }

                public Object m5561a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(AudienceInfoParser.m5758a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object audienceInfoModel = new AudienceInfoModel();
                    ((BaseModel) audienceInfoModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (audienceInfoModel instanceof Postprocessable) {
                        return ((Postprocessable) audienceInfoModel).a();
                    }
                    return audienceInfoModel;
                }
            }

            @FragmentModelWithBridge
            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = 567303496)
            @JsonSerialize(using = Serializer.class)
            /* compiled from: page/{#%s}/album_list */
            public final class PrivacyCheckupInfoModel extends BaseModel implements GraphQLVisitableModel {
                @Nullable
                private AppReviewModel f4500d;

                @FragmentModelWithBridge
                @JsonDeserialize(using = Deserializer.class)
                @ModelWithFlatBufferFormatHash(a = -2046678224)
                @JsonSerialize(using = Serializer.class)
                /* compiled from: page/{#%s}/album_list */
                public final class AppReviewModel extends BaseModel implements GraphQLVisitableModel {
                    @Nullable
                    private List<GraphQLPrivacyCheckupActionType> f4497d;
                    @Nullable
                    private CheckupItemsModel f4498e;
                    private boolean f4499f;

                    @FragmentModelWithBridge
                    @JsonDeserialize(using = Deserializer.class)
                    @ModelWithFlatBufferFormatHash(a = -1985041600)
                    @JsonSerialize(using = Serializer.class)
                    /* compiled from: page/{#%s}/album_list */
                    public final class CheckupItemsModel extends BaseModel implements GraphQLVisitableModel, PrivacyCheckupItemsFragment {
                        @Nullable
                        private List<NodesModel> f4495d;
                        @Nullable
                        private DefaultPageInfoFieldsModel f4496e;

                        /* compiled from: page/{#%s}/album_list */
                        public class Deserializer extends FbJsonDeserializer {
                            static {
                                GlobalAutoGenDeserializerCache.a(CheckupItemsModel.class, new Deserializer());
                            }

                            public Object m5562a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                flatBufferBuilder.d(CheckupItemsParser.m5752a(jsonParser, flatBufferBuilder));
                                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                wrap.position(0);
                                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                                Object checkupItemsModel = new CheckupItemsModel();
                                ((BaseModel) checkupItemsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                                if (checkupItemsModel instanceof Postprocessable) {
                                    return ((Postprocessable) checkupItemsModel).a();
                                }
                                return checkupItemsModel;
                            }
                        }

                        /* compiled from: page/{#%s}/album_list */
                        public class Serializer extends JsonSerializer<CheckupItemsModel> {
                            public final void m5563a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                                CheckupItemsModel checkupItemsModel = (CheckupItemsModel) obj;
                                if (checkupItemsModel.w_() == null) {
                                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                    flatBufferBuilder.d(checkupItemsModel.m5565a(flatBufferBuilder));
                                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                    wrap.position(0);
                                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                    checkupItemsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                                }
                                CheckupItemsParser.m5753a(checkupItemsModel.w_(), checkupItemsModel.u_(), jsonGenerator, serializerProvider);
                            }

                            static {
                                FbSerializerProvider.a(CheckupItemsModel.class, new Serializer());
                            }
                        }

                        @Nullable
                        public final /* synthetic */ DefaultPageInfoFields m5566a() {
                            return m5564j();
                        }

                        public CheckupItemsModel() {
                            super(2);
                        }

                        @Nonnull
                        public final ImmutableList<NodesModel> mo113b() {
                            this.f4495d = super.a(this.f4495d, 0, NodesModel.class);
                            return (ImmutableList) this.f4495d;
                        }

                        @Nullable
                        private DefaultPageInfoFieldsModel m5564j() {
                            this.f4496e = (DefaultPageInfoFieldsModel) super.a(this.f4496e, 1, DefaultPageInfoFieldsModel.class);
                            return this.f4496e;
                        }

                        public final int jK_() {
                            return 445260876;
                        }

                        public final GraphQLVisitableModel m5567a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                            GraphQLVisitableModel graphQLVisitableModel;
                            DefaultPageInfoFieldsModel defaultPageInfoFieldsModel;
                            h();
                            if (mo113b() != null) {
                                Builder a = ModelHelper.a(mo113b(), graphQLModelMutatingVisitor);
                                if (a != null) {
                                    CheckupItemsModel checkupItemsModel = (CheckupItemsModel) ModelHelper.a(null, this);
                                    checkupItemsModel.f4495d = a.b();
                                    graphQLVisitableModel = checkupItemsModel;
                                    if (m5564j() != null) {
                                        defaultPageInfoFieldsModel = (DefaultPageInfoFieldsModel) graphQLModelMutatingVisitor.b(m5564j());
                                        if (m5564j() != defaultPageInfoFieldsModel) {
                                            graphQLVisitableModel = (CheckupItemsModel) ModelHelper.a(graphQLVisitableModel, this);
                                            graphQLVisitableModel.f4496e = defaultPageInfoFieldsModel;
                                        }
                                    }
                                    i();
                                    return graphQLVisitableModel != null ? this : graphQLVisitableModel;
                                }
                            }
                            graphQLVisitableModel = null;
                            if (m5564j() != null) {
                                defaultPageInfoFieldsModel = (DefaultPageInfoFieldsModel) graphQLModelMutatingVisitor.b(m5564j());
                                if (m5564j() != defaultPageInfoFieldsModel) {
                                    graphQLVisitableModel = (CheckupItemsModel) ModelHelper.a(graphQLVisitableModel, this);
                                    graphQLVisitableModel.f4496e = defaultPageInfoFieldsModel;
                                }
                            }
                            i();
                            if (graphQLVisitableModel != null) {
                            }
                        }

                        public final int m5565a(FlatBufferBuilder flatBufferBuilder) {
                            h();
                            int a = ModelHelper.a(flatBufferBuilder, mo113b());
                            int a2 = ModelHelper.a(flatBufferBuilder, m5564j());
                            flatBufferBuilder.c(2);
                            flatBufferBuilder.b(0, a);
                            flatBufferBuilder.b(1, a2);
                            i();
                            return flatBufferBuilder.d();
                        }
                    }

                    /* compiled from: page/{#%s}/album_list */
                    public class Deserializer extends FbJsonDeserializer {
                        static {
                            GlobalAutoGenDeserializerCache.a(AppReviewModel.class, new Deserializer());
                        }

                        public Object m5569a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(AppReviewParser.m5754a(jsonParser, flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            mutableFlatBuffer.a(4, Boolean.valueOf(true));
                            MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                            Object appReviewModel = new AppReviewModel();
                            ((BaseModel) appReviewModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                            if (appReviewModel instanceof Postprocessable) {
                                return ((Postprocessable) appReviewModel).a();
                            }
                            return appReviewModel;
                        }
                    }

                    /* compiled from: page/{#%s}/album_list */
                    public class Serializer extends JsonSerializer<AppReviewModel> {
                        public final void m5570a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                            AppReviewModel appReviewModel = (AppReviewModel) obj;
                            if (appReviewModel.w_() == null) {
                                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                flatBufferBuilder.d(appReviewModel.m5572a(flatBufferBuilder));
                                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                wrap.position(0);
                                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                appReviewModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                            }
                            AppReviewParser.m5755a(appReviewModel.w_(), appReviewModel.u_(), jsonGenerator, serializerProvider);
                        }

                        static {
                            FbSerializerProvider.a(AppReviewModel.class, new Serializer());
                        }
                    }

                    @Nullable
                    public final /* synthetic */ CheckupItemsModel m5576b() {
                        return m5571j();
                    }

                    public AppReviewModel() {
                        super(3);
                    }

                    @Nonnull
                    public final ImmutableList<GraphQLPrivacyCheckupActionType> m5574a() {
                        this.f4497d = super.c(this.f4497d, 0, GraphQLPrivacyCheckupActionType.class);
                        return (ImmutableList) this.f4497d;
                    }

                    @Nullable
                    private CheckupItemsModel m5571j() {
                        this.f4498e = (CheckupItemsModel) super.a(this.f4498e, 1, CheckupItemsModel.class);
                        return this.f4498e;
                    }

                    public final boolean m5577c() {
                        a(0, 2);
                        return this.f4499f;
                    }

                    public final int jK_() {
                        return -296016386;
                    }

                    public final GraphQLVisitableModel m5573a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                        GraphQLVisitableModel graphQLVisitableModel = null;
                        h();
                        if (m5571j() != null) {
                            CheckupItemsModel checkupItemsModel = (CheckupItemsModel) graphQLModelMutatingVisitor.b(m5571j());
                            if (m5571j() != checkupItemsModel) {
                                graphQLVisitableModel = (AppReviewModel) ModelHelper.a(null, this);
                                graphQLVisitableModel.f4498e = checkupItemsModel;
                            }
                        }
                        i();
                        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                    }

                    public final int m5572a(FlatBufferBuilder flatBufferBuilder) {
                        h();
                        int d = flatBufferBuilder.d(m5574a());
                        int a = ModelHelper.a(flatBufferBuilder, m5571j());
                        flatBufferBuilder.c(3);
                        flatBufferBuilder.b(0, d);
                        flatBufferBuilder.b(1, a);
                        flatBufferBuilder.a(2, this.f4499f);
                        i();
                        return flatBufferBuilder.d();
                    }

                    public final void m5575a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                        super.a(mutableFlatBuffer, i, obj);
                        this.f4499f = mutableFlatBuffer.a(i, 2);
                    }
                }

                /* compiled from: page/{#%s}/album_list */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(PrivacyCheckupInfoModel.class, new Deserializer());
                    }

                    public Object m5578a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(PrivacyCheckupInfoParser.m5756a(jsonParser, flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                        Object privacyCheckupInfoModel = new PrivacyCheckupInfoModel();
                        ((BaseModel) privacyCheckupInfoModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                        if (privacyCheckupInfoModel instanceof Postprocessable) {
                            return ((Postprocessable) privacyCheckupInfoModel).a();
                        }
                        return privacyCheckupInfoModel;
                    }
                }

                /* compiled from: page/{#%s}/album_list */
                public class Serializer extends JsonSerializer<PrivacyCheckupInfoModel> {
                    public final void m5579a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        PrivacyCheckupInfoModel privacyCheckupInfoModel = (PrivacyCheckupInfoModel) obj;
                        if (privacyCheckupInfoModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(privacyCheckupInfoModel.m5580a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            privacyCheckupInfoModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        PrivacyCheckupInfoParser.m5757a(privacyCheckupInfoModel.w_(), privacyCheckupInfoModel.u_(), jsonGenerator, serializerProvider);
                    }

                    static {
                        FbSerializerProvider.a(PrivacyCheckupInfoModel.class, new Serializer());
                    }
                }

                public PrivacyCheckupInfoModel() {
                    super(1);
                }

                @Nullable
                public final AppReviewModel m5582a() {
                    this.f4500d = (AppReviewModel) super.a(this.f4500d, 0, AppReviewModel.class);
                    return this.f4500d;
                }

                public final int jK_() {
                    return -1999479703;
                }

                public final GraphQLVisitableModel m5581a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    GraphQLVisitableModel graphQLVisitableModel = null;
                    h();
                    if (m5582a() != null) {
                        AppReviewModel appReviewModel = (AppReviewModel) graphQLModelMutatingVisitor.b(m5582a());
                        if (m5582a() != appReviewModel) {
                            graphQLVisitableModel = (PrivacyCheckupInfoModel) ModelHelper.a(null, this);
                            graphQLVisitableModel.f4500d = appReviewModel;
                        }
                    }
                    i();
                    return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                }

                public final int m5580a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int a = ModelHelper.a(flatBufferBuilder, m5582a());
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.b(0, a);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            /* compiled from: page/{#%s}/album_list */
            public class Serializer extends JsonSerializer<AudienceInfoModel> {
                public final void m5583a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    AudienceInfoModel audienceInfoModel = (AudienceInfoModel) obj;
                    if (audienceInfoModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(audienceInfoModel.m5584a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        audienceInfoModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    AudienceInfoParser.m5759a(audienceInfoModel.w_(), audienceInfoModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(AudienceInfoModel.class, new Serializer());
                }
            }

            public AudienceInfoModel() {
                super(1);
            }

            @Nullable
            public final PrivacyCheckupInfoModel m5586a() {
                this.f4501d = (PrivacyCheckupInfoModel) super.a(this.f4501d, 0, PrivacyCheckupInfoModel.class);
                return this.f4501d;
            }

            public final int jK_() {
                return -1563921166;
            }

            public final GraphQLVisitableModel m5585a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m5586a() != null) {
                    PrivacyCheckupInfoModel privacyCheckupInfoModel = (PrivacyCheckupInfoModel) graphQLModelMutatingVisitor.b(m5586a());
                    if (m5586a() != privacyCheckupInfoModel) {
                        graphQLVisitableModel = (AudienceInfoModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f4501d = privacyCheckupInfoModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m5584a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m5586a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, a);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: page/{#%s}/album_list */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(FetchPrivacyCheckupAppsStepQueryModel.class, new Deserializer());
            }

            public Object m5587a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = FetchPrivacyCheckupAppsStepQueryParser.m5760a(jsonParser);
                Object fetchPrivacyCheckupAppsStepQueryModel = new FetchPrivacyCheckupAppsStepQueryModel();
                ((BaseModel) fetchPrivacyCheckupAppsStepQueryModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (fetchPrivacyCheckupAppsStepQueryModel instanceof Postprocessable) {
                    return ((Postprocessable) fetchPrivacyCheckupAppsStepQueryModel).a();
                }
                return fetchPrivacyCheckupAppsStepQueryModel;
            }
        }

        /* compiled from: page/{#%s}/album_list */
        public class Serializer extends JsonSerializer<FetchPrivacyCheckupAppsStepQueryModel> {
            public final void m5588a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                FetchPrivacyCheckupAppsStepQueryModel fetchPrivacyCheckupAppsStepQueryModel = (FetchPrivacyCheckupAppsStepQueryModel) obj;
                if (fetchPrivacyCheckupAppsStepQueryModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(fetchPrivacyCheckupAppsStepQueryModel.m5589a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    fetchPrivacyCheckupAppsStepQueryModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = fetchPrivacyCheckupAppsStepQueryModel.w_();
                int u_ = fetchPrivacyCheckupAppsStepQueryModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("audience_info");
                    AudienceInfoParser.m5759a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(FetchPrivacyCheckupAppsStepQueryModel.class, new Serializer());
            }
        }

        public FetchPrivacyCheckupAppsStepQueryModel() {
            super(1);
        }

        @Nullable
        public final AudienceInfoModel m5591a() {
            this.f4502d = (AudienceInfoModel) super.a(this.f4502d, 0, AudienceInfoModel.class);
            return this.f4502d;
        }

        public final int jK_() {
            return -1732764110;
        }

        public final GraphQLVisitableModel m5590a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m5591a() != null) {
                AudienceInfoModel audienceInfoModel = (AudienceInfoModel) graphQLModelMutatingVisitor.b(m5591a());
                if (m5591a() != audienceInfoModel) {
                    graphQLVisitableModel = (FetchPrivacyCheckupAppsStepQueryModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f4502d = audienceInfoModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m5589a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m5591a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }

    @FragmentModelWithBridge
    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 1459805128)
    @JsonSerialize(using = Serializer.class)
    /* compiled from: page/{#%s}/album_list */
    public final class FetchPrivacyCheckupComposerStepQueryModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private AudienceInfoModel f4508d;

        @FragmentModelWithBridge
        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 1460494250)
        @JsonSerialize(using = Serializer.class)
        /* compiled from: page/{#%s}/album_list */
        public final class AudienceInfoModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private PrivacyCheckupInfoModel f4507d;

            /* compiled from: page/{#%s}/album_list */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(AudienceInfoModel.class, new Deserializer());
                }

                public Object m5592a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(FetchPrivacyCheckupComposerStepQueryParser.AudienceInfoParser.m5765a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object audienceInfoModel = new AudienceInfoModel();
                    ((BaseModel) audienceInfoModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (audienceInfoModel instanceof Postprocessable) {
                        return ((Postprocessable) audienceInfoModel).a();
                    }
                    return audienceInfoModel;
                }
            }

            @FragmentModelWithBridge
            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = -1174805634)
            @JsonSerialize(using = Serializer.class)
            /* compiled from: page/{#%s}/album_list */
            public final class PrivacyCheckupInfoModel extends BaseModel implements GraphQLVisitableModel {
                @Nullable
                private ComposerReviewModel f4506d;

                @FragmentModelWithBridge
                @JsonDeserialize(using = Deserializer.class)
                @ModelWithFlatBufferFormatHash(a = 630144575)
                @JsonSerialize(using = Serializer.class)
                /* compiled from: page/{#%s}/album_list */
                public final class ComposerReviewModel extends BaseModel implements GraphQLVisitableModel {
                    @Nullable
                    private List<GraphQLPrivacyCheckupActionType> f4503d;
                    @Nullable
                    private PrivacyCheckupItemsFragmentModel f4504e;
                    private boolean f4505f;

                    /* compiled from: page/{#%s}/album_list */
                    public class Deserializer extends FbJsonDeserializer {
                        static {
                            GlobalAutoGenDeserializerCache.a(ComposerReviewModel.class, new Deserializer());
                        }

                        public Object m5593a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(ComposerReviewParser.m5761a(jsonParser, flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            mutableFlatBuffer.a(4, Boolean.valueOf(true));
                            MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                            Object composerReviewModel = new ComposerReviewModel();
                            ((BaseModel) composerReviewModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                            if (composerReviewModel instanceof Postprocessable) {
                                return ((Postprocessable) composerReviewModel).a();
                            }
                            return composerReviewModel;
                        }
                    }

                    /* compiled from: page/{#%s}/album_list */
                    public class Serializer extends JsonSerializer<ComposerReviewModel> {
                        public final void m5594a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                            ComposerReviewModel composerReviewModel = (ComposerReviewModel) obj;
                            if (composerReviewModel.w_() == null) {
                                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                flatBufferBuilder.d(composerReviewModel.m5596a(flatBufferBuilder));
                                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                wrap.position(0);
                                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                composerReviewModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                            }
                            ComposerReviewParser.m5762a(composerReviewModel.w_(), composerReviewModel.u_(), jsonGenerator, serializerProvider);
                        }

                        static {
                            FbSerializerProvider.a(ComposerReviewModel.class, new Serializer());
                        }
                    }

                    @Nullable
                    public final /* synthetic */ PrivacyCheckupItemsFragment m5600b() {
                        return m5595j();
                    }

                    public ComposerReviewModel() {
                        super(3);
                    }

                    @Nonnull
                    public final ImmutableList<GraphQLPrivacyCheckupActionType> m5598a() {
                        this.f4503d = super.c(this.f4503d, 0, GraphQLPrivacyCheckupActionType.class);
                        return (ImmutableList) this.f4503d;
                    }

                    @Nullable
                    private PrivacyCheckupItemsFragmentModel m5595j() {
                        this.f4504e = (PrivacyCheckupItemsFragmentModel) super.a(this.f4504e, 1, PrivacyCheckupItemsFragmentModel.class);
                        return this.f4504e;
                    }

                    public final boolean m5601c() {
                        a(0, 2);
                        return this.f4505f;
                    }

                    public final int jK_() {
                        return 2098468499;
                    }

                    public final GraphQLVisitableModel m5597a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                        GraphQLVisitableModel graphQLVisitableModel = null;
                        h();
                        if (m5595j() != null) {
                            PrivacyCheckupItemsFragmentModel privacyCheckupItemsFragmentModel = (PrivacyCheckupItemsFragmentModel) graphQLModelMutatingVisitor.b(m5595j());
                            if (m5595j() != privacyCheckupItemsFragmentModel) {
                                graphQLVisitableModel = (ComposerReviewModel) ModelHelper.a(null, this);
                                graphQLVisitableModel.f4504e = privacyCheckupItemsFragmentModel;
                            }
                        }
                        i();
                        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                    }

                    public final int m5596a(FlatBufferBuilder flatBufferBuilder) {
                        h();
                        int d = flatBufferBuilder.d(m5598a());
                        int a = ModelHelper.a(flatBufferBuilder, m5595j());
                        flatBufferBuilder.c(3);
                        flatBufferBuilder.b(0, d);
                        flatBufferBuilder.b(1, a);
                        flatBufferBuilder.a(2, this.f4505f);
                        i();
                        return flatBufferBuilder.d();
                    }

                    public final void m5599a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                        super.a(mutableFlatBuffer, i, obj);
                        this.f4505f = mutableFlatBuffer.a(i, 2);
                    }
                }

                /* compiled from: page/{#%s}/album_list */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(PrivacyCheckupInfoModel.class, new Deserializer());
                    }

                    public Object m5602a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(FetchPrivacyCheckupComposerStepQueryParser.AudienceInfoParser.PrivacyCheckupInfoParser.m5763a(jsonParser, flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                        Object privacyCheckupInfoModel = new PrivacyCheckupInfoModel();
                        ((BaseModel) privacyCheckupInfoModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                        if (privacyCheckupInfoModel instanceof Postprocessable) {
                            return ((Postprocessable) privacyCheckupInfoModel).a();
                        }
                        return privacyCheckupInfoModel;
                    }
                }

                /* compiled from: page/{#%s}/album_list */
                public class Serializer extends JsonSerializer<PrivacyCheckupInfoModel> {
                    public final void m5603a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        PrivacyCheckupInfoModel privacyCheckupInfoModel = (PrivacyCheckupInfoModel) obj;
                        if (privacyCheckupInfoModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(privacyCheckupInfoModel.m5604a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            privacyCheckupInfoModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        FetchPrivacyCheckupComposerStepQueryParser.AudienceInfoParser.PrivacyCheckupInfoParser.m5764a(privacyCheckupInfoModel.w_(), privacyCheckupInfoModel.u_(), jsonGenerator, serializerProvider);
                    }

                    static {
                        FbSerializerProvider.a(PrivacyCheckupInfoModel.class, new Serializer());
                    }
                }

                public PrivacyCheckupInfoModel() {
                    super(1);
                }

                @Nullable
                public final ComposerReviewModel m5606a() {
                    this.f4506d = (ComposerReviewModel) super.a(this.f4506d, 0, ComposerReviewModel.class);
                    return this.f4506d;
                }

                public final int jK_() {
                    return -1999479703;
                }

                public final GraphQLVisitableModel m5605a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    GraphQLVisitableModel graphQLVisitableModel = null;
                    h();
                    if (m5606a() != null) {
                        ComposerReviewModel composerReviewModel = (ComposerReviewModel) graphQLModelMutatingVisitor.b(m5606a());
                        if (m5606a() != composerReviewModel) {
                            graphQLVisitableModel = (PrivacyCheckupInfoModel) ModelHelper.a(null, this);
                            graphQLVisitableModel.f4506d = composerReviewModel;
                        }
                    }
                    i();
                    return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                }

                public final int m5604a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int a = ModelHelper.a(flatBufferBuilder, m5606a());
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.b(0, a);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            /* compiled from: page/{#%s}/album_list */
            public class Serializer extends JsonSerializer<AudienceInfoModel> {
                public final void m5607a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    AudienceInfoModel audienceInfoModel = (AudienceInfoModel) obj;
                    if (audienceInfoModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(audienceInfoModel.m5608a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        audienceInfoModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    FetchPrivacyCheckupComposerStepQueryParser.AudienceInfoParser.m5766a(audienceInfoModel.w_(), audienceInfoModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(AudienceInfoModel.class, new Serializer());
                }
            }

            public AudienceInfoModel() {
                super(1);
            }

            @Nullable
            public final PrivacyCheckupInfoModel m5610a() {
                this.f4507d = (PrivacyCheckupInfoModel) super.a(this.f4507d, 0, PrivacyCheckupInfoModel.class);
                return this.f4507d;
            }

            public final int jK_() {
                return -1563921166;
            }

            public final GraphQLVisitableModel m5609a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m5610a() != null) {
                    PrivacyCheckupInfoModel privacyCheckupInfoModel = (PrivacyCheckupInfoModel) graphQLModelMutatingVisitor.b(m5610a());
                    if (m5610a() != privacyCheckupInfoModel) {
                        graphQLVisitableModel = (AudienceInfoModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f4507d = privacyCheckupInfoModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m5608a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m5610a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, a);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: page/{#%s}/album_list */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(FetchPrivacyCheckupComposerStepQueryModel.class, new Deserializer());
            }

            public Object m5611a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = FetchPrivacyCheckupComposerStepQueryParser.m5767a(jsonParser);
                Object fetchPrivacyCheckupComposerStepQueryModel = new FetchPrivacyCheckupComposerStepQueryModel();
                ((BaseModel) fetchPrivacyCheckupComposerStepQueryModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (fetchPrivacyCheckupComposerStepQueryModel instanceof Postprocessable) {
                    return ((Postprocessable) fetchPrivacyCheckupComposerStepQueryModel).a();
                }
                return fetchPrivacyCheckupComposerStepQueryModel;
            }
        }

        /* compiled from: page/{#%s}/album_list */
        public class Serializer extends JsonSerializer<FetchPrivacyCheckupComposerStepQueryModel> {
            public final void m5612a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                FetchPrivacyCheckupComposerStepQueryModel fetchPrivacyCheckupComposerStepQueryModel = (FetchPrivacyCheckupComposerStepQueryModel) obj;
                if (fetchPrivacyCheckupComposerStepQueryModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(fetchPrivacyCheckupComposerStepQueryModel.m5613a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    fetchPrivacyCheckupComposerStepQueryModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = fetchPrivacyCheckupComposerStepQueryModel.w_();
                int u_ = fetchPrivacyCheckupComposerStepQueryModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("audience_info");
                    FetchPrivacyCheckupComposerStepQueryParser.AudienceInfoParser.m5766a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(FetchPrivacyCheckupComposerStepQueryModel.class, new Serializer());
            }
        }

        public FetchPrivacyCheckupComposerStepQueryModel() {
            super(1);
        }

        @Nullable
        public final AudienceInfoModel m5615a() {
            this.f4508d = (AudienceInfoModel) super.a(this.f4508d, 0, AudienceInfoModel.class);
            return this.f4508d;
        }

        public final int jK_() {
            return -1732764110;
        }

        public final GraphQLVisitableModel m5614a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m5615a() != null) {
                AudienceInfoModel audienceInfoModel = (AudienceInfoModel) graphQLModelMutatingVisitor.b(m5615a());
                if (m5615a() != audienceInfoModel) {
                    graphQLVisitableModel = (FetchPrivacyCheckupComposerStepQueryModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f4508d = audienceInfoModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m5613a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m5615a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }

    @FragmentModelWithBridge
    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -2081726386)
    @JsonSerialize(using = Serializer.class)
    /* compiled from: page/{#%s}/album_list */
    public final class FetchPrivacyCheckupProfileStepQueryModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private AudienceInfoModel f4516d;

        @FragmentModelWithBridge
        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1216635136)
        @JsonSerialize(using = Serializer.class)
        /* compiled from: page/{#%s}/album_list */
        public final class AudienceInfoModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private PrivacyCheckupInfoModel f4515d;

            /* compiled from: page/{#%s}/album_list */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(AudienceInfoModel.class, new Deserializer());
                }

                public Object m5616a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(FetchPrivacyCheckupProfileStepQueryParser.AudienceInfoParser.m5774a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object audienceInfoModel = new AudienceInfoModel();
                    ((BaseModel) audienceInfoModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (audienceInfoModel instanceof Postprocessable) {
                        return ((Postprocessable) audienceInfoModel).a();
                    }
                    return audienceInfoModel;
                }
            }

            @FragmentModelWithBridge
            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = 2059624501)
            @JsonSerialize(using = Serializer.class)
            /* compiled from: page/{#%s}/album_list */
            public final class PrivacyCheckupInfoModel extends BaseModel implements GraphQLVisitableModel {
                @Nullable
                private ProfileReviewModel f4514d;

                /* compiled from: page/{#%s}/album_list */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(PrivacyCheckupInfoModel.class, new Deserializer());
                    }

                    public Object m5617a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(FetchPrivacyCheckupProfileStepQueryParser.AudienceInfoParser.PrivacyCheckupInfoParser.m5772a(jsonParser, flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                        Object privacyCheckupInfoModel = new PrivacyCheckupInfoModel();
                        ((BaseModel) privacyCheckupInfoModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                        if (privacyCheckupInfoModel instanceof Postprocessable) {
                            return ((Postprocessable) privacyCheckupInfoModel).a();
                        }
                        return privacyCheckupInfoModel;
                    }
                }

                @FragmentModelWithBridge
                @JsonDeserialize(using = Deserializer.class)
                @ModelWithFlatBufferFormatHash(a = -1785509851)
                @JsonSerialize(using = Serializer.class)
                /* compiled from: page/{#%s}/album_list */
                public final class ProfileReviewModel extends BaseModel implements GraphQLVisitableModel {
                    @Nullable
                    private List<GraphQLPrivacyCheckupActionType> f4511d;
                    @Nullable
                    private CheckupItemsModel f4512e;
                    private boolean f4513f;

                    @FragmentModelWithBridge
                    @JsonDeserialize(using = Deserializer.class)
                    @ModelWithFlatBufferFormatHash(a = -1985041600)
                    @JsonSerialize(using = Serializer.class)
                    /* compiled from: page/{#%s}/album_list */
                    public final class CheckupItemsModel extends BaseModel implements GraphQLVisitableModel, PrivacyCheckupItemsFragment {
                        @Nullable
                        private List<NodesModel> f4509d;
                        @Nullable
                        private DefaultPageInfoFieldsModel f4510e;

                        /* compiled from: page/{#%s}/album_list */
                        public class Deserializer extends FbJsonDeserializer {
                            static {
                                GlobalAutoGenDeserializerCache.a(CheckupItemsModel.class, new Deserializer());
                            }

                            public Object m5618a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                flatBufferBuilder.d(ProfileReviewParser.CheckupItemsParser.m5768a(jsonParser, flatBufferBuilder));
                                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                wrap.position(0);
                                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                                Object checkupItemsModel = new CheckupItemsModel();
                                ((BaseModel) checkupItemsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                                if (checkupItemsModel instanceof Postprocessable) {
                                    return ((Postprocessable) checkupItemsModel).a();
                                }
                                return checkupItemsModel;
                            }
                        }

                        /* compiled from: page/{#%s}/album_list */
                        public class Serializer extends JsonSerializer<CheckupItemsModel> {
                            public final void m5619a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                                CheckupItemsModel checkupItemsModel = (CheckupItemsModel) obj;
                                if (checkupItemsModel.w_() == null) {
                                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                    flatBufferBuilder.d(checkupItemsModel.m5621a(flatBufferBuilder));
                                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                    wrap.position(0);
                                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                    checkupItemsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                                }
                                ProfileReviewParser.CheckupItemsParser.m5769a(checkupItemsModel.w_(), checkupItemsModel.u_(), jsonGenerator, serializerProvider);
                            }

                            static {
                                FbSerializerProvider.a(CheckupItemsModel.class, new Serializer());
                            }
                        }

                        @Nullable
                        public final /* synthetic */ DefaultPageInfoFields m5622a() {
                            return m5620j();
                        }

                        public CheckupItemsModel() {
                            super(2);
                        }

                        @Nonnull
                        public final ImmutableList<NodesModel> mo113b() {
                            this.f4509d = super.a(this.f4509d, 0, NodesModel.class);
                            return (ImmutableList) this.f4509d;
                        }

                        @Nullable
                        private DefaultPageInfoFieldsModel m5620j() {
                            this.f4510e = (DefaultPageInfoFieldsModel) super.a(this.f4510e, 1, DefaultPageInfoFieldsModel.class);
                            return this.f4510e;
                        }

                        public final int jK_() {
                            return 445260876;
                        }

                        public final GraphQLVisitableModel m5623a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                            GraphQLVisitableModel graphQLVisitableModel;
                            DefaultPageInfoFieldsModel defaultPageInfoFieldsModel;
                            h();
                            if (mo113b() != null) {
                                Builder a = ModelHelper.a(mo113b(), graphQLModelMutatingVisitor);
                                if (a != null) {
                                    CheckupItemsModel checkupItemsModel = (CheckupItemsModel) ModelHelper.a(null, this);
                                    checkupItemsModel.f4509d = a.b();
                                    graphQLVisitableModel = checkupItemsModel;
                                    if (m5620j() != null) {
                                        defaultPageInfoFieldsModel = (DefaultPageInfoFieldsModel) graphQLModelMutatingVisitor.b(m5620j());
                                        if (m5620j() != defaultPageInfoFieldsModel) {
                                            graphQLVisitableModel = (CheckupItemsModel) ModelHelper.a(graphQLVisitableModel, this);
                                            graphQLVisitableModel.f4510e = defaultPageInfoFieldsModel;
                                        }
                                    }
                                    i();
                                    return graphQLVisitableModel != null ? this : graphQLVisitableModel;
                                }
                            }
                            graphQLVisitableModel = null;
                            if (m5620j() != null) {
                                defaultPageInfoFieldsModel = (DefaultPageInfoFieldsModel) graphQLModelMutatingVisitor.b(m5620j());
                                if (m5620j() != defaultPageInfoFieldsModel) {
                                    graphQLVisitableModel = (CheckupItemsModel) ModelHelper.a(graphQLVisitableModel, this);
                                    graphQLVisitableModel.f4510e = defaultPageInfoFieldsModel;
                                }
                            }
                            i();
                            if (graphQLVisitableModel != null) {
                            }
                        }

                        public final int m5621a(FlatBufferBuilder flatBufferBuilder) {
                            h();
                            int a = ModelHelper.a(flatBufferBuilder, mo113b());
                            int a2 = ModelHelper.a(flatBufferBuilder, m5620j());
                            flatBufferBuilder.c(2);
                            flatBufferBuilder.b(0, a);
                            flatBufferBuilder.b(1, a2);
                            i();
                            return flatBufferBuilder.d();
                        }
                    }

                    /* compiled from: page/{#%s}/album_list */
                    public class Deserializer extends FbJsonDeserializer {
                        static {
                            GlobalAutoGenDeserializerCache.a(ProfileReviewModel.class, new Deserializer());
                        }

                        public Object m5625a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(ProfileReviewParser.m5770a(jsonParser, flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            mutableFlatBuffer.a(4, Boolean.valueOf(true));
                            MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                            Object profileReviewModel = new ProfileReviewModel();
                            ((BaseModel) profileReviewModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                            if (profileReviewModel instanceof Postprocessable) {
                                return ((Postprocessable) profileReviewModel).a();
                            }
                            return profileReviewModel;
                        }
                    }

                    /* compiled from: page/{#%s}/album_list */
                    public class Serializer extends JsonSerializer<ProfileReviewModel> {
                        public final void m5626a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                            ProfileReviewModel profileReviewModel = (ProfileReviewModel) obj;
                            if (profileReviewModel.w_() == null) {
                                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                flatBufferBuilder.d(profileReviewModel.m5628a(flatBufferBuilder));
                                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                wrap.position(0);
                                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                profileReviewModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                            }
                            ProfileReviewParser.m5771a(profileReviewModel.w_(), profileReviewModel.u_(), jsonGenerator, serializerProvider);
                        }

                        static {
                            FbSerializerProvider.a(ProfileReviewModel.class, new Serializer());
                        }
                    }

                    @Nullable
                    public final /* synthetic */ CheckupItemsModel m5632b() {
                        return m5627j();
                    }

                    public ProfileReviewModel() {
                        super(3);
                    }

                    @Nonnull
                    public final ImmutableList<GraphQLPrivacyCheckupActionType> m5630a() {
                        this.f4511d = super.c(this.f4511d, 0, GraphQLPrivacyCheckupActionType.class);
                        return (ImmutableList) this.f4511d;
                    }

                    @Nullable
                    private CheckupItemsModel m5627j() {
                        this.f4512e = (CheckupItemsModel) super.a(this.f4512e, 1, CheckupItemsModel.class);
                        return this.f4512e;
                    }

                    public final boolean m5633c() {
                        a(0, 2);
                        return this.f4513f;
                    }

                    public final int jK_() {
                        return 933188870;
                    }

                    public final GraphQLVisitableModel m5629a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                        GraphQLVisitableModel graphQLVisitableModel = null;
                        h();
                        if (m5627j() != null) {
                            CheckupItemsModel checkupItemsModel = (CheckupItemsModel) graphQLModelMutatingVisitor.b(m5627j());
                            if (m5627j() != checkupItemsModel) {
                                graphQLVisitableModel = (ProfileReviewModel) ModelHelper.a(null, this);
                                graphQLVisitableModel.f4512e = checkupItemsModel;
                            }
                        }
                        i();
                        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                    }

                    public final int m5628a(FlatBufferBuilder flatBufferBuilder) {
                        h();
                        int d = flatBufferBuilder.d(m5630a());
                        int a = ModelHelper.a(flatBufferBuilder, m5627j());
                        flatBufferBuilder.c(3);
                        flatBufferBuilder.b(0, d);
                        flatBufferBuilder.b(1, a);
                        flatBufferBuilder.a(2, this.f4513f);
                        i();
                        return flatBufferBuilder.d();
                    }

                    public final void m5631a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                        super.a(mutableFlatBuffer, i, obj);
                        this.f4513f = mutableFlatBuffer.a(i, 2);
                    }
                }

                /* compiled from: page/{#%s}/album_list */
                public class Serializer extends JsonSerializer<PrivacyCheckupInfoModel> {
                    public final void m5634a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        PrivacyCheckupInfoModel privacyCheckupInfoModel = (PrivacyCheckupInfoModel) obj;
                        if (privacyCheckupInfoModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(privacyCheckupInfoModel.m5635a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            privacyCheckupInfoModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        FetchPrivacyCheckupProfileStepQueryParser.AudienceInfoParser.PrivacyCheckupInfoParser.m5773a(privacyCheckupInfoModel.w_(), privacyCheckupInfoModel.u_(), jsonGenerator, serializerProvider);
                    }

                    static {
                        FbSerializerProvider.a(PrivacyCheckupInfoModel.class, new Serializer());
                    }
                }

                public PrivacyCheckupInfoModel() {
                    super(1);
                }

                @Nullable
                public final ProfileReviewModel m5637a() {
                    this.f4514d = (ProfileReviewModel) super.a(this.f4514d, 0, ProfileReviewModel.class);
                    return this.f4514d;
                }

                public final int jK_() {
                    return -1999479703;
                }

                public final GraphQLVisitableModel m5636a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    GraphQLVisitableModel graphQLVisitableModel = null;
                    h();
                    if (m5637a() != null) {
                        ProfileReviewModel profileReviewModel = (ProfileReviewModel) graphQLModelMutatingVisitor.b(m5637a());
                        if (m5637a() != profileReviewModel) {
                            graphQLVisitableModel = (PrivacyCheckupInfoModel) ModelHelper.a(null, this);
                            graphQLVisitableModel.f4514d = profileReviewModel;
                        }
                    }
                    i();
                    return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                }

                public final int m5635a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int a = ModelHelper.a(flatBufferBuilder, m5637a());
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.b(0, a);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            /* compiled from: page/{#%s}/album_list */
            public class Serializer extends JsonSerializer<AudienceInfoModel> {
                public final void m5638a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    AudienceInfoModel audienceInfoModel = (AudienceInfoModel) obj;
                    if (audienceInfoModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(audienceInfoModel.m5639a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        audienceInfoModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    FetchPrivacyCheckupProfileStepQueryParser.AudienceInfoParser.m5775a(audienceInfoModel.w_(), audienceInfoModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(AudienceInfoModel.class, new Serializer());
                }
            }

            public AudienceInfoModel() {
                super(1);
            }

            @Nullable
            public final PrivacyCheckupInfoModel m5641a() {
                this.f4515d = (PrivacyCheckupInfoModel) super.a(this.f4515d, 0, PrivacyCheckupInfoModel.class);
                return this.f4515d;
            }

            public final int jK_() {
                return -1563921166;
            }

            public final GraphQLVisitableModel m5640a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m5641a() != null) {
                    PrivacyCheckupInfoModel privacyCheckupInfoModel = (PrivacyCheckupInfoModel) graphQLModelMutatingVisitor.b(m5641a());
                    if (m5641a() != privacyCheckupInfoModel) {
                        graphQLVisitableModel = (AudienceInfoModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f4515d = privacyCheckupInfoModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m5639a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m5641a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, a);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: page/{#%s}/album_list */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(FetchPrivacyCheckupProfileStepQueryModel.class, new Deserializer());
            }

            public Object m5642a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = FetchPrivacyCheckupProfileStepQueryParser.m5776a(jsonParser);
                Object fetchPrivacyCheckupProfileStepQueryModel = new FetchPrivacyCheckupProfileStepQueryModel();
                ((BaseModel) fetchPrivacyCheckupProfileStepQueryModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (fetchPrivacyCheckupProfileStepQueryModel instanceof Postprocessable) {
                    return ((Postprocessable) fetchPrivacyCheckupProfileStepQueryModel).a();
                }
                return fetchPrivacyCheckupProfileStepQueryModel;
            }
        }

        /* compiled from: page/{#%s}/album_list */
        public class Serializer extends JsonSerializer<FetchPrivacyCheckupProfileStepQueryModel> {
            public final void m5643a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                FetchPrivacyCheckupProfileStepQueryModel fetchPrivacyCheckupProfileStepQueryModel = (FetchPrivacyCheckupProfileStepQueryModel) obj;
                if (fetchPrivacyCheckupProfileStepQueryModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(fetchPrivacyCheckupProfileStepQueryModel.m5644a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    fetchPrivacyCheckupProfileStepQueryModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = fetchPrivacyCheckupProfileStepQueryModel.w_();
                int u_ = fetchPrivacyCheckupProfileStepQueryModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("audience_info");
                    FetchPrivacyCheckupProfileStepQueryParser.AudienceInfoParser.m5775a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(FetchPrivacyCheckupProfileStepQueryModel.class, new Serializer());
            }
        }

        public FetchPrivacyCheckupProfileStepQueryModel() {
            super(1);
        }

        @Nullable
        public final AudienceInfoModel m5646a() {
            this.f4516d = (AudienceInfoModel) super.a(this.f4516d, 0, AudienceInfoModel.class);
            return this.f4516d;
        }

        public final int jK_() {
            return -1732764110;
        }

        public final GraphQLVisitableModel m5645a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m5646a() != null) {
                AudienceInfoModel audienceInfoModel = (AudienceInfoModel) graphQLModelMutatingVisitor.b(m5646a());
                if (m5646a() != audienceInfoModel) {
                    graphQLVisitableModel = (FetchPrivacyCheckupProfileStepQueryModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f4516d = audienceInfoModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m5644a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m5646a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }

    @FragmentModelWithBridge
    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -2103097489)
    @JsonSerialize(using = Serializer.class)
    /* compiled from: page/{#%s}/album_list */
    public final class PrivacyCheckupItemPrivacyScopeFragmentModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private String f4519d;
        @Nullable
        private IconImageModel f4520e;
        @Nullable
        private PrivacyOptionsModel f4521f;

        /* compiled from: page/{#%s}/album_list */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(PrivacyCheckupItemPrivacyScopeFragmentModel.class, new Deserializer());
            }

            public Object m5647a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(PrivacyCheckupItemPrivacyScopeFragmentParser.m5781a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object privacyCheckupItemPrivacyScopeFragmentModel = new PrivacyCheckupItemPrivacyScopeFragmentModel();
                ((BaseModel) privacyCheckupItemPrivacyScopeFragmentModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (privacyCheckupItemPrivacyScopeFragmentModel instanceof Postprocessable) {
                    return ((Postprocessable) privacyCheckupItemPrivacyScopeFragmentModel).a();
                }
                return privacyCheckupItemPrivacyScopeFragmentModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 273304230)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: page/{#%s}/album_list */
        public final class IconImageModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private String f4517d;

            /* compiled from: page/{#%s}/album_list */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(IconImageModel.class, new Deserializer());
                }

                public Object m5648a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(IconImageParser.m5777a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object iconImageModel = new IconImageModel();
                    ((BaseModel) iconImageModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (iconImageModel instanceof Postprocessable) {
                        return ((Postprocessable) iconImageModel).a();
                    }
                    return iconImageModel;
                }
            }

            /* compiled from: page/{#%s}/album_list */
            public class Serializer extends JsonSerializer<IconImageModel> {
                public final void m5649a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    IconImageModel iconImageModel = (IconImageModel) obj;
                    if (iconImageModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(iconImageModel.m5650a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        iconImageModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    IconImageParser.m5778a(iconImageModel.w_(), iconImageModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(IconImageModel.class, new Serializer());
                }
            }

            public IconImageModel() {
                super(1);
            }

            @Nullable
            public final String m5652a() {
                this.f4517d = super.a(this.f4517d, 0);
                return this.f4517d;
            }

            public final int jK_() {
                return 70760763;
            }

            public final GraphQLVisitableModel m5651a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m5650a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m5652a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, b);
                i();
                return flatBufferBuilder.d();
            }
        }

        @FragmentModelWithBridge
        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -807017798)
        @JsonSerialize(using = Serializer.class)
        /* compiled from: page/{#%s}/album_list */
        public final class PrivacyOptionsModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private List<GraphQLPrivacyOptionsContentEdge> f4518d;

            /* compiled from: page/{#%s}/album_list */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(PrivacyOptionsModel.class, new Deserializer());
                }

                public Object m5653a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(PrivacyOptionsParser.m5779a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object privacyOptionsModel = new PrivacyOptionsModel();
                    ((BaseModel) privacyOptionsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (privacyOptionsModel instanceof Postprocessable) {
                        return ((Postprocessable) privacyOptionsModel).a();
                    }
                    return privacyOptionsModel;
                }
            }

            /* compiled from: page/{#%s}/album_list */
            public class Serializer extends JsonSerializer<PrivacyOptionsModel> {
                public final void m5654a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    PrivacyOptionsModel privacyOptionsModel = (PrivacyOptionsModel) obj;
                    if (privacyOptionsModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(privacyOptionsModel.m5655a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        privacyOptionsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    PrivacyOptionsParser.m5780a(privacyOptionsModel.w_(), privacyOptionsModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(PrivacyOptionsModel.class, new Serializer());
                }
            }

            public PrivacyOptionsModel() {
                super(1);
            }

            @Nonnull
            public final ImmutableList<GraphQLPrivacyOptionsContentEdge> m5657a() {
                this.f4518d = super.a(this.f4518d, 0, GraphQLPrivacyOptionsContentEdge.class);
                return (ImmutableList) this.f4518d;
            }

            public final int jK_() {
                return 780090561;
            }

            public final GraphQLVisitableModel m5656a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m5657a() != null) {
                    Builder a = ModelHelper.a(m5657a(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        graphQLVisitableModel = (PrivacyOptionsModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f4518d = a.b();
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m5655a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m5657a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, a);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: page/{#%s}/album_list */
        public class Serializer extends JsonSerializer<PrivacyCheckupItemPrivacyScopeFragmentModel> {
            public final void m5658a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                PrivacyCheckupItemPrivacyScopeFragmentModel privacyCheckupItemPrivacyScopeFragmentModel = (PrivacyCheckupItemPrivacyScopeFragmentModel) obj;
                if (privacyCheckupItemPrivacyScopeFragmentModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(privacyCheckupItemPrivacyScopeFragmentModel.m5661a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    privacyCheckupItemPrivacyScopeFragmentModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                PrivacyCheckupItemPrivacyScopeFragmentParser.m5782a(privacyCheckupItemPrivacyScopeFragmentModel.w_(), privacyCheckupItemPrivacyScopeFragmentModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(PrivacyCheckupItemPrivacyScopeFragmentModel.class, new Serializer());
            }
        }

        @Nullable
        public final /* synthetic */ IconImageModel m5664b() {
            return m5659j();
        }

        @Nullable
        public final /* synthetic */ PrivacyOptionsModel m5665c() {
            return m5660k();
        }

        public PrivacyCheckupItemPrivacyScopeFragmentModel() {
            super(3);
        }

        @Nullable
        public final String m5663a() {
            this.f4519d = super.a(this.f4519d, 0);
            return this.f4519d;
        }

        @Nullable
        private IconImageModel m5659j() {
            this.f4520e = (IconImageModel) super.a(this.f4520e, 1, IconImageModel.class);
            return this.f4520e;
        }

        @Nullable
        private PrivacyOptionsModel m5660k() {
            this.f4521f = (PrivacyOptionsModel) super.a(this.f4521f, 2, PrivacyOptionsModel.class);
            return this.f4521f;
        }

        public final int jK_() {
            return -476351540;
        }

        public final GraphQLVisitableModel m5662a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m5659j() != null) {
                IconImageModel iconImageModel = (IconImageModel) graphQLModelMutatingVisitor.b(m5659j());
                if (m5659j() != iconImageModel) {
                    graphQLVisitableModel = (PrivacyCheckupItemPrivacyScopeFragmentModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f4520e = iconImageModel;
                }
            }
            if (m5660k() != null) {
                PrivacyOptionsModel privacyOptionsModel = (PrivacyOptionsModel) graphQLModelMutatingVisitor.b(m5660k());
                if (m5660k() != privacyOptionsModel) {
                    graphQLVisitableModel = (PrivacyCheckupItemPrivacyScopeFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f4521f = privacyOptionsModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m5661a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(m5663a());
            int a = ModelHelper.a(flatBufferBuilder, m5659j());
            int a2 = ModelHelper.a(flatBufferBuilder, m5660k());
            flatBufferBuilder.c(3);
            flatBufferBuilder.b(0, b);
            flatBufferBuilder.b(1, a);
            flatBufferBuilder.b(2, a2);
            i();
            return flatBufferBuilder.d();
        }
    }

    @FragmentModelWithBridge
    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 1987775080)
    @JsonSerialize(using = Serializer.class)
    /* compiled from: page/{#%s}/album_list */
    public final class PrivacyCheckupItemsFragmentModel extends BaseModel implements GraphQLVisitableModel, PrivacyCheckupItemsFragment {
        @Nullable
        private List<NodesModel> f4526d;

        /* compiled from: page/{#%s}/album_list */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(PrivacyCheckupItemsFragmentModel.class, new Deserializer());
            }

            public Object m5666a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(PrivacyCheckupItemsFragmentParser.m5787a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object privacyCheckupItemsFragmentModel = new PrivacyCheckupItemsFragmentModel();
                ((BaseModel) privacyCheckupItemsFragmentModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (privacyCheckupItemsFragmentModel instanceof Postprocessable) {
                    return ((Postprocessable) privacyCheckupItemsFragmentModel).a();
                }
                return privacyCheckupItemsFragmentModel;
            }
        }

        @FragmentModelWithBridge
        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1127187684)
        @JsonSerialize(using = Serializer.class)
        /* compiled from: page/{#%s}/album_list */
        public final class NodesModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private PrivacyCheckupSectionDataFragmentModel f4522d;
            @Nullable
            private PrivacyCheckupSectionHeaderFragmentModel f4523e;
            @Nullable
            private PrivacyCheckupSectionInfoFragmentModel f4524f;
            @Nullable
            private GraphQLPrivacyCheckupSectionType f4525g;

            /* compiled from: page/{#%s}/album_list */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(NodesModel.class, new Deserializer());
                }

                public Object m5667a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(PrivacyCheckupItemsFragmentParser.NodesParser.m5785b(jsonParser, flatBufferBuilder));
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

            /* compiled from: page/{#%s}/album_list */
            public class Serializer extends JsonSerializer<NodesModel> {
                public final void m5668a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    NodesModel nodesModel = (NodesModel) obj;
                    if (nodesModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(nodesModel.m5672a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        nodesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    PrivacyCheckupItemsFragmentParser.NodesParser.m5786b(nodesModel.w_(), nodesModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(NodesModel.class, new Serializer());
                }
            }

            @Nullable
            public final /* synthetic */ PrivacyCheckupSectionDataFragmentModel m5674a() {
                return m5669j();
            }

            @Nullable
            public final /* synthetic */ PrivacyCheckupSectionHeaderFragmentModel m5675b() {
                return m5670k();
            }

            @Nullable
            public final /* synthetic */ PrivacyCheckupSectionInfoFragmentModel m5676c() {
                return m5671l();
            }

            public NodesModel() {
                super(4);
            }

            @Nullable
            private PrivacyCheckupSectionDataFragmentModel m5669j() {
                this.f4522d = (PrivacyCheckupSectionDataFragmentModel) super.a(this.f4522d, 0, PrivacyCheckupSectionDataFragmentModel.class);
                return this.f4522d;
            }

            @Nullable
            private PrivacyCheckupSectionHeaderFragmentModel m5670k() {
                this.f4523e = (PrivacyCheckupSectionHeaderFragmentModel) super.a(this.f4523e, 1, PrivacyCheckupSectionHeaderFragmentModel.class);
                return this.f4523e;
            }

            @Nullable
            private PrivacyCheckupSectionInfoFragmentModel m5671l() {
                this.f4524f = (PrivacyCheckupSectionInfoFragmentModel) super.a(this.f4524f, 2, PrivacyCheckupSectionInfoFragmentModel.class);
                return this.f4524f;
            }

            @Nullable
            public final GraphQLPrivacyCheckupSectionType m5677d() {
                this.f4525g = (GraphQLPrivacyCheckupSectionType) super.b(this.f4525g, 3, GraphQLPrivacyCheckupSectionType.class, GraphQLPrivacyCheckupSectionType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
                return this.f4525g;
            }

            public final int jK_() {
                return -1999473970;
            }

            public final GraphQLVisitableModel m5673a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m5669j() != null) {
                    PrivacyCheckupSectionDataFragmentModel privacyCheckupSectionDataFragmentModel = (PrivacyCheckupSectionDataFragmentModel) graphQLModelMutatingVisitor.b(m5669j());
                    if (m5669j() != privacyCheckupSectionDataFragmentModel) {
                        graphQLVisitableModel = (NodesModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f4522d = privacyCheckupSectionDataFragmentModel;
                    }
                }
                if (m5670k() != null) {
                    PrivacyCheckupSectionHeaderFragmentModel privacyCheckupSectionHeaderFragmentModel = (PrivacyCheckupSectionHeaderFragmentModel) graphQLModelMutatingVisitor.b(m5670k());
                    if (m5670k() != privacyCheckupSectionHeaderFragmentModel) {
                        graphQLVisitableModel = (NodesModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f4523e = privacyCheckupSectionHeaderFragmentModel;
                    }
                }
                if (m5671l() != null) {
                    PrivacyCheckupSectionInfoFragmentModel privacyCheckupSectionInfoFragmentModel = (PrivacyCheckupSectionInfoFragmentModel) graphQLModelMutatingVisitor.b(m5671l());
                    if (m5671l() != privacyCheckupSectionInfoFragmentModel) {
                        graphQLVisitableModel = (NodesModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f4524f = privacyCheckupSectionInfoFragmentModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m5672a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m5669j());
                int a2 = ModelHelper.a(flatBufferBuilder, m5670k());
                int a3 = ModelHelper.a(flatBufferBuilder, m5671l());
                int a4 = flatBufferBuilder.a(m5677d());
                flatBufferBuilder.c(4);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.b(1, a2);
                flatBufferBuilder.b(2, a3);
                flatBufferBuilder.b(3, a4);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: page/{#%s}/album_list */
        public class Serializer extends JsonSerializer<PrivacyCheckupItemsFragmentModel> {
            public final void m5678a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                PrivacyCheckupItemsFragmentModel privacyCheckupItemsFragmentModel = (PrivacyCheckupItemsFragmentModel) obj;
                if (privacyCheckupItemsFragmentModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(privacyCheckupItemsFragmentModel.m5679a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    privacyCheckupItemsFragmentModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                PrivacyCheckupItemsFragmentParser.m5788a(privacyCheckupItemsFragmentModel.w_(), privacyCheckupItemsFragmentModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(PrivacyCheckupItemsFragmentModel.class, new Serializer());
            }
        }

        public PrivacyCheckupItemsFragmentModel() {
            super(1);
        }

        @Nonnull
        public final ImmutableList<NodesModel> mo113b() {
            this.f4526d = super.a(this.f4526d, 0, NodesModel.class);
            return (ImmutableList) this.f4526d;
        }

        public final int jK_() {
            return 445260876;
        }

        public final GraphQLVisitableModel m5680a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (mo113b() != null) {
                Builder a = ModelHelper.a(mo113b(), graphQLModelMutatingVisitor);
                if (a != null) {
                    graphQLVisitableModel = (PrivacyCheckupItemsFragmentModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f4526d = a.b();
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m5679a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, mo113b());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }

    @FragmentModelWithBridge
    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 110500427)
    @JsonSerialize(using = Serializer.class)
    /* compiled from: page/{#%s}/album_list */
    public final class PrivacyCheckupSectionDataFragmentModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private String f4527d;
        @Nullable
        private String f4528e;
        @Nullable
        private String f4529f;
        @Nullable
        private PrivacyScopeForEditFragmentModel f4530g;

        /* compiled from: page/{#%s}/album_list */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(PrivacyCheckupSectionDataFragmentModel.class, new Deserializer());
            }

            public Object m5682a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(PrivacyCheckupSectionDataFragmentParser.m5789a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object privacyCheckupSectionDataFragmentModel = new PrivacyCheckupSectionDataFragmentModel();
                ((BaseModel) privacyCheckupSectionDataFragmentModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (privacyCheckupSectionDataFragmentModel instanceof Postprocessable) {
                    return ((Postprocessable) privacyCheckupSectionDataFragmentModel).a();
                }
                return privacyCheckupSectionDataFragmentModel;
            }
        }

        /* compiled from: page/{#%s}/album_list */
        public class Serializer extends JsonSerializer<PrivacyCheckupSectionDataFragmentModel> {
            public final void m5683a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                PrivacyCheckupSectionDataFragmentModel privacyCheckupSectionDataFragmentModel = (PrivacyCheckupSectionDataFragmentModel) obj;
                if (privacyCheckupSectionDataFragmentModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(privacyCheckupSectionDataFragmentModel.m5685a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    privacyCheckupSectionDataFragmentModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                PrivacyCheckupSectionDataFragmentParser.m5790a(privacyCheckupSectionDataFragmentModel.w_(), privacyCheckupSectionDataFragmentModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(PrivacyCheckupSectionDataFragmentModel.class, new Serializer());
            }
        }

        @Nullable
        public final /* synthetic */ PrivacyScopeForEditFragmentModel m5690d() {
            return m5684j();
        }

        public PrivacyCheckupSectionDataFragmentModel() {
            super(4);
        }

        @Nullable
        public final String m5687a() {
            this.f4527d = super.a(this.f4527d, 0);
            return this.f4527d;
        }

        @Nullable
        public final String m5688b() {
            this.f4528e = super.a(this.f4528e, 1);
            return this.f4528e;
        }

        @Nullable
        public final String m5689c() {
            this.f4529f = super.a(this.f4529f, 2);
            return this.f4529f;
        }

        @Nullable
        private PrivacyScopeForEditFragmentModel m5684j() {
            this.f4530g = (PrivacyScopeForEditFragmentModel) super.a(this.f4530g, 3, PrivacyScopeForEditFragmentModel.class);
            return this.f4530g;
        }

        public final int jK_() {
            return -916269036;
        }

        public final GraphQLVisitableModel m5686a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m5684j() != null) {
                PrivacyScopeForEditFragmentModel privacyScopeForEditFragmentModel = (PrivacyScopeForEditFragmentModel) graphQLModelMutatingVisitor.b(m5684j());
                if (m5684j() != privacyScopeForEditFragmentModel) {
                    graphQLVisitableModel = (PrivacyCheckupSectionDataFragmentModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f4530g = privacyScopeForEditFragmentModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m5685a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(m5687a());
            int b2 = flatBufferBuilder.b(m5688b());
            int b3 = flatBufferBuilder.b(m5689c());
            int a = ModelHelper.a(flatBufferBuilder, m5684j());
            flatBufferBuilder.c(4);
            flatBufferBuilder.b(0, b);
            flatBufferBuilder.b(1, b2);
            flatBufferBuilder.b(2, b3);
            flatBufferBuilder.b(3, a);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 519154443)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: page/{#%s}/album_list */
    public final class PrivacyCheckupSectionHeaderFragmentModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private String f4531d;

        /* compiled from: page/{#%s}/album_list */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(PrivacyCheckupSectionHeaderFragmentModel.class, new Deserializer());
            }

            public Object m5691a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(PrivacyCheckupSectionHeaderFragmentParser.m5791a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object privacyCheckupSectionHeaderFragmentModel = new PrivacyCheckupSectionHeaderFragmentModel();
                ((BaseModel) privacyCheckupSectionHeaderFragmentModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (privacyCheckupSectionHeaderFragmentModel instanceof Postprocessable) {
                    return ((Postprocessable) privacyCheckupSectionHeaderFragmentModel).a();
                }
                return privacyCheckupSectionHeaderFragmentModel;
            }
        }

        /* compiled from: page/{#%s}/album_list */
        public class Serializer extends JsonSerializer<PrivacyCheckupSectionHeaderFragmentModel> {
            public final void m5692a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                PrivacyCheckupSectionHeaderFragmentModel privacyCheckupSectionHeaderFragmentModel = (PrivacyCheckupSectionHeaderFragmentModel) obj;
                if (privacyCheckupSectionHeaderFragmentModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(privacyCheckupSectionHeaderFragmentModel.m5693a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    privacyCheckupSectionHeaderFragmentModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                PrivacyCheckupSectionHeaderFragmentParser.m5792a(privacyCheckupSectionHeaderFragmentModel.w_(), privacyCheckupSectionHeaderFragmentModel.u_(), jsonGenerator);
            }

            static {
                FbSerializerProvider.a(PrivacyCheckupSectionHeaderFragmentModel.class, new Serializer());
            }
        }

        public PrivacyCheckupSectionHeaderFragmentModel() {
            super(1);
        }

        @Nullable
        public final String m5695a() {
            this.f4531d = super.a(this.f4531d, 0);
            return this.f4531d;
        }

        public final int jK_() {
            return 51402871;
        }

        public final GraphQLVisitableModel m5694a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            h();
            i();
            return this;
        }

        public final int m5693a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(m5695a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, b);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 519154443)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: page/{#%s}/album_list */
    public final class PrivacyCheckupSectionInfoFragmentModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private String f4532d;

        /* compiled from: page/{#%s}/album_list */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(PrivacyCheckupSectionInfoFragmentModel.class, new Deserializer());
            }

            public Object m5696a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(PrivacyCheckupSectionInfoFragmentParser.m5793a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object privacyCheckupSectionInfoFragmentModel = new PrivacyCheckupSectionInfoFragmentModel();
                ((BaseModel) privacyCheckupSectionInfoFragmentModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (privacyCheckupSectionInfoFragmentModel instanceof Postprocessable) {
                    return ((Postprocessable) privacyCheckupSectionInfoFragmentModel).a();
                }
                return privacyCheckupSectionInfoFragmentModel;
            }
        }

        /* compiled from: page/{#%s}/album_list */
        public class Serializer extends JsonSerializer<PrivacyCheckupSectionInfoFragmentModel> {
            public final void m5697a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                PrivacyCheckupSectionInfoFragmentModel privacyCheckupSectionInfoFragmentModel = (PrivacyCheckupSectionInfoFragmentModel) obj;
                if (privacyCheckupSectionInfoFragmentModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(privacyCheckupSectionInfoFragmentModel.m5698a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    privacyCheckupSectionInfoFragmentModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                PrivacyCheckupSectionInfoFragmentParser.m5794a(privacyCheckupSectionInfoFragmentModel.w_(), privacyCheckupSectionInfoFragmentModel.u_(), jsonGenerator);
            }

            static {
                FbSerializerProvider.a(PrivacyCheckupSectionInfoFragmentModel.class, new Serializer());
            }
        }

        public PrivacyCheckupSectionInfoFragmentModel() {
            super(1);
        }

        @Nullable
        public final String m5700a() {
            this.f4532d = super.a(this.f4532d, 0);
            return this.f4532d;
        }

        public final int jK_() {
            return -916108008;
        }

        public final GraphQLVisitableModel m5699a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            h();
            i();
            return this;
        }

        public final int m5698a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(m5700a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, b);
            i();
            return flatBufferBuilder.d();
        }
    }

    @FragmentModelWithBridge
    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -802960176)
    @JsonSerialize(using = Serializer.class)
    /* compiled from: page/{#%s}/album_list */
    public final class PrivacyReviewCoreItemsFragmentModel extends BaseModel implements GraphQLVisitableModel, PrivacyReviewCoreItemsFragment {
        @Nullable
        private List<NodesModel> f4536d;

        /* compiled from: page/{#%s}/album_list */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(PrivacyReviewCoreItemsFragmentModel.class, new Deserializer());
            }

            public Object m5701a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = PrivacyReviewCoreItemsFragmentParser.m5799a(jsonParser);
                Object privacyReviewCoreItemsFragmentModel = new PrivacyReviewCoreItemsFragmentModel();
                ((BaseModel) privacyReviewCoreItemsFragmentModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (privacyReviewCoreItemsFragmentModel instanceof Postprocessable) {
                    return ((Postprocessable) privacyReviewCoreItemsFragmentModel).a();
                }
                return privacyReviewCoreItemsFragmentModel;
            }
        }

        @FragmentModelWithBridge
        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1595868458)
        @JsonSerialize(using = Serializer.class)
        /* compiled from: page/{#%s}/album_list */
        public final class NodesModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private PrivacyReviewCoreSectionDataFragmentModel f4533d;
            @Nullable
            private PrivacyReviewCoreSectionHeaderFragmentModel f4534e;
            @Nullable
            private GraphQLPrivacyReviewCoreSectionType f4535f;

            /* compiled from: page/{#%s}/album_list */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(NodesModel.class, new Deserializer());
                }

                public Object m5702a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(PrivacyReviewCoreItemsFragmentParser.NodesParser.m5797b(jsonParser, flatBufferBuilder));
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

            /* compiled from: page/{#%s}/album_list */
            public class Serializer extends JsonSerializer<NodesModel> {
                public final void m5703a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    NodesModel nodesModel = (NodesModel) obj;
                    if (nodesModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(nodesModel.m5706a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        nodesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    PrivacyReviewCoreItemsFragmentParser.NodesParser.m5798b(nodesModel.w_(), nodesModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(NodesModel.class, new Serializer());
                }
            }

            @Nullable
            public final /* synthetic */ PrivacyReviewCoreSectionDataFragmentModel m5708a() {
                return m5704j();
            }

            @Nullable
            public final /* synthetic */ PrivacyReviewCoreSectionHeaderFragmentModel m5709b() {
                return m5705k();
            }

            public NodesModel() {
                super(3);
            }

            @Nullable
            private PrivacyReviewCoreSectionDataFragmentModel m5704j() {
                this.f4533d = (PrivacyReviewCoreSectionDataFragmentModel) super.a(this.f4533d, 0, PrivacyReviewCoreSectionDataFragmentModel.class);
                return this.f4533d;
            }

            @Nullable
            private PrivacyReviewCoreSectionHeaderFragmentModel m5705k() {
                this.f4534e = (PrivacyReviewCoreSectionHeaderFragmentModel) super.a(this.f4534e, 1, PrivacyReviewCoreSectionHeaderFragmentModel.class);
                return this.f4534e;
            }

            @Nullable
            public final GraphQLPrivacyReviewCoreSectionType m5710c() {
                this.f4535f = (GraphQLPrivacyReviewCoreSectionType) super.b(this.f4535f, 2, GraphQLPrivacyReviewCoreSectionType.class, GraphQLPrivacyReviewCoreSectionType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
                return this.f4535f;
            }

            public final int jK_() {
                return 1276662086;
            }

            public final GraphQLVisitableModel m5707a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m5704j() != null) {
                    PrivacyReviewCoreSectionDataFragmentModel privacyReviewCoreSectionDataFragmentModel = (PrivacyReviewCoreSectionDataFragmentModel) graphQLModelMutatingVisitor.b(m5704j());
                    if (m5704j() != privacyReviewCoreSectionDataFragmentModel) {
                        graphQLVisitableModel = (NodesModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f4533d = privacyReviewCoreSectionDataFragmentModel;
                    }
                }
                if (m5705k() != null) {
                    PrivacyReviewCoreSectionHeaderFragmentModel privacyReviewCoreSectionHeaderFragmentModel = (PrivacyReviewCoreSectionHeaderFragmentModel) graphQLModelMutatingVisitor.b(m5705k());
                    if (m5705k() != privacyReviewCoreSectionHeaderFragmentModel) {
                        graphQLVisitableModel = (NodesModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f4534e = privacyReviewCoreSectionHeaderFragmentModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m5706a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m5704j());
                int a2 = ModelHelper.a(flatBufferBuilder, m5705k());
                int a3 = flatBufferBuilder.a(m5710c());
                flatBufferBuilder.c(3);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.b(1, a2);
                flatBufferBuilder.b(2, a3);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: page/{#%s}/album_list */
        public class Serializer extends JsonSerializer<PrivacyReviewCoreItemsFragmentModel> {
            public final void m5711a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                PrivacyReviewCoreItemsFragmentModel privacyReviewCoreItemsFragmentModel = (PrivacyReviewCoreItemsFragmentModel) obj;
                if (privacyReviewCoreItemsFragmentModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(privacyReviewCoreItemsFragmentModel.m5712a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    privacyReviewCoreItemsFragmentModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = privacyReviewCoreItemsFragmentModel.w_();
                int u_ = privacyReviewCoreItemsFragmentModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("nodes");
                    PrivacyReviewCoreItemsFragmentParser.NodesParser.m5796a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(PrivacyReviewCoreItemsFragmentModel.class, new Serializer());
            }
        }

        public PrivacyReviewCoreItemsFragmentModel() {
            super(1);
        }

        @Nonnull
        public final ImmutableList<NodesModel> mo112a() {
            this.f4536d = super.a(this.f4536d, 0, NodesModel.class);
            return (ImmutableList) this.f4536d;
        }

        public final int jK_() {
            return 643956963;
        }

        public final GraphQLVisitableModel m5713a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (mo112a() != null) {
                Builder a = ModelHelper.a(mo112a(), graphQLModelMutatingVisitor);
                if (a != null) {
                    graphQLVisitableModel = (PrivacyReviewCoreItemsFragmentModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f4536d = a.b();
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m5712a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, mo112a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }

    @FragmentModelWithBridge
    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 477821275)
    @JsonSerialize(using = Serializer.class)
    /* compiled from: page/{#%s}/album_list */
    public final class PrivacyReviewCoreSectionDataFragmentModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private String f4537d;
        @Nullable
        private String f4538e;
        @Nullable
        private PrivacyScopeForEditFragmentModel f4539f;

        /* compiled from: page/{#%s}/album_list */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(PrivacyReviewCoreSectionDataFragmentModel.class, new Deserializer());
            }

            public Object m5715a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(PrivacyReviewCoreSectionDataFragmentParser.m5800a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object privacyReviewCoreSectionDataFragmentModel = new PrivacyReviewCoreSectionDataFragmentModel();
                ((BaseModel) privacyReviewCoreSectionDataFragmentModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (privacyReviewCoreSectionDataFragmentModel instanceof Postprocessable) {
                    return ((Postprocessable) privacyReviewCoreSectionDataFragmentModel).a();
                }
                return privacyReviewCoreSectionDataFragmentModel;
            }
        }

        /* compiled from: page/{#%s}/album_list */
        public class Serializer extends JsonSerializer<PrivacyReviewCoreSectionDataFragmentModel> {
            public final void m5716a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                PrivacyReviewCoreSectionDataFragmentModel privacyReviewCoreSectionDataFragmentModel = (PrivacyReviewCoreSectionDataFragmentModel) obj;
                if (privacyReviewCoreSectionDataFragmentModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(privacyReviewCoreSectionDataFragmentModel.m5718a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    privacyReviewCoreSectionDataFragmentModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                PrivacyReviewCoreSectionDataFragmentParser.m5801a(privacyReviewCoreSectionDataFragmentModel.w_(), privacyReviewCoreSectionDataFragmentModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(PrivacyReviewCoreSectionDataFragmentModel.class, new Serializer());
            }
        }

        @Nullable
        public final /* synthetic */ PrivacyScopeForEditFragmentModel m5722c() {
            return m5717j();
        }

        public PrivacyReviewCoreSectionDataFragmentModel() {
            super(3);
        }

        @Nullable
        public final String m5720a() {
            this.f4537d = super.a(this.f4537d, 0);
            return this.f4537d;
        }

        @Nullable
        public final String m5721b() {
            this.f4538e = super.a(this.f4538e, 1);
            return this.f4538e;
        }

        @Nullable
        private PrivacyScopeForEditFragmentModel m5717j() {
            this.f4539f = (PrivacyScopeForEditFragmentModel) super.a(this.f4539f, 2, PrivacyScopeForEditFragmentModel.class);
            return this.f4539f;
        }

        public final int jK_() {
            return -108879344;
        }

        public final GraphQLVisitableModel m5719a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m5717j() != null) {
                PrivacyScopeForEditFragmentModel privacyScopeForEditFragmentModel = (PrivacyScopeForEditFragmentModel) graphQLModelMutatingVisitor.b(m5717j());
                if (m5717j() != privacyScopeForEditFragmentModel) {
                    graphQLVisitableModel = (PrivacyReviewCoreSectionDataFragmentModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f4539f = privacyScopeForEditFragmentModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m5718a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(m5720a());
            int b2 = flatBufferBuilder.b(m5721b());
            int a = ModelHelper.a(flatBufferBuilder, m5717j());
            flatBufferBuilder.c(3);
            flatBufferBuilder.b(0, b);
            flatBufferBuilder.b(1, b2);
            flatBufferBuilder.b(2, a);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 519154443)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: page/{#%s}/album_list */
    public final class PrivacyReviewCoreSectionHeaderFragmentModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private String f4540d;

        /* compiled from: page/{#%s}/album_list */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(PrivacyReviewCoreSectionHeaderFragmentModel.class, new Deserializer());
            }

            public Object m5723a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(PrivacyReviewCoreSectionHeaderFragmentParser.m5802a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object privacyReviewCoreSectionHeaderFragmentModel = new PrivacyReviewCoreSectionHeaderFragmentModel();
                ((BaseModel) privacyReviewCoreSectionHeaderFragmentModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (privacyReviewCoreSectionHeaderFragmentModel instanceof Postprocessable) {
                    return ((Postprocessable) privacyReviewCoreSectionHeaderFragmentModel).a();
                }
                return privacyReviewCoreSectionHeaderFragmentModel;
            }
        }

        /* compiled from: page/{#%s}/album_list */
        public class Serializer extends JsonSerializer<PrivacyReviewCoreSectionHeaderFragmentModel> {
            public final void m5724a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                PrivacyReviewCoreSectionHeaderFragmentModel privacyReviewCoreSectionHeaderFragmentModel = (PrivacyReviewCoreSectionHeaderFragmentModel) obj;
                if (privacyReviewCoreSectionHeaderFragmentModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(privacyReviewCoreSectionHeaderFragmentModel.m5725a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    privacyReviewCoreSectionHeaderFragmentModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                PrivacyReviewCoreSectionHeaderFragmentParser.m5803a(privacyReviewCoreSectionHeaderFragmentModel.w_(), privacyReviewCoreSectionHeaderFragmentModel.u_(), jsonGenerator);
            }

            static {
                FbSerializerProvider.a(PrivacyReviewCoreSectionHeaderFragmentModel.class, new Serializer());
            }
        }

        public PrivacyReviewCoreSectionHeaderFragmentModel() {
            super(1);
        }

        @Nullable
        public final String m5727a() {
            this.f4540d = super.a(this.f4540d, 0);
            return this.f4540d;
        }

        public final int jK_() {
            return -1436183693;
        }

        public final GraphQLVisitableModel m5726a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            h();
            i();
            return this;
        }

        public final int m5725a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(m5727a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, b);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 1373396707)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: page/{#%s}/album_list */
    public final class PrivacyReviewNavigationInfoFragmentModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private String f4541d;
        @Nullable
        private String f4542e;
        @Nullable
        private String f4543f;

        /* compiled from: page/{#%s}/album_list */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(PrivacyReviewNavigationInfoFragmentModel.class, new Deserializer());
            }

            public Object m5728a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(PrivacyReviewNavigationInfoFragmentParser.m5804a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object privacyReviewNavigationInfoFragmentModel = new PrivacyReviewNavigationInfoFragmentModel();
                ((BaseModel) privacyReviewNavigationInfoFragmentModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (privacyReviewNavigationInfoFragmentModel instanceof Postprocessable) {
                    return ((Postprocessable) privacyReviewNavigationInfoFragmentModel).a();
                }
                return privacyReviewNavigationInfoFragmentModel;
            }
        }

        /* compiled from: page/{#%s}/album_list */
        public class Serializer extends JsonSerializer<PrivacyReviewNavigationInfoFragmentModel> {
            public final void m5729a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                PrivacyReviewNavigationInfoFragmentModel privacyReviewNavigationInfoFragmentModel = (PrivacyReviewNavigationInfoFragmentModel) obj;
                if (privacyReviewNavigationInfoFragmentModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(privacyReviewNavigationInfoFragmentModel.m5731a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    privacyReviewNavigationInfoFragmentModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                PrivacyReviewNavigationInfoFragmentParser.m5805a(privacyReviewNavigationInfoFragmentModel.w_(), privacyReviewNavigationInfoFragmentModel.u_(), jsonGenerator);
            }

            static {
                FbSerializerProvider.a(PrivacyReviewNavigationInfoFragmentModel.class, new Serializer());
            }
        }

        public PrivacyReviewNavigationInfoFragmentModel() {
            super(3);
        }

        @Nullable
        public final String m5733a() {
            this.f4541d = super.a(this.f4541d, 0);
            return this.f4541d;
        }

        @Nullable
        public final String m5734j() {
            this.f4542e = super.a(this.f4542e, 1);
            return this.f4542e;
        }

        @Nullable
        private String m5730k() {
            this.f4543f = super.a(this.f4543f, 2);
            return this.f4543f;
        }

        public final int jK_() {
            return -1949282867;
        }

        public final GraphQLVisitableModel m5732a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            h();
            i();
            return this;
        }

        public final int m5731a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(m5733a());
            int b2 = flatBufferBuilder.b(m5734j());
            int b3 = flatBufferBuilder.b(m5730k());
            flatBufferBuilder.c(3);
            flatBufferBuilder.b(0, b);
            flatBufferBuilder.b(1, b2);
            flatBufferBuilder.b(2, b3);
            i();
            return flatBufferBuilder.d();
        }
    }

    @FragmentModelWithBridge
    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -1979464162)
    @JsonSerialize(using = Serializer.class)
    /* compiled from: page/{#%s}/album_list */
    public final class PrivacyScopeForEditFragmentModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private String f4544d;
        @Nullable
        private GraphQLEditablePrivacyScopeType f4545e;
        @Nullable
        private PrivacyCheckupItemPrivacyScopeFragmentModel f4546f;

        /* compiled from: page/{#%s}/album_list */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(PrivacyScopeForEditFragmentModel.class, new Deserializer());
            }

            public Object m5735a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(PrivacyScopeForEditFragmentParser.m5806a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object privacyScopeForEditFragmentModel = new PrivacyScopeForEditFragmentModel();
                ((BaseModel) privacyScopeForEditFragmentModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (privacyScopeForEditFragmentModel instanceof Postprocessable) {
                    return ((Postprocessable) privacyScopeForEditFragmentModel).a();
                }
                return privacyScopeForEditFragmentModel;
            }
        }

        /* compiled from: page/{#%s}/album_list */
        public class Serializer extends JsonSerializer<PrivacyScopeForEditFragmentModel> {
            public final void m5736a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                PrivacyScopeForEditFragmentModel privacyScopeForEditFragmentModel = (PrivacyScopeForEditFragmentModel) obj;
                if (privacyScopeForEditFragmentModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(privacyScopeForEditFragmentModel.m5738a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    privacyScopeForEditFragmentModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                PrivacyScopeForEditFragmentParser.m5807a(privacyScopeForEditFragmentModel.w_(), privacyScopeForEditFragmentModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(PrivacyScopeForEditFragmentModel.class, new Serializer());
            }
        }

        @Nullable
        public final /* synthetic */ PrivacyCheckupItemPrivacyScopeFragmentModel m5742c() {
            return m5737j();
        }

        public PrivacyScopeForEditFragmentModel() {
            super(3);
        }

        @Nullable
        public final String m5740a() {
            this.f4544d = super.a(this.f4544d, 0);
            return this.f4544d;
        }

        @Nullable
        public final GraphQLEditablePrivacyScopeType m5741b() {
            this.f4545e = (GraphQLEditablePrivacyScopeType) super.b(this.f4545e, 1, GraphQLEditablePrivacyScopeType.class, GraphQLEditablePrivacyScopeType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
            return this.f4545e;
        }

        @Nullable
        private PrivacyCheckupItemPrivacyScopeFragmentModel m5737j() {
            this.f4546f = (PrivacyCheckupItemPrivacyScopeFragmentModel) super.a(this.f4546f, 2, PrivacyCheckupItemPrivacyScopeFragmentModel.class);
            return this.f4546f;
        }

        public final int jK_() {
            return 291662087;
        }

        public final GraphQLVisitableModel m5739a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m5737j() != null) {
                PrivacyCheckupItemPrivacyScopeFragmentModel privacyCheckupItemPrivacyScopeFragmentModel = (PrivacyCheckupItemPrivacyScopeFragmentModel) graphQLModelMutatingVisitor.b(m5737j());
                if (m5737j() != privacyCheckupItemPrivacyScopeFragmentModel) {
                    graphQLVisitableModel = (PrivacyScopeForEditFragmentModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f4546f = privacyCheckupItemPrivacyScopeFragmentModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m5738a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(m5740a());
            int a = flatBufferBuilder.a(m5741b());
            int a2 = ModelHelper.a(flatBufferBuilder, m5737j());
            flatBufferBuilder.c(3);
            flatBufferBuilder.b(0, b);
            flatBufferBuilder.b(1, a);
            flatBufferBuilder.b(2, a2);
            i();
            return flatBufferBuilder.d();
        }
    }
}
