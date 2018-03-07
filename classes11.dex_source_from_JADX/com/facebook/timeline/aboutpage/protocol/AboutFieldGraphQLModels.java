package com.facebook.timeline.aboutpage.protocol;

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
import com.facebook.graphql.enums.GraphQLProfileFieldStyle;
import com.facebook.graphql.enums.GraphQLProfileFieldTextListItemHeadingType;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.visitor.ConsistencyTuple;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLPersistableNode;
import com.facebook.graphql.visitor.GraphQLVisitableConsistentModel;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.facebook.linkify.LinkifyTargetGraphQLInterfaces.LinkifyTargetGraphQL;
import com.facebook.linkify.LinkifyTargetGraphQLInterfaces.LinkifyTargetGraphQL.ProfilePicture;
import com.facebook.linkify.LinkifyTargetGraphQLModels.LinkifyTargetGraphQLModel.ProfilePictureModel;
import com.facebook.timeline.aboutpage.protocol.AboutFieldGraphQLInterfaces.ProfileFieldSectionHeader;
import com.facebook.timeline.aboutpage.protocol.AboutFieldGraphQLParsers.AboutSectionInfoParser;
import com.facebook.timeline.aboutpage.protocol.AboutFieldGraphQLParsers.ProfileFieldInfoParser;
import com.facebook.timeline.aboutpage.protocol.AboutFieldGraphQLParsers.ProfileFieldInfoParser.AssociatedPagesParser;
import com.facebook.timeline.aboutpage.protocol.AboutFieldGraphQLParsers.ProfileFieldInfoParser.DateContentParser;
import com.facebook.timeline.aboutpage.protocol.AboutFieldGraphQLParsers.ProfileFieldInfoParser.EmailParser;
import com.facebook.timeline.aboutpage.protocol.AboutFieldGraphQLParsers.ProfileFieldInfoParser.IconParser;
import com.facebook.timeline.aboutpage.protocol.AboutFieldGraphQLParsers.ProfileFieldInfoParser.MenuOptionsParser;
import com.facebook.timeline.aboutpage.protocol.AboutFieldGraphQLParsers.ProfileFieldInfoParser.MenuOptionsParser.NodeToDeleteParser;
import com.facebook.timeline.aboutpage.protocol.AboutFieldGraphQLParsers.ProfileFieldInfoParser.MenuOptionsParser.TitleParser;
import com.facebook.timeline.aboutpage.protocol.AboutFieldGraphQLParsers.ProfileFieldInfoParser.PhoneNumberParser;
import com.facebook.timeline.aboutpage.protocol.AboutFieldGraphQLParsers.ProfileFieldInfoParser.StringsListContentParser;
import com.facebook.timeline.aboutpage.protocol.AboutFieldGraphQLParsers.ProfileFieldInfoParser.TextContentParser;
import com.facebook.timeline.aboutpage.protocol.AboutFieldGraphQLParsers.ProfileFieldInfoParser.UpsellTextParser;
import com.facebook.timeline.aboutpage.protocol.AboutFieldGraphQLParsers.ProfileFieldSectionFieldsParser;
import com.facebook.timeline.aboutpage.protocol.AboutFieldGraphQLParsers.ProfileFieldSectionFieldsParser.ProfileFieldsParser;
import com.facebook.timeline.aboutpage.protocol.AboutFieldGraphQLParsers.ProfileFieldSectionHeaderParser;
import com.facebook.timeline.aboutpage.protocol.AboutFieldGraphQLParsers.ProfileFieldSectionInfoParser;
import com.facebook.timeline.aboutpage.protocol.AboutFieldGraphQLParsers.ProfileFieldTextListItemGroupInfoParser;
import com.facebook.timeline.aboutpage.protocol.AboutFieldGraphQLParsers.ProfileFieldTextListItemGroupInfoParser.ListItemsParser;
import com.facebook.timeline.aboutpage.protocol.AboutFieldGraphQLParsers.ProfileInfoSectionsParser;
import com.facebook.timeline.aboutpage.protocol.AboutFieldGraphQLParsers.ProfileInfoSectionsParser.ProfileFieldSectionsParser;
import com.facebook.timeline.aboutpage.protocol.AboutFieldGraphQLParsers.ProfileInfoSectionsParser.ProfileFieldSectionsParser.PageInfoParser;
import com.facebook.timeline.aboutpage.protocol.AboutFieldGraphQLParsers.TextWithEntitiesInfoParser;
import com.facebook.timeline.aboutpage.protocol.AboutFieldGraphQLParsers.TextWithEntitiesInfoParser.RangesParser;
import com.facebook.timeline.aboutpage.protocol.AboutFieldGraphQLParsers.TextWithEntitiesInfoParser.RangesParser.EntityParser;
import com.facebook.timeline.aboutpage.protocol.FetchTimelineAppSectionsGraphQLInterfaces.AboutPageUserFields;
import com.facebook.timeline.aboutpage.protocol.FetchTimelineAppSectionsGraphQLModels.TimelineAppSectionsStructuredNameModel;
import com.facebook.timeline.aboutpage.protocol.FetchTimelineAppSectionsGraphQLModels.TimelineMutualFriendsModel;
import com.facebook.timeline.aboutpage.protocol.FetchTimelineAppSectionsGraphQLParsers.TimelineAppSectionsStructuredNameParser;
import com.facebook.timeline.aboutpage.protocol.FetchTimelineAppSectionsGraphQLParsers.TimelineMutualFriendsParser;
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

