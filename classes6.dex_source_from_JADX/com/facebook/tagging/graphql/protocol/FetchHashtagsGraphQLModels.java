package com.facebook.tagging.graphql.protocol;

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
import com.facebook.graphql.visitor.GraphQLPersistableNode;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.facebook.tagging.graphql.protocol.FetchHashtagsGraphQLParsers.FetchHashtagsQueryParser;
import com.facebook.tagging.graphql.protocol.FetchHashtagsGraphQLParsers.FetchHashtagsQueryParser.SuggestedHashtagsParser;
import com.facebook.tagging.graphql.protocol.FetchHashtagsGraphQLParsers.FetchHashtagsQueryParser.SuggestedHashtagsParser.NodesParser;
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

/* compiled from: departure_airport */
public class FetchHashtagsGraphQLModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -145364540)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: departure_airport */
    public final class FetchHashtagsQueryModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private SuggestedHashtagsModel f17486d;

        /* compiled from: departure_airport */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(FetchHashtagsQueryModel.class, new Deserializer());
            }

            public Object m25344a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = FetchHashtagsQueryParser.m25366a(jsonParser);
                Object fetchHashtagsQueryModel = new FetchHashtagsQueryModel();
                ((BaseModel) fetchHashtagsQueryModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (fetchHashtagsQueryModel instanceof Postprocessable) {
                    return ((Postprocessable) fetchHashtagsQueryModel).a();
                }
                return fetchHashtagsQueryModel;
            }
        }

        /* compiled from: departure_airport */
        public class Serializer extends JsonSerializer<FetchHashtagsQueryModel> {
            public final void m25345a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                FetchHashtagsQueryModel fetchHashtagsQueryModel = (FetchHashtagsQueryModel) obj;
                if (fetchHashtagsQueryModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(fetchHashtagsQueryModel.m25360a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    fetchHashtagsQueryModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = fetchHashtagsQueryModel.w_();
                int u_ = fetchHashtagsQueryModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("suggested_hashtags");
                    SuggestedHashtagsParser.m25365a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(FetchHashtagsQueryModel.class, new Serializer());
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -617261514)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: departure_airport */
        public final class SuggestedHashtagsModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private List<NodesModel> f17485d;

            /* compiled from: departure_airport */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(SuggestedHashtagsModel.class, new Deserializer());
                }

                public Object m25346a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(SuggestedHashtagsParser.m25364a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object suggestedHashtagsModel = new SuggestedHashtagsModel();
                    ((BaseModel) suggestedHashtagsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (suggestedHashtagsModel instanceof Postprocessable) {
                        return ((Postprocessable) suggestedHashtagsModel).a();
                    }
                    return suggestedHashtagsModel;
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = 415735059)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: departure_airport */
            public final class NodesModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel {
                @Nullable
                private String f17482d;
                @Nullable
                private String f17483e;
                @Nullable
                private String f17484f;

                /* compiled from: departure_airport */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(NodesModel.class, new Deserializer());
                    }

                    public Object m25347a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(NodesParser.m25363b(jsonParser, flatBufferBuilder));
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

                /* compiled from: departure_airport */
                public class Serializer extends JsonSerializer<NodesModel> {
                    public final void m25348a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        NodesModel nodesModel = (NodesModel) obj;
                        if (nodesModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(nodesModel.m25352a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            nodesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        NodesParser.m25362a(nodesModel.w_(), nodesModel.u_(), jsonGenerator);
                    }

                    static {
                        FbSerializerProvider.a(NodesModel.class, new Serializer());
                    }
                }

                public NodesModel() {
                    super(3);
                }

                @Nullable
                private String m25349j() {
                    this.f17482d = super.a(this.f17482d, 0);
                    return this.f17482d;
                }

                @Nullable
                private String m25350k() {
                    this.f17483e = super.a(this.f17483e, 1);
                    return this.f17483e;
                }

                @Nullable
                private String m25351l() {
                    this.f17484f = super.a(this.f17484f, 2);
                    return this.f17484f;
                }

                @Nullable
                public final String m25354a() {
                    return m25349j();
                }

                public final int jK_() {
                    return -1932766292;
                }

                public final GraphQLVisitableModel m25353a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    h();
                    i();
                    return this;
                }

                public final int m25352a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int b = flatBufferBuilder.b(m25349j());
                    int b2 = flatBufferBuilder.b(m25350k());
                    int b3 = flatBufferBuilder.b(m25351l());
                    flatBufferBuilder.c(3);
                    flatBufferBuilder.b(0, b);
                    flatBufferBuilder.b(1, b2);
                    flatBufferBuilder.b(2, b3);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            /* compiled from: departure_airport */
            public class Serializer extends JsonSerializer<SuggestedHashtagsModel> {
                public final void m25355a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    SuggestedHashtagsModel suggestedHashtagsModel = (SuggestedHashtagsModel) obj;
                    if (suggestedHashtagsModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(suggestedHashtagsModel.m25357a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        suggestedHashtagsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    SuggestedHashtagsParser.m25365a(suggestedHashtagsModel.w_(), suggestedHashtagsModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(SuggestedHashtagsModel.class, new Serializer());
                }
            }

            public SuggestedHashtagsModel() {
                super(1);
            }

            @Nonnull
            private ImmutableList<NodesModel> m25356a() {
                this.f17485d = super.a(this.f17485d, 0, NodesModel.class);
                return (ImmutableList) this.f17485d;
            }

            public final int jK_() {
                return -821706552;
            }

            public final GraphQLVisitableModel m25358a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m25356a() != null) {
                    Builder a = ModelHelper.a(m25356a(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        graphQLVisitableModel = (SuggestedHashtagsModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f17485d = a.b();
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m25357a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m25356a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, a);
                i();
                return flatBufferBuilder.d();
            }
        }

        public FetchHashtagsQueryModel() {
            super(1);
        }

        @Nullable
        private SuggestedHashtagsModel m25359a() {
            this.f17486d = (SuggestedHashtagsModel) super.a(this.f17486d, 0, SuggestedHashtagsModel.class);
            return this.f17486d;
        }

        public final int jK_() {
            return -1732764110;
        }

        public final GraphQLVisitableModel m25361a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m25359a() != null) {
                SuggestedHashtagsModel suggestedHashtagsModel = (SuggestedHashtagsModel) graphQLModelMutatingVisitor.b(m25359a());
                if (m25359a() != suggestedHashtagsModel) {
                    graphQLVisitableModel = (FetchHashtagsQueryModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f17486d = suggestedHashtagsModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m25360a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m25359a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }
}
