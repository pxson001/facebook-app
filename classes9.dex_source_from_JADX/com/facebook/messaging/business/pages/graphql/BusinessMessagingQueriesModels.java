package com.facebook.messaging.business.pages.graphql;

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
import com.facebook.messaging.business.pages.graphql.BusinessMessagingQueriesParsers.BYMMQueryParser;
import com.facebook.messaging.business.pages.graphql.BusinessMessagingQueriesParsers.BYMMQueryParser.MessengerBusinessYouMayMessageParser;
import com.facebook.messaging.business.pages.graphql.BusinessMessagingQueriesParsers.BusinessMessagingPageParser;
import com.facebook.messaging.business.pages.graphql.BusinessMessagingQueriesParsers.BusinessUserHasMessagedQueryParser;
import com.facebook.messaging.business.pages.graphql.BusinessMessagingQueriesParsers.BusinessUserHasMessagedQueryParser.BusinessUserHasMessagedParser;
import com.facebook.messaging.business.pages.graphql.BusinessMessagingQueriesParsers.SuggestedBotsQueryParser;
import com.facebook.messaging.business.pages.graphql.BusinessMessagingQueriesParsers.SuggestedBotsQueryParser.MessengerBotsYouMayMessageParser;
import com.facebook.messaging.graphql.threads.UserInfoModels.ProfilePhotoInfoModel;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import java.nio.ByteBuffer;
import java.util.List;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/* compiled from: msg_count */
public class BusinessMessagingQueriesModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -192350789)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: msg_count */
    public final class BYMMQueryModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private MessengerBusinessYouMayMessageModel f9031d;

        /* compiled from: msg_count */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(BYMMQueryModel.class, new Deserializer());
            }

            public Object m9292a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = BYMMQueryParser.m9338a(jsonParser);
                Object bYMMQueryModel = new BYMMQueryModel();
                ((BaseModel) bYMMQueryModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (bYMMQueryModel instanceof Postprocessable) {
                    return ((Postprocessable) bYMMQueryModel).a();
                }
                return bYMMQueryModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -231360317)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: msg_count */
        public final class MessengerBusinessYouMayMessageModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private List<BusinessMessagingPageModel> f9030d;

            /* compiled from: msg_count */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(MessengerBusinessYouMayMessageModel.class, new Deserializer());
                }

                public Object m9293a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(MessengerBusinessYouMayMessageParser.m9336a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object messengerBusinessYouMayMessageModel = new MessengerBusinessYouMayMessageModel();
                    ((BaseModel) messengerBusinessYouMayMessageModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (messengerBusinessYouMayMessageModel instanceof Postprocessable) {
                        return ((Postprocessable) messengerBusinessYouMayMessageModel).a();
                    }
                    return messengerBusinessYouMayMessageModel;
                }
            }

            /* compiled from: msg_count */
            public class Serializer extends JsonSerializer<MessengerBusinessYouMayMessageModel> {
                public final void m9294a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    MessengerBusinessYouMayMessageModel messengerBusinessYouMayMessageModel = (MessengerBusinessYouMayMessageModel) obj;
                    if (messengerBusinessYouMayMessageModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(messengerBusinessYouMayMessageModel.m9295a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        messengerBusinessYouMayMessageModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    MessengerBusinessYouMayMessageParser.m9337a(messengerBusinessYouMayMessageModel.w_(), messengerBusinessYouMayMessageModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(MessengerBusinessYouMayMessageModel.class, new Serializer());
                }
            }

            public MessengerBusinessYouMayMessageModel() {
                super(1);
            }

            @Nonnull
            public final ImmutableList<BusinessMessagingPageModel> m9297a() {
                this.f9030d = super.a(this.f9030d, 0, BusinessMessagingPageModel.class);
                return (ImmutableList) this.f9030d;
            }

            public final int jK_() {
                return -252161844;
            }

            public final GraphQLVisitableModel m9296a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m9297a() != null) {
                    Builder a = ModelHelper.a(m9297a(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        graphQLVisitableModel = (MessengerBusinessYouMayMessageModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f9030d = a.b();
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m9295a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m9297a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, a);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: msg_count */
        public class Serializer extends JsonSerializer<BYMMQueryModel> {
            public final void m9298a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                BYMMQueryModel bYMMQueryModel = (BYMMQueryModel) obj;
                if (bYMMQueryModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(bYMMQueryModel.m9299a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    bYMMQueryModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = bYMMQueryModel.w_();
                int u_ = bYMMQueryModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("messenger_business_you_may_message");
                    MessengerBusinessYouMayMessageParser.m9337a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(BYMMQueryModel.class, new Serializer());
            }
        }

        public BYMMQueryModel() {
            super(1);
        }

        @Nullable
        public final MessengerBusinessYouMayMessageModel m9301a() {
            this.f9031d = (MessengerBusinessYouMayMessageModel) super.a(this.f9031d, 0, MessengerBusinessYouMayMessageModel.class);
            return this.f9031d;
        }

        public final int jK_() {
            return -1732764110;
        }

        public final GraphQLVisitableModel m9300a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m9301a() != null) {
                MessengerBusinessYouMayMessageModel messengerBusinessYouMayMessageModel = (MessengerBusinessYouMayMessageModel) graphQLModelMutatingVisitor.b(m9301a());
                if (m9301a() != messengerBusinessYouMayMessageModel) {
                    graphQLVisitableModel = (BYMMQueryModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f9031d = messengerBusinessYouMayMessageModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m9299a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m9301a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -1082307666)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: msg_count */
    public final class BusinessMessagingPageModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
        @Nullable
        private String f9032d;
        private boolean f9033e;
        @Nullable
        private String f9034f;
        @Nullable
        private ProfilePhotoInfoModel f9035g;
        @Nullable
        private ProfilePhotoInfoModel f9036h;
        @Nullable
        private ProfilePhotoInfoModel f9037i;

        /* compiled from: msg_count */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(BusinessMessagingPageModel.class, new Deserializer());
            }

            public Object m9302a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(BusinessMessagingPageParser.m9341b(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object businessMessagingPageModel = new BusinessMessagingPageModel();
                ((BaseModel) businessMessagingPageModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (businessMessagingPageModel instanceof Postprocessable) {
                    return ((Postprocessable) businessMessagingPageModel).a();
                }
                return businessMessagingPageModel;
            }
        }

        /* compiled from: msg_count */
        public class Serializer extends JsonSerializer<BusinessMessagingPageModel> {
            public final void m9303a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                BusinessMessagingPageModel businessMessagingPageModel = (BusinessMessagingPageModel) obj;
                if (businessMessagingPageModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(businessMessagingPageModel.m9304a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    businessMessagingPageModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                BusinessMessagingPageParser.m9342b(businessMessagingPageModel.w_(), businessMessagingPageModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(BusinessMessagingPageModel.class, new Serializer());
            }
        }

        public BusinessMessagingPageModel() {
            super(6);
        }

        public final void m9308a(String str, ConsistencyTuple consistencyTuple) {
            consistencyTuple.a();
        }

        public final void m9309a(String str, Object obj, boolean z) {
        }

        @Nullable
        public final String m9310j() {
            this.f9032d = super.a(this.f9032d, 0);
            return this.f9032d;
        }

        public final boolean m9311k() {
            a(0, 1);
            return this.f9033e;
        }

        @Nullable
        public final String m9312l() {
            this.f9034f = super.a(this.f9034f, 2);
            return this.f9034f;
        }

        @Nullable
        public final ProfilePhotoInfoModel m9313m() {
            this.f9035g = (ProfilePhotoInfoModel) super.a(this.f9035g, 3, ProfilePhotoInfoModel.class);
            return this.f9035g;
        }

        @Nullable
        public final ProfilePhotoInfoModel m9314n() {
            this.f9036h = (ProfilePhotoInfoModel) super.a(this.f9036h, 4, ProfilePhotoInfoModel.class);
            return this.f9036h;
        }

        @Nullable
        public final ProfilePhotoInfoModel m9315o() {
            this.f9037i = (ProfilePhotoInfoModel) super.a(this.f9037i, 5, ProfilePhotoInfoModel.class);
            return this.f9037i;
        }

        @Nullable
        public final String m9306a() {
            return m9310j();
        }

        public final int jK_() {
            return 2479791;
        }

        public final GraphQLVisitableModel m9305a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            ProfilePhotoInfoModel profilePhotoInfoModel;
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m9313m() != null) {
                profilePhotoInfoModel = (ProfilePhotoInfoModel) graphQLModelMutatingVisitor.b(m9313m());
                if (m9313m() != profilePhotoInfoModel) {
                    graphQLVisitableModel = (BusinessMessagingPageModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f9035g = profilePhotoInfoModel;
                }
            }
            if (m9314n() != null) {
                profilePhotoInfoModel = (ProfilePhotoInfoModel) graphQLModelMutatingVisitor.b(m9314n());
                if (m9314n() != profilePhotoInfoModel) {
                    graphQLVisitableModel = (BusinessMessagingPageModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f9036h = profilePhotoInfoModel;
                }
            }
            if (m9315o() != null) {
                profilePhotoInfoModel = (ProfilePhotoInfoModel) graphQLModelMutatingVisitor.b(m9315o());
                if (m9315o() != profilePhotoInfoModel) {
                    graphQLVisitableModel = (BusinessMessagingPageModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f9037i = profilePhotoInfoModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m9304a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(m9310j());
            int b2 = flatBufferBuilder.b(m9312l());
            int a = ModelHelper.a(flatBufferBuilder, m9313m());
            int a2 = ModelHelper.a(flatBufferBuilder, m9314n());
            int a3 = ModelHelper.a(flatBufferBuilder, m9315o());
            flatBufferBuilder.c(6);
            flatBufferBuilder.b(0, b);
            flatBufferBuilder.a(1, this.f9033e);
            flatBufferBuilder.b(2, b2);
            flatBufferBuilder.b(3, a);
            flatBufferBuilder.b(4, a2);
            flatBufferBuilder.b(5, a3);
            i();
            return flatBufferBuilder.d();
        }

        public final void m9307a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
            super.a(mutableFlatBuffer, i, obj);
            this.f9033e = mutableFlatBuffer.a(i, 1);
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -1883784345)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: msg_count */
    public final class BusinessUserHasMessagedQueryModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private BusinessUserHasMessagedModel f9039d;

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -231360317)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: msg_count */
        public final class BusinessUserHasMessagedModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private List<BusinessMessagingPageModel> f9038d;

            /* compiled from: msg_count */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(BusinessUserHasMessagedModel.class, new Deserializer());
                }

                public Object m9316a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(BusinessUserHasMessagedParser.m9343a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object businessUserHasMessagedModel = new BusinessUserHasMessagedModel();
                    ((BaseModel) businessUserHasMessagedModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (businessUserHasMessagedModel instanceof Postprocessable) {
                        return ((Postprocessable) businessUserHasMessagedModel).a();
                    }
                    return businessUserHasMessagedModel;
                }
            }

            /* compiled from: msg_count */
            public class Serializer extends JsonSerializer<BusinessUserHasMessagedModel> {
                public final void m9317a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    BusinessUserHasMessagedModel businessUserHasMessagedModel = (BusinessUserHasMessagedModel) obj;
                    if (businessUserHasMessagedModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(businessUserHasMessagedModel.m9318a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        businessUserHasMessagedModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    BusinessUserHasMessagedParser.m9344a(businessUserHasMessagedModel.w_(), businessUserHasMessagedModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(BusinessUserHasMessagedModel.class, new Serializer());
                }
            }

            public BusinessUserHasMessagedModel() {
                super(1);
            }

            @Nonnull
            public final ImmutableList<BusinessMessagingPageModel> m9320a() {
                this.f9038d = super.a(this.f9038d, 0, BusinessMessagingPageModel.class);
                return (ImmutableList) this.f9038d;
            }

            public final int jK_() {
                return 1449388330;
            }

            public final GraphQLVisitableModel m9319a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m9320a() != null) {
                    Builder a = ModelHelper.a(m9320a(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        graphQLVisitableModel = (BusinessUserHasMessagedModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f9038d = a.b();
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m9318a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m9320a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, a);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: msg_count */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(BusinessUserHasMessagedQueryModel.class, new Deserializer());
            }

            public Object m9321a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = BusinessUserHasMessagedQueryParser.m9345a(jsonParser);
                Object businessUserHasMessagedQueryModel = new BusinessUserHasMessagedQueryModel();
                ((BaseModel) businessUserHasMessagedQueryModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (businessUserHasMessagedQueryModel instanceof Postprocessable) {
                    return ((Postprocessable) businessUserHasMessagedQueryModel).a();
                }
                return businessUserHasMessagedQueryModel;
            }
        }

        /* compiled from: msg_count */
        public class Serializer extends JsonSerializer<BusinessUserHasMessagedQueryModel> {
            public final void m9322a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                BusinessUserHasMessagedQueryModel businessUserHasMessagedQueryModel = (BusinessUserHasMessagedQueryModel) obj;
                if (businessUserHasMessagedQueryModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(businessUserHasMessagedQueryModel.m9323a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    businessUserHasMessagedQueryModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = businessUserHasMessagedQueryModel.w_();
                int u_ = businessUserHasMessagedQueryModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("business_user_has_messaged");
                    BusinessUserHasMessagedParser.m9344a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(BusinessUserHasMessagedQueryModel.class, new Serializer());
            }
        }

        public BusinessUserHasMessagedQueryModel() {
            super(1);
        }

        @Nullable
        public final BusinessUserHasMessagedModel m9325a() {
            this.f9039d = (BusinessUserHasMessagedModel) super.a(this.f9039d, 0, BusinessUserHasMessagedModel.class);
            return this.f9039d;
        }

        public final int jK_() {
            return -1732764110;
        }

        public final GraphQLVisitableModel m9324a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m9325a() != null) {
                BusinessUserHasMessagedModel businessUserHasMessagedModel = (BusinessUserHasMessagedModel) graphQLModelMutatingVisitor.b(m9325a());
                if (m9325a() != businessUserHasMessagedModel) {
                    graphQLVisitableModel = (BusinessUserHasMessagedQueryModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f9039d = businessUserHasMessagedModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m9323a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m9325a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 719222603)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: msg_count */
    public final class SuggestedBotsQueryModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private MessengerBotsYouMayMessageModel f9041d;

        /* compiled from: msg_count */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(SuggestedBotsQueryModel.class, new Deserializer());
            }

            public Object m9326a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = SuggestedBotsQueryParser.m9348a(jsonParser);
                Object suggestedBotsQueryModel = new SuggestedBotsQueryModel();
                ((BaseModel) suggestedBotsQueryModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (suggestedBotsQueryModel instanceof Postprocessable) {
                    return ((Postprocessable) suggestedBotsQueryModel).a();
                }
                return suggestedBotsQueryModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -231360317)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: msg_count */
        public final class MessengerBotsYouMayMessageModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private List<BusinessMessagingPageModel> f9040d;

            /* compiled from: msg_count */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(MessengerBotsYouMayMessageModel.class, new Deserializer());
                }

                public Object m9327a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(MessengerBotsYouMayMessageParser.m9346a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object messengerBotsYouMayMessageModel = new MessengerBotsYouMayMessageModel();
                    ((BaseModel) messengerBotsYouMayMessageModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (messengerBotsYouMayMessageModel instanceof Postprocessable) {
                        return ((Postprocessable) messengerBotsYouMayMessageModel).a();
                    }
                    return messengerBotsYouMayMessageModel;
                }
            }

            /* compiled from: msg_count */
            public class Serializer extends JsonSerializer<MessengerBotsYouMayMessageModel> {
                public final void m9328a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    MessengerBotsYouMayMessageModel messengerBotsYouMayMessageModel = (MessengerBotsYouMayMessageModel) obj;
                    if (messengerBotsYouMayMessageModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(messengerBotsYouMayMessageModel.m9329a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        messengerBotsYouMayMessageModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    MessengerBotsYouMayMessageParser.m9347a(messengerBotsYouMayMessageModel.w_(), messengerBotsYouMayMessageModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(MessengerBotsYouMayMessageModel.class, new Serializer());
                }
            }

            public MessengerBotsYouMayMessageModel() {
                super(1);
            }

            @Nonnull
            public final ImmutableList<BusinessMessagingPageModel> m9331a() {
                this.f9040d = super.a(this.f9040d, 0, BusinessMessagingPageModel.class);
                return (ImmutableList) this.f9040d;
            }

            public final int jK_() {
                return -1263952384;
            }

            public final GraphQLVisitableModel m9330a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m9331a() != null) {
                    Builder a = ModelHelper.a(m9331a(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        graphQLVisitableModel = (MessengerBotsYouMayMessageModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f9040d = a.b();
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m9329a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m9331a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, a);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: msg_count */
        public class Serializer extends JsonSerializer<SuggestedBotsQueryModel> {
            public final void m9332a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                SuggestedBotsQueryModel suggestedBotsQueryModel = (SuggestedBotsQueryModel) obj;
                if (suggestedBotsQueryModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(suggestedBotsQueryModel.m9333a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    suggestedBotsQueryModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = suggestedBotsQueryModel.w_();
                int u_ = suggestedBotsQueryModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("messenger_bots_you_may_message");
                    MessengerBotsYouMayMessageParser.m9347a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(SuggestedBotsQueryModel.class, new Serializer());
            }
        }

        public SuggestedBotsQueryModel() {
            super(1);
        }

        @Nullable
        public final MessengerBotsYouMayMessageModel m9335a() {
            this.f9041d = (MessengerBotsYouMayMessageModel) super.a(this.f9041d, 0, MessengerBotsYouMayMessageModel.class);
            return this.f9041d;
        }

        public final int jK_() {
            return -1732764110;
        }

        public final GraphQLVisitableModel m9334a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m9335a() != null) {
                MessengerBotsYouMayMessageModel messengerBotsYouMayMessageModel = (MessengerBotsYouMayMessageModel) graphQLModelMutatingVisitor.b(m9335a());
                if (m9335a() != messengerBotsYouMayMessageModel) {
                    graphQLVisitableModel = (SuggestedBotsQueryModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f9041d = messengerBotsYouMayMessageModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m9333a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m9335a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }
}
