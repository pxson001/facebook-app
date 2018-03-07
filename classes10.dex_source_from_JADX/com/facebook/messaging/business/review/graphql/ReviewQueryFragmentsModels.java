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
import com.facebook.graphql.enums.GraphQLObjectType;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.modelutil.SerializerHelpers;
import com.facebook.graphql.visitor.ConsistencyTuple;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLPersistableNode;
import com.facebook.graphql.visitor.GraphQLVisitableConsistentModel;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.facebook.messaging.business.review.graphql.ReviewQueryFragmentsParsers.MessengerPlatformBotReviewQueryParser;
import com.facebook.messaging.business.review.graphql.ReviewQueryFragmentsParsers.MessengerPlatformBotReviewQueryParser.ViewerMessengerPlatformBotReviewParser;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.nio.ByteBuffer;
import javax.annotation.Nullable;

/* compiled from: thread.threadKey */
public class ReviewQueryFragmentsModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -827779974)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: thread.threadKey */
    public final class MessengerPlatformBotReviewQueryModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
        @Nullable
        private GraphQLObjectType f1662d;
        @Nullable
        private String f1663e;
        @Nullable
        private String f1664f;
        @Nullable
        private ViewerMessengerPlatformBotReviewModel f1665g;

        /* compiled from: thread.threadKey */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(MessengerPlatformBotReviewQueryModel.class, new Deserializer());
            }

            public Object m1612a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = MessengerPlatformBotReviewQueryParser.m1634a(jsonParser);
                Object messengerPlatformBotReviewQueryModel = new MessengerPlatformBotReviewQueryModel();
                ((BaseModel) messengerPlatformBotReviewQueryModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (messengerPlatformBotReviewQueryModel instanceof Postprocessable) {
                    return ((Postprocessable) messengerPlatformBotReviewQueryModel).a();
                }
                return messengerPlatformBotReviewQueryModel;
            }
        }

        /* compiled from: thread.threadKey */
        public class Serializer extends JsonSerializer<MessengerPlatformBotReviewQueryModel> {
            public final void m1613a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                MessengerPlatformBotReviewQueryModel messengerPlatformBotReviewQueryModel = (MessengerPlatformBotReviewQueryModel) obj;
                if (messengerPlatformBotReviewQueryModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(messengerPlatformBotReviewQueryModel.m1625a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    messengerPlatformBotReviewQueryModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = messengerPlatformBotReviewQueryModel.w_();
                int u_ = messengerPlatformBotReviewQueryModel.u_();
                jsonGenerator.f();
                if (mutableFlatBuffer.g(u_, 0) != 0) {
                    jsonGenerator.a("__type__");
                    SerializerHelpers.b(mutableFlatBuffer, u_, 0, jsonGenerator);
                }
                if (mutableFlatBuffer.g(u_, 1) != 0) {
                    jsonGenerator.a("id");
                    jsonGenerator.b(mutableFlatBuffer.c(u_, 1));
                }
                if (mutableFlatBuffer.g(u_, 2) != 0) {
                    jsonGenerator.a("name");
                    jsonGenerator.b(mutableFlatBuffer.c(u_, 2));
                }
                int g = mutableFlatBuffer.g(u_, 3);
                if (g != 0) {
                    jsonGenerator.a("viewer_messenger_platform_bot_review");
                    ViewerMessengerPlatformBotReviewParser.m1633a(mutableFlatBuffer, g, jsonGenerator);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(MessengerPlatformBotReviewQueryModel.class, new Serializer());
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 1352976234)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: thread.threadKey */
        public final class ViewerMessengerPlatformBotReviewModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel {
            @Nullable
            private String f1659d;
            private int f1660e;
            @Nullable
            private String f1661f;

            /* compiled from: thread.threadKey */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(ViewerMessengerPlatformBotReviewModel.class, new Deserializer());
                }

                public Object m1614a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(ViewerMessengerPlatformBotReviewParser.m1632a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object viewerMessengerPlatformBotReviewModel = new ViewerMessengerPlatformBotReviewModel();
                    ((BaseModel) viewerMessengerPlatformBotReviewModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (viewerMessengerPlatformBotReviewModel instanceof Postprocessable) {
                        return ((Postprocessable) viewerMessengerPlatformBotReviewModel).a();
                    }
                    return viewerMessengerPlatformBotReviewModel;
                }
            }

            /* compiled from: thread.threadKey */
            public class Serializer extends JsonSerializer<ViewerMessengerPlatformBotReviewModel> {
                public final void m1615a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    ViewerMessengerPlatformBotReviewModel viewerMessengerPlatformBotReviewModel = (ViewerMessengerPlatformBotReviewModel) obj;
                    if (viewerMessengerPlatformBotReviewModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(viewerMessengerPlatformBotReviewModel.m1617a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        viewerMessengerPlatformBotReviewModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    ViewerMessengerPlatformBotReviewParser.m1633a(viewerMessengerPlatformBotReviewModel.w_(), viewerMessengerPlatformBotReviewModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(ViewerMessengerPlatformBotReviewModel.class, new Serializer());
                }
            }

            public ViewerMessengerPlatformBotReviewModel() {
                super(3);
            }

            @Nullable
            private String m1616l() {
                this.f1659d = super.a(this.f1659d, 0);
                return this.f1659d;
            }

            public final int m1621j() {
                a(0, 1);
                return this.f1660e;
            }

            @Nullable
            public final String m1622k() {
                this.f1661f = super.a(this.f1661f, 2);
                return this.f1661f;
            }

            @Nullable
            public final String m1619a() {
                return m1616l();
            }

            public final int jK_() {
                return -619216359;
            }

            public final GraphQLVisitableModel m1618a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m1617a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m1616l());
                int b2 = flatBufferBuilder.b(m1622k());
                flatBufferBuilder.c(3);
                flatBufferBuilder.b(0, b);
                flatBufferBuilder.a(1, this.f1660e, 0);
                flatBufferBuilder.b(2, b2);
                i();
                return flatBufferBuilder.d();
            }

            public final void m1620a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                super.a(mutableFlatBuffer, i, obj);
                this.f1660e = mutableFlatBuffer.a(i, 1, 0);
            }
        }

        public MessengerPlatformBotReviewQueryModel() {
            super(4);
        }

        public final void m1628a(String str, ConsistencyTuple consistencyTuple) {
            consistencyTuple.a();
        }

        public final void m1629a(String str, Object obj, boolean z) {
        }

        @Nullable
        private GraphQLObjectType m1623l() {
            if (this.b != null && this.f1662d == null) {
                this.f1662d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
            }
            return this.f1662d;
        }

        @Nullable
        private String m1624m() {
            this.f1663e = super.a(this.f1663e, 1);
            return this.f1663e;
        }

        @Nullable
        public final String m1630j() {
            this.f1664f = super.a(this.f1664f, 2);
            return this.f1664f;
        }

        @Nullable
        public final ViewerMessengerPlatformBotReviewModel m1631k() {
            this.f1665g = (ViewerMessengerPlatformBotReviewModel) super.a(this.f1665g, 3, ViewerMessengerPlatformBotReviewModel.class);
            return this.f1665g;
        }

        @Nullable
        public final String m1627a() {
            return m1624m();
        }

        public final int jK_() {
            return 2433570;
        }

        public final GraphQLVisitableModel m1626a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m1631k() != null) {
                ViewerMessengerPlatformBotReviewModel viewerMessengerPlatformBotReviewModel = (ViewerMessengerPlatformBotReviewModel) graphQLModelMutatingVisitor.b(m1631k());
                if (m1631k() != viewerMessengerPlatformBotReviewModel) {
                    graphQLVisitableModel = (MessengerPlatformBotReviewQueryModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f1665g = viewerMessengerPlatformBotReviewModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m1625a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m1623l());
            int b = flatBufferBuilder.b(m1624m());
            int b2 = flatBufferBuilder.b(m1630j());
            int a2 = ModelHelper.a(flatBufferBuilder, m1631k());
            flatBufferBuilder.c(4);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, b);
            flatBufferBuilder.b(2, b2);
            flatBufferBuilder.b(3, a2);
            i();
            return flatBufferBuilder.d();
        }
    }
}
