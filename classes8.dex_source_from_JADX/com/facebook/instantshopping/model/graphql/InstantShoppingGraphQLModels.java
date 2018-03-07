package com.facebook.instantshopping.model.graphql;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbSerializerProvider;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.entitycards.contextitems.graphql.ContextItemsQueryModels.FBFullImageFragmentModel;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.FragmentModelWithoutBridge;
import com.facebook.flatbuffers.ModelWithFlatBufferFormatHash;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.enums.GraphQLDocumentVideoAutoplayStyle;
import com.facebook.graphql.enums.GraphQLDocumentVideoControlStyle;
import com.facebook.graphql.enums.GraphQLDocumentVideoLoopingStyle;
import com.facebook.graphql.enums.GraphQLInstantShoppingActionType;
import com.facebook.graphql.enums.GraphQLInstantShoppingDocumentAlignmentDescriptorType;
import com.facebook.graphql.enums.GraphQLInstantShoppingDocumentElementType;
import com.facebook.graphql.enums.GraphQLInstantShoppingDocumentPresentationStyle;
import com.facebook.graphql.enums.GraphQLInstantShoppingHeaderElementType;
import com.facebook.graphql.enums.GraphQLInstantShoppingPostActionNoticeStyle;
import com.facebook.graphql.enums.GraphQLInstantShoppingPresentationStyle;
import com.facebook.graphql.enums.GraphQLObjectType;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.modelutil.SerializerHelpers;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLPersistableNode;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.facebook.instantshopping.model.graphql.InstantShoppingGraphQLInterfaces.InstantShoppingButtonElementFragment;
import com.facebook.instantshopping.model.graphql.InstantShoppingGraphQLInterfaces.InstantShoppingColorSelectorElementFragment;
import com.facebook.instantshopping.model.graphql.InstantShoppingGraphQLInterfaces.InstantShoppingCompositeBlockElementFragment;
import com.facebook.instantshopping.model.graphql.InstantShoppingGraphQLInterfaces.InstantShoppingDocumentExpandableSectionElementFragment;
import com.facebook.instantshopping.model.graphql.InstantShoppingGraphQLInterfaces.InstantShoppingFooterElementFragment;
import com.facebook.instantshopping.model.graphql.InstantShoppingGraphQLInterfaces.InstantShoppingHeaderElementFragment;
import com.facebook.instantshopping.model.graphql.InstantShoppingGraphQLInterfaces.InstantShoppingPhotoElementFragment;
import com.facebook.instantshopping.model.graphql.InstantShoppingGraphQLInterfaces.InstantShoppingTextElementFragment;
import com.facebook.instantshopping.model.graphql.InstantShoppingGraphQLInterfaces.InstantShoppingToggleElementFragment;
import com.facebook.instantshopping.model.graphql.InstantShoppingGraphQLParsers.InstantShoppingActionFragmentParser;
import com.facebook.instantshopping.model.graphql.InstantShoppingGraphQLParsers.InstantShoppingCatalogQueryParser;
import com.facebook.instantshopping.model.graphql.InstantShoppingGraphQLParsers.InstantShoppingColorSelectorColorFragmentParser;
import com.facebook.instantshopping.model.graphql.InstantShoppingGraphQLParsers.InstantShoppingCompositeBlockElementFragmentParser;
import com.facebook.instantshopping.model.graphql.InstantShoppingGraphQLParsers.InstantShoppingCompositeBlockElementFragmentParser.BlockElementsParser;
import com.facebook.instantshopping.model.graphql.InstantShoppingGraphQLParsers.InstantShoppingDocumentFragmentParser;
import com.facebook.instantshopping.model.graphql.InstantShoppingGraphQLParsers.InstantShoppingDocumentFragmentParser.DocumentBodyElementsParser;
import com.facebook.instantshopping.model.graphql.InstantShoppingGraphQLParsers.InstantShoppingDocumentFragmentParser.FooterElementsParser;
import com.facebook.instantshopping.model.graphql.InstantShoppingGraphQLParsers.InstantShoppingDocumentFragmentParser.FooterParser;
import com.facebook.instantshopping.model.graphql.InstantShoppingGraphQLParsers.InstantShoppingDocumentFragmentParser.HeaderElementsParser;
import com.facebook.instantshopping.model.graphql.InstantShoppingGraphQLParsers.InstantShoppingElementDescriptorFragmentParser;
import com.facebook.instantshopping.model.graphql.InstantShoppingGraphQLParsers.InstantShoppingFontObjectFragmentParser;
import com.facebook.instantshopping.model.graphql.InstantShoppingGraphQLParsers.InstantShoppingFooterElementFragmentParser;
import com.facebook.instantshopping.model.graphql.InstantShoppingGraphQLParsers.InstantShoppingHeaderElementFragmentParser;
import com.facebook.instantshopping.model.graphql.InstantShoppingGraphQLParsers.InstantShoppingOptionsActionFragmentParser;
import com.facebook.instantshopping.model.graphql.InstantShoppingGraphQLParsers.InstantShoppingPhotoElementFragmentParser;
import com.facebook.instantshopping.model.graphql.InstantShoppingGraphQLParsers.InstantShoppingPhotoElementFragmentParser.ElementPhotoParser;
import com.facebook.instantshopping.model.graphql.InstantShoppingGraphQLParsers.InstantShoppingProductQueryParser;
import com.facebook.instantshopping.model.graphql.InstantShoppingGraphQLParsers.InstantShoppingSelectorOptionsFragmentParser;
import com.facebook.instantshopping.model.graphql.InstantShoppingGraphQLParsers.InstantShoppingTextElementFragmentParser;
import com.facebook.instantshopping.model.graphql.InstantShoppingGraphQLParsers.InstantShoppingTextMetricsDescriptorFragmentParser;
import com.facebook.instantshopping.model.graphql.InstantShoppingGraphQLParsers.RichMediaDocumentQueryParser;
import com.facebook.instantshopping.model.graphql.InstantShoppingGraphQLParsers.ShoppingDocumentElementsEdgeParser;
import com.facebook.instantshopping.model.graphql.InstantShoppingGraphQLParsers.ShoppingDocumentElementsEdgeParser.NodeParser;
import com.facebook.richdocument.model.graphql.RichDocumentGraphQlInterfaces.FBVideo;
import com.facebook.richdocument.model.graphql.RichDocumentGraphQlInterfaces.RichDocumentText;
import com.facebook.richdocument.model.graphql.RichDocumentGraphQlModels.FBVideoModel;
import com.facebook.richdocument.model.graphql.RichDocumentGraphQlModels.RichDocumentTextModel;
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

