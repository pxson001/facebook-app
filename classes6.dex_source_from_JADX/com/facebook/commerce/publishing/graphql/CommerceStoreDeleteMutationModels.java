package com.facebook.commerce.publishing.graphql;

import com.facebook.commerce.publishing.graphql.CommerceStoreDeleteMutationParsers.CommerceStoreDeleteMutationParser;
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
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.nio.ByteBuffer;
import javax.annotation.Nullable;

/* compiled from: post-slideshow-video */
public class CommerceStoreDeleteMutationModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -2642782)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: post-slideshow-video */
    public final class CommerceStoreDeleteMutationModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private String f7633d;

        /* compiled from: post-slideshow-video */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(CommerceStoreDeleteMutationModel.class, new Deserializer());
            }

            public Object m10833a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = CommerceStoreDeleteMutationParser.m10838a(jsonParser);
                Object commerceStoreDeleteMutationModel = new CommerceStoreDeleteMutationModel();
                ((BaseModel) commerceStoreDeleteMutationModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (commerceStoreDeleteMutationModel instanceof Postprocessable) {
                    return ((Postprocessable) commerceStoreDeleteMutationModel).a();
                }
                return commerceStoreDeleteMutationModel;
            }
        }

        /* compiled from: post-slideshow-video */
        public class Serializer extends JsonSerializer<CommerceStoreDeleteMutationModel> {
            public final void m10834a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                CommerceStoreDeleteMutationModel commerceStoreDeleteMutationModel = (CommerceStoreDeleteMutationModel) obj;
                if (commerceStoreDeleteMutationModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(commerceStoreDeleteMutationModel.m10836a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    commerceStoreDeleteMutationModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = commerceStoreDeleteMutationModel.w_();
                int u_ = commerceStoreDeleteMutationModel.u_();
                jsonGenerator.f();
                if (mutableFlatBuffer.g(u_, 0) != 0) {
                    jsonGenerator.a("client_mutation_id");
                    jsonGenerator.b(mutableFlatBuffer.c(u_, 0));
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(CommerceStoreDeleteMutationModel.class, new Serializer());
            }
        }

        public CommerceStoreDeleteMutationModel() {
            super(1);
        }

        @Nullable
        private String m10835a() {
            this.f7633d = super.a(this.f7633d, 0);
            return this.f7633d;
        }

        public final int jK_() {
            return -1753244074;
        }

        public final GraphQLVisitableModel m10837a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            h();
            i();
            return this;
        }

        public final int m10836a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(m10835a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, b);
            i();
            return flatBufferBuilder.d();
        }
    }
}
