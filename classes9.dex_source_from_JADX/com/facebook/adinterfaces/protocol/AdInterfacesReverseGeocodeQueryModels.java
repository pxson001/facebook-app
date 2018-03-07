package com.facebook.adinterfaces.protocol;

import com.facebook.adinterfaces.protocol.AdInterfacesReverseGeocodeQueryParsers.AdInterfacesReverseGeocodeQueryParser;
import com.facebook.adinterfaces.protocol.AdInterfacesReverseGeocodeQueryParsers.AdInterfacesReverseGeocodeQueryParser.ReverseGeocodeDataParser;
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

/* compiled from: You must supply %s */
public class AdInterfacesReverseGeocodeQueryModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 1769658838)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: You must supply %s */
    public final class AdInterfacesReverseGeocodeQueryModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private ReverseGeocodeDataModel f22270d;

        /* compiled from: You must supply %s */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(AdInterfacesReverseGeocodeQueryModel.class, new Deserializer());
            }

            public Object m23939a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = AdInterfacesReverseGeocodeQueryParser.m23951a(jsonParser);
                Object adInterfacesReverseGeocodeQueryModel = new AdInterfacesReverseGeocodeQueryModel();
                ((BaseModel) adInterfacesReverseGeocodeQueryModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (adInterfacesReverseGeocodeQueryModel instanceof Postprocessable) {
                    return ((Postprocessable) adInterfacesReverseGeocodeQueryModel).a();
                }
                return adInterfacesReverseGeocodeQueryModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 1231721818)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: You must supply %s */
        public final class ReverseGeocodeDataModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private List<com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.ReverseGeocodeDataModel> f22269d;

            /* compiled from: You must supply %s */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(ReverseGeocodeDataModel.class, new Deserializer());
                }

                public Object m23940a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(ReverseGeocodeDataParser.m23949a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object reverseGeocodeDataModel = new ReverseGeocodeDataModel();
                    ((BaseModel) reverseGeocodeDataModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (reverseGeocodeDataModel instanceof Postprocessable) {
                        return ((Postprocessable) reverseGeocodeDataModel).a();
                    }
                    return reverseGeocodeDataModel;
                }
            }

            /* compiled from: You must supply %s */
            public class Serializer extends JsonSerializer<ReverseGeocodeDataModel> {
                public final void m23941a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    ReverseGeocodeDataModel reverseGeocodeDataModel = (ReverseGeocodeDataModel) obj;
                    if (reverseGeocodeDataModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(reverseGeocodeDataModel.m23942a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        reverseGeocodeDataModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    ReverseGeocodeDataParser.m23950a(reverseGeocodeDataModel.w_(), reverseGeocodeDataModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(ReverseGeocodeDataModel.class, new Serializer());
                }
            }

            public ReverseGeocodeDataModel() {
                super(1);
            }

            @Nonnull
            public final ImmutableList<com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.ReverseGeocodeDataModel> m23944a() {
                this.f22269d = super.a(this.f22269d, 0, com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.ReverseGeocodeDataModel.class);
                return (ImmutableList) this.f22269d;
            }

            public final int jK_() {
                return -366318792;
            }

            public final GraphQLVisitableModel m23943a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m23944a() != null) {
                    Builder a = ModelHelper.a(m23944a(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        graphQLVisitableModel = (ReverseGeocodeDataModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f22269d = a.b();
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m23942a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m23944a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, a);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: You must supply %s */
        public class Serializer extends JsonSerializer<AdInterfacesReverseGeocodeQueryModel> {
            public final void m23945a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                AdInterfacesReverseGeocodeQueryModel adInterfacesReverseGeocodeQueryModel = (AdInterfacesReverseGeocodeQueryModel) obj;
                if (adInterfacesReverseGeocodeQueryModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(adInterfacesReverseGeocodeQueryModel.m23946a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    adInterfacesReverseGeocodeQueryModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = adInterfacesReverseGeocodeQueryModel.w_();
                int u_ = adInterfacesReverseGeocodeQueryModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("reverse_geocode_data");
                    ReverseGeocodeDataParser.m23950a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(AdInterfacesReverseGeocodeQueryModel.class, new Serializer());
            }
        }

        public AdInterfacesReverseGeocodeQueryModel() {
            super(1);
        }

        @Nullable
        public final ReverseGeocodeDataModel m23947a() {
            this.f22270d = (ReverseGeocodeDataModel) super.a(this.f22270d, 0, ReverseGeocodeDataModel.class);
            return this.f22270d;
        }

        public final int jK_() {
            return -1217892724;
        }

        public final GraphQLVisitableModel m23948a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m23947a() != null) {
                ReverseGeocodeDataModel reverseGeocodeDataModel = (ReverseGeocodeDataModel) graphQLModelMutatingVisitor.b(m23947a());
                if (m23947a() != reverseGeocodeDataModel) {
                    graphQLVisitableModel = (AdInterfacesReverseGeocodeQueryModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f22270d = reverseGeocodeDataModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m23946a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m23947a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }
}
