package com.facebook.localcontent.protocol.graphql;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbSerializerProvider;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.FragmentModelWithoutBridge;
import com.facebook.flatbuffers.ModelWithFlatBufferFormatHash;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.querybuilder.common.CommonGraphQL2Interfaces.DefaultPageInfoFields;
import com.facebook.graphql.querybuilder.common.CommonGraphQL2Models.DefaultPageInfoFieldsModel;
import com.facebook.graphql.querybuilder.common.CommonGraphQLInterfaces.DefaultImageFields;
import com.facebook.graphql.querybuilder.common.CommonGraphQLModels.DefaultImageFieldsModel;
import com.facebook.graphql.visitor.ConsistencyTuple;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLPersistableNode;
import com.facebook.graphql.visitor.GraphQLVisitableConsistentModel;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.facebook.localcontent.protocol.graphql.StructuredMenuGraphQLParsers.AvailableMenusQueryParser;
import com.facebook.localcontent.protocol.graphql.StructuredMenuGraphQLParsers.AvailableMenusQueryParser.PageProductListsParser;
import com.facebook.localcontent.protocol.graphql.StructuredMenuGraphQLParsers.AvailableMenusQueryParser.PageProductListsParser.NodesParser;
import com.facebook.localcontent.protocol.graphql.StructuredMenuGraphQLParsers.PhotosQueryParser;
import com.facebook.localcontent.protocol.graphql.StructuredMenuGraphQLParsers.PhotosQueryParser.PhotosByCategoryParser;
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

