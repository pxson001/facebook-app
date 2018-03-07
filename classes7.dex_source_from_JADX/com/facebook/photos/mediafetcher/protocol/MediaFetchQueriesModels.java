package com.facebook.photos.mediafetcher.protocol;

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
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.modelutil.SerializerHelpers;
import com.facebook.graphql.querybuilder.common.CommonGraphQL2Interfaces.DefaultPageInfoFields;
import com.facebook.graphql.querybuilder.common.CommonGraphQLInterfaces.DefaultImageFields;
import com.facebook.graphql.querybuilder.common.CommonGraphQLModels.DefaultImageFieldsModel;
import com.facebook.graphql.querybuilder.common.CommonGraphQLParsers.DefaultImageFieldsParser;
import com.facebook.graphql.visitor.ConsistencyTuple;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLVisitableConsistentModel;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.facebook.photos.data.protocol.PhotosMetadataGraphQLInterfaces.MediaMetadata;
import com.facebook.photos.data.protocol.PhotosMetadataGraphQLInterfaces.PageMediaWithAttribution;
import com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.MediaMetadataModel;
import com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.PageMediaWithAttributionModel;
import com.facebook.photos.mediafetcher.protocol.MediaFetchQueriesParsers.MediaFetchForPhotosTakenHereParser;
import com.facebook.photos.mediafetcher.protocol.MediaFetchQueriesParsers.MediaFetchForPhotosTakenHereParser.PhotosTakenHereParser;
import com.facebook.photos.mediafetcher.protocol.MediaFetchQueriesParsers.MediaFetchForPhotosTakenOfParser;
import com.facebook.photos.mediafetcher.protocol.MediaFetchQueriesParsers.MediaFetchForPhotosTakenOfParser.PhotosTakenOfParser;
import com.facebook.photos.mediafetcher.protocol.MediaFetchQueriesParsers.MediaFetchForPostedPhotosParser;
import com.facebook.photos.mediafetcher.protocol.MediaFetchQueriesParsers.MediaFetchForPostedPhotosParser.PostedPhotosParser;
import com.facebook.photos.mediafetcher.protocol.MediaFetchQueriesParsers.MediaFetchForProfilePictureParser;
import com.facebook.photos.mediafetcher.protocol.MediaFetchQueriesParsers.MediaFetchFromMediaSetIdParser;
import com.facebook.photos.mediafetcher.protocol.MediaFetchQueriesParsers.MediaFetchFromMediaSetIdParser.MediaParser;
import com.facebook.photos.mediafetcher.protocol.MediaFetchQueriesParsers.MediaFetchFromMediaSetTokenParser;
import com.facebook.photos.mediafetcher.protocol.MediaFetchQueriesParsers.MediaFetchFromReactionStoryParser;
import com.facebook.photos.mediafetcher.protocol.MediaFetchQueriesParsers.MediaFetchFromReactionStoryParser.ReactionAttachmentsParser;
import com.facebook.photos.mediafetcher.protocol.MediaFetchQueriesParsers.MediaFetchFromReactionStoryParser.ReactionAttachmentsParser.NodesParser;
import com.facebook.photos.mediafetcher.protocol.MediaFetchQueriesParsers.MediaFetchFromStoryParser;
import com.facebook.photos.mediafetcher.protocol.MediaFetchQueriesParsers.MediaFetchFromStoryParser.AttachmentsParser;
import com.facebook.photos.mediafetcher.protocol.MediaFetchQueriesParsers.MediaFetchFromStoryParser.AttachmentsParser.SubattachmentsParser;
import com.facebook.photos.mediafetcher.protocol.MediaFetchQueriesParsers.MediaFetchPageMenusParser;
import com.facebook.photos.mediafetcher.protocol.MediaFetchQueriesParsers.MediaFetchPageMenusParser.PagePhotoMenusParser;
import com.facebook.photos.mediafetcher.protocol.MediaFetchQueriesParsers.MediaFetchPageMenusParser.PagePhotoMenusParser.NodesParser.PagePhotoMenuPhotosParser;
import com.facebook.photos.mediafetcher.protocol.MediaFetchQueriesParsers.MediaFetchPhotosByCategoryParser;
import com.facebook.photos.mediafetcher.protocol.MediaFetchQueriesParsers.MediaFetchPhotosByCategoryParser.PhotosByCategoryParser;
import com.facebook.photos.mediafetcher.protocol.MediaFetchQueriesParsers.MediaPageInfoParser;
import com.facebook.photos.mediafetcher.protocol.MediaFetchQueriesParsers.MediaWithAttributionFetchFromReactionStoryParser;
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

