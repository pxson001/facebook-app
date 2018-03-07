package com.facebook.pages.data.graphql.cards;

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
import com.facebook.graphql.querybuilder.common.CommonGraphQL2Interfaces.DefaultVect2Fields;
import com.facebook.graphql.querybuilder.common.CommonGraphQL2Models.DefaultVect2FieldsModel;
import com.facebook.graphql.querybuilder.common.CommonGraphQLInterfaces.DefaultImageFields;
import com.facebook.graphql.querybuilder.common.CommonGraphQLModels.DefaultImageFieldsModel;
import com.facebook.graphql.visitor.ConsistencyTuple;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLPersistableNode;
import com.facebook.graphql.visitor.GraphQLVisitableConsistentModel;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.facebook.pages.data.graphql.cards.PagePhotosCardGraphQLParsers.OwnedPagePhotosQueryParser;
import com.facebook.pages.data.graphql.cards.PagePhotosCardGraphQLParsers.OwnedPagePhotosQueryParser.PostedPhotosParser;
import com.facebook.pages.data.graphql.cards.PagePhotosCardGraphQLParsers.PagePhotoWithAttributionParser;
import com.facebook.pages.data.graphql.cards.PagePhotosCardGraphQLParsers.PagePhotoWithAttributionParser.OwnerParser;
import com.facebook.pages.data.graphql.cards.PagePhotosCardGraphQLParsers.PagePhotoWithAttributionParser.PrivacyScopeParser;
import com.facebook.pages.data.graphql.cards.PagePhotosCardGraphQLParsers.PagePhotoWithAttributionParser.PrivacyScopeParser.IconImageParser;
import com.facebook.pages.data.graphql.cards.PagePhotosCardGraphQLParsers.UnownedLocalPagePhotosQueryParser;
import com.facebook.pages.data.graphql.cards.PagePhotosCardGraphQLParsers.UnownedLocalPagePhotosQueryParser.PhotosTakenHereParser;
import com.facebook.pages.data.graphql.cards.PagePhotosCardGraphQLParsers.UnownedNonLocalPagePhotosQueryParser;
import com.facebook.pages.data.graphql.cards.PagePhotosCardGraphQLParsers.UnownedNonLocalPagePhotosQueryParser.PhotosTakenOfParser;
import com.facebook.photos.data.protocol.PhotosDefaultsGraphQLInterfaces.SizeAwareMedia;
import com.facebook.photos.data.protocol.PhotosDefaultsGraphQLModels.SizeAwareMediaModel;
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

