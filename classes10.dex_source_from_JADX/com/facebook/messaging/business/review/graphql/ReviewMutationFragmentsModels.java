package com.facebook.messaging.business.review.graphql;

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
import com.facebook.messaging.business.review.graphql.ReviewMutationFragmentsParsers.MessengerPlatformBotReviewMutationParser;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.nio.ByteBuffer;
import javax.annotation.Nullable;

/* compiled from: threadSummary */
public class ReviewMutationFragmentsModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -2642782)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: threadSummary */
    public final class MessengerPlatformBotReviewMutationModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private String f1658d;

        /* compiled from: threadSummary */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(MessengerPlatformBotReviewMutationModel.class, new Deserializer());
            }

            public Object m1605a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = MessengerPlatformBotReviewMutationParser.m1610a(jsonParser);
                Object messengerPlatformBotReviewMutationModel = new MessengerPlatformBotReviewMutationModel();
                ((BaseModel) messengerPlatformBotReviewMutationModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (messengerPlatformBotReviewMutationModel instanceof Postprocessable) {
                    return ((Postprocessable) messengerPlatformBotReviewMutationModel).a();
                }
                return messengerPlatformBotReviewMutationModel;
            }
        }

        /* compiled from: threadSummary */
        public class Serializer extends JsonSerializer<MessengerPlatformBotReviewMutationModel> {
            public final void m1606a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                MessengerPlatformBotReviewMutationModel messengerPlatformBotReviewMutationModel = (MessengerPlatformBotReviewMutationModel) obj;
                if (messengerPlatformBotReviewMutationModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(messengerPlatformBotReviewMutationModel.m1608a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    messengerPlatformBotReviewMutationModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = messengerPlatformBotReviewMutationModel.w_();
                int u_ = messengerPlatformBotReviewMutationModel.u_();
                jsonGenerator.f();
                if (mutableFlatBuffer.g(u_, 0) != 0) {
                    jsonGenerator.a("client_mutation_id");
                    jsonGenerator.b(mutableFlatBuffer.c(u_, 0));
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(MessengerPlatformBotReviewMutationModel.class, new Serializer());
            }
        }

        public MessengerPlatformBotReviewMutationModel() {
            super(1);
        }

        @Nullable
        private String m1607a() {
            this.f1658d = super.a(this.f1658d, 0);
            return this.f1658d;
        }

        public final int jK_() {
            return 2518885;
        }

        public final GraphQLVisitableModel m1609a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            h();
            i();
            return this;
        }

        public final int m1608a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(m1607a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, b);
            i();
            return flatBufferBuilder.d();
        }
    }
}
