package com.facebook.places.pagetopics.graphql;

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
import com.facebook.graphql.visitor.ConsistencyTuple;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLPersistableNode;
import com.facebook.graphql.visitor.GraphQLVisitableConsistentModel;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.facebook.places.pagetopics.graphql.PlaceCategoryPickerGraphQLParsers.PlaceCategoryPickerChildrenParser;
import com.facebook.places.pagetopics.graphql.PlaceCategoryPickerGraphQLParsers.PlaceCategoryPickerChildrenParser.ChildCategoriesParser;
import com.facebook.places.pagetopics.graphql.PlaceCategoryPickerGraphQLParsers.PlaceCategoryPickerChildrenParser.ChildCategoriesParser.EdgesParser;
import com.facebook.places.pagetopics.graphql.PlaceCategoryPickerGraphQLParsers.PlaceCategoryPickerSearchParser;
import com.facebook.places.pagetopics.graphql.PlaceCategoryPickerGraphQLParsers.PlaceCategoryPickerSearchParser.CategoryResultsParser;
import com.facebook.places.pagetopics.graphql.PlaceCategoryPickerGraphQLParsers.PlaceCategoryPickerSearchParser.CategoryResultsParser.PageInfoParser;
import com.facebook.places.pagetopics.graphql.PlaceCategoryPickerGraphQLParsers.PlaceCategoryRowParser;
import com.facebook.places.pagetopics.graphql.PlaceCategoryPickerGraphQLParsers.PlaceCategoryRowParser.ChildCategoriesParser.EdgesParser.NodeParser;
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

