package com.facebook.friends.protocol;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbSerializerProvider;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.FragmentModelWithoutBridge;
import com.facebook.flatbuffers.ModelWithFlatBufferFormatHash;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.friends.protocol.FriendMutationsParsers.ActorSecondarySubscribeCoreMutationFieldsParser;
import com.facebook.friends.protocol.FriendMutationsParsers.ActorSecondarySubscribeCoreMutationFieldsParser.ProfileParser;
import com.facebook.friends.protocol.FriendMutationsParsers.ActorSubscribeCoreMutationFieldsParser;
import com.facebook.friends.protocol.FriendMutationsParsers.ActorSubscribeCoreMutationFieldsParser.SubscribeeParser;
import com.facebook.friends.protocol.FriendMutationsParsers.ActorUnsubscribeCoreMutationFieldsParser;
import com.facebook.friends.protocol.FriendMutationsParsers.ActorUnsubscribeCoreMutationFieldsParser.UnsubscribeeParser;
import com.facebook.friends.protocol.FriendMutationsParsers.ContactInviteCoreMutationFieldsParser;
import com.facebook.friends.protocol.FriendMutationsParsers.ContactInviteCoreMutationFieldsParser.ContactPointParser;
import com.facebook.friends.protocol.FriendMutationsParsers.FriendRemoveCoreMutationFieldsParser;
import com.facebook.friends.protocol.FriendMutationsParsers.FriendRemoveCoreMutationFieldsParser.UnfriendedUserParser;
import com.facebook.friends.protocol.FriendMutationsParsers.FriendRequestAcceptCoreMutationFieldsParser;
import com.facebook.friends.protocol.FriendMutationsParsers.FriendRequestAcceptCoreMutationFieldsParser.FriendRequesterParser;
import com.facebook.friends.protocol.FriendMutationsParsers.FriendRequestCancelCoreMutationFieldsParser;
import com.facebook.friends.protocol.FriendMutationsParsers.FriendRequestCancelCoreMutationFieldsParser.CancelledFriendRequesteeParser;
import com.facebook.friends.protocol.FriendMutationsParsers.FriendRequestDeleteCoreMutationFieldsParser;
import com.facebook.friends.protocol.FriendMutationsParsers.FriendRequestSendCoreMutationFieldsParser;
import com.facebook.friends.protocol.FriendMutationsParsers.FriendRequestSendCoreMutationFieldsParser.FriendRequesteesParser;
import com.facebook.friends.protocol.FriendMutationsParsers.FriendSuggestionIgnoreCoreMutationFieldsParser;
import com.facebook.friends.protocol.FriendMutationsParsers.FriendSuggestionIgnoreCoreMutationFieldsParser.IgnoredSuggestedFriendParser;
import com.facebook.friends.protocol.FriendMutationsParsers.FriendSuggestionSendMutationParser;
import com.facebook.friends.protocol.FriendMutationsParsers.FriendSuggestionSendMutationParser.SuggestedFriendParser;
import com.facebook.friends.protocol.FriendMutationsParsers.FutureFriendingCoreMutationFieldsParser;
import com.facebook.graphql.enums.GraphQLFriendshipStatus;
import com.facebook.graphql.enums.GraphQLObjectType;
import com.facebook.graphql.enums.GraphQLSecondarySubscribeStatus;
import com.facebook.graphql.enums.GraphQLSubscribeStatus;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.visitor.ConsistencyTuple;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLPersistableNode;
import com.facebook.graphql.visitor.GraphQLVisitableConsistentModel;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
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

