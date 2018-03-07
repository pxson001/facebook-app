package com.facebook.timeline.protocol;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbSerializerProvider;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.FragmentModelWithoutBridge;
import com.facebook.flatbuffers.ModelWithFlatBufferFormatHash;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.enums.GraphQLFriendshipStatus;
import com.facebook.graphql.enums.GraphQLObjectType;
import com.facebook.graphql.enums.GraphQLSecondarySubscribeStatus;
import com.facebook.graphql.enums.GraphQLSubscribeStatus;
import com.facebook.graphql.enums.GraphQLTimelineContextListItemType;
import com.facebook.graphql.enums.GraphQLTimelineContextListTargetType;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.querybuilder.common.CommonGraphQL2Interfaces.DefaultVect2Fields;
import com.facebook.graphql.querybuilder.common.CommonGraphQL2Models.DefaultNamePartFieldsModel;
import com.facebook.graphql.querybuilder.common.CommonGraphQL2Models.DefaultVect2FieldsModel;
import com.facebook.graphql.querybuilder.common.CommonGraphQLInterfaces.DefaultImageFields;
import com.facebook.graphql.querybuilder.common.CommonGraphQLModels.DefaultImageFieldsModel;
import com.facebook.graphql.querybuilder.common.CommonGraphQLParsers.DefaultImageFieldsParser;
import com.facebook.graphql.querybuilder.common.TextWithEntitiesGraphQLInterfaces.DefaultTextWithEntitiesFields;
import com.facebook.graphql.querybuilder.common.TextWithEntitiesGraphQLModels.DefaultTextWithEntitiesFieldsModel;
import com.facebook.graphql.visitor.ConsistencyTuple;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLPersistableNode;
import com.facebook.graphql.visitor.GraphQLVisitableConsistentModel;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.facebook.ipc.composer.intent.graphql.FetchComposerTargetDataPrivacyScopeInterfaces.ComposerTargetDataPrivacyScopeFields;
import com.facebook.ipc.composer.intent.graphql.FetchComposerTargetDataPrivacyScopeModels.ComposerTargetDataPrivacyScopeFieldsModel;
import com.facebook.photos.data.protocol.PhotosDefaultsGraphQLInterfaces.SizeAwareMedia;
import com.facebook.timeline.profilevideo.playback.protocol.FetchProfileVideoGraphQLModels.ProfileHeaderAssociatedVideoModel;
import com.facebook.timeline.protocol.FetchTimelineHeaderGraphQLInterfaces.CollageLayoutFields;
import com.facebook.timeline.protocol.FetchTimelineHeaderGraphQLInterfaces.TimelineContextListItemPhotoNodeFields;
import com.facebook.timeline.protocol.FetchTimelineHeaderGraphQLInterfaces.TimelineNuxFields;
import com.facebook.timeline.protocol.FetchTimelineHeaderGraphQLInterfaces.TimelineRefresherFields;
import com.facebook.timeline.protocol.FetchTimelineHeaderGraphQLParsers.CollageLayoutFieldsParser;
import com.facebook.timeline.protocol.FetchTimelineHeaderGraphQLParsers.ExternalLinkParser;
import com.facebook.timeline.protocol.FetchTimelineHeaderGraphQLParsers.ExternalLinkParser.LinkTypeParser;
import com.facebook.timeline.protocol.FetchTimelineHeaderGraphQLParsers.FavoritePhotoParser;
import com.facebook.timeline.protocol.FetchTimelineHeaderGraphQLParsers.IntroCardContextListItemsConnectionFieldsParser;
import com.facebook.timeline.protocol.FetchTimelineHeaderGraphQLParsers.IntroCardPhotoFieldsParser;
import com.facebook.timeline.protocol.FetchTimelineHeaderGraphQLParsers.SuggestedPhotoParser;
import com.facebook.timeline.protocol.FetchTimelineHeaderGraphQLParsers.TimelineContextItemsPageInfoParser;
import com.facebook.timeline.protocol.FetchTimelineHeaderGraphQLParsers.TimelineContextListItemFieldsParser;
import com.facebook.timeline.protocol.FetchTimelineHeaderGraphQLParsers.TimelineContextListItemFieldsParser.BadgeCountParser;
import com.facebook.timeline.protocol.FetchTimelineHeaderGraphQLParsers.TimelineContextListItemFieldsParser.NodeParser;
import com.facebook.timeline.protocol.FetchTimelineHeaderGraphQLParsers.TimelineContextListItemFieldsParser.TitleParser;
import com.facebook.timeline.protocol.FetchTimelineHeaderGraphQLParsers.TimelineContextListItemPhotoNodeFieldsParser;
import com.facebook.timeline.protocol.FetchTimelineHeaderGraphQLParsers.TimelineContextListItemPhotoNodeFieldsParser.AlbumParser;
import com.facebook.timeline.protocol.FetchTimelineHeaderGraphQLParsers.TimelineContextListItemsConnectionFieldsParser;
import com.facebook.timeline.protocol.FetchTimelineHeaderGraphQLParsers.TimelineHeaderCoverPhotoFieldsParser;
import com.facebook.timeline.protocol.FetchTimelineHeaderGraphQLParsers.TimelineHeaderFocusedCoverPhotoFieldsParser;
import com.facebook.timeline.protocol.FetchTimelineHeaderGraphQLParsers.TimelineHeaderProfileIntroCardFieldsParser;
import com.facebook.timeline.protocol.FetchTimelineHeaderGraphQLParsers.TimelineHeaderProfileIntroCardFieldsParser.ActionLinksParser;
import com.facebook.timeline.protocol.FetchTimelineHeaderGraphQLParsers.TimelineHeaderProfileIntroCardFieldsParser.ActionLinksParser.DescriptionParser;
import com.facebook.timeline.protocol.FetchTimelineHeaderGraphQLParsers.TimelineHeaderProfileIntroCardFieldsParser.FavoritePhotosParser;
import com.facebook.timeline.protocol.FetchTimelineHeaderGraphQLParsers.TimelineHeaderProfileIntroCardFieldsParser.SuggestedPhotosParser;
import com.facebook.timeline.protocol.FetchTimelineHeaderGraphQLParsers.TimelineHeaderProfilePhotoFieldsParser;
import com.facebook.timeline.protocol.FetchTimelineHeaderGraphQLParsers.TimelineHeaderStructuredNameParser;
import com.facebook.timeline.protocol.FetchTimelineHeaderGraphQLParsers.TimelineHeaderUserFieldsParser;
import com.facebook.timeline.protocol.FetchTimelineHeaderGraphQLParsers.TimelineNuxFieldsParser;
import com.facebook.timeline.protocol.FetchTimelineHeaderGraphQLParsers.TimelineNuxFieldsParser.ProfileWizardNuxParser;
import com.facebook.timeline.protocol.FetchTimelineHeaderGraphQLParsers.TimelineRefresherFieldsParser;
import com.facebook.timeline.protocol.FetchTimelineHeaderGraphQLParsers.TimelineRefresherFieldsParser.ProfileWizardRefresherParser;
import com.facebook.timeline.protocol.FetchTimelineHeaderGraphQLParsers.TimelineRefresherFieldsParser.ProfileWizardRefresherParser.StepsParser;
import com.facebook.timeline.protocol.FetchTimelineHeaderGraphQLParsers.UserTimelineSelfQueryFieldsParser;
import com.facebook.timeline.protocol.FetchTimelineHeaderGraphQLParsers.ViewerTopFriendsQueryParser;
import com.facebook.timeline.protocol.FetchTimelineHeaderGraphQLParsers.ViewerTopFriendsQueryParser.FollowedProfilesParser;
import com.facebook.timeline.protocol.FetchTimelineHeaderGraphQLParsers.ViewerTopFriendsQueryParser.FollowedProfilesParser.NodesParser;
import com.facebook.timeline.widget.actionbar.protocol.TimelineHeaderActionFieldsGraphQLInterfaces.TimelineHeaderActionFields;
import com.facebook.timeline.widget.actionbar.protocol.TimelineHeaderActionFieldsGraphQLModels.TimelineHeaderActionFieldsModel.FriendsModel;
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