/* compiled from: upload_date */
public class InstantShoppingGraphQLModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 1866480884)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: upload_date */
    public final class InstantShoppingActionFragmentModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private GraphQLObjectType f871d;
        @Nullable
        private GraphQLInstantShoppingActionType f872e;
        @Nullable
        private GraphQLInstantShoppingPostActionNoticeStyle f873f;
        @Nullable
        private String f874g;
        @Nullable
        private List<InstantShoppingSelectorOptionsFragmentModel> f875h;
        @Nullable
        private String f876i;
        private boolean f877j;
        @Nullable
        private String f878k;
        @Nullable
        private String f879l;

        /* compiled from: upload_date */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(InstantShoppingActionFragmentModel.class, new Deserializer());
            }

            public Object m893a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(InstantShoppingActionFragmentParser.m1277a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object instantShoppingActionFragmentModel = new InstantShoppingActionFragmentModel();
                ((BaseModel) instantShoppingActionFragmentModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (instantShoppingActionFragmentModel instanceof Postprocessable) {
                    return ((Postprocessable) instantShoppingActionFragmentModel).a();
                }
                return instantShoppingActionFragmentModel;
            }
        }

        /* compiled from: upload_date */
        public class Serializer extends JsonSerializer<InstantShoppingActionFragmentModel> {
            public final void m894a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                InstantShoppingActionFragmentModel instantShoppingActionFragmentModel = (InstantShoppingActionFragmentModel) obj;
                if (instantShoppingActionFragmentModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(instantShoppingActionFragmentModel.m898a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    instantShoppingActionFragmentModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                InstantShoppingActionFragmentParser.m1278a(instantShoppingActionFragmentModel.w_(), instantShoppingActionFragmentModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(InstantShoppingActionFragmentModel.class, new Serializer());
            }
        }

        public InstantShoppingActionFragmentModel() {
            super(9);
        }

        @Nullable
        private GraphQLObjectType m895j() {
            if (this.b != null && this.f871d == null) {
                this.f871d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
            }
            return this.f871d;
        }

        @Nullable
        public final GraphQLInstantShoppingActionType m899a() {
            this.f872e = (GraphQLInstantShoppingActionType) super.b(this.f872e, 1, GraphQLInstantShoppingActionType.class, GraphQLInstantShoppingActionType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
            return this.f872e;
        }

        @Nullable
        private GraphQLInstantShoppingPostActionNoticeStyle m896k() {
            this.f873f = (GraphQLInstantShoppingPostActionNoticeStyle) super.b(this.f873f, 2, GraphQLInstantShoppingPostActionNoticeStyle.class, GraphQLInstantShoppingPostActionNoticeStyle.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
            return this.f873f;
        }

        @Nullable
        private String m897l() {
            this.f874g = super.a(this.f874g, 3);
            return this.f874g;
        }

        @Nonnull
        public final ImmutableList<InstantShoppingSelectorOptionsFragmentModel> m902b() {
            this.f875h = super.a(this.f875h, 4, InstantShoppingSelectorOptionsFragmentModel.class);
            return (ImmutableList) this.f875h;
        }

        @Nullable
        public final String m903c() {
            this.f876i = super.a(this.f876i, 5);
            return this.f876i;
        }

        public final boolean m904d() {
            a(0, 6);
            return this.f877j;
        }

        @Nullable
        public final String iG_() {
            this.f878k = super.a(this.f878k, 7);
            return this.f878k;
        }

        @Nullable
        public final String m905g() {
            this.f879l = super.a(this.f879l, 8);
            return this.f879l;
        }

        public final int jK_() {
            return 1940230623;
        }

        public final GraphQLVisitableModel m900a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m902b() != null) {
                Builder a = ModelHelper.a(m902b(), graphQLModelMutatingVisitor);
                if (a != null) {
                    graphQLVisitableModel = (InstantShoppingActionFragmentModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f875h = a.b();
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m898a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m895j());
            int a2 = flatBufferBuilder.a(m899a());
            int a3 = flatBufferBuilder.a(m896k());
            int b = flatBufferBuilder.b(m897l());
            int a4 = ModelHelper.a(flatBufferBuilder, m902b());
            int b2 = flatBufferBuilder.b(m903c());
            int b3 = flatBufferBuilder.b(iG_());
            int b4 = flatBufferBuilder.b(m905g());
            flatBufferBuilder.c(9);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, a2);
            flatBufferBuilder.b(2, a3);
            flatBufferBuilder.b(3, b);
            flatBufferBuilder.b(4, a4);
            flatBufferBuilder.b(5, b2);
            flatBufferBuilder.a(6, this.f877j);
            flatBufferBuilder.b(7, b3);
            flatBufferBuilder.b(8, b4);
            i();
            return flatBufferBuilder.d();
        }

        public final void m901a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
            super.a(mutableFlatBuffer, i, obj);
            this.f877j = mutableFlatBuffer.a(i, 6);
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -227134155)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: upload_date */
    public final class InstantShoppingCatalogQueryModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private InstantShoppingDocumentFragmentModel f880d;

        /* compiled from: upload_date */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(InstantShoppingCatalogQueryModel.class, new Deserializer());
            }

            public Object m906a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = InstantShoppingCatalogQueryParser.m1279a(jsonParser);
                Object instantShoppingCatalogQueryModel = new InstantShoppingCatalogQueryModel();
                ((BaseModel) instantShoppingCatalogQueryModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (instantShoppingCatalogQueryModel instanceof Postprocessable) {
                    return ((Postprocessable) instantShoppingCatalogQueryModel).a();
                }
                return instantShoppingCatalogQueryModel;
            }
        }

        /* compiled from: upload_date */
        public class Serializer extends JsonSerializer<InstantShoppingCatalogQueryModel> {
            public final void m907a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                InstantShoppingCatalogQueryModel instantShoppingCatalogQueryModel = (InstantShoppingCatalogQueryModel) obj;
                if (instantShoppingCatalogQueryModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(instantShoppingCatalogQueryModel.m908a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    instantShoppingCatalogQueryModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = instantShoppingCatalogQueryModel.w_();
                int u_ = instantShoppingCatalogQueryModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("catalog_document");
                    InstantShoppingDocumentFragmentParser.m1300a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(InstantShoppingCatalogQueryModel.class, new Serializer());
            }
        }

        public InstantShoppingCatalogQueryModel() {
            super(1);
        }

        @Nullable
        public final InstantShoppingDocumentFragmentModel m910a() {
            this.f880d = (InstantShoppingDocumentFragmentModel) super.a(this.f880d, 0, InstantShoppingDocumentFragmentModel.class);
            return this.f880d;
        }

        public final int jK_() {
            return 1735115152;
        }

        public final GraphQLVisitableModel m909a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m910a() != null) {
                InstantShoppingDocumentFragmentModel instantShoppingDocumentFragmentModel = (InstantShoppingDocumentFragmentModel) graphQLModelMutatingVisitor.b(m910a());
                if (m910a() != instantShoppingDocumentFragmentModel) {
                    graphQLVisitableModel = (InstantShoppingCatalogQueryModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f880d = instantShoppingDocumentFragmentModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m908a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m910a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 266556989)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: upload_date */
    public final class InstantShoppingColorSelectorColorFragmentModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private InstantShoppingActionFragmentModel f881d;
        @Nullable
        private String f882e;
        @Nullable
        private FBFullImageFragmentModel f883f;
        @Nullable
        private String f884g;
        @Nullable
        private String f885h;

        /* compiled from: upload_date */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(InstantShoppingColorSelectorColorFragmentModel.class, new Deserializer());
            }

            public Object m911a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(InstantShoppingColorSelectorColorFragmentParser.m1282b(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object instantShoppingColorSelectorColorFragmentModel = new InstantShoppingColorSelectorColorFragmentModel();
                ((BaseModel) instantShoppingColorSelectorColorFragmentModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (instantShoppingColorSelectorColorFragmentModel instanceof Postprocessable) {
                    return ((Postprocessable) instantShoppingColorSelectorColorFragmentModel).a();
                }
                return instantShoppingColorSelectorColorFragmentModel;
            }
        }

        /* compiled from: upload_date */
        public class Serializer extends JsonSerializer<InstantShoppingColorSelectorColorFragmentModel> {
            public final void m912a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                InstantShoppingColorSelectorColorFragmentModel instantShoppingColorSelectorColorFragmentModel = (InstantShoppingColorSelectorColorFragmentModel) obj;
                if (instantShoppingColorSelectorColorFragmentModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(instantShoppingColorSelectorColorFragmentModel.m915a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    instantShoppingColorSelectorColorFragmentModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                InstantShoppingColorSelectorColorFragmentParser.m1283b(instantShoppingColorSelectorColorFragmentModel.w_(), instantShoppingColorSelectorColorFragmentModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(InstantShoppingColorSelectorColorFragmentModel.class, new Serializer());
            }
        }

        @Nullable
        public final /* synthetic */ InstantShoppingActionFragmentModel m917a() {
            return m913j();
        }

        @Nullable
        public final /* synthetic */ FBFullImageFragmentModel m919c() {
            return m914k();
        }

        public InstantShoppingColorSelectorColorFragmentModel() {
            super(5);
        }

        @Nullable
        private InstantShoppingActionFragmentModel m913j() {
            this.f881d = (InstantShoppingActionFragmentModel) super.a(this.f881d, 0, InstantShoppingActionFragmentModel.class);
            return this.f881d;
        }

        @Nullable
        public final String m918b() {
            this.f882e = super.a(this.f882e, 1);
            return this.f882e;
        }

        @Nullable
        private FBFullImageFragmentModel m914k() {
            this.f883f = (FBFullImageFragmentModel) super.a(this.f883f, 2, FBFullImageFragmentModel.class);
            return this.f883f;
        }

        @Nullable
        public final String m920d() {
            this.f884g = super.a(this.f884g, 3);
            return this.f884g;
        }

        @Nullable
        public final String iH_() {
            this.f885h = super.a(this.f885h, 4);
            return this.f885h;
        }

        public final int jK_() {
            return 1438193226;
        }

        public final GraphQLVisitableModel m916a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m913j() != null) {
                InstantShoppingActionFragmentModel instantShoppingActionFragmentModel = (InstantShoppingActionFragmentModel) graphQLModelMutatingVisitor.b(m913j());
                if (m913j() != instantShoppingActionFragmentModel) {
                    graphQLVisitableModel = (InstantShoppingColorSelectorColorFragmentModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f881d = instantShoppingActionFragmentModel;
                }
            }
            if (m914k() != null) {
                FBFullImageFragmentModel fBFullImageFragmentModel = (FBFullImageFragmentModel) graphQLModelMutatingVisitor.b(m914k());
                if (m914k() != fBFullImageFragmentModel) {
                    graphQLVisitableModel = (InstantShoppingColorSelectorColorFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f883f = fBFullImageFragmentModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m915a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m913j());
            int b = flatBufferBuilder.b(m918b());
            int a2 = ModelHelper.a(flatBufferBuilder, m914k());
            int b2 = flatBufferBuilder.b(m920d());
            int b3 = flatBufferBuilder.b(iH_());
            flatBufferBuilder.c(5);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, b);
            flatBufferBuilder.b(2, a2);
            flatBufferBuilder.b(3, b2);
            flatBufferBuilder.b(4, b3);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -189495686)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: upload_date */
    public final class InstantShoppingCompositeBlockElementFragmentModel extends BaseModel implements GraphQLVisitableModel, InstantShoppingCompositeBlockElementFragment {
        @Nullable
        private List<BlockElementsModel> f908d;
        @Nullable
        private GraphQLInstantShoppingDocumentElementType f909e;
        @Nullable
        private InstantShoppingElementDescriptorFragmentModel f910f;
        private int f911g;
        @Nullable
        private String f912h;

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1941858539)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: upload_date */
        public final class BlockElementsModel extends BaseModel implements GraphQLVisitableModel, InstantShoppingButtonElementFragment, InstantShoppingColorSelectorElementFragment, InstantShoppingDocumentExpandableSectionElementFragment, InstantShoppingPhotoElementFragment, InstantShoppingTextElementFragment {
            @Nullable
            private GraphQLObjectType f886d;
            @Nullable
            private InstantShoppingActionFragmentModel f887e;
            @Nullable
            private List<InstantShoppingTextElementFragmentModel> f888f;
            @Nullable
            private GraphQLDocumentVideoAutoplayStyle f889g;
            @Nullable
            private List<InstantShoppingPhotoElementFragmentModel> f890h;
            @Nullable
            private String f891i;
            @Nullable
            private List<InstantShoppingColorSelectorColorFragmentModel> f892j;
            @Nullable
            private InstantShoppingTextElementFragmentModel f893k;
            @Nullable
            private GraphQLDocumentVideoControlStyle f894l;
            @Nullable
            private GraphQLInstantShoppingDocumentElementType f895m;
            @Nullable
            private InstantShoppingElementDescriptorFragmentModel f896n;
            @Nullable
            private ElementPhotoModel f897o;
            @Nullable
            private RichDocumentTextModel f898p;
            @Nullable
            private FBVideoModel f899q;
            private int f900r;
            @Nullable
            private FBFullImageFragmentModel f901s;
            @Nullable
            private String f902t;
            @Nullable
            private GraphQLDocumentVideoLoopingStyle f903u;
            @Nullable
            private InstantShoppingTextElementFragmentModel f904v;
            private int f905w;
            @Nullable
            private List<GraphQLInstantShoppingPresentationStyle> f906x;
            @Nullable
            private String f907y;

            /* compiled from: upload_date */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(BlockElementsModel.class, new Deserializer());
                }

                public Object m921a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(BlockElementsParser.m1286b(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object blockElementsModel = new BlockElementsModel();
                    ((BaseModel) blockElementsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (blockElementsModel instanceof Postprocessable) {
                        return ((Postprocessable) blockElementsModel).a();
                    }
                    return blockElementsModel;
                }
            }

            /* compiled from: upload_date */
            public class Serializer extends JsonSerializer<BlockElementsModel> {
                public final void m922a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    BlockElementsModel blockElementsModel = (BlockElementsModel) obj;
                    if (blockElementsModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(blockElementsModel.m937a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        blockElementsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    BlockElementsParser.m1287b(blockElementsModel.w_(), blockElementsModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(BlockElementsModel.class, new Serializer());
                }
            }

            @Nullable
            public final /* synthetic */ InstantShoppingActionFragmentModel mo28a() {
                return m928r();
            }

            @Nullable
            public final /* synthetic */ InstantShoppingElementDescriptorFragmentModel mo31d() {
                return m933w();
            }

            @Nullable
            public final /* synthetic */ RichDocumentText iK_() {
                return m935y();
            }

            @Nullable
            public final /* synthetic */ ElementPhotoModel mo39m() {
                return m934x();
            }

            @Nullable
            public final /* synthetic */ FBFullImageFragmentModel mo40n() {
                return m923A();
            }

            @Nullable
            public final /* synthetic */ InstantShoppingTextElementFragment mo41o() {
                return m931u();
            }

            @Nullable
            public final /* synthetic */ InstantShoppingTextElementFragment mo42p() {
                return m925C();
            }

            public BlockElementsModel() {
                super(22);
            }

            @Nullable
            private GraphQLObjectType m927q() {
                if (this.b != null && this.f886d == null) {
                    this.f886d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
                }
                return this.f886d;
            }

            @Nullable
            private InstantShoppingActionFragmentModel m928r() {
                this.f887e = (InstantShoppingActionFragmentModel) super.a(this.f887e, 1, InstantShoppingActionFragmentModel.class);
                return this.f887e;
            }

            @Nonnull
            public final ImmutableList<InstantShoppingTextElementFragmentModel> mo38l() {
                this.f888f = super.a(this.f888f, 2, InstantShoppingTextElementFragmentModel.class);
                return (ImmutableList) this.f888f;
            }

            @Nullable
            private GraphQLDocumentVideoAutoplayStyle m929s() {
                this.f889g = (GraphQLDocumentVideoAutoplayStyle) super.b(this.f889g, 3, GraphQLDocumentVideoAutoplayStyle.class, GraphQLDocumentVideoAutoplayStyle.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
                return this.f889g;
            }

            @Nonnull
            private ImmutableList<InstantShoppingPhotoElementFragmentModel> m930t() {
                this.f890h = super.a(this.f890h, 4, InstantShoppingPhotoElementFragmentModel.class);
                return (ImmutableList) this.f890h;
            }

            @Nullable
            public final String mo29b() {
                this.f891i = super.a(this.f891i, 5);
                return this.f891i;
            }

            @Nonnull
            public final ImmutableList<InstantShoppingColorSelectorColorFragmentModel> mo36j() {
                this.f892j = super.a(this.f892j, 6, InstantShoppingColorSelectorColorFragmentModel.class);
                return (ImmutableList) this.f892j;
            }

            @Nullable
            private InstantShoppingTextElementFragmentModel m931u() {
                this.f893k = (InstantShoppingTextElementFragmentModel) super.a(this.f893k, 7, InstantShoppingTextElementFragmentModel.class);
                return this.f893k;
            }

            @Nullable
            private GraphQLDocumentVideoControlStyle m932v() {
                this.f894l = (GraphQLDocumentVideoControlStyle) super.b(this.f894l, 8, GraphQLDocumentVideoControlStyle.class, GraphQLDocumentVideoControlStyle.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
                return this.f894l;
            }

            @Nullable
            public final GraphQLInstantShoppingDocumentElementType mo30c() {
                this.f895m = (GraphQLInstantShoppingDocumentElementType) super.b(this.f895m, 9, GraphQLInstantShoppingDocumentElementType.class, GraphQLInstantShoppingDocumentElementType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
                return this.f895m;
            }

            @Nullable
            private InstantShoppingElementDescriptorFragmentModel m933w() {
                this.f896n = (InstantShoppingElementDescriptorFragmentModel) super.a(this.f896n, 10, InstantShoppingElementDescriptorFragmentModel.class);
                return this.f896n;
            }

            @Nullable
            private ElementPhotoModel m934x() {
                this.f897o = (ElementPhotoModel) super.a(this.f897o, 11, ElementPhotoModel.class);
                return this.f897o;
            }

            @Nullable
            private RichDocumentTextModel m935y() {
                this.f898p = (RichDocumentTextModel) super.a(this.f898p, 12, RichDocumentTextModel.class);
                return this.f898p;
            }

            @Nullable
            private FBVideoModel m936z() {
                this.f899q = (FBVideoModel) super.a(this.f899q, 13, FBVideoModel.class);
                return this.f899q;
            }

            public final int mo32g() {
                a(1, 6);
                return this.f900r;
            }

            @Nullable
            private FBFullImageFragmentModel m923A() {
                this.f901s = (FBFullImageFragmentModel) super.a(this.f901s, 15, FBFullImageFragmentModel.class);
                return this.f901s;
            }

            @Nullable
            public final String iI_() {
                this.f902t = super.a(this.f902t, 16);
                return this.f902t;
            }

            @Nullable
            private GraphQLDocumentVideoLoopingStyle m924B() {
                this.f903u = (GraphQLDocumentVideoLoopingStyle) super.b(this.f903u, 17, GraphQLDocumentVideoLoopingStyle.class, GraphQLDocumentVideoLoopingStyle.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
                return this.f903u;
            }

            @Nullable
            private InstantShoppingTextElementFragmentModel m925C() {
                this.f904v = (InstantShoppingTextElementFragmentModel) super.a(this.f904v, 18, InstantShoppingTextElementFragmentModel.class);
                return this.f904v;
            }

            public final int mo37k() {
                a(2, 3);
                return this.f905w;
            }

            @Nonnull
            public final ImmutableList<GraphQLInstantShoppingPresentationStyle> iJ_() {
                this.f906x = super.c(this.f906x, 20, GraphQLInstantShoppingPresentationStyle.class);
                return (ImmutableList) this.f906x;
            }

            @Nullable
            private String m926D() {
                this.f907y = super.a(this.f907y, 21);
                return this.f907y;
            }

            public final int jK_() {
                return 1808563160;
            }

            public final GraphQLVisitableModel m938a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                Builder a;
                InstantShoppingTextElementFragmentModel instantShoppingTextElementFragmentModel;
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m928r() != null) {
                    InstantShoppingActionFragmentModel instantShoppingActionFragmentModel = (InstantShoppingActionFragmentModel) graphQLModelMutatingVisitor.b(m928r());
                    if (m928r() != instantShoppingActionFragmentModel) {
                        graphQLVisitableModel = (BlockElementsModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f887e = instantShoppingActionFragmentModel;
                    }
                }
                if (mo38l() != null) {
                    a = ModelHelper.a(mo38l(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        BlockElementsModel blockElementsModel = (BlockElementsModel) ModelHelper.a(graphQLVisitableModel, this);
                        blockElementsModel.f888f = a.b();
                        graphQLVisitableModel = blockElementsModel;
                    }
                }
                if (m930t() != null) {
                    a = ModelHelper.a(m930t(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        blockElementsModel = (BlockElementsModel) ModelHelper.a(graphQLVisitableModel, this);
                        blockElementsModel.f890h = a.b();
                        graphQLVisitableModel = blockElementsModel;
                    }
                }
                if (mo36j() != null) {
                    a = ModelHelper.a(mo36j(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        blockElementsModel = (BlockElementsModel) ModelHelper.a(graphQLVisitableModel, this);
                        blockElementsModel.f892j = a.b();
                        graphQLVisitableModel = blockElementsModel;
                    }
                }
                if (m931u() != null) {
                    instantShoppingTextElementFragmentModel = (InstantShoppingTextElementFragmentModel) graphQLModelMutatingVisitor.b(m931u());
                    if (m931u() != instantShoppingTextElementFragmentModel) {
                        graphQLVisitableModel = (BlockElementsModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f893k = instantShoppingTextElementFragmentModel;
                    }
                }
                if (m933w() != null) {
                    InstantShoppingElementDescriptorFragmentModel instantShoppingElementDescriptorFragmentModel = (InstantShoppingElementDescriptorFragmentModel) graphQLModelMutatingVisitor.b(m933w());
                    if (m933w() != instantShoppingElementDescriptorFragmentModel) {
                        graphQLVisitableModel = (BlockElementsModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f896n = instantShoppingElementDescriptorFragmentModel;
                    }
                }
                if (m934x() != null) {
                    ElementPhotoModel elementPhotoModel = (ElementPhotoModel) graphQLModelMutatingVisitor.b(m934x());
                    if (m934x() != elementPhotoModel) {
                        graphQLVisitableModel = (BlockElementsModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f897o = elementPhotoModel;
                    }
                }
                if (m935y() != null) {
                    RichDocumentTextModel richDocumentTextModel = (RichDocumentTextModel) graphQLModelMutatingVisitor.b(m935y());
                    if (m935y() != richDocumentTextModel) {
                        graphQLVisitableModel = (BlockElementsModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f898p = richDocumentTextModel;
                    }
                }
                if (m936z() != null) {
                    FBVideoModel fBVideoModel = (FBVideoModel) graphQLModelMutatingVisitor.b(m936z());
                    if (m936z() != fBVideoModel) {
                        graphQLVisitableModel = (BlockElementsModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f899q = fBVideoModel;
                    }
                }
                if (m923A() != null) {
                    FBFullImageFragmentModel fBFullImageFragmentModel = (FBFullImageFragmentModel) graphQLModelMutatingVisitor.b(m923A());
                    if (m923A() != fBFullImageFragmentModel) {
                        graphQLVisitableModel = (BlockElementsModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f901s = fBFullImageFragmentModel;
                    }
                }
                if (m925C() != null) {
                    instantShoppingTextElementFragmentModel = (InstantShoppingTextElementFragmentModel) graphQLModelMutatingVisitor.b(m925C());
                    if (m925C() != instantShoppingTextElementFragmentModel) {
                        graphQLVisitableModel = (BlockElementsModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f904v = instantShoppingTextElementFragmentModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m937a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m927q());
                int a2 = ModelHelper.a(flatBufferBuilder, m928r());
                int a3 = ModelHelper.a(flatBufferBuilder, mo38l());
                int a4 = flatBufferBuilder.a(m929s());
                int a5 = ModelHelper.a(flatBufferBuilder, m930t());
                int b = flatBufferBuilder.b(mo29b());
                int a6 = ModelHelper.a(flatBufferBuilder, mo36j());
                int a7 = ModelHelper.a(flatBufferBuilder, m931u());
                int a8 = flatBufferBuilder.a(m932v());
                int a9 = flatBufferBuilder.a(mo30c());
                int a10 = ModelHelper.a(flatBufferBuilder, m933w());
                int a11 = ModelHelper.a(flatBufferBuilder, m934x());
                int a12 = ModelHelper.a(flatBufferBuilder, m935y());
                int a13 = ModelHelper.a(flatBufferBuilder, m936z());
                int a14 = ModelHelper.a(flatBufferBuilder, m923A());
                int b2 = flatBufferBuilder.b(iI_());
                int a15 = flatBufferBuilder.a(m924B());
                int a16 = ModelHelper.a(flatBufferBuilder, m925C());
                int d = flatBufferBuilder.d(iJ_());
                int b3 = flatBufferBuilder.b(m926D());
                flatBufferBuilder.c(22);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.b(1, a2);
                flatBufferBuilder.b(2, a3);
                flatBufferBuilder.b(3, a4);
                flatBufferBuilder.b(4, a5);
                flatBufferBuilder.b(5, b);
                flatBufferBuilder.b(6, a6);
                flatBufferBuilder.b(7, a7);
                flatBufferBuilder.b(8, a8);
                flatBufferBuilder.b(9, a9);
                flatBufferBuilder.b(10, a10);
                flatBufferBuilder.b(11, a11);
                flatBufferBuilder.b(12, a12);
                flatBufferBuilder.b(13, a13);
                flatBufferBuilder.a(14, this.f900r, 0);
                flatBufferBuilder.b(15, a14);
                flatBufferBuilder.b(16, b2);
                flatBufferBuilder.b(17, a15);
                flatBufferBuilder.b(18, a16);
                flatBufferBuilder.a(19, this.f905w, 0);
                flatBufferBuilder.b(20, d);
                flatBufferBuilder.b(21, b3);
                i();
                return flatBufferBuilder.d();
            }

            public final void m940a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                super.a(mutableFlatBuffer, i, obj);
                this.f900r = mutableFlatBuffer.a(i, 14, 0);
                this.f905w = mutableFlatBuffer.a(i, 19, 0);
            }
        }

        /* compiled from: upload_date */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(InstantShoppingCompositeBlockElementFragmentModel.class, new Deserializer());
            }

            public Object m952a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(InstantShoppingCompositeBlockElementFragmentParser.m1288a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object instantShoppingCompositeBlockElementFragmentModel = new InstantShoppingCompositeBlockElementFragmentModel();
                ((BaseModel) instantShoppingCompositeBlockElementFragmentModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (instantShoppingCompositeBlockElementFragmentModel instanceof Postprocessable) {
                    return ((Postprocessable) instantShoppingCompositeBlockElementFragmentModel).a();
                }
                return instantShoppingCompositeBlockElementFragmentModel;
            }
        }

        /* compiled from: upload_date */
        public class Serializer extends JsonSerializer<InstantShoppingCompositeBlockElementFragmentModel> {
            public final void m953a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                InstantShoppingCompositeBlockElementFragmentModel instantShoppingCompositeBlockElementFragmentModel = (InstantShoppingCompositeBlockElementFragmentModel) obj;
                if (instantShoppingCompositeBlockElementFragmentModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(instantShoppingCompositeBlockElementFragmentModel.m955a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    instantShoppingCompositeBlockElementFragmentModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = instantShoppingCompositeBlockElementFragmentModel.w_();
                int u_ = instantShoppingCompositeBlockElementFragmentModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("block_elements");
                    BlockElementsParser.m1285a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                if (mutableFlatBuffer.g(u_, 1) != 0) {
                    jsonGenerator.a("document_element_type");
                    jsonGenerator.b(mutableFlatBuffer.b(u_, 1));
                }
                g = mutableFlatBuffer.g(u_, 2);
                if (g != 0) {
                    jsonGenerator.a("element_descriptor");
                    InstantShoppingElementDescriptorFragmentParser.m1302a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                g = mutableFlatBuffer.a(u_, 3, 0);
                if (g != 0) {
                    jsonGenerator.a("grid_width_percent");
                    jsonGenerator.b(g);
                }
                if (mutableFlatBuffer.g(u_, 4) != 0) {
                    jsonGenerator.a("logging_token");
                    jsonGenerator.b(mutableFlatBuffer.c(u_, 4));
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(InstantShoppingCompositeBlockElementFragmentModel.class, new Serializer());
            }
        }

        @Nullable
        public final /* synthetic */ InstantShoppingElementDescriptorFragmentModel mo44d() {
            return m954a();
        }

        public InstantShoppingCompositeBlockElementFragmentModel() {
            super(5);
        }

        @Nonnull
        public final ImmutableList<BlockElementsModel> iF_() {
            this.f908d = super.a(this.f908d, 0, BlockElementsModel.class);
            return (ImmutableList) this.f908d;
        }

        @Nullable
        public final GraphQLInstantShoppingDocumentElementType mo43c() {
            this.f909e = (GraphQLInstantShoppingDocumentElementType) super.b(this.f909e, 1, GraphQLInstantShoppingDocumentElementType.class, GraphQLInstantShoppingDocumentElementType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
            return this.f909e;
        }

        @Nullable
        private InstantShoppingElementDescriptorFragmentModel m954a() {
            this.f910f = (InstantShoppingElementDescriptorFragmentModel) super.a(this.f910f, 2, InstantShoppingElementDescriptorFragmentModel.class);
            return this.f910f;
        }

        public final int mo45g() {
            a(0, 3);
            return this.f911g;
        }

        @Nullable
        public final String iI_() {
            this.f912h = super.a(this.f912h, 4);
            return this.f912h;
        }

        public final int jK_() {
            return 778855181;
        }

        public final GraphQLVisitableModel m956a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel;
            InstantShoppingElementDescriptorFragmentModel instantShoppingElementDescriptorFragmentModel;
            h();
            if (iF_() != null) {
                Builder a = ModelHelper.a(iF_(), graphQLModelMutatingVisitor);
                if (a != null) {
                    InstantShoppingCompositeBlockElementFragmentModel instantShoppingCompositeBlockElementFragmentModel = (InstantShoppingCompositeBlockElementFragmentModel) ModelHelper.a(null, this);
                    instantShoppingCompositeBlockElementFragmentModel.f908d = a.b();
                    graphQLVisitableModel = instantShoppingCompositeBlockElementFragmentModel;
                    if (m954a() != null) {
                        instantShoppingElementDescriptorFragmentModel = (InstantShoppingElementDescriptorFragmentModel) graphQLModelMutatingVisitor.b(m954a());
                        if (m954a() != instantShoppingElementDescriptorFragmentModel) {
                            graphQLVisitableModel = (InstantShoppingCompositeBlockElementFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                            graphQLVisitableModel.f910f = instantShoppingElementDescriptorFragmentModel;
                        }
                    }
                    i();
                    return graphQLVisitableModel != null ? this : graphQLVisitableModel;
                }
            }
            graphQLVisitableModel = null;
            if (m954a() != null) {
                instantShoppingElementDescriptorFragmentModel = (InstantShoppingElementDescriptorFragmentModel) graphQLModelMutatingVisitor.b(m954a());
                if (m954a() != instantShoppingElementDescriptorFragmentModel) {
                    graphQLVisitableModel = (InstantShoppingCompositeBlockElementFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f910f = instantShoppingElementDescriptorFragmentModel;
                }
            }
            i();
            if (graphQLVisitableModel != null) {
            }
        }

        public final int m955a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, iF_());
            int a2 = flatBufferBuilder.a(mo43c());
            int a3 = ModelHelper.a(flatBufferBuilder, m954a());
            int b = flatBufferBuilder.b(iI_());
            flatBufferBuilder.c(5);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, a2);
            flatBufferBuilder.b(2, a3);
            flatBufferBuilder.a(3, this.f911g, 0);
            flatBufferBuilder.b(4, b);
            i();
            return flatBufferBuilder.d();
        }

        public final void m957a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
            super.a(mutableFlatBuffer, i, obj);
            this.f911g = mutableFlatBuffer.a(i, 3, 0);
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 915043731)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: upload_date */
    public final class InstantShoppingDocumentFragmentModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private String f948d;
        @Nullable
        private List<InstantShoppingFontObjectFragmentModel> f949e;
        @Nullable
        private DocumentBodyElementsModel f950f;
        @Nullable
        private FooterModel f951g;
        @Nullable
        private List<FooterElementsModel> f952h;
        @Nullable
        private List<HeaderElementsModel> f953i;
        private boolean f954j;
        @Nullable
        private List<GraphQLInstantShoppingDocumentPresentationStyle> f955k;
        @Nullable
        private List<String> f956l;
        @Nullable
        private String f957m;

        /* compiled from: upload_date */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(InstantShoppingDocumentFragmentModel.class, new Deserializer());
            }

            public Object m961a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(InstantShoppingDocumentFragmentParser.m1299a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object instantShoppingDocumentFragmentModel = new InstantShoppingDocumentFragmentModel();
                ((BaseModel) instantShoppingDocumentFragmentModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (instantShoppingDocumentFragmentModel instanceof Postprocessable) {
                    return ((Postprocessable) instantShoppingDocumentFragmentModel).a();
                }
                return instantShoppingDocumentFragmentModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -975919072)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: upload_date */
        public final class DocumentBodyElementsModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private List<ShoppingDocumentElementsEdgeModel> f913d;

            /* compiled from: upload_date */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(DocumentBodyElementsModel.class, new Deserializer());
                }

                public Object m962a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(DocumentBodyElementsParser.m1289a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object documentBodyElementsModel = new DocumentBodyElementsModel();
                    ((BaseModel) documentBodyElementsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (documentBodyElementsModel instanceof Postprocessable) {
                        return ((Postprocessable) documentBodyElementsModel).a();
                    }
                    return documentBodyElementsModel;
                }
            }

            /* compiled from: upload_date */
            public class Serializer extends JsonSerializer<DocumentBodyElementsModel> {
                public final void m963a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    DocumentBodyElementsModel documentBodyElementsModel = (DocumentBodyElementsModel) obj;
                    if (documentBodyElementsModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(documentBodyElementsModel.m964a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        documentBodyElementsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    DocumentBodyElementsParser.m1290a(documentBodyElementsModel.w_(), documentBodyElementsModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(DocumentBodyElementsModel.class, new Serializer());
                }
            }

            public DocumentBodyElementsModel() {
                super(1);
            }

            @Nonnull
            public final ImmutableList<ShoppingDocumentElementsEdgeModel> m966a() {
                this.f913d = super.a(this.f913d, 0, ShoppingDocumentElementsEdgeModel.class);
                return (ImmutableList) this.f913d;
            }

            public final int jK_() {
                return -1828796584;
            }

            public final GraphQLVisitableModel m965a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m966a() != null) {
                    Builder a = ModelHelper.a(m966a(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        graphQLVisitableModel = (DocumentBodyElementsModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f913d = a.b();
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m964a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m966a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, a);
                i();
                return flatBufferBuilder.d();
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 1952405810)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: upload_date */
        public final class FooterElementsModel extends BaseModel implements GraphQLVisitableModel, InstantShoppingButtonElementFragment, InstantShoppingToggleElementFragment {
            @Nullable
            private GraphQLObjectType f914d;
            @Nullable
            private InstantShoppingActionFragmentModel f915e;
            @Nullable
            private String f916f;
            @Nullable
            private InstantShoppingActionFragmentModel f917g;
            @Nullable
            private GraphQLInstantShoppingDocumentElementType f918h;
            @Nullable
            private InstantShoppingElementDescriptorFragmentModel f919i;
            @Nullable
            private RichDocumentTextModel f920j;
            private int f921k;
            private boolean f922l;
            @Nullable
            private String f923m;
            @Nullable
            private RichDocumentTextModel f924n;
            @Nullable
            private RichDocumentTextModel f925o;
            @Nullable
            private List<GraphQLInstantShoppingPresentationStyle> f926p;
            @Nullable
            private String f927q;
            @Nullable
            private InstantShoppingActionFragmentModel f928r;

            /* compiled from: upload_date */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(FooterElementsModel.class, new Deserializer());
                }

                public Object m967a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(FooterElementsParser.m1292b(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object footerElementsModel = new FooterElementsModel();
                    ((BaseModel) footerElementsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (footerElementsModel instanceof Postprocessable) {
                        return ((Postprocessable) footerElementsModel).a();
                    }
                    return footerElementsModel;
                }
            }

            /* compiled from: upload_date */
            public class Serializer extends JsonSerializer<FooterElementsModel> {
                public final void m968a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    FooterElementsModel footerElementsModel = (FooterElementsModel) obj;
                    if (footerElementsModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(footerElementsModel.m978a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        footerElementsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    FooterElementsParser.m1293b(footerElementsModel.w_(), footerElementsModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(FooterElementsModel.class, new Serializer());
                }
            }

            @Nullable
            public final /* synthetic */ InstantShoppingActionFragmentModel mo28a() {
                return m970k();
            }

            @Nullable
            public final /* synthetic */ InstantShoppingElementDescriptorFragmentModel mo31d() {
                return m972m();
            }

            @Nullable
            public final /* synthetic */ RichDocumentText iK_() {
                return m973n();
            }

            @Nullable
            public final /* synthetic */ InstantShoppingActionFragmentModel mo48q() {
                return m971l();
            }

            @Nullable
            public final /* synthetic */ RichDocumentText mo50s() {
                return m974o();
            }

            @Nullable
            public final /* synthetic */ RichDocumentText mo51t() {
                return m975p();
            }

            @Nullable
            public final /* synthetic */ InstantShoppingActionFragmentModel mo52u() {
                return m977w();
            }

            public FooterElementsModel() {
                super(15);
            }

            @Nullable
            private GraphQLObjectType m969j() {
                if (this.b != null && this.f914d == null) {
                    this.f914d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
                }
                return this.f914d;
            }

            @Nullable
            private InstantShoppingActionFragmentModel m970k() {
                this.f915e = (InstantShoppingActionFragmentModel) super.a(this.f915e, 1, InstantShoppingActionFragmentModel.class);
                return this.f915e;
            }

            @Nullable
            public final String mo29b() {
                this.f916f = super.a(this.f916f, 2);
                return this.f916f;
            }

            @Nullable
            private InstantShoppingActionFragmentModel m971l() {
                this.f917g = (InstantShoppingActionFragmentModel) super.a(this.f917g, 3, InstantShoppingActionFragmentModel.class);
                return this.f917g;
            }

            @Nullable
            public final GraphQLInstantShoppingDocumentElementType mo30c() {
                this.f918h = (GraphQLInstantShoppingDocumentElementType) super.b(this.f918h, 4, GraphQLInstantShoppingDocumentElementType.class, GraphQLInstantShoppingDocumentElementType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
                return this.f918h;
            }

            @Nullable
            private InstantShoppingElementDescriptorFragmentModel m972m() {
                this.f919i = (InstantShoppingElementDescriptorFragmentModel) super.a(this.f919i, 5, InstantShoppingElementDescriptorFragmentModel.class);
                return this.f919i;
            }

            @Nullable
            private RichDocumentTextModel m973n() {
                this.f920j = (RichDocumentTextModel) super.a(this.f920j, 6, RichDocumentTextModel.class);
                return this.f920j;
            }

            public final int mo32g() {
                a(0, 7);
                return this.f921k;
            }

            public final boolean mo49r() {
                a(1, 0);
                return this.f922l;
            }

            @Nullable
            public final String iI_() {
                this.f923m = super.a(this.f923m, 9);
                return this.f923m;
            }

            @Nullable
            private RichDocumentTextModel m974o() {
                this.f924n = (RichDocumentTextModel) super.a(this.f924n, 10, RichDocumentTextModel.class);
                return this.f924n;
            }

            @Nullable
            private RichDocumentTextModel m975p() {
                this.f925o = (RichDocumentTextModel) super.a(this.f925o, 11, RichDocumentTextModel.class);
                return this.f925o;
            }

            @Nonnull
            public final ImmutableList<GraphQLInstantShoppingPresentationStyle> iJ_() {
                this.f926p = super.c(this.f926p, 12, GraphQLInstantShoppingPresentationStyle.class);
                return (ImmutableList) this.f926p;
            }

            @Nullable
            private String m976v() {
                this.f927q = super.a(this.f927q, 13);
                return this.f927q;
            }

            @Nullable
            private InstantShoppingActionFragmentModel m977w() {
                this.f928r = (InstantShoppingActionFragmentModel) super.a(this.f928r, 14, InstantShoppingActionFragmentModel.class);
                return this.f928r;
            }

            public final int jK_() {
                return 1808563160;
            }

            public final GraphQLVisitableModel m979a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                InstantShoppingActionFragmentModel instantShoppingActionFragmentModel;
                RichDocumentTextModel richDocumentTextModel;
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m970k() != null) {
                    instantShoppingActionFragmentModel = (InstantShoppingActionFragmentModel) graphQLModelMutatingVisitor.b(m970k());
                    if (m970k() != instantShoppingActionFragmentModel) {
                        graphQLVisitableModel = (FooterElementsModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f915e = instantShoppingActionFragmentModel;
                    }
                }
                if (m971l() != null) {
                    instantShoppingActionFragmentModel = (InstantShoppingActionFragmentModel) graphQLModelMutatingVisitor.b(m971l());
                    if (m971l() != instantShoppingActionFragmentModel) {
                        graphQLVisitableModel = (FooterElementsModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f917g = instantShoppingActionFragmentModel;
                    }
                }
                if (m972m() != null) {
                    InstantShoppingElementDescriptorFragmentModel instantShoppingElementDescriptorFragmentModel = (InstantShoppingElementDescriptorFragmentModel) graphQLModelMutatingVisitor.b(m972m());
                    if (m972m() != instantShoppingElementDescriptorFragmentModel) {
                        graphQLVisitableModel = (FooterElementsModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f919i = instantShoppingElementDescriptorFragmentModel;
                    }
                }
                if (m973n() != null) {
                    richDocumentTextModel = (RichDocumentTextModel) graphQLModelMutatingVisitor.b(m973n());
                    if (m973n() != richDocumentTextModel) {
                        graphQLVisitableModel = (FooterElementsModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f920j = richDocumentTextModel;
                    }
                }
                if (m974o() != null) {
                    richDocumentTextModel = (RichDocumentTextModel) graphQLModelMutatingVisitor.b(m974o());
                    if (m974o() != richDocumentTextModel) {
                        graphQLVisitableModel = (FooterElementsModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f924n = richDocumentTextModel;
                    }
                }
                if (m975p() != null) {
                    richDocumentTextModel = (RichDocumentTextModel) graphQLModelMutatingVisitor.b(m975p());
                    if (m975p() != richDocumentTextModel) {
                        graphQLVisitableModel = (FooterElementsModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f925o = richDocumentTextModel;
                    }
                }
                if (m977w() != null) {
                    instantShoppingActionFragmentModel = (InstantShoppingActionFragmentModel) graphQLModelMutatingVisitor.b(m977w());
                    if (m977w() != instantShoppingActionFragmentModel) {
                        graphQLVisitableModel = (FooterElementsModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f928r = instantShoppingActionFragmentModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m978a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m969j());
                int a2 = ModelHelper.a(flatBufferBuilder, m970k());
                int b = flatBufferBuilder.b(mo29b());
                int a3 = ModelHelper.a(flatBufferBuilder, m971l());
                int a4 = flatBufferBuilder.a(mo30c());
                int a5 = ModelHelper.a(flatBufferBuilder, m972m());
                int a6 = ModelHelper.a(flatBufferBuilder, m973n());
                int b2 = flatBufferBuilder.b(iI_());
                int a7 = ModelHelper.a(flatBufferBuilder, m974o());
                int a8 = ModelHelper.a(flatBufferBuilder, m975p());
                int d = flatBufferBuilder.d(iJ_());
                int b3 = flatBufferBuilder.b(m976v());
                int a9 = ModelHelper.a(flatBufferBuilder, m977w());
                flatBufferBuilder.c(15);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.b(1, a2);
                flatBufferBuilder.b(2, b);
                flatBufferBuilder.b(3, a3);
                flatBufferBuilder.b(4, a4);
                flatBufferBuilder.b(5, a5);
                flatBufferBuilder.b(6, a6);
                flatBufferBuilder.a(7, this.f921k, 0);
                flatBufferBuilder.a(8, this.f922l);
                flatBufferBuilder.b(9, b2);
                flatBufferBuilder.b(10, a7);
                flatBufferBuilder.b(11, a8);
                flatBufferBuilder.b(12, d);
                flatBufferBuilder.b(13, b3);
                flatBufferBuilder.b(14, a9);
                i();
                return flatBufferBuilder.d();
            }

            public final void m981a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                super.a(mutableFlatBuffer, i, obj);
                this.f921k = mutableFlatBuffer.a(i, 7, 0);
                this.f922l = mutableFlatBuffer.a(i, 8);
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -75543719)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: upload_date */
        public final class FooterModel extends BaseModel implements GraphQLVisitableModel, InstantShoppingButtonElementFragment, InstantShoppingPhotoElementFragment, InstantShoppingTextElementFragment {
            @Nullable
            private GraphQLObjectType f929d;
            @Nullable
            private InstantShoppingActionFragmentModel f930e;
            @Nullable
            private List<InstantShoppingTextElementFragmentModel> f931f;
            @Nullable
            private String f932g;
            @Nullable
            private GraphQLInstantShoppingDocumentElementType f933h;
            @Nullable
            private InstantShoppingElementDescriptorFragmentModel f934i;
            @Nullable
            private ElementPhotoModel f935j;
            @Nullable
            private RichDocumentTextModel f936k;
            private int f937l;
            @Nullable
            private FBFullImageFragmentModel f938m;
            @Nullable
            private String f939n;
            @Nullable
            private List<GraphQLInstantShoppingPresentationStyle> f940o;
            @Nullable
            private String f941p;

            /* compiled from: upload_date */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(FooterModel.class, new Deserializer());
                }

                public Object m991a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(FooterParser.m1294a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object footerModel = new FooterModel();
                    ((BaseModel) footerModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (footerModel instanceof Postprocessable) {
                        return ((Postprocessable) footerModel).a();
                    }
                    return footerModel;
                }
            }

            /* compiled from: upload_date */
            public class Serializer extends JsonSerializer<FooterModel> {
                public final void m992a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    FooterModel footerModel = (FooterModel) obj;
                    if (footerModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(footerModel.m1000a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        footerModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    FooterParser.m1295a(footerModel.w_(), footerModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(FooterModel.class, new Serializer());
                }
            }

            @Nullable
            public final /* synthetic */ InstantShoppingActionFragmentModel mo28a() {
                return m994k();
            }

            @Nullable
            public final /* synthetic */ InstantShoppingElementDescriptorFragmentModel mo31d() {
                return m995o();
            }

            @Nullable
            public final /* synthetic */ RichDocumentText iK_() {
                return m997q();
            }

            @Nullable
            public final /* synthetic */ ElementPhotoModel mo39m() {
                return m996p();
            }

            @Nullable
            public final /* synthetic */ FBFullImageFragmentModel mo40n() {
                return m998r();
            }

            public FooterModel() {
                super(13);
            }

            @Nullable
            private GraphQLObjectType m993j() {
                if (this.b != null && this.f929d == null) {
                    this.f929d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
                }
                return this.f929d;
            }

            @Nullable
            private InstantShoppingActionFragmentModel m994k() {
                this.f930e = (InstantShoppingActionFragmentModel) super.a(this.f930e, 1, InstantShoppingActionFragmentModel.class);
                return this.f930e;
            }

            @Nonnull
            public final ImmutableList<InstantShoppingTextElementFragmentModel> mo38l() {
                this.f931f = super.a(this.f931f, 2, InstantShoppingTextElementFragmentModel.class);
                return (ImmutableList) this.f931f;
            }

            @Nullable
            public final String mo29b() {
                this.f932g = super.a(this.f932g, 3);
                return this.f932g;
            }

            @Nullable
            public final GraphQLInstantShoppingDocumentElementType mo30c() {
                this.f933h = (GraphQLInstantShoppingDocumentElementType) super.b(this.f933h, 4, GraphQLInstantShoppingDocumentElementType.class, GraphQLInstantShoppingDocumentElementType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
                return this.f933h;
            }

            @Nullable
            private InstantShoppingElementDescriptorFragmentModel m995o() {
                this.f934i = (InstantShoppingElementDescriptorFragmentModel) super.a(this.f934i, 5, InstantShoppingElementDescriptorFragmentModel.class);
                return this.f934i;
            }

            @Nullable
            private ElementPhotoModel m996p() {
                this.f935j = (ElementPhotoModel) super.a(this.f935j, 6, ElementPhotoModel.class);
                return this.f935j;
            }

            @Nullable
            private RichDocumentTextModel m997q() {
                this.f936k = (RichDocumentTextModel) super.a(this.f936k, 7, RichDocumentTextModel.class);
                return this.f936k;
            }

            public final int mo32g() {
                a(1, 0);
                return this.f937l;
            }

            @Nullable
            private FBFullImageFragmentModel m998r() {
                this.f938m = (FBFullImageFragmentModel) super.a(this.f938m, 9, FBFullImageFragmentModel.class);
                return this.f938m;
            }

            @Nullable
            public final String iI_() {
                this.f939n = super.a(this.f939n, 10);
                return this.f939n;
            }

            @Nonnull
            public final ImmutableList<GraphQLInstantShoppingPresentationStyle> iJ_() {
                this.f940o = super.c(this.f940o, 11, GraphQLInstantShoppingPresentationStyle.class);
                return (ImmutableList) this.f940o;
            }

            @Nullable
            private String m999s() {
                this.f941p = super.a(this.f941p, 12);
                return this.f941p;
            }

            public final int jK_() {
                return 1808563160;
            }

            public final GraphQLVisitableModel m1001a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m994k() != null) {
                    InstantShoppingActionFragmentModel instantShoppingActionFragmentModel = (InstantShoppingActionFragmentModel) graphQLModelMutatingVisitor.b(m994k());
                    if (m994k() != instantShoppingActionFragmentModel) {
                        graphQLVisitableModel = (FooterModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f930e = instantShoppingActionFragmentModel;
                    }
                }
                if (mo38l() != null) {
                    Builder a = ModelHelper.a(mo38l(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        FooterModel footerModel = (FooterModel) ModelHelper.a(graphQLVisitableModel, this);
                        footerModel.f931f = a.b();
                        graphQLVisitableModel = footerModel;
                    }
                }
                if (m995o() != null) {
                    InstantShoppingElementDescriptorFragmentModel instantShoppingElementDescriptorFragmentModel = (InstantShoppingElementDescriptorFragmentModel) graphQLModelMutatingVisitor.b(m995o());
                    if (m995o() != instantShoppingElementDescriptorFragmentModel) {
                        graphQLVisitableModel = (FooterModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f934i = instantShoppingElementDescriptorFragmentModel;
                    }
                }
                if (m996p() != null) {
                    ElementPhotoModel elementPhotoModel = (ElementPhotoModel) graphQLModelMutatingVisitor.b(m996p());
                    if (m996p() != elementPhotoModel) {
                        graphQLVisitableModel = (FooterModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f935j = elementPhotoModel;
                    }
                }
                if (m997q() != null) {
                    RichDocumentTextModel richDocumentTextModel = (RichDocumentTextModel) graphQLModelMutatingVisitor.b(m997q());
                    if (m997q() != richDocumentTextModel) {
                        graphQLVisitableModel = (FooterModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f936k = richDocumentTextModel;
                    }
                }
                if (m998r() != null) {
                    FBFullImageFragmentModel fBFullImageFragmentModel = (FBFullImageFragmentModel) graphQLModelMutatingVisitor.b(m998r());
                    if (m998r() != fBFullImageFragmentModel) {
                        graphQLVisitableModel = (FooterModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f938m = fBFullImageFragmentModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m1000a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m993j());
                int a2 = ModelHelper.a(flatBufferBuilder, m994k());
                int a3 = ModelHelper.a(flatBufferBuilder, mo38l());
                int b = flatBufferBuilder.b(mo29b());
                int a4 = flatBufferBuilder.a(mo30c());
                int a5 = ModelHelper.a(flatBufferBuilder, m995o());
                int a6 = ModelHelper.a(flatBufferBuilder, m996p());
                int a7 = ModelHelper.a(flatBufferBuilder, m997q());
                int a8 = ModelHelper.a(flatBufferBuilder, m998r());
                int b2 = flatBufferBuilder.b(iI_());
                int d = flatBufferBuilder.d(iJ_());
                int b3 = flatBufferBuilder.b(m999s());
                flatBufferBuilder.c(13);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.b(1, a2);
                flatBufferBuilder.b(2, a3);
                flatBufferBuilder.b(3, b);
                flatBufferBuilder.b(4, a4);
                flatBufferBuilder.b(5, a5);
                flatBufferBuilder.b(6, a6);
                flatBufferBuilder.b(7, a7);
                flatBufferBuilder.a(8, this.f937l, 0);
                flatBufferBuilder.b(9, a8);
                flatBufferBuilder.b(10, b2);
                flatBufferBuilder.b(11, d);
                flatBufferBuilder.b(12, b3);
                i();
                return flatBufferBuilder.d();
            }

            public final void m1003a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                super.a(mutableFlatBuffer, i, obj);
                this.f937l = mutableFlatBuffer.a(i, 8, 0);
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 22212175)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: upload_date */
        public final class HeaderElementsModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private GraphQLObjectType f942d;
            @Nullable
            private InstantShoppingActionFragmentModel f943e;
            @Nullable
            private GraphQLInstantShoppingHeaderElementType f944f;
            @Nullable
            private String f945g;
            private boolean f946h;
            @Nullable
            private String f947i;

            /* compiled from: upload_date */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(HeaderElementsModel.class, new Deserializer());
                }

                public Object m1011a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(HeaderElementsParser.m1297b(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object headerElementsModel = new HeaderElementsModel();
                    ((BaseModel) headerElementsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (headerElementsModel instanceof Postprocessable) {
                        return ((Postprocessable) headerElementsModel).a();
                    }
                    return headerElementsModel;
                }
            }

            /* compiled from: upload_date */
            public class Serializer extends JsonSerializer<HeaderElementsModel> {
                public final void m1012a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    HeaderElementsModel headerElementsModel = (HeaderElementsModel) obj;
                    if (headerElementsModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(headerElementsModel.m1015a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        headerElementsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    HeaderElementsParser.m1298b(headerElementsModel.w_(), headerElementsModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(HeaderElementsModel.class, new Serializer());
                }
            }

            @Nullable
            public final /* synthetic */ InstantShoppingActionFragmentModel m1017a() {
                return m1014k();
            }

            public HeaderElementsModel() {
                super(6);
            }

            @Nullable
            private GraphQLObjectType m1013j() {
                if (this.b != null && this.f942d == null) {
                    this.f942d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
                }
                return this.f942d;
            }

            @Nullable
            private InstantShoppingActionFragmentModel m1014k() {
                this.f943e = (InstantShoppingActionFragmentModel) super.a(this.f943e, 1, InstantShoppingActionFragmentModel.class);
                return this.f943e;
            }

            @Nullable
            public final GraphQLInstantShoppingHeaderElementType m1019b() {
                this.f944f = (GraphQLInstantShoppingHeaderElementType) super.b(this.f944f, 2, GraphQLInstantShoppingHeaderElementType.class, GraphQLInstantShoppingHeaderElementType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
                return this.f944f;
            }

            @Nullable
            public final String m1020c() {
                this.f945g = super.a(this.f945g, 3);
                return this.f945g;
            }

            public final boolean m1021d() {
                a(0, 4);
                return this.f946h;
            }

            @Nullable
            public final String iL_() {
                this.f947i = super.a(this.f947i, 5);
                return this.f947i;
            }

            public final int jK_() {
                return -1211140122;
            }

            public final GraphQLVisitableModel m1016a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m1014k() != null) {
                    InstantShoppingActionFragmentModel instantShoppingActionFragmentModel = (InstantShoppingActionFragmentModel) graphQLModelMutatingVisitor.b(m1014k());
                    if (m1014k() != instantShoppingActionFragmentModel) {
                        graphQLVisitableModel = (HeaderElementsModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f943e = instantShoppingActionFragmentModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m1015a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m1013j());
                int a2 = ModelHelper.a(flatBufferBuilder, m1014k());
                int a3 = flatBufferBuilder.a(m1019b());
                int b = flatBufferBuilder.b(m1020c());
                int b2 = flatBufferBuilder.b(iL_());
                flatBufferBuilder.c(6);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.b(1, a2);
                flatBufferBuilder.b(2, a3);
                flatBufferBuilder.b(3, b);
                flatBufferBuilder.a(4, this.f946h);
                flatBufferBuilder.b(5, b2);
                i();
                return flatBufferBuilder.d();
            }

            public final void m1018a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                super.a(mutableFlatBuffer, i, obj);
                this.f946h = mutableFlatBuffer.a(i, 4);
            }
        }

        /* compiled from: upload_date */
        public class Serializer extends JsonSerializer<InstantShoppingDocumentFragmentModel> {
            public final void m1022a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                InstantShoppingDocumentFragmentModel instantShoppingDocumentFragmentModel = (InstantShoppingDocumentFragmentModel) obj;
                if (instantShoppingDocumentFragmentModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(instantShoppingDocumentFragmentModel.m1024a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    instantShoppingDocumentFragmentModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                InstantShoppingDocumentFragmentParser.m1300a(instantShoppingDocumentFragmentModel.w_(), instantShoppingDocumentFragmentModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(InstantShoppingDocumentFragmentModel.class, new Serializer());
            }
        }

        @Nullable
        public final /* synthetic */ DocumentBodyElementsModel m1028b() {
            return m1030k();
        }

        public InstantShoppingDocumentFragmentModel() {
            super(10);
        }

        @Nullable
        public final String m1026a() {
            this.f948d = super.a(this.f948d, 0);
            return this.f948d;
        }

        @Nonnull
        public final ImmutableList<InstantShoppingFontObjectFragmentModel> m1029j() {
            this.f949e = super.a(this.f949e, 1, InstantShoppingFontObjectFragmentModel.class);
            return (ImmutableList) this.f949e;
        }

        @Nullable
        public final DocumentBodyElementsModel m1030k() {
            this.f950f = (DocumentBodyElementsModel) super.a(this.f950f, 2, DocumentBodyElementsModel.class);
            return this.f950f;
        }

        @Nullable
        private FooterModel m1023r() {
            this.f951g = (FooterModel) super.a(this.f951g, 3, FooterModel.class);
            return this.f951g;
        }

        @Nonnull
        public final ImmutableList<FooterElementsModel> m1031l() {
            this.f952h = super.a(this.f952h, 4, FooterElementsModel.class);
            return (ImmutableList) this.f952h;
        }

        @Nonnull
        public final ImmutableList<HeaderElementsModel> m1032m() {
            this.f953i = super.a(this.f953i, 5, HeaderElementsModel.class);
            return (ImmutableList) this.f953i;
        }

        public final boolean m1033n() {
            a(0, 6);
            return this.f954j;
        }

        @Nonnull
        public final ImmutableList<GraphQLInstantShoppingDocumentPresentationStyle> m1034o() {
            this.f955k = super.c(this.f955k, 7, GraphQLInstantShoppingDocumentPresentationStyle.class);
            return (ImmutableList) this.f955k;
        }

        @Nonnull
        public final ImmutableList<String> m1035p() {
            this.f956l = super.a(this.f956l, 8);
            return (ImmutableList) this.f956l;
        }

        @Nullable
        public final String m1036q() {
            this.f957m = super.a(this.f957m, 9);
            return this.f957m;
        }

        public final int jK_() {
            return -1231249788;
        }

        public final GraphQLVisitableModel m1025a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            InstantShoppingDocumentFragmentModel instantShoppingDocumentFragmentModel;
            GraphQLVisitableModel graphQLVisitableModel;
            DocumentBodyElementsModel documentBodyElementsModel;
            FooterModel footerModel;
            Builder a;
            h();
            if (m1029j() != null) {
                Builder a2 = ModelHelper.a(m1029j(), graphQLModelMutatingVisitor);
                if (a2 != null) {
                    instantShoppingDocumentFragmentModel = (InstantShoppingDocumentFragmentModel) ModelHelper.a(null, this);
                    instantShoppingDocumentFragmentModel.f949e = a2.b();
                    graphQLVisitableModel = instantShoppingDocumentFragmentModel;
                    if (m1030k() != null) {
                        documentBodyElementsModel = (DocumentBodyElementsModel) graphQLModelMutatingVisitor.b(m1030k());
                        if (m1030k() != documentBodyElementsModel) {
                            graphQLVisitableModel = (InstantShoppingDocumentFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                            graphQLVisitableModel.f950f = documentBodyElementsModel;
                        }
                    }
                    if (m1023r() != null) {
                        footerModel = (FooterModel) graphQLModelMutatingVisitor.b(m1023r());
                        if (m1023r() != footerModel) {
                            graphQLVisitableModel = (InstantShoppingDocumentFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                            graphQLVisitableModel.f951g = footerModel;
                        }
                    }
                    if (m1031l() != null) {
                        a = ModelHelper.a(m1031l(), graphQLModelMutatingVisitor);
                        if (a != null) {
                            instantShoppingDocumentFragmentModel = (InstantShoppingDocumentFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                            instantShoppingDocumentFragmentModel.f952h = a.b();
                            graphQLVisitableModel = instantShoppingDocumentFragmentModel;
                        }
                    }
                    if (m1032m() != null) {
                        a = ModelHelper.a(m1032m(), graphQLModelMutatingVisitor);
                        if (a != null) {
                            instantShoppingDocumentFragmentModel = (InstantShoppingDocumentFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                            instantShoppingDocumentFragmentModel.f953i = a.b();
                            graphQLVisitableModel = instantShoppingDocumentFragmentModel;
                        }
                    }
                    i();
                    return graphQLVisitableModel != null ? this : graphQLVisitableModel;
                }
            }
            graphQLVisitableModel = null;
            if (m1030k() != null) {
                documentBodyElementsModel = (DocumentBodyElementsModel) graphQLModelMutatingVisitor.b(m1030k());
                if (m1030k() != documentBodyElementsModel) {
                    graphQLVisitableModel = (InstantShoppingDocumentFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f950f = documentBodyElementsModel;
                }
            }
            if (m1023r() != null) {
                footerModel = (FooterModel) graphQLModelMutatingVisitor.b(m1023r());
                if (m1023r() != footerModel) {
                    graphQLVisitableModel = (InstantShoppingDocumentFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f951g = footerModel;
                }
            }
            if (m1031l() != null) {
                a = ModelHelper.a(m1031l(), graphQLModelMutatingVisitor);
                if (a != null) {
                    instantShoppingDocumentFragmentModel = (InstantShoppingDocumentFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    instantShoppingDocumentFragmentModel.f952h = a.b();
                    graphQLVisitableModel = instantShoppingDocumentFragmentModel;
                }
            }
            if (m1032m() != null) {
                a = ModelHelper.a(m1032m(), graphQLModelMutatingVisitor);
                if (a != null) {
                    instantShoppingDocumentFragmentModel = (InstantShoppingDocumentFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    instantShoppingDocumentFragmentModel.f953i = a.b();
                    graphQLVisitableModel = instantShoppingDocumentFragmentModel;
                }
            }
            i();
            if (graphQLVisitableModel != null) {
            }
        }

        public final int m1024a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(m1026a());
            int a = ModelHelper.a(flatBufferBuilder, m1029j());
            int a2 = ModelHelper.a(flatBufferBuilder, m1030k());
            int a3 = ModelHelper.a(flatBufferBuilder, m1023r());
            int a4 = ModelHelper.a(flatBufferBuilder, m1031l());
            int a5 = ModelHelper.a(flatBufferBuilder, m1032m());
            int d = flatBufferBuilder.d(m1034o());
            int c = flatBufferBuilder.c(m1035p());
            int b2 = flatBufferBuilder.b(m1036q());
            flatBufferBuilder.c(10);
            flatBufferBuilder.b(0, b);
            flatBufferBuilder.b(1, a);
            flatBufferBuilder.b(2, a2);
            flatBufferBuilder.b(3, a3);
            flatBufferBuilder.b(4, a4);
            flatBufferBuilder.b(5, a5);
            flatBufferBuilder.a(6, this.f954j);
            flatBufferBuilder.b(7, d);
            flatBufferBuilder.b(8, c);
            flatBufferBuilder.b(9, b2);
            i();
            return flatBufferBuilder.d();
        }

        public final void m1027a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
            super.a(mutableFlatBuffer, i, obj);
            this.f954j = mutableFlatBuffer.a(i, 6);
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 2048356091)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: upload_date */
    public final class InstantShoppingElementDescriptorFragmentModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private GraphQLInstantShoppingDocumentAlignmentDescriptorType f958d;
        @Nullable
        private String f959e;
        @Nullable
        private String f960f;
        @Nullable
        private String f961g;
        @Nullable
        private String f962h;
        @Nullable
        private InstantShoppingTextMetricsDescriptorFragmentModel f963i;
        @Nullable
        private String f964j;
        @Nullable
        private String f965k;

        /* compiled from: upload_date */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(InstantShoppingElementDescriptorFragmentModel.class, new Deserializer());
            }

            public Object m1037a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(InstantShoppingElementDescriptorFragmentParser.m1301a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object instantShoppingElementDescriptorFragmentModel = new InstantShoppingElementDescriptorFragmentModel();
                ((BaseModel) instantShoppingElementDescriptorFragmentModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (instantShoppingElementDescriptorFragmentModel instanceof Postprocessable) {
                    return ((Postprocessable) instantShoppingElementDescriptorFragmentModel).a();
                }
                return instantShoppingElementDescriptorFragmentModel;
            }
        }

        /* compiled from: upload_date */
        public class Serializer extends JsonSerializer<InstantShoppingElementDescriptorFragmentModel> {
            public final void m1038a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                InstantShoppingElementDescriptorFragmentModel instantShoppingElementDescriptorFragmentModel = (InstantShoppingElementDescriptorFragmentModel) obj;
                if (instantShoppingElementDescriptorFragmentModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(instantShoppingElementDescriptorFragmentModel.m1040a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    instantShoppingElementDescriptorFragmentModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                InstantShoppingElementDescriptorFragmentParser.m1302a(instantShoppingElementDescriptorFragmentModel.w_(), instantShoppingElementDescriptorFragmentModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(InstantShoppingElementDescriptorFragmentModel.class, new Serializer());
            }
        }

        @Nullable
        public final /* synthetic */ InstantShoppingTextMetricsDescriptorFragmentModel m1046g() {
            return m1039j();
        }

        public InstantShoppingElementDescriptorFragmentModel() {
            super(8);
        }

        @Nullable
        public final GraphQLInstantShoppingDocumentAlignmentDescriptorType m1041a() {
            this.f958d = (GraphQLInstantShoppingDocumentAlignmentDescriptorType) super.b(this.f958d, 0, GraphQLInstantShoppingDocumentAlignmentDescriptorType.class, GraphQLInstantShoppingDocumentAlignmentDescriptorType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
            return this.f958d;
        }

        @Nullable
        public final String m1043b() {
            this.f959e = super.a(this.f959e, 1);
            return this.f959e;
        }

        @Nullable
        public final String m1044c() {
            this.f960f = super.a(this.f960f, 2);
            return this.f960f;
        }

        @Nullable
        public final String m1045d() {
            this.f961g = super.a(this.f961g, 3);
            return this.f961g;
        }

        @Nullable
        public final String iM_() {
            this.f962h = super.a(this.f962h, 4);
            return this.f962h;
        }

        @Nullable
        private InstantShoppingTextMetricsDescriptorFragmentModel m1039j() {
            this.f963i = (InstantShoppingTextMetricsDescriptorFragmentModel) super.a(this.f963i, 5, InstantShoppingTextMetricsDescriptorFragmentModel.class);
            return this.f963i;
        }

        @Nullable
        public final String iN_() {
            this.f964j = super.a(this.f964j, 6);
            return this.f964j;
        }

        @Nullable
        public final String iO_() {
            this.f965k = super.a(this.f965k, 7);
            return this.f965k;
        }

        public final int jK_() {
            return -371442329;
        }

        public final GraphQLVisitableModel m1042a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m1039j() != null) {
                InstantShoppingTextMetricsDescriptorFragmentModel instantShoppingTextMetricsDescriptorFragmentModel = (InstantShoppingTextMetricsDescriptorFragmentModel) graphQLModelMutatingVisitor.b(m1039j());
                if (m1039j() != instantShoppingTextMetricsDescriptorFragmentModel) {
                    graphQLVisitableModel = (InstantShoppingElementDescriptorFragmentModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f963i = instantShoppingTextMetricsDescriptorFragmentModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m1040a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = flatBufferBuilder.a(m1041a());
            int b = flatBufferBuilder.b(m1043b());
            int b2 = flatBufferBuilder.b(m1044c());
            int b3 = flatBufferBuilder.b(m1045d());
            int b4 = flatBufferBuilder.b(iM_());
            int a2 = ModelHelper.a(flatBufferBuilder, m1039j());
            int b5 = flatBufferBuilder.b(iN_());
            int b6 = flatBufferBuilder.b(iO_());
            flatBufferBuilder.c(8);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, b);
            flatBufferBuilder.b(2, b2);
            flatBufferBuilder.b(3, b3);
            flatBufferBuilder.b(4, b4);
            flatBufferBuilder.b(5, a2);
            flatBufferBuilder.b(6, b5);
            flatBufferBuilder.b(7, b6);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -588350329)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: upload_date */
    public final class InstantShoppingFontObjectFragmentModel extends BaseModel implements GraphQLVisitableModel {
        private boolean f966d;
        private boolean f967e;
        @Nullable
        private String f968f;
        @Nullable
        private String f969g;
        @Nullable
        private String f970h;

        /* compiled from: upload_date */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(InstantShoppingFontObjectFragmentModel.class, new Deserializer());
            }

            public Object m1047a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(InstantShoppingFontObjectFragmentParser.m1305b(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object instantShoppingFontObjectFragmentModel = new InstantShoppingFontObjectFragmentModel();
                ((BaseModel) instantShoppingFontObjectFragmentModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (instantShoppingFontObjectFragmentModel instanceof Postprocessable) {
                    return ((Postprocessable) instantShoppingFontObjectFragmentModel).a();
                }
                return instantShoppingFontObjectFragmentModel;
            }
        }

        /* compiled from: upload_date */
        public class Serializer extends JsonSerializer<InstantShoppingFontObjectFragmentModel> {
            public final void m1048a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                InstantShoppingFontObjectFragmentModel instantShoppingFontObjectFragmentModel = (InstantShoppingFontObjectFragmentModel) obj;
                if (instantShoppingFontObjectFragmentModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(instantShoppingFontObjectFragmentModel.m1049a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    instantShoppingFontObjectFragmentModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                InstantShoppingFontObjectFragmentParser.m1304a(instantShoppingFontObjectFragmentModel.w_(), instantShoppingFontObjectFragmentModel.u_(), jsonGenerator);
            }

            static {
                FbSerializerProvider.a(InstantShoppingFontObjectFragmentModel.class, new Serializer());
            }
        }

        public InstantShoppingFontObjectFragmentModel() {
            super(5);
        }

        @Nullable
        public final String m1051a() {
            this.f968f = super.a(this.f968f, 2);
            return this.f968f;
        }

        @Nullable
        public final String m1053b() {
            this.f969g = super.a(this.f969g, 3);
            return this.f969g;
        }

        @Nullable
        public final String m1054c() {
            this.f970h = super.a(this.f970h, 4);
            return this.f970h;
        }

        public final int jK_() {
            return 2028665751;
        }

        public final GraphQLVisitableModel m1050a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            h();
            i();
            return this;
        }

        public final int m1049a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(m1051a());
            int b2 = flatBufferBuilder.b(m1053b());
            int b3 = flatBufferBuilder.b(m1054c());
            flatBufferBuilder.c(5);
            flatBufferBuilder.a(0, this.f966d);
            flatBufferBuilder.a(1, this.f967e);
            flatBufferBuilder.b(2, b);
            flatBufferBuilder.b(3, b2);
            flatBufferBuilder.b(4, b3);
            i();
            return flatBufferBuilder.d();
        }

        public final void m1052a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
            super.a(mutableFlatBuffer, i, obj);
            this.f966d = mutableFlatBuffer.a(i, 0);
            this.f967e = mutableFlatBuffer.a(i, 1);
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -1584568793)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: upload_date */
    public final class InstantShoppingFooterElementFragmentModel extends BaseModel implements GraphQLVisitableModel, InstantShoppingFooterElementFragment {
        @Nullable
        private GraphQLInstantShoppingDocumentElementType f999d;
        @Nullable
        private InstantShoppingElementDescriptorFragmentModel f1000e;
        @Nullable
        private List<FooterElementsModel> f1001f;
        @Nullable
        private List<GraphQLInstantShoppingPresentationStyle> f1002g;

        /* compiled from: upload_date */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(InstantShoppingFooterElementFragmentModel.class, new Deserializer());
            }

            public Object m1055a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = InstantShoppingFooterElementFragmentParser.m1310a(jsonParser);
                Object instantShoppingFooterElementFragmentModel = new InstantShoppingFooterElementFragmentModel();
                ((BaseModel) instantShoppingFooterElementFragmentModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (instantShoppingFooterElementFragmentModel instanceof Postprocessable) {
                    return ((Postprocessable) instantShoppingFooterElementFragmentModel).a();
                }
                return instantShoppingFooterElementFragmentModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 1782734617)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: upload_date */
        public final class FooterElementsModel extends BaseModel implements GraphQLVisitableModel, InstantShoppingButtonElementFragment, InstantShoppingColorSelectorElementFragment, InstantShoppingCompositeBlockElementFragment, InstantShoppingDocumentExpandableSectionElementFragment, InstantShoppingPhotoElementFragment, InstantShoppingTextElementFragment, InstantShoppingToggleElementFragment {
            @Nullable
            private InstantShoppingTextElementFragmentModel f971A;
            private int f972B;
            @Nullable
            private List<GraphQLInstantShoppingPresentationStyle> f973C;
            @Nullable
            private String f974D;
            @Nullable
            private InstantShoppingActionFragmentModel f975E;
            @Nullable
            private GraphQLObjectType f976d;
            @Nullable
            private InstantShoppingActionFragmentModel f977e;
            @Nullable
            private List<InstantShoppingTextElementFragmentModel> f978f;
            @Nullable
            private GraphQLDocumentVideoAutoplayStyle f979g;
            @Nullable
            private List<BlockElementsModel> f980h;
            @Nullable
            private List<InstantShoppingPhotoElementFragmentModel> f981i;
            @Nullable
            private String f982j;
            @Nullable
            private List<InstantShoppingColorSelectorColorFragmentModel> f983k;
            @Nullable
            private InstantShoppingTextElementFragmentModel f984l;
            @Nullable
            private GraphQLDocumentVideoControlStyle f985m;
            @Nullable
            private InstantShoppingActionFragmentModel f986n;
            @Nullable
            private GraphQLInstantShoppingDocumentElementType f987o;
            @Nullable
            private InstantShoppingElementDescriptorFragmentModel f988p;
            @Nullable
            private ElementPhotoModel f989q;
            @Nullable
            private RichDocumentTextModel f990r;
            @Nullable
            private FBVideoModel f991s;
            private int f992t;
            @Nullable
            private FBFullImageFragmentModel f993u;
            private boolean f994v;
            @Nullable
            private String f995w;
            @Nullable
            private GraphQLDocumentVideoLoopingStyle f996x;
            @Nullable
            private RichDocumentTextModel f997y;
            @Nullable
            private RichDocumentTextModel f998z;

            /* compiled from: upload_date */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(FooterElementsModel.class, new Deserializer());
                }

                public Object m1056a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(InstantShoppingFooterElementFragmentParser.FooterElementsParser.m1308b(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object footerElementsModel = new FooterElementsModel();
                    ((BaseModel) footerElementsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (footerElementsModel instanceof Postprocessable) {
                        return ((Postprocessable) footerElementsModel).a();
                    }
                    return footerElementsModel;
                }
            }

            /* compiled from: upload_date */
            public class Serializer extends JsonSerializer<FooterElementsModel> {
                public final void m1057a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    FooterElementsModel footerElementsModel = (FooterElementsModel) obj;
                    if (footerElementsModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(footerElementsModel.m1076a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        footerElementsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    InstantShoppingFooterElementFragmentParser.FooterElementsParser.m1309b(footerElementsModel.w_(), footerElementsModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(FooterElementsModel.class, new Serializer());
                }
            }

            @Nullable
            public final /* synthetic */ InstantShoppingActionFragmentModel mo28a() {
                return m1072w();
            }

            @Nullable
            public final /* synthetic */ InstantShoppingElementDescriptorFragmentModel mo31d() {
                return m1060C();
            }

            @Nullable
            public final /* synthetic */ RichDocumentText iK_() {
                return m1062E();
            }

            @Nullable
            public final /* synthetic */ ElementPhotoModel mo39m() {
                return m1061D();
            }

            @Nullable
            public final /* synthetic */ FBFullImageFragmentModel mo40n() {
                return m1064G();
            }

            @Nullable
            public final /* synthetic */ InstantShoppingTextElementFragment mo41o() {
                return m1075z();
            }

            @Nullable
            public final /* synthetic */ InstantShoppingTextElementFragment mo42p() {
                return m1068K();
            }

            @Nullable
            public final /* synthetic */ InstantShoppingActionFragmentModel mo48q() {
                return m1059B();
            }

            @Nullable
            public final /* synthetic */ RichDocumentText mo50s() {
                return m1066I();
            }

            @Nullable
            public final /* synthetic */ RichDocumentText mo51t() {
                return m1067J();
            }

            @Nullable
            public final /* synthetic */ InstantShoppingActionFragmentModel mo52u() {
                return m1070M();
            }

            public FooterElementsModel() {
                super(28);
            }

            @Nullable
            private GraphQLObjectType m1071v() {
                if (this.b != null && this.f976d == null) {
                    this.f976d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
                }
                return this.f976d;
            }

            @Nullable
            private InstantShoppingActionFragmentModel m1072w() {
                this.f977e = (InstantShoppingActionFragmentModel) super.a(this.f977e, 1, InstantShoppingActionFragmentModel.class);
                return this.f977e;
            }

            @Nonnull
            public final ImmutableList<InstantShoppingTextElementFragmentModel> mo38l() {
                this.f978f = super.a(this.f978f, 2, InstantShoppingTextElementFragmentModel.class);
                return (ImmutableList) this.f978f;
            }

            @Nullable
            private GraphQLDocumentVideoAutoplayStyle m1073x() {
                this.f979g = (GraphQLDocumentVideoAutoplayStyle) super.b(this.f979g, 3, GraphQLDocumentVideoAutoplayStyle.class, GraphQLDocumentVideoAutoplayStyle.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
                return this.f979g;
            }

            @Nonnull
            public final ImmutableList<BlockElementsModel> iF_() {
                this.f980h = super.a(this.f980h, 4, BlockElementsModel.class);
                return (ImmutableList) this.f980h;
            }

            @Nonnull
            private ImmutableList<InstantShoppingPhotoElementFragmentModel> m1074y() {
                this.f981i = super.a(this.f981i, 5, InstantShoppingPhotoElementFragmentModel.class);
                return (ImmutableList) this.f981i;
            }

            @Nullable
            public final String mo29b() {
                this.f982j = super.a(this.f982j, 6);
                return this.f982j;
            }

            @Nonnull
            public final ImmutableList<InstantShoppingColorSelectorColorFragmentModel> mo36j() {
                this.f983k = super.a(this.f983k, 7, InstantShoppingColorSelectorColorFragmentModel.class);
                return (ImmutableList) this.f983k;
            }

            @Nullable
            private InstantShoppingTextElementFragmentModel m1075z() {
                this.f984l = (InstantShoppingTextElementFragmentModel) super.a(this.f984l, 8, InstantShoppingTextElementFragmentModel.class);
                return this.f984l;
            }

            @Nullable
            private GraphQLDocumentVideoControlStyle m1058A() {
                this.f985m = (GraphQLDocumentVideoControlStyle) super.b(this.f985m, 9, GraphQLDocumentVideoControlStyle.class, GraphQLDocumentVideoControlStyle.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
                return this.f985m;
            }

            @Nullable
            private InstantShoppingActionFragmentModel m1059B() {
                this.f986n = (InstantShoppingActionFragmentModel) super.a(this.f986n, 10, InstantShoppingActionFragmentModel.class);
                return this.f986n;
            }

            @Nullable
            public final GraphQLInstantShoppingDocumentElementType mo43c() {
                this.f987o = (GraphQLInstantShoppingDocumentElementType) super.b(this.f987o, 11, GraphQLInstantShoppingDocumentElementType.class, GraphQLInstantShoppingDocumentElementType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
                return this.f987o;
            }

            @Nullable
            private InstantShoppingElementDescriptorFragmentModel m1060C() {
                this.f988p = (InstantShoppingElementDescriptorFragmentModel) super.a(this.f988p, 12, InstantShoppingElementDescriptorFragmentModel.class);
                return this.f988p;
            }

            @Nullable
            private ElementPhotoModel m1061D() {
                this.f989q = (ElementPhotoModel) super.a(this.f989q, 13, ElementPhotoModel.class);
                return this.f989q;
            }

            @Nullable
            private RichDocumentTextModel m1062E() {
                this.f990r = (RichDocumentTextModel) super.a(this.f990r, 14, RichDocumentTextModel.class);
                return this.f990r;
            }

            @Nullable
            private FBVideoModel m1063F() {
                this.f991s = (FBVideoModel) super.a(this.f991s, 15, FBVideoModel.class);
                return this.f991s;
            }

            public final int mo45g() {
                a(2, 0);
                return this.f992t;
            }

            @Nullable
            private FBFullImageFragmentModel m1064G() {
                this.f993u = (FBFullImageFragmentModel) super.a(this.f993u, 17, FBFullImageFragmentModel.class);
                return this.f993u;
            }

            public final boolean mo49r() {
                a(2, 2);
                return this.f994v;
            }

            @Nullable
            public final String iI_() {
                this.f995w = super.a(this.f995w, 19);
                return this.f995w;
            }

            @Nullable
            private GraphQLDocumentVideoLoopingStyle m1065H() {
                this.f996x = (GraphQLDocumentVideoLoopingStyle) super.b(this.f996x, 20, GraphQLDocumentVideoLoopingStyle.class, GraphQLDocumentVideoLoopingStyle.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
                return this.f996x;
            }

            @Nullable
            private RichDocumentTextModel m1066I() {
                this.f997y = (RichDocumentTextModel) super.a(this.f997y, 21, RichDocumentTextModel.class);
                return this.f997y;
            }

            @Nullable
            private RichDocumentTextModel m1067J() {
                this.f998z = (RichDocumentTextModel) super.a(this.f998z, 22, RichDocumentTextModel.class);
                return this.f998z;
            }

            @Nullable
            private InstantShoppingTextElementFragmentModel m1068K() {
                this.f971A = (InstantShoppingTextElementFragmentModel) super.a(this.f971A, 23, InstantShoppingTextElementFragmentModel.class);
                return this.f971A;
            }

            public final int mo37k() {
                a(3, 0);
                return this.f972B;
            }

            @Nonnull
            public final ImmutableList<GraphQLInstantShoppingPresentationStyle> iJ_() {
                this.f973C = super.c(this.f973C, 25, GraphQLInstantShoppingPresentationStyle.class);
                return (ImmutableList) this.f973C;
            }

            @Nullable
            private String m1069L() {
                this.f974D = super.a(this.f974D, 26);
                return this.f974D;
            }

            @Nullable
            private InstantShoppingActionFragmentModel m1070M() {
                this.f975E = (InstantShoppingActionFragmentModel) super.a(this.f975E, 27, InstantShoppingActionFragmentModel.class);
                return this.f975E;
            }

            public final int jK_() {
                return 1808563160;
            }

            public final GraphQLVisitableModel m1077a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                InstantShoppingActionFragmentModel instantShoppingActionFragmentModel;
                Builder a;
                InstantShoppingTextElementFragmentModel instantShoppingTextElementFragmentModel;
                RichDocumentTextModel richDocumentTextModel;
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m1072w() != null) {
                    instantShoppingActionFragmentModel = (InstantShoppingActionFragmentModel) graphQLModelMutatingVisitor.b(m1072w());
                    if (m1072w() != instantShoppingActionFragmentModel) {
                        graphQLVisitableModel = (FooterElementsModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f977e = instantShoppingActionFragmentModel;
                    }
                }
                if (mo38l() != null) {
                    a = ModelHelper.a(mo38l(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        FooterElementsModel footerElementsModel = (FooterElementsModel) ModelHelper.a(graphQLVisitableModel, this);
                        footerElementsModel.f978f = a.b();
                        graphQLVisitableModel = footerElementsModel;
                    }
                }
                if (iF_() != null) {
                    a = ModelHelper.a(iF_(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        footerElementsModel = (FooterElementsModel) ModelHelper.a(graphQLVisitableModel, this);
                        footerElementsModel.f980h = a.b();
                        graphQLVisitableModel = footerElementsModel;
                    }
                }
                if (m1074y() != null) {
                    a = ModelHelper.a(m1074y(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        footerElementsModel = (FooterElementsModel) ModelHelper.a(graphQLVisitableModel, this);
                        footerElementsModel.f981i = a.b();
                        graphQLVisitableModel = footerElementsModel;
                    }
                }
                if (mo36j() != null) {
                    a = ModelHelper.a(mo36j(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        footerElementsModel = (FooterElementsModel) ModelHelper.a(graphQLVisitableModel, this);
                        footerElementsModel.f983k = a.b();
                        graphQLVisitableModel = footerElementsModel;
                    }
                }
                if (m1075z() != null) {
                    instantShoppingTextElementFragmentModel = (InstantShoppingTextElementFragmentModel) graphQLModelMutatingVisitor.b(m1075z());
                    if (m1075z() != instantShoppingTextElementFragmentModel) {
                        graphQLVisitableModel = (FooterElementsModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f984l = instantShoppingTextElementFragmentModel;
                    }
                }
                if (m1059B() != null) {
                    instantShoppingActionFragmentModel = (InstantShoppingActionFragmentModel) graphQLModelMutatingVisitor.b(m1059B());
                    if (m1059B() != instantShoppingActionFragmentModel) {
                        graphQLVisitableModel = (FooterElementsModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f986n = instantShoppingActionFragmentModel;
                    }
                }
                if (m1060C() != null) {
                    InstantShoppingElementDescriptorFragmentModel instantShoppingElementDescriptorFragmentModel = (InstantShoppingElementDescriptorFragmentModel) graphQLModelMutatingVisitor.b(m1060C());
                    if (m1060C() != instantShoppingElementDescriptorFragmentModel) {
                        graphQLVisitableModel = (FooterElementsModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f988p = instantShoppingElementDescriptorFragmentModel;
                    }
                }
                if (m1061D() != null) {
                    ElementPhotoModel elementPhotoModel = (ElementPhotoModel) graphQLModelMutatingVisitor.b(m1061D());
                    if (m1061D() != elementPhotoModel) {
                        graphQLVisitableModel = (FooterElementsModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f989q = elementPhotoModel;
                    }
                }
                if (m1062E() != null) {
                    richDocumentTextModel = (RichDocumentTextModel) graphQLModelMutatingVisitor.b(m1062E());
                    if (m1062E() != richDocumentTextModel) {
                        graphQLVisitableModel = (FooterElementsModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f990r = richDocumentTextModel;
                    }
                }
                if (m1063F() != null) {
                    FBVideoModel fBVideoModel = (FBVideoModel) graphQLModelMutatingVisitor.b(m1063F());
                    if (m1063F() != fBVideoModel) {
                        graphQLVisitableModel = (FooterElementsModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f991s = fBVideoModel;
                    }
                }
                if (m1064G() != null) {
                    FBFullImageFragmentModel fBFullImageFragmentModel = (FBFullImageFragmentModel) graphQLModelMutatingVisitor.b(m1064G());
                    if (m1064G() != fBFullImageFragmentModel) {
                        graphQLVisitableModel = (FooterElementsModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f993u = fBFullImageFragmentModel;
                    }
                }
                if (m1066I() != null) {
                    richDocumentTextModel = (RichDocumentTextModel) graphQLModelMutatingVisitor.b(m1066I());
                    if (m1066I() != richDocumentTextModel) {
                        graphQLVisitableModel = (FooterElementsModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f997y = richDocumentTextModel;
                    }
                }
                if (m1067J() != null) {
                    richDocumentTextModel = (RichDocumentTextModel) graphQLModelMutatingVisitor.b(m1067J());
                    if (m1067J() != richDocumentTextModel) {
                        graphQLVisitableModel = (FooterElementsModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f998z = richDocumentTextModel;
                    }
                }
                if (m1068K() != null) {
                    instantShoppingTextElementFragmentModel = (InstantShoppingTextElementFragmentModel) graphQLModelMutatingVisitor.b(m1068K());
                    if (m1068K() != instantShoppingTextElementFragmentModel) {
                        graphQLVisitableModel = (FooterElementsModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f971A = instantShoppingTextElementFragmentModel;
                    }
                }
                if (m1070M() != null) {
                    instantShoppingActionFragmentModel = (InstantShoppingActionFragmentModel) graphQLModelMutatingVisitor.b(m1070M());
                    if (m1070M() != instantShoppingActionFragmentModel) {
                        graphQLVisitableModel = (FooterElementsModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f975E = instantShoppingActionFragmentModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m1076a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m1071v());
                int a2 = ModelHelper.a(flatBufferBuilder, m1072w());
                int a3 = ModelHelper.a(flatBufferBuilder, mo38l());
                int a4 = flatBufferBuilder.a(m1073x());
                int a5 = ModelHelper.a(flatBufferBuilder, iF_());
                int a6 = ModelHelper.a(flatBufferBuilder, m1074y());
                int b = flatBufferBuilder.b(mo29b());
                int a7 = ModelHelper.a(flatBufferBuilder, mo36j());
                int a8 = ModelHelper.a(flatBufferBuilder, m1075z());
                int a9 = flatBufferBuilder.a(m1058A());
                int a10 = ModelHelper.a(flatBufferBuilder, m1059B());
                int a11 = flatBufferBuilder.a(mo43c());
                int a12 = ModelHelper.a(flatBufferBuilder, m1060C());
                int a13 = ModelHelper.a(flatBufferBuilder, m1061D());
                int a14 = ModelHelper.a(flatBufferBuilder, m1062E());
                int a15 = ModelHelper.a(flatBufferBuilder, m1063F());
                int a16 = ModelHelper.a(flatBufferBuilder, m1064G());
                int b2 = flatBufferBuilder.b(iI_());
                int a17 = flatBufferBuilder.a(m1065H());
                int a18 = ModelHelper.a(flatBufferBuilder, m1066I());
                int a19 = ModelHelper.a(flatBufferBuilder, m1067J());
                int a20 = ModelHelper.a(flatBufferBuilder, m1068K());
                int d = flatBufferBuilder.d(iJ_());
                int b3 = flatBufferBuilder.b(m1069L());
                int a21 = ModelHelper.a(flatBufferBuilder, m1070M());
                flatBufferBuilder.c(28);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.b(1, a2);
                flatBufferBuilder.b(2, a3);
                flatBufferBuilder.b(3, a4);
                flatBufferBuilder.b(4, a5);
                flatBufferBuilder.b(5, a6);
                flatBufferBuilder.b(6, b);
                flatBufferBuilder.b(7, a7);
                flatBufferBuilder.b(8, a8);
                flatBufferBuilder.b(9, a9);
                flatBufferBuilder.b(10, a10);
                flatBufferBuilder.b(11, a11);
                flatBufferBuilder.b(12, a12);
                flatBufferBuilder.b(13, a13);
                flatBufferBuilder.b(14, a14);
                flatBufferBuilder.b(15, a15);
                flatBufferBuilder.a(16, this.f992t, 0);
                flatBufferBuilder.b(17, a16);
                flatBufferBuilder.a(18, this.f994v);
                flatBufferBuilder.b(19, b2);
                flatBufferBuilder.b(20, a17);
                flatBufferBuilder.b(21, a18);
                flatBufferBuilder.b(22, a19);
                flatBufferBuilder.b(23, a20);
                flatBufferBuilder.a(24, this.f972B, 0);
                flatBufferBuilder.b(25, d);
                flatBufferBuilder.b(26, b3);
                flatBufferBuilder.b(27, a21);
                i();
                return flatBufferBuilder.d();
            }

            public final void m1079a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                super.a(mutableFlatBuffer, i, obj);
                this.f992t = mutableFlatBuffer.a(i, 16, 0);
                this.f994v = mutableFlatBuffer.a(i, 18);
                this.f972B = mutableFlatBuffer.a(i, 24, 0);
            }
        }

        /* compiled from: upload_date */
        public class Serializer extends JsonSerializer<InstantShoppingFooterElementFragmentModel> {
            public final void m1096a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                InstantShoppingFooterElementFragmentModel instantShoppingFooterElementFragmentModel = (InstantShoppingFooterElementFragmentModel) obj;
                if (instantShoppingFooterElementFragmentModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(instantShoppingFooterElementFragmentModel.m1101a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    instantShoppingFooterElementFragmentModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = instantShoppingFooterElementFragmentModel.w_();
                int u_ = instantShoppingFooterElementFragmentModel.u_();
                jsonGenerator.f();
                if (mutableFlatBuffer.g(u_, 0) != 0) {
                    jsonGenerator.a("document_element_type");
                    jsonGenerator.b(mutableFlatBuffer.b(u_, 0));
                }
                int g = mutableFlatBuffer.g(u_, 1);
                if (g != 0) {
                    jsonGenerator.a("element_descriptor");
                    InstantShoppingElementDescriptorFragmentParser.m1302a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                g = mutableFlatBuffer.g(u_, 2);
                if (g != 0) {
                    jsonGenerator.a("footer_elements");
                    InstantShoppingFooterElementFragmentParser.FooterElementsParser.m1307a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                if (mutableFlatBuffer.g(u_, 3) != 0) {
                    jsonGenerator.a("style_list");
                    SerializerHelpers.a(mutableFlatBuffer.f(u_, 3), jsonGenerator);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(InstantShoppingFooterElementFragmentModel.class, new Serializer());
            }
        }

        public InstantShoppingFooterElementFragmentModel() {
            super(4);
        }

        @Nullable
        private GraphQLInstantShoppingDocumentElementType m1097a() {
            this.f999d = (GraphQLInstantShoppingDocumentElementType) super.b(this.f999d, 0, GraphQLInstantShoppingDocumentElementType.class, GraphQLInstantShoppingDocumentElementType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
            return this.f999d;
        }

        @Nullable
        private InstantShoppingElementDescriptorFragmentModel m1098j() {
            this.f1000e = (InstantShoppingElementDescriptorFragmentModel) super.a(this.f1000e, 1, InstantShoppingElementDescriptorFragmentModel.class);
            return this.f1000e;
        }

        @Nonnull
        private ImmutableList<FooterElementsModel> m1099k() {
            this.f1001f = super.a(this.f1001f, 2, FooterElementsModel.class);
            return (ImmutableList) this.f1001f;
        }

        @Nonnull
        private ImmutableList<GraphQLInstantShoppingPresentationStyle> m1100l() {
            this.f1002g = super.c(this.f1002g, 3, GraphQLInstantShoppingPresentationStyle.class);
            return (ImmutableList) this.f1002g;
        }

        public final int jK_() {
            return -815999811;
        }

        public final GraphQLVisitableModel m1102a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m1098j() != null) {
                InstantShoppingElementDescriptorFragmentModel instantShoppingElementDescriptorFragmentModel = (InstantShoppingElementDescriptorFragmentModel) graphQLModelMutatingVisitor.b(m1098j());
                if (m1098j() != instantShoppingElementDescriptorFragmentModel) {
                    graphQLVisitableModel = (InstantShoppingFooterElementFragmentModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f1000e = instantShoppingElementDescriptorFragmentModel;
                }
            }
            if (m1099k() != null) {
                Builder a = ModelHelper.a(m1099k(), graphQLModelMutatingVisitor);
                if (a != null) {
                    InstantShoppingFooterElementFragmentModel instantShoppingFooterElementFragmentModel = (InstantShoppingFooterElementFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    instantShoppingFooterElementFragmentModel.f1001f = a.b();
                    graphQLVisitableModel = instantShoppingFooterElementFragmentModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m1101a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = flatBufferBuilder.a(m1097a());
            int a2 = ModelHelper.a(flatBufferBuilder, m1098j());
            int a3 = ModelHelper.a(flatBufferBuilder, m1099k());
            int d = flatBufferBuilder.d(m1100l());
            flatBufferBuilder.c(4);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, a2);
            flatBufferBuilder.b(2, a3);
            flatBufferBuilder.b(3, d);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -2001720444)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: upload_date */
    public final class InstantShoppingHeaderElementFragmentModel extends BaseModel implements GraphQLVisitableModel, InstantShoppingHeaderElementFragment {
        @Nullable
        private GraphQLInstantShoppingDocumentElementType f1031d;
        @Nullable
        private InstantShoppingElementDescriptorFragmentModel f1032e;
        @Nullable
        private List<HeaderElementsModel> f1033f;
        @Nullable
        private String f1034g;
        @Nullable
        private List<GraphQLInstantShoppingPresentationStyle> f1035h;

        /* compiled from: upload_date */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(InstantShoppingHeaderElementFragmentModel.class, new Deserializer());
            }

            public Object m1103a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = InstantShoppingHeaderElementFragmentParser.m1315a(jsonParser);
                Object instantShoppingHeaderElementFragmentModel = new InstantShoppingHeaderElementFragmentModel();
                ((BaseModel) instantShoppingHeaderElementFragmentModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (instantShoppingHeaderElementFragmentModel instanceof Postprocessable) {
                    return ((Postprocessable) instantShoppingHeaderElementFragmentModel).a();
                }
                return instantShoppingHeaderElementFragmentModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 1782734617)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: upload_date */
        public final class HeaderElementsModel extends BaseModel implements GraphQLVisitableModel, InstantShoppingButtonElementFragment, InstantShoppingColorSelectorElementFragment, InstantShoppingCompositeBlockElementFragment, InstantShoppingDocumentExpandableSectionElementFragment, InstantShoppingPhotoElementFragment, InstantShoppingTextElementFragment, InstantShoppingToggleElementFragment {
            @Nullable
            private InstantShoppingTextElementFragmentModel f1003A;
            private int f1004B;
            @Nullable
            private List<GraphQLInstantShoppingPresentationStyle> f1005C;
            @Nullable
            private String f1006D;
            @Nullable
            private InstantShoppingActionFragmentModel f1007E;
            @Nullable
            private GraphQLObjectType f1008d;
            @Nullable
            private InstantShoppingActionFragmentModel f1009e;
            @Nullable
            private List<InstantShoppingTextElementFragmentModel> f1010f;
            @Nullable
            private GraphQLDocumentVideoAutoplayStyle f1011g;
            @Nullable
            private List<BlockElementsModel> f1012h;
            @Nullable
            private List<InstantShoppingPhotoElementFragmentModel> f1013i;
            @Nullable
            private String f1014j;
            @Nullable
            private List<InstantShoppingColorSelectorColorFragmentModel> f1015k;
            @Nullable
            private InstantShoppingTextElementFragmentModel f1016l;
            @Nullable
            private GraphQLDocumentVideoControlStyle f1017m;
            @Nullable
            private InstantShoppingActionFragmentModel f1018n;
            @Nullable
            private GraphQLInstantShoppingDocumentElementType f1019o;
            @Nullable
            private InstantShoppingElementDescriptorFragmentModel f1020p;
            @Nullable
            private ElementPhotoModel f1021q;
            @Nullable
            private RichDocumentTextModel f1022r;
            @Nullable
            private FBVideoModel f1023s;
            private int f1024t;
            @Nullable
            private FBFullImageFragmentModel f1025u;
            private boolean f1026v;
            @Nullable
            private String f1027w;
            @Nullable
            private GraphQLDocumentVideoLoopingStyle f1028x;
            @Nullable
            private RichDocumentTextModel f1029y;
            @Nullable
            private RichDocumentTextModel f1030z;

            /* compiled from: upload_date */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(HeaderElementsModel.class, new Deserializer());
                }

                public Object m1104a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(InstantShoppingHeaderElementFragmentParser.HeaderElementsParser.m1313b(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object headerElementsModel = new HeaderElementsModel();
                    ((BaseModel) headerElementsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (headerElementsModel instanceof Postprocessable) {
                        return ((Postprocessable) headerElementsModel).a();
                    }
                    return headerElementsModel;
                }
            }

            /* compiled from: upload_date */
            public class Serializer extends JsonSerializer<HeaderElementsModel> {
                public final void m1105a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    HeaderElementsModel headerElementsModel = (HeaderElementsModel) obj;
                    if (headerElementsModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(headerElementsModel.m1124a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        headerElementsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    InstantShoppingHeaderElementFragmentParser.HeaderElementsParser.m1314b(headerElementsModel.w_(), headerElementsModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(HeaderElementsModel.class, new Serializer());
                }
            }

            @Nullable
            public final /* synthetic */ InstantShoppingActionFragmentModel mo28a() {
                return m1120w();
            }

            @Nullable
            public final /* synthetic */ InstantShoppingElementDescriptorFragmentModel mo31d() {
                return m1108C();
            }

            @Nullable
            public final /* synthetic */ RichDocumentText iK_() {
                return m1110E();
            }

            @Nullable
            public final /* synthetic */ ElementPhotoModel mo39m() {
                return m1109D();
            }

            @Nullable
            public final /* synthetic */ FBFullImageFragmentModel mo40n() {
                return m1112G();
            }

            @Nullable
            public final /* synthetic */ InstantShoppingTextElementFragment mo41o() {
                return m1123z();
            }

            @Nullable
            public final /* synthetic */ InstantShoppingTextElementFragment mo42p() {
                return m1116K();
            }

            @Nullable
            public final /* synthetic */ InstantShoppingActionFragmentModel mo48q() {
                return m1107B();
            }

            @Nullable
            public final /* synthetic */ RichDocumentText mo50s() {
                return m1114I();
            }

            @Nullable
            public final /* synthetic */ RichDocumentText mo51t() {
                return m1115J();
            }

            @Nullable
            public final /* synthetic */ InstantShoppingActionFragmentModel mo52u() {
                return m1118M();
            }

            public HeaderElementsModel() {
                super(28);
            }

            @Nullable
            private GraphQLObjectType m1119v() {
                if (this.b != null && this.f1008d == null) {
                    this.f1008d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
                }
                return this.f1008d;
            }

            @Nullable
            private InstantShoppingActionFragmentModel m1120w() {
                this.f1009e = (InstantShoppingActionFragmentModel) super.a(this.f1009e, 1, InstantShoppingActionFragmentModel.class);
                return this.f1009e;
            }

            @Nonnull
            public final ImmutableList<InstantShoppingTextElementFragmentModel> mo38l() {
                this.f1010f = super.a(this.f1010f, 2, InstantShoppingTextElementFragmentModel.class);
                return (ImmutableList) this.f1010f;
            }

            @Nullable
            private GraphQLDocumentVideoAutoplayStyle m1121x() {
                this.f1011g = (GraphQLDocumentVideoAutoplayStyle) super.b(this.f1011g, 3, GraphQLDocumentVideoAutoplayStyle.class, GraphQLDocumentVideoAutoplayStyle.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
                return this.f1011g;
            }

            @Nonnull
            public final ImmutableList<BlockElementsModel> iF_() {
                this.f1012h = super.a(this.f1012h, 4, BlockElementsModel.class);
                return (ImmutableList) this.f1012h;
            }

            @Nonnull
            private ImmutableList<InstantShoppingPhotoElementFragmentModel> m1122y() {
                this.f1013i = super.a(this.f1013i, 5, InstantShoppingPhotoElementFragmentModel.class);
                return (ImmutableList) this.f1013i;
            }

            @Nullable
            public final String mo29b() {
                this.f1014j = super.a(this.f1014j, 6);
                return this.f1014j;
            }

            @Nonnull
            public final ImmutableList<InstantShoppingColorSelectorColorFragmentModel> mo36j() {
                this.f1015k = super.a(this.f1015k, 7, InstantShoppingColorSelectorColorFragmentModel.class);
                return (ImmutableList) this.f1015k;
            }

            @Nullable
            private InstantShoppingTextElementFragmentModel m1123z() {
                this.f1016l = (InstantShoppingTextElementFragmentModel) super.a(this.f1016l, 8, InstantShoppingTextElementFragmentModel.class);
                return this.f1016l;
            }

            @Nullable
            private GraphQLDocumentVideoControlStyle m1106A() {
                this.f1017m = (GraphQLDocumentVideoControlStyle) super.b(this.f1017m, 9, GraphQLDocumentVideoControlStyle.class, GraphQLDocumentVideoControlStyle.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
                return this.f1017m;
            }

            @Nullable
            private InstantShoppingActionFragmentModel m1107B() {
                this.f1018n = (InstantShoppingActionFragmentModel) super.a(this.f1018n, 10, InstantShoppingActionFragmentModel.class);
                return this.f1018n;
            }

            @Nullable
            public final GraphQLInstantShoppingDocumentElementType mo43c() {
                this.f1019o = (GraphQLInstantShoppingDocumentElementType) super.b(this.f1019o, 11, GraphQLInstantShoppingDocumentElementType.class, GraphQLInstantShoppingDocumentElementType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
                return this.f1019o;
            }

            @Nullable
            private InstantShoppingElementDescriptorFragmentModel m1108C() {
                this.f1020p = (InstantShoppingElementDescriptorFragmentModel) super.a(this.f1020p, 12, InstantShoppingElementDescriptorFragmentModel.class);
                return this.f1020p;
            }

            @Nullable
            private ElementPhotoModel m1109D() {
                this.f1021q = (ElementPhotoModel) super.a(this.f1021q, 13, ElementPhotoModel.class);
                return this.f1021q;
            }

            @Nullable
            private RichDocumentTextModel m1110E() {
                this.f1022r = (RichDocumentTextModel) super.a(this.f1022r, 14, RichDocumentTextModel.class);
                return this.f1022r;
            }

            @Nullable
            private FBVideoModel m1111F() {
                this.f1023s = (FBVideoModel) super.a(this.f1023s, 15, FBVideoModel.class);
                return this.f1023s;
            }

            public final int mo45g() {
                a(2, 0);
                return this.f1024t;
            }

            @Nullable
            private FBFullImageFragmentModel m1112G() {
                this.f1025u = (FBFullImageFragmentModel) super.a(this.f1025u, 17, FBFullImageFragmentModel.class);
                return this.f1025u;
            }

            public final boolean mo49r() {
                a(2, 2);
                return this.f1026v;
            }

            @Nullable
            public final String iI_() {
                this.f1027w = super.a(this.f1027w, 19);
                return this.f1027w;
            }

            @Nullable
            private GraphQLDocumentVideoLoopingStyle m1113H() {
                this.f1028x = (GraphQLDocumentVideoLoopingStyle) super.b(this.f1028x, 20, GraphQLDocumentVideoLoopingStyle.class, GraphQLDocumentVideoLoopingStyle.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
                return this.f1028x;
            }

            @Nullable
            private RichDocumentTextModel m1114I() {
                this.f1029y = (RichDocumentTextModel) super.a(this.f1029y, 21, RichDocumentTextModel.class);
                return this.f1029y;
            }

            @Nullable
            private RichDocumentTextModel m1115J() {
                this.f1030z = (RichDocumentTextModel) super.a(this.f1030z, 22, RichDocumentTextModel.class);
                return this.f1030z;
            }

            @Nullable
            private InstantShoppingTextElementFragmentModel m1116K() {
                this.f1003A = (InstantShoppingTextElementFragmentModel) super.a(this.f1003A, 23, InstantShoppingTextElementFragmentModel.class);
                return this.f1003A;
            }

            public final int mo37k() {
                a(3, 0);
                return this.f1004B;
            }

            @Nonnull
            public final ImmutableList<GraphQLInstantShoppingPresentationStyle> iJ_() {
                this.f1005C = super.c(this.f1005C, 25, GraphQLInstantShoppingPresentationStyle.class);
                return (ImmutableList) this.f1005C;
            }

            @Nullable
            private String m1117L() {
                this.f1006D = super.a(this.f1006D, 26);
                return this.f1006D;
            }

            @Nullable
            private InstantShoppingActionFragmentModel m1118M() {
                this.f1007E = (InstantShoppingActionFragmentModel) super.a(this.f1007E, 27, InstantShoppingActionFragmentModel.class);
                return this.f1007E;
            }

            public final int jK_() {
                return 1808563160;
            }

            public final GraphQLVisitableModel m1125a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                InstantShoppingActionFragmentModel instantShoppingActionFragmentModel;
                Builder a;
                InstantShoppingTextElementFragmentModel instantShoppingTextElementFragmentModel;
                RichDocumentTextModel richDocumentTextModel;
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m1120w() != null) {
                    instantShoppingActionFragmentModel = (InstantShoppingActionFragmentModel) graphQLModelMutatingVisitor.b(m1120w());
                    if (m1120w() != instantShoppingActionFragmentModel) {
                        graphQLVisitableModel = (HeaderElementsModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f1009e = instantShoppingActionFragmentModel;
                    }
                }
                if (mo38l() != null) {
                    a = ModelHelper.a(mo38l(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        HeaderElementsModel headerElementsModel = (HeaderElementsModel) ModelHelper.a(graphQLVisitableModel, this);
                        headerElementsModel.f1010f = a.b();
                        graphQLVisitableModel = headerElementsModel;
                    }
                }
                if (iF_() != null) {
                    a = ModelHelper.a(iF_(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        headerElementsModel = (HeaderElementsModel) ModelHelper.a(graphQLVisitableModel, this);
                        headerElementsModel.f1012h = a.b();
                        graphQLVisitableModel = headerElementsModel;
                    }
                }
                if (m1122y() != null) {
                    a = ModelHelper.a(m1122y(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        headerElementsModel = (HeaderElementsModel) ModelHelper.a(graphQLVisitableModel, this);
                        headerElementsModel.f1013i = a.b();
                        graphQLVisitableModel = headerElementsModel;
                    }
                }
                if (mo36j() != null) {
                    a = ModelHelper.a(mo36j(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        headerElementsModel = (HeaderElementsModel) ModelHelper.a(graphQLVisitableModel, this);
                        headerElementsModel.f1015k = a.b();
                        graphQLVisitableModel = headerElementsModel;
                    }
                }
                if (m1123z() != null) {
                    instantShoppingTextElementFragmentModel = (InstantShoppingTextElementFragmentModel) graphQLModelMutatingVisitor.b(m1123z());
                    if (m1123z() != instantShoppingTextElementFragmentModel) {
                        graphQLVisitableModel = (HeaderElementsModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f1016l = instantShoppingTextElementFragmentModel;
                    }
                }
                if (m1107B() != null) {
                    instantShoppingActionFragmentModel = (InstantShoppingActionFragmentModel) graphQLModelMutatingVisitor.b(m1107B());
                    if (m1107B() != instantShoppingActionFragmentModel) {
                        graphQLVisitableModel = (HeaderElementsModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f1018n = instantShoppingActionFragmentModel;
                    }
                }
                if (m1108C() != null) {
                    InstantShoppingElementDescriptorFragmentModel instantShoppingElementDescriptorFragmentModel = (InstantShoppingElementDescriptorFragmentModel) graphQLModelMutatingVisitor.b(m1108C());
                    if (m1108C() != instantShoppingElementDescriptorFragmentModel) {
                        graphQLVisitableModel = (HeaderElementsModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f1020p = instantShoppingElementDescriptorFragmentModel;
                    }
                }
                if (m1109D() != null) {
                    ElementPhotoModel elementPhotoModel = (ElementPhotoModel) graphQLModelMutatingVisitor.b(m1109D());
                    if (m1109D() != elementPhotoModel) {
                        graphQLVisitableModel = (HeaderElementsModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f1021q = elementPhotoModel;
                    }
                }
                if (m1110E() != null) {
                    richDocumentTextModel = (RichDocumentTextModel) graphQLModelMutatingVisitor.b(m1110E());
                    if (m1110E() != richDocumentTextModel) {
                        graphQLVisitableModel = (HeaderElementsModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f1022r = richDocumentTextModel;
                    }
                }
                if (m1111F() != null) {
                    FBVideoModel fBVideoModel = (FBVideoModel) graphQLModelMutatingVisitor.b(m1111F());
                    if (m1111F() != fBVideoModel) {
                        graphQLVisitableModel = (HeaderElementsModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f1023s = fBVideoModel;
                    }
                }
                if (m1112G() != null) {
                    FBFullImageFragmentModel fBFullImageFragmentModel = (FBFullImageFragmentModel) graphQLModelMutatingVisitor.b(m1112G());
                    if (m1112G() != fBFullImageFragmentModel) {
                        graphQLVisitableModel = (HeaderElementsModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f1025u = fBFullImageFragmentModel;
                    }
                }
                if (m1114I() != null) {
                    richDocumentTextModel = (RichDocumentTextModel) graphQLModelMutatingVisitor.b(m1114I());
                    if (m1114I() != richDocumentTextModel) {
                        graphQLVisitableModel = (HeaderElementsModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f1029y = richDocumentTextModel;
                    }
                }
                if (m1115J() != null) {
                    richDocumentTextModel = (RichDocumentTextModel) graphQLModelMutatingVisitor.b(m1115J());
                    if (m1115J() != richDocumentTextModel) {
                        graphQLVisitableModel = (HeaderElementsModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f1030z = richDocumentTextModel;
                    }
                }
                if (m1116K() != null) {
                    instantShoppingTextElementFragmentModel = (InstantShoppingTextElementFragmentModel) graphQLModelMutatingVisitor.b(m1116K());
                    if (m1116K() != instantShoppingTextElementFragmentModel) {
                        graphQLVisitableModel = (HeaderElementsModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f1003A = instantShoppingTextElementFragmentModel;
                    }
                }
                if (m1118M() != null) {
                    instantShoppingActionFragmentModel = (InstantShoppingActionFragmentModel) graphQLModelMutatingVisitor.b(m1118M());
                    if (m1118M() != instantShoppingActionFragmentModel) {
                        graphQLVisitableModel = (HeaderElementsModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f1007E = instantShoppingActionFragmentModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m1124a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m1119v());
                int a2 = ModelHelper.a(flatBufferBuilder, m1120w());
                int a3 = ModelHelper.a(flatBufferBuilder, mo38l());
                int a4 = flatBufferBuilder.a(m1121x());
                int a5 = ModelHelper.a(flatBufferBuilder, iF_());
                int a6 = ModelHelper.a(flatBufferBuilder, m1122y());
                int b = flatBufferBuilder.b(mo29b());
                int a7 = ModelHelper.a(flatBufferBuilder, mo36j());
                int a8 = ModelHelper.a(flatBufferBuilder, m1123z());
                int a9 = flatBufferBuilder.a(m1106A());
                int a10 = ModelHelper.a(flatBufferBuilder, m1107B());
                int a11 = flatBufferBuilder.a(mo43c());
                int a12 = ModelHelper.a(flatBufferBuilder, m1108C());
                int a13 = ModelHelper.a(flatBufferBuilder, m1109D());
                int a14 = ModelHelper.a(flatBufferBuilder, m1110E());
                int a15 = ModelHelper.a(flatBufferBuilder, m1111F());
                int a16 = ModelHelper.a(flatBufferBuilder, m1112G());
                int b2 = flatBufferBuilder.b(iI_());
                int a17 = flatBufferBuilder.a(m1113H());
                int a18 = ModelHelper.a(flatBufferBuilder, m1114I());
                int a19 = ModelHelper.a(flatBufferBuilder, m1115J());
                int a20 = ModelHelper.a(flatBufferBuilder, m1116K());
                int d = flatBufferBuilder.d(iJ_());
                int b3 = flatBufferBuilder.b(m1117L());
                int a21 = ModelHelper.a(flatBufferBuilder, m1118M());
                flatBufferBuilder.c(28);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.b(1, a2);
                flatBufferBuilder.b(2, a3);
                flatBufferBuilder.b(3, a4);
                flatBufferBuilder.b(4, a5);
                flatBufferBuilder.b(5, a6);
                flatBufferBuilder.b(6, b);
                flatBufferBuilder.b(7, a7);
                flatBufferBuilder.b(8, a8);
                flatBufferBuilder.b(9, a9);
                flatBufferBuilder.b(10, a10);
                flatBufferBuilder.b(11, a11);
                flatBufferBuilder.b(12, a12);
                flatBufferBuilder.b(13, a13);
                flatBufferBuilder.b(14, a14);
                flatBufferBuilder.b(15, a15);
                flatBufferBuilder.a(16, this.f1024t, 0);
                flatBufferBuilder.b(17, a16);
                flatBufferBuilder.a(18, this.f1026v);
                flatBufferBuilder.b(19, b2);
                flatBufferBuilder.b(20, a17);
                flatBufferBuilder.b(21, a18);
                flatBufferBuilder.b(22, a19);
                flatBufferBuilder.b(23, a20);
                flatBufferBuilder.a(24, this.f1004B, 0);
                flatBufferBuilder.b(25, d);
                flatBufferBuilder.b(26, b3);
                flatBufferBuilder.b(27, a21);
                i();
                return flatBufferBuilder.d();
            }

            public final void m1127a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                super.a(mutableFlatBuffer, i, obj);
                this.f1024t = mutableFlatBuffer.a(i, 16, 0);
                this.f1026v = mutableFlatBuffer.a(i, 18);
                this.f1004B = mutableFlatBuffer.a(i, 24, 0);
            }
        }

        /* compiled from: upload_date */
        public class Serializer extends JsonSerializer<InstantShoppingHeaderElementFragmentModel> {
            public final void m1144a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                InstantShoppingHeaderElementFragmentModel instantShoppingHeaderElementFragmentModel = (InstantShoppingHeaderElementFragmentModel) obj;
                if (instantShoppingHeaderElementFragmentModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(instantShoppingHeaderElementFragmentModel.m1150a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    instantShoppingHeaderElementFragmentModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = instantShoppingHeaderElementFragmentModel.w_();
                int u_ = instantShoppingHeaderElementFragmentModel.u_();
                jsonGenerator.f();
                if (mutableFlatBuffer.g(u_, 0) != 0) {
                    jsonGenerator.a("document_element_type");
                    jsonGenerator.b(mutableFlatBuffer.b(u_, 0));
                }
                int g = mutableFlatBuffer.g(u_, 1);
                if (g != 0) {
                    jsonGenerator.a("element_descriptor");
                    InstantShoppingElementDescriptorFragmentParser.m1302a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                g = mutableFlatBuffer.g(u_, 2);
                if (g != 0) {
                    jsonGenerator.a("header_elements");
                    InstantShoppingHeaderElementFragmentParser.HeaderElementsParser.m1312a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                if (mutableFlatBuffer.g(u_, 3) != 0) {
                    jsonGenerator.a("logging_token");
                    jsonGenerator.b(mutableFlatBuffer.c(u_, 3));
                }
                if (mutableFlatBuffer.g(u_, 4) != 0) {
                    jsonGenerator.a("style_list");
                    SerializerHelpers.a(mutableFlatBuffer.f(u_, 4), jsonGenerator);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(InstantShoppingHeaderElementFragmentModel.class, new Serializer());
            }
        }

        public InstantShoppingHeaderElementFragmentModel() {
            super(5);
        }

        @Nullable
        private GraphQLInstantShoppingDocumentElementType m1145a() {
            this.f1031d = (GraphQLInstantShoppingDocumentElementType) super.b(this.f1031d, 0, GraphQLInstantShoppingDocumentElementType.class, GraphQLInstantShoppingDocumentElementType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
            return this.f1031d;
        }

        @Nullable
        private InstantShoppingElementDescriptorFragmentModel m1146j() {
            this.f1032e = (InstantShoppingElementDescriptorFragmentModel) super.a(this.f1032e, 1, InstantShoppingElementDescriptorFragmentModel.class);
            return this.f1032e;
        }

        @Nonnull
        private ImmutableList<HeaderElementsModel> m1147k() {
            this.f1033f = super.a(this.f1033f, 2, HeaderElementsModel.class);
            return (ImmutableList) this.f1033f;
        }

        @Nullable
        private String m1148l() {
            this.f1034g = super.a(this.f1034g, 3);
            return this.f1034g;
        }

        @Nonnull
        private ImmutableList<GraphQLInstantShoppingPresentationStyle> m1149m() {
            this.f1035h = super.c(this.f1035h, 4, GraphQLInstantShoppingPresentationStyle.class);
            return (ImmutableList) this.f1035h;
        }

        public final int jK_() {
            return -161901685;
        }

        public final GraphQLVisitableModel m1151a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m1146j() != null) {
                InstantShoppingElementDescriptorFragmentModel instantShoppingElementDescriptorFragmentModel = (InstantShoppingElementDescriptorFragmentModel) graphQLModelMutatingVisitor.b(m1146j());
                if (m1146j() != instantShoppingElementDescriptorFragmentModel) {
                    graphQLVisitableModel = (InstantShoppingHeaderElementFragmentModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f1032e = instantShoppingElementDescriptorFragmentModel;
                }
            }
            if (m1147k() != null) {
                Builder a = ModelHelper.a(m1147k(), graphQLModelMutatingVisitor);
                if (a != null) {
                    InstantShoppingHeaderElementFragmentModel instantShoppingHeaderElementFragmentModel = (InstantShoppingHeaderElementFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    instantShoppingHeaderElementFragmentModel.f1033f = a.b();
                    graphQLVisitableModel = instantShoppingHeaderElementFragmentModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m1150a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = flatBufferBuilder.a(m1145a());
            int a2 = ModelHelper.a(flatBufferBuilder, m1146j());
            int a3 = ModelHelper.a(flatBufferBuilder, m1147k());
            int b = flatBufferBuilder.b(m1148l());
            int d = flatBufferBuilder.d(m1149m());
            flatBufferBuilder.c(5);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, a2);
            flatBufferBuilder.b(2, a3);
            flatBufferBuilder.b(3, b);
            flatBufferBuilder.b(4, d);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -1954941648)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: upload_date */
    public final class InstantShoppingOptionsActionFragmentModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private GraphQLObjectType f1036d;
        @Nullable
        private GraphQLInstantShoppingActionType f1037e;
        @Nullable
        private GraphQLInstantShoppingPostActionNoticeStyle f1038f;
        @Nullable
        private String f1039g;
        @Nullable
        private String f1040h;
        private boolean f1041i;
        @Nullable
        private String f1042j;

        /* compiled from: upload_date */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(InstantShoppingOptionsActionFragmentModel.class, new Deserializer());
            }

            public Object m1152a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(InstantShoppingOptionsActionFragmentParser.m1316a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object instantShoppingOptionsActionFragmentModel = new InstantShoppingOptionsActionFragmentModel();
                ((BaseModel) instantShoppingOptionsActionFragmentModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (instantShoppingOptionsActionFragmentModel instanceof Postprocessable) {
                    return ((Postprocessable) instantShoppingOptionsActionFragmentModel).a();
                }
                return instantShoppingOptionsActionFragmentModel;
            }
        }

        /* compiled from: upload_date */
        public class Serializer extends JsonSerializer<InstantShoppingOptionsActionFragmentModel> {
            public final void m1153a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                InstantShoppingOptionsActionFragmentModel instantShoppingOptionsActionFragmentModel = (InstantShoppingOptionsActionFragmentModel) obj;
                if (instantShoppingOptionsActionFragmentModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(instantShoppingOptionsActionFragmentModel.m1157a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    instantShoppingOptionsActionFragmentModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                InstantShoppingOptionsActionFragmentParser.m1317a(instantShoppingOptionsActionFragmentModel.w_(), instantShoppingOptionsActionFragmentModel.u_(), jsonGenerator);
            }

            static {
                FbSerializerProvider.a(InstantShoppingOptionsActionFragmentModel.class, new Serializer());
            }
        }

        public InstantShoppingOptionsActionFragmentModel() {
            super(7);
        }

        @Nullable
        private GraphQLObjectType m1154j() {
            if (this.b != null && this.f1036d == null) {
                this.f1036d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
            }
            return this.f1036d;
        }

        @Nullable
        public final GraphQLInstantShoppingActionType m1158a() {
            this.f1037e = (GraphQLInstantShoppingActionType) super.b(this.f1037e, 1, GraphQLInstantShoppingActionType.class, GraphQLInstantShoppingActionType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
            return this.f1037e;
        }

        @Nullable
        private GraphQLInstantShoppingPostActionNoticeStyle m1155k() {
            this.f1038f = (GraphQLInstantShoppingPostActionNoticeStyle) super.b(this.f1038f, 2, GraphQLInstantShoppingPostActionNoticeStyle.class, GraphQLInstantShoppingPostActionNoticeStyle.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
            return this.f1038f;
        }

        @Nullable
        private String m1156l() {
            this.f1039g = super.a(this.f1039g, 3);
            return this.f1039g;
        }

        @Nullable
        public final String m1161b() {
            this.f1040h = super.a(this.f1040h, 4);
            return this.f1040h;
        }

        public final boolean m1162c() {
            a(0, 5);
            return this.f1041i;
        }

        @Nullable
        public final String m1163d() {
            this.f1042j = super.a(this.f1042j, 6);
            return this.f1042j;
        }

        public final int jK_() {
            return 1940230623;
        }

        public final GraphQLVisitableModel m1159a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            h();
            i();
            return this;
        }

        public final int m1157a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m1154j());
            int a2 = flatBufferBuilder.a(m1158a());
            int a3 = flatBufferBuilder.a(m1155k());
            int b = flatBufferBuilder.b(m1156l());
            int b2 = flatBufferBuilder.b(m1161b());
            int b3 = flatBufferBuilder.b(m1163d());
            flatBufferBuilder.c(7);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, a2);
            flatBufferBuilder.b(2, a3);
            flatBufferBuilder.b(3, b);
            flatBufferBuilder.b(4, b2);
            flatBufferBuilder.a(5, this.f1041i);
            flatBufferBuilder.b(6, b3);
            i();
            return flatBufferBuilder.d();
        }

        public final void m1160a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
            super.a(mutableFlatBuffer, i, obj);
            this.f1041i = mutableFlatBuffer.a(i, 5);
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -1223817355)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: upload_date */
    public final class InstantShoppingPhotoElementFragmentModel extends BaseModel implements GraphQLVisitableModel, InstantShoppingPhotoElementFragment {
        @Nullable
        private InstantShoppingActionFragmentModel f1044d;
        @Nullable
        private List<InstantShoppingTextElementFragmentModel> f1045e;
        @Nullable
        private GraphQLInstantShoppingDocumentElementType f1046f;
        @Nullable
        private InstantShoppingElementDescriptorFragmentModel f1047g;
        @Nullable
        private ElementPhotoModel f1048h;
        private int f1049i;
        @Nullable
        private FBFullImageFragmentModel f1050j;
        @Nullable
        private String f1051k;
        @Nullable
        private List<GraphQLInstantShoppingPresentationStyle> f1052l;
        @Nullable
        private String f1053m;

        /* compiled from: upload_date */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(InstantShoppingPhotoElementFragmentModel.class, new Deserializer());
            }

            public Object m1164a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(InstantShoppingPhotoElementFragmentParser.m1322b(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object instantShoppingPhotoElementFragmentModel = new InstantShoppingPhotoElementFragmentModel();
                ((BaseModel) instantShoppingPhotoElementFragmentModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (instantShoppingPhotoElementFragmentModel instanceof Postprocessable) {
                    return ((Postprocessable) instantShoppingPhotoElementFragmentModel).a();
                }
                return instantShoppingPhotoElementFragmentModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 1244564590)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: upload_date */
        public final class ElementPhotoModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private String f1043d;

            /* compiled from: upload_date */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(ElementPhotoModel.class, new Deserializer());
                }

                public Object m1165a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(ElementPhotoParser.m1318a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object elementPhotoModel = new ElementPhotoModel();
                    ((BaseModel) elementPhotoModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (elementPhotoModel instanceof Postprocessable) {
                        return ((Postprocessable) elementPhotoModel).a();
                    }
                    return elementPhotoModel;
                }
            }

            /* compiled from: upload_date */
            public class Serializer extends JsonSerializer<ElementPhotoModel> {
                public final void m1166a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    ElementPhotoModel elementPhotoModel = (ElementPhotoModel) obj;
                    if (elementPhotoModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(elementPhotoModel.m1167a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        elementPhotoModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    ElementPhotoParser.m1319a(elementPhotoModel.w_(), elementPhotoModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(ElementPhotoModel.class, new Serializer());
                }
            }

            public ElementPhotoModel() {
                super(1);
            }

            @Nullable
            public final String m1169a() {
                this.f1043d = super.a(this.f1043d, 0);
                return this.f1043d;
            }

            public final int jK_() {
                return 77090322;
            }

            public final GraphQLVisitableModel m1168a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m1167a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m1169a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, b);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: upload_date */
        public class Serializer extends JsonSerializer<InstantShoppingPhotoElementFragmentModel> {
            public final void m1170a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                InstantShoppingPhotoElementFragmentModel instantShoppingPhotoElementFragmentModel = (InstantShoppingPhotoElementFragmentModel) obj;
                if (instantShoppingPhotoElementFragmentModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(instantShoppingPhotoElementFragmentModel.m1176a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    instantShoppingPhotoElementFragmentModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                InstantShoppingPhotoElementFragmentParser.m1323b(instantShoppingPhotoElementFragmentModel.w_(), instantShoppingPhotoElementFragmentModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(InstantShoppingPhotoElementFragmentModel.class, new Serializer());
            }
        }

        @Nullable
        public final /* synthetic */ InstantShoppingActionFragmentModel mo28a() {
            return m1171j();
        }

        @Nullable
        public final /* synthetic */ InstantShoppingElementDescriptorFragmentModel mo31d() {
            return m1172k();
        }

        @Nullable
        public final /* synthetic */ ElementPhotoModel mo39m() {
            return m1173o();
        }

        @Nullable
        public final /* synthetic */ FBFullImageFragmentModel mo40n() {
            return m1174p();
        }

        public InstantShoppingPhotoElementFragmentModel() {
            super(10);
        }

        @Nullable
        private InstantShoppingActionFragmentModel m1171j() {
            this.f1044d = (InstantShoppingActionFragmentModel) super.a(this.f1044d, 0, InstantShoppingActionFragmentModel.class);
            return this.f1044d;
        }

        @Nonnull
        public final ImmutableList<InstantShoppingTextElementFragmentModel> mo38l() {
            this.f1045e = super.a(this.f1045e, 1, InstantShoppingTextElementFragmentModel.class);
            return (ImmutableList) this.f1045e;
        }

        @Nullable
        public final GraphQLInstantShoppingDocumentElementType mo30c() {
            this.f1046f = (GraphQLInstantShoppingDocumentElementType) super.b(this.f1046f, 2, GraphQLInstantShoppingDocumentElementType.class, GraphQLInstantShoppingDocumentElementType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
            return this.f1046f;
        }

        @Nullable
        private InstantShoppingElementDescriptorFragmentModel m1172k() {
            this.f1047g = (InstantShoppingElementDescriptorFragmentModel) super.a(this.f1047g, 3, InstantShoppingElementDescriptorFragmentModel.class);
            return this.f1047g;
        }

        @Nullable
        private ElementPhotoModel m1173o() {
            this.f1048h = (ElementPhotoModel) super.a(this.f1048h, 4, ElementPhotoModel.class);
            return this.f1048h;
        }

        @Nullable
        private FBFullImageFragmentModel m1174p() {
            this.f1050j = (FBFullImageFragmentModel) super.a(this.f1050j, 6, FBFullImageFragmentModel.class);
            return this.f1050j;
        }

        @Nullable
        public final String iI_() {
            this.f1051k = super.a(this.f1051k, 7);
            return this.f1051k;
        }

        @Nonnull
        public final ImmutableList<GraphQLInstantShoppingPresentationStyle> iJ_() {
            this.f1052l = super.c(this.f1052l, 8, GraphQLInstantShoppingPresentationStyle.class);
            return (ImmutableList) this.f1052l;
        }

        @Nullable
        private String m1175q() {
            this.f1053m = super.a(this.f1053m, 9);
            return this.f1053m;
        }

        public final int jK_() {
            return -1875654386;
        }

        public final GraphQLVisitableModel m1177a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m1171j() != null) {
                InstantShoppingActionFragmentModel instantShoppingActionFragmentModel = (InstantShoppingActionFragmentModel) graphQLModelMutatingVisitor.b(m1171j());
                if (m1171j() != instantShoppingActionFragmentModel) {
                    graphQLVisitableModel = (InstantShoppingPhotoElementFragmentModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f1044d = instantShoppingActionFragmentModel;
                }
            }
            if (mo38l() != null) {
                Builder a = ModelHelper.a(mo38l(), graphQLModelMutatingVisitor);
                if (a != null) {
                    InstantShoppingPhotoElementFragmentModel instantShoppingPhotoElementFragmentModel = (InstantShoppingPhotoElementFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    instantShoppingPhotoElementFragmentModel.f1045e = a.b();
                    graphQLVisitableModel = instantShoppingPhotoElementFragmentModel;
                }
            }
            if (m1172k() != null) {
                InstantShoppingElementDescriptorFragmentModel instantShoppingElementDescriptorFragmentModel = (InstantShoppingElementDescriptorFragmentModel) graphQLModelMutatingVisitor.b(m1172k());
                if (m1172k() != instantShoppingElementDescriptorFragmentModel) {
                    graphQLVisitableModel = (InstantShoppingPhotoElementFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f1047g = instantShoppingElementDescriptorFragmentModel;
                }
            }
            if (m1173o() != null) {
                ElementPhotoModel elementPhotoModel = (ElementPhotoModel) graphQLModelMutatingVisitor.b(m1173o());
                if (m1173o() != elementPhotoModel) {
                    graphQLVisitableModel = (InstantShoppingPhotoElementFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f1048h = elementPhotoModel;
                }
            }
            if (m1174p() != null) {
                FBFullImageFragmentModel fBFullImageFragmentModel = (FBFullImageFragmentModel) graphQLModelMutatingVisitor.b(m1174p());
                if (m1174p() != fBFullImageFragmentModel) {
                    graphQLVisitableModel = (InstantShoppingPhotoElementFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f1050j = fBFullImageFragmentModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m1176a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m1171j());
            int a2 = ModelHelper.a(flatBufferBuilder, mo38l());
            int a3 = flatBufferBuilder.a(mo30c());
            int a4 = ModelHelper.a(flatBufferBuilder, m1172k());
            int a5 = ModelHelper.a(flatBufferBuilder, m1173o());
            int a6 = ModelHelper.a(flatBufferBuilder, m1174p());
            int b = flatBufferBuilder.b(iI_());
            int d = flatBufferBuilder.d(iJ_());
            int b2 = flatBufferBuilder.b(m1175q());
            flatBufferBuilder.c(10);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, a2);
            flatBufferBuilder.b(2, a3);
            flatBufferBuilder.b(3, a4);
            flatBufferBuilder.b(4, a5);
            flatBufferBuilder.a(5, this.f1049i, 0);
            flatBufferBuilder.b(6, a6);
            flatBufferBuilder.b(7, b);
            flatBufferBuilder.b(8, d);
            flatBufferBuilder.b(9, b2);
            i();
            return flatBufferBuilder.d();
        }

        public final void m1179a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
            super.a(mutableFlatBuffer, i, obj);
            this.f1049i = mutableFlatBuffer.a(i, 5, 0);
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 330127344)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: upload_date */
    public final class InstantShoppingProductQueryModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private InstantShoppingDocumentFragmentModel f1054d;

        /* compiled from: upload_date */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(InstantShoppingProductQueryModel.class, new Deserializer());
            }

            public Object m1185a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = InstantShoppingProductQueryParser.m1324a(jsonParser);
                Object instantShoppingProductQueryModel = new InstantShoppingProductQueryModel();
                ((BaseModel) instantShoppingProductQueryModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (instantShoppingProductQueryModel instanceof Postprocessable) {
                    return ((Postprocessable) instantShoppingProductQueryModel).a();
                }
                return instantShoppingProductQueryModel;
            }
        }

        /* compiled from: upload_date */
        public class Serializer extends JsonSerializer<InstantShoppingProductQueryModel> {
            public final void m1186a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                InstantShoppingProductQueryModel instantShoppingProductQueryModel = (InstantShoppingProductQueryModel) obj;
                if (instantShoppingProductQueryModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(instantShoppingProductQueryModel.m1187a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    instantShoppingProductQueryModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = instantShoppingProductQueryModel.w_();
                int u_ = instantShoppingProductQueryModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("product_document");
                    InstantShoppingDocumentFragmentParser.m1300a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(InstantShoppingProductQueryModel.class, new Serializer());
            }
        }

        public InstantShoppingProductQueryModel() {
            super(1);
        }

        @Nullable
        public final InstantShoppingDocumentFragmentModel m1189a() {
            this.f1054d = (InstantShoppingDocumentFragmentModel) super.a(this.f1054d, 0, InstantShoppingDocumentFragmentModel.class);
            return this.f1054d;
        }

        public final int jK_() {
            return 1735115152;
        }

        public final GraphQLVisitableModel m1188a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m1189a() != null) {
                InstantShoppingDocumentFragmentModel instantShoppingDocumentFragmentModel = (InstantShoppingDocumentFragmentModel) graphQLModelMutatingVisitor.b(m1189a());
                if (m1189a() != instantShoppingDocumentFragmentModel) {
                    graphQLVisitableModel = (InstantShoppingProductQueryModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f1054d = instantShoppingDocumentFragmentModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m1187a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m1189a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 574469129)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: upload_date */
    public final class InstantShoppingSelectorOptionsFragmentModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private InstantShoppingOptionsActionFragmentModel f1055d;
        private boolean f1056e;
        @Nullable
        private String f1057f;

        /* compiled from: upload_date */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(InstantShoppingSelectorOptionsFragmentModel.class, new Deserializer());
            }

            public Object m1190a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(InstantShoppingSelectorOptionsFragmentParser.m1326b(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object instantShoppingSelectorOptionsFragmentModel = new InstantShoppingSelectorOptionsFragmentModel();
                ((BaseModel) instantShoppingSelectorOptionsFragmentModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (instantShoppingSelectorOptionsFragmentModel instanceof Postprocessable) {
                    return ((Postprocessable) instantShoppingSelectorOptionsFragmentModel).a();
                }
                return instantShoppingSelectorOptionsFragmentModel;
            }
        }

        /* compiled from: upload_date */
        public class Serializer extends JsonSerializer<InstantShoppingSelectorOptionsFragmentModel> {
            public final void m1191a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                InstantShoppingSelectorOptionsFragmentModel instantShoppingSelectorOptionsFragmentModel = (InstantShoppingSelectorOptionsFragmentModel) obj;
                if (instantShoppingSelectorOptionsFragmentModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(instantShoppingSelectorOptionsFragmentModel.m1193a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    instantShoppingSelectorOptionsFragmentModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                InstantShoppingSelectorOptionsFragmentParser.m1327b(instantShoppingSelectorOptionsFragmentModel.w_(), instantShoppingSelectorOptionsFragmentModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(InstantShoppingSelectorOptionsFragmentModel.class, new Serializer());
            }
        }

        @Nullable
        public final /* synthetic */ InstantShoppingOptionsActionFragmentModel m1195a() {
            return m1192j();
        }

        public InstantShoppingSelectorOptionsFragmentModel() {
            super(3);
        }

        @Nullable
        private InstantShoppingOptionsActionFragmentModel m1192j() {
            this.f1055d = (InstantShoppingOptionsActionFragmentModel) super.a(this.f1055d, 0, InstantShoppingOptionsActionFragmentModel.class);
            return this.f1055d;
        }

        public final boolean m1197b() {
            a(0, 1);
            return this.f1056e;
        }

        @Nullable
        public final String m1198c() {
            this.f1057f = super.a(this.f1057f, 2);
            return this.f1057f;
        }

        public final int jK_() {
            return 1126244317;
        }

        public final GraphQLVisitableModel m1194a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m1192j() != null) {
                InstantShoppingOptionsActionFragmentModel instantShoppingOptionsActionFragmentModel = (InstantShoppingOptionsActionFragmentModel) graphQLModelMutatingVisitor.b(m1192j());
                if (m1192j() != instantShoppingOptionsActionFragmentModel) {
                    graphQLVisitableModel = (InstantShoppingSelectorOptionsFragmentModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f1055d = instantShoppingOptionsActionFragmentModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m1193a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m1192j());
            int b = flatBufferBuilder.b(m1198c());
            flatBufferBuilder.c(3);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.a(1, this.f1056e);
            flatBufferBuilder.b(2, b);
            i();
            return flatBufferBuilder.d();
        }

        public final void m1196a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
            super.a(mutableFlatBuffer, i, obj);
            this.f1056e = mutableFlatBuffer.a(i, 1);
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -2142062795)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: upload_date */
    public final class InstantShoppingTextElementFragmentModel extends BaseModel implements GraphQLVisitableModel, InstantShoppingTextElementFragment {
        @Nullable
        private InstantShoppingActionFragmentModel f1058d;
        @Nullable
        private GraphQLInstantShoppingDocumentElementType f1059e;
        @Nullable
        private InstantShoppingElementDescriptorFragmentModel f1060f;
        @Nullable
        private RichDocumentTextModel f1061g;
        private int f1062h;
        @Nullable
        private String f1063i;
        @Nullable
        private List<GraphQLInstantShoppingPresentationStyle> f1064j;

        /* compiled from: upload_date */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(InstantShoppingTextElementFragmentModel.class, new Deserializer());
            }

            public Object m1199a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(InstantShoppingTextElementFragmentParser.m1328a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object instantShoppingTextElementFragmentModel = new InstantShoppingTextElementFragmentModel();
                ((BaseModel) instantShoppingTextElementFragmentModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (instantShoppingTextElementFragmentModel instanceof Postprocessable) {
                    return ((Postprocessable) instantShoppingTextElementFragmentModel).a();
                }
                return instantShoppingTextElementFragmentModel;
            }
        }

        /* compiled from: upload_date */
        public class Serializer extends JsonSerializer<InstantShoppingTextElementFragmentModel> {
            public final void m1200a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                InstantShoppingTextElementFragmentModel instantShoppingTextElementFragmentModel = (InstantShoppingTextElementFragmentModel) obj;
                if (instantShoppingTextElementFragmentModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(instantShoppingTextElementFragmentModel.m1205a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    instantShoppingTextElementFragmentModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                InstantShoppingTextElementFragmentParser.m1331b(instantShoppingTextElementFragmentModel.w_(), instantShoppingTextElementFragmentModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(InstantShoppingTextElementFragmentModel.class, new Serializer());
            }
        }

        @Nullable
        public final /* synthetic */ InstantShoppingElementDescriptorFragmentModel mo31d() {
            return m1202j();
        }

        @Nullable
        public final /* synthetic */ RichDocumentText iK_() {
            return m1203k();
        }

        public InstantShoppingTextElementFragmentModel() {
            super(7);
        }

        @Nullable
        private InstantShoppingActionFragmentModel m1201a() {
            this.f1058d = (InstantShoppingActionFragmentModel) super.a(this.f1058d, 0, InstantShoppingActionFragmentModel.class);
            return this.f1058d;
        }

        @Nullable
        public final GraphQLInstantShoppingDocumentElementType mo30c() {
            this.f1059e = (GraphQLInstantShoppingDocumentElementType) super.b(this.f1059e, 1, GraphQLInstantShoppingDocumentElementType.class, GraphQLInstantShoppingDocumentElementType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
            return this.f1059e;
        }

        @Nullable
        private InstantShoppingElementDescriptorFragmentModel m1202j() {
            this.f1060f = (InstantShoppingElementDescriptorFragmentModel) super.a(this.f1060f, 2, InstantShoppingElementDescriptorFragmentModel.class);
            return this.f1060f;
        }

        @Nullable
        private RichDocumentTextModel m1203k() {
            this.f1061g = (RichDocumentTextModel) super.a(this.f1061g, 3, RichDocumentTextModel.class);
            return this.f1061g;
        }

        @Nullable
        public final String iI_() {
            this.f1063i = super.a(this.f1063i, 5);
            return this.f1063i;
        }

        @Nonnull
        private ImmutableList<GraphQLInstantShoppingPresentationStyle> m1204l() {
            this.f1064j = super.c(this.f1064j, 6, GraphQLInstantShoppingPresentationStyle.class);
            return (ImmutableList) this.f1064j;
        }

        public final int jK_() {
            return -1177926677;
        }

        public final GraphQLVisitableModel m1206a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m1201a() != null) {
                InstantShoppingActionFragmentModel instantShoppingActionFragmentModel = (InstantShoppingActionFragmentModel) graphQLModelMutatingVisitor.b(m1201a());
                if (m1201a() != instantShoppingActionFragmentModel) {
                    graphQLVisitableModel = (InstantShoppingTextElementFragmentModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f1058d = instantShoppingActionFragmentModel;
                }
            }
            if (m1202j() != null) {
                InstantShoppingElementDescriptorFragmentModel instantShoppingElementDescriptorFragmentModel = (InstantShoppingElementDescriptorFragmentModel) graphQLModelMutatingVisitor.b(m1202j());
                if (m1202j() != instantShoppingElementDescriptorFragmentModel) {
                    graphQLVisitableModel = (InstantShoppingTextElementFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f1060f = instantShoppingElementDescriptorFragmentModel;
                }
            }
            if (m1203k() != null) {
                RichDocumentTextModel richDocumentTextModel = (RichDocumentTextModel) graphQLModelMutatingVisitor.b(m1203k());
                if (m1203k() != richDocumentTextModel) {
                    graphQLVisitableModel = (InstantShoppingTextElementFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f1061g = richDocumentTextModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m1205a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m1201a());
            int a2 = flatBufferBuilder.a(mo30c());
            int a3 = ModelHelper.a(flatBufferBuilder, m1202j());
            int a4 = ModelHelper.a(flatBufferBuilder, m1203k());
            int b = flatBufferBuilder.b(iI_());
            int d = flatBufferBuilder.d(m1204l());
            flatBufferBuilder.c(7);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, a2);
            flatBufferBuilder.b(2, a3);
            flatBufferBuilder.b(3, a4);
            flatBufferBuilder.a(4, this.f1062h, 0);
            flatBufferBuilder.b(5, b);
            flatBufferBuilder.b(6, d);
            i();
            return flatBufferBuilder.d();
        }

        public final void m1207a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
            super.a(mutableFlatBuffer, i, obj);
            this.f1062h = mutableFlatBuffer.a(i, 4, 0);
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 928121503)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: upload_date */
    public final class InstantShoppingTextMetricsDescriptorFragmentModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private String f1065d;
        @Nullable
        private String f1066e;
        @Nullable
        private String f1067f;
        @Nullable
        private String f1068g;
        private int f1069h;
        @Nullable
        private String f1070i;
        @Nullable
        private String f1071j;

        /* compiled from: upload_date */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(InstantShoppingTextMetricsDescriptorFragmentModel.class, new Deserializer());
            }

            public Object m1210a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(InstantShoppingTextMetricsDescriptorFragmentParser.m1332a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object instantShoppingTextMetricsDescriptorFragmentModel = new InstantShoppingTextMetricsDescriptorFragmentModel();
                ((BaseModel) instantShoppingTextMetricsDescriptorFragmentModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (instantShoppingTextMetricsDescriptorFragmentModel instanceof Postprocessable) {
                    return ((Postprocessable) instantShoppingTextMetricsDescriptorFragmentModel).a();
                }
                return instantShoppingTextMetricsDescriptorFragmentModel;
            }
        }

        /* compiled from: upload_date */
        public class Serializer extends JsonSerializer<InstantShoppingTextMetricsDescriptorFragmentModel> {
            public final void m1211a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                InstantShoppingTextMetricsDescriptorFragmentModel instantShoppingTextMetricsDescriptorFragmentModel = (InstantShoppingTextMetricsDescriptorFragmentModel) obj;
                if (instantShoppingTextMetricsDescriptorFragmentModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(instantShoppingTextMetricsDescriptorFragmentModel.m1214a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    instantShoppingTextMetricsDescriptorFragmentModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                InstantShoppingTextMetricsDescriptorFragmentParser.m1333a(instantShoppingTextMetricsDescriptorFragmentModel.w_(), instantShoppingTextMetricsDescriptorFragmentModel.u_(), jsonGenerator);
            }

            static {
                FbSerializerProvider.a(InstantShoppingTextMetricsDescriptorFragmentModel.class, new Serializer());
            }
        }

        public InstantShoppingTextMetricsDescriptorFragmentModel() {
            super(7);
        }

        @Nullable
        private String m1212j() {
            this.f1065d = super.a(this.f1065d, 0);
            return this.f1065d;
        }

        @Nullable
        public final String m1216a() {
            this.f1066e = super.a(this.f1066e, 1);
            return this.f1066e;
        }

        @Nullable
        public final String m1218b() {
            this.f1067f = super.a(this.f1067f, 2);
            return this.f1067f;
        }

        @Nullable
        public final String m1219c() {
            this.f1068g = super.a(this.f1068g, 3);
            return this.f1068g;
        }

        public final int m1220d() {
            a(0, 4);
            return this.f1069h;
        }

        @Nullable
        public final String iP_() {
            this.f1070i = super.a(this.f1070i, 5);
            return this.f1070i;
        }

        @Nullable
        private String m1213k() {
            this.f1071j = super.a(this.f1071j, 6);
            return this.f1071j;
        }

        public final int jK_() {
            return -885708849;
        }

        public final GraphQLVisitableModel m1215a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            h();
            i();
            return this;
        }

        public final int m1214a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(m1212j());
            int b2 = flatBufferBuilder.b(m1216a());
            int b3 = flatBufferBuilder.b(m1218b());
            int b4 = flatBufferBuilder.b(m1219c());
            int b5 = flatBufferBuilder.b(iP_());
            int b6 = flatBufferBuilder.b(m1213k());
            flatBufferBuilder.c(7);
            flatBufferBuilder.b(0, b);
            flatBufferBuilder.b(1, b2);
            flatBufferBuilder.b(2, b3);
            flatBufferBuilder.b(3, b4);
            flatBufferBuilder.a(4, this.f1069h, 0);
            flatBufferBuilder.b(5, b5);
            flatBufferBuilder.b(6, b6);
            i();
            return flatBufferBuilder.d();
        }

        public final void m1217a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
            super.a(mutableFlatBuffer, i, obj);
            this.f1069h = mutableFlatBuffer.a(i, 4, 0);
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 2109443834)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: upload_date */
    public final class RichMediaDocumentQueryModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel {
        @Nullable
        private InstantShoppingDocumentFragmentModel f1072d;
        @Nullable
        private String f1073e;

        /* compiled from: upload_date */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(RichMediaDocumentQueryModel.class, new Deserializer());
            }

            public Object m1221a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = RichMediaDocumentQueryParser.m1334a(jsonParser);
                Object richMediaDocumentQueryModel = new RichMediaDocumentQueryModel();
                ((BaseModel) richMediaDocumentQueryModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (richMediaDocumentQueryModel instanceof Postprocessable) {
                    return ((Postprocessable) richMediaDocumentQueryModel).a();
                }
                return richMediaDocumentQueryModel;
            }
        }

        /* compiled from: upload_date */
        public class Serializer extends JsonSerializer<RichMediaDocumentQueryModel> {
            public final void m1222a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                RichMediaDocumentQueryModel richMediaDocumentQueryModel = (RichMediaDocumentQueryModel) obj;
                if (richMediaDocumentQueryModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(richMediaDocumentQueryModel.m1224a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    richMediaDocumentQueryModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = richMediaDocumentQueryModel.w_();
                int u_ = richMediaDocumentQueryModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("document");
                    InstantShoppingDocumentFragmentParser.m1300a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                if (mutableFlatBuffer.g(u_, 1) != 0) {
                    jsonGenerator.a("id");
                    jsonGenerator.b(mutableFlatBuffer.c(u_, 1));
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(RichMediaDocumentQueryModel.class, new Serializer());
            }
        }

        public RichMediaDocumentQueryModel() {
            super(2);
        }

        @Nullable
        public final InstantShoppingDocumentFragmentModel m1227j() {
            this.f1072d = (InstantShoppingDocumentFragmentModel) super.a(this.f1072d, 0, InstantShoppingDocumentFragmentModel.class);
            return this.f1072d;
        }

        @Nullable
        private String m1223k() {
            this.f1073e = super.a(this.f1073e, 1);
            return this.f1073e;
        }

        @Nullable
        public final String m1226a() {
            return m1223k();
        }

        public final int jK_() {
            return 1842144148;
        }

        public final GraphQLVisitableModel m1225a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m1227j() != null) {
                InstantShoppingDocumentFragmentModel instantShoppingDocumentFragmentModel = (InstantShoppingDocumentFragmentModel) graphQLModelMutatingVisitor.b(m1227j());
                if (m1227j() != instantShoppingDocumentFragmentModel) {
                    graphQLVisitableModel = (RichMediaDocumentQueryModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f1072d = instantShoppingDocumentFragmentModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m1224a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m1227j());
            int b = flatBufferBuilder.b(m1223k());
            flatBufferBuilder.c(2);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, b);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 996240555)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: upload_date */
    public final class ShoppingDocumentElementsEdgeModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private NodeModel f1104d;

        /* compiled from: upload_date */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(ShoppingDocumentElementsEdgeModel.class, new Deserializer());
            }

            public Object m1228a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(ShoppingDocumentElementsEdgeParser.m1337b(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object shoppingDocumentElementsEdgeModel = new ShoppingDocumentElementsEdgeModel();
                ((BaseModel) shoppingDocumentElementsEdgeModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (shoppingDocumentElementsEdgeModel instanceof Postprocessable) {
                    return ((Postprocessable) shoppingDocumentElementsEdgeModel).a();
                }
                return shoppingDocumentElementsEdgeModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 947775165)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: upload_date */
        public final class NodeModel extends BaseModel implements GraphQLVisitableModel, InstantShoppingButtonElementFragment, InstantShoppingColorSelectorElementFragment, InstantShoppingCompositeBlockElementFragment, InstantShoppingDocumentExpandableSectionElementFragment, InstantShoppingFooterElementFragment, InstantShoppingHeaderElementFragment, InstantShoppingPhotoElementFragment, InstantShoppingTextElementFragment, InstantShoppingToggleElementFragment {
            @Nullable
            private RichDocumentTextModel f1074A;
            @Nullable
            private RichDocumentTextModel f1075B;
            @Nullable
            private InstantShoppingTextElementFragmentModel f1076C;
            private int f1077D;
            @Nullable
            private List<GraphQLInstantShoppingPresentationStyle> f1078E;
            @Nullable
            private String f1079F;
            @Nullable
            private InstantShoppingActionFragmentModel f1080G;
            @Nullable
            private GraphQLObjectType f1081d;
            @Nullable
            private InstantShoppingActionFragmentModel f1082e;
            @Nullable
            private List<InstantShoppingTextElementFragmentModel> f1083f;
            @Nullable
            private GraphQLDocumentVideoAutoplayStyle f1084g;
            @Nullable
            private List<BlockElementsModel> f1085h;
            @Nullable
            private List<InstantShoppingPhotoElementFragmentModel> f1086i;
            @Nullable
            private String f1087j;
            @Nullable
            private List<InstantShoppingColorSelectorColorFragmentModel> f1088k;
            @Nullable
            private InstantShoppingTextElementFragmentModel f1089l;
            @Nullable
            private GraphQLDocumentVideoControlStyle f1090m;
            @Nullable
            private InstantShoppingActionFragmentModel f1091n;
            @Nullable
            private GraphQLInstantShoppingDocumentElementType f1092o;
            @Nullable
            private InstantShoppingElementDescriptorFragmentModel f1093p;
            @Nullable
            private ElementPhotoModel f1094q;
            @Nullable
            private RichDocumentTextModel f1095r;
            @Nullable
            private FBVideoModel f1096s;
            @Nullable
            private List<FooterElementsModel> f1097t;
            private int f1098u;
            @Nullable
            private List<HeaderElementsModel> f1099v;
            @Nullable
            private FBFullImageFragmentModel f1100w;
            private boolean f1101x;
            @Nullable
            private String f1102y;
            @Nullable
            private GraphQLDocumentVideoLoopingStyle f1103z;

            /* compiled from: upload_date */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(NodeModel.class, new Deserializer());
                }

                public Object m1229a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(NodeParser.m1335a(jsonParser, flatBufferBuilder));
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

            /* compiled from: upload_date */
            public class Serializer extends JsonSerializer<NodeModel> {
                public final void m1230a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    NodeModel nodeModel = (NodeModel) obj;
                    if (nodeModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(nodeModel.m1247a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        nodeModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    NodeParser.m1336a(nodeModel.w_(), nodeModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(NodeModel.class, new Serializer());
                }
            }

            @Nullable
            public final /* synthetic */ InstantShoppingActionFragmentModel mo28a() {
                return m1232E();
            }

            @Nullable
            public final /* synthetic */ InstantShoppingElementDescriptorFragmentModel mo31d() {
                return m1235H();
            }

            @Nullable
            public final /* synthetic */ RichDocumentText iK_() {
                return m1237J();
            }

            @Nullable
            public final /* synthetic */ ElementPhotoModel mo39m() {
                return m1236I();
            }

            @Nullable
            public final /* synthetic */ FBFullImageFragmentModel mo40n() {
                return m1239L();
            }

            @Nullable
            public final /* synthetic */ InstantShoppingTextElementFragment mo41o() {
                return m1233F();
            }

            @Nullable
            public final /* synthetic */ InstantShoppingTextElementFragment mo42p() {
                return m1242O();
            }

            @Nullable
            public final /* synthetic */ InstantShoppingActionFragmentModel mo48q() {
                return m1234G();
            }

            @Nullable
            public final /* synthetic */ RichDocumentText mo50s() {
                return m1240M();
            }

            @Nullable
            public final /* synthetic */ RichDocumentText mo51t() {
                return m1241N();
            }

            @Nullable
            public final /* synthetic */ InstantShoppingActionFragmentModel mo52u() {
                return m1243P();
            }

            @Nullable
            public final /* synthetic */ FBVideo m1270y() {
                return m1238K();
            }

            public NodeModel() {
                super(30);
            }

            @Nullable
            private GraphQLObjectType m1231D() {
                if (this.b != null && this.f1081d == null) {
                    this.f1081d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
                }
                return this.f1081d;
            }

            @Nullable
            private InstantShoppingActionFragmentModel m1232E() {
                this.f1082e = (InstantShoppingActionFragmentModel) super.a(this.f1082e, 1, InstantShoppingActionFragmentModel.class);
                return this.f1082e;
            }

            @Nonnull
            public final ImmutableList<InstantShoppingTextElementFragmentModel> mo38l() {
                this.f1083f = super.a(this.f1083f, 2, InstantShoppingTextElementFragmentModel.class);
                return (ImmutableList) this.f1083f;
            }

            @Nullable
            public final GraphQLDocumentVideoAutoplayStyle m1267v() {
                this.f1084g = (GraphQLDocumentVideoAutoplayStyle) super.b(this.f1084g, 3, GraphQLDocumentVideoAutoplayStyle.class, GraphQLDocumentVideoAutoplayStyle.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
                return this.f1084g;
            }

            @Nonnull
            public final ImmutableList<BlockElementsModel> iF_() {
                this.f1085h = super.a(this.f1085h, 4, BlockElementsModel.class);
                return (ImmutableList) this.f1085h;
            }

            @Nonnull
            public final ImmutableList<InstantShoppingPhotoElementFragmentModel> m1268w() {
                this.f1086i = super.a(this.f1086i, 5, InstantShoppingPhotoElementFragmentModel.class);
                return (ImmutableList) this.f1086i;
            }

            @Nullable
            public final String mo29b() {
                this.f1087j = super.a(this.f1087j, 6);
                return this.f1087j;
            }

            @Nonnull
            public final ImmutableList<InstantShoppingColorSelectorColorFragmentModel> mo36j() {
                this.f1088k = super.a(this.f1088k, 7, InstantShoppingColorSelectorColorFragmentModel.class);
                return (ImmutableList) this.f1088k;
            }

            @Nullable
            private InstantShoppingTextElementFragmentModel m1233F() {
                this.f1089l = (InstantShoppingTextElementFragmentModel) super.a(this.f1089l, 8, InstantShoppingTextElementFragmentModel.class);
                return this.f1089l;
            }

            @Nullable
            public final GraphQLDocumentVideoControlStyle m1269x() {
                this.f1090m = (GraphQLDocumentVideoControlStyle) super.b(this.f1090m, 9, GraphQLDocumentVideoControlStyle.class, GraphQLDocumentVideoControlStyle.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
                return this.f1090m;
            }

            @Nullable
            private InstantShoppingActionFragmentModel m1234G() {
                this.f1091n = (InstantShoppingActionFragmentModel) super.a(this.f1091n, 10, InstantShoppingActionFragmentModel.class);
                return this.f1091n;
            }

            @Nullable
            public final GraphQLInstantShoppingDocumentElementType mo43c() {
                this.f1092o = (GraphQLInstantShoppingDocumentElementType) super.b(this.f1092o, 11, GraphQLInstantShoppingDocumentElementType.class, GraphQLInstantShoppingDocumentElementType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
                return this.f1092o;
            }

            @Nullable
            private InstantShoppingElementDescriptorFragmentModel m1235H() {
                this.f1093p = (InstantShoppingElementDescriptorFragmentModel) super.a(this.f1093p, 12, InstantShoppingElementDescriptorFragmentModel.class);
                return this.f1093p;
            }

            @Nullable
            private ElementPhotoModel m1236I() {
                this.f1094q = (ElementPhotoModel) super.a(this.f1094q, 13, ElementPhotoModel.class);
                return this.f1094q;
            }

            @Nullable
            private RichDocumentTextModel m1237J() {
                this.f1095r = (RichDocumentTextModel) super.a(this.f1095r, 14, RichDocumentTextModel.class);
                return this.f1095r;
            }

            @Nullable
            private FBVideoModel m1238K() {
                this.f1096s = (FBVideoModel) super.a(this.f1096s, 15, FBVideoModel.class);
                return this.f1096s;
            }

            @Nonnull
            public final ImmutableList<FooterElementsModel> m1271z() {
                this.f1097t = super.a(this.f1097t, 16, FooterElementsModel.class);
                return (ImmutableList) this.f1097t;
            }

            public final int mo45g() {
                a(2, 1);
                return this.f1098u;
            }

            @Nonnull
            public final ImmutableList<HeaderElementsModel> m1244A() {
                this.f1099v = super.a(this.f1099v, 18, HeaderElementsModel.class);
                return (ImmutableList) this.f1099v;
            }

            @Nullable
            private FBFullImageFragmentModel m1239L() {
                this.f1100w = (FBFullImageFragmentModel) super.a(this.f1100w, 19, FBFullImageFragmentModel.class);
                return this.f1100w;
            }

            public final boolean mo49r() {
                a(2, 4);
                return this.f1101x;
            }

            @Nullable
            public final String iI_() {
                this.f1102y = super.a(this.f1102y, 21);
                return this.f1102y;
            }

            @Nullable
            public final GraphQLDocumentVideoLoopingStyle m1245B() {
                this.f1103z = (GraphQLDocumentVideoLoopingStyle) super.b(this.f1103z, 22, GraphQLDocumentVideoLoopingStyle.class, GraphQLDocumentVideoLoopingStyle.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
                return this.f1103z;
            }

            @Nullable
            private RichDocumentTextModel m1240M() {
                this.f1074A = (RichDocumentTextModel) super.a(this.f1074A, 23, RichDocumentTextModel.class);
                return this.f1074A;
            }

            @Nullable
            private RichDocumentTextModel m1241N() {
                this.f1075B = (RichDocumentTextModel) super.a(this.f1075B, 24, RichDocumentTextModel.class);
                return this.f1075B;
            }

            @Nullable
            private InstantShoppingTextElementFragmentModel m1242O() {
                this.f1076C = (InstantShoppingTextElementFragmentModel) super.a(this.f1076C, 25, InstantShoppingTextElementFragmentModel.class);
                return this.f1076C;
            }

            public final int mo37k() {
                a(3, 2);
                return this.f1077D;
            }

            @Nonnull
            public final ImmutableList<GraphQLInstantShoppingPresentationStyle> iJ_() {
                this.f1078E = super.c(this.f1078E, 27, GraphQLInstantShoppingPresentationStyle.class);
                return (ImmutableList) this.f1078E;
            }

            @Nullable
            public final String m1246C() {
                this.f1079F = super.a(this.f1079F, 28);
                return this.f1079F;
            }

            @Nullable
            private InstantShoppingActionFragmentModel m1243P() {
                this.f1080G = (InstantShoppingActionFragmentModel) super.a(this.f1080G, 29, InstantShoppingActionFragmentModel.class);
                return this.f1080G;
            }

            public final int jK_() {
                return 1808563160;
            }

            public final GraphQLVisitableModel m1248a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                InstantShoppingActionFragmentModel instantShoppingActionFragmentModel;
                Builder a;
                InstantShoppingTextElementFragmentModel instantShoppingTextElementFragmentModel;
                RichDocumentTextModel richDocumentTextModel;
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m1232E() != null) {
                    instantShoppingActionFragmentModel = (InstantShoppingActionFragmentModel) graphQLModelMutatingVisitor.b(m1232E());
                    if (m1232E() != instantShoppingActionFragmentModel) {
                        graphQLVisitableModel = (NodeModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f1082e = instantShoppingActionFragmentModel;
                    }
                }
                if (mo38l() != null) {
                    a = ModelHelper.a(mo38l(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        NodeModel nodeModel = (NodeModel) ModelHelper.a(graphQLVisitableModel, this);
                        nodeModel.f1083f = a.b();
                        graphQLVisitableModel = nodeModel;
                    }
                }
                if (iF_() != null) {
                    a = ModelHelper.a(iF_(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        nodeModel = (NodeModel) ModelHelper.a(graphQLVisitableModel, this);
                        nodeModel.f1085h = a.b();
                        graphQLVisitableModel = nodeModel;
                    }
                }
                if (m1268w() != null) {
                    a = ModelHelper.a(m1268w(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        nodeModel = (NodeModel) ModelHelper.a(graphQLVisitableModel, this);
                        nodeModel.f1086i = a.b();
                        graphQLVisitableModel = nodeModel;
                    }
                }
                if (mo36j() != null) {
                    a = ModelHelper.a(mo36j(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        nodeModel = (NodeModel) ModelHelper.a(graphQLVisitableModel, this);
                        nodeModel.f1088k = a.b();
                        graphQLVisitableModel = nodeModel;
                    }
                }
                if (m1233F() != null) {
                    instantShoppingTextElementFragmentModel = (InstantShoppingTextElementFragmentModel) graphQLModelMutatingVisitor.b(m1233F());
                    if (m1233F() != instantShoppingTextElementFragmentModel) {
                        graphQLVisitableModel = (NodeModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f1089l = instantShoppingTextElementFragmentModel;
                    }
                }
                if (m1234G() != null) {
                    instantShoppingActionFragmentModel = (InstantShoppingActionFragmentModel) graphQLModelMutatingVisitor.b(m1234G());
                    if (m1234G() != instantShoppingActionFragmentModel) {
                        graphQLVisitableModel = (NodeModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f1091n = instantShoppingActionFragmentModel;
                    }
                }
                if (m1235H() != null) {
                    InstantShoppingElementDescriptorFragmentModel instantShoppingElementDescriptorFragmentModel = (InstantShoppingElementDescriptorFragmentModel) graphQLModelMutatingVisitor.b(m1235H());
                    if (m1235H() != instantShoppingElementDescriptorFragmentModel) {
                        graphQLVisitableModel = (NodeModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f1093p = instantShoppingElementDescriptorFragmentModel;
                    }
                }
                if (m1236I() != null) {
                    ElementPhotoModel elementPhotoModel = (ElementPhotoModel) graphQLModelMutatingVisitor.b(m1236I());
                    if (m1236I() != elementPhotoModel) {
                        graphQLVisitableModel = (NodeModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f1094q = elementPhotoModel;
                    }
                }
                if (m1237J() != null) {
                    richDocumentTextModel = (RichDocumentTextModel) graphQLModelMutatingVisitor.b(m1237J());
                    if (m1237J() != richDocumentTextModel) {
                        graphQLVisitableModel = (NodeModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f1095r = richDocumentTextModel;
                    }
                }
                if (m1238K() != null) {
                    FBVideoModel fBVideoModel = (FBVideoModel) graphQLModelMutatingVisitor.b(m1238K());
                    if (m1238K() != fBVideoModel) {
                        graphQLVisitableModel = (NodeModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f1096s = fBVideoModel;
                    }
                }
                if (m1271z() != null) {
                    a = ModelHelper.a(m1271z(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        nodeModel = (NodeModel) ModelHelper.a(graphQLVisitableModel, this);
                        nodeModel.f1097t = a.b();
                        graphQLVisitableModel = nodeModel;
                    }
                }
                if (m1244A() != null) {
                    a = ModelHelper.a(m1244A(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        nodeModel = (NodeModel) ModelHelper.a(graphQLVisitableModel, this);
                        nodeModel.f1099v = a.b();
                        graphQLVisitableModel = nodeModel;
                    }
                }
                if (m1239L() != null) {
                    FBFullImageFragmentModel fBFullImageFragmentModel = (FBFullImageFragmentModel) graphQLModelMutatingVisitor.b(m1239L());
                    if (m1239L() != fBFullImageFragmentModel) {
                        graphQLVisitableModel = (NodeModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f1100w = fBFullImageFragmentModel;
                    }
                }
                if (m1240M() != null) {
                    richDocumentTextModel = (RichDocumentTextModel) graphQLModelMutatingVisitor.b(m1240M());
                    if (m1240M() != richDocumentTextModel) {
                        graphQLVisitableModel = (NodeModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f1074A = richDocumentTextModel;
                    }
                }
                if (m1241N() != null) {
                    richDocumentTextModel = (RichDocumentTextModel) graphQLModelMutatingVisitor.b(m1241N());
                    if (m1241N() != richDocumentTextModel) {
                        graphQLVisitableModel = (NodeModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f1075B = richDocumentTextModel;
                    }
                }
                if (m1242O() != null) {
                    instantShoppingTextElementFragmentModel = (InstantShoppingTextElementFragmentModel) graphQLModelMutatingVisitor.b(m1242O());
                    if (m1242O() != instantShoppingTextElementFragmentModel) {
                        graphQLVisitableModel = (NodeModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f1076C = instantShoppingTextElementFragmentModel;
                    }
                }
                if (m1243P() != null) {
                    instantShoppingActionFragmentModel = (InstantShoppingActionFragmentModel) graphQLModelMutatingVisitor.b(m1243P());
                    if (m1243P() != instantShoppingActionFragmentModel) {
                        graphQLVisitableModel = (NodeModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f1080G = instantShoppingActionFragmentModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m1247a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m1231D());
                int a2 = ModelHelper.a(flatBufferBuilder, m1232E());
                int a3 = ModelHelper.a(flatBufferBuilder, mo38l());
                int a4 = flatBufferBuilder.a(m1267v());
                int a5 = ModelHelper.a(flatBufferBuilder, iF_());
                int a6 = ModelHelper.a(flatBufferBuilder, m1268w());
                int b = flatBufferBuilder.b(mo29b());
                int a7 = ModelHelper.a(flatBufferBuilder, mo36j());
                int a8 = ModelHelper.a(flatBufferBuilder, m1233F());
                int a9 = flatBufferBuilder.a(m1269x());
                int a10 = ModelHelper.a(flatBufferBuilder, m1234G());
                int a11 = flatBufferBuilder.a(mo43c());
                int a12 = ModelHelper.a(flatBufferBuilder, m1235H());
                int a13 = ModelHelper.a(flatBufferBuilder, m1236I());
                int a14 = ModelHelper.a(flatBufferBuilder, m1237J());
                int a15 = ModelHelper.a(flatBufferBuilder, m1238K());
                int a16 = ModelHelper.a(flatBufferBuilder, m1271z());
                int a17 = ModelHelper.a(flatBufferBuilder, m1244A());
                int a18 = ModelHelper.a(flatBufferBuilder, m1239L());
                int b2 = flatBufferBuilder.b(iI_());
                int a19 = flatBufferBuilder.a(m1245B());
                int a20 = ModelHelper.a(flatBufferBuilder, m1240M());
                int a21 = ModelHelper.a(flatBufferBuilder, m1241N());
                int a22 = ModelHelper.a(flatBufferBuilder, m1242O());
                int d = flatBufferBuilder.d(iJ_());
                int b3 = flatBufferBuilder.b(m1246C());
                int a23 = ModelHelper.a(flatBufferBuilder, m1243P());
                flatBufferBuilder.c(30);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.b(1, a2);
                flatBufferBuilder.b(2, a3);
                flatBufferBuilder.b(3, a4);
                flatBufferBuilder.b(4, a5);
                flatBufferBuilder.b(5, a6);
                flatBufferBuilder.b(6, b);
                flatBufferBuilder.b(7, a7);
                flatBufferBuilder.b(8, a8);
                flatBufferBuilder.b(9, a9);
                flatBufferBuilder.b(10, a10);
                flatBufferBuilder.b(11, a11);
                flatBufferBuilder.b(12, a12);
                flatBufferBuilder.b(13, a13);
                flatBufferBuilder.b(14, a14);
                flatBufferBuilder.b(15, a15);
                flatBufferBuilder.b(16, a16);
                flatBufferBuilder.a(17, this.f1098u, 0);
                flatBufferBuilder.b(18, a17);
                flatBufferBuilder.b(19, a18);
                flatBufferBuilder.a(20, this.f1101x);
                flatBufferBuilder.b(21, b2);
                flatBufferBuilder.b(22, a19);
                flatBufferBuilder.b(23, a20);
                flatBufferBuilder.b(24, a21);
                flatBufferBuilder.b(25, a22);
                flatBufferBuilder.a(26, this.f1077D, 0);
                flatBufferBuilder.b(27, d);
                flatBufferBuilder.b(28, b3);
                flatBufferBuilder.b(29, a23);
                i();
                return flatBufferBuilder.d();
            }

            public final void m1250a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                super.a(mutableFlatBuffer, i, obj);
                this.f1098u = mutableFlatBuffer.a(i, 17, 0);
                this.f1101x = mutableFlatBuffer.a(i, 20);
                this.f1077D = mutableFlatBuffer.a(i, 26, 0);
            }
        }

        /* compiled from: upload_date */
        public class Serializer extends JsonSerializer<ShoppingDocumentElementsEdgeModel> {
            public final void m1272a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                ShoppingDocumentElementsEdgeModel shoppingDocumentElementsEdgeModel = (ShoppingDocumentElementsEdgeModel) obj;
                if (shoppingDocumentElementsEdgeModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(shoppingDocumentElementsEdgeModel.m1273a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    shoppingDocumentElementsEdgeModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                ShoppingDocumentElementsEdgeParser.m1338b(shoppingDocumentElementsEdgeModel.w_(), shoppingDocumentElementsEdgeModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(ShoppingDocumentElementsEdgeModel.class, new Serializer());
            }
        }

        @Nullable
        public final /* synthetic */ NodeModel m1275a() {
            return m1276j();
        }

        public ShoppingDocumentElementsEdgeModel() {
            super(1);
        }

        @Nullable
        public final NodeModel m1276j() {
            this.f1104d = (NodeModel) super.a(this.f1104d, 0, NodeModel.class);
            return this.f1104d;
        }

        public final int jK_() {
            return -1426056777;
        }

        public final GraphQLVisitableModel m1274a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m1276j() != null) {
                NodeModel nodeModel = (NodeModel) graphQLModelMutatingVisitor.b(m1276j());
                if (m1276j() != nodeModel) {
                    graphQLVisitableModel = (ShoppingDocumentElementsEdgeModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f1104d = nodeModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m1273a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m1276j());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }
}
