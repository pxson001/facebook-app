package com.facebook.zero.iptest.graphql;

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
import com.facebook.zero.iptest.graphql.ZeroIPTestGraphQLParsers.FetchZeroIPTestParser;
import com.facebook.zero.iptest.graphql.ZeroIPTestGraphQLParsers.FetchZeroIPTestParser.ZeroCarrierParser;
import com.facebook.zero.iptest.graphql.ZeroIPTestGraphQLParsers.FetchZeroIPTestParser.ZeroCarrierParser.IpTestsParser;
import com.facebook.zero.iptest.graphql.ZeroIPTestGraphQLParsers.FetchZeroIPTestParser.ZeroCarrierParser.IpTestsParser.NodesParser;
import com.facebook.zero.iptest.graphql.ZeroIPTestGraphQLParsers.ZeroIPTestSubmitMutationParser;
import com.facebook.zero.iptest.graphql.ZeroIPTestGraphQLParsers.ZeroIPTestSubmitMutationParser.ViewerParser;
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

/* compiled from: events_extended_invite_add_note_nux */
public class ZeroIPTestGraphQLModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -1183426199)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: events_extended_invite_add_note_nux */
    public final class FetchZeroIPTestModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private ZeroCarrierModel f13088d;

        /* compiled from: events_extended_invite_add_note_nux */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(FetchZeroIPTestModel.class, new Deserializer());
            }

            public Object m13144a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = FetchZeroIPTestParser.m13191a(jsonParser);
                Object fetchZeroIPTestModel = new FetchZeroIPTestModel();
                ((BaseModel) fetchZeroIPTestModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (fetchZeroIPTestModel instanceof Postprocessable) {
                    return ((Postprocessable) fetchZeroIPTestModel).a();
                }
                return fetchZeroIPTestModel;
            }
        }

        /* compiled from: events_extended_invite_add_note_nux */
        public class Serializer extends JsonSerializer<FetchZeroIPTestModel> {
            public final void m13145a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                FetchZeroIPTestModel fetchZeroIPTestModel = (FetchZeroIPTestModel) obj;
                if (fetchZeroIPTestModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(fetchZeroIPTestModel.m13167a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    fetchZeroIPTestModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = fetchZeroIPTestModel.w_();
                int u_ = fetchZeroIPTestModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("zero_carrier");
                    ZeroCarrierParser.m13190a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(FetchZeroIPTestModel.class, new Serializer());
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -657684334)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: events_extended_invite_add_note_nux */
        public final class ZeroCarrierModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private IpTestsModel f13087d;

            /* compiled from: events_extended_invite_add_note_nux */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(ZeroCarrierModel.class, new Deserializer());
                }

                public Object m13146a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(ZeroCarrierParser.m13189a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object zeroCarrierModel = new ZeroCarrierModel();
                    ((BaseModel) zeroCarrierModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (zeroCarrierModel instanceof Postprocessable) {
                        return ((Postprocessable) zeroCarrierModel).a();
                    }
                    return zeroCarrierModel;
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = -888583118)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: events_extended_invite_add_note_nux */
            public final class IpTestsModel extends BaseModel implements GraphQLVisitableModel {
                @Nullable
                private List<NodesModel> f13085d;
                private int f13086e;

                /* compiled from: events_extended_invite_add_note_nux */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(IpTestsModel.class, new Deserializer());
                    }

                    public Object m13147a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(IpTestsParser.m13187a(jsonParser, flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                        Object ipTestsModel = new IpTestsModel();
                        ((BaseModel) ipTestsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                        if (ipTestsModel instanceof Postprocessable) {
                            return ((Postprocessable) ipTestsModel).a();
                        }
                        return ipTestsModel;
                    }
                }

                @JsonDeserialize(using = Deserializer.class)
                @ModelWithFlatBufferFormatHash(a = 667545930)
                @JsonSerialize(using = Serializer.class)
                @FragmentModelWithoutBridge
                /* compiled from: events_extended_invite_add_note_nux */
                public final class NodesModel extends BaseModel implements GraphQLVisitableModel {
                    @Nullable
                    private String f13080d;
                    @Nullable
                    private String f13081e;
                    @Nullable
                    private String f13082f;
                    private int f13083g;
                    @Nullable
                    private String f13084h;

                    /* compiled from: events_extended_invite_add_note_nux */
                    public class Deserializer extends FbJsonDeserializer {
                        static {
                            GlobalAutoGenDeserializerCache.a(NodesModel.class, new Deserializer());
                        }

                        public Object m13148a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(NodesParser.m13186b(jsonParser, flatBufferBuilder));
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

                    /* compiled from: events_extended_invite_add_note_nux */
                    public class Serializer extends JsonSerializer<NodesModel> {
                        public final void m13149a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                            NodesModel nodesModel = (NodesModel) obj;
                            if (nodesModel.w_() == null) {
                                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                flatBufferBuilder.d(nodesModel.m13150a(flatBufferBuilder));
                                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                wrap.position(0);
                                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                nodesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                            }
                            NodesParser.m13185a(nodesModel.w_(), nodesModel.u_(), jsonGenerator);
                        }

                        static {
                            FbSerializerProvider.a(NodesModel.class, new Serializer());
                        }
                    }

                    public NodesModel() {
                        super(5);
                    }

                    @Nullable
                    public final String m13152a() {
                        this.f13080d = super.a(this.f13080d, 0);
                        return this.f13080d;
                    }

                    @Nullable
                    public final String m13154b() {
                        this.f13081e = super.a(this.f13081e, 1);
                        return this.f13081e;
                    }

                    @Nullable
                    public final String m13155c() {
                        this.f13082f = super.a(this.f13082f, 2);
                        return this.f13082f;
                    }

                    public final int m13156d() {
                        a(0, 3);
                        return this.f13083g;
                    }

                    @Nullable
                    public final String mG_() {
                        this.f13084h = super.a(this.f13084h, 4);
                        return this.f13084h;
                    }

                    public final int jK_() {
                        return 1002636924;
                    }

                    public final GraphQLVisitableModel m13151a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                        h();
                        i();
                        return this;
                    }

                    public final int m13150a(FlatBufferBuilder flatBufferBuilder) {
                        h();
                        int b = flatBufferBuilder.b(m13152a());
                        int b2 = flatBufferBuilder.b(m13154b());
                        int b3 = flatBufferBuilder.b(m13155c());
                        int b4 = flatBufferBuilder.b(mG_());
                        flatBufferBuilder.c(5);
                        flatBufferBuilder.b(0, b);
                        flatBufferBuilder.b(1, b2);
                        flatBufferBuilder.b(2, b3);
                        flatBufferBuilder.a(3, this.f13083g, 0);
                        flatBufferBuilder.b(4, b4);
                        i();
                        return flatBufferBuilder.d();
                    }

                    public final void m13153a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                        super.a(mutableFlatBuffer, i, obj);
                        this.f13083g = mutableFlatBuffer.a(i, 3, 0);
                    }
                }

                /* compiled from: events_extended_invite_add_note_nux */
                public class Serializer extends JsonSerializer<IpTestsModel> {
                    public final void m13157a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        IpTestsModel ipTestsModel = (IpTestsModel) obj;
                        if (ipTestsModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(ipTestsModel.m13158a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            ipTestsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        IpTestsParser.m13188a(ipTestsModel.w_(), ipTestsModel.u_(), jsonGenerator, serializerProvider);
                    }

                    static {
                        FbSerializerProvider.a(IpTestsModel.class, new Serializer());
                    }
                }

                public IpTestsModel() {
                    super(2);
                }

                @Nonnull
                public final ImmutableList<NodesModel> m13160a() {
                    this.f13085d = super.a(this.f13085d, 0, NodesModel.class);
                    return (ImmutableList) this.f13085d;
                }

                public final int m13162j() {
                    a(0, 1);
                    return this.f13086e;
                }

                public final int jK_() {
                    return 128991013;
                }

                public final GraphQLVisitableModel m13159a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    GraphQLVisitableModel graphQLVisitableModel = null;
                    h();
                    if (m13160a() != null) {
                        Builder a = ModelHelper.a(m13160a(), graphQLModelMutatingVisitor);
                        if (a != null) {
                            graphQLVisitableModel = (IpTestsModel) ModelHelper.a(null, this);
                            graphQLVisitableModel.f13085d = a.b();
                        }
                    }
                    i();
                    return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                }

                public final int m13158a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int a = ModelHelper.a(flatBufferBuilder, m13160a());
                    flatBufferBuilder.c(2);
                    flatBufferBuilder.b(0, a);
                    flatBufferBuilder.a(1, this.f13086e, 0);
                    i();
                    return flatBufferBuilder.d();
                }

                public final void m13161a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                    super.a(mutableFlatBuffer, i, obj);
                    this.f13086e = mutableFlatBuffer.a(i, 1, 0);
                }
            }

            /* compiled from: events_extended_invite_add_note_nux */
            public class Serializer extends JsonSerializer<ZeroCarrierModel> {
                public final void m13163a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    ZeroCarrierModel zeroCarrierModel = (ZeroCarrierModel) obj;
                    if (zeroCarrierModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(zeroCarrierModel.m13164a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        zeroCarrierModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    ZeroCarrierParser.m13190a(zeroCarrierModel.w_(), zeroCarrierModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(ZeroCarrierModel.class, new Serializer());
                }
            }

            public ZeroCarrierModel() {
                super(1);
            }

            @Nullable
            public final IpTestsModel m13166a() {
                this.f13087d = (IpTestsModel) super.a(this.f13087d, 0, IpTestsModel.class);
                return this.f13087d;
            }

            public final int jK_() {
                return 1321194256;
            }

            public final GraphQLVisitableModel m13165a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m13166a() != null) {
                    IpTestsModel ipTestsModel = (IpTestsModel) graphQLModelMutatingVisitor.b(m13166a());
                    if (m13166a() != ipTestsModel) {
                        graphQLVisitableModel = (ZeroCarrierModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f13087d = ipTestsModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m13164a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m13166a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, a);
                i();
                return flatBufferBuilder.d();
            }
        }

        public FetchZeroIPTestModel() {
            super(1);
        }

        @Nullable
        public final ZeroCarrierModel m13169a() {
            this.f13088d = (ZeroCarrierModel) super.a(this.f13088d, 0, ZeroCarrierModel.class);
            return this.f13088d;
        }

        public final int jK_() {
            return -1732764110;
        }

        public final GraphQLVisitableModel m13168a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m13169a() != null) {
                ZeroCarrierModel zeroCarrierModel = (ZeroCarrierModel) graphQLModelMutatingVisitor.b(m13169a());
                if (m13169a() != zeroCarrierModel) {
                    graphQLVisitableModel = (FetchZeroIPTestModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f13088d = zeroCarrierModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m13167a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m13169a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -1122870793)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: events_extended_invite_add_note_nux */
    public final class ZeroIPTestSubmitMutationModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private ViewerModel f13091d;

        /* compiled from: events_extended_invite_add_note_nux */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(ZeroIPTestSubmitMutationModel.class, new Deserializer());
            }

            public Object m13170a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = ZeroIPTestSubmitMutationParser.m13196a(jsonParser);
                Object zeroIPTestSubmitMutationModel = new ZeroIPTestSubmitMutationModel();
                ((BaseModel) zeroIPTestSubmitMutationModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (zeroIPTestSubmitMutationModel instanceof Postprocessable) {
                    return ((Postprocessable) zeroIPTestSubmitMutationModel).a();
                }
                return zeroIPTestSubmitMutationModel;
            }
        }

        /* compiled from: events_extended_invite_add_note_nux */
        public class Serializer extends JsonSerializer<ZeroIPTestSubmitMutationModel> {
            public final void m13171a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                ZeroIPTestSubmitMutationModel zeroIPTestSubmitMutationModel = (ZeroIPTestSubmitMutationModel) obj;
                if (zeroIPTestSubmitMutationModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(zeroIPTestSubmitMutationModel.m13183a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    zeroIPTestSubmitMutationModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = zeroIPTestSubmitMutationModel.w_();
                int u_ = zeroIPTestSubmitMutationModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("viewer");
                    ViewerParser.m13195a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(ZeroIPTestSubmitMutationModel.class, new Serializer());
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 190194665)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: events_extended_invite_add_note_nux */
        public final class ViewerModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private ZeroCarrierModel f13090d;

            /* compiled from: events_extended_invite_add_note_nux */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(ViewerModel.class, new Deserializer());
                }

                public Object m13172a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(ViewerParser.m13194a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object viewerModel = new ViewerModel();
                    ((BaseModel) viewerModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (viewerModel instanceof Postprocessable) {
                        return ((Postprocessable) viewerModel).a();
                    }
                    return viewerModel;
                }
            }

            /* compiled from: events_extended_invite_add_note_nux */
            public class Serializer extends JsonSerializer<ViewerModel> {
                public final void m13173a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    ViewerModel viewerModel = (ViewerModel) obj;
                    if (viewerModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(viewerModel.m13180a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        viewerModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    ViewerParser.m13195a(viewerModel.w_(), viewerModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(ViewerModel.class, new Serializer());
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = 2063899510)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: events_extended_invite_add_note_nux */
            public final class ZeroCarrierModel extends BaseModel implements GraphQLVisitableModel {
                @Nullable
                private String f13089d;

                /* compiled from: events_extended_invite_add_note_nux */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(ZeroCarrierModel.class, new Deserializer());
                    }

                    public Object m13174a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(ViewerParser.ZeroCarrierParser.m13192a(jsonParser, flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                        Object zeroCarrierModel = new ZeroCarrierModel();
                        ((BaseModel) zeroCarrierModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                        if (zeroCarrierModel instanceof Postprocessable) {
                            return ((Postprocessable) zeroCarrierModel).a();
                        }
                        return zeroCarrierModel;
                    }
                }

                /* compiled from: events_extended_invite_add_note_nux */
                public class Serializer extends JsonSerializer<ZeroCarrierModel> {
                    public final void m13175a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        ZeroCarrierModel zeroCarrierModel = (ZeroCarrierModel) obj;
                        if (zeroCarrierModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(zeroCarrierModel.m13177a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            zeroCarrierModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        ViewerParser.ZeroCarrierParser.m13193a(zeroCarrierModel.w_(), zeroCarrierModel.u_(), jsonGenerator);
                    }

                    static {
                        FbSerializerProvider.a(ZeroCarrierModel.class, new Serializer());
                    }
                }

                public ZeroCarrierModel() {
                    super(1);
                }

                @Nullable
                private String m13176a() {
                    this.f13089d = super.a(this.f13089d, 0);
                    return this.f13089d;
                }

                public final int jK_() {
                    return 1321194256;
                }

                public final GraphQLVisitableModel m13178a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    h();
                    i();
                    return this;
                }

                public final int m13177a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int b = flatBufferBuilder.b(m13176a());
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.b(0, b);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            public ViewerModel() {
                super(1);
            }

            @Nullable
            private ZeroCarrierModel m13179a() {
                this.f13090d = (ZeroCarrierModel) super.a(this.f13090d, 0, ZeroCarrierModel.class);
                return this.f13090d;
            }

            public final int jK_() {
                return -1732764110;
            }

            public final GraphQLVisitableModel m13181a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m13179a() != null) {
                    ZeroCarrierModel zeroCarrierModel = (ZeroCarrierModel) graphQLModelMutatingVisitor.b(m13179a());
                    if (m13179a() != zeroCarrierModel) {
                        graphQLVisitableModel = (ViewerModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f13090d = zeroCarrierModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m13180a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m13179a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, a);
                i();
                return flatBufferBuilder.d();
            }
        }

        public ZeroIPTestSubmitMutationModel() {
            super(1);
        }

        @Nullable
        private ViewerModel m13182a() {
            this.f13091d = (ViewerModel) super.a(this.f13091d, 0, ViewerModel.class);
            return this.f13091d;
        }

        public final int jK_() {
            return 257760788;
        }

        public final GraphQLVisitableModel m13184a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m13182a() != null) {
                ViewerModel viewerModel = (ViewerModel) graphQLModelMutatingVisitor.b(m13182a());
                if (m13182a() != viewerModel) {
                    graphQLVisitableModel = (ZeroIPTestSubmitMutationModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f13091d = viewerModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m13183a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m13182a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }
}
