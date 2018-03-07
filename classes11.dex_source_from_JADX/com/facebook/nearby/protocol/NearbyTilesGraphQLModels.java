package com.facebook.nearby.protocol;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbSerializerProvider;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.FragmentModelWithoutBridge;
import com.facebook.flatbuffers.ModelWithFlatBufferFormatHash;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.enums.GraphQLPlaceType;
import com.facebook.graphql.enums.GraphQLSavedState;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.querybuilder.common.CommonGraphQLModels.DefaultLocationFieldsModel;
import com.facebook.graphql.visitor.ConsistencyTuple;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLPersistableNode;
import com.facebook.graphql.visitor.GraphQLVisitableConsistentModel;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.facebook.nearby.protocol.FetchNearbyPlacesGraphQLFragmentsModels.NearbyFacepilesFragmentModel;
import com.facebook.nearby.protocol.NearbyTilesGraphQLParsers.NearbyGeoRectangleParser;
import com.facebook.nearby.protocol.NearbyTilesGraphQLParsers.NearbyTilesParser;
import com.facebook.nearby.protocol.NearbyTilesGraphQLParsers.NearbyTilesParser.TilesParser;
import com.facebook.nearby.protocol.NearbyTilesGraphQLParsers.NearbyTilesParser.TilesParser.EdgesParser;
import com.facebook.nearby.protocol.NearbyTilesGraphQLParsers.NearbyTilesParser.TilesParser.EdgesParser.NodeParser;
import com.facebook.nearby.protocol.NearbyTilesGraphQLParsers.NearbyTilesParser.TilesParser.EdgesParser.NodeParser.PlacesRenderPriority1Parser;
import com.facebook.nearby.protocol.NearbyTilesGraphQLParsers.NearbyTilesParser.TilesParser.EdgesParser.NodeParser.PlacesRenderPriority1Parser.PlacesRenderPriority1EdgesParser;
import com.facebook.nearby.protocol.NearbyTilesGraphQLParsers.NearbyTilesParser.TilesParser.EdgesParser.NodeParser.PlacesRenderPriority1Parser.PlacesRenderPriority1EdgesParser.PlacesRenderPriority1EdgesNodeParser;
import com.facebook.nearby.protocol.NearbyTilesGraphQLParsers.NearbyTilesParser.TilesParser.EdgesParser.NodeParser.PlacesRenderPriority1Parser.PlacesRenderPriority1EdgesParser.PlacesRenderPriority1EdgesNodeParser.AddressParser;
import com.facebook.nearby.protocol.NearbyTilesGraphQLParsers.NearbyTilesParser.TilesParser.EdgesParser.NodeParser.PlacesRenderPriority1Parser.PlacesRenderPriority1EdgesParser.PlacesRenderPriority1EdgesNodeParser.PageLikersParser;
import com.facebook.nearby.protocol.NearbyTilesGraphQLParsers.NearbyTilesParser.TilesParser.EdgesParser.NodeParser.PlacesRenderPriority1Parser.PlacesRenderPriority1EdgesParser.PlacesRenderPriority1EdgesNodeParser.PageVisitsParser;
import com.facebook.nearby.protocol.NearbyTilesGraphQLParsers.NearbyTilesParser.TilesParser.EdgesParser.NodeParser.PlacesRenderPriority1Parser.PlacesRenderPriority1EdgesParser.PlacesRenderPriority1EdgesNodeParser.PhoneNumberParser;
import com.facebook.nearby.protocol.NearbyTilesGraphQLParsers.NearbyTilesParser.TilesParser.EdgesParser.NodeParser.PlacesRenderPriority1Parser.PlacesRenderPriority1EdgesParser.PlacesRenderPriority1EdgesNodeParser.ProfilePictureParser;
import com.facebook.nearby.protocol.NearbyTilesGraphQLParsers.NearbyTilesParser.TilesParser.EdgesParser.NodeParser.PlacesRenderPriority1Parser.PlacesRenderPriority1EdgesParser.PlacesRenderPriority1EdgesNodeParser.RatersParser;
import com.facebook.nearby.protocol.NearbyTilesGraphQLParsers.NearbyTilesParser.TilesParser.EdgesParser.NodeParser.PlacesRenderPriority1Parser.PlacesRenderPriority1EdgesParser.SocialContextParser;
import com.facebook.nearby.protocol.NearbyTilesGraphQLParsers.NearbyTilesParser.TilesParser.EdgesParser.NodeParser.PlacesRenderPriority2Parser;
import com.facebook.nearby.protocol.NearbyTilesGraphQLParsers.NearbyTilesParser.TilesParser.EdgesParser.NodeParser.PlacesRenderPriority2Parser.PlacesRenderPriority2EdgesParser;
import com.facebook.nearby.protocol.NearbyTilesGraphQLParsers.NearbyTilesParser.TilesParser.EdgesParser.NodeParser.PlacesRenderPriority2Parser.PlacesRenderPriority2EdgesParser.PlacesRenderPriority2EdgesNodeParser;
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

