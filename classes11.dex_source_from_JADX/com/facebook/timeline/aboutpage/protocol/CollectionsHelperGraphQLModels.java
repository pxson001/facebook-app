package com.facebook.timeline.aboutpage.protocol;

import com.facebook.api.graphql.saved.SaveDefaultsGraphQLInterfaces.SavableTimelineAppCollection;
import com.facebook.api.graphql.saved.SaveDefaultsGraphQLModels.SavableTimelineAppCollectionModel;
import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbSerializerProvider;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.directinstall.util.DirectInstallApplicationUtilsGraphQLInterfaces.GetNativeAppDetailsActorGraphQL;
import com.facebook.directinstall.util.DirectInstallApplicationUtilsGraphQLModels.GetNativeAppDetailsAppStoreApplicationGraphQLModel;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.FragmentModelWithoutBridge;
import com.facebook.flatbuffers.ModelWithFlatBufferFormatHash;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.enums.GraphQLFriendshipStatus;
import com.facebook.graphql.enums.GraphQLGroupJoinState;
import com.facebook.graphql.enums.GraphQLObjectType;
import com.facebook.graphql.enums.GraphQLSubscribeStatus;
import com.facebook.graphql.enums.GraphQLTimelineAppCollectionItemType;
import com.facebook.graphql.enums.GraphQLTimelineAppCollectionStyle;
import com.facebook.graphql.enums.GraphQLTimelineAppSectionType;
import com.facebook.graphql.enums.GraphQLTimelineContactItemType;
import com.facebook.graphql.linkutil.GraphQLLinkExtractorGraphQLInterfaces.GetEntityFbLinkGraphQL.Page;
import com.facebook.graphql.linkutil.GraphQLLinkExtractorGraphQLModels.GetRedirectionLinkGraphQLModel.RedirectionInfoModel;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.querybuilder.common.CommonGraphQL2Interfaces.DefaultPageInfoFields;
import com.facebook.graphql.querybuilder.common.CommonGraphQL2Models.DefaultPageInfoFieldsModel;
import com.facebook.graphql.querybuilder.common.CommonGraphQLInterfaces.DefaultImageFields;
import com.facebook.graphql.querybuilder.common.CommonGraphQLModels.DefaultImageFieldsModel;
import com.facebook.graphql.querybuilder.common.TextWithEntitiesGraphQLInterfaces.DefaultTextWithEntitiesEntityFields;
import com.facebook.graphql.querybuilder.common.TextWithEntitiesGraphQLInterfaces.DefaultTextWithEntitiesFields;
import com.facebook.graphql.querybuilder.common.TextWithEntitiesGraphQLInterfaces.DefaultTextWithEntitiesLongFields;
import com.facebook.graphql.querybuilder.common.TextWithEntitiesGraphQLInterfaces.DefaultTextWithEntitiesLongFields.Ranges;
import com.facebook.graphql.querybuilder.common.TextWithEntitiesGraphQLModels.DefaultTextWithEntitiesFieldsModel;
import com.facebook.graphql.visitor.ConsistencyTuple;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLPersistableNode;
import com.facebook.graphql.visitor.GraphQLVisitableConsistentModel;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.facebook.linkify.LinkifyTargetGraphQLInterfaces.LinkifyTargetGraphQL.ProfilePicture;
import com.facebook.timeline.aboutpage.protocol.CollectionsHelperGraphQLInterfaces.AppCollectionItemContainingMutationFields;
import com.facebook.timeline.aboutpage.protocol.CollectionsHelperGraphQLInterfaces.AppCollectionSuggestionContainingMutationFields;
import com.facebook.timeline.aboutpage.protocol.CollectionsHelperGraphQLInterfaces.CollectionsAppSection;
import com.facebook.timeline.aboutpage.protocol.CollectionsHelperGraphQLInterfaces.CollectionsFirstFiveGroupMembersFields;
import com.facebook.timeline.aboutpage.protocol.CollectionsHelperGraphQLInterfaces.CollectionsNodeIdFields;
import com.facebook.timeline.aboutpage.protocol.CollectionsHelperGraphQLInterfaces.CollectionsNodePeekFields;
import com.facebook.timeline.aboutpage.protocol.CollectionsHelperGraphQLParsers.AppCollectionItemContainingMutationFieldsParser;
import com.facebook.timeline.aboutpage.protocol.CollectionsHelperGraphQLParsers.AppCollectionItemParser;
import com.facebook.timeline.aboutpage.protocol.CollectionsHelperGraphQLParsers.AppCollectionItemParser.RatingParser;
import com.facebook.timeline.aboutpage.protocol.CollectionsHelperGraphQLParsers.AppCollectionItemParser.TitleParser;
import com.facebook.timeline.aboutpage.protocol.CollectionsHelperGraphQLParsers.AppCollectionItemParser.TitleParser.RangesParser;
import com.facebook.timeline.aboutpage.protocol.CollectionsHelperGraphQLParsers.AppCollectionItemParser.TitleParser.RangesParser.EntityParser;
import com.facebook.timeline.aboutpage.protocol.CollectionsHelperGraphQLParsers.AppCollectionSuggestionContainingMutationFieldsParser;
import com.facebook.timeline.aboutpage.protocol.CollectionsHelperGraphQLParsers.AppCollectionSuggestionFieldsParser;
import com.facebook.timeline.aboutpage.protocol.CollectionsHelperGraphQLParsers.CollectionGroupMembersFieldsParser;
import com.facebook.timeline.aboutpage.protocol.CollectionsHelperGraphQLParsers.CollectionItemConnectionWithFieldsParser;
import com.facebook.timeline.aboutpage.protocol.CollectionsHelperGraphQLParsers.CollectionItemNodeFieldsParser;
import com.facebook.timeline.aboutpage.protocol.CollectionsHelperGraphQLParsers.CollectionItemNodeFieldsParser.AddressParser;
import com.facebook.timeline.aboutpage.protocol.CollectionsHelperGraphQLParsers.CollectionsAppSectionParser;
import com.facebook.timeline.aboutpage.protocol.CollectionsHelperGraphQLParsers.CollectionsAppSectionParser.SubtitleParser;
import com.facebook.timeline.aboutpage.protocol.CollectionsHelperGraphQLParsers.CollectionsEligibleSuggestionsFieldsParser;
import com.facebook.timeline.aboutpage.protocol.CollectionsHelperGraphQLParsers.CollectionsFirstFiveGroupMembersFieldsParser;
import com.facebook.timeline.aboutpage.protocol.CollectionsHelperGraphQLParsers.CollectionsFirstFiveGroupMembersFieldsParser.GroupMembersParser;
import com.facebook.timeline.aboutpage.protocol.CollectionsHelperGraphQLParsers.CollectionsNodeIdFieldsParser;
import com.facebook.timeline.aboutpage.protocol.CollectionsHelperGraphQLParsers.CollectionsNodePeekFieldsParser;
import com.facebook.timeline.aboutpage.protocol.CollectionsHelperGraphQLParsers.CollectionsPeekFieldsParser;
import com.facebook.ufiservices.util.LinkifyUtilGraphQLInterfaces.LinkableUtilApplyActorsLinksGraphQL;
import com.facebook.ufiservices.util.LinkifyUtilGraphQLInterfaces.LinkableUtilApplyActorsLinksGraphQL.Ranges.Entity;
import com.facebook.ufiservices.util.LinkifyUtilGraphQLInterfaces.LinkableUtilApplyClickableLinkSpanWithEntityGraphQL;
import com.facebook.ufiservices.util.LinkifyUtilGraphQLInterfaces.LinkableUtilApplyFamilyNonUserMemberLinkGraphQL;
import com.facebook.ufiservices.util.LinkifyUtilGraphQLInterfaces.LinkableUtilApplyHashtagLinkGraphQL;
import com.facebook.ufiservices.util.LinkifyUtilGraphQLInterfaces.LinkableUtilShouldFormatAsExternalLinkGraphQL;
import com.facebook.ufiservices.util.LinkifyUtilGraphQLModels.LinkableUtilApplyActorsLinksGraphQLModel.RangesModel.EntityModel.PageModel;
import com.facebook.ufiservices.util.LinkifyUtilGraphQLModels.LinkableUtilApplyActorsLinksGraphQLModel.RangesModel.EntityModel.ProfilePictureModel;
import com.facebook.ufiservices.util.LinkifyUtilGraphQLModels.StoryHeaderSectionOnClickGraphQLModel.AppSectionModel;
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

