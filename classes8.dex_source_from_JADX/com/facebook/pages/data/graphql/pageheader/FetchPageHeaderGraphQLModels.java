package com.facebook.pages.data.graphql.pageheader;

import com.facebook.api.graphql.saved.SaveDefaultsGraphQLModels.SavableTimelineAppCollectionExtraFieldsModel;
import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbSerializerProvider;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.entitycards.contextitems.graphql.ContextItemsQueryModels.ContextItemsConnectionWithPageInfoFragmentModel;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.FragmentModelWithoutBridge;
import com.facebook.flatbuffers.ModelWithFlatBufferFormatHash;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.enums.GraphQLAttributionSource;
import com.facebook.graphql.enums.GraphQLObjectType;
import com.facebook.graphql.enums.GraphQLPageCallToActionType;
import com.facebook.graphql.enums.GraphQLPageOpenHoursDisplayDecisionEnum;
import com.facebook.graphql.enums.GraphQLPagePresenceTabContentType;
import com.facebook.graphql.enums.GraphQLPagePresenceTabType;
import com.facebook.graphql.enums.GraphQLPageSuperCategoryType;
import com.facebook.graphql.enums.GraphQLPageVerificationBadge;
import com.facebook.graphql.enums.GraphQLPlaceType;
import com.facebook.graphql.enums.GraphQLSavedState;
import com.facebook.graphql.enums.GraphQLSecondarySubscribeStatus;
import com.facebook.graphql.enums.GraphQLSubscribeStatus;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.querybuilder.common.CommonGraphQL2Interfaces.DefaultVect2Fields;
import com.facebook.graphql.querybuilder.common.CommonGraphQL2Models.DefaultVect2FieldsModel;
import com.facebook.graphql.querybuilder.common.CommonGraphQLInterfaces.DefaultImageFields;
import com.facebook.graphql.querybuilder.common.CommonGraphQLModels.DefaultImageFieldsModel;
import com.facebook.graphql.querybuilder.common.CommonGraphQLModels.DefaultLocationFieldsModel;
import com.facebook.graphql.visitor.ConsistencyTuple;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLPersistableNode;
import com.facebook.graphql.visitor.GraphQLVisitableConsistentModel;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.facebook.pages.common.surface.calltoaction.graphql.PageAdminCallToActionGraphQLModels.CallToActionConfigFieldsModel;
import com.facebook.pages.common.surface.calltoaction.graphql.PageAdminCallToActionGraphQLModels.PhoneNumberCommonFieldsModel;
import com.facebook.pages.data.graphql.pageheader.FetchPageHeaderGraphQLInterfaces.PageCallToActionData;
import com.facebook.pages.data.graphql.pageheader.FetchPageHeaderGraphQLParsers.FetchPageHeaderQueryParser;
import com.facebook.pages.data.graphql.pageheader.FetchPageHeaderGraphQLParsers.PageActionBarDataParser;
import com.facebook.pages.data.graphql.pageheader.FetchPageHeaderGraphQLParsers.PageActionBarDataParser.NuxStateParser;
import com.facebook.pages.data.graphql.pageheader.FetchPageHeaderGraphQLParsers.PageAdminInfoBaseDataParser;
import com.facebook.pages.data.graphql.pageheader.FetchPageHeaderGraphQLParsers.PageAdminPostsByOthersDataParser;
import com.facebook.pages.data.graphql.pageheader.FetchPageHeaderGraphQLParsers.PageAdminPostsByOthersDataParser.AdminDisplayPreferenceParser;
import com.facebook.pages.data.graphql.pageheader.FetchPageHeaderGraphQLParsers.PageAdminPostsByOthersDataParser.RecentPostersParser;
import com.facebook.pages.data.graphql.pageheader.FetchPageHeaderGraphQLParsers.PageAdminSocialContextDataParser;
import com.facebook.pages.data.graphql.pageheader.FetchPageHeaderGraphQLParsers.PageAdminSocialContextDataParser.PageLikersParser;
import com.facebook.pages.data.graphql.pageheader.FetchPageHeaderGraphQLParsers.PageGeneralDataParser;
import com.facebook.pages.data.graphql.pageheader.FetchPageHeaderGraphQLParsers.PageGeneralDataParser.AttributionParser;
import com.facebook.pages.data.graphql.pageheader.FetchPageHeaderGraphQLParsers.PageGeneralDataParser.RedirectionInfoParser;
import com.facebook.pages.data.graphql.pageheader.FetchPageHeaderGraphQLParsers.PageGeneralDataParser.RedirectionInfoParser.NodeParser;
import com.facebook.pages.data.graphql.pageheader.FetchPageHeaderGraphQLParsers.PageHeaderDataProfilePhotoParser;
import com.facebook.pages.data.graphql.pageheader.FetchPageHeaderGraphQLParsers.PageHeaderDataProfilePhotoParser.AlbumParser;
import com.facebook.pages.data.graphql.pageheader.FetchPageHeaderGraphQLParsers.PageHeaderMetaboxDataParser;
import com.facebook.pages.data.graphql.pageheader.FetchPageHeaderGraphQLParsers.PageHeaderMetaboxDataParser.AddressParser;
import com.facebook.pages.data.graphql.pageheader.FetchPageHeaderGraphQLParsers.PageHeaderMetaboxDataParser.PlaceOpenStatusParser;
import com.facebook.pages.data.graphql.pageheader.FetchPageHeaderGraphQLParsers.PageHeaderTabDataParser;
import com.facebook.pages.data.graphql.pageheader.FetchPageHeaderGraphQLParsers.PageHeaderTabDataParser.TabsParser;
import com.facebook.pages.data.graphql.pageheader.FetchPageHeaderGraphQLParsers.PageHeaderTabDataParser.TabsParser.TitleParser;
import com.facebook.pages.data.graphql.pageheader.FetchPageHeaderGraphQLParsers.PageHeaderTabDataParser.VideoCollectionParser;
import com.facebook.pages.data.graphql.pageheader.FetchPageHeaderGraphQLParsers.PageHeaderTabDataParser.VideoCollectionParser.VideoListsParser;
import com.facebook.pages.data.graphql.pageheader.FetchPageHeaderGraphQLParsers.PageProfileCoverPhotosDataParser;
import com.facebook.pages.data.graphql.pageheader.FetchPageHeaderGraphQLParsers.PageProfileCoverPhotosDataParser.CoverPhotoParser;
import com.facebook.pages.data.graphql.pageheader.FetchPageHeaderGraphQLParsers.PageProfileCoverPhotosDataParser.CoverPhotoParser.FocusParser;
import com.facebook.pages.data.graphql.pageheader.FetchPageHeaderGraphQLParsers.PageProfileCoverPhotosDataParser.CoverPhotoParser.PhotoParser;
import com.facebook.pages.data.graphql.pageheader.FetchPageHeaderGraphQLParsers.PageProfileCoverPhotosDataParser.ProfilePictureAsCoverParser;
import com.facebook.pages.data.graphql.pageheader.FetchPageHeaderGraphQLParsers.PageRatingDataParser;
import com.facebook.pages.data.graphql.pageheader.FetchPageHeaderGraphQLParsers.PageRatingDataParser.OverallStarRatingParser;
import com.facebook.pages.data.graphql.pageheader.FetchPageHeaderGraphQLParsers.PageSectionsCanAddDataParser;
import com.facebook.pages.data.graphql.pageheader.FetchPageHeaderGraphQLParsers.PageSectionsCanAddDataParser.SectionsCanAddParser;
import com.facebook.pages.data.graphql.pageheader.FetchPageHeaderGraphQLParsers.PageSectionsCanAddDataParser.SectionsCanAddParser.SubtitleParser;
import com.facebook.photos.data.protocol.PhotosDefaultsGraphQLInterfaces.SizeAwareMedia;
import com.facebook.timeline.profilevideo.playback.protocol.FetchProfileVideoGraphQLModels.ProfileHeaderAssociatedVideoModel;
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

