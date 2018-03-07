package com.facebook.facecast.protocol;

import com.facebook.api.graphql.feedback.FeedbackDefaultsGraphQLModels.BaseFeedbackFieldsModel;
import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbSerializerProvider;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.facecast.protocol.FetchLiveVideoFeedbackQueryParsers.FetchLiveVideoFeedbackQueryParser;
import com.facebook.facecast.protocol.FetchLiveVideoFeedbackQueryParsers.FetchLiveVideoFeedbackQueryParser.CreationStoryParser;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.FragmentModelWithoutBridge;
import com.facebook.flatbuffers.ModelWithFlatBufferFormatHash;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.visitor.ConsistencyTuple;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
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

/* compiled from: back_stack */
public class FetchLiveVideoFeedbackQueryModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -468234439)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: back_stack */
    public final class FetchLiveVideoFeedbackQueryModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private CreationStoryModel f18797d;

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1391128899)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: back_stack */
        public final class CreationStoryModel extends BaseModel implements GraphQLVisitableConsistentModel {
            @Nullable
            private BaseFeedbackFieldsModel f18796d;

            /* compiled from: back_stack */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(CreationStoryModel.class, new Deserializer());
                }

                public Object m22376a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(CreationStoryParser.m22388a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object creationStoryModel = new CreationStoryModel();
                    ((BaseModel) creationStoryModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (creationStoryModel instanceof Postprocessable) {
                        return ((Postprocessable) creationStoryModel).a();
                    }
                    return creationStoryModel;
                }
            }

            /* compiled from: back_stack */
            public class Serializer extends JsonSerializer<CreationStoryModel> {
                public final void m22377a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    CreationStoryModel creationStoryModel = (CreationStoryModel) obj;
                    if (creationStoryModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(creationStoryModel.m22378a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        creationStoryModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    CreationStoryParser.m22389a(creationStoryModel.w_(), creationStoryModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(CreationStoryModel.class, new Serializer());
                }
            }

            public CreationStoryModel() {
                super(1);
            }

            public final void m22381a(String str, ConsistencyTuple consistencyTuple) {
                consistencyTuple.a();
            }

            public final void m22382a(String str, Object obj, boolean z) {
            }

            @Nullable
            public final BaseFeedbackFieldsModel m22379a() {
                this.f18796d = (BaseFeedbackFieldsModel) super.a(this.f18796d, 0, BaseFeedbackFieldsModel.class);
                return this.f18796d;
            }

            public final int jK_() {
                return 80218325;
            }

            public final GraphQLVisitableModel m22380a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m22379a() != null) {
                    BaseFeedbackFieldsModel baseFeedbackFieldsModel = (BaseFeedbackFieldsModel) graphQLModelMutatingVisitor.b(m22379a());
                    if (m22379a() != baseFeedbackFieldsModel) {
                        graphQLVisitableModel = (CreationStoryModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f18796d = baseFeedbackFieldsModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m22378a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m22379a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, a);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: back_stack */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(FetchLiveVideoFeedbackQueryModel.class, new Deserializer());
            }

            public Object m22383a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = FetchLiveVideoFeedbackQueryParser.m22390a(jsonParser);
                Object fetchLiveVideoFeedbackQueryModel = new FetchLiveVideoFeedbackQueryModel();
                ((BaseModel) fetchLiveVideoFeedbackQueryModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (fetchLiveVideoFeedbackQueryModel instanceof Postprocessable) {
                    return ((Postprocessable) fetchLiveVideoFeedbackQueryModel).a();
                }
                return fetchLiveVideoFeedbackQueryModel;
            }
        }

        /* compiled from: back_stack */
        public class Serializer extends JsonSerializer<FetchLiveVideoFeedbackQueryModel> {
            public final void m22384a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                FetchLiveVideoFeedbackQueryModel fetchLiveVideoFeedbackQueryModel = (FetchLiveVideoFeedbackQueryModel) obj;
                if (fetchLiveVideoFeedbackQueryModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(fetchLiveVideoFeedbackQueryModel.m22385a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    fetchLiveVideoFeedbackQueryModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = fetchLiveVideoFeedbackQueryModel.w_();
                int u_ = fetchLiveVideoFeedbackQueryModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("creation_story");
                    CreationStoryParser.m22389a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(FetchLiveVideoFeedbackQueryModel.class, new Serializer());
            }
        }

        public FetchLiveVideoFeedbackQueryModel() {
            super(1);
        }

        @Nullable
        public final CreationStoryModel m22386a() {
            this.f18797d = (CreationStoryModel) super.a(this.f18797d, 0, CreationStoryModel.class);
            return this.f18797d;
        }

        public final int jK_() {
            return 82650203;
        }

        public final GraphQLVisitableModel m22387a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m22386a() != null) {
                CreationStoryModel creationStoryModel = (CreationStoryModel) graphQLModelMutatingVisitor.b(m22386a());
                if (m22386a() != creationStoryModel) {
                    graphQLVisitableModel = (FetchLiveVideoFeedbackQueryModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f18797d = creationStoryModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m22385a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m22386a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }
}
