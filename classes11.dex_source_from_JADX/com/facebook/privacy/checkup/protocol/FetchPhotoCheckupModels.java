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
import com.facebook.graphql.enums.GraphQLObjectType;
import com.facebook.graphql.model.GraphQLPrivacyOptionsContentEdge;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.querybuilder.common.CommonGraphQL2Interfaces.DefaultVect2Fields;
import com.facebook.graphql.querybuilder.common.CommonGraphQL2Models.DefaultVect2FieldsModel;
import com.facebook.graphql.querybuilder.common.CommonGraphQLInterfaces.DefaultImageFields;
import com.facebook.graphql.querybuilder.common.CommonGraphQLModels.DefaultImageFieldsModel;
import com.facebook.graphql.querybuilder.common.TextWithEntitiesGraphQLModels.DefaultTextWithEntitiesLongFieldsModel;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLPersistableNode;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.facebook.heisman.protocol.imageoverlay.ImageOverlayGraphQLModels.ImageOverlayFieldsModel;
import com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.MediaMetadataAttributionAppModel;
import com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.MediaMetadataCreationStoryModel;
import com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.MediaMetadataInlineActivitiesModel;
import com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.MediaMetadataOwnerModel;
import com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.MediaMetadataWithoutFeedbackModel.AlbumModel;
import com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.MediaMetadataWithoutFeedbackModel.ExplicitPlaceModel;
import com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.MediaMetadataWithoutFeedbackModel.PendingPlaceModel;
import com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.MediaMetadataWithoutFeedbackModel.WithTagsModel;
import com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.PhotosFaceBoxesQueryModel;
import com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.SimpleMediaFeedbackModel;
import com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.TagInfoQueryModel;
import com.facebook.photos.mediafetcher.protocol.MediaFetchQueriesModels.MediaPageInfoModel;
import com.facebook.privacy.checkup.protocol.FetchPhotoCheckupInterfaces.MediaMetadataWithCreatorPrivacyOptions;
import com.facebook.privacy.checkup.protocol.FetchPhotoCheckupParsers.FetchProfilePhotoCheckupMediaOnlyQueryParser;
import com.facebook.privacy.checkup.protocol.FetchPhotoCheckupParsers.FetchProfilePhotoCheckupQueryParser;
import com.facebook.privacy.checkup.protocol.FetchPhotoCheckupParsers.FetchProfilePhotoCheckupQueryParser.PhotoCheckupInfoParser;
import com.facebook.privacy.checkup.protocol.FetchPhotoCheckupParsers.MediaCreatorPrivacyScopeParser;
import com.facebook.privacy.checkup.protocol.FetchPhotoCheckupParsers.MediaCreatorPrivacyScopeParser.IconImageParser;
import com.facebook.privacy.checkup.protocol.FetchPhotoCheckupParsers.MediaCreatorPrivacyScopeParser.PrivacyOptionsParser;
import com.facebook.privacy.checkup.protocol.FetchPhotoCheckupParsers.MediaMetadataWithCreatorPrivacyOptionsParser;
import com.facebook.privacy.checkup.protocol.FetchPhotoCheckupParsers.PhotoCheckupPOPMediaParser;
import com.facebook.privacy.checkup.protocol.FetchPhotoCheckupParsers.PhotoCheckupPOPMediaParser.PhotosParser;
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

/* compiled from: page/{#%s}/events_list */
public class FetchPhotoCheckupModels {

