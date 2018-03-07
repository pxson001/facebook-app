package com.facebook.messaging.blocking.graphql;

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
import com.facebook.messaging.blocking.graphql.BlockingMutationsParsers.MessengerCommerceUserControlActionParser;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.nio.ByteBuffer;
import javax.annotation.Nullable;

/* compiled from: onActivityResult */
public class BlockingMutationsModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -2642782)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: onActivityResult */
    public final class MessengerCommerceUserControlActionModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private String f8309d;

        /* compiled from: onActivityResult */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(MessengerCommerceUserControlActionModel.class, new Deserializer());
            }

            public Object m8562a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = MessengerCommerceUserControlActionParser.m8567a(jsonParser);
                Object messengerCommerceUserControlActionModel = new MessengerCommerceUserControlActionModel();
                ((BaseModel) messengerCommerceUserControlActionModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (messengerCommerceUserControlActionModel instanceof Postprocessable) {
                    return ((Postprocessable) messengerCommerceUserControlActionModel).a();
                }
                return messengerCommerceUserControlActionModel;
            }
        }

        /* compiled from: onActivityResult */
        public class Serializer extends JsonSerializer<MessengerCommerceUserControlActionModel> {
            public final void m8563a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                MessengerCommerceUserControlActionModel messengerCommerceUserControlActionModel = (MessengerCommerceUserControlActionModel) obj;
                if (messengerCommerceUserControlActionModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(messengerCommerceUserControlActionModel.m8565a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    messengerCommerceUserControlActionModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = messengerCommerceUserControlActionModel.w_();
                int u_ = messengerCommerceUserControlActionModel.u_();
                jsonGenerator.f();
                if (mutableFlatBuffer.g(u_, 0) != 0) {
                    jsonGenerator.a("client_mutation_id");
                    jsonGenerator.b(mutableFlatBuffer.c(u_, 0));
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(MessengerCommerceUserControlActionModel.class, new Serializer());
            }
        }

        public MessengerCommerceUserControlActionModel() {
            super(1);
        }

        @Nullable
        private String m8564a() {
            this.f8309d = super.a(this.f8309d, 0);
            return this.f8309d;
        }

        public final int jK_() {
            return 873491475;
        }

        public final GraphQLVisitableModel m8566a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            h();
            i();
            return this;
        }

        public final int m8565a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(m8564a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, b);
            i();
            return flatBufferBuilder.d();
        }
    }
}