/* compiled from: contactpoint_type */
public class PagePhotosCardGraphQLModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 1328114142)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: contactpoint_type */
    public final class OwnedPagePhotosQueryModel extends BaseModel implements GraphQLVisitableConsistentModel {
        @Nullable
        private PostedPhotosModel f17021d;

        /* compiled from: contactpoint_type */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(OwnedPagePhotosQueryModel.class, new Deserializer());
            }

            public Object m20585a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = OwnedPagePhotosQueryParser.m20663a(jsonParser);
                Object ownedPagePhotosQueryModel = new OwnedPagePhotosQueryModel();
                ((BaseModel) ownedPagePhotosQueryModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (ownedPagePhotosQueryModel instanceof Postprocessable) {
                    return ((Postprocessable) ownedPagePhotosQueryModel).a();
                }
                return ownedPagePhotosQueryModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1289948363)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: contactpoint_type */
        public final class PostedPhotosModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private List<SizeAwareMediaModel> f17020d;

            /* compiled from: contactpoint_type */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(PostedPhotosModel.class, new Deserializer());
                }

                public Object m20586a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(PostedPhotosParser.m20661a(jsonParser, flatBufferBuilder));
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

            /* compiled from: contactpoint_type */
            public class Serializer extends JsonSerializer<PostedPhotosModel> {
                public final void m20587a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    PostedPhotosModel postedPhotosModel = (PostedPhotosModel) obj;
                    if (postedPhotosModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(postedPhotosModel.m20588a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        postedPhotosModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    PostedPhotosParser.m20662a(postedPhotosModel.w_(), postedPhotosModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(PostedPhotosModel.class, new Serializer());
                }
            }

            public PostedPhotosModel() {
                super(1);
            }

            @Nonnull
            public final ImmutableList<SizeAwareMediaModel> m20590a() {
                this.f17020d = super.a(this.f17020d, 0, SizeAwareMediaModel.class);
                return (ImmutableList) this.f17020d;
            }

            public final int jK_() {
                return 1367901630;
            }

            public final GraphQLVisitableModel m20589a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m20590a() != null) {
                    Builder a = ModelHelper.a(m20590a(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        graphQLVisitableModel = (PostedPhotosModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f17020d = a.b();
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m20588a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m20590a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, a);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: contactpoint_type */
        public class Serializer extends JsonSerializer<OwnedPagePhotosQueryModel> {
            public final void m20591a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                OwnedPagePhotosQueryModel ownedPagePhotosQueryModel = (OwnedPagePhotosQueryModel) obj;
                if (ownedPagePhotosQueryModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(ownedPagePhotosQueryModel.m20592a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    ownedPagePhotosQueryModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = ownedPagePhotosQueryModel.w_();
                int u_ = ownedPagePhotosQueryModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("posted_photos");
                    PostedPhotosParser.m20662a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(OwnedPagePhotosQueryModel.class, new Serializer());
            }
        }

        public OwnedPagePhotosQueryModel() {
            super(1);
        }

        public final void m20595a(String str, ConsistencyTuple consistencyTuple) {
            consistencyTuple.a();
        }

        public final void m20596a(String str, Object obj, boolean z) {
        }

        @Nullable
        public final PostedPhotosModel m20594a() {
            this.f17021d = (PostedPhotosModel) super.a(this.f17021d, 0, PostedPhotosModel.class);
            return this.f17021d;
        }

        public final int jK_() {
            return 2479791;
        }

        public final GraphQLVisitableModel m20593a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m20594a() != null) {
                PostedPhotosModel postedPhotosModel = (PostedPhotosModel) graphQLModelMutatingVisitor.b(m20594a());
                if (m20594a() != postedPhotosModel) {
                    graphQLVisitableModel = (OwnedPagePhotosQueryModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f17021d = postedPhotosModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m20592a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m20594a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 167164745)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: contactpoint_type */
    public final class PagePhotoWithAttributionModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel, SizeAwareMedia {
        @Nullable
        private GraphQLObjectType f17027d;
        private long f17028e;
        @Nullable
        private DefaultVect2FieldsModel f17029f;
        @Nullable
        private String f17030g;
        @Nullable
        private DefaultImageFieldsModel f17031h;
        @Nullable
        private DefaultImageFieldsModel f17032i;
        @Nullable
        private DefaultImageFieldsModel f17033j;
        @Nullable
        private DefaultImageFieldsModel f17034k;
        @Nullable
        private OwnerModel f17035l;
        @Nullable
        private PrivacyScopeModel f17036m;

        /* compiled from: contactpoint_type */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(PagePhotoWithAttributionModel.class, new Deserializer());
            }

            public Object m20597a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(PagePhotoWithAttributionParser.m20672b(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object pagePhotoWithAttributionModel = new PagePhotoWithAttributionModel();
                ((BaseModel) pagePhotoWithAttributionModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (pagePhotoWithAttributionModel instanceof Postprocessable) {
                    return ((Postprocessable) pagePhotoWithAttributionModel).a();
                }
                return pagePhotoWithAttributionModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -341630258)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: contactpoint_type */
        public final class OwnerModel extends BaseModel implements GraphQLVisitableConsistentModel {
            @Nullable
            private GraphQLObjectType f17022d;
            @Nullable
            private String f17023e;

            /* compiled from: contactpoint_type */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(OwnerModel.class, new Deserializer());
                }

                public Object m20598a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(OwnerParser.m20664a(jsonParser, flatBufferBuilder));
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

            /* compiled from: contactpoint_type */
            public class Serializer extends JsonSerializer<OwnerModel> {
                public final void m20599a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    OwnerModel ownerModel = (OwnerModel) obj;
                    if (ownerModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(ownerModel.m20600a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        ownerModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    OwnerParser.m20665a(ownerModel.w_(), ownerModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(OwnerModel.class, new Serializer());
                }
            }

            public OwnerModel() {
                super(2);
            }

            public final void m20603a(String str, ConsistencyTuple consistencyTuple) {
                consistencyTuple.a();
            }

            public final void m20604a(String str, Object obj, boolean z) {
            }

            @Nullable
            public final GraphQLObjectType m20601a() {
                if (this.b != null && this.f17022d == null) {
                    this.f17022d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
                }
                return this.f17022d;
            }

            @Nullable
            public final String m20605b() {
                this.f17023e = super.a(this.f17023e, 1);
                return this.f17023e;
            }

            public final int jK_() {
                return 63093205;
            }

            public final GraphQLVisitableModel m20602a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m20600a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m20601a());
                int b = flatBufferBuilder.b(m20605b());
                flatBufferBuilder.c(2);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.b(1, b);
                i();
                return flatBufferBuilder.d();
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 626137484)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: contactpoint_type */
        public final class PrivacyScopeModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private IconImageModel f17026d;

            /* compiled from: contactpoint_type */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(PrivacyScopeModel.class, new Deserializer());
                }

                public Object m20606a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(PrivacyScopeParser.m20668a(jsonParser, flatBufferBuilder));
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
            @ModelWithFlatBufferFormatHash(a = 201166953)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: contactpoint_type */
            public final class IconImageModel extends BaseModel implements GraphQLVisitableModel {
                @Nullable
                private String f17024d;
                @Nullable
                private String f17025e;

                /* compiled from: contactpoint_type */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(IconImageModel.class, new Deserializer());
                    }

                    public Object m20607a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(IconImageParser.m20666a(jsonParser, flatBufferBuilder));
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

                /* compiled from: contactpoint_type */
                public class Serializer extends JsonSerializer<IconImageModel> {
                    public final void m20608a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        IconImageModel iconImageModel = (IconImageModel) obj;
                        if (iconImageModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(iconImageModel.m20609a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            iconImageModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        IconImageParser.m20667a(iconImageModel.w_(), iconImageModel.u_(), jsonGenerator);
                    }

                    static {
                        FbSerializerProvider.a(IconImageModel.class, new Serializer());
                    }
                }

                public IconImageModel() {
                    super(2);
                }

                @Nullable
                public final String m20611a() {
                    this.f17024d = super.a(this.f17024d, 0);
                    return this.f17024d;
                }

                @Nullable
                public final String m20612b() {
                    this.f17025e = super.a(this.f17025e, 1);
                    return this.f17025e;
                }

                public final int jK_() {
                    return 70760763;
                }

                public final GraphQLVisitableModel m20610a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    h();
                    i();
                    return this;
                }

                public final int m20609a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int b = flatBufferBuilder.b(m20611a());
                    int b2 = flatBufferBuilder.b(m20612b());
                    flatBufferBuilder.c(2);
                    flatBufferBuilder.b(0, b);
                    flatBufferBuilder.b(1, b2);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            /* compiled from: contactpoint_type */
            public class Serializer extends JsonSerializer<PrivacyScopeModel> {
                public final void m20613a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    PrivacyScopeModel privacyScopeModel = (PrivacyScopeModel) obj;
                    if (privacyScopeModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(privacyScopeModel.m20615a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        privacyScopeModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    PrivacyScopeParser.m20669a(privacyScopeModel.w_(), privacyScopeModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(PrivacyScopeModel.class, new Serializer());
                }
            }

            @Nullable
            public final /* synthetic */ IconImageModel m20617a() {
                return m20614j();
            }

            public PrivacyScopeModel() {
                super(1);
            }

            @Nullable
            private IconImageModel m20614j() {
                this.f17026d = (IconImageModel) super.a(this.f17026d, 0, IconImageModel.class);
                return this.f17026d;
            }

            public final int jK_() {
                return -476351540;
            }

            public final GraphQLVisitableModel m20616a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m20614j() != null) {
                    IconImageModel iconImageModel = (IconImageModel) graphQLModelMutatingVisitor.b(m20614j());
                    if (m20614j() != iconImageModel) {
                        graphQLVisitableModel = (PrivacyScopeModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f17026d = iconImageModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m20615a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m20614j());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, a);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: contactpoint_type */
        public class Serializer extends JsonSerializer<PagePhotoWithAttributionModel> {
            public final void m20618a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                PagePhotoWithAttributionModel pagePhotoWithAttributionModel = (PagePhotoWithAttributionModel) obj;
                if (pagePhotoWithAttributionModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(pagePhotoWithAttributionModel.m20626a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    pagePhotoWithAttributionModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                PagePhotoWithAttributionParser.m20673b(pagePhotoWithAttributionModel.w_(), pagePhotoWithAttributionModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(PagePhotoWithAttributionModel.class, new Serializer());
            }
        }

        @Nullable
        public final /* synthetic */ DefaultImageFields bc_() {
            return m20623q();
        }

        @Nullable
        public final /* synthetic */ DefaultImageFields bd_() {
            return m20622p();
        }

        @Nullable
        public final /* synthetic */ DefaultImageFields be_() {
            return m20620n();
        }

        @Nullable
        public final /* synthetic */ DefaultVect2Fields m20631c() {
            return m20619m();
        }

        @Nullable
        public final /* synthetic */ DefaultImageFields m20633g() {
            return m20621o();
        }

        @Nullable
        public final /* synthetic */ OwnerModel m20635k() {
            return m20624r();
        }

        @Nullable
        public final /* synthetic */ PrivacyScopeModel m20636l() {
            return m20625s();
        }

        public PagePhotoWithAttributionModel() {
            super(10);
        }

        @Nullable
        public final GraphQLObjectType m20630b() {
            if (this.b != null && this.f17027d == null) {
                this.f17027d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
            }
            return this.f17027d;
        }

        public final long m20634j() {
            a(0, 1);
            return this.f17028e;
        }

        @Nullable
        private DefaultVect2FieldsModel m20619m() {
            this.f17029f = (DefaultVect2FieldsModel) super.a(this.f17029f, 2, DefaultVect2FieldsModel.class);
            return this.f17029f;
        }

        @Nullable
        public final String m20632d() {
            this.f17030g = super.a(this.f17030g, 3);
            return this.f17030g;
        }

        @Nullable
        private DefaultImageFieldsModel m20620n() {
            this.f17031h = (DefaultImageFieldsModel) super.a(this.f17031h, 4, DefaultImageFieldsModel.class);
            return this.f17031h;
        }

        @Nullable
        private DefaultImageFieldsModel m20621o() {
            this.f17032i = (DefaultImageFieldsModel) super.a(this.f17032i, 5, DefaultImageFieldsModel.class);
            return this.f17032i;
        }

        @Nullable
        private DefaultImageFieldsModel m20622p() {
            this.f17033j = (DefaultImageFieldsModel) super.a(this.f17033j, 6, DefaultImageFieldsModel.class);
            return this.f17033j;
        }

        @Nullable
        private DefaultImageFieldsModel m20623q() {
            this.f17034k = (DefaultImageFieldsModel) super.a(this.f17034k, 7, DefaultImageFieldsModel.class);
            return this.f17034k;
        }

        @Nullable
        private OwnerModel m20624r() {
            this.f17035l = (OwnerModel) super.a(this.f17035l, 8, OwnerModel.class);
            return this.f17035l;
        }

        @Nullable
        private PrivacyScopeModel m20625s() {
            this.f17036m = (PrivacyScopeModel) super.a(this.f17036m, 9, PrivacyScopeModel.class);
            return this.f17036m;
        }

        @Nullable
        public final String m20628a() {
            return m20632d();
        }

        public final int jK_() {
            return 77090322;
        }

        public final GraphQLVisitableModel m20627a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            DefaultImageFieldsModel defaultImageFieldsModel;
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m20619m() != null) {
                DefaultVect2FieldsModel defaultVect2FieldsModel = (DefaultVect2FieldsModel) graphQLModelMutatingVisitor.b(m20619m());
                if (m20619m() != defaultVect2FieldsModel) {
                    graphQLVisitableModel = (PagePhotoWithAttributionModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f17029f = defaultVect2FieldsModel;
                }
            }
            if (m20620n() != null) {
                defaultImageFieldsModel = (DefaultImageFieldsModel) graphQLModelMutatingVisitor.b(m20620n());
                if (m20620n() != defaultImageFieldsModel) {
                    graphQLVisitableModel = (PagePhotoWithAttributionModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f17031h = defaultImageFieldsModel;
                }
            }
            if (m20621o() != null) {
                defaultImageFieldsModel = (DefaultImageFieldsModel) graphQLModelMutatingVisitor.b(m20621o());
                if (m20621o() != defaultImageFieldsModel) {
                    graphQLVisitableModel = (PagePhotoWithAttributionModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f17032i = defaultImageFieldsModel;
                }
            }
            if (m20622p() != null) {
                defaultImageFieldsModel = (DefaultImageFieldsModel) graphQLModelMutatingVisitor.b(m20622p());
                if (m20622p() != defaultImageFieldsModel) {
                    graphQLVisitableModel = (PagePhotoWithAttributionModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f17033j = defaultImageFieldsModel;
                }
            }
            if (m20623q() != null) {
                defaultImageFieldsModel = (DefaultImageFieldsModel) graphQLModelMutatingVisitor.b(m20623q());
                if (m20623q() != defaultImageFieldsModel) {
                    graphQLVisitableModel = (PagePhotoWithAttributionModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f17034k = defaultImageFieldsModel;
                }
            }
            if (m20624r() != null) {
                OwnerModel ownerModel = (OwnerModel) graphQLModelMutatingVisitor.b(m20624r());
                if (m20624r() != ownerModel) {
                    graphQLVisitableModel = (PagePhotoWithAttributionModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f17035l = ownerModel;
                }
            }
            if (m20625s() != null) {
                PrivacyScopeModel privacyScopeModel = (PrivacyScopeModel) graphQLModelMutatingVisitor.b(m20625s());
                if (m20625s() != privacyScopeModel) {
                    graphQLVisitableModel = (PagePhotoWithAttributionModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f17036m = privacyScopeModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m20626a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m20630b());
            int a2 = ModelHelper.a(flatBufferBuilder, m20619m());
            int b = flatBufferBuilder.b(m20632d());
            int a3 = ModelHelper.a(flatBufferBuilder, m20620n());
            int a4 = ModelHelper.a(flatBufferBuilder, m20621o());
            int a5 = ModelHelper.a(flatBufferBuilder, m20622p());
            int a6 = ModelHelper.a(flatBufferBuilder, m20623q());
            int a7 = ModelHelper.a(flatBufferBuilder, m20624r());
            int a8 = ModelHelper.a(flatBufferBuilder, m20625s());
            flatBufferBuilder.c(10);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.a(1, this.f17028e, 0);
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

        public final void m20629a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
            super.a(mutableFlatBuffer, i, obj);
            this.f17028e = mutableFlatBuffer.a(i, 1, 0);
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 2010031562)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: contactpoint_type */
    public final class UnownedLocalPagePhotosQueryModel extends BaseModel implements GraphQLVisitableConsistentModel {
        @Nullable
        private PhotosTakenHereModel f17038d;

        /* compiled from: contactpoint_type */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(UnownedLocalPagePhotosQueryModel.class, new Deserializer());
            }

            public Object m20637a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = UnownedLocalPagePhotosQueryParser.m20676a(jsonParser);
                Object unownedLocalPagePhotosQueryModel = new UnownedLocalPagePhotosQueryModel();
                ((BaseModel) unownedLocalPagePhotosQueryModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (unownedLocalPagePhotosQueryModel instanceof Postprocessable) {
                    return ((Postprocessable) unownedLocalPagePhotosQueryModel).a();
                }
                return unownedLocalPagePhotosQueryModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1743377056)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: contactpoint_type */
        public final class PhotosTakenHereModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private List<PagePhotoWithAttributionModel> f17037d;

            /* compiled from: contactpoint_type */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(PhotosTakenHereModel.class, new Deserializer());
                }

                public Object m20638a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(PhotosTakenHereParser.m20674a(jsonParser, flatBufferBuilder));
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

            /* compiled from: contactpoint_type */
            public class Serializer extends JsonSerializer<PhotosTakenHereModel> {
                public final void m20639a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    PhotosTakenHereModel photosTakenHereModel = (PhotosTakenHereModel) obj;
                    if (photosTakenHereModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(photosTakenHereModel.m20640a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        photosTakenHereModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    PhotosTakenHereParser.m20675a(photosTakenHereModel.w_(), photosTakenHereModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(PhotosTakenHereModel.class, new Serializer());
                }
            }

            public PhotosTakenHereModel() {
                super(1);
            }

            @Nonnull
            public final ImmutableList<PagePhotoWithAttributionModel> m20642a() {
                this.f17037d = super.a(this.f17037d, 0, PagePhotoWithAttributionModel.class);
                return (ImmutableList) this.f17037d;
            }

            public final int jK_() {
                return -1327798988;
            }

            public final GraphQLVisitableModel m20641a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m20642a() != null) {
                    Builder a = ModelHelper.a(m20642a(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        graphQLVisitableModel = (PhotosTakenHereModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f17037d = a.b();
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m20640a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m20642a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, a);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: contactpoint_type */
        public class Serializer extends JsonSerializer<UnownedLocalPagePhotosQueryModel> {
            public final void m20643a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                UnownedLocalPagePhotosQueryModel unownedLocalPagePhotosQueryModel = (UnownedLocalPagePhotosQueryModel) obj;
                if (unownedLocalPagePhotosQueryModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(unownedLocalPagePhotosQueryModel.m20644a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    unownedLocalPagePhotosQueryModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = unownedLocalPagePhotosQueryModel.w_();
                int u_ = unownedLocalPagePhotosQueryModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("photos_taken_here");
                    PhotosTakenHereParser.m20675a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(UnownedLocalPagePhotosQueryModel.class, new Serializer());
            }
        }

        public UnownedLocalPagePhotosQueryModel() {
            super(1);
        }

        public final void m20647a(String str, ConsistencyTuple consistencyTuple) {
            consistencyTuple.a();
        }

        public final void m20648a(String str, Object obj, boolean z) {
        }

        @Nullable
        public final PhotosTakenHereModel m20646a() {
            this.f17038d = (PhotosTakenHereModel) super.a(this.f17038d, 0, PhotosTakenHereModel.class);
            return this.f17038d;
        }

        public final int jK_() {
            return 2479791;
        }

        public final GraphQLVisitableModel m20645a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m20646a() != null) {
                PhotosTakenHereModel photosTakenHereModel = (PhotosTakenHereModel) graphQLModelMutatingVisitor.b(m20646a());
                if (m20646a() != photosTakenHereModel) {
                    graphQLVisitableModel = (UnownedLocalPagePhotosQueryModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f17038d = photosTakenHereModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m20644a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m20646a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -71293118)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: contactpoint_type */
    public final class UnownedNonLocalPagePhotosQueryModel extends BaseModel implements GraphQLVisitableConsistentModel {
        @Nullable
        private PhotosTakenOfModel f17040d;

        /* compiled from: contactpoint_type */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(UnownedNonLocalPagePhotosQueryModel.class, new Deserializer());
            }

            public Object m20649a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = UnownedNonLocalPagePhotosQueryParser.m20679a(jsonParser);
                Object unownedNonLocalPagePhotosQueryModel = new UnownedNonLocalPagePhotosQueryModel();
                ((BaseModel) unownedNonLocalPagePhotosQueryModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (unownedNonLocalPagePhotosQueryModel instanceof Postprocessable) {
                    return ((Postprocessable) unownedNonLocalPagePhotosQueryModel).a();
                }
                return unownedNonLocalPagePhotosQueryModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1743377056)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: contactpoint_type */
        public final class PhotosTakenOfModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private List<PagePhotoWithAttributionModel> f17039d;

            /* compiled from: contactpoint_type */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(PhotosTakenOfModel.class, new Deserializer());
                }

                public Object m20650a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(PhotosTakenOfParser.m20677a(jsonParser, flatBufferBuilder));
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

            /* compiled from: contactpoint_type */
            public class Serializer extends JsonSerializer<PhotosTakenOfModel> {
                public final void m20651a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    PhotosTakenOfModel photosTakenOfModel = (PhotosTakenOfModel) obj;
                    if (photosTakenOfModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(photosTakenOfModel.m20652a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        photosTakenOfModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    PhotosTakenOfParser.m20678a(photosTakenOfModel.w_(), photosTakenOfModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(PhotosTakenOfModel.class, new Serializer());
                }
            }

            public PhotosTakenOfModel() {
                super(1);
            }

            @Nonnull
            public final ImmutableList<PagePhotoWithAttributionModel> m20654a() {
                this.f17039d = super.a(this.f17039d, 0, PagePhotoWithAttributionModel.class);
                return (ImmutableList) this.f17039d;
            }

            public final int jK_() {
                return -823097381;
            }

            public final GraphQLVisitableModel m20653a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m20654a() != null) {
                    Builder a = ModelHelper.a(m20654a(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        graphQLVisitableModel = (PhotosTakenOfModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f17039d = a.b();
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m20652a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m20654a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, a);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: contactpoint_type */
        public class Serializer extends JsonSerializer<UnownedNonLocalPagePhotosQueryModel> {
            public final void m20655a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                UnownedNonLocalPagePhotosQueryModel unownedNonLocalPagePhotosQueryModel = (UnownedNonLocalPagePhotosQueryModel) obj;
                if (unownedNonLocalPagePhotosQueryModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(unownedNonLocalPagePhotosQueryModel.m20656a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    unownedNonLocalPagePhotosQueryModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = unownedNonLocalPagePhotosQueryModel.w_();
                int u_ = unownedNonLocalPagePhotosQueryModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("photos_taken_of");
                    PhotosTakenOfParser.m20678a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(UnownedNonLocalPagePhotosQueryModel.class, new Serializer());
            }
        }

        public UnownedNonLocalPagePhotosQueryModel() {
            super(1);
        }

        public final void m20659a(String str, ConsistencyTuple consistencyTuple) {
            consistencyTuple.a();
        }

        public final void m20660a(String str, Object obj, boolean z) {
        }

        @Nullable
        public final PhotosTakenOfModel m20658a() {
            this.f17040d = (PhotosTakenOfModel) super.a(this.f17040d, 0, PhotosTakenOfModel.class);
            return this.f17040d;
        }

        public final int jK_() {
            return 2479791;
        }

        public final GraphQLVisitableModel m20657a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m20658a() != null) {
                PhotosTakenOfModel photosTakenOfModel = (PhotosTakenOfModel) graphQLModelMutatingVisitor.b(m20658a());
                if (m20658a() != photosTakenOfModel) {
                    graphQLVisitableModel = (UnownedNonLocalPagePhotosQueryModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f17040d = photosTakenOfModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m20656a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m20658a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }
}
