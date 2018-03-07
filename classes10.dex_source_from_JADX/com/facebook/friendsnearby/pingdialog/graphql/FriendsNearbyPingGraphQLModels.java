package com.facebook.friendsnearby.pingdialog.graphql;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbSerializerProvider;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.FragmentModelWithoutBridge;
import com.facebook.flatbuffers.ModelWithFlatBufferFormatHash;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.friendsnearby.pingdialog.graphql.FriendsNearbyPingGraphQLParsers.FriendsNearbyLocationPingFromUserParser;
import com.facebook.friendsnearby.pingdialog.graphql.FriendsNearbyPingGraphQLParsers.FriendsNearbyLocationPingFromUserParser.LocationSharingParser;
import com.facebook.friendsnearby.pingdialog.graphql.FriendsNearbyPingGraphQLParsers.FriendsNearbyLocationPingFromUserParser.LocationSharingParser.LocationPingFromUserParser;
import com.facebook.friendsnearby.pingdialog.graphql.FriendsNearbyPingGraphQLParsers.FriendsNearbyLocationPingToUserParser;
import com.facebook.friendsnearby.pingdialog.graphql.FriendsNearbyPingGraphQLParsers.FriendsNearbyLocationPingToUserParser.LocationSharingParser.LocationPingToUserParser;
import com.facebook.friendsnearby.pingdialog.graphql.FriendsNearbyPingGraphQLParsers.IncomingLocationPingParser;
import com.facebook.friendsnearby.pingdialog.graphql.FriendsNearbyPingGraphQLParsers.IncomingLocationPingParser.AccuracyParser;
import com.facebook.friendsnearby.pingdialog.graphql.FriendsNearbyPingGraphQLParsers.OutgoingLocationPingParser;
import com.facebook.graphql.enums.GraphQLLocationPingType;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.querybuilder.common.CommonGraphQLModels.DefaultLocationFieldsModel;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
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

