package com.facebook.nearby.v2.network;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbSerializerProvider;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.entitycards.contextitems.graphql.ContextItemsQueryModels.FBFullImageFragmentModel;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.FragmentModelWithoutBridge;
import com.facebook.flatbuffers.ModelWithFlatBufferFormatHash;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.enums.GraphQLPageCategoryType;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.modelutil.SerializerHelpers;
import com.facebook.graphql.visitor.ConsistencyTuple;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLPersistableNode;
import com.facebook.graphql.visitor.GraphQLVisitableConsistentModel;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.facebook.nearby.v2.network.NearbyPlacesTypeaheadGraphQLParsers.FBNearbyPlacesLocationSearchQueryParser;
import com.facebook.nearby.v2.network.NearbyPlacesTypeaheadGraphQLParsers.FBNearbyPlacesLocationSearchQueryParser.LocationsParser;
import com.facebook.nearby.v2.network.NearbyPlacesTypeaheadGraphQLParsers.FBNearbyPlacesPlacesAndTopicsQueryParser;
import com.facebook.nearby.v2.network.NearbyPlacesTypeaheadGraphQLParsers.FBNearbyPlacesPlacesAndTopicsQueryParser.TypeaheadPlacesParser;
import com.facebook.nearby.v2.network.NearbyPlacesTypeaheadGraphQLParsers.FBNearbyPlacesTypeaheadLocationResultsConnectionFragmentParser;
import com.facebook.nearby.v2.network.NearbyPlacesTypeaheadGraphQLParsers.FBNearbyPlacesTypeaheadLocationResultsConnectionFragmentParser.EdgesParser;
import com.facebook.nearby.v2.network.NearbyPlacesTypeaheadGraphQLParsers.FBNearbyPlacesTypeaheadLocationResultsConnectionFragmentParser.EdgesParser.NodeParser;
import com.facebook.nearby.v2.network.NearbyPlacesTypeaheadGraphQLParsers.FBNearbyPlacesTypeaheadLocationResultsConnectionFragmentParser.EdgesParser.NodeParser.LocationParser;
import com.facebook.nearby.v2.network.NearbyPlacesTypeaheadGraphQLParsers.FBNearbyPlacesTypeaheadPlaceFragmentParser;
import com.facebook.nearby.v2.network.NearbyPlacesTypeaheadGraphQLParsers.FBNearbyPlacesTypeaheadPlaceFragmentParser.AddressParser;
import com.facebook.nearby.v2.network.NearbyPlacesTypeaheadGraphQLParsers.FBNearbyPlacesTypeaheadPlaceResultsConnectionFragmentParser;
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

