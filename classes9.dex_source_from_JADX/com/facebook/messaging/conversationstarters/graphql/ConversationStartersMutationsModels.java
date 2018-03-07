package com.facebook.messaging.conversationstarters.graphql;

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
import com.facebook.graphql.visitor.ConsistencyTuple;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLPersistableNode;
import com.facebook.graphql.visitor.GraphQLVisitableConsistentModel;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.facebook.messaging.conversationstarters.graphql.ConversationStartersMutationsParsers.ConversationStarterCoreMutationParser;
import com.facebook.messaging.conversationstarters.graphql.ConversationStartersMutationsParsers.ConversationStarterCoreMutationParser.MessengerConversationStarterItemParser;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.nio.ByteBuffer;
import javax.annotation.Nullable;

/* compiled from: mentions_search */
public class ConversationStartersMutationsModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 200820914)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: mentions_search */
    public final class ConversationStarterCoreMutationModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private MessengerConversationStarterItemModel f10216d;

        /* compiled from: mentions_search */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(ConversationStarterCoreMutationModel.class, new Deserializer());
            }

            public Object m10761a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = ConversationStarterCoreMutationParser.m10779a(jsonParser);
                Object conversationStarterCoreMutationModel = new ConversationStarterCoreMutationModel();
                ((BaseModel) conversationStarterCoreMutationModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (conversationStarterCoreMutationModel instanceof Postprocessable) {
                    return ((Postprocessable) conversationStarterCoreMutationModel).a();
                }
                return conversationStarterCoreMutationModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 1565037898)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: mentions_search */
        public final class MessengerConversationStarterItemModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
            private int f10214d;
            @Nullable
            private String f10215e;

            /* compiled from: mentions_search */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(MessengerConversationStarterItemModel.class, new Deserializer());
                }

                public Object m10762a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(MessengerConversationStarterItemParser.m10777a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object messengerConversationStarterItemModel = new MessengerConversationStarterItemModel();
                    ((BaseModel) messengerConversationStarterItemModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (messengerConversationStarterItemModel instanceof Postprocessable) {
                        return ((Postprocessable) messengerConversationStarterItemModel).a();
                    }
                    return messengerConversationStarterItemModel;
                }
            }

            /* compiled from: mentions_search */
            public class Serializer extends JsonSerializer<MessengerConversationStarterItemModel> {
                public final void m10763a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    MessengerConversationStarterItemModel messengerConversationStarterItemModel = (MessengerConversationStarterItemModel) obj;
                    if (messengerConversationStarterItemModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(messengerConversationStarterItemModel.m10767a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        messengerConversationStarterItemModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    MessengerConversationStarterItemParser.m10778a(messengerConversationStarterItemModel.w_(), messengerConversationStarterItemModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(MessengerConversationStarterItemModel.class, new Serializer());
                }
            }

            public MessengerConversationStarterItemModel() {
                super(2);
            }

            public final void m10771a(String str, ConsistencyTuple consistencyTuple) {
                if ("actions_remaining".equals(str)) {
                    consistencyTuple.a = Integer.valueOf(m10765j());
                    consistencyTuple.b = u_();
                    consistencyTuple.c = 0;
                    return;
                }
                consistencyTuple.a();
            }

            public final void m10772a(String str, Object obj, boolean z) {
                if ("actions_remaining".equals(str)) {
                    m10764a(((Integer) obj).intValue());
                }
            }

            private int m10765j() {
                a(0, 0);
                return this.f10214d;
            }

            private void m10764a(int i) {
                this.f10214d = i;
                if (this.b != null && this.b.d) {
                    this.b.b(this.c, 0, i);
                }
            }

            @Nullable
            private String m10766k() {
                this.f10215e = super.a(this.f10215e, 1);
                return this.f10215e;
            }

            @Nullable
            public final String m10769a() {
                return m10766k();
            }

            public final int jK_() {
                return 1251514188;
            }

            public final GraphQLVisitableModel m10768a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m10767a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m10766k());
                flatBufferBuilder.c(2);
                flatBufferBuilder.a(0, this.f10214d, 0);
                flatBufferBuilder.b(1, b);
                i();
                return flatBufferBuilder.d();
            }

            public final void m10770a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                super.a(mutableFlatBuffer, i, obj);
                this.f10214d = mutableFlatBuffer.a(i, 0, 0);
            }
        }

        /* compiled from: mentions_search */
        public class Serializer extends JsonSerializer<ConversationStarterCoreMutationModel> {
            public final void m10773a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                ConversationStarterCoreMutationModel conversationStarterCoreMutationModel = (ConversationStarterCoreMutationModel) obj;
                if (conversationStarterCoreMutationModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(conversationStarterCoreMutationModel.m10775a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    conversationStarterCoreMutationModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = conversationStarterCoreMutationModel.w_();
                int u_ = conversationStarterCoreMutationModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("messenger_conversation_starter_item");
                    MessengerConversationStarterItemParser.m10778a(mutableFlatBuffer, g, jsonGenerator);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(ConversationStarterCoreMutationModel.class, new Serializer());
            }
        }

        public ConversationStarterCoreMutationModel() {
            super(1);
        }

        @Nullable
        private MessengerConversationStarterItemModel m10774a() {
            this.f10216d = (MessengerConversationStarterItemModel) super.a(this.f10216d, 0, MessengerConversationStarterItemModel.class);
            return this.f10216d;
        }

        public final int jK_() {
            return -1426049843;
        }

        public final GraphQLVisitableModel m10776a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m10774a() != null) {
                MessengerConversationStarterItemModel messengerConversationStarterItemModel = (MessengerConversationStarterItemModel) graphQLModelMutatingVisitor.b(m10774a());
                if (m10774a() != messengerConversationStarterItemModel) {
                    graphQLVisitableModel = (ConversationStarterCoreMutationModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f10216d = messengerConversationStarterItemModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m10775a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m10774a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }
}
