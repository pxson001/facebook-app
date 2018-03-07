package com.facebook.crowdsourcing.protocol.graphql;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbSerializerProvider;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.crowdsourcing.protocol.graphql.CrowdsourcingFeatherMutationsParsers.CrowdsourcingFeatherOverlayShownMutationParser;
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

/* compiled from: tap_message_comment */
public class CrowdsourcingFeatherMutationsModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -2642782)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: tap_message_comment */
    public final class CrowdsourcingFeatherOverlayShownMutationModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private String f2308d;

        /* compiled from: tap_message_comment */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(CrowdsourcingFeatherOverlayShownMutationModel.class, new Deserializer());
            }

            public Object m2238a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = CrowdsourcingFeatherOverlayShownMutationParser.m2243a(jsonParser);
                Object crowdsourcingFeatherOverlayShownMutationModel = new CrowdsourcingFeatherOverlayShownMutationModel();
                ((BaseModel) crowdsourcingFeatherOverlayShownMutationModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (crowdsourcingFeatherOverlayShownMutationModel instanceof Postprocessable) {
                    return ((Postprocessable) crowdsourcingFeatherOverlayShownMutationModel).a();
                }
                return crowdsourcingFeatherOverlayShownMutationModel;
            }
        }

        /* compiled from: tap_message_comment */
        public class Serializer extends JsonSerializer<CrowdsourcingFeatherOverlayShownMutationModel> {
            public final void m2239a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                CrowdsourcingFeatherOverlayShownMutationModel crowdsourcingFeatherOverlayShownMutationModel = (CrowdsourcingFeatherOverlayShownMutationModel) obj;
                if (crowdsourcingFeatherOverlayShownMutationModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(crowdsourcingFeatherOverlayShownMutationModel.m2241a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    crowdsourcingFeatherOverlayShownMutationModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = crowdsourcingFeatherOverlayShownMutationModel.w_();
                int u_ = crowdsourcingFeatherOverlayShownMutationModel.u_();
                jsonGenerator.f();
                if (mutableFlatBuffer.g(u_, 0) != 0) {
                    jsonGenerator.a("client_mutation_id");
                    jsonGenerator.b(mutableFlatBuffer.c(u_, 0));
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(CrowdsourcingFeatherOverlayShownMutationModel.class, new Serializer());
            }
        }

        public CrowdsourcingFeatherOverlayShownMutationModel() {
            super(1);
        }

        @Nullable
        private String m2240a() {
            this.f2308d = super.a(this.f2308d, 0);
            return this.f2308d;
        }

        public final int jK_() {
            return 1790416553;
        }

        public final GraphQLVisitableModel m2242a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            h();
            i();
            return this;
        }

        public final int m2241a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(m2240a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, b);
            i();
            return flatBufferBuilder.d();
        }
    }
}
