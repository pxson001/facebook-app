package com.facebook.messaging.sync.connection.graphql;

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
import com.facebook.messaging.sync.connection.graphql.InitialThreadListDataQueryParsers.InitialThreadListDataQueryParser;
import com.facebook.messaging.sync.connection.graphql.InitialThreadListDataQueryParsers.InitialThreadListDataQueryParser.MessageThreadsParser;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.nio.ByteBuffer;
import javax.annotation.Nullable;

/* compiled from: profile_tile_views */
public class InitialThreadListDataQueryModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -680292813)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: profile_tile_views */
    public final class InitialThreadListDataQueryModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private MessageThreadsModel f4347d;

        /* compiled from: profile_tile_views */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(InitialThreadListDataQueryModel.class, new Deserializer());
            }

            public Object m3946a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = InitialThreadListDataQueryParser.m3960a(jsonParser);
                Object initialThreadListDataQueryModel = new InitialThreadListDataQueryModel();
                ((BaseModel) initialThreadListDataQueryModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (initialThreadListDataQueryModel instanceof Postprocessable) {
                    return ((Postprocessable) initialThreadListDataQueryModel).a();
                }
                return initialThreadListDataQueryModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -429591654)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: profile_tile_views */
        public final class MessageThreadsModel extends BaseModel implements GraphQLVisitableModel {
            private int f4345d;
            @Nullable
            private String f4346e;

            /* compiled from: profile_tile_views */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(MessageThreadsModel.class, new Deserializer());
                }

                public Object m3947a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(MessageThreadsParser.m3958a(jsonParser, flatBufferBuilder));
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

            /* compiled from: profile_tile_views */
            public class Serializer extends JsonSerializer<MessageThreadsModel> {
                public final void m3948a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    MessageThreadsModel messageThreadsModel = (MessageThreadsModel) obj;
                    if (messageThreadsModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(messageThreadsModel.m3950a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        messageThreadsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    MessageThreadsParser.m3959a(messageThreadsModel.w_(), messageThreadsModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(MessageThreadsModel.class, new Serializer());
                }
            }

            public MessageThreadsModel() {
                super(2);
            }

            public final int m3949a() {
                a(0, 0);
                return this.f4345d;
            }

            @Nullable
            public final String m3953b() {
                this.f4346e = super.a(this.f4346e, 1);
                return this.f4346e;
            }

            public final int jK_() {
                return 1828653682;
            }

            public final GraphQLVisitableModel m3951a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m3950a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m3953b());
                flatBufferBuilder.c(2);
                flatBufferBuilder.a(0, this.f4345d, 0);
                flatBufferBuilder.b(1, b);
                i();
                return flatBufferBuilder.d();
            }

            public final void m3952a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                super.a(mutableFlatBuffer, i, obj);
                this.f4345d = mutableFlatBuffer.a(i, 0, 0);
            }
        }

        /* compiled from: profile_tile_views */
        public class Serializer extends JsonSerializer<InitialThreadListDataQueryModel> {
            public final void m3954a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                InitialThreadListDataQueryModel initialThreadListDataQueryModel = (InitialThreadListDataQueryModel) obj;
                if (initialThreadListDataQueryModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(initialThreadListDataQueryModel.m3955a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    initialThreadListDataQueryModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = initialThreadListDataQueryModel.w_();
                int u_ = initialThreadListDataQueryModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("message_threads");
                    MessageThreadsParser.m3959a(mutableFlatBuffer, g, jsonGenerator);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(InitialThreadListDataQueryModel.class, new Serializer());
            }
        }

        public InitialThreadListDataQueryModel() {
            super(1);
        }

        @Nullable
        public final MessageThreadsModel m3957a() {
            this.f4347d = (MessageThreadsModel) super.a(this.f4347d, 0, MessageThreadsModel.class);
            return this.f4347d;
        }

        public final int jK_() {
            return -1732764110;
        }

        public final GraphQLVisitableModel m3956a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m3957a() != null) {
                MessageThreadsModel messageThreadsModel = (MessageThreadsModel) graphQLModelMutatingVisitor.b(m3957a());
                if (m3957a() != messageThreadsModel) {
                    graphQLVisitableModel = (InitialThreadListDataQueryModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f4347d = messageThreadsModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m3955a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m3957a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }
}
