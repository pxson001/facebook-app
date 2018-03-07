package com.facebook.timeline.refresher.protocol;

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
import com.facebook.timeline.refresher.protocol.ProfileRefresherSkipMutationParsers.ProfileRefresherStepSkipMutationParser;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.nio.ByteBuffer;
import javax.annotation.Nullable;

/* compiled from: unified_thread */
public class ProfileRefresherSkipMutationModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -2642782)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: unified_thread */
    public final class ProfileRefresherStepSkipMutationModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private String f1095d;

        /* compiled from: unified_thread */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(ProfileRefresherStepSkipMutationModel.class, new Deserializer());
            }

            public Object m1175a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = ProfileRefresherStepSkipMutationParser.m1180a(jsonParser);
                Object profileRefresherStepSkipMutationModel = new ProfileRefresherStepSkipMutationModel();
                ((BaseModel) profileRefresherStepSkipMutationModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (profileRefresherStepSkipMutationModel instanceof Postprocessable) {
                    return ((Postprocessable) profileRefresherStepSkipMutationModel).a();
                }
                return profileRefresherStepSkipMutationModel;
            }
        }

        /* compiled from: unified_thread */
        public class Serializer extends JsonSerializer<ProfileRefresherStepSkipMutationModel> {
            public final void m1176a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                ProfileRefresherStepSkipMutationModel profileRefresherStepSkipMutationModel = (ProfileRefresherStepSkipMutationModel) obj;
                if (profileRefresherStepSkipMutationModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(profileRefresherStepSkipMutationModel.m1178a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    profileRefresherStepSkipMutationModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = profileRefresherStepSkipMutationModel.w_();
                int u_ = profileRefresherStepSkipMutationModel.u_();
                jsonGenerator.f();
                if (mutableFlatBuffer.g(u_, 0) != 0) {
                    jsonGenerator.a("client_mutation_id");
                    jsonGenerator.b(mutableFlatBuffer.c(u_, 0));
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(ProfileRefresherStepSkipMutationModel.class, new Serializer());
            }
        }

        public ProfileRefresherStepSkipMutationModel() {
            super(1);
        }

        @Nullable
        private String m1177a() {
            this.f1095d = super.a(this.f1095d, 0);
            return this.f1095d;
        }

        public final int jK_() {
            return 698221230;
        }

        public final GraphQLVisitableModel m1179a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            h();
            i();
            return this;
        }

        public final int m1178a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(m1177a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, b);
            i();
            return flatBufferBuilder.d();
        }
    }
}