/* compiled from: keywords_groups(%s) */
public class StructuredMenuGraphQLModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -1926776006)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: keywords_groups(%s) */
    public final class AvailableMenusQueryModel extends BaseModel implements GraphQLVisitableConsistentModel {
        @Nullable
        private PageProductListsModel f11816d;

        /* compiled from: keywords_groups(%s) */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(AvailableMenusQueryModel.class, new Deserializer());
            }

            public Object m18711a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = AvailableMenusQueryParser.m18758a(jsonParser);
                Object availableMenusQueryModel = new AvailableMenusQueryModel();
                ((BaseModel) availableMenusQueryModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (availableMenusQueryModel instanceof Postprocessable) {
                    return ((Postprocessable) availableMenusQueryModel).a();
                }
                return availableMenusQueryModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -129216933)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: keywords_groups(%s) */
        public final class PageProductListsModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private List<NodesModel> f11815d;

            /* compiled from: keywords_groups(%s) */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(PageProductListsModel.class, new Deserializer());
                }

                public Object m18712a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(PageProductListsParser.m18756a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object pageProductListsModel = new PageProductListsModel();
                    ((BaseModel) pageProductListsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (pageProductListsModel instanceof Postprocessable) {
                        return ((Postprocessable) pageProductListsModel).a();
                    }
                    return pageProductListsModel;
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = -1185712657)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: keywords_groups(%s) */
            public final class NodesModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel {
                @Nullable
                private String f11813d;
                @Nullable
                private String f11814e;

                /* compiled from: keywords_groups(%s) */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(NodesModel.class, new Deserializer());
                    }

                    public Object m18713a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(NodesParser.m18755b(jsonParser, flatBufferBuilder));
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

                /* compiled from: keywords_groups(%s) */
                public class Serializer extends JsonSerializer<NodesModel> {
                    public final void m18714a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        NodesModel nodesModel = (NodesModel) obj;
                        if (nodesModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(nodesModel.m18715a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            nodesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        NodesParser.m18754a(nodesModel.w_(), nodesModel.u_(), jsonGenerator);
                    }

                    static {
                        FbSerializerProvider.a(NodesModel.class, new Serializer());
                    }
                }

                public NodesModel() {
                    super(2);
                }

                @Nullable
                public final String m18718b() {
                    this.f11813d = super.a(this.f11813d, 0);
                    return this.f11813d;
                }

                @Nullable
                public final String m18719c() {
                    this.f11814e = super.a(this.f11814e, 1);
                    return this.f11814e;
                }

                @Nullable
                public final String m18717a() {
                    return m18718b();
                }

                public final int jK_() {
                    return -1276772354;
                }

                public final GraphQLVisitableModel m18716a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    h();
                    i();
                    return this;
                }

                public final int m18715a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int b = flatBufferBuilder.b(m18718b());
                    int b2 = flatBufferBuilder.b(m18719c());
                    flatBufferBuilder.c(2);
                    flatBufferBuilder.b(0, b);
                    flatBufferBuilder.b(1, b2);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            /* compiled from: keywords_groups(%s) */
            public class Serializer extends JsonSerializer<PageProductListsModel> {
                public final void m18720a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    PageProductListsModel pageProductListsModel = (PageProductListsModel) obj;
                    if (pageProductListsModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(pageProductListsModel.m18721a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        pageProductListsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    PageProductListsParser.m18757a(pageProductListsModel.w_(), pageProductListsModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(PageProductListsModel.class, new Serializer());
                }
            }

            public PageProductListsModel() {
                super(1);
            }

            @Nonnull
            public final ImmutableList<NodesModel> m18723a() {
                this.f11815d = super.a(this.f11815d, 0, NodesModel.class);
                return (ImmutableList) this.f11815d;
            }

            public final int jK_() {
                return 474569971;
            }

            public final GraphQLVisitableModel m18722a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m18723a() != null) {
                    Builder a = ModelHelper.a(m18723a(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        graphQLVisitableModel = (PageProductListsModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f11815d = a.b();
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m18721a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m18723a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, a);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: keywords_groups(%s) */
        public class Serializer extends JsonSerializer<AvailableMenusQueryModel> {
            public final void m18724a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                AvailableMenusQueryModel availableMenusQueryModel = (AvailableMenusQueryModel) obj;
                if (availableMenusQueryModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(availableMenusQueryModel.m18726a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    availableMenusQueryModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = availableMenusQueryModel.w_();
                int u_ = availableMenusQueryModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("page_product_lists");
                    PageProductListsParser.m18757a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(AvailableMenusQueryModel.class, new Serializer());
            }
        }

        @Nullable
        public final /* synthetic */ PageProductListsModel m18728a() {
            return m18725j();
        }

        public AvailableMenusQueryModel() {
            super(1);
        }

        public final void m18729a(String str, ConsistencyTuple consistencyTuple) {
            consistencyTuple.a();
        }

        public final void m18730a(String str, Object obj, boolean z) {
        }

        @Nullable
        private PageProductListsModel m18725j() {
            this.f11816d = (PageProductListsModel) super.a(this.f11816d, 0, PageProductListsModel.class);
            return this.f11816d;
        }

        public final int jK_() {
            return 2479791;
        }

        public final GraphQLVisitableModel m18727a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m18725j() != null) {
                PageProductListsModel pageProductListsModel = (PageProductListsModel) graphQLModelMutatingVisitor.b(m18725j());
                if (m18725j() != pageProductListsModel) {
                    graphQLVisitableModel = (AvailableMenusQueryModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f11816d = pageProductListsModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m18726a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m18725j());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -1122397232)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: keywords_groups(%s) */
    public final class PhotosQueryModel extends BaseModel implements GraphQLVisitableConsistentModel {
        @Nullable
        private PhotosByCategoryModel f11821d;

        /* compiled from: keywords_groups(%s) */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(PhotosQueryModel.class, new Deserializer());
            }

            public Object m18731a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = PhotosQueryParser.m18763a(jsonParser);
                Object photosQueryModel = new PhotosQueryModel();
                ((BaseModel) photosQueryModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (photosQueryModel instanceof Postprocessable) {
                    return ((Postprocessable) photosQueryModel).a();
                }
                return photosQueryModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 460912387)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: keywords_groups(%s) */
        public final class PhotosByCategoryModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private List<NodesModel> f11819d;
            @Nullable
            private DefaultPageInfoFieldsModel f11820e;

            /* compiled from: keywords_groups(%s) */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(PhotosByCategoryModel.class, new Deserializer());
                }

                public Object m18732a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(PhotosByCategoryParser.m18761a(jsonParser, flatBufferBuilder));
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

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = -1810715828)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: keywords_groups(%s) */
            public final class NodesModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel {
                @Nullable
                private String f11817d;
                @Nullable
                private DefaultImageFieldsModel f11818e;

                /* compiled from: keywords_groups(%s) */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(NodesModel.class, new Deserializer());
                    }

                    public Object m18733a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(PhotosByCategoryParser.NodesParser.m18759b(jsonParser, flatBufferBuilder));
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

                /* compiled from: keywords_groups(%s) */
                public class Serializer extends JsonSerializer<NodesModel> {
                    public final void m18734a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        NodesModel nodesModel = (NodesModel) obj;
                        if (nodesModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(nodesModel.m18736a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            nodesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        PhotosByCategoryParser.NodesParser.m18760b(nodesModel.w_(), nodesModel.u_(), jsonGenerator, serializerProvider);
                    }

                    static {
                        FbSerializerProvider.a(NodesModel.class, new Serializer());
                    }
                }

                @Nullable
                public final /* synthetic */ DefaultImageFields m18740c() {
                    return m18735j();
                }

                public NodesModel() {
                    super(2);
                }

                @Nullable
                public final String m18739b() {
                    this.f11817d = super.a(this.f11817d, 0);
                    return this.f11817d;
                }

                @Nullable
                private DefaultImageFieldsModel m18735j() {
                    this.f11818e = (DefaultImageFieldsModel) super.a(this.f11818e, 1, DefaultImageFieldsModel.class);
                    return this.f11818e;
                }

                @Nullable
                public final String m18738a() {
                    return m18739b();
                }

                public final int jK_() {
                    return 77090322;
                }

                public final GraphQLVisitableModel m18737a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    GraphQLVisitableModel graphQLVisitableModel = null;
                    h();
                    if (m18735j() != null) {
                        DefaultImageFieldsModel defaultImageFieldsModel = (DefaultImageFieldsModel) graphQLModelMutatingVisitor.b(m18735j());
                        if (m18735j() != defaultImageFieldsModel) {
                            graphQLVisitableModel = (NodesModel) ModelHelper.a(null, this);
                            graphQLVisitableModel.f11818e = defaultImageFieldsModel;
                        }
                    }
                    i();
                    return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                }

                public final int m18736a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int b = flatBufferBuilder.b(m18739b());
                    int a = ModelHelper.a(flatBufferBuilder, m18735j());
                    flatBufferBuilder.c(2);
                    flatBufferBuilder.b(0, b);
                    flatBufferBuilder.b(1, a);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            /* compiled from: keywords_groups(%s) */
            public class Serializer extends JsonSerializer<PhotosByCategoryModel> {
                public final void m18741a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    PhotosByCategoryModel photosByCategoryModel = (PhotosByCategoryModel) obj;
                    if (photosByCategoryModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(photosByCategoryModel.m18743a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        photosByCategoryModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    PhotosByCategoryParser.m18762a(photosByCategoryModel.w_(), photosByCategoryModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(PhotosByCategoryModel.class, new Serializer());
                }
            }

            @Nullable
            public final /* synthetic */ DefaultPageInfoFields m18746b() {
                return m18742j();
            }

            public PhotosByCategoryModel() {
                super(2);
            }

            @Nonnull
            public final ImmutableList<NodesModel> m18745a() {
                this.f11819d = super.a(this.f11819d, 0, NodesModel.class);
                return (ImmutableList) this.f11819d;
            }

            @Nullable
            private DefaultPageInfoFieldsModel m18742j() {
                this.f11820e = (DefaultPageInfoFieldsModel) super.a(this.f11820e, 1, DefaultPageInfoFieldsModel.class);
                return this.f11820e;
            }

            public final int jK_() {
                return 565084532;
            }

            public final GraphQLVisitableModel m18744a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel;
                DefaultPageInfoFieldsModel defaultPageInfoFieldsModel;
                h();
                if (m18745a() != null) {
                    Builder a = ModelHelper.a(m18745a(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        PhotosByCategoryModel photosByCategoryModel = (PhotosByCategoryModel) ModelHelper.a(null, this);
                        photosByCategoryModel.f11819d = a.b();
                        graphQLVisitableModel = photosByCategoryModel;
                        if (m18742j() != null) {
                            defaultPageInfoFieldsModel = (DefaultPageInfoFieldsModel) graphQLModelMutatingVisitor.b(m18742j());
                            if (m18742j() != defaultPageInfoFieldsModel) {
                                graphQLVisitableModel = (PhotosByCategoryModel) ModelHelper.a(graphQLVisitableModel, this);
                                graphQLVisitableModel.f11820e = defaultPageInfoFieldsModel;
                            }
                        }
                        i();
                        return graphQLVisitableModel != null ? this : graphQLVisitableModel;
                    }
                }
                graphQLVisitableModel = null;
                if (m18742j() != null) {
                    defaultPageInfoFieldsModel = (DefaultPageInfoFieldsModel) graphQLModelMutatingVisitor.b(m18742j());
                    if (m18742j() != defaultPageInfoFieldsModel) {
                        graphQLVisitableModel = (PhotosByCategoryModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f11820e = defaultPageInfoFieldsModel;
                    }
                }
                i();
                if (graphQLVisitableModel != null) {
                }
            }

            public final int m18743a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m18745a());
                int a2 = ModelHelper.a(flatBufferBuilder, m18742j());
                flatBufferBuilder.c(2);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.b(1, a2);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: keywords_groups(%s) */
        public class Serializer extends JsonSerializer<PhotosQueryModel> {
            public final void m18747a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                PhotosQueryModel photosQueryModel = (PhotosQueryModel) obj;
                if (photosQueryModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(photosQueryModel.m18749a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    photosQueryModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = photosQueryModel.w_();
                int u_ = photosQueryModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("photos_by_category");
                    PhotosByCategoryParser.m18762a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(PhotosQueryModel.class, new Serializer());
            }
        }

        @Nullable
        public final /* synthetic */ PhotosByCategoryModel m18751a() {
            return m18748j();
        }

        public PhotosQueryModel() {
            super(1);
        }

        public final void m18752a(String str, ConsistencyTuple consistencyTuple) {
            consistencyTuple.a();
        }

        public final void m18753a(String str, Object obj, boolean z) {
        }

        @Nullable
        private PhotosByCategoryModel m18748j() {
            this.f11821d = (PhotosByCategoryModel) super.a(this.f11821d, 0, PhotosByCategoryModel.class);
            return this.f11821d;
        }

        public final int jK_() {
            return 2479791;
        }

        public final GraphQLVisitableModel m18750a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m18748j() != null) {
                PhotosByCategoryModel photosByCategoryModel = (PhotosByCategoryModel) graphQLModelMutatingVisitor.b(m18748j());
                if (m18748j() != photosByCategoryModel) {
                    graphQLVisitableModel = (PhotosQueryModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f11821d = photosByCategoryModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m18749a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m18748j());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }
}
