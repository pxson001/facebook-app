package com.facebook.pages.data.graphql.cards;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbSerializerProvider;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.entitycards.contextitems.graphql.ContextItemsQueryModels.ContextItemsConnectionFragmentModel;
import com.facebook.entitycards.contextitems.graphql.ContextItemsQueryParsers.ContextItemsConnectionFragmentParser;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.FragmentModelWithoutBridge;
import com.facebook.flatbuffers.ModelWithFlatBufferFormatHash;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.enums.GraphQLPlaceType;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.querybuilder.common.CommonGraphQLModels.DefaultAddressFieldsModel;
import com.facebook.graphql.querybuilder.common.CommonGraphQLModels.DefaultLocationFieldsModel;
import com.facebook.graphql.querybuilder.common.CommonGraphQLParsers.DefaultAddressFieldsParser;
import com.facebook.graphql.querybuilder.common.CommonGraphQLParsers.DefaultLocationFieldsParser;
import com.facebook.graphql.visitor.ConsistencyTuple;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLVisitableConsistentModel;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.facebook.pages.data.graphql.cards.PageContextItemInfoCardGraphQLParsers.PageInfoCardContextItemQueryParser;
import com.facebook.pages.data.graphql.cards.PageContextItemInfoCardGraphQLParsers.PageInfoCardContextItemQueryParser.MapBoundingBoxParser;
import com.facebook.pages.data.graphql.cards.PageContextItemInfoCardGraphQLParsers.PageInfoCardContextItemQueryParser.MenuInfoParser;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.nio.ByteBuffer;
import javax.annotation.Nullable;

