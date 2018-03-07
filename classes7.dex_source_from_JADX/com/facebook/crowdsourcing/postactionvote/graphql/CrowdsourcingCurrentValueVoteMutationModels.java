package com.facebook.crowdsourcing.postactionvote.graphql;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbSerializerProvider;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.crowdsourcing.postactionvote.graphql.CrowdsourcingCurrentValueVoteMutationParsers.CrowdsourcingCurrentValueVoteMutationParser;
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

/* compiled from: com.facebook.contacts.CONTACTS_UPLOAD_DONE */
public class CrowdsourcingCurrentValueVoteMutationModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -2642782)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: com.facebook.contacts.CONTACTS_UPLOAD_DONE */
    public final class CrowdsourcingCurrentValueVoteMutationModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private String f17584d;

        /* compiled from: com.facebook.contacts.CONTACTS_UPLOAD_DONE */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(CrowdsourcingCurrentValueVoteMutationModel.class, new Deserializer());
            }

            public Object m21450a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = CrowdsourcingCurrentValueVoteMutationParser.m21455a(jsonParser);
                Object crowdsourcingCurrentValueVoteMutationModel = new CrowdsourcingCurrentValueVoteMutationModel();
                ((BaseModel) crowdsourcingCurrentValueVoteMutationModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (crowdsourcingCurrentValueVoteMutationModel instanceof Postprocessable) {
                    return ((Postprocessable) crowdsourcingCurrentValueVoteMutationModel).a();
                }
                return crowdsourcingCurrentValueVoteMutationModel;
            }
        }

        /* compiled from: com.facebook.contacts.CONTACTS_UPLOAD_DONE */
        public class Serializer extends JsonSerializer<CrowdsourcingCurrentValueVoteMutationModel> {
            public final void m21451a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                CrowdsourcingCurrentValueVoteMutationModel crowdsourcingCurrentValueVoteMutationModel = (CrowdsourcingCurrentValueVoteMutationModel) obj;
                if (crowdsourcingCurrentValueVoteMutationModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(crowdsourcingCurrentValueVoteMutationModel.m21453a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    crowdsourcingCurrentValueVoteMutationModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = crowdsourcingCurrentValueVoteMutationModel.w_();
                int u_ = crowdsourcingCurrentValueVoteMutationModel.u_();
                jsonGenerator.f();
                if (mutableFlatBuffer.g(u_, 0) != 0) {
                    jsonGenerator.a("client_mutation_id");
                    jsonGenerator.b(mutableFlatBuffer.c(u_, 0));
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(CrowdsourcingCurrentValueVoteMutationModel.class, new Serializer());
            }
        }

        public CrowdsourcingCurrentValueVoteMutationModel() {
            super(1);
        }

        @Nullable
        private String m21452a() {
            this.f17584d = super.a(this.f17584d, 0);
            return this.f17584d;
        }

        public final int jK_() {
            return -1537505082;
        }

        public final GraphQLVisitableModel m21454a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            h();
            i();
            return this;
        }

        public final int m21453a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(m21452a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, b);
            i();
            return flatBufferBuilder.d();
        }
    }
}
