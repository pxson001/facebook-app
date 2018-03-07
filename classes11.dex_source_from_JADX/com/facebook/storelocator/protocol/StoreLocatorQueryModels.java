package com.facebook.storelocator.protocol;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbSerializerProvider;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.entitycards.contextitems.graphql.ContextItemsQueryModels.ContextItemFieldsModel;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.FragmentModelWithoutBridge;
import com.facebook.flatbuffers.ModelWithFlatBufferFormatHash;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.querybuilder.common.CommonGraphQLModels.DefaultImageFieldsModel;
import com.facebook.graphql.visitor.ConsistencyTuple;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLPersistableNode;
import com.facebook.graphql.visitor.GraphQLVisitableConsistentModel;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.facebook.storelocator.protocol.StoreLocatorQueryParsers.StoreLocatorNearbyLocationsQueryParser;
import com.facebook.storelocator.protocol.StoreLocatorQueryParsers.StoreLocatorNearbyLocationsQueryParser.LocationsParser;
import com.facebook.storelocator.protocol.StoreLocatorQueryParsers.StoreLocatorNearbyLocationsQueryParser.LocationsParser.PageParser;
import com.facebook.storelocator.protocol.StoreLocatorQueryParsers.StoreLocatorNearbyLocationsQueryParser.LocationsParser.PinLocationParser;
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

