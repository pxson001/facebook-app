package com.facebook.survey.graphql;

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
import com.facebook.survey.graphql.FetchSurveyConfigParsers.FetchSurveyConfigParser;
import com.facebook.survey.graphql.FetchSurveyConfigParsers.FetchSurveyConfigParser.StructuredSurveyParser;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.nio.ByteBuffer;
import javax.annotation.Nullable;

/* compiled from: disable_attach_to_album */
public class FetchSurveyConfigModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -1849514013)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: disable_attach_to_album */
    public final class FetchSurveyConfigModel extends BaseModel implements GraphQLVisitableConsistentModel {
        @Nullable
        private GraphQLObjectType f17243d;
        @Nullable
        private StructuredSurveyModel f17244e;
        @Nullable
        private String f17245f;

        /* compiled from: disable_attach_to_album */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(FetchSurveyConfigModel.class, new Deserializer());
            }

            public Object m24988a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = FetchSurveyConfigParser.m25005a(jsonParser);
                Object fetchSurveyConfigModel = new FetchSurveyConfigModel();
                ((BaseModel) fetchSurveyConfigModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (fetchSurveyConfigModel instanceof Postprocessable) {
                    return ((Postprocessable) fetchSurveyConfigModel).a();
                }
                return fetchSurveyConfigModel;
            }
        }

        /* compiled from: disable_attach_to_album */
        public class Serializer extends JsonSerializer<FetchSurveyConfigModel> {
            public final void m24989a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                FetchSurveyConfigModel fetchSurveyConfigModel = (FetchSurveyConfigModel) obj;
                if (fetchSurveyConfigModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(fetchSurveyConfigModel.m24997a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    fetchSurveyConfigModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = fetchSurveyConfigModel.w_();
                int u_ = fetchSurveyConfigModel.u_();
                jsonGenerator.f();
                if (mutableFlatBuffer.g(u_, 0) != 0) {
                    jsonGenerator.a("__type__");
                    SerializerHelpers.b(mutableFlatBuffer, u_, 0, jsonGenerator);
                }
                int g = mutableFlatBuffer.g(u_, 1);
                if (g != 0) {
                    jsonGenerator.a("structured_survey");
                    StructuredSurveyParser.m25004a(mutableFlatBuffer, g, jsonGenerator);
                }
                if (mutableFlatBuffer.g(u_, 2) != 0) {
                    jsonGenerator.a("survey_start_url");
                    jsonGenerator.b(mutableFlatBuffer.c(u_, 2));
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(FetchSurveyConfigModel.class, new Serializer());
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 1801334754)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: disable_attach_to_album */
        public final class StructuredSurveyModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel {
            @Nullable
            private String f17242d;

            /* compiled from: disable_attach_to_album */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(StructuredSurveyModel.class, new Deserializer());
                }

                public Object m24990a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(StructuredSurveyParser.m25003a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object structuredSurveyModel = new StructuredSurveyModel();
                    ((BaseModel) structuredSurveyModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (structuredSurveyModel instanceof Postprocessable) {
                        return ((Postprocessable) structuredSurveyModel).a();
                    }
                    return structuredSurveyModel;
                }
            }

            /* compiled from: disable_attach_to_album */
            public class Serializer extends JsonSerializer<StructuredSurveyModel> {
                public final void m24991a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    StructuredSurveyModel structuredSurveyModel = (StructuredSurveyModel) obj;
                    if (structuredSurveyModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(structuredSurveyModel.m24992a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        structuredSurveyModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    StructuredSurveyParser.m25004a(structuredSurveyModel.w_(), structuredSurveyModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(StructuredSurveyModel.class, new Serializer());
                }
            }

            public StructuredSurveyModel() {
                super(1);
            }

            @Nullable
            public final String m24995j() {
                this.f17242d = super.a(this.f17242d, 0);
                return this.f17242d;
            }

            @Nullable
            public final String m24994a() {
                return m24995j();
            }

            public final int jK_() {
                return -943106005;
            }

            public final GraphQLVisitableModel m24993a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m24992a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m24995j());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, b);
                i();
                return flatBufferBuilder.d();
            }
        }

        public FetchSurveyConfigModel() {
            super(3);
        }

        public final void m25000a(String str, ConsistencyTuple consistencyTuple) {
            consistencyTuple.a();
        }

        public final void m25001a(String str, Object obj, boolean z) {
        }

        @Nullable
        private GraphQLObjectType m24996k() {
            if (this.b != null && this.f17243d == null) {
                this.f17243d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
            }
            return this.f17243d;
        }

        @Nullable
        public final StructuredSurveyModel m24999a() {
            this.f17244e = (StructuredSurveyModel) super.a(this.f17244e, 1, StructuredSurveyModel.class);
            return this.f17244e;
        }

        @Nullable
        public final String m25002j() {
            this.f17245f = super.a(this.f17245f, 2);
            return this.f17245f;
        }

        public final int jK_() {
            return 2433570;
        }

        public final GraphQLVisitableModel m24998a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m24999a() != null) {
                StructuredSurveyModel structuredSurveyModel = (StructuredSurveyModel) graphQLModelMutatingVisitor.b(m24999a());
                if (m24999a() != structuredSurveyModel) {
                    graphQLVisitableModel = (FetchSurveyConfigModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f17244e = structuredSurveyModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m24997a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m24996k());
            int a2 = ModelHelper.a(flatBufferBuilder, m24999a());
            int b = flatBufferBuilder.b(m25002j());
            flatBufferBuilder.c(3);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, a2);
            flatBufferBuilder.b(2, b);
            i();
            return flatBufferBuilder.d();
        }
    }
}
