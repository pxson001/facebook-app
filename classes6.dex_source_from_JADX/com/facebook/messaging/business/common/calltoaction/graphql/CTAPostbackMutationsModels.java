package com.facebook.messaging.business.common.calltoaction.graphql;

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
import com.facebook.messaging.business.common.calltoaction.graphql.CTAPostbackMutationsParsers.CTAPostbackMutationParser;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.nio.ByteBuffer;
import javax.annotation.Nullable;

/* compiled from: video_product_type */
public class CTAPostbackMutationsModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -2642782)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: video_product_type */
    public final class CTAPostbackMutationModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private String f709d;

        /* compiled from: video_product_type */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(CTAPostbackMutationModel.class, new Deserializer());
            }

            public Object m716a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = CTAPostbackMutationParser.m721a(jsonParser);
                Object cTAPostbackMutationModel = new CTAPostbackMutationModel();
                ((BaseModel) cTAPostbackMutationModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (cTAPostbackMutationModel instanceof Postprocessable) {
                    return ((Postprocessable) cTAPostbackMutationModel).a();
                }
                return cTAPostbackMutationModel;
            }
        }

        /* compiled from: video_product_type */
        public class Serializer extends JsonSerializer<CTAPostbackMutationModel> {
            public final void m717a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                CTAPostbackMutationModel cTAPostbackMutationModel = (CTAPostbackMutationModel) obj;
                if (cTAPostbackMutationModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(cTAPostbackMutationModel.m719a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    cTAPostbackMutationModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = cTAPostbackMutationModel.w_();
                int u_ = cTAPostbackMutationModel.u_();
                jsonGenerator.f();
                if (mutableFlatBuffer.g(u_, 0) != 0) {
                    jsonGenerator.a("client_mutation_id");
                    jsonGenerator.b(mutableFlatBuffer.c(u_, 0));
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(CTAPostbackMutationModel.class, new Serializer());
            }
        }

        public CTAPostbackMutationModel() {
            super(1);
        }

        @Nullable
        private String m718a() {
            this.f709d = super.a(this.f709d, 0);
            return this.f709d;
        }

        public final int jK_() {
            return 1087736708;
        }

        public final GraphQLVisitableModel m720a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            h();
            i();
            return this;
        }

        public final int m719a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(m718a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, b);
            i();
            return flatBufferBuilder.d();
        }
    }
}
