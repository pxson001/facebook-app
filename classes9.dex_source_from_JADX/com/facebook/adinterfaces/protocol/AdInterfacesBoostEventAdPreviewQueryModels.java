package com.facebook.adinterfaces.protocol;

import com.facebook.adinterfaces.protocol.AdInterfacesBoostEventAdPreviewQueryParsers.FBEventPromotionAdPreviewFeedUnitQueryParser;
import com.facebook.adinterfaces.protocol.AdInterfacesBoostEventAdPreviewQueryParsers.FBEventPromotionAdPreviewFeedUnitQueryParser.PromotionInfoParser;
import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbSerializerProvider;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.FragmentModelWithBridge;
import com.facebook.flatbuffers.ModelWithFlatBufferFormatHash;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.visitor.ConsistencyTuple;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLPersistableNode;
import com.facebook.graphql.visitor.GraphQLVisitableConsistentModel;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.facebook.zero.iptest.graphql.ZeroIPTestGraphQLParsers.ZeroIPTestSubmitMutationParser;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.nio.ByteBuffer;
import javax.annotation.Nullable;

/* compiled from: [ABCEGHJKLMNPRSTVXY]\d[ABCEGHJ-NPRSTV-Z][ ]?\d[ABCEGHJ-NPRSTV-Z]\d */
public class AdInterfacesBoostEventAdPreviewQueryModels {

