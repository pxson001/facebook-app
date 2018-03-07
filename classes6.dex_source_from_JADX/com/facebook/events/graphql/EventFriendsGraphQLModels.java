package com.facebook.events.graphql;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbSerializerProvider;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.events.graphql.EventFriendsGraphQLInterfaces.EventPreview;
import com.facebook.events.graphql.EventFriendsGraphQLParsers.BasicEventGuestParser;
import com.facebook.events.graphql.EventFriendsGraphQLParsers.EventFriendsQueryParser;
import com.facebook.events.graphql.EventFriendsGraphQLParsers.EventFriendsQueryParser.FriendsGoingParser;
import com.facebook.events.graphql.EventFriendsGraphQLParsers.EventFriendsQueryParser.FriendsInterestedParser;
import com.facebook.events.graphql.EventFriendsGraphQLParsers.EventFriendsQueryParser.FriendsInvitedParser;
import com.facebook.events.graphql.EventFriendsGraphQLParsers.EventPreviewParser;
import com.facebook.events.graphql.EventFriendsGraphQLParsers.EventPreviewParser.EventPlaceParser;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.FragmentModelWithoutBridge;
import com.facebook.flatbuffers.ModelWithFlatBufferFormatHash;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.enums.GraphQLObjectType;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.querybuilder.common.CommonGraphQLInterfaces.DefaultImageFields;
import com.facebook.graphql.querybuilder.common.CommonGraphQLModels.DefaultImageFieldsModel;
import com.facebook.graphql.querybuilder.common.CommonGraphQLParsers.DefaultImageFieldsParser;
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

