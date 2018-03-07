package com.facebook.events.graphql;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbSerializerProvider;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.events.graphql.EventsGraphQLModels.EventPurchaseTicketMutationResultModel;
import com.facebook.events.graphql.EventsGraphQLModels.EventTicketTierPermalinkFragmentModel;
import com.facebook.events.graphql.EventsGraphQLParsers.EventPurchaseTicketMutationResultParser;
import com.facebook.events.graphql.EventsGraphQLParsers.EventTicketTierPermalinkFragmentParser;
import com.facebook.events.graphql.EventsMutationsParsers.CancelEventMutationParser;
import com.facebook.events.graphql.EventsMutationsParsers.ChangeSubscriptionMutationParser;
import com.facebook.events.graphql.EventsMutationsParsers.ChangeSubscriptionMutationParser.ProfileParser;
import com.facebook.events.graphql.EventsMutationsParsers.EventAdminRemoveGuestMutationParser;
import com.facebook.events.graphql.EventsMutationsParsers.EventAdminRsvpMutationParser;
import com.facebook.events.graphql.EventsMutationsParsers.EventGuestCountsMutationFragmentParser;
import com.facebook.events.graphql.EventsMutationsParsers.EventGuestCountsMutationFragmentParser.EventDeclinesParser;
import com.facebook.events.graphql.EventsMutationsParsers.EventGuestCountsMutationFragmentParser.EventInviteesParser;
import com.facebook.events.graphql.EventsMutationsParsers.EventGuestCountsMutationFragmentParser.EventMaybesParser;
import com.facebook.events.graphql.EventsMutationsParsers.EventGuestCountsMutationFragmentParser.EventMembersParser;
import com.facebook.events.graphql.EventsMutationsParsers.EventInviteMutationParser;
import com.facebook.events.graphql.EventsMutationsParsers.EventPromptXOutMutationParser;
import com.facebook.events.graphql.EventsMutationsParsers.EventPurchaseTicketMutationAsyncParser;
import com.facebook.events.graphql.EventsMutationsParsers.EventPurchaseTicketMutationParser;
import com.facebook.events.graphql.EventsMutationsParsers.EventPurchaseTicketMutationParser.OrderParser;
import com.facebook.events.graphql.EventsMutationsParsers.EventPurchaseTicketMutationParser.OrderParser.ClaimActionLinkParser;
import com.facebook.events.graphql.EventsMutationsParsers.EventPurchaseTicketMutationParser.OrderParser.EventTicketsParser;
import com.facebook.events.graphql.EventsMutationsParsers.EventPurchaseTicketMutationParser.OrderParser.EventTicketsParser.NodesParser;
import com.facebook.events.graphql.EventsMutationsParsers.EventPurchaseTicketMutationParser.OrderParser.EventTicketsParser.NodesParser.FbqrcodeParser;
import com.facebook.events.graphql.EventsMutationsParsers.EventRsvpMutationParser;
import com.facebook.events.graphql.EventsMutationsParsers.EventRsvpSubscriptionParser;
import com.facebook.events.graphql.EventsMutationsParsers.EventSoftCancelMutationParser;
import com.facebook.events.graphql.EventsMutationsParsers.EventSoftCancelMutationParser.EventParser;
import com.facebook.events.graphql.EventsMutationsParsers.EventUnifiedInviteMutationParser;
import com.facebook.events.graphql.EventsMutationsParsers.EventUserBlockMutationParser;
import com.facebook.events.graphql.EventsMutationsParsers.EventUserBlockMutationParser.UserParser;
import com.facebook.events.graphql.EventsMutationsParsers.OptimisticRsvpEventParser;
import com.facebook.events.graphql.EventsMutationsParsers.OptimisticRsvpEventParser.EventWatchersParser;
import com.facebook.events.graphql.EventsMutationsParsers.RemoveEventCoreMutationParser;
import com.facebook.events.graphql.EventsMutationsParsers.RemoveSubscribedEventMutationParser;
import com.facebook.events.graphql.EventsMutationsParsers.RemoveSuggestedEventMutationParser;
import com.facebook.events.graphql.EventsMutationsParsers.WatchEventMutationParser;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.FragmentModelWithoutBridge;
import com.facebook.flatbuffers.ModelWithFlatBufferFormatHash;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.enums.GraphQLEventGuestStatus;
import com.facebook.graphql.enums.GraphQLEventWatchStatus;
import com.facebook.graphql.enums.GraphQLEventsCalendarSubscriptionStatus;
import com.facebook.graphql.enums.GraphQLObjectType;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.querybuilder.common.TextWithEntitiesGraphQLModels.DefaultTextWithEntitiesLongFieldsModel;
import com.facebook.graphql.querybuilder.common.TextWithEntitiesGraphQLParsers.DefaultTextWithEntitiesLongFieldsParser;
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

