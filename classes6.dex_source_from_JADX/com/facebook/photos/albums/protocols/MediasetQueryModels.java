package com.facebook.photos.albums.protocols;

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
import com.facebook.graphql.querybuilder.common.CommonGraphQL2Interfaces.DefaultVect2Fields;
import com.facebook.graphql.querybuilder.common.CommonGraphQL2Models.DefaultPageInfoFieldsModel;
import com.facebook.graphql.querybuilder.common.CommonGraphQL2Models.DefaultVect2FieldsModel;
import com.facebook.graphql.querybuilder.common.CommonGraphQLInterfaces.DefaultImageFields;
import com.facebook.graphql.querybuilder.common.CommonGraphQLModels.DefaultImageFieldsModel;
import com.facebook.graphql.visitor.ConsistencyTuple;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLPersistableNode;
import com.facebook.graphql.visitor.GraphQLVisitableConsistentModel;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.facebook.photos.albums.protocols.MediasetQueryParsers.AlbumMediasetQueryParser;
import com.facebook.photos.albums.protocols.MediasetQueryParsers.DefaultMediaSetMediaConnectionParser;
import com.facebook.photos.albums.protocols.MediasetQueryParsers.DefaultThumbnailImageParser;
import com.facebook.photos.albums.protocols.MediasetQueryParsers.MediasetQueryParser;
import com.facebook.photos.albums.protocols.MediasetQueryParsers.PhotosTakenHereMediasetQueryParser;
import com.facebook.photos.albums.protocols.MediasetQueryParsers.PhotosTakenOfMediasetQueryParser;
import com.facebook.photos.albums.protocols.MediasetQueryParsers.PostedPhotosMediasetQueryParser;
import com.facebook.photos.albums.protocols.MediasetQueryParsers.TaggedMediasetQueryParser;
import com.facebook.photos.albums.protocols.MediasetQueryParsers.TaggedMediasetQueryParser.TaggedMediasetParser;
import com.facebook.photos.data.protocol.PhotosDefaultsGraphQLInterfaces.SizeAwareMedia;
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