/* compiled from: NotifListLoadTimeWarm */
public class StoreLocatorQueryModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -1053575617)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: NotifListLoadTimeWarm */
    public final class StoreLocatorNearbyLocationsQueryModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private List<LocationsModel> f12924d;

        /* compiled from: NotifListLoadTimeWarm */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(StoreLocatorNearbyLocationsQueryModel.class, new Deserializer());
            }

            public Object m13589a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(StoreLocatorNearbyLocationsQueryParser.m13625a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object storeLocatorNearbyLocationsQueryModel = new StoreLocatorNearbyLocationsQueryModel();
                ((BaseModel) storeLocatorNearbyLocationsQueryModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (storeLocatorNearbyLocationsQueryModel instanceof Postprocessable) {
                    return ((Postprocessable) storeLocatorNearbyLocationsQueryModel).a();
                }
                return storeLocatorNearbyLocationsQueryModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 677935821)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: NotifListLoadTimeWarm */
        public final class LocationsModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private List<ContextItemFieldsModel> f12918d;
            @Nullable
            private String f12919e;
            @Nullable
            private String f12920f;
            @Nullable
            private DefaultImageFieldsModel f12921g;
            @Nullable
            private PageModel f12922h;
            @Nullable
            private PinLocationModel f12923i;

            /* compiled from: NotifListLoadTimeWarm */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(LocationsModel.class, new Deserializer());
                }

                public Object m13590a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(LocationsParser.m13623b(jsonParser, flatBufferBuilder));
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

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = 1801334754)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: NotifListLoadTimeWarm */
            public final class PageModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
                @Nullable
                private String f12915d;

                /* compiled from: NotifListLoadTimeWarm */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(PageModel.class, new Deserializer());
                    }

                    public Object m13591a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(PageParser.m13619a(jsonParser, flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                        Object pageModel = new PageModel();
                        ((BaseModel) pageModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                        if (pageModel instanceof Postprocessable) {
                            return ((Postprocessable) pageModel).a();
                        }
                        return pageModel;
                    }
                }

                /* compiled from: NotifListLoadTimeWarm */
                public class Serializer extends JsonSerializer<PageModel> {
                    public final void m13592a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        PageModel pageModel = (PageModel) obj;
                        if (pageModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(pageModel.m13593a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            pageModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        PageParser.m13620a(pageModel.w_(), pageModel.u_(), jsonGenerator);
                    }

                    static {
                        FbSerializerProvider.a(PageModel.class, new Serializer());
                    }
                }

                public PageModel() {
                    super(1);
                }

                public final void m13596a(String str, ConsistencyTuple consistencyTuple) {
                    consistencyTuple.a();
                }

                public final void m13597a(String str, Object obj, boolean z) {
                }

                @Nullable
                public final String m13598j() {
                    this.f12915d = super.a(this.f12915d, 0);
                    return this.f12915d;
                }

                @Nullable
                public final String m13595a() {
                    return m13598j();
                }

                public final int jK_() {
                    return 2479791;
                }

                public final GraphQLVisitableModel m13594a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    h();
                    i();
                    return this;
                }

                public final int m13593a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int b = flatBufferBuilder.b(m13598j());
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.b(0, b);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = 918622653)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: NotifListLoadTimeWarm */
            public final class PinLocationModel extends BaseModel implements GraphQLVisitableModel {
                private double f12916d;
                private double f12917e;

                /* compiled from: NotifListLoadTimeWarm */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(PinLocationModel.class, new Deserializer());
                    }

                    public Object m13599a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(PinLocationParser.m13621a(jsonParser, flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                        Object pinLocationModel = new PinLocationModel();
                        ((BaseModel) pinLocationModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                        if (pinLocationModel instanceof Postprocessable) {
                            return ((Postprocessable) pinLocationModel).a();
                        }
                        return pinLocationModel;
                    }
                }

                /* compiled from: NotifListLoadTimeWarm */
                public class Serializer extends JsonSerializer<PinLocationModel> {
                    public final void m13600a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        PinLocationModel pinLocationModel = (PinLocationModel) obj;
                        if (pinLocationModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(pinLocationModel.m13602a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            pinLocationModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        PinLocationParser.m13622a(pinLocationModel.w_(), pinLocationModel.u_(), jsonGenerator);
                    }

                    static {
                        FbSerializerProvider.a(PinLocationModel.class, new Serializer());
                    }
                }

                public PinLocationModel() {
                    super(2);
                }

                public final double m13601a() {
                    a(0, 0);
                    return this.f12916d;
                }

                public final double m13605j() {
                    a(0, 1);
                    return this.f12917e;
                }

                public final int jK_() {
                    return 1965687765;
                }

                public final GraphQLVisitableModel m13603a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    h();
                    i();
                    return this;
                }

                public final int m13602a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    flatBufferBuilder.c(2);
                    flatBufferBuilder.a(0, this.f12916d, 0.0d);
                    flatBufferBuilder.a(1, this.f12917e, 0.0d);
                    i();
                    return flatBufferBuilder.d();
                }

                public final void m13604a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                    super.a(mutableFlatBuffer, i, obj);
                    this.f12916d = mutableFlatBuffer.a(i, 0, 0.0d);
                    this.f12917e = mutableFlatBuffer.a(i, 1, 0.0d);
                }
            }

            /* compiled from: NotifListLoadTimeWarm */
            public class Serializer extends JsonSerializer<LocationsModel> {
                public final void m13606a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    LocationsModel locationsModel = (LocationsModel) obj;
                    if (locationsModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(locationsModel.m13607a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        locationsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    LocationsParser.m13624b(locationsModel.w_(), locationsModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(LocationsModel.class, new Serializer());
                }
            }

            public LocationsModel() {
                super(6);
            }

            @Nonnull
            public final ImmutableList<ContextItemFieldsModel> m13609a() {
                this.f12918d = super.a(this.f12918d, 0, ContextItemFieldsModel.class);
                return (ImmutableList) this.f12918d;
            }

            @Nullable
            public final String m13610j() {
                this.f12919e = super.a(this.f12919e, 1);
                return this.f12919e;
            }

            @Nullable
            public final String m13611k() {
                this.f12920f = super.a(this.f12920f, 2);
                return this.f12920f;
            }

            @Nullable
            public final DefaultImageFieldsModel m13612l() {
                this.f12921g = (DefaultImageFieldsModel) super.a(this.f12921g, 3, DefaultImageFieldsModel.class);
                return this.f12921g;
            }

            @Nullable
            public final PageModel m13613m() {
                this.f12922h = (PageModel) super.a(this.f12922h, 4, PageModel.class);
                return this.f12922h;
            }

            @Nullable
            public final PinLocationModel m13614n() {
                this.f12923i = (PinLocationModel) super.a(this.f12923i, 5, PinLocationModel.class);
                return this.f12923i;
            }

            public final int jK_() {
                return 310697834;
            }

            public final GraphQLVisitableModel m13608a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel;
                DefaultImageFieldsModel defaultImageFieldsModel;
                PageModel pageModel;
                PinLocationModel pinLocationModel;
                h();
                if (m13609a() != null) {
                    Builder a = ModelHelper.a(m13609a(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        LocationsModel locationsModel = (LocationsModel) ModelHelper.a(null, this);
                        locationsModel.f12918d = a.b();
                        graphQLVisitableModel = locationsModel;
                        if (m13612l() != null) {
                            defaultImageFieldsModel = (DefaultImageFieldsModel) graphQLModelMutatingVisitor.b(m13612l());
                            if (m13612l() != defaultImageFieldsModel) {
                                graphQLVisitableModel = (LocationsModel) ModelHelper.a(graphQLVisitableModel, this);
                                graphQLVisitableModel.f12921g = defaultImageFieldsModel;
                            }
                        }
                        if (m13613m() != null) {
                            pageModel = (PageModel) graphQLModelMutatingVisitor.b(m13613m());
                            if (m13613m() != pageModel) {
                                graphQLVisitableModel = (LocationsModel) ModelHelper.a(graphQLVisitableModel, this);
                                graphQLVisitableModel.f12922h = pageModel;
                            }
                        }
                        if (m13614n() != null) {
                            pinLocationModel = (PinLocationModel) graphQLModelMutatingVisitor.b(m13614n());
                            if (m13614n() != pinLocationModel) {
                                graphQLVisitableModel = (LocationsModel) ModelHelper.a(graphQLVisitableModel, this);
                                graphQLVisitableModel.f12923i = pinLocationModel;
                            }
                        }
                        i();
                        return graphQLVisitableModel != null ? this : graphQLVisitableModel;
                    }
                }
                graphQLVisitableModel = null;
                if (m13612l() != null) {
                    defaultImageFieldsModel = (DefaultImageFieldsModel) graphQLModelMutatingVisitor.b(m13612l());
                    if (m13612l() != defaultImageFieldsModel) {
                        graphQLVisitableModel = (LocationsModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f12921g = defaultImageFieldsModel;
                    }
                }
                if (m13613m() != null) {
                    pageModel = (PageModel) graphQLModelMutatingVisitor.b(m13613m());
                    if (m13613m() != pageModel) {
                        graphQLVisitableModel = (LocationsModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f12922h = pageModel;
                    }
                }
                if (m13614n() != null) {
                    pinLocationModel = (PinLocationModel) graphQLModelMutatingVisitor.b(m13614n());
                    if (m13614n() != pinLocationModel) {
                        graphQLVisitableModel = (LocationsModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f12923i = pinLocationModel;
                    }
                }
                i();
                if (graphQLVisitableModel != null) {
                }
            }

            public final int m13607a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m13609a());
                int b = flatBufferBuilder.b(m13610j());
                int b2 = flatBufferBuilder.b(m13611k());
                int a2 = ModelHelper.a(flatBufferBuilder, m13612l());
                int a3 = ModelHelper.a(flatBufferBuilder, m13613m());
                int a4 = ModelHelper.a(flatBufferBuilder, m13614n());
                flatBufferBuilder.c(6);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.b(1, b);
                flatBufferBuilder.b(2, b2);
                flatBufferBuilder.b(3, a2);
                flatBufferBuilder.b(4, a3);
                flatBufferBuilder.b(5, a4);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: NotifListLoadTimeWarm */
        public class Serializer extends JsonSerializer<StoreLocatorNearbyLocationsQueryModel> {
            public final void m13615a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                StoreLocatorNearbyLocationsQueryModel storeLocatorNearbyLocationsQueryModel = (StoreLocatorNearbyLocationsQueryModel) obj;
                if (storeLocatorNearbyLocationsQueryModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(storeLocatorNearbyLocationsQueryModel.m13616a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    storeLocatorNearbyLocationsQueryModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = storeLocatorNearbyLocationsQueryModel.w_();
                int u_ = storeLocatorNearbyLocationsQueryModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("locations");
                    jsonGenerator.d();
                    for (int i = 0; i < mutableFlatBuffer.c(g); i++) {
                        LocationsParser.m13624b(mutableFlatBuffer, mutableFlatBuffer.m(g, i), jsonGenerator, serializerProvider);
                    }
                    jsonGenerator.e();
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(StoreLocatorNearbyLocationsQueryModel.class, new Serializer());
            }
        }

        public StoreLocatorNearbyLocationsQueryModel() {
            super(1);
        }

        @Nonnull
        public final ImmutableList<LocationsModel> m13618a() {
            this.f12924d = super.a(this.f12924d, 0, LocationsModel.class);
            return (ImmutableList) this.f12924d;
        }

        public final int jK_() {
            return -405567555;
        }

        public final GraphQLVisitableModel m13617a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m13618a() != null) {
                Builder a = ModelHelper.a(m13618a(), graphQLModelMutatingVisitor);
                if (a != null) {
                    graphQLVisitableModel = (StoreLocatorNearbyLocationsQueryModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f12924d = a.b();
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m13616a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m13618a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }
}
