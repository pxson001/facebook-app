package com.facebook.messaging.momentsinvite.graphql;

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
import com.facebook.messaging.momentsinvite.graphql.MomentsInviteActionPostbackMutationParsers.MomentsInviteActionPostbackMutationParser;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.nio.ByteBuffer;
import javax.annotation.Nullable;

/* compiled from: item_user */
public class MomentsInviteActionPostbackMutationModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -2642782)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: item_user */
    public final class MomentsInviteActionPostbackMutationModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private String f12294d;

        /* compiled from: item_user */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(MomentsInviteActionPostbackMutationModel.class, new Deserializer());
            }

            public Object m12756a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = MomentsInviteActionPostbackMutationParser.m12761a(jsonParser);
                Object momentsInviteActionPostbackMutationModel = new MomentsInviteActionPostbackMutationModel();
                ((BaseModel) momentsInviteActionPostbackMutationModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (momentsInviteActionPostbackMutationModel instanceof Postprocessable) {
                    return ((Postprocessable) momentsInviteActionPostbackMutationModel).a();
                }
                return momentsInviteActionPostbackMutationModel;
            }
        }

        /* compiled from: item_user */
        public class Serializer extends JsonSerializer<MomentsInviteActionPostbackMutationModel> {
            public final void m12757a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                MomentsInviteActionPostbackMutationModel momentsInviteActionPostbackMutationModel = (MomentsInviteActionPostbackMutationModel) obj;
                if (momentsInviteActionPostbackMutationModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(momentsInviteActionPostbackMutationModel.m12759a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    momentsInviteActionPostbackMutationModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = momentsInviteActionPostbackMutationModel.w_();
                int u_ = momentsInviteActionPostbackMutationModel.u_();
                jsonGenerator.f();
                if (mutableFlatBuffer.g(u_, 0) != 0) {
                    jsonGenerator.a("client_mutation_id");
                    jsonGenerator.b(mutableFlatBuffer.c(u_, 0));
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(MomentsInviteActionPostbackMutationModel.class, new Serializer());
            }
        }

        public MomentsInviteActionPostbackMutationModel() {
            super(1);
        }

        @Nullable
        private String m12758a() {
            this.f12294d = super.a(this.f12294d, 0);
            return this.f12294d;
        }

        public final int jK_() {
            return 383299113;
        }

        public final GraphQLVisitableModel m12760a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            h();
            i();
            return this;
        }

        public final int m12759a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(m12758a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, b);
            i();
            return flatBufferBuilder.d();
        }
    }
}
