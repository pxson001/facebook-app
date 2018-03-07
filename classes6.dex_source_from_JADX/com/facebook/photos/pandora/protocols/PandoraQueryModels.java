package com.facebook.photos.pandora.protocols;

import com.facebook.api.graphql.feedback.FeedbackDefaultsGraphQLInterfaces.BaseFeedbackFields.ViewerActsAsPage;
import com.facebook.api.graphql.feedback.FeedbackDefaultsGraphQLInterfaces.SimpleFeedFeedback;
import com.facebook.api.graphql.feedback.FeedbackDefaultsGraphQLModels.BaseFeedbackFieldsModel.ViewerActsAsPageModel;
import com.facebook.api.graphql.feedback.FeedbackDefaultsGraphQLModels.FeedbackRealTimeActivityInfoFieldsModel.RealTimeActivityInfoModel;
import com.facebook.api.graphql.feedback.FeedbackDefaultsGraphQLModels.SimpleFeedFeedbackModel.LikersModel;
import com.facebook.api.graphql.feedback.FeedbackDefaultsGraphQLModels.SimpleFeedFeedbackModel.ResharesModel;
import com.facebook.api.graphql.feedback.FeedbackDefaultsGraphQLModels.SimpleFeedFeedbackModel.TopLevelCommentsModel;
import com.facebook.api.graphql.reactions.ReactionsGraphQLModels.ReactionsCountFieldsModel.TopReactionsModel;
import com.facebook.api.graphql.reactions.ReactionsGraphQLModels.SimpleReactionsFeedbackFieldsModel.ReactorsModel;
import com.facebook.api.graphql.reactions.ReactionsGraphQLModels.ViewerReactionsFeedbackFieldsModel.SupportedReactionsModel;
import com.facebook.api.graphql.reactions.ReactionsGraphQLModels.ViewerReactionsSocialFeedbackFieldsModel.ImportantReactorsModel;
import com.facebook.api.graphql.reactions.ReactionsGraphQLModels.ViewerReactionsSocialFeedbackFieldsModel.ViewerActsAsPersonModel;
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
import com.facebook.graphql.enums.GraphQLStoryAttachmentStyle;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.modelutil.SerializerHelpers;
import com.facebook.graphql.querybuilder.common.CommonGraphQL2Interfaces.DefaultVect2Fields;
import com.facebook.graphql.querybuilder.common.CommonGraphQL2Models.DefaultPageInfoFieldsModel;
import com.facebook.graphql.querybuilder.common.CommonGraphQL2Models.DefaultVect2FieldsModel;
import com.facebook.graphql.querybuilder.common.CommonGraphQLInterfaces.DefaultFeedbackFields;
import com.facebook.graphql.querybuilder.common.CommonGraphQLInterfaces.DefaultImageFields;
import com.facebook.graphql.querybuilder.common.CommonGraphQLModels.DefaultFeedbackFieldsModel;
import com.facebook.graphql.querybuilder.common.CommonGraphQLModels.DefaultImageFieldsModel;
import com.facebook.graphql.visitor.ConsistencyTuple;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLPersistableNode;
import com.facebook.graphql.visitor.GraphQLVisitableConsistentModel;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.facebook.photos.pandora.protocols.PandoraQueryInterfaces.PandoraMediaImageWithFeedbackFields;
import com.facebook.photos.pandora.protocols.PandoraQueryParsers.PandoraAlbumQueryParser;
import com.facebook.photos.pandora.protocols.PandoraQueryParsers.PandoraAlbumQueryParser.MediaParser;
import com.facebook.photos.pandora.protocols.PandoraQueryParsers.PandoraAlbumQueryParser.PhotoItemsParser;
import com.facebook.photos.pandora.protocols.PandoraQueryParsers.PandoraCampaignMediasetQueryParser;
import com.facebook.photos.pandora.protocols.PandoraQueryParsers.PandoraCampaignMediasetQueryParser.MediaSetParser;
import com.facebook.photos.pandora.protocols.PandoraQueryParsers.PandoraFaceAlertsQueryParser;
import com.facebook.photos.pandora.protocols.PandoraQueryParsers.PandoraFaceAlertsQueryParser.ViewerTagSuggestionsMediasetParser;
import com.facebook.photos.pandora.protocols.PandoraQueryParsers.PandoraMediaImageWithFeedbackFieldsParser;
import com.facebook.photos.pandora.protocols.PandoraQueryParsers.PandoraMediaParser;
import com.facebook.photos.pandora.protocols.PandoraQueryParsers.PandoraMediaParser.CreationStoryParser;
import com.facebook.photos.pandora.protocols.PandoraQueryParsers.PandoraMediaParser.CreationStoryParser.ActorsParser;
import com.facebook.photos.pandora.protocols.PandoraQueryParsers.PandoraMediaParser.CreationStoryParser.AttachmentsParser;
import com.facebook.photos.pandora.protocols.PandoraQueryParsers.PandoraMediaParser.CreationStoryParser.AttachmentsParser.SourceParser;
import com.facebook.photos.pandora.protocols.PandoraQueryParsers.PandoraMediaParser.CreationStoryParser.AttachmentsParser.TargetParser;
import com.facebook.photos.pandora.protocols.PandoraQueryParsers.PandoraMediaParser.CreationStoryParser.AttachmentsParser.TargetParser.ApplicationParser;
import com.facebook.photos.pandora.protocols.PandoraQueryParsers.PandoraMediaParser.CreationStoryParser.ShareableParser;
import com.facebook.photos.pandora.protocols.PandoraQueryParsers.PandoraMediasetQueryParser;
import com.facebook.photos.pandora.protocols.PandoraQueryParsers.PandoraProfileSuggestedPhotoQueryParser;
import com.facebook.photos.pandora.protocols.PandoraQueryParsers.PandoraProfileSuggestedPhotoQueryParser.ProfileWizardRefresherParser;
import com.facebook.photos.pandora.protocols.PandoraQueryParsers.PandoraProfileSuggestedPhotoQueryParser.ProfileWizardRefresherParser.ProfilePictureSuggestionsParser;
import com.facebook.photos.pandora.protocols.PandoraQueryParsers.PandoraQueryFeedbackParser;
import com.facebook.photos.pandora.protocols.PandoraQueryParsers.PandoraQueryFeedbackParser.ViewerDoesNotLikeSentenceParser;
import com.facebook.photos.pandora.protocols.PandoraQueryParsers.PandoraQueryFeedbackParser.ViewerLikesSentenceParser;
import com.facebook.photos.pandora.protocols.PandoraQueryParsers.PandoraTaggedMediaCountQueryParser;
import com.facebook.photos.pandora.protocols.PandoraQueryParsers.PandoraTaggedMediaCountQueryParser.TaggedMediasetParser;
import com.facebook.photos.pandora.protocols.PandoraQueryParsers.PandoraTaggedMediasetQueryParser;
import com.facebook.photos.pandora.protocols.PandoraQueryParsers.PandoraUploadedMediaCountQueryParser;
import com.facebook.photos.pandora.protocols.PandoraQueryParsers.PandoraUploadedMediaCountQueryParser.UploadedMediasetParser;
import com.facebook.photos.pandora.protocols.PandoraQueryParsers.PandoraUploadedMediasetQueryParser;
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