/* compiled from: maiden */
public class FriendMutationsModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -1243220435)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: maiden */
    public final class ActorSecondarySubscribeCoreMutationFieldsModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private ProfileModel f10739d;

        /* compiled from: maiden */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(ActorSecondarySubscribeCoreMutationFieldsModel.class, new Deserializer());
            }

            public Object m17073a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = ActorSecondarySubscribeCoreMutationFieldsParser.m17317a(jsonParser);
                Object actorSecondarySubscribeCoreMutationFieldsModel = new ActorSecondarySubscribeCoreMutationFieldsModel();
                ((BaseModel) actorSecondarySubscribeCoreMutationFieldsModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (actorSecondarySubscribeCoreMutationFieldsModel instanceof Postprocessable) {
                    return ((Postprocessable) actorSecondarySubscribeCoreMutationFieldsModel).a();
                }
                return actorSecondarySubscribeCoreMutationFieldsModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 1441167374)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: maiden */
        public final class ProfileModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
            @Nullable
            private GraphQLObjectType f10736d;
            @Nullable
            private String f10737e;
            @Nullable
            private GraphQLSecondarySubscribeStatus f10738f;

            /* compiled from: maiden */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(ProfileModel.class, new Deserializer());
                }

                public Object m17074a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(ProfileParser.m17315a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object profileModel = new ProfileModel();
                    ((BaseModel) profileModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (profileModel instanceof Postprocessable) {
                        return ((Postprocessable) profileModel).a();
                    }
                    return profileModel;
                }
            }

            /* compiled from: maiden */
            public class Serializer extends JsonSerializer<ProfileModel> {
                public final void m17075a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    ProfileModel profileModel = (ProfileModel) obj;
                    if (profileModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(profileModel.m17080a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        profileModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    ProfileParser.m17316a(profileModel.w_(), profileModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(ProfileModel.class, new Serializer());
                }
            }

            public ProfileModel() {
                super(3);
            }

            public final void m17083a(String str, ConsistencyTuple consistencyTuple) {
                if ("secondary_subscribe_status".equals(str)) {
                    consistencyTuple.a = m17079l();
                    consistencyTuple.b = u_();
                    consistencyTuple.c = 2;
                    return;
                }
                consistencyTuple.a();
            }

            public final void m17084a(String str, Object obj, boolean z) {
                if ("secondary_subscribe_status".equals(str)) {
                    m17076a((GraphQLSecondarySubscribeStatus) obj);
                }
            }

            @Nullable
            private GraphQLObjectType m17077j() {
                if (this.b != null && this.f10736d == null) {
                    this.f10736d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
                }
                return this.f10736d;
            }

            @Nullable
            private String m17078k() {
                this.f10737e = super.a(this.f10737e, 1);
                return this.f10737e;
            }

            @Nullable
            private GraphQLSecondarySubscribeStatus m17079l() {
                this.f10738f = (GraphQLSecondarySubscribeStatus) super.b(this.f10738f, 2, GraphQLSecondarySubscribeStatus.class, GraphQLSecondarySubscribeStatus.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
                return this.f10738f;
            }

            private void m17076a(GraphQLSecondarySubscribeStatus graphQLSecondarySubscribeStatus) {
                this.f10738f = graphQLSecondarySubscribeStatus;
                if (this.b != null && this.b.d) {
                    this.b.a(this.c, 2, graphQLSecondarySubscribeStatus != null ? graphQLSecondarySubscribeStatus.name() : null);
                }
            }

            @Nullable
            public final String m17082a() {
                return m17078k();
            }

            public final int jK_() {
                return 1355227529;
            }

            public final GraphQLVisitableModel m17081a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m17080a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m17077j());
                int b = flatBufferBuilder.b(m17078k());
                int a2 = flatBufferBuilder.a(m17079l());
                flatBufferBuilder.c(3);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.b(1, b);
                flatBufferBuilder.b(2, a2);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: maiden */
        public class Serializer extends JsonSerializer<ActorSecondarySubscribeCoreMutationFieldsModel> {
            public final void m17085a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                ActorSecondarySubscribeCoreMutationFieldsModel actorSecondarySubscribeCoreMutationFieldsModel = (ActorSecondarySubscribeCoreMutationFieldsModel) obj;
                if (actorSecondarySubscribeCoreMutationFieldsModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(actorSecondarySubscribeCoreMutationFieldsModel.m17087a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    actorSecondarySubscribeCoreMutationFieldsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = actorSecondarySubscribeCoreMutationFieldsModel.w_();
                int u_ = actorSecondarySubscribeCoreMutationFieldsModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("profile");
                    ProfileParser.m17316a(mutableFlatBuffer, g, jsonGenerator);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(ActorSecondarySubscribeCoreMutationFieldsModel.class, new Serializer());
            }
        }

        public ActorSecondarySubscribeCoreMutationFieldsModel() {
            super(1);
        }

        @Nullable
        private ProfileModel m17086a() {
            this.f10739d = (ProfileModel) super.a(this.f10739d, 0, ProfileModel.class);
            return this.f10739d;
        }

        public final int jK_() {
            return -980383981;
        }

        public final GraphQLVisitableModel m17088a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m17086a() != null) {
                ProfileModel profileModel = (ProfileModel) graphQLModelMutatingVisitor.b(m17086a());
                if (m17086a() != profileModel) {
                    graphQLVisitableModel = (ActorSecondarySubscribeCoreMutationFieldsModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f10739d = profileModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m17087a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m17086a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 181641107)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: maiden */
    public final class ActorSubscribeCoreMutationFieldsModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private SubscribeeModel f10744d;

        /* compiled from: maiden */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(ActorSubscribeCoreMutationFieldsModel.class, new Deserializer());
            }

            public Object m17089a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = ActorSubscribeCoreMutationFieldsParser.m17320a(jsonParser);
                Object actorSubscribeCoreMutationFieldsModel = new ActorSubscribeCoreMutationFieldsModel();
                ((BaseModel) actorSubscribeCoreMutationFieldsModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (actorSubscribeCoreMutationFieldsModel instanceof Postprocessable) {
                    return ((Postprocessable) actorSubscribeCoreMutationFieldsModel).a();
                }
                return actorSubscribeCoreMutationFieldsModel;
            }
        }

        /* compiled from: maiden */
        public class Serializer extends JsonSerializer<ActorSubscribeCoreMutationFieldsModel> {
            public final void m17090a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                ActorSubscribeCoreMutationFieldsModel actorSubscribeCoreMutationFieldsModel = (ActorSubscribeCoreMutationFieldsModel) obj;
                if (actorSubscribeCoreMutationFieldsModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(actorSubscribeCoreMutationFieldsModel.m17106a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    actorSubscribeCoreMutationFieldsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = actorSubscribeCoreMutationFieldsModel.w_();
                int u_ = actorSubscribeCoreMutationFieldsModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("subscribee");
                    SubscribeeParser.m17319a(mutableFlatBuffer, g, jsonGenerator);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(ActorSubscribeCoreMutationFieldsModel.class, new Serializer());
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -751522047)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: maiden */
        public final class SubscribeeModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
            @Nullable
            private GraphQLObjectType f10740d;
            @Nullable
            private String f10741e;
            @Nullable
            private GraphQLSubscribeStatus f10742f;
            private boolean f10743g;

            /* compiled from: maiden */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(SubscribeeModel.class, new Deserializer());
                }

                public Object m17091a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(SubscribeeParser.m17318a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object subscribeeModel = new SubscribeeModel();
                    ((BaseModel) subscribeeModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (subscribeeModel instanceof Postprocessable) {
                        return ((Postprocessable) subscribeeModel).a();
                    }
                    return subscribeeModel;
                }
            }

            /* compiled from: maiden */
            public class Serializer extends JsonSerializer<SubscribeeModel> {
                public final void m17092a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    SubscribeeModel subscribeeModel = (SubscribeeModel) obj;
                    if (subscribeeModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(subscribeeModel.m17099a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        subscribeeModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    SubscribeeParser.m17319a(subscribeeModel.w_(), subscribeeModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(SubscribeeModel.class, new Serializer());
                }
            }

            public SubscribeeModel() {
                super(4);
            }

            public final void m17103a(String str, ConsistencyTuple consistencyTuple) {
                if ("subscribe_status".equals(str)) {
                    consistencyTuple.a = m17097l();
                    consistencyTuple.b = u_();
                    consistencyTuple.c = 2;
                } else if ("video_channel_is_viewer_following".equals(str)) {
                    consistencyTuple.a = Boolean.valueOf(m17098m());
                    consistencyTuple.b = u_();
                    consistencyTuple.c = 3;
                } else {
                    consistencyTuple.a();
                }
            }

            public final void m17104a(String str, Object obj, boolean z) {
                if ("subscribe_status".equals(str)) {
                    m17093a((GraphQLSubscribeStatus) obj);
                } else if ("video_channel_is_viewer_following".equals(str)) {
                    m17094a(((Boolean) obj).booleanValue());
                }
            }

            @Nullable
            private GraphQLObjectType m17095j() {
                if (this.b != null && this.f10740d == null) {
                    this.f10740d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
                }
                return this.f10740d;
            }

            @Nullable
            private String m17096k() {
                this.f10741e = super.a(this.f10741e, 1);
                return this.f10741e;
            }

            @Nullable
            private GraphQLSubscribeStatus m17097l() {
                this.f10742f = (GraphQLSubscribeStatus) super.b(this.f10742f, 2, GraphQLSubscribeStatus.class, GraphQLSubscribeStatus.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
                return this.f10742f;
            }

            private void m17093a(GraphQLSubscribeStatus graphQLSubscribeStatus) {
                this.f10742f = graphQLSubscribeStatus;
                if (this.b != null && this.b.d) {
                    this.b.a(this.c, 2, graphQLSubscribeStatus != null ? graphQLSubscribeStatus.name() : null);
                }
            }

            private boolean m17098m() {
                a(0, 3);
                return this.f10743g;
            }

            private void m17094a(boolean z) {
                this.f10743g = z;
                if (this.b != null && this.b.d) {
                    this.b.a(this.c, 3, z);
                }
            }

            @Nullable
            public final String m17101a() {
                return m17096k();
            }

            public final int jK_() {
                return 63093205;
            }

            public final GraphQLVisitableModel m17100a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m17099a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m17095j());
                int b = flatBufferBuilder.b(m17096k());
                int a2 = flatBufferBuilder.a(m17097l());
                flatBufferBuilder.c(4);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.b(1, b);
                flatBufferBuilder.b(2, a2);
                flatBufferBuilder.a(3, this.f10743g);
                i();
                return flatBufferBuilder.d();
            }

            public final void m17102a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                super.a(mutableFlatBuffer, i, obj);
                this.f10743g = mutableFlatBuffer.a(i, 3);
            }
        }

        public ActorSubscribeCoreMutationFieldsModel() {
            super(1);
        }

        @Nullable
        private SubscribeeModel m17105a() {
            this.f10744d = (SubscribeeModel) super.a(this.f10744d, 0, SubscribeeModel.class);
            return this.f10744d;
        }

        public final int jK_() {
            return 1753781848;
        }

        public final GraphQLVisitableModel m17107a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m17105a() != null) {
                SubscribeeModel subscribeeModel = (SubscribeeModel) graphQLModelMutatingVisitor.b(m17105a());
                if (m17105a() != subscribeeModel) {
                    graphQLVisitableModel = (ActorSubscribeCoreMutationFieldsModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f10744d = subscribeeModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m17106a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m17105a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 1006296830)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: maiden */
    public final class ActorUnsubscribeCoreMutationFieldsModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private UnsubscribeeModel f10749d;

        /* compiled from: maiden */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(ActorUnsubscribeCoreMutationFieldsModel.class, new Deserializer());
            }

            public Object m17108a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = ActorUnsubscribeCoreMutationFieldsParser.m17323a(jsonParser);
                Object actorUnsubscribeCoreMutationFieldsModel = new ActorUnsubscribeCoreMutationFieldsModel();
                ((BaseModel) actorUnsubscribeCoreMutationFieldsModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (actorUnsubscribeCoreMutationFieldsModel instanceof Postprocessable) {
                    return ((Postprocessable) actorUnsubscribeCoreMutationFieldsModel).a();
                }
                return actorUnsubscribeCoreMutationFieldsModel;
            }
        }

        /* compiled from: maiden */
        public class Serializer extends JsonSerializer<ActorUnsubscribeCoreMutationFieldsModel> {
            public final void m17109a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                ActorUnsubscribeCoreMutationFieldsModel actorUnsubscribeCoreMutationFieldsModel = (ActorUnsubscribeCoreMutationFieldsModel) obj;
                if (actorUnsubscribeCoreMutationFieldsModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(actorUnsubscribeCoreMutationFieldsModel.m17125a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    actorUnsubscribeCoreMutationFieldsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = actorUnsubscribeCoreMutationFieldsModel.w_();
                int u_ = actorUnsubscribeCoreMutationFieldsModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("unsubscribee");
                    UnsubscribeeParser.m17322a(mutableFlatBuffer, g, jsonGenerator);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(ActorUnsubscribeCoreMutationFieldsModel.class, new Serializer());
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -751522047)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: maiden */
        public final class UnsubscribeeModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
            @Nullable
            private GraphQLObjectType f10745d;
            @Nullable
            private String f10746e;
            @Nullable
            private GraphQLSubscribeStatus f10747f;
            private boolean f10748g;

            /* compiled from: maiden */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(UnsubscribeeModel.class, new Deserializer());
                }

                public Object m17110a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(UnsubscribeeParser.m17321a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object unsubscribeeModel = new UnsubscribeeModel();
                    ((BaseModel) unsubscribeeModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (unsubscribeeModel instanceof Postprocessable) {
                        return ((Postprocessable) unsubscribeeModel).a();
                    }
                    return unsubscribeeModel;
                }
            }

            /* compiled from: maiden */
            public class Serializer extends JsonSerializer<UnsubscribeeModel> {
                public final void m17111a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    UnsubscribeeModel unsubscribeeModel = (UnsubscribeeModel) obj;
                    if (unsubscribeeModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(unsubscribeeModel.m17118a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        unsubscribeeModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    UnsubscribeeParser.m17322a(unsubscribeeModel.w_(), unsubscribeeModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(UnsubscribeeModel.class, new Serializer());
                }
            }

            public UnsubscribeeModel() {
                super(4);
            }

            public final void m17122a(String str, ConsistencyTuple consistencyTuple) {
                if ("subscribe_status".equals(str)) {
                    consistencyTuple.a = m17116l();
                    consistencyTuple.b = u_();
                    consistencyTuple.c = 2;
                } else if ("video_channel_is_viewer_following".equals(str)) {
                    consistencyTuple.a = Boolean.valueOf(m17117m());
                    consistencyTuple.b = u_();
                    consistencyTuple.c = 3;
                } else {
                    consistencyTuple.a();
                }
            }

            public final void m17123a(String str, Object obj, boolean z) {
                if ("subscribe_status".equals(str)) {
                    m17112a((GraphQLSubscribeStatus) obj);
                } else if ("video_channel_is_viewer_following".equals(str)) {
                    m17113a(((Boolean) obj).booleanValue());
                }
            }

            @Nullable
            private GraphQLObjectType m17114j() {
                if (this.b != null && this.f10745d == null) {
                    this.f10745d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
                }
                return this.f10745d;
            }

            @Nullable
            private String m17115k() {
                this.f10746e = super.a(this.f10746e, 1);
                return this.f10746e;
            }

            @Nullable
            private GraphQLSubscribeStatus m17116l() {
                this.f10747f = (GraphQLSubscribeStatus) super.b(this.f10747f, 2, GraphQLSubscribeStatus.class, GraphQLSubscribeStatus.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
                return this.f10747f;
            }

            private void m17112a(GraphQLSubscribeStatus graphQLSubscribeStatus) {
                this.f10747f = graphQLSubscribeStatus;
                if (this.b != null && this.b.d) {
                    this.b.a(this.c, 2, graphQLSubscribeStatus != null ? graphQLSubscribeStatus.name() : null);
                }
            }

            private boolean m17117m() {
                a(0, 3);
                return this.f10748g;
            }

            private void m17113a(boolean z) {
                this.f10748g = z;
                if (this.b != null && this.b.d) {
                    this.b.a(this.c, 3, z);
                }
            }

            @Nullable
            public final String m17120a() {
                return m17115k();
            }

            public final int jK_() {
                return 63093205;
            }

            public final GraphQLVisitableModel m17119a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m17118a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m17114j());
                int b = flatBufferBuilder.b(m17115k());
                int a2 = flatBufferBuilder.a(m17116l());
                flatBufferBuilder.c(4);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.b(1, b);
                flatBufferBuilder.b(2, a2);
                flatBufferBuilder.a(3, this.f10748g);
                i();
                return flatBufferBuilder.d();
            }

            public final void m17121a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                super.a(mutableFlatBuffer, i, obj);
                this.f10748g = mutableFlatBuffer.a(i, 3);
            }
        }

        public ActorUnsubscribeCoreMutationFieldsModel() {
            super(1);
        }

        @Nullable
        private UnsubscribeeModel m17124a() {
            this.f10749d = (UnsubscribeeModel) super.a(this.f10749d, 0, UnsubscribeeModel.class);
            return this.f10749d;
        }

        public final int jK_() {
            return 1272758449;
        }

        public final GraphQLVisitableModel m17126a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m17124a() != null) {
                UnsubscribeeModel unsubscribeeModel = (UnsubscribeeModel) graphQLModelMutatingVisitor.b(m17124a());
                if (m17124a() != unsubscribeeModel) {
                    graphQLVisitableModel = (ActorUnsubscribeCoreMutationFieldsModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f10749d = unsubscribeeModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m17125a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m17124a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 1367079589)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: maiden */
    public final class ContactInviteCoreMutationFieldsModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private ContactPointModel f10753d;

        /* compiled from: maiden */
        public final class Builder {
            @Nullable
            public ContactPointModel f10750a;
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1787905591)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: maiden */
        public final class ContactPointModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel {
            @Nullable
            private GraphQLObjectType f10751d;
            @Nullable
            private String f10752e;

            /* compiled from: maiden */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(ContactPointModel.class, new Deserializer());
                }

                public Object m17127a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(ContactPointParser.m17324a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object contactPointModel = new ContactPointModel();
                    ((BaseModel) contactPointModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (contactPointModel instanceof Postprocessable) {
                        return ((Postprocessable) contactPointModel).a();
                    }
                    return contactPointModel;
                }
            }

            /* compiled from: maiden */
            public class Serializer extends JsonSerializer<ContactPointModel> {
                public final void m17128a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    ContactPointModel contactPointModel = (ContactPointModel) obj;
                    if (contactPointModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(contactPointModel.m17131a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        contactPointModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    ContactPointParser.m17325a(contactPointModel.w_(), contactPointModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(ContactPointModel.class, new Serializer());
                }
            }

            public ContactPointModel() {
                super(2);
            }

            @Nullable
            private GraphQLObjectType m17129j() {
                if (this.b != null && this.f10751d == null) {
                    this.f10751d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
                }
                return this.f10751d;
            }

            @Nullable
            private String m17130k() {
                this.f10752e = super.a(this.f10752e, 1);
                return this.f10752e;
            }

            @Nullable
            public final String m17133a() {
                return m17130k();
            }

            public final int jK_() {
                return 1428236656;
            }

            public final GraphQLVisitableModel m17132a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m17131a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m17129j());
                int b = flatBufferBuilder.b(m17130k());
                flatBufferBuilder.c(2);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.b(1, b);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: maiden */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(ContactInviteCoreMutationFieldsModel.class, new Deserializer());
            }

            public Object m17134a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = ContactInviteCoreMutationFieldsParser.m17326a(jsonParser);
                Object contactInviteCoreMutationFieldsModel = new ContactInviteCoreMutationFieldsModel();
                ((BaseModel) contactInviteCoreMutationFieldsModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (contactInviteCoreMutationFieldsModel instanceof Postprocessable) {
                    return ((Postprocessable) contactInviteCoreMutationFieldsModel).a();
                }
                return contactInviteCoreMutationFieldsModel;
            }
        }

        /* compiled from: maiden */
        public class Serializer extends JsonSerializer<ContactInviteCoreMutationFieldsModel> {
            public final void m17135a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                ContactInviteCoreMutationFieldsModel contactInviteCoreMutationFieldsModel = (ContactInviteCoreMutationFieldsModel) obj;
                if (contactInviteCoreMutationFieldsModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(contactInviteCoreMutationFieldsModel.m17137a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    contactInviteCoreMutationFieldsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = contactInviteCoreMutationFieldsModel.w_();
                int u_ = contactInviteCoreMutationFieldsModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("contact_point");
                    ContactPointParser.m17325a(mutableFlatBuffer, g, jsonGenerator);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(ContactInviteCoreMutationFieldsModel.class, new Serializer());
            }
        }

        public ContactInviteCoreMutationFieldsModel() {
            super(1);
        }

        public ContactInviteCoreMutationFieldsModel(MutableFlatBuffer mutableFlatBuffer) {
            super(1);
            a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
        }

        @Nullable
        private ContactPointModel m17136a() {
            this.f10753d = (ContactPointModel) super.a(this.f10753d, 0, ContactPointModel.class);
            return this.f10753d;
        }

        public final int jK_() {
            return -2071473244;
        }

        public final GraphQLVisitableModel m17138a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m17136a() != null) {
                ContactPointModel contactPointModel = (ContactPointModel) graphQLModelMutatingVisitor.b(m17136a());
                if (m17136a() != contactPointModel) {
                    graphQLVisitableModel = (ContactInviteCoreMutationFieldsModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f10753d = contactPointModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m17137a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m17136a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -896797041)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: maiden */
    public final class FriendRemoveCoreMutationFieldsModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private UnfriendedUserModel f10761d;

        /* compiled from: maiden */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(FriendRemoveCoreMutationFieldsModel.class, new Deserializer());
            }

            public Object m17139a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = FriendRemoveCoreMutationFieldsParser.m17329a(jsonParser);
                Object friendRemoveCoreMutationFieldsModel = new FriendRemoveCoreMutationFieldsModel();
                ((BaseModel) friendRemoveCoreMutationFieldsModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (friendRemoveCoreMutationFieldsModel instanceof Postprocessable) {
                    return ((Postprocessable) friendRemoveCoreMutationFieldsModel).a();
                }
                return friendRemoveCoreMutationFieldsModel;
            }
        }

        /* compiled from: maiden */
        public class Serializer extends JsonSerializer<FriendRemoveCoreMutationFieldsModel> {
            public final void m17140a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                FriendRemoveCoreMutationFieldsModel friendRemoveCoreMutationFieldsModel = (FriendRemoveCoreMutationFieldsModel) obj;
                if (friendRemoveCoreMutationFieldsModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(friendRemoveCoreMutationFieldsModel.m17161a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    friendRemoveCoreMutationFieldsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = friendRemoveCoreMutationFieldsModel.w_();
                int u_ = friendRemoveCoreMutationFieldsModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("unfriended_user");
                    UnfriendedUserParser.m17328a(mutableFlatBuffer, g, jsonGenerator);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(FriendRemoveCoreMutationFieldsModel.class, new Serializer());
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -342012956)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: maiden */
        public final class UnfriendedUserModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
            @Nullable
            private GraphQLObjectType f10754d;
            private boolean f10755e;
            private boolean f10756f;
            private boolean f10757g;
            @Nullable
            private GraphQLFriendshipStatus f10758h;
            @Nullable
            private String f10759i;
            @Nullable
            private GraphQLSubscribeStatus f10760j;

            /* compiled from: maiden */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(UnfriendedUserModel.class, new Deserializer());
                }

                public Object m17141a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(UnfriendedUserParser.m17327a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object unfriendedUserModel = new UnfriendedUserModel();
                    ((BaseModel) unfriendedUserModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (unfriendedUserModel instanceof Postprocessable) {
                        return ((Postprocessable) unfriendedUserModel).a();
                    }
                    return unfriendedUserModel;
                }
            }

            /* compiled from: maiden */
            public class Serializer extends JsonSerializer<UnfriendedUserModel> {
                public final void m17142a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    UnfriendedUserModel unfriendedUserModel = (UnfriendedUserModel) obj;
                    if (unfriendedUserModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(unfriendedUserModel.m17154a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        unfriendedUserModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    UnfriendedUserParser.m17328a(unfriendedUserModel.w_(), unfriendedUserModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(UnfriendedUserModel.class, new Serializer());
                }
            }

            public UnfriendedUserModel() {
                super(7);
            }

            public final void m17158a(String str, ConsistencyTuple consistencyTuple) {
                if ("can_viewer_message".equals(str)) {
                    consistencyTuple.a = Boolean.valueOf(m17149l());
                    consistencyTuple.b = u_();
                    consistencyTuple.c = 1;
                } else if ("can_viewer_poke".equals(str)) {
                    consistencyTuple.a = Boolean.valueOf(m17150m());
                    consistencyTuple.b = u_();
                    consistencyTuple.c = 2;
                } else if ("can_viewer_post".equals(str)) {
                    consistencyTuple.a = Boolean.valueOf(m17151n());
                    consistencyTuple.b = u_();
                    consistencyTuple.c = 3;
                } else if ("friendship_status".equals(str)) {
                    consistencyTuple.a = m17160j();
                    consistencyTuple.b = u_();
                    consistencyTuple.c = 4;
                } else if ("subscribe_status".equals(str)) {
                    consistencyTuple.a = m17153p();
                    consistencyTuple.b = u_();
                    consistencyTuple.c = 6;
                } else {
                    consistencyTuple.a();
                }
            }

            public final void m17159a(String str, Object obj, boolean z) {
                if ("can_viewer_message".equals(str)) {
                    m17145a(((Boolean) obj).booleanValue());
                } else if ("can_viewer_poke".equals(str)) {
                    m17146b(((Boolean) obj).booleanValue());
                } else if ("can_viewer_post".equals(str)) {
                    m17147c(((Boolean) obj).booleanValue());
                } else if ("friendship_status".equals(str)) {
                    m17143a((GraphQLFriendshipStatus) obj);
                } else if ("subscribe_status".equals(str)) {
                    m17144a((GraphQLSubscribeStatus) obj);
                }
            }

            @Nullable
            private GraphQLObjectType m17148k() {
                if (this.b != null && this.f10754d == null) {
                    this.f10754d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
                }
                return this.f10754d;
            }

            private boolean m17149l() {
                a(0, 1);
                return this.f10755e;
            }

            private void m17145a(boolean z) {
                this.f10755e = z;
                if (this.b != null && this.b.d) {
                    this.b.a(this.c, 1, z);
                }
            }

            private boolean m17150m() {
                a(0, 2);
                return this.f10756f;
            }

            private void m17146b(boolean z) {
                this.f10756f = z;
                if (this.b != null && this.b.d) {
                    this.b.a(this.c, 2, z);
                }
            }

            private boolean m17151n() {
                a(0, 3);
                return this.f10757g;
            }

            private void m17147c(boolean z) {
                this.f10757g = z;
                if (this.b != null && this.b.d) {
                    this.b.a(this.c, 3, z);
                }
            }

            @Nullable
            public final GraphQLFriendshipStatus m17160j() {
                this.f10758h = (GraphQLFriendshipStatus) super.b(this.f10758h, 4, GraphQLFriendshipStatus.class, GraphQLFriendshipStatus.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
                return this.f10758h;
            }

            private void m17143a(GraphQLFriendshipStatus graphQLFriendshipStatus) {
                this.f10758h = graphQLFriendshipStatus;
                if (this.b != null && this.b.d) {
                    this.b.a(this.c, 4, graphQLFriendshipStatus != null ? graphQLFriendshipStatus.name() : null);
                }
            }

            @Nullable
            private String m17152o() {
                this.f10759i = super.a(this.f10759i, 5);
                return this.f10759i;
            }

            @Nullable
            private GraphQLSubscribeStatus m17153p() {
                this.f10760j = (GraphQLSubscribeStatus) super.b(this.f10760j, 6, GraphQLSubscribeStatus.class, GraphQLSubscribeStatus.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
                return this.f10760j;
            }

            private void m17144a(GraphQLSubscribeStatus graphQLSubscribeStatus) {
                this.f10760j = graphQLSubscribeStatus;
                if (this.b != null && this.b.d) {
                    this.b.a(this.c, 6, graphQLSubscribeStatus != null ? graphQLSubscribeStatus.name() : null);
                }
            }

            @Nullable
            public final String m17156a() {
                return m17152o();
            }

            public final int jK_() {
                return 2645995;
            }

            public final GraphQLVisitableModel m17155a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m17154a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m17148k());
                int a2 = flatBufferBuilder.a(m17160j());
                int b = flatBufferBuilder.b(m17152o());
                int a3 = flatBufferBuilder.a(m17153p());
                flatBufferBuilder.c(7);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.a(1, this.f10755e);
                flatBufferBuilder.a(2, this.f10756f);
                flatBufferBuilder.a(3, this.f10757g);
                flatBufferBuilder.b(4, a2);
                flatBufferBuilder.b(5, b);
                flatBufferBuilder.b(6, a3);
                i();
                return flatBufferBuilder.d();
            }

            public final void m17157a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                super.a(mutableFlatBuffer, i, obj);
                this.f10755e = mutableFlatBuffer.a(i, 1);
                this.f10756f = mutableFlatBuffer.a(i, 2);
                this.f10757g = mutableFlatBuffer.a(i, 3);
            }
        }

        public FriendRemoveCoreMutationFieldsModel() {
            super(1);
        }

        @Nullable
        public final UnfriendedUserModel m17162a() {
            this.f10761d = (UnfriendedUserModel) super.a(this.f10761d, 0, UnfriendedUserModel.class);
            return this.f10761d;
        }

        public final int jK_() {
            return -1352201013;
        }

        public final GraphQLVisitableModel m17163a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m17162a() != null) {
                UnfriendedUserModel unfriendedUserModel = (UnfriendedUserModel) graphQLModelMutatingVisitor.b(m17162a());
                if (m17162a() != unfriendedUserModel) {
                    graphQLVisitableModel = (FriendRemoveCoreMutationFieldsModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f10761d = unfriendedUserModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m17161a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m17162a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 1353348857)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: maiden */
    public final class FriendRequestAcceptCoreMutationFieldsModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private FriendRequesterModel f10769d;

        /* compiled from: maiden */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(FriendRequestAcceptCoreMutationFieldsModel.class, new Deserializer());
            }

            public Object m17164a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = FriendRequestAcceptCoreMutationFieldsParser.m17332a(jsonParser);
                Object friendRequestAcceptCoreMutationFieldsModel = new FriendRequestAcceptCoreMutationFieldsModel();
                ((BaseModel) friendRequestAcceptCoreMutationFieldsModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (friendRequestAcceptCoreMutationFieldsModel instanceof Postprocessable) {
                    return ((Postprocessable) friendRequestAcceptCoreMutationFieldsModel).a();
                }
                return friendRequestAcceptCoreMutationFieldsModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -342012956)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: maiden */
        public final class FriendRequesterModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
            @Nullable
            private GraphQLObjectType f10762d;
            private boolean f10763e;
            private boolean f10764f;
            private boolean f10765g;
            @Nullable
            private GraphQLFriendshipStatus f10766h;
            @Nullable
            private String f10767i;
            @Nullable
            private GraphQLSubscribeStatus f10768j;

            /* compiled from: maiden */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(FriendRequesterModel.class, new Deserializer());
                }

                public Object m17165a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(FriendRequesterParser.m17330a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object friendRequesterModel = new FriendRequesterModel();
                    ((BaseModel) friendRequesterModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (friendRequesterModel instanceof Postprocessable) {
                        return ((Postprocessable) friendRequesterModel).a();
                    }
                    return friendRequesterModel;
                }
            }

            /* compiled from: maiden */
            public class Serializer extends JsonSerializer<FriendRequesterModel> {
                public final void m17166a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    FriendRequesterModel friendRequesterModel = (FriendRequesterModel) obj;
                    if (friendRequesterModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(friendRequesterModel.m17178a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        friendRequesterModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    FriendRequesterParser.m17331a(friendRequesterModel.w_(), friendRequesterModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(FriendRequesterModel.class, new Serializer());
                }
            }

            public FriendRequesterModel() {
                super(7);
            }

            public final void m17182a(String str, ConsistencyTuple consistencyTuple) {
                if ("can_viewer_message".equals(str)) {
                    consistencyTuple.a = Boolean.valueOf(m17173l());
                    consistencyTuple.b = u_();
                    consistencyTuple.c = 1;
                } else if ("can_viewer_poke".equals(str)) {
                    consistencyTuple.a = Boolean.valueOf(m17174m());
                    consistencyTuple.b = u_();
                    consistencyTuple.c = 2;
                } else if ("can_viewer_post".equals(str)) {
                    consistencyTuple.a = Boolean.valueOf(m17175n());
                    consistencyTuple.b = u_();
                    consistencyTuple.c = 3;
                } else if ("friendship_status".equals(str)) {
                    consistencyTuple.a = m17184j();
                    consistencyTuple.b = u_();
                    consistencyTuple.c = 4;
                } else if ("subscribe_status".equals(str)) {
                    consistencyTuple.a = m17177p();
                    consistencyTuple.b = u_();
                    consistencyTuple.c = 6;
                } else {
                    consistencyTuple.a();
                }
            }

            public final void m17183a(String str, Object obj, boolean z) {
                if ("can_viewer_message".equals(str)) {
                    m17169a(((Boolean) obj).booleanValue());
                } else if ("can_viewer_poke".equals(str)) {
                    m17170b(((Boolean) obj).booleanValue());
                } else if ("can_viewer_post".equals(str)) {
                    m17171c(((Boolean) obj).booleanValue());
                } else if ("friendship_status".equals(str)) {
                    m17167a((GraphQLFriendshipStatus) obj);
                } else if ("subscribe_status".equals(str)) {
                    m17168a((GraphQLSubscribeStatus) obj);
                }
            }

            @Nullable
            private GraphQLObjectType m17172k() {
                if (this.b != null && this.f10762d == null) {
                    this.f10762d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
                }
                return this.f10762d;
            }

            private boolean m17173l() {
                a(0, 1);
                return this.f10763e;
            }

            private void m17169a(boolean z) {
                this.f10763e = z;
                if (this.b != null && this.b.d) {
                    this.b.a(this.c, 1, z);
                }
            }

            private boolean m17174m() {
                a(0, 2);
                return this.f10764f;
            }

            private void m17170b(boolean z) {
                this.f10764f = z;
                if (this.b != null && this.b.d) {
                    this.b.a(this.c, 2, z);
                }
            }

            private boolean m17175n() {
                a(0, 3);
                return this.f10765g;
            }

            private void m17171c(boolean z) {
                this.f10765g = z;
                if (this.b != null && this.b.d) {
                    this.b.a(this.c, 3, z);
                }
            }

            @Nullable
            public final GraphQLFriendshipStatus m17184j() {
                this.f10766h = (GraphQLFriendshipStatus) super.b(this.f10766h, 4, GraphQLFriendshipStatus.class, GraphQLFriendshipStatus.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
                return this.f10766h;
            }

            private void m17167a(GraphQLFriendshipStatus graphQLFriendshipStatus) {
                this.f10766h = graphQLFriendshipStatus;
                if (this.b != null && this.b.d) {
                    this.b.a(this.c, 4, graphQLFriendshipStatus != null ? graphQLFriendshipStatus.name() : null);
                }
            }

            @Nullable
            private String m17176o() {
                this.f10767i = super.a(this.f10767i, 5);
                return this.f10767i;
            }

            @Nullable
            private GraphQLSubscribeStatus m17177p() {
                this.f10768j = (GraphQLSubscribeStatus) super.b(this.f10768j, 6, GraphQLSubscribeStatus.class, GraphQLSubscribeStatus.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
                return this.f10768j;
            }

            private void m17168a(GraphQLSubscribeStatus graphQLSubscribeStatus) {
                this.f10768j = graphQLSubscribeStatus;
                if (this.b != null && this.b.d) {
                    this.b.a(this.c, 6, graphQLSubscribeStatus != null ? graphQLSubscribeStatus.name() : null);
                }
            }

            @Nullable
            public final String m17180a() {
                return m17176o();
            }

            public final int jK_() {
                return 2645995;
            }

            public final GraphQLVisitableModel m17179a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m17178a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m17172k());
                int a2 = flatBufferBuilder.a(m17184j());
                int b = flatBufferBuilder.b(m17176o());
                int a3 = flatBufferBuilder.a(m17177p());
                flatBufferBuilder.c(7);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.a(1, this.f10763e);
                flatBufferBuilder.a(2, this.f10764f);
                flatBufferBuilder.a(3, this.f10765g);
                flatBufferBuilder.b(4, a2);
                flatBufferBuilder.b(5, b);
                flatBufferBuilder.b(6, a3);
                i();
                return flatBufferBuilder.d();
            }

            public final void m17181a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                super.a(mutableFlatBuffer, i, obj);
                this.f10763e = mutableFlatBuffer.a(i, 1);
                this.f10764f = mutableFlatBuffer.a(i, 2);
                this.f10765g = mutableFlatBuffer.a(i, 3);
            }
        }

        /* compiled from: maiden */
        public class Serializer extends JsonSerializer<FriendRequestAcceptCoreMutationFieldsModel> {
            public final void m17185a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                FriendRequestAcceptCoreMutationFieldsModel friendRequestAcceptCoreMutationFieldsModel = (FriendRequestAcceptCoreMutationFieldsModel) obj;
                if (friendRequestAcceptCoreMutationFieldsModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(friendRequestAcceptCoreMutationFieldsModel.m17186a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    friendRequestAcceptCoreMutationFieldsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = friendRequestAcceptCoreMutationFieldsModel.w_();
                int u_ = friendRequestAcceptCoreMutationFieldsModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("friend_requester");
                    FriendRequesterParser.m17331a(mutableFlatBuffer, g, jsonGenerator);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(FriendRequestAcceptCoreMutationFieldsModel.class, new Serializer());
            }
        }

        public FriendRequestAcceptCoreMutationFieldsModel() {
            super(1);
        }

        @Nullable
        public final FriendRequesterModel m17187a() {
            this.f10769d = (FriendRequesterModel) super.a(this.f10769d, 0, FriendRequesterModel.class);
            return this.f10769d;
        }

        public final int jK_() {
            return 276699764;
        }

        public final GraphQLVisitableModel m17188a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m17187a() != null) {
                FriendRequesterModel friendRequesterModel = (FriendRequesterModel) graphQLModelMutatingVisitor.b(m17187a());
                if (m17187a() != friendRequesterModel) {
                    graphQLVisitableModel = (FriendRequestAcceptCoreMutationFieldsModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f10769d = friendRequesterModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m17186a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m17187a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 346028417)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: maiden */
    public final class FriendRequestCancelCoreMutationFieldsModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private CancelledFriendRequesteeModel f10777d;

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -342012956)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: maiden */
        public final class CancelledFriendRequesteeModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
            @Nullable
            private GraphQLObjectType f10770d;
            private boolean f10771e;
            private boolean f10772f;
            private boolean f10773g;
            @Nullable
            private GraphQLFriendshipStatus f10774h;
            @Nullable
            private String f10775i;
            @Nullable
            private GraphQLSubscribeStatus f10776j;

            /* compiled from: maiden */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(CancelledFriendRequesteeModel.class, new Deserializer());
                }

                public Object m17189a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(CancelledFriendRequesteeParser.m17333a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object cancelledFriendRequesteeModel = new CancelledFriendRequesteeModel();
                    ((BaseModel) cancelledFriendRequesteeModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (cancelledFriendRequesteeModel instanceof Postprocessable) {
                        return ((Postprocessable) cancelledFriendRequesteeModel).a();
                    }
                    return cancelledFriendRequesteeModel;
                }
            }

            /* compiled from: maiden */
            public class Serializer extends JsonSerializer<CancelledFriendRequesteeModel> {
                public final void m17190a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    CancelledFriendRequesteeModel cancelledFriendRequesteeModel = (CancelledFriendRequesteeModel) obj;
                    if (cancelledFriendRequesteeModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(cancelledFriendRequesteeModel.m17202a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        cancelledFriendRequesteeModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    CancelledFriendRequesteeParser.m17334a(cancelledFriendRequesteeModel.w_(), cancelledFriendRequesteeModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(CancelledFriendRequesteeModel.class, new Serializer());
                }
            }

            public CancelledFriendRequesteeModel() {
                super(7);
            }

            public final void m17206a(String str, ConsistencyTuple consistencyTuple) {
                if ("can_viewer_message".equals(str)) {
                    consistencyTuple.a = Boolean.valueOf(m17197l());
                    consistencyTuple.b = u_();
                    consistencyTuple.c = 1;
                } else if ("can_viewer_poke".equals(str)) {
                    consistencyTuple.a = Boolean.valueOf(m17198m());
                    consistencyTuple.b = u_();
                    consistencyTuple.c = 2;
                } else if ("can_viewer_post".equals(str)) {
                    consistencyTuple.a = Boolean.valueOf(m17199n());
                    consistencyTuple.b = u_();
                    consistencyTuple.c = 3;
                } else if ("friendship_status".equals(str)) {
                    consistencyTuple.a = m17208j();
                    consistencyTuple.b = u_();
                    consistencyTuple.c = 4;
                } else if ("subscribe_status".equals(str)) {
                    consistencyTuple.a = m17201p();
                    consistencyTuple.b = u_();
                    consistencyTuple.c = 6;
                } else {
                    consistencyTuple.a();
                }
            }

            public final void m17207a(String str, Object obj, boolean z) {
                if ("can_viewer_message".equals(str)) {
                    m17193a(((Boolean) obj).booleanValue());
                } else if ("can_viewer_poke".equals(str)) {
                    m17194b(((Boolean) obj).booleanValue());
                } else if ("can_viewer_post".equals(str)) {
                    m17195c(((Boolean) obj).booleanValue());
                } else if ("friendship_status".equals(str)) {
                    m17191a((GraphQLFriendshipStatus) obj);
                } else if ("subscribe_status".equals(str)) {
                    m17192a((GraphQLSubscribeStatus) obj);
                }
            }

            @Nullable
            private GraphQLObjectType m17196k() {
                if (this.b != null && this.f10770d == null) {
                    this.f10770d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
                }
                return this.f10770d;
            }

            private boolean m17197l() {
                a(0, 1);
                return this.f10771e;
            }

            private void m17193a(boolean z) {
                this.f10771e = z;
                if (this.b != null && this.b.d) {
                    this.b.a(this.c, 1, z);
                }
            }

            private boolean m17198m() {
                a(0, 2);
                return this.f10772f;
            }

            private void m17194b(boolean z) {
                this.f10772f = z;
                if (this.b != null && this.b.d) {
                    this.b.a(this.c, 2, z);
                }
            }

            private boolean m17199n() {
                a(0, 3);
                return this.f10773g;
            }

            private void m17195c(boolean z) {
                this.f10773g = z;
                if (this.b != null && this.b.d) {
                    this.b.a(this.c, 3, z);
                }
            }

            @Nullable
            public final GraphQLFriendshipStatus m17208j() {
                this.f10774h = (GraphQLFriendshipStatus) super.b(this.f10774h, 4, GraphQLFriendshipStatus.class, GraphQLFriendshipStatus.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
                return this.f10774h;
            }

            private void m17191a(GraphQLFriendshipStatus graphQLFriendshipStatus) {
                this.f10774h = graphQLFriendshipStatus;
                if (this.b != null && this.b.d) {
                    this.b.a(this.c, 4, graphQLFriendshipStatus != null ? graphQLFriendshipStatus.name() : null);
                }
            }

            @Nullable
            private String m17200o() {
                this.f10775i = super.a(this.f10775i, 5);
                return this.f10775i;
            }

            @Nullable
            private GraphQLSubscribeStatus m17201p() {
                this.f10776j = (GraphQLSubscribeStatus) super.b(this.f10776j, 6, GraphQLSubscribeStatus.class, GraphQLSubscribeStatus.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
                return this.f10776j;
            }

            private void m17192a(GraphQLSubscribeStatus graphQLSubscribeStatus) {
                this.f10776j = graphQLSubscribeStatus;
                if (this.b != null && this.b.d) {
                    this.b.a(this.c, 6, graphQLSubscribeStatus != null ? graphQLSubscribeStatus.name() : null);
                }
            }

            @Nullable
            public final String m17204a() {
                return m17200o();
            }

            public final int jK_() {
                return 2645995;
            }

            public final GraphQLVisitableModel m17203a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m17202a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m17196k());
                int a2 = flatBufferBuilder.a(m17208j());
                int b = flatBufferBuilder.b(m17200o());
                int a3 = flatBufferBuilder.a(m17201p());
                flatBufferBuilder.c(7);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.a(1, this.f10771e);
                flatBufferBuilder.a(2, this.f10772f);
                flatBufferBuilder.a(3, this.f10773g);
                flatBufferBuilder.b(4, a2);
                flatBufferBuilder.b(5, b);
                flatBufferBuilder.b(6, a3);
                i();
                return flatBufferBuilder.d();
            }

            public final void m17205a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                super.a(mutableFlatBuffer, i, obj);
                this.f10771e = mutableFlatBuffer.a(i, 1);
                this.f10772f = mutableFlatBuffer.a(i, 2);
                this.f10773g = mutableFlatBuffer.a(i, 3);
            }
        }

        /* compiled from: maiden */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(FriendRequestCancelCoreMutationFieldsModel.class, new Deserializer());
            }

            public Object m17209a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = FriendRequestCancelCoreMutationFieldsParser.m17335a(jsonParser);
                Object friendRequestCancelCoreMutationFieldsModel = new FriendRequestCancelCoreMutationFieldsModel();
                ((BaseModel) friendRequestCancelCoreMutationFieldsModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (friendRequestCancelCoreMutationFieldsModel instanceof Postprocessable) {
                    return ((Postprocessable) friendRequestCancelCoreMutationFieldsModel).a();
                }
                return friendRequestCancelCoreMutationFieldsModel;
            }
        }

        /* compiled from: maiden */
        public class Serializer extends JsonSerializer<FriendRequestCancelCoreMutationFieldsModel> {
            public final void m17210a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                FriendRequestCancelCoreMutationFieldsModel friendRequestCancelCoreMutationFieldsModel = (FriendRequestCancelCoreMutationFieldsModel) obj;
                if (friendRequestCancelCoreMutationFieldsModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(friendRequestCancelCoreMutationFieldsModel.m17211a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    friendRequestCancelCoreMutationFieldsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = friendRequestCancelCoreMutationFieldsModel.w_();
                int u_ = friendRequestCancelCoreMutationFieldsModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("cancelled_friend_requestee");
                    CancelledFriendRequesteeParser.m17334a(mutableFlatBuffer, g, jsonGenerator);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(FriendRequestCancelCoreMutationFieldsModel.class, new Serializer());
            }
        }

        public FriendRequestCancelCoreMutationFieldsModel() {
            super(1);
        }

        @Nullable
        public final CancelledFriendRequesteeModel m17212a() {
            this.f10777d = (CancelledFriendRequesteeModel) super.a(this.f10777d, 0, CancelledFriendRequesteeModel.class);
            return this.f10777d;
        }

        public final int jK_() {
            return 599740098;
        }

        public final GraphQLVisitableModel m17213a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m17212a() != null) {
                CancelledFriendRequesteeModel cancelledFriendRequesteeModel = (CancelledFriendRequesteeModel) graphQLModelMutatingVisitor.b(m17212a());
                if (m17212a() != cancelledFriendRequesteeModel) {
                    graphQLVisitableModel = (FriendRequestCancelCoreMutationFieldsModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f10777d = cancelledFriendRequesteeModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m17211a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m17212a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 513824725)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: maiden */
    public final class FriendRequestDeleteCoreMutationFieldsModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private FriendRequesterModel f10785d;

        /* compiled from: maiden */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(FriendRequestDeleteCoreMutationFieldsModel.class, new Deserializer());
            }

            public Object m17214a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = FriendRequestDeleteCoreMutationFieldsParser.m17338a(jsonParser);
                Object friendRequestDeleteCoreMutationFieldsModel = new FriendRequestDeleteCoreMutationFieldsModel();
                ((BaseModel) friendRequestDeleteCoreMutationFieldsModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (friendRequestDeleteCoreMutationFieldsModel instanceof Postprocessable) {
                    return ((Postprocessable) friendRequestDeleteCoreMutationFieldsModel).a();
                }
                return friendRequestDeleteCoreMutationFieldsModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -342012956)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: maiden */
        public final class FriendRequesterModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
            @Nullable
            private GraphQLObjectType f10778d;
            private boolean f10779e;
            private boolean f10780f;
            private boolean f10781g;
            @Nullable
            private GraphQLFriendshipStatus f10782h;
            @Nullable
            private String f10783i;
            @Nullable
            private GraphQLSubscribeStatus f10784j;

            /* compiled from: maiden */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(FriendRequesterModel.class, new Deserializer());
                }

                public Object m17215a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(FriendRequestDeleteCoreMutationFieldsParser.FriendRequesterParser.m17336a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object friendRequesterModel = new FriendRequesterModel();
                    ((BaseModel) friendRequesterModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (friendRequesterModel instanceof Postprocessable) {
                        return ((Postprocessable) friendRequesterModel).a();
                    }
                    return friendRequesterModel;
                }
            }

            /* compiled from: maiden */
            public class Serializer extends JsonSerializer<FriendRequesterModel> {
                public final void m17216a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    FriendRequesterModel friendRequesterModel = (FriendRequesterModel) obj;
                    if (friendRequesterModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(friendRequesterModel.m17228a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        friendRequesterModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    FriendRequestDeleteCoreMutationFieldsParser.FriendRequesterParser.m17337a(friendRequesterModel.w_(), friendRequesterModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(FriendRequesterModel.class, new Serializer());
                }
            }

            public FriendRequesterModel() {
                super(7);
            }

            public final void m17232a(String str, ConsistencyTuple consistencyTuple) {
                if ("can_viewer_message".equals(str)) {
                    consistencyTuple.a = Boolean.valueOf(m17223l());
                    consistencyTuple.b = u_();
                    consistencyTuple.c = 1;
                } else if ("can_viewer_poke".equals(str)) {
                    consistencyTuple.a = Boolean.valueOf(m17224m());
                    consistencyTuple.b = u_();
                    consistencyTuple.c = 2;
                } else if ("can_viewer_post".equals(str)) {
                    consistencyTuple.a = Boolean.valueOf(m17225n());
                    consistencyTuple.b = u_();
                    consistencyTuple.c = 3;
                } else if ("friendship_status".equals(str)) {
                    consistencyTuple.a = m17234j();
                    consistencyTuple.b = u_();
                    consistencyTuple.c = 4;
                } else if ("subscribe_status".equals(str)) {
                    consistencyTuple.a = m17227p();
                    consistencyTuple.b = u_();
                    consistencyTuple.c = 6;
                } else {
                    consistencyTuple.a();
                }
            }

            public final void m17233a(String str, Object obj, boolean z) {
                if ("can_viewer_message".equals(str)) {
                    m17219a(((Boolean) obj).booleanValue());
                } else if ("can_viewer_poke".equals(str)) {
                    m17220b(((Boolean) obj).booleanValue());
                } else if ("can_viewer_post".equals(str)) {
                    m17221c(((Boolean) obj).booleanValue());
                } else if ("friendship_status".equals(str)) {
                    m17217a((GraphQLFriendshipStatus) obj);
                } else if ("subscribe_status".equals(str)) {
                    m17218a((GraphQLSubscribeStatus) obj);
                }
            }

            @Nullable
            private GraphQLObjectType m17222k() {
                if (this.b != null && this.f10778d == null) {
                    this.f10778d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
                }
                return this.f10778d;
            }

            private boolean m17223l() {
                a(0, 1);
                return this.f10779e;
            }

            private void m17219a(boolean z) {
                this.f10779e = z;
                if (this.b != null && this.b.d) {
                    this.b.a(this.c, 1, z);
                }
            }

            private boolean m17224m() {
                a(0, 2);
                return this.f10780f;
            }

            private void m17220b(boolean z) {
                this.f10780f = z;
                if (this.b != null && this.b.d) {
                    this.b.a(this.c, 2, z);
                }
            }

            private boolean m17225n() {
                a(0, 3);
                return this.f10781g;
            }

            private void m17221c(boolean z) {
                this.f10781g = z;
                if (this.b != null && this.b.d) {
                    this.b.a(this.c, 3, z);
                }
            }

            @Nullable
            public final GraphQLFriendshipStatus m17234j() {
                this.f10782h = (GraphQLFriendshipStatus) super.b(this.f10782h, 4, GraphQLFriendshipStatus.class, GraphQLFriendshipStatus.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
                return this.f10782h;
            }

            private void m17217a(GraphQLFriendshipStatus graphQLFriendshipStatus) {
                this.f10782h = graphQLFriendshipStatus;
                if (this.b != null && this.b.d) {
                    this.b.a(this.c, 4, graphQLFriendshipStatus != null ? graphQLFriendshipStatus.name() : null);
                }
            }

            @Nullable
            private String m17226o() {
                this.f10783i = super.a(this.f10783i, 5);
                return this.f10783i;
            }

            @Nullable
            private GraphQLSubscribeStatus m17227p() {
                this.f10784j = (GraphQLSubscribeStatus) super.b(this.f10784j, 6, GraphQLSubscribeStatus.class, GraphQLSubscribeStatus.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
                return this.f10784j;
            }

            private void m17218a(GraphQLSubscribeStatus graphQLSubscribeStatus) {
                this.f10784j = graphQLSubscribeStatus;
                if (this.b != null && this.b.d) {
                    this.b.a(this.c, 6, graphQLSubscribeStatus != null ? graphQLSubscribeStatus.name() : null);
                }
            }

            @Nullable
            public final String m17230a() {
                return m17226o();
            }

            public final int jK_() {
                return 2645995;
            }

            public final GraphQLVisitableModel m17229a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m17228a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m17222k());
                int a2 = flatBufferBuilder.a(m17234j());
                int b = flatBufferBuilder.b(m17226o());
                int a3 = flatBufferBuilder.a(m17227p());
                flatBufferBuilder.c(7);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.a(1, this.f10779e);
                flatBufferBuilder.a(2, this.f10780f);
                flatBufferBuilder.a(3, this.f10781g);
                flatBufferBuilder.b(4, a2);
                flatBufferBuilder.b(5, b);
                flatBufferBuilder.b(6, a3);
                i();
                return flatBufferBuilder.d();
            }

            public final void m17231a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                super.a(mutableFlatBuffer, i, obj);
                this.f10779e = mutableFlatBuffer.a(i, 1);
                this.f10780f = mutableFlatBuffer.a(i, 2);
                this.f10781g = mutableFlatBuffer.a(i, 3);
            }
        }

        /* compiled from: maiden */
        public class Serializer extends JsonSerializer<FriendRequestDeleteCoreMutationFieldsModel> {
            public final void m17235a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                FriendRequestDeleteCoreMutationFieldsModel friendRequestDeleteCoreMutationFieldsModel = (FriendRequestDeleteCoreMutationFieldsModel) obj;
                if (friendRequestDeleteCoreMutationFieldsModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(friendRequestDeleteCoreMutationFieldsModel.m17236a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    friendRequestDeleteCoreMutationFieldsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = friendRequestDeleteCoreMutationFieldsModel.w_();
                int u_ = friendRequestDeleteCoreMutationFieldsModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("friend_requester");
                    FriendRequestDeleteCoreMutationFieldsParser.FriendRequesterParser.m17337a(mutableFlatBuffer, g, jsonGenerator);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(FriendRequestDeleteCoreMutationFieldsModel.class, new Serializer());
            }
        }

        public FriendRequestDeleteCoreMutationFieldsModel() {
            super(1);
        }

        @Nullable
        public final FriendRequesterModel m17237a() {
            this.f10785d = (FriendRequesterModel) super.a(this.f10785d, 0, FriendRequesterModel.class);
            return this.f10785d;
        }

        public final int jK_() {
            return 1269141361;
        }

        public final GraphQLVisitableModel m17238a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m17237a() != null) {
                FriendRequesterModel friendRequesterModel = (FriendRequesterModel) graphQLModelMutatingVisitor.b(m17237a());
                if (m17237a() != friendRequesterModel) {
                    graphQLVisitableModel = (FriendRequestDeleteCoreMutationFieldsModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f10785d = friendRequesterModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m17236a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m17237a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -1418022311)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: maiden */
    public final class FriendRequestSendCoreMutationFieldsModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private List<FriendRequesteesModel> f10793d;

        /* compiled from: maiden */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(FriendRequestSendCoreMutationFieldsModel.class, new Deserializer());
            }

            public Object m17239a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(FriendRequestSendCoreMutationFieldsParser.m17341a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object friendRequestSendCoreMutationFieldsModel = new FriendRequestSendCoreMutationFieldsModel();
                ((BaseModel) friendRequestSendCoreMutationFieldsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (friendRequestSendCoreMutationFieldsModel instanceof Postprocessable) {
                    return ((Postprocessable) friendRequestSendCoreMutationFieldsModel).a();
                }
                return friendRequestSendCoreMutationFieldsModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -342012956)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: maiden */
        public final class FriendRequesteesModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
            @Nullable
            private GraphQLObjectType f10786d;
            private boolean f10787e;
            private boolean f10788f;
            private boolean f10789g;
            @Nullable
            private GraphQLFriendshipStatus f10790h;
            @Nullable
            private String f10791i;
            @Nullable
            private GraphQLSubscribeStatus f10792j;

            /* compiled from: maiden */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(FriendRequesteesModel.class, new Deserializer());
                }

                public Object m17240a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(FriendRequesteesParser.m17340b(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object friendRequesteesModel = new FriendRequesteesModel();
                    ((BaseModel) friendRequesteesModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (friendRequesteesModel instanceof Postprocessable) {
                        return ((Postprocessable) friendRequesteesModel).a();
                    }
                    return friendRequesteesModel;
                }
            }

            /* compiled from: maiden */
            public class Serializer extends JsonSerializer<FriendRequesteesModel> {
                public final void m17241a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    FriendRequesteesModel friendRequesteesModel = (FriendRequesteesModel) obj;
                    if (friendRequesteesModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(friendRequesteesModel.m17253a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        friendRequesteesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    FriendRequesteesParser.m17339a(friendRequesteesModel.w_(), friendRequesteesModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(FriendRequesteesModel.class, new Serializer());
                }
            }

            public FriendRequesteesModel() {
                super(7);
            }

            public final void m17257a(String str, ConsistencyTuple consistencyTuple) {
                if ("can_viewer_message".equals(str)) {
                    consistencyTuple.a = Boolean.valueOf(m17248l());
                    consistencyTuple.b = u_();
                    consistencyTuple.c = 1;
                } else if ("can_viewer_poke".equals(str)) {
                    consistencyTuple.a = Boolean.valueOf(m17249m());
                    consistencyTuple.b = u_();
                    consistencyTuple.c = 2;
                } else if ("can_viewer_post".equals(str)) {
                    consistencyTuple.a = Boolean.valueOf(m17250n());
                    consistencyTuple.b = u_();
                    consistencyTuple.c = 3;
                } else if ("friendship_status".equals(str)) {
                    consistencyTuple.a = m17259j();
                    consistencyTuple.b = u_();
                    consistencyTuple.c = 4;
                } else if ("subscribe_status".equals(str)) {
                    consistencyTuple.a = m17252p();
                    consistencyTuple.b = u_();
                    consistencyTuple.c = 6;
                } else {
                    consistencyTuple.a();
                }
            }

            public final void m17258a(String str, Object obj, boolean z) {
                if ("can_viewer_message".equals(str)) {
                    m17244a(((Boolean) obj).booleanValue());
                } else if ("can_viewer_poke".equals(str)) {
                    m17245b(((Boolean) obj).booleanValue());
                } else if ("can_viewer_post".equals(str)) {
                    m17246c(((Boolean) obj).booleanValue());
                } else if ("friendship_status".equals(str)) {
                    m17242a((GraphQLFriendshipStatus) obj);
                } else if ("subscribe_status".equals(str)) {
                    m17243a((GraphQLSubscribeStatus) obj);
                }
            }

            @Nullable
            private GraphQLObjectType m17247k() {
                if (this.b != null && this.f10786d == null) {
                    this.f10786d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
                }
                return this.f10786d;
            }

            private boolean m17248l() {
                a(0, 1);
                return this.f10787e;
            }

            private void m17244a(boolean z) {
                this.f10787e = z;
                if (this.b != null && this.b.d) {
                    this.b.a(this.c, 1, z);
                }
            }

            private boolean m17249m() {
                a(0, 2);
                return this.f10788f;
            }

            private void m17245b(boolean z) {
                this.f10788f = z;
                if (this.b != null && this.b.d) {
                    this.b.a(this.c, 2, z);
                }
            }

            private boolean m17250n() {
                a(0, 3);
                return this.f10789g;
            }

            private void m17246c(boolean z) {
                this.f10789g = z;
                if (this.b != null && this.b.d) {
                    this.b.a(this.c, 3, z);
                }
            }

            @Nullable
            public final GraphQLFriendshipStatus m17259j() {
                this.f10790h = (GraphQLFriendshipStatus) super.b(this.f10790h, 4, GraphQLFriendshipStatus.class, GraphQLFriendshipStatus.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
                return this.f10790h;
            }

            private void m17242a(GraphQLFriendshipStatus graphQLFriendshipStatus) {
                this.f10790h = graphQLFriendshipStatus;
                if (this.b != null && this.b.d) {
                    this.b.a(this.c, 4, graphQLFriendshipStatus != null ? graphQLFriendshipStatus.name() : null);
                }
            }

            @Nullable
            private String m17251o() {
                this.f10791i = super.a(this.f10791i, 5);
                return this.f10791i;
            }

            @Nullable
            private GraphQLSubscribeStatus m17252p() {
                this.f10792j = (GraphQLSubscribeStatus) super.b(this.f10792j, 6, GraphQLSubscribeStatus.class, GraphQLSubscribeStatus.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
                return this.f10792j;
            }

            private void m17243a(GraphQLSubscribeStatus graphQLSubscribeStatus) {
                this.f10792j = graphQLSubscribeStatus;
                if (this.b != null && this.b.d) {
                    this.b.a(this.c, 6, graphQLSubscribeStatus != null ? graphQLSubscribeStatus.name() : null);
                }
            }

            @Nullable
            public final String m17255a() {
                return m17251o();
            }

            public final int jK_() {
                return 2645995;
            }

            public final GraphQLVisitableModel m17254a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m17253a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m17247k());
                int a2 = flatBufferBuilder.a(m17259j());
                int b = flatBufferBuilder.b(m17251o());
                int a3 = flatBufferBuilder.a(m17252p());
                flatBufferBuilder.c(7);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.a(1, this.f10787e);
                flatBufferBuilder.a(2, this.f10788f);
                flatBufferBuilder.a(3, this.f10789g);
                flatBufferBuilder.b(4, a2);
                flatBufferBuilder.b(5, b);
                flatBufferBuilder.b(6, a3);
                i();
                return flatBufferBuilder.d();
            }

            public final void m17256a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                super.a(mutableFlatBuffer, i, obj);
                this.f10787e = mutableFlatBuffer.a(i, 1);
                this.f10788f = mutableFlatBuffer.a(i, 2);
                this.f10789g = mutableFlatBuffer.a(i, 3);
            }
        }

        /* compiled from: maiden */
        public class Serializer extends JsonSerializer<FriendRequestSendCoreMutationFieldsModel> {
            public final void m17260a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                FriendRequestSendCoreMutationFieldsModel friendRequestSendCoreMutationFieldsModel = (FriendRequestSendCoreMutationFieldsModel) obj;
                if (friendRequestSendCoreMutationFieldsModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(friendRequestSendCoreMutationFieldsModel.m17261a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    friendRequestSendCoreMutationFieldsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = friendRequestSendCoreMutationFieldsModel.w_();
                int u_ = friendRequestSendCoreMutationFieldsModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("friend_requestees");
                    jsonGenerator.d();
                    for (int i = 0; i < mutableFlatBuffer.c(g); i++) {
                        FriendRequesteesParser.m17339a(mutableFlatBuffer, mutableFlatBuffer.m(g, i), jsonGenerator);
                    }
                    jsonGenerator.e();
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(FriendRequestSendCoreMutationFieldsModel.class, new Serializer());
            }
        }

        public FriendRequestSendCoreMutationFieldsModel() {
            super(1);
        }

        @Nonnull
        public final ImmutableList<FriendRequesteesModel> m17263a() {
            this.f10793d = super.a(this.f10793d, 0, FriendRequesteesModel.class);
            return (ImmutableList) this.f10793d;
        }

        public final int jK_() {
            return 1296304052;
        }

        public final GraphQLVisitableModel m17262a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m17263a() != null) {
                Builder a = ModelHelper.a(m17263a(), graphQLModelMutatingVisitor);
                if (a != null) {
                    graphQLVisitableModel = (FriendRequestSendCoreMutationFieldsModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f10793d = a.b();
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m17261a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m17263a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -2101458828)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: maiden */
    public final class FriendSuggestionIgnoreCoreMutationFieldsModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private IgnoredSuggestedFriendModel f10801d;

        /* compiled from: maiden */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(FriendSuggestionIgnoreCoreMutationFieldsModel.class, new Deserializer());
            }

            public Object m17264a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = FriendSuggestionIgnoreCoreMutationFieldsParser.m17344a(jsonParser);
                Object friendSuggestionIgnoreCoreMutationFieldsModel = new FriendSuggestionIgnoreCoreMutationFieldsModel();
                ((BaseModel) friendSuggestionIgnoreCoreMutationFieldsModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (friendSuggestionIgnoreCoreMutationFieldsModel instanceof Postprocessable) {
                    return ((Postprocessable) friendSuggestionIgnoreCoreMutationFieldsModel).a();
                }
                return friendSuggestionIgnoreCoreMutationFieldsModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -342012956)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: maiden */
        public final class IgnoredSuggestedFriendModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
            @Nullable
            private GraphQLObjectType f10794d;
            private boolean f10795e;
            private boolean f10796f;
            private boolean f10797g;
            @Nullable
            private GraphQLFriendshipStatus f10798h;
            @Nullable
            private String f10799i;
            @Nullable
            private GraphQLSubscribeStatus f10800j;

            /* compiled from: maiden */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(IgnoredSuggestedFriendModel.class, new Deserializer());
                }

                public Object m17265a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(IgnoredSuggestedFriendParser.m17342a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object ignoredSuggestedFriendModel = new IgnoredSuggestedFriendModel();
                    ((BaseModel) ignoredSuggestedFriendModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (ignoredSuggestedFriendModel instanceof Postprocessable) {
                        return ((Postprocessable) ignoredSuggestedFriendModel).a();
                    }
                    return ignoredSuggestedFriendModel;
                }
            }

            /* compiled from: maiden */
            public class Serializer extends JsonSerializer<IgnoredSuggestedFriendModel> {
                public final void m17266a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    IgnoredSuggestedFriendModel ignoredSuggestedFriendModel = (IgnoredSuggestedFriendModel) obj;
                    if (ignoredSuggestedFriendModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(ignoredSuggestedFriendModel.m17278a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        ignoredSuggestedFriendModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    IgnoredSuggestedFriendParser.m17343a(ignoredSuggestedFriendModel.w_(), ignoredSuggestedFriendModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(IgnoredSuggestedFriendModel.class, new Serializer());
                }
            }

            public IgnoredSuggestedFriendModel() {
                super(7);
            }

            public final void m17282a(String str, ConsistencyTuple consistencyTuple) {
                if ("can_viewer_message".equals(str)) {
                    consistencyTuple.a = Boolean.valueOf(m17273l());
                    consistencyTuple.b = u_();
                    consistencyTuple.c = 1;
                } else if ("can_viewer_poke".equals(str)) {
                    consistencyTuple.a = Boolean.valueOf(m17274m());
                    consistencyTuple.b = u_();
                    consistencyTuple.c = 2;
                } else if ("can_viewer_post".equals(str)) {
                    consistencyTuple.a = Boolean.valueOf(m17275n());
                    consistencyTuple.b = u_();
                    consistencyTuple.c = 3;
                } else if ("friendship_status".equals(str)) {
                    consistencyTuple.a = m17284j();
                    consistencyTuple.b = u_();
                    consistencyTuple.c = 4;
                } else if ("subscribe_status".equals(str)) {
                    consistencyTuple.a = m17277p();
                    consistencyTuple.b = u_();
                    consistencyTuple.c = 6;
                } else {
                    consistencyTuple.a();
                }
            }

            public final void m17283a(String str, Object obj, boolean z) {
                if ("can_viewer_message".equals(str)) {
                    m17269a(((Boolean) obj).booleanValue());
                } else if ("can_viewer_poke".equals(str)) {
                    m17270b(((Boolean) obj).booleanValue());
                } else if ("can_viewer_post".equals(str)) {
                    m17271c(((Boolean) obj).booleanValue());
                } else if ("friendship_status".equals(str)) {
                    m17267a((GraphQLFriendshipStatus) obj);
                } else if ("subscribe_status".equals(str)) {
                    m17268a((GraphQLSubscribeStatus) obj);
                }
            }

            @Nullable
            private GraphQLObjectType m17272k() {
                if (this.b != null && this.f10794d == null) {
                    this.f10794d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
                }
                return this.f10794d;
            }

            private boolean m17273l() {
                a(0, 1);
                return this.f10795e;
            }

            private void m17269a(boolean z) {
                this.f10795e = z;
                if (this.b != null && this.b.d) {
                    this.b.a(this.c, 1, z);
                }
            }

            private boolean m17274m() {
                a(0, 2);
                return this.f10796f;
            }

            private void m17270b(boolean z) {
                this.f10796f = z;
                if (this.b != null && this.b.d) {
                    this.b.a(this.c, 2, z);
                }
            }

            private boolean m17275n() {
                a(0, 3);
                return this.f10797g;
            }

            private void m17271c(boolean z) {
                this.f10797g = z;
                if (this.b != null && this.b.d) {
                    this.b.a(this.c, 3, z);
                }
            }

            @Nullable
            public final GraphQLFriendshipStatus m17284j() {
                this.f10798h = (GraphQLFriendshipStatus) super.b(this.f10798h, 4, GraphQLFriendshipStatus.class, GraphQLFriendshipStatus.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
                return this.f10798h;
            }

            private void m17267a(GraphQLFriendshipStatus graphQLFriendshipStatus) {
                this.f10798h = graphQLFriendshipStatus;
                if (this.b != null && this.b.d) {
                    this.b.a(this.c, 4, graphQLFriendshipStatus != null ? graphQLFriendshipStatus.name() : null);
                }
            }

            @Nullable
            private String m17276o() {
                this.f10799i = super.a(this.f10799i, 5);
                return this.f10799i;
            }

            @Nullable
            private GraphQLSubscribeStatus m17277p() {
                this.f10800j = (GraphQLSubscribeStatus) super.b(this.f10800j, 6, GraphQLSubscribeStatus.class, GraphQLSubscribeStatus.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
                return this.f10800j;
            }

            private void m17268a(GraphQLSubscribeStatus graphQLSubscribeStatus) {
                this.f10800j = graphQLSubscribeStatus;
                if (this.b != null && this.b.d) {
                    this.b.a(this.c, 6, graphQLSubscribeStatus != null ? graphQLSubscribeStatus.name() : null);
                }
            }

            @Nullable
            public final String m17280a() {
                return m17276o();
            }

            public final int jK_() {
                return 2645995;
            }

            public final GraphQLVisitableModel m17279a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m17278a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m17272k());
                int a2 = flatBufferBuilder.a(m17284j());
                int b = flatBufferBuilder.b(m17276o());
                int a3 = flatBufferBuilder.a(m17277p());
                flatBufferBuilder.c(7);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.a(1, this.f10795e);
                flatBufferBuilder.a(2, this.f10796f);
                flatBufferBuilder.a(3, this.f10797g);
                flatBufferBuilder.b(4, a2);
                flatBufferBuilder.b(5, b);
                flatBufferBuilder.b(6, a3);
                i();
                return flatBufferBuilder.d();
            }

            public final void m17281a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                super.a(mutableFlatBuffer, i, obj);
                this.f10795e = mutableFlatBuffer.a(i, 1);
                this.f10796f = mutableFlatBuffer.a(i, 2);
                this.f10797g = mutableFlatBuffer.a(i, 3);
            }
        }

        /* compiled from: maiden */
        public class Serializer extends JsonSerializer<FriendSuggestionIgnoreCoreMutationFieldsModel> {
            public final void m17285a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                FriendSuggestionIgnoreCoreMutationFieldsModel friendSuggestionIgnoreCoreMutationFieldsModel = (FriendSuggestionIgnoreCoreMutationFieldsModel) obj;
                if (friendSuggestionIgnoreCoreMutationFieldsModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(friendSuggestionIgnoreCoreMutationFieldsModel.m17286a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    friendSuggestionIgnoreCoreMutationFieldsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = friendSuggestionIgnoreCoreMutationFieldsModel.w_();
                int u_ = friendSuggestionIgnoreCoreMutationFieldsModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("ignored_suggested_friend");
                    IgnoredSuggestedFriendParser.m17343a(mutableFlatBuffer, g, jsonGenerator);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(FriendSuggestionIgnoreCoreMutationFieldsModel.class, new Serializer());
            }
        }

        public FriendSuggestionIgnoreCoreMutationFieldsModel() {
            super(1);
        }

        @Nullable
        public final IgnoredSuggestedFriendModel m17287a() {
            this.f10801d = (IgnoredSuggestedFriendModel) super.a(this.f10801d, 0, IgnoredSuggestedFriendModel.class);
            return this.f10801d;
        }

        public final int jK_() {
            return 69451673;
        }

        public final GraphQLVisitableModel m17288a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m17287a() != null) {
                IgnoredSuggestedFriendModel ignoredSuggestedFriendModel = (IgnoredSuggestedFriendModel) graphQLModelMutatingVisitor.b(m17287a());
                if (m17287a() != ignoredSuggestedFriendModel) {
                    graphQLVisitableModel = (FriendSuggestionIgnoreCoreMutationFieldsModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f10801d = ignoredSuggestedFriendModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m17286a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m17287a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -2102587580)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: maiden */
    public final class FriendSuggestionSendMutationModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private SuggestedFriendModel f10804d;

        /* compiled from: maiden */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(FriendSuggestionSendMutationModel.class, new Deserializer());
            }

            public Object m17289a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = FriendSuggestionSendMutationParser.m17347a(jsonParser);
                Object friendSuggestionSendMutationModel = new FriendSuggestionSendMutationModel();
                ((BaseModel) friendSuggestionSendMutationModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (friendSuggestionSendMutationModel instanceof Postprocessable) {
                    return ((Postprocessable) friendSuggestionSendMutationModel).a();
                }
                return friendSuggestionSendMutationModel;
            }
        }

        /* compiled from: maiden */
        public class Serializer extends JsonSerializer<FriendSuggestionSendMutationModel> {
            public final void m17290a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                FriendSuggestionSendMutationModel friendSuggestionSendMutationModel = (FriendSuggestionSendMutationModel) obj;
                if (friendSuggestionSendMutationModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(friendSuggestionSendMutationModel.m17301a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    friendSuggestionSendMutationModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = friendSuggestionSendMutationModel.w_();
                int u_ = friendSuggestionSendMutationModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("suggested_friend");
                    SuggestedFriendParser.m17346a(mutableFlatBuffer, g, jsonGenerator);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(FriendSuggestionSendMutationModel.class, new Serializer());
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1185712657)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: maiden */
        public final class SuggestedFriendModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
            @Nullable
            private String f10802d;
            @Nullable
            private String f10803e;

            /* compiled from: maiden */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(SuggestedFriendModel.class, new Deserializer());
                }

                public Object m17291a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(SuggestedFriendParser.m17345a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object suggestedFriendModel = new SuggestedFriendModel();
                    ((BaseModel) suggestedFriendModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (suggestedFriendModel instanceof Postprocessable) {
                        return ((Postprocessable) suggestedFriendModel).a();
                    }
                    return suggestedFriendModel;
                }
            }

            /* compiled from: maiden */
            public class Serializer extends JsonSerializer<SuggestedFriendModel> {
                public final void m17292a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    SuggestedFriendModel suggestedFriendModel = (SuggestedFriendModel) obj;
                    if (suggestedFriendModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(suggestedFriendModel.m17295a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        suggestedFriendModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    SuggestedFriendParser.m17346a(suggestedFriendModel.w_(), suggestedFriendModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(SuggestedFriendModel.class, new Serializer());
                }
            }

            public SuggestedFriendModel() {
                super(2);
            }

            public final void m17298a(String str, ConsistencyTuple consistencyTuple) {
                consistencyTuple.a();
            }

            public final void m17299a(String str, Object obj, boolean z) {
            }

            @Nullable
            private String m17293j() {
                this.f10802d = super.a(this.f10802d, 0);
                return this.f10802d;
            }

            @Nullable
            private String m17294k() {
                this.f10803e = super.a(this.f10803e, 1);
                return this.f10803e;
            }

            @Nullable
            public final String m17297a() {
                return m17293j();
            }

            public final int jK_() {
                return 2645995;
            }

            public final GraphQLVisitableModel m17296a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m17295a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m17293j());
                int b2 = flatBufferBuilder.b(m17294k());
                flatBufferBuilder.c(2);
                flatBufferBuilder.b(0, b);
                flatBufferBuilder.b(1, b2);
                i();
                return flatBufferBuilder.d();
            }
        }

        public FriendSuggestionSendMutationModel() {
            super(1);
        }

        @Nullable
        private SuggestedFriendModel m17300a() {
            this.f10804d = (SuggestedFriendModel) super.a(this.f10804d, 0, SuggestedFriendModel.class);
            return this.f10804d;
        }

        public final int jK_() {
            return 295232163;
        }

        public final GraphQLVisitableModel m17302a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m17300a() != null) {
                SuggestedFriendModel suggestedFriendModel = (SuggestedFriendModel) graphQLModelMutatingVisitor.b(m17300a());
                if (m17300a() != suggestedFriendModel) {
                    graphQLVisitableModel = (FriendSuggestionSendMutationModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f10804d = suggestedFriendModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m17301a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m17300a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 243541064)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: maiden */
    public final class FutureFriendingCoreMutationFieldsModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private ContactPointModel f10808d;

        /* compiled from: maiden */
        public final class Builder {
            @Nullable
            public ContactPointModel f10805a;
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1787905591)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: maiden */
        public final class ContactPointModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel {
            @Nullable
            private GraphQLObjectType f10806d;
            @Nullable
            private String f10807e;

            /* compiled from: maiden */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(ContactPointModel.class, new Deserializer());
                }

                public Object m17303a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(FutureFriendingCoreMutationFieldsParser.ContactPointParser.m17348a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object contactPointModel = new ContactPointModel();
                    ((BaseModel) contactPointModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (contactPointModel instanceof Postprocessable) {
                        return ((Postprocessable) contactPointModel).a();
                    }
                    return contactPointModel;
                }
            }

            /* compiled from: maiden */
            public class Serializer extends JsonSerializer<ContactPointModel> {
                public final void m17304a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    ContactPointModel contactPointModel = (ContactPointModel) obj;
                    if (contactPointModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(contactPointModel.m17307a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        contactPointModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    FutureFriendingCoreMutationFieldsParser.ContactPointParser.m17349a(contactPointModel.w_(), contactPointModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(ContactPointModel.class, new Serializer());
                }
            }

            public ContactPointModel() {
                super(2);
            }

            @Nullable
            private GraphQLObjectType m17305j() {
                if (this.b != null && this.f10806d == null) {
                    this.f10806d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
                }
                return this.f10806d;
            }

            @Nullable
            private String m17306k() {
                this.f10807e = super.a(this.f10807e, 1);
                return this.f10807e;
            }

            @Nullable
            public final String m17309a() {
                return m17306k();
            }

            public final int jK_() {
                return 1428236656;
            }

            public final GraphQLVisitableModel m17308a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m17307a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m17305j());
                int b = flatBufferBuilder.b(m17306k());
                flatBufferBuilder.c(2);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.b(1, b);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: maiden */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(FutureFriendingCoreMutationFieldsModel.class, new Deserializer());
            }

            public Object m17310a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = FutureFriendingCoreMutationFieldsParser.m17350a(jsonParser);
                Object futureFriendingCoreMutationFieldsModel = new FutureFriendingCoreMutationFieldsModel();
                ((BaseModel) futureFriendingCoreMutationFieldsModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (futureFriendingCoreMutationFieldsModel instanceof Postprocessable) {
                    return ((Postprocessable) futureFriendingCoreMutationFieldsModel).a();
                }
                return futureFriendingCoreMutationFieldsModel;
            }
        }

        /* compiled from: maiden */
        public class Serializer extends JsonSerializer<FutureFriendingCoreMutationFieldsModel> {
            public final void m17311a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                FutureFriendingCoreMutationFieldsModel futureFriendingCoreMutationFieldsModel = (FutureFriendingCoreMutationFieldsModel) obj;
                if (futureFriendingCoreMutationFieldsModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(futureFriendingCoreMutationFieldsModel.m17313a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    futureFriendingCoreMutationFieldsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = futureFriendingCoreMutationFieldsModel.w_();
                int u_ = futureFriendingCoreMutationFieldsModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("contact_point");
                    FutureFriendingCoreMutationFieldsParser.ContactPointParser.m17349a(mutableFlatBuffer, g, jsonGenerator);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(FutureFriendingCoreMutationFieldsModel.class, new Serializer());
            }
        }

        public FutureFriendingCoreMutationFieldsModel() {
            super(1);
        }

        public FutureFriendingCoreMutationFieldsModel(MutableFlatBuffer mutableFlatBuffer) {
            super(1);
            a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
        }

        @Nullable
        private ContactPointModel m17312a() {
            this.f10808d = (ContactPointModel) super.a(this.f10808d, 0, ContactPointModel.class);
            return this.f10808d;
        }

        public final int jK_() {
            return 346238444;
        }

        public final GraphQLVisitableModel m17314a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m17312a() != null) {
                ContactPointModel contactPointModel = (ContactPointModel) graphQLModelMutatingVisitor.b(m17312a());
                if (m17312a() != contactPointModel) {
                    graphQLVisitableModel = (FutureFriendingCoreMutationFieldsModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f10808d = contactPointModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m17313a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m17312a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }
}
