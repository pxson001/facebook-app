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
import com.facebook.negativefeedback.video.protocol.RapidReportingMutationParsers.RapidReportingMutationParser;
import com.facebook.negativefeedback.video.protocol.RapidReportingMutationParsers.RapidReportingMutationParser.StoryParser;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.nio.ByteBuffer;
import javax.annotation.Nullable;

/* compiled from: text_only_attachment */
public class RapidReportingMutationModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -1989215802)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: text_only_attachment */
    public final class RapidReportingMutationModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private StoryModel f1633d;

        /* compiled from: text_only_attachment */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(RapidReportingMutationModel.class, new Deserializer());
            }

            public Object m1817a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = RapidReportingMutationParser.m1832a(jsonParser);
                Object rapidReportingMutationModel = new RapidReportingMutationModel();
                ((BaseModel) rapidReportingMutationModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (rapidReportingMutationModel instanceof Postprocessable) {
                    return ((Postprocessable) rapidReportingMutationModel).a();
                }
                return rapidReportingMutationModel;
            }
        }

        /* compiled from: text_only_attachment */
        public class Serializer extends JsonSerializer<RapidReportingMutationModel> {
            public final void m1818a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                RapidReportingMutationModel rapidReportingMutationModel = (RapidReportingMutationModel) obj;
                if (rapidReportingMutationModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(rapidReportingMutationModel.m1828a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    rapidReportingMutationModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = rapidReportingMutationModel.w_();
                int u_ = rapidReportingMutationModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("story");
                    StoryParser.m1831a(mutableFlatBuffer, g, jsonGenerator);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(RapidReportingMutationModel.class, new Serializer());
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 1801334754)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: text_only_attachment */
        public final class StoryModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
            @Nullable
            private String f1632d;

            /* compiled from: text_only_attachment */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(StoryModel.class, new Deserializer());
                }

                public Object m1819a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(StoryParser.m1830a(jsonParser, flatBufferBuilder));
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

            /* compiled from: text_only_attachment */
            public class Serializer extends JsonSerializer<StoryModel> {
                public final void m1820a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    StoryModel storyModel = (StoryModel) obj;
                    if (storyModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(storyModel.m1822a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        storyModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    StoryParser.m1831a(storyModel.w_(), storyModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(StoryModel.class, new Serializer());
                }
            }

            public StoryModel() {
                super(1);
            }

            public final void m1825a(String str, ConsistencyTuple consistencyTuple) {
                consistencyTuple.a();
            }

            public final void m1826a(String str, Object obj, boolean z) {
            }

            @Nullable
            private String m1821j() {
                this.f1632d = super.a(this.f1632d, 0);
                return this.f1632d;
            }

            @Nullable
            public final String m1824a() {
                return m1821j();
            }

            public final int jK_() {
                return 80218325;
            }

            public final GraphQLVisitableModel m1823a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m1822a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m1821j());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, b);
                i();
                return flatBufferBuilder.d();
            }
        }

        public RapidReportingMutationModel() {
            super(1);
        }

        @Nullable
        private StoryModel m1827a() {
            this.f1633d = (StoryModel) super.a(this.f1633d, 0, StoryModel.class);
            return this.f1633d;
        }

        public final int jK_() {
            return -542069660;
        }

        public final GraphQLVisitableModel m1829a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m1827a() != null) {
                StoryModel storyModel = (StoryModel) graphQLModelMutatingVisitor.b(m1827a());
                if (m1827a() != storyModel) {
                    graphQLVisitableModel = (RapidReportingMutationModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f1633d = storyModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m1828a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m1827a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }
}