/* compiled from: has_umg */
public class PandoraQueryModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 1222798935)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: has_umg */
    public final class PandoraAlbumQueryModel extends BaseModel implements GraphQLVisitableConsistentModel {
        @Nullable
        private GraphQLObjectType f13098d;
        @Nullable
        private MediaModel f13099e;
        @Nullable
        private PhotoItemsModel f13100f;

        /* compiled from: has_umg */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(PandoraAlbumQueryModel.class, new Deserializer());
            }

            public Object m20474a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = PandoraAlbumQueryParser.m20849a(jsonParser);
                Object pandoraAlbumQueryModel = new PandoraAlbumQueryModel();
                ((BaseModel) pandoraAlbumQueryModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (pandoraAlbumQueryModel instanceof Postprocessable) {
                    return ((Postprocessable) pandoraAlbumQueryModel).a();
                }
                return pandoraAlbumQueryModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1823215375)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: has_umg */
        public final class MediaModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private List<PandoraMediaModel> f13095d;
            @Nullable
            private DefaultPageInfoFieldsModel f13096e;

            /* compiled from: has_umg */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(MediaModel.class, new Deserializer());
                }

                public Object m20475a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(MediaParser.m20845a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object mediaModel = new MediaModel();
                    ((BaseModel) mediaModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (mediaModel instanceof Postprocessable) {
                        return ((Postprocessable) mediaModel).a();
                    }
                    return mediaModel;
                }
            }

            /* compiled from: has_umg */
            public class Serializer extends JsonSerializer<MediaModel> {
                public final void m20476a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    MediaModel mediaModel = (MediaModel) obj;
                    if (mediaModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(mediaModel.m20477a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mediaModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    MediaParser.m20846a(mediaModel.w_(), mediaModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(MediaModel.class, new Serializer());
                }
            }

            public MediaModel() {
                super(2);
            }

            @Nonnull
            public final ImmutableList<PandoraMediaModel> m20479a() {
                this.f13095d = super.a(this.f13095d, 0, PandoraMediaModel.class);
                return (ImmutableList) this.f13095d;
            }

            @Nullable
            public final DefaultPageInfoFieldsModel m20480j() {
                this.f13096e = (DefaultPageInfoFieldsModel) super.a(this.f13096e, 1, DefaultPageInfoFieldsModel.class);
                return this.f13096e;
            }

            public final int jK_() {
                return 747633668;
            }

            public final GraphQLVisitableModel m20478a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel;
                DefaultPageInfoFieldsModel defaultPageInfoFieldsModel;
                h();
                if (m20479a() != null) {
                    Builder a = ModelHelper.a(m20479a(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        MediaModel mediaModel = (MediaModel) ModelHelper.a(null, this);
                        mediaModel.f13095d = a.b();
                        graphQLVisitableModel = mediaModel;
                        if (m20480j() != null) {
                            defaultPageInfoFieldsModel = (DefaultPageInfoFieldsModel) graphQLModelMutatingVisitor.b(m20480j());
                            if (m20480j() != defaultPageInfoFieldsModel) {
                                graphQLVisitableModel = (MediaModel) ModelHelper.a(graphQLVisitableModel, this);
                                graphQLVisitableModel.f13096e = defaultPageInfoFieldsModel;
                            }
                        }
                        i();
                        return graphQLVisitableModel != null ? this : graphQLVisitableModel;
                    }
                }
                graphQLVisitableModel = null;
                if (m20480j() != null) {
                    defaultPageInfoFieldsModel = (DefaultPageInfoFieldsModel) graphQLModelMutatingVisitor.b(m20480j());
                    if (m20480j() != defaultPageInfoFieldsModel) {
                        graphQLVisitableModel = (MediaModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f13096e = defaultPageInfoFieldsModel;
                    }
                }
                i();
                if (graphQLVisitableModel != null) {
                }
            }

            public final int m20477a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m20479a());
                int a2 = ModelHelper.a(flatBufferBuilder, m20480j());
                flatBufferBuilder.c(2);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.b(1, a2);
                i();
                return flatBufferBuilder.d();
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1723990064)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: has_umg */
        public final class PhotoItemsModel extends BaseModel implements GraphQLVisitableModel {
            private int f13097d;

            /* compiled from: has_umg */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(PhotoItemsModel.class, new Deserializer());
                }

                public Object m20481a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(PhotoItemsParser.m20847a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object photoItemsModel = new PhotoItemsModel();
                    ((BaseModel) photoItemsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (photoItemsModel instanceof Postprocessable) {
                        return ((Postprocessable) photoItemsModel).a();
                    }
                    return photoItemsModel;
                }
            }

            /* compiled from: has_umg */
            public class Serializer extends JsonSerializer<PhotoItemsModel> {
                public final void m20482a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    PhotoItemsModel photoItemsModel = (PhotoItemsModel) obj;
                    if (photoItemsModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(photoItemsModel.m20483a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        photoItemsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    PhotoItemsParser.m20848a(photoItemsModel.w_(), photoItemsModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(PhotoItemsModel.class, new Serializer());
                }
            }

            public PhotoItemsModel() {
                super(1);
            }

            public final int jK_() {
                return 747633668;
            }

            public final GraphQLVisitableModel m20484a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m20483a(FlatBufferBuilder flatBufferBuilder) {
                h();
                flatBufferBuilder.c(1);
                flatBufferBuilder.a(0, this.f13097d, 0);
                i();
                return flatBufferBuilder.d();
            }

            public final void m20485a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                super.a(mutableFlatBuffer, i, obj);
                this.f13097d = mutableFlatBuffer.a(i, 0, 0);
            }
        }

        /* compiled from: has_umg */
        public class Serializer extends JsonSerializer<PandoraAlbumQueryModel> {
            public final void m20486a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                PandoraAlbumQueryModel pandoraAlbumQueryModel = (PandoraAlbumQueryModel) obj;
                if (pandoraAlbumQueryModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(pandoraAlbumQueryModel.m20489a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    pandoraAlbumQueryModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = pandoraAlbumQueryModel.w_();
                int u_ = pandoraAlbumQueryModel.u_();
                jsonGenerator.f();
                if (mutableFlatBuffer.g(u_, 0) != 0) {
                    jsonGenerator.a("__type__");
                    SerializerHelpers.b(mutableFlatBuffer, u_, 0, jsonGenerator);
                }
                int g = mutableFlatBuffer.g(u_, 1);
                if (g != 0) {
                    jsonGenerator.a("media");
                    MediaParser.m20846a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                g = mutableFlatBuffer.g(u_, 2);
                if (g != 0) {
                    jsonGenerator.a("photo_items");
                    PhotoItemsParser.m20848a(mutableFlatBuffer, g, jsonGenerator);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(PandoraAlbumQueryModel.class, new Serializer());
            }
        }

        public PandoraAlbumQueryModel() {
            super(3);
        }

        public final void m20492a(String str, ConsistencyTuple consistencyTuple) {
            consistencyTuple.a();
        }

        public final void m20493a(String str, Object obj, boolean z) {
        }

        @Nullable
        private GraphQLObjectType m20487j() {
            if (this.b != null && this.f13098d == null) {
                this.f13098d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
            }
            return this.f13098d;
        }

        @Nullable
        public final MediaModel m20491a() {
            this.f13099e = (MediaModel) super.a(this.f13099e, 1, MediaModel.class);
            return this.f13099e;
        }

        @Nullable
        private PhotoItemsModel m20488k() {
            this.f13100f = (PhotoItemsModel) super.a(this.f13100f, 2, PhotoItemsModel.class);
            return this.f13100f;
        }

        public final int jK_() {
            return 2433570;
        }

        public final GraphQLVisitableModel m20490a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m20491a() != null) {
                MediaModel mediaModel = (MediaModel) graphQLModelMutatingVisitor.b(m20491a());
                if (m20491a() != mediaModel) {
                    graphQLVisitableModel = (PandoraAlbumQueryModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f13099e = mediaModel;
                }
            }
            if (m20488k() != null) {
                PhotoItemsModel photoItemsModel = (PhotoItemsModel) graphQLModelMutatingVisitor.b(m20488k());
                if (m20488k() != photoItemsModel) {
                    graphQLVisitableModel = (PandoraAlbumQueryModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f13100f = photoItemsModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m20489a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m20487j());
            int a2 = ModelHelper.a(flatBufferBuilder, m20491a());
            int a3 = ModelHelper.a(flatBufferBuilder, m20488k());
            flatBufferBuilder.c(3);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, a2);
            flatBufferBuilder.b(2, a3);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 1710827191)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: has_umg */
    public final class PandoraCampaignMediasetQueryModel extends BaseModel implements GraphQLVisitableConsistentModel {
        @Nullable
        private GraphQLObjectType f13105d;
        @Nullable
        private MediaSetModel f13106e;

        /* compiled from: has_umg */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(PandoraCampaignMediasetQueryModel.class, new Deserializer());
            }

            public Object m20494a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = PandoraCampaignMediasetQueryParser.m20854a(jsonParser);
                Object pandoraCampaignMediasetQueryModel = new PandoraCampaignMediasetQueryModel();
                ((BaseModel) pandoraCampaignMediasetQueryModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (pandoraCampaignMediasetQueryModel instanceof Postprocessable) {
                    return ((Postprocessable) pandoraCampaignMediasetQueryModel).a();
                }
                return pandoraCampaignMediasetQueryModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 2107484743)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: has_umg */
        public final class MediaSetModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private GraphQLObjectType f13103d;
            @Nullable
            private MediaModel f13104e;

            /* compiled from: has_umg */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(MediaSetModel.class, new Deserializer());
                }

                public Object m20495a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(MediaSetParser.m20852a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object mediaSetModel = new MediaSetModel();
                    ((BaseModel) mediaSetModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (mediaSetModel instanceof Postprocessable) {
                        return ((Postprocessable) mediaSetModel).a();
                    }
                    return mediaSetModel;
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = -1823215375)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: has_umg */
            public final class MediaModel extends BaseModel implements GraphQLVisitableModel {
                @Nullable
                private List<PandoraMediaModel> f13101d;
                @Nullable
                private DefaultPageInfoFieldsModel f13102e;

                /* compiled from: has_umg */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(MediaModel.class, new Deserializer());
                    }

                    public Object m20496a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(MediaSetParser.MediaParser.m20850a(jsonParser, flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                        Object mediaModel = new MediaModel();
                        ((BaseModel) mediaModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                        if (mediaModel instanceof Postprocessable) {
                            return ((Postprocessable) mediaModel).a();
                        }
                        return mediaModel;
                    }
                }

                /* compiled from: has_umg */
                public class Serializer extends JsonSerializer<MediaModel> {
                    public final void m20497a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        MediaModel mediaModel = (MediaModel) obj;
                        if (mediaModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(mediaModel.m20498a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            mediaModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        MediaSetParser.MediaParser.m20851a(mediaModel.w_(), mediaModel.u_(), jsonGenerator, serializerProvider);
                    }

                    static {
                        FbSerializerProvider.a(MediaModel.class, new Serializer());
                    }
                }

                public MediaModel() {
                    super(2);
                }

                @Nonnull
                public final ImmutableList<PandoraMediaModel> m20500a() {
                    this.f13101d = super.a(this.f13101d, 0, PandoraMediaModel.class);
                    return (ImmutableList) this.f13101d;
                }

                @Nullable
                public final DefaultPageInfoFieldsModel m20501j() {
                    this.f13102e = (DefaultPageInfoFieldsModel) super.a(this.f13102e, 1, DefaultPageInfoFieldsModel.class);
                    return this.f13102e;
                }

                public final int jK_() {
                    return 747633668;
                }

                public final GraphQLVisitableModel m20499a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    GraphQLVisitableModel graphQLVisitableModel;
                    DefaultPageInfoFieldsModel defaultPageInfoFieldsModel;
                    h();
                    if (m20500a() != null) {
                        Builder a = ModelHelper.a(m20500a(), graphQLModelMutatingVisitor);
                        if (a != null) {
                            MediaModel mediaModel = (MediaModel) ModelHelper.a(null, this);
                            mediaModel.f13101d = a.b();
                            graphQLVisitableModel = mediaModel;
                            if (m20501j() != null) {
                                defaultPageInfoFieldsModel = (DefaultPageInfoFieldsModel) graphQLModelMutatingVisitor.b(m20501j());
                                if (m20501j() != defaultPageInfoFieldsModel) {
                                    graphQLVisitableModel = (MediaModel) ModelHelper.a(graphQLVisitableModel, this);
                                    graphQLVisitableModel.f13102e = defaultPageInfoFieldsModel;
                                }
                            }
                            i();
                            return graphQLVisitableModel != null ? this : graphQLVisitableModel;
                        }
                    }
                    graphQLVisitableModel = null;
                    if (m20501j() != null) {
                        defaultPageInfoFieldsModel = (DefaultPageInfoFieldsModel) graphQLModelMutatingVisitor.b(m20501j());
                        if (m20501j() != defaultPageInfoFieldsModel) {
                            graphQLVisitableModel = (MediaModel) ModelHelper.a(graphQLVisitableModel, this);
                            graphQLVisitableModel.f13102e = defaultPageInfoFieldsModel;
                        }
                    }
                    i();
                    if (graphQLVisitableModel != null) {
                    }
                }

                public final int m20498a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int a = ModelHelper.a(flatBufferBuilder, m20500a());
                    int a2 = ModelHelper.a(flatBufferBuilder, m20501j());
                    flatBufferBuilder.c(2);
                    flatBufferBuilder.b(0, a);
                    flatBufferBuilder.b(1, a2);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            /* compiled from: has_umg */
            public class Serializer extends JsonSerializer<MediaSetModel> {
                public final void m20502a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    MediaSetModel mediaSetModel = (MediaSetModel) obj;
                    if (mediaSetModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(mediaSetModel.m20504a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mediaSetModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    MediaSetParser.m20853a(mediaSetModel.w_(), mediaSetModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(MediaSetModel.class, new Serializer());
                }
            }

            public MediaSetModel() {
                super(2);
            }

            @Nullable
            private GraphQLObjectType m20503j() {
                if (this.b != null && this.f13103d == null) {
                    this.f13103d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
                }
                return this.f13103d;
            }

            @Nullable
            public final MediaModel m20506a() {
                this.f13104e = (MediaModel) super.a(this.f13104e, 1, MediaModel.class);
                return this.f13104e;
            }

            public final int jK_() {
                return -836141570;
            }

            public final GraphQLVisitableModel m20505a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m20506a() != null) {
                    MediaModel mediaModel = (MediaModel) graphQLModelMutatingVisitor.b(m20506a());
                    if (m20506a() != mediaModel) {
                        graphQLVisitableModel = (MediaSetModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f13104e = mediaModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m20504a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m20503j());
                int a2 = ModelHelper.a(flatBufferBuilder, m20506a());
                flatBufferBuilder.c(2);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.b(1, a2);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: has_umg */
        public class Serializer extends JsonSerializer<PandoraCampaignMediasetQueryModel> {
            public final void m20507a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                PandoraCampaignMediasetQueryModel pandoraCampaignMediasetQueryModel = (PandoraCampaignMediasetQueryModel) obj;
                if (pandoraCampaignMediasetQueryModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(pandoraCampaignMediasetQueryModel.m20509a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    pandoraCampaignMediasetQueryModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = pandoraCampaignMediasetQueryModel.w_();
                int u_ = pandoraCampaignMediasetQueryModel.u_();
                jsonGenerator.f();
                if (mutableFlatBuffer.g(u_, 0) != 0) {
                    jsonGenerator.a("__type__");
                    SerializerHelpers.b(mutableFlatBuffer, u_, 0, jsonGenerator);
                }
                int g = mutableFlatBuffer.g(u_, 1);
                if (g != 0) {
                    jsonGenerator.a("media_set");
                    MediaSetParser.m20853a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(PandoraCampaignMediasetQueryModel.class, new Serializer());
            }
        }

        public PandoraCampaignMediasetQueryModel() {
            super(2);
        }

        public final void m20512a(String str, ConsistencyTuple consistencyTuple) {
            consistencyTuple.a();
        }

        public final void m20513a(String str, Object obj, boolean z) {
        }

        @Nullable
        private GraphQLObjectType m20508j() {
            if (this.b != null && this.f13105d == null) {
                this.f13105d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
            }
            return this.f13105d;
        }

        @Nullable
        public final MediaSetModel m20511a() {
            this.f13106e = (MediaSetModel) super.a(this.f13106e, 1, MediaSetModel.class);
            return this.f13106e;
        }

        public final int jK_() {
            return 2433570;
        }

        public final GraphQLVisitableModel m20510a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m20511a() != null) {
                MediaSetModel mediaSetModel = (MediaSetModel) graphQLModelMutatingVisitor.b(m20511a());
                if (m20511a() != mediaSetModel) {
                    graphQLVisitableModel = (PandoraCampaignMediasetQueryModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f13106e = mediaSetModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m20509a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m20508j());
            int a2 = ModelHelper.a(flatBufferBuilder, m20511a());
            flatBufferBuilder.c(2);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, a2);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 1469906473)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: has_umg */
    public final class PandoraFaceAlertsQueryModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private ViewerTagSuggestionsMediasetModel f13111d;

        /* compiled from: has_umg */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(PandoraFaceAlertsQueryModel.class, new Deserializer());
            }

            public Object m20514a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = PandoraFaceAlertsQueryParser.m20859a(jsonParser);
                Object pandoraFaceAlertsQueryModel = new PandoraFaceAlertsQueryModel();
                ((BaseModel) pandoraFaceAlertsQueryModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (pandoraFaceAlertsQueryModel instanceof Postprocessable) {
                    return ((Postprocessable) pandoraFaceAlertsQueryModel).a();
                }
                return pandoraFaceAlertsQueryModel;
            }
        }

        /* compiled from: has_umg */
        public class Serializer extends JsonSerializer<PandoraFaceAlertsQueryModel> {
            public final void m20515a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                PandoraFaceAlertsQueryModel pandoraFaceAlertsQueryModel = (PandoraFaceAlertsQueryModel) obj;
                if (pandoraFaceAlertsQueryModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(pandoraFaceAlertsQueryModel.m20529a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    pandoraFaceAlertsQueryModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = pandoraFaceAlertsQueryModel.w_();
                int u_ = pandoraFaceAlertsQueryModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("viewer_tag_suggestions_mediaset");
                    ViewerTagSuggestionsMediasetParser.m20858a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(PandoraFaceAlertsQueryModel.class, new Serializer());
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 957468153)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: has_umg */
        public final class ViewerTagSuggestionsMediasetModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private GraphQLObjectType f13109d;
            @Nullable
            private MediaModel f13110e;

            /* compiled from: has_umg */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(ViewerTagSuggestionsMediasetModel.class, new Deserializer());
                }

                public Object m20516a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(ViewerTagSuggestionsMediasetParser.m20857a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object viewerTagSuggestionsMediasetModel = new ViewerTagSuggestionsMediasetModel();
                    ((BaseModel) viewerTagSuggestionsMediasetModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (viewerTagSuggestionsMediasetModel instanceof Postprocessable) {
                        return ((Postprocessable) viewerTagSuggestionsMediasetModel).a();
                    }
                    return viewerTagSuggestionsMediasetModel;
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = -1823215375)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: has_umg */
            public final class MediaModel extends BaseModel implements GraphQLVisitableModel {
                @Nullable
                private List<PandoraMediaModel> f13107d;
                @Nullable
                private DefaultPageInfoFieldsModel f13108e;

                /* compiled from: has_umg */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(MediaModel.class, new Deserializer());
                    }

                    public Object m20517a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(ViewerTagSuggestionsMediasetParser.MediaParser.m20855a(jsonParser, flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                        Object mediaModel = new MediaModel();
                        ((BaseModel) mediaModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                        if (mediaModel instanceof Postprocessable) {
                            return ((Postprocessable) mediaModel).a();
                        }
                        return mediaModel;
                    }
                }

                /* compiled from: has_umg */
                public class Serializer extends JsonSerializer<MediaModel> {
                    public final void m20518a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        MediaModel mediaModel = (MediaModel) obj;
                        if (mediaModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(mediaModel.m20521a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            mediaModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        ViewerTagSuggestionsMediasetParser.MediaParser.m20856a(mediaModel.w_(), mediaModel.u_(), jsonGenerator, serializerProvider);
                    }

                    static {
                        FbSerializerProvider.a(MediaModel.class, new Serializer());
                    }
                }

                public MediaModel() {
                    super(2);
                }

                @Nonnull
                private ImmutableList<PandoraMediaModel> m20519a() {
                    this.f13107d = super.a(this.f13107d, 0, PandoraMediaModel.class);
                    return (ImmutableList) this.f13107d;
                }

                @Nullable
                private DefaultPageInfoFieldsModel m20520j() {
                    this.f13108e = (DefaultPageInfoFieldsModel) super.a(this.f13108e, 1, DefaultPageInfoFieldsModel.class);
                    return this.f13108e;
                }

                public final int jK_() {
                    return 747633668;
                }

                public final GraphQLVisitableModel m20522a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    GraphQLVisitableModel graphQLVisitableModel;
                    DefaultPageInfoFieldsModel defaultPageInfoFieldsModel;
                    h();
                    if (m20519a() != null) {
                        Builder a = ModelHelper.a(m20519a(), graphQLModelMutatingVisitor);
                        if (a != null) {
                            MediaModel mediaModel = (MediaModel) ModelHelper.a(null, this);
                            mediaModel.f13107d = a.b();
                            graphQLVisitableModel = mediaModel;
                            if (m20520j() != null) {
                                defaultPageInfoFieldsModel = (DefaultPageInfoFieldsModel) graphQLModelMutatingVisitor.b(m20520j());
                                if (m20520j() != defaultPageInfoFieldsModel) {
                                    graphQLVisitableModel = (MediaModel) ModelHelper.a(graphQLVisitableModel, this);
                                    graphQLVisitableModel.f13108e = defaultPageInfoFieldsModel;
                                }
                            }
                            i();
                            return graphQLVisitableModel != null ? this : graphQLVisitableModel;
                        }
                    }
                    graphQLVisitableModel = null;
                    if (m20520j() != null) {
                        defaultPageInfoFieldsModel = (DefaultPageInfoFieldsModel) graphQLModelMutatingVisitor.b(m20520j());
                        if (m20520j() != defaultPageInfoFieldsModel) {
                            graphQLVisitableModel = (MediaModel) ModelHelper.a(graphQLVisitableModel, this);
                            graphQLVisitableModel.f13108e = defaultPageInfoFieldsModel;
                        }
                    }
                    i();
                    if (graphQLVisitableModel != null) {
                    }
                }

                public final int m20521a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int a = ModelHelper.a(flatBufferBuilder, m20519a());
                    int a2 = ModelHelper.a(flatBufferBuilder, m20520j());
                    flatBufferBuilder.c(2);
                    flatBufferBuilder.b(0, a);
                    flatBufferBuilder.b(1, a2);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            /* compiled from: has_umg */
            public class Serializer extends JsonSerializer<ViewerTagSuggestionsMediasetModel> {
                public final void m20523a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    ViewerTagSuggestionsMediasetModel viewerTagSuggestionsMediasetModel = (ViewerTagSuggestionsMediasetModel) obj;
                    if (viewerTagSuggestionsMediasetModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(viewerTagSuggestionsMediasetModel.m20526a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        viewerTagSuggestionsMediasetModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    ViewerTagSuggestionsMediasetParser.m20858a(viewerTagSuggestionsMediasetModel.w_(), viewerTagSuggestionsMediasetModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(ViewerTagSuggestionsMediasetModel.class, new Serializer());
                }
            }

            public ViewerTagSuggestionsMediasetModel() {
                super(2);
            }

            @Nullable
            private GraphQLObjectType m20524a() {
                if (this.b != null && this.f13109d == null) {
                    this.f13109d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
                }
                return this.f13109d;
            }

            @Nullable
            private MediaModel m20525j() {
                this.f13110e = (MediaModel) super.a(this.f13110e, 1, MediaModel.class);
                return this.f13110e;
            }

            public final int jK_() {
                return -836141570;
            }

            public final GraphQLVisitableModel m20527a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m20525j() != null) {
                    MediaModel mediaModel = (MediaModel) graphQLModelMutatingVisitor.b(m20525j());
                    if (m20525j() != mediaModel) {
                        graphQLVisitableModel = (ViewerTagSuggestionsMediasetModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f13110e = mediaModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m20526a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m20524a());
                int a2 = ModelHelper.a(flatBufferBuilder, m20525j());
                flatBufferBuilder.c(2);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.b(1, a2);
                i();
                return flatBufferBuilder.d();
            }
        }

        public PandoraFaceAlertsQueryModel() {
            super(1);
        }

        @Nullable
        private ViewerTagSuggestionsMediasetModel m20528a() {
            this.f13111d = (ViewerTagSuggestionsMediasetModel) super.a(this.f13111d, 0, ViewerTagSuggestionsMediasetModel.class);
            return this.f13111d;
        }

        public final int jK_() {
            return -1732764110;
        }

        public final GraphQLVisitableModel m20530a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m20528a() != null) {
                ViewerTagSuggestionsMediasetModel viewerTagSuggestionsMediasetModel = (ViewerTagSuggestionsMediasetModel) graphQLModelMutatingVisitor.b(m20528a());
                if (m20528a() != viewerTagSuggestionsMediasetModel) {
                    graphQLVisitableModel = (PandoraFaceAlertsQueryModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f13111d = viewerTagSuggestionsMediasetModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m20529a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m20528a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 2004793511)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: has_umg */
    public final class PandoraMediaImageWithFeedbackFieldsModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel, PandoraMediaImageWithFeedbackFields {
        @Nullable
        private GraphQLObjectType f13112d;
        @Nullable
        private DefaultFeedbackFieldsModel f13113e;
        @Nullable
        private DefaultVect2FieldsModel f13114f;
        @Nullable
        private String f13115g;
        @Nullable
        private DefaultImageFieldsModel f13116h;
        @Nullable
        private DefaultImageFieldsModel f13117i;
        @Nullable
        private DefaultImageFieldsModel f13118j;
        @Nullable
        private DefaultImageFieldsModel f13119k;
        @Nullable
        private DefaultImageFieldsModel f13120l;
        @Nullable
        private DefaultImageFieldsModel f13121m;
        @Nullable
        private DefaultImageFieldsModel f13122n;
        @Nullable
        private DefaultImageFieldsModel f13123o;
        @Nullable
        private DefaultImageFieldsModel f13124p;
        @Nullable
        private DefaultImageFieldsModel f13125q;
        @Nullable
        private DefaultImageFieldsModel f13126r;
        @Nullable
        private DefaultImageFieldsModel f13127s;

        /* compiled from: has_umg */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(PandoraMediaImageWithFeedbackFieldsModel.class, new Deserializer());
            }

            public Object m20531a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(PandoraMediaImageWithFeedbackFieldsParser.m20860b(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object pandoraMediaImageWithFeedbackFieldsModel = new PandoraMediaImageWithFeedbackFieldsModel();
                ((BaseModel) pandoraMediaImageWithFeedbackFieldsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (pandoraMediaImageWithFeedbackFieldsModel instanceof Postprocessable) {
                    return ((Postprocessable) pandoraMediaImageWithFeedbackFieldsModel).a();
                }
                return pandoraMediaImageWithFeedbackFieldsModel;
            }
        }

        /* compiled from: has_umg */
        public class Serializer extends JsonSerializer<PandoraMediaImageWithFeedbackFieldsModel> {
            public final void m20532a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                PandoraMediaImageWithFeedbackFieldsModel pandoraMediaImageWithFeedbackFieldsModel = (PandoraMediaImageWithFeedbackFieldsModel) obj;
                if (pandoraMediaImageWithFeedbackFieldsModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(pandoraMediaImageWithFeedbackFieldsModel.m20547a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    pandoraMediaImageWithFeedbackFieldsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                PandoraMediaImageWithFeedbackFieldsParser.m20861b(pandoraMediaImageWithFeedbackFieldsModel.w_(), pandoraMediaImageWithFeedbackFieldsModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(PandoraMediaImageWithFeedbackFieldsModel.class, new Serializer());
            }
        }

        @Nullable
        public final /* synthetic */ DefaultImageFields bc_() {
            return m20544t();
        }

        @Nullable
        public final /* synthetic */ DefaultImageFields bd_() {
            return m20543p();
        }

        @Nullable
        public final /* synthetic */ DefaultImageFields be_() {
            return m20541m();
        }

        @Nullable
        public final /* synthetic */ DefaultVect2Fields mo1108c() {
            return m20540k();
        }

        @Nullable
        public final /* synthetic */ DefaultImageFields mo1110g() {
            return m20542o();
        }

        @Nullable
        public final /* synthetic */ DefaultFeedbackFields mo1111l() {
            return m20539j();
        }

        @Nullable
        public final /* synthetic */ DefaultImageFields mo1112n() {
            return m20545w();
        }

        @Nullable
        public final /* synthetic */ DefaultImageFields mo1113q() {
            return m20546x();
        }

        @Nullable
        public final /* synthetic */ DefaultImageFields mo1114r() {
            return m20533A();
        }

        @Nullable
        public final /* synthetic */ DefaultImageFields mo1115s() {
            return m20534B();
        }

        @Nullable
        public final /* synthetic */ DefaultImageFields mo1116u() {
            return m20535C();
        }

        @Nullable
        public final /* synthetic */ DefaultImageFields mo1117v() {
            return m20536D();
        }

        @Nullable
        public final /* synthetic */ DefaultImageFields mo1118y() {
            return m20537E();
        }

        @Nullable
        public final /* synthetic */ DefaultImageFields mo1119z() {
            return m20538F();
        }

        public PandoraMediaImageWithFeedbackFieldsModel() {
            super(16);
        }

        @Nullable
        public final GraphQLObjectType mo1104b() {
            if (this.b != null && this.f13112d == null) {
                this.f13112d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
            }
            return this.f13112d;
        }

        @Nullable
        private DefaultFeedbackFieldsModel m20539j() {
            this.f13113e = (DefaultFeedbackFieldsModel) super.a(this.f13113e, 1, DefaultFeedbackFieldsModel.class);
            return this.f13113e;
        }

        @Nullable
        private DefaultVect2FieldsModel m20540k() {
            this.f13114f = (DefaultVect2FieldsModel) super.a(this.f13114f, 2, DefaultVect2FieldsModel.class);
            return this.f13114f;
        }

        @Nullable
        public final String mo1109d() {
            this.f13115g = super.a(this.f13115g, 3);
            return this.f13115g;
        }

        @Nullable
        private DefaultImageFieldsModel m20541m() {
            this.f13116h = (DefaultImageFieldsModel) super.a(this.f13116h, 4, DefaultImageFieldsModel.class);
            return this.f13116h;
        }

        @Nullable
        private DefaultImageFieldsModel m20542o() {
            this.f13117i = (DefaultImageFieldsModel) super.a(this.f13117i, 5, DefaultImageFieldsModel.class);
            return this.f13117i;
        }

        @Nullable
        private DefaultImageFieldsModel m20543p() {
            this.f13118j = (DefaultImageFieldsModel) super.a(this.f13118j, 6, DefaultImageFieldsModel.class);
            return this.f13118j;
        }

        @Nullable
        private DefaultImageFieldsModel m20544t() {
            this.f13119k = (DefaultImageFieldsModel) super.a(this.f13119k, 7, DefaultImageFieldsModel.class);
            return this.f13119k;
        }

        @Nullable
        private DefaultImageFieldsModel m20545w() {
            this.f13120l = (DefaultImageFieldsModel) super.a(this.f13120l, 8, DefaultImageFieldsModel.class);
            return this.f13120l;
        }

        @Nullable
        private DefaultImageFieldsModel m20546x() {
            this.f13121m = (DefaultImageFieldsModel) super.a(this.f13121m, 9, DefaultImageFieldsModel.class);
            return this.f13121m;
        }

        @Nullable
        private DefaultImageFieldsModel m20533A() {
            this.f13122n = (DefaultImageFieldsModel) super.a(this.f13122n, 10, DefaultImageFieldsModel.class);
            return this.f13122n;
        }

        @Nullable
        private DefaultImageFieldsModel m20534B() {
            this.f13123o = (DefaultImageFieldsModel) super.a(this.f13123o, 11, DefaultImageFieldsModel.class);
            return this.f13123o;
        }

        @Nullable
        private DefaultImageFieldsModel m20535C() {
            this.f13124p = (DefaultImageFieldsModel) super.a(this.f13124p, 12, DefaultImageFieldsModel.class);
            return this.f13124p;
        }

        @Nullable
        private DefaultImageFieldsModel m20536D() {
            this.f13125q = (DefaultImageFieldsModel) super.a(this.f13125q, 13, DefaultImageFieldsModel.class);
            return this.f13125q;
        }

        @Nullable
        private DefaultImageFieldsModel m20537E() {
            this.f13126r = (DefaultImageFieldsModel) super.a(this.f13126r, 14, DefaultImageFieldsModel.class);
            return this.f13126r;
        }

        @Nullable
        private DefaultImageFieldsModel m20538F() {
            this.f13127s = (DefaultImageFieldsModel) super.a(this.f13127s, 15, DefaultImageFieldsModel.class);
            return this.f13127s;
        }

        @Nullable
        public final String m20549a() {
            return mo1109d();
        }

        public final int jK_() {
            return 74219460;
        }

        public final GraphQLVisitableModel m20548a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            DefaultImageFieldsModel defaultImageFieldsModel;
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m20539j() != null) {
                DefaultFeedbackFieldsModel defaultFeedbackFieldsModel = (DefaultFeedbackFieldsModel) graphQLModelMutatingVisitor.b(m20539j());
                if (m20539j() != defaultFeedbackFieldsModel) {
                    graphQLVisitableModel = (PandoraMediaImageWithFeedbackFieldsModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f13113e = defaultFeedbackFieldsModel;
                }
            }
            if (m20540k() != null) {
                DefaultVect2FieldsModel defaultVect2FieldsModel = (DefaultVect2FieldsModel) graphQLModelMutatingVisitor.b(m20540k());
                if (m20540k() != defaultVect2FieldsModel) {
                    graphQLVisitableModel = (PandoraMediaImageWithFeedbackFieldsModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f13114f = defaultVect2FieldsModel;
                }
            }
            if (m20541m() != null) {
                defaultImageFieldsModel = (DefaultImageFieldsModel) graphQLModelMutatingVisitor.b(m20541m());
                if (m20541m() != defaultImageFieldsModel) {
                    graphQLVisitableModel = (PandoraMediaImageWithFeedbackFieldsModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f13116h = defaultImageFieldsModel;
                }
            }
            if (m20542o() != null) {
                defaultImageFieldsModel = (DefaultImageFieldsModel) graphQLModelMutatingVisitor.b(m20542o());
                if (m20542o() != defaultImageFieldsModel) {
                    graphQLVisitableModel = (PandoraMediaImageWithFeedbackFieldsModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f13117i = defaultImageFieldsModel;
                }
            }
            if (m20543p() != null) {
                defaultImageFieldsModel = (DefaultImageFieldsModel) graphQLModelMutatingVisitor.b(m20543p());
                if (m20543p() != defaultImageFieldsModel) {
                    graphQLVisitableModel = (PandoraMediaImageWithFeedbackFieldsModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f13118j = defaultImageFieldsModel;
                }
            }
            if (m20544t() != null) {
                defaultImageFieldsModel = (DefaultImageFieldsModel) graphQLModelMutatingVisitor.b(m20544t());
                if (m20544t() != defaultImageFieldsModel) {
                    graphQLVisitableModel = (PandoraMediaImageWithFeedbackFieldsModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f13119k = defaultImageFieldsModel;
                }
            }
            if (m20545w() != null) {
                defaultImageFieldsModel = (DefaultImageFieldsModel) graphQLModelMutatingVisitor.b(m20545w());
                if (m20545w() != defaultImageFieldsModel) {
                    graphQLVisitableModel = (PandoraMediaImageWithFeedbackFieldsModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f13120l = defaultImageFieldsModel;
                }
            }
            if (m20546x() != null) {
                defaultImageFieldsModel = (DefaultImageFieldsModel) graphQLModelMutatingVisitor.b(m20546x());
                if (m20546x() != defaultImageFieldsModel) {
                    graphQLVisitableModel = (PandoraMediaImageWithFeedbackFieldsModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f13121m = defaultImageFieldsModel;
                }
            }
            if (m20533A() != null) {
                defaultImageFieldsModel = (DefaultImageFieldsModel) graphQLModelMutatingVisitor.b(m20533A());
                if (m20533A() != defaultImageFieldsModel) {
                    graphQLVisitableModel = (PandoraMediaImageWithFeedbackFieldsModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f13122n = defaultImageFieldsModel;
                }
            }
            if (m20534B() != null) {
                defaultImageFieldsModel = (DefaultImageFieldsModel) graphQLModelMutatingVisitor.b(m20534B());
                if (m20534B() != defaultImageFieldsModel) {
                    graphQLVisitableModel = (PandoraMediaImageWithFeedbackFieldsModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f13123o = defaultImageFieldsModel;
                }
            }
            if (m20535C() != null) {
                defaultImageFieldsModel = (DefaultImageFieldsModel) graphQLModelMutatingVisitor.b(m20535C());
                if (m20535C() != defaultImageFieldsModel) {
                    graphQLVisitableModel = (PandoraMediaImageWithFeedbackFieldsModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f13124p = defaultImageFieldsModel;
                }
            }
            if (m20536D() != null) {
                defaultImageFieldsModel = (DefaultImageFieldsModel) graphQLModelMutatingVisitor.b(m20536D());
                if (m20536D() != defaultImageFieldsModel) {
                    graphQLVisitableModel = (PandoraMediaImageWithFeedbackFieldsModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f13125q = defaultImageFieldsModel;
                }
            }
            if (m20537E() != null) {
                defaultImageFieldsModel = (DefaultImageFieldsModel) graphQLModelMutatingVisitor.b(m20537E());
                if (m20537E() != defaultImageFieldsModel) {
                    graphQLVisitableModel = (PandoraMediaImageWithFeedbackFieldsModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f13126r = defaultImageFieldsModel;
                }
            }
            if (m20538F() != null) {
                defaultImageFieldsModel = (DefaultImageFieldsModel) graphQLModelMutatingVisitor.b(m20538F());
                if (m20538F() != defaultImageFieldsModel) {
                    graphQLVisitableModel = (PandoraMediaImageWithFeedbackFieldsModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f13127s = defaultImageFieldsModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m20547a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, mo1104b());
            int a2 = ModelHelper.a(flatBufferBuilder, m20539j());
            int a3 = ModelHelper.a(flatBufferBuilder, m20540k());
            int b = flatBufferBuilder.b(mo1109d());
            int a4 = ModelHelper.a(flatBufferBuilder, m20541m());
            int a5 = ModelHelper.a(flatBufferBuilder, m20542o());
            int a6 = ModelHelper.a(flatBufferBuilder, m20543p());
            int a7 = ModelHelper.a(flatBufferBuilder, m20544t());
            int a8 = ModelHelper.a(flatBufferBuilder, m20545w());
            int a9 = ModelHelper.a(flatBufferBuilder, m20546x());
            int a10 = ModelHelper.a(flatBufferBuilder, m20533A());
            int a11 = ModelHelper.a(flatBufferBuilder, m20534B());
            int a12 = ModelHelper.a(flatBufferBuilder, m20535C());
            int a13 = ModelHelper.a(flatBufferBuilder, m20536D());
            int a14 = ModelHelper.a(flatBufferBuilder, m20537E());
            int a15 = ModelHelper.a(flatBufferBuilder, m20538F());
            flatBufferBuilder.c(16);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, a2);
            flatBufferBuilder.b(2, a3);
            flatBufferBuilder.b(3, b);
            flatBufferBuilder.b(4, a4);
            flatBufferBuilder.b(5, a5);
            flatBufferBuilder.b(6, a6);
            flatBufferBuilder.b(7, a7);
            flatBufferBuilder.b(8, a8);
            flatBufferBuilder.b(9, a9);
            flatBufferBuilder.b(10, a10);
            flatBufferBuilder.b(11, a11);
            flatBufferBuilder.b(12, a12);
            flatBufferBuilder.b(13, a13);
            flatBufferBuilder.b(14, a14);
            flatBufferBuilder.b(15, a15);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 266409043)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: has_umg */
    public final class PandoraMediaModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel, PandoraMediaImageWithFeedbackFields {
        @Nullable
        private DefaultImageFieldsModel f13154A;
        private int f13155B;
        @Nullable
        private GraphQLObjectType f13156d;
        @Nullable
        private String f13157e;
        @Nullable
        private CreationStoryModel f13158f;
        @Nullable
        private DefaultFeedbackFieldsModel f13159g;
        @Nullable
        private DefaultVect2FieldsModel f13160h;
        private int f13161i;
        @Nullable
        private String f13162j;
        @Nullable
        private DefaultImageFieldsModel f13163k;
        @Nullable
        private DefaultImageFieldsModel f13164l;
        @Nullable
        private DefaultImageFieldsModel f13165m;
        @Nullable
        private DefaultImageFieldsModel f13166n;
        @Nullable
        private DefaultImageFieldsModel f13167o;
        private boolean f13168p;
        private boolean f13169q;
        @Nullable
        private DefaultImageFieldsModel f13170r;
        @Nullable
        private DefaultImageFieldsModel f13171s;
        @Nullable
        private DefaultImageFieldsModel f13172t;
        private int f13173u;
        @Nullable
        private DefaultImageFieldsModel f13174v;
        @Nullable
        private DefaultImageFieldsModel f13175w;
        private int f13176x;
        @Nullable
        private String f13177y;
        @Nullable
        private DefaultImageFieldsModel f13178z;

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 1064090289)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: has_umg */
        public final class CreationStoryModel extends BaseModel implements GraphQLVisitableConsistentModel {
            @Nullable
            private List<ActorsModel> f13147d;
            @Nullable
            private List<AttachmentsModel> f13148e;
            @Nullable
            private String f13149f;
            private long f13150g;
            @Nullable
            private PandoraQueryFeedbackModel f13151h;
            @Nullable
            private ShareableModel f13152i;
            @Nullable
            private String f13153j;

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = 869696189)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: has_umg */
            public final class ActorsModel extends BaseModel implements GraphQLVisitableConsistentModel {
                @Nullable
                private GraphQLObjectType f13128d;
                private boolean f13129e;
                @Nullable
                private String f13130f;

                /* compiled from: has_umg */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(ActorsModel.class, new Deserializer());
                    }

                    public Object m20563a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(ActorsParser.m20864b(jsonParser, flatBufferBuilder));
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

                /* compiled from: has_umg */
                public class Serializer extends JsonSerializer<ActorsModel> {
                    public final void m20564a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        ActorsModel actorsModel = (ActorsModel) obj;
                        if (actorsModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(actorsModel.m20565a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            actorsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        ActorsParser.m20863a(actorsModel.w_(), actorsModel.u_(), jsonGenerator);
                    }

                    static {
                        FbSerializerProvider.a(ActorsModel.class, new Serializer());
                    }
                }

                public ActorsModel() {
                    super(3);
                }

                public final void m20569a(String str, ConsistencyTuple consistencyTuple) {
                    consistencyTuple.a();
                }

                public final void m20570a(String str, Object obj, boolean z) {
                }

                @Nullable
                public final GraphQLObjectType m20566a() {
                    if (this.b != null && this.f13128d == null) {
                        this.f13128d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
                    }
                    return this.f13128d;
                }

                public final boolean m20571b() {
                    a(0, 1);
                    return this.f13129e;
                }

                @Nullable
                public final String m20572c() {
                    this.f13130f = super.a(this.f13130f, 2);
                    return this.f13130f;
                }

                public final int jK_() {
                    return 63093205;
                }

                public final GraphQLVisitableModel m20567a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    h();
                    i();
                    return this;
                }

                public final int m20565a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int a = ModelHelper.a(flatBufferBuilder, m20566a());
                    int b = flatBufferBuilder.b(m20572c());
                    flatBufferBuilder.c(3);
                    flatBufferBuilder.b(0, a);
                    flatBufferBuilder.a(1, this.f13129e);
                    flatBufferBuilder.b(2, b);
                    i();
                    return flatBufferBuilder.d();
                }

                public final void m20568a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                    super.a(mutableFlatBuffer, i, obj);
                    this.f13129e = mutableFlatBuffer.a(i, 1);
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = -204942698)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: has_umg */
            public final class AttachmentsModel extends BaseModel implements GraphQLVisitableModel {
                @Nullable
                private MediaModel f13139d;
                @Nullable
                private SourceModel f13140e;
                @Nullable
                private List<GraphQLStoryAttachmentStyle> f13141f;
                @Nullable
                private TargetModel f13142g;
                @Nullable
                private String f13143h;
                @Nullable
                private String f13144i;

                /* compiled from: has_umg */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(AttachmentsModel.class, new Deserializer());
                    }

                    public Object m20573a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(AttachmentsParser.m20874b(jsonParser, flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                        Object attachmentsModel = new AttachmentsModel();
                        ((BaseModel) attachmentsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                        if (attachmentsModel instanceof Postprocessable) {
                            return ((Postprocessable) attachmentsModel).a();
                        }
                        return attachmentsModel;
                    }
                }

                @JsonDeserialize(using = Deserializer.class)
                @ModelWithFlatBufferFormatHash(a = 1516699231)
                @JsonSerialize(using = Serializer.class)
                @FragmentModelWithoutBridge
                /* compiled from: has_umg */
                public final class MediaModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel {
                    @Nullable
                    private GraphQLObjectType f13131d;
                    @Nullable
                    private String f13132e;
                    @Nullable
                    private DefaultImageFieldsModel f13133f;

                    /* compiled from: has_umg */
                    public class Deserializer extends FbJsonDeserializer {
                        static {
                            GlobalAutoGenDeserializerCache.a(MediaModel.class, new Deserializer());
                        }

                        public Object m20574a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(AttachmentsParser.MediaParser.m20865a(jsonParser, flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            mutableFlatBuffer.a(4, Boolean.valueOf(true));
                            MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                            Object mediaModel = new MediaModel();
                            ((BaseModel) mediaModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                            if (mediaModel instanceof Postprocessable) {
                                return ((Postprocessable) mediaModel).a();
                            }
                            return mediaModel;
                        }
                    }

                    /* compiled from: has_umg */
                    public class Serializer extends JsonSerializer<MediaModel> {
                        public final void m20575a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                            MediaModel mediaModel = (MediaModel) obj;
                            if (mediaModel.w_() == null) {
                                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                flatBufferBuilder.d(mediaModel.m20577a(flatBufferBuilder));
                                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                wrap.position(0);
                                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                mediaModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                            }
                            AttachmentsParser.MediaParser.m20866a(mediaModel.w_(), mediaModel.u_(), jsonGenerator, serializerProvider);
                        }

                        static {
                            FbSerializerProvider.a(MediaModel.class, new Serializer());
                        }
                    }

                    @Nullable
                    public final /* synthetic */ DefaultImageFields m20582d() {
                        return m20576j();
                    }

                    public MediaModel() {
                        super(3);
                    }

                    @Nullable
                    public final GraphQLObjectType m20580b() {
                        if (this.b != null && this.f13131d == null) {
                            this.f13131d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
                        }
                        return this.f13131d;
                    }

                    @Nullable
                    public final String m20581c() {
                        this.f13132e = super.a(this.f13132e, 1);
                        return this.f13132e;
                    }

                    @Nullable
                    private DefaultImageFieldsModel m20576j() {
                        this.f13133f = (DefaultImageFieldsModel) super.a(this.f13133f, 2, DefaultImageFieldsModel.class);
                        return this.f13133f;
                    }

                    @Nullable
                    public final String m20579a() {
                        return m20581c();
                    }

                    public final int jK_() {
                        return 74219460;
                    }

                    public final GraphQLVisitableModel m20578a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                        GraphQLVisitableModel graphQLVisitableModel = null;
                        h();
                        if (m20576j() != null) {
                            DefaultImageFieldsModel defaultImageFieldsModel = (DefaultImageFieldsModel) graphQLModelMutatingVisitor.b(m20576j());
                            if (m20576j() != defaultImageFieldsModel) {
                                graphQLVisitableModel = (MediaModel) ModelHelper.a(null, this);
                                graphQLVisitableModel.f13133f = defaultImageFieldsModel;
                            }
                        }
                        i();
                        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                    }

                    public final int m20577a(FlatBufferBuilder flatBufferBuilder) {
                        h();
                        int a = ModelHelper.a(flatBufferBuilder, m20580b());
                        int b = flatBufferBuilder.b(m20581c());
                        int a2 = ModelHelper.a(flatBufferBuilder, m20576j());
                        flatBufferBuilder.c(3);
                        flatBufferBuilder.b(0, a);
                        flatBufferBuilder.b(1, b);
                        flatBufferBuilder.b(2, a2);
                        i();
                        return flatBufferBuilder.d();
                    }
                }

                /* compiled from: has_umg */
                public class Serializer extends JsonSerializer<AttachmentsModel> {
                    public final void m20583a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        AttachmentsModel attachmentsModel = (AttachmentsModel) obj;
                        if (attachmentsModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(attachmentsModel.m20608a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            attachmentsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        AttachmentsParser.m20875b(attachmentsModel.w_(), attachmentsModel.u_(), jsonGenerator, serializerProvider);
                    }

                    static {
                        FbSerializerProvider.a(AttachmentsModel.class, new Serializer());
                    }
                }

                @JsonDeserialize(using = Deserializer.class)
                @ModelWithFlatBufferFormatHash(a = -1352864475)
                @JsonSerialize(using = Serializer.class)
                @FragmentModelWithoutBridge
                /* compiled from: has_umg */
                public final class SourceModel extends BaseModel implements GraphQLVisitableModel {
                    @Nullable
                    private String f13134d;

                    /* compiled from: has_umg */
                    public class Deserializer extends FbJsonDeserializer {
                        static {
                            GlobalAutoGenDeserializerCache.a(SourceModel.class, new Deserializer());
                        }

                        public Object m20584a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(SourceParser.m20867a(jsonParser, flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            mutableFlatBuffer.a(4, Boolean.valueOf(true));
                            MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                            Object sourceModel = new SourceModel();
                            ((BaseModel) sourceModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                            if (sourceModel instanceof Postprocessable) {
                                return ((Postprocessable) sourceModel).a();
                            }
                            return sourceModel;
                        }
                    }

                    /* compiled from: has_umg */
                    public class Serializer extends JsonSerializer<SourceModel> {
                        public final void m20585a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                            SourceModel sourceModel = (SourceModel) obj;
                            if (sourceModel.w_() == null) {
                                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                flatBufferBuilder.d(sourceModel.m20586a(flatBufferBuilder));
                                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                wrap.position(0);
                                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                sourceModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                            }
                            SourceParser.m20868a(sourceModel.w_(), sourceModel.u_(), jsonGenerator);
                        }

                        static {
                            FbSerializerProvider.a(SourceModel.class, new Serializer());
                        }
                    }

                    public SourceModel() {
                        super(1);
                    }

                    @Nullable
                    public final String m20588a() {
                        this.f13134d = super.a(this.f13134d, 0);
                        return this.f13134d;
                    }

                    public final int jK_() {
                        return -1919764332;
                    }

                    public final GraphQLVisitableModel m20587a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                        h();
                        i();
                        return this;
                    }

                    public final int m20586a(FlatBufferBuilder flatBufferBuilder) {
                        h();
                        int b = flatBufferBuilder.b(m20588a());
                        flatBufferBuilder.c(1);
                        flatBufferBuilder.b(0, b);
                        i();
                        return flatBufferBuilder.d();
                    }
                }

                @JsonDeserialize(using = Deserializer.class)
                @ModelWithFlatBufferFormatHash(a = -1930545284)
                @JsonSerialize(using = Serializer.class)
                @FragmentModelWithoutBridge
                /* compiled from: has_umg */
                public final class TargetModel extends BaseModel implements GraphQLVisitableConsistentModel {
                    @Nullable
                    private GraphQLObjectType f13137d;
                    @Nullable
                    private ApplicationModel f13138e;

                    @JsonDeserialize(using = Deserializer.class)
                    @ModelWithFlatBufferFormatHash(a = -1185712657)
                    @JsonSerialize(using = Serializer.class)
                    @FragmentModelWithoutBridge
                    /* compiled from: has_umg */
                    public final class ApplicationModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel {
                        @Nullable
                        private String f13135d;
                        @Nullable
                        private String f13136e;

                        /* compiled from: has_umg */
                        public class Deserializer extends FbJsonDeserializer {
                            static {
                                GlobalAutoGenDeserializerCache.a(ApplicationModel.class, new Deserializer());
                            }

                            public Object m20589a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                flatBufferBuilder.d(ApplicationParser.m20869a(jsonParser, flatBufferBuilder));
                                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                wrap.position(0);
                                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                                Object applicationModel = new ApplicationModel();
                                ((BaseModel) applicationModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                                if (applicationModel instanceof Postprocessable) {
                                    return ((Postprocessable) applicationModel).a();
                                }
                                return applicationModel;
                            }
                        }

                        /* compiled from: has_umg */
                        public class Serializer extends JsonSerializer<ApplicationModel> {
                            public final void m20590a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                                ApplicationModel applicationModel = (ApplicationModel) obj;
                                if (applicationModel.w_() == null) {
                                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                    flatBufferBuilder.d(applicationModel.m20591a(flatBufferBuilder));
                                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                    wrap.position(0);
                                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                    applicationModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                                }
                                ApplicationParser.m20870a(applicationModel.w_(), applicationModel.u_(), jsonGenerator);
                            }

                            static {
                                FbSerializerProvider.a(ApplicationModel.class, new Serializer());
                            }
                        }

                        public ApplicationModel() {
                            super(2);
                        }

                        @Nullable
                        public final String m20594b() {
                            this.f13135d = super.a(this.f13135d, 0);
                            return this.f13135d;
                        }

                        @Nullable
                        public final String m20595c() {
                            this.f13136e = super.a(this.f13136e, 1);
                            return this.f13136e;
                        }

                        @Nullable
                        public final String m20593a() {
                            return m20594b();
                        }

                        public final int jK_() {
                            return -1072845520;
                        }

                        public final GraphQLVisitableModel m20592a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                            h();
                            i();
                            return this;
                        }

                        public final int m20591a(FlatBufferBuilder flatBufferBuilder) {
                            h();
                            int b = flatBufferBuilder.b(m20594b());
                            int b2 = flatBufferBuilder.b(m20595c());
                            flatBufferBuilder.c(2);
                            flatBufferBuilder.b(0, b);
                            flatBufferBuilder.b(1, b2);
                            i();
                            return flatBufferBuilder.d();
                        }
                    }

                    /* compiled from: has_umg */
                    public class Deserializer extends FbJsonDeserializer {
                        static {
                            GlobalAutoGenDeserializerCache.a(TargetModel.class, new Deserializer());
                        }

                        public Object m20596a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(TargetParser.m20871a(jsonParser, flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            mutableFlatBuffer.a(4, Boolean.valueOf(true));
                            MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                            Object targetModel = new TargetModel();
                            ((BaseModel) targetModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                            if (targetModel instanceof Postprocessable) {
                                return ((Postprocessable) targetModel).a();
                            }
                            return targetModel;
                        }
                    }

                    /* compiled from: has_umg */
                    public class Serializer extends JsonSerializer<TargetModel> {
                        public final void m20597a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                            TargetModel targetModel = (TargetModel) obj;
                            if (targetModel.w_() == null) {
                                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                flatBufferBuilder.d(targetModel.m20599a(flatBufferBuilder));
                                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                wrap.position(0);
                                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                targetModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                            }
                            TargetParser.m20872a(targetModel.w_(), targetModel.u_(), jsonGenerator, serializerProvider);
                        }

                        static {
                            FbSerializerProvider.a(TargetModel.class, new Serializer());
                        }
                    }

                    @Nullable
                    public final /* synthetic */ ApplicationModel m20604b() {
                        return m20598j();
                    }

                    public TargetModel() {
                        super(2);
                    }

                    public final void m20602a(String str, ConsistencyTuple consistencyTuple) {
                        consistencyTuple.a();
                    }

                    public final void m20603a(String str, Object obj, boolean z) {
                    }

                    @Nullable
                    public final GraphQLObjectType m20600a() {
                        if (this.b != null && this.f13137d == null) {
                            this.f13137d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
                        }
                        return this.f13137d;
                    }

                    @Nullable
                    private ApplicationModel m20598j() {
                        this.f13138e = (ApplicationModel) super.a(this.f13138e, 1, ApplicationModel.class);
                        return this.f13138e;
                    }

                    public final int jK_() {
                        return 2433570;
                    }

                    public final GraphQLVisitableModel m20601a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                        GraphQLVisitableModel graphQLVisitableModel = null;
                        h();
                        if (m20598j() != null) {
                            ApplicationModel applicationModel = (ApplicationModel) graphQLModelMutatingVisitor.b(m20598j());
                            if (m20598j() != applicationModel) {
                                graphQLVisitableModel = (TargetModel) ModelHelper.a(null, this);
                                graphQLVisitableModel.f13138e = applicationModel;
                            }
                        }
                        i();
                        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                    }

                    public final int m20599a(FlatBufferBuilder flatBufferBuilder) {
                        h();
                        int a = ModelHelper.a(flatBufferBuilder, m20600a());
                        int a2 = ModelHelper.a(flatBufferBuilder, m20598j());
                        flatBufferBuilder.c(2);
                        flatBufferBuilder.b(0, a);
                        flatBufferBuilder.b(1, a2);
                        i();
                        return flatBufferBuilder.d();
                    }
                }

                @Nullable
                public final /* synthetic */ MediaModel m20610a() {
                    return m20605j();
                }

                @Nullable
                public final /* synthetic */ SourceModel m20611b() {
                    return m20606k();
                }

                @Nullable
                public final /* synthetic */ TargetModel m20613d() {
                    return m20607l();
                }

                public AttachmentsModel() {
                    super(6);
                }

                @Nullable
                private MediaModel m20605j() {
                    this.f13139d = (MediaModel) super.a(this.f13139d, 0, MediaModel.class);
                    return this.f13139d;
                }

                @Nullable
                private SourceModel m20606k() {
                    this.f13140e = (SourceModel) super.a(this.f13140e, 1, SourceModel.class);
                    return this.f13140e;
                }

                @Nonnull
                public final ImmutableList<GraphQLStoryAttachmentStyle> m20612c() {
                    this.f13141f = super.c(this.f13141f, 2, GraphQLStoryAttachmentStyle.class);
                    return (ImmutableList) this.f13141f;
                }

                @Nullable
                private TargetModel m20607l() {
                    this.f13142g = (TargetModel) super.a(this.f13142g, 3, TargetModel.class);
                    return this.f13142g;
                }

                @Nullable
                public final String cO_() {
                    this.f13143h = super.a(this.f13143h, 4);
                    return this.f13143h;
                }

                @Nullable
                public final String m20614g() {
                    this.f13144i = super.a(this.f13144i, 5);
                    return this.f13144i;
                }

                public final int jK_() {
                    return -1267730472;
                }

                public final GraphQLVisitableModel m20609a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    GraphQLVisitableModel graphQLVisitableModel = null;
                    h();
                    if (m20605j() != null) {
                        MediaModel mediaModel = (MediaModel) graphQLModelMutatingVisitor.b(m20605j());
                        if (m20605j() != mediaModel) {
                            graphQLVisitableModel = (AttachmentsModel) ModelHelper.a(null, this);
                            graphQLVisitableModel.f13139d = mediaModel;
                        }
                    }
                    if (m20606k() != null) {
                        SourceModel sourceModel = (SourceModel) graphQLModelMutatingVisitor.b(m20606k());
                        if (m20606k() != sourceModel) {
                            graphQLVisitableModel = (AttachmentsModel) ModelHelper.a(graphQLVisitableModel, this);
                            graphQLVisitableModel.f13140e = sourceModel;
                        }
                    }
                    if (m20607l() != null) {
                        TargetModel targetModel = (TargetModel) graphQLModelMutatingVisitor.b(m20607l());
                        if (m20607l() != targetModel) {
                            graphQLVisitableModel = (AttachmentsModel) ModelHelper.a(graphQLVisitableModel, this);
                            graphQLVisitableModel.f13142g = targetModel;
                        }
                    }
                    i();
                    return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                }

                public final int m20608a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int a = ModelHelper.a(flatBufferBuilder, m20605j());
                    int a2 = ModelHelper.a(flatBufferBuilder, m20606k());
                    int d = flatBufferBuilder.d(m20612c());
                    int a3 = ModelHelper.a(flatBufferBuilder, m20607l());
                    int b = flatBufferBuilder.b(cO_());
                    int b2 = flatBufferBuilder.b(m20614g());
                    flatBufferBuilder.c(6);
                    flatBufferBuilder.b(0, a);
                    flatBufferBuilder.b(1, a2);
                    flatBufferBuilder.b(2, d);
                    flatBufferBuilder.b(3, a3);
                    flatBufferBuilder.b(4, b);
                    flatBufferBuilder.b(5, b2);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            /* compiled from: has_umg */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(CreationStoryModel.class, new Deserializer());
                }

                public Object m20615a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(CreationStoryParser.m20878a(jsonParser, flatBufferBuilder));
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

            /* compiled from: has_umg */
            public class Serializer extends JsonSerializer<CreationStoryModel> {
                public final void m20616a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    CreationStoryModel creationStoryModel = (CreationStoryModel) obj;
                    if (creationStoryModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(creationStoryModel.m20626a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        creationStoryModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    CreationStoryParser.m20879a(creationStoryModel.w_(), creationStoryModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(CreationStoryModel.class, new Serializer());
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = -1787905591)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: has_umg */
            public final class ShareableModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel {
                @Nullable
                private GraphQLObjectType f13145d;
                @Nullable
                private String f13146e;

                /* compiled from: has_umg */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(ShareableModel.class, new Deserializer());
                    }

                    public Object m20617a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(ShareableParser.m20876a(jsonParser, flatBufferBuilder));
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

                /* compiled from: has_umg */
                public class Serializer extends JsonSerializer<ShareableModel> {
                    public final void m20618a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        ShareableModel shareableModel = (ShareableModel) obj;
                        if (shareableModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(shareableModel.m20619a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            shareableModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        ShareableParser.m20877a(shareableModel.w_(), shareableModel.u_(), jsonGenerator);
                    }

                    static {
                        FbSerializerProvider.a(ShareableModel.class, new Serializer());
                    }
                }

                public ShareableModel() {
                    super(2);
                }

                @Nullable
                public final GraphQLObjectType m20622b() {
                    if (this.b != null && this.f13145d == null) {
                        this.f13145d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
                    }
                    return this.f13145d;
                }

                @Nullable
                public final String m20623c() {
                    this.f13146e = super.a(this.f13146e, 1);
                    return this.f13146e;
                }

                @Nullable
                public final String m20621a() {
                    return m20623c();
                }

                public final int jK_() {
                    return 2080559107;
                }

                public final GraphQLVisitableModel m20620a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    h();
                    i();
                    return this;
                }

                public final int m20619a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int a = ModelHelper.a(flatBufferBuilder, m20622b());
                    int b = flatBufferBuilder.b(m20623c());
                    flatBufferBuilder.c(2);
                    flatBufferBuilder.b(0, a);
                    flatBufferBuilder.b(1, b);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            @Nullable
            public final /* synthetic */ PandoraQueryFeedbackModel cN_() {
                return m20624j();
            }

            @Nullable
            public final /* synthetic */ ShareableModel m20635g() {
                return m20625k();
            }

            public CreationStoryModel() {
                super(7);
            }

            public final void m20630a(String str, ConsistencyTuple consistencyTuple) {
                consistencyTuple.a();
            }

            public final void m20631a(String str, Object obj, boolean z) {
            }

            @Nonnull
            public final ImmutableList<ActorsModel> m20628a() {
                this.f13147d = super.a(this.f13147d, 0, ActorsModel.class);
                return (ImmutableList) this.f13147d;
            }

            @Nonnull
            public final ImmutableList<AttachmentsModel> m20632b() {
                this.f13148e = super.a(this.f13148e, 1, AttachmentsModel.class);
                return (ImmutableList) this.f13148e;
            }

            @Nullable
            public final String m20633c() {
                this.f13149f = super.a(this.f13149f, 2);
                return this.f13149f;
            }

            public final long m20634d() {
                a(0, 3);
                return this.f13150g;
            }

            @Nullable
            private PandoraQueryFeedbackModel m20624j() {
                this.f13151h = (PandoraQueryFeedbackModel) super.a(this.f13151h, 4, PandoraQueryFeedbackModel.class);
                return this.f13151h;
            }

            @Nullable
            private ShareableModel m20625k() {
                this.f13152i = (ShareableModel) super.a(this.f13152i, 5, ShareableModel.class);
                return this.f13152i;
            }

            @Nullable
            public final String cM_() {
                this.f13153j = super.a(this.f13153j, 6);
                return this.f13153j;
            }

            public final int jK_() {
                return 80218325;
            }

            public final GraphQLVisitableModel m20627a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                Builder a;
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m20628a() != null) {
                    a = ModelHelper.a(m20628a(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        graphQLVisitableModel = (CreationStoryModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f13147d = a.b();
                    }
                }
                if (m20632b() != null) {
                    a = ModelHelper.a(m20632b(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        graphQLVisitableModel = (CreationStoryModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f13148e = a.b();
                    }
                }
                GraphQLVisitableModel graphQLVisitableModel2 = graphQLVisitableModel;
                if (m20624j() != null) {
                    PandoraQueryFeedbackModel pandoraQueryFeedbackModel = (PandoraQueryFeedbackModel) graphQLModelMutatingVisitor.b(m20624j());
                    if (m20624j() != pandoraQueryFeedbackModel) {
                        graphQLVisitableModel2 = (CreationStoryModel) ModelHelper.a(graphQLVisitableModel2, this);
                        graphQLVisitableModel2.f13151h = pandoraQueryFeedbackModel;
                    }
                }
                if (m20625k() != null) {
                    ShareableModel shareableModel = (ShareableModel) graphQLModelMutatingVisitor.b(m20625k());
                    if (m20625k() != shareableModel) {
                        graphQLVisitableModel2 = (CreationStoryModel) ModelHelper.a(graphQLVisitableModel2, this);
                        graphQLVisitableModel2.f13152i = shareableModel;
                    }
                }
                i();
                return graphQLVisitableModel2 == null ? this : graphQLVisitableModel2;
            }

            public final int m20626a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m20628a());
                int a2 = ModelHelper.a(flatBufferBuilder, m20632b());
                int b = flatBufferBuilder.b(m20633c());
                int a3 = ModelHelper.a(flatBufferBuilder, m20624j());
                int a4 = ModelHelper.a(flatBufferBuilder, m20625k());
                int b2 = flatBufferBuilder.b(cM_());
                flatBufferBuilder.c(7);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.b(1, a2);
                flatBufferBuilder.b(2, b);
                flatBufferBuilder.a(3, this.f13150g, 0);
                flatBufferBuilder.b(4, a3);
                flatBufferBuilder.b(5, a4);
                flatBufferBuilder.b(6, b2);
                i();
                return flatBufferBuilder.d();
            }

            public final void m20629a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                super.a(mutableFlatBuffer, i, obj);
                this.f13150g = mutableFlatBuffer.a(i, 3, 0);
            }
        }

        /* compiled from: has_umg */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(PandoraMediaModel.class, new Deserializer());
            }

            public Object m20636a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(PandoraMediaParser.m20882b(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object pandoraMediaModel = new PandoraMediaModel();
                ((BaseModel) pandoraMediaModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (pandoraMediaModel instanceof Postprocessable) {
                    return ((Postprocessable) pandoraMediaModel).a();
                }
                return pandoraMediaModel;
            }
        }

        /* compiled from: has_umg */
        public class Serializer extends JsonSerializer<PandoraMediaModel> {
            public final void m20637a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                PandoraMediaModel pandoraMediaModel = (PandoraMediaModel) obj;
                if (pandoraMediaModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(pandoraMediaModel.m20654a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    pandoraMediaModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                PandoraMediaParser.m20883b(pandoraMediaModel.w_(), pandoraMediaModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(PandoraMediaModel.class, new Serializer());
            }
        }

        @Nullable
        public final /* synthetic */ DefaultImageFields bc_() {
            return m20641N();
        }

        @Nullable
        public final /* synthetic */ DefaultImageFields bd_() {
            return m20640M();
        }

        @Nullable
        public final /* synthetic */ DefaultImageFields be_() {
            return m20647D();
        }

        @Nullable
        public final /* synthetic */ DefaultVect2Fields mo1108c() {
            return m20638K();
        }

        @Nullable
        public final /* synthetic */ DefaultImageFields mo1110g() {
            return m20639L();
        }

        @Nullable
        public final /* synthetic */ CreationStoryModel m20663k() {
            return m20645B();
        }

        @Nullable
        public final /* synthetic */ DefaultFeedbackFields mo1111l() {
            return m20646C();
        }

        @Nullable
        public final /* synthetic */ DefaultImageFields mo1112n() {
            return m20648E();
        }

        @Nullable
        public final /* synthetic */ DefaultImageFields mo1113q() {
            return m20649F();
        }

        @Nullable
        public final /* synthetic */ DefaultImageFields mo1114r() {
            return m20650G();
        }

        @Nullable
        public final /* synthetic */ DefaultImageFields mo1115s() {
            return m20651H();
        }

        @Nullable
        public final /* synthetic */ DefaultImageFields mo1116u() {
            return m20642O();
        }

        @Nullable
        public final /* synthetic */ DefaultImageFields mo1117v() {
            return m20643P();
        }

        @Nullable
        public final /* synthetic */ DefaultImageFields mo1118y() {
            return m20652I();
        }

        @Nullable
        public final /* synthetic */ DefaultImageFields mo1119z() {
            return m20653J();
        }

        public PandoraMediaModel() {
            super(25);
        }

        public PandoraMediaModel(MutableFlatBuffer mutableFlatBuffer) {
            super(25);
            a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
        }

        @Nullable
        public final GraphQLObjectType mo1104b() {
            if (this.b != null && this.f13156d == null) {
                this.f13156d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
            }
            return this.f13156d;
        }

        @Nullable
        public final String m20662j() {
            this.f13157e = super.a(this.f13157e, 1);
            return this.f13157e;
        }

        @Nullable
        public final CreationStoryModel m20645B() {
            this.f13158f = (CreationStoryModel) super.a(this.f13158f, 2, CreationStoryModel.class);
            return this.f13158f;
        }

        @Nullable
        public final DefaultFeedbackFieldsModel m20646C() {
            this.f13159g = (DefaultFeedbackFieldsModel) super.a(this.f13159g, 3, DefaultFeedbackFieldsModel.class);
            return this.f13159g;
        }

        @Nullable
        private DefaultVect2FieldsModel m20638K() {
            this.f13160h = (DefaultVect2FieldsModel) super.a(this.f13160h, 4, DefaultVect2FieldsModel.class);
            return this.f13160h;
        }

        public final int m20665m() {
            a(0, 5);
            return this.f13161i;
        }

        @Nullable
        public final String mo1109d() {
            this.f13162j = super.a(this.f13162j, 6);
            return this.f13162j;
        }

        @Nullable
        public final DefaultImageFieldsModel m20647D() {
            this.f13163k = (DefaultImageFieldsModel) super.a(this.f13163k, 7, DefaultImageFieldsModel.class);
            return this.f13163k;
        }

        @Nullable
        private DefaultImageFieldsModel m20639L() {
            this.f13164l = (DefaultImageFieldsModel) super.a(this.f13164l, 8, DefaultImageFieldsModel.class);
            return this.f13164l;
        }

        @Nullable
        private DefaultImageFieldsModel m20640M() {
            this.f13165m = (DefaultImageFieldsModel) super.a(this.f13165m, 9, DefaultImageFieldsModel.class);
            return this.f13165m;
        }

        @Nullable
        private DefaultImageFieldsModel m20641N() {
            this.f13166n = (DefaultImageFieldsModel) super.a(this.f13166n, 10, DefaultImageFieldsModel.class);
            return this.f13166n;
        }

        @Nullable
        public final DefaultImageFieldsModel m20648E() {
            this.f13167o = (DefaultImageFieldsModel) super.a(this.f13167o, 11, DefaultImageFieldsModel.class);
            return this.f13167o;
        }

        public final boolean m20667o() {
            a(1, 4);
            return this.f13168p;
        }

        public final boolean m20668p() {
            a(1, 5);
            return this.f13169q;
        }

        @Nullable
        public final DefaultImageFieldsModel m20649F() {
            this.f13170r = (DefaultImageFieldsModel) super.a(this.f13170r, 14, DefaultImageFieldsModel.class);
            return this.f13170r;
        }

        @Nullable
        public final DefaultImageFieldsModel m20650G() {
            this.f13171s = (DefaultImageFieldsModel) super.a(this.f13171s, 15, DefaultImageFieldsModel.class);
            return this.f13171s;
        }

        @Nullable
        public final DefaultImageFieldsModel m20651H() {
            this.f13172t = (DefaultImageFieldsModel) super.a(this.f13172t, 16, DefaultImageFieldsModel.class);
            return this.f13172t;
        }

        public final int m20672t() {
            a(2, 1);
            return this.f13173u;
        }

        @Nullable
        private DefaultImageFieldsModel m20642O() {
            this.f13174v = (DefaultImageFieldsModel) super.a(this.f13174v, 18, DefaultImageFieldsModel.class);
            return this.f13174v;
        }

        @Nullable
        private DefaultImageFieldsModel m20643P() {
            this.f13175w = (DefaultImageFieldsModel) super.a(this.f13175w, 19, DefaultImageFieldsModel.class);
            return this.f13175w;
        }

        public final int m20675w() {
            a(2, 4);
            return this.f13176x;
        }

        @Nullable
        public final String m20676x() {
            this.f13177y = super.a(this.f13177y, 21);
            return this.f13177y;
        }

        @Nullable
        public final DefaultImageFieldsModel m20652I() {
            this.f13178z = (DefaultImageFieldsModel) super.a(this.f13178z, 22, DefaultImageFieldsModel.class);
            return this.f13178z;
        }

        @Nullable
        public final DefaultImageFieldsModel m20653J() {
            this.f13154A = (DefaultImageFieldsModel) super.a(this.f13154A, 23, DefaultImageFieldsModel.class);
            return this.f13154A;
        }

        public final int m20644A() {
            a(3, 0);
            return this.f13155B;
        }

        @Nullable
        public final String m20656a() {
            return mo1109d();
        }

        public final int jK_() {
            return 74219460;
        }

        public final GraphQLVisitableModel m20655a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            DefaultImageFieldsModel defaultImageFieldsModel;
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m20645B() != null) {
                CreationStoryModel creationStoryModel = (CreationStoryModel) graphQLModelMutatingVisitor.b(m20645B());
                if (m20645B() != creationStoryModel) {
                    graphQLVisitableModel = (PandoraMediaModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f13158f = creationStoryModel;
                }
            }
            if (m20646C() != null) {
                DefaultFeedbackFieldsModel defaultFeedbackFieldsModel = (DefaultFeedbackFieldsModel) graphQLModelMutatingVisitor.b(m20646C());
                if (m20646C() != defaultFeedbackFieldsModel) {
                    graphQLVisitableModel = (PandoraMediaModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f13159g = defaultFeedbackFieldsModel;
                }
            }
            if (m20638K() != null) {
                DefaultVect2FieldsModel defaultVect2FieldsModel = (DefaultVect2FieldsModel) graphQLModelMutatingVisitor.b(m20638K());
                if (m20638K() != defaultVect2FieldsModel) {
                    graphQLVisitableModel = (PandoraMediaModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f13160h = defaultVect2FieldsModel;
                }
            }
            if (m20647D() != null) {
                defaultImageFieldsModel = (DefaultImageFieldsModel) graphQLModelMutatingVisitor.b(m20647D());
                if (m20647D() != defaultImageFieldsModel) {
                    graphQLVisitableModel = (PandoraMediaModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f13163k = defaultImageFieldsModel;
                }
            }
            if (m20639L() != null) {
                defaultImageFieldsModel = (DefaultImageFieldsModel) graphQLModelMutatingVisitor.b(m20639L());
                if (m20639L() != defaultImageFieldsModel) {
                    graphQLVisitableModel = (PandoraMediaModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f13164l = defaultImageFieldsModel;
                }
            }
            if (m20640M() != null) {
                defaultImageFieldsModel = (DefaultImageFieldsModel) graphQLModelMutatingVisitor.b(m20640M());
                if (m20640M() != defaultImageFieldsModel) {
                    graphQLVisitableModel = (PandoraMediaModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f13165m = defaultImageFieldsModel;
                }
            }
            if (m20641N() != null) {
                defaultImageFieldsModel = (DefaultImageFieldsModel) graphQLModelMutatingVisitor.b(m20641N());
                if (m20641N() != defaultImageFieldsModel) {
                    graphQLVisitableModel = (PandoraMediaModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f13166n = defaultImageFieldsModel;
                }
            }
            if (m20648E() != null) {
                defaultImageFieldsModel = (DefaultImageFieldsModel) graphQLModelMutatingVisitor.b(m20648E());
                if (m20648E() != defaultImageFieldsModel) {
                    graphQLVisitableModel = (PandoraMediaModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f13167o = defaultImageFieldsModel;
                }
            }
            if (m20649F() != null) {
                defaultImageFieldsModel = (DefaultImageFieldsModel) graphQLModelMutatingVisitor.b(m20649F());
                if (m20649F() != defaultImageFieldsModel) {
                    graphQLVisitableModel = (PandoraMediaModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f13170r = defaultImageFieldsModel;
                }
            }
            if (m20650G() != null) {
                defaultImageFieldsModel = (DefaultImageFieldsModel) graphQLModelMutatingVisitor.b(m20650G());
                if (m20650G() != defaultImageFieldsModel) {
                    graphQLVisitableModel = (PandoraMediaModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f13171s = defaultImageFieldsModel;
                }
            }
            if (m20651H() != null) {
                defaultImageFieldsModel = (DefaultImageFieldsModel) graphQLModelMutatingVisitor.b(m20651H());
                if (m20651H() != defaultImageFieldsModel) {
                    graphQLVisitableModel = (PandoraMediaModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f13172t = defaultImageFieldsModel;
                }
            }
            if (m20642O() != null) {
                defaultImageFieldsModel = (DefaultImageFieldsModel) graphQLModelMutatingVisitor.b(m20642O());
                if (m20642O() != defaultImageFieldsModel) {
                    graphQLVisitableModel = (PandoraMediaModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f13174v = defaultImageFieldsModel;
                }
            }
            if (m20643P() != null) {
                defaultImageFieldsModel = (DefaultImageFieldsModel) graphQLModelMutatingVisitor.b(m20643P());
                if (m20643P() != defaultImageFieldsModel) {
                    graphQLVisitableModel = (PandoraMediaModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f13175w = defaultImageFieldsModel;
                }
            }
            if (m20652I() != null) {
                defaultImageFieldsModel = (DefaultImageFieldsModel) graphQLModelMutatingVisitor.b(m20652I());
                if (m20652I() != defaultImageFieldsModel) {
                    graphQLVisitableModel = (PandoraMediaModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f13178z = defaultImageFieldsModel;
                }
            }
            if (m20653J() != null) {
                defaultImageFieldsModel = (DefaultImageFieldsModel) graphQLModelMutatingVisitor.b(m20653J());
                if (m20653J() != defaultImageFieldsModel) {
                    graphQLVisitableModel = (PandoraMediaModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f13154A = defaultImageFieldsModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m20654a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, mo1104b());
            int b = flatBufferBuilder.b(m20662j());
            int a2 = ModelHelper.a(flatBufferBuilder, m20645B());
            int a3 = ModelHelper.a(flatBufferBuilder, m20646C());
            int a4 = ModelHelper.a(flatBufferBuilder, m20638K());
            int b2 = flatBufferBuilder.b(mo1109d());
            int a5 = ModelHelper.a(flatBufferBuilder, m20647D());
            int a6 = ModelHelper.a(flatBufferBuilder, m20639L());
            int a7 = ModelHelper.a(flatBufferBuilder, m20640M());
            int a8 = ModelHelper.a(flatBufferBuilder, m20641N());
            int a9 = ModelHelper.a(flatBufferBuilder, m20648E());
            int a10 = ModelHelper.a(flatBufferBuilder, m20649F());
            int a11 = ModelHelper.a(flatBufferBuilder, m20650G());
            int a12 = ModelHelper.a(flatBufferBuilder, m20651H());
            int a13 = ModelHelper.a(flatBufferBuilder, m20642O());
            int a14 = ModelHelper.a(flatBufferBuilder, m20643P());
            int b3 = flatBufferBuilder.b(m20676x());
            int a15 = ModelHelper.a(flatBufferBuilder, m20652I());
            int a16 = ModelHelper.a(flatBufferBuilder, m20653J());
            flatBufferBuilder.c(25);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, b);
            flatBufferBuilder.b(2, a2);
            flatBufferBuilder.b(3, a3);
            flatBufferBuilder.b(4, a4);
            flatBufferBuilder.a(5, this.f13161i, 0);
            flatBufferBuilder.b(6, b2);
            flatBufferBuilder.b(7, a5);
            flatBufferBuilder.b(8, a6);
            flatBufferBuilder.b(9, a7);
            flatBufferBuilder.b(10, a8);
            flatBufferBuilder.b(11, a9);
            flatBufferBuilder.a(12, this.f13168p);
            flatBufferBuilder.a(13, this.f13169q);
            flatBufferBuilder.b(14, a10);
            flatBufferBuilder.b(15, a11);
            flatBufferBuilder.b(16, a12);
            flatBufferBuilder.a(17, this.f13173u, 0);
            flatBufferBuilder.b(18, a13);
            flatBufferBuilder.b(19, a14);
            flatBufferBuilder.a(20, this.f13176x, 0);
            flatBufferBuilder.b(21, b3);
            flatBufferBuilder.b(22, a15);
            flatBufferBuilder.b(23, a16);
            flatBufferBuilder.a(24, this.f13155B, 0);
            i();
            return flatBufferBuilder.d();
        }

        public final void m20657a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
            super.a(mutableFlatBuffer, i, obj);
            this.f13161i = mutableFlatBuffer.a(i, 5, 0);
            this.f13168p = mutableFlatBuffer.a(i, 12);
            this.f13169q = mutableFlatBuffer.a(i, 13);
            this.f13173u = mutableFlatBuffer.a(i, 17, 0);
            this.f13176x = mutableFlatBuffer.a(i, 20, 0);
            this.f13155B = mutableFlatBuffer.a(i, 24, 0);
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 34748458)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: has_umg */
    public final class PandoraMediasetQueryModel extends BaseModel implements GraphQLVisitableConsistentModel {
        @Nullable
        private GraphQLObjectType f13181d;
        @Nullable
        private MediaModel f13182e;

        /* compiled from: has_umg */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(PandoraMediasetQueryModel.class, new Deserializer());
            }

            public Object m20679a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = PandoraMediasetQueryParser.m20886a(jsonParser);
                Object pandoraMediasetQueryModel = new PandoraMediasetQueryModel();
                ((BaseModel) pandoraMediasetQueryModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (pandoraMediasetQueryModel instanceof Postprocessable) {
                    return ((Postprocessable) pandoraMediasetQueryModel).a();
                }
                return pandoraMediasetQueryModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1823215375)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: has_umg */
        public final class MediaModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private List<PandoraMediaModel> f13179d;
            @Nullable
            private DefaultPageInfoFieldsModel f13180e;

            /* compiled from: has_umg */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(MediaModel.class, new Deserializer());
                }

                public Object m20680a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(PandoraMediasetQueryParser.MediaParser.m20884a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object mediaModel = new MediaModel();
                    ((BaseModel) mediaModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (mediaModel instanceof Postprocessable) {
                        return ((Postprocessable) mediaModel).a();
                    }
                    return mediaModel;
                }
            }

            /* compiled from: has_umg */
            public class Serializer extends JsonSerializer<MediaModel> {
                public final void m20681a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    MediaModel mediaModel = (MediaModel) obj;
                    if (mediaModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(mediaModel.m20682a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mediaModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    PandoraMediasetQueryParser.MediaParser.m20885a(mediaModel.w_(), mediaModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(MediaModel.class, new Serializer());
                }
            }

            public MediaModel() {
                super(2);
            }

            @Nonnull
            public final ImmutableList<PandoraMediaModel> m20684a() {
                this.f13179d = super.a(this.f13179d, 0, PandoraMediaModel.class);
                return (ImmutableList) this.f13179d;
            }

            @Nullable
            public final DefaultPageInfoFieldsModel m20685j() {
                this.f13180e = (DefaultPageInfoFieldsModel) super.a(this.f13180e, 1, DefaultPageInfoFieldsModel.class);
                return this.f13180e;
            }

            public final int jK_() {
                return 747633668;
            }

            public final GraphQLVisitableModel m20683a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel;
                DefaultPageInfoFieldsModel defaultPageInfoFieldsModel;
                h();
                if (m20684a() != null) {
                    Builder a = ModelHelper.a(m20684a(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        MediaModel mediaModel = (MediaModel) ModelHelper.a(null, this);
                        mediaModel.f13179d = a.b();
                        graphQLVisitableModel = mediaModel;
                        if (m20685j() != null) {
                            defaultPageInfoFieldsModel = (DefaultPageInfoFieldsModel) graphQLModelMutatingVisitor.b(m20685j());
                            if (m20685j() != defaultPageInfoFieldsModel) {
                                graphQLVisitableModel = (MediaModel) ModelHelper.a(graphQLVisitableModel, this);
                                graphQLVisitableModel.f13180e = defaultPageInfoFieldsModel;
                            }
                        }
                        i();
                        return graphQLVisitableModel != null ? this : graphQLVisitableModel;
                    }
                }
                graphQLVisitableModel = null;
                if (m20685j() != null) {
                    defaultPageInfoFieldsModel = (DefaultPageInfoFieldsModel) graphQLModelMutatingVisitor.b(m20685j());
                    if (m20685j() != defaultPageInfoFieldsModel) {
                        graphQLVisitableModel = (MediaModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f13180e = defaultPageInfoFieldsModel;
                    }
                }
                i();
                if (graphQLVisitableModel != null) {
                }
            }

            public final int m20682a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m20684a());
                int a2 = ModelHelper.a(flatBufferBuilder, m20685j());
                flatBufferBuilder.c(2);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.b(1, a2);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: has_umg */
        public class Serializer extends JsonSerializer<PandoraMediasetQueryModel> {
            public final void m20686a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                PandoraMediasetQueryModel pandoraMediasetQueryModel = (PandoraMediasetQueryModel) obj;
                if (pandoraMediasetQueryModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(pandoraMediasetQueryModel.m20688a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    pandoraMediasetQueryModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = pandoraMediasetQueryModel.w_();
                int u_ = pandoraMediasetQueryModel.u_();
                jsonGenerator.f();
                if (mutableFlatBuffer.g(u_, 0) != 0) {
                    jsonGenerator.a("__type__");
                    SerializerHelpers.b(mutableFlatBuffer, u_, 0, jsonGenerator);
                }
                int g = mutableFlatBuffer.g(u_, 1);
                if (g != 0) {
                    jsonGenerator.a("media");
                    PandoraMediasetQueryParser.MediaParser.m20885a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(PandoraMediasetQueryModel.class, new Serializer());
            }
        }

        public PandoraMediasetQueryModel() {
            super(2);
        }

        public final void m20691a(String str, ConsistencyTuple consistencyTuple) {
            consistencyTuple.a();
        }

        public final void m20692a(String str, Object obj, boolean z) {
        }

        @Nullable
        private GraphQLObjectType m20687j() {
            if (this.b != null && this.f13181d == null) {
                this.f13181d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
            }
            return this.f13181d;
        }

        @Nullable
        public final MediaModel m20690a() {
            this.f13182e = (MediaModel) super.a(this.f13182e, 1, MediaModel.class);
            return this.f13182e;
        }

        public final int jK_() {
            return 2433570;
        }

        public final GraphQLVisitableModel m20689a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m20690a() != null) {
                MediaModel mediaModel = (MediaModel) graphQLModelMutatingVisitor.b(m20690a());
                if (m20690a() != mediaModel) {
                    graphQLVisitableModel = (PandoraMediasetQueryModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f13182e = mediaModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m20688a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m20687j());
            int a2 = ModelHelper.a(flatBufferBuilder, m20690a());
            flatBufferBuilder.c(2);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, a2);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -1587766035)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: has_umg */
    public final class PandoraProfileSuggestedPhotoQueryModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private ProfileWizardRefresherModel f13187d;

        /* compiled from: has_umg */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(PandoraProfileSuggestedPhotoQueryModel.class, new Deserializer());
            }

            public Object m20693a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = PandoraProfileSuggestedPhotoQueryParser.m20891a(jsonParser);
                Object pandoraProfileSuggestedPhotoQueryModel = new PandoraProfileSuggestedPhotoQueryModel();
                ((BaseModel) pandoraProfileSuggestedPhotoQueryModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (pandoraProfileSuggestedPhotoQueryModel instanceof Postprocessable) {
                    return ((Postprocessable) pandoraProfileSuggestedPhotoQueryModel).a();
                }
                return pandoraProfileSuggestedPhotoQueryModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 1700423782)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: has_umg */
        public final class ProfileWizardRefresherModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private ProfilePictureSuggestionsModel f13186d;

            /* compiled from: has_umg */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(ProfileWizardRefresherModel.class, new Deserializer());
                }

                public Object m20694a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(ProfileWizardRefresherParser.m20889a(jsonParser, flatBufferBuilder));
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

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = 111599591)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: has_umg */
            public final class ProfilePictureSuggestionsModel extends BaseModel implements GraphQLVisitableModel {
                private int f13183d;
                @Nullable
                private List<PandoraMediaImageWithFeedbackFieldsModel> f13184e;
                @Nullable
                private DefaultPageInfoFieldsModel f13185f;

                /* compiled from: has_umg */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(ProfilePictureSuggestionsModel.class, new Deserializer());
                    }

                    public Object m20695a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(ProfilePictureSuggestionsParser.m20887a(jsonParser, flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                        Object profilePictureSuggestionsModel = new ProfilePictureSuggestionsModel();
                        ((BaseModel) profilePictureSuggestionsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                        if (profilePictureSuggestionsModel instanceof Postprocessable) {
                            return ((Postprocessable) profilePictureSuggestionsModel).a();
                        }
                        return profilePictureSuggestionsModel;
                    }
                }

                /* compiled from: has_umg */
                public class Serializer extends JsonSerializer<ProfilePictureSuggestionsModel> {
                    public final void m20696a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        ProfilePictureSuggestionsModel profilePictureSuggestionsModel = (ProfilePictureSuggestionsModel) obj;
                        if (profilePictureSuggestionsModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(profilePictureSuggestionsModel.m20697a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            profilePictureSuggestionsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        ProfilePictureSuggestionsParser.m20888a(profilePictureSuggestionsModel.w_(), profilePictureSuggestionsModel.u_(), jsonGenerator, serializerProvider);
                    }

                    static {
                        FbSerializerProvider.a(ProfilePictureSuggestionsModel.class, new Serializer());
                    }
                }

                public ProfilePictureSuggestionsModel() {
                    super(3);
                }

                @Nonnull
                public final ImmutableList<PandoraMediaImageWithFeedbackFieldsModel> m20699a() {
                    this.f13184e = super.a(this.f13184e, 1, PandoraMediaImageWithFeedbackFieldsModel.class);
                    return (ImmutableList) this.f13184e;
                }

                @Nullable
                public final DefaultPageInfoFieldsModel m20701j() {
                    this.f13185f = (DefaultPageInfoFieldsModel) super.a(this.f13185f, 2, DefaultPageInfoFieldsModel.class);
                    return this.f13185f;
                }

                public final int jK_() {
                    return -513281116;
                }

                public final GraphQLVisitableModel m20698a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    GraphQLVisitableModel graphQLVisitableModel;
                    DefaultPageInfoFieldsModel defaultPageInfoFieldsModel;
                    h();
                    if (m20699a() != null) {
                        Builder a = ModelHelper.a(m20699a(), graphQLModelMutatingVisitor);
                        if (a != null) {
                            ProfilePictureSuggestionsModel profilePictureSuggestionsModel = (ProfilePictureSuggestionsModel) ModelHelper.a(null, this);
                            profilePictureSuggestionsModel.f13184e = a.b();
                            graphQLVisitableModel = profilePictureSuggestionsModel;
                            if (m20701j() != null) {
                                defaultPageInfoFieldsModel = (DefaultPageInfoFieldsModel) graphQLModelMutatingVisitor.b(m20701j());
                                if (m20701j() != defaultPageInfoFieldsModel) {
                                    graphQLVisitableModel = (ProfilePictureSuggestionsModel) ModelHelper.a(graphQLVisitableModel, this);
                                    graphQLVisitableModel.f13185f = defaultPageInfoFieldsModel;
                                }
                            }
                            i();
                            return graphQLVisitableModel != null ? this : graphQLVisitableModel;
                        }
                    }
                    graphQLVisitableModel = null;
                    if (m20701j() != null) {
                        defaultPageInfoFieldsModel = (DefaultPageInfoFieldsModel) graphQLModelMutatingVisitor.b(m20701j());
                        if (m20701j() != defaultPageInfoFieldsModel) {
                            graphQLVisitableModel = (ProfilePictureSuggestionsModel) ModelHelper.a(graphQLVisitableModel, this);
                            graphQLVisitableModel.f13185f = defaultPageInfoFieldsModel;
                        }
                    }
                    i();
                    if (graphQLVisitableModel != null) {
                    }
                }

                public final int m20697a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int a = ModelHelper.a(flatBufferBuilder, m20699a());
                    int a2 = ModelHelper.a(flatBufferBuilder, m20701j());
                    flatBufferBuilder.c(3);
                    flatBufferBuilder.a(0, this.f13183d, 0);
                    flatBufferBuilder.b(1, a);
                    flatBufferBuilder.b(2, a2);
                    i();
                    return flatBufferBuilder.d();
                }

                public final void m20700a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                    super.a(mutableFlatBuffer, i, obj);
                    this.f13183d = mutableFlatBuffer.a(i, 0, 0);
                }
            }

            /* compiled from: has_umg */
            public class Serializer extends JsonSerializer<ProfileWizardRefresherModel> {
                public final void m20702a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    ProfileWizardRefresherModel profileWizardRefresherModel = (ProfileWizardRefresherModel) obj;
                    if (profileWizardRefresherModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(profileWizardRefresherModel.m20703a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        profileWizardRefresherModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    ProfileWizardRefresherParser.m20890a(profileWizardRefresherModel.w_(), profileWizardRefresherModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(ProfileWizardRefresherModel.class, new Serializer());
                }
            }

            public ProfileWizardRefresherModel() {
                super(1);
            }

            @Nullable
            public final ProfilePictureSuggestionsModel m20705a() {
                this.f13186d = (ProfilePictureSuggestionsModel) super.a(this.f13186d, 0, ProfilePictureSuggestionsModel.class);
                return this.f13186d;
            }

            public final int jK_() {
                return 2141145812;
            }

            public final GraphQLVisitableModel m20704a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m20705a() != null) {
                    ProfilePictureSuggestionsModel profilePictureSuggestionsModel = (ProfilePictureSuggestionsModel) graphQLModelMutatingVisitor.b(m20705a());
                    if (m20705a() != profilePictureSuggestionsModel) {
                        graphQLVisitableModel = (ProfileWizardRefresherModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f13186d = profilePictureSuggestionsModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m20703a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m20705a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, a);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: has_umg */
        public class Serializer extends JsonSerializer<PandoraProfileSuggestedPhotoQueryModel> {
            public final void m20706a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                PandoraProfileSuggestedPhotoQueryModel pandoraProfileSuggestedPhotoQueryModel = (PandoraProfileSuggestedPhotoQueryModel) obj;
                if (pandoraProfileSuggestedPhotoQueryModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(pandoraProfileSuggestedPhotoQueryModel.m20707a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    pandoraProfileSuggestedPhotoQueryModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = pandoraProfileSuggestedPhotoQueryModel.w_();
                int u_ = pandoraProfileSuggestedPhotoQueryModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("profile_wizard_refresher");
                    ProfileWizardRefresherParser.m20890a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(PandoraProfileSuggestedPhotoQueryModel.class, new Serializer());
            }
        }

        public PandoraProfileSuggestedPhotoQueryModel() {
            super(1);
        }

        @Nullable
        public final ProfileWizardRefresherModel m20709a() {
            this.f13187d = (ProfileWizardRefresherModel) super.a(this.f13187d, 0, ProfileWizardRefresherModel.class);
            return this.f13187d;
        }

        public final int jK_() {
            return -1732764110;
        }

        public final GraphQLVisitableModel m20708a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m20709a() != null) {
                ProfileWizardRefresherModel profileWizardRefresherModel = (ProfileWizardRefresherModel) graphQLModelMutatingVisitor.b(m20709a());
                if (m20709a() != profileWizardRefresherModel) {
                    graphQLVisitableModel = (PandoraProfileSuggestedPhotoQueryModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f13187d = profileWizardRefresherModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m20707a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m20709a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 717500221)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: has_umg */
    public final class PandoraQueryFeedbackModel extends BaseModel implements SimpleFeedFeedback, GraphQLPersistableNode, GraphQLVisitableConsistentModel {
        @Nullable
        private TopLevelCommentsModel f13190A;
        @Nullable
        private TopReactionsModel f13191B;
        @Nullable
        private ViewerActsAsPageModel f13192C;
        @Nullable
        private ViewerActsAsPersonModel f13193D;
        @Nullable
        private ViewerDoesNotLikeSentenceModel f13194E;
        private int f13195F;
        @Nullable
        private ViewerLikesSentenceModel f13196G;
        private boolean f13197d;
        private boolean f13198e;
        private boolean f13199f;
        private boolean f13200g;
        private boolean f13201h;
        private boolean f13202i;
        private boolean f13203j;
        private boolean f13204k;
        @Nullable
        private String f13205l;
        @Nullable
        private String f13206m;
        private boolean f13207n;
        private boolean f13208o;
        @Nullable
        private String f13209p;
        @Nullable
        private ImportantReactorsModel f13210q;
        private boolean f13211r;
        @Nullable
        private String f13212s;
        @Nullable
        private LikersModel f13213t;
        @Nullable
        private ReactorsModel f13214u;
        @Nullable
        private RealTimeActivityInfoModel f13215v;
        @Nullable
        private String f13216w;
        @Nullable
        private ResharesModel f13217x;
        private boolean f13218y;
        @Nullable
        private List<SupportedReactionsModel> f13219z;

        /* compiled from: has_umg */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(PandoraQueryFeedbackModel.class, new Deserializer());
            }

            public Object m20710a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(PandoraQueryFeedbackParser.m20896a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object pandoraQueryFeedbackModel = new PandoraQueryFeedbackModel();
                ((BaseModel) pandoraQueryFeedbackModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (pandoraQueryFeedbackModel instanceof Postprocessable) {
                    return ((Postprocessable) pandoraQueryFeedbackModel).a();
                }
                return pandoraQueryFeedbackModel;
            }
        }

        /* compiled from: has_umg */
        public class Serializer extends JsonSerializer<PandoraQueryFeedbackModel> {
            public final void m20711a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                PandoraQueryFeedbackModel pandoraQueryFeedbackModel = (PandoraQueryFeedbackModel) obj;
                if (pandoraQueryFeedbackModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(pandoraQueryFeedbackModel.m20744a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    pandoraQueryFeedbackModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                PandoraQueryFeedbackParser.m20897a(pandoraQueryFeedbackModel.w_(), pandoraQueryFeedbackModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(PandoraQueryFeedbackModel.class, new Serializer());
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1352864475)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: has_umg */
        public final class ViewerDoesNotLikeSentenceModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private String f13188d;

            /* compiled from: has_umg */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(ViewerDoesNotLikeSentenceModel.class, new Deserializer());
                }

                public Object m20712a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(ViewerDoesNotLikeSentenceParser.m20892a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object viewerDoesNotLikeSentenceModel = new ViewerDoesNotLikeSentenceModel();
                    ((BaseModel) viewerDoesNotLikeSentenceModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (viewerDoesNotLikeSentenceModel instanceof Postprocessable) {
                        return ((Postprocessable) viewerDoesNotLikeSentenceModel).a();
                    }
                    return viewerDoesNotLikeSentenceModel;
                }
            }

            /* compiled from: has_umg */
            public class Serializer extends JsonSerializer<ViewerDoesNotLikeSentenceModel> {
                public final void m20713a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    ViewerDoesNotLikeSentenceModel viewerDoesNotLikeSentenceModel = (ViewerDoesNotLikeSentenceModel) obj;
                    if (viewerDoesNotLikeSentenceModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(viewerDoesNotLikeSentenceModel.m20714a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        viewerDoesNotLikeSentenceModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    ViewerDoesNotLikeSentenceParser.m20893a(viewerDoesNotLikeSentenceModel.w_(), viewerDoesNotLikeSentenceModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(ViewerDoesNotLikeSentenceModel.class, new Serializer());
                }
            }

            public ViewerDoesNotLikeSentenceModel() {
                super(1);
            }

            @Nullable
            public final String m20716a() {
                this.f13188d = super.a(this.f13188d, 0);
                return this.f13188d;
            }

            public final int jK_() {
                return -1919764332;
            }

            public final GraphQLVisitableModel m20715a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m20714a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m20716a());
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
        /* compiled from: has_umg */
        public final class ViewerLikesSentenceModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private String f13189d;

            /* compiled from: has_umg */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(ViewerLikesSentenceModel.class, new Deserializer());
                }

                public Object m20717a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(ViewerLikesSentenceParser.m20894a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object viewerLikesSentenceModel = new ViewerLikesSentenceModel();
                    ((BaseModel) viewerLikesSentenceModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (viewerLikesSentenceModel instanceof Postprocessable) {
                        return ((Postprocessable) viewerLikesSentenceModel).a();
                    }
                    return viewerLikesSentenceModel;
                }
            }

            /* compiled from: has_umg */
            public class Serializer extends JsonSerializer<ViewerLikesSentenceModel> {
                public final void m20718a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    ViewerLikesSentenceModel viewerLikesSentenceModel = (ViewerLikesSentenceModel) obj;
                    if (viewerLikesSentenceModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(viewerLikesSentenceModel.m20719a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        viewerLikesSentenceModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    ViewerLikesSentenceParser.m20895a(viewerLikesSentenceModel.w_(), viewerLikesSentenceModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(ViewerLikesSentenceModel.class, new Serializer());
                }
            }

            public ViewerLikesSentenceModel() {
                super(1);
            }

            @Nullable
            public final String m20721a() {
                this.f13189d = super.a(this.f13189d, 0);
                return this.f13189d;
            }

            public final int jK_() {
                return -1919764332;
            }

            public final GraphQLVisitableModel m20720a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m20719a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m20721a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, b);
                i();
                return flatBufferBuilder.d();
            }
        }

        @Nullable
        public final /* synthetic */ TopLevelCommentsModel m20738A() {
            return m20727L();
        }

        @Nullable
        public final /* synthetic */ TopReactionsModel m20739B() {
            return m20728M();
        }

        @Nullable
        public final /* synthetic */ ViewerActsAsPersonModel m20740C() {
            return m20730O();
        }

        @Nullable
        public final /* synthetic */ ViewerDoesNotLikeSentenceModel m20741D() {
            return m20731P();
        }

        @Nullable
        public final /* synthetic */ ViewerLikesSentenceModel m20743F() {
            return m20732Q();
        }

        @Nullable
        public final /* synthetic */ ViewerActsAsPage m20760p() {
            return m20729N();
        }

        @Nullable
        public final /* synthetic */ ImportantReactorsModel m20764t() {
            return m20722G();
        }

        @Nullable
        public final /* synthetic */ LikersModel m20765u() {
            return m20723H();
        }

        @Nullable
        public final /* synthetic */ ReactorsModel m20766v() {
            return m20724I();
        }

        @Nullable
        public final /* synthetic */ RealTimeActivityInfoModel m20767w() {
            return m20725J();
        }

        @Nullable
        public final /* synthetic */ ResharesModel m20768x() {
            return m20726K();
        }

        public PandoraQueryFeedbackModel() {
            super(30);
        }

        public final void m20748a(String str, ConsistencyTuple consistencyTuple) {
            if ("can_viewer_comment".equals(str)) {
                consistencyTuple.a = Boolean.valueOf(m20751c());
                consistencyTuple.b = u_();
                consistencyTuple.c = 1;
            } else if ("can_viewer_like".equals(str)) {
                consistencyTuple.a = Boolean.valueOf(bU_());
                consistencyTuple.b = u_();
                consistencyTuple.c = 5;
            } else if ("does_viewer_like".equals(str)) {
                consistencyTuple.a = Boolean.valueOf(m20755k());
                consistencyTuple.b = u_();
                consistencyTuple.c = 11;
            } else if ("is_viewer_subscribed".equals(str)) {
                consistencyTuple.a = Boolean.valueOf(m20757m());
                consistencyTuple.b = u_();
                consistencyTuple.c = 14;
            } else {
                if ("likers.count".equals(str)) {
                    LikersModel H = m20723H();
                    if (H != null) {
                        consistencyTuple.a = Integer.valueOf(H.a());
                        consistencyTuple.b = H.u_();
                        consistencyTuple.c = 0;
                        return;
                    }
                } else if ("reactors.count".equals(str)) {
                    ReactorsModel I = m20724I();
                    if (I != null) {
                        consistencyTuple.a = Integer.valueOf(I.a());
                        consistencyTuple.b = I.u_();
                        consistencyTuple.c = 0;
                        return;
                    }
                } else if ("reshares.count".equals(str)) {
                    ResharesModel K = m20726K();
                    if (K != null) {
                        consistencyTuple.a = Integer.valueOf(K.a());
                        consistencyTuple.b = K.u_();
                        consistencyTuple.c = 0;
                        return;
                    }
                } else if ("top_level_comments.count".equals(str)) {
                    r0 = m20727L();
                    if (r0 != null) {
                        consistencyTuple.a = Integer.valueOf(r0.a());
                        consistencyTuple.b = r0.u_();
                        consistencyTuple.c = 0;
                        return;
                    }
                } else if ("top_level_comments.total_count".equals(str)) {
                    r0 = m20727L();
                    if (r0 != null) {
                        consistencyTuple.a = Integer.valueOf(r0.b());
                        consistencyTuple.b = r0.u_();
                        consistencyTuple.c = 1;
                        return;
                    }
                } else if ("viewer_feedback_reaction_key".equals(str)) {
                    consistencyTuple.a = Integer.valueOf(m20742E());
                    consistencyTuple.b = u_();
                    consistencyTuple.c = 28;
                    return;
                }
                consistencyTuple.a();
            }
        }

        public final void m20749a(String str, Object obj, boolean z) {
            if ("can_viewer_comment".equals(str)) {
                m20734a(((Boolean) obj).booleanValue());
            } else if ("can_viewer_like".equals(str)) {
                m20735b(((Boolean) obj).booleanValue());
            } else if ("does_viewer_like".equals(str)) {
                m20736c(((Boolean) obj).booleanValue());
            } else if ("is_viewer_subscribed".equals(str)) {
                m20737d(((Boolean) obj).booleanValue());
            } else if ("likers.count".equals(str)) {
                LikersModel H = m20723H();
                if (H == null) {
                    return;
                }
                if (z) {
                    H = (LikersModel) H.clone();
                    H.a(((Integer) obj).intValue());
                    this.f13213t = H;
                    return;
                }
                H.a(((Integer) obj).intValue());
            } else if ("reactors.count".equals(str)) {
                ReactorsModel I = m20724I();
                if (I == null) {
                    return;
                }
                if (z) {
                    I = (ReactorsModel) I.clone();
                    I.a(((Integer) obj).intValue());
                    this.f13214u = I;
                    return;
                }
                I.a(((Integer) obj).intValue());
            } else if ("reshares.count".equals(str)) {
                ResharesModel K = m20726K();
                if (K == null) {
                    return;
                }
                if (z) {
                    K = (ResharesModel) K.clone();
                    K.a(((Integer) obj).intValue());
                    this.f13217x = K;
                    return;
                }
                K.a(((Integer) obj).intValue());
            } else if ("top_level_comments.count".equals(str)) {
                r0 = m20727L();
                if (r0 == null) {
                    return;
                }
                if (z) {
                    r0 = (TopLevelCommentsModel) r0.clone();
                    r0.a(((Integer) obj).intValue());
                    this.f13190A = r0;
                    return;
                }
                r0.a(((Integer) obj).intValue());
            } else if ("top_level_comments.total_count".equals(str)) {
                r0 = m20727L();
                if (r0 == null) {
                    return;
                }
                if (z) {
                    r0 = (TopLevelCommentsModel) r0.clone();
                    r0.b(((Integer) obj).intValue());
                    this.f13190A = r0;
                    return;
                }
                r0.b(((Integer) obj).intValue());
            } else if ("viewer_feedback_reaction_key".equals(str)) {
                m20733a(((Integer) obj).intValue());
            }
        }

        public final boolean m20750b() {
            a(0, 0);
            return this.f13197d;
        }

        public final boolean m20751c() {
            a(0, 1);
            return this.f13198e;
        }

        private void m20734a(boolean z) {
            this.f13198e = z;
            if (this.b != null && this.b.d) {
                this.b.a(this.c, 1, z);
            }
        }

        public final boolean m20752d() {
            a(0, 2);
            return this.f13199f;
        }

        public final boolean bT_() {
            a(0, 3);
            return this.f13200g;
        }

        public final boolean m20753g() {
            a(0, 4);
            return this.f13201h;
        }

        public final boolean bU_() {
            a(0, 5);
            return this.f13202i;
        }

        private void m20735b(boolean z) {
            this.f13202i = z;
            if (this.b != null && this.b.d) {
                this.b.a(this.c, 5, z);
            }
        }

        public final boolean m20761q() {
            a(0, 6);
            return this.f13203j;
        }

        public final boolean bV_() {
            a(0, 7);
            return this.f13204k;
        }

        @Nullable
        public final String m20754j() {
            this.f13205l = super.a(this.f13205l, 8);
            return this.f13205l;
        }

        @Nullable
        public final String m20762r() {
            this.f13206m = super.a(this.f13206m, 9);
            return this.f13206m;
        }

        public final boolean m20763s() {
            a(1, 2);
            return this.f13207n;
        }

        public final boolean m20755k() {
            a(1, 3);
            return this.f13208o;
        }

        private void m20736c(boolean z) {
            this.f13208o = z;
            if (this.b != null && this.b.d) {
                this.b.a(this.c, 11, z);
            }
        }

        @Nullable
        public final String m20756l() {
            this.f13209p = super.a(this.f13209p, 12);
            return this.f13209p;
        }

        @Nullable
        private ImportantReactorsModel m20722G() {
            this.f13210q = (ImportantReactorsModel) super.a(this.f13210q, 13, ImportantReactorsModel.class);
            return this.f13210q;
        }

        public final boolean m20757m() {
            a(1, 6);
            return this.f13211r;
        }

        private void m20737d(boolean z) {
            this.f13211r = z;
            if (this.b != null && this.b.d) {
                this.b.a(this.c, 14, z);
            }
        }

        @Nullable
        public final String m20758n() {
            this.f13212s = super.a(this.f13212s, 15);
            return this.f13212s;
        }

        @Nullable
        private LikersModel m20723H() {
            this.f13213t = (LikersModel) super.a(this.f13213t, 16, LikersModel.class);
            return this.f13213t;
        }

        @Nullable
        private ReactorsModel m20724I() {
            this.f13214u = (ReactorsModel) super.a(this.f13214u, 17, ReactorsModel.class);
            return this.f13214u;
        }

        @Nullable
        private RealTimeActivityInfoModel m20725J() {
            this.f13215v = (RealTimeActivityInfoModel) super.a(this.f13215v, 18, RealTimeActivityInfoModel.class);
            return this.f13215v;
        }

        @Nullable
        public final String m20759o() {
            this.f13216w = super.a(this.f13216w, 19);
            return this.f13216w;
        }

        @Nullable
        private ResharesModel m20726K() {
            this.f13217x = (ResharesModel) super.a(this.f13217x, 20, ResharesModel.class);
            return this.f13217x;
        }

        public final boolean m20769y() {
            a(2, 5);
            return this.f13218y;
        }

        @Nonnull
        public final ImmutableList<SupportedReactionsModel> m20770z() {
            this.f13219z = super.a(this.f13219z, 22, SupportedReactionsModel.class);
            return (ImmutableList) this.f13219z;
        }

        @Nullable
        private TopLevelCommentsModel m20727L() {
            this.f13190A = (TopLevelCommentsModel) super.a(this.f13190A, 23, TopLevelCommentsModel.class);
            return this.f13190A;
        }

        @Nullable
        private TopReactionsModel m20728M() {
            this.f13191B = (TopReactionsModel) super.a(this.f13191B, 24, TopReactionsModel.class);
            return this.f13191B;
        }

        @Nullable
        private ViewerActsAsPageModel m20729N() {
            this.f13192C = (ViewerActsAsPageModel) super.a(this.f13192C, 25, ViewerActsAsPageModel.class);
            return this.f13192C;
        }

        @Nullable
        private ViewerActsAsPersonModel m20730O() {
            this.f13193D = (ViewerActsAsPersonModel) super.a(this.f13193D, 26, ViewerActsAsPersonModel.class);
            return this.f13193D;
        }

        @Nullable
        private ViewerDoesNotLikeSentenceModel m20731P() {
            this.f13194E = (ViewerDoesNotLikeSentenceModel) super.a(this.f13194E, 27, ViewerDoesNotLikeSentenceModel.class);
            return this.f13194E;
        }

        public final int m20742E() {
            a(3, 4);
            return this.f13195F;
        }

        private void m20733a(int i) {
            this.f13195F = i;
            if (this.b != null && this.b.d) {
                this.b.b(this.c, 28, i);
            }
        }

        @Nullable
        private ViewerLikesSentenceModel m20732Q() {
            this.f13196G = (ViewerLikesSentenceModel) super.a(this.f13196G, 29, ViewerLikesSentenceModel.class);
            return this.f13196G;
        }

        @Nullable
        public final String m20746a() {
            return m20758n();
        }

        public final int jK_() {
            return -126857307;
        }

        public final GraphQLVisitableModel m20745a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m20722G() != null) {
                ImportantReactorsModel importantReactorsModel = (ImportantReactorsModel) graphQLModelMutatingVisitor.b(m20722G());
                if (m20722G() != importantReactorsModel) {
                    graphQLVisitableModel = (PandoraQueryFeedbackModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f13210q = importantReactorsModel;
                }
            }
            if (m20723H() != null) {
                LikersModel likersModel = (LikersModel) graphQLModelMutatingVisitor.b(m20723H());
                if (m20723H() != likersModel) {
                    graphQLVisitableModel = (PandoraQueryFeedbackModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f13213t = likersModel;
                }
            }
            if (m20724I() != null) {
                ReactorsModel reactorsModel = (ReactorsModel) graphQLModelMutatingVisitor.b(m20724I());
                if (m20724I() != reactorsModel) {
                    graphQLVisitableModel = (PandoraQueryFeedbackModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f13214u = reactorsModel;
                }
            }
            if (m20725J() != null) {
                RealTimeActivityInfoModel realTimeActivityInfoModel = (RealTimeActivityInfoModel) graphQLModelMutatingVisitor.b(m20725J());
                if (m20725J() != realTimeActivityInfoModel) {
                    graphQLVisitableModel = (PandoraQueryFeedbackModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f13215v = realTimeActivityInfoModel;
                }
            }
            if (m20726K() != null) {
                ResharesModel resharesModel = (ResharesModel) graphQLModelMutatingVisitor.b(m20726K());
                if (m20726K() != resharesModel) {
                    graphQLVisitableModel = (PandoraQueryFeedbackModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f13217x = resharesModel;
                }
            }
            if (m20770z() != null) {
                Builder a = ModelHelper.a(m20770z(), graphQLModelMutatingVisitor);
                if (a != null) {
                    PandoraQueryFeedbackModel pandoraQueryFeedbackModel = (PandoraQueryFeedbackModel) ModelHelper.a(graphQLVisitableModel, this);
                    pandoraQueryFeedbackModel.f13219z = a.b();
                    graphQLVisitableModel = pandoraQueryFeedbackModel;
                }
            }
            if (m20727L() != null) {
                TopLevelCommentsModel topLevelCommentsModel = (TopLevelCommentsModel) graphQLModelMutatingVisitor.b(m20727L());
                if (m20727L() != topLevelCommentsModel) {
                    graphQLVisitableModel = (PandoraQueryFeedbackModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f13190A = topLevelCommentsModel;
                }
            }
            if (m20728M() != null) {
                TopReactionsModel topReactionsModel = (TopReactionsModel) graphQLModelMutatingVisitor.b(m20728M());
                if (m20728M() != topReactionsModel) {
                    graphQLVisitableModel = (PandoraQueryFeedbackModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f13191B = topReactionsModel;
                }
            }
            if (m20729N() != null) {
                ViewerActsAsPageModel viewerActsAsPageModel = (ViewerActsAsPageModel) graphQLModelMutatingVisitor.b(m20729N());
                if (m20729N() != viewerActsAsPageModel) {
                    graphQLVisitableModel = (PandoraQueryFeedbackModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f13192C = viewerActsAsPageModel;
                }
            }
            if (m20730O() != null) {
                ViewerActsAsPersonModel viewerActsAsPersonModel = (ViewerActsAsPersonModel) graphQLModelMutatingVisitor.b(m20730O());
                if (m20730O() != viewerActsAsPersonModel) {
                    graphQLVisitableModel = (PandoraQueryFeedbackModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f13193D = viewerActsAsPersonModel;
                }
            }
            if (m20731P() != null) {
                ViewerDoesNotLikeSentenceModel viewerDoesNotLikeSentenceModel = (ViewerDoesNotLikeSentenceModel) graphQLModelMutatingVisitor.b(m20731P());
                if (m20731P() != viewerDoesNotLikeSentenceModel) {
                    graphQLVisitableModel = (PandoraQueryFeedbackModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f13194E = viewerDoesNotLikeSentenceModel;
                }
            }
            if (m20732Q() != null) {
                ViewerLikesSentenceModel viewerLikesSentenceModel = (ViewerLikesSentenceModel) graphQLModelMutatingVisitor.b(m20732Q());
                if (m20732Q() != viewerLikesSentenceModel) {
                    graphQLVisitableModel = (PandoraQueryFeedbackModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f13196G = viewerLikesSentenceModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m20744a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(m20754j());
            int b2 = flatBufferBuilder.b(m20762r());
            int b3 = flatBufferBuilder.b(m20756l());
            int a = ModelHelper.a(flatBufferBuilder, m20722G());
            int b4 = flatBufferBuilder.b(m20758n());
            int a2 = ModelHelper.a(flatBufferBuilder, m20723H());
            int a3 = ModelHelper.a(flatBufferBuilder, m20724I());
            int a4 = ModelHelper.a(flatBufferBuilder, m20725J());
            int b5 = flatBufferBuilder.b(m20759o());
            int a5 = ModelHelper.a(flatBufferBuilder, m20726K());
            int a6 = ModelHelper.a(flatBufferBuilder, m20770z());
            int a7 = ModelHelper.a(flatBufferBuilder, m20727L());
            int a8 = ModelHelper.a(flatBufferBuilder, m20728M());
            int a9 = ModelHelper.a(flatBufferBuilder, m20729N());
            int a10 = ModelHelper.a(flatBufferBuilder, m20730O());
            int a11 = ModelHelper.a(flatBufferBuilder, m20731P());
            int a12 = ModelHelper.a(flatBufferBuilder, m20732Q());
            flatBufferBuilder.c(30);
            flatBufferBuilder.a(0, this.f13197d);
            flatBufferBuilder.a(1, this.f13198e);
            flatBufferBuilder.a(2, this.f13199f);
            flatBufferBuilder.a(3, this.f13200g);
            flatBufferBuilder.a(4, this.f13201h);
            flatBufferBuilder.a(5, this.f13202i);
            flatBufferBuilder.a(6, this.f13203j);
            flatBufferBuilder.a(7, this.f13204k);
            flatBufferBuilder.b(8, b);
            flatBufferBuilder.b(9, b2);
            flatBufferBuilder.a(10, this.f13207n);
            flatBufferBuilder.a(11, this.f13208o);
            flatBufferBuilder.b(12, b3);
            flatBufferBuilder.b(13, a);
            flatBufferBuilder.a(14, this.f13211r);
            flatBufferBuilder.b(15, b4);
            flatBufferBuilder.b(16, a2);
            flatBufferBuilder.b(17, a3);
            flatBufferBuilder.b(18, a4);
            flatBufferBuilder.b(19, b5);
            flatBufferBuilder.b(20, a5);
            flatBufferBuilder.a(21, this.f13218y);
            flatBufferBuilder.b(22, a6);
            flatBufferBuilder.b(23, a7);
            flatBufferBuilder.b(24, a8);
            flatBufferBuilder.b(25, a9);
            flatBufferBuilder.b(26, a10);
            flatBufferBuilder.b(27, a11);
            flatBufferBuilder.a(28, this.f13195F, 0);
            flatBufferBuilder.b(29, a12);
            i();
            return flatBufferBuilder.d();
        }

        public final void m20747a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
            super.a(mutableFlatBuffer, i, obj);
            this.f13197d = mutableFlatBuffer.a(i, 0);
            this.f13198e = mutableFlatBuffer.a(i, 1);
            this.f13199f = mutableFlatBuffer.a(i, 2);
            this.f13200g = mutableFlatBuffer.a(i, 3);
            this.f13201h = mutableFlatBuffer.a(i, 4);
            this.f13202i = mutableFlatBuffer.a(i, 5);
            this.f13203j = mutableFlatBuffer.a(i, 6);
            this.f13204k = mutableFlatBuffer.a(i, 7);
            this.f13207n = mutableFlatBuffer.a(i, 10);
            this.f13208o = mutableFlatBuffer.a(i, 11);
            this.f13211r = mutableFlatBuffer.a(i, 14);
            this.f13218y = mutableFlatBuffer.a(i, 21);
            this.f13195F = mutableFlatBuffer.a(i, 28, 0);
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -1072228804)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: has_umg */
    public final class PandoraTaggedMediaCountQueryModel extends BaseModel implements GraphQLVisitableConsistentModel {
        @Nullable
        private GraphQLObjectType f13222d;
        @Nullable
        private TaggedMediasetModel f13223e;

        /* compiled from: has_umg */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(PandoraTaggedMediaCountQueryModel.class, new Deserializer());
            }

            public Object m20771a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = PandoraTaggedMediaCountQueryParser.m20902a(jsonParser);
                Object pandoraTaggedMediaCountQueryModel = new PandoraTaggedMediaCountQueryModel();
                ((BaseModel) pandoraTaggedMediaCountQueryModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (pandoraTaggedMediaCountQueryModel instanceof Postprocessable) {
                    return ((Postprocessable) pandoraTaggedMediaCountQueryModel).a();
                }
                return pandoraTaggedMediaCountQueryModel;
            }
        }

        /* compiled from: has_umg */
        public class Serializer extends JsonSerializer<PandoraTaggedMediaCountQueryModel> {
            public final void m20772a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                PandoraTaggedMediaCountQueryModel pandoraTaggedMediaCountQueryModel = (PandoraTaggedMediaCountQueryModel) obj;
                if (pandoraTaggedMediaCountQueryModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(pandoraTaggedMediaCountQueryModel.m20785a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    pandoraTaggedMediaCountQueryModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = pandoraTaggedMediaCountQueryModel.w_();
                int u_ = pandoraTaggedMediaCountQueryModel.u_();
                jsonGenerator.f();
                if (mutableFlatBuffer.g(u_, 0) != 0) {
                    jsonGenerator.a("__type__");
                    SerializerHelpers.b(mutableFlatBuffer, u_, 0, jsonGenerator);
                }
                int g = mutableFlatBuffer.g(u_, 1);
                if (g != 0) {
                    jsonGenerator.a("tagged_mediaset");
                    TaggedMediasetParser.m20901a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(PandoraTaggedMediaCountQueryModel.class, new Serializer());
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1321167506)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: has_umg */
        public final class TaggedMediasetModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private MediaModel f13221d;

            /* compiled from: has_umg */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(TaggedMediasetModel.class, new Deserializer());
                }

                public Object m20773a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(TaggedMediasetParser.m20900a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object taggedMediasetModel = new TaggedMediasetModel();
                    ((BaseModel) taggedMediasetModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (taggedMediasetModel instanceof Postprocessable) {
                        return ((Postprocessable) taggedMediasetModel).a();
                    }
                    return taggedMediasetModel;
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = -1723990064)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: has_umg */
            public final class MediaModel extends BaseModel implements GraphQLVisitableModel {
                private int f13220d;

                /* compiled from: has_umg */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(MediaModel.class, new Deserializer());
                    }

                    public Object m20774a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(TaggedMediasetParser.MediaParser.m20898a(jsonParser, flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                        Object mediaModel = new MediaModel();
                        ((BaseModel) mediaModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                        if (mediaModel instanceof Postprocessable) {
                            return ((Postprocessable) mediaModel).a();
                        }
                        return mediaModel;
                    }
                }

                /* compiled from: has_umg */
                public class Serializer extends JsonSerializer<MediaModel> {
                    public final void m20775a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        MediaModel mediaModel = (MediaModel) obj;
                        if (mediaModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(mediaModel.m20777a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            mediaModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        TaggedMediasetParser.MediaParser.m20899a(mediaModel.w_(), mediaModel.u_(), jsonGenerator);
                    }

                    static {
                        FbSerializerProvider.a(MediaModel.class, new Serializer());
                    }
                }

                public MediaModel() {
                    super(1);
                }

                public final int m20776a() {
                    a(0, 0);
                    return this.f13220d;
                }

                public final int jK_() {
                    return 747633668;
                }

                public final GraphQLVisitableModel m20778a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    h();
                    i();
                    return this;
                }

                public final int m20777a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.a(0, this.f13220d, 0);
                    i();
                    return flatBufferBuilder.d();
                }

                public final void m20779a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                    super.a(mutableFlatBuffer, i, obj);
                    this.f13220d = mutableFlatBuffer.a(i, 0, 0);
                }
            }

            /* compiled from: has_umg */
            public class Serializer extends JsonSerializer<TaggedMediasetModel> {
                public final void m20780a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    TaggedMediasetModel taggedMediasetModel = (TaggedMediasetModel) obj;
                    if (taggedMediasetModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(taggedMediasetModel.m20781a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        taggedMediasetModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    TaggedMediasetParser.m20901a(taggedMediasetModel.w_(), taggedMediasetModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(TaggedMediasetModel.class, new Serializer());
                }
            }

            public TaggedMediasetModel() {
                super(1);
            }

            @Nullable
            public final MediaModel m20783a() {
                this.f13221d = (MediaModel) super.a(this.f13221d, 0, MediaModel.class);
                return this.f13221d;
            }

            public final int jK_() {
                return 685632024;
            }

            public final GraphQLVisitableModel m20782a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m20783a() != null) {
                    MediaModel mediaModel = (MediaModel) graphQLModelMutatingVisitor.b(m20783a());
                    if (m20783a() != mediaModel) {
                        graphQLVisitableModel = (TaggedMediasetModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f13221d = mediaModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m20781a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m20783a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, a);
                i();
                return flatBufferBuilder.d();
            }
        }

        public PandoraTaggedMediaCountQueryModel() {
            super(2);
        }

        public final void m20788a(String str, ConsistencyTuple consistencyTuple) {
            consistencyTuple.a();
        }

        public final void m20789a(String str, Object obj, boolean z) {
        }

        @Nullable
        private GraphQLObjectType m20784j() {
            if (this.b != null && this.f13222d == null) {
                this.f13222d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
            }
            return this.f13222d;
        }

        @Nullable
        public final TaggedMediasetModel m20787a() {
            this.f13223e = (TaggedMediasetModel) super.a(this.f13223e, 1, TaggedMediasetModel.class);
            return this.f13223e;
        }

        public final int jK_() {
            return 2433570;
        }

        public final GraphQLVisitableModel m20786a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m20787a() != null) {
                TaggedMediasetModel taggedMediasetModel = (TaggedMediasetModel) graphQLModelMutatingVisitor.b(m20787a());
                if (m20787a() != taggedMediasetModel) {
                    graphQLVisitableModel = (PandoraTaggedMediaCountQueryModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f13223e = taggedMediasetModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m20785a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m20784j());
            int a2 = ModelHelper.a(flatBufferBuilder, m20787a());
            flatBufferBuilder.c(2);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, a2);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 65261430)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: has_umg */
    public final class PandoraTaggedMediasetQueryModel extends BaseModel implements GraphQLVisitableConsistentModel {
        @Nullable
        private GraphQLObjectType f13227d;
        @Nullable
        private TaggedMediasetModel f13228e;

        /* compiled from: has_umg */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(PandoraTaggedMediasetQueryModel.class, new Deserializer());
            }

            public Object m20790a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = PandoraTaggedMediasetQueryParser.m20907a(jsonParser);
                Object pandoraTaggedMediasetQueryModel = new PandoraTaggedMediasetQueryModel();
                ((BaseModel) pandoraTaggedMediasetQueryModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (pandoraTaggedMediasetQueryModel instanceof Postprocessable) {
                    return ((Postprocessable) pandoraTaggedMediasetQueryModel).a();
                }
                return pandoraTaggedMediasetQueryModel;
            }
        }

        /* compiled from: has_umg */
        public class Serializer extends JsonSerializer<PandoraTaggedMediasetQueryModel> {
            public final void m20791a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                PandoraTaggedMediasetQueryModel pandoraTaggedMediasetQueryModel = (PandoraTaggedMediasetQueryModel) obj;
                if (pandoraTaggedMediasetQueryModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(pandoraTaggedMediasetQueryModel.m20804a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    pandoraTaggedMediasetQueryModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = pandoraTaggedMediasetQueryModel.w_();
                int u_ = pandoraTaggedMediasetQueryModel.u_();
                jsonGenerator.f();
                if (mutableFlatBuffer.g(u_, 0) != 0) {
                    jsonGenerator.a("__type__");
                    SerializerHelpers.b(mutableFlatBuffer, u_, 0, jsonGenerator);
                }
                int g = mutableFlatBuffer.g(u_, 1);
                if (g != 0) {
                    jsonGenerator.a("tagged_mediaset");
                    PandoraTaggedMediasetQueryParser.TaggedMediasetParser.m20906a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(PandoraTaggedMediasetQueryModel.class, new Serializer());
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 1982519325)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: has_umg */
        public final class TaggedMediasetModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private MediaModel f13226d;

            /* compiled from: has_umg */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(TaggedMediasetModel.class, new Deserializer());
                }

                public Object m20792a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(PandoraTaggedMediasetQueryParser.TaggedMediasetParser.m20905a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object taggedMediasetModel = new TaggedMediasetModel();
                    ((BaseModel) taggedMediasetModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (taggedMediasetModel instanceof Postprocessable) {
                        return ((Postprocessable) taggedMediasetModel).a();
                    }
                    return taggedMediasetModel;
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = -1823215375)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: has_umg */
            public final class MediaModel extends BaseModel implements GraphQLVisitableModel {
                @Nullable
                private List<PandoraMediaModel> f13224d;
                @Nullable
                private DefaultPageInfoFieldsModel f13225e;

                /* compiled from: has_umg */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(MediaModel.class, new Deserializer());
                    }

                    public Object m20793a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(PandoraTaggedMediasetQueryParser.TaggedMediasetParser.MediaParser.m20903a(jsonParser, flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                        Object mediaModel = new MediaModel();
                        ((BaseModel) mediaModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                        if (mediaModel instanceof Postprocessable) {
                            return ((Postprocessable) mediaModel).a();
                        }
                        return mediaModel;
                    }
                }

                /* compiled from: has_umg */
                public class Serializer extends JsonSerializer<MediaModel> {
                    public final void m20794a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        MediaModel mediaModel = (MediaModel) obj;
                        if (mediaModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(mediaModel.m20795a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            mediaModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        PandoraTaggedMediasetQueryParser.TaggedMediasetParser.MediaParser.m20904a(mediaModel.w_(), mediaModel.u_(), jsonGenerator, serializerProvider);
                    }

                    static {
                        FbSerializerProvider.a(MediaModel.class, new Serializer());
                    }
                }

                public MediaModel() {
                    super(2);
                }

                @Nonnull
                public final ImmutableList<PandoraMediaModel> m20797a() {
                    this.f13224d = super.a(this.f13224d, 0, PandoraMediaModel.class);
                    return (ImmutableList) this.f13224d;
                }

                @Nullable
                public final DefaultPageInfoFieldsModel m20798j() {
                    this.f13225e = (DefaultPageInfoFieldsModel) super.a(this.f13225e, 1, DefaultPageInfoFieldsModel.class);
                    return this.f13225e;
                }

                public final int jK_() {
                    return 747633668;
                }

                public final GraphQLVisitableModel m20796a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    GraphQLVisitableModel graphQLVisitableModel;
                    DefaultPageInfoFieldsModel defaultPageInfoFieldsModel;
                    h();
                    if (m20797a() != null) {
                        Builder a = ModelHelper.a(m20797a(), graphQLModelMutatingVisitor);
                        if (a != null) {
                            MediaModel mediaModel = (MediaModel) ModelHelper.a(null, this);
                            mediaModel.f13224d = a.b();
                            graphQLVisitableModel = mediaModel;
                            if (m20798j() != null) {
                                defaultPageInfoFieldsModel = (DefaultPageInfoFieldsModel) graphQLModelMutatingVisitor.b(m20798j());
                                if (m20798j() != defaultPageInfoFieldsModel) {
                                    graphQLVisitableModel = (MediaModel) ModelHelper.a(graphQLVisitableModel, this);
                                    graphQLVisitableModel.f13225e = defaultPageInfoFieldsModel;
                                }
                            }
                            i();
                            return graphQLVisitableModel != null ? this : graphQLVisitableModel;
                        }
                    }
                    graphQLVisitableModel = null;
                    if (m20798j() != null) {
                        defaultPageInfoFieldsModel = (DefaultPageInfoFieldsModel) graphQLModelMutatingVisitor.b(m20798j());
                        if (m20798j() != defaultPageInfoFieldsModel) {
                            graphQLVisitableModel = (MediaModel) ModelHelper.a(graphQLVisitableModel, this);
                            graphQLVisitableModel.f13225e = defaultPageInfoFieldsModel;
                        }
                    }
                    i();
                    if (graphQLVisitableModel != null) {
                    }
                }

                public final int m20795a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int a = ModelHelper.a(flatBufferBuilder, m20797a());
                    int a2 = ModelHelper.a(flatBufferBuilder, m20798j());
                    flatBufferBuilder.c(2);
                    flatBufferBuilder.b(0, a);
                    flatBufferBuilder.b(1, a2);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            /* compiled from: has_umg */
            public class Serializer extends JsonSerializer<TaggedMediasetModel> {
                public final void m20799a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    TaggedMediasetModel taggedMediasetModel = (TaggedMediasetModel) obj;
                    if (taggedMediasetModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(taggedMediasetModel.m20800a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        taggedMediasetModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    PandoraTaggedMediasetQueryParser.TaggedMediasetParser.m20906a(taggedMediasetModel.w_(), taggedMediasetModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(TaggedMediasetModel.class, new Serializer());
                }
            }

            public TaggedMediasetModel() {
                super(1);
            }

            @Nullable
            public final MediaModel m20802a() {
                this.f13226d = (MediaModel) super.a(this.f13226d, 0, MediaModel.class);
                return this.f13226d;
            }

            public final int jK_() {
                return 685632024;
            }

            public final GraphQLVisitableModel m20801a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m20802a() != null) {
                    MediaModel mediaModel = (MediaModel) graphQLModelMutatingVisitor.b(m20802a());
                    if (m20802a() != mediaModel) {
                        graphQLVisitableModel = (TaggedMediasetModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f13226d = mediaModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m20800a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m20802a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, a);
                i();
                return flatBufferBuilder.d();
            }
        }

        public PandoraTaggedMediasetQueryModel() {
            super(2);
        }

        public final void m20807a(String str, ConsistencyTuple consistencyTuple) {
            consistencyTuple.a();
        }

        public final void m20808a(String str, Object obj, boolean z) {
        }

        @Nullable
        private GraphQLObjectType m20803j() {
            if (this.b != null && this.f13227d == null) {
                this.f13227d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
            }
            return this.f13227d;
        }

        @Nullable
        public final TaggedMediasetModel m20806a() {
            this.f13228e = (TaggedMediasetModel) super.a(this.f13228e, 1, TaggedMediasetModel.class);
            return this.f13228e;
        }

        public final int jK_() {
            return 2433570;
        }

        public final GraphQLVisitableModel m20805a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m20806a() != null) {
                TaggedMediasetModel taggedMediasetModel = (TaggedMediasetModel) graphQLModelMutatingVisitor.b(m20806a());
                if (m20806a() != taggedMediasetModel) {
                    graphQLVisitableModel = (PandoraTaggedMediasetQueryModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f13228e = taggedMediasetModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m20804a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m20803j());
            int a2 = ModelHelper.a(flatBufferBuilder, m20806a());
            flatBufferBuilder.c(2);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, a2);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 1311854640)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: has_umg */
    public final class PandoraUploadedMediaCountQueryModel extends BaseModel implements GraphQLVisitableConsistentModel {
        @Nullable
        private UploadedMediasetModel f13231d;

        /* compiled from: has_umg */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(PandoraUploadedMediaCountQueryModel.class, new Deserializer());
            }

            public Object m20809a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = PandoraUploadedMediaCountQueryParser.m20912a(jsonParser);
                Object pandoraUploadedMediaCountQueryModel = new PandoraUploadedMediaCountQueryModel();
                ((BaseModel) pandoraUploadedMediaCountQueryModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (pandoraUploadedMediaCountQueryModel instanceof Postprocessable) {
                    return ((Postprocessable) pandoraUploadedMediaCountQueryModel).a();
                }
                return pandoraUploadedMediaCountQueryModel;
            }
        }

        /* compiled from: has_umg */
        public class Serializer extends JsonSerializer<PandoraUploadedMediaCountQueryModel> {
            public final void m20810a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                PandoraUploadedMediaCountQueryModel pandoraUploadedMediaCountQueryModel = (PandoraUploadedMediaCountQueryModel) obj;
                if (pandoraUploadedMediaCountQueryModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(pandoraUploadedMediaCountQueryModel.m20822a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    pandoraUploadedMediaCountQueryModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = pandoraUploadedMediaCountQueryModel.w_();
                int u_ = pandoraUploadedMediaCountQueryModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("uploaded_mediaset");
                    UploadedMediasetParser.m20911a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(PandoraUploadedMediaCountQueryModel.class, new Serializer());
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 460951602)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: has_umg */
        public final class UploadedMediasetModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private MediaModel f13230d;

            /* compiled from: has_umg */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(UploadedMediasetModel.class, new Deserializer());
                }

                public Object m20811a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(UploadedMediasetParser.m20910a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object uploadedMediasetModel = new UploadedMediasetModel();
                    ((BaseModel) uploadedMediasetModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (uploadedMediasetModel instanceof Postprocessable) {
                        return ((Postprocessable) uploadedMediasetModel).a();
                    }
                    return uploadedMediasetModel;
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = -1723990064)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: has_umg */
            public final class MediaModel extends BaseModel implements GraphQLVisitableModel {
                private int f13229d;

                /* compiled from: has_umg */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(MediaModel.class, new Deserializer());
                    }

                    public Object m20812a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(UploadedMediasetParser.MediaParser.m20908a(jsonParser, flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                        Object mediaModel = new MediaModel();
                        ((BaseModel) mediaModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                        if (mediaModel instanceof Postprocessable) {
                            return ((Postprocessable) mediaModel).a();
                        }
                        return mediaModel;
                    }
                }

                /* compiled from: has_umg */
                public class Serializer extends JsonSerializer<MediaModel> {
                    public final void m20813a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        MediaModel mediaModel = (MediaModel) obj;
                        if (mediaModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(mediaModel.m20815a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            mediaModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        UploadedMediasetParser.MediaParser.m20909a(mediaModel.w_(), mediaModel.u_(), jsonGenerator);
                    }

                    static {
                        FbSerializerProvider.a(MediaModel.class, new Serializer());
                    }
                }

                public MediaModel() {
                    super(1);
                }

                public final int m20814a() {
                    a(0, 0);
                    return this.f13229d;
                }

                public final int jK_() {
                    return 747633668;
                }

                public final GraphQLVisitableModel m20816a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    h();
                    i();
                    return this;
                }

                public final int m20815a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.a(0, this.f13229d, 0);
                    i();
                    return flatBufferBuilder.d();
                }

                public final void m20817a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                    super.a(mutableFlatBuffer, i, obj);
                    this.f13229d = mutableFlatBuffer.a(i, 0, 0);
                }
            }

            /* compiled from: has_umg */
            public class Serializer extends JsonSerializer<UploadedMediasetModel> {
                public final void m20818a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    UploadedMediasetModel uploadedMediasetModel = (UploadedMediasetModel) obj;
                    if (uploadedMediasetModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(uploadedMediasetModel.m20819a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        uploadedMediasetModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    UploadedMediasetParser.m20911a(uploadedMediasetModel.w_(), uploadedMediasetModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(UploadedMediasetModel.class, new Serializer());
                }
            }

            public UploadedMediasetModel() {
                super(1);
            }

            @Nullable
            public final MediaModel m20821a() {
                this.f13230d = (MediaModel) super.a(this.f13230d, 0, MediaModel.class);
                return this.f13230d;
            }

            public final int jK_() {
                return -633731036;
            }

            public final GraphQLVisitableModel m20820a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m20821a() != null) {
                    MediaModel mediaModel = (MediaModel) graphQLModelMutatingVisitor.b(m20821a());
                    if (m20821a() != mediaModel) {
                        graphQLVisitableModel = (UploadedMediasetModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f13230d = mediaModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m20819a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m20821a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, a);
                i();
                return flatBufferBuilder.d();
            }
        }

        public PandoraUploadedMediaCountQueryModel() {
            super(1);
        }

        public final void m20825a(String str, ConsistencyTuple consistencyTuple) {
            consistencyTuple.a();
        }

        public final void m20826a(String str, Object obj, boolean z) {
        }

        @Nullable
        public final UploadedMediasetModel m20824a() {
            this.f13231d = (UploadedMediasetModel) super.a(this.f13231d, 0, UploadedMediasetModel.class);
            return this.f13231d;
        }

        public final int jK_() {
            return 2645995;
        }

        public final GraphQLVisitableModel m20823a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m20824a() != null) {
                UploadedMediasetModel uploadedMediasetModel = (UploadedMediasetModel) graphQLModelMutatingVisitor.b(m20824a());
                if (m20824a() != uploadedMediasetModel) {
                    graphQLVisitableModel = (PandoraUploadedMediaCountQueryModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f13231d = uploadedMediasetModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m20822a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m20824a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 2113695815)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: has_umg */
    public final class PandoraUploadedMediasetQueryModel extends BaseModel implements GraphQLVisitableConsistentModel {
        @Nullable
        private UploadedMediasetModel f13235d;

        /* compiled from: has_umg */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(PandoraUploadedMediasetQueryModel.class, new Deserializer());
            }

            public Object m20827a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = PandoraUploadedMediasetQueryParser.m20917a(jsonParser);
                Object pandoraUploadedMediasetQueryModel = new PandoraUploadedMediasetQueryModel();
                ((BaseModel) pandoraUploadedMediasetQueryModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (pandoraUploadedMediasetQueryModel instanceof Postprocessable) {
                    return ((Postprocessable) pandoraUploadedMediasetQueryModel).a();
                }
                return pandoraUploadedMediasetQueryModel;
            }
        }

        /* compiled from: has_umg */
        public class Serializer extends JsonSerializer<PandoraUploadedMediasetQueryModel> {
            public final void m20828a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                PandoraUploadedMediasetQueryModel pandoraUploadedMediasetQueryModel = (PandoraUploadedMediasetQueryModel) obj;
                if (pandoraUploadedMediasetQueryModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(pandoraUploadedMediasetQueryModel.m20840a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    pandoraUploadedMediasetQueryModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = pandoraUploadedMediasetQueryModel.w_();
                int u_ = pandoraUploadedMediasetQueryModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("uploaded_mediaset");
                    PandoraUploadedMediasetQueryParser.UploadedMediasetParser.m20916a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(PandoraUploadedMediasetQueryModel.class, new Serializer());
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -256816209)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: has_umg */
        public final class UploadedMediasetModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private MediaModel f13234d;

            /* compiled from: has_umg */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(UploadedMediasetModel.class, new Deserializer());
                }

                public Object m20829a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(PandoraUploadedMediasetQueryParser.UploadedMediasetParser.m20915a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object uploadedMediasetModel = new UploadedMediasetModel();
                    ((BaseModel) uploadedMediasetModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (uploadedMediasetModel instanceof Postprocessable) {
                        return ((Postprocessable) uploadedMediasetModel).a();
                    }
                    return uploadedMediasetModel;
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = -1823215375)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: has_umg */
            public final class MediaModel extends BaseModel implements GraphQLVisitableModel {
                @Nullable
                private List<PandoraMediaModel> f13232d;
                @Nullable
                private DefaultPageInfoFieldsModel f13233e;

                /* compiled from: has_umg */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(MediaModel.class, new Deserializer());
                    }

                    public Object m20830a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(PandoraUploadedMediasetQueryParser.UploadedMediasetParser.MediaParser.m20913a(jsonParser, flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                        Object mediaModel = new MediaModel();
                        ((BaseModel) mediaModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                        if (mediaModel instanceof Postprocessable) {
                            return ((Postprocessable) mediaModel).a();
                        }
                        return mediaModel;
                    }
                }

                /* compiled from: has_umg */
                public class Serializer extends JsonSerializer<MediaModel> {
                    public final void m20831a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        MediaModel mediaModel = (MediaModel) obj;
                        if (mediaModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(mediaModel.m20832a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            mediaModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        PandoraUploadedMediasetQueryParser.UploadedMediasetParser.MediaParser.m20914a(mediaModel.w_(), mediaModel.u_(), jsonGenerator, serializerProvider);
                    }

                    static {
                        FbSerializerProvider.a(MediaModel.class, new Serializer());
                    }
                }

                public MediaModel() {
                    super(2);
                }

                @Nonnull
                public final ImmutableList<PandoraMediaModel> m20834a() {
                    this.f13232d = super.a(this.f13232d, 0, PandoraMediaModel.class);
                    return (ImmutableList) this.f13232d;
                }

                @Nullable
                public final DefaultPageInfoFieldsModel m20835j() {
                    this.f13233e = (DefaultPageInfoFieldsModel) super.a(this.f13233e, 1, DefaultPageInfoFieldsModel.class);
                    return this.f13233e;
                }

                public final int jK_() {
                    return 747633668;
                }

                public final GraphQLVisitableModel m20833a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    GraphQLVisitableModel graphQLVisitableModel;
                    DefaultPageInfoFieldsModel defaultPageInfoFieldsModel;
                    h();
                    if (m20834a() != null) {
                        Builder a = ModelHelper.a(m20834a(), graphQLModelMutatingVisitor);
                        if (a != null) {
                            MediaModel mediaModel = (MediaModel) ModelHelper.a(null, this);
                            mediaModel.f13232d = a.b();
                            graphQLVisitableModel = mediaModel;
                            if (m20835j() != null) {
                                defaultPageInfoFieldsModel = (DefaultPageInfoFieldsModel) graphQLModelMutatingVisitor.b(m20835j());
                                if (m20835j() != defaultPageInfoFieldsModel) {
                                    graphQLVisitableModel = (MediaModel) ModelHelper.a(graphQLVisitableModel, this);
                                    graphQLVisitableModel.f13233e = defaultPageInfoFieldsModel;
                                }
                            }
                            i();
                            return graphQLVisitableModel != null ? this : graphQLVisitableModel;
                        }
                    }
                    graphQLVisitableModel = null;
                    if (m20835j() != null) {
                        defaultPageInfoFieldsModel = (DefaultPageInfoFieldsModel) graphQLModelMutatingVisitor.b(m20835j());
                        if (m20835j() != defaultPageInfoFieldsModel) {
                            graphQLVisitableModel = (MediaModel) ModelHelper.a(graphQLVisitableModel, this);
                            graphQLVisitableModel.f13233e = defaultPageInfoFieldsModel;
                        }
                    }
                    i();
                    if (graphQLVisitableModel != null) {
                    }
                }

                public final int m20832a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int a = ModelHelper.a(flatBufferBuilder, m20834a());
                    int a2 = ModelHelper.a(flatBufferBuilder, m20835j());
                    flatBufferBuilder.c(2);
                    flatBufferBuilder.b(0, a);
                    flatBufferBuilder.b(1, a2);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            /* compiled from: has_umg */
            public class Serializer extends JsonSerializer<UploadedMediasetModel> {
                public final void m20836a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    UploadedMediasetModel uploadedMediasetModel = (UploadedMediasetModel) obj;
                    if (uploadedMediasetModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(uploadedMediasetModel.m20837a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        uploadedMediasetModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    PandoraUploadedMediasetQueryParser.UploadedMediasetParser.m20916a(uploadedMediasetModel.w_(), uploadedMediasetModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(UploadedMediasetModel.class, new Serializer());
                }
            }

            public UploadedMediasetModel() {
                super(1);
            }

            @Nullable
            public final MediaModel m20839a() {
                this.f13234d = (MediaModel) super.a(this.f13234d, 0, MediaModel.class);
                return this.f13234d;
            }

            public final int jK_() {
                return -633731036;
            }

            public final GraphQLVisitableModel m20838a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m20839a() != null) {
                    MediaModel mediaModel = (MediaModel) graphQLModelMutatingVisitor.b(m20839a());
                    if (m20839a() != mediaModel) {
                        graphQLVisitableModel = (UploadedMediasetModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f13234d = mediaModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m20837a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m20839a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, a);
                i();
                return flatBufferBuilder.d();
            }
        }

        public PandoraUploadedMediasetQueryModel() {
            super(1);
        }

        public final void m20843a(String str, ConsistencyTuple consistencyTuple) {
            consistencyTuple.a();
        }

        public final void m20844a(String str, Object obj, boolean z) {
        }

        @Nullable
        public final UploadedMediasetModel m20842a() {
            this.f13235d = (UploadedMediasetModel) super.a(this.f13235d, 0, UploadedMediasetModel.class);
            return this.f13235d;
        }

        public final int jK_() {
            return 2645995;
        }

        public final GraphQLVisitableModel m20841a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m20842a() != null) {
                UploadedMediasetModel uploadedMediasetModel = (UploadedMediasetModel) graphQLModelMutatingVisitor.b(m20842a());
                if (m20842a() != uploadedMediasetModel) {
                    graphQLVisitableModel = (PandoraUploadedMediasetQueryModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f13235d = uploadedMediasetModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m20840a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m20842a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }
}
