package com.facebook.work.auth.request.protocol;

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
import com.facebook.work.auth.request.protocol.FetchEmailParsers.FetchEmailQueryParser;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.nio.ByteBuffer;
import javax.annotation.Nullable;

/* compiled from: expiration_month */
public class FetchEmailModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 158417169)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: expiration_month */
    public final class FetchEmailQueryModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private String f13006d;

        /* compiled from: expiration_month */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(FetchEmailQueryModel.class, new Deserializer());
            }

            public Object m13043a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = FetchEmailQueryParser.m13048a(jsonParser);
                Object fetchEmailQueryModel = new FetchEmailQueryModel();
                ((BaseModel) fetchEmailQueryModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (fetchEmailQueryModel instanceof Postprocessable) {
                    return ((Postprocessable) fetchEmailQueryModel).a();
                }
                return fetchEmailQueryModel;
            }
        }

        /* compiled from: expiration_month */
        public class Serializer extends JsonSerializer<FetchEmailQueryModel> {
            public final void m13044a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                FetchEmailQueryModel fetchEmailQueryModel = (FetchEmailQueryModel) obj;
                if (fetchEmailQueryModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(fetchEmailQueryModel.m13046a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    fetchEmailQueryModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = fetchEmailQueryModel.w_();
                int u_ = fetchEmailQueryModel.u_();
                jsonGenerator.f();
                if (mutableFlatBuffer.g(u_, 0) != 0) {
                    jsonGenerator.a("primary_email");
                    jsonGenerator.b(mutableFlatBuffer.c(u_, 0));
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(FetchEmailQueryModel.class, new Serializer());
            }
        }

        public FetchEmailQueryModel() {
            super(1);
        }

        @Nullable
        private String m13045a() {
            this.f13006d = super.a(this.f13006d, 0);
            return this.f13006d;
        }

        public final int jK_() {
            return -1732764110;
        }

        public final GraphQLVisitableModel m13047a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            h();
            i();
            return this;
        }

        public final int m13046a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(m13045a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, b);
            i();
            return flatBufferBuilder.d();
        }
    }
}
