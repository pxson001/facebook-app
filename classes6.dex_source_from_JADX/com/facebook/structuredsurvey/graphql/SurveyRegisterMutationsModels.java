package com.facebook.structuredsurvey.graphql;

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
import com.facebook.structuredsurvey.graphql.SurveyRegisterMutationsParsers.SurveyRegisterUserEventCoreMutationParser;
import com.facebook.structuredsurvey.graphql.SurveyRegisterMutationsParsers.SurveyRegisterUserEventCoreMutationParser.SurveyConfigParser;
import com.facebook.structuredsurvey.graphql.SurveyRegisterMutationsParsers.SurveyUnregisterUserEventCoreMutationParser;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.nio.ByteBuffer;
import javax.annotation.Nullable;

/* compiled from: done_button_tapped */
public class SurveyRegisterMutationsModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 1538186269)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: done_button_tapped */
    public final class SurveyRegisterUserEventCoreMutationModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private SurveyConfigModel f17162d;

        /* compiled from: done_button_tapped */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(SurveyRegisterUserEventCoreMutationModel.class, new Deserializer());
            }

            public Object m24895a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = SurveyRegisterUserEventCoreMutationParser.m24919a(jsonParser);
                Object surveyRegisterUserEventCoreMutationModel = new SurveyRegisterUserEventCoreMutationModel();
                ((BaseModel) surveyRegisterUserEventCoreMutationModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (surveyRegisterUserEventCoreMutationModel instanceof Postprocessable) {
                    return ((Postprocessable) surveyRegisterUserEventCoreMutationModel).a();
                }
                return surveyRegisterUserEventCoreMutationModel;
            }
        }

        /* compiled from: done_button_tapped */
        public class Serializer extends JsonSerializer<SurveyRegisterUserEventCoreMutationModel> {
            public final void m24896a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                SurveyRegisterUserEventCoreMutationModel surveyRegisterUserEventCoreMutationModel = (SurveyRegisterUserEventCoreMutationModel) obj;
                if (surveyRegisterUserEventCoreMutationModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(surveyRegisterUserEventCoreMutationModel.m24904a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    surveyRegisterUserEventCoreMutationModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = surveyRegisterUserEventCoreMutationModel.w_();
                int u_ = surveyRegisterUserEventCoreMutationModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("survey_config");
                    SurveyConfigParser.m24918a(mutableFlatBuffer, g, jsonGenerator);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(SurveyRegisterUserEventCoreMutationModel.class, new Serializer());
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 1801334754)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: done_button_tapped */
        public final class SurveyConfigModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel {
            @Nullable
            private String f17161d;

            /* compiled from: done_button_tapped */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(SurveyConfigModel.class, new Deserializer());
                }

                public Object m24897a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(SurveyConfigParser.m24917a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object surveyConfigModel = new SurveyConfigModel();
                    ((BaseModel) surveyConfigModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (surveyConfigModel instanceof Postprocessable) {
                        return ((Postprocessable) surveyConfigModel).a();
                    }
                    return surveyConfigModel;
                }
            }

            /* compiled from: done_button_tapped */
            public class Serializer extends JsonSerializer<SurveyConfigModel> {
                public final void m24898a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    SurveyConfigModel surveyConfigModel = (SurveyConfigModel) obj;
                    if (surveyConfigModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(surveyConfigModel.m24900a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        surveyConfigModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    SurveyConfigParser.m24918a(surveyConfigModel.w_(), surveyConfigModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(SurveyConfigModel.class, new Serializer());
                }
            }

            public SurveyConfigModel() {
                super(1);
            }

            @Nullable
            private String m24899j() {
                this.f17161d = super.a(this.f17161d, 0);
                return this.f17161d;
            }

            @Nullable
            public final String m24902a() {
                return m24899j();
            }

            public final int jK_() {
                return 548077404;
            }

            public final GraphQLVisitableModel m24901a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m24900a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m24899j());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, b);
                i();
                return flatBufferBuilder.d();
            }
        }

        public SurveyRegisterUserEventCoreMutationModel() {
            super(1);
        }

        @Nullable
        private SurveyConfigModel m24903a() {
            this.f17162d = (SurveyConfigModel) super.a(this.f17162d, 0, SurveyConfigModel.class);
            return this.f17162d;
        }

        public final int jK_() {
            return 871210459;
        }

        public final GraphQLVisitableModel m24905a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m24903a() != null) {
                SurveyConfigModel surveyConfigModel = (SurveyConfigModel) graphQLModelMutatingVisitor.b(m24903a());
                if (m24903a() != surveyConfigModel) {
                    graphQLVisitableModel = (SurveyRegisterUserEventCoreMutationModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f17162d = surveyConfigModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m24904a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m24903a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -1493970486)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: done_button_tapped */
    public final class SurveyUnregisterUserEventCoreMutationModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private SurveyConfigModel f17164d;

        /* compiled from: done_button_tapped */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(SurveyUnregisterUserEventCoreMutationModel.class, new Deserializer());
            }

            public Object m24906a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = SurveyUnregisterUserEventCoreMutationParser.m24922a(jsonParser);
                Object surveyUnregisterUserEventCoreMutationModel = new SurveyUnregisterUserEventCoreMutationModel();
                ((BaseModel) surveyUnregisterUserEventCoreMutationModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (surveyUnregisterUserEventCoreMutationModel instanceof Postprocessable) {
                    return ((Postprocessable) surveyUnregisterUserEventCoreMutationModel).a();
                }
                return surveyUnregisterUserEventCoreMutationModel;
            }
        }

        /* compiled from: done_button_tapped */
        public class Serializer extends JsonSerializer<SurveyUnregisterUserEventCoreMutationModel> {
            public final void m24907a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                SurveyUnregisterUserEventCoreMutationModel surveyUnregisterUserEventCoreMutationModel = (SurveyUnregisterUserEventCoreMutationModel) obj;
                if (surveyUnregisterUserEventCoreMutationModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(surveyUnregisterUserEventCoreMutationModel.m24915a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    surveyUnregisterUserEventCoreMutationModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = surveyUnregisterUserEventCoreMutationModel.w_();
                int u_ = surveyUnregisterUserEventCoreMutationModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("survey_config");
                    SurveyUnregisterUserEventCoreMutationParser.SurveyConfigParser.m24921a(mutableFlatBuffer, g, jsonGenerator);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(SurveyUnregisterUserEventCoreMutationModel.class, new Serializer());
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 1801334754)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: done_button_tapped */
        public final class SurveyConfigModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel {
            @Nullable
            private String f17163d;

            /* compiled from: done_button_tapped */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(SurveyConfigModel.class, new Deserializer());
                }

                public Object m24908a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(SurveyUnregisterUserEventCoreMutationParser.SurveyConfigParser.m24920a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object surveyConfigModel = new SurveyConfigModel();
                    ((BaseModel) surveyConfigModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (surveyConfigModel instanceof Postprocessable) {
                        return ((Postprocessable) surveyConfigModel).a();
                    }
                    return surveyConfigModel;
                }
            }

            /* compiled from: done_button_tapped */
            public class Serializer extends JsonSerializer<SurveyConfigModel> {
                public final void m24909a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    SurveyConfigModel surveyConfigModel = (SurveyConfigModel) obj;
                    if (surveyConfigModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(surveyConfigModel.m24911a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        surveyConfigModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    SurveyUnregisterUserEventCoreMutationParser.SurveyConfigParser.m24921a(surveyConfigModel.w_(), surveyConfigModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(SurveyConfigModel.class, new Serializer());
                }
            }

            public SurveyConfigModel() {
                super(1);
            }

            @Nullable
            private String m24910j() {
                this.f17163d = super.a(this.f17163d, 0);
                return this.f17163d;
            }

            @Nullable
            public final String m24913a() {
                return m24910j();
            }

            public final int jK_() {
                return 548077404;
            }

            public final GraphQLVisitableModel m24912a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m24911a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m24910j());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, b);
                i();
                return flatBufferBuilder.d();
            }
        }

        public SurveyUnregisterUserEventCoreMutationModel() {
            super(1);
        }

        @Nullable
        private SurveyConfigModel m24914a() {
            this.f17164d = (SurveyConfigModel) super.a(this.f17164d, 0, SurveyConfigModel.class);
            return this.f17164d;
        }

        public final int jK_() {
            return 1171753460;
        }

        public final GraphQLVisitableModel m24916a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m24914a() != null) {
                SurveyConfigModel surveyConfigModel = (SurveyConfigModel) graphQLModelMutatingVisitor.b(m24914a());
                if (m24914a() != surveyConfigModel) {
                    graphQLVisitableModel = (SurveyUnregisterUserEventCoreMutationModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f17164d = surveyConfigModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m24915a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m24914a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }
}
