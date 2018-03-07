package com.facebook.messaging.graphql.threads;

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
import com.facebook.graphql.visitor.ConsistencyTuple;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLPersistableNode;
import com.facebook.graphql.visitor.GraphQLVisitableConsistentModel;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.facebook.messaging.graphql.threads.BotInfoParsers.BotInfoParser;
import com.facebook.messaging.graphql.threads.BotInfoParsers.BotInfoParser.PageMessengerBotParser;
import com.facebook.messaging.graphql.threads.BotInfoParsers.BotMessagingActorInfoParser;
import com.facebook.messaging.graphql.threads.BotInfoParsers.BotMessagingActorInfoParser.MessagingActorParser;
import com.facebook.messaging.graphql.threads.UserInfoModels.ProfilePhotoInfoModel;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.nio.ByteBuffer;
import javax.annotation.Nullable;

/* compiled from: video_download_queued */
public class BotInfoModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 635696560)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: video_download_queued */
    public final class BotInfoModel extends BaseModel implements GraphQLVisitableConsistentModel {
        @Nullable
        private PageMessengerBotModel f769d;

        /* compiled from: video_download_queued */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(BotInfoModel.class, new Deserializer());
            }

            public Object m835a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = BotInfoParser.m865a(jsonParser);
                Object botInfoModel = new BotInfoModel();
                ((BaseModel) botInfoModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (botInfoModel instanceof Postprocessable) {
                    return ((Postprocessable) botInfoModel).a();
                }
                return botInfoModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 273304230)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: video_download_queued */
        public final class PageMessengerBotModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private String f768d;

            /* compiled from: video_download_queued */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(PageMessengerBotModel.class, new Deserializer());
                }

                public Object m836a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(PageMessengerBotParser.m863a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object pageMessengerBotModel = new PageMessengerBotModel();
                    ((BaseModel) pageMessengerBotModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (pageMessengerBotModel instanceof Postprocessable) {
                        return ((Postprocessable) pageMessengerBotModel).a();
                    }
                    return pageMessengerBotModel;
                }
            }

            /* compiled from: video_download_queued */
            public class Serializer extends JsonSerializer<PageMessengerBotModel> {
                public final void m837a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    PageMessengerBotModel pageMessengerBotModel = (PageMessengerBotModel) obj;
                    if (pageMessengerBotModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(pageMessengerBotModel.m839a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        pageMessengerBotModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    PageMessengerBotParser.m864a(pageMessengerBotModel.w_(), pageMessengerBotModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(PageMessengerBotModel.class, new Serializer());
                }
            }

            public PageMessengerBotModel() {
                super(1);
            }

            @Nullable
            private String m838a() {
                this.f768d = super.a(this.f768d, 0);
                return this.f768d;
            }

            public final int jK_() {
                return 1448520195;
            }

            public final GraphQLVisitableModel m840a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m839a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m838a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, b);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: video_download_queued */
        public class Serializer extends JsonSerializer<BotInfoModel> {
            public final void m841a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                BotInfoModel botInfoModel = (BotInfoModel) obj;
                if (botInfoModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(botInfoModel.m843a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    botInfoModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = botInfoModel.w_();
                int u_ = botInfoModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("page_messenger_bot");
                    PageMessengerBotParser.m864a(mutableFlatBuffer, g, jsonGenerator);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(BotInfoModel.class, new Serializer());
            }
        }

        public BotInfoModel() {
            super(1);
        }

        public final void m845a(String str, ConsistencyTuple consistencyTuple) {
            consistencyTuple.a();
        }

        public final void m846a(String str, Object obj, boolean z) {
        }

        @Nullable
        private PageMessengerBotModel m842a() {
            this.f769d = (PageMessengerBotModel) super.a(this.f769d, 0, PageMessengerBotModel.class);
            return this.f769d;
        }

        public final int jK_() {
            return 2479791;
        }

        public final GraphQLVisitableModel m844a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m842a() != null) {
                PageMessengerBotModel pageMessengerBotModel = (PageMessengerBotModel) graphQLModelMutatingVisitor.b(m842a());
                if (m842a() != pageMessengerBotModel) {
                    graphQLVisitableModel = (BotInfoModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f769d = pageMessengerBotModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m843a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m842a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 2086738037)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: video_download_queued */
    public final class BotMessagingActorInfoModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private MessagingActorModel f776d;

        /* compiled from: video_download_queued */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(BotMessagingActorInfoModel.class, new Deserializer());
            }

            public Object m847a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(BotMessagingActorInfoParser.m868b(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object botMessagingActorInfoModel = new BotMessagingActorInfoModel();
                ((BaseModel) botMessagingActorInfoModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (botMessagingActorInfoModel instanceof Postprocessable) {
                    return ((Postprocessable) botMessagingActorInfoModel).a();
                }
                return botMessagingActorInfoModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 275182867)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: video_download_queued */
        public final class MessagingActorModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel {
            @Nullable
            private GraphQLObjectType f770d;
            @Nullable
            private String f771e;
            @Nullable
            private String f772f;
            @Nullable
            private ProfilePhotoInfoModel f773g;
            @Nullable
            private ProfilePhotoInfoModel f774h;
            @Nullable
            private ProfilePhotoInfoModel f775i;

            /* compiled from: video_download_queued */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(MessagingActorModel.class, new Deserializer());
                }

                public Object m848a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(MessagingActorParser.m866a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object messagingActorModel = new MessagingActorModel();
                    ((BaseModel) messagingActorModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (messagingActorModel instanceof Postprocessable) {
                        return ((Postprocessable) messagingActorModel).a();
                    }
                    return messagingActorModel;
                }
            }

            /* compiled from: video_download_queued */
            public class Serializer extends JsonSerializer<MessagingActorModel> {
                public final void m849a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    MessagingActorModel messagingActorModel = (MessagingActorModel) obj;
                    if (messagingActorModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(messagingActorModel.m850a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        messagingActorModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    MessagingActorParser.m867a(messagingActorModel.w_(), messagingActorModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(MessagingActorModel.class, new Serializer());
                }
            }

            public MessagingActorModel() {
                super(6);
            }

            @Nullable
            public final GraphQLObjectType m853j() {
                if (this.b != null && this.f770d == null) {
                    this.f770d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
                }
                return this.f770d;
            }

            @Nullable
            public final String m854k() {
                this.f771e = super.a(this.f771e, 1);
                return this.f771e;
            }

            @Nullable
            public final String m855l() {
                this.f772f = super.a(this.f772f, 2);
                return this.f772f;
            }

            @Nullable
            public final ProfilePhotoInfoModel m856m() {
                this.f773g = (ProfilePhotoInfoModel) super.a(this.f773g, 3, ProfilePhotoInfoModel.class);
                return this.f773g;
            }

            @Nullable
            public final ProfilePhotoInfoModel m857n() {
                this.f774h = (ProfilePhotoInfoModel) super.a(this.f774h, 4, ProfilePhotoInfoModel.class);
                return this.f774h;
            }

            @Nullable
            public final ProfilePhotoInfoModel m858o() {
                this.f775i = (ProfilePhotoInfoModel) super.a(this.f775i, 5, ProfilePhotoInfoModel.class);
                return this.f775i;
            }

            @Nullable
            public final String m852a() {
                return m854k();
            }

            public final int jK_() {
                return -1575218831;
            }

            public final GraphQLVisitableModel m851a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                ProfilePhotoInfoModel profilePhotoInfoModel;
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m856m() != null) {
                    profilePhotoInfoModel = (ProfilePhotoInfoModel) graphQLModelMutatingVisitor.b(m856m());
                    if (m856m() != profilePhotoInfoModel) {
                        graphQLVisitableModel = (MessagingActorModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f773g = profilePhotoInfoModel;
                    }
                }
                if (m857n() != null) {
                    profilePhotoInfoModel = (ProfilePhotoInfoModel) graphQLModelMutatingVisitor.b(m857n());
                    if (m857n() != profilePhotoInfoModel) {
                        graphQLVisitableModel = (MessagingActorModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f774h = profilePhotoInfoModel;
                    }
                }
                if (m858o() != null) {
                    profilePhotoInfoModel = (ProfilePhotoInfoModel) graphQLModelMutatingVisitor.b(m858o());
                    if (m858o() != profilePhotoInfoModel) {
                        graphQLVisitableModel = (MessagingActorModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f775i = profilePhotoInfoModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m850a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m853j());
                int b = flatBufferBuilder.b(m854k());
                int b2 = flatBufferBuilder.b(m855l());
                int a2 = ModelHelper.a(flatBufferBuilder, m856m());
                int a3 = ModelHelper.a(flatBufferBuilder, m857n());
                int a4 = ModelHelper.a(flatBufferBuilder, m858o());
                flatBufferBuilder.c(6);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.b(1, b);
                flatBufferBuilder.b(2, b2);
                flatBufferBuilder.b(3, a2);
                flatBufferBuilder.b(4, a3);
                flatBufferBuilder.b(5, a4);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: video_download_queued */
        public class Serializer extends JsonSerializer<BotMessagingActorInfoModel> {
            public final void m859a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                BotMessagingActorInfoModel botMessagingActorInfoModel = (BotMessagingActorInfoModel) obj;
                if (botMessagingActorInfoModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(botMessagingActorInfoModel.m860a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    botMessagingActorInfoModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                BotMessagingActorInfoParser.m869b(botMessagingActorInfoModel.w_(), botMessagingActorInfoModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(BotMessagingActorInfoModel.class, new Serializer());
            }
        }

        public BotMessagingActorInfoModel() {
            super(1);
        }

        @Nullable
        public final MessagingActorModel m862a() {
            this.f776d = (MessagingActorModel) super.a(this.f776d, 0, MessagingActorModel.class);
            return this.f776d;
        }

        public final int jK_() {
            return -1020278353;
        }

        public final GraphQLVisitableModel m861a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m862a() != null) {
                MessagingActorModel messagingActorModel = (MessagingActorModel) graphQLModelMutatingVisitor.b(m862a());
                if (m862a() != messagingActorModel) {
                    graphQLVisitableModel = (BotMessagingActorInfoModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f776d = messagingActorModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m860a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m862a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }
}