/* compiled from: intro_text */
public class MediasetQueryModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 1251259040)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: intro_text */
    public final class AlbumMediasetQueryModel extends BaseModel implements GraphQLVisitableConsistentModel {
        @Nullable
        private GraphQLObjectType f12371d;
        @Nullable
        private DefaultMediaSetMediaConnectionModel f12372e;

        /* compiled from: intro_text */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(AlbumMediasetQueryModel.class, new Deserializer());
            }

            public Object m19435a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = AlbumMediasetQueryParser.m19506a(jsonParser);
                Object albumMediasetQueryModel = new AlbumMediasetQueryModel();
                ((BaseModel) albumMediasetQueryModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (albumMediasetQueryModel instanceof Postprocessable) {
                    return ((Postprocessable) albumMediasetQueryModel).a();
                }
                return albumMediasetQueryModel;
            }
        }

        /* compiled from: intro_text */
        public class Serializer extends JsonSerializer<AlbumMediasetQueryModel> {
            public final void m19436a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                AlbumMediasetQueryModel albumMediasetQueryModel = (AlbumMediasetQueryModel) obj;
                if (albumMediasetQueryModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(albumMediasetQueryModel.m19438a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    albumMediasetQueryModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = albumMediasetQueryModel.w_();
                int u_ = albumMediasetQueryModel.u_();
                jsonGenerator.f();
                if (mutableFlatBuffer.g(u_, 0) != 0) {
                    jsonGenerator.a("__type__");
                    SerializerHelpers.b(mutableFlatBuffer, u_, 0, jsonGenerator);
                }
                int g = mutableFlatBuffer.g(u_, 1);
                if (g != 0) {
                    jsonGenerator.a("media");
                    DefaultMediaSetMediaConnectionParser.m19508a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(AlbumMediasetQueryModel.class, new Serializer());
            }
        }

        public AlbumMediasetQueryModel() {
            super(2);
        }

        public final void m19441a(String str, ConsistencyTuple consistencyTuple) {
            consistencyTuple.a();
        }

        public final void m19442a(String str, Object obj, boolean z) {
        }

        @Nullable
        private GraphQLObjectType m19437j() {
            if (this.b != null && this.f12371d == null) {
                this.f12371d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
            }
            return this.f12371d;
        }

        @Nullable
        public final DefaultMediaSetMediaConnectionModel m19440a() {
            this.f12372e = (DefaultMediaSetMediaConnectionModel) super.a(this.f12372e, 1, DefaultMediaSetMediaConnectionModel.class);
            return this.f12372e;
        }

        public final int jK_() {
            return 2433570;
        }

        public final GraphQLVisitableModel m19439a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m19440a() != null) {
                DefaultMediaSetMediaConnectionModel defaultMediaSetMediaConnectionModel = (DefaultMediaSetMediaConnectionModel) graphQLModelMutatingVisitor.b(m19440a());
                if (m19440a() != defaultMediaSetMediaConnectionModel) {
                    graphQLVisitableModel = (AlbumMediasetQueryModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f12372e = defaultMediaSetMediaConnectionModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m19438a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m19437j());
            int a2 = ModelHelper.a(flatBufferBuilder, m19440a());
            flatBufferBuilder.c(2);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, a2);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -948301382)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: intro_text */
    public final class DefaultMediaSetMediaConnectionModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private List<DefaultThumbnailImageModel> f12373d;
        @Nullable
        private DefaultPageInfoFieldsModel f12374e;

        /* compiled from: intro_text */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(DefaultMediaSetMediaConnectionModel.class, new Deserializer());
            }

            public Object m19443a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(DefaultMediaSetMediaConnectionParser.m19507a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object defaultMediaSetMediaConnectionModel = new DefaultMediaSetMediaConnectionModel();
                ((BaseModel) defaultMediaSetMediaConnectionModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (defaultMediaSetMediaConnectionModel instanceof Postprocessable) {
                    return ((Postprocessable) defaultMediaSetMediaConnectionModel).a();
                }
                return defaultMediaSetMediaConnectionModel;
            }
        }

        /* compiled from: intro_text */
        public class Serializer extends JsonSerializer<DefaultMediaSetMediaConnectionModel> {
            public final void m19444a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                DefaultMediaSetMediaConnectionModel defaultMediaSetMediaConnectionModel = (DefaultMediaSetMediaConnectionModel) obj;
                if (defaultMediaSetMediaConnectionModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(defaultMediaSetMediaConnectionModel.m19446a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    defaultMediaSetMediaConnectionModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                DefaultMediaSetMediaConnectionParser.m19508a(defaultMediaSetMediaConnectionModel.w_(), defaultMediaSetMediaConnectionModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(DefaultMediaSetMediaConnectionModel.class, new Serializer());
            }
        }

        @Nullable
        public final /* synthetic */ DefaultPageInfoFields m19449b() {
            return m19445j();
        }

        public DefaultMediaSetMediaConnectionModel() {
            super(2);
        }

        @Nonnull
        public final ImmutableList<DefaultThumbnailImageModel> m19448a() {
            this.f12373d = super.a(this.f12373d, 0, DefaultThumbnailImageModel.class);
            return (ImmutableList) this.f12373d;
        }

        @Nullable
        private DefaultPageInfoFieldsModel m19445j() {
            this.f12374e = (DefaultPageInfoFieldsModel) super.a(this.f12374e, 1, DefaultPageInfoFieldsModel.class);
            return this.f12374e;
        }

        public final int jK_() {
            return 747633668;
        }

        public final GraphQLVisitableModel m19447a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel;
            DefaultPageInfoFieldsModel defaultPageInfoFieldsModel;
            h();
            if (m19448a() != null) {
                Builder a = ModelHelper.a(m19448a(), graphQLModelMutatingVisitor);
                if (a != null) {
                    DefaultMediaSetMediaConnectionModel defaultMediaSetMediaConnectionModel = (DefaultMediaSetMediaConnectionModel) ModelHelper.a(null, this);
                    defaultMediaSetMediaConnectionModel.f12373d = a.b();
                    graphQLVisitableModel = defaultMediaSetMediaConnectionModel;
                    if (m19445j() != null) {
                        defaultPageInfoFieldsModel = (DefaultPageInfoFieldsModel) graphQLModelMutatingVisitor.b(m19445j());
                        if (m19445j() != defaultPageInfoFieldsModel) {
                            graphQLVisitableModel = (DefaultMediaSetMediaConnectionModel) ModelHelper.a(graphQLVisitableModel, this);
                            graphQLVisitableModel.f12374e = defaultPageInfoFieldsModel;
                        }
                    }
                    i();
                    return graphQLVisitableModel != null ? this : graphQLVisitableModel;
                }
            }
            graphQLVisitableModel = null;
            if (m19445j() != null) {
                defaultPageInfoFieldsModel = (DefaultPageInfoFieldsModel) graphQLModelMutatingVisitor.b(m19445j());
                if (m19445j() != defaultPageInfoFieldsModel) {
                    graphQLVisitableModel = (DefaultMediaSetMediaConnectionModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f12374e = defaultPageInfoFieldsModel;
                }
            }
            i();
            if (graphQLVisitableModel != null) {
            }
        }

        public final int m19446a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m19448a());
            int a2 = ModelHelper.a(flatBufferBuilder, m19445j());
            flatBufferBuilder.c(2);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, a2);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -1166041057)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: intro_text */
    public final class DefaultThumbnailImageModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel, SizeAwareMedia {
        @Nullable
        private GraphQLObjectType f12375d;
        @Nullable
        private DefaultVect2FieldsModel f12376e;
        @Nullable
        private String f12377f;
        @Nullable
        private DefaultImageFieldsModel f12378g;
        @Nullable
        private DefaultImageFieldsModel f12379h;
        @Nullable
        private DefaultImageFieldsModel f12380i;
        @Nullable
        private DefaultImageFieldsModel f12381j;
        @Nullable
        private DefaultImageFieldsModel f12382k;

        /* compiled from: intro_text */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(DefaultThumbnailImageModel.class, new Deserializer());
            }

            public Object m19450a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(DefaultThumbnailImageParser.m19509b(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object defaultThumbnailImageModel = new DefaultThumbnailImageModel();
                ((BaseModel) defaultThumbnailImageModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (defaultThumbnailImageModel instanceof Postprocessable) {
                    return ((Postprocessable) defaultThumbnailImageModel).a();
                }
                return defaultThumbnailImageModel;
            }
        }

        /* compiled from: intro_text */
        public class Serializer extends JsonSerializer<DefaultThumbnailImageModel> {
            public final void m19451a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                DefaultThumbnailImageModel defaultThumbnailImageModel = (DefaultThumbnailImageModel) obj;
                if (defaultThumbnailImageModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(defaultThumbnailImageModel.m19458a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    defaultThumbnailImageModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                DefaultThumbnailImageParser.m19510b(defaultThumbnailImageModel.w_(), defaultThumbnailImageModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(DefaultThumbnailImageModel.class, new Serializer());
            }
        }

        @Nullable
        public final /* synthetic */ DefaultImageFields bc_() {
            return m19456o();
        }

        @Nullable
        public final /* synthetic */ DefaultImageFields bd_() {
            return m19455n();
        }

        @Nullable
        public final /* synthetic */ DefaultImageFields be_() {
            return m19453l();
        }

        @Nullable
        public final /* synthetic */ DefaultVect2Fields m19462c() {
            return m19452k();
        }

        @Nullable
        public final /* synthetic */ DefaultImageFields m19464g() {
            return m19454m();
        }

        @Nullable
        public final /* synthetic */ DefaultImageFields m19465j() {
            return m19457p();
        }

        public DefaultThumbnailImageModel() {
            super(8);
        }

        @Nullable
        public final GraphQLObjectType m19461b() {
            if (this.b != null && this.f12375d == null) {
                this.f12375d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
            }
            return this.f12375d;
        }

        @Nullable
        private DefaultVect2FieldsModel m19452k() {
            this.f12376e = (DefaultVect2FieldsModel) super.a(this.f12376e, 1, DefaultVect2FieldsModel.class);
            return this.f12376e;
        }

        @Nullable
        public final String m19463d() {
            this.f12377f = super.a(this.f12377f, 2);
            return this.f12377f;
        }

        @Nullable
        private DefaultImageFieldsModel m19453l() {
            this.f12378g = (DefaultImageFieldsModel) super.a(this.f12378g, 3, DefaultImageFieldsModel.class);
            return this.f12378g;
        }

        @Nullable
        private DefaultImageFieldsModel m19454m() {
            this.f12379h = (DefaultImageFieldsModel) super.a(this.f12379h, 4, DefaultImageFieldsModel.class);
            return this.f12379h;
        }

        @Nullable
        private DefaultImageFieldsModel m19455n() {
            this.f12380i = (DefaultImageFieldsModel) super.a(this.f12380i, 5, DefaultImageFieldsModel.class);
            return this.f12380i;
        }

        @Nullable
        private DefaultImageFieldsModel m19456o() {
            this.f12381j = (DefaultImageFieldsModel) super.a(this.f12381j, 6, DefaultImageFieldsModel.class);
            return this.f12381j;
        }

        @Nullable
        private DefaultImageFieldsModel m19457p() {
            this.f12382k = (DefaultImageFieldsModel) super.a(this.f12382k, 7, DefaultImageFieldsModel.class);
            return this.f12382k;
        }

        @Nullable
        public final String m19460a() {
            return m19463d();
        }

        public final int jK_() {
            return 74219460;
        }

        public final GraphQLVisitableModel m19459a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            DefaultImageFieldsModel defaultImageFieldsModel;
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m19452k() != null) {
                DefaultVect2FieldsModel defaultVect2FieldsModel = (DefaultVect2FieldsModel) graphQLModelMutatingVisitor.b(m19452k());
                if (m19452k() != defaultVect2FieldsModel) {
                    graphQLVisitableModel = (DefaultThumbnailImageModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f12376e = defaultVect2FieldsModel;
                }
            }
            if (m19453l() != null) {
                defaultImageFieldsModel = (DefaultImageFieldsModel) graphQLModelMutatingVisitor.b(m19453l());
                if (m19453l() != defaultImageFieldsModel) {
                    graphQLVisitableModel = (DefaultThumbnailImageModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f12378g = defaultImageFieldsModel;
                }
            }
            if (m19454m() != null) {
                defaultImageFieldsModel = (DefaultImageFieldsModel) graphQLModelMutatingVisitor.b(m19454m());
                if (m19454m() != defaultImageFieldsModel) {
                    graphQLVisitableModel = (DefaultThumbnailImageModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f12379h = defaultImageFieldsModel;
                }
            }
            if (m19455n() != null) {
                defaultImageFieldsModel = (DefaultImageFieldsModel) graphQLModelMutatingVisitor.b(m19455n());
                if (m19455n() != defaultImageFieldsModel) {
                    graphQLVisitableModel = (DefaultThumbnailImageModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f12380i = defaultImageFieldsModel;
                }
            }
            if (m19456o() != null) {
                defaultImageFieldsModel = (DefaultImageFieldsModel) graphQLModelMutatingVisitor.b(m19456o());
                if (m19456o() != defaultImageFieldsModel) {
                    graphQLVisitableModel = (DefaultThumbnailImageModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f12381j = defaultImageFieldsModel;
                }
            }
            if (m19457p() != null) {
                defaultImageFieldsModel = (DefaultImageFieldsModel) graphQLModelMutatingVisitor.b(m19457p());
                if (m19457p() != defaultImageFieldsModel) {
                    graphQLVisitableModel = (DefaultThumbnailImageModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f12382k = defaultImageFieldsModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m19458a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m19461b());
            int a2 = ModelHelper.a(flatBufferBuilder, m19452k());
            int b = flatBufferBuilder.b(m19463d());
            int a3 = ModelHelper.a(flatBufferBuilder, m19453l());
            int a4 = ModelHelper.a(flatBufferBuilder, m19454m());
            int a5 = ModelHelper.a(flatBufferBuilder, m19455n());
            int a6 = ModelHelper.a(flatBufferBuilder, m19456o());
            int a7 = ModelHelper.a(flatBufferBuilder, m19457p());
            flatBufferBuilder.c(8);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, a2);
            flatBufferBuilder.b(2, b);
            flatBufferBuilder.b(3, a3);
            flatBufferBuilder.b(4, a4);
            flatBufferBuilder.b(5, a5);
            flatBufferBuilder.b(6, a6);
            flatBufferBuilder.b(7, a7);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 1251259040)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: intro_text */
    public final class MediasetQueryModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private GraphQLObjectType f12383d;
        @Nullable
        private DefaultMediaSetMediaConnectionModel f12384e;

        /* compiled from: intro_text */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(MediasetQueryModel.class, new Deserializer());
            }

            public Object m19466a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = MediasetQueryParser.m19511a(jsonParser);
                Object mediasetQueryModel = new MediasetQueryModel();
                ((BaseModel) mediasetQueryModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (mediasetQueryModel instanceof Postprocessable) {
                    return ((Postprocessable) mediasetQueryModel).a();
                }
                return mediasetQueryModel;
            }
        }

        /* compiled from: intro_text */
        public class Serializer extends JsonSerializer<MediasetQueryModel> {
            public final void m19467a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                MediasetQueryModel mediasetQueryModel = (MediasetQueryModel) obj;
                if (mediasetQueryModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(mediasetQueryModel.m19469a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mediasetQueryModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = mediasetQueryModel.w_();
                int u_ = mediasetQueryModel.u_();
                jsonGenerator.f();
                if (mutableFlatBuffer.g(u_, 0) != 0) {
                    jsonGenerator.a("__type__");
                    SerializerHelpers.b(mutableFlatBuffer, u_, 0, jsonGenerator);
                }
                int g = mutableFlatBuffer.g(u_, 1);
                if (g != 0) {
                    jsonGenerator.a("media");
                    DefaultMediaSetMediaConnectionParser.m19508a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(MediasetQueryModel.class, new Serializer());
            }
        }

        public MediasetQueryModel() {
            super(2);
        }

        @Nullable
        private GraphQLObjectType m19468j() {
            if (this.b != null && this.f12383d == null) {
                this.f12383d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
            }
            return this.f12383d;
        }

        @Nullable
        public final DefaultMediaSetMediaConnectionModel m19471a() {
            this.f12384e = (DefaultMediaSetMediaConnectionModel) super.a(this.f12384e, 1, DefaultMediaSetMediaConnectionModel.class);
            return this.f12384e;
        }

        public final int jK_() {
            return -836141570;
        }

        public final GraphQLVisitableModel m19470a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m19471a() != null) {
                DefaultMediaSetMediaConnectionModel defaultMediaSetMediaConnectionModel = (DefaultMediaSetMediaConnectionModel) graphQLModelMutatingVisitor.b(m19471a());
                if (m19471a() != defaultMediaSetMediaConnectionModel) {
                    graphQLVisitableModel = (MediasetQueryModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f12384e = defaultMediaSetMediaConnectionModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m19469a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m19468j());
            int a2 = ModelHelper.a(flatBufferBuilder, m19471a());
            flatBufferBuilder.c(2);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, a2);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 1581469506)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: intro_text */
    public final class PhotosTakenHereMediasetQueryModel extends BaseModel implements GraphQLVisitableConsistentModel {
        @Nullable
        private DefaultMediaSetMediaConnectionModel f12385d;

        /* compiled from: intro_text */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(PhotosTakenHereMediasetQueryModel.class, new Deserializer());
            }

            public Object m19472a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = PhotosTakenHereMediasetQueryParser.m19512a(jsonParser);
                Object photosTakenHereMediasetQueryModel = new PhotosTakenHereMediasetQueryModel();
                ((BaseModel) photosTakenHereMediasetQueryModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (photosTakenHereMediasetQueryModel instanceof Postprocessable) {
                    return ((Postprocessable) photosTakenHereMediasetQueryModel).a();
                }
                return photosTakenHereMediasetQueryModel;
            }
        }

        /* compiled from: intro_text */
        public class Serializer extends JsonSerializer<PhotosTakenHereMediasetQueryModel> {
            public final void m19473a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                PhotosTakenHereMediasetQueryModel photosTakenHereMediasetQueryModel = (PhotosTakenHereMediasetQueryModel) obj;
                if (photosTakenHereMediasetQueryModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(photosTakenHereMediasetQueryModel.m19474a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    photosTakenHereMediasetQueryModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = photosTakenHereMediasetQueryModel.w_();
                int u_ = photosTakenHereMediasetQueryModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("photos_taken_here");
                    DefaultMediaSetMediaConnectionParser.m19508a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(PhotosTakenHereMediasetQueryModel.class, new Serializer());
            }
        }

        public PhotosTakenHereMediasetQueryModel() {
            super(1);
        }

        public final void m19477a(String str, ConsistencyTuple consistencyTuple) {
            consistencyTuple.a();
        }

        public final void m19478a(String str, Object obj, boolean z) {
        }

        @Nullable
        public final DefaultMediaSetMediaConnectionModel m19476a() {
            this.f12385d = (DefaultMediaSetMediaConnectionModel) super.a(this.f12385d, 0, DefaultMediaSetMediaConnectionModel.class);
            return this.f12385d;
        }

        public final int jK_() {
            return 2479791;
        }

        public final GraphQLVisitableModel m19475a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m19476a() != null) {
                DefaultMediaSetMediaConnectionModel defaultMediaSetMediaConnectionModel = (DefaultMediaSetMediaConnectionModel) graphQLModelMutatingVisitor.b(m19476a());
                if (m19476a() != defaultMediaSetMediaConnectionModel) {
                    graphQLVisitableModel = (PhotosTakenHereMediasetQueryModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f12385d = defaultMediaSetMediaConnectionModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m19474a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m19476a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -1812468837)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: intro_text */
    public final class PhotosTakenOfMediasetQueryModel extends BaseModel implements GraphQLVisitableConsistentModel {
        @Nullable
        private DefaultMediaSetMediaConnectionModel f12386d;

        /* compiled from: intro_text */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(PhotosTakenOfMediasetQueryModel.class, new Deserializer());
            }

            public Object m19479a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = PhotosTakenOfMediasetQueryParser.m19513a(jsonParser);
                Object photosTakenOfMediasetQueryModel = new PhotosTakenOfMediasetQueryModel();
                ((BaseModel) photosTakenOfMediasetQueryModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (photosTakenOfMediasetQueryModel instanceof Postprocessable) {
                    return ((Postprocessable) photosTakenOfMediasetQueryModel).a();
                }
                return photosTakenOfMediasetQueryModel;
            }
        }

        /* compiled from: intro_text */
        public class Serializer extends JsonSerializer<PhotosTakenOfMediasetQueryModel> {
            public final void m19480a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                PhotosTakenOfMediasetQueryModel photosTakenOfMediasetQueryModel = (PhotosTakenOfMediasetQueryModel) obj;
                if (photosTakenOfMediasetQueryModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(photosTakenOfMediasetQueryModel.m19481a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    photosTakenOfMediasetQueryModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = photosTakenOfMediasetQueryModel.w_();
                int u_ = photosTakenOfMediasetQueryModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("photos_taken_of");
                    DefaultMediaSetMediaConnectionParser.m19508a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(PhotosTakenOfMediasetQueryModel.class, new Serializer());
            }
        }

        public PhotosTakenOfMediasetQueryModel() {
            super(1);
        }

        public final void m19484a(String str, ConsistencyTuple consistencyTuple) {
            consistencyTuple.a();
        }

        public final void m19485a(String str, Object obj, boolean z) {
        }

        @Nullable
        public final DefaultMediaSetMediaConnectionModel m19483a() {
            this.f12386d = (DefaultMediaSetMediaConnectionModel) super.a(this.f12386d, 0, DefaultMediaSetMediaConnectionModel.class);
            return this.f12386d;
        }

        public final int jK_() {
            return 2479791;
        }

        public final GraphQLVisitableModel m19482a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m19483a() != null) {
                DefaultMediaSetMediaConnectionModel defaultMediaSetMediaConnectionModel = (DefaultMediaSetMediaConnectionModel) graphQLModelMutatingVisitor.b(m19483a());
                if (m19483a() != defaultMediaSetMediaConnectionModel) {
                    graphQLVisitableModel = (PhotosTakenOfMediasetQueryModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f12386d = defaultMediaSetMediaConnectionModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m19481a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m19483a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -1536613255)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: intro_text */
    public final class PostedPhotosMediasetQueryModel extends BaseModel implements GraphQLVisitableConsistentModel {
        @Nullable
        private DefaultMediaSetMediaConnectionModel f12387d;

        /* compiled from: intro_text */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(PostedPhotosMediasetQueryModel.class, new Deserializer());
            }

            public Object m19486a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = PostedPhotosMediasetQueryParser.m19514a(jsonParser);
                Object postedPhotosMediasetQueryModel = new PostedPhotosMediasetQueryModel();
                ((BaseModel) postedPhotosMediasetQueryModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (postedPhotosMediasetQueryModel instanceof Postprocessable) {
                    return ((Postprocessable) postedPhotosMediasetQueryModel).a();
                }
                return postedPhotosMediasetQueryModel;
            }
        }

        /* compiled from: intro_text */
        public class Serializer extends JsonSerializer<PostedPhotosMediasetQueryModel> {
            public final void m19487a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                PostedPhotosMediasetQueryModel postedPhotosMediasetQueryModel = (PostedPhotosMediasetQueryModel) obj;
                if (postedPhotosMediasetQueryModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(postedPhotosMediasetQueryModel.m19488a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    postedPhotosMediasetQueryModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = postedPhotosMediasetQueryModel.w_();
                int u_ = postedPhotosMediasetQueryModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("posted_photos");
                    DefaultMediaSetMediaConnectionParser.m19508a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(PostedPhotosMediasetQueryModel.class, new Serializer());
            }
        }

        public PostedPhotosMediasetQueryModel() {
            super(1);
        }

        public final void m19491a(String str, ConsistencyTuple consistencyTuple) {
            consistencyTuple.a();
        }

        public final void m19492a(String str, Object obj, boolean z) {
        }

        @Nullable
        public final DefaultMediaSetMediaConnectionModel m19490a() {
            this.f12387d = (DefaultMediaSetMediaConnectionModel) super.a(this.f12387d, 0, DefaultMediaSetMediaConnectionModel.class);
            return this.f12387d;
        }

        public final int jK_() {
            return 2479791;
        }

        public final GraphQLVisitableModel m19489a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m19490a() != null) {
                DefaultMediaSetMediaConnectionModel defaultMediaSetMediaConnectionModel = (DefaultMediaSetMediaConnectionModel) graphQLModelMutatingVisitor.b(m19490a());
                if (m19490a() != defaultMediaSetMediaConnectionModel) {
                    graphQLVisitableModel = (PostedPhotosMediasetQueryModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f12387d = defaultMediaSetMediaConnectionModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m19488a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m19490a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 552278240)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: intro_text */
    public final class TaggedMediasetQueryModel extends BaseModel implements GraphQLVisitableConsistentModel {
        @Nullable
        private GraphQLObjectType f12389d;
        @Nullable
        private TaggedMediasetModel f12390e;

        /* compiled from: intro_text */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(TaggedMediasetQueryModel.class, new Deserializer());
            }

            public Object m19493a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = TaggedMediasetQueryParser.m19517a(jsonParser);
                Object taggedMediasetQueryModel = new TaggedMediasetQueryModel();
                ((BaseModel) taggedMediasetQueryModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (taggedMediasetQueryModel instanceof Postprocessable) {
                    return ((Postprocessable) taggedMediasetQueryModel).a();
                }
                return taggedMediasetQueryModel;
            }
        }

        /* compiled from: intro_text */
        public class Serializer extends JsonSerializer<TaggedMediasetQueryModel> {
            public final void m19494a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                TaggedMediasetQueryModel taggedMediasetQueryModel = (TaggedMediasetQueryModel) obj;
                if (taggedMediasetQueryModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(taggedMediasetQueryModel.m19501a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    taggedMediasetQueryModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = taggedMediasetQueryModel.w_();
                int u_ = taggedMediasetQueryModel.u_();
                jsonGenerator.f();
                if (mutableFlatBuffer.g(u_, 0) != 0) {
                    jsonGenerator.a("__type__");
                    SerializerHelpers.b(mutableFlatBuffer, u_, 0, jsonGenerator);
                }
                int g = mutableFlatBuffer.g(u_, 1);
                if (g != 0) {
                    jsonGenerator.a("tagged_mediaset");
                    TaggedMediasetParser.m19516a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(TaggedMediasetQueryModel.class, new Serializer());
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 1116771433)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: intro_text */
        public final class TaggedMediasetModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private DefaultMediaSetMediaConnectionModel f12388d;

            /* compiled from: intro_text */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(TaggedMediasetModel.class, new Deserializer());
                }

                public Object m19495a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(TaggedMediasetParser.m19515a(jsonParser, flatBufferBuilder));
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

            /* compiled from: intro_text */
            public class Serializer extends JsonSerializer<TaggedMediasetModel> {
                public final void m19496a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    TaggedMediasetModel taggedMediasetModel = (TaggedMediasetModel) obj;
                    if (taggedMediasetModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(taggedMediasetModel.m19497a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        taggedMediasetModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    TaggedMediasetParser.m19516a(taggedMediasetModel.w_(), taggedMediasetModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(TaggedMediasetModel.class, new Serializer());
                }
            }

            public TaggedMediasetModel() {
                super(1);
            }

            @Nullable
            public final DefaultMediaSetMediaConnectionModel m19499a() {
                this.f12388d = (DefaultMediaSetMediaConnectionModel) super.a(this.f12388d, 0, DefaultMediaSetMediaConnectionModel.class);
                return this.f12388d;
            }

            public final int jK_() {
                return 685632024;
            }

            public final GraphQLVisitableModel m19498a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m19499a() != null) {
                    DefaultMediaSetMediaConnectionModel defaultMediaSetMediaConnectionModel = (DefaultMediaSetMediaConnectionModel) graphQLModelMutatingVisitor.b(m19499a());
                    if (m19499a() != defaultMediaSetMediaConnectionModel) {
                        graphQLVisitableModel = (TaggedMediasetModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f12388d = defaultMediaSetMediaConnectionModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m19497a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m19499a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, a);
                i();
                return flatBufferBuilder.d();
            }
        }

        public TaggedMediasetQueryModel() {
            super(2);
        }

        public final void m19504a(String str, ConsistencyTuple consistencyTuple) {
            consistencyTuple.a();
        }

        public final void m19505a(String str, Object obj, boolean z) {
        }

        @Nullable
        private GraphQLObjectType m19500j() {
            if (this.b != null && this.f12389d == null) {
                this.f12389d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
            }
            return this.f12389d;
        }

        @Nullable
        public final TaggedMediasetModel m19503a() {
            this.f12390e = (TaggedMediasetModel) super.a(this.f12390e, 1, TaggedMediasetModel.class);
            return this.f12390e;
        }

        public final int jK_() {
            return 2433570;
        }

        public final GraphQLVisitableModel m19502a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m19503a() != null) {
                TaggedMediasetModel taggedMediasetModel = (TaggedMediasetModel) graphQLModelMutatingVisitor.b(m19503a());
                if (m19503a() != taggedMediasetModel) {
                    graphQLVisitableModel = (TaggedMediasetQueryModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f12390e = taggedMediasetModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m19501a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m19500j());
            int a2 = ModelHelper.a(flatBufferBuilder, m19503a());
            flatBufferBuilder.c(2);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, a2);
            i();
            return flatBufferBuilder.d();
        }
    }
}