/* compiled from: focus_x */
public class PlaceCategoryPickerGraphQLModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 1086092256)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: focus_x */
    public final class PlaceCategoryPickerChildrenModel extends BaseModel implements GraphQLVisitableConsistentModel {
        @Nullable
        private GraphQLObjectType f14759d;
        @Nullable
        private ChildCategoriesModel f14760e;

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 86475030)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: focus_x */
        public final class ChildCategoriesModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private List<EdgesModel> f14758d;

            /* compiled from: focus_x */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(ChildCategoriesModel.class, new Deserializer());
                }

                public Object m22330a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(ChildCategoriesParser.m22397a(r11, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object childCategoriesModel = new ChildCategoriesModel();
                    ((BaseModel) childCategoriesModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), r11);
                    if (childCategoriesModel instanceof Postprocessable) {
                        return ((Postprocessable) childCategoriesModel).a();
                    }
                    return childCategoriesModel;
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = -1305019605)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: focus_x */
            public final class EdgesModel extends BaseModel implements GraphQLVisitableModel {
                @Nullable
                private PlaceCategoryRowModel f14757d;

                /* compiled from: focus_x */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(EdgesModel.class, new Deserializer());
                    }

                    public Object m22331a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(EdgesParser.m22395b(r11, flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                        Object edgesModel = new EdgesModel();
                        ((BaseModel) edgesModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), r11);
                        if (edgesModel instanceof Postprocessable) {
                            return ((Postprocessable) edgesModel).a();
                        }
                        return edgesModel;
                    }
                }

                /* compiled from: focus_x */
                public class Serializer extends JsonSerializer<EdgesModel> {
                    public final void m22332a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        EdgesModel edgesModel = (EdgesModel) r8;
                        if (edgesModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(edgesModel.m22333a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            edgesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        EdgesParser.m22396b(edgesModel.w_(), edgesModel.u_(), r9, r10);
                    }

                    static {
                        FbSerializerProvider.a(EdgesModel.class, new Serializer());
                    }
                }

                public EdgesModel() {
                    super(1);
                }

                @Nullable
                public final PlaceCategoryRowModel m22335a() {
                    this.f14757d = (PlaceCategoryRowModel) super.a(this.f14757d, 0, PlaceCategoryRowModel.class);
                    return this.f14757d;
                }

                public final int jK_() {
                    return 12043860;
                }

                public final GraphQLVisitableModel m22334a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    GraphQLVisitableModel graphQLVisitableModel = null;
                    h();
                    if (m22335a() != null) {
                        PlaceCategoryRowModel placeCategoryRowModel = (PlaceCategoryRowModel) r4.b(m22335a());
                        if (m22335a() != placeCategoryRowModel) {
                            graphQLVisitableModel = (EdgesModel) ModelHelper.a(null, this);
                            graphQLVisitableModel.f14757d = placeCategoryRowModel;
                        }
                    }
                    i();
                    return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                }

                public final int m22333a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int a = ModelHelper.a(r3, m22335a());
                    r3.c(1);
                    r3.b(0, a);
                    i();
                    return r3.d();
                }
            }

            /* compiled from: focus_x */
            public class Serializer extends JsonSerializer<ChildCategoriesModel> {
                public final void m22336a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    ChildCategoriesModel childCategoriesModel = (ChildCategoriesModel) r8;
                    if (childCategoriesModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(childCategoriesModel.m22337a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        childCategoriesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    ChildCategoriesParser.m22398a(childCategoriesModel.w_(), childCategoriesModel.u_(), r9, r10);
                }

                static {
                    FbSerializerProvider.a(ChildCategoriesModel.class, new Serializer());
                }
            }

            public ChildCategoriesModel() {
                super(1);
            }

            @Nonnull
            public final ImmutableList<EdgesModel> m22339a() {
                this.f14758d = super.a(this.f14758d, 0, EdgesModel.class);
                return (ImmutableList) this.f14758d;
            }

            public final int jK_() {
                return -1535653323;
            }

            public final GraphQLVisitableModel m22338a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m22339a() != null) {
                    Builder a = ModelHelper.a(m22339a(), r3);
                    if (a != null) {
                        graphQLVisitableModel = (ChildCategoriesModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f14758d = a.b();
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m22337a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(r3, m22339a());
                r3.c(1);
                r3.b(0, a);
                i();
                return r3.d();
            }
        }

        /* compiled from: focus_x */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(PlaceCategoryPickerChildrenModel.class, new Deserializer());
            }

            public Object m22340a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = PlaceCategoryPickerChildrenParser.m22399a(r6);
                Object placeCategoryPickerChildrenModel = new PlaceCategoryPickerChildrenModel();
                ((BaseModel) placeCategoryPickerChildrenModel).a(a, FlatBuffer.a(a.a), r6);
                if (placeCategoryPickerChildrenModel instanceof Postprocessable) {
                    return ((Postprocessable) placeCategoryPickerChildrenModel).a();
                }
                return placeCategoryPickerChildrenModel;
            }
        }

        /* compiled from: focus_x */
        public class Serializer extends JsonSerializer<PlaceCategoryPickerChildrenModel> {
            public final void m22341a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                PlaceCategoryPickerChildrenModel placeCategoryPickerChildrenModel = (PlaceCategoryPickerChildrenModel) r9;
                if (placeCategoryPickerChildrenModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(placeCategoryPickerChildrenModel.m22343a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    placeCategoryPickerChildrenModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = placeCategoryPickerChildrenModel.w_();
                int u_ = placeCategoryPickerChildrenModel.u_();
                r10.f();
                if (mutableFlatBuffer.g(u_, 0) != 0) {
                    r10.a("__type__");
                    SerializerHelpers.b(mutableFlatBuffer, u_, 0, r10);
                }
                int g = mutableFlatBuffer.g(u_, 1);
                if (g != 0) {
                    r10.a("child_categories");
                    ChildCategoriesParser.m22398a(mutableFlatBuffer, g, r10, r11);
                }
                r10.g();
            }

            static {
                FbSerializerProvider.a(PlaceCategoryPickerChildrenModel.class, new Serializer());
            }
        }

        public PlaceCategoryPickerChildrenModel() {
            super(2);
        }

        public final void m22346a(String str, ConsistencyTuple consistencyTuple) {
            r2.a();
        }

        public final void m22347a(String str, Object obj, boolean z) {
        }

        @Nullable
        private GraphQLObjectType m22342j() {
            if (this.b != null && this.f14759d == null) {
                this.f14759d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
            }
            return this.f14759d;
        }

        @Nullable
        public final ChildCategoriesModel m22345a() {
            this.f14760e = (ChildCategoriesModel) super.a(this.f14760e, 1, ChildCategoriesModel.class);
            return this.f14760e;
        }

        public final int jK_() {
            return 2433570;
        }

        public final GraphQLVisitableModel m22344a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m22345a() != null) {
                ChildCategoriesModel childCategoriesModel = (ChildCategoriesModel) r4.b(m22345a());
                if (m22345a() != childCategoriesModel) {
                    graphQLVisitableModel = (PlaceCategoryPickerChildrenModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f14760e = childCategoriesModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m22343a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(r4, m22342j());
            int a2 = ModelHelper.a(r4, m22345a());
            r4.c(2);
            r4.b(0, a);
            r4.b(1, a2);
            i();
            return r4.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 1947151740)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: focus_x */
    public final class PlaceCategoryPickerSearchModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private CategoryResultsModel f14766d;

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -811707899)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: focus_x */
        public final class CategoryResultsModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private List<EdgesModel> f14764d;
            @Nullable
            private PageInfoModel f14765e;

            /* compiled from: focus_x */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(CategoryResultsModel.class, new Deserializer());
                }

                public Object m22348a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(CategoryResultsParser.m22404a(r11, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object categoryResultsModel = new CategoryResultsModel();
                    ((BaseModel) categoryResultsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), r11);
                    if (categoryResultsModel instanceof Postprocessable) {
                        return ((Postprocessable) categoryResultsModel).a();
                    }
                    return categoryResultsModel;
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = -1305019605)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: focus_x */
            public final class EdgesModel extends BaseModel implements GraphQLVisitableModel {
                @Nullable
                private PlaceCategoryRowModel f14761d;

                /* compiled from: focus_x */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(EdgesModel.class, new Deserializer());
                    }

                    public Object m22349a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(CategoryResultsParser.EdgesParser.m22400b(r11, flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                        Object edgesModel = new EdgesModel();
                        ((BaseModel) edgesModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), r11);
                        if (edgesModel instanceof Postprocessable) {
                            return ((Postprocessable) edgesModel).a();
                        }
                        return edgesModel;
                    }
                }

                /* compiled from: focus_x */
                public class Serializer extends JsonSerializer<EdgesModel> {
                    public final void m22350a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        EdgesModel edgesModel = (EdgesModel) r8;
                        if (edgesModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(edgesModel.m22351a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            edgesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        CategoryResultsParser.EdgesParser.m22401b(edgesModel.w_(), edgesModel.u_(), r9, r10);
                    }

                    static {
                        FbSerializerProvider.a(EdgesModel.class, new Serializer());
                    }
                }

                public EdgesModel() {
                    super(1);
                }

                @Nullable
                public final PlaceCategoryRowModel m22353a() {
                    this.f14761d = (PlaceCategoryRowModel) super.a(this.f14761d, 0, PlaceCategoryRowModel.class);
                    return this.f14761d;
                }

                public final int jK_() {
                    return 1897710570;
                }

                public final GraphQLVisitableModel m22352a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    GraphQLVisitableModel graphQLVisitableModel = null;
                    h();
                    if (m22353a() != null) {
                        PlaceCategoryRowModel placeCategoryRowModel = (PlaceCategoryRowModel) r4.b(m22353a());
                        if (m22353a() != placeCategoryRowModel) {
                            graphQLVisitableModel = (EdgesModel) ModelHelper.a(null, this);
                            graphQLVisitableModel.f14761d = placeCategoryRowModel;
                        }
                    }
                    i();
                    return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                }

                public final int m22351a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int a = ModelHelper.a(r3, m22353a());
                    r3.c(1);
                    r3.b(0, a);
                    i();
                    return r3.d();
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = 58916270)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: focus_x */
            public final class PageInfoModel extends BaseModel implements GraphQLVisitableModel {
                @Nullable
                private String f14762d;
                @Nullable
                private String f14763e;

                /* compiled from: focus_x */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(PageInfoModel.class, new Deserializer());
                    }

                    public Object m22354a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(PageInfoParser.m22402a(r11, flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                        Object pageInfoModel = new PageInfoModel();
                        ((BaseModel) pageInfoModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), r11);
                        if (pageInfoModel instanceof Postprocessable) {
                            return ((Postprocessable) pageInfoModel).a();
                        }
                        return pageInfoModel;
                    }
                }

                /* compiled from: focus_x */
                public class Serializer extends JsonSerializer<PageInfoModel> {
                    public final void m22355a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        PageInfoModel pageInfoModel = (PageInfoModel) r8;
                        if (pageInfoModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(pageInfoModel.m22358a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            pageInfoModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        PageInfoParser.m22403a(pageInfoModel.w_(), pageInfoModel.u_(), r9);
                    }

                    static {
                        FbSerializerProvider.a(PageInfoModel.class, new Serializer());
                    }
                }

                public PageInfoModel() {
                    super(2);
                }

                @Nullable
                private String m22356a() {
                    this.f14762d = super.a(this.f14762d, 0);
                    return this.f14762d;
                }

                @Nullable
                private String m22357j() {
                    this.f14763e = super.a(this.f14763e, 1);
                    return this.f14763e;
                }

                public final int jK_() {
                    return 923779069;
                }

                public final GraphQLVisitableModel m22359a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    h();
                    i();
                    return this;
                }

                public final int m22358a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int b = r4.b(m22356a());
                    int b2 = r4.b(m22357j());
                    r4.c(2);
                    r4.b(0, b);
                    r4.b(1, b2);
                    i();
                    return r4.d();
                }
            }

            /* compiled from: focus_x */
            public class Serializer extends JsonSerializer<CategoryResultsModel> {
                public final void m22360a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    CategoryResultsModel categoryResultsModel = (CategoryResultsModel) r8;
                    if (categoryResultsModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(categoryResultsModel.m22362a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        categoryResultsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    CategoryResultsParser.m22405a(categoryResultsModel.w_(), categoryResultsModel.u_(), r9, r10);
                }

                static {
                    FbSerializerProvider.a(CategoryResultsModel.class, new Serializer());
                }
            }

            public CategoryResultsModel() {
                super(2);
            }

            @Nonnull
            public final ImmutableList<EdgesModel> m22364a() {
                this.f14764d = super.a(this.f14764d, 0, EdgesModel.class);
                return (ImmutableList) this.f14764d;
            }

            @Nullable
            private PageInfoModel m22361j() {
                this.f14765e = (PageInfoModel) super.a(this.f14765e, 1, PageInfoModel.class);
                return this.f14765e;
            }

            public final int jK_() {
                return -1051607221;
            }

            public final GraphQLVisitableModel m22363a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel;
                PageInfoModel pageInfoModel;
                h();
                if (m22364a() != null) {
                    Builder a = ModelHelper.a(m22364a(), r4);
                    if (a != null) {
                        CategoryResultsModel categoryResultsModel = (CategoryResultsModel) ModelHelper.a(null, this);
                        categoryResultsModel.f14764d = a.b();
                        graphQLVisitableModel = categoryResultsModel;
                        if (m22361j() != null) {
                            pageInfoModel = (PageInfoModel) r4.b(m22361j());
                            if (m22361j() != pageInfoModel) {
                                graphQLVisitableModel = (CategoryResultsModel) ModelHelper.a(graphQLVisitableModel, this);
                                graphQLVisitableModel.f14765e = pageInfoModel;
                            }
                        }
                        i();
                        return graphQLVisitableModel != null ? this : graphQLVisitableModel;
                    }
                }
                graphQLVisitableModel = null;
                if (m22361j() != null) {
                    pageInfoModel = (PageInfoModel) r4.b(m22361j());
                    if (m22361j() != pageInfoModel) {
                        graphQLVisitableModel = (CategoryResultsModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f14765e = pageInfoModel;
                    }
                }
                i();
                if (graphQLVisitableModel != null) {
                }
            }

            public final int m22362a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(r4, m22364a());
                int a2 = ModelHelper.a(r4, m22361j());
                r4.c(2);
                r4.b(0, a);
                r4.b(1, a2);
                i();
                return r4.d();
            }
        }

        /* compiled from: focus_x */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(PlaceCategoryPickerSearchModel.class, new Deserializer());
            }

            public Object m22365a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = PlaceCategoryPickerSearchParser.m22406a(r6);
                Object placeCategoryPickerSearchModel = new PlaceCategoryPickerSearchModel();
                ((BaseModel) placeCategoryPickerSearchModel).a(a, FlatBuffer.a(a.a), r6);
                if (placeCategoryPickerSearchModel instanceof Postprocessable) {
                    return ((Postprocessable) placeCategoryPickerSearchModel).a();
                }
                return placeCategoryPickerSearchModel;
            }
        }

        /* compiled from: focus_x */
        public class Serializer extends JsonSerializer<PlaceCategoryPickerSearchModel> {
            public final void m22366a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                PlaceCategoryPickerSearchModel placeCategoryPickerSearchModel = (PlaceCategoryPickerSearchModel) r9;
                if (placeCategoryPickerSearchModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(placeCategoryPickerSearchModel.m22367a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    placeCategoryPickerSearchModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = placeCategoryPickerSearchModel.w_();
                int u_ = placeCategoryPickerSearchModel.u_();
                r10.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    r10.a("category_results");
                    CategoryResultsParser.m22405a(mutableFlatBuffer, g, r10, r11);
                }
                r10.g();
            }

            static {
                FbSerializerProvider.a(PlaceCategoryPickerSearchModel.class, new Serializer());
            }
        }

        public PlaceCategoryPickerSearchModel() {
            super(1);
        }

        @Nullable
        public final CategoryResultsModel m22369a() {
            this.f14766d = (CategoryResultsModel) super.a(this.f14766d, 0, CategoryResultsModel.class);
            return this.f14766d;
        }

        public final int jK_() {
            return -227080417;
        }

        public final GraphQLVisitableModel m22368a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m22369a() != null) {
                CategoryResultsModel categoryResultsModel = (CategoryResultsModel) r4.b(m22369a());
                if (m22369a() != categoryResultsModel) {
                    graphQLVisitableModel = (PlaceCategoryPickerSearchModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f14766d = categoryResultsModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m22367a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(r3, m22369a());
            r3.c(1);
            r3.b(0, a);
            i();
            return r3.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -1246960430)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: focus_x */
    public final class PlaceCategoryRowModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel {
        @Nullable
        private ChildCategoriesModel f14771d;
        @Nullable
        private String f14772e;
        @Nullable
        private String f14773f;
        @Nullable
        private String f14774g;

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 306451077)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: focus_x */
        public final class ChildCategoriesModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private List<EdgesModel> f14770d;

            /* compiled from: focus_x */
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
                    r0 = com.facebook.places.pagetopics.graphql.PlaceCategoryPickerGraphQLModels.PlaceCategoryRowModel.ChildCategoriesModel.class;
                    r1 = new com.facebook.places.pagetopics.graphql.PlaceCategoryPickerGraphQLModels$PlaceCategoryRowModel$ChildCategoriesModel$Deserializer;
                    r1.<init>();
                    com.facebook.common.json.GlobalAutoGenDeserializerCache.a(r0, r1);
                    return;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.places.pagetopics.graphql.PlaceCategoryPickerGraphQLModels.PlaceCategoryRowModel.ChildCategoriesModel.Deserializer.<clinit>():void");
                }

                public Object m22370a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(PlaceCategoryRowParser.ChildCategoriesParser.m22411a(r11, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object childCategoriesModel = new ChildCategoriesModel();
                    ((BaseModel) childCategoriesModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), r11);
                    if (childCategoriesModel instanceof Postprocessable) {
                        return ((Postprocessable) childCategoriesModel).a();
                    }
                    return childCategoriesModel;
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = 1116853144)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: focus_x */
            public final class EdgesModel extends BaseModel implements GraphQLVisitableModel {
                @Nullable
                private NodeModel f14769d;

                /* compiled from: focus_x */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(EdgesModel.class, new Deserializer());
                    }

                    public Object m22371a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(PlaceCategoryRowParser.ChildCategoriesParser.EdgesParser.m22409b(r11, flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                        Object edgesModel = new EdgesModel();
                        ((BaseModel) edgesModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), r11);
                        if (edgesModel instanceof Postprocessable) {
                            return ((Postprocessable) edgesModel).a();
                        }
                        return edgesModel;
                    }
                }

                @JsonDeserialize(using = Deserializer.class)
                @ModelWithFlatBufferFormatHash(a = 1647119241)
                @JsonSerialize(using = Serializer.class)
                @FragmentModelWithoutBridge
                /* compiled from: focus_x */
                public final class NodeModel extends BaseModel implements GraphQLVisitableModel {
                    @Nullable
                    private String f14767d;
                    @Nullable
                    private String f14768e;

                    /* compiled from: focus_x */
                    public class Deserializer extends FbJsonDeserializer {
                        static {
                            GlobalAutoGenDeserializerCache.a(NodeModel.class, new Deserializer());
                        }

                        public Object m22372a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(NodeParser.m22407a(r11, flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            mutableFlatBuffer.a(4, Boolean.valueOf(true));
                            MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                            Object nodeModel = new NodeModel();
                            ((BaseModel) nodeModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), r11);
                            if (nodeModel instanceof Postprocessable) {
                                return ((Postprocessable) nodeModel).a();
                            }
                            return nodeModel;
                        }
                    }

                    /* compiled from: focus_x */
                    public class Serializer extends JsonSerializer<NodeModel> {
                        public final void m22373a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                            NodeModel nodeModel = (NodeModel) r8;
                            if (nodeModel.w_() == null) {
                                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                flatBufferBuilder.d(nodeModel.m22375a(flatBufferBuilder));
                                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                wrap.position(0);
                                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                nodeModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                            }
                            NodeParser.m22408a(nodeModel.w_(), nodeModel.u_(), r9);
                        }

                        static {
                            FbSerializerProvider.a(NodeModel.class, new Serializer());
                        }
                    }

                    public NodeModel() {
                        super(2);
                    }

                    @Nullable
                    public final String m22377a() {
                        this.f14767d = super.a(this.f14767d, 0);
                        return this.f14767d;
                    }

                    @Nullable
                    private String m22374j() {
                        this.f14768e = super.a(this.f14768e, 1);
                        return this.f14768e;
                    }

                    public final int jK_() {
                        return -1210237407;
                    }

                    public final GraphQLVisitableModel m22376a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                        h();
                        i();
                        return this;
                    }

                    public final int m22375a(FlatBufferBuilder flatBufferBuilder) {
                        h();
                        int b = r4.b(m22377a());
                        int b2 = r4.b(m22374j());
                        r4.c(2);
                        r4.b(0, b);
                        r4.b(1, b2);
                        i();
                        return r4.d();
                    }
                }

                /* compiled from: focus_x */
                public class Serializer extends JsonSerializer<EdgesModel> {
                    public final void m22378a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        EdgesModel edgesModel = (EdgesModel) r8;
                        if (edgesModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(edgesModel.m22379a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            edgesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        PlaceCategoryRowParser.ChildCategoriesParser.EdgesParser.m22410b(edgesModel.w_(), edgesModel.u_(), r9, r10);
                    }

                    static {
                        FbSerializerProvider.a(EdgesModel.class, new Serializer());
                    }
                }

                public EdgesModel() {
                    super(1);
                }

                @Nullable
                public final NodeModel m22381a() {
                    this.f14769d = (NodeModel) super.a(this.f14769d, 0, NodeModel.class);
                    return this.f14769d;
                }

                public final int jK_() {
                    return 12043860;
                }

                public final GraphQLVisitableModel m22380a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    GraphQLVisitableModel graphQLVisitableModel = null;
                    h();
                    if (m22381a() != null) {
                        NodeModel nodeModel = (NodeModel) r4.b(m22381a());
                        if (m22381a() != nodeModel) {
                            graphQLVisitableModel = (EdgesModel) ModelHelper.a(null, this);
                            graphQLVisitableModel.f14769d = nodeModel;
                        }
                    }
                    i();
                    return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                }

                public final int m22379a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int a = ModelHelper.a(r3, m22381a());
                    r3.c(1);
                    r3.b(0, a);
                    i();
                    return r3.d();
                }
            }

            /* compiled from: focus_x */
            public class Serializer extends JsonSerializer<ChildCategoriesModel> {
                public final void m22382a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    ChildCategoriesModel childCategoriesModel = (ChildCategoriesModel) r8;
                    if (childCategoriesModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(childCategoriesModel.m22383a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        childCategoriesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    PlaceCategoryRowParser.ChildCategoriesParser.m22412a(childCategoriesModel.w_(), childCategoriesModel.u_(), r9, r10);
                }

                static {
                    FbSerializerProvider.a(ChildCategoriesModel.class, new Serializer());
                }
            }

            public ChildCategoriesModel() {
                super(1);
            }

            @Nonnull
            public final ImmutableList<EdgesModel> m22385a() {
                this.f14770d = super.a(this.f14770d, 0, EdgesModel.class);
                return (ImmutableList) this.f14770d;
            }

            public final int jK_() {
                return -1535653323;
            }

            public final GraphQLVisitableModel m22384a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m22385a() != null) {
                    Builder a = ModelHelper.a(m22385a(), r3);
                    if (a != null) {
                        graphQLVisitableModel = (ChildCategoriesModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f14770d = a.b();
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m22383a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(r3, m22385a());
                r3.c(1);
                r3.b(0, a);
                i();
                return r3.d();
            }
        }

        /* compiled from: focus_x */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(PlaceCategoryRowModel.class, new Deserializer());
            }

            public Object m22386a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(PlaceCategoryRowParser.m22413a(r11, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object placeCategoryRowModel = new PlaceCategoryRowModel();
                ((BaseModel) placeCategoryRowModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), r11);
                if (placeCategoryRowModel instanceof Postprocessable) {
                    return ((Postprocessable) placeCategoryRowModel).a();
                }
                return placeCategoryRowModel;
            }
        }

        /* compiled from: focus_x */
        public class Serializer extends JsonSerializer<PlaceCategoryRowModel> {
            public final void m22387a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                PlaceCategoryRowModel placeCategoryRowModel = (PlaceCategoryRowModel) r8;
                if (placeCategoryRowModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(placeCategoryRowModel.m22388a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    placeCategoryRowModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                PlaceCategoryRowParser.m22414a(placeCategoryRowModel.w_(), placeCategoryRowModel.u_(), r9, r10);
            }

            static {
                FbSerializerProvider.a(PlaceCategoryRowModel.class, new Serializer());
            }
        }

        public PlaceCategoryRowModel() {
            super(4);
        }

        @Nullable
        public final ChildCategoriesModel m22391j() {
            this.f14771d = (ChildCategoriesModel) super.a(this.f14771d, 0, ChildCategoriesModel.class);
            return this.f14771d;
        }

        @Nullable
        public final String m22392k() {
            this.f14772e = super.a(this.f14772e, 1);
            return this.f14772e;
        }

        @Nullable
        public final String m22393l() {
            this.f14773f = super.a(this.f14773f, 2);
            return this.f14773f;
        }

        @Nullable
        public final String m22394m() {
            this.f14774g = super.a(this.f14774g, 3);
            return this.f14774g;
        }

        @Nullable
        public final String m22390a() {
            return m22393l();
        }

        public final int jK_() {
            return -1210237407;
        }

        public final GraphQLVisitableModel m22389a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m22391j() != null) {
                ChildCategoriesModel childCategoriesModel = (ChildCategoriesModel) r4.b(m22391j());
                if (m22391j() != childCategoriesModel) {
                    graphQLVisitableModel = (PlaceCategoryRowModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f14771d = childCategoriesModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m22388a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(r6, m22391j());
            int b = r6.b(m22392k());
            int b2 = r6.b(m22393l());
            int b3 = r6.b(m22394m());
            r6.c(4);
            r6.b(0, a);
            r6.b(1, b);
            r6.b(2, b2);
            r6.b(3, b3);
            i();
            return r6.d();
        }
    }
}
