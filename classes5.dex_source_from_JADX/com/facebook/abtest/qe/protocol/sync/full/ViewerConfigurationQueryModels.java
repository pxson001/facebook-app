package com.facebook.abtest.qe.protocol.sync.full;

import com.facebook.abtest.qe.protocol.sync.full.ViewerConfigurationQueryParsers.ConfigurationEdgeParser;
import com.facebook.abtest.qe.protocol.sync.full.ViewerConfigurationQueryParsers.ConfigurationParameterSetParser;
import com.facebook.abtest.qe.protocol.sync.full.ViewerConfigurationQueryParsers.ConfigurationParameterSetsConnectionParser;
import com.facebook.abtest.qe.protocol.sync.full.ViewerConfigurationQueryParsers.ConfigurationParameterSetsConnectionParser.EdgesParser;
import com.facebook.abtest.qe.protocol.sync.full.ViewerConfigurationQueryParsers.ConfigurationParser;
import com.facebook.abtest.qe.protocol.sync.full.ViewerConfigurationQueryParsers.QueryStringConfigurationParameterParser;
import com.facebook.abtest.qe.protocol.sync.full.ViewerConfigurationQueryParsers.ViewerConfigsParser;
import com.facebook.abtest.qe.protocol.sync.full.ViewerConfigurationQueryParsers.ViewerConfigsParser.ConfigsParser;
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
import com.google.android.gms.internal.zzmn.zza;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import java.nio.ByteBuffer;
import java.util.List;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/* compiled from: topic_vote_dialog */
public class ViewerConfigurationQueryModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 113033002)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: topic_vote_dialog */
    public final class ConfigurationEdgeModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private ConfigurationModel f1745d;

        /* compiled from: topic_vote_dialog */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(ConfigurationEdgeModel.class, new Deserializer());
            }

            public Object m2386a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(ConfigurationEdgeParser.m2441b(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object configurationEdgeModel = new ConfigurationEdgeModel();
                ((BaseModel) configurationEdgeModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (configurationEdgeModel instanceof Postprocessable) {
                    return ((Postprocessable) configurationEdgeModel).a();
                }
                return configurationEdgeModel;
            }
        }

        /* compiled from: topic_vote_dialog */
        public class Serializer extends JsonSerializer<ConfigurationEdgeModel> {
            public final void m2387a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                ConfigurationEdgeModel configurationEdgeModel = (ConfigurationEdgeModel) obj;
                if (configurationEdgeModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(configurationEdgeModel.m2388a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    configurationEdgeModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                zza.m12852b(configurationEdgeModel.w_(), configurationEdgeModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(ConfigurationEdgeModel.class, new Serializer());
            }
        }

        public ConfigurationEdgeModel() {
            super(1);
        }

        @Nullable
        public final ConfigurationModel m2389a() {
            this.f1745d = (ConfigurationModel) super.a(this.f1745d, 0, ConfigurationModel.class);
            return this.f1745d;
        }

        public final int jK_() {
            return -1672865940;
        }

        public final GraphQLVisitableModel m2390a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m2389a() != null) {
                ConfigurationModel configurationModel = (ConfigurationModel) graphQLModelMutatingVisitor.b(m2389a());
                if (m2389a() != configurationModel) {
                    graphQLVisitableModel = (ConfigurationEdgeModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f1745d = configurationModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m2388a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m2389a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 1473609562)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: topic_vote_dialog */
    public final class ConfigurationModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private ConfigurationParameterSetsConnectionModel f1755d;
        private boolean f1756e;
        @Nullable
        private String f1757f;
        private boolean f1758g;
        @Nullable
        private String f1759h;
        @Nullable
        private String f1760i;
        @Nullable
        private String f1761j;
        @Nullable
        private ConfigurationParameterSetsConnectionModel f1762k;
        private int f1763l;

        /* compiled from: topic_vote_dialog */
        public final class Builder {
            @Nullable
            public ConfigurationParameterSetsConnectionModel f1746a;
            public boolean f1747b;
            @Nullable
            public String f1748c;
            public boolean f1749d;
            @Nullable
            public String f1750e;
            @Nullable
            public String f1751f;
            @Nullable
            public String f1752g;
            @Nullable
            public ConfigurationParameterSetsConnectionModel f1753h;
            public int f1754i;

            public static Builder m2391a(ConfigurationModel configurationModel) {
                Builder builder = new Builder();
                builder.f1746a = configurationModel.m2400j();
                builder.f1747b = configurationModel.m2401k();
                builder.f1748c = configurationModel.m2402l();
                builder.f1749d = configurationModel.m2403m();
                builder.f1750e = configurationModel.m2404n();
                builder.f1751f = configurationModel.m2405o();
                builder.f1752g = configurationModel.m2406p();
                builder.f1753h = configurationModel.m2407q();
                builder.f1754i = configurationModel.m2408r();
                return builder;
            }

            public final Builder m2392a(@Nullable String str) {
                this.f1751f = str;
                return this;
            }

            public final ConfigurationModel m2393a() {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                int a = ModelHelper.a(flatBufferBuilder, this.f1746a);
                int b = flatBufferBuilder.b(this.f1748c);
                int b2 = flatBufferBuilder.b(this.f1750e);
                int b3 = flatBufferBuilder.b(this.f1751f);
                int b4 = flatBufferBuilder.b(this.f1752g);
                int a2 = ModelHelper.a(flatBufferBuilder, this.f1753h);
                flatBufferBuilder.c(9);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.a(1, this.f1747b);
                flatBufferBuilder.b(2, b);
                flatBufferBuilder.a(3, this.f1749d);
                flatBufferBuilder.b(4, b2);
                flatBufferBuilder.b(5, b3);
                flatBufferBuilder.b(6, b4);
                flatBufferBuilder.b(7, a2);
                flatBufferBuilder.a(8, this.f1754i, 0);
                flatBufferBuilder.d(flatBufferBuilder.d());
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                return new ConfigurationModel(new MutableFlatBuffer(wrap, null, null, true, null));
            }
        }

        /* compiled from: topic_vote_dialog */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(ConfigurationModel.class, new Deserializer());
            }

            public Object m2394a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(ConfigurationParser.m2447a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object configurationModel = new ConfigurationModel();
                ((BaseModel) configurationModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (configurationModel instanceof Postprocessable) {
                    return ((Postprocessable) configurationModel).a();
                }
                return configurationModel;
            }
        }

        /* compiled from: topic_vote_dialog */
        public class Serializer extends JsonSerializer<ConfigurationModel> {
            public final void m2395a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                ConfigurationModel configurationModel = (ConfigurationModel) obj;
                if (configurationModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(configurationModel.m2396a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    configurationModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                ConfigurationParser.m2448a(configurationModel.w_(), configurationModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(ConfigurationModel.class, new Serializer());
            }
        }

        @Nullable
        public final /* synthetic */ ConfigurationParameterSetsConnectionModel m2397a() {
            return m2400j();
        }

        @Nullable
        public final /* synthetic */ ConfigurationParameterSetsConnectionModel l_() {
            return m2407q();
        }

        public ConfigurationModel() {
            super(9);
        }

        public ConfigurationModel(MutableFlatBuffer mutableFlatBuffer) {
            super(9);
            a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
        }

        @Nullable
        public final ConfigurationParameterSetsConnectionModel m2400j() {
            this.f1755d = (ConfigurationParameterSetsConnectionModel) super.a(this.f1755d, 0, ConfigurationParameterSetsConnectionModel.class);
            return this.f1755d;
        }

        public final boolean m2401k() {
            a(0, 1);
            return this.f1756e;
        }

        @Nullable
        public final String m2402l() {
            this.f1757f = super.a(this.f1757f, 2);
            return this.f1757f;
        }

        public final boolean m2403m() {
            a(0, 3);
            return this.f1758g;
        }

        @Nullable
        public final String m2404n() {
            this.f1759h = super.a(this.f1759h, 4);
            return this.f1759h;
        }

        @Nullable
        public final String m2405o() {
            this.f1760i = super.a(this.f1760i, 5);
            return this.f1760i;
        }

        @Nullable
        public final String m2406p() {
            this.f1761j = super.a(this.f1761j, 6);
            return this.f1761j;
        }

        @Nullable
        public final ConfigurationParameterSetsConnectionModel m2407q() {
            this.f1762k = (ConfigurationParameterSetsConnectionModel) super.a(this.f1762k, 7, ConfigurationParameterSetsConnectionModel.class);
            return this.f1762k;
        }

        public final int m2408r() {
            a(1, 0);
            return this.f1763l;
        }

        public final int jK_() {
            return -1563253546;
        }

        public final GraphQLVisitableModel m2398a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            ConfigurationParameterSetsConnectionModel configurationParameterSetsConnectionModel;
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m2400j() != null) {
                configurationParameterSetsConnectionModel = (ConfigurationParameterSetsConnectionModel) graphQLModelMutatingVisitor.b(m2400j());
                if (m2400j() != configurationParameterSetsConnectionModel) {
                    graphQLVisitableModel = (ConfigurationModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f1755d = configurationParameterSetsConnectionModel;
                }
            }
            if (m2407q() != null) {
                configurationParameterSetsConnectionModel = (ConfigurationParameterSetsConnectionModel) graphQLModelMutatingVisitor.b(m2407q());
                if (m2407q() != configurationParameterSetsConnectionModel) {
                    graphQLVisitableModel = (ConfigurationModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f1762k = configurationParameterSetsConnectionModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m2396a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m2400j());
            int b = flatBufferBuilder.b(m2402l());
            int b2 = flatBufferBuilder.b(m2404n());
            int b3 = flatBufferBuilder.b(m2405o());
            int b4 = flatBufferBuilder.b(m2406p());
            int a2 = ModelHelper.a(flatBufferBuilder, m2407q());
            flatBufferBuilder.c(9);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.a(1, this.f1756e);
            flatBufferBuilder.b(2, b);
            flatBufferBuilder.a(3, this.f1758g);
            flatBufferBuilder.b(4, b2);
            flatBufferBuilder.b(5, b3);
            flatBufferBuilder.b(6, b4);
            flatBufferBuilder.b(7, a2);
            flatBufferBuilder.a(8, this.f1763l, 0);
            i();
            return flatBufferBuilder.d();
        }

        public final void m2399a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
            super.a(mutableFlatBuffer, i, obj);
            this.f1756e = mutableFlatBuffer.a(i, 1);
            this.f1758g = mutableFlatBuffer.a(i, 3);
            this.f1763l = mutableFlatBuffer.a(i, 8, 0);
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 1157296639)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: topic_vote_dialog */
    public final class ConfigurationParameterSetModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private String f1764d;
        @Nullable
        private String f1765e;
        @Nullable
        private List<QueryStringConfigurationParameterModel> f1766f;

        /* compiled from: topic_vote_dialog */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(ConfigurationParameterSetModel.class, new Deserializer());
            }

            public Object m2409a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(ConfigurationParameterSetParser.m2442a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object configurationParameterSetModel = new ConfigurationParameterSetModel();
                ((BaseModel) configurationParameterSetModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (configurationParameterSetModel instanceof Postprocessable) {
                    return ((Postprocessable) configurationParameterSetModel).a();
                }
                return configurationParameterSetModel;
            }
        }

        /* compiled from: topic_vote_dialog */
        public class Serializer extends JsonSerializer<ConfigurationParameterSetModel> {
            public final void m2410a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                ConfigurationParameterSetModel configurationParameterSetModel = (ConfigurationParameterSetModel) obj;
                if (configurationParameterSetModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(configurationParameterSetModel.m2412a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    configurationParameterSetModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                zza.m12851a(configurationParameterSetModel.w_(), configurationParameterSetModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(ConfigurationParameterSetModel.class, new Serializer());
            }
        }

        public ConfigurationParameterSetModel() {
            super(3);
        }

        @Nullable
        private String m2411j() {
            this.f1764d = super.a(this.f1764d, 0);
            return this.f1764d;
        }

        @Nullable
        public final String m2414a() {
            this.f1765e = super.a(this.f1765e, 1);
            return this.f1765e;
        }

        @Nonnull
        public final ImmutableList<QueryStringConfigurationParameterModel> m_() {
            this.f1766f = super.a(this.f1766f, 2, QueryStringConfigurationParameterModel.class);
            return (ImmutableList) this.f1766f;
        }

        public final int jK_() {
            return -138548241;
        }

        public final GraphQLVisitableModel m2413a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m_() != null) {
                Builder a = ModelHelper.a(m_(), graphQLModelMutatingVisitor);
                if (a != null) {
                    graphQLVisitableModel = (ConfigurationParameterSetModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f1766f = a.b();
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m2412a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(m2411j());
            int b2 = flatBufferBuilder.b(m2414a());
            int a = ModelHelper.a(flatBufferBuilder, m_());
            flatBufferBuilder.c(3);
            flatBufferBuilder.b(0, b);
            flatBufferBuilder.b(1, b2);
            flatBufferBuilder.b(2, a);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 8427395)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: topic_vote_dialog */
    public final class ConfigurationParameterSetsConnectionModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private List<EdgesModel> f1768d;

        /* compiled from: topic_vote_dialog */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(ConfigurationParameterSetsConnectionModel.class, new Deserializer());
            }

            public Object m2415a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(ConfigurationParameterSetsConnectionParser.m2445a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object configurationParameterSetsConnectionModel = new ConfigurationParameterSetsConnectionModel();
                ((BaseModel) configurationParameterSetsConnectionModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (configurationParameterSetsConnectionModel instanceof Postprocessable) {
                    return ((Postprocessable) configurationParameterSetsConnectionModel).a();
                }
                return configurationParameterSetsConnectionModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 1929566136)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: topic_vote_dialog */
        public final class EdgesModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private ConfigurationParameterSetModel f1767d;

            /* compiled from: topic_vote_dialog */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(EdgesModel.class, new Deserializer());
                }

                public Object m2416a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(EdgesParser.m2443b(jsonParser, flatBufferBuilder));
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

            /* compiled from: topic_vote_dialog */
            public class Serializer extends JsonSerializer<EdgesModel> {
                public final void m2417a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    EdgesModel edgesModel = (EdgesModel) obj;
                    if (edgesModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(edgesModel.m2419a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        edgesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    EdgesParser.m2444b(edgesModel.w_(), edgesModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(EdgesModel.class, new Serializer());
                }
            }

            @Nullable
            public final /* synthetic */ ConfigurationParameterSetModel m2420a() {
                return m2418j();
            }

            public EdgesModel() {
                super(1);
            }

            @Nullable
            private ConfigurationParameterSetModel m2418j() {
                this.f1767d = (ConfigurationParameterSetModel) super.a(this.f1767d, 0, ConfigurationParameterSetModel.class);
                return this.f1767d;
            }

            public final int jK_() {
                return -142040511;
            }

            public final GraphQLVisitableModel m2421a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m2418j() != null) {
                    ConfigurationParameterSetModel configurationParameterSetModel = (ConfigurationParameterSetModel) graphQLModelMutatingVisitor.b(m2418j());
                    if (m2418j() != configurationParameterSetModel) {
                        graphQLVisitableModel = (EdgesModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f1767d = configurationParameterSetModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m2419a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m2418j());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, a);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: topic_vote_dialog */
        public class Serializer extends JsonSerializer<ConfigurationParameterSetsConnectionModel> {
            public final void m2422a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                ConfigurationParameterSetsConnectionModel configurationParameterSetsConnectionModel = (ConfigurationParameterSetsConnectionModel) obj;
                if (configurationParameterSetsConnectionModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(configurationParameterSetsConnectionModel.m2423a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    configurationParameterSetsConnectionModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                ConfigurationParameterSetsConnectionParser.m2446a(configurationParameterSetsConnectionModel.w_(), configurationParameterSetsConnectionModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(ConfigurationParameterSetsConnectionModel.class, new Serializer());
            }
        }

        public ConfigurationParameterSetsConnectionModel() {
            super(1);
        }

        @Nonnull
        public final ImmutableList<EdgesModel> m2425a() {
            this.f1768d = super.a(this.f1768d, 0, EdgesModel.class);
            return (ImmutableList) this.f1768d;
        }

        public final int jK_() {
            return 756891746;
        }

        public final GraphQLVisitableModel m2424a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m2425a() != null) {
                Builder a = ModelHelper.a(m2425a(), graphQLModelMutatingVisitor);
                if (a != null) {
                    graphQLVisitableModel = (ConfigurationParameterSetsConnectionModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f1768d = a.b();
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m2423a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m2425a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -1527609873)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: topic_vote_dialog */
    public final class QueryStringConfigurationParameterModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private String f1769d;
        @Nullable
        private String f1770e;

        /* compiled from: topic_vote_dialog */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(QueryStringConfigurationParameterModel.class, new Deserializer());
            }

            public Object m2426a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(QueryStringConfigurationParameterParser.m2449b(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object queryStringConfigurationParameterModel = new QueryStringConfigurationParameterModel();
                ((BaseModel) queryStringConfigurationParameterModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (queryStringConfigurationParameterModel instanceof Postprocessable) {
                    return ((Postprocessable) queryStringConfigurationParameterModel).a();
                }
                return queryStringConfigurationParameterModel;
            }
        }

        /* compiled from: topic_vote_dialog */
        public class Serializer extends JsonSerializer<QueryStringConfigurationParameterModel> {
            public final void m2427a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                QueryStringConfigurationParameterModel queryStringConfigurationParameterModel = (QueryStringConfigurationParameterModel) obj;
                if (queryStringConfigurationParameterModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(queryStringConfigurationParameterModel.m2428a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    queryStringConfigurationParameterModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                zza.m12850a(queryStringConfigurationParameterModel.w_(), queryStringConfigurationParameterModel.u_(), jsonGenerator);
            }

            static {
                FbSerializerProvider.a(QueryStringConfigurationParameterModel.class, new Serializer());
            }
        }

        public QueryStringConfigurationParameterModel() {
            super(2);
        }

        @Nullable
        public final String m2430a() {
            this.f1769d = super.a(this.f1769d, 0);
            return this.f1769d;
        }

        @Nullable
        public final String n_() {
            this.f1770e = super.a(this.f1770e, 1);
            return this.f1770e;
        }

        public final int jK_() {
            return -789389084;
        }

        public final GraphQLVisitableModel m2429a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            h();
            i();
            return this;
        }

        public final int m2428a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(m2430a());
            int b2 = flatBufferBuilder.b(n_());
            flatBufferBuilder.c(2);
            flatBufferBuilder.b(0, b);
            flatBufferBuilder.b(1, b2);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 1753472597)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: topic_vote_dialog */
    public final class ViewerConfigsModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private ConfigsModel f1772d;

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -2111268638)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: topic_vote_dialog */
        public final class ConfigsModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private List<ConfigurationEdgeModel> f1771d;

            /* compiled from: topic_vote_dialog */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(ConfigsModel.class, new Deserializer());
                }

                public Object m2431a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(ConfigsParser.m2450a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object configsModel = new ConfigsModel();
                    ((BaseModel) configsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (configsModel instanceof Postprocessable) {
                        return ((Postprocessable) configsModel).a();
                    }
                    return configsModel;
                }
            }

            /* compiled from: topic_vote_dialog */
            public class Serializer extends JsonSerializer<ConfigsModel> {
                public final void m2432a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    ConfigsModel configsModel = (ConfigsModel) obj;
                    if (configsModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(configsModel.m2433a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        configsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    ConfigsParser.m2451a(configsModel.w_(), configsModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(ConfigsModel.class, new Serializer());
                }
            }

            public ConfigsModel() {
                super(1);
            }

            @Nonnull
            public final ImmutableList<ConfigurationEdgeModel> m2435a() {
                this.f1771d = super.a(this.f1771d, 0, ConfigurationEdgeModel.class);
                return (ImmutableList) this.f1771d;
            }

            public final int jK_() {
                return -1730221747;
            }

            public final GraphQLVisitableModel m2434a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m2435a() != null) {
                    Builder a = ModelHelper.a(m2435a(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        graphQLVisitableModel = (ConfigsModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f1771d = a.b();
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m2433a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m2435a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, a);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: topic_vote_dialog */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(ViewerConfigsModel.class, new Deserializer());
            }

            public Object m2436a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = ViewerConfigsParser.m2452a(jsonParser);
                Object viewerConfigsModel = new ViewerConfigsModel();
                ((BaseModel) viewerConfigsModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (viewerConfigsModel instanceof Postprocessable) {
                    return ((Postprocessable) viewerConfigsModel).a();
                }
                return viewerConfigsModel;
            }
        }

        /* compiled from: topic_vote_dialog */
        public class Serializer extends JsonSerializer<ViewerConfigsModel> {
            public final void m2437a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                ViewerConfigsModel viewerConfigsModel = (ViewerConfigsModel) obj;
                if (viewerConfigsModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(viewerConfigsModel.m2439a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    viewerConfigsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = viewerConfigsModel.w_();
                int u_ = viewerConfigsModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("configs");
                    ConfigsParser.m2451a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(ViewerConfigsModel.class, new Serializer());
            }
        }

        public ViewerConfigsModel() {
            super(1);
        }

        @Nullable
        private ConfigsModel m2438a() {
            this.f1772d = (ConfigsModel) super.a(this.f1772d, 0, ConfigsModel.class);
            return this.f1772d;
        }

        public final int jK_() {
            return -1732764110;
        }

        public final GraphQLVisitableModel m2440a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m2438a() != null) {
                ConfigsModel configsModel = (ConfigsModel) graphQLModelMutatingVisitor.b(m2438a());
                if (m2438a() != configsModel) {
                    graphQLVisitableModel = (ViewerConfigsModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f1772d = configsModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m2439a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m2438a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }
}
