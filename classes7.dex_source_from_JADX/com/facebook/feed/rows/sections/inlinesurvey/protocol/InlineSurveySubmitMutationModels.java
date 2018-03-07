package com.facebook.feed.rows.sections.inlinesurvey.protocol;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbSerializerProvider;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.feed.rows.sections.inlinesurvey.protocol.InlineSurveySubmitMutationParsers.InlineSurveySubmitMutationFieldsParser;
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

/* compiled from: UTF-16LE */
public class InlineSurveySubmitMutationModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 203186466)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: UTF-16LE */
    public final class InlineSurveySubmitMutationFieldsModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private String f21528d;

        /* compiled from: UTF-16LE */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(InlineSurveySubmitMutationFieldsModel.class, new Deserializer());
            }

            public Object m24159a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = InlineSurveySubmitMutationFieldsParser.m24164a(jsonParser);
                Object inlineSurveySubmitMutationFieldsModel = new InlineSurveySubmitMutationFieldsModel();
                ((BaseModel) inlineSurveySubmitMutationFieldsModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (inlineSurveySubmitMutationFieldsModel instanceof Postprocessable) {
                    return ((Postprocessable) inlineSurveySubmitMutationFieldsModel).a();
                }
                return inlineSurveySubmitMutationFieldsModel;
            }
        }

        /* compiled from: UTF-16LE */
        public class Serializer extends JsonSerializer<InlineSurveySubmitMutationFieldsModel> {
            public final void m24160a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                InlineSurveySubmitMutationFieldsModel inlineSurveySubmitMutationFieldsModel = (InlineSurveySubmitMutationFieldsModel) obj;
                if (inlineSurveySubmitMutationFieldsModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(inlineSurveySubmitMutationFieldsModel.m24162a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    inlineSurveySubmitMutationFieldsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = inlineSurveySubmitMutationFieldsModel.w_();
                int u_ = inlineSurveySubmitMutationFieldsModel.u_();
                jsonGenerator.f();
                if (mutableFlatBuffer.g(u_, 0) != 0) {
                    jsonGenerator.a("event");
                    jsonGenerator.b(mutableFlatBuffer.c(u_, 0));
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(InlineSurveySubmitMutationFieldsModel.class, new Serializer());
            }
        }

        public InlineSurveySubmitMutationFieldsModel() {
            super(1);
        }

        @Nullable
        private String m24161a() {
            this.f21528d = super.a(this.f21528d, 0);
            return this.f21528d;
        }

        public final int jK_() {
            return -162062046;
        }

        public final GraphQLVisitableModel m24163a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            h();
            i();
            return this;
        }

        public final int m24162a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(m24161a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, b);
            i();
            return flatBufferBuilder.d();
        }
    }
}
