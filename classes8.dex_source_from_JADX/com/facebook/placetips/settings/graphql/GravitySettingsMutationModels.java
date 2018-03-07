package com.facebook.placetips.settings.graphql;

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
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.facebook.placetips.settings.graphql.GravitySettingsGraphQlFragmentModels.GravitySettingsGraphQlFragmentModel;
import com.facebook.placetips.settings.graphql.GravitySettingsGraphQlFragmentParsers.GravitySettingsGraphQlFragmentParser;
import com.facebook.placetips.settings.graphql.GravitySettingsMutationParsers.GravityBlacklistFeedbackMutationParser;
import com.facebook.placetips.settings.graphql.GravitySettingsMutationParsers.GravityNegativeFeedbackMutationParser;
import com.facebook.placetips.settings.graphql.GravitySettingsMutationParsers.GravitySettingsMutationParser;
import com.facebook.placetips.settings.graphql.GravitySettingsMutationParsers.GravityUnblacklistFeedbackMutationParser;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.nio.ByteBuffer;
import javax.annotation.Nullable;

/* compiled from: rule */
public class GravitySettingsMutationModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -2642782)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: rule */
    public final class GravityBlacklistFeedbackMutationModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private String f3924d;

        /* compiled from: rule */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(GravityBlacklistFeedbackMutationModel.class, new Deserializer());
            }

            public Object m3896a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = GravityBlacklistFeedbackMutationParser.m3916a(jsonParser);
                Object gravityBlacklistFeedbackMutationModel = new GravityBlacklistFeedbackMutationModel();
                ((BaseModel) gravityBlacklistFeedbackMutationModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (gravityBlacklistFeedbackMutationModel instanceof Postprocessable) {
                    return ((Postprocessable) gravityBlacklistFeedbackMutationModel).a();
                }
                return gravityBlacklistFeedbackMutationModel;
            }
        }

        /* compiled from: rule */
        public class Serializer extends JsonSerializer<GravityBlacklistFeedbackMutationModel> {
            public final void m3897a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                GravityBlacklistFeedbackMutationModel gravityBlacklistFeedbackMutationModel = (GravityBlacklistFeedbackMutationModel) obj;
                if (gravityBlacklistFeedbackMutationModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(gravityBlacklistFeedbackMutationModel.m3899a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    gravityBlacklistFeedbackMutationModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = gravityBlacklistFeedbackMutationModel.w_();
                int u_ = gravityBlacklistFeedbackMutationModel.u_();
                jsonGenerator.f();
                if (mutableFlatBuffer.g(u_, 0) != 0) {
                    jsonGenerator.a("client_mutation_id");
                    jsonGenerator.b(mutableFlatBuffer.c(u_, 0));
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(GravityBlacklistFeedbackMutationModel.class, new Serializer());
            }
        }

        public GravityBlacklistFeedbackMutationModel() {
            super(1);
        }

        @Nullable
        private String m3898a() {
            this.f3924d = super.a(this.f3924d, 0);
            return this.f3924d;
        }

        public final int jK_() {
            return -101059069;
        }

        public final GraphQLVisitableModel m3900a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            h();
            i();
            return this;
        }

        public final int m3899a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(m3898a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, b);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -2642782)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: rule */
    public final class GravityNegativeFeedbackMutationModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private String f3925d;

        /* compiled from: rule */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(GravityNegativeFeedbackMutationModel.class, new Deserializer());
            }

            public Object m3901a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = GravityNegativeFeedbackMutationParser.m3917a(jsonParser);
                Object gravityNegativeFeedbackMutationModel = new GravityNegativeFeedbackMutationModel();
                ((BaseModel) gravityNegativeFeedbackMutationModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (gravityNegativeFeedbackMutationModel instanceof Postprocessable) {
                    return ((Postprocessable) gravityNegativeFeedbackMutationModel).a();
                }
                return gravityNegativeFeedbackMutationModel;
            }
        }

        /* compiled from: rule */
        public class Serializer extends JsonSerializer<GravityNegativeFeedbackMutationModel> {
            public final void m3902a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                GravityNegativeFeedbackMutationModel gravityNegativeFeedbackMutationModel = (GravityNegativeFeedbackMutationModel) obj;
                if (gravityNegativeFeedbackMutationModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(gravityNegativeFeedbackMutationModel.m3904a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    gravityNegativeFeedbackMutationModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = gravityNegativeFeedbackMutationModel.w_();
                int u_ = gravityNegativeFeedbackMutationModel.u_();
                jsonGenerator.f();
                if (mutableFlatBuffer.g(u_, 0) != 0) {
                    jsonGenerator.a("client_mutation_id");
                    jsonGenerator.b(mutableFlatBuffer.c(u_, 0));
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(GravityNegativeFeedbackMutationModel.class, new Serializer());
            }
        }

        public GravityNegativeFeedbackMutationModel() {
            super(1);
        }

        @Nullable
        private String m3903a() {
            this.f3925d = super.a(this.f3925d, 0);
            return this.f3925d;
        }

        public final int jK_() {
            return 2034762693;
        }

        public final GraphQLVisitableModel m3905a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            h();
            i();
            return this;
        }

        public final int m3904a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(m3903a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, b);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 216263718)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: rule */
    public final class GravitySettingsMutationModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private GravitySettingsGraphQlFragmentModel f3926d;

        /* compiled from: rule */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(GravitySettingsMutationModel.class, new Deserializer());
            }

            public Object m3906a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = GravitySettingsMutationParser.m3918a(jsonParser);
                Object gravitySettingsMutationModel = new GravitySettingsMutationModel();
                ((BaseModel) gravitySettingsMutationModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (gravitySettingsMutationModel instanceof Postprocessable) {
                    return ((Postprocessable) gravitySettingsMutationModel).a();
                }
                return gravitySettingsMutationModel;
            }
        }

        /* compiled from: rule */
        public class Serializer extends JsonSerializer<GravitySettingsMutationModel> {
            public final void m3907a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                GravitySettingsMutationModel gravitySettingsMutationModel = (GravitySettingsMutationModel) obj;
                if (gravitySettingsMutationModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(gravitySettingsMutationModel.m3908a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    gravitySettingsMutationModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = gravitySettingsMutationModel.w_();
                int u_ = gravitySettingsMutationModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("settings");
                    GravitySettingsGraphQlFragmentParser.a(mutableFlatBuffer, g, jsonGenerator);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(GravitySettingsMutationModel.class, new Serializer());
            }
        }

        public GravitySettingsMutationModel() {
            super(1);
        }

        @Nullable
        public final GravitySettingsGraphQlFragmentModel m3910a() {
            this.f3926d = (GravitySettingsGraphQlFragmentModel) super.a(this.f3926d, 0, GravitySettingsGraphQlFragmentModel.class);
            return this.f3926d;
        }

        public final int jK_() {
            return 907141953;
        }

        public final GraphQLVisitableModel m3909a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m3910a() != null) {
                GravitySettingsGraphQlFragmentModel gravitySettingsGraphQlFragmentModel = (GravitySettingsGraphQlFragmentModel) graphQLModelMutatingVisitor.b(m3910a());
                if (m3910a() != gravitySettingsGraphQlFragmentModel) {
                    graphQLVisitableModel = (GravitySettingsMutationModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f3926d = gravitySettingsGraphQlFragmentModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m3908a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m3910a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -2642782)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: rule */
    public final class GravityUnblacklistFeedbackMutationModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private String f3927d;

        /* compiled from: rule */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(GravityUnblacklistFeedbackMutationModel.class, new Deserializer());
            }

            public Object m3911a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = GravityUnblacklistFeedbackMutationParser.m3919a(jsonParser);
                Object gravityUnblacklistFeedbackMutationModel = new GravityUnblacklistFeedbackMutationModel();
                ((BaseModel) gravityUnblacklistFeedbackMutationModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (gravityUnblacklistFeedbackMutationModel instanceof Postprocessable) {
                    return ((Postprocessable) gravityUnblacklistFeedbackMutationModel).a();
                }
                return gravityUnblacklistFeedbackMutationModel;
            }
        }

        /* compiled from: rule */
        public class Serializer extends JsonSerializer<GravityUnblacklistFeedbackMutationModel> {
            public final void m3912a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                GravityUnblacklistFeedbackMutationModel gravityUnblacklistFeedbackMutationModel = (GravityUnblacklistFeedbackMutationModel) obj;
                if (gravityUnblacklistFeedbackMutationModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(gravityUnblacklistFeedbackMutationModel.m3914a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    gravityUnblacklistFeedbackMutationModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = gravityUnblacklistFeedbackMutationModel.w_();
                int u_ = gravityUnblacklistFeedbackMutationModel.u_();
                jsonGenerator.f();
                if (mutableFlatBuffer.g(u_, 0) != 0) {
                    jsonGenerator.a("client_mutation_id");
                    jsonGenerator.b(mutableFlatBuffer.c(u_, 0));
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(GravityUnblacklistFeedbackMutationModel.class, new Serializer());
            }
        }

        public GravityUnblacklistFeedbackMutationModel() {
            super(1);
        }

        @Nullable
        private String m3913a() {
            this.f3927d = super.a(this.f3927d, 0);
            return this.f3927d;
        }

        public final int jK_() {
            return 269449674;
        }

        public final GraphQLVisitableModel m3915a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            h();
            i();
            return this;
        }

        public final int m3914a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(m3913a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, b);
            i();
            return flatBufferBuilder.d();
        }
    }
}