/* compiled from: number_of_stops_label */
public class EventFriendsGraphQLModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 289552164)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: number_of_stops_label */
    public final class BasicEventGuestModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
        @Nullable
        private GraphQLObjectType f8901d;
        @Nullable
        private String f8902e;
        @Nullable
        private String f8903f;
        @Nullable
        private DefaultImageFieldsModel f8904g;

        /* compiled from: number_of_stops_label */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(BasicEventGuestModel.class, new Deserializer());
            }

            public Object m12705a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(BasicEventGuestParser.m12774b(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object basicEventGuestModel = new BasicEventGuestModel();
                ((BaseModel) basicEventGuestModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (basicEventGuestModel instanceof Postprocessable) {
                    return ((Postprocessable) basicEventGuestModel).a();
                }
                return basicEventGuestModel;
            }
        }

        /* compiled from: number_of_stops_label */
        public class Serializer extends JsonSerializer<BasicEventGuestModel> {
            public final void m12706a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                BasicEventGuestModel basicEventGuestModel = (BasicEventGuestModel) obj;
                if (basicEventGuestModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(basicEventGuestModel.m12709a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    basicEventGuestModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                BasicEventGuestParser.m12775b(basicEventGuestModel.w_(), basicEventGuestModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(BasicEventGuestModel.class, new Serializer());
            }
        }

        @Nullable
        public final /* synthetic */ DefaultImageFields m12716d() {
            return m12708k();
        }

        public BasicEventGuestModel() {
            super(4);
        }

        public final void m12712a(String str, ConsistencyTuple consistencyTuple) {
            consistencyTuple.a();
        }

        public final void m12713a(String str, Object obj, boolean z) {
        }

        @Nullable
        private GraphQLObjectType m12707j() {
            if (this.b != null && this.f8901d == null) {
                this.f8901d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
            }
            return this.f8901d;
        }

        @Nullable
        public final String m12714b() {
            this.f8902e = super.a(this.f8902e, 1);
            return this.f8902e;
        }

        @Nullable
        public final String m12715c() {
            this.f8903f = super.a(this.f8903f, 2);
            return this.f8903f;
        }

        @Nullable
        private DefaultImageFieldsModel m12708k() {
            this.f8904g = (DefaultImageFieldsModel) super.a(this.f8904g, 3, DefaultImageFieldsModel.class);
            return this.f8904g;
        }

        @Nullable
        public final String m12711a() {
            return m12714b();
        }

        public final int jK_() {
            return 63093205;
        }

        public final GraphQLVisitableModel m12710a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m12708k() != null) {
                DefaultImageFieldsModel defaultImageFieldsModel = (DefaultImageFieldsModel) graphQLModelMutatingVisitor.b(m12708k());
                if (m12708k() != defaultImageFieldsModel) {
                    graphQLVisitableModel = (BasicEventGuestModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f8904g = defaultImageFieldsModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m12709a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m12707j());
            int b = flatBufferBuilder.b(m12714b());
            int b2 = flatBufferBuilder.b(m12715c());
            int a2 = ModelHelper.a(flatBufferBuilder, m12708k());
            flatBufferBuilder.c(4);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, b);
            flatBufferBuilder.b(2, b2);
            flatBufferBuilder.b(3, a2);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -2065447604)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: number_of_stops_label */
    public final class EventFriendsQueryModel extends BaseModel implements EventPreview, GraphQLPersistableNode, GraphQLVisitableConsistentModel {
        @Nullable
        private DefaultImageFieldsModel f8908d;
        @Nullable
        private EventPlaceModel f8909e;
        @Nullable
        private FriendsGoingModel f8910f;
        @Nullable
        private FriendsInterestedModel f8911g;
        @Nullable
        private FriendsInvitedModel f8912h;
        @Nullable
        private String f8913i;
        @Nullable
        private String f8914j;
        @Nullable
        private String f8915k;

        /* compiled from: number_of_stops_label */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(EventFriendsQueryModel.class, new Deserializer());
            }

            public Object m12717a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = EventFriendsQueryParser.m12782a(jsonParser);
                Object eventFriendsQueryModel = new EventFriendsQueryModel();
                ((BaseModel) eventFriendsQueryModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (eventFriendsQueryModel instanceof Postprocessable) {
                    return ((Postprocessable) eventFriendsQueryModel).a();
                }
                return eventFriendsQueryModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1161840512)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: number_of_stops_label */
        public final class FriendsGoingModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private List<BasicEventGuestModel> f8905d;

            /* compiled from: number_of_stops_label */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(FriendsGoingModel.class, new Deserializer());
                }

                public Object m12718a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(FriendsGoingParser.m12776a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object friendsGoingModel = new FriendsGoingModel();
                    ((BaseModel) friendsGoingModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (friendsGoingModel instanceof Postprocessable) {
                        return ((Postprocessable) friendsGoingModel).a();
                    }
                    return friendsGoingModel;
                }
            }

            /* compiled from: number_of_stops_label */
            public class Serializer extends JsonSerializer<FriendsGoingModel> {
                public final void m12719a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    FriendsGoingModel friendsGoingModel = (FriendsGoingModel) obj;
                    if (friendsGoingModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(friendsGoingModel.m12720a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        friendsGoingModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    FriendsGoingParser.m12777a(friendsGoingModel.w_(), friendsGoingModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(FriendsGoingModel.class, new Serializer());
                }
            }

            public FriendsGoingModel() {
                super(1);
            }

            @Nonnull
            public final ImmutableList<BasicEventGuestModel> m12722a() {
                this.f8905d = super.a(this.f8905d, 0, BasicEventGuestModel.class);
                return (ImmutableList) this.f8905d;
            }

            public final int jK_() {
                return -1848764035;
            }

            public final GraphQLVisitableModel m12721a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m12722a() != null) {
                    Builder a = ModelHelper.a(m12722a(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        graphQLVisitableModel = (FriendsGoingModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f8905d = a.b();
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m12720a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m12722a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, a);
                i();
                return flatBufferBuilder.d();
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1161840512)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: number_of_stops_label */
        public final class FriendsInterestedModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private List<BasicEventGuestModel> f8906d;

            /* compiled from: number_of_stops_label */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(FriendsInterestedModel.class, new Deserializer());
                }

                public Object m12723a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(FriendsInterestedParser.m12778a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object friendsInterestedModel = new FriendsInterestedModel();
                    ((BaseModel) friendsInterestedModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (friendsInterestedModel instanceof Postprocessable) {
                        return ((Postprocessable) friendsInterestedModel).a();
                    }
                    return friendsInterestedModel;
                }
            }

            /* compiled from: number_of_stops_label */
            public class Serializer extends JsonSerializer<FriendsInterestedModel> {
                public final void m12724a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    FriendsInterestedModel friendsInterestedModel = (FriendsInterestedModel) obj;
                    if (friendsInterestedModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(friendsInterestedModel.m12725a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        friendsInterestedModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    FriendsInterestedParser.m12779a(friendsInterestedModel.w_(), friendsInterestedModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(FriendsInterestedModel.class, new Serializer());
                }
            }

            public FriendsInterestedModel() {
                super(1);
            }

            @Nonnull
            public final ImmutableList<BasicEventGuestModel> m12727a() {
                this.f8906d = super.a(this.f8906d, 0, BasicEventGuestModel.class);
                return (ImmutableList) this.f8906d;
            }

            public final int jK_() {
                return 2050421903;
            }

            public final GraphQLVisitableModel m12726a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m12727a() != null) {
                    Builder a = ModelHelper.a(m12727a(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        graphQLVisitableModel = (FriendsInterestedModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f8906d = a.b();
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m12725a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m12727a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, a);
                i();
                return flatBufferBuilder.d();
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1161840512)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: number_of_stops_label */
        public final class FriendsInvitedModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private List<BasicEventGuestModel> f8907d;

            /* compiled from: number_of_stops_label */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(FriendsInvitedModel.class, new Deserializer());
                }

                public Object m12728a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(FriendsInvitedParser.m12780a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object friendsInvitedModel = new FriendsInvitedModel();
                    ((BaseModel) friendsInvitedModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (friendsInvitedModel instanceof Postprocessable) {
                        return ((Postprocessable) friendsInvitedModel).a();
                    }
                    return friendsInvitedModel;
                }
            }

            /* compiled from: number_of_stops_label */
            public class Serializer extends JsonSerializer<FriendsInvitedModel> {
                public final void m12729a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    FriendsInvitedModel friendsInvitedModel = (FriendsInvitedModel) obj;
                    if (friendsInvitedModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(friendsInvitedModel.m12730a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        friendsInvitedModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    FriendsInvitedParser.m12781a(friendsInvitedModel.w_(), friendsInvitedModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(FriendsInvitedModel.class, new Serializer());
                }
            }

            public FriendsInvitedModel() {
                super(1);
            }

            @Nonnull
            public final ImmutableList<BasicEventGuestModel> m12732a() {
                this.f8907d = super.a(this.f8907d, 0, BasicEventGuestModel.class);
                return (ImmutableList) this.f8907d;
            }

            public final int jK_() {
                return -477813809;
            }

            public final GraphQLVisitableModel m12731a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m12732a() != null) {
                    Builder a = ModelHelper.a(m12732a(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        graphQLVisitableModel = (FriendsInvitedModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f8907d = a.b();
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m12730a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m12732a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, a);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: number_of_stops_label */
        public class Serializer extends JsonSerializer<EventFriendsQueryModel> {
            public final void m12733a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                EventFriendsQueryModel eventFriendsQueryModel = (EventFriendsQueryModel) obj;
                if (eventFriendsQueryModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(eventFriendsQueryModel.m12737a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    eventFriendsQueryModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = eventFriendsQueryModel.w_();
                int u_ = eventFriendsQueryModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("eventProfilePicture");
                    DefaultImageFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
                }
                g = mutableFlatBuffer.g(u_, 1);
                if (g != 0) {
                    jsonGenerator.a("event_place");
                    EventPlaceParser.m12784a(mutableFlatBuffer, g, jsonGenerator);
                }
                g = mutableFlatBuffer.g(u_, 2);
                if (g != 0) {
                    jsonGenerator.a("friends_going");
                    FriendsGoingParser.m12777a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                g = mutableFlatBuffer.g(u_, 3);
                if (g != 0) {
                    jsonGenerator.a("friends_interested");
                    FriendsInterestedParser.m12779a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                g = mutableFlatBuffer.g(u_, 4);
                if (g != 0) {
                    jsonGenerator.a("friends_invited");
                    FriendsInvitedParser.m12781a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                if (mutableFlatBuffer.g(u_, 5) != 0) {
                    jsonGenerator.a("id");
                    jsonGenerator.b(mutableFlatBuffer.c(u_, 5));
                }
                if (mutableFlatBuffer.g(u_, 6) != 0) {
                    jsonGenerator.a("live_permalink_time_range_sentence");
                    jsonGenerator.b(mutableFlatBuffer.c(u_, 6));
                }
                if (mutableFlatBuffer.g(u_, 7) != 0) {
                    jsonGenerator.a("name");
                    jsonGenerator.b(mutableFlatBuffer.c(u_, 7));
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(EventFriendsQueryModel.class, new Serializer());
            }
        }

        @Nullable
        public final /* synthetic */ DefaultImageFields mo963b() {
            return m12735m();
        }

        @Nullable
        public final /* synthetic */ EventPlaceModel mo964c() {
            return m12736n();
        }

        public EventFriendsQueryModel() {
            super(8);
        }

        public final void m12740a(String str, ConsistencyTuple consistencyTuple) {
            if ("name".equals(str)) {
                consistencyTuple.a = mo967g();
                consistencyTuple.b = u_();
                consistencyTuple.c = 7;
                return;
            }
            consistencyTuple.a();
        }

        public final void m12741a(String str, Object obj, boolean z) {
            if ("name".equals(str)) {
                m12734a((String) obj);
            }
        }

        @Nullable
        private DefaultImageFieldsModel m12735m() {
            this.f8908d = (DefaultImageFieldsModel) super.a(this.f8908d, 0, DefaultImageFieldsModel.class);
            return this.f8908d;
        }

        @Nullable
        private EventPlaceModel m12736n() {
            this.f8909e = (EventPlaceModel) super.a(this.f8909e, 1, EventPlaceModel.class);
            return this.f8909e;
        }

        @Nullable
        public final FriendsGoingModel m12746j() {
            this.f8910f = (FriendsGoingModel) super.a(this.f8910f, 2, FriendsGoingModel.class);
            return this.f8910f;
        }

        @Nullable
        public final FriendsInterestedModel m12747k() {
            this.f8911g = (FriendsInterestedModel) super.a(this.f8911g, 3, FriendsInterestedModel.class);
            return this.f8911g;
        }

        @Nullable
        public final FriendsInvitedModel m12748l() {
            this.f8912h = (FriendsInvitedModel) super.a(this.f8912h, 4, FriendsInvitedModel.class);
            return this.f8912h;
        }

        @Nullable
        public final String mo965d() {
            this.f8913i = super.a(this.f8913i, 5);
            return this.f8913i;
        }

        @Nullable
        public final String dJ_() {
            this.f8914j = super.a(this.f8914j, 6);
            return this.f8914j;
        }

        @Nullable
        public final String mo967g() {
            this.f8915k = super.a(this.f8915k, 7);
            return this.f8915k;
        }

        private void m12734a(@Nullable String str) {
            this.f8915k = str;
            if (this.b != null && this.b.d) {
                this.b.a(this.c, 7, str);
            }
        }

        @Nullable
        public final String m12739a() {
            return mo965d();
        }

        public final int jK_() {
            return 67338874;
        }

        public final GraphQLVisitableModel m12738a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m12735m() != null) {
                DefaultImageFieldsModel defaultImageFieldsModel = (DefaultImageFieldsModel) graphQLModelMutatingVisitor.b(m12735m());
                if (m12735m() != defaultImageFieldsModel) {
                    graphQLVisitableModel = (EventFriendsQueryModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f8908d = defaultImageFieldsModel;
                }
            }
            if (m12736n() != null) {
                EventPlaceModel eventPlaceModel = (EventPlaceModel) graphQLModelMutatingVisitor.b(m12736n());
                if (m12736n() != eventPlaceModel) {
                    graphQLVisitableModel = (EventFriendsQueryModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f8909e = eventPlaceModel;
                }
            }
            if (m12746j() != null) {
                FriendsGoingModel friendsGoingModel = (FriendsGoingModel) graphQLModelMutatingVisitor.b(m12746j());
                if (m12746j() != friendsGoingModel) {
                    graphQLVisitableModel = (EventFriendsQueryModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f8910f = friendsGoingModel;
                }
            }
            if (m12747k() != null) {
                FriendsInterestedModel friendsInterestedModel = (FriendsInterestedModel) graphQLModelMutatingVisitor.b(m12747k());
                if (m12747k() != friendsInterestedModel) {
                    graphQLVisitableModel = (EventFriendsQueryModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f8911g = friendsInterestedModel;
                }
            }
            if (m12748l() != null) {
                FriendsInvitedModel friendsInvitedModel = (FriendsInvitedModel) graphQLModelMutatingVisitor.b(m12748l());
                if (m12748l() != friendsInvitedModel) {
                    graphQLVisitableModel = (EventFriendsQueryModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f8912h = friendsInvitedModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m12737a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m12735m());
            int a2 = ModelHelper.a(flatBufferBuilder, m12736n());
            int a3 = ModelHelper.a(flatBufferBuilder, m12746j());
            int a4 = ModelHelper.a(flatBufferBuilder, m12747k());
            int a5 = ModelHelper.a(flatBufferBuilder, m12748l());
            int b = flatBufferBuilder.b(mo965d());
            int b2 = flatBufferBuilder.b(dJ_());
            int b3 = flatBufferBuilder.b(mo967g());
            flatBufferBuilder.c(8);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, a2);
            flatBufferBuilder.b(2, a3);
            flatBufferBuilder.b(3, a4);
            flatBufferBuilder.b(4, a5);
            flatBufferBuilder.b(5, b);
            flatBufferBuilder.b(6, b2);
            flatBufferBuilder.b(7, b3);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 336271594)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: number_of_stops_label */
    public final class EventPreviewModel extends BaseModel implements EventPreview, GraphQLPersistableNode, GraphQLVisitableConsistentModel {
        @Nullable
        private DefaultImageFieldsModel f8918d;
        @Nullable
        private EventPlaceModel f8919e;
        @Nullable
        private String f8920f;
        @Nullable
        private String f8921g;
        @Nullable
        private String f8922h;

        /* compiled from: number_of_stops_label */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(EventPreviewModel.class, new Deserializer());
            }

            public Object m12749a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = EventPreviewParser.m12785a(jsonParser);
                Object eventPreviewModel = new EventPreviewModel();
                ((BaseModel) eventPreviewModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (eventPreviewModel instanceof Postprocessable) {
                    return ((Postprocessable) eventPreviewModel).a();
                }
                return eventPreviewModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -341630258)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: number_of_stops_label */
        public final class EventPlaceModel extends BaseModel implements GraphQLVisitableConsistentModel {
            @Nullable
            private GraphQLObjectType f8916d;
            @Nullable
            private String f8917e;

            /* compiled from: number_of_stops_label */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(EventPlaceModel.class, new Deserializer());
                }

                public Object m12750a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(EventPlaceParser.m12783a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object eventPlaceModel = new EventPlaceModel();
                    ((BaseModel) eventPlaceModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (eventPlaceModel instanceof Postprocessable) {
                        return ((Postprocessable) eventPlaceModel).a();
                    }
                    return eventPlaceModel;
                }
            }

            /* compiled from: number_of_stops_label */
            public class Serializer extends JsonSerializer<EventPlaceModel> {
                public final void m12751a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    EventPlaceModel eventPlaceModel = (EventPlaceModel) obj;
                    if (eventPlaceModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(eventPlaceModel.m12754a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        eventPlaceModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    EventPlaceParser.m12784a(eventPlaceModel.w_(), eventPlaceModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(EventPlaceModel.class, new Serializer());
                }
            }

            public EventPlaceModel() {
                super(2);
            }

            public final void m12757a(String str, ConsistencyTuple consistencyTuple) {
                if ("name".equals(str)) {
                    consistencyTuple.a = m12756a();
                    consistencyTuple.b = u_();
                    consistencyTuple.c = 1;
                    return;
                }
                consistencyTuple.a();
            }

            public final void m12758a(String str, Object obj, boolean z) {
                if ("name".equals(str)) {
                    m12752a((String) obj);
                }
            }

            @Nullable
            private GraphQLObjectType m12753j() {
                if (this.b != null && this.f8916d == null) {
                    this.f8916d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
                }
                return this.f8916d;
            }

            @Nullable
            public final String m12756a() {
                this.f8917e = super.a(this.f8917e, 1);
                return this.f8917e;
            }

            private void m12752a(@Nullable String str) {
                this.f8917e = str;
                if (this.b != null && this.b.d) {
                    this.b.a(this.c, 1, str);
                }
            }

            public final int jK_() {
                return 77195495;
            }

            public final GraphQLVisitableModel m12755a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m12754a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m12753j());
                int b = flatBufferBuilder.b(m12756a());
                flatBufferBuilder.c(2);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.b(1, b);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: number_of_stops_label */
        public class Serializer extends JsonSerializer<EventPreviewModel> {
            public final void m12759a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                EventPreviewModel eventPreviewModel = (EventPreviewModel) obj;
                if (eventPreviewModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(eventPreviewModel.m12763a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    eventPreviewModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = eventPreviewModel.w_();
                int u_ = eventPreviewModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("eventProfilePicture");
                    DefaultImageFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
                }
                g = mutableFlatBuffer.g(u_, 1);
                if (g != 0) {
                    jsonGenerator.a("event_place");
                    EventPlaceParser.m12784a(mutableFlatBuffer, g, jsonGenerator);
                }
                if (mutableFlatBuffer.g(u_, 2) != 0) {
                    jsonGenerator.a("id");
                    jsonGenerator.b(mutableFlatBuffer.c(u_, 2));
                }
                if (mutableFlatBuffer.g(u_, 3) != 0) {
                    jsonGenerator.a("live_permalink_time_range_sentence");
                    jsonGenerator.b(mutableFlatBuffer.c(u_, 3));
                }
                if (mutableFlatBuffer.g(u_, 4) != 0) {
                    jsonGenerator.a("name");
                    jsonGenerator.b(mutableFlatBuffer.c(u_, 4));
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(EventPreviewModel.class, new Serializer());
            }
        }

        @Nullable
        public final /* synthetic */ DefaultImageFields mo963b() {
            return m12761j();
        }

        @Nullable
        public final /* synthetic */ EventPlaceModel mo964c() {
            return m12762k();
        }

        public EventPreviewModel() {
            super(5);
        }

        public final void m12766a(String str, ConsistencyTuple consistencyTuple) {
            if ("name".equals(str)) {
                consistencyTuple.a = mo967g();
                consistencyTuple.b = u_();
                consistencyTuple.c = 4;
                return;
            }
            consistencyTuple.a();
        }

        public final void m12767a(String str, Object obj, boolean z) {
            if ("name".equals(str)) {
                m12760a((String) obj);
            }
        }

        @Nullable
        private DefaultImageFieldsModel m12761j() {
            this.f8918d = (DefaultImageFieldsModel) super.a(this.f8918d, 0, DefaultImageFieldsModel.class);
            return this.f8918d;
        }

        @Nullable
        private EventPlaceModel m12762k() {
            this.f8919e = (EventPlaceModel) super.a(this.f8919e, 1, EventPlaceModel.class);
            return this.f8919e;
        }

        @Nullable
        public final String mo965d() {
            this.f8920f = super.a(this.f8920f, 2);
            return this.f8920f;
        }

        @Nullable
        public final String dJ_() {
            this.f8921g = super.a(this.f8921g, 3);
            return this.f8921g;
        }

        @Nullable
        public final String mo967g() {
            this.f8922h = super.a(this.f8922h, 4);
            return this.f8922h;
        }

        private void m12760a(@Nullable String str) {
            this.f8922h = str;
            if (this.b != null && this.b.d) {
                this.b.a(this.c, 4, str);
            }
        }

        @Nullable
        public final String m12765a() {
            return mo965d();
        }

        public final int jK_() {
            return 67338874;
        }

        public final GraphQLVisitableModel m12764a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m12761j() != null) {
                DefaultImageFieldsModel defaultImageFieldsModel = (DefaultImageFieldsModel) graphQLModelMutatingVisitor.b(m12761j());
                if (m12761j() != defaultImageFieldsModel) {
                    graphQLVisitableModel = (EventPreviewModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f8918d = defaultImageFieldsModel;
                }
            }
            if (m12762k() != null) {
                EventPlaceModel eventPlaceModel = (EventPlaceModel) graphQLModelMutatingVisitor.b(m12762k());
                if (m12762k() != eventPlaceModel) {
                    graphQLVisitableModel = (EventPreviewModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f8919e = eventPlaceModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m12763a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m12761j());
            int a2 = ModelHelper.a(flatBufferBuilder, m12762k());
            int b = flatBufferBuilder.b(mo965d());
            int b2 = flatBufferBuilder.b(dJ_());
            int b3 = flatBufferBuilder.b(mo967g());
            flatBufferBuilder.c(5);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, a2);
            flatBufferBuilder.b(2, b);
            flatBufferBuilder.b(3, b2);
            flatBufferBuilder.b(4, b3);
            i();
            return flatBufferBuilder.d();
        }
    }
}
