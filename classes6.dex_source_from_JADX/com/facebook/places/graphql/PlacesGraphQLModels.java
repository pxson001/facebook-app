package com.facebook.places.graphql;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbSerializerProvider;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.FragmentModelWithBridge;
import com.facebook.flatbuffers.FragmentModelWithoutBridge;
import com.facebook.flatbuffers.ModelWithFlatBufferFormatHash;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.deserializers.GraphQLPrivacyOptionDeserializer;
import com.facebook.graphql.enums.GraphQLCheckinPromptType;
import com.facebook.graphql.enums.GraphQLObjectType;
import com.facebook.graphql.enums.GraphQLPlaceType;
import com.facebook.graphql.model.GraphQLPrivacyOption;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.modelutil.SerializerHelpers;
import com.facebook.graphql.visitor.ConsistencyTuple;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLPersistableNode;
import com.facebook.graphql.visitor.GraphQLVisitableConsistentModel;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.facebook.places.graphql.PlacesGraphQLParsers.CheckinCityParser;
import com.facebook.places.graphql.PlacesGraphQLParsers.CheckinCityParser.LocationParser;
import com.facebook.places.graphql.PlacesGraphQLParsers.CheckinHistoryMostRecentQueryParser;
import com.facebook.places.graphql.PlacesGraphQLParsers.CheckinHistoryMostRecentQueryParser.PlaceVisitsParser;
import com.facebook.places.graphql.PlacesGraphQLParsers.CheckinHistoryMostRecentQueryParser.PlaceVisitsParser.NodesParser;
import com.facebook.places.graphql.PlacesGraphQLParsers.CheckinPlaceParser;
import com.facebook.places.graphql.PlacesGraphQLParsers.CheckinPlaceParser.AddressParser;
import com.facebook.places.graphql.PlacesGraphQLParsers.CheckinPlaceParser.CategoryIconParser;
import com.facebook.places.graphql.PlacesGraphQLParsers.CheckinPlaceParser.FlowableTaggableActivityParser;
import com.facebook.places.graphql.PlacesGraphQLParsers.CheckinPlaceParser.FlowableTaggableActivityParser.FlowIconParser;
import com.facebook.places.graphql.PlacesGraphQLParsers.CheckinPlaceParser.FlowableTaggableActivityParser.TaggableActivityParser;
import com.facebook.places.graphql.PlacesGraphQLParsers.CheckinPlaceParser.PageVisitsParser;
import com.facebook.places.graphql.PlacesGraphQLParsers.CheckinSearchQueryParser;
import com.facebook.places.graphql.PlacesGraphQLParsers.CheckinSearchQueryParser.ClosestCityParser;
import com.facebook.places.graphql.PlacesGraphQLParsers.CheckinSearchQueryParser.PlaceResultsParser;
import com.facebook.places.graphql.PlacesGraphQLParsers.CheckinSearchQueryParser.PlaceResultsParser.EdgesParser;
import com.facebook.places.graphql.PlacesGraphQLParsers.FBCheckinNearbyCityQueryParser;
import com.facebook.places.graphql.PlacesGraphQLParsers.FBCitySearchQueryParser;
import com.facebook.places.graphql.PlacesGraphQLParsers.HomeResidenceQueryParser;
import com.facebook.places.graphql.PlacesGraphQLParsers.HomeResidenceQueryParser.CityParser;
import com.facebook.places.graphql.PlacesGraphQLParsers.HomeResidenceQueryParser.ProfilePictureParser;
import com.facebook.places.graphql.PlacesGraphQLParsers.PlaceDetailsParser;
import com.facebook.places.graphql.PlacesGraphQLParsers.PlaceDetailsParser.AllPhonesParser;
import com.facebook.places.graphql.PlacesGraphQLParsers.PlaceDetailsParser.AllPhonesParser.PhoneNumberParser;
import com.facebook.places.graphql.PlacesGraphQLParsers.PlaceDetailsParser.FriendsWhoVisitedParser;
import com.facebook.places.graphql.PlacesGraphQLParsers.UserProfileCitiesQueryParser;
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