/* compiled from: transformData */
public class NearbyTilesGraphQLModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -1076074038)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: transformData */
    public final class NearbyGeoRectangleModel extends BaseModel implements GraphQLVisitableModel {
        private double f526d;
        private double f527e;
        private double f528f;
        private double f529g;

        /* compiled from: transformData */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(NearbyGeoRectangleModel.class, new Deserializer());
            }

            public Object m653a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(NearbyGeoRectangleParser.m832a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object nearbyGeoRectangleModel = new NearbyGeoRectangleModel();
                ((BaseModel) nearbyGeoRectangleModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (nearbyGeoRectangleModel instanceof Postprocessable) {
                    return ((Postprocessable) nearbyGeoRectangleModel).a();
                }
                return nearbyGeoRectangleModel;
            }
        }

        /* compiled from: transformData */
        public class Serializer extends JsonSerializer<NearbyGeoRectangleModel> {
            public final void m654a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                NearbyGeoRectangleModel nearbyGeoRectangleModel = (NearbyGeoRectangleModel) obj;
                if (nearbyGeoRectangleModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(nearbyGeoRectangleModel.m655a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    nearbyGeoRectangleModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                NearbyGeoRectangleParser.m833a(nearbyGeoRectangleModel.w_(), nearbyGeoRectangleModel.u_(), jsonGenerator);
            }

            static {
                FbSerializerProvider.a(NearbyGeoRectangleModel.class, new Serializer());
            }
        }

        public NearbyGeoRectangleModel() {
            super(4);
        }

        public final int jK_() {
            return -2036384450;
        }

        public final GraphQLVisitableModel m656a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            h();
            i();
            return this;
        }

        public final int m655a(FlatBufferBuilder flatBufferBuilder) {
            h();
            flatBufferBuilder.c(4);
            flatBufferBuilder.a(0, this.f526d, 0.0d);
            flatBufferBuilder.a(1, this.f527e, 0.0d);
            flatBufferBuilder.a(2, this.f528f, 0.0d);
            flatBufferBuilder.a(3, this.f529g, 0.0d);
            i();
            return flatBufferBuilder.d();
        }

        public final void m657a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
            super.a(mutableFlatBuffer, i, obj);
            this.f526d = mutableFlatBuffer.a(i, 0, 0.0d);
            this.f527e = mutableFlatBuffer.a(i, 1, 0.0d);
            this.f528f = mutableFlatBuffer.a(i, 2, 0.0d);
            this.f529g = mutableFlatBuffer.a(i, 3, 0.0d);
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 315913125)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: transformData */
    public final class NearbyTilesModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private String f609d;
        @Nullable
        private TilesModel f610e;

        /* compiled from: transformData */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(NearbyTilesModel.class, new Deserializer());
            }

            public Object m658a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = NearbyTilesParser.m880a(jsonParser);
                Object nearbyTilesModel = new NearbyTilesModel();
                ((BaseModel) nearbyTilesModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (nearbyTilesModel instanceof Postprocessable) {
                    return ((Postprocessable) nearbyTilesModel).a();
                }
                return nearbyTilesModel;
            }
        }

        /* compiled from: transformData */
        public class Serializer extends JsonSerializer<NearbyTilesModel> {
            public final void m659a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                NearbyTilesModel nearbyTilesModel = (NearbyTilesModel) obj;
                if (nearbyTilesModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(nearbyTilesModel.m830a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    nearbyTilesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = nearbyTilesModel.w_();
                int u_ = nearbyTilesModel.u_();
                jsonGenerator.f();
                if (mutableFlatBuffer.g(u_, 0) != 0) {
                    jsonGenerator.a("search_session_key");
                    jsonGenerator.b(mutableFlatBuffer.c(u_, 0));
                }
                int g = mutableFlatBuffer.g(u_, 1);
                if (g != 0) {
                    jsonGenerator.a("tiles");
                    TilesParser.m879a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(NearbyTilesModel.class, new Serializer());
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 159369285)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: transformData */
        public final class TilesModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private String f605d;
            @Nullable
            private NearbyGeoRectangleModel f606e;
            @Nullable
            private List<EdgesModel> f607f;
            @Nullable
            private String f608g;

            /* compiled from: transformData */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(TilesModel.class, new Deserializer());
                }

                public Object m660a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(TilesParser.m878a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object tilesModel = new TilesModel();
                    ((BaseModel) tilesModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (tilesModel instanceof Postprocessable) {
                        return ((Postprocessable) tilesModel).a();
                    }
                    return tilesModel;
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = 1739750897)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: transformData */
            public final class EdgesModel extends BaseModel implements GraphQLVisitableModel {
                @Nullable
                private NodeModel f604d;

                /* compiled from: transformData */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(EdgesModel.class, new Deserializer());
                    }

                    public Object m661a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(EdgesParser.m876b(jsonParser, flatBufferBuilder));
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
                @ModelWithFlatBufferFormatHash(a = 624326751)
                @JsonSerialize(using = Serializer.class)
                @FragmentModelWithoutBridge
                /* compiled from: transformData */
                public final class NodeModel extends BaseModel implements GraphQLVisitableModel {
                    @Nullable
                    private NearbyGeoRectangleModel f596d;
                    private long f597e;
                    private double f598f;
                    private double f599g;
                    @Nullable
                    private PlacesRenderPriority1Model f600h;
                    @Nullable
                    private PlacesRenderPriority2Model f601i;
                    @Nullable
                    private String f602j;
                    private int f603k;

                    /* compiled from: transformData */
                    public class Deserializer extends FbJsonDeserializer {
                        static {
                            GlobalAutoGenDeserializerCache.a(NodeModel.class, new Deserializer());
                        }

                        public Object m662a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(NodeParser.m874a(jsonParser, flatBufferBuilder));
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
                    @ModelWithFlatBufferFormatHash(a = -1835749623)
                    @JsonSerialize(using = Serializer.class)
                    @FragmentModelWithoutBridge
                    /* compiled from: transformData */
                    public final class PlacesRenderPriority1Model extends BaseModel implements GraphQLVisitableModel {
                        @Nullable
                        private List<PlacesRenderPriority1EdgesModel> f562d;

                        /* compiled from: transformData */
                        public class Deserializer extends FbJsonDeserializer {
                            static {
                                GlobalAutoGenDeserializerCache.a(PlacesRenderPriority1Model.class, new Deserializer());
                            }

                            public Object m663a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                flatBufferBuilder.d(PlacesRenderPriority1Parser.m852a(jsonParser, flatBufferBuilder));
                                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                wrap.position(0);
                                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                                Object placesRenderPriority1Model = new PlacesRenderPriority1Model();
                                ((BaseModel) placesRenderPriority1Model).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                                if (placesRenderPriority1Model instanceof Postprocessable) {
                                    return ((Postprocessable) placesRenderPriority1Model).a();
                                }
                                return placesRenderPriority1Model;
                            }
                        }

                        @JsonDeserialize(using = Deserializer.class)
                        @ModelWithFlatBufferFormatHash(a = 1875169196)
                        @JsonSerialize(using = Serializer.class)
                        @FragmentModelWithoutBridge
                        /* compiled from: transformData */
                        public final class PlacesRenderPriority1EdgesModel extends BaseModel implements GraphQLVisitableModel {
                            @Nullable
                            private PlacesRenderPriority1EdgesNodeModel f558d;
                            @Nullable
                            private NearbyFacepilesFragmentModel f559e;
                            private double f560f;
                            @Nullable
                            private SocialContextModel f561g;

                            /* compiled from: transformData */
                            public class Deserializer extends FbJsonDeserializer {
                                static {
                                    GlobalAutoGenDeserializerCache.a(PlacesRenderPriority1EdgesModel.class, new Deserializer());
                                }

                                public Object m664a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                    flatBufferBuilder.d(PlacesRenderPriority1EdgesParser.m850b(jsonParser, flatBufferBuilder));
                                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                    wrap.position(0);
                                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                                    Object placesRenderPriority1EdgesModel = new PlacesRenderPriority1EdgesModel();
                                    ((BaseModel) placesRenderPriority1EdgesModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                                    if (placesRenderPriority1EdgesModel instanceof Postprocessable) {
                                        return ((Postprocessable) placesRenderPriority1EdgesModel).a();
                                    }
                                    return placesRenderPriority1EdgesModel;
                                }
                            }

                            @JsonDeserialize(using = Deserializer.class)
                            @ModelWithFlatBufferFormatHash(a = -207745398)
                            @JsonSerialize(using = Serializer.class)
                            @FragmentModelWithoutBridge
                            /* compiled from: transformData */
                            public final class PlacesRenderPriority1EdgesNodeModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
                                @Nullable
                                private AddressModel f538d;
                                private boolean f539e;
                                private boolean f540f;
                                @Nullable
                                private String f541g;
                                private boolean f542h;
                                @Nullable
                                private DefaultLocationFieldsModel f543i;
                                private int f544j;
                                @Nullable
                                private String f545k;
                                private double f546l;
                                @Nullable
                                private PageLikersModel f547m;
                                @Nullable
                                private PageVisitsModel f548n;
                                @Nullable
                                private PhoneNumberModel f549o;
                                @Nullable
                                private GraphQLPlaceType f550p;
                                @Nullable
                                private ProfilePictureModel f551q;
                                private boolean f552r;
                                @Nullable
                                private RatersModel f553s;
                                @Nullable
                                private List<String> f554t;
                                @Nullable
                                private String f555u;
                                @Nullable
                                private GraphQLSavedState f556v;

                                @JsonDeserialize(using = Deserializer.class)
                                @ModelWithFlatBufferFormatHash(a = 1000273915)
                                @JsonSerialize(using = Serializer.class)
                                @FragmentModelWithoutBridge
                                /* compiled from: transformData */
                                public final class AddressModel extends BaseModel implements GraphQLVisitableModel {
                                    @Nullable
                                    private String f530d;
                                    @Nullable
                                    private String f531e;
                                    @Nullable
                                    private String f532f;

                                    /* compiled from: transformData */
                                    public class Deserializer extends FbJsonDeserializer {
                                        static {
                                            GlobalAutoGenDeserializerCache.a(AddressModel.class, new Deserializer());
                                        }

                                        public Object m665a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                            flatBufferBuilder.d(AddressParser.m834a(jsonParser, flatBufferBuilder));
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

                                    /* compiled from: transformData */
                                    public class Serializer extends JsonSerializer<AddressModel> {
                                        public final void m666a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                                            AddressModel addressModel = (AddressModel) obj;
                                            if (addressModel.w_() == null) {
                                                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                                flatBufferBuilder.d(addressModel.m670a(flatBufferBuilder));
                                                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                                wrap.position(0);
                                                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                                addressModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                                            }
                                            AddressParser.m835a(addressModel.w_(), addressModel.u_(), jsonGenerator);
                                        }

                                        static {
                                            FbSerializerProvider.a(AddressModel.class, new Serializer());
                                        }
                                    }

                                    public AddressModel() {
                                        super(3);
                                    }

                                    @Nullable
                                    private String m667a() {
                                        this.f530d = super.a(this.f530d, 0);
                                        return this.f530d;
                                    }

                                    @Nullable
                                    private String m668j() {
                                        this.f531e = super.a(this.f531e, 1);
                                        return this.f531e;
                                    }

                                    @Nullable
                                    private String m669k() {
                                        this.f532f = super.a(this.f532f, 2);
                                        return this.f532f;
                                    }

                                    public final int jK_() {
                                        return 799251025;
                                    }

                                    public final GraphQLVisitableModel m671a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                                        h();
                                        i();
                                        return this;
                                    }

                                    public final int m670a(FlatBufferBuilder flatBufferBuilder) {
                                        h();
                                        int b = flatBufferBuilder.b(m667a());
                                        int b2 = flatBufferBuilder.b(m668j());
                                        int b3 = flatBufferBuilder.b(m669k());
                                        flatBufferBuilder.c(3);
                                        flatBufferBuilder.b(0, b);
                                        flatBufferBuilder.b(1, b2);
                                        flatBufferBuilder.b(2, b3);
                                        i();
                                        return flatBufferBuilder.d();
                                    }
                                }

                                /* compiled from: transformData */
                                public class Deserializer extends FbJsonDeserializer {
                                    static {
                                        GlobalAutoGenDeserializerCache.a(PlacesRenderPriority1EdgesNodeModel.class, new Deserializer());
                                    }

                                    public Object m672a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                        flatBufferBuilder.d(PlacesRenderPriority1EdgesNodeParser.m846a(jsonParser, flatBufferBuilder));
                                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                        wrap.position(0);
                                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                                        Object placesRenderPriority1EdgesNodeModel = new PlacesRenderPriority1EdgesNodeModel();
                                        ((BaseModel) placesRenderPriority1EdgesNodeModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                                        if (placesRenderPriority1EdgesNodeModel instanceof Postprocessable) {
                                            return ((Postprocessable) placesRenderPriority1EdgesNodeModel).a();
                                        }
                                        return placesRenderPriority1EdgesNodeModel;
                                    }
                                }

                                @JsonDeserialize(using = Deserializer.class)
                                @ModelWithFlatBufferFormatHash(a = -1723990064)
                                @JsonSerialize(using = Serializer.class)
                                @FragmentModelWithoutBridge
                                /* compiled from: transformData */
                                public final class PageLikersModel extends BaseModel implements GraphQLVisitableModel {
                                    private int f533d;

                                    /* compiled from: transformData */
                                    public class Deserializer extends FbJsonDeserializer {
                                        static {
                                            GlobalAutoGenDeserializerCache.a(PageLikersModel.class, new Deserializer());
                                        }

                                        public Object m673a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                            flatBufferBuilder.d(PageLikersParser.m836a(jsonParser, flatBufferBuilder));
                                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                            wrap.position(0);
                                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                            mutableFlatBuffer.a(4, Boolean.valueOf(true));
                                            MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                                            Object pageLikersModel = new PageLikersModel();
                                            ((BaseModel) pageLikersModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                                            if (pageLikersModel instanceof Postprocessable) {
                                                return ((Postprocessable) pageLikersModel).a();
                                            }
                                            return pageLikersModel;
                                        }
                                    }

                                    /* compiled from: transformData */
                                    public class Serializer extends JsonSerializer<PageLikersModel> {
                                        public final void m674a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                                            PageLikersModel pageLikersModel = (PageLikersModel) obj;
                                            if (pageLikersModel.w_() == null) {
                                                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                                flatBufferBuilder.d(pageLikersModel.m675a(flatBufferBuilder));
                                                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                                wrap.position(0);
                                                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                                pageLikersModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                                            }
                                            PageLikersParser.m837a(pageLikersModel.w_(), pageLikersModel.u_(), jsonGenerator);
                                        }

                                        static {
                                            FbSerializerProvider.a(PageLikersModel.class, new Serializer());
                                        }
                                    }

                                    public PageLikersModel() {
                                        super(1);
                                    }

                                    public final int jK_() {
                                        return 637021669;
                                    }

                                    public final GraphQLVisitableModel m676a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                                        h();
                                        i();
                                        return this;
                                    }

                                    public final int m675a(FlatBufferBuilder flatBufferBuilder) {
                                        h();
                                        flatBufferBuilder.c(1);
                                        flatBufferBuilder.a(0, this.f533d, 0);
                                        i();
                                        return flatBufferBuilder.d();
                                    }

                                    public final void m677a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                                        super.a(mutableFlatBuffer, i, obj);
                                        this.f533d = mutableFlatBuffer.a(i, 0, 0);
                                    }
                                }

                                @JsonDeserialize(using = Deserializer.class)
                                @ModelWithFlatBufferFormatHash(a = -1723990064)
                                @JsonSerialize(using = Serializer.class)
                                @FragmentModelWithoutBridge
                                /* compiled from: transformData */
                                public final class PageVisitsModel extends BaseModel implements GraphQLVisitableModel {
                                    private int f534d;

                                    /* compiled from: transformData */
                                    public class Deserializer extends FbJsonDeserializer {
                                        static {
                                            GlobalAutoGenDeserializerCache.a(PageVisitsModel.class, new Deserializer());
                                        }

                                        public Object m678a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                            flatBufferBuilder.d(PageVisitsParser.m838a(jsonParser, flatBufferBuilder));
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

                                    /* compiled from: transformData */
                                    public class Serializer extends JsonSerializer<PageVisitsModel> {
                                        public final void m679a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                                            PageVisitsModel pageVisitsModel = (PageVisitsModel) obj;
                                            if (pageVisitsModel.w_() == null) {
                                                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                                flatBufferBuilder.d(pageVisitsModel.m680a(flatBufferBuilder));
                                                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                                wrap.position(0);
                                                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                                pageVisitsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                                            }
                                            PageVisitsParser.m839a(pageVisitsModel.w_(), pageVisitsModel.u_(), jsonGenerator);
                                        }

                                        static {
                                            FbSerializerProvider.a(PageVisitsModel.class, new Serializer());
                                        }
                                    }

                                    public PageVisitsModel() {
                                        super(1);
                                    }

                                    public final int jK_() {
                                        return -838301099;
                                    }

                                    public final GraphQLVisitableModel m681a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                                        h();
                                        i();
                                        return this;
                                    }

                                    public final int m680a(FlatBufferBuilder flatBufferBuilder) {
                                        h();
                                        flatBufferBuilder.c(1);
                                        flatBufferBuilder.a(0, this.f534d, 0);
                                        i();
                                        return flatBufferBuilder.d();
                                    }

                                    public final void m682a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                                        super.a(mutableFlatBuffer, i, obj);
                                        this.f534d = mutableFlatBuffer.a(i, 0, 0);
                                    }
                                }

                                @JsonDeserialize(using = Deserializer.class)
                                @ModelWithFlatBufferFormatHash(a = -760636128)
                                @JsonSerialize(using = Serializer.class)
                                @FragmentModelWithoutBridge
                                /* compiled from: transformData */
                                public final class PhoneNumberModel extends BaseModel implements GraphQLVisitableModel {
                                    @Nullable
                                    private String f535d;

                                    /* compiled from: transformData */
                                    public class Deserializer extends FbJsonDeserializer {
                                        static {
                                            GlobalAutoGenDeserializerCache.a(PhoneNumberModel.class, new Deserializer());
                                        }

                                        public Object m683a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                            flatBufferBuilder.d(PhoneNumberParser.m840a(jsonParser, flatBufferBuilder));
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

                                    /* compiled from: transformData */
                                    public class Serializer extends JsonSerializer<PhoneNumberModel> {
                                        public final void m684a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                                            PhoneNumberModel phoneNumberModel = (PhoneNumberModel) obj;
                                            if (phoneNumberModel.w_() == null) {
                                                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                                flatBufferBuilder.d(phoneNumberModel.m686a(flatBufferBuilder));
                                                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                                wrap.position(0);
                                                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                                phoneNumberModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                                            }
                                            PhoneNumberParser.m841a(phoneNumberModel.w_(), phoneNumberModel.u_(), jsonGenerator);
                                        }

                                        static {
                                            FbSerializerProvider.a(PhoneNumberModel.class, new Serializer());
                                        }
                                    }

                                    public PhoneNumberModel() {
                                        super(1);
                                    }

                                    @Nullable
                                    private String m685a() {
                                        this.f535d = super.a(this.f535d, 0);
                                        return this.f535d;
                                    }

                                    public final int jK_() {
                                        return 474898999;
                                    }

                                    public final GraphQLVisitableModel m687a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                                        h();
                                        i();
                                        return this;
                                    }

                                    public final int m686a(FlatBufferBuilder flatBufferBuilder) {
                                        h();
                                        int b = flatBufferBuilder.b(m685a());
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
                                /* compiled from: transformData */
                                public final class ProfilePictureModel extends BaseModel implements GraphQLVisitableModel {
                                    @Nullable
                                    private String f536d;

                                    /* compiled from: transformData */
                                    public class Deserializer extends FbJsonDeserializer {
                                        static {
                                            GlobalAutoGenDeserializerCache.a(ProfilePictureModel.class, new Deserializer());
                                        }

                                        public Object m688a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                            flatBufferBuilder.d(ProfilePictureParser.m842a(jsonParser, flatBufferBuilder));
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

                                    /* compiled from: transformData */
                                    public class Serializer extends JsonSerializer<ProfilePictureModel> {
                                        public final void m689a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                                            ProfilePictureModel profilePictureModel = (ProfilePictureModel) obj;
                                            if (profilePictureModel.w_() == null) {
                                                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                                flatBufferBuilder.d(profilePictureModel.m691a(flatBufferBuilder));
                                                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                                wrap.position(0);
                                                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                                profilePictureModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                                            }
                                            ProfilePictureParser.m843a(profilePictureModel.w_(), profilePictureModel.u_(), jsonGenerator);
                                        }

                                        static {
                                            FbSerializerProvider.a(ProfilePictureModel.class, new Serializer());
                                        }
                                    }

                                    public ProfilePictureModel() {
                                        super(1);
                                    }

                                    @Nullable
                                    private String m690a() {
                                        this.f536d = super.a(this.f536d, 0);
                                        return this.f536d;
                                    }

                                    public final int jK_() {
                                        return 70760763;
                                    }

                                    public final GraphQLVisitableModel m692a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                                        h();
                                        i();
                                        return this;
                                    }

                                    public final int m691a(FlatBufferBuilder flatBufferBuilder) {
                                        h();
                                        int b = flatBufferBuilder.b(m690a());
                                        flatBufferBuilder.c(1);
                                        flatBufferBuilder.b(0, b);
                                        i();
                                        return flatBufferBuilder.d();
                                    }
                                }

                                @JsonDeserialize(using = Deserializer.class)
                                @ModelWithFlatBufferFormatHash(a = -1723990064)
                                @JsonSerialize(using = Serializer.class)
                                @FragmentModelWithoutBridge
                                /* compiled from: transformData */
                                public final class RatersModel extends BaseModel implements GraphQLVisitableModel {
                                    private int f537d;

                                    /* compiled from: transformData */
                                    public class Deserializer extends FbJsonDeserializer {
                                        static {
                                            GlobalAutoGenDeserializerCache.a(RatersModel.class, new Deserializer());
                                        }

                                        public Object m693a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                            flatBufferBuilder.d(RatersParser.m844a(jsonParser, flatBufferBuilder));
                                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                            wrap.position(0);
                                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                            mutableFlatBuffer.a(4, Boolean.valueOf(true));
                                            MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                                            Object ratersModel = new RatersModel();
                                            ((BaseModel) ratersModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                                            if (ratersModel instanceof Postprocessable) {
                                                return ((Postprocessable) ratersModel).a();
                                            }
                                            return ratersModel;
                                        }
                                    }

                                    /* compiled from: transformData */
                                    public class Serializer extends JsonSerializer<RatersModel> {
                                        public final void m694a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                                            RatersModel ratersModel = (RatersModel) obj;
                                            if (ratersModel.w_() == null) {
                                                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                                flatBufferBuilder.d(ratersModel.m695a(flatBufferBuilder));
                                                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                                wrap.position(0);
                                                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                                ratersModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                                            }
                                            RatersParser.m845a(ratersModel.w_(), ratersModel.u_(), jsonGenerator);
                                        }

                                        static {
                                            FbSerializerProvider.a(RatersModel.class, new Serializer());
                                        }
                                    }

                                    public RatersModel() {
                                        super(1);
                                    }

                                    public final int jK_() {
                                        return -24998752;
                                    }

                                    public final GraphQLVisitableModel m696a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                                        h();
                                        i();
                                        return this;
                                    }

                                    public final int m695a(FlatBufferBuilder flatBufferBuilder) {
                                        h();
                                        flatBufferBuilder.c(1);
                                        flatBufferBuilder.a(0, this.f537d, 0);
                                        i();
                                        return flatBufferBuilder.d();
                                    }

                                    public final void m697a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                                        super.a(mutableFlatBuffer, i, obj);
                                        this.f537d = mutableFlatBuffer.a(i, 0, 0);
                                    }
                                }

                                /* compiled from: transformData */
                                public class Serializer extends JsonSerializer<PlacesRenderPriority1EdgesNodeModel> {
                                    public final void m698a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                                        PlacesRenderPriority1EdgesNodeModel placesRenderPriority1EdgesNodeModel = (PlacesRenderPriority1EdgesNodeModel) obj;
                                        if (placesRenderPriority1EdgesNodeModel.w_() == null) {
                                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                            flatBufferBuilder.d(placesRenderPriority1EdgesNodeModel.m714a(flatBufferBuilder));
                                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                            wrap.position(0);
                                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                            placesRenderPriority1EdgesNodeModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                                        }
                                        PlacesRenderPriority1EdgesNodeParser.m847a(placesRenderPriority1EdgesNodeModel.w_(), placesRenderPriority1EdgesNodeModel.u_(), jsonGenerator, serializerProvider);
                                    }

                                    static {
                                        FbSerializerProvider.a(PlacesRenderPriority1EdgesNodeModel.class, new Serializer());
                                    }
                                }

                                public PlacesRenderPriority1EdgesNodeModel() {
                                    super(19);
                                }

                                public final void m718a(String str, ConsistencyTuple consistencyTuple) {
                                    if ("does_viewer_like".equals(str)) {
                                        consistencyTuple.a = Boolean.valueOf(m701k());
                                        consistencyTuple.b = u_();
                                        consistencyTuple.c = 2;
                                        return;
                                    }
                                    consistencyTuple.a();
                                }

                                public final void m719a(String str, Object obj, boolean z) {
                                    if ("does_viewer_like".equals(str)) {
                                        m699a(((Boolean) obj).booleanValue());
                                    }
                                }

                                @Nullable
                                private AddressModel m700j() {
                                    this.f538d = (AddressModel) super.a(this.f538d, 0, AddressModel.class);
                                    return this.f538d;
                                }

                                private boolean m701k() {
                                    a(0, 2);
                                    return this.f540f;
                                }

                                private void m699a(boolean z) {
                                    this.f540f = z;
                                    if (this.b != null && this.b.d) {
                                        this.b.a(this.c, 2, z);
                                    }
                                }

                                @Nullable
                                private String m702l() {
                                    this.f541g = super.a(this.f541g, 3);
                                    return this.f541g;
                                }

                                @Nullable
                                private DefaultLocationFieldsModel m703m() {
                                    this.f543i = (DefaultLocationFieldsModel) super.a(this.f543i, 5, DefaultLocationFieldsModel.class);
                                    return this.f543i;
                                }

                                @Nullable
                                private String m704n() {
                                    this.f545k = super.a(this.f545k, 7);
                                    return this.f545k;
                                }

                                @Nullable
                                private PageLikersModel m705o() {
                                    this.f547m = (PageLikersModel) super.a(this.f547m, 9, PageLikersModel.class);
                                    return this.f547m;
                                }

                                @Nullable
                                private PageVisitsModel m706p() {
                                    this.f548n = (PageVisitsModel) super.a(this.f548n, 10, PageVisitsModel.class);
                                    return this.f548n;
                                }

                                @Nullable
                                private PhoneNumberModel m707q() {
                                    this.f549o = (PhoneNumberModel) super.a(this.f549o, 11, PhoneNumberModel.class);
                                    return this.f549o;
                                }

                                @Nullable
                                private GraphQLPlaceType m708r() {
                                    this.f550p = (GraphQLPlaceType) super.b(this.f550p, 12, GraphQLPlaceType.class, GraphQLPlaceType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
                                    return this.f550p;
                                }

                                @Nullable
                                private ProfilePictureModel m709s() {
                                    this.f551q = (ProfilePictureModel) super.a(this.f551q, 13, ProfilePictureModel.class);
                                    return this.f551q;
                                }

                                @Nullable
                                private RatersModel m710t() {
                                    this.f553s = (RatersModel) super.a(this.f553s, 15, RatersModel.class);
                                    return this.f553s;
                                }

                                @Nonnull
                                private ImmutableList<String> m711u() {
                                    this.f554t = super.a(this.f554t, 16);
                                    return (ImmutableList) this.f554t;
                                }

                                @Nullable
                                private String m712v() {
                                    this.f555u = super.a(this.f555u, 17);
                                    return this.f555u;
                                }

                                @Nullable
                                private GraphQLSavedState m713w() {
                                    this.f556v = (GraphQLSavedState) super.b(this.f556v, 18, GraphQLSavedState.class, GraphQLSavedState.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
                                    return this.f556v;
                                }

                                @Nullable
                                public final String m716a() {
                                    return m702l();
                                }

                                public final int jK_() {
                                    return 2479791;
                                }

                                public final GraphQLVisitableModel m715a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                                    GraphQLVisitableModel graphQLVisitableModel = null;
                                    h();
                                    if (m700j() != null) {
                                        AddressModel addressModel = (AddressModel) graphQLModelMutatingVisitor.b(m700j());
                                        if (m700j() != addressModel) {
                                            graphQLVisitableModel = (PlacesRenderPriority1EdgesNodeModel) ModelHelper.a(null, this);
                                            graphQLVisitableModel.f538d = addressModel;
                                        }
                                    }
                                    if (m703m() != null) {
                                        DefaultLocationFieldsModel defaultLocationFieldsModel = (DefaultLocationFieldsModel) graphQLModelMutatingVisitor.b(m703m());
                                        if (m703m() != defaultLocationFieldsModel) {
                                            graphQLVisitableModel = (PlacesRenderPriority1EdgesNodeModel) ModelHelper.a(graphQLVisitableModel, this);
                                            graphQLVisitableModel.f543i = defaultLocationFieldsModel;
                                        }
                                    }
                                    if (m705o() != null) {
                                        PageLikersModel pageLikersModel = (PageLikersModel) graphQLModelMutatingVisitor.b(m705o());
                                        if (m705o() != pageLikersModel) {
                                            graphQLVisitableModel = (PlacesRenderPriority1EdgesNodeModel) ModelHelper.a(graphQLVisitableModel, this);
                                            graphQLVisitableModel.f547m = pageLikersModel;
                                        }
                                    }
                                    if (m706p() != null) {
                                        PageVisitsModel pageVisitsModel = (PageVisitsModel) graphQLModelMutatingVisitor.b(m706p());
                                        if (m706p() != pageVisitsModel) {
                                            graphQLVisitableModel = (PlacesRenderPriority1EdgesNodeModel) ModelHelper.a(graphQLVisitableModel, this);
                                            graphQLVisitableModel.f548n = pageVisitsModel;
                                        }
                                    }
                                    if (m707q() != null) {
                                        PhoneNumberModel phoneNumberModel = (PhoneNumberModel) graphQLModelMutatingVisitor.b(m707q());
                                        if (m707q() != phoneNumberModel) {
                                            graphQLVisitableModel = (PlacesRenderPriority1EdgesNodeModel) ModelHelper.a(graphQLVisitableModel, this);
                                            graphQLVisitableModel.f549o = phoneNumberModel;
                                        }
                                    }
                                    if (m709s() != null) {
                                        ProfilePictureModel profilePictureModel = (ProfilePictureModel) graphQLModelMutatingVisitor.b(m709s());
                                        if (m709s() != profilePictureModel) {
                                            graphQLVisitableModel = (PlacesRenderPriority1EdgesNodeModel) ModelHelper.a(graphQLVisitableModel, this);
                                            graphQLVisitableModel.f551q = profilePictureModel;
                                        }
                                    }
                                    if (m710t() != null) {
                                        RatersModel ratersModel = (RatersModel) graphQLModelMutatingVisitor.b(m710t());
                                        if (m710t() != ratersModel) {
                                            graphQLVisitableModel = (PlacesRenderPriority1EdgesNodeModel) ModelHelper.a(graphQLVisitableModel, this);
                                            graphQLVisitableModel.f553s = ratersModel;
                                        }
                                    }
                                    i();
                                    return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                                }

                                public final int m714a(FlatBufferBuilder flatBufferBuilder) {
                                    h();
                                    int a = ModelHelper.a(flatBufferBuilder, m700j());
                                    int b = flatBufferBuilder.b(m702l());
                                    int a2 = ModelHelper.a(flatBufferBuilder, m703m());
                                    int b2 = flatBufferBuilder.b(m704n());
                                    int a3 = ModelHelper.a(flatBufferBuilder, m705o());
                                    int a4 = ModelHelper.a(flatBufferBuilder, m706p());
                                    int a5 = ModelHelper.a(flatBufferBuilder, m707q());
                                    int a6 = flatBufferBuilder.a(m708r());
                                    int a7 = ModelHelper.a(flatBufferBuilder, m709s());
                                    int a8 = ModelHelper.a(flatBufferBuilder, m710t());
                                    int c = flatBufferBuilder.c(m711u());
                                    int b3 = flatBufferBuilder.b(m712v());
                                    int a9 = flatBufferBuilder.a(m713w());
                                    flatBufferBuilder.c(19);
                                    flatBufferBuilder.b(0, a);
                                    flatBufferBuilder.a(1, this.f539e);
                                    flatBufferBuilder.a(2, this.f540f);
                                    flatBufferBuilder.b(3, b);
                                    flatBufferBuilder.a(4, this.f542h);
                                    flatBufferBuilder.b(5, a2);
                                    flatBufferBuilder.a(6, this.f544j, 0);
                                    flatBufferBuilder.b(7, b2);
                                    flatBufferBuilder.a(8, this.f546l, 0.0d);
                                    flatBufferBuilder.b(9, a3);
                                    flatBufferBuilder.b(10, a4);
                                    flatBufferBuilder.b(11, a5);
                                    flatBufferBuilder.b(12, a6);
                                    flatBufferBuilder.b(13, a7);
                                    flatBufferBuilder.a(14, this.f552r);
                                    flatBufferBuilder.b(15, a8);
                                    flatBufferBuilder.b(16, c);
                                    flatBufferBuilder.b(17, b3);
                                    flatBufferBuilder.b(18, a9);
                                    i();
                                    return flatBufferBuilder.d();
                                }

                                public final void m717a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                                    super.a(mutableFlatBuffer, i, obj);
                                    this.f539e = mutableFlatBuffer.a(i, 1);
                                    this.f540f = mutableFlatBuffer.a(i, 2);
                                    this.f542h = mutableFlatBuffer.a(i, 4);
                                    this.f544j = mutableFlatBuffer.a(i, 6, 0);
                                    this.f546l = mutableFlatBuffer.a(i, 8, 0.0d);
                                    this.f552r = mutableFlatBuffer.a(i, 14);
                                }
                            }

                            /* compiled from: transformData */
                            public class Serializer extends JsonSerializer<PlacesRenderPriority1EdgesModel> {
                                public final void m720a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                                    PlacesRenderPriority1EdgesModel placesRenderPriority1EdgesModel = (PlacesRenderPriority1EdgesModel) obj;
                                    if (placesRenderPriority1EdgesModel.w_() == null) {
                                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                        flatBufferBuilder.d(placesRenderPriority1EdgesModel.m729a(flatBufferBuilder));
                                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                        wrap.position(0);
                                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                        placesRenderPriority1EdgesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                                    }
                                    PlacesRenderPriority1EdgesParser.m851b(placesRenderPriority1EdgesModel.w_(), placesRenderPriority1EdgesModel.u_(), jsonGenerator, serializerProvider);
                                }

                                static {
                                    FbSerializerProvider.a(PlacesRenderPriority1EdgesModel.class, new Serializer());
                                }
                            }

                            @JsonDeserialize(using = Deserializer.class)
                            @ModelWithFlatBufferFormatHash(a = -1352864475)
                            @JsonSerialize(using = Serializer.class)
                            @FragmentModelWithoutBridge
                            /* compiled from: transformData */
                            public final class SocialContextModel extends BaseModel implements GraphQLVisitableModel {
                                @Nullable
                                private String f557d;

                                /* compiled from: transformData */
                                public class Deserializer extends FbJsonDeserializer {
                                    static {
                                        GlobalAutoGenDeserializerCache.a(SocialContextModel.class, new Deserializer());
                                    }

                                    public Object m721a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                        flatBufferBuilder.d(SocialContextParser.m848a(jsonParser, flatBufferBuilder));
                                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                        wrap.position(0);
                                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                                        Object socialContextModel = new SocialContextModel();
                                        ((BaseModel) socialContextModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                                        if (socialContextModel instanceof Postprocessable) {
                                            return ((Postprocessable) socialContextModel).a();
                                        }
                                        return socialContextModel;
                                    }
                                }

                                /* compiled from: transformData */
                                public class Serializer extends JsonSerializer<SocialContextModel> {
                                    public final void m722a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                                        SocialContextModel socialContextModel = (SocialContextModel) obj;
                                        if (socialContextModel.w_() == null) {
                                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                            flatBufferBuilder.d(socialContextModel.m724a(flatBufferBuilder));
                                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                            wrap.position(0);
                                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                            socialContextModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                                        }
                                        SocialContextParser.m849a(socialContextModel.w_(), socialContextModel.u_(), jsonGenerator);
                                    }

                                    static {
                                        FbSerializerProvider.a(SocialContextModel.class, new Serializer());
                                    }
                                }

                                public SocialContextModel() {
                                    super(1);
                                }

                                @Nullable
                                private String m723a() {
                                    this.f557d = super.a(this.f557d, 0);
                                    return this.f557d;
                                }

                                public final int jK_() {
                                    return -1919764332;
                                }

                                public final GraphQLVisitableModel m725a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                                    h();
                                    i();
                                    return this;
                                }

                                public final int m724a(FlatBufferBuilder flatBufferBuilder) {
                                    h();
                                    int b = flatBufferBuilder.b(m723a());
                                    flatBufferBuilder.c(1);
                                    flatBufferBuilder.b(0, b);
                                    i();
                                    return flatBufferBuilder.d();
                                }
                            }

                            public PlacesRenderPriority1EdgesModel() {
                                super(4);
                            }

                            @Nullable
                            private PlacesRenderPriority1EdgesNodeModel m726a() {
                                this.f558d = (PlacesRenderPriority1EdgesNodeModel) super.a(this.f558d, 0, PlacesRenderPriority1EdgesNodeModel.class);
                                return this.f558d;
                            }

                            @Nullable
                            private NearbyFacepilesFragmentModel m727j() {
                                this.f559e = (NearbyFacepilesFragmentModel) super.a(this.f559e, 1, NearbyFacepilesFragmentModel.class);
                                return this.f559e;
                            }

                            @Nullable
                            private SocialContextModel m728k() {
                                this.f561g = (SocialContextModel) super.a(this.f561g, 3, SocialContextModel.class);
                                return this.f561g;
                            }

                            public final int jK_() {
                                return -833204935;
                            }

                            public final GraphQLVisitableModel m730a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                                GraphQLVisitableModel graphQLVisitableModel = null;
                                h();
                                if (m726a() != null) {
                                    PlacesRenderPriority1EdgesNodeModel placesRenderPriority1EdgesNodeModel = (PlacesRenderPriority1EdgesNodeModel) graphQLModelMutatingVisitor.b(m726a());
                                    if (m726a() != placesRenderPriority1EdgesNodeModel) {
                                        graphQLVisitableModel = (PlacesRenderPriority1EdgesModel) ModelHelper.a(null, this);
                                        graphQLVisitableModel.f558d = placesRenderPriority1EdgesNodeModel;
                                    }
                                }
                                if (m727j() != null) {
                                    NearbyFacepilesFragmentModel nearbyFacepilesFragmentModel = (NearbyFacepilesFragmentModel) graphQLModelMutatingVisitor.b(m727j());
                                    if (m727j() != nearbyFacepilesFragmentModel) {
                                        graphQLVisitableModel = (PlacesRenderPriority1EdgesModel) ModelHelper.a(graphQLVisitableModel, this);
                                        graphQLVisitableModel.f559e = nearbyFacepilesFragmentModel;
                                    }
                                }
                                if (m728k() != null) {
                                    SocialContextModel socialContextModel = (SocialContextModel) graphQLModelMutatingVisitor.b(m728k());
                                    if (m728k() != socialContextModel) {
                                        graphQLVisitableModel = (PlacesRenderPriority1EdgesModel) ModelHelper.a(graphQLVisitableModel, this);
                                        graphQLVisitableModel.f561g = socialContextModel;
                                    }
                                }
                                i();
                                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                            }

                            public final int m729a(FlatBufferBuilder flatBufferBuilder) {
                                h();
                                int a = ModelHelper.a(flatBufferBuilder, m726a());
                                int a2 = ModelHelper.a(flatBufferBuilder, m727j());
                                int a3 = ModelHelper.a(flatBufferBuilder, m728k());
                                flatBufferBuilder.c(4);
                                flatBufferBuilder.b(0, a);
                                flatBufferBuilder.b(1, a2);
                                flatBufferBuilder.a(2, this.f560f, 0.0d);
                                flatBufferBuilder.b(3, a3);
                                i();
                                return flatBufferBuilder.d();
                            }

                            public final void m731a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                                super.a(mutableFlatBuffer, i, obj);
                                this.f560f = mutableFlatBuffer.a(i, 2, 0.0d);
                            }
                        }

                        /* compiled from: transformData */
                        public class Serializer extends JsonSerializer<PlacesRenderPriority1Model> {
                            public final void m732a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                                PlacesRenderPriority1Model placesRenderPriority1Model = (PlacesRenderPriority1Model) obj;
                                if (placesRenderPriority1Model.w_() == null) {
                                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                    flatBufferBuilder.d(placesRenderPriority1Model.m734a(flatBufferBuilder));
                                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                    wrap.position(0);
                                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                    placesRenderPriority1Model.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                                }
                                PlacesRenderPriority1Parser.m853a(placesRenderPriority1Model.w_(), placesRenderPriority1Model.u_(), jsonGenerator, serializerProvider);
                            }

                            static {
                                FbSerializerProvider.a(PlacesRenderPriority1Model.class, new Serializer());
                            }
                        }

                        public PlacesRenderPriority1Model() {
                            super(1);
                        }

                        @Nonnull
                        private ImmutableList<PlacesRenderPriority1EdgesModel> m733a() {
                            this.f562d = super.a(this.f562d, 0, PlacesRenderPriority1EdgesModel.class);
                            return (ImmutableList) this.f562d;
                        }

                        public final int jK_() {
                            return 411881818;
                        }

                        public final GraphQLVisitableModel m735a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                            GraphQLVisitableModel graphQLVisitableModel = null;
                            h();
                            if (m733a() != null) {
                                Builder a = ModelHelper.a(m733a(), graphQLModelMutatingVisitor);
                                if (a != null) {
                                    graphQLVisitableModel = (PlacesRenderPriority1Model) ModelHelper.a(null, this);
                                    graphQLVisitableModel.f562d = a.b();
                                }
                            }
                            i();
                            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                        }

                        public final int m734a(FlatBufferBuilder flatBufferBuilder) {
                            h();
                            int a = ModelHelper.a(flatBufferBuilder, m733a());
                            flatBufferBuilder.c(1);
                            flatBufferBuilder.b(0, a);
                            i();
                            return flatBufferBuilder.d();
                        }
                    }

                    @JsonDeserialize(using = Deserializer.class)
                    @ModelWithFlatBufferFormatHash(a = -1769472802)
                    @JsonSerialize(using = Serializer.class)
                    @FragmentModelWithoutBridge
                    /* compiled from: transformData */
                    public final class PlacesRenderPriority2Model extends BaseModel implements GraphQLVisitableModel {
                        @Nullable
                        private List<PlacesRenderPriority2EdgesModel> f595d;

                        /* compiled from: transformData */
                        public class Deserializer extends FbJsonDeserializer {
                            static {
                                GlobalAutoGenDeserializerCache.a(PlacesRenderPriority2Model.class, new Deserializer());
                            }

                            public Object m736a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                flatBufferBuilder.d(PlacesRenderPriority2Parser.m872a(jsonParser, flatBufferBuilder));
                                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                wrap.position(0);
                                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                                Object placesRenderPriority2Model = new PlacesRenderPriority2Model();
                                ((BaseModel) placesRenderPriority2Model).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                                if (placesRenderPriority2Model instanceof Postprocessable) {
                                    return ((Postprocessable) placesRenderPriority2Model).a();
                                }
                                return placesRenderPriority2Model;
                            }
                        }

                        @JsonDeserialize(using = Deserializer.class)
                        @ModelWithFlatBufferFormatHash(a = 322329121)
                        @JsonSerialize(using = Serializer.class)
                        @FragmentModelWithoutBridge
                        /* compiled from: transformData */
                        public final class PlacesRenderPriority2EdgesModel extends BaseModel implements GraphQLVisitableModel {
                            @Nullable
                            private PlacesRenderPriority2EdgesNodeModel f591d;
                            @Nullable
                            private NearbyFacepilesFragmentModel f592e;
                            private double f593f;
                            @Nullable
                            private SocialContextModel f594g;

                            /* compiled from: transformData */
                            public class Deserializer extends FbJsonDeserializer {
                                static {
                                    GlobalAutoGenDeserializerCache.a(PlacesRenderPriority2EdgesModel.class, new Deserializer());
                                }

                                public Object m737a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                    flatBufferBuilder.d(PlacesRenderPriority2EdgesParser.m870b(jsonParser, flatBufferBuilder));
                                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                    wrap.position(0);
                                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                                    Object placesRenderPriority2EdgesModel = new PlacesRenderPriority2EdgesModel();
                                    ((BaseModel) placesRenderPriority2EdgesModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                                    if (placesRenderPriority2EdgesModel instanceof Postprocessable) {
                                        return ((Postprocessable) placesRenderPriority2EdgesModel).a();
                                    }
                                    return placesRenderPriority2EdgesModel;
                                }
                            }

                            @JsonDeserialize(using = Deserializer.class)
                            @ModelWithFlatBufferFormatHash(a = -1828664744)
                            @JsonSerialize(using = Serializer.class)
                            @FragmentModelWithoutBridge
                            /* compiled from: transformData */
                            public final class PlacesRenderPriority2EdgesNodeModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
                                @Nullable
                                private AddressModel f571d;
                                private boolean f572e;
                                private boolean f573f;
                                @Nullable
                                private String f574g;
                                private boolean f575h;
                                @Nullable
                                private DefaultLocationFieldsModel f576i;
                                private int f577j;
                                @Nullable
                                private String f578k;
                                private double f579l;
                                @Nullable
                                private PageLikersModel f580m;
                                @Nullable
                                private PageVisitsModel f581n;
                                @Nullable
                                private PhoneNumberModel f582o;
                                @Nullable
                                private GraphQLPlaceType f583p;
                                @Nullable
                                private ProfilePictureModel f584q;
                                private boolean f585r;
                                @Nullable
                                private RatersModel f586s;
                                @Nullable
                                private List<String> f587t;
                                @Nullable
                                private String f588u;
                                @Nullable
                                private GraphQLSavedState f589v;

                                @JsonDeserialize(using = Deserializer.class)
                                @ModelWithFlatBufferFormatHash(a = 1000273915)
                                @JsonSerialize(using = Serializer.class)
                                @FragmentModelWithoutBridge
                                /* compiled from: transformData */
                                public final class AddressModel extends BaseModel implements GraphQLVisitableModel {
                                    @Nullable
                                    private String f563d;
                                    @Nullable
                                    private String f564e;
                                    @Nullable
                                    private String f565f;

                                    /* compiled from: transformData */
                                    public class Deserializer extends FbJsonDeserializer {
                                        static {
                                            GlobalAutoGenDeserializerCache.a(AddressModel.class, new Deserializer());
                                        }

                                        public Object m738a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                            flatBufferBuilder.d(PlacesRenderPriority2EdgesNodeParser.AddressParser.m854a(jsonParser, flatBufferBuilder));
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

                                    /* compiled from: transformData */
                                    public class Serializer extends JsonSerializer<AddressModel> {
                                        public final void m739a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                                            AddressModel addressModel = (AddressModel) obj;
                                            if (addressModel.w_() == null) {
                                                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                                flatBufferBuilder.d(addressModel.m743a(flatBufferBuilder));
                                                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                                wrap.position(0);
                                                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                                addressModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                                            }
                                            PlacesRenderPriority2EdgesNodeParser.AddressParser.m855a(addressModel.w_(), addressModel.u_(), jsonGenerator);
                                        }

                                        static {
                                            FbSerializerProvider.a(AddressModel.class, new Serializer());
                                        }
                                    }

                                    public AddressModel() {
                                        super(3);
                                    }

                                    @Nullable
                                    private String m740a() {
                                        this.f563d = super.a(this.f563d, 0);
                                        return this.f563d;
                                    }

                                    @Nullable
                                    private String m741j() {
                                        this.f564e = super.a(this.f564e, 1);
                                        return this.f564e;
                                    }

                                    @Nullable
                                    private String m742k() {
                                        this.f565f = super.a(this.f565f, 2);
                                        return this.f565f;
                                    }

                                    public final int jK_() {
                                        return 799251025;
                                    }

                                    public final GraphQLVisitableModel m744a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                                        h();
                                        i();
                                        return this;
                                    }

                                    public final int m743a(FlatBufferBuilder flatBufferBuilder) {
                                        h();
                                        int b = flatBufferBuilder.b(m740a());
                                        int b2 = flatBufferBuilder.b(m741j());
                                        int b3 = flatBufferBuilder.b(m742k());
                                        flatBufferBuilder.c(3);
                                        flatBufferBuilder.b(0, b);
                                        flatBufferBuilder.b(1, b2);
                                        flatBufferBuilder.b(2, b3);
                                        i();
                                        return flatBufferBuilder.d();
                                    }
                                }

                                /* compiled from: transformData */
                                public class Deserializer extends FbJsonDeserializer {
                                    static {
                                        GlobalAutoGenDeserializerCache.a(PlacesRenderPriority2EdgesNodeModel.class, new Deserializer());
                                    }

                                    public Object m745a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                        flatBufferBuilder.d(PlacesRenderPriority2EdgesNodeParser.m866a(jsonParser, flatBufferBuilder));
                                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                        wrap.position(0);
                                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                                        Object placesRenderPriority2EdgesNodeModel = new PlacesRenderPriority2EdgesNodeModel();
                                        ((BaseModel) placesRenderPriority2EdgesNodeModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                                        if (placesRenderPriority2EdgesNodeModel instanceof Postprocessable) {
                                            return ((Postprocessable) placesRenderPriority2EdgesNodeModel).a();
                                        }
                                        return placesRenderPriority2EdgesNodeModel;
                                    }
                                }

                                @JsonDeserialize(using = Deserializer.class)
                                @ModelWithFlatBufferFormatHash(a = -1723990064)
                                @JsonSerialize(using = Serializer.class)
                                @FragmentModelWithoutBridge
                                /* compiled from: transformData */
                                public final class PageLikersModel extends BaseModel implements GraphQLVisitableModel {
                                    private int f566d;

                                    /* compiled from: transformData */
                                    public class Deserializer extends FbJsonDeserializer {
                                        static {
                                            GlobalAutoGenDeserializerCache.a(PageLikersModel.class, new Deserializer());
                                        }

                                        public Object m746a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                            flatBufferBuilder.d(PlacesRenderPriority2EdgesNodeParser.PageLikersParser.m856a(jsonParser, flatBufferBuilder));
                                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                            wrap.position(0);
                                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                            mutableFlatBuffer.a(4, Boolean.valueOf(true));
                                            MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                                            Object pageLikersModel = new PageLikersModel();
                                            ((BaseModel) pageLikersModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                                            if (pageLikersModel instanceof Postprocessable) {
                                                return ((Postprocessable) pageLikersModel).a();
                                            }
                                            return pageLikersModel;
                                        }
                                    }

                                    /* compiled from: transformData */
                                    public class Serializer extends JsonSerializer<PageLikersModel> {
                                        public final void m747a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                                            PageLikersModel pageLikersModel = (PageLikersModel) obj;
                                            if (pageLikersModel.w_() == null) {
                                                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                                flatBufferBuilder.d(pageLikersModel.m748a(flatBufferBuilder));
                                                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                                wrap.position(0);
                                                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                                pageLikersModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                                            }
                                            PlacesRenderPriority2EdgesNodeParser.PageLikersParser.m857a(pageLikersModel.w_(), pageLikersModel.u_(), jsonGenerator);
                                        }

                                        static {
                                            FbSerializerProvider.a(PageLikersModel.class, new Serializer());
                                        }
                                    }

                                    public PageLikersModel() {
                                        super(1);
                                    }

                                    public final int jK_() {
                                        return 637021669;
                                    }

                                    public final GraphQLVisitableModel m749a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                                        h();
                                        i();
                                        return this;
                                    }

                                    public final int m748a(FlatBufferBuilder flatBufferBuilder) {
                                        h();
                                        flatBufferBuilder.c(1);
                                        flatBufferBuilder.a(0, this.f566d, 0);
                                        i();
                                        return flatBufferBuilder.d();
                                    }

                                    public final void m750a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                                        super.a(mutableFlatBuffer, i, obj);
                                        this.f566d = mutableFlatBuffer.a(i, 0, 0);
                                    }
                                }

                                @JsonDeserialize(using = Deserializer.class)
                                @ModelWithFlatBufferFormatHash(a = -1723990064)
                                @JsonSerialize(using = Serializer.class)
                                @FragmentModelWithoutBridge
                                /* compiled from: transformData */
                                public final class PageVisitsModel extends BaseModel implements GraphQLVisitableModel {
                                    private int f567d;

                                    /* compiled from: transformData */
                                    public class Deserializer extends FbJsonDeserializer {
                                        static {
                                            GlobalAutoGenDeserializerCache.a(PageVisitsModel.class, new Deserializer());
                                        }

                                        public Object m751a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                            flatBufferBuilder.d(PlacesRenderPriority2EdgesNodeParser.PageVisitsParser.m858a(jsonParser, flatBufferBuilder));
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

                                    /* compiled from: transformData */
                                    public class Serializer extends JsonSerializer<PageVisitsModel> {
                                        public final void m752a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                                            PageVisitsModel pageVisitsModel = (PageVisitsModel) obj;
                                            if (pageVisitsModel.w_() == null) {
                                                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                                flatBufferBuilder.d(pageVisitsModel.m753a(flatBufferBuilder));
                                                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                                wrap.position(0);
                                                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                                pageVisitsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                                            }
                                            PlacesRenderPriority2EdgesNodeParser.PageVisitsParser.m859a(pageVisitsModel.w_(), pageVisitsModel.u_(), jsonGenerator);
                                        }

                                        static {
                                            FbSerializerProvider.a(PageVisitsModel.class, new Serializer());
                                        }
                                    }

                                    public PageVisitsModel() {
                                        super(1);
                                    }

                                    public final int jK_() {
                                        return -838301099;
                                    }

                                    public final GraphQLVisitableModel m754a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                                        h();
                                        i();
                                        return this;
                                    }

                                    public final int m753a(FlatBufferBuilder flatBufferBuilder) {
                                        h();
                                        flatBufferBuilder.c(1);
                                        flatBufferBuilder.a(0, this.f567d, 0);
                                        i();
                                        return flatBufferBuilder.d();
                                    }

                                    public final void m755a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                                        super.a(mutableFlatBuffer, i, obj);
                                        this.f567d = mutableFlatBuffer.a(i, 0, 0);
                                    }
                                }

                                @JsonDeserialize(using = Deserializer.class)
                                @ModelWithFlatBufferFormatHash(a = -760636128)
                                @JsonSerialize(using = Serializer.class)
                                @FragmentModelWithoutBridge
                                /* compiled from: transformData */
                                public final class PhoneNumberModel extends BaseModel implements GraphQLVisitableModel {
                                    @Nullable
                                    private String f568d;

                                    /* compiled from: transformData */
                                    public class Deserializer extends FbJsonDeserializer {
                                        static {
                                            GlobalAutoGenDeserializerCache.a(PhoneNumberModel.class, new Deserializer());
                                        }

                                        public Object m756a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                            flatBufferBuilder.d(PlacesRenderPriority2EdgesNodeParser.PhoneNumberParser.m860a(jsonParser, flatBufferBuilder));
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

                                    /* compiled from: transformData */
                                    public class Serializer extends JsonSerializer<PhoneNumberModel> {
                                        public final void m757a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                                            PhoneNumberModel phoneNumberModel = (PhoneNumberModel) obj;
                                            if (phoneNumberModel.w_() == null) {
                                                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                                flatBufferBuilder.d(phoneNumberModel.m759a(flatBufferBuilder));
                                                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                                wrap.position(0);
                                                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                                phoneNumberModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                                            }
                                            PlacesRenderPriority2EdgesNodeParser.PhoneNumberParser.m861a(phoneNumberModel.w_(), phoneNumberModel.u_(), jsonGenerator);
                                        }

                                        static {
                                            FbSerializerProvider.a(PhoneNumberModel.class, new Serializer());
                                        }
                                    }

                                    public PhoneNumberModel() {
                                        super(1);
                                    }

                                    @Nullable
                                    private String m758a() {
                                        this.f568d = super.a(this.f568d, 0);
                                        return this.f568d;
                                    }

                                    public final int jK_() {
                                        return 474898999;
                                    }

                                    public final GraphQLVisitableModel m760a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                                        h();
                                        i();
                                        return this;
                                    }

                                    public final int m759a(FlatBufferBuilder flatBufferBuilder) {
                                        h();
                                        int b = flatBufferBuilder.b(m758a());
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
                                /* compiled from: transformData */
                                public final class ProfilePictureModel extends BaseModel implements GraphQLVisitableModel {
                                    @Nullable
                                    private String f569d;

                                    /* compiled from: transformData */
                                    public class Deserializer extends FbJsonDeserializer {
                                        static {
                                            GlobalAutoGenDeserializerCache.a(ProfilePictureModel.class, new Deserializer());
                                        }

                                        public Object m761a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                            flatBufferBuilder.d(PlacesRenderPriority2EdgesNodeParser.ProfilePictureParser.m862a(jsonParser, flatBufferBuilder));
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

                                    /* compiled from: transformData */
                                    public class Serializer extends JsonSerializer<ProfilePictureModel> {
                                        public final void m762a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                                            ProfilePictureModel profilePictureModel = (ProfilePictureModel) obj;
                                            if (profilePictureModel.w_() == null) {
                                                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                                flatBufferBuilder.d(profilePictureModel.m764a(flatBufferBuilder));
                                                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                                wrap.position(0);
                                                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                                profilePictureModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                                            }
                                            PlacesRenderPriority2EdgesNodeParser.ProfilePictureParser.m863a(profilePictureModel.w_(), profilePictureModel.u_(), jsonGenerator);
                                        }

                                        static {
                                            FbSerializerProvider.a(ProfilePictureModel.class, new Serializer());
                                        }
                                    }

                                    public ProfilePictureModel() {
                                        super(1);
                                    }

                                    @Nullable
                                    private String m763a() {
                                        this.f569d = super.a(this.f569d, 0);
                                        return this.f569d;
                                    }

                                    public final int jK_() {
                                        return 70760763;
                                    }

                                    public final GraphQLVisitableModel m765a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                                        h();
                                        i();
                                        return this;
                                    }

                                    public final int m764a(FlatBufferBuilder flatBufferBuilder) {
                                        h();
                                        int b = flatBufferBuilder.b(m763a());
                                        flatBufferBuilder.c(1);
                                        flatBufferBuilder.b(0, b);
                                        i();
                                        return flatBufferBuilder.d();
                                    }
                                }

                                @JsonDeserialize(using = Deserializer.class)
                                @ModelWithFlatBufferFormatHash(a = -1723990064)
                                @JsonSerialize(using = Serializer.class)
                                @FragmentModelWithoutBridge
                                /* compiled from: transformData */
                                public final class RatersModel extends BaseModel implements GraphQLVisitableModel {
                                    private int f570d;

                                    /* compiled from: transformData */
                                    public class Deserializer extends FbJsonDeserializer {
                                        static {
                                            GlobalAutoGenDeserializerCache.a(RatersModel.class, new Deserializer());
                                        }

                                        public Object m766a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                            flatBufferBuilder.d(PlacesRenderPriority2EdgesNodeParser.RatersParser.m864a(jsonParser, flatBufferBuilder));
                                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                            wrap.position(0);
                                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                            mutableFlatBuffer.a(4, Boolean.valueOf(true));
                                            MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                                            Object ratersModel = new RatersModel();
                                            ((BaseModel) ratersModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                                            if (ratersModel instanceof Postprocessable) {
                                                return ((Postprocessable) ratersModel).a();
                                            }
                                            return ratersModel;
                                        }
                                    }

                                    /* compiled from: transformData */
                                    public class Serializer extends JsonSerializer<RatersModel> {
                                        public final void m767a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                                            RatersModel ratersModel = (RatersModel) obj;
                                            if (ratersModel.w_() == null) {
                                                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                                flatBufferBuilder.d(ratersModel.m768a(flatBufferBuilder));
                                                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                                wrap.position(0);
                                                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                                ratersModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                                            }
                                            PlacesRenderPriority2EdgesNodeParser.RatersParser.m865a(ratersModel.w_(), ratersModel.u_(), jsonGenerator);
                                        }

                                        static {
                                            FbSerializerProvider.a(RatersModel.class, new Serializer());
                                        }
                                    }

                                    public RatersModel() {
                                        super(1);
                                    }

                                    public final int jK_() {
                                        return -24998752;
                                    }

                                    public final GraphQLVisitableModel m769a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                                        h();
                                        i();
                                        return this;
                                    }

                                    public final int m768a(FlatBufferBuilder flatBufferBuilder) {
                                        h();
                                        flatBufferBuilder.c(1);
                                        flatBufferBuilder.a(0, this.f570d, 0);
                                        i();
                                        return flatBufferBuilder.d();
                                    }

                                    public final void m770a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                                        super.a(mutableFlatBuffer, i, obj);
                                        this.f570d = mutableFlatBuffer.a(i, 0, 0);
                                    }
                                }

                                /* compiled from: transformData */
                                public class Serializer extends JsonSerializer<PlacesRenderPriority2EdgesNodeModel> {
                                    public final void m771a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                                        PlacesRenderPriority2EdgesNodeModel placesRenderPriority2EdgesNodeModel = (PlacesRenderPriority2EdgesNodeModel) obj;
                                        if (placesRenderPriority2EdgesNodeModel.w_() == null) {
                                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                            flatBufferBuilder.d(placesRenderPriority2EdgesNodeModel.m787a(flatBufferBuilder));
                                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                            wrap.position(0);
                                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                            placesRenderPriority2EdgesNodeModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                                        }
                                        PlacesRenderPriority2EdgesNodeParser.m867a(placesRenderPriority2EdgesNodeModel.w_(), placesRenderPriority2EdgesNodeModel.u_(), jsonGenerator, serializerProvider);
                                    }

                                    static {
                                        FbSerializerProvider.a(PlacesRenderPriority2EdgesNodeModel.class, new Serializer());
                                    }
                                }

                                public PlacesRenderPriority2EdgesNodeModel() {
                                    super(19);
                                }

                                public final void m791a(String str, ConsistencyTuple consistencyTuple) {
                                    if ("does_viewer_like".equals(str)) {
                                        consistencyTuple.a = Boolean.valueOf(m774k());
                                        consistencyTuple.b = u_();
                                        consistencyTuple.c = 2;
                                        return;
                                    }
                                    consistencyTuple.a();
                                }

                                public final void m792a(String str, Object obj, boolean z) {
                                    if ("does_viewer_like".equals(str)) {
                                        m772a(((Boolean) obj).booleanValue());
                                    }
                                }

                                @Nullable
                                private AddressModel m773j() {
                                    this.f571d = (AddressModel) super.a(this.f571d, 0, AddressModel.class);
                                    return this.f571d;
                                }

                                private boolean m774k() {
                                    a(0, 2);
                                    return this.f573f;
                                }

                                private void m772a(boolean z) {
                                    this.f573f = z;
                                    if (this.b != null && this.b.d) {
                                        this.b.a(this.c, 2, z);
                                    }
                                }

                                @Nullable
                                private String m775l() {
                                    this.f574g = super.a(this.f574g, 3);
                                    return this.f574g;
                                }

                                @Nullable
                                private DefaultLocationFieldsModel m776m() {
                                    this.f576i = (DefaultLocationFieldsModel) super.a(this.f576i, 5, DefaultLocationFieldsModel.class);
                                    return this.f576i;
                                }

                                @Nullable
                                private String m777n() {
                                    this.f578k = super.a(this.f578k, 7);
                                    return this.f578k;
                                }

                                @Nullable
                                private PageLikersModel m778o() {
                                    this.f580m = (PageLikersModel) super.a(this.f580m, 9, PageLikersModel.class);
                                    return this.f580m;
                                }

                                @Nullable
                                private PageVisitsModel m779p() {
                                    this.f581n = (PageVisitsModel) super.a(this.f581n, 10, PageVisitsModel.class);
                                    return this.f581n;
                                }

                                @Nullable
                                private PhoneNumberModel m780q() {
                                    this.f582o = (PhoneNumberModel) super.a(this.f582o, 11, PhoneNumberModel.class);
                                    return this.f582o;
                                }

                                @Nullable
                                private GraphQLPlaceType m781r() {
                                    this.f583p = (GraphQLPlaceType) super.b(this.f583p, 12, GraphQLPlaceType.class, GraphQLPlaceType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
                                    return this.f583p;
                                }

                                @Nullable
                                private ProfilePictureModel m782s() {
                                    this.f584q = (ProfilePictureModel) super.a(this.f584q, 13, ProfilePictureModel.class);
                                    return this.f584q;
                                }

                                @Nullable
                                private RatersModel m783t() {
                                    this.f586s = (RatersModel) super.a(this.f586s, 15, RatersModel.class);
                                    return this.f586s;
                                }

                                @Nonnull
                                private ImmutableList<String> m784u() {
                                    this.f587t = super.a(this.f587t, 16);
                                    return (ImmutableList) this.f587t;
                                }

                                @Nullable
                                private String m785v() {
                                    this.f588u = super.a(this.f588u, 17);
                                    return this.f588u;
                                }

                                @Nullable
                                private GraphQLSavedState m786w() {
                                    this.f589v = (GraphQLSavedState) super.b(this.f589v, 18, GraphQLSavedState.class, GraphQLSavedState.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
                                    return this.f589v;
                                }

                                @Nullable
                                public final String m789a() {
                                    return m775l();
                                }

                                public final int jK_() {
                                    return 2479791;
                                }

                                public final GraphQLVisitableModel m788a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                                    GraphQLVisitableModel graphQLVisitableModel = null;
                                    h();
                                    if (m773j() != null) {
                                        AddressModel addressModel = (AddressModel) graphQLModelMutatingVisitor.b(m773j());
                                        if (m773j() != addressModel) {
                                            graphQLVisitableModel = (PlacesRenderPriority2EdgesNodeModel) ModelHelper.a(null, this);
                                            graphQLVisitableModel.f571d = addressModel;
                                        }
                                    }
                                    if (m776m() != null) {
                                        DefaultLocationFieldsModel defaultLocationFieldsModel = (DefaultLocationFieldsModel) graphQLModelMutatingVisitor.b(m776m());
                                        if (m776m() != defaultLocationFieldsModel) {
                                            graphQLVisitableModel = (PlacesRenderPriority2EdgesNodeModel) ModelHelper.a(graphQLVisitableModel, this);
                                            graphQLVisitableModel.f576i = defaultLocationFieldsModel;
                                        }
                                    }
                                    if (m778o() != null) {
                                        PageLikersModel pageLikersModel = (PageLikersModel) graphQLModelMutatingVisitor.b(m778o());
                                        if (m778o() != pageLikersModel) {
                                            graphQLVisitableModel = (PlacesRenderPriority2EdgesNodeModel) ModelHelper.a(graphQLVisitableModel, this);
                                            graphQLVisitableModel.f580m = pageLikersModel;
                                        }
                                    }
                                    if (m779p() != null) {
                                        PageVisitsModel pageVisitsModel = (PageVisitsModel) graphQLModelMutatingVisitor.b(m779p());
                                        if (m779p() != pageVisitsModel) {
                                            graphQLVisitableModel = (PlacesRenderPriority2EdgesNodeModel) ModelHelper.a(graphQLVisitableModel, this);
                                            graphQLVisitableModel.f581n = pageVisitsModel;
                                        }
                                    }
                                    if (m780q() != null) {
                                        PhoneNumberModel phoneNumberModel = (PhoneNumberModel) graphQLModelMutatingVisitor.b(m780q());
                                        if (m780q() != phoneNumberModel) {
                                            graphQLVisitableModel = (PlacesRenderPriority2EdgesNodeModel) ModelHelper.a(graphQLVisitableModel, this);
                                            graphQLVisitableModel.f582o = phoneNumberModel;
                                        }
                                    }
                                    if (m782s() != null) {
                                        ProfilePictureModel profilePictureModel = (ProfilePictureModel) graphQLModelMutatingVisitor.b(m782s());
                                        if (m782s() != profilePictureModel) {
                                            graphQLVisitableModel = (PlacesRenderPriority2EdgesNodeModel) ModelHelper.a(graphQLVisitableModel, this);
                                            graphQLVisitableModel.f584q = profilePictureModel;
                                        }
                                    }
                                    if (m783t() != null) {
                                        RatersModel ratersModel = (RatersModel) graphQLModelMutatingVisitor.b(m783t());
                                        if (m783t() != ratersModel) {
                                            graphQLVisitableModel = (PlacesRenderPriority2EdgesNodeModel) ModelHelper.a(graphQLVisitableModel, this);
                                            graphQLVisitableModel.f586s = ratersModel;
                                        }
                                    }
                                    i();
                                    return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                                }

                                public final int m787a(FlatBufferBuilder flatBufferBuilder) {
                                    h();
                                    int a = ModelHelper.a(flatBufferBuilder, m773j());
                                    int b = flatBufferBuilder.b(m775l());
                                    int a2 = ModelHelper.a(flatBufferBuilder, m776m());
                                    int b2 = flatBufferBuilder.b(m777n());
                                    int a3 = ModelHelper.a(flatBufferBuilder, m778o());
                                    int a4 = ModelHelper.a(flatBufferBuilder, m779p());
                                    int a5 = ModelHelper.a(flatBufferBuilder, m780q());
                                    int a6 = flatBufferBuilder.a(m781r());
                                    int a7 = ModelHelper.a(flatBufferBuilder, m782s());
                                    int a8 = ModelHelper.a(flatBufferBuilder, m783t());
                                    int c = flatBufferBuilder.c(m784u());
                                    int b3 = flatBufferBuilder.b(m785v());
                                    int a9 = flatBufferBuilder.a(m786w());
                                    flatBufferBuilder.c(19);
                                    flatBufferBuilder.b(0, a);
                                    flatBufferBuilder.a(1, this.f572e);
                                    flatBufferBuilder.a(2, this.f573f);
                                    flatBufferBuilder.b(3, b);
                                    flatBufferBuilder.a(4, this.f575h);
                                    flatBufferBuilder.b(5, a2);
                                    flatBufferBuilder.a(6, this.f577j, 0);
                                    flatBufferBuilder.b(7, b2);
                                    flatBufferBuilder.a(8, this.f579l, 0.0d);
                                    flatBufferBuilder.b(9, a3);
                                    flatBufferBuilder.b(10, a4);
                                    flatBufferBuilder.b(11, a5);
                                    flatBufferBuilder.b(12, a6);
                                    flatBufferBuilder.b(13, a7);
                                    flatBufferBuilder.a(14, this.f585r);
                                    flatBufferBuilder.b(15, a8);
                                    flatBufferBuilder.b(16, c);
                                    flatBufferBuilder.b(17, b3);
                                    flatBufferBuilder.b(18, a9);
                                    i();
                                    return flatBufferBuilder.d();
                                }

                                public final void m790a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                                    super.a(mutableFlatBuffer, i, obj);
                                    this.f572e = mutableFlatBuffer.a(i, 1);
                                    this.f573f = mutableFlatBuffer.a(i, 2);
                                    this.f575h = mutableFlatBuffer.a(i, 4);
                                    this.f577j = mutableFlatBuffer.a(i, 6, 0);
                                    this.f579l = mutableFlatBuffer.a(i, 8, 0.0d);
                                    this.f585r = mutableFlatBuffer.a(i, 14);
                                }
                            }

                            /* compiled from: transformData */
                            public class Serializer extends JsonSerializer<PlacesRenderPriority2EdgesModel> {
                                public final void m793a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                                    PlacesRenderPriority2EdgesModel placesRenderPriority2EdgesModel = (PlacesRenderPriority2EdgesModel) obj;
                                    if (placesRenderPriority2EdgesModel.w_() == null) {
                                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                        flatBufferBuilder.d(placesRenderPriority2EdgesModel.m802a(flatBufferBuilder));
                                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                        wrap.position(0);
                                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                        placesRenderPriority2EdgesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                                    }
                                    PlacesRenderPriority2EdgesParser.m871b(placesRenderPriority2EdgesModel.w_(), placesRenderPriority2EdgesModel.u_(), jsonGenerator, serializerProvider);
                                }

                                static {
                                    FbSerializerProvider.a(PlacesRenderPriority2EdgesModel.class, new Serializer());
                                }
                            }

                            @JsonDeserialize(using = Deserializer.class)
                            @ModelWithFlatBufferFormatHash(a = -1352864475)
                            @JsonSerialize(using = Serializer.class)
                            @FragmentModelWithoutBridge
                            /* compiled from: transformData */
                            public final class SocialContextModel extends BaseModel implements GraphQLVisitableModel {
                                @Nullable
                                private String f590d;

                                /* compiled from: transformData */
                                public class Deserializer extends FbJsonDeserializer {
                                    static {
                                        GlobalAutoGenDeserializerCache.a(SocialContextModel.class, new Deserializer());
                                    }

                                    public Object m794a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                        flatBufferBuilder.d(PlacesRenderPriority2EdgesParser.SocialContextParser.m868a(jsonParser, flatBufferBuilder));
                                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                        wrap.position(0);
                                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                                        Object socialContextModel = new SocialContextModel();
                                        ((BaseModel) socialContextModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                                        if (socialContextModel instanceof Postprocessable) {
                                            return ((Postprocessable) socialContextModel).a();
                                        }
                                        return socialContextModel;
                                    }
                                }

                                /* compiled from: transformData */
                                public class Serializer extends JsonSerializer<SocialContextModel> {
                                    public final void m795a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                                        SocialContextModel socialContextModel = (SocialContextModel) obj;
                                        if (socialContextModel.w_() == null) {
                                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                            flatBufferBuilder.d(socialContextModel.m797a(flatBufferBuilder));
                                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                            wrap.position(0);
                                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                            socialContextModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                                        }
                                        PlacesRenderPriority2EdgesParser.SocialContextParser.m869a(socialContextModel.w_(), socialContextModel.u_(), jsonGenerator);
                                    }

                                    static {
                                        FbSerializerProvider.a(SocialContextModel.class, new Serializer());
                                    }
                                }

                                public SocialContextModel() {
                                    super(1);
                                }

                                @Nullable
                                private String m796a() {
                                    this.f590d = super.a(this.f590d, 0);
                                    return this.f590d;
                                }

                                public final int jK_() {
                                    return -1919764332;
                                }

                                public final GraphQLVisitableModel m798a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                                    h();
                                    i();
                                    return this;
                                }

                                public final int m797a(FlatBufferBuilder flatBufferBuilder) {
                                    h();
                                    int b = flatBufferBuilder.b(m796a());
                                    flatBufferBuilder.c(1);
                                    flatBufferBuilder.b(0, b);
                                    i();
                                    return flatBufferBuilder.d();
                                }
                            }

                            public PlacesRenderPriority2EdgesModel() {
                                super(4);
                            }

                            @Nullable
                            private PlacesRenderPriority2EdgesNodeModel m799a() {
                                this.f591d = (PlacesRenderPriority2EdgesNodeModel) super.a(this.f591d, 0, PlacesRenderPriority2EdgesNodeModel.class);
                                return this.f591d;
                            }

                            @Nullable
                            private NearbyFacepilesFragmentModel m800j() {
                                this.f592e = (NearbyFacepilesFragmentModel) super.a(this.f592e, 1, NearbyFacepilesFragmentModel.class);
                                return this.f592e;
                            }

                            @Nullable
                            private SocialContextModel m801k() {
                                this.f594g = (SocialContextModel) super.a(this.f594g, 3, SocialContextModel.class);
                                return this.f594g;
                            }

                            public final int jK_() {
                                return -833204935;
                            }

                            public final GraphQLVisitableModel m803a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                                GraphQLVisitableModel graphQLVisitableModel = null;
                                h();
                                if (m799a() != null) {
                                    PlacesRenderPriority2EdgesNodeModel placesRenderPriority2EdgesNodeModel = (PlacesRenderPriority2EdgesNodeModel) graphQLModelMutatingVisitor.b(m799a());
                                    if (m799a() != placesRenderPriority2EdgesNodeModel) {
                                        graphQLVisitableModel = (PlacesRenderPriority2EdgesModel) ModelHelper.a(null, this);
                                        graphQLVisitableModel.f591d = placesRenderPriority2EdgesNodeModel;
                                    }
                                }
                                if (m800j() != null) {
                                    NearbyFacepilesFragmentModel nearbyFacepilesFragmentModel = (NearbyFacepilesFragmentModel) graphQLModelMutatingVisitor.b(m800j());
                                    if (m800j() != nearbyFacepilesFragmentModel) {
                                        graphQLVisitableModel = (PlacesRenderPriority2EdgesModel) ModelHelper.a(graphQLVisitableModel, this);
                                        graphQLVisitableModel.f592e = nearbyFacepilesFragmentModel;
                                    }
                                }
                                if (m801k() != null) {
                                    SocialContextModel socialContextModel = (SocialContextModel) graphQLModelMutatingVisitor.b(m801k());
                                    if (m801k() != socialContextModel) {
                                        graphQLVisitableModel = (PlacesRenderPriority2EdgesModel) ModelHelper.a(graphQLVisitableModel, this);
                                        graphQLVisitableModel.f594g = socialContextModel;
                                    }
                                }
                                i();
                                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                            }

                            public final int m802a(FlatBufferBuilder flatBufferBuilder) {
                                h();
                                int a = ModelHelper.a(flatBufferBuilder, m799a());
                                int a2 = ModelHelper.a(flatBufferBuilder, m800j());
                                int a3 = ModelHelper.a(flatBufferBuilder, m801k());
                                flatBufferBuilder.c(4);
                                flatBufferBuilder.b(0, a);
                                flatBufferBuilder.b(1, a2);
                                flatBufferBuilder.a(2, this.f593f, 0.0d);
                                flatBufferBuilder.b(3, a3);
                                i();
                                return flatBufferBuilder.d();
                            }

                            public final void m804a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                                super.a(mutableFlatBuffer, i, obj);
                                this.f593f = mutableFlatBuffer.a(i, 2, 0.0d);
                            }
                        }

                        /* compiled from: transformData */
                        public class Serializer extends JsonSerializer<PlacesRenderPriority2Model> {
                            public final void m805a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                                PlacesRenderPriority2Model placesRenderPriority2Model = (PlacesRenderPriority2Model) obj;
                                if (placesRenderPriority2Model.w_() == null) {
                                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                    flatBufferBuilder.d(placesRenderPriority2Model.m807a(flatBufferBuilder));
                                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                    wrap.position(0);
                                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                    placesRenderPriority2Model.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                                }
                                PlacesRenderPriority2Parser.m873a(placesRenderPriority2Model.w_(), placesRenderPriority2Model.u_(), jsonGenerator, serializerProvider);
                            }

                            static {
                                FbSerializerProvider.a(PlacesRenderPriority2Model.class, new Serializer());
                            }
                        }

                        public PlacesRenderPriority2Model() {
                            super(1);
                        }

                        @Nonnull
                        private ImmutableList<PlacesRenderPriority2EdgesModel> m806a() {
                            this.f595d = super.a(this.f595d, 0, PlacesRenderPriority2EdgesModel.class);
                            return (ImmutableList) this.f595d;
                        }

                        public final int jK_() {
                            return 411881818;
                        }

                        public final GraphQLVisitableModel m808a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                            GraphQLVisitableModel graphQLVisitableModel = null;
                            h();
                            if (m806a() != null) {
                                Builder a = ModelHelper.a(m806a(), graphQLModelMutatingVisitor);
                                if (a != null) {
                                    graphQLVisitableModel = (PlacesRenderPriority2Model) ModelHelper.a(null, this);
                                    graphQLVisitableModel.f595d = a.b();
                                }
                            }
                            i();
                            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                        }

                        public final int m807a(FlatBufferBuilder flatBufferBuilder) {
                            h();
                            int a = ModelHelper.a(flatBufferBuilder, m806a());
                            flatBufferBuilder.c(1);
                            flatBufferBuilder.b(0, a);
                            i();
                            return flatBufferBuilder.d();
                        }
                    }

                    /* compiled from: transformData */
                    public class Serializer extends JsonSerializer<NodeModel> {
                        public final void m809a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                            NodeModel nodeModel = (NodeModel) obj;
                            if (nodeModel.w_() == null) {
                                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                flatBufferBuilder.d(nodeModel.m814a(flatBufferBuilder));
                                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                wrap.position(0);
                                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                nodeModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                            }
                            NodeParser.m875a(nodeModel.w_(), nodeModel.u_(), jsonGenerator, serializerProvider);
                        }

                        static {
                            FbSerializerProvider.a(NodeModel.class, new Serializer());
                        }
                    }

                    public NodeModel() {
                        super(8);
                    }

                    @Nullable
                    private NearbyGeoRectangleModel m810a() {
                        this.f596d = (NearbyGeoRectangleModel) super.a(this.f596d, 0, NearbyGeoRectangleModel.class);
                        return this.f596d;
                    }

                    @Nullable
                    private PlacesRenderPriority1Model m811j() {
                        this.f600h = (PlacesRenderPriority1Model) super.a(this.f600h, 4, PlacesRenderPriority1Model.class);
                        return this.f600h;
                    }

                    @Nullable
                    private PlacesRenderPriority2Model m812k() {
                        this.f601i = (PlacesRenderPriority2Model) super.a(this.f601i, 5, PlacesRenderPriority2Model.class);
                        return this.f601i;
                    }

                    @Nullable
                    private String m813l() {
                        this.f602j = super.a(this.f602j, 6);
                        return this.f602j;
                    }

                    public final int jK_() {
                        return 1745020218;
                    }

                    public final GraphQLVisitableModel m815a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                        GraphQLVisitableModel graphQLVisitableModel = null;
                        h();
                        if (m810a() != null) {
                            NearbyGeoRectangleModel nearbyGeoRectangleModel = (NearbyGeoRectangleModel) graphQLModelMutatingVisitor.b(m810a());
                            if (m810a() != nearbyGeoRectangleModel) {
                                graphQLVisitableModel = (NodeModel) ModelHelper.a(null, this);
                                graphQLVisitableModel.f596d = nearbyGeoRectangleModel;
                            }
                        }
                        if (m811j() != null) {
                            PlacesRenderPriority1Model placesRenderPriority1Model = (PlacesRenderPriority1Model) graphQLModelMutatingVisitor.b(m811j());
                            if (m811j() != placesRenderPriority1Model) {
                                graphQLVisitableModel = (NodeModel) ModelHelper.a(graphQLVisitableModel, this);
                                graphQLVisitableModel.f600h = placesRenderPriority1Model;
                            }
                        }
                        if (m812k() != null) {
                            PlacesRenderPriority2Model placesRenderPriority2Model = (PlacesRenderPriority2Model) graphQLModelMutatingVisitor.b(m812k());
                            if (m812k() != placesRenderPriority2Model) {
                                graphQLVisitableModel = (NodeModel) ModelHelper.a(graphQLVisitableModel, this);
                                graphQLVisitableModel.f601i = placesRenderPriority2Model;
                            }
                        }
                        i();
                        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                    }

                    public final int m814a(FlatBufferBuilder flatBufferBuilder) {
                        h();
                        int a = ModelHelper.a(flatBufferBuilder, m810a());
                        int a2 = ModelHelper.a(flatBufferBuilder, m811j());
                        int a3 = ModelHelper.a(flatBufferBuilder, m812k());
                        int b = flatBufferBuilder.b(m813l());
                        flatBufferBuilder.c(8);
                        flatBufferBuilder.b(0, a);
                        flatBufferBuilder.a(1, this.f597e, 0);
                        flatBufferBuilder.a(2, this.f598f, 0.0d);
                        flatBufferBuilder.a(3, this.f599g, 0.0d);
                        flatBufferBuilder.b(4, a2);
                        flatBufferBuilder.b(5, a3);
                        flatBufferBuilder.b(6, b);
                        flatBufferBuilder.a(7, this.f603k, 0);
                        i();
                        return flatBufferBuilder.d();
                    }

                    public final void m816a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                        super.a(mutableFlatBuffer, i, obj);
                        this.f597e = mutableFlatBuffer.a(i, 1, 0);
                        this.f598f = mutableFlatBuffer.a(i, 2, 0.0d);
                        this.f599g = mutableFlatBuffer.a(i, 3, 0.0d);
                        this.f603k = mutableFlatBuffer.a(i, 7, 0);
                    }
                }

                /* compiled from: transformData */
                public class Serializer extends JsonSerializer<EdgesModel> {
                    public final void m817a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        EdgesModel edgesModel = (EdgesModel) obj;
                        if (edgesModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(edgesModel.m819a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            edgesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        EdgesParser.m877b(edgesModel.w_(), edgesModel.u_(), jsonGenerator, serializerProvider);
                    }

                    static {
                        FbSerializerProvider.a(EdgesModel.class, new Serializer());
                    }
                }

                public EdgesModel() {
                    super(1);
                }

                @Nullable
                private NodeModel m818a() {
                    this.f604d = (NodeModel) super.a(this.f604d, 0, NodeModel.class);
                    return this.f604d;
                }

                public final int jK_() {
                    return 2020786134;
                }

                public final GraphQLVisitableModel m820a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    GraphQLVisitableModel graphQLVisitableModel = null;
                    h();
                    if (m818a() != null) {
                        NodeModel nodeModel = (NodeModel) graphQLModelMutatingVisitor.b(m818a());
                        if (m818a() != nodeModel) {
                            graphQLVisitableModel = (EdgesModel) ModelHelper.a(null, this);
                            graphQLVisitableModel.f604d = nodeModel;
                        }
                    }
                    i();
                    return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                }

                public final int m819a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int a = ModelHelper.a(flatBufferBuilder, m818a());
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.b(0, a);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            /* compiled from: transformData */
            public class Serializer extends JsonSerializer<TilesModel> {
                public final void m821a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    TilesModel tilesModel = (TilesModel) obj;
                    if (tilesModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(tilesModel.m826a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        tilesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    TilesParser.m879a(tilesModel.w_(), tilesModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(TilesModel.class, new Serializer());
                }
            }

            public TilesModel() {
                super(4);
            }

            @Nullable
            private String m822a() {
                this.f605d = super.a(this.f605d, 0);
                return this.f605d;
            }

            @Nullable
            private NearbyGeoRectangleModel m823j() {
                this.f606e = (NearbyGeoRectangleModel) super.a(this.f606e, 1, NearbyGeoRectangleModel.class);
                return this.f606e;
            }

            @Nonnull
            private ImmutableList<EdgesModel> m824k() {
                this.f607f = super.a(this.f607f, 2, EdgesModel.class);
                return (ImmutableList) this.f607f;
            }

            @Nullable
            private String m825l() {
                this.f608g = super.a(this.f608g, 3);
                return this.f608g;
            }

            public final int jK_() {
                return -1254221257;
            }

            public final GraphQLVisitableModel m827a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m823j() != null) {
                    NearbyGeoRectangleModel nearbyGeoRectangleModel = (NearbyGeoRectangleModel) graphQLModelMutatingVisitor.b(m823j());
                    if (m823j() != nearbyGeoRectangleModel) {
                        graphQLVisitableModel = (TilesModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f606e = nearbyGeoRectangleModel;
                    }
                }
                if (m824k() != null) {
                    Builder a = ModelHelper.a(m824k(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        TilesModel tilesModel = (TilesModel) ModelHelper.a(graphQLVisitableModel, this);
                        tilesModel.f607f = a.b();
                        graphQLVisitableModel = tilesModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m826a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m822a());
                int a = ModelHelper.a(flatBufferBuilder, m823j());
                int a2 = ModelHelper.a(flatBufferBuilder, m824k());
                int b2 = flatBufferBuilder.b(m825l());
                flatBufferBuilder.c(4);
                flatBufferBuilder.b(0, b);
                flatBufferBuilder.b(1, a);
                flatBufferBuilder.b(2, a2);
                flatBufferBuilder.b(3, b2);
                i();
                return flatBufferBuilder.d();
            }
        }

        public NearbyTilesModel() {
            super(2);
        }

        @Nullable
        private String m828a() {
            this.f609d = super.a(this.f609d, 0);
            return this.f609d;
        }

        @Nullable
        private TilesModel m829j() {
            this.f610e = (TilesModel) super.a(this.f610e, 1, TilesModel.class);
            return this.f610e;
        }

        public final int jK_() {
            return -608734554;
        }

        public final GraphQLVisitableModel m831a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m829j() != null) {
                TilesModel tilesModel = (TilesModel) graphQLModelMutatingVisitor.b(m829j());
                if (m829j() != tilesModel) {
                    graphQLVisitableModel = (NearbyTilesModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f610e = tilesModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m830a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(m828a());
            int a = ModelHelper.a(flatBufferBuilder, m829j());
            flatBufferBuilder.c(2);
            flatBufferBuilder.b(0, b);
            flatBufferBuilder.b(1, a);
            i();
            return flatBufferBuilder.d();
        }
    }
}
