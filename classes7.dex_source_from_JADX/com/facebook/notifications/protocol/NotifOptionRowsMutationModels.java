package com.facebook.notifications.protocol;

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
import com.facebook.notifications.protocol.NotifOptionRowsMutationParsers.NotifOptionActionMutationParser;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.nio.ByteBuffer;
import javax.annotation.Nullable;

/* compiled from: native_modules */
public class NotifOptionRowsMutationModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -2642782)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: native_modules */
    public final class NotifOptionActionMutationModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private String f8559d;

        /* compiled from: native_modules */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(NotifOptionActionMutationModel.class, new Deserializer());
            }

            public Object m10380a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = NotifOptionActionMutationParser.m10385a(jsonParser);
                Object notifOptionActionMutationModel = new NotifOptionActionMutationModel();
                ((BaseModel) notifOptionActionMutationModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (notifOptionActionMutationModel instanceof Postprocessable) {
                    return ((Postprocessable) notifOptionActionMutationModel).a();
                }
                return notifOptionActionMutationModel;
            }
        }

        /* compiled from: native_modules */
        public class Serializer extends JsonSerializer<NotifOptionActionMutationModel> {
            public final void m10381a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                NotifOptionActionMutationModel notifOptionActionMutationModel = (NotifOptionActionMutationModel) obj;
                if (notifOptionActionMutationModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(notifOptionActionMutationModel.m10383a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    notifOptionActionMutationModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = notifOptionActionMutationModel.w_();
                int u_ = notifOptionActionMutationModel.u_();
                jsonGenerator.f();
                if (mutableFlatBuffer.g(u_, 0) != 0) {
                    jsonGenerator.a("client_mutation_id");
                    jsonGenerator.b(mutableFlatBuffer.c(u_, 0));
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(NotifOptionActionMutationModel.class, new Serializer());
            }
        }

        public NotifOptionActionMutationModel() {
            super(1);
        }

        @Nullable
        private String m10382a() {
            this.f8559d = super.a(this.f8559d, 0);
            return this.f8559d;
        }

        public final int jK_() {
            return -1270005166;
        }

        public final GraphQLVisitableModel m10384a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            h();
            i();
            return this;
        }

        public final int m10383a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(m10382a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, b);
            i();
            return flatBufferBuilder.d();
        }
    }
}