/* compiled from: delete_app_and_posts */
public class FetchTimelineHeaderGraphQLModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 611352277)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: delete_app_and_posts */
    public final class CollageLayoutFieldsModel extends BaseModel implements GraphQLVisitableModel, CollageLayoutFields {
        private double f17652d;
        private double f17653e;
        private double f17654f;
        private double f17655g;

        /* compiled from: delete_app_and_posts */
        public final class Builder {
            public double f17648a;
            public double f17649b;
            public double f17650c;
            public double f17651d;

            public final CollageLayoutFieldsModel m25706a() {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.c(4);
                flatBufferBuilder.a(0, this.f17648a, 0.0d);
                flatBufferBuilder.a(1, this.f17649b, 0.0d);
                flatBufferBuilder.a(2, this.f17650c, 0.0d);
                flatBufferBuilder.a(3, this.f17651d, 0.0d);
                flatBufferBuilder.d(flatBufferBuilder.d());
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                return new CollageLayoutFieldsModel(new MutableFlatBuffer(wrap, null, null, true, null));
            }
        }

        /* compiled from: delete_app_and_posts */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(CollageLayoutFieldsModel.class, new Deserializer());
            }

            public Object m25707a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(CollageLayoutFieldsParser.m26050a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object collageLayoutFieldsModel = new CollageLayoutFieldsModel();
                ((BaseModel) collageLayoutFieldsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (collageLayoutFieldsModel instanceof Postprocessable) {
                    return ((Postprocessable) collageLayoutFieldsModel).a();
                }
                return collageLayoutFieldsModel;
            }
        }

        /* compiled from: delete_app_and_posts */
        public class Serializer extends JsonSerializer<CollageLayoutFieldsModel> {
            public final void m25708a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                CollageLayoutFieldsModel collageLayoutFieldsModel = (CollageLayoutFieldsModel) obj;
                if (collageLayoutFieldsModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(collageLayoutFieldsModel.m25710a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    collageLayoutFieldsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                CollageLayoutFieldsParser.m26051a(collageLayoutFieldsModel.w_(), collageLayoutFieldsModel.u_(), jsonGenerator);
            }

            static {
                FbSerializerProvider.a(CollageLayoutFieldsModel.class, new Serializer());
            }
        }

        public CollageLayoutFieldsModel() {
            super(4);
        }

        public CollageLayoutFieldsModel(MutableFlatBuffer mutableFlatBuffer) {
            super(4);
            a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
        }

        public final double mo1326a() {
            a(0, 0);
            return this.f17652d;
        }

        public final double mo1327b() {
            a(0, 1);
            return this.f17653e;
        }

        public final double mo1328c() {
            a(0, 2);
            return this.f17654f;
        }

        public final double mo1329d() {
            a(0, 3);
            return this.f17655g;
        }

        public final int jK_() {
            return -1169699505;
        }

        public final GraphQLVisitableModel m25711a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            h();
            i();
            return this;
        }

        public final int m25710a(FlatBufferBuilder flatBufferBuilder) {
            h();
            flatBufferBuilder.c(4);
            flatBufferBuilder.a(0, this.f17652d, 0.0d);
            flatBufferBuilder.a(1, this.f17653e, 0.0d);
            flatBufferBuilder.a(2, this.f17654f, 0.0d);
            flatBufferBuilder.a(3, this.f17655g, 0.0d);
            i();
            return flatBufferBuilder.d();
        }

        public final void m25712a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
            super.a(mutableFlatBuffer, i, obj);
            this.f17652d = mutableFlatBuffer.a(i, 0, 0.0d);
            this.f17653e = mutableFlatBuffer.a(i, 1, 0.0d);
            this.f17654f = mutableFlatBuffer.a(i, 2, 0.0d);
            this.f17655g = mutableFlatBuffer.a(i, 3, 0.0d);
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 1554089748)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: delete_app_and_posts */
    public final class ExternalLinkModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private DefaultImageFieldsModel f17657d;
        @Nullable
        private LinkTypeModel f17658e;
        @Nullable
        private String f17659f;
        @Nullable
        private String f17660g;

        /* compiled from: delete_app_and_posts */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(ExternalLinkModel.class, new Deserializer());
            }

            public Object m25716a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(ExternalLinkParser.m26055b(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object externalLinkModel = new ExternalLinkModel();
                ((BaseModel) externalLinkModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (externalLinkModel instanceof Postprocessable) {
                    return ((Postprocessable) externalLinkModel).a();
                }
                return externalLinkModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1352864475)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: delete_app_and_posts */
        public final class LinkTypeModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private String f17656d;

            /* compiled from: delete_app_and_posts */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(LinkTypeModel.class, new Deserializer());
                }

                public Object m25717a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(LinkTypeParser.m26052a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object linkTypeModel = new LinkTypeModel();
                    ((BaseModel) linkTypeModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (linkTypeModel instanceof Postprocessable) {
                        return ((Postprocessable) linkTypeModel).a();
                    }
                    return linkTypeModel;
                }
            }

            /* compiled from: delete_app_and_posts */
            public class Serializer extends JsonSerializer<LinkTypeModel> {
                public final void m25718a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    LinkTypeModel linkTypeModel = (LinkTypeModel) obj;
                    if (linkTypeModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(linkTypeModel.m25719a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        linkTypeModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    LinkTypeParser.m26053a(linkTypeModel.w_(), linkTypeModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(LinkTypeModel.class, new Serializer());
                }
            }

            public LinkTypeModel() {
                super(1);
            }

            @Nullable
            public final String m25721a() {
                this.f17656d = super.a(this.f17656d, 0);
                return this.f17656d;
            }

            public final int jK_() {
                return -1919764332;
            }

            public final GraphQLVisitableModel m25720a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m25719a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m25721a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, b);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: delete_app_and_posts */
        public class Serializer extends JsonSerializer<ExternalLinkModel> {
            public final void m25722a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                ExternalLinkModel externalLinkModel = (ExternalLinkModel) obj;
                if (externalLinkModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(externalLinkModel.m25725a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    externalLinkModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                ExternalLinkParser.m26056b(externalLinkModel.w_(), externalLinkModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(ExternalLinkModel.class, new Serializer());
            }
        }

        @Nullable
        public final /* synthetic */ DefaultImageFields m25726a() {
            return m25723j();
        }

        @Nullable
        public final /* synthetic */ LinkTypeModel m25728b() {
            return m25724k();
        }

        public ExternalLinkModel() {
            super(4);
        }

        @Nullable
        private DefaultImageFieldsModel m25723j() {
            this.f17657d = (DefaultImageFieldsModel) super.a(this.f17657d, 0, DefaultImageFieldsModel.class);
            return this.f17657d;
        }

        @Nullable
        private LinkTypeModel m25724k() {
            this.f17658e = (LinkTypeModel) super.a(this.f17658e, 1, LinkTypeModel.class);
            return this.f17658e;
        }

        @Nullable
        public final String m25729c() {
            this.f17659f = super.a(this.f17659f, 2);
            return this.f17659f;
        }

        @Nullable
        public final String m25730d() {
            this.f17660g = super.a(this.f17660g, 3);
            return this.f17660g;
        }

        public final int jK_() {
            return -1654121842;
        }

        public final GraphQLVisitableModel m25727a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m25723j() != null) {
                DefaultImageFieldsModel defaultImageFieldsModel = (DefaultImageFieldsModel) graphQLModelMutatingVisitor.b(m25723j());
                if (m25723j() != defaultImageFieldsModel) {
                    graphQLVisitableModel = (ExternalLinkModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f17657d = defaultImageFieldsModel;
                }
            }
            if (m25724k() != null) {
                LinkTypeModel linkTypeModel = (LinkTypeModel) graphQLModelMutatingVisitor.b(m25724k());
                if (m25724k() != linkTypeModel) {
                    graphQLVisitableModel = (ExternalLinkModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f17658e = linkTypeModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m25725a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m25723j());
            int a2 = ModelHelper.a(flatBufferBuilder, m25724k());
            int b = flatBufferBuilder.b(m25729c());
            int b2 = flatBufferBuilder.b(m25730d());
            flatBufferBuilder.c(4);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, a2);
            flatBufferBuilder.b(2, b);
            flatBufferBuilder.b(3, b2);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -1456496102)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: delete_app_and_posts */
    public final class FavoritePhotoModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private CollageLayoutFieldsModel f17663d;
        @Nullable
        private IntroCardPhotoFieldsModel f17664e;

        /* compiled from: delete_app_and_posts */
        public final class Builder {
            @Nullable
            public CollageLayoutFieldsModel f17661a;
            @Nullable
            public IntroCardPhotoFieldsModel f17662b;

            public final FavoritePhotoModel m25731a() {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                int a = ModelHelper.a(flatBufferBuilder, this.f17661a);
                int a2 = ModelHelper.a(flatBufferBuilder, this.f17662b);
                flatBufferBuilder.c(2);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.b(1, a2);
                flatBufferBuilder.d(flatBufferBuilder.d());
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                return new FavoritePhotoModel(new MutableFlatBuffer(wrap, null, null, true, null));
            }
        }

        /* compiled from: delete_app_and_posts */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(FavoritePhotoModel.class, new Deserializer());
            }

            public Object m25732a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(FavoritePhotoParser.m26059b(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object favoritePhotoModel = new FavoritePhotoModel();
                ((BaseModel) favoritePhotoModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (favoritePhotoModel instanceof Postprocessable) {
                    return ((Postprocessable) favoritePhotoModel).a();
                }
                return favoritePhotoModel;
            }
        }

        /* compiled from: delete_app_and_posts */
        public class Serializer extends JsonSerializer<FavoritePhotoModel> {
            public final void m25733a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                FavoritePhotoModel favoritePhotoModel = (FavoritePhotoModel) obj;
                if (favoritePhotoModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(favoritePhotoModel.m25736a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    favoritePhotoModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                FavoritePhotoParser.m26060b(favoritePhotoModel.w_(), favoritePhotoModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(FavoritePhotoModel.class, new Serializer());
            }
        }

        @Nullable
        public final /* synthetic */ CollageLayoutFields m25738a() {
            return m25734j();
        }

        @Nullable
        public final /* synthetic */ IntroCardPhotoFieldsModel m25739b() {
            return m25735k();
        }

        public FavoritePhotoModel() {
            super(2);
        }

        public FavoritePhotoModel(MutableFlatBuffer mutableFlatBuffer) {
            super(2);
            a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
        }

        @Nullable
        private CollageLayoutFieldsModel m25734j() {
            this.f17663d = (CollageLayoutFieldsModel) super.a(this.f17663d, 0, CollageLayoutFieldsModel.class);
            return this.f17663d;
        }

        @Nullable
        private IntroCardPhotoFieldsModel m25735k() {
            this.f17664e = (IntroCardPhotoFieldsModel) super.a(this.f17664e, 1, IntroCardPhotoFieldsModel.class);
            return this.f17664e;
        }

        public final int jK_() {
            return -517732833;
        }

        public final GraphQLVisitableModel m25737a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m25734j() != null) {
                CollageLayoutFieldsModel collageLayoutFieldsModel = (CollageLayoutFieldsModel) graphQLModelMutatingVisitor.b(m25734j());
                if (m25734j() != collageLayoutFieldsModel) {
                    graphQLVisitableModel = (FavoritePhotoModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f17663d = collageLayoutFieldsModel;
                }
            }
            if (m25735k() != null) {
                IntroCardPhotoFieldsModel introCardPhotoFieldsModel = (IntroCardPhotoFieldsModel) graphQLModelMutatingVisitor.b(m25735k());
                if (m25735k() != introCardPhotoFieldsModel) {
                    graphQLVisitableModel = (FavoritePhotoModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f17664e = introCardPhotoFieldsModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m25736a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m25734j());
            int a2 = ModelHelper.a(flatBufferBuilder, m25735k());
            flatBufferBuilder.c(2);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, a2);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -1995117166)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: delete_app_and_posts */
    public final class IntroCardContextListItemsConnectionFieldsModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private List<TimelineContextListItemFieldsModel> f17665d;
        @Nullable
        private TimelineContextItemsPageInfoModel f17666e;

        /* compiled from: delete_app_and_posts */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(IntroCardContextListItemsConnectionFieldsModel.class, new Deserializer());
            }

            public Object m25740a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(IntroCardContextListItemsConnectionFieldsParser.m26061a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object introCardContextListItemsConnectionFieldsModel = new IntroCardContextListItemsConnectionFieldsModel();
                ((BaseModel) introCardContextListItemsConnectionFieldsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (introCardContextListItemsConnectionFieldsModel instanceof Postprocessable) {
                    return ((Postprocessable) introCardContextListItemsConnectionFieldsModel).a();
                }
                return introCardContextListItemsConnectionFieldsModel;
            }
        }

        /* compiled from: delete_app_and_posts */
        public class Serializer extends JsonSerializer<IntroCardContextListItemsConnectionFieldsModel> {
            public final void m25741a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                IntroCardContextListItemsConnectionFieldsModel introCardContextListItemsConnectionFieldsModel = (IntroCardContextListItemsConnectionFieldsModel) obj;
                if (introCardContextListItemsConnectionFieldsModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(introCardContextListItemsConnectionFieldsModel.m25743a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    introCardContextListItemsConnectionFieldsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                IntroCardContextListItemsConnectionFieldsParser.m26062a(introCardContextListItemsConnectionFieldsModel.w_(), introCardContextListItemsConnectionFieldsModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(IntroCardContextListItemsConnectionFieldsModel.class, new Serializer());
            }
        }

        @Nullable
        public final /* synthetic */ TimelineContextItemsPageInfoModel m25746b() {
            return m25742j();
        }

        public IntroCardContextListItemsConnectionFieldsModel() {
            super(2);
        }

        @Nonnull
        public final ImmutableList<TimelineContextListItemFieldsModel> m25745a() {
            this.f17665d = super.a(this.f17665d, 0, TimelineContextListItemFieldsModel.class);
            return (ImmutableList) this.f17665d;
        }

        @Nullable
        private TimelineContextItemsPageInfoModel m25742j() {
            this.f17666e = (TimelineContextItemsPageInfoModel) super.a(this.f17666e, 1, TimelineContextItemsPageInfoModel.class);
            return this.f17666e;
        }

        public final int jK_() {
            return 1364273067;
        }

        public final GraphQLVisitableModel m25744a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel;
            TimelineContextItemsPageInfoModel timelineContextItemsPageInfoModel;
            h();
            if (m25745a() != null) {
                Builder a = ModelHelper.a(m25745a(), graphQLModelMutatingVisitor);
                if (a != null) {
                    IntroCardContextListItemsConnectionFieldsModel introCardContextListItemsConnectionFieldsModel = (IntroCardContextListItemsConnectionFieldsModel) ModelHelper.a(null, this);
                    introCardContextListItemsConnectionFieldsModel.f17665d = a.b();
                    graphQLVisitableModel = introCardContextListItemsConnectionFieldsModel;
                    if (m25742j() != null) {
                        timelineContextItemsPageInfoModel = (TimelineContextItemsPageInfoModel) graphQLModelMutatingVisitor.b(m25742j());
                        if (m25742j() != timelineContextItemsPageInfoModel) {
                            graphQLVisitableModel = (IntroCardContextListItemsConnectionFieldsModel) ModelHelper.a(graphQLVisitableModel, this);
                            graphQLVisitableModel.f17666e = timelineContextItemsPageInfoModel;
                        }
                    }
                    i();
                    return graphQLVisitableModel != null ? this : graphQLVisitableModel;
                }
            }
            graphQLVisitableModel = null;
            if (m25742j() != null) {
                timelineContextItemsPageInfoModel = (TimelineContextItemsPageInfoModel) graphQLModelMutatingVisitor.b(m25742j());
                if (m25742j() != timelineContextItemsPageInfoModel) {
                    graphQLVisitableModel = (IntroCardContextListItemsConnectionFieldsModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f17666e = timelineContextItemsPageInfoModel;
                }
            }
            i();
            if (graphQLVisitableModel != null) {
            }
        }

        public final int m25743a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m25745a());
            int a2 = ModelHelper.a(flatBufferBuilder, m25742j());
            flatBufferBuilder.c(2);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, a2);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 1981549177)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: delete_app_and_posts */
    public final class IntroCardPhotoFieldsModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel, SizeAwareMedia {
        @Nullable
        private GraphQLObjectType f17675d;
        @Nullable
        private String f17676e;
        @Nullable
        private DefaultVect2FieldsModel f17677f;
        @Nullable
        private String f17678g;
        @Nullable
        private DefaultImageFieldsModel f17679h;
        @Nullable
        private DefaultImageFieldsModel f17680i;
        @Nullable
        private DefaultImageFieldsModel f17681j;
        @Nullable
        private DefaultImageFieldsModel f17682k;

        /* compiled from: delete_app_and_posts */
        public final class Builder {
            @Nullable
            public GraphQLObjectType f17667a;
            @Nullable
            public String f17668b;
            @Nullable
            public DefaultVect2FieldsModel f17669c;
            @Nullable
            public String f17670d;
            @Nullable
            public DefaultImageFieldsModel f17671e;
            @Nullable
            public DefaultImageFieldsModel f17672f;
            @Nullable
            public DefaultImageFieldsModel f17673g;
            @Nullable
            public DefaultImageFieldsModel f17674h;

            public final IntroCardPhotoFieldsModel m25747a() {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                int a = ModelHelper.a(flatBufferBuilder, this.f17667a);
                int b = flatBufferBuilder.b(this.f17668b);
                int a2 = ModelHelper.a(flatBufferBuilder, this.f17669c);
                int b2 = flatBufferBuilder.b(this.f17670d);
                int a3 = ModelHelper.a(flatBufferBuilder, this.f17671e);
                int a4 = ModelHelper.a(flatBufferBuilder, this.f17672f);
                int a5 = ModelHelper.a(flatBufferBuilder, this.f17673g);
                int a6 = ModelHelper.a(flatBufferBuilder, this.f17674h);
                flatBufferBuilder.c(8);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.b(1, b);
                flatBufferBuilder.b(2, a2);
                flatBufferBuilder.b(3, b2);
                flatBufferBuilder.b(4, a3);
                flatBufferBuilder.b(5, a4);
                flatBufferBuilder.b(6, a5);
                flatBufferBuilder.b(7, a6);
                flatBufferBuilder.d(flatBufferBuilder.d());
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                return new IntroCardPhotoFieldsModel(new MutableFlatBuffer(wrap, null, null, true, null));
            }
        }

        /* compiled from: delete_app_and_posts */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(IntroCardPhotoFieldsModel.class, new Deserializer());
            }

            public Object m25748a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(IntroCardPhotoFieldsParser.m26063a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object introCardPhotoFieldsModel = new IntroCardPhotoFieldsModel();
                ((BaseModel) introCardPhotoFieldsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (introCardPhotoFieldsModel instanceof Postprocessable) {
                    return ((Postprocessable) introCardPhotoFieldsModel).a();
                }
                return introCardPhotoFieldsModel;
            }
        }

        /* compiled from: delete_app_and_posts */
        public class Serializer extends JsonSerializer<IntroCardPhotoFieldsModel> {
            public final void m25749a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                IntroCardPhotoFieldsModel introCardPhotoFieldsModel = (IntroCardPhotoFieldsModel) obj;
                if (introCardPhotoFieldsModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(introCardPhotoFieldsModel.m25756a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    introCardPhotoFieldsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                IntroCardPhotoFieldsParser.m26064a(introCardPhotoFieldsModel.w_(), introCardPhotoFieldsModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(IntroCardPhotoFieldsModel.class, new Serializer());
            }
        }

        @Nullable
        public final /* synthetic */ DefaultImageFields bc_() {
            return m25755o();
        }

        @Nullable
        public final /* synthetic */ DefaultImageFields bd_() {
            return m25754n();
        }

        @Nullable
        public final /* synthetic */ DefaultImageFields be_() {
            return m25752l();
        }

        @Nullable
        public final /* synthetic */ DefaultVect2Fields m25760c() {
            return m25751k();
        }

        @Nullable
        public final /* synthetic */ DefaultImageFields m25762g() {
            return m25753m();
        }

        public IntroCardPhotoFieldsModel() {
            super(8);
        }

        public IntroCardPhotoFieldsModel(MutableFlatBuffer mutableFlatBuffer) {
            super(8);
            a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
        }

        @Nullable
        public final GraphQLObjectType m25759b() {
            if (this.b != null && this.f17675d == null) {
                this.f17675d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
            }
            return this.f17675d;
        }

        @Nullable
        public final String m25763j() {
            this.f17676e = super.a(this.f17676e, 1);
            return this.f17676e;
        }

        @Nullable
        private DefaultVect2FieldsModel m25751k() {
            this.f17677f = (DefaultVect2FieldsModel) super.a(this.f17677f, 2, DefaultVect2FieldsModel.class);
            return this.f17677f;
        }

        @Nullable
        public final String m25761d() {
            this.f17678g = super.a(this.f17678g, 3);
            return this.f17678g;
        }

        @Nullable
        private DefaultImageFieldsModel m25752l() {
            this.f17679h = (DefaultImageFieldsModel) super.a(this.f17679h, 4, DefaultImageFieldsModel.class);
            return this.f17679h;
        }

        @Nullable
        private DefaultImageFieldsModel m25753m() {
            this.f17680i = (DefaultImageFieldsModel) super.a(this.f17680i, 5, DefaultImageFieldsModel.class);
            return this.f17680i;
        }

        @Nullable
        private DefaultImageFieldsModel m25754n() {
            this.f17681j = (DefaultImageFieldsModel) super.a(this.f17681j, 6, DefaultImageFieldsModel.class);
            return this.f17681j;
        }

        @Nullable
        private DefaultImageFieldsModel m25755o() {
            this.f17682k = (DefaultImageFieldsModel) super.a(this.f17682k, 7, DefaultImageFieldsModel.class);
            return this.f17682k;
        }

        public static IntroCardPhotoFieldsModel m25750a(IntroCardPhotoFieldsModel introCardPhotoFieldsModel) {
            if (introCardPhotoFieldsModel == null) {
                return null;
            }
            if (introCardPhotoFieldsModel instanceof IntroCardPhotoFieldsModel) {
                return introCardPhotoFieldsModel;
            }
            Builder builder = new Builder();
            builder.f17667a = introCardPhotoFieldsModel.m25759b();
            builder.f17668b = introCardPhotoFieldsModel.m25763j();
            builder.f17669c = DefaultVect2FieldsModel.a(introCardPhotoFieldsModel.m25760c());
            builder.f17670d = introCardPhotoFieldsModel.m25761d();
            builder.f17671e = DefaultImageFieldsModel.a(introCardPhotoFieldsModel.be_());
            builder.f17672f = DefaultImageFieldsModel.a(introCardPhotoFieldsModel.m25762g());
            builder.f17673g = DefaultImageFieldsModel.a(introCardPhotoFieldsModel.bd_());
            builder.f17674h = DefaultImageFieldsModel.a(introCardPhotoFieldsModel.bc_());
            return builder.m25747a();
        }

        @Nullable
        public final String m25758a() {
            return m25761d();
        }

        public final int jK_() {
            return 77090322;
        }

        public final GraphQLVisitableModel m25757a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            DefaultImageFieldsModel defaultImageFieldsModel;
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m25751k() != null) {
                DefaultVect2FieldsModel defaultVect2FieldsModel = (DefaultVect2FieldsModel) graphQLModelMutatingVisitor.b(m25751k());
                if (m25751k() != defaultVect2FieldsModel) {
                    graphQLVisitableModel = (IntroCardPhotoFieldsModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f17677f = defaultVect2FieldsModel;
                }
            }
            if (m25752l() != null) {
                defaultImageFieldsModel = (DefaultImageFieldsModel) graphQLModelMutatingVisitor.b(m25752l());
                if (m25752l() != defaultImageFieldsModel) {
                    graphQLVisitableModel = (IntroCardPhotoFieldsModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f17679h = defaultImageFieldsModel;
                }
            }
            if (m25753m() != null) {
                defaultImageFieldsModel = (DefaultImageFieldsModel) graphQLModelMutatingVisitor.b(m25753m());
                if (m25753m() != defaultImageFieldsModel) {
                    graphQLVisitableModel = (IntroCardPhotoFieldsModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f17680i = defaultImageFieldsModel;
                }
            }
            if (m25754n() != null) {
                defaultImageFieldsModel = (DefaultImageFieldsModel) graphQLModelMutatingVisitor.b(m25754n());
                if (m25754n() != defaultImageFieldsModel) {
                    graphQLVisitableModel = (IntroCardPhotoFieldsModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f17681j = defaultImageFieldsModel;
                }
            }
            if (m25755o() != null) {
                defaultImageFieldsModel = (DefaultImageFieldsModel) graphQLModelMutatingVisitor.b(m25755o());
                if (m25755o() != defaultImageFieldsModel) {
                    graphQLVisitableModel = (IntroCardPhotoFieldsModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f17682k = defaultImageFieldsModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m25756a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m25759b());
            int b = flatBufferBuilder.b(m25763j());
            int a2 = ModelHelper.a(flatBufferBuilder, m25751k());
            int b2 = flatBufferBuilder.b(m25761d());
            int a3 = ModelHelper.a(flatBufferBuilder, m25752l());
            int a4 = ModelHelper.a(flatBufferBuilder, m25753m());
            int a5 = ModelHelper.a(flatBufferBuilder, m25754n());
            int a6 = ModelHelper.a(flatBufferBuilder, m25755o());
            flatBufferBuilder.c(8);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, b);
            flatBufferBuilder.b(2, a2);
            flatBufferBuilder.b(3, b2);
            flatBufferBuilder.b(4, a3);
            flatBufferBuilder.b(5, a4);
            flatBufferBuilder.b(6, a5);
            flatBufferBuilder.b(7, a6);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -581292106)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: delete_app_and_posts */
    public final class SuggestedPhotoModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private IntroCardPhotoFieldsModel f17683d;

        /* compiled from: delete_app_and_posts */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(SuggestedPhotoModel.class, new Deserializer());
            }

            public Object m25764a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(SuggestedPhotoParser.m26065b(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object suggestedPhotoModel = new SuggestedPhotoModel();
                ((BaseModel) suggestedPhotoModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (suggestedPhotoModel instanceof Postprocessable) {
                    return ((Postprocessable) suggestedPhotoModel).a();
                }
                return suggestedPhotoModel;
            }
        }

        /* compiled from: delete_app_and_posts */
        public class Serializer extends JsonSerializer<SuggestedPhotoModel> {
            public final void m25765a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                SuggestedPhotoModel suggestedPhotoModel = (SuggestedPhotoModel) obj;
                if (suggestedPhotoModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(suggestedPhotoModel.m25767a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    suggestedPhotoModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                SuggestedPhotoParser.m26066b(suggestedPhotoModel.w_(), suggestedPhotoModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(SuggestedPhotoModel.class, new Serializer());
            }
        }

        @Nullable
        public final /* synthetic */ IntroCardPhotoFieldsModel m25769a() {
            return m25766j();
        }

        public SuggestedPhotoModel() {
            super(1);
        }

        @Nullable
        private IntroCardPhotoFieldsModel m25766j() {
            this.f17683d = (IntroCardPhotoFieldsModel) super.a(this.f17683d, 0, IntroCardPhotoFieldsModel.class);
            return this.f17683d;
        }

        public final int jK_() {
            return -915341398;
        }

        public final GraphQLVisitableModel m25768a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m25766j() != null) {
                IntroCardPhotoFieldsModel introCardPhotoFieldsModel = (IntroCardPhotoFieldsModel) graphQLModelMutatingVisitor.b(m25766j());
                if (m25766j() != introCardPhotoFieldsModel) {
                    graphQLVisitableModel = (SuggestedPhotoModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f17683d = introCardPhotoFieldsModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m25767a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m25766j());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 1947362733)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: delete_app_and_posts */
    public final class TimelineContextItemsPageInfoModel extends BaseModel implements GraphQLVisitableModel {
        private boolean f17685d;

        /* compiled from: delete_app_and_posts */
        public final class Builder {
            public boolean f17684a;
        }

        /* compiled from: delete_app_and_posts */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(TimelineContextItemsPageInfoModel.class, new Deserializer());
            }

            public Object m25770a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(TimelineContextItemsPageInfoParser.m26067a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object timelineContextItemsPageInfoModel = new TimelineContextItemsPageInfoModel();
                ((BaseModel) timelineContextItemsPageInfoModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (timelineContextItemsPageInfoModel instanceof Postprocessable) {
                    return ((Postprocessable) timelineContextItemsPageInfoModel).a();
                }
                return timelineContextItemsPageInfoModel;
            }
        }

        /* compiled from: delete_app_and_posts */
        public class Serializer extends JsonSerializer<TimelineContextItemsPageInfoModel> {
            public final void m25771a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                TimelineContextItemsPageInfoModel timelineContextItemsPageInfoModel = (TimelineContextItemsPageInfoModel) obj;
                if (timelineContextItemsPageInfoModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(timelineContextItemsPageInfoModel.m25772a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    timelineContextItemsPageInfoModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                TimelineContextItemsPageInfoParser.m26068a(timelineContextItemsPageInfoModel.w_(), timelineContextItemsPageInfoModel.u_(), jsonGenerator);
            }

            static {
                FbSerializerProvider.a(TimelineContextItemsPageInfoModel.class, new Serializer());
            }
        }

        public TimelineContextItemsPageInfoModel() {
            super(1);
        }

        public TimelineContextItemsPageInfoModel(MutableFlatBuffer mutableFlatBuffer) {
            super(1);
            a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
        }

        public final boolean m25775a() {
            a(0, 0);
            return this.f17685d;
        }

        public final int jK_() {
            return 923779069;
        }

        public final GraphQLVisitableModel m25773a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            h();
            i();
            return this;
        }

        public final int m25772a(FlatBufferBuilder flatBufferBuilder) {
            h();
            flatBufferBuilder.c(1);
            flatBufferBuilder.a(0, this.f17685d);
            i();
            return flatBufferBuilder.d();
        }

        public final void m25774a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
            super.a(mutableFlatBuffer, i, obj);
            this.f17685d = mutableFlatBuffer.a(i, 0);
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 848194982)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: delete_app_and_posts */
    public final class TimelineContextListItemFieldsModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private BadgeCountModel f17692d;
        @Nullable
        private DefaultImageFieldsModel f17693e;
        @Nullable
        private NodeModel f17694f;
        @Nullable
        private GraphQLTimelineContextListTargetType f17695g;
        @Nullable
        private GraphQLTimelineContextListItemType f17696h;
        @Nullable
        private TitleModel f17697i;
        @Nullable
        private String f17698j;

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1723990064)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: delete_app_and_posts */
        public final class BadgeCountModel extends BaseModel implements GraphQLVisitableModel {
            private int f17686d;

            /* compiled from: delete_app_and_posts */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(BadgeCountModel.class, new Deserializer());
                }

                public Object m25776a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(BadgeCountParser.m26069a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object badgeCountModel = new BadgeCountModel();
                    ((BaseModel) badgeCountModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (badgeCountModel instanceof Postprocessable) {
                        return ((Postprocessable) badgeCountModel).a();
                    }
                    return badgeCountModel;
                }
            }

            /* compiled from: delete_app_and_posts */
            public class Serializer extends JsonSerializer<BadgeCountModel> {
                public final void m25777a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    BadgeCountModel badgeCountModel = (BadgeCountModel) obj;
                    if (badgeCountModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(badgeCountModel.m25779a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        badgeCountModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    BadgeCountParser.m26070a(badgeCountModel.w_(), badgeCountModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(BadgeCountModel.class, new Serializer());
                }
            }

            public BadgeCountModel() {
                super(1);
            }

            public final int m25778a() {
                a(0, 0);
                return this.f17686d;
            }

            public final int jK_() {
                return 382256763;
            }

            public final GraphQLVisitableModel m25780a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m25779a(FlatBufferBuilder flatBufferBuilder) {
                h();
                flatBufferBuilder.c(1);
                flatBufferBuilder.a(0, this.f17686d, 0);
                i();
                return flatBufferBuilder.d();
            }

            public final void m25781a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                super.a(mutableFlatBuffer, i, obj);
                this.f17686d = mutableFlatBuffer.a(i, 0, 0);
            }
        }

        /* compiled from: delete_app_and_posts */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(TimelineContextListItemFieldsModel.class, new Deserializer());
            }

            public Object m25782a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(TimelineContextListItemFieldsParser.m26077b(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object timelineContextListItemFieldsModel = new TimelineContextListItemFieldsModel();
                ((BaseModel) timelineContextListItemFieldsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (timelineContextListItemFieldsModel instanceof Postprocessable) {
                    return ((Postprocessable) timelineContextListItemFieldsModel).a();
                }
                return timelineContextListItemFieldsModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -787792242)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: delete_app_and_posts */
        public final class NodeModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel, TimelineContextListItemPhotoNodeFields {
            @Nullable
            private GraphQLObjectType f17687d;
            @Nullable
            private AlbumModel f17688e;
            @Nullable
            private String f17689f;
            @Nullable
            private DefaultImageFieldsModel f17690g;

            /* compiled from: delete_app_and_posts */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(NodeModel.class, new Deserializer());
                }

                public Object m25783a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(NodeParser.m26071a(jsonParser, flatBufferBuilder));
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

            /* compiled from: delete_app_and_posts */
            public class Serializer extends JsonSerializer<NodeModel> {
                public final void m25784a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    NodeModel nodeModel = (NodeModel) obj;
                    if (nodeModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(nodeModel.m25787a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        nodeModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    NodeParser.m26072a(nodeModel.w_(), nodeModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(NodeModel.class, new Serializer());
                }
            }

            @Nullable
            public final /* synthetic */ AlbumModel m25793c() {
                return m25785j();
            }

            @Nullable
            public final /* synthetic */ DefaultImageFields dt_() {
                return m25786k();
            }

            public NodeModel() {
                super(4);
            }

            public final void m25790a(String str, ConsistencyTuple consistencyTuple) {
                consistencyTuple.a();
            }

            public final void m25791a(String str, Object obj, boolean z) {
            }

            @Nullable
            public final GraphQLObjectType m25792b() {
                if (this.b != null && this.f17687d == null) {
                    this.f17687d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
                }
                return this.f17687d;
            }

            @Nullable
            private AlbumModel m25785j() {
                this.f17688e = (AlbumModel) super.a(this.f17688e, 1, AlbumModel.class);
                return this.f17688e;
            }

            @Nullable
            public final String m25794d() {
                this.f17689f = super.a(this.f17689f, 2);
                return this.f17689f;
            }

            @Nullable
            private DefaultImageFieldsModel m25786k() {
                this.f17690g = (DefaultImageFieldsModel) super.a(this.f17690g, 3, DefaultImageFieldsModel.class);
                return this.f17690g;
            }

            @Nullable
            public final String m25789a() {
                return m25794d();
            }

            public final int jK_() {
                return 2433570;
            }

            public final GraphQLVisitableModel m25788a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m25785j() != null) {
                    AlbumModel albumModel = (AlbumModel) graphQLModelMutatingVisitor.b(m25785j());
                    if (m25785j() != albumModel) {
                        graphQLVisitableModel = (NodeModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f17688e = albumModel;
                    }
                }
                if (m25786k() != null) {
                    DefaultImageFieldsModel defaultImageFieldsModel = (DefaultImageFieldsModel) graphQLModelMutatingVisitor.b(m25786k());
                    if (m25786k() != defaultImageFieldsModel) {
                        graphQLVisitableModel = (NodeModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f17690g = defaultImageFieldsModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m25787a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m25792b());
                int a2 = ModelHelper.a(flatBufferBuilder, m25785j());
                int b = flatBufferBuilder.b(m25794d());
                int a3 = ModelHelper.a(flatBufferBuilder, m25786k());
                flatBufferBuilder.c(4);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.b(1, a2);
                flatBufferBuilder.b(2, b);
                flatBufferBuilder.b(3, a3);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: delete_app_and_posts */
        public class Serializer extends JsonSerializer<TimelineContextListItemFieldsModel> {
            public final void m25795a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                TimelineContextListItemFieldsModel timelineContextListItemFieldsModel = (TimelineContextListItemFieldsModel) obj;
                if (timelineContextListItemFieldsModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(timelineContextListItemFieldsModel.m25805a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    timelineContextListItemFieldsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                TimelineContextListItemFieldsParser.m26078b(timelineContextListItemFieldsModel.w_(), timelineContextListItemFieldsModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(TimelineContextListItemFieldsModel.class, new Serializer());
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1352864475)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: delete_app_and_posts */
        public final class TitleModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private String f17691d;

            /* compiled from: delete_app_and_posts */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(TitleModel.class, new Deserializer());
                }

                public Object m25796a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(TitleParser.m26073a(jsonParser, flatBufferBuilder));
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

            /* compiled from: delete_app_and_posts */
            public class Serializer extends JsonSerializer<TitleModel> {
                public final void m25797a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    TitleModel titleModel = (TitleModel) obj;
                    if (titleModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(titleModel.m25798a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        titleModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    TitleParser.m26074a(titleModel.w_(), titleModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(TitleModel.class, new Serializer());
                }
            }

            public TitleModel() {
                super(1);
            }

            @Nullable
            public final String m25800a() {
                this.f17691d = super.a(this.f17691d, 0);
                return this.f17691d;
            }

            public final int jK_() {
                return -1919764332;
            }

            public final GraphQLVisitableModel m25799a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m25798a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m25800a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, b);
                i();
                return flatBufferBuilder.d();
            }
        }

        @Nullable
        public final /* synthetic */ BadgeCountModel m25807a() {
            return m25801j();
        }

        @Nullable
        public final /* synthetic */ DefaultImageFields m25808b() {
            return m25802k();
        }

        @Nullable
        public final /* synthetic */ NodeModel m25809c() {
            return m25803l();
        }

        @Nullable
        public final /* synthetic */ TitleModel m25811g() {
            return m25804m();
        }

        public TimelineContextListItemFieldsModel() {
            super(7);
        }

        @Nullable
        private BadgeCountModel m25801j() {
            this.f17692d = (BadgeCountModel) super.a(this.f17692d, 0, BadgeCountModel.class);
            return this.f17692d;
        }

        @Nullable
        private DefaultImageFieldsModel m25802k() {
            this.f17693e = (DefaultImageFieldsModel) super.a(this.f17693e, 1, DefaultImageFieldsModel.class);
            return this.f17693e;
        }

        @Nullable
        private NodeModel m25803l() {
            this.f17694f = (NodeModel) super.a(this.f17694f, 2, NodeModel.class);
            return this.f17694f;
        }

        @Nullable
        public final GraphQLTimelineContextListTargetType m25810d() {
            this.f17695g = (GraphQLTimelineContextListTargetType) super.b(this.f17695g, 3, GraphQLTimelineContextListTargetType.class, GraphQLTimelineContextListTargetType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
            return this.f17695g;
        }

        @Nullable
        public final GraphQLTimelineContextListItemType dr_() {
            this.f17696h = (GraphQLTimelineContextListItemType) super.b(this.f17696h, 4, GraphQLTimelineContextListItemType.class, GraphQLTimelineContextListItemType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
            return this.f17696h;
        }

        @Nullable
        private TitleModel m25804m() {
            this.f17697i = (TitleModel) super.a(this.f17697i, 5, TitleModel.class);
            return this.f17697i;
        }

        @Nullable
        public final String ds_() {
            this.f17698j = super.a(this.f17698j, 6);
            return this.f17698j;
        }

        public final int jK_() {
            return -2140001025;
        }

        public final GraphQLVisitableModel m25806a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m25801j() != null) {
                BadgeCountModel badgeCountModel = (BadgeCountModel) graphQLModelMutatingVisitor.b(m25801j());
                if (m25801j() != badgeCountModel) {
                    graphQLVisitableModel = (TimelineContextListItemFieldsModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f17692d = badgeCountModel;
                }
            }
            if (m25802k() != null) {
                DefaultImageFieldsModel defaultImageFieldsModel = (DefaultImageFieldsModel) graphQLModelMutatingVisitor.b(m25802k());
                if (m25802k() != defaultImageFieldsModel) {
                    graphQLVisitableModel = (TimelineContextListItemFieldsModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f17693e = defaultImageFieldsModel;
                }
            }
            if (m25803l() != null) {
                NodeModel nodeModel = (NodeModel) graphQLModelMutatingVisitor.b(m25803l());
                if (m25803l() != nodeModel) {
                    graphQLVisitableModel = (TimelineContextListItemFieldsModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f17694f = nodeModel;
                }
            }
            if (m25804m() != null) {
                TitleModel titleModel = (TitleModel) graphQLModelMutatingVisitor.b(m25804m());
                if (m25804m() != titleModel) {
                    graphQLVisitableModel = (TimelineContextListItemFieldsModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f17697i = titleModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m25805a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m25801j());
            int a2 = ModelHelper.a(flatBufferBuilder, m25802k());
            int a3 = ModelHelper.a(flatBufferBuilder, m25803l());
            int a4 = flatBufferBuilder.a(m25810d());
            int a5 = flatBufferBuilder.a(dr_());
            int a6 = ModelHelper.a(flatBufferBuilder, m25804m());
            int b = flatBufferBuilder.b(ds_());
            flatBufferBuilder.c(7);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, a2);
            flatBufferBuilder.b(2, a3);
            flatBufferBuilder.b(3, a4);
            flatBufferBuilder.b(4, a5);
            flatBufferBuilder.b(5, a6);
            flatBufferBuilder.b(6, b);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -1617441070)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: delete_app_and_posts */
    public final class TimelineContextListItemPhotoNodeFieldsModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel, TimelineContextListItemPhotoNodeFields {
        @Nullable
        private AlbumModel f17700d;
        @Nullable
        private String f17701e;
        @Nullable
        private DefaultImageFieldsModel f17702f;

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 1801334754)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: delete_app_and_posts */
        public final class AlbumModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel {
            @Nullable
            private String f17699d;

            /* compiled from: delete_app_and_posts */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(AlbumModel.class, new Deserializer());
                }

                public Object m25812a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(AlbumParser.m26079a(jsonParser, flatBufferBuilder));
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

            /* compiled from: delete_app_and_posts */
            public class Serializer extends JsonSerializer<AlbumModel> {
                public final void m25813a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    AlbumModel albumModel = (AlbumModel) obj;
                    if (albumModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(albumModel.m25814a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        albumModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    AlbumParser.m26080a(albumModel.w_(), albumModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(AlbumModel.class, new Serializer());
                }
            }

            public AlbumModel() {
                super(1);
            }

            @Nullable
            public final String m25817b() {
                this.f17699d = super.a(this.f17699d, 0);
                return this.f17699d;
            }

            @Nullable
            public final String m25816a() {
                return m25817b();
            }

            public final int jK_() {
                return 63344207;
            }

            public final GraphQLVisitableModel m25815a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m25814a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m25817b());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, b);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: delete_app_and_posts */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(TimelineContextListItemPhotoNodeFieldsModel.class, new Deserializer());
            }

            public Object m25818a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = TimelineContextListItemPhotoNodeFieldsParser.m26081a(jsonParser);
                Object timelineContextListItemPhotoNodeFieldsModel = new TimelineContextListItemPhotoNodeFieldsModel();
                ((BaseModel) timelineContextListItemPhotoNodeFieldsModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (timelineContextListItemPhotoNodeFieldsModel instanceof Postprocessable) {
                    return ((Postprocessable) timelineContextListItemPhotoNodeFieldsModel).a();
                }
                return timelineContextListItemPhotoNodeFieldsModel;
            }
        }

        /* compiled from: delete_app_and_posts */
        public class Serializer extends JsonSerializer<TimelineContextListItemPhotoNodeFieldsModel> {
            public final void m25819a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                TimelineContextListItemPhotoNodeFieldsModel timelineContextListItemPhotoNodeFieldsModel = (TimelineContextListItemPhotoNodeFieldsModel) obj;
                if (timelineContextListItemPhotoNodeFieldsModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(timelineContextListItemPhotoNodeFieldsModel.m25823a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    timelineContextListItemPhotoNodeFieldsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = timelineContextListItemPhotoNodeFieldsModel.w_();
                int u_ = timelineContextListItemPhotoNodeFieldsModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("album");
                    AlbumParser.m26080a(mutableFlatBuffer, g, jsonGenerator);
                }
                if (mutableFlatBuffer.g(u_, 1) != 0) {
                    jsonGenerator.a("id");
                    jsonGenerator.b(mutableFlatBuffer.c(u_, 1));
                }
                g = mutableFlatBuffer.g(u_, 2);
                if (g != 0) {
                    jsonGenerator.a("image");
                    DefaultImageFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(TimelineContextListItemPhotoNodeFieldsModel.class, new Serializer());
            }
        }

        public TimelineContextListItemPhotoNodeFieldsModel() {
            super(3);
        }

        @Nullable
        private AlbumModel m25820j() {
            this.f17700d = (AlbumModel) super.a(this.f17700d, 0, AlbumModel.class);
            return this.f17700d;
        }

        @Nullable
        private String m25821k() {
            this.f17701e = super.a(this.f17701e, 1);
            return this.f17701e;
        }

        @Nullable
        private DefaultImageFieldsModel m25822l() {
            this.f17702f = (DefaultImageFieldsModel) super.a(this.f17702f, 2, DefaultImageFieldsModel.class);
            return this.f17702f;
        }

        @Nullable
        public final String m25825a() {
            return m25821k();
        }

        public final int jK_() {
            return 77090322;
        }

        public final GraphQLVisitableModel m25824a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m25820j() != null) {
                AlbumModel albumModel = (AlbumModel) graphQLModelMutatingVisitor.b(m25820j());
                if (m25820j() != albumModel) {
                    graphQLVisitableModel = (TimelineContextListItemPhotoNodeFieldsModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f17700d = albumModel;
                }
            }
            if (m25822l() != null) {
                DefaultImageFieldsModel defaultImageFieldsModel = (DefaultImageFieldsModel) graphQLModelMutatingVisitor.b(m25822l());
                if (m25822l() != defaultImageFieldsModel) {
                    graphQLVisitableModel = (TimelineContextListItemPhotoNodeFieldsModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f17702f = defaultImageFieldsModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m25823a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m25820j());
            int b = flatBufferBuilder.b(m25821k());
            int a2 = ModelHelper.a(flatBufferBuilder, m25822l());
            flatBufferBuilder.c(3);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, b);
            flatBufferBuilder.b(2, a2);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -1995117166)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: delete_app_and_posts */
    public final class TimelineContextListItemsConnectionFieldsModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private List<TimelineContextListItemFieldsModel> f17703d;
        @Nullable
        private TimelineContextItemsPageInfoModel f17704e;

        /* compiled from: delete_app_and_posts */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(TimelineContextListItemsConnectionFieldsModel.class, new Deserializer());
            }

            public Object m25826a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(TimelineContextListItemsConnectionFieldsParser.m26082a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object timelineContextListItemsConnectionFieldsModel = new TimelineContextListItemsConnectionFieldsModel();
                ((BaseModel) timelineContextListItemsConnectionFieldsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (timelineContextListItemsConnectionFieldsModel instanceof Postprocessable) {
                    return ((Postprocessable) timelineContextListItemsConnectionFieldsModel).a();
                }
                return timelineContextListItemsConnectionFieldsModel;
            }
        }

        /* compiled from: delete_app_and_posts */
        public class Serializer extends JsonSerializer<TimelineContextListItemsConnectionFieldsModel> {
            public final void m25827a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                TimelineContextListItemsConnectionFieldsModel timelineContextListItemsConnectionFieldsModel = (TimelineContextListItemsConnectionFieldsModel) obj;
                if (timelineContextListItemsConnectionFieldsModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(timelineContextListItemsConnectionFieldsModel.m25829a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    timelineContextListItemsConnectionFieldsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                TimelineContextListItemsConnectionFieldsParser.m26083a(timelineContextListItemsConnectionFieldsModel.w_(), timelineContextListItemsConnectionFieldsModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(TimelineContextListItemsConnectionFieldsModel.class, new Serializer());
            }
        }

        @Nullable
        public final /* synthetic */ TimelineContextItemsPageInfoModel m25832b() {
            return m25828j();
        }

        public TimelineContextListItemsConnectionFieldsModel() {
            super(2);
        }

        @Nonnull
        public final ImmutableList<TimelineContextListItemFieldsModel> m25831a() {
            this.f17703d = super.a(this.f17703d, 0, TimelineContextListItemFieldsModel.class);
            return (ImmutableList) this.f17703d;
        }

        @Nullable
        private TimelineContextItemsPageInfoModel m25828j() {
            this.f17704e = (TimelineContextItemsPageInfoModel) super.a(this.f17704e, 1, TimelineContextItemsPageInfoModel.class);
            return this.f17704e;
        }

        public final int jK_() {
            return -2113882798;
        }

        public final GraphQLVisitableModel m25830a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel;
            TimelineContextItemsPageInfoModel timelineContextItemsPageInfoModel;
            h();
            if (m25831a() != null) {
                Builder a = ModelHelper.a(m25831a(), graphQLModelMutatingVisitor);
                if (a != null) {
                    TimelineContextListItemsConnectionFieldsModel timelineContextListItemsConnectionFieldsModel = (TimelineContextListItemsConnectionFieldsModel) ModelHelper.a(null, this);
                    timelineContextListItemsConnectionFieldsModel.f17703d = a.b();
                    graphQLVisitableModel = timelineContextListItemsConnectionFieldsModel;
                    if (m25828j() != null) {
                        timelineContextItemsPageInfoModel = (TimelineContextItemsPageInfoModel) graphQLModelMutatingVisitor.b(m25828j());
                        if (m25828j() != timelineContextItemsPageInfoModel) {
                            graphQLVisitableModel = (TimelineContextListItemsConnectionFieldsModel) ModelHelper.a(graphQLVisitableModel, this);
                            graphQLVisitableModel.f17704e = timelineContextItemsPageInfoModel;
                        }
                    }
                    i();
                    return graphQLVisitableModel != null ? this : graphQLVisitableModel;
                }
            }
            graphQLVisitableModel = null;
            if (m25828j() != null) {
                timelineContextItemsPageInfoModel = (TimelineContextItemsPageInfoModel) graphQLModelMutatingVisitor.b(m25828j());
                if (m25828j() != timelineContextItemsPageInfoModel) {
                    graphQLVisitableModel = (TimelineContextListItemsConnectionFieldsModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f17704e = timelineContextItemsPageInfoModel;
                }
            }
            i();
            if (graphQLVisitableModel != null) {
            }
        }

        public final int m25829a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m25831a());
            int a2 = ModelHelper.a(flatBufferBuilder, m25828j());
            flatBufferBuilder.c(2);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, a2);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -534575516)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: delete_app_and_posts */
    public final class TimelineHeaderCoverPhotoFieldsModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel {
        @Nullable
        private String f17712d;
        @Nullable
        private AlbumModel f17713e;
        @Nullable
        private String f17714f;
        @Nullable
        private DefaultImageFieldsModel f17715g;
        @Nullable
        private String f17716h;

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 1801334754)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: delete_app_and_posts */
        public final class AlbumModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel {
            @Nullable
            private String f17706d;

            /* compiled from: delete_app_and_posts */
            public final class Builder {
                @Nullable
                public String f17705a;
            }

            /* compiled from: delete_app_and_posts */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(AlbumModel.class, new Deserializer());
                }

                public Object m25833a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(TimelineHeaderCoverPhotoFieldsParser.AlbumParser.m26084a(jsonParser, flatBufferBuilder));
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

            /* compiled from: delete_app_and_posts */
            public class Serializer extends JsonSerializer<AlbumModel> {
                public final void m25834a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    AlbumModel albumModel = (AlbumModel) obj;
                    if (albumModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(albumModel.m25836a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        albumModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    TimelineHeaderCoverPhotoFieldsParser.AlbumParser.m26085a(albumModel.w_(), albumModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(AlbumModel.class, new Serializer());
                }
            }

            public AlbumModel() {
                super(1);
            }

            public AlbumModel(MutableFlatBuffer mutableFlatBuffer) {
                super(1);
                a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
            }

            @Nullable
            public final String m25839b() {
                this.f17706d = super.a(this.f17706d, 0);
                return this.f17706d;
            }

            public static AlbumModel m25835a(AlbumModel albumModel) {
                if (albumModel == null) {
                    return null;
                }
                if (albumModel instanceof AlbumModel) {
                    return albumModel;
                }
                Builder builder = new Builder();
                builder.f17705a = albumModel.m25839b();
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                int b = flatBufferBuilder.b(builder.f17705a);
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, b);
                flatBufferBuilder.d(flatBufferBuilder.d());
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                return new AlbumModel(new MutableFlatBuffer(wrap, null, null, true, null));
            }

            @Nullable
            public final String m25838a() {
                return m25839b();
            }

            public final int jK_() {
                return 63344207;
            }

            public final GraphQLVisitableModel m25837a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m25836a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m25839b());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, b);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: delete_app_and_posts */
        public final class Builder {
            @Nullable
            public String f17707a;
            @Nullable
            public AlbumModel f17708b;
            @Nullable
            public String f17709c;
            @Nullable
            public DefaultImageFieldsModel f17710d;
            @Nullable
            public String f17711e;

            public final TimelineHeaderCoverPhotoFieldsModel m25840a() {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                int b = flatBufferBuilder.b(this.f17707a);
                int a = ModelHelper.a(flatBufferBuilder, this.f17708b);
                int b2 = flatBufferBuilder.b(this.f17709c);
                int a2 = ModelHelper.a(flatBufferBuilder, this.f17710d);
                int b3 = flatBufferBuilder.b(this.f17711e);
                flatBufferBuilder.c(5);
                flatBufferBuilder.b(0, b);
                flatBufferBuilder.b(1, a);
                flatBufferBuilder.b(2, b2);
                flatBufferBuilder.b(3, a2);
                flatBufferBuilder.b(4, b3);
                flatBufferBuilder.d(flatBufferBuilder.d());
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                return new TimelineHeaderCoverPhotoFieldsModel(new MutableFlatBuffer(wrap, null, null, true, null));
            }
        }

        /* compiled from: delete_app_and_posts */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(TimelineHeaderCoverPhotoFieldsModel.class, new Deserializer());
            }

            public Object m25841a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(TimelineHeaderCoverPhotoFieldsParser.m26086a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object timelineHeaderCoverPhotoFieldsModel = new TimelineHeaderCoverPhotoFieldsModel();
                ((BaseModel) timelineHeaderCoverPhotoFieldsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (timelineHeaderCoverPhotoFieldsModel instanceof Postprocessable) {
                    return ((Postprocessable) timelineHeaderCoverPhotoFieldsModel).a();
                }
                return timelineHeaderCoverPhotoFieldsModel;
            }
        }

        /* compiled from: delete_app_and_posts */
        public class Serializer extends JsonSerializer<TimelineHeaderCoverPhotoFieldsModel> {
            public final void m25842a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                TimelineHeaderCoverPhotoFieldsModel timelineHeaderCoverPhotoFieldsModel = (TimelineHeaderCoverPhotoFieldsModel) obj;
                if (timelineHeaderCoverPhotoFieldsModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(timelineHeaderCoverPhotoFieldsModel.m25846a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    timelineHeaderCoverPhotoFieldsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                TimelineHeaderCoverPhotoFieldsParser.m26087a(timelineHeaderCoverPhotoFieldsModel.w_(), timelineHeaderCoverPhotoFieldsModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(TimelineHeaderCoverPhotoFieldsModel.class, new Serializer());
            }
        }

        @Nullable
        public final /* synthetic */ AlbumModel m25850c() {
            return m25844j();
        }

        @Nullable
        public final /* synthetic */ DefaultImageFields du_() {
            return m25845k();
        }

        public TimelineHeaderCoverPhotoFieldsModel() {
            super(5);
        }

        public TimelineHeaderCoverPhotoFieldsModel(MutableFlatBuffer mutableFlatBuffer) {
            super(5);
            a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
        }

        @Nullable
        public final String m25849b() {
            this.f17712d = super.a(this.f17712d, 0);
            return this.f17712d;
        }

        @Nullable
        private AlbumModel m25844j() {
            this.f17713e = (AlbumModel) super.a(this.f17713e, 1, AlbumModel.class);
            return this.f17713e;
        }

        @Nullable
        public final String m25851d() {
            this.f17714f = super.a(this.f17714f, 2);
            return this.f17714f;
        }

        @Nullable
        private DefaultImageFieldsModel m25845k() {
            this.f17715g = (DefaultImageFieldsModel) super.a(this.f17715g, 3, DefaultImageFieldsModel.class);
            return this.f17715g;
        }

        @Nullable
        public final String m25852g() {
            this.f17716h = super.a(this.f17716h, 4);
            return this.f17716h;
        }

        public static TimelineHeaderCoverPhotoFieldsModel m25843a(TimelineHeaderCoverPhotoFieldsModel timelineHeaderCoverPhotoFieldsModel) {
            if (timelineHeaderCoverPhotoFieldsModel == null) {
                return null;
            }
            if (timelineHeaderCoverPhotoFieldsModel instanceof TimelineHeaderCoverPhotoFieldsModel) {
                return timelineHeaderCoverPhotoFieldsModel;
            }
            Builder builder = new Builder();
            builder.f17707a = timelineHeaderCoverPhotoFieldsModel.m25849b();
            builder.f17708b = AlbumModel.m25835a(timelineHeaderCoverPhotoFieldsModel.m25850c());
            builder.f17709c = timelineHeaderCoverPhotoFieldsModel.m25851d();
            builder.f17710d = DefaultImageFieldsModel.a(timelineHeaderCoverPhotoFieldsModel.du_());
            builder.f17711e = timelineHeaderCoverPhotoFieldsModel.m25852g();
            return builder.m25840a();
        }

        @Nullable
        public final String m25848a() {
            return m25851d();
        }

        public final int jK_() {
            return 77090322;
        }

        public final GraphQLVisitableModel m25847a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m25844j() != null) {
                AlbumModel albumModel = (AlbumModel) graphQLModelMutatingVisitor.b(m25844j());
                if (m25844j() != albumModel) {
                    graphQLVisitableModel = (TimelineHeaderCoverPhotoFieldsModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f17713e = albumModel;
                }
            }
            if (m25845k() != null) {
                DefaultImageFieldsModel defaultImageFieldsModel = (DefaultImageFieldsModel) graphQLModelMutatingVisitor.b(m25845k());
                if (m25845k() != defaultImageFieldsModel) {
                    graphQLVisitableModel = (TimelineHeaderCoverPhotoFieldsModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f17715g = defaultImageFieldsModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m25846a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(m25849b());
            int a = ModelHelper.a(flatBufferBuilder, m25844j());
            int b2 = flatBufferBuilder.b(m25851d());
            int a2 = ModelHelper.a(flatBufferBuilder, m25845k());
            int b3 = flatBufferBuilder.b(m25852g());
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

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -1593151788)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: delete_app_and_posts */
    public final class TimelineHeaderFocusedCoverPhotoFieldsModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private DefaultVect2FieldsModel f17719d;
        @Nullable
        private TimelineHeaderCoverPhotoFieldsModel f17720e;

        /* compiled from: delete_app_and_posts */
        public final class Builder {
            @Nullable
            public DefaultVect2FieldsModel f17717a;
            @Nullable
            public TimelineHeaderCoverPhotoFieldsModel f17718b;

            public final TimelineHeaderFocusedCoverPhotoFieldsModel m25853a() {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                int a = ModelHelper.a(flatBufferBuilder, this.f17717a);
                int a2 = ModelHelper.a(flatBufferBuilder, this.f17718b);
                flatBufferBuilder.c(2);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.b(1, a2);
                flatBufferBuilder.d(flatBufferBuilder.d());
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                return new TimelineHeaderFocusedCoverPhotoFieldsModel(new MutableFlatBuffer(wrap, null, null, true, null));
            }
        }

        /* compiled from: delete_app_and_posts */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(TimelineHeaderFocusedCoverPhotoFieldsModel.class, new Deserializer());
            }

            public Object m25854a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(TimelineHeaderFocusedCoverPhotoFieldsParser.m26088a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object timelineHeaderFocusedCoverPhotoFieldsModel = new TimelineHeaderFocusedCoverPhotoFieldsModel();
                ((BaseModel) timelineHeaderFocusedCoverPhotoFieldsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (timelineHeaderFocusedCoverPhotoFieldsModel instanceof Postprocessable) {
                    return ((Postprocessable) timelineHeaderFocusedCoverPhotoFieldsModel).a();
                }
                return timelineHeaderFocusedCoverPhotoFieldsModel;
            }
        }

        /* compiled from: delete_app_and_posts */
        public class Serializer extends JsonSerializer<TimelineHeaderFocusedCoverPhotoFieldsModel> {
            public final void m25855a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                TimelineHeaderFocusedCoverPhotoFieldsModel timelineHeaderFocusedCoverPhotoFieldsModel = (TimelineHeaderFocusedCoverPhotoFieldsModel) obj;
                if (timelineHeaderFocusedCoverPhotoFieldsModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(timelineHeaderFocusedCoverPhotoFieldsModel.m25859a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    timelineHeaderFocusedCoverPhotoFieldsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                TimelineHeaderFocusedCoverPhotoFieldsParser.m26089a(timelineHeaderFocusedCoverPhotoFieldsModel.w_(), timelineHeaderFocusedCoverPhotoFieldsModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(TimelineHeaderFocusedCoverPhotoFieldsModel.class, new Serializer());
            }
        }

        @Nullable
        public final /* synthetic */ DefaultVect2Fields m25860a() {
            return m25857j();
        }

        @Nullable
        public final /* synthetic */ TimelineHeaderCoverPhotoFieldsModel m25862b() {
            return m25858k();
        }

        public TimelineHeaderFocusedCoverPhotoFieldsModel() {
            super(2);
        }

        public TimelineHeaderFocusedCoverPhotoFieldsModel(MutableFlatBuffer mutableFlatBuffer) {
            super(2);
            a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
        }

        @Nullable
        private DefaultVect2FieldsModel m25857j() {
            this.f17719d = (DefaultVect2FieldsModel) super.a(this.f17719d, 0, DefaultVect2FieldsModel.class);
            return this.f17719d;
        }

        @Nullable
        private TimelineHeaderCoverPhotoFieldsModel m25858k() {
            this.f17720e = (TimelineHeaderCoverPhotoFieldsModel) super.a(this.f17720e, 1, TimelineHeaderCoverPhotoFieldsModel.class);
            return this.f17720e;
        }

        public static TimelineHeaderFocusedCoverPhotoFieldsModel m25856a(TimelineHeaderFocusedCoverPhotoFieldsModel timelineHeaderFocusedCoverPhotoFieldsModel) {
            if (timelineHeaderFocusedCoverPhotoFieldsModel == null) {
                return null;
            }
            if (timelineHeaderFocusedCoverPhotoFieldsModel instanceof TimelineHeaderFocusedCoverPhotoFieldsModel) {
                return timelineHeaderFocusedCoverPhotoFieldsModel;
            }
            Builder builder = new Builder();
            builder.f17717a = DefaultVect2FieldsModel.a(timelineHeaderFocusedCoverPhotoFieldsModel.m25860a());
            builder.f17718b = TimelineHeaderCoverPhotoFieldsModel.m25843a(timelineHeaderFocusedCoverPhotoFieldsModel.m25862b());
            return builder.m25853a();
        }

        public final int jK_() {
            return 497264923;
        }

        public final GraphQLVisitableModel m25861a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m25857j() != null) {
                DefaultVect2FieldsModel defaultVect2FieldsModel = (DefaultVect2FieldsModel) graphQLModelMutatingVisitor.b(m25857j());
                if (m25857j() != defaultVect2FieldsModel) {
                    graphQLVisitableModel = (TimelineHeaderFocusedCoverPhotoFieldsModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f17719d = defaultVect2FieldsModel;
                }
            }
            if (m25858k() != null) {
                TimelineHeaderCoverPhotoFieldsModel timelineHeaderCoverPhotoFieldsModel = (TimelineHeaderCoverPhotoFieldsModel) graphQLModelMutatingVisitor.b(m25858k());
                if (m25858k() != timelineHeaderCoverPhotoFieldsModel) {
                    graphQLVisitableModel = (TimelineHeaderFocusedCoverPhotoFieldsModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f17720e = timelineHeaderCoverPhotoFieldsModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m25859a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m25857j());
            int a2 = ModelHelper.a(flatBufferBuilder, m25858k());
            flatBufferBuilder.c(2);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, a2);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 1098857794)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: delete_app_and_posts */
    public final class TimelineHeaderProfileIntroCardFieldsModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private List<ActionLinksModel> f17728d;
        @Nullable
        private DefaultTextWithEntitiesFieldsModel f17729e;
        private boolean f17730f;
        private boolean f17731g;
        private boolean f17732h;
        @Nullable
        private IntroCardContextListItemsConnectionFieldsModel f17733i;
        @Nullable
        private List<ExternalLinkModel> f17734j;
        @Nullable
        private FavoritePhotosModel f17735k;
        private boolean f17736l;
        private boolean f17737m;
        @Nullable
        private DefaultTextWithEntitiesFieldsModel f17738n;
        @Nullable
        private SuggestedPhotosModel f17739o;

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 1046994586)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: delete_app_and_posts */
        public final class ActionLinksModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private GraphQLObjectType f17722d;
            @Nullable
            private DescriptionModel f17723e;
            @Nullable
            private String f17724f;
            @Nullable
            private String f17725g;

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = -1352864475)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: delete_app_and_posts */
            public final class DescriptionModel extends BaseModel implements GraphQLVisitableModel {
                @Nullable
                private String f17721d;

                /* compiled from: delete_app_and_posts */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(DescriptionModel.class, new Deserializer());
                    }

                    public Object m25863a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(DescriptionParser.m26090a(jsonParser, flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                        Object descriptionModel = new DescriptionModel();
                        ((BaseModel) descriptionModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                        if (descriptionModel instanceof Postprocessable) {
                            return ((Postprocessable) descriptionModel).a();
                        }
                        return descriptionModel;
                    }
                }

                /* compiled from: delete_app_and_posts */
                public class Serializer extends JsonSerializer<DescriptionModel> {
                    public final void m25864a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        DescriptionModel descriptionModel = (DescriptionModel) obj;
                        if (descriptionModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(descriptionModel.m25865a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            descriptionModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        DescriptionParser.m26091a(descriptionModel.w_(), descriptionModel.u_(), jsonGenerator);
                    }

                    static {
                        FbSerializerProvider.a(DescriptionModel.class, new Serializer());
                    }
                }

                public DescriptionModel() {
                    super(1);
                }

                @Nullable
                public final String m25867a() {
                    this.f17721d = super.a(this.f17721d, 0);
                    return this.f17721d;
                }

                public final int jK_() {
                    return -1919764332;
                }

                public final GraphQLVisitableModel m25866a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    h();
                    i();
                    return this;
                }

                public final int m25865a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int b = flatBufferBuilder.b(m25867a());
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.b(0, b);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            /* compiled from: delete_app_and_posts */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(ActionLinksModel.class, new Deserializer());
                }

                public Object m25868a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(ActionLinksParser.m26093b(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object actionLinksModel = new ActionLinksModel();
                    ((BaseModel) actionLinksModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (actionLinksModel instanceof Postprocessable) {
                        return ((Postprocessable) actionLinksModel).a();
                    }
                    return actionLinksModel;
                }
            }

            /* compiled from: delete_app_and_posts */
            public class Serializer extends JsonSerializer<ActionLinksModel> {
                public final void m25869a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    ActionLinksModel actionLinksModel = (ActionLinksModel) obj;
                    if (actionLinksModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(actionLinksModel.m25871a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        actionLinksModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    ActionLinksParser.m26094b(actionLinksModel.w_(), actionLinksModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(ActionLinksModel.class, new Serializer());
                }
            }

            @Nullable
            public final /* synthetic */ DescriptionModel m25874b() {
                return m25870j();
            }

            public ActionLinksModel() {
                super(4);
            }

            @Nullable
            public final GraphQLObjectType m25872a() {
                if (this.b != null && this.f17722d == null) {
                    this.f17722d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
                }
                return this.f17722d;
            }

            @Nullable
            private DescriptionModel m25870j() {
                this.f17723e = (DescriptionModel) super.a(this.f17723e, 1, DescriptionModel.class);
                return this.f17723e;
            }

            @Nullable
            public final String m25875c() {
                this.f17724f = super.a(this.f17724f, 2);
                return this.f17724f;
            }

            @Nullable
            public final String m25876d() {
                this.f17725g = super.a(this.f17725g, 3);
                return this.f17725g;
            }

            public final int jK_() {
                return -1747569147;
            }

            public final GraphQLVisitableModel m25873a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m25870j() != null) {
                    DescriptionModel descriptionModel = (DescriptionModel) graphQLModelMutatingVisitor.b(m25870j());
                    if (m25870j() != descriptionModel) {
                        graphQLVisitableModel = (ActionLinksModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f17723e = descriptionModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m25871a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m25872a());
                int a2 = ModelHelper.a(flatBufferBuilder, m25870j());
                int b = flatBufferBuilder.b(m25875c());
                int b2 = flatBufferBuilder.b(m25876d());
                flatBufferBuilder.c(4);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.b(1, a2);
                flatBufferBuilder.b(2, b);
                flatBufferBuilder.b(3, b2);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: delete_app_and_posts */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(TimelineHeaderProfileIntroCardFieldsModel.class, new Deserializer());
            }

            public Object m25877a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(TimelineHeaderProfileIntroCardFieldsParser.m26099a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object timelineHeaderProfileIntroCardFieldsModel = new TimelineHeaderProfileIntroCardFieldsModel();
                ((BaseModel) timelineHeaderProfileIntroCardFieldsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (timelineHeaderProfileIntroCardFieldsModel instanceof Postprocessable) {
                    return ((Postprocessable) timelineHeaderProfileIntroCardFieldsModel).a();
                }
                return timelineHeaderProfileIntroCardFieldsModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 813627492)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: delete_app_and_posts */
        public final class FavoritePhotosModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private List<FavoritePhotoModel> f17726d;

            /* compiled from: delete_app_and_posts */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(FavoritePhotosModel.class, new Deserializer());
                }

                public Object m25878a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(FavoritePhotosParser.m26095a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object favoritePhotosModel = new FavoritePhotosModel();
                    ((BaseModel) favoritePhotosModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (favoritePhotosModel instanceof Postprocessable) {
                        return ((Postprocessable) favoritePhotosModel).a();
                    }
                    return favoritePhotosModel;
                }
            }

            /* compiled from: delete_app_and_posts */
            public class Serializer extends JsonSerializer<FavoritePhotosModel> {
                public final void m25879a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    FavoritePhotosModel favoritePhotosModel = (FavoritePhotosModel) obj;
                    if (favoritePhotosModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(favoritePhotosModel.m25880a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        favoritePhotosModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    FavoritePhotosParser.m26096a(favoritePhotosModel.w_(), favoritePhotosModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(FavoritePhotosModel.class, new Serializer());
                }
            }

            public FavoritePhotosModel() {
                super(1);
            }

            @Nonnull
            public final ImmutableList<FavoritePhotoModel> m25882a() {
                this.f17726d = super.a(this.f17726d, 0, FavoritePhotoModel.class);
                return (ImmutableList) this.f17726d;
            }

            public final int jK_() {
                return 520734144;
            }

            public final GraphQLVisitableModel m25881a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m25882a() != null) {
                    Builder a = ModelHelper.a(m25882a(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        graphQLVisitableModel = (FavoritePhotosModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f17726d = a.b();
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m25880a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m25882a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, a);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: delete_app_and_posts */
        public class Serializer extends JsonSerializer<TimelineHeaderProfileIntroCardFieldsModel> {
            public final void m25883a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                TimelineHeaderProfileIntroCardFieldsModel timelineHeaderProfileIntroCardFieldsModel = (TimelineHeaderProfileIntroCardFieldsModel) obj;
                if (timelineHeaderProfileIntroCardFieldsModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(timelineHeaderProfileIntroCardFieldsModel.m25894a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    timelineHeaderProfileIntroCardFieldsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                TimelineHeaderProfileIntroCardFieldsParser.m26100a(timelineHeaderProfileIntroCardFieldsModel.w_(), timelineHeaderProfileIntroCardFieldsModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(TimelineHeaderProfileIntroCardFieldsModel.class, new Serializer());
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -909057885)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: delete_app_and_posts */
        public final class SuggestedPhotosModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private List<SuggestedPhotoModel> f17727d;

            /* compiled from: delete_app_and_posts */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(SuggestedPhotosModel.class, new Deserializer());
                }

                public Object m25884a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(SuggestedPhotosParser.m26097a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object suggestedPhotosModel = new SuggestedPhotosModel();
                    ((BaseModel) suggestedPhotosModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (suggestedPhotosModel instanceof Postprocessable) {
                        return ((Postprocessable) suggestedPhotosModel).a();
                    }
                    return suggestedPhotosModel;
                }
            }

            /* compiled from: delete_app_and_posts */
            public class Serializer extends JsonSerializer<SuggestedPhotosModel> {
                public final void m25885a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    SuggestedPhotosModel suggestedPhotosModel = (SuggestedPhotosModel) obj;
                    if (suggestedPhotosModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(suggestedPhotosModel.m25886a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        suggestedPhotosModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    SuggestedPhotosParser.m26098a(suggestedPhotosModel.w_(), suggestedPhotosModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(SuggestedPhotosModel.class, new Serializer());
                }
            }

            public SuggestedPhotosModel() {
                super(1);
            }

            @Nonnull
            public final ImmutableList<SuggestedPhotoModel> m25888a() {
                this.f17727d = super.a(this.f17727d, 0, SuggestedPhotoModel.class);
                return (ImmutableList) this.f17727d;
            }

            public final int jK_() {
                return 1190800139;
            }

            public final GraphQLVisitableModel m25887a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m25888a() != null) {
                    Builder a = ModelHelper.a(m25888a(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        graphQLVisitableModel = (SuggestedPhotosModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f17727d = a.b();
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m25886a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m25888a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, a);
                i();
                return flatBufferBuilder.d();
            }
        }

        @Nullable
        public final /* synthetic */ DefaultTextWithEntitiesFields m25898b() {
            return m25889n();
        }

        @Nullable
        public final /* synthetic */ FavoritePhotosModel dx_() {
            return m25891p();
        }

        @Nullable
        public final /* synthetic */ IntroCardContextListItemsConnectionFieldsModel m25901g() {
            return m25890o();
        }

        @Nullable
        public final /* synthetic */ DefaultTextWithEntitiesFields m25904l() {
            return m25892q();
        }

        @Nullable
        public final /* synthetic */ SuggestedPhotosModel m25905m() {
            return m25893r();
        }

        public TimelineHeaderProfileIntroCardFieldsModel() {
            super(12);
        }

        @Nonnull
        public final ImmutableList<ActionLinksModel> m25896a() {
            this.f17728d = super.a(this.f17728d, 0, ActionLinksModel.class);
            return (ImmutableList) this.f17728d;
        }

        @Nullable
        private DefaultTextWithEntitiesFieldsModel m25889n() {
            this.f17729e = (DefaultTextWithEntitiesFieldsModel) super.a(this.f17729e, 1, DefaultTextWithEntitiesFieldsModel.class);
            return this.f17729e;
        }

        public final boolean m25899c() {
            a(0, 2);
            return this.f17730f;
        }

        public final boolean m25900d() {
            a(0, 3);
            return this.f17731g;
        }

        public final boolean dv_() {
            a(0, 4);
            return this.f17732h;
        }

        @Nullable
        private IntroCardContextListItemsConnectionFieldsModel m25890o() {
            this.f17733i = (IntroCardContextListItemsConnectionFieldsModel) super.a(this.f17733i, 5, IntroCardContextListItemsConnectionFieldsModel.class);
            return this.f17733i;
        }

        @Nonnull
        public final ImmutableList<ExternalLinkModel> dw_() {
            this.f17734j = super.a(this.f17734j, 6, ExternalLinkModel.class);
            return (ImmutableList) this.f17734j;
        }

        @Nullable
        private FavoritePhotosModel m25891p() {
            this.f17735k = (FavoritePhotosModel) super.a(this.f17735k, 7, FavoritePhotosModel.class);
            return this.f17735k;
        }

        public final boolean m25902j() {
            a(1, 0);
            return this.f17736l;
        }

        public final boolean m25903k() {
            a(1, 1);
            return this.f17737m;
        }

        @Nullable
        private DefaultTextWithEntitiesFieldsModel m25892q() {
            this.f17738n = (DefaultTextWithEntitiesFieldsModel) super.a(this.f17738n, 10, DefaultTextWithEntitiesFieldsModel.class);
            return this.f17738n;
        }

        @Nullable
        private SuggestedPhotosModel m25893r() {
            this.f17739o = (SuggestedPhotosModel) super.a(this.f17739o, 11, SuggestedPhotosModel.class);
            return this.f17739o;
        }

        public final int jK_() {
            return 2102913043;
        }

        public final GraphQLVisitableModel m25895a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            TimelineHeaderProfileIntroCardFieldsModel timelineHeaderProfileIntroCardFieldsModel;
            GraphQLVisitableModel graphQLVisitableModel;
            DefaultTextWithEntitiesFieldsModel defaultTextWithEntitiesFieldsModel;
            IntroCardContextListItemsConnectionFieldsModel introCardContextListItemsConnectionFieldsModel;
            Builder a;
            FavoritePhotosModel favoritePhotosModel;
            SuggestedPhotosModel suggestedPhotosModel;
            h();
            if (m25896a() != null) {
                Builder a2 = ModelHelper.a(m25896a(), graphQLModelMutatingVisitor);
                if (a2 != null) {
                    timelineHeaderProfileIntroCardFieldsModel = (TimelineHeaderProfileIntroCardFieldsModel) ModelHelper.a(null, this);
                    timelineHeaderProfileIntroCardFieldsModel.f17728d = a2.b();
                    graphQLVisitableModel = timelineHeaderProfileIntroCardFieldsModel;
                    if (m25889n() != null) {
                        defaultTextWithEntitiesFieldsModel = (DefaultTextWithEntitiesFieldsModel) graphQLModelMutatingVisitor.b(m25889n());
                        if (m25889n() != defaultTextWithEntitiesFieldsModel) {
                            graphQLVisitableModel = (TimelineHeaderProfileIntroCardFieldsModel) ModelHelper.a(graphQLVisitableModel, this);
                            graphQLVisitableModel.f17729e = defaultTextWithEntitiesFieldsModel;
                        }
                    }
                    if (m25890o() != null) {
                        introCardContextListItemsConnectionFieldsModel = (IntroCardContextListItemsConnectionFieldsModel) graphQLModelMutatingVisitor.b(m25890o());
                        if (m25890o() != introCardContextListItemsConnectionFieldsModel) {
                            graphQLVisitableModel = (TimelineHeaderProfileIntroCardFieldsModel) ModelHelper.a(graphQLVisitableModel, this);
                            graphQLVisitableModel.f17733i = introCardContextListItemsConnectionFieldsModel;
                        }
                    }
                    if (dw_() != null) {
                        a = ModelHelper.a(dw_(), graphQLModelMutatingVisitor);
                        if (a != null) {
                            timelineHeaderProfileIntroCardFieldsModel = (TimelineHeaderProfileIntroCardFieldsModel) ModelHelper.a(graphQLVisitableModel, this);
                            timelineHeaderProfileIntroCardFieldsModel.f17734j = a.b();
                            graphQLVisitableModel = timelineHeaderProfileIntroCardFieldsModel;
                        }
                    }
                    if (m25891p() != null) {
                        favoritePhotosModel = (FavoritePhotosModel) graphQLModelMutatingVisitor.b(m25891p());
                        if (m25891p() != favoritePhotosModel) {
                            graphQLVisitableModel = (TimelineHeaderProfileIntroCardFieldsModel) ModelHelper.a(graphQLVisitableModel, this);
                            graphQLVisitableModel.f17735k = favoritePhotosModel;
                        }
                    }
                    if (m25892q() != null) {
                        defaultTextWithEntitiesFieldsModel = (DefaultTextWithEntitiesFieldsModel) graphQLModelMutatingVisitor.b(m25892q());
                        if (m25892q() != defaultTextWithEntitiesFieldsModel) {
                            graphQLVisitableModel = (TimelineHeaderProfileIntroCardFieldsModel) ModelHelper.a(graphQLVisitableModel, this);
                            graphQLVisitableModel.f17738n = defaultTextWithEntitiesFieldsModel;
                        }
                    }
                    if (m25893r() != null) {
                        suggestedPhotosModel = (SuggestedPhotosModel) graphQLModelMutatingVisitor.b(m25893r());
                        if (m25893r() != suggestedPhotosModel) {
                            graphQLVisitableModel = (TimelineHeaderProfileIntroCardFieldsModel) ModelHelper.a(graphQLVisitableModel, this);
                            graphQLVisitableModel.f17739o = suggestedPhotosModel;
                        }
                    }
                    i();
                    return graphQLVisitableModel != null ? this : graphQLVisitableModel;
                }
            }
            graphQLVisitableModel = null;
            if (m25889n() != null) {
                defaultTextWithEntitiesFieldsModel = (DefaultTextWithEntitiesFieldsModel) graphQLModelMutatingVisitor.b(m25889n());
                if (m25889n() != defaultTextWithEntitiesFieldsModel) {
                    graphQLVisitableModel = (TimelineHeaderProfileIntroCardFieldsModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f17729e = defaultTextWithEntitiesFieldsModel;
                }
            }
            if (m25890o() != null) {
                introCardContextListItemsConnectionFieldsModel = (IntroCardContextListItemsConnectionFieldsModel) graphQLModelMutatingVisitor.b(m25890o());
                if (m25890o() != introCardContextListItemsConnectionFieldsModel) {
                    graphQLVisitableModel = (TimelineHeaderProfileIntroCardFieldsModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f17733i = introCardContextListItemsConnectionFieldsModel;
                }
            }
            if (dw_() != null) {
                a = ModelHelper.a(dw_(), graphQLModelMutatingVisitor);
                if (a != null) {
                    timelineHeaderProfileIntroCardFieldsModel = (TimelineHeaderProfileIntroCardFieldsModel) ModelHelper.a(graphQLVisitableModel, this);
                    timelineHeaderProfileIntroCardFieldsModel.f17734j = a.b();
                    graphQLVisitableModel = timelineHeaderProfileIntroCardFieldsModel;
                }
            }
            if (m25891p() != null) {
                favoritePhotosModel = (FavoritePhotosModel) graphQLModelMutatingVisitor.b(m25891p());
                if (m25891p() != favoritePhotosModel) {
                    graphQLVisitableModel = (TimelineHeaderProfileIntroCardFieldsModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f17735k = favoritePhotosModel;
                }
            }
            if (m25892q() != null) {
                defaultTextWithEntitiesFieldsModel = (DefaultTextWithEntitiesFieldsModel) graphQLModelMutatingVisitor.b(m25892q());
                if (m25892q() != defaultTextWithEntitiesFieldsModel) {
                    graphQLVisitableModel = (TimelineHeaderProfileIntroCardFieldsModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f17738n = defaultTextWithEntitiesFieldsModel;
                }
            }
            if (m25893r() != null) {
                suggestedPhotosModel = (SuggestedPhotosModel) graphQLModelMutatingVisitor.b(m25893r());
                if (m25893r() != suggestedPhotosModel) {
                    graphQLVisitableModel = (TimelineHeaderProfileIntroCardFieldsModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f17739o = suggestedPhotosModel;
                }
            }
            i();
            if (graphQLVisitableModel != null) {
            }
        }

        public final int m25894a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m25896a());
            int a2 = ModelHelper.a(flatBufferBuilder, m25889n());
            int a3 = ModelHelper.a(flatBufferBuilder, m25890o());
            int a4 = ModelHelper.a(flatBufferBuilder, dw_());
            int a5 = ModelHelper.a(flatBufferBuilder, m25891p());
            int a6 = ModelHelper.a(flatBufferBuilder, m25892q());
            int a7 = ModelHelper.a(flatBufferBuilder, m25893r());
            flatBufferBuilder.c(12);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, a2);
            flatBufferBuilder.a(2, this.f17730f);
            flatBufferBuilder.a(3, this.f17731g);
            flatBufferBuilder.a(4, this.f17732h);
            flatBufferBuilder.b(5, a3);
            flatBufferBuilder.b(6, a4);
            flatBufferBuilder.b(7, a5);
            flatBufferBuilder.a(8, this.f17736l);
            flatBufferBuilder.a(9, this.f17737m);
            flatBufferBuilder.b(10, a6);
            flatBufferBuilder.b(11, a7);
            i();
            return flatBufferBuilder.d();
        }

        public final void m25897a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
            super.a(mutableFlatBuffer, i, obj);
            this.f17730f = mutableFlatBuffer.a(i, 2);
            this.f17731g = mutableFlatBuffer.a(i, 3);
            this.f17732h = mutableFlatBuffer.a(i, 4);
            this.f17736l = mutableFlatBuffer.a(i, 8);
            this.f17737m = mutableFlatBuffer.a(i, 9);
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -288304916)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: delete_app_and_posts */
    public final class TimelineHeaderProfilePhotoFieldsModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel {
        @Nullable
        private AlbumModel f17741d;
        @Nullable
        private String f17742e;
        private long f17743f;

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 1801334754)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: delete_app_and_posts */
        public final class AlbumModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel {
            @Nullable
            private String f17740d;

            /* compiled from: delete_app_and_posts */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(AlbumModel.class, new Deserializer());
                }

                public Object m25906a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(TimelineHeaderProfilePhotoFieldsParser.AlbumParser.m26101a(jsonParser, flatBufferBuilder));
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

            /* compiled from: delete_app_and_posts */
            public class Serializer extends JsonSerializer<AlbumModel> {
                public final void m25907a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    AlbumModel albumModel = (AlbumModel) obj;
                    if (albumModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(albumModel.m25908a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        albumModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    TimelineHeaderProfilePhotoFieldsParser.AlbumParser.m26102a(albumModel.w_(), albumModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(AlbumModel.class, new Serializer());
                }
            }

            public AlbumModel() {
                super(1);
            }

            @Nullable
            public final String m25911b() {
                this.f17740d = super.a(this.f17740d, 0);
                return this.f17740d;
            }

            @Nullable
            public final String m25910a() {
                return m25911b();
            }

            public final int jK_() {
                return 63344207;
            }

            public final GraphQLVisitableModel m25909a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m25908a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m25911b());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, b);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: delete_app_and_posts */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(TimelineHeaderProfilePhotoFieldsModel.class, new Deserializer());
            }

            public Object m25912a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(TimelineHeaderProfilePhotoFieldsParser.m26103a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object timelineHeaderProfilePhotoFieldsModel = new TimelineHeaderProfilePhotoFieldsModel();
                ((BaseModel) timelineHeaderProfilePhotoFieldsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (timelineHeaderProfilePhotoFieldsModel instanceof Postprocessable) {
                    return ((Postprocessable) timelineHeaderProfilePhotoFieldsModel).a();
                }
                return timelineHeaderProfilePhotoFieldsModel;
            }
        }

        /* compiled from: delete_app_and_posts */
        public class Serializer extends JsonSerializer<TimelineHeaderProfilePhotoFieldsModel> {
            public final void m25913a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                TimelineHeaderProfilePhotoFieldsModel timelineHeaderProfilePhotoFieldsModel = (TimelineHeaderProfilePhotoFieldsModel) obj;
                if (timelineHeaderProfilePhotoFieldsModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(timelineHeaderProfilePhotoFieldsModel.m25915a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    timelineHeaderProfilePhotoFieldsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                TimelineHeaderProfilePhotoFieldsParser.m26104a(timelineHeaderProfilePhotoFieldsModel.w_(), timelineHeaderProfilePhotoFieldsModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(TimelineHeaderProfilePhotoFieldsModel.class, new Serializer());
            }
        }

        @Nullable
        public final /* synthetic */ AlbumModel m25919b() {
            return m25914j();
        }

        public TimelineHeaderProfilePhotoFieldsModel() {
            super(3);
        }

        @Nullable
        private AlbumModel m25914j() {
            this.f17741d = (AlbumModel) super.a(this.f17741d, 0, AlbumModel.class);
            return this.f17741d;
        }

        @Nullable
        public final String m25920c() {
            this.f17742e = super.a(this.f17742e, 1);
            return this.f17742e;
        }

        public final long m25921d() {
            a(0, 2);
            return this.f17743f;
        }

        @Nullable
        public final String m25917a() {
            return m25920c();
        }

        public final int jK_() {
            return 77090322;
        }

        public final GraphQLVisitableModel m25916a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m25914j() != null) {
                AlbumModel albumModel = (AlbumModel) graphQLModelMutatingVisitor.b(m25914j());
                if (m25914j() != albumModel) {
                    graphQLVisitableModel = (TimelineHeaderProfilePhotoFieldsModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f17741d = albumModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m25915a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m25914j());
            int b = flatBufferBuilder.b(m25920c());
            flatBufferBuilder.c(3);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, b);
            flatBufferBuilder.a(2, this.f17743f, 0);
            i();
            return flatBufferBuilder.d();
        }

        public final void m25918a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
            super.a(mutableFlatBuffer, i, obj);
            this.f17743f = mutableFlatBuffer.a(i, 2, 0);
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -541630613)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: delete_app_and_posts */
    public final class TimelineHeaderStructuredNameModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private List<DefaultNamePartFieldsModel> f17744d;
        @Nullable
        private String f17745e;

        /* compiled from: delete_app_and_posts */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(TimelineHeaderStructuredNameModel.class, new Deserializer());
            }

            public Object m25922a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(TimelineHeaderStructuredNameParser.m26105a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object timelineHeaderStructuredNameModel = new TimelineHeaderStructuredNameModel();
                ((BaseModel) timelineHeaderStructuredNameModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (timelineHeaderStructuredNameModel instanceof Postprocessable) {
                    return ((Postprocessable) timelineHeaderStructuredNameModel).a();
                }
                return timelineHeaderStructuredNameModel;
            }
        }

        /* compiled from: delete_app_and_posts */
        public class Serializer extends JsonSerializer<TimelineHeaderStructuredNameModel> {
            public final void m25923a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                TimelineHeaderStructuredNameModel timelineHeaderStructuredNameModel = (TimelineHeaderStructuredNameModel) obj;
                if (timelineHeaderStructuredNameModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(timelineHeaderStructuredNameModel.m25924a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    timelineHeaderStructuredNameModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                TimelineHeaderStructuredNameParser.m26106a(timelineHeaderStructuredNameModel.w_(), timelineHeaderStructuredNameModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(TimelineHeaderStructuredNameModel.class, new Serializer());
            }
        }

        public TimelineHeaderStructuredNameModel() {
            super(2);
        }

        @Nonnull
        public final ImmutableList<DefaultNamePartFieldsModel> m25926a() {
            this.f17744d = super.a(this.f17744d, 0, DefaultNamePartFieldsModel.class);
            return (ImmutableList) this.f17744d;
        }

        @Nullable
        public final String m25927b() {
            this.f17745e = super.a(this.f17745e, 1);
            return this.f17745e;
        }

        public final int jK_() {
            return 2420395;
        }

        public final GraphQLVisitableModel m25925a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m25926a() != null) {
                Builder a = ModelHelper.a(m25926a(), graphQLModelMutatingVisitor);
                if (a != null) {
                    graphQLVisitableModel = (TimelineHeaderStructuredNameModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f17744d = a.b();
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m25924a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m25926a());
            int b = flatBufferBuilder.b(m25927b());
            flatBufferBuilder.c(2);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, b);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 232353463)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: delete_app_and_posts */
    public final class TimelineHeaderUserFieldsModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel, TimelineHeaderActionFields {
        @Nullable
        private ProfileHeaderAssociatedVideoModel f17774A;
        @Nullable
        private GraphQLSecondarySubscribeStatus f17775B;
        @Nullable
        private TimelineHeaderStructuredNameModel f17776C;
        @Nullable
        private GraphQLSubscribeStatus f17777D;
        @Nullable
        private TimelineContextListItemsConnectionFieldsModel f17778E;
        @Nullable
        private String f17779d;
        private boolean f17780e;
        private boolean f17781f;
        private boolean f17782g;
        private boolean f17783h;
        private boolean f17784i;
        private boolean f17785j;
        @Nullable
        private TimelineHeaderFocusedCoverPhotoFieldsModel f17786k;
        @Nullable
        private FriendsModel f17787l;
        @Nullable
        private GraphQLFriendshipStatus f17788m;
        @Nullable
        private String f17789n;
        private boolean f17790o;
        private boolean f17791p;
        private boolean f17792q;
        private boolean f17793r;
        private boolean f17794s;
        @Nullable
        private String f17795t;
        @Nullable
        private ComposerTargetDataPrivacyScopeFieldsModel f17796u;
        @Nullable
        private TimelineHeaderProfileIntroCardFieldsModel f17797v;
        @Nullable
        private TimelineHeaderProfilePhotoFieldsModel f17798w;
        @Nullable
        private DefaultImageFieldsModel f17799x;
        private long f17800y;
        private boolean f17801z;

        /* compiled from: delete_app_and_posts */
        public final class Builder {
            @Nullable
            public GraphQLSubscribeStatus f17746A;
            @Nullable
            public TimelineContextListItemsConnectionFieldsModel f17747B;
            @Nullable
            public String f17748a;
            public boolean f17749b;
            public boolean f17750c;
            public boolean f17751d;
            public boolean f17752e;
            public boolean f17753f;
            public boolean f17754g;
            @Nullable
            public TimelineHeaderFocusedCoverPhotoFieldsModel f17755h;
            @Nullable
            public FriendsModel f17756i;
            @Nullable
            public GraphQLFriendshipStatus f17757j;
            @Nullable
            public String f17758k;
            public boolean f17759l;
            public boolean f17760m;
            public boolean f17761n;
            public boolean f17762o;
            public boolean f17763p;
            @Nullable
            public String f17764q;
            @Nullable
            public ComposerTargetDataPrivacyScopeFieldsModel f17765r;
            @Nullable
            public TimelineHeaderProfileIntroCardFieldsModel f17766s;
            @Nullable
            public TimelineHeaderProfilePhotoFieldsModel f17767t;
            @Nullable
            public DefaultImageFieldsModel f17768u;
            public long f17769v;
            public boolean f17770w;
            @Nullable
            public ProfileHeaderAssociatedVideoModel f17771x;
            @Nullable
            public GraphQLSecondarySubscribeStatus f17772y;
            @Nullable
            public TimelineHeaderStructuredNameModel f17773z;

            public static Builder m25928a(TimelineHeaderUserFieldsModel timelineHeaderUserFieldsModel) {
                Builder builder = new Builder();
                builder.f17748a = timelineHeaderUserFieldsModel.m25973v();
                builder.f17749b = timelineHeaderUserFieldsModel.mo1330b();
                builder.f17750c = timelineHeaderUserFieldsModel.mo1331c();
                builder.f17751d = timelineHeaderUserFieldsModel.mo1332d();
                builder.f17752e = timelineHeaderUserFieldsModel.do_();
                builder.f17753f = timelineHeaderUserFieldsModel.mo1336g();
                builder.f17754g = timelineHeaderUserFieldsModel.dp_();
                builder.f17755h = timelineHeaderUserFieldsModel.m25942E();
                builder.f17756i = timelineHeaderUserFieldsModel.m25943F();
                builder.f17757j = timelineHeaderUserFieldsModel.mo1337j();
                builder.f17758k = timelineHeaderUserFieldsModel.m25967p();
                builder.f17759l = timelineHeaderUserFieldsModel.mo1338k();
                builder.f17760m = timelineHeaderUserFieldsModel.m25974w();
                builder.f17761n = timelineHeaderUserFieldsModel.m25975x();
                builder.f17762o = timelineHeaderUserFieldsModel.m25976y();
                builder.f17763p = timelineHeaderUserFieldsModel.m25977z();
                builder.f17764q = timelineHeaderUserFieldsModel.m25968q();
                builder.f17765r = timelineHeaderUserFieldsModel.m25944G();
                builder.f17766s = timelineHeaderUserFieldsModel.m25945H();
                builder.f17767t = timelineHeaderUserFieldsModel.m25946I();
                builder.f17768u = timelineHeaderUserFieldsModel.m25947J();
                builder.f17769v = timelineHeaderUserFieldsModel.m25939B();
                builder.f17770w = timelineHeaderUserFieldsModel.m25940C();
                builder.f17771x = timelineHeaderUserFieldsModel.m25948K();
                builder.f17772y = timelineHeaderUserFieldsModel.mo1340m();
                builder.f17773z = timelineHeaderUserFieldsModel.m25949L();
                builder.f17746A = timelineHeaderUserFieldsModel.mo1341n();
                builder.f17747B = timelineHeaderUserFieldsModel.m25950M();
                return builder;
            }

            public final TimelineHeaderUserFieldsModel m25929a() {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                int b = flatBufferBuilder.b(this.f17748a);
                int a = ModelHelper.a(flatBufferBuilder, this.f17755h);
                int a2 = ModelHelper.a(flatBufferBuilder, this.f17756i);
                int a3 = flatBufferBuilder.a(this.f17757j);
                int b2 = flatBufferBuilder.b(this.f17758k);
                int b3 = flatBufferBuilder.b(this.f17764q);
                int a4 = ModelHelper.a(flatBufferBuilder, this.f17765r);
                int a5 = ModelHelper.a(flatBufferBuilder, this.f17766s);
                int a6 = ModelHelper.a(flatBufferBuilder, this.f17767t);
                int a7 = ModelHelper.a(flatBufferBuilder, this.f17768u);
                int a8 = ModelHelper.a(flatBufferBuilder, this.f17771x);
                int a9 = flatBufferBuilder.a(this.f17772y);
                int a10 = ModelHelper.a(flatBufferBuilder, this.f17773z);
                int a11 = flatBufferBuilder.a(this.f17746A);
                int a12 = ModelHelper.a(flatBufferBuilder, this.f17747B);
                flatBufferBuilder.c(28);
                flatBufferBuilder.b(0, b);
                flatBufferBuilder.a(1, this.f17749b);
                flatBufferBuilder.a(2, this.f17750c);
                flatBufferBuilder.a(3, this.f17751d);
                flatBufferBuilder.a(4, this.f17752e);
                flatBufferBuilder.a(5, this.f17753f);
                flatBufferBuilder.a(6, this.f17754g);
                flatBufferBuilder.b(7, a);
                flatBufferBuilder.b(8, a2);
                flatBufferBuilder.b(9, a3);
                flatBufferBuilder.b(10, b2);
                flatBufferBuilder.a(11, this.f17759l);
                flatBufferBuilder.a(12, this.f17760m);
                flatBufferBuilder.a(13, this.f17761n);
                flatBufferBuilder.a(14, this.f17762o);
                flatBufferBuilder.a(15, this.f17763p);
                flatBufferBuilder.b(16, b3);
                flatBufferBuilder.b(17, a4);
                flatBufferBuilder.b(18, a5);
                flatBufferBuilder.b(19, a6);
                flatBufferBuilder.b(20, a7);
                flatBufferBuilder.a(21, this.f17769v, 0);
                flatBufferBuilder.a(22, this.f17770w);
                flatBufferBuilder.b(23, a8);
                flatBufferBuilder.b(24, a9);
                flatBufferBuilder.b(25, a10);
                flatBufferBuilder.b(26, a11);
                flatBufferBuilder.b(27, a12);
                flatBufferBuilder.d(flatBufferBuilder.d());
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                return new TimelineHeaderUserFieldsModel(new MutableFlatBuffer(wrap, null, null, true, null));
            }
        }

        /* compiled from: delete_app_and_posts */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(TimelineHeaderUserFieldsModel.class, new Deserializer());
            }

            public Object m25930a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(TimelineHeaderUserFieldsParser.m26107a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object timelineHeaderUserFieldsModel = new TimelineHeaderUserFieldsModel();
                ((BaseModel) timelineHeaderUserFieldsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (timelineHeaderUserFieldsModel instanceof Postprocessable) {
                    return ((Postprocessable) timelineHeaderUserFieldsModel).a();
                }
                return timelineHeaderUserFieldsModel;
            }
        }

        /* compiled from: delete_app_and_posts */
        public class Serializer extends JsonSerializer<TimelineHeaderUserFieldsModel> {
            public final void m25931a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                TimelineHeaderUserFieldsModel timelineHeaderUserFieldsModel = (TimelineHeaderUserFieldsModel) obj;
                if (timelineHeaderUserFieldsModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(timelineHeaderUserFieldsModel.m25951a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    timelineHeaderUserFieldsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                TimelineHeaderUserFieldsParser.m26108a(timelineHeaderUserFieldsModel.w_(), timelineHeaderUserFieldsModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(TimelineHeaderUserFieldsModel.class, new Serializer());
            }
        }

        @Nullable
        public final /* synthetic */ TimelineHeaderStructuredNameModel m25938A() {
            return m25949L();
        }

        @Nullable
        public final /* synthetic */ TimelineContextListItemsConnectionFieldsModel m25941D() {
            return m25950M();
        }

        @Nullable
        public final /* synthetic */ FriendsModel dq_() {
            return m25943F();
        }

        @Nullable
        public final /* synthetic */ ComposerTargetDataPrivacyScopeFields mo1339l() {
            return m25944G();
        }

        @Nullable
        public final /* synthetic */ TimelineHeaderFocusedCoverPhotoFieldsModel m25966o() {
            return m25942E();
        }

        @Nullable
        public final /* synthetic */ TimelineHeaderProfileIntroCardFieldsModel m25969r() {
            return m25945H();
        }

        @Nullable
        public final /* synthetic */ TimelineHeaderProfilePhotoFieldsModel m25970s() {
            return m25946I();
        }

        @Nullable
        public final /* synthetic */ DefaultImageFields m25971t() {
            return m25947J();
        }

        @Nullable
        public final /* synthetic */ ProfileHeaderAssociatedVideoModel m25972u() {
            return m25948K();
        }

        public TimelineHeaderUserFieldsModel() {
            super(28);
        }

        public TimelineHeaderUserFieldsModel(MutableFlatBuffer mutableFlatBuffer) {
            super(28);
            a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
        }

        public final void m25955a(String str, ConsistencyTuple consistencyTuple) {
            if ("can_viewer_message".equals(str)) {
                consistencyTuple.a = Boolean.valueOf(mo1332d());
                consistencyTuple.b = u_();
                consistencyTuple.c = 3;
            } else if ("can_viewer_poke".equals(str)) {
                consistencyTuple.a = Boolean.valueOf(do_());
                consistencyTuple.b = u_();
                consistencyTuple.c = 4;
            } else if ("can_viewer_post".equals(str)) {
                consistencyTuple.a = Boolean.valueOf(mo1336g());
                consistencyTuple.b = u_();
                consistencyTuple.c = 5;
            } else if ("friendship_status".equals(str)) {
                consistencyTuple.a = mo1337j();
                consistencyTuple.b = u_();
                consistencyTuple.c = 9;
            } else if ("secondary_subscribe_status".equals(str)) {
                consistencyTuple.a = mo1340m();
                consistencyTuple.b = u_();
                consistencyTuple.c = 24;
            } else if ("subscribe_status".equals(str)) {
                consistencyTuple.a = mo1341n();
                consistencyTuple.b = u_();
                consistencyTuple.c = 26;
            } else {
                consistencyTuple.a();
            }
        }

        public final void m25956a(String str, Object obj, boolean z) {
            if ("can_viewer_message".equals(str)) {
                m25935a(((Boolean) obj).booleanValue());
            } else if ("can_viewer_poke".equals(str)) {
                m25936b(((Boolean) obj).booleanValue());
            } else if ("can_viewer_post".equals(str)) {
                m25937c(((Boolean) obj).booleanValue());
            } else if ("friendship_status".equals(str)) {
                m25932a((GraphQLFriendshipStatus) obj);
            } else if ("secondary_subscribe_status".equals(str)) {
                m25933a((GraphQLSecondarySubscribeStatus) obj);
            } else if ("subscribe_status".equals(str)) {
                m25934a((GraphQLSubscribeStatus) obj);
            }
        }

        @Nullable
        public final String m25973v() {
            this.f17779d = super.a(this.f17779d, 0);
            return this.f17779d;
        }

        public final boolean mo1330b() {
            a(0, 1);
            return this.f17780e;
        }

        public final boolean mo1331c() {
            a(0, 2);
            return this.f17781f;
        }

        public final boolean mo1332d() {
            a(0, 3);
            return this.f17782g;
        }

        private void m25935a(boolean z) {
            this.f17782g = z;
            if (this.b != null && this.b.d) {
                this.b.a(this.c, 3, z);
            }
        }

        public final boolean do_() {
            a(0, 4);
            return this.f17783h;
        }

        private void m25936b(boolean z) {
            this.f17783h = z;
            if (this.b != null && this.b.d) {
                this.b.a(this.c, 4, z);
            }
        }

        public final boolean mo1336g() {
            a(0, 5);
            return this.f17784i;
        }

        private void m25937c(boolean z) {
            this.f17784i = z;
            if (this.b != null && this.b.d) {
                this.b.a(this.c, 5, z);
            }
        }

        public final boolean dp_() {
            a(0, 6);
            return this.f17785j;
        }

        @Nullable
        public final TimelineHeaderFocusedCoverPhotoFieldsModel m25942E() {
            this.f17786k = (TimelineHeaderFocusedCoverPhotoFieldsModel) super.a(this.f17786k, 7, TimelineHeaderFocusedCoverPhotoFieldsModel.class);
            return this.f17786k;
        }

        @Nullable
        public final FriendsModel m25943F() {
            this.f17787l = (FriendsModel) super.a(this.f17787l, 8, FriendsModel.class);
            return this.f17787l;
        }

        @Nullable
        public final GraphQLFriendshipStatus mo1337j() {
            this.f17788m = (GraphQLFriendshipStatus) super.b(this.f17788m, 9, GraphQLFriendshipStatus.class, GraphQLFriendshipStatus.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
            return this.f17788m;
        }

        private void m25932a(GraphQLFriendshipStatus graphQLFriendshipStatus) {
            this.f17788m = graphQLFriendshipStatus;
            if (this.b != null && this.b.d) {
                this.b.a(this.c, 9, graphQLFriendshipStatus != null ? graphQLFriendshipStatus.name() : null);
            }
        }

        @Nullable
        public final String m25967p() {
            this.f17789n = super.a(this.f17789n, 10);
            return this.f17789n;
        }

        public final boolean mo1338k() {
            a(1, 3);
            return this.f17790o;
        }

        public final boolean m25974w() {
            a(1, 4);
            return this.f17791p;
        }

        public final boolean m25975x() {
            a(1, 5);
            return this.f17792q;
        }

        public final boolean m25976y() {
            a(1, 6);
            return this.f17793r;
        }

        public final boolean m25977z() {
            a(1, 7);
            return this.f17794s;
        }

        @Nullable
        public final String m25968q() {
            this.f17795t = super.a(this.f17795t, 16);
            return this.f17795t;
        }

        @Nullable
        public final ComposerTargetDataPrivacyScopeFieldsModel m25944G() {
            this.f17796u = (ComposerTargetDataPrivacyScopeFieldsModel) super.a(this.f17796u, 17, ComposerTargetDataPrivacyScopeFieldsModel.class);
            return this.f17796u;
        }

        @Nullable
        public final TimelineHeaderProfileIntroCardFieldsModel m25945H() {
            this.f17797v = (TimelineHeaderProfileIntroCardFieldsModel) super.a(this.f17797v, 18, TimelineHeaderProfileIntroCardFieldsModel.class);
            return this.f17797v;
        }

        @Nullable
        public final TimelineHeaderProfilePhotoFieldsModel m25946I() {
            this.f17798w = (TimelineHeaderProfilePhotoFieldsModel) super.a(this.f17798w, 19, TimelineHeaderProfilePhotoFieldsModel.class);
            return this.f17798w;
        }

        @Nullable
        public final DefaultImageFieldsModel m25947J() {
            this.f17799x = (DefaultImageFieldsModel) super.a(this.f17799x, 20, DefaultImageFieldsModel.class);
            return this.f17799x;
        }

        public final long m25939B() {
            a(2, 5);
            return this.f17800y;
        }

        public final boolean m25940C() {
            a(2, 6);
            return this.f17801z;
        }

        @Nullable
        public final ProfileHeaderAssociatedVideoModel m25948K() {
            this.f17774A = (ProfileHeaderAssociatedVideoModel) super.a(this.f17774A, 23, ProfileHeaderAssociatedVideoModel.class);
            return this.f17774A;
        }

        @Nullable
        public final GraphQLSecondarySubscribeStatus mo1340m() {
            this.f17775B = (GraphQLSecondarySubscribeStatus) super.b(this.f17775B, 24, GraphQLSecondarySubscribeStatus.class, GraphQLSecondarySubscribeStatus.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
            return this.f17775B;
        }

        private void m25933a(GraphQLSecondarySubscribeStatus graphQLSecondarySubscribeStatus) {
            this.f17775B = graphQLSecondarySubscribeStatus;
            if (this.b != null && this.b.d) {
                this.b.a(this.c, 24, graphQLSecondarySubscribeStatus != null ? graphQLSecondarySubscribeStatus.name() : null);
            }
        }

        @Nullable
        public final TimelineHeaderStructuredNameModel m25949L() {
            this.f17776C = (TimelineHeaderStructuredNameModel) super.a(this.f17776C, 25, TimelineHeaderStructuredNameModel.class);
            return this.f17776C;
        }

        @Nullable
        public final GraphQLSubscribeStatus mo1341n() {
            this.f17777D = (GraphQLSubscribeStatus) super.b(this.f17777D, 26, GraphQLSubscribeStatus.class, GraphQLSubscribeStatus.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
            return this.f17777D;
        }

        private void m25934a(GraphQLSubscribeStatus graphQLSubscribeStatus) {
            this.f17777D = graphQLSubscribeStatus;
            if (this.b != null && this.b.d) {
                this.b.a(this.c, 26, graphQLSubscribeStatus != null ? graphQLSubscribeStatus.name() : null);
            }
        }

        @Nullable
        public final TimelineContextListItemsConnectionFieldsModel m25950M() {
            this.f17778E = (TimelineContextListItemsConnectionFieldsModel) super.a(this.f17778E, 27, TimelineContextListItemsConnectionFieldsModel.class);
            return this.f17778E;
        }

        @Nullable
        public final String m25953a() {
            return m25967p();
        }

        public final int jK_() {
            return 2645995;
        }

        public final GraphQLVisitableModel m25952a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m25942E() != null) {
                TimelineHeaderFocusedCoverPhotoFieldsModel timelineHeaderFocusedCoverPhotoFieldsModel = (TimelineHeaderFocusedCoverPhotoFieldsModel) graphQLModelMutatingVisitor.b(m25942E());
                if (m25942E() != timelineHeaderFocusedCoverPhotoFieldsModel) {
                    graphQLVisitableModel = (TimelineHeaderUserFieldsModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f17786k = timelineHeaderFocusedCoverPhotoFieldsModel;
                }
            }
            if (m25943F() != null) {
                FriendsModel friendsModel = (FriendsModel) graphQLModelMutatingVisitor.b(m25943F());
                if (m25943F() != friendsModel) {
                    graphQLVisitableModel = (TimelineHeaderUserFieldsModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f17787l = friendsModel;
                }
            }
            if (m25944G() != null) {
                ComposerTargetDataPrivacyScopeFieldsModel composerTargetDataPrivacyScopeFieldsModel = (ComposerTargetDataPrivacyScopeFieldsModel) graphQLModelMutatingVisitor.b(m25944G());
                if (m25944G() != composerTargetDataPrivacyScopeFieldsModel) {
                    graphQLVisitableModel = (TimelineHeaderUserFieldsModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f17796u = composerTargetDataPrivacyScopeFieldsModel;
                }
            }
            if (m25945H() != null) {
                TimelineHeaderProfileIntroCardFieldsModel timelineHeaderProfileIntroCardFieldsModel = (TimelineHeaderProfileIntroCardFieldsModel) graphQLModelMutatingVisitor.b(m25945H());
                if (m25945H() != timelineHeaderProfileIntroCardFieldsModel) {
                    graphQLVisitableModel = (TimelineHeaderUserFieldsModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f17797v = timelineHeaderProfileIntroCardFieldsModel;
                }
            }
            if (m25946I() != null) {
                TimelineHeaderProfilePhotoFieldsModel timelineHeaderProfilePhotoFieldsModel = (TimelineHeaderProfilePhotoFieldsModel) graphQLModelMutatingVisitor.b(m25946I());
                if (m25946I() != timelineHeaderProfilePhotoFieldsModel) {
                    graphQLVisitableModel = (TimelineHeaderUserFieldsModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f17798w = timelineHeaderProfilePhotoFieldsModel;
                }
            }
            if (m25947J() != null) {
                DefaultImageFieldsModel defaultImageFieldsModel = (DefaultImageFieldsModel) graphQLModelMutatingVisitor.b(m25947J());
                if (m25947J() != defaultImageFieldsModel) {
                    graphQLVisitableModel = (TimelineHeaderUserFieldsModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f17799x = defaultImageFieldsModel;
                }
            }
            if (m25948K() != null) {
                ProfileHeaderAssociatedVideoModel profileHeaderAssociatedVideoModel = (ProfileHeaderAssociatedVideoModel) graphQLModelMutatingVisitor.b(m25948K());
                if (m25948K() != profileHeaderAssociatedVideoModel) {
                    graphQLVisitableModel = (TimelineHeaderUserFieldsModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f17774A = profileHeaderAssociatedVideoModel;
                }
            }
            if (m25949L() != null) {
                TimelineHeaderStructuredNameModel timelineHeaderStructuredNameModel = (TimelineHeaderStructuredNameModel) graphQLModelMutatingVisitor.b(m25949L());
                if (m25949L() != timelineHeaderStructuredNameModel) {
                    graphQLVisitableModel = (TimelineHeaderUserFieldsModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f17776C = timelineHeaderStructuredNameModel;
                }
            }
            if (m25950M() != null) {
                TimelineContextListItemsConnectionFieldsModel timelineContextListItemsConnectionFieldsModel = (TimelineContextListItemsConnectionFieldsModel) graphQLModelMutatingVisitor.b(m25950M());
                if (m25950M() != timelineContextListItemsConnectionFieldsModel) {
                    graphQLVisitableModel = (TimelineHeaderUserFieldsModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f17778E = timelineContextListItemsConnectionFieldsModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m25951a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(m25973v());
            int a = ModelHelper.a(flatBufferBuilder, m25942E());
            int a2 = ModelHelper.a(flatBufferBuilder, m25943F());
            int a3 = flatBufferBuilder.a(mo1337j());
            int b2 = flatBufferBuilder.b(m25967p());
            int b3 = flatBufferBuilder.b(m25968q());
            int a4 = ModelHelper.a(flatBufferBuilder, m25944G());
            int a5 = ModelHelper.a(flatBufferBuilder, m25945H());
            int a6 = ModelHelper.a(flatBufferBuilder, m25946I());
            int a7 = ModelHelper.a(flatBufferBuilder, m25947J());
            int a8 = ModelHelper.a(flatBufferBuilder, m25948K());
            int a9 = flatBufferBuilder.a(mo1340m());
            int a10 = ModelHelper.a(flatBufferBuilder, m25949L());
            int a11 = flatBufferBuilder.a(mo1341n());
            int a12 = ModelHelper.a(flatBufferBuilder, m25950M());
            flatBufferBuilder.c(28);
            flatBufferBuilder.b(0, b);
            flatBufferBuilder.a(1, this.f17780e);
            flatBufferBuilder.a(2, this.f17781f);
            flatBufferBuilder.a(3, this.f17782g);
            flatBufferBuilder.a(4, this.f17783h);
            flatBufferBuilder.a(5, this.f17784i);
            flatBufferBuilder.a(6, this.f17785j);
            flatBufferBuilder.b(7, a);
            flatBufferBuilder.b(8, a2);
            flatBufferBuilder.b(9, a3);
            flatBufferBuilder.b(10, b2);
            flatBufferBuilder.a(11, this.f17790o);
            flatBufferBuilder.a(12, this.f17791p);
            flatBufferBuilder.a(13, this.f17792q);
            flatBufferBuilder.a(14, this.f17793r);
            flatBufferBuilder.a(15, this.f17794s);
            flatBufferBuilder.b(16, b3);
            flatBufferBuilder.b(17, a4);
            flatBufferBuilder.b(18, a5);
            flatBufferBuilder.b(19, a6);
            flatBufferBuilder.b(20, a7);
            flatBufferBuilder.a(21, this.f17800y, 0);
            flatBufferBuilder.a(22, this.f17801z);
            flatBufferBuilder.b(23, a8);
            flatBufferBuilder.b(24, a9);
            flatBufferBuilder.b(25, a10);
            flatBufferBuilder.b(26, a11);
            flatBufferBuilder.b(27, a12);
            i();
            return flatBufferBuilder.d();
        }

        public final void m25954a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
            super.a(mutableFlatBuffer, i, obj);
            this.f17780e = mutableFlatBuffer.a(i, 1);
            this.f17781f = mutableFlatBuffer.a(i, 2);
            this.f17782g = mutableFlatBuffer.a(i, 3);
            this.f17783h = mutableFlatBuffer.a(i, 4);
            this.f17784i = mutableFlatBuffer.a(i, 5);
            this.f17785j = mutableFlatBuffer.a(i, 6);
            this.f17790o = mutableFlatBuffer.a(i, 11);
            this.f17791p = mutableFlatBuffer.a(i, 12);
            this.f17792q = mutableFlatBuffer.a(i, 13);
            this.f17793r = mutableFlatBuffer.a(i, 14);
            this.f17794s = mutableFlatBuffer.a(i, 15);
            this.f17800y = mutableFlatBuffer.a(i, 21, 0);
            this.f17801z = mutableFlatBuffer.a(i, 22);
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 103325110)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: delete_app_and_posts */
    public final class TimelineNuxFieldsModel extends BaseModel implements GraphQLVisitableModel, TimelineNuxFields {
        @Nullable
        private ProfileWizardNuxModel f17807d;

        /* compiled from: delete_app_and_posts */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(TimelineNuxFieldsModel.class, new Deserializer());
            }

            public Object m25978a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = TimelineNuxFieldsParser.m26115a(jsonParser);
                Object timelineNuxFieldsModel = new TimelineNuxFieldsModel();
                ((BaseModel) timelineNuxFieldsModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (timelineNuxFieldsModel instanceof Postprocessable) {
                    return ((Postprocessable) timelineNuxFieldsModel).a();
                }
                return timelineNuxFieldsModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 2082753785)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: delete_app_and_posts */
        public final class ProfileWizardNuxModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private DescriptionModel f17804d;
            private boolean f17805e;
            @Nullable
            private TitleModel f17806f;

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = -1352864475)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: delete_app_and_posts */
            public final class DescriptionModel extends BaseModel implements GraphQLVisitableModel {
                @Nullable
                private String f17802d;

                /* compiled from: delete_app_and_posts */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(DescriptionModel.class, new Deserializer());
                    }

                    public Object m25979a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(ProfileWizardNuxParser.DescriptionParser.m26109a(jsonParser, flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                        Object descriptionModel = new DescriptionModel();
                        ((BaseModel) descriptionModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                        if (descriptionModel instanceof Postprocessable) {
                            return ((Postprocessable) descriptionModel).a();
                        }
                        return descriptionModel;
                    }
                }

                /* compiled from: delete_app_and_posts */
                public class Serializer extends JsonSerializer<DescriptionModel> {
                    public final void m25980a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        DescriptionModel descriptionModel = (DescriptionModel) obj;
                        if (descriptionModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(descriptionModel.m25981a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            descriptionModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        ProfileWizardNuxParser.DescriptionParser.m26110a(descriptionModel.w_(), descriptionModel.u_(), jsonGenerator);
                    }

                    static {
                        FbSerializerProvider.a(DescriptionModel.class, new Serializer());
                    }
                }

                public DescriptionModel() {
                    super(1);
                }

                @Nullable
                public final String m25983a() {
                    this.f17802d = super.a(this.f17802d, 0);
                    return this.f17802d;
                }

                public final int jK_() {
                    return -1919764332;
                }

                public final GraphQLVisitableModel m25982a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    h();
                    i();
                    return this;
                }

                public final int m25981a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int b = flatBufferBuilder.b(m25983a());
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.b(0, b);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            /* compiled from: delete_app_and_posts */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(ProfileWizardNuxModel.class, new Deserializer());
                }

                public Object m25984a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(ProfileWizardNuxParser.m26113a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object profileWizardNuxModel = new ProfileWizardNuxModel();
                    ((BaseModel) profileWizardNuxModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (profileWizardNuxModel instanceof Postprocessable) {
                        return ((Postprocessable) profileWizardNuxModel).a();
                    }
                    return profileWizardNuxModel;
                }
            }

            /* compiled from: delete_app_and_posts */
            public class Serializer extends JsonSerializer<ProfileWizardNuxModel> {
                public final void m25985a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    ProfileWizardNuxModel profileWizardNuxModel = (ProfileWizardNuxModel) obj;
                    if (profileWizardNuxModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(profileWizardNuxModel.m25993a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        profileWizardNuxModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    ProfileWizardNuxParser.m26114a(profileWizardNuxModel.w_(), profileWizardNuxModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(ProfileWizardNuxModel.class, new Serializer());
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = -1352864475)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: delete_app_and_posts */
            public final class TitleModel extends BaseModel implements GraphQLVisitableModel {
                @Nullable
                private String f17803d;

                /* compiled from: delete_app_and_posts */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(TitleModel.class, new Deserializer());
                    }

                    public Object m25986a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(ProfileWizardNuxParser.TitleParser.m26111a(jsonParser, flatBufferBuilder));
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

                /* compiled from: delete_app_and_posts */
                public class Serializer extends JsonSerializer<TitleModel> {
                    public final void m25987a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        TitleModel titleModel = (TitleModel) obj;
                        if (titleModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(titleModel.m25988a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            titleModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        ProfileWizardNuxParser.TitleParser.m26112a(titleModel.w_(), titleModel.u_(), jsonGenerator);
                    }

                    static {
                        FbSerializerProvider.a(TitleModel.class, new Serializer());
                    }
                }

                public TitleModel() {
                    super(1);
                }

                @Nullable
                public final String m25990a() {
                    this.f17803d = super.a(this.f17803d, 0);
                    return this.f17803d;
                }

                public final int jK_() {
                    return -1919764332;
                }

                public final GraphQLVisitableModel m25989a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    h();
                    i();
                    return this;
                }

                public final int m25988a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int b = flatBufferBuilder.b(m25990a());
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.b(0, b);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            @Nullable
            public final /* synthetic */ DescriptionModel m25995a() {
                return m25991j();
            }

            @Nullable
            public final /* synthetic */ TitleModel m25998c() {
                return m25992k();
            }

            public ProfileWizardNuxModel() {
                super(3);
            }

            @Nullable
            private DescriptionModel m25991j() {
                this.f17804d = (DescriptionModel) super.a(this.f17804d, 0, DescriptionModel.class);
                return this.f17804d;
            }

            public final boolean m25997b() {
                a(0, 1);
                return this.f17805e;
            }

            @Nullable
            private TitleModel m25992k() {
                this.f17806f = (TitleModel) super.a(this.f17806f, 2, TitleModel.class);
                return this.f17806f;
            }

            public final int jK_() {
                return -1303636323;
            }

            public final GraphQLVisitableModel m25994a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m25991j() != null) {
                    DescriptionModel descriptionModel = (DescriptionModel) graphQLModelMutatingVisitor.b(m25991j());
                    if (m25991j() != descriptionModel) {
                        graphQLVisitableModel = (ProfileWizardNuxModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f17804d = descriptionModel;
                    }
                }
                if (m25992k() != null) {
                    TitleModel titleModel = (TitleModel) graphQLModelMutatingVisitor.b(m25992k());
                    if (m25992k() != titleModel) {
                        graphQLVisitableModel = (ProfileWizardNuxModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f17806f = titleModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m25993a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m25991j());
                int a2 = ModelHelper.a(flatBufferBuilder, m25992k());
                flatBufferBuilder.c(3);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.a(1, this.f17805e);
                flatBufferBuilder.b(2, a2);
                i();
                return flatBufferBuilder.d();
            }

            public final void m25996a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                super.a(mutableFlatBuffer, i, obj);
                this.f17805e = mutableFlatBuffer.a(i, 1);
            }
        }

        /* compiled from: delete_app_and_posts */
        public class Serializer extends JsonSerializer<TimelineNuxFieldsModel> {
            public final void m25999a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                TimelineNuxFieldsModel timelineNuxFieldsModel = (TimelineNuxFieldsModel) obj;
                if (timelineNuxFieldsModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(timelineNuxFieldsModel.m26001a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    timelineNuxFieldsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = timelineNuxFieldsModel.w_();
                int u_ = timelineNuxFieldsModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("profile_wizard_nux");
                    ProfileWizardNuxParser.m26114a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(TimelineNuxFieldsModel.class, new Serializer());
            }
        }

        public TimelineNuxFieldsModel() {
            super(1);
        }

        @Nullable
        private ProfileWizardNuxModel m26000a() {
            this.f17807d = (ProfileWizardNuxModel) super.a(this.f17807d, 0, ProfileWizardNuxModel.class);
            return this.f17807d;
        }

        public final int jK_() {
            return -1732764110;
        }

        public final GraphQLVisitableModel m26002a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m26000a() != null) {
                ProfileWizardNuxModel profileWizardNuxModel = (ProfileWizardNuxModel) graphQLModelMutatingVisitor.b(m26000a());
                if (m26000a() != profileWizardNuxModel) {
                    graphQLVisitableModel = (TimelineNuxFieldsModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f17807d = profileWizardNuxModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m26001a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m26000a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 149485733)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: delete_app_and_posts */
    public final class TimelineRefresherFieldsModel extends BaseModel implements GraphQLVisitableModel, TimelineRefresherFields {
        @Nullable
        private ProfileWizardRefresherModel f17810d;

        /* compiled from: delete_app_and_posts */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(TimelineRefresherFieldsModel.class, new Deserializer());
            }

            public Object m26003a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = TimelineRefresherFieldsParser.m26120a(jsonParser);
                Object timelineRefresherFieldsModel = new TimelineRefresherFieldsModel();
                ((BaseModel) timelineRefresherFieldsModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (timelineRefresherFieldsModel instanceof Postprocessable) {
                    return ((Postprocessable) timelineRefresherFieldsModel).a();
                }
                return timelineRefresherFieldsModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1375098541)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: delete_app_and_posts */
        public final class ProfileWizardRefresherModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private StepsModel f17809d;

            /* compiled from: delete_app_and_posts */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(ProfileWizardRefresherModel.class, new Deserializer());
                }

                public Object m26004a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(ProfileWizardRefresherParser.m26118a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object profileWizardRefresherModel = new ProfileWizardRefresherModel();
                    ((BaseModel) profileWizardRefresherModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (profileWizardRefresherModel instanceof Postprocessable) {
                        return ((Postprocessable) profileWizardRefresherModel).a();
                    }
                    return profileWizardRefresherModel;
                }
            }

            /* compiled from: delete_app_and_posts */
            public class Serializer extends JsonSerializer<ProfileWizardRefresherModel> {
                public final void m26005a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    ProfileWizardRefresherModel profileWizardRefresherModel = (ProfileWizardRefresherModel) obj;
                    if (profileWizardRefresherModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(profileWizardRefresherModel.m26013a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        profileWizardRefresherModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    ProfileWizardRefresherParser.m26119a(profileWizardRefresherModel.w_(), profileWizardRefresherModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(ProfileWizardRefresherModel.class, new Serializer());
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = -1723990064)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: delete_app_and_posts */
            public final class StepsModel extends BaseModel implements GraphQLVisitableModel {
                private int f17808d;

                /* compiled from: delete_app_and_posts */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(StepsModel.class, new Deserializer());
                    }

                    public Object m26006a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(StepsParser.m26116a(jsonParser, flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                        Object stepsModel = new StepsModel();
                        ((BaseModel) stepsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                        if (stepsModel instanceof Postprocessable) {
                            return ((Postprocessable) stepsModel).a();
                        }
                        return stepsModel;
                    }
                }

                /* compiled from: delete_app_and_posts */
                public class Serializer extends JsonSerializer<StepsModel> {
                    public final void m26007a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        StepsModel stepsModel = (StepsModel) obj;
                        if (stepsModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(stepsModel.m26009a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            stepsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        StepsParser.m26117a(stepsModel.w_(), stepsModel.u_(), jsonGenerator);
                    }

                    static {
                        FbSerializerProvider.a(StepsModel.class, new Serializer());
                    }
                }

                public StepsModel() {
                    super(1);
                }

                public final int m26008a() {
                    a(0, 0);
                    return this.f17808d;
                }

                public final int jK_() {
                    return -368253327;
                }

                public final GraphQLVisitableModel m26010a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    h();
                    i();
                    return this;
                }

                public final int m26009a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.a(0, this.f17808d, 0);
                    i();
                    return flatBufferBuilder.d();
                }

                public final void m26011a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                    super.a(mutableFlatBuffer, i, obj);
                    this.f17808d = mutableFlatBuffer.a(i, 0, 0);
                }
            }

            @Nullable
            public final /* synthetic */ StepsModel m26015a() {
                return m26012j();
            }

            public ProfileWizardRefresherModel() {
                super(1);
            }

            @Nullable
            private StepsModel m26012j() {
                this.f17809d = (StepsModel) super.a(this.f17809d, 0, StepsModel.class);
                return this.f17809d;
            }

            public final int jK_() {
                return 2141145812;
            }

            public final GraphQLVisitableModel m26014a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m26012j() != null) {
                    StepsModel stepsModel = (StepsModel) graphQLModelMutatingVisitor.b(m26012j());
                    if (m26012j() != stepsModel) {
                        graphQLVisitableModel = (ProfileWizardRefresherModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f17809d = stepsModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m26013a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m26012j());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, a);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: delete_app_and_posts */
        public class Serializer extends JsonSerializer<TimelineRefresherFieldsModel> {
            public final void m26016a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                TimelineRefresherFieldsModel timelineRefresherFieldsModel = (TimelineRefresherFieldsModel) obj;
                if (timelineRefresherFieldsModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(timelineRefresherFieldsModel.m26018a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    timelineRefresherFieldsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = timelineRefresherFieldsModel.w_();
                int u_ = timelineRefresherFieldsModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("profile_wizard_refresher");
                    ProfileWizardRefresherParser.m26119a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(TimelineRefresherFieldsModel.class, new Serializer());
            }
        }

        public TimelineRefresherFieldsModel() {
            super(1);
        }

        @Nullable
        private ProfileWizardRefresherModel m26017a() {
            this.f17810d = (ProfileWizardRefresherModel) super.a(this.f17810d, 0, ProfileWizardRefresherModel.class);
            return this.f17810d;
        }

        public final int jK_() {
            return -1732764110;
        }

        public final GraphQLVisitableModel m26019a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m26017a() != null) {
                ProfileWizardRefresherModel profileWizardRefresherModel = (ProfileWizardRefresherModel) graphQLModelMutatingVisitor.b(m26017a());
                if (m26017a() != profileWizardRefresherModel) {
                    graphQLVisitableModel = (TimelineRefresherFieldsModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f17810d = profileWizardRefresherModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m26018a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m26017a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -1441295128)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: delete_app_and_posts */
    public final class UserTimelineSelfQueryFieldsModel extends BaseModel implements GraphQLVisitableModel, TimelineNuxFields, TimelineRefresherFields {
        @Nullable
        private TimelineHeaderUserFieldsModel f17811d;
        @Nullable
        private String f17812e;
        @Nullable
        private ProfileWizardNuxModel f17813f;
        @Nullable
        private ProfileWizardRefresherModel f17814g;

        /* compiled from: delete_app_and_posts */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(UserTimelineSelfQueryFieldsModel.class, new Deserializer());
            }

            public Object m26020a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = UserTimelineSelfQueryFieldsParser.m26121a(jsonParser);
                Object userTimelineSelfQueryFieldsModel = new UserTimelineSelfQueryFieldsModel();
                ((BaseModel) userTimelineSelfQueryFieldsModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (userTimelineSelfQueryFieldsModel instanceof Postprocessable) {
                    return ((Postprocessable) userTimelineSelfQueryFieldsModel).a();
                }
                return userTimelineSelfQueryFieldsModel;
            }
        }

        /* compiled from: delete_app_and_posts */
        public class Serializer extends JsonSerializer<UserTimelineSelfQueryFieldsModel> {
            public final void m26021a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                UserTimelineSelfQueryFieldsModel userTimelineSelfQueryFieldsModel = (UserTimelineSelfQueryFieldsModel) obj;
                if (userTimelineSelfQueryFieldsModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(userTimelineSelfQueryFieldsModel.m26025a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    userTimelineSelfQueryFieldsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = userTimelineSelfQueryFieldsModel.w_();
                int u_ = userTimelineSelfQueryFieldsModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("actor");
                    TimelineHeaderUserFieldsParser.m26108a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                if (mutableFlatBuffer.g(u_, 1) != 0) {
                    jsonGenerator.a("currently_processing_profile_video_content_id");
                    jsonGenerator.b(mutableFlatBuffer.c(u_, 1));
                }
                g = mutableFlatBuffer.g(u_, 2);
                if (g != 0) {
                    jsonGenerator.a("profile_wizard_nux");
                    ProfileWizardNuxParser.m26114a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                g = mutableFlatBuffer.g(u_, 3);
                if (g != 0) {
                    jsonGenerator.a("profile_wizard_refresher");
                    ProfileWizardRefresherParser.m26119a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(UserTimelineSelfQueryFieldsModel.class, new Serializer());
            }
        }

        @Nullable
        public final /* synthetic */ TimelineHeaderUserFieldsModel m26027a() {
            return m26022j();
        }

        @Nullable
        public final /* synthetic */ ProfileWizardNuxModel m26029c() {
            return m26023k();
        }

        @Nullable
        public final /* synthetic */ ProfileWizardRefresherModel m26030d() {
            return m26024l();
        }

        public UserTimelineSelfQueryFieldsModel() {
            super(4);
        }

        @Nullable
        private TimelineHeaderUserFieldsModel m26022j() {
            this.f17811d = (TimelineHeaderUserFieldsModel) super.a(this.f17811d, 0, TimelineHeaderUserFieldsModel.class);
            return this.f17811d;
        }

        @Nullable
        public final String m26028b() {
            this.f17812e = super.a(this.f17812e, 1);
            return this.f17812e;
        }

        @Nullable
        private ProfileWizardNuxModel m26023k() {
            this.f17813f = (ProfileWizardNuxModel) super.a(this.f17813f, 2, ProfileWizardNuxModel.class);
            return this.f17813f;
        }

        @Nullable
        private ProfileWizardRefresherModel m26024l() {
            this.f17814g = (ProfileWizardRefresherModel) super.a(this.f17814g, 3, ProfileWizardRefresherModel.class);
            return this.f17814g;
        }

        public final int jK_() {
            return -1732764110;
        }

        public final GraphQLVisitableModel m26026a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m26022j() != null) {
                TimelineHeaderUserFieldsModel timelineHeaderUserFieldsModel = (TimelineHeaderUserFieldsModel) graphQLModelMutatingVisitor.b(m26022j());
                if (m26022j() != timelineHeaderUserFieldsModel) {
                    graphQLVisitableModel = (UserTimelineSelfQueryFieldsModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f17811d = timelineHeaderUserFieldsModel;
                }
            }
            if (m26023k() != null) {
                ProfileWizardNuxModel profileWizardNuxModel = (ProfileWizardNuxModel) graphQLModelMutatingVisitor.b(m26023k());
                if (m26023k() != profileWizardNuxModel) {
                    graphQLVisitableModel = (UserTimelineSelfQueryFieldsModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f17813f = profileWizardNuxModel;
                }
            }
            if (m26024l() != null) {
                ProfileWizardRefresherModel profileWizardRefresherModel = (ProfileWizardRefresherModel) graphQLModelMutatingVisitor.b(m26024l());
                if (m26024l() != profileWizardRefresherModel) {
                    graphQLVisitableModel = (UserTimelineSelfQueryFieldsModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f17814g = profileWizardRefresherModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m26025a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m26022j());
            int b = flatBufferBuilder.b(m26028b());
            int a2 = ModelHelper.a(flatBufferBuilder, m26023k());
            int a3 = ModelHelper.a(flatBufferBuilder, m26024l());
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
    @ModelWithFlatBufferFormatHash(a = 650290854)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: delete_app_and_posts */
    public final class ViewerTopFriendsQueryModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private FollowedProfilesModel f17818d;

        /* compiled from: delete_app_and_posts */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(ViewerTopFriendsQueryModel.class, new Deserializer());
            }

            public Object m26031a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = ViewerTopFriendsQueryParser.m26126a(jsonParser);
                Object viewerTopFriendsQueryModel = new ViewerTopFriendsQueryModel();
                ((BaseModel) viewerTopFriendsQueryModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (viewerTopFriendsQueryModel instanceof Postprocessable) {
                    return ((Postprocessable) viewerTopFriendsQueryModel).a();
                }
                return viewerTopFriendsQueryModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 667924406)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: delete_app_and_posts */
        public final class FollowedProfilesModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private List<NodesModel> f17817d;

            /* compiled from: delete_app_and_posts */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(FollowedProfilesModel.class, new Deserializer());
                }

                public Object m26032a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(FollowedProfilesParser.m26124a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object followedProfilesModel = new FollowedProfilesModel();
                    ((BaseModel) followedProfilesModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (followedProfilesModel instanceof Postprocessable) {
                        return ((Postprocessable) followedProfilesModel).a();
                    }
                    return followedProfilesModel;
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = -1787905591)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: delete_app_and_posts */
            public final class NodesModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
                @Nullable
                private GraphQLObjectType f17815d;
                @Nullable
                private String f17816e;

                /* compiled from: delete_app_and_posts */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(NodesModel.class, new Deserializer());
                    }

                    public Object m26033a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(NodesParser.m26123b(jsonParser, flatBufferBuilder));
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

                /* compiled from: delete_app_and_posts */
                public class Serializer extends JsonSerializer<NodesModel> {
                    public final void m26034a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        NodesModel nodesModel = (NodesModel) obj;
                        if (nodesModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(nodesModel.m26036a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            nodesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        NodesParser.m26122a(nodesModel.w_(), nodesModel.u_(), jsonGenerator);
                    }

                    static {
                        FbSerializerProvider.a(NodesModel.class, new Serializer());
                    }
                }

                public NodesModel() {
                    super(2);
                }

                public final void m26039a(String str, ConsistencyTuple consistencyTuple) {
                    consistencyTuple.a();
                }

                public final void m26040a(String str, Object obj, boolean z) {
                }

                @Nullable
                private GraphQLObjectType m26035j() {
                    if (this.b != null && this.f17815d == null) {
                        this.f17815d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
                    }
                    return this.f17815d;
                }

                @Nullable
                public final String m26041b() {
                    this.f17816e = super.a(this.f17816e, 1);
                    return this.f17816e;
                }

                @Nullable
                public final String m26038a() {
                    return m26041b();
                }

                public final int jK_() {
                    return 1355227529;
                }

                public final GraphQLVisitableModel m26037a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    h();
                    i();
                    return this;
                }

                public final int m26036a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int a = ModelHelper.a(flatBufferBuilder, m26035j());
                    int b = flatBufferBuilder.b(m26041b());
                    flatBufferBuilder.c(2);
                    flatBufferBuilder.b(0, a);
                    flatBufferBuilder.b(1, b);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            /* compiled from: delete_app_and_posts */
            public class Serializer extends JsonSerializer<FollowedProfilesModel> {
                public final void m26042a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    FollowedProfilesModel followedProfilesModel = (FollowedProfilesModel) obj;
                    if (followedProfilesModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(followedProfilesModel.m26043a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        followedProfilesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    FollowedProfilesParser.m26125a(followedProfilesModel.w_(), followedProfilesModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(FollowedProfilesModel.class, new Serializer());
                }
            }

            public FollowedProfilesModel() {
                super(1);
            }

            @Nonnull
            public final ImmutableList<NodesModel> m26045a() {
                this.f17817d = super.a(this.f17817d, 0, NodesModel.class);
                return (ImmutableList) this.f17817d;
            }

            public final int jK_() {
                return -989905224;
            }

            public final GraphQLVisitableModel m26044a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m26045a() != null) {
                    Builder a = ModelHelper.a(m26045a(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        graphQLVisitableModel = (FollowedProfilesModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f17817d = a.b();
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m26043a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m26045a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, a);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: delete_app_and_posts */
        public class Serializer extends JsonSerializer<ViewerTopFriendsQueryModel> {
            public final void m26046a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                ViewerTopFriendsQueryModel viewerTopFriendsQueryModel = (ViewerTopFriendsQueryModel) obj;
                if (viewerTopFriendsQueryModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(viewerTopFriendsQueryModel.m26047a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    viewerTopFriendsQueryModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = viewerTopFriendsQueryModel.w_();
                int u_ = viewerTopFriendsQueryModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("followed_profiles");
                    FollowedProfilesParser.m26125a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(ViewerTopFriendsQueryModel.class, new Serializer());
            }
        }

        public ViewerTopFriendsQueryModel() {
            super(1);
        }

        @Nullable
        public final FollowedProfilesModel m26049a() {
            this.f17818d = (FollowedProfilesModel) super.a(this.f17818d, 0, FollowedProfilesModel.class);
            return this.f17818d;
        }

        public final int jK_() {
            return -1732764110;
        }

        public final GraphQLVisitableModel m26048a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m26049a() != null) {
                FollowedProfilesModel followedProfilesModel = (FollowedProfilesModel) graphQLModelMutatingVisitor.b(m26049a());
                if (m26049a() != followedProfilesModel) {
                    graphQLVisitableModel = (ViewerTopFriendsQueryModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f17818d = followedProfilesModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m26047a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m26049a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }
}
