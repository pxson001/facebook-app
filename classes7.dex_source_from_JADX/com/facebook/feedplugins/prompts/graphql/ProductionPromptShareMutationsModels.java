package com.facebook.feedplugins.prompts.graphql;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbSerializerProvider;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.feedplugins.prompts.graphql.ProductionPromptShareMutationsParsers.ProductionPromptShareMutationFieldsParser;
import com.facebook.feedplugins.prompts.graphql.ProductionPromptShareMutationsParsers.ProductionPromptShareMutationFieldsParser.ProductionPromptParser;
import com.facebook.feedplugins.prompts.graphql.ProductionPromptShareMutationsParsers.ProductionPromptShareMutationFieldsParser.ViewerParser;
import com.facebook.feedplugins.prompts.graphql.ProductionPromptShareMutationsParsers.ProductionPromptShareMutationFieldsParser.ViewerParser.ActorParser;
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
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.nio.ByteBuffer;
import javax.annotation.Nullable;

/* compiled from: SINGLE_IMAGE_NO_SIZE_WIDTH_HEIGHT */
public class ProductionPromptShareMutationsModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -1070162129)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: SINGLE_IMAGE_NO_SIZE_WIDTH_HEIGHT */
    public final class ProductionPromptShareMutationFieldsModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private ProductionPromptModel f23784d;
        @Nullable
        private ViewerModel f23785e;

        /* compiled from: SINGLE_IMAGE_NO_SIZE_WIDTH_HEIGHT */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(ProductionPromptShareMutationFieldsModel.class, new Deserializer());
            }

            public Object m25926a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = ProductionPromptShareMutationFieldsParser.m25961a(jsonParser);
                Object productionPromptShareMutationFieldsModel = new ProductionPromptShareMutationFieldsModel();
                ((BaseModel) productionPromptShareMutationFieldsModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (productionPromptShareMutationFieldsModel instanceof Postprocessable) {
                    return ((Postprocessable) productionPromptShareMutationFieldsModel).a();
                }
                return productionPromptShareMutationFieldsModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 1801334754)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: SINGLE_IMAGE_NO_SIZE_WIDTH_HEIGHT */
        public final class ProductionPromptModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
            @Nullable
            private String f23780d;

            /* compiled from: SINGLE_IMAGE_NO_SIZE_WIDTH_HEIGHT */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(ProductionPromptModel.class, new Deserializer());
                }

                public Object m25927a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(ProductionPromptParser.m25955a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object productionPromptModel = new ProductionPromptModel();
                    ((BaseModel) productionPromptModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (productionPromptModel instanceof Postprocessable) {
                        return ((Postprocessable) productionPromptModel).a();
                    }
                    return productionPromptModel;
                }
            }

            /* compiled from: SINGLE_IMAGE_NO_SIZE_WIDTH_HEIGHT */
            public class Serializer extends JsonSerializer<ProductionPromptModel> {
                public final void m25928a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    ProductionPromptModel productionPromptModel = (ProductionPromptModel) obj;
                    if (productionPromptModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(productionPromptModel.m25931a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        productionPromptModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    ProductionPromptParser.m25956a(productionPromptModel.w_(), productionPromptModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(ProductionPromptModel.class, new Serializer());
                }
            }

            public ProductionPromptModel() {
                super(1);
            }

            public final void m25934a(String str, ConsistencyTuple consistencyTuple) {
                if ("id".equals(str)) {
                    consistencyTuple.a = m25930j();
                    consistencyTuple.b = u_();
                    consistencyTuple.c = 0;
                    return;
                }
                consistencyTuple.a();
            }

            public final void m25935a(String str, Object obj, boolean z) {
                if ("id".equals(str)) {
                    m25929a((String) obj);
                }
            }

            @Nullable
            private String m25930j() {
                this.f23780d = super.a(this.f23780d, 0);
                return this.f23780d;
            }

            private void m25929a(@Nullable String str) {
                this.f23780d = str;
                if (this.b != null && this.b.d) {
                    this.b.a(this.c, 0, str);
                }
            }

            @Nullable
            public final String m25933a() {
                return m25930j();
            }

            public final int jK_() {
                return -1976808547;
            }

            public final GraphQLVisitableModel m25932a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m25931a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m25930j());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, b);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: SINGLE_IMAGE_NO_SIZE_WIDTH_HEIGHT */
        public class Serializer extends JsonSerializer<ProductionPromptShareMutationFieldsModel> {
            public final void m25936a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                ProductionPromptShareMutationFieldsModel productionPromptShareMutationFieldsModel = (ProductionPromptShareMutationFieldsModel) obj;
                if (productionPromptShareMutationFieldsModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(productionPromptShareMutationFieldsModel.m25953a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    productionPromptShareMutationFieldsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = productionPromptShareMutationFieldsModel.w_();
                int u_ = productionPromptShareMutationFieldsModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("production_prompt");
                    ProductionPromptParser.m25956a(mutableFlatBuffer, g, jsonGenerator);
                }
                g = mutableFlatBuffer.g(u_, 1);
                if (g != 0) {
                    jsonGenerator.a("viewer");
                    ViewerParser.m25960a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(ProductionPromptShareMutationFieldsModel.class, new Serializer());
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 1491140198)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: SINGLE_IMAGE_NO_SIZE_WIDTH_HEIGHT */
        public final class ViewerModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private ActorModel f23783d;

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = -1787905591)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: SINGLE_IMAGE_NO_SIZE_WIDTH_HEIGHT */
            public final class ActorModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
                @Nullable
                private GraphQLObjectType f23781d;
                @Nullable
                private String f23782e;

                /* compiled from: SINGLE_IMAGE_NO_SIZE_WIDTH_HEIGHT */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(ActorModel.class, new Deserializer());
                    }

                    public Object m25937a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(ActorParser.m25957a(jsonParser, flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                        Object actorModel = new ActorModel();
                        ((BaseModel) actorModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                        if (actorModel instanceof Postprocessable) {
                            return ((Postprocessable) actorModel).a();
                        }
                        return actorModel;
                    }
                }

                /* compiled from: SINGLE_IMAGE_NO_SIZE_WIDTH_HEIGHT */
                public class Serializer extends JsonSerializer<ActorModel> {
                    public final void m25938a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        ActorModel actorModel = (ActorModel) obj;
                        if (actorModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(actorModel.m25941a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            actorModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        ActorParser.m25958a(actorModel.w_(), actorModel.u_(), jsonGenerator);
                    }

                    static {
                        FbSerializerProvider.a(ActorModel.class, new Serializer());
                    }
                }

                public ActorModel() {
                    super(2);
                }

                public final void m25944a(String str, ConsistencyTuple consistencyTuple) {
                    consistencyTuple.a();
                }

                public final void m25945a(String str, Object obj, boolean z) {
                }

                @Nullable
                private GraphQLObjectType m25939j() {
                    if (this.b != null && this.f23781d == null) {
                        this.f23781d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
                    }
                    return this.f23781d;
                }

                @Nullable
                private String m25940k() {
                    this.f23782e = super.a(this.f23782e, 1);
                    return this.f23782e;
                }

                @Nullable
                public final String m25943a() {
                    return m25940k();
                }

                public final int jK_() {
                    return 63093205;
                }

                public final GraphQLVisitableModel m25942a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    h();
                    i();
                    return this;
                }

                public final int m25941a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int a = ModelHelper.a(flatBufferBuilder, m25939j());
                    int b = flatBufferBuilder.b(m25940k());
                    flatBufferBuilder.c(2);
                    flatBufferBuilder.b(0, a);
                    flatBufferBuilder.b(1, b);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            /* compiled from: SINGLE_IMAGE_NO_SIZE_WIDTH_HEIGHT */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(ViewerModel.class, new Deserializer());
                }

                public Object m25946a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(ViewerParser.m25959a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object viewerModel = new ViewerModel();
                    ((BaseModel) viewerModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (viewerModel instanceof Postprocessable) {
                        return ((Postprocessable) viewerModel).a();
                    }
                    return viewerModel;
                }
            }

            /* compiled from: SINGLE_IMAGE_NO_SIZE_WIDTH_HEIGHT */
            public class Serializer extends JsonSerializer<ViewerModel> {
                public final void m25947a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    ViewerModel viewerModel = (ViewerModel) obj;
                    if (viewerModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(viewerModel.m25949a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        viewerModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    ViewerParser.m25960a(viewerModel.w_(), viewerModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(ViewerModel.class, new Serializer());
                }
            }

            public ViewerModel() {
                super(1);
            }

            @Nullable
            private ActorModel m25948a() {
                this.f23783d = (ActorModel) super.a(this.f23783d, 0, ActorModel.class);
                return this.f23783d;
            }

            public final int jK_() {
                return -1732764110;
            }

            public final GraphQLVisitableModel m25950a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m25948a() != null) {
                    ActorModel actorModel = (ActorModel) graphQLModelMutatingVisitor.b(m25948a());
                    if (m25948a() != actorModel) {
                        graphQLVisitableModel = (ViewerModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f23783d = actorModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m25949a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m25948a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, a);
                i();
                return flatBufferBuilder.d();
            }
        }

        public ProductionPromptShareMutationFieldsModel() {
            super(2);
        }

        @Nullable
        private ProductionPromptModel m25951a() {
            this.f23784d = (ProductionPromptModel) super.a(this.f23784d, 0, ProductionPromptModel.class);
            return this.f23784d;
        }

        @Nullable
        private ViewerModel m25952j() {
            this.f23785e = (ViewerModel) super.a(this.f23785e, 1, ViewerModel.class);
            return this.f23785e;
        }

        public final int jK_() {
            return 185444203;
        }

        public final GraphQLVisitableModel m25954a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m25951a() != null) {
                ProductionPromptModel productionPromptModel = (ProductionPromptModel) graphQLModelMutatingVisitor.b(m25951a());
                if (m25951a() != productionPromptModel) {
                    graphQLVisitableModel = (ProductionPromptShareMutationFieldsModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f23784d = productionPromptModel;
                }
            }
            if (m25952j() != null) {
                ViewerModel viewerModel = (ViewerModel) graphQLModelMutatingVisitor.b(m25952j());
                if (m25952j() != viewerModel) {
                    graphQLVisitableModel = (ProductionPromptShareMutationFieldsModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f23785e = viewerModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m25953a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m25951a());
            int a2 = ModelHelper.a(flatBufferBuilder, m25952j());
            flatBufferBuilder.c(2);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, a2);
            i();
            return flatBufferBuilder.d();
        }
    }
}
