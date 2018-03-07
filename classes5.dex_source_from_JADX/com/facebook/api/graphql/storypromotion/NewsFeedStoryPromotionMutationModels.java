package com.facebook.api.graphql.storypromotion;

import com.facebook.api.graphql.storypromotion.NewsFeedStoryPromotionMutationParsers.AYMTLogEventMutationParser;
import com.facebook.api.graphql.storypromotion.NewsFeedStoryPromotionMutationParsers.AYMTLogEventMutationParser.AymtChannelParser;
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
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLPersistableNode;
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

/* compiled from: targetId */
public class NewsFeedStoryPromotionMutationModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -1814460096)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: targetId */
    public final class AYMTLogEventMutationModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private AymtChannelModel f2169d;

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 1801334754)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: targetId */
        public final class AymtChannelModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel {
            @Nullable
            private String f2168d;

            /* compiled from: targetId */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(AymtChannelModel.class, new Deserializer());
                }

                public Object m2974a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(AymtChannelParser.m2985a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object aymtChannelModel = new AymtChannelModel();
                    ((BaseModel) aymtChannelModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (aymtChannelModel instanceof Postprocessable) {
                        return ((Postprocessable) aymtChannelModel).a();
                    }
                    return aymtChannelModel;
                }
            }

            /* compiled from: targetId */
            public class Serializer extends JsonSerializer<AymtChannelModel> {
                public final void m2975a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    AymtChannelModel aymtChannelModel = (AymtChannelModel) obj;
                    if (aymtChannelModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(aymtChannelModel.m2977a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        aymtChannelModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    AymtChannelParser.m2986a(aymtChannelModel.w_(), aymtChannelModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(AymtChannelModel.class, new Serializer());
                }
            }

            public AymtChannelModel() {
                super(1);
            }

            @Nullable
            private String m2976j() {
                this.f2168d = super.a(this.f2168d, 0);
                return this.f2168d;
            }

            @Nullable
            public final String m2979a() {
                return m2976j();
            }

            public final int jK_() {
                return -111810524;
            }

            public final GraphQLVisitableModel m2978a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m2977a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m2976j());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, b);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: targetId */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(AYMTLogEventMutationModel.class, new Deserializer());
            }

            public Object m2980a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = AYMTLogEventMutationParser.m2987a(jsonParser);
                Object aYMTLogEventMutationModel = new AYMTLogEventMutationModel();
                ((BaseModel) aYMTLogEventMutationModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (aYMTLogEventMutationModel instanceof Postprocessable) {
                    return ((Postprocessable) aYMTLogEventMutationModel).a();
                }
                return aYMTLogEventMutationModel;
            }
        }

        /* compiled from: targetId */
        public class Serializer extends JsonSerializer<AYMTLogEventMutationModel> {
            public final void m2981a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                AYMTLogEventMutationModel aYMTLogEventMutationModel = (AYMTLogEventMutationModel) obj;
                if (aYMTLogEventMutationModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(aYMTLogEventMutationModel.m2983a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    aYMTLogEventMutationModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = aYMTLogEventMutationModel.w_();
                int u_ = aYMTLogEventMutationModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("aymt_channel");
                    AymtChannelParser.m2986a(mutableFlatBuffer, g, jsonGenerator);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(AYMTLogEventMutationModel.class, new Serializer());
            }
        }

        public AYMTLogEventMutationModel() {
            super(1);
        }

        @Nullable
        private AymtChannelModel m2982a() {
            this.f2169d = (AymtChannelModel) super.a(this.f2169d, 0, AymtChannelModel.class);
            return this.f2169d;
        }

        public final int jK_() {
            return -1281540488;
        }

        public final GraphQLVisitableModel m2984a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m2982a() != null) {
                AymtChannelModel aymtChannelModel = (AymtChannelModel) graphQLModelMutatingVisitor.b(m2982a());
                if (m2982a() != aymtChannelModel) {
                    graphQLVisitableModel = (AYMTLogEventMutationModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f2169d = aymtChannelModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m2983a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m2982a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }
}
