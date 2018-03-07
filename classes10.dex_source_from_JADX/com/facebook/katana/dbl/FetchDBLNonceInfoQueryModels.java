package com.facebook.katana.dbl;

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
import com.facebook.katana.dbl.FetchDBLNonceInfoQueryParsers.FetchDBLNonceInfoQueryParser;
import com.facebook.katana.dbl.FetchDBLNonceInfoQueryParsers.FetchDBLNonceInfoQueryParser.DeviceBasedLoginNonceInfosParser;
import com.facebook.katana.dbl.FetchDBLNonceInfoQueryParsers.FetchDBLNonceInfoQueryParser.DeviceBasedLoginNonceInfosParser.NodesParser;
import com.facebook.katana.dbl.FetchDBLNonceInfoQueryParsers.FetchDBLNonceInfoQueryParser.DeviceBasedLoginNonceInfosParser.NodesParser.DeviceTypeParser;
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

/* compiled from: update_cover_photo_key */
public class FetchDBLNonceInfoQueryModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -1492235120)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: update_cover_photo_key */
    public final class FetchDBLNonceInfoQueryModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private DeviceBasedLoginNonceInfosModel f923d;

        /* compiled from: update_cover_photo_key */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(FetchDBLNonceInfoQueryModel.class, new Deserializer());
            }

            public Object m939a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = FetchDBLNonceInfoQueryParser.m971a(jsonParser);
                Object fetchDBLNonceInfoQueryModel = new FetchDBLNonceInfoQueryModel();
                ((BaseModel) fetchDBLNonceInfoQueryModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (fetchDBLNonceInfoQueryModel instanceof Postprocessable) {
                    return ((Postprocessable) fetchDBLNonceInfoQueryModel).a();
                }
                return fetchDBLNonceInfoQueryModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -448960053)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: update_cover_photo_key */
        public final class DeviceBasedLoginNonceInfosModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private List<NodesModel> f922d;

            /* compiled from: update_cover_photo_key */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(DeviceBasedLoginNonceInfosModel.class, new Deserializer());
                }

                public Object m940a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(DeviceBasedLoginNonceInfosParser.m969a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object deviceBasedLoginNonceInfosModel = new DeviceBasedLoginNonceInfosModel();
                    ((BaseModel) deviceBasedLoginNonceInfosModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (deviceBasedLoginNonceInfosModel instanceof Postprocessable) {
                        return ((Postprocessable) deviceBasedLoginNonceInfosModel).a();
                    }
                    return deviceBasedLoginNonceInfosModel;
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = 2038421158)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: update_cover_photo_key */
            public final class NodesModel extends BaseModel implements GraphQLVisitableModel {
                @Nullable
                private String f916d;
                @Nullable
                private DeviceTypeModel f917e;
                private boolean f918f;
                private boolean f919g;
                private long f920h;
                @Nullable
                private String f921i;

                /* compiled from: update_cover_photo_key */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(NodesModel.class, new Deserializer());
                    }

                    public Object m941a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(NodesParser.m967b(jsonParser, flatBufferBuilder));
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
                @ModelWithFlatBufferFormatHash(a = -1352864475)
                @JsonSerialize(using = Serializer.class)
                @FragmentModelWithoutBridge
                /* compiled from: update_cover_photo_key */
                public final class DeviceTypeModel extends BaseModel implements GraphQLVisitableModel {
                    @Nullable
                    private String f915d;

                    /* compiled from: update_cover_photo_key */
                    public class Deserializer extends FbJsonDeserializer {
                        static {
                            GlobalAutoGenDeserializerCache.a(DeviceTypeModel.class, new Deserializer());
                        }

                        public Object m942a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(DeviceTypeParser.m965a(jsonParser, flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            mutableFlatBuffer.a(4, Boolean.valueOf(true));
                            MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                            Object deviceTypeModel = new DeviceTypeModel();
                            ((BaseModel) deviceTypeModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                            if (deviceTypeModel instanceof Postprocessable) {
                                return ((Postprocessable) deviceTypeModel).a();
                            }
                            return deviceTypeModel;
                        }
                    }

                    /* compiled from: update_cover_photo_key */
                    public class Serializer extends JsonSerializer<DeviceTypeModel> {
                        public final void m943a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                            DeviceTypeModel deviceTypeModel = (DeviceTypeModel) obj;
                            if (deviceTypeModel.w_() == null) {
                                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                flatBufferBuilder.d(deviceTypeModel.m944a(flatBufferBuilder));
                                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                wrap.position(0);
                                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                deviceTypeModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                            }
                            DeviceTypeParser.m966a(deviceTypeModel.w_(), deviceTypeModel.u_(), jsonGenerator);
                        }

                        static {
                            FbSerializerProvider.a(DeviceTypeModel.class, new Serializer());
                        }
                    }

                    public DeviceTypeModel() {
                        super(1);
                    }

                    @Nullable
                    public final String m946a() {
                        this.f915d = super.a(this.f915d, 0);
                        return this.f915d;
                    }

                    public final int jK_() {
                        return -1919764332;
                    }

                    public final GraphQLVisitableModel m945a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                        h();
                        i();
                        return this;
                    }

                    public final int m944a(FlatBufferBuilder flatBufferBuilder) {
                        h();
                        int b = flatBufferBuilder.b(m946a());
                        flatBufferBuilder.c(1);
                        flatBufferBuilder.b(0, b);
                        i();
                        return flatBufferBuilder.d();
                    }
                }

                /* compiled from: update_cover_photo_key */
                public class Serializer extends JsonSerializer<NodesModel> {
                    public final void m947a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        NodesModel nodesModel = (NodesModel) obj;
                        if (nodesModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(nodesModel.m949a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            nodesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        NodesParser.m968b(nodesModel.w_(), nodesModel.u_(), jsonGenerator, serializerProvider);
                    }

                    static {
                        FbSerializerProvider.a(NodesModel.class, new Serializer());
                    }
                }

                public NodesModel() {
                    super(6);
                }

                @Nullable
                public final String m951a() {
                    this.f916d = super.a(this.f916d, 0);
                    return this.f916d;
                }

                @Nullable
                public final DeviceTypeModel m953j() {
                    this.f917e = (DeviceTypeModel) super.a(this.f917e, 1, DeviceTypeModel.class);
                    return this.f917e;
                }

                public final boolean m954k() {
                    a(0, 2);
                    return this.f918f;
                }

                public final boolean m955l() {
                    a(0, 3);
                    return this.f919g;
                }

                public final long m956m() {
                    a(0, 4);
                    return this.f920h;
                }

                @Nullable
                private String m948n() {
                    this.f921i = super.a(this.f921i, 5);
                    return this.f921i;
                }

                public final int jK_() {
                    return 1396501825;
                }

                public final GraphQLVisitableModel m950a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    GraphQLVisitableModel graphQLVisitableModel = null;
                    h();
                    if (m953j() != null) {
                        DeviceTypeModel deviceTypeModel = (DeviceTypeModel) graphQLModelMutatingVisitor.b(m953j());
                        if (m953j() != deviceTypeModel) {
                            graphQLVisitableModel = (NodesModel) ModelHelper.a(null, this);
                            graphQLVisitableModel.f917e = deviceTypeModel;
                        }
                    }
                    i();
                    return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                }

                public final int m949a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int b = flatBufferBuilder.b(m951a());
                    int a = ModelHelper.a(flatBufferBuilder, m953j());
                    int b2 = flatBufferBuilder.b(m948n());
                    flatBufferBuilder.c(6);
                    flatBufferBuilder.b(0, b);
                    flatBufferBuilder.b(1, a);
                    flatBufferBuilder.a(2, this.f918f);
                    flatBufferBuilder.a(3, this.f919g);
                    flatBufferBuilder.a(4, this.f920h, 0);
                    flatBufferBuilder.b(5, b2);
                    i();
                    return flatBufferBuilder.d();
                }

                public final void m952a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                    super.a(mutableFlatBuffer, i, obj);
                    this.f918f = mutableFlatBuffer.a(i, 2);
                    this.f919g = mutableFlatBuffer.a(i, 3);
                    this.f920h = mutableFlatBuffer.a(i, 4, 0);
                }
            }

            /* compiled from: update_cover_photo_key */
            public class Serializer extends JsonSerializer<DeviceBasedLoginNonceInfosModel> {
                public final void m957a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    DeviceBasedLoginNonceInfosModel deviceBasedLoginNonceInfosModel = (DeviceBasedLoginNonceInfosModel) obj;
                    if (deviceBasedLoginNonceInfosModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(deviceBasedLoginNonceInfosModel.m958a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        deviceBasedLoginNonceInfosModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    DeviceBasedLoginNonceInfosParser.m970a(deviceBasedLoginNonceInfosModel.w_(), deviceBasedLoginNonceInfosModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(DeviceBasedLoginNonceInfosModel.class, new Serializer());
                }
            }

            public DeviceBasedLoginNonceInfosModel() {
                super(1);
            }

            @Nonnull
            public final ImmutableList<NodesModel> m960a() {
                this.f922d = super.a(this.f922d, 0, NodesModel.class);
                return (ImmutableList) this.f922d;
            }

            public final int jK_() {
                return 617256912;
            }

            public final GraphQLVisitableModel m959a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m960a() != null) {
                    Builder a = ModelHelper.a(m960a(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        graphQLVisitableModel = (DeviceBasedLoginNonceInfosModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f922d = a.b();
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m958a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m960a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, a);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: update_cover_photo_key */
        public class Serializer extends JsonSerializer<FetchDBLNonceInfoQueryModel> {
            public final void m961a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                FetchDBLNonceInfoQueryModel fetchDBLNonceInfoQueryModel = (FetchDBLNonceInfoQueryModel) obj;
                if (fetchDBLNonceInfoQueryModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(fetchDBLNonceInfoQueryModel.m962a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    fetchDBLNonceInfoQueryModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = fetchDBLNonceInfoQueryModel.w_();
                int u_ = fetchDBLNonceInfoQueryModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("device_based_login_nonce_infos");
                    DeviceBasedLoginNonceInfosParser.m970a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(FetchDBLNonceInfoQueryModel.class, new Serializer());
            }
        }

        public FetchDBLNonceInfoQueryModel() {
            super(1);
        }

        @Nullable
        public final DeviceBasedLoginNonceInfosModel m964a() {
            this.f923d = (DeviceBasedLoginNonceInfosModel) super.a(this.f923d, 0, DeviceBasedLoginNonceInfosModel.class);
            return this.f923d;
        }

        public final int jK_() {
            return -1732764110;
        }

        public final GraphQLVisitableModel m963a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m964a() != null) {
                DeviceBasedLoginNonceInfosModel deviceBasedLoginNonceInfosModel = (DeviceBasedLoginNonceInfosModel) graphQLModelMutatingVisitor.b(m964a());
                if (m964a() != deviceBasedLoginNonceInfosModel) {
                    graphQLVisitableModel = (FetchDBLNonceInfoQueryModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f923d = deviceBasedLoginNonceInfosModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m962a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m964a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }
}
