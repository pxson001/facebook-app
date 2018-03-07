package com.facebook.crowdsourcing.protocol.graphql;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbSerializerProvider;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.crowdsourcing.protocol.graphql.SuggestEditsInterfaces.CrowdsourcedAddress;
import com.facebook.crowdsourcing.protocol.graphql.SuggestEditsInterfaces.CrowdsourcedCategory;
import com.facebook.crowdsourcing.protocol.graphql.SuggestEditsInterfaces.CrowdsourcedHours;
import com.facebook.crowdsourcing.protocol.graphql.SuggestEditsInterfaces.CrowdsourcedLocatedIn;
import com.facebook.crowdsourcing.protocol.graphql.SuggestEditsInterfaces.CrowdsourcedPhoto;
import com.facebook.crowdsourcing.protocol.graphql.SuggestEditsInterfaces.SuggestEditsField;
import com.facebook.crowdsourcing.protocol.graphql.SuggestEditsParsers.CrowdsourcedAddressParser;
import com.facebook.crowdsourcing.protocol.graphql.SuggestEditsParsers.CrowdsourcedAddressParser.CityParser;
import com.facebook.crowdsourcing.protocol.graphql.SuggestEditsParsers.CrowdsourcedAddressParser.CityParser.LocationParser;
import com.facebook.crowdsourcing.protocol.graphql.SuggestEditsParsers.CrowdsourcedCategoryParser;
import com.facebook.crowdsourcing.protocol.graphql.SuggestEditsParsers.CrowdsourcedCategoryParser.CategoryParser;
import com.facebook.crowdsourcing.protocol.graphql.SuggestEditsParsers.CrowdsourcedFieldParser;
import com.facebook.crowdsourcing.protocol.graphql.SuggestEditsParsers.CrowdsourcedFieldParser.UserValuesParser;
import com.facebook.crowdsourcing.protocol.graphql.SuggestEditsParsers.CrowdsourcedFieldParser.UserValuesParser.EdgesParser;
import com.facebook.crowdsourcing.protocol.graphql.SuggestEditsParsers.CrowdsourcedFieldParser.UserValuesParser.EdgesParser.NodeParser;
import com.facebook.crowdsourcing.protocol.graphql.SuggestEditsParsers.CrowdsourcedHoursParser;
import com.facebook.crowdsourcing.protocol.graphql.SuggestEditsParsers.CrowdsourcedHoursParser.FriParser;
import com.facebook.crowdsourcing.protocol.graphql.SuggestEditsParsers.CrowdsourcedHoursParser.MonParser;
import com.facebook.crowdsourcing.protocol.graphql.SuggestEditsParsers.CrowdsourcedHoursParser.SatParser;
import com.facebook.crowdsourcing.protocol.graphql.SuggestEditsParsers.CrowdsourcedHoursParser.SunParser;
import com.facebook.crowdsourcing.protocol.graphql.SuggestEditsParsers.CrowdsourcedHoursParser.ThuParser;
import com.facebook.crowdsourcing.protocol.graphql.SuggestEditsParsers.CrowdsourcedHoursParser.TueParser;
import com.facebook.crowdsourcing.protocol.graphql.SuggestEditsParsers.CrowdsourcedHoursParser.WedParser;
import com.facebook.crowdsourcing.protocol.graphql.SuggestEditsParsers.CrowdsourcedLocatedInParser;
import com.facebook.crowdsourcing.protocol.graphql.SuggestEditsParsers.CrowdsourcedLocatedInParser.ParentPlaceParser;
import com.facebook.crowdsourcing.protocol.graphql.SuggestEditsParsers.CrowdsourcedPhotoParser;
import com.facebook.crowdsourcing.protocol.graphql.SuggestEditsParsers.CrowdsourcedPhotoParser.PhotoParser;
import com.facebook.crowdsourcing.protocol.graphql.SuggestEditsParsers.CrowdsourcedPhotoParser.PhotoParser.ImageParser;
import com.facebook.crowdsourcing.protocol.graphql.SuggestEditsParsers.SuggestEditsFieldParser;
import com.facebook.crowdsourcing.protocol.graphql.SuggestEditsParsers.SuggestEditsFieldParser.OptionsParser;
import com.facebook.crowdsourcing.protocol.graphql.SuggestEditsParsers.SuggestEditsHeaderParser;
import com.facebook.crowdsourcing.protocol.graphql.SuggestEditsParsers.SuggestEditsOptionParser;
import com.facebook.crowdsourcing.protocol.graphql.SuggestEditsParsers.SuggestEditsOptionParser.FieldIconParser;
import com.facebook.crowdsourcing.protocol.graphql.SuggestEditsParsers.SuggestEditsOptionParser.OptionIconParser;
import com.facebook.crowdsourcing.protocol.graphql.SuggestEditsParsers.SuggestEditsOptionParser.OptionSelectedIconParser;
import com.facebook.crowdsourcing.protocol.graphql.SuggestEditsParsers.SuggestEditsOptionParser.OptionValueParser;
import com.facebook.crowdsourcing.protocol.graphql.SuggestEditsParsers.SuggestEditsSectionParser;
import com.facebook.crowdsourcing.protocol.graphql.SuggestEditsParsers.SuggestEditsSectionParser.FieldSectionsParser;
import com.facebook.crowdsourcing.protocol.graphql.SuggestEditsParsers.SuggestEditsSectionsParser;
import com.facebook.crowdsourcing.protocol.graphql.SuggestEditsParsers.SuggestEditsSectionsParser.CrowdsourcingSuggestEditsCardsParser;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.FragmentModelWithoutBridge;
import com.facebook.flatbuffers.ModelWithFlatBufferFormatHash;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.enums.GraphQLObjectType;
import com.facebook.graphql.enums.GraphQLSuggestEditsFieldOptionType;
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

