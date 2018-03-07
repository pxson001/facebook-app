package com.facebook.crowdsourcing.friendvote.graphql;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbSerializerProvider;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.crowdsourcing.friendvote.graphql.CrowdsourcingFriendVoteMutationsParsers.CrowdsourcingFriendVoteInviteParser;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.FragmentModelWithoutBridge;
import com.facebook.flatbuffers.ModelWithFlatBufferFormatHash;
import com.facebook.flatbuffers.MutableFlatBuffer;
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

/* compiled from: com.facebook.push.registration.ACTION_TOKEN_REQUEST_RETRY */
public class CrowdsourcingFriendVoteMutationsModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -2642782)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: com.facebook.push.registration.ACTION_TOKEN_REQUEST_RETRY */
    public final class CrowdsourcingFriendVoteInviteModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private String f17417d;

        /* compiled from: com.facebook.push.registration.ACTION_TOKEN_REQUEST_RETRY */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(CrowdsourcingFriendVoteInviteModel.class, new Deserializer());
            }

            public Object m21315a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = CrowdsourcingFriendVoteInviteParser.m21320a(jsonParser);
                Object crowdsourcingFriendVoteInviteModel = new CrowdsourcingFriendVoteInviteModel();
                ((BaseModel) crowdsourcingFriendVoteInviteModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (crowdsourcingFriendVoteInviteModel instanceof Postprocessable) {
                    return ((Postprocessable) crowdsourcingFriendVoteInviteModel).a();
                }
                return crowdsourcingFriendVoteInviteModel;
            }
        }

        /* compiled from: com.facebook.push.registration.ACTION_TOKEN_REQUEST_RETRY */
        public class Serializer extends JsonSerializer<CrowdsourcingFriendVoteInviteModel> {
            public final void m21316a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                CrowdsourcingFriendVoteInviteModel crowdsourcingFriendVoteInviteModel = (CrowdsourcingFriendVoteInviteModel) obj;
                if (crowdsourcingFriendVoteInviteModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(crowdsourcingFriendVoteInviteModel.m21318a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    crowdsourcingFriendVoteInviteModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = crowdsourcingFriendVoteInviteModel.w_();
                int u_ = crowdsourcingFriendVoteInviteModel.u_();
                jsonGenerator.f();
                if (mutableFlatBuffer.g(u_, 0) != 0) {
                    jsonGenerator.a("client_mutation_id");
                    jsonGenerator.b(mutableFlatBuffer.c(u_, 0));
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(CrowdsourcingFriendVoteInviteModel.class, new Serializer());
            }
        }

        public CrowdsourcingFriendVoteInviteModel() {
            super(1);
        }

        @Nullable
        private String m21317a() {
            this.f17417d = super.a(this.f17417d, 0);
            return this.f17417d;
        }

        public final int jK_() {
            return 717964183;
        }

        public final GraphQLVisitableModel m21319a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            h();
            i();
            return this;
        }

        public final int m21318a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(m21317a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, b);
            i();
            return flatBufferBuilder.d();
        }
    }
}
