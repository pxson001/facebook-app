package com.facebook.reaction.protocol.components;

import com.facebook.api.graphql.feedback.FeedbackDefaultsGraphQLInterfaces.BaseFeedbackFields;
import com.facebook.api.graphql.feedback.FeedbackDefaultsGraphQLInterfaces.BaseFeedbackFields.ViewerActsAsPage;
import com.facebook.api.graphql.feedback.FeedbackDefaultsGraphQLModels.BaseFeedbackFieldsModel.ViewerActsAsPageModel;
import com.facebook.api.graphql.reactions.ReactionsGraphQLInterfaces.SimpleReactionsFeedbackFields;
import com.facebook.api.graphql.reactions.ReactionsGraphQLModels.ReactionsCountFieldsModel.TopReactionsModel;
import com.facebook.api.graphql.reactions.ReactionsGraphQLModels.SimpleReactionsFeedbackFieldsModel.ReactorsModel;
import com.facebook.api.graphql.reactions.ReactionsGraphQLModels.ViewerReactionsFeedbackFieldsModel.SupportedReactionsModel;
import com.facebook.api.graphql.reactions.ReactionsGraphQLModels.ViewerReactionsSocialFeedbackFieldsModel.ImportantReactorsModel;
import com.facebook.api.graphql.reactions.ReactionsGraphQLModels.ViewerReactionsSocialFeedbackFieldsModel.ViewerActsAsPersonModel;
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
import com.facebook.graphql.enums.GraphQLFriendshipStatus;
import com.facebook.graphql.enums.GraphQLObjectType;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.modelutil.SerializerHelpers;
import com.facebook.graphql.querybuilder.common.CommonGraphQL2Interfaces.DefaultVect2Fields;
import com.facebook.graphql.querybuilder.common.CommonGraphQL2Models.DefaultVect2FieldsModel;
import com.facebook.graphql.querybuilder.common.CommonGraphQLInterfaces.DefaultImageFields;
import com.facebook.graphql.querybuilder.common.CommonGraphQLModels.DefaultImageFieldsModel;
import com.facebook.graphql.querybuilder.common.CommonGraphQLModels.DefaultLocationFieldsModel;
import com.facebook.graphql.querybuilder.common.TextWithEntitiesGraphQLInterfaces.DefaultTextWithEntitiesFields;
import com.facebook.graphql.querybuilder.common.TextWithEntitiesGraphQLModels.DefaultTextWithEntitiesFieldsModel;
import com.facebook.graphql.querybuilder.common.TextWithEntitiesGraphQLParsers.DefaultTextWithEntitiesFieldsParser;
import com.facebook.graphql.visitor.ConsistencyTuple;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLPersistableNode;
import com.facebook.graphql.visitor.GraphQLVisitableConsistentModel;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.facebook.photos.data.protocol.PhotosDefaultsGraphQLInterfaces.SizeAwareMedia;
import com.facebook.reaction.protocol.common.ReactionCommonGraphQLModels.ReactionStoryAttachmentStoryFragmentModel;
import com.facebook.reaction.protocol.components.ReactionComponentsGraphQLInterfaces.GametimeDataFactFragment;
import com.facebook.reaction.protocol.components.ReactionComponentsGraphQLInterfaces.GametimeFanFavoriteMatchFragment;
import com.facebook.reaction.protocol.components.ReactionComponentsGraphQLInterfaces.GametimeFanFavoriteMatchFragment.AwayTeamObject;
import com.facebook.reaction.protocol.components.ReactionComponentsGraphQLInterfaces.GametimeFanFavoriteMatchFragment.AwayTeamObject.OfficialPage;
import com.facebook.reaction.protocol.components.ReactionComponentsGraphQLInterfaces.GametimeFanFavoriteMatchFragment.AwayTeamObject.OfficialPage.PageLogo;
import com.facebook.reaction.protocol.components.ReactionComponentsGraphQLInterfaces.GametimeFanFavoriteMatchFragment.HomeTeamObject;
import com.facebook.reaction.protocol.components.ReactionComponentsGraphQLInterfaces.GametimeFanFavoriteMatchFragment.MatchPage;
import com.facebook.reaction.protocol.components.ReactionComponentsGraphQLInterfaces.ReactionPageContextRowsPlaceholderComponentFragment;
import com.facebook.reaction.protocol.components.ReactionComponentsGraphQLInterfaces.ReactionPageContextRowsPlaceholderComponentFragment.Page;
import com.facebook.reaction.protocol.components.ReactionComponentsGraphQLInterfaces.ReactionReviewUnitComponentFragment;
import com.facebook.reaction.protocol.components.ReactionComponentsGraphQLInterfaces.ReactionUnitFriendRequestListComponentFragment;
import com.facebook.reaction.protocol.components.ReactionComponentsGraphQLInterfaces.ReactionUnitGametimeFanFavoriteComponentFragment;
import com.facebook.reaction.protocol.components.ReactionComponentsGraphQLInterfaces.ReactionUnitGametimeTableComponentFragment;
import com.facebook.reaction.protocol.components.ReactionComponentsGraphQLInterfaces.ReactionUnitPhotoComponentFragment;
import com.facebook.reaction.protocol.components.ReactionComponentsGraphQLParsers.GametimeDataFactFeedbackFieldsParser;
import com.facebook.reaction.protocol.components.ReactionComponentsGraphQLParsers.GametimeDataFactFeedbackFieldsParser.LikersParser;
import com.facebook.reaction.protocol.components.ReactionComponentsGraphQLParsers.GametimeDataFactFeedbackFieldsParser.ResharesParser;
import com.facebook.reaction.protocol.components.ReactionComponentsGraphQLParsers.GametimeDataFactFeedbackFieldsParser.TopLevelCommentsParser;
import com.facebook.reaction.protocol.components.ReactionComponentsGraphQLParsers.GametimeDataFactFragmentParser;
import com.facebook.reaction.protocol.components.ReactionComponentsGraphQLParsers.GametimeDataFactFragmentParser.ActingTeamParser;
import com.facebook.reaction.protocol.components.ReactionComponentsGraphQLParsers.GametimeDataFactFragmentParser.ActingTeamParser.PageLogoParser;
import com.facebook.reaction.protocol.components.ReactionComponentsGraphQLParsers.GametimeDataFactFragmentParser.PreviewCommentParser;
import com.facebook.reaction.protocol.components.ReactionComponentsGraphQLParsers.GametimeDataFactFragmentParser.PreviewCommentParser.AuthorParser;
import com.facebook.reaction.protocol.components.ReactionComponentsGraphQLParsers.GametimeDataFactFragmentParser.PreviewCommentParser.AuthorParser.ProfilePictureParser;
import com.facebook.reaction.protocol.components.ReactionComponentsGraphQLParsers.GametimeDataFactFragmentParser.StoryParser;
import com.facebook.reaction.protocol.components.ReactionComponentsGraphQLParsers.GametimeDataFactFragmentParser.StoryParser.ShareableParser;
import com.facebook.reaction.protocol.components.ReactionComponentsGraphQLParsers.GametimeFanFavoriteMatchFragmentParser;
import com.facebook.reaction.protocol.components.ReactionComponentsGraphQLParsers.GametimeFanFavoriteMatchFragmentParser.AwayTeamObjectParser;
import com.facebook.reaction.protocol.components.ReactionComponentsGraphQLParsers.GametimeFanFavoriteMatchFragmentParser.AwayTeamObjectParser.OfficialPageParser;
import com.facebook.reaction.protocol.components.ReactionComponentsGraphQLParsers.GametimeFanFavoriteMatchFragmentParser.HomeTeamObjectParser;
import com.facebook.reaction.protocol.components.ReactionComponentsGraphQLParsers.GametimeFanFavoriteMatchFragmentParser.MatchPageParser;
import com.facebook.reaction.protocol.components.ReactionComponentsGraphQLParsers.ReactionPageContextRowsPlaceholderComponentFragmentParser;
import com.facebook.reaction.protocol.components.ReactionComponentsGraphQLParsers.ReactionPageContextRowsPlaceholderComponentFragmentParser.PageParser;
import com.facebook.reaction.protocol.components.ReactionComponentsGraphQLParsers.ReactionPageContextRowsPlaceholderComponentFragmentParser.PageParser.OverallStarRatingParser;
import com.facebook.reaction.protocol.components.ReactionComponentsGraphQLParsers.ReactionReviewUnitComponentFragmentParser;
import com.facebook.reaction.protocol.components.ReactionComponentsGraphQLParsers.ReactionReviewUnitComponentFragmentParser.SpotlightStoryPreviewParser;
import com.facebook.reaction.protocol.components.ReactionComponentsGraphQLParsers.ReactionReviewUnitComponentFragmentParser.SpotlightStoryPreviewParser.FormattedPreviewParser;
import com.facebook.reaction.protocol.components.ReactionComponentsGraphQLParsers.ReactionUnitFriendRequestListComponentFragmentParser;
import com.facebook.reaction.protocol.components.ReactionComponentsGraphQLParsers.ReactionUnitFriendRequestListComponentFragmentParser.FriendingPossibilitiesParser;
import com.facebook.reaction.protocol.components.ReactionComponentsGraphQLParsers.ReactionUnitFriendRequestListComponentFragmentParser.FriendingPossibilitiesParser.RequesterParser;
import com.facebook.reaction.protocol.components.ReactionComponentsGraphQLParsers.ReactionUnitFriendRequestListComponentFragmentParser.FriendingPossibilitiesParser.RequesterParser.SocialContextParser;
import com.facebook.reaction.protocol.components.ReactionComponentsGraphQLParsers.ReactionUnitFriendRequestListComponentFragmentParser.FriendingPossibilitiesParser.SuggestersParser;
import com.facebook.reaction.protocol.components.ReactionComponentsGraphQLParsers.ReactionUnitGametimeFanFavoriteComponentFragmentParser;
import com.facebook.reaction.protocol.components.ReactionComponentsGraphQLParsers.ReactionUnitGametimeFanFavoriteComponentFragmentParser.AwayVotingPageParser;
import com.facebook.reaction.protocol.components.ReactionComponentsGraphQLParsers.ReactionUnitGametimeFanFavoriteComponentFragmentParser.HomeVotingPageParser;
import com.facebook.reaction.protocol.components.ReactionComponentsGraphQLParsers.ReactionUnitGametimeTableComponentFragmentParser;
import com.facebook.reaction.protocol.components.ReactionComponentsGraphQLParsers.ReactionUnitGametimeTableComponentFragmentParser.TypedDataParser;
import com.facebook.reaction.protocol.components.ReactionComponentsGraphQLParsers.ReactionUnitPhotoComponentFragmentParser;
import com.facebook.reaction.protocol.components.ReactionComponentsGraphQLParsers.ReactionUnitPhotoComponentFragmentParser.PhotoParser;
import com.facebook.reaction.protocol.components.ReactionComponentsGraphQLParsers.ReactionUnitPhotoComponentFragmentParser.PhotoParser.CreationStoryParser;
import com.facebook.reaction.protocol.components.ReactionComponentsGraphQLParsers.ReactionUnitPhotoComponentFragmentParser.PhotoParser.CreationStoryParser.FeedbackParser;
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

