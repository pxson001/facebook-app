package com.facebook.timeline.protocol;

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
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.facebook.timeline.protocol.ProfileNuxCancelMutationParsers.ProfileNuxCancelButtonMutationParser;
import com.facebook.timeline.protocol.ProfileNuxCancelMutationParsers.ProfileNuxStartMutationParser;
import com.facebook.timeline.protocol.ProfileNuxCancelMutationParsers.ProfileNuxViewMutationParser;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.nio.ByteBuffer;
import javax.annotation.Nullable;

/* compiled from: de3c80e2754c411064b8dc8c84eb9360 */
public class ProfileNuxCancelMutationModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -2642782)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: de3c80e2754c411064b8dc8c84eb9360 */
    public final class ProfileNuxCancelButtonMutationModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private String f17848d;

        /* compiled from: de3c80e2754c411064b8dc8c84eb9360 */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(ProfileNuxCancelButtonMutationModel.class, new Deserializer());
            }

            public Object m26278a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = ProfileNuxCancelButtonMutationParser.m26293a(jsonParser);
                Object profileNuxCancelButtonMutationModel = new ProfileNuxCancelButtonMutationModel();
                ((BaseModel) profileNuxCancelButtonMutationModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (profileNuxCancelButtonMutationModel instanceof Postprocessable) {
                    return ((Postprocessable) profileNuxCancelButtonMutationModel).a();
                }
                return profileNuxCancelButtonMutationModel;
            }
        }

        /* compiled from: de3c80e2754c411064b8dc8c84eb9360 */
        public class Serializer extends JsonSerializer<ProfileNuxCancelButtonMutationModel> {
            public final void m26279a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                ProfileNuxCancelButtonMutationModel profileNuxCancelButtonMutationModel = (ProfileNuxCancelButtonMutationModel) obj;
                if (profileNuxCancelButtonMutationModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(profileNuxCancelButtonMutationModel.m26281a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    profileNuxCancelButtonMutationModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = profileNuxCancelButtonMutationModel.w_();
                int u_ = profileNuxCancelButtonMutationModel.u_();
                jsonGenerator.f();
                if (mutableFlatBuffer.g(u_, 0) != 0) {
                    jsonGenerator.a("client_mutation_id");
                    jsonGenerator.b(mutableFlatBuffer.c(u_, 0));
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(ProfileNuxCancelButtonMutationModel.class, new Serializer());
            }
        }

        public ProfileNuxCancelButtonMutationModel() {
            super(1);
        }

        @Nullable
        private String m26280a() {
            this.f17848d = super.a(this.f17848d, 0);
            return this.f17848d;
        }

        public final int jK_() {
            return -1435374304;
        }

        public final GraphQLVisitableModel m26282a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            h();
            i();
            return this;
        }

        public final int m26281a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(m26280a());
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
    /* compiled from: de3c80e2754c411064b8dc8c84eb9360 */
    public final class ProfileNuxStartMutationModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private String f17849d;

        /* compiled from: de3c80e2754c411064b8dc8c84eb9360 */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(ProfileNuxStartMutationModel.class, new Deserializer());
            }

            public Object m26283a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = ProfileNuxStartMutationParser.m26294a(jsonParser);
                Object profileNuxStartMutationModel = new ProfileNuxStartMutationModel();
                ((BaseModel) profileNuxStartMutationModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (profileNuxStartMutationModel instanceof Postprocessable) {
                    return ((Postprocessable) profileNuxStartMutationModel).a();
                }
                return profileNuxStartMutationModel;
            }
        }

        /* compiled from: de3c80e2754c411064b8dc8c84eb9360 */
        public class Serializer extends JsonSerializer<ProfileNuxStartMutationModel> {
            public final void m26284a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                ProfileNuxStartMutationModel profileNuxStartMutationModel = (ProfileNuxStartMutationModel) obj;
                if (profileNuxStartMutationModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(profileNuxStartMutationModel.m26286a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    profileNuxStartMutationModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = profileNuxStartMutationModel.w_();
                int u_ = profileNuxStartMutationModel.u_();
                jsonGenerator.f();
                if (mutableFlatBuffer.g(u_, 0) != 0) {
                    jsonGenerator.a("client_mutation_id");
                    jsonGenerator.b(mutableFlatBuffer.c(u_, 0));
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(ProfileNuxStartMutationModel.class, new Serializer());
            }
        }

        public ProfileNuxStartMutationModel() {
            super(1);
        }

        @Nullable
        private String m26285a() {
            this.f17849d = super.a(this.f17849d, 0);
            return this.f17849d;
        }

        public final int jK_() {
            return 2008583048;
        }

        public final GraphQLVisitableModel m26287a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            h();
            i();
            return this;
        }

        public final int m26286a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(m26285a());
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
    /* compiled from: de3c80e2754c411064b8dc8c84eb9360 */
    public final class ProfileNuxViewMutationModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private String f17850d;

        /* compiled from: de3c80e2754c411064b8dc8c84eb9360 */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(ProfileNuxViewMutationModel.class, new Deserializer());
            }

            public Object m26288a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = ProfileNuxViewMutationParser.m26295a(jsonParser);
                Object profileNuxViewMutationModel = new ProfileNuxViewMutationModel();
                ((BaseModel) profileNuxViewMutationModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (profileNuxViewMutationModel instanceof Postprocessable) {
                    return ((Postprocessable) profileNuxViewMutationModel).a();
                }
                return profileNuxViewMutationModel;
            }
        }

        /* compiled from: de3c80e2754c411064b8dc8c84eb9360 */
        public class Serializer extends JsonSerializer<ProfileNuxViewMutationModel> {
            public final void m26289a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                ProfileNuxViewMutationModel profileNuxViewMutationModel = (ProfileNuxViewMutationModel) obj;
                if (profileNuxViewMutationModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(profileNuxViewMutationModel.m26291a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    profileNuxViewMutationModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = profileNuxViewMutationModel.w_();
                int u_ = profileNuxViewMutationModel.u_();
                jsonGenerator.f();
                if (mutableFlatBuffer.g(u_, 0) != 0) {
                    jsonGenerator.a("client_mutation_id");
                    jsonGenerator.b(mutableFlatBuffer.c(u_, 0));
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(ProfileNuxViewMutationModel.class, new Serializer());
            }
        }

        public ProfileNuxViewMutationModel() {
            super(1);
        }

        @Nullable
        private String m26290a() {
            this.f17850d = super.a(this.f17850d, 0);
            return this.f17850d;
        }

        public final int jK_() {
            return 1310551755;
        }

        public final GraphQLVisitableModel m26292a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            h();
            i();
            return this;
        }

        public final int m26291a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(m26290a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, b);
            i();
            return flatBufferBuilder.d();
        }
    }
}
