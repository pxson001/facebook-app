package com.facebook.adinterfaces.protocol;

import com.facebook.adinterfaces.protocol.AdInterfacesGeocodeQueryParsers.AdInterfacesGeocodeQueryParser;
import com.facebook.adinterfaces.protocol.AdInterfacesGeocodeQueryParsers.AdInterfacesGeocodeQueryParser.GeocodeAddressDataParser;
import com.facebook.adinterfaces.protocol.AdInterfacesGeocodeQueryParsers.AdInterfacesGeocodeQueryParser.GeocodeAddressDataParser.EdgesParser;
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
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.facebook.zero.iptest.graphql.ZeroIPTestGraphQLParsers.ZeroIPTestSubmitMutationParser;
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

/* compiled from: ['user'] */
public class AdInterfacesGeocodeQueryModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -1607776741)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: ['user'] */
    public final class AdInterfacesGeocodeQueryModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private GeocodeAddressDataModel f21923d;

        /* compiled from: ['user'] */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(AdInterfacesGeocodeQueryModel.class, new Deserializer());
            }

            public Object m23020a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = AdInterfacesGeocodeQueryParser.m23039a(jsonParser);
                Object adInterfacesGeocodeQueryModel = new AdInterfacesGeocodeQueryModel();
                ((BaseModel) adInterfacesGeocodeQueryModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (adInterfacesGeocodeQueryModel instanceof Postprocessable) {
                    return ((Postprocessable) adInterfacesGeocodeQueryModel).a();
                }
                return adInterfacesGeocodeQueryModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 622450257)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: ['user'] */
        public final class GeocodeAddressDataModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private List<EdgesModel> f21922d;

            /* compiled from: ['user'] */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(GeocodeAddressDataModel.class, new Deserializer());
                }

                public Object m23021a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(GeocodeAddressDataParser.m23037a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object geocodeAddressDataModel = new GeocodeAddressDataModel();
                    ((BaseModel) geocodeAddressDataModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (geocodeAddressDataModel instanceof Postprocessable) {
                        return ((Postprocessable) geocodeAddressDataModel).a();
                    }
                    return geocodeAddressDataModel;
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = -98882802)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: ['user'] */
            public final class EdgesModel extends BaseModel implements GraphQLVisitableModel {
                private int f21920d;
                @Nullable
                private com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.GeocodeAddressDataModel f21921e;

                /* compiled from: ['user'] */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(EdgesModel.class, new Deserializer());
                    }

                    public Object m23022a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(EdgesParser.m23036b(jsonParser, flatBufferBuilder));
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

                /* compiled from: ['user'] */
                public class Serializer extends JsonSerializer<EdgesModel> {
                    public final void m23023a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        EdgesModel edgesModel = (EdgesModel) obj;
                        if (edgesModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(edgesModel.m23024a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            edgesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        ZeroIPTestSubmitMutationParser.b(edgesModel.w_(), edgesModel.u_(), jsonGenerator, serializerProvider);
                    }

                    static {
                        FbSerializerProvider.a(EdgesModel.class, new Serializer());
                    }
                }

                public EdgesModel() {
                    super(2);
                }

                @Nullable
                public final com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.GeocodeAddressDataModel m23025a() {
                    this.f21921e = (com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.GeocodeAddressDataModel) super.a(this.f21921e, 1, com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.GeocodeAddressDataModel.class);
                    return this.f21921e;
                }

                public final int jK_() {
                    return -475540611;
                }

                public final GraphQLVisitableModel m23026a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    GraphQLVisitableModel graphQLVisitableModel = null;
                    h();
                    if (m23025a() != null) {
                        com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.GeocodeAddressDataModel geocodeAddressDataModel = (com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.GeocodeAddressDataModel) graphQLModelMutatingVisitor.b(m23025a());
                        if (m23025a() != geocodeAddressDataModel) {
                            graphQLVisitableModel = (EdgesModel) ModelHelper.a(null, this);
                            graphQLVisitableModel.f21921e = geocodeAddressDataModel;
                        }
                    }
                    i();
                    return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                }

                public final int m23024a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int a = ModelHelper.a(flatBufferBuilder, m23025a());
                    flatBufferBuilder.c(2);
                    flatBufferBuilder.a(0, this.f21920d, 0);
                    flatBufferBuilder.b(1, a);
                    i();
                    return flatBufferBuilder.d();
                }

                public final void m23027a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                    super.a(mutableFlatBuffer, i, obj);
                    this.f21920d = mutableFlatBuffer.a(i, 0, 0);
                }
            }

            /* compiled from: ['user'] */
            public class Serializer extends JsonSerializer<GeocodeAddressDataModel> {
                public final void m23028a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    GeocodeAddressDataModel geocodeAddressDataModel = (GeocodeAddressDataModel) obj;
                    if (geocodeAddressDataModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(geocodeAddressDataModel.m23029a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        geocodeAddressDataModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    GeocodeAddressDataParser.m23038a(geocodeAddressDataModel.w_(), geocodeAddressDataModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(GeocodeAddressDataModel.class, new Serializer());
                }
            }

            public GeocodeAddressDataModel() {
                super(1);
            }

            @Nonnull
            public final ImmutableList<EdgesModel> m23031a() {
                this.f21922d = super.a(this.f21922d, 0, EdgesModel.class);
                return (ImmutableList) this.f21922d;
            }

            public final int jK_() {
                return -1119251298;
            }

            public final GraphQLVisitableModel m23030a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m23031a() != null) {
                    Builder a = ModelHelper.a(m23031a(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        graphQLVisitableModel = (GeocodeAddressDataModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f21922d = a.b();
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m23029a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m23031a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, a);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: ['user'] */
        public class Serializer extends JsonSerializer<AdInterfacesGeocodeQueryModel> {
            public final void m23032a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                AdInterfacesGeocodeQueryModel adInterfacesGeocodeQueryModel = (AdInterfacesGeocodeQueryModel) obj;
                if (adInterfacesGeocodeQueryModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(adInterfacesGeocodeQueryModel.m23033a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    adInterfacesGeocodeQueryModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = adInterfacesGeocodeQueryModel.w_();
                int u_ = adInterfacesGeocodeQueryModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("geocode_address_data");
                    GeocodeAddressDataParser.m23038a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(AdInterfacesGeocodeQueryModel.class, new Serializer());
            }
        }

        public AdInterfacesGeocodeQueryModel() {
            super(1);
        }

        @Nullable
        public final GeocodeAddressDataModel m23034a() {
            this.f21923d = (GeocodeAddressDataModel) super.a(this.f21923d, 0, GeocodeAddressDataModel.class);
            return this.f21923d;
        }

        public final int jK_() {
            return 807272690;
        }

        public final GraphQLVisitableModel m23035a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m23034a() != null) {
                GeocodeAddressDataModel geocodeAddressDataModel = (GeocodeAddressDataModel) graphQLModelMutatingVisitor.b(m23034a());
                if (m23034a() != geocodeAddressDataModel) {
                    graphQLVisitableModel = (AdInterfacesGeocodeQueryModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f21923d = geocodeAddressDataModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m23033a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m23034a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }
}