/* compiled from: depth */
public class NearbyPlacesTypeaheadGraphQLModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -606345712)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: depth */
    public final class FBNearbyPlacesLocationSearchQueryModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private LocationsModel f15749d;

        /* compiled from: depth */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(FBNearbyPlacesLocationSearchQueryModel.class, new Deserializer());
            }

            public Object m18497a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = FBNearbyPlacesLocationSearchQueryParser.m18583a(jsonParser);
                Object fBNearbyPlacesLocationSearchQueryModel = new FBNearbyPlacesLocationSearchQueryModel();
                ((BaseModel) fBNearbyPlacesLocationSearchQueryModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (fBNearbyPlacesLocationSearchQueryModel instanceof Postprocessable) {
                    return ((Postprocessable) fBNearbyPlacesLocationSearchQueryModel).a();
                }
                return fBNearbyPlacesLocationSearchQueryModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 2064941577)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: depth */
        public final class LocationsModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private List<EdgesModel> f15747d;
            @Nullable
            private String f15748e;

            /* compiled from: depth */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(LocationsModel.class, new Deserializer());
                }

                public Object m18498a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(LocationsParser.m18581a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object locationsModel = new LocationsModel();
                    ((BaseModel) locationsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (locationsModel instanceof Postprocessable) {
                        return ((Postprocessable) locationsModel).a();
                    }
                    return locationsModel;
                }
            }

            /* compiled from: depth */
            public class Serializer extends JsonSerializer<LocationsModel> {
                public final void m18499a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    LocationsModel locationsModel = (LocationsModel) obj;
                    if (locationsModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(locationsModel.m18500a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        locationsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    LocationsParser.m18582a(locationsModel.w_(), locationsModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(LocationsModel.class, new Serializer());
                }
            }

            public LocationsModel() {
                super(2);
            }

            @Nonnull
            public final ImmutableList<EdgesModel> m18502a() {
                this.f15747d = super.a(this.f15747d, 0, EdgesModel.class);
                return (ImmutableList) this.f15747d;
            }

            @Nullable
            public final String m18503j() {
                this.f15748e = super.a(this.f15748e, 1);
                return this.f15748e;
            }

            public final int jK_() {
                return 1773207651;
            }

            public final GraphQLVisitableModel m18501a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m18502a() != null) {
                    Builder a = ModelHelper.a(m18502a(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        graphQLVisitableModel = (LocationsModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f15747d = a.b();
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m18500a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m18502a());
                int b = flatBufferBuilder.b(m18503j());
                flatBufferBuilder.c(2);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.b(1, b);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: depth */
        public class Serializer extends JsonSerializer<FBNearbyPlacesLocationSearchQueryModel> {
            public final void m18504a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                FBNearbyPlacesLocationSearchQueryModel fBNearbyPlacesLocationSearchQueryModel = (FBNearbyPlacesLocationSearchQueryModel) obj;
                if (fBNearbyPlacesLocationSearchQueryModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(fBNearbyPlacesLocationSearchQueryModel.m18505a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    fBNearbyPlacesLocationSearchQueryModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = fBNearbyPlacesLocationSearchQueryModel.w_();
                int u_ = fBNearbyPlacesLocationSearchQueryModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("locations");
                    LocationsParser.m18582a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(FBNearbyPlacesLocationSearchQueryModel.class, new Serializer());
            }
        }

        public FBNearbyPlacesLocationSearchQueryModel() {
            super(1);
        }

        @Nullable
        public final LocationsModel m18507a() {
            this.f15749d = (LocationsModel) super.a(this.f15749d, 0, LocationsModel.class);
            return this.f15749d;
        }

        public final int jK_() {
            return 1725273057;
        }

        public final GraphQLVisitableModel m18506a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m18507a() != null) {
                LocationsModel locationsModel = (LocationsModel) graphQLModelMutatingVisitor.b(m18507a());
                if (m18507a() != locationsModel) {
                    graphQLVisitableModel = (FBNearbyPlacesLocationSearchQueryModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f15749d = locationsModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m18505a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m18507a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 1739305996)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: depth */
    public final class FBNearbyPlacesPlacesAndTopicsQueryModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private List<String> f15752d;
        @Nullable
        private TypeaheadPlacesModel f15753e;

        /* compiled from: depth */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(FBNearbyPlacesPlacesAndTopicsQueryModel.class, new Deserializer());
            }

            public Object m18508a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = FBNearbyPlacesPlacesAndTopicsQueryParser.m18586a(jsonParser);
                Object fBNearbyPlacesPlacesAndTopicsQueryModel = new FBNearbyPlacesPlacesAndTopicsQueryModel();
                ((BaseModel) fBNearbyPlacesPlacesAndTopicsQueryModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (fBNearbyPlacesPlacesAndTopicsQueryModel instanceof Postprocessable) {
                    return ((Postprocessable) fBNearbyPlacesPlacesAndTopicsQueryModel).a();
                }
                return fBNearbyPlacesPlacesAndTopicsQueryModel;
            }
        }

        /* compiled from: depth */
        public class Serializer extends JsonSerializer<FBNearbyPlacesPlacesAndTopicsQueryModel> {
            public final void m18509a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                FBNearbyPlacesPlacesAndTopicsQueryModel fBNearbyPlacesPlacesAndTopicsQueryModel = (FBNearbyPlacesPlacesAndTopicsQueryModel) obj;
                if (fBNearbyPlacesPlacesAndTopicsQueryModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(fBNearbyPlacesPlacesAndTopicsQueryModel.m18516a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    fBNearbyPlacesPlacesAndTopicsQueryModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = fBNearbyPlacesPlacesAndTopicsQueryModel.w_();
                int u_ = fBNearbyPlacesPlacesAndTopicsQueryModel.u_();
                jsonGenerator.f();
                if (mutableFlatBuffer.g(u_, 0) != 0) {
                    jsonGenerator.a("query_suggestions");
                    SerializerHelpers.a(mutableFlatBuffer.f(u_, 0), jsonGenerator);
                }
                int g = mutableFlatBuffer.g(u_, 1);
                if (g != 0) {
                    jsonGenerator.a("typeahead_places");
                    TypeaheadPlacesParser.m18585a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(FBNearbyPlacesPlacesAndTopicsQueryModel.class, new Serializer());
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1349353224)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: depth */
        public final class TypeaheadPlacesModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private List<EdgesModel> f15750d;
            @Nullable
            private String f15751e;

            /* compiled from: depth */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(TypeaheadPlacesModel.class, new Deserializer());
                }

                public Object m18510a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(TypeaheadPlacesParser.m18584a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object typeaheadPlacesModel = new TypeaheadPlacesModel();
                    ((BaseModel) typeaheadPlacesModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (typeaheadPlacesModel instanceof Postprocessable) {
                        return ((Postprocessable) typeaheadPlacesModel).a();
                    }
                    return typeaheadPlacesModel;
                }
            }

            /* compiled from: depth */
            public class Serializer extends JsonSerializer<TypeaheadPlacesModel> {
                public final void m18511a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    TypeaheadPlacesModel typeaheadPlacesModel = (TypeaheadPlacesModel) obj;
                    if (typeaheadPlacesModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(typeaheadPlacesModel.m18512a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        typeaheadPlacesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    TypeaheadPlacesParser.m18585a(typeaheadPlacesModel.w_(), typeaheadPlacesModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(TypeaheadPlacesModel.class, new Serializer());
                }
            }

            public TypeaheadPlacesModel() {
                super(2);
            }

            @Nonnull
            public final ImmutableList<EdgesModel> m18514a() {
                this.f15750d = super.a(this.f15750d, 0, EdgesModel.class);
                return (ImmutableList) this.f15750d;
            }

            @Nullable
            public final String m18515j() {
                this.f15751e = super.a(this.f15751e, 1);
                return this.f15751e;
            }

            public final int jK_() {
                return -1390256247;
            }

            public final GraphQLVisitableModel m18513a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m18514a() != null) {
                    Builder a = ModelHelper.a(m18514a(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        graphQLVisitableModel = (TypeaheadPlacesModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f15750d = a.b();
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m18512a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m18514a());
                int b = flatBufferBuilder.b(m18515j());
                flatBufferBuilder.c(2);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.b(1, b);
                i();
                return flatBufferBuilder.d();
            }
        }

        public FBNearbyPlacesPlacesAndTopicsQueryModel() {
            super(2);
        }

        @Nonnull
        public final ImmutableList<String> m18518a() {
            this.f15752d = super.a(this.f15752d, 0);
            return (ImmutableList) this.f15752d;
        }

        @Nullable
        public final TypeaheadPlacesModel m18519j() {
            this.f15753e = (TypeaheadPlacesModel) super.a(this.f15753e, 1, TypeaheadPlacesModel.class);
            return this.f15753e;
        }

        public final int jK_() {
            return 1725273057;
        }

        public final GraphQLVisitableModel m18517a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m18519j() != null) {
                TypeaheadPlacesModel typeaheadPlacesModel = (TypeaheadPlacesModel) graphQLModelMutatingVisitor.b(m18519j());
                if (m18519j() != typeaheadPlacesModel) {
                    graphQLVisitableModel = (FBNearbyPlacesPlacesAndTopicsQueryModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f15753e = typeaheadPlacesModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m18516a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int c = flatBufferBuilder.c(m18518a());
            int a = ModelHelper.a(flatBufferBuilder, m18519j());
            flatBufferBuilder.c(2);
            flatBufferBuilder.b(0, c);
            flatBufferBuilder.b(1, a);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -929889386)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: depth */
    public final class FBNearbyPlacesTypeaheadLocationResultsConnectionFragmentModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private List<EdgesModel> f15761d;

        /* compiled from: depth */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(FBNearbyPlacesTypeaheadLocationResultsConnectionFragmentModel.class, new Deserializer());
            }

            public Object m18520a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = FBNearbyPlacesTypeaheadLocationResultsConnectionFragmentParser.m18595a(jsonParser);
                Object fBNearbyPlacesTypeaheadLocationResultsConnectionFragmentModel = new FBNearbyPlacesTypeaheadLocationResultsConnectionFragmentModel();
                ((BaseModel) fBNearbyPlacesTypeaheadLocationResultsConnectionFragmentModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (fBNearbyPlacesTypeaheadLocationResultsConnectionFragmentModel instanceof Postprocessable) {
                    return ((Postprocessable) fBNearbyPlacesTypeaheadLocationResultsConnectionFragmentModel).a();
                }
                return fBNearbyPlacesTypeaheadLocationResultsConnectionFragmentModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 597191725)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: depth */
        public final class EdgesModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private NodeModel f15760d;

            /* compiled from: depth */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(EdgesModel.class, new Deserializer());
                }

                public Object m18521a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(EdgesParser.m18593b(jsonParser, flatBufferBuilder));
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
            @ModelWithFlatBufferFormatHash(a = -530243494)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: depth */
            public final class NodeModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
                @Nullable
                private GraphQLPageCategoryType f15756d;
                @Nullable
                private String f15757e;
                @Nullable
                private LocationModel f15758f;
                @Nullable
                private String f15759g;

                /* compiled from: depth */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(NodeModel.class, new Deserializer());
                    }

                    public Object m18522a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(NodeParser.m18589a(jsonParser, flatBufferBuilder));
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

                @JsonDeserialize(using = Deserializer.class)
                @ModelWithFlatBufferFormatHash(a = 918622653)
                @JsonSerialize(using = Serializer.class)
                @FragmentModelWithoutBridge
                /* compiled from: depth */
                public final class LocationModel extends BaseModel implements GraphQLVisitableModel {
                    private double f15754d;
                    private double f15755e;

                    /* compiled from: depth */
                    public class Deserializer extends FbJsonDeserializer {
                        static {
                            GlobalAutoGenDeserializerCache.a(LocationModel.class, new Deserializer());
                        }

                        public Object m18523a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(LocationParser.m18587a(jsonParser, flatBufferBuilder));
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

                    /* compiled from: depth */
                    public class Serializer extends JsonSerializer<LocationModel> {
                        public final void m18524a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                            LocationModel locationModel = (LocationModel) obj;
                            if (locationModel.w_() == null) {
                                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                flatBufferBuilder.d(locationModel.m18526a(flatBufferBuilder));
                                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                wrap.position(0);
                                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                locationModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                            }
                            LocationParser.m18588a(locationModel.w_(), locationModel.u_(), jsonGenerator);
                        }

                        static {
                            FbSerializerProvider.a(LocationModel.class, new Serializer());
                        }
                    }

                    public LocationModel() {
                        super(2);
                    }

                    public final double m18525a() {
                        a(0, 0);
                        return this.f15754d;
                    }

                    public final double m18529j() {
                        a(0, 1);
                        return this.f15755e;
                    }

                    public final int jK_() {
                        return 1965687765;
                    }

                    public final GraphQLVisitableModel m18527a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                        h();
                        i();
                        return this;
                    }

                    public final int m18526a(FlatBufferBuilder flatBufferBuilder) {
                        h();
                        flatBufferBuilder.c(2);
                        flatBufferBuilder.a(0, this.f15754d, 0.0d);
                        flatBufferBuilder.a(1, this.f15755e, 0.0d);
                        i();
                        return flatBufferBuilder.d();
                    }

                    public final void m18528a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                        super.a(mutableFlatBuffer, i, obj);
                        this.f15754d = mutableFlatBuffer.a(i, 0, 0.0d);
                        this.f15755e = mutableFlatBuffer.a(i, 1, 0.0d);
                    }
                }

                /* compiled from: depth */
                public class Serializer extends JsonSerializer<NodeModel> {
                    public final void m18530a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        NodeModel nodeModel = (NodeModel) obj;
                        if (nodeModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(nodeModel.m18532a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            nodeModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        NodeParser.m18590a(nodeModel.w_(), nodeModel.u_(), jsonGenerator, serializerProvider);
                    }

                    static {
                        FbSerializerProvider.a(NodeModel.class, new Serializer());
                    }
                }

                public NodeModel() {
                    super(4);
                }

                public final void m18535a(String str, ConsistencyTuple consistencyTuple) {
                    consistencyTuple.a();
                }

                public final void m18536a(String str, Object obj, boolean z) {
                }

                @Nullable
                private GraphQLPageCategoryType m18531m() {
                    this.f15756d = (GraphQLPageCategoryType) super.b(this.f15756d, 0, GraphQLPageCategoryType.class, GraphQLPageCategoryType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
                    return this.f15756d;
                }

                @Nullable
                public final String m18537j() {
                    this.f15757e = super.a(this.f15757e, 1);
                    return this.f15757e;
                }

                @Nullable
                public final LocationModel m18538k() {
                    this.f15758f = (LocationModel) super.a(this.f15758f, 2, LocationModel.class);
                    return this.f15758f;
                }

                @Nullable
                public final String m18539l() {
                    this.f15759g = super.a(this.f15759g, 3);
                    return this.f15759g;
                }

                @Nullable
                public final String m18534a() {
                    return m18537j();
                }

                public final int jK_() {
                    return 2479791;
                }

                public final GraphQLVisitableModel m18533a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    GraphQLVisitableModel graphQLVisitableModel = null;
                    h();
                    if (m18538k() != null) {
                        LocationModel locationModel = (LocationModel) graphQLModelMutatingVisitor.b(m18538k());
                        if (m18538k() != locationModel) {
                            graphQLVisitableModel = (NodeModel) ModelHelper.a(null, this);
                            graphQLVisitableModel.f15758f = locationModel;
                        }
                    }
                    i();
                    return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                }

                public final int m18532a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int a = flatBufferBuilder.a(m18531m());
                    int b = flatBufferBuilder.b(m18537j());
                    int a2 = ModelHelper.a(flatBufferBuilder, m18538k());
                    int b2 = flatBufferBuilder.b(m18539l());
                    flatBufferBuilder.c(4);
                    flatBufferBuilder.b(0, a);
                    flatBufferBuilder.b(1, b);
                    flatBufferBuilder.b(2, a2);
                    flatBufferBuilder.b(3, b2);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            /* compiled from: depth */
            public class Serializer extends JsonSerializer<EdgesModel> {
                public final void m18540a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    EdgesModel edgesModel = (EdgesModel) obj;
                    if (edgesModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(edgesModel.m18541a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        edgesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    EdgesParser.m18594b(edgesModel.w_(), edgesModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(EdgesModel.class, new Serializer());
                }
            }

            public EdgesModel() {
                super(1);
            }

            @Nullable
            public final NodeModel m18543a() {
                this.f15760d = (NodeModel) super.a(this.f15760d, 0, NodeModel.class);
                return this.f15760d;
            }

            public final int jK_() {
                return -1645693182;
            }

            public final GraphQLVisitableModel m18542a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m18543a() != null) {
                    NodeModel nodeModel = (NodeModel) graphQLModelMutatingVisitor.b(m18543a());
                    if (m18543a() != nodeModel) {
                        graphQLVisitableModel = (EdgesModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f15760d = nodeModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m18541a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m18543a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, a);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: depth */
        public class Serializer extends JsonSerializer<FBNearbyPlacesTypeaheadLocationResultsConnectionFragmentModel> {
            public final void m18544a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                FBNearbyPlacesTypeaheadLocationResultsConnectionFragmentModel fBNearbyPlacesTypeaheadLocationResultsConnectionFragmentModel = (FBNearbyPlacesTypeaheadLocationResultsConnectionFragmentModel) obj;
                if (fBNearbyPlacesTypeaheadLocationResultsConnectionFragmentModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(fBNearbyPlacesTypeaheadLocationResultsConnectionFragmentModel.m18546a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    fBNearbyPlacesTypeaheadLocationResultsConnectionFragmentModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = fBNearbyPlacesTypeaheadLocationResultsConnectionFragmentModel.w_();
                int u_ = fBNearbyPlacesTypeaheadLocationResultsConnectionFragmentModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("edges");
                    EdgesParser.m18592a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(FBNearbyPlacesTypeaheadLocationResultsConnectionFragmentModel.class, new Serializer());
            }
        }

        public FBNearbyPlacesTypeaheadLocationResultsConnectionFragmentModel() {
            super(1);
        }

        @Nonnull
        private ImmutableList<EdgesModel> m18545a() {
            this.f15761d = super.a(this.f15761d, 0, EdgesModel.class);
            return (ImmutableList) this.f15761d;
        }

        public final int jK_() {
            return 1773207651;
        }

        public final GraphQLVisitableModel m18547a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m18545a() != null) {
                Builder a = ModelHelper.a(m18545a(), graphQLModelMutatingVisitor);
                if (a != null) {
                    graphQLVisitableModel = (FBNearbyPlacesTypeaheadLocationResultsConnectionFragmentModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f15761d = a.b();
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m18546a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m18545a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 1600796535)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: depth */
    public final class FBNearbyPlacesTypeaheadPlaceFragmentModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
        @Nullable
        private AddressModel f15766d;
        @Nullable
        private String f15767e;
        @Nullable
        private LocationModel f15768f;
        @Nullable
        private String f15769g;
        @Nullable
        private FBFullImageFragmentModel f15770h;

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1492488211)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: depth */
        public final class AddressModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private String f15762d;
            @Nullable
            private String f15763e;

            /* compiled from: depth */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(AddressModel.class, new Deserializer());
                }

                public Object m18548a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(AddressParser.m18596a(jsonParser, flatBufferBuilder));
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

            /* compiled from: depth */
            public class Serializer extends JsonSerializer<AddressModel> {
                public final void m18549a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    AddressModel addressModel = (AddressModel) obj;
                    if (addressModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(addressModel.m18551a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        addressModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    AddressParser.m18597a(addressModel.w_(), addressModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(AddressModel.class, new Serializer());
                }
            }

            public AddressModel() {
                super(2);
            }

            @Nullable
            private String m18550j() {
                this.f15762d = super.a(this.f15762d, 0);
                return this.f15762d;
            }

            @Nullable
            public final String m18553a() {
                this.f15763e = super.a(this.f15763e, 1);
                return this.f15763e;
            }

            public final int jK_() {
                return 799251025;
            }

            public final GraphQLVisitableModel m18552a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m18551a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m18550j());
                int b2 = flatBufferBuilder.b(m18553a());
                flatBufferBuilder.c(2);
                flatBufferBuilder.b(0, b);
                flatBufferBuilder.b(1, b2);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: depth */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(FBNearbyPlacesTypeaheadPlaceFragmentModel.class, new Deserializer());
            }

            public Object m18554a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(FBNearbyPlacesTypeaheadPlaceFragmentParser.m18600a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object fBNearbyPlacesTypeaheadPlaceFragmentModel = new FBNearbyPlacesTypeaheadPlaceFragmentModel();
                ((BaseModel) fBNearbyPlacesTypeaheadPlaceFragmentModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (fBNearbyPlacesTypeaheadPlaceFragmentModel instanceof Postprocessable) {
                    return ((Postprocessable) fBNearbyPlacesTypeaheadPlaceFragmentModel).a();
                }
                return fBNearbyPlacesTypeaheadPlaceFragmentModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 918622653)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: depth */
        public final class LocationModel extends BaseModel implements GraphQLVisitableModel {
            private double f15764d;
            private double f15765e;

            /* compiled from: depth */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(LocationModel.class, new Deserializer());
                }

                public Object m18555a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(FBNearbyPlacesTypeaheadPlaceFragmentParser.LocationParser.m18598a(jsonParser, flatBufferBuilder));
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

            /* compiled from: depth */
            public class Serializer extends JsonSerializer<LocationModel> {
                public final void m18556a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    LocationModel locationModel = (LocationModel) obj;
                    if (locationModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(locationModel.m18557a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        locationModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    FBNearbyPlacesTypeaheadPlaceFragmentParser.LocationParser.m18599a(locationModel.w_(), locationModel.u_(), jsonGenerator);
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

            public final GraphQLVisitableModel m18558a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m18557a(FlatBufferBuilder flatBufferBuilder) {
                h();
                flatBufferBuilder.c(2);
                flatBufferBuilder.a(0, this.f15764d, 0.0d);
                flatBufferBuilder.a(1, this.f15765e, 0.0d);
                i();
                return flatBufferBuilder.d();
            }

            public final void m18559a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                super.a(mutableFlatBuffer, i, obj);
                this.f15764d = mutableFlatBuffer.a(i, 0, 0.0d);
                this.f15765e = mutableFlatBuffer.a(i, 1, 0.0d);
            }
        }

        /* compiled from: depth */
        public class Serializer extends JsonSerializer<FBNearbyPlacesTypeaheadPlaceFragmentModel> {
            public final void m18560a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                FBNearbyPlacesTypeaheadPlaceFragmentModel fBNearbyPlacesTypeaheadPlaceFragmentModel = (FBNearbyPlacesTypeaheadPlaceFragmentModel) obj;
                if (fBNearbyPlacesTypeaheadPlaceFragmentModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(fBNearbyPlacesTypeaheadPlaceFragmentModel.m18562a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    fBNearbyPlacesTypeaheadPlaceFragmentModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                FBNearbyPlacesTypeaheadPlaceFragmentParser.m18601a(fBNearbyPlacesTypeaheadPlaceFragmentModel.w_(), fBNearbyPlacesTypeaheadPlaceFragmentModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(FBNearbyPlacesTypeaheadPlaceFragmentModel.class, new Serializer());
            }
        }

        public FBNearbyPlacesTypeaheadPlaceFragmentModel() {
            super(5);
        }

        public final void m18565a(String str, ConsistencyTuple consistencyTuple) {
            consistencyTuple.a();
        }

        public final void m18566a(String str, Object obj, boolean z) {
        }

        @Nullable
        public final AddressModel m18567j() {
            this.f15766d = (AddressModel) super.a(this.f15766d, 0, AddressModel.class);
            return this.f15766d;
        }

        @Nullable
        public final String m18568k() {
            this.f15767e = super.a(this.f15767e, 1);
            return this.f15767e;
        }

        @Nullable
        private LocationModel m18561n() {
            this.f15768f = (LocationModel) super.a(this.f15768f, 2, LocationModel.class);
            return this.f15768f;
        }

        @Nullable
        public final String m18569l() {
            this.f15769g = super.a(this.f15769g, 3);
            return this.f15769g;
        }

        @Nullable
        public final FBFullImageFragmentModel m18570m() {
            this.f15770h = (FBFullImageFragmentModel) super.a(this.f15770h, 4, FBFullImageFragmentModel.class);
            return this.f15770h;
        }

        @Nullable
        public final String m18564a() {
            return m18568k();
        }

        public final int jK_() {
            return 2479791;
        }

        public final GraphQLVisitableModel m18563a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m18567j() != null) {
                AddressModel addressModel = (AddressModel) graphQLModelMutatingVisitor.b(m18567j());
                if (m18567j() != addressModel) {
                    graphQLVisitableModel = (FBNearbyPlacesTypeaheadPlaceFragmentModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f15766d = addressModel;
                }
            }
            if (m18561n() != null) {
                LocationModel locationModel = (LocationModel) graphQLModelMutatingVisitor.b(m18561n());
                if (m18561n() != locationModel) {
                    graphQLVisitableModel = (FBNearbyPlacesTypeaheadPlaceFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f15768f = locationModel;
                }
            }
            if (m18570m() != null) {
                FBFullImageFragmentModel fBFullImageFragmentModel = (FBFullImageFragmentModel) graphQLModelMutatingVisitor.b(m18570m());
                if (m18570m() != fBFullImageFragmentModel) {
                    graphQLVisitableModel = (FBNearbyPlacesTypeaheadPlaceFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f15770h = fBFullImageFragmentModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m18562a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m18567j());
            int b = flatBufferBuilder.b(m18568k());
            int a2 = ModelHelper.a(flatBufferBuilder, m18561n());
            int b2 = flatBufferBuilder.b(m18569l());
            int a3 = ModelHelper.a(flatBufferBuilder, m18570m());
            flatBufferBuilder.c(5);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, b);
            flatBufferBuilder.b(2, a2);
            flatBufferBuilder.b(3, b2);
            flatBufferBuilder.b(4, a3);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -940012781)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: depth */
    public final class FBNearbyPlacesTypeaheadPlaceResultsConnectionFragmentModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private List<EdgesModel> f15772d;

        /* compiled from: depth */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(FBNearbyPlacesTypeaheadPlaceResultsConnectionFragmentModel.class, new Deserializer());
            }

            public Object m18571a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = FBNearbyPlacesTypeaheadPlaceResultsConnectionFragmentParser.m18606a(jsonParser);
                Object fBNearbyPlacesTypeaheadPlaceResultsConnectionFragmentModel = new FBNearbyPlacesTypeaheadPlaceResultsConnectionFragmentModel();
                ((BaseModel) fBNearbyPlacesTypeaheadPlaceResultsConnectionFragmentModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (fBNearbyPlacesTypeaheadPlaceResultsConnectionFragmentModel instanceof Postprocessable) {
                    return ((Postprocessable) fBNearbyPlacesTypeaheadPlaceResultsConnectionFragmentModel).a();
                }
                return fBNearbyPlacesTypeaheadPlaceResultsConnectionFragmentModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 2113576621)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: depth */
        public final class EdgesModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private FBNearbyPlacesTypeaheadPlaceFragmentModel f15771d;

            /* compiled from: depth */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(EdgesModel.class, new Deserializer());
                }

                public Object m18572a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(FBNearbyPlacesTypeaheadPlaceResultsConnectionFragmentParser.EdgesParser.m18604b(jsonParser, flatBufferBuilder));
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

            /* compiled from: depth */
            public class Serializer extends JsonSerializer<EdgesModel> {
                public final void m18573a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    EdgesModel edgesModel = (EdgesModel) obj;
                    if (edgesModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(edgesModel.m18574a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        edgesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    FBNearbyPlacesTypeaheadPlaceResultsConnectionFragmentParser.EdgesParser.m18605b(edgesModel.w_(), edgesModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(EdgesModel.class, new Serializer());
                }
            }

            public EdgesModel() {
                super(1);
            }

            @Nullable
            public final FBNearbyPlacesTypeaheadPlaceFragmentModel m18576a() {
                this.f15771d = (FBNearbyPlacesTypeaheadPlaceFragmentModel) super.a(this.f15771d, 0, FBNearbyPlacesTypeaheadPlaceFragmentModel.class);
                return this.f15771d;
            }

            public final int jK_() {
                return 755100328;
            }

            public final GraphQLVisitableModel m18575a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m18576a() != null) {
                    FBNearbyPlacesTypeaheadPlaceFragmentModel fBNearbyPlacesTypeaheadPlaceFragmentModel = (FBNearbyPlacesTypeaheadPlaceFragmentModel) graphQLModelMutatingVisitor.b(m18576a());
                    if (m18576a() != fBNearbyPlacesTypeaheadPlaceFragmentModel) {
                        graphQLVisitableModel = (EdgesModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f15771d = fBNearbyPlacesTypeaheadPlaceFragmentModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m18574a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m18576a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, a);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: depth */
        public class Serializer extends JsonSerializer<FBNearbyPlacesTypeaheadPlaceResultsConnectionFragmentModel> {
            public final void m18577a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                FBNearbyPlacesTypeaheadPlaceResultsConnectionFragmentModel fBNearbyPlacesTypeaheadPlaceResultsConnectionFragmentModel = (FBNearbyPlacesTypeaheadPlaceResultsConnectionFragmentModel) obj;
                if (fBNearbyPlacesTypeaheadPlaceResultsConnectionFragmentModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(fBNearbyPlacesTypeaheadPlaceResultsConnectionFragmentModel.m18579a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    fBNearbyPlacesTypeaheadPlaceResultsConnectionFragmentModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = fBNearbyPlacesTypeaheadPlaceResultsConnectionFragmentModel.w_();
                int u_ = fBNearbyPlacesTypeaheadPlaceResultsConnectionFragmentModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("edges");
                    FBNearbyPlacesTypeaheadPlaceResultsConnectionFragmentParser.EdgesParser.m18603a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(FBNearbyPlacesTypeaheadPlaceResultsConnectionFragmentModel.class, new Serializer());
            }
        }

        public FBNearbyPlacesTypeaheadPlaceResultsConnectionFragmentModel() {
            super(1);
        }

        @Nonnull
        private ImmutableList<EdgesModel> m18578a() {
            this.f15772d = super.a(this.f15772d, 0, EdgesModel.class);
            return (ImmutableList) this.f15772d;
        }

        public final int jK_() {
            return -1390256247;
        }

        public final GraphQLVisitableModel m18580a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m18578a() != null) {
                Builder a = ModelHelper.a(m18578a(), graphQLModelMutatingVisitor);
                if (a != null) {
                    graphQLVisitableModel = (FBNearbyPlacesTypeaheadPlaceResultsConnectionFragmentModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f15772d = a.b();
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m18579a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m18578a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }
}