/* compiled from: confirmation_change_contactpoint_failure */
public class FetchPageHeaderGraphQLModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -1778213421)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: confirmation_change_contactpoint_failure */
    public final class FetchPageHeaderQueryModel extends BaseModel implements GraphQLVisitableConsistentModel, PageCallToActionData {
        @Nullable
        private OverallStarRatingModel f17130A;
        @Nullable
        private PageCallToActionModel f17131B;
        @Nullable
        private PageLikersModel f17132C;
        @Nullable
        private PlaceOpenStatusModel f17133D;
        @Nullable
        private GraphQLPageOpenHoursDisplayDecisionEnum f17134E;
        @Nullable
        private GraphQLPlaceType f17135F;
        @Nullable
        private ProfilePictureAsCoverModel f17136G;
        @Nullable
        private PageHeaderDataProfilePhotoModel f17137H;
        @Nullable
        private DefaultImageFieldsModel f17138I;
        private boolean f17139J;
        @Nullable
        private ProfileHeaderAssociatedVideoModel f17140K;
        @Nullable
        private RecentPostersModel f17141L;
        @Nullable
        private List<RedirectionInfoModel> f17142M;
        @Nullable
        private SavableTimelineAppCollectionExtraFieldsModel f17143N;
        @Nullable
        private GraphQLSecondarySubscribeStatus f17144O;
        @Nullable
        private List<SectionsCanAddModel> f17145P;
        private boolean f17146Q;
        private boolean f17147R;
        private boolean f17148S;
        @Nullable
        private GraphQLSubscribeStatus f17149T;
        @Nullable
        private GraphQLPageSuperCategoryType f17150U;
        @Nullable
        private List<TabsModel> f17151V;
        @Nullable
        private String f17152W;
        @Nullable
        private String f17153X;
        @Nullable
        private GraphQLPageVerificationBadge f17154Y;
        @Nullable
        private VideoCollectionModel f17155Z;
        @Nullable
        private List<String> aa;
        @Nullable
        private GraphQLSavedState ab;
        @Nullable
        private GraphQLObjectType f17156d;
        @Nullable
        private AddressModel f17157e;
        @Nullable
        private AdminDisplayPreferenceModel f17158f;
        @Nullable
        private PageAdminInfoBaseDataModel f17159g;
        @Nullable
        private List<AttributionModel> f17160h;
        private boolean f17161i;
        private boolean f17162j;
        private boolean f17163k;
        private boolean f17164l;
        private boolean f17165m;
        @Nullable
        private List<String> f17166n;
        @Nullable
        private ContextItemsConnectionWithPageInfoFragmentModel f17167o;
        @Nullable
        private CoverPhotoModel f17168p;
        private boolean f17169q;
        private boolean f17170r;
        private boolean f17171s;
        private boolean f17172t;
        private boolean f17173u;
        private boolean f17174v;
        @Nullable
        private DefaultLocationFieldsModel f17175w;
        @Nullable
        private String f17176x;
        @Nullable
        private String f17177y;
        @Nullable
        private NuxStateModel f17178z;

        /* compiled from: confirmation_change_contactpoint_failure */
        public final class Builder {
            @Nullable
            public PlaceOpenStatusModel f17079A;
            @Nullable
            public GraphQLPageOpenHoursDisplayDecisionEnum f17080B;
            @Nullable
            public GraphQLPlaceType f17081C;
            @Nullable
            public ProfilePictureAsCoverModel f17082D;
            @Nullable
            public PageHeaderDataProfilePhotoModel f17083E;
            @Nullable
            public DefaultImageFieldsModel f17084F;
            public boolean f17085G;
            @Nullable
            public ProfileHeaderAssociatedVideoModel f17086H;
            @Nullable
            public RecentPostersModel f17087I;
            @Nullable
            public ImmutableList<RedirectionInfoModel> f17088J;
            @Nullable
            public SavableTimelineAppCollectionExtraFieldsModel f17089K;
            @Nullable
            public GraphQLSecondarySubscribeStatus f17090L;
            @Nullable
            public ImmutableList<SectionsCanAddModel> f17091M;
            public boolean f17092N;
            public boolean f17093O;
            public boolean f17094P;
            @Nullable
            public GraphQLSubscribeStatus f17095Q;
            @Nullable
            public GraphQLPageSuperCategoryType f17096R;
            @Nullable
            public ImmutableList<TabsModel> f17097S;
            @Nullable
            public String f17098T;
            @Nullable
            public String f17099U;
            @Nullable
            public GraphQLPageVerificationBadge f17100V;
            @Nullable
            public VideoCollectionModel f17101W;
            @Nullable
            public ImmutableList<String> f17102X;
            @Nullable
            public GraphQLSavedState f17103Y;
            @Nullable
            public GraphQLObjectType f17104a;
            @Nullable
            public AddressModel f17105b;
            @Nullable
            public AdminDisplayPreferenceModel f17106c;
            @Nullable
            public PageAdminInfoBaseDataModel f17107d;
            @Nullable
            public ImmutableList<AttributionModel> f17108e;
            public boolean f17109f;
            public boolean f17110g;
            public boolean f17111h;
            public boolean f17112i;
            public boolean f17113j;
            @Nullable
            public ImmutableList<String> f17114k;
            @Nullable
            public ContextItemsConnectionWithPageInfoFragmentModel f17115l;
            @Nullable
            public CoverPhotoModel f17116m;
            public boolean f17117n;
            public boolean f17118o;
            public boolean f17119p;
            public boolean f17120q;
            public boolean f17121r;
            public boolean f17122s;
            @Nullable
            public DefaultLocationFieldsModel f17123t;
            @Nullable
            public String f17124u;
            @Nullable
            public String f17125v;
            @Nullable
            public NuxStateModel f17126w;
            @Nullable
            public OverallStarRatingModel f17127x;
            @Nullable
            public PageCallToActionModel f17128y;
            @Nullable
            public PageLikersModel f17129z;

            public static Builder m20872a(FetchPageHeaderQueryModel fetchPageHeaderQueryModel) {
                Builder builder = new Builder();
                builder.f17104a = fetchPageHeaderQueryModel.m20905a();
                builder.f17105b = fetchPageHeaderQueryModel.m20910j();
                builder.f17106c = fetchPageHeaderQueryModel.m20911k();
                builder.f17107d = fetchPageHeaderQueryModel.m20912l();
                builder.f17108e = fetchPageHeaderQueryModel.m20913m();
                builder.f17109f = fetchPageHeaderQueryModel.m20914n();
                builder.f17110g = fetchPageHeaderQueryModel.m20915o();
                builder.f17111h = fetchPageHeaderQueryModel.m20916p();
                builder.f17112i = fetchPageHeaderQueryModel.m20917q();
                builder.f17113j = fetchPageHeaderQueryModel.m20918r();
                builder.f17114k = fetchPageHeaderQueryModel.m20919s();
                builder.f17115l = fetchPageHeaderQueryModel.m20920t();
                builder.f17116m = fetchPageHeaderQueryModel.m20921u();
                builder.f17117n = fetchPageHeaderQueryModel.m20922v();
                builder.f17118o = fetchPageHeaderQueryModel.m20923w();
                builder.f17119p = fetchPageHeaderQueryModel.m20924x();
                builder.f17120q = fetchPageHeaderQueryModel.m20925y();
                builder.f17121r = fetchPageHeaderQueryModel.m20926z();
                builder.f17122s = fetchPageHeaderQueryModel.m20878A();
                builder.f17123t = fetchPageHeaderQueryModel.m20879B();
                builder.f17124u = fetchPageHeaderQueryModel.m20880C();
                builder.f17125v = fetchPageHeaderQueryModel.m20881D();
                builder.f17126w = fetchPageHeaderQueryModel.m20882E();
                builder.f17127x = fetchPageHeaderQueryModel.m20883F();
                builder.f17128y = fetchPageHeaderQueryModel.m20884G();
                builder.f17129z = fetchPageHeaderQueryModel.m20885H();
                builder.f17079A = fetchPageHeaderQueryModel.m20886I();
                builder.f17080B = fetchPageHeaderQueryModel.m20887J();
                builder.f17081C = fetchPageHeaderQueryModel.m20888K();
                builder.f17082D = fetchPageHeaderQueryModel.m20889L();
                builder.f17083E = fetchPageHeaderQueryModel.m20890M();
                builder.f17084F = fetchPageHeaderQueryModel.m20891N();
                builder.f17085G = fetchPageHeaderQueryModel.m20892O();
                builder.f17086H = fetchPageHeaderQueryModel.m20893P();
                builder.f17087I = fetchPageHeaderQueryModel.m20894Q();
                builder.f17088J = fetchPageHeaderQueryModel.m20895R();
                builder.f17089K = fetchPageHeaderQueryModel.m20896S();
                builder.f17090L = fetchPageHeaderQueryModel.m20897T();
                builder.f17091M = fetchPageHeaderQueryModel.m20898U();
                builder.f17092N = fetchPageHeaderQueryModel.m20899V();
                builder.f17093O = fetchPageHeaderQueryModel.m20900W();
                builder.f17094P = fetchPageHeaderQueryModel.m20901X();
                builder.f17095Q = fetchPageHeaderQueryModel.m20902Y();
                builder.f17096R = fetchPageHeaderQueryModel.m20903Z();
                builder.f17097S = fetchPageHeaderQueryModel.aa();
                builder.f17098T = fetchPageHeaderQueryModel.ab();
                builder.f17099U = fetchPageHeaderQueryModel.ac();
                builder.f17100V = fetchPageHeaderQueryModel.ad();
                builder.f17101W = fetchPageHeaderQueryModel.ae();
                builder.f17102X = fetchPageHeaderQueryModel.af();
                builder.f17103Y = fetchPageHeaderQueryModel.ag();
                return builder;
            }

            public final FetchPageHeaderQueryModel m20873a() {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                int a = ModelHelper.a(flatBufferBuilder, this.f17104a);
                int a2 = ModelHelper.a(flatBufferBuilder, this.f17105b);
                int a3 = ModelHelper.a(flatBufferBuilder, this.f17106c);
                int a4 = ModelHelper.a(flatBufferBuilder, this.f17107d);
                int a5 = ModelHelper.a(flatBufferBuilder, this.f17108e);
                int c = flatBufferBuilder.c(this.f17114k);
                int a6 = ModelHelper.a(flatBufferBuilder, this.f17115l);
                int a7 = ModelHelper.a(flatBufferBuilder, this.f17116m);
                int a8 = ModelHelper.a(flatBufferBuilder, this.f17123t);
                int b = flatBufferBuilder.b(this.f17124u);
                int b2 = flatBufferBuilder.b(this.f17125v);
                int a9 = ModelHelper.a(flatBufferBuilder, this.f17126w);
                int a10 = ModelHelper.a(flatBufferBuilder, this.f17127x);
                int a11 = ModelHelper.a(flatBufferBuilder, this.f17128y);
                int a12 = ModelHelper.a(flatBufferBuilder, this.f17129z);
                int a13 = ModelHelper.a(flatBufferBuilder, this.f17079A);
                int a14 = flatBufferBuilder.a(this.f17080B);
                int a15 = flatBufferBuilder.a(this.f17081C);
                int a16 = ModelHelper.a(flatBufferBuilder, this.f17082D);
                int a17 = ModelHelper.a(flatBufferBuilder, this.f17083E);
                int a18 = ModelHelper.a(flatBufferBuilder, this.f17084F);
                int a19 = ModelHelper.a(flatBufferBuilder, this.f17086H);
                int a20 = ModelHelper.a(flatBufferBuilder, this.f17087I);
                int a21 = ModelHelper.a(flatBufferBuilder, this.f17088J);
                int a22 = ModelHelper.a(flatBufferBuilder, this.f17089K);
                int a23 = flatBufferBuilder.a(this.f17090L);
                int a24 = ModelHelper.a(flatBufferBuilder, this.f17091M);
                int a25 = flatBufferBuilder.a(this.f17095Q);
                int a26 = flatBufferBuilder.a(this.f17096R);
                int a27 = ModelHelper.a(flatBufferBuilder, this.f17097S);
                int b3 = flatBufferBuilder.b(this.f17098T);
                int b4 = flatBufferBuilder.b(this.f17099U);
                int a28 = flatBufferBuilder.a(this.f17100V);
                int a29 = ModelHelper.a(flatBufferBuilder, this.f17101W);
                int c2 = flatBufferBuilder.c(this.f17102X);
                int a30 = flatBufferBuilder.a(this.f17103Y);
                flatBufferBuilder.c(51);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.b(1, a2);
                flatBufferBuilder.b(2, a3);
                flatBufferBuilder.b(3, a4);
                flatBufferBuilder.b(4, a5);
                flatBufferBuilder.a(5, this.f17109f);
                flatBufferBuilder.a(6, this.f17110g);
                flatBufferBuilder.a(7, this.f17111h);
                flatBufferBuilder.a(8, this.f17112i);
                flatBufferBuilder.a(9, this.f17113j);
                flatBufferBuilder.b(10, c);
                flatBufferBuilder.b(11, a6);
                flatBufferBuilder.b(12, a7);
                flatBufferBuilder.a(13, this.f17117n);
                flatBufferBuilder.a(14, this.f17118o);
                flatBufferBuilder.a(15, this.f17119p);
                flatBufferBuilder.a(16, this.f17120q);
                flatBufferBuilder.a(17, this.f17121r);
                flatBufferBuilder.a(18, this.f17122s);
                flatBufferBuilder.b(19, a8);
                flatBufferBuilder.b(20, b);
                flatBufferBuilder.b(21, b2);
                flatBufferBuilder.b(22, a9);
                flatBufferBuilder.b(23, a10);
                flatBufferBuilder.b(24, a11);
                flatBufferBuilder.b(25, a12);
                flatBufferBuilder.b(26, a13);
                flatBufferBuilder.b(27, a14);
                flatBufferBuilder.b(28, a15);
                flatBufferBuilder.b(29, a16);
                flatBufferBuilder.b(30, a17);
                flatBufferBuilder.b(31, a18);
                flatBufferBuilder.a(32, this.f17085G);
                flatBufferBuilder.b(33, a19);
                flatBufferBuilder.b(34, a20);
                flatBufferBuilder.b(35, a21);
                flatBufferBuilder.b(36, a22);
                flatBufferBuilder.b(37, a23);
                flatBufferBuilder.b(38, a24);
                flatBufferBuilder.a(39, this.f17092N);
                flatBufferBuilder.a(40, this.f17093O);
                flatBufferBuilder.a(41, this.f17094P);
                flatBufferBuilder.b(42, a25);
                flatBufferBuilder.b(43, a26);
                flatBufferBuilder.b(44, a27);
                flatBufferBuilder.b(45, b3);
                flatBufferBuilder.b(46, b4);
                flatBufferBuilder.b(47, a28);
                flatBufferBuilder.b(48, a29);
                flatBufferBuilder.b(49, c2);
                flatBufferBuilder.b(50, a30);
                flatBufferBuilder.d(flatBufferBuilder.d());
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                return new FetchPageHeaderQueryModel(new MutableFlatBuffer(wrap, null, null, true, null));
            }
        }

        /* compiled from: confirmation_change_contactpoint_failure */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(FetchPageHeaderQueryModel.class, new Deserializer());
            }

            public Object m20874a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(FetchPageHeaderQueryParser.m21229a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object fetchPageHeaderQueryModel = new FetchPageHeaderQueryModel();
                ((BaseModel) fetchPageHeaderQueryModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (fetchPageHeaderQueryModel instanceof Postprocessable) {
                    return ((Postprocessable) fetchPageHeaderQueryModel).a();
                }
                return fetchPageHeaderQueryModel;
            }
        }

        /* compiled from: confirmation_change_contactpoint_failure */
        public class Serializer extends JsonSerializer<FetchPageHeaderQueryModel> {
            public final void m20875a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                FetchPageHeaderQueryModel fetchPageHeaderQueryModel = (FetchPageHeaderQueryModel) obj;
                if (fetchPageHeaderQueryModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(fetchPageHeaderQueryModel.m20904a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    fetchPageHeaderQueryModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                FetchPageHeaderQueryParser.m21230a(fetchPageHeaderQueryModel.w_(), fetchPageHeaderQueryModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(FetchPageHeaderQueryModel.class, new Serializer());
            }
        }

        public FetchPageHeaderQueryModel() {
            super(51);
        }

        public FetchPageHeaderQueryModel(MutableFlatBuffer mutableFlatBuffer) {
            super(51);
            a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
        }

        public final void m20908a(String str, ConsistencyTuple consistencyTuple) {
            if ("subscribe_status".equals(str)) {
                consistencyTuple.a = m20902Y();
                consistencyTuple.b = u_();
                consistencyTuple.c = 42;
            } else if ("viewer_saved_state".equals(str)) {
                consistencyTuple.a = ag();
                consistencyTuple.b = u_();
                consistencyTuple.c = 50;
            } else {
                consistencyTuple.a();
            }
        }

        public final void m20909a(String str, Object obj, boolean z) {
            if ("subscribe_status".equals(str)) {
                m20877a((GraphQLSubscribeStatus) obj);
            } else if ("viewer_saved_state".equals(str)) {
                m20876a((GraphQLSavedState) obj);
            }
        }

        @Nullable
        public final GraphQLObjectType m20905a() {
            if (this.b != null && this.f17156d == null) {
                this.f17156d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
            }
            return this.f17156d;
        }

        @Nullable
        public final AddressModel m20910j() {
            this.f17157e = (AddressModel) super.a(this.f17157e, 1, AddressModel.class);
            return this.f17157e;
        }

        @Nullable
        public final AdminDisplayPreferenceModel m20911k() {
            this.f17158f = (AdminDisplayPreferenceModel) super.a(this.f17158f, 2, AdminDisplayPreferenceModel.class);
            return this.f17158f;
        }

        @Nullable
        public final PageAdminInfoBaseDataModel m20912l() {
            this.f17159g = (PageAdminInfoBaseDataModel) super.a(this.f17159g, 3, PageAdminInfoBaseDataModel.class);
            return this.f17159g;
        }

        @Nonnull
        public final ImmutableList<AttributionModel> m20913m() {
            this.f17160h = super.a(this.f17160h, 4, AttributionModel.class);
            return (ImmutableList) this.f17160h;
        }

        public final boolean m20914n() {
            a(0, 5);
            return this.f17161i;
        }

        public final boolean m20915o() {
            a(0, 6);
            return this.f17162j;
        }

        public final boolean m20916p() {
            a(0, 7);
            return this.f17163k;
        }

        public final boolean m20917q() {
            a(1, 0);
            return this.f17164l;
        }

        public final boolean m20918r() {
            a(1, 1);
            return this.f17165m;
        }

        @Nonnull
        public final ImmutableList<String> m20919s() {
            this.f17166n = super.a(this.f17166n, 10);
            return (ImmutableList) this.f17166n;
        }

        @Nullable
        public final ContextItemsConnectionWithPageInfoFragmentModel m20920t() {
            this.f17167o = (ContextItemsConnectionWithPageInfoFragmentModel) super.a(this.f17167o, 11, ContextItemsConnectionWithPageInfoFragmentModel.class);
            return this.f17167o;
        }

        @Nullable
        public final CoverPhotoModel m20921u() {
            this.f17168p = (CoverPhotoModel) super.a(this.f17168p, 12, CoverPhotoModel.class);
            return this.f17168p;
        }

        public final boolean m20922v() {
            a(1, 5);
            return this.f17169q;
        }

        public final boolean m20923w() {
            a(1, 6);
            return this.f17170r;
        }

        public final boolean m20924x() {
            a(1, 7);
            return this.f17171s;
        }

        public final boolean m20925y() {
            a(2, 0);
            return this.f17172t;
        }

        public final boolean m20926z() {
            a(2, 1);
            return this.f17173u;
        }

        public final boolean m20878A() {
            a(2, 2);
            return this.f17174v;
        }

        @Nullable
        public final DefaultLocationFieldsModel m20879B() {
            this.f17175w = (DefaultLocationFieldsModel) super.a(this.f17175w, 19, DefaultLocationFieldsModel.class);
            return this.f17175w;
        }

        @Nullable
        public final String m20880C() {
            this.f17176x = super.a(this.f17176x, 20);
            return this.f17176x;
        }

        @Nullable
        public final String m20881D() {
            this.f17177y = super.a(this.f17177y, 21);
            return this.f17177y;
        }

        @Nullable
        public final NuxStateModel m20882E() {
            this.f17178z = (NuxStateModel) super.a(this.f17178z, 22, NuxStateModel.class);
            return this.f17178z;
        }

        @Nullable
        public final OverallStarRatingModel m20883F() {
            this.f17130A = (OverallStarRatingModel) super.a(this.f17130A, 23, OverallStarRatingModel.class);
            return this.f17130A;
        }

        @Nullable
        public final PageCallToActionModel m20884G() {
            this.f17131B = (PageCallToActionModel) super.a(this.f17131B, 24, PageCallToActionModel.class);
            return this.f17131B;
        }

        @Nullable
        public final PageLikersModel m20885H() {
            this.f17132C = (PageLikersModel) super.a(this.f17132C, 25, PageLikersModel.class);
            return this.f17132C;
        }

        @Nullable
        public final PlaceOpenStatusModel m20886I() {
            this.f17133D = (PlaceOpenStatusModel) super.a(this.f17133D, 26, PlaceOpenStatusModel.class);
            return this.f17133D;
        }

        @Nullable
        public final GraphQLPageOpenHoursDisplayDecisionEnum m20887J() {
            this.f17134E = (GraphQLPageOpenHoursDisplayDecisionEnum) super.b(this.f17134E, 27, GraphQLPageOpenHoursDisplayDecisionEnum.class, GraphQLPageOpenHoursDisplayDecisionEnum.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
            return this.f17134E;
        }

        @Nullable
        public final GraphQLPlaceType m20888K() {
            this.f17135F = (GraphQLPlaceType) super.b(this.f17135F, 28, GraphQLPlaceType.class, GraphQLPlaceType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
            return this.f17135F;
        }

        @Nullable
        public final ProfilePictureAsCoverModel m20889L() {
            this.f17136G = (ProfilePictureAsCoverModel) super.a(this.f17136G, 29, ProfilePictureAsCoverModel.class);
            return this.f17136G;
        }

        @Nullable
        public final PageHeaderDataProfilePhotoModel m20890M() {
            this.f17137H = (PageHeaderDataProfilePhotoModel) super.a(this.f17137H, 30, PageHeaderDataProfilePhotoModel.class);
            return this.f17137H;
        }

        @Nullable
        public final DefaultImageFieldsModel m20891N() {
            this.f17138I = (DefaultImageFieldsModel) super.a(this.f17138I, 31, DefaultImageFieldsModel.class);
            return this.f17138I;
        }

        public final boolean m20892O() {
            a(4, 0);
            return this.f17139J;
        }

        @Nullable
        public final ProfileHeaderAssociatedVideoModel m20893P() {
            this.f17140K = (ProfileHeaderAssociatedVideoModel) super.a(this.f17140K, 33, ProfileHeaderAssociatedVideoModel.class);
            return this.f17140K;
        }

        @Nullable
        public final RecentPostersModel m20894Q() {
            this.f17141L = (RecentPostersModel) super.a(this.f17141L, 34, RecentPostersModel.class);
            return this.f17141L;
        }

        @Nonnull
        public final ImmutableList<RedirectionInfoModel> m20895R() {
            this.f17142M = super.a(this.f17142M, 35, RedirectionInfoModel.class);
            return (ImmutableList) this.f17142M;
        }

        @Nullable
        public final SavableTimelineAppCollectionExtraFieldsModel m20896S() {
            this.f17143N = (SavableTimelineAppCollectionExtraFieldsModel) super.a(this.f17143N, 36, SavableTimelineAppCollectionExtraFieldsModel.class);
            return this.f17143N;
        }

        @Nullable
        public final GraphQLSecondarySubscribeStatus m20897T() {
            this.f17144O = (GraphQLSecondarySubscribeStatus) super.b(this.f17144O, 37, GraphQLSecondarySubscribeStatus.class, GraphQLSecondarySubscribeStatus.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
            return this.f17144O;
        }

        @Nonnull
        public final ImmutableList<SectionsCanAddModel> m20898U() {
            this.f17145P = super.a(this.f17145P, 38, SectionsCanAddModel.class);
            return (ImmutableList) this.f17145P;
        }

        public final boolean m20899V() {
            a(4, 7);
            return this.f17146Q;
        }

        public final boolean m20900W() {
            a(5, 0);
            return this.f17147R;
        }

        public final boolean m20901X() {
            a(5, 1);
            return this.f17148S;
        }

        @Nullable
        public final GraphQLSubscribeStatus m20902Y() {
            this.f17149T = (GraphQLSubscribeStatus) super.b(this.f17149T, 42, GraphQLSubscribeStatus.class, GraphQLSubscribeStatus.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
            return this.f17149T;
        }

        private void m20877a(GraphQLSubscribeStatus graphQLSubscribeStatus) {
            this.f17149T = graphQLSubscribeStatus;
            if (this.b != null && this.b.d) {
                this.b.a(this.c, 42, graphQLSubscribeStatus != null ? graphQLSubscribeStatus.name() : null);
            }
        }

        @Nullable
        public final GraphQLPageSuperCategoryType m20903Z() {
            this.f17150U = (GraphQLPageSuperCategoryType) super.b(this.f17150U, 43, GraphQLPageSuperCategoryType.class, GraphQLPageSuperCategoryType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
            return this.f17150U;
        }

        @Nonnull
        public final ImmutableList<TabsModel> aa() {
            this.f17151V = super.a(this.f17151V, 44, TabsModel.class);
            return (ImmutableList) this.f17151V;
        }

        @Nullable
        public final String ab() {
            this.f17152W = super.a(this.f17152W, 45);
            return this.f17152W;
        }

        @Nullable
        public final String ac() {
            this.f17153X = super.a(this.f17153X, 46);
            return this.f17153X;
        }

        @Nullable
        public final GraphQLPageVerificationBadge ad() {
            this.f17154Y = (GraphQLPageVerificationBadge) super.b(this.f17154Y, 47, GraphQLPageVerificationBadge.class, GraphQLPageVerificationBadge.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
            return this.f17154Y;
        }

        @Nullable
        public final VideoCollectionModel ae() {
            this.f17155Z = (VideoCollectionModel) super.a(this.f17155Z, 48, VideoCollectionModel.class);
            return this.f17155Z;
        }

        @Nonnull
        public final ImmutableList<String> af() {
            this.aa = super.a(this.aa, 49);
            return (ImmutableList) this.aa;
        }

        @Nullable
        public final GraphQLSavedState ag() {
            this.ab = (GraphQLSavedState) super.b(this.ab, 50, GraphQLSavedState.class, GraphQLSavedState.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
            return this.ab;
        }

        private void m20876a(GraphQLSavedState graphQLSavedState) {
            this.ab = graphQLSavedState;
            if (this.b != null && this.b.d) {
                this.b.a(this.c, 50, graphQLSavedState != null ? graphQLSavedState.name() : null);
            }
        }

        public final int jK_() {
            return 2433570;
        }

        public final GraphQLVisitableModel m20906a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            com.google.common.collect.ImmutableList.Builder a;
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m20910j() != null) {
                AddressModel addressModel = (AddressModel) graphQLModelMutatingVisitor.b(m20910j());
                if (m20910j() != addressModel) {
                    graphQLVisitableModel = (FetchPageHeaderQueryModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f17157e = addressModel;
                }
            }
            if (m20911k() != null) {
                AdminDisplayPreferenceModel adminDisplayPreferenceModel = (AdminDisplayPreferenceModel) graphQLModelMutatingVisitor.b(m20911k());
                if (m20911k() != adminDisplayPreferenceModel) {
                    graphQLVisitableModel = (FetchPageHeaderQueryModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f17158f = adminDisplayPreferenceModel;
                }
            }
            if (m20912l() != null) {
                PageAdminInfoBaseDataModel pageAdminInfoBaseDataModel = (PageAdminInfoBaseDataModel) graphQLModelMutatingVisitor.b(m20912l());
                if (m20912l() != pageAdminInfoBaseDataModel) {
                    graphQLVisitableModel = (FetchPageHeaderQueryModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f17159g = pageAdminInfoBaseDataModel;
                }
            }
            if (m20913m() != null) {
                a = ModelHelper.a(m20913m(), graphQLModelMutatingVisitor);
                if (a != null) {
                    FetchPageHeaderQueryModel fetchPageHeaderQueryModel = (FetchPageHeaderQueryModel) ModelHelper.a(graphQLVisitableModel, this);
                    fetchPageHeaderQueryModel.f17160h = a.b();
                    graphQLVisitableModel = fetchPageHeaderQueryModel;
                }
            }
            if (m20920t() != null) {
                ContextItemsConnectionWithPageInfoFragmentModel contextItemsConnectionWithPageInfoFragmentModel = (ContextItemsConnectionWithPageInfoFragmentModel) graphQLModelMutatingVisitor.b(m20920t());
                if (m20920t() != contextItemsConnectionWithPageInfoFragmentModel) {
                    graphQLVisitableModel = (FetchPageHeaderQueryModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f17167o = contextItemsConnectionWithPageInfoFragmentModel;
                }
            }
            if (m20921u() != null) {
                CoverPhotoModel coverPhotoModel = (CoverPhotoModel) graphQLModelMutatingVisitor.b(m20921u());
                if (m20921u() != coverPhotoModel) {
                    graphQLVisitableModel = (FetchPageHeaderQueryModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f17168p = coverPhotoModel;
                }
            }
            if (m20879B() != null) {
                DefaultLocationFieldsModel defaultLocationFieldsModel = (DefaultLocationFieldsModel) graphQLModelMutatingVisitor.b(m20879B());
                if (m20879B() != defaultLocationFieldsModel) {
                    graphQLVisitableModel = (FetchPageHeaderQueryModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f17175w = defaultLocationFieldsModel;
                }
            }
            if (m20882E() != null) {
                NuxStateModel nuxStateModel = (NuxStateModel) graphQLModelMutatingVisitor.b(m20882E());
                if (m20882E() != nuxStateModel) {
                    graphQLVisitableModel = (FetchPageHeaderQueryModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f17178z = nuxStateModel;
                }
            }
            if (m20883F() != null) {
                OverallStarRatingModel overallStarRatingModel = (OverallStarRatingModel) graphQLModelMutatingVisitor.b(m20883F());
                if (m20883F() != overallStarRatingModel) {
                    graphQLVisitableModel = (FetchPageHeaderQueryModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f17130A = overallStarRatingModel;
                }
            }
            if (m20884G() != null) {
                PageCallToActionModel pageCallToActionModel = (PageCallToActionModel) graphQLModelMutatingVisitor.b(m20884G());
                if (m20884G() != pageCallToActionModel) {
                    graphQLVisitableModel = (FetchPageHeaderQueryModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f17131B = pageCallToActionModel;
                }
            }
            if (m20885H() != null) {
                PageLikersModel pageLikersModel = (PageLikersModel) graphQLModelMutatingVisitor.b(m20885H());
                if (m20885H() != pageLikersModel) {
                    graphQLVisitableModel = (FetchPageHeaderQueryModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f17132C = pageLikersModel;
                }
            }
            if (m20886I() != null) {
                PlaceOpenStatusModel placeOpenStatusModel = (PlaceOpenStatusModel) graphQLModelMutatingVisitor.b(m20886I());
                if (m20886I() != placeOpenStatusModel) {
                    graphQLVisitableModel = (FetchPageHeaderQueryModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f17133D = placeOpenStatusModel;
                }
            }
            if (m20889L() != null) {
                ProfilePictureAsCoverModel profilePictureAsCoverModel = (ProfilePictureAsCoverModel) graphQLModelMutatingVisitor.b(m20889L());
                if (m20889L() != profilePictureAsCoverModel) {
                    graphQLVisitableModel = (FetchPageHeaderQueryModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f17136G = profilePictureAsCoverModel;
                }
            }
            if (m20890M() != null) {
                PageHeaderDataProfilePhotoModel pageHeaderDataProfilePhotoModel = (PageHeaderDataProfilePhotoModel) graphQLModelMutatingVisitor.b(m20890M());
                if (m20890M() != pageHeaderDataProfilePhotoModel) {
                    graphQLVisitableModel = (FetchPageHeaderQueryModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f17137H = pageHeaderDataProfilePhotoModel;
                }
            }
            if (m20891N() != null) {
                DefaultImageFieldsModel defaultImageFieldsModel = (DefaultImageFieldsModel) graphQLModelMutatingVisitor.b(m20891N());
                if (m20891N() != defaultImageFieldsModel) {
                    graphQLVisitableModel = (FetchPageHeaderQueryModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f17138I = defaultImageFieldsModel;
                }
            }
            if (m20893P() != null) {
                ProfileHeaderAssociatedVideoModel profileHeaderAssociatedVideoModel = (ProfileHeaderAssociatedVideoModel) graphQLModelMutatingVisitor.b(m20893P());
                if (m20893P() != profileHeaderAssociatedVideoModel) {
                    graphQLVisitableModel = (FetchPageHeaderQueryModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f17140K = profileHeaderAssociatedVideoModel;
                }
            }
            if (m20894Q() != null) {
                RecentPostersModel recentPostersModel = (RecentPostersModel) graphQLModelMutatingVisitor.b(m20894Q());
                if (m20894Q() != recentPostersModel) {
                    graphQLVisitableModel = (FetchPageHeaderQueryModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f17141L = recentPostersModel;
                }
            }
            if (m20895R() != null) {
                a = ModelHelper.a(m20895R(), graphQLModelMutatingVisitor);
                if (a != null) {
                    fetchPageHeaderQueryModel = (FetchPageHeaderQueryModel) ModelHelper.a(graphQLVisitableModel, this);
                    fetchPageHeaderQueryModel.f17142M = a.b();
                    graphQLVisitableModel = fetchPageHeaderQueryModel;
                }
            }
            if (m20896S() != null) {
                SavableTimelineAppCollectionExtraFieldsModel savableTimelineAppCollectionExtraFieldsModel = (SavableTimelineAppCollectionExtraFieldsModel) graphQLModelMutatingVisitor.b(m20896S());
                if (m20896S() != savableTimelineAppCollectionExtraFieldsModel) {
                    graphQLVisitableModel = (FetchPageHeaderQueryModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f17143N = savableTimelineAppCollectionExtraFieldsModel;
                }
            }
            if (m20898U() != null) {
                a = ModelHelper.a(m20898U(), graphQLModelMutatingVisitor);
                if (a != null) {
                    fetchPageHeaderQueryModel = (FetchPageHeaderQueryModel) ModelHelper.a(graphQLVisitableModel, this);
                    fetchPageHeaderQueryModel.f17145P = a.b();
                    graphQLVisitableModel = fetchPageHeaderQueryModel;
                }
            }
            if (aa() != null) {
                a = ModelHelper.a(aa(), graphQLModelMutatingVisitor);
                if (a != null) {
                    fetchPageHeaderQueryModel = (FetchPageHeaderQueryModel) ModelHelper.a(graphQLVisitableModel, this);
                    fetchPageHeaderQueryModel.f17151V = a.b();
                    graphQLVisitableModel = fetchPageHeaderQueryModel;
                }
            }
            if (ae() != null) {
                VideoCollectionModel videoCollectionModel = (VideoCollectionModel) graphQLModelMutatingVisitor.b(ae());
                if (ae() != videoCollectionModel) {
                    graphQLVisitableModel = (FetchPageHeaderQueryModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f17155Z = videoCollectionModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m20904a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m20905a());
            int a2 = ModelHelper.a(flatBufferBuilder, m20910j());
            int a3 = ModelHelper.a(flatBufferBuilder, m20911k());
            int a4 = ModelHelper.a(flatBufferBuilder, m20912l());
            int a5 = ModelHelper.a(flatBufferBuilder, m20913m());
            int c = flatBufferBuilder.c(m20919s());
            int a6 = ModelHelper.a(flatBufferBuilder, m20920t());
            int a7 = ModelHelper.a(flatBufferBuilder, m20921u());
            int a8 = ModelHelper.a(flatBufferBuilder, m20879B());
            int b = flatBufferBuilder.b(m20880C());
            int b2 = flatBufferBuilder.b(m20881D());
            int a9 = ModelHelper.a(flatBufferBuilder, m20882E());
            int a10 = ModelHelper.a(flatBufferBuilder, m20883F());
            int a11 = ModelHelper.a(flatBufferBuilder, m20884G());
            int a12 = ModelHelper.a(flatBufferBuilder, m20885H());
            int a13 = ModelHelper.a(flatBufferBuilder, m20886I());
            int a14 = flatBufferBuilder.a(m20887J());
            int a15 = flatBufferBuilder.a(m20888K());
            int a16 = ModelHelper.a(flatBufferBuilder, m20889L());
            int a17 = ModelHelper.a(flatBufferBuilder, m20890M());
            int a18 = ModelHelper.a(flatBufferBuilder, m20891N());
            int a19 = ModelHelper.a(flatBufferBuilder, m20893P());
            int a20 = ModelHelper.a(flatBufferBuilder, m20894Q());
            int a21 = ModelHelper.a(flatBufferBuilder, m20895R());
            int a22 = ModelHelper.a(flatBufferBuilder, m20896S());
            int a23 = flatBufferBuilder.a(m20897T());
            int a24 = ModelHelper.a(flatBufferBuilder, m20898U());
            int a25 = flatBufferBuilder.a(m20902Y());
            int a26 = flatBufferBuilder.a(m20903Z());
            int a27 = ModelHelper.a(flatBufferBuilder, aa());
            int b3 = flatBufferBuilder.b(ab());
            int b4 = flatBufferBuilder.b(ac());
            int a28 = flatBufferBuilder.a(ad());
            int a29 = ModelHelper.a(flatBufferBuilder, ae());
            int c2 = flatBufferBuilder.c(af());
            int a30 = flatBufferBuilder.a(ag());
            flatBufferBuilder.c(51);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, a2);
            flatBufferBuilder.b(2, a3);
            flatBufferBuilder.b(3, a4);
            flatBufferBuilder.b(4, a5);
            flatBufferBuilder.a(5, this.f17161i);
            flatBufferBuilder.a(6, this.f17162j);
            flatBufferBuilder.a(7, this.f17163k);
            flatBufferBuilder.a(8, this.f17164l);
            flatBufferBuilder.a(9, this.f17165m);
            flatBufferBuilder.b(10, c);
            flatBufferBuilder.b(11, a6);
            flatBufferBuilder.b(12, a7);
            flatBufferBuilder.a(13, this.f17169q);
            flatBufferBuilder.a(14, this.f17170r);
            flatBufferBuilder.a(15, this.f17171s);
            flatBufferBuilder.a(16, this.f17172t);
            flatBufferBuilder.a(17, this.f17173u);
            flatBufferBuilder.a(18, this.f17174v);
            flatBufferBuilder.b(19, a8);
            flatBufferBuilder.b(20, b);
            flatBufferBuilder.b(21, b2);
            flatBufferBuilder.b(22, a9);
            flatBufferBuilder.b(23, a10);
            flatBufferBuilder.b(24, a11);
            flatBufferBuilder.b(25, a12);
            flatBufferBuilder.b(26, a13);
            flatBufferBuilder.b(27, a14);
            flatBufferBuilder.b(28, a15);
            flatBufferBuilder.b(29, a16);
            flatBufferBuilder.b(30, a17);
            flatBufferBuilder.b(31, a18);
            flatBufferBuilder.a(32, this.f17139J);
            flatBufferBuilder.b(33, a19);
            flatBufferBuilder.b(34, a20);
            flatBufferBuilder.b(35, a21);
            flatBufferBuilder.b(36, a22);
            flatBufferBuilder.b(37, a23);
            flatBufferBuilder.b(38, a24);
            flatBufferBuilder.a(39, this.f17146Q);
            flatBufferBuilder.a(40, this.f17147R);
            flatBufferBuilder.a(41, this.f17148S);
            flatBufferBuilder.b(42, a25);
            flatBufferBuilder.b(43, a26);
            flatBufferBuilder.b(44, a27);
            flatBufferBuilder.b(45, b3);
            flatBufferBuilder.b(46, b4);
            flatBufferBuilder.b(47, a28);
            flatBufferBuilder.b(48, a29);
            flatBufferBuilder.b(49, c2);
            flatBufferBuilder.b(50, a30);
            i();
            return flatBufferBuilder.d();
        }

        public final void m20907a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
            super.a(mutableFlatBuffer, i, obj);
            this.f17161i = mutableFlatBuffer.a(i, 5);
            this.f17162j = mutableFlatBuffer.a(i, 6);
            this.f17163k = mutableFlatBuffer.a(i, 7);
            this.f17164l = mutableFlatBuffer.a(i, 8);
            this.f17165m = mutableFlatBuffer.a(i, 9);
            this.f17169q = mutableFlatBuffer.a(i, 13);
            this.f17170r = mutableFlatBuffer.a(i, 14);
            this.f17171s = mutableFlatBuffer.a(i, 15);
            this.f17172t = mutableFlatBuffer.a(i, 16);
            this.f17173u = mutableFlatBuffer.a(i, 17);
            this.f17174v = mutableFlatBuffer.a(i, 18);
            this.f17139J = mutableFlatBuffer.a(i, 32);
            this.f17146Q = mutableFlatBuffer.a(i, 39);
            this.f17147R = mutableFlatBuffer.a(i, 40);
            this.f17148S = mutableFlatBuffer.a(i, 41);
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -1469125757)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: confirmation_change_contactpoint_failure */
    public final class PageActionBarDataModel extends BaseModel implements GraphQLVisitableConsistentModel {
        private boolean f17180d;
        private boolean f17181e;
        private boolean f17182f;
        private boolean f17183g;
        private boolean f17184h;
        private boolean f17185i;
        @Nullable
        private String f17186j;
        @Nullable
        private NuxStateModel f17187k;
        @Nullable
        private GraphQLPlaceType f17188l;
        @Nullable
        private SavableTimelineAppCollectionExtraFieldsModel f17189m;
        @Nullable
        private GraphQLSecondarySubscribeStatus f17190n;
        private boolean f17191o;
        private boolean f17192p;
        @Nullable
        private GraphQLSubscribeStatus f17193q;
        @Nullable
        private String f17194r;
        @Nullable
        private GraphQLSavedState f17195s;

        /* compiled from: confirmation_change_contactpoint_failure */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(PageActionBarDataModel.class, new Deserializer());
            }

            public Object m20927a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(PageActionBarDataParser.m21233a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object pageActionBarDataModel = new PageActionBarDataModel();
                ((BaseModel) pageActionBarDataModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (pageActionBarDataModel instanceof Postprocessable) {
                    return ((Postprocessable) pageActionBarDataModel).a();
                }
                return pageActionBarDataModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 1430609600)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: confirmation_change_contactpoint_failure */
        public final class NuxStateModel extends BaseModel implements GraphQLVisitableModel {
            private boolean f17179d;

            /* compiled from: confirmation_change_contactpoint_failure */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(NuxStateModel.class, new Deserializer());
                }

                public Object m20928a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(NuxStateParser.m21231a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object nuxStateModel = new NuxStateModel();
                    ((BaseModel) nuxStateModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (nuxStateModel instanceof Postprocessable) {
                        return ((Postprocessable) nuxStateModel).a();
                    }
                    return nuxStateModel;
                }
            }

            /* compiled from: confirmation_change_contactpoint_failure */
            public class Serializer extends JsonSerializer<NuxStateModel> {
                public final void m20929a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    NuxStateModel nuxStateModel = (NuxStateModel) obj;
                    if (nuxStateModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(nuxStateModel.m20930a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        nuxStateModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    NuxStateParser.m21232a(nuxStateModel.w_(), nuxStateModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(NuxStateModel.class, new Serializer());
                }
            }

            public NuxStateModel() {
                super(1);
            }

            public final boolean m20933a() {
                a(0, 0);
                return this.f17179d;
            }

            public final int jK_() {
                return 1075435343;
            }

            public final GraphQLVisitableModel m20931a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m20930a(FlatBufferBuilder flatBufferBuilder) {
                h();
                flatBufferBuilder.c(1);
                flatBufferBuilder.a(0, this.f17179d);
                i();
                return flatBufferBuilder.d();
            }

            public final void m20932a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                super.a(mutableFlatBuffer, i, obj);
                this.f17179d = mutableFlatBuffer.a(i, 0);
            }
        }

        /* compiled from: confirmation_change_contactpoint_failure */
        public class Serializer extends JsonSerializer<PageActionBarDataModel> {
            public final void m20934a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                PageActionBarDataModel pageActionBarDataModel = (PageActionBarDataModel) obj;
                if (pageActionBarDataModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(pageActionBarDataModel.m20946a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    pageActionBarDataModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                PageActionBarDataParser.m21234a(pageActionBarDataModel.w_(), pageActionBarDataModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(PageActionBarDataModel.class, new Serializer());
            }
        }

        public PageActionBarDataModel() {
            super(16);
        }

        public final void m20949a(String str, ConsistencyTuple consistencyTuple) {
            if ("does_viewer_like".equals(str)) {
                consistencyTuple.a = Boolean.valueOf(m20937a());
                consistencyTuple.b = u_();
                consistencyTuple.c = 5;
            } else if ("secondary_subscribe_status".equals(str)) {
                consistencyTuple.a = m20942n();
                consistencyTuple.b = u_();
                consistencyTuple.c = 10;
            } else {
                consistencyTuple.a();
            }
        }

        public final void m20950a(String str, Object obj, boolean z) {
            if ("does_viewer_like".equals(str)) {
                m20936a(((Boolean) obj).booleanValue());
            } else if ("secondary_subscribe_status".equals(str)) {
                m20935a((GraphQLSecondarySubscribeStatus) obj);
            }
        }

        private boolean m20937a() {
            a(0, 5);
            return this.f17185i;
        }

        private void m20936a(boolean z) {
            this.f17185i = z;
            if (this.b != null && this.b.d) {
                this.b.a(this.c, 5, z);
            }
        }

        @Nullable
        private String m20938j() {
            this.f17186j = super.a(this.f17186j, 6);
            return this.f17186j;
        }

        @Nullable
        private NuxStateModel m20939k() {
            this.f17187k = (NuxStateModel) super.a(this.f17187k, 7, NuxStateModel.class);
            return this.f17187k;
        }

        @Nullable
        private GraphQLPlaceType m20940l() {
            this.f17188l = (GraphQLPlaceType) super.b(this.f17188l, 8, GraphQLPlaceType.class, GraphQLPlaceType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
            return this.f17188l;
        }

        @Nullable
        private SavableTimelineAppCollectionExtraFieldsModel m20941m() {
            this.f17189m = (SavableTimelineAppCollectionExtraFieldsModel) super.a(this.f17189m, 9, SavableTimelineAppCollectionExtraFieldsModel.class);
            return this.f17189m;
        }

        @Nullable
        private GraphQLSecondarySubscribeStatus m20942n() {
            this.f17190n = (GraphQLSecondarySubscribeStatus) super.b(this.f17190n, 10, GraphQLSecondarySubscribeStatus.class, GraphQLSecondarySubscribeStatus.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
            return this.f17190n;
        }

        private void m20935a(GraphQLSecondarySubscribeStatus graphQLSecondarySubscribeStatus) {
            this.f17190n = graphQLSecondarySubscribeStatus;
            if (this.b != null && this.b.d) {
                this.b.a(this.c, 10, graphQLSecondarySubscribeStatus != null ? graphQLSecondarySubscribeStatus.name() : null);
            }
        }

        @Nullable
        private GraphQLSubscribeStatus m20943o() {
            this.f17193q = (GraphQLSubscribeStatus) super.b(this.f17193q, 13, GraphQLSubscribeStatus.class, GraphQLSubscribeStatus.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
            return this.f17193q;
        }

        @Nullable
        private String m20944p() {
            this.f17194r = super.a(this.f17194r, 14);
            return this.f17194r;
        }

        @Nullable
        private GraphQLSavedState m20945q() {
            this.f17195s = (GraphQLSavedState) super.b(this.f17195s, 15, GraphQLSavedState.class, GraphQLSavedState.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
            return this.f17195s;
        }

        public final int jK_() {
            return 2479791;
        }

        public final GraphQLVisitableModel m20947a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m20939k() != null) {
                NuxStateModel nuxStateModel = (NuxStateModel) graphQLModelMutatingVisitor.b(m20939k());
                if (m20939k() != nuxStateModel) {
                    graphQLVisitableModel = (PageActionBarDataModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f17187k = nuxStateModel;
                }
            }
            if (m20941m() != null) {
                SavableTimelineAppCollectionExtraFieldsModel savableTimelineAppCollectionExtraFieldsModel = (SavableTimelineAppCollectionExtraFieldsModel) graphQLModelMutatingVisitor.b(m20941m());
                if (m20941m() != savableTimelineAppCollectionExtraFieldsModel) {
                    graphQLVisitableModel = (PageActionBarDataModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f17189m = savableTimelineAppCollectionExtraFieldsModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m20946a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(m20938j());
            int a = ModelHelper.a(flatBufferBuilder, m20939k());
            int a2 = flatBufferBuilder.a(m20940l());
            int a3 = ModelHelper.a(flatBufferBuilder, m20941m());
            int a4 = flatBufferBuilder.a(m20942n());
            int a5 = flatBufferBuilder.a(m20943o());
            int b2 = flatBufferBuilder.b(m20944p());
            int a6 = flatBufferBuilder.a(m20945q());
            flatBufferBuilder.c(16);
            flatBufferBuilder.a(0, this.f17180d);
            flatBufferBuilder.a(1, this.f17181e);
            flatBufferBuilder.a(2, this.f17182f);
            flatBufferBuilder.a(3, this.f17183g);
            flatBufferBuilder.a(4, this.f17184h);
            flatBufferBuilder.a(5, this.f17185i);
            flatBufferBuilder.b(6, b);
            flatBufferBuilder.b(7, a);
            flatBufferBuilder.b(8, a2);
            flatBufferBuilder.b(9, a3);
            flatBufferBuilder.b(10, a4);
            flatBufferBuilder.a(11, this.f17191o);
            flatBufferBuilder.a(12, this.f17192p);
            flatBufferBuilder.b(13, a5);
            flatBufferBuilder.b(14, b2);
            flatBufferBuilder.b(15, a6);
            i();
            return flatBufferBuilder.d();
        }

        public final void m20948a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
            super.a(mutableFlatBuffer, i, obj);
            this.f17180d = mutableFlatBuffer.a(i, 0);
            this.f17181e = mutableFlatBuffer.a(i, 1);
            this.f17182f = mutableFlatBuffer.a(i, 2);
            this.f17183g = mutableFlatBuffer.a(i, 3);
            this.f17184h = mutableFlatBuffer.a(i, 4);
            this.f17185i = mutableFlatBuffer.a(i, 5);
            this.f17191o = mutableFlatBuffer.a(i, 11);
            this.f17192p = mutableFlatBuffer.a(i, 12);
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 138069390)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: confirmation_change_contactpoint_failure */
    public final class PageAdminInfoBaseDataModel extends BaseModel implements GraphQLVisitableModel {
        private boolean f17199d;
        private boolean f17200e;
        private boolean f17201f;

        /* compiled from: confirmation_change_contactpoint_failure */
        public final class Builder {
            public boolean f17196a;
            public boolean f17197b;
            public boolean f17198c;

            public final PageAdminInfoBaseDataModel m20951a() {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.c(3);
                flatBufferBuilder.a(0, this.f17196a);
                flatBufferBuilder.a(1, this.f17197b);
                flatBufferBuilder.a(2, this.f17198c);
                flatBufferBuilder.d(flatBufferBuilder.d());
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                return new PageAdminInfoBaseDataModel(new MutableFlatBuffer(wrap, null, null, true, null));
            }
        }

        /* compiled from: confirmation_change_contactpoint_failure */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(PageAdminInfoBaseDataModel.class, new Deserializer());
            }

            public Object m20952a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(PageAdminInfoBaseDataParser.m21235a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object pageAdminInfoBaseDataModel = new PageAdminInfoBaseDataModel();
                ((BaseModel) pageAdminInfoBaseDataModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (pageAdminInfoBaseDataModel instanceof Postprocessable) {
                    return ((Postprocessable) pageAdminInfoBaseDataModel).a();
                }
                return pageAdminInfoBaseDataModel;
            }
        }

        /* compiled from: confirmation_change_contactpoint_failure */
        public class Serializer extends JsonSerializer<PageAdminInfoBaseDataModel> {
            public final void m20953a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                PageAdminInfoBaseDataModel pageAdminInfoBaseDataModel = (PageAdminInfoBaseDataModel) obj;
                if (pageAdminInfoBaseDataModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(pageAdminInfoBaseDataModel.m20954a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    pageAdminInfoBaseDataModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                PageAdminInfoBaseDataParser.m21236a(pageAdminInfoBaseDataModel.w_(), pageAdminInfoBaseDataModel.u_(), jsonGenerator);
            }

            static {
                FbSerializerProvider.a(PageAdminInfoBaseDataModel.class, new Serializer());
            }
        }

        public PageAdminInfoBaseDataModel() {
            super(3);
        }

        public PageAdminInfoBaseDataModel(MutableFlatBuffer mutableFlatBuffer) {
            super(3);
            a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
        }

        public final boolean m20957a() {
            a(0, 0);
            return this.f17199d;
        }

        public final boolean m20958j() {
            a(0, 1);
            return this.f17200e;
        }

        public final boolean m20959k() {
            a(0, 2);
            return this.f17201f;
        }

        public final int jK_() {
            return 888797870;
        }

        public final GraphQLVisitableModel m20955a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            h();
            i();
            return this;
        }

        public final int m20954a(FlatBufferBuilder flatBufferBuilder) {
            h();
            flatBufferBuilder.c(3);
            flatBufferBuilder.a(0, this.f17199d);
            flatBufferBuilder.a(1, this.f17200e);
            flatBufferBuilder.a(2, this.f17201f);
            i();
            return flatBufferBuilder.d();
        }

        public final void m20956a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
            super.a(mutableFlatBuffer, i, obj);
            this.f17199d = mutableFlatBuffer.a(i, 0);
            this.f17200e = mutableFlatBuffer.a(i, 1);
            this.f17201f = mutableFlatBuffer.a(i, 2);
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -433029491)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: confirmation_change_contactpoint_failure */
    public final class PageAdminPostsByOthersDataModel extends BaseModel implements GraphQLVisitableConsistentModel {
        @Nullable
        private AdminDisplayPreferenceModel f17204d;
        @Nullable
        private RecentPostersModel f17205e;

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 1905074626)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: confirmation_change_contactpoint_failure */
        public final class AdminDisplayPreferenceModel extends BaseModel implements GraphQLVisitableModel {
            private boolean f17202d;

            /* compiled from: confirmation_change_contactpoint_failure */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(AdminDisplayPreferenceModel.class, new Deserializer());
                }

                public Object m20960a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(AdminDisplayPreferenceParser.m21237a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object adminDisplayPreferenceModel = new AdminDisplayPreferenceModel();
                    ((BaseModel) adminDisplayPreferenceModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (adminDisplayPreferenceModel instanceof Postprocessable) {
                        return ((Postprocessable) adminDisplayPreferenceModel).a();
                    }
                    return adminDisplayPreferenceModel;
                }
            }

            /* compiled from: confirmation_change_contactpoint_failure */
            public class Serializer extends JsonSerializer<AdminDisplayPreferenceModel> {
                public final void m20961a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    AdminDisplayPreferenceModel adminDisplayPreferenceModel = (AdminDisplayPreferenceModel) obj;
                    if (adminDisplayPreferenceModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(adminDisplayPreferenceModel.m20962a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        adminDisplayPreferenceModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    AdminDisplayPreferenceParser.m21238a(adminDisplayPreferenceModel.w_(), adminDisplayPreferenceModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(AdminDisplayPreferenceModel.class, new Serializer());
                }
            }

            public AdminDisplayPreferenceModel() {
                super(1);
            }

            public final boolean m20965a() {
                a(0, 0);
                return this.f17202d;
            }

            public final int jK_() {
                return 60838205;
            }

            public final GraphQLVisitableModel m20963a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m20962a(FlatBufferBuilder flatBufferBuilder) {
                h();
                flatBufferBuilder.c(1);
                flatBufferBuilder.a(0, this.f17202d);
                i();
                return flatBufferBuilder.d();
            }

            public final void m20964a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                super.a(mutableFlatBuffer, i, obj);
                this.f17202d = mutableFlatBuffer.a(i, 0);
            }
        }

        /* compiled from: confirmation_change_contactpoint_failure */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(PageAdminPostsByOthersDataModel.class, new Deserializer());
            }

            public Object m20966a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = PageAdminPostsByOthersDataParser.m21241a(jsonParser);
                Object pageAdminPostsByOthersDataModel = new PageAdminPostsByOthersDataModel();
                ((BaseModel) pageAdminPostsByOthersDataModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (pageAdminPostsByOthersDataModel instanceof Postprocessable) {
                    return ((Postprocessable) pageAdminPostsByOthersDataModel).a();
                }
                return pageAdminPostsByOthersDataModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1723990064)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: confirmation_change_contactpoint_failure */
        public final class RecentPostersModel extends BaseModel implements GraphQLVisitableModel {
            private int f17203d;

            /* compiled from: confirmation_change_contactpoint_failure */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(RecentPostersModel.class, new Deserializer());
                }

                public Object m20967a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(RecentPostersParser.m21239a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object recentPostersModel = new RecentPostersModel();
                    ((BaseModel) recentPostersModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (recentPostersModel instanceof Postprocessable) {
                        return ((Postprocessable) recentPostersModel).a();
                    }
                    return recentPostersModel;
                }
            }

            /* compiled from: confirmation_change_contactpoint_failure */
            public class Serializer extends JsonSerializer<RecentPostersModel> {
                public final void m20968a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    RecentPostersModel recentPostersModel = (RecentPostersModel) obj;
                    if (recentPostersModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(recentPostersModel.m20970a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        recentPostersModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    RecentPostersParser.m21240a(recentPostersModel.w_(), recentPostersModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(RecentPostersModel.class, new Serializer());
                }
            }

            public RecentPostersModel() {
                super(1);
            }

            public final int m20969a() {
                a(0, 0);
                return this.f17203d;
            }

            public final int jK_() {
                return 775245690;
            }

            public final GraphQLVisitableModel m20971a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m20970a(FlatBufferBuilder flatBufferBuilder) {
                h();
                flatBufferBuilder.c(1);
                flatBufferBuilder.a(0, this.f17203d, 0);
                i();
                return flatBufferBuilder.d();
            }

            public final void m20972a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                super.a(mutableFlatBuffer, i, obj);
                this.f17203d = mutableFlatBuffer.a(i, 0, 0);
            }
        }

        /* compiled from: confirmation_change_contactpoint_failure */
        public class Serializer extends JsonSerializer<PageAdminPostsByOthersDataModel> {
            public final void m20973a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                PageAdminPostsByOthersDataModel pageAdminPostsByOthersDataModel = (PageAdminPostsByOthersDataModel) obj;
                if (pageAdminPostsByOthersDataModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(pageAdminPostsByOthersDataModel.m20976a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    pageAdminPostsByOthersDataModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = pageAdminPostsByOthersDataModel.w_();
                int u_ = pageAdminPostsByOthersDataModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("admin_display_preference");
                    AdminDisplayPreferenceParser.m21238a(mutableFlatBuffer, g, jsonGenerator);
                }
                g = mutableFlatBuffer.g(u_, 1);
                if (g != 0) {
                    jsonGenerator.a("recent_posters");
                    RecentPostersParser.m21240a(mutableFlatBuffer, g, jsonGenerator);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(PageAdminPostsByOthersDataModel.class, new Serializer());
            }
        }

        public PageAdminPostsByOthersDataModel() {
            super(2);
        }

        public final void m20978a(String str, ConsistencyTuple consistencyTuple) {
            consistencyTuple.a();
        }

        public final void m20979a(String str, Object obj, boolean z) {
        }

        @Nullable
        private AdminDisplayPreferenceModel m20974a() {
            this.f17204d = (AdminDisplayPreferenceModel) super.a(this.f17204d, 0, AdminDisplayPreferenceModel.class);
            return this.f17204d;
        }

        @Nullable
        private RecentPostersModel m20975j() {
            this.f17205e = (RecentPostersModel) super.a(this.f17205e, 1, RecentPostersModel.class);
            return this.f17205e;
        }

        public final int jK_() {
            return 2479791;
        }

        public final GraphQLVisitableModel m20977a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m20974a() != null) {
                AdminDisplayPreferenceModel adminDisplayPreferenceModel = (AdminDisplayPreferenceModel) graphQLModelMutatingVisitor.b(m20974a());
                if (m20974a() != adminDisplayPreferenceModel) {
                    graphQLVisitableModel = (PageAdminPostsByOthersDataModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f17204d = adminDisplayPreferenceModel;
                }
            }
            if (m20975j() != null) {
                RecentPostersModel recentPostersModel = (RecentPostersModel) graphQLModelMutatingVisitor.b(m20975j());
                if (m20975j() != recentPostersModel) {
                    graphQLVisitableModel = (PageAdminPostsByOthersDataModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f17205e = recentPostersModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m20976a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m20974a());
            int a2 = ModelHelper.a(flatBufferBuilder, m20975j());
            flatBufferBuilder.c(2);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, a2);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 1818258984)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: confirmation_change_contactpoint_failure */
    public final class PageAdminSocialContextDataModel extends BaseModel implements GraphQLVisitableConsistentModel {
        @Nullable
        private PageAdminInfoBaseDataModel f17207d;
        @Nullable
        private PageLikersModel f17208e;

        /* compiled from: confirmation_change_contactpoint_failure */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(PageAdminSocialContextDataModel.class, new Deserializer());
            }

            public Object m20980a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = PageAdminSocialContextDataParser.m21244a(jsonParser);
                Object pageAdminSocialContextDataModel = new PageAdminSocialContextDataModel();
                ((BaseModel) pageAdminSocialContextDataModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (pageAdminSocialContextDataModel instanceof Postprocessable) {
                    return ((Postprocessable) pageAdminSocialContextDataModel).a();
                }
                return pageAdminSocialContextDataModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1723990064)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: confirmation_change_contactpoint_failure */
        public final class PageLikersModel extends BaseModel implements GraphQLVisitableModel {
            private int f17206d;

            /* compiled from: confirmation_change_contactpoint_failure */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(PageLikersModel.class, new Deserializer());
                }

                public Object m20981a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(PageLikersParser.m21242a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object pageLikersModel = new PageLikersModel();
                    ((BaseModel) pageLikersModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (pageLikersModel instanceof Postprocessable) {
                        return ((Postprocessable) pageLikersModel).a();
                    }
                    return pageLikersModel;
                }
            }

            /* compiled from: confirmation_change_contactpoint_failure */
            public class Serializer extends JsonSerializer<PageLikersModel> {
                public final void m20982a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    PageLikersModel pageLikersModel = (PageLikersModel) obj;
                    if (pageLikersModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(pageLikersModel.m20984a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        pageLikersModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    PageLikersParser.m21243a(pageLikersModel.w_(), pageLikersModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(PageLikersModel.class, new Serializer());
                }
            }

            public PageLikersModel() {
                super(1);
            }

            public final int m20983a() {
                a(0, 0);
                return this.f17206d;
            }

            public final int jK_() {
                return 637021669;
            }

            public final GraphQLVisitableModel m20985a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m20984a(FlatBufferBuilder flatBufferBuilder) {
                h();
                flatBufferBuilder.c(1);
                flatBufferBuilder.a(0, this.f17206d, 0);
                i();
                return flatBufferBuilder.d();
            }

            public final void m20986a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                super.a(mutableFlatBuffer, i, obj);
                this.f17206d = mutableFlatBuffer.a(i, 0, 0);
            }
        }

        /* compiled from: confirmation_change_contactpoint_failure */
        public class Serializer extends JsonSerializer<PageAdminSocialContextDataModel> {
            public final void m20987a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                PageAdminSocialContextDataModel pageAdminSocialContextDataModel = (PageAdminSocialContextDataModel) obj;
                if (pageAdminSocialContextDataModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(pageAdminSocialContextDataModel.m20990a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    pageAdminSocialContextDataModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = pageAdminSocialContextDataModel.w_();
                int u_ = pageAdminSocialContextDataModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("admin_info");
                    PageAdminInfoBaseDataParser.m21236a(mutableFlatBuffer, g, jsonGenerator);
                }
                g = mutableFlatBuffer.g(u_, 1);
                if (g != 0) {
                    jsonGenerator.a("page_likers");
                    PageLikersParser.m21243a(mutableFlatBuffer, g, jsonGenerator);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(PageAdminSocialContextDataModel.class, new Serializer());
            }
        }

        public PageAdminSocialContextDataModel() {
            super(2);
        }

        public final void m20992a(String str, ConsistencyTuple consistencyTuple) {
            consistencyTuple.a();
        }

        public final void m20993a(String str, Object obj, boolean z) {
        }

        @Nullable
        private PageAdminInfoBaseDataModel m20988a() {
            this.f17207d = (PageAdminInfoBaseDataModel) super.a(this.f17207d, 0, PageAdminInfoBaseDataModel.class);
            return this.f17207d;
        }

        @Nullable
        private PageLikersModel m20989j() {
            this.f17208e = (PageLikersModel) super.a(this.f17208e, 1, PageLikersModel.class);
            return this.f17208e;
        }

        public final int jK_() {
            return 2479791;
        }

        public final GraphQLVisitableModel m20991a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m20988a() != null) {
                PageAdminInfoBaseDataModel pageAdminInfoBaseDataModel = (PageAdminInfoBaseDataModel) graphQLModelMutatingVisitor.b(m20988a());
                if (m20988a() != pageAdminInfoBaseDataModel) {
                    graphQLVisitableModel = (PageAdminSocialContextDataModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f17207d = pageAdminInfoBaseDataModel;
                }
            }
            if (m20989j() != null) {
                PageLikersModel pageLikersModel = (PageLikersModel) graphQLModelMutatingVisitor.b(m20989j());
                if (m20989j() != pageLikersModel) {
                    graphQLVisitableModel = (PageAdminSocialContextDataModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f17208e = pageLikersModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m20990a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m20988a());
            int a2 = ModelHelper.a(flatBufferBuilder, m20989j());
            flatBufferBuilder.c(2);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, a2);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -7729303)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: confirmation_change_contactpoint_failure */
    public final class PageCallToActionDataModel extends BaseModel implements GraphQLVisitableConsistentModel, PageCallToActionData {
        @Nullable
        private PageCallToActionModel f17226d;

        /* compiled from: confirmation_change_contactpoint_failure */
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
                r0 = com.facebook.pages.data.graphql.pageheader.FetchPageHeaderGraphQLModels.PageCallToActionDataModel.class;
                r1 = new com.facebook.pages.data.graphql.pageheader.FetchPageHeaderGraphQLModels$PageCallToActionDataModel$Deserializer;
                r1.<init>();
                com.facebook.common.json.GlobalAutoGenDeserializerCache.a(r0, r1);
                return;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.pages.data.graphql.pageheader.FetchPageHeaderGraphQLModels.PageCallToActionDataModel.Deserializer.<clinit>():void");
            }

            public java.lang.Object m20994a(com.fasterxml.jackson.core.JsonParser r6, com.fasterxml.jackson.databind.DeserializationContext r7) {
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
                r2 = com.facebook.pages.data.graphql.pageheader.FetchPageHeaderGraphQLParsers.PageCallToActionDataParser.m21251a(r6);
                r1 = new com.facebook.pages.data.graphql.pageheader.FetchPageHeaderGraphQLModels$PageCallToActionDataModel;
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
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.pages.data.graphql.pageheader.FetchPageHeaderGraphQLModels.PageCallToActionDataModel.Deserializer.a(com.fasterxml.jackson.core.JsonParser, com.fasterxml.jackson.databind.DeserializationContext):java.lang.Object");
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1432425542)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: confirmation_change_contactpoint_failure */
        public final class PageCallToActionModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel {
            @Nullable
            private String f17213d;
            @Nullable
            private String f17214e;
            private boolean f17215f;
            @Nullable
            private CtaAdminInfoModel f17216g;
            @Nullable
            private GraphQLPageCallToActionType f17217h;
            @Nullable
            private String f17218i;
            @Nullable
            private String f17219j;
            @Nullable
            private FormFieldsModel f17220k;
            @Nullable
            private String f17221l;
            private boolean f17222m;
            @Nullable
            private String f17223n;
            @Nullable
            private PhoneNumberCommonFieldsModel f17224o;
            @Nullable
            private String f17225p;

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = 266149771)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: confirmation_change_contactpoint_failure */
            public final class CtaAdminInfoModel extends BaseModel implements GraphQLVisitableModel {
                private boolean f17209d;
                @Nullable
                private String f17210e;
                private boolean f17211f;

                /* compiled from: confirmation_change_contactpoint_failure */
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
                        r0 = com.facebook.pages.data.graphql.pageheader.FetchPageHeaderGraphQLModels.PageCallToActionDataModel.PageCallToActionModel.CtaAdminInfoModel.class;
                        r1 = new com.facebook.pages.data.graphql.pageheader.FetchPageHeaderGraphQLModels$PageCallToActionDataModel$PageCallToActionModel$CtaAdminInfoModel$Deserializer;
                        r1.<init>();
                        com.facebook.common.json.GlobalAutoGenDeserializerCache.a(r0, r1);
                        return;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.pages.data.graphql.pageheader.FetchPageHeaderGraphQLModels.PageCallToActionDataModel.PageCallToActionModel.CtaAdminInfoModel.Deserializer.<clinit>():void");
                    }

                    public java.lang.Object m20995a(com.fasterxml.jackson.core.JsonParser r11, com.fasterxml.jackson.databind.DeserializationContext r12) {
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
                        r5 = com.facebook.pages.data.graphql.pageheader.FetchPageHeaderGraphQLParsers.PageCallToActionDataParser.PageCallToActionParser.CtaAdminInfoParser.m21245a(r11, r4);
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
                        r1 = new com.facebook.pages.data.graphql.pageheader.FetchPageHeaderGraphQLModels$PageCallToActionDataModel$PageCallToActionModel$CtaAdminInfoModel;
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
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.pages.data.graphql.pageheader.FetchPageHeaderGraphQLModels.PageCallToActionDataModel.PageCallToActionModel.CtaAdminInfoModel.Deserializer.a(com.fasterxml.jackson.core.JsonParser, com.fasterxml.jackson.databind.DeserializationContext):java.lang.Object");
                    }
                }

                /* compiled from: confirmation_change_contactpoint_failure */
                public class Serializer extends JsonSerializer<CtaAdminInfoModel> {
                    public final void m20996a(java.lang.Object r8, com.fasterxml.jackson.core.JsonGenerator r9, com.fasterxml.jackson.databind.SerializerProvider r10) {
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
                        r8 = (com.facebook.pages.data.graphql.pageheader.FetchPageHeaderGraphQLModels.PageCallToActionDataModel.PageCallToActionModel.CtaAdminInfoModel) r8;
                        r2 = 0;
                        r0 = r8.w_();
                        if (r0 != 0) goto L_0x0035;
                    L_0x0009:
                        r0 = new com.facebook.flatbuffers.FlatBufferBuilder;
                        r1 = 128; // 0x80 float:1.794E-43 double:6.32E-322;
                        r0.<init>(r1);
                        r1 = r8.m20998a(r0);
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
                        com.facebook.pages.data.graphql.pageheader.FetchPageHeaderGraphQLParsers.PageCallToActionDataParser.PageCallToActionParser.CtaAdminInfoParser.m21246a(r0, r1, r9);
                        return;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.pages.data.graphql.pageheader.FetchPageHeaderGraphQLModels.PageCallToActionDataModel.PageCallToActionModel.CtaAdminInfoModel.Serializer.a(java.lang.Object, com.fasterxml.jackson.core.JsonGenerator, com.fasterxml.jackson.databind.SerializerProvider):void");
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
                        r0 = com.facebook.pages.data.graphql.pageheader.FetchPageHeaderGraphQLModels.PageCallToActionDataModel.PageCallToActionModel.CtaAdminInfoModel.class;
                        r1 = new com.facebook.pages.data.graphql.pageheader.FetchPageHeaderGraphQLModels$PageCallToActionDataModel$PageCallToActionModel$CtaAdminInfoModel$Serializer;
                        r1.<init>();
                        com.facebook.common.json.FbSerializerProvider.a(r0, r1);
                        return;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.pages.data.graphql.pageheader.FetchPageHeaderGraphQLModels.PageCallToActionDataModel.PageCallToActionModel.CtaAdminInfoModel.Serializer.<clinit>():void");
                    }
                }

                public CtaAdminInfoModel() {
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
                    r0 = 3;
                    r1.<init>(r0);
                    return;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.pages.data.graphql.pageheader.FetchPageHeaderGraphQLModels.PageCallToActionDataModel.PageCallToActionModel.CtaAdminInfoModel.<init>():void");
                }

                public final boolean m21001a() {
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
                    r0 = r1.f17209d;
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.pages.data.graphql.pageheader.FetchPageHeaderGraphQLModels.PageCallToActionDataModel.PageCallToActionModel.CtaAdminInfoModel.a():boolean");
                }

                @javax.annotation.Nullable
                private java.lang.String m20997k() {
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
                    r0 = r2.f17210e;
                    r1 = 1;
                    r0 = super.a(r0, r1);
                    r2.f17210e = r0;
                    r0 = r2.f17210e;
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.pages.data.graphql.pageheader.FetchPageHeaderGraphQLModels.PageCallToActionDataModel.PageCallToActionModel.CtaAdminInfoModel.k():java.lang.String");
                }

                public final boolean m21002j() {
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
                    r1 = 2;
                    r2.a(r0, r1);
                    r0 = r2.f17211f;
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.pages.data.graphql.pageheader.FetchPageHeaderGraphQLModels.PageCallToActionDataModel.PageCallToActionModel.CtaAdminInfoModel.j():boolean");
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
                    r0 = 609433823; // 0x245338df float:4.5801503E-17 double:3.011003154E-315;
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.pages.data.graphql.pageheader.FetchPageHeaderGraphQLModels.PageCallToActionDataModel.PageCallToActionModel.CtaAdminInfoModel.jK_():int");
                }

                public final com.facebook.graphql.visitor.GraphQLVisitableModel m20999a(com.facebook.graphql.visitor.GraphQLModelMutatingVisitor r1) {
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
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.pages.data.graphql.pageheader.FetchPageHeaderGraphQLModels.PageCallToActionDataModel.PageCallToActionModel.CtaAdminInfoModel.a(com.facebook.graphql.visitor.GraphQLModelMutatingVisitor):com.facebook.graphql.visitor.GraphQLVisitableModel");
                }

                public final int m20998a(com.facebook.flatbuffers.FlatBufferBuilder r4) {
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
                    r3.h();
                    r0 = r3.m20997k();
                    r0 = r4.b(r0);
                    r1 = 3;
                    r4.c(r1);
                    r1 = 0;
                    r2 = r3.f17209d;
                    r4.a(r1, r2);
                    r1 = 1;
                    r4.b(r1, r0);
                    r0 = 2;
                    r1 = r3.f17211f;
                    r4.a(r0, r1);
                    r3.i();
                    r0 = r4.d();
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.pages.data.graphql.pageheader.FetchPageHeaderGraphQLModels.PageCallToActionDataModel.PageCallToActionModel.CtaAdminInfoModel.a(com.facebook.flatbuffers.FlatBufferBuilder):int");
                }

                public final void m21000a(com.facebook.flatbuffers.MutableFlatBuffer r2, int r3, java.lang.Object r4) {
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
                    super.a(r2, r3, r4);
                    r0 = 0;
                    r0 = r2.a(r3, r0);
                    r1.f17209d = r0;
                    r0 = 2;
                    r0 = r2.a(r3, r0);
                    r1.f17211f = r0;
                    return;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.pages.data.graphql.pageheader.FetchPageHeaderGraphQLModels.PageCallToActionDataModel.PageCallToActionModel.CtaAdminInfoModel.a(com.facebook.flatbuffers.MutableFlatBuffer, int, java.lang.Object):void");
                }
            }

            /* compiled from: confirmation_change_contactpoint_failure */
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
                    r0 = com.facebook.pages.data.graphql.pageheader.FetchPageHeaderGraphQLModels.PageCallToActionDataModel.PageCallToActionModel.class;
                    r1 = new com.facebook.pages.data.graphql.pageheader.FetchPageHeaderGraphQLModels$PageCallToActionDataModel$PageCallToActionModel$Deserializer;
                    r1.<init>();
                    com.facebook.common.json.GlobalAutoGenDeserializerCache.a(r0, r1);
                    return;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.pages.data.graphql.pageheader.FetchPageHeaderGraphQLModels.PageCallToActionDataModel.PageCallToActionModel.Deserializer.<clinit>():void");
                }

                public java.lang.Object m21003a(com.fasterxml.jackson.core.JsonParser r11, com.fasterxml.jackson.databind.DeserializationContext r12) {
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
                    r5 = com.facebook.pages.data.graphql.pageheader.FetchPageHeaderGraphQLParsers.PageCallToActionDataParser.PageCallToActionParser.m21249a(r11, r4);
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
                    r1 = new com.facebook.pages.data.graphql.pageheader.FetchPageHeaderGraphQLModels$PageCallToActionDataModel$PageCallToActionModel;
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
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.pages.data.graphql.pageheader.FetchPageHeaderGraphQLModels.PageCallToActionDataModel.PageCallToActionModel.Deserializer.a(com.fasterxml.jackson.core.JsonParser, com.fasterxml.jackson.databind.DeserializationContext):java.lang.Object");
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = -1750181179)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: confirmation_change_contactpoint_failure */
            public final class FormFieldsModel extends BaseModel implements GraphQLVisitableModel {
                @Nullable
                private List<CallToActionConfigFieldsModel> f17212d;

                /* compiled from: confirmation_change_contactpoint_failure */
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
                        r0 = com.facebook.pages.data.graphql.pageheader.FetchPageHeaderGraphQLModels.PageCallToActionDataModel.PageCallToActionModel.FormFieldsModel.class;
                        r1 = new com.facebook.pages.data.graphql.pageheader.FetchPageHeaderGraphQLModels$PageCallToActionDataModel$PageCallToActionModel$FormFieldsModel$Deserializer;
                        r1.<init>();
                        com.facebook.common.json.GlobalAutoGenDeserializerCache.a(r0, r1);
                        return;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.pages.data.graphql.pageheader.FetchPageHeaderGraphQLModels.PageCallToActionDataModel.PageCallToActionModel.FormFieldsModel.Deserializer.<clinit>():void");
                    }

                    public java.lang.Object m21004a(com.fasterxml.jackson.core.JsonParser r11, com.fasterxml.jackson.databind.DeserializationContext r12) {
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
                        r5 = com.facebook.pages.data.graphql.pageheader.FetchPageHeaderGraphQLParsers.PageCallToActionDataParser.PageCallToActionParser.FormFieldsParser.m21247a(r11, r4);
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
                        r1 = new com.facebook.pages.data.graphql.pageheader.FetchPageHeaderGraphQLModels$PageCallToActionDataModel$PageCallToActionModel$FormFieldsModel;
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
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.pages.data.graphql.pageheader.FetchPageHeaderGraphQLModels.PageCallToActionDataModel.PageCallToActionModel.FormFieldsModel.Deserializer.a(com.fasterxml.jackson.core.JsonParser, com.fasterxml.jackson.databind.DeserializationContext):java.lang.Object");
                    }
                }

                /* compiled from: confirmation_change_contactpoint_failure */
                public class Serializer extends JsonSerializer<FormFieldsModel> {
                    public final void m21005a(java.lang.Object r8, com.fasterxml.jackson.core.JsonGenerator r9, com.fasterxml.jackson.databind.SerializerProvider r10) {
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
                        r8 = (com.facebook.pages.data.graphql.pageheader.FetchPageHeaderGraphQLModels.PageCallToActionDataModel.PageCallToActionModel.FormFieldsModel) r8;
                        r2 = 0;
                        r0 = r8.w_();
                        if (r0 != 0) goto L_0x0035;
                    L_0x0009:
                        r0 = new com.facebook.flatbuffers.FlatBufferBuilder;
                        r1 = 128; // 0x80 float:1.794E-43 double:6.32E-322;
                        r0.<init>(r1);
                        r1 = r8.m21006a(r0);
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
                        com.facebook.pages.data.graphql.pageheader.FetchPageHeaderGraphQLParsers.PageCallToActionDataParser.PageCallToActionParser.FormFieldsParser.m21248a(r0, r1, r9, r10);
                        return;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.pages.data.graphql.pageheader.FetchPageHeaderGraphQLModels.PageCallToActionDataModel.PageCallToActionModel.FormFieldsModel.Serializer.a(java.lang.Object, com.fasterxml.jackson.core.JsonGenerator, com.fasterxml.jackson.databind.SerializerProvider):void");
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
                        r0 = com.facebook.pages.data.graphql.pageheader.FetchPageHeaderGraphQLModels.PageCallToActionDataModel.PageCallToActionModel.FormFieldsModel.class;
                        r1 = new com.facebook.pages.data.graphql.pageheader.FetchPageHeaderGraphQLModels$PageCallToActionDataModel$PageCallToActionModel$FormFieldsModel$Serializer;
                        r1.<init>();
                        com.facebook.common.json.FbSerializerProvider.a(r0, r1);
                        return;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.pages.data.graphql.pageheader.FetchPageHeaderGraphQLModels.PageCallToActionDataModel.PageCallToActionModel.FormFieldsModel.Serializer.<clinit>():void");
                    }
                }

                public FormFieldsModel() {
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
                    r0 = 1;
                    r1.<init>(r0);
                    return;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.pages.data.graphql.pageheader.FetchPageHeaderGraphQLModels.PageCallToActionDataModel.PageCallToActionModel.FormFieldsModel.<init>():void");
                }

                @javax.annotation.Nonnull
                public final com.google.common.collect.ImmutableList<com.facebook.pages.common.surface.calltoaction.graphql.PageAdminCallToActionGraphQLModels.CallToActionConfigFieldsModel> m21008a() {
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
                    r0 = r3.f17212d;
                    r1 = 0;
                    r2 = com.facebook.pages.common.surface.calltoaction.graphql.PageAdminCallToActionGraphQLModels.CallToActionConfigFieldsModel.class;
                    r0 = super.a(r0, r1, r2);
                    r3.f17212d = r0;
                    r0 = r3.f17212d;
                    r0 = (com.google.common.collect.ImmutableList) r0;
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.pages.data.graphql.pageheader.FetchPageHeaderGraphQLModels.PageCallToActionDataModel.PageCallToActionModel.FormFieldsModel.a():com.google.common.collect.ImmutableList<com.facebook.pages.common.surface.calltoaction.graphql.PageAdminCallToActionGraphQLModels$CallToActionConfigFieldsModel>");
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
                    r0 = 2051369175; // 0x7a4568d7 float:2.5625222E35 double:1.0135110363E-314;
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.pages.data.graphql.pageheader.FetchPageHeaderGraphQLModels.PageCallToActionDataModel.PageCallToActionModel.FormFieldsModel.jK_():int");
                }

                public final com.facebook.graphql.visitor.GraphQLVisitableModel m21007a(com.facebook.graphql.visitor.GraphQLModelMutatingVisitor r3) {
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
                    r1 = r2.m21008a();
                    if (r1 == 0) goto L_0x0020;
                L_0x000a:
                    r1 = r2.m21008a();
                    r1 = com.facebook.graphql.modelutil.ModelHelper.a(r1, r3);
                    if (r1 == 0) goto L_0x0020;
                L_0x0014:
                    r0 = com.facebook.graphql.modelutil.ModelHelper.a(r0, r2);
                    r0 = (com.facebook.pages.data.graphql.pageheader.FetchPageHeaderGraphQLModels.PageCallToActionDataModel.PageCallToActionModel.FormFieldsModel) r0;
                    r1 = r1.b();
                    r0.f17212d = r1;
                L_0x0020:
                    r2.i();
                    if (r0 != 0) goto L_0x0026;
                L_0x0025:
                    return r2;
                L_0x0026:
                    r2 = r0;
                    goto L_0x0025;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.pages.data.graphql.pageheader.FetchPageHeaderGraphQLModels.PageCallToActionDataModel.PageCallToActionModel.FormFieldsModel.a(com.facebook.graphql.visitor.GraphQLModelMutatingVisitor):com.facebook.graphql.visitor.GraphQLVisitableModel");
                }

                public final int m21006a(com.facebook.flatbuffers.FlatBufferBuilder r3) {
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
                    r2.h();
                    r0 = r2.m21008a();
                    r0 = com.facebook.graphql.modelutil.ModelHelper.a(r3, r0);
                    r1 = 1;
                    r3.c(r1);
                    r1 = 0;
                    r3.b(r1, r0);
                    r2.i();
                    r0 = r3.d();
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.pages.data.graphql.pageheader.FetchPageHeaderGraphQLModels.PageCallToActionDataModel.PageCallToActionModel.FormFieldsModel.a(com.facebook.flatbuffers.FlatBufferBuilder):int");
                }
            }

            /* compiled from: confirmation_change_contactpoint_failure */
            public class Serializer extends JsonSerializer<PageCallToActionModel> {
                public final void m21009a(java.lang.Object r8, com.fasterxml.jackson.core.JsonGenerator r9, com.fasterxml.jackson.databind.SerializerProvider r10) {
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
                    r8 = (com.facebook.pages.data.graphql.pageheader.FetchPageHeaderGraphQLModels.PageCallToActionDataModel.PageCallToActionModel) r8;
                    r2 = 0;
                    r0 = r8.w_();
                    if (r0 != 0) goto L_0x0035;
                L_0x0009:
                    r0 = new com.facebook.flatbuffers.FlatBufferBuilder;
                    r1 = 128; // 0x80 float:1.794E-43 double:6.32E-322;
                    r0.<init>(r1);
                    r1 = r8.m21012a(r0);
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
                    com.facebook.pages.data.graphql.pageheader.FetchPageHeaderGraphQLParsers.PageCallToActionDataParser.PageCallToActionParser.m21250a(r0, r1, r9, r10);
                    return;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.pages.data.graphql.pageheader.FetchPageHeaderGraphQLModels.PageCallToActionDataModel.PageCallToActionModel.Serializer.a(java.lang.Object, com.fasterxml.jackson.core.JsonGenerator, com.fasterxml.jackson.databind.SerializerProvider):void");
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
                    r0 = com.facebook.pages.data.graphql.pageheader.FetchPageHeaderGraphQLModels.PageCallToActionDataModel.PageCallToActionModel.class;
                    r1 = new com.facebook.pages.data.graphql.pageheader.FetchPageHeaderGraphQLModels$PageCallToActionDataModel$PageCallToActionModel$Serializer;
                    r1.<init>();
                    com.facebook.common.json.FbSerializerProvider.a(r0, r1);
                    return;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.pages.data.graphql.pageheader.FetchPageHeaderGraphQLModels.PageCallToActionDataModel.PageCallToActionModel.Serializer.<clinit>():void");
                }
            }

            @javax.annotation.Nullable
            public final /* synthetic */ com.facebook.pages.data.graphql.pageheader.FetchPageHeaderGraphQLModels.PageCallToActionDataModel.PageCallToActionModel.FormFieldsModel m21020j() {
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
                r0 = r1.m21010q();
                return r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.pages.data.graphql.pageheader.FetchPageHeaderGraphQLModels.PageCallToActionDataModel.PageCallToActionModel.j():com.facebook.pages.data.graphql.pageheader.FetchPageHeaderGraphQLModels$PageCallToActionDataModel$PageCallToActionModel$FormFieldsModel");
            }

            @javax.annotation.Nullable
            public final /* synthetic */ com.facebook.pages.data.graphql.pageheader.FetchPageHeaderGraphQLModels.PageCallToActionDataModel.PageCallToActionModel.CtaAdminInfoModel kD_() {
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
                r0 = r1.m21025o();
                return r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.pages.data.graphql.pageheader.FetchPageHeaderGraphQLModels.PageCallToActionDataModel.PageCallToActionModel.kD_():com.facebook.pages.data.graphql.pageheader.FetchPageHeaderGraphQLModels$PageCallToActionDataModel$PageCallToActionModel$CtaAdminInfoModel");
            }

            @javax.annotation.Nullable
            public final /* synthetic */ com.facebook.pages.common.surface.calltoaction.graphql.PageAdminCallToActionGraphQLModels.PhoneNumberCommonFieldsModel m21024n() {
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
                r0 = r1.m21026p();
                return r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.pages.data.graphql.pageheader.FetchPageHeaderGraphQLModels.PageCallToActionDataModel.PageCallToActionModel.n():com.facebook.pages.common.surface.calltoaction.graphql.PageAdminCallToActionGraphQLModels$PhoneNumberCommonFieldsModel");
            }

            public PageCallToActionModel() {
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
                r0 = 13;
                r1.<init>(r0);
                return;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.pages.data.graphql.pageheader.FetchPageHeaderGraphQLModels.PageCallToActionDataModel.PageCallToActionModel.<init>():void");
            }

            @javax.annotation.Nullable
            public final java.lang.String m21016b() {
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
                r0 = r2.f17213d;
                r1 = 0;
                r0 = super.a(r0, r1);
                r2.f17213d = r0;
                r0 = r2.f17213d;
                return r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.pages.data.graphql.pageheader.FetchPageHeaderGraphQLModels.PageCallToActionDataModel.PageCallToActionModel.b():java.lang.String");
            }

            @javax.annotation.Nullable
            public final java.lang.String m21017c() {
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
                r0 = r2.f17214e;
                r1 = 1;
                r0 = super.a(r0, r1);
                r2.f17214e = r0;
                r0 = r2.f17214e;
                return r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.pages.data.graphql.pageheader.FetchPageHeaderGraphQLModels.PageCallToActionDataModel.PageCallToActionModel.c():java.lang.String");
            }

            public final boolean m21018d() {
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
                r0 = r2.f17215f;
                return r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.pages.data.graphql.pageheader.FetchPageHeaderGraphQLModels.PageCallToActionDataModel.PageCallToActionModel.d():boolean");
            }

            @javax.annotation.Nullable
            public final com.facebook.pages.data.graphql.pageheader.FetchPageHeaderGraphQLModels.PageCallToActionDataModel.PageCallToActionModel.CtaAdminInfoModel m21025o() {
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
                r0 = r3.f17216g;
                r1 = 3;
                r2 = com.facebook.pages.data.graphql.pageheader.FetchPageHeaderGraphQLModels.PageCallToActionDataModel.PageCallToActionModel.CtaAdminInfoModel.class;
                r0 = super.a(r0, r1, r2);
                r0 = (com.facebook.pages.data.graphql.pageheader.FetchPageHeaderGraphQLModels.PageCallToActionDataModel.PageCallToActionModel.CtaAdminInfoModel) r0;
                r3.f17216g = r0;
                r0 = r3.f17216g;
                return r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.pages.data.graphql.pageheader.FetchPageHeaderGraphQLModels.PageCallToActionDataModel.PageCallToActionModel.o():com.facebook.pages.data.graphql.pageheader.FetchPageHeaderGraphQLModels$PageCallToActionDataModel$PageCallToActionModel$CtaAdminInfoModel");
            }

            @javax.annotation.Nullable
            public final com.facebook.graphql.enums.GraphQLPageCallToActionType m21019g() {
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
                r4 = this;
                r0 = r4.f17217h;
                r1 = 4;
                r2 = com.facebook.graphql.enums.GraphQLPageCallToActionType.class;
                r3 = com.facebook.graphql.enums.GraphQLPageCallToActionType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
                r0 = super.b(r0, r1, r2, r3);
                r0 = (com.facebook.graphql.enums.GraphQLPageCallToActionType) r0;
                r4.f17217h = r0;
                r0 = r4.f17217h;
                return r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.pages.data.graphql.pageheader.FetchPageHeaderGraphQLModels.PageCallToActionDataModel.PageCallToActionModel.g():com.facebook.graphql.enums.GraphQLPageCallToActionType");
            }

            @javax.annotation.Nullable
            public final java.lang.String kB_() {
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
                r0 = r2.f17218i;
                r1 = 5;
                r0 = super.a(r0, r1);
                r2.f17218i = r0;
                r0 = r2.f17218i;
                return r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.pages.data.graphql.pageheader.FetchPageHeaderGraphQLModels.PageCallToActionDataModel.PageCallToActionModel.kB_():java.lang.String");
            }

            @javax.annotation.Nullable
            public final java.lang.String kC_() {
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
                r0 = r2.f17219j;
                r1 = 6;
                r0 = super.a(r0, r1);
                r2.f17219j = r0;
                r0 = r2.f17219j;
                return r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.pages.data.graphql.pageheader.FetchPageHeaderGraphQLModels.PageCallToActionDataModel.PageCallToActionModel.kC_():java.lang.String");
            }

            @javax.annotation.Nullable
            private com.facebook.pages.data.graphql.pageheader.FetchPageHeaderGraphQLModels.PageCallToActionDataModel.PageCallToActionModel.FormFieldsModel m21010q() {
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
                r0 = r3.f17220k;
                r1 = 7;
                r2 = com.facebook.pages.data.graphql.pageheader.FetchPageHeaderGraphQLModels.PageCallToActionDataModel.PageCallToActionModel.FormFieldsModel.class;
                r0 = super.a(r0, r1, r2);
                r0 = (com.facebook.pages.data.graphql.pageheader.FetchPageHeaderGraphQLModels.PageCallToActionDataModel.PageCallToActionModel.FormFieldsModel) r0;
                r3.f17220k = r0;
                r0 = r3.f17220k;
                return r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.pages.data.graphql.pageheader.FetchPageHeaderGraphQLModels.PageCallToActionDataModel.PageCallToActionModel.q():com.facebook.pages.data.graphql.pageheader.FetchPageHeaderGraphQLModels$PageCallToActionDataModel$PageCallToActionModel$FormFieldsModel");
            }

            @javax.annotation.Nullable
            public final java.lang.String m21021k() {
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
                r0 = r2.f17221l;
                r1 = 8;
                r0 = super.a(r0, r1);
                r2.f17221l = r0;
                r0 = r2.f17221l;
                return r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.pages.data.graphql.pageheader.FetchPageHeaderGraphQLModels.PageCallToActionDataModel.PageCallToActionModel.k():java.lang.String");
            }

            public final boolean m21022l() {
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
                r1.a(r0, r0);
                r0 = r1.f17222m;
                return r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.pages.data.graphql.pageheader.FetchPageHeaderGraphQLModels.PageCallToActionDataModel.PageCallToActionModel.l():boolean");
            }

            @javax.annotation.Nullable
            public final java.lang.String m21023m() {
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
                r0 = r2.f17223n;
                r1 = 10;
                r0 = super.a(r0, r1);
                r2.f17223n = r0;
                r0 = r2.f17223n;
                return r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.pages.data.graphql.pageheader.FetchPageHeaderGraphQLModels.PageCallToActionDataModel.PageCallToActionModel.m():java.lang.String");
            }

            @javax.annotation.Nullable
            public final com.facebook.pages.common.surface.calltoaction.graphql.PageAdminCallToActionGraphQLModels.PhoneNumberCommonFieldsModel m21026p() {
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
                r0 = r3.f17224o;
                r1 = 11;
                r2 = com.facebook.pages.common.surface.calltoaction.graphql.PageAdminCallToActionGraphQLModels.PhoneNumberCommonFieldsModel.class;
                r0 = super.a(r0, r1, r2);
                r0 = (com.facebook.pages.common.surface.calltoaction.graphql.PageAdminCallToActionGraphQLModels.PhoneNumberCommonFieldsModel) r0;
                r3.f17224o = r0;
                r0 = r3.f17224o;
                return r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.pages.data.graphql.pageheader.FetchPageHeaderGraphQLModels.PageCallToActionDataModel.PageCallToActionModel.p():com.facebook.pages.common.surface.calltoaction.graphql.PageAdminCallToActionGraphQLModels$PhoneNumberCommonFieldsModel");
            }

            @javax.annotation.Nullable
            private java.lang.String m21011r() {
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
                r0 = r2.f17225p;
                r1 = 12;
                r0 = super.a(r0, r1);
                r2.f17225p = r0;
                r0 = r2.f17225p;
                return r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.pages.data.graphql.pageheader.FetchPageHeaderGraphQLModels.PageCallToActionDataModel.PageCallToActionModel.r():java.lang.String");
            }

            @javax.annotation.Nullable
            public final java.lang.String m21014a() {
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
                r0 = r1.m21021k();
                return r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.pages.data.graphql.pageheader.FetchPageHeaderGraphQLModels.PageCallToActionDataModel.PageCallToActionModel.a():java.lang.String");
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
                r0 = 133279070; // 0x7f1ad5e float:3.6363546E-34 double:6.584861E-316;
                return r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.pages.data.graphql.pageheader.FetchPageHeaderGraphQLModels.PageCallToActionDataModel.PageCallToActionModel.jK_():int");
            }

            public final com.facebook.graphql.visitor.GraphQLVisitableModel m21013a(com.facebook.graphql.visitor.GraphQLModelMutatingVisitor r4) {
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
                r0 = r3.m21025o();
                if (r0 == 0) goto L_0x0022;
            L_0x000a:
                r0 = r3.m21025o();
                r0 = r4.b(r0);
                r0 = (com.facebook.pages.data.graphql.pageheader.FetchPageHeaderGraphQLModels.PageCallToActionDataModel.PageCallToActionModel.CtaAdminInfoModel) r0;
                r2 = r3.m21025o();
                if (r2 == r0) goto L_0x0022;
            L_0x001a:
                r1 = com.facebook.graphql.modelutil.ModelHelper.a(r1, r3);
                r1 = (com.facebook.pages.data.graphql.pageheader.FetchPageHeaderGraphQLModels.PageCallToActionDataModel.PageCallToActionModel) r1;
                r1.f17216g = r0;
            L_0x0022:
                r0 = r3.m21010q();
                if (r0 == 0) goto L_0x0040;
            L_0x0028:
                r0 = r3.m21010q();
                r0 = r4.b(r0);
                r0 = (com.facebook.pages.data.graphql.pageheader.FetchPageHeaderGraphQLModels.PageCallToActionDataModel.PageCallToActionModel.FormFieldsModel) r0;
                r2 = r3.m21010q();
                if (r2 == r0) goto L_0x0040;
            L_0x0038:
                r1 = com.facebook.graphql.modelutil.ModelHelper.a(r1, r3);
                r1 = (com.facebook.pages.data.graphql.pageheader.FetchPageHeaderGraphQLModels.PageCallToActionDataModel.PageCallToActionModel) r1;
                r1.f17220k = r0;
            L_0x0040:
                r0 = r3.m21026p();
                if (r0 == 0) goto L_0x005e;
            L_0x0046:
                r0 = r3.m21026p();
                r0 = r4.b(r0);
                r0 = (com.facebook.pages.common.surface.calltoaction.graphql.PageAdminCallToActionGraphQLModels.PhoneNumberCommonFieldsModel) r0;
                r2 = r3.m21026p();
                if (r2 == r0) goto L_0x005e;
            L_0x0056:
                r1 = com.facebook.graphql.modelutil.ModelHelper.a(r1, r3);
                r1 = (com.facebook.pages.data.graphql.pageheader.FetchPageHeaderGraphQLModels.PageCallToActionDataModel.PageCallToActionModel) r1;
                r1.f17224o = r0;
            L_0x005e:
                r3.i();
                if (r1 != 0) goto L_0x0064;
            L_0x0063:
                return r3;
            L_0x0064:
                r3 = r1;
                goto L_0x0063;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.pages.data.graphql.pageheader.FetchPageHeaderGraphQLModels.PageCallToActionDataModel.PageCallToActionModel.a(com.facebook.graphql.visitor.GraphQLModelMutatingVisitor):com.facebook.graphql.visitor.GraphQLVisitableModel");
            }

            public final int m21012a(com.facebook.flatbuffers.FlatBufferBuilder r13) {
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
                r12 = this;
                r12.h();
                r0 = r12.m21016b();
                r0 = r13.b(r0);
                r1 = r12.m21017c();
                r1 = r13.b(r1);
                r2 = r12.m21025o();
                r2 = com.facebook.graphql.modelutil.ModelHelper.a(r13, r2);
                r3 = r12.m21019g();
                r3 = r13.a(r3);
                r4 = r12.kB_();
                r4 = r13.b(r4);
                r5 = r12.kC_();
                r5 = r13.b(r5);
                r6 = r12.m21010q();
                r6 = com.facebook.graphql.modelutil.ModelHelper.a(r13, r6);
                r7 = r12.m21021k();
                r7 = r13.b(r7);
                r8 = r12.m21023m();
                r8 = r13.b(r8);
                r9 = r12.m21026p();
                r9 = com.facebook.graphql.modelutil.ModelHelper.a(r13, r9);
                r10 = r12.m21011r();
                r10 = r13.b(r10);
                r11 = 13;
                r13.c(r11);
                r11 = 0;
                r13.b(r11, r0);
                r0 = 1;
                r13.b(r0, r1);
                r0 = 2;
                r1 = r12.f17215f;
                r13.a(r0, r1);
                r0 = 3;
                r13.b(r0, r2);
                r0 = 4;
                r13.b(r0, r3);
                r0 = 5;
                r13.b(r0, r4);
                r0 = 6;
                r13.b(r0, r5);
                r0 = 7;
                r13.b(r0, r6);
                r0 = 8;
                r13.b(r0, r7);
                r0 = 9;
                r1 = r12.f17222m;
                r13.a(r0, r1);
                r0 = 10;
                r13.b(r0, r8);
                r0 = 11;
                r13.b(r0, r9);
                r0 = 12;
                r13.b(r0, r10);
                r12.i();
                r0 = r13.d();
                return r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.pages.data.graphql.pageheader.FetchPageHeaderGraphQLModels.PageCallToActionDataModel.PageCallToActionModel.a(com.facebook.flatbuffers.FlatBufferBuilder):int");
            }

            public final void m21015a(com.facebook.flatbuffers.MutableFlatBuffer r2, int r3, java.lang.Object r4) {
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
                super.a(r2, r3, r4);
                r0 = 2;
                r0 = r2.a(r3, r0);
                r1.f17215f = r0;
                r0 = 9;
                r0 = r2.a(r3, r0);
                r1.f17222m = r0;
                return;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.pages.data.graphql.pageheader.FetchPageHeaderGraphQLModels.PageCallToActionDataModel.PageCallToActionModel.a(com.facebook.flatbuffers.MutableFlatBuffer, int, java.lang.Object):void");
            }
        }

        /* compiled from: confirmation_change_contactpoint_failure */
        public class Serializer extends JsonSerializer<PageCallToActionDataModel> {
            public final void m21027a(java.lang.Object r9, com.fasterxml.jackson.core.JsonGenerator r10, com.fasterxml.jackson.databind.SerializerProvider r11) {
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
                r9 = (com.facebook.pages.data.graphql.pageheader.FetchPageHeaderGraphQLModels.PageCallToActionDataModel) r9;
                r2 = 0;
                r0 = r9.w_();
                if (r0 != 0) goto L_0x0035;
            L_0x0009:
                r0 = new com.facebook.flatbuffers.FlatBufferBuilder;
                r1 = 128; // 0x80 float:1.794E-43 double:6.32E-322;
                r0.<init>(r1);
                r1 = r9.m21029a(r0);
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
                r10.f();
                r6 = 0;
                r6 = r0.g(r1, r6);
                if (r6 == 0) goto L_0x004f;
            L_0x0047:
                r7 = "page_call_to_action";
                r10.a(r7);
                com.facebook.pages.data.graphql.pageheader.FetchPageHeaderGraphQLParsers.PageCallToActionDataParser.PageCallToActionParser.m21250a(r0, r6, r10, r11);
            L_0x004f:
                r10.g();
                return;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.pages.data.graphql.pageheader.FetchPageHeaderGraphQLModels.PageCallToActionDataModel.Serializer.a(java.lang.Object, com.fasterxml.jackson.core.JsonGenerator, com.fasterxml.jackson.databind.SerializerProvider):void");
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
                r0 = com.facebook.pages.data.graphql.pageheader.FetchPageHeaderGraphQLModels.PageCallToActionDataModel.class;
                r1 = new com.facebook.pages.data.graphql.pageheader.FetchPageHeaderGraphQLModels$PageCallToActionDataModel$Serializer;
                r1.<init>();
                com.facebook.common.json.FbSerializerProvider.a(r0, r1);
                return;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.pages.data.graphql.pageheader.FetchPageHeaderGraphQLModels.PageCallToActionDataModel.Serializer.<clinit>():void");
            }
        }

        public PageCallToActionDataModel() {
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
            r0 = 1;
            r1.<init>(r0);
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.pages.data.graphql.pageheader.FetchPageHeaderGraphQLModels.PageCallToActionDataModel.<init>():void");
        }

        public final void m21031a(java.lang.String r1, com.facebook.graphql.visitor.ConsistencyTuple r2) {
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
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.pages.data.graphql.pageheader.FetchPageHeaderGraphQLModels.PageCallToActionDataModel.a(java.lang.String, com.facebook.graphql.visitor.ConsistencyTuple):void");
        }

        public final void m21032a(java.lang.String r1, java.lang.Object r2, boolean r3) {
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
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.pages.data.graphql.pageheader.FetchPageHeaderGraphQLModels.PageCallToActionDataModel.a(java.lang.String, java.lang.Object, boolean):void");
        }

        @javax.annotation.Nullable
        private com.facebook.pages.data.graphql.pageheader.FetchPageHeaderGraphQLModels.PageCallToActionDataModel.PageCallToActionModel m21028a() {
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
            r0 = r3.f17226d;
            r1 = 0;
            r2 = com.facebook.pages.data.graphql.pageheader.FetchPageHeaderGraphQLModels.PageCallToActionDataModel.PageCallToActionModel.class;
            r0 = super.a(r0, r1, r2);
            r0 = (com.facebook.pages.data.graphql.pageheader.FetchPageHeaderGraphQLModels.PageCallToActionDataModel.PageCallToActionModel) r0;
            r3.f17226d = r0;
            r0 = r3.f17226d;
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.pages.data.graphql.pageheader.FetchPageHeaderGraphQLModels.PageCallToActionDataModel.a():com.facebook.pages.data.graphql.pageheader.FetchPageHeaderGraphQLModels$PageCallToActionDataModel$PageCallToActionModel");
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
            r0 = 2479791; // 0x25d6af float:3.474927E-39 double:1.2251795E-317;
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.pages.data.graphql.pageheader.FetchPageHeaderGraphQLModels.PageCallToActionDataModel.jK_():int");
        }

        public final com.facebook.graphql.visitor.GraphQLVisitableModel m21030a(com.facebook.graphql.visitor.GraphQLModelMutatingVisitor r4) {
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
            r0 = r3.m21028a();
            if (r0 == 0) goto L_0x0022;
        L_0x000a:
            r0 = r3.m21028a();
            r0 = r4.b(r0);
            r0 = (com.facebook.pages.data.graphql.pageheader.FetchPageHeaderGraphQLModels.PageCallToActionDataModel.PageCallToActionModel) r0;
            r2 = r3.m21028a();
            if (r2 == r0) goto L_0x0022;
        L_0x001a:
            r1 = com.facebook.graphql.modelutil.ModelHelper.a(r1, r3);
            r1 = (com.facebook.pages.data.graphql.pageheader.FetchPageHeaderGraphQLModels.PageCallToActionDataModel) r1;
            r1.f17226d = r0;
        L_0x0022:
            r3.i();
            if (r1 != 0) goto L_0x0028;
        L_0x0027:
            return r3;
        L_0x0028:
            r3 = r1;
            goto L_0x0027;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.pages.data.graphql.pageheader.FetchPageHeaderGraphQLModels.PageCallToActionDataModel.a(com.facebook.graphql.visitor.GraphQLModelMutatingVisitor):com.facebook.graphql.visitor.GraphQLVisitableModel");
        }

        public final int m21029a(com.facebook.flatbuffers.FlatBufferBuilder r3) {
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
            r2.h();
            r0 = r2.m21028a();
            r0 = com.facebook.graphql.modelutil.ModelHelper.a(r3, r0);
            r1 = 1;
            r3.c(r1);
            r1 = 0;
            r3.b(r1, r0);
            r2.i();
            r0 = r3.d();
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.pages.data.graphql.pageheader.FetchPageHeaderGraphQLModels.PageCallToActionDataModel.a(com.facebook.flatbuffers.FlatBufferBuilder):int");
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 1710049818)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: confirmation_change_contactpoint_failure */
    public final class PageGeneralDataModel extends BaseModel implements GraphQLVisitableConsistentModel {
        @Nullable
        private List<AttributionModel> f17233d;
        @Nullable
        private List<String> f17234e;
        @Nullable
        private CoverPhotoModel f17235f;
        private boolean f17236g;
        private boolean f17237h;
        private boolean f17238i;
        private boolean f17239j;
        private boolean f17240k;
        @Nullable
        private String f17241l;
        @Nullable
        private ProfilePictureAsCoverModel f17242m;
        @Nullable
        private PageHeaderDataProfilePhotoModel f17243n;
        @Nullable
        private DefaultImageFieldsModel f17244o;
        private boolean f17245p;
        @Nullable
        private List<RedirectionInfoModel> f17246q;
        private boolean f17247r;
        @Nullable
        private GraphQLPageSuperCategoryType f17248s;
        @Nullable
        private String f17249t;
        @Nullable
        private GraphQLPageVerificationBadge f17250u;
        @Nullable
        private List<String> f17251v;

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1232026915)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: confirmation_change_contactpoint_failure */
        public final class AttributionModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private String f17227d;
            @Nullable
            private GraphQLAttributionSource f17228e;

            /* compiled from: confirmation_change_contactpoint_failure */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(AttributionModel.class, new Deserializer());
                }

                public Object m21033a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(AttributionParser.m21255b(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object attributionModel = new AttributionModel();
                    ((BaseModel) attributionModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (attributionModel instanceof Postprocessable) {
                        return ((Postprocessable) attributionModel).a();
                    }
                    return attributionModel;
                }
            }

            /* compiled from: confirmation_change_contactpoint_failure */
            public class Serializer extends JsonSerializer<AttributionModel> {
                public final void m21034a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    AttributionModel attributionModel = (AttributionModel) obj;
                    if (attributionModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(attributionModel.m21036a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        attributionModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    AttributionParser.m21253a(attributionModel.w_(), attributionModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(AttributionModel.class, new Serializer());
                }
            }

            public AttributionModel() {
                super(2);
            }

            @Nullable
            private String m21035j() {
                this.f17227d = super.a(this.f17227d, 0);
                return this.f17227d;
            }

            @Nullable
            public final GraphQLAttributionSource m21037a() {
                this.f17228e = (GraphQLAttributionSource) super.b(this.f17228e, 1, GraphQLAttributionSource.class, GraphQLAttributionSource.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
                return this.f17228e;
            }

            public final int jK_() {
                return -751942829;
            }

            public final GraphQLVisitableModel m21038a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m21036a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m21035j());
                int a = flatBufferBuilder.a(m21037a());
                flatBufferBuilder.c(2);
                flatBufferBuilder.b(0, b);
                flatBufferBuilder.b(1, a);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: confirmation_change_contactpoint_failure */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(PageGeneralDataModel.class, new Deserializer());
            }

            public Object m21039a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(PageGeneralDataParser.m21262a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object pageGeneralDataModel = new PageGeneralDataModel();
                ((BaseModel) pageGeneralDataModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (pageGeneralDataModel instanceof Postprocessable) {
                    return ((Postprocessable) pageGeneralDataModel).a();
                }
                return pageGeneralDataModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1336971586)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: confirmation_change_contactpoint_failure */
        public final class RedirectionInfoModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private NodeModel f17232d;

            /* compiled from: confirmation_change_contactpoint_failure */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(RedirectionInfoModel.class, new Deserializer());
                }

                public Object m21040a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(RedirectionInfoParser.m21260b(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object redirectionInfoModel = new RedirectionInfoModel();
                    ((BaseModel) redirectionInfoModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (redirectionInfoModel instanceof Postprocessable) {
                        return ((Postprocessable) redirectionInfoModel).a();
                    }
                    return redirectionInfoModel;
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = 1255661007)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: confirmation_change_contactpoint_failure */
            public final class NodeModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
                @Nullable
                private GraphQLObjectType f17229d;
                @Nullable
                private String f17230e;
                @Nullable
                private String f17231f;

                /* compiled from: confirmation_change_contactpoint_failure */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(NodeModel.class, new Deserializer());
                    }

                    public Object m21041a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(NodeParser.m21256a(jsonParser, flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                        Object nodeModel = new NodeModel();
                        ((BaseModel) nodeModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                        if (nodeModel instanceof Postprocessable) {
                            return ((Postprocessable) nodeModel).a();
                        }
                        return nodeModel;
                    }
                }

                /* compiled from: confirmation_change_contactpoint_failure */
                public class Serializer extends JsonSerializer<NodeModel> {
                    public final void m21042a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        NodeModel nodeModel = (NodeModel) obj;
                        if (nodeModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(nodeModel.m21045a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            nodeModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        NodeParser.m21257a(nodeModel.w_(), nodeModel.u_(), jsonGenerator);
                    }

                    static {
                        FbSerializerProvider.a(NodeModel.class, new Serializer());
                    }
                }

                public NodeModel() {
                    super(3);
                }

                public final void m21048a(String str, ConsistencyTuple consistencyTuple) {
                    consistencyTuple.a();
                }

                public final void m21049a(String str, Object obj, boolean z) {
                }

                @Nullable
                private GraphQLObjectType m21043k() {
                    if (this.b != null && this.f17229d == null) {
                        this.f17229d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
                    }
                    return this.f17229d;
                }

                @Nullable
                public final String m21050j() {
                    this.f17230e = super.a(this.f17230e, 1);
                    return this.f17230e;
                }

                @Nullable
                private String m21044l() {
                    this.f17231f = super.a(this.f17231f, 2);
                    return this.f17231f;
                }

                @Nullable
                public final String m21047a() {
                    return m21050j();
                }

                public final int jK_() {
                    return 2433570;
                }

                public final GraphQLVisitableModel m21046a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    h();
                    i();
                    return this;
                }

                public final int m21045a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int a = ModelHelper.a(flatBufferBuilder, m21043k());
                    int b = flatBufferBuilder.b(m21050j());
                    int b2 = flatBufferBuilder.b(m21044l());
                    flatBufferBuilder.c(3);
                    flatBufferBuilder.b(0, a);
                    flatBufferBuilder.b(1, b);
                    flatBufferBuilder.b(2, b2);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            /* compiled from: confirmation_change_contactpoint_failure */
            public class Serializer extends JsonSerializer<RedirectionInfoModel> {
                public final void m21051a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    RedirectionInfoModel redirectionInfoModel = (RedirectionInfoModel) obj;
                    if (redirectionInfoModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(redirectionInfoModel.m21052a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        redirectionInfoModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    RedirectionInfoParser.m21261b(redirectionInfoModel.w_(), redirectionInfoModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(RedirectionInfoModel.class, new Serializer());
                }
            }

            public RedirectionInfoModel() {
                super(1);
            }

            @Nullable
            public final NodeModel m21054a() {
                this.f17232d = (NodeModel) super.a(this.f17232d, 0, NodeModel.class);
                return this.f17232d;
            }

            public final int jK_() {
                return -986866342;
            }

            public final GraphQLVisitableModel m21053a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m21054a() != null) {
                    NodeModel nodeModel = (NodeModel) graphQLModelMutatingVisitor.b(m21054a());
                    if (m21054a() != nodeModel) {
                        graphQLVisitableModel = (RedirectionInfoModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f17232d = nodeModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m21052a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m21054a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, a);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: confirmation_change_contactpoint_failure */
        public class Serializer extends JsonSerializer<PageGeneralDataModel> {
            public final void m21055a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                PageGeneralDataModel pageGeneralDataModel = (PageGeneralDataModel) obj;
                if (pageGeneralDataModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(pageGeneralDataModel.m21068a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    pageGeneralDataModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                PageGeneralDataParser.m21263a(pageGeneralDataModel.w_(), pageGeneralDataModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(PageGeneralDataModel.class, new Serializer());
            }
        }

        public PageGeneralDataModel() {
            super(19);
        }

        public final void m21071a(String str, ConsistencyTuple consistencyTuple) {
            consistencyTuple.a();
        }

        public final void m21072a(String str, Object obj, boolean z) {
        }

        @Nonnull
        private ImmutableList<AttributionModel> m21056a() {
            this.f17233d = super.a(this.f17233d, 0, AttributionModel.class);
            return (ImmutableList) this.f17233d;
        }

        @Nonnull
        private ImmutableList<String> m21057j() {
            this.f17234e = super.a(this.f17234e, 1);
            return (ImmutableList) this.f17234e;
        }

        @Nullable
        private CoverPhotoModel m21058k() {
            this.f17235f = (CoverPhotoModel) super.a(this.f17235f, 2, CoverPhotoModel.class);
            return this.f17235f;
        }

        @Nullable
        private String m21059l() {
            this.f17241l = super.a(this.f17241l, 8);
            return this.f17241l;
        }

        @Nullable
        private ProfilePictureAsCoverModel m21060m() {
            this.f17242m = (ProfilePictureAsCoverModel) super.a(this.f17242m, 9, ProfilePictureAsCoverModel.class);
            return this.f17242m;
        }

        @Nullable
        private PageHeaderDataProfilePhotoModel m21061n() {
            this.f17243n = (PageHeaderDataProfilePhotoModel) super.a(this.f17243n, 10, PageHeaderDataProfilePhotoModel.class);
            return this.f17243n;
        }

        @Nullable
        private DefaultImageFieldsModel m21062o() {
            this.f17244o = (DefaultImageFieldsModel) super.a(this.f17244o, 11, DefaultImageFieldsModel.class);
            return this.f17244o;
        }

        @Nonnull
        private ImmutableList<RedirectionInfoModel> m21063p() {
            this.f17246q = super.a(this.f17246q, 13, RedirectionInfoModel.class);
            return (ImmutableList) this.f17246q;
        }

        @Nullable
        private GraphQLPageSuperCategoryType m21064q() {
            this.f17248s = (GraphQLPageSuperCategoryType) super.b(this.f17248s, 15, GraphQLPageSuperCategoryType.class, GraphQLPageSuperCategoryType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
            return this.f17248s;
        }

        @Nullable
        private String m21065r() {
            this.f17249t = super.a(this.f17249t, 16);
            return this.f17249t;
        }

        @Nullable
        private GraphQLPageVerificationBadge m21066s() {
            this.f17250u = (GraphQLPageVerificationBadge) super.b(this.f17250u, 17, GraphQLPageVerificationBadge.class, GraphQLPageVerificationBadge.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
            return this.f17250u;
        }

        @Nonnull
        private ImmutableList<String> m21067t() {
            this.f17251v = super.a(this.f17251v, 18);
            return (ImmutableList) this.f17251v;
        }

        public final int jK_() {
            return 2479791;
        }

        public final GraphQLVisitableModel m21069a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            PageGeneralDataModel pageGeneralDataModel;
            GraphQLVisitableModel graphQLVisitableModel;
            CoverPhotoModel coverPhotoModel;
            ProfilePictureAsCoverModel profilePictureAsCoverModel;
            PageHeaderDataProfilePhotoModel pageHeaderDataProfilePhotoModel;
            DefaultImageFieldsModel defaultImageFieldsModel;
            Builder a;
            h();
            if (m21056a() != null) {
                Builder a2 = ModelHelper.a(m21056a(), graphQLModelMutatingVisitor);
                if (a2 != null) {
                    pageGeneralDataModel = (PageGeneralDataModel) ModelHelper.a(null, this);
                    pageGeneralDataModel.f17233d = a2.b();
                    graphQLVisitableModel = pageGeneralDataModel;
                    if (m21058k() != null) {
                        coverPhotoModel = (CoverPhotoModel) graphQLModelMutatingVisitor.b(m21058k());
                        if (m21058k() != coverPhotoModel) {
                            graphQLVisitableModel = (PageGeneralDataModel) ModelHelper.a(graphQLVisitableModel, this);
                            graphQLVisitableModel.f17235f = coverPhotoModel;
                        }
                    }
                    if (m21060m() != null) {
                        profilePictureAsCoverModel = (ProfilePictureAsCoverModel) graphQLModelMutatingVisitor.b(m21060m());
                        if (m21060m() != profilePictureAsCoverModel) {
                            graphQLVisitableModel = (PageGeneralDataModel) ModelHelper.a(graphQLVisitableModel, this);
                            graphQLVisitableModel.f17242m = profilePictureAsCoverModel;
                        }
                    }
                    if (m21061n() != null) {
                        pageHeaderDataProfilePhotoModel = (PageHeaderDataProfilePhotoModel) graphQLModelMutatingVisitor.b(m21061n());
                        if (m21061n() != pageHeaderDataProfilePhotoModel) {
                            graphQLVisitableModel = (PageGeneralDataModel) ModelHelper.a(graphQLVisitableModel, this);
                            graphQLVisitableModel.f17243n = pageHeaderDataProfilePhotoModel;
                        }
                    }
                    if (m21062o() != null) {
                        defaultImageFieldsModel = (DefaultImageFieldsModel) graphQLModelMutatingVisitor.b(m21062o());
                        if (m21062o() != defaultImageFieldsModel) {
                            graphQLVisitableModel = (PageGeneralDataModel) ModelHelper.a(graphQLVisitableModel, this);
                            graphQLVisitableModel.f17244o = defaultImageFieldsModel;
                        }
                    }
                    if (m21063p() != null) {
                        a = ModelHelper.a(m21063p(), graphQLModelMutatingVisitor);
                        if (a != null) {
                            pageGeneralDataModel = (PageGeneralDataModel) ModelHelper.a(graphQLVisitableModel, this);
                            pageGeneralDataModel.f17246q = a.b();
                            graphQLVisitableModel = pageGeneralDataModel;
                        }
                    }
                    i();
                    return graphQLVisitableModel != null ? this : graphQLVisitableModel;
                }
            }
            graphQLVisitableModel = null;
            if (m21058k() != null) {
                coverPhotoModel = (CoverPhotoModel) graphQLModelMutatingVisitor.b(m21058k());
                if (m21058k() != coverPhotoModel) {
                    graphQLVisitableModel = (PageGeneralDataModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f17235f = coverPhotoModel;
                }
            }
            if (m21060m() != null) {
                profilePictureAsCoverModel = (ProfilePictureAsCoverModel) graphQLModelMutatingVisitor.b(m21060m());
                if (m21060m() != profilePictureAsCoverModel) {
                    graphQLVisitableModel = (PageGeneralDataModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f17242m = profilePictureAsCoverModel;
                }
            }
            if (m21061n() != null) {
                pageHeaderDataProfilePhotoModel = (PageHeaderDataProfilePhotoModel) graphQLModelMutatingVisitor.b(m21061n());
                if (m21061n() != pageHeaderDataProfilePhotoModel) {
                    graphQLVisitableModel = (PageGeneralDataModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f17243n = pageHeaderDataProfilePhotoModel;
                }
            }
            if (m21062o() != null) {
                defaultImageFieldsModel = (DefaultImageFieldsModel) graphQLModelMutatingVisitor.b(m21062o());
                if (m21062o() != defaultImageFieldsModel) {
                    graphQLVisitableModel = (PageGeneralDataModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f17244o = defaultImageFieldsModel;
                }
            }
            if (m21063p() != null) {
                a = ModelHelper.a(m21063p(), graphQLModelMutatingVisitor);
                if (a != null) {
                    pageGeneralDataModel = (PageGeneralDataModel) ModelHelper.a(graphQLVisitableModel, this);
                    pageGeneralDataModel.f17246q = a.b();
                    graphQLVisitableModel = pageGeneralDataModel;
                }
            }
            i();
            if (graphQLVisitableModel != null) {
            }
        }

        public final int m21068a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m21056a());
            int c = flatBufferBuilder.c(m21057j());
            int a2 = ModelHelper.a(flatBufferBuilder, m21058k());
            int b = flatBufferBuilder.b(m21059l());
            int a3 = ModelHelper.a(flatBufferBuilder, m21060m());
            int a4 = ModelHelper.a(flatBufferBuilder, m21061n());
            int a5 = ModelHelper.a(flatBufferBuilder, m21062o());
            int a6 = ModelHelper.a(flatBufferBuilder, m21063p());
            int a7 = flatBufferBuilder.a(m21064q());
            int b2 = flatBufferBuilder.b(m21065r());
            int a8 = flatBufferBuilder.a(m21066s());
            int c2 = flatBufferBuilder.c(m21067t());
            flatBufferBuilder.c(19);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, c);
            flatBufferBuilder.b(2, a2);
            flatBufferBuilder.a(3, this.f17236g);
            flatBufferBuilder.a(4, this.f17237h);
            flatBufferBuilder.a(5, this.f17238i);
            flatBufferBuilder.a(6, this.f17239j);
            flatBufferBuilder.a(7, this.f17240k);
            flatBufferBuilder.b(8, b);
            flatBufferBuilder.b(9, a3);
            flatBufferBuilder.b(10, a4);
            flatBufferBuilder.b(11, a5);
            flatBufferBuilder.a(12, this.f17245p);
            flatBufferBuilder.b(13, a6);
            flatBufferBuilder.a(14, this.f17247r);
            flatBufferBuilder.b(15, a7);
            flatBufferBuilder.b(16, b2);
            flatBufferBuilder.b(17, a8);
            flatBufferBuilder.b(18, c2);
            i();
            return flatBufferBuilder.d();
        }

        public final void m21070a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
            super.a(mutableFlatBuffer, i, obj);
            this.f17236g = mutableFlatBuffer.a(i, 3);
            this.f17237h = mutableFlatBuffer.a(i, 4);
            this.f17238i = mutableFlatBuffer.a(i, 5);
            this.f17239j = mutableFlatBuffer.a(i, 6);
            this.f17240k = mutableFlatBuffer.a(i, 7);
            this.f17245p = mutableFlatBuffer.a(i, 12);
            this.f17247r = mutableFlatBuffer.a(i, 14);
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 1909295923)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: confirmation_change_contactpoint_failure */
    public final class PageHeaderDataProfilePhotoModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel, SizeAwareMedia {
        @Nullable
        private GraphQLObjectType f17253d;
        @Nullable
        private AlbumModel f17254e;
        @Nullable
        private DefaultVect2FieldsModel f17255f;
        @Nullable
        private String f17256g;
        @Nullable
        private DefaultImageFieldsModel f17257h;
        @Nullable
        private DefaultImageFieldsModel f17258i;
        @Nullable
        private DefaultImageFieldsModel f17259j;
        @Nullable
        private DefaultImageFieldsModel f17260k;
        @Nullable
        private String f17261l;

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 1801334754)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: confirmation_change_contactpoint_failure */
        public final class AlbumModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel {
            @Nullable
            private String f17252d;

            /* compiled from: confirmation_change_contactpoint_failure */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(AlbumModel.class, new Deserializer());
                }

                public Object m21073a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(AlbumParser.m21264a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object albumModel = new AlbumModel();
                    ((BaseModel) albumModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (albumModel instanceof Postprocessable) {
                        return ((Postprocessable) albumModel).a();
                    }
                    return albumModel;
                }
            }

            /* compiled from: confirmation_change_contactpoint_failure */
            public class Serializer extends JsonSerializer<AlbumModel> {
                public final void m21074a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    AlbumModel albumModel = (AlbumModel) obj;
                    if (albumModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(albumModel.m21075a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        albumModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    AlbumParser.m21265a(albumModel.w_(), albumModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(AlbumModel.class, new Serializer());
                }
            }

            public AlbumModel() {
                super(1);
            }

            @Nullable
            public final String m21078j() {
                this.f17252d = super.a(this.f17252d, 0);
                return this.f17252d;
            }

            @Nullable
            public final String m21077a() {
                return m21078j();
            }

            public final int jK_() {
                return 63344207;
            }

            public final GraphQLVisitableModel m21076a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m21075a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m21078j());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, b);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: confirmation_change_contactpoint_failure */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(PageHeaderDataProfilePhotoModel.class, new Deserializer());
            }

            public Object m21079a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(PageHeaderDataProfilePhotoParser.m21266a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object pageHeaderDataProfilePhotoModel = new PageHeaderDataProfilePhotoModel();
                ((BaseModel) pageHeaderDataProfilePhotoModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (pageHeaderDataProfilePhotoModel instanceof Postprocessable) {
                    return ((Postprocessable) pageHeaderDataProfilePhotoModel).a();
                }
                return pageHeaderDataProfilePhotoModel;
            }
        }

        /* compiled from: confirmation_change_contactpoint_failure */
        public class Serializer extends JsonSerializer<PageHeaderDataProfilePhotoModel> {
            public final void m21080a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                PageHeaderDataProfilePhotoModel pageHeaderDataProfilePhotoModel = (PageHeaderDataProfilePhotoModel) obj;
                if (pageHeaderDataProfilePhotoModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(pageHeaderDataProfilePhotoModel.m21083a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    pageHeaderDataProfilePhotoModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                PageHeaderDataProfilePhotoParser.m21267a(pageHeaderDataProfilePhotoModel.w_(), pageHeaderDataProfilePhotoModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(PageHeaderDataProfilePhotoModel.class, new Serializer());
            }
        }

        @Nullable
        public final /* synthetic */ DefaultImageFields bc_() {
            return m21094n();
        }

        @Nullable
        public final /* synthetic */ DefaultImageFields bd_() {
            return m21093m();
        }

        @Nullable
        public final /* synthetic */ DefaultImageFields be_() {
            return m21091k();
        }

        @Nullable
        public final /* synthetic */ DefaultVect2Fields m21087c() {
            return m21081o();
        }

        @Nullable
        public final /* synthetic */ DefaultImageFields m21089g() {
            return m21092l();
        }

        public PageHeaderDataProfilePhotoModel() {
            super(9);
        }

        @Nullable
        public final GraphQLObjectType m21086b() {
            if (this.b != null && this.f17253d == null) {
                this.f17253d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
            }
            return this.f17253d;
        }

        @Nullable
        public final AlbumModel m21090j() {
            this.f17254e = (AlbumModel) super.a(this.f17254e, 1, AlbumModel.class);
            return this.f17254e;
        }

        @Nullable
        private DefaultVect2FieldsModel m21081o() {
            this.f17255f = (DefaultVect2FieldsModel) super.a(this.f17255f, 2, DefaultVect2FieldsModel.class);
            return this.f17255f;
        }

        @Nullable
        public final String m21088d() {
            this.f17256g = super.a(this.f17256g, 3);
            return this.f17256g;
        }

        @Nullable
        public final DefaultImageFieldsModel m21091k() {
            this.f17257h = (DefaultImageFieldsModel) super.a(this.f17257h, 4, DefaultImageFieldsModel.class);
            return this.f17257h;
        }

        @Nullable
        public final DefaultImageFieldsModel m21092l() {
            this.f17258i = (DefaultImageFieldsModel) super.a(this.f17258i, 5, DefaultImageFieldsModel.class);
            return this.f17258i;
        }

        @Nullable
        public final DefaultImageFieldsModel m21093m() {
            this.f17259j = (DefaultImageFieldsModel) super.a(this.f17259j, 6, DefaultImageFieldsModel.class);
            return this.f17259j;
        }

        @Nullable
        public final DefaultImageFieldsModel m21094n() {
            this.f17260k = (DefaultImageFieldsModel) super.a(this.f17260k, 7, DefaultImageFieldsModel.class);
            return this.f17260k;
        }

        @Nullable
        private String m21082p() {
            this.f17261l = super.a(this.f17261l, 8);
            return this.f17261l;
        }

        @Nullable
        public final String m21085a() {
            return m21088d();
        }

        public final int jK_() {
            return 77090322;
        }

        public final GraphQLVisitableModel m21084a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            DefaultImageFieldsModel defaultImageFieldsModel;
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m21090j() != null) {
                AlbumModel albumModel = (AlbumModel) graphQLModelMutatingVisitor.b(m21090j());
                if (m21090j() != albumModel) {
                    graphQLVisitableModel = (PageHeaderDataProfilePhotoModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f17254e = albumModel;
                }
            }
            if (m21081o() != null) {
                DefaultVect2FieldsModel defaultVect2FieldsModel = (DefaultVect2FieldsModel) graphQLModelMutatingVisitor.b(m21081o());
                if (m21081o() != defaultVect2FieldsModel) {
                    graphQLVisitableModel = (PageHeaderDataProfilePhotoModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f17255f = defaultVect2FieldsModel;
                }
            }
            if (m21091k() != null) {
                defaultImageFieldsModel = (DefaultImageFieldsModel) graphQLModelMutatingVisitor.b(m21091k());
                if (m21091k() != defaultImageFieldsModel) {
                    graphQLVisitableModel = (PageHeaderDataProfilePhotoModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f17257h = defaultImageFieldsModel;
                }
            }
            if (m21092l() != null) {
                defaultImageFieldsModel = (DefaultImageFieldsModel) graphQLModelMutatingVisitor.b(m21092l());
                if (m21092l() != defaultImageFieldsModel) {
                    graphQLVisitableModel = (PageHeaderDataProfilePhotoModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f17258i = defaultImageFieldsModel;
                }
            }
            if (m21093m() != null) {
                defaultImageFieldsModel = (DefaultImageFieldsModel) graphQLModelMutatingVisitor.b(m21093m());
                if (m21093m() != defaultImageFieldsModel) {
                    graphQLVisitableModel = (PageHeaderDataProfilePhotoModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f17259j = defaultImageFieldsModel;
                }
            }
            if (m21094n() != null) {
                defaultImageFieldsModel = (DefaultImageFieldsModel) graphQLModelMutatingVisitor.b(m21094n());
                if (m21094n() != defaultImageFieldsModel) {
                    graphQLVisitableModel = (PageHeaderDataProfilePhotoModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f17260k = defaultImageFieldsModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m21083a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m21086b());
            int a2 = ModelHelper.a(flatBufferBuilder, m21090j());
            int a3 = ModelHelper.a(flatBufferBuilder, m21081o());
            int b = flatBufferBuilder.b(m21088d());
            int a4 = ModelHelper.a(flatBufferBuilder, m21091k());
            int a5 = ModelHelper.a(flatBufferBuilder, m21092l());
            int a6 = ModelHelper.a(flatBufferBuilder, m21093m());
            int a7 = ModelHelper.a(flatBufferBuilder, m21094n());
            int b2 = flatBufferBuilder.b(m21082p());
            flatBufferBuilder.c(9);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, a2);
            flatBufferBuilder.b(2, a3);
            flatBufferBuilder.b(3, b);
            flatBufferBuilder.b(4, a4);
            flatBufferBuilder.b(5, a5);
            flatBufferBuilder.b(6, a6);
            flatBufferBuilder.b(7, a7);
            flatBufferBuilder.b(8, b2);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -1904449320)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: confirmation_change_contactpoint_failure */
    public final class PageHeaderMetaboxDataModel extends BaseModel implements GraphQLVisitableConsistentModel {
        @Nullable
        private AddressModel f17264d;
        @Nullable
        private PlaceOpenStatusModel f17265e;
        @Nullable
        private GraphQLPageOpenHoursDisplayDecisionEnum f17266f;

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -2132098501)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: confirmation_change_contactpoint_failure */
        public final class AddressModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private String f17262d;

            /* compiled from: confirmation_change_contactpoint_failure */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(AddressModel.class, new Deserializer());
                }

                public Object m21095a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(AddressParser.m21268a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object addressModel = new AddressModel();
                    ((BaseModel) addressModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (addressModel instanceof Postprocessable) {
                        return ((Postprocessable) addressModel).a();
                    }
                    return addressModel;
                }
            }

            /* compiled from: confirmation_change_contactpoint_failure */
            public class Serializer extends JsonSerializer<AddressModel> {
                public final void m21096a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    AddressModel addressModel = (AddressModel) obj;
                    if (addressModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(addressModel.m21097a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        addressModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    AddressParser.m21269a(addressModel.w_(), addressModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(AddressModel.class, new Serializer());
                }
            }

            public AddressModel() {
                super(1);
            }

            @Nullable
            public final String m21099a() {
                this.f17262d = super.a(this.f17262d, 0);
                return this.f17262d;
            }

            public final int jK_() {
                return 799251025;
            }

            public final GraphQLVisitableModel m21098a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m21097a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m21099a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, b);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: confirmation_change_contactpoint_failure */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(PageHeaderMetaboxDataModel.class, new Deserializer());
            }

            public Object m21100a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = PageHeaderMetaboxDataParser.m21272a(jsonParser);
                Object pageHeaderMetaboxDataModel = new PageHeaderMetaboxDataModel();
                ((BaseModel) pageHeaderMetaboxDataModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (pageHeaderMetaboxDataModel instanceof Postprocessable) {
                    return ((Postprocessable) pageHeaderMetaboxDataModel).a();
                }
                return pageHeaderMetaboxDataModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1352864475)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: confirmation_change_contactpoint_failure */
        public final class PlaceOpenStatusModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private String f17263d;

            /* compiled from: confirmation_change_contactpoint_failure */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(PlaceOpenStatusModel.class, new Deserializer());
                }

                public Object m21101a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(PlaceOpenStatusParser.m21270a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object placeOpenStatusModel = new PlaceOpenStatusModel();
                    ((BaseModel) placeOpenStatusModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (placeOpenStatusModel instanceof Postprocessable) {
                        return ((Postprocessable) placeOpenStatusModel).a();
                    }
                    return placeOpenStatusModel;
                }
            }

            /* compiled from: confirmation_change_contactpoint_failure */
            public class Serializer extends JsonSerializer<PlaceOpenStatusModel> {
                public final void m21102a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    PlaceOpenStatusModel placeOpenStatusModel = (PlaceOpenStatusModel) obj;
                    if (placeOpenStatusModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(placeOpenStatusModel.m21103a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        placeOpenStatusModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    PlaceOpenStatusParser.m21271a(placeOpenStatusModel.w_(), placeOpenStatusModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(PlaceOpenStatusModel.class, new Serializer());
                }
            }

            public PlaceOpenStatusModel() {
                super(1);
            }

            @Nullable
            public final String m21105a() {
                this.f17263d = super.a(this.f17263d, 0);
                return this.f17263d;
            }

            public final int jK_() {
                return -1919764332;
            }

            public final GraphQLVisitableModel m21104a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m21103a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m21105a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, b);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: confirmation_change_contactpoint_failure */
        public class Serializer extends JsonSerializer<PageHeaderMetaboxDataModel> {
            public final void m21106a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                PageHeaderMetaboxDataModel pageHeaderMetaboxDataModel = (PageHeaderMetaboxDataModel) obj;
                if (pageHeaderMetaboxDataModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(pageHeaderMetaboxDataModel.m21110a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    pageHeaderMetaboxDataModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = pageHeaderMetaboxDataModel.w_();
                int u_ = pageHeaderMetaboxDataModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("address");
                    AddressParser.m21269a(mutableFlatBuffer, g, jsonGenerator);
                }
                g = mutableFlatBuffer.g(u_, 1);
                if (g != 0) {
                    jsonGenerator.a("place_open_status");
                    PlaceOpenStatusParser.m21271a(mutableFlatBuffer, g, jsonGenerator);
                }
                if (mutableFlatBuffer.g(u_, 2) != 0) {
                    jsonGenerator.a("place_open_status_type");
                    jsonGenerator.b(mutableFlatBuffer.b(u_, 2));
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(PageHeaderMetaboxDataModel.class, new Serializer());
            }
        }

        public PageHeaderMetaboxDataModel() {
            super(3);
        }

        public final void m21112a(String str, ConsistencyTuple consistencyTuple) {
            consistencyTuple.a();
        }

        public final void m21113a(String str, Object obj, boolean z) {
        }

        @Nullable
        private AddressModel m21107a() {
            this.f17264d = (AddressModel) super.a(this.f17264d, 0, AddressModel.class);
            return this.f17264d;
        }

        @Nullable
        private PlaceOpenStatusModel m21108j() {
            this.f17265e = (PlaceOpenStatusModel) super.a(this.f17265e, 1, PlaceOpenStatusModel.class);
            return this.f17265e;
        }

        @Nullable
        private GraphQLPageOpenHoursDisplayDecisionEnum m21109k() {
            this.f17266f = (GraphQLPageOpenHoursDisplayDecisionEnum) super.b(this.f17266f, 2, GraphQLPageOpenHoursDisplayDecisionEnum.class, GraphQLPageOpenHoursDisplayDecisionEnum.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
            return this.f17266f;
        }

        public final int jK_() {
            return 2479791;
        }

        public final GraphQLVisitableModel m21111a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m21107a() != null) {
                AddressModel addressModel = (AddressModel) graphQLModelMutatingVisitor.b(m21107a());
                if (m21107a() != addressModel) {
                    graphQLVisitableModel = (PageHeaderMetaboxDataModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f17264d = addressModel;
                }
            }
            if (m21108j() != null) {
                PlaceOpenStatusModel placeOpenStatusModel = (PlaceOpenStatusModel) graphQLModelMutatingVisitor.b(m21108j());
                if (m21108j() != placeOpenStatusModel) {
                    graphQLVisitableModel = (PageHeaderMetaboxDataModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f17265e = placeOpenStatusModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m21110a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m21107a());
            int a2 = ModelHelper.a(flatBufferBuilder, m21108j());
            int a3 = flatBufferBuilder.a(m21109k());
            flatBufferBuilder.c(3);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, a2);
            flatBufferBuilder.b(2, a3);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -1092046871)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: confirmation_change_contactpoint_failure */
    public final class PageHeaderTabDataModel extends BaseModel implements GraphQLVisitableConsistentModel {
        @Nullable
        private List<TabsModel> f17274d;
        @Nullable
        private VideoCollectionModel f17275e;

        /* compiled from: confirmation_change_contactpoint_failure */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(PageHeaderTabDataModel.class, new Deserializer());
            }

            public Object m21114a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = PageHeaderTabDataParser.m21283a(jsonParser);
                Object pageHeaderTabDataModel = new PageHeaderTabDataModel();
                ((BaseModel) pageHeaderTabDataModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (pageHeaderTabDataModel instanceof Postprocessable) {
                    return ((Postprocessable) pageHeaderTabDataModel).a();
                }
                return pageHeaderTabDataModel;
            }
        }

        /* compiled from: confirmation_change_contactpoint_failure */
        public class Serializer extends JsonSerializer<PageHeaderTabDataModel> {
            public final void m21115a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                PageHeaderTabDataModel pageHeaderTabDataModel = (PageHeaderTabDataModel) obj;
                if (pageHeaderTabDataModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(pageHeaderTabDataModel.m21142a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    pageHeaderTabDataModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = pageHeaderTabDataModel.w_();
                int u_ = pageHeaderTabDataModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("tabs");
                    TabsParser.m21276a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                g = mutableFlatBuffer.g(u_, 1);
                if (g != 0) {
                    jsonGenerator.a("video_collection");
                    VideoCollectionParser.m21282a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(PageHeaderTabDataModel.class, new Serializer());
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 841675414)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: confirmation_change_contactpoint_failure */
        public final class TabsModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private GraphQLPagePresenceTabContentType f17268d;
            @Nullable
            private String f17269e;
            @Nullable
            private GraphQLPagePresenceTabType f17270f;
            @Nullable
            private TitleModel f17271g;

            /* compiled from: confirmation_change_contactpoint_failure */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(TabsModel.class, new Deserializer());
                }

                public Object m21116a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(TabsParser.m21277b(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object tabsModel = new TabsModel();
                    ((BaseModel) tabsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (tabsModel instanceof Postprocessable) {
                        return ((Postprocessable) tabsModel).a();
                    }
                    return tabsModel;
                }
            }

            /* compiled from: confirmation_change_contactpoint_failure */
            public class Serializer extends JsonSerializer<TabsModel> {
                public final void m21117a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    TabsModel tabsModel = (TabsModel) obj;
                    if (tabsModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(tabsModel.m21123a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        tabsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    TabsParser.m21278b(tabsModel.w_(), tabsModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(TabsModel.class, new Serializer());
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = -1352864475)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: confirmation_change_contactpoint_failure */
            public final class TitleModel extends BaseModel implements GraphQLVisitableModel {
                @Nullable
                private String f17267d;

                /* compiled from: confirmation_change_contactpoint_failure */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(TitleModel.class, new Deserializer());
                    }

                    public Object m21118a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(TitleParser.m21273a(jsonParser, flatBufferBuilder));
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

                /* compiled from: confirmation_change_contactpoint_failure */
                public class Serializer extends JsonSerializer<TitleModel> {
                    public final void m21119a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        TitleModel titleModel = (TitleModel) obj;
                        if (titleModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(titleModel.m21120a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            titleModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        TitleParser.m21274a(titleModel.w_(), titleModel.u_(), jsonGenerator);
                    }

                    static {
                        FbSerializerProvider.a(TitleModel.class, new Serializer());
                    }
                }

                public TitleModel() {
                    super(1);
                }

                @Nullable
                public final String m21122a() {
                    this.f17267d = super.a(this.f17267d, 0);
                    return this.f17267d;
                }

                public final int jK_() {
                    return -1919764332;
                }

                public final GraphQLVisitableModel m21121a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    h();
                    i();
                    return this;
                }

                public final int m21120a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int b = flatBufferBuilder.b(m21122a());
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.b(0, b);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            public TabsModel() {
                super(4);
            }

            @Nullable
            public final GraphQLPagePresenceTabContentType m21124a() {
                this.f17268d = (GraphQLPagePresenceTabContentType) super.b(this.f17268d, 0, GraphQLPagePresenceTabContentType.class, GraphQLPagePresenceTabContentType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
                return this.f17268d;
            }

            @Nullable
            public final String m21126j() {
                this.f17269e = super.a(this.f17269e, 1);
                return this.f17269e;
            }

            @Nullable
            public final GraphQLPagePresenceTabType m21127k() {
                this.f17270f = (GraphQLPagePresenceTabType) super.b(this.f17270f, 2, GraphQLPagePresenceTabType.class, GraphQLPagePresenceTabType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
                return this.f17270f;
            }

            @Nullable
            public final TitleModel m21128l() {
                this.f17271g = (TitleModel) super.a(this.f17271g, 3, TitleModel.class);
                return this.f17271g;
            }

            public final int jK_() {
                return -1024957845;
            }

            public final GraphQLVisitableModel m21125a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m21128l() != null) {
                    TitleModel titleModel = (TitleModel) graphQLModelMutatingVisitor.b(m21128l());
                    if (m21128l() != titleModel) {
                        graphQLVisitableModel = (TabsModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f17271g = titleModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m21123a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = flatBufferBuilder.a(m21124a());
                int b = flatBufferBuilder.b(m21126j());
                int a2 = flatBufferBuilder.a(m21127k());
                int a3 = ModelHelper.a(flatBufferBuilder, m21128l());
                flatBufferBuilder.c(4);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.b(1, b);
                flatBufferBuilder.b(2, a2);
                flatBufferBuilder.b(3, a3);
                i();
                return flatBufferBuilder.d();
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 437728715)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: confirmation_change_contactpoint_failure */
        public final class VideoCollectionModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private VideoListsModel f17273d;

            /* compiled from: confirmation_change_contactpoint_failure */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(VideoCollectionModel.class, new Deserializer());
                }

                public Object m21129a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(VideoCollectionParser.m21281a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object videoCollectionModel = new VideoCollectionModel();
                    ((BaseModel) videoCollectionModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (videoCollectionModel instanceof Postprocessable) {
                        return ((Postprocessable) videoCollectionModel).a();
                    }
                    return videoCollectionModel;
                }
            }

            /* compiled from: confirmation_change_contactpoint_failure */
            public class Serializer extends JsonSerializer<VideoCollectionModel> {
                public final void m21130a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    VideoCollectionModel videoCollectionModel = (VideoCollectionModel) obj;
                    if (videoCollectionModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(videoCollectionModel.m21137a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        videoCollectionModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    VideoCollectionParser.m21282a(videoCollectionModel.w_(), videoCollectionModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(VideoCollectionModel.class, new Serializer());
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = -1723990064)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: confirmation_change_contactpoint_failure */
            public final class VideoListsModel extends BaseModel implements GraphQLVisitableModel {
                private int f17272d;

                /* compiled from: confirmation_change_contactpoint_failure */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(VideoListsModel.class, new Deserializer());
                    }

                    public Object m21131a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(VideoListsParser.m21279a(jsonParser, flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                        Object videoListsModel = new VideoListsModel();
                        ((BaseModel) videoListsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                        if (videoListsModel instanceof Postprocessable) {
                            return ((Postprocessable) videoListsModel).a();
                        }
                        return videoListsModel;
                    }
                }

                /* compiled from: confirmation_change_contactpoint_failure */
                public class Serializer extends JsonSerializer<VideoListsModel> {
                    public final void m21132a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        VideoListsModel videoListsModel = (VideoListsModel) obj;
                        if (videoListsModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(videoListsModel.m21134a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            videoListsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        VideoListsParser.m21280a(videoListsModel.w_(), videoListsModel.u_(), jsonGenerator);
                    }

                    static {
                        FbSerializerProvider.a(VideoListsModel.class, new Serializer());
                    }
                }

                public VideoListsModel() {
                    super(1);
                }

                public final int m21133a() {
                    a(0, 0);
                    return this.f17272d;
                }

                public final int jK_() {
                    return -1464360025;
                }

                public final GraphQLVisitableModel m21135a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    h();
                    i();
                    return this;
                }

                public final int m21134a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.a(0, this.f17272d, 0);
                    i();
                    return flatBufferBuilder.d();
                }

                public final void m21136a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                    super.a(mutableFlatBuffer, i, obj);
                    this.f17272d = mutableFlatBuffer.a(i, 0, 0);
                }
            }

            public VideoCollectionModel() {
                super(1);
            }

            @Nullable
            public final VideoListsModel m21139a() {
                this.f17273d = (VideoListsModel) super.a(this.f17273d, 0, VideoListsModel.class);
                return this.f17273d;
            }

            public final int jK_() {
                return -645050678;
            }

            public final GraphQLVisitableModel m21138a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m21139a() != null) {
                    VideoListsModel videoListsModel = (VideoListsModel) graphQLModelMutatingVisitor.b(m21139a());
                    if (m21139a() != videoListsModel) {
                        graphQLVisitableModel = (VideoCollectionModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f17273d = videoListsModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m21137a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m21139a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, a);
                i();
                return flatBufferBuilder.d();
            }
        }

        public PageHeaderTabDataModel() {
            super(2);
        }

        public final void m21144a(String str, ConsistencyTuple consistencyTuple) {
            consistencyTuple.a();
        }

        public final void m21145a(String str, Object obj, boolean z) {
        }

        @Nonnull
        private ImmutableList<TabsModel> m21140a() {
            this.f17274d = super.a(this.f17274d, 0, TabsModel.class);
            return (ImmutableList) this.f17274d;
        }

        @Nullable
        private VideoCollectionModel m21141j() {
            this.f17275e = (VideoCollectionModel) super.a(this.f17275e, 1, VideoCollectionModel.class);
            return this.f17275e;
        }

        public final int jK_() {
            return 2479791;
        }

        public final GraphQLVisitableModel m21143a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel;
            VideoCollectionModel videoCollectionModel;
            h();
            if (m21140a() != null) {
                Builder a = ModelHelper.a(m21140a(), graphQLModelMutatingVisitor);
                if (a != null) {
                    PageHeaderTabDataModel pageHeaderTabDataModel = (PageHeaderTabDataModel) ModelHelper.a(null, this);
                    pageHeaderTabDataModel.f17274d = a.b();
                    graphQLVisitableModel = pageHeaderTabDataModel;
                    if (m21141j() != null) {
                        videoCollectionModel = (VideoCollectionModel) graphQLModelMutatingVisitor.b(m21141j());
                        if (m21141j() != videoCollectionModel) {
                            graphQLVisitableModel = (PageHeaderTabDataModel) ModelHelper.a(graphQLVisitableModel, this);
                            graphQLVisitableModel.f17275e = videoCollectionModel;
                        }
                    }
                    i();
                    return graphQLVisitableModel != null ? this : graphQLVisitableModel;
                }
            }
            graphQLVisitableModel = null;
            if (m21141j() != null) {
                videoCollectionModel = (VideoCollectionModel) graphQLModelMutatingVisitor.b(m21141j());
                if (m21141j() != videoCollectionModel) {
                    graphQLVisitableModel = (PageHeaderTabDataModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f17275e = videoCollectionModel;
                }
            }
            i();
            if (graphQLVisitableModel != null) {
            }
        }

        public final int m21142a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m21140a());
            int a2 = ModelHelper.a(flatBufferBuilder, m21141j());
            flatBufferBuilder.c(2);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, a2);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 209461890)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: confirmation_change_contactpoint_failure */
    public final class PageProfileCoverPhotosDataModel extends BaseModel implements GraphQLVisitableConsistentModel {
        @Nullable
        private CoverPhotoModel f17289d;
        @Nullable
        private ProfilePictureAsCoverModel f17290e;
        @Nullable
        private PageHeaderDataProfilePhotoModel f17291f;
        private boolean f17292g;

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1583965343)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: confirmation_change_contactpoint_failure */
        public final class CoverPhotoModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private FocusModel f17284d;
            @Nullable
            private PhotoModel f17285e;

            /* compiled from: confirmation_change_contactpoint_failure */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(CoverPhotoModel.class, new Deserializer());
                }

                public Object m21146a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(CoverPhotoParser.m21290a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object coverPhotoModel = new CoverPhotoModel();
                    ((BaseModel) coverPhotoModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (coverPhotoModel instanceof Postprocessable) {
                        return ((Postprocessable) coverPhotoModel).a();
                    }
                    return coverPhotoModel;
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = -496435496)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: confirmation_change_contactpoint_failure */
            public final class FocusModel extends BaseModel implements GraphQLVisitableModel {
                private double f17276d;
                private double f17277e;

                /* compiled from: confirmation_change_contactpoint_failure */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(FocusModel.class, new Deserializer());
                    }

                    public Object m21147a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(FocusParser.m21284a(jsonParser, flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                        Object focusModel = new FocusModel();
                        ((BaseModel) focusModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                        if (focusModel instanceof Postprocessable) {
                            return ((Postprocessable) focusModel).a();
                        }
                        return focusModel;
                    }
                }

                /* compiled from: confirmation_change_contactpoint_failure */
                public class Serializer extends JsonSerializer<FocusModel> {
                    public final void m21148a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        FocusModel focusModel = (FocusModel) obj;
                        if (focusModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(focusModel.m21150a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            focusModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        FocusParser.m21285a(focusModel.w_(), focusModel.u_(), jsonGenerator);
                    }

                    static {
                        FbSerializerProvider.a(FocusModel.class, new Serializer());
                    }
                }

                public FocusModel() {
                    super(2);
                }

                public final double m21149a() {
                    a(0, 0);
                    return this.f17276d;
                }

                public final double m21153j() {
                    a(0, 1);
                    return this.f17277e;
                }

                public final int jK_() {
                    return 82530482;
                }

                public final GraphQLVisitableModel m21151a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    h();
                    i();
                    return this;
                }

                public final int m21150a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    flatBufferBuilder.c(2);
                    flatBufferBuilder.a(0, this.f17276d, 0.0d);
                    flatBufferBuilder.a(1, this.f17277e, 0.0d);
                    i();
                    return flatBufferBuilder.d();
                }

                public final void m21152a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                    super.a(mutableFlatBuffer, i, obj);
                    this.f17276d = mutableFlatBuffer.a(i, 0, 0.0d);
                    this.f17277e = mutableFlatBuffer.a(i, 1, 0.0d);
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = -798437176)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: confirmation_change_contactpoint_failure */
            public final class PhotoModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel {
                @Nullable
                private String f17279d;
                @Nullable
                private AlbumModel f17280e;
                @Nullable
                private String f17281f;
                @Nullable
                private DefaultImageFieldsModel f17282g;
                @Nullable
                private String f17283h;

                @JsonDeserialize(using = Deserializer.class)
                @ModelWithFlatBufferFormatHash(a = 1801334754)
                @JsonSerialize(using = Serializer.class)
                @FragmentModelWithoutBridge
                /* compiled from: confirmation_change_contactpoint_failure */
                public final class AlbumModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel {
                    @Nullable
                    private String f17278d;

                    /* compiled from: confirmation_change_contactpoint_failure */
                    public class Deserializer extends FbJsonDeserializer {
                        static {
                            GlobalAutoGenDeserializerCache.a(AlbumModel.class, new Deserializer());
                        }

                        public Object m21154a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(PhotoParser.AlbumParser.m21286a(jsonParser, flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            mutableFlatBuffer.a(4, Boolean.valueOf(true));
                            MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                            Object albumModel = new AlbumModel();
                            ((BaseModel) albumModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                            if (albumModel instanceof Postprocessable) {
                                return ((Postprocessable) albumModel).a();
                            }
                            return albumModel;
                        }
                    }

                    /* compiled from: confirmation_change_contactpoint_failure */
                    public class Serializer extends JsonSerializer<AlbumModel> {
                        public final void m21155a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                            AlbumModel albumModel = (AlbumModel) obj;
                            if (albumModel.w_() == null) {
                                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                flatBufferBuilder.d(albumModel.m21156a(flatBufferBuilder));
                                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                wrap.position(0);
                                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                albumModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                            }
                            PhotoParser.AlbumParser.m21287a(albumModel.w_(), albumModel.u_(), jsonGenerator);
                        }

                        static {
                            FbSerializerProvider.a(AlbumModel.class, new Serializer());
                        }
                    }

                    public AlbumModel() {
                        super(1);
                    }

                    @Nullable
                    public final String m21159j() {
                        this.f17278d = super.a(this.f17278d, 0);
                        return this.f17278d;
                    }

                    @Nullable
                    public final String m21158a() {
                        return m21159j();
                    }

                    public final int jK_() {
                        return 63344207;
                    }

                    public final GraphQLVisitableModel m21157a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                        h();
                        i();
                        return this;
                    }

                    public final int m21156a(FlatBufferBuilder flatBufferBuilder) {
                        h();
                        int b = flatBufferBuilder.b(m21159j());
                        flatBufferBuilder.c(1);
                        flatBufferBuilder.b(0, b);
                        i();
                        return flatBufferBuilder.d();
                    }
                }

                /* compiled from: confirmation_change_contactpoint_failure */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(PhotoModel.class, new Deserializer());
                    }

                    public Object m21160a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(PhotoParser.m21288a(jsonParser, flatBufferBuilder));
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

                /* compiled from: confirmation_change_contactpoint_failure */
                public class Serializer extends JsonSerializer<PhotoModel> {
                    public final void m21161a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        PhotoModel photoModel = (PhotoModel) obj;
                        if (photoModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(photoModel.m21162a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            photoModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        PhotoParser.m21289a(photoModel.w_(), photoModel.u_(), jsonGenerator, serializerProvider);
                    }

                    static {
                        FbSerializerProvider.a(PhotoModel.class, new Serializer());
                    }
                }

                public PhotoModel() {
                    super(5);
                }

                @Nullable
                public final String m21165j() {
                    this.f17279d = super.a(this.f17279d, 0);
                    return this.f17279d;
                }

                @Nullable
                public final AlbumModel m21166k() {
                    this.f17280e = (AlbumModel) super.a(this.f17280e, 1, AlbumModel.class);
                    return this.f17280e;
                }

                @Nullable
                public final String m21167l() {
                    this.f17281f = super.a(this.f17281f, 2);
                    return this.f17281f;
                }

                @Nullable
                public final DefaultImageFieldsModel m21168m() {
                    this.f17282g = (DefaultImageFieldsModel) super.a(this.f17282g, 3, DefaultImageFieldsModel.class);
                    return this.f17282g;
                }

                @Nullable
                public final String m21169n() {
                    this.f17283h = super.a(this.f17283h, 4);
                    return this.f17283h;
                }

                @Nullable
                public final String m21164a() {
                    return m21167l();
                }

                public final int jK_() {
                    return 77090322;
                }

                public final GraphQLVisitableModel m21163a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    GraphQLVisitableModel graphQLVisitableModel = null;
                    h();
                    if (m21166k() != null) {
                        AlbumModel albumModel = (AlbumModel) graphQLModelMutatingVisitor.b(m21166k());
                        if (m21166k() != albumModel) {
                            graphQLVisitableModel = (PhotoModel) ModelHelper.a(null, this);
                            graphQLVisitableModel.f17280e = albumModel;
                        }
                    }
                    if (m21168m() != null) {
                        DefaultImageFieldsModel defaultImageFieldsModel = (DefaultImageFieldsModel) graphQLModelMutatingVisitor.b(m21168m());
                        if (m21168m() != defaultImageFieldsModel) {
                            graphQLVisitableModel = (PhotoModel) ModelHelper.a(graphQLVisitableModel, this);
                            graphQLVisitableModel.f17282g = defaultImageFieldsModel;
                        }
                    }
                    i();
                    return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                }

                public final int m21162a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int b = flatBufferBuilder.b(m21165j());
                    int a = ModelHelper.a(flatBufferBuilder, m21166k());
                    int b2 = flatBufferBuilder.b(m21167l());
                    int a2 = ModelHelper.a(flatBufferBuilder, m21168m());
                    int b3 = flatBufferBuilder.b(m21169n());
                    flatBufferBuilder.c(5);
                    flatBufferBuilder.b(0, b);
                    flatBufferBuilder.b(1, a);
                    flatBufferBuilder.b(2, b2);
                    flatBufferBuilder.b(3, a2);
                    flatBufferBuilder.b(4, b3);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            /* compiled from: confirmation_change_contactpoint_failure */
            public class Serializer extends JsonSerializer<CoverPhotoModel> {
                public final void m21170a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    CoverPhotoModel coverPhotoModel = (CoverPhotoModel) obj;
                    if (coverPhotoModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(coverPhotoModel.m21171a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        coverPhotoModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    CoverPhotoParser.m21291a(coverPhotoModel.w_(), coverPhotoModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(CoverPhotoModel.class, new Serializer());
                }
            }

            public CoverPhotoModel() {
                super(2);
            }

            @Nullable
            public final FocusModel m21173a() {
                this.f17284d = (FocusModel) super.a(this.f17284d, 0, FocusModel.class);
                return this.f17284d;
            }

            @Nullable
            public final PhotoModel m21174j() {
                this.f17285e = (PhotoModel) super.a(this.f17285e, 1, PhotoModel.class);
                return this.f17285e;
            }

            public final int jK_() {
                return 497264923;
            }

            public final GraphQLVisitableModel m21172a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m21173a() != null) {
                    FocusModel focusModel = (FocusModel) graphQLModelMutatingVisitor.b(m21173a());
                    if (m21173a() != focusModel) {
                        graphQLVisitableModel = (CoverPhotoModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f17284d = focusModel;
                    }
                }
                if (m21174j() != null) {
                    PhotoModel photoModel = (PhotoModel) graphQLModelMutatingVisitor.b(m21174j());
                    if (m21174j() != photoModel) {
                        graphQLVisitableModel = (CoverPhotoModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f17285e = photoModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m21171a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m21173a());
                int a2 = ModelHelper.a(flatBufferBuilder, m21174j());
                flatBufferBuilder.c(2);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.b(1, a2);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: confirmation_change_contactpoint_failure */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(PageProfileCoverPhotosDataModel.class, new Deserializer());
            }

            public Object m21175a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(PageProfileCoverPhotosDataParser.m21294a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object pageProfileCoverPhotosDataModel = new PageProfileCoverPhotosDataModel();
                ((BaseModel) pageProfileCoverPhotosDataModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (pageProfileCoverPhotosDataModel instanceof Postprocessable) {
                    return ((Postprocessable) pageProfileCoverPhotosDataModel).a();
                }
                return pageProfileCoverPhotosDataModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 729935302)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: confirmation_change_contactpoint_failure */
        public final class ProfilePictureAsCoverModel extends BaseModel implements GraphQLVisitableModel {
            private int f17286d;
            @Nullable
            private String f17287e;
            private int f17288f;

            /* compiled from: confirmation_change_contactpoint_failure */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(ProfilePictureAsCoverModel.class, new Deserializer());
                }

                public Object m21176a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(ProfilePictureAsCoverParser.m21292a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object profilePictureAsCoverModel = new ProfilePictureAsCoverModel();
                    ((BaseModel) profilePictureAsCoverModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (profilePictureAsCoverModel instanceof Postprocessable) {
                        return ((Postprocessable) profilePictureAsCoverModel).a();
                    }
                    return profilePictureAsCoverModel;
                }
            }

            /* compiled from: confirmation_change_contactpoint_failure */
            public class Serializer extends JsonSerializer<ProfilePictureAsCoverModel> {
                public final void m21177a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    ProfilePictureAsCoverModel profilePictureAsCoverModel = (ProfilePictureAsCoverModel) obj;
                    if (profilePictureAsCoverModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(profilePictureAsCoverModel.m21178a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        profilePictureAsCoverModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    ProfilePictureAsCoverParser.m21293a(profilePictureAsCoverModel.w_(), profilePictureAsCoverModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(ProfilePictureAsCoverModel.class, new Serializer());
                }
            }

            public ProfilePictureAsCoverModel() {
                super(3);
            }

            @Nullable
            public final String m21180a() {
                this.f17287e = super.a(this.f17287e, 1);
                return this.f17287e;
            }

            public final int jK_() {
                return 70760763;
            }

            public final GraphQLVisitableModel m21179a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m21178a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m21180a());
                flatBufferBuilder.c(3);
                flatBufferBuilder.a(0, this.f17286d, 0);
                flatBufferBuilder.b(1, b);
                flatBufferBuilder.a(2, this.f17288f, 0);
                i();
                return flatBufferBuilder.d();
            }

            public final void m21181a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                super.a(mutableFlatBuffer, i, obj);
                this.f17286d = mutableFlatBuffer.a(i, 0, 0);
                this.f17288f = mutableFlatBuffer.a(i, 2, 0);
            }
        }

        /* compiled from: confirmation_change_contactpoint_failure */
        public class Serializer extends JsonSerializer<PageProfileCoverPhotosDataModel> {
            public final void m21182a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                PageProfileCoverPhotosDataModel pageProfileCoverPhotosDataModel = (PageProfileCoverPhotosDataModel) obj;
                if (pageProfileCoverPhotosDataModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(pageProfileCoverPhotosDataModel.m21186a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    pageProfileCoverPhotosDataModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = pageProfileCoverPhotosDataModel.w_();
                int u_ = pageProfileCoverPhotosDataModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("cover_photo");
                    CoverPhotoParser.m21291a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                g = mutableFlatBuffer.g(u_, 1);
                if (g != 0) {
                    jsonGenerator.a("profilePictureAsCover");
                    ProfilePictureAsCoverParser.m21293a(mutableFlatBuffer, g, jsonGenerator);
                }
                g = mutableFlatBuffer.g(u_, 2);
                if (g != 0) {
                    jsonGenerator.a("profile_photo");
                    PageHeaderDataProfilePhotoParser.m21267a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                boolean a = mutableFlatBuffer.a(u_, 3);
                if (a) {
                    jsonGenerator.a("profile_picture_is_silhouette");
                    jsonGenerator.a(a);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(PageProfileCoverPhotosDataModel.class, new Serializer());
            }
        }

        public PageProfileCoverPhotosDataModel() {
            super(4);
        }

        public final void m21189a(String str, ConsistencyTuple consistencyTuple) {
            consistencyTuple.a();
        }

        public final void m21190a(String str, Object obj, boolean z) {
        }

        @Nullable
        private CoverPhotoModel m21183a() {
            this.f17289d = (CoverPhotoModel) super.a(this.f17289d, 0, CoverPhotoModel.class);
            return this.f17289d;
        }

        @Nullable
        private ProfilePictureAsCoverModel m21184j() {
            this.f17290e = (ProfilePictureAsCoverModel) super.a(this.f17290e, 1, ProfilePictureAsCoverModel.class);
            return this.f17290e;
        }

        @Nullable
        private PageHeaderDataProfilePhotoModel m21185k() {
            this.f17291f = (PageHeaderDataProfilePhotoModel) super.a(this.f17291f, 2, PageHeaderDataProfilePhotoModel.class);
            return this.f17291f;
        }

        public final int jK_() {
            return 2479791;
        }

        public final GraphQLVisitableModel m21187a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m21183a() != null) {
                CoverPhotoModel coverPhotoModel = (CoverPhotoModel) graphQLModelMutatingVisitor.b(m21183a());
                if (m21183a() != coverPhotoModel) {
                    graphQLVisitableModel = (PageProfileCoverPhotosDataModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f17289d = coverPhotoModel;
                }
            }
            if (m21184j() != null) {
                ProfilePictureAsCoverModel profilePictureAsCoverModel = (ProfilePictureAsCoverModel) graphQLModelMutatingVisitor.b(m21184j());
                if (m21184j() != profilePictureAsCoverModel) {
                    graphQLVisitableModel = (PageProfileCoverPhotosDataModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f17290e = profilePictureAsCoverModel;
                }
            }
            if (m21185k() != null) {
                PageHeaderDataProfilePhotoModel pageHeaderDataProfilePhotoModel = (PageHeaderDataProfilePhotoModel) graphQLModelMutatingVisitor.b(m21185k());
                if (m21185k() != pageHeaderDataProfilePhotoModel) {
                    graphQLVisitableModel = (PageProfileCoverPhotosDataModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f17291f = pageHeaderDataProfilePhotoModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m21186a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m21183a());
            int a2 = ModelHelper.a(flatBufferBuilder, m21184j());
            int a3 = ModelHelper.a(flatBufferBuilder, m21185k());
            flatBufferBuilder.c(4);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, a2);
            flatBufferBuilder.b(2, a3);
            flatBufferBuilder.a(3, this.f17292g);
            i();
            return flatBufferBuilder.d();
        }

        public final void m21188a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
            super.a(mutableFlatBuffer, i, obj);
            this.f17292g = mutableFlatBuffer.a(i, 3);
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -260639742)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: confirmation_change_contactpoint_failure */
    public final class PageRatingDataModel extends BaseModel implements GraphQLVisitableConsistentModel {
        @Nullable
        private OverallStarRatingModel f17295d;

        /* compiled from: confirmation_change_contactpoint_failure */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(PageRatingDataModel.class, new Deserializer());
            }

            public Object m21191a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = PageRatingDataParser.m21297a(jsonParser);
                Object pageRatingDataModel = new PageRatingDataModel();
                ((BaseModel) pageRatingDataModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (pageRatingDataModel instanceof Postprocessable) {
                    return ((Postprocessable) pageRatingDataModel).a();
                }
                return pageRatingDataModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1026989130)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: confirmation_change_contactpoint_failure */
        public final class OverallStarRatingModel extends BaseModel implements GraphQLVisitableModel {
            private int f17293d;
            private double f17294e;

            /* compiled from: confirmation_change_contactpoint_failure */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(OverallStarRatingModel.class, new Deserializer());
                }

                public Object m21192a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(OverallStarRatingParser.m21295a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object overallStarRatingModel = new OverallStarRatingModel();
                    ((BaseModel) overallStarRatingModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (overallStarRatingModel instanceof Postprocessable) {
                        return ((Postprocessable) overallStarRatingModel).a();
                    }
                    return overallStarRatingModel;
                }
            }

            /* compiled from: confirmation_change_contactpoint_failure */
            public class Serializer extends JsonSerializer<OverallStarRatingModel> {
                public final void m21193a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    OverallStarRatingModel overallStarRatingModel = (OverallStarRatingModel) obj;
                    if (overallStarRatingModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(overallStarRatingModel.m21195a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        overallStarRatingModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    OverallStarRatingParser.m21296a(overallStarRatingModel.w_(), overallStarRatingModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(OverallStarRatingModel.class, new Serializer());
                }
            }

            public OverallStarRatingModel() {
                super(2);
            }

            public final int m21194a() {
                a(0, 0);
                return this.f17293d;
            }

            public final double m21198j() {
                a(0, 1);
                return this.f17294e;
            }

            public final int jK_() {
                return -1854235203;
            }

            public final GraphQLVisitableModel m21196a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m21195a(FlatBufferBuilder flatBufferBuilder) {
                h();
                flatBufferBuilder.c(2);
                flatBufferBuilder.a(0, this.f17293d, 0);
                flatBufferBuilder.a(1, this.f17294e, 0.0d);
                i();
                return flatBufferBuilder.d();
            }

            public final void m21197a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                super.a(mutableFlatBuffer, i, obj);
                this.f17293d = mutableFlatBuffer.a(i, 0, 0);
                this.f17294e = mutableFlatBuffer.a(i, 1, 0.0d);
            }
        }

        /* compiled from: confirmation_change_contactpoint_failure */
        public class Serializer extends JsonSerializer<PageRatingDataModel> {
            public final void m21199a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                PageRatingDataModel pageRatingDataModel = (PageRatingDataModel) obj;
                if (pageRatingDataModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(pageRatingDataModel.m21201a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    pageRatingDataModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = pageRatingDataModel.w_();
                int u_ = pageRatingDataModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("overall_star_rating");
                    OverallStarRatingParser.m21296a(mutableFlatBuffer, g, jsonGenerator);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(PageRatingDataModel.class, new Serializer());
            }
        }

        public PageRatingDataModel() {
            super(1);
        }

        public final void m21203a(String str, ConsistencyTuple consistencyTuple) {
            consistencyTuple.a();
        }

        public final void m21204a(String str, Object obj, boolean z) {
        }

        @Nullable
        private OverallStarRatingModel m21200a() {
            this.f17295d = (OverallStarRatingModel) super.a(this.f17295d, 0, OverallStarRatingModel.class);
            return this.f17295d;
        }

        public final int jK_() {
            return 2479791;
        }

        public final GraphQLVisitableModel m21202a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m21200a() != null) {
                OverallStarRatingModel overallStarRatingModel = (OverallStarRatingModel) graphQLModelMutatingVisitor.b(m21200a());
                if (m21200a() != overallStarRatingModel) {
                    graphQLVisitableModel = (PageRatingDataModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f17295d = overallStarRatingModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m21201a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m21200a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -1041186317)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: confirmation_change_contactpoint_failure */
    public final class PageSectionsCanAddDataModel extends BaseModel implements GraphQLVisitableConsistentModel {
        @Nullable
        private List<SectionsCanAddModel> f17301d;

        /* compiled from: confirmation_change_contactpoint_failure */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(PageSectionsCanAddDataModel.class, new Deserializer());
            }

            public Object m21205a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = PageSectionsCanAddDataParser.m21306a(jsonParser);
                Object pageSectionsCanAddDataModel = new PageSectionsCanAddDataModel();
                ((BaseModel) pageSectionsCanAddDataModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (pageSectionsCanAddDataModel instanceof Postprocessable) {
                    return ((Postprocessable) pageSectionsCanAddDataModel).a();
                }
                return pageSectionsCanAddDataModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 374361893)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: confirmation_change_contactpoint_failure */
        public final class SectionsCanAddModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private SubtitleModel f17298d;
            @Nullable
            private GraphQLPagePresenceTabType f17299e;
            @Nullable
            private TitleModel f17300f;

            /* compiled from: confirmation_change_contactpoint_failure */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(SectionsCanAddModel.class, new Deserializer());
                }

                public Object m21206a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(SectionsCanAddParser.m21304b(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object sectionsCanAddModel = new SectionsCanAddModel();
                    ((BaseModel) sectionsCanAddModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (sectionsCanAddModel instanceof Postprocessable) {
                        return ((Postprocessable) sectionsCanAddModel).a();
                    }
                    return sectionsCanAddModel;
                }
            }

            /* compiled from: confirmation_change_contactpoint_failure */
            public class Serializer extends JsonSerializer<SectionsCanAddModel> {
                public final void m21207a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    SectionsCanAddModel sectionsCanAddModel = (SectionsCanAddModel) obj;
                    if (sectionsCanAddModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(sectionsCanAddModel.m21220a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        sectionsCanAddModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    SectionsCanAddParser.m21305b(sectionsCanAddModel.w_(), sectionsCanAddModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(SectionsCanAddModel.class, new Serializer());
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = -1352864475)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: confirmation_change_contactpoint_failure */
            public final class SubtitleModel extends BaseModel implements GraphQLVisitableModel {
                @Nullable
                private String f17296d;

                /* compiled from: confirmation_change_contactpoint_failure */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(SubtitleModel.class, new Deserializer());
                    }

                    public Object m21208a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(SubtitleParser.m21298a(jsonParser, flatBufferBuilder));
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

                /* compiled from: confirmation_change_contactpoint_failure */
                public class Serializer extends JsonSerializer<SubtitleModel> {
                    public final void m21209a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        SubtitleModel subtitleModel = (SubtitleModel) obj;
                        if (subtitleModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(subtitleModel.m21211a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            subtitleModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        SubtitleParser.m21299a(subtitleModel.w_(), subtitleModel.u_(), jsonGenerator);
                    }

                    static {
                        FbSerializerProvider.a(SubtitleModel.class, new Serializer());
                    }
                }

                public SubtitleModel() {
                    super(1);
                }

                @Nullable
                private String m21210a() {
                    this.f17296d = super.a(this.f17296d, 0);
                    return this.f17296d;
                }

                public final int jK_() {
                    return -1919764332;
                }

                public final GraphQLVisitableModel m21212a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    h();
                    i();
                    return this;
                }

                public final int m21211a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int b = flatBufferBuilder.b(m21210a());
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
            /* compiled from: confirmation_change_contactpoint_failure */
            public final class TitleModel extends BaseModel implements GraphQLVisitableModel {
                @Nullable
                private String f17297d;

                /* compiled from: confirmation_change_contactpoint_failure */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(TitleModel.class, new Deserializer());
                    }

                    public Object m21213a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(SectionsCanAddParser.TitleParser.m21300a(jsonParser, flatBufferBuilder));
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

                /* compiled from: confirmation_change_contactpoint_failure */
                public class Serializer extends JsonSerializer<TitleModel> {
                    public final void m21214a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        TitleModel titleModel = (TitleModel) obj;
                        if (titleModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(titleModel.m21216a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            titleModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        SectionsCanAddParser.TitleParser.m21301a(titleModel.w_(), titleModel.u_(), jsonGenerator);
                    }

                    static {
                        FbSerializerProvider.a(TitleModel.class, new Serializer());
                    }
                }

                public TitleModel() {
                    super(1);
                }

                @Nullable
                private String m21215a() {
                    this.f17297d = super.a(this.f17297d, 0);
                    return this.f17297d;
                }

                public final int jK_() {
                    return -1919764332;
                }

                public final GraphQLVisitableModel m21217a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    h();
                    i();
                    return this;
                }

                public final int m21216a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int b = flatBufferBuilder.b(m21215a());
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.b(0, b);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            public SectionsCanAddModel() {
                super(3);
            }

            @Nullable
            private SubtitleModel m21218j() {
                this.f17298d = (SubtitleModel) super.a(this.f17298d, 0, SubtitleModel.class);
                return this.f17298d;
            }

            @Nullable
            public final GraphQLPagePresenceTabType m21221a() {
                this.f17299e = (GraphQLPagePresenceTabType) super.b(this.f17299e, 1, GraphQLPagePresenceTabType.class, GraphQLPagePresenceTabType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
                return this.f17299e;
            }

            @Nullable
            private TitleModel m21219k() {
                this.f17300f = (TitleModel) super.a(this.f17300f, 2, TitleModel.class);
                return this.f17300f;
            }

            public final int jK_() {
                return -1024957845;
            }

            public final GraphQLVisitableModel m21222a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m21218j() != null) {
                    SubtitleModel subtitleModel = (SubtitleModel) graphQLModelMutatingVisitor.b(m21218j());
                    if (m21218j() != subtitleModel) {
                        graphQLVisitableModel = (SectionsCanAddModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f17298d = subtitleModel;
                    }
                }
                if (m21219k() != null) {
                    TitleModel titleModel = (TitleModel) graphQLModelMutatingVisitor.b(m21219k());
                    if (m21219k() != titleModel) {
                        graphQLVisitableModel = (SectionsCanAddModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f17300f = titleModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m21220a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m21218j());
                int a2 = flatBufferBuilder.a(m21221a());
                int a3 = ModelHelper.a(flatBufferBuilder, m21219k());
                flatBufferBuilder.c(3);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.b(1, a2);
                flatBufferBuilder.b(2, a3);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: confirmation_change_contactpoint_failure */
        public class Serializer extends JsonSerializer<PageSectionsCanAddDataModel> {
            public final void m21223a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                PageSectionsCanAddDataModel pageSectionsCanAddDataModel = (PageSectionsCanAddDataModel) obj;
                if (pageSectionsCanAddDataModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(pageSectionsCanAddDataModel.m21225a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    pageSectionsCanAddDataModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = pageSectionsCanAddDataModel.w_();
                int u_ = pageSectionsCanAddDataModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("sections_can_add");
                    SectionsCanAddParser.m21303a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(PageSectionsCanAddDataModel.class, new Serializer());
            }
        }

        public PageSectionsCanAddDataModel() {
            super(1);
        }

        public final void m21227a(String str, ConsistencyTuple consistencyTuple) {
            consistencyTuple.a();
        }

        public final void m21228a(String str, Object obj, boolean z) {
        }

        @Nonnull
        private ImmutableList<SectionsCanAddModel> m21224a() {
            this.f17301d = super.a(this.f17301d, 0, SectionsCanAddModel.class);
            return (ImmutableList) this.f17301d;
        }

        public final int jK_() {
            return 2479791;
        }

        public final GraphQLVisitableModel m21226a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m21224a() != null) {
                Builder a = ModelHelper.a(m21224a(), graphQLModelMutatingVisitor);
                if (a != null) {
                    graphQLVisitableModel = (PageSectionsCanAddDataModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f17301d = a.b();
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m21225a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m21224a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }
}