/* compiled from: num_missing */
public class EventsMutationsModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -1061784452)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: num_missing */
    public final class CancelEventMutationModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private String f9705d;

        /* compiled from: num_missing */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(CancelEventMutationModel.class, new Deserializer());
            }

            public Object m15207a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = CancelEventMutationParser.m15468a(jsonParser);
                Object cancelEventMutationModel = new CancelEventMutationModel();
                ((BaseModel) cancelEventMutationModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (cancelEventMutationModel instanceof Postprocessable) {
                    return ((Postprocessable) cancelEventMutationModel).a();
                }
                return cancelEventMutationModel;
            }
        }

        /* compiled from: num_missing */
        public class Serializer extends JsonSerializer<CancelEventMutationModel> {
            public final void m15208a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                CancelEventMutationModel cancelEventMutationModel = (CancelEventMutationModel) obj;
                if (cancelEventMutationModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(cancelEventMutationModel.m15210a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    cancelEventMutationModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = cancelEventMutationModel.w_();
                int u_ = cancelEventMutationModel.u_();
                jsonGenerator.f();
                if (mutableFlatBuffer.g(u_, 0) != 0) {
                    jsonGenerator.a("canceled_event_id");
                    jsonGenerator.b(mutableFlatBuffer.c(u_, 0));
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(CancelEventMutationModel.class, new Serializer());
            }
        }

        public CancelEventMutationModel() {
            super(1);
        }

        @Nullable
        private String m15209a() {
            this.f9705d = super.a(this.f9705d, 0);
            return this.f9705d;
        }

        public final int jK_() {
            return -639382055;
        }

        public final GraphQLVisitableModel m15211a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            h();
            i();
            return this;
        }

        public final int m15210a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(m15209a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, b);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 638182833)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: num_missing */
    public final class ChangeSubscriptionMutationModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private String f9710d;
        @Nullable
        private ProfileModel f9711e;

        /* compiled from: num_missing */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(ChangeSubscriptionMutationModel.class, new Deserializer());
            }

            public Object m15212a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = ChangeSubscriptionMutationParser.m15471a(jsonParser);
                Object changeSubscriptionMutationModel = new ChangeSubscriptionMutationModel();
                ((BaseModel) changeSubscriptionMutationModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (changeSubscriptionMutationModel instanceof Postprocessable) {
                    return ((Postprocessable) changeSubscriptionMutationModel).a();
                }
                return changeSubscriptionMutationModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1685138978)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: num_missing */
        public final class ProfileModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
            @Nullable
            private GraphQLObjectType f9706d;
            private int f9707e;
            @Nullable
            private GraphQLEventsCalendarSubscriptionStatus f9708f;
            @Nullable
            private String f9709g;

            /* compiled from: num_missing */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(ProfileModel.class, new Deserializer());
                }

                public Object m15213a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(ProfileParser.m15469a(jsonParser, flatBufferBuilder));
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

            /* compiled from: num_missing */
            public class Serializer extends JsonSerializer<ProfileModel> {
                public final void m15214a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    ProfileModel profileModel = (ProfileModel) obj;
                    if (profileModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(profileModel.m15218a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        profileModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    ProfileParser.m15470a(profileModel.w_(), profileModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(ProfileModel.class, new Serializer());
                }
            }

            public ProfileModel() {
                super(4);
            }

            public final void m15222a(String str, ConsistencyTuple consistencyTuple) {
                consistencyTuple.a();
            }

            public final void m15223a(String str, Object obj, boolean z) {
            }

            @Nullable
            private GraphQLObjectType m15215j() {
                if (this.b != null && this.f9706d == null) {
                    this.f9706d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
                }
                return this.f9706d;
            }

            @Nullable
            private GraphQLEventsCalendarSubscriptionStatus m15216k() {
                this.f9708f = (GraphQLEventsCalendarSubscriptionStatus) super.b(this.f9708f, 2, GraphQLEventsCalendarSubscriptionStatus.class, GraphQLEventsCalendarSubscriptionStatus.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
                return this.f9708f;
            }

            @Nullable
            private String m15217l() {
                this.f9709g = super.a(this.f9709g, 3);
                return this.f9709g;
            }

            @Nullable
            public final String m15220a() {
                return m15217l();
            }

            public final int jK_() {
                return 1355227529;
            }

            public final GraphQLVisitableModel m15219a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m15218a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m15215j());
                int a2 = flatBufferBuilder.a(m15216k());
                int b = flatBufferBuilder.b(m15217l());
                flatBufferBuilder.c(4);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.a(1, this.f9707e, 0);
                flatBufferBuilder.b(2, a2);
                flatBufferBuilder.b(3, b);
                i();
                return flatBufferBuilder.d();
            }

            public final void m15221a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                super.a(mutableFlatBuffer, i, obj);
                this.f9707e = mutableFlatBuffer.a(i, 1, 0);
            }
        }

        /* compiled from: num_missing */
        public class Serializer extends JsonSerializer<ChangeSubscriptionMutationModel> {
            public final void m15224a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                ChangeSubscriptionMutationModel changeSubscriptionMutationModel = (ChangeSubscriptionMutationModel) obj;
                if (changeSubscriptionMutationModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(changeSubscriptionMutationModel.m15227a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    changeSubscriptionMutationModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = changeSubscriptionMutationModel.w_();
                int u_ = changeSubscriptionMutationModel.u_();
                jsonGenerator.f();
                if (mutableFlatBuffer.g(u_, 0) != 0) {
                    jsonGenerator.a("client_mutation_id");
                    jsonGenerator.b(mutableFlatBuffer.c(u_, 0));
                }
                int g = mutableFlatBuffer.g(u_, 1);
                if (g != 0) {
                    jsonGenerator.a("profile");
                    ProfileParser.m15470a(mutableFlatBuffer, g, jsonGenerator);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(ChangeSubscriptionMutationModel.class, new Serializer());
            }
        }

        public ChangeSubscriptionMutationModel() {
            super(2);
        }

        @Nullable
        private String m15225a() {
            this.f9710d = super.a(this.f9710d, 0);
            return this.f9710d;
        }

        @Nullable
        private ProfileModel m15226j() {
            this.f9711e = (ProfileModel) super.a(this.f9711e, 1, ProfileModel.class);
            return this.f9711e;
        }

        public final int jK_() {
            return 522336910;
        }

        public final GraphQLVisitableModel m15228a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m15226j() != null) {
                ProfileModel profileModel = (ProfileModel) graphQLModelMutatingVisitor.b(m15226j());
                if (m15226j() != profileModel) {
                    graphQLVisitableModel = (ChangeSubscriptionMutationModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f9711e = profileModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m15227a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(m15225a());
            int a = ModelHelper.a(flatBufferBuilder, m15226j());
            flatBufferBuilder.c(2);
            flatBufferBuilder.b(0, b);
            flatBufferBuilder.b(1, a);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 294707174)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: num_missing */
    public final class EventAdminRemoveGuestMutationModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private String f9712d;
        @Nullable
        private EventGuestCountsMutationFragmentModel f9713e;

        /* compiled from: num_missing */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(EventAdminRemoveGuestMutationModel.class, new Deserializer());
            }

            public Object m15229a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = EventAdminRemoveGuestMutationParser.m15472a(jsonParser);
                Object eventAdminRemoveGuestMutationModel = new EventAdminRemoveGuestMutationModel();
                ((BaseModel) eventAdminRemoveGuestMutationModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (eventAdminRemoveGuestMutationModel instanceof Postprocessable) {
                    return ((Postprocessable) eventAdminRemoveGuestMutationModel).a();
                }
                return eventAdminRemoveGuestMutationModel;
            }
        }

        /* compiled from: num_missing */
        public class Serializer extends JsonSerializer<EventAdminRemoveGuestMutationModel> {
            public final void m15230a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                EventAdminRemoveGuestMutationModel eventAdminRemoveGuestMutationModel = (EventAdminRemoveGuestMutationModel) obj;
                if (eventAdminRemoveGuestMutationModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(eventAdminRemoveGuestMutationModel.m15233a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    eventAdminRemoveGuestMutationModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = eventAdminRemoveGuestMutationModel.w_();
                int u_ = eventAdminRemoveGuestMutationModel.u_();
                jsonGenerator.f();
                if (mutableFlatBuffer.g(u_, 0) != 0) {
                    jsonGenerator.a("client_mutation_id");
                    jsonGenerator.b(mutableFlatBuffer.c(u_, 0));
                }
                int g = mutableFlatBuffer.g(u_, 1);
                if (g != 0) {
                    jsonGenerator.a("event");
                    EventGuestCountsMutationFragmentParser.m15483a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(EventAdminRemoveGuestMutationModel.class, new Serializer());
            }
        }

        public EventAdminRemoveGuestMutationModel() {
            super(2);
        }

        @Nullable
        private String m15231a() {
            this.f9712d = super.a(this.f9712d, 0);
            return this.f9712d;
        }

        @Nullable
        private EventGuestCountsMutationFragmentModel m15232j() {
            this.f9713e = (EventGuestCountsMutationFragmentModel) super.a(this.f9713e, 1, EventGuestCountsMutationFragmentModel.class);
            return this.f9713e;
        }

        public final int jK_() {
            return 1505090702;
        }

        public final GraphQLVisitableModel m15234a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m15232j() != null) {
                EventGuestCountsMutationFragmentModel eventGuestCountsMutationFragmentModel = (EventGuestCountsMutationFragmentModel) graphQLModelMutatingVisitor.b(m15232j());
                if (m15232j() != eventGuestCountsMutationFragmentModel) {
                    graphQLVisitableModel = (EventAdminRemoveGuestMutationModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f9713e = eventGuestCountsMutationFragmentModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m15233a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(m15231a());
            int a = ModelHelper.a(flatBufferBuilder, m15232j());
            flatBufferBuilder.c(2);
            flatBufferBuilder.b(0, b);
            flatBufferBuilder.b(1, a);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 294707174)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: num_missing */
    public final class EventAdminRsvpMutationModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private String f9714d;
        @Nullable
        private EventGuestCountsMutationFragmentModel f9715e;

        /* compiled from: num_missing */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(EventAdminRsvpMutationModel.class, new Deserializer());
            }

            public Object m15235a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = EventAdminRsvpMutationParser.m15473a(jsonParser);
                Object eventAdminRsvpMutationModel = new EventAdminRsvpMutationModel();
                ((BaseModel) eventAdminRsvpMutationModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (eventAdminRsvpMutationModel instanceof Postprocessable) {
                    return ((Postprocessable) eventAdminRsvpMutationModel).a();
                }
                return eventAdminRsvpMutationModel;
            }
        }

        /* compiled from: num_missing */
        public class Serializer extends JsonSerializer<EventAdminRsvpMutationModel> {
            public final void m15236a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                EventAdminRsvpMutationModel eventAdminRsvpMutationModel = (EventAdminRsvpMutationModel) obj;
                if (eventAdminRsvpMutationModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(eventAdminRsvpMutationModel.m15239a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    eventAdminRsvpMutationModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = eventAdminRsvpMutationModel.w_();
                int u_ = eventAdminRsvpMutationModel.u_();
                jsonGenerator.f();
                if (mutableFlatBuffer.g(u_, 0) != 0) {
                    jsonGenerator.a("client_mutation_id");
                    jsonGenerator.b(mutableFlatBuffer.c(u_, 0));
                }
                int g = mutableFlatBuffer.g(u_, 1);
                if (g != 0) {
                    jsonGenerator.a("event");
                    EventGuestCountsMutationFragmentParser.m15483a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(EventAdminRsvpMutationModel.class, new Serializer());
            }
        }

        public EventAdminRsvpMutationModel() {
            super(2);
        }

        @Nullable
        private String m15237a() {
            this.f9714d = super.a(this.f9714d, 0);
            return this.f9714d;
        }

        @Nullable
        private EventGuestCountsMutationFragmentModel m15238j() {
            this.f9715e = (EventGuestCountsMutationFragmentModel) super.a(this.f9715e, 1, EventGuestCountsMutationFragmentModel.class);
            return this.f9715e;
        }

        public final int jK_() {
            return 659941533;
        }

        public final GraphQLVisitableModel m15240a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m15238j() != null) {
                EventGuestCountsMutationFragmentModel eventGuestCountsMutationFragmentModel = (EventGuestCountsMutationFragmentModel) graphQLModelMutatingVisitor.b(m15238j());
                if (m15238j() != eventGuestCountsMutationFragmentModel) {
                    graphQLVisitableModel = (EventAdminRsvpMutationModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f9715e = eventGuestCountsMutationFragmentModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m15239a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(m15237a());
            int a = ModelHelper.a(flatBufferBuilder, m15238j());
            flatBufferBuilder.c(2);
            flatBufferBuilder.b(0, b);
            flatBufferBuilder.b(1, a);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -631735214)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: num_missing */
    public final class EventGuestCountsMutationFragmentModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
        @Nullable
        private EventDeclinesModel f9729d;
        @Nullable
        private EventInviteesModel f9730e;
        @Nullable
        private EventMaybesModel f9731f;
        @Nullable
        private EventMembersModel f9732g;
        @Nullable
        private String f9733h;

        /* compiled from: num_missing */
        public final class Builder {
            @Nullable
            public EventDeclinesModel f9716a;
            @Nullable
            public EventInviteesModel f9717b;
            @Nullable
            public EventMaybesModel f9718c;
            @Nullable
            public EventMembersModel f9719d;
            @Nullable
            public String f9720e;

            public final EventGuestCountsMutationFragmentModel m15241a() {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                int a = ModelHelper.a(flatBufferBuilder, this.f9716a);
                int a2 = ModelHelper.a(flatBufferBuilder, this.f9717b);
                int a3 = ModelHelper.a(flatBufferBuilder, this.f9718c);
                int a4 = ModelHelper.a(flatBufferBuilder, this.f9719d);
                int b = flatBufferBuilder.b(this.f9720e);
                flatBufferBuilder.c(5);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.b(1, a2);
                flatBufferBuilder.b(2, a3);
                flatBufferBuilder.b(3, a4);
                flatBufferBuilder.b(4, b);
                flatBufferBuilder.d(flatBufferBuilder.d());
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                return new EventGuestCountsMutationFragmentModel(new MutableFlatBuffer(wrap, null, null, true, null));
            }
        }

        /* compiled from: num_missing */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(EventGuestCountsMutationFragmentModel.class, new Deserializer());
            }

            public Object m15242a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(EventGuestCountsMutationFragmentParser.m15482a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object eventGuestCountsMutationFragmentModel = new EventGuestCountsMutationFragmentModel();
                ((BaseModel) eventGuestCountsMutationFragmentModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (eventGuestCountsMutationFragmentModel instanceof Postprocessable) {
                    return ((Postprocessable) eventGuestCountsMutationFragmentModel).a();
                }
                return eventGuestCountsMutationFragmentModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1723990064)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: num_missing */
        public final class EventDeclinesModel extends BaseModel implements GraphQLVisitableModel {
            private int f9722d;

            /* compiled from: num_missing */
            public final class Builder {
                public int f9721a;

                public final EventDeclinesModel m15243a() {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.a(0, this.f9721a, 0);
                    flatBufferBuilder.d(flatBufferBuilder.d());
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    return new EventDeclinesModel(new MutableFlatBuffer(wrap, null, null, true, null));
                }
            }

            /* compiled from: num_missing */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(EventDeclinesModel.class, new Deserializer());
                }

                public Object m15244a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(EventDeclinesParser.m15474a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object eventDeclinesModel = new EventDeclinesModel();
                    ((BaseModel) eventDeclinesModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (eventDeclinesModel instanceof Postprocessable) {
                        return ((Postprocessable) eventDeclinesModel).a();
                    }
                    return eventDeclinesModel;
                }
            }

            /* compiled from: num_missing */
            public class Serializer extends JsonSerializer<EventDeclinesModel> {
                public final void m15245a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    EventDeclinesModel eventDeclinesModel = (EventDeclinesModel) obj;
                    if (eventDeclinesModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(eventDeclinesModel.m15247a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        eventDeclinesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    EventDeclinesParser.m15475a(eventDeclinesModel.w_(), eventDeclinesModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(EventDeclinesModel.class, new Serializer());
                }
            }

            public EventDeclinesModel() {
                super(1);
            }

            public EventDeclinesModel(MutableFlatBuffer mutableFlatBuffer) {
                super(1);
                a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
            }

            public final int m15246a() {
                a(0, 0);
                return this.f9722d;
            }

            public final void m15249a(int i) {
                this.f9722d = i;
                if (this.b != null && this.b.d) {
                    this.b.b(this.c, 0, i);
                }
            }

            public final int jK_() {
                return 881148693;
            }

            public final GraphQLVisitableModel m15248a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m15247a(FlatBufferBuilder flatBufferBuilder) {
                h();
                flatBufferBuilder.c(1);
                flatBufferBuilder.a(0, this.f9722d, 0);
                i();
                return flatBufferBuilder.d();
            }

            public final void m15250a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                super.a(mutableFlatBuffer, i, obj);
                this.f9722d = mutableFlatBuffer.a(i, 0, 0);
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1723990064)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: num_missing */
        public final class EventInviteesModel extends BaseModel implements GraphQLVisitableModel {
            private int f9724d;

            /* compiled from: num_missing */
            public final class Builder {
                public int f9723a;

                public final EventInviteesModel m15251a() {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.a(0, this.f9723a, 0);
                    flatBufferBuilder.d(flatBufferBuilder.d());
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    return new EventInviteesModel(new MutableFlatBuffer(wrap, null, null, true, null));
                }
            }

            /* compiled from: num_missing */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(EventInviteesModel.class, new Deserializer());
                }

                public Object m15252a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(EventInviteesParser.m15476a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object eventInviteesModel = new EventInviteesModel();
                    ((BaseModel) eventInviteesModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (eventInviteesModel instanceof Postprocessable) {
                        return ((Postprocessable) eventInviteesModel).a();
                    }
                    return eventInviteesModel;
                }
            }

            /* compiled from: num_missing */
            public class Serializer extends JsonSerializer<EventInviteesModel> {
                public final void m15253a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    EventInviteesModel eventInviteesModel = (EventInviteesModel) obj;
                    if (eventInviteesModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(eventInviteesModel.m15255a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        eventInviteesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    EventInviteesParser.m15477a(eventInviteesModel.w_(), eventInviteesModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(EventInviteesModel.class, new Serializer());
                }
            }

            public EventInviteesModel() {
                super(1);
            }

            public EventInviteesModel(MutableFlatBuffer mutableFlatBuffer) {
                super(1);
                a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
            }

            public final int m15254a() {
                a(0, 0);
                return this.f9724d;
            }

            public final void m15257a(int i) {
                this.f9724d = i;
                if (this.b != null && this.b.d) {
                    this.b.b(this.c, 0, i);
                }
            }

            public final int jK_() {
                return -477813809;
            }

            public final GraphQLVisitableModel m15256a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m15255a(FlatBufferBuilder flatBufferBuilder) {
                h();
                flatBufferBuilder.c(1);
                flatBufferBuilder.a(0, this.f9724d, 0);
                i();
                return flatBufferBuilder.d();
            }

            public final void m15258a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                super.a(mutableFlatBuffer, i, obj);
                this.f9724d = mutableFlatBuffer.a(i, 0, 0);
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1723990064)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: num_missing */
        public final class EventMaybesModel extends BaseModel implements GraphQLVisitableModel {
            private int f9726d;

            /* compiled from: num_missing */
            public final class Builder {
                public int f9725a;

                public final EventMaybesModel m15259a() {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.a(0, this.f9725a, 0);
                    flatBufferBuilder.d(flatBufferBuilder.d());
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    return new EventMaybesModel(new MutableFlatBuffer(wrap, null, null, true, null));
                }
            }

            /* compiled from: num_missing */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(EventMaybesModel.class, new Deserializer());
                }

                public Object m15260a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(EventMaybesParser.m15478a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object eventMaybesModel = new EventMaybesModel();
                    ((BaseModel) eventMaybesModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (eventMaybesModel instanceof Postprocessable) {
                        return ((Postprocessable) eventMaybesModel).a();
                    }
                    return eventMaybesModel;
                }
            }

            /* compiled from: num_missing */
            public class Serializer extends JsonSerializer<EventMaybesModel> {
                public final void m15261a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    EventMaybesModel eventMaybesModel = (EventMaybesModel) obj;
                    if (eventMaybesModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(eventMaybesModel.m15263a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        eventMaybesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    EventMaybesParser.m15479a(eventMaybesModel.w_(), eventMaybesModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(EventMaybesModel.class, new Serializer());
                }
            }

            public EventMaybesModel() {
                super(1);
            }

            public EventMaybesModel(MutableFlatBuffer mutableFlatBuffer) {
                super(1);
                a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
            }

            public final int m15262a() {
                a(0, 0);
                return this.f9726d;
            }

            public final void m15265a(int i) {
                this.f9726d = i;
                if (this.b != null && this.b.d) {
                    this.b.b(this.c, 0, i);
                }
            }

            public final int jK_() {
                return 2065431779;
            }

            public final GraphQLVisitableModel m15264a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m15263a(FlatBufferBuilder flatBufferBuilder) {
                h();
                flatBufferBuilder.c(1);
                flatBufferBuilder.a(0, this.f9726d, 0);
                i();
                return flatBufferBuilder.d();
            }

            public final void m15266a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                super.a(mutableFlatBuffer, i, obj);
                this.f9726d = mutableFlatBuffer.a(i, 0, 0);
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1723990064)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: num_missing */
        public final class EventMembersModel extends BaseModel implements GraphQLVisitableModel {
            private int f9728d;

            /* compiled from: num_missing */
            public final class Builder {
                public int f9727a;

                public final EventMembersModel m15267a() {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.a(0, this.f9727a, 0);
                    flatBufferBuilder.d(flatBufferBuilder.d());
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    return new EventMembersModel(new MutableFlatBuffer(wrap, null, null, true, null));
                }
            }

            /* compiled from: num_missing */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(EventMembersModel.class, new Deserializer());
                }

                public Object m15268a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(EventMembersParser.m15480a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object eventMembersModel = new EventMembersModel();
                    ((BaseModel) eventMembersModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (eventMembersModel instanceof Postprocessable) {
                        return ((Postprocessable) eventMembersModel).a();
                    }
                    return eventMembersModel;
                }
            }

            /* compiled from: num_missing */
            public class Serializer extends JsonSerializer<EventMembersModel> {
                public final void m15269a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    EventMembersModel eventMembersModel = (EventMembersModel) obj;
                    if (eventMembersModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(eventMembersModel.m15271a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        eventMembersModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    EventMembersParser.m15481a(eventMembersModel.w_(), eventMembersModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(EventMembersModel.class, new Serializer());
                }
            }

            public EventMembersModel() {
                super(1);
            }

            public EventMembersModel(MutableFlatBuffer mutableFlatBuffer) {
                super(1);
                a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
            }

            public final int m15270a() {
                a(0, 0);
                return this.f9728d;
            }

            public final void m15273a(int i) {
                this.f9728d = i;
                if (this.b != null && this.b.d) {
                    this.b.b(this.c, 0, i);
                }
            }

            public final int jK_() {
                return -1848764035;
            }

            public final GraphQLVisitableModel m15272a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m15271a(FlatBufferBuilder flatBufferBuilder) {
                h();
                flatBufferBuilder.c(1);
                flatBufferBuilder.a(0, this.f9728d, 0);
                i();
                return flatBufferBuilder.d();
            }

            public final void m15274a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                super.a(mutableFlatBuffer, i, obj);
                this.f9728d = mutableFlatBuffer.a(i, 0, 0);
            }
        }

        /* compiled from: num_missing */
        public class Serializer extends JsonSerializer<EventGuestCountsMutationFragmentModel> {
            public final void m15275a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                EventGuestCountsMutationFragmentModel eventGuestCountsMutationFragmentModel = (EventGuestCountsMutationFragmentModel) obj;
                if (eventGuestCountsMutationFragmentModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(eventGuestCountsMutationFragmentModel.m15281a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    eventGuestCountsMutationFragmentModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                EventGuestCountsMutationFragmentParser.m15483a(eventGuestCountsMutationFragmentModel.w_(), eventGuestCountsMutationFragmentModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(EventGuestCountsMutationFragmentModel.class, new Serializer());
            }
        }

        public EventGuestCountsMutationFragmentModel() {
            super(5);
        }

        public EventGuestCountsMutationFragmentModel(MutableFlatBuffer mutableFlatBuffer) {
            super(5);
            a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
        }

        public final void m15284a(String str, ConsistencyTuple consistencyTuple) {
            if ("event_declines.count".equals(str)) {
                EventDeclinesModel j = m15276j();
                if (j != null) {
                    consistencyTuple.a = Integer.valueOf(j.m15246a());
                    consistencyTuple.b = j.u_();
                    consistencyTuple.c = 0;
                    return;
                }
            } else if ("event_invitees.count".equals(str)) {
                EventInviteesModel k = m15277k();
                if (k != null) {
                    consistencyTuple.a = Integer.valueOf(k.m15254a());
                    consistencyTuple.b = k.u_();
                    consistencyTuple.c = 0;
                    return;
                }
            } else if ("event_maybes.count".equals(str)) {
                EventMaybesModel l = m15278l();
                if (l != null) {
                    consistencyTuple.a = Integer.valueOf(l.m15262a());
                    consistencyTuple.b = l.u_();
                    consistencyTuple.c = 0;
                    return;
                }
            } else if ("event_members.count".equals(str)) {
                EventMembersModel m = m15279m();
                if (m != null) {
                    consistencyTuple.a = Integer.valueOf(m.m15270a());
                    consistencyTuple.b = m.u_();
                    consistencyTuple.c = 0;
                    return;
                }
            }
            consistencyTuple.a();
        }

        public final void m15285a(String str, Object obj, boolean z) {
            if ("event_declines.count".equals(str)) {
                EventDeclinesModel j = m15276j();
                if (j == null) {
                    return;
                }
                if (z) {
                    j = (EventDeclinesModel) j.clone();
                    j.m15249a(((Integer) obj).intValue());
                    this.f9729d = j;
                    return;
                }
                j.m15249a(((Integer) obj).intValue());
            } else if ("event_invitees.count".equals(str)) {
                EventInviteesModel k = m15277k();
                if (k == null) {
                    return;
                }
                if (z) {
                    k = (EventInviteesModel) k.clone();
                    k.m15257a(((Integer) obj).intValue());
                    this.f9730e = k;
                    return;
                }
                k.m15257a(((Integer) obj).intValue());
            } else if ("event_maybes.count".equals(str)) {
                EventMaybesModel l = m15278l();
                if (l == null) {
                    return;
                }
                if (z) {
                    l = (EventMaybesModel) l.clone();
                    l.m15265a(((Integer) obj).intValue());
                    this.f9731f = l;
                    return;
                }
                l.m15265a(((Integer) obj).intValue());
            } else if ("event_members.count".equals(str)) {
                EventMembersModel m = m15279m();
                if (m == null) {
                    return;
                }
                if (z) {
                    m = (EventMembersModel) m.clone();
                    m.m15273a(((Integer) obj).intValue());
                    this.f9732g = m;
                    return;
                }
                m.m15273a(((Integer) obj).intValue());
            }
        }

        @Nullable
        private EventDeclinesModel m15276j() {
            this.f9729d = (EventDeclinesModel) super.a(this.f9729d, 0, EventDeclinesModel.class);
            return this.f9729d;
        }

        @Nullable
        private EventInviteesModel m15277k() {
            this.f9730e = (EventInviteesModel) super.a(this.f9730e, 1, EventInviteesModel.class);
            return this.f9730e;
        }

        @Nullable
        private EventMaybesModel m15278l() {
            this.f9731f = (EventMaybesModel) super.a(this.f9731f, 2, EventMaybesModel.class);
            return this.f9731f;
        }

        @Nullable
        private EventMembersModel m15279m() {
            this.f9732g = (EventMembersModel) super.a(this.f9732g, 3, EventMembersModel.class);
            return this.f9732g;
        }

        @Nullable
        private String m15280n() {
            this.f9733h = super.a(this.f9733h, 4);
            return this.f9733h;
        }

        @Nullable
        public final String m15283a() {
            return m15280n();
        }

        public final int jK_() {
            return 67338874;
        }

        public final GraphQLVisitableModel m15282a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m15276j() != null) {
                EventDeclinesModel eventDeclinesModel = (EventDeclinesModel) graphQLModelMutatingVisitor.b(m15276j());
                if (m15276j() != eventDeclinesModel) {
                    graphQLVisitableModel = (EventGuestCountsMutationFragmentModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f9729d = eventDeclinesModel;
                }
            }
            if (m15277k() != null) {
                EventInviteesModel eventInviteesModel = (EventInviteesModel) graphQLModelMutatingVisitor.b(m15277k());
                if (m15277k() != eventInviteesModel) {
                    graphQLVisitableModel = (EventGuestCountsMutationFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f9730e = eventInviteesModel;
                }
            }
            if (m15278l() != null) {
                EventMaybesModel eventMaybesModel = (EventMaybesModel) graphQLModelMutatingVisitor.b(m15278l());
                if (m15278l() != eventMaybesModel) {
                    graphQLVisitableModel = (EventGuestCountsMutationFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f9731f = eventMaybesModel;
                }
            }
            if (m15279m() != null) {
                EventMembersModel eventMembersModel = (EventMembersModel) graphQLModelMutatingVisitor.b(m15279m());
                if (m15279m() != eventMembersModel) {
                    graphQLVisitableModel = (EventGuestCountsMutationFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f9732g = eventMembersModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m15281a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m15276j());
            int a2 = ModelHelper.a(flatBufferBuilder, m15277k());
            int a3 = ModelHelper.a(flatBufferBuilder, m15278l());
            int a4 = ModelHelper.a(flatBufferBuilder, m15279m());
            int b = flatBufferBuilder.b(m15280n());
            flatBufferBuilder.c(5);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, a2);
            flatBufferBuilder.b(2, a3);
            flatBufferBuilder.b(3, a4);
            flatBufferBuilder.b(4, b);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -2642782)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: num_missing */
    public final class EventInviteMutationModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private String f9734d;

        /* compiled from: num_missing */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(EventInviteMutationModel.class, new Deserializer());
            }

            public Object m15286a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = EventInviteMutationParser.m15484a(jsonParser);
                Object eventInviteMutationModel = new EventInviteMutationModel();
                ((BaseModel) eventInviteMutationModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (eventInviteMutationModel instanceof Postprocessable) {
                    return ((Postprocessable) eventInviteMutationModel).a();
                }
                return eventInviteMutationModel;
            }
        }

        /* compiled from: num_missing */
        public class Serializer extends JsonSerializer<EventInviteMutationModel> {
            public final void m15287a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                EventInviteMutationModel eventInviteMutationModel = (EventInviteMutationModel) obj;
                if (eventInviteMutationModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(eventInviteMutationModel.m15289a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    eventInviteMutationModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = eventInviteMutationModel.w_();
                int u_ = eventInviteMutationModel.u_();
                jsonGenerator.f();
                if (mutableFlatBuffer.g(u_, 0) != 0) {
                    jsonGenerator.a("client_mutation_id");
                    jsonGenerator.b(mutableFlatBuffer.c(u_, 0));
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(EventInviteMutationModel.class, new Serializer());
            }
        }

        public EventInviteMutationModel() {
            super(1);
        }

        @Nullable
        private String m15288a() {
            this.f9734d = super.a(this.f9734d, 0);
            return this.f9734d;
        }

        public final int jK_() {
            return -2140750486;
        }

        public final GraphQLVisitableModel m15290a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            h();
            i();
            return this;
        }

        public final int m15289a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(m15288a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, b);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -2642782)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: num_missing */
    public final class EventPromptXOutMutationModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private String f9735d;

        /* compiled from: num_missing */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(EventPromptXOutMutationModel.class, new Deserializer());
            }

            public Object m15291a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = EventPromptXOutMutationParser.m15485a(jsonParser);
                Object eventPromptXOutMutationModel = new EventPromptXOutMutationModel();
                ((BaseModel) eventPromptXOutMutationModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (eventPromptXOutMutationModel instanceof Postprocessable) {
                    return ((Postprocessable) eventPromptXOutMutationModel).a();
                }
                return eventPromptXOutMutationModel;
            }
        }

        /* compiled from: num_missing */
        public class Serializer extends JsonSerializer<EventPromptXOutMutationModel> {
            public final void m15292a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                EventPromptXOutMutationModel eventPromptXOutMutationModel = (EventPromptXOutMutationModel) obj;
                if (eventPromptXOutMutationModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(eventPromptXOutMutationModel.m15294a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    eventPromptXOutMutationModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = eventPromptXOutMutationModel.w_();
                int u_ = eventPromptXOutMutationModel.u_();
                jsonGenerator.f();
                if (mutableFlatBuffer.g(u_, 0) != 0) {
                    jsonGenerator.a("client_mutation_id");
                    jsonGenerator.b(mutableFlatBuffer.c(u_, 0));
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(EventPromptXOutMutationModel.class, new Serializer());
            }
        }

        public EventPromptXOutMutationModel() {
            super(1);
        }

        @Nullable
        private String m15293a() {
            this.f9735d = super.a(this.f9735d, 0);
            return this.f9735d;
        }

        public final int jK_() {
            return -1723914930;
        }

        public final GraphQLVisitableModel m15295a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            h();
            i();
            return this;
        }

        public final int m15294a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(m15293a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, b);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -247061784)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: num_missing */
    public final class EventPurchaseTicketMutationAsyncModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private EventPurchaseTicketMutationResultModel f9736d;

        /* compiled from: num_missing */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(EventPurchaseTicketMutationAsyncModel.class, new Deserializer());
            }

            public Object m15296a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = EventPurchaseTicketMutationAsyncParser.m15486a(jsonParser);
                Object eventPurchaseTicketMutationAsyncModel = new EventPurchaseTicketMutationAsyncModel();
                ((BaseModel) eventPurchaseTicketMutationAsyncModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (eventPurchaseTicketMutationAsyncModel instanceof Postprocessable) {
                    return ((Postprocessable) eventPurchaseTicketMutationAsyncModel).a();
                }
                return eventPurchaseTicketMutationAsyncModel;
            }
        }

        /* compiled from: num_missing */
        public class Serializer extends JsonSerializer<EventPurchaseTicketMutationAsyncModel> {
            public final void m15297a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                EventPurchaseTicketMutationAsyncModel eventPurchaseTicketMutationAsyncModel = (EventPurchaseTicketMutationAsyncModel) obj;
                if (eventPurchaseTicketMutationAsyncModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(eventPurchaseTicketMutationAsyncModel.m15298a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    eventPurchaseTicketMutationAsyncModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = eventPurchaseTicketMutationAsyncModel.w_();
                int u_ = eventPurchaseTicketMutationAsyncModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("event_ticket_order");
                    EventPurchaseTicketMutationResultParser.m14937a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(EventPurchaseTicketMutationAsyncModel.class, new Serializer());
            }
        }

        public EventPurchaseTicketMutationAsyncModel() {
            super(1);
        }

        @Nullable
        public final EventPurchaseTicketMutationResultModel m15299a() {
            this.f9736d = (EventPurchaseTicketMutationResultModel) super.a(this.f9736d, 0, EventPurchaseTicketMutationResultModel.class);
            return this.f9736d;
        }

        public final int jK_() {
            return 1612568285;
        }

        public final GraphQLVisitableModel m15300a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m15299a() != null) {
                EventPurchaseTicketMutationResultModel eventPurchaseTicketMutationResultModel = (EventPurchaseTicketMutationResultModel) graphQLModelMutatingVisitor.b(m15299a());
                if (m15299a() != eventPurchaseTicketMutationResultModel) {
                    graphQLVisitableModel = (EventPurchaseTicketMutationAsyncModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f9736d = eventPurchaseTicketMutationResultModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m15298a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m15299a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 331510840)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: num_missing */
    public final class EventPurchaseTicketMutationModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private DefaultTextWithEntitiesLongFieldsModel f9745d;
        @Nullable
        private String f9746e;
        @Nullable
        private EventTicketTierPermalinkFragmentModel f9747f;
        @Nullable
        private OrderModel f9748g;
        @Nullable
        private String f9749h;

        /* compiled from: num_missing */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(EventPurchaseTicketMutationModel.class, new Deserializer());
            }

            public Object m15301a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = EventPurchaseTicketMutationParser.m15497a(jsonParser);
                Object eventPurchaseTicketMutationModel = new EventPurchaseTicketMutationModel();
                ((BaseModel) eventPurchaseTicketMutationModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (eventPurchaseTicketMutationModel instanceof Postprocessable) {
                    return ((Postprocessable) eventPurchaseTicketMutationModel).a();
                }
                return eventPurchaseTicketMutationModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -2114315499)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: num_missing */
        public final class OrderModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel {
            @Nullable
            private ClaimActionLinkModel f9742d;
            @Nullable
            private EventTicketsModel f9743e;
            @Nullable
            private String f9744f;

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = 1716483899)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: num_missing */
            public final class ClaimActionLinkModel extends BaseModel implements GraphQLVisitableModel {
                @Nullable
                private String f9737d;
                @Nullable
                private String f9738e;

                /* compiled from: num_missing */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(ClaimActionLinkModel.class, new Deserializer());
                    }

                    public Object m15302a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(ClaimActionLinkParser.m15487a(jsonParser, flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                        Object claimActionLinkModel = new ClaimActionLinkModel();
                        ((BaseModel) claimActionLinkModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                        if (claimActionLinkModel instanceof Postprocessable) {
                            return ((Postprocessable) claimActionLinkModel).a();
                        }
                        return claimActionLinkModel;
                    }
                }

                /* compiled from: num_missing */
                public class Serializer extends JsonSerializer<ClaimActionLinkModel> {
                    public final void m15303a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        ClaimActionLinkModel claimActionLinkModel = (ClaimActionLinkModel) obj;
                        if (claimActionLinkModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(claimActionLinkModel.m15306a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            claimActionLinkModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        ClaimActionLinkParser.m15488a(claimActionLinkModel.w_(), claimActionLinkModel.u_(), jsonGenerator);
                    }

                    static {
                        FbSerializerProvider.a(ClaimActionLinkModel.class, new Serializer());
                    }
                }

                public ClaimActionLinkModel() {
                    super(2);
                }

                @Nullable
                private String m15304a() {
                    this.f9737d = super.a(this.f9737d, 0);
                    return this.f9737d;
                }

                @Nullable
                private String m15305j() {
                    this.f9738e = super.a(this.f9738e, 1);
                    return this.f9738e;
                }

                public final int jK_() {
                    return -1365487538;
                }

                public final GraphQLVisitableModel m15307a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    h();
                    i();
                    return this;
                }

                public final int m15306a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int b = flatBufferBuilder.b(m15304a());
                    int b2 = flatBufferBuilder.b(m15305j());
                    flatBufferBuilder.c(2);
                    flatBufferBuilder.b(0, b);
                    flatBufferBuilder.b(1, b2);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            /* compiled from: num_missing */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(OrderModel.class, new Deserializer());
                }

                public Object m15308a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(OrderParser.m15495a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object orderModel = new OrderModel();
                    ((BaseModel) orderModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (orderModel instanceof Postprocessable) {
                        return ((Postprocessable) orderModel).a();
                    }
                    return orderModel;
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = -121054081)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: num_missing */
            public final class EventTicketsModel extends BaseModel implements GraphQLVisitableModel {
                @Nullable
                private List<NodesModel> f9741d;

                /* compiled from: num_missing */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(EventTicketsModel.class, new Deserializer());
                    }

                    public Object m15309a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(EventTicketsParser.m15493a(jsonParser, flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                        Object eventTicketsModel = new EventTicketsModel();
                        ((BaseModel) eventTicketsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                        if (eventTicketsModel instanceof Postprocessable) {
                            return ((Postprocessable) eventTicketsModel).a();
                        }
                        return eventTicketsModel;
                    }
                }

                @JsonDeserialize(using = Deserializer.class)
                @ModelWithFlatBufferFormatHash(a = -1614038928)
                @JsonSerialize(using = Serializer.class)
                @FragmentModelWithoutBridge
                /* compiled from: num_missing */
                public final class NodesModel extends BaseModel implements GraphQLVisitableModel {
                    @Nullable
                    private FbqrcodeModel f9740d;

                    /* compiled from: num_missing */
                    public class Deserializer extends FbJsonDeserializer {
                        static {
                            GlobalAutoGenDeserializerCache.a(NodesModel.class, new Deserializer());
                        }

                        public Object m15310a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(NodesParser.m15491b(jsonParser, flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            mutableFlatBuffer.a(4, Boolean.valueOf(true));
                            MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                            Object nodesModel = new NodesModel();
                            ((BaseModel) nodesModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                            if (nodesModel instanceof Postprocessable) {
                                return ((Postprocessable) nodesModel).a();
                            }
                            return nodesModel;
                        }
                    }

                    @JsonDeserialize(using = Deserializer.class)
                    @ModelWithFlatBufferFormatHash(a = 1801334754)
                    @JsonSerialize(using = Serializer.class)
                    @FragmentModelWithoutBridge
                    /* compiled from: num_missing */
                    public final class FbqrcodeModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel {
                        @Nullable
                        private String f9739d;

                        /* compiled from: num_missing */
                        public class Deserializer extends FbJsonDeserializer {
                            static {
                                GlobalAutoGenDeserializerCache.a(FbqrcodeModel.class, new Deserializer());
                            }

                            public Object m15311a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                flatBufferBuilder.d(FbqrcodeParser.m15489a(jsonParser, flatBufferBuilder));
                                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                wrap.position(0);
                                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                                Object fbqrcodeModel = new FbqrcodeModel();
                                ((BaseModel) fbqrcodeModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                                if (fbqrcodeModel instanceof Postprocessable) {
                                    return ((Postprocessable) fbqrcodeModel).a();
                                }
                                return fbqrcodeModel;
                            }
                        }

                        /* compiled from: num_missing */
                        public class Serializer extends JsonSerializer<FbqrcodeModel> {
                            public final void m15312a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                                FbqrcodeModel fbqrcodeModel = (FbqrcodeModel) obj;
                                if (fbqrcodeModel.w_() == null) {
                                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                    flatBufferBuilder.d(fbqrcodeModel.m15314a(flatBufferBuilder));
                                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                    wrap.position(0);
                                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                    fbqrcodeModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                                }
                                FbqrcodeParser.m15490a(fbqrcodeModel.w_(), fbqrcodeModel.u_(), jsonGenerator);
                            }

                            static {
                                FbSerializerProvider.a(FbqrcodeModel.class, new Serializer());
                            }
                        }

                        public FbqrcodeModel() {
                            super(1);
                        }

                        @Nullable
                        private String m15313j() {
                            this.f9739d = super.a(this.f9739d, 0);
                            return this.f9739d;
                        }

                        @Nullable
                        public final String m15316a() {
                            return m15313j();
                        }

                        public final int jK_() {
                            return -1714831510;
                        }

                        public final GraphQLVisitableModel m15315a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                            h();
                            i();
                            return this;
                        }

                        public final int m15314a(FlatBufferBuilder flatBufferBuilder) {
                            h();
                            int b = flatBufferBuilder.b(m15313j());
                            flatBufferBuilder.c(1);
                            flatBufferBuilder.b(0, b);
                            i();
                            return flatBufferBuilder.d();
                        }
                    }

                    /* compiled from: num_missing */
                    public class Serializer extends JsonSerializer<NodesModel> {
                        public final void m15317a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                            NodesModel nodesModel = (NodesModel) obj;
                            if (nodesModel.w_() == null) {
                                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                flatBufferBuilder.d(nodesModel.m15319a(flatBufferBuilder));
                                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                wrap.position(0);
                                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                nodesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                            }
                            NodesParser.m15492b(nodesModel.w_(), nodesModel.u_(), jsonGenerator, serializerProvider);
                        }

                        static {
                            FbSerializerProvider.a(NodesModel.class, new Serializer());
                        }
                    }

                    public NodesModel() {
                        super(1);
                    }

                    @Nullable
                    private FbqrcodeModel m15318a() {
                        this.f9740d = (FbqrcodeModel) super.a(this.f9740d, 0, FbqrcodeModel.class);
                        return this.f9740d;
                    }

                    public final int jK_() {
                        return 1599763871;
                    }

                    public final GraphQLVisitableModel m15320a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                        GraphQLVisitableModel graphQLVisitableModel = null;
                        h();
                        if (m15318a() != null) {
                            FbqrcodeModel fbqrcodeModel = (FbqrcodeModel) graphQLModelMutatingVisitor.b(m15318a());
                            if (m15318a() != fbqrcodeModel) {
                                graphQLVisitableModel = (NodesModel) ModelHelper.a(null, this);
                                graphQLVisitableModel.f9740d = fbqrcodeModel;
                            }
                        }
                        i();
                        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                    }

                    public final int m15319a(FlatBufferBuilder flatBufferBuilder) {
                        h();
                        int a = ModelHelper.a(flatBufferBuilder, m15318a());
                        flatBufferBuilder.c(1);
                        flatBufferBuilder.b(0, a);
                        i();
                        return flatBufferBuilder.d();
                    }
                }

                /* compiled from: num_missing */
                public class Serializer extends JsonSerializer<EventTicketsModel> {
                    public final void m15321a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        EventTicketsModel eventTicketsModel = (EventTicketsModel) obj;
                        if (eventTicketsModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(eventTicketsModel.m15323a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            eventTicketsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        EventTicketsParser.m15494a(eventTicketsModel.w_(), eventTicketsModel.u_(), jsonGenerator, serializerProvider);
                    }

                    static {
                        FbSerializerProvider.a(EventTicketsModel.class, new Serializer());
                    }
                }

                public EventTicketsModel() {
                    super(1);
                }

                @Nonnull
                private ImmutableList<NodesModel> m15322a() {
                    this.f9741d = super.a(this.f9741d, 0, NodesModel.class);
                    return (ImmutableList) this.f9741d;
                }

                public final int jK_() {
                    return 1465911203;
                }

                public final GraphQLVisitableModel m15324a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    GraphQLVisitableModel graphQLVisitableModel = null;
                    h();
                    if (m15322a() != null) {
                        Builder a = ModelHelper.a(m15322a(), graphQLModelMutatingVisitor);
                        if (a != null) {
                            graphQLVisitableModel = (EventTicketsModel) ModelHelper.a(null, this);
                            graphQLVisitableModel.f9741d = a.b();
                        }
                    }
                    i();
                    return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                }

                public final int m15323a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int a = ModelHelper.a(flatBufferBuilder, m15322a());
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.b(0, a);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            /* compiled from: num_missing */
            public class Serializer extends JsonSerializer<OrderModel> {
                public final void m15325a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    OrderModel orderModel = (OrderModel) obj;
                    if (orderModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(orderModel.m15329a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        orderModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    OrderParser.m15496a(orderModel.w_(), orderModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(OrderModel.class, new Serializer());
                }
            }

            public OrderModel() {
                super(3);
            }

            @Nullable
            private ClaimActionLinkModel m15326j() {
                this.f9742d = (ClaimActionLinkModel) super.a(this.f9742d, 0, ClaimActionLinkModel.class);
                return this.f9742d;
            }

            @Nullable
            private EventTicketsModel m15327k() {
                this.f9743e = (EventTicketsModel) super.a(this.f9743e, 1, EventTicketsModel.class);
                return this.f9743e;
            }

            @Nullable
            private String m15328l() {
                this.f9744f = super.a(this.f9744f, 2);
                return this.f9744f;
            }

            @Nullable
            public final String m15331a() {
                return m15328l();
            }

            public final int jK_() {
                return -992679736;
            }

            public final GraphQLVisitableModel m15330a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m15326j() != null) {
                    ClaimActionLinkModel claimActionLinkModel = (ClaimActionLinkModel) graphQLModelMutatingVisitor.b(m15326j());
                    if (m15326j() != claimActionLinkModel) {
                        graphQLVisitableModel = (OrderModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f9742d = claimActionLinkModel;
                    }
                }
                if (m15327k() != null) {
                    EventTicketsModel eventTicketsModel = (EventTicketsModel) graphQLModelMutatingVisitor.b(m15327k());
                    if (m15327k() != eventTicketsModel) {
                        graphQLVisitableModel = (OrderModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f9743e = eventTicketsModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m15329a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m15326j());
                int a2 = ModelHelper.a(flatBufferBuilder, m15327k());
                int b = flatBufferBuilder.b(m15328l());
                flatBufferBuilder.c(3);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.b(1, a2);
                flatBufferBuilder.b(2, b);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: num_missing */
        public class Serializer extends JsonSerializer<EventPurchaseTicketMutationModel> {
            public final void m15332a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                EventPurchaseTicketMutationModel eventPurchaseTicketMutationModel = (EventPurchaseTicketMutationModel) obj;
                if (eventPurchaseTicketMutationModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(eventPurchaseTicketMutationModel.m15333a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    eventPurchaseTicketMutationModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = eventPurchaseTicketMutationModel.w_();
                int u_ = eventPurchaseTicketMutationModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("confirmation_message");
                    DefaultTextWithEntitiesLongFieldsParser.b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                if (mutableFlatBuffer.g(u_, 1) != 0) {
                    jsonGenerator.a("error_message");
                    jsonGenerator.b(mutableFlatBuffer.c(u_, 1));
                }
                g = mutableFlatBuffer.g(u_, 2);
                if (g != 0) {
                    jsonGenerator.a("event");
                    EventTicketTierPermalinkFragmentParser.m15028a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                g = mutableFlatBuffer.g(u_, 3);
                if (g != 0) {
                    jsonGenerator.a("order");
                    OrderParser.m15496a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                if (mutableFlatBuffer.g(u_, 4) != 0) {
                    jsonGenerator.a("response_code");
                    jsonGenerator.b(mutableFlatBuffer.c(u_, 4));
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(EventPurchaseTicketMutationModel.class, new Serializer());
            }
        }

        public EventPurchaseTicketMutationModel() {
            super(5);
        }

        @Nullable
        public final DefaultTextWithEntitiesLongFieldsModel m15334a() {
            this.f9745d = (DefaultTextWithEntitiesLongFieldsModel) super.a(this.f9745d, 0, DefaultTextWithEntitiesLongFieldsModel.class);
            return this.f9745d;
        }

        @Nullable
        public final String m15336j() {
            this.f9746e = super.a(this.f9746e, 1);
            return this.f9746e;
        }

        @Nullable
        public final EventTicketTierPermalinkFragmentModel m15337k() {
            this.f9747f = (EventTicketTierPermalinkFragmentModel) super.a(this.f9747f, 2, EventTicketTierPermalinkFragmentModel.class);
            return this.f9747f;
        }

        @Nullable
        public final OrderModel m15338l() {
            this.f9748g = (OrderModel) super.a(this.f9748g, 3, OrderModel.class);
            return this.f9748g;
        }

        @Nullable
        public final String m15339m() {
            this.f9749h = super.a(this.f9749h, 4);
            return this.f9749h;
        }

        public final int jK_() {
            return 1503463329;
        }

        public final GraphQLVisitableModel m15335a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m15334a() != null) {
                DefaultTextWithEntitiesLongFieldsModel defaultTextWithEntitiesLongFieldsModel = (DefaultTextWithEntitiesLongFieldsModel) graphQLModelMutatingVisitor.b(m15334a());
                if (m15334a() != defaultTextWithEntitiesLongFieldsModel) {
                    graphQLVisitableModel = (EventPurchaseTicketMutationModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f9745d = defaultTextWithEntitiesLongFieldsModel;
                }
            }
            if (m15337k() != null) {
                EventTicketTierPermalinkFragmentModel eventTicketTierPermalinkFragmentModel = (EventTicketTierPermalinkFragmentModel) graphQLModelMutatingVisitor.b(m15337k());
                if (m15337k() != eventTicketTierPermalinkFragmentModel) {
                    graphQLVisitableModel = (EventPurchaseTicketMutationModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f9747f = eventTicketTierPermalinkFragmentModel;
                }
            }
            if (m15338l() != null) {
                OrderModel orderModel = (OrderModel) graphQLModelMutatingVisitor.b(m15338l());
                if (m15338l() != orderModel) {
                    graphQLVisitableModel = (EventPurchaseTicketMutationModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f9748g = orderModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m15333a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m15334a());
            int b = flatBufferBuilder.b(m15336j());
            int a2 = ModelHelper.a(flatBufferBuilder, m15337k());
            int a3 = ModelHelper.a(flatBufferBuilder, m15338l());
            int b2 = flatBufferBuilder.b(m15339m());
            flatBufferBuilder.c(5);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, b);
            flatBufferBuilder.b(2, a2);
            flatBufferBuilder.b(3, a3);
            flatBufferBuilder.b(4, b2);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 891822883)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: num_missing */
    public final class EventRsvpMutationModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private String f9750d;
        @Nullable
        private OptimisticRsvpEventModel f9751e;

        /* compiled from: num_missing */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(EventRsvpMutationModel.class, new Deserializer());
            }

            public Object m15340a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = EventRsvpMutationParser.m15498a(jsonParser);
                Object eventRsvpMutationModel = new EventRsvpMutationModel();
                ((BaseModel) eventRsvpMutationModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (eventRsvpMutationModel instanceof Postprocessable) {
                    return ((Postprocessable) eventRsvpMutationModel).a();
                }
                return eventRsvpMutationModel;
            }
        }

        /* compiled from: num_missing */
        public class Serializer extends JsonSerializer<EventRsvpMutationModel> {
            public final void m15341a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                EventRsvpMutationModel eventRsvpMutationModel = (EventRsvpMutationModel) obj;
                if (eventRsvpMutationModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(eventRsvpMutationModel.m15343a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    eventRsvpMutationModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = eventRsvpMutationModel.w_();
                int u_ = eventRsvpMutationModel.u_();
                jsonGenerator.f();
                if (mutableFlatBuffer.g(u_, 0) != 0) {
                    jsonGenerator.a("client_mutation_id");
                    jsonGenerator.b(mutableFlatBuffer.c(u_, 0));
                }
                int g = mutableFlatBuffer.g(u_, 1);
                if (g != 0) {
                    jsonGenerator.a("event");
                    OptimisticRsvpEventParser.m15518a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(EventRsvpMutationModel.class, new Serializer());
            }
        }

        public EventRsvpMutationModel() {
            super(2);
        }

        @Nullable
        private String m15342j() {
            this.f9750d = super.a(this.f9750d, 0);
            return this.f9750d;
        }

        @Nullable
        public final OptimisticRsvpEventModel m15344a() {
            this.f9751e = (OptimisticRsvpEventModel) super.a(this.f9751e, 1, OptimisticRsvpEventModel.class);
            return this.f9751e;
        }

        public final int jK_() {
            return 1448129272;
        }

        public final GraphQLVisitableModel m15345a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m15344a() != null) {
                OptimisticRsvpEventModel optimisticRsvpEventModel = (OptimisticRsvpEventModel) graphQLModelMutatingVisitor.b(m15344a());
                if (m15344a() != optimisticRsvpEventModel) {
                    graphQLVisitableModel = (EventRsvpMutationModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f9751e = optimisticRsvpEventModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m15343a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(m15342j());
            int a = ModelHelper.a(flatBufferBuilder, m15344a());
            flatBufferBuilder.c(2);
            flatBufferBuilder.b(0, b);
            flatBufferBuilder.b(1, a);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 891822883)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: num_missing */
    public final class EventRsvpSubscriptionModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private String f9752d;
        @Nullable
        private OptimisticRsvpEventModel f9753e;

        /* compiled from: num_missing */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(EventRsvpSubscriptionModel.class, new Deserializer());
            }

            public Object m15346a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = EventRsvpSubscriptionParser.m15499a(jsonParser);
                Object eventRsvpSubscriptionModel = new EventRsvpSubscriptionModel();
                ((BaseModel) eventRsvpSubscriptionModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (eventRsvpSubscriptionModel instanceof Postprocessable) {
                    return ((Postprocessable) eventRsvpSubscriptionModel).a();
                }
                return eventRsvpSubscriptionModel;
            }
        }

        /* compiled from: num_missing */
        public class Serializer extends JsonSerializer<EventRsvpSubscriptionModel> {
            public final void m15347a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                EventRsvpSubscriptionModel eventRsvpSubscriptionModel = (EventRsvpSubscriptionModel) obj;
                if (eventRsvpSubscriptionModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(eventRsvpSubscriptionModel.m15350a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    eventRsvpSubscriptionModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = eventRsvpSubscriptionModel.w_();
                int u_ = eventRsvpSubscriptionModel.u_();
                jsonGenerator.f();
                if (mutableFlatBuffer.g(u_, 0) != 0) {
                    jsonGenerator.a("client_mutation_id");
                    jsonGenerator.b(mutableFlatBuffer.c(u_, 0));
                }
                int g = mutableFlatBuffer.g(u_, 1);
                if (g != 0) {
                    jsonGenerator.a("event");
                    OptimisticRsvpEventParser.m15518a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(EventRsvpSubscriptionModel.class, new Serializer());
            }
        }

        public EventRsvpSubscriptionModel() {
            super(2);
        }

        @Nullable
        private String m15348a() {
            this.f9752d = super.a(this.f9752d, 0);
            return this.f9752d;
        }

        @Nullable
        private OptimisticRsvpEventModel m15349j() {
            this.f9753e = (OptimisticRsvpEventModel) super.a(this.f9753e, 1, OptimisticRsvpEventModel.class);
            return this.f9753e;
        }

        public final int jK_() {
            return 1448129272;
        }

        public final GraphQLVisitableModel m15351a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m15349j() != null) {
                OptimisticRsvpEventModel optimisticRsvpEventModel = (OptimisticRsvpEventModel) graphQLModelMutatingVisitor.b(m15349j());
                if (m15349j() != optimisticRsvpEventModel) {
                    graphQLVisitableModel = (EventRsvpSubscriptionModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f9753e = optimisticRsvpEventModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m15350a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(m15348a());
            int a = ModelHelper.a(flatBufferBuilder, m15349j());
            flatBufferBuilder.c(2);
            flatBufferBuilder.b(0, b);
            flatBufferBuilder.b(1, a);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -907103917)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: num_missing */
    public final class EventSoftCancelMutationModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private String f9756d;
        @Nullable
        private EventModel f9757e;

        /* compiled from: num_missing */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(EventSoftCancelMutationModel.class, new Deserializer());
            }

            public Object m15352a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = EventSoftCancelMutationParser.m15502a(jsonParser);
                Object eventSoftCancelMutationModel = new EventSoftCancelMutationModel();
                ((BaseModel) eventSoftCancelMutationModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (eventSoftCancelMutationModel instanceof Postprocessable) {
                    return ((Postprocessable) eventSoftCancelMutationModel).a();
                }
                return eventSoftCancelMutationModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -312248176)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: num_missing */
        public final class EventModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
            @Nullable
            private String f9754d;
            private boolean f9755e;

            /* compiled from: num_missing */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(EventModel.class, new Deserializer());
                }

                public Object m15353a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(EventParser.m15500a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object eventModel = new EventModel();
                    ((BaseModel) eventModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (eventModel instanceof Postprocessable) {
                        return ((Postprocessable) eventModel).a();
                    }
                    return eventModel;
                }
            }

            /* compiled from: num_missing */
            public class Serializer extends JsonSerializer<EventModel> {
                public final void m15354a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    EventModel eventModel = (EventModel) obj;
                    if (eventModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(eventModel.m15358a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        eventModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    EventParser.m15501a(eventModel.w_(), eventModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(EventModel.class, new Serializer());
                }
            }

            public EventModel() {
                super(2);
            }

            public final void m15362a(String str, ConsistencyTuple consistencyTuple) {
                if ("is_canceled".equals(str)) {
                    consistencyTuple.a = Boolean.valueOf(m15357k());
                    consistencyTuple.b = u_();
                    consistencyTuple.c = 1;
                    return;
                }
                consistencyTuple.a();
            }

            public final void m15363a(String str, Object obj, boolean z) {
                if ("is_canceled".equals(str)) {
                    m15355a(((Boolean) obj).booleanValue());
                }
            }

            @Nullable
            private String m15356j() {
                this.f9754d = super.a(this.f9754d, 0);
                return this.f9754d;
            }

            private boolean m15357k() {
                a(0, 1);
                return this.f9755e;
            }

            private void m15355a(boolean z) {
                this.f9755e = z;
                if (this.b != null && this.b.d) {
                    this.b.a(this.c, 1, z);
                }
            }

            @Nullable
            public final String m15360a() {
                return m15356j();
            }

            public final int jK_() {
                return 67338874;
            }

            public final GraphQLVisitableModel m15359a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m15358a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m15356j());
                flatBufferBuilder.c(2);
                flatBufferBuilder.b(0, b);
                flatBufferBuilder.a(1, this.f9755e);
                i();
                return flatBufferBuilder.d();
            }

            public final void m15361a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                super.a(mutableFlatBuffer, i, obj);
                this.f9755e = mutableFlatBuffer.a(i, 1);
            }
        }

        /* compiled from: num_missing */
        public class Serializer extends JsonSerializer<EventSoftCancelMutationModel> {
            public final void m15364a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                EventSoftCancelMutationModel eventSoftCancelMutationModel = (EventSoftCancelMutationModel) obj;
                if (eventSoftCancelMutationModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(eventSoftCancelMutationModel.m15367a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    eventSoftCancelMutationModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = eventSoftCancelMutationModel.w_();
                int u_ = eventSoftCancelMutationModel.u_();
                jsonGenerator.f();
                if (mutableFlatBuffer.g(u_, 0) != 0) {
                    jsonGenerator.a("client_mutation_id");
                    jsonGenerator.b(mutableFlatBuffer.c(u_, 0));
                }
                int g = mutableFlatBuffer.g(u_, 1);
                if (g != 0) {
                    jsonGenerator.a("event");
                    EventParser.m15501a(mutableFlatBuffer, g, jsonGenerator);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(EventSoftCancelMutationModel.class, new Serializer());
            }
        }

        public EventSoftCancelMutationModel() {
            super(2);
        }

        @Nullable
        private String m15365a() {
            this.f9756d = super.a(this.f9756d, 0);
            return this.f9756d;
        }

        @Nullable
        private EventModel m15366j() {
            this.f9757e = (EventModel) super.a(this.f9757e, 1, EventModel.class);
            return this.f9757e;
        }

        public final int jK_() {
            return -2124610353;
        }

        public final GraphQLVisitableModel m15368a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m15366j() != null) {
                EventModel eventModel = (EventModel) graphQLModelMutatingVisitor.b(m15366j());
                if (m15366j() != eventModel) {
                    graphQLVisitableModel = (EventSoftCancelMutationModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f9757e = eventModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m15367a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(m15365a());
            int a = ModelHelper.a(flatBufferBuilder, m15366j());
            flatBufferBuilder.c(2);
            flatBufferBuilder.b(0, b);
            flatBufferBuilder.b(1, a);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 1521588461)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: num_missing */
    public final class EventUnifiedInviteMutationModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private EventModel f9759d;

        /* compiled from: num_missing */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(EventUnifiedInviteMutationModel.class, new Deserializer());
            }

            public Object m15369a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = EventUnifiedInviteMutationParser.m15505a(jsonParser);
                Object eventUnifiedInviteMutationModel = new EventUnifiedInviteMutationModel();
                ((BaseModel) eventUnifiedInviteMutationModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (eventUnifiedInviteMutationModel instanceof Postprocessable) {
                    return ((Postprocessable) eventUnifiedInviteMutationModel).a();
                }
                return eventUnifiedInviteMutationModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 1801334754)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: num_missing */
        public final class EventModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
            @Nullable
            private String f9758d;

            /* compiled from: num_missing */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(EventModel.class, new Deserializer());
                }

                public Object m15370a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(EventUnifiedInviteMutationParser.EventParser.m15503a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object eventModel = new EventModel();
                    ((BaseModel) eventModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (eventModel instanceof Postprocessable) {
                        return ((Postprocessable) eventModel).a();
                    }
                    return eventModel;
                }
            }

            /* compiled from: num_missing */
            public class Serializer extends JsonSerializer<EventModel> {
                public final void m15371a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    EventModel eventModel = (EventModel) obj;
                    if (eventModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(eventModel.m15373a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        eventModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    EventUnifiedInviteMutationParser.EventParser.m15504a(eventModel.w_(), eventModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(EventModel.class, new Serializer());
                }
            }

            public EventModel() {
                super(1);
            }

            public final void m15376a(String str, ConsistencyTuple consistencyTuple) {
                consistencyTuple.a();
            }

            public final void m15377a(String str, Object obj, boolean z) {
            }

            @Nullable
            private String m15372j() {
                this.f9758d = super.a(this.f9758d, 0);
                return this.f9758d;
            }

            @Nullable
            public final String m15375a() {
                return m15372j();
            }

            public final int jK_() {
                return 67338874;
            }

            public final GraphQLVisitableModel m15374a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m15373a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m15372j());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, b);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: num_missing */
        public class Serializer extends JsonSerializer<EventUnifiedInviteMutationModel> {
            public final void m15378a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                EventUnifiedInviteMutationModel eventUnifiedInviteMutationModel = (EventUnifiedInviteMutationModel) obj;
                if (eventUnifiedInviteMutationModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(eventUnifiedInviteMutationModel.m15380a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    eventUnifiedInviteMutationModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = eventUnifiedInviteMutationModel.w_();
                int u_ = eventUnifiedInviteMutationModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("event");
                    EventUnifiedInviteMutationParser.EventParser.m15504a(mutableFlatBuffer, g, jsonGenerator);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(EventUnifiedInviteMutationModel.class, new Serializer());
            }
        }

        public EventUnifiedInviteMutationModel() {
            super(1);
        }

        @Nullable
        private EventModel m15379a() {
            this.f9759d = (EventModel) super.a(this.f9759d, 0, EventModel.class);
            return this.f9759d;
        }

        public final int jK_() {
            return -172369684;
        }

        public final GraphQLVisitableModel m15381a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m15379a() != null) {
                EventModel eventModel = (EventModel) graphQLModelMutatingVisitor.b(m15379a());
                if (m15379a() != eventModel) {
                    graphQLVisitableModel = (EventUnifiedInviteMutationModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f9759d = eventModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m15380a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m15379a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 1693965882)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: num_missing */
    public final class EventUserBlockMutationModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private UserModel f9761d;

        /* compiled from: num_missing */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(EventUserBlockMutationModel.class, new Deserializer());
            }

            public Object m15382a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = EventUserBlockMutationParser.m15508a(jsonParser);
                Object eventUserBlockMutationModel = new EventUserBlockMutationModel();
                ((BaseModel) eventUserBlockMutationModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (eventUserBlockMutationModel instanceof Postprocessable) {
                    return ((Postprocessable) eventUserBlockMutationModel).a();
                }
                return eventUserBlockMutationModel;
            }
        }

        /* compiled from: num_missing */
        public class Serializer extends JsonSerializer<EventUserBlockMutationModel> {
            public final void m15383a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                EventUserBlockMutationModel eventUserBlockMutationModel = (EventUserBlockMutationModel) obj;
                if (eventUserBlockMutationModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(eventUserBlockMutationModel.m15393a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    eventUserBlockMutationModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = eventUserBlockMutationModel.w_();
                int u_ = eventUserBlockMutationModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("user");
                    UserParser.m15507a(mutableFlatBuffer, g, jsonGenerator);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(EventUserBlockMutationModel.class, new Serializer());
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 1801334754)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: num_missing */
        public final class UserModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
            @Nullable
            private String f9760d;

            /* compiled from: num_missing */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(UserModel.class, new Deserializer());
                }

                public Object m15384a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(UserParser.m15506a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object userModel = new UserModel();
                    ((BaseModel) userModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (userModel instanceof Postprocessable) {
                        return ((Postprocessable) userModel).a();
                    }
                    return userModel;
                }
            }

            /* compiled from: num_missing */
            public class Serializer extends JsonSerializer<UserModel> {
                public final void m15385a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    UserModel userModel = (UserModel) obj;
                    if (userModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(userModel.m15387a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        userModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    UserParser.m15507a(userModel.w_(), userModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(UserModel.class, new Serializer());
                }
            }

            public UserModel() {
                super(1);
            }

            public final void m15390a(String str, ConsistencyTuple consistencyTuple) {
                consistencyTuple.a();
            }

            public final void m15391a(String str, Object obj, boolean z) {
            }

            @Nullable
            private String m15386j() {
                this.f9760d = super.a(this.f9760d, 0);
                return this.f9760d;
            }

            @Nullable
            public final String m15389a() {
                return m15386j();
            }

            public final int jK_() {
                return 2645995;
            }

            public final GraphQLVisitableModel m15388a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m15387a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m15386j());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, b);
                i();
                return flatBufferBuilder.d();
            }
        }

        public EventUserBlockMutationModel() {
            super(1);
        }

        @Nullable
        private UserModel m15392a() {
            this.f9761d = (UserModel) super.a(this.f9761d, 0, UserModel.class);
            return this.f9761d;
        }

        public final int jK_() {
            return 173053637;
        }

        public final GraphQLVisitableModel m15394a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m15392a() != null) {
                UserModel userModel = (UserModel) graphQLModelMutatingVisitor.b(m15392a());
                if (m15392a() != userModel) {
                    graphQLVisitableModel = (EventUserBlockMutationModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f9761d = userModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m15393a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m15392a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -1745378182)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: num_missing */
    public final class OptimisticRsvpEventModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
        @Nullable
        private EventInviteesModel f9778d;
        @Nullable
        private EventMaybesModel f9779e;
        @Nullable
        private EventMembersModel f9780f;
        @Nullable
        private EventWatchersModel f9781g;
        @Nullable
        private String f9782h;
        @Nullable
        private GraphQLEventGuestStatus f9783i;
        private boolean f9784j;
        @Nullable
        private GraphQLEventWatchStatus f9785k;

        /* compiled from: num_missing */
        public final class Builder {
            @Nullable
            public EventInviteesModel f9762a;
            @Nullable
            public EventMaybesModel f9763b;
            @Nullable
            public EventMembersModel f9764c;
            @Nullable
            public EventWatchersModel f9765d;
            @Nullable
            public String f9766e;
            @Nullable
            public GraphQLEventGuestStatus f9767f;
            public boolean f9768g;
            @Nullable
            public GraphQLEventWatchStatus f9769h;

            public final OptimisticRsvpEventModel m15395a() {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                int a = ModelHelper.a(flatBufferBuilder, this.f9762a);
                int a2 = ModelHelper.a(flatBufferBuilder, this.f9763b);
                int a3 = ModelHelper.a(flatBufferBuilder, this.f9764c);
                int a4 = ModelHelper.a(flatBufferBuilder, this.f9765d);
                int b = flatBufferBuilder.b(this.f9766e);
                int a5 = flatBufferBuilder.a(this.f9767f);
                int a6 = flatBufferBuilder.a(this.f9769h);
                flatBufferBuilder.c(8);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.b(1, a2);
                flatBufferBuilder.b(2, a3);
                flatBufferBuilder.b(3, a4);
                flatBufferBuilder.b(4, b);
                flatBufferBuilder.b(5, a5);
                flatBufferBuilder.a(6, this.f9768g);
                flatBufferBuilder.b(7, a6);
                flatBufferBuilder.d(flatBufferBuilder.d());
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                return new OptimisticRsvpEventModel(new MutableFlatBuffer(wrap, null, null, true, null));
            }
        }

        /* compiled from: num_missing */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(OptimisticRsvpEventModel.class, new Deserializer());
            }

            public Object m15396a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(OptimisticRsvpEventParser.m15517a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object optimisticRsvpEventModel = new OptimisticRsvpEventModel();
                ((BaseModel) optimisticRsvpEventModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (optimisticRsvpEventModel instanceof Postprocessable) {
                    return ((Postprocessable) optimisticRsvpEventModel).a();
                }
                return optimisticRsvpEventModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1723990064)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: num_missing */
        public final class EventInviteesModel extends BaseModel implements GraphQLVisitableModel {
            private int f9771d;

            /* compiled from: num_missing */
            public final class Builder {
                public int f9770a;

                public final EventInviteesModel m15397a() {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.a(0, this.f9770a, 0);
                    flatBufferBuilder.d(flatBufferBuilder.d());
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    return new EventInviteesModel(new MutableFlatBuffer(wrap, null, null, true, null));
                }
            }

            /* compiled from: num_missing */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(EventInviteesModel.class, new Deserializer());
                }

                public Object m15398a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(OptimisticRsvpEventParser.EventInviteesParser.m15509a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object eventInviteesModel = new EventInviteesModel();
                    ((BaseModel) eventInviteesModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (eventInviteesModel instanceof Postprocessable) {
                        return ((Postprocessable) eventInviteesModel).a();
                    }
                    return eventInviteesModel;
                }
            }

            /* compiled from: num_missing */
            public class Serializer extends JsonSerializer<EventInviteesModel> {
                public final void m15399a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    EventInviteesModel eventInviteesModel = (EventInviteesModel) obj;
                    if (eventInviteesModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(eventInviteesModel.m15401a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        eventInviteesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    OptimisticRsvpEventParser.EventInviteesParser.m15510a(eventInviteesModel.w_(), eventInviteesModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(EventInviteesModel.class, new Serializer());
                }
            }

            public EventInviteesModel() {
                super(1);
            }

            public EventInviteesModel(MutableFlatBuffer mutableFlatBuffer) {
                super(1);
                a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
            }

            public final int m15400a() {
                a(0, 0);
                return this.f9771d;
            }

            public final void m15403a(int i) {
                this.f9771d = i;
                if (this.b != null && this.b.d) {
                    this.b.b(this.c, 0, i);
                }
            }

            public final int jK_() {
                return -477813809;
            }

            public final GraphQLVisitableModel m15402a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m15401a(FlatBufferBuilder flatBufferBuilder) {
                h();
                flatBufferBuilder.c(1);
                flatBufferBuilder.a(0, this.f9771d, 0);
                i();
                return flatBufferBuilder.d();
            }

            public final void m15404a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                super.a(mutableFlatBuffer, i, obj);
                this.f9771d = mutableFlatBuffer.a(i, 0, 0);
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1723990064)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: num_missing */
        public final class EventMaybesModel extends BaseModel implements GraphQLVisitableModel {
            private int f9773d;

            /* compiled from: num_missing */
            public final class Builder {
                public int f9772a;

                public final EventMaybesModel m15405a() {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.a(0, this.f9772a, 0);
                    flatBufferBuilder.d(flatBufferBuilder.d());
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    return new EventMaybesModel(new MutableFlatBuffer(wrap, null, null, true, null));
                }
            }

            /* compiled from: num_missing */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(EventMaybesModel.class, new Deserializer());
                }

                public Object m15406a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(OptimisticRsvpEventParser.EventMaybesParser.m15511a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object eventMaybesModel = new EventMaybesModel();
                    ((BaseModel) eventMaybesModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (eventMaybesModel instanceof Postprocessable) {
                        return ((Postprocessable) eventMaybesModel).a();
                    }
                    return eventMaybesModel;
                }
            }

            /* compiled from: num_missing */
            public class Serializer extends JsonSerializer<EventMaybesModel> {
                public final void m15407a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    EventMaybesModel eventMaybesModel = (EventMaybesModel) obj;
                    if (eventMaybesModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(eventMaybesModel.m15409a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        eventMaybesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    OptimisticRsvpEventParser.EventMaybesParser.m15512a(eventMaybesModel.w_(), eventMaybesModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(EventMaybesModel.class, new Serializer());
                }
            }

            public EventMaybesModel() {
                super(1);
            }

            public EventMaybesModel(MutableFlatBuffer mutableFlatBuffer) {
                super(1);
                a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
            }

            public final int m15408a() {
                a(0, 0);
                return this.f9773d;
            }

            public final void m15411a(int i) {
                this.f9773d = i;
                if (this.b != null && this.b.d) {
                    this.b.b(this.c, 0, i);
                }
            }

            public final int jK_() {
                return 2065431779;
            }

            public final GraphQLVisitableModel m15410a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m15409a(FlatBufferBuilder flatBufferBuilder) {
                h();
                flatBufferBuilder.c(1);
                flatBufferBuilder.a(0, this.f9773d, 0);
                i();
                return flatBufferBuilder.d();
            }

            public final void m15412a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                super.a(mutableFlatBuffer, i, obj);
                this.f9773d = mutableFlatBuffer.a(i, 0, 0);
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1723990064)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: num_missing */
        public final class EventMembersModel extends BaseModel implements GraphQLVisitableModel {
            private int f9775d;

            /* compiled from: num_missing */
            public final class Builder {
                public int f9774a;

                public final EventMembersModel m15413a() {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.a(0, this.f9774a, 0);
                    flatBufferBuilder.d(flatBufferBuilder.d());
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    return new EventMembersModel(new MutableFlatBuffer(wrap, null, null, true, null));
                }
            }

            /* compiled from: num_missing */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(EventMembersModel.class, new Deserializer());
                }

                public Object m15414a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(OptimisticRsvpEventParser.EventMembersParser.m15513a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object eventMembersModel = new EventMembersModel();
                    ((BaseModel) eventMembersModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (eventMembersModel instanceof Postprocessable) {
                        return ((Postprocessable) eventMembersModel).a();
                    }
                    return eventMembersModel;
                }
            }

            /* compiled from: num_missing */
            public class Serializer extends JsonSerializer<EventMembersModel> {
                public final void m15415a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    EventMembersModel eventMembersModel = (EventMembersModel) obj;
                    if (eventMembersModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(eventMembersModel.m15417a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        eventMembersModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    OptimisticRsvpEventParser.EventMembersParser.m15514a(eventMembersModel.w_(), eventMembersModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(EventMembersModel.class, new Serializer());
                }
            }

            public EventMembersModel() {
                super(1);
            }

            public EventMembersModel(MutableFlatBuffer mutableFlatBuffer) {
                super(1);
                a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
            }

            public final int m15416a() {
                a(0, 0);
                return this.f9775d;
            }

            public final void m15419a(int i) {
                this.f9775d = i;
                if (this.b != null && this.b.d) {
                    this.b.b(this.c, 0, i);
                }
            }

            public final int jK_() {
                return -1848764035;
            }

            public final GraphQLVisitableModel m15418a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m15417a(FlatBufferBuilder flatBufferBuilder) {
                h();
                flatBufferBuilder.c(1);
                flatBufferBuilder.a(0, this.f9775d, 0);
                i();
                return flatBufferBuilder.d();
            }

            public final void m15420a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                super.a(mutableFlatBuffer, i, obj);
                this.f9775d = mutableFlatBuffer.a(i, 0, 0);
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1723990064)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: num_missing */
        public final class EventWatchersModel extends BaseModel implements GraphQLVisitableModel {
            private int f9777d;

            /* compiled from: num_missing */
            public final class Builder {
                public int f9776a;

                public final EventWatchersModel m15421a() {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.a(0, this.f9776a, 0);
                    flatBufferBuilder.d(flatBufferBuilder.d());
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    return new EventWatchersModel(new MutableFlatBuffer(wrap, null, null, true, null));
                }
            }

            /* compiled from: num_missing */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(EventWatchersModel.class, new Deserializer());
                }

                public Object m15422a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(EventWatchersParser.m15515a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object eventWatchersModel = new EventWatchersModel();
                    ((BaseModel) eventWatchersModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (eventWatchersModel instanceof Postprocessable) {
                        return ((Postprocessable) eventWatchersModel).a();
                    }
                    return eventWatchersModel;
                }
            }

            /* compiled from: num_missing */
            public class Serializer extends JsonSerializer<EventWatchersModel> {
                public final void m15423a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    EventWatchersModel eventWatchersModel = (EventWatchersModel) obj;
                    if (eventWatchersModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(eventWatchersModel.m15425a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        eventWatchersModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    EventWatchersParser.m15516a(eventWatchersModel.w_(), eventWatchersModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(EventWatchersModel.class, new Serializer());
                }
            }

            public EventWatchersModel() {
                super(1);
            }

            public EventWatchersModel(MutableFlatBuffer mutableFlatBuffer) {
                super(1);
                a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
            }

            public final int m15424a() {
                a(0, 0);
                return this.f9777d;
            }

            public final void m15427a(int i) {
                this.f9777d = i;
                if (this.b != null && this.b.d) {
                    this.b.b(this.c, 0, i);
                }
            }

            public final int jK_() {
                return 2050421903;
            }

            public final GraphQLVisitableModel m15426a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m15425a(FlatBufferBuilder flatBufferBuilder) {
                h();
                flatBufferBuilder.c(1);
                flatBufferBuilder.a(0, this.f9777d, 0);
                i();
                return flatBufferBuilder.d();
            }

            public final void m15428a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                super.a(mutableFlatBuffer, i, obj);
                this.f9777d = mutableFlatBuffer.a(i, 0, 0);
            }
        }

        /* compiled from: num_missing */
        public class Serializer extends JsonSerializer<OptimisticRsvpEventModel> {
            public final void m15429a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                OptimisticRsvpEventModel optimisticRsvpEventModel = (OptimisticRsvpEventModel) obj;
                if (optimisticRsvpEventModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(optimisticRsvpEventModel.m15439a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    optimisticRsvpEventModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                OptimisticRsvpEventParser.m15518a(optimisticRsvpEventModel.w_(), optimisticRsvpEventModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(OptimisticRsvpEventModel.class, new Serializer());
            }
        }

        public OptimisticRsvpEventModel() {
            super(8);
        }

        public OptimisticRsvpEventModel(MutableFlatBuffer mutableFlatBuffer) {
            super(8);
            a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
        }

        public final void m15443a(String str, ConsistencyTuple consistencyTuple) {
            if ("event_invitees.count".equals(str)) {
                EventInviteesModel l = m15433l();
                if (l != null) {
                    consistencyTuple.a = Integer.valueOf(l.m15400a());
                    consistencyTuple.b = l.u_();
                    consistencyTuple.c = 0;
                    return;
                }
            } else if ("event_maybes.count".equals(str)) {
                EventMaybesModel m = m15434m();
                if (m != null) {
                    consistencyTuple.a = Integer.valueOf(m.m15408a());
                    consistencyTuple.b = m.u_();
                    consistencyTuple.c = 0;
                    return;
                }
            } else if ("event_members.count".equals(str)) {
                EventMembersModel n = m15435n();
                if (n != null) {
                    consistencyTuple.a = Integer.valueOf(n.m15416a());
                    consistencyTuple.b = n.u_();
                    consistencyTuple.c = 0;
                    return;
                }
            } else if ("event_watchers.count".equals(str)) {
                EventWatchersModel o = m15436o();
                if (o != null) {
                    consistencyTuple.a = Integer.valueOf(o.m15424a());
                    consistencyTuple.b = o.u_();
                    consistencyTuple.c = 0;
                    return;
                }
            } else if ("viewer_guest_status".equals(str)) {
                consistencyTuple.a = m15446k();
                consistencyTuple.b = u_();
                consistencyTuple.c = 5;
                return;
            } else if ("viewer_has_pending_invite".equals(str)) {
                consistencyTuple.a = Boolean.valueOf(m15437p());
                consistencyTuple.b = u_();
                consistencyTuple.c = 6;
                return;
            } else if ("viewer_watch_status".equals(str)) {
                consistencyTuple.a = m15438q();
                consistencyTuple.b = u_();
                consistencyTuple.c = 7;
                return;
            }
            consistencyTuple.a();
        }

        public final void m15444a(String str, Object obj, boolean z) {
            if ("event_invitees.count".equals(str)) {
                EventInviteesModel l = m15433l();
                if (l == null) {
                    return;
                }
                if (z) {
                    l = (EventInviteesModel) l.clone();
                    l.m15403a(((Integer) obj).intValue());
                    this.f9778d = l;
                    return;
                }
                l.m15403a(((Integer) obj).intValue());
            } else if ("event_maybes.count".equals(str)) {
                EventMaybesModel m = m15434m();
                if (m == null) {
                    return;
                }
                if (z) {
                    m = (EventMaybesModel) m.clone();
                    m.m15411a(((Integer) obj).intValue());
                    this.f9779e = m;
                    return;
                }
                m.m15411a(((Integer) obj).intValue());
            } else if ("event_members.count".equals(str)) {
                EventMembersModel n = m15435n();
                if (n == null) {
                    return;
                }
                if (z) {
                    n = (EventMembersModel) n.clone();
                    n.m15419a(((Integer) obj).intValue());
                    this.f9780f = n;
                    return;
                }
                n.m15419a(((Integer) obj).intValue());
            } else if ("event_watchers.count".equals(str)) {
                EventWatchersModel o = m15436o();
                if (o == null) {
                    return;
                }
                if (z) {
                    o = (EventWatchersModel) o.clone();
                    o.m15427a(((Integer) obj).intValue());
                    this.f9781g = o;
                    return;
                }
                o.m15427a(((Integer) obj).intValue());
            } else if ("viewer_guest_status".equals(str)) {
                m15430a((GraphQLEventGuestStatus) obj);
            } else if ("viewer_has_pending_invite".equals(str)) {
                m15432a(((Boolean) obj).booleanValue());
            } else if ("viewer_watch_status".equals(str)) {
                m15431a((GraphQLEventWatchStatus) obj);
            }
        }

        @Nullable
        private EventInviteesModel m15433l() {
            this.f9778d = (EventInviteesModel) super.a(this.f9778d, 0, EventInviteesModel.class);
            return this.f9778d;
        }

        @Nullable
        private EventMaybesModel m15434m() {
            this.f9779e = (EventMaybesModel) super.a(this.f9779e, 1, EventMaybesModel.class);
            return this.f9779e;
        }

        @Nullable
        private EventMembersModel m15435n() {
            this.f9780f = (EventMembersModel) super.a(this.f9780f, 2, EventMembersModel.class);
            return this.f9780f;
        }

        @Nullable
        private EventWatchersModel m15436o() {
            this.f9781g = (EventWatchersModel) super.a(this.f9781g, 3, EventWatchersModel.class);
            return this.f9781g;
        }

        @Nullable
        public final String m15445j() {
            this.f9782h = super.a(this.f9782h, 4);
            return this.f9782h;
        }

        @Nullable
        public final GraphQLEventGuestStatus m15446k() {
            this.f9783i = (GraphQLEventGuestStatus) super.b(this.f9783i, 5, GraphQLEventGuestStatus.class, GraphQLEventGuestStatus.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
            return this.f9783i;
        }

        private void m15430a(GraphQLEventGuestStatus graphQLEventGuestStatus) {
            this.f9783i = graphQLEventGuestStatus;
            if (this.b != null && this.b.d) {
                this.b.a(this.c, 5, graphQLEventGuestStatus != null ? graphQLEventGuestStatus.name() : null);
            }
        }

        private boolean m15437p() {
            a(0, 6);
            return this.f9784j;
        }

        private void m15432a(boolean z) {
            this.f9784j = z;
            if (this.b != null && this.b.d) {
                this.b.a(this.c, 6, z);
            }
        }

        @Nullable
        private GraphQLEventWatchStatus m15438q() {
            this.f9785k = (GraphQLEventWatchStatus) super.b(this.f9785k, 7, GraphQLEventWatchStatus.class, GraphQLEventWatchStatus.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
            return this.f9785k;
        }

        private void m15431a(GraphQLEventWatchStatus graphQLEventWatchStatus) {
            this.f9785k = graphQLEventWatchStatus;
            if (this.b != null && this.b.d) {
                this.b.a(this.c, 7, graphQLEventWatchStatus != null ? graphQLEventWatchStatus.name() : null);
            }
        }

        @Nullable
        public final String m15441a() {
            return m15445j();
        }

        public final int jK_() {
            return 67338874;
        }

        public final GraphQLVisitableModel m15440a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m15433l() != null) {
                EventInviteesModel eventInviteesModel = (EventInviteesModel) graphQLModelMutatingVisitor.b(m15433l());
                if (m15433l() != eventInviteesModel) {
                    graphQLVisitableModel = (OptimisticRsvpEventModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f9778d = eventInviteesModel;
                }
            }
            if (m15434m() != null) {
                EventMaybesModel eventMaybesModel = (EventMaybesModel) graphQLModelMutatingVisitor.b(m15434m());
                if (m15434m() != eventMaybesModel) {
                    graphQLVisitableModel = (OptimisticRsvpEventModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f9779e = eventMaybesModel;
                }
            }
            if (m15435n() != null) {
                EventMembersModel eventMembersModel = (EventMembersModel) graphQLModelMutatingVisitor.b(m15435n());
                if (m15435n() != eventMembersModel) {
                    graphQLVisitableModel = (OptimisticRsvpEventModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f9780f = eventMembersModel;
                }
            }
            if (m15436o() != null) {
                EventWatchersModel eventWatchersModel = (EventWatchersModel) graphQLModelMutatingVisitor.b(m15436o());
                if (m15436o() != eventWatchersModel) {
                    graphQLVisitableModel = (OptimisticRsvpEventModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f9781g = eventWatchersModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m15439a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m15433l());
            int a2 = ModelHelper.a(flatBufferBuilder, m15434m());
            int a3 = ModelHelper.a(flatBufferBuilder, m15435n());
            int a4 = ModelHelper.a(flatBufferBuilder, m15436o());
            int b = flatBufferBuilder.b(m15445j());
            int a5 = flatBufferBuilder.a(m15446k());
            int a6 = flatBufferBuilder.a(m15438q());
            flatBufferBuilder.c(8);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, a2);
            flatBufferBuilder.b(2, a3);
            flatBufferBuilder.b(3, a4);
            flatBufferBuilder.b(4, b);
            flatBufferBuilder.b(5, a5);
            flatBufferBuilder.a(6, this.f9784j);
            flatBufferBuilder.b(7, a6);
            i();
            return flatBufferBuilder.d();
        }

        public final void m15442a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
            super.a(mutableFlatBuffer, i, obj);
            this.f9784j = mutableFlatBuffer.a(i, 6);
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -2642782)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: num_missing */
    public final class RemoveEventCoreMutationModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private String f9786d;

        /* compiled from: num_missing */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(RemoveEventCoreMutationModel.class, new Deserializer());
            }

            public Object m15447a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = RemoveEventCoreMutationParser.m15519a(jsonParser);
                Object removeEventCoreMutationModel = new RemoveEventCoreMutationModel();
                ((BaseModel) removeEventCoreMutationModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (removeEventCoreMutationModel instanceof Postprocessable) {
                    return ((Postprocessable) removeEventCoreMutationModel).a();
                }
                return removeEventCoreMutationModel;
            }
        }

        /* compiled from: num_missing */
        public class Serializer extends JsonSerializer<RemoveEventCoreMutationModel> {
            public final void m15448a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                RemoveEventCoreMutationModel removeEventCoreMutationModel = (RemoveEventCoreMutationModel) obj;
                if (removeEventCoreMutationModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(removeEventCoreMutationModel.m15450a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    removeEventCoreMutationModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = removeEventCoreMutationModel.w_();
                int u_ = removeEventCoreMutationModel.u_();
                jsonGenerator.f();
                if (mutableFlatBuffer.g(u_, 0) != 0) {
                    jsonGenerator.a("client_mutation_id");
                    jsonGenerator.b(mutableFlatBuffer.c(u_, 0));
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(RemoveEventCoreMutationModel.class, new Serializer());
            }
        }

        public RemoveEventCoreMutationModel() {
            super(1);
        }

        @Nullable
        private String m15449a() {
            this.f9786d = super.a(this.f9786d, 0);
            return this.f9786d;
        }

        public final int jK_() {
            return -824676721;
        }

        public final GraphQLVisitableModel m15451a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            h();
            i();
            return this;
        }

        public final int m15450a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(m15449a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, b);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -2642782)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: num_missing */
    public final class RemoveSubscribedEventMutationModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private String f9787d;

        /* compiled from: num_missing */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(RemoveSubscribedEventMutationModel.class, new Deserializer());
            }

            public Object m15452a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = RemoveSubscribedEventMutationParser.m15520a(jsonParser);
                Object removeSubscribedEventMutationModel = new RemoveSubscribedEventMutationModel();
                ((BaseModel) removeSubscribedEventMutationModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (removeSubscribedEventMutationModel instanceof Postprocessable) {
                    return ((Postprocessable) removeSubscribedEventMutationModel).a();
                }
                return removeSubscribedEventMutationModel;
            }
        }

        /* compiled from: num_missing */
        public class Serializer extends JsonSerializer<RemoveSubscribedEventMutationModel> {
            public final void m15453a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                RemoveSubscribedEventMutationModel removeSubscribedEventMutationModel = (RemoveSubscribedEventMutationModel) obj;
                if (removeSubscribedEventMutationModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(removeSubscribedEventMutationModel.m15455a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    removeSubscribedEventMutationModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = removeSubscribedEventMutationModel.w_();
                int u_ = removeSubscribedEventMutationModel.u_();
                jsonGenerator.f();
                if (mutableFlatBuffer.g(u_, 0) != 0) {
                    jsonGenerator.a("client_mutation_id");
                    jsonGenerator.b(mutableFlatBuffer.c(u_, 0));
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(RemoveSubscribedEventMutationModel.class, new Serializer());
            }
        }

        public RemoveSubscribedEventMutationModel() {
            super(1);
        }

        @Nullable
        private String m15454a() {
            this.f9787d = super.a(this.f9787d, 0);
            return this.f9787d;
        }

        public final int jK_() {
            return 694117915;
        }

        public final GraphQLVisitableModel m15456a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            h();
            i();
            return this;
        }

        public final int m15455a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(m15454a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, b);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -2642782)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: num_missing */
    public final class RemoveSuggestedEventMutationModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private String f9788d;

        /* compiled from: num_missing */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(RemoveSuggestedEventMutationModel.class, new Deserializer());
            }

            public Object m15457a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = RemoveSuggestedEventMutationParser.m15521a(jsonParser);
                Object removeSuggestedEventMutationModel = new RemoveSuggestedEventMutationModel();
                ((BaseModel) removeSuggestedEventMutationModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (removeSuggestedEventMutationModel instanceof Postprocessable) {
                    return ((Postprocessable) removeSuggestedEventMutationModel).a();
                }
                return removeSuggestedEventMutationModel;
            }
        }

        /* compiled from: num_missing */
        public class Serializer extends JsonSerializer<RemoveSuggestedEventMutationModel> {
            public final void m15458a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                RemoveSuggestedEventMutationModel removeSuggestedEventMutationModel = (RemoveSuggestedEventMutationModel) obj;
                if (removeSuggestedEventMutationModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(removeSuggestedEventMutationModel.m15460a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    removeSuggestedEventMutationModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = removeSuggestedEventMutationModel.w_();
                int u_ = removeSuggestedEventMutationModel.u_();
                jsonGenerator.f();
                if (mutableFlatBuffer.g(u_, 0) != 0) {
                    jsonGenerator.a("client_mutation_id");
                    jsonGenerator.b(mutableFlatBuffer.c(u_, 0));
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(RemoveSuggestedEventMutationModel.class, new Serializer());
            }
        }

        public RemoveSuggestedEventMutationModel() {
            super(1);
        }

        @Nullable
        private String m15459a() {
            this.f9788d = super.a(this.f9788d, 0);
            return this.f9788d;
        }

        public final int jK_() {
            return 2039076861;
        }

        public final GraphQLVisitableModel m15461a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            h();
            i();
            return this;
        }

        public final int m15460a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(m15459a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, b);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 891822883)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: num_missing */
    public final class WatchEventMutationModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private String f9789d;
        @Nullable
        private OptimisticRsvpEventModel f9790e;

        /* compiled from: num_missing */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(WatchEventMutationModel.class, new Deserializer());
            }

            public Object m15462a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = WatchEventMutationParser.m15522a(jsonParser);
                Object watchEventMutationModel = new WatchEventMutationModel();
                ((BaseModel) watchEventMutationModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (watchEventMutationModel instanceof Postprocessable) {
                    return ((Postprocessable) watchEventMutationModel).a();
                }
                return watchEventMutationModel;
            }
        }

        /* compiled from: num_missing */
        public class Serializer extends JsonSerializer<WatchEventMutationModel> {
            public final void m15463a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                WatchEventMutationModel watchEventMutationModel = (WatchEventMutationModel) obj;
                if (watchEventMutationModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(watchEventMutationModel.m15465a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    watchEventMutationModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = watchEventMutationModel.w_();
                int u_ = watchEventMutationModel.u_();
                jsonGenerator.f();
                if (mutableFlatBuffer.g(u_, 0) != 0) {
                    jsonGenerator.a("client_mutation_id");
                    jsonGenerator.b(mutableFlatBuffer.c(u_, 0));
                }
                int g = mutableFlatBuffer.g(u_, 1);
                if (g != 0) {
                    jsonGenerator.a("event");
                    OptimisticRsvpEventParser.m15518a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(WatchEventMutationModel.class, new Serializer());
            }
        }

        public WatchEventMutationModel() {
            super(2);
        }

        @Nullable
        private String m15464j() {
            this.f9789d = super.a(this.f9789d, 0);
            return this.f9789d;
        }

        @Nullable
        public final OptimisticRsvpEventModel m15466a() {
            this.f9790e = (OptimisticRsvpEventModel) super.a(this.f9790e, 1, OptimisticRsvpEventModel.class);
            return this.f9790e;
        }

        public final int jK_() {
            return 168637498;
        }

        public final GraphQLVisitableModel m15467a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m15466a() != null) {
                OptimisticRsvpEventModel optimisticRsvpEventModel = (OptimisticRsvpEventModel) graphQLModelMutatingVisitor.b(m15466a());
                if (m15466a() != optimisticRsvpEventModel) {
                    graphQLVisitableModel = (WatchEventMutationModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f9790e = optimisticRsvpEventModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m15465a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(m15464j());
            int a = ModelHelper.a(flatBufferBuilder, m15466a());
            flatBufferBuilder.c(2);
            flatBufferBuilder.b(0, b);
            flatBufferBuilder.b(1, a);
            i();
            return flatBufferBuilder.d();
        }
    }
}
