package com.facebook.messaging.messagerequests.snippet.graphql;

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
import com.facebook.messaging.messagerequests.snippet.graphql.MessageRequestsSnippetQueryParsers.MessageRequestsSnippetParser;
import com.facebook.messaging.messagerequests.snippet.graphql.MessageRequestsSnippetQueryParsers.MessageRequestsSnippetParser.PendingCountParser;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.nio.ByteBuffer;
import javax.annotation.Nullable;

/* compiled from: saved dashboard */
public class MessageRequestsSnippetQueryModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -2001540121)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: saved dashboard */
    public final class MessageRequestsSnippetModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private PendingCountModel f3273d;

        /* compiled from: saved dashboard */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(MessageRequestsSnippetModel.class, new Deserializer());
            }

            public Object m3184a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = MessageRequestsSnippetParser.m3198a(jsonParser);
                Object messageRequestsSnippetModel = new MessageRequestsSnippetModel();
                ((BaseModel) messageRequestsSnippetModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (messageRequestsSnippetModel instanceof Postprocessable) {
                    return ((Postprocessable) messageRequestsSnippetModel).a();
                }
                return messageRequestsSnippetModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 1437356698)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: saved dashboard */
        public final class PendingCountModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private String f3271d;
            private int f3272e;

            /* compiled from: saved dashboard */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(PendingCountModel.class, new Deserializer());
                }

                public Object m3185a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(PendingCountParser.m3196a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object pendingCountModel = new PendingCountModel();
                    ((BaseModel) pendingCountModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (pendingCountModel instanceof Postprocessable) {
                        return ((Postprocessable) pendingCountModel).a();
                    }
                    return pendingCountModel;
                }
            }

            /* compiled from: saved dashboard */
            public class Serializer extends JsonSerializer<PendingCountModel> {
                public final void m3186a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    PendingCountModel pendingCountModel = (PendingCountModel) obj;
                    if (pendingCountModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(pendingCountModel.m3187a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        pendingCountModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    PendingCountParser.m3197a(pendingCountModel.w_(), pendingCountModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(PendingCountModel.class, new Serializer());
                }
            }

            public PendingCountModel() {
                super(2);
            }

            @Nullable
            public final String m3189a() {
                this.f3271d = super.a(this.f3271d, 0);
                return this.f3271d;
            }

            public final int m3191j() {
                a(0, 1);
                return this.f3272e;
            }

            public final int jK_() {
                return 1828653682;
            }

            public final GraphQLVisitableModel m3188a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m3187a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m3189a());
                flatBufferBuilder.c(2);
                flatBufferBuilder.b(0, b);
                flatBufferBuilder.a(1, this.f3272e, 0);
                i();
                return flatBufferBuilder.d();
            }

            public final void m3190a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                super.a(mutableFlatBuffer, i, obj);
                this.f3272e = mutableFlatBuffer.a(i, 1, 0);
            }
        }

        /* compiled from: saved dashboard */
        public class Serializer extends JsonSerializer<MessageRequestsSnippetModel> {
            public final void m3192a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                MessageRequestsSnippetModel messageRequestsSnippetModel = (MessageRequestsSnippetModel) obj;
                if (messageRequestsSnippetModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(messageRequestsSnippetModel.m3193a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    messageRequestsSnippetModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = messageRequestsSnippetModel.w_();
                int u_ = messageRequestsSnippetModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("pending_count");
                    PendingCountParser.m3197a(mutableFlatBuffer, g, jsonGenerator);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(MessageRequestsSnippetModel.class, new Serializer());
            }
        }

        public MessageRequestsSnippetModel() {
            super(1);
        }

        @Nullable
        public final PendingCountModel m3195a() {
            this.f3273d = (PendingCountModel) super.a(this.f3273d, 0, PendingCountModel.class);
            return this.f3273d;
        }

        public final int jK_() {
            return -1732764110;
        }

        public final GraphQLVisitableModel m3194a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m3195a() != null) {
                PendingCountModel pendingCountModel = (PendingCountModel) graphQLModelMutatingVisitor.b(m3195a());
                if (m3195a() != pendingCountModel) {
                    graphQLVisitableModel = (MessageRequestsSnippetModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f3273d = pendingCountModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m3193a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m3195a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }
}
