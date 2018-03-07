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
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.facebook.notifications.protocol.FetchMessengerJewelCountsGraphQLParsers.FetchMessengerJewelCountsParser;
import com.facebook.notifications.protocol.FetchMessengerJewelCountsGraphQLParsers.FetchMessengerJewelCountsParser.MessageThreadsParser;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.nio.ByteBuffer;
import javax.annotation.Nullable;

/* compiled from: negative_component */
public class FetchMessengerJewelCountsGraphQLModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 2024137722)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: negative_component */
    public final class FetchMessengerJewelCountsModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private MessageThreadsModel f8440d;

        /* compiled from: negative_component */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(FetchMessengerJewelCountsModel.class, new Deserializer());
            }

            public Object m10016a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = FetchMessengerJewelCountsParser.m10030a(jsonParser);
                Object fetchMessengerJewelCountsModel = new FetchMessengerJewelCountsModel();
                ((BaseModel) fetchMessengerJewelCountsModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (fetchMessengerJewelCountsModel instanceof Postprocessable) {
                    return ((Postprocessable) fetchMessengerJewelCountsModel).a();
                }
                return fetchMessengerJewelCountsModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -321043073)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: negative_component */
        public final class MessageThreadsModel extends BaseModel implements GraphQLVisitableModel {
            private int f8438d;
            private int f8439e;

            /* compiled from: negative_component */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(MessageThreadsModel.class, new Deserializer());
                }

                public Object m10017a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(MessageThreadsParser.m10028a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object messageThreadsModel = new MessageThreadsModel();
                    ((BaseModel) messageThreadsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (messageThreadsModel instanceof Postprocessable) {
                        return ((Postprocessable) messageThreadsModel).a();
                    }
                    return messageThreadsModel;
                }
            }

            /* compiled from: negative_component */
            public class Serializer extends JsonSerializer<MessageThreadsModel> {
                public final void m10018a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    MessageThreadsModel messageThreadsModel = (MessageThreadsModel) obj;
                    if (messageThreadsModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(messageThreadsModel.m10020a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        messageThreadsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    MessageThreadsParser.m10029a(messageThreadsModel.w_(), messageThreadsModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(MessageThreadsModel.class, new Serializer());
                }
            }

            public MessageThreadsModel() {
                super(2);
            }

            public final int m10019a() {
                a(0, 0);
                return this.f8438d;
            }

            public final int m10023j() {
                a(0, 1);
                return this.f8439e;
            }

            public final int jK_() {
                return 1828653682;
            }

            public final GraphQLVisitableModel m10021a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m10020a(FlatBufferBuilder flatBufferBuilder) {
                h();
                flatBufferBuilder.c(2);
                flatBufferBuilder.a(0, this.f8438d, 0);
                flatBufferBuilder.a(1, this.f8439e, 0);
                i();
                return flatBufferBuilder.d();
            }

            public final void m10022a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                super.a(mutableFlatBuffer, i, obj);
                this.f8438d = mutableFlatBuffer.a(i, 0, 0);
                this.f8439e = mutableFlatBuffer.a(i, 1, 0);
            }
        }

        /* compiled from: negative_component */
        public class Serializer extends JsonSerializer<FetchMessengerJewelCountsModel> {
            public final void m10024a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                FetchMessengerJewelCountsModel fetchMessengerJewelCountsModel = (FetchMessengerJewelCountsModel) obj;
                if (fetchMessengerJewelCountsModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(fetchMessengerJewelCountsModel.m10025a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    fetchMessengerJewelCountsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = fetchMessengerJewelCountsModel.w_();
                int u_ = fetchMessengerJewelCountsModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("message_threads");
                    MessageThreadsParser.m10029a(mutableFlatBuffer, g, jsonGenerator);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(FetchMessengerJewelCountsModel.class, new Serializer());
            }
        }

        public FetchMessengerJewelCountsModel() {
            super(1);
        }

        @Nullable
        public final MessageThreadsModel m10027a() {
            this.f8440d = (MessageThreadsModel) super.a(this.f8440d, 0, MessageThreadsModel.class);
            return this.f8440d;
        }

        public final int jK_() {
            return -1732764110;
        }

        public final GraphQLVisitableModel m10026a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m10027a() != null) {
                MessageThreadsModel messageThreadsModel = (MessageThreadsModel) graphQLModelMutatingVisitor.b(m10027a());
                if (m10027a() != messageThreadsModel) {
                    graphQLVisitableModel = (FetchMessengerJewelCountsModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f8440d = messageThreadsModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m10025a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m10027a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }
}