/* compiled from: subscribe ignored as client has been closed */
public class PlacesGraphQLModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 712678897)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: subscribe ignored as client has been closed */
    public final class CheckinCityModel extends BaseModel implements GraphQLVisitableConsistentModel {
        @Nullable
        private GraphQLObjectType f3878d;
        @Nullable
        private LocationModel f3879e;
        @Nullable
        private String f3880f;

        /* compiled from: subscribe ignored as client has been closed */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(CheckinCityModel.class, new Deserializer());
            }

            public Object m5513a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(CheckinCityParser.m5824a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object checkinCityModel = new CheckinCityModel();
                ((BaseModel) checkinCityModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (checkinCityModel instanceof Postprocessable) {
                    return ((Postprocessable) checkinCityModel).a();
                }
                return checkinCityModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 918622653)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: subscribe ignored as client has been closed */
        public final class LocationModel extends BaseModel implements GraphQLVisitableModel {
            private double f3876d;
            private double f3877e;

            /* compiled from: subscribe ignored as client has been closed */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(LocationModel.class, new Deserializer());
                }

                public Object m5514a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(LocationParser.m5822a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object locationModel = new LocationModel();
                    ((BaseModel) locationModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (locationModel instanceof Postprocessable) {
                        return ((Postprocessable) locationModel).a();
                    }
                    return locationModel;
                }
            }

            /* compiled from: subscribe ignored as client has been closed */
            public class Serializer extends JsonSerializer<LocationModel> {
                public final void m5515a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    LocationModel locationModel = (LocationModel) obj;
                    if (locationModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(locationModel.m5516a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        locationModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    LocationParser.m5823a(locationModel.w_(), locationModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(LocationModel.class, new Serializer());
                }
            }

            public LocationModel() {
                super(2);
            }

            public final int jK_() {
                return 1965687765;
            }

            public final GraphQLVisitableModel m5517a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m5516a(FlatBufferBuilder flatBufferBuilder) {
                h();
                flatBufferBuilder.c(2);
                flatBufferBuilder.a(0, this.f3876d, 0.0d);
                flatBufferBuilder.a(1, this.f3877e, 0.0d);
                i();
                return flatBufferBuilder.d();
            }

            public final void m5518a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                super.a(mutableFlatBuffer, i, obj);
                this.f3876d = mutableFlatBuffer.a(i, 0, 0.0d);
                this.f3877e = mutableFlatBuffer.a(i, 1, 0.0d);
            }
        }

        /* compiled from: subscribe ignored as client has been closed */
        public class Serializer extends JsonSerializer<CheckinCityModel> {
            public final void m5519a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                CheckinCityModel checkinCityModel = (CheckinCityModel) obj;
                if (checkinCityModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(checkinCityModel.m5524a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    checkinCityModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                CheckinCityParser.m5825a(checkinCityModel.w_(), checkinCityModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(CheckinCityModel.class, new Serializer());
            }
        }

        public CheckinCityModel() {
            super(3);
        }

        public final void m5526a(String str, ConsistencyTuple consistencyTuple) {
            if ("name".equals(str)) {
                consistencyTuple.a = m5523k();
                consistencyTuple.b = u_();
                consistencyTuple.c = 2;
                return;
            }
            consistencyTuple.a();
        }

        public final void m5527a(String str, Object obj, boolean z) {
            if ("name".equals(str)) {
                m5521a((String) obj);
            }
        }

        @Nullable
        private GraphQLObjectType m5520a() {
            if (this.b != null && this.f3878d == null) {
                this.f3878d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
            }
            return this.f3878d;
        }

        @Nullable
        private LocationModel m5522j() {
            this.f3879e = (LocationModel) super.a(this.f3879e, 1, LocationModel.class);
            return this.f3879e;
        }

        @Nullable
        private String m5523k() {
            this.f3880f = super.a(this.f3880f, 2);
            return this.f3880f;
        }

        private void m5521a(@Nullable String str) {
            this.f3880f = str;
            if (this.b != null && this.b.d) {
                this.b.a(this.c, 2, str);
            }
        }

        public final int jK_() {
            return 77195495;
        }

        public final GraphQLVisitableModel m5525a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m5522j() != null) {
                LocationModel locationModel = (LocationModel) graphQLModelMutatingVisitor.b(m5522j());
                if (m5522j() != locationModel) {
                    graphQLVisitableModel = (CheckinCityModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f3879e = locationModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m5524a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m5520a());
            int a2 = ModelHelper.a(flatBufferBuilder, m5522j());
            int b = flatBufferBuilder.b(m5523k());
            flatBufferBuilder.c(3);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, a2);
            flatBufferBuilder.b(2, b);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 231588974)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: subscribe ignored as client has been closed */
    public final class CheckinHistoryMostRecentQueryModel extends BaseModel implements GraphQLVisitableConsistentModel {
        @Nullable
        private GraphQLObjectType f3883d;
        @Nullable
        private PlaceVisitsModel f3884e;

        /* compiled from: subscribe ignored as client has been closed */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(CheckinHistoryMostRecentQueryModel.class, new Deserializer());
            }

            public Object m5528a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = CheckinHistoryMostRecentQueryParser.m5830a(jsonParser);
                Object checkinHistoryMostRecentQueryModel = new CheckinHistoryMostRecentQueryModel();
                ((BaseModel) checkinHistoryMostRecentQueryModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (checkinHistoryMostRecentQueryModel instanceof Postprocessable) {
                    return ((Postprocessable) checkinHistoryMostRecentQueryModel).a();
                }
                return checkinHistoryMostRecentQueryModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 291814300)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: subscribe ignored as client has been closed */
        public final class PlaceVisitsModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private List<NodesModel> f3882d;

            /* compiled from: subscribe ignored as client has been closed */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(PlaceVisitsModel.class, new Deserializer());
                }

                public Object m5529a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(PlaceVisitsParser.m5828a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object placeVisitsModel = new PlaceVisitsModel();
                    ((BaseModel) placeVisitsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (placeVisitsModel instanceof Postprocessable) {
                        return ((Postprocessable) placeVisitsModel).a();
                    }
                    return placeVisitsModel;
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = -502513374)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: subscribe ignored as client has been closed */
            public final class NodesModel extends BaseModel implements GraphQLVisitableModel {
                @Nullable
                private CheckinPlaceModel f3881d;

                /* compiled from: subscribe ignored as client has been closed */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(NodesModel.class, new Deserializer());
                    }

                    public Object m5530a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(NodesParser.m5826b(jsonParser, flatBufferBuilder));
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

                /* compiled from: subscribe ignored as client has been closed */
                public class Serializer extends JsonSerializer<NodesModel> {
                    public final void m5531a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        NodesModel nodesModel = (NodesModel) obj;
                        if (nodesModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(nodesModel.m5533a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            nodesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        NodesParser.m5827b(nodesModel.w_(), nodesModel.u_(), jsonGenerator, serializerProvider);
                    }

                    static {
                        FbSerializerProvider.a(NodesModel.class, new Serializer());
                    }
                }

                @Nullable
                public final /* synthetic */ CheckinPlaceModel m5535a() {
                    return m5532j();
                }

                public NodesModel() {
                    super(1);
                }

                @Nullable
                private CheckinPlaceModel m5532j() {
                    this.f3881d = (CheckinPlaceModel) super.a(this.f3881d, 0, CheckinPlaceModel.class);
                    return this.f3881d;
                }

                public final int jK_() {
                    return 1718873252;
                }

                public final GraphQLVisitableModel m5534a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    GraphQLVisitableModel graphQLVisitableModel = null;
                    h();
                    if (m5532j() != null) {
                        CheckinPlaceModel checkinPlaceModel = (CheckinPlaceModel) graphQLModelMutatingVisitor.b(m5532j());
                        if (m5532j() != checkinPlaceModel) {
                            graphQLVisitableModel = (NodesModel) ModelHelper.a(null, this);
                            graphQLVisitableModel.f3881d = checkinPlaceModel;
                        }
                    }
                    i();
                    return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                }

                public final int m5533a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int a = ModelHelper.a(flatBufferBuilder, m5532j());
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.b(0, a);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            /* compiled from: subscribe ignored as client has been closed */
            public class Serializer extends JsonSerializer<PlaceVisitsModel> {
                public final void m5536a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    PlaceVisitsModel placeVisitsModel = (PlaceVisitsModel) obj;
                    if (placeVisitsModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(placeVisitsModel.m5537a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        placeVisitsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    PlaceVisitsParser.m5829a(placeVisitsModel.w_(), placeVisitsModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(PlaceVisitsModel.class, new Serializer());
                }
            }

            public PlaceVisitsModel() {
                super(1);
            }

            @Nonnull
            public final ImmutableList<NodesModel> m5539a() {
                this.f3882d = super.a(this.f3882d, 0, NodesModel.class);
                return (ImmutableList) this.f3882d;
            }

            public final int jK_() {
                return 1193049474;
            }

            public final GraphQLVisitableModel m5538a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m5539a() != null) {
                    Builder a = ModelHelper.a(m5539a(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        graphQLVisitableModel = (PlaceVisitsModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f3882d = a.b();
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m5537a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m5539a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, a);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: subscribe ignored as client has been closed */
        public class Serializer extends JsonSerializer<CheckinHistoryMostRecentQueryModel> {
            public final void m5540a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                CheckinHistoryMostRecentQueryModel checkinHistoryMostRecentQueryModel = (CheckinHistoryMostRecentQueryModel) obj;
                if (checkinHistoryMostRecentQueryModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(checkinHistoryMostRecentQueryModel.m5543a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    checkinHistoryMostRecentQueryModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = checkinHistoryMostRecentQueryModel.w_();
                int u_ = checkinHistoryMostRecentQueryModel.u_();
                jsonGenerator.f();
                if (mutableFlatBuffer.g(u_, 0) != 0) {
                    jsonGenerator.a("__type__");
                    SerializerHelpers.b(mutableFlatBuffer, u_, 0, jsonGenerator);
                }
                int g = mutableFlatBuffer.g(u_, 1);
                if (g != 0) {
                    jsonGenerator.a("place_visits");
                    PlaceVisitsParser.m5829a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(CheckinHistoryMostRecentQueryModel.class, new Serializer());
            }
        }

        @Nullable
        public final /* synthetic */ PlaceVisitsModel m5545a() {
            return m5542k();
        }

        public CheckinHistoryMostRecentQueryModel() {
            super(2);
        }

        public final void m5546a(String str, ConsistencyTuple consistencyTuple) {
            consistencyTuple.a();
        }

        public final void m5547a(String str, Object obj, boolean z) {
        }

        @Nullable
        private GraphQLObjectType m5541j() {
            if (this.b != null && this.f3883d == null) {
                this.f3883d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
            }
            return this.f3883d;
        }

        @Nullable
        private PlaceVisitsModel m5542k() {
            this.f3884e = (PlaceVisitsModel) super.a(this.f3884e, 1, PlaceVisitsModel.class);
            return this.f3884e;
        }

        public final int jK_() {
            return 63093205;
        }

        public final GraphQLVisitableModel m5544a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m5542k() != null) {
                PlaceVisitsModel placeVisitsModel = (PlaceVisitsModel) graphQLModelMutatingVisitor.b(m5542k());
                if (m5542k() != placeVisitsModel) {
                    graphQLVisitableModel = (CheckinHistoryMostRecentQueryModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f3884e = placeVisitsModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m5543a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m5541j());
            int a2 = ModelHelper.a(flatBufferBuilder, m5542k());
            flatBufferBuilder.c(2);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, a2);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -1992913467)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: subscribe ignored as client has been closed */
    public final class CheckinPlaceModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
        @Nullable
        private GraphQLObjectType f3928d;
        @Nullable
        private AddressModel f3929e;
        @Nullable
        private CategoryIconModel f3930f;
        @Nullable
        private String f3931g;
        @Nullable
        private FlowableTaggableActivityModel f3932h;
        @Nullable
        private String f3933i;
        @Nullable
        private LocationModel f3934j;
        @Nullable
        private String f3935k;
        @Nullable
        private PageVisitsModel f3936l;
        @Nullable
        private String f3937m;
        @Nullable
        private GraphQLPlaceType f3938n;

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1492488211)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: subscribe ignored as client has been closed */
        public final class AddressModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private String f3887d;
            @Nullable
            private String f3888e;

            /* compiled from: subscribe ignored as client has been closed */
            public final class Builder {
                @Nullable
                public String f3885a;
                @Nullable
                public String f3886b;
            }

            /* compiled from: subscribe ignored as client has been closed */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(AddressModel.class, new Deserializer());
                }

                public Object m5548a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(AddressParser.m5831a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object addressModel = new AddressModel();
                    ((BaseModel) addressModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (addressModel instanceof Postprocessable) {
                        return ((Postprocessable) addressModel).a();
                    }
                    return addressModel;
                }
            }

            /* compiled from: subscribe ignored as client has been closed */
            public class Serializer extends JsonSerializer<AddressModel> {
                public final void m5549a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    AddressModel addressModel = (AddressModel) obj;
                    if (addressModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(addressModel.m5551a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        addressModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    AddressParser.m5832a(addressModel.w_(), addressModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(AddressModel.class, new Serializer());
                }
            }

            public AddressModel() {
                super(2);
            }

            public AddressModel(MutableFlatBuffer mutableFlatBuffer) {
                super(2);
                a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
            }

            @Nullable
            public final String m5553a() {
                this.f3887d = super.a(this.f3887d, 0);
                return this.f3887d;
            }

            @Nullable
            public final String m5554b() {
                this.f3888e = super.a(this.f3888e, 1);
                return this.f3888e;
            }

            public static AddressModel m5550a(AddressModel addressModel) {
                if (addressModel == null) {
                    return null;
                }
                if (addressModel instanceof AddressModel) {
                    return addressModel;
                }
                Builder builder = new Builder();
                builder.f3885a = addressModel.m5553a();
                builder.f3886b = addressModel.m5554b();
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                int b = flatBufferBuilder.b(builder.f3885a);
                int b2 = flatBufferBuilder.b(builder.f3886b);
                flatBufferBuilder.c(2);
                flatBufferBuilder.b(0, b);
                flatBufferBuilder.b(1, b2);
                flatBufferBuilder.d(flatBufferBuilder.d());
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                return new AddressModel(new MutableFlatBuffer(wrap, null, null, true, null));
            }

            public final int jK_() {
                return 799251025;
            }

            public final GraphQLVisitableModel m5552a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m5551a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m5553a());
                int b2 = flatBufferBuilder.b(m5554b());
                flatBufferBuilder.c(2);
                flatBufferBuilder.b(0, b);
                flatBufferBuilder.b(1, b2);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: subscribe ignored as client has been closed */
        public final class Builder {
            @Nullable
            public GraphQLObjectType f3889a;
            @Nullable
            public AddressModel f3890b;
            @Nullable
            public CategoryIconModel f3891c;
            @Nullable
            public String f3892d;
            @Nullable
            public FlowableTaggableActivityModel f3893e;
            @Nullable
            public String f3894f;
            @Nullable
            public LocationModel f3895g;
            @Nullable
            public String f3896h;
            @Nullable
            public PageVisitsModel f3897i;
            @Nullable
            public String f3898j;
            @Nullable
            public GraphQLPlaceType f3899k;

            public final Builder m5556a(@Nullable String str) {
                this.f3894f = str;
                return this;
            }

            public final Builder m5555a(@Nullable LocationModel locationModel) {
                this.f3895g = locationModel;
                return this;
            }

            public final Builder m5558b(@Nullable String str) {
                this.f3896h = str;
                return this;
            }

            public final CheckinPlaceModel m5557a() {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                int a = ModelHelper.a(flatBufferBuilder, this.f3889a);
                int a2 = ModelHelper.a(flatBufferBuilder, this.f3890b);
                int a3 = ModelHelper.a(flatBufferBuilder, this.f3891c);
                int b = flatBufferBuilder.b(this.f3892d);
                int a4 = ModelHelper.a(flatBufferBuilder, this.f3893e);
                int b2 = flatBufferBuilder.b(this.f3894f);
                int a5 = ModelHelper.a(flatBufferBuilder, this.f3895g);
                int b3 = flatBufferBuilder.b(this.f3896h);
                int a6 = ModelHelper.a(flatBufferBuilder, this.f3897i);
                int b4 = flatBufferBuilder.b(this.f3898j);
                int a7 = flatBufferBuilder.a(this.f3899k);
                flatBufferBuilder.c(11);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.b(1, a2);
                flatBufferBuilder.b(2, a3);
                flatBufferBuilder.b(3, b);
                flatBufferBuilder.b(4, a4);
                flatBufferBuilder.b(5, b2);
                flatBufferBuilder.b(6, a5);
                flatBufferBuilder.b(7, b3);
                flatBufferBuilder.b(8, a6);
                flatBufferBuilder.b(9, b4);
                flatBufferBuilder.b(10, a7);
                flatBufferBuilder.d(flatBufferBuilder.d());
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                return new CheckinPlaceModel(new MutableFlatBuffer(wrap, null, null, true, null));
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 842551240)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: subscribe ignored as client has been closed */
        public final class CategoryIconModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private String f3901d;

            /* compiled from: subscribe ignored as client has been closed */
            public final class Builder {
                @Nullable
                public String f3900a;
            }

            /* compiled from: subscribe ignored as client has been closed */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(CategoryIconModel.class, new Deserializer());
                }

                public Object m5559a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(CategoryIconParser.m5833a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object categoryIconModel = new CategoryIconModel();
                    ((BaseModel) categoryIconModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (categoryIconModel instanceof Postprocessable) {
                        return ((Postprocessable) categoryIconModel).a();
                    }
                    return categoryIconModel;
                }
            }

            /* compiled from: subscribe ignored as client has been closed */
            public class Serializer extends JsonSerializer<CategoryIconModel> {
                public final void m5560a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    CategoryIconModel categoryIconModel = (CategoryIconModel) obj;
                    if (categoryIconModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(categoryIconModel.m5562a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        categoryIconModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    CategoryIconParser.m5834a(categoryIconModel.w_(), categoryIconModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(CategoryIconModel.class, new Serializer());
                }
            }

            public CategoryIconModel() {
                super(1);
            }

            public CategoryIconModel(MutableFlatBuffer mutableFlatBuffer) {
                super(1);
                a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
            }

            @Nullable
            public final String m5564a() {
                this.f3901d = super.a(this.f3901d, 0);
                return this.f3901d;
            }

            public static CategoryIconModel m5561a(CategoryIconModel categoryIconModel) {
                if (categoryIconModel == null) {
                    return null;
                }
                if (categoryIconModel instanceof CategoryIconModel) {
                    return categoryIconModel;
                }
                Builder builder = new Builder();
                builder.f3900a = categoryIconModel.m5564a();
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                int b = flatBufferBuilder.b(builder.f3900a);
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, b);
                flatBufferBuilder.d(flatBufferBuilder.d());
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                return new CategoryIconModel(new MutableFlatBuffer(wrap, null, null, true, null));
            }

            public final int jK_() {
                return 70760763;
            }

            public final GraphQLVisitableModel m5563a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m5562a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m5564a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, b);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: subscribe ignored as client has been closed */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(CheckinPlaceModel.class, new Deserializer());
            }

            public Object m5565a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(CheckinPlaceParser.m5845a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object checkinPlaceModel = new CheckinPlaceModel();
                ((BaseModel) checkinPlaceModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (checkinPlaceModel instanceof Postprocessable) {
                    return ((Postprocessable) checkinPlaceModel).a();
                }
                return checkinPlaceModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 345535000)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: subscribe ignored as client has been closed */
        public final class FlowableTaggableActivityModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private String f3916d;
            @Nullable
            private List<String> f3917e;
            @Nullable
            private FlowIconModel f3918f;
            private boolean f3919g;
            @Nullable
            private String f3920h;
            @Nullable
            private TaggableActivityModel f3921i;

            /* compiled from: subscribe ignored as client has been closed */
            public final class Builder {
                @Nullable
                public String f3902a;
                @Nullable
                public ImmutableList<String> f3903b;
                @Nullable
                public FlowIconModel f3904c;
                public boolean f3905d;
                @Nullable
                public String f3906e;
                @Nullable
                public TaggableActivityModel f3907f;
            }

            /* compiled from: subscribe ignored as client has been closed */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(FlowableTaggableActivityModel.class, new Deserializer());
                }

                public Object m5566a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(FlowableTaggableActivityParser.m5839a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object flowableTaggableActivityModel = new FlowableTaggableActivityModel();
                    ((BaseModel) flowableTaggableActivityModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (flowableTaggableActivityModel instanceof Postprocessable) {
                        return ((Postprocessable) flowableTaggableActivityModel).a();
                    }
                    return flowableTaggableActivityModel;
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = 842551240)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: subscribe ignored as client has been closed */
            public final class FlowIconModel extends BaseModel implements GraphQLVisitableModel {
                @Nullable
                private String f3909d;

                /* compiled from: subscribe ignored as client has been closed */
                public final class Builder {
                    @Nullable
                    public String f3908a;
                }

                /* compiled from: subscribe ignored as client has been closed */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(FlowIconModel.class, new Deserializer());
                    }

                    public Object m5567a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(FlowIconParser.m5835a(jsonParser, flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                        Object flowIconModel = new FlowIconModel();
                        ((BaseModel) flowIconModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                        if (flowIconModel instanceof Postprocessable) {
                            return ((Postprocessable) flowIconModel).a();
                        }
                        return flowIconModel;
                    }
                }

                /* compiled from: subscribe ignored as client has been closed */
                public class Serializer extends JsonSerializer<FlowIconModel> {
                    public final void m5568a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        FlowIconModel flowIconModel = (FlowIconModel) obj;
                        if (flowIconModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(flowIconModel.m5570a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            flowIconModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        FlowIconParser.m5836a(flowIconModel.w_(), flowIconModel.u_(), jsonGenerator);
                    }

                    static {
                        FbSerializerProvider.a(FlowIconModel.class, new Serializer());
                    }
                }

                public FlowIconModel() {
                    super(1);
                }

                public FlowIconModel(MutableFlatBuffer mutableFlatBuffer) {
                    super(1);
                    a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }

                @Nullable
                public final String m5572a() {
                    this.f3909d = super.a(this.f3909d, 0);
                    return this.f3909d;
                }

                public static FlowIconModel m5569a(FlowIconModel flowIconModel) {
                    if (flowIconModel == null) {
                        return null;
                    }
                    if (flowIconModel instanceof FlowIconModel) {
                        return flowIconModel;
                    }
                    Builder builder = new Builder();
                    builder.f3908a = flowIconModel.m5572a();
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    int b = flatBufferBuilder.b(builder.f3908a);
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.b(0, b);
                    flatBufferBuilder.d(flatBufferBuilder.d());
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    return new FlowIconModel(new MutableFlatBuffer(wrap, null, null, true, null));
                }

                public final int jK_() {
                    return 70760763;
                }

                public final GraphQLVisitableModel m5571a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    h();
                    i();
                    return this;
                }

                public final int m5570a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int b = flatBufferBuilder.b(m5572a());
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.b(0, b);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            /* compiled from: subscribe ignored as client has been closed */
            public class Serializer extends JsonSerializer<FlowableTaggableActivityModel> {
                public final void m5573a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    FlowableTaggableActivityModel flowableTaggableActivityModel = (FlowableTaggableActivityModel) obj;
                    if (flowableTaggableActivityModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(flowableTaggableActivityModel.m5585a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        flowableTaggableActivityModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    FlowableTaggableActivityParser.m5840a(flowableTaggableActivityModel.w_(), flowableTaggableActivityModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(FlowableTaggableActivityModel.class, new Serializer());
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = 1391106853)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: subscribe ignored as client has been closed */
            public final class TaggableActivityModel extends BaseModel implements GraphQLVisitableModel {
                @Nullable
                private String f3913d;
                @Nullable
                private String f3914e;
                @Nullable
                private String f3915f;

                /* compiled from: subscribe ignored as client has been closed */
                public final class Builder {
                    @Nullable
                    public String f3910a;
                    @Nullable
                    public String f3911b;
                    @Nullable
                    public String f3912c;
                }

                /* compiled from: subscribe ignored as client has been closed */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(TaggableActivityModel.class, new Deserializer());
                    }

                    public Object m5574a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(TaggableActivityParser.m5837a(jsonParser, flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                        Object taggableActivityModel = new TaggableActivityModel();
                        ((BaseModel) taggableActivityModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                        if (taggableActivityModel instanceof Postprocessable) {
                            return ((Postprocessable) taggableActivityModel).a();
                        }
                        return taggableActivityModel;
                    }
                }

                /* compiled from: subscribe ignored as client has been closed */
                public class Serializer extends JsonSerializer<TaggableActivityModel> {
                    public final void m5575a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        TaggableActivityModel taggableActivityModel = (TaggableActivityModel) obj;
                        if (taggableActivityModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(taggableActivityModel.m5577a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            taggableActivityModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        TaggableActivityParser.m5838a(taggableActivityModel.w_(), taggableActivityModel.u_(), jsonGenerator);
                    }

                    static {
                        FbSerializerProvider.a(TaggableActivityModel.class, new Serializer());
                    }
                }

                public TaggableActivityModel() {
                    super(3);
                }

                public TaggableActivityModel(MutableFlatBuffer mutableFlatBuffer) {
                    super(3);
                    a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }

                @Nullable
                public final String m5579a() {
                    this.f3913d = super.a(this.f3913d, 0);
                    return this.f3913d;
                }

                @Nullable
                public final String m5580b() {
                    this.f3914e = super.a(this.f3914e, 1);
                    return this.f3914e;
                }

                @Nullable
                public final String m5581c() {
                    this.f3915f = super.a(this.f3915f, 2);
                    return this.f3915f;
                }

                public static TaggableActivityModel m5576a(TaggableActivityModel taggableActivityModel) {
                    if (taggableActivityModel == null) {
                        return null;
                    }
                    if (taggableActivityModel instanceof TaggableActivityModel) {
                        return taggableActivityModel;
                    }
                    Builder builder = new Builder();
                    builder.f3910a = taggableActivityModel.m5579a();
                    builder.f3911b = taggableActivityModel.m5580b();
                    builder.f3912c = taggableActivityModel.m5581c();
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    int b = flatBufferBuilder.b(builder.f3910a);
                    int b2 = flatBufferBuilder.b(builder.f3911b);
                    int b3 = flatBufferBuilder.b(builder.f3912c);
                    flatBufferBuilder.c(3);
                    flatBufferBuilder.b(0, b);
                    flatBufferBuilder.b(1, b2);
                    flatBufferBuilder.b(2, b3);
                    flatBufferBuilder.d(flatBufferBuilder.d());
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    return new TaggableActivityModel(new MutableFlatBuffer(wrap, null, null, true, null));
                }

                public final int jK_() {
                    return -934090;
                }

                public final GraphQLVisitableModel m5578a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    h();
                    i();
                    return this;
                }

                public final int m5577a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int b = flatBufferBuilder.b(m5579a());
                    int b2 = flatBufferBuilder.b(m5580b());
                    int b3 = flatBufferBuilder.b(m5581c());
                    flatBufferBuilder.c(3);
                    flatBufferBuilder.b(0, b);
                    flatBufferBuilder.b(1, b2);
                    flatBufferBuilder.b(2, b3);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            @Nullable
            public final /* synthetic */ FlowIconModel m5590c() {
                return m5583j();
            }

            @Nullable
            public final /* synthetic */ TaggableActivityModel m5592g() {
                return m5584k();
            }

            public FlowableTaggableActivityModel() {
                super(6);
            }

            public FlowableTaggableActivityModel(MutableFlatBuffer mutableFlatBuffer) {
                super(6);
                a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
            }

            @Nullable
            public final String m5587a() {
                this.f3916d = super.a(this.f3916d, 0);
                return this.f3916d;
            }

            @Nonnull
            public final ImmutableList<String> m5589b() {
                this.f3917e = super.a(this.f3917e, 1);
                return (ImmutableList) this.f3917e;
            }

            @Nullable
            private FlowIconModel m5583j() {
                this.f3918f = (FlowIconModel) super.a(this.f3918f, 2, FlowIconModel.class);
                return this.f3918f;
            }

            public final boolean m5591d() {
                a(0, 3);
                return this.f3919g;
            }

            @Nullable
            public final String ch_() {
                this.f3920h = super.a(this.f3920h, 4);
                return this.f3920h;
            }

            @Nullable
            private TaggableActivityModel m5584k() {
                this.f3921i = (TaggableActivityModel) super.a(this.f3921i, 5, TaggableActivityModel.class);
                return this.f3921i;
            }

            public static FlowableTaggableActivityModel m5582a(FlowableTaggableActivityModel flowableTaggableActivityModel) {
                if (flowableTaggableActivityModel == null) {
                    return null;
                }
                if (flowableTaggableActivityModel instanceof FlowableTaggableActivityModel) {
                    return flowableTaggableActivityModel;
                }
                Builder builder = new Builder();
                builder.f3902a = flowableTaggableActivityModel.m5587a();
                com.google.common.collect.ImmutableList.Builder builder2 = ImmutableList.builder();
                for (int i = 0; i < flowableTaggableActivityModel.m5589b().size(); i++) {
                    builder2.c(flowableTaggableActivityModel.m5589b().get(i));
                }
                builder.f3903b = builder2.b();
                builder.f3904c = FlowIconModel.m5569a(flowableTaggableActivityModel.m5590c());
                builder.f3905d = flowableTaggableActivityModel.m5591d();
                builder.f3906e = flowableTaggableActivityModel.ch_();
                builder.f3907f = TaggableActivityModel.m5576a(flowableTaggableActivityModel.m5592g());
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                int b = flatBufferBuilder.b(builder.f3902a);
                int c = flatBufferBuilder.c(builder.f3903b);
                int a = ModelHelper.a(flatBufferBuilder, builder.f3904c);
                int b2 = flatBufferBuilder.b(builder.f3906e);
                int a2 = ModelHelper.a(flatBufferBuilder, builder.f3907f);
                flatBufferBuilder.c(6);
                flatBufferBuilder.b(0, b);
                flatBufferBuilder.b(1, c);
                flatBufferBuilder.b(2, a);
                flatBufferBuilder.a(3, builder.f3905d);
                flatBufferBuilder.b(4, b2);
                flatBufferBuilder.b(5, a2);
                flatBufferBuilder.d(flatBufferBuilder.d());
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                return new FlowableTaggableActivityModel(new MutableFlatBuffer(wrap, null, null, true, null));
            }

            public final int jK_() {
                return -1535302946;
            }

            public final GraphQLVisitableModel m5586a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m5583j() != null) {
                    FlowIconModel flowIconModel = (FlowIconModel) graphQLModelMutatingVisitor.b(m5583j());
                    if (m5583j() != flowIconModel) {
                        graphQLVisitableModel = (FlowableTaggableActivityModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f3918f = flowIconModel;
                    }
                }
                if (m5584k() != null) {
                    TaggableActivityModel taggableActivityModel = (TaggableActivityModel) graphQLModelMutatingVisitor.b(m5584k());
                    if (m5584k() != taggableActivityModel) {
                        graphQLVisitableModel = (FlowableTaggableActivityModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f3921i = taggableActivityModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m5585a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m5587a());
                int c = flatBufferBuilder.c(m5589b());
                int a = ModelHelper.a(flatBufferBuilder, m5583j());
                int b2 = flatBufferBuilder.b(ch_());
                int a2 = ModelHelper.a(flatBufferBuilder, m5584k());
                flatBufferBuilder.c(6);
                flatBufferBuilder.b(0, b);
                flatBufferBuilder.b(1, c);
                flatBufferBuilder.b(2, a);
                flatBufferBuilder.a(3, this.f3919g);
                flatBufferBuilder.b(4, b2);
                flatBufferBuilder.b(5, a2);
                i();
                return flatBufferBuilder.d();
            }

            public final void m5588a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                super.a(mutableFlatBuffer, i, obj);
                this.f3919g = mutableFlatBuffer.a(i, 3);
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 918622653)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: subscribe ignored as client has been closed */
        public final class LocationModel extends BaseModel implements GraphQLVisitableModel {
            private double f3924d;
            private double f3925e;

            /* compiled from: subscribe ignored as client has been closed */
            public final class Builder {
                public double f3922a;
                public double f3923b;

                public final Builder m5593a(double d) {
                    this.f3922a = d;
                    return this;
                }

                public final Builder m5595b(double d) {
                    this.f3923b = d;
                    return this;
                }

                public final LocationModel m5594a() {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.c(2);
                    flatBufferBuilder.a(0, this.f3922a, 0.0d);
                    flatBufferBuilder.a(1, this.f3923b, 0.0d);
                    flatBufferBuilder.d(flatBufferBuilder.d());
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    return new LocationModel(new MutableFlatBuffer(wrap, null, null, true, null));
                }
            }

            /* compiled from: subscribe ignored as client has been closed */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(LocationModel.class, new Deserializer());
                }

                public Object m5596a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(CheckinPlaceParser.LocationParser.m5841a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object locationModel = new LocationModel();
                    ((BaseModel) locationModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (locationModel instanceof Postprocessable) {
                        return ((Postprocessable) locationModel).a();
                    }
                    return locationModel;
                }
            }

            /* compiled from: subscribe ignored as client has been closed */
            public class Serializer extends JsonSerializer<LocationModel> {
                public final void m5597a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    LocationModel locationModel = (LocationModel) obj;
                    if (locationModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(locationModel.m5600a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        locationModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    CheckinPlaceParser.LocationParser.m5842a(locationModel.w_(), locationModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(LocationModel.class, new Serializer());
                }
            }

            public LocationModel() {
                super(2);
            }

            public LocationModel(MutableFlatBuffer mutableFlatBuffer) {
                super(2);
                a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
            }

            public final double m5599a() {
                a(0, 0);
                return this.f3924d;
            }

            public final double m5603b() {
                a(0, 1);
                return this.f3925e;
            }

            public static LocationModel m5598a(LocationModel locationModel) {
                if (locationModel == null) {
                    return null;
                }
                if (locationModel instanceof LocationModel) {
                    return locationModel;
                }
                Builder builder = new Builder();
                builder.f3922a = locationModel.m5599a();
                builder.f3923b = locationModel.m5603b();
                return builder.m5594a();
            }

            public final int jK_() {
                return 1965687765;
            }

            public final GraphQLVisitableModel m5601a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m5600a(FlatBufferBuilder flatBufferBuilder) {
                h();
                flatBufferBuilder.c(2);
                flatBufferBuilder.a(0, this.f3924d, 0.0d);
                flatBufferBuilder.a(1, this.f3925e, 0.0d);
                i();
                return flatBufferBuilder.d();
            }

            public final void m5602a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                super.a(mutableFlatBuffer, i, obj);
                this.f3924d = mutableFlatBuffer.a(i, 0, 0.0d);
                this.f3925e = mutableFlatBuffer.a(i, 1, 0.0d);
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1723990064)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: subscribe ignored as client has been closed */
        public final class PageVisitsModel extends BaseModel implements GraphQLVisitableModel {
            private int f3927d;

            /* compiled from: subscribe ignored as client has been closed */
            public final class Builder {
                public int f3926a;

                public final PageVisitsModel m5604a() {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.a(0, this.f3926a, 0);
                    flatBufferBuilder.d(flatBufferBuilder.d());
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    return new PageVisitsModel(new MutableFlatBuffer(wrap, null, null, true, null));
                }
            }

            /* compiled from: subscribe ignored as client has been closed */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(PageVisitsModel.class, new Deserializer());
                }

                public Object m5605a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(PageVisitsParser.m5843a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object pageVisitsModel = new PageVisitsModel();
                    ((BaseModel) pageVisitsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (pageVisitsModel instanceof Postprocessable) {
                        return ((Postprocessable) pageVisitsModel).a();
                    }
                    return pageVisitsModel;
                }
            }

            /* compiled from: subscribe ignored as client has been closed */
            public class Serializer extends JsonSerializer<PageVisitsModel> {
                public final void m5606a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    PageVisitsModel pageVisitsModel = (PageVisitsModel) obj;
                    if (pageVisitsModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(pageVisitsModel.m5609a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        pageVisitsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    PageVisitsParser.m5844a(pageVisitsModel.w_(), pageVisitsModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(PageVisitsModel.class, new Serializer());
                }
            }

            public PageVisitsModel() {
                super(1);
            }

            public PageVisitsModel(MutableFlatBuffer mutableFlatBuffer) {
                super(1);
                a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
            }

            public final int m5608a() {
                a(0, 0);
                return this.f3927d;
            }

            public static PageVisitsModel m5607a(PageVisitsModel pageVisitsModel) {
                if (pageVisitsModel == null) {
                    return null;
                }
                if (pageVisitsModel instanceof PageVisitsModel) {
                    return pageVisitsModel;
                }
                Builder builder = new Builder();
                builder.f3926a = pageVisitsModel.m5608a();
                return builder.m5604a();
            }

            public final int jK_() {
                return -838301099;
            }

            public final GraphQLVisitableModel m5610a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m5609a(FlatBufferBuilder flatBufferBuilder) {
                h();
                flatBufferBuilder.c(1);
                flatBufferBuilder.a(0, this.f3927d, 0);
                i();
                return flatBufferBuilder.d();
            }

            public final void m5611a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                super.a(mutableFlatBuffer, i, obj);
                this.f3927d = mutableFlatBuffer.a(i, 0, 0);
            }
        }

        /* compiled from: subscribe ignored as client has been closed */
        public class Serializer extends JsonSerializer<CheckinPlaceModel> {
            public final void m5612a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                CheckinPlaceModel checkinPlaceModel = (CheckinPlaceModel) obj;
                if (checkinPlaceModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(checkinPlaceModel.m5615a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    checkinPlaceModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                CheckinPlaceParser.m5846a(checkinPlaceModel.w_(), checkinPlaceModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(CheckinPlaceModel.class, new Serializer());
            }
        }

        @Nullable
        public final /* synthetic */ AddressModel m5621c() {
            return m5628n();
        }

        @Nullable
        public final /* synthetic */ LocationModel cg_() {
            return m5631q();
        }

        @Nullable
        public final /* synthetic */ CategoryIconModel m5622d() {
            return m5629o();
        }

        @Nullable
        public final /* synthetic */ FlowableTaggableActivityModel m5623g() {
            return m5630p();
        }

        @Nullable
        public final /* synthetic */ PageVisitsModel m5625k() {
            return m5632r();
        }

        public CheckinPlaceModel() {
            super(11);
        }

        public CheckinPlaceModel(MutableFlatBuffer mutableFlatBuffer) {
            super(11);
            a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
        }

        public final void m5618a(String str, ConsistencyTuple consistencyTuple) {
            if ("name".equals(str)) {
                consistencyTuple.a = m5624j();
                consistencyTuple.b = u_();
                consistencyTuple.c = 7;
                return;
            }
            consistencyTuple.a();
        }

        public final void m5619a(String str, Object obj, boolean z) {
            if ("name".equals(str)) {
                m5614a((String) obj);
            }
        }

        @Nullable
        public final GraphQLObjectType m5620b() {
            if (this.b != null && this.f3928d == null) {
                this.f3928d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
            }
            return this.f3928d;
        }

        @Nullable
        public final AddressModel m5628n() {
            this.f3929e = (AddressModel) super.a(this.f3929e, 1, AddressModel.class);
            return this.f3929e;
        }

        @Nullable
        public final CategoryIconModel m5629o() {
            this.f3930f = (CategoryIconModel) super.a(this.f3930f, 2, CategoryIconModel.class);
            return this.f3930f;
        }

        @Nullable
        public final String ce_() {
            this.f3931g = super.a(this.f3931g, 3);
            return this.f3931g;
        }

        @Nullable
        public final FlowableTaggableActivityModel m5630p() {
            this.f3932h = (FlowableTaggableActivityModel) super.a(this.f3932h, 4, FlowableTaggableActivityModel.class);
            return this.f3932h;
        }

        @Nullable
        public final String cf_() {
            this.f3933i = super.a(this.f3933i, 5);
            return this.f3933i;
        }

        @Nullable
        public final LocationModel m5631q() {
            this.f3934j = (LocationModel) super.a(this.f3934j, 6, LocationModel.class);
            return this.f3934j;
        }

        @Nullable
        public final String m5624j() {
            this.f3935k = super.a(this.f3935k, 7);
            return this.f3935k;
        }

        private void m5614a(@Nullable String str) {
            this.f3935k = str;
            if (this.b != null && this.b.d) {
                this.b.a(this.c, 7, str);
            }
        }

        @Nullable
        public final PageVisitsModel m5632r() {
            this.f3936l = (PageVisitsModel) super.a(this.f3936l, 8, PageVisitsModel.class);
            return this.f3936l;
        }

        @Nullable
        public final String m5626l() {
            this.f3937m = super.a(this.f3937m, 9);
            return this.f3937m;
        }

        @Nullable
        public final GraphQLPlaceType m5627m() {
            this.f3938n = (GraphQLPlaceType) super.b(this.f3938n, 10, GraphQLPlaceType.class, GraphQLPlaceType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
            return this.f3938n;
        }

        public static CheckinPlaceModel m5613a(CheckinPlaceModel checkinPlaceModel) {
            if (checkinPlaceModel == null) {
                return null;
            }
            if (checkinPlaceModel instanceof CheckinPlaceModel) {
                return checkinPlaceModel;
            }
            Builder builder = new Builder();
            builder.f3889a = checkinPlaceModel.m5620b();
            builder.f3890b = AddressModel.m5550a(checkinPlaceModel.m5621c());
            builder.f3891c = CategoryIconModel.m5561a(checkinPlaceModel.m5622d());
            builder.f3892d = checkinPlaceModel.ce_();
            builder.f3893e = FlowableTaggableActivityModel.m5582a(checkinPlaceModel.m5623g());
            builder.f3894f = checkinPlaceModel.cf_();
            builder.f3895g = LocationModel.m5598a(checkinPlaceModel.cg_());
            builder.f3896h = checkinPlaceModel.m5624j();
            builder.f3897i = PageVisitsModel.m5607a(checkinPlaceModel.m5625k());
            builder.f3898j = checkinPlaceModel.m5626l();
            builder.f3899k = checkinPlaceModel.m5627m();
            return builder.m5557a();
        }

        @Nullable
        public final String m5617a() {
            return cf_();
        }

        public final int jK_() {
            return 77195495;
        }

        public final GraphQLVisitableModel m5616a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m5628n() != null) {
                AddressModel addressModel = (AddressModel) graphQLModelMutatingVisitor.b(m5628n());
                if (m5628n() != addressModel) {
                    graphQLVisitableModel = (CheckinPlaceModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f3929e = addressModel;
                }
            }
            if (m5629o() != null) {
                CategoryIconModel categoryIconModel = (CategoryIconModel) graphQLModelMutatingVisitor.b(m5629o());
                if (m5629o() != categoryIconModel) {
                    graphQLVisitableModel = (CheckinPlaceModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f3930f = categoryIconModel;
                }
            }
            if (m5630p() != null) {
                FlowableTaggableActivityModel flowableTaggableActivityModel = (FlowableTaggableActivityModel) graphQLModelMutatingVisitor.b(m5630p());
                if (m5630p() != flowableTaggableActivityModel) {
                    graphQLVisitableModel = (CheckinPlaceModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f3932h = flowableTaggableActivityModel;
                }
            }
            if (m5631q() != null) {
                LocationModel locationModel = (LocationModel) graphQLModelMutatingVisitor.b(m5631q());
                if (m5631q() != locationModel) {
                    graphQLVisitableModel = (CheckinPlaceModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f3934j = locationModel;
                }
            }
            if (m5632r() != null) {
                PageVisitsModel pageVisitsModel = (PageVisitsModel) graphQLModelMutatingVisitor.b(m5632r());
                if (m5632r() != pageVisitsModel) {
                    graphQLVisitableModel = (CheckinPlaceModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f3936l = pageVisitsModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m5615a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m5620b());
            int a2 = ModelHelper.a(flatBufferBuilder, m5628n());
            int a3 = ModelHelper.a(flatBufferBuilder, m5629o());
            int b = flatBufferBuilder.b(ce_());
            int a4 = ModelHelper.a(flatBufferBuilder, m5630p());
            int b2 = flatBufferBuilder.b(cf_());
            int a5 = ModelHelper.a(flatBufferBuilder, m5631q());
            int b3 = flatBufferBuilder.b(m5624j());
            int a6 = ModelHelper.a(flatBufferBuilder, m5632r());
            int b4 = flatBufferBuilder.b(m5626l());
            int a7 = flatBufferBuilder.a(m5627m());
            flatBufferBuilder.c(11);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, a2);
            flatBufferBuilder.b(2, a3);
            flatBufferBuilder.b(3, b);
            flatBufferBuilder.b(4, a4);
            flatBufferBuilder.b(5, b2);
            flatBufferBuilder.b(6, a5);
            flatBufferBuilder.b(7, b3);
            flatBufferBuilder.b(8, a6);
            flatBufferBuilder.b(9, b4);
            flatBufferBuilder.b(10, a7);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 490805922)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: subscribe ignored as client has been closed */
    public final class CheckinSearchQueryModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private ClosestCityModel f3945d;
        @Nullable
        private PlaceResultsModel f3946e;
        private boolean f3947f;
        @Nullable
        private String f3948g;

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 1255661007)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: subscribe ignored as client has been closed */
        public final class ClosestCityModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
            @Nullable
            private GraphQLObjectType f3939d;
            @Nullable
            private String f3940e;
            @Nullable
            private String f3941f;

            /* compiled from: subscribe ignored as client has been closed */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(ClosestCityModel.class, new Deserializer());
                }

                public Object m5633a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(ClosestCityParser.m5847a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object closestCityModel = new ClosestCityModel();
                    ((BaseModel) closestCityModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (closestCityModel instanceof Postprocessable) {
                        return ((Postprocessable) closestCityModel).a();
                    }
                    return closestCityModel;
                }
            }

            /* compiled from: subscribe ignored as client has been closed */
            public class Serializer extends JsonSerializer<ClosestCityModel> {
                public final void m5634a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    ClosestCityModel closestCityModel = (ClosestCityModel) obj;
                    if (closestCityModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(closestCityModel.m5637a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        closestCityModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    ClosestCityParser.m5848a(closestCityModel.w_(), closestCityModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(ClosestCityModel.class, new Serializer());
                }
            }

            public ClosestCityModel() {
                super(3);
            }

            public final void m5640a(String str, ConsistencyTuple consistencyTuple) {
                if ("name".equals(str)) {
                    consistencyTuple.a = m5643c();
                    consistencyTuple.b = u_();
                    consistencyTuple.c = 2;
                    return;
                }
                consistencyTuple.a();
            }

            public final void m5641a(String str, Object obj, boolean z) {
                if ("name".equals(str)) {
                    m5635a((String) obj);
                }
            }

            @Nullable
            private GraphQLObjectType m5636j() {
                if (this.b != null && this.f3939d == null) {
                    this.f3939d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
                }
                return this.f3939d;
            }

            @Nullable
            public final String m5642b() {
                this.f3940e = super.a(this.f3940e, 1);
                return this.f3940e;
            }

            @Nullable
            public final String m5643c() {
                this.f3941f = super.a(this.f3941f, 2);
                return this.f3941f;
            }

            private void m5635a(@Nullable String str) {
                this.f3941f = str;
                if (this.b != null && this.b.d) {
                    this.b.a(this.c, 2, str);
                }
            }

            @Nullable
            public final String m5639a() {
                return m5642b();
            }

            public final int jK_() {
                return 77195495;
            }

            public final GraphQLVisitableModel m5638a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m5637a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m5636j());
                int b = flatBufferBuilder.b(m5642b());
                int b2 = flatBufferBuilder.b(m5643c());
                flatBufferBuilder.c(3);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.b(1, b);
                flatBufferBuilder.b(2, b2);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: subscribe ignored as client has been closed */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(CheckinSearchQueryModel.class, new Deserializer());
            }

            public Object m5644a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(CheckinSearchQueryParser.m5853a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object checkinSearchQueryModel = new CheckinSearchQueryModel();
                ((BaseModel) checkinSearchQueryModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (checkinSearchQueryModel instanceof Postprocessable) {
                    return ((Postprocessable) checkinSearchQueryModel).a();
                }
                return checkinSearchQueryModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 2032829656)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: subscribe ignored as client has been closed */
        public final class PlaceResultsModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private List<EdgesModel> f3943d;
            @Nullable
            private GraphQLCheckinPromptType f3944e;

            /* compiled from: subscribe ignored as client has been closed */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(PlaceResultsModel.class, new Deserializer());
                }

                public Object m5645a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(PlaceResultsParser.m5851a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object placeResultsModel = new PlaceResultsModel();
                    ((BaseModel) placeResultsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (placeResultsModel instanceof Postprocessable) {
                        return ((Postprocessable) placeResultsModel).a();
                    }
                    return placeResultsModel;
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = 1223120339)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: subscribe ignored as client has been closed */
            public final class EdgesModel extends BaseModel implements GraphQLVisitableModel {
                @Nullable
                private CheckinPlaceModel f3942d;

                /* compiled from: subscribe ignored as client has been closed */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(EdgesModel.class, new Deserializer());
                    }

                    public Object m5646a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(EdgesParser.m5849b(jsonParser, flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                        Object edgesModel = new EdgesModel();
                        ((BaseModel) edgesModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                        if (edgesModel instanceof Postprocessable) {
                            return ((Postprocessable) edgesModel).a();
                        }
                        return edgesModel;
                    }
                }

                /* compiled from: subscribe ignored as client has been closed */
                public class Serializer extends JsonSerializer<EdgesModel> {
                    public final void m5647a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        EdgesModel edgesModel = (EdgesModel) obj;
                        if (edgesModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(edgesModel.m5649a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            edgesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        EdgesParser.m5850b(edgesModel.w_(), edgesModel.u_(), jsonGenerator, serializerProvider);
                    }

                    static {
                        FbSerializerProvider.a(EdgesModel.class, new Serializer());
                    }
                }

                @Nullable
                public final /* synthetic */ CheckinPlaceModel m5651a() {
                    return m5648j();
                }

                public EdgesModel() {
                    super(1);
                }

                @Nullable
                private CheckinPlaceModel m5648j() {
                    this.f3942d = (CheckinPlaceModel) super.a(this.f3942d, 0, CheckinPlaceModel.class);
                    return this.f3942d;
                }

                public final int jK_() {
                    return -1246945919;
                }

                public final GraphQLVisitableModel m5650a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    GraphQLVisitableModel graphQLVisitableModel = null;
                    h();
                    if (m5648j() != null) {
                        CheckinPlaceModel checkinPlaceModel = (CheckinPlaceModel) graphQLModelMutatingVisitor.b(m5648j());
                        if (m5648j() != checkinPlaceModel) {
                            graphQLVisitableModel = (EdgesModel) ModelHelper.a(null, this);
                            graphQLVisitableModel.f3942d = checkinPlaceModel;
                        }
                    }
                    i();
                    return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                }

                public final int m5649a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int a = ModelHelper.a(flatBufferBuilder, m5648j());
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.b(0, a);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            /* compiled from: subscribe ignored as client has been closed */
            public class Serializer extends JsonSerializer<PlaceResultsModel> {
                public final void m5652a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    PlaceResultsModel placeResultsModel = (PlaceResultsModel) obj;
                    if (placeResultsModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(placeResultsModel.m5653a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        placeResultsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    PlaceResultsParser.m5852a(placeResultsModel.w_(), placeResultsModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(PlaceResultsModel.class, new Serializer());
                }
            }

            public PlaceResultsModel() {
                super(2);
            }

            @Nonnull
            public final ImmutableList<EdgesModel> m5655a() {
                this.f3943d = super.a(this.f3943d, 0, EdgesModel.class);
                return (ImmutableList) this.f3943d;
            }

            @Nullable
            public final GraphQLCheckinPromptType m5656b() {
                this.f3944e = (GraphQLCheckinPromptType) super.b(this.f3944e, 1, GraphQLCheckinPromptType.class, GraphQLCheckinPromptType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
                return this.f3944e;
            }

            public final int jK_() {
                return -1740092510;
            }

            public final GraphQLVisitableModel m5654a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m5655a() != null) {
                    Builder a = ModelHelper.a(m5655a(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        graphQLVisitableModel = (PlaceResultsModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f3943d = a.b();
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m5653a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m5655a());
                int a2 = flatBufferBuilder.a(m5656b());
                flatBufferBuilder.c(2);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.b(1, a2);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: subscribe ignored as client has been closed */
        public class Serializer extends JsonSerializer<CheckinSearchQueryModel> {
            public final void m5657a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                CheckinSearchQueryModel checkinSearchQueryModel = (CheckinSearchQueryModel) obj;
                if (checkinSearchQueryModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(checkinSearchQueryModel.m5660a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    checkinSearchQueryModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = checkinSearchQueryModel.w_();
                int u_ = checkinSearchQueryModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("closest_city");
                    ClosestCityParser.m5848a(mutableFlatBuffer, g, jsonGenerator);
                }
                g = mutableFlatBuffer.g(u_, 1);
                if (g != 0) {
                    jsonGenerator.a("place_results");
                    PlaceResultsParser.m5852a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                boolean a = mutableFlatBuffer.a(u_, 2);
                if (a) {
                    jsonGenerator.a("suggest_place_when_people_tagging");
                    jsonGenerator.a(a);
                }
                if (mutableFlatBuffer.g(u_, 3) != 0) {
                    jsonGenerator.a("tracking");
                    jsonGenerator.b(mutableFlatBuffer.c(u_, 3));
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(CheckinSearchQueryModel.class, new Serializer());
            }
        }

        @Nullable
        public final /* synthetic */ ClosestCityModel m5662a() {
            return m5658j();
        }

        @Nullable
        public final /* synthetic */ PlaceResultsModel m5664b() {
            return m5659k();
        }

        public CheckinSearchQueryModel() {
            super(4);
        }

        @Nullable
        private ClosestCityModel m5658j() {
            this.f3945d = (ClosestCityModel) super.a(this.f3945d, 0, ClosestCityModel.class);
            return this.f3945d;
        }

        @Nullable
        private PlaceResultsModel m5659k() {
            this.f3946e = (PlaceResultsModel) super.a(this.f3946e, 1, PlaceResultsModel.class);
            return this.f3946e;
        }

        public final boolean m5665c() {
            a(0, 2);
            return this.f3947f;
        }

        @Nullable
        public final String m5666d() {
            this.f3948g = super.a(this.f3948g, 3);
            return this.f3948g;
        }

        public final int jK_() {
            return -1042435661;
        }

        public final GraphQLVisitableModel m5661a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m5658j() != null) {
                ClosestCityModel closestCityModel = (ClosestCityModel) graphQLModelMutatingVisitor.b(m5658j());
                if (m5658j() != closestCityModel) {
                    graphQLVisitableModel = (CheckinSearchQueryModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f3945d = closestCityModel;
                }
            }
            if (m5659k() != null) {
                PlaceResultsModel placeResultsModel = (PlaceResultsModel) graphQLModelMutatingVisitor.b(m5659k());
                if (m5659k() != placeResultsModel) {
                    graphQLVisitableModel = (CheckinSearchQueryModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f3946e = placeResultsModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m5660a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m5658j());
            int a2 = ModelHelper.a(flatBufferBuilder, m5659k());
            int b = flatBufferBuilder.b(m5666d());
            flatBufferBuilder.c(4);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, a2);
            flatBufferBuilder.a(2, this.f3947f);
            flatBufferBuilder.b(3, b);
            i();
            return flatBufferBuilder.d();
        }

        public final void m5663a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
            super.a(mutableFlatBuffer, i, obj);
            this.f3947f = mutableFlatBuffer.a(i, 2);
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 823481852)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: subscribe ignored as client has been closed */
    public final class FBCheckinNearbyCityQueryModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private ClosestCityModel f3952d;

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 1255661007)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: subscribe ignored as client has been closed */
        public final class ClosestCityModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
            @Nullable
            private GraphQLObjectType f3949d;
            @Nullable
            private String f3950e;
            @Nullable
            private String f3951f;

            /* compiled from: subscribe ignored as client has been closed */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(ClosestCityModel.class, new Deserializer());
                }

                public Object m5667a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(FBCheckinNearbyCityQueryParser.ClosestCityParser.m5854a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object closestCityModel = new ClosestCityModel();
                    ((BaseModel) closestCityModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (closestCityModel instanceof Postprocessable) {
                        return ((Postprocessable) closestCityModel).a();
                    }
                    return closestCityModel;
                }
            }

            /* compiled from: subscribe ignored as client has been closed */
            public class Serializer extends JsonSerializer<ClosestCityModel> {
                public final void m5668a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    ClosestCityModel closestCityModel = (ClosestCityModel) obj;
                    if (closestCityModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(closestCityModel.m5671a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        closestCityModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    FBCheckinNearbyCityQueryParser.ClosestCityParser.m5855a(closestCityModel.w_(), closestCityModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(ClosestCityModel.class, new Serializer());
                }
            }

            public ClosestCityModel() {
                super(3);
            }

            public final void m5674a(String str, ConsistencyTuple consistencyTuple) {
                if ("name".equals(str)) {
                    consistencyTuple.a = m5677c();
                    consistencyTuple.b = u_();
                    consistencyTuple.c = 2;
                    return;
                }
                consistencyTuple.a();
            }

            public final void m5675a(String str, Object obj, boolean z) {
                if ("name".equals(str)) {
                    m5669a((String) obj);
                }
            }

            @Nullable
            private GraphQLObjectType m5670j() {
                if (this.b != null && this.f3949d == null) {
                    this.f3949d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
                }
                return this.f3949d;
            }

            @Nullable
            public final String m5676b() {
                this.f3950e = super.a(this.f3950e, 1);
                return this.f3950e;
            }

            @Nullable
            public final String m5677c() {
                this.f3951f = super.a(this.f3951f, 2);
                return this.f3951f;
            }

            private void m5669a(@Nullable String str) {
                this.f3951f = str;
                if (this.b != null && this.b.d) {
                    this.b.a(this.c, 2, str);
                }
            }

            @Nullable
            public final String m5673a() {
                return m5676b();
            }

            public final int jK_() {
                return 77195495;
            }

            public final GraphQLVisitableModel m5672a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m5671a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m5670j());
                int b = flatBufferBuilder.b(m5676b());
                int b2 = flatBufferBuilder.b(m5677c());
                flatBufferBuilder.c(3);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.b(1, b);
                flatBufferBuilder.b(2, b2);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: subscribe ignored as client has been closed */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(FBCheckinNearbyCityQueryModel.class, new Deserializer());
            }

            public Object m5678a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = FBCheckinNearbyCityQueryParser.m5856a(jsonParser);
                Object fBCheckinNearbyCityQueryModel = new FBCheckinNearbyCityQueryModel();
                ((BaseModel) fBCheckinNearbyCityQueryModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (fBCheckinNearbyCityQueryModel instanceof Postprocessable) {
                    return ((Postprocessable) fBCheckinNearbyCityQueryModel).a();
                }
                return fBCheckinNearbyCityQueryModel;
            }
        }

        /* compiled from: subscribe ignored as client has been closed */
        public class Serializer extends JsonSerializer<FBCheckinNearbyCityQueryModel> {
            public final void m5679a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                FBCheckinNearbyCityQueryModel fBCheckinNearbyCityQueryModel = (FBCheckinNearbyCityQueryModel) obj;
                if (fBCheckinNearbyCityQueryModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(fBCheckinNearbyCityQueryModel.m5681a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    fBCheckinNearbyCityQueryModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = fBCheckinNearbyCityQueryModel.w_();
                int u_ = fBCheckinNearbyCityQueryModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("closest_city");
                    FBCheckinNearbyCityQueryParser.ClosestCityParser.m5855a(mutableFlatBuffer, g, jsonGenerator);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(FBCheckinNearbyCityQueryModel.class, new Serializer());
            }
        }

        @Nullable
        public final /* synthetic */ ClosestCityModel m5683a() {
            return m5680j();
        }

        public FBCheckinNearbyCityQueryModel() {
            super(1);
        }

        @Nullable
        private ClosestCityModel m5680j() {
            this.f3952d = (ClosestCityModel) super.a(this.f3952d, 0, ClosestCityModel.class);
            return this.f3952d;
        }

        public final int jK_() {
            return -1042435661;
        }

        public final GraphQLVisitableModel m5682a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m5680j() != null) {
                ClosestCityModel closestCityModel = (ClosestCityModel) graphQLModelMutatingVisitor.b(m5680j());
                if (m5680j() != closestCityModel) {
                    graphQLVisitableModel = (FBCheckinNearbyCityQueryModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f3952d = closestCityModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m5681a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m5680j());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -1884265376)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: subscribe ignored as client has been closed */
    public final class FBCitySearchQueryModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private PlaceResultsModel f3955d;

        /* compiled from: subscribe ignored as client has been closed */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(FBCitySearchQueryModel.class, new Deserializer());
            }

            public Object m5684a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = FBCitySearchQueryParser.m5861a(jsonParser);
                Object fBCitySearchQueryModel = new FBCitySearchQueryModel();
                ((BaseModel) fBCitySearchQueryModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (fBCitySearchQueryModel instanceof Postprocessable) {
                    return ((Postprocessable) fBCitySearchQueryModel).a();
                }
                return fBCitySearchQueryModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -719138762)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: subscribe ignored as client has been closed */
        public final class PlaceResultsModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private List<EdgesModel> f3954d;

            /* compiled from: subscribe ignored as client has been closed */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(PlaceResultsModel.class, new Deserializer());
                }

                public Object m5685a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(FBCitySearchQueryParser.PlaceResultsParser.m5859a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object placeResultsModel = new PlaceResultsModel();
                    ((BaseModel) placeResultsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (placeResultsModel instanceof Postprocessable) {
                        return ((Postprocessable) placeResultsModel).a();
                    }
                    return placeResultsModel;
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = 1223120339)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: subscribe ignored as client has been closed */
            public final class EdgesModel extends BaseModel implements GraphQLVisitableModel {
                @Nullable
                private CheckinPlaceModel f3953d;

                /* compiled from: subscribe ignored as client has been closed */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(EdgesModel.class, new Deserializer());
                    }

                    public Object m5686a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(FBCitySearchQueryParser.PlaceResultsParser.EdgesParser.m5857b(jsonParser, flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                        Object edgesModel = new EdgesModel();
                        ((BaseModel) edgesModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                        if (edgesModel instanceof Postprocessable) {
                            return ((Postprocessable) edgesModel).a();
                        }
                        return edgesModel;
                    }
                }

                /* compiled from: subscribe ignored as client has been closed */
                public class Serializer extends JsonSerializer<EdgesModel> {
                    public final void m5687a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        EdgesModel edgesModel = (EdgesModel) obj;
                        if (edgesModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(edgesModel.m5689a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            edgesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        FBCitySearchQueryParser.PlaceResultsParser.EdgesParser.m5858b(edgesModel.w_(), edgesModel.u_(), jsonGenerator, serializerProvider);
                    }

                    static {
                        FbSerializerProvider.a(EdgesModel.class, new Serializer());
                    }
                }

                @Nullable
                public final /* synthetic */ CheckinPlaceModel m5691a() {
                    return m5688j();
                }

                public EdgesModel() {
                    super(1);
                }

                @Nullable
                private CheckinPlaceModel m5688j() {
                    this.f3953d = (CheckinPlaceModel) super.a(this.f3953d, 0, CheckinPlaceModel.class);
                    return this.f3953d;
                }

                public final int jK_() {
                    return -1246945919;
                }

                public final GraphQLVisitableModel m5690a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    GraphQLVisitableModel graphQLVisitableModel = null;
                    h();
                    if (m5688j() != null) {
                        CheckinPlaceModel checkinPlaceModel = (CheckinPlaceModel) graphQLModelMutatingVisitor.b(m5688j());
                        if (m5688j() != checkinPlaceModel) {
                            graphQLVisitableModel = (EdgesModel) ModelHelper.a(null, this);
                            graphQLVisitableModel.f3953d = checkinPlaceModel;
                        }
                    }
                    i();
                    return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                }

                public final int m5689a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int a = ModelHelper.a(flatBufferBuilder, m5688j());
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.b(0, a);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            /* compiled from: subscribe ignored as client has been closed */
            public class Serializer extends JsonSerializer<PlaceResultsModel> {
                public final void m5692a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    PlaceResultsModel placeResultsModel = (PlaceResultsModel) obj;
                    if (placeResultsModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(placeResultsModel.m5693a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        placeResultsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    FBCitySearchQueryParser.PlaceResultsParser.m5860a(placeResultsModel.w_(), placeResultsModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(PlaceResultsModel.class, new Serializer());
                }
            }

            public PlaceResultsModel() {
                super(1);
            }

            @Nonnull
            public final ImmutableList<EdgesModel> m5695a() {
                this.f3954d = super.a(this.f3954d, 0, EdgesModel.class);
                return (ImmutableList) this.f3954d;
            }

            public final int jK_() {
                return -1740092510;
            }

            public final GraphQLVisitableModel m5694a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m5695a() != null) {
                    Builder a = ModelHelper.a(m5695a(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        graphQLVisitableModel = (PlaceResultsModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f3954d = a.b();
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m5693a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m5695a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, a);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: subscribe ignored as client has been closed */
        public class Serializer extends JsonSerializer<FBCitySearchQueryModel> {
            public final void m5696a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                FBCitySearchQueryModel fBCitySearchQueryModel = (FBCitySearchQueryModel) obj;
                if (fBCitySearchQueryModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(fBCitySearchQueryModel.m5698a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    fBCitySearchQueryModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = fBCitySearchQueryModel.w_();
                int u_ = fBCitySearchQueryModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("place_results");
                    FBCitySearchQueryParser.PlaceResultsParser.m5860a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(FBCitySearchQueryModel.class, new Serializer());
            }
        }

        @Nullable
        public final /* synthetic */ PlaceResultsModel m5700a() {
            return m5697j();
        }

        public FBCitySearchQueryModel() {
            super(1);
        }

        @Nullable
        private PlaceResultsModel m5697j() {
            this.f3955d = (PlaceResultsModel) super.a(this.f3955d, 0, PlaceResultsModel.class);
            return this.f3955d;
        }

        public final int jK_() {
            return -1042435661;
        }

        public final GraphQLVisitableModel m5699a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m5697j() != null) {
                PlaceResultsModel placeResultsModel = (PlaceResultsModel) graphQLModelMutatingVisitor.b(m5697j());
                if (m5697j() != placeResultsModel) {
                    graphQLVisitableModel = (FBCitySearchQueryModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f3955d = placeResultsModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m5698a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m5697j());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }

    @FragmentModelWithBridge
    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -525289571)
    @JsonSerialize(using = Serializer.class)
    /* compiled from: subscribe ignored as client has been closed */
    public final class HomeResidenceQueryModel extends BaseModel implements GraphQLVisitableConsistentModel {
        @Nullable
        private GraphQLObjectType f3963d;
        @Nullable
        private AddressModel f3964e;
        @Nullable
        private CityModel f3965f;
        @Nullable
        private String f3966g;
        @Nullable
        private String f3967h;
        @Nullable
        private GraphQLPrivacyOption f3968i;
        @Nullable
        private ProfilePictureModel f3969j;
        private boolean f3970k;

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 1502488613)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: subscribe ignored as client has been closed */
        public final class AddressModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private String f3956d;

            /* compiled from: subscribe ignored as client has been closed */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(AddressModel.class, new Deserializer());
                }

                public Object m5701a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(HomeResidenceQueryParser.AddressParser.m5862a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object addressModel = new AddressModel();
                    ((BaseModel) addressModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (addressModel instanceof Postprocessable) {
                        return ((Postprocessable) addressModel).a();
                    }
                    return addressModel;
                }
            }

            /* compiled from: subscribe ignored as client has been closed */
            public class Serializer extends JsonSerializer<AddressModel> {
                public final void m5702a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    AddressModel addressModel = (AddressModel) obj;
                    if (addressModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(addressModel.m5703a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        addressModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    HomeResidenceQueryParser.AddressParser.m5863a(addressModel.w_(), addressModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(AddressModel.class, new Serializer());
                }
            }

            public AddressModel() {
                super(1);
            }

            @Nullable
            public final String m5705a() {
                this.f3956d = super.a(this.f3956d, 0);
                return this.f3956d;
            }

            public final int jK_() {
                return 799251025;
            }

            public final GraphQLVisitableModel m5704a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m5703a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m5705a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, b);
                i();
                return flatBufferBuilder.d();
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 1239572254)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: subscribe ignored as client has been closed */
        public final class CityModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
            @Nullable
            private String f3959d;
            @Nullable
            private LocationModel f3960e;
            @Nullable
            private String f3961f;

            /* compiled from: subscribe ignored as client has been closed */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(CityModel.class, new Deserializer());
                }

                public Object m5706a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(CityParser.m5866a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object cityModel = new CityModel();
                    ((BaseModel) cityModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (cityModel instanceof Postprocessable) {
                        return ((Postprocessable) cityModel).a();
                    }
                    return cityModel;
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = 918622653)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: subscribe ignored as client has been closed */
            public final class LocationModel extends BaseModel implements GraphQLVisitableModel {
                private double f3957d;
                private double f3958e;

                /* compiled from: subscribe ignored as client has been closed */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(LocationModel.class, new Deserializer());
                    }

                    public Object m5707a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(CityParser.LocationParser.m5864a(jsonParser, flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                        Object locationModel = new LocationModel();
                        ((BaseModel) locationModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                        if (locationModel instanceof Postprocessable) {
                            return ((Postprocessable) locationModel).a();
                        }
                        return locationModel;
                    }
                }

                /* compiled from: subscribe ignored as client has been closed */
                public class Serializer extends JsonSerializer<LocationModel> {
                    public final void m5708a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        LocationModel locationModel = (LocationModel) obj;
                        if (locationModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(locationModel.m5710a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            locationModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        CityParser.LocationParser.m5865a(locationModel.w_(), locationModel.u_(), jsonGenerator);
                    }

                    static {
                        FbSerializerProvider.a(LocationModel.class, new Serializer());
                    }
                }

                public LocationModel() {
                    super(2);
                }

                public final double m5709a() {
                    a(0, 0);
                    return this.f3957d;
                }

                public final double m5713b() {
                    a(0, 1);
                    return this.f3958e;
                }

                public final int jK_() {
                    return 1965687765;
                }

                public final GraphQLVisitableModel m5711a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    h();
                    i();
                    return this;
                }

                public final int m5710a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    flatBufferBuilder.c(2);
                    flatBufferBuilder.a(0, this.f3957d, 0.0d);
                    flatBufferBuilder.a(1, this.f3958e, 0.0d);
                    i();
                    return flatBufferBuilder.d();
                }

                public final void m5712a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                    super.a(mutableFlatBuffer, i, obj);
                    this.f3957d = mutableFlatBuffer.a(i, 0, 0.0d);
                    this.f3958e = mutableFlatBuffer.a(i, 1, 0.0d);
                }
            }

            /* compiled from: subscribe ignored as client has been closed */
            public class Serializer extends JsonSerializer<CityModel> {
                public final void m5714a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    CityModel cityModel = (CityModel) obj;
                    if (cityModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(cityModel.m5716a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        cityModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    CityParser.m5867a(cityModel.w_(), cityModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(CityModel.class, new Serializer());
                }
            }

            @Nullable
            public final /* synthetic */ LocationModel m5722c() {
                return m5715j();
            }

            public CityModel() {
                super(3);
            }

            public final void m5719a(String str, ConsistencyTuple consistencyTuple) {
                consistencyTuple.a();
            }

            public final void m5720a(String str, Object obj, boolean z) {
            }

            @Nullable
            public final String m5721b() {
                this.f3959d = super.a(this.f3959d, 0);
                return this.f3959d;
            }

            @Nullable
            private LocationModel m5715j() {
                this.f3960e = (LocationModel) super.a(this.f3960e, 1, LocationModel.class);
                return this.f3960e;
            }

            @Nullable
            public final String m5723d() {
                this.f3961f = super.a(this.f3961f, 2);
                return this.f3961f;
            }

            @Nullable
            public final String m5718a() {
                return m5721b();
            }

            public final int jK_() {
                return 2479791;
            }

            public final GraphQLVisitableModel m5717a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m5715j() != null) {
                    LocationModel locationModel = (LocationModel) graphQLModelMutatingVisitor.b(m5715j());
                    if (m5715j() != locationModel) {
                        graphQLVisitableModel = (CityModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f3960e = locationModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m5716a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m5721b());
                int a = ModelHelper.a(flatBufferBuilder, m5715j());
                int b2 = flatBufferBuilder.b(m5723d());
                flatBufferBuilder.c(3);
                flatBufferBuilder.b(0, b);
                flatBufferBuilder.b(1, a);
                flatBufferBuilder.b(2, b2);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: subscribe ignored as client has been closed */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(HomeResidenceQueryModel.class, new Deserializer());
            }

            public Object m5724a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(HomeResidenceQueryParser.m5870a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object homeResidenceQueryModel = new HomeResidenceQueryModel();
                ((BaseModel) homeResidenceQueryModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (homeResidenceQueryModel instanceof Postprocessable) {
                    return ((Postprocessable) homeResidenceQueryModel).a();
                }
                return homeResidenceQueryModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 842551240)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: subscribe ignored as client has been closed */
        public final class ProfilePictureModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private String f3962d;

            /* compiled from: subscribe ignored as client has been closed */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(ProfilePictureModel.class, new Deserializer());
                }

                public Object m5725a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(ProfilePictureParser.m5868a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object profilePictureModel = new ProfilePictureModel();
                    ((BaseModel) profilePictureModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (profilePictureModel instanceof Postprocessable) {
                        return ((Postprocessable) profilePictureModel).a();
                    }
                    return profilePictureModel;
                }
            }

            /* compiled from: subscribe ignored as client has been closed */
            public class Serializer extends JsonSerializer<ProfilePictureModel> {
                public final void m5726a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    ProfilePictureModel profilePictureModel = (ProfilePictureModel) obj;
                    if (profilePictureModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(profilePictureModel.m5727a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        profilePictureModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    ProfilePictureParser.m5869a(profilePictureModel.w_(), profilePictureModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(ProfilePictureModel.class, new Serializer());
                }
            }

            public ProfilePictureModel() {
                super(1);
            }

            @Nullable
            public final String m5729a() {
                this.f3962d = super.a(this.f3962d, 0);
                return this.f3962d;
            }

            public final int jK_() {
                return 70760763;
            }

            public final GraphQLVisitableModel m5728a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m5727a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m5729a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, b);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: subscribe ignored as client has been closed */
        public class Serializer extends JsonSerializer<HomeResidenceQueryModel> {
            public final void m5730a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                HomeResidenceQueryModel homeResidenceQueryModel = (HomeResidenceQueryModel) obj;
                if (homeResidenceQueryModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(homeResidenceQueryModel.m5735a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    homeResidenceQueryModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = homeResidenceQueryModel.w_();
                int u_ = homeResidenceQueryModel.u_();
                jsonGenerator.f();
                if (mutableFlatBuffer.g(u_, 0) != 0) {
                    jsonGenerator.a("__type__");
                    SerializerHelpers.b(mutableFlatBuffer, u_, 0, jsonGenerator);
                }
                int g = mutableFlatBuffer.g(u_, 1);
                if (g != 0) {
                    jsonGenerator.a("address");
                    HomeResidenceQueryParser.AddressParser.m5863a(mutableFlatBuffer, g, jsonGenerator);
                }
                g = mutableFlatBuffer.g(u_, 2);
                if (g != 0) {
                    jsonGenerator.a("city");
                    CityParser.m5867a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                if (mutableFlatBuffer.g(u_, 3) != 0) {
                    jsonGenerator.a("name");
                    jsonGenerator.b(mutableFlatBuffer.c(u_, 3));
                }
                if (mutableFlatBuffer.g(u_, 4) != 0) {
                    jsonGenerator.a("neighborhood_name");
                    jsonGenerator.b(mutableFlatBuffer.c(u_, 4));
                }
                g = mutableFlatBuffer.g(u_, 5);
                if (g != 0) {
                    jsonGenerator.a("privacy_option");
                    GraphQLPrivacyOptionDeserializer.a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                g = mutableFlatBuffer.g(u_, 6);
                if (g != 0) {
                    jsonGenerator.a("profile_picture");
                    ProfilePictureParser.m5869a(mutableFlatBuffer, g, jsonGenerator);
                }
                boolean a = mutableFlatBuffer.a(u_, 7);
                if (a) {
                    jsonGenerator.a("profile_picture_is_silhouette");
                    jsonGenerator.a(a);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(HomeResidenceQueryModel.class, new Serializer());
            }
        }

        @Nullable
        public final /* synthetic */ AddressModel m5737a() {
            return m5732k();
        }

        @Nullable
        public final /* synthetic */ CityModel m5741b() {
            return m5733l();
        }

        @Nullable
        public final /* synthetic */ ProfilePictureModel m5744g() {
            return m5734m();
        }

        public HomeResidenceQueryModel() {
            super(8);
        }

        public final void m5739a(String str, ConsistencyTuple consistencyTuple) {
            consistencyTuple.a();
        }

        public final void m5740a(String str, Object obj, boolean z) {
        }

        @Nullable
        private GraphQLObjectType m5731j() {
            if (this.b != null && this.f3963d == null) {
                this.f3963d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
            }
            return this.f3963d;
        }

        @Nullable
        private AddressModel m5732k() {
            this.f3964e = (AddressModel) super.a(this.f3964e, 1, AddressModel.class);
            return this.f3964e;
        }

        @Nullable
        private CityModel m5733l() {
            this.f3965f = (CityModel) super.a(this.f3965f, 2, CityModel.class);
            return this.f3965f;
        }

        @Nullable
        public final String m5742c() {
            this.f3966g = super.a(this.f3966g, 3);
            return this.f3966g;
        }

        @Nullable
        public final String m5743d() {
            this.f3967h = super.a(this.f3967h, 4);
            return this.f3967h;
        }

        @Nullable
        public final GraphQLPrivacyOption ci_() {
            this.f3968i = (GraphQLPrivacyOption) super.a(this.f3968i, 5, GraphQLPrivacyOption.class);
            return this.f3968i;
        }

        @Nullable
        private ProfilePictureModel m5734m() {
            this.f3969j = (ProfilePictureModel) super.a(this.f3969j, 6, ProfilePictureModel.class);
            return this.f3969j;
        }

        public final boolean cj_() {
            a(0, 7);
            return this.f3970k;
        }

        public final int jK_() {
            return 2433570;
        }

        public final GraphQLVisitableModel m5736a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m5732k() != null) {
                AddressModel addressModel = (AddressModel) graphQLModelMutatingVisitor.b(m5732k());
                if (m5732k() != addressModel) {
                    graphQLVisitableModel = (HomeResidenceQueryModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f3964e = addressModel;
                }
            }
            if (m5733l() != null) {
                CityModel cityModel = (CityModel) graphQLModelMutatingVisitor.b(m5733l());
                if (m5733l() != cityModel) {
                    graphQLVisitableModel = (HomeResidenceQueryModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f3965f = cityModel;
                }
            }
            if (ci_() != null) {
                GraphQLPrivacyOption graphQLPrivacyOption = (GraphQLPrivacyOption) graphQLModelMutatingVisitor.b(ci_());
                if (ci_() != graphQLPrivacyOption) {
                    graphQLVisitableModel = (HomeResidenceQueryModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f3968i = graphQLPrivacyOption;
                }
            }
            if (m5734m() != null) {
                ProfilePictureModel profilePictureModel = (ProfilePictureModel) graphQLModelMutatingVisitor.b(m5734m());
                if (m5734m() != profilePictureModel) {
                    graphQLVisitableModel = (HomeResidenceQueryModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f3969j = profilePictureModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m5735a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m5731j());
            int a2 = ModelHelper.a(flatBufferBuilder, m5732k());
            int a3 = ModelHelper.a(flatBufferBuilder, m5733l());
            int b = flatBufferBuilder.b(m5742c());
            int b2 = flatBufferBuilder.b(m5743d());
            int a4 = ModelHelper.a(flatBufferBuilder, ci_());
            int a5 = ModelHelper.a(flatBufferBuilder, m5734m());
            flatBufferBuilder.c(8);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, a2);
            flatBufferBuilder.b(2, a3);
            flatBufferBuilder.b(3, b);
            flatBufferBuilder.b(4, b2);
            flatBufferBuilder.b(5, a4);
            flatBufferBuilder.b(6, a5);
            flatBufferBuilder.a(7, this.f3970k);
            i();
            return flatBufferBuilder.d();
        }

        public final void m5738a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
            super.a(mutableFlatBuffer, i, obj);
            this.f3970k = mutableFlatBuffer.a(i, 7);
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -1126909823)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: subscribe ignored as client has been closed */
    public final class PlaceDetailsModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
        @Nullable
        private GraphQLObjectType f3983d;
        @Nullable
        private AddressModel f3984e;
        @Nullable
        private List<AllPhonesModel> f3985f;
        @Nullable
        private List<String> f3986g;
        @Nullable
        private FriendsWhoVisitedModel f3987h;
        @Nullable
        private String f3988i;
        @Nullable
        private String f3989j;
        @Nullable
        private LocationModel f3990k;
        @Nullable
        private String f3991l;
        @Nullable
        private ProfilePictureModel f3992m;
        @Nullable
        private List<String> f3993n;

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1492488211)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: subscribe ignored as client has been closed */
        public final class AddressModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private String f3971d;
            @Nullable
            private String f3972e;

            /* compiled from: subscribe ignored as client has been closed */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(AddressModel.class, new Deserializer());
                }

                public Object m5745a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(PlaceDetailsParser.AddressParser.m5871a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object addressModel = new AddressModel();
                    ((BaseModel) addressModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (addressModel instanceof Postprocessable) {
                        return ((Postprocessable) addressModel).a();
                    }
                    return addressModel;
                }
            }

            /* compiled from: subscribe ignored as client has been closed */
            public class Serializer extends JsonSerializer<AddressModel> {
                public final void m5746a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    AddressModel addressModel = (AddressModel) obj;
                    if (addressModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(addressModel.m5747a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        addressModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    PlaceDetailsParser.AddressParser.m5872a(addressModel.w_(), addressModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(AddressModel.class, new Serializer());
                }
            }

            public AddressModel() {
                super(2);
            }

            @Nullable
            public final String m5749a() {
                this.f3971d = super.a(this.f3971d, 0);
                return this.f3971d;
            }

            @Nullable
            public final String m5750b() {
                this.f3972e = super.a(this.f3972e, 1);
                return this.f3972e;
            }

            public final int jK_() {
                return 799251025;
            }

            public final GraphQLVisitableModel m5748a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m5747a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m5749a());
                int b2 = flatBufferBuilder.b(m5750b());
                flatBufferBuilder.c(2);
                flatBufferBuilder.b(0, b);
                flatBufferBuilder.b(1, b2);
                i();
                return flatBufferBuilder.d();
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 1826469910)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: subscribe ignored as client has been closed */
        public final class AllPhonesModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private PhoneNumberModel f3974d;

            /* compiled from: subscribe ignored as client has been closed */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(AllPhonesModel.class, new Deserializer());
                }

                public Object m5751a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(AllPhonesParser.m5875b(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object allPhonesModel = new AllPhonesModel();
                    ((BaseModel) allPhonesModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (allPhonesModel instanceof Postprocessable) {
                        return ((Postprocessable) allPhonesModel).a();
                    }
                    return allPhonesModel;
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = 1091263827)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: subscribe ignored as client has been closed */
            public final class PhoneNumberModel extends BaseModel implements GraphQLVisitableModel {
                @Nullable
                private String f3973d;

                /* compiled from: subscribe ignored as client has been closed */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(PhoneNumberModel.class, new Deserializer());
                    }

                    public Object m5752a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(PhoneNumberParser.m5873a(jsonParser, flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                        Object phoneNumberModel = new PhoneNumberModel();
                        ((BaseModel) phoneNumberModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                        if (phoneNumberModel instanceof Postprocessable) {
                            return ((Postprocessable) phoneNumberModel).a();
                        }
                        return phoneNumberModel;
                    }
                }

                /* compiled from: subscribe ignored as client has been closed */
                public class Serializer extends JsonSerializer<PhoneNumberModel> {
                    public final void m5753a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        PhoneNumberModel phoneNumberModel = (PhoneNumberModel) obj;
                        if (phoneNumberModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(phoneNumberModel.m5754a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            phoneNumberModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        PhoneNumberParser.m5874a(phoneNumberModel.w_(), phoneNumberModel.u_(), jsonGenerator);
                    }

                    static {
                        FbSerializerProvider.a(PhoneNumberModel.class, new Serializer());
                    }
                }

                public PhoneNumberModel() {
                    super(1);
                }

                @Nullable
                public final String m5756a() {
                    this.f3973d = super.a(this.f3973d, 0);
                    return this.f3973d;
                }

                public final int jK_() {
                    return 474898999;
                }

                public final GraphQLVisitableModel m5755a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    h();
                    i();
                    return this;
                }

                public final int m5754a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int b = flatBufferBuilder.b(m5756a());
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.b(0, b);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            /* compiled from: subscribe ignored as client has been closed */
            public class Serializer extends JsonSerializer<AllPhonesModel> {
                public final void m5757a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    AllPhonesModel allPhonesModel = (AllPhonesModel) obj;
                    if (allPhonesModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(allPhonesModel.m5759a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        allPhonesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    AllPhonesParser.m5876b(allPhonesModel.w_(), allPhonesModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(AllPhonesModel.class, new Serializer());
                }
            }

            @Nullable
            public final /* synthetic */ PhoneNumberModel m5761a() {
                return m5758j();
            }

            public AllPhonesModel() {
                super(1);
            }

            @Nullable
            private PhoneNumberModel m5758j() {
                this.f3974d = (PhoneNumberModel) super.a(this.f3974d, 0, PhoneNumberModel.class);
                return this.f3974d;
            }

            public final int jK_() {
                return 77090126;
            }

            public final GraphQLVisitableModel m5760a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m5758j() != null) {
                    PhoneNumberModel phoneNumberModel = (PhoneNumberModel) graphQLModelMutatingVisitor.b(m5758j());
                    if (m5758j() != phoneNumberModel) {
                        graphQLVisitableModel = (AllPhonesModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f3974d = phoneNumberModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m5759a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m5758j());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, a);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: subscribe ignored as client has been closed */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(PlaceDetailsModel.class, new Deserializer());
            }

            public Object m5762a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(PlaceDetailsParser.m5887a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object placeDetailsModel = new PlaceDetailsModel();
                ((BaseModel) placeDetailsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (placeDetailsModel instanceof Postprocessable) {
                    return ((Postprocessable) placeDetailsModel).a();
                }
                return placeDetailsModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 1903207062)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: subscribe ignored as client has been closed */
        public final class FriendsWhoVisitedModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private List<NodesModel> f3979d;

            /* compiled from: subscribe ignored as client has been closed */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(FriendsWhoVisitedModel.class, new Deserializer());
                }

                public Object m5763a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(FriendsWhoVisitedParser.m5881a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object friendsWhoVisitedModel = new FriendsWhoVisitedModel();
                    ((BaseModel) friendsWhoVisitedModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (friendsWhoVisitedModel instanceof Postprocessable) {
                        return ((Postprocessable) friendsWhoVisitedModel).a();
                    }
                    return friendsWhoVisitedModel;
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = 1948473739)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: subscribe ignored as client has been closed */
            public final class NodesModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
                @Nullable
                private String f3976d;
                @Nullable
                private String f3977e;
                @Nullable
                private ProfilePictureModel f3978f;

                /* compiled from: subscribe ignored as client has been closed */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(NodesModel.class, new Deserializer());
                    }

                    public Object m5764a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(FriendsWhoVisitedParser.NodesParser.m5879b(jsonParser, flatBufferBuilder));
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
                @ModelWithFlatBufferFormatHash(a = 842551240)
                @JsonSerialize(using = Serializer.class)
                @FragmentModelWithoutBridge
                /* compiled from: subscribe ignored as client has been closed */
                public final class ProfilePictureModel extends BaseModel implements GraphQLVisitableModel {
                    @Nullable
                    private String f3975d;

                    /* compiled from: subscribe ignored as client has been closed */
                    public class Deserializer extends FbJsonDeserializer {
                        static {
                            GlobalAutoGenDeserializerCache.a(ProfilePictureModel.class, new Deserializer());
                        }

                        public Object m5765a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(FriendsWhoVisitedParser.NodesParser.ProfilePictureParser.m5877a(jsonParser, flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            mutableFlatBuffer.a(4, Boolean.valueOf(true));
                            MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                            Object profilePictureModel = new ProfilePictureModel();
                            ((BaseModel) profilePictureModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                            if (profilePictureModel instanceof Postprocessable) {
                                return ((Postprocessable) profilePictureModel).a();
                            }
                            return profilePictureModel;
                        }
                    }

                    /* compiled from: subscribe ignored as client has been closed */
                    public class Serializer extends JsonSerializer<ProfilePictureModel> {
                        public final void m5766a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                            ProfilePictureModel profilePictureModel = (ProfilePictureModel) obj;
                            if (profilePictureModel.w_() == null) {
                                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                flatBufferBuilder.d(profilePictureModel.m5768a(flatBufferBuilder));
                                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                wrap.position(0);
                                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                profilePictureModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                            }
                            FriendsWhoVisitedParser.NodesParser.ProfilePictureParser.m5878a(profilePictureModel.w_(), profilePictureModel.u_(), jsonGenerator);
                        }

                        static {
                            FbSerializerProvider.a(ProfilePictureModel.class, new Serializer());
                        }
                    }

                    public ProfilePictureModel() {
                        super(1);
                    }

                    @Nullable
                    private String m5767a() {
                        this.f3975d = super.a(this.f3975d, 0);
                        return this.f3975d;
                    }

                    public final int jK_() {
                        return 70760763;
                    }

                    public final GraphQLVisitableModel m5769a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                        h();
                        i();
                        return this;
                    }

                    public final int m5768a(FlatBufferBuilder flatBufferBuilder) {
                        h();
                        int b = flatBufferBuilder.b(m5767a());
                        flatBufferBuilder.c(1);
                        flatBufferBuilder.b(0, b);
                        i();
                        return flatBufferBuilder.d();
                    }
                }

                /* compiled from: subscribe ignored as client has been closed */
                public class Serializer extends JsonSerializer<NodesModel> {
                    public final void m5770a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        NodesModel nodesModel = (NodesModel) obj;
                        if (nodesModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(nodesModel.m5774a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            nodesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        FriendsWhoVisitedParser.NodesParser.m5880b(nodesModel.w_(), nodesModel.u_(), jsonGenerator, serializerProvider);
                    }

                    static {
                        FbSerializerProvider.a(NodesModel.class, new Serializer());
                    }
                }

                public NodesModel() {
                    super(3);
                }

                public final void m5777a(String str, ConsistencyTuple consistencyTuple) {
                    consistencyTuple.a();
                }

                public final void m5778a(String str, Object obj, boolean z) {
                }

                @Nullable
                private String m5771j() {
                    this.f3976d = super.a(this.f3976d, 0);
                    return this.f3976d;
                }

                @Nullable
                private String m5772k() {
                    this.f3977e = super.a(this.f3977e, 1);
                    return this.f3977e;
                }

                @Nullable
                private ProfilePictureModel m5773l() {
                    this.f3978f = (ProfilePictureModel) super.a(this.f3978f, 2, ProfilePictureModel.class);
                    return this.f3978f;
                }

                @Nullable
                public final String m5776a() {
                    return m5771j();
                }

                public final int jK_() {
                    return 2645995;
                }

                public final GraphQLVisitableModel m5775a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    GraphQLVisitableModel graphQLVisitableModel = null;
                    h();
                    if (m5773l() != null) {
                        ProfilePictureModel profilePictureModel = (ProfilePictureModel) graphQLModelMutatingVisitor.b(m5773l());
                        if (m5773l() != profilePictureModel) {
                            graphQLVisitableModel = (NodesModel) ModelHelper.a(null, this);
                            graphQLVisitableModel.f3978f = profilePictureModel;
                        }
                    }
                    i();
                    return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                }

                public final int m5774a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int b = flatBufferBuilder.b(m5771j());
                    int b2 = flatBufferBuilder.b(m5772k());
                    int a = ModelHelper.a(flatBufferBuilder, m5773l());
                    flatBufferBuilder.c(3);
                    flatBufferBuilder.b(0, b);
                    flatBufferBuilder.b(1, b2);
                    flatBufferBuilder.b(2, a);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            /* compiled from: subscribe ignored as client has been closed */
            public class Serializer extends JsonSerializer<FriendsWhoVisitedModel> {
                public final void m5779a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    FriendsWhoVisitedModel friendsWhoVisitedModel = (FriendsWhoVisitedModel) obj;
                    if (friendsWhoVisitedModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(friendsWhoVisitedModel.m5781a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        friendsWhoVisitedModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    FriendsWhoVisitedParser.m5882a(friendsWhoVisitedModel.w_(), friendsWhoVisitedModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(FriendsWhoVisitedModel.class, new Serializer());
                }
            }

            public FriendsWhoVisitedModel() {
                super(1);
            }

            @Nonnull
            private ImmutableList<NodesModel> m5780a() {
                this.f3979d = super.a(this.f3979d, 0, NodesModel.class);
                return (ImmutableList) this.f3979d;
            }

            public final int jK_() {
                return -404188513;
            }

            public final GraphQLVisitableModel m5782a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m5780a() != null) {
                    Builder a = ModelHelper.a(m5780a(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        graphQLVisitableModel = (FriendsWhoVisitedModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f3979d = a.b();
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m5781a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m5780a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, a);
                i();
                return flatBufferBuilder.d();
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 918622653)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: subscribe ignored as client has been closed */
        public final class LocationModel extends BaseModel implements GraphQLVisitableModel {
            private double f3980d;
            private double f3981e;

            /* compiled from: subscribe ignored as client has been closed */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(LocationModel.class, new Deserializer());
                }

                public Object m5783a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(PlaceDetailsParser.LocationParser.m5883a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object locationModel = new LocationModel();
                    ((BaseModel) locationModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (locationModel instanceof Postprocessable) {
                        return ((Postprocessable) locationModel).a();
                    }
                    return locationModel;
                }
            }

            /* compiled from: subscribe ignored as client has been closed */
            public class Serializer extends JsonSerializer<LocationModel> {
                public final void m5784a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    LocationModel locationModel = (LocationModel) obj;
                    if (locationModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(locationModel.m5786a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        locationModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    PlaceDetailsParser.LocationParser.m5884a(locationModel.w_(), locationModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(LocationModel.class, new Serializer());
                }
            }

            public LocationModel() {
                super(2);
            }

            public final double m5785a() {
                a(0, 0);
                return this.f3980d;
            }

            public final double m5789b() {
                a(0, 1);
                return this.f3981e;
            }

            public final int jK_() {
                return 1965687765;
            }

            public final GraphQLVisitableModel m5787a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m5786a(FlatBufferBuilder flatBufferBuilder) {
                h();
                flatBufferBuilder.c(2);
                flatBufferBuilder.a(0, this.f3980d, 0.0d);
                flatBufferBuilder.a(1, this.f3981e, 0.0d);
                i();
                return flatBufferBuilder.d();
            }

            public final void m5788a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                super.a(mutableFlatBuffer, i, obj);
                this.f3980d = mutableFlatBuffer.a(i, 0, 0.0d);
                this.f3981e = mutableFlatBuffer.a(i, 1, 0.0d);
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 842551240)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: subscribe ignored as client has been closed */
        public final class ProfilePictureModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private String f3982d;

            /* compiled from: subscribe ignored as client has been closed */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(ProfilePictureModel.class, new Deserializer());
                }

                public Object m5790a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(PlaceDetailsParser.ProfilePictureParser.m5885a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object profilePictureModel = new ProfilePictureModel();
                    ((BaseModel) profilePictureModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (profilePictureModel instanceof Postprocessable) {
                        return ((Postprocessable) profilePictureModel).a();
                    }
                    return profilePictureModel;
                }
            }

            /* compiled from: subscribe ignored as client has been closed */
            public class Serializer extends JsonSerializer<ProfilePictureModel> {
                public final void m5791a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    ProfilePictureModel profilePictureModel = (ProfilePictureModel) obj;
                    if (profilePictureModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(profilePictureModel.m5793a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        profilePictureModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    PlaceDetailsParser.ProfilePictureParser.m5886a(profilePictureModel.w_(), profilePictureModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(ProfilePictureModel.class, new Serializer());
                }
            }

            public ProfilePictureModel() {
                super(1);
            }

            @Nullable
            private String m5792a() {
                this.f3982d = super.a(this.f3982d, 0);
                return this.f3982d;
            }

            public final int jK_() {
                return 70760763;
            }

            public final GraphQLVisitableModel m5794a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m5793a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m5792a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, b);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: subscribe ignored as client has been closed */
        public class Serializer extends JsonSerializer<PlaceDetailsModel> {
            public final void m5795a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                PlaceDetailsModel placeDetailsModel = (PlaceDetailsModel) obj;
                if (placeDetailsModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(placeDetailsModel.m5804a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    placeDetailsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                PlaceDetailsParser.m5888a(placeDetailsModel.w_(), placeDetailsModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(PlaceDetailsModel.class, new Serializer());
            }
        }

        @Nullable
        public final /* synthetic */ AddressModel m5809b() {
            return m5798k();
        }

        @Nullable
        public final /* synthetic */ LocationModel cl_() {
            return m5802o();
        }

        public PlaceDetailsModel() {
            super(11);
        }

        public final void m5807a(String str, ConsistencyTuple consistencyTuple) {
            if ("name".equals(str)) {
                consistencyTuple.a = m5812g();
                consistencyTuple.b = u_();
                consistencyTuple.c = 8;
                return;
            }
            consistencyTuple.a();
        }

        public final void m5808a(String str, Object obj, boolean z) {
            if ("name".equals(str)) {
                m5796a((String) obj);
            }
        }

        @Nullable
        private GraphQLObjectType m5797j() {
            if (this.b != null && this.f3983d == null) {
                this.f3983d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
            }
            return this.f3983d;
        }

        @Nullable
        private AddressModel m5798k() {
            this.f3984e = (AddressModel) super.a(this.f3984e, 1, AddressModel.class);
            return this.f3984e;
        }

        @Nonnull
        public final ImmutableList<AllPhonesModel> m5810c() {
            this.f3985f = super.a(this.f3985f, 2, AllPhonesModel.class);
            return (ImmutableList) this.f3985f;
        }

        @Nonnull
        public final ImmutableList<String> m5811d() {
            this.f3986g = super.a(this.f3986g, 3);
            return (ImmutableList) this.f3986g;
        }

        @Nullable
        private FriendsWhoVisitedModel m5799l() {
            this.f3987h = (FriendsWhoVisitedModel) super.a(this.f3987h, 4, FriendsWhoVisitedModel.class);
            return this.f3987h;
        }

        @Nullable
        private String m5800m() {
            this.f3988i = super.a(this.f3988i, 5);
            return this.f3988i;
        }

        @Nullable
        private String m5801n() {
            this.f3989j = super.a(this.f3989j, 6);
            return this.f3989j;
        }

        @Nullable
        private LocationModel m5802o() {
            this.f3990k = (LocationModel) super.a(this.f3990k, 7, LocationModel.class);
            return this.f3990k;
        }

        @Nullable
        public final String m5812g() {
            this.f3991l = super.a(this.f3991l, 8);
            return this.f3991l;
        }

        private void m5796a(@Nullable String str) {
            this.f3991l = str;
            if (this.b != null && this.b.d) {
                this.b.a(this.c, 8, str);
            }
        }

        @Nullable
        private ProfilePictureModel m5803p() {
            this.f3992m = (ProfilePictureModel) super.a(this.f3992m, 9, ProfilePictureModel.class);
            return this.f3992m;
        }

        @Nonnull
        public final ImmutableList<String> ck_() {
            this.f3993n = super.a(this.f3993n, 10);
            return (ImmutableList) this.f3993n;
        }

        @Nullable
        public final String m5806a() {
            return m5801n();
        }

        public final int jK_() {
            return 77195495;
        }

        public final GraphQLVisitableModel m5805a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m5798k() != null) {
                AddressModel addressModel = (AddressModel) graphQLModelMutatingVisitor.b(m5798k());
                if (m5798k() != addressModel) {
                    graphQLVisitableModel = (PlaceDetailsModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f3984e = addressModel;
                }
            }
            if (m5810c() != null) {
                Builder a = ModelHelper.a(m5810c(), graphQLModelMutatingVisitor);
                if (a != null) {
                    PlaceDetailsModel placeDetailsModel = (PlaceDetailsModel) ModelHelper.a(graphQLVisitableModel, this);
                    placeDetailsModel.f3985f = a.b();
                    graphQLVisitableModel = placeDetailsModel;
                }
            }
            if (m5799l() != null) {
                FriendsWhoVisitedModel friendsWhoVisitedModel = (FriendsWhoVisitedModel) graphQLModelMutatingVisitor.b(m5799l());
                if (m5799l() != friendsWhoVisitedModel) {
                    graphQLVisitableModel = (PlaceDetailsModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f3987h = friendsWhoVisitedModel;
                }
            }
            if (m5802o() != null) {
                LocationModel locationModel = (LocationModel) graphQLModelMutatingVisitor.b(m5802o());
                if (m5802o() != locationModel) {
                    graphQLVisitableModel = (PlaceDetailsModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f3990k = locationModel;
                }
            }
            if (m5803p() != null) {
                ProfilePictureModel profilePictureModel = (ProfilePictureModel) graphQLModelMutatingVisitor.b(m5803p());
                if (m5803p() != profilePictureModel) {
                    graphQLVisitableModel = (PlaceDetailsModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f3992m = profilePictureModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m5804a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m5797j());
            int a2 = ModelHelper.a(flatBufferBuilder, m5798k());
            int a3 = ModelHelper.a(flatBufferBuilder, m5810c());
            int c = flatBufferBuilder.c(m5811d());
            int a4 = ModelHelper.a(flatBufferBuilder, m5799l());
            int b = flatBufferBuilder.b(m5800m());
            int b2 = flatBufferBuilder.b(m5801n());
            int a5 = ModelHelper.a(flatBufferBuilder, m5802o());
            int b3 = flatBufferBuilder.b(m5812g());
            int a6 = ModelHelper.a(flatBufferBuilder, m5803p());
            int c2 = flatBufferBuilder.c(ck_());
            flatBufferBuilder.c(11);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, a2);
            flatBufferBuilder.b(2, a3);
            flatBufferBuilder.b(3, c);
            flatBufferBuilder.b(4, a4);
            flatBufferBuilder.b(5, b);
            flatBufferBuilder.b(6, b2);
            flatBufferBuilder.b(7, a5);
            flatBufferBuilder.b(8, b3);
            flatBufferBuilder.b(9, a6);
            flatBufferBuilder.b(10, c2);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 247298312)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: subscribe ignored as client has been closed */
    public final class UserProfileCitiesQueryModel extends BaseModel implements GraphQLVisitableConsistentModel {
        @Nullable
        private GraphQLObjectType f3994d;
        @Nullable
        private CheckinCityModel f3995e;
        @Nullable
        private CheckinCityModel f3996f;

        /* compiled from: subscribe ignored as client has been closed */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(UserProfileCitiesQueryModel.class, new Deserializer());
            }

            public Object m5813a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = UserProfileCitiesQueryParser.m5889a(jsonParser);
                Object userProfileCitiesQueryModel = new UserProfileCitiesQueryModel();
                ((BaseModel) userProfileCitiesQueryModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (userProfileCitiesQueryModel instanceof Postprocessable) {
                    return ((Postprocessable) userProfileCitiesQueryModel).a();
                }
                return userProfileCitiesQueryModel;
            }
        }

        /* compiled from: subscribe ignored as client has been closed */
        public class Serializer extends JsonSerializer<UserProfileCitiesQueryModel> {
            public final void m5814a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                UserProfileCitiesQueryModel userProfileCitiesQueryModel = (UserProfileCitiesQueryModel) obj;
                if (userProfileCitiesQueryModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(userProfileCitiesQueryModel.m5818a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    userProfileCitiesQueryModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = userProfileCitiesQueryModel.w_();
                int u_ = userProfileCitiesQueryModel.u_();
                jsonGenerator.f();
                if (mutableFlatBuffer.g(u_, 0) != 0) {
                    jsonGenerator.a("__type__");
                    SerializerHelpers.b(mutableFlatBuffer, u_, 0, jsonGenerator);
                }
                int g = mutableFlatBuffer.g(u_, 1);
                if (g != 0) {
                    jsonGenerator.a("current_city");
                    CheckinCityParser.m5825a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                g = mutableFlatBuffer.g(u_, 2);
                if (g != 0) {
                    jsonGenerator.a("hometown");
                    CheckinCityParser.m5825a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(UserProfileCitiesQueryModel.class, new Serializer());
            }
        }

        public UserProfileCitiesQueryModel() {
            super(3);
        }

        public final void m5820a(String str, ConsistencyTuple consistencyTuple) {
            consistencyTuple.a();
        }

        public final void m5821a(String str, Object obj, boolean z) {
        }

        @Nullable
        private GraphQLObjectType m5815a() {
            if (this.b != null && this.f3994d == null) {
                this.f3994d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
            }
            return this.f3994d;
        }

        @Nullable
        private CheckinCityModel m5816j() {
            this.f3995e = (CheckinCityModel) super.a(this.f3995e, 1, CheckinCityModel.class);
            return this.f3995e;
        }

        @Nullable
        private CheckinCityModel m5817k() {
            this.f3996f = (CheckinCityModel) super.a(this.f3996f, 2, CheckinCityModel.class);
            return this.f3996f;
        }

        public final int jK_() {
            return 63093205;
        }

        public final GraphQLVisitableModel m5819a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            CheckinCityModel checkinCityModel;
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m5816j() != null) {
                checkinCityModel = (CheckinCityModel) graphQLModelMutatingVisitor.b(m5816j());
                if (m5816j() != checkinCityModel) {
                    graphQLVisitableModel = (UserProfileCitiesQueryModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f3995e = checkinCityModel;
                }
            }
            if (m5817k() != null) {
                checkinCityModel = (CheckinCityModel) graphQLModelMutatingVisitor.b(m5817k());
                if (m5817k() != checkinCityModel) {
                    graphQLVisitableModel = (UserProfileCitiesQueryModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f3996f = checkinCityModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m5818a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m5815a());
            int a2 = ModelHelper.a(flatBufferBuilder, m5816j());
            int a3 = ModelHelper.a(flatBufferBuilder, m5817k());
            flatBufferBuilder.c(3);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, a2);
            flatBufferBuilder.b(2, a3);
            i();
            return flatBufferBuilder.d();
        }
    }
}