/* compiled from: MarketplaceLocationDialogCancelled */
public class CollectionsHelperGraphQLModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -1067712738)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: MarketplaceLocationDialogCancelled */
    public final class AppCollectionItemContainingMutationFieldsModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel, AppCollectionItemContainingMutationFields {
        @Nullable
        private String f13242d;
        @Nullable
        private String f13243e;

        /* compiled from: MarketplaceLocationDialogCancelled */
        public final class Builder {
            @Nullable
            public String f13240a;
            @Nullable
            public String f13241b;

            public final AppCollectionItemContainingMutationFieldsModel m14214a() {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                int b = flatBufferBuilder.b(this.f13240a);
                int b2 = flatBufferBuilder.b(this.f13241b);
                flatBufferBuilder.c(2);
                flatBufferBuilder.b(0, b);
                flatBufferBuilder.b(1, b2);
                flatBufferBuilder.d(flatBufferBuilder.d());
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                return new AppCollectionItemContainingMutationFieldsModel(new MutableFlatBuffer(wrap, null, null, true, null));
            }
        }

        /* compiled from: MarketplaceLocationDialogCancelled */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(AppCollectionItemContainingMutationFieldsModel.class, new Deserializer());
            }

            public Object m14215a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = AppCollectionItemContainingMutationFieldsParser.m14444a(jsonParser);
                Object appCollectionItemContainingMutationFieldsModel = new AppCollectionItemContainingMutationFieldsModel();
                ((BaseModel) appCollectionItemContainingMutationFieldsModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (appCollectionItemContainingMutationFieldsModel instanceof Postprocessable) {
                    return ((Postprocessable) appCollectionItemContainingMutationFieldsModel).a();
                }
                return appCollectionItemContainingMutationFieldsModel;
            }
        }

        /* compiled from: MarketplaceLocationDialogCancelled */
        public class Serializer extends JsonSerializer<AppCollectionItemContainingMutationFieldsModel> {
            public final void m14216a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                AppCollectionItemContainingMutationFieldsModel appCollectionItemContainingMutationFieldsModel = (AppCollectionItemContainingMutationFieldsModel) obj;
                if (appCollectionItemContainingMutationFieldsModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(appCollectionItemContainingMutationFieldsModel.m14219a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    appCollectionItemContainingMutationFieldsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = appCollectionItemContainingMutationFieldsModel.w_();
                int u_ = appCollectionItemContainingMutationFieldsModel.u_();
                jsonGenerator.f();
                if (mutableFlatBuffer.g(u_, 0) != 0) {
                    jsonGenerator.a("id");
                    jsonGenerator.b(mutableFlatBuffer.c(u_, 0));
                }
                if (mutableFlatBuffer.g(u_, 1) != 0) {
                    jsonGenerator.a("locally_updated_containing_collection_id");
                    jsonGenerator.b(mutableFlatBuffer.c(u_, 1));
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(AppCollectionItemContainingMutationFieldsModel.class, new Serializer());
            }
        }

        public AppCollectionItemContainingMutationFieldsModel() {
            super(2);
        }

        public AppCollectionItemContainingMutationFieldsModel(MutableFlatBuffer mutableFlatBuffer) {
            super(2);
            a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
        }

        public final void m14222a(String str, ConsistencyTuple consistencyTuple) {
            if ("locally_updated_containing_collection_id".equals(str)) {
                consistencyTuple.a = mo385g();
                consistencyTuple.b = u_();
                consistencyTuple.c = 1;
                return;
            }
            consistencyTuple.a();
        }

        public final void m14223a(String str, Object obj, boolean z) {
            if ("locally_updated_containing_collection_id".equals(str)) {
                m14218a((String) obj);
            }
        }

        @Nullable
        public final String mo384d() {
            this.f13242d = super.a(this.f13242d, 0);
            return this.f13242d;
        }

        @Nullable
        public final String mo385g() {
            this.f13243e = super.a(this.f13243e, 1);
            return this.f13243e;
        }

        private void m14218a(@Nullable String str) {
            this.f13243e = str;
            if (this.b != null && this.b.d) {
                this.b.a(this.c, 1, str);
            }
        }

        public static AppCollectionItemContainingMutationFieldsModel m14217a(AppCollectionItemContainingMutationFields appCollectionItemContainingMutationFields) {
            if (appCollectionItemContainingMutationFields == null) {
                return null;
            }
            if (appCollectionItemContainingMutationFields instanceof AppCollectionItemContainingMutationFieldsModel) {
                return (AppCollectionItemContainingMutationFieldsModel) appCollectionItemContainingMutationFields;
            }
            Builder builder = new Builder();
            builder.f13240a = appCollectionItemContainingMutationFields.mo384d();
            builder.f13241b = appCollectionItemContainingMutationFields.mo385g();
            return builder.m14214a();
        }

        @Nullable
        public final String m14221a() {
            return mo384d();
        }

        public final int jK_() {
            return -154776335;
        }

        public final GraphQLVisitableModel m14220a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            h();
            i();
            return this;
        }

        public final int m14219a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(mo384d());
            int b2 = flatBufferBuilder.b(mo385g());
            flatBufferBuilder.c(2);
            flatBufferBuilder.b(0, b);
            flatBufferBuilder.b(1, b2);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -596961402)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: MarketplaceLocationDialogCancelled */
    public final class AppCollectionItemModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel, AppCollectionItemContainingMutationFields {
        @Nullable
        private GraphQLTimelineAppCollectionItemType f13289d;
        @Nullable
        private DefaultImageFieldsModel f13290e;
        @Nullable
        private String f13291f;
        @Nullable
        private DefaultImageFieldsModel f13292g;
        @Nullable
        private String f13293h;
        @Nullable
        private CollectionItemNodeFieldsModel f13294i;
        @Nullable
        private RatingModel f13295j;
        @Nullable
        private DefaultTextWithEntitiesFieldsModel f13296k;
        @Nullable
        private DefaultImageFieldsModel f13297l;
        @Nullable
        private TitleModel f13298m;
        @Nullable
        private String f13299n;

        /* compiled from: MarketplaceLocationDialogCancelled */
        public final class Builder {
            @Nullable
            public GraphQLTimelineAppCollectionItemType f13244a;
            @Nullable
            public DefaultImageFieldsModel f13245b;
            @Nullable
            public String f13246c;
            @Nullable
            public DefaultImageFieldsModel f13247d;
            @Nullable
            public String f13248e;
            @Nullable
            public CollectionItemNodeFieldsModel f13249f;
            @Nullable
            public RatingModel f13250g;
            @Nullable
            public DefaultTextWithEntitiesFieldsModel f13251h;
            @Nullable
            public DefaultImageFieldsModel f13252i;
            @Nullable
            public TitleModel f13253j;
            @Nullable
            public String f13254k;
        }

        /* compiled from: MarketplaceLocationDialogCancelled */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(AppCollectionItemModel.class, new Deserializer());
            }

            public Object m14226a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(AppCollectionItemParser.m14453b(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object appCollectionItemModel = new AppCollectionItemModel();
                ((BaseModel) appCollectionItemModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (appCollectionItemModel instanceof Postprocessable) {
                    return ((Postprocessable) appCollectionItemModel).a();
                }
                return appCollectionItemModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 276562124)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: MarketplaceLocationDialogCancelled */
        public final class RatingModel extends BaseModel implements GraphQLVisitableModel {
            private double f13256d;

            /* compiled from: MarketplaceLocationDialogCancelled */
            public final class Builder {
                public double f13255a;
            }

            /* compiled from: MarketplaceLocationDialogCancelled */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(RatingModel.class, new Deserializer());
                }

                public Object m14227a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(RatingParser.m14445a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object ratingModel = new RatingModel();
                    ((BaseModel) ratingModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (ratingModel instanceof Postprocessable) {
                        return ((Postprocessable) ratingModel).a();
                    }
                    return ratingModel;
                }
            }

            /* compiled from: MarketplaceLocationDialogCancelled */
            public class Serializer extends JsonSerializer<RatingModel> {
                public final void m14228a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    RatingModel ratingModel = (RatingModel) obj;
                    if (ratingModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(ratingModel.m14231a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        ratingModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    RatingParser.m14446a(ratingModel.w_(), ratingModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(RatingModel.class, new Serializer());
                }
            }

            public RatingModel() {
                super(1);
            }

            public RatingModel(MutableFlatBuffer mutableFlatBuffer) {
                super(1);
                a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
            }

            public final double m14230a() {
                a(0, 0);
                return this.f13256d;
            }

            public static RatingModel m14229a(RatingModel ratingModel) {
                if (ratingModel == null) {
                    return null;
                }
                if (ratingModel instanceof RatingModel) {
                    return ratingModel;
                }
                Builder builder = new Builder();
                builder.f13255a = ratingModel.m14230a();
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.c(1);
                flatBufferBuilder.a(0, builder.f13255a, 0.0d);
                flatBufferBuilder.d(flatBufferBuilder.d());
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                return new RatingModel(new MutableFlatBuffer(wrap, null, null, true, null));
            }

            public final int jK_() {
                return -1854235203;
            }

            public final GraphQLVisitableModel m14232a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m14231a(FlatBufferBuilder flatBufferBuilder) {
                h();
                flatBufferBuilder.c(1);
                flatBufferBuilder.a(0, this.f13256d, 0.0d);
                i();
                return flatBufferBuilder.d();
            }

            public final void m14233a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                super.a(mutableFlatBuffer, i, obj);
                this.f13256d = mutableFlatBuffer.a(i, 0, 0.0d);
            }
        }

        /* compiled from: MarketplaceLocationDialogCancelled */
        public class Serializer extends JsonSerializer<AppCollectionItemModel> {
            public final void m14234a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                AppCollectionItemModel appCollectionItemModel = (AppCollectionItemModel) obj;
                if (appCollectionItemModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(appCollectionItemModel.m14288a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    appCollectionItemModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                AppCollectionItemParser.m14454b(appCollectionItemModel.w_(), appCollectionItemModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(AppCollectionItemModel.class, new Serializer());
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 192071497)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: MarketplaceLocationDialogCancelled */
        public final class TitleModel extends BaseModel implements DefaultTextWithEntitiesLongFields, GraphQLVisitableModel, LinkableUtilApplyActorsLinksGraphQL {
            @Nullable
            private List<RangesModel> f13287d;
            @Nullable
            private String f13288e;

            /* compiled from: MarketplaceLocationDialogCancelled */
            public final class Builder {
                @Nullable
                public ImmutableList<RangesModel> f13257a;
                @Nullable
                public String f13258b;
            }

            /* compiled from: MarketplaceLocationDialogCancelled */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(TitleModel.class, new Deserializer());
                }

                public Object m14235a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(TitleParser.m14451a(jsonParser, flatBufferBuilder));
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

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = 468395731)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: MarketplaceLocationDialogCancelled */
            public final class RangesModel extends BaseModel implements Ranges, GraphQLVisitableModel, LinkableUtilApplyActorsLinksGraphQL.Ranges {
                @Nullable
                private EntityModel f13284d;
                private int f13285e;
                private int f13286f;

                /* compiled from: MarketplaceLocationDialogCancelled */
                public final class Builder {
                    @Nullable
                    public EntityModel f13259a;
                    public int f13260b;
                    public int f13261c;
                }

                /* compiled from: MarketplaceLocationDialogCancelled */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(RangesModel.class, new Deserializer());
                    }

                    public Object m14236a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(RangesParser.m14449b(jsonParser, flatBufferBuilder));
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
                @ModelWithFlatBufferFormatHash(a = -1671914308)
                @JsonSerialize(using = Serializer.class)
                @FragmentModelWithoutBridge
                /* compiled from: MarketplaceLocationDialogCancelled */
                public final class EntityModel extends BaseModel implements DefaultTextWithEntitiesEntityFields, GraphQLPersistableNode, GraphQLVisitableConsistentModel, Entity {
                    @Nullable
                    private GraphQLObjectType f13273d;
                    @Nullable
                    private List<String> f13274e;
                    @Nullable
                    private AppSectionModel f13275f;
                    @Nullable
                    private GetNativeAppDetailsAppStoreApplicationGraphQLModel f13276g;
                    @Nullable
                    private String f13277h;
                    @Nullable
                    private String f13278i;
                    @Nullable
                    private PageModel f13279j;
                    @Nullable
                    private ProfilePictureModel f13280k;
                    @Nullable
                    private List<RedirectionInfoModel> f13281l;
                    @Nullable
                    private String f13282m;
                    @Nullable
                    private String f13283n;

                    /* compiled from: MarketplaceLocationDialogCancelled */
                    public final class Builder {
                        @Nullable
                        public GraphQLObjectType f13262a;
                        @Nullable
                        public ImmutableList<String> f13263b;
                        @Nullable
                        public AppSectionModel f13264c;
                        @Nullable
                        public GetNativeAppDetailsAppStoreApplicationGraphQLModel f13265d;
                        @Nullable
                        public String f13266e;
                        @Nullable
                        public String f13267f;
                        @Nullable
                        public PageModel f13268g;
                        @Nullable
                        public ProfilePictureModel f13269h;
                        @Nullable
                        public ImmutableList<RedirectionInfoModel> f13270i;
                        @Nullable
                        public String f13271j;
                        @Nullable
                        public String f13272k;

                        public final EntityModel m14237a() {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            int a = ModelHelper.a(flatBufferBuilder, this.f13262a);
                            int c = flatBufferBuilder.c(this.f13263b);
                            int a2 = ModelHelper.a(flatBufferBuilder, this.f13264c);
                            int a3 = ModelHelper.a(flatBufferBuilder, this.f13265d);
                            int b = flatBufferBuilder.b(this.f13266e);
                            int b2 = flatBufferBuilder.b(this.f13267f);
                            int a4 = ModelHelper.a(flatBufferBuilder, this.f13268g);
                            int a5 = ModelHelper.a(flatBufferBuilder, this.f13269h);
                            int a6 = ModelHelper.a(flatBufferBuilder, this.f13270i);
                            int b3 = flatBufferBuilder.b(this.f13271j);
                            int b4 = flatBufferBuilder.b(this.f13272k);
                            flatBufferBuilder.c(11);
                            flatBufferBuilder.b(0, a);
                            flatBufferBuilder.b(1, c);
                            flatBufferBuilder.b(2, a2);
                            flatBufferBuilder.b(3, a3);
                            flatBufferBuilder.b(4, b);
                            flatBufferBuilder.b(5, b2);
                            flatBufferBuilder.b(6, a4);
                            flatBufferBuilder.b(7, a5);
                            flatBufferBuilder.b(8, a6);
                            flatBufferBuilder.b(9, b3);
                            flatBufferBuilder.b(10, b4);
                            flatBufferBuilder.d(flatBufferBuilder.d());
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            return new EntityModel(new MutableFlatBuffer(wrap, null, null, true, null));
                        }
                    }

                    /* compiled from: MarketplaceLocationDialogCancelled */
                    public class Deserializer extends FbJsonDeserializer {
                        static {
                            GlobalAutoGenDeserializerCache.a(EntityModel.class, new Deserializer());
                        }

                        public Object m14238a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(EntityParser.m14447a(jsonParser, flatBufferBuilder));
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

                    /* compiled from: MarketplaceLocationDialogCancelled */
                    public class Serializer extends JsonSerializer<EntityModel> {
                        public final void m14239a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                            EntityModel entityModel = (EntityModel) obj;
                            if (entityModel.w_() == null) {
                                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                flatBufferBuilder.d(entityModel.m14245a(flatBufferBuilder));
                                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                wrap.position(0);
                                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                entityModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                            }
                            EntityParser.m14448a(entityModel.w_(), entityModel.u_(), jsonGenerator, serializerProvider);
                        }

                        static {
                            FbSerializerProvider.a(EntityModel.class, new Serializer());
                        }
                    }

                    @Nullable
                    public final /* synthetic */ ProfilePicture ad_() {
                        return m14244t();
                    }

                    @Nullable
                    public final /* synthetic */ Page m14254j() {
                        return m14243s();
                    }

                    @Nullable
                    public final /* synthetic */ GetNativeAppDetailsActorGraphQL.ProfilePicture m14256l() {
                        return m14244t();
                    }

                    @Nullable
                    public final /* synthetic */ GetNativeAppDetailsAppStoreApplicationGraphQLModel m14257m() {
                        return m14242r();
                    }

                    @Nullable
                    public final /* synthetic */ Entity.Page m14258n() {
                        return m14243s();
                    }

                    @Nullable
                    public final /* synthetic */ AppSectionModel m14259o() {
                        return m14241q();
                    }

                    @Nullable
                    public final /* synthetic */ ProfilePictureModel m14260p() {
                        return m14244t();
                    }

                    public EntityModel() {
                        super(11);
                    }

                    public EntityModel(MutableFlatBuffer mutableFlatBuffer) {
                        super(11);
                        a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }

                    public final void m14248a(String str, ConsistencyTuple consistencyTuple) {
                        consistencyTuple.a();
                    }

                    public final void m14249a(String str, Object obj, boolean z) {
                    }

                    @Nullable
                    public final GraphQLObjectType m14250b() {
                        if (this.b != null && this.f13273d == null) {
                            this.f13273d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
                        }
                        return this.f13273d;
                    }

                    @Nonnull
                    public final ImmutableList<String> m14251c() {
                        this.f13274e = super.a(this.f13274e, 1);
                        return (ImmutableList) this.f13274e;
                    }

                    @Nullable
                    private AppSectionModel m14241q() {
                        this.f13275f = (AppSectionModel) super.a(this.f13275f, 2, AppSectionModel.class);
                        return this.f13275f;
                    }

                    @Nullable
                    private GetNativeAppDetailsAppStoreApplicationGraphQLModel m14242r() {
                        this.f13276g = (GetNativeAppDetailsAppStoreApplicationGraphQLModel) super.a(this.f13276g, 3, GetNativeAppDetailsAppStoreApplicationGraphQLModel.class);
                        return this.f13276g;
                    }

                    @Nullable
                    public final String m14252d() {
                        this.f13277h = super.a(this.f13277h, 4);
                        return this.f13277h;
                    }

                    @Nullable
                    public final String C_() {
                        this.f13278i = super.a(this.f13278i, 5);
                        return this.f13278i;
                    }

                    @Nullable
                    private PageModel m14243s() {
                        this.f13279j = (PageModel) super.a(this.f13279j, 6, PageModel.class);
                        return this.f13279j;
                    }

                    @Nullable
                    private ProfilePictureModel m14244t() {
                        this.f13280k = (ProfilePictureModel) super.a(this.f13280k, 7, ProfilePictureModel.class);
                        return this.f13280k;
                    }

                    @Nonnull
                    public final ImmutableList<RedirectionInfoModel> m14255k() {
                        this.f13281l = super.a(this.f13281l, 8, RedirectionInfoModel.class);
                        return (ImmutableList) this.f13281l;
                    }

                    @Nullable
                    public final String m14253g() {
                        this.f13282m = super.a(this.f13282m, 9);
                        return this.f13282m;
                    }

                    @Nullable
                    public final String D_() {
                        this.f13283n = super.a(this.f13283n, 10);
                        return this.f13283n;
                    }

                    public static EntityModel m14240a(EntityModel entityModel) {
                        int i = 0;
                        if (entityModel == null) {
                            return null;
                        }
                        if (entityModel instanceof EntityModel) {
                            return entityModel;
                        }
                        Builder builder = new Builder();
                        builder.f13262a = entityModel.m14250b();
                        com.google.common.collect.ImmutableList.Builder builder2 = ImmutableList.builder();
                        for (int i2 = 0; i2 < entityModel.m14251c().size(); i2++) {
                            builder2.c(entityModel.m14251c().get(i2));
                        }
                        builder.f13263b = builder2.b();
                        builder.f13264c = AppSectionModel.a(entityModel.m14259o());
                        builder.f13265d = GetNativeAppDetailsAppStoreApplicationGraphQLModel.a(entityModel.m14257m());
                        builder.f13266e = entityModel.m14252d();
                        builder.f13267f = entityModel.C_();
                        builder.f13268g = PageModel.a(entityModel.m14258n());
                        builder.f13269h = ProfilePictureModel.a(entityModel.m14260p());
                        builder2 = ImmutableList.builder();
                        while (i < entityModel.m14255k().size()) {
                            builder2.c(RedirectionInfoModel.a((RedirectionInfoModel) entityModel.m14255k().get(i)));
                            i++;
                        }
                        builder.f13270i = builder2.b();
                        builder.f13271j = entityModel.m14253g();
                        builder.f13272k = entityModel.D_();
                        return builder.m14237a();
                    }

                    @Nullable
                    public final String m14247a() {
                        return m14252d();
                    }

                    public final int jK_() {
                        return 2080559107;
                    }

                    public final GraphQLVisitableModel m14246a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                        GraphQLVisitableModel graphQLVisitableModel = null;
                        h();
                        if (m14241q() != null) {
                            AppSectionModel appSectionModel = (AppSectionModel) graphQLModelMutatingVisitor.b(m14241q());
                            if (m14241q() != appSectionModel) {
                                graphQLVisitableModel = (EntityModel) ModelHelper.a(null, this);
                                graphQLVisitableModel.f13275f = appSectionModel;
                            }
                        }
                        if (m14242r() != null) {
                            GetNativeAppDetailsAppStoreApplicationGraphQLModel getNativeAppDetailsAppStoreApplicationGraphQLModel = (GetNativeAppDetailsAppStoreApplicationGraphQLModel) graphQLModelMutatingVisitor.b(m14242r());
                            if (m14242r() != getNativeAppDetailsAppStoreApplicationGraphQLModel) {
                                graphQLVisitableModel = (EntityModel) ModelHelper.a(graphQLVisitableModel, this);
                                graphQLVisitableModel.f13276g = getNativeAppDetailsAppStoreApplicationGraphQLModel;
                            }
                        }
                        if (m14243s() != null) {
                            PageModel pageModel = (PageModel) graphQLModelMutatingVisitor.b(m14243s());
                            if (m14243s() != pageModel) {
                                graphQLVisitableModel = (EntityModel) ModelHelper.a(graphQLVisitableModel, this);
                                graphQLVisitableModel.f13279j = pageModel;
                            }
                        }
                        if (m14244t() != null) {
                            ProfilePictureModel profilePictureModel = (ProfilePictureModel) graphQLModelMutatingVisitor.b(m14244t());
                            if (m14244t() != profilePictureModel) {
                                graphQLVisitableModel = (EntityModel) ModelHelper.a(graphQLVisitableModel, this);
                                graphQLVisitableModel.f13280k = profilePictureModel;
                            }
                        }
                        if (m14255k() != null) {
                            com.google.common.collect.ImmutableList.Builder a = ModelHelper.a(m14255k(), graphQLModelMutatingVisitor);
                            if (a != null) {
                                EntityModel entityModel = (EntityModel) ModelHelper.a(graphQLVisitableModel, this);
                                entityModel.f13281l = a.b();
                                graphQLVisitableModel = entityModel;
                            }
                        }
                        i();
                        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                    }

                    public final int m14245a(FlatBufferBuilder flatBufferBuilder) {
                        h();
                        int a = ModelHelper.a(flatBufferBuilder, m14250b());
                        int c = flatBufferBuilder.c(m14251c());
                        int a2 = ModelHelper.a(flatBufferBuilder, m14241q());
                        int a3 = ModelHelper.a(flatBufferBuilder, m14242r());
                        int b = flatBufferBuilder.b(m14252d());
                        int b2 = flatBufferBuilder.b(C_());
                        int a4 = ModelHelper.a(flatBufferBuilder, m14243s());
                        int a5 = ModelHelper.a(flatBufferBuilder, m14244t());
                        int a6 = ModelHelper.a(flatBufferBuilder, m14255k());
                        int b3 = flatBufferBuilder.b(m14253g());
                        int b4 = flatBufferBuilder.b(D_());
                        flatBufferBuilder.c(11);
                        flatBufferBuilder.b(0, a);
                        flatBufferBuilder.b(1, c);
                        flatBufferBuilder.b(2, a2);
                        flatBufferBuilder.b(3, a3);
                        flatBufferBuilder.b(4, b);
                        flatBufferBuilder.b(5, b2);
                        flatBufferBuilder.b(6, a4);
                        flatBufferBuilder.b(7, a5);
                        flatBufferBuilder.b(8, a6);
                        flatBufferBuilder.b(9, b3);
                        flatBufferBuilder.b(10, b4);
                        i();
                        return flatBufferBuilder.d();
                    }
                }

                /* compiled from: MarketplaceLocationDialogCancelled */
                public class Serializer extends JsonSerializer<RangesModel> {
                    public final void m14261a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        RangesModel rangesModel = (RangesModel) obj;
                        if (rangesModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(rangesModel.m14264a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            rangesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        RangesParser.m14450b(rangesModel.w_(), rangesModel.u_(), jsonGenerator, serializerProvider);
                    }

                    static {
                        FbSerializerProvider.a(RangesModel.class, new Serializer());
                    }
                }

                @Nullable
                public final /* synthetic */ DefaultTextWithEntitiesEntityFields m14265a() {
                    return m14263k();
                }

                @Nullable
                public final /* synthetic */ Entity m14270d() {
                    return m14263k();
                }

                @Nullable
                public final /* synthetic */ LinkableUtilApplyClickableLinkSpanWithEntityGraphQL.Entity dG_() {
                    return m14263k();
                }

                @Nullable
                public final /* synthetic */ LinkableUtilApplyHashtagLinkGraphQL.Entity dH_() {
                    return m14263k();
                }

                @Nullable
                public final /* synthetic */ LinkableUtilShouldFormatAsExternalLinkGraphQL.Entity dI_() {
                    return m14263k();
                }

                @Nullable
                public final /* synthetic */ LinkableUtilApplyFamilyNonUserMemberLinkGraphQL.Entity m14271g() {
                    return m14263k();
                }

                @Nullable
                public final /* synthetic */ EntityModel m14272j() {
                    return m14263k();
                }

                public RangesModel() {
                    super(3);
                }

                public RangesModel(MutableFlatBuffer mutableFlatBuffer) {
                    super(3);
                    a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }

                @Nullable
                private EntityModel m14263k() {
                    this.f13284d = (EntityModel) super.a(this.f13284d, 0, EntityModel.class);
                    return this.f13284d;
                }

                public final int m14268b() {
                    a(0, 1);
                    return this.f13285e;
                }

                public final int m14269c() {
                    a(0, 2);
                    return this.f13286f;
                }

                public static RangesModel m14262a(RangesModel rangesModel) {
                    if (rangesModel == null) {
                        return null;
                    }
                    if (rangesModel instanceof RangesModel) {
                        return rangesModel;
                    }
                    Builder builder = new Builder();
                    builder.f13259a = EntityModel.m14240a(rangesModel.m14272j());
                    builder.f13260b = rangesModel.m14268b();
                    builder.f13261c = rangesModel.m14269c();
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    int a = ModelHelper.a(flatBufferBuilder, builder.f13259a);
                    flatBufferBuilder.c(3);
                    flatBufferBuilder.b(0, a);
                    flatBufferBuilder.a(1, builder.f13260b, 0);
                    flatBufferBuilder.a(2, builder.f13261c, 0);
                    flatBufferBuilder.d(flatBufferBuilder.d());
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    return new RangesModel(new MutableFlatBuffer(wrap, null, null, true, null));
                }

                public final int jK_() {
                    return -1024511161;
                }

                public final GraphQLVisitableModel m14266a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    GraphQLVisitableModel graphQLVisitableModel = null;
                    h();
                    if (m14263k() != null) {
                        EntityModel entityModel = (EntityModel) graphQLModelMutatingVisitor.b(m14263k());
                        if (m14263k() != entityModel) {
                            graphQLVisitableModel = (RangesModel) ModelHelper.a(null, this);
                            graphQLVisitableModel.f13284d = entityModel;
                        }
                    }
                    i();
                    return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                }

                public final int m14264a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int a = ModelHelper.a(flatBufferBuilder, m14263k());
                    flatBufferBuilder.c(3);
                    flatBufferBuilder.b(0, a);
                    flatBufferBuilder.a(1, this.f13285e, 0);
                    flatBufferBuilder.a(2, this.f13286f, 0);
                    i();
                    return flatBufferBuilder.d();
                }

                public final void m14267a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                    super.a(mutableFlatBuffer, i, obj);
                    this.f13285e = mutableFlatBuffer.a(i, 1, 0);
                    this.f13286f = mutableFlatBuffer.a(i, 2, 0);
                }
            }

            /* compiled from: MarketplaceLocationDialogCancelled */
            public class Serializer extends JsonSerializer<TitleModel> {
                public final void m14273a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    TitleModel titleModel = (TitleModel) obj;
                    if (titleModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(titleModel.m14275a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        titleModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    TitleParser.m14452a(titleModel.w_(), titleModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(TitleModel.class, new Serializer());
                }
            }

            public TitleModel() {
                super(2);
            }

            public TitleModel(MutableFlatBuffer mutableFlatBuffer) {
                super(2);
                a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
            }

            @Nonnull
            public final ImmutableList<RangesModel> m14278b() {
                this.f13287d = super.a(this.f13287d, 0, RangesModel.class);
                return (ImmutableList) this.f13287d;
            }

            @Nullable
            public final String m14277a() {
                this.f13288e = super.a(this.f13288e, 1);
                return this.f13288e;
            }

            public static TitleModel m14274a(TitleModel titleModel) {
                if (titleModel == null) {
                    return null;
                }
                if (titleModel instanceof TitleModel) {
                    return titleModel;
                }
                Builder builder = new Builder();
                com.google.common.collect.ImmutableList.Builder builder2 = ImmutableList.builder();
                for (int i = 0; i < titleModel.m14278b().size(); i++) {
                    builder2.c(RangesModel.m14262a((RangesModel) titleModel.m14278b().get(i)));
                }
                builder.f13257a = builder2.b();
                builder.f13258b = titleModel.m14277a();
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                int a = ModelHelper.a(flatBufferBuilder, builder.f13257a);
                int b = flatBufferBuilder.b(builder.f13258b);
                flatBufferBuilder.c(2);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.b(1, b);
                flatBufferBuilder.d(flatBufferBuilder.d());
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                return new TitleModel(new MutableFlatBuffer(wrap, null, null, true, null));
            }

            public final int jK_() {
                return -1919764332;
            }

            public final GraphQLVisitableModel m14276a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m14278b() != null) {
                    com.google.common.collect.ImmutableList.Builder a = ModelHelper.a(m14278b(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        graphQLVisitableModel = (TitleModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f13287d = a.b();
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m14275a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m14278b());
                int b = flatBufferBuilder.b(m14277a());
                flatBufferBuilder.c(2);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.b(1, b);
                i();
                return flatBufferBuilder.d();
            }
        }

        @Nullable
        public final /* synthetic */ DefaultImageFields m14294c() {
            return m14281n();
        }

        @Nullable
        public final /* synthetic */ DefaultTextWithEntitiesFields m14297j() {
            return m14285r();
        }

        @Nullable
        public final /* synthetic */ DefaultImageFields m14298k() {
            return m14286s();
        }

        @Nullable
        public final /* synthetic */ TitleModel m14299l() {
            return m14287t();
        }

        @Nullable
        public final /* synthetic */ RatingModel nG_() {
            return m14284q();
        }

        @Nullable
        public final /* synthetic */ CollectionItemNodeFieldsModel nH_() {
            return m14283p();
        }

        @Nullable
        public final /* synthetic */ DefaultImageFields nI_() {
            return m14282o();
        }

        public AppCollectionItemModel() {
            super(11);
        }

        public AppCollectionItemModel(MutableFlatBuffer mutableFlatBuffer) {
            super(11);
            a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
        }

        public final void m14291a(String str, ConsistencyTuple consistencyTuple) {
            if ("locally_updated_containing_collection_id".equals(str)) {
                consistencyTuple.a = mo385g();
                consistencyTuple.b = u_();
                consistencyTuple.c = 4;
                return;
            }
            consistencyTuple.a();
        }

        public final void m14292a(String str, Object obj, boolean z) {
            if ("locally_updated_containing_collection_id".equals(str)) {
                m14280a((String) obj);
            }
        }

        @Nullable
        public final GraphQLTimelineAppCollectionItemType m14293b() {
            this.f13289d = (GraphQLTimelineAppCollectionItemType) super.b(this.f13289d, 0, GraphQLTimelineAppCollectionItemType.class, GraphQLTimelineAppCollectionItemType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
            return this.f13289d;
        }

        @Nullable
        private DefaultImageFieldsModel m14281n() {
            this.f13290e = (DefaultImageFieldsModel) super.a(this.f13290e, 1, DefaultImageFieldsModel.class);
            return this.f13290e;
        }

        @Nullable
        public final String mo384d() {
            this.f13291f = super.a(this.f13291f, 2);
            return this.f13291f;
        }

        @Nullable
        private DefaultImageFieldsModel m14282o() {
            this.f13292g = (DefaultImageFieldsModel) super.a(this.f13292g, 3, DefaultImageFieldsModel.class);
            return this.f13292g;
        }

        @Nullable
        public final String mo385g() {
            this.f13293h = super.a(this.f13293h, 4);
            return this.f13293h;
        }

        private void m14280a(@Nullable String str) {
            this.f13293h = str;
            if (this.b != null && this.b.d) {
                this.b.a(this.c, 4, str);
            }
        }

        @Nullable
        private CollectionItemNodeFieldsModel m14283p() {
            this.f13294i = (CollectionItemNodeFieldsModel) super.a(this.f13294i, 5, CollectionItemNodeFieldsModel.class);
            return this.f13294i;
        }

        @Nullable
        private RatingModel m14284q() {
            this.f13295j = (RatingModel) super.a(this.f13295j, 6, RatingModel.class);
            return this.f13295j;
        }

        @Nullable
        private DefaultTextWithEntitiesFieldsModel m14285r() {
            this.f13296k = (DefaultTextWithEntitiesFieldsModel) super.a(this.f13296k, 7, DefaultTextWithEntitiesFieldsModel.class);
            return this.f13296k;
        }

        @Nullable
        private DefaultImageFieldsModel m14286s() {
            this.f13297l = (DefaultImageFieldsModel) super.a(this.f13297l, 8, DefaultImageFieldsModel.class);
            return this.f13297l;
        }

        @Nullable
        private TitleModel m14287t() {
            this.f13298m = (TitleModel) super.a(this.f13298m, 9, TitleModel.class);
            return this.f13298m;
        }

        @Nullable
        public final String m14300m() {
            this.f13299n = super.a(this.f13299n, 10);
            return this.f13299n;
        }

        public static AppCollectionItemModel m14279a(AppCollectionItemModel appCollectionItemModel) {
            if (appCollectionItemModel == null) {
                return null;
            }
            if (appCollectionItemModel instanceof AppCollectionItemModel) {
                return appCollectionItemModel;
            }
            Builder builder = new Builder();
            builder.f13244a = appCollectionItemModel.m14293b();
            builder.f13245b = DefaultImageFieldsModel.a(appCollectionItemModel.m14294c());
            builder.f13246c = appCollectionItemModel.mo384d();
            builder.f13247d = DefaultImageFieldsModel.a(appCollectionItemModel.nI_());
            builder.f13248e = appCollectionItemModel.mo385g();
            builder.f13249f = CollectionItemNodeFieldsModel.m14359a(appCollectionItemModel.nH_());
            builder.f13250g = RatingModel.m14229a(appCollectionItemModel.nG_());
            builder.f13251h = DefaultTextWithEntitiesFieldsModel.a(appCollectionItemModel.m14297j());
            builder.f13252i = DefaultImageFieldsModel.a(appCollectionItemModel.m14298k());
            builder.f13253j = TitleModel.m14274a(appCollectionItemModel.m14299l());
            builder.f13254k = appCollectionItemModel.m14300m();
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
            int a = flatBufferBuilder.a(builder.f13244a);
            int a2 = ModelHelper.a(flatBufferBuilder, builder.f13245b);
            int b = flatBufferBuilder.b(builder.f13246c);
            int a3 = ModelHelper.a(flatBufferBuilder, builder.f13247d);
            int b2 = flatBufferBuilder.b(builder.f13248e);
            int a4 = ModelHelper.a(flatBufferBuilder, builder.f13249f);
            int a5 = ModelHelper.a(flatBufferBuilder, builder.f13250g);
            int a6 = ModelHelper.a(flatBufferBuilder, builder.f13251h);
            int a7 = ModelHelper.a(flatBufferBuilder, builder.f13252i);
            int a8 = ModelHelper.a(flatBufferBuilder, builder.f13253j);
            int b3 = flatBufferBuilder.b(builder.f13254k);
            flatBufferBuilder.c(11);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, a2);
            flatBufferBuilder.b(2, b);
            flatBufferBuilder.b(3, a3);
            flatBufferBuilder.b(4, b2);
            flatBufferBuilder.b(5, a4);
            flatBufferBuilder.b(6, a5);
            flatBufferBuilder.b(7, a6);
            flatBufferBuilder.b(8, a7);
            flatBufferBuilder.b(9, a8);
            flatBufferBuilder.b(10, b3);
            flatBufferBuilder.d(flatBufferBuilder.d());
            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
            wrap.position(0);
            return new AppCollectionItemModel(new MutableFlatBuffer(wrap, null, null, true, null));
        }

        @Nullable
        public final String m14290a() {
            return mo384d();
        }

        public final int jK_() {
            return -154776335;
        }

        public final GraphQLVisitableModel m14289a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            DefaultImageFieldsModel defaultImageFieldsModel;
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m14281n() != null) {
                defaultImageFieldsModel = (DefaultImageFieldsModel) graphQLModelMutatingVisitor.b(m14281n());
                if (m14281n() != defaultImageFieldsModel) {
                    graphQLVisitableModel = (AppCollectionItemModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f13290e = defaultImageFieldsModel;
                }
            }
            if (m14282o() != null) {
                defaultImageFieldsModel = (DefaultImageFieldsModel) graphQLModelMutatingVisitor.b(m14282o());
                if (m14282o() != defaultImageFieldsModel) {
                    graphQLVisitableModel = (AppCollectionItemModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f13292g = defaultImageFieldsModel;
                }
            }
            if (m14283p() != null) {
                CollectionItemNodeFieldsModel collectionItemNodeFieldsModel = (CollectionItemNodeFieldsModel) graphQLModelMutatingVisitor.b(m14283p());
                if (m14283p() != collectionItemNodeFieldsModel) {
                    graphQLVisitableModel = (AppCollectionItemModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f13294i = collectionItemNodeFieldsModel;
                }
            }
            if (m14284q() != null) {
                RatingModel ratingModel = (RatingModel) graphQLModelMutatingVisitor.b(m14284q());
                if (m14284q() != ratingModel) {
                    graphQLVisitableModel = (AppCollectionItemModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f13295j = ratingModel;
                }
            }
            if (m14285r() != null) {
                DefaultTextWithEntitiesFieldsModel defaultTextWithEntitiesFieldsModel = (DefaultTextWithEntitiesFieldsModel) graphQLModelMutatingVisitor.b(m14285r());
                if (m14285r() != defaultTextWithEntitiesFieldsModel) {
                    graphQLVisitableModel = (AppCollectionItemModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f13296k = defaultTextWithEntitiesFieldsModel;
                }
            }
            if (m14286s() != null) {
                defaultImageFieldsModel = (DefaultImageFieldsModel) graphQLModelMutatingVisitor.b(m14286s());
                if (m14286s() != defaultImageFieldsModel) {
                    graphQLVisitableModel = (AppCollectionItemModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f13297l = defaultImageFieldsModel;
                }
            }
            if (m14287t() != null) {
                TitleModel titleModel = (TitleModel) graphQLModelMutatingVisitor.b(m14287t());
                if (m14287t() != titleModel) {
                    graphQLVisitableModel = (AppCollectionItemModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f13298m = titleModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m14288a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = flatBufferBuilder.a(m14293b());
            int a2 = ModelHelper.a(flatBufferBuilder, m14281n());
            int b = flatBufferBuilder.b(mo384d());
            int a3 = ModelHelper.a(flatBufferBuilder, m14282o());
            int b2 = flatBufferBuilder.b(mo385g());
            int a4 = ModelHelper.a(flatBufferBuilder, m14283p());
            int a5 = ModelHelper.a(flatBufferBuilder, m14284q());
            int a6 = ModelHelper.a(flatBufferBuilder, m14285r());
            int a7 = ModelHelper.a(flatBufferBuilder, m14286s());
            int a8 = ModelHelper.a(flatBufferBuilder, m14287t());
            int b3 = flatBufferBuilder.b(m14300m());
            flatBufferBuilder.c(11);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, a2);
            flatBufferBuilder.b(2, b);
            flatBufferBuilder.b(3, a3);
            flatBufferBuilder.b(4, b2);
            flatBufferBuilder.b(5, a4);
            flatBufferBuilder.b(6, a5);
            flatBufferBuilder.b(7, a6);
            flatBufferBuilder.b(8, a7);
            flatBufferBuilder.b(9, a8);
            flatBufferBuilder.b(10, b3);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -1067712738)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: MarketplaceLocationDialogCancelled */
    public final class AppCollectionSuggestionContainingMutationFieldsModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel, AppCollectionSuggestionContainingMutationFields {
        @Nullable
        private String f13302d;
        @Nullable
        private String f13303e;

        /* compiled from: MarketplaceLocationDialogCancelled */
        public final class Builder {
            @Nullable
            public String f13300a;
            @Nullable
            public String f13301b;

            public final AppCollectionSuggestionContainingMutationFieldsModel m14301a() {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                int b = flatBufferBuilder.b(this.f13300a);
                int b2 = flatBufferBuilder.b(this.f13301b);
                flatBufferBuilder.c(2);
                flatBufferBuilder.b(0, b);
                flatBufferBuilder.b(1, b2);
                flatBufferBuilder.d(flatBufferBuilder.d());
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                return new AppCollectionSuggestionContainingMutationFieldsModel(new MutableFlatBuffer(wrap, null, null, true, null));
            }
        }

        /* compiled from: MarketplaceLocationDialogCancelled */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(AppCollectionSuggestionContainingMutationFieldsModel.class, new Deserializer());
            }

            public Object m14302a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = AppCollectionSuggestionContainingMutationFieldsParser.m14455a(jsonParser);
                Object appCollectionSuggestionContainingMutationFieldsModel = new AppCollectionSuggestionContainingMutationFieldsModel();
                ((BaseModel) appCollectionSuggestionContainingMutationFieldsModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (appCollectionSuggestionContainingMutationFieldsModel instanceof Postprocessable) {
                    return ((Postprocessable) appCollectionSuggestionContainingMutationFieldsModel).a();
                }
                return appCollectionSuggestionContainingMutationFieldsModel;
            }
        }

        /* compiled from: MarketplaceLocationDialogCancelled */
        public class Serializer extends JsonSerializer<AppCollectionSuggestionContainingMutationFieldsModel> {
            public final void m14303a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                AppCollectionSuggestionContainingMutationFieldsModel appCollectionSuggestionContainingMutationFieldsModel = (AppCollectionSuggestionContainingMutationFieldsModel) obj;
                if (appCollectionSuggestionContainingMutationFieldsModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(appCollectionSuggestionContainingMutationFieldsModel.m14305a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    appCollectionSuggestionContainingMutationFieldsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = appCollectionSuggestionContainingMutationFieldsModel.w_();
                int u_ = appCollectionSuggestionContainingMutationFieldsModel.u_();
                jsonGenerator.f();
                if (mutableFlatBuffer.g(u_, 0) != 0) {
                    jsonGenerator.a("id");
                    jsonGenerator.b(mutableFlatBuffer.c(u_, 0));
                }
                if (mutableFlatBuffer.g(u_, 1) != 0) {
                    jsonGenerator.a("locally_updated_containing_collection_id");
                    jsonGenerator.b(mutableFlatBuffer.c(u_, 1));
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(AppCollectionSuggestionContainingMutationFieldsModel.class, new Serializer());
            }
        }

        public AppCollectionSuggestionContainingMutationFieldsModel() {
            super(2);
        }

        public AppCollectionSuggestionContainingMutationFieldsModel(MutableFlatBuffer mutableFlatBuffer) {
            super(2);
            a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
        }

        public final void m14308a(String str, ConsistencyTuple consistencyTuple) {
            consistencyTuple.a();
        }

        public final void m14309a(String str, Object obj, boolean z) {
        }

        @Nullable
        public final String mo386b() {
            this.f13302d = super.a(this.f13302d, 0);
            return this.f13302d;
        }

        @Nullable
        public final String mo387c() {
            this.f13303e = super.a(this.f13303e, 1);
            return this.f13303e;
        }

        public static AppCollectionSuggestionContainingMutationFieldsModel m14304a(AppCollectionSuggestionContainingMutationFields appCollectionSuggestionContainingMutationFields) {
            if (appCollectionSuggestionContainingMutationFields == null) {
                return null;
            }
            if (appCollectionSuggestionContainingMutationFields instanceof AppCollectionSuggestionContainingMutationFieldsModel) {
                return (AppCollectionSuggestionContainingMutationFieldsModel) appCollectionSuggestionContainingMutationFields;
            }
            Builder builder = new Builder();
            builder.f13300a = appCollectionSuggestionContainingMutationFields.mo386b();
            builder.f13301b = appCollectionSuggestionContainingMutationFields.mo387c();
            return builder.m14301a();
        }

        @Nullable
        public final String m14307a() {
            return mo386b();
        }

        public final int jK_() {
            return 2479791;
        }

        public final GraphQLVisitableModel m14306a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            h();
            i();
            return this;
        }

        public final int m14305a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(mo386b());
            int b2 = flatBufferBuilder.b(mo387c());
            flatBufferBuilder.c(2);
            flatBufferBuilder.b(0, b);
            flatBufferBuilder.b(1, b2);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 940141822)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: MarketplaceLocationDialogCancelled */
    public final class AppCollectionSuggestionFieldsModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel, AppCollectionSuggestionContainingMutationFields {
        @Nullable
        private GraphQLObjectType f13314d;
        @Nullable
        private List<String> f13315e;
        @Nullable
        private String f13316f;
        @Nullable
        private String f13317g;
        @Nullable
        private String f13318h;
        @Nullable
        private String f13319i;
        @Nullable
        private DefaultImageFieldsModel f13320j;
        @Nullable
        private String f13321k;
        @Nullable
        private List<SavableTimelineAppCollectionModel> f13322l;
        @Nullable
        private List<SavableTimelineAppCollectionModel> f13323m;

        /* compiled from: MarketplaceLocationDialogCancelled */
        public final class Builder {
            @Nullable
            public GraphQLObjectType f13304a;
            @Nullable
            public ImmutableList<String> f13305b;
            @Nullable
            public String f13306c;
            @Nullable
            public String f13307d;
            @Nullable
            public String f13308e;
            @Nullable
            public String f13309f;
            @Nullable
            public DefaultImageFieldsModel f13310g;
            @Nullable
            public String f13311h;
            @Nullable
            public ImmutableList<SavableTimelineAppCollectionModel> f13312i;
            @Nullable
            public ImmutableList<SavableTimelineAppCollectionModel> f13313j;

            public final AppCollectionSuggestionFieldsModel m14312a() {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                int a = ModelHelper.a(flatBufferBuilder, this.f13304a);
                int c = flatBufferBuilder.c(this.f13305b);
                int b = flatBufferBuilder.b(this.f13306c);
                int b2 = flatBufferBuilder.b(this.f13307d);
                int b3 = flatBufferBuilder.b(this.f13308e);
                int b4 = flatBufferBuilder.b(this.f13309f);
                int a2 = ModelHelper.a(flatBufferBuilder, this.f13310g);
                int b5 = flatBufferBuilder.b(this.f13311h);
                int a3 = ModelHelper.a(flatBufferBuilder, this.f13312i);
                int a4 = ModelHelper.a(flatBufferBuilder, this.f13313j);
                flatBufferBuilder.c(10);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.b(1, c);
                flatBufferBuilder.b(2, b);
                flatBufferBuilder.b(3, b2);
                flatBufferBuilder.b(4, b3);
                flatBufferBuilder.b(5, b4);
                flatBufferBuilder.b(6, a2);
                flatBufferBuilder.b(7, b5);
                flatBufferBuilder.b(8, a3);
                flatBufferBuilder.b(9, a4);
                flatBufferBuilder.d(flatBufferBuilder.d());
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                return new AppCollectionSuggestionFieldsModel(new MutableFlatBuffer(wrap, null, null, true, null));
            }
        }

        /* compiled from: MarketplaceLocationDialogCancelled */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(AppCollectionSuggestionFieldsModel.class, new Deserializer());
            }

            public Object m14313a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(AppCollectionSuggestionFieldsParser.m14456b(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object appCollectionSuggestionFieldsModel = new AppCollectionSuggestionFieldsModel();
                ((BaseModel) appCollectionSuggestionFieldsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (appCollectionSuggestionFieldsModel instanceof Postprocessable) {
                    return ((Postprocessable) appCollectionSuggestionFieldsModel).a();
                }
                return appCollectionSuggestionFieldsModel;
            }
        }

        /* compiled from: MarketplaceLocationDialogCancelled */
        public class Serializer extends JsonSerializer<AppCollectionSuggestionFieldsModel> {
            public final void m14314a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                AppCollectionSuggestionFieldsModel appCollectionSuggestionFieldsModel = (AppCollectionSuggestionFieldsModel) obj;
                if (appCollectionSuggestionFieldsModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(appCollectionSuggestionFieldsModel.m14318a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    appCollectionSuggestionFieldsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                AppCollectionSuggestionFieldsParser.m14457b(appCollectionSuggestionFieldsModel.w_(), appCollectionSuggestionFieldsModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(AppCollectionSuggestionFieldsModel.class, new Serializer());
            }
        }

        @Nullable
        public final /* synthetic */ DefaultImageFields nL_() {
            return m14317m();
        }

        public AppCollectionSuggestionFieldsModel() {
            super(10);
        }

        public AppCollectionSuggestionFieldsModel(MutableFlatBuffer mutableFlatBuffer) {
            super(10);
            a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
        }

        public final void m14321a(String str, ConsistencyTuple consistencyTuple) {
            if ("locally_updated_containing_collection_id".equals(str)) {
                consistencyTuple.a = mo387c();
                consistencyTuple.b = u_();
                consistencyTuple.c = 4;
                return;
            }
            consistencyTuple.a();
        }

        public final void m14322a(String str, Object obj, boolean z) {
            if ("locally_updated_containing_collection_id".equals(str)) {
                m14316a((String) obj);
            }
        }

        @Nullable
        public final GraphQLObjectType m14325d() {
            if (this.b != null && this.f13314d == null) {
                this.f13314d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
            }
            return this.f13314d;
        }

        @Nonnull
        public final ImmutableList<String> nJ_() {
            this.f13315e = super.a(this.f13315e, 1);
            return (ImmutableList) this.f13315e;
        }

        @Nullable
        public final String m14326g() {
            this.f13316f = super.a(this.f13316f, 2);
            return this.f13316f;
        }

        @Nullable
        public final String mo386b() {
            this.f13317g = super.a(this.f13317g, 3);
            return this.f13317g;
        }

        @Nullable
        public final String mo387c() {
            this.f13318h = super.a(this.f13318h, 4);
            return this.f13318h;
        }

        private void m14316a(@Nullable String str) {
            this.f13318h = str;
            if (this.b != null && this.b.d) {
                this.b.a(this.c, 4, str);
            }
        }

        @Nullable
        public final String nK_() {
            this.f13319i = super.a(this.f13319i, 5);
            return this.f13319i;
        }

        @Nullable
        private DefaultImageFieldsModel m14317m() {
            this.f13320j = (DefaultImageFieldsModel) super.a(this.f13320j, 6, DefaultImageFieldsModel.class);
            return this.f13320j;
        }

        @Nullable
        public final String m14327j() {
            this.f13321k = super.a(this.f13321k, 7);
            return this.f13321k;
        }

        @Nonnull
        public final ImmutableList<SavableTimelineAppCollectionModel> m14328k() {
            this.f13322l = super.a(this.f13322l, 8, SavableTimelineAppCollectionModel.class);
            return (ImmutableList) this.f13322l;
        }

        @Nonnull
        public final ImmutableList<SavableTimelineAppCollectionModel> m14329l() {
            this.f13323m = super.a(this.f13323m, 9, SavableTimelineAppCollectionModel.class);
            return (ImmutableList) this.f13323m;
        }

        public static AppCollectionSuggestionFieldsModel m14315a(AppCollectionSuggestionFieldsModel appCollectionSuggestionFieldsModel) {
            int i = 0;
            if (appCollectionSuggestionFieldsModel == null) {
                return null;
            }
            if (appCollectionSuggestionFieldsModel instanceof AppCollectionSuggestionFieldsModel) {
                return appCollectionSuggestionFieldsModel;
            }
            Builder builder = new Builder();
            builder.f13304a = appCollectionSuggestionFieldsModel.m14325d();
            com.google.common.collect.ImmutableList.Builder builder2 = ImmutableList.builder();
            for (int i2 = 0; i2 < appCollectionSuggestionFieldsModel.nJ_().size(); i2++) {
                builder2.c(appCollectionSuggestionFieldsModel.nJ_().get(i2));
            }
            builder.f13305b = builder2.b();
            builder.f13306c = appCollectionSuggestionFieldsModel.m14326g();
            builder.f13307d = appCollectionSuggestionFieldsModel.mo386b();
            builder.f13308e = appCollectionSuggestionFieldsModel.mo387c();
            builder.f13309f = appCollectionSuggestionFieldsModel.nK_();
            builder.f13310g = DefaultImageFieldsModel.a(appCollectionSuggestionFieldsModel.nL_());
            builder.f13311h = appCollectionSuggestionFieldsModel.m14327j();
            com.google.common.collect.ImmutableList.Builder builder3 = ImmutableList.builder();
            for (int i3 = 0; i3 < appCollectionSuggestionFieldsModel.m14328k().size(); i3++) {
                builder3.c(SavableTimelineAppCollectionModel.a((SavableTimelineAppCollection) appCollectionSuggestionFieldsModel.m14328k().get(i3)));
            }
            builder.f13312i = builder3.b();
            builder2 = ImmutableList.builder();
            while (i < appCollectionSuggestionFieldsModel.m14329l().size()) {
                builder2.c(SavableTimelineAppCollectionModel.a((SavableTimelineAppCollection) appCollectionSuggestionFieldsModel.m14329l().get(i)));
                i++;
            }
            builder.f13313j = builder2.b();
            return builder.m14312a();
        }

        @Nullable
        public final String m14320a() {
            return mo386b();
        }

        public final int jK_() {
            return 2433570;
        }

        public final GraphQLVisitableModel m14319a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            com.google.common.collect.ImmutableList.Builder a;
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m14317m() != null) {
                DefaultImageFieldsModel defaultImageFieldsModel = (DefaultImageFieldsModel) graphQLModelMutatingVisitor.b(m14317m());
                if (m14317m() != defaultImageFieldsModel) {
                    graphQLVisitableModel = (AppCollectionSuggestionFieldsModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f13320j = defaultImageFieldsModel;
                }
            }
            if (m14328k() != null) {
                a = ModelHelper.a(m14328k(), graphQLModelMutatingVisitor);
                if (a != null) {
                    AppCollectionSuggestionFieldsModel appCollectionSuggestionFieldsModel = (AppCollectionSuggestionFieldsModel) ModelHelper.a(graphQLVisitableModel, this);
                    appCollectionSuggestionFieldsModel.f13322l = a.b();
                    graphQLVisitableModel = appCollectionSuggestionFieldsModel;
                }
            }
            if (m14329l() != null) {
                a = ModelHelper.a(m14329l(), graphQLModelMutatingVisitor);
                if (a != null) {
                    appCollectionSuggestionFieldsModel = (AppCollectionSuggestionFieldsModel) ModelHelper.a(graphQLVisitableModel, this);
                    appCollectionSuggestionFieldsModel.f13323m = a.b();
                    graphQLVisitableModel = appCollectionSuggestionFieldsModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m14318a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m14325d());
            int c = flatBufferBuilder.c(nJ_());
            int b = flatBufferBuilder.b(m14326g());
            int b2 = flatBufferBuilder.b(mo386b());
            int b3 = flatBufferBuilder.b(mo387c());
            int b4 = flatBufferBuilder.b(nK_());
            int a2 = ModelHelper.a(flatBufferBuilder, m14317m());
            int b5 = flatBufferBuilder.b(m14327j());
            int a3 = ModelHelper.a(flatBufferBuilder, m14328k());
            int a4 = ModelHelper.a(flatBufferBuilder, m14329l());
            flatBufferBuilder.c(10);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, c);
            flatBufferBuilder.b(2, b);
            flatBufferBuilder.b(3, b2);
            flatBufferBuilder.b(4, b3);
            flatBufferBuilder.b(5, b4);
            flatBufferBuilder.b(6, a2);
            flatBufferBuilder.b(7, b5);
            flatBufferBuilder.b(8, a3);
            flatBufferBuilder.b(9, a4);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -1097398158)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: MarketplaceLocationDialogCancelled */
    public final class CollectionGroupMembersFieldsModel extends BaseModel implements GraphQLVisitableConsistentModel {
        @Nullable
        private DefaultImageFieldsModel f13325d;

        /* compiled from: MarketplaceLocationDialogCancelled */
        public final class Builder {
            @Nullable
            public DefaultImageFieldsModel f13324a;
        }

        /* compiled from: MarketplaceLocationDialogCancelled */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(CollectionGroupMembersFieldsModel.class, new Deserializer());
            }

            public Object m14330a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(CollectionGroupMembersFieldsParser.m14458b(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object collectionGroupMembersFieldsModel = new CollectionGroupMembersFieldsModel();
                ((BaseModel) collectionGroupMembersFieldsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (collectionGroupMembersFieldsModel instanceof Postprocessable) {
                    return ((Postprocessable) collectionGroupMembersFieldsModel).a();
                }
                return collectionGroupMembersFieldsModel;
            }
        }

        /* compiled from: MarketplaceLocationDialogCancelled */
        public class Serializer extends JsonSerializer<CollectionGroupMembersFieldsModel> {
            public final void m14331a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                CollectionGroupMembersFieldsModel collectionGroupMembersFieldsModel = (CollectionGroupMembersFieldsModel) obj;
                if (collectionGroupMembersFieldsModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(collectionGroupMembersFieldsModel.m14334a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    collectionGroupMembersFieldsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                CollectionGroupMembersFieldsParser.m14459b(collectionGroupMembersFieldsModel.w_(), collectionGroupMembersFieldsModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(CollectionGroupMembersFieldsModel.class, new Serializer());
            }
        }

        @Nullable
        public final /* synthetic */ DefaultImageFields m14335a() {
            return m14333j();
        }

        public CollectionGroupMembersFieldsModel() {
            super(1);
        }

        public CollectionGroupMembersFieldsModel(MutableFlatBuffer mutableFlatBuffer) {
            super(1);
            a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
        }

        public final void m14337a(String str, ConsistencyTuple consistencyTuple) {
            consistencyTuple.a();
        }

        public final void m14338a(String str, Object obj, boolean z) {
        }

        @Nullable
        private DefaultImageFieldsModel m14333j() {
            this.f13325d = (DefaultImageFieldsModel) super.a(this.f13325d, 0, DefaultImageFieldsModel.class);
            return this.f13325d;
        }

        public static CollectionGroupMembersFieldsModel m14332a(CollectionGroupMembersFieldsModel collectionGroupMembersFieldsModel) {
            if (collectionGroupMembersFieldsModel == null) {
                return null;
            }
            if (collectionGroupMembersFieldsModel instanceof CollectionGroupMembersFieldsModel) {
                return collectionGroupMembersFieldsModel;
            }
            Builder builder = new Builder();
            builder.f13324a = DefaultImageFieldsModel.a(collectionGroupMembersFieldsModel.m14335a());
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
            int a = ModelHelper.a(flatBufferBuilder, builder.f13324a);
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.d(flatBufferBuilder.d());
            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
            wrap.position(0);
            return new CollectionGroupMembersFieldsModel(new MutableFlatBuffer(wrap, null, null, true, null));
        }

        public final int jK_() {
            return 2645995;
        }

        public final GraphQLVisitableModel m14336a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m14333j() != null) {
                DefaultImageFieldsModel defaultImageFieldsModel = (DefaultImageFieldsModel) graphQLModelMutatingVisitor.b(m14333j());
                if (m14333j() != defaultImageFieldsModel) {
                    graphQLVisitableModel = (CollectionGroupMembersFieldsModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f13325d = defaultImageFieldsModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m14334a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m14333j());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -1810077392)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: MarketplaceLocationDialogCancelled */
    public final class CollectionItemConnectionWithFieldsModel extends BaseModel implements GraphQLVisitableModel {
        private int f13330d;
        @Nullable
        private List<AppCollectionItemModel> f13331e;
        @Nullable
        private DefaultPageInfoFieldsModel f13332f;
        private int f13333g;

        /* compiled from: MarketplaceLocationDialogCancelled */
        public final class Builder {
            public int f13326a;
            @Nullable
            public ImmutableList<AppCollectionItemModel> f13327b;
            @Nullable
            public DefaultPageInfoFieldsModel f13328c;
            public int f13329d;
        }

        /* compiled from: MarketplaceLocationDialogCancelled */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(CollectionItemConnectionWithFieldsModel.class, new Deserializer());
            }

            public Object m14339a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(CollectionItemConnectionWithFieldsParser.m14460a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object collectionItemConnectionWithFieldsModel = new CollectionItemConnectionWithFieldsModel();
                ((BaseModel) collectionItemConnectionWithFieldsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (collectionItemConnectionWithFieldsModel instanceof Postprocessable) {
                    return ((Postprocessable) collectionItemConnectionWithFieldsModel).a();
                }
                return collectionItemConnectionWithFieldsModel;
            }
        }

        /* compiled from: MarketplaceLocationDialogCancelled */
        public class Serializer extends JsonSerializer<CollectionItemConnectionWithFieldsModel> {
            public final void m14340a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                CollectionItemConnectionWithFieldsModel collectionItemConnectionWithFieldsModel = (CollectionItemConnectionWithFieldsModel) obj;
                if (collectionItemConnectionWithFieldsModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(collectionItemConnectionWithFieldsModel.m14343a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    collectionItemConnectionWithFieldsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                CollectionItemConnectionWithFieldsParser.m14461a(collectionItemConnectionWithFieldsModel.w_(), collectionItemConnectionWithFieldsModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(CollectionItemConnectionWithFieldsModel.class, new Serializer());
            }
        }

        @Nullable
        public final /* synthetic */ DefaultPageInfoFields m14347c() {
            return m14349j();
        }

        public CollectionItemConnectionWithFieldsModel() {
            super(4);
        }

        public CollectionItemConnectionWithFieldsModel(MutableFlatBuffer mutableFlatBuffer) {
            super(4);
            a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
        }

        public final int m14342a() {
            a(0, 0);
            return this.f13330d;
        }

        @Nonnull
        public final ImmutableList<AppCollectionItemModel> m14346b() {
            this.f13331e = super.a(this.f13331e, 1, AppCollectionItemModel.class);
            return (ImmutableList) this.f13331e;
        }

        @Nullable
        public final DefaultPageInfoFieldsModel m14349j() {
            this.f13332f = (DefaultPageInfoFieldsModel) super.a(this.f13332f, 2, DefaultPageInfoFieldsModel.class);
            return this.f13332f;
        }

        public final int m14348d() {
            a(0, 3);
            return this.f13333g;
        }

        public static CollectionItemConnectionWithFieldsModel m14341a(CollectionItemConnectionWithFieldsModel collectionItemConnectionWithFieldsModel) {
            if (collectionItemConnectionWithFieldsModel == null) {
                return null;
            }
            if (collectionItemConnectionWithFieldsModel instanceof CollectionItemConnectionWithFieldsModel) {
                return collectionItemConnectionWithFieldsModel;
            }
            Builder builder = new Builder();
            builder.f13326a = collectionItemConnectionWithFieldsModel.m14342a();
            com.google.common.collect.ImmutableList.Builder builder2 = ImmutableList.builder();
            for (int i = 0; i < collectionItemConnectionWithFieldsModel.m14346b().size(); i++) {
                builder2.c(AppCollectionItemModel.m14279a((AppCollectionItemModel) collectionItemConnectionWithFieldsModel.m14346b().get(i)));
            }
            builder.f13327b = builder2.b();
            builder.f13328c = DefaultPageInfoFieldsModel.a(collectionItemConnectionWithFieldsModel.m14347c());
            builder.f13329d = collectionItemConnectionWithFieldsModel.m14348d();
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
            int a = ModelHelper.a(flatBufferBuilder, builder.f13327b);
            int a2 = ModelHelper.a(flatBufferBuilder, builder.f13328c);
            flatBufferBuilder.c(4);
            flatBufferBuilder.a(0, builder.f13326a, 0);
            flatBufferBuilder.b(1, a);
            flatBufferBuilder.b(2, a2);
            flatBufferBuilder.a(3, builder.f13329d, 0);
            flatBufferBuilder.d(flatBufferBuilder.d());
            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
            wrap.position(0);
            return new CollectionItemConnectionWithFieldsModel(new MutableFlatBuffer(wrap, null, null, true, null));
        }

        public final int jK_() {
            return 1478593056;
        }

        public final GraphQLVisitableModel m14344a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel;
            DefaultPageInfoFieldsModel defaultPageInfoFieldsModel;
            h();
            if (m14346b() != null) {
                com.google.common.collect.ImmutableList.Builder a = ModelHelper.a(m14346b(), graphQLModelMutatingVisitor);
                if (a != null) {
                    CollectionItemConnectionWithFieldsModel collectionItemConnectionWithFieldsModel = (CollectionItemConnectionWithFieldsModel) ModelHelper.a(null, this);
                    collectionItemConnectionWithFieldsModel.f13331e = a.b();
                    graphQLVisitableModel = collectionItemConnectionWithFieldsModel;
                    if (m14349j() != null) {
                        defaultPageInfoFieldsModel = (DefaultPageInfoFieldsModel) graphQLModelMutatingVisitor.b(m14349j());
                        if (m14349j() != defaultPageInfoFieldsModel) {
                            graphQLVisitableModel = (CollectionItemConnectionWithFieldsModel) ModelHelper.a(graphQLVisitableModel, this);
                            graphQLVisitableModel.f13332f = defaultPageInfoFieldsModel;
                        }
                    }
                    i();
                    return graphQLVisitableModel != null ? this : graphQLVisitableModel;
                }
            }
            graphQLVisitableModel = null;
            if (m14349j() != null) {
                defaultPageInfoFieldsModel = (DefaultPageInfoFieldsModel) graphQLModelMutatingVisitor.b(m14349j());
                if (m14349j() != defaultPageInfoFieldsModel) {
                    graphQLVisitableModel = (CollectionItemConnectionWithFieldsModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f13332f = defaultPageInfoFieldsModel;
                }
            }
            i();
            if (graphQLVisitableModel != null) {
            }
        }

        public final int m14343a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m14346b());
            int a2 = ModelHelper.a(flatBufferBuilder, m14349j());
            flatBufferBuilder.c(4);
            flatBufferBuilder.a(0, this.f13330d, 0);
            flatBufferBuilder.b(1, a);
            flatBufferBuilder.b(2, a2);
            flatBufferBuilder.a(3, this.f13333g, 0);
            i();
            return flatBufferBuilder.d();
        }

        public final void m14345a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
            super.a(mutableFlatBuffer, i, obj);
            this.f13330d = mutableFlatBuffer.a(i, 0, 0);
            this.f13333g = mutableFlatBuffer.a(i, 3, 0);
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 279896020)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: MarketplaceLocationDialogCancelled */
    public final class CollectionItemNodeFieldsModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel, CollectionsFirstFiveGroupMembersFields {
        @Nullable
        private GraphQLObjectType f13349d;
        @Nullable
        private AddressModel f13350e;
        @Nullable
        private GraphQLFriendshipStatus f13351f;
        @Nullable
        private GroupMembersModel f13352g;
        @Nullable
        private String f13353h;
        private boolean f13354i;
        @Nullable
        private GraphQLTimelineContactItemType f13355j;
        @Nullable
        private String f13356k;
        @Nullable
        private GraphQLTimelineAppSectionType f13357l;
        @Nullable
        private GraphQLSubscribeStatus f13358m;
        @Nullable
        private GraphQLGroupJoinState f13359n;
        @Nullable
        private List<SavableTimelineAppCollectionModel> f13360o;
        @Nullable
        private List<SavableTimelineAppCollectionModel> f13361p;

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -247756404)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: MarketplaceLocationDialogCancelled */
        public final class AddressModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private String f13335d;

            /* compiled from: MarketplaceLocationDialogCancelled */
            public final class Builder {
                @Nullable
                public String f13334a;
            }

            /* compiled from: MarketplaceLocationDialogCancelled */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(AddressModel.class, new Deserializer());
                }

                public Object m14350a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(AddressParser.m14462a(jsonParser, flatBufferBuilder));
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

            /* compiled from: MarketplaceLocationDialogCancelled */
            public class Serializer extends JsonSerializer<AddressModel> {
                public final void m14351a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    AddressModel addressModel = (AddressModel) obj;
                    if (addressModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(addressModel.m14353a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        addressModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    AddressParser.m14463a(addressModel.w_(), addressModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(AddressModel.class, new Serializer());
                }
            }

            public AddressModel() {
                super(1);
            }

            public AddressModel(MutableFlatBuffer mutableFlatBuffer) {
                super(1);
                a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
            }

            @Nullable
            public final String m14355a() {
                this.f13335d = super.a(this.f13335d, 0);
                return this.f13335d;
            }

            public static AddressModel m14352a(AddressModel addressModel) {
                if (addressModel == null) {
                    return null;
                }
                if (addressModel instanceof AddressModel) {
                    return addressModel;
                }
                Builder builder = new Builder();
                builder.f13334a = addressModel.m14355a();
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                int b = flatBufferBuilder.b(builder.f13334a);
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, b);
                flatBufferBuilder.d(flatBufferBuilder.d());
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                return new AddressModel(new MutableFlatBuffer(wrap, null, null, true, null));
            }

            public final int jK_() {
                return 799251025;
            }

            public final GraphQLVisitableModel m14354a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m14353a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m14355a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, b);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: MarketplaceLocationDialogCancelled */
        public final class Builder {
            @Nullable
            public GraphQLObjectType f13336a;
            @Nullable
            public AddressModel f13337b;
            @Nullable
            public GraphQLFriendshipStatus f13338c;
            @Nullable
            public GroupMembersModel f13339d;
            @Nullable
            public String f13340e;
            public boolean f13341f;
            @Nullable
            public GraphQLTimelineContactItemType f13342g;
            @Nullable
            public String f13343h;
            @Nullable
            public GraphQLTimelineAppSectionType f13344i;
            @Nullable
            public GraphQLSubscribeStatus f13345j;
            @Nullable
            public GraphQLGroupJoinState f13346k;
            @Nullable
            public ImmutableList<SavableTimelineAppCollectionModel> f13347l;
            @Nullable
            public ImmutableList<SavableTimelineAppCollectionModel> f13348m;

            public final CollectionItemNodeFieldsModel m14356a() {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                int a = ModelHelper.a(flatBufferBuilder, this.f13336a);
                int a2 = ModelHelper.a(flatBufferBuilder, this.f13337b);
                int a3 = flatBufferBuilder.a(this.f13338c);
                int a4 = ModelHelper.a(flatBufferBuilder, this.f13339d);
                int b = flatBufferBuilder.b(this.f13340e);
                int a5 = flatBufferBuilder.a(this.f13342g);
                int b2 = flatBufferBuilder.b(this.f13343h);
                int a6 = flatBufferBuilder.a(this.f13344i);
                int a7 = flatBufferBuilder.a(this.f13345j);
                int a8 = flatBufferBuilder.a(this.f13346k);
                int a9 = ModelHelper.a(flatBufferBuilder, this.f13347l);
                int a10 = ModelHelper.a(flatBufferBuilder, this.f13348m);
                flatBufferBuilder.c(13);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.b(1, a2);
                flatBufferBuilder.b(2, a3);
                flatBufferBuilder.b(3, a4);
                flatBufferBuilder.b(4, b);
                flatBufferBuilder.a(5, this.f13341f);
                flatBufferBuilder.b(6, a5);
                flatBufferBuilder.b(7, b2);
                flatBufferBuilder.b(8, a6);
                flatBufferBuilder.b(9, a7);
                flatBufferBuilder.b(10, a8);
                flatBufferBuilder.b(11, a9);
                flatBufferBuilder.b(12, a10);
                flatBufferBuilder.d(flatBufferBuilder.d());
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                return new CollectionItemNodeFieldsModel(new MutableFlatBuffer(wrap, null, null, true, null));
            }
        }

        /* compiled from: MarketplaceLocationDialogCancelled */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(CollectionItemNodeFieldsModel.class, new Deserializer());
            }

            public Object m14357a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(CollectionItemNodeFieldsParser.m14464a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object collectionItemNodeFieldsModel = new CollectionItemNodeFieldsModel();
                ((BaseModel) collectionItemNodeFieldsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (collectionItemNodeFieldsModel instanceof Postprocessable) {
                    return ((Postprocessable) collectionItemNodeFieldsModel).a();
                }
                return collectionItemNodeFieldsModel;
            }
        }

        /* compiled from: MarketplaceLocationDialogCancelled */
        public class Serializer extends JsonSerializer<CollectionItemNodeFieldsModel> {
            public final void m14358a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                CollectionItemNodeFieldsModel collectionItemNodeFieldsModel = (CollectionItemNodeFieldsModel) obj;
                if (collectionItemNodeFieldsModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(collectionItemNodeFieldsModel.m14365a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    collectionItemNodeFieldsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                CollectionItemNodeFieldsParser.m14465a(collectionItemNodeFieldsModel.w_(), collectionItemNodeFieldsModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(CollectionItemNodeFieldsModel.class, new Serializer());
            }
        }

        @Nullable
        public final /* synthetic */ AddressModel m14372c() {
            return m14363p();
        }

        @Nullable
        public final /* synthetic */ GroupMembersModel nO_() {
            return m14364q();
        }

        public CollectionItemNodeFieldsModel() {
            super(13);
        }

        public CollectionItemNodeFieldsModel(MutableFlatBuffer mutableFlatBuffer) {
            super(13);
            a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
        }

        public final void m14369a(String str, ConsistencyTuple consistencyTuple) {
            if ("friendship_status".equals(str)) {
                consistencyTuple.a = m14373d();
                consistencyTuple.b = u_();
                consistencyTuple.c = 2;
            } else if ("subscribe_status".equals(str)) {
                consistencyTuple.a = m14377l();
                consistencyTuple.b = u_();
                consistencyTuple.c = 9;
            } else if ("viewer_join_state".equals(str)) {
                consistencyTuple.a = m14378m();
                consistencyTuple.b = u_();
                consistencyTuple.c = 10;
            } else {
                consistencyTuple.a();
            }
        }

        public final void m14370a(String str, Object obj, boolean z) {
            if ("friendship_status".equals(str)) {
                m14360a((GraphQLFriendshipStatus) obj);
            } else if ("subscribe_status".equals(str)) {
                m14362a((GraphQLSubscribeStatus) obj);
            } else if ("viewer_join_state".equals(str)) {
                m14361a((GraphQLGroupJoinState) obj);
            }
        }

        @Nullable
        public final GraphQLObjectType m14371b() {
            if (this.b != null && this.f13349d == null) {
                this.f13349d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
            }
            return this.f13349d;
        }

        @Nullable
        private AddressModel m14363p() {
            this.f13350e = (AddressModel) super.a(this.f13350e, 1, AddressModel.class);
            return this.f13350e;
        }

        @Nullable
        public final GraphQLFriendshipStatus m14373d() {
            this.f13351f = (GraphQLFriendshipStatus) super.b(this.f13351f, 2, GraphQLFriendshipStatus.class, GraphQLFriendshipStatus.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
            return this.f13351f;
        }

        private void m14360a(GraphQLFriendshipStatus graphQLFriendshipStatus) {
            this.f13351f = graphQLFriendshipStatus;
            if (this.b != null && this.b.d) {
                this.b.a(this.c, 2, graphQLFriendshipStatus != null ? graphQLFriendshipStatus.name() : null);
            }
        }

        @Nullable
        private GroupMembersModel m14364q() {
            this.f13352g = (GroupMembersModel) super.a(this.f13352g, 3, GroupMembersModel.class);
            return this.f13352g;
        }

        @Nullable
        public final String m14374g() {
            this.f13353h = super.a(this.f13353h, 4);
            return this.f13353h;
        }

        public final boolean nM_() {
            a(0, 5);
            return this.f13354i;
        }

        @Nullable
        public final GraphQLTimelineContactItemType nN_() {
            this.f13355j = (GraphQLTimelineContactItemType) super.b(this.f13355j, 6, GraphQLTimelineContactItemType.class, GraphQLTimelineContactItemType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
            return this.f13355j;
        }

        @Nullable
        public final String m14375j() {
            this.f13356k = super.a(this.f13356k, 7);
            return this.f13356k;
        }

        @Nullable
        public final GraphQLTimelineAppSectionType m14376k() {
            this.f13357l = (GraphQLTimelineAppSectionType) super.b(this.f13357l, 8, GraphQLTimelineAppSectionType.class, GraphQLTimelineAppSectionType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
            return this.f13357l;
        }

        @Nullable
        public final GraphQLSubscribeStatus m14377l() {
            this.f13358m = (GraphQLSubscribeStatus) super.b(this.f13358m, 9, GraphQLSubscribeStatus.class, GraphQLSubscribeStatus.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
            return this.f13358m;
        }

        private void m14362a(GraphQLSubscribeStatus graphQLSubscribeStatus) {
            this.f13358m = graphQLSubscribeStatus;
            if (this.b != null && this.b.d) {
                this.b.a(this.c, 9, graphQLSubscribeStatus != null ? graphQLSubscribeStatus.name() : null);
            }
        }

        @Nullable
        public final GraphQLGroupJoinState m14378m() {
            this.f13359n = (GraphQLGroupJoinState) super.b(this.f13359n, 10, GraphQLGroupJoinState.class, GraphQLGroupJoinState.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
            return this.f13359n;
        }

        private void m14361a(GraphQLGroupJoinState graphQLGroupJoinState) {
            this.f13359n = graphQLGroupJoinState;
            if (this.b != null && this.b.d) {
                this.b.a(this.c, 10, graphQLGroupJoinState != null ? graphQLGroupJoinState.name() : null);
            }
        }

        @Nonnull
        public final ImmutableList<SavableTimelineAppCollectionModel> m14379n() {
            this.f13360o = super.a(this.f13360o, 11, SavableTimelineAppCollectionModel.class);
            return (ImmutableList) this.f13360o;
        }

        @Nonnull
        public final ImmutableList<SavableTimelineAppCollectionModel> m14380o() {
            this.f13361p = super.a(this.f13361p, 12, SavableTimelineAppCollectionModel.class);
            return (ImmutableList) this.f13361p;
        }

        public static CollectionItemNodeFieldsModel m14359a(CollectionItemNodeFieldsModel collectionItemNodeFieldsModel) {
            int i = 0;
            if (collectionItemNodeFieldsModel == null) {
                return null;
            }
            if (collectionItemNodeFieldsModel instanceof CollectionItemNodeFieldsModel) {
                return collectionItemNodeFieldsModel;
            }
            Builder builder = new Builder();
            builder.f13336a = collectionItemNodeFieldsModel.m14371b();
            builder.f13337b = AddressModel.m14352a(collectionItemNodeFieldsModel.m14372c());
            builder.f13338c = collectionItemNodeFieldsModel.m14373d();
            builder.f13339d = GroupMembersModel.m14414a(collectionItemNodeFieldsModel.nO_());
            builder.f13340e = collectionItemNodeFieldsModel.m14374g();
            builder.f13341f = collectionItemNodeFieldsModel.nM_();
            builder.f13342g = collectionItemNodeFieldsModel.nN_();
            builder.f13343h = collectionItemNodeFieldsModel.m14375j();
            builder.f13344i = collectionItemNodeFieldsModel.m14376k();
            builder.f13345j = collectionItemNodeFieldsModel.m14377l();
            builder.f13346k = collectionItemNodeFieldsModel.m14378m();
            com.google.common.collect.ImmutableList.Builder builder2 = ImmutableList.builder();
            for (int i2 = 0; i2 < collectionItemNodeFieldsModel.m14379n().size(); i2++) {
                builder2.c(SavableTimelineAppCollectionModel.a((SavableTimelineAppCollection) collectionItemNodeFieldsModel.m14379n().get(i2)));
            }
            builder.f13347l = builder2.b();
            com.google.common.collect.ImmutableList.Builder builder3 = ImmutableList.builder();
            while (i < collectionItemNodeFieldsModel.m14380o().size()) {
                builder3.c(SavableTimelineAppCollectionModel.a((SavableTimelineAppCollection) collectionItemNodeFieldsModel.m14380o().get(i)));
                i++;
            }
            builder.f13348m = builder3.b();
            return builder.m14356a();
        }

        @Nullable
        public final String m14367a() {
            return m14374g();
        }

        public final int jK_() {
            return 2433570;
        }

        public final GraphQLVisitableModel m14366a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            com.google.common.collect.ImmutableList.Builder a;
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m14363p() != null) {
                AddressModel addressModel = (AddressModel) graphQLModelMutatingVisitor.b(m14363p());
                if (m14363p() != addressModel) {
                    graphQLVisitableModel = (CollectionItemNodeFieldsModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f13350e = addressModel;
                }
            }
            if (m14364q() != null) {
                GroupMembersModel groupMembersModel = (GroupMembersModel) graphQLModelMutatingVisitor.b(m14364q());
                if (m14364q() != groupMembersModel) {
                    graphQLVisitableModel = (CollectionItemNodeFieldsModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f13352g = groupMembersModel;
                }
            }
            if (m14379n() != null) {
                a = ModelHelper.a(m14379n(), graphQLModelMutatingVisitor);
                if (a != null) {
                    CollectionItemNodeFieldsModel collectionItemNodeFieldsModel = (CollectionItemNodeFieldsModel) ModelHelper.a(graphQLVisitableModel, this);
                    collectionItemNodeFieldsModel.f13360o = a.b();
                    graphQLVisitableModel = collectionItemNodeFieldsModel;
                }
            }
            if (m14380o() != null) {
                a = ModelHelper.a(m14380o(), graphQLModelMutatingVisitor);
                if (a != null) {
                    collectionItemNodeFieldsModel = (CollectionItemNodeFieldsModel) ModelHelper.a(graphQLVisitableModel, this);
                    collectionItemNodeFieldsModel.f13361p = a.b();
                    graphQLVisitableModel = collectionItemNodeFieldsModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m14365a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m14371b());
            int a2 = ModelHelper.a(flatBufferBuilder, m14363p());
            int a3 = flatBufferBuilder.a(m14373d());
            int a4 = ModelHelper.a(flatBufferBuilder, m14364q());
            int b = flatBufferBuilder.b(m14374g());
            int a5 = flatBufferBuilder.a(nN_());
            int b2 = flatBufferBuilder.b(m14375j());
            int a6 = flatBufferBuilder.a(m14376k());
            int a7 = flatBufferBuilder.a(m14377l());
            int a8 = flatBufferBuilder.a(m14378m());
            int a9 = ModelHelper.a(flatBufferBuilder, m14379n());
            int a10 = ModelHelper.a(flatBufferBuilder, m14380o());
            flatBufferBuilder.c(13);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, a2);
            flatBufferBuilder.b(2, a3);
            flatBufferBuilder.b(3, a4);
            flatBufferBuilder.b(4, b);
            flatBufferBuilder.a(5, this.f13354i);
            flatBufferBuilder.b(6, a5);
            flatBufferBuilder.b(7, b2);
            flatBufferBuilder.b(8, a6);
            flatBufferBuilder.b(9, a7);
            flatBufferBuilder.b(10, a8);
            flatBufferBuilder.b(11, a9);
            flatBufferBuilder.b(12, a10);
            i();
            return flatBufferBuilder.d();
        }

        public final void m14368a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
            super.a(mutableFlatBuffer, i, obj);
            this.f13354i = mutableFlatBuffer.a(i, 5);
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 1300427078)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: MarketplaceLocationDialogCancelled */
    public final class CollectionsAppSectionModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel, CollectionsAppSection {
        @Nullable
        private DefaultImageFieldsModel f13364d;
        @Nullable
        private String f13365e;
        @Nullable
        private String f13366f;
        @Nullable
        private GraphQLTimelineAppSectionType f13367g;
        @Nullable
        private String f13368h;
        @Nullable
        private SubtitleModel f13369i;
        @Nullable
        private TitleModel f13370j;
        @Nullable
        private String f13371k;
        @Nullable
        private String f13372l;

        /* compiled from: MarketplaceLocationDialogCancelled */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(CollectionsAppSectionModel.class, new Deserializer());
            }

            public Object m14381a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = CollectionsAppSectionParser.m14470a(jsonParser);
                Object collectionsAppSectionModel = new CollectionsAppSectionModel();
                ((BaseModel) collectionsAppSectionModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (collectionsAppSectionModel instanceof Postprocessable) {
                    return ((Postprocessable) collectionsAppSectionModel).a();
                }
                return collectionsAppSectionModel;
            }
        }

        /* compiled from: MarketplaceLocationDialogCancelled */
        public class Serializer extends JsonSerializer<CollectionsAppSectionModel> {
            public final void m14382a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                CollectionsAppSectionModel collectionsAppSectionModel = (CollectionsAppSectionModel) obj;
                if (collectionsAppSectionModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(collectionsAppSectionModel.m14396a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    collectionsAppSectionModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                CollectionsAppSectionParser.m14471a(collectionsAppSectionModel.w_(), collectionsAppSectionModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(CollectionsAppSectionModel.class, new Serializer());
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1352864475)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: MarketplaceLocationDialogCancelled */
        public final class SubtitleModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private String f13362d;

            /* compiled from: MarketplaceLocationDialogCancelled */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(SubtitleModel.class, new Deserializer());
                }

                public Object m14383a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(SubtitleParser.m14466a(jsonParser, flatBufferBuilder));
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

            /* compiled from: MarketplaceLocationDialogCancelled */
            public class Serializer extends JsonSerializer<SubtitleModel> {
                public final void m14384a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    SubtitleModel subtitleModel = (SubtitleModel) obj;
                    if (subtitleModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(subtitleModel.m14385a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        subtitleModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    SubtitleParser.m14467a(subtitleModel.w_(), subtitleModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(SubtitleModel.class, new Serializer());
                }
            }

            public SubtitleModel() {
                super(1);
            }

            @Nullable
            public final String m14387a() {
                this.f13362d = super.a(this.f13362d, 0);
                return this.f13362d;
            }

            public final int jK_() {
                return -1919764332;
            }

            public final GraphQLVisitableModel m14386a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m14385a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m14387a());
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
        /* compiled from: MarketplaceLocationDialogCancelled */
        public final class TitleModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private String f13363d;

            /* compiled from: MarketplaceLocationDialogCancelled */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(TitleModel.class, new Deserializer());
                }

                public Object m14388a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(CollectionsAppSectionParser.TitleParser.m14468a(jsonParser, flatBufferBuilder));
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

            /* compiled from: MarketplaceLocationDialogCancelled */
            public class Serializer extends JsonSerializer<TitleModel> {
                public final void m14389a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    TitleModel titleModel = (TitleModel) obj;
                    if (titleModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(titleModel.m14390a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        titleModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    CollectionsAppSectionParser.TitleParser.m14469a(titleModel.w_(), titleModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(TitleModel.class, new Serializer());
                }
            }

            public TitleModel() {
                super(1);
            }

            @Nullable
            public final String m14392a() {
                this.f13363d = super.a(this.f13363d, 0);
                return this.f13363d;
            }

            public final int jK_() {
                return -1919764332;
            }

            public final GraphQLVisitableModel m14391a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m14390a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m14392a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, b);
                i();
                return flatBufferBuilder.d();
            }
        }

        @Nullable
        public final /* synthetic */ DefaultImageFields mo388b() {
            return m14393j();
        }

        public CollectionsAppSectionModel() {
            super(9);
        }

        @Nullable
        private DefaultImageFieldsModel m14393j() {
            this.f13364d = (DefaultImageFieldsModel) super.a(this.f13364d, 0, DefaultImageFieldsModel.class);
            return this.f13364d;
        }

        @Nullable
        public final String mo389c() {
            this.f13365e = super.a(this.f13365e, 1);
            return this.f13365e;
        }

        @Nullable
        public final String mo390d() {
            this.f13366f = super.a(this.f13366f, 2);
            return this.f13366f;
        }

        @Nullable
        public final GraphQLTimelineAppSectionType nP_() {
            this.f13367g = (GraphQLTimelineAppSectionType) super.b(this.f13367g, 3, GraphQLTimelineAppSectionType.class, GraphQLTimelineAppSectionType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
            return this.f13367g;
        }

        @Nullable
        public final String mo391g() {
            this.f13368h = super.a(this.f13368h, 4);
            return this.f13368h;
        }

        @Nullable
        private SubtitleModel m14394k() {
            this.f13369i = (SubtitleModel) super.a(this.f13369i, 5, SubtitleModel.class);
            return this.f13369i;
        }

        @Nullable
        private TitleModel m14395l() {
            this.f13370j = (TitleModel) super.a(this.f13370j, 6, TitleModel.class);
            return this.f13370j;
        }

        @Nullable
        public final String nQ_() {
            this.f13371k = super.a(this.f13371k, 7);
            return this.f13371k;
        }

        @Nullable
        public final String nR_() {
            this.f13372l = super.a(this.f13372l, 8);
            return this.f13372l;
        }

        @Nullable
        public final String m14398a() {
            return mo389c();
        }

        public final int jK_() {
            return 1842803909;
        }

        public final GraphQLVisitableModel m14397a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m14393j() != null) {
                DefaultImageFieldsModel defaultImageFieldsModel = (DefaultImageFieldsModel) graphQLModelMutatingVisitor.b(m14393j());
                if (m14393j() != defaultImageFieldsModel) {
                    graphQLVisitableModel = (CollectionsAppSectionModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f13364d = defaultImageFieldsModel;
                }
            }
            if (m14394k() != null) {
                SubtitleModel subtitleModel = (SubtitleModel) graphQLModelMutatingVisitor.b(m14394k());
                if (m14394k() != subtitleModel) {
                    graphQLVisitableModel = (CollectionsAppSectionModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f13369i = subtitleModel;
                }
            }
            if (m14395l() != null) {
                TitleModel titleModel = (TitleModel) graphQLModelMutatingVisitor.b(m14395l());
                if (m14395l() != titleModel) {
                    graphQLVisitableModel = (CollectionsAppSectionModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f13370j = titleModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m14396a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m14393j());
            int b = flatBufferBuilder.b(mo389c());
            int b2 = flatBufferBuilder.b(mo390d());
            int a2 = flatBufferBuilder.a(nP_());
            int b3 = flatBufferBuilder.b(mo391g());
            int a3 = ModelHelper.a(flatBufferBuilder, m14394k());
            int a4 = ModelHelper.a(flatBufferBuilder, m14395l());
            int b4 = flatBufferBuilder.b(nQ_());
            int b5 = flatBufferBuilder.b(nR_());
            flatBufferBuilder.c(9);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, b);
            flatBufferBuilder.b(2, b2);
            flatBufferBuilder.b(3, a2);
            flatBufferBuilder.b(4, b3);
            flatBufferBuilder.b(5, a3);
            flatBufferBuilder.b(6, a4);
            flatBufferBuilder.b(7, b4);
            flatBufferBuilder.b(8, b5);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 156580080)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: MarketplaceLocationDialogCancelled */
    public final class CollectionsEligibleSuggestionsFieldsModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private List<AppCollectionSuggestionFieldsModel> f13375d;
        @Nullable
        private DefaultPageInfoFieldsModel f13376e;

        /* compiled from: MarketplaceLocationDialogCancelled */
        public final class Builder {
            @Nullable
            public ImmutableList<AppCollectionSuggestionFieldsModel> f13373a;
            @Nullable
            public DefaultPageInfoFieldsModel f13374b;
        }

        /* compiled from: MarketplaceLocationDialogCancelled */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(CollectionsEligibleSuggestionsFieldsModel.class, new Deserializer());
            }

            public Object m14403a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(CollectionsEligibleSuggestionsFieldsParser.m14472a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object collectionsEligibleSuggestionsFieldsModel = new CollectionsEligibleSuggestionsFieldsModel();
                ((BaseModel) collectionsEligibleSuggestionsFieldsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (collectionsEligibleSuggestionsFieldsModel instanceof Postprocessable) {
                    return ((Postprocessable) collectionsEligibleSuggestionsFieldsModel).a();
                }
                return collectionsEligibleSuggestionsFieldsModel;
            }
        }

        /* compiled from: MarketplaceLocationDialogCancelled */
        public class Serializer extends JsonSerializer<CollectionsEligibleSuggestionsFieldsModel> {
            public final void m14404a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                CollectionsEligibleSuggestionsFieldsModel collectionsEligibleSuggestionsFieldsModel = (CollectionsEligibleSuggestionsFieldsModel) obj;
                if (collectionsEligibleSuggestionsFieldsModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(collectionsEligibleSuggestionsFieldsModel.m14407a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    collectionsEligibleSuggestionsFieldsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                CollectionsEligibleSuggestionsFieldsParser.m14473a(collectionsEligibleSuggestionsFieldsModel.w_(), collectionsEligibleSuggestionsFieldsModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(CollectionsEligibleSuggestionsFieldsModel.class, new Serializer());
            }
        }

        @Nullable
        public final /* synthetic */ DefaultPageInfoFields m14410b() {
            return m14406j();
        }

        public CollectionsEligibleSuggestionsFieldsModel() {
            super(2);
        }

        public CollectionsEligibleSuggestionsFieldsModel(MutableFlatBuffer mutableFlatBuffer) {
            super(2);
            a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
        }

        @Nonnull
        public final ImmutableList<AppCollectionSuggestionFieldsModel> m14409a() {
            this.f13375d = super.a(this.f13375d, 0, AppCollectionSuggestionFieldsModel.class);
            return (ImmutableList) this.f13375d;
        }

        @Nullable
        private DefaultPageInfoFieldsModel m14406j() {
            this.f13376e = (DefaultPageInfoFieldsModel) super.a(this.f13376e, 1, DefaultPageInfoFieldsModel.class);
            return this.f13376e;
        }

        public static CollectionsEligibleSuggestionsFieldsModel m14405a(CollectionsEligibleSuggestionsFieldsModel collectionsEligibleSuggestionsFieldsModel) {
            if (collectionsEligibleSuggestionsFieldsModel == null) {
                return null;
            }
            if (collectionsEligibleSuggestionsFieldsModel instanceof CollectionsEligibleSuggestionsFieldsModel) {
                return collectionsEligibleSuggestionsFieldsModel;
            }
            Builder builder = new Builder();
            com.google.common.collect.ImmutableList.Builder builder2 = ImmutableList.builder();
            for (int i = 0; i < collectionsEligibleSuggestionsFieldsModel.m14409a().size(); i++) {
                builder2.c(AppCollectionSuggestionFieldsModel.m14315a((AppCollectionSuggestionFieldsModel) collectionsEligibleSuggestionsFieldsModel.m14409a().get(i)));
            }
            builder.f13373a = builder2.b();
            builder.f13374b = DefaultPageInfoFieldsModel.a(collectionsEligibleSuggestionsFieldsModel.m14410b());
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
            int a = ModelHelper.a(flatBufferBuilder, builder.f13373a);
            int a2 = ModelHelper.a(flatBufferBuilder, builder.f13374b);
            flatBufferBuilder.c(2);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, a2);
            flatBufferBuilder.d(flatBufferBuilder.d());
            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
            wrap.position(0);
            return new CollectionsEligibleSuggestionsFieldsModel(new MutableFlatBuffer(wrap, null, null, true, null));
        }

        public final int jK_() {
            return -681797361;
        }

        public final GraphQLVisitableModel m14408a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel;
            DefaultPageInfoFieldsModel defaultPageInfoFieldsModel;
            h();
            if (m14409a() != null) {
                com.google.common.collect.ImmutableList.Builder a = ModelHelper.a(m14409a(), graphQLModelMutatingVisitor);
                if (a != null) {
                    CollectionsEligibleSuggestionsFieldsModel collectionsEligibleSuggestionsFieldsModel = (CollectionsEligibleSuggestionsFieldsModel) ModelHelper.a(null, this);
                    collectionsEligibleSuggestionsFieldsModel.f13375d = a.b();
                    graphQLVisitableModel = collectionsEligibleSuggestionsFieldsModel;
                    if (m14406j() != null) {
                        defaultPageInfoFieldsModel = (DefaultPageInfoFieldsModel) graphQLModelMutatingVisitor.b(m14406j());
                        if (m14406j() != defaultPageInfoFieldsModel) {
                            graphQLVisitableModel = (CollectionsEligibleSuggestionsFieldsModel) ModelHelper.a(graphQLVisitableModel, this);
                            graphQLVisitableModel.f13376e = defaultPageInfoFieldsModel;
                        }
                    }
                    i();
                    return graphQLVisitableModel != null ? this : graphQLVisitableModel;
                }
            }
            graphQLVisitableModel = null;
            if (m14406j() != null) {
                defaultPageInfoFieldsModel = (DefaultPageInfoFieldsModel) graphQLModelMutatingVisitor.b(m14406j());
                if (m14406j() != defaultPageInfoFieldsModel) {
                    graphQLVisitableModel = (CollectionsEligibleSuggestionsFieldsModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f13376e = defaultPageInfoFieldsModel;
                }
            }
            i();
            if (graphQLVisitableModel != null) {
            }
        }

        public final int m14407a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m14409a());
            int a2 = ModelHelper.a(flatBufferBuilder, m14406j());
            flatBufferBuilder.c(2);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, a2);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -1479004855)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: MarketplaceLocationDialogCancelled */
    public final class CollectionsFirstFiveGroupMembersFieldsModel extends BaseModel implements GraphQLVisitableConsistentModel, CollectionsFirstFiveGroupMembersFields {
        @Nullable
        private GroupMembersModel f13379d;

        /* compiled from: MarketplaceLocationDialogCancelled */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(CollectionsFirstFiveGroupMembersFieldsModel.class, new Deserializer());
            }

            public Object m14411a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = CollectionsFirstFiveGroupMembersFieldsParser.m14476a(jsonParser);
                Object collectionsFirstFiveGroupMembersFieldsModel = new CollectionsFirstFiveGroupMembersFieldsModel();
                ((BaseModel) collectionsFirstFiveGroupMembersFieldsModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (collectionsFirstFiveGroupMembersFieldsModel instanceof Postprocessable) {
                    return ((Postprocessable) collectionsFirstFiveGroupMembersFieldsModel).a();
                }
                return collectionsFirstFiveGroupMembersFieldsModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 835178162)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: MarketplaceLocationDialogCancelled */
        public final class GroupMembersModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private List<CollectionGroupMembersFieldsModel> f13378d;

            /* compiled from: MarketplaceLocationDialogCancelled */
            public final class Builder {
                @Nullable
                public ImmutableList<CollectionGroupMembersFieldsModel> f13377a;
            }

            /* compiled from: MarketplaceLocationDialogCancelled */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(GroupMembersModel.class, new Deserializer());
                }

                public Object m14412a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(GroupMembersParser.m14474a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object groupMembersModel = new GroupMembersModel();
                    ((BaseModel) groupMembersModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (groupMembersModel instanceof Postprocessable) {
                        return ((Postprocessable) groupMembersModel).a();
                    }
                    return groupMembersModel;
                }
            }

            /* compiled from: MarketplaceLocationDialogCancelled */
            public class Serializer extends JsonSerializer<GroupMembersModel> {
                public final void m14413a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    GroupMembersModel groupMembersModel = (GroupMembersModel) obj;
                    if (groupMembersModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(groupMembersModel.m14415a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        groupMembersModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    GroupMembersParser.m14475a(groupMembersModel.w_(), groupMembersModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(GroupMembersModel.class, new Serializer());
                }
            }

            public GroupMembersModel() {
                super(1);
            }

            public GroupMembersModel(MutableFlatBuffer mutableFlatBuffer) {
                super(1);
                a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
            }

            @Nonnull
            public final ImmutableList<CollectionGroupMembersFieldsModel> m14417a() {
                this.f13378d = super.a(this.f13378d, 0, CollectionGroupMembersFieldsModel.class);
                return (ImmutableList) this.f13378d;
            }

            public static GroupMembersModel m14414a(GroupMembersModel groupMembersModel) {
                if (groupMembersModel == null) {
                    return null;
                }
                if (groupMembersModel instanceof GroupMembersModel) {
                    return groupMembersModel;
                }
                Builder builder = new Builder();
                com.google.common.collect.ImmutableList.Builder builder2 = ImmutableList.builder();
                for (int i = 0; i < groupMembersModel.m14417a().size(); i++) {
                    builder2.c(CollectionGroupMembersFieldsModel.m14332a((CollectionGroupMembersFieldsModel) groupMembersModel.m14417a().get(i)));
                }
                builder.f13377a = builder2.b();
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                int a = ModelHelper.a(flatBufferBuilder, builder.f13377a);
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.d(flatBufferBuilder.d());
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                return new GroupMembersModel(new MutableFlatBuffer(wrap, null, null, true, null));
            }

            public final int jK_() {
                return 103365688;
            }

            public final GraphQLVisitableModel m14416a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m14417a() != null) {
                    com.google.common.collect.ImmutableList.Builder a = ModelHelper.a(m14417a(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        graphQLVisitableModel = (GroupMembersModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f13378d = a.b();
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m14415a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m14417a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, a);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: MarketplaceLocationDialogCancelled */
        public class Serializer extends JsonSerializer<CollectionsFirstFiveGroupMembersFieldsModel> {
            public final void m14418a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                CollectionsFirstFiveGroupMembersFieldsModel collectionsFirstFiveGroupMembersFieldsModel = (CollectionsFirstFiveGroupMembersFieldsModel) obj;
                if (collectionsFirstFiveGroupMembersFieldsModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(collectionsFirstFiveGroupMembersFieldsModel.m14420a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    collectionsFirstFiveGroupMembersFieldsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = collectionsFirstFiveGroupMembersFieldsModel.w_();
                int u_ = collectionsFirstFiveGroupMembersFieldsModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("group_members");
                    GroupMembersParser.m14475a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(CollectionsFirstFiveGroupMembersFieldsModel.class, new Serializer());
            }
        }

        public CollectionsFirstFiveGroupMembersFieldsModel() {
            super(1);
        }

        public final void m14422a(String str, ConsistencyTuple consistencyTuple) {
            consistencyTuple.a();
        }

        public final void m14423a(String str, Object obj, boolean z) {
        }

        @Nullable
        private GroupMembersModel m14419a() {
            this.f13379d = (GroupMembersModel) super.a(this.f13379d, 0, GroupMembersModel.class);
            return this.f13379d;
        }

        public final int jK_() {
            return 69076575;
        }

        public final GraphQLVisitableModel m14421a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m14419a() != null) {
                GroupMembersModel groupMembersModel = (GroupMembersModel) graphQLModelMutatingVisitor.b(m14419a());
                if (m14419a() != groupMembersModel) {
                    graphQLVisitableModel = (CollectionsFirstFiveGroupMembersFieldsModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f13379d = groupMembersModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m14420a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m14419a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 1801334754)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: MarketplaceLocationDialogCancelled */
    public final class CollectionsNodeIdFieldsModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel, CollectionsNodeIdFields {
        @Nullable
        private String f13380d;

        /* compiled from: MarketplaceLocationDialogCancelled */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(CollectionsNodeIdFieldsModel.class, new Deserializer());
            }

            public Object m14424a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(CollectionsNodeIdFieldsParser.m14478b(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object collectionsNodeIdFieldsModel = new CollectionsNodeIdFieldsModel();
                ((BaseModel) collectionsNodeIdFieldsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (collectionsNodeIdFieldsModel instanceof Postprocessable) {
                    return ((Postprocessable) collectionsNodeIdFieldsModel).a();
                }
                return collectionsNodeIdFieldsModel;
            }
        }

        /* compiled from: MarketplaceLocationDialogCancelled */
        public class Serializer extends JsonSerializer<CollectionsNodeIdFieldsModel> {
            public final void m14425a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                CollectionsNodeIdFieldsModel collectionsNodeIdFieldsModel = (CollectionsNodeIdFieldsModel) obj;
                if (collectionsNodeIdFieldsModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(collectionsNodeIdFieldsModel.m14426a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    collectionsNodeIdFieldsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                CollectionsNodeIdFieldsParser.m14477a(collectionsNodeIdFieldsModel.w_(), collectionsNodeIdFieldsModel.u_(), jsonGenerator);
            }

            static {
                FbSerializerProvider.a(CollectionsNodeIdFieldsModel.class, new Serializer());
            }
        }

        public CollectionsNodeIdFieldsModel() {
            super(1);
        }

        @Nullable
        public final String mo395c() {
            this.f13380d = super.a(this.f13380d, 0);
            return this.f13380d;
        }

        @Nullable
        public final String m14428a() {
            return mo395c();
        }

        public final int jK_() {
            return -1476137794;
        }

        public final GraphQLVisitableModel m14427a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            h();
            i();
            return this;
        }

        public final int m14426a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(mo395c());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, b);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 344949562)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: MarketplaceLocationDialogCancelled */
    public final class CollectionsNodePeekFieldsModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel, CollectionsNodePeekFields {
        @Nullable
        private String f13381d;
        @Nullable
        private List<GraphQLTimelineAppCollectionStyle> f13382e;

        /* compiled from: MarketplaceLocationDialogCancelled */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(CollectionsNodePeekFieldsModel.class, new Deserializer());
            }

            public Object m14430a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(CollectionsNodePeekFieldsParser.m14480b(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object collectionsNodePeekFieldsModel = new CollectionsNodePeekFieldsModel();
                ((BaseModel) collectionsNodePeekFieldsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (collectionsNodePeekFieldsModel instanceof Postprocessable) {
                    return ((Postprocessable) collectionsNodePeekFieldsModel).a();
                }
                return collectionsNodePeekFieldsModel;
            }
        }

        /* compiled from: MarketplaceLocationDialogCancelled */
        public class Serializer extends JsonSerializer<CollectionsNodePeekFieldsModel> {
            public final void m14431a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                CollectionsNodePeekFieldsModel collectionsNodePeekFieldsModel = (CollectionsNodePeekFieldsModel) obj;
                if (collectionsNodePeekFieldsModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(collectionsNodePeekFieldsModel.m14432a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    collectionsNodePeekFieldsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                CollectionsNodePeekFieldsParser.m14479a(collectionsNodePeekFieldsModel.w_(), collectionsNodePeekFieldsModel.u_(), jsonGenerator);
            }

            static {
                FbSerializerProvider.a(CollectionsNodePeekFieldsModel.class, new Serializer());
            }
        }

        public CollectionsNodePeekFieldsModel() {
            super(2);
        }

        @Nullable
        public final String mo395c() {
            this.f13381d = super.a(this.f13381d, 0);
            return this.f13381d;
        }

        @Nonnull
        public final ImmutableList<GraphQLTimelineAppCollectionStyle> mo396d() {
            this.f13382e = super.c(this.f13382e, 1, GraphQLTimelineAppCollectionStyle.class);
            return (ImmutableList) this.f13382e;
        }

        @Nullable
        public final String m14434a() {
            return mo395c();
        }

        public final int jK_() {
            return -1476137794;
        }

        public final GraphQLVisitableModel m14433a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            h();
            i();
            return this;
        }

        public final int m14432a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(mo395c());
            int d = flatBufferBuilder.d(mo396d());
            flatBufferBuilder.c(2);
            flatBufferBuilder.b(0, b);
            flatBufferBuilder.b(1, d);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -195708678)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: MarketplaceLocationDialogCancelled */
    public final class CollectionsPeekFieldsModel extends BaseModel implements GraphQLVisitableModel {
        private int f13383d;
        @Nullable
        private List<CollectionsNodePeekFieldsModel> f13384e;

        /* compiled from: MarketplaceLocationDialogCancelled */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(CollectionsPeekFieldsModel.class, new Deserializer());
            }

            public Object m14437a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(CollectionsPeekFieldsParser.m14481a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object collectionsPeekFieldsModel = new CollectionsPeekFieldsModel();
                ((BaseModel) collectionsPeekFieldsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (collectionsPeekFieldsModel instanceof Postprocessable) {
                    return ((Postprocessable) collectionsPeekFieldsModel).a();
                }
                return collectionsPeekFieldsModel;
            }
        }

        /* compiled from: MarketplaceLocationDialogCancelled */
        public class Serializer extends JsonSerializer<CollectionsPeekFieldsModel> {
            public final void m14438a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                CollectionsPeekFieldsModel collectionsPeekFieldsModel = (CollectionsPeekFieldsModel) obj;
                if (collectionsPeekFieldsModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(collectionsPeekFieldsModel.m14440a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    collectionsPeekFieldsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                CollectionsPeekFieldsParser.m14482a(collectionsPeekFieldsModel.w_(), collectionsPeekFieldsModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(CollectionsPeekFieldsModel.class, new Serializer());
            }
        }

        public CollectionsPeekFieldsModel() {
            super(2);
        }

        public final int m14439a() {
            a(0, 0);
            return this.f13383d;
        }

        @Nonnull
        public final ImmutableList<CollectionsNodePeekFieldsModel> m14443b() {
            this.f13384e = super.a(this.f13384e, 1, CollectionsNodePeekFieldsModel.class);
            return (ImmutableList) this.f13384e;
        }

        public final int jK_() {
            return -306448333;
        }

        public final GraphQLVisitableModel m14441a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m14443b() != null) {
                Builder a = ModelHelper.a(m14443b(), graphQLModelMutatingVisitor);
                if (a != null) {
                    graphQLVisitableModel = (CollectionsPeekFieldsModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f13384e = a.b();
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m14440a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m14443b());
            flatBufferBuilder.c(2);
            flatBufferBuilder.a(0, this.f13383d, 0);
            flatBufferBuilder.b(1, a);
            i();
            return flatBufferBuilder.d();
        }

        public final void m14442a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
            super.a(mutableFlatBuffer, i, obj);
            this.f13383d = mutableFlatBuffer.a(i, 0, 0);
        }
    }
}
