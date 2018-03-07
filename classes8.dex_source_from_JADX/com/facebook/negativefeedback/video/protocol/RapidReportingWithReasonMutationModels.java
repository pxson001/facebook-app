package com.facebook.negativefeedback.video.protocol;

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
import com.facebook.graphql.visitor.ConsistencyTuple;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLPersistableNode;
import com.facebook.graphql.visitor.GraphQLVisitableConsistentModel;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.facebook.negativefeedback.video.protocol.RapidReportingWithReasonMutationParsers.RapidReportingWithReasonMutationParser;
import com.facebook.negativefeedback.video.protocol.RapidReportingWithReasonMutationParsers.RapidReportingWithReasonMutationParser.StoryParser;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.nio.ByteBuffer;
import javax.annotation.Nullable;

/* compiled from: test_bounce_from_msite */
public class RapidReportingWithReasonMutationModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 1357585312)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: test_bounce_from_msite */
    public final class RapidReportingWithReasonMutationModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private StoryModel f1643d;

        /* compiled from: test_bounce_from_msite */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(RapidReportingWithReasonMutationModel.class, new Deserializer());
            }

            public Object m1870a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = RapidReportingWithReasonMutationParser.m1885a(jsonParser);
                Object rapidReportingWithReasonMutationModel = new RapidReportingWithReasonMutationModel();
                ((BaseModel) rapidReportingWithReasonMutationModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (rapidReportingWithReasonMutationModel instanceof Postprocessable) {
                    return ((Postprocessable) rapidReportingWithReasonMutationModel).a();
                }
                return rapidReportingWithReasonMutationModel;
            }
        }

        /* compiled from: test_bounce_from_msite */
        public class Serializer extends JsonSerializer<RapidReportingWithReasonMutationModel> {
            public final void m1871a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                RapidReportingWithReasonMutationModel rapidReportingWithReasonMutationModel = (RapidReportingWithReasonMutationModel) obj;
                if (rapidReportingWithReasonMutationModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(rapidReportingWithReasonMutationModel.m1881a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    rapidReportingWithReasonMutationModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = rapidReportingWithReasonMutationModel.w_();
                int u_ = rapidReportingWithReasonMutationModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("story");
                    StoryParser.m1884a(mutableFlatBuffer, g, jsonGenerator);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(RapidReportingWithReasonMutationModel.class, new Serializer());
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 1801334754)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: test_bounce_from_msite */
        public final class StoryModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
            @Nullable
            private String f1642d;

            /* compiled from: test_bounce_from_msite */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(StoryModel.class, new Deserializer());
                }

                public Object m1872a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(StoryParser.m1883a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object storyModel = new StoryModel();
                    ((BaseModel) storyModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (storyModel instanceof Postprocessable) {
                        return ((Postprocessable) storyModel).a();
                    }
                    return storyModel;
                }
            }

            /* compiled from: test_bounce_from_msite */
            public class Serializer extends JsonSerializer<StoryModel> {
                public final void m1873a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    StoryModel storyModel = (StoryModel) obj;
                    if (storyModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(storyModel.m1875a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        storyModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    StoryParser.m1884a(storyModel.w_(), storyModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(StoryModel.class, new Serializer());
                }
            }

            public StoryModel() {
                super(1);
            }

            public final void m1878a(String str, ConsistencyTuple consistencyTuple) {
                consistencyTuple.a();
            }

            public final void m1879a(String str, Object obj, boolean z) {
            }

            @Nullable
            private String m1874j() {
                this.f1642d = super.a(this.f1642d, 0);
                return this.f1642d;
            }

            @Nullable
            public final String m1877a() {
                return m1874j();
            }

            public final int jK_() {
                return 80218325;
            }

            public final GraphQLVisitableModel m1876a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m1875a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m1874j());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, b);
                i();
                return flatBufferBuilder.d();
            }
        }

        public RapidReportingWithReasonMutationModel() {
            super(1);
        }

        @Nullable
        private StoryModel m1880a() {
            this.f1643d = (StoryModel) super.a(this.f1643d, 0, StoryModel.class);
            return this.f1643d;
        }

        public final int jK_() {
            return -119445719;
        }

        public final GraphQLVisitableModel m1882a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m1880a() != null) {
                StoryModel storyModel = (StoryModel) graphQLModelMutatingVisitor.b(m1880a());
                if (m1880a() != storyModel) {
                    graphQLVisitableModel = (RapidReportingWithReasonMutationModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f1643d = storyModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m1881a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m1880a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }
}
