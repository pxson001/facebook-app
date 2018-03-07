package com.facebook.search.results.protocol.entity;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbSerializerProvider;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.FragmentModelWithoutBridge;
import com.facebook.flatbuffers.ModelWithFlatBufferFormatHash;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.enums.GraphQLPageOpenHoursDisplayDecisionEnum;
import com.facebook.graphql.enums.GraphQLSavedState;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.querybuilder.common.CommonGraphQLModels.DefaultImageFieldsModel;
import com.facebook.graphql.visitor.ConsistencyTuple;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLPersistableNode;
import com.facebook.graphql.visitor.GraphQLVisitableConsistentModel;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.facebook.search.results.protocol.entity.SearchResultsPlaceInterfaces.SearchResultsPlace;
import com.facebook.search.results.protocol.entity.SearchResultsPlaceParsers.SearchResultsPlaceParser;
import com.facebook.search.results.protocol.entity.SearchResultsPlaceParsers.SearchResultsPlaceParser.AddressParser;
import com.facebook.search.results.protocol.entity.SearchResultsPlaceParsers.SearchResultsPlaceParser.LocationParser;
import com.facebook.search.results.protocol.entity.SearchResultsPlaceParsers.SearchResultsPlaceParser.OverallStarRatingParser;
import com.facebook.search.results.protocol.entity.SearchResultsPlaceParsers.SearchResultsPlaceParser.PlaceOpenStatusParser;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.google.common.collect.ImmutableList;
import java.nio.ByteBuffer;
import java.util.List;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/* compiled from: mimetype = ? */
public class SearchResultsPlaceModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 1569553247)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: mimetype = ? */
    public final class SearchResultsPlaceModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel, SearchResultsPlace {
        @Nullable
        private AddressModel f8658d;
        @Nullable
        private List<String> f8659e;
        private boolean f8660f;
        @Nullable
        private String f8661g;
        private boolean f8662h;
        @Nullable
        private LocationModel f8663i;
        @Nullable
        private String f8664j;
        @Nullable
        private OverallStarRatingModel f8665k;
        @Nullable
        private PlaceOpenStatusModel f8666l;
        @Nullable
        private GraphQLPageOpenHoursDisplayDecisionEnum f8667m;
        @Nullable
        private String f8668n;
        @Nullable
        private DefaultImageFieldsModel f8669o;
        @Nullable
        private GraphQLSavedState f8670p;

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -2110849367)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: mimetype = ? */
        public final class AddressModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private String f8647d;

            /* compiled from: mimetype = ? */
            public final class Builder {
                @Nullable
                public String f8646a;
            }

            /* compiled from: mimetype = ? */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(AddressModel.class, new Deserializer());
                }

                public Object m10042a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(AddressParser.m10090a(jsonParser, flatBufferBuilder));
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

            /* compiled from: mimetype = ? */
            public class Serializer extends JsonSerializer<AddressModel> {
                public final void m10043a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    AddressModel addressModel = (AddressModel) obj;
                    if (addressModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(addressModel.m10045a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        addressModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    AddressParser.m10091a(addressModel.w_(), addressModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(AddressModel.class, new Serializer());
                }
            }

            public AddressModel() {
                super(1);
            }

            public AddressModel(MutableFlatBuffer mutableFlatBuffer) {
                super(1);
                a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
            }

            @Nullable
            public final String m10047a() {
                this.f8647d = super.a(this.f8647d, 0);
                return this.f8647d;
            }

            public static AddressModel m10044a(AddressModel addressModel) {
                if (addressModel == null) {
                    return null;
                }
                if (addressModel instanceof AddressModel) {
                    return addressModel;
                }
                Builder builder = new Builder();
                builder.f8646a = addressModel.m10047a();
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                int b = flatBufferBuilder.b(builder.f8646a);
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, b);
                flatBufferBuilder.d(flatBufferBuilder.d());
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                return new AddressModel(new MutableFlatBuffer(wrap, null, null, true, null));
            }

            public final int jK_() {
                return 799251025;
            }

            public final GraphQLVisitableModel m10046a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m10045a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m10047a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, b);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: mimetype = ? */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(SearchResultsPlaceModel.class, new Deserializer());
            }

            public Object m10048a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(SearchResultsPlaceParser.m10098a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object searchResultsPlaceModel = new SearchResultsPlaceModel();
                ((BaseModel) searchResultsPlaceModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (searchResultsPlaceModel instanceof Postprocessable) {
                    return ((Postprocessable) searchResultsPlaceModel).a();
                }
                return searchResultsPlaceModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 918622653)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: mimetype = ? */
        public final class LocationModel extends BaseModel implements GraphQLVisitableModel {
            private double f8650d;
            private double f8651e;

            /* compiled from: mimetype = ? */
            public final class Builder {
                public double f8648a;
                public double f8649b;

                public final LocationModel m10049a() {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.c(2);
                    flatBufferBuilder.a(0, this.f8648a, 0.0d);
                    flatBufferBuilder.a(1, this.f8649b, 0.0d);
                    flatBufferBuilder.d(flatBufferBuilder.d());
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    return new LocationModel(new MutableFlatBuffer(wrap, null, null, true, null));
                }
            }

            /* compiled from: mimetype = ? */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(LocationModel.class, new Deserializer());
                }

                public Object m10050a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(LocationParser.m10092a(jsonParser, flatBufferBuilder));
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

            /* compiled from: mimetype = ? */
            public class Serializer extends JsonSerializer<LocationModel> {
                public final void m10051a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    LocationModel locationModel = (LocationModel) obj;
                    if (locationModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(locationModel.m10054a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        locationModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    LocationParser.m10093a(locationModel.w_(), locationModel.u_(), jsonGenerator);
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

            public final double m10053a() {
                a(0, 0);
                return this.f8650d;
            }

            public final double m10057b() {
                a(0, 1);
                return this.f8651e;
            }

            public static LocationModel m10052a(LocationModel locationModel) {
                if (locationModel == null) {
                    return null;
                }
                if (locationModel instanceof LocationModel) {
                    return locationModel;
                }
                Builder builder = new Builder();
                builder.f8648a = locationModel.m10053a();
                builder.f8649b = locationModel.m10057b();
                return builder.m10049a();
            }

            public final int jK_() {
                return 1965687765;
            }

            public final GraphQLVisitableModel m10055a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m10054a(FlatBufferBuilder flatBufferBuilder) {
                h();
                flatBufferBuilder.c(2);
                flatBufferBuilder.a(0, this.f8650d, 0.0d);
                flatBufferBuilder.a(1, this.f8651e, 0.0d);
                i();
                return flatBufferBuilder.d();
            }

            public final void m10056a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                super.a(mutableFlatBuffer, i, obj);
                this.f8650d = mutableFlatBuffer.a(i, 0, 0.0d);
                this.f8651e = mutableFlatBuffer.a(i, 1, 0.0d);
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1026989130)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: mimetype = ? */
        public final class OverallStarRatingModel extends BaseModel implements GraphQLVisitableModel {
            private int f8654d;
            private double f8655e;

            /* compiled from: mimetype = ? */
            public final class Builder {
                public int f8652a;
                public double f8653b;
            }

            /* compiled from: mimetype = ? */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(OverallStarRatingModel.class, new Deserializer());
                }

                public Object m10058a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(OverallStarRatingParser.m10094a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object overallStarRatingModel = new OverallStarRatingModel();
                    ((BaseModel) overallStarRatingModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (overallStarRatingModel instanceof Postprocessable) {
                        return ((Postprocessable) overallStarRatingModel).a();
                    }
                    return overallStarRatingModel;
                }
            }

            /* compiled from: mimetype = ? */
            public class Serializer extends JsonSerializer<OverallStarRatingModel> {
                public final void m10059a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    OverallStarRatingModel overallStarRatingModel = (OverallStarRatingModel) obj;
                    if (overallStarRatingModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(overallStarRatingModel.m10062a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        overallStarRatingModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    OverallStarRatingParser.m10095a(overallStarRatingModel.w_(), overallStarRatingModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(OverallStarRatingModel.class, new Serializer());
                }
            }

            public OverallStarRatingModel() {
                super(2);
            }

            public OverallStarRatingModel(MutableFlatBuffer mutableFlatBuffer) {
                super(2);
                a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
            }

            public final int m10061a() {
                a(0, 0);
                return this.f8654d;
            }

            public final double m10065b() {
                a(0, 1);
                return this.f8655e;
            }

            public static OverallStarRatingModel m10060a(OverallStarRatingModel overallStarRatingModel) {
                if (overallStarRatingModel == null) {
                    return null;
                }
                if (overallStarRatingModel instanceof OverallStarRatingModel) {
                    return overallStarRatingModel;
                }
                Builder builder = new Builder();
                builder.f8652a = overallStarRatingModel.m10061a();
                builder.f8653b = overallStarRatingModel.m10065b();
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.c(2);
                flatBufferBuilder.a(0, builder.f8652a, 0);
                flatBufferBuilder.a(1, builder.f8653b, 0.0d);
                flatBufferBuilder.d(flatBufferBuilder.d());
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                return new OverallStarRatingModel(new MutableFlatBuffer(wrap, null, null, true, null));
            }

            public final int jK_() {
                return -1854235203;
            }

            public final GraphQLVisitableModel m10063a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m10062a(FlatBufferBuilder flatBufferBuilder) {
                h();
                flatBufferBuilder.c(2);
                flatBufferBuilder.a(0, this.f8654d, 0);
                flatBufferBuilder.a(1, this.f8655e, 0.0d);
                i();
                return flatBufferBuilder.d();
            }

            public final void m10064a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                super.a(mutableFlatBuffer, i, obj);
                this.f8654d = mutableFlatBuffer.a(i, 0, 0);
                this.f8655e = mutableFlatBuffer.a(i, 1, 0.0d);
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1352864475)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: mimetype = ? */
        public final class PlaceOpenStatusModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private String f8657d;

            /* compiled from: mimetype = ? */
            public final class Builder {
                @Nullable
                public String f8656a;
            }

            /* compiled from: mimetype = ? */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(PlaceOpenStatusModel.class, new Deserializer());
                }

                public Object m10066a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(PlaceOpenStatusParser.m10096a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object placeOpenStatusModel = new PlaceOpenStatusModel();
                    ((BaseModel) placeOpenStatusModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (placeOpenStatusModel instanceof Postprocessable) {
                        return ((Postprocessable) placeOpenStatusModel).a();
                    }
                    return placeOpenStatusModel;
                }
            }

            /* compiled from: mimetype = ? */
            public class Serializer extends JsonSerializer<PlaceOpenStatusModel> {
                public final void m10067a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    PlaceOpenStatusModel placeOpenStatusModel = (PlaceOpenStatusModel) obj;
                    if (placeOpenStatusModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(placeOpenStatusModel.m10069a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        placeOpenStatusModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    PlaceOpenStatusParser.m10097a(placeOpenStatusModel.w_(), placeOpenStatusModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(PlaceOpenStatusModel.class, new Serializer());
                }
            }

            public PlaceOpenStatusModel() {
                super(1);
            }

            public PlaceOpenStatusModel(MutableFlatBuffer mutableFlatBuffer) {
                super(1);
                a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
            }

            @Nullable
            public final String m10071a() {
                this.f8657d = super.a(this.f8657d, 0);
                return this.f8657d;
            }

            public static PlaceOpenStatusModel m10068a(PlaceOpenStatusModel placeOpenStatusModel) {
                if (placeOpenStatusModel == null) {
                    return null;
                }
                if (placeOpenStatusModel instanceof PlaceOpenStatusModel) {
                    return placeOpenStatusModel;
                }
                Builder builder = new Builder();
                builder.f8656a = placeOpenStatusModel.m10071a();
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                int b = flatBufferBuilder.b(builder.f8656a);
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, b);
                flatBufferBuilder.d(flatBufferBuilder.d());
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                return new PlaceOpenStatusModel(new MutableFlatBuffer(wrap, null, null, true, null));
            }

            public final int jK_() {
                return -1919764332;
            }

            public final GraphQLVisitableModel m10070a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m10069a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m10071a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, b);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: mimetype = ? */
        public class Serializer extends JsonSerializer<SearchResultsPlaceModel> {
            public final void m10072a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                SearchResultsPlaceModel searchResultsPlaceModel = (SearchResultsPlaceModel) obj;
                if (searchResultsPlaceModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(searchResultsPlaceModel.m10084a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    searchResultsPlaceModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                SearchResultsPlaceParser.m10099a(searchResultsPlaceModel.w_(), searchResultsPlaceModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(SearchResultsPlaceModel.class, new Serializer());
            }
        }

        public SearchResultsPlaceModel() {
            super(13);
        }

        public final void m10088a(String str, ConsistencyTuple consistencyTuple) {
            consistencyTuple.a();
        }

        public final void m10089a(String str, Object obj, boolean z) {
        }

        @Nullable
        private AddressModel m10073j() {
            this.f8658d = (AddressModel) super.a(this.f8658d, 0, AddressModel.class);
            return this.f8658d;
        }

        @Nonnull
        private ImmutableList<String> m10074k() {
            this.f8659e = super.a(this.f8659e, 1);
            return (ImmutableList) this.f8659e;
        }

        @Nullable
        private String m10075l() {
            this.f8661g = super.a(this.f8661g, 3);
            return this.f8661g;
        }

        @Nullable
        private LocationModel m10076m() {
            this.f8663i = (LocationModel) super.a(this.f8663i, 5, LocationModel.class);
            return this.f8663i;
        }

        @Nullable
        private String m10077n() {
            this.f8664j = super.a(this.f8664j, 6);
            return this.f8664j;
        }

        @Nullable
        private OverallStarRatingModel m10078o() {
            this.f8665k = (OverallStarRatingModel) super.a(this.f8665k, 7, OverallStarRatingModel.class);
            return this.f8665k;
        }

        @Nullable
        private PlaceOpenStatusModel m10079p() {
            this.f8666l = (PlaceOpenStatusModel) super.a(this.f8666l, 8, PlaceOpenStatusModel.class);
            return this.f8666l;
        }

        @Nullable
        private GraphQLPageOpenHoursDisplayDecisionEnum m10080q() {
            this.f8667m = (GraphQLPageOpenHoursDisplayDecisionEnum) super.b(this.f8667m, 9, GraphQLPageOpenHoursDisplayDecisionEnum.class, GraphQLPageOpenHoursDisplayDecisionEnum.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
            return this.f8667m;
        }

        @Nullable
        private String m10081r() {
            this.f8668n = super.a(this.f8668n, 10);
            return this.f8668n;
        }

        @Nullable
        private DefaultImageFieldsModel m10082s() {
            this.f8669o = (DefaultImageFieldsModel) super.a(this.f8669o, 11, DefaultImageFieldsModel.class);
            return this.f8669o;
        }

        @Nullable
        private GraphQLSavedState m10083t() {
            this.f8670p = (GraphQLSavedState) super.b(this.f8670p, 12, GraphQLSavedState.class, GraphQLSavedState.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
            return this.f8670p;
        }

        @Nullable
        public final String m10086a() {
            return m10075l();
        }

        public final int jK_() {
            return 2479791;
        }

        public final GraphQLVisitableModel m10085a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m10073j() != null) {
                AddressModel addressModel = (AddressModel) graphQLModelMutatingVisitor.b(m10073j());
                if (m10073j() != addressModel) {
                    graphQLVisitableModel = (SearchResultsPlaceModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f8658d = addressModel;
                }
            }
            if (m10076m() != null) {
                LocationModel locationModel = (LocationModel) graphQLModelMutatingVisitor.b(m10076m());
                if (m10076m() != locationModel) {
                    graphQLVisitableModel = (SearchResultsPlaceModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f8663i = locationModel;
                }
            }
            if (m10078o() != null) {
                OverallStarRatingModel overallStarRatingModel = (OverallStarRatingModel) graphQLModelMutatingVisitor.b(m10078o());
                if (m10078o() != overallStarRatingModel) {
                    graphQLVisitableModel = (SearchResultsPlaceModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f8665k = overallStarRatingModel;
                }
            }
            if (m10079p() != null) {
                PlaceOpenStatusModel placeOpenStatusModel = (PlaceOpenStatusModel) graphQLModelMutatingVisitor.b(m10079p());
                if (m10079p() != placeOpenStatusModel) {
                    graphQLVisitableModel = (SearchResultsPlaceModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f8666l = placeOpenStatusModel;
                }
            }
            if (m10082s() != null) {
                DefaultImageFieldsModel defaultImageFieldsModel = (DefaultImageFieldsModel) graphQLModelMutatingVisitor.b(m10082s());
                if (m10082s() != defaultImageFieldsModel) {
                    graphQLVisitableModel = (SearchResultsPlaceModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f8669o = defaultImageFieldsModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m10084a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m10073j());
            int c = flatBufferBuilder.c(m10074k());
            int b = flatBufferBuilder.b(m10075l());
            int a2 = ModelHelper.a(flatBufferBuilder, m10076m());
            int b2 = flatBufferBuilder.b(m10077n());
            int a3 = ModelHelper.a(flatBufferBuilder, m10078o());
            int a4 = ModelHelper.a(flatBufferBuilder, m10079p());
            int a5 = flatBufferBuilder.a(m10080q());
            int b3 = flatBufferBuilder.b(m10081r());
            int a6 = ModelHelper.a(flatBufferBuilder, m10082s());
            int a7 = flatBufferBuilder.a(m10083t());
            flatBufferBuilder.c(13);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, c);
            flatBufferBuilder.a(2, this.f8660f);
            flatBufferBuilder.b(3, b);
            flatBufferBuilder.a(4, this.f8662h);
            flatBufferBuilder.b(5, a2);
            flatBufferBuilder.b(6, b2);
            flatBufferBuilder.b(7, a3);
            flatBufferBuilder.b(8, a4);
            flatBufferBuilder.b(9, a5);
            flatBufferBuilder.b(10, b3);
            flatBufferBuilder.b(11, a6);
            flatBufferBuilder.b(12, a7);
            i();
            return flatBufferBuilder.d();
        }

        public final void m10087a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
            super.a(mutableFlatBuffer, i, obj);
            this.f8660f = mutableFlatBuffer.a(i, 2);
            this.f8662h = mutableFlatBuffer.a(i, 4);
        }
    }
}