/* compiled from: context_item_icon_size */
public class PageContextItemInfoCardGraphQLModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -1747926977)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: context_item_icon_size */
    public final class PageInfoCardContextItemQueryModel extends BaseModel implements GraphQLVisitableConsistentModel {
        @Nullable
        private DefaultAddressFieldsModel f16995d;
        @Nullable
        private ContextItemsConnectionFragmentModel f16996e;
        private boolean f16997f;
        @Nullable
        private DefaultLocationFieldsModel f16998g;
        @Nullable
        private MapBoundingBoxModel f16999h;
        private int f17000i;
        @Nullable
        private MenuInfoModel f17001j;
        @Nullable
        private GraphQLPlaceType f17002k;

        /* compiled from: context_item_icon_size */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(PageInfoCardContextItemQueryModel.class, new Deserializer());
            }

            public Object m20457a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(PageInfoCardContextItemQueryParser.m20492a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object pageInfoCardContextItemQueryModel = new PageInfoCardContextItemQueryModel();
                ((BaseModel) pageInfoCardContextItemQueryModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (pageInfoCardContextItemQueryModel instanceof Postprocessable) {
                    return ((Postprocessable) pageInfoCardContextItemQueryModel).a();
                }
                return pageInfoCardContextItemQueryModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1076074038)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: context_item_icon_size */
        public final class MapBoundingBoxModel extends BaseModel implements GraphQLVisitableModel {
            private double f16989d;
            private double f16990e;
            private double f16991f;
            private double f16992g;

            /* compiled from: context_item_icon_size */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(MapBoundingBoxModel.class, new Deserializer());
                }

                public Object m20458a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(MapBoundingBoxParser.m20488a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object mapBoundingBoxModel = new MapBoundingBoxModel();
                    ((BaseModel) mapBoundingBoxModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (mapBoundingBoxModel instanceof Postprocessable) {
                        return ((Postprocessable) mapBoundingBoxModel).a();
                    }
                    return mapBoundingBoxModel;
                }
            }

            /* compiled from: context_item_icon_size */
            public class Serializer extends JsonSerializer<MapBoundingBoxModel> {
                public final void m20459a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    MapBoundingBoxModel mapBoundingBoxModel = (MapBoundingBoxModel) obj;
                    if (mapBoundingBoxModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(mapBoundingBoxModel.m20461a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mapBoundingBoxModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    MapBoundingBoxParser.m20489a(mapBoundingBoxModel.w_(), mapBoundingBoxModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(MapBoundingBoxModel.class, new Serializer());
                }
            }

            public MapBoundingBoxModel() {
                super(4);
            }

            public final double m20460a() {
                a(0, 0);
                return this.f16989d;
            }

            public final double m20464j() {
                a(0, 1);
                return this.f16990e;
            }

            public final double m20465k() {
                a(0, 2);
                return this.f16991f;
            }

            public final double m20466l() {
                a(0, 3);
                return this.f16992g;
            }

            public final int jK_() {
                return -2036384450;
            }

            public final GraphQLVisitableModel m20462a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m20461a(FlatBufferBuilder flatBufferBuilder) {
                h();
                flatBufferBuilder.c(4);
                flatBufferBuilder.a(0, this.f16989d, 0.0d);
                flatBufferBuilder.a(1, this.f16990e, 0.0d);
                flatBufferBuilder.a(2, this.f16991f, 0.0d);
                flatBufferBuilder.a(3, this.f16992g, 0.0d);
                i();
                return flatBufferBuilder.d();
            }

            public final void m20463a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                super.a(mutableFlatBuffer, i, obj);
                this.f16989d = mutableFlatBuffer.a(i, 0, 0.0d);
                this.f16990e = mutableFlatBuffer.a(i, 1, 0.0d);
                this.f16991f = mutableFlatBuffer.a(i, 2, 0.0d);
                this.f16992g = mutableFlatBuffer.a(i, 3, 0.0d);
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1406037294)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: context_item_icon_size */
        public final class MenuInfoModel extends BaseModel implements GraphQLVisitableModel {
            private boolean f16993d;
            private boolean f16994e;

            /* compiled from: context_item_icon_size */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(MenuInfoModel.class, new Deserializer());
                }

                public Object m20467a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(MenuInfoParser.m20490a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object menuInfoModel = new MenuInfoModel();
                    ((BaseModel) menuInfoModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (menuInfoModel instanceof Postprocessable) {
                        return ((Postprocessable) menuInfoModel).a();
                    }
                    return menuInfoModel;
                }
            }

            /* compiled from: context_item_icon_size */
            public class Serializer extends JsonSerializer<MenuInfoModel> {
                public final void m20468a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    MenuInfoModel menuInfoModel = (MenuInfoModel) obj;
                    if (menuInfoModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(menuInfoModel.m20469a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        menuInfoModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    MenuInfoParser.m20491a(menuInfoModel.w_(), menuInfoModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(MenuInfoModel.class, new Serializer());
                }
            }

            public MenuInfoModel() {
                super(2);
            }

            public final boolean m20472a() {
                a(0, 0);
                return this.f16993d;
            }

            public final boolean m20473j() {
                a(0, 1);
                return this.f16994e;
            }

            public final int jK_() {
                return 2056274556;
            }

            public final GraphQLVisitableModel m20470a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m20469a(FlatBufferBuilder flatBufferBuilder) {
                h();
                flatBufferBuilder.c(2);
                flatBufferBuilder.a(0, this.f16993d);
                flatBufferBuilder.a(1, this.f16994e);
                i();
                return flatBufferBuilder.d();
            }

            public final void m20471a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                super.a(mutableFlatBuffer, i, obj);
                this.f16993d = mutableFlatBuffer.a(i, 0);
                this.f16994e = mutableFlatBuffer.a(i, 1);
            }
        }

        /* compiled from: context_item_icon_size */
        public class Serializer extends JsonSerializer<PageInfoCardContextItemQueryModel> {
            public final void m20474a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                PageInfoCardContextItemQueryModel pageInfoCardContextItemQueryModel = (PageInfoCardContextItemQueryModel) obj;
                if (pageInfoCardContextItemQueryModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(pageInfoCardContextItemQueryModel.m20475a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    pageInfoCardContextItemQueryModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = pageInfoCardContextItemQueryModel.w_();
                int u_ = pageInfoCardContextItemQueryModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("address");
                    DefaultAddressFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
                }
                g = mutableFlatBuffer.g(u_, 1);
                if (g != 0) {
                    jsonGenerator.a("contextItemInfoCards");
                    ContextItemsConnectionFragmentParser.a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                boolean a = mutableFlatBuffer.a(u_, 2);
                if (a) {
                    jsonGenerator.a("is_place_map_hidden");
                    jsonGenerator.a(a);
                }
                g = mutableFlatBuffer.g(u_, 3);
                if (g != 0) {
                    jsonGenerator.a("location");
                    DefaultLocationFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
                }
                g = mutableFlatBuffer.g(u_, 4);
                if (g != 0) {
                    jsonGenerator.a("map_bounding_box");
                    MapBoundingBoxParser.m20489a(mutableFlatBuffer, g, jsonGenerator);
                }
                g = mutableFlatBuffer.a(u_, 5, 0);
                if (g != 0) {
                    jsonGenerator.a("map_zoom_level");
                    jsonGenerator.b(g);
                }
                g = mutableFlatBuffer.g(u_, 6);
                if (g != 0) {
                    jsonGenerator.a("menu_info");
                    MenuInfoParser.m20491a(mutableFlatBuffer, g, jsonGenerator);
                }
                if (mutableFlatBuffer.g(u_, 7) != 0) {
                    jsonGenerator.a("place_type");
                    jsonGenerator.b(mutableFlatBuffer.b(u_, 7));
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(PageInfoCardContextItemQueryModel.class, new Serializer());
            }
        }

        public PageInfoCardContextItemQueryModel() {
            super(8);
        }

        public final void m20479a(String str, ConsistencyTuple consistencyTuple) {
            consistencyTuple.a();
        }

        public final void m20480a(String str, Object obj, boolean z) {
        }

        @Nullable
        public final DefaultAddressFieldsModel m20476a() {
            this.f16995d = (DefaultAddressFieldsModel) super.a(this.f16995d, 0, DefaultAddressFieldsModel.class);
            return this.f16995d;
        }

        @Nullable
        public final ContextItemsConnectionFragmentModel m20481j() {
            this.f16996e = (ContextItemsConnectionFragmentModel) super.a(this.f16996e, 1, ContextItemsConnectionFragmentModel.class);
            return this.f16996e;
        }

        public final boolean m20482k() {
            a(0, 2);
            return this.f16997f;
        }

        @Nullable
        public final DefaultLocationFieldsModel m20483l() {
            this.f16998g = (DefaultLocationFieldsModel) super.a(this.f16998g, 3, DefaultLocationFieldsModel.class);
            return this.f16998g;
        }

        @Nullable
        public final MapBoundingBoxModel m20484m() {
            this.f16999h = (MapBoundingBoxModel) super.a(this.f16999h, 4, MapBoundingBoxModel.class);
            return this.f16999h;
        }

        public final int m20485n() {
            a(0, 5);
            return this.f17000i;
        }

        @Nullable
        public final MenuInfoModel m20486o() {
            this.f17001j = (MenuInfoModel) super.a(this.f17001j, 6, MenuInfoModel.class);
            return this.f17001j;
        }

        @Nullable
        public final GraphQLPlaceType m20487p() {
            this.f17002k = (GraphQLPlaceType) super.b(this.f17002k, 7, GraphQLPlaceType.class, GraphQLPlaceType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
            return this.f17002k;
        }

        public final int jK_() {
            return 2479791;
        }

        public final GraphQLVisitableModel m20477a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m20476a() != null) {
                DefaultAddressFieldsModel defaultAddressFieldsModel = (DefaultAddressFieldsModel) graphQLModelMutatingVisitor.b(m20476a());
                if (m20476a() != defaultAddressFieldsModel) {
                    graphQLVisitableModel = (PageInfoCardContextItemQueryModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f16995d = defaultAddressFieldsModel;
                }
            }
            if (m20481j() != null) {
                ContextItemsConnectionFragmentModel contextItemsConnectionFragmentModel = (ContextItemsConnectionFragmentModel) graphQLModelMutatingVisitor.b(m20481j());
                if (m20481j() != contextItemsConnectionFragmentModel) {
                    graphQLVisitableModel = (PageInfoCardContextItemQueryModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f16996e = contextItemsConnectionFragmentModel;
                }
            }
            if (m20483l() != null) {
                DefaultLocationFieldsModel defaultLocationFieldsModel = (DefaultLocationFieldsModel) graphQLModelMutatingVisitor.b(m20483l());
                if (m20483l() != defaultLocationFieldsModel) {
                    graphQLVisitableModel = (PageInfoCardContextItemQueryModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f16998g = defaultLocationFieldsModel;
                }
            }
            if (m20484m() != null) {
                MapBoundingBoxModel mapBoundingBoxModel = (MapBoundingBoxModel) graphQLModelMutatingVisitor.b(m20484m());
                if (m20484m() != mapBoundingBoxModel) {
                    graphQLVisitableModel = (PageInfoCardContextItemQueryModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f16999h = mapBoundingBoxModel;
                }
            }
            if (m20486o() != null) {
                MenuInfoModel menuInfoModel = (MenuInfoModel) graphQLModelMutatingVisitor.b(m20486o());
                if (m20486o() != menuInfoModel) {
                    graphQLVisitableModel = (PageInfoCardContextItemQueryModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f17001j = menuInfoModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m20475a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m20476a());
            int a2 = ModelHelper.a(flatBufferBuilder, m20481j());
            int a3 = ModelHelper.a(flatBufferBuilder, m20483l());
            int a4 = ModelHelper.a(flatBufferBuilder, m20484m());
            int a5 = ModelHelper.a(flatBufferBuilder, m20486o());
            int a6 = flatBufferBuilder.a(m20487p());
            flatBufferBuilder.c(8);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, a2);
            flatBufferBuilder.a(2, this.f16997f);
            flatBufferBuilder.b(3, a3);
            flatBufferBuilder.b(4, a4);
            flatBufferBuilder.a(5, this.f17000i, 0);
            flatBufferBuilder.b(6, a5);
            flatBufferBuilder.b(7, a6);
            i();
            return flatBufferBuilder.d();
        }

        public final void m20478a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
            super.a(mutableFlatBuffer, i, obj);
            this.f16997f = mutableFlatBuffer.a(i, 2);
            this.f17000i = mutableFlatBuffer.a(i, 5, 0);
        }
    }
}