    @FragmentModelWithBridge
    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -1731670523)
    @JsonSerialize(using = Serializer.class)
    /* compiled from: page/{#%s}/events_list */
    public final class FetchProfilePhotoCheckupMediaOnlyQueryModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private PhotoCheckupPOPMediaModel f4426d;

        /* compiled from: page/{#%s}/events_list */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(FetchProfilePhotoCheckupMediaOnlyQueryModel.class, new Deserializer());
            }

            public Object m5417a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = FetchProfilePhotoCheckupMediaOnlyQueryParser.m5500a(jsonParser);
                Object fetchProfilePhotoCheckupMediaOnlyQueryModel = new FetchProfilePhotoCheckupMediaOnlyQueryModel();
                ((BaseModel) fetchProfilePhotoCheckupMediaOnlyQueryModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (fetchProfilePhotoCheckupMediaOnlyQueryModel instanceof Postprocessable) {
                    return ((Postprocessable) fetchProfilePhotoCheckupMediaOnlyQueryModel).a();
                }
                return fetchProfilePhotoCheckupMediaOnlyQueryModel;
            }
        }

        /* compiled from: page/{#%s}/events_list */
        public class Serializer extends JsonSerializer<FetchProfilePhotoCheckupMediaOnlyQueryModel> {
            public final void m5418a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                FetchProfilePhotoCheckupMediaOnlyQueryModel fetchProfilePhotoCheckupMediaOnlyQueryModel = (FetchProfilePhotoCheckupMediaOnlyQueryModel) obj;
                if (fetchProfilePhotoCheckupMediaOnlyQueryModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(fetchProfilePhotoCheckupMediaOnlyQueryModel.m5419a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    fetchProfilePhotoCheckupMediaOnlyQueryModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = fetchProfilePhotoCheckupMediaOnlyQueryModel.w_();
                int u_ = fetchProfilePhotoCheckupMediaOnlyQueryModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("photo_checkup_info");
                    PhotoCheckupPOPMediaParser.m5515a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(FetchProfilePhotoCheckupMediaOnlyQueryModel.class, new Serializer());
            }
        }

        public FetchProfilePhotoCheckupMediaOnlyQueryModel() {
            super(1);
        }

        @Nullable
        public final PhotoCheckupPOPMediaModel m5421a() {
            this.f4426d = (PhotoCheckupPOPMediaModel) super.a(this.f4426d, 0, PhotoCheckupPOPMediaModel.class);
            return this.f4426d;
        }

        public final int jK_() {
            return -1732764110;
        }

        public final GraphQLVisitableModel m5420a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m5421a() != null) {
                PhotoCheckupPOPMediaModel photoCheckupPOPMediaModel = (PhotoCheckupPOPMediaModel) graphQLModelMutatingVisitor.b(m5421a());
                if (m5421a() != photoCheckupPOPMediaModel) {
                    graphQLVisitableModel = (FetchProfilePhotoCheckupMediaOnlyQueryModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f4426d = photoCheckupPOPMediaModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m5419a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m5421a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }

    @FragmentModelWithBridge
    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 1554824182)
    @JsonSerialize(using = Serializer.class)
    /* compiled from: page/{#%s}/events_list */
    public final class FetchProfilePhotoCheckupQueryModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private PhotoCheckupInfoModel f4430d;

        /* compiled from: page/{#%s}/events_list */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(FetchProfilePhotoCheckupQueryModel.class, new Deserializer());
            }

            public Object m5422a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = FetchProfilePhotoCheckupQueryParser.m5503a(jsonParser);
                Object fetchProfilePhotoCheckupQueryModel = new FetchProfilePhotoCheckupQueryModel();
                ((BaseModel) fetchProfilePhotoCheckupQueryModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (fetchProfilePhotoCheckupQueryModel instanceof Postprocessable) {
                    return ((Postprocessable) fetchProfilePhotoCheckupQueryModel).a();
                }
                return fetchProfilePhotoCheckupQueryModel;
            }
        }

        @FragmentModelWithBridge
        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 176790027)
        @JsonSerialize(using = Serializer.class)
        /* compiled from: page/{#%s}/events_list */
        public final class PhotoCheckupInfoModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private DefaultImageFieldsModel f4427d;
            @Nullable
            private DefaultImageFieldsModel f4428e;
            @Nullable
            private PhotosModel f4429f;

            /* compiled from: page/{#%s}/events_list */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(PhotoCheckupInfoModel.class, new Deserializer());
                }

                public Object m5423a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(PhotoCheckupInfoParser.m5501a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object photoCheckupInfoModel = new PhotoCheckupInfoModel();
                    ((BaseModel) photoCheckupInfoModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (photoCheckupInfoModel instanceof Postprocessable) {
                        return ((Postprocessable) photoCheckupInfoModel).a();
                    }
                    return photoCheckupInfoModel;
                }
            }

            /* compiled from: page/{#%s}/events_list */
            public class Serializer extends JsonSerializer<PhotoCheckupInfoModel> {
                public final void m5424a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    PhotoCheckupInfoModel photoCheckupInfoModel = (PhotoCheckupInfoModel) obj;
                    if (photoCheckupInfoModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(photoCheckupInfoModel.m5425a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        photoCheckupInfoModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    PhotoCheckupInfoParser.m5502a(photoCheckupInfoModel.w_(), photoCheckupInfoModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(PhotoCheckupInfoModel.class, new Serializer());
                }
            }

            public PhotoCheckupInfoModel() {
                super(3);
            }

            @Nullable
            public final DefaultImageFieldsModel m5426a() {
                this.f4427d = (DefaultImageFieldsModel) super.a(this.f4427d, 0, DefaultImageFieldsModel.class);
                return this.f4427d;
            }

            @Nullable
            public final DefaultImageFieldsModel m5428j() {
                this.f4428e = (DefaultImageFieldsModel) super.a(this.f4428e, 1, DefaultImageFieldsModel.class);
                return this.f4428e;
            }

            @Nullable
            public final PhotosModel m5429k() {
                this.f4429f = (PhotosModel) super.a(this.f4429f, 2, PhotosModel.class);
                return this.f4429f;
            }

            public final int jK_() {
                return 574380927;
            }

            public final GraphQLVisitableModel m5427a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                DefaultImageFieldsModel defaultImageFieldsModel;
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m5426a() != null) {
                    defaultImageFieldsModel = (DefaultImageFieldsModel) graphQLModelMutatingVisitor.b(m5426a());
                    if (m5426a() != defaultImageFieldsModel) {
                        graphQLVisitableModel = (PhotoCheckupInfoModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f4427d = defaultImageFieldsModel;
                    }
                }
                if (m5428j() != null) {
                    defaultImageFieldsModel = (DefaultImageFieldsModel) graphQLModelMutatingVisitor.b(m5428j());
                    if (m5428j() != defaultImageFieldsModel) {
                        graphQLVisitableModel = (PhotoCheckupInfoModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f4428e = defaultImageFieldsModel;
                    }
                }
                if (m5429k() != null) {
                    PhotosModel photosModel = (PhotosModel) graphQLModelMutatingVisitor.b(m5429k());
                    if (m5429k() != photosModel) {
                        graphQLVisitableModel = (PhotoCheckupInfoModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f4429f = photosModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m5425a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m5426a());
                int a2 = ModelHelper.a(flatBufferBuilder, m5428j());
                int a3 = ModelHelper.a(flatBufferBuilder, m5429k());
                flatBufferBuilder.c(3);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.b(1, a2);
                flatBufferBuilder.b(2, a3);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: page/{#%s}/events_list */
        public class Serializer extends JsonSerializer<FetchProfilePhotoCheckupQueryModel> {
            public final void m5430a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                FetchProfilePhotoCheckupQueryModel fetchProfilePhotoCheckupQueryModel = (FetchProfilePhotoCheckupQueryModel) obj;
                if (fetchProfilePhotoCheckupQueryModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(fetchProfilePhotoCheckupQueryModel.m5431a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    fetchProfilePhotoCheckupQueryModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = fetchProfilePhotoCheckupQueryModel.w_();
                int u_ = fetchProfilePhotoCheckupQueryModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("photo_checkup_info");
                    PhotoCheckupInfoParser.m5502a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(FetchProfilePhotoCheckupQueryModel.class, new Serializer());
            }
        }

        public FetchProfilePhotoCheckupQueryModel() {
            super(1);
        }

        @Nullable
        public final PhotoCheckupInfoModel m5433a() {
            this.f4430d = (PhotoCheckupInfoModel) super.a(this.f4430d, 0, PhotoCheckupInfoModel.class);
            return this.f4430d;
        }

        public final int jK_() {
            return -1732764110;
        }

        public final GraphQLVisitableModel m5432a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m5433a() != null) {
                PhotoCheckupInfoModel photoCheckupInfoModel = (PhotoCheckupInfoModel) graphQLModelMutatingVisitor.b(m5433a());
                if (m5433a() != photoCheckupInfoModel) {
                    graphQLVisitableModel = (FetchProfilePhotoCheckupQueryModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f4430d = photoCheckupInfoModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m5431a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m5433a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }

    @FragmentModelWithBridge
    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -128266519)
    @JsonSerialize(using = Serializer.class)
    /* compiled from: page/{#%s}/events_list */
    public final class MediaCreatorPrivacyScopeModel extends BaseModel implements GraphQLVisitableModel {
        private boolean f4433d;
        @Nullable
        private IconImageModel f4434e;
        @Nullable
        private PrivacyOptionsModel f4435f;

        /* compiled from: page/{#%s}/events_list */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(MediaCreatorPrivacyScopeModel.class, new Deserializer());
            }

            public Object m5434a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(MediaCreatorPrivacyScopeParser.m5508a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object mediaCreatorPrivacyScopeModel = new MediaCreatorPrivacyScopeModel();
                ((BaseModel) mediaCreatorPrivacyScopeModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (mediaCreatorPrivacyScopeModel instanceof Postprocessable) {
                    return ((Postprocessable) mediaCreatorPrivacyScopeModel).a();
                }
                return mediaCreatorPrivacyScopeModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 842551240)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: page/{#%s}/events_list */
        public final class IconImageModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private String f4431d;

            /* compiled from: page/{#%s}/events_list */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(IconImageModel.class, new Deserializer());
                }

                public Object m5435a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(IconImageParser.m5504a(jsonParser, flatBufferBuilder));
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

            /* compiled from: page/{#%s}/events_list */
            public class Serializer extends JsonSerializer<IconImageModel> {
                public final void m5436a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    IconImageModel iconImageModel = (IconImageModel) obj;
                    if (iconImageModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(iconImageModel.m5438a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        iconImageModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    IconImageParser.m5505a(iconImageModel.w_(), iconImageModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(IconImageModel.class, new Serializer());
                }
            }

            public IconImageModel() {
                super(1);
            }

            @Nullable
            private String m5437a() {
                this.f4431d = super.a(this.f4431d, 0);
                return this.f4431d;
            }

            public final int jK_() {
                return 70760763;
            }

            public final GraphQLVisitableModel m5439a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m5438a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m5437a());
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
        /* compiled from: page/{#%s}/events_list */
        public final class PrivacyOptionsModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private List<GraphQLPrivacyOptionsContentEdge> f4432d;

            /* compiled from: page/{#%s}/events_list */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(PrivacyOptionsModel.class, new Deserializer());
                }

                public Object m5440a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(PrivacyOptionsParser.m5506a(jsonParser, flatBufferBuilder));
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

            /* compiled from: page/{#%s}/events_list */
            public class Serializer extends JsonSerializer<PrivacyOptionsModel> {
                public final void m5441a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    PrivacyOptionsModel privacyOptionsModel = (PrivacyOptionsModel) obj;
                    if (privacyOptionsModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(privacyOptionsModel.m5442a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        privacyOptionsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    PrivacyOptionsParser.m5507a(privacyOptionsModel.w_(), privacyOptionsModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(PrivacyOptionsModel.class, new Serializer());
                }
            }

            public PrivacyOptionsModel() {
                super(1);
            }

            @Nonnull
            public final ImmutableList<GraphQLPrivacyOptionsContentEdge> m5444a() {
                this.f4432d = super.a(this.f4432d, 0, GraphQLPrivacyOptionsContentEdge.class);
                return (ImmutableList) this.f4432d;
            }

            public final int jK_() {
                return 780090561;
            }

            public final GraphQLVisitableModel m5443a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m5444a() != null) {
                    Builder a = ModelHelper.a(m5444a(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        graphQLVisitableModel = (PrivacyOptionsModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f4432d = a.b();
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m5442a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m5444a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, a);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: page/{#%s}/events_list */
        public class Serializer extends JsonSerializer<MediaCreatorPrivacyScopeModel> {
            public final void m5445a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MediaCreatorPrivacyScopeModel mediaCreatorPrivacyScopeModel = (MediaCreatorPrivacyScopeModel) obj;
                if (mediaCreatorPrivacyScopeModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(mediaCreatorPrivacyScopeModel.m5448a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mediaCreatorPrivacyScopeModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                MediaCreatorPrivacyScopeParser.m5509a(mediaCreatorPrivacyScopeModel.w_(), mediaCreatorPrivacyScopeModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(MediaCreatorPrivacyScopeModel.class, new Serializer());
            }
        }

        @Nullable
        public final /* synthetic */ PrivacyOptionsModel m5450a() {
            return m5447k();
        }

        public MediaCreatorPrivacyScopeModel() {
            super(3);
        }

        @Nullable
        private IconImageModel m5446j() {
            this.f4434e = (IconImageModel) super.a(this.f4434e, 1, IconImageModel.class);
            return this.f4434e;
        }

        @Nullable
        private PrivacyOptionsModel m5447k() {
            this.f4435f = (PrivacyOptionsModel) super.a(this.f4435f, 2, PrivacyOptionsModel.class);
            return this.f4435f;
        }

        public final int jK_() {
            return -476351540;
        }

        public final GraphQLVisitableModel m5449a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m5446j() != null) {
                IconImageModel iconImageModel = (IconImageModel) graphQLModelMutatingVisitor.b(m5446j());
                if (m5446j() != iconImageModel) {
                    graphQLVisitableModel = (MediaCreatorPrivacyScopeModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f4434e = iconImageModel;
                }
            }
            if (m5447k() != null) {
                PrivacyOptionsModel privacyOptionsModel = (PrivacyOptionsModel) graphQLModelMutatingVisitor.b(m5447k());
                if (m5447k() != privacyOptionsModel) {
                    graphQLVisitableModel = (MediaCreatorPrivacyScopeModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f4435f = privacyOptionsModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m5448a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m5446j());
            int a2 = ModelHelper.a(flatBufferBuilder, m5447k());
            flatBufferBuilder.c(3);
            flatBufferBuilder.a(0, this.f4433d);
            flatBufferBuilder.b(1, a);
            flatBufferBuilder.b(2, a2);
            i();
            return flatBufferBuilder.d();
        }

        public final void m5451a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
            super.a(mutableFlatBuffer, i, obj);
            this.f4433d = mutableFlatBuffer.a(i, 0);
        }
    }

    @FragmentModelWithBridge
    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 1976802225)
    @JsonSerialize(using = Serializer.class)
    /* compiled from: page/{#%s}/events_list */
    public final class MediaMetadataWithCreatorPrivacyOptionsModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel, MediaMetadataWithCreatorPrivacyOptions {
        @Nullable
        private DefaultImageFieldsModel f4436A;
        @Nullable
        private DefaultImageFieldsModel f4437B;
        @Nullable
        private DefaultImageFieldsModel f4438C;
        @Nullable
        private DefaultImageFieldsModel f4439D;
        @Nullable
        private DefaultImageFieldsModel f4440E;
        @Nullable
        private DefaultImageFieldsModel f4441F;
        @Nullable
        private MediaMetadataInlineActivitiesModel f4442G;
        private boolean f4443H;
        @Nullable
        private DefaultImageFieldsModel f4444I;
        @Nullable
        private DefaultTextWithEntitiesLongFieldsModel f4445J;
        @Nullable
        private MediaMetadataOwnerModel f4446K;
        @Nullable
        private PendingPlaceModel f4447L;
        private int f4448M;
        @Nullable
        private String f4449N;
        @Nullable
        private MediaCreatorPrivacyScopeModel f4450O;
        @Nullable
        private ImageOverlayFieldsModel f4451P;
        @Nullable
        private TagInfoQueryModel f4452Q;
        @Nullable
        private WithTagsModel f4453R;
        @Nullable
        private GraphQLObjectType f4454d;
        @Nullable
        private AlbumModel f4455e;
        @Nullable
        private MediaMetadataAttributionAppModel f4456f;
        @Nullable
        private String f4457g;
        private boolean f4458h;
        private boolean f4459i;
        private boolean f4460j;
        private boolean f4461k;
        private boolean f4462l;
        private boolean f4463m;
        private boolean f4464n;
        private boolean f4465o;
        private boolean f4466p;
        private boolean f4467q;
        private long f4468r;
        @Nullable
        private MediaMetadataCreationStoryModel f4469s;
        @Nullable
        private ExplicitPlaceModel f4470t;
        @Nullable
        private PhotosFaceBoxesQueryModel f4471u;
        @Nullable
        private SimpleMediaFeedbackModel f4472v;
        @Nullable
        private DefaultVect2FieldsModel f4473w;
        private boolean f4474x;
        @Nullable
        private String f4475y;
        @Nullable
        private String f4476z;

        /* compiled from: page/{#%s}/events_list */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(MediaMetadataWithCreatorPrivacyOptionsModel.class, new Deserializer());
            }

            public Object m5452a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(MediaMetadataWithCreatorPrivacyOptionsParser.m5510b(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object mediaMetadataWithCreatorPrivacyOptionsModel = new MediaMetadataWithCreatorPrivacyOptionsModel();
                ((BaseModel) mediaMetadataWithCreatorPrivacyOptionsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (mediaMetadataWithCreatorPrivacyOptionsModel instanceof Postprocessable) {
                    return ((Postprocessable) mediaMetadataWithCreatorPrivacyOptionsModel).a();
                }
                return mediaMetadataWithCreatorPrivacyOptionsModel;
            }
        }

        /* compiled from: page/{#%s}/events_list */
        public class Serializer extends JsonSerializer<MediaMetadataWithCreatorPrivacyOptionsModel> {
            public final void m5453a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MediaMetadataWithCreatorPrivacyOptionsModel mediaMetadataWithCreatorPrivacyOptionsModel = (MediaMetadataWithCreatorPrivacyOptionsModel) obj;
                if (mediaMetadataWithCreatorPrivacyOptionsModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(mediaMetadataWithCreatorPrivacyOptionsModel.m5479a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mediaMetadataWithCreatorPrivacyOptionsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                MediaMetadataWithCreatorPrivacyOptionsParser.m5511b(mediaMetadataWithCreatorPrivacyOptionsModel.w_(), mediaMetadataWithCreatorPrivacyOptionsModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(MediaMetadataWithCreatorPrivacyOptionsModel.class, new Serializer());
            }
        }

        @Nullable
        public final /* synthetic */ DefaultImageFields bc_() {
            return m5477y();
        }

        @Nullable
        public final /* synthetic */ DefaultImageFields bd_() {
            return m5476x();
        }

        @Nullable
        public final /* synthetic */ DefaultImageFields be_() {
            return m5473u();
        }

        @Nullable
        public final /* synthetic */ DefaultVect2Fields m5484c() {
            return m5471s();
        }

        @Nullable
        public final /* synthetic */ DefaultImageFields m5486g() {
            return m5474v();
        }

        @Nullable
        public final /* synthetic */ MediaCreatorPrivacyScopeModel m5488k() {
            return m5460G();
        }

        public MediaMetadataWithCreatorPrivacyOptionsModel() {
            super(41);
        }

        @Nullable
        public final GraphQLObjectType m5483b() {
            if (this.b != null && this.f4454d == null) {
                this.f4454d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
            }
            return this.f4454d;
        }

        @Nullable
        private AlbumModel m5464l() {
            this.f4455e = (AlbumModel) super.a(this.f4455e, 1, AlbumModel.class);
            return this.f4455e;
        }

        @Nullable
        private MediaMetadataAttributionAppModel m5465m() {
            this.f4456f = (MediaMetadataAttributionAppModel) super.a(this.f4456f, 2, MediaMetadataAttributionAppModel.class);
            return this.f4456f;
        }

        @Nullable
        private String m5466n() {
            this.f4457g = super.a(this.f4457g, 3);
            return this.f4457g;
        }

        public final long m5487j() {
            a(1, 6);
            return this.f4468r;
        }

        @Nullable
        private MediaMetadataCreationStoryModel m5467o() {
            this.f4469s = (MediaMetadataCreationStoryModel) super.a(this.f4469s, 15, MediaMetadataCreationStoryModel.class);
            return this.f4469s;
        }

        @Nullable
        private ExplicitPlaceModel m5468p() {
            this.f4470t = (ExplicitPlaceModel) super.a(this.f4470t, 16, ExplicitPlaceModel.class);
            return this.f4470t;
        }

        @Nullable
        private PhotosFaceBoxesQueryModel m5469q() {
            this.f4471u = (PhotosFaceBoxesQueryModel) super.a(this.f4471u, 17, PhotosFaceBoxesQueryModel.class);
            return this.f4471u;
        }

        @Nullable
        private SimpleMediaFeedbackModel m5470r() {
            this.f4472v = (SimpleMediaFeedbackModel) super.a(this.f4472v, 18, SimpleMediaFeedbackModel.class);
            return this.f4472v;
        }

        @Nullable
        private DefaultVect2FieldsModel m5471s() {
            this.f4473w = (DefaultVect2FieldsModel) super.a(this.f4473w, 19, DefaultVect2FieldsModel.class);
            return this.f4473w;
        }

        @Nullable
        private String m5472t() {
            this.f4475y = super.a(this.f4475y, 21);
            return this.f4475y;
        }

        @Nullable
        public final String m5485d() {
            this.f4476z = super.a(this.f4476z, 22);
            return this.f4476z;
        }

        @Nullable
        private DefaultImageFieldsModel m5473u() {
            this.f4436A = (DefaultImageFieldsModel) super.a(this.f4436A, 23, DefaultImageFieldsModel.class);
            return this.f4436A;
        }

        @Nullable
        private DefaultImageFieldsModel m5474v() {
            this.f4437B = (DefaultImageFieldsModel) super.a(this.f4437B, 24, DefaultImageFieldsModel.class);
            return this.f4437B;
        }

        @Nullable
        private DefaultImageFieldsModel m5475w() {
            this.f4438C = (DefaultImageFieldsModel) super.a(this.f4438C, 25, DefaultImageFieldsModel.class);
            return this.f4438C;
        }

        @Nullable
        private DefaultImageFieldsModel m5476x() {
            this.f4439D = (DefaultImageFieldsModel) super.a(this.f4439D, 26, DefaultImageFieldsModel.class);
            return this.f4439D;
        }

        @Nullable
        private DefaultImageFieldsModel m5477y() {
            this.f4440E = (DefaultImageFieldsModel) super.a(this.f4440E, 27, DefaultImageFieldsModel.class);
            return this.f4440E;
        }

        @Nullable
        private DefaultImageFieldsModel m5478z() {
            this.f4441F = (DefaultImageFieldsModel) super.a(this.f4441F, 28, DefaultImageFieldsModel.class);
            return this.f4441F;
        }

        @Nullable
        private MediaMetadataInlineActivitiesModel m5454A() {
            this.f4442G = (MediaMetadataInlineActivitiesModel) super.a(this.f4442G, 29, MediaMetadataInlineActivitiesModel.class);
            return this.f4442G;
        }

        @Nullable
        private DefaultImageFieldsModel m5455B() {
            this.f4444I = (DefaultImageFieldsModel) super.a(this.f4444I, 31, DefaultImageFieldsModel.class);
            return this.f4444I;
        }

        @Nullable
        private DefaultTextWithEntitiesLongFieldsModel m5456C() {
            this.f4445J = (DefaultTextWithEntitiesLongFieldsModel) super.a(this.f4445J, 32, DefaultTextWithEntitiesLongFieldsModel.class);
            return this.f4445J;
        }

        @Nullable
        private MediaMetadataOwnerModel m5457D() {
            this.f4446K = (MediaMetadataOwnerModel) super.a(this.f4446K, 33, MediaMetadataOwnerModel.class);
            return this.f4446K;
        }

        @Nullable
        private PendingPlaceModel m5458E() {
            this.f4447L = (PendingPlaceModel) super.a(this.f4447L, 34, PendingPlaceModel.class);
            return this.f4447L;
        }

        @Nullable
        private String m5459F() {
            this.f4449N = super.a(this.f4449N, 36);
            return this.f4449N;
        }

        @Nullable
        private MediaCreatorPrivacyScopeModel m5460G() {
            this.f4450O = (MediaCreatorPrivacyScopeModel) super.a(this.f4450O, 37, MediaCreatorPrivacyScopeModel.class);
            return this.f4450O;
        }

        @Nullable
        private ImageOverlayFieldsModel m5461H() {
            this.f4451P = (ImageOverlayFieldsModel) super.a(this.f4451P, 38, ImageOverlayFieldsModel.class);
            return this.f4451P;
        }

        @Nullable
        private TagInfoQueryModel m5462I() {
            this.f4452Q = (TagInfoQueryModel) super.a(this.f4452Q, 39, TagInfoQueryModel.class);
            return this.f4452Q;
        }

        @Nullable
        private WithTagsModel m5463J() {
            this.f4453R = (WithTagsModel) super.a(this.f4453R, 40, WithTagsModel.class);
            return this.f4453R;
        }

        @Nullable
        public final String m5481a() {
            return m5485d();
        }

        public final int jK_() {
            return 74219460;
        }

        public final GraphQLVisitableModel m5480a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            DefaultImageFieldsModel defaultImageFieldsModel;
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m5464l() != null) {
                AlbumModel albumModel = (AlbumModel) graphQLModelMutatingVisitor.b(m5464l());
                if (m5464l() != albumModel) {
                    graphQLVisitableModel = (MediaMetadataWithCreatorPrivacyOptionsModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f4455e = albumModel;
                }
            }
            if (m5465m() != null) {
                MediaMetadataAttributionAppModel mediaMetadataAttributionAppModel = (MediaMetadataAttributionAppModel) graphQLModelMutatingVisitor.b(m5465m());
                if (m5465m() != mediaMetadataAttributionAppModel) {
                    graphQLVisitableModel = (MediaMetadataWithCreatorPrivacyOptionsModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f4456f = mediaMetadataAttributionAppModel;
                }
            }
            if (m5467o() != null) {
                MediaMetadataCreationStoryModel mediaMetadataCreationStoryModel = (MediaMetadataCreationStoryModel) graphQLModelMutatingVisitor.b(m5467o());
                if (m5467o() != mediaMetadataCreationStoryModel) {
                    graphQLVisitableModel = (MediaMetadataWithCreatorPrivacyOptionsModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f4469s = mediaMetadataCreationStoryModel;
                }
            }
            if (m5468p() != null) {
                ExplicitPlaceModel explicitPlaceModel = (ExplicitPlaceModel) graphQLModelMutatingVisitor.b(m5468p());
                if (m5468p() != explicitPlaceModel) {
                    graphQLVisitableModel = (MediaMetadataWithCreatorPrivacyOptionsModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f4470t = explicitPlaceModel;
                }
            }
            if (m5469q() != null) {
                PhotosFaceBoxesQueryModel photosFaceBoxesQueryModel = (PhotosFaceBoxesQueryModel) graphQLModelMutatingVisitor.b(m5469q());
                if (m5469q() != photosFaceBoxesQueryModel) {
                    graphQLVisitableModel = (MediaMetadataWithCreatorPrivacyOptionsModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f4471u = photosFaceBoxesQueryModel;
                }
            }
            if (m5470r() != null) {
                SimpleMediaFeedbackModel simpleMediaFeedbackModel = (SimpleMediaFeedbackModel) graphQLModelMutatingVisitor.b(m5470r());
                if (m5470r() != simpleMediaFeedbackModel) {
                    graphQLVisitableModel = (MediaMetadataWithCreatorPrivacyOptionsModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f4472v = simpleMediaFeedbackModel;
                }
            }
            if (m5471s() != null) {
                DefaultVect2FieldsModel defaultVect2FieldsModel = (DefaultVect2FieldsModel) graphQLModelMutatingVisitor.b(m5471s());
                if (m5471s() != defaultVect2FieldsModel) {
                    graphQLVisitableModel = (MediaMetadataWithCreatorPrivacyOptionsModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f4473w = defaultVect2FieldsModel;
                }
            }
            if (m5473u() != null) {
                defaultImageFieldsModel = (DefaultImageFieldsModel) graphQLModelMutatingVisitor.b(m5473u());
                if (m5473u() != defaultImageFieldsModel) {
                    graphQLVisitableModel = (MediaMetadataWithCreatorPrivacyOptionsModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f4436A = defaultImageFieldsModel;
                }
            }
            if (m5474v() != null) {
                defaultImageFieldsModel = (DefaultImageFieldsModel) graphQLModelMutatingVisitor.b(m5474v());
                if (m5474v() != defaultImageFieldsModel) {
                    graphQLVisitableModel = (MediaMetadataWithCreatorPrivacyOptionsModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f4437B = defaultImageFieldsModel;
                }
            }
            if (m5475w() != null) {
                defaultImageFieldsModel = (DefaultImageFieldsModel) graphQLModelMutatingVisitor.b(m5475w());
                if (m5475w() != defaultImageFieldsModel) {
                    graphQLVisitableModel = (MediaMetadataWithCreatorPrivacyOptionsModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f4438C = defaultImageFieldsModel;
                }
            }
            if (m5476x() != null) {
                defaultImageFieldsModel = (DefaultImageFieldsModel) graphQLModelMutatingVisitor.b(m5476x());
                if (m5476x() != defaultImageFieldsModel) {
                    graphQLVisitableModel = (MediaMetadataWithCreatorPrivacyOptionsModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f4439D = defaultImageFieldsModel;
                }
            }
            if (m5477y() != null) {
                defaultImageFieldsModel = (DefaultImageFieldsModel) graphQLModelMutatingVisitor.b(m5477y());
                if (m5477y() != defaultImageFieldsModel) {
                    graphQLVisitableModel = (MediaMetadataWithCreatorPrivacyOptionsModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f4440E = defaultImageFieldsModel;
                }
            }
            if (m5478z() != null) {
                defaultImageFieldsModel = (DefaultImageFieldsModel) graphQLModelMutatingVisitor.b(m5478z());
                if (m5478z() != defaultImageFieldsModel) {
                    graphQLVisitableModel = (MediaMetadataWithCreatorPrivacyOptionsModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f4441F = defaultImageFieldsModel;
                }
            }
            if (m5454A() != null) {
                MediaMetadataInlineActivitiesModel mediaMetadataInlineActivitiesModel = (MediaMetadataInlineActivitiesModel) graphQLModelMutatingVisitor.b(m5454A());
                if (m5454A() != mediaMetadataInlineActivitiesModel) {
                    graphQLVisitableModel = (MediaMetadataWithCreatorPrivacyOptionsModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f4442G = mediaMetadataInlineActivitiesModel;
                }
            }
            if (m5455B() != null) {
                defaultImageFieldsModel = (DefaultImageFieldsModel) graphQLModelMutatingVisitor.b(m5455B());
                if (m5455B() != defaultImageFieldsModel) {
                    graphQLVisitableModel = (MediaMetadataWithCreatorPrivacyOptionsModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f4444I = defaultImageFieldsModel;
                }
            }
            if (m5456C() != null) {
                DefaultTextWithEntitiesLongFieldsModel defaultTextWithEntitiesLongFieldsModel = (DefaultTextWithEntitiesLongFieldsModel) graphQLModelMutatingVisitor.b(m5456C());
                if (m5456C() != defaultTextWithEntitiesLongFieldsModel) {
                    graphQLVisitableModel = (MediaMetadataWithCreatorPrivacyOptionsModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f4445J = defaultTextWithEntitiesLongFieldsModel;
                }
            }
            if (m5457D() != null) {
                MediaMetadataOwnerModel mediaMetadataOwnerModel = (MediaMetadataOwnerModel) graphQLModelMutatingVisitor.b(m5457D());
                if (m5457D() != mediaMetadataOwnerModel) {
                    graphQLVisitableModel = (MediaMetadataWithCreatorPrivacyOptionsModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f4446K = mediaMetadataOwnerModel;
                }
            }
            if (m5458E() != null) {
                PendingPlaceModel pendingPlaceModel = (PendingPlaceModel) graphQLModelMutatingVisitor.b(m5458E());
                if (m5458E() != pendingPlaceModel) {
                    graphQLVisitableModel = (MediaMetadataWithCreatorPrivacyOptionsModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f4447L = pendingPlaceModel;
                }
            }
            if (m5460G() != null) {
                MediaCreatorPrivacyScopeModel mediaCreatorPrivacyScopeModel = (MediaCreatorPrivacyScopeModel) graphQLModelMutatingVisitor.b(m5460G());
                if (m5460G() != mediaCreatorPrivacyScopeModel) {
                    graphQLVisitableModel = (MediaMetadataWithCreatorPrivacyOptionsModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f4450O = mediaCreatorPrivacyScopeModel;
                }
            }
            if (m5461H() != null) {
                ImageOverlayFieldsModel imageOverlayFieldsModel = (ImageOverlayFieldsModel) graphQLModelMutatingVisitor.b(m5461H());
                if (m5461H() != imageOverlayFieldsModel) {
                    graphQLVisitableModel = (MediaMetadataWithCreatorPrivacyOptionsModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f4451P = imageOverlayFieldsModel;
                }
            }
            if (m5462I() != null) {
                TagInfoQueryModel tagInfoQueryModel = (TagInfoQueryModel) graphQLModelMutatingVisitor.b(m5462I());
                if (m5462I() != tagInfoQueryModel) {
                    graphQLVisitableModel = (MediaMetadataWithCreatorPrivacyOptionsModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f4452Q = tagInfoQueryModel;
                }
            }
            if (m5463J() != null) {
                WithTagsModel withTagsModel = (WithTagsModel) graphQLModelMutatingVisitor.b(m5463J());
                if (m5463J() != withTagsModel) {
                    graphQLVisitableModel = (MediaMetadataWithCreatorPrivacyOptionsModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f4453R = withTagsModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m5479a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m5483b());
            int a2 = ModelHelper.a(flatBufferBuilder, m5464l());
            int a3 = ModelHelper.a(flatBufferBuilder, m5465m());
            int b = flatBufferBuilder.b(m5466n());
            int a4 = ModelHelper.a(flatBufferBuilder, m5467o());
            int a5 = ModelHelper.a(flatBufferBuilder, m5468p());
            int a6 = ModelHelper.a(flatBufferBuilder, m5469q());
            int a7 = ModelHelper.a(flatBufferBuilder, m5470r());
            int a8 = ModelHelper.a(flatBufferBuilder, m5471s());
            int b2 = flatBufferBuilder.b(m5472t());
            int b3 = flatBufferBuilder.b(m5485d());
            int a9 = ModelHelper.a(flatBufferBuilder, m5473u());
            int a10 = ModelHelper.a(flatBufferBuilder, m5474v());
            int a11 = ModelHelper.a(flatBufferBuilder, m5475w());
            int a12 = ModelHelper.a(flatBufferBuilder, m5476x());
            int a13 = ModelHelper.a(flatBufferBuilder, m5477y());
            int a14 = ModelHelper.a(flatBufferBuilder, m5478z());
            int a15 = ModelHelper.a(flatBufferBuilder, m5454A());
            int a16 = ModelHelper.a(flatBufferBuilder, m5455B());
            int a17 = ModelHelper.a(flatBufferBuilder, m5456C());
            int a18 = ModelHelper.a(flatBufferBuilder, m5457D());
            int a19 = ModelHelper.a(flatBufferBuilder, m5458E());
            int b4 = flatBufferBuilder.b(m5459F());
            int a20 = ModelHelper.a(flatBufferBuilder, m5460G());
            int a21 = ModelHelper.a(flatBufferBuilder, m5461H());
            int a22 = ModelHelper.a(flatBufferBuilder, m5462I());
            int a23 = ModelHelper.a(flatBufferBuilder, m5463J());
            flatBufferBuilder.c(41);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, a2);
            flatBufferBuilder.b(2, a3);
            flatBufferBuilder.b(3, b);
            flatBufferBuilder.a(4, this.f4458h);
            flatBufferBuilder.a(5, this.f4459i);
            flatBufferBuilder.a(6, this.f4460j);
            flatBufferBuilder.a(7, this.f4461k);
            flatBufferBuilder.a(8, this.f4462l);
            flatBufferBuilder.a(9, this.f4463m);
            flatBufferBuilder.a(10, this.f4464n);
            flatBufferBuilder.a(11, this.f4465o);
            flatBufferBuilder.a(12, this.f4466p);
            flatBufferBuilder.a(13, this.f4467q);
            flatBufferBuilder.a(14, this.f4468r, 0);
            flatBufferBuilder.b(15, a4);
            flatBufferBuilder.b(16, a5);
            flatBufferBuilder.b(17, a6);
            flatBufferBuilder.b(18, a7);
            flatBufferBuilder.b(19, a8);
            flatBufferBuilder.a(20, this.f4474x);
            flatBufferBuilder.b(21, b2);
            flatBufferBuilder.b(22, b3);
            flatBufferBuilder.b(23, a9);
            flatBufferBuilder.b(24, a10);
            flatBufferBuilder.b(25, a11);
            flatBufferBuilder.b(26, a12);
            flatBufferBuilder.b(27, a13);
            flatBufferBuilder.b(28, a14);
            flatBufferBuilder.b(29, a15);
            flatBufferBuilder.a(30, this.f4443H);
            flatBufferBuilder.b(31, a16);
            flatBufferBuilder.b(32, a17);
            flatBufferBuilder.b(33, a18);
            flatBufferBuilder.b(34, a19);
            flatBufferBuilder.a(35, this.f4448M, 0);
            flatBufferBuilder.b(36, b4);
            flatBufferBuilder.b(37, a20);
            flatBufferBuilder.b(38, a21);
            flatBufferBuilder.b(39, a22);
            flatBufferBuilder.b(40, a23);
            i();
            return flatBufferBuilder.d();
        }

        public final void m5482a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
            super.a(mutableFlatBuffer, i, obj);
            this.f4458h = mutableFlatBuffer.a(i, 4);
            this.f4459i = mutableFlatBuffer.a(i, 5);
            this.f4460j = mutableFlatBuffer.a(i, 6);
            this.f4461k = mutableFlatBuffer.a(i, 7);
            this.f4462l = mutableFlatBuffer.a(i, 8);
            this.f4463m = mutableFlatBuffer.a(i, 9);
            this.f4464n = mutableFlatBuffer.a(i, 10);
            this.f4465o = mutableFlatBuffer.a(i, 11);
            this.f4466p = mutableFlatBuffer.a(i, 12);
            this.f4467q = mutableFlatBuffer.a(i, 13);
            this.f4468r = mutableFlatBuffer.a(i, 14, 0);
            this.f4474x = mutableFlatBuffer.a(i, 20);
            this.f4443H = mutableFlatBuffer.a(i, 30);
            this.f4448M = mutableFlatBuffer.a(i, 35, 0);
        }
    }

    @FragmentModelWithBridge
    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 702306727)
    @JsonSerialize(using = Serializer.class)
    /* compiled from: page/{#%s}/events_list */
    public final class PhotoCheckupPOPMediaModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private PhotosModel f4479d;

        /* compiled from: page/{#%s}/events_list */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(PhotoCheckupPOPMediaModel.class, new Deserializer());
            }

            public Object m5489a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(PhotoCheckupPOPMediaParser.m5514a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object photoCheckupPOPMediaModel = new PhotoCheckupPOPMediaModel();
                ((BaseModel) photoCheckupPOPMediaModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (photoCheckupPOPMediaModel instanceof Postprocessable) {
                    return ((Postprocessable) photoCheckupPOPMediaModel).a();
                }
                return photoCheckupPOPMediaModel;
            }
        }

        @FragmentModelWithBridge
        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -701644447)
        @JsonSerialize(using = Serializer.class)
        /* compiled from: page/{#%s}/events_list */
        public final class PhotosModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private List<MediaMetadataWithCreatorPrivacyOptionsModel> f4477d;
            @Nullable
            private MediaPageInfoModel f4478e;

            /* compiled from: page/{#%s}/events_list */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(PhotosModel.class, new Deserializer());
                }

                public Object m5490a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(PhotosParser.m5512a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object photosModel = new PhotosModel();
                    ((BaseModel) photosModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (photosModel instanceof Postprocessable) {
                        return ((Postprocessable) photosModel).a();
                    }
                    return photosModel;
                }
            }

            /* compiled from: page/{#%s}/events_list */
            public class Serializer extends JsonSerializer<PhotosModel> {
                public final void m5491a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    PhotosModel photosModel = (PhotosModel) obj;
                    if (photosModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(photosModel.m5492a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        photosModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    PhotosParser.m5513a(photosModel.w_(), photosModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(PhotosModel.class, new Serializer());
                }
            }

            public PhotosModel() {
                super(2);
            }

            @Nonnull
            public final ImmutableList<MediaMetadataWithCreatorPrivacyOptionsModel> m5494a() {
                this.f4477d = super.a(this.f4477d, 0, MediaMetadataWithCreatorPrivacyOptionsModel.class);
                return (ImmutableList) this.f4477d;
            }

            @Nullable
            public final MediaPageInfoModel m5495j() {
                this.f4478e = (MediaPageInfoModel) super.a(this.f4478e, 1, MediaPageInfoModel.class);
                return this.f4478e;
            }

            public final int jK_() {
                return -198762743;
            }

            public final GraphQLVisitableModel m5493a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel;
                MediaPageInfoModel mediaPageInfoModel;
                h();
                if (m5494a() != null) {
                    Builder a = ModelHelper.a(m5494a(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        PhotosModel photosModel = (PhotosModel) ModelHelper.a(null, this);
                        photosModel.f4477d = a.b();
                        graphQLVisitableModel = photosModel;
                        if (m5495j() != null) {
                            mediaPageInfoModel = (MediaPageInfoModel) graphQLModelMutatingVisitor.b(m5495j());
                            if (m5495j() != mediaPageInfoModel) {
                                graphQLVisitableModel = (PhotosModel) ModelHelper.a(graphQLVisitableModel, this);
                                graphQLVisitableModel.f4478e = mediaPageInfoModel;
                            }
                        }
                        i();
                        return graphQLVisitableModel != null ? this : graphQLVisitableModel;
                    }
                }
                graphQLVisitableModel = null;
                if (m5495j() != null) {
                    mediaPageInfoModel = (MediaPageInfoModel) graphQLModelMutatingVisitor.b(m5495j());
                    if (m5495j() != mediaPageInfoModel) {
                        graphQLVisitableModel = (PhotosModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f4478e = mediaPageInfoModel;
                    }
                }
                i();
                if (graphQLVisitableModel != null) {
                }
            }

            public final int m5492a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m5494a());
                int a2 = ModelHelper.a(flatBufferBuilder, m5495j());
                flatBufferBuilder.c(2);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.b(1, a2);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: page/{#%s}/events_list */
        public class Serializer extends JsonSerializer<PhotoCheckupPOPMediaModel> {
            public final void m5496a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                PhotoCheckupPOPMediaModel photoCheckupPOPMediaModel = (PhotoCheckupPOPMediaModel) obj;
                if (photoCheckupPOPMediaModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(photoCheckupPOPMediaModel.m5497a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    photoCheckupPOPMediaModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                PhotoCheckupPOPMediaParser.m5515a(photoCheckupPOPMediaModel.w_(), photoCheckupPOPMediaModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(PhotoCheckupPOPMediaModel.class, new Serializer());
            }
        }

        public PhotoCheckupPOPMediaModel() {
            super(1);
        }

        @Nullable
        public final PhotosModel m5499a() {
            this.f4479d = (PhotosModel) super.a(this.f4479d, 0, PhotosModel.class);
            return this.f4479d;
        }

        public final int jK_() {
            return 574380927;
        }

        public final GraphQLVisitableModel m5498a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m5499a() != null) {
                PhotosModel photosModel = (PhotosModel) graphQLModelMutatingVisitor.b(m5499a());
                if (m5499a() != photosModel) {
                    graphQLVisitableModel = (PhotoCheckupPOPMediaModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f4479d = photosModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m5497a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m5499a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }
}
