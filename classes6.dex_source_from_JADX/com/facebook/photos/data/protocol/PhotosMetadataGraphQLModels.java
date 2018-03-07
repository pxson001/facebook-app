package com.facebook.photos.data.protocol;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbSerializerProvider;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.composer.minutiae.graphql.MinutiaeDefaultsGraphQLModels.MinutiaeTaggableActivityPreviewTemplateFieldsModel;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.FragmentModelWithoutBridge;
import com.facebook.flatbuffers.ModelWithFlatBufferFormatHash;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.enums.GraphQLObjectType;
import com.facebook.graphql.enums.GraphQLPhotosAlbumAPIType;
import com.facebook.graphql.enums.GraphQLPlaceSuggestionType;
import com.facebook.graphql.enums.GraphQLProfilePictureActionLinkType;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.querybuilder.common.CommonGraphQL2Interfaces.DefaultVect2Fields;
import com.facebook.graphql.querybuilder.common.CommonGraphQL2Models.DefaultVect2FieldsModel;
import com.facebook.graphql.querybuilder.common.CommonGraphQLInterfaces.DefaultImageFields;
import com.facebook.graphql.querybuilder.common.CommonGraphQLModels.DefaultImageFieldsModel;
import com.facebook.graphql.querybuilder.common.TextWithEntitiesGraphQLInterfaces.DefaultTextWithEntitiesLongFields;
import com.facebook.graphql.querybuilder.common.TextWithEntitiesGraphQLModels.DefaultTextWithEntitiesLongFieldsModel;
import com.facebook.graphql.visitor.ConsistencyTuple;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLPersistableNode;
import com.facebook.graphql.visitor.GraphQLVisitableConsistentModel;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.facebook.heisman.protocol.imageoverlay.ImageOverlayGraphQLModels.ImageOverlayFieldsModel;
import com.facebook.photos.data.protocol.PhotosMetadataGraphQLInterfaces.LocationSuggestion;
import com.facebook.photos.data.protocol.PhotosMetadataGraphQLInterfaces.MediaMetadata;
import com.facebook.photos.data.protocol.PhotosMetadataGraphQLInterfaces.MediaMetadataWithoutFeedback;
import com.facebook.photos.data.protocol.PhotosMetadataGraphQLInterfaces.MediaPrivacyAndContainerStory;
import com.facebook.photos.data.protocol.PhotosMetadataGraphQLInterfaces.PageMediaWithAttribution;
import com.facebook.photos.data.protocol.PhotosMetadataGraphQLParsers.FaceBoxInfoParser;
import com.facebook.photos.data.protocol.PhotosMetadataGraphQLParsers.FaceBoxSuggestionsQueryParser;
import com.facebook.photos.data.protocol.PhotosMetadataGraphQLParsers.FaceBoxSuggestionsQueryParser.EdgesParser;
import com.facebook.photos.data.protocol.PhotosMetadataGraphQLParsers.FaceBoxUserParser;
import com.facebook.photos.data.protocol.PhotosMetadataGraphQLParsers.InlineActivityObjectParser;
import com.facebook.photos.data.protocol.PhotosMetadataGraphQLParsers.LocationSuggestionParser;
import com.facebook.photos.data.protocol.PhotosMetadataGraphQLParsers.LocationSuggestionParser.LocationTagSuggestionParser;
import com.facebook.photos.data.protocol.PhotosMetadataGraphQLParsers.MediaMetadataAttributionAppParser;
import com.facebook.photos.data.protocol.PhotosMetadataGraphQLParsers.MediaMetadataAttributionAppParser.NativeStoreObjectParser;
import com.facebook.photos.data.protocol.PhotosMetadataGraphQLParsers.MediaMetadataAttributionAppParser.SquareLogoParser;
import com.facebook.photos.data.protocol.PhotosMetadataGraphQLParsers.MediaMetadataCreationStoryParser.SponsoredDataParser.UserParser;
import com.facebook.photos.data.protocol.PhotosMetadataGraphQLParsers.MediaMetadataInlineActivitiesParser;
import com.facebook.photos.data.protocol.PhotosMetadataGraphQLParsers.MediaMetadataOwnerParser;
import com.facebook.photos.data.protocol.PhotosMetadataGraphQLParsers.MediaMetadataParser;
import com.facebook.photos.data.protocol.PhotosMetadataGraphQLParsers.MediaMetadataWithoutFeedbackParser;
import com.facebook.photos.data.protocol.PhotosMetadataGraphQLParsers.MediaMetadataWithoutFeedbackParser.AlbumParser;
import com.facebook.photos.data.protocol.PhotosMetadataGraphQLParsers.MediaMetadataWithoutFeedbackParser.ExplicitPlaceParser;
import com.facebook.photos.data.protocol.PhotosMetadataGraphQLParsers.MediaMetadataWithoutFeedbackParser.PendingPlaceParser;
import com.facebook.photos.data.protocol.PhotosMetadataGraphQLParsers.MediaMetadataWithoutFeedbackParser.WithTagsParser;
import com.facebook.photos.data.protocol.PhotosMetadataGraphQLParsers.MediaMetadataWithoutFeedbackParser.WithTagsParser.NodesParser;
import com.facebook.photos.data.protocol.PhotosMetadataGraphQLParsers.PageMediaWithAttributionParser;
import com.facebook.photos.data.protocol.PhotosMetadataGraphQLParsers.PageMediaWithAttributionParser.OwnerParser;
import com.facebook.photos.data.protocol.PhotosMetadataGraphQLParsers.PageMediaWithAttributionParser.PrivacyScopeParser;
import com.facebook.photos.data.protocol.PhotosMetadataGraphQLParsers.PageMediaWithAttributionParser.PrivacyScopeParser.IconImageParser;
import com.facebook.photos.data.protocol.PhotosMetadataGraphQLParsers.PhotosFaceBoxesQueryParser;
import com.facebook.photos.data.protocol.PhotosMetadataGraphQLParsers.PlaceInfoParser;
import com.facebook.photos.data.protocol.PhotosMetadataGraphQLParsers.PlaceInfoParser.PlaceProfilePictureParser;
import com.facebook.photos.data.protocol.PhotosMetadataGraphQLParsers.TagInfoParser;
import com.facebook.photos.data.protocol.PhotosMetadataGraphQLParsers.TagInfoParser.TaggerParser;
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