/* compiled from: last active */
public class MediaFetchQueriesModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -1760523853)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: last active */
    public final class MediaFetchForPhotosTakenHereModel extends BaseModel implements GraphQLVisitableConsistentModel {
        @Nullable
        private PhotosTakenHereModel f10560d;

        /* compiled from: last active */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(MediaFetchForPhotosTakenHereModel.class, new Deserializer());
            }

            public Object m12443a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = MediaFetchForPhotosTakenHereParser.m12640a(jsonParser);
                Object mediaFetchForPhotosTakenHereModel = new MediaFetchForPhotosTakenHereModel();
                ((BaseModel) mediaFetchForPhotosTakenHereModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (mediaFetchForPhotosTakenHereModel instanceof Postprocessable) {
                    return ((Postprocessable) mediaFetchForPhotosTakenHereModel).a();
                }
                return mediaFetchForPhotosTakenHereModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1122935727)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: last active */
        public final class PhotosTakenHereModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private List<MediaMetadataModel> f10558d;
            @Nullable
            private MediaPageInfoModel f10559e;

            /* compiled from: last active */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(PhotosTakenHereModel.class, new Deserializer());
                }

                public Object m12444a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(PhotosTakenHereParser.m12638a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object photosTakenHereModel = new PhotosTakenHereModel();
                    ((BaseModel) photosTakenHereModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (photosTakenHereModel instanceof Postprocessable) {
                        return ((Postprocessable) photosTakenHereModel).a();
                    }
                    return photosTakenHereModel;
                }
            }

            /* compiled from: last active */
            public class Serializer extends JsonSerializer<PhotosTakenHereModel> {
                public final void m12445a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    PhotosTakenHereModel photosTakenHereModel = (PhotosTakenHereModel) obj;
                    if (photosTakenHereModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(photosTakenHereModel.m12447a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        photosTakenHereModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    PhotosTakenHereParser.m12639a(photosTakenHereModel.w_(), photosTakenHereModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(PhotosTakenHereModel.class, new Serializer());
                }
            }

            @Nullable
            public final /* synthetic */ MediaPageInfoModel m12450b() {
                return m12446j();
            }

            public PhotosTakenHereModel() {
                super(2);
            }

            @Nonnull
            public final ImmutableList<MediaMetadataModel> m12449a() {
                this.f10558d = super.a(this.f10558d, 0, MediaMetadataModel.class);
                return (ImmutableList) this.f10558d;
            }

            @Nullable
            private MediaPageInfoModel m12446j() {
                this.f10559e = (MediaPageInfoModel) super.a(this.f10559e, 1, MediaPageInfoModel.class);
                return this.f10559e;
            }

            public final int jK_() {
                return -1327798988;
            }

            public final GraphQLVisitableModel m12448a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel;
                MediaPageInfoModel mediaPageInfoModel;
                h();
                if (m12449a() != null) {
                    Builder a = ModelHelper.a(m12449a(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        PhotosTakenHereModel photosTakenHereModel = (PhotosTakenHereModel) ModelHelper.a(null, this);
                        photosTakenHereModel.f10558d = a.b();
                        graphQLVisitableModel = photosTakenHereModel;
                        if (m12446j() != null) {
                            mediaPageInfoModel = (MediaPageInfoModel) graphQLModelMutatingVisitor.b(m12446j());
                            if (m12446j() != mediaPageInfoModel) {
                                graphQLVisitableModel = (PhotosTakenHereModel) ModelHelper.a(graphQLVisitableModel, this);
                                graphQLVisitableModel.f10559e = mediaPageInfoModel;
                            }
                        }
                        i();
                        return graphQLVisitableModel != null ? this : graphQLVisitableModel;
                    }
                }
                graphQLVisitableModel = null;
                if (m12446j() != null) {
                    mediaPageInfoModel = (MediaPageInfoModel) graphQLModelMutatingVisitor.b(m12446j());
                    if (m12446j() != mediaPageInfoModel) {
                        graphQLVisitableModel = (PhotosTakenHereModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f10559e = mediaPageInfoModel;
                    }
                }
                i();
                if (graphQLVisitableModel != null) {
                }
            }

            public final int m12447a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m12449a());
                int a2 = ModelHelper.a(flatBufferBuilder, m12446j());
                flatBufferBuilder.c(2);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.b(1, a2);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: last active */
        public class Serializer extends JsonSerializer<MediaFetchForPhotosTakenHereModel> {
            public final void m12451a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                MediaFetchForPhotosTakenHereModel mediaFetchForPhotosTakenHereModel = (MediaFetchForPhotosTakenHereModel) obj;
                if (mediaFetchForPhotosTakenHereModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(mediaFetchForPhotosTakenHereModel.m12453a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mediaFetchForPhotosTakenHereModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = mediaFetchForPhotosTakenHereModel.w_();
                int u_ = mediaFetchForPhotosTakenHereModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("photos_taken_here");
                    PhotosTakenHereParser.m12639a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(MediaFetchForPhotosTakenHereModel.class, new Serializer());
            }
        }

        @Nullable
        public final /* synthetic */ PhotosTakenHereModel m12455a() {
            return m12452j();
        }

        public MediaFetchForPhotosTakenHereModel() {
            super(1);
        }

        public final void m12456a(String str, ConsistencyTuple consistencyTuple) {
            consistencyTuple.a();
        }

        public final void m12457a(String str, Object obj, boolean z) {
        }

        @Nullable
        private PhotosTakenHereModel m12452j() {
            this.f10560d = (PhotosTakenHereModel) super.a(this.f10560d, 0, PhotosTakenHereModel.class);
            return this.f10560d;
        }

        public final int jK_() {
            return 2479791;
        }

        public final GraphQLVisitableModel m12454a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m12452j() != null) {
                PhotosTakenHereModel photosTakenHereModel = (PhotosTakenHereModel) graphQLModelMutatingVisitor.b(m12452j());
                if (m12452j() != photosTakenHereModel) {
                    graphQLVisitableModel = (MediaFetchForPhotosTakenHereModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f10560d = photosTakenHereModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m12453a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m12452j());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 250296634)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: last active */
    public final class MediaFetchForPhotosTakenOfModel extends BaseModel implements GraphQLVisitableConsistentModel {
        @Nullable
        private PhotosTakenOfModel f10563d;

        /* compiled from: last active */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(MediaFetchForPhotosTakenOfModel.class, new Deserializer());
            }

            public Object m12458a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = MediaFetchForPhotosTakenOfParser.m12643a(jsonParser);
                Object mediaFetchForPhotosTakenOfModel = new MediaFetchForPhotosTakenOfModel();
                ((BaseModel) mediaFetchForPhotosTakenOfModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (mediaFetchForPhotosTakenOfModel instanceof Postprocessable) {
                    return ((Postprocessable) mediaFetchForPhotosTakenOfModel).a();
                }
                return mediaFetchForPhotosTakenOfModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1122935727)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: last active */
        public final class PhotosTakenOfModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private List<MediaMetadataModel> f10561d;
            @Nullable
            private MediaPageInfoModel f10562e;

            /* compiled from: last active */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(PhotosTakenOfModel.class, new Deserializer());
                }

                public Object m12459a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(PhotosTakenOfParser.m12641a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object photosTakenOfModel = new PhotosTakenOfModel();
                    ((BaseModel) photosTakenOfModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (photosTakenOfModel instanceof Postprocessable) {
                        return ((Postprocessable) photosTakenOfModel).a();
                    }
                    return photosTakenOfModel;
                }
            }

            /* compiled from: last active */
            public class Serializer extends JsonSerializer<PhotosTakenOfModel> {
                public final void m12460a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    PhotosTakenOfModel photosTakenOfModel = (PhotosTakenOfModel) obj;
                    if (photosTakenOfModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(photosTakenOfModel.m12462a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        photosTakenOfModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    PhotosTakenOfParser.m12642a(photosTakenOfModel.w_(), photosTakenOfModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(PhotosTakenOfModel.class, new Serializer());
                }
            }

            @Nullable
            public final /* synthetic */ MediaPageInfoModel m12465b() {
                return m12461j();
            }

            public PhotosTakenOfModel() {
                super(2);
            }

            @Nonnull
            public final ImmutableList<MediaMetadataModel> m12464a() {
                this.f10561d = super.a(this.f10561d, 0, MediaMetadataModel.class);
                return (ImmutableList) this.f10561d;
            }

            @Nullable
            private MediaPageInfoModel m12461j() {
                this.f10562e = (MediaPageInfoModel) super.a(this.f10562e, 1, MediaPageInfoModel.class);
                return this.f10562e;
            }

            public final int jK_() {
                return -823097381;
            }

            public final GraphQLVisitableModel m12463a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel;
                MediaPageInfoModel mediaPageInfoModel;
                h();
                if (m12464a() != null) {
                    Builder a = ModelHelper.a(m12464a(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        PhotosTakenOfModel photosTakenOfModel = (PhotosTakenOfModel) ModelHelper.a(null, this);
                        photosTakenOfModel.f10561d = a.b();
                        graphQLVisitableModel = photosTakenOfModel;
                        if (m12461j() != null) {
                            mediaPageInfoModel = (MediaPageInfoModel) graphQLModelMutatingVisitor.b(m12461j());
                            if (m12461j() != mediaPageInfoModel) {
                                graphQLVisitableModel = (PhotosTakenOfModel) ModelHelper.a(graphQLVisitableModel, this);
                                graphQLVisitableModel.f10562e = mediaPageInfoModel;
                            }
                        }
                        i();
                        return graphQLVisitableModel != null ? this : graphQLVisitableModel;
                    }
                }
                graphQLVisitableModel = null;
                if (m12461j() != null) {
                    mediaPageInfoModel = (MediaPageInfoModel) graphQLModelMutatingVisitor.b(m12461j());
                    if (m12461j() != mediaPageInfoModel) {
                        graphQLVisitableModel = (PhotosTakenOfModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f10562e = mediaPageInfoModel;
                    }
                }
                i();
                if (graphQLVisitableModel != null) {
                }
            }

            public final int m12462a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m12464a());
                int a2 = ModelHelper.a(flatBufferBuilder, m12461j());
                flatBufferBuilder.c(2);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.b(1, a2);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: last active */
        public class Serializer extends JsonSerializer<MediaFetchForPhotosTakenOfModel> {
            public final void m12466a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                MediaFetchForPhotosTakenOfModel mediaFetchForPhotosTakenOfModel = (MediaFetchForPhotosTakenOfModel) obj;
                if (mediaFetchForPhotosTakenOfModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(mediaFetchForPhotosTakenOfModel.m12468a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mediaFetchForPhotosTakenOfModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = mediaFetchForPhotosTakenOfModel.w_();
                int u_ = mediaFetchForPhotosTakenOfModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("photos_taken_of");
                    PhotosTakenOfParser.m12642a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(MediaFetchForPhotosTakenOfModel.class, new Serializer());
            }
        }

        @Nullable
        public final /* synthetic */ PhotosTakenOfModel m12470a() {
            return m12467j();
        }

        public MediaFetchForPhotosTakenOfModel() {
            super(1);
        }

        public final void m12471a(String str, ConsistencyTuple consistencyTuple) {
            consistencyTuple.a();
        }

        public final void m12472a(String str, Object obj, boolean z) {
        }

        @Nullable
        private PhotosTakenOfModel m12467j() {
            this.f10563d = (PhotosTakenOfModel) super.a(this.f10563d, 0, PhotosTakenOfModel.class);
            return this.f10563d;
        }

        public final int jK_() {
            return 2479791;
        }

        public final GraphQLVisitableModel m12469a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m12467j() != null) {
                PhotosTakenOfModel photosTakenOfModel = (PhotosTakenOfModel) graphQLModelMutatingVisitor.b(m12467j());
                if (m12467j() != photosTakenOfModel) {
                    graphQLVisitableModel = (MediaFetchForPhotosTakenOfModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f10563d = photosTakenOfModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m12468a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m12467j());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -715277197)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: last active */
    public final class MediaFetchForPostedPhotosModel extends BaseModel implements GraphQLVisitableConsistentModel {
        @Nullable
        private PostedPhotosModel f10566d;

        /* compiled from: last active */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(MediaFetchForPostedPhotosModel.class, new Deserializer());
            }

            public Object m12473a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = MediaFetchForPostedPhotosParser.m12646a(jsonParser);
                Object mediaFetchForPostedPhotosModel = new MediaFetchForPostedPhotosModel();
                ((BaseModel) mediaFetchForPostedPhotosModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (mediaFetchForPostedPhotosModel instanceof Postprocessable) {
                    return ((Postprocessable) mediaFetchForPostedPhotosModel).a();
                }
                return mediaFetchForPostedPhotosModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1122935727)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: last active */
        public final class PostedPhotosModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private List<MediaMetadataModel> f10564d;
            @Nullable
            private MediaPageInfoModel f10565e;

            /* compiled from: last active */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(PostedPhotosModel.class, new Deserializer());
                }

                public Object m12474a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(PostedPhotosParser.m12644a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object postedPhotosModel = new PostedPhotosModel();
                    ((BaseModel) postedPhotosModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (postedPhotosModel instanceof Postprocessable) {
                        return ((Postprocessable) postedPhotosModel).a();
                    }
                    return postedPhotosModel;
                }
            }

            /* compiled from: last active */
            public class Serializer extends JsonSerializer<PostedPhotosModel> {
                public final void m12475a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    PostedPhotosModel postedPhotosModel = (PostedPhotosModel) obj;
                    if (postedPhotosModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(postedPhotosModel.m12477a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        postedPhotosModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    PostedPhotosParser.m12645a(postedPhotosModel.w_(), postedPhotosModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(PostedPhotosModel.class, new Serializer());
                }
            }

            @Nullable
            public final /* synthetic */ MediaPageInfoModel m12480b() {
                return m12476j();
            }

            public PostedPhotosModel() {
                super(2);
            }

            @Nonnull
            public final ImmutableList<MediaMetadataModel> m12479a() {
                this.f10564d = super.a(this.f10564d, 0, MediaMetadataModel.class);
                return (ImmutableList) this.f10564d;
            }

            @Nullable
            private MediaPageInfoModel m12476j() {
                this.f10565e = (MediaPageInfoModel) super.a(this.f10565e, 1, MediaPageInfoModel.class);
                return this.f10565e;
            }

            public final int jK_() {
                return 1367901630;
            }

            public final GraphQLVisitableModel m12478a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel;
                MediaPageInfoModel mediaPageInfoModel;
                h();
                if (m12479a() != null) {
                    Builder a = ModelHelper.a(m12479a(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        PostedPhotosModel postedPhotosModel = (PostedPhotosModel) ModelHelper.a(null, this);
                        postedPhotosModel.f10564d = a.b();
                        graphQLVisitableModel = postedPhotosModel;
                        if (m12476j() != null) {
                            mediaPageInfoModel = (MediaPageInfoModel) graphQLModelMutatingVisitor.b(m12476j());
                            if (m12476j() != mediaPageInfoModel) {
                                graphQLVisitableModel = (PostedPhotosModel) ModelHelper.a(graphQLVisitableModel, this);
                                graphQLVisitableModel.f10565e = mediaPageInfoModel;
                            }
                        }
                        i();
                        return graphQLVisitableModel != null ? this : graphQLVisitableModel;
                    }
                }
                graphQLVisitableModel = null;
                if (m12476j() != null) {
                    mediaPageInfoModel = (MediaPageInfoModel) graphQLModelMutatingVisitor.b(m12476j());
                    if (m12476j() != mediaPageInfoModel) {
                        graphQLVisitableModel = (PostedPhotosModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f10565e = mediaPageInfoModel;
                    }
                }
                i();
                if (graphQLVisitableModel != null) {
                }
            }

            public final int m12477a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m12479a());
                int a2 = ModelHelper.a(flatBufferBuilder, m12476j());
                flatBufferBuilder.c(2);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.b(1, a2);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: last active */
        public class Serializer extends JsonSerializer<MediaFetchForPostedPhotosModel> {
            public final void m12481a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                MediaFetchForPostedPhotosModel mediaFetchForPostedPhotosModel = (MediaFetchForPostedPhotosModel) obj;
                if (mediaFetchForPostedPhotosModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(mediaFetchForPostedPhotosModel.m12483a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mediaFetchForPostedPhotosModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = mediaFetchForPostedPhotosModel.w_();
                int u_ = mediaFetchForPostedPhotosModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("posted_photos");
                    PostedPhotosParser.m12645a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(MediaFetchForPostedPhotosModel.class, new Serializer());
            }
        }

        @Nullable
        public final /* synthetic */ PostedPhotosModel m12485a() {
            return m12482j();
        }

        public MediaFetchForPostedPhotosModel() {
            super(1);
        }

        public final void m12486a(String str, ConsistencyTuple consistencyTuple) {
            consistencyTuple.a();
        }

        public final void m12487a(String str, Object obj, boolean z) {
        }

        @Nullable
        private PostedPhotosModel m12482j() {
            this.f10566d = (PostedPhotosModel) super.a(this.f10566d, 0, PostedPhotosModel.class);
            return this.f10566d;
        }

        public final int jK_() {
            return 2479791;
        }

        public final GraphQLVisitableModel m12484a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m12482j() != null) {
                PostedPhotosModel postedPhotosModel = (PostedPhotosModel) graphQLModelMutatingVisitor.b(m12482j());
                if (m12482j() != postedPhotosModel) {
                    graphQLVisitableModel = (MediaFetchForPostedPhotosModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f10566d = postedPhotosModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m12483a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m12482j());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 124473403)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: last active */
    public final class MediaFetchForProfilePictureModel extends BaseModel implements GraphQLVisitableConsistentModel {
        @Nullable
        private GraphQLObjectType f10567d;
        @Nullable
        private DefaultImageFieldsModel f10568e;

        /* compiled from: last active */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(MediaFetchForProfilePictureModel.class, new Deserializer());
            }

            public Object m12488a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = MediaFetchForProfilePictureParser.m12647a(jsonParser);
                Object mediaFetchForProfilePictureModel = new MediaFetchForProfilePictureModel();
                ((BaseModel) mediaFetchForProfilePictureModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (mediaFetchForProfilePictureModel instanceof Postprocessable) {
                    return ((Postprocessable) mediaFetchForProfilePictureModel).a();
                }
                return mediaFetchForProfilePictureModel;
            }
        }

        /* compiled from: last active */
        public class Serializer extends JsonSerializer<MediaFetchForProfilePictureModel> {
            public final void m12489a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                MediaFetchForProfilePictureModel mediaFetchForProfilePictureModel = (MediaFetchForProfilePictureModel) obj;
                if (mediaFetchForProfilePictureModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(mediaFetchForProfilePictureModel.m12492a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mediaFetchForProfilePictureModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = mediaFetchForProfilePictureModel.w_();
                int u_ = mediaFetchForProfilePictureModel.u_();
                jsonGenerator.f();
                if (mutableFlatBuffer.g(u_, 0) != 0) {
                    jsonGenerator.a("__type__");
                    SerializerHelpers.b(mutableFlatBuffer, u_, 0, jsonGenerator);
                }
                int g = mutableFlatBuffer.g(u_, 1);
                if (g != 0) {
                    jsonGenerator.a("imageHighOrig");
                    DefaultImageFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(MediaFetchForProfilePictureModel.class, new Serializer());
            }
        }

        @Nullable
        public final /* synthetic */ DefaultImageFields m12493a() {
            return m12491k();
        }

        public MediaFetchForProfilePictureModel() {
            super(2);
        }

        public final void m12495a(String str, ConsistencyTuple consistencyTuple) {
            consistencyTuple.a();
        }

        public final void m12496a(String str, Object obj, boolean z) {
        }

        @Nullable
        private GraphQLObjectType m12490j() {
            if (this.b != null && this.f10567d == null) {
                this.f10567d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
            }
            return this.f10567d;
        }

        @Nullable
        private DefaultImageFieldsModel m12491k() {
            this.f10568e = (DefaultImageFieldsModel) super.a(this.f10568e, 1, DefaultImageFieldsModel.class);
            return this.f10568e;
        }

        public final int jK_() {
            return 2433570;
        }

        public final GraphQLVisitableModel m12494a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m12491k() != null) {
                DefaultImageFieldsModel defaultImageFieldsModel = (DefaultImageFieldsModel) graphQLModelMutatingVisitor.b(m12491k());
                if (m12491k() != defaultImageFieldsModel) {
                    graphQLVisitableModel = (MediaFetchForProfilePictureModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f10568e = defaultImageFieldsModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m12492a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m12490j());
            int a2 = ModelHelper.a(flatBufferBuilder, m12491k());
            flatBufferBuilder.c(2);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, a2);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -1364006279)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: last active */
    public final class MediaFetchFromMediaSetIdModel extends BaseModel implements GraphQLVisitableConsistentModel {
        @Nullable
        private GraphQLObjectType f10571d;
        @Nullable
        private MediaModel f10572e;

        /* compiled from: last active */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(MediaFetchFromMediaSetIdModel.class, new Deserializer());
            }

            public Object m12497a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = MediaFetchFromMediaSetIdParser.m12650a(jsonParser);
                Object mediaFetchFromMediaSetIdModel = new MediaFetchFromMediaSetIdModel();
                ((BaseModel) mediaFetchFromMediaSetIdModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (mediaFetchFromMediaSetIdModel instanceof Postprocessable) {
                    return ((Postprocessable) mediaFetchFromMediaSetIdModel).a();
                }
                return mediaFetchFromMediaSetIdModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1122935727)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: last active */
        public final class MediaModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private List<MediaMetadataModel> f10569d;
            @Nullable
            private MediaPageInfoModel f10570e;

            /* compiled from: last active */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(MediaModel.class, new Deserializer());
                }

                public Object m12498a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(MediaParser.m12648a(jsonParser, flatBufferBuilder));
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

            /* compiled from: last active */
            public class Serializer extends JsonSerializer<MediaModel> {
                public final void m12499a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    MediaModel mediaModel = (MediaModel) obj;
                    if (mediaModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(mediaModel.m12501a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mediaModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    MediaParser.m12649a(mediaModel.w_(), mediaModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(MediaModel.class, new Serializer());
                }
            }

            @Nullable
            public final /* synthetic */ MediaPageInfoModel m12504b() {
                return m12500j();
            }

            public MediaModel() {
                super(2);
            }

            @Nonnull
            public final ImmutableList<MediaMetadataModel> m12503a() {
                this.f10569d = super.a(this.f10569d, 0, MediaMetadataModel.class);
                return (ImmutableList) this.f10569d;
            }

            @Nullable
            private MediaPageInfoModel m12500j() {
                this.f10570e = (MediaPageInfoModel) super.a(this.f10570e, 1, MediaPageInfoModel.class);
                return this.f10570e;
            }

            public final int jK_() {
                return 747633668;
            }

            public final GraphQLVisitableModel m12502a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel;
                MediaPageInfoModel mediaPageInfoModel;
                h();
                if (m12503a() != null) {
                    Builder a = ModelHelper.a(m12503a(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        MediaModel mediaModel = (MediaModel) ModelHelper.a(null, this);
                        mediaModel.f10569d = a.b();
                        graphQLVisitableModel = mediaModel;
                        if (m12500j() != null) {
                            mediaPageInfoModel = (MediaPageInfoModel) graphQLModelMutatingVisitor.b(m12500j());
                            if (m12500j() != mediaPageInfoModel) {
                                graphQLVisitableModel = (MediaModel) ModelHelper.a(graphQLVisitableModel, this);
                                graphQLVisitableModel.f10570e = mediaPageInfoModel;
                            }
                        }
                        i();
                        return graphQLVisitableModel != null ? this : graphQLVisitableModel;
                    }
                }
                graphQLVisitableModel = null;
                if (m12500j() != null) {
                    mediaPageInfoModel = (MediaPageInfoModel) graphQLModelMutatingVisitor.b(m12500j());
                    if (m12500j() != mediaPageInfoModel) {
                        graphQLVisitableModel = (MediaModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f10570e = mediaPageInfoModel;
                    }
                }
                i();
                if (graphQLVisitableModel != null) {
                }
            }

            public final int m12501a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m12503a());
                int a2 = ModelHelper.a(flatBufferBuilder, m12500j());
                flatBufferBuilder.c(2);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.b(1, a2);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: last active */
        public class Serializer extends JsonSerializer<MediaFetchFromMediaSetIdModel> {
            public final void m12505a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                MediaFetchFromMediaSetIdModel mediaFetchFromMediaSetIdModel = (MediaFetchFromMediaSetIdModel) obj;
                if (mediaFetchFromMediaSetIdModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(mediaFetchFromMediaSetIdModel.m12508a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mediaFetchFromMediaSetIdModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = mediaFetchFromMediaSetIdModel.w_();
                int u_ = mediaFetchFromMediaSetIdModel.u_();
                jsonGenerator.f();
                if (mutableFlatBuffer.g(u_, 0) != 0) {
                    jsonGenerator.a("__type__");
                    SerializerHelpers.b(mutableFlatBuffer, u_, 0, jsonGenerator);
                }
                int g = mutableFlatBuffer.g(u_, 1);
                if (g != 0) {
                    jsonGenerator.a("media");
                    MediaParser.m12649a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(MediaFetchFromMediaSetIdModel.class, new Serializer());
            }
        }

        @Nullable
        public final /* synthetic */ MediaModel m12510a() {
            return m12507k();
        }

        public MediaFetchFromMediaSetIdModel() {
            super(2);
        }

        public final void m12511a(String str, ConsistencyTuple consistencyTuple) {
            consistencyTuple.a();
        }

        public final void m12512a(String str, Object obj, boolean z) {
        }

        @Nullable
        private GraphQLObjectType m12506j() {
            if (this.b != null && this.f10571d == null) {
                this.f10571d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
            }
            return this.f10571d;
        }

        @Nullable
        private MediaModel m12507k() {
            this.f10572e = (MediaModel) super.a(this.f10572e, 1, MediaModel.class);
            return this.f10572e;
        }

        public final int jK_() {
            return 2433570;
        }

        public final GraphQLVisitableModel m12509a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m12507k() != null) {
                MediaModel mediaModel = (MediaModel) graphQLModelMutatingVisitor.b(m12507k());
                if (m12507k() != mediaModel) {
                    graphQLVisitableModel = (MediaFetchFromMediaSetIdModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f10572e = mediaModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m12508a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m12506j());
            int a2 = ModelHelper.a(flatBufferBuilder, m12507k());
            flatBufferBuilder.c(2);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, a2);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 424466999)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: last active */
    public final class MediaFetchFromMediaSetTokenModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private GraphQLObjectType f10575d;
        @Nullable
        private MediaModel f10576e;

        /* compiled from: last active */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(MediaFetchFromMediaSetTokenModel.class, new Deserializer());
            }

            public Object m12513a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = MediaFetchFromMediaSetTokenParser.m12653a(jsonParser);
                Object mediaFetchFromMediaSetTokenModel = new MediaFetchFromMediaSetTokenModel();
                ((BaseModel) mediaFetchFromMediaSetTokenModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (mediaFetchFromMediaSetTokenModel instanceof Postprocessable) {
                    return ((Postprocessable) mediaFetchFromMediaSetTokenModel).a();
                }
                return mediaFetchFromMediaSetTokenModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1122935727)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: last active */
        public final class MediaModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private List<MediaMetadataModel> f10573d;
            @Nullable
            private MediaPageInfoModel f10574e;

            /* compiled from: last active */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(MediaModel.class, new Deserializer());
                }

                public Object m12514a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(MediaFetchFromMediaSetTokenParser.MediaParser.m12651a(jsonParser, flatBufferBuilder));
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

            /* compiled from: last active */
            public class Serializer extends JsonSerializer<MediaModel> {
                public final void m12515a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    MediaModel mediaModel = (MediaModel) obj;
                    if (mediaModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(mediaModel.m12517a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mediaModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    MediaFetchFromMediaSetTokenParser.MediaParser.m12652a(mediaModel.w_(), mediaModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(MediaModel.class, new Serializer());
                }
            }

            @Nullable
            public final /* synthetic */ MediaPageInfoModel m12520b() {
                return m12516j();
            }

            public MediaModel() {
                super(2);
            }

            @Nonnull
            public final ImmutableList<MediaMetadataModel> m12519a() {
                this.f10573d = super.a(this.f10573d, 0, MediaMetadataModel.class);
                return (ImmutableList) this.f10573d;
            }

            @Nullable
            private MediaPageInfoModel m12516j() {
                this.f10574e = (MediaPageInfoModel) super.a(this.f10574e, 1, MediaPageInfoModel.class);
                return this.f10574e;
            }

            public final int jK_() {
                return 747633668;
            }

            public final GraphQLVisitableModel m12518a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel;
                MediaPageInfoModel mediaPageInfoModel;
                h();
                if (m12519a() != null) {
                    Builder a = ModelHelper.a(m12519a(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        MediaModel mediaModel = (MediaModel) ModelHelper.a(null, this);
                        mediaModel.f10573d = a.b();
                        graphQLVisitableModel = mediaModel;
                        if (m12516j() != null) {
                            mediaPageInfoModel = (MediaPageInfoModel) graphQLModelMutatingVisitor.b(m12516j());
                            if (m12516j() != mediaPageInfoModel) {
                                graphQLVisitableModel = (MediaModel) ModelHelper.a(graphQLVisitableModel, this);
                                graphQLVisitableModel.f10574e = mediaPageInfoModel;
                            }
                        }
                        i();
                        return graphQLVisitableModel != null ? this : graphQLVisitableModel;
                    }
                }
                graphQLVisitableModel = null;
                if (m12516j() != null) {
                    mediaPageInfoModel = (MediaPageInfoModel) graphQLModelMutatingVisitor.b(m12516j());
                    if (m12516j() != mediaPageInfoModel) {
                        graphQLVisitableModel = (MediaModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f10574e = mediaPageInfoModel;
                    }
                }
                i();
                if (graphQLVisitableModel != null) {
                }
            }

            public final int m12517a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m12519a());
                int a2 = ModelHelper.a(flatBufferBuilder, m12516j());
                flatBufferBuilder.c(2);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.b(1, a2);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: last active */
        public class Serializer extends JsonSerializer<MediaFetchFromMediaSetTokenModel> {
            public final void m12521a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                MediaFetchFromMediaSetTokenModel mediaFetchFromMediaSetTokenModel = (MediaFetchFromMediaSetTokenModel) obj;
                if (mediaFetchFromMediaSetTokenModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(mediaFetchFromMediaSetTokenModel.m12524a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mediaFetchFromMediaSetTokenModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = mediaFetchFromMediaSetTokenModel.w_();
                int u_ = mediaFetchFromMediaSetTokenModel.u_();
                jsonGenerator.f();
                if (mutableFlatBuffer.g(u_, 0) != 0) {
                    jsonGenerator.a("__type__");
                    SerializerHelpers.b(mutableFlatBuffer, u_, 0, jsonGenerator);
                }
                int g = mutableFlatBuffer.g(u_, 1);
                if (g != 0) {
                    jsonGenerator.a("media");
                    MediaFetchFromMediaSetTokenParser.MediaParser.m12652a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(MediaFetchFromMediaSetTokenModel.class, new Serializer());
            }
        }

        @Nullable
        public final /* synthetic */ MediaModel m12526a() {
            return m12523k();
        }

        public MediaFetchFromMediaSetTokenModel() {
            super(2);
        }

        @Nullable
        private GraphQLObjectType m12522j() {
            if (this.b != null && this.f10575d == null) {
                this.f10575d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
            }
            return this.f10575d;
        }

        @Nullable
        private MediaModel m12523k() {
            this.f10576e = (MediaModel) super.a(this.f10576e, 1, MediaModel.class);
            return this.f10576e;
        }

        public final int jK_() {
            return -836141570;
        }

        public final GraphQLVisitableModel m12525a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m12523k() != null) {
                MediaModel mediaModel = (MediaModel) graphQLModelMutatingVisitor.b(m12523k());
                if (m12523k() != mediaModel) {
                    graphQLVisitableModel = (MediaFetchFromMediaSetTokenModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f10576e = mediaModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m12524a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m12522j());
            int a2 = ModelHelper.a(flatBufferBuilder, m12523k());
            flatBufferBuilder.c(2);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, a2);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 1087751313)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: last active */
    public final class MediaFetchFromReactionStoryModel extends BaseModel implements GraphQLVisitableConsistentModel {
        @Nullable
        private GraphQLObjectType f10581d;
        @Nullable
        private ReactionAttachmentsModel f10582e;

        /* compiled from: last active */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(MediaFetchFromReactionStoryModel.class, new Deserializer());
            }

            public Object m12527a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = MediaFetchFromReactionStoryParser.m12658a(jsonParser);
                Object mediaFetchFromReactionStoryModel = new MediaFetchFromReactionStoryModel();
                ((BaseModel) mediaFetchFromReactionStoryModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (mediaFetchFromReactionStoryModel instanceof Postprocessable) {
                    return ((Postprocessable) mediaFetchFromReactionStoryModel).a();
                }
                return mediaFetchFromReactionStoryModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -718211570)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: last active */
        public final class ReactionAttachmentsModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private List<NodesModel> f10579d;
            @Nullable
            private MediaPageInfoModel f10580e;

            /* compiled from: last active */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(ReactionAttachmentsModel.class, new Deserializer());
                }

                public Object m12528a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(ReactionAttachmentsParser.m12656a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object reactionAttachmentsModel = new ReactionAttachmentsModel();
                    ((BaseModel) reactionAttachmentsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (reactionAttachmentsModel instanceof Postprocessable) {
                        return ((Postprocessable) reactionAttachmentsModel).a();
                    }
                    return reactionAttachmentsModel;
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = 614584963)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: last active */
            public final class NodesModel extends BaseModel implements GraphQLVisitableModel {
                @Nullable
                private GraphQLObjectType f10577d;
                @Nullable
                private MediaMetadataModel f10578e;

                /* compiled from: last active */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(NodesModel.class, new Deserializer());
                    }

                    public Object m12529a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(NodesParser.m12654b(jsonParser, flatBufferBuilder));
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

                /* compiled from: last active */
                public class Serializer extends JsonSerializer<NodesModel> {
                    public final void m12530a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        NodesModel nodesModel = (NodesModel) obj;
                        if (nodesModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(nodesModel.m12533a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            nodesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        NodesParser.m12655b(nodesModel.w_(), nodesModel.u_(), jsonGenerator, serializerProvider);
                    }

                    static {
                        FbSerializerProvider.a(NodesModel.class, new Serializer());
                    }
                }

                @Nullable
                public final /* synthetic */ MediaMetadata m12535a() {
                    return m12532k();
                }

                public NodesModel() {
                    super(2);
                }

                @Nullable
                private GraphQLObjectType m12531j() {
                    if (this.b != null && this.f10577d == null) {
                        this.f10577d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
                    }
                    return this.f10577d;
                }

                @Nullable
                private MediaMetadataModel m12532k() {
                    this.f10578e = (MediaMetadataModel) super.a(this.f10578e, 1, MediaMetadataModel.class);
                    return this.f10578e;
                }

                public final int jK_() {
                    return -1677771153;
                }

                public final GraphQLVisitableModel m12534a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    GraphQLVisitableModel graphQLVisitableModel = null;
                    h();
                    if (m12532k() != null) {
                        MediaMetadataModel mediaMetadataModel = (MediaMetadataModel) graphQLModelMutatingVisitor.b(m12532k());
                        if (m12532k() != mediaMetadataModel) {
                            graphQLVisitableModel = (NodesModel) ModelHelper.a(null, this);
                            graphQLVisitableModel.f10578e = mediaMetadataModel;
                        }
                    }
                    i();
                    return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                }

                public final int m12533a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int a = ModelHelper.a(flatBufferBuilder, m12531j());
                    int a2 = ModelHelper.a(flatBufferBuilder, m12532k());
                    flatBufferBuilder.c(2);
                    flatBufferBuilder.b(0, a);
                    flatBufferBuilder.b(1, a2);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            /* compiled from: last active */
            public class Serializer extends JsonSerializer<ReactionAttachmentsModel> {
                public final void m12536a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    ReactionAttachmentsModel reactionAttachmentsModel = (ReactionAttachmentsModel) obj;
                    if (reactionAttachmentsModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(reactionAttachmentsModel.m12538a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        reactionAttachmentsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    ReactionAttachmentsParser.m12657a(reactionAttachmentsModel.w_(), reactionAttachmentsModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(ReactionAttachmentsModel.class, new Serializer());
                }
            }

            @Nullable
            public final /* synthetic */ MediaPageInfoModel m12541b() {
                return m12537j();
            }

            public ReactionAttachmentsModel() {
                super(2);
            }

            @Nonnull
            public final ImmutableList<NodesModel> m12540a() {
                this.f10579d = super.a(this.f10579d, 0, NodesModel.class);
                return (ImmutableList) this.f10579d;
            }

            @Nullable
            private MediaPageInfoModel m12537j() {
                this.f10580e = (MediaPageInfoModel) super.a(this.f10580e, 1, MediaPageInfoModel.class);
                return this.f10580e;
            }

            public final int jK_() {
                return -972595742;
            }

            public final GraphQLVisitableModel m12539a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel;
                MediaPageInfoModel mediaPageInfoModel;
                h();
                if (m12540a() != null) {
                    Builder a = ModelHelper.a(m12540a(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        ReactionAttachmentsModel reactionAttachmentsModel = (ReactionAttachmentsModel) ModelHelper.a(null, this);
                        reactionAttachmentsModel.f10579d = a.b();
                        graphQLVisitableModel = reactionAttachmentsModel;
                        if (m12537j() != null) {
                            mediaPageInfoModel = (MediaPageInfoModel) graphQLModelMutatingVisitor.b(m12537j());
                            if (m12537j() != mediaPageInfoModel) {
                                graphQLVisitableModel = (ReactionAttachmentsModel) ModelHelper.a(graphQLVisitableModel, this);
                                graphQLVisitableModel.f10580e = mediaPageInfoModel;
                            }
                        }
                        i();
                        return graphQLVisitableModel != null ? this : graphQLVisitableModel;
                    }
                }
                graphQLVisitableModel = null;
                if (m12537j() != null) {
                    mediaPageInfoModel = (MediaPageInfoModel) graphQLModelMutatingVisitor.b(m12537j());
                    if (m12537j() != mediaPageInfoModel) {
                        graphQLVisitableModel = (ReactionAttachmentsModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f10580e = mediaPageInfoModel;
                    }
                }
                i();
                if (graphQLVisitableModel != null) {
                }
            }

            public final int m12538a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m12540a());
                int a2 = ModelHelper.a(flatBufferBuilder, m12537j());
                flatBufferBuilder.c(2);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.b(1, a2);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: last active */
        public class Serializer extends JsonSerializer<MediaFetchFromReactionStoryModel> {
            public final void m12542a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                MediaFetchFromReactionStoryModel mediaFetchFromReactionStoryModel = (MediaFetchFromReactionStoryModel) obj;
                if (mediaFetchFromReactionStoryModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(mediaFetchFromReactionStoryModel.m12545a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mediaFetchFromReactionStoryModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = mediaFetchFromReactionStoryModel.w_();
                int u_ = mediaFetchFromReactionStoryModel.u_();
                jsonGenerator.f();
                if (mutableFlatBuffer.g(u_, 0) != 0) {
                    jsonGenerator.a("__type__");
                    SerializerHelpers.b(mutableFlatBuffer, u_, 0, jsonGenerator);
                }
                int g = mutableFlatBuffer.g(u_, 1);
                if (g != 0) {
                    jsonGenerator.a("reaction_attachments");
                    ReactionAttachmentsParser.m12657a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(MediaFetchFromReactionStoryModel.class, new Serializer());
            }
        }

        @Nullable
        public final /* synthetic */ ReactionAttachmentsModel m12547a() {
            return m12544k();
        }

        public MediaFetchFromReactionStoryModel() {
            super(2);
        }

        public final void m12548a(String str, ConsistencyTuple consistencyTuple) {
            consistencyTuple.a();
        }

        public final void m12549a(String str, Object obj, boolean z) {
        }

        @Nullable
        private GraphQLObjectType m12543j() {
            if (this.b != null && this.f10581d == null) {
                this.f10581d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
            }
            return this.f10581d;
        }

        @Nullable
        private ReactionAttachmentsModel m12544k() {
            this.f10582e = (ReactionAttachmentsModel) super.a(this.f10582e, 1, ReactionAttachmentsModel.class);
            return this.f10582e;
        }

        public final int jK_() {
            return 2433570;
        }

        public final GraphQLVisitableModel m12546a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m12544k() != null) {
                ReactionAttachmentsModel reactionAttachmentsModel = (ReactionAttachmentsModel) graphQLModelMutatingVisitor.b(m12544k());
                if (m12544k() != reactionAttachmentsModel) {
                    graphQLVisitableModel = (MediaFetchFromReactionStoryModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f10582e = reactionAttachmentsModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m12545a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m12543j());
            int a2 = ModelHelper.a(flatBufferBuilder, m12544k());
            flatBufferBuilder.c(2);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, a2);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -1578791996)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: last active */
    public final class MediaFetchFromStoryModel extends BaseModel implements GraphQLVisitableConsistentModel {
        @Nullable
        private GraphQLObjectType f10585d;
        @Nullable
        private List<AttachmentsModel> f10586e;

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1719601140)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: last active */
        public final class AttachmentsModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private List<SubattachmentsModel> f10584d;

            /* compiled from: last active */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(AttachmentsModel.class, new Deserializer());
                }

                public Object m12550a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(AttachmentsParser.m12661b(jsonParser, flatBufferBuilder));
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

            /* compiled from: last active */
            public class Serializer extends JsonSerializer<AttachmentsModel> {
                public final void m12551a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    AttachmentsModel attachmentsModel = (AttachmentsModel) obj;
                    if (attachmentsModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(attachmentsModel.m12558a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        attachmentsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    AttachmentsParser.m12662b(attachmentsModel.w_(), attachmentsModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(AttachmentsModel.class, new Serializer());
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = 1088808833)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: last active */
            public final class SubattachmentsModel extends BaseModel implements GraphQLVisitableModel {
                @Nullable
                private MediaMetadataModel f10583d;

                /* compiled from: last active */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(SubattachmentsModel.class, new Deserializer());
                    }

                    public Object m12552a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(SubattachmentsParser.m12659b(jsonParser, flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                        Object subattachmentsModel = new SubattachmentsModel();
                        ((BaseModel) subattachmentsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                        if (subattachmentsModel instanceof Postprocessable) {
                            return ((Postprocessable) subattachmentsModel).a();
                        }
                        return subattachmentsModel;
                    }
                }

                /* compiled from: last active */
                public class Serializer extends JsonSerializer<SubattachmentsModel> {
                    public final void m12553a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        SubattachmentsModel subattachmentsModel = (SubattachmentsModel) obj;
                        if (subattachmentsModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(subattachmentsModel.m12555a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            subattachmentsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        SubattachmentsParser.m12660b(subattachmentsModel.w_(), subattachmentsModel.u_(), jsonGenerator, serializerProvider);
                    }

                    static {
                        FbSerializerProvider.a(SubattachmentsModel.class, new Serializer());
                    }
                }

                @Nullable
                public final /* synthetic */ MediaMetadata m12557a() {
                    return m12554j();
                }

                public SubattachmentsModel() {
                    super(1);
                }

                @Nullable
                private MediaMetadataModel m12554j() {
                    this.f10583d = (MediaMetadataModel) super.a(this.f10583d, 0, MediaMetadataModel.class);
                    return this.f10583d;
                }

                public final int jK_() {
                    return -1267730472;
                }

                public final GraphQLVisitableModel m12556a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    GraphQLVisitableModel graphQLVisitableModel = null;
                    h();
                    if (m12554j() != null) {
                        MediaMetadataModel mediaMetadataModel = (MediaMetadataModel) graphQLModelMutatingVisitor.b(m12554j());
                        if (m12554j() != mediaMetadataModel) {
                            graphQLVisitableModel = (SubattachmentsModel) ModelHelper.a(null, this);
                            graphQLVisitableModel.f10583d = mediaMetadataModel;
                        }
                    }
                    i();
                    return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                }

                public final int m12555a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int a = ModelHelper.a(flatBufferBuilder, m12554j());
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.b(0, a);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            public AttachmentsModel() {
                super(1);
            }

            @Nonnull
            public final ImmutableList<SubattachmentsModel> m12560a() {
                this.f10584d = super.a(this.f10584d, 0, SubattachmentsModel.class);
                return (ImmutableList) this.f10584d;
            }

            public final int jK_() {
                return -1267730472;
            }

            public final GraphQLVisitableModel m12559a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m12560a() != null) {
                    Builder a = ModelHelper.a(m12560a(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        graphQLVisitableModel = (AttachmentsModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f10584d = a.b();
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m12558a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m12560a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, a);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: last active */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(MediaFetchFromStoryModel.class, new Deserializer());
            }

            public Object m12561a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(MediaFetchFromStoryParser.m12663a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object mediaFetchFromStoryModel = new MediaFetchFromStoryModel();
                ((BaseModel) mediaFetchFromStoryModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (mediaFetchFromStoryModel instanceof Postprocessable) {
                    return ((Postprocessable) mediaFetchFromStoryModel).a();
                }
                return mediaFetchFromStoryModel;
            }
        }

        /* compiled from: last active */
        public class Serializer extends JsonSerializer<MediaFetchFromStoryModel> {
            public final void m12562a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                MediaFetchFromStoryModel mediaFetchFromStoryModel = (MediaFetchFromStoryModel) obj;
                if (mediaFetchFromStoryModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(mediaFetchFromStoryModel.m12564a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mediaFetchFromStoryModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = mediaFetchFromStoryModel.w_();
                int u_ = mediaFetchFromStoryModel.u_();
                jsonGenerator.f();
                if (mutableFlatBuffer.g(u_, 0) != 0) {
                    jsonGenerator.a("__type__");
                    SerializerHelpers.b(mutableFlatBuffer, u_, 0, jsonGenerator);
                }
                int g = mutableFlatBuffer.g(u_, 1);
                if (g != 0) {
                    jsonGenerator.a("attachments");
                    jsonGenerator.d();
                    for (int i = 0; i < mutableFlatBuffer.c(g); i++) {
                        AttachmentsParser.m12662b(mutableFlatBuffer, mutableFlatBuffer.m(g, i), jsonGenerator, serializerProvider);
                    }
                    jsonGenerator.e();
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(MediaFetchFromStoryModel.class, new Serializer());
            }
        }

        public MediaFetchFromStoryModel() {
            super(2);
        }

        public final void m12567a(String str, ConsistencyTuple consistencyTuple) {
            consistencyTuple.a();
        }

        public final void m12568a(String str, Object obj, boolean z) {
        }

        @Nullable
        private GraphQLObjectType m12563j() {
            if (this.b != null && this.f10585d == null) {
                this.f10585d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
            }
            return this.f10585d;
        }

        @Nonnull
        public final ImmutableList<AttachmentsModel> m12566a() {
            this.f10586e = super.a(this.f10586e, 1, AttachmentsModel.class);
            return (ImmutableList) this.f10586e;
        }

        public final int jK_() {
            return 2433570;
        }

        public final GraphQLVisitableModel m12565a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m12566a() != null) {
                Builder a = ModelHelper.a(m12566a(), graphQLModelMutatingVisitor);
                if (a != null) {
                    graphQLVisitableModel = (MediaFetchFromStoryModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f10586e = a.b();
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m12564a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m12563j());
            int a2 = ModelHelper.a(flatBufferBuilder, m12566a());
            flatBufferBuilder.c(2);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, a2);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 444945089)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: last active */
    public final class MediaFetchPageMenusModel extends BaseModel implements GraphQLVisitableConsistentModel {
        @Nullable
        private PagePhotoMenusModel f10591d;

        /* compiled from: last active */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(MediaFetchPageMenusModel.class, new Deserializer());
            }

            public Object m12569a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = MediaFetchPageMenusParser.m12670a(jsonParser);
                Object mediaFetchPageMenusModel = new MediaFetchPageMenusModel();
                ((BaseModel) mediaFetchPageMenusModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (mediaFetchPageMenusModel instanceof Postprocessable) {
                    return ((Postprocessable) mediaFetchPageMenusModel).a();
                }
                return mediaFetchPageMenusModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -389866723)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: last active */
        public final class PagePhotoMenusModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private List<NodesModel> f10590d;

            /* compiled from: last active */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(PagePhotoMenusModel.class, new Deserializer());
                }

                public Object m12570a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(PagePhotoMenusParser.m12668a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object pagePhotoMenusModel = new PagePhotoMenusModel();
                    ((BaseModel) pagePhotoMenusModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (pagePhotoMenusModel instanceof Postprocessable) {
                        return ((Postprocessable) pagePhotoMenusModel).a();
                    }
                    return pagePhotoMenusModel;
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = -314325559)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: last active */
            public final class NodesModel extends BaseModel implements GraphQLVisitableModel {
                @Nullable
                private PagePhotoMenuPhotosModel f10589d;

                /* compiled from: last active */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(NodesModel.class, new Deserializer());
                    }

                    public Object m12571a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(PagePhotoMenusParser.NodesParser.m12666b(jsonParser, flatBufferBuilder));
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

                @JsonDeserialize(using = Deserializer.class)
                @ModelWithFlatBufferFormatHash(a = -1122935727)
                @JsonSerialize(using = Serializer.class)
                @FragmentModelWithoutBridge
                /* compiled from: last active */
                public final class PagePhotoMenuPhotosModel extends BaseModel implements GraphQLVisitableModel {
                    @Nullable
                    private List<MediaMetadataModel> f10587d;
                    @Nullable
                    private MediaPageInfoModel f10588e;

                    /* compiled from: last active */
                    public class Deserializer extends FbJsonDeserializer {
                        static {
                            GlobalAutoGenDeserializerCache.a(PagePhotoMenuPhotosModel.class, new Deserializer());
                        }

                        public Object m12572a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(PagePhotoMenuPhotosParser.m12664a(jsonParser, flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            mutableFlatBuffer.a(4, Boolean.valueOf(true));
                            MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                            Object pagePhotoMenuPhotosModel = new PagePhotoMenuPhotosModel();
                            ((BaseModel) pagePhotoMenuPhotosModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                            if (pagePhotoMenuPhotosModel instanceof Postprocessable) {
                                return ((Postprocessable) pagePhotoMenuPhotosModel).a();
                            }
                            return pagePhotoMenuPhotosModel;
                        }
                    }

                    /* compiled from: last active */
                    public class Serializer extends JsonSerializer<PagePhotoMenuPhotosModel> {
                        public final void m12573a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                            PagePhotoMenuPhotosModel pagePhotoMenuPhotosModel = (PagePhotoMenuPhotosModel) obj;
                            if (pagePhotoMenuPhotosModel.w_() == null) {
                                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                flatBufferBuilder.d(pagePhotoMenuPhotosModel.m12574a(flatBufferBuilder));
                                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                wrap.position(0);
                                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                pagePhotoMenuPhotosModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                            }
                            PagePhotoMenuPhotosParser.m12665a(pagePhotoMenuPhotosModel.w_(), pagePhotoMenuPhotosModel.u_(), jsonGenerator, serializerProvider);
                        }

                        static {
                            FbSerializerProvider.a(PagePhotoMenuPhotosModel.class, new Serializer());
                        }
                    }

                    public PagePhotoMenuPhotosModel() {
                        super(2);
                    }

                    @Nonnull
                    public final ImmutableList<MediaMetadataModel> m12576a() {
                        this.f10587d = super.a(this.f10587d, 0, MediaMetadataModel.class);
                        return (ImmutableList) this.f10587d;
                    }

                    @Nullable
                    public final MediaPageInfoModel m12577j() {
                        this.f10588e = (MediaPageInfoModel) super.a(this.f10588e, 1, MediaPageInfoModel.class);
                        return this.f10588e;
                    }

                    public final int jK_() {
                        return -545246431;
                    }

                    public final GraphQLVisitableModel m12575a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                        GraphQLVisitableModel graphQLVisitableModel;
                        MediaPageInfoModel mediaPageInfoModel;
                        h();
                        if (m12576a() != null) {
                            Builder a = ModelHelper.a(m12576a(), graphQLModelMutatingVisitor);
                            if (a != null) {
                                PagePhotoMenuPhotosModel pagePhotoMenuPhotosModel = (PagePhotoMenuPhotosModel) ModelHelper.a(null, this);
                                pagePhotoMenuPhotosModel.f10587d = a.b();
                                graphQLVisitableModel = pagePhotoMenuPhotosModel;
                                if (m12577j() != null) {
                                    mediaPageInfoModel = (MediaPageInfoModel) graphQLModelMutatingVisitor.b(m12577j());
                                    if (m12577j() != mediaPageInfoModel) {
                                        graphQLVisitableModel = (PagePhotoMenuPhotosModel) ModelHelper.a(graphQLVisitableModel, this);
                                        graphQLVisitableModel.f10588e = mediaPageInfoModel;
                                    }
                                }
                                i();
                                return graphQLVisitableModel != null ? this : graphQLVisitableModel;
                            }
                        }
                        graphQLVisitableModel = null;
                        if (m12577j() != null) {
                            mediaPageInfoModel = (MediaPageInfoModel) graphQLModelMutatingVisitor.b(m12577j());
                            if (m12577j() != mediaPageInfoModel) {
                                graphQLVisitableModel = (PagePhotoMenuPhotosModel) ModelHelper.a(graphQLVisitableModel, this);
                                graphQLVisitableModel.f10588e = mediaPageInfoModel;
                            }
                        }
                        i();
                        if (graphQLVisitableModel != null) {
                        }
                    }

                    public final int m12574a(FlatBufferBuilder flatBufferBuilder) {
                        h();
                        int a = ModelHelper.a(flatBufferBuilder, m12576a());
                        int a2 = ModelHelper.a(flatBufferBuilder, m12577j());
                        flatBufferBuilder.c(2);
                        flatBufferBuilder.b(0, a);
                        flatBufferBuilder.b(1, a2);
                        i();
                        return flatBufferBuilder.d();
                    }
                }

                /* compiled from: last active */
                public class Serializer extends JsonSerializer<NodesModel> {
                    public final void m12578a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        NodesModel nodesModel = (NodesModel) obj;
                        if (nodesModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(nodesModel.m12579a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            nodesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        PagePhotoMenusParser.NodesParser.m12667b(nodesModel.w_(), nodesModel.u_(), jsonGenerator, serializerProvider);
                    }

                    static {
                        FbSerializerProvider.a(NodesModel.class, new Serializer());
                    }
                }

                public NodesModel() {
                    super(1);
                }

                @Nullable
                public final PagePhotoMenuPhotosModel m12581a() {
                    this.f10589d = (PagePhotoMenuPhotosModel) super.a(this.f10589d, 0, PagePhotoMenuPhotosModel.class);
                    return this.f10589d;
                }

                public final int jK_() {
                    return 19053762;
                }

                public final GraphQLVisitableModel m12580a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    GraphQLVisitableModel graphQLVisitableModel = null;
                    h();
                    if (m12581a() != null) {
                        PagePhotoMenuPhotosModel pagePhotoMenuPhotosModel = (PagePhotoMenuPhotosModel) graphQLModelMutatingVisitor.b(m12581a());
                        if (m12581a() != pagePhotoMenuPhotosModel) {
                            graphQLVisitableModel = (NodesModel) ModelHelper.a(null, this);
                            graphQLVisitableModel.f10589d = pagePhotoMenuPhotosModel;
                        }
                    }
                    i();
                    return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                }

                public final int m12579a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int a = ModelHelper.a(flatBufferBuilder, m12581a());
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.b(0, a);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            /* compiled from: last active */
            public class Serializer extends JsonSerializer<PagePhotoMenusModel> {
                public final void m12582a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    PagePhotoMenusModel pagePhotoMenusModel = (PagePhotoMenusModel) obj;
                    if (pagePhotoMenusModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(pagePhotoMenusModel.m12583a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        pagePhotoMenusModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    PagePhotoMenusParser.m12669a(pagePhotoMenusModel.w_(), pagePhotoMenusModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(PagePhotoMenusModel.class, new Serializer());
                }
            }

            public PagePhotoMenusModel() {
                super(1);
            }

            @Nonnull
            public final ImmutableList<NodesModel> m12585a() {
                this.f10590d = super.a(this.f10590d, 0, NodesModel.class);
                return (ImmutableList) this.f10590d;
            }

            public final int jK_() {
                return -889078353;
            }

            public final GraphQLVisitableModel m12584a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m12585a() != null) {
                    Builder a = ModelHelper.a(m12585a(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        graphQLVisitableModel = (PagePhotoMenusModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f10590d = a.b();
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m12583a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m12585a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, a);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: last active */
        public class Serializer extends JsonSerializer<MediaFetchPageMenusModel> {
            public final void m12586a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                MediaFetchPageMenusModel mediaFetchPageMenusModel = (MediaFetchPageMenusModel) obj;
                if (mediaFetchPageMenusModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(mediaFetchPageMenusModel.m12587a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mediaFetchPageMenusModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = mediaFetchPageMenusModel.w_();
                int u_ = mediaFetchPageMenusModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("page_photo_menus");
                    PagePhotoMenusParser.m12669a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(MediaFetchPageMenusModel.class, new Serializer());
            }
        }

        public MediaFetchPageMenusModel() {
            super(1);
        }

        public final void m12590a(String str, ConsistencyTuple consistencyTuple) {
            consistencyTuple.a();
        }

        public final void m12591a(String str, Object obj, boolean z) {
        }

        @Nullable
        public final PagePhotoMenusModel m12589a() {
            this.f10591d = (PagePhotoMenusModel) super.a(this.f10591d, 0, PagePhotoMenusModel.class);
            return this.f10591d;
        }

        public final int jK_() {
            return 2479791;
        }

        public final GraphQLVisitableModel m12588a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m12589a() != null) {
                PagePhotoMenusModel pagePhotoMenusModel = (PagePhotoMenusModel) graphQLModelMutatingVisitor.b(m12589a());
                if (m12589a() != pagePhotoMenusModel) {
                    graphQLVisitableModel = (MediaFetchPageMenusModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f10591d = pagePhotoMenusModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m12587a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m12589a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 497041917)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: last active */
    public final class MediaFetchPhotosByCategoryModel extends BaseModel implements GraphQLVisitableConsistentModel {
        @Nullable
        private PhotosByCategoryModel f10594d;

        /* compiled from: last active */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(MediaFetchPhotosByCategoryModel.class, new Deserializer());
            }

            public Object m12592a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = MediaFetchPhotosByCategoryParser.m12673a(jsonParser);
                Object mediaFetchPhotosByCategoryModel = new MediaFetchPhotosByCategoryModel();
                ((BaseModel) mediaFetchPhotosByCategoryModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (mediaFetchPhotosByCategoryModel instanceof Postprocessable) {
                    return ((Postprocessable) mediaFetchPhotosByCategoryModel).a();
                }
                return mediaFetchPhotosByCategoryModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1122935727)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: last active */
        public final class PhotosByCategoryModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private List<MediaMetadataModel> f10592d;
            @Nullable
            private MediaPageInfoModel f10593e;

            /* compiled from: last active */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(PhotosByCategoryModel.class, new Deserializer());
                }

                public Object m12593a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(PhotosByCategoryParser.m12671a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object photosByCategoryModel = new PhotosByCategoryModel();
                    ((BaseModel) photosByCategoryModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (photosByCategoryModel instanceof Postprocessable) {
                        return ((Postprocessable) photosByCategoryModel).a();
                    }
                    return photosByCategoryModel;
                }
            }

            /* compiled from: last active */
            public class Serializer extends JsonSerializer<PhotosByCategoryModel> {
                public final void m12594a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    PhotosByCategoryModel photosByCategoryModel = (PhotosByCategoryModel) obj;
                    if (photosByCategoryModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(photosByCategoryModel.m12595a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        photosByCategoryModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    PhotosByCategoryParser.m12672a(photosByCategoryModel.w_(), photosByCategoryModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(PhotosByCategoryModel.class, new Serializer());
                }
            }

            public PhotosByCategoryModel() {
                super(2);
            }

            @Nonnull
            public final ImmutableList<MediaMetadataModel> m12597a() {
                this.f10592d = super.a(this.f10592d, 0, MediaMetadataModel.class);
                return (ImmutableList) this.f10592d;
            }

            @Nullable
            public final MediaPageInfoModel m12598j() {
                this.f10593e = (MediaPageInfoModel) super.a(this.f10593e, 1, MediaPageInfoModel.class);
                return this.f10593e;
            }

            public final int jK_() {
                return 565084532;
            }

            public final GraphQLVisitableModel m12596a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel;
                MediaPageInfoModel mediaPageInfoModel;
                h();
                if (m12597a() != null) {
                    Builder a = ModelHelper.a(m12597a(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        PhotosByCategoryModel photosByCategoryModel = (PhotosByCategoryModel) ModelHelper.a(null, this);
                        photosByCategoryModel.f10592d = a.b();
                        graphQLVisitableModel = photosByCategoryModel;
                        if (m12598j() != null) {
                            mediaPageInfoModel = (MediaPageInfoModel) graphQLModelMutatingVisitor.b(m12598j());
                            if (m12598j() != mediaPageInfoModel) {
                                graphQLVisitableModel = (PhotosByCategoryModel) ModelHelper.a(graphQLVisitableModel, this);
                                graphQLVisitableModel.f10593e = mediaPageInfoModel;
                            }
                        }
                        i();
                        return graphQLVisitableModel != null ? this : graphQLVisitableModel;
                    }
                }
                graphQLVisitableModel = null;
                if (m12598j() != null) {
                    mediaPageInfoModel = (MediaPageInfoModel) graphQLModelMutatingVisitor.b(m12598j());
                    if (m12598j() != mediaPageInfoModel) {
                        graphQLVisitableModel = (PhotosByCategoryModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f10593e = mediaPageInfoModel;
                    }
                }
                i();
                if (graphQLVisitableModel != null) {
                }
            }

            public final int m12595a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m12597a());
                int a2 = ModelHelper.a(flatBufferBuilder, m12598j());
                flatBufferBuilder.c(2);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.b(1, a2);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: last active */
        public class Serializer extends JsonSerializer<MediaFetchPhotosByCategoryModel> {
            public final void m12599a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                MediaFetchPhotosByCategoryModel mediaFetchPhotosByCategoryModel = (MediaFetchPhotosByCategoryModel) obj;
                if (mediaFetchPhotosByCategoryModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(mediaFetchPhotosByCategoryModel.m12600a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mediaFetchPhotosByCategoryModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = mediaFetchPhotosByCategoryModel.w_();
                int u_ = mediaFetchPhotosByCategoryModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("photos_by_category");
                    PhotosByCategoryParser.m12672a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(MediaFetchPhotosByCategoryModel.class, new Serializer());
            }
        }

        public MediaFetchPhotosByCategoryModel() {
            super(1);
        }

        public final void m12603a(String str, ConsistencyTuple consistencyTuple) {
            consistencyTuple.a();
        }

        public final void m12604a(String str, Object obj, boolean z) {
        }

        @Nullable
        public final PhotosByCategoryModel m12602a() {
            this.f10594d = (PhotosByCategoryModel) super.a(this.f10594d, 0, PhotosByCategoryModel.class);
            return this.f10594d;
        }

        public final int jK_() {
            return 2479791;
        }

        public final GraphQLVisitableModel m12601a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m12602a() != null) {
                PhotosByCategoryModel photosByCategoryModel = (PhotosByCategoryModel) graphQLModelMutatingVisitor.b(m12602a());
                if (m12602a() != photosByCategoryModel) {
                    graphQLVisitableModel = (MediaFetchPhotosByCategoryModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f10594d = photosByCategoryModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m12600a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m12602a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 1536830492)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: last active */
    public final class MediaPageInfoModel extends BaseModel implements DefaultPageInfoFields, GraphQLVisitableModel {
        @Nullable
        private String f10600d;
        @Nullable
        private String f10601e;
        private boolean f10602f;
        private boolean f10603g;
        @Nullable
        private String f10604h;

        /* compiled from: last active */
        public final class Builder {
            @Nullable
            public String f10595a;
            @Nullable
            public String f10596b;
            public boolean f10597c;
            public boolean f10598d;
            @Nullable
            public String f10599e;

            public final MediaPageInfoModel m12605a() {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                int b = flatBufferBuilder.b(this.f10595a);
                int b2 = flatBufferBuilder.b(this.f10596b);
                int b3 = flatBufferBuilder.b(this.f10599e);
                flatBufferBuilder.c(5);
                flatBufferBuilder.b(0, b);
                flatBufferBuilder.b(1, b2);
                flatBufferBuilder.a(2, this.f10597c);
                flatBufferBuilder.a(3, this.f10598d);
                flatBufferBuilder.b(4, b3);
                flatBufferBuilder.d(flatBufferBuilder.d());
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                return new MediaPageInfoModel(new MutableFlatBuffer(wrap, null, null, true, null));
            }
        }

        /* compiled from: last active */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(MediaPageInfoModel.class, new Deserializer());
            }

            public Object m12606a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(MediaPageInfoParser.m12674a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object mediaPageInfoModel = new MediaPageInfoModel();
                ((BaseModel) mediaPageInfoModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (mediaPageInfoModel instanceof Postprocessable) {
                    return ((Postprocessable) mediaPageInfoModel).a();
                }
                return mediaPageInfoModel;
            }
        }

        /* compiled from: last active */
        public class Serializer extends JsonSerializer<MediaPageInfoModel> {
            public final void m12607a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MediaPageInfoModel mediaPageInfoModel = (MediaPageInfoModel) obj;
                if (mediaPageInfoModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(mediaPageInfoModel.m12609a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mediaPageInfoModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                MediaPageInfoParser.m12675a(mediaPageInfoModel.w_(), mediaPageInfoModel.u_(), jsonGenerator);
            }

            static {
                FbSerializerProvider.a(MediaPageInfoModel.class, new Serializer());
            }
        }

        public MediaPageInfoModel() {
            super(5);
        }

        public MediaPageInfoModel(MutableFlatBuffer mutableFlatBuffer) {
            super(5);
            a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
        }

        @Nullable
        private String m12608j() {
            this.f10600d = super.a(this.f10600d, 0);
            return this.f10600d;
        }

        @Nullable
        public final String m12611a() {
            this.f10601e = super.a(this.f10601e, 1);
            return this.f10601e;
        }

        public final boolean m12613b() {
            a(0, 2);
            return this.f10602f;
        }

        public final boolean m12614c() {
            a(0, 3);
            return this.f10603g;
        }

        @Nullable
        public final String v_() {
            this.f10604h = super.a(this.f10604h, 4);
            return this.f10604h;
        }

        public final int jK_() {
            return 923779069;
        }

        public final GraphQLVisitableModel m12610a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            h();
            i();
            return this;
        }

        public final int m12609a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(m12608j());
            int b2 = flatBufferBuilder.b(m12611a());
            int b3 = flatBufferBuilder.b(v_());
            flatBufferBuilder.c(5);
            flatBufferBuilder.b(0, b);
            flatBufferBuilder.b(1, b2);
            flatBufferBuilder.a(2, this.f10602f);
            flatBufferBuilder.a(3, this.f10603g);
            flatBufferBuilder.b(4, b3);
            i();
            return flatBufferBuilder.d();
        }

        public final void m12612a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
            super.a(mutableFlatBuffer, i, obj);
            this.f10602f = mutableFlatBuffer.a(i, 2);
            this.f10603g = mutableFlatBuffer.a(i, 3);
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 25462476)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: last active */
    public final class MediaWithAttributionFetchFromReactionStoryModel extends BaseModel implements GraphQLVisitableConsistentModel {
        @Nullable
        private GraphQLObjectType f10609d;
        @Nullable
        private ReactionAttachmentsModel f10610e;

        /* compiled from: last active */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(MediaWithAttributionFetchFromReactionStoryModel.class, new Deserializer());
            }

            public Object m12615a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = MediaWithAttributionFetchFromReactionStoryParser.m12680a(jsonParser);
                Object mediaWithAttributionFetchFromReactionStoryModel = new MediaWithAttributionFetchFromReactionStoryModel();
                ((BaseModel) mediaWithAttributionFetchFromReactionStoryModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (mediaWithAttributionFetchFromReactionStoryModel instanceof Postprocessable) {
                    return ((Postprocessable) mediaWithAttributionFetchFromReactionStoryModel).a();
                }
                return mediaWithAttributionFetchFromReactionStoryModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 1941556369)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: last active */
        public final class ReactionAttachmentsModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private List<NodesModel> f10607d;
            @Nullable
            private MediaPageInfoModel f10608e;

            /* compiled from: last active */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(ReactionAttachmentsModel.class, new Deserializer());
                }

                public Object m12616a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(MediaWithAttributionFetchFromReactionStoryParser.ReactionAttachmentsParser.m12678a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object reactionAttachmentsModel = new ReactionAttachmentsModel();
                    ((BaseModel) reactionAttachmentsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (reactionAttachmentsModel instanceof Postprocessable) {
                        return ((Postprocessable) reactionAttachmentsModel).a();
                    }
                    return reactionAttachmentsModel;
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = 506528377)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: last active */
            public final class NodesModel extends BaseModel implements GraphQLVisitableModel {
                @Nullable
                private GraphQLObjectType f10605d;
                @Nullable
                private PageMediaWithAttributionModel f10606e;

                /* compiled from: last active */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(NodesModel.class, new Deserializer());
                    }

                    public Object m12617a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(MediaWithAttributionFetchFromReactionStoryParser.ReactionAttachmentsParser.NodesParser.m12676b(jsonParser, flatBufferBuilder));
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

                /* compiled from: last active */
                public class Serializer extends JsonSerializer<NodesModel> {
                    public final void m12618a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        NodesModel nodesModel = (NodesModel) obj;
                        if (nodesModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(nodesModel.m12621a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            nodesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        MediaWithAttributionFetchFromReactionStoryParser.ReactionAttachmentsParser.NodesParser.m12677b(nodesModel.w_(), nodesModel.u_(), jsonGenerator, serializerProvider);
                    }

                    static {
                        FbSerializerProvider.a(NodesModel.class, new Serializer());
                    }
                }

                @Nullable
                public final /* synthetic */ PageMediaWithAttribution m12623a() {
                    return m12620k();
                }

                public NodesModel() {
                    super(2);
                }

                @Nullable
                private GraphQLObjectType m12619j() {
                    if (this.b != null && this.f10605d == null) {
                        this.f10605d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
                    }
                    return this.f10605d;
                }

                @Nullable
                private PageMediaWithAttributionModel m12620k() {
                    this.f10606e = (PageMediaWithAttributionModel) super.a(this.f10606e, 1, PageMediaWithAttributionModel.class);
                    return this.f10606e;
                }

                public final int jK_() {
                    return -1677771153;
                }

                public final GraphQLVisitableModel m12622a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    GraphQLVisitableModel graphQLVisitableModel = null;
                    h();
                    if (m12620k() != null) {
                        PageMediaWithAttributionModel pageMediaWithAttributionModel = (PageMediaWithAttributionModel) graphQLModelMutatingVisitor.b(m12620k());
                        if (m12620k() != pageMediaWithAttributionModel) {
                            graphQLVisitableModel = (NodesModel) ModelHelper.a(null, this);
                            graphQLVisitableModel.f10606e = pageMediaWithAttributionModel;
                        }
                    }
                    i();
                    return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                }

                public final int m12621a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int a = ModelHelper.a(flatBufferBuilder, m12619j());
                    int a2 = ModelHelper.a(flatBufferBuilder, m12620k());
                    flatBufferBuilder.c(2);
                    flatBufferBuilder.b(0, a);
                    flatBufferBuilder.b(1, a2);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            /* compiled from: last active */
            public class Serializer extends JsonSerializer<ReactionAttachmentsModel> {
                public final void m12624a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    ReactionAttachmentsModel reactionAttachmentsModel = (ReactionAttachmentsModel) obj;
                    if (reactionAttachmentsModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(reactionAttachmentsModel.m12626a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        reactionAttachmentsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    MediaWithAttributionFetchFromReactionStoryParser.ReactionAttachmentsParser.m12679a(reactionAttachmentsModel.w_(), reactionAttachmentsModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(ReactionAttachmentsModel.class, new Serializer());
                }
            }

            @Nullable
            public final /* synthetic */ MediaPageInfoModel m12629b() {
                return m12625j();
            }

            public ReactionAttachmentsModel() {
                super(2);
            }

            @Nonnull
            public final ImmutableList<NodesModel> m12628a() {
                this.f10607d = super.a(this.f10607d, 0, NodesModel.class);
                return (ImmutableList) this.f10607d;
            }

            @Nullable
            private MediaPageInfoModel m12625j() {
                this.f10608e = (MediaPageInfoModel) super.a(this.f10608e, 1, MediaPageInfoModel.class);
                return this.f10608e;
            }

            public final int jK_() {
                return -972595742;
            }

            public final GraphQLVisitableModel m12627a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel;
                MediaPageInfoModel mediaPageInfoModel;
                h();
                if (m12628a() != null) {
                    Builder a = ModelHelper.a(m12628a(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        ReactionAttachmentsModel reactionAttachmentsModel = (ReactionAttachmentsModel) ModelHelper.a(null, this);
                        reactionAttachmentsModel.f10607d = a.b();
                        graphQLVisitableModel = reactionAttachmentsModel;
                        if (m12625j() != null) {
                            mediaPageInfoModel = (MediaPageInfoModel) graphQLModelMutatingVisitor.b(m12625j());
                            if (m12625j() != mediaPageInfoModel) {
                                graphQLVisitableModel = (ReactionAttachmentsModel) ModelHelper.a(graphQLVisitableModel, this);
                                graphQLVisitableModel.f10608e = mediaPageInfoModel;
                            }
                        }
                        i();
                        return graphQLVisitableModel != null ? this : graphQLVisitableModel;
                    }
                }
                graphQLVisitableModel = null;
                if (m12625j() != null) {
                    mediaPageInfoModel = (MediaPageInfoModel) graphQLModelMutatingVisitor.b(m12625j());
                    if (m12625j() != mediaPageInfoModel) {
                        graphQLVisitableModel = (ReactionAttachmentsModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f10608e = mediaPageInfoModel;
                    }
                }
                i();
                if (graphQLVisitableModel != null) {
                }
            }

            public final int m12626a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m12628a());
                int a2 = ModelHelper.a(flatBufferBuilder, m12625j());
                flatBufferBuilder.c(2);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.b(1, a2);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: last active */
        public class Serializer extends JsonSerializer<MediaWithAttributionFetchFromReactionStoryModel> {
            public final void m12630a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                MediaWithAttributionFetchFromReactionStoryModel mediaWithAttributionFetchFromReactionStoryModel = (MediaWithAttributionFetchFromReactionStoryModel) obj;
                if (mediaWithAttributionFetchFromReactionStoryModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(mediaWithAttributionFetchFromReactionStoryModel.m12633a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mediaWithAttributionFetchFromReactionStoryModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = mediaWithAttributionFetchFromReactionStoryModel.w_();
                int u_ = mediaWithAttributionFetchFromReactionStoryModel.u_();
                jsonGenerator.f();
                if (mutableFlatBuffer.g(u_, 0) != 0) {
                    jsonGenerator.a("__type__");
                    SerializerHelpers.b(mutableFlatBuffer, u_, 0, jsonGenerator);
                }
                int g = mutableFlatBuffer.g(u_, 1);
                if (g != 0) {
                    jsonGenerator.a("reaction_attachments");
                    MediaWithAttributionFetchFromReactionStoryParser.ReactionAttachmentsParser.m12679a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(MediaWithAttributionFetchFromReactionStoryModel.class, new Serializer());
            }
        }

        @Nullable
        public final /* synthetic */ ReactionAttachmentsModel m12635a() {
            return m12632k();
        }

        public MediaWithAttributionFetchFromReactionStoryModel() {
            super(2);
        }

        public final void m12636a(String str, ConsistencyTuple consistencyTuple) {
            consistencyTuple.a();
        }

        public final void m12637a(String str, Object obj, boolean z) {
        }

        @Nullable
        private GraphQLObjectType m12631j() {
            if (this.b != null && this.f10609d == null) {
                this.f10609d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
            }
            return this.f10609d;
        }

        @Nullable
        private ReactionAttachmentsModel m12632k() {
            this.f10610e = (ReactionAttachmentsModel) super.a(this.f10610e, 1, ReactionAttachmentsModel.class);
            return this.f10610e;
        }

        public final int jK_() {
            return 2433570;
        }

        public final GraphQLVisitableModel m12634a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m12632k() != null) {
                ReactionAttachmentsModel reactionAttachmentsModel = (ReactionAttachmentsModel) graphQLModelMutatingVisitor.b(m12632k());
                if (m12632k() != reactionAttachmentsModel) {
                    graphQLVisitableModel = (MediaWithAttributionFetchFromReactionStoryModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f10610e = reactionAttachmentsModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m12633a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m12631j());
            int a2 = ModelHelper.a(flatBufferBuilder, m12632k());
            flatBufferBuilder.c(2);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, a2);
            i();
            return flatBufferBuilder.d();
        }
    }
}