/* compiled from: [[ticketing_information]] */
public class FriendsNearbyPingGraphQLModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 1987035070)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: [[ticketing_information]] */
    public final class FriendsNearbyLocationPingFromUserModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private LocationSharingModel f20629d;

        /* compiled from: [[ticketing_information]] */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(FriendsNearbyLocationPingFromUserModel.class, new Deserializer());
            }

            public Object m21044a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = FriendsNearbyLocationPingFromUserParser.m21100a(jsonParser);
                Object friendsNearbyLocationPingFromUserModel = new FriendsNearbyLocationPingFromUserModel();
                ((BaseModel) friendsNearbyLocationPingFromUserModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (friendsNearbyLocationPingFromUserModel instanceof Postprocessable) {
                    return ((Postprocessable) friendsNearbyLocationPingFromUserModel).a();
                }
                return friendsNearbyLocationPingFromUserModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1682956048)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: [[ticketing_information]] */
        public final class LocationSharingModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private LocationPingFromUserModel f20628d;

            /* compiled from: [[ticketing_information]] */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(LocationSharingModel.class, new Deserializer());
                }

                public Object m21045a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(LocationSharingParser.m21098a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object locationSharingModel = new LocationSharingModel();
                    ((BaseModel) locationSharingModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (locationSharingModel instanceof Postprocessable) {
                        return ((Postprocessable) locationSharingModel).a();
                    }
                    return locationSharingModel;
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = 1065870681)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: [[ticketing_information]] */
            public final class LocationPingFromUserModel extends BaseModel implements GraphQLVisitableModel {
                @Nullable
                private List<IncomingLocationPingModel> f20627d;

                /* compiled from: [[ticketing_information]] */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(LocationPingFromUserModel.class, new Deserializer());
                    }

                    public Object m21046a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(LocationPingFromUserParser.m21096a(jsonParser, flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                        Object locationPingFromUserModel = new LocationPingFromUserModel();
                        ((BaseModel) locationPingFromUserModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                        if (locationPingFromUserModel instanceof Postprocessable) {
                            return ((Postprocessable) locationPingFromUserModel).a();
                        }
                        return locationPingFromUserModel;
                    }
                }

                /* compiled from: [[ticketing_information]] */
                public class Serializer extends JsonSerializer<LocationPingFromUserModel> {
                    public final void m21047a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        LocationPingFromUserModel locationPingFromUserModel = (LocationPingFromUserModel) obj;
                        if (locationPingFromUserModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(locationPingFromUserModel.m21049a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            locationPingFromUserModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        LocationPingFromUserParser.m21097a(locationPingFromUserModel.w_(), locationPingFromUserModel.u_(), jsonGenerator, serializerProvider);
                    }

                    static {
                        FbSerializerProvider.a(LocationPingFromUserModel.class, new Serializer());
                    }
                }

                public LocationPingFromUserModel() {
                    super(1);
                }

                @Nonnull
                private ImmutableList<IncomingLocationPingModel> m21048a() {
                    this.f20627d = super.a(this.f20627d, 0, IncomingLocationPingModel.class);
                    return (ImmutableList) this.f20627d;
                }

                public final int jK_() {
                    return -771027445;
                }

                public final GraphQLVisitableModel m21050a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    GraphQLVisitableModel graphQLVisitableModel = null;
                    h();
                    if (m21048a() != null) {
                        Builder a = ModelHelper.a(m21048a(), graphQLModelMutatingVisitor);
                        if (a != null) {
                            graphQLVisitableModel = (LocationPingFromUserModel) ModelHelper.a(null, this);
                            graphQLVisitableModel.f20627d = a.b();
                        }
                    }
                    i();
                    return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                }

                public final int m21049a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int a = ModelHelper.a(flatBufferBuilder, m21048a());
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.b(0, a);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            /* compiled from: [[ticketing_information]] */
            public class Serializer extends JsonSerializer<LocationSharingModel> {
                public final void m21051a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    LocationSharingModel locationSharingModel = (LocationSharingModel) obj;
                    if (locationSharingModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(locationSharingModel.m21053a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        locationSharingModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    LocationSharingParser.m21099a(locationSharingModel.w_(), locationSharingModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(LocationSharingModel.class, new Serializer());
                }
            }

            public LocationSharingModel() {
                super(1);
            }

            @Nullable
            private LocationPingFromUserModel m21052a() {
                this.f20628d = (LocationPingFromUserModel) super.a(this.f20628d, 0, LocationPingFromUserModel.class);
                return this.f20628d;
            }

            public final int jK_() {
                return 924875591;
            }

            public final GraphQLVisitableModel m21054a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m21052a() != null) {
                    LocationPingFromUserModel locationPingFromUserModel = (LocationPingFromUserModel) graphQLModelMutatingVisitor.b(m21052a());
                    if (m21052a() != locationPingFromUserModel) {
                        graphQLVisitableModel = (LocationSharingModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f20628d = locationPingFromUserModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m21053a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m21052a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, a);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: [[ticketing_information]] */
        public class Serializer extends JsonSerializer<FriendsNearbyLocationPingFromUserModel> {
            public final void m21055a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                FriendsNearbyLocationPingFromUserModel friendsNearbyLocationPingFromUserModel = (FriendsNearbyLocationPingFromUserModel) obj;
                if (friendsNearbyLocationPingFromUserModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(friendsNearbyLocationPingFromUserModel.m21057a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    friendsNearbyLocationPingFromUserModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = friendsNearbyLocationPingFromUserModel.w_();
                int u_ = friendsNearbyLocationPingFromUserModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("location_sharing");
                    LocationSharingParser.m21099a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(FriendsNearbyLocationPingFromUserModel.class, new Serializer());
            }
        }

        public FriendsNearbyLocationPingFromUserModel() {
            super(1);
        }

        @Nullable
        private LocationSharingModel m21056a() {
            this.f20629d = (LocationSharingModel) super.a(this.f20629d, 0, LocationSharingModel.class);
            return this.f20629d;
        }

        public final int jK_() {
            return -1732764110;
        }

        public final GraphQLVisitableModel m21058a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m21056a() != null) {
                LocationSharingModel locationSharingModel = (LocationSharingModel) graphQLModelMutatingVisitor.b(m21056a());
                if (m21056a() != locationSharingModel) {
                    graphQLVisitableModel = (FriendsNearbyLocationPingFromUserModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f20629d = locationSharingModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m21057a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m21056a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 151920999)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: [[ticketing_information]] */
    public final class FriendsNearbyLocationPingToUserModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private LocationSharingModel f20632d;

        /* compiled from: [[ticketing_information]] */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(FriendsNearbyLocationPingToUserModel.class, new Deserializer());
            }

            public Object m21059a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = FriendsNearbyLocationPingToUserParser.m21105a(jsonParser);
                Object friendsNearbyLocationPingToUserModel = new FriendsNearbyLocationPingToUserModel();
                ((BaseModel) friendsNearbyLocationPingToUserModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (friendsNearbyLocationPingToUserModel instanceof Postprocessable) {
                    return ((Postprocessable) friendsNearbyLocationPingToUserModel).a();
                }
                return friendsNearbyLocationPingToUserModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 2119545353)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: [[ticketing_information]] */
        public final class LocationSharingModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private LocationPingToUserModel f20631d;

            /* compiled from: [[ticketing_information]] */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(LocationSharingModel.class, new Deserializer());
                }

                public Object m21060a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(FriendsNearbyLocationPingToUserParser.LocationSharingParser.m21103a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object locationSharingModel = new LocationSharingModel();
                    ((BaseModel) locationSharingModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (locationSharingModel instanceof Postprocessable) {
                        return ((Postprocessable) locationSharingModel).a();
                    }
                    return locationSharingModel;
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = 699850688)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: [[ticketing_information]] */
            public final class LocationPingToUserModel extends BaseModel implements GraphQLVisitableModel {
                @Nullable
                private List<OutgoingLocationPingModel> f20630d;

                /* compiled from: [[ticketing_information]] */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(LocationPingToUserModel.class, new Deserializer());
                    }

                    public Object m21061a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(LocationPingToUserParser.m21101a(jsonParser, flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                        Object locationPingToUserModel = new LocationPingToUserModel();
                        ((BaseModel) locationPingToUserModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                        if (locationPingToUserModel instanceof Postprocessable) {
                            return ((Postprocessable) locationPingToUserModel).a();
                        }
                        return locationPingToUserModel;
                    }
                }

                /* compiled from: [[ticketing_information]] */
                public class Serializer extends JsonSerializer<LocationPingToUserModel> {
                    public final void m21062a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        LocationPingToUserModel locationPingToUserModel = (LocationPingToUserModel) obj;
                        if (locationPingToUserModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(locationPingToUserModel.m21063a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            locationPingToUserModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        LocationPingToUserParser.m21102a(locationPingToUserModel.w_(), locationPingToUserModel.u_(), jsonGenerator, serializerProvider);
                    }

                    static {
                        FbSerializerProvider.a(LocationPingToUserModel.class, new Serializer());
                    }
                }

                public LocationPingToUserModel() {
                    super(1);
                }

                @Nonnull
                public final ImmutableList<OutgoingLocationPingModel> m21065a() {
                    this.f20630d = super.a(this.f20630d, 0, OutgoingLocationPingModel.class);
                    return (ImmutableList) this.f20630d;
                }

                public final int jK_() {
                    return -771027445;
                }

                public final GraphQLVisitableModel m21064a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    GraphQLVisitableModel graphQLVisitableModel = null;
                    h();
                    if (m21065a() != null) {
                        Builder a = ModelHelper.a(m21065a(), graphQLModelMutatingVisitor);
                        if (a != null) {
                            graphQLVisitableModel = (LocationPingToUserModel) ModelHelper.a(null, this);
                            graphQLVisitableModel.f20630d = a.b();
                        }
                    }
                    i();
                    return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                }

                public final int m21063a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int a = ModelHelper.a(flatBufferBuilder, m21065a());
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.b(0, a);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            /* compiled from: [[ticketing_information]] */
            public class Serializer extends JsonSerializer<LocationSharingModel> {
                public final void m21066a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    LocationSharingModel locationSharingModel = (LocationSharingModel) obj;
                    if (locationSharingModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(locationSharingModel.m21067a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        locationSharingModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    FriendsNearbyLocationPingToUserParser.LocationSharingParser.m21104a(locationSharingModel.w_(), locationSharingModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(LocationSharingModel.class, new Serializer());
                }
            }

            public LocationSharingModel() {
                super(1);
            }

            @Nullable
            public final LocationPingToUserModel m21068a() {
                this.f20631d = (LocationPingToUserModel) super.a(this.f20631d, 0, LocationPingToUserModel.class);
                return this.f20631d;
            }

            public final int jK_() {
                return 924875591;
            }

            public final GraphQLVisitableModel m21069a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m21068a() != null) {
                    LocationPingToUserModel locationPingToUserModel = (LocationPingToUserModel) graphQLModelMutatingVisitor.b(m21068a());
                    if (m21068a() != locationPingToUserModel) {
                        graphQLVisitableModel = (LocationSharingModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f20631d = locationPingToUserModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m21067a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m21068a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, a);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: [[ticketing_information]] */
        public class Serializer extends JsonSerializer<FriendsNearbyLocationPingToUserModel> {
            public final void m21070a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                FriendsNearbyLocationPingToUserModel friendsNearbyLocationPingToUserModel = (FriendsNearbyLocationPingToUserModel) obj;
                if (friendsNearbyLocationPingToUserModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(friendsNearbyLocationPingToUserModel.m21071a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    friendsNearbyLocationPingToUserModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = friendsNearbyLocationPingToUserModel.w_();
                int u_ = friendsNearbyLocationPingToUserModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("location_sharing");
                    FriendsNearbyLocationPingToUserParser.LocationSharingParser.m21104a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(FriendsNearbyLocationPingToUserModel.class, new Serializer());
            }
        }

        public FriendsNearbyLocationPingToUserModel() {
            super(1);
        }

        @Nullable
        public final LocationSharingModel m21072a() {
            this.f20632d = (LocationSharingModel) super.a(this.f20632d, 0, LocationSharingModel.class);
            return this.f20632d;
        }

        public final int jK_() {
            return -1732764110;
        }

        public final GraphQLVisitableModel m21073a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m21072a() != null) {
                LocationSharingModel locationSharingModel = (LocationSharingModel) graphQLModelMutatingVisitor.b(m21072a());
                if (m21072a() != locationSharingModel) {
                    graphQLVisitableModel = (FriendsNearbyLocationPingToUserModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f20632d = locationSharingModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m21071a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m21072a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 1853902498)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: [[ticketing_information]] */
    public final class IncomingLocationPingModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private AccuracyModel f20635d;
        @Nullable
        private DefaultLocationFieldsModel f20636e;
        private long f20637f;
        @Nullable
        private String f20638g;

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -2011369352)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: [[ticketing_information]] */
        public final class AccuracyModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private String f20633d;
            private double f20634e;

            /* compiled from: [[ticketing_information]] */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(AccuracyModel.class, new Deserializer());
                }

                public Object m21074a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(AccuracyParser.m21106a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object accuracyModel = new AccuracyModel();
                    ((BaseModel) accuracyModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (accuracyModel instanceof Postprocessable) {
                        return ((Postprocessable) accuracyModel).a();
                    }
                    return accuracyModel;
                }
            }

            /* compiled from: [[ticketing_information]] */
            public class Serializer extends JsonSerializer<AccuracyModel> {
                public final void m21075a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    AccuracyModel accuracyModel = (AccuracyModel) obj;
                    if (accuracyModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(accuracyModel.m21077a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        accuracyModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    AccuracyParser.m21107a(accuracyModel.w_(), accuracyModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(AccuracyModel.class, new Serializer());
                }
            }

            public AccuracyModel() {
                super(2);
            }

            @Nullable
            private String m21076a() {
                this.f20633d = super.a(this.f20633d, 0);
                return this.f20633d;
            }

            public final int jK_() {
                return -1220360021;
            }

            public final GraphQLVisitableModel m21078a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m21077a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m21076a());
                flatBufferBuilder.c(2);
                flatBufferBuilder.b(0, b);
                flatBufferBuilder.a(1, this.f20634e, 0.0d);
                i();
                return flatBufferBuilder.d();
            }

            public final void m21079a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                super.a(mutableFlatBuffer, i, obj);
                this.f20634e = mutableFlatBuffer.a(i, 1, 0.0d);
            }
        }

        /* compiled from: [[ticketing_information]] */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(IncomingLocationPingModel.class, new Deserializer());
            }

            public Object m21080a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(IncomingLocationPingParser.m21108b(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object incomingLocationPingModel = new IncomingLocationPingModel();
                ((BaseModel) incomingLocationPingModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (incomingLocationPingModel instanceof Postprocessable) {
                    return ((Postprocessable) incomingLocationPingModel).a();
                }
                return incomingLocationPingModel;
            }
        }

        /* compiled from: [[ticketing_information]] */
        public class Serializer extends JsonSerializer<IncomingLocationPingModel> {
            public final void m21081a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                IncomingLocationPingModel incomingLocationPingModel = (IncomingLocationPingModel) obj;
                if (incomingLocationPingModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(incomingLocationPingModel.m21085a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    incomingLocationPingModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                IncomingLocationPingParser.m21109b(incomingLocationPingModel.w_(), incomingLocationPingModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(IncomingLocationPingModel.class, new Serializer());
            }
        }

        public IncomingLocationPingModel() {
            super(4);
        }

        @Nullable
        private AccuracyModel m21082a() {
            this.f20635d = (AccuracyModel) super.a(this.f20635d, 0, AccuracyModel.class);
            return this.f20635d;
        }

        @Nullable
        private DefaultLocationFieldsModel m21083j() {
            this.f20636e = (DefaultLocationFieldsModel) super.a(this.f20636e, 1, DefaultLocationFieldsModel.class);
            return this.f20636e;
        }

        @Nullable
        private String m21084k() {
            this.f20638g = super.a(this.f20638g, 3);
            return this.f20638g;
        }

        public final int jK_() {
            return 105907943;
        }

        public final GraphQLVisitableModel m21086a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m21082a() != null) {
                AccuracyModel accuracyModel = (AccuracyModel) graphQLModelMutatingVisitor.b(m21082a());
                if (m21082a() != accuracyModel) {
                    graphQLVisitableModel = (IncomingLocationPingModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f20635d = accuracyModel;
                }
            }
            if (m21083j() != null) {
                DefaultLocationFieldsModel defaultLocationFieldsModel = (DefaultLocationFieldsModel) graphQLModelMutatingVisitor.b(m21083j());
                if (m21083j() != defaultLocationFieldsModel) {
                    graphQLVisitableModel = (IncomingLocationPingModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f20636e = defaultLocationFieldsModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m21085a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m21082a());
            int a2 = ModelHelper.a(flatBufferBuilder, m21083j());
            int b = flatBufferBuilder.b(m21084k());
            flatBufferBuilder.c(4);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, a2);
            flatBufferBuilder.a(2, this.f20637f, 0);
            flatBufferBuilder.b(3, b);
            i();
            return flatBufferBuilder.d();
        }

        public final void m21087a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
            super.a(mutableFlatBuffer, i, obj);
            this.f20637f = mutableFlatBuffer.a(i, 2, 0);
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -1318805030)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: [[ticketing_information]] */
    public final class OutgoingLocationPingModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private String f20639d;
        @Nullable
        private GraphQLLocationPingType f20640e;
        private int f20641f;

        /* compiled from: [[ticketing_information]] */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(OutgoingLocationPingModel.class, new Deserializer());
            }

            public Object m21088a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(OutgoingLocationPingParser.m21111b(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object outgoingLocationPingModel = new OutgoingLocationPingModel();
                ((BaseModel) outgoingLocationPingModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (outgoingLocationPingModel instanceof Postprocessable) {
                    return ((Postprocessable) outgoingLocationPingModel).a();
                }
                return outgoingLocationPingModel;
            }
        }

        /* compiled from: [[ticketing_information]] */
        public class Serializer extends JsonSerializer<OutgoingLocationPingModel> {
            public final void m21089a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                OutgoingLocationPingModel outgoingLocationPingModel = (OutgoingLocationPingModel) obj;
                if (outgoingLocationPingModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(outgoingLocationPingModel.m21090a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    outgoingLocationPingModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                OutgoingLocationPingParser.m21110a(outgoingLocationPingModel.w_(), outgoingLocationPingModel.u_(), jsonGenerator);
            }

            static {
                FbSerializerProvider.a(OutgoingLocationPingModel.class, new Serializer());
            }
        }

        public OutgoingLocationPingModel() {
            super(3);
        }

        @Nullable
        public final String m21095j() {
            this.f20639d = super.a(this.f20639d, 0);
            return this.f20639d;
        }

        @Nullable
        public final GraphQLLocationPingType m21091a() {
            this.f20640e = (GraphQLLocationPingType) super.b(this.f20640e, 1, GraphQLLocationPingType.class, GraphQLLocationPingType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
            return this.f20640e;
        }

        public final int m21094b() {
            a(0, 2);
            return this.f20641f;
        }

        public final int jK_() {
            return 105907943;
        }

        public final GraphQLVisitableModel m21092a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            h();
            i();
            return this;
        }

        public final int m21090a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(m21095j());
            int a = flatBufferBuilder.a(m21091a());
            flatBufferBuilder.c(3);
            flatBufferBuilder.b(0, b);
            flatBufferBuilder.b(1, a);
            flatBufferBuilder.a(2, this.f20641f, 0);
            i();
            return flatBufferBuilder.d();
        }

        public final void m21093a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
            super.a(mutableFlatBuffer, i, obj);
            this.f20641f = mutableFlatBuffer.a(i, 2, 0);
        }
    }
}