/* compiled from: MarketplacePostPublished */
public class AboutFieldGraphQLModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -1439296099)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: MarketplacePostPublished */
    public final class AboutSectionInfoModel extends BaseModel implements GraphQLVisitableConsistentModel, AboutPageUserFields {
        @Nullable
        private TimelineMutualFriendsModel f13166d;
        @Nullable
        private String f13167e;
        @Nullable
        private ProfileFieldSectionsModel f13168f;
        @Nullable
        private TimelineAppSectionsStructuredNameModel f13169g;

        /* compiled from: MarketplacePostPublished */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(AboutSectionInfoModel.class, new Deserializer());
            }

            public Object m13945a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = AboutSectionInfoParser.m14142a(jsonParser);
                Object aboutSectionInfoModel = new AboutSectionInfoModel();
                ((BaseModel) aboutSectionInfoModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (aboutSectionInfoModel instanceof Postprocessable) {
                    return ((Postprocessable) aboutSectionInfoModel).a();
                }
                return aboutSectionInfoModel;
            }
        }

        /* compiled from: MarketplacePostPublished */
        public class Serializer extends JsonSerializer<AboutSectionInfoModel> {
            public final void m13946a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                AboutSectionInfoModel aboutSectionInfoModel = (AboutSectionInfoModel) obj;
                if (aboutSectionInfoModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(aboutSectionInfoModel.m13949a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    aboutSectionInfoModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = aboutSectionInfoModel.w_();
                int u_ = aboutSectionInfoModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("mutual_friends");
                    TimelineMutualFriendsParser.m14667a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                if (mutableFlatBuffer.g(u_, 1) != 0) {
                    jsonGenerator.a("name");
                    jsonGenerator.b(mutableFlatBuffer.c(u_, 1));
                }
                g = mutableFlatBuffer.g(u_, 2);
                if (g != 0) {
                    jsonGenerator.a("profile_field_sections");
                    ProfileFieldSectionsParser.m14190a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                g = mutableFlatBuffer.g(u_, 3);
                if (g != 0) {
                    jsonGenerator.a("structured_name");
                    TimelineAppSectionsStructuredNameParser.m14658a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(AboutSectionInfoModel.class, new Serializer());
            }
        }

        @Nullable
        public final /* synthetic */ TimelineAppSectionsStructuredNameModel mo382k() {
            return m13948n();
        }

        @Nullable
        public final /* synthetic */ TimelineMutualFriendsModel mo383l() {
            return m13947m();
        }

        public AboutSectionInfoModel() {
            super(4);
        }

        public final void m13952a(String str, ConsistencyTuple consistencyTuple) {
            consistencyTuple.a();
        }

        public final void m13953a(String str, Object obj, boolean z) {
        }

        @Nullable
        private TimelineMutualFriendsModel m13947m() {
            this.f13166d = (TimelineMutualFriendsModel) super.a(this.f13166d, 0, TimelineMutualFriendsModel.class);
            return this.f13166d;
        }

        @Nullable
        public final String mo381a() {
            this.f13167e = super.a(this.f13167e, 1);
            return this.f13167e;
        }

        @Nullable
        public final ProfileFieldSectionsModel m13954j() {
            this.f13168f = (ProfileFieldSectionsModel) super.a(this.f13168f, 2, ProfileFieldSectionsModel.class);
            return this.f13168f;
        }

        @Nullable
        private TimelineAppSectionsStructuredNameModel m13948n() {
            this.f13169g = (TimelineAppSectionsStructuredNameModel) super.a(this.f13169g, 3, TimelineAppSectionsStructuredNameModel.class);
            return this.f13169g;
        }

        public final int jK_() {
            return 2645995;
        }

        public final GraphQLVisitableModel m13950a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m13947m() != null) {
                TimelineMutualFriendsModel timelineMutualFriendsModel = (TimelineMutualFriendsModel) graphQLModelMutatingVisitor.b(m13947m());
                if (m13947m() != timelineMutualFriendsModel) {
                    graphQLVisitableModel = (AboutSectionInfoModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f13166d = timelineMutualFriendsModel;
                }
            }
            if (m13954j() != null) {
                ProfileFieldSectionsModel profileFieldSectionsModel = (ProfileFieldSectionsModel) graphQLModelMutatingVisitor.b(m13954j());
                if (m13954j() != profileFieldSectionsModel) {
                    graphQLVisitableModel = (AboutSectionInfoModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f13168f = profileFieldSectionsModel;
                }
            }
            if (m13948n() != null) {
                TimelineAppSectionsStructuredNameModel timelineAppSectionsStructuredNameModel = (TimelineAppSectionsStructuredNameModel) graphQLModelMutatingVisitor.b(m13948n());
                if (m13948n() != timelineAppSectionsStructuredNameModel) {
                    graphQLVisitableModel = (AboutSectionInfoModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f13169g = timelineAppSectionsStructuredNameModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m13949a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m13947m());
            int b = flatBufferBuilder.b(mo381a());
            int a2 = ModelHelper.a(flatBufferBuilder, m13954j());
            int a3 = ModelHelper.a(flatBufferBuilder, m13948n());
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
    @ModelWithFlatBufferFormatHash(a = -1988949585)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: MarketplacePostPublished */
    public final class ProfileFieldInfoModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private List<AssociatedPagesModel> f13192d;
        @Nullable
        private DateContentModel f13193e;
        @Nullable
        private String f13194f;
        @Nullable
        private EmailModel f13195g;
        private boolean f13196h;
        @Nullable
        private IconModel f13197i;
        @Nullable
        private String f13198j;
        @Nullable
        private String f13199k;
        @Nullable
        private List<ProfileFieldTextListItemGroupInfoModel> f13200l;
        @Nullable
        private List<MenuOptionsModel> f13201m;
        @Nullable
        private PhoneNumberModel f13202n;
        private boolean f13203o;
        @Nullable
        private List<StringsListContentModel> f13204p;
        @Nullable
        private List<GraphQLProfileFieldStyle> f13205q;
        @Nullable
        private TextContentModel f13206r;
        @Nullable
        private List<String> f13207s;
        @Nullable
        private TitleModel f13208t;
        @Nullable
        private UpsellTextModel f13209u;

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 723206835)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: MarketplacePostPublished */
        public final class AssociatedPagesModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel, LinkifyTargetGraphQL {
            @Nullable
            private GraphQLObjectType f13170d;
            @Nullable
            private String f13171e;
            @Nullable
            private String f13172f;
            @Nullable
            private ProfilePictureModel f13173g;
            @Nullable
            private String f13174h;

            /* compiled from: MarketplacePostPublished */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(AssociatedPagesModel.class, new Deserializer());
                }

                public Object m13957a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(AssociatedPagesParser.m14144b(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object associatedPagesModel = new AssociatedPagesModel();
                    ((BaseModel) associatedPagesModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (associatedPagesModel instanceof Postprocessable) {
                        return ((Postprocessable) associatedPagesModel).a();
                    }
                    return associatedPagesModel;
                }
            }

            /* compiled from: MarketplacePostPublished */
            public class Serializer extends JsonSerializer<AssociatedPagesModel> {
                public final void m13958a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    AssociatedPagesModel associatedPagesModel = (AssociatedPagesModel) obj;
                    if (associatedPagesModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(associatedPagesModel.m13960a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        associatedPagesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    AssociatedPagesParser.m14145b(associatedPagesModel.w_(), associatedPagesModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(AssociatedPagesModel.class, new Serializer());
                }
            }

            @Nullable
            public final /* synthetic */ ProfilePicture ad_() {
                return m13959j();
            }

            public AssociatedPagesModel() {
                super(5);
            }

            public final void m13963a(String str, ConsistencyTuple consistencyTuple) {
                consistencyTuple.a();
            }

            public final void m13964a(String str, Object obj, boolean z) {
            }

            @Nullable
            public final GraphQLObjectType m13965b() {
                if (this.b != null && this.f13170d == null) {
                    this.f13170d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
                }
                return this.f13170d;
            }

            @Nullable
            public final String m13966d() {
                this.f13171e = super.a(this.f13171e, 1);
                return this.f13171e;
            }

            @Nullable
            public final String C_() {
                this.f13172f = super.a(this.f13172f, 2);
                return this.f13172f;
            }

            @Nullable
            private ProfilePictureModel m13959j() {
                this.f13173g = (ProfilePictureModel) super.a(this.f13173g, 3, ProfilePictureModel.class);
                return this.f13173g;
            }

            @Nullable
            public final String D_() {
                this.f13174h = super.a(this.f13174h, 4);
                return this.f13174h;
            }

            @Nullable
            public final String m13962a() {
                return m13966d();
            }

            public final int jK_() {
                return 2479791;
            }

            public final GraphQLVisitableModel m13961a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m13959j() != null) {
                    ProfilePictureModel profilePictureModel = (ProfilePictureModel) graphQLModelMutatingVisitor.b(m13959j());
                    if (m13959j() != profilePictureModel) {
                        graphQLVisitableModel = (AssociatedPagesModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f13173g = profilePictureModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m13960a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m13965b());
                int b = flatBufferBuilder.b(m13966d());
                int b2 = flatBufferBuilder.b(C_());
                int a2 = ModelHelper.a(flatBufferBuilder, m13959j());
                int b3 = flatBufferBuilder.b(D_());
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

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1352864475)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: MarketplacePostPublished */
        public final class DateContentModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private String f13175d;

            /* compiled from: MarketplacePostPublished */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(DateContentModel.class, new Deserializer());
                }

                public Object m13967a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(DateContentParser.m14146a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object dateContentModel = new DateContentModel();
                    ((BaseModel) dateContentModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (dateContentModel instanceof Postprocessable) {
                        return ((Postprocessable) dateContentModel).a();
                    }
                    return dateContentModel;
                }
            }

            /* compiled from: MarketplacePostPublished */
            public class Serializer extends JsonSerializer<DateContentModel> {
                public final void m13968a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    DateContentModel dateContentModel = (DateContentModel) obj;
                    if (dateContentModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(dateContentModel.m13969a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        dateContentModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    DateContentParser.m14147a(dateContentModel.w_(), dateContentModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(DateContentModel.class, new Serializer());
                }
            }

            public DateContentModel() {
                super(1);
            }

            @Nullable
            public final String m13971a() {
                this.f13175d = super.a(this.f13175d, 0);
                return this.f13175d;
            }

            public final int jK_() {
                return 2122702;
            }

            public final GraphQLVisitableModel m13970a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m13969a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m13971a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, b);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: MarketplacePostPublished */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(ProfileFieldInfoModel.class, new Deserializer());
            }

            public Object m13972a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(ProfileFieldInfoParser.m14172b(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object profileFieldInfoModel = new ProfileFieldInfoModel();
                ((BaseModel) profileFieldInfoModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (profileFieldInfoModel instanceof Postprocessable) {
                    return ((Postprocessable) profileFieldInfoModel).a();
                }
                return profileFieldInfoModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 398854959)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: MarketplacePostPublished */
        public final class EmailModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private String f13176d;

            /* compiled from: MarketplacePostPublished */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(EmailModel.class, new Deserializer());
                }

                public Object m13973a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(EmailParser.m14148a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object emailModel = new EmailModel();
                    ((BaseModel) emailModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (emailModel instanceof Postprocessable) {
                        return ((Postprocessable) emailModel).a();
                    }
                    return emailModel;
                }
            }

            /* compiled from: MarketplacePostPublished */
            public class Serializer extends JsonSerializer<EmailModel> {
                public final void m13974a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    EmailModel emailModel = (EmailModel) obj;
                    if (emailModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(emailModel.m13975a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        emailModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    EmailParser.m14149a(emailModel.w_(), emailModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(EmailModel.class, new Serializer());
                }
            }

            public EmailModel() {
                super(1);
            }

            @Nullable
            public final String m13977a() {
                this.f13176d = super.a(this.f13176d, 0);
                return this.f13176d;
            }

            public final int jK_() {
                return -906611496;
            }

            public final GraphQLVisitableModel m13976a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m13975a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m13977a());
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
        /* compiled from: MarketplacePostPublished */
        public final class IconModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private String f13177d;

            /* compiled from: MarketplacePostPublished */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(IconModel.class, new Deserializer());
                }

                public Object m13978a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(IconParser.m14150a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object iconModel = new IconModel();
                    ((BaseModel) iconModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (iconModel instanceof Postprocessable) {
                        return ((Postprocessable) iconModel).a();
                    }
                    return iconModel;
                }
            }

            /* compiled from: MarketplacePostPublished */
            public class Serializer extends JsonSerializer<IconModel> {
                public final void m13979a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    IconModel iconModel = (IconModel) obj;
                    if (iconModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(iconModel.m13980a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        iconModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    IconParser.m14151a(iconModel.w_(), iconModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(IconModel.class, new Serializer());
                }
            }

            public IconModel() {
                super(1);
            }

            @Nullable
            public final String m13982a() {
                this.f13177d = super.a(this.f13177d, 0);
                return this.f13177d;
            }

            public final int jK_() {
                return 70760763;
            }

            public final GraphQLVisitableModel m13981a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m13980a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m13982a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, b);
                i();
                return flatBufferBuilder.d();
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 1153213367)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: MarketplacePostPublished */
        public final class MenuOptionsModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private IconModel f13182d;
            @Nullable
            private NodeToDeleteModel f13183e;
            @Nullable
            private TitleModel f13184f;
            @Nullable
            private String f13185g;

            /* compiled from: MarketplacePostPublished */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(MenuOptionsModel.class, new Deserializer());
                }

                public Object m13983a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(MenuOptionsParser.m14159b(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object menuOptionsModel = new MenuOptionsModel();
                    ((BaseModel) menuOptionsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (menuOptionsModel instanceof Postprocessable) {
                        return ((Postprocessable) menuOptionsModel).a();
                    }
                    return menuOptionsModel;
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = 842551240)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: MarketplacePostPublished */
            public final class IconModel extends BaseModel implements GraphQLVisitableModel {
                @Nullable
                private String f13178d;

                /* compiled from: MarketplacePostPublished */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(IconModel.class, new Deserializer());
                    }

                    public Object m13984a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(MenuOptionsParser.IconParser.m14152a(jsonParser, flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                        Object iconModel = new IconModel();
                        ((BaseModel) iconModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                        if (iconModel instanceof Postprocessable) {
                            return ((Postprocessable) iconModel).a();
                        }
                        return iconModel;
                    }
                }

                /* compiled from: MarketplacePostPublished */
                public class Serializer extends JsonSerializer<IconModel> {
                    public final void m13985a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        IconModel iconModel = (IconModel) obj;
                        if (iconModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(iconModel.m13986a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            iconModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        MenuOptionsParser.IconParser.m14153a(iconModel.w_(), iconModel.u_(), jsonGenerator);
                    }

                    static {
                        FbSerializerProvider.a(IconModel.class, new Serializer());
                    }
                }

                public IconModel() {
                    super(1);
                }

                @Nullable
                public final String m13988a() {
                    this.f13178d = super.a(this.f13178d, 0);
                    return this.f13178d;
                }

                public final int jK_() {
                    return 70760763;
                }

                public final GraphQLVisitableModel m13987a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    h();
                    i();
                    return this;
                }

                public final int m13986a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int b = flatBufferBuilder.b(m13988a());
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.b(0, b);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = -1787905591)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: MarketplacePostPublished */
            public final class NodeToDeleteModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
                @Nullable
                private GraphQLObjectType f13179d;
                @Nullable
                private String f13180e;

                /* compiled from: MarketplacePostPublished */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(NodeToDeleteModel.class, new Deserializer());
                    }

                    public Object m13989a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(NodeToDeleteParser.m14154a(jsonParser, flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                        Object nodeToDeleteModel = new NodeToDeleteModel();
                        ((BaseModel) nodeToDeleteModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                        if (nodeToDeleteModel instanceof Postprocessable) {
                            return ((Postprocessable) nodeToDeleteModel).a();
                        }
                        return nodeToDeleteModel;
                    }
                }

                /* compiled from: MarketplacePostPublished */
                public class Serializer extends JsonSerializer<NodeToDeleteModel> {
                    public final void m13990a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        NodeToDeleteModel nodeToDeleteModel = (NodeToDeleteModel) obj;
                        if (nodeToDeleteModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(nodeToDeleteModel.m13992a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            nodeToDeleteModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        NodeToDeleteParser.m14155a(nodeToDeleteModel.w_(), nodeToDeleteModel.u_(), jsonGenerator);
                    }

                    static {
                        FbSerializerProvider.a(NodeToDeleteModel.class, new Serializer());
                    }
                }

                public NodeToDeleteModel() {
                    super(2);
                }

                public final void m13995a(String str, ConsistencyTuple consistencyTuple) {
                    consistencyTuple.a();
                }

                public final void m13996a(String str, Object obj, boolean z) {
                }

                @Nullable
                private GraphQLObjectType m13991k() {
                    if (this.b != null && this.f13179d == null) {
                        this.f13179d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
                    }
                    return this.f13179d;
                }

                @Nullable
                public final String m13997j() {
                    this.f13180e = super.a(this.f13180e, 1);
                    return this.f13180e;
                }

                @Nullable
                public final String m13994a() {
                    return m13997j();
                }

                public final int jK_() {
                    return 2433570;
                }

                public final GraphQLVisitableModel m13993a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    h();
                    i();
                    return this;
                }

                public final int m13992a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int a = ModelHelper.a(flatBufferBuilder, m13991k());
                    int b = flatBufferBuilder.b(m13997j());
                    flatBufferBuilder.c(2);
                    flatBufferBuilder.b(0, a);
                    flatBufferBuilder.b(1, b);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            /* compiled from: MarketplacePostPublished */
            public class Serializer extends JsonSerializer<MenuOptionsModel> {
                public final void m13998a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    MenuOptionsModel menuOptionsModel = (MenuOptionsModel) obj;
                    if (menuOptionsModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(menuOptionsModel.m14004a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        menuOptionsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    MenuOptionsParser.m14160b(menuOptionsModel.w_(), menuOptionsModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(MenuOptionsModel.class, new Serializer());
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = -1352864475)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: MarketplacePostPublished */
            public final class TitleModel extends BaseModel implements GraphQLVisitableModel {
                @Nullable
                private String f13181d;

                /* compiled from: MarketplacePostPublished */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(TitleModel.class, new Deserializer());
                    }

                    public Object m13999a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(TitleParser.m14156a(jsonParser, flatBufferBuilder));
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

                /* compiled from: MarketplacePostPublished */
                public class Serializer extends JsonSerializer<TitleModel> {
                    public final void m14000a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        TitleModel titleModel = (TitleModel) obj;
                        if (titleModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(titleModel.m14001a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            titleModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        TitleParser.m14157a(titleModel.w_(), titleModel.u_(), jsonGenerator);
                    }

                    static {
                        FbSerializerProvider.a(TitleModel.class, new Serializer());
                    }
                }

                public TitleModel() {
                    super(1);
                }

                @Nullable
                public final String m14003a() {
                    this.f13181d = super.a(this.f13181d, 0);
                    return this.f13181d;
                }

                public final int jK_() {
                    return -1919764332;
                }

                public final GraphQLVisitableModel m14002a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    h();
                    i();
                    return this;
                }

                public final int m14001a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int b = flatBufferBuilder.b(m14003a());
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.b(0, b);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            public MenuOptionsModel() {
                super(4);
            }

            @Nullable
            public final IconModel m14006a() {
                this.f13182d = (IconModel) super.a(this.f13182d, 0, IconModel.class);
                return this.f13182d;
            }

            @Nullable
            public final NodeToDeleteModel m14007j() {
                this.f13183e = (NodeToDeleteModel) super.a(this.f13183e, 1, NodeToDeleteModel.class);
                return this.f13183e;
            }

            @Nullable
            public final TitleModel m14008k() {
                this.f13184f = (TitleModel) super.a(this.f13184f, 2, TitleModel.class);
                return this.f13184f;
            }

            @Nullable
            public final String m14009l() {
                this.f13185g = super.a(this.f13185g, 3);
                return this.f13185g;
            }

            public final int jK_() {
                return -1154283899;
            }

            public final GraphQLVisitableModel m14005a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m14006a() != null) {
                    IconModel iconModel = (IconModel) graphQLModelMutatingVisitor.b(m14006a());
                    if (m14006a() != iconModel) {
                        graphQLVisitableModel = (MenuOptionsModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f13182d = iconModel;
                    }
                }
                if (m14007j() != null) {
                    NodeToDeleteModel nodeToDeleteModel = (NodeToDeleteModel) graphQLModelMutatingVisitor.b(m14007j());
                    if (m14007j() != nodeToDeleteModel) {
                        graphQLVisitableModel = (MenuOptionsModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f13183e = nodeToDeleteModel;
                    }
                }
                if (m14008k() != null) {
                    TitleModel titleModel = (TitleModel) graphQLModelMutatingVisitor.b(m14008k());
                    if (m14008k() != titleModel) {
                        graphQLVisitableModel = (MenuOptionsModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f13184f = titleModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m14004a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m14006a());
                int a2 = ModelHelper.a(flatBufferBuilder, m14007j());
                int a3 = ModelHelper.a(flatBufferBuilder, m14008k());
                int b = flatBufferBuilder.b(m14009l());
                flatBufferBuilder.c(4);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.b(1, a2);
                flatBufferBuilder.b(2, a3);
                flatBufferBuilder.b(3, b);
                i();
                return flatBufferBuilder.d();
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 44074500)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: MarketplacePostPublished */
        public final class PhoneNumberModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private String f13186d;
            @Nullable
            private String f13187e;

            /* compiled from: MarketplacePostPublished */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(PhoneNumberModel.class, new Deserializer());
                }

                public Object m14010a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(PhoneNumberParser.m14161a(jsonParser, flatBufferBuilder));
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

            /* compiled from: MarketplacePostPublished */
            public class Serializer extends JsonSerializer<PhoneNumberModel> {
                public final void m14011a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    PhoneNumberModel phoneNumberModel = (PhoneNumberModel) obj;
                    if (phoneNumberModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(phoneNumberModel.m14012a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        phoneNumberModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    PhoneNumberParser.m14162a(phoneNumberModel.w_(), phoneNumberModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(PhoneNumberModel.class, new Serializer());
                }
            }

            public PhoneNumberModel() {
                super(2);
            }

            @Nullable
            public final String m14014a() {
                this.f13186d = super.a(this.f13186d, 0);
                return this.f13186d;
            }

            @Nullable
            public final String m14015j() {
                this.f13187e = super.a(this.f13187e, 1);
                return this.f13187e;
            }

            public final int jK_() {
                return 474898999;
            }

            public final GraphQLVisitableModel m14013a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m14012a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m14014a());
                int b2 = flatBufferBuilder.b(m14015j());
                flatBufferBuilder.c(2);
                flatBufferBuilder.b(0, b);
                flatBufferBuilder.b(1, b2);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: MarketplacePostPublished */
        public class Serializer extends JsonSerializer<ProfileFieldInfoModel> {
            public final void m14016a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                ProfileFieldInfoModel profileFieldInfoModel = (ProfileFieldInfoModel) obj;
                if (profileFieldInfoModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(profileFieldInfoModel.m14037a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    profileFieldInfoModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                ProfileFieldInfoParser.m14173b(profileFieldInfoModel.w_(), profileFieldInfoModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(ProfileFieldInfoModel.class, new Serializer());
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1352864475)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: MarketplacePostPublished */
        public final class StringsListContentModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private String f13188d;

            /* compiled from: MarketplacePostPublished */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(StringsListContentModel.class, new Deserializer());
                }

                public Object m14017a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(StringsListContentParser.m14165b(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object stringsListContentModel = new StringsListContentModel();
                    ((BaseModel) stringsListContentModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (stringsListContentModel instanceof Postprocessable) {
                        return ((Postprocessable) stringsListContentModel).a();
                    }
                    return stringsListContentModel;
                }
            }

            /* compiled from: MarketplacePostPublished */
            public class Serializer extends JsonSerializer<StringsListContentModel> {
                public final void m14018a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    StringsListContentModel stringsListContentModel = (StringsListContentModel) obj;
                    if (stringsListContentModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(stringsListContentModel.m14019a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        stringsListContentModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    StringsListContentParser.m14164a(stringsListContentModel.w_(), stringsListContentModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(StringsListContentModel.class, new Serializer());
                }
            }

            public StringsListContentModel() {
                super(1);
            }

            @Nullable
            public final String m14021a() {
                this.f13188d = super.a(this.f13188d, 0);
                return this.f13188d;
            }

            public final int jK_() {
                return -1919764332;
            }

            public final GraphQLVisitableModel m14020a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m14019a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m14021a());
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
        /* compiled from: MarketplacePostPublished */
        public final class TextContentModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private String f13189d;

            /* compiled from: MarketplacePostPublished */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(TextContentModel.class, new Deserializer());
                }

                public Object m14022a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(TextContentParser.m14166a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object textContentModel = new TextContentModel();
                    ((BaseModel) textContentModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (textContentModel instanceof Postprocessable) {
                        return ((Postprocessable) textContentModel).a();
                    }
                    return textContentModel;
                }
            }

            /* compiled from: MarketplacePostPublished */
            public class Serializer extends JsonSerializer<TextContentModel> {
                public final void m14023a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    TextContentModel textContentModel = (TextContentModel) obj;
                    if (textContentModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(textContentModel.m14024a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        textContentModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    TextContentParser.m14167a(textContentModel.w_(), textContentModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(TextContentModel.class, new Serializer());
                }
            }

            public TextContentModel() {
                super(1);
            }

            @Nullable
            public final String m14026a() {
                this.f13189d = super.a(this.f13189d, 0);
                return this.f13189d;
            }

            public final int jK_() {
                return -1919764332;
            }

            public final GraphQLVisitableModel m14025a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m14024a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m14026a());
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
        /* compiled from: MarketplacePostPublished */
        public final class TitleModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private String f13190d;

            /* compiled from: MarketplacePostPublished */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(TitleModel.class, new Deserializer());
                }

                public Object m14027a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(ProfileFieldInfoParser.TitleParser.m14168a(jsonParser, flatBufferBuilder));
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

            /* compiled from: MarketplacePostPublished */
            public class Serializer extends JsonSerializer<TitleModel> {
                public final void m14028a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    TitleModel titleModel = (TitleModel) obj;
                    if (titleModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(titleModel.m14029a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        titleModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    ProfileFieldInfoParser.TitleParser.m14169a(titleModel.w_(), titleModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(TitleModel.class, new Serializer());
                }
            }

            public TitleModel() {
                super(1);
            }

            @Nullable
            public final String m14031a() {
                this.f13190d = super.a(this.f13190d, 0);
                return this.f13190d;
            }

            public final int jK_() {
                return -1919764332;
            }

            public final GraphQLVisitableModel m14030a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m14029a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m14031a());
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
        /* compiled from: MarketplacePostPublished */
        public final class UpsellTextModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private String f13191d;

            /* compiled from: MarketplacePostPublished */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(UpsellTextModel.class, new Deserializer());
                }

                public Object m14032a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(UpsellTextParser.m14170a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object upsellTextModel = new UpsellTextModel();
                    ((BaseModel) upsellTextModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (upsellTextModel instanceof Postprocessable) {
                        return ((Postprocessable) upsellTextModel).a();
                    }
                    return upsellTextModel;
                }
            }

            /* compiled from: MarketplacePostPublished */
            public class Serializer extends JsonSerializer<UpsellTextModel> {
                public final void m14033a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    UpsellTextModel upsellTextModel = (UpsellTextModel) obj;
                    if (upsellTextModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(upsellTextModel.m14034a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        upsellTextModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    UpsellTextParser.m14171a(upsellTextModel.w_(), upsellTextModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(UpsellTextModel.class, new Serializer());
                }
            }

            public UpsellTextModel() {
                super(1);
            }

            @Nullable
            public final String m14036a() {
                this.f13191d = super.a(this.f13191d, 0);
                return this.f13191d;
            }

            public final int jK_() {
                return -1919764332;
            }

            public final GraphQLVisitableModel m14035a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m14034a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m14036a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, b);
                i();
                return flatBufferBuilder.d();
            }
        }

        @Nullable
        public final /* synthetic */ TextContentModel m14042c() {
            return m14056v();
        }

        @Nullable
        public final /* synthetic */ UpsellTextModel m14043d() {
            return m14059y();
        }

        public ProfileFieldInfoModel() {
            super(18);
        }

        @Nonnull
        public final ImmutableList<AssociatedPagesModel> m14044j() {
            this.f13192d = super.a(this.f13192d, 0, AssociatedPagesModel.class);
            return (ImmutableList) this.f13192d;
        }

        @Nullable
        public final DateContentModel m14045k() {
            this.f13193e = (DateContentModel) super.a(this.f13193e, 1, DateContentModel.class);
            return this.f13193e;
        }

        @Nullable
        public final String m14039a() {
            this.f13194f = super.a(this.f13194f, 2);
            return this.f13194f;
        }

        @Nullable
        public final EmailModel m14046l() {
            this.f13195g = (EmailModel) super.a(this.f13195g, 3, EmailModel.class);
            return this.f13195g;
        }

        public final boolean m14047m() {
            a(0, 4);
            return this.f13196h;
        }

        @Nullable
        public final IconModel m14048n() {
            this.f13197i = (IconModel) super.a(this.f13197i, 5, IconModel.class);
            return this.f13197i;
        }

        @Nullable
        public final String m14049o() {
            this.f13198j = super.a(this.f13198j, 6);
            return this.f13198j;
        }

        @Nullable
        public final String m14050p() {
            this.f13199k = super.a(this.f13199k, 7);
            return this.f13199k;
        }

        @Nonnull
        public final ImmutableList<ProfileFieldTextListItemGroupInfoModel> m14051q() {
            this.f13200l = super.a(this.f13200l, 8, ProfileFieldTextListItemGroupInfoModel.class);
            return (ImmutableList) this.f13200l;
        }

        @Nonnull
        public final ImmutableList<MenuOptionsModel> m14052r() {
            this.f13201m = super.a(this.f13201m, 9, MenuOptionsModel.class);
            return (ImmutableList) this.f13201m;
        }

        @Nullable
        public final PhoneNumberModel m14053s() {
            this.f13202n = (PhoneNumberModel) super.a(this.f13202n, 10, PhoneNumberModel.class);
            return this.f13202n;
        }

        public final boolean m14054t() {
            a(1, 3);
            return this.f13203o;
        }

        @Nonnull
        public final ImmutableList<StringsListContentModel> m14055u() {
            this.f13204p = super.a(this.f13204p, 12, StringsListContentModel.class);
            return (ImmutableList) this.f13204p;
        }

        @Nonnull
        public final ImmutableList<GraphQLProfileFieldStyle> m14041b() {
            this.f13205q = super.c(this.f13205q, 13, GraphQLProfileFieldStyle.class);
            return (ImmutableList) this.f13205q;
        }

        @Nullable
        public final TextContentModel m14056v() {
            this.f13206r = (TextContentModel) super.a(this.f13206r, 14, TextContentModel.class);
            return this.f13206r;
        }

        @Nonnull
        public final ImmutableList<String> m14057w() {
            this.f13207s = super.a(this.f13207s, 15);
            return (ImmutableList) this.f13207s;
        }

        @Nullable
        public final TitleModel m14058x() {
            this.f13208t = (TitleModel) super.a(this.f13208t, 16, TitleModel.class);
            return this.f13208t;
        }

        @Nullable
        public final UpsellTextModel m14059y() {
            this.f13209u = (UpsellTextModel) super.a(this.f13209u, 17, UpsellTextModel.class);
            return this.f13209u;
        }

        public final int jK_() {
            return 1364794609;
        }

        public final GraphQLVisitableModel m14038a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            ProfileFieldInfoModel profileFieldInfoModel;
            GraphQLVisitableModel graphQLVisitableModel;
            DateContentModel dateContentModel;
            EmailModel emailModel;
            IconModel iconModel;
            Builder a;
            PhoneNumberModel phoneNumberModel;
            TextContentModel textContentModel;
            TitleModel titleModel;
            UpsellTextModel upsellTextModel;
            h();
            if (m14044j() != null) {
                Builder a2 = ModelHelper.a(m14044j(), graphQLModelMutatingVisitor);
                if (a2 != null) {
                    profileFieldInfoModel = (ProfileFieldInfoModel) ModelHelper.a(null, this);
                    profileFieldInfoModel.f13192d = a2.b();
                    graphQLVisitableModel = profileFieldInfoModel;
                    if (m14045k() != null) {
                        dateContentModel = (DateContentModel) graphQLModelMutatingVisitor.b(m14045k());
                        if (m14045k() != dateContentModel) {
                            graphQLVisitableModel = (ProfileFieldInfoModel) ModelHelper.a(graphQLVisitableModel, this);
                            graphQLVisitableModel.f13193e = dateContentModel;
                        }
                    }
                    if (m14046l() != null) {
                        emailModel = (EmailModel) graphQLModelMutatingVisitor.b(m14046l());
                        if (m14046l() != emailModel) {
                            graphQLVisitableModel = (ProfileFieldInfoModel) ModelHelper.a(graphQLVisitableModel, this);
                            graphQLVisitableModel.f13195g = emailModel;
                        }
                    }
                    if (m14048n() != null) {
                        iconModel = (IconModel) graphQLModelMutatingVisitor.b(m14048n());
                        if (m14048n() != iconModel) {
                            graphQLVisitableModel = (ProfileFieldInfoModel) ModelHelper.a(graphQLVisitableModel, this);
                            graphQLVisitableModel.f13197i = iconModel;
                        }
                    }
                    if (m14051q() != null) {
                        a = ModelHelper.a(m14051q(), graphQLModelMutatingVisitor);
                        if (a != null) {
                            profileFieldInfoModel = (ProfileFieldInfoModel) ModelHelper.a(graphQLVisitableModel, this);
                            profileFieldInfoModel.f13200l = a.b();
                            graphQLVisitableModel = profileFieldInfoModel;
                        }
                    }
                    if (m14052r() != null) {
                        a = ModelHelper.a(m14052r(), graphQLModelMutatingVisitor);
                        if (a != null) {
                            profileFieldInfoModel = (ProfileFieldInfoModel) ModelHelper.a(graphQLVisitableModel, this);
                            profileFieldInfoModel.f13201m = a.b();
                            graphQLVisitableModel = profileFieldInfoModel;
                        }
                    }
                    if (m14053s() != null) {
                        phoneNumberModel = (PhoneNumberModel) graphQLModelMutatingVisitor.b(m14053s());
                        if (m14053s() != phoneNumberModel) {
                            graphQLVisitableModel = (ProfileFieldInfoModel) ModelHelper.a(graphQLVisitableModel, this);
                            graphQLVisitableModel.f13202n = phoneNumberModel;
                        }
                    }
                    if (m14055u() != null) {
                        a = ModelHelper.a(m14055u(), graphQLModelMutatingVisitor);
                        if (a != null) {
                            profileFieldInfoModel = (ProfileFieldInfoModel) ModelHelper.a(graphQLVisitableModel, this);
                            profileFieldInfoModel.f13204p = a.b();
                            graphQLVisitableModel = profileFieldInfoModel;
                        }
                    }
                    if (m14056v() != null) {
                        textContentModel = (TextContentModel) graphQLModelMutatingVisitor.b(m14056v());
                        if (m14056v() != textContentModel) {
                            graphQLVisitableModel = (ProfileFieldInfoModel) ModelHelper.a(graphQLVisitableModel, this);
                            graphQLVisitableModel.f13206r = textContentModel;
                        }
                    }
                    if (m14058x() != null) {
                        titleModel = (TitleModel) graphQLModelMutatingVisitor.b(m14058x());
                        if (m14058x() != titleModel) {
                            graphQLVisitableModel = (ProfileFieldInfoModel) ModelHelper.a(graphQLVisitableModel, this);
                            graphQLVisitableModel.f13208t = titleModel;
                        }
                    }
                    if (m14059y() != null) {
                        upsellTextModel = (UpsellTextModel) graphQLModelMutatingVisitor.b(m14059y());
                        if (m14059y() != upsellTextModel) {
                            graphQLVisitableModel = (ProfileFieldInfoModel) ModelHelper.a(graphQLVisitableModel, this);
                            graphQLVisitableModel.f13209u = upsellTextModel;
                        }
                    }
                    i();
                    return graphQLVisitableModel != null ? this : graphQLVisitableModel;
                }
            }
            graphQLVisitableModel = null;
            if (m14045k() != null) {
                dateContentModel = (DateContentModel) graphQLModelMutatingVisitor.b(m14045k());
                if (m14045k() != dateContentModel) {
                    graphQLVisitableModel = (ProfileFieldInfoModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f13193e = dateContentModel;
                }
            }
            if (m14046l() != null) {
                emailModel = (EmailModel) graphQLModelMutatingVisitor.b(m14046l());
                if (m14046l() != emailModel) {
                    graphQLVisitableModel = (ProfileFieldInfoModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f13195g = emailModel;
                }
            }
            if (m14048n() != null) {
                iconModel = (IconModel) graphQLModelMutatingVisitor.b(m14048n());
                if (m14048n() != iconModel) {
                    graphQLVisitableModel = (ProfileFieldInfoModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f13197i = iconModel;
                }
            }
            if (m14051q() != null) {
                a = ModelHelper.a(m14051q(), graphQLModelMutatingVisitor);
                if (a != null) {
                    profileFieldInfoModel = (ProfileFieldInfoModel) ModelHelper.a(graphQLVisitableModel, this);
                    profileFieldInfoModel.f13200l = a.b();
                    graphQLVisitableModel = profileFieldInfoModel;
                }
            }
            if (m14052r() != null) {
                a = ModelHelper.a(m14052r(), graphQLModelMutatingVisitor);
                if (a != null) {
                    profileFieldInfoModel = (ProfileFieldInfoModel) ModelHelper.a(graphQLVisitableModel, this);
                    profileFieldInfoModel.f13201m = a.b();
                    graphQLVisitableModel = profileFieldInfoModel;
                }
            }
            if (m14053s() != null) {
                phoneNumberModel = (PhoneNumberModel) graphQLModelMutatingVisitor.b(m14053s());
                if (m14053s() != phoneNumberModel) {
                    graphQLVisitableModel = (ProfileFieldInfoModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f13202n = phoneNumberModel;
                }
            }
            if (m14055u() != null) {
                a = ModelHelper.a(m14055u(), graphQLModelMutatingVisitor);
                if (a != null) {
                    profileFieldInfoModel = (ProfileFieldInfoModel) ModelHelper.a(graphQLVisitableModel, this);
                    profileFieldInfoModel.f13204p = a.b();
                    graphQLVisitableModel = profileFieldInfoModel;
                }
            }
            if (m14056v() != null) {
                textContentModel = (TextContentModel) graphQLModelMutatingVisitor.b(m14056v());
                if (m14056v() != textContentModel) {
                    graphQLVisitableModel = (ProfileFieldInfoModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f13206r = textContentModel;
                }
            }
            if (m14058x() != null) {
                titleModel = (TitleModel) graphQLModelMutatingVisitor.b(m14058x());
                if (m14058x() != titleModel) {
                    graphQLVisitableModel = (ProfileFieldInfoModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f13208t = titleModel;
                }
            }
            if (m14059y() != null) {
                upsellTextModel = (UpsellTextModel) graphQLModelMutatingVisitor.b(m14059y());
                if (m14059y() != upsellTextModel) {
                    graphQLVisitableModel = (ProfileFieldInfoModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f13209u = upsellTextModel;
                }
            }
            i();
            if (graphQLVisitableModel != null) {
            }
        }

        public final int m14037a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m14044j());
            int a2 = ModelHelper.a(flatBufferBuilder, m14045k());
            int b = flatBufferBuilder.b(m14039a());
            int a3 = ModelHelper.a(flatBufferBuilder, m14046l());
            int a4 = ModelHelper.a(flatBufferBuilder, m14048n());
            int b2 = flatBufferBuilder.b(m14049o());
            int b3 = flatBufferBuilder.b(m14050p());
            int a5 = ModelHelper.a(flatBufferBuilder, m14051q());
            int a6 = ModelHelper.a(flatBufferBuilder, m14052r());
            int a7 = ModelHelper.a(flatBufferBuilder, m14053s());
            int a8 = ModelHelper.a(flatBufferBuilder, m14055u());
            int d = flatBufferBuilder.d(m14041b());
            int a9 = ModelHelper.a(flatBufferBuilder, m14056v());
            int c = flatBufferBuilder.c(m14057w());
            int a10 = ModelHelper.a(flatBufferBuilder, m14058x());
            int a11 = ModelHelper.a(flatBufferBuilder, m14059y());
            flatBufferBuilder.c(18);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, a2);
            flatBufferBuilder.b(2, b);
            flatBufferBuilder.b(3, a3);
            flatBufferBuilder.a(4, this.f13196h);
            flatBufferBuilder.b(5, a4);
            flatBufferBuilder.b(6, b2);
            flatBufferBuilder.b(7, b3);
            flatBufferBuilder.b(8, a5);
            flatBufferBuilder.b(9, a6);
            flatBufferBuilder.b(10, a7);
            flatBufferBuilder.a(11, this.f13203o);
            flatBufferBuilder.b(12, a8);
            flatBufferBuilder.b(13, d);
            flatBufferBuilder.b(14, a9);
            flatBufferBuilder.b(15, c);
            flatBufferBuilder.b(16, a10);
            flatBufferBuilder.b(17, a11);
            i();
            return flatBufferBuilder.d();
        }

        public final void m14040a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
            super.a(mutableFlatBuffer, i, obj);
            this.f13196h = mutableFlatBuffer.a(i, 4);
            this.f13203o = mutableFlatBuffer.a(i, 11);
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 1415953550)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: MarketplacePostPublished */
    public final class ProfileFieldSectionFieldsModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private ProfileFieldsModel f13211d;

        /* compiled from: MarketplacePostPublished */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(ProfileFieldSectionFieldsModel.class, new Deserializer());
            }

            public Object m14060a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = ProfileFieldSectionFieldsParser.m14176a(jsonParser);
                Object profileFieldSectionFieldsModel = new ProfileFieldSectionFieldsModel();
                ((BaseModel) profileFieldSectionFieldsModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (profileFieldSectionFieldsModel instanceof Postprocessable) {
                    return ((Postprocessable) profileFieldSectionFieldsModel).a();
                }
                return profileFieldSectionFieldsModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -695359263)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: MarketplacePostPublished */
        public final class ProfileFieldsModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private List<ProfileFieldInfoModel> f13210d;

            /* compiled from: MarketplacePostPublished */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(ProfileFieldsModel.class, new Deserializer());
                }

                public Object m14061a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(ProfileFieldsParser.m14174a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object profileFieldsModel = new ProfileFieldsModel();
                    ((BaseModel) profileFieldsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (profileFieldsModel instanceof Postprocessable) {
                        return ((Postprocessable) profileFieldsModel).a();
                    }
                    return profileFieldsModel;
                }
            }

            /* compiled from: MarketplacePostPublished */
            public class Serializer extends JsonSerializer<ProfileFieldsModel> {
                public final void m14062a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    ProfileFieldsModel profileFieldsModel = (ProfileFieldsModel) obj;
                    if (profileFieldsModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(profileFieldsModel.m14063a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        profileFieldsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    ProfileFieldsParser.m14175a(profileFieldsModel.w_(), profileFieldsModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(ProfileFieldsModel.class, new Serializer());
                }
            }

            public ProfileFieldsModel() {
                super(1);
            }

            @Nonnull
            public final ImmutableList<ProfileFieldInfoModel> m14065a() {
                this.f13210d = super.a(this.f13210d, 0, ProfileFieldInfoModel.class);
                return (ImmutableList) this.f13210d;
            }

            public final int jK_() {
                return 1689041440;
            }

            public final GraphQLVisitableModel m14064a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m14065a() != null) {
                    Builder a = ModelHelper.a(m14065a(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        graphQLVisitableModel = (ProfileFieldsModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f13210d = a.b();
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m14063a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m14065a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, a);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: MarketplacePostPublished */
        public class Serializer extends JsonSerializer<ProfileFieldSectionFieldsModel> {
            public final void m14066a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                ProfileFieldSectionFieldsModel profileFieldSectionFieldsModel = (ProfileFieldSectionFieldsModel) obj;
                if (profileFieldSectionFieldsModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(profileFieldSectionFieldsModel.m14068a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    profileFieldSectionFieldsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = profileFieldSectionFieldsModel.w_();
                int u_ = profileFieldSectionFieldsModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("profile_fields");
                    ProfileFieldsParser.m14175a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(ProfileFieldSectionFieldsModel.class, new Serializer());
            }
        }

        public ProfileFieldSectionFieldsModel() {
            super(1);
        }

        @Nullable
        private ProfileFieldsModel m14067a() {
            this.f13211d = (ProfileFieldsModel) super.a(this.f13211d, 0, ProfileFieldsModel.class);
            return this.f13211d;
        }

        public final int jK_() {
            return 1829943476;
        }

        public final GraphQLVisitableModel m14069a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m14067a() != null) {
                ProfileFieldsModel profileFieldsModel = (ProfileFieldsModel) graphQLModelMutatingVisitor.b(m14067a());
                if (m14067a() != profileFieldsModel) {
                    graphQLVisitableModel = (ProfileFieldSectionFieldsModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f13211d = profileFieldsModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m14068a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m14067a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -1129883178)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: MarketplacePostPublished */
    public final class ProfileFieldSectionHeaderModel extends BaseModel implements GraphQLVisitableModel, ProfileFieldSectionHeader {
        @Nullable
        private String f13213d;
        @Nullable
        private TitleModel f13214e;

        /* compiled from: MarketplacePostPublished */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(ProfileFieldSectionHeaderModel.class, new Deserializer());
            }

            public Object m14070a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = ProfileFieldSectionHeaderParser.m14179a(jsonParser);
                Object profileFieldSectionHeaderModel = new ProfileFieldSectionHeaderModel();
                ((BaseModel) profileFieldSectionHeaderModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (profileFieldSectionHeaderModel instanceof Postprocessable) {
                    return ((Postprocessable) profileFieldSectionHeaderModel).a();
                }
                return profileFieldSectionHeaderModel;
            }
        }

        /* compiled from: MarketplacePostPublished */
        public class Serializer extends JsonSerializer<ProfileFieldSectionHeaderModel> {
            public final void m14071a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                ProfileFieldSectionHeaderModel profileFieldSectionHeaderModel = (ProfileFieldSectionHeaderModel) obj;
                if (profileFieldSectionHeaderModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(profileFieldSectionHeaderModel.m14079a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    profileFieldSectionHeaderModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = profileFieldSectionHeaderModel.w_();
                int u_ = profileFieldSectionHeaderModel.u_();
                jsonGenerator.f();
                if (mutableFlatBuffer.g(u_, 0) != 0) {
                    jsonGenerator.a("edit_uri");
                    jsonGenerator.b(mutableFlatBuffer.c(u_, 0));
                }
                int g = mutableFlatBuffer.g(u_, 1);
                if (g != 0) {
                    jsonGenerator.a("title");
                    ProfileFieldSectionHeaderParser.TitleParser.m14178a(mutableFlatBuffer, g, jsonGenerator);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(ProfileFieldSectionHeaderModel.class, new Serializer());
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1352864475)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: MarketplacePostPublished */
        public final class TitleModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private String f13212d;

            /* compiled from: MarketplacePostPublished */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(TitleModel.class, new Deserializer());
                }

                public Object m14072a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(ProfileFieldSectionHeaderParser.TitleParser.m14177a(jsonParser, flatBufferBuilder));
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

            /* compiled from: MarketplacePostPublished */
            public class Serializer extends JsonSerializer<TitleModel> {
                public final void m14073a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    TitleModel titleModel = (TitleModel) obj;
                    if (titleModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(titleModel.m14074a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        titleModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    ProfileFieldSectionHeaderParser.TitleParser.m14178a(titleModel.w_(), titleModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(TitleModel.class, new Serializer());
                }
            }

            public TitleModel() {
                super(1);
            }

            @Nullable
            public final String m14076a() {
                this.f13212d = super.a(this.f13212d, 0);
                return this.f13212d;
            }

            public final int jK_() {
                return -1919764332;
            }

            public final GraphQLVisitableModel m14075a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m14074a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m14076a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, b);
                i();
                return flatBufferBuilder.d();
            }
        }

        public ProfileFieldSectionHeaderModel() {
            super(2);
        }

        @Nullable
        private String m14077a() {
            this.f13213d = super.a(this.f13213d, 0);
            return this.f13213d;
        }

        @Nullable
        private TitleModel m14078j() {
            this.f13214e = (TitleModel) super.a(this.f13214e, 1, TitleModel.class);
            return this.f13214e;
        }

        public final int jK_() {
            return 1829943476;
        }

        public final GraphQLVisitableModel m14080a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m14078j() != null) {
                TitleModel titleModel = (TitleModel) graphQLModelMutatingVisitor.b(m14078j());
                if (m14078j() != titleModel) {
                    graphQLVisitableModel = (ProfileFieldSectionHeaderModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f13214e = titleModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m14079a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(m14077a());
            int a = ModelHelper.a(flatBufferBuilder, m14078j());
            flatBufferBuilder.c(2);
            flatBufferBuilder.b(0, b);
            flatBufferBuilder.b(1, a);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -103610955)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: MarketplacePostPublished */
    public final class ProfileFieldSectionInfoModel extends BaseModel implements GraphQLVisitableModel, ProfileFieldSectionHeader {
        @Nullable
        private String f13215d;
        @Nullable
        private ProfileFieldsModel f13216e;
        @Nullable
        private TitleModel f13217f;

        /* compiled from: MarketplacePostPublished */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(ProfileFieldSectionInfoModel.class, new Deserializer());
            }

            public Object m14081a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(ProfileFieldSectionInfoParser.m14180b(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object profileFieldSectionInfoModel = new ProfileFieldSectionInfoModel();
                ((BaseModel) profileFieldSectionInfoModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (profileFieldSectionInfoModel instanceof Postprocessable) {
                    return ((Postprocessable) profileFieldSectionInfoModel).a();
                }
                return profileFieldSectionInfoModel;
            }
        }

        /* compiled from: MarketplacePostPublished */
        public class Serializer extends JsonSerializer<ProfileFieldSectionInfoModel> {
            public final void m14082a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                ProfileFieldSectionInfoModel profileFieldSectionInfoModel = (ProfileFieldSectionInfoModel) obj;
                if (profileFieldSectionInfoModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(profileFieldSectionInfoModel.m14083a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    profileFieldSectionInfoModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                ProfileFieldSectionInfoParser.m14181b(profileFieldSectionInfoModel.w_(), profileFieldSectionInfoModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(ProfileFieldSectionInfoModel.class, new Serializer());
            }
        }

        @Nullable
        public final /* synthetic */ TitleModel m14086b() {
            return m14088k();
        }

        public ProfileFieldSectionInfoModel() {
            super(3);
        }

        @Nullable
        public final String m14085a() {
            this.f13215d = super.a(this.f13215d, 0);
            return this.f13215d;
        }

        @Nullable
        public final ProfileFieldsModel m14087j() {
            this.f13216e = (ProfileFieldsModel) super.a(this.f13216e, 1, ProfileFieldsModel.class);
            return this.f13216e;
        }

        @Nullable
        public final TitleModel m14088k() {
            this.f13217f = (TitleModel) super.a(this.f13217f, 2, TitleModel.class);
            return this.f13217f;
        }

        public final int jK_() {
            return 1829943476;
        }

        public final GraphQLVisitableModel m14084a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m14087j() != null) {
                ProfileFieldsModel profileFieldsModel = (ProfileFieldsModel) graphQLModelMutatingVisitor.b(m14087j());
                if (m14087j() != profileFieldsModel) {
                    graphQLVisitableModel = (ProfileFieldSectionInfoModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f13216e = profileFieldsModel;
                }
            }
            if (m14088k() != null) {
                TitleModel titleModel = (TitleModel) graphQLModelMutatingVisitor.b(m14088k());
                if (m14088k() != titleModel) {
                    graphQLVisitableModel = (ProfileFieldSectionInfoModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f13217f = titleModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m14083a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(m14085a());
            int a = ModelHelper.a(flatBufferBuilder, m14087j());
            int a2 = ModelHelper.a(flatBufferBuilder, m14088k());
            flatBufferBuilder.c(3);
            flatBufferBuilder.b(0, b);
            flatBufferBuilder.b(1, a);
            flatBufferBuilder.b(2, a2);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -1499271189)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: MarketplacePostPublished */
    public final class ProfileFieldTextListItemGroupInfoModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private List<ListItemsModel> f13220d;

        /* compiled from: MarketplacePostPublished */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(ProfileFieldTextListItemGroupInfoModel.class, new Deserializer());
            }

            public Object m14089a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(ProfileFieldTextListItemGroupInfoParser.m14185b(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object profileFieldTextListItemGroupInfoModel = new ProfileFieldTextListItemGroupInfoModel();
                ((BaseModel) profileFieldTextListItemGroupInfoModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (profileFieldTextListItemGroupInfoModel instanceof Postprocessable) {
                    return ((Postprocessable) profileFieldTextListItemGroupInfoModel).a();
                }
                return profileFieldTextListItemGroupInfoModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -232245231)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: MarketplacePostPublished */
        public final class ListItemsModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private GraphQLProfileFieldTextListItemHeadingType f13218d;
            @Nullable
            private TextWithEntitiesInfoModel f13219e;

            /* compiled from: MarketplacePostPublished */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(ListItemsModel.class, new Deserializer());
                }

                public Object m14090a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(ListItemsParser.m14182b(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object listItemsModel = new ListItemsModel();
                    ((BaseModel) listItemsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (listItemsModel instanceof Postprocessable) {
                        return ((Postprocessable) listItemsModel).a();
                    }
                    return listItemsModel;
                }
            }

            /* compiled from: MarketplacePostPublished */
            public class Serializer extends JsonSerializer<ListItemsModel> {
                public final void m14091a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    ListItemsModel listItemsModel = (ListItemsModel) obj;
                    if (listItemsModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(listItemsModel.m14092a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        listItemsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    ListItemsParser.m14183b(listItemsModel.w_(), listItemsModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(ListItemsModel.class, new Serializer());
                }
            }

            public ListItemsModel() {
                super(2);
            }

            @Nullable
            public final GraphQLProfileFieldTextListItemHeadingType m14093a() {
                this.f13218d = (GraphQLProfileFieldTextListItemHeadingType) super.b(this.f13218d, 0, GraphQLProfileFieldTextListItemHeadingType.class, GraphQLProfileFieldTextListItemHeadingType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
                return this.f13218d;
            }

            @Nullable
            public final TextWithEntitiesInfoModel m14095j() {
                this.f13219e = (TextWithEntitiesInfoModel) super.a(this.f13219e, 1, TextWithEntitiesInfoModel.class);
                return this.f13219e;
            }

            public final int jK_() {
                return 1004985519;
            }

            public final GraphQLVisitableModel m14094a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m14095j() != null) {
                    TextWithEntitiesInfoModel textWithEntitiesInfoModel = (TextWithEntitiesInfoModel) graphQLModelMutatingVisitor.b(m14095j());
                    if (m14095j() != textWithEntitiesInfoModel) {
                        graphQLVisitableModel = (ListItemsModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f13219e = textWithEntitiesInfoModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m14092a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = flatBufferBuilder.a(m14093a());
                int a2 = ModelHelper.a(flatBufferBuilder, m14095j());
                flatBufferBuilder.c(2);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.b(1, a2);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: MarketplacePostPublished */
        public class Serializer extends JsonSerializer<ProfileFieldTextListItemGroupInfoModel> {
            public final void m14096a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                ProfileFieldTextListItemGroupInfoModel profileFieldTextListItemGroupInfoModel = (ProfileFieldTextListItemGroupInfoModel) obj;
                if (profileFieldTextListItemGroupInfoModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(profileFieldTextListItemGroupInfoModel.m14097a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    profileFieldTextListItemGroupInfoModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                ProfileFieldTextListItemGroupInfoParser.m14186b(profileFieldTextListItemGroupInfoModel.w_(), profileFieldTextListItemGroupInfoModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(ProfileFieldTextListItemGroupInfoModel.class, new Serializer());
            }
        }

        public ProfileFieldTextListItemGroupInfoModel() {
            super(1);
        }

        @Nonnull
        public final ImmutableList<ListItemsModel> m14099a() {
            this.f13220d = super.a(this.f13220d, 0, ListItemsModel.class);
            return (ImmutableList) this.f13220d;
        }

        public final int jK_() {
            return -591347952;
        }

        public final GraphQLVisitableModel m14098a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m14099a() != null) {
                Builder a = ModelHelper.a(m14099a(), graphQLModelMutatingVisitor);
                if (a != null) {
                    graphQLVisitableModel = (ProfileFieldTextListItemGroupInfoModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f13220d = a.b();
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m14097a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m14099a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 18379723)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: MarketplacePostPublished */
    public final class ProfileInfoSectionsModel extends BaseModel implements GraphQLVisitableConsistentModel {
        @Nullable
        private ProfileFieldSectionsModel f13225d;

        /* compiled from: MarketplacePostPublished */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(ProfileInfoSectionsModel.class, new Deserializer());
            }

            public Object m14100a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = ProfileInfoSectionsParser.m14191a(jsonParser);
                Object profileInfoSectionsModel = new ProfileInfoSectionsModel();
                ((BaseModel) profileInfoSectionsModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (profileInfoSectionsModel instanceof Postprocessable) {
                    return ((Postprocessable) profileInfoSectionsModel).a();
                }
                return profileInfoSectionsModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1801445538)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: MarketplacePostPublished */
        public final class ProfileFieldSectionsModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private List<ProfileFieldSectionInfoModel> f13223d;
            @Nullable
            private PageInfoModel f13224e;

            /* compiled from: MarketplacePostPublished */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(ProfileFieldSectionsModel.class, new Deserializer());
                }

                public Object m14101a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(ProfileFieldSectionsParser.m14189a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object profileFieldSectionsModel = new ProfileFieldSectionsModel();
                    ((BaseModel) profileFieldSectionsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (profileFieldSectionsModel instanceof Postprocessable) {
                        return ((Postprocessable) profileFieldSectionsModel).a();
                    }
                    return profileFieldSectionsModel;
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = -2005169142)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: MarketplacePostPublished */
            public final class PageInfoModel extends BaseModel implements GraphQLVisitableModel {
                @Nullable
                private String f13221d;
                private boolean f13222e;

                /* compiled from: MarketplacePostPublished */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(PageInfoModel.class, new Deserializer());
                    }

                    public Object m14102a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(PageInfoParser.m14187a(jsonParser, flatBufferBuilder));
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

                /* compiled from: MarketplacePostPublished */
                public class Serializer extends JsonSerializer<PageInfoModel> {
                    public final void m14103a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        PageInfoModel pageInfoModel = (PageInfoModel) obj;
                        if (pageInfoModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(pageInfoModel.m14105a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            pageInfoModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        PageInfoParser.m14188a(pageInfoModel.w_(), pageInfoModel.u_(), jsonGenerator);
                    }

                    static {
                        FbSerializerProvider.a(PageInfoModel.class, new Serializer());
                    }
                }

                public PageInfoModel() {
                    super(2);
                }

                @Nullable
                private String m14104a() {
                    this.f13221d = super.a(this.f13221d, 0);
                    return this.f13221d;
                }

                public final int jK_() {
                    return 923779069;
                }

                public final GraphQLVisitableModel m14106a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    h();
                    i();
                    return this;
                }

                public final int m14105a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int b = flatBufferBuilder.b(m14104a());
                    flatBufferBuilder.c(2);
                    flatBufferBuilder.b(0, b);
                    flatBufferBuilder.a(1, this.f13222e);
                    i();
                    return flatBufferBuilder.d();
                }

                public final void m14107a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                    super.a(mutableFlatBuffer, i, obj);
                    this.f13222e = mutableFlatBuffer.a(i, 1);
                }
            }

            /* compiled from: MarketplacePostPublished */
            public class Serializer extends JsonSerializer<ProfileFieldSectionsModel> {
                public final void m14108a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    ProfileFieldSectionsModel profileFieldSectionsModel = (ProfileFieldSectionsModel) obj;
                    if (profileFieldSectionsModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(profileFieldSectionsModel.m14110a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        profileFieldSectionsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    ProfileFieldSectionsParser.m14190a(profileFieldSectionsModel.w_(), profileFieldSectionsModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(ProfileFieldSectionsModel.class, new Serializer());
                }
            }

            public ProfileFieldSectionsModel() {
                super(2);
            }

            @Nonnull
            public final ImmutableList<ProfileFieldSectionInfoModel> m14112a() {
                this.f13223d = super.a(this.f13223d, 0, ProfileFieldSectionInfoModel.class);
                return (ImmutableList) this.f13223d;
            }

            @Nullable
            private PageInfoModel m14109j() {
                this.f13224e = (PageInfoModel) super.a(this.f13224e, 1, PageInfoModel.class);
                return this.f13224e;
            }

            public final int jK_() {
                return 1455765117;
            }

            public final GraphQLVisitableModel m14111a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel;
                PageInfoModel pageInfoModel;
                h();
                if (m14112a() != null) {
                    Builder a = ModelHelper.a(m14112a(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        ProfileFieldSectionsModel profileFieldSectionsModel = (ProfileFieldSectionsModel) ModelHelper.a(null, this);
                        profileFieldSectionsModel.f13223d = a.b();
                        graphQLVisitableModel = profileFieldSectionsModel;
                        if (m14109j() != null) {
                            pageInfoModel = (PageInfoModel) graphQLModelMutatingVisitor.b(m14109j());
                            if (m14109j() != pageInfoModel) {
                                graphQLVisitableModel = (ProfileFieldSectionsModel) ModelHelper.a(graphQLVisitableModel, this);
                                graphQLVisitableModel.f13224e = pageInfoModel;
                            }
                        }
                        i();
                        return graphQLVisitableModel != null ? this : graphQLVisitableModel;
                    }
                }
                graphQLVisitableModel = null;
                if (m14109j() != null) {
                    pageInfoModel = (PageInfoModel) graphQLModelMutatingVisitor.b(m14109j());
                    if (m14109j() != pageInfoModel) {
                        graphQLVisitableModel = (ProfileFieldSectionsModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f13224e = pageInfoModel;
                    }
                }
                i();
                if (graphQLVisitableModel != null) {
                }
            }

            public final int m14110a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m14112a());
                int a2 = ModelHelper.a(flatBufferBuilder, m14109j());
                flatBufferBuilder.c(2);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.b(1, a2);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: MarketplacePostPublished */
        public class Serializer extends JsonSerializer<ProfileInfoSectionsModel> {
            public final void m14113a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                ProfileInfoSectionsModel profileInfoSectionsModel = (ProfileInfoSectionsModel) obj;
                if (profileInfoSectionsModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(profileInfoSectionsModel.m14115a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    profileInfoSectionsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = profileInfoSectionsModel.w_();
                int u_ = profileInfoSectionsModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("profile_field_sections");
                    ProfileFieldSectionsParser.m14190a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(ProfileInfoSectionsModel.class, new Serializer());
            }
        }

        public ProfileInfoSectionsModel() {
            super(1);
        }

        public final void m14117a(String str, ConsistencyTuple consistencyTuple) {
            consistencyTuple.a();
        }

        public final void m14118a(String str, Object obj, boolean z) {
        }

        @Nullable
        private ProfileFieldSectionsModel m14114a() {
            this.f13225d = (ProfileFieldSectionsModel) super.a(this.f13225d, 0, ProfileFieldSectionsModel.class);
            return this.f13225d;
        }

        public final int jK_() {
            return 2645995;
        }

        public final GraphQLVisitableModel m14116a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m14114a() != null) {
                ProfileFieldSectionsModel profileFieldSectionsModel = (ProfileFieldSectionsModel) graphQLModelMutatingVisitor.b(m14114a());
                if (m14114a() != profileFieldSectionsModel) {
                    graphQLVisitableModel = (ProfileInfoSectionsModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f13225d = profileFieldSectionsModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m14115a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m14114a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -1808296171)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: MarketplacePostPublished */
    public final class TextWithEntitiesInfoModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private List<RangesModel> f13233d;
        @Nullable
        private String f13234e;

        /* compiled from: MarketplacePostPublished */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(TextWithEntitiesInfoModel.class, new Deserializer());
            }

            public Object m14119a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(TextWithEntitiesInfoParser.m14196a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object textWithEntitiesInfoModel = new TextWithEntitiesInfoModel();
                ((BaseModel) textWithEntitiesInfoModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (textWithEntitiesInfoModel instanceof Postprocessable) {
                    return ((Postprocessable) textWithEntitiesInfoModel).a();
                }
                return textWithEntitiesInfoModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 1557292924)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: MarketplacePostPublished */
        public final class RangesModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private EntityModel f13230d;
            private int f13231e;
            private int f13232f;

            /* compiled from: MarketplacePostPublished */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(RangesModel.class, new Deserializer());
                }

                public Object m14120a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(RangesParser.m14194b(jsonParser, flatBufferBuilder));
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
            /* compiled from: MarketplacePostPublished */
            public final class EntityModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel {
                @Nullable
                private GraphQLObjectType f13226d;
                @Nullable
                private String f13227e;
                @Nullable
                private String f13228f;
                @Nullable
                private String f13229g;

                /* compiled from: MarketplacePostPublished */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(EntityModel.class, new Deserializer());
                    }

                    public Object m14121a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(EntityParser.m14192a(jsonParser, flatBufferBuilder));
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

                /* compiled from: MarketplacePostPublished */
                public class Serializer extends JsonSerializer<EntityModel> {
                    public final void m14122a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        EntityModel entityModel = (EntityModel) obj;
                        if (entityModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(entityModel.m14124a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            entityModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        EntityParser.m14193a(entityModel.w_(), entityModel.u_(), jsonGenerator);
                    }

                    static {
                        FbSerializerProvider.a(EntityModel.class, new Serializer());
                    }
                }

                public EntityModel() {
                    super(4);
                }

                @Nullable
                public final GraphQLObjectType m14127j() {
                    if (this.b != null && this.f13226d == null) {
                        this.f13226d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
                    }
                    return this.f13226d;
                }

                @Nullable
                public final String m14128k() {
                    this.f13227e = super.a(this.f13227e, 1);
                    return this.f13227e;
                }

                @Nullable
                private String m14123m() {
                    this.f13228f = super.a(this.f13228f, 2);
                    return this.f13228f;
                }

                @Nullable
                public final String m14129l() {
                    this.f13229g = super.a(this.f13229g, 3);
                    return this.f13229g;
                }

                @Nullable
                public final String m14126a() {
                    return m14128k();
                }

                public final int jK_() {
                    return 2080559107;
                }

                public final GraphQLVisitableModel m14125a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    h();
                    i();
                    return this;
                }

                public final int m14124a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int a = ModelHelper.a(flatBufferBuilder, m14127j());
                    int b = flatBufferBuilder.b(m14128k());
                    int b2 = flatBufferBuilder.b(m14123m());
                    int b3 = flatBufferBuilder.b(m14129l());
                    flatBufferBuilder.c(4);
                    flatBufferBuilder.b(0, a);
                    flatBufferBuilder.b(1, b);
                    flatBufferBuilder.b(2, b2);
                    flatBufferBuilder.b(3, b3);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            /* compiled from: MarketplacePostPublished */
            public class Serializer extends JsonSerializer<RangesModel> {
                public final void m14130a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    RangesModel rangesModel = (RangesModel) obj;
                    if (rangesModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(rangesModel.m14131a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        rangesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    RangesParser.m14195b(rangesModel.w_(), rangesModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(RangesModel.class, new Serializer());
                }
            }

            public RangesModel() {
                super(3);
            }

            @Nullable
            public final EntityModel m14133a() {
                this.f13230d = (EntityModel) super.a(this.f13230d, 0, EntityModel.class);
                return this.f13230d;
            }

            public final int m14135j() {
                a(0, 1);
                return this.f13231e;
            }

            public final int m14136k() {
                a(0, 2);
                return this.f13232f;
            }

            public final int jK_() {
                return -1024511161;
            }

            public final GraphQLVisitableModel m14132a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m14133a() != null) {
                    EntityModel entityModel = (EntityModel) graphQLModelMutatingVisitor.b(m14133a());
                    if (m14133a() != entityModel) {
                        graphQLVisitableModel = (RangesModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f13230d = entityModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m14131a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m14133a());
                flatBufferBuilder.c(3);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.a(1, this.f13231e, 0);
                flatBufferBuilder.a(2, this.f13232f, 0);
                i();
                return flatBufferBuilder.d();
            }

            public final void m14134a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                super.a(mutableFlatBuffer, i, obj);
                this.f13231e = mutableFlatBuffer.a(i, 1, 0);
                this.f13232f = mutableFlatBuffer.a(i, 2, 0);
            }
        }

        /* compiled from: MarketplacePostPublished */
        public class Serializer extends JsonSerializer<TextWithEntitiesInfoModel> {
            public final void m14137a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                TextWithEntitiesInfoModel textWithEntitiesInfoModel = (TextWithEntitiesInfoModel) obj;
                if (textWithEntitiesInfoModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(textWithEntitiesInfoModel.m14138a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    textWithEntitiesInfoModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                TextWithEntitiesInfoParser.m14197a(textWithEntitiesInfoModel.w_(), textWithEntitiesInfoModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(TextWithEntitiesInfoModel.class, new Serializer());
            }
        }

        public TextWithEntitiesInfoModel() {
            super(2);
        }

        @Nonnull
        public final ImmutableList<RangesModel> m14140a() {
            this.f13233d = super.a(this.f13233d, 0, RangesModel.class);
            return (ImmutableList) this.f13233d;
        }

        @Nullable
        public final String m14141j() {
            this.f13234e = super.a(this.f13234e, 1);
            return this.f13234e;
        }

        public final int jK_() {
            return -1919764332;
        }

        public final GraphQLVisitableModel m14139a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m14140a() != null) {
                Builder a = ModelHelper.a(m14140a(), graphQLModelMutatingVisitor);
                if (a != null) {
                    graphQLVisitableModel = (TextWithEntitiesInfoModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f13233d = a.b();
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m14138a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m14140a());
            int b = flatBufferBuilder.b(m14141j());
            flatBufferBuilder.c(2);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, b);
            i();
            return flatBufferBuilder.d();
        }
    }
}
