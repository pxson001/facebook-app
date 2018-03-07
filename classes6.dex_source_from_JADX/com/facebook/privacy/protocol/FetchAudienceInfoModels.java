package com.facebook.privacy.protocol;

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
import com.facebook.privacy.protocol.FetchAudienceInfoParsers.AudienceInfoFieldsForLoginParser;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.nio.ByteBuffer;

/* compiled from: sticker_source_object_id */
public class FetchAudienceInfoModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -1462331951)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: sticker_source_object_id */
    public final class AudienceInfoFieldsForLoginModel extends BaseModel implements GraphQLVisitableModel {
        private boolean f4135d;
        private boolean f4136e;

        /* compiled from: sticker_source_object_id */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(AudienceInfoFieldsForLoginModel.class, new Deserializer());
            }

            public Object m6035a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(AudienceInfoFieldsForLoginParser.m6045a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object audienceInfoFieldsForLoginModel = new AudienceInfoFieldsForLoginModel();
                ((BaseModel) audienceInfoFieldsForLoginModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (audienceInfoFieldsForLoginModel instanceof Postprocessable) {
                    return ((Postprocessable) audienceInfoFieldsForLoginModel).a();
                }
                return audienceInfoFieldsForLoginModel;
            }
        }

        /* compiled from: sticker_source_object_id */
        public class Serializer extends JsonSerializer<AudienceInfoFieldsForLoginModel> {
            public final void m6036a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                AudienceInfoFieldsForLoginModel audienceInfoFieldsForLoginModel = (AudienceInfoFieldsForLoginModel) obj;
                if (audienceInfoFieldsForLoginModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(audienceInfoFieldsForLoginModel.m6037a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    audienceInfoFieldsForLoginModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                AudienceInfoFieldsForLoginParser.m6046a(audienceInfoFieldsForLoginModel.w_(), audienceInfoFieldsForLoginModel.u_(), jsonGenerator);
            }

            static {
                FbSerializerProvider.a(AudienceInfoFieldsForLoginModel.class, new Serializer());
            }
        }

        public AudienceInfoFieldsForLoginModel() {
            super(2);
        }

        public final int jK_() {
            return -1563921166;
        }

        public final GraphQLVisitableModel m6038a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            h();
            i();
            return this;
        }

        public final int m6037a(FlatBufferBuilder flatBufferBuilder) {
            h();
            flatBufferBuilder.c(2);
            flatBufferBuilder.a(0, this.f4135d);
            flatBufferBuilder.a(1, this.f4136e);
            i();
            return flatBufferBuilder.d();
        }

        public final void m6039a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
            super.a(mutableFlatBuffer, i, obj);
            this.f4135d = mutableFlatBuffer.a(i, 0);
            this.f4136e = mutableFlatBuffer.a(i, 1);
        }
    }
}