/* compiled from: suggest_edits */
public class PhotosMetadataGraphQLModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -404903680)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: suggest_edits */
    public final class FaceBoxInfoModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel {
        @Nullable
        private DefaultVect2FieldsModel f3568d;
        @Nullable
        private DefaultVect2FieldsModel f3569e;
        @Nullable
        private String f3570f;
        @Nullable
        private FaceBoxSuggestionsQueryModel f3571g;

        /* compiled from: suggest_edits */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(FaceBoxInfoModel.class, new Deserializer());
            }

            public Object m4934a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(FaceBoxInfoParser.m5404b(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object faceBoxInfoModel = new FaceBoxInfoModel();
                ((BaseModel) faceBoxInfoModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (faceBoxInfoModel instanceof Postprocessable) {
                    return ((Postprocessable) faceBoxInfoModel).a();
                }
                return faceBoxInfoModel;
            }
        }

        /* compiled from: suggest_edits */
        public class Serializer extends JsonSerializer<FaceBoxInfoModel> {
            public final void m4935a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                FaceBoxInfoModel faceBoxInfoModel = (FaceBoxInfoModel) obj;
                if (faceBoxInfoModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(faceBoxInfoModel.m4939a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    faceBoxInfoModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                FaceBoxInfoParser.m5405b(faceBoxInfoModel.w_(), faceBoxInfoModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(FaceBoxInfoModel.class, new Serializer());
            }
        }

        @Nullable
        public final /* synthetic */ DefaultVect2Fields m4942b() {
            return m4936j();
        }

        @Nullable
        public final /* synthetic */ FaceBoxSuggestionsQueryModel bf_() {
            return m4938l();
        }

        @Nullable
        public final /* synthetic */ DefaultVect2Fields m4943c() {
            return m4937k();
        }

        public FaceBoxInfoModel() {
            super(4);
        }

        @Nullable
        private DefaultVect2FieldsModel m4936j() {
            this.f3568d = (DefaultVect2FieldsModel) super.a(this.f3568d, 0, DefaultVect2FieldsModel.class);
            return this.f3568d;
        }

        @Nullable
        private DefaultVect2FieldsModel m4937k() {
            this.f3569e = (DefaultVect2FieldsModel) super.a(this.f3569e, 1, DefaultVect2FieldsModel.class);
            return this.f3569e;
        }

        @Nullable
        public final String m4944d() {
            this.f3570f = super.a(this.f3570f, 2);
            return this.f3570f;
        }

        @Nullable
        private FaceBoxSuggestionsQueryModel m4938l() {
            this.f3571g = (FaceBoxSuggestionsQueryModel) super.a(this.f3571g, 3, FaceBoxSuggestionsQueryModel.class);
            return this.f3571g;
        }

        @Nullable
        public final String m4941a() {
            return m4944d();
        }

        public final int jK_() {
            return 572280334;
        }

        public final GraphQLVisitableModel m4940a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            DefaultVect2FieldsModel defaultVect2FieldsModel;
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m4936j() != null) {
                defaultVect2FieldsModel = (DefaultVect2FieldsModel) graphQLModelMutatingVisitor.b(m4936j());
                if (m4936j() != defaultVect2FieldsModel) {
                    graphQLVisitableModel = (FaceBoxInfoModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f3568d = defaultVect2FieldsModel;
                }
            }
            if (m4937k() != null) {
                defaultVect2FieldsModel = (DefaultVect2FieldsModel) graphQLModelMutatingVisitor.b(m4937k());
                if (m4937k() != defaultVect2FieldsModel) {
                    graphQLVisitableModel = (FaceBoxInfoModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f3569e = defaultVect2FieldsModel;
                }
            }
            if (m4938l() != null) {
                FaceBoxSuggestionsQueryModel faceBoxSuggestionsQueryModel = (FaceBoxSuggestionsQueryModel) graphQLModelMutatingVisitor.b(m4938l());
                if (m4938l() != faceBoxSuggestionsQueryModel) {
                    graphQLVisitableModel = (FaceBoxInfoModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f3571g = faceBoxSuggestionsQueryModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m4939a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m4936j());
            int a2 = ModelHelper.a(flatBufferBuilder, m4937k());
            int b = flatBufferBuilder.b(m4944d());
            int a3 = ModelHelper.a(flatBufferBuilder, m4938l());
            flatBufferBuilder.c(4);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, a2);
            flatBufferBuilder.b(2, b);
            flatBufferBuilder.b(3, a3);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -628159055)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: suggest_edits */
    public final class FaceBoxSuggestionsQueryModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private List<EdgesModel> f3574d;

        /* compiled from: suggest_edits */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(FaceBoxSuggestionsQueryModel.class, new Deserializer());
            }

            public Object m4945a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(FaceBoxSuggestionsQueryParser.m5408a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object faceBoxSuggestionsQueryModel = new FaceBoxSuggestionsQueryModel();
                ((BaseModel) faceBoxSuggestionsQueryModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (faceBoxSuggestionsQueryModel instanceof Postprocessable) {
                    return ((Postprocessable) faceBoxSuggestionsQueryModel).a();
                }
                return faceBoxSuggestionsQueryModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 562760083)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: suggest_edits */
        public final class EdgesModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private String f3572d;
            @Nullable
            private FaceBoxUserModel f3573e;

            /* compiled from: suggest_edits */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(EdgesModel.class, new Deserializer());
                }

                public Object m4946a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(EdgesParser.m5406b(jsonParser, flatBufferBuilder));
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

            /* compiled from: suggest_edits */
            public class Serializer extends JsonSerializer<EdgesModel> {
                public final void m4947a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    EdgesModel edgesModel = (EdgesModel) obj;
                    if (edgesModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(edgesModel.m4949a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        edgesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    EdgesParser.m5407b(edgesModel.w_(), edgesModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(EdgesModel.class, new Serializer());
                }
            }

            @Nullable
            public final /* synthetic */ FaceBoxUserModel m4952b() {
                return m4948j();
            }

            public EdgesModel() {
                super(2);
            }

            @Nullable
            public final String m4951a() {
                this.f3572d = super.a(this.f3572d, 0);
                return this.f3572d;
            }

            @Nullable
            private FaceBoxUserModel m4948j() {
                this.f3573e = (FaceBoxUserModel) super.a(this.f3573e, 1, FaceBoxUserModel.class);
                return this.f3573e;
            }

            public final int jK_() {
                return -1318601472;
            }

            public final GraphQLVisitableModel m4950a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m4948j() != null) {
                    FaceBoxUserModel faceBoxUserModel = (FaceBoxUserModel) graphQLModelMutatingVisitor.b(m4948j());
                    if (m4948j() != faceBoxUserModel) {
                        graphQLVisitableModel = (EdgesModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f3573e = faceBoxUserModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m4949a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m4951a());
                int a = ModelHelper.a(flatBufferBuilder, m4948j());
                flatBufferBuilder.c(2);
                flatBufferBuilder.b(0, b);
                flatBufferBuilder.b(1, a);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: suggest_edits */
        public class Serializer extends JsonSerializer<FaceBoxSuggestionsQueryModel> {
            public final void m4953a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                FaceBoxSuggestionsQueryModel faceBoxSuggestionsQueryModel = (FaceBoxSuggestionsQueryModel) obj;
                if (faceBoxSuggestionsQueryModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(faceBoxSuggestionsQueryModel.m4954a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    faceBoxSuggestionsQueryModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                FaceBoxSuggestionsQueryParser.m5409a(faceBoxSuggestionsQueryModel.w_(), faceBoxSuggestionsQueryModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(FaceBoxSuggestionsQueryModel.class, new Serializer());
            }
        }

        public FaceBoxSuggestionsQueryModel() {
            super(1);
        }

        @Nonnull
        public final ImmutableList<EdgesModel> m4956a() {
            this.f3574d = super.a(this.f3574d, 0, EdgesModel.class);
            return (ImmutableList) this.f3574d;
        }

        public final int jK_() {
            return -1652092959;
        }

        public final GraphQLVisitableModel m4955a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m4956a() != null) {
                Builder a = ModelHelper.a(m4956a(), graphQLModelMutatingVisitor);
                if (a != null) {
                    graphQLVisitableModel = (FaceBoxSuggestionsQueryModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f3574d = a.b();
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m4954a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m4956a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -1787905591)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: suggest_edits */
    public final class FaceBoxUserModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
        @Nullable
        private GraphQLObjectType f3575d;
        @Nullable
        private String f3576e;

        /* compiled from: suggest_edits */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(FaceBoxUserModel.class, new Deserializer());
            }

            public Object m4957a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(FaceBoxUserParser.m5410a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object faceBoxUserModel = new FaceBoxUserModel();
                ((BaseModel) faceBoxUserModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (faceBoxUserModel instanceof Postprocessable) {
                    return ((Postprocessable) faceBoxUserModel).a();
                }
                return faceBoxUserModel;
            }
        }

        /* compiled from: suggest_edits */
        public class Serializer extends JsonSerializer<FaceBoxUserModel> {
            public final void m4958a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                FaceBoxUserModel faceBoxUserModel = (FaceBoxUserModel) obj;
                if (faceBoxUserModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(faceBoxUserModel.m4959a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    faceBoxUserModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                FaceBoxUserParser.m5411a(faceBoxUserModel.w_(), faceBoxUserModel.u_(), jsonGenerator);
            }

            static {
                FbSerializerProvider.a(FaceBoxUserModel.class, new Serializer());
            }
        }

        public FaceBoxUserModel() {
            super(2);
        }

        public final void m4962a(String str, ConsistencyTuple consistencyTuple) {
            consistencyTuple.a();
        }

        public final void m4963a(String str, Object obj, boolean z) {
        }

        @Nullable
        public final GraphQLObjectType m4964b() {
            if (this.b != null && this.f3575d == null) {
                this.f3575d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
            }
            return this.f3575d;
        }

        @Nullable
        public final String m4965c() {
            this.f3576e = super.a(this.f3576e, 1);
            return this.f3576e;
        }

        @Nullable
        public final String m4961a() {
            return m4965c();
        }

        public final int jK_() {
            return 1355227529;
        }

        public final GraphQLVisitableModel m4960a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            h();
            i();
            return this;
        }

        public final int m4959a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m4964b());
            int b = flatBufferBuilder.b(m4965c());
            flatBufferBuilder.c(2);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, b);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -1611504741)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: suggest_edits */
    public final class InlineActivityInfoModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel {
        @Nullable
        private String f3579d;
        @Nullable
        private InlineActivityObjectModel f3580e;
        @Nullable
        private MinutiaeTaggableActivityPreviewTemplateFieldsModel f3581f;
        @Nullable
        private TaggableActivityIconModel f3582g;

        /* compiled from: suggest_edits */
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
                r0 = com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.InlineActivityInfoModel.class;
                r1 = new com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels$InlineActivityInfoModel$Deserializer;
                r1.<init>();
                com.facebook.common.json.GlobalAutoGenDeserializerCache.a(r0, r1);
                return;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.InlineActivityInfoModel.Deserializer.<clinit>():void");
            }

            public java.lang.Object m4966a(com.fasterxml.jackson.core.JsonParser r11, com.fasterxml.jackson.databind.DeserializationContext r12) {
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
                r5 = com.facebook.photos.data.protocol.PhotosMetadataGraphQLParsers.InlineActivityInfoParser.m5416b(r11, r4);
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
                r1 = new com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels$InlineActivityInfoModel;
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
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.InlineActivityInfoModel.Deserializer.a(com.fasterxml.jackson.core.JsonParser, com.fasterxml.jackson.databind.DeserializationContext):java.lang.Object");
            }
        }

        /* compiled from: suggest_edits */
        public class Serializer extends JsonSerializer<InlineActivityInfoModel> {
            public final void m4967a(java.lang.Object r8, com.fasterxml.jackson.core.JsonGenerator r9, com.fasterxml.jackson.databind.SerializerProvider r10) {
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
                r8 = (com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.InlineActivityInfoModel) r8;
                r2 = 0;
                r0 = r8.w_();
                if (r0 != 0) goto L_0x0035;
            L_0x0009:
                r0 = new com.facebook.flatbuffers.FlatBufferBuilder;
                r1 = 128; // 0x80 float:1.794E-43 double:6.32E-322;
                r0.<init>(r1);
                r1 = r8.m4982a(r0);
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
                com.facebook.photos.data.protocol.PhotosMetadataGraphQLParsers.InlineActivityInfoParser.m5417b(r0, r1, r9, r10);
                return;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.InlineActivityInfoModel.Serializer.a(java.lang.Object, com.fasterxml.jackson.core.JsonGenerator, com.fasterxml.jackson.databind.SerializerProvider):void");
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
                r0 = com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.InlineActivityInfoModel.class;
                r1 = new com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels$InlineActivityInfoModel$Serializer;
                r1.<init>();
                com.facebook.common.json.FbSerializerProvider.a(r0, r1);
                return;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.InlineActivityInfoModel.Serializer.<clinit>():void");
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -223314034)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: suggest_edits */
        public final class TaggableActivityIconModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private ImageModel f3578d;

            /* compiled from: suggest_edits */
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
                    r0 = com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.InlineActivityInfoModel.TaggableActivityIconModel.class;
                    r1 = new com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels$InlineActivityInfoModel$TaggableActivityIconModel$Deserializer;
                    r1.<init>();
                    com.facebook.common.json.GlobalAutoGenDeserializerCache.a(r0, r1);
                    return;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.InlineActivityInfoModel.TaggableActivityIconModel.Deserializer.<clinit>():void");
                }

                public java.lang.Object m4968a(com.fasterxml.jackson.core.JsonParser r11, com.fasterxml.jackson.databind.DeserializationContext r12) {
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
                    r5 = com.facebook.photos.data.protocol.PhotosMetadataGraphQLParsers.InlineActivityInfoParser.TaggableActivityIconParser.m5414a(r11, r4);
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
                    r1 = new com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels$InlineActivityInfoModel$TaggableActivityIconModel;
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
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.InlineActivityInfoModel.TaggableActivityIconModel.Deserializer.a(com.fasterxml.jackson.core.JsonParser, com.fasterxml.jackson.databind.DeserializationContext):java.lang.Object");
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = 842551240)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: suggest_edits */
            public final class ImageModel extends BaseModel implements GraphQLVisitableModel {
                @Nullable
                private String f3577d;

                /* compiled from: suggest_edits */
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
                        r0 = com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.InlineActivityInfoModel.TaggableActivityIconModel.ImageModel.class;
                        r1 = new com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels$InlineActivityInfoModel$TaggableActivityIconModel$ImageModel$Deserializer;
                        r1.<init>();
                        com.facebook.common.json.GlobalAutoGenDeserializerCache.a(r0, r1);
                        return;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.InlineActivityInfoModel.TaggableActivityIconModel.ImageModel.Deserializer.<clinit>():void");
                    }

                    public java.lang.Object m4969a(com.fasterxml.jackson.core.JsonParser r11, com.fasterxml.jackson.databind.DeserializationContext r12) {
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
                        r5 = com.facebook.photos.data.protocol.PhotosMetadataGraphQLParsers.InlineActivityInfoParser.TaggableActivityIconParser.ImageParser.m5412a(r11, r4);
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
                        r1 = new com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels$InlineActivityInfoModel$TaggableActivityIconModel$ImageModel;
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
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.InlineActivityInfoModel.TaggableActivityIconModel.ImageModel.Deserializer.a(com.fasterxml.jackson.core.JsonParser, com.fasterxml.jackson.databind.DeserializationContext):java.lang.Object");
                    }
                }

                /* compiled from: suggest_edits */
                public class Serializer extends JsonSerializer<ImageModel> {
                    public final void m4970a(java.lang.Object r8, com.fasterxml.jackson.core.JsonGenerator r9, com.fasterxml.jackson.databind.SerializerProvider r10) {
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
                        r8 = (com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.InlineActivityInfoModel.TaggableActivityIconModel.ImageModel) r8;
                        r2 = 0;
                        r0 = r8.w_();
                        if (r0 != 0) goto L_0x0035;
                    L_0x0009:
                        r0 = new com.facebook.flatbuffers.FlatBufferBuilder;
                        r1 = 128; // 0x80 float:1.794E-43 double:6.32E-322;
                        r0.<init>(r1);
                        r1 = r8.m4971a(r0);
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
                        com.facebook.photos.data.protocol.PhotosMetadataGraphQLParsers.InlineActivityInfoParser.TaggableActivityIconParser.ImageParser.m5413a(r0, r1, r9);
                        return;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.InlineActivityInfoModel.TaggableActivityIconModel.ImageModel.Serializer.a(java.lang.Object, com.fasterxml.jackson.core.JsonGenerator, com.fasterxml.jackson.databind.SerializerProvider):void");
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
                        r0 = com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.InlineActivityInfoModel.TaggableActivityIconModel.ImageModel.class;
                        r1 = new com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels$InlineActivityInfoModel$TaggableActivityIconModel$ImageModel$Serializer;
                        r1.<init>();
                        com.facebook.common.json.FbSerializerProvider.a(r0, r1);
                        return;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.InlineActivityInfoModel.TaggableActivityIconModel.ImageModel.Serializer.<clinit>():void");
                    }
                }

                public ImageModel() {
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
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.InlineActivityInfoModel.TaggableActivityIconModel.ImageModel.<init>():void");
                }

                @javax.annotation.Nullable
                public final java.lang.String m4973a() {
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
                    r0 = r2.f3577d;
                    r1 = 0;
                    r0 = super.a(r0, r1);
                    r2.f3577d = r0;
                    r0 = r2.f3577d;
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.InlineActivityInfoModel.TaggableActivityIconModel.ImageModel.a():java.lang.String");
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
                    r0 = 70760763; // 0x437b93b float:2.15966E-36 double:3.4960462E-316;
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.InlineActivityInfoModel.TaggableActivityIconModel.ImageModel.jK_():int");
                }

                public final com.facebook.graphql.visitor.GraphQLVisitableModel m4972a(com.facebook.graphql.visitor.GraphQLModelMutatingVisitor r1) {
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
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.InlineActivityInfoModel.TaggableActivityIconModel.ImageModel.a(com.facebook.graphql.visitor.GraphQLModelMutatingVisitor):com.facebook.graphql.visitor.GraphQLVisitableModel");
                }

                public final int m4971a(com.facebook.flatbuffers.FlatBufferBuilder r3) {
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
                    r0 = r2.m4973a();
                    r0 = r3.b(r0);
                    r1 = 1;
                    r3.c(r1);
                    r1 = 0;
                    r3.b(r1, r0);
                    r2.i();
                    r0 = r3.d();
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.InlineActivityInfoModel.TaggableActivityIconModel.ImageModel.a(com.facebook.flatbuffers.FlatBufferBuilder):int");
                }
            }

            /* compiled from: suggest_edits */
            public class Serializer extends JsonSerializer<TaggableActivityIconModel> {
                public final void m4974a(java.lang.Object r8, com.fasterxml.jackson.core.JsonGenerator r9, com.fasterxml.jackson.databind.SerializerProvider r10) {
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
                    r8 = (com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.InlineActivityInfoModel.TaggableActivityIconModel) r8;
                    r2 = 0;
                    r0 = r8.w_();
                    if (r0 != 0) goto L_0x0035;
                L_0x0009:
                    r0 = new com.facebook.flatbuffers.FlatBufferBuilder;
                    r1 = 128; // 0x80 float:1.794E-43 double:6.32E-322;
                    r0.<init>(r1);
                    r1 = r8.m4976a(r0);
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
                    com.facebook.photos.data.protocol.PhotosMetadataGraphQLParsers.InlineActivityInfoParser.TaggableActivityIconParser.m5415a(r0, r1, r9, r10);
                    return;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.InlineActivityInfoModel.TaggableActivityIconModel.Serializer.a(java.lang.Object, com.fasterxml.jackson.core.JsonGenerator, com.fasterxml.jackson.databind.SerializerProvider):void");
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
                    r0 = com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.InlineActivityInfoModel.TaggableActivityIconModel.class;
                    r1 = new com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels$InlineActivityInfoModel$TaggableActivityIconModel$Serializer;
                    r1.<init>();
                    com.facebook.common.json.FbSerializerProvider.a(r0, r1);
                    return;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.InlineActivityInfoModel.TaggableActivityIconModel.Serializer.<clinit>():void");
                }
            }

            @javax.annotation.Nullable
            public final /* synthetic */ com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.InlineActivityInfoModel.TaggableActivityIconModel.ImageModel m4978a() {
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
                r0 = r1.m4975j();
                return r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.InlineActivityInfoModel.TaggableActivityIconModel.a():com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels$InlineActivityInfoModel$TaggableActivityIconModel$ImageModel");
            }

            public TaggableActivityIconModel() {
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
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.InlineActivityInfoModel.TaggableActivityIconModel.<init>():void");
            }

            @javax.annotation.Nullable
            private com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.InlineActivityInfoModel.TaggableActivityIconModel.ImageModel m4975j() {
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
                r0 = r3.f3578d;
                r1 = 0;
                r2 = com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.InlineActivityInfoModel.TaggableActivityIconModel.ImageModel.class;
                r0 = super.a(r0, r1, r2);
                r0 = (com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.InlineActivityInfoModel.TaggableActivityIconModel.ImageModel) r0;
                r3.f3578d = r0;
                r0 = r3.f3578d;
                return r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.InlineActivityInfoModel.TaggableActivityIconModel.j():com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels$InlineActivityInfoModel$TaggableActivityIconModel$ImageModel");
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
                r0 = 638969039; // 0x2615e4cf float:5.2004853E-16 double:3.15692651E-315;
                return r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.InlineActivityInfoModel.TaggableActivityIconModel.jK_():int");
            }

            public final com.facebook.graphql.visitor.GraphQLVisitableModel m4977a(com.facebook.graphql.visitor.GraphQLModelMutatingVisitor r4) {
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
                r0 = r3.m4975j();
                if (r0 == 0) goto L_0x0022;
            L_0x000a:
                r0 = r3.m4975j();
                r0 = r4.b(r0);
                r0 = (com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.InlineActivityInfoModel.TaggableActivityIconModel.ImageModel) r0;
                r2 = r3.m4975j();
                if (r2 == r0) goto L_0x0022;
            L_0x001a:
                r1 = com.facebook.graphql.modelutil.ModelHelper.a(r1, r3);
                r1 = (com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.InlineActivityInfoModel.TaggableActivityIconModel) r1;
                r1.f3578d = r0;
            L_0x0022:
                r3.i();
                if (r1 != 0) goto L_0x0028;
            L_0x0027:
                return r3;
            L_0x0028:
                r3 = r1;
                goto L_0x0027;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.InlineActivityInfoModel.TaggableActivityIconModel.a(com.facebook.graphql.visitor.GraphQLModelMutatingVisitor):com.facebook.graphql.visitor.GraphQLVisitableModel");
            }

            public final int m4976a(com.facebook.flatbuffers.FlatBufferBuilder r3) {
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
                r0 = r2.m4975j();
                r0 = com.facebook.graphql.modelutil.ModelHelper.a(r3, r0);
                r1 = 1;
                r3.c(r1);
                r1 = 0;
                r3.b(r1, r0);
                r2.i();
                r0 = r3.d();
                return r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.InlineActivityInfoModel.TaggableActivityIconModel.a(com.facebook.flatbuffers.FlatBufferBuilder):int");
            }
        }

        @javax.annotation.Nullable
        public final /* synthetic */ com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.InlineActivityInfoModel.TaggableActivityIconModel bg_() {
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
            r0 = r1.m4981l();
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.InlineActivityInfoModel.bg_():com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels$InlineActivityInfoModel$TaggableActivityIconModel");
        }

        @javax.annotation.Nullable
        public final /* synthetic */ com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.InlineActivityObjectModel m4986c() {
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
            r0 = r1.m4979j();
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.InlineActivityInfoModel.c():com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels$InlineActivityObjectModel");
        }

        @javax.annotation.Nullable
        public final /* synthetic */ com.facebook.composer.minutiae.graphql.MinutiaeDefaultsGraphQLInterfaces.MinutiaeTaggableActivityPreviewTemplateFields m4987d() {
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
            r0 = r1.m4980k();
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.InlineActivityInfoModel.d():com.facebook.composer.minutiae.graphql.MinutiaeDefaultsGraphQLInterfaces$MinutiaeTaggableActivityPreviewTemplateFields");
        }

        public InlineActivityInfoModel() {
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
            r0 = 4;
            r1.<init>(r0);
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.InlineActivityInfoModel.<init>():void");
        }

        @javax.annotation.Nullable
        public final java.lang.String m4985b() {
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
            r0 = r2.f3579d;
            r1 = 0;
            r0 = super.a(r0, r1);
            r2.f3579d = r0;
            r0 = r2.f3579d;
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.InlineActivityInfoModel.b():java.lang.String");
        }

        @javax.annotation.Nullable
        private com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.InlineActivityObjectModel m4979j() {
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
            r0 = r3.f3580e;
            r1 = 1;
            r2 = com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.InlineActivityObjectModel.class;
            r0 = super.a(r0, r1, r2);
            r0 = (com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.InlineActivityObjectModel) r0;
            r3.f3580e = r0;
            r0 = r3.f3580e;
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.InlineActivityInfoModel.j():com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels$InlineActivityObjectModel");
        }

        @javax.annotation.Nullable
        private com.facebook.composer.minutiae.graphql.MinutiaeDefaultsGraphQLModels.MinutiaeTaggableActivityPreviewTemplateFieldsModel m4980k() {
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
            r0 = r3.f3581f;
            r1 = 2;
            r2 = com.facebook.composer.minutiae.graphql.MinutiaeDefaultsGraphQLModels.MinutiaeTaggableActivityPreviewTemplateFieldsModel.class;
            r0 = super.a(r0, r1, r2);
            r0 = (com.facebook.composer.minutiae.graphql.MinutiaeDefaultsGraphQLModels.MinutiaeTaggableActivityPreviewTemplateFieldsModel) r0;
            r3.f3581f = r0;
            r0 = r3.f3581f;
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.InlineActivityInfoModel.k():com.facebook.composer.minutiae.graphql.MinutiaeDefaultsGraphQLModels$MinutiaeTaggableActivityPreviewTemplateFieldsModel");
        }

        @javax.annotation.Nullable
        private com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.InlineActivityInfoModel.TaggableActivityIconModel m4981l() {
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
            r0 = r3.f3582g;
            r1 = 3;
            r2 = com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.InlineActivityInfoModel.TaggableActivityIconModel.class;
            r0 = super.a(r0, r1, r2);
            r0 = (com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.InlineActivityInfoModel.TaggableActivityIconModel) r0;
            r3.f3582g = r0;
            r0 = r3.f3582g;
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.InlineActivityInfoModel.l():com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels$InlineActivityInfoModel$TaggableActivityIconModel");
        }

        @javax.annotation.Nullable
        public final java.lang.String m4984a() {
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
            r0 = r1.m4985b();
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.InlineActivityInfoModel.a():java.lang.String");
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
            r0 = 1291787496; // 0x4cff1ce8 float:1.3375264E8 double:6.382278235E-315;
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.InlineActivityInfoModel.jK_():int");
        }

        public final com.facebook.graphql.visitor.GraphQLVisitableModel m4983a(com.facebook.graphql.visitor.GraphQLModelMutatingVisitor r4) {
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
            r0 = r3.m4979j();
            if (r0 == 0) goto L_0x0022;
        L_0x000a:
            r0 = r3.m4979j();
            r0 = r4.b(r0);
            r0 = (com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.InlineActivityObjectModel) r0;
            r2 = r3.m4979j();
            if (r2 == r0) goto L_0x0022;
        L_0x001a:
            r1 = com.facebook.graphql.modelutil.ModelHelper.a(r1, r3);
            r1 = (com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.InlineActivityInfoModel) r1;
            r1.f3580e = r0;
        L_0x0022:
            r0 = r3.m4980k();
            if (r0 == 0) goto L_0x0040;
        L_0x0028:
            r0 = r3.m4980k();
            r0 = r4.b(r0);
            r0 = (com.facebook.composer.minutiae.graphql.MinutiaeDefaultsGraphQLModels.MinutiaeTaggableActivityPreviewTemplateFieldsModel) r0;
            r2 = r3.m4980k();
            if (r2 == r0) goto L_0x0040;
        L_0x0038:
            r1 = com.facebook.graphql.modelutil.ModelHelper.a(r1, r3);
            r1 = (com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.InlineActivityInfoModel) r1;
            r1.f3581f = r0;
        L_0x0040:
            r0 = r3.m4981l();
            if (r0 == 0) goto L_0x005e;
        L_0x0046:
            r0 = r3.m4981l();
            r0 = r4.b(r0);
            r0 = (com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.InlineActivityInfoModel.TaggableActivityIconModel) r0;
            r2 = r3.m4981l();
            if (r2 == r0) goto L_0x005e;
        L_0x0056:
            r1 = com.facebook.graphql.modelutil.ModelHelper.a(r1, r3);
            r1 = (com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.InlineActivityInfoModel) r1;
            r1.f3582g = r0;
        L_0x005e:
            r3.i();
            if (r1 != 0) goto L_0x0064;
        L_0x0063:
            return r3;
        L_0x0064:
            r3 = r1;
            goto L_0x0063;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.InlineActivityInfoModel.a(com.facebook.graphql.visitor.GraphQLModelMutatingVisitor):com.facebook.graphql.visitor.GraphQLVisitableModel");
        }

        public final int m4982a(com.facebook.flatbuffers.FlatBufferBuilder r6) {
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
            r5 = this;
            r5.h();
            r0 = r5.m4985b();
            r0 = r6.b(r0);
            r1 = r5.m4979j();
            r1 = com.facebook.graphql.modelutil.ModelHelper.a(r6, r1);
            r2 = r5.m4980k();
            r2 = com.facebook.graphql.modelutil.ModelHelper.a(r6, r2);
            r3 = r5.m4981l();
            r3 = com.facebook.graphql.modelutil.ModelHelper.a(r6, r3);
            r4 = 4;
            r6.c(r4);
            r4 = 0;
            r6.b(r4, r0);
            r0 = 1;
            r6.b(r0, r1);
            r0 = 2;
            r6.b(r0, r2);
            r0 = 3;
            r6.b(r0, r3);
            r5.i();
            r0 = r6.d();
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.InlineActivityInfoModel.a(com.facebook.flatbuffers.FlatBufferBuilder):int");
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 1255661007)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: suggest_edits */
    public final class InlineActivityObjectModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
        @Nullable
        private GraphQLObjectType f3583d;
        @Nullable
        private String f3584e;
        @Nullable
        private String f3585f;

        /* compiled from: suggest_edits */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(InlineActivityObjectModel.class, new Deserializer());
            }

            public Object m4988a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(InlineActivityObjectParser.m5418a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object inlineActivityObjectModel = new InlineActivityObjectModel();
                ((BaseModel) inlineActivityObjectModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (inlineActivityObjectModel instanceof Postprocessable) {
                    return ((Postprocessable) inlineActivityObjectModel).a();
                }
                return inlineActivityObjectModel;
            }
        }

        /* compiled from: suggest_edits */
        public class Serializer extends JsonSerializer<InlineActivityObjectModel> {
            public final void m4989a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                InlineActivityObjectModel inlineActivityObjectModel = (InlineActivityObjectModel) obj;
                if (inlineActivityObjectModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(inlineActivityObjectModel.m4990a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    inlineActivityObjectModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                InlineActivityObjectParser.m5419a(inlineActivityObjectModel.w_(), inlineActivityObjectModel.u_(), jsonGenerator);
            }

            static {
                FbSerializerProvider.a(InlineActivityObjectModel.class, new Serializer());
            }
        }

        public InlineActivityObjectModel() {
            super(3);
        }

        public final void m4993a(String str, ConsistencyTuple consistencyTuple) {
            consistencyTuple.a();
        }

        public final void m4994a(String str, Object obj, boolean z) {
        }

        @Nullable
        public final GraphQLObjectType m4995b() {
            if (this.b != null && this.f3583d == null) {
                this.f3583d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
            }
            return this.f3583d;
        }

        @Nullable
        public final String m4996c() {
            this.f3584e = super.a(this.f3584e, 1);
            return this.f3584e;
        }

        @Nullable
        public final String m4997d() {
            this.f3585f = super.a(this.f3585f, 2);
            return this.f3585f;
        }

        @Nullable
        public final String m4992a() {
            return m4996c();
        }

        public final int jK_() {
            return 2433570;
        }

        public final GraphQLVisitableModel m4991a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            h();
            i();
            return this;
        }

        public final int m4990a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m4995b());
            int b = flatBufferBuilder.b(m4996c());
            int b2 = flatBufferBuilder.b(m4997d());
            flatBufferBuilder.c(3);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, b);
            flatBufferBuilder.b(2, b2);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -1765321342)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: suggest_edits */
    public final class LocationSuggestionModel extends BaseModel implements GraphQLVisitableModel, LocationSuggestion {
        @Nullable
        private LocationTagSuggestionModel f3589d;

        /* compiled from: suggest_edits */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(LocationSuggestionModel.class, new Deserializer());
            }

            public Object m4998a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = LocationSuggestionParser.m5422a(jsonParser);
                Object locationSuggestionModel = new LocationSuggestionModel();
                ((BaseModel) locationSuggestionModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (locationSuggestionModel instanceof Postprocessable) {
                    return ((Postprocessable) locationSuggestionModel).a();
                }
                return locationSuggestionModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 1699296610)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: suggest_edits */
        public final class LocationTagSuggestionModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private PlaceInfoModel f3586d;
            @Nullable
            private String f3587e;
            @Nullable
            private GraphQLPlaceSuggestionType f3588f;

            /* compiled from: suggest_edits */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(LocationTagSuggestionModel.class, new Deserializer());
                }

                public Object m4999a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(LocationTagSuggestionParser.m5420a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object locationTagSuggestionModel = new LocationTagSuggestionModel();
                    ((BaseModel) locationTagSuggestionModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (locationTagSuggestionModel instanceof Postprocessable) {
                        return ((Postprocessable) locationTagSuggestionModel).a();
                    }
                    return locationTagSuggestionModel;
                }
            }

            /* compiled from: suggest_edits */
            public class Serializer extends JsonSerializer<LocationTagSuggestionModel> {
                public final void m5000a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    LocationTagSuggestionModel locationTagSuggestionModel = (LocationTagSuggestionModel) obj;
                    if (locationTagSuggestionModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(locationTagSuggestionModel.m5002a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        locationTagSuggestionModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    LocationTagSuggestionParser.m5421a(locationTagSuggestionModel.w_(), locationTagSuggestionModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(LocationTagSuggestionModel.class, new Serializer());
                }
            }

            @Nullable
            public final /* synthetic */ PlaceInfoModel m5004a() {
                return m5001j();
            }

            public LocationTagSuggestionModel() {
                super(3);
            }

            @Nullable
            private PlaceInfoModel m5001j() {
                this.f3586d = (PlaceInfoModel) super.a(this.f3586d, 0, PlaceInfoModel.class);
                return this.f3586d;
            }

            @Nullable
            public final String m5005b() {
                this.f3587e = super.a(this.f3587e, 1);
                return this.f3587e;
            }

            @Nullable
            public final GraphQLPlaceSuggestionType m5006c() {
                this.f3588f = (GraphQLPlaceSuggestionType) super.b(this.f3588f, 2, GraphQLPlaceSuggestionType.class, GraphQLPlaceSuggestionType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
                return this.f3588f;
            }

            public final int jK_() {
                return 858887577;
            }

            public final GraphQLVisitableModel m5003a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m5001j() != null) {
                    PlaceInfoModel placeInfoModel = (PlaceInfoModel) graphQLModelMutatingVisitor.b(m5001j());
                    if (m5001j() != placeInfoModel) {
                        graphQLVisitableModel = (LocationTagSuggestionModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f3586d = placeInfoModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m5002a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m5001j());
                int b = flatBufferBuilder.b(m5005b());
                int a2 = flatBufferBuilder.a(m5006c());
                flatBufferBuilder.c(3);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.b(1, b);
                flatBufferBuilder.b(2, a2);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: suggest_edits */
        public class Serializer extends JsonSerializer<LocationSuggestionModel> {
            public final void m5007a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                LocationSuggestionModel locationSuggestionModel = (LocationSuggestionModel) obj;
                if (locationSuggestionModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(locationSuggestionModel.m5009a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    locationSuggestionModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = locationSuggestionModel.w_();
                int u_ = locationSuggestionModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("location_tag_suggestion");
                    LocationTagSuggestionParser.m5421a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(LocationSuggestionModel.class, new Serializer());
            }
        }

        public LocationSuggestionModel() {
            super(1);
        }

        @Nullable
        private LocationTagSuggestionModel m5008a() {
            this.f3589d = (LocationTagSuggestionModel) super.a(this.f3589d, 0, LocationTagSuggestionModel.class);
            return this.f3589d;
        }

        public final int jK_() {
            return 77090322;
        }

        public final GraphQLVisitableModel m5010a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m5008a() != null) {
                LocationTagSuggestionModel locationTagSuggestionModel = (LocationTagSuggestionModel) graphQLModelMutatingVisitor.b(m5008a());
                if (m5008a() != locationTagSuggestionModel) {
                    graphQLVisitableModel = (LocationSuggestionModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f3589d = locationTagSuggestionModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m5009a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m5008a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -102033816)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: suggest_edits */
    public final class MediaMetadataAttributionAppModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel {
        @Nullable
        private String f3593d;
        @Nullable
        private String f3594e;
        @Nullable
        private NativeStoreObjectModel f3595f;
        @Nullable
        private SquareLogoModel f3596g;

        /* compiled from: suggest_edits */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(MediaMetadataAttributionAppModel.class, new Deserializer());
            }

            public Object m5011a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(MediaMetadataAttributionAppParser.m5427a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object mediaMetadataAttributionAppModel = new MediaMetadataAttributionAppModel();
                ((BaseModel) mediaMetadataAttributionAppModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (mediaMetadataAttributionAppModel instanceof Postprocessable) {
                    return ((Postprocessable) mediaMetadataAttributionAppModel).a();
                }
                return mediaMetadataAttributionAppModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 1915539409)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: suggest_edits */
        public final class NativeStoreObjectModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private String f3590d;
            @Nullable
            private String f3591e;

            /* compiled from: suggest_edits */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(NativeStoreObjectModel.class, new Deserializer());
                }

                public Object m5012a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(NativeStoreObjectParser.m5423a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object nativeStoreObjectModel = new NativeStoreObjectModel();
                    ((BaseModel) nativeStoreObjectModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (nativeStoreObjectModel instanceof Postprocessable) {
                        return ((Postprocessable) nativeStoreObjectModel).a();
                    }
                    return nativeStoreObjectModel;
                }
            }

            /* compiled from: suggest_edits */
            public class Serializer extends JsonSerializer<NativeStoreObjectModel> {
                public final void m5013a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    NativeStoreObjectModel nativeStoreObjectModel = (NativeStoreObjectModel) obj;
                    if (nativeStoreObjectModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(nativeStoreObjectModel.m5014a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        nativeStoreObjectModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    NativeStoreObjectParser.m5424a(nativeStoreObjectModel.w_(), nativeStoreObjectModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(NativeStoreObjectModel.class, new Serializer());
                }
            }

            public NativeStoreObjectModel() {
                super(2);
            }

            @Nullable
            public final String m5016a() {
                this.f3590d = super.a(this.f3590d, 0);
                return this.f3590d;
            }

            @Nullable
            public final String m5017b() {
                this.f3591e = super.a(this.f3591e, 1);
                return this.f3591e;
            }

            public final int jK_() {
                return -1304127138;
            }

            public final GraphQLVisitableModel m5015a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m5014a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m5016a());
                int b2 = flatBufferBuilder.b(m5017b());
                flatBufferBuilder.c(2);
                flatBufferBuilder.b(0, b);
                flatBufferBuilder.b(1, b2);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: suggest_edits */
        public class Serializer extends JsonSerializer<MediaMetadataAttributionAppModel> {
            public final void m5018a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MediaMetadataAttributionAppModel mediaMetadataAttributionAppModel = (MediaMetadataAttributionAppModel) obj;
                if (mediaMetadataAttributionAppModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(mediaMetadataAttributionAppModel.m5026a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mediaMetadataAttributionAppModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                MediaMetadataAttributionAppParser.m5428a(mediaMetadataAttributionAppModel.w_(), mediaMetadataAttributionAppModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(MediaMetadataAttributionAppModel.class, new Serializer());
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 842551240)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: suggest_edits */
        public final class SquareLogoModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private String f3592d;

            /* compiled from: suggest_edits */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(SquareLogoModel.class, new Deserializer());
                }

                public Object m5019a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(SquareLogoParser.m5425a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object squareLogoModel = new SquareLogoModel();
                    ((BaseModel) squareLogoModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (squareLogoModel instanceof Postprocessable) {
                        return ((Postprocessable) squareLogoModel).a();
                    }
                    return squareLogoModel;
                }
            }

            /* compiled from: suggest_edits */
            public class Serializer extends JsonSerializer<SquareLogoModel> {
                public final void m5020a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    SquareLogoModel squareLogoModel = (SquareLogoModel) obj;
                    if (squareLogoModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(squareLogoModel.m5021a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        squareLogoModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    SquareLogoParser.m5426a(squareLogoModel.w_(), squareLogoModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(SquareLogoModel.class, new Serializer());
                }
            }

            public SquareLogoModel() {
                super(1);
            }

            @Nullable
            public final String m5023a() {
                this.f3592d = super.a(this.f3592d, 0);
                return this.f3592d;
            }

            public final int jK_() {
                return 70760763;
            }

            public final GraphQLVisitableModel m5022a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m5021a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m5023a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, b);
                i();
                return flatBufferBuilder.d();
            }
        }

        @Nullable
        public final /* synthetic */ SquareLogoModel bh_() {
            return m5025k();
        }

        @Nullable
        public final /* synthetic */ NativeStoreObjectModel m5031d() {
            return m5024j();
        }

        public MediaMetadataAttributionAppModel() {
            super(4);
        }

        @Nullable
        public final String m5029b() {
            this.f3593d = super.a(this.f3593d, 0);
            return this.f3593d;
        }

        @Nullable
        public final String m5030c() {
            this.f3594e = super.a(this.f3594e, 1);
            return this.f3594e;
        }

        @Nullable
        private NativeStoreObjectModel m5024j() {
            this.f3595f = (NativeStoreObjectModel) super.a(this.f3595f, 2, NativeStoreObjectModel.class);
            return this.f3595f;
        }

        @Nullable
        private SquareLogoModel m5025k() {
            this.f3596g = (SquareLogoModel) super.a(this.f3596g, 3, SquareLogoModel.class);
            return this.f3596g;
        }

        @Nullable
        public final String m5028a() {
            return m5029b();
        }

        public final int jK_() {
            return -1072845520;
        }

        public final GraphQLVisitableModel m5027a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m5024j() != null) {
                NativeStoreObjectModel nativeStoreObjectModel = (NativeStoreObjectModel) graphQLModelMutatingVisitor.b(m5024j());
                if (m5024j() != nativeStoreObjectModel) {
                    graphQLVisitableModel = (MediaMetadataAttributionAppModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f3595f = nativeStoreObjectModel;
                }
            }
            if (m5025k() != null) {
                SquareLogoModel squareLogoModel = (SquareLogoModel) graphQLModelMutatingVisitor.b(m5025k());
                if (m5025k() != squareLogoModel) {
                    graphQLVisitableModel = (MediaMetadataAttributionAppModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f3596g = squareLogoModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m5026a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(m5029b());
            int b2 = flatBufferBuilder.b(m5030c());
            int a = ModelHelper.a(flatBufferBuilder, m5024j());
            int a2 = ModelHelper.a(flatBufferBuilder, m5025k());
            flatBufferBuilder.c(4);
            flatBufferBuilder.b(0, b);
            flatBufferBuilder.b(1, b2);
            flatBufferBuilder.b(2, a);
            flatBufferBuilder.b(3, a2);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -467055550)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: suggest_edits */
    public final class MediaMetadataCreationStoryModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
        @Nullable
        private ApplicationModel f3604d;
        @Nullable
        private List<AttachmentsModel> f3605e;
        @Nullable
        private String f3606f;
        @Nullable
        private String f3607g;
        @Nullable
        private String f3608h;
        @Nullable
        private SponsoredDataModel f3609i;
        @Nullable
        private String f3610j;

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 1801334754)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: suggest_edits */
        public final class ApplicationModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel {
            @Nullable
            private String f3597d;

            /* compiled from: suggest_edits */
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
                    r0 = com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.MediaMetadataCreationStoryModel.ApplicationModel.class;
                    r1 = new com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels$MediaMetadataCreationStoryModel$ApplicationModel$Deserializer;
                    r1.<init>();
                    com.facebook.common.json.GlobalAutoGenDeserializerCache.a(r0, r1);
                    return;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.MediaMetadataCreationStoryModel.ApplicationModel.Deserializer.<clinit>():void");
                }

                public java.lang.Object m5032a(com.fasterxml.jackson.core.JsonParser r11, com.fasterxml.jackson.databind.DeserializationContext r12) {
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
                    r5 = com.facebook.photos.data.protocol.PhotosMetadataGraphQLParsers.MediaMetadataCreationStoryParser.ApplicationParser.m5429a(r11, r4);
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
                    r1 = new com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels$MediaMetadataCreationStoryModel$ApplicationModel;
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
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.MediaMetadataCreationStoryModel.ApplicationModel.Deserializer.a(com.fasterxml.jackson.core.JsonParser, com.fasterxml.jackson.databind.DeserializationContext):java.lang.Object");
                }
            }

            /* compiled from: suggest_edits */
            public class Serializer extends JsonSerializer<ApplicationModel> {
                public final void m5033a(java.lang.Object r8, com.fasterxml.jackson.core.JsonGenerator r9, com.fasterxml.jackson.databind.SerializerProvider r10) {
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
                    r8 = (com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.MediaMetadataCreationStoryModel.ApplicationModel) r8;
                    r2 = 0;
                    r0 = r8.w_();
                    if (r0 != 0) goto L_0x0035;
                L_0x0009:
                    r0 = new com.facebook.flatbuffers.FlatBufferBuilder;
                    r1 = 128; // 0x80 float:1.794E-43 double:6.32E-322;
                    r0.<init>(r1);
                    r1 = r8.m5034a(r0);
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
                    com.facebook.photos.data.protocol.PhotosMetadataGraphQLParsers.MediaMetadataCreationStoryParser.ApplicationParser.m5430a(r0, r1, r9);
                    return;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.MediaMetadataCreationStoryModel.ApplicationModel.Serializer.a(java.lang.Object, com.fasterxml.jackson.core.JsonGenerator, com.fasterxml.jackson.databind.SerializerProvider):void");
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
                    r0 = com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.MediaMetadataCreationStoryModel.ApplicationModel.class;
                    r1 = new com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels$MediaMetadataCreationStoryModel$ApplicationModel$Serializer;
                    r1.<init>();
                    com.facebook.common.json.FbSerializerProvider.a(r0, r1);
                    return;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.MediaMetadataCreationStoryModel.ApplicationModel.Serializer.<clinit>():void");
                }
            }

            public ApplicationModel() {
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
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.MediaMetadataCreationStoryModel.ApplicationModel.<init>():void");
            }

            @javax.annotation.Nullable
            public final java.lang.String m5037b() {
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
                r0 = r2.f3597d;
                r1 = 0;
                r0 = super.a(r0, r1);
                r2.f3597d = r0;
                r0 = r2.f3597d;
                return r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.MediaMetadataCreationStoryModel.ApplicationModel.b():java.lang.String");
            }

            @javax.annotation.Nullable
            public final java.lang.String m5036a() {
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
                r0 = r1.m5037b();
                return r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.MediaMetadataCreationStoryModel.ApplicationModel.a():java.lang.String");
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
                r0 = -1072845520; // 0xffffffffc00dad30 float:-2.2136955 double:NaN;
                return r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.MediaMetadataCreationStoryModel.ApplicationModel.jK_():int");
            }

            public final com.facebook.graphql.visitor.GraphQLVisitableModel m5035a(com.facebook.graphql.visitor.GraphQLModelMutatingVisitor r1) {
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
                r0 = this;
                r0.h();
                r0.i();
                return r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.MediaMetadataCreationStoryModel.ApplicationModel.a(com.facebook.graphql.visitor.GraphQLModelMutatingVisitor):com.facebook.graphql.visitor.GraphQLVisitableModel");
            }

            public final int m5034a(com.facebook.flatbuffers.FlatBufferBuilder r3) {
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
                r0 = r2.m5037b();
                r0 = r3.b(r0);
                r1 = 1;
                r3.c(r1);
                r1 = 0;
                r3.b(r1, r0);
                r2.i();
                r0 = r3.d();
                return r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.MediaMetadataCreationStoryModel.ApplicationModel.a(com.facebook.flatbuffers.FlatBufferBuilder):int");
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -2048122183)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: suggest_edits */
        public final class AttachmentsModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private List<ActionLinksModel> f3601d;

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = 510804672)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: suggest_edits */
            public final class ActionLinksModel extends BaseModel implements GraphQLVisitableModel {
                @Nullable
                private GraphQLObjectType f3598d;
                @Nullable
                private GraphQLProfilePictureActionLinkType f3599e;
                private long f3600f;

                /* compiled from: suggest_edits */
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
                        r0 = com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.MediaMetadataCreationStoryModel.AttachmentsModel.ActionLinksModel.class;
                        r1 = new com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels$MediaMetadataCreationStoryModel$AttachmentsModel$ActionLinksModel$Deserializer;
                        r1.<init>();
                        com.facebook.common.json.GlobalAutoGenDeserializerCache.a(r0, r1);
                        return;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.MediaMetadataCreationStoryModel.AttachmentsModel.ActionLinksModel.Deserializer.<clinit>():void");
                    }

                    public java.lang.Object m5038a(com.fasterxml.jackson.core.JsonParser r11, com.fasterxml.jackson.databind.DeserializationContext r12) {
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
                        r5 = com.facebook.photos.data.protocol.PhotosMetadataGraphQLParsers.MediaMetadataCreationStoryParser.AttachmentsParser.ActionLinksParser.m5432b(r11, r4);
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
                        r1 = new com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels$MediaMetadataCreationStoryModel$AttachmentsModel$ActionLinksModel;
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
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.MediaMetadataCreationStoryModel.AttachmentsModel.ActionLinksModel.Deserializer.a(com.fasterxml.jackson.core.JsonParser, com.fasterxml.jackson.databind.DeserializationContext):java.lang.Object");
                    }
                }

                /* compiled from: suggest_edits */
                public class Serializer extends JsonSerializer<ActionLinksModel> {
                    public final void m5039a(java.lang.Object r8, com.fasterxml.jackson.core.JsonGenerator r9, com.fasterxml.jackson.databind.SerializerProvider r10) {
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
                        r8 = (com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.MediaMetadataCreationStoryModel.AttachmentsModel.ActionLinksModel) r8;
                        r2 = 0;
                        r0 = r8.w_();
                        if (r0 != 0) goto L_0x0035;
                    L_0x0009:
                        r0 = new com.facebook.flatbuffers.FlatBufferBuilder;
                        r1 = 128; // 0x80 float:1.794E-43 double:6.32E-322;
                        r0.<init>(r1);
                        r1 = r8.m5040a(r0);
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
                        com.facebook.photos.data.protocol.PhotosMetadataGraphQLParsers.MediaMetadataCreationStoryParser.AttachmentsParser.ActionLinksParser.m5431a(r0, r1, r9);
                        return;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.MediaMetadataCreationStoryModel.AttachmentsModel.ActionLinksModel.Serializer.a(java.lang.Object, com.fasterxml.jackson.core.JsonGenerator, com.fasterxml.jackson.databind.SerializerProvider):void");
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
                        r0 = com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.MediaMetadataCreationStoryModel.AttachmentsModel.ActionLinksModel.class;
                        r1 = new com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels$MediaMetadataCreationStoryModel$AttachmentsModel$ActionLinksModel$Serializer;
                        r1.<init>();
                        com.facebook.common.json.FbSerializerProvider.a(r0, r1);
                        return;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.MediaMetadataCreationStoryModel.AttachmentsModel.ActionLinksModel.Serializer.<clinit>():void");
                    }
                }

                public ActionLinksModel() {
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
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.MediaMetadataCreationStoryModel.AttachmentsModel.ActionLinksModel.<init>():void");
                }

                @javax.annotation.Nullable
                public final com.facebook.graphql.enums.GraphQLObjectType m5041a() {
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
                    r0 = r4.b;
                    if (r0 == 0) goto L_0x0017;
                L_0x0004:
                    r0 = r4.f3598d;
                    if (r0 != 0) goto L_0x0017;
                L_0x0008:
                    r0 = r4.b;
                    r1 = r4.c;
                    r2 = 0;
                    r3 = com.facebook.graphql.enums.GraphQLObjectType.class;
                    r0 = r0.d(r1, r2, r3);
                    r0 = (com.facebook.graphql.enums.GraphQLObjectType) r0;
                    r4.f3598d = r0;
                L_0x0017:
                    r0 = r4.f3598d;
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.MediaMetadataCreationStoryModel.AttachmentsModel.ActionLinksModel.a():com.facebook.graphql.enums.GraphQLObjectType");
                }

                @javax.annotation.Nullable
                public final com.facebook.graphql.enums.GraphQLProfilePictureActionLinkType m5044b() {
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
                    r0 = r4.f3599e;
                    r1 = 1;
                    r2 = com.facebook.graphql.enums.GraphQLProfilePictureActionLinkType.class;
                    r3 = com.facebook.graphql.enums.GraphQLProfilePictureActionLinkType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
                    r0 = super.b(r0, r1, r2, r3);
                    r0 = (com.facebook.graphql.enums.GraphQLProfilePictureActionLinkType) r0;
                    r4.f3599e = r0;
                    r0 = r4.f3599e;
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.MediaMetadataCreationStoryModel.AttachmentsModel.ActionLinksModel.b():com.facebook.graphql.enums.GraphQLProfilePictureActionLinkType");
                }

                public final long m5045c() {
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
                    r0 = r2.f3600f;
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.MediaMetadataCreationStoryModel.AttachmentsModel.ActionLinksModel.c():long");
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
                    r0 = -1747569147; // 0xffffffff97d63605 float:-1.3843062E-24 double:NaN;
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.MediaMetadataCreationStoryModel.AttachmentsModel.ActionLinksModel.jK_():int");
                }

                public final com.facebook.graphql.visitor.GraphQLVisitableModel m5042a(com.facebook.graphql.visitor.GraphQLModelMutatingVisitor r1) {
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
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.MediaMetadataCreationStoryModel.AttachmentsModel.ActionLinksModel.a(com.facebook.graphql.visitor.GraphQLModelMutatingVisitor):com.facebook.graphql.visitor.GraphQLVisitableModel");
                }

                public final int m5040a(com.facebook.flatbuffers.FlatBufferBuilder r7) {
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
                    r0 = r6.m5041a();
                    r0 = com.facebook.graphql.modelutil.ModelHelper.a(r7, r0);
                    r1 = r6.m5044b();
                    r1 = r7.a(r1);
                    r2 = 3;
                    r7.c(r2);
                    r2 = 0;
                    r7.b(r2, r0);
                    r0 = 1;
                    r7.b(r0, r1);
                    r1 = 2;
                    r2 = r6.f3600f;
                    r4 = 0;
                    r0 = r7;
                    r0.a(r1, r2, r4);
                    r6.i();
                    r0 = r7.d();
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.MediaMetadataCreationStoryModel.AttachmentsModel.ActionLinksModel.a(com.facebook.flatbuffers.FlatBufferBuilder):int");
                }

                public final void m5043a(com.facebook.flatbuffers.MutableFlatBuffer r5, int r6, java.lang.Object r7) {
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
                    super.a(r5, r6, r7);
                    r0 = 2;
                    r2 = 0;
                    r0 = r5.a(r6, r0, r2);
                    r4.f3600f = r0;
                    return;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.MediaMetadataCreationStoryModel.AttachmentsModel.ActionLinksModel.a(com.facebook.flatbuffers.MutableFlatBuffer, int, java.lang.Object):void");
                }
            }

            /* compiled from: suggest_edits */
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
                    r0 = com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.MediaMetadataCreationStoryModel.AttachmentsModel.class;
                    r1 = new com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels$MediaMetadataCreationStoryModel$AttachmentsModel$Deserializer;
                    r1.<init>();
                    com.facebook.common.json.GlobalAutoGenDeserializerCache.a(r0, r1);
                    return;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.MediaMetadataCreationStoryModel.AttachmentsModel.Deserializer.<clinit>():void");
                }

                public java.lang.Object m5046a(com.fasterxml.jackson.core.JsonParser r11, com.fasterxml.jackson.databind.DeserializationContext r12) {
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
                    r5 = com.facebook.photos.data.protocol.PhotosMetadataGraphQLParsers.MediaMetadataCreationStoryParser.AttachmentsParser.m5433b(r11, r4);
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
                    r1 = new com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels$MediaMetadataCreationStoryModel$AttachmentsModel;
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
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.MediaMetadataCreationStoryModel.AttachmentsModel.Deserializer.a(com.fasterxml.jackson.core.JsonParser, com.fasterxml.jackson.databind.DeserializationContext):java.lang.Object");
                }
            }

            /* compiled from: suggest_edits */
            public class Serializer extends JsonSerializer<AttachmentsModel> {
                public final void m5047a(java.lang.Object r8, com.fasterxml.jackson.core.JsonGenerator r9, com.fasterxml.jackson.databind.SerializerProvider r10) {
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
                    r8 = (com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.MediaMetadataCreationStoryModel.AttachmentsModel) r8;
                    r2 = 0;
                    r0 = r8.w_();
                    if (r0 != 0) goto L_0x0035;
                L_0x0009:
                    r0 = new com.facebook.flatbuffers.FlatBufferBuilder;
                    r1 = 128; // 0x80 float:1.794E-43 double:6.32E-322;
                    r0.<init>(r1);
                    r1 = r8.m5048a(r0);
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
                    com.facebook.photos.data.protocol.PhotosMetadataGraphQLParsers.MediaMetadataCreationStoryParser.AttachmentsParser.m5434b(r0, r1, r9, r10);
                    return;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.MediaMetadataCreationStoryModel.AttachmentsModel.Serializer.a(java.lang.Object, com.fasterxml.jackson.core.JsonGenerator, com.fasterxml.jackson.databind.SerializerProvider):void");
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
                    r0 = com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.MediaMetadataCreationStoryModel.AttachmentsModel.class;
                    r1 = new com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels$MediaMetadataCreationStoryModel$AttachmentsModel$Serializer;
                    r1.<init>();
                    com.facebook.common.json.FbSerializerProvider.a(r0, r1);
                    return;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.MediaMetadataCreationStoryModel.AttachmentsModel.Serializer.<clinit>():void");
                }
            }

            public AttachmentsModel() {
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
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.MediaMetadataCreationStoryModel.AttachmentsModel.<init>():void");
            }

            @javax.annotation.Nonnull
            public final com.google.common.collect.ImmutableList<com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.MediaMetadataCreationStoryModel.AttachmentsModel.ActionLinksModel> m5050a() {
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
                r0 = r3.f3601d;
                r1 = 0;
                r2 = com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.MediaMetadataCreationStoryModel.AttachmentsModel.ActionLinksModel.class;
                r0 = super.a(r0, r1, r2);
                r3.f3601d = r0;
                r0 = r3.f3601d;
                r0 = (com.google.common.collect.ImmutableList) r0;
                return r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.MediaMetadataCreationStoryModel.AttachmentsModel.a():com.google.common.collect.ImmutableList<com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels$MediaMetadataCreationStoryModel$AttachmentsModel$ActionLinksModel>");
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
                r0 = -1267730472; // 0xffffffffb46ff7d8 float:-2.2348775E-7 double:NaN;
                return r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.MediaMetadataCreationStoryModel.AttachmentsModel.jK_():int");
            }

            public final com.facebook.graphql.visitor.GraphQLVisitableModel m5049a(com.facebook.graphql.visitor.GraphQLModelMutatingVisitor r3) {
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
                r1 = r2.m5050a();
                if (r1 == 0) goto L_0x0020;
            L_0x000a:
                r1 = r2.m5050a();
                r1 = com.facebook.graphql.modelutil.ModelHelper.a(r1, r3);
                if (r1 == 0) goto L_0x0020;
            L_0x0014:
                r0 = com.facebook.graphql.modelutil.ModelHelper.a(r0, r2);
                r0 = (com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.MediaMetadataCreationStoryModel.AttachmentsModel) r0;
                r1 = r1.b();
                r0.f3601d = r1;
            L_0x0020:
                r2.i();
                if (r0 != 0) goto L_0x0026;
            L_0x0025:
                return r2;
            L_0x0026:
                r2 = r0;
                goto L_0x0025;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.MediaMetadataCreationStoryModel.AttachmentsModel.a(com.facebook.graphql.visitor.GraphQLModelMutatingVisitor):com.facebook.graphql.visitor.GraphQLVisitableModel");
            }

            public final int m5048a(com.facebook.flatbuffers.FlatBufferBuilder r3) {
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
                r0 = r2.m5050a();
                r0 = com.facebook.graphql.modelutil.ModelHelper.a(r3, r0);
                r1 = 1;
                r3.c(r1);
                r1 = 0;
                r3.b(r1, r0);
                r2.i();
                r0 = r3.d();
                return r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.MediaMetadataCreationStoryModel.AttachmentsModel.a(com.facebook.flatbuffers.FlatBufferBuilder):int");
            }
        }

        /* compiled from: suggest_edits */
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
                r0 = com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.MediaMetadataCreationStoryModel.class;
                r1 = new com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels$MediaMetadataCreationStoryModel$Deserializer;
                r1.<init>();
                com.facebook.common.json.GlobalAutoGenDeserializerCache.a(r0, r1);
                return;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.MediaMetadataCreationStoryModel.Deserializer.<clinit>():void");
            }

            public java.lang.Object m5051a(com.fasterxml.jackson.core.JsonParser r11, com.fasterxml.jackson.databind.DeserializationContext r12) {
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
                r5 = com.facebook.photos.data.protocol.PhotosMetadataGraphQLParsers.MediaMetadataCreationStoryParser.m5439a(r11, r4);
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
                r1 = new com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels$MediaMetadataCreationStoryModel;
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
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.MediaMetadataCreationStoryModel.Deserializer.a(com.fasterxml.jackson.core.JsonParser, com.fasterxml.jackson.databind.DeserializationContext):java.lang.Object");
            }
        }

        /* compiled from: suggest_edits */
        public class Serializer extends JsonSerializer<MediaMetadataCreationStoryModel> {
            public final void m5052a(java.lang.Object r8, com.fasterxml.jackson.core.JsonGenerator r9, com.fasterxml.jackson.databind.SerializerProvider r10) {
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
                r8 = (com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.MediaMetadataCreationStoryModel) r8;
                r2 = 0;
                r0 = r8.w_();
                if (r0 != 0) goto L_0x0035;
            L_0x0009:
                r0 = new com.facebook.flatbuffers.FlatBufferBuilder;
                r1 = 128; // 0x80 float:1.794E-43 double:6.32E-322;
                r0.<init>(r1);
                r1 = r8.m5069a(r0);
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
                com.facebook.photos.data.protocol.PhotosMetadataGraphQLParsers.MediaMetadataCreationStoryParser.m5440a(r0, r1, r9, r10);
                return;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.MediaMetadataCreationStoryModel.Serializer.a(java.lang.Object, com.fasterxml.jackson.core.JsonGenerator, com.fasterxml.jackson.databind.SerializerProvider):void");
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
                r0 = com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.MediaMetadataCreationStoryModel.class;
                r1 = new com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels$MediaMetadataCreationStoryModel$Serializer;
                r1.<init>();
                com.facebook.common.json.FbSerializerProvider.a(r0, r1);
                return;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.MediaMetadataCreationStoryModel.Serializer.<clinit>():void");
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 1748713222)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: suggest_edits */
        public final class SponsoredDataModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private UserModel f3603d;

            /* compiled from: suggest_edits */
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
                    r0 = com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.MediaMetadataCreationStoryModel.SponsoredDataModel.class;
                    r1 = new com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels$MediaMetadataCreationStoryModel$SponsoredDataModel$Deserializer;
                    r1.<init>();
                    com.facebook.common.json.GlobalAutoGenDeserializerCache.a(r0, r1);
                    return;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.MediaMetadataCreationStoryModel.SponsoredDataModel.Deserializer.<clinit>():void");
                }

                public java.lang.Object m5053a(com.fasterxml.jackson.core.JsonParser r11, com.fasterxml.jackson.databind.DeserializationContext r12) {
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
                    r5 = com.facebook.photos.data.protocol.PhotosMetadataGraphQLParsers.MediaMetadataCreationStoryParser.SponsoredDataParser.m5437a(r11, r4);
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
                    r1 = new com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels$MediaMetadataCreationStoryModel$SponsoredDataModel;
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
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.MediaMetadataCreationStoryModel.SponsoredDataModel.Deserializer.a(com.fasterxml.jackson.core.JsonParser, com.fasterxml.jackson.databind.DeserializationContext):java.lang.Object");
                }
            }

            /* compiled from: suggest_edits */
            public class Serializer extends JsonSerializer<SponsoredDataModel> {
                public final void m5054a(java.lang.Object r8, com.fasterxml.jackson.core.JsonGenerator r9, com.fasterxml.jackson.databind.SerializerProvider r10) {
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
                    r8 = (com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.MediaMetadataCreationStoryModel.SponsoredDataModel) r8;
                    r2 = 0;
                    r0 = r8.w_();
                    if (r0 != 0) goto L_0x0035;
                L_0x0009:
                    r0 = new com.facebook.flatbuffers.FlatBufferBuilder;
                    r1 = 128; // 0x80 float:1.794E-43 double:6.32E-322;
                    r0.<init>(r1);
                    r1 = r8.m5064a(r0);
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
                    com.facebook.photos.data.protocol.PhotosMetadataGraphQLParsers.MediaMetadataCreationStoryParser.SponsoredDataParser.m5438a(r0, r1, r9, r10);
                    return;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.MediaMetadataCreationStoryModel.SponsoredDataModel.Serializer.a(java.lang.Object, com.fasterxml.jackson.core.JsonGenerator, com.fasterxml.jackson.databind.SerializerProvider):void");
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
                    r0 = com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.MediaMetadataCreationStoryModel.SponsoredDataModel.class;
                    r1 = new com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels$MediaMetadataCreationStoryModel$SponsoredDataModel$Serializer;
                    r1.<init>();
                    com.facebook.common.json.FbSerializerProvider.a(r0, r1);
                    return;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.MediaMetadataCreationStoryModel.SponsoredDataModel.Serializer.<clinit>():void");
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = 1801334754)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: suggest_edits */
            public final class UserModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
                @Nullable
                private String f3602d;

                /* compiled from: suggest_edits */
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
                        r0 = com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.MediaMetadataCreationStoryModel.SponsoredDataModel.UserModel.class;
                        r1 = new com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels$MediaMetadataCreationStoryModel$SponsoredDataModel$UserModel$Deserializer;
                        r1.<init>();
                        com.facebook.common.json.GlobalAutoGenDeserializerCache.a(r0, r1);
                        return;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.MediaMetadataCreationStoryModel.SponsoredDataModel.UserModel.Deserializer.<clinit>():void");
                    }

                    public Object m5055a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(UserParser.m5435a(r11, flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                        Object userModel = new UserModel();
                        ((BaseModel) userModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), r11);
                        if (userModel instanceof Postprocessable) {
                            return ((Postprocessable) userModel).a();
                        }
                        return userModel;
                    }
                }

                /* compiled from: suggest_edits */
                public class Serializer extends JsonSerializer<UserModel> {
                    public final void m5056a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        UserModel userModel = (UserModel) r8;
                        if (userModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(userModel.m5057a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            userModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        UserParser.m5436a(userModel.w_(), userModel.u_(), r9);
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
                        r0 = com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.MediaMetadataCreationStoryModel.SponsoredDataModel.UserModel.class;
                        r1 = new com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels$MediaMetadataCreationStoryModel$SponsoredDataModel$UserModel$Serializer;
                        r1.<init>();
                        com.facebook.common.json.FbSerializerProvider.a(r0, r1);
                        return;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.MediaMetadataCreationStoryModel.SponsoredDataModel.UserModel.Serializer.<clinit>():void");
                    }
                }

                public UserModel() {
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
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.MediaMetadataCreationStoryModel.SponsoredDataModel.UserModel.<init>():void");
                }

                public final void m5060a(java.lang.String r1, com.facebook.graphql.visitor.ConsistencyTuple r2) {
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
                    r2.a();
                    return;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.MediaMetadataCreationStoryModel.SponsoredDataModel.UserModel.a(java.lang.String, com.facebook.graphql.visitor.ConsistencyTuple):void");
                }

                public final void m5061a(java.lang.String r1, java.lang.Object r2, boolean r3) {
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
                    return;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.MediaMetadataCreationStoryModel.SponsoredDataModel.UserModel.a(java.lang.String, java.lang.Object, boolean):void");
                }

                @javax.annotation.Nullable
                public final java.lang.String m5062b() {
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
                    r0 = r2.f3602d;
                    r1 = 0;
                    r0 = super.a(r0, r1);
                    r2.f3602d = r0;
                    r0 = r2.f3602d;
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.MediaMetadataCreationStoryModel.SponsoredDataModel.UserModel.b():java.lang.String");
                }

                @javax.annotation.Nullable
                public final java.lang.String m5059a() {
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
                    r0 = r1.m5062b();
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.MediaMetadataCreationStoryModel.SponsoredDataModel.UserModel.a():java.lang.String");
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
                    r0 = 2645995; // 0x285feb float:3.707829E-39 double:1.307295E-317;
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.MediaMetadataCreationStoryModel.SponsoredDataModel.UserModel.jK_():int");
                }

                public final com.facebook.graphql.visitor.GraphQLVisitableModel m5058a(com.facebook.graphql.visitor.GraphQLModelMutatingVisitor r1) {
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
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.MediaMetadataCreationStoryModel.SponsoredDataModel.UserModel.a(com.facebook.graphql.visitor.GraphQLModelMutatingVisitor):com.facebook.graphql.visitor.GraphQLVisitableModel");
                }

                public final int m5057a(com.facebook.flatbuffers.FlatBufferBuilder r3) {
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
                    r0 = r2.m5062b();
                    r0 = r3.b(r0);
                    r1 = 1;
                    r3.c(r1);
                    r1 = 0;
                    r3.b(r1, r0);
                    r2.i();
                    r0 = r3.d();
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.MediaMetadataCreationStoryModel.SponsoredDataModel.UserModel.a(com.facebook.flatbuffers.FlatBufferBuilder):int");
                }
            }

            @javax.annotation.Nullable
            public final /* synthetic */ com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.MediaMetadataCreationStoryModel.SponsoredDataModel.UserModel m5066a() {
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
                r0 = r1.m5063j();
                return r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.MediaMetadataCreationStoryModel.SponsoredDataModel.a():com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels$MediaMetadataCreationStoryModel$SponsoredDataModel$UserModel");
            }

            public SponsoredDataModel() {
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
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.MediaMetadataCreationStoryModel.SponsoredDataModel.<init>():void");
            }

            @javax.annotation.Nullable
            private com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.MediaMetadataCreationStoryModel.SponsoredDataModel.UserModel m5063j() {
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
                r0 = r3.f3603d;
                r1 = 0;
                r2 = com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.MediaMetadataCreationStoryModel.SponsoredDataModel.UserModel.class;
                r0 = super.a(r0, r1, r2);
                r0 = (com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.MediaMetadataCreationStoryModel.SponsoredDataModel.UserModel) r0;
                r3.f3603d = r0;
                r0 = r3.f3603d;
                return r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.MediaMetadataCreationStoryModel.SponsoredDataModel.j():com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels$MediaMetadataCreationStoryModel$SponsoredDataModel$UserModel");
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
                r0 = 516771939; // 0x1ecd5063 float:2.1738466E-20 double:2.55319262E-315;
                return r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.MediaMetadataCreationStoryModel.SponsoredDataModel.jK_():int");
            }

            public final com.facebook.graphql.visitor.GraphQLVisitableModel m5065a(com.facebook.graphql.visitor.GraphQLModelMutatingVisitor r4) {
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
                r0 = r3.m5063j();
                if (r0 == 0) goto L_0x0022;
            L_0x000a:
                r0 = r3.m5063j();
                r0 = r4.b(r0);
                r0 = (com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.MediaMetadataCreationStoryModel.SponsoredDataModel.UserModel) r0;
                r2 = r3.m5063j();
                if (r2 == r0) goto L_0x0022;
            L_0x001a:
                r1 = com.facebook.graphql.modelutil.ModelHelper.a(r1, r3);
                r1 = (com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.MediaMetadataCreationStoryModel.SponsoredDataModel) r1;
                r1.f3603d = r0;
            L_0x0022:
                r3.i();
                if (r1 != 0) goto L_0x0028;
            L_0x0027:
                return r3;
            L_0x0028:
                r3 = r1;
                goto L_0x0027;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.MediaMetadataCreationStoryModel.SponsoredDataModel.a(com.facebook.graphql.visitor.GraphQLModelMutatingVisitor):com.facebook.graphql.visitor.GraphQLVisitableModel");
            }

            public final int m5064a(com.facebook.flatbuffers.FlatBufferBuilder r3) {
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
                r0 = r2.m5063j();
                r0 = com.facebook.graphql.modelutil.ModelHelper.a(r3, r0);
                r1 = 1;
                r3.c(r1);
                r1 = 0;
                r3.b(r1, r0);
                r2.i();
                r0 = r3.d();
                return r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.MediaMetadataCreationStoryModel.SponsoredDataModel.a(com.facebook.flatbuffers.FlatBufferBuilder):int");
            }
        }

        @javax.annotation.Nullable
        public final /* synthetic */ com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.MediaMetadataCreationStoryModel.ApplicationModel m5074b() {
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
            r0 = r1.m5067j();
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.MediaMetadataCreationStoryModel.b():com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels$MediaMetadataCreationStoryModel$ApplicationModel");
        }

        @javax.annotation.Nullable
        public final /* synthetic */ com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.MediaMetadataCreationStoryModel.SponsoredDataModel bk_() {
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
            r0 = r1.m5068k();
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.MediaMetadataCreationStoryModel.bk_():com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels$MediaMetadataCreationStoryModel$SponsoredDataModel");
        }

        public MediaMetadataCreationStoryModel() {
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
            r0 = 7;
            r1.<init>(r0);
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.MediaMetadataCreationStoryModel.<init>():void");
        }

        public final void m5072a(java.lang.String r1, com.facebook.graphql.visitor.ConsistencyTuple r2) {
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
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.MediaMetadataCreationStoryModel.a(java.lang.String, com.facebook.graphql.visitor.ConsistencyTuple):void");
        }

        public final void m5073a(java.lang.String r1, java.lang.Object r2, boolean r3) {
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
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.MediaMetadataCreationStoryModel.a(java.lang.String, java.lang.Object, boolean):void");
        }

        @javax.annotation.Nullable
        private com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.MediaMetadataCreationStoryModel.ApplicationModel m5067j() {
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
            r0 = r3.f3604d;
            r1 = 0;
            r2 = com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.MediaMetadataCreationStoryModel.ApplicationModel.class;
            r0 = super.a(r0, r1, r2);
            r0 = (com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.MediaMetadataCreationStoryModel.ApplicationModel) r0;
            r3.f3604d = r0;
            r0 = r3.f3604d;
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.MediaMetadataCreationStoryModel.j():com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels$MediaMetadataCreationStoryModel$ApplicationModel");
        }

        @javax.annotation.Nonnull
        public final com.google.common.collect.ImmutableList<com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.MediaMetadataCreationStoryModel.AttachmentsModel> m5075c() {
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
            r0 = r3.f3605e;
            r1 = 1;
            r2 = com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.MediaMetadataCreationStoryModel.AttachmentsModel.class;
            r0 = super.a(r0, r1, r2);
            r3.f3605e = r0;
            r0 = r3.f3605e;
            r0 = (com.google.common.collect.ImmutableList) r0;
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.MediaMetadataCreationStoryModel.c():com.google.common.collect.ImmutableList<com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels$MediaMetadataCreationStoryModel$AttachmentsModel>");
        }

        @javax.annotation.Nullable
        public final java.lang.String m5076d() {
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
            r0 = r2.f3606f;
            r1 = 2;
            r0 = super.a(r0, r1);
            r2.f3606f = r0;
            r0 = r2.f3606f;
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.MediaMetadataCreationStoryModel.d():java.lang.String");
        }

        @javax.annotation.Nullable
        public final java.lang.String bi_() {
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
            r0 = r2.f3607g;
            r1 = 3;
            r0 = super.a(r0, r1);
            r2.f3607g = r0;
            r0 = r2.f3607g;
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.MediaMetadataCreationStoryModel.bi_():java.lang.String");
        }

        @javax.annotation.Nullable
        public final java.lang.String m5077g() {
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
            r0 = r2.f3608h;
            r1 = 4;
            r0 = super.a(r0, r1);
            r2.f3608h = r0;
            r0 = r2.f3608h;
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.MediaMetadataCreationStoryModel.g():java.lang.String");
        }

        @javax.annotation.Nullable
        private com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.MediaMetadataCreationStoryModel.SponsoredDataModel m5068k() {
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
            r0 = r3.f3609i;
            r1 = 5;
            r2 = com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.MediaMetadataCreationStoryModel.SponsoredDataModel.class;
            r0 = super.a(r0, r1, r2);
            r0 = (com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.MediaMetadataCreationStoryModel.SponsoredDataModel) r0;
            r3.f3609i = r0;
            r0 = r3.f3609i;
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.MediaMetadataCreationStoryModel.k():com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels$MediaMetadataCreationStoryModel$SponsoredDataModel");
        }

        @javax.annotation.Nullable
        public final java.lang.String bj_() {
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
            r0 = r2.f3610j;
            r1 = 6;
            r0 = super.a(r0, r1);
            r2.f3610j = r0;
            r0 = r2.f3610j;
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.MediaMetadataCreationStoryModel.bj_():java.lang.String");
        }

        @javax.annotation.Nullable
        public final java.lang.String m5071a() {
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
            r0 = r1.bi_();
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.MediaMetadataCreationStoryModel.a():java.lang.String");
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
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.MediaMetadataCreationStoryModel.jK_():int");
        }

        public final com.facebook.graphql.visitor.GraphQLVisitableModel m5070a(com.facebook.graphql.visitor.GraphQLModelMutatingVisitor r4) {
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
            r0 = r3.m5067j();
            if (r0 == 0) goto L_0x0022;
        L_0x000a:
            r0 = r3.m5067j();
            r0 = r4.b(r0);
            r0 = (com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.MediaMetadataCreationStoryModel.ApplicationModel) r0;
            r2 = r3.m5067j();
            if (r2 == r0) goto L_0x0022;
        L_0x001a:
            r1 = com.facebook.graphql.modelutil.ModelHelper.a(r1, r3);
            r1 = (com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.MediaMetadataCreationStoryModel) r1;
            r1.f3604d = r0;
        L_0x0022:
            r0 = r3.m5075c();
            if (r0 == 0) goto L_0x003f;
        L_0x0028:
            r0 = r3.m5075c();
            r2 = com.facebook.graphql.modelutil.ModelHelper.a(r0, r4);
            if (r2 == 0) goto L_0x003f;
        L_0x0032:
            r0 = com.facebook.graphql.modelutil.ModelHelper.a(r1, r3);
            r0 = (com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.MediaMetadataCreationStoryModel) r0;
            r1 = r2.b();
            r0.f3605e = r1;
            r1 = r0;
        L_0x003f:
            r0 = r3.m5068k();
            if (r0 == 0) goto L_0x005d;
        L_0x0045:
            r0 = r3.m5068k();
            r0 = r4.b(r0);
            r0 = (com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.MediaMetadataCreationStoryModel.SponsoredDataModel) r0;
            r2 = r3.m5068k();
            if (r2 == r0) goto L_0x005d;
        L_0x0055:
            r1 = com.facebook.graphql.modelutil.ModelHelper.a(r1, r3);
            r1 = (com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.MediaMetadataCreationStoryModel) r1;
            r1.f3609i = r0;
        L_0x005d:
            r3.i();
            if (r1 != 0) goto L_0x0063;
        L_0x0062:
            return r3;
        L_0x0063:
            r3 = r1;
            goto L_0x0062;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.MediaMetadataCreationStoryModel.a(com.facebook.graphql.visitor.GraphQLModelMutatingVisitor):com.facebook.graphql.visitor.GraphQLVisitableModel");
        }

        public final int m5069a(com.facebook.flatbuffers.FlatBufferBuilder r9) {
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
            r8 = this;
            r8.h();
            r0 = r8.m5067j();
            r0 = com.facebook.graphql.modelutil.ModelHelper.a(r9, r0);
            r1 = r8.m5075c();
            r1 = com.facebook.graphql.modelutil.ModelHelper.a(r9, r1);
            r2 = r8.m5076d();
            r2 = r9.b(r2);
            r3 = r8.bi_();
            r3 = r9.b(r3);
            r4 = r8.m5077g();
            r4 = r9.b(r4);
            r5 = r8.m5068k();
            r5 = com.facebook.graphql.modelutil.ModelHelper.a(r9, r5);
            r6 = r8.bj_();
            r6 = r9.b(r6);
            r7 = 7;
            r9.c(r7);
            r7 = 0;
            r9.b(r7, r0);
            r0 = 1;
            r9.b(r0, r1);
            r0 = 2;
            r9.b(r0, r2);
            r0 = 3;
            r9.b(r0, r3);
            r0 = 4;
            r9.b(r0, r4);
            r0 = 5;
            r9.b(r0, r5);
            r0 = 6;
            r9.b(r0, r6);
            r8.i();
            r0 = r9.d();
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.MediaMetadataCreationStoryModel.a(com.facebook.flatbuffers.FlatBufferBuilder):int");
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 237035154)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: suggest_edits */
    public final class MediaMetadataInlineActivitiesModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private List<InlineActivityInfoModel> f3611d;

        /* compiled from: suggest_edits */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(MediaMetadataInlineActivitiesModel.class, new Deserializer());
            }

            public Object m5078a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(MediaMetadataInlineActivitiesParser.m5441a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object mediaMetadataInlineActivitiesModel = new MediaMetadataInlineActivitiesModel();
                ((BaseModel) mediaMetadataInlineActivitiesModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (mediaMetadataInlineActivitiesModel instanceof Postprocessable) {
                    return ((Postprocessable) mediaMetadataInlineActivitiesModel).a();
                }
                return mediaMetadataInlineActivitiesModel;
            }
        }

        /* compiled from: suggest_edits */
        public class Serializer extends JsonSerializer<MediaMetadataInlineActivitiesModel> {
            public final void m5079a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MediaMetadataInlineActivitiesModel mediaMetadataInlineActivitiesModel = (MediaMetadataInlineActivitiesModel) obj;
                if (mediaMetadataInlineActivitiesModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(mediaMetadataInlineActivitiesModel.m5080a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mediaMetadataInlineActivitiesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                MediaMetadataInlineActivitiesParser.m5442a(mediaMetadataInlineActivitiesModel.w_(), mediaMetadataInlineActivitiesModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(MediaMetadataInlineActivitiesModel.class, new Serializer());
            }
        }

        public MediaMetadataInlineActivitiesModel() {
            super(1);
        }

        @Nonnull
        public final ImmutableList<InlineActivityInfoModel> m5082a() {
            this.f3611d = super.a(this.f3611d, 0, InlineActivityInfoModel.class);
            return (ImmutableList) this.f3611d;
        }

        public final int jK_() {
            return -1909752060;
        }

        public final GraphQLVisitableModel m5081a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m5082a() != null) {
                Builder a = ModelHelper.a(m5082a(), graphQLModelMutatingVisitor);
                if (a != null) {
                    graphQLVisitableModel = (MediaMetadataInlineActivitiesModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f3611d = a.b();
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m5080a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m5082a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -30093476)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: suggest_edits */
    public final class MediaMetadataModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel, MediaMetadata {
        @Nullable
        private String f3658A;
        @Nullable
        private String f3659B;
        @Nullable
        private DefaultImageFieldsModel f3660C;
        @Nullable
        private DefaultImageFieldsModel f3661D;
        @Nullable
        private DefaultImageFieldsModel f3662E;
        @Nullable
        private DefaultImageFieldsModel f3663F;
        @Nullable
        private DefaultImageFieldsModel f3664G;
        @Nullable
        private DefaultImageFieldsModel f3665H;
        @Nullable
        private MediaMetadataInlineActivitiesModel f3666I;
        private boolean f3667J;
        private boolean f3668K;
        @Nullable
        private DefaultImageFieldsModel f3669L;
        @Nullable
        private LocationTagSuggestionModel f3670M;
        @Nullable
        private DefaultTextWithEntitiesLongFieldsModel f3671N;
        @Nullable
        private MediaMetadataOwnerModel f3672O;
        @Nullable
        private PendingPlaceModel f3673P;
        private int f3674Q;
        @Nullable
        private String f3675R;
        @Nullable
        private PrivacyScopeModel f3676S;
        @Nullable
        private ImageOverlayFieldsModel f3677T;
        private boolean f3678U;
        @Nullable
        private TagInfoQueryModel f3679V;
        @Nullable
        private WithTagsModel f3680W;
        @Nullable
        private GraphQLObjectType f3681d;
        @Nullable
        private String f3682e;
        @Nullable
        private AlbumModel f3683f;
        @Nullable
        private MediaMetadataAttributionAppModel f3684g;
        @Nullable
        private String f3685h;
        private boolean f3686i;
        private boolean f3687j;
        private boolean f3688k;
        private boolean f3689l;
        private boolean f3690m;
        private boolean f3691n;
        private boolean f3692o;
        private boolean f3693p;
        private boolean f3694q;
        private boolean f3695r;
        @Nullable
        private MediaPrivacyContainerStoryModel f3696s;
        private long f3697t;
        @Nullable
        private MediaMetadataCreationStoryModel f3698u;
        @Nullable
        private ExplicitPlaceModel f3699v;
        @Nullable
        private PhotosFaceBoxesQueryModel f3700w;
        @Nullable
        private SimpleMediaFeedbackModel f3701x;
        @Nullable
        private DefaultVect2FieldsModel f3702y;
        private boolean f3703z;

        /* compiled from: suggest_edits */
        public final class Builder {
            @Nullable
            public DefaultImageFieldsModel f3612A;
            @Nullable
            public DefaultImageFieldsModel f3613B;
            @Nullable
            public DefaultImageFieldsModel f3614C;
            @Nullable
            public DefaultImageFieldsModel f3615D;
            @Nullable
            public DefaultImageFieldsModel f3616E;
            @Nullable
            public MediaMetadataInlineActivitiesModel f3617F;
            public boolean f3618G;
            public boolean f3619H;
            @Nullable
            public DefaultImageFieldsModel f3620I;
            @Nullable
            public LocationTagSuggestionModel f3621J;
            @Nullable
            public DefaultTextWithEntitiesLongFieldsModel f3622K;
            @Nullable
            public MediaMetadataOwnerModel f3623L;
            @Nullable
            public PendingPlaceModel f3624M;
            public int f3625N;
            @Nullable
            public String f3626O;
            @Nullable
            public PrivacyScopeModel f3627P;
            @Nullable
            public ImageOverlayFieldsModel f3628Q;
            public boolean f3629R;
            @Nullable
            public TagInfoQueryModel f3630S;
            @Nullable
            public WithTagsModel f3631T;
            @Nullable
            public GraphQLObjectType f3632a;
            @Nullable
            public String f3633b;
            @Nullable
            public AlbumModel f3634c;
            @Nullable
            public MediaMetadataAttributionAppModel f3635d;
            @Nullable
            public String f3636e;
            public boolean f3637f;
            public boolean f3638g;
            public boolean f3639h;
            public boolean f3640i;
            public boolean f3641j;
            public boolean f3642k;
            public boolean f3643l;
            public boolean f3644m;
            public boolean f3645n;
            public boolean f3646o;
            @Nullable
            public MediaPrivacyContainerStoryModel f3647p;
            public long f3648q;
            @Nullable
            public MediaMetadataCreationStoryModel f3649r;
            @Nullable
            public ExplicitPlaceModel f3650s;
            @Nullable
            public PhotosFaceBoxesQueryModel f3651t;
            @Nullable
            public SimpleMediaFeedbackModel f3652u;
            @Nullable
            public DefaultVect2FieldsModel f3653v;
            public boolean f3654w;
            @Nullable
            public String f3655x;
            @Nullable
            public String f3656y;
            @Nullable
            public DefaultImageFieldsModel f3657z;

            public static Builder m5083a(MediaMetadataModel mediaMetadataModel) {
                Builder builder = new Builder();
                builder.f3632a = mediaMetadataModel.mo255b();
                builder.f3633b = mediaMetadataModel.mo262j();
                builder.f3634c = mediaMetadataModel.m5109W();
                builder.f3635d = mediaMetadataModel.m5110X();
                builder.f3636e = mediaMetadataModel.mo265m();
                builder.f3637f = mediaMetadataModel.mo266n();
                builder.f3638g = mediaMetadataModel.mo267o();
                builder.f3639h = mediaMetadataModel.mo268p();
                builder.f3640i = mediaMetadataModel.mo269q();
                builder.f3641j = mediaMetadataModel.mo270r();
                builder.f3642k = mediaMetadataModel.mo271s();
                builder.f3643l = mediaMetadataModel.mo272t();
                builder.f3644m = mediaMetadataModel.mo273u();
                builder.f3645n = mediaMetadataModel.mo274v();
                builder.f3646o = mediaMetadataModel.mo275w();
                builder.f3647p = mediaMetadataModel.m5111Y();
                builder.f3648q = mediaMetadataModel.mo277y();
                builder.f3649r = mediaMetadataModel.m5112Z();
                builder.f3650s = mediaMetadataModel.aa();
                builder.f3651t = mediaMetadataModel.ab();
                builder.f3652u = mediaMetadataModel.ac();
                builder.f3653v = mediaMetadataModel.ad();
                builder.f3654w = mediaMetadataModel.mo236D();
                builder.f3655x = mediaMetadataModel.mo237E();
                builder.f3656y = mediaMetadataModel.mo260d();
                builder.f3657z = mediaMetadataModel.ae();
                builder.f3612A = mediaMetadataModel.af();
                builder.f3613B = mediaMetadataModel.ag();
                builder.f3614C = mediaMetadataModel.ah();
                builder.f3615D = mediaMetadataModel.ai();
                builder.f3616E = mediaMetadataModel.aj();
                builder.f3617F = mediaMetadataModel.ak();
                builder.f3618G = mediaMetadataModel.mo241I();
                builder.f3619H = mediaMetadataModel.mo242J();
                builder.f3620I = mediaMetadataModel.al();
                builder.f3621J = mediaMetadataModel.am();
                builder.f3622K = mediaMetadataModel.an();
                builder.f3623L = mediaMetadataModel.ao();
                builder.f3624M = mediaMetadataModel.ap();
                builder.f3625N = mediaMetadataModel.mo248P();
                builder.f3626O = mediaMetadataModel.mo249Q();
                builder.f3627P = mediaMetadataModel.aq();
                builder.f3628Q = mediaMetadataModel.ar();
                builder.f3629R = mediaMetadataModel.mo252T();
                builder.f3630S = mediaMetadataModel.as();
                builder.f3631T = mediaMetadataModel.at();
                return builder;
            }

            public final MediaMetadataModel m5084a() {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                int a = ModelHelper.a(flatBufferBuilder, this.f3632a);
                int b = flatBufferBuilder.b(this.f3633b);
                int a2 = ModelHelper.a(flatBufferBuilder, this.f3634c);
                int a3 = ModelHelper.a(flatBufferBuilder, this.f3635d);
                int b2 = flatBufferBuilder.b(this.f3636e);
                int a4 = ModelHelper.a(flatBufferBuilder, this.f3647p);
                int a5 = ModelHelper.a(flatBufferBuilder, this.f3649r);
                int a6 = ModelHelper.a(flatBufferBuilder, this.f3650s);
                int a7 = ModelHelper.a(flatBufferBuilder, this.f3651t);
                int a8 = ModelHelper.a(flatBufferBuilder, this.f3652u);
                int a9 = ModelHelper.a(flatBufferBuilder, this.f3653v);
                int b3 = flatBufferBuilder.b(this.f3655x);
                int b4 = flatBufferBuilder.b(this.f3656y);
                int a10 = ModelHelper.a(flatBufferBuilder, this.f3657z);
                int a11 = ModelHelper.a(flatBufferBuilder, this.f3612A);
                int a12 = ModelHelper.a(flatBufferBuilder, this.f3613B);
                int a13 = ModelHelper.a(flatBufferBuilder, this.f3614C);
                int a14 = ModelHelper.a(flatBufferBuilder, this.f3615D);
                int a15 = ModelHelper.a(flatBufferBuilder, this.f3616E);
                int a16 = ModelHelper.a(flatBufferBuilder, this.f3617F);
                int a17 = ModelHelper.a(flatBufferBuilder, this.f3620I);
                int a18 = ModelHelper.a(flatBufferBuilder, this.f3621J);
                int a19 = ModelHelper.a(flatBufferBuilder, this.f3622K);
                int a20 = ModelHelper.a(flatBufferBuilder, this.f3623L);
                int a21 = ModelHelper.a(flatBufferBuilder, this.f3624M);
                int b5 = flatBufferBuilder.b(this.f3626O);
                int a22 = ModelHelper.a(flatBufferBuilder, this.f3627P);
                int a23 = ModelHelper.a(flatBufferBuilder, this.f3628Q);
                int a24 = ModelHelper.a(flatBufferBuilder, this.f3630S);
                int a25 = ModelHelper.a(flatBufferBuilder, this.f3631T);
                flatBufferBuilder.c(46);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.b(1, b);
                flatBufferBuilder.b(2, a2);
                flatBufferBuilder.b(3, a3);
                flatBufferBuilder.b(4, b2);
                flatBufferBuilder.a(5, this.f3637f);
                flatBufferBuilder.a(6, this.f3638g);
                flatBufferBuilder.a(7, this.f3639h);
                flatBufferBuilder.a(8, this.f3640i);
                flatBufferBuilder.a(9, this.f3641j);
                flatBufferBuilder.a(10, this.f3642k);
                flatBufferBuilder.a(11, this.f3643l);
                flatBufferBuilder.a(12, this.f3644m);
                flatBufferBuilder.a(13, this.f3645n);
                flatBufferBuilder.a(14, this.f3646o);
                flatBufferBuilder.b(15, a4);
                flatBufferBuilder.a(16, this.f3648q, 0);
                flatBufferBuilder.b(17, a5);
                flatBufferBuilder.b(18, a6);
                flatBufferBuilder.b(19, a7);
                flatBufferBuilder.b(20, a8);
                flatBufferBuilder.b(21, a9);
                flatBufferBuilder.a(22, this.f3654w);
                flatBufferBuilder.b(23, b3);
                flatBufferBuilder.b(24, b4);
                flatBufferBuilder.b(25, a10);
                flatBufferBuilder.b(26, a11);
                flatBufferBuilder.b(27, a12);
                flatBufferBuilder.b(28, a13);
                flatBufferBuilder.b(29, a14);
                flatBufferBuilder.b(30, a15);
                flatBufferBuilder.b(31, a16);
                flatBufferBuilder.a(32, this.f3618G);
                flatBufferBuilder.a(33, this.f3619H);
                flatBufferBuilder.b(34, a17);
                flatBufferBuilder.b(35, a18);
                flatBufferBuilder.b(36, a19);
                flatBufferBuilder.b(37, a20);
                flatBufferBuilder.b(38, a21);
                flatBufferBuilder.a(39, this.f3625N, 0);
                flatBufferBuilder.b(40, b5);
                flatBufferBuilder.b(41, a22);
                flatBufferBuilder.b(42, a23);
                flatBufferBuilder.a(43, this.f3629R);
                flatBufferBuilder.b(44, a24);
                flatBufferBuilder.b(45, a25);
                flatBufferBuilder.d(flatBufferBuilder.d());
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                return new MediaMetadataModel(new MutableFlatBuffer(wrap, null, null, true, null));
            }
        }

        /* compiled from: suggest_edits */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(MediaMetadataModel.class, new Deserializer());
            }

            public Object m5085a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(MediaMetadataParser.m5445a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object mediaMetadataModel = new MediaMetadataModel();
                ((BaseModel) mediaMetadataModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (mediaMetadataModel instanceof Postprocessable) {
                    return ((Postprocessable) mediaMetadataModel).a();
                }
                return mediaMetadataModel;
            }
        }

        /* compiled from: suggest_edits */
        public class Serializer extends JsonSerializer<MediaMetadataModel> {
            public final void m5086a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MediaMetadataModel mediaMetadataModel = (MediaMetadataModel) obj;
                if (mediaMetadataModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(mediaMetadataModel.m5113a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mediaMetadataModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                MediaMetadataParser.m5448b(mediaMetadataModel.w_(), mediaMetadataModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(MediaMetadataModel.class, new Serializer());
            }
        }

        @Nullable
        public final /* synthetic */ ExplicitPlaceModel mo233A() {
            return aa();
        }

        @Nullable
        public final /* synthetic */ PhotosFaceBoxesQueryModel mo234B() {
            return ab();
        }

        @Nullable
        public final /* synthetic */ SimpleMediaFeedbackModel mo235C() {
            return ac();
        }

        @Nullable
        public final /* synthetic */ DefaultImageFields mo238F() {
            return ag();
        }

        @Nullable
        public final /* synthetic */ DefaultImageFields mo239G() {
            return aj();
        }

        @Nullable
        public final /* synthetic */ MediaMetadataInlineActivitiesModel mo240H() {
            return ak();
        }

        @Nullable
        public final /* synthetic */ DefaultImageFields mo243K() {
            return al();
        }

        @Nullable
        public final /* synthetic */ LocationTagSuggestionModel mo244L() {
            return am();
        }

        @Nullable
        public final /* synthetic */ DefaultTextWithEntitiesLongFields mo245M() {
            return an();
        }

        @Nullable
        public final /* synthetic */ MediaMetadataOwnerModel mo246N() {
            return ao();
        }

        @Nullable
        public final /* synthetic */ PendingPlaceModel mo247O() {
            return ap();
        }

        @Nullable
        public final /* synthetic */ PrivacyScopeModel mo250R() {
            return aq();
        }

        @Nullable
        public final /* synthetic */ ImageOverlayFieldsModel mo251S() {
            return ar();
        }

        @Nullable
        public final /* synthetic */ TagInfoQueryModel mo253U() {
            return as();
        }

        @Nullable
        public final /* synthetic */ WithTagsModel mo254V() {
            return at();
        }

        @Nullable
        public final /* synthetic */ DefaultImageFields bc_() {
            return ai();
        }

        @Nullable
        public final /* synthetic */ DefaultImageFields bd_() {
            return ah();
        }

        @Nullable
        public final /* synthetic */ DefaultImageFields be_() {
            return ae();
        }

        @Nullable
        public final /* synthetic */ DefaultVect2Fields mo259c() {
            return ad();
        }

        @Nullable
        public final /* synthetic */ DefaultImageFields mo261g() {
            return af();
        }

        @Nullable
        public final /* synthetic */ AlbumModel mo263k() {
            return m5109W();
        }

        @Nullable
        public final /* synthetic */ MediaMetadataAttributionAppModel mo264l() {
            return m5110X();
        }

        @Nullable
        public final /* synthetic */ MediaPrivacyContainerStoryModel mo276x() {
            return m5111Y();
        }

        @Nullable
        public final /* synthetic */ MediaMetadataCreationStoryModel mo278z() {
            return m5112Z();
        }

        public MediaMetadataModel() {
            super(46);
        }

        public MediaMetadataModel(MutableFlatBuffer mutableFlatBuffer) {
            super(46);
            a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
        }

        @Nullable
        public final GraphQLObjectType mo255b() {
            if (this.b != null && this.f3681d == null) {
                this.f3681d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
            }
            return this.f3681d;
        }

        @Nullable
        public final String mo262j() {
            this.f3682e = super.a(this.f3682e, 1);
            return this.f3682e;
        }

        @Nullable
        public final AlbumModel m5109W() {
            this.f3683f = (AlbumModel) super.a(this.f3683f, 2, AlbumModel.class);
            return this.f3683f;
        }

        @Nullable
        public final MediaMetadataAttributionAppModel m5110X() {
            this.f3684g = (MediaMetadataAttributionAppModel) super.a(this.f3684g, 3, MediaMetadataAttributionAppModel.class);
            return this.f3684g;
        }

        @Nullable
        public final String mo265m() {
            this.f3685h = super.a(this.f3685h, 4);
            return this.f3685h;
        }

        public final boolean mo266n() {
            a(0, 5);
            return this.f3686i;
        }

        public final boolean mo267o() {
            a(0, 6);
            return this.f3687j;
        }

        public final boolean mo268p() {
            a(0, 7);
            return this.f3688k;
        }

        public final boolean mo269q() {
            a(1, 0);
            return this.f3689l;
        }

        public final boolean mo270r() {
            a(1, 1);
            return this.f3690m;
        }

        public final boolean mo271s() {
            a(1, 2);
            return this.f3691n;
        }

        public final boolean mo272t() {
            a(1, 3);
            return this.f3692o;
        }

        public final boolean mo273u() {
            a(1, 4);
            return this.f3693p;
        }

        public final boolean mo274v() {
            a(1, 5);
            return this.f3694q;
        }

        public final boolean mo275w() {
            a(1, 6);
            return this.f3695r;
        }

        @Nullable
        public final MediaPrivacyContainerStoryModel m5111Y() {
            this.f3696s = (MediaPrivacyContainerStoryModel) super.a(this.f3696s, 15, MediaPrivacyContainerStoryModel.class);
            return this.f3696s;
        }

        public final long mo277y() {
            a(2, 0);
            return this.f3697t;
        }

        @Nullable
        public final MediaMetadataCreationStoryModel m5112Z() {
            this.f3698u = (MediaMetadataCreationStoryModel) super.a(this.f3698u, 17, MediaMetadataCreationStoryModel.class);
            return this.f3698u;
        }

        @Nullable
        public final ExplicitPlaceModel aa() {
            this.f3699v = (ExplicitPlaceModel) super.a(this.f3699v, 18, ExplicitPlaceModel.class);
            return this.f3699v;
        }

        @Nullable
        public final PhotosFaceBoxesQueryModel ab() {
            this.f3700w = (PhotosFaceBoxesQueryModel) super.a(this.f3700w, 19, PhotosFaceBoxesQueryModel.class);
            return this.f3700w;
        }

        @Nullable
        public final SimpleMediaFeedbackModel ac() {
            this.f3701x = (SimpleMediaFeedbackModel) super.a(this.f3701x, 20, SimpleMediaFeedbackModel.class);
            return this.f3701x;
        }

        @Nullable
        public final DefaultVect2FieldsModel ad() {
            this.f3702y = (DefaultVect2FieldsModel) super.a(this.f3702y, 21, DefaultVect2FieldsModel.class);
            return this.f3702y;
        }

        public final boolean mo236D() {
            a(2, 6);
            return this.f3703z;
        }

        @Nullable
        public final String mo237E() {
            this.f3658A = super.a(this.f3658A, 23);
            return this.f3658A;
        }

        @Nullable
        public final String mo260d() {
            this.f3659B = super.a(this.f3659B, 24);
            return this.f3659B;
        }

        @Nullable
        public final DefaultImageFieldsModel ae() {
            this.f3660C = (DefaultImageFieldsModel) super.a(this.f3660C, 25, DefaultImageFieldsModel.class);
            return this.f3660C;
        }

        @Nullable
        public final DefaultImageFieldsModel af() {
            this.f3661D = (DefaultImageFieldsModel) super.a(this.f3661D, 26, DefaultImageFieldsModel.class);
            return this.f3661D;
        }

        @Nullable
        public final DefaultImageFieldsModel ag() {
            this.f3662E = (DefaultImageFieldsModel) super.a(this.f3662E, 27, DefaultImageFieldsModel.class);
            return this.f3662E;
        }

        @Nullable
        public final DefaultImageFieldsModel ah() {
            this.f3663F = (DefaultImageFieldsModel) super.a(this.f3663F, 28, DefaultImageFieldsModel.class);
            return this.f3663F;
        }

        @Nullable
        public final DefaultImageFieldsModel ai() {
            this.f3664G = (DefaultImageFieldsModel) super.a(this.f3664G, 29, DefaultImageFieldsModel.class);
            return this.f3664G;
        }

        @Nullable
        public final DefaultImageFieldsModel aj() {
            this.f3665H = (DefaultImageFieldsModel) super.a(this.f3665H, 30, DefaultImageFieldsModel.class);
            return this.f3665H;
        }

        @Nullable
        public final MediaMetadataInlineActivitiesModel ak() {
            this.f3666I = (MediaMetadataInlineActivitiesModel) super.a(this.f3666I, 31, MediaMetadataInlineActivitiesModel.class);
            return this.f3666I;
        }

        public final boolean mo241I() {
            a(4, 0);
            return this.f3667J;
        }

        public final boolean mo242J() {
            a(4, 1);
            return this.f3668K;
        }

        @Nullable
        public final DefaultImageFieldsModel al() {
            this.f3669L = (DefaultImageFieldsModel) super.a(this.f3669L, 34, DefaultImageFieldsModel.class);
            return this.f3669L;
        }

        @Nullable
        public final LocationTagSuggestionModel am() {
            this.f3670M = (LocationTagSuggestionModel) super.a(this.f3670M, 35, LocationTagSuggestionModel.class);
            return this.f3670M;
        }

        @Nullable
        public final DefaultTextWithEntitiesLongFieldsModel an() {
            this.f3671N = (DefaultTextWithEntitiesLongFieldsModel) super.a(this.f3671N, 36, DefaultTextWithEntitiesLongFieldsModel.class);
            return this.f3671N;
        }

        @Nullable
        public final MediaMetadataOwnerModel ao() {
            this.f3672O = (MediaMetadataOwnerModel) super.a(this.f3672O, 37, MediaMetadataOwnerModel.class);
            return this.f3672O;
        }

        @Nullable
        public final PendingPlaceModel ap() {
            this.f3673P = (PendingPlaceModel) super.a(this.f3673P, 38, PendingPlaceModel.class);
            return this.f3673P;
        }

        public final int mo248P() {
            a(4, 7);
            return this.f3674Q;
        }

        @Nullable
        public final String mo249Q() {
            this.f3675R = super.a(this.f3675R, 40);
            return this.f3675R;
        }

        @Nullable
        public final PrivacyScopeModel aq() {
            this.f3676S = (PrivacyScopeModel) super.a(this.f3676S, 41, PrivacyScopeModel.class);
            return this.f3676S;
        }

        @Nullable
        public final ImageOverlayFieldsModel ar() {
            this.f3677T = (ImageOverlayFieldsModel) super.a(this.f3677T, 42, ImageOverlayFieldsModel.class);
            return this.f3677T;
        }

        public final boolean mo252T() {
            a(5, 3);
            return this.f3678U;
        }

        @Nullable
        public final TagInfoQueryModel as() {
            this.f3679V = (TagInfoQueryModel) super.a(this.f3679V, 44, TagInfoQueryModel.class);
            return this.f3679V;
        }

        @Nullable
        public final WithTagsModel at() {
            this.f3680W = (WithTagsModel) super.a(this.f3680W, 45, WithTagsModel.class);
            return this.f3680W;
        }

        @Nullable
        public final String m5115a() {
            return mo260d();
        }

        public final int jK_() {
            return 74219460;
        }

        public final GraphQLVisitableModel m5114a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            DefaultImageFieldsModel defaultImageFieldsModel;
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m5109W() != null) {
                AlbumModel albumModel = (AlbumModel) graphQLModelMutatingVisitor.b(m5109W());
                if (m5109W() != albumModel) {
                    graphQLVisitableModel = (MediaMetadataModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f3683f = albumModel;
                }
            }
            if (m5110X() != null) {
                MediaMetadataAttributionAppModel mediaMetadataAttributionAppModel = (MediaMetadataAttributionAppModel) graphQLModelMutatingVisitor.b(m5110X());
                if (m5110X() != mediaMetadataAttributionAppModel) {
                    graphQLVisitableModel = (MediaMetadataModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f3684g = mediaMetadataAttributionAppModel;
                }
            }
            if (m5111Y() != null) {
                MediaPrivacyContainerStoryModel mediaPrivacyContainerStoryModel = (MediaPrivacyContainerStoryModel) graphQLModelMutatingVisitor.b(m5111Y());
                if (m5111Y() != mediaPrivacyContainerStoryModel) {
                    graphQLVisitableModel = (MediaMetadataModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f3696s = mediaPrivacyContainerStoryModel;
                }
            }
            if (m5112Z() != null) {
                MediaMetadataCreationStoryModel mediaMetadataCreationStoryModel = (MediaMetadataCreationStoryModel) graphQLModelMutatingVisitor.b(m5112Z());
                if (m5112Z() != mediaMetadataCreationStoryModel) {
                    graphQLVisitableModel = (MediaMetadataModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f3698u = mediaMetadataCreationStoryModel;
                }
            }
            if (aa() != null) {
                ExplicitPlaceModel explicitPlaceModel = (ExplicitPlaceModel) graphQLModelMutatingVisitor.b(aa());
                if (aa() != explicitPlaceModel) {
                    graphQLVisitableModel = (MediaMetadataModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f3699v = explicitPlaceModel;
                }
            }
            if (ab() != null) {
                PhotosFaceBoxesQueryModel photosFaceBoxesQueryModel = (PhotosFaceBoxesQueryModel) graphQLModelMutatingVisitor.b(ab());
                if (ab() != photosFaceBoxesQueryModel) {
                    graphQLVisitableModel = (MediaMetadataModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f3700w = photosFaceBoxesQueryModel;
                }
            }
            if (ac() != null) {
                SimpleMediaFeedbackModel simpleMediaFeedbackModel = (SimpleMediaFeedbackModel) graphQLModelMutatingVisitor.b(ac());
                if (ac() != simpleMediaFeedbackModel) {
                    graphQLVisitableModel = (MediaMetadataModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f3701x = simpleMediaFeedbackModel;
                }
            }
            if (ad() != null) {
                DefaultVect2FieldsModel defaultVect2FieldsModel = (DefaultVect2FieldsModel) graphQLModelMutatingVisitor.b(ad());
                if (ad() != defaultVect2FieldsModel) {
                    graphQLVisitableModel = (MediaMetadataModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f3702y = defaultVect2FieldsModel;
                }
            }
            if (ae() != null) {
                defaultImageFieldsModel = (DefaultImageFieldsModel) graphQLModelMutatingVisitor.b(ae());
                if (ae() != defaultImageFieldsModel) {
                    graphQLVisitableModel = (MediaMetadataModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f3660C = defaultImageFieldsModel;
                }
            }
            if (af() != null) {
                defaultImageFieldsModel = (DefaultImageFieldsModel) graphQLModelMutatingVisitor.b(af());
                if (af() != defaultImageFieldsModel) {
                    graphQLVisitableModel = (MediaMetadataModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f3661D = defaultImageFieldsModel;
                }
            }
            if (ag() != null) {
                defaultImageFieldsModel = (DefaultImageFieldsModel) graphQLModelMutatingVisitor.b(ag());
                if (ag() != defaultImageFieldsModel) {
                    graphQLVisitableModel = (MediaMetadataModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f3662E = defaultImageFieldsModel;
                }
            }
            if (ah() != null) {
                defaultImageFieldsModel = (DefaultImageFieldsModel) graphQLModelMutatingVisitor.b(ah());
                if (ah() != defaultImageFieldsModel) {
                    graphQLVisitableModel = (MediaMetadataModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f3663F = defaultImageFieldsModel;
                }
            }
            if (ai() != null) {
                defaultImageFieldsModel = (DefaultImageFieldsModel) graphQLModelMutatingVisitor.b(ai());
                if (ai() != defaultImageFieldsModel) {
                    graphQLVisitableModel = (MediaMetadataModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f3664G = defaultImageFieldsModel;
                }
            }
            if (aj() != null) {
                defaultImageFieldsModel = (DefaultImageFieldsModel) graphQLModelMutatingVisitor.b(aj());
                if (aj() != defaultImageFieldsModel) {
                    graphQLVisitableModel = (MediaMetadataModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f3665H = defaultImageFieldsModel;
                }
            }
            if (ak() != null) {
                MediaMetadataInlineActivitiesModel mediaMetadataInlineActivitiesModel = (MediaMetadataInlineActivitiesModel) graphQLModelMutatingVisitor.b(ak());
                if (ak() != mediaMetadataInlineActivitiesModel) {
                    graphQLVisitableModel = (MediaMetadataModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f3666I = mediaMetadataInlineActivitiesModel;
                }
            }
            if (al() != null) {
                defaultImageFieldsModel = (DefaultImageFieldsModel) graphQLModelMutatingVisitor.b(al());
                if (al() != defaultImageFieldsModel) {
                    graphQLVisitableModel = (MediaMetadataModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f3669L = defaultImageFieldsModel;
                }
            }
            if (am() != null) {
                LocationTagSuggestionModel locationTagSuggestionModel = (LocationTagSuggestionModel) graphQLModelMutatingVisitor.b(am());
                if (am() != locationTagSuggestionModel) {
                    graphQLVisitableModel = (MediaMetadataModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f3670M = locationTagSuggestionModel;
                }
            }
            if (an() != null) {
                DefaultTextWithEntitiesLongFieldsModel defaultTextWithEntitiesLongFieldsModel = (DefaultTextWithEntitiesLongFieldsModel) graphQLModelMutatingVisitor.b(an());
                if (an() != defaultTextWithEntitiesLongFieldsModel) {
                    graphQLVisitableModel = (MediaMetadataModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f3671N = defaultTextWithEntitiesLongFieldsModel;
                }
            }
            if (ao() != null) {
                MediaMetadataOwnerModel mediaMetadataOwnerModel = (MediaMetadataOwnerModel) graphQLModelMutatingVisitor.b(ao());
                if (ao() != mediaMetadataOwnerModel) {
                    graphQLVisitableModel = (MediaMetadataModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f3672O = mediaMetadataOwnerModel;
                }
            }
            if (ap() != null) {
                PendingPlaceModel pendingPlaceModel = (PendingPlaceModel) graphQLModelMutatingVisitor.b(ap());
                if (ap() != pendingPlaceModel) {
                    graphQLVisitableModel = (MediaMetadataModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f3673P = pendingPlaceModel;
                }
            }
            if (aq() != null) {
                PrivacyScopeModel privacyScopeModel = (PrivacyScopeModel) graphQLModelMutatingVisitor.b(aq());
                if (aq() != privacyScopeModel) {
                    graphQLVisitableModel = (MediaMetadataModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f3676S = privacyScopeModel;
                }
            }
            if (ar() != null) {
                ImageOverlayFieldsModel imageOverlayFieldsModel = (ImageOverlayFieldsModel) graphQLModelMutatingVisitor.b(ar());
                if (ar() != imageOverlayFieldsModel) {
                    graphQLVisitableModel = (MediaMetadataModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f3677T = imageOverlayFieldsModel;
                }
            }
            if (as() != null) {
                TagInfoQueryModel tagInfoQueryModel = (TagInfoQueryModel) graphQLModelMutatingVisitor.b(as());
                if (as() != tagInfoQueryModel) {
                    graphQLVisitableModel = (MediaMetadataModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f3679V = tagInfoQueryModel;
                }
            }
            if (at() != null) {
                WithTagsModel withTagsModel = (WithTagsModel) graphQLModelMutatingVisitor.b(at());
                if (at() != withTagsModel) {
                    graphQLVisitableModel = (MediaMetadataModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f3680W = withTagsModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m5113a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, mo255b());
            int b = flatBufferBuilder.b(mo262j());
            int a2 = ModelHelper.a(flatBufferBuilder, m5109W());
            int a3 = ModelHelper.a(flatBufferBuilder, m5110X());
            int b2 = flatBufferBuilder.b(mo265m());
            int a4 = ModelHelper.a(flatBufferBuilder, m5111Y());
            int a5 = ModelHelper.a(flatBufferBuilder, m5112Z());
            int a6 = ModelHelper.a(flatBufferBuilder, aa());
            int a7 = ModelHelper.a(flatBufferBuilder, ab());
            int a8 = ModelHelper.a(flatBufferBuilder, ac());
            int a9 = ModelHelper.a(flatBufferBuilder, ad());
            int b3 = flatBufferBuilder.b(mo237E());
            int b4 = flatBufferBuilder.b(mo260d());
            int a10 = ModelHelper.a(flatBufferBuilder, ae());
            int a11 = ModelHelper.a(flatBufferBuilder, af());
            int a12 = ModelHelper.a(flatBufferBuilder, ag());
            int a13 = ModelHelper.a(flatBufferBuilder, ah());
            int a14 = ModelHelper.a(flatBufferBuilder, ai());
            int a15 = ModelHelper.a(flatBufferBuilder, aj());
            int a16 = ModelHelper.a(flatBufferBuilder, ak());
            int a17 = ModelHelper.a(flatBufferBuilder, al());
            int a18 = ModelHelper.a(flatBufferBuilder, am());
            int a19 = ModelHelper.a(flatBufferBuilder, an());
            int a20 = ModelHelper.a(flatBufferBuilder, ao());
            int a21 = ModelHelper.a(flatBufferBuilder, ap());
            int b5 = flatBufferBuilder.b(mo249Q());
            int a22 = ModelHelper.a(flatBufferBuilder, aq());
            int a23 = ModelHelper.a(flatBufferBuilder, ar());
            int a24 = ModelHelper.a(flatBufferBuilder, as());
            int a25 = ModelHelper.a(flatBufferBuilder, at());
            flatBufferBuilder.c(46);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, b);
            flatBufferBuilder.b(2, a2);
            flatBufferBuilder.b(3, a3);
            flatBufferBuilder.b(4, b2);
            flatBufferBuilder.a(5, this.f3686i);
            flatBufferBuilder.a(6, this.f3687j);
            flatBufferBuilder.a(7, this.f3688k);
            flatBufferBuilder.a(8, this.f3689l);
            flatBufferBuilder.a(9, this.f3690m);
            flatBufferBuilder.a(10, this.f3691n);
            flatBufferBuilder.a(11, this.f3692o);
            flatBufferBuilder.a(12, this.f3693p);
            flatBufferBuilder.a(13, this.f3694q);
            flatBufferBuilder.a(14, this.f3695r);
            flatBufferBuilder.b(15, a4);
            flatBufferBuilder.a(16, this.f3697t, 0);
            flatBufferBuilder.b(17, a5);
            flatBufferBuilder.b(18, a6);
            flatBufferBuilder.b(19, a7);
            flatBufferBuilder.b(20, a8);
            flatBufferBuilder.b(21, a9);
            flatBufferBuilder.a(22, this.f3703z);
            flatBufferBuilder.b(23, b3);
            flatBufferBuilder.b(24, b4);
            flatBufferBuilder.b(25, a10);
            flatBufferBuilder.b(26, a11);
            flatBufferBuilder.b(27, a12);
            flatBufferBuilder.b(28, a13);
            flatBufferBuilder.b(29, a14);
            flatBufferBuilder.b(30, a15);
            flatBufferBuilder.b(31, a16);
            flatBufferBuilder.a(32, this.f3667J);
            flatBufferBuilder.a(33, this.f3668K);
            flatBufferBuilder.b(34, a17);
            flatBufferBuilder.b(35, a18);
            flatBufferBuilder.b(36, a19);
            flatBufferBuilder.b(37, a20);
            flatBufferBuilder.b(38, a21);
            flatBufferBuilder.a(39, this.f3674Q, 0);
            flatBufferBuilder.b(40, b5);
            flatBufferBuilder.b(41, a22);
            flatBufferBuilder.b(42, a23);
            flatBufferBuilder.a(43, this.f3678U);
            flatBufferBuilder.b(44, a24);
            flatBufferBuilder.b(45, a25);
            i();
            return flatBufferBuilder.d();
        }

        public final void m5116a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
            super.a(mutableFlatBuffer, i, obj);
            this.f3686i = mutableFlatBuffer.a(i, 5);
            this.f3687j = mutableFlatBuffer.a(i, 6);
            this.f3688k = mutableFlatBuffer.a(i, 7);
            this.f3689l = mutableFlatBuffer.a(i, 8);
            this.f3690m = mutableFlatBuffer.a(i, 9);
            this.f3691n = mutableFlatBuffer.a(i, 10);
            this.f3692o = mutableFlatBuffer.a(i, 11);
            this.f3693p = mutableFlatBuffer.a(i, 12);
            this.f3694q = mutableFlatBuffer.a(i, 13);
            this.f3695r = mutableFlatBuffer.a(i, 14);
            this.f3697t = mutableFlatBuffer.a(i, 16, 0);
            this.f3703z = mutableFlatBuffer.a(i, 22);
            this.f3667J = mutableFlatBuffer.a(i, 32);
            this.f3668K = mutableFlatBuffer.a(i, 33);
            this.f3674Q = mutableFlatBuffer.a(i, 39, 0);
            this.f3678U = mutableFlatBuffer.a(i, 43);
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 1255661007)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: suggest_edits */
    public final class MediaMetadataOwnerModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
        @Nullable
        private GraphQLObjectType f3704d;
        @Nullable
        private String f3705e;
        @Nullable
        private String f3706f;

        /* compiled from: suggest_edits */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(MediaMetadataOwnerModel.class, new Deserializer());
            }

            public Object m5138a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(MediaMetadataOwnerParser.m5443a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object mediaMetadataOwnerModel = new MediaMetadataOwnerModel();
                ((BaseModel) mediaMetadataOwnerModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (mediaMetadataOwnerModel instanceof Postprocessable) {
                    return ((Postprocessable) mediaMetadataOwnerModel).a();
                }
                return mediaMetadataOwnerModel;
            }
        }

        /* compiled from: suggest_edits */
        public class Serializer extends JsonSerializer<MediaMetadataOwnerModel> {
            public final void m5139a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MediaMetadataOwnerModel mediaMetadataOwnerModel = (MediaMetadataOwnerModel) obj;
                if (mediaMetadataOwnerModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(mediaMetadataOwnerModel.m5140a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mediaMetadataOwnerModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                MediaMetadataOwnerParser.m5444a(mediaMetadataOwnerModel.w_(), mediaMetadataOwnerModel.u_(), jsonGenerator);
            }

            static {
                FbSerializerProvider.a(MediaMetadataOwnerModel.class, new Serializer());
            }
        }

        public MediaMetadataOwnerModel() {
            super(3);
        }

        public final void m5143a(String str, ConsistencyTuple consistencyTuple) {
            consistencyTuple.a();
        }

        public final void m5144a(String str, Object obj, boolean z) {
        }

        @Nullable
        public final GraphQLObjectType m5145b() {
            if (this.b != null && this.f3704d == null) {
                this.f3704d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
            }
            return this.f3704d;
        }

        @Nullable
        public final String m5146c() {
            this.f3705e = super.a(this.f3705e, 1);
            return this.f3705e;
        }

        @Nullable
        public final String m5147d() {
            this.f3706f = super.a(this.f3706f, 2);
            return this.f3706f;
        }

        @Nullable
        public final String m5142a() {
            return m5146c();
        }

        public final int jK_() {
            return 63093205;
        }

        public final GraphQLVisitableModel m5141a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            h();
            i();
            return this;
        }

        public final int m5140a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m5145b());
            int b = flatBufferBuilder.b(m5146c());
            int b2 = flatBufferBuilder.b(m5147d());
            flatBufferBuilder.c(3);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, b);
            flatBufferBuilder.b(2, b2);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 324242748)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: suggest_edits */
    public final class MediaMetadataWithoutFeedbackModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel, MediaMetadataWithoutFeedback {
        @Nullable
        private DefaultImageFieldsModel f3725A;
        @Nullable
        private DefaultImageFieldsModel f3726B;
        @Nullable
        private DefaultImageFieldsModel f3727C;
        @Nullable
        private DefaultImageFieldsModel f3728D;
        @Nullable
        private MediaMetadataInlineActivitiesModel f3729E;
        private boolean f3730F;
        @Nullable
        private DefaultImageFieldsModel f3731G;
        @Nullable
        private DefaultTextWithEntitiesLongFieldsModel f3732H;
        @Nullable
        private MediaMetadataOwnerModel f3733I;
        @Nullable
        private PendingPlaceModel f3734J;
        private int f3735K;
        @Nullable
        private String f3736L;
        @Nullable
        private ImageOverlayFieldsModel f3737M;
        @Nullable
        private TagInfoQueryModel f3738N;
        @Nullable
        private WithTagsModel f3739O;
        @Nullable
        private GraphQLObjectType f3740d;
        @Nullable
        private AlbumModel f3741e;
        @Nullable
        private MediaMetadataAttributionAppModel f3742f;
        @Nullable
        private String f3743g;
        private boolean f3744h;
        private boolean f3745i;
        private boolean f3746j;
        private boolean f3747k;
        private boolean f3748l;
        private boolean f3749m;
        private boolean f3750n;
        private boolean f3751o;
        private boolean f3752p;
        private boolean f3753q;
        private long f3754r;
        @Nullable
        private MediaMetadataCreationStoryModel f3755s;
        @Nullable
        private ExplicitPlaceModel f3756t;
        @Nullable
        private PhotosFaceBoxesQueryModel f3757u;
        @Nullable
        private DefaultVect2FieldsModel f3758v;
        private boolean f3759w;
        @Nullable
        private String f3760x;
        @Nullable
        private String f3761y;
        @Nullable
        private DefaultImageFieldsModel f3762z;

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 1101610521)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: suggest_edits */
        public final class AlbumModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel {
            @Nullable
            private GraphQLPhotosAlbumAPIType f3707d;
            @Nullable
            private String f3708e;

            /* compiled from: suggest_edits */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(AlbumModel.class, new Deserializer());
                }

                public Object m5148a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(AlbumParser.m5449a(jsonParser, flatBufferBuilder));
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

            /* compiled from: suggest_edits */
            public class Serializer extends JsonSerializer<AlbumModel> {
                public final void m5149a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    AlbumModel albumModel = (AlbumModel) obj;
                    if (albumModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(albumModel.m5150a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        albumModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    AlbumParser.m5450a(albumModel.w_(), albumModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(AlbumModel.class, new Serializer());
                }
            }

            public AlbumModel() {
                super(2);
            }

            @Nullable
            public final GraphQLPhotosAlbumAPIType m5153b() {
                this.f3707d = (GraphQLPhotosAlbumAPIType) super.b(this.f3707d, 0, GraphQLPhotosAlbumAPIType.class, GraphQLPhotosAlbumAPIType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
                return this.f3707d;
            }

            @Nullable
            public final String m5154c() {
                this.f3708e = super.a(this.f3708e, 1);
                return this.f3708e;
            }

            @Nullable
            public final String m5152a() {
                return m5154c();
            }

            public final int jK_() {
                return 63344207;
            }

            public final GraphQLVisitableModel m5151a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m5150a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = flatBufferBuilder.a(m5153b());
                int b = flatBufferBuilder.b(m5154c());
                flatBufferBuilder.c(2);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.b(1, b);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: suggest_edits */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(MediaMetadataWithoutFeedbackModel.class, new Deserializer());
            }

            public Object m5155a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(MediaMetadataWithoutFeedbackParser.m5459a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object mediaMetadataWithoutFeedbackModel = new MediaMetadataWithoutFeedbackModel();
                ((BaseModel) mediaMetadataWithoutFeedbackModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (mediaMetadataWithoutFeedbackModel instanceof Postprocessable) {
                    return ((Postprocessable) mediaMetadataWithoutFeedbackModel).a();
                }
                return mediaMetadataWithoutFeedbackModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 1255661007)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: suggest_edits */
        public final class ExplicitPlaceModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
            @Nullable
            private GraphQLObjectType f3712d;
            @Nullable
            private String f3713e;
            @Nullable
            private String f3714f;

            /* compiled from: suggest_edits */
            public final class Builder {
                @Nullable
                public GraphQLObjectType f3709a;
                @Nullable
                public String f3710b;
                @Nullable
                public String f3711c;

                public final ExplicitPlaceModel m5156a() {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    int a = ModelHelper.a(flatBufferBuilder, this.f3709a);
                    int b = flatBufferBuilder.b(this.f3710b);
                    int b2 = flatBufferBuilder.b(this.f3711c);
                    flatBufferBuilder.c(3);
                    flatBufferBuilder.b(0, a);
                    flatBufferBuilder.b(1, b);
                    flatBufferBuilder.b(2, b2);
                    flatBufferBuilder.d(flatBufferBuilder.d());
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    return new ExplicitPlaceModel(new MutableFlatBuffer(wrap, null, null, true, null));
                }
            }

            /* compiled from: suggest_edits */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(ExplicitPlaceModel.class, new Deserializer());
                }

                public Object m5157a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(ExplicitPlaceParser.m5451a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object explicitPlaceModel = new ExplicitPlaceModel();
                    ((BaseModel) explicitPlaceModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (explicitPlaceModel instanceof Postprocessable) {
                        return ((Postprocessable) explicitPlaceModel).a();
                    }
                    return explicitPlaceModel;
                }
            }

            /* compiled from: suggest_edits */
            public class Serializer extends JsonSerializer<ExplicitPlaceModel> {
                public final void m5158a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    ExplicitPlaceModel explicitPlaceModel = (ExplicitPlaceModel) obj;
                    if (explicitPlaceModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(explicitPlaceModel.m5160a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        explicitPlaceModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    ExplicitPlaceParser.m5452a(explicitPlaceModel.w_(), explicitPlaceModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(ExplicitPlaceModel.class, new Serializer());
                }
            }

            public ExplicitPlaceModel() {
                super(3);
            }

            public ExplicitPlaceModel(MutableFlatBuffer mutableFlatBuffer) {
                super(3);
                a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
            }

            public final void m5163a(String str, ConsistencyTuple consistencyTuple) {
                if ("name".equals(str)) {
                    consistencyTuple.a = m5167d();
                    consistencyTuple.b = u_();
                    consistencyTuple.c = 2;
                    return;
                }
                consistencyTuple.a();
            }

            public final void m5164a(String str, Object obj, boolean z) {
                if ("name".equals(str)) {
                    m5159a((String) obj);
                }
            }

            @Nullable
            public final GraphQLObjectType m5165b() {
                if (this.b != null && this.f3712d == null) {
                    this.f3712d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
                }
                return this.f3712d;
            }

            @Nullable
            public final String m5166c() {
                this.f3713e = super.a(this.f3713e, 1);
                return this.f3713e;
            }

            @Nullable
            public final String m5167d() {
                this.f3714f = super.a(this.f3714f, 2);
                return this.f3714f;
            }

            private void m5159a(@Nullable String str) {
                this.f3714f = str;
                if (this.b != null && this.b.d) {
                    this.b.a(this.c, 2, str);
                }
            }

            @Nullable
            public final String m5162a() {
                return m5166c();
            }

            public final int jK_() {
                return 77195495;
            }

            public final GraphQLVisitableModel m5161a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m5160a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m5165b());
                int b = flatBufferBuilder.b(m5166c());
                int b2 = flatBufferBuilder.b(m5167d());
                flatBufferBuilder.c(3);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.b(1, b);
                flatBufferBuilder.b(2, b2);
                i();
                return flatBufferBuilder.d();
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 1255661007)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: suggest_edits */
        public final class PendingPlaceModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
            @Nullable
            private GraphQLObjectType f3718d;
            @Nullable
            private String f3719e;
            @Nullable
            private String f3720f;

            /* compiled from: suggest_edits */
            public final class Builder {
                @Nullable
                public GraphQLObjectType f3715a;
                @Nullable
                public String f3716b;
                @Nullable
                public String f3717c;

                public final PendingPlaceModel m5168a() {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    int a = ModelHelper.a(flatBufferBuilder, this.f3715a);
                    int b = flatBufferBuilder.b(this.f3716b);
                    int b2 = flatBufferBuilder.b(this.f3717c);
                    flatBufferBuilder.c(3);
                    flatBufferBuilder.b(0, a);
                    flatBufferBuilder.b(1, b);
                    flatBufferBuilder.b(2, b2);
                    flatBufferBuilder.d(flatBufferBuilder.d());
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    return new PendingPlaceModel(new MutableFlatBuffer(wrap, null, null, true, null));
                }
            }

            /* compiled from: suggest_edits */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(PendingPlaceModel.class, new Deserializer());
                }

                public Object m5169a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(PendingPlaceParser.m5453a(r11, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object pendingPlaceModel = new PendingPlaceModel();
                    ((BaseModel) pendingPlaceModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), r11);
                    if (pendingPlaceModel instanceof Postprocessable) {
                        return ((Postprocessable) pendingPlaceModel).a();
                    }
                    return pendingPlaceModel;
                }
            }

            /* compiled from: suggest_edits */
            public class Serializer extends JsonSerializer<PendingPlaceModel> {
                public final void m5170a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    PendingPlaceModel pendingPlaceModel = (PendingPlaceModel) r8;
                    if (pendingPlaceModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(pendingPlaceModel.m5172a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        pendingPlaceModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    PendingPlaceParser.m5454a(pendingPlaceModel.w_(), pendingPlaceModel.u_(), r9);
                }

                static {
                    FbSerializerProvider.a(PendingPlaceModel.class, new Serializer());
                }
            }

            public PendingPlaceModel() {
                super(3);
            }

            public PendingPlaceModel(MutableFlatBuffer mutableFlatBuffer) {
                super(3);
                a(r3, FlatBuffer.a(r3.a));
            }

            public final void m5175a(String str, ConsistencyTuple consistencyTuple) {
                if ("name".equals(r2)) {
                    r3.a = m5179d();
                    r3.b = u_();
                    r3.c = 2;
                    return;
                }
                r3.a();
            }

            public final void m5176a(String str, Object obj, boolean z) {
                if ("name".equals(r2)) {
                    m5171a((String) r3);
                }
            }

            @Nullable
            public final GraphQLObjectType m5177b() {
                if (this.b != null && this.f3718d == null) {
                    this.f3718d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
                }
                return this.f3718d;
            }

            @Nullable
            public final String m5178c() {
                this.f3719e = super.a(this.f3719e, 1);
                return this.f3719e;
            }

            @Nullable
            public final String m5179d() {
                this.f3720f = super.a(this.f3720f, 2);
                return this.f3720f;
            }

            private void m5171a(@Nullable String str) {
                this.f3720f = r5;
                if (this.b != null && this.b.d) {
                    this.b.a(this.c, 2, r5);
                }
            }

            @Nullable
            public final String m5174a() {
                return m5178c();
            }

            public final int jK_() {
                return 77195495;
            }

            public final GraphQLVisitableModel m5173a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m5172a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(r5, m5177b());
                int b = r5.b(m5178c());
                int b2 = r5.b(m5179d());
                r5.c(3);
                r5.b(0, a);
                r5.b(1, b);
                r5.b(2, b2);
                i();
                return r5.d();
            }
        }

        /* compiled from: suggest_edits */
        public class Serializer extends JsonSerializer<MediaMetadataWithoutFeedbackModel> {
            public final void m5180a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MediaMetadataWithoutFeedbackModel mediaMetadataWithoutFeedbackModel = (MediaMetadataWithoutFeedbackModel) r8;
                if (mediaMetadataWithoutFeedbackModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(mediaMetadataWithoutFeedbackModel.m5218a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mediaMetadataWithoutFeedbackModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                MediaMetadataWithoutFeedbackParser.m5460a(mediaMetadataWithoutFeedbackModel.w_(), mediaMetadataWithoutFeedbackModel.u_(), r9, r10);
            }

            static {
                FbSerializerProvider.a(MediaMetadataWithoutFeedbackModel.class, new Serializer());
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1057279065)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: suggest_edits */
        public final class WithTagsModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private List<NodesModel> f3724d;

            /* compiled from: suggest_edits */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(WithTagsModel.class, new Deserializer());
                }

                public Object m5181a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(WithTagsParser.m5457a(r11, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object withTagsModel = new WithTagsModel();
                    ((BaseModel) withTagsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), r11);
                    if (withTagsModel instanceof Postprocessable) {
                        return ((Postprocessable) withTagsModel).a();
                    }
                    return withTagsModel;
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = 1255661007)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: suggest_edits */
            public final class NodesModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
                @Nullable
                private GraphQLObjectType f3721d;
                @Nullable
                private String f3722e;
                @Nullable
                private String f3723f;

                /* compiled from: suggest_edits */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(NodesModel.class, new Deserializer());
                    }

                    public Object m5182a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(NodesParser.m5456b(r11, flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                        Object nodesModel = new NodesModel();
                        ((BaseModel) nodesModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), r11);
                        if (nodesModel instanceof Postprocessable) {
                            return ((Postprocessable) nodesModel).a();
                        }
                        return nodesModel;
                    }
                }

                /* compiled from: suggest_edits */
                public class Serializer extends JsonSerializer<NodesModel> {
                    public final void m5183a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        NodesModel nodesModel = (NodesModel) r8;
                        if (nodesModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(nodesModel.m5184a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            nodesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        NodesParser.m5455a(nodesModel.w_(), nodesModel.u_(), r9);
                    }

                    static {
                        FbSerializerProvider.a(NodesModel.class, new Serializer());
                    }
                }

                public NodesModel() {
                    super(3);
                }

                public final void m5187a(String str, ConsistencyTuple consistencyTuple) {
                    r2.a();
                }

                public final void m5188a(String str, Object obj, boolean z) {
                }

                @Nullable
                public final GraphQLObjectType m5189b() {
                    if (this.b != null && this.f3721d == null) {
                        this.f3721d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
                    }
                    return this.f3721d;
                }

                @Nullable
                public final String m5190c() {
                    this.f3722e = super.a(this.f3722e, 1);
                    return this.f3722e;
                }

                @Nullable
                public final String m5191d() {
                    this.f3723f = super.a(this.f3723f, 2);
                    return this.f3723f;
                }

                @Nullable
                public final String m5186a() {
                    return m5190c();
                }

                public final int jK_() {
                    return 63093205;
                }

                public final GraphQLVisitableModel m5185a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    h();
                    i();
                    return this;
                }

                public final int m5184a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int a = ModelHelper.a(r5, m5189b());
                    int b = r5.b(m5190c());
                    int b2 = r5.b(m5191d());
                    r5.c(3);
                    r5.b(0, a);
                    r5.b(1, b);
                    r5.b(2, b2);
                    i();
                    return r5.d();
                }
            }

            /* compiled from: suggest_edits */
            public class Serializer extends JsonSerializer<WithTagsModel> {
                public final void m5192a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    WithTagsModel withTagsModel = (WithTagsModel) r8;
                    if (withTagsModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(withTagsModel.m5193a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        withTagsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    WithTagsParser.m5458a(withTagsModel.w_(), withTagsModel.u_(), r9, r10);
                }

                static {
                    FbSerializerProvider.a(WithTagsModel.class, new Serializer());
                }
            }

            public WithTagsModel() {
                super(1);
            }

            @Nonnull
            public final ImmutableList<NodesModel> m5195a() {
                this.f3724d = super.a(this.f3724d, 0, NodesModel.class);
                return (ImmutableList) this.f3724d;
            }

            public final int jK_() {
                return 1521707613;
            }

            public final GraphQLVisitableModel m5194a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m5195a() != null) {
                    Builder a = ModelHelper.a(m5195a(), r3);
                    if (a != null) {
                        graphQLVisitableModel = (WithTagsModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f3724d = a.b();
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m5193a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(r3, m5195a());
                r3.c(1);
                r3.b(0, a);
                i();
                return r3.d();
            }
        }

        @Nullable
        public final /* synthetic */ DefaultImageFields bc_() {
            return m5212u();
        }

        @Nullable
        public final /* synthetic */ DefaultImageFields bd_() {
            return m5211t();
        }

        @Nullable
        public final /* synthetic */ DefaultImageFields be_() {
            return m5209r();
        }

        @Nullable
        public final /* synthetic */ DefaultVect2Fields m5223c() {
            return m5207p();
        }

        @Nullable
        public final /* synthetic */ DefaultImageFields m5225g() {
            return m5210s();
        }

        public MediaMetadataWithoutFeedbackModel() {
            super(38);
        }

        @Nullable
        public final GraphQLObjectType m5222b() {
            if (this.b != null && this.f3740d == null) {
                this.f3740d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
            }
            return this.f3740d;
        }

        @Nullable
        private AlbumModel m5201j() {
            this.f3741e = (AlbumModel) super.a(this.f3741e, 1, AlbumModel.class);
            return this.f3741e;
        }

        @Nullable
        private MediaMetadataAttributionAppModel m5202k() {
            this.f3742f = (MediaMetadataAttributionAppModel) super.a(this.f3742f, 2, MediaMetadataAttributionAppModel.class);
            return this.f3742f;
        }

        @Nullable
        private String m5203l() {
            this.f3743g = super.a(this.f3743g, 3);
            return this.f3743g;
        }

        @Nullable
        private MediaMetadataCreationStoryModel m5204m() {
            this.f3755s = (MediaMetadataCreationStoryModel) super.a(this.f3755s, 15, MediaMetadataCreationStoryModel.class);
            return this.f3755s;
        }

        @Nullable
        private ExplicitPlaceModel m5205n() {
            this.f3756t = (ExplicitPlaceModel) super.a(this.f3756t, 16, ExplicitPlaceModel.class);
            return this.f3756t;
        }

        @Nullable
        private PhotosFaceBoxesQueryModel m5206o() {
            this.f3757u = (PhotosFaceBoxesQueryModel) super.a(this.f3757u, 17, PhotosFaceBoxesQueryModel.class);
            return this.f3757u;
        }

        @Nullable
        private DefaultVect2FieldsModel m5207p() {
            this.f3758v = (DefaultVect2FieldsModel) super.a(this.f3758v, 18, DefaultVect2FieldsModel.class);
            return this.f3758v;
        }

        @Nullable
        private String m5208q() {
            this.f3760x = super.a(this.f3760x, 20);
            return this.f3760x;
        }

        @Nullable
        public final String m5224d() {
            this.f3761y = super.a(this.f3761y, 21);
            return this.f3761y;
        }

        @Nullable
        private DefaultImageFieldsModel m5209r() {
            this.f3762z = (DefaultImageFieldsModel) super.a(this.f3762z, 22, DefaultImageFieldsModel.class);
            return this.f3762z;
        }

        @Nullable
        private DefaultImageFieldsModel m5210s() {
            this.f3725A = (DefaultImageFieldsModel) super.a(this.f3725A, 23, DefaultImageFieldsModel.class);
            return this.f3725A;
        }

        @Nullable
        private DefaultImageFieldsModel m5211t() {
            this.f3726B = (DefaultImageFieldsModel) super.a(this.f3726B, 24, DefaultImageFieldsModel.class);
            return this.f3726B;
        }

        @Nullable
        private DefaultImageFieldsModel m5212u() {
            this.f3727C = (DefaultImageFieldsModel) super.a(this.f3727C, 25, DefaultImageFieldsModel.class);
            return this.f3727C;
        }

        @Nullable
        private DefaultImageFieldsModel m5213v() {
            this.f3728D = (DefaultImageFieldsModel) super.a(this.f3728D, 26, DefaultImageFieldsModel.class);
            return this.f3728D;
        }

        @Nullable
        private MediaMetadataInlineActivitiesModel m5214w() {
            this.f3729E = (MediaMetadataInlineActivitiesModel) super.a(this.f3729E, 27, MediaMetadataInlineActivitiesModel.class);
            return this.f3729E;
        }

        @Nullable
        private DefaultImageFieldsModel m5215x() {
            this.f3731G = (DefaultImageFieldsModel) super.a(this.f3731G, 29, DefaultImageFieldsModel.class);
            return this.f3731G;
        }

        @Nullable
        private DefaultTextWithEntitiesLongFieldsModel m5216y() {
            this.f3732H = (DefaultTextWithEntitiesLongFieldsModel) super.a(this.f3732H, 30, DefaultTextWithEntitiesLongFieldsModel.class);
            return this.f3732H;
        }

        @Nullable
        private MediaMetadataOwnerModel m5217z() {
            this.f3733I = (MediaMetadataOwnerModel) super.a(this.f3733I, 31, MediaMetadataOwnerModel.class);
            return this.f3733I;
        }

        @Nullable
        private PendingPlaceModel m5196A() {
            this.f3734J = (PendingPlaceModel) super.a(this.f3734J, 32, PendingPlaceModel.class);
            return this.f3734J;
        }

        @Nullable
        private String m5197B() {
            this.f3736L = super.a(this.f3736L, 34);
            return this.f3736L;
        }

        @Nullable
        private ImageOverlayFieldsModel m5198C() {
            this.f3737M = (ImageOverlayFieldsModel) super.a(this.f3737M, 35, ImageOverlayFieldsModel.class);
            return this.f3737M;
        }

        @Nullable
        private TagInfoQueryModel m5199D() {
            this.f3738N = (TagInfoQueryModel) super.a(this.f3738N, 36, TagInfoQueryModel.class);
            return this.f3738N;
        }

        @Nullable
        private WithTagsModel m5200E() {
            this.f3739O = (WithTagsModel) super.a(this.f3739O, 37, WithTagsModel.class);
            return this.f3739O;
        }

        @Nullable
        public final String m5220a() {
            return m5224d();
        }

        public final int jK_() {
            return 74219460;
        }

        public final GraphQLVisitableModel m5219a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            DefaultImageFieldsModel defaultImageFieldsModel;
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m5201j() != null) {
                AlbumModel albumModel = (AlbumModel) r4.b(m5201j());
                if (m5201j() != albumModel) {
                    graphQLVisitableModel = (MediaMetadataWithoutFeedbackModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f3741e = albumModel;
                }
            }
            if (m5202k() != null) {
                MediaMetadataAttributionAppModel mediaMetadataAttributionAppModel = (MediaMetadataAttributionAppModel) r4.b(m5202k());
                if (m5202k() != mediaMetadataAttributionAppModel) {
                    graphQLVisitableModel = (MediaMetadataWithoutFeedbackModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f3742f = mediaMetadataAttributionAppModel;
                }
            }
            if (m5204m() != null) {
                MediaMetadataCreationStoryModel mediaMetadataCreationStoryModel = (MediaMetadataCreationStoryModel) r4.b(m5204m());
                if (m5204m() != mediaMetadataCreationStoryModel) {
                    graphQLVisitableModel = (MediaMetadataWithoutFeedbackModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f3755s = mediaMetadataCreationStoryModel;
                }
            }
            if (m5205n() != null) {
                ExplicitPlaceModel explicitPlaceModel = (ExplicitPlaceModel) r4.b(m5205n());
                if (m5205n() != explicitPlaceModel) {
                    graphQLVisitableModel = (MediaMetadataWithoutFeedbackModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f3756t = explicitPlaceModel;
                }
            }
            if (m5206o() != null) {
                PhotosFaceBoxesQueryModel photosFaceBoxesQueryModel = (PhotosFaceBoxesQueryModel) r4.b(m5206o());
                if (m5206o() != photosFaceBoxesQueryModel) {
                    graphQLVisitableModel = (MediaMetadataWithoutFeedbackModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f3757u = photosFaceBoxesQueryModel;
                }
            }
            if (m5207p() != null) {
                DefaultVect2FieldsModel defaultVect2FieldsModel = (DefaultVect2FieldsModel) r4.b(m5207p());
                if (m5207p() != defaultVect2FieldsModel) {
                    graphQLVisitableModel = (MediaMetadataWithoutFeedbackModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f3758v = defaultVect2FieldsModel;
                }
            }
            if (m5209r() != null) {
                defaultImageFieldsModel = (DefaultImageFieldsModel) r4.b(m5209r());
                if (m5209r() != defaultImageFieldsModel) {
                    graphQLVisitableModel = (MediaMetadataWithoutFeedbackModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f3762z = defaultImageFieldsModel;
                }
            }
            if (m5210s() != null) {
                defaultImageFieldsModel = (DefaultImageFieldsModel) r4.b(m5210s());
                if (m5210s() != defaultImageFieldsModel) {
                    graphQLVisitableModel = (MediaMetadataWithoutFeedbackModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f3725A = defaultImageFieldsModel;
                }
            }
            if (m5211t() != null) {
                defaultImageFieldsModel = (DefaultImageFieldsModel) r4.b(m5211t());
                if (m5211t() != defaultImageFieldsModel) {
                    graphQLVisitableModel = (MediaMetadataWithoutFeedbackModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f3726B = defaultImageFieldsModel;
                }
            }
            if (m5212u() != null) {
                defaultImageFieldsModel = (DefaultImageFieldsModel) r4.b(m5212u());
                if (m5212u() != defaultImageFieldsModel) {
                    graphQLVisitableModel = (MediaMetadataWithoutFeedbackModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f3727C = defaultImageFieldsModel;
                }
            }
            if (m5213v() != null) {
                defaultImageFieldsModel = (DefaultImageFieldsModel) r4.b(m5213v());
                if (m5213v() != defaultImageFieldsModel) {
                    graphQLVisitableModel = (MediaMetadataWithoutFeedbackModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f3728D = defaultImageFieldsModel;
                }
            }
            if (m5214w() != null) {
                MediaMetadataInlineActivitiesModel mediaMetadataInlineActivitiesModel = (MediaMetadataInlineActivitiesModel) r4.b(m5214w());
                if (m5214w() != mediaMetadataInlineActivitiesModel) {
                    graphQLVisitableModel = (MediaMetadataWithoutFeedbackModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f3729E = mediaMetadataInlineActivitiesModel;
                }
            }
            if (m5215x() != null) {
                defaultImageFieldsModel = (DefaultImageFieldsModel) r4.b(m5215x());
                if (m5215x() != defaultImageFieldsModel) {
                    graphQLVisitableModel = (MediaMetadataWithoutFeedbackModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f3731G = defaultImageFieldsModel;
                }
            }
            if (m5216y() != null) {
                DefaultTextWithEntitiesLongFieldsModel defaultTextWithEntitiesLongFieldsModel = (DefaultTextWithEntitiesLongFieldsModel) r4.b(m5216y());
                if (m5216y() != defaultTextWithEntitiesLongFieldsModel) {
                    graphQLVisitableModel = (MediaMetadataWithoutFeedbackModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f3732H = defaultTextWithEntitiesLongFieldsModel;
                }
            }
            if (m5217z() != null) {
                MediaMetadataOwnerModel mediaMetadataOwnerModel = (MediaMetadataOwnerModel) r4.b(m5217z());
                if (m5217z() != mediaMetadataOwnerModel) {
                    graphQLVisitableModel = (MediaMetadataWithoutFeedbackModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f3733I = mediaMetadataOwnerModel;
                }
            }
            if (m5196A() != null) {
                PendingPlaceModel pendingPlaceModel = (PendingPlaceModel) r4.b(m5196A());
                if (m5196A() != pendingPlaceModel) {
                    graphQLVisitableModel = (MediaMetadataWithoutFeedbackModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f3734J = pendingPlaceModel;
                }
            }
            if (m5198C() != null) {
                ImageOverlayFieldsModel imageOverlayFieldsModel = (ImageOverlayFieldsModel) r4.b(m5198C());
                if (m5198C() != imageOverlayFieldsModel) {
                    graphQLVisitableModel = (MediaMetadataWithoutFeedbackModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f3737M = imageOverlayFieldsModel;
                }
            }
            if (m5199D() != null) {
                TagInfoQueryModel tagInfoQueryModel = (TagInfoQueryModel) r4.b(m5199D());
                if (m5199D() != tagInfoQueryModel) {
                    graphQLVisitableModel = (MediaMetadataWithoutFeedbackModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f3738N = tagInfoQueryModel;
                }
            }
            if (m5200E() != null) {
                WithTagsModel withTagsModel = (WithTagsModel) r4.b(m5200E());
                if (m5200E() != withTagsModel) {
                    graphQLVisitableModel = (MediaMetadataWithoutFeedbackModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f3739O = withTagsModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m5218a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(r29, m5222b());
            int a2 = ModelHelper.a(r29, m5201j());
            int a3 = ModelHelper.a(r29, m5202k());
            int b = r29.b(m5203l());
            int a4 = ModelHelper.a(r29, m5204m());
            int a5 = ModelHelper.a(r29, m5205n());
            int a6 = ModelHelper.a(r29, m5206o());
            int a7 = ModelHelper.a(r29, m5207p());
            int b2 = r29.b(m5208q());
            int b3 = r29.b(m5224d());
            int a8 = ModelHelper.a(r29, m5209r());
            int a9 = ModelHelper.a(r29, m5210s());
            int a10 = ModelHelper.a(r29, m5211t());
            int a11 = ModelHelper.a(r29, m5212u());
            int a12 = ModelHelper.a(r29, m5213v());
            int a13 = ModelHelper.a(r29, m5214w());
            int a14 = ModelHelper.a(r29, m5215x());
            int a15 = ModelHelper.a(r29, m5216y());
            int a16 = ModelHelper.a(r29, m5217z());
            int a17 = ModelHelper.a(r29, m5196A());
            int b4 = r29.b(m5197B());
            int a18 = ModelHelper.a(r29, m5198C());
            int a19 = ModelHelper.a(r29, m5199D());
            int a20 = ModelHelper.a(r29, m5200E());
            r29.c(38);
            r29.b(0, a);
            r29.b(1, a2);
            r29.b(2, a3);
            r29.b(3, b);
            r29.a(4, this.f3744h);
            r29.a(5, this.f3745i);
            r29.a(6, this.f3746j);
            r29.a(7, this.f3747k);
            r29.a(8, this.f3748l);
            r29.a(9, this.f3749m);
            r29.a(10, this.f3750n);
            r29.a(11, this.f3751o);
            r29.a(12, this.f3752p);
            r29.a(13, this.f3753q);
            r29.a(14, this.f3754r, 0);
            r29.b(15, a4);
            r29.b(16, a5);
            r29.b(17, a6);
            r29.b(18, a7);
            r29.a(19, this.f3759w);
            r29.b(20, b2);
            r29.b(21, b3);
            r29.b(22, a8);
            r29.b(23, a9);
            r29.b(24, a10);
            r29.b(25, a11);
            r29.b(26, a12);
            r29.b(27, a13);
            r29.a(28, this.f3730F);
            r29.b(29, a14);
            r29.b(30, a15);
            r29.b(31, a16);
            r29.b(32, a17);
            r29.a(33, this.f3735K, 0);
            r29.b(34, b4);
            r29.b(35, a18);
            r29.b(36, a19);
            r29.b(37, a20);
            i();
            return r29.d();
        }

        public final void m5221a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
            super.a(r5, r6, r7);
            this.f3744h = r5.a(r6, 4);
            this.f3745i = r5.a(r6, 5);
            this.f3746j = r5.a(r6, 6);
            this.f3747k = r5.a(r6, 7);
            this.f3748l = r5.a(r6, 8);
            this.f3749m = r5.a(r6, 9);
            this.f3750n = r5.a(r6, 10);
            this.f3751o = r5.a(r6, 11);
            this.f3752p = r5.a(r6, 12);
            this.f3753q = r5.a(r6, 13);
            this.f3754r = r5.a(r6, 14, 0);
            this.f3759w = r5.a(r6, 19);
            this.f3730F = r5.a(r6, 28);
            this.f3735K = r5.a(r6, 33, 0);
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 1673505904)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: suggest_edits */
    public final class MediaPrivacyAndContainerStoryModel extends BaseModel implements GraphQLVisitableModel, MediaPrivacyAndContainerStory {
        @Nullable
        private MediaPrivacyContainerStoryModel f3766d;
        @Nullable
        private PrivacyScopeModel f3767e;

        /* compiled from: suggest_edits */
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
                r0 = com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.MediaPrivacyAndContainerStoryModel.class;
                r1 = new com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels$MediaPrivacyAndContainerStoryModel$Deserializer;
                r1.<init>();
                com.facebook.common.json.GlobalAutoGenDeserializerCache.a(r0, r1);
                return;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.MediaPrivacyAndContainerStoryModel.Deserializer.<clinit>():void");
            }

            public java.lang.Object m5226a(com.fasterxml.jackson.core.JsonParser r6, com.fasterxml.jackson.databind.DeserializationContext r7) {
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
                r2 = com.facebook.photos.data.protocol.PhotosMetadataGraphQLParsers.MediaPrivacyAndContainerStoryParser.m5465a(r6);
                r1 = new com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels$MediaPrivacyAndContainerStoryModel;
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
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.MediaPrivacyAndContainerStoryModel.Deserializer.a(com.fasterxml.jackson.core.JsonParser, com.fasterxml.jackson.databind.DeserializationContext):java.lang.Object");
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 1924851732)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: suggest_edits */
        public final class PrivacyScopeModel extends BaseModel implements GraphQLVisitableModel {
            private boolean f3764d;
            @Nullable
            private IconImageModel f3765e;

            /* compiled from: suggest_edits */
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
                    r0 = com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.MediaPrivacyAndContainerStoryModel.PrivacyScopeModel.class;
                    r1 = new com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels$MediaPrivacyAndContainerStoryModel$PrivacyScopeModel$Deserializer;
                    r1.<init>();
                    com.facebook.common.json.GlobalAutoGenDeserializerCache.a(r0, r1);
                    return;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.MediaPrivacyAndContainerStoryModel.PrivacyScopeModel.Deserializer.<clinit>():void");
                }

                public java.lang.Object m5227a(com.fasterxml.jackson.core.JsonParser r11, com.fasterxml.jackson.databind.DeserializationContext r12) {
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
                    r5 = com.facebook.photos.data.protocol.PhotosMetadataGraphQLParsers.MediaPrivacyAndContainerStoryParser.PrivacyScopeParser.m5463a(r11, r4);
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
                    r1 = new com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels$MediaPrivacyAndContainerStoryModel$PrivacyScopeModel;
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
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.MediaPrivacyAndContainerStoryModel.PrivacyScopeModel.Deserializer.a(com.fasterxml.jackson.core.JsonParser, com.fasterxml.jackson.databind.DeserializationContext):java.lang.Object");
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = 842551240)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: suggest_edits */
            public final class IconImageModel extends BaseModel implements GraphQLVisitableModel {
                @Nullable
                private String f3763d;

                /* compiled from: suggest_edits */
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
                        r0 = com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.MediaPrivacyAndContainerStoryModel.PrivacyScopeModel.IconImageModel.class;
                        r1 = new com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels$MediaPrivacyAndContainerStoryModel$PrivacyScopeModel$IconImageModel$Deserializer;
                        r1.<init>();
                        com.facebook.common.json.GlobalAutoGenDeserializerCache.a(r0, r1);
                        return;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.MediaPrivacyAndContainerStoryModel.PrivacyScopeModel.IconImageModel.Deserializer.<clinit>():void");
                    }

                    public java.lang.Object m5228a(com.fasterxml.jackson.core.JsonParser r11, com.fasterxml.jackson.databind.DeserializationContext r12) {
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
                        r5 = com.facebook.photos.data.protocol.PhotosMetadataGraphQLParsers.MediaPrivacyAndContainerStoryParser.PrivacyScopeParser.IconImageParser.m5461a(r11, r4);
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
                        r1 = new com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels$MediaPrivacyAndContainerStoryModel$PrivacyScopeModel$IconImageModel;
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
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.MediaPrivacyAndContainerStoryModel.PrivacyScopeModel.IconImageModel.Deserializer.a(com.fasterxml.jackson.core.JsonParser, com.fasterxml.jackson.databind.DeserializationContext):java.lang.Object");
                    }
                }

                /* compiled from: suggest_edits */
                public class Serializer extends JsonSerializer<IconImageModel> {
                    public final void m5229a(java.lang.Object r8, com.fasterxml.jackson.core.JsonGenerator r9, com.fasterxml.jackson.databind.SerializerProvider r10) {
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
                        r8 = (com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.MediaPrivacyAndContainerStoryModel.PrivacyScopeModel.IconImageModel) r8;
                        r2 = 0;
                        r0 = r8.w_();
                        if (r0 != 0) goto L_0x0035;
                    L_0x0009:
                        r0 = new com.facebook.flatbuffers.FlatBufferBuilder;
                        r1 = 128; // 0x80 float:1.794E-43 double:6.32E-322;
                        r0.<init>(r1);
                        r1 = r8.m5230a(r0);
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
                        com.facebook.photos.data.protocol.PhotosMetadataGraphQLParsers.MediaPrivacyAndContainerStoryParser.PrivacyScopeParser.IconImageParser.m5462a(r0, r1, r9);
                        return;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.MediaPrivacyAndContainerStoryModel.PrivacyScopeModel.IconImageModel.Serializer.a(java.lang.Object, com.fasterxml.jackson.core.JsonGenerator, com.fasterxml.jackson.databind.SerializerProvider):void");
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
                        r0 = com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.MediaPrivacyAndContainerStoryModel.PrivacyScopeModel.IconImageModel.class;
                        r1 = new com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels$MediaPrivacyAndContainerStoryModel$PrivacyScopeModel$IconImageModel$Serializer;
                        r1.<init>();
                        com.facebook.common.json.FbSerializerProvider.a(r0, r1);
                        return;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.MediaPrivacyAndContainerStoryModel.PrivacyScopeModel.IconImageModel.Serializer.<clinit>():void");
                    }
                }

                public IconImageModel() {
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
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.MediaPrivacyAndContainerStoryModel.PrivacyScopeModel.IconImageModel.<init>():void");
                }

                @javax.annotation.Nullable
                public final java.lang.String m5232a() {
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
                    r0 = r2.f3763d;
                    r1 = 0;
                    r0 = super.a(r0, r1);
                    r2.f3763d = r0;
                    r0 = r2.f3763d;
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.MediaPrivacyAndContainerStoryModel.PrivacyScopeModel.IconImageModel.a():java.lang.String");
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
                    r0 = 70760763; // 0x437b93b float:2.15966E-36 double:3.4960462E-316;
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.MediaPrivacyAndContainerStoryModel.PrivacyScopeModel.IconImageModel.jK_():int");
                }

                public final com.facebook.graphql.visitor.GraphQLVisitableModel m5231a(com.facebook.graphql.visitor.GraphQLModelMutatingVisitor r1) {
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
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.MediaPrivacyAndContainerStoryModel.PrivacyScopeModel.IconImageModel.a(com.facebook.graphql.visitor.GraphQLModelMutatingVisitor):com.facebook.graphql.visitor.GraphQLVisitableModel");
                }

                public final int m5230a(com.facebook.flatbuffers.FlatBufferBuilder r3) {
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
                    r0 = r2.m5232a();
                    r0 = r3.b(r0);
                    r1 = 1;
                    r3.c(r1);
                    r1 = 0;
                    r3.b(r1, r0);
                    r2.i();
                    r0 = r3.d();
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.MediaPrivacyAndContainerStoryModel.PrivacyScopeModel.IconImageModel.a(com.facebook.flatbuffers.FlatBufferBuilder):int");
                }
            }

            /* compiled from: suggest_edits */
            public class Serializer extends JsonSerializer<PrivacyScopeModel> {
                public final void m5233a(java.lang.Object r8, com.fasterxml.jackson.core.JsonGenerator r9, com.fasterxml.jackson.databind.SerializerProvider r10) {
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
                    r8 = (com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.MediaPrivacyAndContainerStoryModel.PrivacyScopeModel) r8;
                    r2 = 0;
                    r0 = r8.w_();
                    if (r0 != 0) goto L_0x0035;
                L_0x0009:
                    r0 = new com.facebook.flatbuffers.FlatBufferBuilder;
                    r1 = 128; // 0x80 float:1.794E-43 double:6.32E-322;
                    r0.<init>(r1);
                    r1 = r8.m5235a(r0);
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
                    com.facebook.photos.data.protocol.PhotosMetadataGraphQLParsers.MediaPrivacyAndContainerStoryParser.PrivacyScopeParser.m5464a(r0, r1, r9, r10);
                    return;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.MediaPrivacyAndContainerStoryModel.PrivacyScopeModel.Serializer.a(java.lang.Object, com.fasterxml.jackson.core.JsonGenerator, com.fasterxml.jackson.databind.SerializerProvider):void");
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
                    r0 = com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.MediaPrivacyAndContainerStoryModel.PrivacyScopeModel.class;
                    r1 = new com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels$MediaPrivacyAndContainerStoryModel$PrivacyScopeModel$Serializer;
                    r1.<init>();
                    com.facebook.common.json.FbSerializerProvider.a(r0, r1);
                    return;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.MediaPrivacyAndContainerStoryModel.PrivacyScopeModel.Serializer.<clinit>():void");
                }
            }

            @javax.annotation.Nullable
            public final /* synthetic */ com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.MediaPrivacyAndContainerStoryModel.PrivacyScopeModel.IconImageModel m5239b() {
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
                r0 = r1.m5234j();
                return r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.MediaPrivacyAndContainerStoryModel.PrivacyScopeModel.b():com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels$MediaPrivacyAndContainerStoryModel$PrivacyScopeModel$IconImageModel");
            }

            public PrivacyScopeModel() {
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
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.MediaPrivacyAndContainerStoryModel.PrivacyScopeModel.<init>():void");
            }

            public final boolean m5238a() {
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
                r0 = 0;
                r1.a(r0, r0);
                r0 = r1.f3764d;
                return r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.MediaPrivacyAndContainerStoryModel.PrivacyScopeModel.a():boolean");
            }

            @javax.annotation.Nullable
            private com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.MediaPrivacyAndContainerStoryModel.PrivacyScopeModel.IconImageModel m5234j() {
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
                r0 = r3.f3765e;
                r1 = 1;
                r2 = com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.MediaPrivacyAndContainerStoryModel.PrivacyScopeModel.IconImageModel.class;
                r0 = super.a(r0, r1, r2);
                r0 = (com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.MediaPrivacyAndContainerStoryModel.PrivacyScopeModel.IconImageModel) r0;
                r3.f3765e = r0;
                r0 = r3.f3765e;
                return r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.MediaPrivacyAndContainerStoryModel.PrivacyScopeModel.j():com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels$MediaPrivacyAndContainerStoryModel$PrivacyScopeModel$IconImageModel");
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
                r0 = -476351540; // 0xffffffffe39b73cc float:-5.735179E21 double:NaN;
                return r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.MediaPrivacyAndContainerStoryModel.PrivacyScopeModel.jK_():int");
            }

            public final com.facebook.graphql.visitor.GraphQLVisitableModel m5236a(com.facebook.graphql.visitor.GraphQLModelMutatingVisitor r4) {
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
                r0 = r3.m5234j();
                if (r0 == 0) goto L_0x0022;
            L_0x000a:
                r0 = r3.m5234j();
                r0 = r4.b(r0);
                r0 = (com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.MediaPrivacyAndContainerStoryModel.PrivacyScopeModel.IconImageModel) r0;
                r2 = r3.m5234j();
                if (r2 == r0) goto L_0x0022;
            L_0x001a:
                r1 = com.facebook.graphql.modelutil.ModelHelper.a(r1, r3);
                r1 = (com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.MediaPrivacyAndContainerStoryModel.PrivacyScopeModel) r1;
                r1.f3765e = r0;
            L_0x0022:
                r3.i();
                if (r1 != 0) goto L_0x0028;
            L_0x0027:
                return r3;
            L_0x0028:
                r3 = r1;
                goto L_0x0027;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.MediaPrivacyAndContainerStoryModel.PrivacyScopeModel.a(com.facebook.graphql.visitor.GraphQLModelMutatingVisitor):com.facebook.graphql.visitor.GraphQLVisitableModel");
            }

            public final int m5235a(com.facebook.flatbuffers.FlatBufferBuilder r4) {
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
                r0 = r3.m5234j();
                r0 = com.facebook.graphql.modelutil.ModelHelper.a(r4, r0);
                r1 = 2;
                r4.c(r1);
                r1 = 0;
                r2 = r3.f3764d;
                r4.a(r1, r2);
                r1 = 1;
                r4.b(r1, r0);
                r3.i();
                r0 = r4.d();
                return r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.MediaPrivacyAndContainerStoryModel.PrivacyScopeModel.a(com.facebook.flatbuffers.FlatBufferBuilder):int");
            }

            public final void m5237a(com.facebook.flatbuffers.MutableFlatBuffer r2, int r3, java.lang.Object r4) {
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
                r0 = 0;
                r0 = r2.a(r3, r0);
                r1.f3764d = r0;
                return;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.MediaPrivacyAndContainerStoryModel.PrivacyScopeModel.a(com.facebook.flatbuffers.MutableFlatBuffer, int, java.lang.Object):void");
            }
        }

        /* compiled from: suggest_edits */
        public class Serializer extends JsonSerializer<MediaPrivacyAndContainerStoryModel> {
            public final void m5240a(java.lang.Object r9, com.fasterxml.jackson.core.JsonGenerator r10, com.fasterxml.jackson.databind.SerializerProvider r11) {
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
                r9 = (com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.MediaPrivacyAndContainerStoryModel) r9;
                r2 = 0;
                r0 = r9.w_();
                if (r0 != 0) goto L_0x0035;
            L_0x0009:
                r0 = new com.facebook.flatbuffers.FlatBufferBuilder;
                r1 = 128; // 0x80 float:1.794E-43 double:6.32E-322;
                r0.<init>(r1);
                r1 = r9.m5243a(r0);
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
                r7 = "container_story";
                r10.a(r7);
                com.facebook.photos.data.protocol.PhotosMetadataGraphQLParsers.MediaPrivacyContainerStoryParser.m5471a(r0, r6, r10, r11);
            L_0x004f:
                r6 = 1;
                r6 = r0.g(r1, r6);
                if (r6 == 0) goto L_0x005e;
            L_0x0056:
                r7 = "privacy_scope";
                r10.a(r7);
                com.facebook.photos.data.protocol.PhotosMetadataGraphQLParsers.MediaPrivacyAndContainerStoryParser.PrivacyScopeParser.m5464a(r0, r6, r10, r11);
            L_0x005e:
                r10.g();
                return;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.MediaPrivacyAndContainerStoryModel.Serializer.a(java.lang.Object, com.fasterxml.jackson.core.JsonGenerator, com.fasterxml.jackson.databind.SerializerProvider):void");
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
                r0 = com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.MediaPrivacyAndContainerStoryModel.class;
                r1 = new com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels$MediaPrivacyAndContainerStoryModel$Serializer;
                r1.<init>();
                com.facebook.common.json.FbSerializerProvider.a(r0, r1);
                return;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.MediaPrivacyAndContainerStoryModel.Serializer.<clinit>():void");
            }
        }

        public MediaPrivacyAndContainerStoryModel() {
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
            r0 = 2;
            r1.<init>(r0);
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.MediaPrivacyAndContainerStoryModel.<init>():void");
        }

        @javax.annotation.Nullable
        private com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.MediaPrivacyContainerStoryModel m5241a() {
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
            r0 = r3.f3766d;
            r1 = 0;
            r2 = com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.MediaPrivacyContainerStoryModel.class;
            r0 = super.a(r0, r1, r2);
            r0 = (com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.MediaPrivacyContainerStoryModel) r0;
            r3.f3766d = r0;
            r0 = r3.f3766d;
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.MediaPrivacyAndContainerStoryModel.a():com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels$MediaPrivacyContainerStoryModel");
        }

        @javax.annotation.Nullable
        private com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.MediaPrivacyAndContainerStoryModel.PrivacyScopeModel m5242j() {
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
            r0 = r3.f3767e;
            r1 = 1;
            r2 = com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.MediaPrivacyAndContainerStoryModel.PrivacyScopeModel.class;
            r0 = super.a(r0, r1, r2);
            r0 = (com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.MediaPrivacyAndContainerStoryModel.PrivacyScopeModel) r0;
            r3.f3767e = r0;
            r0 = r3.f3767e;
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.MediaPrivacyAndContainerStoryModel.j():com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels$MediaPrivacyAndContainerStoryModel$PrivacyScopeModel");
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
            r0 = 77090322; // 0x4984e12 float:3.5806725E-36 double:3.80876797E-316;
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.MediaPrivacyAndContainerStoryModel.jK_():int");
        }

        public final com.facebook.graphql.visitor.GraphQLVisitableModel m5244a(com.facebook.graphql.visitor.GraphQLModelMutatingVisitor r4) {
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
            r0 = r3.m5241a();
            if (r0 == 0) goto L_0x0022;
        L_0x000a:
            r0 = r3.m5241a();
            r0 = r4.b(r0);
            r0 = (com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.MediaPrivacyContainerStoryModel) r0;
            r2 = r3.m5241a();
            if (r2 == r0) goto L_0x0022;
        L_0x001a:
            r1 = com.facebook.graphql.modelutil.ModelHelper.a(r1, r3);
            r1 = (com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.MediaPrivacyAndContainerStoryModel) r1;
            r1.f3766d = r0;
        L_0x0022:
            r0 = r3.m5242j();
            if (r0 == 0) goto L_0x0040;
        L_0x0028:
            r0 = r3.m5242j();
            r0 = r4.b(r0);
            r0 = (com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.MediaPrivacyAndContainerStoryModel.PrivacyScopeModel) r0;
            r2 = r3.m5242j();
            if (r2 == r0) goto L_0x0040;
        L_0x0038:
            r1 = com.facebook.graphql.modelutil.ModelHelper.a(r1, r3);
            r1 = (com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.MediaPrivacyAndContainerStoryModel) r1;
            r1.f3767e = r0;
        L_0x0040:
            r3.i();
            if (r1 != 0) goto L_0x0046;
        L_0x0045:
            return r3;
        L_0x0046:
            r3 = r1;
            goto L_0x0045;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.MediaPrivacyAndContainerStoryModel.a(com.facebook.graphql.visitor.GraphQLModelMutatingVisitor):com.facebook.graphql.visitor.GraphQLVisitableModel");
        }

        public final int m5243a(com.facebook.flatbuffers.FlatBufferBuilder r4) {
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
            r3.h();
            r0 = r3.m5241a();
            r0 = com.facebook.graphql.modelutil.ModelHelper.a(r4, r0);
            r1 = r3.m5242j();
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
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.MediaPrivacyAndContainerStoryModel.a(com.facebook.flatbuffers.FlatBufferBuilder):int");
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -633766874)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: suggest_edits */
    public final class MediaPrivacyContainerStoryModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
        @Nullable
        private String f3771d;
        @Nullable
        private String f3772e;
        @Nullable
        private String f3773f;
        @Nullable
        private PrivacyScopeModel f3774g;

        /* compiled from: suggest_edits */
        public class Deserializer extends FbJsonDeserializer {
            public Deserializer() {
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
                r0 = this;
                r0.<init>();
                return;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.MediaPrivacyContainerStoryModel.Deserializer.<init>():void");
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
                r0 = com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.MediaPrivacyContainerStoryModel.class;
                r1 = new com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels$MediaPrivacyContainerStoryModel$Deserializer;
                r1.<init>();
                com.facebook.common.json.GlobalAutoGenDeserializerCache.a(r0, r1);
                return;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.MediaPrivacyContainerStoryModel.Deserializer.<clinit>():void");
            }

            public java.lang.Object m5245a(com.fasterxml.jackson.core.JsonParser r11, com.fasterxml.jackson.databind.DeserializationContext r12) {
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
                r5 = com.facebook.photos.data.protocol.PhotosMetadataGraphQLParsers.MediaPrivacyContainerStoryParser.m5470a(r11, r4);
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
                r1 = new com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels$MediaPrivacyContainerStoryModel;
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
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.MediaPrivacyContainerStoryModel.Deserializer.a(com.fasterxml.jackson.core.JsonParser, com.fasterxml.jackson.databind.DeserializationContext):java.lang.Object");
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1282529351)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: suggest_edits */
        public final class PrivacyScopeModel extends BaseModel implements GraphQLVisitableModel {
            private boolean f3769d;
            @Nullable
            private IconImageModel f3770e;

            /* compiled from: suggest_edits */
            public class Deserializer extends FbJsonDeserializer {
                public Deserializer() {
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
                    r0.<init>();
                    return;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.MediaPrivacyContainerStoryModel.PrivacyScopeModel.Deserializer.<init>():void");
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
                    r0 = com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.MediaPrivacyContainerStoryModel.PrivacyScopeModel.class;
                    r1 = new com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels$MediaPrivacyContainerStoryModel$PrivacyScopeModel$Deserializer;
                    r1.<init>();
                    com.facebook.common.json.GlobalAutoGenDeserializerCache.a(r0, r1);
                    return;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.MediaPrivacyContainerStoryModel.PrivacyScopeModel.Deserializer.<clinit>():void");
                }

                public java.lang.Object m5246a(com.fasterxml.jackson.core.JsonParser r11, com.fasterxml.jackson.databind.DeserializationContext r12) {
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
                    r5 = com.facebook.photos.data.protocol.PhotosMetadataGraphQLParsers.MediaPrivacyContainerStoryParser.PrivacyScopeParser.m5468a(r11, r4);
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
                    r1 = new com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels$MediaPrivacyContainerStoryModel$PrivacyScopeModel;
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
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.MediaPrivacyContainerStoryModel.PrivacyScopeModel.Deserializer.a(com.fasterxml.jackson.core.JsonParser, com.fasterxml.jackson.databind.DeserializationContext):java.lang.Object");
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = 842551240)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: suggest_edits */
            public final class IconImageModel extends BaseModel implements GraphQLVisitableModel {
                @Nullable
                private String f3768d;

                /* compiled from: suggest_edits */
                public class Deserializer extends FbJsonDeserializer {
                    public Deserializer() {
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
                        r0 = this;
                        r0.<init>();
                        return;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.MediaPrivacyContainerStoryModel.PrivacyScopeModel.IconImageModel.Deserializer.<init>():void");
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
                        r0 = com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.MediaPrivacyContainerStoryModel.PrivacyScopeModel.IconImageModel.class;
                        r1 = new com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels$MediaPrivacyContainerStoryModel$PrivacyScopeModel$IconImageModel$Deserializer;
                        r1.<init>();
                        com.facebook.common.json.GlobalAutoGenDeserializerCache.a(r0, r1);
                        return;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.MediaPrivacyContainerStoryModel.PrivacyScopeModel.IconImageModel.Deserializer.<clinit>():void");
                    }

                    public java.lang.Object m5247a(com.fasterxml.jackson.core.JsonParser r11, com.fasterxml.jackson.databind.DeserializationContext r12) {
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
                        r5 = com.facebook.photos.data.protocol.PhotosMetadataGraphQLParsers.MediaPrivacyContainerStoryParser.PrivacyScopeParser.IconImageParser.m5466a(r11, r4);
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
                        r1 = new com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels$MediaPrivacyContainerStoryModel$PrivacyScopeModel$IconImageModel;
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
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.MediaPrivacyContainerStoryModel.PrivacyScopeModel.IconImageModel.Deserializer.a(com.fasterxml.jackson.core.JsonParser, com.fasterxml.jackson.databind.DeserializationContext):java.lang.Object");
                    }
                }

                /* compiled from: suggest_edits */
                public class Serializer extends JsonSerializer<IconImageModel> {
                    public Serializer() {
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
                        r0 = this;
                        r0.<init>();
                        return;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.MediaPrivacyContainerStoryModel.PrivacyScopeModel.IconImageModel.Serializer.<init>():void");
                    }

                    public final void m5248a(java.lang.Object r8, com.fasterxml.jackson.core.JsonGenerator r9, com.fasterxml.jackson.databind.SerializerProvider r10) {
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
                        r8 = (com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.MediaPrivacyContainerStoryModel.PrivacyScopeModel.IconImageModel) r8;
                        r2 = 0;
                        r0 = r8.w_();
                        if (r0 != 0) goto L_0x0035;
                    L_0x0009:
                        r0 = new com.facebook.flatbuffers.FlatBufferBuilder;
                        r1 = 128; // 0x80 float:1.794E-43 double:6.32E-322;
                        r0.<init>(r1);
                        r1 = r8.m5249a(r0);
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
                        com.facebook.photos.data.protocol.PhotosMetadataGraphQLParsers.MediaPrivacyContainerStoryParser.PrivacyScopeParser.IconImageParser.m5467a(r0, r1, r9);
                        return;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.MediaPrivacyContainerStoryModel.PrivacyScopeModel.IconImageModel.Serializer.a(java.lang.Object, com.fasterxml.jackson.core.JsonGenerator, com.fasterxml.jackson.databind.SerializerProvider):void");
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
                        r0 = com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.MediaPrivacyContainerStoryModel.PrivacyScopeModel.IconImageModel.class;
                        r1 = new com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels$MediaPrivacyContainerStoryModel$PrivacyScopeModel$IconImageModel$Serializer;
                        r1.<init>();
                        com.facebook.common.json.FbSerializerProvider.a(r0, r1);
                        return;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.MediaPrivacyContainerStoryModel.PrivacyScopeModel.IconImageModel.Serializer.<clinit>():void");
                    }
                }

                public IconImageModel() {
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
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.MediaPrivacyContainerStoryModel.PrivacyScopeModel.IconImageModel.<init>():void");
                }

                @javax.annotation.Nullable
                public final java.lang.String m5251a() {
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
                    r0 = r2.f3768d;
                    r1 = 0;
                    r0 = super.a(r0, r1);
                    r2.f3768d = r0;
                    r0 = r2.f3768d;
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.MediaPrivacyContainerStoryModel.PrivacyScopeModel.IconImageModel.a():java.lang.String");
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
                    r0 = 70760763; // 0x437b93b float:2.15966E-36 double:3.4960462E-316;
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.MediaPrivacyContainerStoryModel.PrivacyScopeModel.IconImageModel.jK_():int");
                }

                public final com.facebook.graphql.visitor.GraphQLVisitableModel m5250a(com.facebook.graphql.visitor.GraphQLModelMutatingVisitor r1) {
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
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.MediaPrivacyContainerStoryModel.PrivacyScopeModel.IconImageModel.a(com.facebook.graphql.visitor.GraphQLModelMutatingVisitor):com.facebook.graphql.visitor.GraphQLVisitableModel");
                }

                public final int m5249a(com.facebook.flatbuffers.FlatBufferBuilder r3) {
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
                    r0 = r2.m5251a();
                    r0 = r3.b(r0);
                    r1 = 1;
                    r3.c(r1);
                    r1 = 0;
                    r3.b(r1, r0);
                    r2.i();
                    r0 = r3.d();
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.MediaPrivacyContainerStoryModel.PrivacyScopeModel.IconImageModel.a(com.facebook.flatbuffers.FlatBufferBuilder):int");
                }
            }

            /* compiled from: suggest_edits */
            public class Serializer extends JsonSerializer<PrivacyScopeModel> {
                public Serializer() {
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
                    r0.<init>();
                    return;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.MediaPrivacyContainerStoryModel.PrivacyScopeModel.Serializer.<init>():void");
                }

                public final void m5252a(java.lang.Object r8, com.fasterxml.jackson.core.JsonGenerator r9, com.fasterxml.jackson.databind.SerializerProvider r10) {
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
                    r8 = (com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.MediaPrivacyContainerStoryModel.PrivacyScopeModel) r8;
                    r2 = 0;
                    r0 = r8.w_();
                    if (r0 != 0) goto L_0x0035;
                L_0x0009:
                    r0 = new com.facebook.flatbuffers.FlatBufferBuilder;
                    r1 = 128; // 0x80 float:1.794E-43 double:6.32E-322;
                    r0.<init>(r1);
                    r1 = r8.m5254a(r0);
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
                    com.facebook.photos.data.protocol.PhotosMetadataGraphQLParsers.MediaPrivacyContainerStoryParser.PrivacyScopeParser.m5469a(r0, r1, r9, r10);
                    return;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.MediaPrivacyContainerStoryModel.PrivacyScopeModel.Serializer.a(java.lang.Object, com.fasterxml.jackson.core.JsonGenerator, com.fasterxml.jackson.databind.SerializerProvider):void");
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
                    r0 = com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.MediaPrivacyContainerStoryModel.PrivacyScopeModel.class;
                    r1 = new com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels$MediaPrivacyContainerStoryModel$PrivacyScopeModel$Serializer;
                    r1.<init>();
                    com.facebook.common.json.FbSerializerProvider.a(r0, r1);
                    return;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.MediaPrivacyContainerStoryModel.PrivacyScopeModel.Serializer.<clinit>():void");
                }
            }

            @javax.annotation.Nullable
            public final /* synthetic */ com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.MediaPrivacyContainerStoryModel.PrivacyScopeModel.IconImageModel m5258b() {
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
                r0 = r1.m5253j();
                return r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.MediaPrivacyContainerStoryModel.PrivacyScopeModel.b():com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels$MediaPrivacyContainerStoryModel$PrivacyScopeModel$IconImageModel");
            }

            public PrivacyScopeModel() {
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
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.MediaPrivacyContainerStoryModel.PrivacyScopeModel.<init>():void");
            }

            public final boolean m5257a() {
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
                r0 = 0;
                r1.a(r0, r0);
                r0 = r1.f3769d;
                return r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.MediaPrivacyContainerStoryModel.PrivacyScopeModel.a():boolean");
            }

            @javax.annotation.Nullable
            private com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.MediaPrivacyContainerStoryModel.PrivacyScopeModel.IconImageModel m5253j() {
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
                r0 = r3.f3770e;
                r1 = 1;
                r2 = com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.MediaPrivacyContainerStoryModel.PrivacyScopeModel.IconImageModel.class;
                r0 = super.a(r0, r1, r2);
                r0 = (com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.MediaPrivacyContainerStoryModel.PrivacyScopeModel.IconImageModel) r0;
                r3.f3770e = r0;
                r0 = r3.f3770e;
                return r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.MediaPrivacyContainerStoryModel.PrivacyScopeModel.j():com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels$MediaPrivacyContainerStoryModel$PrivacyScopeModel$IconImageModel");
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
                r0 = -476351540; // 0xffffffffe39b73cc float:-5.735179E21 double:NaN;
                return r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.MediaPrivacyContainerStoryModel.PrivacyScopeModel.jK_():int");
            }

            public final com.facebook.graphql.visitor.GraphQLVisitableModel m5255a(com.facebook.graphql.visitor.GraphQLModelMutatingVisitor r4) {
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
                r0 = r3.m5253j();
                if (r0 == 0) goto L_0x0022;
            L_0x000a:
                r0 = r3.m5253j();
                r0 = r4.b(r0);
                r0 = (com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.MediaPrivacyContainerStoryModel.PrivacyScopeModel.IconImageModel) r0;
                r2 = r3.m5253j();
                if (r2 == r0) goto L_0x0022;
            L_0x001a:
                r1 = com.facebook.graphql.modelutil.ModelHelper.a(r1, r3);
                r1 = (com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.MediaPrivacyContainerStoryModel.PrivacyScopeModel) r1;
                r1.f3770e = r0;
            L_0x0022:
                r3.i();
                if (r1 != 0) goto L_0x0028;
            L_0x0027:
                return r3;
            L_0x0028:
                r3 = r1;
                goto L_0x0027;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.MediaPrivacyContainerStoryModel.PrivacyScopeModel.a(com.facebook.graphql.visitor.GraphQLModelMutatingVisitor):com.facebook.graphql.visitor.GraphQLVisitableModel");
            }

            public final int m5254a(com.facebook.flatbuffers.FlatBufferBuilder r4) {
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
                r0 = r3.m5253j();
                r0 = com.facebook.graphql.modelutil.ModelHelper.a(r4, r0);
                r1 = 2;
                r4.c(r1);
                r1 = 0;
                r2 = r3.f3769d;
                r4.a(r1, r2);
                r1 = 1;
                r4.b(r1, r0);
                r3.i();
                r0 = r4.d();
                return r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.MediaPrivacyContainerStoryModel.PrivacyScopeModel.a(com.facebook.flatbuffers.FlatBufferBuilder):int");
            }

            public final void m5256a(com.facebook.flatbuffers.MutableFlatBuffer r2, int r3, java.lang.Object r4) {
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
                r0 = 0;
                r0 = r2.a(r3, r0);
                r1.f3769d = r0;
                return;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.MediaPrivacyContainerStoryModel.PrivacyScopeModel.a(com.facebook.flatbuffers.MutableFlatBuffer, int, java.lang.Object):void");
            }
        }

        /* compiled from: suggest_edits */
        public class Serializer extends JsonSerializer<MediaPrivacyContainerStoryModel> {
            public Serializer() {
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
                r0 = this;
                r0.<init>();
                return;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.MediaPrivacyContainerStoryModel.Serializer.<init>():void");
            }

            public final void m5259a(java.lang.Object r8, com.fasterxml.jackson.core.JsonGenerator r9, com.fasterxml.jackson.databind.SerializerProvider r10) {
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
                r8 = (com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.MediaPrivacyContainerStoryModel) r8;
                r2 = 0;
                r0 = r8.w_();
                if (r0 != 0) goto L_0x0035;
            L_0x0009:
                r0 = new com.facebook.flatbuffers.FlatBufferBuilder;
                r1 = 128; // 0x80 float:1.794E-43 double:6.32E-322;
                r0.<init>(r1);
                r1 = r8.m5261a(r0);
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
                com.facebook.photos.data.protocol.PhotosMetadataGraphQLParsers.MediaPrivacyContainerStoryParser.m5471a(r0, r1, r9, r10);
                return;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.MediaPrivacyContainerStoryModel.Serializer.a(java.lang.Object, com.fasterxml.jackson.core.JsonGenerator, com.fasterxml.jackson.databind.SerializerProvider):void");
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
                r0 = com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.MediaPrivacyContainerStoryModel.class;
                r1 = new com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels$MediaPrivacyContainerStoryModel$Serializer;
                r1.<init>();
                com.facebook.common.json.FbSerializerProvider.a(r0, r1);
                return;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.MediaPrivacyContainerStoryModel.Serializer.<clinit>():void");
            }
        }

        @javax.annotation.Nullable
        public final /* synthetic */ com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.MediaPrivacyContainerStoryModel.PrivacyScopeModel bl_() {
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
            r0 = r1.m5260j();
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.MediaPrivacyContainerStoryModel.bl_():com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels$MediaPrivacyContainerStoryModel$PrivacyScopeModel");
        }

        public MediaPrivacyContainerStoryModel() {
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
            r0 = 4;
            r1.<init>(r0);
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.MediaPrivacyContainerStoryModel.<init>():void");
        }

        public final void m5264a(java.lang.String r1, com.facebook.graphql.visitor.ConsistencyTuple r2) {
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
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.MediaPrivacyContainerStoryModel.a(java.lang.String, com.facebook.graphql.visitor.ConsistencyTuple):void");
        }

        public final void m5265a(java.lang.String r1, java.lang.Object r2, boolean r3) {
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
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.MediaPrivacyContainerStoryModel.a(java.lang.String, java.lang.Object, boolean):void");
        }

        @javax.annotation.Nullable
        public final java.lang.String m5266b() {
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
            r0 = r2.f3771d;
            r1 = 0;
            r0 = super.a(r0, r1);
            r2.f3771d = r0;
            r0 = r2.f3771d;
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.MediaPrivacyContainerStoryModel.b():java.lang.String");
        }

        @javax.annotation.Nullable
        public final java.lang.String m5267c() {
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
            r0 = r2.f3772e;
            r1 = 1;
            r0 = super.a(r0, r1);
            r2.f3772e = r0;
            r0 = r2.f3772e;
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.MediaPrivacyContainerStoryModel.c():java.lang.String");
        }

        @javax.annotation.Nullable
        public final java.lang.String m5268d() {
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
            r0 = r2.f3773f;
            r1 = 2;
            r0 = super.a(r0, r1);
            r2.f3773f = r0;
            r0 = r2.f3773f;
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.MediaPrivacyContainerStoryModel.d():java.lang.String");
        }

        @javax.annotation.Nullable
        private com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.MediaPrivacyContainerStoryModel.PrivacyScopeModel m5260j() {
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
            r0 = r3.f3774g;
            r1 = 3;
            r2 = com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.MediaPrivacyContainerStoryModel.PrivacyScopeModel.class;
            r0 = super.a(r0, r1, r2);
            r0 = (com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.MediaPrivacyContainerStoryModel.PrivacyScopeModel) r0;
            r3.f3774g = r0;
            r0 = r3.f3774g;
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.MediaPrivacyContainerStoryModel.j():com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels$MediaPrivacyContainerStoryModel$PrivacyScopeModel");
        }

        @javax.annotation.Nullable
        public final java.lang.String m5263a() {
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
            r0 = r1.m5267c();
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.MediaPrivacyContainerStoryModel.a():java.lang.String");
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
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.MediaPrivacyContainerStoryModel.jK_():int");
        }

        public final com.facebook.graphql.visitor.GraphQLVisitableModel m5262a(com.facebook.graphql.visitor.GraphQLModelMutatingVisitor r4) {
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
            r0 = r3.m5260j();
            if (r0 == 0) goto L_0x0022;
        L_0x000a:
            r0 = r3.m5260j();
            r0 = r4.b(r0);
            r0 = (com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.MediaPrivacyContainerStoryModel.PrivacyScopeModel) r0;
            r2 = r3.m5260j();
            if (r2 == r0) goto L_0x0022;
        L_0x001a:
            r1 = com.facebook.graphql.modelutil.ModelHelper.a(r1, r3);
            r1 = (com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.MediaPrivacyContainerStoryModel) r1;
            r1.f3774g = r0;
        L_0x0022:
            r3.i();
            if (r1 != 0) goto L_0x0028;
        L_0x0027:
            return r3;
        L_0x0028:
            r3 = r1;
            goto L_0x0027;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.MediaPrivacyContainerStoryModel.a(com.facebook.graphql.visitor.GraphQLModelMutatingVisitor):com.facebook.graphql.visitor.GraphQLVisitableModel");
        }

        public final int m5261a(com.facebook.flatbuffers.FlatBufferBuilder r6) {
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
            r5 = this;
            r5.h();
            r0 = r5.m5266b();
            r0 = r6.b(r0);
            r1 = r5.m5267c();
            r1 = r6.b(r1);
            r2 = r5.m5268d();
            r2 = r6.b(r2);
            r3 = r5.m5260j();
            r3 = com.facebook.graphql.modelutil.ModelHelper.a(r6, r3);
            r4 = 4;
            r6.c(r4);
            r4 = 0;
            r6.b(r4, r0);
            r0 = 1;
            r6.b(r0, r1);
            r0 = 2;
            r6.b(r0, r2);
            r0 = 3;
            r6.b(r0, r3);
            r5.i();
            r0 = r6.d();
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.MediaPrivacyContainerStoryModel.a(com.facebook.flatbuffers.FlatBufferBuilder):int");
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -873475796)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: suggest_edits */
    public final class PageMediaWithAttributionModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel, PageMediaWithAttribution {
        @Nullable
        private GraphQLObjectType f3793d;
        private long f3794e;
        @Nullable
        private DefaultVect2FieldsModel f3795f;
        @Nullable
        private String f3796g;
        @Nullable
        private DefaultImageFieldsModel f3797h;
        @Nullable
        private DefaultImageFieldsModel f3798i;
        @Nullable
        private DefaultImageFieldsModel f3799j;
        @Nullable
        private DefaultImageFieldsModel f3800k;
        @Nullable
        private OwnerModel f3801l;
        @Nullable
        private PrivacyScopeModel f3802m;

        /* compiled from: suggest_edits */
        public final class Builder {
            @Nullable
            public GraphQLObjectType f3775a;
            public long f3776b;
            @Nullable
            public DefaultVect2FieldsModel f3777c;
            @Nullable
            public String f3778d;
            @Nullable
            public DefaultImageFieldsModel f3779e;
            @Nullable
            public DefaultImageFieldsModel f3780f;
            @Nullable
            public DefaultImageFieldsModel f3781g;
            @Nullable
            public DefaultImageFieldsModel f3782h;
            @Nullable
            public OwnerModel f3783i;
            @Nullable
            public PrivacyScopeModel f3784j;

            public final PageMediaWithAttributionModel m5269a() {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                int a = ModelHelper.a(flatBufferBuilder, this.f3775a);
                int a2 = ModelHelper.a(flatBufferBuilder, this.f3777c);
                int b = flatBufferBuilder.b(this.f3778d);
                int a3 = ModelHelper.a(flatBufferBuilder, this.f3779e);
                int a4 = ModelHelper.a(flatBufferBuilder, this.f3780f);
                int a5 = ModelHelper.a(flatBufferBuilder, this.f3781g);
                int a6 = ModelHelper.a(flatBufferBuilder, this.f3782h);
                int a7 = ModelHelper.a(flatBufferBuilder, this.f3783i);
                int a8 = ModelHelper.a(flatBufferBuilder, this.f3784j);
                flatBufferBuilder.c(10);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.a(1, this.f3776b, 0);
                flatBufferBuilder.b(2, a2);
                flatBufferBuilder.b(3, b);
                flatBufferBuilder.b(4, a3);
                flatBufferBuilder.b(5, a4);
                flatBufferBuilder.b(6, a5);
                flatBufferBuilder.b(7, a6);
                flatBufferBuilder.b(8, a7);
                flatBufferBuilder.b(9, a8);
                flatBufferBuilder.d(flatBufferBuilder.d());
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                return new PageMediaWithAttributionModel(new MutableFlatBuffer(wrap, null, null, true, null));
            }
        }

        /* compiled from: suggest_edits */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(PageMediaWithAttributionModel.class, new Deserializer());
            }

            public Object m5270a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(PageMediaWithAttributionParser.m5478a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object pageMediaWithAttributionModel = new PageMediaWithAttributionModel();
                ((BaseModel) pageMediaWithAttributionModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (pageMediaWithAttributionModel instanceof Postprocessable) {
                    return ((Postprocessable) pageMediaWithAttributionModel).a();
                }
                return pageMediaWithAttributionModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -341630258)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: suggest_edits */
        public final class OwnerModel extends BaseModel implements GraphQLVisitableConsistentModel {
            @Nullable
            private GraphQLObjectType f3787d;
            @Nullable
            private String f3788e;

            /* compiled from: suggest_edits */
            public final class Builder {
                @Nullable
                public GraphQLObjectType f3785a;
                @Nullable
                public String f3786b;
            }

            /* compiled from: suggest_edits */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(OwnerModel.class, new Deserializer());
                }

                public Object m5271a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(OwnerParser.m5472a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object ownerModel = new OwnerModel();
                    ((BaseModel) ownerModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (ownerModel instanceof Postprocessable) {
                        return ((Postprocessable) ownerModel).a();
                    }
                    return ownerModel;
                }
            }

            /* compiled from: suggest_edits */
            public class Serializer extends JsonSerializer<OwnerModel> {
                public final void m5272a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    OwnerModel ownerModel = (OwnerModel) obj;
                    if (ownerModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(ownerModel.m5274a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        ownerModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    OwnerParser.m5473a(ownerModel.w_(), ownerModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(OwnerModel.class, new Serializer());
                }
            }

            public OwnerModel() {
                super(2);
            }

            public OwnerModel(MutableFlatBuffer mutableFlatBuffer) {
                super(2);
                a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
            }

            public final void m5277a(String str, ConsistencyTuple consistencyTuple) {
                consistencyTuple.a();
            }

            public final void m5278a(String str, Object obj, boolean z) {
            }

            @Nullable
            public final GraphQLObjectType m5275a() {
                if (this.b != null && this.f3787d == null) {
                    this.f3787d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
                }
                return this.f3787d;
            }

            @Nullable
            public final String m5279b() {
                this.f3788e = super.a(this.f3788e, 1);
                return this.f3788e;
            }

            public static OwnerModel m5273a(OwnerModel ownerModel) {
                if (ownerModel == null) {
                    return null;
                }
                if (ownerModel instanceof OwnerModel) {
                    return ownerModel;
                }
                Builder builder = new Builder();
                builder.f3785a = ownerModel.m5275a();
                builder.f3786b = ownerModel.m5279b();
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                int a = ModelHelper.a(flatBufferBuilder, builder.f3785a);
                int b = flatBufferBuilder.b(builder.f3786b);
                flatBufferBuilder.c(2);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.b(1, b);
                flatBufferBuilder.d(flatBufferBuilder.d());
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                return new OwnerModel(new MutableFlatBuffer(wrap, null, null, true, null));
            }

            public final int jK_() {
                return 63093205;
            }

            public final GraphQLVisitableModel m5276a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m5274a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m5275a());
                int b = flatBufferBuilder.b(m5279b());
                flatBufferBuilder.c(2);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.b(1, b);
                i();
                return flatBufferBuilder.d();
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -475564388)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: suggest_edits */
        public final class PrivacyScopeModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private IconImageModel f3792d;

            /* compiled from: suggest_edits */
            public final class Builder {
                @Nullable
                public IconImageModel f3789a;
            }

            /* compiled from: suggest_edits */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(PrivacyScopeModel.class, new Deserializer());
                }

                public Object m5280a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(PrivacyScopeParser.m5476a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object privacyScopeModel = new PrivacyScopeModel();
                    ((BaseModel) privacyScopeModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (privacyScopeModel instanceof Postprocessable) {
                        return ((Postprocessable) privacyScopeModel).a();
                    }
                    return privacyScopeModel;
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = 842551240)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: suggest_edits */
            public final class IconImageModel extends BaseModel implements GraphQLVisitableModel {
                @Nullable
                private String f3791d;

                /* compiled from: suggest_edits */
                public final class Builder {
                    @Nullable
                    public String f3790a;
                }

                /* compiled from: suggest_edits */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(IconImageModel.class, new Deserializer());
                    }

                    public Object m5281a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(IconImageParser.m5474a(jsonParser, flatBufferBuilder));
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

                /* compiled from: suggest_edits */
                public class Serializer extends JsonSerializer<IconImageModel> {
                    public final void m5282a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        IconImageModel iconImageModel = (IconImageModel) obj;
                        if (iconImageModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(iconImageModel.m5284a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            iconImageModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        IconImageParser.m5475a(iconImageModel.w_(), iconImageModel.u_(), jsonGenerator);
                    }

                    static {
                        FbSerializerProvider.a(IconImageModel.class, new Serializer());
                    }
                }

                public IconImageModel() {
                    super(1);
                }

                public IconImageModel(MutableFlatBuffer mutableFlatBuffer) {
                    super(1);
                    a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }

                @Nullable
                public final String m5286a() {
                    this.f3791d = super.a(this.f3791d, 0);
                    return this.f3791d;
                }

                public static IconImageModel m5283a(IconImageModel iconImageModel) {
                    if (iconImageModel == null) {
                        return null;
                    }
                    if (iconImageModel instanceof IconImageModel) {
                        return iconImageModel;
                    }
                    Builder builder = new Builder();
                    builder.f3790a = iconImageModel.m5286a();
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    int b = flatBufferBuilder.b(builder.f3790a);
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.b(0, b);
                    flatBufferBuilder.d(flatBufferBuilder.d());
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    return new IconImageModel(new MutableFlatBuffer(wrap, null, null, true, null));
                }

                public final int jK_() {
                    return 70760763;
                }

                public final GraphQLVisitableModel m5285a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    h();
                    i();
                    return this;
                }

                public final int m5284a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int b = flatBufferBuilder.b(m5286a());
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.b(0, b);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            /* compiled from: suggest_edits */
            public class Serializer extends JsonSerializer<PrivacyScopeModel> {
                public final void m5287a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    PrivacyScopeModel privacyScopeModel = (PrivacyScopeModel) obj;
                    if (privacyScopeModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(privacyScopeModel.m5290a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        privacyScopeModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    PrivacyScopeParser.m5477a(privacyScopeModel.w_(), privacyScopeModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(PrivacyScopeModel.class, new Serializer());
                }
            }

            @Nullable
            public final /* synthetic */ IconImageModel m5292a() {
                return m5289j();
            }

            public PrivacyScopeModel() {
                super(1);
            }

            public PrivacyScopeModel(MutableFlatBuffer mutableFlatBuffer) {
                super(1);
                a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
            }

            @Nullable
            private IconImageModel m5289j() {
                this.f3792d = (IconImageModel) super.a(this.f3792d, 0, IconImageModel.class);
                return this.f3792d;
            }

            public static PrivacyScopeModel m5288a(PrivacyScopeModel privacyScopeModel) {
                if (privacyScopeModel == null) {
                    return null;
                }
                if (privacyScopeModel instanceof PrivacyScopeModel) {
                    return privacyScopeModel;
                }
                Builder builder = new Builder();
                builder.f3789a = IconImageModel.m5283a(privacyScopeModel.m5292a());
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                int a = ModelHelper.a(flatBufferBuilder, builder.f3789a);
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.d(flatBufferBuilder.d());
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                return new PrivacyScopeModel(new MutableFlatBuffer(wrap, null, null, true, null));
            }

            public final int jK_() {
                return -476351540;
            }

            public final GraphQLVisitableModel m5291a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m5289j() != null) {
                    IconImageModel iconImageModel = (IconImageModel) graphQLModelMutatingVisitor.b(m5289j());
                    if (m5289j() != iconImageModel) {
                        graphQLVisitableModel = (PrivacyScopeModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f3792d = iconImageModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m5290a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m5289j());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, a);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: suggest_edits */
        public class Serializer extends JsonSerializer<PageMediaWithAttributionModel> {
            public final void m5293a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                PageMediaWithAttributionModel pageMediaWithAttributionModel = (PageMediaWithAttributionModel) obj;
                if (pageMediaWithAttributionModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(pageMediaWithAttributionModel.m5302a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    pageMediaWithAttributionModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                PageMediaWithAttributionParser.m5479a(pageMediaWithAttributionModel.w_(), pageMediaWithAttributionModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(PageMediaWithAttributionModel.class, new Serializer());
            }
        }

        @Nullable
        public final /* synthetic */ DefaultImageFields bc_() {
            return m5299q();
        }

        @Nullable
        public final /* synthetic */ DefaultImageFields bd_() {
            return m5298p();
        }

        @Nullable
        public final /* synthetic */ DefaultImageFields be_() {
            return m5296n();
        }

        @Nullable
        public final /* synthetic */ DefaultVect2Fields mo283c() {
            return m5295m();
        }

        @Nullable
        public final /* synthetic */ DefaultImageFields mo285g() {
            return m5297o();
        }

        @Nullable
        public final /* synthetic */ OwnerModel mo287k() {
            return m5300r();
        }

        @Nullable
        public final /* synthetic */ PrivacyScopeModel mo288l() {
            return m5301s();
        }

        public PageMediaWithAttributionModel() {
            super(10);
        }

        public PageMediaWithAttributionModel(MutableFlatBuffer mutableFlatBuffer) {
            super(10);
            a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
        }

        @Nullable
        public final GraphQLObjectType mo279b() {
            if (this.b != null && this.f3793d == null) {
                this.f3793d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
            }
            return this.f3793d;
        }

        public final long mo286j() {
            a(0, 1);
            return this.f3794e;
        }

        @Nullable
        private DefaultVect2FieldsModel m5295m() {
            this.f3795f = (DefaultVect2FieldsModel) super.a(this.f3795f, 2, DefaultVect2FieldsModel.class);
            return this.f3795f;
        }

        @Nullable
        public final String mo284d() {
            this.f3796g = super.a(this.f3796g, 3);
            return this.f3796g;
        }

        @Nullable
        private DefaultImageFieldsModel m5296n() {
            this.f3797h = (DefaultImageFieldsModel) super.a(this.f3797h, 4, DefaultImageFieldsModel.class);
            return this.f3797h;
        }

        @Nullable
        private DefaultImageFieldsModel m5297o() {
            this.f3798i = (DefaultImageFieldsModel) super.a(this.f3798i, 5, DefaultImageFieldsModel.class);
            return this.f3798i;
        }

        @Nullable
        private DefaultImageFieldsModel m5298p() {
            this.f3799j = (DefaultImageFieldsModel) super.a(this.f3799j, 6, DefaultImageFieldsModel.class);
            return this.f3799j;
        }

        @Nullable
        private DefaultImageFieldsModel m5299q() {
            this.f3800k = (DefaultImageFieldsModel) super.a(this.f3800k, 7, DefaultImageFieldsModel.class);
            return this.f3800k;
        }

        @Nullable
        private OwnerModel m5300r() {
            this.f3801l = (OwnerModel) super.a(this.f3801l, 8, OwnerModel.class);
            return this.f3801l;
        }

        @Nullable
        private PrivacyScopeModel m5301s() {
            this.f3802m = (PrivacyScopeModel) super.a(this.f3802m, 9, PrivacyScopeModel.class);
            return this.f3802m;
        }

        public static PageMediaWithAttributionModel m5294a(PageMediaWithAttribution pageMediaWithAttribution) {
            if (pageMediaWithAttribution == null) {
                return null;
            }
            if (pageMediaWithAttribution instanceof PageMediaWithAttributionModel) {
                return (PageMediaWithAttributionModel) pageMediaWithAttribution;
            }
            Builder builder = new Builder();
            builder.f3775a = pageMediaWithAttribution.mo279b();
            builder.f3776b = pageMediaWithAttribution.mo286j();
            builder.f3777c = DefaultVect2FieldsModel.a(pageMediaWithAttribution.mo283c());
            builder.f3778d = pageMediaWithAttribution.mo284d();
            builder.f3779e = DefaultImageFieldsModel.a(pageMediaWithAttribution.be_());
            builder.f3780f = DefaultImageFieldsModel.a(pageMediaWithAttribution.mo285g());
            builder.f3781g = DefaultImageFieldsModel.a(pageMediaWithAttribution.bd_());
            builder.f3782h = DefaultImageFieldsModel.a(pageMediaWithAttribution.bc_());
            builder.f3783i = OwnerModel.m5273a(pageMediaWithAttribution.mo287k());
            builder.f3784j = PrivacyScopeModel.m5288a(pageMediaWithAttribution.mo288l());
            return builder.m5269a();
        }

        @Nullable
        public final String m5304a() {
            return mo284d();
        }

        public final int jK_() {
            return 74219460;
        }

        public final GraphQLVisitableModel m5303a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            DefaultImageFieldsModel defaultImageFieldsModel;
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m5295m() != null) {
                DefaultVect2FieldsModel defaultVect2FieldsModel = (DefaultVect2FieldsModel) graphQLModelMutatingVisitor.b(m5295m());
                if (m5295m() != defaultVect2FieldsModel) {
                    graphQLVisitableModel = (PageMediaWithAttributionModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f3795f = defaultVect2FieldsModel;
                }
            }
            if (m5296n() != null) {
                defaultImageFieldsModel = (DefaultImageFieldsModel) graphQLModelMutatingVisitor.b(m5296n());
                if (m5296n() != defaultImageFieldsModel) {
                    graphQLVisitableModel = (PageMediaWithAttributionModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f3797h = defaultImageFieldsModel;
                }
            }
            if (m5297o() != null) {
                defaultImageFieldsModel = (DefaultImageFieldsModel) graphQLModelMutatingVisitor.b(m5297o());
                if (m5297o() != defaultImageFieldsModel) {
                    graphQLVisitableModel = (PageMediaWithAttributionModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f3798i = defaultImageFieldsModel;
                }
            }
            if (m5298p() != null) {
                defaultImageFieldsModel = (DefaultImageFieldsModel) graphQLModelMutatingVisitor.b(m5298p());
                if (m5298p() != defaultImageFieldsModel) {
                    graphQLVisitableModel = (PageMediaWithAttributionModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f3799j = defaultImageFieldsModel;
                }
            }
            if (m5299q() != null) {
                defaultImageFieldsModel = (DefaultImageFieldsModel) graphQLModelMutatingVisitor.b(m5299q());
                if (m5299q() != defaultImageFieldsModel) {
                    graphQLVisitableModel = (PageMediaWithAttributionModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f3800k = defaultImageFieldsModel;
                }
            }
            if (m5300r() != null) {
                OwnerModel ownerModel = (OwnerModel) graphQLModelMutatingVisitor.b(m5300r());
                if (m5300r() != ownerModel) {
                    graphQLVisitableModel = (PageMediaWithAttributionModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f3801l = ownerModel;
                }
            }
            if (m5301s() != null) {
                PrivacyScopeModel privacyScopeModel = (PrivacyScopeModel) graphQLModelMutatingVisitor.b(m5301s());
                if (m5301s() != privacyScopeModel) {
                    graphQLVisitableModel = (PageMediaWithAttributionModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f3802m = privacyScopeModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m5302a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, mo279b());
            int a2 = ModelHelper.a(flatBufferBuilder, m5295m());
            int b = flatBufferBuilder.b(mo284d());
            int a3 = ModelHelper.a(flatBufferBuilder, m5296n());
            int a4 = ModelHelper.a(flatBufferBuilder, m5297o());
            int a5 = ModelHelper.a(flatBufferBuilder, m5298p());
            int a6 = ModelHelper.a(flatBufferBuilder, m5299q());
            int a7 = ModelHelper.a(flatBufferBuilder, m5300r());
            int a8 = ModelHelper.a(flatBufferBuilder, m5301s());
            flatBufferBuilder.c(10);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.a(1, this.f3794e, 0);
            flatBufferBuilder.b(2, a2);
            flatBufferBuilder.b(3, b);
            flatBufferBuilder.b(4, a3);
            flatBufferBuilder.b(5, a4);
            flatBufferBuilder.b(6, a5);
            flatBufferBuilder.b(7, a6);
            flatBufferBuilder.b(8, a7);
            flatBufferBuilder.b(9, a8);
            i();
            return flatBufferBuilder.d();
        }

        public final void m5305a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
            super.a(mutableFlatBuffer, i, obj);
            this.f3794e = mutableFlatBuffer.a(i, 1, 0);
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 454472376)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: suggest_edits */
    public final class PhotosFaceBoxesQueryModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private List<FaceBoxInfoModel> f3803d;

        /* compiled from: suggest_edits */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(PhotosFaceBoxesQueryModel.class, new Deserializer());
            }

            public Object m5313a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(PhotosFaceBoxesQueryParser.m5480a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object photosFaceBoxesQueryModel = new PhotosFaceBoxesQueryModel();
                ((BaseModel) photosFaceBoxesQueryModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (photosFaceBoxesQueryModel instanceof Postprocessable) {
                    return ((Postprocessable) photosFaceBoxesQueryModel).a();
                }
                return photosFaceBoxesQueryModel;
            }
        }

        /* compiled from: suggest_edits */
        public class Serializer extends JsonSerializer<PhotosFaceBoxesQueryModel> {
            public final void m5314a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                PhotosFaceBoxesQueryModel photosFaceBoxesQueryModel = (PhotosFaceBoxesQueryModel) obj;
                if (photosFaceBoxesQueryModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(photosFaceBoxesQueryModel.m5315a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    photosFaceBoxesQueryModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                PhotosFaceBoxesQueryParser.m5481a(photosFaceBoxesQueryModel.w_(), photosFaceBoxesQueryModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(PhotosFaceBoxesQueryModel.class, new Serializer());
            }
        }

        public PhotosFaceBoxesQueryModel() {
            super(1);
        }

        @Nonnull
        public final ImmutableList<FaceBoxInfoModel> m5317a() {
            this.f3803d = super.a(this.f3803d, 0, FaceBoxInfoModel.class);
            return (ImmutableList) this.f3803d;
        }

        public final int jK_() {
            return 1623495656;
        }

        public final GraphQLVisitableModel m5316a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m5317a() != null) {
                Builder a = ModelHelper.a(m5317a(), graphQLModelMutatingVisitor);
                if (a != null) {
                    graphQLVisitableModel = (PhotosFaceBoxesQueryModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f3803d = a.b();
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m5315a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m5317a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 1636143856)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: suggest_edits */
    public final class PlaceInfoModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
        @Nullable
        private GraphQLObjectType f3805d;
        @Nullable
        private String f3806e;
        @Nullable
        private String f3807f;
        @Nullable
        private PlaceProfilePictureModel f3808g;

        /* compiled from: suggest_edits */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(PlaceInfoModel.class, new Deserializer());
            }

            public Object m5318a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(PlaceInfoParser.m5484a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object placeInfoModel = new PlaceInfoModel();
                ((BaseModel) placeInfoModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (placeInfoModel instanceof Postprocessable) {
                    return ((Postprocessable) placeInfoModel).a();
                }
                return placeInfoModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 842551240)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: suggest_edits */
        public final class PlaceProfilePictureModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private String f3804d;

            /* compiled from: suggest_edits */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(PlaceProfilePictureModel.class, new Deserializer());
                }

                public Object m5319a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(PlaceProfilePictureParser.m5482a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object placeProfilePictureModel = new PlaceProfilePictureModel();
                    ((BaseModel) placeProfilePictureModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (placeProfilePictureModel instanceof Postprocessable) {
                        return ((Postprocessable) placeProfilePictureModel).a();
                    }
                    return placeProfilePictureModel;
                }
            }

            /* compiled from: suggest_edits */
            public class Serializer extends JsonSerializer<PlaceProfilePictureModel> {
                public final void m5320a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    PlaceProfilePictureModel placeProfilePictureModel = (PlaceProfilePictureModel) obj;
                    if (placeProfilePictureModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(placeProfilePictureModel.m5321a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        placeProfilePictureModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    PlaceProfilePictureParser.m5483a(placeProfilePictureModel.w_(), placeProfilePictureModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(PlaceProfilePictureModel.class, new Serializer());
                }
            }

            public PlaceProfilePictureModel() {
                super(1);
            }

            @Nullable
            public final String m5323a() {
                this.f3804d = super.a(this.f3804d, 0);
                return this.f3804d;
            }

            public final int jK_() {
                return 70760763;
            }

            public final GraphQLVisitableModel m5322a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m5321a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m5323a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, b);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: suggest_edits */
        public class Serializer extends JsonSerializer<PlaceInfoModel> {
            public final void m5324a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                PlaceInfoModel placeInfoModel = (PlaceInfoModel) obj;
                if (placeInfoModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(placeInfoModel.m5327a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    placeInfoModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                PlaceInfoParser.m5485a(placeInfoModel.w_(), placeInfoModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(PlaceInfoModel.class, new Serializer());
            }
        }

        @Nullable
        public final /* synthetic */ PlaceProfilePictureModel bm_() {
            return m5326j();
        }

        public PlaceInfoModel() {
            super(4);
        }

        public final void m5330a(String str, ConsistencyTuple consistencyTuple) {
            if ("name".equals(str)) {
                consistencyTuple.a = m5334d();
                consistencyTuple.b = u_();
                consistencyTuple.c = 2;
                return;
            }
            consistencyTuple.a();
        }

        public final void m5331a(String str, Object obj, boolean z) {
            if ("name".equals(str)) {
                m5325a((String) obj);
            }
        }

        @Nullable
        public final GraphQLObjectType m5332b() {
            if (this.b != null && this.f3805d == null) {
                this.f3805d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
            }
            return this.f3805d;
        }

        @Nullable
        public final String m5333c() {
            this.f3806e = super.a(this.f3806e, 1);
            return this.f3806e;
        }

        @Nullable
        public final String m5334d() {
            this.f3807f = super.a(this.f3807f, 2);
            return this.f3807f;
        }

        private void m5325a(@Nullable String str) {
            this.f3807f = str;
            if (this.b != null && this.b.d) {
                this.b.a(this.c, 2, str);
            }
        }

        @Nullable
        private PlaceProfilePictureModel m5326j() {
            this.f3808g = (PlaceProfilePictureModel) super.a(this.f3808g, 3, PlaceProfilePictureModel.class);
            return this.f3808g;
        }

        @Nullable
        public final String m5329a() {
            return m5333c();
        }

        public final int jK_() {
            return 77195495;
        }

        public final GraphQLVisitableModel m5328a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m5326j() != null) {
                PlaceProfilePictureModel placeProfilePictureModel = (PlaceProfilePictureModel) graphQLModelMutatingVisitor.b(m5326j());
                if (m5326j() != placeProfilePictureModel) {
                    graphQLVisitableModel = (PlaceInfoModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f3808g = placeProfilePictureModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m5327a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m5332b());
            int b = flatBufferBuilder.b(m5333c());
            int b2 = flatBufferBuilder.b(m5334d());
            int a2 = ModelHelper.a(flatBufferBuilder, m5326j());
            flatBufferBuilder.c(4);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, b);
            flatBufferBuilder.b(2, b2);
            flatBufferBuilder.b(3, a2);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -106809384)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: suggest_edits */
    public final class TagInfoModel extends BaseModel implements GraphQLVisitableModel {
        private boolean f3844d;
        @Nullable
        private DefaultVect2FieldsModel f3845e;
        @Nullable
        private TaggerModel f3846f;
        private long f3847g;

        /* compiled from: suggest_edits */
        public final class Builder {
            public boolean f3836a;
            @Nullable
            public DefaultVect2FieldsModel f3837b;
            @Nullable
            public TaggerModel f3838c;
            public long f3839d;

            public final TagInfoModel m5356a() {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                int a = ModelHelper.a(flatBufferBuilder, this.f3837b);
                int a2 = ModelHelper.a(flatBufferBuilder, this.f3838c);
                flatBufferBuilder.c(4);
                flatBufferBuilder.a(0, this.f3836a);
                flatBufferBuilder.b(1, a);
                flatBufferBuilder.b(2, a2);
                flatBufferBuilder.a(3, this.f3839d, 0);
                flatBufferBuilder.d(flatBufferBuilder.d());
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                return new TagInfoModel(new MutableFlatBuffer(wrap, null, null, true, null));
            }
        }

        /* compiled from: suggest_edits */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(TagInfoModel.class, new Deserializer());
            }

            public Object m5357a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(TagInfoParser.m5494a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object tagInfoModel = new TagInfoModel();
                ((BaseModel) tagInfoModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (tagInfoModel instanceof Postprocessable) {
                    return ((Postprocessable) tagInfoModel).a();
                }
                return tagInfoModel;
            }
        }

        /* compiled from: suggest_edits */
        public class Serializer extends JsonSerializer<TagInfoModel> {
            public final void m5358a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                TagInfoModel tagInfoModel = (TagInfoModel) obj;
                if (tagInfoModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(tagInfoModel.m5370a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    tagInfoModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                TagInfoParser.m5495a(tagInfoModel.w_(), tagInfoModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(TagInfoModel.class, new Serializer());
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -341630258)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: suggest_edits */
        public final class TaggerModel extends BaseModel implements GraphQLVisitableConsistentModel {
            @Nullable
            private GraphQLObjectType f3842d;
            @Nullable
            private String f3843e;

            /* compiled from: suggest_edits */
            public final class Builder {
                @Nullable
                public GraphQLObjectType f3840a;
                @Nullable
                public String f3841b;

                public final TaggerModel m5359a() {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    int a = ModelHelper.a(flatBufferBuilder, this.f3840a);
                    int b = flatBufferBuilder.b(this.f3841b);
                    flatBufferBuilder.c(2);
                    flatBufferBuilder.b(0, a);
                    flatBufferBuilder.b(1, b);
                    flatBufferBuilder.d(flatBufferBuilder.d());
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    return new TaggerModel(new MutableFlatBuffer(wrap, null, null, true, null));
                }
            }

            /* compiled from: suggest_edits */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(TaggerModel.class, new Deserializer());
                }

                public Object m5360a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(TaggerParser.m5492a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object taggerModel = new TaggerModel();
                    ((BaseModel) taggerModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (taggerModel instanceof Postprocessable) {
                        return ((Postprocessable) taggerModel).a();
                    }
                    return taggerModel;
                }
            }

            /* compiled from: suggest_edits */
            public class Serializer extends JsonSerializer<TaggerModel> {
                public final void m5361a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    TaggerModel taggerModel = (TaggerModel) obj;
                    if (taggerModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(taggerModel.m5362a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        taggerModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    TaggerParser.m5493a(taggerModel.w_(), taggerModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(TaggerModel.class, new Serializer());
                }
            }

            public TaggerModel() {
                super(2);
            }

            public TaggerModel(MutableFlatBuffer mutableFlatBuffer) {
                super(2);
                a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
            }

            public final void m5365a(String str, ConsistencyTuple consistencyTuple) {
                consistencyTuple.a();
            }

            public final void m5366a(String str, Object obj, boolean z) {
            }

            @Nullable
            public final GraphQLObjectType m5363a() {
                if (this.b != null && this.f3842d == null) {
                    this.f3842d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
                }
                return this.f3842d;
            }

            @Nullable
            public final String m5367b() {
                this.f3843e = super.a(this.f3843e, 1);
                return this.f3843e;
            }

            public final int jK_() {
                return 63093205;
            }

            public final GraphQLVisitableModel m5364a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m5362a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m5363a());
                int b = flatBufferBuilder.b(m5367b());
                flatBufferBuilder.c(2);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.b(1, b);
                i();
                return flatBufferBuilder.d();
            }
        }

        @Nullable
        public final /* synthetic */ DefaultVect2Fields m5374b() {
            return m5368j();
        }

        @Nullable
        public final /* synthetic */ TaggerModel m5375c() {
            return m5369k();
        }

        public TagInfoModel() {
            super(4);
        }

        public TagInfoModel(MutableFlatBuffer mutableFlatBuffer) {
            super(4);
            a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
        }

        public final boolean m5373a() {
            a(0, 0);
            return this.f3844d;
        }

        @Nullable
        private DefaultVect2FieldsModel m5368j() {
            this.f3845e = (DefaultVect2FieldsModel) super.a(this.f3845e, 1, DefaultVect2FieldsModel.class);
            return this.f3845e;
        }

        @Nullable
        private TaggerModel m5369k() {
            this.f3846f = (TaggerModel) super.a(this.f3846f, 2, TaggerModel.class);
            return this.f3846f;
        }

        public final long m5376d() {
            a(0, 3);
            return this.f3847g;
        }

        public final int jK_() {
            return -1209636824;
        }

        public final GraphQLVisitableModel m5371a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m5368j() != null) {
                DefaultVect2FieldsModel defaultVect2FieldsModel = (DefaultVect2FieldsModel) graphQLModelMutatingVisitor.b(m5368j());
                if (m5368j() != defaultVect2FieldsModel) {
                    graphQLVisitableModel = (TagInfoModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f3845e = defaultVect2FieldsModel;
                }
            }
            if (m5369k() != null) {
                TaggerModel taggerModel = (TaggerModel) graphQLModelMutatingVisitor.b(m5369k());
                if (m5369k() != taggerModel) {
                    graphQLVisitableModel = (TagInfoModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f3846f = taggerModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m5370a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m5368j());
            int a2 = ModelHelper.a(flatBufferBuilder, m5369k());
            flatBufferBuilder.c(4);
            flatBufferBuilder.a(0, this.f3844d);
            flatBufferBuilder.b(1, a);
            flatBufferBuilder.b(2, a2);
            flatBufferBuilder.a(3, this.f3847g, 0);
            i();
            return flatBufferBuilder.d();
        }

        public final void m5372a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
            super.a(mutableFlatBuffer, i, obj);
            this.f3844d = mutableFlatBuffer.a(i, 0);
            this.f3847g = mutableFlatBuffer.a(i, 3, 0);
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -101232399)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: suggest_edits */
    public final class TagInfoQueryModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private List<EdgesModel> f3861d;

        /* compiled from: suggest_edits */
        public final class Builder {
            @Nullable
            public ImmutableList<EdgesModel> f3848a;

            public Builder() {
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
                r0 = this;
                r0.<init>();
                return;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.TagInfoQueryModel.Builder.<init>():void");
            }

            public final com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.TagInfoQueryModel m5377a() {
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
                r4 = 1;
                r3 = 0;
                r2 = 0;
                r0 = new com.facebook.flatbuffers.FlatBufferBuilder;
                r1 = 128; // 0x80 float:1.794E-43 double:6.32E-322;
                r0.<init>(r1);
                r1 = r6.f3848a;
                r1 = com.facebook.graphql.modelutil.ModelHelper.a(r0, r1);
                r0.c(r4);
                r0.b(r3, r1);
                r1 = r0.d();
                r0.d(r1);
                r0 = r0.e();
                r1 = java.nio.ByteBuffer.wrap(r0);
                r1.position(r3);
                r0 = new com.facebook.flatbuffers.MutableFlatBuffer;
                r3 = r2;
                r5 = r2;
                r0.<init>(r1, r2, r3, r4, r5);
                r1 = new com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels$TagInfoQueryModel;
                r1.<init>(r0);
                return r1;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.TagInfoQueryModel.Builder.a():com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels$TagInfoQueryModel");
            }
        }

        /* compiled from: suggest_edits */
        public class Deserializer extends FbJsonDeserializer {
            public Deserializer() {
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
                r0 = this;
                r0.<init>();
                return;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.TagInfoQueryModel.Deserializer.<init>():void");
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
                r0 = com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.TagInfoQueryModel.class;
                r1 = new com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels$TagInfoQueryModel$Deserializer;
                r1.<init>();
                com.facebook.common.json.GlobalAutoGenDeserializerCache.a(r0, r1);
                return;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.TagInfoQueryModel.Deserializer.<clinit>():void");
            }

            public java.lang.Object m5378a(com.fasterxml.jackson.core.JsonParser r11, com.fasterxml.jackson.databind.DeserializationContext r12) {
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
                r5 = com.facebook.photos.data.protocol.PhotosMetadataGraphQLParsers.TagInfoQueryParser.m5500a(r11, r4);
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
                r1 = new com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels$TagInfoQueryModel;
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
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.TagInfoQueryModel.Deserializer.a(com.fasterxml.jackson.core.JsonParser, com.fasterxml.jackson.databind.DeserializationContext):java.lang.Object");
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 759529456)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: suggest_edits */
        public final class EdgesModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private String f3858d;
            @Nullable
            private NodeModel f3859e;
            @Nullable
            private TagInfoModel f3860f;

            /* compiled from: suggest_edits */
            public final class Builder {
                @Nullable
                public String f3849a;
                @Nullable
                public NodeModel f3850b;
                @Nullable
                public TagInfoModel f3851c;

                public Builder() {
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
                    r0.<init>();
                    return;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.TagInfoQueryModel.EdgesModel.Builder.<init>():void");
                }

                public final com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.TagInfoQueryModel.EdgesModel m5379a() {
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
                    r8 = this;
                    r4 = 1;
                    r7 = 0;
                    r2 = 0;
                    r0 = new com.facebook.flatbuffers.FlatBufferBuilder;
                    r1 = 128; // 0x80 float:1.794E-43 double:6.32E-322;
                    r0.<init>(r1);
                    r1 = r8.f3849a;
                    r1 = r0.b(r1);
                    r3 = r8.f3850b;
                    r3 = com.facebook.graphql.modelutil.ModelHelper.a(r0, r3);
                    r5 = r8.f3851c;
                    r5 = com.facebook.graphql.modelutil.ModelHelper.a(r0, r5);
                    r6 = 3;
                    r0.c(r6);
                    r0.b(r7, r1);
                    r0.b(r4, r3);
                    r1 = 2;
                    r0.b(r1, r5);
                    r1 = r0.d();
                    r0.d(r1);
                    r0 = r0.e();
                    r1 = java.nio.ByteBuffer.wrap(r0);
                    r1.position(r7);
                    r0 = new com.facebook.flatbuffers.MutableFlatBuffer;
                    r3 = r2;
                    r5 = r2;
                    r0.<init>(r1, r2, r3, r4, r5);
                    r1 = new com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels$TagInfoQueryModel$EdgesModel;
                    r1.<init>(r0);
                    return r1;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.TagInfoQueryModel.EdgesModel.Builder.a():com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels$TagInfoQueryModel$EdgesModel");
                }
            }

            /* compiled from: suggest_edits */
            public class Deserializer extends FbJsonDeserializer {
                public Deserializer() {
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
                    r0.<init>();
                    return;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.TagInfoQueryModel.EdgesModel.Deserializer.<init>():void");
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
                    r0 = com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.TagInfoQueryModel.EdgesModel.class;
                    r1 = new com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels$TagInfoQueryModel$EdgesModel$Deserializer;
                    r1.<init>();
                    com.facebook.common.json.GlobalAutoGenDeserializerCache.a(r0, r1);
                    return;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.TagInfoQueryModel.EdgesModel.Deserializer.<clinit>():void");
                }

                public java.lang.Object m5380a(com.fasterxml.jackson.core.JsonParser r11, com.fasterxml.jackson.databind.DeserializationContext r12) {
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
                    r5 = com.facebook.photos.data.protocol.PhotosMetadataGraphQLParsers.TagInfoQueryParser.EdgesParser.m5498b(r11, r4);
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
                    r1 = new com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels$TagInfoQueryModel$EdgesModel;
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
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.TagInfoQueryModel.EdgesModel.Deserializer.a(com.fasterxml.jackson.core.JsonParser, com.fasterxml.jackson.databind.DeserializationContext):java.lang.Object");
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = 1255661007)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: suggest_edits */
            public final class NodeModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
                @Nullable
                private GraphQLObjectType f3855d;
                @Nullable
                private String f3856e;
                @Nullable
                private String f3857f;

                /* compiled from: suggest_edits */
                public final class Builder {
                    @Nullable
                    public GraphQLObjectType f3852a;
                    @Nullable
                    public String f3853b;
                    @Nullable
                    public String f3854c;

                    public Builder() {
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
                        r0 = this;
                        r0.<init>();
                        return;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.TagInfoQueryModel.EdgesModel.NodeModel.Builder.<init>():void");
                    }

                    public final com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.TagInfoQueryModel.EdgesModel.NodeModel m5381a() {
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
                        r8 = this;
                        r4 = 1;
                        r7 = 0;
                        r2 = 0;
                        r0 = new com.facebook.flatbuffers.FlatBufferBuilder;
                        r1 = 128; // 0x80 float:1.794E-43 double:6.32E-322;
                        r0.<init>(r1);
                        r1 = r8.f3852a;
                        r1 = com.facebook.graphql.modelutil.ModelHelper.a(r0, r1);
                        r3 = r8.f3853b;
                        r3 = r0.b(r3);
                        r5 = r8.f3854c;
                        r5 = r0.b(r5);
                        r6 = 3;
                        r0.c(r6);
                        r0.b(r7, r1);
                        r0.b(r4, r3);
                        r1 = 2;
                        r0.b(r1, r5);
                        r1 = r0.d();
                        r0.d(r1);
                        r0 = r0.e();
                        r1 = java.nio.ByteBuffer.wrap(r0);
                        r1.position(r7);
                        r0 = new com.facebook.flatbuffers.MutableFlatBuffer;
                        r3 = r2;
                        r5 = r2;
                        r0.<init>(r1, r2, r3, r4, r5);
                        r1 = new com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels$TagInfoQueryModel$EdgesModel$NodeModel;
                        r1.<init>(r0);
                        return r1;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.TagInfoQueryModel.EdgesModel.NodeModel.Builder.a():com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels$TagInfoQueryModel$EdgesModel$NodeModel");
                    }
                }

                /* compiled from: suggest_edits */
                public class Deserializer extends FbJsonDeserializer {
                    public Deserializer() {
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
                        r0 = this;
                        r0.<init>();
                        return;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.TagInfoQueryModel.EdgesModel.NodeModel.Deserializer.<init>():void");
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
                        r0 = com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.TagInfoQueryModel.EdgesModel.NodeModel.class;
                        r1 = new com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels$TagInfoQueryModel$EdgesModel$NodeModel$Deserializer;
                        r1.<init>();
                        com.facebook.common.json.GlobalAutoGenDeserializerCache.a(r0, r1);
                        return;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.TagInfoQueryModel.EdgesModel.NodeModel.Deserializer.<clinit>():void");
                    }

                    public java.lang.Object m5382a(com.fasterxml.jackson.core.JsonParser r11, com.fasterxml.jackson.databind.DeserializationContext r12) {
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
                        r5 = com.facebook.photos.data.protocol.PhotosMetadataGraphQLParsers.TagInfoQueryParser.EdgesParser.NodeParser.m5496a(r11, r4);
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
                        r1 = new com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels$TagInfoQueryModel$EdgesModel$NodeModel;
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
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.TagInfoQueryModel.EdgesModel.NodeModel.Deserializer.a(com.fasterxml.jackson.core.JsonParser, com.fasterxml.jackson.databind.DeserializationContext):java.lang.Object");
                    }
                }

                /* compiled from: suggest_edits */
                public class Serializer extends JsonSerializer<NodeModel> {
                    public Serializer() {
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
                        r0 = this;
                        r0.<init>();
                        return;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.TagInfoQueryModel.EdgesModel.NodeModel.Serializer.<init>():void");
                    }

                    public final void m5383a(java.lang.Object r8, com.fasterxml.jackson.core.JsonGenerator r9, com.fasterxml.jackson.databind.SerializerProvider r10) {
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
                        r8 = (com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.TagInfoQueryModel.EdgesModel.NodeModel) r8;
                        r2 = 0;
                        r0 = r8.w_();
                        if (r0 != 0) goto L_0x0035;
                    L_0x0009:
                        r0 = new com.facebook.flatbuffers.FlatBufferBuilder;
                        r1 = 128; // 0x80 float:1.794E-43 double:6.32E-322;
                        r0.<init>(r1);
                        r1 = r8.m5384a(r0);
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
                        com.facebook.photos.data.protocol.PhotosMetadataGraphQLParsers.TagInfoQueryParser.EdgesParser.NodeParser.m5497a(r0, r1, r9);
                        return;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.TagInfoQueryModel.EdgesModel.NodeModel.Serializer.a(java.lang.Object, com.fasterxml.jackson.core.JsonGenerator, com.fasterxml.jackson.databind.SerializerProvider):void");
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
                        r0 = com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.TagInfoQueryModel.EdgesModel.NodeModel.class;
                        r1 = new com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels$TagInfoQueryModel$EdgesModel$NodeModel$Serializer;
                        r1.<init>();
                        com.facebook.common.json.FbSerializerProvider.a(r0, r1);
                        return;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.TagInfoQueryModel.EdgesModel.NodeModel.Serializer.<clinit>():void");
                    }
                }

                public NodeModel() {
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
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.TagInfoQueryModel.EdgesModel.NodeModel.<init>():void");
                }

                public NodeModel(com.facebook.flatbuffers.MutableFlatBuffer r3) {
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
                    r0 = 3;
                    r2.<init>(r0);
                    r1 = r3.a;
                    r0 = r1;
                    r0 = com.facebook.flatbuffers.FlatBuffer.a(r0);
                    r2.a(r3, r0);
                    return;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.TagInfoQueryModel.EdgesModel.NodeModel.<init>(com.facebook.flatbuffers.MutableFlatBuffer):void");
                }

                public final void m5387a(java.lang.String r1, com.facebook.graphql.visitor.ConsistencyTuple r2) {
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
                    r2.a();
                    return;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.TagInfoQueryModel.EdgesModel.NodeModel.a(java.lang.String, com.facebook.graphql.visitor.ConsistencyTuple):void");
                }

                public final void m5388a(java.lang.String r1, java.lang.Object r2, boolean r3) {
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
                    return;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.TagInfoQueryModel.EdgesModel.NodeModel.a(java.lang.String, java.lang.Object, boolean):void");
                }

                @javax.annotation.Nullable
                public final com.facebook.graphql.enums.GraphQLObjectType m5389b() {
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
                    r0 = r4.b;
                    if (r0 == 0) goto L_0x0017;
                L_0x0004:
                    r0 = r4.f3855d;
                    if (r0 != 0) goto L_0x0017;
                L_0x0008:
                    r0 = r4.b;
                    r1 = r4.c;
                    r2 = 0;
                    r3 = com.facebook.graphql.enums.GraphQLObjectType.class;
                    r0 = r0.d(r1, r2, r3);
                    r0 = (com.facebook.graphql.enums.GraphQLObjectType) r0;
                    r4.f3855d = r0;
                L_0x0017:
                    r0 = r4.f3855d;
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.TagInfoQueryModel.EdgesModel.NodeModel.b():com.facebook.graphql.enums.GraphQLObjectType");
                }

                @javax.annotation.Nullable
                public final java.lang.String m5390c() {
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
                    r0 = r2.f3856e;
                    r1 = 1;
                    r0 = super.a(r0, r1);
                    r2.f3856e = r0;
                    r0 = r2.f3856e;
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.TagInfoQueryModel.EdgesModel.NodeModel.c():java.lang.String");
                }

                @javax.annotation.Nullable
                public final java.lang.String m5391d() {
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
                    r0 = r2.f3857f;
                    r1 = 2;
                    r0 = super.a(r0, r1);
                    r2.f3857f = r0;
                    r0 = r2.f3857f;
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.TagInfoQueryModel.EdgesModel.NodeModel.d():java.lang.String");
                }

                @javax.annotation.Nullable
                public final java.lang.String m5386a() {
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
                    r0 = r1.m5390c();
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.TagInfoQueryModel.EdgesModel.NodeModel.a():java.lang.String");
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
                    r0 = 1355227529; // 0x50c72189 float:2.672691E10 double:6.695713644E-315;
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.TagInfoQueryModel.EdgesModel.NodeModel.jK_():int");
                }

                public final com.facebook.graphql.visitor.GraphQLVisitableModel m5385a(com.facebook.graphql.visitor.GraphQLModelMutatingVisitor r1) {
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
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.TagInfoQueryModel.EdgesModel.NodeModel.a(com.facebook.graphql.visitor.GraphQLModelMutatingVisitor):com.facebook.graphql.visitor.GraphQLVisitableModel");
                }

                public final int m5384a(com.facebook.flatbuffers.FlatBufferBuilder r5) {
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
                    r4.h();
                    r0 = r4.m5389b();
                    r0 = com.facebook.graphql.modelutil.ModelHelper.a(r5, r0);
                    r1 = r4.m5390c();
                    r1 = r5.b(r1);
                    r2 = r4.m5391d();
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
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.TagInfoQueryModel.EdgesModel.NodeModel.a(com.facebook.flatbuffers.FlatBufferBuilder):int");
                }
            }

            /* compiled from: suggest_edits */
            public class Serializer extends JsonSerializer<EdgesModel> {
                public Serializer() {
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
                    r0.<init>();
                    return;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.TagInfoQueryModel.EdgesModel.Serializer.<init>():void");
                }

                public final void m5392a(java.lang.Object r8, com.fasterxml.jackson.core.JsonGenerator r9, com.fasterxml.jackson.databind.SerializerProvider r10) {
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
                    r8 = (com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.TagInfoQueryModel.EdgesModel) r8;
                    r2 = 0;
                    r0 = r8.w_();
                    if (r0 != 0) goto L_0x0035;
                L_0x0009:
                    r0 = new com.facebook.flatbuffers.FlatBufferBuilder;
                    r1 = 128; // 0x80 float:1.794E-43 double:6.32E-322;
                    r0.<init>(r1);
                    r1 = r8.m5394a(r0);
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
                    com.facebook.photos.data.protocol.PhotosMetadataGraphQLParsers.TagInfoQueryParser.EdgesParser.m5499b(r0, r1, r9, r10);
                    return;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.TagInfoQueryModel.EdgesModel.Serializer.a(java.lang.Object, com.fasterxml.jackson.core.JsonGenerator, com.fasterxml.jackson.databind.SerializerProvider):void");
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
                    r0 = com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.TagInfoQueryModel.EdgesModel.class;
                    r1 = new com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels$TagInfoQueryModel$EdgesModel$Serializer;
                    r1.<init>();
                    com.facebook.common.json.FbSerializerProvider.a(r0, r1);
                    return;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.TagInfoQueryModel.EdgesModel.Serializer.<clinit>():void");
                }
            }

            @javax.annotation.Nullable
            public final /* synthetic */ com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.TagInfoQueryModel.EdgesModel.NodeModel m5397b() {
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
                r0 = r1.m5399j();
                return r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.TagInfoQueryModel.EdgesModel.b():com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels$TagInfoQueryModel$EdgesModel$NodeModel");
            }

            @javax.annotation.Nullable
            public final /* synthetic */ com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.TagInfoModel m5398c() {
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
                r0 = r1.m5393k();
                return r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.TagInfoQueryModel.EdgesModel.c():com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels$TagInfoModel");
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
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.TagInfoQueryModel.EdgesModel.<init>():void");
            }

            public EdgesModel(com.facebook.flatbuffers.MutableFlatBuffer r3) {
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
                r0 = 3;
                r2.<init>(r0);
                r1 = r3.a;
                r0 = r1;
                r0 = com.facebook.flatbuffers.FlatBuffer.a(r0);
                r2.a(r3, r0);
                return;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.TagInfoQueryModel.EdgesModel.<init>(com.facebook.flatbuffers.MutableFlatBuffer):void");
            }

            @javax.annotation.Nullable
            public final java.lang.String m5396a() {
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
                r0 = r2.f3858d;
                r1 = 0;
                r0 = super.a(r0, r1);
                r2.f3858d = r0;
                r0 = r2.f3858d;
                return r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.TagInfoQueryModel.EdgesModel.a():java.lang.String");
            }

            @javax.annotation.Nullable
            public final com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.TagInfoQueryModel.EdgesModel.NodeModel m5399j() {
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
                r0 = r3.f3859e;
                r1 = 1;
                r2 = com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.TagInfoQueryModel.EdgesModel.NodeModel.class;
                r0 = super.a(r0, r1, r2);
                r0 = (com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.TagInfoQueryModel.EdgesModel.NodeModel) r0;
                r3.f3859e = r0;
                r0 = r3.f3859e;
                return r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.TagInfoQueryModel.EdgesModel.j():com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels$TagInfoQueryModel$EdgesModel$NodeModel");
            }

            @javax.annotation.Nullable
            private com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.TagInfoModel m5393k() {
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
                r0 = r3.f3860f;
                r1 = 2;
                r2 = com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.TagInfoModel.class;
                r0 = super.a(r0, r1, r2);
                r0 = (com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.TagInfoModel) r0;
                r3.f3860f = r0;
                r0 = r3.f3860f;
                return r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.TagInfoQueryModel.EdgesModel.k():com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels$TagInfoModel");
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
                r0 = 177332648; // 0xa91e1a8 float:1.4047875E-32 double:8.76139693E-316;
                return r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.TagInfoQueryModel.EdgesModel.jK_():int");
            }

            public final com.facebook.graphql.visitor.GraphQLVisitableModel m5395a(com.facebook.graphql.visitor.GraphQLModelMutatingVisitor r4) {
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
                r0 = r3.m5399j();
                if (r0 == 0) goto L_0x0022;
            L_0x000a:
                r0 = r3.m5399j();
                r0 = r4.b(r0);
                r0 = (com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.TagInfoQueryModel.EdgesModel.NodeModel) r0;
                r2 = r3.m5399j();
                if (r2 == r0) goto L_0x0022;
            L_0x001a:
                r1 = com.facebook.graphql.modelutil.ModelHelper.a(r1, r3);
                r1 = (com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.TagInfoQueryModel.EdgesModel) r1;
                r1.f3859e = r0;
            L_0x0022:
                r0 = r3.m5393k();
                if (r0 == 0) goto L_0x0040;
            L_0x0028:
                r0 = r3.m5393k();
                r0 = r4.b(r0);
                r0 = (com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.TagInfoModel) r0;
                r2 = r3.m5393k();
                if (r2 == r0) goto L_0x0040;
            L_0x0038:
                r1 = com.facebook.graphql.modelutil.ModelHelper.a(r1, r3);
                r1 = (com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.TagInfoQueryModel.EdgesModel) r1;
                r1.f3860f = r0;
            L_0x0040:
                r3.i();
                if (r1 != 0) goto L_0x0046;
            L_0x0045:
                return r3;
            L_0x0046:
                r3 = r1;
                goto L_0x0045;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.TagInfoQueryModel.EdgesModel.a(com.facebook.graphql.visitor.GraphQLModelMutatingVisitor):com.facebook.graphql.visitor.GraphQLVisitableModel");
            }

            public final int m5394a(com.facebook.flatbuffers.FlatBufferBuilder r5) {
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
                r4.h();
                r0 = r4.m5396a();
                r0 = r5.b(r0);
                r1 = r4.m5399j();
                r1 = com.facebook.graphql.modelutil.ModelHelper.a(r5, r1);
                r2 = r4.m5393k();
                r2 = com.facebook.graphql.modelutil.ModelHelper.a(r5, r2);
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
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.TagInfoQueryModel.EdgesModel.a(com.facebook.flatbuffers.FlatBufferBuilder):int");
            }
        }

        /* compiled from: suggest_edits */
        public class Serializer extends JsonSerializer<TagInfoQueryModel> {
            public Serializer() {
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
                r0 = this;
                r0.<init>();
                return;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.TagInfoQueryModel.Serializer.<init>():void");
            }

            public final void m5400a(java.lang.Object r8, com.fasterxml.jackson.core.JsonGenerator r9, com.fasterxml.jackson.databind.SerializerProvider r10) {
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
                r8 = (com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.TagInfoQueryModel) r8;
                r2 = 0;
                r0 = r8.w_();
                if (r0 != 0) goto L_0x0035;
            L_0x0009:
                r0 = new com.facebook.flatbuffers.FlatBufferBuilder;
                r1 = 128; // 0x80 float:1.794E-43 double:6.32E-322;
                r0.<init>(r1);
                r1 = r8.m5401a(r0);
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
                com.facebook.photos.data.protocol.PhotosMetadataGraphQLParsers.TagInfoQueryParser.m5501a(r0, r1, r9, r10);
                return;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.TagInfoQueryModel.Serializer.a(java.lang.Object, com.fasterxml.jackson.core.JsonGenerator, com.fasterxml.jackson.databind.SerializerProvider):void");
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
                r0 = com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.TagInfoQueryModel.class;
                r1 = new com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels$TagInfoQueryModel$Serializer;
                r1.<init>();
                com.facebook.common.json.FbSerializerProvider.a(r0, r1);
                return;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.TagInfoQueryModel.Serializer.<clinit>():void");
            }
        }

        public TagInfoQueryModel() {
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
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.TagInfoQueryModel.<init>():void");
        }

        public TagInfoQueryModel(com.facebook.flatbuffers.MutableFlatBuffer r3) {
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
            r2.<init>(r0);
            r1 = r3.a;
            r0 = r1;
            r0 = com.facebook.flatbuffers.FlatBuffer.a(r0);
            r2.a(r3, r0);
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.TagInfoQueryModel.<init>(com.facebook.flatbuffers.MutableFlatBuffer):void");
        }

        @javax.annotation.Nonnull
        public final com.google.common.collect.ImmutableList<com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.TagInfoQueryModel.EdgesModel> m5403a() {
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
            r0 = r3.f3861d;
            r1 = 0;
            r2 = com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.TagInfoQueryModel.EdgesModel.class;
            r0 = super.a(r0, r1, r2);
            r3.f3861d = r0;
            r0 = r3.f3861d;
            r0 = (com.google.common.collect.ImmutableList) r0;
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.TagInfoQueryModel.a():com.google.common.collect.ImmutableList<com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels$TagInfoQueryModel$EdgesModel>");
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
            r0 = 110958217; // 0x69d1689 float:5.908995E-35 double:5.4820643E-316;
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.TagInfoQueryModel.jK_():int");
        }

        public final com.facebook.graphql.visitor.GraphQLVisitableModel m5402a(com.facebook.graphql.visitor.GraphQLModelMutatingVisitor r3) {
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
            r0 = 0;
            r2.h();
            r1 = r2.m5403a();
            if (r1 == 0) goto L_0x0020;
        L_0x000a:
            r1 = r2.m5403a();
            r1 = com.facebook.graphql.modelutil.ModelHelper.a(r1, r3);
            if (r1 == 0) goto L_0x0020;
        L_0x0014:
            r0 = com.facebook.graphql.modelutil.ModelHelper.a(r0, r2);
            r0 = (com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.TagInfoQueryModel) r0;
            r1 = r1.b();
            r0.f3861d = r1;
        L_0x0020:
            r2.i();
            if (r0 != 0) goto L_0x0026;
        L_0x0025:
            return r2;
        L_0x0026:
            r2 = r0;
            goto L_0x0025;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.TagInfoQueryModel.a(com.facebook.graphql.visitor.GraphQLModelMutatingVisitor):com.facebook.graphql.visitor.GraphQLVisitableModel");
        }

        public final int m5401a(com.facebook.flatbuffers.FlatBufferBuilder r3) {
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
            r0 = r2.m5403a();
            r0 = com.facebook.graphql.modelutil.ModelHelper.a(r3, r0);
            r1 = 1;
            r3.c(r1);
            r1 = 0;
            r3.b(r1, r0);
            r2.i();
            r0 = r3.d();
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.TagInfoQueryModel.a(com.facebook.flatbuffers.FlatBufferBuilder):int");
        }
    }
}
