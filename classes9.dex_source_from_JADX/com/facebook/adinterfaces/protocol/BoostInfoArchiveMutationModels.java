package com.facebook.adinterfaces.protocol;

import com.facebook.adinterfaces.protocol.BoostInfoArchiveMutationParsers.BoostInfoArchiveMutationFieldsParser;
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

/* compiled from: YT */
public class BoostInfoArchiveMutationModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -2642782)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: YT */
    public final class BoostInfoArchiveMutationFieldsModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private String f22277d;

        /* compiled from: YT */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(BoostInfoArchiveMutationFieldsModel.class, new Deserializer());
            }

            public Object m23956a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = BoostInfoArchiveMutationFieldsParser.m23961a(jsonParser);
                Object boostInfoArchiveMutationFieldsModel = new BoostInfoArchiveMutationFieldsModel();
                ((BaseModel) boostInfoArchiveMutationFieldsModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (boostInfoArchiveMutationFieldsModel instanceof Postprocessable) {
                    return ((Postprocessable) boostInfoArchiveMutationFieldsModel).a();
                }
                return boostInfoArchiveMutationFieldsModel;
            }
        }

        /* compiled from: YT */
        public class Serializer extends JsonSerializer<BoostInfoArchiveMutationFieldsModel> {
            public final void m23957a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                BoostInfoArchiveMutationFieldsModel boostInfoArchiveMutationFieldsModel = (BoostInfoArchiveMutationFieldsModel) obj;
                if (boostInfoArchiveMutationFieldsModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(boostInfoArchiveMutationFieldsModel.m23959a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    boostInfoArchiveMutationFieldsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = boostInfoArchiveMutationFieldsModel.w_();
                int u_ = boostInfoArchiveMutationFieldsModel.u_();
                jsonGenerator.f();
                if (mutableFlatBuffer.g(u_, 0) != 0) {
                    jsonGenerator.a("client_mutation_id");
                    jsonGenerator.b(mutableFlatBuffer.c(u_, 0));
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(BoostInfoArchiveMutationFieldsModel.class, new Serializer());
            }
        }

        public BoostInfoArchiveMutationFieldsModel() {
            super(1);
        }

        @Nullable
        private String m23958a() {
            this.f22277d = super.a(this.f22277d, 0);
            return this.f22277d;
        }

        public final int jK_() {
            return 294527260;
        }

        public final GraphQLVisitableModel m23960a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            h();
            i();
            return this;
        }

        public final int m23959a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(m23958a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, b);
            i();
            return flatBufferBuilder.d();
        }
    }
}