/* compiled from: final_slider_value */
public class ReactionComponentsGraphQLModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 514655678)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: final_slider_value */
    public final class GametimeDataFactFeedbackFieldsModel extends BaseModel implements BaseFeedbackFields, SimpleReactionsFeedbackFields, GraphQLPersistableNode, GraphQLVisitableConsistentModel {
        @Nullable
        private ViewerActsAsPersonModel f12214A;
        private int f12215B;
        private boolean f12216d;
        private boolean f12217e;
        private boolean f12218f;
        private boolean f12219g;
        private boolean f12220h;
        private boolean f12221i;
        private boolean f12222j;
        private boolean f12223k;
        @Nullable
        private String f12224l;
        private boolean f12225m;
        private boolean f12226n;
        @Nullable
        private String f12227o;
        @Nullable
        private ImportantReactorsModel f12228p;
        private boolean f12229q;
        @Nullable
        private String f12230r;
        @Nullable
        private LikersModel f12231s;
        @Nullable
        private ReactorsModel f12232t;
        @Nullable
        private String f12233u;
        @Nullable
        private ResharesModel f12234v;
        @Nullable
        private List<SupportedReactionsModel> f12235w;
        @Nullable
        private TopLevelCommentsModel f12236x;
        @Nullable
        private TopReactionsModel f12237y;
        @Nullable
        private ViewerActsAsPageModel f12238z;

        /* compiled from: final_slider_value */
        public final class Builder {
            public boolean f12183a;
            public boolean f12184b;
            public boolean f12185c;
            public boolean f12186d;
            public boolean f12187e;
            public boolean f12188f;
            public boolean f12189g;
            public boolean f12190h;
            @Nullable
            public String f12191i;
            public boolean f12192j;
            public boolean f12193k;
            @Nullable
            public String f12194l;
            @Nullable
            public ImportantReactorsModel f12195m;
            public boolean f12196n;
            @Nullable
            public String f12197o;
            @Nullable
            public LikersModel f12198p;
            @Nullable
            public ReactorsModel f12199q;
            @Nullable
            public String f12200r;
            @Nullable
            public ResharesModel f12201s;
            @Nullable
            public ImmutableList<SupportedReactionsModel> f12202t;
            @Nullable
            public TopLevelCommentsModel f12203u;
            @Nullable
            public TopReactionsModel f12204v;
            @Nullable
            public ViewerActsAsPageModel f12205w;
            @Nullable
            public ViewerActsAsPersonModel f12206x;
            public int f12207y;

            public final GametimeDataFactFeedbackFieldsModel m14749a() {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                int b = flatBufferBuilder.b(this.f12191i);
                int b2 = flatBufferBuilder.b(this.f12194l);
                int a = ModelHelper.a(flatBufferBuilder, this.f12195m);
                int b3 = flatBufferBuilder.b(this.f12197o);
                int a2 = ModelHelper.a(flatBufferBuilder, this.f12198p);
                int a3 = ModelHelper.a(flatBufferBuilder, this.f12199q);
                int b4 = flatBufferBuilder.b(this.f12200r);
                int a4 = ModelHelper.a(flatBufferBuilder, this.f12201s);
                int a5 = ModelHelper.a(flatBufferBuilder, this.f12202t);
                int a6 = ModelHelper.a(flatBufferBuilder, this.f12203u);
                int a7 = ModelHelper.a(flatBufferBuilder, this.f12204v);
                int a8 = ModelHelper.a(flatBufferBuilder, this.f12205w);
                int a9 = ModelHelper.a(flatBufferBuilder, this.f12206x);
                flatBufferBuilder.c(25);
                flatBufferBuilder.a(0, this.f12183a);
                flatBufferBuilder.a(1, this.f12184b);
                flatBufferBuilder.a(2, this.f12185c);
                flatBufferBuilder.a(3, this.f12186d);
                flatBufferBuilder.a(4, this.f12187e);
                flatBufferBuilder.a(5, this.f12188f);
                flatBufferBuilder.a(6, this.f12189g);
                flatBufferBuilder.a(7, this.f12190h);
                flatBufferBuilder.b(8, b);
                flatBufferBuilder.a(9, this.f12192j);
                flatBufferBuilder.a(10, this.f12193k);
                flatBufferBuilder.b(11, b2);
                flatBufferBuilder.b(12, a);
                flatBufferBuilder.a(13, this.f12196n);
                flatBufferBuilder.b(14, b3);
                flatBufferBuilder.b(15, a2);
                flatBufferBuilder.b(16, a3);
                flatBufferBuilder.b(17, b4);
                flatBufferBuilder.b(18, a4);
                flatBufferBuilder.b(19, a5);
                flatBufferBuilder.b(20, a6);
                flatBufferBuilder.b(21, a7);
                flatBufferBuilder.b(22, a8);
                flatBufferBuilder.b(23, a9);
                flatBufferBuilder.a(24, this.f12207y, 0);
                flatBufferBuilder.d(flatBufferBuilder.d());
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                return new GametimeDataFactFeedbackFieldsModel(new MutableFlatBuffer(wrap, null, null, true, null));
            }
        }

        /* compiled from: final_slider_value */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(GametimeDataFactFeedbackFieldsModel.class, new Deserializer());
            }

            public Object m14750a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(GametimeDataFactFeedbackFieldsParser.m15166a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object gametimeDataFactFeedbackFieldsModel = new GametimeDataFactFeedbackFieldsModel();
                ((BaseModel) gametimeDataFactFeedbackFieldsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (gametimeDataFactFeedbackFieldsModel instanceof Postprocessable) {
                    return ((Postprocessable) gametimeDataFactFeedbackFieldsModel).a();
                }
                return gametimeDataFactFeedbackFieldsModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1723990064)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: final_slider_value */
        public final class LikersModel extends BaseModel implements GraphQLVisitableModel {
            private int f12209d;

            /* compiled from: final_slider_value */
            public final class Builder {
                public int f12208a;
            }

            /* compiled from: final_slider_value */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(LikersModel.class, new Deserializer());
                }

                public Object m14751a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(LikersParser.m15160a(jsonParser, flatBufferBuilder));
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

            /* compiled from: final_slider_value */
            public class Serializer extends JsonSerializer<LikersModel> {
                public final void m14752a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    LikersModel likersModel = (LikersModel) obj;
                    if (likersModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(likersModel.m14755a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        likersModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    LikersParser.m15161a(likersModel.w_(), likersModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(LikersModel.class, new Serializer());
                }
            }

            public LikersModel() {
                super(1);
            }

            public LikersModel(MutableFlatBuffer mutableFlatBuffer) {
                super(1);
                a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
            }

            public final int m14754a() {
                a(0, 0);
                return this.f12209d;
            }

            public final void m14757a(int i) {
                this.f12209d = i;
                if (this.b != null && this.b.d) {
                    this.b.b(this.c, 0, i);
                }
            }

            public static LikersModel m14753a(LikersModel likersModel) {
                if (likersModel == null) {
                    return null;
                }
                if (likersModel instanceof LikersModel) {
                    return likersModel;
                }
                Builder builder = new Builder();
                builder.f12208a = likersModel.m14754a();
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.c(1);
                flatBufferBuilder.a(0, builder.f12208a, 0);
                flatBufferBuilder.d(flatBufferBuilder.d());
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                return new LikersModel(new MutableFlatBuffer(wrap, null, null, true, null));
            }

            public final int jK_() {
                return 733369288;
            }

            public final GraphQLVisitableModel m14756a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m14755a(FlatBufferBuilder flatBufferBuilder) {
                h();
                flatBufferBuilder.c(1);
                flatBufferBuilder.a(0, this.f12209d, 0);
                i();
                return flatBufferBuilder.d();
            }

            public final void m14758a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                super.a(mutableFlatBuffer, i, obj);
                this.f12209d = mutableFlatBuffer.a(i, 0, 0);
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1723990064)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: final_slider_value */
        public final class ResharesModel extends BaseModel implements GraphQLVisitableModel {
            private int f12211d;

            /* compiled from: final_slider_value */
            public final class Builder {
                public int f12210a;
            }

            /* compiled from: final_slider_value */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(ResharesModel.class, new Deserializer());
                }

                public Object m14759a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(ResharesParser.m15162a(jsonParser, flatBufferBuilder));
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

            /* compiled from: final_slider_value */
            public class Serializer extends JsonSerializer<ResharesModel> {
                public final void m14760a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    ResharesModel resharesModel = (ResharesModel) obj;
                    if (resharesModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(resharesModel.m14763a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        resharesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    ResharesParser.m15163a(resharesModel.w_(), resharesModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(ResharesModel.class, new Serializer());
                }
            }

            public ResharesModel() {
                super(1);
            }

            public ResharesModel(MutableFlatBuffer mutableFlatBuffer) {
                super(1);
                a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
            }

            public final int m14762a() {
                a(0, 0);
                return this.f12211d;
            }

            public final void m14765a(int i) {
                this.f12211d = i;
                if (this.b != null && this.b.d) {
                    this.b.b(this.c, 0, i);
                }
            }

            public static ResharesModel m14761a(ResharesModel resharesModel) {
                if (resharesModel == null) {
                    return null;
                }
                if (resharesModel instanceof ResharesModel) {
                    return resharesModel;
                }
                Builder builder = new Builder();
                builder.f12210a = resharesModel.m14762a();
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.c(1);
                flatBufferBuilder.a(0, builder.f12210a, 0);
                flatBufferBuilder.d(flatBufferBuilder.d());
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                return new ResharesModel(new MutableFlatBuffer(wrap, null, null, true, null));
            }

            public final int jK_() {
                return -1260671207;
            }

            public final GraphQLVisitableModel m14764a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m14763a(FlatBufferBuilder flatBufferBuilder) {
                h();
                flatBufferBuilder.c(1);
                flatBufferBuilder.a(0, this.f12211d, 0);
                i();
                return flatBufferBuilder.d();
            }

            public final void m14766a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                super.a(mutableFlatBuffer, i, obj);
                this.f12211d = mutableFlatBuffer.a(i, 0, 0);
            }
        }

        /* compiled from: final_slider_value */
        public class Serializer extends JsonSerializer<GametimeDataFactFeedbackFieldsModel> {
            public final void m14767a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                GametimeDataFactFeedbackFieldsModel gametimeDataFactFeedbackFieldsModel = (GametimeDataFactFeedbackFieldsModel) obj;
                if (gametimeDataFactFeedbackFieldsModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(gametimeDataFactFeedbackFieldsModel.m14791a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    gametimeDataFactFeedbackFieldsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                GametimeDataFactFeedbackFieldsParser.m15167a(gametimeDataFactFeedbackFieldsModel.w_(), gametimeDataFactFeedbackFieldsModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(GametimeDataFactFeedbackFieldsModel.class, new Serializer());
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1723990064)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: final_slider_value */
        public final class TopLevelCommentsModel extends BaseModel implements GraphQLVisitableModel {
            private int f12213d;

            /* compiled from: final_slider_value */
            public final class Builder {
                public int f12212a;
            }

            /* compiled from: final_slider_value */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(TopLevelCommentsModel.class, new Deserializer());
                }

                public Object m14768a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(TopLevelCommentsParser.m15164a(jsonParser, flatBufferBuilder));
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

            /* compiled from: final_slider_value */
            public class Serializer extends JsonSerializer<TopLevelCommentsModel> {
                public final void m14769a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    TopLevelCommentsModel topLevelCommentsModel = (TopLevelCommentsModel) obj;
                    if (topLevelCommentsModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(topLevelCommentsModel.m14772a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        topLevelCommentsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    TopLevelCommentsParser.m15165a(topLevelCommentsModel.w_(), topLevelCommentsModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(TopLevelCommentsModel.class, new Serializer());
                }
            }

            public TopLevelCommentsModel() {
                super(1);
            }

            public TopLevelCommentsModel(MutableFlatBuffer mutableFlatBuffer) {
                super(1);
                a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
            }

            public final int m14771a() {
                a(0, 0);
                return this.f12213d;
            }

            public final void m14774a(int i) {
                this.f12213d = i;
                if (this.b != null && this.b.d) {
                    this.b.b(this.c, 0, i);
                }
            }

            public static TopLevelCommentsModel m14770a(TopLevelCommentsModel topLevelCommentsModel) {
                if (topLevelCommentsModel == null) {
                    return null;
                }
                if (topLevelCommentsModel instanceof TopLevelCommentsModel) {
                    return topLevelCommentsModel;
                }
                Builder builder = new Builder();
                builder.f12212a = topLevelCommentsModel.m14771a();
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.c(1);
                flatBufferBuilder.a(0, builder.f12212a, 0);
                flatBufferBuilder.d(flatBufferBuilder.d());
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                return new TopLevelCommentsModel(new MutableFlatBuffer(wrap, null, null, true, null));
            }

            public final int jK_() {
                return 899897761;
            }

            public final GraphQLVisitableModel m14773a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m14772a(FlatBufferBuilder flatBufferBuilder) {
                h();
                flatBufferBuilder.c(1);
                flatBufferBuilder.a(0, this.f12213d, 0);
                i();
                return flatBufferBuilder.d();
            }

            public final void m14775a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                super.a(mutableFlatBuffer, i, obj);
                this.f12213d = mutableFlatBuffer.a(i, 0, 0);
            }
        }

        @Nullable
        public final /* synthetic */ ViewerActsAsPage m14807p() {
            return m14782H();
        }

        @Nullable
        public final /* synthetic */ ImportantReactorsModel m14810s() {
            return m14776B();
        }

        @Nullable
        public final /* synthetic */ LikersModel m14811t() {
            return m14777C();
        }

        @Nullable
        public final /* synthetic */ ReactorsModel m14812u() {
            return m14778D();
        }

        @Nullable
        public final /* synthetic */ ResharesModel m14813v() {
            return m14779E();
        }

        @Nullable
        public final /* synthetic */ TopLevelCommentsModel m14815x() {
            return m14780F();
        }

        @Nullable
        public final /* synthetic */ TopReactionsModel m14816y() {
            return m14781G();
        }

        @Nullable
        public final /* synthetic */ ViewerActsAsPersonModel m14817z() {
            return m14783I();
        }

        public GametimeDataFactFeedbackFieldsModel() {
            super(25);
        }

        public GametimeDataFactFeedbackFieldsModel(MutableFlatBuffer mutableFlatBuffer) {
            super(25);
            a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
        }

        public final void m14795a(String str, ConsistencyTuple consistencyTuple) {
            if ("can_viewer_comment".equals(str)) {
                consistencyTuple.a = Boolean.valueOf(m14798c());
                consistencyTuple.b = u_();
                consistencyTuple.c = 1;
            } else if ("can_viewer_like".equals(str)) {
                consistencyTuple.a = Boolean.valueOf(bU_());
                consistencyTuple.b = u_();
                consistencyTuple.c = 5;
            } else if ("does_viewer_like".equals(str)) {
                consistencyTuple.a = Boolean.valueOf(m14802k());
                consistencyTuple.b = u_();
                consistencyTuple.c = 10;
            } else if ("is_viewer_subscribed".equals(str)) {
                consistencyTuple.a = Boolean.valueOf(m14804m());
                consistencyTuple.b = u_();
                consistencyTuple.c = 13;
            } else {
                if ("likers.count".equals(str)) {
                    LikersModel C = m14777C();
                    if (C != null) {
                        consistencyTuple.a = Integer.valueOf(C.m14754a());
                        consistencyTuple.b = C.u_();
                        consistencyTuple.c = 0;
                        return;
                    }
                } else if ("reactors.count".equals(str)) {
                    ReactorsModel D = m14778D();
                    if (D != null) {
                        consistencyTuple.a = Integer.valueOf(D.a());
                        consistencyTuple.b = D.u_();
                        consistencyTuple.c = 0;
                        return;
                    }
                } else if ("reshares.count".equals(str)) {
                    ResharesModel E = m14779E();
                    if (E != null) {
                        consistencyTuple.a = Integer.valueOf(E.m14762a());
                        consistencyTuple.b = E.u_();
                        consistencyTuple.c = 0;
                        return;
                    }
                } else if ("top_level_comments.count".equals(str)) {
                    TopLevelCommentsModel F = m14780F();
                    if (F != null) {
                        consistencyTuple.a = Integer.valueOf(F.m14771a());
                        consistencyTuple.b = F.u_();
                        consistencyTuple.c = 0;
                        return;
                    }
                } else if ("viewer_feedback_reaction_key".equals(str)) {
                    consistencyTuple.a = Integer.valueOf(m14790A());
                    consistencyTuple.b = u_();
                    consistencyTuple.c = 24;
                    return;
                }
                consistencyTuple.a();
            }
        }

        public final void m14796a(String str, Object obj, boolean z) {
            if ("can_viewer_comment".equals(str)) {
                m14786a(((Boolean) obj).booleanValue());
            } else if ("can_viewer_like".equals(str)) {
                m14787b(((Boolean) obj).booleanValue());
            } else if ("does_viewer_like".equals(str)) {
                m14788c(((Boolean) obj).booleanValue());
            } else if ("is_viewer_subscribed".equals(str)) {
                m14789d(((Boolean) obj).booleanValue());
            } else if ("likers.count".equals(str)) {
                LikersModel C = m14777C();
                if (C == null) {
                    return;
                }
                if (z) {
                    C = (LikersModel) C.clone();
                    C.m14757a(((Integer) obj).intValue());
                    this.f12231s = C;
                    return;
                }
                C.m14757a(((Integer) obj).intValue());
            } else if ("reactors.count".equals(str)) {
                ReactorsModel D = m14778D();
                if (D == null) {
                    return;
                }
                if (z) {
                    D = (ReactorsModel) D.clone();
                    D.a(((Integer) obj).intValue());
                    this.f12232t = D;
                    return;
                }
                D.a(((Integer) obj).intValue());
            } else if ("reshares.count".equals(str)) {
                ResharesModel E = m14779E();
                if (E == null) {
                    return;
                }
                if (z) {
                    E = (ResharesModel) E.clone();
                    E.m14765a(((Integer) obj).intValue());
                    this.f12234v = E;
                    return;
                }
                E.m14765a(((Integer) obj).intValue());
            } else if ("top_level_comments.count".equals(str)) {
                TopLevelCommentsModel F = m14780F();
                if (F == null) {
                    return;
                }
                if (z) {
                    F = (TopLevelCommentsModel) F.clone();
                    F.m14774a(((Integer) obj).intValue());
                    this.f12236x = F;
                    return;
                }
                F.m14774a(((Integer) obj).intValue());
            } else if ("viewer_feedback_reaction_key".equals(str)) {
                m14785a(((Integer) obj).intValue());
            }
        }

        public final boolean m14797b() {
            a(0, 0);
            return this.f12216d;
        }

        public final boolean m14798c() {
            a(0, 1);
            return this.f12217e;
        }

        private void m14786a(boolean z) {
            this.f12217e = z;
            if (this.b != null && this.b.d) {
                this.b.a(this.c, 1, z);
            }
        }

        public final boolean m14799d() {
            a(0, 2);
            return this.f12218f;
        }

        public final boolean bT_() {
            a(0, 3);
            return this.f12219g;
        }

        public final boolean m14800g() {
            a(0, 4);
            return this.f12220h;
        }

        public final boolean bU_() {
            a(0, 5);
            return this.f12221i;
        }

        private void m14787b(boolean z) {
            this.f12221i = z;
            if (this.b != null && this.b.d) {
                this.b.a(this.c, 5, z);
            }
        }

        public final boolean m14808q() {
            a(0, 6);
            return this.f12222j;
        }

        public final boolean bV_() {
            a(0, 7);
            return this.f12223k;
        }

        @Nullable
        public final String m14801j() {
            this.f12224l = super.a(this.f12224l, 8);
            return this.f12224l;
        }

        public final boolean m14809r() {
            a(1, 1);
            return this.f12225m;
        }

        public final boolean m14802k() {
            a(1, 2);
            return this.f12226n;
        }

        private void m14788c(boolean z) {
            this.f12226n = z;
            if (this.b != null && this.b.d) {
                this.b.a(this.c, 10, z);
            }
        }

        @Nullable
        public final String m14803l() {
            this.f12227o = super.a(this.f12227o, 11);
            return this.f12227o;
        }

        @Nullable
        private ImportantReactorsModel m14776B() {
            this.f12228p = (ImportantReactorsModel) super.a(this.f12228p, 12, ImportantReactorsModel.class);
            return this.f12228p;
        }

        public final boolean m14804m() {
            a(1, 5);
            return this.f12229q;
        }

        private void m14789d(boolean z) {
            this.f12229q = z;
            if (this.b != null && this.b.d) {
                this.b.a(this.c, 13, z);
            }
        }

        @Nullable
        public final String m14805n() {
            this.f12230r = super.a(this.f12230r, 14);
            return this.f12230r;
        }

        @Nullable
        private LikersModel m14777C() {
            this.f12231s = (LikersModel) super.a(this.f12231s, 15, LikersModel.class);
            return this.f12231s;
        }

        @Nullable
        private ReactorsModel m14778D() {
            this.f12232t = (ReactorsModel) super.a(this.f12232t, 16, ReactorsModel.class);
            return this.f12232t;
        }

        @Nullable
        public final String m14806o() {
            this.f12233u = super.a(this.f12233u, 17);
            return this.f12233u;
        }

        @Nullable
        private ResharesModel m14779E() {
            this.f12234v = (ResharesModel) super.a(this.f12234v, 18, ResharesModel.class);
            return this.f12234v;
        }

        @Nonnull
        public final ImmutableList<SupportedReactionsModel> m14814w() {
            this.f12235w = super.a(this.f12235w, 19, SupportedReactionsModel.class);
            return (ImmutableList) this.f12235w;
        }

        @Nullable
        private TopLevelCommentsModel m14780F() {
            this.f12236x = (TopLevelCommentsModel) super.a(this.f12236x, 20, TopLevelCommentsModel.class);
            return this.f12236x;
        }

        @Nullable
        private TopReactionsModel m14781G() {
            this.f12237y = (TopReactionsModel) super.a(this.f12237y, 21, TopReactionsModel.class);
            return this.f12237y;
        }

        @Nullable
        private ViewerActsAsPageModel m14782H() {
            this.f12238z = (ViewerActsAsPageModel) super.a(this.f12238z, 22, ViewerActsAsPageModel.class);
            return this.f12238z;
        }

        @Nullable
        private ViewerActsAsPersonModel m14783I() {
            this.f12214A = (ViewerActsAsPersonModel) super.a(this.f12214A, 23, ViewerActsAsPersonModel.class);
            return this.f12214A;
        }

        public final int m14790A() {
            a(3, 0);
            return this.f12215B;
        }

        private void m14785a(int i) {
            this.f12215B = i;
            if (this.b != null && this.b.d) {
                this.b.b(this.c, 24, i);
            }
        }

        public static GametimeDataFactFeedbackFieldsModel m14784a(GametimeDataFactFeedbackFieldsModel gametimeDataFactFeedbackFieldsModel) {
            if (gametimeDataFactFeedbackFieldsModel == null) {
                return null;
            }
            if (gametimeDataFactFeedbackFieldsModel instanceof GametimeDataFactFeedbackFieldsModel) {
                return gametimeDataFactFeedbackFieldsModel;
            }
            Builder builder = new Builder();
            builder.f12183a = gametimeDataFactFeedbackFieldsModel.m14797b();
            builder.f12184b = gametimeDataFactFeedbackFieldsModel.m14798c();
            builder.f12185c = gametimeDataFactFeedbackFieldsModel.m14799d();
            builder.f12186d = gametimeDataFactFeedbackFieldsModel.bT_();
            builder.f12187e = gametimeDataFactFeedbackFieldsModel.m14800g();
            builder.f12188f = gametimeDataFactFeedbackFieldsModel.bU_();
            builder.f12189g = gametimeDataFactFeedbackFieldsModel.m14808q();
            builder.f12190h = gametimeDataFactFeedbackFieldsModel.bV_();
            builder.f12191i = gametimeDataFactFeedbackFieldsModel.m14801j();
            builder.f12192j = gametimeDataFactFeedbackFieldsModel.m14809r();
            builder.f12193k = gametimeDataFactFeedbackFieldsModel.m14802k();
            builder.f12194l = gametimeDataFactFeedbackFieldsModel.m14803l();
            builder.f12195m = ImportantReactorsModel.a(gametimeDataFactFeedbackFieldsModel.m14810s());
            builder.f12196n = gametimeDataFactFeedbackFieldsModel.m14804m();
            builder.f12197o = gametimeDataFactFeedbackFieldsModel.m14805n();
            builder.f12198p = LikersModel.m14753a(gametimeDataFactFeedbackFieldsModel.m14811t());
            builder.f12199q = ReactorsModel.a(gametimeDataFactFeedbackFieldsModel.m14812u());
            builder.f12200r = gametimeDataFactFeedbackFieldsModel.m14806o();
            builder.f12201s = ResharesModel.m14761a(gametimeDataFactFeedbackFieldsModel.m14813v());
            com.google.common.collect.ImmutableList.Builder builder2 = ImmutableList.builder();
            for (int i = 0; i < gametimeDataFactFeedbackFieldsModel.m14814w().size(); i++) {
                builder2.c(SupportedReactionsModel.a((SupportedReactionsModel) gametimeDataFactFeedbackFieldsModel.m14814w().get(i)));
            }
            builder.f12202t = builder2.b();
            builder.f12203u = TopLevelCommentsModel.m14770a(gametimeDataFactFeedbackFieldsModel.m14815x());
            builder.f12204v = TopReactionsModel.a(gametimeDataFactFeedbackFieldsModel.m14816y());
            builder.f12205w = ViewerActsAsPageModel.a(gametimeDataFactFeedbackFieldsModel.m14807p());
            builder.f12206x = ViewerActsAsPersonModel.a(gametimeDataFactFeedbackFieldsModel.m14817z());
            builder.f12207y = gametimeDataFactFeedbackFieldsModel.m14790A();
            return builder.m14749a();
        }

        @Nullable
        public final String m14793a() {
            return m14805n();
        }

        public final int jK_() {
            return -126857307;
        }

        public final GraphQLVisitableModel m14792a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m14776B() != null) {
                ImportantReactorsModel importantReactorsModel = (ImportantReactorsModel) graphQLModelMutatingVisitor.b(m14776B());
                if (m14776B() != importantReactorsModel) {
                    graphQLVisitableModel = (GametimeDataFactFeedbackFieldsModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f12228p = importantReactorsModel;
                }
            }
            if (m14777C() != null) {
                LikersModel likersModel = (LikersModel) graphQLModelMutatingVisitor.b(m14777C());
                if (m14777C() != likersModel) {
                    graphQLVisitableModel = (GametimeDataFactFeedbackFieldsModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f12231s = likersModel;
                }
            }
            if (m14778D() != null) {
                ReactorsModel reactorsModel = (ReactorsModel) graphQLModelMutatingVisitor.b(m14778D());
                if (m14778D() != reactorsModel) {
                    graphQLVisitableModel = (GametimeDataFactFeedbackFieldsModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f12232t = reactorsModel;
                }
            }
            if (m14779E() != null) {
                ResharesModel resharesModel = (ResharesModel) graphQLModelMutatingVisitor.b(m14779E());
                if (m14779E() != resharesModel) {
                    graphQLVisitableModel = (GametimeDataFactFeedbackFieldsModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f12234v = resharesModel;
                }
            }
            if (m14814w() != null) {
                com.google.common.collect.ImmutableList.Builder a = ModelHelper.a(m14814w(), graphQLModelMutatingVisitor);
                if (a != null) {
                    GametimeDataFactFeedbackFieldsModel gametimeDataFactFeedbackFieldsModel = (GametimeDataFactFeedbackFieldsModel) ModelHelper.a(graphQLVisitableModel, this);
                    gametimeDataFactFeedbackFieldsModel.f12235w = a.b();
                    graphQLVisitableModel = gametimeDataFactFeedbackFieldsModel;
                }
            }
            if (m14780F() != null) {
                TopLevelCommentsModel topLevelCommentsModel = (TopLevelCommentsModel) graphQLModelMutatingVisitor.b(m14780F());
                if (m14780F() != topLevelCommentsModel) {
                    graphQLVisitableModel = (GametimeDataFactFeedbackFieldsModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f12236x = topLevelCommentsModel;
                }
            }
            if (m14781G() != null) {
                TopReactionsModel topReactionsModel = (TopReactionsModel) graphQLModelMutatingVisitor.b(m14781G());
                if (m14781G() != topReactionsModel) {
                    graphQLVisitableModel = (GametimeDataFactFeedbackFieldsModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f12237y = topReactionsModel;
                }
            }
            if (m14782H() != null) {
                ViewerActsAsPageModel viewerActsAsPageModel = (ViewerActsAsPageModel) graphQLModelMutatingVisitor.b(m14782H());
                if (m14782H() != viewerActsAsPageModel) {
                    graphQLVisitableModel = (GametimeDataFactFeedbackFieldsModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f12238z = viewerActsAsPageModel;
                }
            }
            if (m14783I() != null) {
                ViewerActsAsPersonModel viewerActsAsPersonModel = (ViewerActsAsPersonModel) graphQLModelMutatingVisitor.b(m14783I());
                if (m14783I() != viewerActsAsPersonModel) {
                    graphQLVisitableModel = (GametimeDataFactFeedbackFieldsModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f12214A = viewerActsAsPersonModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m14791a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(m14801j());
            int b2 = flatBufferBuilder.b(m14803l());
            int a = ModelHelper.a(flatBufferBuilder, m14776B());
            int b3 = flatBufferBuilder.b(m14805n());
            int a2 = ModelHelper.a(flatBufferBuilder, m14777C());
            int a3 = ModelHelper.a(flatBufferBuilder, m14778D());
            int b4 = flatBufferBuilder.b(m14806o());
            int a4 = ModelHelper.a(flatBufferBuilder, m14779E());
            int a5 = ModelHelper.a(flatBufferBuilder, m14814w());
            int a6 = ModelHelper.a(flatBufferBuilder, m14780F());
            int a7 = ModelHelper.a(flatBufferBuilder, m14781G());
            int a8 = ModelHelper.a(flatBufferBuilder, m14782H());
            int a9 = ModelHelper.a(flatBufferBuilder, m14783I());
            flatBufferBuilder.c(25);
            flatBufferBuilder.a(0, this.f12216d);
            flatBufferBuilder.a(1, this.f12217e);
            flatBufferBuilder.a(2, this.f12218f);
            flatBufferBuilder.a(3, this.f12219g);
            flatBufferBuilder.a(4, this.f12220h);
            flatBufferBuilder.a(5, this.f12221i);
            flatBufferBuilder.a(6, this.f12222j);
            flatBufferBuilder.a(7, this.f12223k);
            flatBufferBuilder.b(8, b);
            flatBufferBuilder.a(9, this.f12225m);
            flatBufferBuilder.a(10, this.f12226n);
            flatBufferBuilder.b(11, b2);
            flatBufferBuilder.b(12, a);
            flatBufferBuilder.a(13, this.f12229q);
            flatBufferBuilder.b(14, b3);
            flatBufferBuilder.b(15, a2);
            flatBufferBuilder.b(16, a3);
            flatBufferBuilder.b(17, b4);
            flatBufferBuilder.b(18, a4);
            flatBufferBuilder.b(19, a5);
            flatBufferBuilder.b(20, a6);
            flatBufferBuilder.b(21, a7);
            flatBufferBuilder.b(22, a8);
            flatBufferBuilder.b(23, a9);
            flatBufferBuilder.a(24, this.f12215B, 0);
            i();
            return flatBufferBuilder.d();
        }

        public final void m14794a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
            super.a(mutableFlatBuffer, i, obj);
            this.f12216d = mutableFlatBuffer.a(i, 0);
            this.f12217e = mutableFlatBuffer.a(i, 1);
            this.f12218f = mutableFlatBuffer.a(i, 2);
            this.f12219g = mutableFlatBuffer.a(i, 3);
            this.f12220h = mutableFlatBuffer.a(i, 4);
            this.f12221i = mutableFlatBuffer.a(i, 5);
            this.f12222j = mutableFlatBuffer.a(i, 6);
            this.f12223k = mutableFlatBuffer.a(i, 7);
            this.f12225m = mutableFlatBuffer.a(i, 9);
            this.f12226n = mutableFlatBuffer.a(i, 10);
            this.f12229q = mutableFlatBuffer.a(i, 13);
            this.f12215B = mutableFlatBuffer.a(i, 24, 0);
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -1617496467)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: final_slider_value */
    public final class GametimeDataFactFragmentModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel, GametimeDataFactFragment {
        @Nullable
        private ActingTeamModel f12286d;
        @Nullable
        private String f12287e;
        @Nullable
        private String f12288f;
        @Nullable
        private String f12289g;
        @Nullable
        private GametimeDataFactFeedbackFieldsModel f12290h;
        @Nullable
        private String f12291i;
        @Nullable
        private String f12292j;
        @Nullable
        private PreviewCommentModel f12293k;
        @Nullable
        private String f12294l;
        private int f12295m;
        @Nullable
        private StoryModel f12296n;

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1895478192)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: final_slider_value */
        public final class ActingTeamModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
            @Nullable
            private String f12245d;
            @Nullable
            private String f12246e;
            @Nullable
            private PageLogoModel f12247f;
            @Nullable
            private String f12248g;

            /* compiled from: final_slider_value */
            public final class Builder {
                @Nullable
                public String f12239a;
                @Nullable
                public String f12240b;
                @Nullable
                public PageLogoModel f12241c;
                @Nullable
                public String f12242d;
            }

            /* compiled from: final_slider_value */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(ActingTeamModel.class, new Deserializer());
                }

                public Object m14818a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(ActingTeamParser.m15170a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object actingTeamModel = new ActingTeamModel();
                    ((BaseModel) actingTeamModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (actingTeamModel instanceof Postprocessable) {
                        return ((Postprocessable) actingTeamModel).a();
                    }
                    return actingTeamModel;
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = 842551240)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: final_slider_value */
            public final class PageLogoModel extends BaseModel implements GraphQLVisitableModel {
                @Nullable
                private String f12244d;

                /* compiled from: final_slider_value */
                public final class Builder {
                    @Nullable
                    public String f12243a;
                }

                /* compiled from: final_slider_value */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(PageLogoModel.class, new Deserializer());
                    }

                    public Object m14819a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(PageLogoParser.m15168a(jsonParser, flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                        Object pageLogoModel = new PageLogoModel();
                        ((BaseModel) pageLogoModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                        if (pageLogoModel instanceof Postprocessable) {
                            return ((Postprocessable) pageLogoModel).a();
                        }
                        return pageLogoModel;
                    }
                }

                /* compiled from: final_slider_value */
                public class Serializer extends JsonSerializer<PageLogoModel> {
                    public final void m14820a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        PageLogoModel pageLogoModel = (PageLogoModel) obj;
                        if (pageLogoModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(pageLogoModel.m14822a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            pageLogoModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        PageLogoParser.m15169a(pageLogoModel.w_(), pageLogoModel.u_(), jsonGenerator);
                    }

                    static {
                        FbSerializerProvider.a(PageLogoModel.class, new Serializer());
                    }
                }

                public PageLogoModel() {
                    super(1);
                }

                public PageLogoModel(MutableFlatBuffer mutableFlatBuffer) {
                    super(1);
                    a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }

                @Nullable
                public final String m14824a() {
                    this.f12244d = super.a(this.f12244d, 0);
                    return this.f12244d;
                }

                public static PageLogoModel m14821a(PageLogoModel pageLogoModel) {
                    if (pageLogoModel == null) {
                        return null;
                    }
                    if (pageLogoModel instanceof PageLogoModel) {
                        return pageLogoModel;
                    }
                    Builder builder = new Builder();
                    builder.f12243a = pageLogoModel.m14824a();
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    int b = flatBufferBuilder.b(builder.f12243a);
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.b(0, b);
                    flatBufferBuilder.d(flatBufferBuilder.d());
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    return new PageLogoModel(new MutableFlatBuffer(wrap, null, null, true, null));
                }

                public final int jK_() {
                    return 70760763;
                }

                public final GraphQLVisitableModel m14823a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    h();
                    i();
                    return this;
                }

                public final int m14822a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int b = flatBufferBuilder.b(m14824a());
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.b(0, b);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            /* compiled from: final_slider_value */
            public class Serializer extends JsonSerializer<ActingTeamModel> {
                public final void m14825a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    ActingTeamModel actingTeamModel = (ActingTeamModel) obj;
                    if (actingTeamModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(actingTeamModel.m14828a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        actingTeamModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    ActingTeamParser.m15171a(actingTeamModel.w_(), actingTeamModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(ActingTeamModel.class, new Serializer());
                }
            }

            @Nullable
            public final /* synthetic */ PageLogoModel m14835d() {
                return m14827j();
            }

            public ActingTeamModel() {
                super(4);
            }

            public ActingTeamModel(MutableFlatBuffer mutableFlatBuffer) {
                super(4);
                a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
            }

            public final void m14831a(String str, ConsistencyTuple consistencyTuple) {
                consistencyTuple.a();
            }

            public final void m14832a(String str, Object obj, boolean z) {
            }

            @Nullable
            public final String m14833b() {
                this.f12245d = super.a(this.f12245d, 0);
                return this.f12245d;
            }

            @Nullable
            public final String m14834c() {
                this.f12246e = super.a(this.f12246e, 1);
                return this.f12246e;
            }

            @Nullable
            private PageLogoModel m14827j() {
                this.f12247f = (PageLogoModel) super.a(this.f12247f, 2, PageLogoModel.class);
                return this.f12247f;
            }

            @Nullable
            public final String eS_() {
                this.f12248g = super.a(this.f12248g, 3);
                return this.f12248g;
            }

            public static ActingTeamModel m14826a(ActingTeamModel actingTeamModel) {
                if (actingTeamModel == null) {
                    return null;
                }
                if (actingTeamModel instanceof ActingTeamModel) {
                    return actingTeamModel;
                }
                Builder builder = new Builder();
                builder.f12239a = actingTeamModel.m14833b();
                builder.f12240b = actingTeamModel.m14834c();
                builder.f12241c = PageLogoModel.m14821a(actingTeamModel.m14835d());
                builder.f12242d = actingTeamModel.eS_();
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                int b = flatBufferBuilder.b(builder.f12239a);
                int b2 = flatBufferBuilder.b(builder.f12240b);
                int a = ModelHelper.a(flatBufferBuilder, builder.f12241c);
                int b3 = flatBufferBuilder.b(builder.f12242d);
                flatBufferBuilder.c(4);
                flatBufferBuilder.b(0, b);
                flatBufferBuilder.b(1, b2);
                flatBufferBuilder.b(2, a);
                flatBufferBuilder.b(3, b3);
                flatBufferBuilder.d(flatBufferBuilder.d());
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                return new ActingTeamModel(new MutableFlatBuffer(wrap, null, null, true, null));
            }

            @Nullable
            public final String m14830a() {
                return m14833b();
            }

            public final int jK_() {
                return 2479791;
            }

            public final GraphQLVisitableModel m14829a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m14827j() != null) {
                    PageLogoModel pageLogoModel = (PageLogoModel) graphQLModelMutatingVisitor.b(m14827j());
                    if (m14827j() != pageLogoModel) {
                        graphQLVisitableModel = (ActingTeamModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f12247f = pageLogoModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m14828a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m14833b());
                int b2 = flatBufferBuilder.b(m14834c());
                int a = ModelHelper.a(flatBufferBuilder, m14827j());
                int b3 = flatBufferBuilder.b(eS_());
                flatBufferBuilder.c(4);
                flatBufferBuilder.b(0, b);
                flatBufferBuilder.b(1, b2);
                flatBufferBuilder.b(2, a);
                flatBufferBuilder.b(3, b3);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: final_slider_value */
        public final class Builder {
            @Nullable
            public ActingTeamModel f12249a;
            @Nullable
            public String f12250b;
            @Nullable
            public String f12251c;
            @Nullable
            public String f12252d;
            @Nullable
            public GametimeDataFactFeedbackFieldsModel f12253e;
            @Nullable
            public String f12254f;
            @Nullable
            public String f12255g;
            @Nullable
            public PreviewCommentModel f12256h;
            @Nullable
            public String f12257i;
            public int f12258j;
            @Nullable
            public StoryModel f12259k;

            public final GametimeDataFactFragmentModel m14836a() {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                int a = ModelHelper.a(flatBufferBuilder, this.f12249a);
                int b = flatBufferBuilder.b(this.f12250b);
                int b2 = flatBufferBuilder.b(this.f12251c);
                int b3 = flatBufferBuilder.b(this.f12252d);
                int a2 = ModelHelper.a(flatBufferBuilder, this.f12253e);
                int b4 = flatBufferBuilder.b(this.f12254f);
                int b5 = flatBufferBuilder.b(this.f12255g);
                int a3 = ModelHelper.a(flatBufferBuilder, this.f12256h);
                int b6 = flatBufferBuilder.b(this.f12257i);
                int a4 = ModelHelper.a(flatBufferBuilder, this.f12259k);
                flatBufferBuilder.c(11);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.b(1, b);
                flatBufferBuilder.b(2, b2);
                flatBufferBuilder.b(3, b3);
                flatBufferBuilder.b(4, a2);
                flatBufferBuilder.b(5, b4);
                flatBufferBuilder.b(6, b5);
                flatBufferBuilder.b(7, a3);
                flatBufferBuilder.b(8, b6);
                flatBufferBuilder.a(9, this.f12258j, 0);
                flatBufferBuilder.b(10, a4);
                flatBufferBuilder.d(flatBufferBuilder.d());
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                return new GametimeDataFactFragmentModel(new MutableFlatBuffer(wrap, null, null, true, null));
            }
        }

        /* compiled from: final_slider_value */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(GametimeDataFactFragmentModel.class, new Deserializer());
            }

            public Object m14837a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(GametimeDataFactFragmentParser.m15182a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object gametimeDataFactFragmentModel = new GametimeDataFactFragmentModel();
                ((BaseModel) gametimeDataFactFragmentModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (gametimeDataFactFragmentModel instanceof Postprocessable) {
                    return ((Postprocessable) gametimeDataFactFragmentModel).a();
                }
                return gametimeDataFactFragmentModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 12101085)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: final_slider_value */
        public final class PreviewCommentModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel {
            @Nullable
            private AuthorModel f12273d;
            @Nullable
            private DefaultTextWithEntitiesFieldsModel f12274e;
            @Nullable
            private String f12275f;

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = -2045399156)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: final_slider_value */
            public final class AuthorModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
                @Nullable
                private GraphQLObjectType f12266d;
                @Nullable
                private String f12267e;
                @Nullable
                private String f12268f;
                @Nullable
                private ProfilePictureModel f12269g;

                /* compiled from: final_slider_value */
                public final class Builder {
                    @Nullable
                    public GraphQLObjectType f12260a;
                    @Nullable
                    public String f12261b;
                    @Nullable
                    public String f12262c;
                    @Nullable
                    public ProfilePictureModel f12263d;
                }

                /* compiled from: final_slider_value */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(AuthorModel.class, new Deserializer());
                    }

                    public Object m14838a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(AuthorParser.m15174a(jsonParser, flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                        Object authorModel = new AuthorModel();
                        ((BaseModel) authorModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                        if (authorModel instanceof Postprocessable) {
                            return ((Postprocessable) authorModel).a();
                        }
                        return authorModel;
                    }
                }

                @JsonDeserialize(using = Deserializer.class)
                @ModelWithFlatBufferFormatHash(a = 842551240)
                @JsonSerialize(using = Serializer.class)
                @FragmentModelWithoutBridge
                /* compiled from: final_slider_value */
                public final class ProfilePictureModel extends BaseModel implements GraphQLVisitableModel {
                    @Nullable
                    private String f12265d;

                    /* compiled from: final_slider_value */
                    public final class Builder {
                        @Nullable
                        public String f12264a;
                    }

                    /* compiled from: final_slider_value */
                    public class Deserializer extends FbJsonDeserializer {
                        static {
                            GlobalAutoGenDeserializerCache.a(ProfilePictureModel.class, new Deserializer());
                        }

                        public Object m14839a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(ProfilePictureParser.m15172a(jsonParser, flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            mutableFlatBuffer.a(4, Boolean.valueOf(true));
                            MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                            Object profilePictureModel = new ProfilePictureModel();
                            ((BaseModel) profilePictureModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                            if (profilePictureModel instanceof Postprocessable) {
                                return ((Postprocessable) profilePictureModel).a();
                            }
                            return profilePictureModel;
                        }
                    }

                    /* compiled from: final_slider_value */
                    public class Serializer extends JsonSerializer<ProfilePictureModel> {
                        public final void m14840a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                            ProfilePictureModel profilePictureModel = (ProfilePictureModel) obj;
                            if (profilePictureModel.w_() == null) {
                                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                flatBufferBuilder.d(profilePictureModel.m14842a(flatBufferBuilder));
                                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                wrap.position(0);
                                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                profilePictureModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                            }
                            ProfilePictureParser.m15173a(profilePictureModel.w_(), profilePictureModel.u_(), jsonGenerator);
                        }

                        static {
                            FbSerializerProvider.a(ProfilePictureModel.class, new Serializer());
                        }
                    }

                    public ProfilePictureModel() {
                        super(1);
                    }

                    public ProfilePictureModel(MutableFlatBuffer mutableFlatBuffer) {
                        super(1);
                        a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }

                    @Nullable
                    public final String m14844a() {
                        this.f12265d = super.a(this.f12265d, 0);
                        return this.f12265d;
                    }

                    public static ProfilePictureModel m14841a(ProfilePictureModel profilePictureModel) {
                        if (profilePictureModel == null) {
                            return null;
                        }
                        if (profilePictureModel instanceof ProfilePictureModel) {
                            return profilePictureModel;
                        }
                        Builder builder = new Builder();
                        builder.f12264a = profilePictureModel.m14844a();
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        int b = flatBufferBuilder.b(builder.f12264a);
                        flatBufferBuilder.c(1);
                        flatBufferBuilder.b(0, b);
                        flatBufferBuilder.d(flatBufferBuilder.d());
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        return new ProfilePictureModel(new MutableFlatBuffer(wrap, null, null, true, null));
                    }

                    public final int jK_() {
                        return 70760763;
                    }

                    public final GraphQLVisitableModel m14843a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                        h();
                        i();
                        return this;
                    }

                    public final int m14842a(FlatBufferBuilder flatBufferBuilder) {
                        h();
                        int b = flatBufferBuilder.b(m14844a());
                        flatBufferBuilder.c(1);
                        flatBufferBuilder.b(0, b);
                        i();
                        return flatBufferBuilder.d();
                    }
                }

                /* compiled from: final_slider_value */
                public class Serializer extends JsonSerializer<AuthorModel> {
                    public final void m14845a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        AuthorModel authorModel = (AuthorModel) obj;
                        if (authorModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(authorModel.m14848a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            authorModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        AuthorParser.m15175a(authorModel.w_(), authorModel.u_(), jsonGenerator, serializerProvider);
                    }

                    static {
                        FbSerializerProvider.a(AuthorModel.class, new Serializer());
                    }
                }

                @Nullable
                public final /* synthetic */ ProfilePictureModel eT_() {
                    return m14847j();
                }

                public AuthorModel() {
                    super(4);
                }

                public AuthorModel(MutableFlatBuffer mutableFlatBuffer) {
                    super(4);
                    a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }

                public final void m14851a(String str, ConsistencyTuple consistencyTuple) {
                    consistencyTuple.a();
                }

                public final void m14852a(String str, Object obj, boolean z) {
                }

                @Nullable
                public final GraphQLObjectType m14853b() {
                    if (this.b != null && this.f12266d == null) {
                        this.f12266d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
                    }
                    return this.f12266d;
                }

                @Nullable
                public final String m14854c() {
                    this.f12267e = super.a(this.f12267e, 1);
                    return this.f12267e;
                }

                @Nullable
                public final String m14855d() {
                    this.f12268f = super.a(this.f12268f, 2);
                    return this.f12268f;
                }

                @Nullable
                private ProfilePictureModel m14847j() {
                    this.f12269g = (ProfilePictureModel) super.a(this.f12269g, 3, ProfilePictureModel.class);
                    return this.f12269g;
                }

                public static AuthorModel m14846a(AuthorModel authorModel) {
                    if (authorModel == null) {
                        return null;
                    }
                    if (authorModel instanceof AuthorModel) {
                        return authorModel;
                    }
                    Builder builder = new Builder();
                    builder.f12260a = authorModel.m14853b();
                    builder.f12261b = authorModel.m14854c();
                    builder.f12262c = authorModel.m14855d();
                    builder.f12263d = ProfilePictureModel.m14841a(authorModel.eT_());
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    int a = ModelHelper.a(flatBufferBuilder, builder.f12260a);
                    int b = flatBufferBuilder.b(builder.f12261b);
                    int b2 = flatBufferBuilder.b(builder.f12262c);
                    int a2 = ModelHelper.a(flatBufferBuilder, builder.f12263d);
                    flatBufferBuilder.c(4);
                    flatBufferBuilder.b(0, a);
                    flatBufferBuilder.b(1, b);
                    flatBufferBuilder.b(2, b2);
                    flatBufferBuilder.b(3, a2);
                    flatBufferBuilder.d(flatBufferBuilder.d());
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    return new AuthorModel(new MutableFlatBuffer(wrap, null, null, true, null));
                }

                @Nullable
                public final String m14850a() {
                    return m14854c();
                }

                public final int jK_() {
                    return 63093205;
                }

                public final GraphQLVisitableModel m14849a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    GraphQLVisitableModel graphQLVisitableModel = null;
                    h();
                    if (m14847j() != null) {
                        ProfilePictureModel profilePictureModel = (ProfilePictureModel) graphQLModelMutatingVisitor.b(m14847j());
                        if (m14847j() != profilePictureModel) {
                            graphQLVisitableModel = (AuthorModel) ModelHelper.a(null, this);
                            graphQLVisitableModel.f12269g = profilePictureModel;
                        }
                    }
                    i();
                    return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                }

                public final int m14848a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int a = ModelHelper.a(flatBufferBuilder, m14853b());
                    int b = flatBufferBuilder.b(m14854c());
                    int b2 = flatBufferBuilder.b(m14855d());
                    int a2 = ModelHelper.a(flatBufferBuilder, m14847j());
                    flatBufferBuilder.c(4);
                    flatBufferBuilder.b(0, a);
                    flatBufferBuilder.b(1, b);
                    flatBufferBuilder.b(2, b2);
                    flatBufferBuilder.b(3, a2);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            /* compiled from: final_slider_value */
            public final class Builder {
                @Nullable
                public AuthorModel f12270a;
                @Nullable
                public DefaultTextWithEntitiesFieldsModel f12271b;
                @Nullable
                public String f12272c;
            }

            /* compiled from: final_slider_value */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(PreviewCommentModel.class, new Deserializer());
                }

                public Object m14856a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(PreviewCommentParser.m15176a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object previewCommentModel = new PreviewCommentModel();
                    ((BaseModel) previewCommentModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (previewCommentModel instanceof Postprocessable) {
                        return ((Postprocessable) previewCommentModel).a();
                    }
                    return previewCommentModel;
                }
            }

            /* compiled from: final_slider_value */
            public class Serializer extends JsonSerializer<PreviewCommentModel> {
                public final void m14857a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    PreviewCommentModel previewCommentModel = (PreviewCommentModel) obj;
                    if (previewCommentModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(previewCommentModel.m14861a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        previewCommentModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    PreviewCommentParser.m15177a(previewCommentModel.w_(), previewCommentModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(PreviewCommentModel.class, new Serializer());
                }
            }

            @Nullable
            public final /* synthetic */ AuthorModel m14864b() {
                return m14859j();
            }

            @Nullable
            public final /* synthetic */ DefaultTextWithEntitiesFields m14865c() {
                return m14860k();
            }

            public PreviewCommentModel() {
                super(3);
            }

            public PreviewCommentModel(MutableFlatBuffer mutableFlatBuffer) {
                super(3);
                a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
            }

            @Nullable
            private AuthorModel m14859j() {
                this.f12273d = (AuthorModel) super.a(this.f12273d, 0, AuthorModel.class);
                return this.f12273d;
            }

            @Nullable
            private DefaultTextWithEntitiesFieldsModel m14860k() {
                this.f12274e = (DefaultTextWithEntitiesFieldsModel) super.a(this.f12274e, 1, DefaultTextWithEntitiesFieldsModel.class);
                return this.f12274e;
            }

            @Nullable
            public final String m14866d() {
                this.f12275f = super.a(this.f12275f, 2);
                return this.f12275f;
            }

            public static PreviewCommentModel m14858a(PreviewCommentModel previewCommentModel) {
                if (previewCommentModel == null) {
                    return null;
                }
                if (previewCommentModel instanceof PreviewCommentModel) {
                    return previewCommentModel;
                }
                Builder builder = new Builder();
                builder.f12270a = AuthorModel.m14846a(previewCommentModel.m14864b());
                builder.f12271b = DefaultTextWithEntitiesFieldsModel.a(previewCommentModel.m14865c());
                builder.f12272c = previewCommentModel.m14866d();
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                int a = ModelHelper.a(flatBufferBuilder, builder.f12270a);
                int a2 = ModelHelper.a(flatBufferBuilder, builder.f12271b);
                int b = flatBufferBuilder.b(builder.f12272c);
                flatBufferBuilder.c(3);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.b(1, a2);
                flatBufferBuilder.b(2, b);
                flatBufferBuilder.d(flatBufferBuilder.d());
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                return new PreviewCommentModel(new MutableFlatBuffer(wrap, null, null, true, null));
            }

            @Nullable
            public final String m14863a() {
                return m14866d();
            }

            public final int jK_() {
                return -1679915457;
            }

            public final GraphQLVisitableModel m14862a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m14859j() != null) {
                    AuthorModel authorModel = (AuthorModel) graphQLModelMutatingVisitor.b(m14859j());
                    if (m14859j() != authorModel) {
                        graphQLVisitableModel = (PreviewCommentModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f12273d = authorModel;
                    }
                }
                if (m14860k() != null) {
                    DefaultTextWithEntitiesFieldsModel defaultTextWithEntitiesFieldsModel = (DefaultTextWithEntitiesFieldsModel) graphQLModelMutatingVisitor.b(m14860k());
                    if (m14860k() != defaultTextWithEntitiesFieldsModel) {
                        graphQLVisitableModel = (PreviewCommentModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f12274e = defaultTextWithEntitiesFieldsModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m14861a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m14859j());
                int a2 = ModelHelper.a(flatBufferBuilder, m14860k());
                int b = flatBufferBuilder.b(m14866d());
                flatBufferBuilder.c(3);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.b(1, a2);
                flatBufferBuilder.b(2, b);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: final_slider_value */
        public class Serializer extends JsonSerializer<GametimeDataFactFragmentModel> {
            public final void m14867a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                GametimeDataFactFragmentModel gametimeDataFactFragmentModel = (GametimeDataFactFragmentModel) obj;
                if (gametimeDataFactFragmentModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(gametimeDataFactFragmentModel.m14893a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    gametimeDataFactFragmentModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                GametimeDataFactFragmentParser.m15185b(gametimeDataFactFragmentModel.w_(), gametimeDataFactFragmentModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(GametimeDataFactFragmentModel.class, new Serializer());
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1403415917)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: final_slider_value */
        public final class StoryModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
            @Nullable
            private String f12283d;
            @Nullable
            private String f12284e;
            @Nullable
            private ShareableModel f12285f;

            /* compiled from: final_slider_value */
            public final class Builder {
                @Nullable
                public String f12276a;
                @Nullable
                public String f12277b;
                @Nullable
                public ShareableModel f12278c;
            }

            /* compiled from: final_slider_value */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(StoryModel.class, new Deserializer());
                }

                public Object m14868a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(StoryParser.m15180a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object storyModel = new StoryModel();
                    ((BaseModel) storyModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (storyModel instanceof Postprocessable) {
                        return ((Postprocessable) storyModel).a();
                    }
                    return storyModel;
                }
            }

            /* compiled from: final_slider_value */
            public class Serializer extends JsonSerializer<StoryModel> {
                public final void m14869a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    StoryModel storyModel = (StoryModel) obj;
                    if (storyModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(storyModel.m14880a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        storyModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    StoryParser.m15181a(storyModel.w_(), storyModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(StoryModel.class, new Serializer());
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = -1787905591)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: final_slider_value */
            public final class ShareableModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel {
                @Nullable
                private GraphQLObjectType f12281d;
                @Nullable
                private String f12282e;

                /* compiled from: final_slider_value */
                public final class Builder {
                    @Nullable
                    public GraphQLObjectType f12279a;
                    @Nullable
                    public String f12280b;
                }

                /* compiled from: final_slider_value */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(ShareableModel.class, new Deserializer());
                    }

                    public Object m14870a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(ShareableParser.m15178a(jsonParser, flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                        Object shareableModel = new ShareableModel();
                        ((BaseModel) shareableModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                        if (shareableModel instanceof Postprocessable) {
                            return ((Postprocessable) shareableModel).a();
                        }
                        return shareableModel;
                    }
                }

                /* compiled from: final_slider_value */
                public class Serializer extends JsonSerializer<ShareableModel> {
                    public final void m14871a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        ShareableModel shareableModel = (ShareableModel) obj;
                        if (shareableModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(shareableModel.m14873a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            shareableModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        ShareableParser.m15179a(shareableModel.w_(), shareableModel.u_(), jsonGenerator);
                    }

                    static {
                        FbSerializerProvider.a(ShareableModel.class, new Serializer());
                    }
                }

                public ShareableModel() {
                    super(2);
                }

                public ShareableModel(MutableFlatBuffer mutableFlatBuffer) {
                    super(2);
                    a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }

                @Nullable
                public final GraphQLObjectType m14876b() {
                    if (this.b != null && this.f12281d == null) {
                        this.f12281d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
                    }
                    return this.f12281d;
                }

                @Nullable
                public final String m14877c() {
                    this.f12282e = super.a(this.f12282e, 1);
                    return this.f12282e;
                }

                public static ShareableModel m14872a(ShareableModel shareableModel) {
                    if (shareableModel == null) {
                        return null;
                    }
                    if (shareableModel instanceof ShareableModel) {
                        return shareableModel;
                    }
                    Builder builder = new Builder();
                    builder.f12279a = shareableModel.m14876b();
                    builder.f12280b = shareableModel.m14877c();
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    int a = ModelHelper.a(flatBufferBuilder, builder.f12279a);
                    int b = flatBufferBuilder.b(builder.f12280b);
                    flatBufferBuilder.c(2);
                    flatBufferBuilder.b(0, a);
                    flatBufferBuilder.b(1, b);
                    flatBufferBuilder.d(flatBufferBuilder.d());
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    return new ShareableModel(new MutableFlatBuffer(wrap, null, null, true, null));
                }

                @Nullable
                public final String m14875a() {
                    return m14877c();
                }

                public final int jK_() {
                    return 2080559107;
                }

                public final GraphQLVisitableModel m14874a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    h();
                    i();
                    return this;
                }

                public final int m14873a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int a = ModelHelper.a(flatBufferBuilder, m14876b());
                    int b = flatBufferBuilder.b(m14877c());
                    flatBufferBuilder.c(2);
                    flatBufferBuilder.b(0, a);
                    flatBufferBuilder.b(1, b);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            @Nullable
            public final /* synthetic */ ShareableModel m14887d() {
                return m14879j();
            }

            public StoryModel() {
                super(3);
            }

            public StoryModel(MutableFlatBuffer mutableFlatBuffer) {
                super(3);
                a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
            }

            public final void m14883a(String str, ConsistencyTuple consistencyTuple) {
                consistencyTuple.a();
            }

            public final void m14884a(String str, Object obj, boolean z) {
            }

            @Nullable
            public final String m14885b() {
                this.f12283d = super.a(this.f12283d, 0);
                return this.f12283d;
            }

            @Nullable
            public final String m14886c() {
                this.f12284e = super.a(this.f12284e, 1);
                return this.f12284e;
            }

            @Nullable
            private ShareableModel m14879j() {
                this.f12285f = (ShareableModel) super.a(this.f12285f, 2, ShareableModel.class);
                return this.f12285f;
            }

            public static StoryModel m14878a(StoryModel storyModel) {
                if (storyModel == null) {
                    return null;
                }
                if (storyModel instanceof StoryModel) {
                    return storyModel;
                }
                Builder builder = new Builder();
                builder.f12276a = storyModel.m14885b();
                builder.f12277b = storyModel.m14886c();
                builder.f12278c = ShareableModel.m14872a(storyModel.m14887d());
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                int b = flatBufferBuilder.b(builder.f12276a);
                int b2 = flatBufferBuilder.b(builder.f12277b);
                int a = ModelHelper.a(flatBufferBuilder, builder.f12278c);
                flatBufferBuilder.c(3);
                flatBufferBuilder.b(0, b);
                flatBufferBuilder.b(1, b2);
                flatBufferBuilder.b(2, a);
                flatBufferBuilder.d(flatBufferBuilder.d());
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                return new StoryModel(new MutableFlatBuffer(wrap, null, null, true, null));
            }

            @Nullable
            public final String m14882a() {
                return m14886c();
            }

            public final int jK_() {
                return 80218325;
            }

            public final GraphQLVisitableModel m14881a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m14879j() != null) {
                    ShareableModel shareableModel = (ShareableModel) graphQLModelMutatingVisitor.b(m14879j());
                    if (m14879j() != shareableModel) {
                        graphQLVisitableModel = (StoryModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f12285f = shareableModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m14880a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m14885b());
                int b2 = flatBufferBuilder.b(m14886c());
                int a = ModelHelper.a(flatBufferBuilder, m14879j());
                flatBufferBuilder.c(3);
                flatBufferBuilder.b(0, b);
                flatBufferBuilder.b(1, b2);
                flatBufferBuilder.b(2, a);
                i();
                return flatBufferBuilder.d();
            }
        }

        @Nullable
        public final /* synthetic */ ActingTeamModel mo787b() {
            return m14889n();
        }

        @Nullable
        public final /* synthetic */ GametimeDataFactFeedbackFieldsModel mo793g() {
            return m14890o();
        }

        @Nullable
        public final /* synthetic */ PreviewCommentModel mo794j() {
            return m14891p();
        }

        @Nullable
        public final /* synthetic */ StoryModel mo797m() {
            return m14892q();
        }

        public GametimeDataFactFragmentModel() {
            super(11);
        }

        public GametimeDataFactFragmentModel(MutableFlatBuffer mutableFlatBuffer) {
            super(11);
            a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
        }

        @Nullable
        private ActingTeamModel m14889n() {
            this.f12286d = (ActingTeamModel) super.a(this.f12286d, 0, ActingTeamModel.class);
            return this.f12286d;
        }

        @Nullable
        public final String mo788c() {
            this.f12287e = super.a(this.f12287e, 1);
            return this.f12287e;
        }

        @Nullable
        public final String mo789d() {
            this.f12288f = super.a(this.f12288f, 2);
            return this.f12288f;
        }

        @Nullable
        public final String eP_() {
            this.f12289g = super.a(this.f12289g, 3);
            return this.f12289g;
        }

        @Nullable
        private GametimeDataFactFeedbackFieldsModel m14890o() {
            this.f12290h = (GametimeDataFactFeedbackFieldsModel) super.a(this.f12290h, 4, GametimeDataFactFeedbackFieldsModel.class);
            return this.f12290h;
        }

        @Nullable
        public final String eQ_() {
            this.f12291i = super.a(this.f12291i, 5);
            return this.f12291i;
        }

        @Nullable
        public final String eR_() {
            this.f12292j = super.a(this.f12292j, 6);
            return this.f12292j;
        }

        @Nullable
        private PreviewCommentModel m14891p() {
            this.f12293k = (PreviewCommentModel) super.a(this.f12293k, 7, PreviewCommentModel.class);
            return this.f12293k;
        }

        @Nullable
        public final String mo795k() {
            this.f12294l = super.a(this.f12294l, 8);
            return this.f12294l;
        }

        public final int mo796l() {
            a(1, 1);
            return this.f12295m;
        }

        @Nullable
        private StoryModel m14892q() {
            this.f12296n = (StoryModel) super.a(this.f12296n, 10, StoryModel.class);
            return this.f12296n;
        }

        public static GametimeDataFactFragmentModel m14888a(GametimeDataFactFragment gametimeDataFactFragment) {
            if (gametimeDataFactFragment == null) {
                return null;
            }
            if (gametimeDataFactFragment instanceof GametimeDataFactFragmentModel) {
                return (GametimeDataFactFragmentModel) gametimeDataFactFragment;
            }
            Builder builder = new Builder();
            builder.f12249a = ActingTeamModel.m14826a(gametimeDataFactFragment.mo787b());
            builder.f12250b = gametimeDataFactFragment.mo788c();
            builder.f12251c = gametimeDataFactFragment.mo789d();
            builder.f12252d = gametimeDataFactFragment.eP_();
            builder.f12253e = GametimeDataFactFeedbackFieldsModel.m14784a(gametimeDataFactFragment.mo793g());
            builder.f12254f = gametimeDataFactFragment.eQ_();
            builder.f12255g = gametimeDataFactFragment.eR_();
            builder.f12256h = PreviewCommentModel.m14858a(gametimeDataFactFragment.mo794j());
            builder.f12257i = gametimeDataFactFragment.mo795k();
            builder.f12258j = gametimeDataFactFragment.mo796l();
            builder.f12259k = StoryModel.m14878a(gametimeDataFactFragment.mo797m());
            return builder.m14836a();
        }

        @Nullable
        public final String m14895a() {
            return eR_();
        }

        public final int jK_() {
            return 2006245554;
        }

        public final GraphQLVisitableModel m14894a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m14889n() != null) {
                ActingTeamModel actingTeamModel = (ActingTeamModel) graphQLModelMutatingVisitor.b(m14889n());
                if (m14889n() != actingTeamModel) {
                    graphQLVisitableModel = (GametimeDataFactFragmentModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f12286d = actingTeamModel;
                }
            }
            if (m14890o() != null) {
                GametimeDataFactFeedbackFieldsModel gametimeDataFactFeedbackFieldsModel = (GametimeDataFactFeedbackFieldsModel) graphQLModelMutatingVisitor.b(m14890o());
                if (m14890o() != gametimeDataFactFeedbackFieldsModel) {
                    graphQLVisitableModel = (GametimeDataFactFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f12290h = gametimeDataFactFeedbackFieldsModel;
                }
            }
            if (m14891p() != null) {
                PreviewCommentModel previewCommentModel = (PreviewCommentModel) graphQLModelMutatingVisitor.b(m14891p());
                if (m14891p() != previewCommentModel) {
                    graphQLVisitableModel = (GametimeDataFactFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f12293k = previewCommentModel;
                }
            }
            if (m14892q() != null) {
                StoryModel storyModel = (StoryModel) graphQLModelMutatingVisitor.b(m14892q());
                if (m14892q() != storyModel) {
                    graphQLVisitableModel = (GametimeDataFactFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f12296n = storyModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m14893a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m14889n());
            int b = flatBufferBuilder.b(mo788c());
            int b2 = flatBufferBuilder.b(mo789d());
            int b3 = flatBufferBuilder.b(eP_());
            int a2 = ModelHelper.a(flatBufferBuilder, m14890o());
            int b4 = flatBufferBuilder.b(eQ_());
            int b5 = flatBufferBuilder.b(eR_());
            int a3 = ModelHelper.a(flatBufferBuilder, m14891p());
            int b6 = flatBufferBuilder.b(mo795k());
            int a4 = ModelHelper.a(flatBufferBuilder, m14892q());
            flatBufferBuilder.c(11);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, b);
            flatBufferBuilder.b(2, b2);
            flatBufferBuilder.b(3, b3);
            flatBufferBuilder.b(4, a2);
            flatBufferBuilder.b(5, b4);
            flatBufferBuilder.b(6, b5);
            flatBufferBuilder.b(7, a3);
            flatBufferBuilder.b(8, b6);
            flatBufferBuilder.a(9, this.f12295m, 0);
            flatBufferBuilder.b(10, a4);
            i();
            return flatBufferBuilder.d();
        }

        public final void m14896a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
            super.a(mutableFlatBuffer, i, obj);
            this.f12295m = mutableFlatBuffer.a(i, 9, 0);
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 1681531753)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: final_slider_value */
    public final class GametimeFanFavoriteMatchFragmentModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel, GametimeFanFavoriteMatchFragment {
        private int f12308d;
        @Nullable
        private AwayTeamObjectModel f12309e;
        @Nullable
        private String f12310f;
        private int f12311g;
        @Nullable
        private HomeTeamObjectModel f12312h;
        @Nullable
        private String f12313i;
        @Nullable
        private String f12314j;
        @Nullable
        private MatchPageModel f12315k;
        private boolean f12316l;

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 207220418)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: final_slider_value */
        public final class AwayTeamObjectModel extends BaseModel implements GraphQLVisitableModel, AwayTeamObject {
            @Nullable
            private GraphQLObjectType f12299d;
            @Nullable
            private OfficialPageModel f12300e;
            @Nullable
            private String f12301f;

            /* compiled from: final_slider_value */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(AwayTeamObjectModel.class, new Deserializer());
                }

                public Object m14905a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(AwayTeamObjectParser.m15190a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object awayTeamObjectModel = new AwayTeamObjectModel();
                    ((BaseModel) awayTeamObjectModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (awayTeamObjectModel instanceof Postprocessable) {
                        return ((Postprocessable) awayTeamObjectModel).a();
                    }
                    return awayTeamObjectModel;
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = 1057228744)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: final_slider_value */
            public final class OfficialPageModel extends BaseModel implements GraphQLVisitableConsistentModel, OfficialPage {
                @Nullable
                private PageLogoModel f12298d;

                /* compiled from: final_slider_value */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(OfficialPageModel.class, new Deserializer());
                    }

                    public Object m14906a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(OfficialPageParser.m15188a(jsonParser, flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                        Object officialPageModel = new OfficialPageModel();
                        ((BaseModel) officialPageModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                        if (officialPageModel instanceof Postprocessable) {
                            return ((Postprocessable) officialPageModel).a();
                        }
                        return officialPageModel;
                    }
                }

                @JsonDeserialize(using = Deserializer.class)
                @ModelWithFlatBufferFormatHash(a = 842551240)
                @JsonSerialize(using = Serializer.class)
                @FragmentModelWithoutBridge
                /* compiled from: final_slider_value */
                public final class PageLogoModel extends BaseModel implements GraphQLVisitableModel, PageLogo {
                    @Nullable
                    private String f12297d;

                    /* compiled from: final_slider_value */
                    public class Deserializer extends FbJsonDeserializer {
                        static {
                            GlobalAutoGenDeserializerCache.a(PageLogoModel.class, new Deserializer());
                        }

                        public Object m14907a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(OfficialPageParser.PageLogoParser.m15186a(jsonParser, flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            mutableFlatBuffer.a(4, Boolean.valueOf(true));
                            MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                            Object pageLogoModel = new PageLogoModel();
                            ((BaseModel) pageLogoModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                            if (pageLogoModel instanceof Postprocessable) {
                                return ((Postprocessable) pageLogoModel).a();
                            }
                            return pageLogoModel;
                        }
                    }

                    /* compiled from: final_slider_value */
                    public class Serializer extends JsonSerializer<PageLogoModel> {
                        public final void m14908a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                            PageLogoModel pageLogoModel = (PageLogoModel) obj;
                            if (pageLogoModel.w_() == null) {
                                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                flatBufferBuilder.d(pageLogoModel.m14909a(flatBufferBuilder));
                                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                wrap.position(0);
                                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                pageLogoModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                            }
                            OfficialPageParser.PageLogoParser.m15187a(pageLogoModel.w_(), pageLogoModel.u_(), jsonGenerator);
                        }

                        static {
                            FbSerializerProvider.a(PageLogoModel.class, new Serializer());
                        }
                    }

                    public PageLogoModel() {
                        super(1);
                    }

                    @Nullable
                    public final String mo798a() {
                        this.f12297d = super.a(this.f12297d, 0);
                        return this.f12297d;
                    }

                    public final int jK_() {
                        return 70760763;
                    }

                    public final GraphQLVisitableModel m14910a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                        h();
                        i();
                        return this;
                    }

                    public final int m14909a(FlatBufferBuilder flatBufferBuilder) {
                        h();
                        int b = flatBufferBuilder.b(mo798a());
                        flatBufferBuilder.c(1);
                        flatBufferBuilder.b(0, b);
                        i();
                        return flatBufferBuilder.d();
                    }
                }

                /* compiled from: final_slider_value */
                public class Serializer extends JsonSerializer<OfficialPageModel> {
                    public final void m14912a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        OfficialPageModel officialPageModel = (OfficialPageModel) obj;
                        if (officialPageModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(officialPageModel.m14914a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            officialPageModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        OfficialPageParser.m15189a(officialPageModel.w_(), officialPageModel.u_(), jsonGenerator, serializerProvider);
                    }

                    static {
                        FbSerializerProvider.a(OfficialPageModel.class, new Serializer());
                    }
                }

                @Nullable
                public final /* synthetic */ PageLogo mo799a() {
                    return m14913j();
                }

                public OfficialPageModel() {
                    super(1);
                }

                public final void m14917a(String str, ConsistencyTuple consistencyTuple) {
                    consistencyTuple.a();
                }

                public final void m14918a(String str, Object obj, boolean z) {
                }

                @Nullable
                private PageLogoModel m14913j() {
                    this.f12298d = (PageLogoModel) super.a(this.f12298d, 0, PageLogoModel.class);
                    return this.f12298d;
                }

                public final int jK_() {
                    return 2479791;
                }

                public final GraphQLVisitableModel m14915a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    GraphQLVisitableModel graphQLVisitableModel = null;
                    h();
                    if (m14913j() != null) {
                        PageLogoModel pageLogoModel = (PageLogoModel) graphQLModelMutatingVisitor.b(m14913j());
                        if (m14913j() != pageLogoModel) {
                            graphQLVisitableModel = (OfficialPageModel) ModelHelper.a(null, this);
                            graphQLVisitableModel.f12298d = pageLogoModel;
                        }
                    }
                    i();
                    return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                }

                public final int m14914a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int a = ModelHelper.a(flatBufferBuilder, m14913j());
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.b(0, a);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            /* compiled from: final_slider_value */
            public class Serializer extends JsonSerializer<AwayTeamObjectModel> {
                public final void m14919a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    AwayTeamObjectModel awayTeamObjectModel = (AwayTeamObjectModel) obj;
                    if (awayTeamObjectModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(awayTeamObjectModel.m14922a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        awayTeamObjectModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    AwayTeamObjectParser.m15191a(awayTeamObjectModel.w_(), awayTeamObjectModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(AwayTeamObjectModel.class, new Serializer());
                }
            }

            @Nullable
            public final /* synthetic */ OfficialPage mo800a() {
                return m14921k();
            }

            public AwayTeamObjectModel() {
                super(3);
            }

            @Nullable
            private GraphQLObjectType m14920j() {
                if (this.b != null && this.f12299d == null) {
                    this.f12299d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
                }
                return this.f12299d;
            }

            @Nullable
            private OfficialPageModel m14921k() {
                this.f12300e = (OfficialPageModel) super.a(this.f12300e, 1, OfficialPageModel.class);
                return this.f12300e;
            }

            @Nullable
            public final String mo801b() {
                this.f12301f = super.a(this.f12301f, 2);
                return this.f12301f;
            }

            public final int jK_() {
                return 2002223772;
            }

            public final GraphQLVisitableModel m14923a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m14921k() != null) {
                    OfficialPageModel officialPageModel = (OfficialPageModel) graphQLModelMutatingVisitor.b(m14921k());
                    if (m14921k() != officialPageModel) {
                        graphQLVisitableModel = (AwayTeamObjectModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f12300e = officialPageModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m14922a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m14920j());
                int a2 = ModelHelper.a(flatBufferBuilder, m14921k());
                int b = flatBufferBuilder.b(mo801b());
                flatBufferBuilder.c(3);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.b(1, a2);
                flatBufferBuilder.b(2, b);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: final_slider_value */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(GametimeFanFavoriteMatchFragmentModel.class, new Deserializer());
            }

            public Object m14926a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(GametimeFanFavoriteMatchFragmentParser.m15200a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object gametimeFanFavoriteMatchFragmentModel = new GametimeFanFavoriteMatchFragmentModel();
                ((BaseModel) gametimeFanFavoriteMatchFragmentModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (gametimeFanFavoriteMatchFragmentModel instanceof Postprocessable) {
                    return ((Postprocessable) gametimeFanFavoriteMatchFragmentModel).a();
                }
                return gametimeFanFavoriteMatchFragmentModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1709764231)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: final_slider_value */
        public final class HomeTeamObjectModel extends BaseModel implements GraphQLVisitableModel, HomeTeamObject {
            @Nullable
            private GraphQLObjectType f12304d;
            @Nullable
            private OfficialPageModel f12305e;
            @Nullable
            private String f12306f;

            /* compiled from: final_slider_value */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(HomeTeamObjectModel.class, new Deserializer());
                }

                public Object m14927a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(HomeTeamObjectParser.m15196a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object homeTeamObjectModel = new HomeTeamObjectModel();
                    ((BaseModel) homeTeamObjectModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (homeTeamObjectModel instanceof Postprocessable) {
                        return ((Postprocessable) homeTeamObjectModel).a();
                    }
                    return homeTeamObjectModel;
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = 352713700)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: final_slider_value */
            public final class OfficialPageModel extends BaseModel implements GraphQLVisitableConsistentModel, HomeTeamObject.OfficialPage {
                @Nullable
                private PageLogoModel f12303d;

                /* compiled from: final_slider_value */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(OfficialPageModel.class, new Deserializer());
                    }

                    public Object m14928a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(HomeTeamObjectParser.OfficialPageParser.m15194a(jsonParser, flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                        Object officialPageModel = new OfficialPageModel();
                        ((BaseModel) officialPageModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                        if (officialPageModel instanceof Postprocessable) {
                            return ((Postprocessable) officialPageModel).a();
                        }
                        return officialPageModel;
                    }
                }

                @JsonDeserialize(using = Deserializer.class)
                @ModelWithFlatBufferFormatHash(a = 842551240)
                @JsonSerialize(using = Serializer.class)
                @FragmentModelWithoutBridge
                /* compiled from: final_slider_value */
                public final class PageLogoModel extends BaseModel implements GraphQLVisitableModel, HomeTeamObject.OfficialPage.PageLogo {
                    @Nullable
                    private String f12302d;

                    /* compiled from: final_slider_value */
                    public class Deserializer extends FbJsonDeserializer {
                        static {
                            GlobalAutoGenDeserializerCache.a(PageLogoModel.class, new Deserializer());
                        }

                        public Object m14929a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(HomeTeamObjectParser.OfficialPageParser.PageLogoParser.m15192a(jsonParser, flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            mutableFlatBuffer.a(4, Boolean.valueOf(true));
                            MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                            Object pageLogoModel = new PageLogoModel();
                            ((BaseModel) pageLogoModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                            if (pageLogoModel instanceof Postprocessable) {
                                return ((Postprocessable) pageLogoModel).a();
                            }
                            return pageLogoModel;
                        }
                    }

                    /* compiled from: final_slider_value */
                    public class Serializer extends JsonSerializer<PageLogoModel> {
                        public final void m14930a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                            PageLogoModel pageLogoModel = (PageLogoModel) obj;
                            if (pageLogoModel.w_() == null) {
                                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                flatBufferBuilder.d(pageLogoModel.m14931a(flatBufferBuilder));
                                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                wrap.position(0);
                                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                pageLogoModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                            }
                            HomeTeamObjectParser.OfficialPageParser.PageLogoParser.m15193a(pageLogoModel.w_(), pageLogoModel.u_(), jsonGenerator);
                        }

                        static {
                            FbSerializerProvider.a(PageLogoModel.class, new Serializer());
                        }
                    }

                    public PageLogoModel() {
                        super(1);
                    }

                    @Nullable
                    public final String mo802a() {
                        this.f12302d = super.a(this.f12302d, 0);
                        return this.f12302d;
                    }

                    public final int jK_() {
                        return 70760763;
                    }

                    public final GraphQLVisitableModel m14932a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                        h();
                        i();
                        return this;
                    }

                    public final int m14931a(FlatBufferBuilder flatBufferBuilder) {
                        h();
                        int b = flatBufferBuilder.b(mo802a());
                        flatBufferBuilder.c(1);
                        flatBufferBuilder.b(0, b);
                        i();
                        return flatBufferBuilder.d();
                    }
                }

                /* compiled from: final_slider_value */
                public class Serializer extends JsonSerializer<OfficialPageModel> {
                    public final void m14934a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        OfficialPageModel officialPageModel = (OfficialPageModel) obj;
                        if (officialPageModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(officialPageModel.m14936a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            officialPageModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        HomeTeamObjectParser.OfficialPageParser.m15195a(officialPageModel.w_(), officialPageModel.u_(), jsonGenerator, serializerProvider);
                    }

                    static {
                        FbSerializerProvider.a(OfficialPageModel.class, new Serializer());
                    }
                }

                @Nullable
                public final /* synthetic */ HomeTeamObject.OfficialPage.PageLogo mo803a() {
                    return m14935j();
                }

                public OfficialPageModel() {
                    super(1);
                }

                public final void m14939a(String str, ConsistencyTuple consistencyTuple) {
                    consistencyTuple.a();
                }

                public final void m14940a(String str, Object obj, boolean z) {
                }

                @Nullable
                private PageLogoModel m14935j() {
                    this.f12303d = (PageLogoModel) super.a(this.f12303d, 0, PageLogoModel.class);
                    return this.f12303d;
                }

                public final int jK_() {
                    return 2479791;
                }

                public final GraphQLVisitableModel m14937a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    GraphQLVisitableModel graphQLVisitableModel = null;
                    h();
                    if (m14935j() != null) {
                        PageLogoModel pageLogoModel = (PageLogoModel) graphQLModelMutatingVisitor.b(m14935j());
                        if (m14935j() != pageLogoModel) {
                            graphQLVisitableModel = (OfficialPageModel) ModelHelper.a(null, this);
                            graphQLVisitableModel.f12303d = pageLogoModel;
                        }
                    }
                    i();
                    return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                }

                public final int m14936a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int a = ModelHelper.a(flatBufferBuilder, m14935j());
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.b(0, a);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            /* compiled from: final_slider_value */
            public class Serializer extends JsonSerializer<HomeTeamObjectModel> {
                public final void m14941a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    HomeTeamObjectModel homeTeamObjectModel = (HomeTeamObjectModel) obj;
                    if (homeTeamObjectModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(homeTeamObjectModel.m14944a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        homeTeamObjectModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    HomeTeamObjectParser.m15197a(homeTeamObjectModel.w_(), homeTeamObjectModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(HomeTeamObjectModel.class, new Serializer());
                }
            }

            @Nullable
            public final /* synthetic */ HomeTeamObject.OfficialPage mo804a() {
                return m14943k();
            }

            public HomeTeamObjectModel() {
                super(3);
            }

            @Nullable
            private GraphQLObjectType m14942j() {
                if (this.b != null && this.f12304d == null) {
                    this.f12304d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
                }
                return this.f12304d;
            }

            @Nullable
            private OfficialPageModel m14943k() {
                this.f12305e = (OfficialPageModel) super.a(this.f12305e, 1, OfficialPageModel.class);
                return this.f12305e;
            }

            @Nullable
            public final String mo805b() {
                this.f12306f = super.a(this.f12306f, 2);
                return this.f12306f;
            }

            public final int jK_() {
                return 2002223772;
            }

            public final GraphQLVisitableModel m14945a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m14943k() != null) {
                    OfficialPageModel officialPageModel = (OfficialPageModel) graphQLModelMutatingVisitor.b(m14943k());
                    if (m14943k() != officialPageModel) {
                        graphQLVisitableModel = (HomeTeamObjectModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f12305e = officialPageModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m14944a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m14942j());
                int a2 = ModelHelper.a(flatBufferBuilder, m14943k());
                int b = flatBufferBuilder.b(mo805b());
                flatBufferBuilder.c(3);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.b(1, a2);
                flatBufferBuilder.b(2, b);
                i();
                return flatBufferBuilder.d();
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 1801334754)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: final_slider_value */
        public final class MatchPageModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel, MatchPage {
            @Nullable
            private String f12307d;

            /* compiled from: final_slider_value */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(MatchPageModel.class, new Deserializer());
                }

                public Object m14948a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(MatchPageParser.m15198a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object matchPageModel = new MatchPageModel();
                    ((BaseModel) matchPageModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (matchPageModel instanceof Postprocessable) {
                        return ((Postprocessable) matchPageModel).a();
                    }
                    return matchPageModel;
                }
            }

            /* compiled from: final_slider_value */
            public class Serializer extends JsonSerializer<MatchPageModel> {
                public final void m14949a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    MatchPageModel matchPageModel = (MatchPageModel) obj;
                    if (matchPageModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(matchPageModel.m14950a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        matchPageModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    MatchPageParser.m15199a(matchPageModel.w_(), matchPageModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(MatchPageModel.class, new Serializer());
                }
            }

            public MatchPageModel() {
                super(1);
            }

            public final void m14953a(String str, ConsistencyTuple consistencyTuple) {
                consistencyTuple.a();
            }

            public final void m14954a(String str, Object obj, boolean z) {
            }

            @Nullable
            public final String mo806b() {
                this.f12307d = super.a(this.f12307d, 0);
                return this.f12307d;
            }

            @Nullable
            public final String m14952a() {
                return mo806b();
            }

            public final int jK_() {
                return 2479791;
            }

            public final GraphQLVisitableModel m14951a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m14950a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(mo806b());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, b);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: final_slider_value */
        public class Serializer extends JsonSerializer<GametimeFanFavoriteMatchFragmentModel> {
            public final void m14956a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                GametimeFanFavoriteMatchFragmentModel gametimeFanFavoriteMatchFragmentModel = (GametimeFanFavoriteMatchFragmentModel) obj;
                if (gametimeFanFavoriteMatchFragmentModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(gametimeFanFavoriteMatchFragmentModel.m14965a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    gametimeFanFavoriteMatchFragmentModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                GametimeFanFavoriteMatchFragmentParser.m15201a(gametimeFanFavoriteMatchFragmentModel.w_(), gametimeFanFavoriteMatchFragmentModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(GametimeFanFavoriteMatchFragmentModel.class, new Serializer());
            }
        }

        @Nullable
        public final /* synthetic */ AwayTeamObject mo808c() {
            return m14960j();
        }

        @Nullable
        public final /* synthetic */ MatchPage eW_() {
            return m14963m();
        }

        @Nullable
        public final /* synthetic */ HomeTeamObject mo813g() {
            return m14961k();
        }

        public GametimeFanFavoriteMatchFragmentModel() {
            super(9);
        }

        public final void m14969a(String str, ConsistencyTuple consistencyTuple) {
            if ("away_team_fan_count".equals(str)) {
                consistencyTuple.a = Integer.valueOf(mo807b());
                consistencyTuple.b = u_();
                consistencyTuple.c = 0;
            } else if ("home_team_fan_count".equals(str)) {
                consistencyTuple.a = Integer.valueOf(eU_());
                consistencyTuple.b = u_();
                consistencyTuple.c = 3;
            } else if ("viewer_can_vote_fan_favorite".equals(str)) {
                consistencyTuple.a = Boolean.valueOf(m14964n());
                consistencyTuple.b = u_();
                consistencyTuple.c = 8;
            } else {
                consistencyTuple.a();
            }
        }

        public final void m14970a(String str, Object obj, boolean z) {
            if ("away_team_fan_count".equals(str)) {
                m14957a(((Integer) obj).intValue());
            } else if ("home_team_fan_count".equals(str)) {
                m14959b(((Integer) obj).intValue());
            } else if ("viewer_can_vote_fan_favorite".equals(str)) {
                m14958a(((Boolean) obj).booleanValue());
            }
        }

        public final int mo807b() {
            a(0, 0);
            return this.f12308d;
        }

        private void m14957a(int i) {
            this.f12308d = i;
            if (this.b != null && this.b.d) {
                this.b.b(this.c, 0, i);
            }
        }

        @Nullable
        private AwayTeamObjectModel m14960j() {
            this.f12309e = (AwayTeamObjectModel) super.a(this.f12309e, 1, AwayTeamObjectModel.class);
            return this.f12309e;
        }

        @Nullable
        public final String mo809d() {
            this.f12310f = super.a(this.f12310f, 2);
            return this.f12310f;
        }

        public final int eU_() {
            a(0, 3);
            return this.f12311g;
        }

        private void m14959b(int i) {
            this.f12311g = i;
            if (this.b != null && this.b.d) {
                this.b.b(this.c, 3, i);
            }
        }

        @Nullable
        private HomeTeamObjectModel m14961k() {
            this.f12312h = (HomeTeamObjectModel) super.a(this.f12312h, 4, HomeTeamObjectModel.class);
            return this.f12312h;
        }

        @Nullable
        public final String eV_() {
            this.f12313i = super.a(this.f12313i, 5);
            return this.f12313i;
        }

        @Nullable
        private String m14962l() {
            this.f12314j = super.a(this.f12314j, 6);
            return this.f12314j;
        }

        @Nullable
        private MatchPageModel m14963m() {
            this.f12315k = (MatchPageModel) super.a(this.f12315k, 7, MatchPageModel.class);
            return this.f12315k;
        }

        private boolean m14964n() {
            a(1, 0);
            return this.f12316l;
        }

        private void m14958a(boolean z) {
            this.f12316l = z;
            if (this.b != null && this.b.d) {
                this.b.a(this.c, 8, z);
            }
        }

        @Nullable
        public final String m14967a() {
            return m14962l();
        }

        public final int jK_() {
            return 827365670;
        }

        public final GraphQLVisitableModel m14966a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m14960j() != null) {
                AwayTeamObjectModel awayTeamObjectModel = (AwayTeamObjectModel) graphQLModelMutatingVisitor.b(m14960j());
                if (m14960j() != awayTeamObjectModel) {
                    graphQLVisitableModel = (GametimeFanFavoriteMatchFragmentModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f12309e = awayTeamObjectModel;
                }
            }
            if (m14961k() != null) {
                HomeTeamObjectModel homeTeamObjectModel = (HomeTeamObjectModel) graphQLModelMutatingVisitor.b(m14961k());
                if (m14961k() != homeTeamObjectModel) {
                    graphQLVisitableModel = (GametimeFanFavoriteMatchFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f12312h = homeTeamObjectModel;
                }
            }
            if (m14963m() != null) {
                MatchPageModel matchPageModel = (MatchPageModel) graphQLModelMutatingVisitor.b(m14963m());
                if (m14963m() != matchPageModel) {
                    graphQLVisitableModel = (GametimeFanFavoriteMatchFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f12315k = matchPageModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m14965a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m14960j());
            int b = flatBufferBuilder.b(mo809d());
            int a2 = ModelHelper.a(flatBufferBuilder, m14961k());
            int b2 = flatBufferBuilder.b(eV_());
            int b3 = flatBufferBuilder.b(m14962l());
            int a3 = ModelHelper.a(flatBufferBuilder, m14963m());
            flatBufferBuilder.c(9);
            flatBufferBuilder.a(0, this.f12308d, 0);
            flatBufferBuilder.b(1, a);
            flatBufferBuilder.b(2, b);
            flatBufferBuilder.a(3, this.f12311g, 0);
            flatBufferBuilder.b(4, a2);
            flatBufferBuilder.b(5, b2);
            flatBufferBuilder.b(6, b3);
            flatBufferBuilder.b(7, a3);
            flatBufferBuilder.a(8, this.f12316l);
            i();
            return flatBufferBuilder.d();
        }

        public final void m14968a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
            super.a(mutableFlatBuffer, i, obj);
            this.f12308d = mutableFlatBuffer.a(i, 0, 0);
            this.f12311g = mutableFlatBuffer.a(i, 3, 0);
            this.f12316l = mutableFlatBuffer.a(i, 8);
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 1550632258)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: final_slider_value */
    public final class ReactionPageContextRowsPlaceholderComponentFragmentModel extends BaseModel implements GraphQLVisitableModel, ReactionPageContextRowsPlaceholderComponentFragment {
        @Nullable
        private PageModel f12328d;

        /* compiled from: final_slider_value */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(ReactionPageContextRowsPlaceholderComponentFragmentModel.class, new Deserializer());
            }

            public Object m14975a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = ReactionPageContextRowsPlaceholderComponentFragmentParser.m15206a(jsonParser);
                Object reactionPageContextRowsPlaceholderComponentFragmentModel = new ReactionPageContextRowsPlaceholderComponentFragmentModel();
                ((BaseModel) reactionPageContextRowsPlaceholderComponentFragmentModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (reactionPageContextRowsPlaceholderComponentFragmentModel instanceof Postprocessable) {
                    return ((Postprocessable) reactionPageContextRowsPlaceholderComponentFragmentModel).a();
                }
                return reactionPageContextRowsPlaceholderComponentFragmentModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -134978292)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: final_slider_value */
        public final class PageModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel, Page {
            @Nullable
            private ContextItemsConnectionWithPageInfoFragmentModel f12321d;
            @Nullable
            private String f12322e;
            @Nullable
            private DefaultLocationFieldsModel f12323f;
            @Nullable
            private String f12324g;
            @Nullable
            private OverallStarRatingModel f12325h;
            @Nullable
            private DefaultImageFieldsModel f12326i;
            @Nullable
            private List<String> f12327j;

            /* compiled from: final_slider_value */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(PageModel.class, new Deserializer());
                }

                public Object m14976a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(PageParser.m15204a(jsonParser, flatBufferBuilder));
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

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = -1026989130)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: final_slider_value */
            public final class OverallStarRatingModel extends BaseModel implements GraphQLVisitableModel {
                private int f12319d;
                private double f12320e;

                /* compiled from: final_slider_value */
                public final class Builder {
                    public int f12317a;
                    public double f12318b;
                }

                /* compiled from: final_slider_value */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(OverallStarRatingModel.class, new Deserializer());
                    }

                    public Object m14977a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(OverallStarRatingParser.m15202a(jsonParser, flatBufferBuilder));
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

                /* compiled from: final_slider_value */
                public class Serializer extends JsonSerializer<OverallStarRatingModel> {
                    public final void m14978a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        OverallStarRatingModel overallStarRatingModel = (OverallStarRatingModel) obj;
                        if (overallStarRatingModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(overallStarRatingModel.m14981a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            overallStarRatingModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        OverallStarRatingParser.m15203a(overallStarRatingModel.w_(), overallStarRatingModel.u_(), jsonGenerator);
                    }

                    static {
                        FbSerializerProvider.a(OverallStarRatingModel.class, new Serializer());
                    }
                }

                public OverallStarRatingModel() {
                    super(2);
                }

                public OverallStarRatingModel(MutableFlatBuffer mutableFlatBuffer) {
                    super(2);
                    a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }

                public final int m14980a() {
                    a(0, 0);
                    return this.f12319d;
                }

                public final double m14984b() {
                    a(0, 1);
                    return this.f12320e;
                }

                public static OverallStarRatingModel m14979a(OverallStarRatingModel overallStarRatingModel) {
                    if (overallStarRatingModel == null) {
                        return null;
                    }
                    if (overallStarRatingModel instanceof OverallStarRatingModel) {
                        return overallStarRatingModel;
                    }
                    Builder builder = new Builder();
                    builder.f12317a = overallStarRatingModel.m14980a();
                    builder.f12318b = overallStarRatingModel.m14984b();
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.c(2);
                    flatBufferBuilder.a(0, builder.f12317a, 0);
                    flatBufferBuilder.a(1, builder.f12318b, 0.0d);
                    flatBufferBuilder.d(flatBufferBuilder.d());
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    return new OverallStarRatingModel(new MutableFlatBuffer(wrap, null, null, true, null));
                }

                public final int jK_() {
                    return -1854235203;
                }

                public final GraphQLVisitableModel m14982a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    h();
                    i();
                    return this;
                }

                public final int m14981a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    flatBufferBuilder.c(2);
                    flatBufferBuilder.a(0, this.f12319d, 0);
                    flatBufferBuilder.a(1, this.f12320e, 0.0d);
                    i();
                    return flatBufferBuilder.d();
                }

                public final void m14983a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                    super.a(mutableFlatBuffer, i, obj);
                    this.f12319d = mutableFlatBuffer.a(i, 0, 0);
                    this.f12320e = mutableFlatBuffer.a(i, 1, 0.0d);
                }
            }

            /* compiled from: final_slider_value */
            public class Serializer extends JsonSerializer<PageModel> {
                public final void m14985a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    PageModel pageModel = (PageModel) obj;
                    if (pageModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(pageModel.m14993a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        pageModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    PageParser.m15205a(pageModel.w_(), pageModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(PageModel.class, new Serializer());
                }
            }

            public PageModel() {
                super(7);
            }

            public final void m14996a(String str, ConsistencyTuple consistencyTuple) {
                consistencyTuple.a();
            }

            public final void m14997a(String str, Object obj, boolean z) {
            }

            @Nullable
            private ContextItemsConnectionWithPageInfoFragmentModel m14986j() {
                this.f12321d = (ContextItemsConnectionWithPageInfoFragmentModel) super.a(this.f12321d, 0, ContextItemsConnectionWithPageInfoFragmentModel.class);
                return this.f12321d;
            }

            @Nullable
            private String m14987k() {
                this.f12322e = super.a(this.f12322e, 1);
                return this.f12322e;
            }

            @Nullable
            private DefaultLocationFieldsModel m14988l() {
                this.f12323f = (DefaultLocationFieldsModel) super.a(this.f12323f, 2, DefaultLocationFieldsModel.class);
                return this.f12323f;
            }

            @Nullable
            private String m14989m() {
                this.f12324g = super.a(this.f12324g, 3);
                return this.f12324g;
            }

            @Nullable
            private OverallStarRatingModel m14990n() {
                this.f12325h = (OverallStarRatingModel) super.a(this.f12325h, 4, OverallStarRatingModel.class);
                return this.f12325h;
            }

            @Nullable
            private DefaultImageFieldsModel m14991o() {
                this.f12326i = (DefaultImageFieldsModel) super.a(this.f12326i, 5, DefaultImageFieldsModel.class);
                return this.f12326i;
            }

            @Nonnull
            private ImmutableList<String> m14992p() {
                this.f12327j = super.a(this.f12327j, 6);
                return (ImmutableList) this.f12327j;
            }

            @Nullable
            public final String m14995a() {
                return m14987k();
            }

            public final int jK_() {
                return 2479791;
            }

            public final GraphQLVisitableModel m14994a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m14986j() != null) {
                    ContextItemsConnectionWithPageInfoFragmentModel contextItemsConnectionWithPageInfoFragmentModel = (ContextItemsConnectionWithPageInfoFragmentModel) graphQLModelMutatingVisitor.b(m14986j());
                    if (m14986j() != contextItemsConnectionWithPageInfoFragmentModel) {
                        graphQLVisitableModel = (PageModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f12321d = contextItemsConnectionWithPageInfoFragmentModel;
                    }
                }
                if (m14988l() != null) {
                    DefaultLocationFieldsModel defaultLocationFieldsModel = (DefaultLocationFieldsModel) graphQLModelMutatingVisitor.b(m14988l());
                    if (m14988l() != defaultLocationFieldsModel) {
                        graphQLVisitableModel = (PageModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f12323f = defaultLocationFieldsModel;
                    }
                }
                if (m14990n() != null) {
                    OverallStarRatingModel overallStarRatingModel = (OverallStarRatingModel) graphQLModelMutatingVisitor.b(m14990n());
                    if (m14990n() != overallStarRatingModel) {
                        graphQLVisitableModel = (PageModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f12325h = overallStarRatingModel;
                    }
                }
                if (m14991o() != null) {
                    DefaultImageFieldsModel defaultImageFieldsModel = (DefaultImageFieldsModel) graphQLModelMutatingVisitor.b(m14991o());
                    if (m14991o() != defaultImageFieldsModel) {
                        graphQLVisitableModel = (PageModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f12326i = defaultImageFieldsModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m14993a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m14986j());
                int b = flatBufferBuilder.b(m14987k());
                int a2 = ModelHelper.a(flatBufferBuilder, m14988l());
                int b2 = flatBufferBuilder.b(m14989m());
                int a3 = ModelHelper.a(flatBufferBuilder, m14990n());
                int a4 = ModelHelper.a(flatBufferBuilder, m14991o());
                int c = flatBufferBuilder.c(m14992p());
                flatBufferBuilder.c(7);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.b(1, b);
                flatBufferBuilder.b(2, a2);
                flatBufferBuilder.b(3, b2);
                flatBufferBuilder.b(4, a3);
                flatBufferBuilder.b(5, a4);
                flatBufferBuilder.b(6, c);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: final_slider_value */
        public class Serializer extends JsonSerializer<ReactionPageContextRowsPlaceholderComponentFragmentModel> {
            public final void m14998a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                ReactionPageContextRowsPlaceholderComponentFragmentModel reactionPageContextRowsPlaceholderComponentFragmentModel = (ReactionPageContextRowsPlaceholderComponentFragmentModel) obj;
                if (reactionPageContextRowsPlaceholderComponentFragmentModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(reactionPageContextRowsPlaceholderComponentFragmentModel.m15000a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    reactionPageContextRowsPlaceholderComponentFragmentModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = reactionPageContextRowsPlaceholderComponentFragmentModel.w_();
                int u_ = reactionPageContextRowsPlaceholderComponentFragmentModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("page");
                    PageParser.m15205a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(ReactionPageContextRowsPlaceholderComponentFragmentModel.class, new Serializer());
            }
        }

        public ReactionPageContextRowsPlaceholderComponentFragmentModel() {
            super(1);
        }

        @Nullable
        private PageModel m14999a() {
            this.f12328d = (PageModel) super.a(this.f12328d, 0, PageModel.class);
            return this.f12328d;
        }

        public final int jK_() {
            return 458921338;
        }

        public final GraphQLVisitableModel m15001a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m14999a() != null) {
                PageModel pageModel = (PageModel) graphQLModelMutatingVisitor.b(m14999a());
                if (m14999a() != pageModel) {
                    graphQLVisitableModel = (ReactionPageContextRowsPlaceholderComponentFragmentModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f12328d = pageModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m15000a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m14999a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -1650235048)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: final_slider_value */
    public final class ReactionReviewUnitComponentFragmentModel extends BaseModel implements GraphQLVisitableModel, ReactionReviewUnitComponentFragment {
        @Nullable
        private SpotlightStoryPreviewModel f12339d;

        /* compiled from: final_slider_value */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(ReactionReviewUnitComponentFragmentModel.class, new Deserializer());
            }

            public Object m15002a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = ReactionReviewUnitComponentFragmentParser.m15211a(jsonParser);
                Object reactionReviewUnitComponentFragmentModel = new ReactionReviewUnitComponentFragmentModel();
                ((BaseModel) reactionReviewUnitComponentFragmentModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (reactionReviewUnitComponentFragmentModel instanceof Postprocessable) {
                    return ((Postprocessable) reactionReviewUnitComponentFragmentModel).a();
                }
                return reactionReviewUnitComponentFragmentModel;
            }
        }

        /* compiled from: final_slider_value */
        public class Serializer extends JsonSerializer<ReactionReviewUnitComponentFragmentModel> {
            public final void m15003a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                ReactionReviewUnitComponentFragmentModel reactionReviewUnitComponentFragmentModel = (ReactionReviewUnitComponentFragmentModel) obj;
                if (reactionReviewUnitComponentFragmentModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(reactionReviewUnitComponentFragmentModel.m15025a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    reactionReviewUnitComponentFragmentModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = reactionReviewUnitComponentFragmentModel.w_();
                int u_ = reactionReviewUnitComponentFragmentModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("spotlight_story_preview");
                    SpotlightStoryPreviewParser.m15210a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(ReactionReviewUnitComponentFragmentModel.class, new Serializer());
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 799919187)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: final_slider_value */
        public final class SpotlightStoryPreviewModel extends BaseModel implements GraphQLVisitableModel {
            private int f12336d;
            @Nullable
            private FormattedPreviewModel f12337e;
            @Nullable
            private ReactionStoryAttachmentStoryFragmentModel f12338f;

            /* compiled from: final_slider_value */
            public final class Builder {
                public int f12329a;
                @Nullable
                public FormattedPreviewModel f12330b;
                @Nullable
                public ReactionStoryAttachmentStoryFragmentModel f12331c;
            }

            /* compiled from: final_slider_value */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(SpotlightStoryPreviewModel.class, new Deserializer());
                }

                public Object m15004a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(SpotlightStoryPreviewParser.m15209a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object spotlightStoryPreviewModel = new SpotlightStoryPreviewModel();
                    ((BaseModel) spotlightStoryPreviewModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (spotlightStoryPreviewModel instanceof Postprocessable) {
                        return ((Postprocessable) spotlightStoryPreviewModel).a();
                    }
                    return spotlightStoryPreviewModel;
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = -656739284)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: final_slider_value */
            public final class FormattedPreviewModel extends BaseModel implements GraphQLVisitableModel {
                @Nullable
                private DefaultTextWithEntitiesFieldsModel f12334d;
                private boolean f12335e;

                /* compiled from: final_slider_value */
                public final class Builder {
                    @Nullable
                    public DefaultTextWithEntitiesFieldsModel f12332a;
                    public boolean f12333b;
                }

                /* compiled from: final_slider_value */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(FormattedPreviewModel.class, new Deserializer());
                    }

                    public Object m15005a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(FormattedPreviewParser.m15207a(jsonParser, flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                        Object formattedPreviewModel = new FormattedPreviewModel();
                        ((BaseModel) formattedPreviewModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                        if (formattedPreviewModel instanceof Postprocessable) {
                            return ((Postprocessable) formattedPreviewModel).a();
                        }
                        return formattedPreviewModel;
                    }
                }

                /* compiled from: final_slider_value */
                public class Serializer extends JsonSerializer<FormattedPreviewModel> {
                    public final void m15006a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        FormattedPreviewModel formattedPreviewModel = (FormattedPreviewModel) obj;
                        if (formattedPreviewModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(formattedPreviewModel.m15009a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            formattedPreviewModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        FormattedPreviewParser.m15208a(formattedPreviewModel.w_(), formattedPreviewModel.u_(), jsonGenerator, serializerProvider);
                    }

                    static {
                        FbSerializerProvider.a(FormattedPreviewModel.class, new Serializer());
                    }
                }

                @Nullable
                public final /* synthetic */ DefaultTextWithEntitiesFields m15010a() {
                    return m15008j();
                }

                public FormattedPreviewModel() {
                    super(2);
                }

                public FormattedPreviewModel(MutableFlatBuffer mutableFlatBuffer) {
                    super(2);
                    a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }

                @Nullable
                private DefaultTextWithEntitiesFieldsModel m15008j() {
                    this.f12334d = (DefaultTextWithEntitiesFieldsModel) super.a(this.f12334d, 0, DefaultTextWithEntitiesFieldsModel.class);
                    return this.f12334d;
                }

                public final boolean m15013b() {
                    a(0, 1);
                    return this.f12335e;
                }

                public static FormattedPreviewModel m15007a(FormattedPreviewModel formattedPreviewModel) {
                    if (formattedPreviewModel == null) {
                        return null;
                    }
                    if (formattedPreviewModel instanceof FormattedPreviewModel) {
                        return formattedPreviewModel;
                    }
                    Builder builder = new Builder();
                    builder.f12332a = DefaultTextWithEntitiesFieldsModel.a(formattedPreviewModel.m15010a());
                    builder.f12333b = formattedPreviewModel.m15013b();
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    int a = ModelHelper.a(flatBufferBuilder, builder.f12332a);
                    flatBufferBuilder.c(2);
                    flatBufferBuilder.b(0, a);
                    flatBufferBuilder.a(1, builder.f12333b);
                    flatBufferBuilder.d(flatBufferBuilder.d());
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    return new FormattedPreviewModel(new MutableFlatBuffer(wrap, null, null, true, null));
                }

                public final int jK_() {
                    return 1228610989;
                }

                public final GraphQLVisitableModel m15011a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    GraphQLVisitableModel graphQLVisitableModel = null;
                    h();
                    if (m15008j() != null) {
                        DefaultTextWithEntitiesFieldsModel defaultTextWithEntitiesFieldsModel = (DefaultTextWithEntitiesFieldsModel) graphQLModelMutatingVisitor.b(m15008j());
                        if (m15008j() != defaultTextWithEntitiesFieldsModel) {
                            graphQLVisitableModel = (FormattedPreviewModel) ModelHelper.a(null, this);
                            graphQLVisitableModel.f12334d = defaultTextWithEntitiesFieldsModel;
                        }
                    }
                    i();
                    return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                }

                public final int m15009a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int a = ModelHelper.a(flatBufferBuilder, m15008j());
                    flatBufferBuilder.c(2);
                    flatBufferBuilder.b(0, a);
                    flatBufferBuilder.a(1, this.f12335e);
                    i();
                    return flatBufferBuilder.d();
                }

                public final void m15012a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                    super.a(mutableFlatBuffer, i, obj);
                    this.f12335e = mutableFlatBuffer.a(i, 1);
                }
            }

            /* compiled from: final_slider_value */
            public class Serializer extends JsonSerializer<SpotlightStoryPreviewModel> {
                public final void m15014a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    SpotlightStoryPreviewModel spotlightStoryPreviewModel = (SpotlightStoryPreviewModel) obj;
                    if (spotlightStoryPreviewModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(spotlightStoryPreviewModel.m15019a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        spotlightStoryPreviewModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    SpotlightStoryPreviewParser.m15210a(spotlightStoryPreviewModel.w_(), spotlightStoryPreviewModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(SpotlightStoryPreviewModel.class, new Serializer());
                }
            }

            @Nullable
            public final /* synthetic */ FormattedPreviewModel m15022b() {
                return m15016j();
            }

            @Nullable
            public final /* synthetic */ ReactionStoryAttachmentStoryFragmentModel m15023c() {
                return m15017k();
            }

            public SpotlightStoryPreviewModel() {
                super(3);
            }

            public SpotlightStoryPreviewModel(MutableFlatBuffer mutableFlatBuffer) {
                super(3);
                a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
            }

            public final int m15018a() {
                a(0, 0);
                return this.f12336d;
            }

            @Nullable
            private FormattedPreviewModel m15016j() {
                this.f12337e = (FormattedPreviewModel) super.a(this.f12337e, 1, FormattedPreviewModel.class);
                return this.f12337e;
            }

            @Nullable
            private ReactionStoryAttachmentStoryFragmentModel m15017k() {
                this.f12338f = (ReactionStoryAttachmentStoryFragmentModel) super.a(this.f12338f, 2, ReactionStoryAttachmentStoryFragmentModel.class);
                return this.f12338f;
            }

            public static SpotlightStoryPreviewModel m15015a(SpotlightStoryPreviewModel spotlightStoryPreviewModel) {
                if (spotlightStoryPreviewModel == null) {
                    return null;
                }
                if (spotlightStoryPreviewModel instanceof SpotlightStoryPreviewModel) {
                    return spotlightStoryPreviewModel;
                }
                Builder builder = new Builder();
                builder.f12329a = spotlightStoryPreviewModel.m15018a();
                builder.f12330b = FormattedPreviewModel.m15007a(spotlightStoryPreviewModel.m15022b());
                builder.f12331c = ReactionStoryAttachmentStoryFragmentModel.m14644a(spotlightStoryPreviewModel.m15023c());
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                int a = ModelHelper.a(flatBufferBuilder, builder.f12330b);
                int a2 = ModelHelper.a(flatBufferBuilder, builder.f12331c);
                flatBufferBuilder.c(3);
                flatBufferBuilder.a(0, builder.f12329a, 0);
                flatBufferBuilder.b(1, a);
                flatBufferBuilder.b(2, a2);
                flatBufferBuilder.d(flatBufferBuilder.d());
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                return new SpotlightStoryPreviewModel(new MutableFlatBuffer(wrap, null, null, true, null));
            }

            public final int jK_() {
                return -1877989276;
            }

            public final GraphQLVisitableModel m15020a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m15016j() != null) {
                    FormattedPreviewModel formattedPreviewModel = (FormattedPreviewModel) graphQLModelMutatingVisitor.b(m15016j());
                    if (m15016j() != formattedPreviewModel) {
                        graphQLVisitableModel = (SpotlightStoryPreviewModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f12337e = formattedPreviewModel;
                    }
                }
                if (m15017k() != null) {
                    ReactionStoryAttachmentStoryFragmentModel reactionStoryAttachmentStoryFragmentModel = (ReactionStoryAttachmentStoryFragmentModel) graphQLModelMutatingVisitor.b(m15017k());
                    if (m15017k() != reactionStoryAttachmentStoryFragmentModel) {
                        graphQLVisitableModel = (SpotlightStoryPreviewModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f12338f = reactionStoryAttachmentStoryFragmentModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m15019a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m15016j());
                int a2 = ModelHelper.a(flatBufferBuilder, m15017k());
                flatBufferBuilder.c(3);
                flatBufferBuilder.a(0, this.f12336d, 0);
                flatBufferBuilder.b(1, a);
                flatBufferBuilder.b(2, a2);
                i();
                return flatBufferBuilder.d();
            }

            public final void m15021a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                super.a(mutableFlatBuffer, i, obj);
                this.f12336d = mutableFlatBuffer.a(i, 0, 0);
            }
        }

        public ReactionReviewUnitComponentFragmentModel() {
            super(1);
        }

        @Nullable
        private SpotlightStoryPreviewModel m15024a() {
            this.f12339d = (SpotlightStoryPreviewModel) super.a(this.f12339d, 0, SpotlightStoryPreviewModel.class);
            return this.f12339d;
        }

        public final int jK_() {
            return -2084878322;
        }

        public final GraphQLVisitableModel m15026a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m15024a() != null) {
                SpotlightStoryPreviewModel spotlightStoryPreviewModel = (SpotlightStoryPreviewModel) graphQLModelMutatingVisitor.b(m15024a());
                if (m15024a() != spotlightStoryPreviewModel) {
                    graphQLVisitableModel = (ReactionReviewUnitComponentFragmentModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f12339d = spotlightStoryPreviewModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m15025a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m15024a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 1673163249)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: final_slider_value */
    public final class ReactionUnitFriendRequestListComponentFragmentModel extends BaseModel implements GraphQLVisitableModel, ReactionUnitFriendRequestListComponentFragment {
        @Nullable
        private List<FriendingPossibilitiesModel> f12364d;

        /* compiled from: final_slider_value */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(ReactionUnitFriendRequestListComponentFragmentModel.class, new Deserializer());
            }

            public Object m15027a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = ReactionUnitFriendRequestListComponentFragmentParser.m15225a(jsonParser);
                Object reactionUnitFriendRequestListComponentFragmentModel = new ReactionUnitFriendRequestListComponentFragmentModel();
                ((BaseModel) reactionUnitFriendRequestListComponentFragmentModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (reactionUnitFriendRequestListComponentFragmentModel instanceof Postprocessable) {
                    return ((Postprocessable) reactionUnitFriendRequestListComponentFragmentModel).a();
                }
                return reactionUnitFriendRequestListComponentFragmentModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -2100869040)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: final_slider_value */
        public final class FriendingPossibilitiesModel extends BaseModel implements GraphQLVisitableModel {
            private boolean f12360d;
            private boolean f12361e;
            @Nullable
            private RequesterModel f12362f;
            @Nullable
            private List<SuggestersModel> f12363g;

            /* compiled from: final_slider_value */
            public final class Builder {
                public boolean f12340a;
                public boolean f12341b;
                @Nullable
                public RequesterModel f12342c;
                @Nullable
                public ImmutableList<SuggestersModel> f12343d;
            }

            /* compiled from: final_slider_value */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(FriendingPossibilitiesModel.class, new Deserializer());
                }

                public Object m15028a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(FriendingPossibilitiesParser.m15223b(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object friendingPossibilitiesModel = new FriendingPossibilitiesModel();
                    ((BaseModel) friendingPossibilitiesModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (friendingPossibilitiesModel instanceof Postprocessable) {
                        return ((Postprocessable) friendingPossibilitiesModel).a();
                    }
                    return friendingPossibilitiesModel;
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = 939329395)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: final_slider_value */
            public final class RequesterModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
                @Nullable
                private GraphQLFriendshipStatus f12353d;
                @Nullable
                private String f12354e;
                @Nullable
                private String f12355f;
                @Nullable
                private ProfilePictureModel f12356g;
                @Nullable
                private SocialContextModel f12357h;

                /* compiled from: final_slider_value */
                public final class Builder {
                    @Nullable
                    public GraphQLFriendshipStatus f12344a;
                    @Nullable
                    public String f12345b;
                    @Nullable
                    public String f12346c;
                    @Nullable
                    public ProfilePictureModel f12347d;
                    @Nullable
                    public SocialContextModel f12348e;
                }

                /* compiled from: final_slider_value */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(RequesterModel.class, new Deserializer());
                    }

                    public Object m15029a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(RequesterParser.m15216a(jsonParser, flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                        Object requesterModel = new RequesterModel();
                        ((BaseModel) requesterModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                        if (requesterModel instanceof Postprocessable) {
                            return ((Postprocessable) requesterModel).a();
                        }
                        return requesterModel;
                    }
                }

                @JsonDeserialize(using = Deserializer.class)
                @ModelWithFlatBufferFormatHash(a = 842551240)
                @JsonSerialize(using = Serializer.class)
                @FragmentModelWithoutBridge
                /* compiled from: final_slider_value */
                public final class ProfilePictureModel extends BaseModel implements GraphQLVisitableModel {
                    @Nullable
                    private String f12350d;

                    /* compiled from: final_slider_value */
                    public final class Builder {
                        @Nullable
                        public String f12349a;
                    }

                    /* compiled from: final_slider_value */
                    public class Deserializer extends FbJsonDeserializer {
                        static {
                            GlobalAutoGenDeserializerCache.a(ProfilePictureModel.class, new Deserializer());
                        }

                        public Object m15030a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(RequesterParser.ProfilePictureParser.m15212a(jsonParser, flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            mutableFlatBuffer.a(4, Boolean.valueOf(true));
                            MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                            Object profilePictureModel = new ProfilePictureModel();
                            ((BaseModel) profilePictureModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                            if (profilePictureModel instanceof Postprocessable) {
                                return ((Postprocessable) profilePictureModel).a();
                            }
                            return profilePictureModel;
                        }
                    }

                    /* compiled from: final_slider_value */
                    public class Serializer extends JsonSerializer<ProfilePictureModel> {
                        public final void m15031a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                            ProfilePictureModel profilePictureModel = (ProfilePictureModel) obj;
                            if (profilePictureModel.w_() == null) {
                                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                flatBufferBuilder.d(profilePictureModel.m15033a(flatBufferBuilder));
                                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                wrap.position(0);
                                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                profilePictureModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                            }
                            RequesterParser.ProfilePictureParser.m15213a(profilePictureModel.w_(), profilePictureModel.u_(), jsonGenerator);
                        }

                        static {
                            FbSerializerProvider.a(ProfilePictureModel.class, new Serializer());
                        }
                    }

                    public ProfilePictureModel() {
                        super(1);
                    }

                    public ProfilePictureModel(MutableFlatBuffer mutableFlatBuffer) {
                        super(1);
                        a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }

                    @Nullable
                    public final String m15035a() {
                        this.f12350d = super.a(this.f12350d, 0);
                        return this.f12350d;
                    }

                    public static ProfilePictureModel m15032a(ProfilePictureModel profilePictureModel) {
                        if (profilePictureModel == null) {
                            return null;
                        }
                        if (profilePictureModel instanceof ProfilePictureModel) {
                            return profilePictureModel;
                        }
                        Builder builder = new Builder();
                        builder.f12349a = profilePictureModel.m15035a();
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        int b = flatBufferBuilder.b(builder.f12349a);
                        flatBufferBuilder.c(1);
                        flatBufferBuilder.b(0, b);
                        flatBufferBuilder.d(flatBufferBuilder.d());
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        return new ProfilePictureModel(new MutableFlatBuffer(wrap, null, null, true, null));
                    }

                    public final int jK_() {
                        return 70760763;
                    }

                    public final GraphQLVisitableModel m15034a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                        h();
                        i();
                        return this;
                    }

                    public final int m15033a(FlatBufferBuilder flatBufferBuilder) {
                        h();
                        int b = flatBufferBuilder.b(m15035a());
                        flatBufferBuilder.c(1);
                        flatBufferBuilder.b(0, b);
                        i();
                        return flatBufferBuilder.d();
                    }
                }

                /* compiled from: final_slider_value */
                public class Serializer extends JsonSerializer<RequesterModel> {
                    public final void m15036a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        RequesterModel requesterModel = (RequesterModel) obj;
                        if (requesterModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(requesterModel.m15047a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            requesterModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        RequesterParser.m15217a(requesterModel.w_(), requesterModel.u_(), jsonGenerator, serializerProvider);
                    }

                    static {
                        FbSerializerProvider.a(RequesterModel.class, new Serializer());
                    }
                }

                @JsonDeserialize(using = Deserializer.class)
                @ModelWithFlatBufferFormatHash(a = -1352864475)
                @JsonSerialize(using = Serializer.class)
                @FragmentModelWithoutBridge
                /* compiled from: final_slider_value */
                public final class SocialContextModel extends BaseModel implements GraphQLVisitableModel {
                    @Nullable
                    private String f12352d;

                    /* compiled from: final_slider_value */
                    public final class Builder {
                        @Nullable
                        public String f12351a;
                    }

                    /* compiled from: final_slider_value */
                    public class Deserializer extends FbJsonDeserializer {
                        static {
                            GlobalAutoGenDeserializerCache.a(SocialContextModel.class, new Deserializer());
                        }

                        public Object m15037a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(SocialContextParser.m15214a(jsonParser, flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            mutableFlatBuffer.a(4, Boolean.valueOf(true));
                            MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                            Object socialContextModel = new SocialContextModel();
                            ((BaseModel) socialContextModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                            if (socialContextModel instanceof Postprocessable) {
                                return ((Postprocessable) socialContextModel).a();
                            }
                            return socialContextModel;
                        }
                    }

                    /* compiled from: final_slider_value */
                    public class Serializer extends JsonSerializer<SocialContextModel> {
                        public final void m15038a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                            SocialContextModel socialContextModel = (SocialContextModel) obj;
                            if (socialContextModel.w_() == null) {
                                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                flatBufferBuilder.d(socialContextModel.m15040a(flatBufferBuilder));
                                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                wrap.position(0);
                                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                socialContextModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                            }
                            SocialContextParser.m15215a(socialContextModel.w_(), socialContextModel.u_(), jsonGenerator);
                        }

                        static {
                            FbSerializerProvider.a(SocialContextModel.class, new Serializer());
                        }
                    }

                    public SocialContextModel() {
                        super(1);
                    }

                    public SocialContextModel(MutableFlatBuffer mutableFlatBuffer) {
                        super(1);
                        a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }

                    @Nullable
                    public final String m15042a() {
                        this.f12352d = super.a(this.f12352d, 0);
                        return this.f12352d;
                    }

                    public static SocialContextModel m15039a(SocialContextModel socialContextModel) {
                        if (socialContextModel == null) {
                            return null;
                        }
                        if (socialContextModel instanceof SocialContextModel) {
                            return socialContextModel;
                        }
                        Builder builder = new Builder();
                        builder.f12351a = socialContextModel.m15042a();
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        int b = flatBufferBuilder.b(builder.f12351a);
                        flatBufferBuilder.c(1);
                        flatBufferBuilder.b(0, b);
                        flatBufferBuilder.d(flatBufferBuilder.d());
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        return new SocialContextModel(new MutableFlatBuffer(wrap, null, null, true, null));
                    }

                    public final int jK_() {
                        return -1919764332;
                    }

                    public final GraphQLVisitableModel m15041a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                        h();
                        i();
                        return this;
                    }

                    public final int m15040a(FlatBufferBuilder flatBufferBuilder) {
                        h();
                        int b = flatBufferBuilder.b(m15042a());
                        flatBufferBuilder.c(1);
                        flatBufferBuilder.b(0, b);
                        i();
                        return flatBufferBuilder.d();
                    }
                }

                @Nullable
                public final /* synthetic */ ProfilePictureModel eX_() {
                    return m15045j();
                }

                @Nullable
                public final /* synthetic */ SocialContextModel m15055g() {
                    return m15046k();
                }

                public RequesterModel() {
                    super(5);
                }

                public RequesterModel(MutableFlatBuffer mutableFlatBuffer) {
                    super(5);
                    a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }

                public final void m15050a(String str, ConsistencyTuple consistencyTuple) {
                    if ("friendship_status".equals(str)) {
                        consistencyTuple.a = m15052b();
                        consistencyTuple.b = u_();
                        consistencyTuple.c = 0;
                        return;
                    }
                    consistencyTuple.a();
                }

                public final void m15051a(String str, Object obj, boolean z) {
                    if ("friendship_status".equals(str)) {
                        m15044a((GraphQLFriendshipStatus) obj);
                    }
                }

                @Nullable
                public final GraphQLFriendshipStatus m15052b() {
                    this.f12353d = (GraphQLFriendshipStatus) super.b(this.f12353d, 0, GraphQLFriendshipStatus.class, GraphQLFriendshipStatus.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
                    return this.f12353d;
                }

                private void m15044a(GraphQLFriendshipStatus graphQLFriendshipStatus) {
                    this.f12353d = graphQLFriendshipStatus;
                    if (this.b != null && this.b.d) {
                        this.b.a(this.c, 0, graphQLFriendshipStatus != null ? graphQLFriendshipStatus.name() : null);
                    }
                }

                @Nullable
                public final String m15053c() {
                    this.f12354e = super.a(this.f12354e, 1);
                    return this.f12354e;
                }

                @Nullable
                public final String m15054d() {
                    this.f12355f = super.a(this.f12355f, 2);
                    return this.f12355f;
                }

                @Nullable
                private ProfilePictureModel m15045j() {
                    this.f12356g = (ProfilePictureModel) super.a(this.f12356g, 3, ProfilePictureModel.class);
                    return this.f12356g;
                }

                @Nullable
                private SocialContextModel m15046k() {
                    this.f12357h = (SocialContextModel) super.a(this.f12357h, 4, SocialContextModel.class);
                    return this.f12357h;
                }

                public static RequesterModel m15043a(RequesterModel requesterModel) {
                    if (requesterModel == null) {
                        return null;
                    }
                    if (requesterModel instanceof RequesterModel) {
                        return requesterModel;
                    }
                    Builder builder = new Builder();
                    builder.f12344a = requesterModel.m15052b();
                    builder.f12345b = requesterModel.m15053c();
                    builder.f12346c = requesterModel.m15054d();
                    builder.f12347d = ProfilePictureModel.m15032a(requesterModel.eX_());
                    builder.f12348e = SocialContextModel.m15039a(requesterModel.m15055g());
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    int a = flatBufferBuilder.a(builder.f12344a);
                    int b = flatBufferBuilder.b(builder.f12345b);
                    int b2 = flatBufferBuilder.b(builder.f12346c);
                    int a2 = ModelHelper.a(flatBufferBuilder, builder.f12347d);
                    int a3 = ModelHelper.a(flatBufferBuilder, builder.f12348e);
                    flatBufferBuilder.c(5);
                    flatBufferBuilder.b(0, a);
                    flatBufferBuilder.b(1, b);
                    flatBufferBuilder.b(2, b2);
                    flatBufferBuilder.b(3, a2);
                    flatBufferBuilder.b(4, a3);
                    flatBufferBuilder.d(flatBufferBuilder.d());
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    return new RequesterModel(new MutableFlatBuffer(wrap, null, null, true, null));
                }

                @Nullable
                public final String m15049a() {
                    return m15053c();
                }

                public final int jK_() {
                    return 2645995;
                }

                public final GraphQLVisitableModel m15048a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    GraphQLVisitableModel graphQLVisitableModel = null;
                    h();
                    if (m15045j() != null) {
                        ProfilePictureModel profilePictureModel = (ProfilePictureModel) graphQLModelMutatingVisitor.b(m15045j());
                        if (m15045j() != profilePictureModel) {
                            graphQLVisitableModel = (RequesterModel) ModelHelper.a(null, this);
                            graphQLVisitableModel.f12356g = profilePictureModel;
                        }
                    }
                    if (m15046k() != null) {
                        SocialContextModel socialContextModel = (SocialContextModel) graphQLModelMutatingVisitor.b(m15046k());
                        if (m15046k() != socialContextModel) {
                            graphQLVisitableModel = (RequesterModel) ModelHelper.a(graphQLVisitableModel, this);
                            graphQLVisitableModel.f12357h = socialContextModel;
                        }
                    }
                    i();
                    return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                }

                public final int m15047a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int a = flatBufferBuilder.a(m15052b());
                    int b = flatBufferBuilder.b(m15053c());
                    int b2 = flatBufferBuilder.b(m15054d());
                    int a2 = ModelHelper.a(flatBufferBuilder, m15045j());
                    int a3 = ModelHelper.a(flatBufferBuilder, m15046k());
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

            /* compiled from: final_slider_value */
            public class Serializer extends JsonSerializer<FriendingPossibilitiesModel> {
                public final void m15056a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    FriendingPossibilitiesModel friendingPossibilitiesModel = (FriendingPossibilitiesModel) obj;
                    if (friendingPossibilitiesModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(friendingPossibilitiesModel.m15067a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        friendingPossibilitiesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    FriendingPossibilitiesParser.m15224b(friendingPossibilitiesModel.w_(), friendingPossibilitiesModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(FriendingPossibilitiesModel.class, new Serializer());
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = 273304230)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: final_slider_value */
            public final class SuggestersModel extends BaseModel implements GraphQLVisitableConsistentModel {
                @Nullable
                private String f12359d;

                /* compiled from: final_slider_value */
                public final class Builder {
                    @Nullable
                    public String f12358a;
                }

                /* compiled from: final_slider_value */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(SuggestersModel.class, new Deserializer());
                    }

                    public Object m15057a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(SuggestersParser.m15220b(jsonParser, flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                        Object suggestersModel = new SuggestersModel();
                        ((BaseModel) suggestersModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                        if (suggestersModel instanceof Postprocessable) {
                            return ((Postprocessable) suggestersModel).a();
                        }
                        return suggestersModel;
                    }
                }

                /* compiled from: final_slider_value */
                public class Serializer extends JsonSerializer<SuggestersModel> {
                    public final void m15058a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        SuggestersModel suggestersModel = (SuggestersModel) obj;
                        if (suggestersModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(suggestersModel.m15060a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            suggestersModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        SuggestersParser.m15219a(suggestersModel.w_(), suggestersModel.u_(), jsonGenerator);
                    }

                    static {
                        FbSerializerProvider.a(SuggestersModel.class, new Serializer());
                    }
                }

                public SuggestersModel() {
                    super(1);
                }

                public SuggestersModel(MutableFlatBuffer mutableFlatBuffer) {
                    super(1);
                    a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }

                public final void m15063a(String str, ConsistencyTuple consistencyTuple) {
                    consistencyTuple.a();
                }

                public final void m15064a(String str, Object obj, boolean z) {
                }

                @Nullable
                public final String m15062a() {
                    this.f12359d = super.a(this.f12359d, 0);
                    return this.f12359d;
                }

                public static SuggestersModel m15059a(SuggestersModel suggestersModel) {
                    if (suggestersModel == null) {
                        return null;
                    }
                    if (suggestersModel instanceof SuggestersModel) {
                        return suggestersModel;
                    }
                    Builder builder = new Builder();
                    builder.f12358a = suggestersModel.m15062a();
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    int b = flatBufferBuilder.b(builder.f12358a);
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.b(0, b);
                    flatBufferBuilder.d(flatBufferBuilder.d());
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    return new SuggestersModel(new MutableFlatBuffer(wrap, null, null, true, null));
                }

                public final int jK_() {
                    return 2645995;
                }

                public final GraphQLVisitableModel m15061a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    h();
                    i();
                    return this;
                }

                public final int m15060a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int b = flatBufferBuilder.b(m15062a());
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.b(0, b);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            @Nullable
            public final /* synthetic */ RequesterModel m15072c() {
                return m15066j();
            }

            public FriendingPossibilitiesModel() {
                super(4);
            }

            public FriendingPossibilitiesModel(MutableFlatBuffer mutableFlatBuffer) {
                super(4);
                a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
            }

            public final boolean m15070a() {
                a(0, 0);
                return this.f12360d;
            }

            public final boolean m15071b() {
                a(0, 1);
                return this.f12361e;
            }

            @Nullable
            private RequesterModel m15066j() {
                this.f12362f = (RequesterModel) super.a(this.f12362f, 2, RequesterModel.class);
                return this.f12362f;
            }

            @Nonnull
            public final ImmutableList<SuggestersModel> m15073d() {
                this.f12363g = super.a(this.f12363g, 3, SuggestersModel.class);
                return (ImmutableList) this.f12363g;
            }

            public static FriendingPossibilitiesModel m15065a(FriendingPossibilitiesModel friendingPossibilitiesModel) {
                if (friendingPossibilitiesModel == null) {
                    return null;
                }
                if (friendingPossibilitiesModel instanceof FriendingPossibilitiesModel) {
                    return friendingPossibilitiesModel;
                }
                Builder builder = new Builder();
                builder.f12340a = friendingPossibilitiesModel.m15070a();
                builder.f12341b = friendingPossibilitiesModel.m15071b();
                builder.f12342c = RequesterModel.m15043a(friendingPossibilitiesModel.m15072c());
                com.google.common.collect.ImmutableList.Builder builder2 = ImmutableList.builder();
                for (int i = 0; i < friendingPossibilitiesModel.m15073d().size(); i++) {
                    builder2.c(SuggestersModel.m15059a((SuggestersModel) friendingPossibilitiesModel.m15073d().get(i)));
                }
                builder.f12343d = builder2.b();
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                int a = ModelHelper.a(flatBufferBuilder, builder.f12342c);
                int a2 = ModelHelper.a(flatBufferBuilder, builder.f12343d);
                flatBufferBuilder.c(4);
                flatBufferBuilder.a(0, builder.f12340a);
                flatBufferBuilder.a(1, builder.f12341b);
                flatBufferBuilder.b(2, a);
                flatBufferBuilder.b(3, a2);
                flatBufferBuilder.d(flatBufferBuilder.d());
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                return new FriendingPossibilitiesModel(new MutableFlatBuffer(wrap, null, null, true, null));
            }

            public final int jK_() {
                return -1532225928;
            }

            public final GraphQLVisitableModel m15068a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m15066j() != null) {
                    RequesterModel requesterModel = (RequesterModel) graphQLModelMutatingVisitor.b(m15066j());
                    if (m15066j() != requesterModel) {
                        graphQLVisitableModel = (FriendingPossibilitiesModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f12362f = requesterModel;
                    }
                }
                if (m15073d() != null) {
                    com.google.common.collect.ImmutableList.Builder a = ModelHelper.a(m15073d(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        FriendingPossibilitiesModel friendingPossibilitiesModel = (FriendingPossibilitiesModel) ModelHelper.a(graphQLVisitableModel, this);
                        friendingPossibilitiesModel.f12363g = a.b();
                        graphQLVisitableModel = friendingPossibilitiesModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m15067a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m15066j());
                int a2 = ModelHelper.a(flatBufferBuilder, m15073d());
                flatBufferBuilder.c(4);
                flatBufferBuilder.a(0, this.f12360d);
                flatBufferBuilder.a(1, this.f12361e);
                flatBufferBuilder.b(2, a);
                flatBufferBuilder.b(3, a2);
                i();
                return flatBufferBuilder.d();
            }

            public final void m15069a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                super.a(mutableFlatBuffer, i, obj);
                this.f12360d = mutableFlatBuffer.a(i, 0);
                this.f12361e = mutableFlatBuffer.a(i, 1);
            }
        }

        /* compiled from: final_slider_value */
        public class Serializer extends JsonSerializer<ReactionUnitFriendRequestListComponentFragmentModel> {
            public final void m15074a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                ReactionUnitFriendRequestListComponentFragmentModel reactionUnitFriendRequestListComponentFragmentModel = (ReactionUnitFriendRequestListComponentFragmentModel) obj;
                if (reactionUnitFriendRequestListComponentFragmentModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(reactionUnitFriendRequestListComponentFragmentModel.m15076a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    reactionUnitFriendRequestListComponentFragmentModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = reactionUnitFriendRequestListComponentFragmentModel.w_();
                int u_ = reactionUnitFriendRequestListComponentFragmentModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("friending_possibilities");
                    FriendingPossibilitiesParser.m15222a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(ReactionUnitFriendRequestListComponentFragmentModel.class, new Serializer());
            }
        }

        public ReactionUnitFriendRequestListComponentFragmentModel() {
            super(1);
        }

        @Nonnull
        private ImmutableList<FriendingPossibilitiesModel> m15075a() {
            this.f12364d = super.a(this.f12364d, 0, FriendingPossibilitiesModel.class);
            return (ImmutableList) this.f12364d;
        }

        public final int jK_() {
            return -432309061;
        }

        public final GraphQLVisitableModel m15077a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m15075a() != null) {
                Builder a = ModelHelper.a(m15075a(), graphQLModelMutatingVisitor);
                if (a != null) {
                    graphQLVisitableModel = (ReactionUnitFriendRequestListComponentFragmentModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f12364d = a.b();
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m15076a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m15075a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -550401191)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: final_slider_value */
    public final class ReactionUnitGametimeFanFavoriteComponentFragmentModel extends BaseModel implements GraphQLVisitableModel, ReactionUnitGametimeFanFavoriteComponentFragment {
        @Nullable
        private AwayVotingPageModel f12369d;
        @Nullable
        private HomeVotingPageModel f12370e;
        @Nullable
        private GametimeFanFavoriteMatchFragmentModel f12371f;
        @Nullable
        private DefaultTextWithEntitiesFieldsModel f12372g;
        private int f12373h;

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 1801334754)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: final_slider_value */
        public final class AwayVotingPageModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
            @Nullable
            private String f12366d;

            /* compiled from: final_slider_value */
            public final class Builder {
                @Nullable
                public String f12365a;
            }

            /* compiled from: final_slider_value */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(AwayVotingPageModel.class, new Deserializer());
                }

                public Object m15078a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(AwayVotingPageParser.m15226a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object awayVotingPageModel = new AwayVotingPageModel();
                    ((BaseModel) awayVotingPageModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (awayVotingPageModel instanceof Postprocessable) {
                        return ((Postprocessable) awayVotingPageModel).a();
                    }
                    return awayVotingPageModel;
                }
            }

            /* compiled from: final_slider_value */
            public class Serializer extends JsonSerializer<AwayVotingPageModel> {
                public final void m15079a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    AwayVotingPageModel awayVotingPageModel = (AwayVotingPageModel) obj;
                    if (awayVotingPageModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(awayVotingPageModel.m15081a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        awayVotingPageModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    AwayVotingPageParser.m15227a(awayVotingPageModel.w_(), awayVotingPageModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(AwayVotingPageModel.class, new Serializer());
                }
            }

            public AwayVotingPageModel() {
                super(1);
            }

            public AwayVotingPageModel(MutableFlatBuffer mutableFlatBuffer) {
                super(1);
                a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
            }

            public final void m15084a(String str, ConsistencyTuple consistencyTuple) {
                consistencyTuple.a();
            }

            public final void m15085a(String str, Object obj, boolean z) {
            }

            @Nullable
            public final String m15086b() {
                this.f12366d = super.a(this.f12366d, 0);
                return this.f12366d;
            }

            public static AwayVotingPageModel m15080a(AwayVotingPageModel awayVotingPageModel) {
                if (awayVotingPageModel == null) {
                    return null;
                }
                if (awayVotingPageModel instanceof AwayVotingPageModel) {
                    return awayVotingPageModel;
                }
                Builder builder = new Builder();
                builder.f12365a = awayVotingPageModel.m15086b();
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                int b = flatBufferBuilder.b(builder.f12365a);
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, b);
                flatBufferBuilder.d(flatBufferBuilder.d());
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                return new AwayVotingPageModel(new MutableFlatBuffer(wrap, null, null, true, null));
            }

            @Nullable
            public final String m15083a() {
                return m15086b();
            }

            public final int jK_() {
                return 2479791;
            }

            public final GraphQLVisitableModel m15082a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m15081a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m15086b());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, b);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: final_slider_value */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(ReactionUnitGametimeFanFavoriteComponentFragmentModel.class, new Deserializer());
            }

            public Object m15087a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(ReactionUnitGametimeFanFavoriteComponentFragmentParser.m15230a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object reactionUnitGametimeFanFavoriteComponentFragmentModel = new ReactionUnitGametimeFanFavoriteComponentFragmentModel();
                ((BaseModel) reactionUnitGametimeFanFavoriteComponentFragmentModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (reactionUnitGametimeFanFavoriteComponentFragmentModel instanceof Postprocessable) {
                    return ((Postprocessable) reactionUnitGametimeFanFavoriteComponentFragmentModel).a();
                }
                return reactionUnitGametimeFanFavoriteComponentFragmentModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 1801334754)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: final_slider_value */
        public final class HomeVotingPageModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
            @Nullable
            private String f12368d;

            /* compiled from: final_slider_value */
            public final class Builder {
                @Nullable
                public String f12367a;
            }

            /* compiled from: final_slider_value */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(HomeVotingPageModel.class, new Deserializer());
                }

                public Object m15088a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(HomeVotingPageParser.m15228a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object homeVotingPageModel = new HomeVotingPageModel();
                    ((BaseModel) homeVotingPageModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (homeVotingPageModel instanceof Postprocessable) {
                        return ((Postprocessable) homeVotingPageModel).a();
                    }
                    return homeVotingPageModel;
                }
            }

            /* compiled from: final_slider_value */
            public class Serializer extends JsonSerializer<HomeVotingPageModel> {
                public final void m15089a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    HomeVotingPageModel homeVotingPageModel = (HomeVotingPageModel) obj;
                    if (homeVotingPageModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(homeVotingPageModel.m15091a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        homeVotingPageModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    HomeVotingPageParser.m15229a(homeVotingPageModel.w_(), homeVotingPageModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(HomeVotingPageModel.class, new Serializer());
                }
            }

            public HomeVotingPageModel() {
                super(1);
            }

            public HomeVotingPageModel(MutableFlatBuffer mutableFlatBuffer) {
                super(1);
                a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
            }

            public final void m15094a(String str, ConsistencyTuple consistencyTuple) {
                consistencyTuple.a();
            }

            public final void m15095a(String str, Object obj, boolean z) {
            }

            @Nullable
            public final String m15096b() {
                this.f12368d = super.a(this.f12368d, 0);
                return this.f12368d;
            }

            public static HomeVotingPageModel m15090a(HomeVotingPageModel homeVotingPageModel) {
                if (homeVotingPageModel == null) {
                    return null;
                }
                if (homeVotingPageModel instanceof HomeVotingPageModel) {
                    return homeVotingPageModel;
                }
                Builder builder = new Builder();
                builder.f12367a = homeVotingPageModel.m15096b();
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                int b = flatBufferBuilder.b(builder.f12367a);
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, b);
                flatBufferBuilder.d(flatBufferBuilder.d());
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                return new HomeVotingPageModel(new MutableFlatBuffer(wrap, null, null, true, null));
            }

            @Nullable
            public final String m15093a() {
                return m15096b();
            }

            public final int jK_() {
                return 2479791;
            }

            public final GraphQLVisitableModel m15092a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m15091a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m15096b());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, b);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: final_slider_value */
        public class Serializer extends JsonSerializer<ReactionUnitGametimeFanFavoriteComponentFragmentModel> {
            public final void m15097a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                ReactionUnitGametimeFanFavoriteComponentFragmentModel reactionUnitGametimeFanFavoriteComponentFragmentModel = (ReactionUnitGametimeFanFavoriteComponentFragmentModel) obj;
                if (reactionUnitGametimeFanFavoriteComponentFragmentModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(reactionUnitGametimeFanFavoriteComponentFragmentModel.m15102a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    reactionUnitGametimeFanFavoriteComponentFragmentModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = reactionUnitGametimeFanFavoriteComponentFragmentModel.w_();
                int u_ = reactionUnitGametimeFanFavoriteComponentFragmentModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("away_voting_page");
                    AwayVotingPageParser.m15227a(mutableFlatBuffer, g, jsonGenerator);
                }
                g = mutableFlatBuffer.g(u_, 1);
                if (g != 0) {
                    jsonGenerator.a("home_voting_page");
                    HomeVotingPageParser.m15229a(mutableFlatBuffer, g, jsonGenerator);
                }
                g = mutableFlatBuffer.g(u_, 2);
                if (g != 0) {
                    jsonGenerator.a("match");
                    GametimeFanFavoriteMatchFragmentParser.m15201a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                g = mutableFlatBuffer.g(u_, 3);
                if (g != 0) {
                    jsonGenerator.a("title");
                    DefaultTextWithEntitiesFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
                }
                g = mutableFlatBuffer.a(u_, 4, 0);
                if (g != 0) {
                    jsonGenerator.a("total_votes");
                    jsonGenerator.b(g);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(ReactionUnitGametimeFanFavoriteComponentFragmentModel.class, new Serializer());
            }
        }

        public ReactionUnitGametimeFanFavoriteComponentFragmentModel() {
            super(5);
        }

        @Nullable
        private AwayVotingPageModel m15098a() {
            this.f12369d = (AwayVotingPageModel) super.a(this.f12369d, 0, AwayVotingPageModel.class);
            return this.f12369d;
        }

        @Nullable
        private HomeVotingPageModel m15099j() {
            this.f12370e = (HomeVotingPageModel) super.a(this.f12370e, 1, HomeVotingPageModel.class);
            return this.f12370e;
        }

        @Nullable
        private GametimeFanFavoriteMatchFragmentModel m15100k() {
            this.f12371f = (GametimeFanFavoriteMatchFragmentModel) super.a(this.f12371f, 2, GametimeFanFavoriteMatchFragmentModel.class);
            return this.f12371f;
        }

        @Nullable
        private DefaultTextWithEntitiesFieldsModel m15101l() {
            this.f12372g = (DefaultTextWithEntitiesFieldsModel) super.a(this.f12372g, 3, DefaultTextWithEntitiesFieldsModel.class);
            return this.f12372g;
        }

        public final int jK_() {
            return 1052184374;
        }

        public final GraphQLVisitableModel m15103a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m15098a() != null) {
                AwayVotingPageModel awayVotingPageModel = (AwayVotingPageModel) graphQLModelMutatingVisitor.b(m15098a());
                if (m15098a() != awayVotingPageModel) {
                    graphQLVisitableModel = (ReactionUnitGametimeFanFavoriteComponentFragmentModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f12369d = awayVotingPageModel;
                }
            }
            if (m15099j() != null) {
                HomeVotingPageModel homeVotingPageModel = (HomeVotingPageModel) graphQLModelMutatingVisitor.b(m15099j());
                if (m15099j() != homeVotingPageModel) {
                    graphQLVisitableModel = (ReactionUnitGametimeFanFavoriteComponentFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f12370e = homeVotingPageModel;
                }
            }
            if (m15100k() != null) {
                GametimeFanFavoriteMatchFragmentModel gametimeFanFavoriteMatchFragmentModel = (GametimeFanFavoriteMatchFragmentModel) graphQLModelMutatingVisitor.b(m15100k());
                if (m15100k() != gametimeFanFavoriteMatchFragmentModel) {
                    graphQLVisitableModel = (ReactionUnitGametimeFanFavoriteComponentFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f12371f = gametimeFanFavoriteMatchFragmentModel;
                }
            }
            if (m15101l() != null) {
                DefaultTextWithEntitiesFieldsModel defaultTextWithEntitiesFieldsModel = (DefaultTextWithEntitiesFieldsModel) graphQLModelMutatingVisitor.b(m15101l());
                if (m15101l() != defaultTextWithEntitiesFieldsModel) {
                    graphQLVisitableModel = (ReactionUnitGametimeFanFavoriteComponentFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f12372g = defaultTextWithEntitiesFieldsModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m15102a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m15098a());
            int a2 = ModelHelper.a(flatBufferBuilder, m15099j());
            int a3 = ModelHelper.a(flatBufferBuilder, m15100k());
            int a4 = ModelHelper.a(flatBufferBuilder, m15101l());
            flatBufferBuilder.c(5);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, a2);
            flatBufferBuilder.b(2, a3);
            flatBufferBuilder.b(3, a4);
            flatBufferBuilder.a(4, this.f12373h, 0);
            i();
            return flatBufferBuilder.d();
        }

        public final void m15104a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
            super.a(mutableFlatBuffer, i, obj);
            this.f12373h = mutableFlatBuffer.a(i, 4, 0);
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -1629606829)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: final_slider_value */
    public final class ReactionUnitGametimeTableComponentFragmentModel extends BaseModel implements GraphQLVisitableModel, ReactionUnitGametimeTableComponentFragment {
        @Nullable
        private List<TypedDataModel> f12376d;
        @Nullable
        private List<String> f12377e;

        /* compiled from: final_slider_value */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(ReactionUnitGametimeTableComponentFragmentModel.class, new Deserializer());
            }

            public Object m15105a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = ReactionUnitGametimeTableComponentFragmentParser.m15235a(jsonParser);
                Object reactionUnitGametimeTableComponentFragmentModel = new ReactionUnitGametimeTableComponentFragmentModel();
                ((BaseModel) reactionUnitGametimeTableComponentFragmentModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (reactionUnitGametimeTableComponentFragmentModel instanceof Postprocessable) {
                    return ((Postprocessable) reactionUnitGametimeTableComponentFragmentModel).a();
                }
                return reactionUnitGametimeTableComponentFragmentModel;
            }
        }

        /* compiled from: final_slider_value */
        public class Serializer extends JsonSerializer<ReactionUnitGametimeTableComponentFragmentModel> {
            public final void m15106a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                ReactionUnitGametimeTableComponentFragmentModel reactionUnitGametimeTableComponentFragmentModel = (ReactionUnitGametimeTableComponentFragmentModel) obj;
                if (reactionUnitGametimeTableComponentFragmentModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(reactionUnitGametimeTableComponentFragmentModel.m15115a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    reactionUnitGametimeTableComponentFragmentModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = reactionUnitGametimeTableComponentFragmentModel.w_();
                int u_ = reactionUnitGametimeTableComponentFragmentModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("typed_data");
                    TypedDataParser.m15233a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                if (mutableFlatBuffer.g(u_, 1) != 0) {
                    jsonGenerator.a("typed_headers");
                    SerializerHelpers.a(mutableFlatBuffer.f(u_, 1), jsonGenerator);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(ReactionUnitGametimeTableComponentFragmentModel.class, new Serializer());
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 403239041)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: final_slider_value */
        public final class TypedDataModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private List<String> f12375d;

            /* compiled from: final_slider_value */
            public final class Builder {
                @Nullable
                public ImmutableList<String> f12374a;
            }

            /* compiled from: final_slider_value */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(TypedDataModel.class, new Deserializer());
                }

                public Object m15107a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(TypedDataParser.m15234b(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object typedDataModel = new TypedDataModel();
                    ((BaseModel) typedDataModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (typedDataModel instanceof Postprocessable) {
                        return ((Postprocessable) typedDataModel).a();
                    }
                    return typedDataModel;
                }
            }

            /* compiled from: final_slider_value */
            public class Serializer extends JsonSerializer<TypedDataModel> {
                public final void m15108a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    TypedDataModel typedDataModel = (TypedDataModel) obj;
                    if (typedDataModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(typedDataModel.m15110a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        typedDataModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    TypedDataParser.m15232a(typedDataModel.w_(), typedDataModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(TypedDataModel.class, new Serializer());
                }
            }

            public TypedDataModel() {
                super(1);
            }

            public TypedDataModel(MutableFlatBuffer mutableFlatBuffer) {
                super(1);
                a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
            }

            @Nonnull
            public final ImmutableList<String> m15112a() {
                this.f12375d = super.a(this.f12375d, 0);
                return (ImmutableList) this.f12375d;
            }

            public static TypedDataModel m15109a(TypedDataModel typedDataModel) {
                if (typedDataModel == null) {
                    return null;
                }
                if (typedDataModel instanceof TypedDataModel) {
                    return typedDataModel;
                }
                Builder builder = new Builder();
                com.google.common.collect.ImmutableList.Builder builder2 = ImmutableList.builder();
                for (int i = 0; i < typedDataModel.m15112a().size(); i++) {
                    builder2.c(typedDataModel.m15112a().get(i));
                }
                builder.f12374a = builder2.b();
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                int c = flatBufferBuilder.c(builder.f12374a);
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, c);
                flatBufferBuilder.d(flatBufferBuilder.d());
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                return new TypedDataModel(new MutableFlatBuffer(wrap, null, null, true, null));
            }

            public final int jK_() {
                return -2079976299;
            }

            public final GraphQLVisitableModel m15111a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m15110a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int c = flatBufferBuilder.c(m15112a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, c);
                i();
                return flatBufferBuilder.d();
            }
        }

        public ReactionUnitGametimeTableComponentFragmentModel() {
            super(2);
        }

        @Nonnull
        private ImmutableList<TypedDataModel> m15113a() {
            this.f12376d = super.a(this.f12376d, 0, TypedDataModel.class);
            return (ImmutableList) this.f12376d;
        }

        @Nonnull
        private ImmutableList<String> m15114j() {
            this.f12377e = super.a(this.f12377e, 1);
            return (ImmutableList) this.f12377e;
        }

        public final int jK_() {
            return -944213604;
        }

        public final GraphQLVisitableModel m15116a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m15113a() != null) {
                Builder a = ModelHelper.a(m15113a(), graphQLModelMutatingVisitor);
                if (a != null) {
                    graphQLVisitableModel = (ReactionUnitGametimeTableComponentFragmentModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f12376d = a.b();
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m15115a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m15113a());
            int c = flatBufferBuilder.c(m15114j());
            flatBufferBuilder.c(2);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, c);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -32890295)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: final_slider_value */
    public final class ReactionUnitPhotoComponentFragmentModel extends BaseModel implements GraphQLVisitableModel, ReactionUnitPhotoComponentFragment {
        @Nullable
        private DefaultTextWithEntitiesFieldsModel f12402d;
        @Nullable
        private PhotoModel f12403e;

        /* compiled from: final_slider_value */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(ReactionUnitPhotoComponentFragmentModel.class, new Deserializer());
            }

            public Object m15117a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = ReactionUnitPhotoComponentFragmentParser.m15242a(jsonParser);
                Object reactionUnitPhotoComponentFragmentModel = new ReactionUnitPhotoComponentFragmentModel();
                ((BaseModel) reactionUnitPhotoComponentFragmentModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (reactionUnitPhotoComponentFragmentModel instanceof Postprocessable) {
                    return ((Postprocessable) reactionUnitPhotoComponentFragmentModel).a();
                }
                return reactionUnitPhotoComponentFragmentModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -69542833)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: final_slider_value */
        public final class PhotoModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel, SizeAwareMedia {
            @Nullable
            private GraphQLObjectType f12394d;
            @Nullable
            private CreationStoryModel f12395e;
            @Nullable
            private DefaultVect2FieldsModel f12396f;
            @Nullable
            private String f12397g;
            @Nullable
            private DefaultImageFieldsModel f12398h;
            @Nullable
            private DefaultImageFieldsModel f12399i;
            @Nullable
            private DefaultImageFieldsModel f12400j;
            @Nullable
            private DefaultImageFieldsModel f12401k;

            /* compiled from: final_slider_value */
            public final class Builder {
                @Nullable
                public GraphQLObjectType f12378a;
                @Nullable
                public CreationStoryModel f12379b;
                @Nullable
                public DefaultVect2FieldsModel f12380c;
                @Nullable
                public String f12381d;
                @Nullable
                public DefaultImageFieldsModel f12382e;
                @Nullable
                public DefaultImageFieldsModel f12383f;
                @Nullable
                public DefaultImageFieldsModel f12384g;
                @Nullable
                public DefaultImageFieldsModel f12385h;
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = -876945551)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: final_slider_value */
            public final class CreationStoryModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
                @Nullable
                private String f12391d;
                @Nullable
                private FeedbackModel f12392e;
                @Nullable
                private String f12393f;

                /* compiled from: final_slider_value */
                public final class Builder {
                    @Nullable
                    public String f12386a;
                    @Nullable
                    public FeedbackModel f12387b;
                    @Nullable
                    public String f12388c;
                }

                /* compiled from: final_slider_value */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(CreationStoryModel.class, new Deserializer());
                    }

                    public Object m15118a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(CreationStoryParser.m15238a(jsonParser, flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                        Object creationStoryModel = new CreationStoryModel();
                        ((BaseModel) creationStoryModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                        if (creationStoryModel instanceof Postprocessable) {
                            return ((Postprocessable) creationStoryModel).a();
                        }
                        return creationStoryModel;
                    }
                }

                @JsonDeserialize(using = Deserializer.class)
                @ModelWithFlatBufferFormatHash(a = 989329089)
                @JsonSerialize(using = Serializer.class)
                @FragmentModelWithoutBridge
                /* compiled from: final_slider_value */
                public final class FeedbackModel extends BaseModel implements GraphQLVisitableConsistentModel {
                    @Nullable
                    private String f12390d;

                    /* compiled from: final_slider_value */
                    public final class Builder {
                        @Nullable
                        public String f12389a;
                    }

                    /* compiled from: final_slider_value */
                    public class Deserializer extends FbJsonDeserializer {
                        static {
                            GlobalAutoGenDeserializerCache.a(FeedbackModel.class, new Deserializer());
                        }

                        public Object m15119a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(FeedbackParser.m15236a(jsonParser, flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            mutableFlatBuffer.a(4, Boolean.valueOf(true));
                            MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                            Object feedbackModel = new FeedbackModel();
                            ((BaseModel) feedbackModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                            if (feedbackModel instanceof Postprocessable) {
                                return ((Postprocessable) feedbackModel).a();
                            }
                            return feedbackModel;
                        }
                    }

                    /* compiled from: final_slider_value */
                    public class Serializer extends JsonSerializer<FeedbackModel> {
                        public final void m15120a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                            FeedbackModel feedbackModel = (FeedbackModel) obj;
                            if (feedbackModel.w_() == null) {
                                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                flatBufferBuilder.d(feedbackModel.m15122a(flatBufferBuilder));
                                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                wrap.position(0);
                                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                feedbackModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                            }
                            FeedbackParser.m15237a(feedbackModel.w_(), feedbackModel.u_(), jsonGenerator);
                        }

                        static {
                            FbSerializerProvider.a(FeedbackModel.class, new Serializer());
                        }
                    }

                    public FeedbackModel() {
                        super(1);
                    }

                    public FeedbackModel(MutableFlatBuffer mutableFlatBuffer) {
                        super(1);
                        a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }

                    public final void m15125a(String str, ConsistencyTuple consistencyTuple) {
                        consistencyTuple.a();
                    }

                    public final void m15126a(String str, Object obj, boolean z) {
                    }

                    @Nullable
                    public final String m15124a() {
                        this.f12390d = super.a(this.f12390d, 0);
                        return this.f12390d;
                    }

                    public static FeedbackModel m15121a(FeedbackModel feedbackModel) {
                        if (feedbackModel == null) {
                            return null;
                        }
                        if (feedbackModel instanceof FeedbackModel) {
                            return feedbackModel;
                        }
                        Builder builder = new Builder();
                        builder.f12389a = feedbackModel.m15124a();
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        int b = flatBufferBuilder.b(builder.f12389a);
                        flatBufferBuilder.c(1);
                        flatBufferBuilder.b(0, b);
                        flatBufferBuilder.d(flatBufferBuilder.d());
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        return new FeedbackModel(new MutableFlatBuffer(wrap, null, null, true, null));
                    }

                    public final int jK_() {
                        return -126857307;
                    }

                    public final GraphQLVisitableModel m15123a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                        h();
                        i();
                        return this;
                    }

                    public final int m15122a(FlatBufferBuilder flatBufferBuilder) {
                        h();
                        int b = flatBufferBuilder.b(m15124a());
                        flatBufferBuilder.c(1);
                        flatBufferBuilder.b(0, b);
                        i();
                        return flatBufferBuilder.d();
                    }
                }

                /* compiled from: final_slider_value */
                public class Serializer extends JsonSerializer<CreationStoryModel> {
                    public final void m15127a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        CreationStoryModel creationStoryModel = (CreationStoryModel) obj;
                        if (creationStoryModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(creationStoryModel.m15130a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            creationStoryModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        CreationStoryParser.m15239a(creationStoryModel.w_(), creationStoryModel.u_(), jsonGenerator, serializerProvider);
                    }

                    static {
                        FbSerializerProvider.a(CreationStoryModel.class, new Serializer());
                    }
                }

                @Nullable
                public final /* synthetic */ FeedbackModel m15136c() {
                    return m15129j();
                }

                public CreationStoryModel() {
                    super(3);
                }

                public CreationStoryModel(MutableFlatBuffer mutableFlatBuffer) {
                    super(3);
                    a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }

                public final void m15133a(String str, ConsistencyTuple consistencyTuple) {
                    consistencyTuple.a();
                }

                public final void m15134a(String str, Object obj, boolean z) {
                }

                @Nullable
                public final String m15135b() {
                    this.f12391d = super.a(this.f12391d, 0);
                    return this.f12391d;
                }

                @Nullable
                private FeedbackModel m15129j() {
                    this.f12392e = (FeedbackModel) super.a(this.f12392e, 1, FeedbackModel.class);
                    return this.f12392e;
                }

                @Nullable
                public final String m15137d() {
                    this.f12393f = super.a(this.f12393f, 2);
                    return this.f12393f;
                }

                public static CreationStoryModel m15128a(CreationStoryModel creationStoryModel) {
                    if (creationStoryModel == null) {
                        return null;
                    }
                    if (creationStoryModel instanceof CreationStoryModel) {
                        return creationStoryModel;
                    }
                    Builder builder = new Builder();
                    builder.f12386a = creationStoryModel.m15135b();
                    builder.f12387b = FeedbackModel.m15121a(creationStoryModel.m15136c());
                    builder.f12388c = creationStoryModel.m15137d();
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    int b = flatBufferBuilder.b(builder.f12386a);
                    int a = ModelHelper.a(flatBufferBuilder, builder.f12387b);
                    int b2 = flatBufferBuilder.b(builder.f12388c);
                    flatBufferBuilder.c(3);
                    flatBufferBuilder.b(0, b);
                    flatBufferBuilder.b(1, a);
                    flatBufferBuilder.b(2, b2);
                    flatBufferBuilder.d(flatBufferBuilder.d());
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    return new CreationStoryModel(new MutableFlatBuffer(wrap, null, null, true, null));
                }

                @Nullable
                public final String m15132a() {
                    return m15137d();
                }

                public final int jK_() {
                    return 80218325;
                }

                public final GraphQLVisitableModel m15131a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    GraphQLVisitableModel graphQLVisitableModel = null;
                    h();
                    if (m15129j() != null) {
                        FeedbackModel feedbackModel = (FeedbackModel) graphQLModelMutatingVisitor.b(m15129j());
                        if (m15129j() != feedbackModel) {
                            graphQLVisitableModel = (CreationStoryModel) ModelHelper.a(null, this);
                            graphQLVisitableModel.f12392e = feedbackModel;
                        }
                    }
                    i();
                    return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                }

                public final int m15130a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int b = flatBufferBuilder.b(m15135b());
                    int a = ModelHelper.a(flatBufferBuilder, m15129j());
                    int b2 = flatBufferBuilder.b(m15137d());
                    flatBufferBuilder.c(3);
                    flatBufferBuilder.b(0, b);
                    flatBufferBuilder.b(1, a);
                    flatBufferBuilder.b(2, b2);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            /* compiled from: final_slider_value */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(PhotoModel.class, new Deserializer());
                }

                public Object m15138a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(PhotoParser.m15240a(jsonParser, flatBufferBuilder));
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

            /* compiled from: final_slider_value */
            public class Serializer extends JsonSerializer<PhotoModel> {
                public final void m15139a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    PhotoModel photoModel = (PhotoModel) obj;
                    if (photoModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(photoModel.m15147a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        photoModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    PhotoParser.m15241a(photoModel.w_(), photoModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(PhotoModel.class, new Serializer());
                }
            }

            @Nullable
            public final /* synthetic */ DefaultImageFields bc_() {
                return m15146p();
            }

            @Nullable
            public final /* synthetic */ DefaultImageFields bd_() {
                return m15145o();
            }

            @Nullable
            public final /* synthetic */ DefaultImageFields be_() {
                return m15143m();
            }

            @Nullable
            public final /* synthetic */ DefaultVect2Fields m15151c() {
                return m15142l();
            }

            @Nullable
            public final /* synthetic */ DefaultImageFields m15153g() {
                return m15144n();
            }

            @Nullable
            public final /* synthetic */ CreationStoryModel m15154j() {
                return m15141k();
            }

            public PhotoModel() {
                super(8);
            }

            public PhotoModel(MutableFlatBuffer mutableFlatBuffer) {
                super(8);
                a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
            }

            @Nullable
            public final GraphQLObjectType m15150b() {
                if (this.b != null && this.f12394d == null) {
                    this.f12394d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
                }
                return this.f12394d;
            }

            @Nullable
            private CreationStoryModel m15141k() {
                this.f12395e = (CreationStoryModel) super.a(this.f12395e, 1, CreationStoryModel.class);
                return this.f12395e;
            }

            @Nullable
            private DefaultVect2FieldsModel m15142l() {
                this.f12396f = (DefaultVect2FieldsModel) super.a(this.f12396f, 2, DefaultVect2FieldsModel.class);
                return this.f12396f;
            }

            @Nullable
            public final String m15152d() {
                this.f12397g = super.a(this.f12397g, 3);
                return this.f12397g;
            }

            @Nullable
            private DefaultImageFieldsModel m15143m() {
                this.f12398h = (DefaultImageFieldsModel) super.a(this.f12398h, 4, DefaultImageFieldsModel.class);
                return this.f12398h;
            }

            @Nullable
            private DefaultImageFieldsModel m15144n() {
                this.f12399i = (DefaultImageFieldsModel) super.a(this.f12399i, 5, DefaultImageFieldsModel.class);
                return this.f12399i;
            }

            @Nullable
            private DefaultImageFieldsModel m15145o() {
                this.f12400j = (DefaultImageFieldsModel) super.a(this.f12400j, 6, DefaultImageFieldsModel.class);
                return this.f12400j;
            }

            @Nullable
            private DefaultImageFieldsModel m15146p() {
                this.f12401k = (DefaultImageFieldsModel) super.a(this.f12401k, 7, DefaultImageFieldsModel.class);
                return this.f12401k;
            }

            public static PhotoModel m15140a(PhotoModel photoModel) {
                if (photoModel == null) {
                    return null;
                }
                if (photoModel instanceof PhotoModel) {
                    return photoModel;
                }
                Builder builder = new Builder();
                builder.f12378a = photoModel.m15150b();
                builder.f12379b = CreationStoryModel.m15128a(photoModel.m15154j());
                builder.f12380c = DefaultVect2FieldsModel.a(photoModel.m15151c());
                builder.f12381d = photoModel.m15152d();
                builder.f12382e = DefaultImageFieldsModel.a(photoModel.be_());
                builder.f12383f = DefaultImageFieldsModel.a(photoModel.m15153g());
                builder.f12384g = DefaultImageFieldsModel.a(photoModel.bd_());
                builder.f12385h = DefaultImageFieldsModel.a(photoModel.bc_());
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                int a = ModelHelper.a(flatBufferBuilder, builder.f12378a);
                int a2 = ModelHelper.a(flatBufferBuilder, builder.f12379b);
                int a3 = ModelHelper.a(flatBufferBuilder, builder.f12380c);
                int b = flatBufferBuilder.b(builder.f12381d);
                int a4 = ModelHelper.a(flatBufferBuilder, builder.f12382e);
                int a5 = ModelHelper.a(flatBufferBuilder, builder.f12383f);
                int a6 = ModelHelper.a(flatBufferBuilder, builder.f12384g);
                int a7 = ModelHelper.a(flatBufferBuilder, builder.f12385h);
                flatBufferBuilder.c(8);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.b(1, a2);
                flatBufferBuilder.b(2, a3);
                flatBufferBuilder.b(3, b);
                flatBufferBuilder.b(4, a4);
                flatBufferBuilder.b(5, a5);
                flatBufferBuilder.b(6, a6);
                flatBufferBuilder.b(7, a7);
                flatBufferBuilder.d(flatBufferBuilder.d());
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                return new PhotoModel(new MutableFlatBuffer(wrap, null, null, true, null));
            }

            @Nullable
            public final String m15149a() {
                return m15152d();
            }

            public final int jK_() {
                return 77090322;
            }

            public final GraphQLVisitableModel m15148a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                DefaultImageFieldsModel defaultImageFieldsModel;
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m15141k() != null) {
                    CreationStoryModel creationStoryModel = (CreationStoryModel) graphQLModelMutatingVisitor.b(m15141k());
                    if (m15141k() != creationStoryModel) {
                        graphQLVisitableModel = (PhotoModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f12395e = creationStoryModel;
                    }
                }
                if (m15142l() != null) {
                    DefaultVect2FieldsModel defaultVect2FieldsModel = (DefaultVect2FieldsModel) graphQLModelMutatingVisitor.b(m15142l());
                    if (m15142l() != defaultVect2FieldsModel) {
                        graphQLVisitableModel = (PhotoModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f12396f = defaultVect2FieldsModel;
                    }
                }
                if (m15143m() != null) {
                    defaultImageFieldsModel = (DefaultImageFieldsModel) graphQLModelMutatingVisitor.b(m15143m());
                    if (m15143m() != defaultImageFieldsModel) {
                        graphQLVisitableModel = (PhotoModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f12398h = defaultImageFieldsModel;
                    }
                }
                if (m15144n() != null) {
                    defaultImageFieldsModel = (DefaultImageFieldsModel) graphQLModelMutatingVisitor.b(m15144n());
                    if (m15144n() != defaultImageFieldsModel) {
                        graphQLVisitableModel = (PhotoModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f12399i = defaultImageFieldsModel;
                    }
                }
                if (m15145o() != null) {
                    defaultImageFieldsModel = (DefaultImageFieldsModel) graphQLModelMutatingVisitor.b(m15145o());
                    if (m15145o() != defaultImageFieldsModel) {
                        graphQLVisitableModel = (PhotoModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f12400j = defaultImageFieldsModel;
                    }
                }
                if (m15146p() != null) {
                    defaultImageFieldsModel = (DefaultImageFieldsModel) graphQLModelMutatingVisitor.b(m15146p());
                    if (m15146p() != defaultImageFieldsModel) {
                        graphQLVisitableModel = (PhotoModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f12401k = defaultImageFieldsModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m15147a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m15150b());
                int a2 = ModelHelper.a(flatBufferBuilder, m15141k());
                int a3 = ModelHelper.a(flatBufferBuilder, m15142l());
                int b = flatBufferBuilder.b(m15152d());
                int a4 = ModelHelper.a(flatBufferBuilder, m15143m());
                int a5 = ModelHelper.a(flatBufferBuilder, m15144n());
                int a6 = ModelHelper.a(flatBufferBuilder, m15145o());
                int a7 = ModelHelper.a(flatBufferBuilder, m15146p());
                flatBufferBuilder.c(8);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.b(1, a2);
                flatBufferBuilder.b(2, a3);
                flatBufferBuilder.b(3, b);
                flatBufferBuilder.b(4, a4);
                flatBufferBuilder.b(5, a5);
                flatBufferBuilder.b(6, a6);
                flatBufferBuilder.b(7, a7);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: final_slider_value */
        public class Serializer extends JsonSerializer<ReactionUnitPhotoComponentFragmentModel> {
            public final void m15155a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                ReactionUnitPhotoComponentFragmentModel reactionUnitPhotoComponentFragmentModel = (ReactionUnitPhotoComponentFragmentModel) obj;
                if (reactionUnitPhotoComponentFragmentModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(reactionUnitPhotoComponentFragmentModel.m15158a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    reactionUnitPhotoComponentFragmentModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = reactionUnitPhotoComponentFragmentModel.w_();
                int u_ = reactionUnitPhotoComponentFragmentModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("message");
                    DefaultTextWithEntitiesFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
                }
                g = mutableFlatBuffer.g(u_, 1);
                if (g != 0) {
                    jsonGenerator.a("photo");
                    PhotoParser.m15241a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(ReactionUnitPhotoComponentFragmentModel.class, new Serializer());
            }
        }

        public ReactionUnitPhotoComponentFragmentModel() {
            super(2);
        }

        @Nullable
        private DefaultTextWithEntitiesFieldsModel m15156a() {
            this.f12402d = (DefaultTextWithEntitiesFieldsModel) super.a(this.f12402d, 0, DefaultTextWithEntitiesFieldsModel.class);
            return this.f12402d;
        }

        @Nullable
        private PhotoModel m15157j() {
            this.f12403e = (PhotoModel) super.a(this.f12403e, 1, PhotoModel.class);
            return this.f12403e;
        }

        public final int jK_() {
            return 1541398456;
        }

        public final GraphQLVisitableModel m15159a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m15156a() != null) {
                DefaultTextWithEntitiesFieldsModel defaultTextWithEntitiesFieldsModel = (DefaultTextWithEntitiesFieldsModel) graphQLModelMutatingVisitor.b(m15156a());
                if (m15156a() != defaultTextWithEntitiesFieldsModel) {
                    graphQLVisitableModel = (ReactionUnitPhotoComponentFragmentModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f12402d = defaultTextWithEntitiesFieldsModel;
                }
            }
            if (m15157j() != null) {
                PhotoModel photoModel = (PhotoModel) graphQLModelMutatingVisitor.b(m15157j());
                if (m15157j() != photoModel) {
                    graphQLVisitableModel = (ReactionUnitPhotoComponentFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f12403e = photoModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m15158a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m15156a());
            int a2 = ModelHelper.a(flatBufferBuilder, m15157j());
            flatBufferBuilder.c(2);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, a2);
            i();
            return flatBufferBuilder.d();
        }
    }
}