/* compiled from: sync_params/ */
public class SuggestEditsModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 908588948)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: sync_params/ */
    public final class CrowdsourcedAddressModel extends BaseModel implements CrowdsourcedAddress, GraphQLVisitableModel {
        @Nullable
        private CityModel f2392d;
        @Nullable
        private String f2393e;
        @Nullable
        private String f2394f;

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 2055927059)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: sync_params/ */
        public final class CityModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
            @Nullable
            private String f2389d;
            @Nullable
            private LocationModel f2390e;
            @Nullable
            private String f2391f;

            /* compiled from: sync_params/ */
            public final class Builder {
                @Nullable
                public String f2382a;
                @Nullable
                public LocationModel f2383b;
                @Nullable
                public String f2384c;

                public final CityModel m2512a() {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    int b = flatBufferBuilder.b(this.f2382a);
                    int a = ModelHelper.a(flatBufferBuilder, this.f2383b);
                    int b2 = flatBufferBuilder.b(this.f2384c);
                    flatBufferBuilder.c(3);
                    flatBufferBuilder.b(0, b);
                    flatBufferBuilder.b(1, a);
                    flatBufferBuilder.b(2, b2);
                    flatBufferBuilder.d(flatBufferBuilder.d());
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    return new CityModel(new MutableFlatBuffer(wrap, null, null, true, null));
                }
            }

            /* compiled from: sync_params/ */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(CityModel.class, new Deserializer());
                }

                public Object m2513a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(CityParser.m2882a(jsonParser, flatBufferBuilder));
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
            /* compiled from: sync_params/ */
            public final class LocationModel extends BaseModel implements GraphQLVisitableModel {
                private double f2387d;
                private double f2388e;

                /* compiled from: sync_params/ */
                public final class Builder {
                    public double f2385a;
                    public double f2386b;

                    public final LocationModel m2514a() {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.c(2);
                        flatBufferBuilder.a(0, this.f2385a, 0.0d);
                        flatBufferBuilder.a(1, this.f2386b, 0.0d);
                        flatBufferBuilder.d(flatBufferBuilder.d());
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        return new LocationModel(new MutableFlatBuffer(wrap, null, null, true, null));
                    }
                }

                /* compiled from: sync_params/ */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(LocationModel.class, new Deserializer());
                    }

                    public Object m2515a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(LocationParser.m2880a(jsonParser, flatBufferBuilder));
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

                /* compiled from: sync_params/ */
                public class Serializer extends JsonSerializer<LocationModel> {
                    public final void m2516a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        LocationModel locationModel = (LocationModel) obj;
                        if (locationModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(locationModel.m2519a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            locationModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        LocationParser.m2881a(locationModel.w_(), locationModel.u_(), jsonGenerator);
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

                public final double m2518a() {
                    a(0, 0);
                    return this.f2387d;
                }

                public final double m2522b() {
                    a(0, 1);
                    return this.f2388e;
                }

                public static LocationModel m2517a(LocationModel locationModel) {
                    if (locationModel == null) {
                        return null;
                    }
                    if (locationModel instanceof LocationModel) {
                        return locationModel;
                    }
                    Builder builder = new Builder();
                    builder.f2385a = locationModel.m2518a();
                    builder.f2386b = locationModel.m2522b();
                    return builder.m2514a();
                }

                public final int jK_() {
                    return 1965687765;
                }

                public final GraphQLVisitableModel m2520a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    h();
                    i();
                    return this;
                }

                public final int m2519a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    flatBufferBuilder.c(2);
                    flatBufferBuilder.a(0, this.f2387d, 0.0d);
                    flatBufferBuilder.a(1, this.f2388e, 0.0d);
                    i();
                    return flatBufferBuilder.d();
                }

                public final void m2521a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                    super.a(mutableFlatBuffer, i, obj);
                    this.f2387d = mutableFlatBuffer.a(i, 0, 0.0d);
                    this.f2388e = mutableFlatBuffer.a(i, 1, 0.0d);
                }
            }

            /* compiled from: sync_params/ */
            public class Serializer extends JsonSerializer<CityModel> {
                public final void m2523a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    CityModel cityModel = (CityModel) obj;
                    if (cityModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(cityModel.m2526a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        cityModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    CityParser.m2883a(cityModel.w_(), cityModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(CityModel.class, new Serializer());
                }
            }

            @Nullable
            public final /* synthetic */ LocationModel m2532c() {
                return m2525j();
            }

            public CityModel() {
                super(3);
            }

            public CityModel(MutableFlatBuffer mutableFlatBuffer) {
                super(3);
                a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
            }

            public final void m2529a(String str, ConsistencyTuple consistencyTuple) {
                consistencyTuple.a();
            }

            public final void m2530a(String str, Object obj, boolean z) {
            }

            @Nullable
            public final String m2531b() {
                this.f2389d = super.a(this.f2389d, 0);
                return this.f2389d;
            }

            @Nullable
            private LocationModel m2525j() {
                this.f2390e = (LocationModel) super.a(this.f2390e, 1, LocationModel.class);
                return this.f2390e;
            }

            @Nullable
            public final String m2533d() {
                this.f2391f = super.a(this.f2391f, 2);
                return this.f2391f;
            }

            public static CityModel m2524a(CityModel cityModel) {
                if (cityModel == null) {
                    return null;
                }
                if (cityModel instanceof CityModel) {
                    return cityModel;
                }
                Builder builder = new Builder();
                builder.f2382a = cityModel.m2531b();
                builder.f2383b = LocationModel.m2517a(cityModel.m2532c());
                builder.f2384c = cityModel.m2533d();
                return builder.m2512a();
            }

            @Nullable
            public final String m2528a() {
                return m2531b();
            }

            public final int jK_() {
                return 2479791;
            }

            public final GraphQLVisitableModel m2527a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m2525j() != null) {
                    LocationModel locationModel = (LocationModel) graphQLModelMutatingVisitor.b(m2525j());
                    if (m2525j() != locationModel) {
                        graphQLVisitableModel = (CityModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f2390e = locationModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m2526a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m2531b());
                int a = ModelHelper.a(flatBufferBuilder, m2525j());
                int b2 = flatBufferBuilder.b(m2533d());
                flatBufferBuilder.c(3);
                flatBufferBuilder.b(0, b);
                flatBufferBuilder.b(1, a);
                flatBufferBuilder.b(2, b2);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: sync_params/ */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(CrowdsourcedAddressModel.class, new Deserializer());
            }

            public Object m2534a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = CrowdsourcedAddressParser.m2884a(jsonParser);
                Object crowdsourcedAddressModel = new CrowdsourcedAddressModel();
                ((BaseModel) crowdsourcedAddressModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (crowdsourcedAddressModel instanceof Postprocessable) {
                    return ((Postprocessable) crowdsourcedAddressModel).a();
                }
                return crowdsourcedAddressModel;
            }
        }

        /* compiled from: sync_params/ */
        public class Serializer extends JsonSerializer<CrowdsourcedAddressModel> {
            public final void m2535a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                CrowdsourcedAddressModel crowdsourcedAddressModel = (CrowdsourcedAddressModel) obj;
                if (crowdsourcedAddressModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(crowdsourcedAddressModel.m2539a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    crowdsourcedAddressModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = crowdsourcedAddressModel.w_();
                int u_ = crowdsourcedAddressModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("city");
                    CityParser.m2883a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                if (mutableFlatBuffer.g(u_, 1) != 0) {
                    jsonGenerator.a("street");
                    jsonGenerator.b(mutableFlatBuffer.c(u_, 1));
                }
                if (mutableFlatBuffer.g(u_, 2) != 0) {
                    jsonGenerator.a("zip");
                    jsonGenerator.b(mutableFlatBuffer.c(u_, 2));
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(CrowdsourcedAddressModel.class, new Serializer());
            }
        }

        public CrowdsourcedAddressModel() {
            super(3);
        }

        @Nullable
        private CityModel m2536a() {
            this.f2392d = (CityModel) super.a(this.f2392d, 0, CityModel.class);
            return this.f2392d;
        }

        @Nullable
        private String m2537j() {
            this.f2393e = super.a(this.f2393e, 1);
            return this.f2393e;
        }

        @Nullable
        private String m2538k() {
            this.f2394f = super.a(this.f2394f, 2);
            return this.f2394f;
        }

        public final int jK_() {
            return -660039287;
        }

        public final GraphQLVisitableModel m2540a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m2536a() != null) {
                CityModel cityModel = (CityModel) graphQLModelMutatingVisitor.b(m2536a());
                if (m2536a() != cityModel) {
                    graphQLVisitableModel = (CrowdsourcedAddressModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f2392d = cityModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m2539a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m2536a());
            int b = flatBufferBuilder.b(m2537j());
            int b2 = flatBufferBuilder.b(m2538k());
            flatBufferBuilder.c(3);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, b);
            flatBufferBuilder.b(2, b2);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -748052206)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: sync_params/ */
    public final class CrowdsourcedCategoryModel extends BaseModel implements CrowdsourcedCategory, GraphQLVisitableModel {
        @Nullable
        private CategoryModel f2399d;

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -383963122)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: sync_params/ */
        public final class CategoryModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private String f2397d;
            @Nullable
            private String f2398e;

            /* compiled from: sync_params/ */
            public final class Builder {
                @Nullable
                public String f2395a;
                @Nullable
                public String f2396b;

                public final CategoryModel m2541a() {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    int b = flatBufferBuilder.b(this.f2395a);
                    int b2 = flatBufferBuilder.b(this.f2396b);
                    flatBufferBuilder.c(2);
                    flatBufferBuilder.b(0, b);
                    flatBufferBuilder.b(1, b2);
                    flatBufferBuilder.d(flatBufferBuilder.d());
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    return new CategoryModel(new MutableFlatBuffer(wrap, null, null, true, null));
                }
            }

            /* compiled from: sync_params/ */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(CategoryModel.class, new Deserializer());
                }

                public Object m2542a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(CategoryParser.m2885a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object categoryModel = new CategoryModel();
                    ((BaseModel) categoryModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (categoryModel instanceof Postprocessable) {
                        return ((Postprocessable) categoryModel).a();
                    }
                    return categoryModel;
                }
            }

            /* compiled from: sync_params/ */
            public class Serializer extends JsonSerializer<CategoryModel> {
                public final void m2543a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    CategoryModel categoryModel = (CategoryModel) obj;
                    if (categoryModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(categoryModel.m2545a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        categoryModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    CategoryParser.m2886a(categoryModel.w_(), categoryModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(CategoryModel.class, new Serializer());
                }
            }

            public CategoryModel() {
                super(2);
            }

            public CategoryModel(MutableFlatBuffer mutableFlatBuffer) {
                super(2);
                a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
            }

            @Nullable
            public final String m2547a() {
                this.f2397d = super.a(this.f2397d, 0);
                return this.f2397d;
            }

            @Nullable
            public final String m2548b() {
                this.f2398e = super.a(this.f2398e, 1);
                return this.f2398e;
            }

            public static CategoryModel m2544a(CategoryModel categoryModel) {
                if (categoryModel == null) {
                    return null;
                }
                if (categoryModel instanceof CategoryModel) {
                    return categoryModel;
                }
                Builder builder = new Builder();
                builder.f2395a = categoryModel.m2547a();
                builder.f2396b = categoryModel.m2548b();
                return builder.m2541a();
            }

            public final int jK_() {
                return -1210237407;
            }

            public final GraphQLVisitableModel m2546a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m2545a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m2547a());
                int b2 = flatBufferBuilder.b(m2548b());
                flatBufferBuilder.c(2);
                flatBufferBuilder.b(0, b);
                flatBufferBuilder.b(1, b2);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: sync_params/ */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(CrowdsourcedCategoryModel.class, new Deserializer());
            }

            public Object m2549a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = CrowdsourcedCategoryParser.m2887a(jsonParser);
                Object crowdsourcedCategoryModel = new CrowdsourcedCategoryModel();
                ((BaseModel) crowdsourcedCategoryModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (crowdsourcedCategoryModel instanceof Postprocessable) {
                    return ((Postprocessable) crowdsourcedCategoryModel).a();
                }
                return crowdsourcedCategoryModel;
            }
        }

        /* compiled from: sync_params/ */
        public class Serializer extends JsonSerializer<CrowdsourcedCategoryModel> {
            public final void m2550a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                CrowdsourcedCategoryModel crowdsourcedCategoryModel = (CrowdsourcedCategoryModel) obj;
                if (crowdsourcedCategoryModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(crowdsourcedCategoryModel.m2552a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    crowdsourcedCategoryModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = crowdsourcedCategoryModel.w_();
                int u_ = crowdsourcedCategoryModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("category");
                    CategoryParser.m2886a(mutableFlatBuffer, g, jsonGenerator);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(CrowdsourcedCategoryModel.class, new Serializer());
            }
        }

        public CrowdsourcedCategoryModel() {
            super(1);
        }

        @Nullable
        private CategoryModel m2551a() {
            this.f2399d = (CategoryModel) super.a(this.f2399d, 0, CategoryModel.class);
            return this.f2399d;
        }

        public final int jK_() {
            return -2012122615;
        }

        public final GraphQLVisitableModel m2553a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m2551a() != null) {
                CategoryModel categoryModel = (CategoryModel) graphQLModelMutatingVisitor.b(m2551a());
                if (m2551a() != categoryModel) {
                    graphQLVisitableModel = (CrowdsourcedCategoryModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f2399d = categoryModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m2552a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m2551a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 611000089)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: sync_params/ */
    public final class CrowdsourcedFieldModel extends BaseModel implements GraphQLVisitableModel {
        private boolean f2436d;
        @Nullable
        private UserValuesModel f2437e;

        /* compiled from: sync_params/ */
        public final class Builder {
            public boolean f2400a;
            @Nullable
            public UserValuesModel f2401b;

            public static Builder m2554a(CrowdsourcedFieldModel crowdsourcedFieldModel) {
                Builder builder = new Builder();
                builder.f2400a = crowdsourcedFieldModel.m2600a();
                builder.f2401b = crowdsourcedFieldModel.m2602j();
                return builder;
            }

            public final CrowdsourcedFieldModel m2555a() {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                int a = ModelHelper.a(flatBufferBuilder, this.f2401b);
                flatBufferBuilder.c(2);
                flatBufferBuilder.a(0, this.f2400a);
                flatBufferBuilder.b(1, a);
                flatBufferBuilder.d(flatBufferBuilder.d());
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                return new CrowdsourcedFieldModel(new MutableFlatBuffer(wrap, null, null, true, null));
            }
        }

        /* compiled from: sync_params/ */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(CrowdsourcedFieldModel.class, new Deserializer());
            }

            public Object m2556a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(CrowdsourcedFieldParser.m2894a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object crowdsourcedFieldModel = new CrowdsourcedFieldModel();
                ((BaseModel) crowdsourcedFieldModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (crowdsourcedFieldModel instanceof Postprocessable) {
                    return ((Postprocessable) crowdsourcedFieldModel).a();
                }
                return crowdsourcedFieldModel;
            }
        }

        /* compiled from: sync_params/ */
        public class Serializer extends JsonSerializer<CrowdsourcedFieldModel> {
            public final void m2557a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                CrowdsourcedFieldModel crowdsourcedFieldModel = (CrowdsourcedFieldModel) obj;
                if (crowdsourcedFieldModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(crowdsourcedFieldModel.m2597a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    crowdsourcedFieldModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                CrowdsourcedFieldParser.m2895a(crowdsourcedFieldModel.w_(), crowdsourcedFieldModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(CrowdsourcedFieldModel.class, new Serializer());
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1212147579)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: sync_params/ */
        public final class UserValuesModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private List<EdgesModel> f2435d;

            /* compiled from: sync_params/ */
            public final class Builder {
                @Nullable
                public ImmutableList<EdgesModel> f2402a;

                public final UserValuesModel m2558a() {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    int a = ModelHelper.a(flatBufferBuilder, this.f2402a);
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.b(0, a);
                    flatBufferBuilder.d(flatBufferBuilder.d());
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    return new UserValuesModel(new MutableFlatBuffer(wrap, null, null, true, null));
                }
            }

            /* compiled from: sync_params/ */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(UserValuesModel.class, new Deserializer());
                }

                public Object m2559a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(UserValuesParser.m2892a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object userValuesModel = new UserValuesModel();
                    ((BaseModel) userValuesModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (userValuesModel instanceof Postprocessable) {
                        return ((Postprocessable) userValuesModel).a();
                    }
                    return userValuesModel;
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = -471917171)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: sync_params/ */
            public final class EdgesModel extends BaseModel implements GraphQLVisitableModel {
                @Nullable
                private NodeModel f2434d;

                /* compiled from: sync_params/ */
                public final class Builder {
                    @Nullable
                    public NodeModel f2403a;

                    public final EdgesModel m2560a() {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        int a = ModelHelper.a(flatBufferBuilder, this.f2403a);
                        flatBufferBuilder.c(1);
                        flatBufferBuilder.b(0, a);
                        flatBufferBuilder.d(flatBufferBuilder.d());
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        return new EdgesModel(new MutableFlatBuffer(wrap, null, null, true, null));
                    }
                }

                /* compiled from: sync_params/ */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(EdgesModel.class, new Deserializer());
                    }

                    public Object m2561a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(EdgesParser.m2890b(jsonParser, flatBufferBuilder));
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

                @JsonDeserialize(using = Deserializer.class)
                @ModelWithFlatBufferFormatHash(a = 1507018910)
                @JsonSerialize(using = Serializer.class)
                @FragmentModelWithoutBridge
                /* compiled from: sync_params/ */
                public final class NodeModel extends BaseModel implements CrowdsourcedAddress, CrowdsourcedCategory, CrowdsourcedHours, CrowdsourcedLocatedIn, CrowdsourcedPhoto, GraphQLVisitableModel {
                    @Nullable
                    private GraphQLObjectType f2419d;
                    @Nullable
                    private CategoryModel f2420e;
                    @Nullable
                    private CityModel f2421f;
                    @Nullable
                    private List<FriModel> f2422g;
                    @Nullable
                    private List<MonModel> f2423h;
                    @Nullable
                    private ParentPlaceModel f2424i;
                    @Nullable
                    private PhotoModel f2425j;
                    @Nullable
                    private List<SatModel> f2426k;
                    @Nullable
                    private String f2427l;
                    @Nullable
                    private List<SunModel> f2428m;
                    @Nullable
                    private String f2429n;
                    @Nullable
                    private List<ThuModel> f2430o;
                    @Nullable
                    private List<TueModel> f2431p;
                    @Nullable
                    private List<WedModel> f2432q;
                    @Nullable
                    private String f2433r;

                    /* compiled from: sync_params/ */
                    public final class Builder {
                        @Nullable
                        public GraphQLObjectType f2404a;
                        @Nullable
                        public CategoryModel f2405b;
                        @Nullable
                        public CityModel f2406c;
                        @Nullable
                        public ImmutableList<FriModel> f2407d;
                        @Nullable
                        public ImmutableList<MonModel> f2408e;
                        @Nullable
                        public ParentPlaceModel f2409f;
                        @Nullable
                        public PhotoModel f2410g;
                        @Nullable
                        public ImmutableList<SatModel> f2411h;
                        @Nullable
                        public String f2412i;
                        @Nullable
                        public ImmutableList<SunModel> f2413j;
                        @Nullable
                        public String f2414k;
                        @Nullable
                        public ImmutableList<ThuModel> f2415l;
                        @Nullable
                        public ImmutableList<TueModel> f2416m;
                        @Nullable
                        public ImmutableList<WedModel> f2417n;
                        @Nullable
                        public String f2418o;

                        public static Builder m2562a(NodeModel nodeModel) {
                            Builder builder = new Builder();
                            builder.f2404a = nodeModel.m2568a();
                            builder.f2405b = nodeModel.m2581q();
                            builder.f2406c = nodeModel.m2582r();
                            builder.f2407d = nodeModel.mo99d();
                            builder.f2408e = nodeModel.et_();
                            builder.f2409f = nodeModel.m2583s();
                            builder.f2410g = nodeModel.m2584t();
                            builder.f2411h = nodeModel.eu_();
                            builder.f2412i = nodeModel.m2574j();
                            builder.f2413j = nodeModel.mo102k();
                            builder.f2414k = nodeModel.m2576l();
                            builder.f2415l = nodeModel.mo103m();
                            builder.f2416m = nodeModel.mo104n();
                            builder.f2417n = nodeModel.mo105o();
                            builder.f2418o = nodeModel.m2580p();
                            return builder;
                        }

                        public final NodeModel m2563a() {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            int a = ModelHelper.a(flatBufferBuilder, this.f2404a);
                            int a2 = ModelHelper.a(flatBufferBuilder, this.f2405b);
                            int a3 = ModelHelper.a(flatBufferBuilder, this.f2406c);
                            int a4 = ModelHelper.a(flatBufferBuilder, this.f2407d);
                            int a5 = ModelHelper.a(flatBufferBuilder, this.f2408e);
                            int a6 = ModelHelper.a(flatBufferBuilder, this.f2409f);
                            int a7 = ModelHelper.a(flatBufferBuilder, this.f2410g);
                            int a8 = ModelHelper.a(flatBufferBuilder, this.f2411h);
                            int b = flatBufferBuilder.b(this.f2412i);
                            int a9 = ModelHelper.a(flatBufferBuilder, this.f2413j);
                            int b2 = flatBufferBuilder.b(this.f2414k);
                            int a10 = ModelHelper.a(flatBufferBuilder, this.f2415l);
                            int a11 = ModelHelper.a(flatBufferBuilder, this.f2416m);
                            int a12 = ModelHelper.a(flatBufferBuilder, this.f2417n);
                            int b3 = flatBufferBuilder.b(this.f2418o);
                            flatBufferBuilder.c(15);
                            flatBufferBuilder.b(0, a);
                            flatBufferBuilder.b(1, a2);
                            flatBufferBuilder.b(2, a3);
                            flatBufferBuilder.b(3, a4);
                            flatBufferBuilder.b(4, a5);
                            flatBufferBuilder.b(5, a6);
                            flatBufferBuilder.b(6, a7);
                            flatBufferBuilder.b(7, a8);
                            flatBufferBuilder.b(8, b);
                            flatBufferBuilder.b(9, a9);
                            flatBufferBuilder.b(10, b2);
                            flatBufferBuilder.b(11, a10);
                            flatBufferBuilder.b(12, a11);
                            flatBufferBuilder.b(13, a12);
                            flatBufferBuilder.b(14, b3);
                            flatBufferBuilder.d(flatBufferBuilder.d());
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            return new NodeModel(new MutableFlatBuffer(wrap, null, null, true, null));
                        }
                    }

                    /* compiled from: sync_params/ */
                    public class Deserializer extends FbJsonDeserializer {
                        static {
                            GlobalAutoGenDeserializerCache.a(NodeModel.class, new Deserializer());
                        }

                        public Object m2564a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(NodeParser.m2888a(jsonParser, flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            mutableFlatBuffer.a(4, Boolean.valueOf(true));
                            MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                            Object nodeModel = new NodeModel();
                            ((BaseModel) nodeModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                            if (nodeModel instanceof Postprocessable) {
                                return ((Postprocessable) nodeModel).a();
                            }
                            return nodeModel;
                        }
                    }

                    /* compiled from: sync_params/ */
                    public class Serializer extends JsonSerializer<NodeModel> {
                        public final void m2565a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                            NodeModel nodeModel = (NodeModel) obj;
                            if (nodeModel.w_() == null) {
                                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                flatBufferBuilder.d(nodeModel.m2567a(flatBufferBuilder));
                                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                wrap.position(0);
                                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                nodeModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                            }
                            NodeParser.m2889a(nodeModel.w_(), nodeModel.u_(), jsonGenerator, serializerProvider);
                        }

                        static {
                            FbSerializerProvider.a(NodeModel.class, new Serializer());
                        }
                    }

                    @Nullable
                    public final /* synthetic */ CategoryModel m2570b() {
                        return m2581q();
                    }

                    @Nullable
                    public final /* synthetic */ CityModel m2571c() {
                        return m2582r();
                    }

                    @Nullable
                    public final /* synthetic */ PhotoModel ev_() {
                        return m2584t();
                    }

                    @Nullable
                    public final /* synthetic */ ParentPlaceModel m2573g() {
                        return m2583s();
                    }

                    public NodeModel() {
                        super(15);
                    }

                    public NodeModel(MutableFlatBuffer mutableFlatBuffer) {
                        super(15);
                        a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }

                    @Nullable
                    public final GraphQLObjectType m2568a() {
                        if (this.b != null && this.f2419d == null) {
                            this.f2419d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
                        }
                        return this.f2419d;
                    }

                    @Nullable
                    public final CategoryModel m2581q() {
                        this.f2420e = (CategoryModel) super.a(this.f2420e, 1, CategoryModel.class);
                        return this.f2420e;
                    }

                    @Nullable
                    public final CityModel m2582r() {
                        this.f2421f = (CityModel) super.a(this.f2421f, 2, CityModel.class);
                        return this.f2421f;
                    }

                    @Nonnull
                    public final ImmutableList<FriModel> mo99d() {
                        this.f2422g = super.a(this.f2422g, 3, FriModel.class);
                        return (ImmutableList) this.f2422g;
                    }

                    @Nonnull
                    public final ImmutableList<MonModel> et_() {
                        this.f2423h = super.a(this.f2423h, 4, MonModel.class);
                        return (ImmutableList) this.f2423h;
                    }

                    @Nullable
                    public final ParentPlaceModel m2583s() {
                        this.f2424i = (ParentPlaceModel) super.a(this.f2424i, 5, ParentPlaceModel.class);
                        return this.f2424i;
                    }

                    @Nullable
                    public final PhotoModel m2584t() {
                        this.f2425j = (PhotoModel) super.a(this.f2425j, 6, PhotoModel.class);
                        return this.f2425j;
                    }

                    @Nonnull
                    public final ImmutableList<SatModel> eu_() {
                        this.f2426k = super.a(this.f2426k, 7, SatModel.class);
                        return (ImmutableList) this.f2426k;
                    }

                    @Nullable
                    public final String m2574j() {
                        this.f2427l = super.a(this.f2427l, 8);
                        return this.f2427l;
                    }

                    @Nonnull
                    public final ImmutableList<SunModel> mo102k() {
                        this.f2428m = super.a(this.f2428m, 9, SunModel.class);
                        return (ImmutableList) this.f2428m;
                    }

                    @Nullable
                    public final String m2576l() {
                        this.f2429n = super.a(this.f2429n, 10);
                        return this.f2429n;
                    }

                    @Nonnull
                    public final ImmutableList<ThuModel> mo103m() {
                        this.f2430o = super.a(this.f2430o, 11, ThuModel.class);
                        return (ImmutableList) this.f2430o;
                    }

                    @Nonnull
                    public final ImmutableList<TueModel> mo104n() {
                        this.f2431p = super.a(this.f2431p, 12, TueModel.class);
                        return (ImmutableList) this.f2431p;
                    }

                    @Nonnull
                    public final ImmutableList<WedModel> mo105o() {
                        this.f2432q = super.a(this.f2432q, 13, WedModel.class);
                        return (ImmutableList) this.f2432q;
                    }

                    @Nullable
                    public final String m2580p() {
                        this.f2433r = super.a(this.f2433r, 14);
                        return this.f2433r;
                    }

                    public static NodeModel m2566a(NodeModel nodeModel) {
                        int i = 0;
                        if (nodeModel == null) {
                            return null;
                        }
                        if (nodeModel instanceof NodeModel) {
                            return nodeModel;
                        }
                        int i2;
                        Builder builder = new Builder();
                        builder.f2404a = nodeModel.m2568a();
                        builder.f2405b = CategoryModel.m2544a(nodeModel.m2570b());
                        builder.f2406c = CityModel.m2524a(nodeModel.m2571c());
                        com.google.common.collect.ImmutableList.Builder builder2 = ImmutableList.builder();
                        for (i2 = 0; i2 < nodeModel.mo99d().size(); i2++) {
                            builder2.c(FriModel.m2609a((FriModel) nodeModel.mo99d().get(i2)));
                        }
                        builder.f2407d = builder2.b();
                        builder2 = ImmutableList.builder();
                        for (i2 = 0; i2 < nodeModel.et_().size(); i2++) {
                            builder2.c(MonModel.m2620a((MonModel) nodeModel.et_().get(i2)));
                        }
                        builder.f2408e = builder2.b();
                        builder.f2409f = ParentPlaceModel.m2692a(nodeModel.m2573g());
                        builder.f2410g = PhotoModel.m2715a(nodeModel.ev_());
                        builder2 = ImmutableList.builder();
                        for (i2 = 0; i2 < nodeModel.eu_().size(); i2++) {
                            builder2.c(SatModel.m2631a((SatModel) nodeModel.eu_().get(i2)));
                        }
                        builder.f2411h = builder2.b();
                        builder.f2412i = nodeModel.m2574j();
                        builder2 = ImmutableList.builder();
                        for (i2 = 0; i2 < nodeModel.mo102k().size(); i2++) {
                            builder2.c(SunModel.m2643a((SunModel) nodeModel.mo102k().get(i2)));
                        }
                        builder.f2413j = builder2.b();
                        builder.f2414k = nodeModel.m2576l();
                        builder2 = ImmutableList.builder();
                        for (i2 = 0; i2 < nodeModel.mo103m().size(); i2++) {
                            builder2.c(ThuModel.m2654a((ThuModel) nodeModel.mo103m().get(i2)));
                        }
                        builder.f2415l = builder2.b();
                        builder2 = ImmutableList.builder();
                        for (i2 = 0; i2 < nodeModel.mo104n().size(); i2++) {
                            builder2.c(TueModel.m2665a((TueModel) nodeModel.mo104n().get(i2)));
                        }
                        builder.f2416m = builder2.b();
                        com.google.common.collect.ImmutableList.Builder builder3 = ImmutableList.builder();
                        while (i < nodeModel.mo105o().size()) {
                            builder3.c(WedModel.m2676a((WedModel) nodeModel.mo105o().get(i)));
                            i++;
                        }
                        builder.f2417n = builder3.b();
                        builder.f2418o = nodeModel.m2580p();
                        return builder.m2563a();
                    }

                    public final int jK_() {
                        return 424485973;
                    }

                    public final GraphQLVisitableModel m2569a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                        com.google.common.collect.ImmutableList.Builder a;
                        GraphQLVisitableModel graphQLVisitableModel = null;
                        h();
                        if (m2581q() != null) {
                            CategoryModel categoryModel = (CategoryModel) graphQLModelMutatingVisitor.b(m2581q());
                            if (m2581q() != categoryModel) {
                                graphQLVisitableModel = (NodeModel) ModelHelper.a(null, this);
                                graphQLVisitableModel.f2420e = categoryModel;
                            }
                        }
                        if (m2582r() != null) {
                            CityModel cityModel = (CityModel) graphQLModelMutatingVisitor.b(m2582r());
                            if (m2582r() != cityModel) {
                                graphQLVisitableModel = (NodeModel) ModelHelper.a(graphQLVisitableModel, this);
                                graphQLVisitableModel.f2421f = cityModel;
                            }
                        }
                        if (mo99d() != null) {
                            a = ModelHelper.a(mo99d(), graphQLModelMutatingVisitor);
                            if (a != null) {
                                NodeModel nodeModel = (NodeModel) ModelHelper.a(graphQLVisitableModel, this);
                                nodeModel.f2422g = a.b();
                                graphQLVisitableModel = nodeModel;
                            }
                        }
                        if (et_() != null) {
                            a = ModelHelper.a(et_(), graphQLModelMutatingVisitor);
                            if (a != null) {
                                nodeModel = (NodeModel) ModelHelper.a(graphQLVisitableModel, this);
                                nodeModel.f2423h = a.b();
                                graphQLVisitableModel = nodeModel;
                            }
                        }
                        if (m2583s() != null) {
                            ParentPlaceModel parentPlaceModel = (ParentPlaceModel) graphQLModelMutatingVisitor.b(m2583s());
                            if (m2583s() != parentPlaceModel) {
                                graphQLVisitableModel = (NodeModel) ModelHelper.a(graphQLVisitableModel, this);
                                graphQLVisitableModel.f2424i = parentPlaceModel;
                            }
                        }
                        if (m2584t() != null) {
                            PhotoModel photoModel = (PhotoModel) graphQLModelMutatingVisitor.b(m2584t());
                            if (m2584t() != photoModel) {
                                graphQLVisitableModel = (NodeModel) ModelHelper.a(graphQLVisitableModel, this);
                                graphQLVisitableModel.f2425j = photoModel;
                            }
                        }
                        if (eu_() != null) {
                            a = ModelHelper.a(eu_(), graphQLModelMutatingVisitor);
                            if (a != null) {
                                nodeModel = (NodeModel) ModelHelper.a(graphQLVisitableModel, this);
                                nodeModel.f2426k = a.b();
                                graphQLVisitableModel = nodeModel;
                            }
                        }
                        if (mo102k() != null) {
                            a = ModelHelper.a(mo102k(), graphQLModelMutatingVisitor);
                            if (a != null) {
                                nodeModel = (NodeModel) ModelHelper.a(graphQLVisitableModel, this);
                                nodeModel.f2428m = a.b();
                                graphQLVisitableModel = nodeModel;
                            }
                        }
                        if (mo103m() != null) {
                            a = ModelHelper.a(mo103m(), graphQLModelMutatingVisitor);
                            if (a != null) {
                                nodeModel = (NodeModel) ModelHelper.a(graphQLVisitableModel, this);
                                nodeModel.f2430o = a.b();
                                graphQLVisitableModel = nodeModel;
                            }
                        }
                        if (mo104n() != null) {
                            a = ModelHelper.a(mo104n(), graphQLModelMutatingVisitor);
                            if (a != null) {
                                nodeModel = (NodeModel) ModelHelper.a(graphQLVisitableModel, this);
                                nodeModel.f2431p = a.b();
                                graphQLVisitableModel = nodeModel;
                            }
                        }
                        if (mo105o() != null) {
                            a = ModelHelper.a(mo105o(), graphQLModelMutatingVisitor);
                            if (a != null) {
                                nodeModel = (NodeModel) ModelHelper.a(graphQLVisitableModel, this);
                                nodeModel.f2432q = a.b();
                                graphQLVisitableModel = nodeModel;
                            }
                        }
                        i();
                        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                    }

                    public final int m2567a(FlatBufferBuilder flatBufferBuilder) {
                        h();
                        int a = ModelHelper.a(flatBufferBuilder, m2568a());
                        int a2 = ModelHelper.a(flatBufferBuilder, m2581q());
                        int a3 = ModelHelper.a(flatBufferBuilder, m2582r());
                        int a4 = ModelHelper.a(flatBufferBuilder, mo99d());
                        int a5 = ModelHelper.a(flatBufferBuilder, et_());
                        int a6 = ModelHelper.a(flatBufferBuilder, m2583s());
                        int a7 = ModelHelper.a(flatBufferBuilder, m2584t());
                        int a8 = ModelHelper.a(flatBufferBuilder, eu_());
                        int b = flatBufferBuilder.b(m2574j());
                        int a9 = ModelHelper.a(flatBufferBuilder, mo102k());
                        int b2 = flatBufferBuilder.b(m2576l());
                        int a10 = ModelHelper.a(flatBufferBuilder, mo103m());
                        int a11 = ModelHelper.a(flatBufferBuilder, mo104n());
                        int a12 = ModelHelper.a(flatBufferBuilder, mo105o());
                        int b3 = flatBufferBuilder.b(m2580p());
                        flatBufferBuilder.c(15);
                        flatBufferBuilder.b(0, a);
                        flatBufferBuilder.b(1, a2);
                        flatBufferBuilder.b(2, a3);
                        flatBufferBuilder.b(3, a4);
                        flatBufferBuilder.b(4, a5);
                        flatBufferBuilder.b(5, a6);
                        flatBufferBuilder.b(6, a7);
                        flatBufferBuilder.b(7, a8);
                        flatBufferBuilder.b(8, b);
                        flatBufferBuilder.b(9, a9);
                        flatBufferBuilder.b(10, b2);
                        flatBufferBuilder.b(11, a10);
                        flatBufferBuilder.b(12, a11);
                        flatBufferBuilder.b(13, a12);
                        flatBufferBuilder.b(14, b3);
                        i();
                        return flatBufferBuilder.d();
                    }
                }

                /* compiled from: sync_params/ */
                public class Serializer extends JsonSerializer<EdgesModel> {
                    public final void m2585a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        EdgesModel edgesModel = (EdgesModel) obj;
                        if (edgesModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(edgesModel.m2587a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            edgesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        EdgesParser.m2891b(edgesModel.w_(), edgesModel.u_(), jsonGenerator, serializerProvider);
                    }

                    static {
                        FbSerializerProvider.a(EdgesModel.class, new Serializer());
                    }
                }

                @Nullable
                public final /* synthetic */ NodeModel m2588a() {
                    return m2590j();
                }

                public EdgesModel() {
                    super(1);
                }

                public EdgesModel(MutableFlatBuffer mutableFlatBuffer) {
                    super(1);
                    a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }

                @Nullable
                public final NodeModel m2590j() {
                    this.f2434d = (NodeModel) super.a(this.f2434d, 0, NodeModel.class);
                    return this.f2434d;
                }

                public static EdgesModel m2586a(EdgesModel edgesModel) {
                    if (edgesModel == null) {
                        return null;
                    }
                    if (edgesModel instanceof EdgesModel) {
                        return edgesModel;
                    }
                    Builder builder = new Builder();
                    builder.f2403a = NodeModel.m2566a(edgesModel.m2588a());
                    return builder.m2560a();
                }

                public final int jK_() {
                    return 895426863;
                }

                public final GraphQLVisitableModel m2589a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    GraphQLVisitableModel graphQLVisitableModel = null;
                    h();
                    if (m2590j() != null) {
                        NodeModel nodeModel = (NodeModel) graphQLModelMutatingVisitor.b(m2590j());
                        if (m2590j() != nodeModel) {
                            graphQLVisitableModel = (EdgesModel) ModelHelper.a(null, this);
                            graphQLVisitableModel.f2434d = nodeModel;
                        }
                    }
                    i();
                    return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                }

                public final int m2587a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int a = ModelHelper.a(flatBufferBuilder, m2590j());
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.b(0, a);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            /* compiled from: sync_params/ */
            public class Serializer extends JsonSerializer<UserValuesModel> {
                public final void m2591a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    UserValuesModel userValuesModel = (UserValuesModel) obj;
                    if (userValuesModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(userValuesModel.m2593a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        userValuesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    UserValuesParser.m2893a(userValuesModel.w_(), userValuesModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(UserValuesModel.class, new Serializer());
                }
            }

            public UserValuesModel() {
                super(1);
            }

            public UserValuesModel(MutableFlatBuffer mutableFlatBuffer) {
                super(1);
                a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
            }

            @Nonnull
            public final ImmutableList<EdgesModel> m2595a() {
                this.f2435d = super.a(this.f2435d, 0, EdgesModel.class);
                return (ImmutableList) this.f2435d;
            }

            public static UserValuesModel m2592a(UserValuesModel userValuesModel) {
                if (userValuesModel == null) {
                    return null;
                }
                if (userValuesModel instanceof UserValuesModel) {
                    return userValuesModel;
                }
                Builder builder = new Builder();
                com.google.common.collect.ImmutableList.Builder builder2 = ImmutableList.builder();
                for (int i = 0; i < userValuesModel.m2595a().size(); i++) {
                    builder2.c(EdgesModel.m2586a((EdgesModel) userValuesModel.m2595a().get(i)));
                }
                builder.f2402a = builder2.b();
                return builder.m2558a();
            }

            public final int jK_() {
                return -1314368304;
            }

            public final GraphQLVisitableModel m2594a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m2595a() != null) {
                    com.google.common.collect.ImmutableList.Builder a = ModelHelper.a(m2595a(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        graphQLVisitableModel = (UserValuesModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f2435d = a.b();
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m2593a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m2595a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, a);
                i();
                return flatBufferBuilder.d();
            }
        }

        @Nullable
        public final /* synthetic */ UserValuesModel m2601b() {
            return m2602j();
        }

        public CrowdsourcedFieldModel() {
            super(2);
        }

        public CrowdsourcedFieldModel(MutableFlatBuffer mutableFlatBuffer) {
            super(2);
            a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
        }

        public final boolean m2600a() {
            a(0, 0);
            return this.f2436d;
        }

        @Nullable
        public final UserValuesModel m2602j() {
            this.f2437e = (UserValuesModel) super.a(this.f2437e, 1, UserValuesModel.class);
            return this.f2437e;
        }

        public static CrowdsourcedFieldModel m2596a(CrowdsourcedFieldModel crowdsourcedFieldModel) {
            if (crowdsourcedFieldModel == null) {
                return null;
            }
            if (crowdsourcedFieldModel instanceof CrowdsourcedFieldModel) {
                return crowdsourcedFieldModel;
            }
            Builder builder = new Builder();
            builder.f2400a = crowdsourcedFieldModel.m2600a();
            builder.f2401b = UserValuesModel.m2592a(crowdsourcedFieldModel.m2601b());
            return builder.m2555a();
        }

        public final int jK_() {
            return 409940958;
        }

        public final GraphQLVisitableModel m2598a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m2602j() != null) {
                UserValuesModel userValuesModel = (UserValuesModel) graphQLModelMutatingVisitor.b(m2602j());
                if (m2602j() != userValuesModel) {
                    graphQLVisitableModel = (CrowdsourcedFieldModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f2437e = userValuesModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m2597a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m2602j());
            flatBufferBuilder.c(2);
            flatBufferBuilder.a(0, this.f2436d);
            flatBufferBuilder.b(1, a);
            i();
            return flatBufferBuilder.d();
        }

        public final void m2599a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
            super.a(mutableFlatBuffer, i, obj);
            this.f2436d = mutableFlatBuffer.a(i, 0);
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 1618802240)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: sync_params/ */
    public final class CrowdsourcedHoursModel extends BaseModel implements CrowdsourcedHours, GraphQLVisitableModel {
        @Nullable
        private List<FriModel> f2466d;
        @Nullable
        private List<MonModel> f2467e;
        @Nullable
        private List<SatModel> f2468f;
        @Nullable
        private List<SunModel> f2469g;
        @Nullable
        private List<ThuModel> f2470h;
        @Nullable
        private List<TueModel> f2471i;
        @Nullable
        private List<WedModel> f2472j;

        /* compiled from: sync_params/ */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(CrowdsourcedHoursModel.class, new Deserializer());
            }

            public Object m2603a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = CrowdsourcedHoursParser.m2924a(jsonParser);
                Object crowdsourcedHoursModel = new CrowdsourcedHoursModel();
                ((BaseModel) crowdsourcedHoursModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (crowdsourcedHoursModel instanceof Postprocessable) {
                    return ((Postprocessable) crowdsourcedHoursModel).a();
                }
                return crowdsourcedHoursModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 1244528557)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: sync_params/ */
        public final class FriModel extends BaseModel implements GraphQLVisitableModel {
            private long f2440d;
            private long f2441e;

            /* compiled from: sync_params/ */
            public final class Builder {
                public long f2438a;
                public long f2439b;

                public final Builder m2604a(long j) {
                    this.f2438a = j;
                    return this;
                }

                public final Builder m2606b(long j) {
                    this.f2439b = j;
                    return this;
                }

                public final FriModel m2605a() {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.c(2);
                    flatBufferBuilder.a(0, this.f2438a, 0);
                    flatBufferBuilder.a(1, this.f2439b, 0);
                    flatBufferBuilder.d(flatBufferBuilder.d());
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    return new FriModel(new MutableFlatBuffer(wrap, null, null, true, null));
                }
            }

            /* compiled from: sync_params/ */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(FriModel.class, new Deserializer());
                }

                public Object m2607a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(FriParser.m2899b(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object friModel = new FriModel();
                    ((BaseModel) friModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (friModel instanceof Postprocessable) {
                        return ((Postprocessable) friModel).a();
                    }
                    return friModel;
                }
            }

            /* compiled from: sync_params/ */
            public class Serializer extends JsonSerializer<FriModel> {
                public final void m2608a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    FriModel friModel = (FriModel) obj;
                    if (friModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(friModel.m2610a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        friModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    FriParser.m2897a(friModel.w_(), friModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(FriModel.class, new Serializer());
                }
            }

            public FriModel() {
                super(2);
            }

            public FriModel(MutableFlatBuffer mutableFlatBuffer) {
                super(2);
                a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
            }

            public final long m2611a() {
                a(0, 0);
                return this.f2440d;
            }

            public final long m2614b() {
                a(0, 1);
                return this.f2441e;
            }

            public static FriModel m2609a(FriModel friModel) {
                if (friModel == null) {
                    return null;
                }
                if (friModel instanceof FriModel) {
                    return friModel;
                }
                Builder builder = new Builder();
                builder.f2438a = friModel.m2611a();
                builder.f2439b = friModel.m2614b();
                return builder.m2605a();
            }

            public final int jK_() {
                return 2028064336;
            }

            public final GraphQLVisitableModel m2612a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m2610a(FlatBufferBuilder flatBufferBuilder) {
                h();
                flatBufferBuilder.c(2);
                flatBufferBuilder.a(0, this.f2440d, 0);
                flatBufferBuilder.a(1, this.f2441e, 0);
                i();
                return flatBufferBuilder.d();
            }

            public final void m2613a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                super.a(mutableFlatBuffer, i, obj);
                this.f2440d = mutableFlatBuffer.a(i, 0, 0);
                this.f2441e = mutableFlatBuffer.a(i, 1, 0);
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 1244528557)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: sync_params/ */
        public final class MonModel extends BaseModel implements GraphQLVisitableModel {
            private long f2444d;
            private long f2445e;

            /* compiled from: sync_params/ */
            public final class Builder {
                public long f2442a;
                public long f2443b;

                public final Builder m2615a(long j) {
                    this.f2442a = j;
                    return this;
                }

                public final Builder m2617b(long j) {
                    this.f2443b = j;
                    return this;
                }

                public final MonModel m2616a() {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.c(2);
                    flatBufferBuilder.a(0, this.f2442a, 0);
                    flatBufferBuilder.a(1, this.f2443b, 0);
                    flatBufferBuilder.d(flatBufferBuilder.d());
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    return new MonModel(new MutableFlatBuffer(wrap, null, null, true, null));
                }
            }

            /* compiled from: sync_params/ */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(MonModel.class, new Deserializer());
                }

                public Object m2618a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(MonParser.m2903b(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object monModel = new MonModel();
                    ((BaseModel) monModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (monModel instanceof Postprocessable) {
                        return ((Postprocessable) monModel).a();
                    }
                    return monModel;
                }
            }

            /* compiled from: sync_params/ */
            public class Serializer extends JsonSerializer<MonModel> {
                public final void m2619a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    MonModel monModel = (MonModel) obj;
                    if (monModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(monModel.m2621a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        monModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    MonParser.m2901a(monModel.w_(), monModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(MonModel.class, new Serializer());
                }
            }

            public MonModel() {
                super(2);
            }

            public MonModel(MutableFlatBuffer mutableFlatBuffer) {
                super(2);
                a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
            }

            public final long m2622a() {
                a(0, 0);
                return this.f2444d;
            }

            public final long m2625b() {
                a(0, 1);
                return this.f2445e;
            }

            public static MonModel m2620a(MonModel monModel) {
                if (monModel == null) {
                    return null;
                }
                if (monModel instanceof MonModel) {
                    return monModel;
                }
                Builder builder = new Builder();
                builder.f2442a = monModel.m2622a();
                builder.f2443b = monModel.m2625b();
                return builder.m2616a();
            }

            public final int jK_() {
                return 2028064336;
            }

            public final GraphQLVisitableModel m2623a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m2621a(FlatBufferBuilder flatBufferBuilder) {
                h();
                flatBufferBuilder.c(2);
                flatBufferBuilder.a(0, this.f2444d, 0);
                flatBufferBuilder.a(1, this.f2445e, 0);
                i();
                return flatBufferBuilder.d();
            }

            public final void m2624a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                super.a(mutableFlatBuffer, i, obj);
                this.f2444d = mutableFlatBuffer.a(i, 0, 0);
                this.f2445e = mutableFlatBuffer.a(i, 1, 0);
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 1244528557)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: sync_params/ */
        public final class SatModel extends BaseModel implements GraphQLVisitableModel {
            private long f2448d;
            private long f2449e;

            /* compiled from: sync_params/ */
            public final class Builder {
                public long f2446a;
                public long f2447b;

                public final Builder m2626a(long j) {
                    this.f2446a = j;
                    return this;
                }

                public final Builder m2628b(long j) {
                    this.f2447b = j;
                    return this;
                }

                public final SatModel m2627a() {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.c(2);
                    flatBufferBuilder.a(0, this.f2446a, 0);
                    flatBufferBuilder.a(1, this.f2447b, 0);
                    flatBufferBuilder.d(flatBufferBuilder.d());
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    return new SatModel(new MutableFlatBuffer(wrap, null, null, true, null));
                }
            }

            /* compiled from: sync_params/ */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(SatModel.class, new Deserializer());
                }

                public Object m2629a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(SatParser.m2907b(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object satModel = new SatModel();
                    ((BaseModel) satModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (satModel instanceof Postprocessable) {
                        return ((Postprocessable) satModel).a();
                    }
                    return satModel;
                }
            }

            /* compiled from: sync_params/ */
            public class Serializer extends JsonSerializer<SatModel> {
                public final void m2630a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    SatModel satModel = (SatModel) obj;
                    if (satModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(satModel.m2632a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        satModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    SatParser.m2905a(satModel.w_(), satModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(SatModel.class, new Serializer());
                }
            }

            public SatModel() {
                super(2);
            }

            public SatModel(MutableFlatBuffer mutableFlatBuffer) {
                super(2);
                a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
            }

            public final long m2633a() {
                a(0, 0);
                return this.f2448d;
            }

            public final long m2636b() {
                a(0, 1);
                return this.f2449e;
            }

            public static SatModel m2631a(SatModel satModel) {
                if (satModel == null) {
                    return null;
                }
                if (satModel instanceof SatModel) {
                    return satModel;
                }
                Builder builder = new Builder();
                builder.f2446a = satModel.m2633a();
                builder.f2447b = satModel.m2636b();
                return builder.m2627a();
            }

            public final int jK_() {
                return 2028064336;
            }

            public final GraphQLVisitableModel m2634a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m2632a(FlatBufferBuilder flatBufferBuilder) {
                h();
                flatBufferBuilder.c(2);
                flatBufferBuilder.a(0, this.f2448d, 0);
                flatBufferBuilder.a(1, this.f2449e, 0);
                i();
                return flatBufferBuilder.d();
            }

            public final void m2635a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                super.a(mutableFlatBuffer, i, obj);
                this.f2448d = mutableFlatBuffer.a(i, 0, 0);
                this.f2449e = mutableFlatBuffer.a(i, 1, 0);
            }
        }

        /* compiled from: sync_params/ */
        public class Serializer extends JsonSerializer<CrowdsourcedHoursModel> {
            public final void m2637a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                CrowdsourcedHoursModel crowdsourcedHoursModel = (CrowdsourcedHoursModel) obj;
                if (crowdsourcedHoursModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(crowdsourcedHoursModel.m2682a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    crowdsourcedHoursModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = crowdsourcedHoursModel.w_();
                int u_ = crowdsourcedHoursModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("fri");
                    FriParser.m2898a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                g = mutableFlatBuffer.g(u_, 1);
                if (g != 0) {
                    jsonGenerator.a("mon");
                    MonParser.m2902a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                g = mutableFlatBuffer.g(u_, 2);
                if (g != 0) {
                    jsonGenerator.a("sat");
                    SatParser.m2906a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                g = mutableFlatBuffer.g(u_, 3);
                if (g != 0) {
                    jsonGenerator.a("sun");
                    SunParser.m2910a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                g = mutableFlatBuffer.g(u_, 4);
                if (g != 0) {
                    jsonGenerator.a("thu");
                    ThuParser.m2914a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                g = mutableFlatBuffer.g(u_, 5);
                if (g != 0) {
                    jsonGenerator.a("tue");
                    TueParser.m2918a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                g = mutableFlatBuffer.g(u_, 6);
                if (g != 0) {
                    jsonGenerator.a("wed");
                    WedParser.m2922a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(CrowdsourcedHoursModel.class, new Serializer());
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 1244528557)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: sync_params/ */
        public final class SunModel extends BaseModel implements GraphQLVisitableModel {
            private long f2452d;
            private long f2453e;

            /* compiled from: sync_params/ */
            public final class Builder {
                public long f2450a;
                public long f2451b;

                public final Builder m2638a(long j) {
                    this.f2450a = j;
                    return this;
                }

                public final Builder m2640b(long j) {
                    this.f2451b = j;
                    return this;
                }

                public final SunModel m2639a() {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.c(2);
                    flatBufferBuilder.a(0, this.f2450a, 0);
                    flatBufferBuilder.a(1, this.f2451b, 0);
                    flatBufferBuilder.d(flatBufferBuilder.d());
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    return new SunModel(new MutableFlatBuffer(wrap, null, null, true, null));
                }
            }

            /* compiled from: sync_params/ */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(SunModel.class, new Deserializer());
                }

                public Object m2641a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(SunParser.m2911b(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object sunModel = new SunModel();
                    ((BaseModel) sunModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (sunModel instanceof Postprocessable) {
                        return ((Postprocessable) sunModel).a();
                    }
                    return sunModel;
                }
            }

            /* compiled from: sync_params/ */
            public class Serializer extends JsonSerializer<SunModel> {
                public final void m2642a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    SunModel sunModel = (SunModel) obj;
                    if (sunModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(sunModel.m2644a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        sunModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    SunParser.m2909a(sunModel.w_(), sunModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(SunModel.class, new Serializer());
                }
            }

            public SunModel() {
                super(2);
            }

            public SunModel(MutableFlatBuffer mutableFlatBuffer) {
                super(2);
                a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
            }

            public final long m2645a() {
                a(0, 0);
                return this.f2452d;
            }

            public final long m2648b() {
                a(0, 1);
                return this.f2453e;
            }

            public static SunModel m2643a(SunModel sunModel) {
                if (sunModel == null) {
                    return null;
                }
                if (sunModel instanceof SunModel) {
                    return sunModel;
                }
                Builder builder = new Builder();
                builder.f2450a = sunModel.m2645a();
                builder.f2451b = sunModel.m2648b();
                return builder.m2639a();
            }

            public final int jK_() {
                return 2028064336;
            }

            public final GraphQLVisitableModel m2646a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m2644a(FlatBufferBuilder flatBufferBuilder) {
                h();
                flatBufferBuilder.c(2);
                flatBufferBuilder.a(0, this.f2452d, 0);
                flatBufferBuilder.a(1, this.f2453e, 0);
                i();
                return flatBufferBuilder.d();
            }

            public final void m2647a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                super.a(mutableFlatBuffer, i, obj);
                this.f2452d = mutableFlatBuffer.a(i, 0, 0);
                this.f2453e = mutableFlatBuffer.a(i, 1, 0);
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 1244528557)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: sync_params/ */
        public final class ThuModel extends BaseModel implements GraphQLVisitableModel {
            private long f2456d;
            private long f2457e;

            /* compiled from: sync_params/ */
            public final class Builder {
                public long f2454a;
                public long f2455b;

                public final Builder m2649a(long j) {
                    this.f2454a = j;
                    return this;
                }

                public final Builder m2651b(long j) {
                    this.f2455b = j;
                    return this;
                }

                public final ThuModel m2650a() {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.c(2);
                    flatBufferBuilder.a(0, this.f2454a, 0);
                    flatBufferBuilder.a(1, this.f2455b, 0);
                    flatBufferBuilder.d(flatBufferBuilder.d());
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    return new ThuModel(new MutableFlatBuffer(wrap, null, null, true, null));
                }
            }

            /* compiled from: sync_params/ */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(ThuModel.class, new Deserializer());
                }

                public Object m2652a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(ThuParser.m2915b(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object thuModel = new ThuModel();
                    ((BaseModel) thuModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (thuModel instanceof Postprocessable) {
                        return ((Postprocessable) thuModel).a();
                    }
                    return thuModel;
                }
            }

            /* compiled from: sync_params/ */
            public class Serializer extends JsonSerializer<ThuModel> {
                public final void m2653a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    ThuModel thuModel = (ThuModel) obj;
                    if (thuModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(thuModel.m2655a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        thuModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    ThuParser.m2913a(thuModel.w_(), thuModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(ThuModel.class, new Serializer());
                }
            }

            public ThuModel() {
                super(2);
            }

            public ThuModel(MutableFlatBuffer mutableFlatBuffer) {
                super(2);
                a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
            }

            public final long m2656a() {
                a(0, 0);
                return this.f2456d;
            }

            public final long m2659b() {
                a(0, 1);
                return this.f2457e;
            }

            public static ThuModel m2654a(ThuModel thuModel) {
                if (thuModel == null) {
                    return null;
                }
                if (thuModel instanceof ThuModel) {
                    return thuModel;
                }
                Builder builder = new Builder();
                builder.f2454a = thuModel.m2656a();
                builder.f2455b = thuModel.m2659b();
                return builder.m2650a();
            }

            public final int jK_() {
                return 2028064336;
            }

            public final GraphQLVisitableModel m2657a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m2655a(FlatBufferBuilder flatBufferBuilder) {
                h();
                flatBufferBuilder.c(2);
                flatBufferBuilder.a(0, this.f2456d, 0);
                flatBufferBuilder.a(1, this.f2457e, 0);
                i();
                return flatBufferBuilder.d();
            }

            public final void m2658a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                super.a(mutableFlatBuffer, i, obj);
                this.f2456d = mutableFlatBuffer.a(i, 0, 0);
                this.f2457e = mutableFlatBuffer.a(i, 1, 0);
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 1244528557)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: sync_params/ */
        public final class TueModel extends BaseModel implements GraphQLVisitableModel {
            private long f2460d;
            private long f2461e;

            /* compiled from: sync_params/ */
            public final class Builder {
                public long f2458a;
                public long f2459b;

                public final Builder m2660a(long j) {
                    this.f2458a = j;
                    return this;
                }

                public final Builder m2662b(long j) {
                    this.f2459b = j;
                    return this;
                }

                public final TueModel m2661a() {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.c(2);
                    flatBufferBuilder.a(0, this.f2458a, 0);
                    flatBufferBuilder.a(1, this.f2459b, 0);
                    flatBufferBuilder.d(flatBufferBuilder.d());
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    return new TueModel(new MutableFlatBuffer(wrap, null, null, true, null));
                }
            }

            /* compiled from: sync_params/ */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(TueModel.class, new Deserializer());
                }

                public Object m2663a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(TueParser.m2919b(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object tueModel = new TueModel();
                    ((BaseModel) tueModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (tueModel instanceof Postprocessable) {
                        return ((Postprocessable) tueModel).a();
                    }
                    return tueModel;
                }
            }

            /* compiled from: sync_params/ */
            public class Serializer extends JsonSerializer<TueModel> {
                public final void m2664a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    TueModel tueModel = (TueModel) obj;
                    if (tueModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(tueModel.m2666a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        tueModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    TueParser.m2917a(tueModel.w_(), tueModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(TueModel.class, new Serializer());
                }
            }

            public TueModel() {
                super(2);
            }

            public TueModel(MutableFlatBuffer mutableFlatBuffer) {
                super(2);
                a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
            }

            public final long m2667a() {
                a(0, 0);
                return this.f2460d;
            }

            public final long m2670b() {
                a(0, 1);
                return this.f2461e;
            }

            public static TueModel m2665a(TueModel tueModel) {
                if (tueModel == null) {
                    return null;
                }
                if (tueModel instanceof TueModel) {
                    return tueModel;
                }
                Builder builder = new Builder();
                builder.f2458a = tueModel.m2667a();
                builder.f2459b = tueModel.m2670b();
                return builder.m2661a();
            }

            public final int jK_() {
                return 2028064336;
            }

            public final GraphQLVisitableModel m2668a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m2666a(FlatBufferBuilder flatBufferBuilder) {
                h();
                flatBufferBuilder.c(2);
                flatBufferBuilder.a(0, this.f2460d, 0);
                flatBufferBuilder.a(1, this.f2461e, 0);
                i();
                return flatBufferBuilder.d();
            }

            public final void m2669a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                super.a(mutableFlatBuffer, i, obj);
                this.f2460d = mutableFlatBuffer.a(i, 0, 0);
                this.f2461e = mutableFlatBuffer.a(i, 1, 0);
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 1244528557)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: sync_params/ */
        public final class WedModel extends BaseModel implements GraphQLVisitableModel {
            private long f2464d;
            private long f2465e;

            /* compiled from: sync_params/ */
            public final class Builder {
                public long f2462a;
                public long f2463b;

                public final Builder m2671a(long j) {
                    this.f2462a = j;
                    return this;
                }

                public final Builder m2673b(long j) {
                    this.f2463b = j;
                    return this;
                }

                public final WedModel m2672a() {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.c(2);
                    flatBufferBuilder.a(0, this.f2462a, 0);
                    flatBufferBuilder.a(1, this.f2463b, 0);
                    flatBufferBuilder.d(flatBufferBuilder.d());
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    return new WedModel(new MutableFlatBuffer(wrap, null, null, true, null));
                }
            }

            /* compiled from: sync_params/ */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(WedModel.class, new Deserializer());
                }

                public Object m2674a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(WedParser.m2923b(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object wedModel = new WedModel();
                    ((BaseModel) wedModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (wedModel instanceof Postprocessable) {
                        return ((Postprocessable) wedModel).a();
                    }
                    return wedModel;
                }
            }

            /* compiled from: sync_params/ */
            public class Serializer extends JsonSerializer<WedModel> {
                public final void m2675a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    WedModel wedModel = (WedModel) obj;
                    if (wedModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(wedModel.m2677a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        wedModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    WedParser.m2921a(wedModel.w_(), wedModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(WedModel.class, new Serializer());
                }
            }

            public WedModel() {
                super(2);
            }

            public WedModel(MutableFlatBuffer mutableFlatBuffer) {
                super(2);
                a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
            }

            public final long m2678a() {
                a(0, 0);
                return this.f2464d;
            }

            public final long m2681b() {
                a(0, 1);
                return this.f2465e;
            }

            public static WedModel m2676a(WedModel wedModel) {
                if (wedModel == null) {
                    return null;
                }
                if (wedModel instanceof WedModel) {
                    return wedModel;
                }
                Builder builder = new Builder();
                builder.f2462a = wedModel.m2678a();
                builder.f2463b = wedModel.m2681b();
                return builder.m2672a();
            }

            public final int jK_() {
                return 2028064336;
            }

            public final GraphQLVisitableModel m2679a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m2677a(FlatBufferBuilder flatBufferBuilder) {
                h();
                flatBufferBuilder.c(2);
                flatBufferBuilder.a(0, this.f2464d, 0);
                flatBufferBuilder.a(1, this.f2465e, 0);
                i();
                return flatBufferBuilder.d();
            }

            public final void m2680a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                super.a(mutableFlatBuffer, i, obj);
                this.f2464d = mutableFlatBuffer.a(i, 0, 0);
                this.f2465e = mutableFlatBuffer.a(i, 1, 0);
            }
        }

        public CrowdsourcedHoursModel() {
            super(7);
        }

        @Nonnull
        public final ImmutableList<FriModel> mo99d() {
            this.f2466d = super.a(this.f2466d, 0, FriModel.class);
            return (ImmutableList) this.f2466d;
        }

        @Nonnull
        public final ImmutableList<MonModel> et_() {
            this.f2467e = super.a(this.f2467e, 1, MonModel.class);
            return (ImmutableList) this.f2467e;
        }

        @Nonnull
        public final ImmutableList<SatModel> eu_() {
            this.f2468f = super.a(this.f2468f, 2, SatModel.class);
            return (ImmutableList) this.f2468f;
        }

        @Nonnull
        public final ImmutableList<SunModel> mo102k() {
            this.f2469g = super.a(this.f2469g, 3, SunModel.class);
            return (ImmutableList) this.f2469g;
        }

        @Nonnull
        public final ImmutableList<ThuModel> mo103m() {
            this.f2470h = super.a(this.f2470h, 4, ThuModel.class);
            return (ImmutableList) this.f2470h;
        }

        @Nonnull
        public final ImmutableList<TueModel> mo104n() {
            this.f2471i = super.a(this.f2471i, 5, TueModel.class);
            return (ImmutableList) this.f2471i;
        }

        @Nonnull
        public final ImmutableList<WedModel> mo105o() {
            this.f2472j = super.a(this.f2472j, 6, WedModel.class);
            return (ImmutableList) this.f2472j;
        }

        public final int jK_() {
            return 685450724;
        }

        public final GraphQLVisitableModel m2683a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            Builder a;
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (mo99d() != null) {
                a = ModelHelper.a(mo99d(), graphQLModelMutatingVisitor);
                if (a != null) {
                    graphQLVisitableModel = (CrowdsourcedHoursModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f2466d = a.b();
                }
            }
            if (et_() != null) {
                a = ModelHelper.a(et_(), graphQLModelMutatingVisitor);
                if (a != null) {
                    graphQLVisitableModel = (CrowdsourcedHoursModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f2467e = a.b();
                }
            }
            if (eu_() != null) {
                a = ModelHelper.a(eu_(), graphQLModelMutatingVisitor);
                if (a != null) {
                    graphQLVisitableModel = (CrowdsourcedHoursModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f2468f = a.b();
                }
            }
            if (mo102k() != null) {
                a = ModelHelper.a(mo102k(), graphQLModelMutatingVisitor);
                if (a != null) {
                    graphQLVisitableModel = (CrowdsourcedHoursModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f2469g = a.b();
                }
            }
            if (mo103m() != null) {
                a = ModelHelper.a(mo103m(), graphQLModelMutatingVisitor);
                if (a != null) {
                    graphQLVisitableModel = (CrowdsourcedHoursModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f2470h = a.b();
                }
            }
            if (mo104n() != null) {
                a = ModelHelper.a(mo104n(), graphQLModelMutatingVisitor);
                if (a != null) {
                    graphQLVisitableModel = (CrowdsourcedHoursModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f2471i = a.b();
                }
            }
            if (mo105o() != null) {
                a = ModelHelper.a(mo105o(), graphQLModelMutatingVisitor);
                if (a != null) {
                    graphQLVisitableModel = (CrowdsourcedHoursModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f2472j = a.b();
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m2682a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, mo99d());
            int a2 = ModelHelper.a(flatBufferBuilder, et_());
            int a3 = ModelHelper.a(flatBufferBuilder, eu_());
            int a4 = ModelHelper.a(flatBufferBuilder, mo102k());
            int a5 = ModelHelper.a(flatBufferBuilder, mo103m());
            int a6 = ModelHelper.a(flatBufferBuilder, mo104n());
            int a7 = ModelHelper.a(flatBufferBuilder, mo105o());
            flatBufferBuilder.c(7);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, a2);
            flatBufferBuilder.b(2, a3);
            flatBufferBuilder.b(3, a4);
            flatBufferBuilder.b(4, a5);
            flatBufferBuilder.b(5, a6);
            flatBufferBuilder.b(6, a7);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -332946172)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: sync_params/ */
    public final class CrowdsourcedLocatedInModel extends BaseModel implements CrowdsourcedLocatedIn, GraphQLVisitableModel {
        @Nullable
        private ParentPlaceModel f2477d;

        /* compiled from: sync_params/ */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(CrowdsourcedLocatedInModel.class, new Deserializer());
            }

            public Object m2689a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = CrowdsourcedLocatedInParser.m2927a(jsonParser);
                Object crowdsourcedLocatedInModel = new CrowdsourcedLocatedInModel();
                ((BaseModel) crowdsourcedLocatedInModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (crowdsourcedLocatedInModel instanceof Postprocessable) {
                    return ((Postprocessable) crowdsourcedLocatedInModel).a();
                }
                return crowdsourcedLocatedInModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1185712657)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: sync_params/ */
        public final class ParentPlaceModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
            @Nullable
            private String f2475d;
            @Nullable
            private String f2476e;

            /* compiled from: sync_params/ */
            public final class Builder {
                @Nullable
                public String f2473a;
                @Nullable
                public String f2474b;
            }

            /* compiled from: sync_params/ */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(ParentPlaceModel.class, new Deserializer());
                }

                public Object m2690a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(ParentPlaceParser.m2925a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object parentPlaceModel = new ParentPlaceModel();
                    ((BaseModel) parentPlaceModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (parentPlaceModel instanceof Postprocessable) {
                        return ((Postprocessable) parentPlaceModel).a();
                    }
                    return parentPlaceModel;
                }
            }

            /* compiled from: sync_params/ */
            public class Serializer extends JsonSerializer<ParentPlaceModel> {
                public final void m2691a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    ParentPlaceModel parentPlaceModel = (ParentPlaceModel) obj;
                    if (parentPlaceModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(parentPlaceModel.m2693a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        parentPlaceModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    ParentPlaceParser.m2926a(parentPlaceModel.w_(), parentPlaceModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(ParentPlaceModel.class, new Serializer());
                }
            }

            public ParentPlaceModel() {
                super(2);
            }

            public ParentPlaceModel(MutableFlatBuffer mutableFlatBuffer) {
                super(2);
                a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
            }

            public final void m2696a(String str, ConsistencyTuple consistencyTuple) {
                consistencyTuple.a();
            }

            public final void m2697a(String str, Object obj, boolean z) {
            }

            @Nullable
            public final String m2698b() {
                this.f2475d = super.a(this.f2475d, 0);
                return this.f2475d;
            }

            @Nullable
            public final String m2699c() {
                this.f2476e = super.a(this.f2476e, 1);
                return this.f2476e;
            }

            public static ParentPlaceModel m2692a(ParentPlaceModel parentPlaceModel) {
                if (parentPlaceModel == null) {
                    return null;
                }
                if (parentPlaceModel instanceof ParentPlaceModel) {
                    return parentPlaceModel;
                }
                Builder builder = new Builder();
                builder.f2473a = parentPlaceModel.m2698b();
                builder.f2474b = parentPlaceModel.m2699c();
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                int b = flatBufferBuilder.b(builder.f2473a);
                int b2 = flatBufferBuilder.b(builder.f2474b);
                flatBufferBuilder.c(2);
                flatBufferBuilder.b(0, b);
                flatBufferBuilder.b(1, b2);
                flatBufferBuilder.d(flatBufferBuilder.d());
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                return new ParentPlaceModel(new MutableFlatBuffer(wrap, null, null, true, null));
            }

            @Nullable
            public final String m2695a() {
                return m2698b();
            }

            public final int jK_() {
                return 2479791;
            }

            public final GraphQLVisitableModel m2694a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m2693a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m2698b());
                int b2 = flatBufferBuilder.b(m2699c());
                flatBufferBuilder.c(2);
                flatBufferBuilder.b(0, b);
                flatBufferBuilder.b(1, b2);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: sync_params/ */
        public class Serializer extends JsonSerializer<CrowdsourcedLocatedInModel> {
            public final void m2700a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                CrowdsourcedLocatedInModel crowdsourcedLocatedInModel = (CrowdsourcedLocatedInModel) obj;
                if (crowdsourcedLocatedInModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(crowdsourcedLocatedInModel.m2702a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    crowdsourcedLocatedInModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = crowdsourcedLocatedInModel.w_();
                int u_ = crowdsourcedLocatedInModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("parent_place");
                    ParentPlaceParser.m2926a(mutableFlatBuffer, g, jsonGenerator);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(CrowdsourcedLocatedInModel.class, new Serializer());
            }
        }

        public CrowdsourcedLocatedInModel() {
            super(1);
        }

        @Nullable
        private ParentPlaceModel m2701a() {
            this.f2477d = (ParentPlaceModel) super.a(this.f2477d, 0, ParentPlaceModel.class);
            return this.f2477d;
        }

        public final int jK_() {
            return -714455956;
        }

        public final GraphQLVisitableModel m2703a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m2701a() != null) {
                ParentPlaceModel parentPlaceModel = (ParentPlaceModel) graphQLModelMutatingVisitor.b(m2701a());
                if (m2701a() != parentPlaceModel) {
                    graphQLVisitableModel = (CrowdsourcedLocatedInModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f2477d = parentPlaceModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m2702a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m2701a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 695795658)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: sync_params/ */
    public final class CrowdsourcedPhotoModel extends BaseModel implements CrowdsourcedPhoto, GraphQLVisitableModel {
        @Nullable
        private PhotoModel f2482d;

        /* compiled from: sync_params/ */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(CrowdsourcedPhotoModel.class, new Deserializer());
            }

            public Object m2704a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = CrowdsourcedPhotoParser.m2932a(jsonParser);
                Object crowdsourcedPhotoModel = new CrowdsourcedPhotoModel();
                ((BaseModel) crowdsourcedPhotoModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (crowdsourcedPhotoModel instanceof Postprocessable) {
                    return ((Postprocessable) crowdsourcedPhotoModel).a();
                }
                return crowdsourcedPhotoModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 2080628399)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: sync_params/ */
        public final class PhotoModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private ImageModel f2481d;

            /* compiled from: sync_params/ */
            public final class Builder {
                @Nullable
                public ImageModel f2478a;

                public final PhotoModel m2705a() {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    int a = ModelHelper.a(flatBufferBuilder, this.f2478a);
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.b(0, a);
                    flatBufferBuilder.d(flatBufferBuilder.d());
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    return new PhotoModel(new MutableFlatBuffer(wrap, null, null, true, null));
                }
            }

            /* compiled from: sync_params/ */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(PhotoModel.class, new Deserializer());
                }

                public Object m2706a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(PhotoParser.m2930a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object photoModel = new PhotoModel();
                    ((BaseModel) photoModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (photoModel instanceof Postprocessable) {
                        return ((Postprocessable) photoModel).a();
                    }
                    return photoModel;
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = 842551240)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: sync_params/ */
            public final class ImageModel extends BaseModel implements GraphQLVisitableModel {
                @Nullable
                private String f2480d;

                /* compiled from: sync_params/ */
                public final class Builder {
                    @Nullable
                    public String f2479a;

                    public final ImageModel m2707a() {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        int b = flatBufferBuilder.b(this.f2479a);
                        flatBufferBuilder.c(1);
                        flatBufferBuilder.b(0, b);
                        flatBufferBuilder.d(flatBufferBuilder.d());
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        return new ImageModel(new MutableFlatBuffer(wrap, null, null, true, null));
                    }
                }

                /* compiled from: sync_params/ */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(ImageModel.class, new Deserializer());
                    }

                    public Object m2708a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(ImageParser.m2928a(jsonParser, flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                        Object imageModel = new ImageModel();
                        ((BaseModel) imageModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                        if (imageModel instanceof Postprocessable) {
                            return ((Postprocessable) imageModel).a();
                        }
                        return imageModel;
                    }
                }

                /* compiled from: sync_params/ */
                public class Serializer extends JsonSerializer<ImageModel> {
                    public final void m2709a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        ImageModel imageModel = (ImageModel) obj;
                        if (imageModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(imageModel.m2711a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            imageModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        ImageParser.m2929a(imageModel.w_(), imageModel.u_(), jsonGenerator);
                    }

                    static {
                        FbSerializerProvider.a(ImageModel.class, new Serializer());
                    }
                }

                public ImageModel() {
                    super(1);
                }

                public ImageModel(MutableFlatBuffer mutableFlatBuffer) {
                    super(1);
                    a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }

                @Nullable
                public final String m2713a() {
                    this.f2480d = super.a(this.f2480d, 0);
                    return this.f2480d;
                }

                public static ImageModel m2710a(ImageModel imageModel) {
                    if (imageModel == null) {
                        return null;
                    }
                    if (imageModel instanceof ImageModel) {
                        return imageModel;
                    }
                    Builder builder = new Builder();
                    builder.f2479a = imageModel.m2713a();
                    return builder.m2707a();
                }

                public final int jK_() {
                    return 70760763;
                }

                public final GraphQLVisitableModel m2712a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    h();
                    i();
                    return this;
                }

                public final int m2711a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int b = flatBufferBuilder.b(m2713a());
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.b(0, b);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            /* compiled from: sync_params/ */
            public class Serializer extends JsonSerializer<PhotoModel> {
                public final void m2714a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    PhotoModel photoModel = (PhotoModel) obj;
                    if (photoModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(photoModel.m2717a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        photoModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    PhotoParser.m2931a(photoModel.w_(), photoModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(PhotoModel.class, new Serializer());
                }
            }

            @Nullable
            public final /* synthetic */ ImageModel m2718a() {
                return m2716j();
            }

            public PhotoModel() {
                super(1);
            }

            public PhotoModel(MutableFlatBuffer mutableFlatBuffer) {
                super(1);
                a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
            }

            @Nullable
            private ImageModel m2716j() {
                this.f2481d = (ImageModel) super.a(this.f2481d, 0, ImageModel.class);
                return this.f2481d;
            }

            public static PhotoModel m2715a(PhotoModel photoModel) {
                if (photoModel == null) {
                    return null;
                }
                if (photoModel instanceof PhotoModel) {
                    return photoModel;
                }
                Builder builder = new Builder();
                builder.f2478a = ImageModel.m2710a(photoModel.m2718a());
                return builder.m2705a();
            }

            public final int jK_() {
                return 77090322;
            }

            public final GraphQLVisitableModel m2719a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m2716j() != null) {
                    ImageModel imageModel = (ImageModel) graphQLModelMutatingVisitor.b(m2716j());
                    if (m2716j() != imageModel) {
                        graphQLVisitableModel = (PhotoModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f2481d = imageModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m2717a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m2716j());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, a);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: sync_params/ */
        public class Serializer extends JsonSerializer<CrowdsourcedPhotoModel> {
            public final void m2720a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                CrowdsourcedPhotoModel crowdsourcedPhotoModel = (CrowdsourcedPhotoModel) obj;
                if (crowdsourcedPhotoModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(crowdsourcedPhotoModel.m2722a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    crowdsourcedPhotoModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = crowdsourcedPhotoModel.w_();
                int u_ = crowdsourcedPhotoModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("photo");
                    PhotoParser.m2931a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(CrowdsourcedPhotoModel.class, new Serializer());
            }
        }

        public CrowdsourcedPhotoModel() {
            super(1);
        }

        @Nullable
        private PhotoModel m2721a() {
            this.f2482d = (PhotoModel) super.a(this.f2482d, 0, PhotoModel.class);
            return this.f2482d;
        }

        public final int jK_() {
            return 208317895;
        }

        public final GraphQLVisitableModel m2723a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m2721a() != null) {
                PhotoModel photoModel = (PhotoModel) graphQLModelMutatingVisitor.b(m2721a());
                if (m2721a() != photoModel) {
                    graphQLVisitableModel = (CrowdsourcedPhotoModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f2482d = photoModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m2722a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m2721a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -879751157)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: sync_params/ */
    public final class SuggestEditsFieldModel extends BaseModel implements SuggestEditsField, GraphQLVisitableModel {
        @Nullable
        private String f2496d;
        @Nullable
        private String f2497e;
        @Nullable
        private CrowdsourcedFieldModel f2498f;
        @Nullable
        private String f2499g;
        @Nullable
        private OptionsModel f2500h;
        @Nullable
        private String f2501i;
        @Nullable
        private GraphQLSuggestEditsFieldOptionType f2502j;
        @Nullable
        private String f2503k;
        @Nullable
        private String f2504l;

        /* compiled from: sync_params/ */
        public final class Builder {
            @Nullable
            public String f2483a;
            @Nullable
            public String f2484b;
            @Nullable
            public CrowdsourcedFieldModel f2485c;
            @Nullable
            public String f2486d;
            @Nullable
            public OptionsModel f2487e;
            @Nullable
            public String f2488f;
            @Nullable
            public GraphQLSuggestEditsFieldOptionType f2489g;
            @Nullable
            public String f2490h;
            @Nullable
            public String f2491i;

            public static Builder m2724a(SuggestEditsFieldModel suggestEditsFieldModel) {
                Builder builder = new Builder();
                builder.f2483a = suggestEditsFieldModel.mo106a();
                builder.f2484b = suggestEditsFieldModel.mo107b();
                builder.f2485c = suggestEditsFieldModel.m2750k();
                builder.f2486d = suggestEditsFieldModel.mo109d();
                builder.f2487e = suggestEditsFieldModel.m2751l();
                builder.f2488f = suggestEditsFieldModel.mo113g();
                builder.f2489g = suggestEditsFieldModel.ew_();
                builder.f2490h = suggestEditsFieldModel.ex_();
                builder.f2491i = suggestEditsFieldModel.mo114j();
                return builder;
            }

            public final SuggestEditsFieldModel m2725a() {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                int b = flatBufferBuilder.b(this.f2483a);
                int b2 = flatBufferBuilder.b(this.f2484b);
                int a = ModelHelper.a(flatBufferBuilder, this.f2485c);
                int b3 = flatBufferBuilder.b(this.f2486d);
                int a2 = ModelHelper.a(flatBufferBuilder, this.f2487e);
                int b4 = flatBufferBuilder.b(this.f2488f);
                int a3 = flatBufferBuilder.a(this.f2489g);
                int b5 = flatBufferBuilder.b(this.f2490h);
                int b6 = flatBufferBuilder.b(this.f2491i);
                flatBufferBuilder.c(9);
                flatBufferBuilder.b(0, b);
                flatBufferBuilder.b(1, b2);
                flatBufferBuilder.b(2, a);
                flatBufferBuilder.b(3, b3);
                flatBufferBuilder.b(4, a2);
                flatBufferBuilder.b(5, b4);
                flatBufferBuilder.b(6, a3);
                flatBufferBuilder.b(7, b5);
                flatBufferBuilder.b(8, b6);
                flatBufferBuilder.d(flatBufferBuilder.d());
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                return new SuggestEditsFieldModel(new MutableFlatBuffer(wrap, null, null, true, null));
            }
        }

        /* compiled from: sync_params/ */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(SuggestEditsFieldModel.class, new Deserializer());
            }

            public Object m2726a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(SuggestEditsFieldParser.m2937a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object suggestEditsFieldModel = new SuggestEditsFieldModel();
                ((BaseModel) suggestEditsFieldModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (suggestEditsFieldModel instanceof Postprocessable) {
                    return ((Postprocessable) suggestEditsFieldModel).a();
                }
                return suggestEditsFieldModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -2020524422)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: sync_params/ */
        public final class OptionsModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private List<EdgesModel> f2495d;

            /* compiled from: sync_params/ */
            public final class Builder {
                @Nullable
                public ImmutableList<EdgesModel> f2492a;
            }

            /* compiled from: sync_params/ */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(OptionsModel.class, new Deserializer());
                }

                public Object m2727a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(OptionsParser.m2935a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object optionsModel = new OptionsModel();
                    ((BaseModel) optionsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (optionsModel instanceof Postprocessable) {
                        return ((Postprocessable) optionsModel).a();
                    }
                    return optionsModel;
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = -581353699)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: sync_params/ */
            public final class EdgesModel extends BaseModel implements GraphQLVisitableModel {
                @Nullable
                private SuggestEditsOptionModel f2494d;

                /* compiled from: sync_params/ */
                public final class Builder {
                    @Nullable
                    public SuggestEditsOptionModel f2493a;
                }

                /* compiled from: sync_params/ */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(EdgesModel.class, new Deserializer());
                    }

                    public Object m2728a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(OptionsParser.EdgesParser.m2933b(jsonParser, flatBufferBuilder));
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

                /* compiled from: sync_params/ */
                public class Serializer extends JsonSerializer<EdgesModel> {
                    public final void m2729a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        EdgesModel edgesModel = (EdgesModel) obj;
                        if (edgesModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(edgesModel.m2732a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            edgesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        OptionsParser.EdgesParser.m2934b(edgesModel.w_(), edgesModel.u_(), jsonGenerator, serializerProvider);
                    }

                    static {
                        FbSerializerProvider.a(EdgesModel.class, new Serializer());
                    }
                }

                @Nullable
                public final /* synthetic */ SuggestEditsOptionModel m2733a() {
                    return m2731j();
                }

                public EdgesModel() {
                    super(1);
                }

                public EdgesModel(MutableFlatBuffer mutableFlatBuffer) {
                    super(1);
                    a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }

                @Nullable
                private SuggestEditsOptionModel m2731j() {
                    this.f2494d = (SuggestEditsOptionModel) super.a(this.f2494d, 0, SuggestEditsOptionModel.class);
                    return this.f2494d;
                }

                public static EdgesModel m2730a(EdgesModel edgesModel) {
                    if (edgesModel == null) {
                        return null;
                    }
                    if (edgesModel instanceof EdgesModel) {
                        return edgesModel;
                    }
                    Builder builder = new Builder();
                    builder.f2493a = SuggestEditsOptionModel.m2829a(edgesModel.m2733a());
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    int a = ModelHelper.a(flatBufferBuilder, builder.f2493a);
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.b(0, a);
                    flatBufferBuilder.d(flatBufferBuilder.d());
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    return new EdgesModel(new MutableFlatBuffer(wrap, null, null, true, null));
                }

                public final int jK_() {
                    return 134882534;
                }

                public final GraphQLVisitableModel m2734a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    GraphQLVisitableModel graphQLVisitableModel = null;
                    h();
                    if (m2731j() != null) {
                        SuggestEditsOptionModel suggestEditsOptionModel = (SuggestEditsOptionModel) graphQLModelMutatingVisitor.b(m2731j());
                        if (m2731j() != suggestEditsOptionModel) {
                            graphQLVisitableModel = (EdgesModel) ModelHelper.a(null, this);
                            graphQLVisitableModel.f2494d = suggestEditsOptionModel;
                        }
                    }
                    i();
                    return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                }

                public final int m2732a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int a = ModelHelper.a(flatBufferBuilder, m2731j());
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.b(0, a);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            /* compiled from: sync_params/ */
            public class Serializer extends JsonSerializer<OptionsModel> {
                public final void m2735a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    OptionsModel optionsModel = (OptionsModel) obj;
                    if (optionsModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(optionsModel.m2737a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        optionsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    OptionsParser.m2936a(optionsModel.w_(), optionsModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(OptionsModel.class, new Serializer());
                }
            }

            public OptionsModel() {
                super(1);
            }

            public OptionsModel(MutableFlatBuffer mutableFlatBuffer) {
                super(1);
                a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
            }

            @Nonnull
            public final ImmutableList<EdgesModel> m2739a() {
                this.f2495d = super.a(this.f2495d, 0, EdgesModel.class);
                return (ImmutableList) this.f2495d;
            }

            public static OptionsModel m2736a(OptionsModel optionsModel) {
                if (optionsModel == null) {
                    return null;
                }
                if (optionsModel instanceof OptionsModel) {
                    return optionsModel;
                }
                Builder builder = new Builder();
                com.google.common.collect.ImmutableList.Builder builder2 = ImmutableList.builder();
                for (int i = 0; i < optionsModel.m2739a().size(); i++) {
                    builder2.c(EdgesModel.m2730a((EdgesModel) optionsModel.m2739a().get(i)));
                }
                builder.f2492a = builder2.b();
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                int a = ModelHelper.a(flatBufferBuilder, builder.f2492a);
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.d(flatBufferBuilder.d());
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                return new OptionsModel(new MutableFlatBuffer(wrap, null, null, true, null));
            }

            public final int jK_() {
                return 458847047;
            }

            public final GraphQLVisitableModel m2738a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m2739a() != null) {
                    com.google.common.collect.ImmutableList.Builder a = ModelHelper.a(m2739a(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        graphQLVisitableModel = (OptionsModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f2495d = a.b();
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m2737a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m2739a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, a);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: sync_params/ */
        public class Serializer extends JsonSerializer<SuggestEditsFieldModel> {
            public final void m2740a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                SuggestEditsFieldModel suggestEditsFieldModel = (SuggestEditsFieldModel) obj;
                if (suggestEditsFieldModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(suggestEditsFieldModel.m2742a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    suggestEditsFieldModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                SuggestEditsFieldParser.m2938a(suggestEditsFieldModel.w_(), suggestEditsFieldModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(SuggestEditsFieldModel.class, new Serializer());
            }
        }

        @Nullable
        public final /* synthetic */ CrowdsourcedFieldModel mo108c() {
            return m2750k();
        }

        @Nullable
        public final /* synthetic */ OptionsModel ey_() {
            return m2751l();
        }

        public SuggestEditsFieldModel() {
            super(9);
        }

        public SuggestEditsFieldModel(MutableFlatBuffer mutableFlatBuffer) {
            super(9);
            a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
        }

        @Nullable
        public final String mo106a() {
            this.f2496d = super.a(this.f2496d, 0);
            return this.f2496d;
        }

        @Nullable
        public final String mo107b() {
            this.f2497e = super.a(this.f2497e, 1);
            return this.f2497e;
        }

        @Nullable
        public final CrowdsourcedFieldModel m2750k() {
            this.f2498f = (CrowdsourcedFieldModel) super.a(this.f2498f, 2, CrowdsourcedFieldModel.class);
            return this.f2498f;
        }

        @Nullable
        public final String mo109d() {
            this.f2499g = super.a(this.f2499g, 3);
            return this.f2499g;
        }

        @Nullable
        public final OptionsModel m2751l() {
            this.f2500h = (OptionsModel) super.a(this.f2500h, 4, OptionsModel.class);
            return this.f2500h;
        }

        @Nullable
        public final String mo113g() {
            this.f2501i = super.a(this.f2501i, 5);
            return this.f2501i;
        }

        @Nullable
        public final GraphQLSuggestEditsFieldOptionType ew_() {
            this.f2502j = (GraphQLSuggestEditsFieldOptionType) super.b(this.f2502j, 6, GraphQLSuggestEditsFieldOptionType.class, GraphQLSuggestEditsFieldOptionType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
            return this.f2502j;
        }

        @Nullable
        public final String ex_() {
            this.f2503k = super.a(this.f2503k, 7);
            return this.f2503k;
        }

        @Nullable
        public final String mo114j() {
            this.f2504l = super.a(this.f2504l, 8);
            return this.f2504l;
        }

        public static SuggestEditsFieldModel m2741a(SuggestEditsField suggestEditsField) {
            if (suggestEditsField == null) {
                return null;
            }
            if (suggestEditsField instanceof SuggestEditsFieldModel) {
                return (SuggestEditsFieldModel) suggestEditsField;
            }
            Builder builder = new Builder();
            builder.f2483a = suggestEditsField.mo106a();
            builder.f2484b = suggestEditsField.mo107b();
            builder.f2485c = CrowdsourcedFieldModel.m2596a(suggestEditsField.mo108c());
            builder.f2486d = suggestEditsField.mo109d();
            builder.f2487e = OptionsModel.m2736a(suggestEditsField.ey_());
            builder.f2488f = suggestEditsField.mo113g();
            builder.f2489g = suggestEditsField.ew_();
            builder.f2490h = suggestEditsField.ex_();
            builder.f2491i = suggestEditsField.mo114j();
            return builder.m2725a();
        }

        public final int jK_() {
            return 1626810320;
        }

        public final GraphQLVisitableModel m2743a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m2750k() != null) {
                CrowdsourcedFieldModel crowdsourcedFieldModel = (CrowdsourcedFieldModel) graphQLModelMutatingVisitor.b(m2750k());
                if (m2750k() != crowdsourcedFieldModel) {
                    graphQLVisitableModel = (SuggestEditsFieldModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f2498f = crowdsourcedFieldModel;
                }
            }
            if (m2751l() != null) {
                OptionsModel optionsModel = (OptionsModel) graphQLModelMutatingVisitor.b(m2751l());
                if (m2751l() != optionsModel) {
                    graphQLVisitableModel = (SuggestEditsFieldModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f2500h = optionsModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m2742a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(mo106a());
            int b2 = flatBufferBuilder.b(mo107b());
            int a = ModelHelper.a(flatBufferBuilder, m2750k());
            int b3 = flatBufferBuilder.b(mo109d());
            int a2 = ModelHelper.a(flatBufferBuilder, m2751l());
            int b4 = flatBufferBuilder.b(mo113g());
            int a3 = flatBufferBuilder.a(ew_());
            int b5 = flatBufferBuilder.b(ex_());
            int b6 = flatBufferBuilder.b(mo114j());
            flatBufferBuilder.c(9);
            flatBufferBuilder.b(0, b);
            flatBufferBuilder.b(1, b2);
            flatBufferBuilder.b(2, a);
            flatBufferBuilder.b(3, b3);
            flatBufferBuilder.b(4, a2);
            flatBufferBuilder.b(5, b4);
            flatBufferBuilder.b(6, a3);
            flatBufferBuilder.b(7, b5);
            flatBufferBuilder.b(8, b6);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 1626436907)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: sync_params/ */
    public final class SuggestEditsHeaderModel extends BaseModel implements GraphQLVisitableConsistentModel {
        @Nullable
        private CrowdsourcedFieldModel f2508d;
        @Nullable
        private CrowdsourcedFieldModel f2509e;
        private int f2510f;

        /* compiled from: sync_params/ */
        public final class Builder {
            @Nullable
            public CrowdsourcedFieldModel f2505a;
            @Nullable
            public CrowdsourcedFieldModel f2506b;
            public int f2507c;

            public static Builder m2752a(SuggestEditsHeaderModel suggestEditsHeaderModel) {
                Builder builder = new Builder();
                builder.f2505a = suggestEditsHeaderModel.m2765j();
                builder.f2506b = suggestEditsHeaderModel.m2766k();
                builder.f2507c = suggestEditsHeaderModel.m2764c();
                return builder;
            }

            public final SuggestEditsHeaderModel m2753a() {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                int a = ModelHelper.a(flatBufferBuilder, this.f2505a);
                int a2 = ModelHelper.a(flatBufferBuilder, this.f2506b);
                flatBufferBuilder.c(3);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.b(1, a2);
                flatBufferBuilder.a(2, this.f2507c, 0);
                flatBufferBuilder.d(flatBufferBuilder.d());
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                return new SuggestEditsHeaderModel(new MutableFlatBuffer(wrap, null, null, true, null));
            }
        }

        /* compiled from: sync_params/ */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(SuggestEditsHeaderModel.class, new Deserializer());
            }

            public Object m2754a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = SuggestEditsHeaderParser.m2939a(jsonParser);
                Object suggestEditsHeaderModel = new SuggestEditsHeaderModel();
                ((BaseModel) suggestEditsHeaderModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (suggestEditsHeaderModel instanceof Postprocessable) {
                    return ((Postprocessable) suggestEditsHeaderModel).a();
                }
                return suggestEditsHeaderModel;
            }
        }

        /* compiled from: sync_params/ */
        public class Serializer extends JsonSerializer<SuggestEditsHeaderModel> {
            public final void m2755a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                SuggestEditsHeaderModel suggestEditsHeaderModel = (SuggestEditsHeaderModel) obj;
                if (suggestEditsHeaderModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(suggestEditsHeaderModel.m2757a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    suggestEditsHeaderModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = suggestEditsHeaderModel.w_();
                int u_ = suggestEditsHeaderModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("crowdsourcedName");
                    CrowdsourcedFieldParser.m2895a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                g = mutableFlatBuffer.g(u_, 1);
                if (g != 0) {
                    jsonGenerator.a("crowdsourcedPhoto");
                    CrowdsourcedFieldParser.m2895a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                g = mutableFlatBuffer.a(u_, 2, 0);
                if (g != 0) {
                    jsonGenerator.a("pending_claims_count");
                    jsonGenerator.b(g);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(SuggestEditsHeaderModel.class, new Serializer());
            }
        }

        @Nullable
        public final /* synthetic */ CrowdsourcedFieldModel m2758a() {
            return m2765j();
        }

        @Nullable
        public final /* synthetic */ CrowdsourcedFieldModel m2763b() {
            return m2766k();
        }

        public SuggestEditsHeaderModel() {
            super(3);
        }

        public SuggestEditsHeaderModel(MutableFlatBuffer mutableFlatBuffer) {
            super(3);
            a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
        }

        public final void m2761a(String str, ConsistencyTuple consistencyTuple) {
            consistencyTuple.a();
        }

        public final void m2762a(String str, Object obj, boolean z) {
        }

        @Nullable
        public final CrowdsourcedFieldModel m2765j() {
            this.f2508d = (CrowdsourcedFieldModel) super.a(this.f2508d, 0, CrowdsourcedFieldModel.class);
            return this.f2508d;
        }

        @Nullable
        public final CrowdsourcedFieldModel m2766k() {
            this.f2509e = (CrowdsourcedFieldModel) super.a(this.f2509e, 1, CrowdsourcedFieldModel.class);
            return this.f2509e;
        }

        public final int m2764c() {
            a(0, 2);
            return this.f2510f;
        }

        public static SuggestEditsHeaderModel m2756a(SuggestEditsHeaderModel suggestEditsHeaderModel) {
            if (suggestEditsHeaderModel == null) {
                return null;
            }
            if (suggestEditsHeaderModel instanceof SuggestEditsHeaderModel) {
                return suggestEditsHeaderModel;
            }
            Builder builder = new Builder();
            builder.f2505a = CrowdsourcedFieldModel.m2596a(suggestEditsHeaderModel.m2758a());
            builder.f2506b = CrowdsourcedFieldModel.m2596a(suggestEditsHeaderModel.m2763b());
            builder.f2507c = suggestEditsHeaderModel.m2764c();
            return builder.m2753a();
        }

        public final int jK_() {
            return 2479791;
        }

        public final GraphQLVisitableModel m2759a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            CrowdsourcedFieldModel crowdsourcedFieldModel;
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m2765j() != null) {
                crowdsourcedFieldModel = (CrowdsourcedFieldModel) graphQLModelMutatingVisitor.b(m2765j());
                if (m2765j() != crowdsourcedFieldModel) {
                    graphQLVisitableModel = (SuggestEditsHeaderModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f2508d = crowdsourcedFieldModel;
                }
            }
            if (m2766k() != null) {
                crowdsourcedFieldModel = (CrowdsourcedFieldModel) graphQLModelMutatingVisitor.b(m2766k());
                if (m2766k() != crowdsourcedFieldModel) {
                    graphQLVisitableModel = (SuggestEditsHeaderModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f2509e = crowdsourcedFieldModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m2757a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m2765j());
            int a2 = ModelHelper.a(flatBufferBuilder, m2766k());
            flatBufferBuilder.c(3);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, a2);
            flatBufferBuilder.a(2, this.f2510f, 0);
            i();
            return flatBufferBuilder.d();
        }

        public final void m2760a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
            super.a(mutableFlatBuffer, i, obj);
            this.f2510f = mutableFlatBuffer.a(i, 2, 0);
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 1076497272)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: sync_params/ */
    public final class SuggestEditsOptionModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private FieldIconModel f2560d;
        @Nullable
        private String f2561e;
        @Nullable
        private OptionIconModel f2562f;
        @Nullable
        private OptionSelectedIconModel f2563g;
        @Nullable
        private String f2564h;
        @Nullable
        private GraphQLSuggestEditsFieldOptionType f2565i;
        @Nullable
        private OptionValueModel f2566j;

        /* compiled from: sync_params/ */
        public final class Builder {
            @Nullable
            public FieldIconModel f2511a;
            @Nullable
            public String f2512b;
            @Nullable
            public OptionIconModel f2513c;
            @Nullable
            public OptionSelectedIconModel f2514d;
            @Nullable
            public String f2515e;
            @Nullable
            public GraphQLSuggestEditsFieldOptionType f2516f;
            @Nullable
            public OptionValueModel f2517g;
        }

        /* compiled from: sync_params/ */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(SuggestEditsOptionModel.class, new Deserializer());
            }

            public Object m2767a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(SuggestEditsOptionParser.m2954a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object suggestEditsOptionModel = new SuggestEditsOptionModel();
                ((BaseModel) suggestEditsOptionModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (suggestEditsOptionModel instanceof Postprocessable) {
                    return ((Postprocessable) suggestEditsOptionModel).a();
                }
                return suggestEditsOptionModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 842551240)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: sync_params/ */
        public final class FieldIconModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private String f2519d;

            /* compiled from: sync_params/ */
            public final class Builder {
                @Nullable
                public String f2518a;
            }

            /* compiled from: sync_params/ */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(FieldIconModel.class, new Deserializer());
                }

                public Object m2768a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(FieldIconParser.m2940a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object fieldIconModel = new FieldIconModel();
                    ((BaseModel) fieldIconModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (fieldIconModel instanceof Postprocessable) {
                        return ((Postprocessable) fieldIconModel).a();
                    }
                    return fieldIconModel;
                }
            }

            /* compiled from: sync_params/ */
            public class Serializer extends JsonSerializer<FieldIconModel> {
                public final void m2769a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    FieldIconModel fieldIconModel = (FieldIconModel) obj;
                    if (fieldIconModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(fieldIconModel.m2771a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        fieldIconModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    FieldIconParser.m2941a(fieldIconModel.w_(), fieldIconModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(FieldIconModel.class, new Serializer());
                }
            }

            public FieldIconModel() {
                super(1);
            }

            public FieldIconModel(MutableFlatBuffer mutableFlatBuffer) {
                super(1);
                a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
            }

            @Nullable
            public final String m2773a() {
                this.f2519d = super.a(this.f2519d, 0);
                return this.f2519d;
            }

            public static FieldIconModel m2770a(FieldIconModel fieldIconModel) {
                if (fieldIconModel == null) {
                    return null;
                }
                if (fieldIconModel instanceof FieldIconModel) {
                    return fieldIconModel;
                }
                Builder builder = new Builder();
                builder.f2518a = fieldIconModel.m2773a();
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                int b = flatBufferBuilder.b(builder.f2518a);
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, b);
                flatBufferBuilder.d(flatBufferBuilder.d());
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                return new FieldIconModel(new MutableFlatBuffer(wrap, null, null, true, null));
            }

            public final int jK_() {
                return 70760763;
            }

            public final GraphQLVisitableModel m2772a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m2771a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m2773a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, b);
                i();
                return flatBufferBuilder.d();
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 842551240)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: sync_params/ */
        public final class OptionIconModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private String f2521d;

            /* compiled from: sync_params/ */
            public final class Builder {
                @Nullable
                public String f2520a;
            }

            /* compiled from: sync_params/ */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(OptionIconModel.class, new Deserializer());
                }

                public Object m2774a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(OptionIconParser.m2942a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object optionIconModel = new OptionIconModel();
                    ((BaseModel) optionIconModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (optionIconModel instanceof Postprocessable) {
                        return ((Postprocessable) optionIconModel).a();
                    }
                    return optionIconModel;
                }
            }

            /* compiled from: sync_params/ */
            public class Serializer extends JsonSerializer<OptionIconModel> {
                public final void m2775a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    OptionIconModel optionIconModel = (OptionIconModel) obj;
                    if (optionIconModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(optionIconModel.m2777a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        optionIconModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    OptionIconParser.m2943a(optionIconModel.w_(), optionIconModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(OptionIconModel.class, new Serializer());
                }
            }

            public OptionIconModel() {
                super(1);
            }

            public OptionIconModel(MutableFlatBuffer mutableFlatBuffer) {
                super(1);
                a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
            }

            @Nullable
            public final String m2779a() {
                this.f2521d = super.a(this.f2521d, 0);
                return this.f2521d;
            }

            public static OptionIconModel m2776a(OptionIconModel optionIconModel) {
                if (optionIconModel == null) {
                    return null;
                }
                if (optionIconModel instanceof OptionIconModel) {
                    return optionIconModel;
                }
                Builder builder = new Builder();
                builder.f2520a = optionIconModel.m2779a();
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                int b = flatBufferBuilder.b(builder.f2520a);
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, b);
                flatBufferBuilder.d(flatBufferBuilder.d());
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                return new OptionIconModel(new MutableFlatBuffer(wrap, null, null, true, null));
            }

            public final int jK_() {
                return 70760763;
            }

            public final GraphQLVisitableModel m2778a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m2777a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m2779a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, b);
                i();
                return flatBufferBuilder.d();
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 842551240)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: sync_params/ */
        public final class OptionSelectedIconModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private String f2523d;

            /* compiled from: sync_params/ */
            public final class Builder {
                @Nullable
                public String f2522a;
            }

            /* compiled from: sync_params/ */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(OptionSelectedIconModel.class, new Deserializer());
                }

                public Object m2780a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(OptionSelectedIconParser.m2944a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object optionSelectedIconModel = new OptionSelectedIconModel();
                    ((BaseModel) optionSelectedIconModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (optionSelectedIconModel instanceof Postprocessable) {
                        return ((Postprocessable) optionSelectedIconModel).a();
                    }
                    return optionSelectedIconModel;
                }
            }

            /* compiled from: sync_params/ */
            public class Serializer extends JsonSerializer<OptionSelectedIconModel> {
                public final void m2781a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    OptionSelectedIconModel optionSelectedIconModel = (OptionSelectedIconModel) obj;
                    if (optionSelectedIconModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(optionSelectedIconModel.m2783a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        optionSelectedIconModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    OptionSelectedIconParser.m2945a(optionSelectedIconModel.w_(), optionSelectedIconModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(OptionSelectedIconModel.class, new Serializer());
                }
            }

            public OptionSelectedIconModel() {
                super(1);
            }

            public OptionSelectedIconModel(MutableFlatBuffer mutableFlatBuffer) {
                super(1);
                a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
            }

            @Nullable
            public final String m2785a() {
                this.f2523d = super.a(this.f2523d, 0);
                return this.f2523d;
            }

            public static OptionSelectedIconModel m2782a(OptionSelectedIconModel optionSelectedIconModel) {
                if (optionSelectedIconModel == null) {
                    return null;
                }
                if (optionSelectedIconModel instanceof OptionSelectedIconModel) {
                    return optionSelectedIconModel;
                }
                Builder builder = new Builder();
                builder.f2522a = optionSelectedIconModel.m2785a();
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                int b = flatBufferBuilder.b(builder.f2522a);
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, b);
                flatBufferBuilder.d(flatBufferBuilder.d());
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                return new OptionSelectedIconModel(new MutableFlatBuffer(wrap, null, null, true, null));
            }

            public final int jK_() {
                return 70760763;
            }

            public final GraphQLVisitableModel m2784a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m2783a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m2785a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, b);
                i();
                return flatBufferBuilder.d();
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -374105223)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: sync_params/ */
        public final class OptionValueModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private UserValuesModel f2559d;

            /* compiled from: sync_params/ */
            public final class Builder {
                @Nullable
                public UserValuesModel f2524a;
            }

            /* compiled from: sync_params/ */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(OptionValueModel.class, new Deserializer());
                }

                public Object m2786a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(OptionValueParser.m2952a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object optionValueModel = new OptionValueModel();
                    ((BaseModel) optionValueModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (optionValueModel instanceof Postprocessable) {
                        return ((Postprocessable) optionValueModel).a();
                    }
                    return optionValueModel;
                }
            }

            /* compiled from: sync_params/ */
            public class Serializer extends JsonSerializer<OptionValueModel> {
                public final void m2787a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    OptionValueModel optionValueModel = (OptionValueModel) obj;
                    if (optionValueModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(optionValueModel.m2825a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        optionValueModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    OptionValueParser.m2953a(optionValueModel.w_(), optionValueModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(OptionValueModel.class, new Serializer());
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = -587424696)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: sync_params/ */
            public final class UserValuesModel extends BaseModel implements GraphQLVisitableModel {
                @Nullable
                private List<EdgesModel> f2558d;

                /* compiled from: sync_params/ */
                public final class Builder {
                    @Nullable
                    public ImmutableList<EdgesModel> f2525a;
                }

                /* compiled from: sync_params/ */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(UserValuesModel.class, new Deserializer());
                    }

                    public Object m2788a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(OptionValueParser.UserValuesParser.m2950a(jsonParser, flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                        Object userValuesModel = new UserValuesModel();
                        ((BaseModel) userValuesModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                        if (userValuesModel instanceof Postprocessable) {
                            return ((Postprocessable) userValuesModel).a();
                        }
                        return userValuesModel;
                    }
                }

                @JsonDeserialize(using = Deserializer.class)
                @ModelWithFlatBufferFormatHash(a = -972674236)
                @JsonSerialize(using = Serializer.class)
                @FragmentModelWithoutBridge
                /* compiled from: sync_params/ */
                public final class EdgesModel extends BaseModel implements GraphQLVisitableModel {
                    @Nullable
                    private NodeModel f2557d;

                    /* compiled from: sync_params/ */
                    public final class Builder {
                        @Nullable
                        public NodeModel f2526a;
                    }

                    /* compiled from: sync_params/ */
                    public class Deserializer extends FbJsonDeserializer {
                        static {
                            GlobalAutoGenDeserializerCache.a(EdgesModel.class, new Deserializer());
                        }

                        public Object m2789a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(OptionValueParser.UserValuesParser.EdgesParser.m2948b(jsonParser, flatBufferBuilder));
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

                    @JsonDeserialize(using = Deserializer.class)
                    @ModelWithFlatBufferFormatHash(a = 1507018910)
                    @JsonSerialize(using = Serializer.class)
                    @FragmentModelWithoutBridge
                    /* compiled from: sync_params/ */
                    public final class NodeModel extends BaseModel implements CrowdsourcedAddress, CrowdsourcedCategory, CrowdsourcedHours, CrowdsourcedLocatedIn, CrowdsourcedPhoto, GraphQLVisitableModel {
                        @Nullable
                        private GraphQLObjectType f2542d;
                        @Nullable
                        private CategoryModel f2543e;
                        @Nullable
                        private CityModel f2544f;
                        @Nullable
                        private List<FriModel> f2545g;
                        @Nullable
                        private List<MonModel> f2546h;
                        @Nullable
                        private ParentPlaceModel f2547i;
                        @Nullable
                        private PhotoModel f2548j;
                        @Nullable
                        private List<SatModel> f2549k;
                        @Nullable
                        private String f2550l;
                        @Nullable
                        private List<SunModel> f2551m;
                        @Nullable
                        private String f2552n;
                        @Nullable
                        private List<ThuModel> f2553o;
                        @Nullable
                        private List<TueModel> f2554p;
                        @Nullable
                        private List<WedModel> f2555q;
                        @Nullable
                        private String f2556r;

                        /* compiled from: sync_params/ */
                        public final class Builder {
                            @Nullable
                            public GraphQLObjectType f2527a;
                            @Nullable
                            public CategoryModel f2528b;
                            @Nullable
                            public CityModel f2529c;
                            @Nullable
                            public ImmutableList<FriModel> f2530d;
                            @Nullable
                            public ImmutableList<MonModel> f2531e;
                            @Nullable
                            public ParentPlaceModel f2532f;
                            @Nullable
                            public PhotoModel f2533g;
                            @Nullable
                            public ImmutableList<SatModel> f2534h;
                            @Nullable
                            public String f2535i;
                            @Nullable
                            public ImmutableList<SunModel> f2536j;
                            @Nullable
                            public String f2537k;
                            @Nullable
                            public ImmutableList<ThuModel> f2538l;
                            @Nullable
                            public ImmutableList<TueModel> f2539m;
                            @Nullable
                            public ImmutableList<WedModel> f2540n;
                            @Nullable
                            public String f2541o;

                            public final NodeModel m2790a() {
                                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                int a = ModelHelper.a(flatBufferBuilder, this.f2527a);
                                int a2 = ModelHelper.a(flatBufferBuilder, this.f2528b);
                                int a3 = ModelHelper.a(flatBufferBuilder, this.f2529c);
                                int a4 = ModelHelper.a(flatBufferBuilder, this.f2530d);
                                int a5 = ModelHelper.a(flatBufferBuilder, this.f2531e);
                                int a6 = ModelHelper.a(flatBufferBuilder, this.f2532f);
                                int a7 = ModelHelper.a(flatBufferBuilder, this.f2533g);
                                int a8 = ModelHelper.a(flatBufferBuilder, this.f2534h);
                                int b = flatBufferBuilder.b(this.f2535i);
                                int a9 = ModelHelper.a(flatBufferBuilder, this.f2536j);
                                int b2 = flatBufferBuilder.b(this.f2537k);
                                int a10 = ModelHelper.a(flatBufferBuilder, this.f2538l);
                                int a11 = ModelHelper.a(flatBufferBuilder, this.f2539m);
                                int a12 = ModelHelper.a(flatBufferBuilder, this.f2540n);
                                int b3 = flatBufferBuilder.b(this.f2541o);
                                flatBufferBuilder.c(15);
                                flatBufferBuilder.b(0, a);
                                flatBufferBuilder.b(1, a2);
                                flatBufferBuilder.b(2, a3);
                                flatBufferBuilder.b(3, a4);
                                flatBufferBuilder.b(4, a5);
                                flatBufferBuilder.b(5, a6);
                                flatBufferBuilder.b(6, a7);
                                flatBufferBuilder.b(7, a8);
                                flatBufferBuilder.b(8, b);
                                flatBufferBuilder.b(9, a9);
                                flatBufferBuilder.b(10, b2);
                                flatBufferBuilder.b(11, a10);
                                flatBufferBuilder.b(12, a11);
                                flatBufferBuilder.b(13, a12);
                                flatBufferBuilder.b(14, b3);
                                flatBufferBuilder.d(flatBufferBuilder.d());
                                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                wrap.position(0);
                                return new NodeModel(new MutableFlatBuffer(wrap, null, null, true, null));
                            }
                        }

                        /* compiled from: sync_params/ */
                        public class Deserializer extends FbJsonDeserializer {
                            static {
                                GlobalAutoGenDeserializerCache.a(NodeModel.class, new Deserializer());
                            }

                            public Object m2791a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                flatBufferBuilder.d(OptionValueParser.UserValuesParser.EdgesParser.NodeParser.m2946a(jsonParser, flatBufferBuilder));
                                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                wrap.position(0);
                                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                                Object nodeModel = new NodeModel();
                                ((BaseModel) nodeModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                                if (nodeModel instanceof Postprocessable) {
                                    return ((Postprocessable) nodeModel).a();
                                }
                                return nodeModel;
                            }
                        }

                        /* compiled from: sync_params/ */
                        public class Serializer extends JsonSerializer<NodeModel> {
                            public final void m2792a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                                NodeModel nodeModel = (NodeModel) obj;
                                if (nodeModel.w_() == null) {
                                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                    flatBufferBuilder.d(nodeModel.m2798a(flatBufferBuilder));
                                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                    wrap.position(0);
                                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                    nodeModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                                }
                                OptionValueParser.UserValuesParser.EdgesParser.NodeParser.m2947a(nodeModel.w_(), nodeModel.u_(), jsonGenerator, serializerProvider);
                            }

                            static {
                                FbSerializerProvider.a(NodeModel.class, new Serializer());
                            }
                        }

                        @Nullable
                        public final /* synthetic */ CategoryModel m2801b() {
                            return m2794q();
                        }

                        @Nullable
                        public final /* synthetic */ CityModel m2802c() {
                            return m2795r();
                        }

                        @Nullable
                        public final /* synthetic */ PhotoModel eB_() {
                            return m2797t();
                        }

                        @Nullable
                        public final /* synthetic */ ParentPlaceModel m2804g() {
                            return m2796s();
                        }

                        public NodeModel() {
                            super(15);
                        }

                        public NodeModel(MutableFlatBuffer mutableFlatBuffer) {
                            super(15);
                            a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }

                        @Nullable
                        public final GraphQLObjectType m2799a() {
                            if (this.b != null && this.f2542d == null) {
                                this.f2542d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
                            }
                            return this.f2542d;
                        }

                        @Nullable
                        private CategoryModel m2794q() {
                            this.f2543e = (CategoryModel) super.a(this.f2543e, 1, CategoryModel.class);
                            return this.f2543e;
                        }

                        @Nullable
                        private CityModel m2795r() {
                            this.f2544f = (CityModel) super.a(this.f2544f, 2, CityModel.class);
                            return this.f2544f;
                        }

                        @Nonnull
                        public final ImmutableList<FriModel> mo99d() {
                            this.f2545g = super.a(this.f2545g, 3, FriModel.class);
                            return (ImmutableList) this.f2545g;
                        }

                        @Nonnull
                        public final ImmutableList<MonModel> et_() {
                            this.f2546h = super.a(this.f2546h, 4, MonModel.class);
                            return (ImmutableList) this.f2546h;
                        }

                        @Nullable
                        private ParentPlaceModel m2796s() {
                            this.f2547i = (ParentPlaceModel) super.a(this.f2547i, 5, ParentPlaceModel.class);
                            return this.f2547i;
                        }

                        @Nullable
                        private PhotoModel m2797t() {
                            this.f2548j = (PhotoModel) super.a(this.f2548j, 6, PhotoModel.class);
                            return this.f2548j;
                        }

                        @Nonnull
                        public final ImmutableList<SatModel> eu_() {
                            this.f2549k = super.a(this.f2549k, 7, SatModel.class);
                            return (ImmutableList) this.f2549k;
                        }

                        @Nullable
                        public final String m2805j() {
                            this.f2550l = super.a(this.f2550l, 8);
                            return this.f2550l;
                        }

                        @Nonnull
                        public final ImmutableList<SunModel> mo102k() {
                            this.f2551m = super.a(this.f2551m, 9, SunModel.class);
                            return (ImmutableList) this.f2551m;
                        }

                        @Nullable
                        public final String m2807l() {
                            this.f2552n = super.a(this.f2552n, 10);
                            return this.f2552n;
                        }

                        @Nonnull
                        public final ImmutableList<ThuModel> mo103m() {
                            this.f2553o = super.a(this.f2553o, 11, ThuModel.class);
                            return (ImmutableList) this.f2553o;
                        }

                        @Nonnull
                        public final ImmutableList<TueModel> mo104n() {
                            this.f2554p = super.a(this.f2554p, 12, TueModel.class);
                            return (ImmutableList) this.f2554p;
                        }

                        @Nonnull
                        public final ImmutableList<WedModel> mo105o() {
                            this.f2555q = super.a(this.f2555q, 13, WedModel.class);
                            return (ImmutableList) this.f2555q;
                        }

                        @Nullable
                        public final String m2811p() {
                            this.f2556r = super.a(this.f2556r, 14);
                            return this.f2556r;
                        }

                        public static NodeModel m2793a(NodeModel nodeModel) {
                            int i = 0;
                            if (nodeModel == null) {
                                return null;
                            }
                            if (nodeModel instanceof NodeModel) {
                                return nodeModel;
                            }
                            int i2;
                            Builder builder = new Builder();
                            builder.f2527a = nodeModel.m2799a();
                            builder.f2528b = CategoryModel.m2544a(nodeModel.m2801b());
                            builder.f2529c = CityModel.m2524a(nodeModel.m2802c());
                            com.google.common.collect.ImmutableList.Builder builder2 = ImmutableList.builder();
                            for (i2 = 0; i2 < nodeModel.mo99d().size(); i2++) {
                                builder2.c(FriModel.m2609a((FriModel) nodeModel.mo99d().get(i2)));
                            }
                            builder.f2530d = builder2.b();
                            builder2 = ImmutableList.builder();
                            for (i2 = 0; i2 < nodeModel.et_().size(); i2++) {
                                builder2.c(MonModel.m2620a((MonModel) nodeModel.et_().get(i2)));
                            }
                            builder.f2531e = builder2.b();
                            builder.f2532f = ParentPlaceModel.m2692a(nodeModel.m2804g());
                            builder.f2533g = PhotoModel.m2715a(nodeModel.eB_());
                            builder2 = ImmutableList.builder();
                            for (i2 = 0; i2 < nodeModel.eu_().size(); i2++) {
                                builder2.c(SatModel.m2631a((SatModel) nodeModel.eu_().get(i2)));
                            }
                            builder.f2534h = builder2.b();
                            builder.f2535i = nodeModel.m2805j();
                            builder2 = ImmutableList.builder();
                            for (i2 = 0; i2 < nodeModel.mo102k().size(); i2++) {
                                builder2.c(SunModel.m2643a((SunModel) nodeModel.mo102k().get(i2)));
                            }
                            builder.f2536j = builder2.b();
                            builder.f2537k = nodeModel.m2807l();
                            builder2 = ImmutableList.builder();
                            for (i2 = 0; i2 < nodeModel.mo103m().size(); i2++) {
                                builder2.c(ThuModel.m2654a((ThuModel) nodeModel.mo103m().get(i2)));
                            }
                            builder.f2538l = builder2.b();
                            builder2 = ImmutableList.builder();
                            for (i2 = 0; i2 < nodeModel.mo104n().size(); i2++) {
                                builder2.c(TueModel.m2665a((TueModel) nodeModel.mo104n().get(i2)));
                            }
                            builder.f2539m = builder2.b();
                            com.google.common.collect.ImmutableList.Builder builder3 = ImmutableList.builder();
                            while (i < nodeModel.mo105o().size()) {
                                builder3.c(WedModel.m2676a((WedModel) nodeModel.mo105o().get(i)));
                                i++;
                            }
                            builder.f2540n = builder3.b();
                            builder.f2541o = nodeModel.m2811p();
                            return builder.m2790a();
                        }

                        public final int jK_() {
                            return 424485973;
                        }

                        public final GraphQLVisitableModel m2800a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                            com.google.common.collect.ImmutableList.Builder a;
                            GraphQLVisitableModel graphQLVisitableModel = null;
                            h();
                            if (m2794q() != null) {
                                CategoryModel categoryModel = (CategoryModel) graphQLModelMutatingVisitor.b(m2794q());
                                if (m2794q() != categoryModel) {
                                    graphQLVisitableModel = (NodeModel) ModelHelper.a(null, this);
                                    graphQLVisitableModel.f2543e = categoryModel;
                                }
                            }
                            if (m2795r() != null) {
                                CityModel cityModel = (CityModel) graphQLModelMutatingVisitor.b(m2795r());
                                if (m2795r() != cityModel) {
                                    graphQLVisitableModel = (NodeModel) ModelHelper.a(graphQLVisitableModel, this);
                                    graphQLVisitableModel.f2544f = cityModel;
                                }
                            }
                            if (mo99d() != null) {
                                a = ModelHelper.a(mo99d(), graphQLModelMutatingVisitor);
                                if (a != null) {
                                    NodeModel nodeModel = (NodeModel) ModelHelper.a(graphQLVisitableModel, this);
                                    nodeModel.f2545g = a.b();
                                    graphQLVisitableModel = nodeModel;
                                }
                            }
                            if (et_() != null) {
                                a = ModelHelper.a(et_(), graphQLModelMutatingVisitor);
                                if (a != null) {
                                    nodeModel = (NodeModel) ModelHelper.a(graphQLVisitableModel, this);
                                    nodeModel.f2546h = a.b();
                                    graphQLVisitableModel = nodeModel;
                                }
                            }
                            if (m2796s() != null) {
                                ParentPlaceModel parentPlaceModel = (ParentPlaceModel) graphQLModelMutatingVisitor.b(m2796s());
                                if (m2796s() != parentPlaceModel) {
                                    graphQLVisitableModel = (NodeModel) ModelHelper.a(graphQLVisitableModel, this);
                                    graphQLVisitableModel.f2547i = parentPlaceModel;
                                }
                            }
                            if (m2797t() != null) {
                                PhotoModel photoModel = (PhotoModel) graphQLModelMutatingVisitor.b(m2797t());
                                if (m2797t() != photoModel) {
                                    graphQLVisitableModel = (NodeModel) ModelHelper.a(graphQLVisitableModel, this);
                                    graphQLVisitableModel.f2548j = photoModel;
                                }
                            }
                            if (eu_() != null) {
                                a = ModelHelper.a(eu_(), graphQLModelMutatingVisitor);
                                if (a != null) {
                                    nodeModel = (NodeModel) ModelHelper.a(graphQLVisitableModel, this);
                                    nodeModel.f2549k = a.b();
                                    graphQLVisitableModel = nodeModel;
                                }
                            }
                            if (mo102k() != null) {
                                a = ModelHelper.a(mo102k(), graphQLModelMutatingVisitor);
                                if (a != null) {
                                    nodeModel = (NodeModel) ModelHelper.a(graphQLVisitableModel, this);
                                    nodeModel.f2551m = a.b();
                                    graphQLVisitableModel = nodeModel;
                                }
                            }
                            if (mo103m() != null) {
                                a = ModelHelper.a(mo103m(), graphQLModelMutatingVisitor);
                                if (a != null) {
                                    nodeModel = (NodeModel) ModelHelper.a(graphQLVisitableModel, this);
                                    nodeModel.f2553o = a.b();
                                    graphQLVisitableModel = nodeModel;
                                }
                            }
                            if (mo104n() != null) {
                                a = ModelHelper.a(mo104n(), graphQLModelMutatingVisitor);
                                if (a != null) {
                                    nodeModel = (NodeModel) ModelHelper.a(graphQLVisitableModel, this);
                                    nodeModel.f2554p = a.b();
                                    graphQLVisitableModel = nodeModel;
                                }
                            }
                            if (mo105o() != null) {
                                a = ModelHelper.a(mo105o(), graphQLModelMutatingVisitor);
                                if (a != null) {
                                    nodeModel = (NodeModel) ModelHelper.a(graphQLVisitableModel, this);
                                    nodeModel.f2555q = a.b();
                                    graphQLVisitableModel = nodeModel;
                                }
                            }
                            i();
                            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                        }

                        public final int m2798a(FlatBufferBuilder flatBufferBuilder) {
                            h();
                            int a = ModelHelper.a(flatBufferBuilder, m2799a());
                            int a2 = ModelHelper.a(flatBufferBuilder, m2794q());
                            int a3 = ModelHelper.a(flatBufferBuilder, m2795r());
                            int a4 = ModelHelper.a(flatBufferBuilder, mo99d());
                            int a5 = ModelHelper.a(flatBufferBuilder, et_());
                            int a6 = ModelHelper.a(flatBufferBuilder, m2796s());
                            int a7 = ModelHelper.a(flatBufferBuilder, m2797t());
                            int a8 = ModelHelper.a(flatBufferBuilder, eu_());
                            int b = flatBufferBuilder.b(m2805j());
                            int a9 = ModelHelper.a(flatBufferBuilder, mo102k());
                            int b2 = flatBufferBuilder.b(m2807l());
                            int a10 = ModelHelper.a(flatBufferBuilder, mo103m());
                            int a11 = ModelHelper.a(flatBufferBuilder, mo104n());
                            int a12 = ModelHelper.a(flatBufferBuilder, mo105o());
                            int b3 = flatBufferBuilder.b(m2811p());
                            flatBufferBuilder.c(15);
                            flatBufferBuilder.b(0, a);
                            flatBufferBuilder.b(1, a2);
                            flatBufferBuilder.b(2, a3);
                            flatBufferBuilder.b(3, a4);
                            flatBufferBuilder.b(4, a5);
                            flatBufferBuilder.b(5, a6);
                            flatBufferBuilder.b(6, a7);
                            flatBufferBuilder.b(7, a8);
                            flatBufferBuilder.b(8, b);
                            flatBufferBuilder.b(9, a9);
                            flatBufferBuilder.b(10, b2);
                            flatBufferBuilder.b(11, a10);
                            flatBufferBuilder.b(12, a11);
                            flatBufferBuilder.b(13, a12);
                            flatBufferBuilder.b(14, b3);
                            i();
                            return flatBufferBuilder.d();
                        }
                    }

                    /* compiled from: sync_params/ */
                    public class Serializer extends JsonSerializer<EdgesModel> {
                        public final void m2812a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                            EdgesModel edgesModel = (EdgesModel) obj;
                            if (edgesModel.w_() == null) {
                                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                flatBufferBuilder.d(edgesModel.m2815a(flatBufferBuilder));
                                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                wrap.position(0);
                                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                edgesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                            }
                            OptionValueParser.UserValuesParser.EdgesParser.m2949b(edgesModel.w_(), edgesModel.u_(), jsonGenerator, serializerProvider);
                        }

                        static {
                            FbSerializerProvider.a(EdgesModel.class, new Serializer());
                        }
                    }

                    @Nullable
                    public final /* synthetic */ NodeModel m2816a() {
                        return m2814j();
                    }

                    public EdgesModel() {
                        super(1);
                    }

                    public EdgesModel(MutableFlatBuffer mutableFlatBuffer) {
                        super(1);
                        a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }

                    @Nullable
                    private NodeModel m2814j() {
                        this.f2557d = (NodeModel) super.a(this.f2557d, 0, NodeModel.class);
                        return this.f2557d;
                    }

                    public static EdgesModel m2813a(EdgesModel edgesModel) {
                        if (edgesModel == null) {
                            return null;
                        }
                        if (edgesModel instanceof EdgesModel) {
                            return edgesModel;
                        }
                        Builder builder = new Builder();
                        builder.f2526a = NodeModel.m2793a(edgesModel.m2816a());
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        int a = ModelHelper.a(flatBufferBuilder, builder.f2526a);
                        flatBufferBuilder.c(1);
                        flatBufferBuilder.b(0, a);
                        flatBufferBuilder.d(flatBufferBuilder.d());
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        return new EdgesModel(new MutableFlatBuffer(wrap, null, null, true, null));
                    }

                    public final int jK_() {
                        return 895426863;
                    }

                    public final GraphQLVisitableModel m2817a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                        GraphQLVisitableModel graphQLVisitableModel = null;
                        h();
                        if (m2814j() != null) {
                            NodeModel nodeModel = (NodeModel) graphQLModelMutatingVisitor.b(m2814j());
                            if (m2814j() != nodeModel) {
                                graphQLVisitableModel = (EdgesModel) ModelHelper.a(null, this);
                                graphQLVisitableModel.f2557d = nodeModel;
                            }
                        }
                        i();
                        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                    }

                    public final int m2815a(FlatBufferBuilder flatBufferBuilder) {
                        h();
                        int a = ModelHelper.a(flatBufferBuilder, m2814j());
                        flatBufferBuilder.c(1);
                        flatBufferBuilder.b(0, a);
                        i();
                        return flatBufferBuilder.d();
                    }
                }

                /* compiled from: sync_params/ */
                public class Serializer extends JsonSerializer<UserValuesModel> {
                    public final void m2818a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        UserValuesModel userValuesModel = (UserValuesModel) obj;
                        if (userValuesModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(userValuesModel.m2820a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            userValuesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        OptionValueParser.UserValuesParser.m2951a(userValuesModel.w_(), userValuesModel.u_(), jsonGenerator, serializerProvider);
                    }

                    static {
                        FbSerializerProvider.a(UserValuesModel.class, new Serializer());
                    }
                }

                public UserValuesModel() {
                    super(1);
                }

                public UserValuesModel(MutableFlatBuffer mutableFlatBuffer) {
                    super(1);
                    a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }

                @Nonnull
                public final ImmutableList<EdgesModel> m2822a() {
                    this.f2558d = super.a(this.f2558d, 0, EdgesModel.class);
                    return (ImmutableList) this.f2558d;
                }

                public static UserValuesModel m2819a(UserValuesModel userValuesModel) {
                    if (userValuesModel == null) {
                        return null;
                    }
                    if (userValuesModel instanceof UserValuesModel) {
                        return userValuesModel;
                    }
                    Builder builder = new Builder();
                    com.google.common.collect.ImmutableList.Builder builder2 = ImmutableList.builder();
                    for (int i = 0; i < userValuesModel.m2822a().size(); i++) {
                        builder2.c(EdgesModel.m2813a((EdgesModel) userValuesModel.m2822a().get(i)));
                    }
                    builder.f2525a = builder2.b();
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    int a = ModelHelper.a(flatBufferBuilder, builder.f2525a);
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.b(0, a);
                    flatBufferBuilder.d(flatBufferBuilder.d());
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    return new UserValuesModel(new MutableFlatBuffer(wrap, null, null, true, null));
                }

                public final int jK_() {
                    return -1314368304;
                }

                public final GraphQLVisitableModel m2821a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    GraphQLVisitableModel graphQLVisitableModel = null;
                    h();
                    if (m2822a() != null) {
                        com.google.common.collect.ImmutableList.Builder a = ModelHelper.a(m2822a(), graphQLModelMutatingVisitor);
                        if (a != null) {
                            graphQLVisitableModel = (UserValuesModel) ModelHelper.a(null, this);
                            graphQLVisitableModel.f2558d = a.b();
                        }
                    }
                    i();
                    return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                }

                public final int m2820a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int a = ModelHelper.a(flatBufferBuilder, m2822a());
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.b(0, a);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            @Nullable
            public final /* synthetic */ UserValuesModel m2826a() {
                return m2824j();
            }

            public OptionValueModel() {
                super(1);
            }

            public OptionValueModel(MutableFlatBuffer mutableFlatBuffer) {
                super(1);
                a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
            }

            @Nullable
            private UserValuesModel m2824j() {
                this.f2559d = (UserValuesModel) super.a(this.f2559d, 0, UserValuesModel.class);
                return this.f2559d;
            }

            public static OptionValueModel m2823a(OptionValueModel optionValueModel) {
                if (optionValueModel == null) {
                    return null;
                }
                if (optionValueModel instanceof OptionValueModel) {
                    return optionValueModel;
                }
                Builder builder = new Builder();
                builder.f2524a = UserValuesModel.m2819a(optionValueModel.m2826a());
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                int a = ModelHelper.a(flatBufferBuilder, builder.f2524a);
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.d(flatBufferBuilder.d());
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                return new OptionValueModel(new MutableFlatBuffer(wrap, null, null, true, null));
            }

            public final int jK_() {
                return 409940958;
            }

            public final GraphQLVisitableModel m2827a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m2824j() != null) {
                    UserValuesModel userValuesModel = (UserValuesModel) graphQLModelMutatingVisitor.b(m2824j());
                    if (m2824j() != userValuesModel) {
                        graphQLVisitableModel = (OptionValueModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f2559d = userValuesModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m2825a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m2824j());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, a);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: sync_params/ */
        public class Serializer extends JsonSerializer<SuggestEditsOptionModel> {
            public final void m2828a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                SuggestEditsOptionModel suggestEditsOptionModel = (SuggestEditsOptionModel) obj;
                if (suggestEditsOptionModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(suggestEditsOptionModel.m2834a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    suggestEditsOptionModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                SuggestEditsOptionParser.m2955a(suggestEditsOptionModel.w_(), suggestEditsOptionModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(SuggestEditsOptionModel.class, new Serializer());
            }
        }

        @Nullable
        public final /* synthetic */ FieldIconModel m2835a() {
            return m2830j();
        }

        @Nullable
        public final /* synthetic */ OptionIconModel m2838c() {
            return m2831k();
        }

        @Nullable
        public final /* synthetic */ OptionSelectedIconModel m2839d() {
            return m2832l();
        }

        @Nullable
        public final /* synthetic */ OptionValueModel eA_() {
            return m2833m();
        }

        public SuggestEditsOptionModel() {
            super(7);
        }

        public SuggestEditsOptionModel(MutableFlatBuffer mutableFlatBuffer) {
            super(7);
            a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
        }

        @Nullable
        private FieldIconModel m2830j() {
            this.f2560d = (FieldIconModel) super.a(this.f2560d, 0, FieldIconModel.class);
            return this.f2560d;
        }

        @Nullable
        public final String m2837b() {
            this.f2561e = super.a(this.f2561e, 1);
            return this.f2561e;
        }

        @Nullable
        private OptionIconModel m2831k() {
            this.f2562f = (OptionIconModel) super.a(this.f2562f, 2, OptionIconModel.class);
            return this.f2562f;
        }

        @Nullable
        private OptionSelectedIconModel m2832l() {
            this.f2563g = (OptionSelectedIconModel) super.a(this.f2563g, 3, OptionSelectedIconModel.class);
            return this.f2563g;
        }

        @Nullable
        public final String ez_() {
            this.f2564h = super.a(this.f2564h, 4);
            return this.f2564h;
        }

        @Nullable
        public final GraphQLSuggestEditsFieldOptionType m2840g() {
            this.f2565i = (GraphQLSuggestEditsFieldOptionType) super.b(this.f2565i, 5, GraphQLSuggestEditsFieldOptionType.class, GraphQLSuggestEditsFieldOptionType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
            return this.f2565i;
        }

        @Nullable
        private OptionValueModel m2833m() {
            this.f2566j = (OptionValueModel) super.a(this.f2566j, 6, OptionValueModel.class);
            return this.f2566j;
        }

        public static SuggestEditsOptionModel m2829a(SuggestEditsOptionModel suggestEditsOptionModel) {
            if (suggestEditsOptionModel == null) {
                return null;
            }
            if (suggestEditsOptionModel instanceof SuggestEditsOptionModel) {
                return suggestEditsOptionModel;
            }
            Builder builder = new Builder();
            builder.f2511a = FieldIconModel.m2770a(suggestEditsOptionModel.m2835a());
            builder.f2512b = suggestEditsOptionModel.m2837b();
            builder.f2513c = OptionIconModel.m2776a(suggestEditsOptionModel.m2838c());
            builder.f2514d = OptionSelectedIconModel.m2782a(suggestEditsOptionModel.m2839d());
            builder.f2515e = suggestEditsOptionModel.ez_();
            builder.f2516f = suggestEditsOptionModel.m2840g();
            builder.f2517g = OptionValueModel.m2823a(suggestEditsOptionModel.eA_());
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
            int a = ModelHelper.a(flatBufferBuilder, builder.f2511a);
            int b = flatBufferBuilder.b(builder.f2512b);
            int a2 = ModelHelper.a(flatBufferBuilder, builder.f2513c);
            int a3 = ModelHelper.a(flatBufferBuilder, builder.f2514d);
            int b2 = flatBufferBuilder.b(builder.f2515e);
            int a4 = flatBufferBuilder.a(builder.f2516f);
            int a5 = ModelHelper.a(flatBufferBuilder, builder.f2517g);
            flatBufferBuilder.c(7);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, b);
            flatBufferBuilder.b(2, a2);
            flatBufferBuilder.b(3, a3);
            flatBufferBuilder.b(4, b2);
            flatBufferBuilder.b(5, a4);
            flatBufferBuilder.b(6, a5);
            flatBufferBuilder.d(flatBufferBuilder.d());
            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
            wrap.position(0);
            return new SuggestEditsOptionModel(new MutableFlatBuffer(wrap, null, null, true, null));
        }

        public final int jK_() {
            return 1334089258;
        }

        public final GraphQLVisitableModel m2836a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m2830j() != null) {
                FieldIconModel fieldIconModel = (FieldIconModel) graphQLModelMutatingVisitor.b(m2830j());
                if (m2830j() != fieldIconModel) {
                    graphQLVisitableModel = (SuggestEditsOptionModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f2560d = fieldIconModel;
                }
            }
            if (m2831k() != null) {
                OptionIconModel optionIconModel = (OptionIconModel) graphQLModelMutatingVisitor.b(m2831k());
                if (m2831k() != optionIconModel) {
                    graphQLVisitableModel = (SuggestEditsOptionModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f2562f = optionIconModel;
                }
            }
            if (m2832l() != null) {
                OptionSelectedIconModel optionSelectedIconModel = (OptionSelectedIconModel) graphQLModelMutatingVisitor.b(m2832l());
                if (m2832l() != optionSelectedIconModel) {
                    graphQLVisitableModel = (SuggestEditsOptionModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f2563g = optionSelectedIconModel;
                }
            }
            if (m2833m() != null) {
                OptionValueModel optionValueModel = (OptionValueModel) graphQLModelMutatingVisitor.b(m2833m());
                if (m2833m() != optionValueModel) {
                    graphQLVisitableModel = (SuggestEditsOptionModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f2566j = optionValueModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m2834a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m2830j());
            int b = flatBufferBuilder.b(m2837b());
            int a2 = ModelHelper.a(flatBufferBuilder, m2831k());
            int a3 = ModelHelper.a(flatBufferBuilder, m2832l());
            int b2 = flatBufferBuilder.b(ez_());
            int a4 = flatBufferBuilder.a(m2840g());
            int a5 = ModelHelper.a(flatBufferBuilder, m2833m());
            flatBufferBuilder.c(7);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, b);
            flatBufferBuilder.b(2, a2);
            flatBufferBuilder.b(3, a3);
            flatBufferBuilder.b(4, b2);
            flatBufferBuilder.b(5, a4);
            flatBufferBuilder.b(6, a5);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -250927253)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: sync_params/ */
    public final class SuggestEditsSectionModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private FieldSectionsModel f2569d;
        @Nullable
        private String f2570e;

        /* compiled from: sync_params/ */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(SuggestEditsSectionModel.class, new Deserializer());
            }

            public Object m2841a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(SuggestEditsSectionParser.m2960a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object suggestEditsSectionModel = new SuggestEditsSectionModel();
                ((BaseModel) suggestEditsSectionModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (suggestEditsSectionModel instanceof Postprocessable) {
                    return ((Postprocessable) suggestEditsSectionModel).a();
                }
                return suggestEditsSectionModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 1158514898)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: sync_params/ */
        public final class FieldSectionsModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private List<EdgesModel> f2568d;

            /* compiled from: sync_params/ */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(FieldSectionsModel.class, new Deserializer());
                }

                public Object m2842a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(FieldSectionsParser.m2958a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object fieldSectionsModel = new FieldSectionsModel();
                    ((BaseModel) fieldSectionsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (fieldSectionsModel instanceof Postprocessable) {
                        return ((Postprocessable) fieldSectionsModel).a();
                    }
                    return fieldSectionsModel;
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = 1325065945)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: sync_params/ */
            public final class EdgesModel extends BaseModel implements GraphQLVisitableModel {
                @Nullable
                private SuggestEditsFieldModel f2567d;

                /* compiled from: sync_params/ */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(EdgesModel.class, new Deserializer());
                    }

                    public Object m2843a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(FieldSectionsParser.EdgesParser.m2956b(jsonParser, flatBufferBuilder));
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

                /* compiled from: sync_params/ */
                public class Serializer extends JsonSerializer<EdgesModel> {
                    public final void m2844a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        EdgesModel edgesModel = (EdgesModel) obj;
                        if (edgesModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(edgesModel.m2846a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            edgesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        FieldSectionsParser.EdgesParser.m2957b(edgesModel.w_(), edgesModel.u_(), jsonGenerator, serializerProvider);
                    }

                    static {
                        FbSerializerProvider.a(EdgesModel.class, new Serializer());
                    }
                }

                @Nullable
                public final /* synthetic */ SuggestEditsField m2847a() {
                    return m2845j();
                }

                public EdgesModel() {
                    super(1);
                }

                @Nullable
                private SuggestEditsFieldModel m2845j() {
                    this.f2567d = (SuggestEditsFieldModel) super.a(this.f2567d, 0, SuggestEditsFieldModel.class);
                    return this.f2567d;
                }

                public final int jK_() {
                    return -1748063488;
                }

                public final GraphQLVisitableModel m2848a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    GraphQLVisitableModel graphQLVisitableModel = null;
                    h();
                    if (m2845j() != null) {
                        SuggestEditsFieldModel suggestEditsFieldModel = (SuggestEditsFieldModel) graphQLModelMutatingVisitor.b(m2845j());
                        if (m2845j() != suggestEditsFieldModel) {
                            graphQLVisitableModel = (EdgesModel) ModelHelper.a(null, this);
                            graphQLVisitableModel.f2567d = suggestEditsFieldModel;
                        }
                    }
                    i();
                    return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                }

                public final int m2846a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int a = ModelHelper.a(flatBufferBuilder, m2845j());
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.b(0, a);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            /* compiled from: sync_params/ */
            public class Serializer extends JsonSerializer<FieldSectionsModel> {
                public final void m2849a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    FieldSectionsModel fieldSectionsModel = (FieldSectionsModel) obj;
                    if (fieldSectionsModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(fieldSectionsModel.m2850a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        fieldSectionsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    FieldSectionsParser.m2959a(fieldSectionsModel.w_(), fieldSectionsModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(FieldSectionsModel.class, new Serializer());
                }
            }

            public FieldSectionsModel() {
                super(1);
            }

            @Nonnull
            public final ImmutableList<EdgesModel> m2852a() {
                this.f2568d = super.a(this.f2568d, 0, EdgesModel.class);
                return (ImmutableList) this.f2568d;
            }

            public final int jK_() {
                return -1434223135;
            }

            public final GraphQLVisitableModel m2851a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m2852a() != null) {
                    Builder a = ModelHelper.a(m2852a(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        graphQLVisitableModel = (FieldSectionsModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f2568d = a.b();
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m2850a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m2852a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, a);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: sync_params/ */
        public class Serializer extends JsonSerializer<SuggestEditsSectionModel> {
            public final void m2853a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                SuggestEditsSectionModel suggestEditsSectionModel = (SuggestEditsSectionModel) obj;
                if (suggestEditsSectionModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(suggestEditsSectionModel.m2855a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    suggestEditsSectionModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                SuggestEditsSectionParser.m2961a(suggestEditsSectionModel.w_(), suggestEditsSectionModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(SuggestEditsSectionModel.class, new Serializer());
            }
        }

        @Nullable
        public final /* synthetic */ FieldSectionsModel m2856a() {
            return m2854j();
        }

        public SuggestEditsSectionModel() {
            super(2);
        }

        @Nullable
        private FieldSectionsModel m2854j() {
            this.f2569d = (FieldSectionsModel) super.a(this.f2569d, 0, FieldSectionsModel.class);
            return this.f2569d;
        }

        @Nullable
        public final String m2858b() {
            this.f2570e = super.a(this.f2570e, 1);
            return this.f2570e;
        }

        public final int jK_() {
            return -1327730859;
        }

        public final GraphQLVisitableModel m2857a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m2854j() != null) {
                FieldSectionsModel fieldSectionsModel = (FieldSectionsModel) graphQLModelMutatingVisitor.b(m2854j());
                if (m2854j() != fieldSectionsModel) {
                    graphQLVisitableModel = (SuggestEditsSectionModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f2569d = fieldSectionsModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m2855a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m2854j());
            int b = flatBufferBuilder.b(m2858b());
            flatBufferBuilder.c(2);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, b);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -2079875696)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: sync_params/ */
    public final class SuggestEditsSectionsModel extends BaseModel implements GraphQLVisitableConsistentModel {
        @Nullable
        private CrowdsourcingSuggestEditsCardsModel f2573d;
        private int f2574e;

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -229571881)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: sync_params/ */
        public final class CrowdsourcingSuggestEditsCardsModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private List<EdgesModel> f2572d;

            /* compiled from: sync_params/ */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(CrowdsourcingSuggestEditsCardsModel.class, new Deserializer());
                }

                public Object m2859a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(CrowdsourcingSuggestEditsCardsParser.m2964a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object crowdsourcingSuggestEditsCardsModel = new CrowdsourcingSuggestEditsCardsModel();
                    ((BaseModel) crowdsourcingSuggestEditsCardsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (crowdsourcingSuggestEditsCardsModel instanceof Postprocessable) {
                        return ((Postprocessable) crowdsourcingSuggestEditsCardsModel).a();
                    }
                    return crowdsourcingSuggestEditsCardsModel;
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = 1818766788)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: sync_params/ */
            public final class EdgesModel extends BaseModel implements GraphQLVisitableModel {
                @Nullable
                private SuggestEditsSectionModel f2571d;

                /* compiled from: sync_params/ */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(EdgesModel.class, new Deserializer());
                    }

                    public Object m2860a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(CrowdsourcingSuggestEditsCardsParser.EdgesParser.m2962b(jsonParser, flatBufferBuilder));
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

                /* compiled from: sync_params/ */
                public class Serializer extends JsonSerializer<EdgesModel> {
                    public final void m2861a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        EdgesModel edgesModel = (EdgesModel) obj;
                        if (edgesModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(edgesModel.m2863a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            edgesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        CrowdsourcingSuggestEditsCardsParser.EdgesParser.m2963b(edgesModel.w_(), edgesModel.u_(), jsonGenerator, serializerProvider);
                    }

                    static {
                        FbSerializerProvider.a(EdgesModel.class, new Serializer());
                    }
                }

                @Nullable
                public final /* synthetic */ SuggestEditsSectionModel m2864a() {
                    return m2862j();
                }

                public EdgesModel() {
                    super(1);
                }

                @Nullable
                private SuggestEditsSectionModel m2862j() {
                    this.f2571d = (SuggestEditsSectionModel) super.a(this.f2571d, 0, SuggestEditsSectionModel.class);
                    return this.f2571d;
                }

                public final int jK_() {
                    return 2048020123;
                }

                public final GraphQLVisitableModel m2865a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    GraphQLVisitableModel graphQLVisitableModel = null;
                    h();
                    if (m2862j() != null) {
                        SuggestEditsSectionModel suggestEditsSectionModel = (SuggestEditsSectionModel) graphQLModelMutatingVisitor.b(m2862j());
                        if (m2862j() != suggestEditsSectionModel) {
                            graphQLVisitableModel = (EdgesModel) ModelHelper.a(null, this);
                            graphQLVisitableModel.f2571d = suggestEditsSectionModel;
                        }
                    }
                    i();
                    return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                }

                public final int m2863a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int a = ModelHelper.a(flatBufferBuilder, m2862j());
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.b(0, a);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            /* compiled from: sync_params/ */
            public class Serializer extends JsonSerializer<CrowdsourcingSuggestEditsCardsModel> {
                public final void m2866a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    CrowdsourcingSuggestEditsCardsModel crowdsourcingSuggestEditsCardsModel = (CrowdsourcingSuggestEditsCardsModel) obj;
                    if (crowdsourcingSuggestEditsCardsModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(crowdsourcingSuggestEditsCardsModel.m2867a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        crowdsourcingSuggestEditsCardsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    CrowdsourcingSuggestEditsCardsParser.m2965a(crowdsourcingSuggestEditsCardsModel.w_(), crowdsourcingSuggestEditsCardsModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(CrowdsourcingSuggestEditsCardsModel.class, new Serializer());
                }
            }

            public CrowdsourcingSuggestEditsCardsModel() {
                super(1);
            }

            @Nonnull
            public final ImmutableList<EdgesModel> m2869a() {
                this.f2572d = super.a(this.f2572d, 0, EdgesModel.class);
                return (ImmutableList) this.f2572d;
            }

            public final int jK_() {
                return 765903164;
            }

            public final GraphQLVisitableModel m2868a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m2869a() != null) {
                    Builder a = ModelHelper.a(m2869a(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        graphQLVisitableModel = (CrowdsourcingSuggestEditsCardsModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f2572d = a.b();
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m2867a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m2869a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, a);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: sync_params/ */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(SuggestEditsSectionsModel.class, new Deserializer());
            }

            public Object m2870a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = SuggestEditsSectionsParser.m2966a(jsonParser);
                Object suggestEditsSectionsModel = new SuggestEditsSectionsModel();
                ((BaseModel) suggestEditsSectionsModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (suggestEditsSectionsModel instanceof Postprocessable) {
                    return ((Postprocessable) suggestEditsSectionsModel).a();
                }
                return suggestEditsSectionsModel;
            }
        }

        /* compiled from: sync_params/ */
        public class Serializer extends JsonSerializer<SuggestEditsSectionsModel> {
            public final void m2871a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                SuggestEditsSectionsModel suggestEditsSectionsModel = (SuggestEditsSectionsModel) obj;
                if (suggestEditsSectionsModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(suggestEditsSectionsModel.m2873a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    suggestEditsSectionsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = suggestEditsSectionsModel.w_();
                int u_ = suggestEditsSectionsModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("crowdsourcing_suggest_edits_cards");
                    CrowdsourcingSuggestEditsCardsParser.m2965a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                g = mutableFlatBuffer.a(u_, 1, 0);
                if (g != 0) {
                    jsonGenerator.a("recent_claims_count");
                    jsonGenerator.b(g);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(SuggestEditsSectionsModel.class, new Serializer());
            }
        }

        @Nullable
        public final /* synthetic */ CrowdsourcingSuggestEditsCardsModel m2874a() {
            return m2872j();
        }

        public SuggestEditsSectionsModel() {
            super(2);
        }

        public final void m2877a(String str, ConsistencyTuple consistencyTuple) {
            consistencyTuple.a();
        }

        public final void m2878a(String str, Object obj, boolean z) {
        }

        @Nullable
        private CrowdsourcingSuggestEditsCardsModel m2872j() {
            this.f2573d = (CrowdsourcingSuggestEditsCardsModel) super.a(this.f2573d, 0, CrowdsourcingSuggestEditsCardsModel.class);
            return this.f2573d;
        }

        public final int m2879b() {
            a(0, 1);
            return this.f2574e;
        }

        public final int jK_() {
            return 2479791;
        }

        public final GraphQLVisitableModel m2875a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m2872j() != null) {
                CrowdsourcingSuggestEditsCardsModel crowdsourcingSuggestEditsCardsModel = (CrowdsourcingSuggestEditsCardsModel) graphQLModelMutatingVisitor.b(m2872j());
                if (m2872j() != crowdsourcingSuggestEditsCardsModel) {
                    graphQLVisitableModel = (SuggestEditsSectionsModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f2573d = crowdsourcingSuggestEditsCardsModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m2873a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m2872j());
            flatBufferBuilder.c(2);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.a(1, this.f2574e, 0);
            i();
            return flatBufferBuilder.d();
        }

        public final void m2876a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
            super.a(mutableFlatBuffer, i, obj);
            this.f2574e = mutableFlatBuffer.a(i, 1, 0);
        }
    }
}
