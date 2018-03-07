package com.facebook.search.protocol.resultpage;

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
import com.facebook.graphql.visitor.ConsistencyTuple;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLPersistableNode;
import com.facebook.graphql.visitor.GraphQLVisitableConsistentModel;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.facebook.search.protocol.resultpage.SearchProductItemNodeParsers.SearchProductItemNodeParser;
import com.facebook.search.protocol.resultpage.SearchProductItemNodeParsers.SearchProductItemNodeParser.ImageParser;
import com.facebook.search.protocol.resultpage.SearchProductItemNodeParsers.SearchProductItemNodeParser.ItemPriceParser;
import com.facebook.search.protocol.resultpage.SearchProductItemNodeParsers.SearchProductItemNodeParser.SellerParser;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.nio.ByteBuffer;
import javax.annotation.Nullable;

/* compiled from: msite_account_recovery */
public class SearchProductItemNodeModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -1145578714)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: msite_account_recovery */
    public final class SearchProductItemNodeModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel {
        @Nullable
        private String f8309d;
        @Nullable
        private ImageModel f8310e;
        @Nullable
        private ItemPriceModel f8311f;
        @Nullable
        private String f8312g;
        @Nullable
        private SellerModel f8313h;

        /* compiled from: msite_account_recovery */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(SearchProductItemNodeModel.class, new Deserializer());
            }

            public Object m9485a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(SearchProductItemNodeParser.m9520a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object searchProductItemNodeModel = new SearchProductItemNodeModel();
                ((BaseModel) searchProductItemNodeModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (searchProductItemNodeModel instanceof Postprocessable) {
                    return ((Postprocessable) searchProductItemNodeModel).a();
                }
                return searchProductItemNodeModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 842551240)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: msite_account_recovery */
        public final class ImageModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private String f8304d;

            /* compiled from: msite_account_recovery */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(ImageModel.class, new Deserializer());
                }

                public Object m9486a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(ImageParser.m9514a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object imageModel = new ImageModel();
                    ((BaseModel) imageModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (imageModel instanceof Postprocessable) {
                        return ((Postprocessable) imageModel).a();
                    }
                    return imageModel;
                }
            }

            /* compiled from: msite_account_recovery */
            public class Serializer extends JsonSerializer<ImageModel> {
                public final void m9487a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    ImageModel imageModel = (ImageModel) obj;
                    if (imageModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(imageModel.m9489a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        imageModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    ImageParser.m9515a(imageModel.w_(), imageModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(ImageModel.class, new Serializer());
                }
            }

            public ImageModel() {
                super(1);
            }

            @Nullable
            private String m9488a() {
                this.f8304d = super.a(this.f8304d, 0);
                return this.f8304d;
            }

            public final int jK_() {
                return 70760763;
            }

            public final GraphQLVisitableModel m9490a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m9489a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m9488a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, b);
                i();
                return flatBufferBuilder.d();
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 1000635129)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: msite_account_recovery */
        public final class ItemPriceModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private String f8305d;
            @Nullable
            private String f8306e;

            /* compiled from: msite_account_recovery */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(ItemPriceModel.class, new Deserializer());
                }

                public Object m9491a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(ItemPriceParser.m9516a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object itemPriceModel = new ItemPriceModel();
                    ((BaseModel) itemPriceModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (itemPriceModel instanceof Postprocessable) {
                        return ((Postprocessable) itemPriceModel).a();
                    }
                    return itemPriceModel;
                }
            }

            /* compiled from: msite_account_recovery */
            public class Serializer extends JsonSerializer<ItemPriceModel> {
                public final void m9492a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    ItemPriceModel itemPriceModel = (ItemPriceModel) obj;
                    if (itemPriceModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(itemPriceModel.m9495a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        itemPriceModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    ItemPriceParser.m9517a(itemPriceModel.w_(), itemPriceModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(ItemPriceModel.class, new Serializer());
                }
            }

            public ItemPriceModel() {
                super(2);
            }

            @Nullable
            private String m9493a() {
                this.f8305d = super.a(this.f8305d, 0);
                return this.f8305d;
            }

            @Nullable
            private String m9494j() {
                this.f8306e = super.a(this.f8306e, 1);
                return this.f8306e;
            }

            public final int jK_() {
                return 753818588;
            }

            public final GraphQLVisitableModel m9496a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m9495a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m9493a());
                int b2 = flatBufferBuilder.b(m9494j());
                flatBufferBuilder.c(2);
                flatBufferBuilder.b(0, b);
                flatBufferBuilder.b(1, b2);
                i();
                return flatBufferBuilder.d();
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -341630258)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: msite_account_recovery */
        public final class SellerModel extends BaseModel implements GraphQLVisitableConsistentModel {
            @Nullable
            private GraphQLObjectType f8307d;
            @Nullable
            private String f8308e;

            /* compiled from: msite_account_recovery */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(SellerModel.class, new Deserializer());
                }

                public Object m9497a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(SellerParser.m9518a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object sellerModel = new SellerModel();
                    ((BaseModel) sellerModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (sellerModel instanceof Postprocessable) {
                        return ((Postprocessable) sellerModel).a();
                    }
                    return sellerModel;
                }
            }

            /* compiled from: msite_account_recovery */
            public class Serializer extends JsonSerializer<SellerModel> {
                public final void m9498a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    SellerModel sellerModel = (SellerModel) obj;
                    if (sellerModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(sellerModel.m9501a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        sellerModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    SellerParser.m9519a(sellerModel.w_(), sellerModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(SellerModel.class, new Serializer());
                }
            }

            public SellerModel() {
                super(2);
            }

            public final void m9503a(String str, ConsistencyTuple consistencyTuple) {
                consistencyTuple.a();
            }

            public final void m9504a(String str, Object obj, boolean z) {
            }

            @Nullable
            private GraphQLObjectType m9499a() {
                if (this.b != null && this.f8307d == null) {
                    this.f8307d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
                }
                return this.f8307d;
            }

            @Nullable
            private String m9500j() {
                this.f8308e = super.a(this.f8308e, 1);
                return this.f8308e;
            }

            public final int jK_() {
                return 63093205;
            }

            public final GraphQLVisitableModel m9502a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m9501a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m9499a());
                int b = flatBufferBuilder.b(m9500j());
                flatBufferBuilder.c(2);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.b(1, b);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: msite_account_recovery */
        public class Serializer extends JsonSerializer<SearchProductItemNodeModel> {
            public final void m9505a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                SearchProductItemNodeModel searchProductItemNodeModel = (SearchProductItemNodeModel) obj;
                if (searchProductItemNodeModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(searchProductItemNodeModel.m9511a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    searchProductItemNodeModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                SearchProductItemNodeParser.m9521a(searchProductItemNodeModel.w_(), searchProductItemNodeModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(SearchProductItemNodeModel.class, new Serializer());
            }
        }

        public SearchProductItemNodeModel() {
            super(5);
        }

        @Nullable
        private String m9506j() {
            this.f8309d = super.a(this.f8309d, 0);
            return this.f8309d;
        }

        @Nullable
        private ImageModel m9507k() {
            this.f8310e = (ImageModel) super.a(this.f8310e, 1, ImageModel.class);
            return this.f8310e;
        }

        @Nullable
        private ItemPriceModel m9508l() {
            this.f8311f = (ItemPriceModel) super.a(this.f8311f, 2, ItemPriceModel.class);
            return this.f8311f;
        }

        @Nullable
        private String m9509m() {
            this.f8312g = super.a(this.f8312g, 3);
            return this.f8312g;
        }

        @Nullable
        private SellerModel m9510n() {
            this.f8313h = (SellerModel) super.a(this.f8313h, 4, SellerModel.class);
            return this.f8313h;
        }

        @Nullable
        public final String m9513a() {
            return m9506j();
        }

        public final int jK_() {
            return 175920258;
        }

        public final GraphQLVisitableModel m9512a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m9507k() != null) {
                ImageModel imageModel = (ImageModel) graphQLModelMutatingVisitor.b(m9507k());
                if (m9507k() != imageModel) {
                    graphQLVisitableModel = (SearchProductItemNodeModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f8310e = imageModel;
                }
            }
            if (m9508l() != null) {
                ItemPriceModel itemPriceModel = (ItemPriceModel) graphQLModelMutatingVisitor.b(m9508l());
                if (m9508l() != itemPriceModel) {
                    graphQLVisitableModel = (SearchProductItemNodeModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f8311f = itemPriceModel;
                }
            }
            if (m9510n() != null) {
                SellerModel sellerModel = (SellerModel) graphQLModelMutatingVisitor.b(m9510n());
                if (m9510n() != sellerModel) {
                    graphQLVisitableModel = (SearchProductItemNodeModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f8313h = sellerModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m9511a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(m9506j());
            int a = ModelHelper.a(flatBufferBuilder, m9507k());
            int a2 = ModelHelper.a(flatBufferBuilder, m9508l());
            int b2 = flatBufferBuilder.b(m9509m());
            int a3 = ModelHelper.a(flatBufferBuilder, m9510n());
            flatBufferBuilder.c(5);
            flatBufferBuilder.b(0, b);
            flatBufferBuilder.b(1, a);
            flatBufferBuilder.b(2, a2);
            flatBufferBuilder.b(3, b2);
            flatBufferBuilder.b(4, a3);
            i();
            return flatBufferBuilder.d();
        }
    }
}
