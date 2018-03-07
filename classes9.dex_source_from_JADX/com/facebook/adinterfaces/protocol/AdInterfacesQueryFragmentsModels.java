package com.facebook.adinterfaces.protocol;

import com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsParsers.AdAccountAudiencesParser;
import com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsParsers.AdAccountAudiencesParser.AudiencesParser;
import com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsParsers.AdAccountAudiencesParser.AudiencesParser.NodesParser;
import com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsParsers.AdAccountAudiencesParser.AudiencesParser.NodesParser.TargetingSentencesParser;
import com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsParsers.AdAccountBasicFieldsParser;
import com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsParsers.AdAccountBasicFieldsParser.SpendInfoParser;
import com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsParsers.AdAccountBasicFieldsParser.SpendInfoParser.AmountSpentParser;
import com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsParsers.AdAccountBasicFieldsParser.SpendInfoParser.SpendLimitParser;
import com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsParsers.AdAccountBasicFieldsParser.TimezoneInfoParser;
import com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsParsers.AdAccountParser;
import com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsParsers.AdAccountParser.AccountBusinessInfoParser;
import com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsParsers.AdAccountsParser;
import com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsParsers.AdCoverPhotoParser;
import com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsParsers.AdCoverPhotoParser.PhotoParser;
import com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsParsers.AdGeoCircleParser;
import com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsParsers.AdminInfoParser;
import com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsParsers.AvailableAudienceFragmentParser;
import com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsParsers.AvailableAudienceFragmentParser.DefaultSpecParser;
import com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsParsers.AvailableAudienceFragmentParser.DefaultSpecParser.AvailableAudiencesParser;
import com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsParsers.AvailableAudienceFragmentParser.DefaultSpecParser.AvailableAudiencesParser.EdgesParser;
import com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsParsers.BoostedComponentAudienceParser;
import com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsParsers.BoostedComponentCreativeParser;
import com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsParsers.BoostedComponentCreativeParser.CreativeImageParser;
import com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsParsers.BoostedComponentCreativeParser.ObjectStorySpecParser;
import com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsParsers.BoostedComponentCreativeParser.ObjectStorySpecParser.LinkDataParser;
import com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsParsers.BoostedComponentCreativeParser.ObjectStorySpecParser.LinkDataParser.CallToActionParser;
import com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsParsers.BoostedComponentValidationMessageParser;
import com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsParsers.BudgetRecommendationDataParser;
import com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsParsers.BudgetRecommendationParser;
import com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsParsers.BudgetRecommendationsParser;
import com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsParsers.CampaignGroupResultsParser;
import com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsParsers.CampaignGroupResultsParser.LifetimeOverallStatsParser;
import com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsParsers.ConversionPixelParser;
import com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsParsers.CurrencyQuantityParser;
import com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsParsers.EventInfoParser;
import com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsParsers.GeoLocationParser;
import com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsParsers.GeocodeAddressDataParser;
import com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsParsers.InterestParser;
import com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsParsers.IntervalParser;
import com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsParsers.LocalAwarenessAdminInfoParser;
import com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsParsers.LocalAwarenessAdminInfoParser.BoostedLocalAwarenessPromotionsParser;
import com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsParsers.PCTAAvailableAudiencesConnectionParser;
import com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsParsers.PPAvailableAudiencesConnectionParser;
import com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsParsers.PWAvailableAudiencesConnectionParser;
import com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsParsers.PageBaseFieldsParser;
import com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsParsers.PageBaseFieldsParser.AboutParser;
import com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsParsers.PageLikeAdminInfoParser;
import com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsParsers.PageLikeAdminInfoParser.BoostedPageLikePromotionsParser;
import com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsParsers.PhoneNumberParser;
import com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsParsers.PromoteCTAAdminInfoParser;
import com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsParsers.PromoteCTAAdminInfoParser.BoostedCtaPromotionsParser;
import com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsParsers.PromoteProductAdminInfoParser;
import com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsParsers.PromoteProductAdminInfoParser.ProductPromotionsParser;
import com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsParsers.PromoteProductInfoParser;
import com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsParsers.PromoteProductInfoParser.OrderedCollectionsParser;
import com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsParsers.PromoteProductInfoParser.OrderedCollectionsParser.NodesParser.CollectionProductItemsParser;
import com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsParsers.PromoteProductInfoParser.OrderedCollectionsParser.NodesParser.CollectionProductItemsParser.CollectionProductItemsNodesParser;
import com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsParsers.PromoteProductInfoParser.OrderedCollectionsParser.NodesParser.CollectionProductItemsParser.CollectionProductItemsNodesParser.OrderedImagesParser;
import com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsParsers.PromoteWebsiteAdminInfoParser;
import com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsParsers.PromoteWebsiteAdminInfoParser.BoostedWebsitePromotionsParser;
import com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsParsers.ReverseGeocodeDataParser;
import com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsParsers.StoryFeedbackParser;
import com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsParsers.StoryFeedbackParser.LikersParser;
import com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsParsers.StoryFeedbackParser.ResharesParser;
import com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsParsers.StoryFeedbackParser.TopLevelCommentsParser;
import com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsParsers.StoryInsightsParser;
import com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsParsers.StoryPromotionInfoParser;
import com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsParsers.StoryPromotionInfoParser.TargetingDescriptionParser;
import com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsParsers.StoryPromotionInsightsParser;
import com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsParsers.TargetSpecificationsParser;
import com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsParsers.TargetSpecificationsParser.GeoLocationsParser;
import com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsParsers.TargetSpecificationsParser.InterestsParser;
import com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsParsers.TargetingDescriptionParser.TargetingDescriptorsParser;
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
import com.facebook.graphql.enums.GraphQLAdAccountStatus;
import com.facebook.graphql.enums.GraphQLAdGeoLocationType;
import com.facebook.graphql.enums.GraphQLAdsApiPacingType;
import com.facebook.graphql.enums.GraphQLAdsTargetingGender;
import com.facebook.graphql.enums.GraphQLBoostedComponentBudgetType;
import com.facebook.graphql.enums.GraphQLBoostedComponentMessageType;
import com.facebook.graphql.enums.GraphQLBoostedComponentSpecElement;
import com.facebook.graphql.enums.GraphQLBoostedComponentStatus;
import com.facebook.graphql.enums.GraphQLBoostedPostAudienceOption;
import com.facebook.graphql.enums.GraphQLBoostedPostStatus;
import com.facebook.graphql.enums.GraphQLCallToActionType;
import com.facebook.graphql.enums.GraphQLObjectType;
import com.facebook.graphql.model.FeedUnit;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.querybuilder.common.CommonGraphQLModels.DefaultImageFieldsModel;
import com.facebook.graphql.querybuilder.common.TextWithEntitiesGraphQLModels.DefaultTextWithEntitiesLongFieldsModel;
import com.facebook.graphql.visitor.ConsistencyTuple;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLPersistableNode;
import com.facebook.graphql.visitor.GraphQLVisitableConsistentModel;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.facebook.zero.iptest.graphql.ZeroIPTestGraphQLParsers.ZeroIPTestSubmitMutationParser;
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

/* compiled from: ZA */
public class AdInterfacesQueryFragmentsModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 1046709860)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: ZA */
    public final class AdAccountAudiencesModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private AudiencesModel f21942d;

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 1172416534)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: ZA */
        public final class AudiencesModel extends BaseModel implements GraphQLVisitableModel {
            private int f21940d;
            @Nullable
            private List<NodesModel> f21941e;

            /* compiled from: ZA */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(AudiencesModel.class, new Deserializer());
                }

                public Object m23057a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(AudiencesParser.m23754a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object audiencesModel = new AudiencesModel();
                    ((BaseModel) audiencesModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (audiencesModel instanceof Postprocessable) {
                        return ((Postprocessable) audiencesModel).a();
                    }
                    return audiencesModel;
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = -1957160398)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: ZA */
            public final class NodesModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel {
                @Nullable
                private GraphQLObjectType f21936d;
                @Nullable
                private String f21937e;
                @Nullable
                private String f21938f;
                @Nullable
                private List<TargetingSentencesModel> f21939g;

                /* compiled from: ZA */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(NodesModel.class, new Deserializer());
                    }

                    public Object m23058a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(NodesParser.m23752b(jsonParser, flatBufferBuilder));
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

                /* compiled from: ZA */
                public class Serializer extends JsonSerializer<NodesModel> {
                    public final void m23059a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        NodesModel nodesModel = (NodesModel) obj;
                        if (nodesModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(nodesModel.m23067a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            nodesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        NodesParser.m23753b(nodesModel.w_(), nodesModel.u_(), jsonGenerator, serializerProvider);
                    }

                    static {
                        FbSerializerProvider.a(NodesModel.class, new Serializer());
                    }
                }

                @JsonDeserialize(using = Deserializer.class)
                @ModelWithFlatBufferFormatHash(a = -1176734575)
                @JsonSerialize(using = Serializer.class)
                @FragmentModelWithoutBridge
                /* compiled from: ZA */
                public final class TargetingSentencesModel extends BaseModel implements GraphQLVisitableModel {
                    @Nullable
                    private String f21934d;
                    @Nullable
                    private List<String> f21935e;

                    /* compiled from: ZA */
                    public class Deserializer extends FbJsonDeserializer {
                        static {
                            GlobalAutoGenDeserializerCache.a(TargetingSentencesModel.class, new Deserializer());
                        }

                        public Object m23060a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(TargetingSentencesParser.m23751b(jsonParser, flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            mutableFlatBuffer.a(4, Boolean.valueOf(true));
                            MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                            Object targetingSentencesModel = new TargetingSentencesModel();
                            ((BaseModel) targetingSentencesModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                            if (targetingSentencesModel instanceof Postprocessable) {
                                return ((Postprocessable) targetingSentencesModel).a();
                            }
                            return targetingSentencesModel;
                        }
                    }

                    /* compiled from: ZA */
                    public class Serializer extends JsonSerializer<TargetingSentencesModel> {
                        public final void m23061a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                            TargetingSentencesModel targetingSentencesModel = (TargetingSentencesModel) obj;
                            if (targetingSentencesModel.w_() == null) {
                                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                flatBufferBuilder.d(targetingSentencesModel.m23062a(flatBufferBuilder));
                                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                wrap.position(0);
                                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                targetingSentencesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                            }
                            ZeroIPTestSubmitMutationParser.a(targetingSentencesModel.w_(), targetingSentencesModel.u_(), jsonGenerator);
                        }

                        static {
                            FbSerializerProvider.a(TargetingSentencesModel.class, new Serializer());
                        }
                    }

                    public TargetingSentencesModel() {
                        super(2);
                    }

                    @Nullable
                    public final String m23064a() {
                        this.f21934d = super.a(this.f21934d, 0);
                        return this.f21934d;
                    }

                    @Nonnull
                    public final ImmutableList<String> m23065j() {
                        this.f21935e = super.a(this.f21935e, 1);
                        return (ImmutableList) this.f21935e;
                    }

                    public final int jK_() {
                        return 1801834545;
                    }

                    public final GraphQLVisitableModel m23063a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                        h();
                        i();
                        return this;
                    }

                    public final int m23062a(FlatBufferBuilder flatBufferBuilder) {
                        h();
                        int b = flatBufferBuilder.b(m23064a());
                        int c = flatBufferBuilder.c(m23065j());
                        flatBufferBuilder.c(2);
                        flatBufferBuilder.b(0, b);
                        flatBufferBuilder.b(1, c);
                        i();
                        return flatBufferBuilder.d();
                    }
                }

                public NodesModel() {
                    super(4);
                }

                @Nullable
                private GraphQLObjectType m23066m() {
                    if (this.b != null && this.f21936d == null) {
                        this.f21936d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
                    }
                    return this.f21936d;
                }

                @Nullable
                public final String m23070j() {
                    this.f21937e = super.a(this.f21937e, 1);
                    return this.f21937e;
                }

                @Nullable
                public final String m23071k() {
                    this.f21938f = super.a(this.f21938f, 2);
                    return this.f21938f;
                }

                @Nonnull
                public final ImmutableList<TargetingSentencesModel> m23072l() {
                    this.f21939g = super.a(this.f21939g, 3, TargetingSentencesModel.class);
                    return (ImmutableList) this.f21939g;
                }

                @Nullable
                public final String m23069a() {
                    return m23070j();
                }

                public final int jK_() {
                    return 1040272932;
                }

                public final GraphQLVisitableModel m23068a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    GraphQLVisitableModel graphQLVisitableModel = null;
                    h();
                    if (m23072l() != null) {
                        Builder a = ModelHelper.a(m23072l(), graphQLModelMutatingVisitor);
                        if (a != null) {
                            graphQLVisitableModel = (NodesModel) ModelHelper.a(null, this);
                            graphQLVisitableModel.f21939g = a.b();
                        }
                    }
                    i();
                    return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                }

                public final int m23067a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int a = ModelHelper.a(flatBufferBuilder, m23066m());
                    int b = flatBufferBuilder.b(m23070j());
                    int b2 = flatBufferBuilder.b(m23071k());
                    int a2 = ModelHelper.a(flatBufferBuilder, m23072l());
                    flatBufferBuilder.c(4);
                    flatBufferBuilder.b(0, a);
                    flatBufferBuilder.b(1, b);
                    flatBufferBuilder.b(2, b2);
                    flatBufferBuilder.b(3, a2);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            /* compiled from: ZA */
            public class Serializer extends JsonSerializer<AudiencesModel> {
                public final void m23073a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    AudiencesModel audiencesModel = (AudiencesModel) obj;
                    if (audiencesModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(audiencesModel.m23075a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        audiencesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    AudiencesParser.m23755a(audiencesModel.w_(), audiencesModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(AudiencesModel.class, new Serializer());
                }
            }

            public AudiencesModel() {
                super(2);
            }

            public final int m23074a() {
                a(0, 0);
                return this.f21940d;
            }

            @Nonnull
            public final ImmutableList<NodesModel> m23078j() {
                this.f21941e = super.a(this.f21941e, 1, NodesModel.class);
                return (ImmutableList) this.f21941e;
            }

            public final int jK_() {
                return 1597135808;
            }

            public final GraphQLVisitableModel m23076a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m23078j() != null) {
                    Builder a = ModelHelper.a(m23078j(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        graphQLVisitableModel = (AudiencesModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f21941e = a.b();
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m23075a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m23078j());
                flatBufferBuilder.c(2);
                flatBufferBuilder.a(0, this.f21940d, 0);
                flatBufferBuilder.b(1, a);
                i();
                return flatBufferBuilder.d();
            }

            public final void m23077a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                super.a(mutableFlatBuffer, i, obj);
                this.f21940d = mutableFlatBuffer.a(i, 0, 0);
            }
        }

        /* compiled from: ZA */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(AdAccountAudiencesModel.class, new Deserializer());
            }

            public Object m23079a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = AdAccountAudiencesParser.m23756a(jsonParser);
                Object adAccountAudiencesModel = new AdAccountAudiencesModel();
                ((BaseModel) adAccountAudiencesModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (adAccountAudiencesModel instanceof Postprocessable) {
                    return ((Postprocessable) adAccountAudiencesModel).a();
                }
                return adAccountAudiencesModel;
            }
        }

        /* compiled from: ZA */
        public class Serializer extends JsonSerializer<AdAccountAudiencesModel> {
            public final void m23080a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                AdAccountAudiencesModel adAccountAudiencesModel = (AdAccountAudiencesModel) obj;
                if (adAccountAudiencesModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(adAccountAudiencesModel.m23081a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    adAccountAudiencesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = adAccountAudiencesModel.w_();
                int u_ = adAccountAudiencesModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("audiences");
                    AudiencesParser.m23755a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(AdAccountAudiencesModel.class, new Serializer());
            }
        }

        public AdAccountAudiencesModel() {
            super(1);
        }

        @Nullable
        public final AudiencesModel m23082a() {
            this.f21942d = (AudiencesModel) super.a(this.f21942d, 0, AudiencesModel.class);
            return this.f21942d;
        }

        public final int jK_() {
            return 1449252970;
        }

        public final GraphQLVisitableModel m23083a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m23082a() != null) {
                AudiencesModel audiencesModel = (AudiencesModel) graphQLModelMutatingVisitor.b(m23082a());
                if (m23082a() != audiencesModel) {
                    graphQLVisitableModel = (AdAccountAudiencesModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f21942d = audiencesModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m23081a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m23082a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -1279437003)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: ZA */
    public final class AdAccountBasicFieldsModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel {
        @Nullable
        private String f21952d;
        @Nullable
        private CurrencyQuantityModel f21953e;
        private boolean f21954f;
        @Nullable
        private String f21955g;
        @Nullable
        private String f21956h;
        @Nullable
        private String f21957i;
        @Nullable
        private String f21958j;
        @Nullable
        private SpendInfoModel f21959k;
        @Nullable
        private TimezoneInfoModel f21960l;

        /* compiled from: ZA */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(AdAccountBasicFieldsModel.class, new Deserializer());
            }

            public Object m23084a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(AdAccountBasicFieldsParser.m23765a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object adAccountBasicFieldsModel = new AdAccountBasicFieldsModel();
                ((BaseModel) adAccountBasicFieldsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (adAccountBasicFieldsModel instanceof Postprocessable) {
                    return ((Postprocessable) adAccountBasicFieldsModel).a();
                }
                return adAccountBasicFieldsModel;
            }
        }

        /* compiled from: ZA */
        public class Serializer extends JsonSerializer<AdAccountBasicFieldsModel> {
            public final void m23085a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                AdAccountBasicFieldsModel adAccountBasicFieldsModel = (AdAccountBasicFieldsModel) obj;
                if (adAccountBasicFieldsModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(adAccountBasicFieldsModel.m23116a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    adAccountBasicFieldsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                AdAccountBasicFieldsParser.m23766a(adAccountBasicFieldsModel.w_(), adAccountBasicFieldsModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(AdAccountBasicFieldsModel.class, new Serializer());
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -527302723)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: ZA */
        public final class SpendInfoModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private AmountSpentModel f21949d;
            @Nullable
            private SpendLimitModel f21950e;

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = -1404649757)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: ZA */
            public final class AmountSpentModel extends BaseModel implements GraphQLVisitableModel {
                @Nullable
                private String f21943d;
                private int f21944e;
                @Nullable
                private String f21945f;

                /* compiled from: ZA */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(AmountSpentModel.class, new Deserializer());
                    }

                    public Object m23086a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(AmountSpentParser.m23757a(jsonParser, flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                        Object amountSpentModel = new AmountSpentModel();
                        ((BaseModel) amountSpentModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                        if (amountSpentModel instanceof Postprocessable) {
                            return ((Postprocessable) amountSpentModel).a();
                        }
                        return amountSpentModel;
                    }
                }

                /* compiled from: ZA */
                public class Serializer extends JsonSerializer<AmountSpentModel> {
                    public final void m23087a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        AmountSpentModel amountSpentModel = (AmountSpentModel) obj;
                        if (amountSpentModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(amountSpentModel.m23089a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            amountSpentModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        AmountSpentParser.m23758a(amountSpentModel.w_(), amountSpentModel.u_(), jsonGenerator);
                    }

                    static {
                        FbSerializerProvider.a(AmountSpentModel.class, new Serializer());
                    }
                }

                public AmountSpentModel() {
                    super(3);
                }

                @Nullable
                private String m23088j() {
                    this.f21943d = super.a(this.f21943d, 0);
                    return this.f21943d;
                }

                @Nullable
                public final String m23091a() {
                    this.f21945f = super.a(this.f21945f, 2);
                    return this.f21945f;
                }

                public final int jK_() {
                    return 753818588;
                }

                public final GraphQLVisitableModel m23090a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    h();
                    i();
                    return this;
                }

                public final int m23089a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int b = flatBufferBuilder.b(m23088j());
                    int b2 = flatBufferBuilder.b(m23091a());
                    flatBufferBuilder.c(3);
                    flatBufferBuilder.b(0, b);
                    flatBufferBuilder.a(1, this.f21944e, 0);
                    flatBufferBuilder.b(2, b2);
                    i();
                    return flatBufferBuilder.d();
                }

                public final void m23092a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                    super.a(mutableFlatBuffer, i, obj);
                    this.f21944e = mutableFlatBuffer.a(i, 1, 0);
                }
            }

            /* compiled from: ZA */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(SpendInfoModel.class, new Deserializer());
                }

                public Object m23093a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(SpendInfoParser.m23761a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object spendInfoModel = new SpendInfoModel();
                    ((BaseModel) spendInfoModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (spendInfoModel instanceof Postprocessable) {
                        return ((Postprocessable) spendInfoModel).a();
                    }
                    return spendInfoModel;
                }
            }

            /* compiled from: ZA */
            public class Serializer extends JsonSerializer<SpendInfoModel> {
                public final void m23094a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    SpendInfoModel spendInfoModel = (SpendInfoModel) obj;
                    if (spendInfoModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(spendInfoModel.m23102a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        spendInfoModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    SpendInfoParser.m23762a(spendInfoModel.w_(), spendInfoModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(SpendInfoModel.class, new Serializer());
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = -1404649757)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: ZA */
            public final class SpendLimitModel extends BaseModel implements GraphQLVisitableModel {
                @Nullable
                private String f21946d;
                private int f21947e;
                @Nullable
                private String f21948f;

                /* compiled from: ZA */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(SpendLimitModel.class, new Deserializer());
                    }

                    public Object m23095a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(SpendLimitParser.m23759a(jsonParser, flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                        Object spendLimitModel = new SpendLimitModel();
                        ((BaseModel) spendLimitModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                        if (spendLimitModel instanceof Postprocessable) {
                            return ((Postprocessable) spendLimitModel).a();
                        }
                        return spendLimitModel;
                    }
                }

                /* compiled from: ZA */
                public class Serializer extends JsonSerializer<SpendLimitModel> {
                    public final void m23096a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        SpendLimitModel spendLimitModel = (SpendLimitModel) obj;
                        if (spendLimitModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(spendLimitModel.m23098a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            spendLimitModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        SpendLimitParser.m23760a(spendLimitModel.w_(), spendLimitModel.u_(), jsonGenerator);
                    }

                    static {
                        FbSerializerProvider.a(SpendLimitModel.class, new Serializer());
                    }
                }

                public SpendLimitModel() {
                    super(3);
                }

                @Nullable
                private String m23097j() {
                    this.f21946d = super.a(this.f21946d, 0);
                    return this.f21946d;
                }

                @Nullable
                public final String m23100a() {
                    this.f21948f = super.a(this.f21948f, 2);
                    return this.f21948f;
                }

                public final int jK_() {
                    return 753818588;
                }

                public final GraphQLVisitableModel m23099a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    h();
                    i();
                    return this;
                }

                public final int m23098a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int b = flatBufferBuilder.b(m23097j());
                    int b2 = flatBufferBuilder.b(m23100a());
                    flatBufferBuilder.c(3);
                    flatBufferBuilder.b(0, b);
                    flatBufferBuilder.a(1, this.f21947e, 0);
                    flatBufferBuilder.b(2, b2);
                    i();
                    return flatBufferBuilder.d();
                }

                public final void m23101a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                    super.a(mutableFlatBuffer, i, obj);
                    this.f21947e = mutableFlatBuffer.a(i, 1, 0);
                }
            }

            public SpendInfoModel() {
                super(2);
            }

            @Nullable
            public final AmountSpentModel m23103a() {
                this.f21949d = (AmountSpentModel) super.a(this.f21949d, 0, AmountSpentModel.class);
                return this.f21949d;
            }

            @Nullable
            public final SpendLimitModel m23105j() {
                this.f21950e = (SpendLimitModel) super.a(this.f21950e, 1, SpendLimitModel.class);
                return this.f21950e;
            }

            public final int jK_() {
                return -1988355614;
            }

            public final GraphQLVisitableModel m23104a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m23103a() != null) {
                    AmountSpentModel amountSpentModel = (AmountSpentModel) graphQLModelMutatingVisitor.b(m23103a());
                    if (m23103a() != amountSpentModel) {
                        graphQLVisitableModel = (SpendInfoModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f21949d = amountSpentModel;
                    }
                }
                if (m23105j() != null) {
                    SpendLimitModel spendLimitModel = (SpendLimitModel) graphQLModelMutatingVisitor.b(m23105j());
                    if (m23105j() != spendLimitModel) {
                        graphQLVisitableModel = (SpendInfoModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f21950e = spendLimitModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m23102a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m23103a());
                int a2 = ModelHelper.a(flatBufferBuilder, m23105j());
                flatBufferBuilder.c(2);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.b(1, a2);
                i();
                return flatBufferBuilder.d();
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 855047979)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: ZA */
        public final class TimezoneInfoModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private String f21951d;

            /* compiled from: ZA */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(TimezoneInfoModel.class, new Deserializer());
                }

                public Object m23106a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(TimezoneInfoParser.m23763a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object timezoneInfoModel = new TimezoneInfoModel();
                    ((BaseModel) timezoneInfoModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (timezoneInfoModel instanceof Postprocessable) {
                        return ((Postprocessable) timezoneInfoModel).a();
                    }
                    return timezoneInfoModel;
                }
            }

            /* compiled from: ZA */
            public class Serializer extends JsonSerializer<TimezoneInfoModel> {
                public final void m23107a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    TimezoneInfoModel timezoneInfoModel = (TimezoneInfoModel) obj;
                    if (timezoneInfoModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(timezoneInfoModel.m23108a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        timezoneInfoModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    TimezoneInfoParser.m23764a(timezoneInfoModel.w_(), timezoneInfoModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(TimezoneInfoModel.class, new Serializer());
                }
            }

            public TimezoneInfoModel() {
                super(1);
            }

            @Nullable
            public final String m23110a() {
                this.f21951d = super.a(this.f21951d, 0);
                return this.f21951d;
            }

            public final int jK_() {
                return 1290195047;
            }

            public final GraphQLVisitableModel m23109a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m23108a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m23110a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, b);
                i();
                return flatBufferBuilder.d();
            }
        }

        public AdAccountBasicFieldsModel() {
            super(9);
        }

        @Nullable
        private String m23111m() {
            this.f21952d = super.a(this.f21952d, 0);
            return this.f21952d;
        }

        @Nullable
        private CurrencyQuantityModel m23112n() {
            this.f21953e = (CurrencyQuantityModel) super.a(this.f21953e, 1, CurrencyQuantityModel.class);
            return this.f21953e;
        }

        @Nullable
        private String m23113o() {
            this.f21955g = super.a(this.f21955g, 3);
            return this.f21955g;
        }

        @Nullable
        public final String m23120j() {
            this.f21956h = super.a(this.f21956h, 4);
            return this.f21956h;
        }

        @Nullable
        public final String m23121k() {
            this.f21957i = super.a(this.f21957i, 5);
            return this.f21957i;
        }

        @Nullable
        public final String m23122l() {
            this.f21958j = super.a(this.f21958j, 6);
            return this.f21958j;
        }

        @Nullable
        private SpendInfoModel m23114p() {
            this.f21959k = (SpendInfoModel) super.a(this.f21959k, 7, SpendInfoModel.class);
            return this.f21959k;
        }

        @Nullable
        private TimezoneInfoModel m23115q() {
            this.f21960l = (TimezoneInfoModel) super.a(this.f21960l, 8, TimezoneInfoModel.class);
            return this.f21960l;
        }

        @Nullable
        public final String m23118a() {
            return m23113o();
        }

        public final int jK_() {
            return 1449252970;
        }

        public final GraphQLVisitableModel m23117a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m23112n() != null) {
                CurrencyQuantityModel currencyQuantityModel = (CurrencyQuantityModel) graphQLModelMutatingVisitor.b(m23112n());
                if (m23112n() != currencyQuantityModel) {
                    graphQLVisitableModel = (AdAccountBasicFieldsModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f21953e = currencyQuantityModel;
                }
            }
            if (m23114p() != null) {
                SpendInfoModel spendInfoModel = (SpendInfoModel) graphQLModelMutatingVisitor.b(m23114p());
                if (m23114p() != spendInfoModel) {
                    graphQLVisitableModel = (AdAccountBasicFieldsModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f21959k = spendInfoModel;
                }
            }
            if (m23115q() != null) {
                TimezoneInfoModel timezoneInfoModel = (TimezoneInfoModel) graphQLModelMutatingVisitor.b(m23115q());
                if (m23115q() != timezoneInfoModel) {
                    graphQLVisitableModel = (AdAccountBasicFieldsModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f21960l = timezoneInfoModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m23116a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(m23111m());
            int a = ModelHelper.a(flatBufferBuilder, m23112n());
            int b2 = flatBufferBuilder.b(m23113o());
            int b3 = flatBufferBuilder.b(m23120j());
            int b4 = flatBufferBuilder.b(m23121k());
            int b5 = flatBufferBuilder.b(m23122l());
            int a2 = ModelHelper.a(flatBufferBuilder, m23114p());
            int a3 = ModelHelper.a(flatBufferBuilder, m23115q());
            flatBufferBuilder.c(9);
            flatBufferBuilder.b(0, b);
            flatBufferBuilder.b(1, a);
            flatBufferBuilder.a(2, this.f21954f);
            flatBufferBuilder.b(3, b2);
            flatBufferBuilder.b(4, b3);
            flatBufferBuilder.b(5, b4);
            flatBufferBuilder.b(6, b5);
            flatBufferBuilder.b(7, a2);
            flatBufferBuilder.b(8, a3);
            i();
            return flatBufferBuilder.d();
        }

        public final void m23119a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
            super.a(mutableFlatBuffer, i, obj);
            this.f21954f = mutableFlatBuffer.a(i, 2);
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 690756425)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: ZA */
    public final class AdAccountModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel {
        @Nullable
        private AccountBusinessInfoModel f21962d;
        @Nullable
        private String f21963e;
        @Nullable
        private GraphQLAdAccountStatus f21964f;
        @Nullable
        private CurrencyQuantityModel f21965g;
        @Nullable
        private AudiencesModel f21966h;
        @Nullable
        private CurrencyQuantityModel f21967i;
        private boolean f21968j;
        @Nullable
        private List<ConversionPixelModel> f21969k;
        private boolean f21970l;
        @Nullable
        private String f21971m;
        @Nullable
        private String f21972n;
        @Nullable
        private CurrencyQuantityModel f21973o;
        @Nullable
        private CurrencyQuantityModel f21974p;
        @Nullable
        private String f21975q;
        @Nullable
        private String f21976r;
        @Nullable
        private CurrencyQuantityModel f21977s;
        @Nullable
        private SpendInfoModel f21978t;
        @Nullable
        private String f21979u;
        @Nullable
        private TimezoneInfoModel f21980v;

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 1983580092)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: ZA */
        public final class AccountBusinessInfoModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private String f21961d;

            /* compiled from: ZA */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(AccountBusinessInfoModel.class, new Deserializer());
                }

                public Object m23123a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(AccountBusinessInfoParser.m23767a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object accountBusinessInfoModel = new AccountBusinessInfoModel();
                    ((BaseModel) accountBusinessInfoModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (accountBusinessInfoModel instanceof Postprocessable) {
                        return ((Postprocessable) accountBusinessInfoModel).a();
                    }
                    return accountBusinessInfoModel;
                }
            }

            /* compiled from: ZA */
            public class Serializer extends JsonSerializer<AccountBusinessInfoModel> {
                public final void m23124a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    AccountBusinessInfoModel accountBusinessInfoModel = (AccountBusinessInfoModel) obj;
                    if (accountBusinessInfoModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(accountBusinessInfoModel.m23125a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        accountBusinessInfoModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    AccountBusinessInfoParser.m23768a(accountBusinessInfoModel.w_(), accountBusinessInfoModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(AccountBusinessInfoModel.class, new Serializer());
                }
            }

            public AccountBusinessInfoModel() {
                super(1);
            }

            @Nullable
            public final String m23127a() {
                this.f21961d = super.a(this.f21961d, 0);
                return this.f21961d;
            }

            public final int jK_() {
                return -28600808;
            }

            public final GraphQLVisitableModel m23126a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m23125a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m23127a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, b);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: ZA */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(AdAccountModel.class, new Deserializer());
            }

            public Object m23128a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(AdAccountParser.m23769b(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object adAccountModel = new AdAccountModel();
                ((BaseModel) adAccountModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (adAccountModel instanceof Postprocessable) {
                    return ((Postprocessable) adAccountModel).a();
                }
                return adAccountModel;
            }
        }

        /* compiled from: ZA */
        public class Serializer extends JsonSerializer<AdAccountModel> {
            public final void m23129a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                AdAccountModel adAccountModel = (AdAccountModel) obj;
                if (adAccountModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(adAccountModel.m23132a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    adAccountModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                AdAccountParser.m23770b(adAccountModel.w_(), adAccountModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(AdAccountModel.class, new Serializer());
            }
        }

        public AdAccountModel() {
            super(19);
        }

        @Nullable
        public final AccountBusinessInfoModel m23136j() {
            this.f21962d = (AccountBusinessInfoModel) super.a(this.f21962d, 0, AccountBusinessInfoModel.class);
            return this.f21962d;
        }

        @Nullable
        public final String m23137k() {
            this.f21963e = super.a(this.f21963e, 1);
            return this.f21963e;
        }

        @Nullable
        public final GraphQLAdAccountStatus m23138l() {
            this.f21964f = (GraphQLAdAccountStatus) super.b(this.f21964f, 2, GraphQLAdAccountStatus.class, GraphQLAdAccountStatus.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
            return this.f21964f;
        }

        @Nullable
        public final CurrencyQuantityModel m23139m() {
            this.f21965g = (CurrencyQuantityModel) super.a(this.f21965g, 3, CurrencyQuantityModel.class);
            return this.f21965g;
        }

        @Nullable
        public final AudiencesModel m23140n() {
            this.f21966h = (AudiencesModel) super.a(this.f21966h, 4, AudiencesModel.class);
            return this.f21966h;
        }

        @Nullable
        public final CurrencyQuantityModel m23141o() {
            this.f21967i = (CurrencyQuantityModel) super.a(this.f21967i, 5, CurrencyQuantityModel.class);
            return this.f21967i;
        }

        public final boolean m23142p() {
            a(0, 6);
            return this.f21968j;
        }

        @Nonnull
        public final ImmutableList<ConversionPixelModel> m23143q() {
            this.f21969k = super.a(this.f21969k, 7, ConversionPixelModel.class);
            return (ImmutableList) this.f21969k;
        }

        public final boolean m23144r() {
            a(1, 0);
            return this.f21970l;
        }

        @Nullable
        public final String m23145s() {
            this.f21971m = super.a(this.f21971m, 9);
            return this.f21971m;
        }

        @Nullable
        public final String m23146t() {
            this.f21972n = super.a(this.f21972n, 10);
            return this.f21972n;
        }

        @Nullable
        public final CurrencyQuantityModel m23147u() {
            this.f21973o = (CurrencyQuantityModel) super.a(this.f21973o, 11, CurrencyQuantityModel.class);
            return this.f21973o;
        }

        @Nullable
        public final CurrencyQuantityModel m23148v() {
            this.f21974p = (CurrencyQuantityModel) super.a(this.f21974p, 12, CurrencyQuantityModel.class);
            return this.f21974p;
        }

        @Nullable
        public final String m23149w() {
            this.f21975q = super.a(this.f21975q, 13);
            return this.f21975q;
        }

        @Nullable
        public final String m23150x() {
            this.f21976r = super.a(this.f21976r, 14);
            return this.f21976r;
        }

        @Nullable
        private CurrencyQuantityModel m23130B() {
            this.f21977s = (CurrencyQuantityModel) super.a(this.f21977s, 15, CurrencyQuantityModel.class);
            return this.f21977s;
        }

        @Nullable
        public final SpendInfoModel m23151y() {
            this.f21978t = (SpendInfoModel) super.a(this.f21978t, 16, SpendInfoModel.class);
            return this.f21978t;
        }

        @Nullable
        public final String m23152z() {
            this.f21979u = super.a(this.f21979u, 17);
            return this.f21979u;
        }

        @Nullable
        public final TimezoneInfoModel m23131A() {
            this.f21980v = (TimezoneInfoModel) super.a(this.f21980v, 18, TimezoneInfoModel.class);
            return this.f21980v;
        }

        @Nullable
        public final String m23134a() {
            return m23145s();
        }

        public final int jK_() {
            return 1449252970;
        }

        public final GraphQLVisitableModel m23133a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            CurrencyQuantityModel currencyQuantityModel;
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m23136j() != null) {
                AccountBusinessInfoModel accountBusinessInfoModel = (AccountBusinessInfoModel) graphQLModelMutatingVisitor.b(m23136j());
                if (m23136j() != accountBusinessInfoModel) {
                    graphQLVisitableModel = (AdAccountModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f21962d = accountBusinessInfoModel;
                }
            }
            if (m23139m() != null) {
                currencyQuantityModel = (CurrencyQuantityModel) graphQLModelMutatingVisitor.b(m23139m());
                if (m23139m() != currencyQuantityModel) {
                    graphQLVisitableModel = (AdAccountModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f21965g = currencyQuantityModel;
                }
            }
            if (m23140n() != null) {
                AudiencesModel audiencesModel = (AudiencesModel) graphQLModelMutatingVisitor.b(m23140n());
                if (m23140n() != audiencesModel) {
                    graphQLVisitableModel = (AdAccountModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f21966h = audiencesModel;
                }
            }
            if (m23141o() != null) {
                currencyQuantityModel = (CurrencyQuantityModel) graphQLModelMutatingVisitor.b(m23141o());
                if (m23141o() != currencyQuantityModel) {
                    graphQLVisitableModel = (AdAccountModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f21967i = currencyQuantityModel;
                }
            }
            if (m23143q() != null) {
                Builder a = ModelHelper.a(m23143q(), graphQLModelMutatingVisitor);
                if (a != null) {
                    AdAccountModel adAccountModel = (AdAccountModel) ModelHelper.a(graphQLVisitableModel, this);
                    adAccountModel.f21969k = a.b();
                    graphQLVisitableModel = adAccountModel;
                }
            }
            if (m23147u() != null) {
                currencyQuantityModel = (CurrencyQuantityModel) graphQLModelMutatingVisitor.b(m23147u());
                if (m23147u() != currencyQuantityModel) {
                    graphQLVisitableModel = (AdAccountModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f21973o = currencyQuantityModel;
                }
            }
            if (m23148v() != null) {
                currencyQuantityModel = (CurrencyQuantityModel) graphQLModelMutatingVisitor.b(m23148v());
                if (m23148v() != currencyQuantityModel) {
                    graphQLVisitableModel = (AdAccountModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f21974p = currencyQuantityModel;
                }
            }
            if (m23130B() != null) {
                currencyQuantityModel = (CurrencyQuantityModel) graphQLModelMutatingVisitor.b(m23130B());
                if (m23130B() != currencyQuantityModel) {
                    graphQLVisitableModel = (AdAccountModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f21977s = currencyQuantityModel;
                }
            }
            if (m23151y() != null) {
                SpendInfoModel spendInfoModel = (SpendInfoModel) graphQLModelMutatingVisitor.b(m23151y());
                if (m23151y() != spendInfoModel) {
                    graphQLVisitableModel = (AdAccountModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f21978t = spendInfoModel;
                }
            }
            if (m23131A() != null) {
                TimezoneInfoModel timezoneInfoModel = (TimezoneInfoModel) graphQLModelMutatingVisitor.b(m23131A());
                if (m23131A() != timezoneInfoModel) {
                    graphQLVisitableModel = (AdAccountModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f21980v = timezoneInfoModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m23132a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m23136j());
            int b = flatBufferBuilder.b(m23137k());
            int a2 = flatBufferBuilder.a(m23138l());
            int a3 = ModelHelper.a(flatBufferBuilder, m23139m());
            int a4 = ModelHelper.a(flatBufferBuilder, m23140n());
            int a5 = ModelHelper.a(flatBufferBuilder, m23141o());
            int a6 = ModelHelper.a(flatBufferBuilder, m23143q());
            int b2 = flatBufferBuilder.b(m23145s());
            int b3 = flatBufferBuilder.b(m23146t());
            int a7 = ModelHelper.a(flatBufferBuilder, m23147u());
            int a8 = ModelHelper.a(flatBufferBuilder, m23148v());
            int b4 = flatBufferBuilder.b(m23149w());
            int b5 = flatBufferBuilder.b(m23150x());
            int a9 = ModelHelper.a(flatBufferBuilder, m23130B());
            int a10 = ModelHelper.a(flatBufferBuilder, m23151y());
            int b6 = flatBufferBuilder.b(m23152z());
            int a11 = ModelHelper.a(flatBufferBuilder, m23131A());
            flatBufferBuilder.c(19);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, b);
            flatBufferBuilder.b(2, a2);
            flatBufferBuilder.b(3, a3);
            flatBufferBuilder.b(4, a4);
            flatBufferBuilder.b(5, a5);
            flatBufferBuilder.a(6, this.f21968j);
            flatBufferBuilder.b(7, a6);
            flatBufferBuilder.a(8, this.f21970l);
            flatBufferBuilder.b(9, b2);
            flatBufferBuilder.b(10, b3);
            flatBufferBuilder.b(11, a7);
            flatBufferBuilder.b(12, a8);
            flatBufferBuilder.b(13, b4);
            flatBufferBuilder.b(14, b5);
            flatBufferBuilder.b(15, a9);
            flatBufferBuilder.b(16, a10);
            flatBufferBuilder.b(17, b6);
            flatBufferBuilder.b(18, a11);
            i();
            return flatBufferBuilder.d();
        }

        public final void m23135a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
            super.a(mutableFlatBuffer, i, obj);
            this.f21968j = mutableFlatBuffer.a(i, 6);
            this.f21970l = mutableFlatBuffer.a(i, 8);
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -219643379)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: ZA */
    public final class AdAccountsModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private List<AdAccountModel> f21982d;

        /* compiled from: ZA */
        public final class Builder {
            @Nullable
            public ImmutableList<AdAccountModel> f21981a;

            public final AdAccountsModel m23153a() {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                int a = ModelHelper.a(flatBufferBuilder, this.f21981a);
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.d(flatBufferBuilder.d());
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                return new AdAccountsModel(new MutableFlatBuffer(wrap, null, null, true, null));
            }
        }

        /* compiled from: ZA */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(AdAccountsModel.class, new Deserializer());
            }

            public Object m23154a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(AdAccountsParser.m23771a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object adAccountsModel = new AdAccountsModel();
                ((BaseModel) adAccountsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (adAccountsModel instanceof Postprocessable) {
                    return ((Postprocessable) adAccountsModel).a();
                }
                return adAccountsModel;
            }
        }

        /* compiled from: ZA */
        public class Serializer extends JsonSerializer<AdAccountsModel> {
            public final void m23155a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                AdAccountsModel adAccountsModel = (AdAccountsModel) obj;
                if (adAccountsModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(adAccountsModel.m23156a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    adAccountsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                AdAccountsParser.m23772a(adAccountsModel.w_(), adAccountsModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(AdAccountsModel.class, new Serializer());
            }
        }

        public AdAccountsModel() {
            super(1);
        }

        public AdAccountsModel(MutableFlatBuffer mutableFlatBuffer) {
            super(1);
            a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
        }

        @Nonnull
        public final ImmutableList<AdAccountModel> m23158a() {
            this.f21982d = super.a(this.f21982d, 0, AdAccountModel.class);
            return (ImmutableList) this.f21982d;
        }

        public final int jK_() {
            return 1086675513;
        }

        public final GraphQLVisitableModel m23157a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m23158a() != null) {
                com.google.common.collect.ImmutableList.Builder a = ModelHelper.a(m23158a(), graphQLModelMutatingVisitor);
                if (a != null) {
                    graphQLVisitableModel = (AdAccountsModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f21982d = a.b();
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m23156a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m23158a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -1143170035)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: ZA */
    public final class AdCoverPhotoModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private PhotoModel f21984d;

        /* compiled from: ZA */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(AdCoverPhotoModel.class, new Deserializer());
            }

            public Object m23159a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(AdCoverPhotoParser.m23775a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object adCoverPhotoModel = new AdCoverPhotoModel();
                ((BaseModel) adCoverPhotoModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (adCoverPhotoModel instanceof Postprocessable) {
                    return ((Postprocessable) adCoverPhotoModel).a();
                }
                return adCoverPhotoModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1236209140)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: ZA */
        public final class PhotoModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private DefaultImageFieldsModel f21983d;

            /* compiled from: ZA */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(PhotoModel.class, new Deserializer());
                }

                public Object m23160a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(PhotoParser.m23773a(jsonParser, flatBufferBuilder));
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

            /* compiled from: ZA */
            public class Serializer extends JsonSerializer<PhotoModel> {
                public final void m23161a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    PhotoModel photoModel = (PhotoModel) obj;
                    if (photoModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(photoModel.m23162a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        photoModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    PhotoParser.m23774a(photoModel.w_(), photoModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(PhotoModel.class, new Serializer());
                }
            }

            public PhotoModel() {
                super(1);
            }

            @Nullable
            public final DefaultImageFieldsModel m23163a() {
                this.f21983d = (DefaultImageFieldsModel) super.a(this.f21983d, 0, DefaultImageFieldsModel.class);
                return this.f21983d;
            }

            public final int jK_() {
                return 77090322;
            }

            public final GraphQLVisitableModel m23164a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m23163a() != null) {
                    DefaultImageFieldsModel defaultImageFieldsModel = (DefaultImageFieldsModel) graphQLModelMutatingVisitor.b(m23163a());
                    if (m23163a() != defaultImageFieldsModel) {
                        graphQLVisitableModel = (PhotoModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f21983d = defaultImageFieldsModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m23162a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m23163a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, a);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: ZA */
        public class Serializer extends JsonSerializer<AdCoverPhotoModel> {
            public final void m23165a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                AdCoverPhotoModel adCoverPhotoModel = (AdCoverPhotoModel) obj;
                if (adCoverPhotoModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(adCoverPhotoModel.m23166a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    adCoverPhotoModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                AdCoverPhotoParser.m23776a(adCoverPhotoModel.w_(), adCoverPhotoModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(AdCoverPhotoModel.class, new Serializer());
            }
        }

        public AdCoverPhotoModel() {
            super(1);
        }

        @Nullable
        public final PhotoModel m23167a() {
            this.f21984d = (PhotoModel) super.a(this.f21984d, 0, PhotoModel.class);
            return this.f21984d;
        }

        public final int jK_() {
            return 497264923;
        }

        public final GraphQLVisitableModel m23168a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m23167a() != null) {
                PhotoModel photoModel = (PhotoModel) graphQLModelMutatingVisitor.b(m23167a());
                if (m23167a() != photoModel) {
                    graphQLVisitableModel = (AdCoverPhotoModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f21984d = photoModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m23166a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m23167a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -2037586196)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: ZA */
    public final class AdGeoCircleModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private String f21985d;
        private double f21986e;
        private double f21987f;
        private double f21988g;

        /* compiled from: ZA */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(AdGeoCircleModel.class, new Deserializer());
            }

            public Object m23169a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(AdGeoCircleParser.m23777a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object adGeoCircleModel = new AdGeoCircleModel();
                ((BaseModel) adGeoCircleModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (adGeoCircleModel instanceof Postprocessable) {
                    return ((Postprocessable) adGeoCircleModel).a();
                }
                return adGeoCircleModel;
            }
        }

        /* compiled from: ZA */
        public class Serializer extends JsonSerializer<AdGeoCircleModel> {
            public final void m23170a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                AdGeoCircleModel adGeoCircleModel = (AdGeoCircleModel) obj;
                if (adGeoCircleModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(adGeoCircleModel.m23173a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    adGeoCircleModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                AdGeoCircleParser.m23778a(adGeoCircleModel.w_(), adGeoCircleModel.u_(), jsonGenerator);
            }

            static {
                FbSerializerProvider.a(AdGeoCircleModel.class, new Serializer());
            }
        }

        public AdGeoCircleModel() {
            super(4);
        }

        @Nullable
        private String m23171j() {
            this.f21985d = super.a(this.f21985d, 0);
            return this.f21985d;
        }

        public final double m23172a() {
            a(0, 1);
            return this.f21986e;
        }

        public final double m23176b() {
            a(0, 2);
            return this.f21987f;
        }

        public final double m23177c() {
            a(0, 3);
            return this.f21988g;
        }

        public final int jK_() {
            return -1111987586;
        }

        public final GraphQLVisitableModel m23174a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            h();
            i();
            return this;
        }

        public final int m23173a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(m23171j());
            flatBufferBuilder.c(4);
            flatBufferBuilder.b(0, b);
            flatBufferBuilder.a(1, this.f21986e, 0.0d);
            flatBufferBuilder.a(2, this.f21987f, 0.0d);
            flatBufferBuilder.a(3, this.f21988g, 0.0d);
            i();
            return flatBufferBuilder.d();
        }

        public final void m23175a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
            super.a(mutableFlatBuffer, i, obj);
            this.f21986e = mutableFlatBuffer.a(i, 1, 0.0d);
            this.f21987f = mutableFlatBuffer.a(i, 2, 0.0d);
            this.f21988g = mutableFlatBuffer.a(i, 3, 0.0d);
        }
    }

    @FragmentModelWithBridge
    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -1040062372)
    @JsonSerialize(using = Serializer.class)
    /* compiled from: ZA */
    public final class AdminInfoModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private AdAccountsModel f22003d;
        @Nullable
        private BoostedCtaPromotionsModel f22004e;
        @Nullable
        private BoostedLocalAwarenessPromotionsModel f22005f;
        @Nullable
        private BoostedPageLikePromotionsModel f22006g;
        @Nullable
        private GraphQLBoostedPostAudienceOption f22007h;
        @Nullable
        private BoostedWebsitePromotionsModel f22008i;
        @Nullable
        private BudgetRecommendationModel f22009j;
        private boolean f22010k;
        private boolean f22011l;
        private int f22012m;
        private boolean f22013n;
        private boolean f22014o;
        @Nullable
        private TargetSpecificationsModel f22015p;
        private boolean f22016q;

        /* compiled from: ZA */
        public final class Builder {
            @Nullable
            public AdAccountsModel f21989a;
            @Nullable
            public BoostedCtaPromotionsModel f21990b;
            @Nullable
            public BoostedLocalAwarenessPromotionsModel f21991c;
            @Nullable
            public BoostedPageLikePromotionsModel f21992d;
            @Nullable
            public GraphQLBoostedPostAudienceOption f21993e;
            @Nullable
            public BoostedWebsitePromotionsModel f21994f;
            @Nullable
            public BudgetRecommendationModel f21995g;
            public boolean f21996h;
            public boolean f21997i;
            public int f21998j;
            public boolean f21999k;
            public boolean f22000l;
            @Nullable
            public TargetSpecificationsModel f22001m;
            public boolean f22002n;

            public static Builder m23178a(AdminInfoModel adminInfoModel) {
                Builder builder = new Builder();
                builder.f21989a = adminInfoModel.m23183a();
                builder.f21990b = adminInfoModel.m23186j();
                builder.f21991c = adminInfoModel.m23187k();
                builder.f21992d = adminInfoModel.m23188l();
                builder.f21993e = adminInfoModel.m23189m();
                builder.f21994f = adminInfoModel.m23190n();
                builder.f21995g = adminInfoModel.m23191o();
                builder.f21996h = adminInfoModel.m23192p();
                builder.f21997i = adminInfoModel.m23193q();
                builder.f21998j = adminInfoModel.m23194r();
                builder.f21999k = adminInfoModel.m23195s();
                builder.f22000l = adminInfoModel.m23196t();
                builder.f22001m = adminInfoModel.m23197u();
                builder.f22002n = adminInfoModel.m23198v();
                return builder;
            }

            public final AdminInfoModel m23179a() {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                int a = ModelHelper.a(flatBufferBuilder, this.f21989a);
                int a2 = ModelHelper.a(flatBufferBuilder, this.f21990b);
                int a3 = ModelHelper.a(flatBufferBuilder, this.f21991c);
                int a4 = ModelHelper.a(flatBufferBuilder, this.f21992d);
                int a5 = flatBufferBuilder.a(this.f21993e);
                int a6 = ModelHelper.a(flatBufferBuilder, this.f21994f);
                int a7 = ModelHelper.a(flatBufferBuilder, this.f21995g);
                int a8 = ModelHelper.a(flatBufferBuilder, this.f22001m);
                flatBufferBuilder.c(14);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.b(1, a2);
                flatBufferBuilder.b(2, a3);
                flatBufferBuilder.b(3, a4);
                flatBufferBuilder.b(4, a5);
                flatBufferBuilder.b(5, a6);
                flatBufferBuilder.b(6, a7);
                flatBufferBuilder.a(7, this.f21996h);
                flatBufferBuilder.a(8, this.f21997i);
                flatBufferBuilder.a(9, this.f21998j, 0);
                flatBufferBuilder.a(10, this.f21999k);
                flatBufferBuilder.a(11, this.f22000l);
                flatBufferBuilder.b(12, a8);
                flatBufferBuilder.a(13, this.f22002n);
                flatBufferBuilder.d(flatBufferBuilder.d());
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                return new AdminInfoModel(new MutableFlatBuffer(wrap, null, null, true, null));
            }
        }

        /* compiled from: ZA */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(AdminInfoModel.class, new Deserializer());
            }

            public Object m23180a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(AdminInfoParser.m23779a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object adminInfoModel = new AdminInfoModel();
                ((BaseModel) adminInfoModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (adminInfoModel instanceof Postprocessable) {
                    return ((Postprocessable) adminInfoModel).a();
                }
                return adminInfoModel;
            }
        }

        /* compiled from: ZA */
        public class Serializer extends JsonSerializer<AdminInfoModel> {
            public final void m23181a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                AdminInfoModel adminInfoModel = (AdminInfoModel) obj;
                if (adminInfoModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(adminInfoModel.m23182a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    adminInfoModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                AdminInfoParser.m23780a(adminInfoModel.w_(), adminInfoModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(AdminInfoModel.class, new Serializer());
            }
        }

        public AdminInfoModel() {
            super(14);
        }

        public AdminInfoModel(MutableFlatBuffer mutableFlatBuffer) {
            super(14);
            a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
        }

        @Nullable
        public final AdAccountsModel m23183a() {
            this.f22003d = (AdAccountsModel) super.a(this.f22003d, 0, AdAccountsModel.class);
            return this.f22003d;
        }

        @Nullable
        public final BoostedCtaPromotionsModel m23186j() {
            this.f22004e = (BoostedCtaPromotionsModel) super.a(this.f22004e, 1, BoostedCtaPromotionsModel.class);
            return this.f22004e;
        }

        @Nullable
        public final BoostedLocalAwarenessPromotionsModel m23187k() {
            this.f22005f = (BoostedLocalAwarenessPromotionsModel) super.a(this.f22005f, 2, BoostedLocalAwarenessPromotionsModel.class);
            return this.f22005f;
        }

        @Nullable
        public final BoostedPageLikePromotionsModel m23188l() {
            this.f22006g = (BoostedPageLikePromotionsModel) super.a(this.f22006g, 3, BoostedPageLikePromotionsModel.class);
            return this.f22006g;
        }

        @Nullable
        public final GraphQLBoostedPostAudienceOption m23189m() {
            this.f22007h = (GraphQLBoostedPostAudienceOption) super.b(this.f22007h, 4, GraphQLBoostedPostAudienceOption.class, GraphQLBoostedPostAudienceOption.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
            return this.f22007h;
        }

        @Nullable
        public final BoostedWebsitePromotionsModel m23190n() {
            this.f22008i = (BoostedWebsitePromotionsModel) super.a(this.f22008i, 5, BoostedWebsitePromotionsModel.class);
            return this.f22008i;
        }

        @Nullable
        public final BudgetRecommendationModel m23191o() {
            this.f22009j = (BudgetRecommendationModel) super.a(this.f22009j, 6, BudgetRecommendationModel.class);
            return this.f22009j;
        }

        public final boolean m23192p() {
            a(0, 7);
            return this.f22010k;
        }

        public final boolean m23193q() {
            a(1, 0);
            return this.f22011l;
        }

        public final int m23194r() {
            a(1, 1);
            return this.f22012m;
        }

        public final boolean m23195s() {
            a(1, 2);
            return this.f22013n;
        }

        public final boolean m23196t() {
            a(1, 3);
            return this.f22014o;
        }

        @Nullable
        public final TargetSpecificationsModel m23197u() {
            this.f22015p = (TargetSpecificationsModel) super.a(this.f22015p, 12, TargetSpecificationsModel.class);
            return this.f22015p;
        }

        public final boolean m23198v() {
            a(1, 5);
            return this.f22016q;
        }

        public final int jK_() {
            return 888797870;
        }

        public final GraphQLVisitableModel m23184a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m23183a() != null) {
                AdAccountsModel adAccountsModel = (AdAccountsModel) graphQLModelMutatingVisitor.b(m23183a());
                if (m23183a() != adAccountsModel) {
                    graphQLVisitableModel = (AdminInfoModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f22003d = adAccountsModel;
                }
            }
            if (m23186j() != null) {
                BoostedCtaPromotionsModel boostedCtaPromotionsModel = (BoostedCtaPromotionsModel) graphQLModelMutatingVisitor.b(m23186j());
                if (m23186j() != boostedCtaPromotionsModel) {
                    graphQLVisitableModel = (AdminInfoModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f22004e = boostedCtaPromotionsModel;
                }
            }
            if (m23187k() != null) {
                BoostedLocalAwarenessPromotionsModel boostedLocalAwarenessPromotionsModel = (BoostedLocalAwarenessPromotionsModel) graphQLModelMutatingVisitor.b(m23187k());
                if (m23187k() != boostedLocalAwarenessPromotionsModel) {
                    graphQLVisitableModel = (AdminInfoModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f22005f = boostedLocalAwarenessPromotionsModel;
                }
            }
            if (m23188l() != null) {
                BoostedPageLikePromotionsModel boostedPageLikePromotionsModel = (BoostedPageLikePromotionsModel) graphQLModelMutatingVisitor.b(m23188l());
                if (m23188l() != boostedPageLikePromotionsModel) {
                    graphQLVisitableModel = (AdminInfoModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f22006g = boostedPageLikePromotionsModel;
                }
            }
            if (m23190n() != null) {
                BoostedWebsitePromotionsModel boostedWebsitePromotionsModel = (BoostedWebsitePromotionsModel) graphQLModelMutatingVisitor.b(m23190n());
                if (m23190n() != boostedWebsitePromotionsModel) {
                    graphQLVisitableModel = (AdminInfoModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f22008i = boostedWebsitePromotionsModel;
                }
            }
            if (m23191o() != null) {
                BudgetRecommendationModel budgetRecommendationModel = (BudgetRecommendationModel) graphQLModelMutatingVisitor.b(m23191o());
                if (m23191o() != budgetRecommendationModel) {
                    graphQLVisitableModel = (AdminInfoModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f22009j = budgetRecommendationModel;
                }
            }
            if (m23197u() != null) {
                TargetSpecificationsModel targetSpecificationsModel = (TargetSpecificationsModel) graphQLModelMutatingVisitor.b(m23197u());
                if (m23197u() != targetSpecificationsModel) {
                    graphQLVisitableModel = (AdminInfoModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f22015p = targetSpecificationsModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m23182a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m23183a());
            int a2 = ModelHelper.a(flatBufferBuilder, m23186j());
            int a3 = ModelHelper.a(flatBufferBuilder, m23187k());
            int a4 = ModelHelper.a(flatBufferBuilder, m23188l());
            int a5 = flatBufferBuilder.a(m23189m());
            int a6 = ModelHelper.a(flatBufferBuilder, m23190n());
            int a7 = ModelHelper.a(flatBufferBuilder, m23191o());
            int a8 = ModelHelper.a(flatBufferBuilder, m23197u());
            flatBufferBuilder.c(14);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, a2);
            flatBufferBuilder.b(2, a3);
            flatBufferBuilder.b(3, a4);
            flatBufferBuilder.b(4, a5);
            flatBufferBuilder.b(5, a6);
            flatBufferBuilder.b(6, a7);
            flatBufferBuilder.a(7, this.f22010k);
            flatBufferBuilder.a(8, this.f22011l);
            flatBufferBuilder.a(9, this.f22012m, 0);
            flatBufferBuilder.a(10, this.f22013n);
            flatBufferBuilder.a(11, this.f22014o);
            flatBufferBuilder.b(12, a8);
            flatBufferBuilder.a(13, this.f22016q);
            i();
            return flatBufferBuilder.d();
        }

        public final void m23185a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
            super.a(mutableFlatBuffer, i, obj);
            this.f22010k = mutableFlatBuffer.a(i, 7);
            this.f22011l = mutableFlatBuffer.a(i, 8);
            this.f22012m = mutableFlatBuffer.a(i, 9, 0);
            this.f22013n = mutableFlatBuffer.a(i, 10);
            this.f22014o = mutableFlatBuffer.a(i, 11);
            this.f22016q = mutableFlatBuffer.a(i, 13);
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -1951000792)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: ZA */
    public final class AvailableAudienceFragmentModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private DefaultSpecModel f22021d;

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 24479761)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: ZA */
        public final class DefaultSpecModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private AvailableAudiencesModel f22020d;

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = 245065353)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: ZA */
            public final class AvailableAudiencesModel extends BaseModel implements GraphQLVisitableModel {
                private int f22018d;
                @Nullable
                private List<EdgesModel> f22019e;

                /* compiled from: ZA */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(AvailableAudiencesModel.class, new Deserializer());
                    }

                    public Object m23199a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(AvailableAudiencesParser.m23783a(jsonParser, flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                        Object availableAudiencesModel = new AvailableAudiencesModel();
                        ((BaseModel) availableAudiencesModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                        if (availableAudiencesModel instanceof Postprocessable) {
                            return ((Postprocessable) availableAudiencesModel).a();
                        }
                        return availableAudiencesModel;
                    }
                }

                @JsonDeserialize(using = Deserializer.class)
                @ModelWithFlatBufferFormatHash(a = -1601065326)
                @JsonSerialize(using = Serializer.class)
                @FragmentModelWithoutBridge
                /* compiled from: ZA */
                public final class EdgesModel extends BaseModel implements GraphQLVisitableModel {
                    @Nullable
                    private BoostedComponentAudienceModel f22017d;

                    /* compiled from: ZA */
                    public class Deserializer extends FbJsonDeserializer {
                        static {
                            GlobalAutoGenDeserializerCache.a(EdgesModel.class, new Deserializer());
                        }

                        public Object m23200a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(EdgesParser.m23781b(jsonParser, flatBufferBuilder));
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

                    /* compiled from: ZA */
                    public class Serializer extends JsonSerializer<EdgesModel> {
                        public final void m23201a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                            EdgesModel edgesModel = (EdgesModel) obj;
                            if (edgesModel.w_() == null) {
                                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                flatBufferBuilder.d(edgesModel.m23202a(flatBufferBuilder));
                                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                wrap.position(0);
                                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                edgesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                            }
                            EdgesParser.m23782b(edgesModel.w_(), edgesModel.u_(), jsonGenerator, serializerProvider);
                        }

                        static {
                            FbSerializerProvider.a(EdgesModel.class, new Serializer());
                        }
                    }

                    public EdgesModel() {
                        super(1);
                    }

                    @Nullable
                    public final BoostedComponentAudienceModel m23203a() {
                        this.f22017d = (BoostedComponentAudienceModel) super.a(this.f22017d, 0, BoostedComponentAudienceModel.class);
                        return this.f22017d;
                    }

                    public final int jK_() {
                        return -474185391;
                    }

                    public final GraphQLVisitableModel m23204a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                        GraphQLVisitableModel graphQLVisitableModel = null;
                        h();
                        if (m23203a() != null) {
                            BoostedComponentAudienceModel boostedComponentAudienceModel = (BoostedComponentAudienceModel) graphQLModelMutatingVisitor.b(m23203a());
                            if (m23203a() != boostedComponentAudienceModel) {
                                graphQLVisitableModel = (EdgesModel) ModelHelper.a(null, this);
                                graphQLVisitableModel.f22017d = boostedComponentAudienceModel;
                            }
                        }
                        i();
                        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                    }

                    public final int m23202a(FlatBufferBuilder flatBufferBuilder) {
                        h();
                        int a = ModelHelper.a(flatBufferBuilder, m23203a());
                        flatBufferBuilder.c(1);
                        flatBufferBuilder.b(0, a);
                        i();
                        return flatBufferBuilder.d();
                    }
                }

                /* compiled from: ZA */
                public class Serializer extends JsonSerializer<AvailableAudiencesModel> {
                    public final void m23205a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        AvailableAudiencesModel availableAudiencesModel = (AvailableAudiencesModel) obj;
                        if (availableAudiencesModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(availableAudiencesModel.m23207a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            availableAudiencesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        AvailableAudiencesParser.m23784a(availableAudiencesModel.w_(), availableAudiencesModel.u_(), jsonGenerator, serializerProvider);
                    }

                    static {
                        FbSerializerProvider.a(AvailableAudiencesModel.class, new Serializer());
                    }
                }

                public AvailableAudiencesModel() {
                    super(2);
                }

                public final int m23206a() {
                    a(0, 0);
                    return this.f22018d;
                }

                @Nonnull
                public final ImmutableList<EdgesModel> m23210j() {
                    this.f22019e = super.a(this.f22019e, 1, EdgesModel.class);
                    return (ImmutableList) this.f22019e;
                }

                public final int jK_() {
                    return -1022258318;
                }

                public final GraphQLVisitableModel m23208a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    GraphQLVisitableModel graphQLVisitableModel = null;
                    h();
                    if (m23210j() != null) {
                        Builder a = ModelHelper.a(m23210j(), graphQLModelMutatingVisitor);
                        if (a != null) {
                            graphQLVisitableModel = (AvailableAudiencesModel) ModelHelper.a(null, this);
                            graphQLVisitableModel.f22019e = a.b();
                        }
                    }
                    i();
                    return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                }

                public final int m23207a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int a = ModelHelper.a(flatBufferBuilder, m23210j());
                    flatBufferBuilder.c(2);
                    flatBufferBuilder.a(0, this.f22018d, 0);
                    flatBufferBuilder.b(1, a);
                    i();
                    return flatBufferBuilder.d();
                }

                public final void m23209a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                    super.a(mutableFlatBuffer, i, obj);
                    this.f22018d = mutableFlatBuffer.a(i, 0, 0);
                }
            }

            /* compiled from: ZA */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(DefaultSpecModel.class, new Deserializer());
                }

                public Object m23211a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(DefaultSpecParser.m23785a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object defaultSpecModel = new DefaultSpecModel();
                    ((BaseModel) defaultSpecModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (defaultSpecModel instanceof Postprocessable) {
                        return ((Postprocessable) defaultSpecModel).a();
                    }
                    return defaultSpecModel;
                }
            }

            /* compiled from: ZA */
            public class Serializer extends JsonSerializer<DefaultSpecModel> {
                public final void m23212a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    DefaultSpecModel defaultSpecModel = (DefaultSpecModel) obj;
                    if (defaultSpecModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(defaultSpecModel.m23213a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        defaultSpecModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    DefaultSpecParser.m23786a(defaultSpecModel.w_(), defaultSpecModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(DefaultSpecModel.class, new Serializer());
                }
            }

            public DefaultSpecModel() {
                super(1);
            }

            @Nullable
            public final AvailableAudiencesModel m23214a() {
                this.f22020d = (AvailableAudiencesModel) super.a(this.f22020d, 0, AvailableAudiencesModel.class);
                return this.f22020d;
            }

            public final int jK_() {
                return 1218236129;
            }

            public final GraphQLVisitableModel m23215a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m23214a() != null) {
                    AvailableAudiencesModel availableAudiencesModel = (AvailableAudiencesModel) graphQLModelMutatingVisitor.b(m23214a());
                    if (m23214a() != availableAudiencesModel) {
                        graphQLVisitableModel = (DefaultSpecModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f22020d = availableAudiencesModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m23213a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m23214a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, a);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: ZA */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(AvailableAudienceFragmentModel.class, new Deserializer());
            }

            public Object m23216a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(AvailableAudienceFragmentParser.m23789b(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object availableAudienceFragmentModel = new AvailableAudienceFragmentModel();
                ((BaseModel) availableAudienceFragmentModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (availableAudienceFragmentModel instanceof Postprocessable) {
                    return ((Postprocessable) availableAudienceFragmentModel).a();
                }
                return availableAudienceFragmentModel;
            }
        }

        /* compiled from: ZA */
        public class Serializer extends JsonSerializer<AvailableAudienceFragmentModel> {
            public final void m23217a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                AvailableAudienceFragmentModel availableAudienceFragmentModel = (AvailableAudienceFragmentModel) obj;
                if (availableAudienceFragmentModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(availableAudienceFragmentModel.m23218a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    availableAudienceFragmentModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                AvailableAudienceFragmentParser.m23790b(availableAudienceFragmentModel.w_(), availableAudienceFragmentModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(AvailableAudienceFragmentModel.class, new Serializer());
            }
        }

        public AvailableAudienceFragmentModel() {
            super(1);
        }

        @Nullable
        public final DefaultSpecModel m23219a() {
            this.f22021d = (DefaultSpecModel) super.a(this.f22021d, 0, DefaultSpecModel.class);
            return this.f22021d;
        }

        public final int jK_() {
            return -47218757;
        }

        public final GraphQLVisitableModel m23220a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m23219a() != null) {
                DefaultSpecModel defaultSpecModel = (DefaultSpecModel) graphQLModelMutatingVisitor.b(m23219a());
                if (m23219a() != defaultSpecModel) {
                    graphQLVisitableModel = (AvailableAudienceFragmentModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f22021d = defaultSpecModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m23218a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m23219a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 1361375896)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: ZA */
    public final class BoostedComponentAudienceModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private GraphQLBoostedPostAudienceOption f22024d;
        @Nullable
        private String f22025e;
        @Nullable
        private String f22026f;
        @Nullable
        private List<TargetingSentencesModel> f22027g;
        @Nullable
        private TargetSpecificationsModel f22028h;

        /* compiled from: ZA */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(BoostedComponentAudienceModel.class, new Deserializer());
            }

            public Object m23221a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(BoostedComponentAudienceParser.m23793a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object boostedComponentAudienceModel = new BoostedComponentAudienceModel();
                ((BaseModel) boostedComponentAudienceModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (boostedComponentAudienceModel instanceof Postprocessable) {
                    return ((Postprocessable) boostedComponentAudienceModel).a();
                }
                return boostedComponentAudienceModel;
            }
        }

        /* compiled from: ZA */
        public class Serializer extends JsonSerializer<BoostedComponentAudienceModel> {
            public final void m23222a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                BoostedComponentAudienceModel boostedComponentAudienceModel = (BoostedComponentAudienceModel) obj;
                if (boostedComponentAudienceModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(boostedComponentAudienceModel.m23229a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    boostedComponentAudienceModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                BoostedComponentAudienceParser.m23794a(boostedComponentAudienceModel.w_(), boostedComponentAudienceModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(BoostedComponentAudienceModel.class, new Serializer());
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1176734575)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: ZA */
        public final class TargetingSentencesModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private String f22022d;
            @Nullable
            private List<String> f22023e;

            /* compiled from: ZA */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(TargetingSentencesModel.class, new Deserializer());
                }

                public Object m23223a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(BoostedComponentAudienceParser.TargetingSentencesParser.m23792b(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object targetingSentencesModel = new TargetingSentencesModel();
                    ((BaseModel) targetingSentencesModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (targetingSentencesModel instanceof Postprocessable) {
                        return ((Postprocessable) targetingSentencesModel).a();
                    }
                    return targetingSentencesModel;
                }
            }

            /* compiled from: ZA */
            public class Serializer extends JsonSerializer<TargetingSentencesModel> {
                public final void m23224a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    TargetingSentencesModel targetingSentencesModel = (TargetingSentencesModel) obj;
                    if (targetingSentencesModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(targetingSentencesModel.m23225a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        targetingSentencesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    BoostedComponentAudienceParser.TargetingSentencesParser.m23791a(targetingSentencesModel.w_(), targetingSentencesModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(TargetingSentencesModel.class, new Serializer());
                }
            }

            public TargetingSentencesModel() {
                super(2);
            }

            @Nullable
            public final String m23227a() {
                this.f22022d = super.a(this.f22022d, 0);
                return this.f22022d;
            }

            @Nonnull
            public final ImmutableList<String> m23228j() {
                this.f22023e = super.a(this.f22023e, 1);
                return (ImmutableList) this.f22023e;
            }

            public final int jK_() {
                return 1801834545;
            }

            public final GraphQLVisitableModel m23226a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m23225a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m23227a());
                int c = flatBufferBuilder.c(m23228j());
                flatBufferBuilder.c(2);
                flatBufferBuilder.b(0, b);
                flatBufferBuilder.b(1, c);
                i();
                return flatBufferBuilder.d();
            }
        }

        public BoostedComponentAudienceModel() {
            super(5);
        }

        @Nullable
        public final GraphQLBoostedPostAudienceOption m23230a() {
            this.f22024d = (GraphQLBoostedPostAudienceOption) super.b(this.f22024d, 0, GraphQLBoostedPostAudienceOption.class, GraphQLBoostedPostAudienceOption.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
            return this.f22024d;
        }

        @Nullable
        public final String m23232j() {
            this.f22025e = super.a(this.f22025e, 1);
            return this.f22025e;
        }

        @Nullable
        public final String m23233k() {
            this.f22026f = super.a(this.f22026f, 2);
            return this.f22026f;
        }

        @Nonnull
        public final ImmutableList<TargetingSentencesModel> m23234l() {
            this.f22027g = super.a(this.f22027g, 3, TargetingSentencesModel.class);
            return (ImmutableList) this.f22027g;
        }

        @Nullable
        public final TargetSpecificationsModel m23235m() {
            this.f22028h = (TargetSpecificationsModel) super.a(this.f22028h, 4, TargetSpecificationsModel.class);
            return this.f22028h;
        }

        public final int jK_() {
            return -583081249;
        }

        public final GraphQLVisitableModel m23231a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel;
            TargetSpecificationsModel targetSpecificationsModel;
            h();
            if (m23234l() != null) {
                Builder a = ModelHelper.a(m23234l(), graphQLModelMutatingVisitor);
                if (a != null) {
                    BoostedComponentAudienceModel boostedComponentAudienceModel = (BoostedComponentAudienceModel) ModelHelper.a(null, this);
                    boostedComponentAudienceModel.f22027g = a.b();
                    graphQLVisitableModel = boostedComponentAudienceModel;
                    if (m23235m() != null) {
                        targetSpecificationsModel = (TargetSpecificationsModel) graphQLModelMutatingVisitor.b(m23235m());
                        if (m23235m() != targetSpecificationsModel) {
                            graphQLVisitableModel = (BoostedComponentAudienceModel) ModelHelper.a(graphQLVisitableModel, this);
                            graphQLVisitableModel.f22028h = targetSpecificationsModel;
                        }
                    }
                    i();
                    return graphQLVisitableModel != null ? this : graphQLVisitableModel;
                }
            }
            graphQLVisitableModel = null;
            if (m23235m() != null) {
                targetSpecificationsModel = (TargetSpecificationsModel) graphQLModelMutatingVisitor.b(m23235m());
                if (m23235m() != targetSpecificationsModel) {
                    graphQLVisitableModel = (BoostedComponentAudienceModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f22028h = targetSpecificationsModel;
                }
            }
            i();
            if (graphQLVisitableModel != null) {
            }
        }

        public final int m23229a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = flatBufferBuilder.a(m23230a());
            int b = flatBufferBuilder.b(m23232j());
            int b2 = flatBufferBuilder.b(m23233k());
            int a2 = ModelHelper.a(flatBufferBuilder, m23234l());
            int a3 = ModelHelper.a(flatBufferBuilder, m23235m());
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
    @ModelWithFlatBufferFormatHash(a = -2051348856)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: ZA */
    public final class BoostedComponentCreativeModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel {
        @Nullable
        private String f22039d;
        @Nullable
        private CreativeImageModel f22040e;
        @Nullable
        private String f22041f;
        @Nullable
        private String f22042g;
        @Nullable
        private ObjectStorySpecModel f22043h;

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 842551240)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: ZA */
        public final class CreativeImageModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private String f22029d;

            /* compiled from: ZA */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(CreativeImageModel.class, new Deserializer());
                }

                public Object m23236a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(CreativeImageParser.m23795a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object creativeImageModel = new CreativeImageModel();
                    ((BaseModel) creativeImageModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (creativeImageModel instanceof Postprocessable) {
                        return ((Postprocessable) creativeImageModel).a();
                    }
                    return creativeImageModel;
                }
            }

            /* compiled from: ZA */
            public class Serializer extends JsonSerializer<CreativeImageModel> {
                public final void m23237a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    CreativeImageModel creativeImageModel = (CreativeImageModel) obj;
                    if (creativeImageModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(creativeImageModel.m23238a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        creativeImageModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    CreativeImageParser.m23796a(creativeImageModel.w_(), creativeImageModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(CreativeImageModel.class, new Serializer());
                }
            }

            public CreativeImageModel() {
                super(1);
            }

            @Nullable
            public final String m23240a() {
                this.f22029d = super.a(this.f22029d, 0);
                return this.f22029d;
            }

            public final int jK_() {
                return 70760763;
            }

            public final GraphQLVisitableModel m23239a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m23238a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m23240a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, b);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: ZA */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(BoostedComponentCreativeModel.class, new Deserializer());
            }

            public Object m23241a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(BoostedComponentCreativeParser.m23803a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object boostedComponentCreativeModel = new BoostedComponentCreativeModel();
                ((BaseModel) boostedComponentCreativeModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (boostedComponentCreativeModel instanceof Postprocessable) {
                    return ((Postprocessable) boostedComponentCreativeModel).a();
                }
                return boostedComponentCreativeModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1489812797)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: ZA */
        public final class ObjectStorySpecModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private LinkDataModel f22038d;

            /* compiled from: ZA */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(ObjectStorySpecModel.class, new Deserializer());
                }

                public Object m23242a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(ObjectStorySpecParser.m23801a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object objectStorySpecModel = new ObjectStorySpecModel();
                    ((BaseModel) objectStorySpecModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (objectStorySpecModel instanceof Postprocessable) {
                        return ((Postprocessable) objectStorySpecModel).a();
                    }
                    return objectStorySpecModel;
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = -724964460)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: ZA */
            public final class LinkDataModel extends BaseModel implements GraphQLVisitableModel {
                @Nullable
                private CallToActionModel f22031d;
                @Nullable
                private String f22032e;
                @Nullable
                private String f22033f;
                @Nullable
                private String f22034g;
                @Nullable
                private String f22035h;
                @Nullable
                private String f22036i;
                @Nullable
                private String f22037j;

                @JsonDeserialize(using = Deserializer.class)
                @ModelWithFlatBufferFormatHash(a = 1460746430)
                @JsonSerialize(using = Serializer.class)
                @FragmentModelWithoutBridge
                /* compiled from: ZA */
                public final class CallToActionModel extends BaseModel implements GraphQLVisitableModel {
                    @Nullable
                    private String f22030d;

                    /* compiled from: ZA */
                    public class Deserializer extends FbJsonDeserializer {
                        static {
                            GlobalAutoGenDeserializerCache.a(CallToActionModel.class, new Deserializer());
                        }

                        public Object m23243a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(CallToActionParser.m23797a(jsonParser, flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            mutableFlatBuffer.a(4, Boolean.valueOf(true));
                            MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                            Object callToActionModel = new CallToActionModel();
                            ((BaseModel) callToActionModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                            if (callToActionModel instanceof Postprocessable) {
                                return ((Postprocessable) callToActionModel).a();
                            }
                            return callToActionModel;
                        }
                    }

                    /* compiled from: ZA */
                    public class Serializer extends JsonSerializer<CallToActionModel> {
                        public final void m23244a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                            CallToActionModel callToActionModel = (CallToActionModel) obj;
                            if (callToActionModel.w_() == null) {
                                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                flatBufferBuilder.d(callToActionModel.m23246a(flatBufferBuilder));
                                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                wrap.position(0);
                                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                callToActionModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                            }
                            CallToActionParser.m23798a(callToActionModel.w_(), callToActionModel.u_(), jsonGenerator);
                        }

                        static {
                            FbSerializerProvider.a(CallToActionModel.class, new Serializer());
                        }
                    }

                    public CallToActionModel() {
                        super(1);
                    }

                    @Nullable
                    private String m23245a() {
                        this.f22030d = super.a(this.f22030d, 0);
                        return this.f22030d;
                    }

                    public final int jK_() {
                        return -908334799;
                    }

                    public final GraphQLVisitableModel m23247a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                        h();
                        i();
                        return this;
                    }

                    public final int m23246a(FlatBufferBuilder flatBufferBuilder) {
                        h();
                        int b = flatBufferBuilder.b(m23245a());
                        flatBufferBuilder.c(1);
                        flatBufferBuilder.b(0, b);
                        i();
                        return flatBufferBuilder.d();
                    }
                }

                /* compiled from: ZA */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(LinkDataModel.class, new Deserializer());
                    }

                    public Object m23248a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(LinkDataParser.m23799a(jsonParser, flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                        Object linkDataModel = new LinkDataModel();
                        ((BaseModel) linkDataModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                        if (linkDataModel instanceof Postprocessable) {
                            return ((Postprocessable) linkDataModel).a();
                        }
                        return linkDataModel;
                    }
                }

                /* compiled from: ZA */
                public class Serializer extends JsonSerializer<LinkDataModel> {
                    public final void m23249a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        LinkDataModel linkDataModel = (LinkDataModel) obj;
                        if (linkDataModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(linkDataModel.m23257a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            linkDataModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        LinkDataParser.m23800a(linkDataModel.w_(), linkDataModel.u_(), jsonGenerator, serializerProvider);
                    }

                    static {
                        FbSerializerProvider.a(LinkDataModel.class, new Serializer());
                    }
                }

                public LinkDataModel() {
                    super(7);
                }

                @Nullable
                private CallToActionModel m23250a() {
                    this.f22031d = (CallToActionModel) super.a(this.f22031d, 0, CallToActionModel.class);
                    return this.f22031d;
                }

                @Nullable
                private String m23251j() {
                    this.f22032e = super.a(this.f22032e, 1);
                    return this.f22032e;
                }

                @Nullable
                private String m23252k() {
                    this.f22033f = super.a(this.f22033f, 2);
                    return this.f22033f;
                }

                @Nullable
                private String m23253l() {
                    this.f22034g = super.a(this.f22034g, 3);
                    return this.f22034g;
                }

                @Nullable
                private String m23254m() {
                    this.f22035h = super.a(this.f22035h, 4);
                    return this.f22035h;
                }

                @Nullable
                private String m23255n() {
                    this.f22036i = super.a(this.f22036i, 5);
                    return this.f22036i;
                }

                @Nullable
                private String m23256o() {
                    this.f22037j = super.a(this.f22037j, 6);
                    return this.f22037j;
                }

                public final int jK_() {
                    return -1130767956;
                }

                public final GraphQLVisitableModel m23258a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    GraphQLVisitableModel graphQLVisitableModel = null;
                    h();
                    if (m23250a() != null) {
                        CallToActionModel callToActionModel = (CallToActionModel) graphQLModelMutatingVisitor.b(m23250a());
                        if (m23250a() != callToActionModel) {
                            graphQLVisitableModel = (LinkDataModel) ModelHelper.a(null, this);
                            graphQLVisitableModel.f22031d = callToActionModel;
                        }
                    }
                    i();
                    return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                }

                public final int m23257a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int a = ModelHelper.a(flatBufferBuilder, m23250a());
                    int b = flatBufferBuilder.b(m23251j());
                    int b2 = flatBufferBuilder.b(m23252k());
                    int b3 = flatBufferBuilder.b(m23253l());
                    int b4 = flatBufferBuilder.b(m23254m());
                    int b5 = flatBufferBuilder.b(m23255n());
                    int b6 = flatBufferBuilder.b(m23256o());
                    flatBufferBuilder.c(7);
                    flatBufferBuilder.b(0, a);
                    flatBufferBuilder.b(1, b);
                    flatBufferBuilder.b(2, b2);
                    flatBufferBuilder.b(3, b3);
                    flatBufferBuilder.b(4, b4);
                    flatBufferBuilder.b(5, b5);
                    flatBufferBuilder.b(6, b6);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            /* compiled from: ZA */
            public class Serializer extends JsonSerializer<ObjectStorySpecModel> {
                public final void m23259a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    ObjectStorySpecModel objectStorySpecModel = (ObjectStorySpecModel) obj;
                    if (objectStorySpecModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(objectStorySpecModel.m23261a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        objectStorySpecModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    ObjectStorySpecParser.m23802a(objectStorySpecModel.w_(), objectStorySpecModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(ObjectStorySpecModel.class, new Serializer());
                }
            }

            public ObjectStorySpecModel() {
                super(1);
            }

            @Nullable
            private LinkDataModel m23260a() {
                this.f22038d = (LinkDataModel) super.a(this.f22038d, 0, LinkDataModel.class);
                return this.f22038d;
            }

            public final int jK_() {
                return 278753040;
            }

            public final GraphQLVisitableModel m23262a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m23260a() != null) {
                    LinkDataModel linkDataModel = (LinkDataModel) graphQLModelMutatingVisitor.b(m23260a());
                    if (m23260a() != linkDataModel) {
                        graphQLVisitableModel = (ObjectStorySpecModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f22038d = linkDataModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m23261a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m23260a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, a);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: ZA */
        public class Serializer extends JsonSerializer<BoostedComponentCreativeModel> {
            public final void m23263a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                BoostedComponentCreativeModel boostedComponentCreativeModel = (BoostedComponentCreativeModel) obj;
                if (boostedComponentCreativeModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(boostedComponentCreativeModel.m23266a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    boostedComponentCreativeModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                BoostedComponentCreativeParser.m23804a(boostedComponentCreativeModel.w_(), boostedComponentCreativeModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(BoostedComponentCreativeModel.class, new Serializer());
            }
        }

        public BoostedComponentCreativeModel() {
            super(5);
        }

        @Nullable
        public final String m23269j() {
            this.f22039d = super.a(this.f22039d, 0);
            return this.f22039d;
        }

        @Nullable
        public final CreativeImageModel m23270k() {
            this.f22040e = (CreativeImageModel) super.a(this.f22040e, 1, CreativeImageModel.class);
            return this.f22040e;
        }

        @Nullable
        private String m23264m() {
            this.f22041f = super.a(this.f22041f, 2);
            return this.f22041f;
        }

        @Nullable
        public final String m23271l() {
            this.f22042g = super.a(this.f22042g, 3);
            return this.f22042g;
        }

        @Nullable
        private ObjectStorySpecModel m23265n() {
            this.f22043h = (ObjectStorySpecModel) super.a(this.f22043h, 4, ObjectStorySpecModel.class);
            return this.f22043h;
        }

        @Nullable
        public final String m23268a() {
            return m23264m();
        }

        public final int jK_() {
            return 1639770386;
        }

        public final GraphQLVisitableModel m23267a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m23270k() != null) {
                CreativeImageModel creativeImageModel = (CreativeImageModel) graphQLModelMutatingVisitor.b(m23270k());
                if (m23270k() != creativeImageModel) {
                    graphQLVisitableModel = (BoostedComponentCreativeModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f22040e = creativeImageModel;
                }
            }
            if (m23265n() != null) {
                ObjectStorySpecModel objectStorySpecModel = (ObjectStorySpecModel) graphQLModelMutatingVisitor.b(m23265n());
                if (m23265n() != objectStorySpecModel) {
                    graphQLVisitableModel = (BoostedComponentCreativeModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f22043h = objectStorySpecModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m23266a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(m23269j());
            int a = ModelHelper.a(flatBufferBuilder, m23270k());
            int b2 = flatBufferBuilder.b(m23264m());
            int b3 = flatBufferBuilder.b(m23271l());
            int a2 = ModelHelper.a(flatBufferBuilder, m23265n());
            flatBufferBuilder.c(5);
            flatBufferBuilder.b(0, b);
            flatBufferBuilder.b(1, a);
            flatBufferBuilder.b(2, b2);
            flatBufferBuilder.b(3, b3);
            flatBufferBuilder.b(4, a2);
            i();
            return flatBufferBuilder.d();
        }
    }

    @FragmentModelWithBridge
    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 1100630047)
    @JsonSerialize(using = Serializer.class)
    /* compiled from: ZA */
    public final class BoostedComponentModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private AdAccountBasicFieldsModel f22085d;
        @Nullable
        private BoostedComponentAudienceModel f22086e;
        @Nullable
        private GraphQLBoostedComponentStatus f22087f;
        @Nullable
        private CurrencyQuantityModel f22088g;
        @Nullable
        private GraphQLBoostedComponentBudgetType f22089h;
        @Nullable
        private CampaignGroupResultsModel f22090i;
        @Nullable
        private BoostedComponentCreativeModel f22091j;
        @Nullable
        private DefaultSpecModel f22092k;
        @Nullable
        private FeedUnit f22093l;
        @Nullable
        private InsightsModel f22094m;
        @Nullable
        private DefaultTextWithEntitiesLongFieldsModel f22095n;
        @Nullable
        private CurrencyQuantityModel f22096o;
        private long f22097p;
        private long f22098q;
        @Nullable
        private TargetSpecificationsModel f22099r;
        @Nullable
        private TargetingDescriptionModel f22100s;

        /* compiled from: ZA */
        public final class Builder {
            @Nullable
            public AdAccountBasicFieldsModel f22044a;
            @Nullable
            public BoostedComponentAudienceModel f22045b;
            @Nullable
            public GraphQLBoostedComponentStatus f22046c;
            @Nullable
            public CurrencyQuantityModel f22047d;
            @Nullable
            public GraphQLBoostedComponentBudgetType f22048e;
            @Nullable
            public CampaignGroupResultsModel f22049f;
            @Nullable
            public BoostedComponentCreativeModel f22050g;
            @Nullable
            public DefaultSpecModel f22051h;
            @Nullable
            public FeedUnit f22052i;
            @Nullable
            public InsightsModel f22053j;
            @Nullable
            public DefaultTextWithEntitiesLongFieldsModel f22054k;
            @Nullable
            public CurrencyQuantityModel f22055l;
            public long f22056m;
            public long f22057n;
            @Nullable
            public TargetSpecificationsModel f22058o;
            @Nullable
            public TargetingDescriptionModel f22059p;

            public final com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.BoostedComponentModel m23272a() {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r18 = this;
                r2 = new com.facebook.flatbuffers.FlatBufferBuilder;
                r3 = 128; // 0x80 float:1.794E-43 double:6.32E-322;
                r2.<init>(r3);
                r0 = r18;
                r3 = r0.f22044a;
                r4 = com.facebook.graphql.modelutil.ModelHelper.a(r2, r3);
                r0 = r18;
                r3 = r0.f22045b;
                r5 = com.facebook.graphql.modelutil.ModelHelper.a(r2, r3);
                r0 = r18;
                r3 = r0.f22046c;
                r6 = r2.a(r3);
                r0 = r18;
                r3 = r0.f22047d;
                r7 = com.facebook.graphql.modelutil.ModelHelper.a(r2, r3);
                r0 = r18;
                r3 = r0.f22048e;
                r8 = r2.a(r3);
                r0 = r18;
                r3 = r0.f22049f;
                r9 = com.facebook.graphql.modelutil.ModelHelper.a(r2, r3);
                r0 = r18;
                r3 = r0.f22050g;
                r10 = com.facebook.graphql.modelutil.ModelHelper.a(r2, r3);
                r0 = r18;
                r3 = r0.f22051h;
                r11 = com.facebook.graphql.modelutil.ModelHelper.a(r2, r3);
                r0 = r18;
                r3 = r0.f22052i;
                r3 = (com.facebook.flatbuffers.MutableFlattenable) r3;
                r3 = com.facebook.graphql.modelutil.ModelHelper.a(r2, r3);
                r0 = r18;
                r12 = r0.f22053j;
                r12 = com.facebook.graphql.modelutil.ModelHelper.a(r2, r12);
                r0 = r18;
                r13 = r0.f22054k;
                r13 = com.facebook.graphql.modelutil.ModelHelper.a(r2, r13);
                r0 = r18;
                r14 = r0.f22055l;
                r14 = com.facebook.graphql.modelutil.ModelHelper.a(r2, r14);
                r0 = r18;
                r15 = r0.f22058o;
                r15 = com.facebook.graphql.modelutil.ModelHelper.a(r2, r15);
                r0 = r18;
                r0 = r0.f22059p;
                r16 = r0;
                r0 = r16;
                r16 = com.facebook.graphql.modelutil.ModelHelper.a(r2, r0);
                r17 = 16;
                r0 = r17;
                r2.c(r0);
                r17 = 0;
                r0 = r17;
                r2.b(r0, r4);
                r4 = 1;
                r2.b(r4, r5);
                r4 = 2;
                r2.b(r4, r6);
                r4 = 3;
                r2.b(r4, r7);
                r4 = 4;
                r2.b(r4, r8);
                r4 = 5;
                r2.b(r4, r9);
                r4 = 6;
                r2.b(r4, r10);
                r4 = 7;
                r2.b(r4, r11);
                r4 = 8;
                r2.b(r4, r3);
                r3 = 9;
                r2.b(r3, r12);
                r3 = 10;
                r2.b(r3, r13);
                r3 = 11;
                r2.b(r3, r14);
                r3 = 12;
                r0 = r18;
                r4 = r0.f22056m;
                r6 = 0;
                r2.a(r3, r4, r6);
                r3 = 13;
                r0 = r18;
                r4 = r0.f22057n;
                r6 = 0;
                r2.a(r3, r4, r6);
                r3 = 14;
                r2.b(r3, r15);
                r3 = 15;
                r0 = r16;
                r2.b(r3, r0);
                r3 = r2.d();
                r2.d(r3);
                r2 = r2.e();
                r3 = java.nio.ByteBuffer.wrap(r2);
                r2 = 0;
                r3.position(r2);
                r2 = new com.facebook.flatbuffers.MutableFlatBuffer;
                r4 = 0;
                r5 = 0;
                r6 = 1;
                r7 = 0;
                r2.<init>(r3, r4, r5, r6, r7);
                r3 = new com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels$BoostedComponentModel;
                r3.<init>(r2);
                return r3;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.BoostedComponentModel.Builder.a():com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels$BoostedComponentModel");
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 95223605)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: ZA */
        public final class DefaultSpecModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private List<GraphQLCallToActionType> f22072d;
            @Nullable
            private AvailableAudiencesModel f22073e;
            @Nullable
            private DefaultCreativeSpecModel f22074f;
            @Nullable
            private TargetSpecificationsModel f22075g;
            private int f22076h;

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = 2133537505)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: ZA */
            public final class AvailableAudiencesModel extends BaseModel implements GraphQLVisitableModel {
                private int f22061d;
                @Nullable
                private List<EdgesModel> f22062e;

                /* compiled from: ZA */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                        /*
                        r0 = com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.BoostedComponentModel.DefaultSpecModel.AvailableAudiencesModel.class;
                        r1 = new com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels$BoostedComponentModel$DefaultSpecModel$AvailableAudiencesModel$Deserializer;
                        r1.<init>();
                        com.facebook.common.json.GlobalAutoGenDeserializerCache.a(r0, r1);
                        return;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.BoostedComponentModel.DefaultSpecModel.AvailableAudiencesModel.Deserializer.<clinit>():void");
                    }

                    public java.lang.Object m23273a(com.fasterxml.jackson.core.JsonParser r11, com.fasterxml.jackson.databind.DeserializationContext r12) {
                        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                        /*
                        r10 = this;
                        r8 = 1;
                        r6 = 0;
                        r4 = new com.facebook.flatbuffers.FlatBufferBuilder;
                        r5 = 128; // 0x80 float:1.794E-43 double:6.32E-322;
                        r4.<init>(r5);
                        r5 = com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsParsers.BoostedComponentParser.DefaultSpecParser.AvailableAudiencesParser.m23807a(r11, r4);
                        r4.d(r5);
                        r4 = r4.e();
                        r5 = java.nio.ByteBuffer.wrap(r4);
                        r4 = 0;
                        r5.position(r4);
                        r4 = new com.facebook.flatbuffers.MutableFlatBuffer;
                        r7 = r6;
                        r9 = r6;
                        r4.<init>(r5, r6, r7, r8, r9);
                        r5 = 4;
                        r6 = java.lang.Boolean.valueOf(r8);
                        r4.a(r5, r6);
                        r2 = r4;
                        r1 = new com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels$BoostedComponentModel$DefaultSpecModel$AvailableAudiencesModel;
                        r1.<init>();
                        r4 = r2.a;
                        r0 = r4;
                        r3 = com.facebook.flatbuffers.FlatBuffer.a(r0);
                        r0 = r1;
                        r0 = (com.facebook.graphql.modelutil.BaseModel) r0;
                        r0.a(r2, r3, r11);
                        r0 = r1 instanceof com.facebook.common.json.Postprocessable;
                        if (r0 == 0) goto L_0x0048;
                    L_0x0042:
                        r1 = (com.facebook.common.json.Postprocessable) r1;
                        r1 = r1.a();
                    L_0x0048:
                        return r1;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.BoostedComponentModel.DefaultSpecModel.AvailableAudiencesModel.Deserializer.a(com.fasterxml.jackson.core.JsonParser, com.fasterxml.jackson.databind.DeserializationContext):java.lang.Object");
                    }
                }

                @JsonDeserialize(using = Deserializer.class)
                @ModelWithFlatBufferFormatHash(a = -1601065326)
                @JsonSerialize(using = Serializer.class)
                @FragmentModelWithoutBridge
                /* compiled from: ZA */
                public final class EdgesModel extends BaseModel implements GraphQLVisitableModel {
                    @Nullable
                    private BoostedComponentAudienceModel f22060d;

                    /* compiled from: ZA */
                    public class Deserializer extends FbJsonDeserializer {
                        static {
                            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                            /*
                            r0 = com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.BoostedComponentModel.DefaultSpecModel.AvailableAudiencesModel.EdgesModel.class;
                            r1 = new com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels$BoostedComponentModel$DefaultSpecModel$AvailableAudiencesModel$EdgesModel$Deserializer;
                            r1.<init>();
                            com.facebook.common.json.GlobalAutoGenDeserializerCache.a(r0, r1);
                            return;
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.BoostedComponentModel.DefaultSpecModel.AvailableAudiencesModel.EdgesModel.Deserializer.<clinit>():void");
                        }

                        public java.lang.Object m23274a(com.fasterxml.jackson.core.JsonParser r11, com.fasterxml.jackson.databind.DeserializationContext r12) {
                            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                            /*
                            r10 = this;
                            r8 = 1;
                            r6 = 0;
                            r4 = new com.facebook.flatbuffers.FlatBufferBuilder;
                            r5 = 128; // 0x80 float:1.794E-43 double:6.32E-322;
                            r4.<init>(r5);
                            r5 = com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsParsers.BoostedComponentParser.DefaultSpecParser.AvailableAudiencesParser.EdgesParser.m23805b(r11, r4);
                            r4.d(r5);
                            r4 = r4.e();
                            r5 = java.nio.ByteBuffer.wrap(r4);
                            r4 = 0;
                            r5.position(r4);
                            r4 = new com.facebook.flatbuffers.MutableFlatBuffer;
                            r7 = r6;
                            r9 = r6;
                            r4.<init>(r5, r6, r7, r8, r9);
                            r5 = 4;
                            r6 = java.lang.Boolean.valueOf(r8);
                            r4.a(r5, r6);
                            r2 = r4;
                            r1 = new com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels$BoostedComponentModel$DefaultSpecModel$AvailableAudiencesModel$EdgesModel;
                            r1.<init>();
                            r4 = r2.a;
                            r0 = r4;
                            r3 = com.facebook.flatbuffers.FlatBuffer.a(r0);
                            r0 = r1;
                            r0 = (com.facebook.graphql.modelutil.BaseModel) r0;
                            r0.a(r2, r3, r11);
                            r0 = r1 instanceof com.facebook.common.json.Postprocessable;
                            if (r0 == 0) goto L_0x0048;
                        L_0x0042:
                            r1 = (com.facebook.common.json.Postprocessable) r1;
                            r1 = r1.a();
                        L_0x0048:
                            return r1;
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.BoostedComponentModel.DefaultSpecModel.AvailableAudiencesModel.EdgesModel.Deserializer.a(com.fasterxml.jackson.core.JsonParser, com.fasterxml.jackson.databind.DeserializationContext):java.lang.Object");
                        }
                    }

                    /* compiled from: ZA */
                    public class Serializer extends JsonSerializer<EdgesModel> {
                        public final void m23275a(java.lang.Object r8, com.fasterxml.jackson.core.JsonGenerator r9, com.fasterxml.jackson.databind.SerializerProvider r10) {
                            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                            /*
                            r7 = this;
                            r8 = (com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.BoostedComponentModel.DefaultSpecModel.AvailableAudiencesModel.EdgesModel) r8;
                            r2 = 0;
                            r0 = r8.w_();
                            if (r0 != 0) goto L_0x0035;
                        L_0x0009:
                            r0 = new com.facebook.flatbuffers.FlatBufferBuilder;
                            r1 = 128; // 0x80 float:1.794E-43 double:6.32E-322;
                            r0.<init>(r1);
                            r1 = r8.m23276a(r0);
                            r0.d(r1);
                            r0 = r0.e();
                            r1 = java.nio.ByteBuffer.wrap(r0);
                            r0 = 0;
                            r1.position(r0);
                            r0 = new com.facebook.flatbuffers.MutableFlatBuffer;
                            r4 = 1;
                            r3 = r2;
                            r5 = r2;
                            r0.<init>(r1, r2, r3, r4, r5);
                            r6 = r0.a;
                            r1 = r6;
                            r1 = com.facebook.flatbuffers.FlatBuffer.a(r1);
                            r8.a(r0, r1);
                        L_0x0035:
                            r0 = r8.w_();
                            r1 = r8.u_();
                            com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsParsers.BoostedComponentParser.DefaultSpecParser.AvailableAudiencesParser.EdgesParser.m23806b(r0, r1, r9, r10);
                            return;
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.BoostedComponentModel.DefaultSpecModel.AvailableAudiencesModel.EdgesModel.Serializer.a(java.lang.Object, com.fasterxml.jackson.core.JsonGenerator, com.fasterxml.jackson.databind.SerializerProvider):void");
                        }

                        static {
                            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                            /*
                            r0 = com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.BoostedComponentModel.DefaultSpecModel.AvailableAudiencesModel.EdgesModel.class;
                            r1 = new com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels$BoostedComponentModel$DefaultSpecModel$AvailableAudiencesModel$EdgesModel$Serializer;
                            r1.<init>();
                            com.facebook.common.json.FbSerializerProvider.a(r0, r1);
                            return;
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.BoostedComponentModel.DefaultSpecModel.AvailableAudiencesModel.EdgesModel.Serializer.<clinit>():void");
                        }
                    }

                    public EdgesModel() {
                        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                        /*
                        r1 = this;
                        r0 = 1;
                        r1.<init>(r0);
                        return;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.BoostedComponentModel.DefaultSpecModel.AvailableAudiencesModel.EdgesModel.<init>():void");
                    }

                    @javax.annotation.Nullable
                    public final com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.BoostedComponentAudienceModel m23277a() {
                        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                        /*
                        r3 = this;
                        r0 = r3.f22060d;
                        r1 = 0;
                        r2 = com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.BoostedComponentAudienceModel.class;
                        r0 = super.a(r0, r1, r2);
                        r0 = (com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.BoostedComponentAudienceModel) r0;
                        r3.f22060d = r0;
                        r0 = r3.f22060d;
                        return r0;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.BoostedComponentModel.DefaultSpecModel.AvailableAudiencesModel.EdgesModel.a():com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels$BoostedComponentAudienceModel");
                    }

                    public final int jK_() {
                        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                        /*
                        r1 = this;
                        r0 = -474185391; // 0xffffffffe3bc8151 float:-6.954612E21 double:NaN;
                        return r0;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.BoostedComponentModel.DefaultSpecModel.AvailableAudiencesModel.EdgesModel.jK_():int");
                    }

                    public final com.facebook.graphql.visitor.GraphQLVisitableModel m23278a(com.facebook.graphql.visitor.GraphQLModelMutatingVisitor r4) {
                        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                        /*
                        r3 = this;
                        r1 = 0;
                        r3.h();
                        r0 = r3.m23277a();
                        if (r0 == 0) goto L_0x0022;
                    L_0x000a:
                        r0 = r3.m23277a();
                        r0 = r4.b(r0);
                        r0 = (com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.BoostedComponentAudienceModel) r0;
                        r2 = r3.m23277a();
                        if (r2 == r0) goto L_0x0022;
                    L_0x001a:
                        r1 = com.facebook.graphql.modelutil.ModelHelper.a(r1, r3);
                        r1 = (com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.BoostedComponentModel.DefaultSpecModel.AvailableAudiencesModel.EdgesModel) r1;
                        r1.f22060d = r0;
                    L_0x0022:
                        r3.i();
                        if (r1 != 0) goto L_0x0028;
                    L_0x0027:
                        return r3;
                    L_0x0028:
                        r3 = r1;
                        goto L_0x0027;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.BoostedComponentModel.DefaultSpecModel.AvailableAudiencesModel.EdgesModel.a(com.facebook.graphql.visitor.GraphQLModelMutatingVisitor):com.facebook.graphql.visitor.GraphQLVisitableModel");
                    }

                    public final int m23276a(com.facebook.flatbuffers.FlatBufferBuilder r3) {
                        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                        /*
                        r2 = this;
                        r2.h();
                        r0 = r2.m23277a();
                        r0 = com.facebook.graphql.modelutil.ModelHelper.a(r3, r0);
                        r1 = 1;
                        r3.c(r1);
                        r1 = 0;
                        r3.b(r1, r0);
                        r2.i();
                        r0 = r3.d();
                        return r0;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.BoostedComponentModel.DefaultSpecModel.AvailableAudiencesModel.EdgesModel.a(com.facebook.flatbuffers.FlatBufferBuilder):int");
                    }
                }

                /* compiled from: ZA */
                public class Serializer extends JsonSerializer<AvailableAudiencesModel> {
                    public final void m23279a(java.lang.Object r8, com.fasterxml.jackson.core.JsonGenerator r9, com.fasterxml.jackson.databind.SerializerProvider r10) {
                        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                        /*
                        r7 = this;
                        r8 = (com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.BoostedComponentModel.DefaultSpecModel.AvailableAudiencesModel) r8;
                        r2 = 0;
                        r0 = r8.w_();
                        if (r0 != 0) goto L_0x0035;
                    L_0x0009:
                        r0 = new com.facebook.flatbuffers.FlatBufferBuilder;
                        r1 = 128; // 0x80 float:1.794E-43 double:6.32E-322;
                        r0.<init>(r1);
                        r1 = r8.m23281a(r0);
                        r0.d(r1);
                        r0 = r0.e();
                        r1 = java.nio.ByteBuffer.wrap(r0);
                        r0 = 0;
                        r1.position(r0);
                        r0 = new com.facebook.flatbuffers.MutableFlatBuffer;
                        r4 = 1;
                        r3 = r2;
                        r5 = r2;
                        r0.<init>(r1, r2, r3, r4, r5);
                        r6 = r0.a;
                        r1 = r6;
                        r1 = com.facebook.flatbuffers.FlatBuffer.a(r1);
                        r8.a(r0, r1);
                    L_0x0035:
                        r0 = r8.w_();
                        r1 = r8.u_();
                        com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsParsers.BoostedComponentParser.DefaultSpecParser.AvailableAudiencesParser.m23808a(r0, r1, r9, r10);
                        return;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.BoostedComponentModel.DefaultSpecModel.AvailableAudiencesModel.Serializer.a(java.lang.Object, com.fasterxml.jackson.core.JsonGenerator, com.fasterxml.jackson.databind.SerializerProvider):void");
                    }

                    static {
                        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                        /*
                        r0 = com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.BoostedComponentModel.DefaultSpecModel.AvailableAudiencesModel.class;
                        r1 = new com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels$BoostedComponentModel$DefaultSpecModel$AvailableAudiencesModel$Serializer;
                        r1.<init>();
                        com.facebook.common.json.FbSerializerProvider.a(r0, r1);
                        return;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.BoostedComponentModel.DefaultSpecModel.AvailableAudiencesModel.Serializer.<clinit>():void");
                    }
                }

                public AvailableAudiencesModel() {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r1 = this;
                    r0 = 2;
                    r1.<init>(r0);
                    return;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.BoostedComponentModel.DefaultSpecModel.AvailableAudiencesModel.<init>():void");
                }

                public final int m23280a() {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r1 = this;
                    r0 = 0;
                    r1.a(r0, r0);
                    r0 = r1.f22061d;
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.BoostedComponentModel.DefaultSpecModel.AvailableAudiencesModel.a():int");
                }

                @javax.annotation.Nonnull
                public final com.google.common.collect.ImmutableList<com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.BoostedComponentModel.DefaultSpecModel.AvailableAudiencesModel.EdgesModel> m23284j() {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r3 = this;
                    r0 = r3.f22062e;
                    r1 = 1;
                    r2 = com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.BoostedComponentModel.DefaultSpecModel.AvailableAudiencesModel.EdgesModel.class;
                    r0 = super.a(r0, r1, r2);
                    r3.f22062e = r0;
                    r0 = r3.f22062e;
                    r0 = (com.google.common.collect.ImmutableList) r0;
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.BoostedComponentModel.DefaultSpecModel.AvailableAudiencesModel.j():com.google.common.collect.ImmutableList<com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels$BoostedComponentModel$DefaultSpecModel$AvailableAudiencesModel$EdgesModel>");
                }

                public final int jK_() {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r1 = this;
                    r0 = -1022258318; // 0xffffffffc3119372 float:-145.57596 double:NaN;
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.BoostedComponentModel.DefaultSpecModel.AvailableAudiencesModel.jK_():int");
                }

                public final com.facebook.graphql.visitor.GraphQLVisitableModel m23282a(com.facebook.graphql.visitor.GraphQLModelMutatingVisitor r3) {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r2 = this;
                    r0 = 0;
                    r2.h();
                    r1 = r2.m23284j();
                    if (r1 == 0) goto L_0x0020;
                L_0x000a:
                    r1 = r2.m23284j();
                    r1 = com.facebook.graphql.modelutil.ModelHelper.a(r1, r3);
                    if (r1 == 0) goto L_0x0020;
                L_0x0014:
                    r0 = com.facebook.graphql.modelutil.ModelHelper.a(r0, r2);
                    r0 = (com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.BoostedComponentModel.DefaultSpecModel.AvailableAudiencesModel) r0;
                    r1 = r1.b();
                    r0.f22062e = r1;
                L_0x0020:
                    r2.i();
                    if (r0 != 0) goto L_0x0026;
                L_0x0025:
                    return r2;
                L_0x0026:
                    r2 = r0;
                    goto L_0x0025;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.BoostedComponentModel.DefaultSpecModel.AvailableAudiencesModel.a(com.facebook.graphql.visitor.GraphQLModelMutatingVisitor):com.facebook.graphql.visitor.GraphQLVisitableModel");
                }

                public final int m23281a(com.facebook.flatbuffers.FlatBufferBuilder r4) {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r3 = this;
                    r2 = 0;
                    r3.h();
                    r0 = r3.m23284j();
                    r0 = com.facebook.graphql.modelutil.ModelHelper.a(r4, r0);
                    r1 = 2;
                    r4.c(r1);
                    r1 = r3.f22061d;
                    r4.a(r2, r1, r2);
                    r1 = 1;
                    r4.b(r1, r0);
                    r3.i();
                    r0 = r4.d();
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.BoostedComponentModel.DefaultSpecModel.AvailableAudiencesModel.a(com.facebook.flatbuffers.FlatBufferBuilder):int");
                }

                public final void m23283a(com.facebook.flatbuffers.MutableFlatBuffer r2, int r3, java.lang.Object r4) {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r1 = this;
                    r0 = 0;
                    super.a(r2, r3, r4);
                    r0 = r2.a(r3, r0, r0);
                    r1.f22061d = r0;
                    return;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.BoostedComponentModel.DefaultSpecModel.AvailableAudiencesModel.a(com.facebook.flatbuffers.MutableFlatBuffer, int, java.lang.Object):void");
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = -1721817996)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: ZA */
            public final class DefaultCreativeSpecModel extends BaseModel implements GraphQLVisitableModel {
                @Nullable
                private String f22067d;
                @Nullable
                private String f22068e;
                @Nullable
                private String f22069f;
                @Nullable
                private String f22070g;
                @Nullable
                private ObjectStorySpecModel f22071h;

                /* compiled from: ZA */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                        /*
                        r0 = com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.BoostedComponentModel.DefaultSpecModel.DefaultCreativeSpecModel.class;
                        r1 = new com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels$BoostedComponentModel$DefaultSpecModel$DefaultCreativeSpecModel$Deserializer;
                        r1.<init>();
                        com.facebook.common.json.GlobalAutoGenDeserializerCache.a(r0, r1);
                        return;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.BoostedComponentModel.DefaultSpecModel.DefaultCreativeSpecModel.Deserializer.<clinit>():void");
                    }

                    public java.lang.Object m23285a(com.fasterxml.jackson.core.JsonParser r11, com.fasterxml.jackson.databind.DeserializationContext r12) {
                        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                        /*
                        r10 = this;
                        r8 = 1;
                        r6 = 0;
                        r4 = new com.facebook.flatbuffers.FlatBufferBuilder;
                        r5 = 128; // 0x80 float:1.794E-43 double:6.32E-322;
                        r4.<init>(r5);
                        r5 = com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsParsers.BoostedComponentParser.DefaultSpecParser.DefaultCreativeSpecParser.m23813a(r11, r4);
                        r4.d(r5);
                        r4 = r4.e();
                        r5 = java.nio.ByteBuffer.wrap(r4);
                        r4 = 0;
                        r5.position(r4);
                        r4 = new com.facebook.flatbuffers.MutableFlatBuffer;
                        r7 = r6;
                        r9 = r6;
                        r4.<init>(r5, r6, r7, r8, r9);
                        r5 = 4;
                        r6 = java.lang.Boolean.valueOf(r8);
                        r4.a(r5, r6);
                        r2 = r4;
                        r1 = new com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels$BoostedComponentModel$DefaultSpecModel$DefaultCreativeSpecModel;
                        r1.<init>();
                        r4 = r2.a;
                        r0 = r4;
                        r3 = com.facebook.flatbuffers.FlatBuffer.a(r0);
                        r0 = r1;
                        r0 = (com.facebook.graphql.modelutil.BaseModel) r0;
                        r0.a(r2, r3, r11);
                        r0 = r1 instanceof com.facebook.common.json.Postprocessable;
                        if (r0 == 0) goto L_0x0048;
                    L_0x0042:
                        r1 = (com.facebook.common.json.Postprocessable) r1;
                        r1 = r1.a();
                    L_0x0048:
                        return r1;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.BoostedComponentModel.DefaultSpecModel.DefaultCreativeSpecModel.Deserializer.a(com.fasterxml.jackson.core.JsonParser, com.fasterxml.jackson.databind.DeserializationContext):java.lang.Object");
                    }
                }

                @JsonDeserialize(using = Deserializer.class)
                @ModelWithFlatBufferFormatHash(a = -409777061)
                @JsonSerialize(using = Serializer.class)
                @FragmentModelWithoutBridge
                /* compiled from: ZA */
                public final class ObjectStorySpecModel extends BaseModel implements GraphQLVisitableModel {
                    @Nullable
                    private LinkDataModel f22066d;

                    /* compiled from: ZA */
                    public class Deserializer extends FbJsonDeserializer {
                        static {
                            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                            /*
                            r0 = com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.BoostedComponentModel.DefaultSpecModel.DefaultCreativeSpecModel.ObjectStorySpecModel.class;
                            r1 = new com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels$BoostedComponentModel$DefaultSpecModel$DefaultCreativeSpecModel$ObjectStorySpecModel$Deserializer;
                            r1.<init>();
                            com.facebook.common.json.GlobalAutoGenDeserializerCache.a(r0, r1);
                            return;
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.BoostedComponentModel.DefaultSpecModel.DefaultCreativeSpecModel.ObjectStorySpecModel.Deserializer.<clinit>():void");
                        }

                        public java.lang.Object m23286a(com.fasterxml.jackson.core.JsonParser r11, com.fasterxml.jackson.databind.DeserializationContext r12) {
                            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                            /*
                            r10 = this;
                            r8 = 1;
                            r6 = 0;
                            r4 = new com.facebook.flatbuffers.FlatBufferBuilder;
                            r5 = 128; // 0x80 float:1.794E-43 double:6.32E-322;
                            r4.<init>(r5);
                            r5 = com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsParsers.BoostedComponentParser.DefaultSpecParser.DefaultCreativeSpecParser.ObjectStorySpecParser.m23811a(r11, r4);
                            r4.d(r5);
                            r4 = r4.e();
                            r5 = java.nio.ByteBuffer.wrap(r4);
                            r4 = 0;
                            r5.position(r4);
                            r4 = new com.facebook.flatbuffers.MutableFlatBuffer;
                            r7 = r6;
                            r9 = r6;
                            r4.<init>(r5, r6, r7, r8, r9);
                            r5 = 4;
                            r6 = java.lang.Boolean.valueOf(r8);
                            r4.a(r5, r6);
                            r2 = r4;
                            r1 = new com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels$BoostedComponentModel$DefaultSpecModel$DefaultCreativeSpecModel$ObjectStorySpecModel;
                            r1.<init>();
                            r4 = r2.a;
                            r0 = r4;
                            r3 = com.facebook.flatbuffers.FlatBuffer.a(r0);
                            r0 = r1;
                            r0 = (com.facebook.graphql.modelutil.BaseModel) r0;
                            r0.a(r2, r3, r11);
                            r0 = r1 instanceof com.facebook.common.json.Postprocessable;
                            if (r0 == 0) goto L_0x0048;
                        L_0x0042:
                            r1 = (com.facebook.common.json.Postprocessable) r1;
                            r1 = r1.a();
                        L_0x0048:
                            return r1;
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.BoostedComponentModel.DefaultSpecModel.DefaultCreativeSpecModel.ObjectStorySpecModel.Deserializer.a(com.fasterxml.jackson.core.JsonParser, com.fasterxml.jackson.databind.DeserializationContext):java.lang.Object");
                        }
                    }

                    @JsonDeserialize(using = Deserializer.class)
                    @ModelWithFlatBufferFormatHash(a = -1989912816)
                    @JsonSerialize(using = Serializer.class)
                    @FragmentModelWithoutBridge
                    /* compiled from: ZA */
                    public final class LinkDataModel extends BaseModel implements GraphQLVisitableModel {
                        @Nullable
                        private String f22063d;
                        @Nullable
                        private String f22064e;
                        @Nullable
                        private String f22065f;

                        /* compiled from: ZA */
                        public class Deserializer extends FbJsonDeserializer {
                            static {
                                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                                /*
                                r0 = com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.BoostedComponentModel.DefaultSpecModel.DefaultCreativeSpecModel.ObjectStorySpecModel.LinkDataModel.class;
                                r1 = new com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels$BoostedComponentModel$DefaultSpecModel$DefaultCreativeSpecModel$ObjectStorySpecModel$LinkDataModel$Deserializer;
                                r1.<init>();
                                com.facebook.common.json.GlobalAutoGenDeserializerCache.a(r0, r1);
                                return;
                                */
                                throw new UnsupportedOperationException("Method not decompiled: com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.BoostedComponentModel.DefaultSpecModel.DefaultCreativeSpecModel.ObjectStorySpecModel.LinkDataModel.Deserializer.<clinit>():void");
                            }

                            public java.lang.Object m23287a(com.fasterxml.jackson.core.JsonParser r11, com.fasterxml.jackson.databind.DeserializationContext r12) {
                                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                                /*
                                r10 = this;
                                r8 = 1;
                                r6 = 0;
                                r4 = new com.facebook.flatbuffers.FlatBufferBuilder;
                                r5 = 128; // 0x80 float:1.794E-43 double:6.32E-322;
                                r4.<init>(r5);
                                r5 = com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsParsers.BoostedComponentParser.DefaultSpecParser.DefaultCreativeSpecParser.ObjectStorySpecParser.LinkDataParser.m23809a(r11, r4);
                                r4.d(r5);
                                r4 = r4.e();
                                r5 = java.nio.ByteBuffer.wrap(r4);
                                r4 = 0;
                                r5.position(r4);
                                r4 = new com.facebook.flatbuffers.MutableFlatBuffer;
                                r7 = r6;
                                r9 = r6;
                                r4.<init>(r5, r6, r7, r8, r9);
                                r5 = 4;
                                r6 = java.lang.Boolean.valueOf(r8);
                                r4.a(r5, r6);
                                r2 = r4;
                                r1 = new com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels$BoostedComponentModel$DefaultSpecModel$DefaultCreativeSpecModel$ObjectStorySpecModel$LinkDataModel;
                                r1.<init>();
                                r4 = r2.a;
                                r0 = r4;
                                r3 = com.facebook.flatbuffers.FlatBuffer.a(r0);
                                r0 = r1;
                                r0 = (com.facebook.graphql.modelutil.BaseModel) r0;
                                r0.a(r2, r3, r11);
                                r0 = r1 instanceof com.facebook.common.json.Postprocessable;
                                if (r0 == 0) goto L_0x0048;
                            L_0x0042:
                                r1 = (com.facebook.common.json.Postprocessable) r1;
                                r1 = r1.a();
                            L_0x0048:
                                return r1;
                                */
                                throw new UnsupportedOperationException("Method not decompiled: com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.BoostedComponentModel.DefaultSpecModel.DefaultCreativeSpecModel.ObjectStorySpecModel.LinkDataModel.Deserializer.a(com.fasterxml.jackson.core.JsonParser, com.fasterxml.jackson.databind.DeserializationContext):java.lang.Object");
                            }
                        }

                        /* compiled from: ZA */
                        public class Serializer extends JsonSerializer<LinkDataModel> {
                            public final void m23288a(java.lang.Object r8, com.fasterxml.jackson.core.JsonGenerator r9, com.fasterxml.jackson.databind.SerializerProvider r10) {
                                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                                /*
                                r7 = this;
                                r8 = (com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.BoostedComponentModel.DefaultSpecModel.DefaultCreativeSpecModel.ObjectStorySpecModel.LinkDataModel) r8;
                                r2 = 0;
                                r0 = r8.w_();
                                if (r0 != 0) goto L_0x0035;
                            L_0x0009:
                                r0 = new com.facebook.flatbuffers.FlatBufferBuilder;
                                r1 = 128; // 0x80 float:1.794E-43 double:6.32E-322;
                                r0.<init>(r1);
                                r1 = r8.m23289a(r0);
                                r0.d(r1);
                                r0 = r0.e();
                                r1 = java.nio.ByteBuffer.wrap(r0);
                                r0 = 0;
                                r1.position(r0);
                                r0 = new com.facebook.flatbuffers.MutableFlatBuffer;
                                r4 = 1;
                                r3 = r2;
                                r5 = r2;
                                r0.<init>(r1, r2, r3, r4, r5);
                                r6 = r0.a;
                                r1 = r6;
                                r1 = com.facebook.flatbuffers.FlatBuffer.a(r1);
                                r8.a(r0, r1);
                            L_0x0035:
                                r0 = r8.w_();
                                r1 = r8.u_();
                                com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsParsers.BoostedComponentParser.DefaultSpecParser.DefaultCreativeSpecParser.ObjectStorySpecParser.LinkDataParser.m23810a(r0, r1, r9);
                                return;
                                */
                                throw new UnsupportedOperationException("Method not decompiled: com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.BoostedComponentModel.DefaultSpecModel.DefaultCreativeSpecModel.ObjectStorySpecModel.LinkDataModel.Serializer.a(java.lang.Object, com.fasterxml.jackson.core.JsonGenerator, com.fasterxml.jackson.databind.SerializerProvider):void");
                            }

                            static {
                                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                                /*
                                r0 = com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.BoostedComponentModel.DefaultSpecModel.DefaultCreativeSpecModel.ObjectStorySpecModel.LinkDataModel.class;
                                r1 = new com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels$BoostedComponentModel$DefaultSpecModel$DefaultCreativeSpecModel$ObjectStorySpecModel$LinkDataModel$Serializer;
                                r1.<init>();
                                com.facebook.common.json.FbSerializerProvider.a(r0, r1);
                                return;
                                */
                                throw new UnsupportedOperationException("Method not decompiled: com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.BoostedComponentModel.DefaultSpecModel.DefaultCreativeSpecModel.ObjectStorySpecModel.LinkDataModel.Serializer.<clinit>():void");
                            }
                        }

                        public LinkDataModel() {
                            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                            /*
                            r1 = this;
                            r0 = 3;
                            r1.<init>(r0);
                            return;
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.BoostedComponentModel.DefaultSpecModel.DefaultCreativeSpecModel.ObjectStorySpecModel.LinkDataModel.<init>():void");
                        }

                        @javax.annotation.Nullable
                        public final java.lang.String m23291a() {
                            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                            /*
                            r2 = this;
                            r0 = r2.f22063d;
                            r1 = 0;
                            r0 = super.a(r0, r1);
                            r2.f22063d = r0;
                            r0 = r2.f22063d;
                            return r0;
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.BoostedComponentModel.DefaultSpecModel.DefaultCreativeSpecModel.ObjectStorySpecModel.LinkDataModel.a():java.lang.String");
                        }

                        @javax.annotation.Nullable
                        public final java.lang.String m23292b() {
                            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                            /*
                            r2 = this;
                            r0 = r2.f22064e;
                            r1 = 1;
                            r0 = super.a(r0, r1);
                            r2.f22064e = r0;
                            r0 = r2.f22064e;
                            return r0;
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.BoostedComponentModel.DefaultSpecModel.DefaultCreativeSpecModel.ObjectStorySpecModel.LinkDataModel.b():java.lang.String");
                        }

                        @javax.annotation.Nullable
                        public final java.lang.String m23293c() {
                            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                            /*
                            r2 = this;
                            r0 = r2.f22065f;
                            r1 = 2;
                            r0 = super.a(r0, r1);
                            r2.f22065f = r0;
                            r0 = r2.f22065f;
                            return r0;
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.BoostedComponentModel.DefaultSpecModel.DefaultCreativeSpecModel.ObjectStorySpecModel.LinkDataModel.c():java.lang.String");
                        }

                        public final int jK_() {
                            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                            /*
                            r1 = this;
                            r0 = -1130767956; // 0xffffffffbc99d9ac float:-0.018780552 double:NaN;
                            return r0;
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.BoostedComponentModel.DefaultSpecModel.DefaultCreativeSpecModel.ObjectStorySpecModel.LinkDataModel.jK_():int");
                        }

                        public final com.facebook.graphql.visitor.GraphQLVisitableModel m23290a(com.facebook.graphql.visitor.GraphQLModelMutatingVisitor r1) {
                            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                            /*
                            r0 = this;
                            r0.h();
                            r0.i();
                            return r0;
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.BoostedComponentModel.DefaultSpecModel.DefaultCreativeSpecModel.ObjectStorySpecModel.LinkDataModel.a(com.facebook.graphql.visitor.GraphQLModelMutatingVisitor):com.facebook.graphql.visitor.GraphQLVisitableModel");
                        }

                        public final int m23289a(com.facebook.flatbuffers.FlatBufferBuilder r5) {
                            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                            /*
                            r4 = this;
                            r4.h();
                            r0 = r4.m23291a();
                            r0 = r5.b(r0);
                            r1 = r4.m23292b();
                            r1 = r5.b(r1);
                            r2 = r4.m23293c();
                            r2 = r5.b(r2);
                            r3 = 3;
                            r5.c(r3);
                            r3 = 0;
                            r5.b(r3, r0);
                            r0 = 1;
                            r5.b(r0, r1);
                            r0 = 2;
                            r5.b(r0, r2);
                            r4.i();
                            r0 = r5.d();
                            return r0;
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.BoostedComponentModel.DefaultSpecModel.DefaultCreativeSpecModel.ObjectStorySpecModel.LinkDataModel.a(com.facebook.flatbuffers.FlatBufferBuilder):int");
                        }
                    }

                    /* compiled from: ZA */
                    public class Serializer extends JsonSerializer<ObjectStorySpecModel> {
                        public final void m23294a(java.lang.Object r8, com.fasterxml.jackson.core.JsonGenerator r9, com.fasterxml.jackson.databind.SerializerProvider r10) {
                            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                            /*
                            r7 = this;
                            r8 = (com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.BoostedComponentModel.DefaultSpecModel.DefaultCreativeSpecModel.ObjectStorySpecModel) r8;
                            r2 = 0;
                            r0 = r8.w_();
                            if (r0 != 0) goto L_0x0035;
                        L_0x0009:
                            r0 = new com.facebook.flatbuffers.FlatBufferBuilder;
                            r1 = 128; // 0x80 float:1.794E-43 double:6.32E-322;
                            r0.<init>(r1);
                            r1 = r8.m23295a(r0);
                            r0.d(r1);
                            r0 = r0.e();
                            r1 = java.nio.ByteBuffer.wrap(r0);
                            r0 = 0;
                            r1.position(r0);
                            r0 = new com.facebook.flatbuffers.MutableFlatBuffer;
                            r4 = 1;
                            r3 = r2;
                            r5 = r2;
                            r0.<init>(r1, r2, r3, r4, r5);
                            r6 = r0.a;
                            r1 = r6;
                            r1 = com.facebook.flatbuffers.FlatBuffer.a(r1);
                            r8.a(r0, r1);
                        L_0x0035:
                            r0 = r8.w_();
                            r1 = r8.u_();
                            com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsParsers.BoostedComponentParser.DefaultSpecParser.DefaultCreativeSpecParser.ObjectStorySpecParser.m23812a(r0, r1, r9, r10);
                            return;
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.BoostedComponentModel.DefaultSpecModel.DefaultCreativeSpecModel.ObjectStorySpecModel.Serializer.a(java.lang.Object, com.fasterxml.jackson.core.JsonGenerator, com.fasterxml.jackson.databind.SerializerProvider):void");
                        }

                        static {
                            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                            /*
                            r0 = com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.BoostedComponentModel.DefaultSpecModel.DefaultCreativeSpecModel.ObjectStorySpecModel.class;
                            r1 = new com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels$BoostedComponentModel$DefaultSpecModel$DefaultCreativeSpecModel$ObjectStorySpecModel$Serializer;
                            r1.<init>();
                            com.facebook.common.json.FbSerializerProvider.a(r0, r1);
                            return;
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.BoostedComponentModel.DefaultSpecModel.DefaultCreativeSpecModel.ObjectStorySpecModel.Serializer.<clinit>():void");
                        }
                    }

                    public ObjectStorySpecModel() {
                        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                        /*
                        r1 = this;
                        r0 = 1;
                        r1.<init>(r0);
                        return;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.BoostedComponentModel.DefaultSpecModel.DefaultCreativeSpecModel.ObjectStorySpecModel.<init>():void");
                    }

                    @javax.annotation.Nullable
                    public final com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.BoostedComponentModel.DefaultSpecModel.DefaultCreativeSpecModel.ObjectStorySpecModel.LinkDataModel m23296a() {
                        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                        /*
                        r3 = this;
                        r0 = r3.f22066d;
                        r1 = 0;
                        r2 = com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.BoostedComponentModel.DefaultSpecModel.DefaultCreativeSpecModel.ObjectStorySpecModel.LinkDataModel.class;
                        r0 = super.a(r0, r1, r2);
                        r0 = (com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.BoostedComponentModel.DefaultSpecModel.DefaultCreativeSpecModel.ObjectStorySpecModel.LinkDataModel) r0;
                        r3.f22066d = r0;
                        r0 = r3.f22066d;
                        return r0;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.BoostedComponentModel.DefaultSpecModel.DefaultCreativeSpecModel.ObjectStorySpecModel.a():com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels$BoostedComponentModel$DefaultSpecModel$DefaultCreativeSpecModel$ObjectStorySpecModel$LinkDataModel");
                    }

                    public final int jK_() {
                        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                        /*
                        r1 = this;
                        r0 = 278753040; // 0x109d6f10 float:6.20967E-29 double:1.377223007E-315;
                        return r0;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.BoostedComponentModel.DefaultSpecModel.DefaultCreativeSpecModel.ObjectStorySpecModel.jK_():int");
                    }

                    public final com.facebook.graphql.visitor.GraphQLVisitableModel m23297a(com.facebook.graphql.visitor.GraphQLModelMutatingVisitor r4) {
                        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                        /*
                        r3 = this;
                        r1 = 0;
                        r3.h();
                        r0 = r3.m23296a();
                        if (r0 == 0) goto L_0x0022;
                    L_0x000a:
                        r0 = r3.m23296a();
                        r0 = r4.b(r0);
                        r0 = (com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.BoostedComponentModel.DefaultSpecModel.DefaultCreativeSpecModel.ObjectStorySpecModel.LinkDataModel) r0;
                        r2 = r3.m23296a();
                        if (r2 == r0) goto L_0x0022;
                    L_0x001a:
                        r1 = com.facebook.graphql.modelutil.ModelHelper.a(r1, r3);
                        r1 = (com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.BoostedComponentModel.DefaultSpecModel.DefaultCreativeSpecModel.ObjectStorySpecModel) r1;
                        r1.f22066d = r0;
                    L_0x0022:
                        r3.i();
                        if (r1 != 0) goto L_0x0028;
                    L_0x0027:
                        return r3;
                    L_0x0028:
                        r3 = r1;
                        goto L_0x0027;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.BoostedComponentModel.DefaultSpecModel.DefaultCreativeSpecModel.ObjectStorySpecModel.a(com.facebook.graphql.visitor.GraphQLModelMutatingVisitor):com.facebook.graphql.visitor.GraphQLVisitableModel");
                    }

                    public final int m23295a(com.facebook.flatbuffers.FlatBufferBuilder r3) {
                        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                        /*
                        r2 = this;
                        r2.h();
                        r0 = r2.m23296a();
                        r0 = com.facebook.graphql.modelutil.ModelHelper.a(r3, r0);
                        r1 = 1;
                        r3.c(r1);
                        r1 = 0;
                        r3.b(r1, r0);
                        r2.i();
                        r0 = r3.d();
                        return r0;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.BoostedComponentModel.DefaultSpecModel.DefaultCreativeSpecModel.ObjectStorySpecModel.a(com.facebook.flatbuffers.FlatBufferBuilder):int");
                    }
                }

                /* compiled from: ZA */
                public class Serializer extends JsonSerializer<DefaultCreativeSpecModel> {
                    public final void m23298a(java.lang.Object r8, com.fasterxml.jackson.core.JsonGenerator r9, com.fasterxml.jackson.databind.SerializerProvider r10) {
                        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                        /*
                        r7 = this;
                        r8 = (com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.BoostedComponentModel.DefaultSpecModel.DefaultCreativeSpecModel) r8;
                        r2 = 0;
                        r0 = r8.w_();
                        if (r0 != 0) goto L_0x0035;
                    L_0x0009:
                        r0 = new com.facebook.flatbuffers.FlatBufferBuilder;
                        r1 = 128; // 0x80 float:1.794E-43 double:6.32E-322;
                        r0.<init>(r1);
                        r1 = r8.m23301a(r0);
                        r0.d(r1);
                        r0 = r0.e();
                        r1 = java.nio.ByteBuffer.wrap(r0);
                        r0 = 0;
                        r1.position(r0);
                        r0 = new com.facebook.flatbuffers.MutableFlatBuffer;
                        r4 = 1;
                        r3 = r2;
                        r5 = r2;
                        r0.<init>(r1, r2, r3, r4, r5);
                        r6 = r0.a;
                        r1 = r6;
                        r1 = com.facebook.flatbuffers.FlatBuffer.a(r1);
                        r8.a(r0, r1);
                    L_0x0035:
                        r0 = r8.w_();
                        r1 = r8.u_();
                        com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsParsers.BoostedComponentParser.DefaultSpecParser.DefaultCreativeSpecParser.m23814a(r0, r1, r9, r10);
                        return;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.BoostedComponentModel.DefaultSpecModel.DefaultCreativeSpecModel.Serializer.a(java.lang.Object, com.fasterxml.jackson.core.JsonGenerator, com.fasterxml.jackson.databind.SerializerProvider):void");
                    }

                    static {
                        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                        /*
                        r0 = com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.BoostedComponentModel.DefaultSpecModel.DefaultCreativeSpecModel.class;
                        r1 = new com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels$BoostedComponentModel$DefaultSpecModel$DefaultCreativeSpecModel$Serializer;
                        r1.<init>();
                        com.facebook.common.json.FbSerializerProvider.a(r0, r1);
                        return;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.BoostedComponentModel.DefaultSpecModel.DefaultCreativeSpecModel.Serializer.<clinit>():void");
                    }
                }

                public DefaultCreativeSpecModel() {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r1 = this;
                    r0 = 5;
                    r1.<init>(r0);
                    return;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.BoostedComponentModel.DefaultSpecModel.DefaultCreativeSpecModel.<init>():void");
                }

                @javax.annotation.Nullable
                public final java.lang.String m23303a() {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r2 = this;
                    r0 = r2.f22067d;
                    r1 = 0;
                    r0 = super.a(r0, r1);
                    r2.f22067d = r0;
                    r0 = r2.f22067d;
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.BoostedComponentModel.DefaultSpecModel.DefaultCreativeSpecModel.a():java.lang.String");
                }

                @javax.annotation.Nullable
                private java.lang.String m23299l() {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r2 = this;
                    r0 = r2.f22068e;
                    r1 = 1;
                    r0 = super.a(r0, r1);
                    r2.f22068e = r0;
                    r0 = r2.f22068e;
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.BoostedComponentModel.DefaultSpecModel.DefaultCreativeSpecModel.l():java.lang.String");
                }

                @javax.annotation.Nullable
                public final java.lang.String m23304j() {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r2 = this;
                    r0 = r2.f22069f;
                    r1 = 2;
                    r0 = super.a(r0, r1);
                    r2.f22069f = r0;
                    r0 = r2.f22069f;
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.BoostedComponentModel.DefaultSpecModel.DefaultCreativeSpecModel.j():java.lang.String");
                }

                @javax.annotation.Nullable
                private java.lang.String m23300m() {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r2 = this;
                    r0 = r2.f22070g;
                    r1 = 3;
                    r0 = super.a(r0, r1);
                    r2.f22070g = r0;
                    r0 = r2.f22070g;
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.BoostedComponentModel.DefaultSpecModel.DefaultCreativeSpecModel.m():java.lang.String");
                }

                @javax.annotation.Nullable
                public final com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.BoostedComponentModel.DefaultSpecModel.DefaultCreativeSpecModel.ObjectStorySpecModel m23305k() {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r3 = this;
                    r0 = r3.f22071h;
                    r1 = 4;
                    r2 = com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.BoostedComponentModel.DefaultSpecModel.DefaultCreativeSpecModel.ObjectStorySpecModel.class;
                    r0 = super.a(r0, r1, r2);
                    r0 = (com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.BoostedComponentModel.DefaultSpecModel.DefaultCreativeSpecModel.ObjectStorySpecModel) r0;
                    r3.f22071h = r0;
                    r0 = r3.f22071h;
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.BoostedComponentModel.DefaultSpecModel.DefaultCreativeSpecModel.k():com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels$BoostedComponentModel$DefaultSpecModel$DefaultCreativeSpecModel$ObjectStorySpecModel");
                }

                public final int jK_() {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r1 = this;
                    r0 = -1905623324; // 0xffffffff8e6a7ee4 float:-2.8903822E-30 double:NaN;
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.BoostedComponentModel.DefaultSpecModel.DefaultCreativeSpecModel.jK_():int");
                }

                public final com.facebook.graphql.visitor.GraphQLVisitableModel m23302a(com.facebook.graphql.visitor.GraphQLModelMutatingVisitor r4) {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r3 = this;
                    r1 = 0;
                    r3.h();
                    r0 = r3.m23305k();
                    if (r0 == 0) goto L_0x0022;
                L_0x000a:
                    r0 = r3.m23305k();
                    r0 = r4.b(r0);
                    r0 = (com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.BoostedComponentModel.DefaultSpecModel.DefaultCreativeSpecModel.ObjectStorySpecModel) r0;
                    r2 = r3.m23305k();
                    if (r2 == r0) goto L_0x0022;
                L_0x001a:
                    r1 = com.facebook.graphql.modelutil.ModelHelper.a(r1, r3);
                    r1 = (com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.BoostedComponentModel.DefaultSpecModel.DefaultCreativeSpecModel) r1;
                    r1.f22071h = r0;
                L_0x0022:
                    r3.i();
                    if (r1 != 0) goto L_0x0028;
                L_0x0027:
                    return r3;
                L_0x0028:
                    r3 = r1;
                    goto L_0x0027;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.BoostedComponentModel.DefaultSpecModel.DefaultCreativeSpecModel.a(com.facebook.graphql.visitor.GraphQLModelMutatingVisitor):com.facebook.graphql.visitor.GraphQLVisitableModel");
                }

                public final int m23301a(com.facebook.flatbuffers.FlatBufferBuilder r7) {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r6 = this;
                    r6.h();
                    r0 = r6.m23303a();
                    r0 = r7.b(r0);
                    r1 = r6.m23299l();
                    r1 = r7.b(r1);
                    r2 = r6.m23304j();
                    r2 = r7.b(r2);
                    r3 = r6.m23300m();
                    r3 = r7.b(r3);
                    r4 = r6.m23305k();
                    r4 = com.facebook.graphql.modelutil.ModelHelper.a(r7, r4);
                    r5 = 5;
                    r7.c(r5);
                    r5 = 0;
                    r7.b(r5, r0);
                    r0 = 1;
                    r7.b(r0, r1);
                    r0 = 2;
                    r7.b(r0, r2);
                    r0 = 3;
                    r7.b(r0, r3);
                    r0 = 4;
                    r7.b(r0, r4);
                    r6.i();
                    r0 = r7.d();
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.BoostedComponentModel.DefaultSpecModel.DefaultCreativeSpecModel.a(com.facebook.flatbuffers.FlatBufferBuilder):int");
                }
            }

            /* compiled from: ZA */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r0 = com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.BoostedComponentModel.DefaultSpecModel.class;
                    r1 = new com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels$BoostedComponentModel$DefaultSpecModel$Deserializer;
                    r1.<init>();
                    com.facebook.common.json.GlobalAutoGenDeserializerCache.a(r0, r1);
                    return;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.BoostedComponentModel.DefaultSpecModel.Deserializer.<clinit>():void");
                }

                public java.lang.Object m23306a(com.fasterxml.jackson.core.JsonParser r11, com.fasterxml.jackson.databind.DeserializationContext r12) {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r10 = this;
                    r8 = 1;
                    r6 = 0;
                    r4 = new com.facebook.flatbuffers.FlatBufferBuilder;
                    r5 = 128; // 0x80 float:1.794E-43 double:6.32E-322;
                    r4.<init>(r5);
                    r5 = com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsParsers.BoostedComponentParser.DefaultSpecParser.m23815a(r11, r4);
                    r4.d(r5);
                    r4 = r4.e();
                    r5 = java.nio.ByteBuffer.wrap(r4);
                    r4 = 0;
                    r5.position(r4);
                    r4 = new com.facebook.flatbuffers.MutableFlatBuffer;
                    r7 = r6;
                    r9 = r6;
                    r4.<init>(r5, r6, r7, r8, r9);
                    r5 = 4;
                    r6 = java.lang.Boolean.valueOf(r8);
                    r4.a(r5, r6);
                    r2 = r4;
                    r1 = new com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels$BoostedComponentModel$DefaultSpecModel;
                    r1.<init>();
                    r4 = r2.a;
                    r0 = r4;
                    r3 = com.facebook.flatbuffers.FlatBuffer.a(r0);
                    r0 = r1;
                    r0 = (com.facebook.graphql.modelutil.BaseModel) r0;
                    r0.a(r2, r3, r11);
                    r0 = r1 instanceof com.facebook.common.json.Postprocessable;
                    if (r0 == 0) goto L_0x0048;
                L_0x0042:
                    r1 = (com.facebook.common.json.Postprocessable) r1;
                    r1 = r1.a();
                L_0x0048:
                    return r1;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.BoostedComponentModel.DefaultSpecModel.Deserializer.a(com.fasterxml.jackson.core.JsonParser, com.fasterxml.jackson.databind.DeserializationContext):java.lang.Object");
                }
            }

            /* compiled from: ZA */
            public class Serializer extends JsonSerializer<DefaultSpecModel> {
                public final void m23307a(java.lang.Object r8, com.fasterxml.jackson.core.JsonGenerator r9, com.fasterxml.jackson.databind.SerializerProvider r10) {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r7 = this;
                    r8 = (com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.BoostedComponentModel.DefaultSpecModel) r8;
                    r2 = 0;
                    r0 = r8.w_();
                    if (r0 != 0) goto L_0x0035;
                L_0x0009:
                    r0 = new com.facebook.flatbuffers.FlatBufferBuilder;
                    r1 = 128; // 0x80 float:1.794E-43 double:6.32E-322;
                    r0.<init>(r1);
                    r1 = r8.m23308a(r0);
                    r0.d(r1);
                    r0 = r0.e();
                    r1 = java.nio.ByteBuffer.wrap(r0);
                    r0 = 0;
                    r1.position(r0);
                    r0 = new com.facebook.flatbuffers.MutableFlatBuffer;
                    r4 = 1;
                    r3 = r2;
                    r5 = r2;
                    r0.<init>(r1, r2, r3, r4, r5);
                    r6 = r0.a;
                    r1 = r6;
                    r1 = com.facebook.flatbuffers.FlatBuffer.a(r1);
                    r8.a(r0, r1);
                L_0x0035:
                    r0 = r8.w_();
                    r1 = r8.u_();
                    com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsParsers.BoostedComponentParser.DefaultSpecParser.m23816a(r0, r1, r9, r10);
                    return;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.BoostedComponentModel.DefaultSpecModel.Serializer.a(java.lang.Object, com.fasterxml.jackson.core.JsonGenerator, com.fasterxml.jackson.databind.SerializerProvider):void");
                }

                static {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r0 = com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.BoostedComponentModel.DefaultSpecModel.class;
                    r1 = new com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels$BoostedComponentModel$DefaultSpecModel$Serializer;
                    r1.<init>();
                    com.facebook.common.json.FbSerializerProvider.a(r0, r1);
                    return;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.BoostedComponentModel.DefaultSpecModel.Serializer.<clinit>():void");
                }
            }

            public DefaultSpecModel() {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r1 = this;
                r0 = 5;
                r1.<init>(r0);
                return;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.BoostedComponentModel.DefaultSpecModel.<init>():void");
            }

            @javax.annotation.Nonnull
            public final com.google.common.collect.ImmutableList<com.facebook.graphql.enums.GraphQLCallToActionType> m23310a() {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r3 = this;
                r0 = r3.f22072d;
                r1 = 0;
                r2 = com.facebook.graphql.enums.GraphQLCallToActionType.class;
                r0 = super.c(r0, r1, r2);
                r3.f22072d = r0;
                r0 = r3.f22072d;
                r0 = (com.google.common.collect.ImmutableList) r0;
                return r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.BoostedComponentModel.DefaultSpecModel.a():com.google.common.collect.ImmutableList<com.facebook.graphql.enums.GraphQLCallToActionType>");
            }

            @javax.annotation.Nullable
            public final com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.BoostedComponentModel.DefaultSpecModel.AvailableAudiencesModel m23312j() {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r3 = this;
                r0 = r3.f22073e;
                r1 = 1;
                r2 = com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.BoostedComponentModel.DefaultSpecModel.AvailableAudiencesModel.class;
                r0 = super.a(r0, r1, r2);
                r0 = (com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.BoostedComponentModel.DefaultSpecModel.AvailableAudiencesModel) r0;
                r3.f22073e = r0;
                r0 = r3.f22073e;
                return r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.BoostedComponentModel.DefaultSpecModel.j():com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels$BoostedComponentModel$DefaultSpecModel$AvailableAudiencesModel");
            }

            @javax.annotation.Nullable
            public final com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.BoostedComponentModel.DefaultSpecModel.DefaultCreativeSpecModel m23313k() {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r3 = this;
                r0 = r3.f22074f;
                r1 = 2;
                r2 = com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.BoostedComponentModel.DefaultSpecModel.DefaultCreativeSpecModel.class;
                r0 = super.a(r0, r1, r2);
                r0 = (com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.BoostedComponentModel.DefaultSpecModel.DefaultCreativeSpecModel) r0;
                r3.f22074f = r0;
                r0 = r3.f22074f;
                return r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.BoostedComponentModel.DefaultSpecModel.k():com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels$BoostedComponentModel$DefaultSpecModel$DefaultCreativeSpecModel");
            }

            @javax.annotation.Nullable
            public final com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.TargetSpecificationsModel m23314l() {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r3 = this;
                r0 = r3.f22075g;
                r1 = 3;
                r2 = com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.TargetSpecificationsModel.class;
                r0 = super.a(r0, r1, r2);
                r0 = (com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.TargetSpecificationsModel) r0;
                r3.f22075g = r0;
                r0 = r3.f22075g;
                return r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.BoostedComponentModel.DefaultSpecModel.l():com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels$TargetSpecificationsModel");
            }

            public final int m23315m() {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r2 = this;
                r0 = 0;
                r1 = 4;
                r2.a(r0, r1);
                r0 = r2.f22076h;
                return r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.BoostedComponentModel.DefaultSpecModel.m():int");
            }

            public final int jK_() {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r1 = this;
                r0 = 1218236129; // 0x489ccee1 float:321143.03 double:6.0188862E-315;
                return r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.BoostedComponentModel.DefaultSpecModel.jK_():int");
            }

            public final com.facebook.graphql.visitor.GraphQLVisitableModel m23309a(com.facebook.graphql.visitor.GraphQLModelMutatingVisitor r4) {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r3 = this;
                r1 = 0;
                r3.h();
                r0 = r3.m23312j();
                if (r0 == 0) goto L_0x0022;
            L_0x000a:
                r0 = r3.m23312j();
                r0 = r4.b(r0);
                r0 = (com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.BoostedComponentModel.DefaultSpecModel.AvailableAudiencesModel) r0;
                r2 = r3.m23312j();
                if (r2 == r0) goto L_0x0022;
            L_0x001a:
                r1 = com.facebook.graphql.modelutil.ModelHelper.a(r1, r3);
                r1 = (com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.BoostedComponentModel.DefaultSpecModel) r1;
                r1.f22073e = r0;
            L_0x0022:
                r0 = r3.m23313k();
                if (r0 == 0) goto L_0x0040;
            L_0x0028:
                r0 = r3.m23313k();
                r0 = r4.b(r0);
                r0 = (com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.BoostedComponentModel.DefaultSpecModel.DefaultCreativeSpecModel) r0;
                r2 = r3.m23313k();
                if (r2 == r0) goto L_0x0040;
            L_0x0038:
                r1 = com.facebook.graphql.modelutil.ModelHelper.a(r1, r3);
                r1 = (com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.BoostedComponentModel.DefaultSpecModel) r1;
                r1.f22074f = r0;
            L_0x0040:
                r0 = r3.m23314l();
                if (r0 == 0) goto L_0x005e;
            L_0x0046:
                r0 = r3.m23314l();
                r0 = r4.b(r0);
                r0 = (com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.TargetSpecificationsModel) r0;
                r2 = r3.m23314l();
                if (r2 == r0) goto L_0x005e;
            L_0x0056:
                r1 = com.facebook.graphql.modelutil.ModelHelper.a(r1, r3);
                r1 = (com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.BoostedComponentModel.DefaultSpecModel) r1;
                r1.f22075g = r0;
            L_0x005e:
                r3.i();
                if (r1 != 0) goto L_0x0064;
            L_0x0063:
                return r3;
            L_0x0064:
                r3 = r1;
                goto L_0x0063;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.BoostedComponentModel.DefaultSpecModel.a(com.facebook.graphql.visitor.GraphQLModelMutatingVisitor):com.facebook.graphql.visitor.GraphQLVisitableModel");
            }

            public final int m23308a(com.facebook.flatbuffers.FlatBufferBuilder r7) {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r6 = this;
                r5 = 0;
                r6.h();
                r0 = r6.m23310a();
                r0 = r7.d(r0);
                r1 = r6.m23312j();
                r1 = com.facebook.graphql.modelutil.ModelHelper.a(r7, r1);
                r2 = r6.m23313k();
                r2 = com.facebook.graphql.modelutil.ModelHelper.a(r7, r2);
                r3 = r6.m23314l();
                r3 = com.facebook.graphql.modelutil.ModelHelper.a(r7, r3);
                r4 = 5;
                r7.c(r4);
                r7.b(r5, r0);
                r0 = 1;
                r7.b(r0, r1);
                r0 = 2;
                r7.b(r0, r2);
                r0 = 3;
                r7.b(r0, r3);
                r0 = 4;
                r1 = r6.f22076h;
                r7.a(r0, r1, r5);
                r6.i();
                r0 = r7.d();
                return r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.BoostedComponentModel.DefaultSpecModel.a(com.facebook.flatbuffers.FlatBufferBuilder):int");
            }

            public final void m23311a(com.facebook.flatbuffers.MutableFlatBuffer r3, int r4, java.lang.Object r5) {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r2 = this;
                super.a(r3, r4, r5);
                r0 = 4;
                r1 = 0;
                r0 = r3.a(r4, r0, r1);
                r2.f22076h = r0;
                return;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.BoostedComponentModel.DefaultSpecModel.a(com.facebook.flatbuffers.MutableFlatBuffer, int, java.lang.Object):void");
            }
        }

        /* compiled from: ZA */
        public class Deserializer extends FbJsonDeserializer {
            static {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r0 = com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.BoostedComponentModel.class;
                r1 = new com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels$BoostedComponentModel$Deserializer;
                r1.<init>();
                com.facebook.common.json.GlobalAutoGenDeserializerCache.a(r0, r1);
                return;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.BoostedComponentModel.Deserializer.<clinit>():void");
            }

            public java.lang.Object m23316a(com.fasterxml.jackson.core.JsonParser r11, com.fasterxml.jackson.databind.DeserializationContext r12) {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r10 = this;
                r8 = 1;
                r6 = 0;
                r4 = new com.facebook.flatbuffers.FlatBufferBuilder;
                r5 = 128; // 0x80 float:1.794E-43 double:6.32E-322;
                r4.<init>(r5);
                r5 = com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsParsers.BoostedComponentParser.m23824a(r11, r4);
                r4.d(r5);
                r4 = r4.e();
                r5 = java.nio.ByteBuffer.wrap(r4);
                r4 = 0;
                r5.position(r4);
                r4 = new com.facebook.flatbuffers.MutableFlatBuffer;
                r7 = r6;
                r9 = r6;
                r4.<init>(r5, r6, r7, r8, r9);
                r5 = 4;
                r6 = java.lang.Boolean.valueOf(r8);
                r4.a(r5, r6);
                r2 = r4;
                r1 = new com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels$BoostedComponentModel;
                r1.<init>();
                r4 = r2.a;
                r0 = r4;
                r3 = com.facebook.flatbuffers.FlatBuffer.a(r0);
                r0 = r1;
                r0 = (com.facebook.graphql.modelutil.BaseModel) r0;
                r0.a(r2, r3, r11);
                r0 = r1 instanceof com.facebook.common.json.Postprocessable;
                if (r0 == 0) goto L_0x0048;
            L_0x0042:
                r1 = (com.facebook.common.json.Postprocessable) r1;
                r1 = r1.a();
            L_0x0048:
                return r1;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.BoostedComponentModel.Deserializer.a(com.fasterxml.jackson.core.JsonParser, com.fasterxml.jackson.databind.DeserializationContext):java.lang.Object");
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 1957519832)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: ZA */
        public final class InsightsModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private List<CtaClicksModel> f22079d;
            private int f22080e;
            private int f22081f;
            private int f22082g;
            private int f22083h;

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = 2058051774)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: ZA */
            public final class CtaClicksModel extends BaseModel implements GraphQLVisitableModel {
                private int f22077d;
                @Nullable
                private GraphQLCallToActionType f22078e;

                /* compiled from: ZA */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                        /*
                        r0 = com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.BoostedComponentModel.InsightsModel.CtaClicksModel.class;
                        r1 = new com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels$BoostedComponentModel$InsightsModel$CtaClicksModel$Deserializer;
                        r1.<init>();
                        com.facebook.common.json.GlobalAutoGenDeserializerCache.a(r0, r1);
                        return;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.BoostedComponentModel.InsightsModel.CtaClicksModel.Deserializer.<clinit>():void");
                    }

                    public java.lang.Object m23317a(com.fasterxml.jackson.core.JsonParser r11, com.fasterxml.jackson.databind.DeserializationContext r12) {
                        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                        /*
                        r10 = this;
                        r8 = 1;
                        r6 = 0;
                        r4 = new com.facebook.flatbuffers.FlatBufferBuilder;
                        r5 = 128; // 0x80 float:1.794E-43 double:6.32E-322;
                        r4.<init>(r5);
                        r5 = com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsParsers.BoostedComponentParser.InsightsParser.CtaClicksParser.m23819b(r11, r4);
                        r4.d(r5);
                        r4 = r4.e();
                        r5 = java.nio.ByteBuffer.wrap(r4);
                        r4 = 0;
                        r5.position(r4);
                        r4 = new com.facebook.flatbuffers.MutableFlatBuffer;
                        r7 = r6;
                        r9 = r6;
                        r4.<init>(r5, r6, r7, r8, r9);
                        r5 = 4;
                        r6 = java.lang.Boolean.valueOf(r8);
                        r4.a(r5, r6);
                        r2 = r4;
                        r1 = new com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels$BoostedComponentModel$InsightsModel$CtaClicksModel;
                        r1.<init>();
                        r4 = r2.a;
                        r0 = r4;
                        r3 = com.facebook.flatbuffers.FlatBuffer.a(r0);
                        r0 = r1;
                        r0 = (com.facebook.graphql.modelutil.BaseModel) r0;
                        r0.a(r2, r3, r11);
                        r0 = r1 instanceof com.facebook.common.json.Postprocessable;
                        if (r0 == 0) goto L_0x0048;
                    L_0x0042:
                        r1 = (com.facebook.common.json.Postprocessable) r1;
                        r1 = r1.a();
                    L_0x0048:
                        return r1;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.BoostedComponentModel.InsightsModel.CtaClicksModel.Deserializer.a(com.fasterxml.jackson.core.JsonParser, com.fasterxml.jackson.databind.DeserializationContext):java.lang.Object");
                    }
                }

                /* compiled from: ZA */
                public class Serializer extends JsonSerializer<CtaClicksModel> {
                    public final void m23318a(java.lang.Object r8, com.fasterxml.jackson.core.JsonGenerator r9, com.fasterxml.jackson.databind.SerializerProvider r10) {
                        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                        /*
                        r7 = this;
                        r8 = (com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.BoostedComponentModel.InsightsModel.CtaClicksModel) r8;
                        r2 = 0;
                        r0 = r8.w_();
                        if (r0 != 0) goto L_0x0035;
                    L_0x0009:
                        r0 = new com.facebook.flatbuffers.FlatBufferBuilder;
                        r1 = 128; // 0x80 float:1.794E-43 double:6.32E-322;
                        r0.<init>(r1);
                        r1 = r8.m23320a(r0);
                        r0.d(r1);
                        r0 = r0.e();
                        r1 = java.nio.ByteBuffer.wrap(r0);
                        r0 = 0;
                        r1.position(r0);
                        r0 = new com.facebook.flatbuffers.MutableFlatBuffer;
                        r4 = 1;
                        r3 = r2;
                        r5 = r2;
                        r0.<init>(r1, r2, r3, r4, r5);
                        r6 = r0.a;
                        r1 = r6;
                        r1 = com.facebook.flatbuffers.FlatBuffer.a(r1);
                        r8.a(r0, r1);
                    L_0x0035:
                        r0 = r8.w_();
                        r1 = r8.u_();
                        com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsParsers.BoostedComponentParser.InsightsParser.CtaClicksParser.m23818a(r0, r1, r9);
                        return;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.BoostedComponentModel.InsightsModel.CtaClicksModel.Serializer.a(java.lang.Object, com.fasterxml.jackson.core.JsonGenerator, com.fasterxml.jackson.databind.SerializerProvider):void");
                    }

                    static {
                        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                        /*
                        r0 = com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.BoostedComponentModel.InsightsModel.CtaClicksModel.class;
                        r1 = new com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels$BoostedComponentModel$InsightsModel$CtaClicksModel$Serializer;
                        r1.<init>();
                        com.facebook.common.json.FbSerializerProvider.a(r0, r1);
                        return;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.BoostedComponentModel.InsightsModel.CtaClicksModel.Serializer.<clinit>():void");
                    }
                }

                public CtaClicksModel() {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r1 = this;
                    r0 = 2;
                    r1.<init>(r0);
                    return;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.BoostedComponentModel.InsightsModel.CtaClicksModel.<init>():void");
                }

                public final int m23319a() {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r1 = this;
                    r0 = 0;
                    r1.a(r0, r0);
                    r0 = r1.f22077d;
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.BoostedComponentModel.InsightsModel.CtaClicksModel.a():int");
                }

                @javax.annotation.Nullable
                public final com.facebook.graphql.enums.GraphQLCallToActionType m23323j() {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r4 = this;
                    r0 = r4.f22078e;
                    r1 = 1;
                    r2 = com.facebook.graphql.enums.GraphQLCallToActionType.class;
                    r3 = com.facebook.graphql.enums.GraphQLCallToActionType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
                    r0 = super.b(r0, r1, r2, r3);
                    r0 = (com.facebook.graphql.enums.GraphQLCallToActionType) r0;
                    r4.f22078e = r0;
                    r0 = r4.f22078e;
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.BoostedComponentModel.InsightsModel.CtaClicksModel.j():com.facebook.graphql.enums.GraphQLCallToActionType");
                }

                public final int jK_() {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r1 = this;
                    r0 = 170921289; // 0xa300d49 float:8.4765904E-33 double:8.4446337E-316;
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.BoostedComponentModel.InsightsModel.CtaClicksModel.jK_():int");
                }

                public final com.facebook.graphql.visitor.GraphQLVisitableModel m23321a(com.facebook.graphql.visitor.GraphQLModelMutatingVisitor r1) {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r0 = this;
                    r0.h();
                    r0.i();
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.BoostedComponentModel.InsightsModel.CtaClicksModel.a(com.facebook.graphql.visitor.GraphQLModelMutatingVisitor):com.facebook.graphql.visitor.GraphQLVisitableModel");
                }

                public final int m23320a(com.facebook.flatbuffers.FlatBufferBuilder r4) {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r3 = this;
                    r2 = 0;
                    r3.h();
                    r0 = r3.m23323j();
                    r0 = r4.a(r0);
                    r1 = 2;
                    r4.c(r1);
                    r1 = r3.f22077d;
                    r4.a(r2, r1, r2);
                    r1 = 1;
                    r4.b(r1, r0);
                    r3.i();
                    r0 = r4.d();
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.BoostedComponentModel.InsightsModel.CtaClicksModel.a(com.facebook.flatbuffers.FlatBufferBuilder):int");
                }

                public final void m23322a(com.facebook.flatbuffers.MutableFlatBuffer r2, int r3, java.lang.Object r4) {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r1 = this;
                    r0 = 0;
                    super.a(r2, r3, r4);
                    r0 = r2.a(r3, r0, r0);
                    r1.f22077d = r0;
                    return;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.BoostedComponentModel.InsightsModel.CtaClicksModel.a(com.facebook.flatbuffers.MutableFlatBuffer, int, java.lang.Object):void");
                }
            }

            /* compiled from: ZA */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r0 = com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.BoostedComponentModel.InsightsModel.class;
                    r1 = new com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels$BoostedComponentModel$InsightsModel$Deserializer;
                    r1.<init>();
                    com.facebook.common.json.GlobalAutoGenDeserializerCache.a(r0, r1);
                    return;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.BoostedComponentModel.InsightsModel.Deserializer.<clinit>():void");
                }

                public java.lang.Object m23324a(com.fasterxml.jackson.core.JsonParser r11, com.fasterxml.jackson.databind.DeserializationContext r12) {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r10 = this;
                    r8 = 1;
                    r6 = 0;
                    r4 = new com.facebook.flatbuffers.FlatBufferBuilder;
                    r5 = 128; // 0x80 float:1.794E-43 double:6.32E-322;
                    r4.<init>(r5);
                    r5 = com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsParsers.BoostedComponentParser.InsightsParser.m23820a(r11, r4);
                    r4.d(r5);
                    r4 = r4.e();
                    r5 = java.nio.ByteBuffer.wrap(r4);
                    r4 = 0;
                    r5.position(r4);
                    r4 = new com.facebook.flatbuffers.MutableFlatBuffer;
                    r7 = r6;
                    r9 = r6;
                    r4.<init>(r5, r6, r7, r8, r9);
                    r5 = 4;
                    r6 = java.lang.Boolean.valueOf(r8);
                    r4.a(r5, r6);
                    r2 = r4;
                    r1 = new com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels$BoostedComponentModel$InsightsModel;
                    r1.<init>();
                    r4 = r2.a;
                    r0 = r4;
                    r3 = com.facebook.flatbuffers.FlatBuffer.a(r0);
                    r0 = r1;
                    r0 = (com.facebook.graphql.modelutil.BaseModel) r0;
                    r0.a(r2, r3, r11);
                    r0 = r1 instanceof com.facebook.common.json.Postprocessable;
                    if (r0 == 0) goto L_0x0048;
                L_0x0042:
                    r1 = (com.facebook.common.json.Postprocessable) r1;
                    r1 = r1.a();
                L_0x0048:
                    return r1;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.BoostedComponentModel.InsightsModel.Deserializer.a(com.fasterxml.jackson.core.JsonParser, com.fasterxml.jackson.databind.DeserializationContext):java.lang.Object");
                }
            }

            /* compiled from: ZA */
            public class Serializer extends JsonSerializer<InsightsModel> {
                public final void m23325a(java.lang.Object r8, com.fasterxml.jackson.core.JsonGenerator r9, com.fasterxml.jackson.databind.SerializerProvider r10) {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r7 = this;
                    r8 = (com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.BoostedComponentModel.InsightsModel) r8;
                    r2 = 0;
                    r0 = r8.w_();
                    if (r0 != 0) goto L_0x0035;
                L_0x0009:
                    r0 = new com.facebook.flatbuffers.FlatBufferBuilder;
                    r1 = 128; // 0x80 float:1.794E-43 double:6.32E-322;
                    r0.<init>(r1);
                    r1 = r8.m23326a(r0);
                    r0.d(r1);
                    r0 = r0.e();
                    r1 = java.nio.ByteBuffer.wrap(r0);
                    r0 = 0;
                    r1.position(r0);
                    r0 = new com.facebook.flatbuffers.MutableFlatBuffer;
                    r4 = 1;
                    r3 = r2;
                    r5 = r2;
                    r0.<init>(r1, r2, r3, r4, r5);
                    r6 = r0.a;
                    r1 = r6;
                    r1 = com.facebook.flatbuffers.FlatBuffer.a(r1);
                    r8.a(r0, r1);
                L_0x0035:
                    r0 = r8.w_();
                    r1 = r8.u_();
                    com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsParsers.BoostedComponentParser.InsightsParser.m23821a(r0, r1, r9, r10);
                    return;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.BoostedComponentModel.InsightsModel.Serializer.a(java.lang.Object, com.fasterxml.jackson.core.JsonGenerator, com.fasterxml.jackson.databind.SerializerProvider):void");
                }

                static {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r0 = com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.BoostedComponentModel.InsightsModel.class;
                    r1 = new com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels$BoostedComponentModel$InsightsModel$Serializer;
                    r1.<init>();
                    com.facebook.common.json.FbSerializerProvider.a(r0, r1);
                    return;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.BoostedComponentModel.InsightsModel.Serializer.<clinit>():void");
                }
            }

            public InsightsModel() {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r1 = this;
                r0 = 5;
                r1.<init>(r0);
                return;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.BoostedComponentModel.InsightsModel.<init>():void");
            }

            @javax.annotation.Nonnull
            public final com.google.common.collect.ImmutableList<com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.BoostedComponentModel.InsightsModel.CtaClicksModel> m23328a() {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r3 = this;
                r0 = r3.f22079d;
                r1 = 0;
                r2 = com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.BoostedComponentModel.InsightsModel.CtaClicksModel.class;
                r0 = super.a(r0, r1, r2);
                r3.f22079d = r0;
                r0 = r3.f22079d;
                r0 = (com.google.common.collect.ImmutableList) r0;
                return r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.BoostedComponentModel.InsightsModel.a():com.google.common.collect.ImmutableList<com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels$BoostedComponentModel$InsightsModel$CtaClicksModel>");
            }

            public final int m23330j() {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r2 = this;
                r0 = 0;
                r1 = 2;
                r2.a(r0, r1);
                r0 = r2.f22081f;
                return r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.BoostedComponentModel.InsightsModel.j():int");
            }

            public final int m23331k() {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r2 = this;
                r0 = 0;
                r1 = 3;
                r2.a(r0, r1);
                r0 = r2.f22082g;
                return r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.BoostedComponentModel.InsightsModel.k():int");
            }

            public final int m23332l() {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r2 = this;
                r0 = 0;
                r1 = 4;
                r2.a(r0, r1);
                r0 = r2.f22083h;
                return r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.BoostedComponentModel.InsightsModel.l():int");
            }

            public final int jK_() {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r1 = this;
                r0 = -1563439156; // 0xffffffffa2cfcfcc float:-5.6327476E-18 double:NaN;
                return r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.BoostedComponentModel.InsightsModel.jK_():int");
            }

            public final com.facebook.graphql.visitor.GraphQLVisitableModel m23327a(com.facebook.graphql.visitor.GraphQLModelMutatingVisitor r3) {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r2 = this;
                r0 = 0;
                r2.h();
                r1 = r2.m23328a();
                if (r1 == 0) goto L_0x0020;
            L_0x000a:
                r1 = r2.m23328a();
                r1 = com.facebook.graphql.modelutil.ModelHelper.a(r1, r3);
                if (r1 == 0) goto L_0x0020;
            L_0x0014:
                r0 = com.facebook.graphql.modelutil.ModelHelper.a(r0, r2);
                r0 = (com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.BoostedComponentModel.InsightsModel) r0;
                r1 = r1.b();
                r0.f22079d = r1;
            L_0x0020:
                r2.i();
                if (r0 != 0) goto L_0x0026;
            L_0x0025:
                return r2;
            L_0x0026:
                r2 = r0;
                goto L_0x0025;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.BoostedComponentModel.InsightsModel.a(com.facebook.graphql.visitor.GraphQLModelMutatingVisitor):com.facebook.graphql.visitor.GraphQLVisitableModel");
            }

            public final int m23326a(com.facebook.flatbuffers.FlatBufferBuilder r4) {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r3 = this;
                r2 = 0;
                r3.h();
                r0 = r3.m23328a();
                r0 = com.facebook.graphql.modelutil.ModelHelper.a(r4, r0);
                r1 = 5;
                r4.c(r1);
                r4.b(r2, r0);
                r0 = 1;
                r1 = r3.f22080e;
                r4.a(r0, r1, r2);
                r0 = 2;
                r1 = r3.f22081f;
                r4.a(r0, r1, r2);
                r0 = 3;
                r1 = r3.f22082g;
                r4.a(r0, r1, r2);
                r0 = 4;
                r1 = r3.f22083h;
                r4.a(r0, r1, r2);
                r3.i();
                r0 = r4.d();
                return r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.BoostedComponentModel.InsightsModel.a(com.facebook.flatbuffers.FlatBufferBuilder):int");
            }

            public final void m23329a(com.facebook.flatbuffers.MutableFlatBuffer r3, int r4, java.lang.Object r5) {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r2 = this;
                r1 = 0;
                super.a(r3, r4, r5);
                r0 = 1;
                r0 = r3.a(r4, r0, r1);
                r2.f22080e = r0;
                r0 = 2;
                r0 = r3.a(r4, r0, r1);
                r2.f22081f = r0;
                r0 = 3;
                r0 = r3.a(r4, r0, r1);
                r2.f22082g = r0;
                r0 = 4;
                r0 = r3.a(r4, r0, r1);
                r2.f22083h = r0;
                return;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.BoostedComponentModel.InsightsModel.a(com.facebook.flatbuffers.MutableFlatBuffer, int, java.lang.Object):void");
            }
        }

        /* compiled from: ZA */
        public class Serializer extends JsonSerializer<BoostedComponentModel> {
            public final void m23333a(java.lang.Object r8, com.fasterxml.jackson.core.JsonGenerator r9, com.fasterxml.jackson.databind.SerializerProvider r10) {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r7 = this;
                r8 = (com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.BoostedComponentModel) r8;
                r2 = 0;
                r0 = r8.w_();
                if (r0 != 0) goto L_0x0035;
            L_0x0009:
                r0 = new com.facebook.flatbuffers.FlatBufferBuilder;
                r1 = 128; // 0x80 float:1.794E-43 double:6.32E-322;
                r0.<init>(r1);
                r1 = r8.m23339a(r0);
                r0.d(r1);
                r0 = r0.e();
                r1 = java.nio.ByteBuffer.wrap(r0);
                r0 = 0;
                r1.position(r0);
                r0 = new com.facebook.flatbuffers.MutableFlatBuffer;
                r4 = 1;
                r3 = r2;
                r5 = r2;
                r0.<init>(r1, r2, r3, r4, r5);
                r6 = r0.a;
                r1 = r6;
                r1 = com.facebook.flatbuffers.FlatBuffer.a(r1);
                r8.a(r0, r1);
            L_0x0035:
                r0 = r8.w_();
                r1 = r8.u_();
                com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsParsers.BoostedComponentParser.m23827b(r0, r1, r9, r10);
                return;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.BoostedComponentModel.Serializer.a(java.lang.Object, com.fasterxml.jackson.core.JsonGenerator, com.fasterxml.jackson.databind.SerializerProvider):void");
            }

            static {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r0 = com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.BoostedComponentModel.class;
                r1 = new com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels$BoostedComponentModel$Serializer;
                r1.<init>();
                com.facebook.common.json.FbSerializerProvider.a(r0, r1);
                return;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.BoostedComponentModel.Serializer.<clinit>():void");
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1104351312)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: ZA */
        public final class TargetingDescriptionModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private List<TargetingDescriptionModel> f22084d;

            /* compiled from: ZA */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r0 = com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.BoostedComponentModel.TargetingDescriptionModel.class;
                    r1 = new com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels$BoostedComponentModel$TargetingDescriptionModel$Deserializer;
                    r1.<init>();
                    com.facebook.common.json.GlobalAutoGenDeserializerCache.a(r0, r1);
                    return;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.BoostedComponentModel.TargetingDescriptionModel.Deserializer.<clinit>():void");
                }

                public java.lang.Object m23334a(com.fasterxml.jackson.core.JsonParser r11, com.fasterxml.jackson.databind.DeserializationContext r12) {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r10 = this;
                    r8 = 1;
                    r6 = 0;
                    r4 = new com.facebook.flatbuffers.FlatBufferBuilder;
                    r5 = 128; // 0x80 float:1.794E-43 double:6.32E-322;
                    r4.<init>(r5);
                    r5 = com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsParsers.BoostedComponentParser.TargetingDescriptionParser.m23822a(r11, r4);
                    r4.d(r5);
                    r4 = r4.e();
                    r5 = java.nio.ByteBuffer.wrap(r4);
                    r4 = 0;
                    r5.position(r4);
                    r4 = new com.facebook.flatbuffers.MutableFlatBuffer;
                    r7 = r6;
                    r9 = r6;
                    r4.<init>(r5, r6, r7, r8, r9);
                    r5 = 4;
                    r6 = java.lang.Boolean.valueOf(r8);
                    r4.a(r5, r6);
                    r2 = r4;
                    r1 = new com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels$BoostedComponentModel$TargetingDescriptionModel;
                    r1.<init>();
                    r4 = r2.a;
                    r0 = r4;
                    r3 = com.facebook.flatbuffers.FlatBuffer.a(r0);
                    r0 = r1;
                    r0 = (com.facebook.graphql.modelutil.BaseModel) r0;
                    r0.a(r2, r3, r11);
                    r0 = r1 instanceof com.facebook.common.json.Postprocessable;
                    if (r0 == 0) goto L_0x0048;
                L_0x0042:
                    r1 = (com.facebook.common.json.Postprocessable) r1;
                    r1 = r1.a();
                L_0x0048:
                    return r1;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.BoostedComponentModel.TargetingDescriptionModel.Deserializer.a(com.fasterxml.jackson.core.JsonParser, com.fasterxml.jackson.databind.DeserializationContext):java.lang.Object");
                }
            }

            /* compiled from: ZA */
            public class Serializer extends JsonSerializer<TargetingDescriptionModel> {
                public final void m23335a(java.lang.Object r8, com.fasterxml.jackson.core.JsonGenerator r9, com.fasterxml.jackson.databind.SerializerProvider r10) {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r7 = this;
                    r8 = (com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.BoostedComponentModel.TargetingDescriptionModel) r8;
                    r2 = 0;
                    r0 = r8.w_();
                    if (r0 != 0) goto L_0x0035;
                L_0x0009:
                    r0 = new com.facebook.flatbuffers.FlatBufferBuilder;
                    r1 = 128; // 0x80 float:1.794E-43 double:6.32E-322;
                    r0.<init>(r1);
                    r1 = r8.m23336a(r0);
                    r0.d(r1);
                    r0 = r0.e();
                    r1 = java.nio.ByteBuffer.wrap(r0);
                    r0 = 0;
                    r1.position(r0);
                    r0 = new com.facebook.flatbuffers.MutableFlatBuffer;
                    r4 = 1;
                    r3 = r2;
                    r5 = r2;
                    r0.<init>(r1, r2, r3, r4, r5);
                    r6 = r0.a;
                    r1 = r6;
                    r1 = com.facebook.flatbuffers.FlatBuffer.a(r1);
                    r8.a(r0, r1);
                L_0x0035:
                    r0 = r8.w_();
                    r1 = r8.u_();
                    com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsParsers.BoostedComponentParser.TargetingDescriptionParser.m23823a(r0, r1, r9, r10);
                    return;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.BoostedComponentModel.TargetingDescriptionModel.Serializer.a(java.lang.Object, com.fasterxml.jackson.core.JsonGenerator, com.fasterxml.jackson.databind.SerializerProvider):void");
                }

                static {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r0 = com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.BoostedComponentModel.TargetingDescriptionModel.class;
                    r1 = new com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels$BoostedComponentModel$TargetingDescriptionModel$Serializer;
                    r1.<init>();
                    com.facebook.common.json.FbSerializerProvider.a(r0, r1);
                    return;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.BoostedComponentModel.TargetingDescriptionModel.Serializer.<clinit>():void");
                }
            }

            public TargetingDescriptionModel() {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r1 = this;
                r0 = 1;
                r1.<init>(r0);
                return;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.BoostedComponentModel.TargetingDescriptionModel.<init>():void");
            }

            @javax.annotation.Nonnull
            public final com.google.common.collect.ImmutableList<com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.TargetingDescriptionModel> m23338a() {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r3 = this;
                r0 = r3.f22084d;
                r1 = 0;
                r2 = com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.TargetingDescriptionModel.class;
                r0 = super.a(r0, r1, r2);
                r3.f22084d = r0;
                r0 = r3.f22084d;
                r0 = (com.google.common.collect.ImmutableList) r0;
                return r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.BoostedComponentModel.TargetingDescriptionModel.a():com.google.common.collect.ImmutableList<com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels$TargetingDescriptionModel>");
            }

            public final int jK_() {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r1 = this;
                r0 = -1772482972; // 0xffffffff965a0e64 float:-1.7614441E-25 double:NaN;
                return r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.BoostedComponentModel.TargetingDescriptionModel.jK_():int");
            }

            public final com.facebook.graphql.visitor.GraphQLVisitableModel m23337a(com.facebook.graphql.visitor.GraphQLModelMutatingVisitor r3) {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r2 = this;
                r0 = 0;
                r2.h();
                r1 = r2.m23338a();
                if (r1 == 0) goto L_0x0020;
            L_0x000a:
                r1 = r2.m23338a();
                r1 = com.facebook.graphql.modelutil.ModelHelper.a(r1, r3);
                if (r1 == 0) goto L_0x0020;
            L_0x0014:
                r0 = com.facebook.graphql.modelutil.ModelHelper.a(r0, r2);
                r0 = (com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.BoostedComponentModel.TargetingDescriptionModel) r0;
                r1 = r1.b();
                r0.f22084d = r1;
            L_0x0020:
                r2.i();
                if (r0 != 0) goto L_0x0026;
            L_0x0025:
                return r2;
            L_0x0026:
                r2 = r0;
                goto L_0x0025;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.BoostedComponentModel.TargetingDescriptionModel.a(com.facebook.graphql.visitor.GraphQLModelMutatingVisitor):com.facebook.graphql.visitor.GraphQLVisitableModel");
            }

            public final int m23336a(com.facebook.flatbuffers.FlatBufferBuilder r3) {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r2 = this;
                r2.h();
                r0 = r2.m23338a();
                r0 = com.facebook.graphql.modelutil.ModelHelper.a(r3, r0);
                r1 = 1;
                r3.c(r1);
                r1 = 0;
                r3.b(r1, r0);
                r2.i();
                r0 = r3.d();
                return r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.BoostedComponentModel.TargetingDescriptionModel.a(com.facebook.flatbuffers.FlatBufferBuilder):int");
            }
        }

        public BoostedComponentModel() {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
            /*
            r1 = this;
            r0 = 16;
            r1.<init>(r0);
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.BoostedComponentModel.<init>():void");
        }

        public BoostedComponentModel(com.facebook.flatbuffers.MutableFlatBuffer r3) {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
            /*
            r2 = this;
            r0 = 16;
            r2.<init>(r0);
            r1 = r3.a;
            r0 = r1;
            r0 = com.facebook.flatbuffers.FlatBuffer.a(r0);
            r2.a(r3, r0);
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.BoostedComponentModel.<init>(com.facebook.flatbuffers.MutableFlatBuffer):void");
        }

        @javax.annotation.Nullable
        public final com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.AdAccountBasicFieldsModel m23340a() {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
            /*
            r3 = this;
            r0 = r3.f22085d;
            r1 = 0;
            r2 = com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.AdAccountBasicFieldsModel.class;
            r0 = super.a(r0, r1, r2);
            r0 = (com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.AdAccountBasicFieldsModel) r0;
            r3.f22085d = r0;
            r0 = r3.f22085d;
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.BoostedComponentModel.a():com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels$AdAccountBasicFieldsModel");
        }

        @javax.annotation.Nullable
        public final com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.BoostedComponentAudienceModel m23343j() {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
            /*
            r3 = this;
            r0 = r3.f22086e;
            r1 = 1;
            r2 = com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.BoostedComponentAudienceModel.class;
            r0 = super.a(r0, r1, r2);
            r0 = (com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.BoostedComponentAudienceModel) r0;
            r3.f22086e = r0;
            r0 = r3.f22086e;
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.BoostedComponentModel.j():com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels$BoostedComponentAudienceModel");
        }

        @javax.annotation.Nullable
        public final com.facebook.graphql.enums.GraphQLBoostedComponentStatus m23344k() {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
            /*
            r4 = this;
            r0 = r4.f22087f;
            r1 = 2;
            r2 = com.facebook.graphql.enums.GraphQLBoostedComponentStatus.class;
            r3 = com.facebook.graphql.enums.GraphQLBoostedComponentStatus.UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            r0 = super.b(r0, r1, r2, r3);
            r0 = (com.facebook.graphql.enums.GraphQLBoostedComponentStatus) r0;
            r4.f22087f = r0;
            r0 = r4.f22087f;
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.BoostedComponentModel.k():com.facebook.graphql.enums.GraphQLBoostedComponentStatus");
        }

        @javax.annotation.Nullable
        public final com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.CurrencyQuantityModel m23345l() {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
            /*
            r3 = this;
            r0 = r3.f22088g;
            r1 = 3;
            r2 = com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.CurrencyQuantityModel.class;
            r0 = super.a(r0, r1, r2);
            r0 = (com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.CurrencyQuantityModel) r0;
            r3.f22088g = r0;
            r0 = r3.f22088g;
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.BoostedComponentModel.l():com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels$CurrencyQuantityModel");
        }

        @javax.annotation.Nullable
        public final com.facebook.graphql.enums.GraphQLBoostedComponentBudgetType m23346m() {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
            /*
            r4 = this;
            r0 = r4.f22089h;
            r1 = 4;
            r2 = com.facebook.graphql.enums.GraphQLBoostedComponentBudgetType.class;
            r3 = com.facebook.graphql.enums.GraphQLBoostedComponentBudgetType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            r0 = super.b(r0, r1, r2, r3);
            r0 = (com.facebook.graphql.enums.GraphQLBoostedComponentBudgetType) r0;
            r4.f22089h = r0;
            r0 = r4.f22089h;
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.BoostedComponentModel.m():com.facebook.graphql.enums.GraphQLBoostedComponentBudgetType");
        }

        @javax.annotation.Nullable
        public final com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.CampaignGroupResultsModel m23347n() {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
            /*
            r3 = this;
            r0 = r3.f22090i;
            r1 = 5;
            r2 = com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.CampaignGroupResultsModel.class;
            r0 = super.a(r0, r1, r2);
            r0 = (com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.CampaignGroupResultsModel) r0;
            r3.f22090i = r0;
            r0 = r3.f22090i;
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.BoostedComponentModel.n():com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels$CampaignGroupResultsModel");
        }

        @javax.annotation.Nullable
        public final com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.BoostedComponentCreativeModel m23348o() {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
            /*
            r3 = this;
            r0 = r3.f22091j;
            r1 = 6;
            r2 = com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.BoostedComponentCreativeModel.class;
            r0 = super.a(r0, r1, r2);
            r0 = (com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.BoostedComponentCreativeModel) r0;
            r3.f22091j = r0;
            r0 = r3.f22091j;
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.BoostedComponentModel.o():com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels$BoostedComponentCreativeModel");
        }

        @javax.annotation.Nullable
        public final com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.BoostedComponentModel.DefaultSpecModel m23349p() {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
            /*
            r3 = this;
            r0 = r3.f22092k;
            r1 = 7;
            r2 = com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.BoostedComponentModel.DefaultSpecModel.class;
            r0 = super.a(r0, r1, r2);
            r0 = (com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.BoostedComponentModel.DefaultSpecModel) r0;
            r3.f22092k = r0;
            r0 = r3.f22092k;
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.BoostedComponentModel.p():com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels$BoostedComponentModel$DefaultSpecModel");
        }

        @javax.annotation.Nullable
        public final com.facebook.graphql.model.FeedUnit m23350q() {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
            /*
            r3 = this;
            r0 = r3.f22093l;
            r1 = 8;
            r2 = com.facebook.graphql.model.VirtualFlattenableResolverImpl.a;
            r0 = super.a(r0, r1, r2);
            r0 = (com.facebook.graphql.model.FeedUnit) r0;
            r3.f22093l = r0;
            r0 = r3.f22093l;
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.BoostedComponentModel.q():com.facebook.graphql.model.FeedUnit");
        }

        @javax.annotation.Nullable
        public final com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.BoostedComponentModel.InsightsModel m23351r() {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
            /*
            r3 = this;
            r0 = r3.f22094m;
            r1 = 9;
            r2 = com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.BoostedComponentModel.InsightsModel.class;
            r0 = super.a(r0, r1, r2);
            r0 = (com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.BoostedComponentModel.InsightsModel) r0;
            r3.f22094m = r0;
            r0 = r3.f22094m;
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.BoostedComponentModel.r():com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels$BoostedComponentModel$InsightsModel");
        }

        @javax.annotation.Nullable
        public final com.facebook.graphql.querybuilder.common.TextWithEntitiesGraphQLModels.DefaultTextWithEntitiesLongFieldsModel m23352s() {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
            /*
            r3 = this;
            r0 = r3.f22095n;
            r1 = 10;
            r2 = com.facebook.graphql.querybuilder.common.TextWithEntitiesGraphQLModels.DefaultTextWithEntitiesLongFieldsModel.class;
            r0 = super.a(r0, r1, r2);
            r0 = (com.facebook.graphql.querybuilder.common.TextWithEntitiesGraphQLModels.DefaultTextWithEntitiesLongFieldsModel) r0;
            r3.f22095n = r0;
            r0 = r3.f22095n;
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.BoostedComponentModel.s():com.facebook.graphql.querybuilder.common.TextWithEntitiesGraphQLModels$DefaultTextWithEntitiesLongFieldsModel");
        }

        @javax.annotation.Nullable
        public final com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.CurrencyQuantityModel m23353t() {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
            /*
            r3 = this;
            r0 = r3.f22096o;
            r1 = 11;
            r2 = com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.CurrencyQuantityModel.class;
            r0 = super.a(r0, r1, r2);
            r0 = (com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.CurrencyQuantityModel) r0;
            r3.f22096o = r0;
            r0 = r3.f22096o;
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.BoostedComponentModel.t():com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels$CurrencyQuantityModel");
        }

        public final long m23354u() {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
            /*
            r2 = this;
            r0 = 1;
            r1 = 5;
            r2.a(r0, r1);
            r0 = r2.f22098q;
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.BoostedComponentModel.u():long");
        }

        @javax.annotation.Nullable
        public final com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.TargetSpecificationsModel m23355v() {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
            /*
            r3 = this;
            r0 = r3.f22099r;
            r1 = 14;
            r2 = com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.TargetSpecificationsModel.class;
            r0 = super.a(r0, r1, r2);
            r0 = (com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.TargetSpecificationsModel) r0;
            r3.f22099r = r0;
            r0 = r3.f22099r;
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.BoostedComponentModel.v():com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels$TargetSpecificationsModel");
        }

        @javax.annotation.Nullable
        public final com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.BoostedComponentModel.TargetingDescriptionModel m23356w() {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
            /*
            r3 = this;
            r0 = r3.f22100s;
            r1 = 15;
            r2 = com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.BoostedComponentModel.TargetingDescriptionModel.class;
            r0 = super.a(r0, r1, r2);
            r0 = (com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.BoostedComponentModel.TargetingDescriptionModel) r0;
            r3.f22100s = r0;
            r0 = r3.f22100s;
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.BoostedComponentModel.w():com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels$BoostedComponentModel$TargetingDescriptionModel");
        }

        public final int jK_() {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
            /*
            r1 = this;
            r0 = -47218757; // 0xfffffffffd2f7fbb float:-1.4579882E37 double:NaN;
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.BoostedComponentModel.jK_():int");
        }

        public final com.facebook.graphql.visitor.GraphQLVisitableModel m23341a(com.facebook.graphql.visitor.GraphQLModelMutatingVisitor r4) {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
            /*
            r3 = this;
            r1 = 0;
            r3.h();
            r0 = r3.m23340a();
            if (r0 == 0) goto L_0x0022;
        L_0x000a:
            r0 = r3.m23340a();
            r0 = r4.b(r0);
            r0 = (com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.AdAccountBasicFieldsModel) r0;
            r2 = r3.m23340a();
            if (r2 == r0) goto L_0x0022;
        L_0x001a:
            r1 = com.facebook.graphql.modelutil.ModelHelper.a(r1, r3);
            r1 = (com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.BoostedComponentModel) r1;
            r1.f22085d = r0;
        L_0x0022:
            r0 = r3.m23343j();
            if (r0 == 0) goto L_0x0040;
        L_0x0028:
            r0 = r3.m23343j();
            r0 = r4.b(r0);
            r0 = (com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.BoostedComponentAudienceModel) r0;
            r2 = r3.m23343j();
            if (r2 == r0) goto L_0x0040;
        L_0x0038:
            r1 = com.facebook.graphql.modelutil.ModelHelper.a(r1, r3);
            r1 = (com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.BoostedComponentModel) r1;
            r1.f22086e = r0;
        L_0x0040:
            r0 = r3.m23345l();
            if (r0 == 0) goto L_0x005e;
        L_0x0046:
            r0 = r3.m23345l();
            r0 = r4.b(r0);
            r0 = (com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.CurrencyQuantityModel) r0;
            r2 = r3.m23345l();
            if (r2 == r0) goto L_0x005e;
        L_0x0056:
            r1 = com.facebook.graphql.modelutil.ModelHelper.a(r1, r3);
            r1 = (com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.BoostedComponentModel) r1;
            r1.f22088g = r0;
        L_0x005e:
            r0 = r3.m23347n();
            if (r0 == 0) goto L_0x007c;
        L_0x0064:
            r0 = r3.m23347n();
            r0 = r4.b(r0);
            r0 = (com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.CampaignGroupResultsModel) r0;
            r2 = r3.m23347n();
            if (r2 == r0) goto L_0x007c;
        L_0x0074:
            r1 = com.facebook.graphql.modelutil.ModelHelper.a(r1, r3);
            r1 = (com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.BoostedComponentModel) r1;
            r1.f22090i = r0;
        L_0x007c:
            r0 = r3.m23348o();
            if (r0 == 0) goto L_0x009a;
        L_0x0082:
            r0 = r3.m23348o();
            r0 = r4.b(r0);
            r0 = (com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.BoostedComponentCreativeModel) r0;
            r2 = r3.m23348o();
            if (r2 == r0) goto L_0x009a;
        L_0x0092:
            r1 = com.facebook.graphql.modelutil.ModelHelper.a(r1, r3);
            r1 = (com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.BoostedComponentModel) r1;
            r1.f22091j = r0;
        L_0x009a:
            r0 = r3.m23349p();
            if (r0 == 0) goto L_0x00b8;
        L_0x00a0:
            r0 = r3.m23349p();
            r0 = r4.b(r0);
            r0 = (com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.BoostedComponentModel.DefaultSpecModel) r0;
            r2 = r3.m23349p();
            if (r2 == r0) goto L_0x00b8;
        L_0x00b0:
            r1 = com.facebook.graphql.modelutil.ModelHelper.a(r1, r3);
            r1 = (com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.BoostedComponentModel) r1;
            r1.f22092k = r0;
        L_0x00b8:
            r0 = r3.m23350q();
            if (r0 == 0) goto L_0x00d6;
        L_0x00be:
            r0 = r3.m23350q();
            r0 = r4.b(r0);
            r0 = (com.facebook.graphql.model.FeedUnit) r0;
            r2 = r3.m23350q();
            if (r2 == r0) goto L_0x00d6;
        L_0x00ce:
            r1 = com.facebook.graphql.modelutil.ModelHelper.a(r1, r3);
            r1 = (com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.BoostedComponentModel) r1;
            r1.f22093l = r0;
        L_0x00d6:
            r0 = r3.m23351r();
            if (r0 == 0) goto L_0x00f4;
        L_0x00dc:
            r0 = r3.m23351r();
            r0 = r4.b(r0);
            r0 = (com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.BoostedComponentModel.InsightsModel) r0;
            r2 = r3.m23351r();
            if (r2 == r0) goto L_0x00f4;
        L_0x00ec:
            r1 = com.facebook.graphql.modelutil.ModelHelper.a(r1, r3);
            r1 = (com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.BoostedComponentModel) r1;
            r1.f22094m = r0;
        L_0x00f4:
            r0 = r3.m23352s();
            if (r0 == 0) goto L_0x0112;
        L_0x00fa:
            r0 = r3.m23352s();
            r0 = r4.b(r0);
            r0 = (com.facebook.graphql.querybuilder.common.TextWithEntitiesGraphQLModels.DefaultTextWithEntitiesLongFieldsModel) r0;
            r2 = r3.m23352s();
            if (r2 == r0) goto L_0x0112;
        L_0x010a:
            r1 = com.facebook.graphql.modelutil.ModelHelper.a(r1, r3);
            r1 = (com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.BoostedComponentModel) r1;
            r1.f22095n = r0;
        L_0x0112:
            r0 = r3.m23353t();
            if (r0 == 0) goto L_0x0130;
        L_0x0118:
            r0 = r3.m23353t();
            r0 = r4.b(r0);
            r0 = (com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.CurrencyQuantityModel) r0;
            r2 = r3.m23353t();
            if (r2 == r0) goto L_0x0130;
        L_0x0128:
            r1 = com.facebook.graphql.modelutil.ModelHelper.a(r1, r3);
            r1 = (com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.BoostedComponentModel) r1;
            r1.f22096o = r0;
        L_0x0130:
            r0 = r3.m23355v();
            if (r0 == 0) goto L_0x014e;
        L_0x0136:
            r0 = r3.m23355v();
            r0 = r4.b(r0);
            r0 = (com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.TargetSpecificationsModel) r0;
            r2 = r3.m23355v();
            if (r2 == r0) goto L_0x014e;
        L_0x0146:
            r1 = com.facebook.graphql.modelutil.ModelHelper.a(r1, r3);
            r1 = (com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.BoostedComponentModel) r1;
            r1.f22099r = r0;
        L_0x014e:
            r0 = r3.m23356w();
            if (r0 == 0) goto L_0x016c;
        L_0x0154:
            r0 = r3.m23356w();
            r0 = r4.b(r0);
            r0 = (com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.BoostedComponentModel.TargetingDescriptionModel) r0;
            r2 = r3.m23356w();
            if (r2 == r0) goto L_0x016c;
        L_0x0164:
            r1 = com.facebook.graphql.modelutil.ModelHelper.a(r1, r3);
            r1 = (com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.BoostedComponentModel) r1;
            r1.f22100s = r0;
        L_0x016c:
            r3.i();
            if (r1 != 0) goto L_0x0172;
        L_0x0171:
            return r3;
        L_0x0172:
            r3 = r1;
            goto L_0x0171;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.BoostedComponentModel.a(com.facebook.graphql.visitor.GraphQLModelMutatingVisitor):com.facebook.graphql.visitor.GraphQLVisitableModel");
        }

        public final int m23339a(com.facebook.flatbuffers.FlatBufferBuilder r18) {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
            /*
            r17 = this;
            r17.h();
            r2 = r17.m23340a();
            r0 = r18;
            r3 = com.facebook.graphql.modelutil.ModelHelper.a(r0, r2);
            r2 = r17.m23343j();
            r0 = r18;
            r4 = com.facebook.graphql.modelutil.ModelHelper.a(r0, r2);
            r2 = r17.m23344k();
            r0 = r18;
            r5 = r0.a(r2);
            r2 = r17.m23345l();
            r0 = r18;
            r6 = com.facebook.graphql.modelutil.ModelHelper.a(r0, r2);
            r2 = r17.m23346m();
            r0 = r18;
            r7 = r0.a(r2);
            r2 = r17.m23347n();
            r0 = r18;
            r8 = com.facebook.graphql.modelutil.ModelHelper.a(r0, r2);
            r2 = r17.m23348o();
            r0 = r18;
            r9 = com.facebook.graphql.modelutil.ModelHelper.a(r0, r2);
            r2 = r17.m23349p();
            r0 = r18;
            r10 = com.facebook.graphql.modelutil.ModelHelper.a(r0, r2);
            r2 = r17.m23350q();
            r2 = (com.facebook.flatbuffers.MutableFlattenable) r2;
            r0 = r18;
            r2 = com.facebook.graphql.modelutil.ModelHelper.a(r0, r2);
            r11 = r17.m23351r();
            r0 = r18;
            r11 = com.facebook.graphql.modelutil.ModelHelper.a(r0, r11);
            r12 = r17.m23352s();
            r0 = r18;
            r12 = com.facebook.graphql.modelutil.ModelHelper.a(r0, r12);
            r13 = r17.m23353t();
            r0 = r18;
            r13 = com.facebook.graphql.modelutil.ModelHelper.a(r0, r13);
            r14 = r17.m23355v();
            r0 = r18;
            r14 = com.facebook.graphql.modelutil.ModelHelper.a(r0, r14);
            r15 = r17.m23356w();
            r0 = r18;
            r15 = com.facebook.graphql.modelutil.ModelHelper.a(r0, r15);
            r16 = 16;
            r0 = r18;
            r1 = r16;
            r0.c(r1);
            r16 = 0;
            r0 = r18;
            r1 = r16;
            r0.b(r1, r3);
            r3 = 1;
            r0 = r18;
            r0.b(r3, r4);
            r3 = 2;
            r0 = r18;
            r0.b(r3, r5);
            r3 = 3;
            r0 = r18;
            r0.b(r3, r6);
            r3 = 4;
            r0 = r18;
            r0.b(r3, r7);
            r3 = 5;
            r0 = r18;
            r0.b(r3, r8);
            r3 = 6;
            r0 = r18;
            r0.b(r3, r9);
            r3 = 7;
            r0 = r18;
            r0.b(r3, r10);
            r3 = 8;
            r0 = r18;
            r0.b(r3, r2);
            r2 = 9;
            r0 = r18;
            r0.b(r2, r11);
            r2 = 10;
            r0 = r18;
            r0.b(r2, r12);
            r2 = 11;
            r0 = r18;
            r0.b(r2, r13);
            r3 = 12;
            r0 = r17;
            r4 = r0.f22097p;
            r6 = 0;
            r2 = r18;
            r2.a(r3, r4, r6);
            r3 = 13;
            r0 = r17;
            r4 = r0.f22098q;
            r6 = 0;
            r2 = r18;
            r2.a(r3, r4, r6);
            r2 = 14;
            r0 = r18;
            r0.b(r2, r14);
            r2 = 15;
            r0 = r18;
            r0.b(r2, r15);
            r17.i();
            r2 = r18.d();
            return r2;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.BoostedComponentModel.a(com.facebook.flatbuffers.FlatBufferBuilder):int");
        }

        public final void m23342a(com.facebook.flatbuffers.MutableFlatBuffer r5, int r6, java.lang.Object r7) {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
            /*
            r4 = this;
            r2 = 0;
            super.a(r5, r6, r7);
            r0 = 12;
            r0 = r5.a(r6, r0, r2);
            r4.f22097p = r0;
            r0 = 13;
            r0 = r5.a(r6, r0, r2);
            r4.f22098q = r0;
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.BoostedComponentModel.a(com.facebook.flatbuffers.MutableFlatBuffer, int, java.lang.Object):void");
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 1707691768)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: ZA */
    public final class BoostedComponentValidationMessageModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private GraphQLBoostedComponentMessageType f22101d;
        @Nullable
        private GraphQLBoostedComponentSpecElement f22102e;
        @Nullable
        private DefaultTextWithEntitiesLongFieldsModel f22103f;

        /* compiled from: ZA */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(BoostedComponentValidationMessageModel.class, new Deserializer());
            }

            public Object m23357a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(BoostedComponentValidationMessageParser.m23830b(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object boostedComponentValidationMessageModel = new BoostedComponentValidationMessageModel();
                ((BaseModel) boostedComponentValidationMessageModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (boostedComponentValidationMessageModel instanceof Postprocessable) {
                    return ((Postprocessable) boostedComponentValidationMessageModel).a();
                }
                return boostedComponentValidationMessageModel;
            }
        }

        /* compiled from: ZA */
        public class Serializer extends JsonSerializer<BoostedComponentValidationMessageModel> {
            public final void m23358a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                BoostedComponentValidationMessageModel boostedComponentValidationMessageModel = (BoostedComponentValidationMessageModel) obj;
                if (boostedComponentValidationMessageModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(boostedComponentValidationMessageModel.m23359a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    boostedComponentValidationMessageModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                BoostedComponentValidationMessageParser.m23831b(boostedComponentValidationMessageModel.w_(), boostedComponentValidationMessageModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(BoostedComponentValidationMessageModel.class, new Serializer());
            }
        }

        public BoostedComponentValidationMessageModel() {
            super(3);
        }

        @Nullable
        public final GraphQLBoostedComponentMessageType m23360a() {
            this.f22101d = (GraphQLBoostedComponentMessageType) super.b(this.f22101d, 0, GraphQLBoostedComponentMessageType.class, GraphQLBoostedComponentMessageType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
            return this.f22101d;
        }

        @Nullable
        public final GraphQLBoostedComponentSpecElement m23362j() {
            this.f22102e = (GraphQLBoostedComponentSpecElement) super.b(this.f22102e, 1, GraphQLBoostedComponentSpecElement.class, GraphQLBoostedComponentSpecElement.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
            return this.f22102e;
        }

        @Nullable
        public final DefaultTextWithEntitiesLongFieldsModel m23363k() {
            this.f22103f = (DefaultTextWithEntitiesLongFieldsModel) super.a(this.f22103f, 2, DefaultTextWithEntitiesLongFieldsModel.class);
            return this.f22103f;
        }

        public final int jK_() {
            return -757923892;
        }

        public final GraphQLVisitableModel m23361a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m23363k() != null) {
                DefaultTextWithEntitiesLongFieldsModel defaultTextWithEntitiesLongFieldsModel = (DefaultTextWithEntitiesLongFieldsModel) graphQLModelMutatingVisitor.b(m23363k());
                if (m23363k() != defaultTextWithEntitiesLongFieldsModel) {
                    graphQLVisitableModel = (BoostedComponentValidationMessageModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f22103f = defaultTextWithEntitiesLongFieldsModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m23359a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = flatBufferBuilder.a(m23360a());
            int a2 = flatBufferBuilder.a(m23362j());
            int a3 = ModelHelper.a(flatBufferBuilder, m23363k());
            flatBufferBuilder.c(3);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, a2);
            flatBufferBuilder.b(2, a3);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -1745423636)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: ZA */
    public final class BudgetRecommendationDataModel extends BaseModel implements GraphQLVisitableModel {
        private int f22104d;
        @Nullable
        private CurrencyQuantityModel f22105e;
        private int f22106f;
        @Nullable
        private IntervalModel f22107g;

        /* compiled from: ZA */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(BudgetRecommendationDataModel.class, new Deserializer());
            }

            public Object m23364a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(BudgetRecommendationDataParser.m23832a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object budgetRecommendationDataModel = new BudgetRecommendationDataModel();
                ((BaseModel) budgetRecommendationDataModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (budgetRecommendationDataModel instanceof Postprocessable) {
                    return ((Postprocessable) budgetRecommendationDataModel).a();
                }
                return budgetRecommendationDataModel;
            }
        }

        /* compiled from: ZA */
        public class Serializer extends JsonSerializer<BudgetRecommendationDataModel> {
            public final void m23365a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                BudgetRecommendationDataModel budgetRecommendationDataModel = (BudgetRecommendationDataModel) obj;
                if (budgetRecommendationDataModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(budgetRecommendationDataModel.m23366a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    budgetRecommendationDataModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                BudgetRecommendationDataParser.m23833a(budgetRecommendationDataModel.w_(), budgetRecommendationDataModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(BudgetRecommendationDataModel.class, new Serializer());
            }
        }

        public BudgetRecommendationDataModel() {
            super(4);
        }

        @Nullable
        public final CurrencyQuantityModel m23367a() {
            this.f22105e = (CurrencyQuantityModel) super.a(this.f22105e, 1, CurrencyQuantityModel.class);
            return this.f22105e;
        }

        @Nullable
        public final IntervalModel m23370j() {
            this.f22107g = (IntervalModel) super.a(this.f22107g, 3, IntervalModel.class);
            return this.f22107g;
        }

        public final int jK_() {
            return -311212216;
        }

        public final GraphQLVisitableModel m23368a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m23367a() != null) {
                CurrencyQuantityModel currencyQuantityModel = (CurrencyQuantityModel) graphQLModelMutatingVisitor.b(m23367a());
                if (m23367a() != currencyQuantityModel) {
                    graphQLVisitableModel = (BudgetRecommendationDataModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f22105e = currencyQuantityModel;
                }
            }
            if (m23370j() != null) {
                IntervalModel intervalModel = (IntervalModel) graphQLModelMutatingVisitor.b(m23370j());
                if (m23370j() != intervalModel) {
                    graphQLVisitableModel = (BudgetRecommendationDataModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f22107g = intervalModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m23366a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m23367a());
            int a2 = ModelHelper.a(flatBufferBuilder, m23370j());
            flatBufferBuilder.c(4);
            flatBufferBuilder.a(0, this.f22104d, 0);
            flatBufferBuilder.b(1, a);
            flatBufferBuilder.a(2, this.f22106f, 0);
            flatBufferBuilder.b(3, a2);
            i();
            return flatBufferBuilder.d();
        }

        public final void m23369a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
            super.a(mutableFlatBuffer, i, obj);
            this.f22104d = mutableFlatBuffer.a(i, 0, 0);
            this.f22106f = mutableFlatBuffer.a(i, 2, 0);
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -201046392)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: ZA */
    public final class BudgetRecommendationModel extends BaseModel implements GraphQLVisitableModel {
        private int f22112d;
        @Nullable
        private List<EdgesModel> f22113e;

        /* compiled from: ZA */
        public final class Builder {
            public int f22108a;
            @Nullable
            public ImmutableList<EdgesModel> f22109b;
        }

        /* compiled from: ZA */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(BudgetRecommendationModel.class, new Deserializer());
            }

            public Object m23371a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(BudgetRecommendationParser.m23836a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object budgetRecommendationModel = new BudgetRecommendationModel();
                ((BaseModel) budgetRecommendationModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (budgetRecommendationModel instanceof Postprocessable) {
                    return ((Postprocessable) budgetRecommendationModel).a();
                }
                return budgetRecommendationModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1249815699)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: ZA */
        public final class EdgesModel extends BaseModel implements GraphQLVisitableModel {
            private boolean f22110d;
            @Nullable
            private BudgetRecommendationDataModel f22111e;

            /* compiled from: ZA */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(EdgesModel.class, new Deserializer());
                }

                public Object m23372a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(BudgetRecommendationParser.EdgesParser.m23834b(jsonParser, flatBufferBuilder));
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

            /* compiled from: ZA */
            public class Serializer extends JsonSerializer<EdgesModel> {
                public final void m23373a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    EdgesModel edgesModel = (EdgesModel) obj;
                    if (edgesModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(edgesModel.m23374a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        edgesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    BudgetRecommendationParser.EdgesParser.m23835b(edgesModel.w_(), edgesModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(EdgesModel.class, new Serializer());
                }
            }

            public EdgesModel() {
                super(2);
            }

            public final boolean m23377a() {
                a(0, 0);
                return this.f22110d;
            }

            @Nullable
            public final BudgetRecommendationDataModel m23378j() {
                this.f22111e = (BudgetRecommendationDataModel) super.a(this.f22111e, 1, BudgetRecommendationDataModel.class);
                return this.f22111e;
            }

            public final int jK_() {
                return -1015087854;
            }

            public final GraphQLVisitableModel m23375a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m23378j() != null) {
                    BudgetRecommendationDataModel budgetRecommendationDataModel = (BudgetRecommendationDataModel) graphQLModelMutatingVisitor.b(m23378j());
                    if (m23378j() != budgetRecommendationDataModel) {
                        graphQLVisitableModel = (EdgesModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f22111e = budgetRecommendationDataModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m23374a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m23378j());
                flatBufferBuilder.c(2);
                flatBufferBuilder.a(0, this.f22110d);
                flatBufferBuilder.b(1, a);
                i();
                return flatBufferBuilder.d();
            }

            public final void m23376a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                super.a(mutableFlatBuffer, i, obj);
                this.f22110d = mutableFlatBuffer.a(i, 0);
            }
        }

        /* compiled from: ZA */
        public class Serializer extends JsonSerializer<BudgetRecommendationModel> {
            public final void m23379a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                BudgetRecommendationModel budgetRecommendationModel = (BudgetRecommendationModel) obj;
                if (budgetRecommendationModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(budgetRecommendationModel.m23381a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    budgetRecommendationModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                BudgetRecommendationParser.m23837a(budgetRecommendationModel.w_(), budgetRecommendationModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(BudgetRecommendationModel.class, new Serializer());
            }
        }

        public BudgetRecommendationModel() {
            super(2);
        }

        public BudgetRecommendationModel(MutableFlatBuffer mutableFlatBuffer) {
            super(2);
            a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
        }

        public final int m23380a() {
            a(0, 0);
            return this.f22112d;
        }

        @Nonnull
        public final ImmutableList<EdgesModel> m23384j() {
            this.f22113e = super.a(this.f22113e, 1, EdgesModel.class);
            return (ImmutableList) this.f22113e;
        }

        public final int jK_() {
            return -916555149;
        }

        public final GraphQLVisitableModel m23382a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m23384j() != null) {
                com.google.common.collect.ImmutableList.Builder a = ModelHelper.a(m23384j(), graphQLModelMutatingVisitor);
                if (a != null) {
                    graphQLVisitableModel = (BudgetRecommendationModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f22113e = a.b();
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m23381a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m23384j());
            flatBufferBuilder.c(2);
            flatBufferBuilder.a(0, this.f22112d, 0);
            flatBufferBuilder.b(1, a);
            i();
            return flatBufferBuilder.d();
        }

        public final void m23383a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
            super.a(mutableFlatBuffer, i, obj);
            this.f22112d = mutableFlatBuffer.a(i, 0, 0);
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -1357605800)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: ZA */
    public final class BudgetRecommendationsModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private BudgetRecommendationModel f22114d;

        /* compiled from: ZA */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(BudgetRecommendationsModel.class, new Deserializer());
            }

            public Object m23385a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(BudgetRecommendationsParser.m23838a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object budgetRecommendationsModel = new BudgetRecommendationsModel();
                ((BaseModel) budgetRecommendationsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (budgetRecommendationsModel instanceof Postprocessable) {
                    return ((Postprocessable) budgetRecommendationsModel).a();
                }
                return budgetRecommendationsModel;
            }
        }

        /* compiled from: ZA */
        public class Serializer extends JsonSerializer<BudgetRecommendationsModel> {
            public final void m23386a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                BudgetRecommendationsModel budgetRecommendationsModel = (BudgetRecommendationsModel) obj;
                if (budgetRecommendationsModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(budgetRecommendationsModel.m23387a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    budgetRecommendationsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                BudgetRecommendationsParser.m23839a(budgetRecommendationsModel.w_(), budgetRecommendationsModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(BudgetRecommendationsModel.class, new Serializer());
            }
        }

        public BudgetRecommendationsModel() {
            super(1);
        }

        @Nullable
        public final BudgetRecommendationModel m23388a() {
            this.f22114d = (BudgetRecommendationModel) super.a(this.f22114d, 0, BudgetRecommendationModel.class);
            return this.f22114d;
        }

        public final int jK_() {
            return 888797870;
        }

        public final GraphQLVisitableModel m23389a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m23388a() != null) {
                BudgetRecommendationModel budgetRecommendationModel = (BudgetRecommendationModel) graphQLModelMutatingVisitor.b(m23388a());
                if (m23388a() != budgetRecommendationModel) {
                    graphQLVisitableModel = (BudgetRecommendationsModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f22114d = budgetRecommendationModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m23387a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m23388a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -436632365)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: ZA */
    public final class CampaignGroupResultsModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel {
        @Nullable
        private String f22117d;
        @Nullable
        private List<LifetimeOverallStatsModel> f22118e;
        @Nullable
        private String f22119f;
        @Nullable
        private String f22120g;

        /* compiled from: ZA */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(CampaignGroupResultsModel.class, new Deserializer());
            }

            public Object m23390a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(CampaignGroupResultsParser.m23842a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object campaignGroupResultsModel = new CampaignGroupResultsModel();
                ((BaseModel) campaignGroupResultsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (campaignGroupResultsModel instanceof Postprocessable) {
                    return ((Postprocessable) campaignGroupResultsModel).a();
                }
                return campaignGroupResultsModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 1265307835)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: ZA */
        public final class LifetimeOverallStatsModel extends BaseModel implements GraphQLVisitableModel {
            private int f22115d;
            private int f22116e;

            /* compiled from: ZA */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(LifetimeOverallStatsModel.class, new Deserializer());
                }

                public Object m23391a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(LifetimeOverallStatsParser.m23841b(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object lifetimeOverallStatsModel = new LifetimeOverallStatsModel();
                    ((BaseModel) lifetimeOverallStatsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (lifetimeOverallStatsModel instanceof Postprocessable) {
                        return ((Postprocessable) lifetimeOverallStatsModel).a();
                    }
                    return lifetimeOverallStatsModel;
                }
            }

            /* compiled from: ZA */
            public class Serializer extends JsonSerializer<LifetimeOverallStatsModel> {
                public final void m23392a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    LifetimeOverallStatsModel lifetimeOverallStatsModel = (LifetimeOverallStatsModel) obj;
                    if (lifetimeOverallStatsModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(lifetimeOverallStatsModel.m23394a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        lifetimeOverallStatsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    LifetimeOverallStatsParser.m23840a(lifetimeOverallStatsModel.w_(), lifetimeOverallStatsModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(LifetimeOverallStatsModel.class, new Serializer());
                }
            }

            public LifetimeOverallStatsModel() {
                super(2);
            }

            public final int m23393a() {
                a(0, 0);
                return this.f22115d;
            }

            public final int m23397j() {
                a(0, 1);
                return this.f22116e;
            }

            public final int jK_() {
                return 597870780;
            }

            public final GraphQLVisitableModel m23395a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m23394a(FlatBufferBuilder flatBufferBuilder) {
                h();
                flatBufferBuilder.c(2);
                flatBufferBuilder.a(0, this.f22115d, 0);
                flatBufferBuilder.a(1, this.f22116e, 0);
                i();
                return flatBufferBuilder.d();
            }

            public final void m23396a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                super.a(mutableFlatBuffer, i, obj);
                this.f22115d = mutableFlatBuffer.a(i, 0, 0);
                this.f22116e = mutableFlatBuffer.a(i, 1, 0);
            }
        }

        /* compiled from: ZA */
        public class Serializer extends JsonSerializer<CampaignGroupResultsModel> {
            public final void m23398a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                CampaignGroupResultsModel campaignGroupResultsModel = (CampaignGroupResultsModel) obj;
                if (campaignGroupResultsModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(campaignGroupResultsModel.m23399a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    campaignGroupResultsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                CampaignGroupResultsParser.m23843a(campaignGroupResultsModel.w_(), campaignGroupResultsModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(CampaignGroupResultsModel.class, new Serializer());
            }
        }

        public CampaignGroupResultsModel() {
            super(4);
        }

        @Nullable
        public final String m23402j() {
            this.f22117d = super.a(this.f22117d, 0);
            return this.f22117d;
        }

        @Nonnull
        public final ImmutableList<LifetimeOverallStatsModel> m23403k() {
            this.f22118e = super.a(this.f22118e, 1, LifetimeOverallStatsModel.class);
            return (ImmutableList) this.f22118e;
        }

        @Nullable
        public final String m23404l() {
            this.f22119f = super.a(this.f22119f, 2);
            return this.f22119f;
        }

        @Nullable
        public final String m23405m() {
            this.f22120g = super.a(this.f22120g, 3);
            return this.f22120g;
        }

        @Nullable
        public final String m23401a() {
            return m23402j();
        }

        public final int jK_() {
            return 2033392588;
        }

        public final GraphQLVisitableModel m23400a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m23403k() != null) {
                Builder a = ModelHelper.a(m23403k(), graphQLModelMutatingVisitor);
                if (a != null) {
                    graphQLVisitableModel = (CampaignGroupResultsModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f22118e = a.b();
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m23399a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(m23402j());
            int a = ModelHelper.a(flatBufferBuilder, m23403k());
            int b2 = flatBufferBuilder.b(m23404l());
            int b3 = flatBufferBuilder.b(m23405m());
            flatBufferBuilder.c(4);
            flatBufferBuilder.b(0, b);
            flatBufferBuilder.b(1, a);
            flatBufferBuilder.b(2, b2);
            flatBufferBuilder.b(3, b3);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 1015270419)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: ZA */
    public final class ConversionPixelModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel {
        @Nullable
        private String f22121d;
        @Nullable
        private String f22122e;
        @Nullable
        private String f22123f;

        /* compiled from: ZA */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(ConversionPixelModel.class, new Deserializer());
            }

            public Object m23406a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(ConversionPixelParser.m23844a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object conversionPixelModel = new ConversionPixelModel();
                ((BaseModel) conversionPixelModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (conversionPixelModel instanceof Postprocessable) {
                    return ((Postprocessable) conversionPixelModel).a();
                }
                return conversionPixelModel;
            }
        }

        /* compiled from: ZA */
        public class Serializer extends JsonSerializer<ConversionPixelModel> {
            public final void m23407a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                ConversionPixelModel conversionPixelModel = (ConversionPixelModel) obj;
                if (conversionPixelModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(conversionPixelModel.m23408a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    conversionPixelModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                ConversionPixelParser.m23845a(conversionPixelModel.w_(), conversionPixelModel.u_(), jsonGenerator);
            }

            static {
                FbSerializerProvider.a(ConversionPixelModel.class, new Serializer());
            }
        }

        public ConversionPixelModel() {
            super(3);
        }

        @Nullable
        public final String m23411j() {
            this.f22121d = super.a(this.f22121d, 0);
            return this.f22121d;
        }

        @Nullable
        public final String m23412k() {
            this.f22122e = super.a(this.f22122e, 1);
            return this.f22122e;
        }

        @Nullable
        public final String m23413l() {
            this.f22123f = super.a(this.f22123f, 2);
            return this.f22123f;
        }

        @Nullable
        public final String m23410a() {
            return m23411j();
        }

        public final int jK_() {
            return -2129912755;
        }

        public final GraphQLVisitableModel m23409a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            h();
            i();
            return this;
        }

        public final int m23408a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(m23411j());
            int b2 = flatBufferBuilder.b(m23412k());
            int b3 = flatBufferBuilder.b(m23413l());
            flatBufferBuilder.c(3);
            flatBufferBuilder.b(0, b);
            flatBufferBuilder.b(1, b2);
            flatBufferBuilder.b(2, b3);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -1404649757)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: ZA */
    public final class CurrencyQuantityModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private String f22127d;
        private int f22128e;
        @Nullable
        private String f22129f;

        /* compiled from: ZA */
        public final class Builder {
            @Nullable
            public String f22124a;
            public int f22125b;
            @Nullable
            public String f22126c;

            public final CurrencyQuantityModel m23414a() {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                int b = flatBufferBuilder.b(this.f22124a);
                int b2 = flatBufferBuilder.b(this.f22126c);
                flatBufferBuilder.c(3);
                flatBufferBuilder.b(0, b);
                flatBufferBuilder.a(1, this.f22125b, 0);
                flatBufferBuilder.b(2, b2);
                flatBufferBuilder.d(flatBufferBuilder.d());
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                return new CurrencyQuantityModel(new MutableFlatBuffer(wrap, null, null, true, null));
            }
        }

        /* compiled from: ZA */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(CurrencyQuantityModel.class, new Deserializer());
            }

            public Object m23415a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(CurrencyQuantityParser.m23847a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object currencyQuantityModel = new CurrencyQuantityModel();
                ((BaseModel) currencyQuantityModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (currencyQuantityModel instanceof Postprocessable) {
                    return ((Postprocessable) currencyQuantityModel).a();
                }
                return currencyQuantityModel;
            }
        }

        /* compiled from: ZA */
        public class Serializer extends JsonSerializer<CurrencyQuantityModel> {
            public final void m23416a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                CurrencyQuantityModel currencyQuantityModel = (CurrencyQuantityModel) obj;
                if (currencyQuantityModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(currencyQuantityModel.m23417a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    currencyQuantityModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                CurrencyQuantityParser.m23848a(currencyQuantityModel.w_(), currencyQuantityModel.u_(), jsonGenerator);
            }

            static {
                FbSerializerProvider.a(CurrencyQuantityModel.class, new Serializer());
            }
        }

        public CurrencyQuantityModel() {
            super(3);
        }

        public CurrencyQuantityModel(MutableFlatBuffer mutableFlatBuffer) {
            super(3);
            a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
        }

        @Nullable
        public final String m23419a() {
            this.f22127d = super.a(this.f22127d, 0);
            return this.f22127d;
        }

        public final int m23421j() {
            a(0, 1);
            return this.f22128e;
        }

        @Nullable
        public final String m23422k() {
            this.f22129f = super.a(this.f22129f, 2);
            return this.f22129f;
        }

        public final int jK_() {
            return 753818588;
        }

        public final GraphQLVisitableModel m23418a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            h();
            i();
            return this;
        }

        public final int m23417a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(m23419a());
            int b2 = flatBufferBuilder.b(m23422k());
            flatBufferBuilder.c(3);
            flatBufferBuilder.b(0, b);
            flatBufferBuilder.a(1, this.f22128e, 0);
            flatBufferBuilder.b(2, b2);
            i();
            return flatBufferBuilder.d();
        }

        public final void m23420a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
            super.a(mutableFlatBuffer, i, obj);
            this.f22128e = mutableFlatBuffer.a(i, 1, 0);
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -473115020)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: ZA */
    public final class EventInfoModel extends BaseModel implements GraphQLVisitableConsistentModel {
        @Nullable
        private String f22130d;
        @Nullable
        private String f22131e;

        /* compiled from: ZA */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(EventInfoModel.class, new Deserializer());
            }

            public Object m23423a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(EventInfoParser.m23849a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object eventInfoModel = new EventInfoModel();
                ((BaseModel) eventInfoModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (eventInfoModel instanceof Postprocessable) {
                    return ((Postprocessable) eventInfoModel).a();
                }
                return eventInfoModel;
            }
        }

        /* compiled from: ZA */
        public class Serializer extends JsonSerializer<EventInfoModel> {
            public final void m23424a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                EventInfoModel eventInfoModel = (EventInfoModel) obj;
                if (eventInfoModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(eventInfoModel.m23425a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    eventInfoModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                EventInfoParser.m23850a(eventInfoModel.w_(), eventInfoModel.u_(), jsonGenerator);
            }

            static {
                FbSerializerProvider.a(EventInfoModel.class, new Serializer());
            }
        }

        public EventInfoModel() {
            super(2);
        }

        public final void m23428a(String str, ConsistencyTuple consistencyTuple) {
            consistencyTuple.a();
        }

        public final void m23429a(String str, Object obj, boolean z) {
        }

        @Nullable
        public final String m23427a() {
            this.f22130d = super.a(this.f22130d, 0);
            return this.f22130d;
        }

        @Nullable
        public final String m23430j() {
            this.f22131e = super.a(this.f22131e, 1);
            return this.f22131e;
        }

        public final int jK_() {
            return 67338874;
        }

        public final GraphQLVisitableModel m23426a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            h();
            i();
            return this;
        }

        public final int m23425a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(m23427a());
            int b2 = flatBufferBuilder.b(m23430j());
            flatBufferBuilder.c(2);
            flatBufferBuilder.b(0, b);
            flatBufferBuilder.b(1, b2);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -1700639796)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: ZA */
    public final class GeoLocationModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private String f22145d;
        @Nullable
        private String f22146e;
        @Nullable
        private String f22147f;
        @Nullable
        private String f22148g;
        @Nullable
        private String f22149h;
        private double f22150i;
        @Nullable
        private GraphQLAdGeoLocationType f22151j;
        private double f22152k;
        @Nullable
        private String f22153l;
        private double f22154m;
        @Nullable
        private String f22155n;
        private boolean f22156o;
        private boolean f22157p;

        /* compiled from: ZA */
        public final class Builder {
            @Nullable
            public String f22132a;
            @Nullable
            public String f22133b;
            @Nullable
            public String f22134c;
            @Nullable
            public String f22135d;
            @Nullable
            public String f22136e;
            public double f22137f;
            @Nullable
            public GraphQLAdGeoLocationType f22138g;
            public double f22139h;
            @Nullable
            public String f22140i;
            public double f22141j;
            @Nullable
            public String f22142k;
            public boolean f22143l;
            public boolean f22144m;

            public final GeoLocationModel m23431a() {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                int b = flatBufferBuilder.b(this.f22132a);
                int b2 = flatBufferBuilder.b(this.f22133b);
                int b3 = flatBufferBuilder.b(this.f22134c);
                int b4 = flatBufferBuilder.b(this.f22135d);
                int b5 = flatBufferBuilder.b(this.f22136e);
                int a = flatBufferBuilder.a(this.f22138g);
                int b6 = flatBufferBuilder.b(this.f22140i);
                int b7 = flatBufferBuilder.b(this.f22142k);
                flatBufferBuilder.c(13);
                flatBufferBuilder.b(0, b);
                flatBufferBuilder.b(1, b2);
                flatBufferBuilder.b(2, b3);
                flatBufferBuilder.b(3, b4);
                flatBufferBuilder.b(4, b5);
                flatBufferBuilder.a(5, this.f22137f, 0.0d);
                flatBufferBuilder.b(6, a);
                flatBufferBuilder.a(7, this.f22139h, 0.0d);
                flatBufferBuilder.b(8, b6);
                flatBufferBuilder.a(9, this.f22141j, 0.0d);
                flatBufferBuilder.b(10, b7);
                flatBufferBuilder.a(11, this.f22143l);
                flatBufferBuilder.a(12, this.f22144m);
                flatBufferBuilder.d(flatBufferBuilder.d());
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                return new GeoLocationModel(new MutableFlatBuffer(wrap, null, null, true, null));
            }
        }

        /* compiled from: ZA */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(GeoLocationModel.class, new Deserializer());
            }

            public Object m23432a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(GeoLocationParser.m23854b(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object geoLocationModel = new GeoLocationModel();
                ((BaseModel) geoLocationModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (geoLocationModel instanceof Postprocessable) {
                    return ((Postprocessable) geoLocationModel).a();
                }
                return geoLocationModel;
            }
        }

        /* compiled from: ZA */
        public class Serializer extends JsonSerializer<GeoLocationModel> {
            public final void m23433a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                GeoLocationModel geoLocationModel = (GeoLocationModel) obj;
                if (geoLocationModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(geoLocationModel.m23435a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    geoLocationModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                GeoLocationParser.m23852a(geoLocationModel.w_(), geoLocationModel.u_(), jsonGenerator);
            }

            static {
                FbSerializerProvider.a(GeoLocationModel.class, new Serializer());
            }
        }

        public GeoLocationModel() {
            super(13);
        }

        public GeoLocationModel(MutableFlatBuffer mutableFlatBuffer) {
            super(13);
            a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
        }

        @Nullable
        public final String m23437a() {
            this.f22145d = super.a(this.f22145d, 0);
            return this.f22145d;
        }

        @Nullable
        public final String m23439b() {
            this.f22146e = super.a(this.f22146e, 1);
            return this.f22146e;
        }

        @Nullable
        public final String m23440c() {
            this.f22147f = super.a(this.f22147f, 2);
            return this.f22147f;
        }

        @Nullable
        public final String m23441d() {
            this.f22148g = super.a(this.f22148g, 3);
            return this.f22148g;
        }

        @Nullable
        public final String mL_() {
            this.f22149h = super.a(this.f22149h, 4);
            return this.f22149h;
        }

        public final double m23442g() {
            a(0, 5);
            return this.f22150i;
        }

        @Nullable
        public final GraphQLAdGeoLocationType mM_() {
            this.f22151j = (GraphQLAdGeoLocationType) super.b(this.f22151j, 6, GraphQLAdGeoLocationType.class, GraphQLAdGeoLocationType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
            return this.f22151j;
        }

        public final double mN_() {
            a(0, 7);
            return this.f22152k;
        }

        @Nullable
        public final String m23443j() {
            this.f22153l = super.a(this.f22153l, 8);
            return this.f22153l;
        }

        public final double m23444k() {
            a(1, 1);
            return this.f22154m;
        }

        @Nullable
        public final String m23445l() {
            this.f22155n = super.a(this.f22155n, 10);
            return this.f22155n;
        }

        public final boolean m23446m() {
            a(1, 3);
            return this.f22156o;
        }

        public final boolean m23447n() {
            a(1, 4);
            return this.f22157p;
        }

        public static GeoLocationModel m23434a(GeoLocationModel geoLocationModel) {
            if (geoLocationModel == null) {
                return null;
            }
            if (geoLocationModel instanceof GeoLocationModel) {
                return geoLocationModel;
            }
            Builder builder = new Builder();
            builder.f22132a = geoLocationModel.m23437a();
            builder.f22133b = geoLocationModel.m23439b();
            builder.f22134c = geoLocationModel.m23440c();
            builder.f22135d = geoLocationModel.m23441d();
            builder.f22136e = geoLocationModel.mL_();
            builder.f22137f = geoLocationModel.m23442g();
            builder.f22138g = geoLocationModel.mM_();
            builder.f22139h = geoLocationModel.mN_();
            builder.f22140i = geoLocationModel.m23443j();
            builder.f22141j = geoLocationModel.m23444k();
            builder.f22142k = geoLocationModel.m23445l();
            builder.f22143l = geoLocationModel.m23446m();
            builder.f22144m = geoLocationModel.m23447n();
            return builder.m23431a();
        }

        public final int jK_() {
            return -68773405;
        }

        public final GraphQLVisitableModel m23436a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            h();
            i();
            return this;
        }

        public final int m23435a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(m23437a());
            int b2 = flatBufferBuilder.b(m23439b());
            int b3 = flatBufferBuilder.b(m23440c());
            int b4 = flatBufferBuilder.b(m23441d());
            int b5 = flatBufferBuilder.b(mL_());
            int a = flatBufferBuilder.a(mM_());
            int b6 = flatBufferBuilder.b(m23443j());
            int b7 = flatBufferBuilder.b(m23445l());
            flatBufferBuilder.c(13);
            flatBufferBuilder.b(0, b);
            flatBufferBuilder.b(1, b2);
            flatBufferBuilder.b(2, b3);
            flatBufferBuilder.b(3, b4);
            flatBufferBuilder.b(4, b5);
            flatBufferBuilder.a(5, this.f22150i, 0.0d);
            flatBufferBuilder.b(6, a);
            flatBufferBuilder.a(7, this.f22152k, 0.0d);
            flatBufferBuilder.b(8, b6);
            flatBufferBuilder.a(9, this.f22154m, 0.0d);
            flatBufferBuilder.b(10, b7);
            flatBufferBuilder.a(11, this.f22156o);
            flatBufferBuilder.a(12, this.f22157p);
            i();
            return flatBufferBuilder.d();
        }

        public final void m23438a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
            super.a(mutableFlatBuffer, i, obj);
            this.f22150i = mutableFlatBuffer.a(i, 5, 0.0d);
            this.f22152k = mutableFlatBuffer.a(i, 7, 0.0d);
            this.f22154m = mutableFlatBuffer.a(i, 9, 0.0d);
            this.f22156o = mutableFlatBuffer.a(i, 11);
            this.f22157p = mutableFlatBuffer.a(i, 12);
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 1988486115)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: ZA */
    public final class GeocodeAddressDataModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private String f22158d;
        @Nullable
        private String f22159e;
        @Nullable
        private String f22160f;
        @Nullable
        private String f22161g;
        @Nullable
        private String f22162h;
        @Nullable
        private String f22163i;

        /* compiled from: ZA */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(GeocodeAddressDataModel.class, new Deserializer());
            }

            public Object m23448a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(GeocodeAddressDataParser.m23855a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object geocodeAddressDataModel = new GeocodeAddressDataModel();
                ((BaseModel) geocodeAddressDataModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (geocodeAddressDataModel instanceof Postprocessable) {
                    return ((Postprocessable) geocodeAddressDataModel).a();
                }
                return geocodeAddressDataModel;
            }
        }

        /* compiled from: ZA */
        public class Serializer extends JsonSerializer<GeocodeAddressDataModel> {
            public final void m23449a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                GeocodeAddressDataModel geocodeAddressDataModel = (GeocodeAddressDataModel) obj;
                if (geocodeAddressDataModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(geocodeAddressDataModel.m23454a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    geocodeAddressDataModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                GeocodeAddressDataParser.m23856a(geocodeAddressDataModel.w_(), geocodeAddressDataModel.u_(), jsonGenerator);
            }

            static {
                FbSerializerProvider.a(GeocodeAddressDataModel.class, new Serializer());
            }
        }

        public GeocodeAddressDataModel() {
            super(6);
        }

        @Nullable
        private String m23450k() {
            this.f22158d = super.a(this.f22158d, 0);
            return this.f22158d;
        }

        @Nullable
        private String m23451l() {
            this.f22159e = super.a(this.f22159e, 1);
            return this.f22159e;
        }

        @Nullable
        private String m23452m() {
            this.f22160f = super.a(this.f22160f, 2);
            return this.f22160f;
        }

        @Nullable
        public final String m23456a() {
            this.f22161g = super.a(this.f22161g, 3);
            return this.f22161g;
        }

        @Nullable
        public final String m23457j() {
            this.f22162h = super.a(this.f22162h, 4);
            return this.f22162h;
        }

        @Nullable
        private String m23453n() {
            this.f22163i = super.a(this.f22163i, 5);
            return this.f22163i;
        }

        public final int jK_() {
            return 441276992;
        }

        public final GraphQLVisitableModel m23455a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            h();
            i();
            return this;
        }

        public final int m23454a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(m23450k());
            int b2 = flatBufferBuilder.b(m23451l());
            int b3 = flatBufferBuilder.b(m23452m());
            int b4 = flatBufferBuilder.b(m23456a());
            int b5 = flatBufferBuilder.b(m23457j());
            int b6 = flatBufferBuilder.b(m23453n());
            flatBufferBuilder.c(6);
            flatBufferBuilder.b(0, b);
            flatBufferBuilder.b(1, b2);
            flatBufferBuilder.b(2, b3);
            flatBufferBuilder.b(3, b4);
            flatBufferBuilder.b(4, b5);
            flatBufferBuilder.b(5, b6);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -1185712657)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: ZA */
    public final class InterestModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel {
        @Nullable
        private String f22164d;
        @Nullable
        private String f22165e;

        /* compiled from: ZA */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(InterestModel.class, new Deserializer());
            }

            public Object m23458a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(InterestParser.m23860b(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object interestModel = new InterestModel();
                ((BaseModel) interestModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (interestModel instanceof Postprocessable) {
                    return ((Postprocessable) interestModel).a();
                }
                return interestModel;
            }
        }

        /* compiled from: ZA */
        public class Serializer extends JsonSerializer<InterestModel> {
            public final void m23459a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                InterestModel interestModel = (InterestModel) obj;
                if (interestModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(interestModel.m23460a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    interestModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                InterestParser.m23858a(interestModel.w_(), interestModel.u_(), jsonGenerator);
            }

            static {
                FbSerializerProvider.a(InterestModel.class, new Serializer());
            }
        }

        public InterestModel() {
            super(2);
        }

        @Nullable
        public final String m23463j() {
            this.f22164d = super.a(this.f22164d, 0);
            return this.f22164d;
        }

        @Nullable
        public final String m23464k() {
            this.f22165e = super.a(this.f22165e, 1);
            return this.f22165e;
        }

        @Nullable
        public final String m23462a() {
            return m23463j();
        }

        public final int jK_() {
            return -78021670;
        }

        public final GraphQLVisitableModel m23461a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            h();
            i();
            return this;
        }

        public final int m23460a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(m23463j());
            int b2 = flatBufferBuilder.b(m23464k());
            flatBufferBuilder.c(2);
            flatBufferBuilder.b(0, b);
            flatBufferBuilder.b(1, b2);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 1941253780)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: ZA */
    public final class IntervalModel extends BaseModel implements GraphQLVisitableModel {
        private int f22166d;
        private int f22167e;

        /* compiled from: ZA */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(IntervalModel.class, new Deserializer());
            }

            public Object m23465a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(IntervalParser.m23861a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object intervalModel = new IntervalModel();
                ((BaseModel) intervalModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (intervalModel instanceof Postprocessable) {
                    return ((Postprocessable) intervalModel).a();
                }
                return intervalModel;
            }
        }

        /* compiled from: ZA */
        public class Serializer extends JsonSerializer<IntervalModel> {
            public final void m23466a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                IntervalModel intervalModel = (IntervalModel) obj;
                if (intervalModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(intervalModel.m23468a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    intervalModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                IntervalParser.m23862a(intervalModel.w_(), intervalModel.u_(), jsonGenerator);
            }

            static {
                FbSerializerProvider.a(IntervalModel.class, new Serializer());
            }
        }

        public IntervalModel() {
            super(2);
        }

        public final int m23467a() {
            a(0, 0);
            return this.f22166d;
        }

        public final int m23471j() {
            a(0, 1);
            return this.f22167e;
        }

        public final int jK_() {
            return 635062501;
        }

        public final GraphQLVisitableModel m23469a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            h();
            i();
            return this;
        }

        public final int m23468a(FlatBufferBuilder flatBufferBuilder) {
            h();
            flatBufferBuilder.c(2);
            flatBufferBuilder.a(0, this.f22166d, 0);
            flatBufferBuilder.a(1, this.f22167e, 0);
            i();
            return flatBufferBuilder.d();
        }

        public final void m23470a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
            super.a(mutableFlatBuffer, i, obj);
            this.f22166d = mutableFlatBuffer.a(i, 0, 0);
            this.f22167e = mutableFlatBuffer.a(i, 1, 0);
        }
    }

    @FragmentModelWithBridge
    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 780225368)
    @JsonSerialize(using = Serializer.class)
    /* compiled from: ZA */
    public final class LocalAwarenessAdminInfoModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private BoostedLocalAwarenessPromotionsModel f22169d;
        private boolean f22170e;

        @FragmentModelWithBridge
        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1553092270)
        @JsonSerialize(using = Serializer.class)
        /* compiled from: ZA */
        public final class BoostedLocalAwarenessPromotionsModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private List<BoostedComponentModel> f22168d;

            /* compiled from: ZA */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(BoostedLocalAwarenessPromotionsModel.class, new Deserializer());
                }

                public Object m23472a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(BoostedLocalAwarenessPromotionsParser.m23863a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object boostedLocalAwarenessPromotionsModel = new BoostedLocalAwarenessPromotionsModel();
                    ((BaseModel) boostedLocalAwarenessPromotionsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (boostedLocalAwarenessPromotionsModel instanceof Postprocessable) {
                        return ((Postprocessable) boostedLocalAwarenessPromotionsModel).a();
                    }
                    return boostedLocalAwarenessPromotionsModel;
                }
            }

            /* compiled from: ZA */
            public class Serializer extends JsonSerializer<BoostedLocalAwarenessPromotionsModel> {
                public final void m23473a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    BoostedLocalAwarenessPromotionsModel boostedLocalAwarenessPromotionsModel = (BoostedLocalAwarenessPromotionsModel) obj;
                    if (boostedLocalAwarenessPromotionsModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(boostedLocalAwarenessPromotionsModel.m23474a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        boostedLocalAwarenessPromotionsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    BoostedLocalAwarenessPromotionsParser.m23864a(boostedLocalAwarenessPromotionsModel.w_(), boostedLocalAwarenessPromotionsModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(BoostedLocalAwarenessPromotionsModel.class, new Serializer());
                }
            }

            public BoostedLocalAwarenessPromotionsModel() {
                super(1);
            }

            @Nonnull
            public final ImmutableList<BoostedComponentModel> m23476a() {
                this.f22168d = super.a(this.f22168d, 0, BoostedComponentModel.class);
                return (ImmutableList) this.f22168d;
            }

            public final int jK_() {
                return -187331336;
            }

            public final GraphQLVisitableModel m23475a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m23476a() != null) {
                    Builder a = ModelHelper.a(m23476a(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        graphQLVisitableModel = (BoostedLocalAwarenessPromotionsModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f22168d = a.b();
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m23474a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m23476a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, a);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: ZA */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(LocalAwarenessAdminInfoModel.class, new Deserializer());
            }

            public Object m23477a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = LocalAwarenessAdminInfoParser.m23865a(jsonParser);
                Object localAwarenessAdminInfoModel = new LocalAwarenessAdminInfoModel();
                ((BaseModel) localAwarenessAdminInfoModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (localAwarenessAdminInfoModel instanceof Postprocessable) {
                    return ((Postprocessable) localAwarenessAdminInfoModel).a();
                }
                return localAwarenessAdminInfoModel;
            }
        }

        /* compiled from: ZA */
        public class Serializer extends JsonSerializer<LocalAwarenessAdminInfoModel> {
            public final void m23478a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                LocalAwarenessAdminInfoModel localAwarenessAdminInfoModel = (LocalAwarenessAdminInfoModel) obj;
                if (localAwarenessAdminInfoModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(localAwarenessAdminInfoModel.m23480a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    localAwarenessAdminInfoModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = localAwarenessAdminInfoModel.w_();
                int u_ = localAwarenessAdminInfoModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("boosted_local_awareness_promotions");
                    BoostedLocalAwarenessPromotionsParser.m23864a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                boolean a = mutableFlatBuffer.a(u_, 1);
                if (a) {
                    jsonGenerator.a("messaging_enabled");
                    jsonGenerator.a(a);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(LocalAwarenessAdminInfoModel.class, new Serializer());
            }
        }

        public LocalAwarenessAdminInfoModel() {
            super(2);
        }

        @Nullable
        private BoostedLocalAwarenessPromotionsModel m23479a() {
            this.f22169d = (BoostedLocalAwarenessPromotionsModel) super.a(this.f22169d, 0, BoostedLocalAwarenessPromotionsModel.class);
            return this.f22169d;
        }

        public final int jK_() {
            return 888797870;
        }

        public final GraphQLVisitableModel m23481a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m23479a() != null) {
                BoostedLocalAwarenessPromotionsModel boostedLocalAwarenessPromotionsModel = (BoostedLocalAwarenessPromotionsModel) graphQLModelMutatingVisitor.b(m23479a());
                if (m23479a() != boostedLocalAwarenessPromotionsModel) {
                    graphQLVisitableModel = (LocalAwarenessAdminInfoModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f22169d = boostedLocalAwarenessPromotionsModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m23480a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m23479a());
            flatBufferBuilder.c(2);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.a(1, this.f22170e);
            i();
            return flatBufferBuilder.d();
        }

        public final void m23482a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
            super.a(mutableFlatBuffer, i, obj);
            this.f22170e = mutableFlatBuffer.a(i, 1);
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -249762016)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: ZA */
    public final class PCTAAvailableAudiencesConnectionModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private List<AvailableAudienceFragmentModel> f22171d;

        /* compiled from: ZA */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(PCTAAvailableAudiencesConnectionModel.class, new Deserializer());
            }

            public Object m23483a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(PCTAAvailableAudiencesConnectionParser.m23866a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object pCTAAvailableAudiencesConnectionModel = new PCTAAvailableAudiencesConnectionModel();
                ((BaseModel) pCTAAvailableAudiencesConnectionModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (pCTAAvailableAudiencesConnectionModel instanceof Postprocessable) {
                    return ((Postprocessable) pCTAAvailableAudiencesConnectionModel).a();
                }
                return pCTAAvailableAudiencesConnectionModel;
            }
        }

        /* compiled from: ZA */
        public class Serializer extends JsonSerializer<PCTAAvailableAudiencesConnectionModel> {
            public final void m23484a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                PCTAAvailableAudiencesConnectionModel pCTAAvailableAudiencesConnectionModel = (PCTAAvailableAudiencesConnectionModel) obj;
                if (pCTAAvailableAudiencesConnectionModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(pCTAAvailableAudiencesConnectionModel.m23485a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    pCTAAvailableAudiencesConnectionModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                PCTAAvailableAudiencesConnectionParser.m23867a(pCTAAvailableAudiencesConnectionModel.w_(), pCTAAvailableAudiencesConnectionModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(PCTAAvailableAudiencesConnectionModel.class, new Serializer());
            }
        }

        public PCTAAvailableAudiencesConnectionModel() {
            super(1);
        }

        @Nonnull
        public final ImmutableList<AvailableAudienceFragmentModel> m23487a() {
            this.f22171d = super.a(this.f22171d, 0, AvailableAudienceFragmentModel.class);
            return (ImmutableList) this.f22171d;
        }

        public final int jK_() {
            return 1540643134;
        }

        public final GraphQLVisitableModel m23486a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m23487a() != null) {
                Builder a = ModelHelper.a(m23487a(), graphQLModelMutatingVisitor);
                if (a != null) {
                    graphQLVisitableModel = (PCTAAvailableAudiencesConnectionModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f22171d = a.b();
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m23485a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m23487a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -249762016)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: ZA */
    public final class PPAvailableAudiencesConnectionModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private List<AvailableAudienceFragmentModel> f22172d;

        /* compiled from: ZA */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(PPAvailableAudiencesConnectionModel.class, new Deserializer());
            }

            public Object m23488a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(PPAvailableAudiencesConnectionParser.m23868a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object pPAvailableAudiencesConnectionModel = new PPAvailableAudiencesConnectionModel();
                ((BaseModel) pPAvailableAudiencesConnectionModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (pPAvailableAudiencesConnectionModel instanceof Postprocessable) {
                    return ((Postprocessable) pPAvailableAudiencesConnectionModel).a();
                }
                return pPAvailableAudiencesConnectionModel;
            }
        }

        /* compiled from: ZA */
        public class Serializer extends JsonSerializer<PPAvailableAudiencesConnectionModel> {
            public final void m23489a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                PPAvailableAudiencesConnectionModel pPAvailableAudiencesConnectionModel = (PPAvailableAudiencesConnectionModel) obj;
                if (pPAvailableAudiencesConnectionModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(pPAvailableAudiencesConnectionModel.m23490a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    pPAvailableAudiencesConnectionModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                PPAvailableAudiencesConnectionParser.m23869a(pPAvailableAudiencesConnectionModel.w_(), pPAvailableAudiencesConnectionModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(PPAvailableAudiencesConnectionModel.class, new Serializer());
            }
        }

        public PPAvailableAudiencesConnectionModel() {
            super(1);
        }

        @Nonnull
        public final ImmutableList<AvailableAudienceFragmentModel> m23492a() {
            this.f22172d = super.a(this.f22172d, 0, AvailableAudienceFragmentModel.class);
            return (ImmutableList) this.f22172d;
        }

        public final int jK_() {
            return -373930188;
        }

        public final GraphQLVisitableModel m23491a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m23492a() != null) {
                Builder a = ModelHelper.a(m23492a(), graphQLModelMutatingVisitor);
                if (a != null) {
                    graphQLVisitableModel = (PPAvailableAudiencesConnectionModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f22172d = a.b();
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m23490a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m23492a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -249762016)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: ZA */
    public final class PWAvailableAudiencesConnectionModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private List<AvailableAudienceFragmentModel> f22173d;

        /* compiled from: ZA */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(PWAvailableAudiencesConnectionModel.class, new Deserializer());
            }

            public Object m23493a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(PWAvailableAudiencesConnectionParser.m23870a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object pWAvailableAudiencesConnectionModel = new PWAvailableAudiencesConnectionModel();
                ((BaseModel) pWAvailableAudiencesConnectionModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (pWAvailableAudiencesConnectionModel instanceof Postprocessable) {
                    return ((Postprocessable) pWAvailableAudiencesConnectionModel).a();
                }
                return pWAvailableAudiencesConnectionModel;
            }
        }

        /* compiled from: ZA */
        public class Serializer extends JsonSerializer<PWAvailableAudiencesConnectionModel> {
            public final void m23494a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                PWAvailableAudiencesConnectionModel pWAvailableAudiencesConnectionModel = (PWAvailableAudiencesConnectionModel) obj;
                if (pWAvailableAudiencesConnectionModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(pWAvailableAudiencesConnectionModel.m23495a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    pWAvailableAudiencesConnectionModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                PWAvailableAudiencesConnectionParser.m23871a(pWAvailableAudiencesConnectionModel.w_(), pWAvailableAudiencesConnectionModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(PWAvailableAudiencesConnectionModel.class, new Serializer());
            }
        }

        public PWAvailableAudiencesConnectionModel() {
            super(1);
        }

        @Nonnull
        public final ImmutableList<AvailableAudienceFragmentModel> m23497a() {
            this.f22173d = super.a(this.f22173d, 0, AvailableAudienceFragmentModel.class);
            return (ImmutableList) this.f22173d;
        }

        public final int jK_() {
            return -102361015;
        }

        public final GraphQLVisitableModel m23496a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m23497a() != null) {
                Builder a = ModelHelper.a(m23497a(), graphQLModelMutatingVisitor);
                if (a != null) {
                    graphQLVisitableModel = (PWAvailableAudiencesConnectionModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f22173d = a.b();
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m23495a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m23497a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 1646772830)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: ZA */
    public final class PageBaseFieldsModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
        @Nullable
        private AboutModel f22175d;
        @Nullable
        private AdCoverPhotoModel f22176e;
        @Nullable
        private String f22177f;
        @Nullable
        private String f22178g;
        @Nullable
        private DefaultImageFieldsModel f22179h;
        @Nullable
        private DefaultImageFieldsModel f22180i;
        @Nullable
        private String f22181j;
        @Nullable
        private List<String> f22182k;

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1352864475)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: ZA */
        public final class AboutModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private String f22174d;

            /* compiled from: ZA */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(AboutModel.class, new Deserializer());
                }

                public Object m23498a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(AboutParser.m23872a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object aboutModel = new AboutModel();
                    ((BaseModel) aboutModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (aboutModel instanceof Postprocessable) {
                        return ((Postprocessable) aboutModel).a();
                    }
                    return aboutModel;
                }
            }

            /* compiled from: ZA */
            public class Serializer extends JsonSerializer<AboutModel> {
                public final void m23499a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    AboutModel aboutModel = (AboutModel) obj;
                    if (aboutModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(aboutModel.m23500a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        aboutModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    AboutParser.m23873a(aboutModel.w_(), aboutModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(AboutModel.class, new Serializer());
                }
            }

            public AboutModel() {
                super(1);
            }

            @Nullable
            public final String m23502a() {
                this.f22174d = super.a(this.f22174d, 0);
                return this.f22174d;
            }

            public final int jK_() {
                return -1919764332;
            }

            public final GraphQLVisitableModel m23501a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m23500a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m23502a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, b);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: ZA */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(PageBaseFieldsModel.class, new Deserializer());
            }

            public Object m23503a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = PageBaseFieldsParser.m23874a(jsonParser);
                Object pageBaseFieldsModel = new PageBaseFieldsModel();
                ((BaseModel) pageBaseFieldsModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (pageBaseFieldsModel instanceof Postprocessable) {
                    return ((Postprocessable) pageBaseFieldsModel).a();
                }
                return pageBaseFieldsModel;
            }
        }

        /* compiled from: ZA */
        public class Serializer extends JsonSerializer<PageBaseFieldsModel> {
            public final void m23504a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                PageBaseFieldsModel pageBaseFieldsModel = (PageBaseFieldsModel) obj;
                if (pageBaseFieldsModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(pageBaseFieldsModel.m23513a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    pageBaseFieldsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                PageBaseFieldsParser.m23875a(pageBaseFieldsModel.w_(), pageBaseFieldsModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(PageBaseFieldsModel.class, new Serializer());
            }
        }

        public PageBaseFieldsModel() {
            super(8);
        }

        public final void m23516a(String str, ConsistencyTuple consistencyTuple) {
            consistencyTuple.a();
        }

        public final void m23517a(String str, Object obj, boolean z) {
        }

        @Nullable
        private AboutModel m23505j() {
            this.f22175d = (AboutModel) super.a(this.f22175d, 0, AboutModel.class);
            return this.f22175d;
        }

        @Nullable
        private AdCoverPhotoModel m23506k() {
            this.f22176e = (AdCoverPhotoModel) super.a(this.f22176e, 1, AdCoverPhotoModel.class);
            return this.f22176e;
        }

        @Nullable
        private String m23507l() {
            this.f22177f = super.a(this.f22177f, 2);
            return this.f22177f;
        }

        @Nullable
        private String m23508m() {
            this.f22178g = super.a(this.f22178g, 3);
            return this.f22178g;
        }

        @Nullable
        private DefaultImageFieldsModel m23509n() {
            this.f22179h = (DefaultImageFieldsModel) super.a(this.f22179h, 4, DefaultImageFieldsModel.class);
            return this.f22179h;
        }

        @Nullable
        private DefaultImageFieldsModel m23510o() {
            this.f22180i = (DefaultImageFieldsModel) super.a(this.f22180i, 5, DefaultImageFieldsModel.class);
            return this.f22180i;
        }

        @Nullable
        private String m23511p() {
            this.f22181j = super.a(this.f22181j, 6);
            return this.f22181j;
        }

        @Nonnull
        private ImmutableList<String> m23512q() {
            this.f22182k = super.a(this.f22182k, 7);
            return (ImmutableList) this.f22182k;
        }

        @Nullable
        public final String m23515a() {
            return m23507l();
        }

        public final int jK_() {
            return 2479791;
        }

        public final GraphQLVisitableModel m23514a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            DefaultImageFieldsModel defaultImageFieldsModel;
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m23505j() != null) {
                AboutModel aboutModel = (AboutModel) graphQLModelMutatingVisitor.b(m23505j());
                if (m23505j() != aboutModel) {
                    graphQLVisitableModel = (PageBaseFieldsModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f22175d = aboutModel;
                }
            }
            if (m23506k() != null) {
                AdCoverPhotoModel adCoverPhotoModel = (AdCoverPhotoModel) graphQLModelMutatingVisitor.b(m23506k());
                if (m23506k() != adCoverPhotoModel) {
                    graphQLVisitableModel = (PageBaseFieldsModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f22176e = adCoverPhotoModel;
                }
            }
            if (m23509n() != null) {
                defaultImageFieldsModel = (DefaultImageFieldsModel) graphQLModelMutatingVisitor.b(m23509n());
                if (m23509n() != defaultImageFieldsModel) {
                    graphQLVisitableModel = (PageBaseFieldsModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f22179h = defaultImageFieldsModel;
                }
            }
            if (m23510o() != null) {
                defaultImageFieldsModel = (DefaultImageFieldsModel) graphQLModelMutatingVisitor.b(m23510o());
                if (m23510o() != defaultImageFieldsModel) {
                    graphQLVisitableModel = (PageBaseFieldsModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f22180i = defaultImageFieldsModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m23513a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m23505j());
            int a2 = ModelHelper.a(flatBufferBuilder, m23506k());
            int b = flatBufferBuilder.b(m23507l());
            int b2 = flatBufferBuilder.b(m23508m());
            int a3 = ModelHelper.a(flatBufferBuilder, m23509n());
            int a4 = ModelHelper.a(flatBufferBuilder, m23510o());
            int b3 = flatBufferBuilder.b(m23511p());
            int c = flatBufferBuilder.c(m23512q());
            flatBufferBuilder.c(8);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, a2);
            flatBufferBuilder.b(2, b);
            flatBufferBuilder.b(3, b2);
            flatBufferBuilder.b(4, a3);
            flatBufferBuilder.b(5, a4);
            flatBufferBuilder.b(6, b3);
            flatBufferBuilder.b(7, c);
            i();
            return flatBufferBuilder.d();
        }
    }

    @FragmentModelWithBridge
    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 1412630170)
    @JsonSerialize(using = Serializer.class)
    /* compiled from: ZA */
    public final class PageLikeAdminInfoModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private BoostedPageLikePromotionsModel f22184d;
        private boolean f22185e;

        @FragmentModelWithBridge
        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1553092270)
        @JsonSerialize(using = Serializer.class)
        /* compiled from: ZA */
        public final class BoostedPageLikePromotionsModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private List<BoostedComponentModel> f22183d;

            /* compiled from: ZA */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(BoostedPageLikePromotionsModel.class, new Deserializer());
                }

                public Object m23518a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(BoostedPageLikePromotionsParser.m23876a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object boostedPageLikePromotionsModel = new BoostedPageLikePromotionsModel();
                    ((BaseModel) boostedPageLikePromotionsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (boostedPageLikePromotionsModel instanceof Postprocessable) {
                        return ((Postprocessable) boostedPageLikePromotionsModel).a();
                    }
                    return boostedPageLikePromotionsModel;
                }
            }

            /* compiled from: ZA */
            public class Serializer extends JsonSerializer<BoostedPageLikePromotionsModel> {
                public final void m23519a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    BoostedPageLikePromotionsModel boostedPageLikePromotionsModel = (BoostedPageLikePromotionsModel) obj;
                    if (boostedPageLikePromotionsModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(boostedPageLikePromotionsModel.m23520a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        boostedPageLikePromotionsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    BoostedPageLikePromotionsParser.m23877a(boostedPageLikePromotionsModel.w_(), boostedPageLikePromotionsModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(BoostedPageLikePromotionsModel.class, new Serializer());
                }
            }

            public BoostedPageLikePromotionsModel() {
                super(1);
            }

            @Nonnull
            public final ImmutableList<BoostedComponentModel> m23522a() {
                this.f22183d = super.a(this.f22183d, 0, BoostedComponentModel.class);
                return (ImmutableList) this.f22183d;
            }

            public final int jK_() {
                return -373930188;
            }

            public final GraphQLVisitableModel m23521a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m23522a() != null) {
                    Builder a = ModelHelper.a(m23522a(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        graphQLVisitableModel = (BoostedPageLikePromotionsModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f22183d = a.b();
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m23520a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m23522a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, a);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: ZA */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(PageLikeAdminInfoModel.class, new Deserializer());
            }

            public Object m23523a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = PageLikeAdminInfoParser.m23878a(jsonParser);
                Object pageLikeAdminInfoModel = new PageLikeAdminInfoModel();
                ((BaseModel) pageLikeAdminInfoModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (pageLikeAdminInfoModel instanceof Postprocessable) {
                    return ((Postprocessable) pageLikeAdminInfoModel).a();
                }
                return pageLikeAdminInfoModel;
            }
        }

        /* compiled from: ZA */
        public class Serializer extends JsonSerializer<PageLikeAdminInfoModel> {
            public final void m23524a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                PageLikeAdminInfoModel pageLikeAdminInfoModel = (PageLikeAdminInfoModel) obj;
                if (pageLikeAdminInfoModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(pageLikeAdminInfoModel.m23526a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    pageLikeAdminInfoModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = pageLikeAdminInfoModel.w_();
                int u_ = pageLikeAdminInfoModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("boosted_page_like_promotions");
                    BoostedPageLikePromotionsParser.m23877a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                boolean a = mutableFlatBuffer.a(u_, 1);
                if (a) {
                    jsonGenerator.a("can_viewer_promote_for_page_likes");
                    jsonGenerator.a(a);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(PageLikeAdminInfoModel.class, new Serializer());
            }
        }

        public PageLikeAdminInfoModel() {
            super(2);
        }

        @Nullable
        private BoostedPageLikePromotionsModel m23525a() {
            this.f22184d = (BoostedPageLikePromotionsModel) super.a(this.f22184d, 0, BoostedPageLikePromotionsModel.class);
            return this.f22184d;
        }

        public final int jK_() {
            return 888797870;
        }

        public final GraphQLVisitableModel m23527a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m23525a() != null) {
                BoostedPageLikePromotionsModel boostedPageLikePromotionsModel = (BoostedPageLikePromotionsModel) graphQLModelMutatingVisitor.b(m23525a());
                if (m23525a() != boostedPageLikePromotionsModel) {
                    graphQLVisitableModel = (PageLikeAdminInfoModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f22184d = boostedPageLikePromotionsModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m23526a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m23525a());
            flatBufferBuilder.c(2);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.a(1, this.f22185e);
            i();
            return flatBufferBuilder.d();
        }

        public final void m23528a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
            super.a(mutableFlatBuffer, i, obj);
            this.f22185e = mutableFlatBuffer.a(i, 1);
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 44074500)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: ZA */
    public final class PhoneNumberModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private String f22186d;
        @Nullable
        private String f22187e;

        /* compiled from: ZA */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(PhoneNumberModel.class, new Deserializer());
            }

            public Object m23529a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(PhoneNumberParser.m23879a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object phoneNumberModel = new PhoneNumberModel();
                ((BaseModel) phoneNumberModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (phoneNumberModel instanceof Postprocessable) {
                    return ((Postprocessable) phoneNumberModel).a();
                }
                return phoneNumberModel;
            }
        }

        /* compiled from: ZA */
        public class Serializer extends JsonSerializer<PhoneNumberModel> {
            public final void m23530a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                PhoneNumberModel phoneNumberModel = (PhoneNumberModel) obj;
                if (phoneNumberModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(phoneNumberModel.m23532a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    phoneNumberModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                PhoneNumberParser.m23880a(phoneNumberModel.w_(), phoneNumberModel.u_(), jsonGenerator);
            }

            static {
                FbSerializerProvider.a(PhoneNumberModel.class, new Serializer());
            }
        }

        public PhoneNumberModel() {
            super(2);
        }

        @Nullable
        private String m23531j() {
            this.f22186d = super.a(this.f22186d, 0);
            return this.f22186d;
        }

        @Nullable
        public final String m23534a() {
            this.f22187e = super.a(this.f22187e, 1);
            return this.f22187e;
        }

        public final int jK_() {
            return 474898999;
        }

        public final GraphQLVisitableModel m23533a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            h();
            i();
            return this;
        }

        public final int m23532a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(m23531j());
            int b2 = flatBufferBuilder.b(m23534a());
            flatBufferBuilder.c(2);
            flatBufferBuilder.b(0, b);
            flatBufferBuilder.b(1, b2);
            i();
            return flatBufferBuilder.d();
        }
    }

    @FragmentModelWithBridge
    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -1741569981)
    @JsonSerialize(using = Serializer.class)
    /* compiled from: ZA */
    public final class PromoteCTAAdminInfoModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private BoostedCtaPromotionsModel f22189d;

        @FragmentModelWithBridge
        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1553092270)
        @JsonSerialize(using = Serializer.class)
        /* compiled from: ZA */
        public final class BoostedCtaPromotionsModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private List<BoostedComponentModel> f22188d;

            /* compiled from: ZA */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(BoostedCtaPromotionsModel.class, new Deserializer());
                }

                public Object m23535a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(BoostedCtaPromotionsParser.m23881a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object boostedCtaPromotionsModel = new BoostedCtaPromotionsModel();
                    ((BaseModel) boostedCtaPromotionsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (boostedCtaPromotionsModel instanceof Postprocessable) {
                        return ((Postprocessable) boostedCtaPromotionsModel).a();
                    }
                    return boostedCtaPromotionsModel;
                }
            }

            /* compiled from: ZA */
            public class Serializer extends JsonSerializer<BoostedCtaPromotionsModel> {
                public final void m23536a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    BoostedCtaPromotionsModel boostedCtaPromotionsModel = (BoostedCtaPromotionsModel) obj;
                    if (boostedCtaPromotionsModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(boostedCtaPromotionsModel.m23537a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        boostedCtaPromotionsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    BoostedCtaPromotionsParser.m23882a(boostedCtaPromotionsModel.w_(), boostedCtaPromotionsModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(BoostedCtaPromotionsModel.class, new Serializer());
                }
            }

            public BoostedCtaPromotionsModel() {
                super(1);
            }

            @Nonnull
            public final ImmutableList<BoostedComponentModel> m23539a() {
                this.f22188d = super.a(this.f22188d, 0, BoostedComponentModel.class);
                return (ImmutableList) this.f22188d;
            }

            public final int jK_() {
                return 1540643134;
            }

            public final GraphQLVisitableModel m23538a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m23539a() != null) {
                    Builder a = ModelHelper.a(m23539a(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        graphQLVisitableModel = (BoostedCtaPromotionsModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f22188d = a.b();
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m23537a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m23539a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, a);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: ZA */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(PromoteCTAAdminInfoModel.class, new Deserializer());
            }

            public Object m23540a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = PromoteCTAAdminInfoParser.m23883a(jsonParser);
                Object promoteCTAAdminInfoModel = new PromoteCTAAdminInfoModel();
                ((BaseModel) promoteCTAAdminInfoModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (promoteCTAAdminInfoModel instanceof Postprocessable) {
                    return ((Postprocessable) promoteCTAAdminInfoModel).a();
                }
                return promoteCTAAdminInfoModel;
            }
        }

        /* compiled from: ZA */
        public class Serializer extends JsonSerializer<PromoteCTAAdminInfoModel> {
            public final void m23541a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                PromoteCTAAdminInfoModel promoteCTAAdminInfoModel = (PromoteCTAAdminInfoModel) obj;
                if (promoteCTAAdminInfoModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(promoteCTAAdminInfoModel.m23543a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    promoteCTAAdminInfoModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = promoteCTAAdminInfoModel.w_();
                int u_ = promoteCTAAdminInfoModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("boosted_cta_promotions");
                    BoostedCtaPromotionsParser.m23882a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(PromoteCTAAdminInfoModel.class, new Serializer());
            }
        }

        public PromoteCTAAdminInfoModel() {
            super(1);
        }

        @Nullable
        private BoostedCtaPromotionsModel m23542a() {
            this.f22189d = (BoostedCtaPromotionsModel) super.a(this.f22189d, 0, BoostedCtaPromotionsModel.class);
            return this.f22189d;
        }

        public final int jK_() {
            return 888797870;
        }

        public final GraphQLVisitableModel m23544a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m23542a() != null) {
                BoostedCtaPromotionsModel boostedCtaPromotionsModel = (BoostedCtaPromotionsModel) graphQLModelMutatingVisitor.b(m23542a());
                if (m23542a() != boostedCtaPromotionsModel) {
                    graphQLVisitableModel = (PromoteCTAAdminInfoModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f22189d = boostedCtaPromotionsModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m23543a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m23542a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }

    @FragmentModelWithBridge
    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 321829836)
    @JsonSerialize(using = Serializer.class)
    /* compiled from: ZA */
    public final class PromoteProductAdminInfoModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private ProductPromotionsModel f22191d;

        /* compiled from: ZA */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(PromoteProductAdminInfoModel.class, new Deserializer());
            }

            public Object m23545a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = PromoteProductAdminInfoParser.m23886a(jsonParser);
                Object promoteProductAdminInfoModel = new PromoteProductAdminInfoModel();
                ((BaseModel) promoteProductAdminInfoModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (promoteProductAdminInfoModel instanceof Postprocessable) {
                    return ((Postprocessable) promoteProductAdminInfoModel).a();
                }
                return promoteProductAdminInfoModel;
            }
        }

        @FragmentModelWithBridge
        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1553092270)
        @JsonSerialize(using = Serializer.class)
        /* compiled from: ZA */
        public final class ProductPromotionsModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private List<BoostedComponentModel> f22190d;

            /* compiled from: ZA */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(ProductPromotionsModel.class, new Deserializer());
                }

                public Object m23546a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(ProductPromotionsParser.m23884a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object productPromotionsModel = new ProductPromotionsModel();
                    ((BaseModel) productPromotionsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (productPromotionsModel instanceof Postprocessable) {
                        return ((Postprocessable) productPromotionsModel).a();
                    }
                    return productPromotionsModel;
                }
            }

            /* compiled from: ZA */
            public class Serializer extends JsonSerializer<ProductPromotionsModel> {
                public final void m23547a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    ProductPromotionsModel productPromotionsModel = (ProductPromotionsModel) obj;
                    if (productPromotionsModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(productPromotionsModel.m23548a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        productPromotionsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    ProductPromotionsParser.m23885a(productPromotionsModel.w_(), productPromotionsModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(ProductPromotionsModel.class, new Serializer());
                }
            }

            public ProductPromotionsModel() {
                super(1);
            }

            @Nonnull
            public final ImmutableList<BoostedComponentModel> m23550a() {
                this.f22190d = super.a(this.f22190d, 0, BoostedComponentModel.class);
                return (ImmutableList) this.f22190d;
            }

            public final int jK_() {
                return -1149463907;
            }

            public final GraphQLVisitableModel m23549a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m23550a() != null) {
                    Builder a = ModelHelper.a(m23550a(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        graphQLVisitableModel = (ProductPromotionsModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f22190d = a.b();
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m23548a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m23550a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, a);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: ZA */
        public class Serializer extends JsonSerializer<PromoteProductAdminInfoModel> {
            public final void m23551a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                PromoteProductAdminInfoModel promoteProductAdminInfoModel = (PromoteProductAdminInfoModel) obj;
                if (promoteProductAdminInfoModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(promoteProductAdminInfoModel.m23553a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    promoteProductAdminInfoModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = promoteProductAdminInfoModel.w_();
                int u_ = promoteProductAdminInfoModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("product_promotions");
                    ProductPromotionsParser.m23885a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(PromoteProductAdminInfoModel.class, new Serializer());
            }
        }

        public PromoteProductAdminInfoModel() {
            super(1);
        }

        @Nullable
        private ProductPromotionsModel m23552a() {
            this.f22191d = (ProductPromotionsModel) super.a(this.f22191d, 0, ProductPromotionsModel.class);
            return this.f22191d;
        }

        public final int jK_() {
            return 175920258;
        }

        public final GraphQLVisitableModel m23554a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m23552a() != null) {
                ProductPromotionsModel productPromotionsModel = (ProductPromotionsModel) graphQLModelMutatingVisitor.b(m23552a());
                if (m23552a() != productPromotionsModel) {
                    graphQLVisitableModel = (PromoteProductAdminInfoModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f22191d = productPromotionsModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m23553a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m23552a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }

    @FragmentModelWithBridge
    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 1954507529)
    @JsonSerialize(using = Serializer.class)
    /* compiled from: ZA */
    public final class PromoteProductInfoModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel {
        @Nullable
        private String f22201d;
        @Nullable
        private OrderedCollectionsModel f22202e;

        /* compiled from: ZA */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(PromoteProductInfoModel.class, new Deserializer());
            }

            public Object m23555a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(PromoteProductInfoParser.m23897a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object promoteProductInfoModel = new PromoteProductInfoModel();
                ((BaseModel) promoteProductInfoModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (promoteProductInfoModel instanceof Postprocessable) {
                    return ((Postprocessable) promoteProductInfoModel).a();
                }
                return promoteProductInfoModel;
            }
        }

        @FragmentModelWithBridge
        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 1154591749)
        @JsonSerialize(using = Serializer.class)
        /* compiled from: ZA */
        public final class OrderedCollectionsModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private List<NodesModel> f22200d;

            /* compiled from: ZA */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(OrderedCollectionsModel.class, new Deserializer());
                }

                public Object m23556a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(OrderedCollectionsParser.m23895a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object orderedCollectionsModel = new OrderedCollectionsModel();
                    ((BaseModel) orderedCollectionsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (orderedCollectionsModel instanceof Postprocessable) {
                        return ((Postprocessable) orderedCollectionsModel).a();
                    }
                    return orderedCollectionsModel;
                }
            }

            @FragmentModelWithBridge
            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = -1739232589)
            @JsonSerialize(using = Serializer.class)
            /* compiled from: ZA */
            public final class NodesModel extends BaseModel implements GraphQLVisitableModel {
                @Nullable
                private CollectionProductItemsModel f22199d;

                @FragmentModelWithBridge
                @JsonDeserialize(using = Deserializer.class)
                @ModelWithFlatBufferFormatHash(a = -1061795856)
                @JsonSerialize(using = Serializer.class)
                /* compiled from: ZA */
                public final class CollectionProductItemsModel extends BaseModel implements GraphQLVisitableModel {
                    @Nullable
                    private List<CollectionProductItemsNodesModel> f22198d;

                    @FragmentModelWithBridge
                    @JsonDeserialize(using = Deserializer.class)
                    @ModelWithFlatBufferFormatHash(a = -772430199)
                    @JsonSerialize(using = Serializer.class)
                    /* compiled from: ZA */
                    public final class CollectionProductItemsNodesModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel {
                        @Nullable
                        private String f22193d;
                        @Nullable
                        private String f22194e;
                        @Nullable
                        private String f22195f;
                        @Nullable
                        private List<OrderedImagesModel> f22196g;
                        @Nullable
                        private ProductPromotionsModel f22197h;

                        /* compiled from: ZA */
                        public class Deserializer extends FbJsonDeserializer {
                            static {
                                GlobalAutoGenDeserializerCache.a(CollectionProductItemsNodesModel.class, new Deserializer());
                            }

                            public Object m23557a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                flatBufferBuilder.d(CollectionProductItemsNodesParser.m23889b(jsonParser, flatBufferBuilder));
                                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                wrap.position(0);
                                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                                Object collectionProductItemsNodesModel = new CollectionProductItemsNodesModel();
                                ((BaseModel) collectionProductItemsNodesModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                                if (collectionProductItemsNodesModel instanceof Postprocessable) {
                                    return ((Postprocessable) collectionProductItemsNodesModel).a();
                                }
                                return collectionProductItemsNodesModel;
                            }
                        }

                        @JsonDeserialize(using = Deserializer.class)
                        @ModelWithFlatBufferFormatHash(a = -1236209140)
                        @JsonSerialize(using = Serializer.class)
                        @FragmentModelWithoutBridge
                        /* compiled from: ZA */
                        public final class OrderedImagesModel extends BaseModel implements GraphQLVisitableModel {
                            @Nullable
                            private DefaultImageFieldsModel f22192d;

                            /* compiled from: ZA */
                            public class Deserializer extends FbJsonDeserializer {
                                static {
                                    GlobalAutoGenDeserializerCache.a(OrderedImagesModel.class, new Deserializer());
                                }

                                public Object m23558a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                    flatBufferBuilder.d(OrderedImagesParser.m23887b(jsonParser, flatBufferBuilder));
                                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                    wrap.position(0);
                                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                                    Object orderedImagesModel = new OrderedImagesModel();
                                    ((BaseModel) orderedImagesModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                                    if (orderedImagesModel instanceof Postprocessable) {
                                        return ((Postprocessable) orderedImagesModel).a();
                                    }
                                    return orderedImagesModel;
                                }
                            }

                            /* compiled from: ZA */
                            public class Serializer extends JsonSerializer<OrderedImagesModel> {
                                public final void m23559a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                                    OrderedImagesModel orderedImagesModel = (OrderedImagesModel) obj;
                                    if (orderedImagesModel.w_() == null) {
                                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                        flatBufferBuilder.d(orderedImagesModel.m23560a(flatBufferBuilder));
                                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                        wrap.position(0);
                                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                        orderedImagesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                                    }
                                    OrderedImagesParser.m23888b(orderedImagesModel.w_(), orderedImagesModel.u_(), jsonGenerator, serializerProvider);
                                }

                                static {
                                    FbSerializerProvider.a(OrderedImagesModel.class, new Serializer());
                                }
                            }

                            public OrderedImagesModel() {
                                super(1);
                            }

                            @Nullable
                            public final DefaultImageFieldsModel m23561a() {
                                this.f22192d = (DefaultImageFieldsModel) super.a(this.f22192d, 0, DefaultImageFieldsModel.class);
                                return this.f22192d;
                            }

                            public final int jK_() {
                                return 1158348236;
                            }

                            public final GraphQLVisitableModel m23562a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                                GraphQLVisitableModel graphQLVisitableModel = null;
                                h();
                                if (m23561a() != null) {
                                    DefaultImageFieldsModel defaultImageFieldsModel = (DefaultImageFieldsModel) graphQLModelMutatingVisitor.b(m23561a());
                                    if (m23561a() != defaultImageFieldsModel) {
                                        graphQLVisitableModel = (OrderedImagesModel) ModelHelper.a(null, this);
                                        graphQLVisitableModel.f22192d = defaultImageFieldsModel;
                                    }
                                }
                                i();
                                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                            }

                            public final int m23560a(FlatBufferBuilder flatBufferBuilder) {
                                h();
                                int a = ModelHelper.a(flatBufferBuilder, m23561a());
                                flatBufferBuilder.c(1);
                                flatBufferBuilder.b(0, a);
                                i();
                                return flatBufferBuilder.d();
                            }
                        }

                        /* compiled from: ZA */
                        public class Serializer extends JsonSerializer<CollectionProductItemsNodesModel> {
                            public final void m23563a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                                CollectionProductItemsNodesModel collectionProductItemsNodesModel = (CollectionProductItemsNodesModel) obj;
                                if (collectionProductItemsNodesModel.w_() == null) {
                                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                    flatBufferBuilder.d(collectionProductItemsNodesModel.m23565a(flatBufferBuilder));
                                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                    wrap.position(0);
                                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                    collectionProductItemsNodesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                                }
                                CollectionProductItemsNodesParser.m23890b(collectionProductItemsNodesModel.w_(), collectionProductItemsNodesModel.u_(), jsonGenerator, serializerProvider);
                            }

                            static {
                                FbSerializerProvider.a(CollectionProductItemsNodesModel.class, new Serializer());
                            }
                        }

                        public CollectionProductItemsNodesModel() {
                            super(5);
                        }

                        @Nullable
                        public final String m23568j() {
                            this.f22193d = super.a(this.f22193d, 0);
                            return this.f22193d;
                        }

                        @Nullable
                        public final String m23569k() {
                            this.f22194e = super.a(this.f22194e, 1);
                            return this.f22194e;
                        }

                        @Nullable
                        private String m23564n() {
                            this.f22195f = super.a(this.f22195f, 2);
                            return this.f22195f;
                        }

                        @Nonnull
                        public final ImmutableList<OrderedImagesModel> m23570l() {
                            this.f22196g = super.a(this.f22196g, 3, OrderedImagesModel.class);
                            return (ImmutableList) this.f22196g;
                        }

                        @Nullable
                        public final ProductPromotionsModel m23571m() {
                            this.f22197h = (ProductPromotionsModel) super.a(this.f22197h, 4, ProductPromotionsModel.class);
                            return this.f22197h;
                        }

                        @Nullable
                        public final String m23567a() {
                            return m23569k();
                        }

                        public final int jK_() {
                            return 175920258;
                        }

                        public final GraphQLVisitableModel m23566a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                            GraphQLVisitableModel graphQLVisitableModel;
                            ProductPromotionsModel productPromotionsModel;
                            h();
                            if (m23570l() != null) {
                                Builder a = ModelHelper.a(m23570l(), graphQLModelMutatingVisitor);
                                if (a != null) {
                                    CollectionProductItemsNodesModel collectionProductItemsNodesModel = (CollectionProductItemsNodesModel) ModelHelper.a(null, this);
                                    collectionProductItemsNodesModel.f22196g = a.b();
                                    graphQLVisitableModel = collectionProductItemsNodesModel;
                                    if (m23571m() != null) {
                                        productPromotionsModel = (ProductPromotionsModel) graphQLModelMutatingVisitor.b(m23571m());
                                        if (m23571m() != productPromotionsModel) {
                                            graphQLVisitableModel = (CollectionProductItemsNodesModel) ModelHelper.a(graphQLVisitableModel, this);
                                            graphQLVisitableModel.f22197h = productPromotionsModel;
                                        }
                                    }
                                    i();
                                    return graphQLVisitableModel != null ? this : graphQLVisitableModel;
                                }
                            }
                            graphQLVisitableModel = null;
                            if (m23571m() != null) {
                                productPromotionsModel = (ProductPromotionsModel) graphQLModelMutatingVisitor.b(m23571m());
                                if (m23571m() != productPromotionsModel) {
                                    graphQLVisitableModel = (CollectionProductItemsNodesModel) ModelHelper.a(graphQLVisitableModel, this);
                                    graphQLVisitableModel.f22197h = productPromotionsModel;
                                }
                            }
                            i();
                            if (graphQLVisitableModel != null) {
                            }
                        }

                        public final int m23565a(FlatBufferBuilder flatBufferBuilder) {
                            h();
                            int b = flatBufferBuilder.b(m23568j());
                            int b2 = flatBufferBuilder.b(m23569k());
                            int b3 = flatBufferBuilder.b(m23564n());
                            int a = ModelHelper.a(flatBufferBuilder, m23570l());
                            int a2 = ModelHelper.a(flatBufferBuilder, m23571m());
                            flatBufferBuilder.c(5);
                            flatBufferBuilder.b(0, b);
                            flatBufferBuilder.b(1, b2);
                            flatBufferBuilder.b(2, b3);
                            flatBufferBuilder.b(3, a);
                            flatBufferBuilder.b(4, a2);
                            i();
                            return flatBufferBuilder.d();
                        }
                    }

                    /* compiled from: ZA */
                    public class Deserializer extends FbJsonDeserializer {
                        static {
                            GlobalAutoGenDeserializerCache.a(CollectionProductItemsModel.class, new Deserializer());
                        }

                        public Object m23572a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(CollectionProductItemsParser.m23891a(jsonParser, flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            mutableFlatBuffer.a(4, Boolean.valueOf(true));
                            MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                            Object collectionProductItemsModel = new CollectionProductItemsModel();
                            ((BaseModel) collectionProductItemsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                            if (collectionProductItemsModel instanceof Postprocessable) {
                                return ((Postprocessable) collectionProductItemsModel).a();
                            }
                            return collectionProductItemsModel;
                        }
                    }

                    /* compiled from: ZA */
                    public class Serializer extends JsonSerializer<CollectionProductItemsModel> {
                        public final void m23573a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                            CollectionProductItemsModel collectionProductItemsModel = (CollectionProductItemsModel) obj;
                            if (collectionProductItemsModel.w_() == null) {
                                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                flatBufferBuilder.d(collectionProductItemsModel.m23574a(flatBufferBuilder));
                                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                wrap.position(0);
                                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                collectionProductItemsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                            }
                            CollectionProductItemsParser.m23892a(collectionProductItemsModel.w_(), collectionProductItemsModel.u_(), jsonGenerator, serializerProvider);
                        }

                        static {
                            FbSerializerProvider.a(CollectionProductItemsModel.class, new Serializer());
                        }
                    }

                    public CollectionProductItemsModel() {
                        super(1);
                    }

                    @Nonnull
                    public final ImmutableList<CollectionProductItemsNodesModel> m23576a() {
                        this.f22198d = super.a(this.f22198d, 0, CollectionProductItemsNodesModel.class);
                        return (ImmutableList) this.f22198d;
                    }

                    public final int jK_() {
                        return -1537844013;
                    }

                    public final GraphQLVisitableModel m23575a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                        GraphQLVisitableModel graphQLVisitableModel = null;
                        h();
                        if (m23576a() != null) {
                            Builder a = ModelHelper.a(m23576a(), graphQLModelMutatingVisitor);
                            if (a != null) {
                                graphQLVisitableModel = (CollectionProductItemsModel) ModelHelper.a(null, this);
                                graphQLVisitableModel.f22198d = a.b();
                            }
                        }
                        i();
                        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                    }

                    public final int m23574a(FlatBufferBuilder flatBufferBuilder) {
                        h();
                        int a = ModelHelper.a(flatBufferBuilder, m23576a());
                        flatBufferBuilder.c(1);
                        flatBufferBuilder.b(0, a);
                        i();
                        return flatBufferBuilder.d();
                    }
                }

                /* compiled from: ZA */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(NodesModel.class, new Deserializer());
                    }

                    public Object m23577a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(OrderedCollectionsParser.NodesParser.m23893b(jsonParser, flatBufferBuilder));
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

                /* compiled from: ZA */
                public class Serializer extends JsonSerializer<NodesModel> {
                    public final void m23578a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        NodesModel nodesModel = (NodesModel) obj;
                        if (nodesModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(nodesModel.m23579a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            nodesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        OrderedCollectionsParser.NodesParser.m23894b(nodesModel.w_(), nodesModel.u_(), jsonGenerator, serializerProvider);
                    }

                    static {
                        FbSerializerProvider.a(NodesModel.class, new Serializer());
                    }
                }

                public NodesModel() {
                    super(1);
                }

                @Nullable
                public final CollectionProductItemsModel m23580a() {
                    this.f22199d = (CollectionProductItemsModel) super.a(this.f22199d, 0, CollectionProductItemsModel.class);
                    return this.f22199d;
                }

                public final int jK_() {
                    return -1187196444;
                }

                public final GraphQLVisitableModel m23581a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    GraphQLVisitableModel graphQLVisitableModel = null;
                    h();
                    if (m23580a() != null) {
                        CollectionProductItemsModel collectionProductItemsModel = (CollectionProductItemsModel) graphQLModelMutatingVisitor.b(m23580a());
                        if (m23580a() != collectionProductItemsModel) {
                            graphQLVisitableModel = (NodesModel) ModelHelper.a(null, this);
                            graphQLVisitableModel.f22199d = collectionProductItemsModel;
                        }
                    }
                    i();
                    return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                }

                public final int m23579a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int a = ModelHelper.a(flatBufferBuilder, m23580a());
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.b(0, a);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            /* compiled from: ZA */
            public class Serializer extends JsonSerializer<OrderedCollectionsModel> {
                public final void m23582a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    OrderedCollectionsModel orderedCollectionsModel = (OrderedCollectionsModel) obj;
                    if (orderedCollectionsModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(orderedCollectionsModel.m23583a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        orderedCollectionsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    OrderedCollectionsParser.m23896a(orderedCollectionsModel.w_(), orderedCollectionsModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(OrderedCollectionsModel.class, new Serializer());
                }
            }

            public OrderedCollectionsModel() {
                super(1);
            }

            @Nonnull
            public final ImmutableList<NodesModel> m23585a() {
                this.f22200d = super.a(this.f22200d, 0, NodesModel.class);
                return (ImmutableList) this.f22200d;
            }

            public final int jK_() {
                return 1993375565;
            }

            public final GraphQLVisitableModel m23584a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m23585a() != null) {
                    Builder a = ModelHelper.a(m23585a(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        graphQLVisitableModel = (OrderedCollectionsModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f22200d = a.b();
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m23583a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m23585a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, a);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: ZA */
        public class Serializer extends JsonSerializer<PromoteProductInfoModel> {
            public final void m23586a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                PromoteProductInfoModel promoteProductInfoModel = (PromoteProductInfoModel) obj;
                if (promoteProductInfoModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(promoteProductInfoModel.m23588a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    promoteProductInfoModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                PromoteProductInfoParser.m23898a(promoteProductInfoModel.w_(), promoteProductInfoModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(PromoteProductInfoModel.class, new Serializer());
            }
        }

        public PromoteProductInfoModel() {
            super(2);
        }

        @Nullable
        private String m23587k() {
            this.f22201d = super.a(this.f22201d, 0);
            return this.f22201d;
        }

        @Nullable
        public final OrderedCollectionsModel m23591j() {
            this.f22202e = (OrderedCollectionsModel) super.a(this.f22202e, 1, OrderedCollectionsModel.class);
            return this.f22202e;
        }

        @Nullable
        public final String m23590a() {
            return m23587k();
        }

        public final int jK_() {
            return 308731558;
        }

        public final GraphQLVisitableModel m23589a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m23591j() != null) {
                OrderedCollectionsModel orderedCollectionsModel = (OrderedCollectionsModel) graphQLModelMutatingVisitor.b(m23591j());
                if (m23591j() != orderedCollectionsModel) {
                    graphQLVisitableModel = (PromoteProductInfoModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f22202e = orderedCollectionsModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m23588a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(m23587k());
            int a = ModelHelper.a(flatBufferBuilder, m23591j());
            flatBufferBuilder.c(2);
            flatBufferBuilder.b(0, b);
            flatBufferBuilder.b(1, a);
            i();
            return flatBufferBuilder.d();
        }
    }

    @FragmentModelWithBridge
    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 111789397)
    @JsonSerialize(using = Serializer.class)
    /* compiled from: ZA */
    public final class PromoteWebsiteAdminInfoModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private BoostedWebsitePromotionsModel f22204d;
        private boolean f22205e;

        @FragmentModelWithBridge
        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1553092270)
        @JsonSerialize(using = Serializer.class)
        /* compiled from: ZA */
        public final class BoostedWebsitePromotionsModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private List<BoostedComponentModel> f22203d;

            /* compiled from: ZA */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(BoostedWebsitePromotionsModel.class, new Deserializer());
                }

                public Object m23592a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(BoostedWebsitePromotionsParser.m23899a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object boostedWebsitePromotionsModel = new BoostedWebsitePromotionsModel();
                    ((BaseModel) boostedWebsitePromotionsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (boostedWebsitePromotionsModel instanceof Postprocessable) {
                        return ((Postprocessable) boostedWebsitePromotionsModel).a();
                    }
                    return boostedWebsitePromotionsModel;
                }
            }

            /* compiled from: ZA */
            public class Serializer extends JsonSerializer<BoostedWebsitePromotionsModel> {
                public final void m23593a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    BoostedWebsitePromotionsModel boostedWebsitePromotionsModel = (BoostedWebsitePromotionsModel) obj;
                    if (boostedWebsitePromotionsModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(boostedWebsitePromotionsModel.m23594a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        boostedWebsitePromotionsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    BoostedWebsitePromotionsParser.m23900a(boostedWebsitePromotionsModel.w_(), boostedWebsitePromotionsModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(BoostedWebsitePromotionsModel.class, new Serializer());
                }
            }

            public BoostedWebsitePromotionsModel() {
                super(1);
            }

            @Nonnull
            public final ImmutableList<BoostedComponentModel> m23596a() {
                this.f22203d = super.a(this.f22203d, 0, BoostedComponentModel.class);
                return (ImmutableList) this.f22203d;
            }

            public final int jK_() {
                return -102361015;
            }

            public final GraphQLVisitableModel m23595a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m23596a() != null) {
                    Builder a = ModelHelper.a(m23596a(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        graphQLVisitableModel = (BoostedWebsitePromotionsModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f22203d = a.b();
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m23594a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m23596a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, a);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: ZA */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(PromoteWebsiteAdminInfoModel.class, new Deserializer());
            }

            public Object m23597a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = PromoteWebsiteAdminInfoParser.m23901a(jsonParser);
                Object promoteWebsiteAdminInfoModel = new PromoteWebsiteAdminInfoModel();
                ((BaseModel) promoteWebsiteAdminInfoModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (promoteWebsiteAdminInfoModel instanceof Postprocessable) {
                    return ((Postprocessable) promoteWebsiteAdminInfoModel).a();
                }
                return promoteWebsiteAdminInfoModel;
            }
        }

        /* compiled from: ZA */
        public class Serializer extends JsonSerializer<PromoteWebsiteAdminInfoModel> {
            public final void m23598a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                PromoteWebsiteAdminInfoModel promoteWebsiteAdminInfoModel = (PromoteWebsiteAdminInfoModel) obj;
                if (promoteWebsiteAdminInfoModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(promoteWebsiteAdminInfoModel.m23600a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    promoteWebsiteAdminInfoModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = promoteWebsiteAdminInfoModel.w_();
                int u_ = promoteWebsiteAdminInfoModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("boosted_website_promotions");
                    BoostedWebsitePromotionsParser.m23900a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                boolean a = mutableFlatBuffer.a(u_, 1);
                if (a) {
                    jsonGenerator.a("can_viewer_promote_website");
                    jsonGenerator.a(a);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(PromoteWebsiteAdminInfoModel.class, new Serializer());
            }
        }

        public PromoteWebsiteAdminInfoModel() {
            super(2);
        }

        @Nullable
        private BoostedWebsitePromotionsModel m23599a() {
            this.f22204d = (BoostedWebsitePromotionsModel) super.a(this.f22204d, 0, BoostedWebsitePromotionsModel.class);
            return this.f22204d;
        }

        public final int jK_() {
            return 888797870;
        }

        public final GraphQLVisitableModel m23601a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m23599a() != null) {
                BoostedWebsitePromotionsModel boostedWebsitePromotionsModel = (BoostedWebsitePromotionsModel) graphQLModelMutatingVisitor.b(m23599a());
                if (m23599a() != boostedWebsitePromotionsModel) {
                    graphQLVisitableModel = (PromoteWebsiteAdminInfoModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f22204d = boostedWebsitePromotionsModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m23600a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m23599a());
            flatBufferBuilder.c(2);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.a(1, this.f22205e);
            i();
            return flatBufferBuilder.d();
        }

        public final void m23602a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
            super.a(mutableFlatBuffer, i, obj);
            this.f22205e = mutableFlatBuffer.a(i, 1);
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -807245166)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: ZA */
    public final class ReverseGeocodeDataModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private String f22206d;
        @Nullable
        private String f22207e;

        /* compiled from: ZA */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(ReverseGeocodeDataModel.class, new Deserializer());
            }

            public Object m23603a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(ReverseGeocodeDataParser.m23903b(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object reverseGeocodeDataModel = new ReverseGeocodeDataModel();
                ((BaseModel) reverseGeocodeDataModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (reverseGeocodeDataModel instanceof Postprocessable) {
                    return ((Postprocessable) reverseGeocodeDataModel).a();
                }
                return reverseGeocodeDataModel;
            }
        }

        /* compiled from: ZA */
        public class Serializer extends JsonSerializer<ReverseGeocodeDataModel> {
            public final void m23604a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                ReverseGeocodeDataModel reverseGeocodeDataModel = (ReverseGeocodeDataModel) obj;
                if (reverseGeocodeDataModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(reverseGeocodeDataModel.m23605a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    reverseGeocodeDataModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                ReverseGeocodeDataParser.m23902a(reverseGeocodeDataModel.w_(), reverseGeocodeDataModel.u_(), jsonGenerator);
            }

            static {
                FbSerializerProvider.a(ReverseGeocodeDataModel.class, new Serializer());
            }
        }

        public ReverseGeocodeDataModel() {
            super(2);
        }

        @Nullable
        public final String m23607a() {
            this.f22206d = super.a(this.f22206d, 0);
            return this.f22206d;
        }

        @Nullable
        public final String m23608j() {
            this.f22207e = super.a(this.f22207e, 1);
            return this.f22207e;
        }

        public final int jK_() {
            return -1148071578;
        }

        public final GraphQLVisitableModel m23606a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            h();
            i();
            return this;
        }

        public final int m23605a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(m23607a());
            int b2 = flatBufferBuilder.b(m23608j());
            flatBufferBuilder.c(2);
            flatBufferBuilder.b(0, b);
            flatBufferBuilder.b(1, b2);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -918712821)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: ZA */
    public final class StoryFeedbackModel extends BaseModel implements GraphQLVisitableConsistentModel {
        private boolean f22212d;
        @Nullable
        private LikersModel f22213e;
        @Nullable
        private ResharesModel f22214f;
        @Nullable
        private TopLevelCommentsModel f22215g;

        /* compiled from: ZA */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(StoryFeedbackModel.class, new Deserializer());
            }

            public Object m23609a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(StoryFeedbackParser.m23910a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object storyFeedbackModel = new StoryFeedbackModel();
                ((BaseModel) storyFeedbackModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (storyFeedbackModel instanceof Postprocessable) {
                    return ((Postprocessable) storyFeedbackModel).a();
                }
                return storyFeedbackModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1723990064)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: ZA */
        public final class LikersModel extends BaseModel implements GraphQLVisitableModel {
            private int f22208d;

            /* compiled from: ZA */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(LikersModel.class, new Deserializer());
                }

                public Object m23610a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(LikersParser.m23904a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object likersModel = new LikersModel();
                    ((BaseModel) likersModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (likersModel instanceof Postprocessable) {
                        return ((Postprocessable) likersModel).a();
                    }
                    return likersModel;
                }
            }

            /* compiled from: ZA */
            public class Serializer extends JsonSerializer<LikersModel> {
                public final void m23611a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    LikersModel likersModel = (LikersModel) obj;
                    if (likersModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(likersModel.m23613a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        likersModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    LikersParser.m23905a(likersModel.w_(), likersModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(LikersModel.class, new Serializer());
                }
            }

            public LikersModel() {
                super(1);
            }

            public final int m23612a() {
                a(0, 0);
                return this.f22208d;
            }

            public final void m23615a(int i) {
                this.f22208d = i;
                if (this.b != null && this.b.d) {
                    this.b.b(this.c, 0, i);
                }
            }

            public final int jK_() {
                return 733369288;
            }

            public final GraphQLVisitableModel m23614a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m23613a(FlatBufferBuilder flatBufferBuilder) {
                h();
                flatBufferBuilder.c(1);
                flatBufferBuilder.a(0, this.f22208d, 0);
                i();
                return flatBufferBuilder.d();
            }

            public final void m23616a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                super.a(mutableFlatBuffer, i, obj);
                this.f22208d = mutableFlatBuffer.a(i, 0, 0);
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1723990064)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: ZA */
        public final class ResharesModel extends BaseModel implements GraphQLVisitableModel {
            private int f22209d;

            /* compiled from: ZA */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(ResharesModel.class, new Deserializer());
                }

                public Object m23617a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(ResharesParser.m23906a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object resharesModel = new ResharesModel();
                    ((BaseModel) resharesModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (resharesModel instanceof Postprocessable) {
                        return ((Postprocessable) resharesModel).a();
                    }
                    return resharesModel;
                }
            }

            /* compiled from: ZA */
            public class Serializer extends JsonSerializer<ResharesModel> {
                public final void m23618a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    ResharesModel resharesModel = (ResharesModel) obj;
                    if (resharesModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(resharesModel.m23620a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        resharesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    ResharesParser.m23907a(resharesModel.w_(), resharesModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(ResharesModel.class, new Serializer());
                }
            }

            public ResharesModel() {
                super(1);
            }

            public final int m23619a() {
                a(0, 0);
                return this.f22209d;
            }

            public final void m23622a(int i) {
                this.f22209d = i;
                if (this.b != null && this.b.d) {
                    this.b.b(this.c, 0, i);
                }
            }

            public final int jK_() {
                return -1260671207;
            }

            public final GraphQLVisitableModel m23621a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m23620a(FlatBufferBuilder flatBufferBuilder) {
                h();
                flatBufferBuilder.c(1);
                flatBufferBuilder.a(0, this.f22209d, 0);
                i();
                return flatBufferBuilder.d();
            }

            public final void m23623a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                super.a(mutableFlatBuffer, i, obj);
                this.f22209d = mutableFlatBuffer.a(i, 0, 0);
            }
        }

        /* compiled from: ZA */
        public class Serializer extends JsonSerializer<StoryFeedbackModel> {
            public final void m23624a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                StoryFeedbackModel storyFeedbackModel = (StoryFeedbackModel) obj;
                if (storyFeedbackModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(storyFeedbackModel.m23634a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    storyFeedbackModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                StoryFeedbackParser.m23911a(storyFeedbackModel.w_(), storyFeedbackModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(StoryFeedbackModel.class, new Serializer());
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -2056444745)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: ZA */
        public final class TopLevelCommentsModel extends BaseModel implements GraphQLVisitableModel {
            private int f22210d;
            private int f22211e;

            /* compiled from: ZA */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(TopLevelCommentsModel.class, new Deserializer());
                }

                public Object m23625a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(TopLevelCommentsParser.m23908a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object topLevelCommentsModel = new TopLevelCommentsModel();
                    ((BaseModel) topLevelCommentsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (topLevelCommentsModel instanceof Postprocessable) {
                        return ((Postprocessable) topLevelCommentsModel).a();
                    }
                    return topLevelCommentsModel;
                }
            }

            /* compiled from: ZA */
            public class Serializer extends JsonSerializer<TopLevelCommentsModel> {
                public final void m23626a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    TopLevelCommentsModel topLevelCommentsModel = (TopLevelCommentsModel) obj;
                    if (topLevelCommentsModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(topLevelCommentsModel.m23628a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        topLevelCommentsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    TopLevelCommentsParser.m23909a(topLevelCommentsModel.w_(), topLevelCommentsModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(TopLevelCommentsModel.class, new Serializer());
                }
            }

            public TopLevelCommentsModel() {
                super(2);
            }

            public final int m23627a() {
                a(0, 0);
                return this.f22210d;
            }

            public final void m23630a(int i) {
                this.f22210d = i;
                if (this.b != null && this.b.d) {
                    this.b.b(this.c, 0, i);
                }
            }

            public final int m23633j() {
                a(0, 1);
                return this.f22211e;
            }

            public final void m23632b(int i) {
                this.f22211e = i;
                if (this.b != null && this.b.d) {
                    this.b.b(this.c, 1, i);
                }
            }

            public final int jK_() {
                return 899897761;
            }

            public final GraphQLVisitableModel m23629a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m23628a(FlatBufferBuilder flatBufferBuilder) {
                h();
                flatBufferBuilder.c(2);
                flatBufferBuilder.a(0, this.f22210d, 0);
                flatBufferBuilder.a(1, this.f22211e, 0);
                i();
                return flatBufferBuilder.d();
            }

            public final void m23631a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                super.a(mutableFlatBuffer, i, obj);
                this.f22210d = mutableFlatBuffer.a(i, 0, 0);
                this.f22211e = mutableFlatBuffer.a(i, 1, 0);
            }
        }

        @Nullable
        public final /* synthetic */ LikersModel m23640b() {
            return m23643j();
        }

        @Nullable
        public final /* synthetic */ ResharesModel m23641c() {
            return m23644k();
        }

        @Nullable
        public final /* synthetic */ TopLevelCommentsModel m23642d() {
            return m23645l();
        }

        public StoryFeedbackModel() {
            super(4);
        }

        public final void m23637a(String str, ConsistencyTuple consistencyTuple) {
            if ("likers.count".equals(str)) {
                LikersModel j = m23643j();
                if (j != null) {
                    consistencyTuple.a = Integer.valueOf(j.m23612a());
                    consistencyTuple.b = j.u_();
                    consistencyTuple.c = 0;
                    return;
                }
            } else if ("reshares.count".equals(str)) {
                ResharesModel k = m23644k();
                if (k != null) {
                    consistencyTuple.a = Integer.valueOf(k.m23619a());
                    consistencyTuple.b = k.u_();
                    consistencyTuple.c = 0;
                    return;
                }
            } else if ("top_level_comments.count".equals(str)) {
                r0 = m23645l();
                if (r0 != null) {
                    consistencyTuple.a = Integer.valueOf(r0.m23627a());
                    consistencyTuple.b = r0.u_();
                    consistencyTuple.c = 0;
                    return;
                }
            } else if ("top_level_comments.total_count".equals(str)) {
                r0 = m23645l();
                if (r0 != null) {
                    consistencyTuple.a = Integer.valueOf(r0.m23633j());
                    consistencyTuple.b = r0.u_();
                    consistencyTuple.c = 1;
                    return;
                }
            }
            consistencyTuple.a();
        }

        public final void m23638a(String str, Object obj, boolean z) {
            if ("likers.count".equals(str)) {
                LikersModel j = m23643j();
                if (j == null) {
                    return;
                }
                if (z) {
                    j = (LikersModel) j.clone();
                    j.m23615a(((Integer) obj).intValue());
                    this.f22213e = j;
                    return;
                }
                j.m23615a(((Integer) obj).intValue());
            } else if ("reshares.count".equals(str)) {
                ResharesModel k = m23644k();
                if (k == null) {
                    return;
                }
                if (z) {
                    k = (ResharesModel) k.clone();
                    k.m23622a(((Integer) obj).intValue());
                    this.f22214f = k;
                    return;
                }
                k.m23622a(((Integer) obj).intValue());
            } else if ("top_level_comments.count".equals(str)) {
                r0 = m23645l();
                if (r0 == null) {
                    return;
                }
                if (z) {
                    r0 = (TopLevelCommentsModel) r0.clone();
                    r0.m23630a(((Integer) obj).intValue());
                    this.f22215g = r0;
                    return;
                }
                r0.m23630a(((Integer) obj).intValue());
            } else if ("top_level_comments.total_count".equals(str)) {
                r0 = m23645l();
                if (r0 == null) {
                    return;
                }
                if (z) {
                    r0 = (TopLevelCommentsModel) r0.clone();
                    r0.m23632b(((Integer) obj).intValue());
                    this.f22215g = r0;
                    return;
                }
                r0.m23632b(((Integer) obj).intValue());
            }
        }

        public final boolean m23639a() {
            a(0, 0);
            return this.f22212d;
        }

        @Nullable
        public final LikersModel m23643j() {
            this.f22213e = (LikersModel) super.a(this.f22213e, 1, LikersModel.class);
            return this.f22213e;
        }

        @Nullable
        public final ResharesModel m23644k() {
            this.f22214f = (ResharesModel) super.a(this.f22214f, 2, ResharesModel.class);
            return this.f22214f;
        }

        @Nullable
        public final TopLevelCommentsModel m23645l() {
            this.f22215g = (TopLevelCommentsModel) super.a(this.f22215g, 3, TopLevelCommentsModel.class);
            return this.f22215g;
        }

        public final int jK_() {
            return -126857307;
        }

        public final GraphQLVisitableModel m23635a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m23643j() != null) {
                LikersModel likersModel = (LikersModel) graphQLModelMutatingVisitor.b(m23643j());
                if (m23643j() != likersModel) {
                    graphQLVisitableModel = (StoryFeedbackModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f22213e = likersModel;
                }
            }
            if (m23644k() != null) {
                ResharesModel resharesModel = (ResharesModel) graphQLModelMutatingVisitor.b(m23644k());
                if (m23644k() != resharesModel) {
                    graphQLVisitableModel = (StoryFeedbackModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f22214f = resharesModel;
                }
            }
            if (m23645l() != null) {
                TopLevelCommentsModel topLevelCommentsModel = (TopLevelCommentsModel) graphQLModelMutatingVisitor.b(m23645l());
                if (m23645l() != topLevelCommentsModel) {
                    graphQLVisitableModel = (StoryFeedbackModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f22215g = topLevelCommentsModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m23634a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m23643j());
            int a2 = ModelHelper.a(flatBufferBuilder, m23644k());
            int a3 = ModelHelper.a(flatBufferBuilder, m23645l());
            flatBufferBuilder.c(4);
            flatBufferBuilder.a(0, this.f22212d);
            flatBufferBuilder.b(1, a);
            flatBufferBuilder.b(2, a2);
            flatBufferBuilder.b(3, a3);
            i();
            return flatBufferBuilder.d();
        }

        public final void m23636a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
            super.a(mutableFlatBuffer, i, obj);
            this.f22212d = mutableFlatBuffer.a(i, 0);
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -1489219564)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: ZA */
    public final class StoryInsightsModel extends BaseModel implements GraphQLVisitableModel {
        private int f22216d;
        private int f22217e;
        private int f22218f;
        private int f22219g;
        private int f22220h;
        private int f22221i;
        private int f22222j;
        private int f22223k;

        /* compiled from: ZA */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(StoryInsightsModel.class, new Deserializer());
            }

            public Object m23646a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(StoryInsightsParser.m23912a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object storyInsightsModel = new StoryInsightsModel();
                ((BaseModel) storyInsightsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (storyInsightsModel instanceof Postprocessable) {
                    return ((Postprocessable) storyInsightsModel).a();
                }
                return storyInsightsModel;
            }
        }

        /* compiled from: ZA */
        public class Serializer extends JsonSerializer<StoryInsightsModel> {
            public final void m23647a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                StoryInsightsModel storyInsightsModel = (StoryInsightsModel) obj;
                if (storyInsightsModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(storyInsightsModel.m23649a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    storyInsightsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                StoryInsightsParser.m23913a(storyInsightsModel.w_(), storyInsightsModel.u_(), jsonGenerator);
            }

            static {
                FbSerializerProvider.a(StoryInsightsModel.class, new Serializer());
            }
        }

        public StoryInsightsModel() {
            super(8);
        }

        public final int m23648a() {
            a(0, 0);
            return this.f22216d;
        }

        public final int m23652b() {
            a(0, 1);
            return this.f22217e;
        }

        public final int m23653c() {
            a(0, 2);
            return this.f22218f;
        }

        public final int m23654d() {
            a(0, 3);
            return this.f22219g;
        }

        public final int mO_() {
            a(0, 4);
            return this.f22220h;
        }

        public final int m23655g() {
            a(0, 5);
            return this.f22221i;
        }

        public final int mP_() {
            a(0, 6);
            return this.f22222j;
        }

        public final int mQ_() {
            a(0, 7);
            return this.f22223k;
        }

        public final int jK_() {
            return 1636368336;
        }

        public final GraphQLVisitableModel m23650a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            h();
            i();
            return this;
        }

        public final int m23649a(FlatBufferBuilder flatBufferBuilder) {
            h();
            flatBufferBuilder.c(8);
            flatBufferBuilder.a(0, this.f22216d, 0);
            flatBufferBuilder.a(1, this.f22217e, 0);
            flatBufferBuilder.a(2, this.f22218f, 0);
            flatBufferBuilder.a(3, this.f22219g, 0);
            flatBufferBuilder.a(4, this.f22220h, 0);
            flatBufferBuilder.a(5, this.f22221i, 0);
            flatBufferBuilder.a(6, this.f22222j, 0);
            flatBufferBuilder.a(7, this.f22223k, 0);
            i();
            return flatBufferBuilder.d();
        }

        public final void m23651a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
            super.a(mutableFlatBuffer, i, obj);
            this.f22216d = mutableFlatBuffer.a(i, 0, 0);
            this.f22217e = mutableFlatBuffer.a(i, 1, 0);
            this.f22218f = mutableFlatBuffer.a(i, 2, 0);
            this.f22219g = mutableFlatBuffer.a(i, 3, 0);
            this.f22220h = mutableFlatBuffer.a(i, 4, 0);
            this.f22221i = mutableFlatBuffer.a(i, 5, 0);
            this.f22222j = mutableFlatBuffer.a(i, 6, 0);
            this.f22223k = mutableFlatBuffer.a(i, 7, 0);
        }
    }

    @FragmentModelWithBridge
    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 1634744063)
    @JsonSerialize(using = Serializer.class)
    /* compiled from: ZA */
    public final class StoryPromotionInfoModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private AdAccountBasicFieldsModel f22225d;
        @Nullable
        private GraphQLBoostedPostAudienceOption f22226e;
        @Nullable
        private CurrencyQuantityModel f22227f;
        @Nullable
        private CampaignGroupResultsModel f22228g;
        @Nullable
        private GraphQLStory f22229h;
        private boolean f22230i;
        private int f22231j;
        @Nullable
        private ConversionPixelModel f22232k;
        @Nullable
        private String f22233l;
        @Nullable
        private DefaultTextWithEntitiesLongFieldsModel f22234m;
        private int f22235n;
        @Nullable
        private GraphQLBoostedPostStatus f22236o;
        private long f22237p;
        @Nullable
        private TargetingDescriptionModel f22238q;
        @Nullable
        private TargetSpecificationsModel f22239r;

        /* compiled from: ZA */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(StoryPromotionInfoModel.class, new Deserializer());
            }

            public Object m23656a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(StoryPromotionInfoParser.m23916a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object storyPromotionInfoModel = new StoryPromotionInfoModel();
                ((BaseModel) storyPromotionInfoModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (storyPromotionInfoModel instanceof Postprocessable) {
                    return ((Postprocessable) storyPromotionInfoModel).a();
                }
                return storyPromotionInfoModel;
            }
        }

        /* compiled from: ZA */
        public class Serializer extends JsonSerializer<StoryPromotionInfoModel> {
            public final void m23657a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                StoryPromotionInfoModel storyPromotionInfoModel = (StoryPromotionInfoModel) obj;
                if (storyPromotionInfoModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(storyPromotionInfoModel.m23663a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    storyPromotionInfoModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                StoryPromotionInfoParser.m23917a(storyPromotionInfoModel.w_(), storyPromotionInfoModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(StoryPromotionInfoModel.class, new Serializer());
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1104351312)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: ZA */
        public final class TargetingDescriptionModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private List<TargetingDescriptionModel> f22224d;

            /* compiled from: ZA */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(TargetingDescriptionModel.class, new Deserializer());
                }

                public Object m23658a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(TargetingDescriptionParser.m23914a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object targetingDescriptionModel = new TargetingDescriptionModel();
                    ((BaseModel) targetingDescriptionModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (targetingDescriptionModel instanceof Postprocessable) {
                        return ((Postprocessable) targetingDescriptionModel).a();
                    }
                    return targetingDescriptionModel;
                }
            }

            /* compiled from: ZA */
            public class Serializer extends JsonSerializer<TargetingDescriptionModel> {
                public final void m23659a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    TargetingDescriptionModel targetingDescriptionModel = (TargetingDescriptionModel) obj;
                    if (targetingDescriptionModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(targetingDescriptionModel.m23660a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        targetingDescriptionModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    TargetingDescriptionParser.m23915a(targetingDescriptionModel.w_(), targetingDescriptionModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(TargetingDescriptionModel.class, new Serializer());
                }
            }

            public TargetingDescriptionModel() {
                super(1);
            }

            @Nonnull
            public final ImmutableList<TargetingDescriptionModel> m23662a() {
                this.f22224d = super.a(this.f22224d, 0, TargetingDescriptionModel.class);
                return (ImmutableList) this.f22224d;
            }

            public final int jK_() {
                return -1830502406;
            }

            public final GraphQLVisitableModel m23661a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m23662a() != null) {
                    Builder a = ModelHelper.a(m23662a(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        graphQLVisitableModel = (TargetingDescriptionModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f22224d = a.b();
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m23660a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m23662a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, a);
                i();
                return flatBufferBuilder.d();
            }
        }

        public StoryPromotionInfoModel() {
            super(15);
        }

        @Nullable
        public final AdAccountBasicFieldsModel m23664a() {
            this.f22225d = (AdAccountBasicFieldsModel) super.a(this.f22225d, 0, AdAccountBasicFieldsModel.class);
            return this.f22225d;
        }

        @Nullable
        public final GraphQLBoostedPostAudienceOption m23667j() {
            this.f22226e = (GraphQLBoostedPostAudienceOption) super.b(this.f22226e, 1, GraphQLBoostedPostAudienceOption.class, GraphQLBoostedPostAudienceOption.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
            return this.f22226e;
        }

        @Nullable
        public final CurrencyQuantityModel m23668k() {
            this.f22227f = (CurrencyQuantityModel) super.a(this.f22227f, 2, CurrencyQuantityModel.class);
            return this.f22227f;
        }

        @Nullable
        public final CampaignGroupResultsModel m23669l() {
            this.f22228g = (CampaignGroupResultsModel) super.a(this.f22228g, 3, CampaignGroupResultsModel.class);
            return this.f22228g;
        }

        @Nullable
        public final GraphQLStory m23670m() {
            this.f22229h = (GraphQLStory) super.a(this.f22229h, 4, GraphQLStory.class);
            return this.f22229h;
        }

        public final boolean m23671n() {
            a(0, 5);
            return this.f22230i;
        }

        public final int m23672o() {
            a(0, 6);
            return this.f22231j;
        }

        @Nullable
        public final ConversionPixelModel m23673p() {
            this.f22232k = (ConversionPixelModel) super.a(this.f22232k, 7, ConversionPixelModel.class);
            return this.f22232k;
        }

        @Nullable
        public final String m23674q() {
            this.f22233l = super.a(this.f22233l, 8);
            return this.f22233l;
        }

        @Nullable
        public final DefaultTextWithEntitiesLongFieldsModel m23675r() {
            this.f22234m = (DefaultTextWithEntitiesLongFieldsModel) super.a(this.f22234m, 9, DefaultTextWithEntitiesLongFieldsModel.class);
            return this.f22234m;
        }

        public final int m23676s() {
            a(1, 2);
            return this.f22235n;
        }

        @Nullable
        public final GraphQLBoostedPostStatus m23677t() {
            this.f22236o = (GraphQLBoostedPostStatus) super.b(this.f22236o, 11, GraphQLBoostedPostStatus.class, GraphQLBoostedPostStatus.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
            return this.f22236o;
        }

        public final long m23678u() {
            a(1, 4);
            return this.f22237p;
        }

        @Nullable
        public final TargetingDescriptionModel m23679v() {
            this.f22238q = (TargetingDescriptionModel) super.a(this.f22238q, 13, TargetingDescriptionModel.class);
            return this.f22238q;
        }

        @Nullable
        public final TargetSpecificationsModel m23680w() {
            this.f22239r = (TargetSpecificationsModel) super.a(this.f22239r, 14, TargetSpecificationsModel.class);
            return this.f22239r;
        }

        public final int jK_() {
            return 349774914;
        }

        public final GraphQLVisitableModel m23665a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m23664a() != null) {
                AdAccountBasicFieldsModel adAccountBasicFieldsModel = (AdAccountBasicFieldsModel) graphQLModelMutatingVisitor.b(m23664a());
                if (m23664a() != adAccountBasicFieldsModel) {
                    graphQLVisitableModel = (StoryPromotionInfoModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f22225d = adAccountBasicFieldsModel;
                }
            }
            if (m23668k() != null) {
                CurrencyQuantityModel currencyQuantityModel = (CurrencyQuantityModel) graphQLModelMutatingVisitor.b(m23668k());
                if (m23668k() != currencyQuantityModel) {
                    graphQLVisitableModel = (StoryPromotionInfoModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f22227f = currencyQuantityModel;
                }
            }
            if (m23669l() != null) {
                CampaignGroupResultsModel campaignGroupResultsModel = (CampaignGroupResultsModel) graphQLModelMutatingVisitor.b(m23669l());
                if (m23669l() != campaignGroupResultsModel) {
                    graphQLVisitableModel = (StoryPromotionInfoModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f22228g = campaignGroupResultsModel;
                }
            }
            if (m23670m() != null) {
                GraphQLStory graphQLStory = (GraphQLStory) graphQLModelMutatingVisitor.b(m23670m());
                if (m23670m() != graphQLStory) {
                    graphQLVisitableModel = (StoryPromotionInfoModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f22229h = graphQLStory;
                }
            }
            if (m23673p() != null) {
                ConversionPixelModel conversionPixelModel = (ConversionPixelModel) graphQLModelMutatingVisitor.b(m23673p());
                if (m23673p() != conversionPixelModel) {
                    graphQLVisitableModel = (StoryPromotionInfoModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f22232k = conversionPixelModel;
                }
            }
            if (m23675r() != null) {
                DefaultTextWithEntitiesLongFieldsModel defaultTextWithEntitiesLongFieldsModel = (DefaultTextWithEntitiesLongFieldsModel) graphQLModelMutatingVisitor.b(m23675r());
                if (m23675r() != defaultTextWithEntitiesLongFieldsModel) {
                    graphQLVisitableModel = (StoryPromotionInfoModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f22234m = defaultTextWithEntitiesLongFieldsModel;
                }
            }
            if (m23679v() != null) {
                TargetingDescriptionModel targetingDescriptionModel = (TargetingDescriptionModel) graphQLModelMutatingVisitor.b(m23679v());
                if (m23679v() != targetingDescriptionModel) {
                    graphQLVisitableModel = (StoryPromotionInfoModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f22238q = targetingDescriptionModel;
                }
            }
            if (m23680w() != null) {
                TargetSpecificationsModel targetSpecificationsModel = (TargetSpecificationsModel) graphQLModelMutatingVisitor.b(m23680w());
                if (m23680w() != targetSpecificationsModel) {
                    graphQLVisitableModel = (StoryPromotionInfoModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f22239r = targetSpecificationsModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m23663a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m23664a());
            int a2 = flatBufferBuilder.a(m23667j());
            int a3 = ModelHelper.a(flatBufferBuilder, m23668k());
            int a4 = ModelHelper.a(flatBufferBuilder, m23669l());
            int a5 = ModelHelper.a(flatBufferBuilder, m23670m());
            int a6 = ModelHelper.a(flatBufferBuilder, m23673p());
            int b = flatBufferBuilder.b(m23674q());
            int a7 = ModelHelper.a(flatBufferBuilder, m23675r());
            int a8 = flatBufferBuilder.a(m23677t());
            int a9 = ModelHelper.a(flatBufferBuilder, m23679v());
            int a10 = ModelHelper.a(flatBufferBuilder, m23680w());
            flatBufferBuilder.c(15);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, a2);
            flatBufferBuilder.b(2, a3);
            flatBufferBuilder.b(3, a4);
            flatBufferBuilder.b(4, a5);
            flatBufferBuilder.a(5, this.f22230i);
            flatBufferBuilder.a(6, this.f22231j, 0);
            flatBufferBuilder.b(7, a6);
            flatBufferBuilder.b(8, b);
            flatBufferBuilder.b(9, a7);
            flatBufferBuilder.a(10, this.f22235n, 0);
            flatBufferBuilder.b(11, a8);
            flatBufferBuilder.a(12, this.f22237p, 0);
            flatBufferBuilder.b(13, a9);
            flatBufferBuilder.b(14, a10);
            i();
            return flatBufferBuilder.d();
        }

        public final void m23666a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
            super.a(mutableFlatBuffer, i, obj);
            this.f22230i = mutableFlatBuffer.a(i, 5);
            this.f22231j = mutableFlatBuffer.a(i, 6, 0);
            this.f22235n = mutableFlatBuffer.a(i, 10, 0);
            this.f22237p = mutableFlatBuffer.a(i, 12, 0);
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 383725816)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: ZA */
    public final class StoryPromotionInsightsModel extends BaseModel implements GraphQLVisitableConsistentModel {
        @Nullable
        private StoryFeedbackModel f22240d;
        @Nullable
        private StoryInsightsModel f22241e;

        /* compiled from: ZA */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(StoryPromotionInsightsModel.class, new Deserializer());
            }

            public Object m23681a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = StoryPromotionInsightsParser.m23918a(jsonParser);
                Object storyPromotionInsightsModel = new StoryPromotionInsightsModel();
                ((BaseModel) storyPromotionInsightsModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (storyPromotionInsightsModel instanceof Postprocessable) {
                    return ((Postprocessable) storyPromotionInsightsModel).a();
                }
                return storyPromotionInsightsModel;
            }
        }

        /* compiled from: ZA */
        public class Serializer extends JsonSerializer<StoryPromotionInsightsModel> {
            public final void m23682a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                StoryPromotionInsightsModel storyPromotionInsightsModel = (StoryPromotionInsightsModel) obj;
                if (storyPromotionInsightsModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(storyPromotionInsightsModel.m23683a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    storyPromotionInsightsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = storyPromotionInsightsModel.w_();
                int u_ = storyPromotionInsightsModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("feedback");
                    StoryFeedbackParser.m23911a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                g = mutableFlatBuffer.g(u_, 1);
                if (g != 0) {
                    jsonGenerator.a("insights");
                    StoryInsightsParser.m23913a(mutableFlatBuffer, g, jsonGenerator);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(StoryPromotionInsightsModel.class, new Serializer());
            }
        }

        public StoryPromotionInsightsModel() {
            super(2);
        }

        public final void m23686a(String str, ConsistencyTuple consistencyTuple) {
            consistencyTuple.a();
        }

        public final void m23687a(String str, Object obj, boolean z) {
        }

        @Nullable
        public final StoryFeedbackModel m23684a() {
            this.f22240d = (StoryFeedbackModel) super.a(this.f22240d, 0, StoryFeedbackModel.class);
            return this.f22240d;
        }

        @Nullable
        public final StoryInsightsModel m23688j() {
            this.f22241e = (StoryInsightsModel) super.a(this.f22241e, 1, StoryInsightsModel.class);
            return this.f22241e;
        }

        public final int jK_() {
            return 80218325;
        }

        public final GraphQLVisitableModel m23685a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m23684a() != null) {
                StoryFeedbackModel storyFeedbackModel = (StoryFeedbackModel) graphQLModelMutatingVisitor.b(m23684a());
                if (m23684a() != storyFeedbackModel) {
                    graphQLVisitableModel = (StoryPromotionInsightsModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f22240d = storyFeedbackModel;
                }
            }
            if (m23688j() != null) {
                StoryInsightsModel storyInsightsModel = (StoryInsightsModel) graphQLModelMutatingVisitor.b(m23688j());
                if (m23688j() != storyInsightsModel) {
                    graphQLVisitableModel = (StoryPromotionInsightsModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f22241e = storyInsightsModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m23683a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m23684a());
            int a2 = ModelHelper.a(flatBufferBuilder, m23688j());
            flatBufferBuilder.c(2);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, a2);
            i();
            return flatBufferBuilder.d();
        }
    }

    @FragmentModelWithBridge
    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 1638029223)
    @JsonSerialize(using = Serializer.class)
    /* compiled from: ZA */
    public final class StoryPromotionModel extends BaseModel implements GraphQLVisitableConsistentModel {
        @Nullable
        private GraphQLObjectType f22252d;
        @Nullable
        private StoryFeedbackModel f22253e;
        @Nullable
        private StoryInsightsModel f22254f;
        @Nullable
        private PostPromotionInfoModel f22255g;
        @Nullable
        private StoryPromotionInfoModel f22256h;
        @Nullable
        private EventInfoModel f22257i;

        /* compiled from: ZA */
        public final class Builder {
            @Nullable
            public GraphQLObjectType f22242a;
            @Nullable
            public StoryFeedbackModel f22243b;
            @Nullable
            public StoryInsightsModel f22244c;
            @Nullable
            public PostPromotionInfoModel f22245d;
            @Nullable
            public StoryPromotionInfoModel f22246e;
            @Nullable
            public EventInfoModel f22247f;

            public final com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.StoryPromotionModel m23689a() {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r11 = this;
                r4 = 1;
                r10 = 0;
                r2 = 0;
                r0 = new com.facebook.flatbuffers.FlatBufferBuilder;
                r1 = 128; // 0x80 float:1.794E-43 double:6.32E-322;
                r0.<init>(r1);
                r1 = r11.f22242a;
                r1 = com.facebook.graphql.modelutil.ModelHelper.a(r0, r1);
                r3 = r11.f22243b;
                r3 = com.facebook.graphql.modelutil.ModelHelper.a(r0, r3);
                r5 = r11.f22244c;
                r5 = com.facebook.graphql.modelutil.ModelHelper.a(r0, r5);
                r6 = r11.f22245d;
                r6 = com.facebook.graphql.modelutil.ModelHelper.a(r0, r6);
                r7 = r11.f22246e;
                r7 = com.facebook.graphql.modelutil.ModelHelper.a(r0, r7);
                r8 = r11.f22247f;
                r8 = com.facebook.graphql.modelutil.ModelHelper.a(r0, r8);
                r9 = 6;
                r0.c(r9);
                r0.b(r10, r1);
                r0.b(r4, r3);
                r1 = 2;
                r0.b(r1, r5);
                r1 = 3;
                r0.b(r1, r6);
                r1 = 4;
                r0.b(r1, r7);
                r1 = 5;
                r0.b(r1, r8);
                r1 = r0.d();
                r0.d(r1);
                r0 = r0.e();
                r1 = java.nio.ByteBuffer.wrap(r0);
                r1.position(r10);
                r0 = new com.facebook.flatbuffers.MutableFlatBuffer;
                r3 = r2;
                r5 = r2;
                r0.<init>(r1, r2, r3, r4, r5);
                r1 = new com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels$StoryPromotionModel;
                r1.<init>(r0);
                return r1;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.StoryPromotionModel.Builder.a():com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels$StoryPromotionModel");
            }
        }

        /* compiled from: ZA */
        public class Deserializer extends FbJsonDeserializer {
            static {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r0 = com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.StoryPromotionModel.class;
                r1 = new com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels$StoryPromotionModel$Deserializer;
                r1.<init>();
                com.facebook.common.json.GlobalAutoGenDeserializerCache.a(r0, r1);
                return;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.StoryPromotionModel.Deserializer.<clinit>():void");
            }

            public java.lang.Object m23690a(com.fasterxml.jackson.core.JsonParser r6, com.fasterxml.jackson.databind.DeserializationContext r7) {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r5 = this;
                r2 = com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsParsers.StoryPromotionParser.m23923a(r6);
                r1 = new com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels$StoryPromotionModel;
                r1.<init>();
                r4 = r2.a;
                r0 = r4;
                r3 = com.facebook.flatbuffers.FlatBuffer.a(r0);
                r0 = r1;
                r0 = (com.facebook.graphql.modelutil.BaseModel) r0;
                r0.a(r2, r3, r6);
                r0 = r1 instanceof com.facebook.common.json.Postprocessable;
                if (r0 == 0) goto L_0x0020;
            L_0x001a:
                r1 = (com.facebook.common.json.Postprocessable) r1;
                r1 = r1.a();
            L_0x0020:
                return r1;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.StoryPromotionModel.Deserializer.a(com.fasterxml.jackson.core.JsonParser, com.fasterxml.jackson.databind.DeserializationContext):java.lang.Object");
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 767734541)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: ZA */
        public final class PostPromotionInfoModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private DefaultSpecModel f22250d;
            @Nullable
            private List<BoostedComponentValidationMessageModel> f22251e;

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = 158999184)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: ZA */
            public final class DefaultSpecModel extends BaseModel implements GraphQLVisitableModel {
                private int f22248d;
                @Nullable
                private GraphQLAdsApiPacingType f22249e;

                /* compiled from: ZA */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                        /*
                        r0 = com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.StoryPromotionModel.PostPromotionInfoModel.DefaultSpecModel.class;
                        r1 = new com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels$StoryPromotionModel$PostPromotionInfoModel$DefaultSpecModel$Deserializer;
                        r1.<init>();
                        com.facebook.common.json.GlobalAutoGenDeserializerCache.a(r0, r1);
                        return;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.StoryPromotionModel.PostPromotionInfoModel.DefaultSpecModel.Deserializer.<clinit>():void");
                    }

                    public java.lang.Object m23691a(com.fasterxml.jackson.core.JsonParser r11, com.fasterxml.jackson.databind.DeserializationContext r12) {
                        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                        /*
                        r10 = this;
                        r8 = 1;
                        r6 = 0;
                        r4 = new com.facebook.flatbuffers.FlatBufferBuilder;
                        r5 = 128; // 0x80 float:1.794E-43 double:6.32E-322;
                        r4.<init>(r5);
                        r5 = com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsParsers.StoryPromotionParser.PostPromotionInfoParser.DefaultSpecParser.m23919a(r11, r4);
                        r4.d(r5);
                        r4 = r4.e();
                        r5 = java.nio.ByteBuffer.wrap(r4);
                        r4 = 0;
                        r5.position(r4);
                        r4 = new com.facebook.flatbuffers.MutableFlatBuffer;
                        r7 = r6;
                        r9 = r6;
                        r4.<init>(r5, r6, r7, r8, r9);
                        r5 = 4;
                        r6 = java.lang.Boolean.valueOf(r8);
                        r4.a(r5, r6);
                        r2 = r4;
                        r1 = new com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels$StoryPromotionModel$PostPromotionInfoModel$DefaultSpecModel;
                        r1.<init>();
                        r4 = r2.a;
                        r0 = r4;
                        r3 = com.facebook.flatbuffers.FlatBuffer.a(r0);
                        r0 = r1;
                        r0 = (com.facebook.graphql.modelutil.BaseModel) r0;
                        r0.a(r2, r3, r11);
                        r0 = r1 instanceof com.facebook.common.json.Postprocessable;
                        if (r0 == 0) goto L_0x0048;
                    L_0x0042:
                        r1 = (com.facebook.common.json.Postprocessable) r1;
                        r1 = r1.a();
                    L_0x0048:
                        return r1;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.StoryPromotionModel.PostPromotionInfoModel.DefaultSpecModel.Deserializer.a(com.fasterxml.jackson.core.JsonParser, com.fasterxml.jackson.databind.DeserializationContext):java.lang.Object");
                    }
                }

                /* compiled from: ZA */
                public class Serializer extends JsonSerializer<DefaultSpecModel> {
                    public final void m23692a(java.lang.Object r8, com.fasterxml.jackson.core.JsonGenerator r9, com.fasterxml.jackson.databind.SerializerProvider r10) {
                        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                        /*
                        r7 = this;
                        r8 = (com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.StoryPromotionModel.PostPromotionInfoModel.DefaultSpecModel) r8;
                        r2 = 0;
                        r0 = r8.w_();
                        if (r0 != 0) goto L_0x0035;
                    L_0x0009:
                        r0 = new com.facebook.flatbuffers.FlatBufferBuilder;
                        r1 = 128; // 0x80 float:1.794E-43 double:6.32E-322;
                        r0.<init>(r1);
                        r1 = r8.m23694a(r0);
                        r0.d(r1);
                        r0 = r0.e();
                        r1 = java.nio.ByteBuffer.wrap(r0);
                        r0 = 0;
                        r1.position(r0);
                        r0 = new com.facebook.flatbuffers.MutableFlatBuffer;
                        r4 = 1;
                        r3 = r2;
                        r5 = r2;
                        r0.<init>(r1, r2, r3, r4, r5);
                        r6 = r0.a;
                        r1 = r6;
                        r1 = com.facebook.flatbuffers.FlatBuffer.a(r1);
                        r8.a(r0, r1);
                    L_0x0035:
                        r0 = r8.w_();
                        r1 = r8.u_();
                        com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsParsers.StoryPromotionParser.PostPromotionInfoParser.DefaultSpecParser.m23920a(r0, r1, r9);
                        return;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.StoryPromotionModel.PostPromotionInfoModel.DefaultSpecModel.Serializer.a(java.lang.Object, com.fasterxml.jackson.core.JsonGenerator, com.fasterxml.jackson.databind.SerializerProvider):void");
                    }

                    static {
                        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                        /*
                        r0 = com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.StoryPromotionModel.PostPromotionInfoModel.DefaultSpecModel.class;
                        r1 = new com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels$StoryPromotionModel$PostPromotionInfoModel$DefaultSpecModel$Serializer;
                        r1.<init>();
                        com.facebook.common.json.FbSerializerProvider.a(r0, r1);
                        return;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.StoryPromotionModel.PostPromotionInfoModel.DefaultSpecModel.Serializer.<clinit>():void");
                    }
                }

                public DefaultSpecModel() {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r1 = this;
                    r0 = 2;
                    r1.<init>(r0);
                    return;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.StoryPromotionModel.PostPromotionInfoModel.DefaultSpecModel.<init>():void");
                }

                public final int m23693a() {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r1 = this;
                    r0 = 0;
                    r1.a(r0, r0);
                    r0 = r1.f22248d;
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.StoryPromotionModel.PostPromotionInfoModel.DefaultSpecModel.a():int");
                }

                @javax.annotation.Nullable
                public final com.facebook.graphql.enums.GraphQLAdsApiPacingType m23697j() {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r4 = this;
                    r0 = r4.f22249e;
                    r1 = 1;
                    r2 = com.facebook.graphql.enums.GraphQLAdsApiPacingType.class;
                    r3 = com.facebook.graphql.enums.GraphQLAdsApiPacingType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
                    r0 = super.b(r0, r1, r2, r3);
                    r0 = (com.facebook.graphql.enums.GraphQLAdsApiPacingType) r0;
                    r4.f22249e = r0;
                    r0 = r4.f22249e;
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.StoryPromotionModel.PostPromotionInfoModel.DefaultSpecModel.j():com.facebook.graphql.enums.GraphQLAdsApiPacingType");
                }

                public final int jK_() {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r1 = this;
                    r0 = 1218236129; // 0x489ccee1 float:321143.03 double:6.0188862E-315;
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.StoryPromotionModel.PostPromotionInfoModel.DefaultSpecModel.jK_():int");
                }

                public final com.facebook.graphql.visitor.GraphQLVisitableModel m23695a(com.facebook.graphql.visitor.GraphQLModelMutatingVisitor r1) {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r0 = this;
                    r0.h();
                    r0.i();
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.StoryPromotionModel.PostPromotionInfoModel.DefaultSpecModel.a(com.facebook.graphql.visitor.GraphQLModelMutatingVisitor):com.facebook.graphql.visitor.GraphQLVisitableModel");
                }

                public final int m23694a(com.facebook.flatbuffers.FlatBufferBuilder r4) {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r3 = this;
                    r2 = 0;
                    r3.h();
                    r0 = r3.m23697j();
                    r0 = r4.a(r0);
                    r1 = 2;
                    r4.c(r1);
                    r1 = r3.f22248d;
                    r4.a(r2, r1, r2);
                    r1 = 1;
                    r4.b(r1, r0);
                    r3.i();
                    r0 = r4.d();
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.StoryPromotionModel.PostPromotionInfoModel.DefaultSpecModel.a(com.facebook.flatbuffers.FlatBufferBuilder):int");
                }

                public final void m23696a(com.facebook.flatbuffers.MutableFlatBuffer r2, int r3, java.lang.Object r4) {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r1 = this;
                    r0 = 0;
                    super.a(r2, r3, r4);
                    r0 = r2.a(r3, r0, r0);
                    r1.f22248d = r0;
                    return;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.StoryPromotionModel.PostPromotionInfoModel.DefaultSpecModel.a(com.facebook.flatbuffers.MutableFlatBuffer, int, java.lang.Object):void");
                }
            }

            /* compiled from: ZA */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r0 = com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.StoryPromotionModel.PostPromotionInfoModel.class;
                    r1 = new com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels$StoryPromotionModel$PostPromotionInfoModel$Deserializer;
                    r1.<init>();
                    com.facebook.common.json.GlobalAutoGenDeserializerCache.a(r0, r1);
                    return;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.StoryPromotionModel.PostPromotionInfoModel.Deserializer.<clinit>():void");
                }

                public java.lang.Object m23698a(com.fasterxml.jackson.core.JsonParser r11, com.fasterxml.jackson.databind.DeserializationContext r12) {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r10 = this;
                    r8 = 1;
                    r6 = 0;
                    r4 = new com.facebook.flatbuffers.FlatBufferBuilder;
                    r5 = 128; // 0x80 float:1.794E-43 double:6.32E-322;
                    r4.<init>(r5);
                    r5 = com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsParsers.StoryPromotionParser.PostPromotionInfoParser.m23921a(r11, r4);
                    r4.d(r5);
                    r4 = r4.e();
                    r5 = java.nio.ByteBuffer.wrap(r4);
                    r4 = 0;
                    r5.position(r4);
                    r4 = new com.facebook.flatbuffers.MutableFlatBuffer;
                    r7 = r6;
                    r9 = r6;
                    r4.<init>(r5, r6, r7, r8, r9);
                    r5 = 4;
                    r6 = java.lang.Boolean.valueOf(r8);
                    r4.a(r5, r6);
                    r2 = r4;
                    r1 = new com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels$StoryPromotionModel$PostPromotionInfoModel;
                    r1.<init>();
                    r4 = r2.a;
                    r0 = r4;
                    r3 = com.facebook.flatbuffers.FlatBuffer.a(r0);
                    r0 = r1;
                    r0 = (com.facebook.graphql.modelutil.BaseModel) r0;
                    r0.a(r2, r3, r11);
                    r0 = r1 instanceof com.facebook.common.json.Postprocessable;
                    if (r0 == 0) goto L_0x0048;
                L_0x0042:
                    r1 = (com.facebook.common.json.Postprocessable) r1;
                    r1 = r1.a();
                L_0x0048:
                    return r1;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.StoryPromotionModel.PostPromotionInfoModel.Deserializer.a(com.fasterxml.jackson.core.JsonParser, com.fasterxml.jackson.databind.DeserializationContext):java.lang.Object");
                }
            }

            /* compiled from: ZA */
            public class Serializer extends JsonSerializer<PostPromotionInfoModel> {
                public final void m23699a(java.lang.Object r8, com.fasterxml.jackson.core.JsonGenerator r9, com.fasterxml.jackson.databind.SerializerProvider r10) {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r7 = this;
                    r8 = (com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.StoryPromotionModel.PostPromotionInfoModel) r8;
                    r2 = 0;
                    r0 = r8.w_();
                    if (r0 != 0) goto L_0x0035;
                L_0x0009:
                    r0 = new com.facebook.flatbuffers.FlatBufferBuilder;
                    r1 = 128; // 0x80 float:1.794E-43 double:6.32E-322;
                    r0.<init>(r1);
                    r1 = r8.m23700a(r0);
                    r0.d(r1);
                    r0 = r0.e();
                    r1 = java.nio.ByteBuffer.wrap(r0);
                    r0 = 0;
                    r1.position(r0);
                    r0 = new com.facebook.flatbuffers.MutableFlatBuffer;
                    r4 = 1;
                    r3 = r2;
                    r5 = r2;
                    r0.<init>(r1, r2, r3, r4, r5);
                    r6 = r0.a;
                    r1 = r6;
                    r1 = com.facebook.flatbuffers.FlatBuffer.a(r1);
                    r8.a(r0, r1);
                L_0x0035:
                    r0 = r8.w_();
                    r1 = r8.u_();
                    com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsParsers.StoryPromotionParser.PostPromotionInfoParser.m23922a(r0, r1, r9, r10);
                    return;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.StoryPromotionModel.PostPromotionInfoModel.Serializer.a(java.lang.Object, com.fasterxml.jackson.core.JsonGenerator, com.fasterxml.jackson.databind.SerializerProvider):void");
                }

                static {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r0 = com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.StoryPromotionModel.PostPromotionInfoModel.class;
                    r1 = new com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels$StoryPromotionModel$PostPromotionInfoModel$Serializer;
                    r1.<init>();
                    com.facebook.common.json.FbSerializerProvider.a(r0, r1);
                    return;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.StoryPromotionModel.PostPromotionInfoModel.Serializer.<clinit>():void");
                }
            }

            public PostPromotionInfoModel() {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r1 = this;
                r0 = 2;
                r1.<init>(r0);
                return;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.StoryPromotionModel.PostPromotionInfoModel.<init>():void");
            }

            @javax.annotation.Nullable
            public final com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.StoryPromotionModel.PostPromotionInfoModel.DefaultSpecModel m23701a() {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r3 = this;
                r0 = r3.f22250d;
                r1 = 0;
                r2 = com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.StoryPromotionModel.PostPromotionInfoModel.DefaultSpecModel.class;
                r0 = super.a(r0, r1, r2);
                r0 = (com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.StoryPromotionModel.PostPromotionInfoModel.DefaultSpecModel) r0;
                r3.f22250d = r0;
                r0 = r3.f22250d;
                return r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.StoryPromotionModel.PostPromotionInfoModel.a():com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels$StoryPromotionModel$PostPromotionInfoModel$DefaultSpecModel");
            }

            @javax.annotation.Nonnull
            public final com.google.common.collect.ImmutableList<com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.BoostedComponentValidationMessageModel> m23703j() {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r3 = this;
                r0 = r3.f22251e;
                r1 = 1;
                r2 = com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.BoostedComponentValidationMessageModel.class;
                r0 = super.a(r0, r1, r2);
                r3.f22251e = r0;
                r0 = r3.f22251e;
                r0 = (com.google.common.collect.ImmutableList) r0;
                return r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.StoryPromotionModel.PostPromotionInfoModel.j():com.google.common.collect.ImmutableList<com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels$BoostedComponentValidationMessageModel>");
            }

            public final int jK_() {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r1 = this;
                r0 = -47218757; // 0xfffffffffd2f7fbb float:-1.4579882E37 double:NaN;
                return r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.StoryPromotionModel.PostPromotionInfoModel.jK_():int");
            }

            public final com.facebook.graphql.visitor.GraphQLVisitableModel m23702a(com.facebook.graphql.visitor.GraphQLModelMutatingVisitor r4) {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r3 = this;
                r1 = 0;
                r3.h();
                r0 = r3.m23701a();
                if (r0 == 0) goto L_0x0022;
            L_0x000a:
                r0 = r3.m23701a();
                r0 = r4.b(r0);
                r0 = (com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.StoryPromotionModel.PostPromotionInfoModel.DefaultSpecModel) r0;
                r2 = r3.m23701a();
                if (r2 == r0) goto L_0x0022;
            L_0x001a:
                r1 = com.facebook.graphql.modelutil.ModelHelper.a(r1, r3);
                r1 = (com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.StoryPromotionModel.PostPromotionInfoModel) r1;
                r1.f22250d = r0;
            L_0x0022:
                r0 = r3.m23703j();
                if (r0 == 0) goto L_0x003f;
            L_0x0028:
                r0 = r3.m23703j();
                r2 = com.facebook.graphql.modelutil.ModelHelper.a(r0, r4);
                if (r2 == 0) goto L_0x003f;
            L_0x0032:
                r0 = com.facebook.graphql.modelutil.ModelHelper.a(r1, r3);
                r0 = (com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.StoryPromotionModel.PostPromotionInfoModel) r0;
                r1 = r2.b();
                r0.f22251e = r1;
                r1 = r0;
            L_0x003f:
                r3.i();
                if (r1 != 0) goto L_0x0045;
            L_0x0044:
                return r3;
            L_0x0045:
                r3 = r1;
                goto L_0x0044;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.StoryPromotionModel.PostPromotionInfoModel.a(com.facebook.graphql.visitor.GraphQLModelMutatingVisitor):com.facebook.graphql.visitor.GraphQLVisitableModel");
            }

            public final int m23700a(com.facebook.flatbuffers.FlatBufferBuilder r4) {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r3 = this;
                r3.h();
                r0 = r3.m23701a();
                r0 = com.facebook.graphql.modelutil.ModelHelper.a(r4, r0);
                r1 = r3.m23703j();
                r1 = com.facebook.graphql.modelutil.ModelHelper.a(r4, r1);
                r2 = 2;
                r4.c(r2);
                r2 = 0;
                r4.b(r2, r0);
                r0 = 1;
                r4.b(r0, r1);
                r3.i();
                r0 = r4.d();
                return r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.StoryPromotionModel.PostPromotionInfoModel.a(com.facebook.flatbuffers.FlatBufferBuilder):int");
            }
        }

        /* compiled from: ZA */
        public class Serializer extends JsonSerializer<StoryPromotionModel> {
            public final void m23704a(java.lang.Object r9, com.fasterxml.jackson.core.JsonGenerator r10, com.fasterxml.jackson.databind.SerializerProvider r11) {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r8 = this;
                r9 = (com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.StoryPromotionModel) r9;
                r2 = 0;
                r0 = r9.w_();
                if (r0 != 0) goto L_0x0035;
            L_0x0009:
                r0 = new com.facebook.flatbuffers.FlatBufferBuilder;
                r1 = 128; // 0x80 float:1.794E-43 double:6.32E-322;
                r0.<init>(r1);
                r1 = r9.m23706a(r0);
                r0.d(r1);
                r0 = r0.e();
                r1 = java.nio.ByteBuffer.wrap(r0);
                r0 = 0;
                r1.position(r0);
                r0 = new com.facebook.flatbuffers.MutableFlatBuffer;
                r4 = 1;
                r3 = r2;
                r5 = r2;
                r0.<init>(r1, r2, r3, r4, r5);
                r6 = r0.a;
                r1 = r6;
                r1 = com.facebook.flatbuffers.FlatBuffer.a(r1);
                r9.a(r0, r1);
            L_0x0035:
                r0 = r9.w_();
                r1 = r9.u_();
                r7 = 0;
                r10.f();
                r6 = r0.g(r1, r7);
                if (r6 == 0) goto L_0x004f;
            L_0x0047:
                r6 = "__type__";
                r10.a(r6);
                com.facebook.graphql.modelutil.SerializerHelpers.b(r0, r1, r7, r10);
            L_0x004f:
                r6 = 1;
                r6 = r0.g(r1, r6);
                if (r6 == 0) goto L_0x005e;
            L_0x0056:
                r7 = "feedback";
                r10.a(r7);
                com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsParsers.StoryFeedbackParser.m23911a(r0, r6, r10, r11);
            L_0x005e:
                r6 = 2;
                r6 = r0.g(r1, r6);
                if (r6 == 0) goto L_0x006d;
            L_0x0065:
                r7 = "insights";
                r10.a(r7);
                com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsParsers.StoryInsightsParser.m23913a(r0, r6, r10);
            L_0x006d:
                r6 = 3;
                r6 = r0.g(r1, r6);
                if (r6 == 0) goto L_0x007c;
            L_0x0074:
                r7 = "post_promotion_info";
                r10.a(r7);
                com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsParsers.StoryPromotionParser.PostPromotionInfoParser.m23922a(r0, r6, r10, r11);
            L_0x007c:
                r6 = 4;
                r6 = r0.g(r1, r6);
                if (r6 == 0) goto L_0x008b;
            L_0x0083:
                r7 = "promotion_info";
                r10.a(r7);
                com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsParsers.StoryPromotionInfoParser.m23917a(r0, r6, r10, r11);
            L_0x008b:
                r6 = 5;
                r6 = r0.g(r1, r6);
                if (r6 == 0) goto L_0x009a;
            L_0x0092:
                r7 = "shareable";
                r10.a(r7);
                com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsParsers.EventInfoParser.m23850a(r0, r6, r10);
            L_0x009a:
                r10.g();
                return;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.StoryPromotionModel.Serializer.a(java.lang.Object, com.fasterxml.jackson.core.JsonGenerator, com.fasterxml.jackson.databind.SerializerProvider):void");
            }

            static {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r0 = com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.StoryPromotionModel.class;
                r1 = new com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels$StoryPromotionModel$Serializer;
                r1.<init>();
                com.facebook.common.json.FbSerializerProvider.a(r0, r1);
                return;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.StoryPromotionModel.Serializer.<clinit>():void");
            }
        }

        public StoryPromotionModel() {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
            /*
            r1 = this;
            r0 = 6;
            r1.<init>(r0);
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.StoryPromotionModel.<init>():void");
        }

        public StoryPromotionModel(com.facebook.flatbuffers.MutableFlatBuffer r3) {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
            /*
            r2 = this;
            r0 = 6;
            r2.<init>(r0);
            r1 = r3.a;
            r0 = r1;
            r0 = com.facebook.flatbuffers.FlatBuffer.a(r0);
            r2.a(r3, r0);
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.StoryPromotionModel.<init>(com.facebook.flatbuffers.MutableFlatBuffer):void");
        }

        public final void m23709a(java.lang.String r1, com.facebook.graphql.visitor.ConsistencyTuple r2) {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
            /*
            r0 = this;
            r2.a();
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.StoryPromotionModel.a(java.lang.String, com.facebook.graphql.visitor.ConsistencyTuple):void");
        }

        public final void m23710a(java.lang.String r1, java.lang.Object r2, boolean r3) {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
            /*
            r0 = this;
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.StoryPromotionModel.a(java.lang.String, java.lang.Object, boolean):void");
        }

        @javax.annotation.Nullable
        private com.facebook.graphql.enums.GraphQLObjectType m23705n() {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
            /*
            r4 = this;
            r0 = r4.b;
            if (r0 == 0) goto L_0x0017;
        L_0x0004:
            r0 = r4.f22252d;
            if (r0 != 0) goto L_0x0017;
        L_0x0008:
            r0 = r4.b;
            r1 = r4.c;
            r2 = 0;
            r3 = com.facebook.graphql.enums.GraphQLObjectType.class;
            r0 = r0.d(r1, r2, r3);
            r0 = (com.facebook.graphql.enums.GraphQLObjectType) r0;
            r4.f22252d = r0;
        L_0x0017:
            r0 = r4.f22252d;
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.StoryPromotionModel.n():com.facebook.graphql.enums.GraphQLObjectType");
        }

        @javax.annotation.Nullable
        public final com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.StoryFeedbackModel m23707a() {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
            /*
            r3 = this;
            r0 = r3.f22253e;
            r1 = 1;
            r2 = com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.StoryFeedbackModel.class;
            r0 = super.a(r0, r1, r2);
            r0 = (com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.StoryFeedbackModel) r0;
            r3.f22253e = r0;
            r0 = r3.f22253e;
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.StoryPromotionModel.a():com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels$StoryFeedbackModel");
        }

        @javax.annotation.Nullable
        public final com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.StoryInsightsModel m23711j() {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
            /*
            r3 = this;
            r0 = r3.f22254f;
            r1 = 2;
            r2 = com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.StoryInsightsModel.class;
            r0 = super.a(r0, r1, r2);
            r0 = (com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.StoryInsightsModel) r0;
            r3.f22254f = r0;
            r0 = r3.f22254f;
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.StoryPromotionModel.j():com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels$StoryInsightsModel");
        }

        @javax.annotation.Nullable
        public final com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.StoryPromotionModel.PostPromotionInfoModel m23712k() {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
            /*
            r3 = this;
            r0 = r3.f22255g;
            r1 = 3;
            r2 = com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.StoryPromotionModel.PostPromotionInfoModel.class;
            r0 = super.a(r0, r1, r2);
            r0 = (com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.StoryPromotionModel.PostPromotionInfoModel) r0;
            r3.f22255g = r0;
            r0 = r3.f22255g;
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.StoryPromotionModel.k():com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels$StoryPromotionModel$PostPromotionInfoModel");
        }

        @javax.annotation.Nullable
        public final com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.StoryPromotionInfoModel m23713l() {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
            /*
            r3 = this;
            r0 = r3.f22256h;
            r1 = 4;
            r2 = com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.StoryPromotionInfoModel.class;
            r0 = super.a(r0, r1, r2);
            r0 = (com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.StoryPromotionInfoModel) r0;
            r3.f22256h = r0;
            r0 = r3.f22256h;
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.StoryPromotionModel.l():com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels$StoryPromotionInfoModel");
        }

        @javax.annotation.Nullable
        public final com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.EventInfoModel m23714m() {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
            /*
            r3 = this;
            r0 = r3.f22257i;
            r1 = 5;
            r2 = com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.EventInfoModel.class;
            r0 = super.a(r0, r1, r2);
            r0 = (com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.EventInfoModel) r0;
            r3.f22257i = r0;
            r0 = r3.f22257i;
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.StoryPromotionModel.m():com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels$EventInfoModel");
        }

        public final int jK_() {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
            /*
            r1 = this;
            r0 = 80218325; // 0x4c808d5 float:4.7027885E-36 double:3.96331185E-316;
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.StoryPromotionModel.jK_():int");
        }

        public final com.facebook.graphql.visitor.GraphQLVisitableModel m23708a(com.facebook.graphql.visitor.GraphQLModelMutatingVisitor r4) {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
            /*
            r3 = this;
            r1 = 0;
            r3.h();
            r0 = r3.m23707a();
            if (r0 == 0) goto L_0x0022;
        L_0x000a:
            r0 = r3.m23707a();
            r0 = r4.b(r0);
            r0 = (com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.StoryFeedbackModel) r0;
            r2 = r3.m23707a();
            if (r2 == r0) goto L_0x0022;
        L_0x001a:
            r1 = com.facebook.graphql.modelutil.ModelHelper.a(r1, r3);
            r1 = (com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.StoryPromotionModel) r1;
            r1.f22253e = r0;
        L_0x0022:
            r0 = r3.m23711j();
            if (r0 == 0) goto L_0x0040;
        L_0x0028:
            r0 = r3.m23711j();
            r0 = r4.b(r0);
            r0 = (com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.StoryInsightsModel) r0;
            r2 = r3.m23711j();
            if (r2 == r0) goto L_0x0040;
        L_0x0038:
            r1 = com.facebook.graphql.modelutil.ModelHelper.a(r1, r3);
            r1 = (com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.StoryPromotionModel) r1;
            r1.f22254f = r0;
        L_0x0040:
            r0 = r3.m23712k();
            if (r0 == 0) goto L_0x005e;
        L_0x0046:
            r0 = r3.m23712k();
            r0 = r4.b(r0);
            r0 = (com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.StoryPromotionModel.PostPromotionInfoModel) r0;
            r2 = r3.m23712k();
            if (r2 == r0) goto L_0x005e;
        L_0x0056:
            r1 = com.facebook.graphql.modelutil.ModelHelper.a(r1, r3);
            r1 = (com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.StoryPromotionModel) r1;
            r1.f22255g = r0;
        L_0x005e:
            r0 = r3.m23713l();
            if (r0 == 0) goto L_0x007c;
        L_0x0064:
            r0 = r3.m23713l();
            r0 = r4.b(r0);
            r0 = (com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.StoryPromotionInfoModel) r0;
            r2 = r3.m23713l();
            if (r2 == r0) goto L_0x007c;
        L_0x0074:
            r1 = com.facebook.graphql.modelutil.ModelHelper.a(r1, r3);
            r1 = (com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.StoryPromotionModel) r1;
            r1.f22256h = r0;
        L_0x007c:
            r0 = r3.m23714m();
            if (r0 == 0) goto L_0x009a;
        L_0x0082:
            r0 = r3.m23714m();
            r0 = r4.b(r0);
            r0 = (com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.EventInfoModel) r0;
            r2 = r3.m23714m();
            if (r2 == r0) goto L_0x009a;
        L_0x0092:
            r1 = com.facebook.graphql.modelutil.ModelHelper.a(r1, r3);
            r1 = (com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.StoryPromotionModel) r1;
            r1.f22257i = r0;
        L_0x009a:
            r3.i();
            if (r1 != 0) goto L_0x00a0;
        L_0x009f:
            return r3;
        L_0x00a0:
            r3 = r1;
            goto L_0x009f;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.StoryPromotionModel.a(com.facebook.graphql.visitor.GraphQLModelMutatingVisitor):com.facebook.graphql.visitor.GraphQLVisitableModel");
        }

        public final int m23706a(com.facebook.flatbuffers.FlatBufferBuilder r8) {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
            /*
            r7 = this;
            r7.h();
            r0 = r7.m23705n();
            r0 = com.facebook.graphql.modelutil.ModelHelper.a(r8, r0);
            r1 = r7.m23707a();
            r1 = com.facebook.graphql.modelutil.ModelHelper.a(r8, r1);
            r2 = r7.m23711j();
            r2 = com.facebook.graphql.modelutil.ModelHelper.a(r8, r2);
            r3 = r7.m23712k();
            r3 = com.facebook.graphql.modelutil.ModelHelper.a(r8, r3);
            r4 = r7.m23713l();
            r4 = com.facebook.graphql.modelutil.ModelHelper.a(r8, r4);
            r5 = r7.m23714m();
            r5 = com.facebook.graphql.modelutil.ModelHelper.a(r8, r5);
            r6 = 6;
            r8.c(r6);
            r6 = 0;
            r8.b(r6, r0);
            r0 = 1;
            r8.b(r0, r1);
            r0 = 2;
            r8.b(r0, r2);
            r0 = 3;
            r8.b(r0, r3);
            r0 = 4;
            r8.b(r0, r4);
            r0 = 5;
            r8.b(r0, r5);
            r7.i();
            r0 = r8.d();
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.StoryPromotionModel.a(com.facebook.flatbuffers.FlatBufferBuilder):int");
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 515756813)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: ZA */
    public final class TargetSpecificationsModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private List<GraphQLAdsTargetingGender> f22260d;
        @Nullable
        private GeoLocationsModel f22261e;
        @Nullable
        private InterestsModel f22262f;
        private int f22263g;
        private int f22264h;

        /* compiled from: ZA */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(TargetSpecificationsModel.class, new Deserializer());
            }

            public Object m23715a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(TargetSpecificationsParser.m23928a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object targetSpecificationsModel = new TargetSpecificationsModel();
                ((BaseModel) targetSpecificationsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (targetSpecificationsModel instanceof Postprocessable) {
                    return ((Postprocessable) targetSpecificationsModel).a();
                }
                return targetSpecificationsModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 283251305)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: ZA */
        public final class GeoLocationsModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private List<GeoLocationModel> f22258d;

            /* compiled from: ZA */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(GeoLocationsModel.class, new Deserializer());
                }

                public Object m23716a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(GeoLocationsParser.m23924a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object geoLocationsModel = new GeoLocationsModel();
                    ((BaseModel) geoLocationsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (geoLocationsModel instanceof Postprocessable) {
                        return ((Postprocessable) geoLocationsModel).a();
                    }
                    return geoLocationsModel;
                }
            }

            /* compiled from: ZA */
            public class Serializer extends JsonSerializer<GeoLocationsModel> {
                public final void m23717a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    GeoLocationsModel geoLocationsModel = (GeoLocationsModel) obj;
                    if (geoLocationsModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(geoLocationsModel.m23718a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        geoLocationsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    GeoLocationsParser.m23925a(geoLocationsModel.w_(), geoLocationsModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(GeoLocationsModel.class, new Serializer());
                }
            }

            public GeoLocationsModel() {
                super(1);
            }

            @Nonnull
            public final ImmutableList<GeoLocationModel> m23720a() {
                this.f22258d = super.a(this.f22258d, 0, GeoLocationModel.class);
                return (ImmutableList) this.f22258d;
            }

            public final int jK_() {
                return -2136564134;
            }

            public final GraphQLVisitableModel m23719a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m23720a() != null) {
                    Builder a = ModelHelper.a(m23720a(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        graphQLVisitableModel = (GeoLocationsModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f22258d = a.b();
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m23718a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m23720a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, a);
                i();
                return flatBufferBuilder.d();
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -389633985)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: ZA */
        public final class InterestsModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private List<InterestModel> f22259d;

            /* compiled from: ZA */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(InterestsModel.class, new Deserializer());
                }

                public Object m23721a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(InterestsParser.m23926a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object interestsModel = new InterestsModel();
                    ((BaseModel) interestsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (interestsModel instanceof Postprocessable) {
                        return ((Postprocessable) interestsModel).a();
                    }
                    return interestsModel;
                }
            }

            /* compiled from: ZA */
            public class Serializer extends JsonSerializer<InterestsModel> {
                public final void m23722a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    InterestsModel interestsModel = (InterestsModel) obj;
                    if (interestsModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(interestsModel.m23723a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        interestsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    InterestsParser.m23927a(interestsModel.w_(), interestsModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(InterestsModel.class, new Serializer());
                }
            }

            public InterestsModel() {
                super(1);
            }

            @Nonnull
            public final ImmutableList<InterestModel> m23725a() {
                this.f22259d = super.a(this.f22259d, 0, InterestModel.class);
                return (ImmutableList) this.f22259d;
            }

            public final int jK_() {
                return 807553048;
            }

            public final GraphQLVisitableModel m23724a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m23725a() != null) {
                    Builder a = ModelHelper.a(m23725a(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        graphQLVisitableModel = (InterestsModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f22259d = a.b();
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m23723a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m23725a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, a);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: ZA */
        public class Serializer extends JsonSerializer<TargetSpecificationsModel> {
            public final void m23726a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                TargetSpecificationsModel targetSpecificationsModel = (TargetSpecificationsModel) obj;
                if (targetSpecificationsModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(targetSpecificationsModel.m23727a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    targetSpecificationsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                TargetSpecificationsParser.m23929a(targetSpecificationsModel.w_(), targetSpecificationsModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(TargetSpecificationsModel.class, new Serializer());
            }
        }

        public TargetSpecificationsModel() {
            super(5);
        }

        @Nonnull
        public final ImmutableList<GraphQLAdsTargetingGender> m23729a() {
            this.f22260d = super.c(this.f22260d, 0, GraphQLAdsTargetingGender.class);
            return (ImmutableList) this.f22260d;
        }

        @Nullable
        public final GeoLocationsModel m23731j() {
            this.f22261e = (GeoLocationsModel) super.a(this.f22261e, 1, GeoLocationsModel.class);
            return this.f22261e;
        }

        @Nullable
        public final InterestsModel m23732k() {
            this.f22262f = (InterestsModel) super.a(this.f22262f, 2, InterestsModel.class);
            return this.f22262f;
        }

        public final int m23733l() {
            a(0, 3);
            return this.f22263g;
        }

        public final int m23734m() {
            a(0, 4);
            return this.f22264h;
        }

        public final int jK_() {
            return -1674859089;
        }

        public final GraphQLVisitableModel m23728a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m23731j() != null) {
                GeoLocationsModel geoLocationsModel = (GeoLocationsModel) graphQLModelMutatingVisitor.b(m23731j());
                if (m23731j() != geoLocationsModel) {
                    graphQLVisitableModel = (TargetSpecificationsModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f22261e = geoLocationsModel;
                }
            }
            if (m23732k() != null) {
                InterestsModel interestsModel = (InterestsModel) graphQLModelMutatingVisitor.b(m23732k());
                if (m23732k() != interestsModel) {
                    graphQLVisitableModel = (TargetSpecificationsModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f22262f = interestsModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m23727a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int d = flatBufferBuilder.d(m23729a());
            int a = ModelHelper.a(flatBufferBuilder, m23731j());
            int a2 = ModelHelper.a(flatBufferBuilder, m23732k());
            flatBufferBuilder.c(5);
            flatBufferBuilder.b(0, d);
            flatBufferBuilder.b(1, a);
            flatBufferBuilder.b(2, a2);
            flatBufferBuilder.a(3, this.f22263g, 0);
            flatBufferBuilder.a(4, this.f22264h, 0);
            i();
            return flatBufferBuilder.d();
        }

        public final void m23730a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
            super.a(mutableFlatBuffer, i, obj);
            this.f22263g = mutableFlatBuffer.a(i, 3, 0);
            this.f22264h = mutableFlatBuffer.a(i, 4, 0);
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -1111420467)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: ZA */
    public final class TargetingDescriptionModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private String f22267d;
        @Nullable
        private TargetingDescriptorsModel f22268e;

        /* compiled from: ZA */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(TargetingDescriptionModel.class, new Deserializer());
            }

            public Object m23735a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(AdInterfacesQueryFragmentsParsers.TargetingDescriptionParser.m23936b(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object targetingDescriptionModel = new TargetingDescriptionModel();
                ((BaseModel) targetingDescriptionModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (targetingDescriptionModel instanceof Postprocessable) {
                    return ((Postprocessable) targetingDescriptionModel).a();
                }
                return targetingDescriptionModel;
            }
        }

        /* compiled from: ZA */
        public class Serializer extends JsonSerializer<TargetingDescriptionModel> {
            public final void m23736a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                TargetingDescriptionModel targetingDescriptionModel = (TargetingDescriptionModel) obj;
                if (targetingDescriptionModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(targetingDescriptionModel.m23747a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    targetingDescriptionModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                AdInterfacesQueryFragmentsParsers.TargetingDescriptionParser.m23937b(targetingDescriptionModel.w_(), targetingDescriptionModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(TargetingDescriptionModel.class, new Serializer());
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -588346058)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: ZA */
        public final class TargetingDescriptorsModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private List<NodesModel> f22266d;

            /* compiled from: ZA */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(TargetingDescriptorsModel.class, new Deserializer());
                }

                public Object m23737a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(TargetingDescriptorsParser.m23932a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object targetingDescriptorsModel = new TargetingDescriptorsModel();
                    ((BaseModel) targetingDescriptorsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (targetingDescriptorsModel instanceof Postprocessable) {
                        return ((Postprocessable) targetingDescriptorsModel).a();
                    }
                    return targetingDescriptorsModel;
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = -1352864475)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: ZA */
            public final class NodesModel extends BaseModel implements GraphQLVisitableModel {
                @Nullable
                private String f22265d;

                /* compiled from: ZA */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(NodesModel.class, new Deserializer());
                    }

                    public Object m23738a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(TargetingDescriptorsParser.NodesParser.m23931b(jsonParser, flatBufferBuilder));
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

                /* compiled from: ZA */
                public class Serializer extends JsonSerializer<NodesModel> {
                    public final void m23739a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        NodesModel nodesModel = (NodesModel) obj;
                        if (nodesModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(nodesModel.m23740a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            nodesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        TargetingDescriptorsParser.NodesParser.m23930a(nodesModel.w_(), nodesModel.u_(), jsonGenerator);
                    }

                    static {
                        FbSerializerProvider.a(NodesModel.class, new Serializer());
                    }
                }

                public NodesModel() {
                    super(1);
                }

                @Nullable
                public final String m23742a() {
                    this.f22265d = super.a(this.f22265d, 0);
                    return this.f22265d;
                }

                public final int jK_() {
                    return -1199790546;
                }

                public final GraphQLVisitableModel m23741a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    h();
                    i();
                    return this;
                }

                public final int m23740a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int b = flatBufferBuilder.b(m23742a());
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.b(0, b);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            /* compiled from: ZA */
            public class Serializer extends JsonSerializer<TargetingDescriptorsModel> {
                public final void m23743a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    TargetingDescriptorsModel targetingDescriptorsModel = (TargetingDescriptorsModel) obj;
                    if (targetingDescriptorsModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(targetingDescriptorsModel.m23744a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        targetingDescriptorsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    TargetingDescriptorsParser.m23933a(targetingDescriptorsModel.w_(), targetingDescriptorsModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(TargetingDescriptorsModel.class, new Serializer());
                }
            }

            public TargetingDescriptorsModel() {
                super(1);
            }

            @Nonnull
            public final ImmutableList<NodesModel> m23746a() {
                this.f22266d = super.a(this.f22266d, 0, NodesModel.class);
                return (ImmutableList) this.f22266d;
            }

            public final int jK_() {
                return -1558995028;
            }

            public final GraphQLVisitableModel m23745a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m23746a() != null) {
                    Builder a = ModelHelper.a(m23746a(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        graphQLVisitableModel = (TargetingDescriptorsModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f22266d = a.b();
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m23744a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m23746a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, a);
                i();
                return flatBufferBuilder.d();
            }
        }

        public TargetingDescriptionModel() {
            super(2);
        }

        @Nullable
        public final String m23749a() {
            this.f22267d = super.a(this.f22267d, 0);
            return this.f22267d;
        }

        @Nullable
        public final TargetingDescriptorsModel m23750j() {
            this.f22268e = (TargetingDescriptorsModel) super.a(this.f22268e, 1, TargetingDescriptorsModel.class);
            return this.f22268e;
        }

        public final int jK_() {
            return -682735957;
        }

        public final GraphQLVisitableModel m23748a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m23750j() != null) {
                TargetingDescriptorsModel targetingDescriptorsModel = (TargetingDescriptorsModel) graphQLModelMutatingVisitor.b(m23750j());
                if (m23750j() != targetingDescriptorsModel) {
                    graphQLVisitableModel = (TargetingDescriptionModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f22268e = targetingDescriptorsModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m23747a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(m23749a());
            int a = ModelHelper.a(flatBufferBuilder, m23750j());
            flatBufferBuilder.c(2);
            flatBufferBuilder.b(0, b);
            flatBufferBuilder.b(1, a);
            i();
            return flatBufferBuilder.d();
        }
    }
}