    @FragmentModelWithBridge
    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -1759217711)
    @JsonSerialize(using = Serializer.class)
    /* compiled from: [ABCEGHJKLMNPRSTVXY]\d[ABCEGHJ-NPRSTV-Z][ ]?\d[ABCEGHJ-NPRSTV-Z]\d */
    public final class FBEventPromotionAdPreviewFeedUnitQueryModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
        @Nullable
        private String f21918d;
        @Nullable
        private PromotionInfoModel f21919e;

        /* compiled from: [ABCEGHJKLMNPRSTVXY]\d[ABCEGHJ-NPRSTV-Z][ ]?\d[ABCEGHJ-NPRSTV-Z]\d */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(FBEventPromotionAdPreviewFeedUnitQueryModel.class, new Deserializer());
            }

            public Object m23003a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = FBEventPromotionAdPreviewFeedUnitQueryParser.m23018a(jsonParser);
                Object fBEventPromotionAdPreviewFeedUnitQueryModel = new FBEventPromotionAdPreviewFeedUnitQueryModel();
                ((BaseModel) fBEventPromotionAdPreviewFeedUnitQueryModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (fBEventPromotionAdPreviewFeedUnitQueryModel instanceof Postprocessable) {
                    return ((Postprocessable) fBEventPromotionAdPreviewFeedUnitQueryModel).a();
                }
                return fBEventPromotionAdPreviewFeedUnitQueryModel;
            }
        }

        @FragmentModelWithBridge
        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 59497387)
        @JsonSerialize(using = Serializer.class)
        /* compiled from: [ABCEGHJKLMNPRSTVXY]\d[ABCEGHJ-NPRSTV-Z][ ]?\d[ABCEGHJ-NPRSTV-Z]\d */
        public final class PromotionInfoModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private GraphQLStory f21917d;

            /* compiled from: [ABCEGHJKLMNPRSTVXY]\d[ABCEGHJ-NPRSTV-Z][ ]?\d[ABCEGHJ-NPRSTV-Z]\d */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(PromotionInfoModel.class, new Deserializer());
                }

                public Object m23004a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(PromotionInfoParser.m23017a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object promotionInfoModel = new PromotionInfoModel();
                    ((BaseModel) promotionInfoModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (promotionInfoModel instanceof Postprocessable) {
                        return ((Postprocessable) promotionInfoModel).a();
                    }
                    return promotionInfoModel;
                }
            }

            /* compiled from: [ABCEGHJKLMNPRSTVXY]\d[ABCEGHJ-NPRSTV-Z][ ]?\d[ABCEGHJ-NPRSTV-Z]\d */
            public class Serializer extends JsonSerializer<PromotionInfoModel> {
                public final void m23005a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    PromotionInfoModel promotionInfoModel = (PromotionInfoModel) obj;
                    if (promotionInfoModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(promotionInfoModel.m23006a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        promotionInfoModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    ZeroIPTestSubmitMutationParser.a(promotionInfoModel.w_(), promotionInfoModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(PromotionInfoModel.class, new Serializer());
                }
            }

            public PromotionInfoModel() {
                super(1);
            }

            @Nullable
            public final GraphQLStory m23007a() {
                this.f21917d = (GraphQLStory) super.a(this.f21917d, 0, GraphQLStory.class);
                return this.f21917d;
            }

            public final int jK_() {
                return 349774914;
            }

            public final GraphQLVisitableModel m23008a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m23007a() != null) {
                    GraphQLStory graphQLStory = (GraphQLStory) graphQLModelMutatingVisitor.b(m23007a());
                    if (m23007a() != graphQLStory) {
                        graphQLVisitableModel = (PromotionInfoModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f21917d = graphQLStory;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m23006a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m23007a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, a);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: [ABCEGHJKLMNPRSTVXY]\d[ABCEGHJ-NPRSTV-Z][ ]?\d[ABCEGHJ-NPRSTV-Z]\d */
        public class Serializer extends JsonSerializer<FBEventPromotionAdPreviewFeedUnitQueryModel> {
            public final void m23009a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                FBEventPromotionAdPreviewFeedUnitQueryModel fBEventPromotionAdPreviewFeedUnitQueryModel = (FBEventPromotionAdPreviewFeedUnitQueryModel) obj;
                if (fBEventPromotionAdPreviewFeedUnitQueryModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(fBEventPromotionAdPreviewFeedUnitQueryModel.m23011a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    fBEventPromotionAdPreviewFeedUnitQueryModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = fBEventPromotionAdPreviewFeedUnitQueryModel.w_();
                int u_ = fBEventPromotionAdPreviewFeedUnitQueryModel.u_();
                jsonGenerator.f();
                if (mutableFlatBuffer.g(u_, 0) != 0) {
                    jsonGenerator.a("id");
                    jsonGenerator.b(mutableFlatBuffer.c(u_, 0));
                }
                int g = mutableFlatBuffer.g(u_, 1);
                if (g != 0) {
                    jsonGenerator.a("promotion_info");
                    ZeroIPTestSubmitMutationParser.a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(FBEventPromotionAdPreviewFeedUnitQueryModel.class, new Serializer());
            }
        }

        public FBEventPromotionAdPreviewFeedUnitQueryModel() {
            super(2);
        }

        public final void m23014a(String str, ConsistencyTuple consistencyTuple) {
            consistencyTuple.a();
        }

        public final void m23015a(String str, Object obj, boolean z) {
        }

        @Nullable
        private String m23010k() {
            this.f21918d = super.a(this.f21918d, 0);
            return this.f21918d;
        }

        @Nullable
        public final PromotionInfoModel m23016j() {
            this.f21919e = (PromotionInfoModel) super.a(this.f21919e, 1, PromotionInfoModel.class);
            return this.f21919e;
        }

        @Nullable
        public final String m23013a() {
            return m23010k();
        }

        public final int jK_() {
            return 80218325;
        }

        public final GraphQLVisitableModel m23012a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m23016j() != null) {
                PromotionInfoModel promotionInfoModel = (PromotionInfoModel) graphQLModelMutatingVisitor.b(m23016j());
                if (m23016j() != promotionInfoModel) {
                    graphQLVisitableModel = (FBEventPromotionAdPreviewFeedUnitQueryModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f21919e = promotionInfoModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m23011a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(m23010k());
            int a = ModelHelper.a(flatBufferBuilder, m23016j());
            flatBufferBuilder.c(2);
            flatBufferBuilder.b(0, b);
            flatBufferBuilder.b(1, a);
            i();
            return flatBufferBuilder.d();
        }
    }
}
