package com.facebook.friending.jewel.protocol;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbSerializerProvider;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.FragmentModelWithoutBridge;
import com.facebook.flatbuffers.ModelWithFlatBufferFormatHash;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.friending.jewel.protocol.SetFriendRequestsAudienceMutationParsers.SetFriendRequestsAudienceMutationParser;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
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

/* compiled from: filter_button_tapped */
public class SetFriendRequestsAudienceMutationModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -2642782)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: filter_button_tapped */
    public final class SetFriendRequestsAudienceMutationModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private String f13331d;

        /* compiled from: filter_button_tapped */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(SetFriendRequestsAudienceMutationModel.class, new Deserializer());
            }

            public Object m14981a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = SetFriendRequestsAudienceMutationParser.m14986a(jsonParser);
                Object setFriendRequestsAudienceMutationModel = new SetFriendRequestsAudienceMutationModel();
                ((BaseModel) setFriendRequestsAudienceMutationModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (setFriendRequestsAudienceMutationModel instanceof Postprocessable) {
                    return ((Postprocessable) setFriendRequestsAudienceMutationModel).a();
                }
                return setFriendRequestsAudienceMutationModel;
            }
        }

        /* compiled from: filter_button_tapped */
        public class Serializer extends JsonSerializer<SetFriendRequestsAudienceMutationModel> {
            public final void m14982a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                SetFriendRequestsAudienceMutationModel setFriendRequestsAudienceMutationModel = (SetFriendRequestsAudienceMutationModel) obj;
                if (setFriendRequestsAudienceMutationModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(setFriendRequestsAudienceMutationModel.m14984a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    setFriendRequestsAudienceMutationModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = setFriendRequestsAudienceMutationModel.w_();
                int u_ = setFriendRequestsAudienceMutationModel.u_();
                jsonGenerator.f();
                if (mutableFlatBuffer.g(u_, 0) != 0) {
                    jsonGenerator.a("client_mutation_id");
                    jsonGenerator.b(mutableFlatBuffer.c(u_, 0));
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(SetFriendRequestsAudienceMutationModel.class, new Serializer());
            }
        }

        public SetFriendRequestsAudienceMutationModel() {
            super(1);
        }

        @Nullable
        private String m14983a() {
            this.f13331d = super.a(this.f13331d, 0);
            return this.f13331d;
        }

        public final int jK_() {
            return -315387547;
        }

        public final GraphQLVisitableModel m14985a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            h();
            i();
            return this;
        }

        public final int m14984a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(m14983a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, b);
            i();
            return flatBufferBuilder.d();
        }
    }
}
